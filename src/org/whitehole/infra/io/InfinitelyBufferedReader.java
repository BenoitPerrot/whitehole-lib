package org.whitehole.infra.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;

public class InfinitelyBufferedReader implements Closeable {

	private final Reader _r;
	private final Stack<Integer> _b = new Stack<Integer>();

	public InfinitelyBufferedReader(Reader r) {
		_r = r;
	}

	public void close() throws IOException {
		_r.close();
	}

	public int read() throws IOException {
		if (_b.isEmpty())
			return _r.read();
		else
			return _b.pop();
	}

	public int peek() throws IOException {
		if (_b.isEmpty())
			_b.push(_r.read());
		return _b.peek();
	}

	public void unread(String s) {
		for (int i = s.length() - 1; 0 <= i; --i)
			_b.push((int) s.charAt(i));
	}
}
