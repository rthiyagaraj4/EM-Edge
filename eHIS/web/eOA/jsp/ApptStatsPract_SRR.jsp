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

						PreparedStatement pstmt1=null;
						ResultSet rset1=null;
						Connection conn=null;
						String sql="";
try
{
	request.setCharacterEncoding("UTF-8");	

		conn = ConnectionManager.getConnection(request);	

%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src="../../eOA/js/repApptStatsByDayOfWeekByPract_SRR.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='getDay()'> 
<form name="ApptStatsPractform" id="ApptStatsPractform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border="0" cellpadding="0" cellspacing="0" width='65%' align='center'>
  	<tr>
			<td width='25%'>&nbsp;</td>
			<td class='QUERYDATA' width='30%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='QUERYDATA' width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
  <tr>
	<td  class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>

	<td class='fields'><input type="text" name="P_FM_SPECIALITY" id="P_FM_SPECIALITY" size="15" onblur='if(this.value!="") searchCode1(this, P_FM_SPECIALITY,p_fm_special_desc)' maxlength="15" ><input type="hidden" name="p_fm_special_desc" id="p_fm_special_desc"><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchCode1(this, P_FM_SPECIALITY,p_fm_special_desc)'>
	</td>


	<td class='fields'><input type="text" name="P_TO_SPECIALITY" id="P_TO_SPECIALITY" size="15" onblur='if(this.value!="") searchCode1(this, P_TO_SPECIALITY,p_to_special_desc)' maxlength="15"><input type="hidden" name="p_to_special_desc" id="p_to_special_desc"><input type='button' name='spec' id='spec' value='?' class='button' onclick='searchCode1(this, P_TO_SPECIALITY,p_to_special_desc)'>
	</td>
</tr>
		<tr>
			<td width='25%'>&nbsp;</td>
			<td width='30%'>&nbsp;</td>
			<td width='30%'>&nbsp;</td>			
		</tr>	
			<tr>
			<td class="label" nowrap><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
                 <OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
                 <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                 <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                 <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				 <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                 </SELECT>
			</td>
	
			<td width='10%'>&nbsp;</td>
		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	
	
		
		<tr>
			<td  class="label"><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

			<TD class=fields id='loc' >
				  <SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);'>
				  <OPTION value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
                  </SELECT></td>
		    <TD class=fields id='loc' >
				  <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
				  <OPTION value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		</tr>

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
		</tr>	

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" flush="true" >
				<jsp:param name ="from_page" value= "reports" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

		<!-- <tr>
			<td  class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class=fields nowrap><input type="text" name="from_pract_code" id="from_pract_code" onblur="onblurcheck(this,from_pract_code)" disabled size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' disabled class='button' onclick='callPractSearch(this, from_pract_code)'>
			</td>


			<td class=fields><input type="text" name="to_pract_code" id="to_pract_code" onblur="onblurcheck(this,to_pract_code)" disabled size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' value='?' disabled class='button' onclick='callPractSearch(this, to_pract_code)'>
			</td>
		</tr> -->

		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td>&nbsp;</td>			
		</tr>	

	<tr>
		
		<td  class='Label'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
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
		<td class=fields ><input align='left' type='text' id='apptstatdate' name='dat' id='dat' size='10' maxlength='10'  value='<%=sys_disp%>' onBlur='ValidateDate(this);'><input type='hidden' name='dat_disp' id='dat_disp' value='<%=sys%>'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].dat.focus();return showCalendar('apptstatdate');"> <img src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='fields'><a id=sys1><%=sysday%></a>
		</td>
	</tr>	
	<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
			<td >&nbsp;</td>			
	</tr>	
	<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] Start-->
	<%
	Boolean isAppointmentThrough	= CommonBean.isSiteSpecific(conn, "OA","OA_PORTAL_APP_REPORTS");
	if(isAppointmentThrough){
	
	%>
	<tr>
		<td class="label" nowrap><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>

		<td class='fields' nowrap>
			<select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
				<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
				<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
				<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
			</select>
		</td>
		<td width='10%'>&nbsp;</td>
	</tr>
	<%} else{%>
	<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='A' />
	<%}%>
	<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->

	<input type='hidden' name='sysday' id='sysday' value=<%=sysday%>>
	<input type='hidden' name='P_From_Pract_Code' id='P_From_Pract_Code' value=''></input>
	<input type='hidden' name='P_To_Pract_Code' id='P_To_Pract_Code' value=''></input>
	<input type='hidden' name='P_Start_Date' id='P_Start_Date' value=''></input>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value='<%=p_facility_id%>'></input>
	<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
	<input type="hidden" name="p_report_id" id="p_report_id"   value="OADWKPRST"></input>
	<input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''></input>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	 <!-- Monday, March 29, 2010 20345 venkat S -->
	<input type='hidden' name='p_fm_locn_code' id='p_fm_locn_code' value=''>
	<input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value=''>
	
  </table>
</form>
</body>
<%
	if ( rset1 != null ) rset1.close() ;
	if ( pstmt1 != null ) pstmt1.close() ;
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
<script>document.forms[0].fm_pract_type.focus();</script>
</html>

