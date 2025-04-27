<!DOCTYPE html>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
						String p_facility_id	= (String) session.getValue( "facility_id" ) ;
						String p_user_name		= (String) session.getValue( "login_user" ) ;
						String locale = (String)session.getAttribute("LOCALE");

						ResultSet rset1=null;
						Connection conn = null;
						ResultSet rs2=null;
						Statement stmt2=null;
						String sql1="";
						int i=0;
try
{

	request.setCharacterEncoding("UTF-8");	

				conn = ConnectionManager.getConnection(request);
				stmt2=conn.createStatement();
			%>
			<head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script src="../../eOA/js/repApptStatsByDayOfMonthByClinic.js" language="javascript"></script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
			<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'> 
<form name="ApptStatsMonthClinicform" id="ApptStatsMonthClinicform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border="0" cellpadding="0" cellspacing="0" width='55%' align='center'>


	<tr>
			<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

			<td class='fields'>
						<% sql1 = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in 	('C','E','Y') order by 2";
									  rs2 = stmt2.executeQuery(sql1);
									  %>
										<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> 
										  <option value='' style='align:center'>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
											<%
											 String locn_type="";
											 String short_desc="";
											 while(rs2.next() && rs2 !=null)
											 {
												locn_type=rs2.getString("care_locn_type_ind");
												short_desc=rs2.getString("short_desc");
												out.println("<option value='"+locn_type+"'>"+short_desc);
											 }
											%>

										</SELECT></td>


			<td  class='label'>&nbsp;</td>
			<td  class='label'>&nbsp;</td>
	</tr>

	<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
	</tr>
	<tr>
			<td class='label'>&nbsp</td>
			<td class='QUERYDATA'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='label'></td>
			<td class='QUERYDATA'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>	
			<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

			<td class='fields'>
			<input type="text" name="from_clinic_code" id="from_clinic_code" size="4" onblur='if(this.value!="") searchCode1(this, from_clinic_code,from_clinic_desc)' maxlength="4"  ><input type="hidden" name="from_clinic_desc" id="from_clinic_desc"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, from_clinic_code,from_clinic_desc)'></td>

			<td class="label">&nbsp;</td>
			<td class='fields'>
			 <input type="text" name="to_clinic_code" id="to_clinic_code" size="4" onblur='if(this.value!="") searchCode1(this, to_clinic_code,to_clinic_desc)' maxlength="4"><input type="hidden" name="to_clinic_desc" id="to_clinic_desc"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, to_clinic_code,to_clinic_desc)'></td>
			 
	</tr>

	<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
	</tr>
 
	<tr>
			<td class='Label'><fmt:message key="eOA.StatisticsMonth.label" bundle="${oa_labels}"/></td>
			<td class='fields'>
				<select name="mon" id="mon" >
				<option value =''>-<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-</option>
					<%

						for(i=1;i<13;i++)
						{
							out.println( "<option value='"+i+"' >"+i+"</option>" ) ; 
						}

					%>
					</select>
					<img src='../../eCommon/images/mandatory.gif' ></img>
				<td width='15%' class='label'><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
				<td class='fields' ><input type='text'  id='yr' name='years' id='years' value="" size="5"  maxlength="4" onkeypress = 'return allowValidNumber(this,event,4,0)' onBlur='validateYear(this)'><img  style="cursor:pointer" src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].years.select();return showCalendar('yr','y')">
				<img src='../../eMP/images/mandatory.gif' align='center'></img></td>
		
 	</tr>

	<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
	</tr>

	<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] Start-->
	<%
	Boolean isAppointmentThrough	= CommonBean.isSiteSpecific(conn, "OA","OA_PORTAL_APP_REPORTS");
	if(isAppointmentThrough){
	
	%>
	<tr>	
			<td class="label"><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>

			<td class='fields'>
				<select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
					<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
					<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
					<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
				</select>
			</td>

			<td class="label" colspan="2">&nbsp;</td>
			 
	</tr>
	<%} else{%>
		<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='' />
	<%}%>
	<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->
 	<input type='hidden' name='P_From_Clinic_Code' id='P_From_Clinic_Code' value=''></input>
	<input type='hidden' name='P_To_Clinic_Code' id='P_To_Clinic_Code' value=''></input>
	<input type='hidden' name='P_Start_Month' id='P_Start_Month' value=''></input>	
	<input type='hidden' name='P_Start_Year' id='P_Start_Year' value=''></input>
	<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=p_facility_id%>'></input>
	<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
	<input type="hidden" name="p_report_id" id="p_report_id"   value="OADMCLST"></input>
	<input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
		<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''></input>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	
  </table>
</form>
</body>
<%
	if ( rset1 != null ) rset1.close() ;
	if(rs2 !=null)rs2.close();
	if (stmt2 !=null) stmt2.close();
 }
catch ( Exception e )
{
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
  	
	ConnectionManager.returnConnection(conn,request);
}

%>
<script>document.forms[0].from_clinic_code.focus();</script>
</html>

