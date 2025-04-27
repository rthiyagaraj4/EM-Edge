<!DOCTYPE html>
<html>
<title id="lookup_title"><%=request.getParameter( "title" )%></title>
<iframe name="lookup_head" id="lookup_head" src='../../eRS/jsp/RSCommonLookupSearchCriteria.jsp?title=<%=request.getParameter( "title" )%>' noresize  frameborder="no" marginheight="0" marginwidth="0" style='height:17vh;width:100vw'></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:73vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eCommon/jsp/CommonLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>
</html>

