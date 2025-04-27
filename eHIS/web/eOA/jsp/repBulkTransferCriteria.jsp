<!DOCTYPE html>
</head>
<body  OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
<form name="bulktransferapptreport" id="bulktransferapptreport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<script language="javascript" src="../../eOA/js/repBulkTransfer.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>



	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'  href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>





<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con=null;
Statement stmt   	= null ;
Statement stmtlen   =null;
ResultSet rs2	   	= null;
ResultSet rslen	   	= null;

boolean allow_inside=true;
String p_module_id		= "OA" ;
String p_report_id		= "OABLKTFR" ;
String fac_id    	= (String) session.getValue( "facility_id" ) ;
String p_facility_id	= (String) session.getValue( "facility_id" ) ;
String loginuser 	= (String) session.getValue( "login_user" ) ;
String locale=(String)session.getAttribute("LOCALE");
String pat_name_as_multipart_yn = "";
String pat_name_length = "";
String sys_date="";
String oper_stn_id=request.getParameter("oper_stn_id");
//String currentdate=request.getParameter("currentdate");
String canc_appt_yn=request.getParameter("canc_appt_yn");
if(canc_appt_yn.equals("") ) canc_appt_yn="N";
String tfr_appt_yn=request.getParameter("tfr_appt_yn");
if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";

//String b_loc1_value= "";
//String b_loc1_name = "";
String visit_limit_rule = "";
String isSpltyNurUnitToEnableYNAppl="";

try{

	con = ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		 stmt   	= con.createStatement() ;
		 stmtlen=con.createStatement() ;
					
if(allow_inside){
		 tfr_appt_yn =request.getParameter("book_appt_yn"); 
			 if(tfr_appt_yn.equals("") ) tfr_appt_yn="N";

		if(tfr_appt_yn.equals("N")){%>
			<script>alert(getMessage('SCH_NOT_ALLOW','OA'));
		parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';
			</script>
		<%}
int pat_id_len=0;

	rslen=stmtlen.executeQuery("Select Patient_Id_Length,Nat_Id_Length,alt_id1_length, pat_name_as_multipart_yn,to_char(sysdate,'dd/mm/yyyy') sys_date from mp_param");
	
	if( rslen !=null && rslen.next())
	{
	
	 pat_id_len=rslen.getInt("Patient_Id_Length");
	sys_date=rslen.getString("sys_date");
	pat_name_as_multipart_yn = rslen.getString("pat_name_as_multipart_yn");
	}

	if (pat_name_as_multipart_yn.equals("N"))
	{
		pat_name_length = "60";
	}
	else
	{
		pat_name_length = "40";
	}

	String sql_oa_param="select visit_limit_rule from oa_param where module_id='OA'";
	rs2=stmt.executeQuery(sql_oa_param);
	if(rs2 !=null && rs2.next())
	{
		visit_limit_rule=rs2.getString("visit_limit_rule");
		if(visit_limit_rule ==null) visit_limit_rule="N";
	}

%>
        <table cellpadding='2' cellspacing='0' width='60%' border='0' align='center' >
<br>
		<tr>
			<td  width='30%'>&nbsp;</td>
			<td class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->		
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
			<td  class='label' width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap>
				<input type="text" name="p_fm_speciality" id="p_fm_speciality" size="15" maxlength="15" onblur='chkSpecVal(p_fm_speciality,P_SPECIALTY_CODE_FROM,P_SPECIALTY_CODE_TO)' ><input type="hidden" name="P_SPECIALTY_CODE_FROM" id="P_SPECIALTY_CODE_FROM"><input type='button' name='speciality' id='speciality' value='?' class='button'  onclick='searchCode1(this, P_SPECIALTY_CODE_FROM,p_fm_speciality)'>
			</td>
			<input type="hidden" name="P_SPECIALTY_CODE_TO" id="P_SPECIALTY_CODE_TO">
<%}else{%>		
<tr>
			<td  class='label' width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields' nowrap>
				<input type="text" name="P_SPECIALTY_CODE_FROM" id="P_SPECIALTY_CODE_FROM" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, P_SPECIALTY_CODE_FROM,p_fm_speciality)' ><input type="hidden" name="p_fm_speciality" id="p_fm_speciality"><input type='button' name='speciality' id='speciality' value='?' class='button'  onclick='searchCode1(this, P_SPECIALTY_CODE_FROM,p_fm_speciality)'>
			</td>
			<td class='fields' nowrap>
				<input type="text" name="P_SPECIALTY_CODE_TO" id="P_SPECIALTY_CODE_TO" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, P_SPECIALTY_CODE_TO,p_to_speciality)' ><input type="hidden" name="p_to_speciality" id="p_to_speciality"><input type='button' name='speciality1' id='speciality1' value='?' class='button'  onclick='searchCode1(this, P_SPECIALTY_CODE_TO,p_to_speciality)'>
			</td>

