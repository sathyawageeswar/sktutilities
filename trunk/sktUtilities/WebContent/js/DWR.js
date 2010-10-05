
function convertSimple(id) {

  var txt = dwr.util.getValue(id);
  var encoding = findEncoding();
  DWRUtil.convertSimple(txt, encoding  , function(data) {
    dwr.util.setValue(id + 2, data);
  });
  
}


function convertComplicated(eLatinRequired) {
  var txt = dwr.util.getValue("area");
  var encoding = findEncoding();
    DWRUtil.convertComplicated(txt, encoding , eLatinRequired,  function(data) {
    var str = data.split("#$%");
	document.getElementById("area2").value=str[0];
	dwr.util.setValue("characterCounter", str[1]);
	if(eLatinRequired != "false")
	{
	document.getElementById("area3").value=str[2]
	}
	
  });
}

function findEncoding()
{
  var slp = dwr.util.getValue("slp");
  var hk = dwr.util.getValue("hk");
  var dvn = dwr.util.getValue("dvn");
  var iast = dwr.util.getValue("iast");
  
  
  var encoding = "ITRANS";
  
  if(slp == true)
	{encoding = "SLP";}
		
	else if(hk == true)
	{encoding = "HK";}
	
	else if(dvn == true)
	{encoding = "DVN";}
	
	else if(iast == true)
	{encoding = "IAST";}
	
	return encoding;
}