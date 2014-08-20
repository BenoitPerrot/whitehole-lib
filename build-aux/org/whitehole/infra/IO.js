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
                   this.imports = {};
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

                   addImport: function (i) {
                       if (!this.imports.hasOwnProperty(i)) {
                           this.imports[i] = true;
                           this.head.printLine('import ' + i + ';');
                       }
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
                   
                   openClass: function (visibility, name, base) {
                	   this.body.startLine(visibility + ' class ' + name + ' ');
                       if (base)
                           this.body.append('extends ' + base + ' ');
                       return this.openBlock();
                   },
                   closeClass: function () {
                	   return this.closeBlock();
                   },

                   openEnum: function (visibility, name) {
                       this.body.startLine(visibility + ' enum ' + name + ' ');
                       this.isFirstEnumMember.push(false);
                       return this.openBlock();
                   },
                   closeEnum: function () {
                       this.body.endLine();
                       this.isFirstEnumMember.pop();
                       this.closeBlock();
                       this.body.endLine();
                       return this;
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
                   closeEnumMembers: function () {
                       this.body.endLine(';').endLine();
                       return this;
                   },

                   openFunction: function (prefix, name, args, exs) {
                	   this.body.startLine();
                	   if (prefix)
                		   this.body.append(prefix + ' ');
                	   this.body.append(name).append('(');
                       if (args)
                           this.body.append(args);
                       this.body.append(') ');
                       if (exs)
                    	   this.body.append(exs).append(' ');
                       return this.openBlock();
                   },
                   closeFunction: function () {
                       this.closeBlock();
                       this.body.printLine();
                       return this;
                   },
                   
                   openIf: function (test) {
                       this.body.startLine("if (" + test + ") ");
                       return this.openBlock();
                   },

                   openElse: function () {
                       this.closeBlock();
                       this.body.startLine("else ");
                       return this.openBlock();
                   },

                   openElseIf: function (test) {
                       this.closeBlock();
                       this.body.startLine("else if (" + test + ") ");
                       return this.openBlock();
                   },

                   closeIf: function () {
                       return this.closeBlock();
                   },

                   openSwitch: function (x) {
                       this.body.startLine('switch (' + x + ') ');
                       return this.openBlock();
                   },

                   openCase: function (c) {
                       this.body.startLine('case ' + c + ': ');
                       return this.openBlock();
                   },

                   closeCase: function () {
                       return this.closeBlock();
                   },

                   openDefault: function () {
                       this.body.startLine('default: ');
                       return this.openBlock();
                   },

                   closeDefault: function () {
                       return this.closeBlock();
                   },

                   closeSwitch: function () {
                       return this.closeBlock();
                   },

                   openBlock: function () {
                       this.body.endLine('{').indentMore();
                       return this;
                   },
                   closeBlock: function () {
                       this.body.indentLess().printLine('}');
                       return this;
                   },

                   addStatement: function (s) {
                       this.body.printLine(s + ';');
                       return this;
                   },

                   toString: function () {
                       return this.head.toString() + '\n' +
                           this.body.toString();
                   }
               },
               {
            	   capitalizeFirstLetter: function(s) {
            		   return s.charAt(0).toUpperCase() + s.slice(1);
            	   },

            	   capitalizeAllFirst: function(name, capitalizeFirst) {
            		   var l = name.replace(/_/g, ' ').toLowerCase().split(' '), r = [], i, s;
            			
            		   if (2 <= l.length && l[0].length === 1 && l[1].length === 1)
            			   capitalizeFirst = true;
            			
            		   i = 0;
            		   if (!capitalizeFirst) {
            			   r.push(l[0])
            			   ++i;
            		   }
            		   for (; i < l.length; ++i)
            			   r.push((0 < l[i].length) ? this.capitalizeFirstLetter(l[i]) : '_');
            			
            		   return r.join('');
            	   },
            		
            	   makeMethodName: function(prefix, name) {
            		   return prefix + this.capitalizeAllFirst(name, true);
            	   },
            	   makeMemberName: function(name) {
            		   return '_' + this.capitalizeAllFirst(name, false);
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
                   fw.write(String(s));
                   fw.close();
               },

               //
               CodeWriter: CodeWriter
           };
       });
