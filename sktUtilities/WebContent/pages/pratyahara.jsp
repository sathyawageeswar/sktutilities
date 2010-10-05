<%@page pageEncoding="UTF-8"%>
<%@ include file="/pages/taglibs.jsp" %>
Welcome to <html:link page="/html/pratyahara.html" target="_blank">Pratyahar Decoder</html:link> 
<br>
<h3>Please enter a Pratyahara</h3>

<table>
<html:form action="/displayPratyahara.do?function=displayPratyahara">
<tr>
<td>
<table>
<tr>
<td>
<html:text name="pratyaharaForm" property="pratyahara" styleId="prat" tabindex="1" onkeyup="convertSimple('prat')"/>
</td>
<td><html:text name="pratyaharaForm" property="transformedPratyahara" styleId="prat2" readonly="true" /></td>
</tr>
</table>
</td>
</tr>

<tr>
<td>
<html:checkbox property="hideMarkers" styleId="marker" onchange="alterCheckBox('marker')"><html:link page="/html/marker.html"><bean:message key="hide.markers" /></html:link></html:checkbox>
</td>
</tr>

<tr>
<td>
<%@ include file="/pages/encodingOptions.jsp" %>
</td>
</tr>


<tr>
<td>
<html:submit tabindex="2"/>
<button tabindex="3" onclick="clearPratyaharaFields()"><bean:message key="clear" /> </button>
</td>
</tr>
</html:form>

<tr><td>
<bean:message key="long.form" />:
<br>
<br>
</td></tr>

<tr><td>
${pratyaharaForm.notes }
</td></tr>
</table>
