<!DOCTYPE html>
<!-- Access Rights.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suresh.S
*	Created On		:	23 Sept 2004
--%>
<html>
<head>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/AccessRights.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String source="";
String params="";
String url ="";
try
{
	url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	params = request.getQueryString() ;
	source = url + params ;
}
catch(Exception exp)
{
	out.println(exp.toString());
}
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:85vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
</html>

