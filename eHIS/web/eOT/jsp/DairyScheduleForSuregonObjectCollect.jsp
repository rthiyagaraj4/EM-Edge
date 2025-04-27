<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script Language="JavaScript" src="../../eOT/js/Hashtable.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript">
	var rows = new Array();
	var hash = new Hashtable();
	//var lookUpTable = new Array();
	 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectCollectForm" id="ObjectCollectForm">
</form>
</body>
</html>

