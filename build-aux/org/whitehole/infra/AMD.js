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
//
// Implement AMD API on top of Rhino.
//

(function () {
    'use strict';

    var modules = {};

    function trace(msg) {
        if (require.verbose)
            print(msg);
    }

    function traceLoadedModules() {
    	var k;

    	if (require.verbose) {
    		trace('Loaded modules:\n');
    		for (k in modules)
    			if (modules.hasOwnProperty(k))
    				trace('  ' + k + ' -> ' + modules[k] + '\n');
    	}
    }

    function loadModule(moduleName) {
        var modulePath = require.path + '/' + moduleName + '.js';

        var m = modules[moduleName];
        if (m === undefined) {
            modules[moduleName] = null;

            trace('Loading ' + moduleName + ' from ' + modulePath + '\n');

            load(modulePath);
        }
        else if (m === null)
            trace('Error: cycle detected!\n');

        return modules[moduleName];
    }

    function loadModules(moduleNames) {
        var i, n, l;

        l = [];
        for (i = 0; i < moduleNames.length; ++i) {
            n = moduleNames[i];
            l.push(loadModule(n));
        }

        return l;
    }

    function define(moduleName, dependencies, f) {
        trace('Defining ' + moduleName + '\n');
        modules[moduleName] = f.apply(undefined, loadModules(dependencies));
    };

    function require(dependencies, f) {
    	var d, i, k;
        trace('Entry point\n');
        
        d = loadModules(dependencies);
        
        traceLoadedModules();
        
        f.apply(undefined, d);
    };

    // Configuration
    require.path = '.';
    require.verbose = false;

    return {
        require: require,
        define: define
    };

} ());
