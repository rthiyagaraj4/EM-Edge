<!DOCTYPE html>
<html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>

<%	
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
Connection  con = null ;
Statement stmt1 = null ;
ResultSet rset  = null ;

try{
    con=ConnectionManager.getConnection(request);
	stmt1 = con.createStatement();	
	String StartDate= request.getParameter("StartDate")==null?"":request.getParameter("StartDate");
	String Canceldays= request.getParameter("Canceldays")==null?"":request.getParameter("Canceldays");
	String bl_interfaced_yn= request.getParameter("bl_interfaced_yn")==null?"":request.getParameter("bl_interfaced_yn");
	String build_episode_rule= request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
	String assign_queue_num_by= request.getParameter("assign_queue_num_by")==null?"":request.getParameter("assign_queue_num_by");
	String queue_date= request.getParameter("queue_date")==null?"":request.getParameter("queue_date");
	
	String Patient_Id_Length= request.getParameter("Patient_Id_Length")==null?"":request.getParameter("Patient_Id_Length");
	String inc_arrive_cons_start_pats_yn= request.getParameter("inc_arrive_cons_start_pats_yn")==null?"N":request.getParameter("inc_arrive_cons_start_pats_yn");	
	String package_bl_install_YN= request.getParameter("package_enabled_yn")==null?"N":request.getParameter("package_enabled_yn");	
	String inc_arrive_cons_start_pats__chk=""; 
    String facilityId = (String) session.getValue( "facility_id" ) ;
	String locale = (String) session.getValue("LOCALE");
    String p_mode=request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");		
	String loginuser 	= (String) session.getValue( "login_user" ) ;   
	String Canceldays_display=DateUtils.convertDate(Canceldays,"DMY","en",locale);	

	
%>
<head>
       <!--  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
        <script language='javascript' src='../../eOP/js/ReviseVisit.js'></script>
		<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
	    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

</head>
<body onMouseDown="CodeArrest();" onLoad="FocusFirstElement();" onKeyDown ='lockKey();'>
<form name="SearchVisit" id="SearchVisit">
<br>
    <table  border="0" width='97%' cellspacing='0' cellpadding='2' align="center">
		<tr width='100'>   
			<input type='hidden' name='sys_date' id='sys_date' value='<%=StartDate%>'></input>
			<input type='hidden' name='p_mode' id='p_mode' value='<%=p_mode%>'></input>
			<input type='hidden' name='sys_date1' id='sys_date1' value='<%=Canceldays%>'></input>	
			<td class="label" width='25%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			  <td class='fields'>
				<input type="text"  name="visit_adm_date_time" id="visit_adm_date_time"  value='<%=Canceldays_display%>' size='10' maxlength='10' onblur='if(validDateObj(this,"DMY",localeName))chkWithSysDt(this);'><img name= "dob" src='../../eCommon/images/CommonCalendar.gif'   id = 'dob'  onClick="return showCalendar('visit_adm_date_time');"style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
			  </td>
			<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			  <td class='fields'>
			  <INPUT TYPE="text" name="assign_care_locn_code1" id="assign_care_locn_code1"  onBlur="onBlurgetLoc('<%=facilityId%>','<%=locale%>','<%=oper_id%>','<%=loginuser%>','<%=p_mode%>',document.forms[0].assign_care_locn_code1);PractEnableDisable(this);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=facilityId%>','<%=locale%>','<%=oper_id%>','<%=loginuser%>','<%=p_mode%>',document.forms[0].assign_care_locn_code1);PractEnableDisable(this);">
			  <input type="hidden" name="assign_care_locn_code" id="assign_care_locn_code">	
			</td>
	 </tr>
	 <tr>
			<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text"  name="patient_id" id="patient_id" align="left" size='15' maxlength='<%=Patient_Id_Length%>' onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);"><input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
			</td>	
			<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
			<td class='fields'><input type="text"  name="encounter_id" id="encounter_id" align="left" size='12' maxlength='12' onKeyPress='return(ChkNumberInput(this,event,0))'>
			</td>	
	 </tr>
	  <tr>
		   <td class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="pract_name1" id="pract_name1" maxlength="30" size="30" onBlur="callPractSearch(document.forms[0].pract_butt,pract_name1);" readOnly><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" onClick="callPractSearch(this,pract_name1);" disabled ><input type="hidden" name="practitioner_id" id="practitioner_id" value="">
		</td>
	
	<%
		/* Modified for CRF - PMG20089-CRF-0541 (IN08081)
			Modified by Suresh M
			New Checkbox is introduced in Cancel Visit Function.This checkbox gets enable based on OP Parameter setup.
		*/
		if(p_mode.equals("CANCELVISIT")) {%>
	
	 <td class='label' nowrap id = 'Include1' style="visibility:hidden"><fmt:message  key="eOP.IncludeArrivedConsStartedPatients.label" bundle="${op_labels}"/></td><td id = 'Include2' style="visibility:hidden"><input type='checkbox'  name='inc_arrive_cons_start_pats' id='inc_arrive_cons_start_pats' value="N" <%=inc_arrive_cons_start_pats__chk%>></td></td>
	 </tr>
	 <tr>
	 <td><td>
	 	 <%}%>
	   <td  colspan=2 align='right'><input type="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='CallDescFrame()' class='button'><input type="button" name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class='button' onClick='ClearFrame()'></td>
	
    </tr>
  </table>

        <input type="hidden" name="where_criteria1" id="where_criteria1">
        <input type="hidden" name="where_criteria2" id="where_criteria2">
		<input type='hidden' name="whereCriteria" id="whereCriteria">
		<input type='hidden' name="oper_id" id="oper_id" value="<%=oper_id%>">
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
		<input type='hidden' name="facilityId" id="facilityId" value="<%=facilityId%>">
		<input type='hidden' name="inc_arrive_cons_start_pats_yn" id="inc_arrive_cons_start_pats_yn" value="<%=inc_arrive_cons_start_pats_yn%>">
		<input type='hidden' name="open_to_all_pract_yn" id="open_to_all_pract_yn" value="">
		<input type='hidden' name="package_bl_install_YN" id="package_bl_install_YN" value="<%=package_bl_install_YN%>">
		<input type='hidden' name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
		<input type='hidden' name="queue_date" id="queue_date" value="<%=queue_date%>">
		<input type='hidden' name="assign_queue_num_by" id="assign_queue_num_by" value="<%=assign_queue_num_by%>">
		<input type='hidden' name="build_episode_rule" id="build_episode_rule" value="<%=build_episode_rule%>">

	<script >
		
		if(document.forms[0].p_mode.value == "CANCELVISIT") {			
			if (document.getElementById("inc_arrive_cons_start_pats_yn").value == 'N') {
				document.getElementById("Include1").style.visibility='hidden';
				document.getElementById("Include2").style.visibility='hidden';				
			 } else {
				document.getElementById("Include1").style.visibility='visible';
				document.getElementById("Include2").style.visibility='visible';
			}
		}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


        </form>
 <%
		if(rset!=null)rset.close();
		if(stmt1 != null) stmt1.close();	
  }catch (Exception e) {
	  e.printStackTrace();
	  }

finally{
		try
		{
		 if(rset != null) rset.close();
		 if(stmt1 != null) stmt1.close();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	if(con!=null) ConnectionManager.returnConnection(con,request);
		}

%>
</body>
</html>

