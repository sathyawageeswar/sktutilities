<%@page pageEncoding="UTF-8"%>
<%@ include file="/pages/taglibs.jsp" %>

<bean:define id="cols" value = "100" />  
<bean:define id="rows" value = "4" />     
<html:link page="/html/transliterator.html" target="_blank">Transliterator</html:link>       
<html:form action="/transliterate?function=transliterate" styleId="transliteratorForm">
<table>
<tr><td align="right">
<html:link action="/transliterateViaFileAction" ><bean:message key="transliterator.convert.file"/></html:link> 
</td></tr>

<tr>
<td colspan="3">
<logic:notEmpty name="valMsg" scope="request">${valMsg}</logic:notEmpty>
</td>
</tr>

<tr><td>
<bean:message key="area1"/> [<bean:message key="transliterator.char.limit.as.str" /> <bean:message key="character.limit" />]
</td></tr>

<tr>
<td>
<div id="inputSpan"><html:textarea property="textInRoman" tabindex="1" styleId="area" cols="${cols}" rows="${rows}" onkeyup="convertComplicated('true')" /></div> 
</td>
</tr>
<tr><td></td></tr>
<tr>
<td>
<button onclick="clipBoardInput();"><bean:message key="clipboard" /></button>  
</td>
</tr>
<tr><td>
<%@ include file="/pages/encodingOptions.jsp" %>
</td></tr>

<tr>
<td align="right">
<bean:message key="transliterator.character.count" />: <html:text property="characterCounter" styleId="counter" size="5" readonly="true"/>
</td>
</tr>

<tr>
<td align="left">
<button tabindex="3" onclick="clearFields('area', 'area2', 'area3', 'counter')"><bean:message key="clear.all.text" /> </button> 
  
</td>
</tr>

<tr><td>
<bean:message key="area2"/>
</td></tr>
<tr>
<td>
<div id="dvnSpan"><html:textarea property="textInDVN" styleId="area2" cols="${cols}" rows="${rows}" readonly="true"/></div>
</td>
</tr>

<tr><td><button onclick="clipBoardDVN();"><bean:message key="clipboard" /></button></td></tr>

<tr><td><bean:message key="area3"/></td></tr>
<tr>
<td>
<div id="IASTSpan"><html:textarea property="textIneLatin" styleId="area3" cols="${cols}" rows="${rows}"  readonly="true"/></div>
</td>
</tr>
<tr><td><button onclick="clipBoardIAST();"><bean:message key="clipboard" /></button></td></tr>
<!--<tr>
<td>
<html:submit tabindex="2"><bean:message key="transliterate" /> </html:submit>
</td>
</tr>
-->
</table>
</html:form>