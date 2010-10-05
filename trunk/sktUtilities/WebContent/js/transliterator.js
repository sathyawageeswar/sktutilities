function clipBoardDVN() 
{
var myVar = dvnSpan.innerText;
window.clipboardData.setData('text',myVar);
}
function clipBoardIAST() 
{
var myVar = IASTSpan.innerText;
window.clipboardData.setData('Text',myVar);
}

function clipBoardInput() 
{
var myVar = inputSpan.innerText;
window.clipboardData.setData('text',myVar);
}
	
