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

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public interface JsonObject extends JsonStructure, Map<String, JsonValue> {

	public JsonString getString(String key);

	public JsonArray getArray(String key);

	static class Impl extends JsonValue.Impl implements JsonObject {

		private final SortedMap<String, JsonValue> _data = new TreeMap<String, JsonValue>();

		public Impl() {
			super(ValueType.OBJECT);
		}

		@Override
		public void clear() {
			_data.clear();
		}

		@Override
		public boolean containsKey(Object key) {
			return _data.containsKey(key);
		}

		@Override
		public boolean containsValue(Object value) {
			return _data.containsValue(value);
		}

		@Override
		public Set<java.util.Map.Entry<String, JsonValue>> entrySet() {
			return _data.entrySet();
		}

		@Override
		public JsonValue get(Object key) {
			return _data.get(key);
		}

		@Override
		public JsonString getString(String key) {
			return (JsonString) get(key);
		}

		@Override
		public JsonArray getArray(String key) {
			return (JsonArray) get(key);
		}

		@Override
		public boolean isEmpty() {
			return _data.isEmpty();
		}

		@Override
		public Set<String> keySet() {
			return _data.keySet();
		}

		@Override
		public JsonValue put(String key, JsonValue value) {
			return _data.put(key, value);
		}

		@Override
		public void putAll(Map<? extends String, ? extends JsonValue> m) {
			_data.putAll(m);
		}

		@Override
		public JsonValue remove(Object key) {
			return _data.remove(key);
		}

		@Override
		public int size() {
			return _data.size();
		}

		@Override
		public Collection<JsonValue> values() {
			return _data.values();
		}
	}
}
