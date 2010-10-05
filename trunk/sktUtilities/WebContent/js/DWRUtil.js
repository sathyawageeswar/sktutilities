// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (DWRUtil == null) var DWRUtil = {};
DWRUtil._path = '/sktUtilities/dwr';
DWRUtil.convertSimple = function(p0, p1, callback) {
  dwr.engine._execute(DWRUtil._path, 'DWRUtil', 'convertSimple', p0, p1, callback);
}
DWRUtil.convertComplicated = function(p0, p1, p2, callback) {
  dwr.engine._execute(DWRUtil._path, 'DWRUtil', 'convertComplicated', p0, p1, p2, callback);
}
