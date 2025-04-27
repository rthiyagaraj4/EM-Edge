<!DOCTYPE html>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>




<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script> 
<script src="../../eAE/js/repEDFollowupPatient.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

	
<script>
	
async function searchCategory(obj,target)
{    
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var facilityid = document.forms[0].p_facility_id.value;
	if(target.name == 'p_fm_patcat_code' || target.name == 'p_to_patcat_code')
	{
		tit=getLabel("eAE.TreatmentAreaCode.label","ae");
		//sql="SELECT pat_cat_code code, short_desc description FROM mp_pat_category_lang_vw WHERE language_id = '"+localeName+"' and eff_status = 'E' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2";
		//sql = "SELECT pat_cat_code code, short_desc description FROM mp_pat_category_lang_vw WHERE language_id = '"+localeName+"' and eff_status = 'E' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?)";
		sql = "select distinct TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+localeName+"' and  facility_id='"+facilityid+"' and upper(TREATMENT_AREA_CODE) LIKE UPPER (?) and upper(SHORT_DESC)  LIKE UPPER (?)  ";
		
	}
	

	argumentArray[0] = encodeURIComponent(sql);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'p_fm_patcat_code')
		{
		document.forms[0].p_fm_patcat_code.value= arr[0];
		}
		if(target.name == 'p_to_patcat_code')
		{
		document.forms[0].p_to_patcat_code.value= arr[0];
		}
	}
	
	
}
</script>

 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>
 
<%

		String p_module_id		= "AE" ;
		String p_report_id		= "AEFOLPAT" ;
		String p_facility_id	= (String) session.getValue( "facility_id" ) ;
		String p_user_name		= (String) session.getValue( "login_user" ) ;
		String sql			= "" ;
		String p_passing_local_date="";
		String locale = (String)session.getAttribute("LOCALE");
		if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs   = null;
		Statement stmt1 = null;
		ResultSet rset  = null;
		request.setCharacterEncoding("UTF-8");
		String isSpltyNurUnitToEnableYNAppl="";
try
{
	 con = ConnectionManager.getConnection(request);
	 isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 25th-OCT-2018 for ML-MMOH-CRF-1115.1
		 stmt = con.createStatement() ;
		 stmt1 = con.createStatement() ;
	%>




<center>
<body onLoad="groupByTrtmentarea()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name="repEDFollowupPatient" id="repEDFollowupPatient" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

		<table border='0' align='center' cellpadding='0' cellspacing='0' width='65%'>
		<br>
		<tr>
			<td  width='30%'>&nbsp;</td>
			<td class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
			

		<tr>
			<td class="label"><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" id='apptdatefrom' name="p_fm_appointment_date" id="p_fm_appointment_date" size="10" maxlength="10" OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>


			<td class='fields'>
				<input type="text" id='apptdateto' name="p_to_appointment_date" id="p_to_appointment_date" size="10" maxlength="10" OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>

		</tr>

		<tr>
			<td>&nbsp;</td>
			<td >&nbsp;</td>
			<td>&nbsp;</td>			
		</tr>	

			

		<tr>
			<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_fm_locn_code,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn' id='locn' value='?' class='button'  onclick='searchCode1(this, p_fm_locn_code,p_fm_locn)'>
			</td>


			<td class='fields'>
				<input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_to_locn_code,p_to_locn)' ><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn1' id='locn1' value='?' class='button'  onclick='searchCode1(this, p_to_locn_code,p_to_locn)'>
			</td>

  		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_speciality_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality_code"/>
					</jsp:include>
					</tr>
<%}else{%>
		<tr> 
			<td  class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/>

			</td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_speciality_code" id="p_fm_speciality_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_fm_speciality_code,p_fm_speciality)' ><input type="hidden" name="p_fm_speciality" id="p_fm_speciality"><input type='button' name='speciality' id='speciality' value='?' class='button'  onclick='searchCode1(this, p_fm_speciality_code,p_fm_speciality)'>
			</td>


			<td class='fields'>
				<input type="text" name="p_to_speciality_code" id="p_to_speciality_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_to_speciality_code,p_to_speciality)'><input type="hidden" name="p_to_speciality" id="p_to_speciality"><input type='button' name='speciality1' id='speciality1' value='?' class='button' onclick='searchCode1(this, p_to_speciality_code,p_to_speciality)'>
			</td>
