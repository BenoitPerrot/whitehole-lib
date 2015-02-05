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
package org.whitehole.infra.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonObjectBuilder {

	public JsonObjectBuilder add(String name, JsonValue value);

	public JsonObjectBuilder addNull(String name);

	public JsonObjectBuilder add(String name, boolean value);

	public JsonObjectBuilder add(String name, BigDecimal value);

	public JsonObjectBuilder add(String name, BigInteger value);

	public JsonObjectBuilder add(String name, double value);

	public JsonObjectBuilder add(String name, int value);

	public JsonObjectBuilder add(String name, long value);

	public JsonObjectBuilder add(String name, String value);

	public JsonObjectBuilder add(String name, JsonArrayBuilder builder);

	public JsonObjectBuilder add(String name, JsonObjectBuilder builder);

	public JsonObject build();

	static class Impl implements JsonObjectBuilder {

		public JsonObjectBuilder add(String name, JsonValue value) {
			_o.put(name, value);
			return this;
		}

		public JsonObjectBuilder addNull(String name) {
			return add(name, JsonValue.NULL);
		}

		public JsonObjectBuilder add(String name, boolean value) {
			return add(name, value ? JsonValue.TRUE : JsonValue.FALSE);
		}

		public JsonObjectBuilder add(String name, BigDecimal value) {
			return add(name, new JsonNumber(value));
		}

		public JsonObjectBuilder add(String name, BigInteger value) {
			return add(name, new BigDecimal(value));
		}

		public JsonObjectBuilder add(String name, double value) {
			return add(name, new BigDecimal(value));
		}

		public JsonObjectBuilder add(String name, int value) {
			return add(name, new BigDecimal(value));
		}

		public JsonObjectBuilder add(String name, long value) {
			return add(name, new BigDecimal(value));
		}

		public JsonObjectBuilder add(String name, String value) {
			return add(name, new JsonString(value));
		}

		public JsonObjectBuilder add(String name, JsonArrayBuilder builder) {
			return add(name, builder.build());
		}

		public JsonObjectBuilder add(String name, JsonObjectBuilder builder) {
			return add(name, builder.build());
		}

		public JsonObject build() {
			return _o;
		}

		private final JsonObject _o = new JsonObject();
	}
}
