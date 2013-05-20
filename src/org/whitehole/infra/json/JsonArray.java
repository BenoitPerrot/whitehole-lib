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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface JsonArray extends JsonValue, List<JsonValue> {

	static class Impl extends JsonValue.Impl implements JsonArray {
		private final ArrayList<JsonValue> _data = new ArrayList<JsonValue>();

		public Impl() {
			super(ValueType.ARRAY);
		}

		@Override
		public boolean add(JsonValue e) {
			return _data.add(e);
		}

		@Override
		public void add(int index, JsonValue element) {
			_data.add(index, element);
		}

		@Override
		public boolean addAll(Collection<? extends JsonValue> c) {
			return _data.addAll(c);
		}

		@Override
		public boolean addAll(int index, Collection<? extends JsonValue> c) {
			return _data.addAll(index, c);
		}

		@Override
		public void clear() {
			_data.clear();
		}

		@Override
		public boolean contains(Object o) {
			return _data.contains(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return _data.containsAll(c);
		}

		@Override
		public JsonValue get(int index) {
			return _data.get(index);
		}

		@Override
		public int indexOf(Object o) {
			return _data.indexOf(o);
		}

		@Override
		public boolean isEmpty() {
			return _data.isEmpty();
		}

		@Override
		public Iterator<JsonValue> iterator() {
			return _data.iterator();
		}

		@Override
		public int lastIndexOf(Object o) {
			return _data.lastIndexOf(o);
		}

		@Override
		public ListIterator<JsonValue> listIterator() {
			return _data.listIterator();
		}

		@Override
		public ListIterator<JsonValue> listIterator(int index) {
			return _data.listIterator(index);
		}

		@Override
		public boolean remove(Object o) {
			return _data.remove(o);
		}

		@Override
		public JsonValue remove(int index) {
			return _data.remove(index);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return _data.removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return _data.retainAll(c);
		}

		@Override
		public JsonValue set(int index, JsonValue element) {
			return _data.set(index, element);
		}

		@Override
		public int size() {
			return _data.size();
		}

		@Override
		public List<JsonValue> subList(int fromIndex, int toIndex) {
			return _data.subList(fromIndex, toIndex);
		}

		@Override
		public Object[] toArray() {
			return _data.toArray();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return _data.toArray(a);
		}
	}
}