</tr><%}%>
 <tr>
             <td  class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
            	<td class='fields' nowrap>
				<input type="text" name="P_LOCATION_CODE_FROM" id="P_LOCATION_CODE_FROM" size="4" maxlength="4"  disabled onblur='if(this.value !="") searchCode2(this, P_LOCATION_CODE_FROM,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn' id='locn' disabled value='?' class='button'  onclick='searchCode2(this, P_LOCATION_CODE_FROM,p_fm_locn)'>
			</td>
				<td class='fields' nowrap>
				<input type="text" name="P_LOCATION_CODE_TO" id="P_LOCATION_CODE_TO" size="4" maxlength="4"  disabled onblur='if(this.value !="") searchCode2(this, P_LOCATION_CODE_TO,p_to_locn)'><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn1' id='locn1' disabled value='?' class='button'  onclick='searchCode2(this, P_LOCATION_CODE_TO,p_to_locn)'>
			</td>
</tr>

	   <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
	   <jsp:param name ="from_page" value= "reports_bulk" />
	   <jsp:param name ="pract_value" value= "" />
	   </jsp:include>
		
<tr>
			<td class="label"><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type="text" id='apptdatefrom' name="P_APPT_DATE_FROM" id="P_APPT_DATE_FROM" size="10" maxlength="10" OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<td class='fields'>
				<input type="text" id='apptdateto' name="P_APPT_DATE_TO" id="P_APPT_DATE_TO" size="10" maxlength="10" OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
</tr>

  <tr>
            <td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
           
			<TD class='fields' >
					<SELECT name='P_ORDER_BY' id='P_ORDER_BY' id='res' >
                    <OPTION value='APPT_DATE_TIME'><fmt:message key="Common.ApptDate/Time.label" bundle="${common_labels}"/>
					<!--below line modifed by Mano aganist ML-MMOH-CRF-0609-->
                    <OPTION value='BULKTRANSFER_DATE_TIME'><fmt:message key="eOA.BulkRescheduleDateTime.label" bundle="${oa_labels}"/> 
                    <OPTION value='PATIENT_ID'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
					<OPTION value='SPECIALTY'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> 
					<OPTION value='GENDER_AGE'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>/<fmt:message key="Common.age.label" bundle="${common_labels}"/>
                    <OPTION value='LOCATION'><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
                    <OPTION value='PRACTITIONER'><fmt:message key="Common.resource.label" bundle="${common_labels}"/>
					<!--below line modifed by Mano aganist ML-MMOH-CRF-0609-->
					<OPTION value='REASON_FOR_BULKTRANSFER'><fmt:message key="eOA.ReasonforBulkReschedule.label" bundle="${oa_labels}"/> 
                    </SELECT></td>
			<td class='querydata' >&nbsp;</td>
       </tr>
</table>
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type='hidden' name='loginuser' id='loginuser' value='<%=loginuser%>'>
<input type='hidden' name='resource_class1' id='resource_class1' value=''>
<input type='hidden' name='resource_class2' id='resource_class2' value=''>
<input type='hidden' name='p_report_id' id='p_report_id' value='<%=p_report_id%>'>
<input type='hidden' name='p_module_id' id='p_module_id' value='<%=p_module_id%>'>
<input type='hidden' name='isSpltyNurUnitToEnableYNAppl' id='isSpltyNurUnitToEnableYNAppl' value='<%=isSpltyNurUnitToEnableYNAppl%>'>
</form>
<%
}
	if(stmt !=null) stmt.close();
	if(rs2 !=null) rs2.close();
	if(rslen !=null) rslen.close();
	if(stmtlen !=null) stmtlen.close();

}catch(Exception es){
	//out.println("Exception in querycriteria"+ es.toString());
	es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}		
%>
</body>
</html>

