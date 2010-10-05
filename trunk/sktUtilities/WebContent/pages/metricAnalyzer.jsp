<%@page pageEncoding="UTF-8"%>
<%@ include file="/pages/taglibs.jsp" %>

<bean:define id="cols" value = "100" />  
<bean:define id="rows" value = "4" />     
 Welcome to <html:link page="/html/metricAnalyzer.html" target="_blank">Metric Analysis</html:link>   
 <%-- http://cs.annauniv.edu/insight/insight/chhandas/pages/typepage.htm --%>
 
<html:form action="/analyzeMetre?function=analyze">
<table>
<tr><td><bean:message key="area1"/></td></tr>
<tr>
<td>
<html:textarea property="chanda" tabindex="1" styleId="area" cols="${cols}" rows="${rows}" onkeyup="convertComplicated('false')"/>
</td>
</tr>
<tr>
<td align="right"><bean:message key="transliterator.character.count" />: <html:text property="characterCounter" styleId="counter" size="5" readonly="true"/></td>
</tr>

<tr><td><bean:message key="area2"/></td></tr>
<tr>
<td>
<html:textarea property="transformedchanda" styleId="area2" cols="${cols}" rows="${rows}" readonly="true"/>
</td>
</tr>


<tr><td>
<%@ include file="/pages/encodingOptions.jsp" %>
</td></tr>

<tr>
<td>
<html:submit tabindex="2"><bean:message key="analyze" /> </html:submit>
<button tabindex="3" onclick="clearFields('chanda', 'transformedchanda' , 'counter')"><bean:message key="clear" /> </button>
</td>
</tr>

<tr><td>
<c:if test="${varnaDistribution != null}">
<display:table name="varnaDistribution" id="row" pagesize="10" requestURI="">
<display:column property="varna" />
<display:column property="frequency" />
</display:table>
</c:if>

</td></tr>
</table>
</html:form>