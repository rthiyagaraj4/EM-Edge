<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script>

var specialtyForClinc= new Array();
var openToAllPractYN=new Array();
	specialtyForClinc[0]	=	'';
	openToAllPractYN[0]='';



</script>
</head>
<%
Connection  con					= null;
PreparedStatement pstmt			= null;
Statement stmt1					= null;
ResultSet rset					= null;
ResultSet rs					= null;
ResultSet rs1					= null;


StringBuffer  sqlLocBuff        = null;
try{
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");
	con=ConnectionManager.getConnection(request);
    String StartDate="";
    String sys_date="";
    String shortdesc="";
    String dat="";
    String ID="";
    String sel1="";
	String RevCanceldays="";
    String facilityId = (String) session.getValue( "facility_id" ) ;
	String userId     = (String) session.getValue("login_user");
    String p_mode		=request.getParameter("p_mode");
    String patient_id		=checkForNull(request.getParameter("patient_id"));
	String params		=request.getQueryString() ;
	StartDate			=checkForNull(request.getParameter("StartDate")); 
	String start_date   =checkForNull(request.getParameter("start_date")); 
	String function_name   =checkForNull(request.getParameter("function_name")); 
	String function_id   =checkForNull(request.getParameter("function_id")); 
	String Patient_Id_Length			=checkForNull(request.getParameter("Patient_Id_Length"));// Wednesday, May 12, 2010 venkat s PE_EXE
	sys_date			=checkForNull(request.getParameter("sys_date"));
	RevCanceldays		=checkForNull(request.getParameter("RevCanceldays"));
	String max_days_allow_update =checkForNull(request.getParameter("max_days_allow_update"));
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	String system_date ="";
    String system_date1="";
  //Below line Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
    String five_level_triage_appl_yn =	(request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");



	if(!sys_date.equals(""))
	system_date    =sys_date.substring(0,10);
	if(!RevCanceldays.equals(""))
	system_date1    =RevCanceldays.substring(0,10);

	String oper_stn_id=checkForNull(request.getParameter("oper_stn_id"));
	if (oper_stn_id.equals(""))
	{
		StringBuffer sqlBuf = new StringBuffer();
            sqlBuf.append("select a.oper_stn_id from am_oper_stn a,am_user_for_oper_stn b where a.facility_id = ? and a.oper_stn_type in ('O', 'B')  and  a.facility_id=b.facility_id and a.oper_stn_id=b.oper_stn_id and b.appl_user_id = ? and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
			pstmt   = con.prepareStatement( sqlBuf.toString());
			pstmt.setString	(	1,	facilityId		);
			pstmt.setString	(	2,	userId	);
			
			rs  = pstmt.executeQuery();
			if (rs!= null && rs.next())
			{
				oper_stn_id		=	rs.getString("oper_stn_id");
			}

			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if((sqlBuf != null) && (sqlBuf.length() > 0))
			{
				sqlBuf.delete(0,sqlBuf.length());
			} 
	}
	if(p_mode.equals("CANCELVISIT") || p_mode.equals("REVISEVISIT") ){
		sqlLocBuff = new StringBuffer();

		sqlLocBuff.append("select a.clinic_code,a.long_desc short_desc,a.SPECIALITY_CODE,a.open_to_all_pract_yn from op_clinic_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =rtrim(to_char(sysdate,'DAY'))) b  where decode(b.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and  a.facility_id = ? and  a.language_id = '"+locale+"' and a.LEVEL_OF_CARE_IND = 'E' and a.clinic_type in (select locn_type from am_care_locn_type where care_locn_type_ind='C') and a.eff_status='E' and (a.clinic_type, a.clinic_code) in (select locn_type, locn_code from am_os_user_locn_access_vw  where facility_id = ? and oper_stn_id =? and appl_user_id = ? ");
		if (p_mode.equals("CANCELVISIT"))
			sqlLocBuff.append("AND cancel_visit_yn = 'Y' ");
		else if(p_mode.equals("REVISEVISIT"))
			sqlLocBuff.append("AND revise_visit_yn = 'Y' ");

		sqlLocBuff.append(") order by 2 ");

		if (pstmt != null) pstmt.close();
		pstmt = con.prepareStatement(sqlLocBuff.toString());
		pstmt.setString(1, facilityId);
		pstmt.setString(2, facilityId);
		pstmt.setString(3, oper_stn_id);
		pstmt.setString(4, loginuser);

	  
	}
	else
	{
		sqlLocBuff = new StringBuffer();
		sqlLocBuff.append("select a.long_desc short_desc,a.clinic_code,a.SPECIALITY_CODE,a.open_to_all_pract_yn from op_clinic_lang_vw a, (select day_no from sm_day_of_week where day_of_week = rtrim(to_char(sysdate,'DAY'))) b where decode(b.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and a.eff_status='E' and  a.facility_id = ? and a.language_id = '"+locale+"' and a.LEVEL_OF_CARE_IND = 'E' order by 1 ");
		if (pstmt != null) pstmt.close();
		pstmt = con.prepareStatement(sqlLocBuff.toString());
		pstmt.setString(1, facilityId);
	}

//  Wednesday, May 12, 2010 venkat s   
	if(Patient_Id_Length.equals(""))
	{
		String sql;
		sql = "Select patient_id_length from mp_param where module_id='MP' " ;
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery(sql);
	if (rs1 != null)
	{
		while(rs1.next())
	{
			Patient_Id_Length   = rs1.getString(1);
	}
	}
	if(rs1 != null) rs1.close();
	if(stmt1 != null) stmt1.close();
	}

%>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        <script language='javascript' src='../../eCommon/js/dchk.js'></script>
        <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	    <script language='javascript' src='../../eAE/js/AESearchVisit.js'></script>
	    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
        <script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">

<form name="SearchVisit" id="SearchVisit" >
<table  border="0" width="100%" cellspacing='0' cellpadding='0' align="center">
  <tr><td colspan='4'></td></tr>

    <tr>
       
<%  
    String specialty_code="";
	String open_to_all_pract_yn="";
	int rowIndex=1;
%>
    <input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'></input>
    <input type='hidden' name='p_mode' id='p_mode' value='<%=p_mode%>'></input>
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'></input>
	<input type='hidden' name='params' id='params' value='<%=params%>'></input>
	<input type='hidden' name='sys_date1' id='sys_date1' value='<%=RevCanceldays%>'>
	<input type='hidden' name='max_days_allow_update' id='max_days_allow_update' value='<%=max_days_allow_update%>'>
	<input type='hidden' name='system_date' id='system_date' value='<%=system_date%>'>
	<input type='hidden' name='system_date1' id='system_date1' value='<%=system_date1%>'>
    <input type="hidden" name="start_date" id="start_date" value='<%=start_date%>'>
   
<td    class="label" width="25%" ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>
<td  width="25%" class='fields'>
    <input type="text" id = "visitadmdatetime" name="visit_adm_date_time" id="visit_adm_date_time"  value='<%=DateUtils.convertDate(system_date1,"DMY","en",locale)%>' size='10' maxlength='10' onBlur = "chkFromToTime2(this);" ><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('visitadmdatetime');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<td   class="label" width="25%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<td   width="25%" class='fields' >
    <select name='assign_care_locn_code' id='assign_care_locn_code' onChange="">
        <option value="">------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
<%
		rset = pstmt.executeQuery();
        if(rset!=null)
        {
          while(rset.next())
           {
			dat=rset.getString("short_desc");
            ID=rset.getString("clinic_code");
			specialty_code=rset.getString("SPECIALITY_CODE");
			open_to_all_pract_yn=rset.getString("open_to_all_pract_yn");

			if(dat.equals(shortdesc))
                sel1="selected";
            else
			sel1="";
            out.println("<option value='"+ID+ "' "+sel1+">"+dat+"</option>");
            %>
			<script>parent.frames[1].specialtyForClinc[<%=rowIndex%>]='<%=specialty_code%>';
			parent.frames[1].openToAllPractYN[<%=rowIndex%>]='<%=open_to_all_pract_yn%>';
			</script> 
			 <%
			rowIndex++; 
		   
		   }
        }
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		if((sqlLocBuff != null) && (sqlLocBuff.length() > 0))
		{
			sqlLocBuff.delete(0,sqlLocBuff.length());
		} 
%>
    </select> 
</td>
</tr>
<tr>
<td  class='label' width="25%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
<td  width="25%" class='fields'>
<input type="text"   name="patient_id" id="patient_id" align="left" size='16' maxlength='<%=Patient_Id_Length%>' onBlur="ChangeUpperCase(this);" onKeyPress="return(CheckForSpecChars(event))" value='<%=patient_id%>'><input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
</td>
<td  class='label' width="25%" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
<td  width="25%" class='fields'>
<input type="text"  name="encounter_id" id="encounter_id"  size='12' maxlength='12'  onBlur='return(ChkNumber(this))' onKeyPress='return(ChkNumberInput(this,event,0));' >
</td>
</tr>
<tr>
<!-- 	<td   class="label"  width="25%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
    <td width="25%"  class='fields'>
       <input type=text name='practitioner_desc' id='practitioner_desc' size=30 maxlength=30 onBlur="beforeGetPractitioner2(practitioner_id,practitioner_desc);" readOnly><input type=hidden name='practitioner_id' id='practitioner_id' ><input type=button class=button value='?' name='Practitioner_lookup_button' id='Practitioner_lookup_button' onClick="getPractitioner2(practitioner_id,practitioner_desc);" disabled><input type='hidden' name='prev_pract_name' id='prev_pract_name' value=""> 
    </td> -->
	<%
		/* Modified for CRF - PMG20089-CRF-0541 (IN08081)
			Modified by Suresh M Date : 11/12/2009
			New Checkbox is introduced in Cancel Attendence Function.
		*/
		if(p_mode.equals("CANCELVISIT")) {%>
	<tr>
	<td></td>
	<td></td>
   <td class='label' nowrap><fmt:message  key="eAE.IncludeTreatAreaPat.label" bundle="${ae_labels}"/></td>
   <td><input type='checkbox'  name='inc_arrive_cons_start_pats' id='inc_arrive_cons_start_pats' value="N" ></td>
   </tr>
   <tr>
   <%}%>
   <td></td>
   <td></td>
	<td></td>
    <td class='BUTTON' width="25%"><input type="button" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='CheckSplChars();' class='button' ><input type="button" name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='ClearFrame()'></td>
</tr>
<tr><td colspan='4' class='LABEL' height='5'></td></tr>
</table>
        <input type='hidden' name='locale' id='locale' value="<%=locale%>">
        <input type="hidden" name="where_criteria1" id="where_criteria1">
        <input type="hidden" name="where_criteria2" id="where_criteria2">
        <input type="hidden" name="facility_id" id="facility_id" value='<%=facilityId%>'>
		<input type="hidden" name="function_name" id="function_name" value='<%=function_name%>'>
		<input type="hidden" name="function_id" id="function_id" value='<%=function_id%>'>
		<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value="<%=five_level_triage_appl_yn%>">
		
		
        </form>
<%}catch (Exception e) {e.printStackTrace();}
finally{
        if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>
</body>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

</html>

