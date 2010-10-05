function convert(id)
{
alert('the id is : ' + id) ;
	var textTyped = document.getElementById(id).value;
	alert('ddd' + textTyped);
	var slpEncoding = document.getElementById("slp").checked;
	alert(slpEncoding);
	var hkEncoding = document.getElementById("hk").checked;
	var encoding = "ITRANS";
	var context = document.getElementById("context").value;
	alert(encoding);
	if(slpEncoding == true)
		{
			encoding = "SLP";
		}
	
	else if(hkEncoding == true)
		{
			encoding = "HK";
		}
alert(encoding);
		
var url = context + "/performSandhi.do?function=transform&param1=" + textTyped + "&param2=" + encoding;
new Ajax.Request(url, { 
	asynchronous: true,
	 method: "get",
	   onComplete: function(request)
	    {updateElement(request.responseText, id)}
});
		
}

function updateElement(text, id)
{
	document.getElementById(id+2).value = text;
}

function alterCheckBox(id)
{
	var chkBox = document.getElementById(id).checked;
	var context = document.getElementById("context").value;
	
	var url = context + "/performSandhi.do?function=setChkBox&param1=" + id + "&param2=" + chkBox;
	new Ajax.Request(url);
 
}

function clearSandhiFields()
{
	document.getElementById('pp').value="";	
	document.getElementById('up').value="";
	document.getElementById('sr').value="";
	document.getElementById('pp2').value="";
	document.getElementById('up2').value="";
	document.getElementById('sr2').value="";
	document.getElementById('padanta').checked=false;
	document.getElementById('pragrhya').checked=false;
	
}

function clearPratyaharaFields()
{
	document.getElementById('pratyahara').value="";
	document.getElementById('transformedPratyahara').value="";
	document.getElementById('marker').checked=false;
}