<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/MmCommon.js"></script>	
<script language="JavaScript" src="../js/BinLocation.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script language="JavaScript" src="../js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 -->

<iframe name='bin_location_store' id='bin_location_store' src='../jsp/BinLocationStoreFrame.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='bin_location_detail' id='bin_location_detail' src='../jsp/AddBinLocation.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' style='height:80vh;width:100vw'></iframe>
 
</html>

