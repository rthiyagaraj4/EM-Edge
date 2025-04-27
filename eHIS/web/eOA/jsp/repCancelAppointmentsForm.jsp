<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%String p_facility_id		= (String) session.getValue( "facility_id" ) ; %>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eOA/js/repCancelAppointments.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>

<%
	String p_module_id		= "OA" ;
	String p_report_id		= "OABCNAPT" ;	
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_passing_local_date="";
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th"))
	{
		p_passing_local_date="Y";
	}else 
	{
		p_passing_local_date="N";
	}
	String sql			= "" ;	
	Connection con = null;
	Statement stmt   		=null;
	Statement stmt1   		= null ;
	ResultSet rs	   		= null;
	ResultSet rset	   		= null;
	String practtype="";
	StringBuffer fm_strt=new StringBuffer("");
	StringBuffer to_strt=new StringBuffer("");
	String practtypedesc="";
	request.setCharacterEncoding("UTF-8");
	String isSpltyNurUnitToEnableYNAppl="";
try{	
	con = ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
	 stmt   		= con.createStatement() ;
	 stmt1   		= con.createStatement() ;
	String sqlt = "select pract_type,Desc_Userdef  from am_pract_type order by 2";
	rs	= stmt.executeQuery( sqlt) ;			
  	fm_strt.append("<select name='fm_pract_type' id='fm_pract_type'><option value=''> --- <fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/> ---");
  	to_strt.append("<select name='to_pract_type' id='to_pract_type'><option value=''> --- <fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/> ---");
	while(rs!=null&&rs.next()) 
  	 {
  		practtype=rs.getString("pract_type");
  		practtypedesc=rs.getString("Desc_Userdef");
  		fm_strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);	
		to_strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
  	 }
	fm_strt.append("</select>");
  	to_strt.append("</select>");

