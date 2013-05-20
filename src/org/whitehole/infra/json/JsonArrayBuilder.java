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
package org.whitehole.infra.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonArrayBuilder {

	public JsonArrayBuilder add(JsonValue value);

	public JsonArrayBuilder addNull();

	public JsonArrayBuilder add(boolean value);

	public JsonArrayBuilder add(BigDecimal value);

	public JsonArrayBuilder add(BigInteger value);

	public JsonArrayBuilder add(double value);

	public JsonArrayBuilder add(int value);

	public JsonArrayBuilder add(long value);

	public JsonArrayBuilder add(String value);

	public JsonArrayBuilder add(JsonArrayBuilder builder);

	public JsonArrayBuilder add(JsonObjectBuilder builder);

	public JsonArray build();

	static class Impl implements JsonArrayBuilder {
		public JsonArrayBuilder add(JsonValue value) {
			_a.add(value);
			return this;
		}

		public JsonArrayBuilder addNull() {
			return add(JsonValue.NULL);
		}

		public JsonArrayBuilder add(boolean value) {
			return add(value ? JsonValue.TRUE : JsonValue.FALSE);
		}

		public JsonArrayBuilder add(BigDecimal value) {
			return add(new JsonNumber.Impl(value));
		}

		public JsonArrayBuilder add(BigInteger value) {
			return add(new BigDecimal(value));
		}

		public JsonArrayBuilder add(double value) {
			return add(new BigDecimal(value));
		}

		public JsonArrayBuilder add(int value) {
			return add(new BigDecimal(value));
		}

		public JsonArrayBuilder add(long value) {
			return add(new BigDecimal(value));
		}

		public JsonArrayBuilder add(String value) {
			return add(new JsonString.Impl(value));
		}

		public JsonArrayBuilder add(JsonArrayBuilder builder) {
			return add(builder.build());
		}

		public JsonArrayBuilder add(JsonObjectBuilder builder) {
			return add(builder.build());
		}

		public JsonArray build() {
			return _a;
		}

		private final JsonArray _a = new JsonArray.Impl();
	}
}
