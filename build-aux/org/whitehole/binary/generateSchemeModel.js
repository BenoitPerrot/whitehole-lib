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

// Build a Java class representing an enumerated type in a binary decoding
// scheme. Said class is immutable.
//

define('org/whitehole/binary/generateSchemeModel',
       [ 'org/whitehole/infra/IO',
         'org/whitehole/binary/generateEnumeration',
         'org/whitehole/binary/generateFlagSet',
         'org/whitehole/binary/generateStructure'],
         function(IO, generateEnumeration, generateFlagSet, generateStructure) {
	'use strict';

	function generate(ns, name, e) {
	}
	
	return function(schemaPath, destNS) {
		var schema = IO.readJSONFile(schemaPath);
		
		var destPath = 'src/' + destNS.replace(/\./g, '/');

		for (k in schema.enumerations)
			if (schema.enumerations.hasOwnProperty(k)) {
				print("Generating " + destPath + '/' + k + '.java' + "...");
				IO.writeFile(destPath + '/' + k + '.java',
				             generateEnumeration(destNS, k, schema.enumerations[k]));
			}
		
		for (k in schema.flagSets)
			if (schema.flagSets.hasOwnProperty(k)) {
				print("Generating " + destPath + '/' + k + '.java' + "...");
				IO.writeFile(destPath + '/' + k + '.java',
				             generateFlagSet(destNS, k, schema.flagSets[k]));
			}
		
		for (k in schema.structures)
			if (schema.structures.hasOwnProperty(k))
				if (k !== 'PEHeader' && k !== 'OptionalHeader' && k !== 'WindowsSpecificPEFields') {
					print("Generating " + destPath + '/' + k + '.java' + "...");
					IO.writeFile(destPath + '/' + k + '.java',
					             generateStructure(destNS, schema, k));
				}
	}
});
