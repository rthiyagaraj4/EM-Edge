<!DOCTYPE html>
<!-- New file MealAcknowledgementStatus.jsp created against ML-MMOH-CRF-1061-->
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id	= (String)session.getAttribute("facility_id");
	String locale = (String) session.getAttribute("LOCALE");
%>

	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eDS/js/MealAcknowledgementStatus.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="changeStatus_OP();changeStatus_IP();">
		<br>
		<form target="messageFrame" name="MealAcknowledgementStatusForm" id="MealAcknowledgementStatusForm">
<%
   int noOfStatusRequired_OP = 0;
   String patient_class_OP="OP";
   String status_code_OP="";
   String status_desc_OP="";
   String patient_class="";
   String status_desc1="";
   String status_desc2="";
   String status_desc3="";
   String status_code1="";
   String status_code2="";
   String status_code3="";
   String OPstatus_Ser_YN="";
   String OPstatus_Acc_YN="";
   String OPstatus_Rej_YN="";
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			String sql = "",sql_OPstatus="";
	try{
			con=ConnectionManager.getConnection(request);
			
		sql= "SELECT patient_class, status_code, status_desc FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 4 AND patient_class ='"+patient_class_OP+"' ORDER BY patient_class, disp_sl_no DESC";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();	
		while (rs != null && rs.next()) {
		patient_class = checkForNull(rs.getString(1));
		status_code_OP = checkForNull(rs.getString(2));
		status_desc_OP = checkForNull(rs.getString(3));	
			if(patient_class.equalsIgnoreCase("OP")){
				if(status_code_OP.equalsIgnoreCase("MS")){
						status_code1 = rs.getString(2);
						status_desc1 = rs.getString(3);
				}else if(status_code_OP.equalsIgnoreCase("MA")){
						status_code2 = rs.getString(2);			
						status_desc2 = rs.getString(3);
				}else if(status_code_OP.equalsIgnoreCase("MR")){
						status_code3 = rs.getString(2);				
						status_desc3 = rs.getString(3);
				}
			}
		}
		
			sql_OPstatus= "Select NO_OF_ACK_STATUS_OP from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
			stmt=con.prepareStatement(sql_OPstatus);
			rs=stmt.executeQuery();
			while (rs != null && rs.next()){
			noOfStatusRequired_OP = rs.getInt(1);
			}
	%>
			<tr>
				<td class="BORDER">
					<table border='0' cellpadding=3  cellspacing='0' width='100%'>
					<tr>
						<td class="COLUMNHEADERCENTER">
					   <b>
						<fmt:message key="eDS.DefineStatusForDocument/AcknowledgeOP/EMPatientMealOrder.Label" bundle="${ds_labels}"/>
						</b>
						</td>
					</tr>
				</td>
					<td class="BORDERX">
						<table border='0' cellpadding=3  cellspacing='0' width='100%'>
			<tr>	 
				<td align="left" class='label'>
					<fmt:message key="eDS.NumberOfStatusRequired.Label" bundle="${ds_labels}"/>
				</td>
				<td>
				    <select name="noOfStatusRequired_OP" id="noOfStatusRequired_OP" id="noOfStatusRequired_OP" onchange="changeStatus_OP(this);">
					<%if(noOfStatusRequired_OP==3){
					%>
				        <option value="3" selected>ALL</option>
					<%}else{
					%>
					    <option value="3">ALL</option >
					<%}%>
					<%if(noOfStatusRequired_OP==2){
					%>
						<option value="2" selected>2</option>
					<%}else{
					%>
					    <option value="2">2</option >
					<%}%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>					
			</tr>
			<tr name="OP_served" id="OP_served">
				<td align="left" class='label'>
					<fmt:message key="eDS.served.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left">
					<input type="text" name="served" id="served" value="<%=status_desc1%>" size="15" maxlength="15"/>
					<img src='../../eCommon/images/mandatory.gif'></img >
				</td>
			</tr>
			<tr name="OP_accept" id="OP_accept">
				<td align="left" class='label'>
					<fmt:message key="eDS.accept.Label" bundle="${ds_labels}"/>
				</td>
				<td>
				<input type="text" name="accept" id="accept" value="<%=status_desc2%>" size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr name="OP_reject" id="OP_reject">
				<td align="left" class='label'>
					<fmt:message key="eDS.reject.Label" bundle="${ds_labels}"/>
				</td>
				<td>
					<input type="text" name="reject" id="reject" value="<%=status_desc3%>"size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
						</table>
					</td>
				</tr>
				
			<input type="hidden" name="noOfStatusRequired_OP" id="noOfStatusRequired_OP" id="noOfStatusRequired_OP" value="<%=noOfStatusRequired_OP%>"/>
			<input type="hidden" name="served" id="served" id="served" value="<%=status_desc1%>"/>
			<input type="hidden" name="served1" id="served1" id="status_desc1" value="<%=status_desc1%>"/>
			<input type="hidden" name="accept" id="accept" id="accept" value="<%=status_desc2%>"/>
			<input type="hidden" name="accept1" id="accept1" id="status_desc2" value="<%=status_desc2%>"/>
			<input type="hidden" name="reject" id="reject" id="reject" value="<%=status_desc3%>"/>
			<input type="hidden" name="reject1" id="reject1" id="status_desc3" value="<%=status_desc3%>"/>
			<input type="hidden" name="patient_class_OP" id="patient_class_OP" id="patient_class_OP" value="<%=patient_class_OP%>"/>
			<input type="hidden" name="status_code1" id="status_code1" id="status_code1" value="<%=status_code1%>"/>
			<input type="hidden" name="status_code2" id="status_code2" id="status_code2" value="<%=status_code2%>"/>
			<input type="hidden" name="status_code3" id="status_code3" id="status_code3" value="<%=status_code3%>"/> 
			<input type="hidden" name="OPstatus_Ser_YN" id="OPstatus_Ser_YN" id="OPstatus_Ser_YN" value="Y"/>
			<input type="hidden" name="OPstatus_Acc_YN" id="OPstatus_Acc_YN" id="OPstatus_Acc_YN" value="Y"/>
			<input type="hidden" name="OPstatus_Rej_YN" id="OPstatus_Rej_YN" id="OPstatus_Rej_YN" value="Y"/>			
				
<%  
}catch (Exception e) {
			e.printStackTrace();
			System.err.println("156 Exception==" + e);
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con);
		}
