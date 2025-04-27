<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    		Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
12/05/2024  50627    Twinkle Shah    12/05/2024		Ramesh Goli        ML-MMOH-CRF-2106
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <%
	request.setCharacterEncoding("UTF-8");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
 %>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCA/js/CAConsultationTagReport.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>

<script language="javascript" >
function fnChangeCriteria(obj)
{
if(obj=="CACONTAGDTL")
{ 
document.getElementById('patEncounterRow').style.display="inline";
}
else
{
document.getElementById('patEncounterRow').style.display="none";
document.getElementById('p_patient_id').value=''
clearEncounterList() ;
} 	
}
</script>
</head>
<form name="ConsulationTagReportForm" id="ConsulationTagReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
			Connection con =null;
			PreparedStatement stmtLen = null,stmt = null;
			PreparedStatement pstmt=null;
			PreparedStatement stmtVt = null;
			ResultSet rsVt = null ;
			ResultSet rset = null,rsetLen = null;
			String p_from_date="";
			String p_to_date="";
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");
				p_to_date= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
				p_from_date	= com.ehis.util.DateUtils.minusDate(p_to_date,"DMY",locale,1,"Y");
				con = ConnectionManager.getConnection(request);
				String  sql = "select PATIENT_CLASS, AM_GET_DESC.AM_PATIENT_CLASS(PATIENT_CLASS,?,'2') SHORT_DESC  from  am_patient_class where patient_class in ('OP','IP','EM','DC') order by 2";		
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,locale);
				rset = pstmt.executeQuery();
%>
<table width='80%' align='center' valign='top' cellpadding='3'>
<td class='columnheader' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
</td>
</table>
<tr>
<td width="100%" class="Border" align='center'>
<table border=0 width='80%' cellPadding="3" cellSpacing="0"  align='center' >
					<tr>
					<td  colspan=1 class="label"><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
					<td colspan=1 ><input type=textbox size=11 maxlength=10 name='p_fm_Date' id='p_fm_Date' value="<%=p_from_date%>" onblur='return Check_Date(this,"DMY","<%=locale%>");' OnKeyPress='return CheckForNumsAndColon(event)' ><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_fm_Date');" >
					<img align='center'  src='../../eCommon/images/mandatory.gif'> 
					</td>
					<td  colspan=1 class="label"><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
					<td><input type=textbox size=11 maxlength=10 value="<%=p_to_date%>" name='p_to_Date' onblur='return checkingDate(this,"DMY","<%=locale%>")' OnKeyPress='return CheckForNumsAndColon(event)'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_to_Date');" >
					<img align='center'  src='../../eCommon/images/mandatory.gif'>
					</td>				

		
					</tr>
					<tr>
					<td class='label' width=25%><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td class='fields' width=25% >	<select name='p_patient_class' id='p_patient_class' onblur='populateEncounter();'>
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<% 
								String patientClass = "";
								String selected = "";
								while (rset.next())
								{
									patientClass = rset.getString("PATIENT_CLASS")==null?"":rset.getString("PATIENT_CLASS");
								%>	
									<option value='<%=patientClass%>'<%=selected%>><%=rset.getString("SHORT_DESC")%></option>
								<%}								 
							 if(rset!=null)rset.close();
							 if(pstmt!=null)pstmt.close();
							 %>
						</select>
					</td>
					<td width='25%'  class="label"><fmt:message key="eCA.patientCategoryType.label" bundle="${ca_labels}"/></td>
						<td class='fields' width ='25%'><select name='p_pat_cate_type' id='p_pat_cate_type' onblur='populateEncounter();'> 
						<option value=''><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value='N'><fmt:message key="Common.Public.label" bundle="${common_labels}"/></option>
						<option value='Y'><fmt:message key="Common.FPP.label" bundle="${common_labels}"/> </option>   
						</select>
						</td>
					</tr>
					<tr>
					<td width='25%'  class="label"><fmt:message key="eCA.ReportType.label" bundle="${ca_labels}"/></td>
						<td class='fields' width ='25%'><select name='p_report_id' id='p_report_id' onchange="fnChangeCriteria(this.value);"> 
                        <option value='CACONTAGSUM'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						<option value='CACONTAGDTL'><fmt:message key="eCA.Detailed.label" bundle="${ca_labels}"/> </option>   
						</select>
						</td>
						</tr>
					<tr id="patEncounterRow" style="display:none" >
						<td width='20%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="fields" width='25%' ><input type=textbox value='' size=14 maxlength=20 name=p_patient_id id=p_patient_id onblur='populateEncounter();'>
						<input type='button' name='btnPatID' id='btnPatID' value='?' class='button' onclick='callPatientSearch()'>
						</td>				
<td class='label' id='id_encounter'  width='25%' nowrap ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
<td class='fields' name='p_encounter_id' width='25%'><select name='p_encounter_id' id='p_encounter_id'><option value=''><fmt:message key="eCA.All.label" bundle="${ca_labels}"/></option>
</select>
</td>						
</tr>
		</table>
		<input type=hidden name='p_facility_id' id='p_facility_id' value='<%=facility_id%>'> 
		<input type=hidden name=p_status id=p_status value=''> 
		<input type=hidden name='p_language_id' id='p_language_id' value='<%=locale%>'> 
		<input type=hidden name=p_user_id id=p_user_id value="<%=user_id%>"> 
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="CA">
</form>
</html>

<%
}
catch ( Exception e) 
{
         e.printStackTrace();
}
finally 
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
			
 }
%>

