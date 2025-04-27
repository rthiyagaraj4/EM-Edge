<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*,  eST.Common.* , eCommon.Common.*" %>
<head>  	
	<script language="JavaScript" src="../../eST/js/ParentStoreForStore.js"></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script type="text/javascript">
function create() {
	f_query_add_mod.location.href = "../../eST/jsp/ParentStoreForStoreFrames.jsp?mode=" + MODE_INSERT;
}
</script>

<%
    //String     mode = request.getParameter( "mode" ); %>
	
</head>
	<iframe name="headerFrame" id="headerFrame" frameborder=0  scrolling="no" noresize src="../../eST/jsp/ParentStoreForStoreAddModifyHeader.jsp?<%=request.getQueryString()%>" style="height:17vh;width:100vw"></iframe>
	<iframe name ="parentStoreFrame" id ="parentStoreFrame" frameborder=0 noresize  scrolling="no" src="../../eCommon/html/blank.html" style="height:42vh;width:100vw"></iframe>
	<iframe name ="modifyFrame" id ="modifyFrame" frameborder=0 noresize scrolling="no" src="../../eCommon/html/blank.html" style="height:41vh;width:100vw"></iframe>

</html>

