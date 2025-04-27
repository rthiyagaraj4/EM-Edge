<!DOCTYPE html>
<!--Created by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->
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
<iframe name="lookup_head" id="lookup_head" src="../../eMR/jsp/AllergenLookupSearch.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:17%;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail" src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:100vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eMR/jsp/AllergenLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10%;width:100vw"></iframe>

</html>

