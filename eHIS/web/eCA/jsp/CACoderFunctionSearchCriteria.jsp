<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		          Rev.Date		 Rev.Name		        Description
--------------------------------------------------------------------------------------------------------------
03/08/2020		IN073540			chandrashekar raju											AAKH-CRF-0122.3
01/09/2020	        		        Chandra	                                            AAKH-SCF-0448
16/03/2022       41064             krishna pranay             16/03/2023     Ramesh Goli           AAKH-CRF-0172

---------------------------------------------------------------------------------------------------------------
*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD> 
	
	<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
	<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
  
<%
        Properties p;
		session 		              = request.getSession(false);
		p 				              = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale 	              = (String) p.getProperty("LOCALE");
        String bean_id				  = "CACoderFunction" ;
	    String bean_name			  = "eCA.CACoderFunction";
		CACoderFunction bean	      = (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
		String toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		Connection con	= null;//41064
		con = ConnectionManager.getConnection(request);//41064
		boolean siteSupervisor =eCommon.Common.CommonBean.isSiteSpecific(con,"CA","CA_SUPERVISOR_CLEARANCE");//41064
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
  <form name="coderFunctionCriteria" id="coderFunctionCriteria" >
			<table cellpadding=3 cellspacing=0 border=0  width="100%" align="center" >

			<tr >

			  <td align="right" class="label" colspan=""><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td align="left">
				<SELECT name="p_patient_class" id="p_patient_class" style="width:150px">
					<option value =""> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value ="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value ="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
				</select>
			</td>		
			<td class="label" nowrap colspan="1"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		    <td>&nbsp; <input type="text" name="p_encounter" id="p_encounter" maxlength="20" size="20" onKeyPress="return CheckForSpecChars(event);"></td>
     </tr>
	  <tr>
            <td class="label" nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="field" >
			<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" onBlur="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
			onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
			<td class="label" ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
			<td class="label" >&nbsp&nbsp<input type="text" name="dt_from" id="dt_from"  value='<%=frDate%>' onBlur='chkDateTime(this,"DMY","<%=locale%>","CODER");'
			 maxlength="10" size="10" >
			<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');"  onblur='dt_from.focus()'><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class="label" ><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
			<td class="label" ><input type="text" name="dt_to" id="dt_to" value='<%=toDate%>' maxlength="10" size="10" onBlur='chkDateTime(this,"DMY","<%=locale%>","CODER");'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" onblur='dt_to.focus()' ><img src='../../eCommon/images/mandatory.gif'></img></td>
	  </tr>
	   <tr >
	        <td align="right" class="label" ><fmt:message key="eCA.CodingStatus.label" bundle="${ca_labels}"/></td>
			<td align="left">
				<SELECT name="coding_status" id="coding_status" style="width:150px">
					
					<option value ="*A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value ="NW"><fmt:message key="Common.New.label" bundle="${common_labels}"/></option>
					<option value ="DQ"><fmt:message key="eCA.DoctorQuery.label" bundle="${ca_labels}"/></option>
					<option value ="SQ"><fmt:message key="eCA.SupervisorQuery.label" bundle="${ca_labels}"/></option>
					<option value ="HD"><fmt:message key="Common.Hold.label" bundle="${common_labels}"/></option>
					<option value ="PC"><fmt:message key="Common.PartiallyCompleted.label" bundle="${common_labels}"/></option>
					<option value ="CO"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
					<!-- 41064 start -->
					<% if(siteSupervisor){ %> 
					<option value ="SC"><fmt:message key="eCA.supervisorCleranceCompleted.label" bundle="${ca_labels}"/></option>
						<% }%>
					<!-- 41064 end -->

				</select>
			</td>		
			<td class=label id = 'viewlistlabel'  ><fmt:message key="eCA.viewlist.label" bundle="${ca_labels}"/></td>
		    <td class='fields' id = 'view_list_code'>&nbsp&nbsp
			    <select name='view_list_code' id='view_list_code' onchange = ";">
				  <option value = "*A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				  <option value = "SR"><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
			   </select>
		    </td>		
	    </tr>

		<tr>     
		     <td></td>
			 <td></td>
			 <td></td>
			 <td></td>
			 <td align="left" >
			   <input type="button" name="btnSearch" id="btnSearch" class="button"   value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'   onClick="showRecords()">
			   <input type="button" name="btnReset" id="btnReset" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="clearAll()">		
		     </td>
       </tr> 
 </table>
<input type='hidden' name ='locale' value ='<%=locale%>'/><!-- Added for AAKH-SCF-0448 -->
</form>

<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

