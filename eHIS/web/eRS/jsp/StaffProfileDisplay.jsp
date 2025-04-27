<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Subbulakshmy. K
*	Created On		:	18 Oct 2004-->
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
<script language="javascript" src="../js/StaffProfile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name= "f_query__select" id="f_query__select" src='../../eRs/jsp/StaffSelect.jsp' frameborder=0 scrolling='auto' noresize style='height:11vh;width:100vw'></iframe>
<iframe name="f_query_details" id="f_query_details" src='../../eCommon/html/blank.html' frameborder=0 scrolling="auto" noresize style='height:89vh;width:100vw'></iframe>

</html>

