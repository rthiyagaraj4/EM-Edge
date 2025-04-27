<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"   import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.* " %>
<%
request.setCharacterEncoding("UTF-8");	

				String p_facility_id	= (String) session.getValue( "facility_id" ) ;
				String p_user_name		= (String) session.getValue( "login_user" ) ;
				String locale = (String)session.getAttribute("LOCALE");

				String sql = "";
				PreparedStatement pstmt1=null;
				ResultSet rset1=null;
				Connection conn = null;
				ResultSet rs2=null;
				Statement stmt2=null;
				String sql1="";
				String isSpltyNurUnitToEnableYNAppl="";
try
	{
			conn = ConnectionManager.getConnection(request);	
			isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(conn);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
			stmt2=conn.createStatement();
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src="../../eOA/js/repApptStatsByDayOfWeekByClinic.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload="DateSetup();getDay();"> 
<form name="ApptStatsform" id="ApptStatsform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR>
  <table border="0" cellpadding="0" cellspacing="0" width='55%' align='center'>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

	<td class='fields'>
		<% sql1 = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
		  rs2 = stmt2.executeQuery(sql1);
		 %>
		<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"><option value='' style='align:center'>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
		<%
			String locn_type="";
            String short_desc="";
            while(rs2.next() && rs2 !=null){
            locn_type=rs2.getString("care_locn_type_ind");
            short_desc=rs2.getString("short_desc");
            out.println("<option value='"+locn_type+"'>"+short_desc);
			}
			if(rs2 !=null) rs2.close();
			%>
		</SELECT>
	</td>

	<td class="label">&nbsp;</td>

</tr>

<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

<tr>
	<td>&nbsp;</td>
	<td class="QUERYDATA"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="QUERYDATA"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td  class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="from_clinic_code" id="from_clinic_code" onblur='if(this.value!="") searchCode1(this, from_clinic_code,from_clinic_desc)' size="4" maxlength="4" ><input type="hidden" name="from_clinic_desc" id="from_clinic_desc"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, from_clinic_code,from_clinic_desc)'>
	</td>


	<td class='fields'><input type="text" name="to_clinic_code" id="to_clinic_code" onblur='if(this.value!="") searchCode1(this, to_clinic_code,to_clinic_desc)' size="4" maxlength="4"><input type="hidden" name="to_clinic_desc" id="to_clinic_desc"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, to_clinic_code,to_clinic_desc)'>
	</td>
</tr>

<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_special"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_special"/>
					</jsp:include>
					</tr>
<%}else{%>
<tr>
	<td  class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_special" id="p_fm_special" size="4" onblur='if(this.value!="") searchCode1(this, p_fm_special,p_fm_special_desc)' maxlength="4" ><input type="hidden" name="p_fm_special_desc" id="p_fm_special_desc"><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchCode1(this, p_fm_special,p_fm_special_desc)'>
	</td>


	<td class='fields'><input type="text" name="p_to_special" id="p_to_special" size="4" onblur='if(this.value!="") searchCode1(this, p_to_special,p_to_special_desc)' maxlength="4"><input type="hidden" name="p_to_special_desc" id="p_to_special_desc"><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchCode1(this, p_to_special,p_to_special_desc)'>
	</td>
</tr><%}%>

<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

<tr>
	<td class='Label'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
	<%
	String sys="";
	String sysday="";
	String sys_disp="";
	sql="select to_char(sysdate,'dd/mm/rrrr') sys,to_char(sysdate,'Day') day from dual";
	pstmt1 = conn.prepareStatement(sql);
	rset1 = pstmt1.executeQuery () ;
	if(rset1 != null)
	{
		while(rset1.next())
		{
			sys=rset1.getString("sys");
			sysday=rset1.getString("day");
		}
	}

	sys_disp=DateUtils.convertDate(sys,"DMY","en",locale);
	%>
	<td class='fields'><input align='left' type='text'  id='apptstatdate' name='dat' id='dat'  size='10' maxlength='10'  value='<%=sys_disp%>' onBlur='ValidateDate(this);'><input type='hidden' name='dat_disp' id='dat_disp' value='<%=sys%>'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" 
	onClick="document.forms[0].dat.focus();return showCalendar('apptstatdate');">
	<img src='../../eCommon/images/mandatory.gif'></img> </td>	
	
	<td class='label'><a id=sys1><%=sysday%></a>	
	</td>
</tr>

<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>	

<tr>
	<td class='Label'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
	<td><INPUT TYPE="text" name="end_date" id="end_date" size='10' readonly maxlength='10'></td>
	<!--Added by Ashwini on 27-Nov-2017 for ML-MMOH-SCF-0875-->
	<td class='label'><a id=endDate></a></td>
</tr>
<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] Start-->
<%
	Boolean isAppointmentThrough	= CommonBean.isSiteSpecific(conn, "OA","OA_PORTAL_APP_REPORTS");
	if(isAppointmentThrough){
	
%>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>	

<tr>
	<td class='Label'><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>
	<td>
		<select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
			<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
			<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
			<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
		</select>
	</td>
	<td>&nbsp;</td>
</tr>
<%} else{%>
	<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='' />
<%}%>
<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->
<tr>
    <td colspan = 3>&nbsp;</td>
  	<input type='hidden' name='sysday' id='sysday' value=<%=sysday%>></input>
	<input type='hidden' name='P_From_Clinic_Code' id='P_From_Clinic_Code' value=''></input>
	<input type='hidden' name='P_To_Clinic_Code' id='P_To_Clinic_Code' value=''></input>
	<input type='hidden' name='P_Start_Date' id='P_Start_Date' value=''></input>
	<input type='hidden' name='P_Start_Month' id='P_Start_Month' value=''></input>
	<input type='hidden' name='P_Start_Year' id='P_Start_Year' value=''></input>
	<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=p_facility_id%>'></input>
	<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
	<input type="hidden" name="p_report_id" id="p_report_id"   value=""></input>
	<input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''></input>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	</tr>
	
  </table>
</form>
</body>
<%
	  if(rs2 !=null) rs2.close();
	if ( rset1 != null ) rset1.close() ;
	if ( pstmt1 != null ) pstmt1.close() ;
	if (stmt2 !=null) stmt2.close();
 }
catch ( Exception e )
{
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
    ConnectionManager.returnConnection(conn,request);
}

%>
<script>document.forms[0].from_clinic_code.focus();</script>
</html>


