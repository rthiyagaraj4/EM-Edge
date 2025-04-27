<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%><html>

<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/ItemMovement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name="criteria" id="criteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/ItemMovementQueryCriteria.jsp" style="height:23vh;width:100vw"></iframe>
<iframe name="result" id="result" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:77vh;width:100vw"></iframe>
</html>


