<!DOCTYPE html>
<!--
CRF/SCF Reference No 	:  ML-MMOH-CRF-1955
Detected Release  No  	:  SEPTEMBER 2023 Release 
File prepared by      	:  Lakshmanan P
File prepared date    	:  1-07-2023
Purpose of the Script   :  Mark Patient as Medico Legal Case (MLC) Patient and to revert the MLC marked patient as Non-MLC patient 				   
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites	
-->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eMP/js/MarkPatientMLC.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%

Connection con = null;
try
{
request.setCharacterEncoding("UTF-8");
String locale					=	 (String)session.getAttribute("LOCALE");
con = ConnectionManager.getConnection(request);
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rset					=	null;
ResultSet rs1				=	null;
String Patient_Id = request.getParameter("Patient_ID");
String mlc_yn="";
String sql="";
try {
	String sbQuery = "Select mlc_yn  from mp_patient where patient_id=?";
	pstmt = con.prepareStatement(sbQuery);
	pstmt.setString(1, Patient_Id);
	rset = pstmt.executeQuery();
	if(rset != null) {
		if(rset.next()) {
			mlc_yn=rset.getString("mlc_yn")==null ? "N" : rset.getString("mlc_yn");	
		}
	}
	if (pstmt!=null) pstmt.close();
	if (rset!=null) rset.close();		
	}
catch(Exception e){
	e.printStackTrace();
	}%>
<body  OnMouseDown="CodeArrest()" onLoad='' onKeyDown = 'lockKey()'>
<form name="MarkPatientMLC" id="MarkPatientMLC" action="../../servlet/eMP.MarkPatientMLCServlet" method="post" target="messageFrame">
<center>
<br>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
				<tr>
					<td width='100%' class="BORDER">
					<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<td  class=label>&nbsp;</td>
				   <td  class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
				   <td  class='fields'>
						<% if(mlc_yn.equals("N")) out.println("<input type='text' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.MLC.label","mp_labels")+"' size='15' name='Action_1' id='Action_1' disabled> <input type='hidden' value='Y' name='Action' id='Action'>");
						else out.println("<input type='text' size='15' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NonMLC.label","mp_labels")+"' name='Action_1' id='Action_1' disabled> <input type='hidden' value='N' name='Action' id='Action' >");
						%>  
				   </td>
				</tr>
				<tr>
				<%if(mlc_yn.equals("N")) {
					   sql="select CONTACT_REASON_CODE , CONTACT_REASON  from am_contact_reason   where mark_mlc_yn='Y' AND EFF_STATUS='E' order by CONTACT_REASON";
				   } else {
					   sql="select CONTACT_REASON_CODE , CONTACT_REASON  from am_contact_reason   where mark_nonmlc_yn='Y' AND EFF_STATUS='E' order by CONTACT_REASON";
				   } %>
					<td class=label>&nbsp;</td>
				   <td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				   <td  class='fields'><Select name="Reason" id="Reason" >
				   <Option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				   <%
				   stmt = con.createStatement();
					rs1 = stmt.executeQuery(sql);
					if(rs1 !=null){
						while(rs1.next()) out.println("<Option value='"+ rs1.getString("CONTACT_REASON_CODE") + "'>" +rs1.getString("CONTACT_REASON") );
					}%>
					</Select><%	  
				if(rs1 != null) rs1.close();	
				if(stmt != null) stmt.close();	
			    				   
				   %><img src='../images/mandatory.gif'></img>
				   </td>
				<tr><td class=label colspan='3'>&nbsp;</td></tr>
			</table>
		</td>
	</tr>
	<input type='hidden' name='Patient_Id' id='Patient_Id' value='<%=Patient_Id%>' />
</table>
</center>
</form>
</body>
</html>
<%
	}
	catch(Exception e){				   
	e.printStackTrace();
	}
finally	{
	if(con!=null) ConnectionManager.returnConnection(con,request);
} %>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

