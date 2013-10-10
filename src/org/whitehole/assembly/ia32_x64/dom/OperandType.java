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
package org.whitehole.assembly.ia32_x64.dom;

import org.whitehole.infra.types.BinaryWidth;

public enum OperandType {
	BYTE,
	DOUBLEWORD,
	DOUBLE_QUADWORD,
	EXTENDED_FLOAT,
	PACKED_BCD,
	PACKED_DOUBLE_128BIT,
	PACKED_DOUBLE_256BIT,
	PACKED_SINGLE_128BIT,
	PACKED_SINGLE_256BIT,
	PSEUDO_DESCRIPTOR_6BYTE,
	PSEUDO_DESCRIPTOR_10BYTE,
	POINTER_32BIT,
	POINTER_48BIT,
	POINTER_80BIT,
	QUADWORD,
	QUAD_QUADWORD,
	SCALAR_DOUBLE_128BIT,
	SCALAR_SINGLE_128BIT,
	TWO_DOUBLEWORD,
	TWO_ONE_WORD,
	WORD;

	public static BinaryWidth toBinaryWidth(OperandType t) {
		switch (t) {
			case BYTE:
				return BinaryWidth._8BIT;
			case WORD:
				return BinaryWidth._16BIT;
			case DOUBLEWORD:
				return BinaryWidth._32BIT;
			case QUADWORD:
				return BinaryWidth._64BIT;
			case DOUBLE_QUADWORD:
				return BinaryWidth._128BIT;
			default:
				break;
		}
		return null;
	}

	public static OperandType fromBinaryWidth(BinaryWidth w) {
		switch (w) {
			case _8BIT:
				return OperandType.BYTE;
			case _16BIT:
				return OperandType.WORD;
			case _32BIT:
				return OperandType.DOUBLEWORD;
			case _64BIT:
				return OperandType.QUADWORD;
			case _128BIT:
				return OperandType.DOUBLE_QUADWORD;
			default:
				break;
		}
		return null;
	}
}
