var NEWLINE_REPLACEMENT = "####" ; // A Global Variable
function convert(id)
{
	var textTyped = document.getElementById(id).value;
	
	var slpEncoding = document.getElementById("slp").checked;
	var hkEncoding = document.getElementById("hk").checked;
	var encoding = "ITRANS";
	var context = document.getElementById("context").value;
	
	if(slpEncoding == true)
	{
		encoding = "SLP";
	}
		
	else if(hkEncoding == true)
	{
		encoding = "HK";
	}
	var str = textTyped.split("\n");
	var newStr = "";
	for(var i = 0; i < str.length; i++)
	{
		newStr += str[i] + NEWLINE_REPLACEMENT;
	}
var url = context + "/transliterate.do?function=transform&param1=" + newStr + "&param2=" + encoding;

new Ajax.Request(url, { 
	asynchronous: true,
	 method: "get",
	   onComplete: function(request)
	    {updateElement(request.responseText, id)}
});
		
}


function updateElement(text, id)
{
	//The variable contains the text for Updating both Area2 and Area3 separated by the Random String "#$%" 
	//Hence we will split them into two parts below.
	
	//Unicode DVN Text
	var str = text.split("#$%");
	var str1 = str[0].split(NEWLINE_REPLACEMENT);
	var DVNText = "";
	for(var i = 0 ; i < str1.length; i++)
	{
		DVNText += str1[i];
		if( i != str1.length - 1 )
		 DVNText += "\n"
	}
	document.getElementById(id+2).value = DVNText;
	
	//ELatin Text
	var str2 = str[1].split(NEWLINE_REPLACEMENT);
	var eLatinText = "";
	for(var i = 0 ; i < str2.length; i++)
	{
		eLatinText += str2[i];
		if( i != str2.length - 1 )
		 eLatinText += "\n"
	}
	document.getElementById(id+3).value = eLatinText;
	
	var str3 = str[2];
	document.getElementById('characterCounter').value = str3;
	
}