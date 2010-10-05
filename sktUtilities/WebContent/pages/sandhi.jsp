<%@page pageEncoding="UTF-8"%>
<%@ include file="/pages/taglibs.jsp" %>
Welcome to <html:link page="/html/sandhi.html" target="_blank">Sandhi Engine</html:link>
<br>
<h3><bean:message key="enter.words"/></h3>

<table>
<html:form action="/performSandhi.do?function=performSandhi">
<tr>
<td>
<table>
<tr><td>
<html:text name="sandhiForm" property="purvaPada" styleId="pp" tabindex="1" onkeyup="convertSimple('pp')"/>
</td>
<td>
<html:text name="sandhiForm" property="uttaraPada" styleId="up" tabindex="2"  onkeyup="convertSimple('up')"/>
</td>
<td>
<html:text name="sandhiForm" property="samhitaPada" styleId="sr" tabindex="0" readonly="true" styleClass="txtBoxLarge" />
</td>
</tr>
</table>
</td>
</tr>


<tr>
<td>
<table>
<tr>
<td>
<html:text name="sandhiForm" property="transformedPurvaPada" tabindex="0" readonly="true" styleId="pp2"/>
</td>
<td>
<html:text name="sandhiForm" property="transformedUttaraPada" tabindex="0" readonly="true" styleId="up2"/>
</td>
<td>
<html:text name="sandhiForm" property="transformedSamhitaPada" tabindex="0" readonly="true"  styleId="sr2" styleClass="txtBoxLarge"/>
</td>
</tr>
</table>
</td>

<tr><td>
<html:checkbox property="padanta" styleId="padanta" onchange="alterCheckBox('padanta')"><bean:message key="padanta" /></html:checkbox>
<html:checkbox property="pragrhya" styleId="pragrhya" onchange="alterCheckBox('pragrhya')"><html:link page="/html/pragrhya.html"><bean:message key="pragrhya" /></html:link></html:checkbox>
</td></tr>


<tr><td>
<%@ include file="/pages/encodingOptions.jsp" %>
</td></tr>

<tr><td>
<html:submit tabindex="3"/>
<button tabindex="4" onclick="return clearSandhiFields()"><bean:message key="clear" /> </button>
</td></tr>
</html:form>

<tr><td>
${sandhiForm.notes }
</td></tr>
</table> 