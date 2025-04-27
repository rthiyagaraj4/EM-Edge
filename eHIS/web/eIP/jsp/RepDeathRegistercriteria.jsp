<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script src='../../eIP/js/RepDeathRegister.js' language='javascript'></script>

</script>
<script>



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

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<%
request.setCharacterEncoding("UTF-8"); 
	Connection con=null;
	Statement stmt=null;
	ResultSet rs =null;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String p_module_id		= "IP" ;
	String p_report_id		= "IPRDTHRG" ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String pat_length = "";
	String CurrentDate = "";
    String isSpltyNurUnitToEnableYNAppl="";

try{
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	stmt=con.createStatement();
	rs=stmt.executeQuery("select patient_id_length,to_char(sysdate,'dd/mm/yyyy')CurrentDate from MP_PARAM_lang_vw where language_id='"+locale+"'");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);
		CurrentDate=rs.getString("CurrentDate");
	}catch(Exception e) {out.println(e.toString());	}
	finally
	{
		try
		{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}
		catch(Exception e)
		{
		}
		ConnectionManager.returnConnection(con,request);
	}

%>

<form name="RepDeathRegisterForm" id="RepDeathRegisterForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">


	<table width='80%' cellPadding="4" cellSpacing="0"  align='center' border='0'>
			<th align='left' colspan="3"> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
			</th>
					
					<tr>
						<td  width="30%">&nbsp;</td>
						<td class="label" width="30%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
							<td  width='30%' class="label"><fmt:message key="eIP.Deceasedperiod.label" bundle="${ip_labels}"/> &nbsp;</td>
							<td width='30%' class="fields" >
								<input type=text id="p_fm_dec_date"  name='p_fm_dec_date' id='p_fm_dec_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_dec_date');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
							<td width='40%' class="fields">  
								<input type=text id="p_to_dec_date"  name='p_to_dec_date' id='p_to_dec_date' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_dec_date');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
					</tr>

					<tr>			
						<td  width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width = '30%' class = 'fields'><input type=text  name='p_patient_id' id='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="ChangeUpperCase(this);"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'></td>
						<td>&nbsp;</td>
					</tr>

					<!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
					<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursg_unit_code"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursg_unit_code"/>
					</jsp:include>
					</tr>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_splty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_splty_code"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
						<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>
						<td width='30%' class="fields" >
							<input type=text  name='p_fm_nursg_unit_code' id='p_fm_nursg_unit_code' id='p_fm_nursg_unit_code'size="4" maxlength="4" align="center" ><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursg_unit_code)'>
						</td>
						<td width='40%' class="fields"> 
							<input type=text  name='p_to_nursg_unit_code' id='p_to_nursg_unit_code' size="4"
							id='p_to_nursg_unit_code'maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursg_unit_code)'>
						</td>
				</tr>

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></td>
					<td width='30%' class="fields" >
						<input type=text  name='p_fm_splty_code' id='p_fm_splty_code' size="4" id='p_fm_splty_code'maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_splty_code)'>
					</td>
					<td width='40%' class="fields"> 
						<input type=text  name='p_to_splty_code' id='p_to_splty_code' size="4" id='p_to_splty_code'maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_splty_code)'>
					</td>
				</tr>
				<%}%>	

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
					<td width='30%'  class="fields">
						<input type=text  name='p_fm_attnd_pract_id' id='p_fm_attnd_pract_id' size="15" id='p_fm_attnd_pract_id'maxlength="15" align="center" ><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode(this, p_fm_attnd_pract_id)'>
					</td>
					<td width='40%' class="fields"> 
						<input type=text  name='p_to_attnd_pract_id' id='p_to_attnd_pract_id' size="15" id='p_to_attnd_pract_id'maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode(this, p_to_attnd_pract_id)'>
					</td>
				</tr>


			
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
					<td width='30%'  class="fields">
						<input type=text  name='p_fm_nalty_code' id='p_fm_nalty_code' size="4" id='p_fm_nalty_code'maxlength="4" align="center" ><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this,p_fm_nalty_code)'>
					</td>
					<td width='40%' class="fields"> 
						<input type=text  name='p_to_nalty_code' id='p_to_nalty_code' size="4" id='p_to_nalty_code'maxlength="4" align="center"><input type='button' name='nationality' id='nationality' value='?' class='button' onclick='searchCode(this,p_to_nalty_code)'>
					</td>
				</tr>
			

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
					<td width='30%'  class="fields">
						<input type=text  name='p_fm_adm_date' id='p_fm_adm_date' size="10" maxlength="2" align="center" id='p_fm_adm_date' onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_adm_date');"/>
					</td>
					<td width='40%' class="fields"> 
						<input type=text  name='p_to_adm_date' id='p_to_adm_date' size="10" maxlength="2" id='p_to_adm_date' align="center"onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_adm_date');"/>
					</td>
				</tr>
			

				<tr>
					<td  width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='30%' class="fields">
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.Nursing.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
						<option value='3'><fmt:message key="Common.nationality.label" bundle="${ip_labels}"/>
						<option value='3'><fmt:message key="Common.practitioner.label" bundle="${ip_labels}"/>
						</select>
					</td>
					<td>&nbsp;</td>
				
				</tr>
				
<input type='hidden' name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<input type='hidden' name="locale" id="locale" value="<%=locale%>">
<input type='hidden' name="p_report_id" id="p_report_id" value="<%=p_report_id%>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">

</table>
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
 