%>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
	<form name="repCancelAppointments" id="repCancelAppointments" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table border='0' align='center' cellpadding='0' cellspacing='0'>
	<br>
		<tr>
			<td width='30%'>&nbsp;</td>
			<td class='querydata' width='35%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td class="label"><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" id='apptdatefrom' name="p_fm_appt_date" id="p_fm_appt_date" size="10" maxlength="10" OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');">
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>


			<td class='fields'>
				<input type="text" id='apptdateto' name="p_to_appt_date" id="p_to_appt_date" size="10" maxlength="10" OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');">
				<img src='../../eCommon/images/mandatory.gif'></img>
			</td>

		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
		</tr>
			
		<tr>
			<td  class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<TD class='fields'>
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

					</SELECT></td>
			<td >&nbsp;</td>			
		</tr>	
			
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	

		<tr>
			<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_fm_locn_code,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, p_fm_locn_code,p_fm_locn)'>
			</td>

			<td class='fields'>
				<input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, p_to_locn_code,p_to_locn)'><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, p_to_locn_code,p_to_locn)'>
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
					<jsp:param name="speciality_code_Appl" value="p_fm_speciality"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality"/>
					</jsp:include>
					</tr>
		<%}else{%>
        <tr>
             <td  class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			 <td class='fields'>
               <input name='p_fm_speciality' id='p_fm_speciality' value='' size='4' maxlength='4' title='From Practitioner Id' onblur='if(this.value !="") searchCode1(this, p_fm_speciality,p_fm_speciality_desc)'><input type="hidden" name="p_fm_speciality_desc" id="p_fm_speciality_desc"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode1(this, p_fm_speciality,p_fm_speciality_desc)'>
              </td>
			 <td class='fields'>
               <input name='p_to_speciality' id='p_to_speciality' value='' size='4' maxlength='4' title='To Practitioner Id' onblur='if(this.value !="") searchCode1(this, p_to_speciality,p_to_speciality_desc)'><input type="hidden" name="p_to_speciality_desc" id="p_to_speciality_desc"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode1(this, p_to_speciality,p_to_speciality_desc)'>
			 </td>
        </tr><%}%>


		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			
		</tr>	

        <tr>
             <td  class='label'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
			<td class='fields'>
               <input name='p_fm_service' id='p_fm_service' value='' size='4' maxlength='4' title='From Practitioner Id' onblur='if(this.value !="") searchCode1(this, p_fm_service,p_fm_service_desc)'><input type="hidden" name="p_fm_service_desc" id="p_fm_service_desc"><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode1(this, p_fm_service,p_fm_service_desc)'>
              </td>
			<td class='fields'>
               <input name='p_to_service' id='p_to_service' value='' size='4' maxlength='4' title='To Practitioner Id' onblur='if(this.value !="") searchCode1(this, p_to_service,p_to_service_desc)'><input type="hidden" name="p_to_service_desc" id="p_to_service_desc"><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode1(this, p_to_service,p_to_service_desc)'>
             </td>
	   </tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			<TD class='fields'><SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
                  <OPTION value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
                  <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                  <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                  <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                  </SELECT></td>
					
			<td>&nbsp;</td>			
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
				  <OPTION value='' >&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
                   </SELECT>
			
			<TD class='fields' id='loc' >
				  <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
				  <OPTION value='' >&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
				  </SELECT>
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
			<td  class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" onblur ="onblurcheck(this,p_fm_pract_id)"size="15" maxlength="15" disabled><input type='button' name='fm_pract_id' id='fm_pract_id' value='?' class='button' disabled onclick='callPractSearch(this, p_fm_pract_id)'>
			</td>


			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" onblur="onblurcheck(this,p_to_pract_id)"size="15" maxlength="15" disabled><input type='button' name='to_pract_id' id='to_pract_id' value='?' class='button' disabled onclick='callPractSearch(this, p_to_pract_id)'>
			</td>
		</tr> -->

		<tr>
			<td >&nbsp;</td>
			<td>&nbsp;</td>
			<td >&nbsp;</td>
			
		</tr>
			<tr>
			<td  class="label"><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" name="p_fm_contact_reason" id="p_fm_contact_reason" onblur ='onblurcheck(this,p_fm_pract_id); if(this.value !="") searchCode1(this, p_fm_contact_reason,p_fm_contact_reason_desc)' size="15" maxlength="15" ><input type="hidden" name="p_fm_contact_reason_desc" id="p_fm_contact_reason_desc"><input type='button' name='reasoncancel' id='reasoncancel' value='?' class='button'  onclick='searchCode1(this, p_fm_contact_reason,p_fm_contact_reason_desc)'>
			</td>


			<td class='fields'>
				<input type="text" name="p_to_contact_reason" id="p_to_contact_reason" onblur='onblurcheck(this,p_to_pract_id); if(this.value !="") searchCode1(this, p_to_contact_reason,p_to_contact_reason_desc)' size="15" maxlength="15" ><input type="hidden" name="p_to_contact_reason_desc" id="p_to_contact_reason_desc"><input type='button' name='reasoncancel' id='reasoncancel' value='?' class='button'  onclick='searchCode1(this, p_to_contact_reason,p_to_contact_reason_desc)'>
			</td>


		</tr>
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td>&nbsp;</td>
			
		</tr>
 
	<tr>
			<td class="label"><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" name="p_fm_modified_by_id" id="p_fm_modified_by_id" onblur ='onblurcheck(this,p_fm_pract_id); if(this.value !="") searchCode1(this, p_fm_modified_by_id,p_fm_modified)'size="15" maxlength="15" ><input type="hidden" name="p_fm_modified" id="p_fm_modified"><input type='button' name='canceledby' id='canceledby' value='?' class='button'  onclick='searchCode1(this, p_fm_modified_by_id,p_fm_modified)'>
			</td>


			<td class='fields'>
				<input type="text" name="p_to_modified_by_id" id="p_to_modified_by_id" onblur='onblurcheck(this,p_to_pract_id); if(this.value !="") searchCode1(this, p_to_modified_by_id,p_to_modified)' size="15" maxlength="15" ><input type="hidden" name="p_to_modified" id="p_to_modified"><input type='button' name='canceledby' id='canceledby' value='?' class='button'  onclick='searchCode1(this, p_to_modified_by_id,p_to_modified)'>
			</td>

	</tr>

	<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			
	</tr>

	<tr>
             <td  class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>

             <td class='fields'>
			  <select name='sex' id='sex'>
			  <option value=""> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
			  <option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			  <option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			  <option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			  </select>
             </td>

			 <td>&nbsp;</td>
    </tr>

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
             <td  class='label'><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>

             <td class='fields'>
				<select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
					<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
					<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
					<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
				</select>
             </td>

			 <td>&nbsp;</td>
    </tr>
	 <%}else{%>
			<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='' />
		<%}%>
<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->
		

</table>

<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
			<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
			<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	</form>

</center>
<%
if(rs !=null) rs.close();
if(rset !=null) rset.close();
if(stmt !=null) stmt.close();
if(stmt1 !=null) stmt1.close();
fm_strt.setLength(0);
to_strt.setLength(0);

}catch(Exception es){
//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{

ConnectionManager.returnConnection(con,request);

}

%>
</body><script>document.forms[0].p_fm_appt_date.focus();</script>
</html>

