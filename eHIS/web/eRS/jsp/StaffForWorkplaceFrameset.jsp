<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<html>
<head>
<title><fmt:message key="eRS.StaffForWorkplace.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="JavaScript" src="../js/RSCommon.js"></script>

<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>
<script language="javascript" src="../js/StaffForWorkplace.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='frameSearch' id='frameSearch' src='../../eRS/jsp/StaffForWorkplaceAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:5vh;width:100vw'></iframe>
<iframe name= "frameSelect" src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:26vh;width:100vw'></iframe>
<iframe name="frameList" id="frameList" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:69-vh;width:100vw'></iframe>

</html>

