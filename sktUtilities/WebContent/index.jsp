<%@ include file="/pages/taglibs.jsp" %>
<%@page import="com.dictionary.service.DictionaryService"%>
<%@page import="com.dictionary.util.SpringUtil"%>

<!-- Use of Scriptlets. Very unfortunate but a quick shortcut-->
<%
DictionaryService service = (DictionaryService) SpringUtil.getBean("DictionaryService");
service.getDictionaryDAO().logUserActivityToDB("Transliterator.Main Page", request.getRemoteAddr(), "");
%>
<logic:redirect action="transliteratorAction" />
