<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@include file="/pages/taglibs.jsp" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Sanskrit Utilities: <tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()%>/css/sandhi.css' />
</head>

<body>
<input type="hidden" value="<%=request.getContextPath() %>" id="context"/>
<script src="js/sandhi.js" type="text/javascript"></script>
<script src="js/prototype.js" type="text/javascript"></script>
<script src="js/transliterator.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/engine.js" type="text/javascript"></script>
<script src="js/util.js" type="text/javascript"></script>
<script src="js/DWRUtil.js" type="text/javascript"></script>
<script src="js/DWR.js" type="text/javascript"></script>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0"  bgcolor="#FFFFFF">
	<tr>
		<td><tiles:insert attribute="header" /></td>
	</tr>
</table>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
<tr><td><tiles:insert attribute="body"/></td></tr>
</table>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
<tr><td colspan="5"><tiles:insert attribute="footer"/></td></tr>
</table>
</body>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
var pageTracker = _gat._getTracker("UA-4445961-1");
pageTracker._initData();
pageTracker._trackPageview();
</script>
</html>