<!DOCTYPE html>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>




<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script> 
<script src="../../eOA/js/repAppointmentsForOPD.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%/*Added for this CRF [RUT-CRF-0011]*/%>	
<script>
	
	async function searchCategory(obj,target)
{    
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	if(target.name == 'p_fm_patcat_code' || target.name == 'p_to_patcat_code')
	{
		tit=getLabel("Common.category.label","common");
		//sql="SELECT pat_cat_code code, short_desc description FROM mp_pat_category_lang_vw WHERE language_id = '"+localeName+"' and eff_status = 'E' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2";
		sql = "SELECT pat_cat_code code, short_desc description FROM mp_pat_category_lang_vw WHERE language_id = '"+localeName+"' and eff_status = 'E' and upper(pat_cat_code) like upper(?) and upper(short_desc) like upper(?)";

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
	/*else{
	    if(target.name == 'p_fm_patcat')
		{
		target.value='';
		document.forms[0].p_fm_patcat_code.value='';
		}else{
		  target.value='';
		 document.forms[0].p_to_patcat_code.value='';
		
		}
	}*/
	
}
</script>



<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>
 
<%

		String p_module_id		= "OA" ;
		String p_report_id		= "OAAPOPPI" ;
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
		boolean isVirtualConsVisit = false;
try
{
	 con = ConnectionManager.getConnection(request);
	 isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 1st-OCT-2018 for ML-MMOH-CRF-1115.1
	 isVirtualConsVisit  = CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION");
		 stmt = con.createStatement() ;
		 stmt1 = con.createStatement() ;
	%>




<center>
<body onLoad="groupByLocation()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name="repAppointmentsForOPD" id="repAppointmentsForOPD" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

		<table border='0' align='center' cellpadding='0' cellspacing='0' width='65%'>
		<br>
		<tr>
			<td  width='25%'>&nbsp;</td>
			<td class='querydata' width='30%' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
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
			<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

			<TD class='fields' >
				<%
				 sql = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
				  rset = stmt1.executeQuery(sql);
				  %>
					<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> 						<option value='' style='align:center'>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
						<%
						 String locn_type="";
                         String short_desc="";
                         while(rset.next() && rset !=null){
						 locn_type=rset.getString("care_locn_type_ind");
                         short_desc=rset.getString("short_desc");
                         out.println("<option value='"+locn_type+"'>"+short_desc);
						 }%>
					</SELECT>
				</td>
			<td width='5%'>&nbsp;</td>			
		</tr>	
			
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
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
		<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
		<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_speciality_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality_code"/>
					</jsp:include>
					</tr>
		<%}else{%>
		<tr>
			<td  class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>

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
			<td class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>

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
			<td class="label"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td> 

			
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

			<td class="label"><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>

			<TD class='fields'><SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
				 <OPTION value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
                 <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                 <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                 <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				 <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                 </SELECT>
		  </td>
					
		  <td width='5%'>&nbsp;</td>			

		</tr>	
			
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	

		<tr>
			<td  class="label"><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

			<TD class='fields' id='loc' >
			  <SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
			  <OPTION value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</SELECT>
			
			<TD class='fields' id='loc' >
			  <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
			  <OPTION value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</SELECT>

		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	

				 <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "reports" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

		<!-- <tr>
			<td class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" disabled onblur ="onblurcheck(this,p_fm_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch(this, p_fm_pract_id)">
			</td>


			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" disabled onblur="onblurcheck(this,p_to_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch(this, p_to_pract_id)'>
			</td>
		</tr> -->

		<tr>
			<td>&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	

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

			<td  class="label"><fmt:message key="Common.Options.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<select name="p_options" id="p_options">
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
					<option value='1'><fmt:message key="eOA.WithPatientNumbers.label" bundle="${oa_labels}"/>
					<option value='2'><fmt:message key="eOA.WithoutPatientNumbers.label" bundle="${oa_labels}"/>
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
			<td class="label"><fmt:message key="eOA.GroupByLocation.label" bundle="${oa_labels}"/>
			</td>

			<td class='fields'> 
				<input type="checkbox" name="p_grp_by_location" id="p_grp_by_location" value='Y' onClick="groupByLocation()" unchecked>
			</td>

			<td width='10%'>&nbsp;</td>
		
		</tr>
		<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1930 US11 -->
		<% if(isVirtualConsVisit){ %>
		<tr>
			<td class="label"><fmt:message key="Common.virtualConsultation.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Visit.label" bundle="${common_labels}"/>
			</td>
			<td class='fields'> 
				<input type="checkbox" name="p_virtual_consultation_visit" id="p_virtual_consultation_visit" value="N">
			</td>
			<td width='10%'>&nbsp;</td>
		</tr>
		<% }%>
		<!-- End ML-MMOH-CRF-1930 US11 -->
		<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] Start-->
		<%
		Boolean isAppointmentThrough	= CommonBean.isSiteSpecific(con, "OA","OA_PORTAL_APP_REPORTS");
		if(isAppointmentThrough){
		
		%>
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>
		<tr>
			<td  class="label"><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>
			<td class='fields'>
				<select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
				    <OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
					<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
					<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
				</select>
			</td>
			<td width='10%'>&nbsp;</td>
		</tr>
		<%}else{%>
				<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='' />
		<%}%>
		<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->
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
				<option value='appt_date__slab_from_time'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/>
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
		<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
		<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS"	value=''>
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type='hidden' name='locale' id='locale'				value='<%=locale%>'>
		<input type="hidden" name="p_order_by" id="p_order_by"			value="">
	    <input type="hidden" name="p_fm_appt_date" id="p_fm_appt_date"	value="">
		<input type="hidden" name="p_to_appt_date" id="p_to_appt_date"	value="">
		<input type="hidden" name="isVirtualConsVisit" id="isVirtualConsVisit"	value="<%=isVirtualConsVisit%>">
		<input type="hidden" name="p_vcv" id="p_vcv"	value=""> <!-- Added by Ajay Hatwate for ML-MMOH-CRF-1930 -->

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
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{

ConnectionManager.returnConnection(con,request);

}
%>
</body><script>document.forms[0].apptdatefrom.focus();</script>
</html>

