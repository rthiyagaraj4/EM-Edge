<!DOCTYPE html>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIP.advbedmgmt.transaction.assignbed.AssignBedConstants"%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.text.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
 	String sStyle = checkForNull(
 			(String) session.getAttribute("PREFERRED_STYLE"),
 			"IeStyle.css");
 %>
<html>
<%
	//data from request parameter
	String nuCode = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.NURSING_UNIT_REQ_PARAM));
	String nuDesc = CommonBean
			.checkForNull(request
					.getParameter(AssignBedConstants.NURSING_UNIT_DESC_REQ_PARAM));
	String specialtyCode = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.SPECIALTY_CODE_REQ_PARAM));
	String specialtyDesc = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.SPECIALTY_DESC_REQ_PARAM));
	String showNuPopup = CommonBean.checkForNull(request
			.getParameter(AssignBedConstants.SHOW_NU_POPUP_REQ_PARAM),
			AssignBedConstants.SHOW_NU_POPUP_DEFAULT_VALUE);
	String showSpecialtyPopup = CommonBean
			.checkForNull(
					request.getParameter(AssignBedConstants.SHOW_SPECIALTY_POPUP_REQ_PARAM),
					AssignBedConstants.SHOW_SPECIALTY_POPUP_DEFAULT_VALUE);

	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rset = null;
	try {
		con = ConnectionManager.getConnection(request);
		// added for assign bed on 3/8/2005 by Sridhar R 
		String chg_nurs_unit_in_assign_bed_yn = checkForNull(
				request.getParameter("chg_nurs_unit_in_assign_bed_yn"),
				"N");
		// need to get nursing unit code, nursing unit desc, specialty code, specialty desc
		// also get status for showing nursing unit popup and specialty popup 

		String chk_in_lodger_max_period = checkForNull(
				request.getParameter("chk_in_lodger_max_period"), "0");
		String bed_block_period_max = checkForNull(request
				.getParameter("bed_block_period_max"));
		String bl_install_yn = checkForNull(request
				.getParameter("bl_install_yn"));
		String bedBlock_normal = checkForNull(request
				.getParameter("bedBlock_normal"));
		String max_blk_type = checkForNull(request
				.getParameter("max_blk_type"));
		String oper_stn_id = checkForNull(request
				.getParameter("oper_stn_id"));
		String routine_tfr_yn = "";
		String jsp_name = checkForNull(request.getParameter("jsp_name"));
		String win_height = checkForNull(request
				.getParameter("win_height"));
		String win_width = checkForNull(request
				.getParameter("win_width"));
		String call_function = checkForNull(request
				.getParameter("call_function"));
		String modal = checkForNull(request.getParameter("modal"));
		String dialogTop = checkForNull(request
				.getParameter("dialogTop"));
		String module = checkForNull(request.getParameter("module"));
		String model_window = checkForNull(request
				.getParameter("model_window"));
		String function_id = checkForNull(request
				.getParameter("function_id"));
		String function_name = checkForNull(request
				.getParameter("function_name"));
		String prog_id = checkForNull(request.getParameter("prog_id"));
		String wherecondn = checkForNull(request
				.getParameter("wherecondn"));
		//String operstn								= checkForNull(request.getParameter("oper_stn_id"));
		String targetURL = checkForNull(request
				.getParameter("targetURL"));
		String facilityID = (String) session.getValue("facility_id");
		String loginUser = (String) session.getValue("login_user");
		String practitioner_id = checkForNull(request
				.getParameter("practitioner_id"));
		String encounterID_repDischargeAdvice = checkForNull(request
				.getParameter("encounter_id"));
		StringBuffer sbSql = new StringBuffer();
		String systemdate = "";
		String chk_in_lodger_min_date = "";
		String systemdate_converted = "";
		String patient_id_length = "";
		String dis_adv_chk = "";
		String dis_adv_val = "N";
		String display_discharge_pat_list = "";
		if (call_function.equals("DischargePatient")) {
			display_discharge_pat_list = checkForNull(
					request.getParameter("display_discharge_pat_list"),
					"A");

			if (display_discharge_pat_list.equals("D")) {
				dis_adv_chk = "checked";
				dis_adv_val = "Y";
			} else {
				dis_adv_chk = "";
				dis_adv_val = "N";
			}

		}
		try {
			if (oper_stn_id.equals("")
					|| call_function.equals("TransferPatientOut")) {
				sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
				sbSql.append(" where a.facility_id='" + facilityID
						+ "' and a.facility_id=b.facility_id	   ");
				sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"
						+ loginUser + "'   ");
				sbSql.append(" and trunc(sysdate) between b.eff_date_from and ");
				sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sbSql.toString());

				if (rs != null) {
					while (rs.next()) {
						systemdate = checkForNull(rs
								.getString("systemdate"));
						if (!(systemdate == null || systemdate
								.equals("")))
							systemdate_converted = DateUtils
									.convertDate(systemdate, "DMY",
											"en", locale);
						oper_stn_id = checkForNull(rs
								.getString("oper_stn_id"));
						routine_tfr_yn = checkForNull(rs
								.getString("routine_tfr_yn"));
						patient_id_length = checkForNull(rs
								.getString("patient_id_length"));
					}
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
				}
			} else {
				sbSql.append(" select patient_id_length,to_char(sysdate,'dd/mm/rrrr'), to_char(trunc(sysdate)-round(");
				sbSql.append(chk_in_lodger_max_period);
				sbSql.append("/24),'dd/mm/yyyy') from mp_param where  module_id = 'MP' ");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sbSql.toString());

				if (rs != null && rs.next()) {
					patient_id_length = checkForNull(rs.getString(1));
					systemdate = checkForNull(rs.getString(2));
					if (!(systemdate == null || systemdate.equals("")))
						systemdate_converted = DateUtils.convertDate(
								systemdate, "DMY", "en", locale);
					chk_in_lodger_min_date = checkForNull(rs
							.getString(3));
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (sbSql.length() > 0)
			sbSql.delete(0, sbSql.length());
%>
<head>
	<script src="../../eCommon/js/CommonLookup.js" language="javaScript"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<script src="../../eIP/js/IPPractitionerComponent.js" language="javaScript"></script>
	<script src='../../js/GBMAssignBed.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<script>
		// below code is added for the 17600 end  Wednesday, December 23, 2009
		function clearResultpage()
		{
			var resultIFrame = document.getElementById('resultframe');
			if(resultIFrame){
				resultIFrame.src = '../../eCommon/html/blank.html';
			}
			//parent.frames[2].location.href ='../../eCommon/html/blank.html';
		}

// Added by Sridhar on Jan 3rd 2006...
// This Function will check for empty values before calling up the common lookup func..
function BeforeGetPractitioner(obj, target, details)
{
	if(details == 'from')
	{
		if(document.forms[0].from_practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].from_practid.value =""
	}
	else
	{
		if(document.forms[0].practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid.value ="";
	}

}

function getPractitionerLocal(obj, target, details)
{
	var facility_id		= "<%=facilityID%>";
	var locale			= "<%=locale%>";
	getPractitioner(obj, target, facility_id, "","","Q3");

} // End of getToPractitioner.

// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "from_practid_desc")
		{
			document.forms[0].from_practid.value=arr[0];
			document.forms[0].from_practid_desc.value=arr[1];			
		}
		else if(objName=='cancel_pract')
		{
			document.forms[0].cancel_pract_id.value=arr[0];
			document.forms[0].cancel_pract.value=arr[1];

		}	
		else
		{
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];			
		}
	}
	else
	{
		if(objName.name == "practid_desc")
		{
			document.forms[0].from_practid.value="";
			document.forms[0].from_practid_desc.value="";			
		}
		else if(objName=='cancel_pract'){
		
			document.forms[0].cancel_pract_id.value="";
			document.forms[0].cancel_pract.value="";
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";			
		}
	}
}

