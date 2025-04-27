<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
06/07/2020 	  		       Ram kumar S											AAKH-CRF-0122
-------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
%>
<html>
<script>
	var argArray = window.dialogArguments ;
	var fieldLegend = argArray[9];
	window.document.title = fieldLegend;
</script>

<title id="lookup_title"></title>
<iframe name="lookup_head" id="lookup_head" src="../../eBL/jsp/cptLookupSearch.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:17vh;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail" src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:73vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eBL/jsp/cptLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>
</html>

