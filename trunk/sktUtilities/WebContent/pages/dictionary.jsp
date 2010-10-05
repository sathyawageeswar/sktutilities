<%@page pageEncoding="UTF-8"%>
<%@page import="com.dictionary.main.MainClass"%>
<%@ include file="/pages/taglibs.jsp" %>

<br>
<html:form action="/findWord.do?function=findMeaning" acceptCharset="UTF-8">
<bean:message key="welcome.dictionary"/> <html:link page="/html/dictionary.html" target="_blank"><bean:message key="sanskrit.dictionary"/> </html:link>
<h3><bean:message key="enter.dictionary.term"/></h3>
<table>
<tr>
<td>
<html:text name="dictionaryForm" property="entry" styleId="pp" tabindex="1" onkeyup="convertSimple('pp')"/>
</td>
</tr>
<tr>
<td>
<html:text name="dictionaryForm" property="transformedEntry" tabindex="0" readonly="true" styleId="pp2"/>
</td>
</tr>
<tr><td>
<%@ include file="/pages/encodingOptions.jsp" %>
</td></tr>

<tr><td>
<html:submit tabindex="3"/>
<button tabindex="4" onclick="clearFields('entry', 'transformedEntry')"><bean:message key="clear" /> </button>
</td></tr>

<tr><td>
<tr><td>
<html:radio property="searchType" value="<%=MainClass.EXACT%>"><%=MainClass.EXACT%> </html:radio>
<html:radio property="searchType" value="<%=MainClass.LEFT%>"><%=MainClass.LEFT%></html:radio>
<html:radio property="searchType" value="<%=MainClass.RIGHT%>"><%=MainClass.RIGHT%> </html:radio>
<html:radio property="searchType" value="<%=MainClass.ALL%>"><%=MainClass.ALL%> </html:radio>
</td></tr>
</td></tr>


<tr><td>
${dictionaryForm.notes }
</td></tr>
</table>
</html:form>
 




