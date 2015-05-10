package org.whitehole.assembly.ia32_x64.control;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.whitehole.assembly.ia32_x64.dis.Disassembler;
import org.whitehole.assembly.ia32_x64.dom.Immediate;
import org.whitehole.assembly.ia32_x64.dom.Instruction;
import org.whitehole.assembly.ia32_x64.dom.InstructionBuffer;
import org.whitehole.assembly.ia32_x64.dom.Mnemonic;
import org.whitehole.assembly.ia32_x64.dom.Operand;

public class CallGraphExplorer {

	static private TreeSet<Long> gatherCalledFunctions(ControlFlowGraph cfg) {
		final TreeSet<Long> calledFunctions = new TreeSet<Long>();
		for (final BasicBlock bb : cfg.getBasicBlocks())
			for (final Entry<Long, Instruction> e : bb) {
				final long p = e.getKey();
				final Instruction i = e.getValue();

				if (i.getMnemonic() == Mnemonic.CALL) {

					if (i.getOperands().length == 1) {
						final Operand o = i.getOperands()[0];
						if (o instanceof Immediate) {

							final Immediate imm = (Immediate) o;
							final long addr = p + 5 /* = length of call imm */+ imm.getSignedInteger().intValue() /* FIXME: sign-extended long */;
							calledFunctions.add(addr);
						}
					}
				}
			}
		return calledFunctions;
	}

	static private void explore(Disassembler d, ByteBuffer buffer, long offset, Map<Long, ControlFlowGraph> offsetToGraph, boolean keepCFG) throws InterruptedException, ExecutionException {

		final ExecutorService pool = Executors.newFixedThreadPool(4);
		final ExecutorCompletionService<ControlFlowGraph> x = new ExecutorCompletionService<ControlFlowGraph>(pool);

		int pending = 0;

		offsetToGraph.put(offset, null);
		x.submit(() -> {
			return ControlFlowGraphBuilder.build(new InstructionBuffer(d, buffer), offset);
		});
		++pending;

		while (0 < pending) {
			final Future<ControlFlowGraph> f = x.take();
			final ControlFlowGraph g = f.get();
			offsetToGraph.put(g.getBasicBlock(g.getEntryVertex()).getEntryPoint(), keepCFG ? g : null);
			--pending;

			for (final long o : gatherCalledFunctions(g)) {
				if (!offsetToGraph.containsKey(o)) {

					offsetToGraph.put(o, null);
					x.submit(() -> {
						return ControlFlowGraphBuilder.build(new InstructionBuffer(d, buffer), o);
					});
					++pending;
				}
			}
		}

		pool.shutdown();
	}

	static public void explore(Disassembler d, ByteBuffer buffer, long offset, Map<Long, ControlFlowGraph> offsetToGraph) throws InterruptedException, ExecutionException {
		explore(d, buffer, offset, offsetToGraph, true);
	}

	static public void explore(Disassembler d, ByteBuffer buffer, long offset, Set<Long> entryPoints) throws InterruptedException, ExecutionException {
		final HashMap<Long, ControlFlowGraph> x = new HashMap<Long, ControlFlowGraph>();
		explore(d, buffer, offset, x, false);
		entryPoints.addAll(x.keySet());
	}
}
