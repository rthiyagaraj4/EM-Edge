<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/PoCommon.js"></script>	
<script language="JavaScript" src="../js/MasterType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe name='master_type_list' id='master_type_list' src='../jsp/MasterTypeFrame.jsp?<%=request.getQueryString()%>'  scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
<iframe name='master_type_detail' id='master_type_detail' src='../jsp/AddMasterType.jsp?<%=request.getQueryString()%>' scrolling='no' style='height:80vh;width:100vw'></iframe>
 
</html>

