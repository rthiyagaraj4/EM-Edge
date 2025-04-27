<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
</head>
<title id="lookup_title"><%=request.getParameter( "title" )%></title>
<iframe name="lookup_head" id="lookup_head" src="../../eOT/jsp/AT_NameLookupCriteria.jsp" noresize   marginheight="0" marginwidth="0" style="height:17vh;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no"  marginheight="0" marginwidth="0" style="height:73vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eOT/jsp/AT_NameLookupCancel.jsp" noresize   marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>
</html>

