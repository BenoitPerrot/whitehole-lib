// Generated, do not edit by hand
package org.whitehole.assembly.ia32_x64.dis;
import java.io.IOException;
import java.io.InputStream;
import org.whitehole.assembly.ia32_x64.dom.OperandType;
import org.whitehole.assembly.ia32_x64.dom.Mnemonic;

 class InstructionDecoder {
    static void one_byte(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        switch (c) {
            case 0x00: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                    OperandDecoder.ES(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x07: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.POP);
                    OperandDecoder.ES(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x08: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x09: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x0a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x0b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x0c: {
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x0d: {
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x0e: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                    OperandDecoder.CS(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0f: {
                two_byte(m, p, i, l);
                break;
            }
            case 0x10: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x11: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x12: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x13: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x14: {
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x15: {
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x16: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                    OperandDecoder.SS(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x17: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.POP);
                    OperandDecoder.SS(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x18: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x19: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x1a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x1c: {
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1d: {
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x1e: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                    OperandDecoder.DS(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x1f: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.POP);
                    OperandDecoder.DS(l);
                    l.endInstruction();
                }
                break;
            }
            case 0x20: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x21: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x22: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x23: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x24: {
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x25: {
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x27: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DAA);
                    l.endInstruction();
                }
                break;
            }
            case 0x28: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x29: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x2a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x2b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x2c: {
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x2d: {
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x2f: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DAS);
                    l.endInstruction();
                }
                break;
            }
            case 0x30: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x31: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x32: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x33: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x34: {
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x35: {
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x37: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.AAA);
                    l.endInstruction();
                }
                break;
            }
            case 0x38: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x39: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x3a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x3b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x3c: {
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x3d: {
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x3f: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.AAS);
                    l.endInstruction();
                }
                break;
            }
            case 0x40: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eAX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x41: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eCX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x42: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eDX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x43: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eBX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x44: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eSP(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x45: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eBP(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x46: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eSI(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x47: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INC);
                    OperandDecoder.eDI(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x48: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eAX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x49: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eCX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4a: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eDX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4b: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eBX(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4c: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eSP(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4d: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eBP(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4e: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eSI(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4f: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.DEC);
                    OperandDecoder.eDI(m, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x50: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rAXr8(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x51: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rCXr9(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x52: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rDXr10(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x53: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rBXr11(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x54: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rSPr12(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x55: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rBPr13(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x56: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rSIr14(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x57: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.rDIr15(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x58: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rAXr8(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x59: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rCXr9(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x5a: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rDXr10(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x5b: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rBXr11(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x5c: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rSPr12(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x5d: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rBPr13(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x5e: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rSIr14(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x5f: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.rDIr15(Mode.d64(m), p, l);
                l.endInstruction();
                break;
            }
            case 0x60: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.PUSHA);
                    l.endInstruction();
                }
                break;
            }
            case 0x61: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.POPA);
                    l.endInstruction();
                }
                break;
            }
            case 0x62: {
                if (!m.is64BIT()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BOUND);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.a(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x63: {
                if (!m.is64BIT()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.ARPL);
                    OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                    OperandDecoder.G(m, p, mrm, OperandType.WORD, l);
                    l.endInstruction();
                }
                else if (m.is64BIT()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVSXD);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x68: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x69: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.IMUL);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x6a: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x6b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.IMUL);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x6c: {
                l.startInstruction(p.toModifier(), Mnemonic.INSB);
                OperandDecoder.DX(l);
                OperandDecoder.Y(OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x6d: {
                l.startInstruction(p.toModifier(), Mnemonic.INSW);
                OperandDecoder.DX(l);
                OperandDecoder.Y(OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x6e: {
                l.startInstruction(p.toModifier(), Mnemonic.OUTSB);
                OperandDecoder.X(OperandType.BYTE, l);
                OperandDecoder.DX(l);
                l.endInstruction();
                break;
            }
            case 0x6f: {
                l.startInstruction(p.toModifier(), Mnemonic.OUTSW);
                OperandDecoder.X(OperandDecoder.z(m.getOperandSize()), l);
                OperandDecoder.DX(l);
                l.endInstruction();
                break;
            }
            case 0x70: {
                l.startInstruction(p.toModifier(), Mnemonic.JO);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x71: {
                l.startInstruction(p.toModifier(), Mnemonic.JNO);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x72: {
                l.startInstruction(p.toModifier(), Mnemonic.JB);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x73: {
                l.startInstruction(p.toModifier(), Mnemonic.JAE);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x74: {
                l.startInstruction(p.toModifier(), Mnemonic.JZ);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x75: {
                l.startInstruction(p.toModifier(), Mnemonic.JNZ);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x76: {
                l.startInstruction(p.toModifier(), Mnemonic.JBE);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x77: {
                l.startInstruction(p.toModifier(), Mnemonic.JA);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x78: {
                l.startInstruction(p.toModifier(), Mnemonic.JS);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x79: {
                l.startInstruction(p.toModifier(), Mnemonic.JNS);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x7a: {
                l.startInstruction(p.toModifier(), Mnemonic.JP);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x7b: {
                l.startInstruction(p.toModifier(), Mnemonic.JNP);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x7c: {
                l.startInstruction(p.toModifier(), Mnemonic.JL);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x7d: {
                l.startInstruction(p.toModifier(), Mnemonic.JGE);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x7e: {
                l.startInstruction(p.toModifier(), Mnemonic.JLE);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x7f: {
                l.startInstruction(p.toModifier(), Mnemonic.JG);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x80: {
                final ModRM mrm = ModRM.read(i);
                immediate_group_1_0x80(m, p, mrm, i, l);
                break;
            }
            case 0x81: {
                final ModRM mrm = ModRM.read(i);
                immediate_group_1_0x81(m, p, mrm, i, l);
                break;
            }
            case 0x82: {
                final ModRM mrm = ModRM.read(i);
                immediate_group_1_0x82(m, p, mrm, i, l);
                break;
            }
            case 0x83: {
                final ModRM mrm = ModRM.read(i);
                immediate_group_1_0x83(m, p, mrm, i, l);
                break;
            }
            case 0x84: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.TEST);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x85: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.TEST);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x86: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x87: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x88: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x89: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x8b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8c: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.Sw(mrm, l);
                l.endInstruction();
                break;
            }
            case 0x8d: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.LEA);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x8e: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.Sw(mrm, l);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x8f: {
                final ModRM mrm = ModRM.read(i);
                group_1A(m, p, mrm, i, l);
                break;
            }
            case 0x90: {
                if (p.hasF3()) {
                    l.startInstruction(p.toModifier(), Mnemonic.PAUSE);
                    l.endInstruction();
                }
                else {
                    l.startInstruction(p.toModifier(), Mnemonic.NOP);
                    l.endInstruction();
                }
                break;
            }
            case 0x91: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rCXr9(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x92: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rDXr10(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x93: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rBXr11(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x94: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rSPr12(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x95: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rBPr13(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x96: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rSIr14(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x97: {
                l.startInstruction(p.toModifier(), Mnemonic.XCHG);
                OperandDecoder.rDIr15(m, p, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0x98: {
                l.startInstruction(p.toModifier(), Mnemonic.CBW);
                l.endInstruction();
                break;
            }
            case 0x99: {
                l.startInstruction(p.toModifier(), Mnemonic.CWD);
                l.endInstruction();
                break;
            }
            case 0x9a: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.CALL);
                    OperandDecoder.Ap(m, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9b: {
                l.startInstruction(p.toModifier(), Mnemonic.WAIT);
                l.endInstruction();
                break;
            }
            case 0x9c: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSHFW);
                OperandDecoder.Fv(Mode.d64(m), l);
                l.endInstruction();
                break;
            }
            case 0x9d: {
                l.startInstruction(p.toModifier(), Mnemonic.POPFW);
                OperandDecoder.Fv(Mode.d64(m), l);
                l.endInstruction();
                break;
            }
            case 0x9e: {
                l.startInstruction(p.toModifier(), Mnemonic.SAHF);
                l.endInstruction();
                break;
            }
            case 0x9f: {
                l.startInstruction(p.toModifier(), Mnemonic.LAHF);
                l.endInstruction();
                break;
            }
            case 0xa0: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.AL(l);
                OperandDecoder.Ob(m, i, l);
                l.endInstruction();
                break;
            }
            case 0xa1: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rAX(m, l);
                OperandDecoder.Ov(m, i, l);
                l.endInstruction();
                break;
            }
            case 0xa2: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.Ob(m, i, l);
                OperandDecoder.AL(l);
                l.endInstruction();
                break;
            }
            case 0xa3: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.Ov(m, i, l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0xa4: {
                l.startInstruction(p.toModifier(), Mnemonic.MOVSB);
                OperandDecoder.Y(OperandType.BYTE, l);
                OperandDecoder.X(OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xa5: {
                l.startInstruction(p.toModifier(), Mnemonic.MOVSW);
                OperandDecoder.Y(OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.X(OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xa6: {
                l.startInstruction(p.toModifier(), Mnemonic.CMPSB);
                OperandDecoder.Y(OperandType.BYTE, l);
                OperandDecoder.X(OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xa7: {
                l.startInstruction(p.toModifier(), Mnemonic.CMPSW);
                OperandDecoder.Y(OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.X(OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xa8: {
                l.startInstruction(p.toModifier(), Mnemonic.TEST);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xa9: {
                l.startInstruction(p.toModifier(), Mnemonic.TEST);
                OperandDecoder.rAX(m, l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xaa: {
                l.startInstruction(p.toModifier(), Mnemonic.STOSB);
                OperandDecoder.Y(OperandType.BYTE, l);
                OperandDecoder.AL(l);
                l.endInstruction();
                break;
            }
            case 0xab: {
                l.startInstruction(p.toModifier(), Mnemonic.STOSW);
                OperandDecoder.Y(OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.rAX(m, l);
                l.endInstruction();
                break;
            }
            case 0xac: {
                l.startInstruction(p.toModifier(), Mnemonic.LODSB);
                OperandDecoder.AL(l);
                OperandDecoder.X(OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xad: {
                l.startInstruction(p.toModifier(), Mnemonic.LODSW);
                OperandDecoder.rAX(m, l);
                OperandDecoder.X(OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xae: {
                l.startInstruction(p.toModifier(), Mnemonic.SCASB);
                OperandDecoder.AL(l);
                OperandDecoder.Y(OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xaf: {
                l.startInstruction(p.toModifier(), Mnemonic.SCASW);
                OperandDecoder.rAX(m, l);
                OperandDecoder.X(OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb0: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.ALr8b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb1: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.CLr9b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb2: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.DLr10b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb3: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.BLr11b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb4: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.AHr12b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb5: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.CHr13b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb6: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.DHr14b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb7: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.BHr15b(m, p, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb8: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rAXr8(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb9: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rCXr9(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xba: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rDXr10(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xbb: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rBXr11(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xbc: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rSPr12(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xbd: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rBPr13(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xbe: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rSIr14(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xbf: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.rDIr15(m, p, l);
                OperandDecoder.I(i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xc0: {
                final ModRM mrm = ModRM.read(i);
                shift_group_2_0xc0(m, p, mrm, i, l);
                break;
            }
            case 0xc1: {
                final ModRM mrm = ModRM.read(i);
                shift_group_2_0xc1(m, p, mrm, i, l);
                break;
            }
            case 0xc2: {
                l.startInstruction(p.toModifier(), Mnemonic.RET);
                OperandDecoder.I(i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0xc3: {
                l.startInstruction(p.toModifier(), Mnemonic.RET);
                l.endInstruction();
                break;
            }
            case 0xc4: {
                if (!m.is64BIT()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.LES);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.z(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xc5: {
                if (!m.is64BIT()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.LDS);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.z(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xc6: {
                final ModRM mrm = ModRM.read(i);
                group_11_0xc6(m, p, mrm, i, l);
                break;
            }
            case 0xc7: {
                final ModRM mrm = ModRM.read(i);
                group_11_0xc7(m, p, mrm, i, l);
                break;
            }
            case 0xc8: {
                l.startInstruction(p.toModifier(), Mnemonic.ENTER);
                OperandDecoder.I(i, OperandType.WORD, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xc9: {
                l.startInstruction(p.toModifier(), Mnemonic.LEAVE);
                l.endInstruction();
                break;
            }
            case 0xca: {
                l.startInstruction(p.toModifier(), Mnemonic.RETF);
                OperandDecoder.I(i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0xcb: {
                l.startInstruction(p.toModifier(), Mnemonic.RETF);
                l.endInstruction();
                break;
            }
            case 0xcc: {
                l.startInstruction(p.toModifier(), Mnemonic.INT3);
                l.endInstruction();
                break;
            }
            case 0xcd: {
                l.startInstruction(p.toModifier(), Mnemonic.INT);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xce: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.INTO);
                    l.endInstruction();
                }
                break;
            }
            case 0xcf: {
                l.startInstruction(p.toModifier(), Mnemonic.IRETW);
                l.endInstruction();
                break;
            }
            case 0xd0: {
                final ModRM mrm = ModRM.read(i);
                shift_group_2_0xd0(m, p, mrm, i, l);
                break;
            }
            case 0xd1: {
                final ModRM mrm = ModRM.read(i);
                shift_group_2_0xd1(m, p, mrm, i, l);
                break;
            }
            case 0xd2: {
                final ModRM mrm = ModRM.read(i);
                shift_group_2_0xd2(m, p, mrm, i, l);
                break;
            }
            case 0xd3: {
                final ModRM mrm = ModRM.read(i);
                shift_group_2_0xd3(m, p, mrm, i, l);
                break;
            }
            case 0xd4: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.AAM);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd5: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.AAD);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd6: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.SALC);
                    l.endInstruction();
                }
                break;
            }
            case 0xd7: {
                l.startInstruction(p.toModifier(), Mnemonic.XLATB);
                l.endInstruction();
                break;
            }
            case 0xd8: {
                x87_0xd8(m, p, i, l);
                break;
            }
            case 0xd9: {
                x87_0xd9(m, p, i, l);
                break;
            }
            case 0xda: {
                x87_0xda(m, p, i, l);
                break;
            }
            case 0xdb: {
                x87_0xdb(m, p, i, l);
                break;
            }
            case 0xdc: {
                x87_0xdc(m, p, i, l);
                break;
            }
            case 0xdd: {
                x87_0xdd(m, p, i, l);
                break;
            }
            case 0xde: {
                x87_0xde(m, p, i, l);
                break;
            }
            case 0xdf: {
                x87_0xdf(m, p, i, l);
                break;
            }
            case 0xe0: {
                l.startInstruction(p.toModifier(), Mnemonic.LOOPNZ);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xe1: {
                l.startInstruction(p.toModifier(), Mnemonic.LOOPE);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xe2: {
                l.startInstruction(p.toModifier(), Mnemonic.LOOP);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xe3: {
                l.startInstruction(p.toModifier(), Mnemonic.JRCXZ);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xe4: {
                l.startInstruction(p.toModifier(), Mnemonic.IN);
                OperandDecoder.AL(l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xe5: {
                l.startInstruction(p.toModifier(), Mnemonic.IN);
                OperandDecoder.eAX(m, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xe6: {
                l.startInstruction(p.toModifier(), Mnemonic.OUT);
                OperandDecoder.I(i, OperandType.BYTE, l);
                OperandDecoder.AL(l);
                l.endInstruction();
                break;
            }
            case 0xe7: {
                l.startInstruction(p.toModifier(), Mnemonic.OUT);
                OperandDecoder.I(i, OperandType.BYTE, l);
                OperandDecoder.eAX(m, l);
                l.endInstruction();
                break;
            }
            case 0xe8: {
                l.startInstruction(p.toModifier(), Mnemonic.CALL);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xe9: {
                l.startInstruction(p.toModifier(), Mnemonic.JMP);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xea: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.JMP);
                    OperandDecoder.Ap(m, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xeb: {
                l.startInstruction(p.toModifier(), Mnemonic.JMP);
                OperandDecoder.J(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xec: {
                l.startInstruction(p.toModifier(), Mnemonic.IN);
                OperandDecoder.AL(l);
                OperandDecoder.DX(l);
                l.endInstruction();
                break;
            }
            case 0xed: {
                l.startInstruction(p.toModifier(), Mnemonic.IN);
                OperandDecoder.eAX(m, l);
                OperandDecoder.DX(l);
                l.endInstruction();
                break;
            }
            case 0xee: {
                l.startInstruction(p.toModifier(), Mnemonic.OUT);
                OperandDecoder.DX(l);
                OperandDecoder.AL(l);
                l.endInstruction();
                break;
            }
            case 0xef: {
                l.startInstruction(p.toModifier(), Mnemonic.OUT);
                OperandDecoder.DX(l);
                OperandDecoder.eAX(m, l);
                l.endInstruction();
                break;
            }
            case 0xf1: {
                l.startInstruction(p.toModifier(), Mnemonic.INT1);
                l.endInstruction();
                break;
            }
            case 0xf4: {
                l.startInstruction(p.toModifier(), Mnemonic.HLT);
                l.endInstruction();
                break;
            }
            case 0xf5: {
                l.startInstruction(p.toModifier(), Mnemonic.CMC);
                l.endInstruction();
                break;
            }
            case 0xf6: {
                final ModRM mrm = ModRM.read(i);
                unary_group_3_0xf6(m, p, mrm, i, l);
                break;
            }
            case 0xf7: {
                final ModRM mrm = ModRM.read(i);
                unary_group_3_0xf7(m, p, mrm, i, l);
                break;
            }
            case 0xf8: {
                l.startInstruction(p.toModifier(), Mnemonic.CLC);
                l.endInstruction();
                break;
            }
            case 0xf9: {
                l.startInstruction(p.toModifier(), Mnemonic.STC);
                l.endInstruction();
                break;
            }
            case 0xfa: {
                l.startInstruction(p.toModifier(), Mnemonic.CLI);
                l.endInstruction();
                break;
            }
            case 0xfb: {
                l.startInstruction(p.toModifier(), Mnemonic.STI);
                l.endInstruction();
                break;
            }
            case 0xfc: {
                l.startInstruction(p.toModifier(), Mnemonic.CLD);
                l.endInstruction();
                break;
            }
            case 0xfd: {
                l.startInstruction(p.toModifier(), Mnemonic.STD);
                l.endInstruction();
                break;
            }
            case 0xfe: {
                final ModRM mrm = ModRM.read(i);
                group_4(m, p, mrm, i, l);
                break;
            }
            case 0xff: {
                final ModRM mrm = ModRM.read(i);
                group_5(m, p, mrm, i, l);
                break;
            }
            default: {
                l.reportInvalid();
                break;
            }
        }
    }
    
    static void two_byte(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        switch (c) {
            case 0x00: {
                final ModRM mrm = ModRM.read(i);
                group_6(m, p, mrm, i, l);
                break;
            }
            case 0x01: {
                final ModRM mrm = ModRM.read(i);
                group_7(m, p, mrm, i, l);
                break;
            }
            case 0x02: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.LAR);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.LSL);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                if (m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.SYSCALL);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.CLTS);
                l.endInstruction();
                break;
            }
            case 0x07: {
                if (m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.SYSRET);
                    l.endInstruction();
                }
                break;
            }
            case 0x08: {
                l.startInstruction(p.toModifier(), Mnemonic.INVD);
                l.endInstruction();
                break;
            }
            case 0x09: {
                l.startInstruction(p.toModifier(), Mnemonic.WBINVD);
                l.endInstruction();
                break;
            }
            case 0x0b: {
                l.startInstruction(p.toModifier(), Mnemonic.UD2);
                l.endInstruction();
                break;
            }
            case 0x0d: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x0f: {
                amd3DNow(m, p, i, l);
                break;
            }
            case 0x10: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVUPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVSS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVSD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVUPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x11: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVUPD);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVSS);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVSD);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVUPS);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x12: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVLPD);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUADWORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVSLDUP);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVDDUP);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVLPS);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUADWORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x13: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVLPD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVLPS);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x14: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VUNPCKLPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VUNPCKLPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x15: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VUNPCKHPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VUNPCKHPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x16: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVHPD);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUADWORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVSHDUP);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVHPS);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUADWORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x17: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVHPD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVHPS);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x18: {
                final ModRM mrm = ModRM.read(i);
                group_16(m, p, mrm, i, l);
                break;
            }
            case 0x19: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1c: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1d: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1e: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x1f: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.NOP);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x20: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.R(mrm, OperandType.DOUBLEWORD, l);
                OperandDecoder.Cd(m, p, mrm, l);
                l.endInstruction();
                break;
            }
            case 0x21: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.R(mrm, OperandType.DOUBLEWORD, l);
                OperandDecoder.Dd(m, p, mrm, l);
                l.endInstruction();
                break;
            }
            case 0x22: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.Cd(m, p, mrm, l);
                OperandDecoder.R(mrm, OperandType.DOUBLEWORD, l);
                l.endInstruction();
                break;
            }
            case 0x23: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.Dd(m, p, mrm, l);
                OperandDecoder.R(mrm, OperandType.DOUBLEWORD, l);
                l.endInstruction();
                break;
            }
            case 0x28: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVAPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVAPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x29: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVAPD);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVAPS);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CVTPI2PD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTSI2SS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTSI2SD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CVTPI2PS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVNTPD);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVNTPS);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CVTTPD2PI);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTTSS2SI);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTTSD2SI);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CVTTPS2PI);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CVTPD2PI);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTSS2SI);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTSD2SI);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CVTPS2PI);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VUCOMISD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VUCOMISS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCOMISD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCOMISS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x30: {
                l.startInstruction(p.toModifier(), Mnemonic.WRMSR);
                l.endInstruction();
                break;
            }
            case 0x31: {
                l.startInstruction(p.toModifier(), Mnemonic.RDTSC);
                l.endInstruction();
                break;
            }
            case 0x32: {
                l.startInstruction(p.toModifier(), Mnemonic.RDMSR);
                l.endInstruction();
                break;
            }
            case 0x33: {
                l.startInstruction(p.toModifier(), Mnemonic.RDPMC);
                l.endInstruction();
                break;
            }
            case 0x34: {
                l.startInstruction(p.toModifier(), Mnemonic.SYSENTER);
                l.endInstruction();
                break;
            }
            case 0x35: {
                l.startInstruction(p.toModifier(), Mnemonic.SYSEXIT);
                l.endInstruction();
                break;
            }
            case 0x37: {
                l.startInstruction(p.toModifier(), Mnemonic.GETSEC);
                l.endInstruction();
                break;
            }
            case 0x38: {
                three_byte_0x38(m, p, i, l);
                break;
            }
            case 0x3a: {
                three_byte_0x3a(m, p, i, l);
                break;
            }
            case 0x40: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVO);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x41: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVNO);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x42: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVB);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x43: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVAE);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x44: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVZ);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x45: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVNZ);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x46: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVBE);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x47: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVA);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x48: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVS);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x49: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVNS);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x4a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVP);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x4b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVNP);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x4c: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVL);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x4d: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVGE);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x4e: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVLE);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x4f: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMOVG);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x50: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVMSKPD);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVMSKPS);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x51: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSQRTPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSQRTSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSQRTSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSQRTPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x52: {
                if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VRSQRTSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VRSQRTPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x53: {
                if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VRCPSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VRCPPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x54: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VANDPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VANDPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x55: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VANDNPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VANDNPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x56: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VORPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VORPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x57: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VXORPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VXORPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x58: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VADDPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VADDSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VADDSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VADDPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x59: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMULPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMULSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMULSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMULPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTPD2PS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTSS2SD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTSD2SS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTPS2PD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTPS2DQ);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTTPS2DQ);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTDQ2PS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSUBPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSUBSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSUBSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VSUBPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMINPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMINSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMINSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMINPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VDIVPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VDIVSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VDIVSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VDIVPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMAXPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMAXSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMAXSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.H(p, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMAXPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x60: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKLBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PUNPCKLBW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x61: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKLWD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PUNPCKLWD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x62: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKLDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PUNPCKLDQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x63: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPACKSSWB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PACKSSWB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x64: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPGTB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PCMPGTB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x65: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPGTW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PCMPGTW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x66: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPGTD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PCMPGTD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x67: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPACKUSWB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PACKUSWB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x68: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKHBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PUNPCKHBW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x69: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKHWD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PUNPCKHWD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x6a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKHDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PUNPCKHDQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x6b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPACKSSDW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PACKSSDW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x6c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKLQDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x6d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPUNPCKHQDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x6e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVD);
                    OperandDecoder.V(mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVD);
                    OperandDecoder.P(mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x6f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVDQA);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVDQU);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x70: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSHUFD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSHUFHW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSHUFLW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSHUFW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x71: {
                final ModRM mrm = ModRM.read(i);
                group_12(m, p, mrm, i, l);
                break;
            }
            case 0x72: {
                final ModRM mrm = ModRM.read(i);
                group_13(m, p, mrm, i, l);
                break;
            }
            case 0x73: {
                final ModRM mrm = ModRM.read(i);
                group_14(m, p, mrm, i, l);
                break;
            }
            case 0x74: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPEQB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PCMPEQB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x75: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPEQW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PCMPEQW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x76: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPEQD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PCMPEQD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x77: {
                l.startInstruction(p.toModifier(), Mnemonic.EMMS);
                l.endInstruction();
                break;
            }
            case 0x78: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.VMREAD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x79: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.VMWRITE);
                OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x7c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VHADDPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VHADDPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x7d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VHSUBPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VHSUBPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x7e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVD);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVQ);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVD);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.P(mrm, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x7f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVDQA);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVDQU);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVQ);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x80: {
                l.startInstruction(p.toModifier(), Mnemonic.JO);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x81: {
                l.startInstruction(p.toModifier(), Mnemonic.JNO);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x82: {
                l.startInstruction(p.toModifier(), Mnemonic.JB);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x83: {
                l.startInstruction(p.toModifier(), Mnemonic.JAE);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x84: {
                l.startInstruction(p.toModifier(), Mnemonic.JZ);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x85: {
                l.startInstruction(p.toModifier(), Mnemonic.JNZ);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x86: {
                l.startInstruction(p.toModifier(), Mnemonic.JBE);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x87: {
                l.startInstruction(p.toModifier(), Mnemonic.JA);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x88: {
                l.startInstruction(p.toModifier(), Mnemonic.JS);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x89: {
                l.startInstruction(p.toModifier(), Mnemonic.JNS);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8a: {
                l.startInstruction(p.toModifier(), Mnemonic.JP);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8b: {
                l.startInstruction(p.toModifier(), Mnemonic.JNP);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8c: {
                l.startInstruction(p.toModifier(), Mnemonic.JL);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8d: {
                l.startInstruction(p.toModifier(), Mnemonic.JGE);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8e: {
                l.startInstruction(p.toModifier(), Mnemonic.JLE);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x8f: {
                l.startInstruction(p.toModifier(), Mnemonic.JG);
                OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x90: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETO);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x91: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETNO);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x92: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETB);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x93: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETNB);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x94: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETZ);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x95: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETNZ);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x96: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETBE);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x97: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETA);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x98: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETS);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x99: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETNS);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x9a: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETP);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x9b: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETNP);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x9c: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x9d: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETGE);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x9e: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETLE);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x9f: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SETG);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xa0: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.FS(l);
                l.endInstruction();
                break;
            }
            case 0xa1: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.FS(l);
                l.endInstruction();
                break;
            }
            case 0xa2: {
                l.startInstruction(p.toModifier(), Mnemonic.CPUID);
                l.endInstruction();
                break;
            }
            case 0xa3: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.BT);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xa4: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SHLD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xa5: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SHLD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0xa8: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.GS(l);
                l.endInstruction();
                break;
            }
            case 0xa9: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.GS(l);
                l.endInstruction();
                break;
            }
            case 0xaa: {
                l.startInstruction(p.toModifier(), Mnemonic.RSM);
                l.endInstruction();
                break;
            }
            case 0xab: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.BTS);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xac: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SHRD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xad: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.SHRD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0xae: {
                final ModRM mrm = ModRM.read(i);
                group_15(m, p, mrm, i, l);
                break;
            }
            case 0xaf: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.IMUL);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb0: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMPXCHG);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb1: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.CMPXCHG);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb2: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.LSS);
                OperandDecoder.G(m, p, mrm, OperandDecoder.z(m.getOperandSize()), l);
                OperandDecoder.M(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb3: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.BTR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb4: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.LFS);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.M(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb5: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.LGS);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.M(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xb6: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOVZX);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xb7: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOVZX);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0xb8: {
                if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.POPCNT);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    l.startInstruction(p.toModifier(), Mnemonic.JMPE);
                    l.endInstruction();
                }
                break;
            }
            case 0xb9: {
                final ModRM mrm = ModRM.read(i);
                group_10(m, p, mrm, i, l);
                break;
            }
            case 0xba: {
                final ModRM mrm = ModRM.read(i);
                group_8(m, p, mrm, i, l);
                break;
            }
            case 0xbb: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.BTC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xbc: {
                if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.TZNCT);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BSF);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbd: {
                if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.LZNCT);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BSR);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbe: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOVSX);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xbf: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOVSX);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0xc0: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XADD);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.G(m, p, mrm, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0xc1: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.XADD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xc2: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCMPPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCMPSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCMPSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCMPPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xc3: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.MOVNTI);
                OperandDecoder.M(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xc4: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PINSRW);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Ry_Mw(m, p, mrm, i, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PINSRW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Ry_Mw(m, p, mrm, i, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xc5: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PEXTRW);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.U(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PEXTRW);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xc6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.SHUFPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.SHUFPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xc7: {
                final ModRM mrm = ModRM.read(i);
                group_9(m, p, mrm, i, l);
                break;
            }
            case 0xc8: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rAXr8(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xc9: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rCXr9(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xca: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rDXr10(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xcb: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rBXr11(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xcc: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rSPr12(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xcd: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rBPr13(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xce: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rSIr14(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xcf: {
                l.startInstruction(p.toModifier(), Mnemonic.BSWAP);
                OperandDecoder.rDIr15(m, p, l);
                l.endInstruction();
                break;
            }
            case 0xd0: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VADDSUBPD);
                    OperandDecoder.V(mrm, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.pd(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VADDSUBPS);
                    OperandDecoder.V(mrm, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.ps(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.ps(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd1: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd2: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd3: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd4: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd5: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMULLW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMULLW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVQ);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.V(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVQ2DQ);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Nq(mrm, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVDQ2Q);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.U(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd7: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMOVMSKB);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMOVMSKB);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.Nq(mrm, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd8: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBUSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBUSB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xd9: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBUSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBUSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xda: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMINUB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMINUB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdb: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPAND);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PAND);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdc: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDUSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDUSB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdd: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDUSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDUSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xde: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMAXUB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMAXUB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdf: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPANDN);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PANDN);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe0: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPAVGB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PAVGB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe1: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRAW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSRAW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe2: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRAD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSRAD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe3: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPAVGW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PAVGW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe4: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMULHUW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMULHUW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe5: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMULHW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMULHW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTTPD2DQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTDQ2PD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTPD2DQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.pd(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe7: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVNTDQ);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVNTQ);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe8: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBSB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xe9: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xea: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMINSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMINSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xeb: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPOR);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.POR);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xec: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDSB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xed: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xee: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMAXSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMAXSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xef: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPXOR);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PXOR);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf0: {
                if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VLDDQU);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf1: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf2: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf3: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf4: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMULUDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMULUDQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf5: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMADDWD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMADDWD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSADBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSADBW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf7: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMASKMOVQ);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.U(mrm, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MASKMOVQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Nq(mrm, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf8: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf9: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xfa: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xfb: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSUBQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSUBQ);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xfc: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xfd: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xfe: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPADDD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PADDD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
                break;
            }
        }
    }
    
    static void three_byte_0x38(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        switch (c) {
            case 0x00: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSHUFB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSHUFB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x01: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHADDW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PHADDW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x02: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHADDD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PHADDD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x03: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHADDSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PHADDSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x04: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMADDUBSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMADDUBSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x05: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHSUBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PHSUBW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHSUBD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PHSUBD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x07: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHSUBSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PHSUBSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x08: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSIGNB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSIGNB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x09: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSIGNW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSIGNW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSIGND);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PSIGND);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMULHRSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PMULHRSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMILPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMILPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VTESTPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VTESTPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x10: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PBLENDVB);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x13: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTPH2PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x14: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BLENDVPS);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x15: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BLENDVPD);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x16: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMPS);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x17: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPTEST);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x18: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBROADCASTSS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x19: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBROADCASTSD);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x1a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBROADCASTF128);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x1c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPABSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PABSB);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x1d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPABSW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PABSW);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x1e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPABSD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PABSD);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x20: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVSXBW);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Ux_Mq(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x21: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVSXBD);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Ux_Md(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x22: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVSXBQ);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Ux_Mw(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x23: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVSXWD);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Ux_Mq(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x24: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVSXWQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Md(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x25: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVSXDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Mq(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x28: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMULDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x29: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPEQQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMOVNTDQA);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPACKUSDW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMASKMOVPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMASKMOVPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMASKMOVPS);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x2f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMASKMOVPD);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x30: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVZXBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Mq(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x31: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVZXBD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Md(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x32: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVZXBQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Mw(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x33: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVZXWD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Mq(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x34: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVZXWQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Md(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x35: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMOVZXDQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.Ux_Mq(m, p, mrm, i, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x36: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMD);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x37: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPGTQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x38: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMINSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x39: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMINSD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x3a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMINUW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x3b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMINUD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x3c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMAXSB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x3d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMAXSD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x3e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMAXUW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x3f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMAXUD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x40: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMULLD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x41: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPHMINPOSUW);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x45: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLVD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x46: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRAVD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x47: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLVD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x58: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBROADCASTD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x59: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBROADCASTQ);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x5a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBROADCASTI128);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x78: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPBROADCASTB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x79: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPBROADCASTW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x80: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.INVEPT);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x81: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.INVVPID);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x82: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.INVPCID);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x8c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMASKMOVD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x8e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPMASKMOVD);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x90: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VGATHERDD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x91: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VGATHERQD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x92: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VGATHERDPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x93: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VGATHERQPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x96: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADDSUB132PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x97: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUBADD132PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x98: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADD132PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x99: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADD132SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUB132PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUB132SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMADD132PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMADD132SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMSUB132PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x9f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMSUB132SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xa6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADDSUB213PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xa7: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUBADD213PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xa8: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADD213PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xa9: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADD213SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xaa: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUB213PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xab: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUB213SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xac: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMADD213PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xad: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMADD213SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xae: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMSUB213PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xaf: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMSUB213SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xb6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADDSUB231);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xb7: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUBADD231);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xb8: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADD231PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xb9: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMADD231SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xba: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUB231PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbb: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFMSUB231SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbc: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMADD231PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbd: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMADD231SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbe: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMSUB231PS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xbf: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VFNMSUB231SS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdb: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VAESIMC);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdc: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VAESENC);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdd: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VAESENCLAST);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xde: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VAESDEC);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdf: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VAESDECLAST);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf0: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVBE);
                    OperandDecoder.G(m, p, mrm, OperandType.WORD, l);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CRC32);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CRC32);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVBE);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf1: {
                if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CRC32);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.has66() && p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.CRC32);
                    OperandDecoder.G(m, p, mrm, OperandType.DOUBLEWORD, l);
                    OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                }
                else if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVBE);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    OperandDecoder.G(m, p, mrm, OperandType.WORD, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MOVBE);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf2: {
                final ModRM mrm = ModRM.read(i);
                l.startInstruction(p.toModifier(), Mnemonic.ANDN);
                OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0xf3: {
                final ModRM mrm = ModRM.read(i);
                group_17(m, p, mrm, i, l);
                break;
            }
            case 0xf5: {
                if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PEXT);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PEDP);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BZHI);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf6: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.ADCX);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.ADOX);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.MULX);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.rDX(m, l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf7: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.SHLX);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF3()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.SARX);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.SHRX);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.BEXTR);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
                break;
            }
        }
    }
    
    static void three_byte_0x3a(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        switch (c) {
            case 0x00: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMQ);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x01: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMPD);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x02: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPBLENDD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x04: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMILPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x05: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERMILPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERM2F128);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x08: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VROUNDPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x09: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VROUNDPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VROUNDSS);
                    OperandDecoder.V(mrm, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_SINGLE_128BIT, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VROUNDSD);
                    OperandDecoder.V(mrm, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.SCALAR_DOUBLE_128BIT, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBLENDPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBLENDPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0e: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPBLENDW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x0f: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PALIGNR);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.PALIGNR);
                    OperandDecoder.P(mrm, OperandType.QUADWORD, l);
                    OperandDecoder.Q(m, p, mrm, i, OperandType.QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x14: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPEXTRB);
                    OperandDecoder.Rd_Mb(m, p, mrm, i, l);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x15: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPEXTRW);
                    OperandDecoder.Rd_Mw(m, p, mrm, i, l);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x16: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPEXTRD_Q);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x17: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VEXTRACTPS);
                    OperandDecoder.E(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x18: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VINSERTF128);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x19: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VEXTRACTF128);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x1d: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VCVTPS2PH);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x20: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPINSRB);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Ry_Mb(m, p, mrm, i, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x21: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VINSERTPS);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.Udq_Md(m, p, mrm, i, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x22: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPINSRD_Q);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x40: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VDPPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x41: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VDPPD);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x42: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VMPSADBW);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x44: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCLMULQDQ);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x46: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPERM2I128);
                    OperandDecoder.V(mrm, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.H(p, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.QUAD_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4a: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBLENDVPS);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.L(i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4b: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBLENDVPD);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.L(i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x4c: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VBLENDVB);
                    OperandDecoder.V(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.W(m, p, mrm, i, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.L(i, OperandDecoder.x(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x60: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPESTRM);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x61: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPESTRI);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x62: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPISTRM);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x63: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.VPCMPISTRI);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xdf: {
                if (p.has66()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.AESKEYGEN);
                    OperandDecoder.V(mrm, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.W(m, p, mrm, i, OperandType.DOUBLE_QUADWORD, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0xf0: {
                if (p.hasF2()) {
                    final ModRM mrm = ModRM.read(i);
                    l.startInstruction(p.toModifier(), Mnemonic.RORX);
                    OperandDecoder.G(m, p, mrm, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
                break;
            }
        }
    }
    
    static void amd3DNow(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        switch (c) {
            default: {
                l.reportInvalid();
                break;
            }
        }
    }
    
    static void x87_0xd8(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xc8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xca: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xcb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xcc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xcd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xce: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xcf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xd2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xd3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xd4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xd5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xd6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xd7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xda: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xdb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xdc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xdd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xde: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xdf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xe0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xe2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xe3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xe4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xe5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xe6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xe7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xef: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xf0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xf2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xf3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xf4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xf5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xf6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xf7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xf8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xfa: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xfb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xfc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xfd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xfe: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xff: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xd9(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDENV);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDCW);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNSTENV);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNSTCW);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xc8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xca: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xcb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xcc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xcd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xce: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xcf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXCH);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNOP);
                    l.endInstruction();
                    break;
                }
                case 0xd8: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xd9: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xda: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xdb: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xdc: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xdd: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xde: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xdf: {
                    l.startInstruction(p.toModifier(), Mnemonic.NONE);
                    l.endInstruction();
                    break;
                }
                case 0xe0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCHS);
                    l.endInstruction();
                    break;
                }
                case 0xe1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FABS);
                    l.endInstruction();
                    break;
                }
                case 0xe4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FTST);
                    l.endInstruction();
                    break;
                }
                case 0xe5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FXAM);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD1);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDL2T);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDL2E);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDLPI);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDLG2);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDLN2);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLDZ);
                    l.endInstruction();
                    break;
                }
                case 0xf0: {
                    l.startInstruction(p.toModifier(), Mnemonic.F2XM1);
                    l.endInstruction();
                    break;
                }
                case 0xf1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FYL2X);
                    l.endInstruction();
                    break;
                }
                case 0xf2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FPTAN);
                    l.endInstruction();
                    break;
                }
                case 0xf3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FPATAN);
                    l.endInstruction();
                    break;
                }
                case 0xf4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FPXTRACT);
                    l.endInstruction();
                    break;
                }
                case 0xf5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FPREM1);
                    l.endInstruction();
                    break;
                }
                case 0xf6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDECSTP);
                    l.endInstruction();
                    break;
                }
                case 0xf7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNCSTP);
                    l.endInstruction();
                    break;
                }
                case 0xf8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FPREM);
                    l.endInstruction();
                    break;
                }
                case 0xf9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FYL2XP1);
                    l.endInstruction();
                    break;
                }
                case 0xfa: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSQRT);
                    l.endInstruction();
                    break;
                }
                case 0xfb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSINCOS);
                    l.endInstruction();
                    break;
                }
                case 0xfc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FRNDINT);
                    l.endInstruction();
                    break;
                }
                case 0xfd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSCALE);
                    l.endInstruction();
                    break;
                }
                case 0xfe: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSIN);
                    l.endInstruction();
                    break;
                }
                case 0xff: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOS);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xda(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIADD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIMUL);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FICOM);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FICOMP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISUB);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISUBR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIDIV);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIDIVR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xc8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xca: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xcb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xcc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xcd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xce: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xcf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xd2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xd3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xd4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xd5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xd6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xd7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xda: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xdb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xdc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xdd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xde: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xdf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMPP);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xdb(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FILD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISTTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIST);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.PACKED_BCD, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.PACKED_BCD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xc8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xca: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xcb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xcc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xcd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xce: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xcf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xd2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xd3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xd4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xd5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xd6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xd7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNBE);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xda: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xdb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xdc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xdd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xde: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xdf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCMOVNU);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xe2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCLEX);
                    l.endInstruction();
                    break;
                }
                case 0xe3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNINIT);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xef: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xf0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xf2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xf3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xf4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xf5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xf6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xf7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMI);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xdc(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOM);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADD);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xca: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xce: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMUL);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBR);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xef: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUB);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVR);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfa: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfe: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xff: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIV);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xdd(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FLD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISTTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FRSTOR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNSAVE);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNSTSW);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FFREE);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xd2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xd3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xd4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xd5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xd6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xd7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FST);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xd8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xda: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xdb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xdc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xdd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xde: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xdf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSTP);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xe0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xe2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xe3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xe4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xe5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xe6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xe7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOM);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xef: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMP);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xde(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIADD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIMUL);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FICOM);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FICOMP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISUB);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISUBR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIDIV);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIDIVR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xc0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FADDP);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xc9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xca: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xce: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xcf: {
                    l.startInstruction(p.toModifier(), Mnemonic.FMULP);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xd9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMPP);
                    l.endInstruction();
                    break;
                }
                case 0xe0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBRP);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xef: {
                    l.startInstruction(p.toModifier(), Mnemonic.FSUBP);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVRP);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST1(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfa: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST2(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST3(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfc: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST4(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfd: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST5(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xfe: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST6(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xff: {
                    l.startInstruction(p.toModifier(), Mnemonic.FDIVP);
                    OperandDecoder.ST7(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void x87_0xdf(Mode m, Prefixes p, InputStream i, Disassembler.Listener l) throws IOException {
        final int c = i.read();
        final ModRM mrm = new ModRM((byte) c);
        if (c <= 0xbf) {
            switch (mrm.reg()) {
                case 0x0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FILD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISTTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FIST);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FBLD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.PACKED_BCD, l);
                    l.endInstruction();
                    break;
                }
                case 0x5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FILD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                case 0x6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FBSTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.PACKED_BCD, l);
                    l.endInstruction();
                    break;
                }
                case 0x7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FISTP);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
        else {
            switch (c) {
                case 0xe0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FNSTSW);
                    OperandDecoder.AX(l);
                    l.endInstruction();
                    break;
                }
                case 0xe8: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xe9: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xea: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xeb: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xec: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xed: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xee: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xef: {
                    l.startInstruction(p.toModifier(), Mnemonic.FUCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                case 0xf0: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST0(l);
                    l.endInstruction();
                    break;
                }
                case 0xf1: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST1(l);
                    l.endInstruction();
                    break;
                }
                case 0xf2: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST2(l);
                    l.endInstruction();
                    break;
                }
                case 0xf3: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST3(l);
                    l.endInstruction();
                    break;
                }
                case 0xf4: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST4(l);
                    l.endInstruction();
                    break;
                }
                case 0xf5: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST5(l);
                    l.endInstruction();
                    break;
                }
                case 0xf6: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST6(l);
                    l.endInstruction();
                    break;
                }
                case 0xf7: {
                    l.startInstruction(p.toModifier(), Mnemonic.FCOMIP);
                    OperandDecoder.ST0(l);
                    OperandDecoder.ST7(l);
                    l.endInstruction();
                    break;
                }
                default: {
                    l.reportInvalid();
                    break;
                }
            }
        }
    }
    
    static void immediate_group_1_0x80(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void immediate_group_1_0x81(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void immediate_group_1_0x82(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.ADD);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x01: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.OR);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x02: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.ADC);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x03: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.SBB);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x04: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.AND);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x05: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.SUB);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.XOR);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x07: {
                if (!m.is64BIT()) {
                    l.startInstruction(p.toModifier(), Mnemonic.CMP);
                    OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void immediate_group_1_0x83(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ADD);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.OR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.ADC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.SBB);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.AND);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SUB);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.XOR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.CMP);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_1A(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.POP);
                OperandDecoder.E(Mode.d64(m), p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void shift_group_2_0xc0(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ROL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.ROR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.RCL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.RCR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.SHL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SHR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.SAL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.SAR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void shift_group_2_0xc1(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ROL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.ROR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.RCL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.RCR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.SHL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SHR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.SAL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.SAR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void shift_group_2_0xd0(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ROL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.ROR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.RCL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.RCR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.SHL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SHR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.SAL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.SAR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void shift_group_2_0xd1(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ROL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.ROR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.RCL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.RCR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.SHL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SHR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.SAR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder._1(l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void shift_group_2_0xd2(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ROL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.ROR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.RCL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.RCR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.SHL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SHR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.SAL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.SAR);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void shift_group_2_0xd3(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.ROL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.ROR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.RCL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.RCR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.SHL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.SHR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.SAL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.SAR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.CL(l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void unary_group_3_0xf6(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.TEST);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.NOT);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.NEG);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.MUL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.IMUL);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.DIV);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.IDIV);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void unary_group_3_0xf7(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.TEST);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.NOT);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.NEG);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.MUL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.IMUL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.DIV);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.IDIV);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_4(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.INC);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.DEC);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_5(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.INC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.DEC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.CALL);
                OperandDecoder.E(Mode.f64(m), p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.CALL);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.JMP);
                OperandDecoder.E(Mode.f64(m), p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.JMP);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.p(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.PUSH);
                OperandDecoder.E(Mode.d64(m), p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_6(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.SLDT);
                OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.STR);
                OperandDecoder.M(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.LLDT);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.LTR);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.VERR);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.VERW);
                OperandDecoder.E(m, p, mrm, i, OperandType.WORD, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_7(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                if (mrm.mod() == 3 && mrm.rm() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMRESUME);
                    l.endInstruction();
                }
                else if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.SGDT);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.s(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3 && mrm.rm() == 1) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMCALL);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3 && mrm.rm() == 2) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMLAUNCH);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3 && mrm.rm() == 4) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMXOFF);
                    l.endInstruction();
                }
                break;
            }
            case 0x01: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.SIDT);
                    OperandDecoder.M(m, p, mrm, i, OperandDecoder.s(m.getOperandSize()), l);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3 && mrm.rm() == 1) {
                    l.startInstruction(p.toModifier(), Mnemonic.MWAIT);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3 && mrm.rm() == 0) {
                    l.startInstruction(p.toModifier(), Mnemonic.MONITOR);
                    l.endInstruction();
                }
                break;
            }
            case 0x02: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.INVLPG);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (m.is64BIT() && mrm.mod() == 3 && mrm.rm() == 0) {
                    l.startInstruction(p.toModifier(), Mnemonic.SWAPGS);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_8(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x04: {
                l.startInstruction(p.toModifier(), Mnemonic.BT);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x05: {
                l.startInstruction(p.toModifier(), Mnemonic.BTS);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x06: {
                l.startInstruction(p.toModifier(), Mnemonic.BTR);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                l.startInstruction(p.toModifier(), Mnemonic.BTC);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_9(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x01: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.CMPXCHG8B);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMCLEAR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMXON);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMPTRLD);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x07: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VMPTRST);
                    OperandDecoder.M(m, p, mrm, i, OperandType.QUADWORD, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_10(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_11_0xc6(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.E(m, p, mrm, i, OperandType.BYTE, l);
                OperandDecoder.I(i, OperandType.BYTE, l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.XABORT);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_11_0xc7(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                l.startInstruction(p.toModifier(), Mnemonic.MOV);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.v(m.getOperandSize()), l);
                OperandDecoder.I(i, OperandDecoder.z(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x07: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.XBEGIN);
                    OperandDecoder.J(i, OperandDecoder.z(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_12(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x02: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLW);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLW);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x04: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSRAW);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRAW);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLW);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLW);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_13(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x02: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLD);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLD);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x04: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSRAD);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRAD);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLD);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLD);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_14(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x02: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLQ);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSRLQ);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x03: {
                if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSRLDQ);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLQ);
                    OperandDecoder.Nq(mrm, l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.VPSLLQ);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x07: {
                if (p.has66() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PSLLDQ);
                    OperandDecoder.H(p, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.U(mrm, OperandDecoder.x(m.getOperandSize()), l);
                    OperandDecoder.I(i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_15(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.FXSAVE);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.hasF3() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.RDFSBASE);
                    OperandDecoder.R(mrm, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x01: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.FXRSTOR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (p.hasF3() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.RDGSBASE);
                    OperandDecoder.R(mrm, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x02: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.LDMXCSR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.WRFSBASE);
                    OperandDecoder.R(mrm, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x03: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.STMXCSR);
                    OperandDecoder.M(m, p, mrm, i, OperandType.DOUBLEWORD, l);
                    l.endInstruction();
                }
                else if (p.hasF3() && mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.WRGSBASE);
                    OperandDecoder.R(mrm, OperandDecoder.y(m.getOperandSize()), l);
                    l.endInstruction();
                }
                break;
            }
            case 0x04: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.XSAVE);
                    l.endInstruction();
                }
                break;
            }
            case 0x05: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.XRSTOR);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.LFENCE);
                    l.endInstruction();
                }
                break;
            }
            case 0x06: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.XSAVEOPT);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.MFENCE);
                    l.endInstruction();
                }
                break;
            }
            case 0x07: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.CLFLUSH);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                else if (mrm.mod() == 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.SFENCE);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_16(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x00: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PREFETCHNTA);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x01: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PREFETCHT0);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x02: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PREFETCHT1);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            case 0x03: {
                if (mrm.mod() != 3) {
                    l.startInstruction(p.toModifier(), Mnemonic.PREFETCHT2);
                    OperandDecoder.M(m, p, mrm, i, OperandType.BYTE, l);
                    l.endInstruction();
                }
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
    static void group_17(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l) throws IOException {
        switch (mrm.reg()) {
            case 0x01: {
                l.startInstruction(p.toModifier(), Mnemonic.BLSR);
                OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x02: {
                l.startInstruction(p.toModifier(), Mnemonic.BLSMSK);
                OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            case 0x03: {
                l.startInstruction(p.toModifier(), Mnemonic.BLSI);
                OperandDecoder.B(p, OperandDecoder.y(m.getOperandSize()), l);
                OperandDecoder.E(m, p, mrm, i, OperandDecoder.y(m.getOperandSize()), l);
                l.endInstruction();
                break;
            }
            default: {
                l.reportInvalid();
            }
        }
    }
    
}
