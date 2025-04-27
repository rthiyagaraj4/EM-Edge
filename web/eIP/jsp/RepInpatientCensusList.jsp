<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
 
<%
    request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPCENSUS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale					= (String)session.getAttribute("LOCALE");
	String isSpltyNurUnitToEnableYNAppl="";
	Connection con = ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
	Statement stmt=null;
	ResultSet rs =null;
	String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
	String CurrentDate="";
	try{
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='JavaScript'></script>
<script src="../../eCommon/js/common.js" language='JavaScript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	
	<script>
  async	function searchCode(obj,target)
		{
				var retVal = 	new String();
	             var dialogHeight= "400px" ;
	             var dialogWidth="900px";
				/* var dialogHeight= "28" ;
				var dialogWidth	= "43" ; */
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
	
				if(obj.name=="speciality_code")
				{
					tit="Speciality"
					sql="select speciality_code,short_desc from am_speciality_lang_vw where language_id = `<%=locale%>` and eff_status = `E` ";
					search_code="speciality_code";
					search_desc= "short_desc";
				}
				else if(obj.name=="nursing_unit")
				{
					tit=getLabel('Common.nursingUnit.label','common');
					sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%=p_facility_id%>` and language_id=`<%=locale%>` ";
					search_code="nursing_unit_code";
					search_desc= "short_desc";
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
		}
		

		 function validate_date(obj) {
				if(obj.value!=''){

					if(isBeforeNow(obj.value,"DMY",localeName))
						return true;
					else {
						alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
						obj.select();
						obj.focus();
						return false ;
					}
				}
  }

</script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onload="FocusFirstElement()" onKeyDown='lockKey()'>
<br>
<br>
<form name="RepInpatientCensusForm" id="RepInpatientCensusForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	<tr>
    <td >&nbsp;</td>
   			<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
				<tr>
					  <td align="left" class="label" ><fmt:message key="eIP.CensusDateRange.label" bundle="${ip_labels}"/>
					 
					<td width='20%'  >
					<input type=text  name='census_date_from'  id="census_date_from"  onblur = "if(validDateObj(this,'DMY',localeName))validate_date(this)" size="10" maxlength="10" align="center" ><input type="image" align='center' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date_from');"><img align='center' src='../../eMP/images/mandatory.gif'>

					</td>

					</td>	

					<td  width='40%' align='left'>
					<input type=text name='census_date_to' id='census_date_to' onblur ="if(validDateObj(this,'DMY',localeName))validate_date(this)" size="10" maxlength="10" align="center" ;'><input type="image" align='center' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date_to');"><img align='center' src='../../eMP/images/mandatory.gif'>
					</td>

   </td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fm_locn_code"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_locn_code"/>
					</jsp:include>
					</tr>
					<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
					</tr>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_spec_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_spec_code"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>			
				<tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  >
							<input type=text onkeypress='return ValidString(event)' name='p_fm_locn_code' id='p_fm_locn_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
							
						</td>
						<td class="fields" width='40%'>
							<input type=text  name='p_to_locn_code' id='p_to_locn_code' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>				

				<tr>
						<td align="left" class="label" ><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/> </td> 
						<td width='20%'  >
							<input type=text  name='p_fm_spec_code' id='p_fm_spec_code' size="4" maxlength="4" align="center"><input type='button' name='speciality_code' id='speciality_code' value='?' class='button' onclick='searchCode(this, p_fm_spec_code)'>
						</td>
						<td width='40%'>
							<input type=text  name='p_to_spec_code' id='p_to_spec_code' size="4" maxlength="4" align="center"><input type='button' name='speciality_code' id='speciality_code' value='?' class='button' onclick='searchCode(this, p_to_spec_code)'>
						</td>
				</tr><%}%>
				
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
		
		</table>
	</td>
</tr>
</table>
    <input type="hidden" name="p_fm_trn_date" id="p_fm_trn_date"		value="">
	<input type="hidden" name="p_to_trn_date" id="p_to_trn_date" 		value="">
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%= CurrentDate %>">
	<input type='hidden' name ='p_language_id' value="<%=locale%>">

</form>
</BODY>
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

