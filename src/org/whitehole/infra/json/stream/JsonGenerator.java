// Copyright (c) 2004-2014, Benoit PERROT.
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
//       notice, this list of conditions and the following disclaimer.
//
//     * Redistributions in binary form must reproduce the above
//       copyright notice, this list of conditions and the following
//       disclaimer in the documentation and/or other materials provided
//       with the distribution.
//
//     * Neither the name of the White Hole Project nor the names of its
//       contributors may be used to endorse or promote products derived
//       from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
package org.whitehole.infra.json.stream;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Stack;

import org.whitehole.infra.json.JsonArray;
import org.whitehole.infra.json.JsonException;
import org.whitehole.infra.json.JsonNumber;
import org.whitehole.infra.json.JsonObject;
import org.whitehole.infra.json.JsonString;
import org.whitehole.infra.json.JsonStructure;
import org.whitehole.infra.json.JsonValue;

public interface JsonGenerator extends Closeable {

	public void close() throws JsonException;

	public JsonGenerator write(BigDecimal value) throws JsonException;

	public JsonGenerator write(boolean value) throws JsonException;

	public JsonGenerator write(String value) throws JsonException;

	public JsonGenerator write(String name, BigDecimal value) throws JsonException;

	public JsonGenerator write(String name, boolean value) throws JsonException;

	public JsonGenerator write(String name, String value) throws JsonException;

	public JsonGenerator writeEnd() throws JsonException;

	public JsonGenerator writeNull() throws JsonException;

	public JsonGenerator writeNull(String name) throws JsonException;

	public JsonGenerator writeStartArray() throws JsonException;

	public JsonGenerator writeStartArray(String name) throws JsonException;

	public JsonGenerator writeStartObject() throws JsonException;

	public JsonGenerator writeStartObject(String name) throws JsonException;

	class Builder implements JsonGenerator {

		@Override
		public void close() {
			// Nothing to do.
		}

		@Override
		public JsonGenerator write(BigDecimal value) {
			return add(new JsonNumber(value));
		}

		@Override
		public JsonGenerator write(boolean value) {
			return add(value ? JsonValue.TRUE : JsonValue.FALSE);
		}

		@Override
		public JsonGenerator write(String value) {
			return add(new JsonString(value));
		}

		@Override
		public JsonGenerator write(String name, BigDecimal value) {
			return put(name, new JsonNumber(value));
		}

		@Override
		public JsonGenerator write(String name, boolean value) {
			return put(name, value ? JsonValue.TRUE : JsonValue.FALSE);
		}

		@Override
		public JsonGenerator write(String name, String value) {
			return put(name, new JsonString(value));
		}

		@Override
		public JsonGenerator writeEnd() {
			_last = _structures.pop();
			return this;
		}

		@Override
		public JsonGenerator writeNull() {
			return add(JsonValue.NULL);
		}

		@Override
		public JsonGenerator writeNull(String name) {
			return put(name, JsonValue.NULL);
		}

		@Override
		public JsonGenerator writeStartObject() {
			return addStart(new JsonObject());
		}

		@Override
		public JsonGenerator writeStartObject(final String name) throws JsonException {
			return putStart(name, new JsonObject());
		}

		@Override
		public JsonGenerator writeStartArray() {
			return addStart(new JsonArray());
		}

		@Override
		public JsonGenerator writeStartArray(String name) throws JsonException {
			return putStart(name, new JsonArray());
		}

		private final Stack<JsonStructure> _structures = new Stack<JsonStructure>();
		private JsonStructure _last = null;

		private JsonGenerator addStart(JsonStructure s) {
			if (!_structures.empty())
				((JsonArray) _structures.peek()).add(s);
			_structures.push(s);
			return this;
		}

		private JsonGenerator add(JsonValue value) {
			if (_structures.empty())
				; // FIXME: throw
			else
				((JsonArray) _structures.peek()).add(value);
			return this;
		}

		private JsonGenerator putStart(String name, JsonStructure s) {
			if (!_structures.empty())
				((JsonObject) _structures.peek()).put(name, s);
			_structures.push(s);
			return this;
		}

		private JsonGenerator put(String name, JsonValue value) {
			if (_structures.empty())
				; // FIXME: throw
			else
				((JsonObject) _structures.peek()).put(name, value);
			return this;
		}

		public JsonStructure get() {
			return _last;
		}
	}

	class Writer implements JsonGenerator {

		public Writer(java.io.Writer w) {
			_w = w;
		}

