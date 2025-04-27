<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	 String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script Language='javaScript' src='../../eCommon/js/common.js'></script>
<script>
function selectEncounter(plcyEnctr){
    window.returnValue = plcyEnctr;
    window.close();
}
</script>

<html>
<head>
<title> <%= request.getParameter("title")%></title>
</head>
<table>
<tr>
<th>Encounter ID </th>
<th>Across Enc group ID</th>
<th>Cust Group Code Description</th>
<th>Cust Code Description</th>
<th>Policy Type code</th>
<tr>

<%
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	request.setCharacterEncoding("UTF-8");

	try
	{
		con	=	ConnectionManager.getConnection(request);	
		stmt = con.createStatement();
		
		String custGrpCode =	 request.getParameter("cust_group_code");
		String custCode =		 request.getParameter("cust_code");
		String policyTypeCode =  request.getParameter("policy_type_code");
		String custGrpDesc =	 request.getParameter("ins_cust_group_name");
		String custDesc =		 request.getParameter("payer_desc");
		String policyTypeDesc =  request.getParameter("policy_type_desc");
		String patientID =  request.getParameter("patient_id");
		String patClass=request.getParameter("patClass");
		
				
			String qryPart=" where   a.ACROSS_ENCOUNTERS_YN = 'Y'  ";
			if(patClass.equalsIgnoreCase("OP")){
			qryPart=" where   a.ACROSS_ENCOUNTERS_YN = 'Y'  ";
			}
			if(patClass.equalsIgnoreCase("IP")){
			qryPart=" where   a.IP_ACROSS_ENCOUNTERS_YN = 'Y'  ";
			}
			if(patClass.equalsIgnoreCase("EX")){
			qryPart=" where   a.EX_ACROSS_ENCOUNTERS_YN = 'Y'  ";
			}	
		
		
		String query_ref_source = 
				 		  " select distinct(b.ENCOUNTER_ID),b.ACROSS_ENC_GROUP_ID,b.cust_group_code,b.cust_code ,b.policy_type_code   "+
						  " from bl_ins_policy_type_hdr a, bl_ins_policy_addl_hdr b          "+
						  qryPart+
						  " and  B.ACROSS_ENC_GROUP_ID is not null  "+
						  " and  a.cust_group_code = b.cust_group_code  "+
						  " and  a. cust_code     =  b.cust_code  "+
						  " and  a.policy_Type_code = b.policy_type_code  " +
						  " and  b.cust_group_code  = '"+custGrpCode+"'" + 
						  " and  b.cust_code        =  '"+custCode+"'" +
						  " and  b.policy_type_code =  '"+policyTypeCode+"'" +
						  " and  b.patient_id =  '"+patientID+"'" +
						  " and sysdate between NVL(a.POLICY_EFF_FROM,SYSDATE-1) and NVL(a.POLICY_EFF_TO,SYSDATE) "
						  ;
		rs = stmt.executeQuery(query_ref_source);
		while(rs.next())
		{			
			String encounterID	=	rs.getString(1);
			String acrossEncGrpID = rs.getString(2);
			%>
			<tr>
			<td class='fields'><a href='#' onClick="selectEncounter('<%=acrossEncGrpID%>')"><%=encounterID %></a></td>
			<td class='fields'><%=acrossEncGrpID %></td>
			<td class='fields'><%=custGrpDesc %></td>
			<td class='fields'><%=custDesc %></td>
			<td class='fields'><%=policyTypeDesc %></td>
			</tr>
			<%
		}
		
	}
	catch(Exception e) 
	{
		//out.println("Exception : "+e);
		e.printStackTrace();
	}
	finally
	{
		if (rs != null)   rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con, request);
	}	
%>
	
</table>
</html>

