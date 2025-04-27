<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/SRRPhUncollDrug.js"></script>
	
	
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	
<!-- <script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<script>
function chkFromToTime(Obj)
{
	//alert("Obj=========>" +Obj.value);
	if(Obj.value != '')
    {
		if(!validDateObj(Obj,"DMYHM",localeName))
		{
			
			Obj.select();
			return false;
		}
		else 
		if(!isBefore(Obj.value,document.getElementById("currdate").value,"DMYHM",localeName))
		{
			var err1 = getMessage("DATE1_GT_DATE2","IP");
			//var err1 = getMessage("TO_DT_GR_EQ_FM_DT","PH");
			err1 = err1.replace('$', getLabel("Common.entereddatetime.label","Common"));
			err1 = err1.replace('#', getLabel("Common.CurrentDateTime.label","Common"));
			alert(err1);
			Obj.value = "";
			Obj.focus();
			return false;
		}
		else
		{
		if((formPhUncollDrugCriteria.dt_from.value!="")&&(formPhUncollDrugCriteria.dt_to.value!=""))
			{
			var from  = formPhUncollDrugCriteria.dt_from;
			var to	  = formPhUncollDrugCriteria.dt_to;
				if(!isBefore(from.value,to.value,"DMYHM",localeName))
				{
					var err1 = getMessage("DATE1_GT_DATE2","IP");
					err1 = err1.replace('$', getLabel("Common.fromdate.label","Common"));
					err1 = err1.replace('#', getLabel("Common.todate.label","Common"));
					alert(err1);
					Obj.value = "";	
					Obj.focus();
					return false;
				}
			}

		}
    }
}

function chkFromToTime2(Obj)
{
	//alert("Obj=========>" +Obj.value);
	if(Obj.value != '')
    {
		if(!validDateObj(Obj,"DMYHM",localeName))
		{
			
			Obj.select();
			return false;
		}
		/*else 
		if(!isBefore(Obj.value,document.getElementById("currdate").value,"DMYHM",localeName))
		{
			var err1 = getMessage("DATE1_GT_DATE2","IP");
			err1 = err1.replace('$', getLabel("Common.entereddatetime.label","Common"));
			err1 = err1.replace('#', getLabel("Common.CurrentDateTime.label","Common"));
			alert(err1);
			Obj.value = "";
			Obj.focus();
			return false;
		}*/
		else
		{
		if((formPhUncollDrugCriteria.dt_from.value!="")&&(formPhUncollDrugCriteria.dt_to.value!=""))
			{
			var from  = formPhUncollDrugCriteria.dt_from;
			var to	  = formPhUncollDrugCriteria.dt_to;
				if(!isBefore(from.value,to.value,"DMYHM",localeName))
				{
					var err1 = getMessage("DATE1_GT_DATE2","IP");
					err1 = err1.replace('$', getLabel("Common.fromdate.label","Common"));
					err1 = err1.replace('#', getLabel("Common.todate.label","Common"));
					alert(err1);
					Obj.value = "";	
					Obj.focus();
					return false;
				}
			}

		}
    }
}










</script>




 </head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "SRRPhUncollDrugBean" ;
	String bean_name			= "ePH.SRRPhUncollDrugBean";
	SRRPhUncollDrugBean bean	= (SRRPhUncollDrugBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
	ArrayList facilityList       = bean.getMednFacilityList();
	String  all_access           = "";
	ArrayList displocationlist  = bean.getDispLocationList(all_access);

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");
	//Calling systemdate from bean:
	//String disp_date		= bean.getTodaysDate();
	//String from_date		= bean.getFromDate();

	String sys_date=(String) com.ehis.util.DateUtils.getCurrentDate("DMY",locale); //added sysdate on 30/12/09



//	out.println(dateList);

%>


<!-- <BODY onload="document.formPhUncollDrugCriteria.p_facility_code.focus();"> -->
<BODY onload="document.formPhUncollDrugCriteria.p_facility_code.focus();populateDispLocs(formPhUncollDrugCriteria.p_facility_code,'<%=locale%>')" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhUncollDrugCriteria.p_facility_code.focus();"> -->

<form name="formPhUncollDrugCriteria" id="formPhUncollDrugCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onChange="populateDispLocs(this,'<%=locale%>')">
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} %>
	<!--	  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> -->
	</tr>
	 <tr>
	 <!-- change the date format added time along with date on 30/12/09 -->
		<td class="label" ><fmt:message key="ePH.AllocatedDateFrom.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="1">&nbsp;<input type="text" maxlength="10" size="15" name="dt_from1" id="dt_from1" value="<%=sys_date%>" OnBlur='ChkDate(this)'> <!--ChcekDate changed to ChkDate for ICN 31195-->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');">&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> 
		<td COLSPAN="1" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
		<td COLSPAN="1">&nbsp;<input type="text" maxlength="10" size="15" name="dt_to1" id="dt_to1" value="<%=sys_date%>" OnBlur='ChkDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--CheckDate changed to ChkDate for ICN 31195-->

	</tr> 
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" width="30%">&nbsp;<SELECT name="p_disp_loc_code" id="p_disp_loc_code">
	   	</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>

			
	</tr>
<!-- Adding New column Patient-Id Lookup: and paymentstatus on 30/12/09-->
	<tr>
			<td  class="label" width='10%'nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
			<td>&nbsp;<input type="text" name="p_patient_id" id="p_patient_id" size="20" 
			maxlength="<%=bean.getPatientIDLength()%>" value="" onKeyPress="return CheckForSpecChars(event);changeToUpper()"> <INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.formPhUncollDrugCriteria.p_patient_id)" >
			</td>
			<td class="label" nowrap><fmt:message key="ePH.PaymentStatus.label" bundle="${ph_labels}"/></td>
		 <td>&nbsp;
		   <select name="paidstatus" id="paidstatus" >
					<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="P" ><fmt:message key="Common.Paid.label" bundle="${common_labels}"/></option>
					<option value="U" ><fmt:message key="ePH.UnPaid.label" bundle="${ph_labels}"/></option>
				</select>
		</td>
	</tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="30" size="30" value="" onblur="chkdrug()"><input type="button" class="button" value="?" name="drug_search" id="drug_search" onfocus="callDrugSearch(document.formPhUncollDrugCriteria.drug_name, 1)" onClick="callDrugSearch(document.formPhUncollDrugCriteria.drug_name, 1)"></td>
		<input type="hidden" name="drug_code" id="drug_code" value="">
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" maxlength="30" size="30" value="" onblur="chkdrug()"><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onfocus="callDrugSearch(document.formPhUncollDrugCriteria.tdrug_name, 2)" onClick="callDrugSearch(document.formPhUncollDrugCriteria.tdrug_name, 2)"></td>
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
	</tr>
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<!-- <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUNDRUGS"> -->
	 <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUNDRUGS"> 
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id1" id="p_language_id1" VALUE="<%=locale%>">
	<input type='hidden' name ='currdate' value="<%=sys_date%>">
	<INPUT TYPE="hidden" name="p_reprint" id="p_reprint" VALUE="Y">
	<!-- Added Hidden variables for date conversion regarding incident num:23336 on 31/Aug/2010 -->
	<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
	<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