		private final java.io.Writer _w;

		private enum State {
			FIRST_IN_OBJECT, IN_OBJECT, FIRST_IN_ARRAY, IN_ARRAY
		}

		private Stack<State> _nest = new Stack<State>();

		private String escape(String s) {
			return s; // FIXME: do escape
		}

		private JsonGenerator preWrite() throws IOException {
			if (!_nest.empty()) {
				if (_nest.peek() == State.FIRST_IN_ARRAY) {
					_nest.pop();
					_nest.push(State.IN_ARRAY);
				}
				else if (_nest.peek() == State.FIRST_IN_OBJECT) {
					_nest.pop();
					_nest.push(State.IN_OBJECT);
				}
				else
					_w.write(", ");
			}
			return this;
		}

		@Override
		public void close() throws JsonException {
			try {
				_w.close();
			}
			catch (Exception x) {
				throw new JsonException("", x); // FIXME
			}
		}

		@Override
		public JsonGenerator write(BigDecimal value) throws JsonException {
			return writeEscapedItem(value.toString());
		}

		@Override
		public JsonGenerator write(boolean value) throws JsonException {
			return writeEscapedItem(Boolean.toString(value));
		}

		@Override
		public JsonGenerator write(String value) throws JsonException {
			// Do not concatenate strings to avoid useless copy
			try {
				preWrite();
				_w.write('"');
				_w.write(escape(value)); // FIXME: escape
				_w.write('"');
			}
			catch (IOException x) {
				throw new JsonException("", x); // FIXME: say something
			}
			return this;
		}

		private JsonGenerator writeEscapedItem(String value) throws JsonException {
			try {
				preWrite();
				_w.write(value);
			}
			catch (IOException x) {
				throw new JsonException("", x); // FIXME: say something
			}
			return this;
		}

		@Override
		public JsonGenerator write(String name, BigDecimal value) throws JsonException {
			return writeEscapedValue(name, value.toString());
		}

		@Override
		public JsonGenerator write(String name, boolean value) throws JsonException {
			return writeEscapedValue(name, Boolean.toString(value));
		}

		private JsonGenerator writeUnescapedKey(String key) throws IOException {
			preWrite();
			// Do not concatenate strings to avoid useless copy
			_w.write('"');
			_w.write(escape(key));
			_w.write('"');
			_w.write(": "); // TODO: pretty-print
			return this;
		}

		private JsonGenerator writeEscapedValue(String name, String value) throws JsonException {
			try {
				writeUnescapedKey(name);
				_w.write(value);
			}
			catch (IOException x) {
				throw new JsonException("", x); // FIXME: say something
			}
			return this;
		}

		@Override
		public JsonGenerator write(String name, String value) throws JsonException {
			try {
				writeUnescapedKey(name);
				_w.write('"');
				_w.write(escape(value));
				_w.write('"');
			}
			catch (IOException x) {
				throw new JsonException("", x); // FIXME: say something
			}
			return this;
		}

		@Override
		public JsonGenerator writeEnd() throws JsonException {
			try {
				switch (_nest.pop()) {
					case IN_ARRAY:
					case FIRST_IN_ARRAY:
						_w.write(" ]");
						break;
					case IN_OBJECT:
					case FIRST_IN_OBJECT:
						_w.write(" }");
						break;
				}
			}
			catch (IOException x) {
				throw new JsonException("", x); // FIXME: say something.
			}
			return this;
		}

		@Override
		public JsonGenerator writeNull() throws JsonException {
			return writeEscapedItem("null");
		}

		@Override
		public JsonGenerator writeNull(String name) throws JsonException {
			return writeEscapedValue(name, "null");
		}

		@Override
		public JsonGenerator writeStartObject() throws JsonException {
			writeEscapedItem("{ ");
			_nest.push(State.FIRST_IN_OBJECT);
			return this;
		}

		@Override
		public JsonGenerator writeStartObject(final String name) throws JsonException {
			writeEscapedValue(name, "{ ");
			_nest.push(State.FIRST_IN_OBJECT);
			return this;
		}

		@Override
		public JsonGenerator writeStartArray() throws JsonException {
			writeEscapedItem("[ ");
			_nest.push(State.FIRST_IN_ARRAY);
			return this;
		}

		@Override
		public JsonGenerator writeStartArray(String name) throws JsonException {
			writeEscapedValue(name, "[ ");
			_nest.push(State.FIRST_IN_ARRAY);
			return this;
		}
	}
}
