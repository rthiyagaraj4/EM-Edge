<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<!-- To give title to the Show Similar Items look up-->
<title><fmt:message key="eMM.SimilarItems.label" bundle="${mm_labels}"/></title>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/MmCommon.js"></script>	
<script language="JavaScript" src="../js/Item.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script language="JavaScript" src="../js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 -->
<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0" scrolling="no" style="height:0vh ;width:100vw"></iframe><iframe name="detailsFrame" id="detailsFrame"  
	noresize src='../../eMM/jsp/ItemQueryResult.jsp?<%=request.getQueryString()%>' frameborder="" scrolling="no" style='height:100vh;width:100vw'></iframe> 
</html>

