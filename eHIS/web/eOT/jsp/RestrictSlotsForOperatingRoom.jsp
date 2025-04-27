<!DOCTYPE html>
<!-- CRF-004 Authorize Slots for Booking - Rajesh V New page added for including Authorized users-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<title><fmt:message key="eOT.AuthorizeUsers.Label" bundle="${ot_labels}"/></title>
<Script Language="JavaScript" src="../../eOT/js/OperatingRooms.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<script language="javascript">
function assign(obj){
	 formObj = document.restrictSlots;
	 var str = obj.value;
	 var arr = str.split("##");
	 formObj.role_id.value=arr[0];
	 formObj.role_type.value=arr[1];
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
String operRoom = request.getParameter("oper_room")==null?"":request.getParameter( "oper_room" );
int totRows = 0;

Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;

%>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<fmt:setBundle basename="eCommon.resources.Labels" var="ot_labels"/>
<form name="restrictSlots" id="restrictSlots" action="../../servlet/eDL.TempServlet" method="post" target="messageFrame">
<br>
<br>
<table width="100%" border='1' cellpadding='0' cellspacing='0' align='center' height='20'>
			<tr>
					
				<th valign='top' class='ColumnHeaderCenter' style="display:block;visibility:visible;color:white;font-size:8pt;font-weight: bolder;text-align: left;padding-left:7px;padding-right:7px;">
					<fmt:message key="eOT.AssignUser.Label" bundle="${ot_labels}"/>
				</th>
				
			</tr>
</table>
<table  border='0' cellpadding=3 cellspacing='0' width='100%' align="center">
<tr> 
			<td class="label" width='30%'>
					<fmt:message key="Common.name.label" bundle="${common_labels}"/>
			</td>
			<td class="fields" width='70%'>
				<input type='hidden' name='practitioner_id' id='practitioner_id' >
			<input type='text' name='practitioner_name' id='practitioner_name' size='20' onblur="if(this.value!='')searchDoctor(practitioner_id,practitioner_name); else practitioner_id.value='';"  >			
			<input type='button' class='button' value='?' name='DoctorLookUp' id='DoctorLookUp' 	onClick='searchDoctor(practitioner_id,practitioner_name);'  > <img src='../../eCommon/images/mandatory.gif'></img>
			</td>
</tr>
 <tr>
			<td width='25%'class="button" colspan="2">
					<input type='button' name='record' id='record' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='selectRecord1();'  >
					<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancelRecord();' >
			</td>
	
</tr>
</table>
<br>
<br>
<br>
<br>
						<div id="listContentLayer"
						style="display:block;visibility:visible;overflow:auto;height:280;width:600;"
						align="center">
						<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' id="listContentTable" >
							<tr>
								<td width="40%" class="columnheadercenter" nowrap> 
									<fmt:message key="Common.userid.label" bundle="${common_labels}"/>
								</td>
								<td width="60%" class="columnheadercenter" nowrap> 
									<fmt:message key="Common.name.label" bundle="${common_labels}"/>
								</td>					
							</tr>
							<%
							try{
								con = ConnectionManager.getConnection(request);
								String sqlUsers = "select appl_user_id,appl_user_name from OT_OPER_ROOM_USER where operating_facility_id = ? and oper_room_code = ?";
								pstmt = con.prepareStatement(sqlUsers);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,operRoom);
								rst = pstmt.executeQuery();
								int i=2;
								int j=0;
								while(rst.next()){%>
									<input type="hidden" name="nutMode<%=j %>" id="nutMode<%=j %>" value="U">
									<tr>
										<td><a href="javascript:callfn12(<%=i%>)"><%=rst.getString("appl_user_id") %></a></td>
										<td><%=rst.getString("appl_user_name") %></td>
									</tr>
									<%i++; 
									j++;%>
								<%}
								pstmt = null;
								rst = null;
								totRows = j;
							}
						
							catch(Exception e){
								System.err.println("Exception in operation users:"+e);
							}
				
							finally{
								try{
									if(pstmt!=null) pstmt.close();
									if(rst!=null) rst.close();
									ConnectionManager.returnConnection(con);
								}
								catch(Exception e){
									System.err.println("Exception in operation users:"+e);
								}
							}
						%>
						</table>
						</div>
<br>
<input type='button' name='record' id='record' class='button' value='Save' onClick='tempSubmit();'  >
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="role_id" id="role_id" value="">
<input type="hidden" name="role_type" id="role_type" value="">
<input type="hidden" name="idForPract" id="idForPract" value="">
<input type="hidden" name="totalRows" id="totalRows" value="<%=totRows%>">
</form>
</body>
</html>

