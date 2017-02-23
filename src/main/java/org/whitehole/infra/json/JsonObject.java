// Copyright (c) 2004-2015, Benoit PERROT.
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

import java.util.Set;
import java.util.TreeMap;

public class JsonObject extends JsonStructure {

	private final TreeMap<String, JsonValue> _data = new TreeMap<String, JsonValue>();

	public JsonObject() {
		super(ValueType.OBJECT);
	}

	public boolean isEmpty() {
		return _data.isEmpty();
	}

	public int size() {
		return _data.size();
	}

	public boolean containsKey(String key) {
		return _data.containsKey(key);
	}

	public boolean containsValue(JsonValue v) {
		return _data.containsValue(v);
	}

	public Set<java.util.Map.Entry<String, JsonValue>> entrySet() {
		return _data.entrySet();
	}

	public Set<String> keySet() {
		return _data.keySet();
	}

	public JsonValue put(String key, JsonValue value) {
		return _data.put(key, value);
	}

	public JsonValue get(String key) {
		return _data.get(key);
	}

	public JsonNumber getNumber(String key) {
		return (JsonNumber) _data.get(key);
	}

	public JsonString getString(String key) {
		return (JsonString) _data.get(key);
	}

	public JsonArray getArray(String key) {
		return (JsonArray) _data.get(key);
	}

	public JsonObject getObject(String key) {
		return (JsonObject) _data.get(key);
	}

	public JsonValue remove(String key) {
		return _data.remove(key);
	}

	public void clear() {
		_data.clear();
	}

}
