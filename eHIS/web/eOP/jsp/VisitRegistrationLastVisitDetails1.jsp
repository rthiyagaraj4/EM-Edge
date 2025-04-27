<!DOCTYPE html>
<!-- 	Function Name VisitRegistration
	Created by M.Sathis Kumar on 13/12/2000 -->

<%@ page import ="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	//Connection con    = (Connection) session.getValue("connection");
	//PreparedStatement pstmt;
	//ResultSet rs;
	request.setCharacterEncoding("UTF-8");
	String 	l_encounter_id 		= request.getParameter("encounter_id");
	String 	l_service_encounter_id 	= request.getParameter("service_encounter_id");
%>

<html>
	<head>
		<title><fmt:message key="Common.LastVisitDetails.label" bundle="${common_labels}"/></title>
		<meta http-equiv="Expires" content="0">
		<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript'>
			function ButtonClick(flag)
			{
				window.returnValue="Y";
				window.close();
			}
			function show_detail(obj)
			{
				if (obj.value == "Y")
				{
					obj.value = "N";
					parent.frames[1].location.href = "../../eOP/jsp/VisitRegistrationLastVisitDetails2.jsp?encounter_id=<%=l_encounter_id%>";
				}
				else
				{
					obj.value = "Y";
					parent.frames[1].location.href = "../../eOP/jsp/VisitRegistrationLastVisitDetails2.jsp?encounter_id=<%=l_service_encounter_id%>";
				}

			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='content' topmargin='0' bottommargin='0' onKeyDown ='lockKey()'>
		<center>
		<form name='last_visit_detail' id='last_visit_detail'>
				<br>
				<table width='90%' border="0" cellpadding="0" cellspacing="0" align="center" valign="middle">
					<tr>
						<td class='label' align='center' width="30%" align="right">
							<fmt:message key="eOP.ForSpecifiedService.label" bundle="${op_labels}"/>
						</td>
						<td width="70%" align="left">
						<input type="checkbox" name="service_yn" id="service_yn" onClick="show_detail(this)"
						<%
							if (l_service_encounter_id.equals(""))
								out.println(" value='N' disabled>");
							else
								out.println(" value='N'>");
						%>
						</td>
					</tr>
				</table>
				<br>
		</form>
	</body>
</html>

