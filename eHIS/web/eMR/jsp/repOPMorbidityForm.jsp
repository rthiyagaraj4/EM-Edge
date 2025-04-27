<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
 
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "MR" ;
	//String p_report_id		= "MROPCSMB" ;
	String p_facility_id		= (String) session.getAttribute( "facility_id" ) ;
	String p_user_name	= (String) session.getAttribute( "login_user" ) ;
	String locale = checkForNull((String)session.getAttribute("LOCALE"));
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

	/*Commented by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349*/
	/*function getMainGroupId()
    {
 		
		var target= document.forms[0].Main_Group_desc;
		//var main_group=document.forms[0].Main_Group.value;
		//var report_gr_id = document.forms[0].Report_Id.value;
		var retVal	=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code="";
		var title=getLabel("Common.LevelDesc.label","Common");
		
		var sql="select group_code, group_desc from mr_report_grouping where REPORT_ID = `MROPCSMB` and group_category = `M`"
		
		
		search_code="group_code";
		search_desc="group_desc";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title)+"&dispDescFirst=dispDescFirst",arguments,features);
	   
	    var arr=new Array();
	    if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    document.forms[0].Main_Group_desc.value=arr[0];
			document.forms[0].Main_Group.value=arr[1];
			document.forms[0].Main_Group_desc.focus();
		}
	}*/

	/*Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349*/
	function callReportid(obj)
	{
		if(obj.value=="D")
		{
			//document.forms[0].Main_Group_desc.disabled=false;
			//document.forms[0].sub_group11_level2.disabled=false;
            document.forms[0].p_report_id.value="MROPCSMB";

		}
		else
		{
			//document.forms[0].Main_Group_desc.value='';
			//document.forms[0].Main_Group_desc.disabled=true;
			
			//document.forms[0].sub_group11_level2.disabled=true;
			document.forms[0].p_report_id.value="MROPCSMS";
		}

	}
	</script>

</HEAD>

<% 
Connection con = null;
try
{
	con = ConnectionManager.getConnection(request);	
%>

<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="mychangerepOPMorbidity()">
<br>
<br>
<form name="repOPMorbidityForm" id="repOPMorbidityForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' >

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' border='0'>
				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="report_type" id="report_type" onchange='mychangerepOPMorbidity()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
						 <td >&nbsp; </td>
				</tr>
				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
					<td colspan ='3'></td>
				<tr>
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td><td> </td>
						<td align='left' id='MY3' > &nbsp; </td><td> </td>
						<td  > &nbsp;  </td>
				</tr>
				<!-- <tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr> -->
				
			<tr>
             <!-- <td width='30%' align='right' class='label' nowrap>Tab List &nbsp;&nbsp;</td>
             <td align='left'>
               <input name='p_fm_tab_list' id='p_fm_tab_list' onkeypress='return ValidStringrepOPMorbidity(event)' value='' size='5' maxlength='4' ><input type='button' name='tablist' id='tablist' value='?' class='button' onclick='searchCoderepOPMorbidity(this, p_fm_tab_list)'>
              </td>
              <td align='left'>
               <input name='p_to_tab_list' id='p_to_tab_list' onkeypress='return ValidStringrepOPMorbidity(event)' value='' size='5' maxlength='4' ><input type='button' name='tablist' id='tablist' value='?' class='button' onclick='searchCoderepOPMorbidity(this, p_to_tab_list)'>
			   <td>&nbsp;</td>
             </td> -->
          </tr>
                 <tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
					<Td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					
				<td align="right" class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>
			    <td>
					<!--Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349-->
					<SELECT name='p_location_type1' id='p_location_type1' onchange='clearvalrepOPMorbidity();getVisitType();' >
					<!--<option value="">------- All -------</option>
					<option value="A"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>-->
					<option value=''> ------------ <fmt:message key="Common.all.label" bundle="${common_labels}"/> ------------ </option>
					<option value='ED'><fmt:message key="eMR.EmergencyDepartment.label" bundle="${mr_labels}"/></option>
					<option value='SC'><fmt:message key="Common.SpecialistClinic.label" bundle="${common_labels}"/></option>
					<!--<option value='ST'><fmt:message key="Common.Staff.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>-->
					<option value='ST'><fmt:message key="eMR.SpecialClinic.label" bundle="${mr_labels}"/></option><!--Added by Suji Keerthi for ML-MMOH-SCF-1708-->
					<option value='PU'><fmt:message key="Common.PAC.label" bundle="${common_labels}"/></option>
					</SELECT>&nbsp;&nbsp;</td>
				<td>		
				<input type="text" name="p_clinic" id="p_clinic" onkeypress='return ValidStringrepOPMorbidity(event)' size="4" maxlength="4"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepOPMorbidity(p_location_type1,p_clinic)'>
				</td>
				<td>&nbsp;</td>
				</tr>
				<tr>
					<td > &nbsp;</td>
					<td  >&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>					
				</tr>
				
				<!--Added by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349-->
				<tr>
					<td class='label' width="20%" align='right' ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
					<td class='querydata' width="20%">
						<select name="p_visit_type" id="p_visit_type" disabled>
							<option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
						</select>
					</td>
				</tr>

				<tr>
					<td > &nbsp;</td>
					<td  >&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>					
				</tr>

				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
					<SELECT name="p_type" id="p_type" onchange="callReportid(this);">
					<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="M"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</SELECT>
					</td>
					<td >&nbsp; </td>
					<td >&nbsp; </td>
				</tr>
         <tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
		<Td>&nbsp;</td>
		<Td>&nbsp;</td>
		</tr>
		<!--Commented by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349-->
		<!--<tr>
		   <td align='right' width='35%' class="label"><fmt:message key="Common.LevelDesc.label" bundle="${common_labels}"/>&nbsp;</td>
			<td colspan='2'><textarea cols='50' rows='3' value='' readonly name="Main_Group_desc"></textarea>
<input type="button"  name="sub_group11_level2" id="sub_group11_level2"  value="?" class="BUTTON" onClick="getMainGroupId();"><input type="hidden"  name="Main_Group" id="Main_Group">
			</td>-->
		  <!-- <td><img src='../../eMP/images/mandatory.gif' style="visibility:hidden" id='mand_gif1'></td> -->
		<!--</tr>-->
		<tr>
		<td>&nbsp;</td>
		<Td>&nbsp;</td>
		<Td>&nbsp;</td>
		<Td>&nbsp;</td>
		</tr>
		</table>
	</td>
</tr>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="MROPCSMB">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="language_id" id="language_id"	value="<%= locale %>">

</form>
</BODY>

<%
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

