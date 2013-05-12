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

// Helpers to define/derive classes, roughly implementing WinJS API.
//

define('org/whitehole/infra/Class',
       [
       ],
       function () {
           'use strict';

           var initializingChild = {};

           var Class = {
               derive: function (BaseClass, constructor,
                                 instanceMembers, staticMembers) {

                   // Constructor (executed for each instantiation)
                   //
                   var T = constructor ? function () {
                       if (! (arguments.length === 1 &&
                              arguments[0] === initializingChild))
                           // Invoke user-defined constructor
                           constructor.apply(this, arguments);
                       // else: building super, do nothing.
                   }
                   : function () {};

                   // Definition (executed once per class)
                   //
                   var k, v;

                   if (BaseClass !== null)
                       // Chain prototypes
                       T.prototype = new BaseClass(initializingChild);

                   // Set instance members
                   if (instanceMembers)
                       for (k in instanceMembers) 
                           if (instanceMembers.hasOwnProperty(k)) {
                               v = instanceMembers[k];
                               if (v && (v.hasOwnProperty('get') ||
                                         v.hasOwnProperty('set')))
                                   Object.defineProperty(T.prototype, k, v);
                               else
                                   T.prototype[k] = v;
                           }

                   // Set static members
                   if (staticMembers)
                       for (k in staticMembers)
                           if (staticMembers.hasOwnProperty(k))
                               T[k] = staticMembers[k];

                   // Enforce the constructor to be what is expected
                   T.prototype.constructor = T;

                   return T;
               },

               define: function (constructor,
                                 instanceMembers, staticMembers) {
                   return this.derive(null, constructor,
                                      instanceMembers, staticMembers);
               }
           };

           return Class;
       });
