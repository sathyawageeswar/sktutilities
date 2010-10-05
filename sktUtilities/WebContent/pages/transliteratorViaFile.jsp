<%@page pageEncoding="UTF-8"%>
<%@ include file="/pages/taglibs.jsp" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>

<script language="javascript">
function doUpload() {
	if (jcap() == false)
	{
		return false;
	}
}	
</script>
<script src="js/jcap.js" type="text/javascript"></script>
<script src="js/md5.js" type="text/javascript"></script>


<bean:define id="cols" value = "100" />  
<bean:define id="rows" value = "7" />     
 Welcome to <html:link page="/html/transliterator.html" target="_blank">Transliterator</html:link>       
<html:form action="/transliterateViaFile?function=transliterateFromFile"
    onsubmit="clearFields('fileArea2','fileArea3');return validateTransliteratorViaFileForm(this);"
	enctype="multipart/form-data" style="padding:0px; margin:0px;"
	method="POST">
	
	<!-- Begin Validator Javascript Function-->
				<html:javascript formName="transliteratorViaFileForm" dynamicJavascript="true"
					staticJavascript="true" />
				<!-- End of Validator Javascript Function-->
	<%-- This Variable will be used several times to get the Context Path--%>
	<bean:define id="contextPath">
		<%=StringUtils.isBlank(request.getContextPath()) ? "/" : request.getContextPath() + "/"%>
	</bean:define>	
<table>
<tr>
<td colspan="3">
<logic:notEmpty name="valMsg" scope="request">${valMsg}</logic:notEmpty>
</td>
</tr>
<tr><td>
<html:errors/>
</td></tr>
<tr>
<td><bean:message key="transliterator.convert.file"/></td>
<td><html:file property="file"></html:file>[ <bean:message key="transliterator.file.size.limit.warning" />]</td> 
</tr>
<tr><td></td></tr>
</table>

<tr><td></td></tr>

<tr><td>
<%@ include file="/pages/encodingOptions.jsp" %>
</td></tr>


<tr>
	<td>Enter the code as it is shown:</td>
</tr>
<tr>
	<td><input type=text name="uword" id="uword" value="" size=20></td>
</tr>
<tr>
	<td>This field helps prevent automated access.</td>
</tr>
<tr>
	<td><script language="javascript" type="text/javascript">cimg('${contextPath}')</script>
<noscript>[This resource requires a Javascript enabled
browser.]</noscript>
</td>
</tr>

<tr><td>
<html:submit tabindex="2" onclick="return doUpload();"><bean:message key="transliterate" /> </html:submit>
<button tabindex="3" onclick="clearFields('fileArea2', 'fileArea3')"><bean:message key="clear.all.text" /> </button>
</td></tr>

<tr><td><bean:message key="area2"/></td></tr>
<tr>
<td>
<html:textarea property="textInDVN" styleId="fileArea2" cols="${cols}" rows="${rows}" readonly="true"/>
</td>
</tr>


<tr><td><bean:message key="area3"/></td></tr>
<tr>
<td>
<html:textarea property="textIneLatin" styleId="fileArea3" cols="${cols}" rows="${rows}"  readonly="true"/>
</td>
</tr>
</html:form>