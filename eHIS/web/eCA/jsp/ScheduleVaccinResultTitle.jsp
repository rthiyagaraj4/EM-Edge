<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    		Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
20/11/2013      IN040377		Chowminya 	   New Immunization report required Patient wise.
06/12/2013      IN045410        Chowminya      Link5:Two Immunization records are displayed in report,even though single record selected
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String facility_id = (String)session.getValue("facility_id");//IN040377
	String user_id = (String)session.getValue("login_user");//IN040377
%>
<html>
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;//uncommentted IN040377
String locale = (String) p.getProperty("LOCALE");//uncommentted IN040377
//String query_string = request.getQueryString(); 

String vac_sch_ref =request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
String vacc_categ_id =request.getParameter("vacc_categ_id")==null?"":request.getParameter("vacc_categ_id");
String encounter_id=request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");//IN040377
String patient_id  =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//IN040377
String check ="";
String disbl ="";
String val ="";
if(vac_sch_ref.equals("ALL"))
	{
		check="checked";
		disbl="";
		val="Y";
	}
	else
	{
		check="";
		disbl="disabled";
		val="";
	}


%>
<!-- <modifeid by Arvind @02-12-2008> -->
	  

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../js/ScheduleForVacination.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <head>
  </head> 
  <body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
   <form name="repPatImmun" id="repPatImmun" action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> <!--IN040377 included the action for report print  -->
		<table  cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
			<tr></tr>
			<tr> 
			<td class='label' width ='25%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></td>
			<td class='fields' width ='25%'><input type="checkbox" name="cbSchedule" id="cbSchedule"  onClick="setcbSchedule(this);callGrpBy(this);" <%= check %> <%=disbl%> value='<%=val%>'></td>
			<td class='label' width ='25%'><fmt:message key="eCA.Show.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class='fields' width ='20%'><select name='schedule_status' id='schedule_status' onchange='scheduleResByStatus(this)'> 
			<option value=''>----<fmt:message key="Common.all.label" bundle="${common_labels}"/>----</option>
			<option value='C'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
			<!-- 
			Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
			-->
			  <option value='DO'><fmt:message key="Common.Due.label" bundle="${common_labels}"/> & <fmt:message key="Common.Overdue.label" bundle="${common_labels}"/> </option>   
			
			<!--ends here.
			-->
			<option value='D'><fmt:message key="Common.Due.label" bundle="${common_labels}"/></option>
			<option value='L'><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></option>
			<option value='N'><fmt:message key="Common.NotAdministered.label" bundle="${common_labels}"/></option>
			<!-- 
				Added by kishore kumar N on 02-Nov-09, for CRF 0691.1 ,
			-->
			<option value='F'><fmt:message key="Common.Future.label" bundle="${common_labels}"/></option>
			<option value='O'><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></option>
			<!--ends here.
			-->
			</select>
			</td> <!-- IN040377 Start -->
			<td  width ='20%'><input type=button class=button name='print' id='print'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick='run()'></td>
			</tr> <!-- IN040377 end -->
			<tr>
			<!-- <td class='label' width ='25%'><fmt:message key="eCA.IncludeInErrRecs.label" bundle="${ca_labels}"/></td><td class='fields' width ='25%'><input type="checkbox" name="include_err" id="include_err"  onClick="scheduleResShowErr(this)" value='N'></td><td class='label' width ='25%'></td><td class='label' width ='25%'></td> -->
			<td class='label' colspan='2'>&nbsp;</td>
			<td class='fields' colspan='2'><input type="checkbox" name="include_err" id="include_err"  onClick="scheduleResShowErr(this)" value='N' style='display:none'></td>
			
			</tr>
		</table>
		
		<!--
			**** Modified by Kishore Kumar N on 11-sept-09, for CRF-691
			
		<table  id='patVaccTitle' border='0' width='100%' cellpadding='3' cellspacing=0>
		<tr> 
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="eCA.ActualDate.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'  width='' nowrap ><fmt:message key="eCA.BatchNumber.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
		 <td class='columnheadercenter'   width='' nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> 
		</tr> 
		</table>
		
		****** ends here.
		-->
		<!-- IN040377 Start --> 
		<input type=hidden name=p_facility_id value='<%=facility_id%>'> 
		<input type=hidden name=p_user_id value='<%=user_id%>'> 
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' value='<%=vac_sch_ref%>' name='vac_sch_ref'>
		<input type='hidden' value='' name='P_VAC_SCH_REF' id='P_VAC_SCH_REF'>
		<input type='hidden' value='<%=vacc_categ_id%>' name='vacc_categ_id'>
		<input type='hidden' value='CA' name='p_module_id' id='p_module_id'>
		<input type='hidden' value='<%=patient_id%>' name='p_patient_id'>
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
		<input type='hidden' value='' name='P_VACC_ID' id='P_VACC_ID'>
		<input type='hidden' value='' name='P_DOSE_NO' id='P_DOSE_NO'> <!--IN045410 -->
		<input type='hidden' value='Y' name='P_ONLINE_YN' id='P_ONLINE_YN'>
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="CAPATIMRPT">
		<!-- IN040377 End -->
		
		
    </form>
	
   </body>
</html>