function CheckZeroVal(obj) 
{
	
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{
		
        return true;
    }
    else 
	{
		if(obj.value.length > 0 && obj.value==0) 
		{
			
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...    
function clearAll()
{
		
	//parent.frames[1].document.location.href ='../../eCommon/html/blank.html';

	/* if(parent.messageFrame)
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'; */

	var resultFrameComp = parent.document.getElementById('resultframe');
	if(resultFrameComp){
		alert('result');
		resultFrameComp.src = '';
	}else{
		alert('result comp not obtained');
	}
	
	//document.forms[0].search.disabled=false;
	var searchButton = document.getElementById('search');
	if(searchButton){
		searchButton.disabled = false;
	}
}

//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...
function submitPage()
{
	
	var condition=""
	for(var i=0; i<document.forms[0].elements.length; i++)
	{
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	}
	document.forms[0].search.disabled=true;
	oper_stn = document.forms[0].operstn.value;
	routine_tfr_yn = document.forms[0].routine_tfr_yn.value;
	call_function =document.forms[0].call_function.value;
	
	var modalComp = document.getElementById("modal");
	var modalVal = '';
	if(modalComp){
		modalVal = modalComp.value;
	}
	if(modalVal == 'yes')
	{
		var resultDivComp = parent.document.getElementById('resultComp');
		if(resultDivComp){
			alert('result is valid');
		}else{
			alert('result comp not obtained');
		}
		<%-- parent.frames[1].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+''; --%>
	}
	else
	{
		var exclude_nda_pats="N";
		var resultFrameComp = parent.document.getElementById('resultframe');
		if(resultFrameComp){
			//alert('result is valid');
			resultFrameComp.src = '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'&exclude_nda_pats='+exclude_nda_pats+'';
			var legendPanel = parent.document.getElementById('legendframe');
			if(legendPanel){
				//alert('setting legend panel');
				//legendPanel.innerHTML = '<'+'object id="legendObj" name="legendObj" type="text/html" data="QuerySearchResultFrames.jsp?step=assignbed"'+'><\/object>';
				legendPanel.src = 'QuerySearchResultFrames.jsp?step=assignbed';
				alert('legend panel is set');
			}
			
		}else{
			alert('result comp not obtained');
		}
<%-- 		parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'&exclude_nda_pats='+exclude_nda_pats+''; --%>
		/* parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'; */
	}
}
function BeforeGetPractID1(obj1,obj2)
{
	if(document.forms[0].cancel_pract.value!="")
		getPractitioner(obj1,obj2,'','','Q7');	// For 17674 (Monday, December 28, 2009)
}
	
</script>
</head>
	<body onSelect="codeArrestThruSelect();" onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="FocusFirstElement();//checkForMPRequest();">
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
					
				<tr>
					<td class='label' width='25%'>
						<script>getLabel("Common.nursingUnit.label","common")</script>
						<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
					</td>
					<td CLASS='fields' width='25%'>
						<%
							String disabled = "";
							if ((nuCode != null && !nuCode.trim().equals(""))
									&& (AssignBedConstants.SHOW_NU_POPUP_DEFAULT_VALUE
											.equalsIgnoreCase(showNuPopup))) {
								disabled = "disabled";
							}
						%>
					
						<input type=text id="nursing_unit_desc" name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');" value="<%=nuDesc%>" <%=disabled%>>
						<input type=hidden id="nursing_unit" name="nursing_unit" id="nursing_unit" size=15 > 
						<input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc,nursing_unit, '<%=facilityID%>','to','<%=loginUser%>','<%=oper_stn_id%>','<%=wherecondn%>','<%=call_function%>');" <%=disabled%> >
					</td>
					
					<td class='label'  nowrap width="25%">
						<fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/>
					</td>
					<td   class='fields' width='25%'  nowrap>
						<input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' id='from_date' 
						onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'>
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('admn_date_from').focus();return showCalendar('admn_date_from');">
						
						 - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
						 						
						<input type='text' id="admn_date_to"  maxlength='10' size='10' name='to_date' id='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'>
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_to.focus();return showCalendar('admn_date_to');" >
					</td>
				</tr>
				<tr>
					<%
					disabled = "";
					if (specialtyCode != null && !specialtyCode.trim().equals("")) {
						if(AssignBedConstants.HIDE_SPECIALTY_POPUP_VALUE.
								equalsIgnoreCase(showSpecialtyPopup)){
							disabled = "disabled";
						}
					}else{
						specialtyDesc = "";
						if(AssignBedConstants.HIDE_SPECIALTY_POPUP_VALUE.
								equalsIgnoreCase(showSpecialtyPopup)){
							disabled = "disabled";
						}
					}
					
					%>
					<td  class='label' width='25%' nowrap>
						<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
					</td>
					<td class='fields' width='25%'  nowrap>
						<input type=text name=specialty_desc size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');" value="<%=specialtyDesc %>" <%=disabled %>>
						<input type=hidden class=label name=Splcode size=15 readonly>
						<input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');" <%=disabled %>>
					</td>
					
					<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap>
						<input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.getElementById('practid'),document.getElementById('practid_desc'),'to');" value="">
						<input type='hidden' id="practid" name='practid' id='practid' value="" size="15" maxlength="15" > 
						<input type='button' id="pract_id_search" name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.getElementById('practid'), document.getElementById('practid_desc'),'to');">
					</td>
				</tr>
	
				<tr>
				
					<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap>
						<input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)">
					</td>
					<td colspan=4></td>
				</tr>
				<tr>
					<td colspan=4>
						<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
					</td>
				</tr>
	</table>	
	
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
			<td width = "75%" class='white' >&nbsp;</td>
			<td width = "25%" class='white' align="right">
				<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.search.label", "common_labels")%>' class='button' onclick='submitPage()'>
				<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(
						pageContext, "Common.clear.label", "common_labels")%>' class='button' onclick='clearAll()'>
			</td>
		</tr>


	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >

	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_name' id='function_name' value="<%=function_name%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
	<input type='hidden' name='operstn' id='operstn' value="<%=oper_stn_id%>" >
	<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value="<%=routine_tfr_yn%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='targetURL' id='targetURL' value="<%=targetURL%>" >
	<input type='hidden' name='wherecondn' id='wherecondn' value="<%=wherecondn%>" >
	<input type='hidden' name='bed_block_period_max' id='bed_block_period_max' value="<%=bed_block_period_max%>" >
	<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>" >
	<input type='hidden' name='bedBlock_normal' id='bedBlock_normal' value="<%=bedBlock_normal%>" >
	<input type='hidden' name='max_blk_type' id='max_blk_type' value="<%=max_blk_type%>" >
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
	<input type='hidden' name='systemdate' id='systemdate' value="<%=systemdate%>" >
	<input type='hidden' name='chk_in_lodger_min_date' id='chk_in_lodger_min_date' value="<%=chk_in_lodger_min_date%>">
	<input type='hidden' name='chg_nurs_unit_in_assign_bed_yn' id='chg_nurs_unit_in_assign_bed_yn' value="<%=chg_nurs_unit_in_assign_bed_yn%>" >
	<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='patient_id_length' id='patient_id_length' value="<%=patient_id_length%>" >
</form>
</body>
<%
	if (rset != null)
			rset.close();
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();

	} catch (Exception e) {

		e.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
%>
</html>

<%!public static String checkForNull(String inputString) {
		return ((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return ((inputString == null) ? defaultValue : inputString);
	}%>