</tr><%}%>

	  <tr>
			<td>&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
	  </tr>	


	  <tr>
			<td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_fm_service_code,p_fm_service)'><input type="hidden" name="p_fm_service" id="p_fm_service"><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode1(this, p_fm_service_code,p_fm_service)'>
			</td>


			<td class='fields'>
				<input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_to_service_code,p_to_service)'><input type="hidden" name="p_to_service" id="p_to_service"><input type='button' name='service1' id='service1' value='?' class='button' onclick='searchCode1(this, p_to_service_code,p_to_service)'>
			</td>
		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	
		
				<%/*Added for this CRF [RUT-CRF-0011]*/%>		
  <tr>
			<td class="label"><fmt:message key="eAE.TreatmentAreaCode.label" bundle="${ae_labels}"/></td> 

			
				<td class='fields'>
				<input type="text" name="p_fm_patcat_code" id="p_fm_patcat_code" size="4" maxlength="4" onblur='if(this.value !="") searchCategory(p_fm_patcat,p_fm_patcat_code)'><input type="hidden" name="p_fm_patcat" id="p_fm_patcat"><input type='button' name='pat_cat_code_id' id='pat_cat_code_id' value='?' class='button' onclick='searchCategory(p_fm_patcat,p_fm_patcat_code)'>
			</td>
			
			
			<td class='fields'>
				<input type="text" name="p_to_patcat_code" id="p_to_patcat_code" size="4" maxlength="4" onblur='if(this.value !="") searchCategory(p_to_patcat,p_to_patcat_code)'><input type="hidden" name="p_to_patcat" id="p_to_patcat"><input type='button' name='pat_cat_code_id' id='pat_cat_code_id' value='?' class='button' onclick='searchCategory(p_to_patcat,p_to_patcat_code)'>
			</td>		
			
		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>


<%/*End*/%>
		
		
		

		

		

		<tr>
			<td  class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

			<td class='fields'> 
				<select name="p_gender" id="p_gender">
					<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
				</select>
			</td>
			
			<td width='10%'>&nbsp;</td>
		
		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	

		

		<tr>
			<td class="label"><fmt:message key="eAE.GroupbyTreatmentarea.label" bundle="${ae_labels}"/>
			</td>

			<td class='fields'> 
				<input type="checkbox" name="p_grp_by_trtment_area" id="p_grp_by_trtment_area" value='Y' onClick="groupByTrtmentarea()" unchecked>
			</td>

			<td width='10%'>&nbsp;</td>
		
		</tr>
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	
		</table>
		<br><br>

		<table border='0' width='80%' align='center' cellpadding='0' cellspacing='0'>
			<th colspan='3' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></th>
		<tr>
			<td colspan=3>&nbsp;</td>
		</tr>

		<tr>

			<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td class='label'>&nbsp;</td>
			<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td align='center'><select name='orderbycols' id='orderbycols' size='6' >
				<option value='patient_name' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></option>
				<option value='appt_date'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>
				</option>
				
				</select>
			</td>

				<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>

			<td  align='center'>
			<select name='orderbycolumns' id='orderbycolumns' size='6' multiple='true'>
			<option value='patient_id' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
			</select>
			</td>
		</tr>
			<td class='label' colspan=3>&nbsp;</td>
		</table>


		<br>

		

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	
		<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS"	value=''>
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type='hidden' name='locale' id='locale'				value='<%=locale%>'>
		<input type="hidden" name="p_order_by" id="p_order_by"			value="">
	    <input type="hidden" name="p_fm_appt_date" id="p_fm_appt_date"	value="">
		<input type="hidden" name="p_to_appt_date" id="p_to_appt_date"	value="">

	</form>
</body>
</center>
<%
	if(rs !=null) rs.close();
	if(rset !=null)rset.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
}catch(Exception es){
//out.println(es.toString());
es.printStackTrace();
}
finally{

ConnectionManager.returnConnection(con,request);

}
%>
</body><script>document.forms[0].apptdatefrom.focus();</script>
</html>

