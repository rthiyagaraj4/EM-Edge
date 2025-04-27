<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

Connection con = null;
try
{
request.setCharacterEncoding("UTF-8");
String locale					=	 (String)session.getAttribute("LOCALE");
con = ConnectionManager.getConnection(request);
Statement stmt = con.createStatement();
ResultSet rs					=	null;
ResultSet rs1				=	null;

String Patient_Id = request.getParameter("Patient_ID");
String Patient_Name = "";
String Suspend_Yn ="";
String Deceased_Yn ="";
String Pat_Details="";
//String patdtl = "select get_patient_line(?,?) from dual";
String remark_to_diaplay="";
String made_read_only="";

try {
	StringBuffer sbQuery = new StringBuffer("Select decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Patient_Name,Suspend_Yn,Deceased_Yn,status_remarks from Mp_Patient where Patient_Id='");
	sbQuery.append(Patient_Id);
	sbQuery.append("'");
	rs = stmt.executeQuery( sbQuery.toString() );
	if(rs != null) {
		if(rs.next()) {
			Patient_Name = rs.getString("Patient_Name") == null ? "" : rs.getString("Patient_Name");
			Suspend_Yn = rs.getString("Suspend_Yn")==null ? "N" : rs.getString("Suspend_Yn");
			Deceased_Yn = rs.getString("Deceased_Yn")==null ? "N" : rs.getString("Deceased_Yn");
			remark_to_diaplay= rs.getString("status_remarks")==null ? "" : rs.getString("status_remarks");
			
			if (Suspend_Yn.equals("Y"))made_read_only = "DISABLED";
			if (Suspend_Yn.equals("N")) remark_to_diaplay ="";		
		}
	}
	/*pstmt = con.prepareStatement(patdtl);
	pstmt.setString(1, Patient_Id);
	pstmt.setString(2, locale);
	rset = pstmt.executeQuery();
	if(rset !=null) {
		if(rset.next()) {
			Pat_Details = rset.getString(1);
		}
	}*/
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/SuspendReinstatePatient.js" language="javascript"></script>
<Script Language="JavaScript">
function foc()
{
	<% if(Suspend_Yn.equals("N")){%>
		document.SuspendReinstatePatient.Reason.focus();
	<%}else{%>
	   document.SuspendReinstatePatient.Reinstatement_Remarks.focus();
	<%}%>

}
</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad='CheckDeceased("<%=Deceased_Yn%>");fieldFocus();startBlink();' onKeyDown = 'lockKey()'>
<form name="SuspendReinstatePatient" id="SuspendReinstatePatient" action="../../servlet/eMP.SuspendReinstatePatientServlet?Patient_Id=<%=Patient_Id%>" method="post" target="messageFrame">
<center>
<br>
<!-- <table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td  class='PATIENTLINECOLOROTHLANG' width='90%' id='patdetails' style='position:relative;'>&nbsp;</td>
		<TD style='background-color:red' align='center' id='nam' nowrap></TD>
	 	<td class='PATIENTLINECOLOR' width='30%' align='right'><img name='nam' src='../../eCommon/images/Status.gif'><img name='nam1' src='../../eCommon/images/Status.gif'></td>
	</tr>
</table> -->
<table border="0" cellpadding="3" cellspacing="0" width="100%">
	<tr>
		<td width='100%' class="BORDER">
			<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<td class='label' width='15%'>&nbsp;</td>
					<td class="label" width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> 
						<%
							if(Suspend_Yn.equals("Y")) out.println("<td width='65%' class='fields' ><input type='text' name='Patient_Status' id='Patient_Status' size='15' maxlength='15' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels")+"' readonly></td>");
							else out.println("<td ><input type='text' name='Patient_Status' id='Patient_Status' size='15' maxlength='15' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels")+"' readonly></td>");
						%>
				</tr>
				<tr>
					<td  class=label>&nbsp;</td>
				   <td  class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
				   <td  class='fields'>
						<% if(Suspend_Yn.equals("N")) out.println("<input type='text' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspend.label","common_labels")+"' size='15' name='Action_1' id='Action_1' disabled> <input type='hidden' value='Suspend' name='Action' id='Action'>");
						else out.println("<input type='text' size='15' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reinstate.label","common_labels")+"' name='Action_1' id='Action_1' disabled> <input type='hidden' value='Reinstate' name='Action' id='Action' >");
						%>  
				   </td>
				</tr>
				<% if(Suspend_Yn.equals("N")) { %>
				<tr>
					<td class=label>&nbsp;</td>
				   <td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				   <td  class='fields'><Select name="Reason" id="Reason" >
				   <Option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				   <%
					rs1 = stmt.executeQuery("Select Reason_Code,Short_Desc from mp_pat_susp_reason_lang_vw where eff_status = 'E' and language_id = '"+locale+"'  order by short_desc");
					if(rs1 !=null){
						while(rs1.next()) out.println("<Option value='"+ rs1.getString("Reason_Code") + "'>" +rs1.getString("Short_Desc") );
					}%>
					</Select>
			<%	}  
				else out.println("<input type='hidden' name='Reason' id='Reason' value=\"\" >");                      
				
				if(rs != null) rs.close();
				if(rs1 != null) rs1.close();	
				if(stmt != null) stmt.close();	
			    }
				catch(Exception e){
				   
				   e.printStackTrace();
				   }
				   %>
				  &nbsp;<%if (Suspend_Yn.equals("N")){%><img src='../images/mandatory.gif'></img><% } %>
				   </td>
				</tr>
				<tr>
					<td class=label>&nbsp;</td>
				   <td class="label" valign="center"><fmt:message key="eMP.suspensionremarks.label" bundle="${mp_labels}"/></td>
				   <td  class='fields'><TextArea name="Suspension_Remarks" rows="5" cols="45"<%=made_read_only%>><%=remark_to_diaplay%></TextArea> </td>
				</tr>
				<% if(Suspend_Yn.equals("Y")) { %>
				<tr>
					<td class=label>&nbsp;</td>
				   <td  class="label" valign="center"><fmt:message key="eMP.reinstatementremarks.label" bundle="${mp_labels}"/></td>
				   <td  class='fields'><TextArea name="Reinstatement_Remarks" rows="5" cols="45"></TextArea></td>
				</tr>
				<% } else out.println("<input type='hidden' name='Reinstatement_Remarks' id='Reinstatement_Remarks' value=''"); %>
				<tr><td class=label colspan='3'>&nbsp;</td></tr>
			</table>
		</td>
	</tr>
</table>
</center>
</form>
</body>
<script>
	//GifBlink(escape("<%=Pat_Details%>"),"parent.frames[1].document")
/*var str='<%=Pat_Details%>';	
pat_line=str.substring(0,str.length-6);
document.getElementById('patdetails').firstElementChild.nodeValue = pat_line;*/
</script>
<%
	/*if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();*/
}
catch(Exception e){
	out.println(e);
	
	e.printStackTrace();
	}
finally	{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</html>

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

