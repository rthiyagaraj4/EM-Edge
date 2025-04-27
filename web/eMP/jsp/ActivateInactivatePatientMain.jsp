<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    Connection con = null;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    String locale			= (String)session.getAttribute("LOCALE");
    try
    {
		con = ConnectionManager.getConnection(request);
		Statement stmt = con.createStatement();
		ResultSet rs=null;
		ResultSet rs1=null;
		String Patient_Id = request.getParameter("Patient_ID");
		String Patient_Name = "";
		String Suspend_Yn ="";
		String Active_Yn ="";
		String Deceased_Yn ="";
		//String Pat_Details="";
		/*StringBuffer patdtl = new StringBuffer("select get_patient_line('");
		patdtl.append(Patient_Id+"','");
		patdtl.append(locale);
		patdtl.append("') from dual");*/
		String remark_to_diaplay="";
		String made_read_only="";
			StringBuffer sbQuery = new StringBuffer("Select decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Patient_Name,Suspend_Yn, Active_yn, Deceased_Yn,inact_act_remarks as status_remarks from Mp_Patient where Patient_Id='");
			sbQuery.append(Patient_Id);
			sbQuery.append("'");
			rs = stmt.executeQuery(sbQuery.toString());

			if(rs != null) 
			{
				if(rs.next()) 
				{
					Patient_Name = rs.getString("Patient_Name") == null ? "" : rs.getString("Patient_Name");
					Suspend_Yn = rs.getString("Suspend_Yn")==null ? "N" : rs.getString("Suspend_Yn");
					Active_Yn = rs.getString("Active_Yn")==null ? "Y" : rs.getString("Active_Yn");
					Deceased_Yn = rs.getString("Deceased_Yn")==null ? "N" : rs.getString("Deceased_Yn");
					remark_to_diaplay= rs.getString("status_remarks")==null ? "" : rs.getString("status_remarks");
					
					if (Active_Yn.equals("N"))made_read_only = "DISABLED";
					if (Active_Yn.equals("Y")) remark_to_diaplay ="";
                
				}
			}
		/*	rs1 = stmt.executeQuery(patdtl.toString());
			if(rs1 !=null) {
				if(rs1.next()) {
					Pat_Details = rs1.getString(1);
				}
			}*/
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
			<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
textarea {
  resize: none;
}
</style>
<body  OnMouseDown="CodeArrest()" onLoad='startBlink();' onKeyDown='lockKey();'>
<form name="ActiveInactivePatient" id="ActiveInactivePatient" action="../../servlet/eMP.ActivateInactivatePatientServlet?Patient_Id=<%=Patient_Id%>" method="post" target="messageFrame">
<center>
<br>
  <!--<table border="0" cellpadding="0" cellspacing="0" width="97%">
     <tr>
			<td  class='PATIENTLINECOLOROTHLANG' width='90%' id='patdetails' style='position:relative;'>&nbsp;</td>
			<TD style='background-color:red' align='center' id='nam' nowrap></TD>
			 <td class='PATIENTLINECOLOR' width='30%' align='right'><img name='nam' src='../../eCommon/images/Status.gif'><img name='nam1' src='../../eCommon/images/Status.gif'></td> 
     </tr>
  </table>-->
  
 <table border="0" cellpadding="3" cellspacing="0" width="97%">
  <tr>
		<td width='100% 'class="BORDER">
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
				<td class='label' width='20%'>&nbsp;</td>
				<td class='label' width='20%'>&nbsp;</td>
				<td class='label' width='60%'>&nbsp;</td>
		</tr>
        <tr>
				<td class='label'>&nbsp;</td>
			   <td class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			   <td >
				<% if(Active_Yn.equals("Y"))
				   { 
						out.println("<input type='text'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels")+"' name='Action_1' id='Action_1' size ='15' disabled> 			 <input type='hidden' value='Inactive' name='Action' id='Action'>");
					}
					else 
					{
						out.println("<input type='text'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels")+"'   name='Action_1' id='Action_1' size ='15'  disabled> 			 <input type='hidden' value='Active'   name='Action' id='Action' >");
					}
				%>  
				</td></tr>
				<% if(Active_Yn.equals("Y")) 
				{
				%>  
				<tr>
				<td class='label'>&nbsp;</td>
				<td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			   <td ><Select name="Reason" id="Reason" >
				<Option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</OPTION>
<%
           rs1 = stmt.executeQuery("Select Reason_Code,long_desc from mp_pat_inact_reason_lang_vw where  language_id = '"+locale+"' and eff_status = 'E' and reason_for_active_yn='N' order by short_desc");
            if(rs1 !=null)
			{
                while(rs1.next()) out.println("<Option value='"+ rs1.getString("Reason_Code") + "'>" +rs1.getString("long_desc")+"</OPTION>" );
             }
    } 
	else if(Active_Yn.equals("N")) 
	{ 
%>
      <tr>
				<td class='label'>&nbsp;</td>
				<td class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td ><Select name="Reason" id="Reason" >
			   <Option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
		<%
			   rs1 = stmt.executeQuery("Select Reason_Code,long_desc from mp_pat_inact_reason_lang_vw where   language_id = '"+locale+"' and eff_status = 'E' and reason_for_active_yn='Y' order by short_desc");
			   if(rs1 !=null)
			   {
					while(rs1.next()) out.println("<Option value='"+ rs1.getString("Reason_Code") + "'>" +rs1.getString("long_desc")+"</OPTION>" );
			   }
			}
			else out.println("<input type='hidden' name='Reason' id='Reason' value=''>");                      
		%>
		   </Select><%if (Active_Yn.equals("Y")){%><img src='../images/mandatory.gif'></img>
		<% } %>
                   </td>
        </tr>
		<tr>
		    <td class='label'>&nbsp;</td>
		   <td  class="label" valign="center"><fmt:message key="eMP.inactivationremarks.label" bundle="${mp_labels}"/></td>
		   <td ><TextArea name="Inactivate_Remarks" size=500 maxlength=500 rows="5" cols="45" <%=made_read_only%>><%=remark_to_diaplay%></TextArea> </td>
		</tr>
		  <tr><td class='label' colspan='3'>&nbsp;</td></tr>
<% if(Active_Yn.equals("N")) { %>
		<tr>
		   <td class='label'>&nbsp;</td>
		   <td  class="label" valign="center"><fmt:message key="eMP.activationremarks.label" bundle="${mp_labels}"/></td>
		   <td ><TextArea name="Activate_Remarks" rows="5" cols="45"></TextArea></td>
		</tr>
<% } else out.println("<input type='hidden' name='Activate_Remarks' id='Activate_Remarks' value=''"); %>
		<tr><td class='label' colspan='3'></td></tr>
	</table>
   </td>
   </tr>
  </table>
</center>
<input type='hidden' name='Active_Yn' id='Active_Yn' value='<%=Active_Yn%>'>
</form>
</body>

<%
    if(rs != null) rs.close();
    if(rs1 != null) rs1.close();
	if(stmt != null) stmt.close();
}
catch(Exception e){/* out.println(e); */ e.printStackTrace();}  
finally{
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

