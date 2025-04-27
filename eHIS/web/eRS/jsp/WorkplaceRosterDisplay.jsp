<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Karabi S.
*	Created On		:	10th Dec 2004-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/WorkplaceRoster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='f_query__select' id='f_query__select'src='../../eRS/jsp/WorkplaceRosterCriteria.jsp' frameborder=no scrolling=no noresize style='height:25vh;width:100vw'></iframe>
<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style='height:5vh;width:100vw'></iframe><iframe name='f_query_details' id='f_query_details' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style='height:70vh;width:100vw'></iframe>
</html>

