<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
%>

<html>
<script>
	var argArray = window.dialogArguments ;
	var fieldLegend     = argArray[9];
	window.document.title=fieldLegend;
	
</script>
<title id="lookup_title"></title>
<iframe name="lookup_head" id="lookup_head" src="../../eCommon/jsp/CommonLookupSearchCriteria.jsp" noresize   marginheight="0" marginwidth="0" style="height:17vh;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no"  marginheight="0" marginwidth="0" style="height:37vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eCommon/jsp/CommonLookupCancel.jsp" noresize   marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>


</html>