%>			
		
<%
   int noOfStatusRequired_IP = 0;
   String patient_class_IP="IP";
   String status_code_IP="";
   String status_desc_IP="";
   String status_desc_MP="";
   String status_desc_MR="";
   String status_desc_MS="";
   String status_desc_MJ="";
   String status_code_MP="";
   String status_code_MR="";
   String status_code_MS="";
   String status_code_MJ="";
   String IPstatus_Pre_YN="";
   String IPstatus_Rec_YN="";
   String IPstatus_Ser_YN="";
   String IPstatus_Rej_YN="";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String sql_Query ="", sql_IPstatus="";

			try
		    {
		        conn=ConnectionManager.getConnection(request);	
		
		sql_Query= "SELECT patient_class, status_code, status_desc FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 4 AND patient_class ='"+patient_class_IP+"' ORDER BY patient_class, disp_sl_no DESC";
		pstmt=conn.prepareStatement(sql_Query);
		rst=pstmt.executeQuery();
		while (rst.next()){
		patient_class = checkForNull(rst.getString(1));
		status_code_IP = checkForNull(rst.getString(2));
		status_desc_IP = checkForNull(rst.getString(3));
			
			if(patient_class.equalsIgnoreCase("IP")){
				if(status_code_IP.equalsIgnoreCase("MP")){
						status_code_MP = rst.getString(2);
						status_desc_MP = rst.getString(3);
				}else if(status_code_IP.equalsIgnoreCase("MR")){
						status_code_MR = rst.getString(2);			
						status_desc_MR = rst.getString(3);
				}else if(status_code_IP.equalsIgnoreCase("MS")){
						status_code_MS = rst.getString(2);				
						status_desc_MS = rst.getString(3);
				}else if(status_code_IP.equalsIgnoreCase("MJ")){
						status_code_MJ = rst.getString(2);				
						status_desc_MJ = rst.getString(3);
				}
			}
		}
		
		sql_IPstatus= "Select NO_OF_ACK_STATUS_IP from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
			pstmt=conn.prepareStatement(sql_IPstatus);
			System.err.println("220 sql_IPstatus==>"+sql_IPstatus);
			rst=pstmt.executeQuery();
			while (rst != null && rst.next()){
			noOfStatusRequired_IP = rst.getInt(1);
			System.err.println("223 noOfStatusRequired_IP==>"+noOfStatusRequired_IP);
			}
		
	%>
		<tr>
			<td class="BORDER">
					<table border='0' cellpadding=3  cellspacing='0' width='100%'>
					<tr>
						<td class="COLUMNHEADERCENTER">
					   <b>
						<fmt:message key="eDS.DefineStatusForDocument/AcknowledgeMealPrepared/Served/Complaints.Label" bundle="${ds_labels}"/>
						</b>
						</td>
					</tr>	
					</td>
				</tr>
				<tr>
					<td width="100%" class="BORDERX">
						<table border='0' cellpadding=3  cellspacing='0' width='100%'>
							<td class="label" >
						<fmt:message key="eDS.NumberOfStatusRequired.Label" bundle="${ds_labels}"/>
					</td>
					<td>
				        <select name="noOfStatusRequired_IP" id="noOfStatusRequired_IP" id="noOfStatusRequired_IP"  onchange="changeStatus_IP(this)";>
				            <%if(noOfStatusRequired_IP==4){%>
								<option value="4" selected>ALL</option>
							<%}else{%>
								<option value="4">ALL</option >
							<%}%>
							<%if(noOfStatusRequired_IP==3){
							%>
								<option value="3" selected>3</option>
							<%}else{%>
								<option value="3">3</option >
							<%}%>
							<%if(noOfStatusRequired_IP==2){
							%>
								<option value="2" selected>2</option>
							<%}else{%>
								<option value="2">2</option >
							<%}%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
				   </td>					
				</tr>
			<tr name="IP_MealPrepared" id="IP_MealPrepared">
				<td align="left" class='label'>
					<fmt:message key="eOT.MealPrepared.Label" bundle="${ot_labels}"/>
				</td>
				<td>
				<input type="text" name="MealPrepared" id="MealPrepared" value="<%=status_desc_MP%>" size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr name="IP_MealReceived" id="IP_MealReceived">
				<td align="left" class='label'>
					<fmt:message key="eOT.MealReceived.Label" bundle="${ot_labels}"/>
				</td>
				<td>
				<input type="text" name="MealReceived" id="MealReceived" value="<%=status_desc_MR%>" size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
				<tr name="IP_MealServed" id="IP_MealServed">
				<td align="left" class='label'>
					<fmt:message key="eOT.MealServed.Label" bundle="${ot_labels}"/>
				</td>
				<td>
				<input type="text" name="MealServed" id="MealServed" value="<%=status_desc_MS%>" size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr name="IP_MealRejected" id="IP_MealRejected">
				<td align="left" class='label'>
					<fmt:message key="eOT.MealReject.Label" bundle="${ot_labels}"/>
				</td>
				<td>
				<input type="text" name="MealRejected" id="MealRejected"  value="<%=status_desc_MJ%>" size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>

					</table>
					</td>
				</tr>
			<input type="hidden" name="noOfStatusRequired_IP" id="noOfStatusRequired_IP" id="noOfStatusRequired_IP" value="<%=noOfStatusRequired_IP%>"/>
			<input type="hidden" name="patient_class_IP" id="patient_class_IP" id="patient_class_IP" value="<%=patient_class_IP%>"/>
			<input type="hidden" name="MealPrepared" id="MealPrepared" id="MealPrepared" value="<%=status_desc_MP%>"/>
			<input type="hidden" name="MealPrepared1" id="MealPrepared1" id="status_desc_MP" value="<%=status_desc_MP%>"/>
			<input type="hidden" name="MealReceived" id="MealReceived" id="MealReceived" value="<%=status_desc_MR%>"/>
			<input type="hidden" name="MealReceived1" id="MealReceived1" id="status_desc_MR" value="<%=status_desc_MR%>"/>
			<input type="hidden" name="MealServed" id="MealServed" id="MealServed" value="<%=status_desc_MS%>"/>
			<input type="hidden" name="MealServed1" id="MealServed1" id="status_desc_MS" value="<%=status_desc_MS%>"/>
			<input type="hidden" name="MealRejected" id="MealRejected" id="MealRejected" value="<%=status_desc_MJ%>"/>
			<input type="hidden" name="MealRejected1" id="MealRejected1" id="status_desc_MJ" value="<%=status_desc_MJ%>"/>
			<input type="hidden" name="status_code_MP" id="status_code_MP" id="status_code_MP" value="<%=status_code_MP%>"/>
			<input type="hidden" name="status_code_MR" id="status_code_MR" id="status_code_MR" value="<%=status_code_MR%>"/>
			<input type="hidden" name="status_code_MS" id="status_code_MS" id="status_code_MS" value="<%=status_code_MS%>"/>
			<input type="hidden" name="status_code_MJ" id="status_code_MJ" id="status_code_MJ" value="<%=status_code_MJ%>"/>
			<input type="hidden" name="IPstatus_Pre_YN" id="IPstatus_Pre_YN" id="IPstatus_Pre_YN" value="Y"/>
			<input type="hidden" name="IPstatus_Rec_YN" id="IPstatus_Rec_YN" id="IPstatus_Rec_YN" value="Y"/>
			<input type="hidden" name="IPstatus_Ser_YN" id="IPstatus_Ser_YN" id="IPstatus_Ser_YN" value="Y"/>
			<input type="hidden" name="IPstatus_Rej_YN" id="IPstatus_Rej_YN" id="IPstatus_Rej_YN" value="Y"/>
<%}catch (Exception e) {
			e.printStackTrace();
			System.err.println("254 Exception==" + e);
		} finally {
			if (rst != null) rst.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(conn);
		}
%>	

			<input type="hidden" name="function_id" id="function_id" value="DS_MEAL_ACKNOWLEDGEMENT_STATUS"/>
			<input type="hidden" name="moduleId" id="moduleId" value="DS"/>
			<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>"/>
			</form>
	</body>
</html>
		

