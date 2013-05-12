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

// Provide a Java code writer and a set of helpers to read/write files.
//

define('org/whitehole/infra/IO',
       [
           'org/whitehole/infra/Class'
       ],
       function (Class) {
           'use strict';

           var IndentingStringBuilder = Class.define(
               function (ws) {
                   this.ws = ws;
                   this.depth = 0;

                   this.s = '';
               },
               {
                   indentMore: function () {
                       ++this.depth;
                       return this;
                   },
                   indentLess: function() {
                       --this.depth;
                       return this;
                   },

                   startLine: function (s) {
                       for (var i = 0; i < this.depth; ++i)
                           this.s += this.ws;
                       return this.append(s);
                   },
                   endLine: function (s) {
                       this.append(s);
                       this.s += '\n';
                       return this;
                   },
                   append: function (s) {
                       if (s !== undefined)
                           this.s += s;
                       return this;
                   },
                   printLine: function (s) {
                       return this.startLine(s).endLine();
                   },

                   toString: function () {
                       return this.s;
                   }
               }
           );

           var CodeWriter = Class.define(
               function() {
                   this.head = new IndentingStringBuilder('    ');
                   this.body = new IndentingStringBuilder('    ');

                   this.ns = [];
                   this.isFirstEnumMember = [];
               },
               {
                   openDocument: function () {
                       this.head.printLine('// Generated, do not edit by hand');
                       return this;
                   },
                   closeDocument: function () {
                       return this;
                   },

                   openNamespace: function (ns) {
                       this.ns.push(ns);
                       this.head.printLine('package ' + ns + ';');
                       return this;
                   },
                   closeNamespace: function () {
                       this.ns.pop();
                       return this;
                   },

                   openEnum: function (name, visibility) {
                       this.body.startLine(visibility + ' enum ' + name + ' ');
                       this.isFirstEnumMember.push(false);
                       return this.openBlock();
                   },
                   closeEnum: function () {
                       this.body.endLine();
                       this.isFirstEnumMember.pop();
                       return this.closeBlock();
                   },
                   addEnumMember: function (name, value) {
                       var x = this.isFirstEnumMember.length - 1;
                       if (this.isFirstEnumMember[x])
                           this.body.endLine(',');
                       else
                           this.isFirstEnumMember[x] = true;

                       this.body.startLine(name);
                       if (value !== undefined)
                           this.body.append('(' + value + ')');

                       return this;
                   },

                   openBlock: function () {
                       this.body.endLine('{').indentMore();
                       return this;
                   },
                   closeBlock: function () {
                       this.body.indentLess().printLine('}');
                       return this;
                   },

                   toString: function () {
                       return this.head.toString() + '\n' +
                           this.body.toString();
                   }
               }
           );

           return {
               //
               readFile: function (path) {
                   return new java.util.Scanner(new java.io.File(path))
                       .useDelimiter("\\Z").next();
               },

               readJSONFile: function (path) {
                   return JSON.parse(this.readFile(path));
               },

               writeFile: function (path, s) {
                   var fw = new java.io.FileWriter(path);
                   fw.write(s);
                   fw.close();
               },

               //
               CodeWriter: CodeWriter
           };
       });