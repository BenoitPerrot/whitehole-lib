// Copyright (c) 2004-2013, Benoit PERROT.
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

import java.math.BigDecimal;
import java.util.Stack;

import org.whitehole.infra.json.JsonArray;
import org.whitehole.infra.json.JsonNumber;
import org.whitehole.infra.json.JsonObject;
import org.whitehole.infra.json.JsonString;
import org.whitehole.infra.json.JsonStructure;
import org.whitehole.infra.json.JsonValue;

public interface JsonGenerator {

	public JsonGenerator write(BigDecimal value);

	public JsonGenerator write(boolean value);

	public JsonGenerator write(String value);

	public JsonGenerator write(String name, BigDecimal value);

	public JsonGenerator write(String name, boolean value);

	public JsonGenerator write(String name, String value);

	public JsonGenerator writeEnd() throws Exception;

	public JsonGenerator writeNull() throws Exception;

	public JsonGenerator writeNull(String name) throws Exception;

	public JsonGenerator writeStartArray() throws Exception;

	public JsonGenerator writeStartArray(String name) throws Exception;

	public JsonGenerator writeStartObject() throws Exception;

	public JsonGenerator writeStartObject(String name) throws Exception;

	class Builder implements JsonGenerator {

		@Override
		public JsonGenerator write(BigDecimal value) {
			return add(new JsonNumber.Impl(value));
		}

		@Override
		public JsonGenerator write(boolean value) {
			return add(value ? JsonValue.TRUE : JsonValue.FALSE);
		}

		@Override
		public JsonGenerator write(String value) {
			return add(new JsonString.Impl(value));
		}

		@Override
		public JsonGenerator write(String name, BigDecimal value) {
			return put(name, new JsonNumber.Impl(value));
		}

		@Override
		public JsonGenerator write(String name, boolean value) {
			return put(name, value ? JsonValue.TRUE : JsonValue.FALSE);
		}

		@Override
		public JsonGenerator write(String name, String value) {
			return put(name, new JsonString.Impl(value));
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
			return addStart(new JsonObject.Impl());
		}

		@Override
		public JsonGenerator writeStartObject(final String name) throws Exception {
			return putStart(name, new JsonObject.Impl());
		}

		@Override
		public JsonGenerator writeStartArray() {
			return addStart(new JsonArray.Impl());
		}

		@Override
		public JsonGenerator writeStartArray(String name) throws Exception {
			return putStart(name, new JsonArray.Impl());
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
}
