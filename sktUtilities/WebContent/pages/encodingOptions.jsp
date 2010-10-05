<%@page pageEncoding="UTF-8"%>
<%@page import="com.sktutilities.util.EncodingUtil"%>
<html:radio property="encoding" value="<%=EncodingUtil.ITRANS%>" styleId="itrans" >
<html:link page="/html/itrans.html" target="_blank"><bean:message key="itrans.scheme" /></html:link>
</html:radio>
<html:radio property="encoding" value="<%=EncodingUtil.HK%>" styleId="hk" >
<html:link page="/html/hk.html" target="_blank"><bean:message key="hp.scheme"/></html:link>
</html:radio>
<html:radio property="encoding" value="<%=EncodingUtil.SLP%>" styleId="slp" >
<html:link page="/html/slp.html" target="_blank"><bean:message key="slp.scheme"/></html:link>
</html:radio>
<html:radio property="encoding" value="<%=EncodingUtil.UNICODE_DVN%>" styleId="dvn" >
<html:link page="/html/dvn.html" target="_blank"><bean:message key="dvn.scheme"/></html:link>
</html:radio>
<html:radio property="encoding" value="<%=EncodingUtil.IAST%>" styleId="iast" >
<html:link page="/html/iast.html" target="_blank"><bean:message key="iast.scheme"/></html:link>
</html:radio>