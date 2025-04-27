<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
<%
request.setCharacterEncoding("UTF-8");	
String facility_id			= (String)session.getAttribute("facility_id");
String v_patient_id			=	checkForNull(request.getParameter("v_patient_id"));
String v_encounter_id		=	checkForNull(request.getParameter("v_encounter_id"));
String practid_desc		    =	checkForNull(request.getParameter("practid_desc"));
String v_nursing_unit_code	= checkForNull(request.getParameter("v_nursing_unit_code"));
String v_spacialty_code		= checkForNull(request.getParameter("v_spacialty_code"));
String from_date			= checkForNull(request.getParameter("from_date"));
String to_date		        = checkForNull(request.getParameter("to_date"));
String from 				= request.getParameter( "from" ) ;
String to 					= request.getParameter( "to" ) ;
String whereclause = request.getParameter("whereclause")== null?"":request.getParameter("whereclause");  
StringBuffer where_criteria = new StringBuffer();
String locale				= (String)session.getAttribute("LOCALE");
Connection con				= null;
ResultSet rs				= null;
PreparedStatement pstmt		= null;
con  =  ConnectionManager.getConnection(request);
StringBuffer sql			= new StringBuffer();
	
//Added by Arthi for ML-MMOH-SCF-2095
Boolean isListaggAppl = false;

int start = 0 ;
int end = 0 ;


	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 11 ;
	else
		end = Integer.parseInt( to ) ;
	
try{

    //Added by Arthi for ML-MMOH-SCF-2095
	isListaggAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "VW_PREP_DISCH_ADV_LST_QRY");
	
	if(whereclause.equals(""))
	{
	where_criteria.append("AND a.patient_id = NVL('"+v_patient_id+"',a.patient_id) AND a.encounter_id = NVL('"+v_encounter_id+"', a.encounter_id) AND a.nursing_unit_code = NVL('"+v_nursing_unit_code+"', a.nursing_unit_code) AND a.specialty_code = NVL('"+v_spacialty_code+"', a.specialty_code) AND a.attend_practitioner_id =NVL('"+practid_desc+"', a.attend_practitioner_id) AND TRUNC(c.dis_adv_date_time) BETWEEN TO_DATE('"+from_date+"', 'dd/mm/yyyy') AND  TO_DATE('"+to_date+"' , 'dd/mm/yyyy')");
	}else{
		where_criteria.append(whereclause);
	}
	
	sql.append("SELECT a.patient_id,DECODE('"+locale+"','en', b.patient_name,NVL(b.patient_name_loc_lang, b.patient_name)) patient_name, a.encounter_id, DECODE(b.sex,'F','Female','M','Male','U','Unknown')gender, Mp_get_age_ymdh(b.date_of_birth)age, TO_CHAR(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, am_get_desc.am_practitioner(a.admit_practitioner_id,'"+locale+"',2) admit_practitioner, am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',2)attend_practitioner, ip_get_desc.ip_nursing_unit(a.facility_id,a.nursing_unit_code,'"+locale+"',2)nursing_unit_desc, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2)bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, a.bed_num bed_no, TO_CHAR(a.modified_date,'dd/mm/rrrr hh24:mi:ss')modified_date, ip_get_desc.IP_DISCHARGE_TYPE(c.discharge_type_code,'en',2)discharge_type_code, TO_CHAR(c.expected_discharge_date,'dd/mm/rrrr hh24:mi')expected_discharge_date, ");
	
	//Modified for ML-MMOH-SCF-2095
	if(isListaggAppl){
	sql.append(" ( select distinct listagg( h.term_code || '-' ||h. term_code_short_desc) from pr_diagnosis_enc_dtl h where h.ENCOUNTER_ID=a.ENCOUNTER_ID and h.ENC_STAGE='D' and h.status!='E')diagnosis ,( select distinct listagg( e.proc_narration) ");
	}
	else{ 
		sql.append(" ( select distinct wm_concat( h.term_code || '-' ||h. term_code_short_desc) from pr_diagnosis_enc_dtl h where h.ENCOUNTER_ID=a.ENCOUNTER_ID and h.ENC_STAGE='D' and h.status!='E')diagnosis ,( select distinct wm_concat( e.proc_narration) ");
    }
	
	sql.append(" from pr_encounter_procedure e where e.ENCOUNTER_ID=a.ENCOUNTER_ID and e.error_yn='N')procedure_recording FROM ip_open_encounter a,mp_patient b,ip_discharge_advice c WHERE a.facility_id='"+facility_id+"' AND a.patient_id = b.patient_id AND a.patient_id = c.patient_id AND a.encounter_id = c.encounter_id  AND c.dis_adv_status != '9'  "+where_criteria+" GROUP BY a.patient_id,DECODE ('"+locale+"','en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name)),a.encounter_id,b.sex,Mp_get_age_ymdh(b.date_of_birth),TO_CHAR (a.admission_date_time, 'dd/mm/rrrr hh24:mi'),a.admit_practitioner_id,a.attend_practitioner_id,ip_get_desc.ip_nursing_unit (a.facility_id,a.nursing_unit_code,'en',2), ip_get_desc.ip_bed_class (a.bed_class_code, 'en', 2),ip_get_desc.ip_bed_type (a.bed_type_code, 'en', 2),a.bed_num, a.modified_date,ip_get_desc.ip_discharge_type (c.discharge_type_code,'en',2), c.expected_discharge_date ORDER BY  c.expected_discharge_date ");
	//out.println("sql.toString()-->"+sql.toString());
int maxRecords=0;
pstmt = con.prepareStatement(sql.toString());

rs= pstmt.executeQuery();
int i=0;
int j=0;
%>
		<P>
		<table align='right'>
		<tr>
		<td>
		<%
if ( !(start <= 1) ){
out.println("<A  HREF='../jsp/ViewPrepareDischargeAdviseListQueryResult.jsp?from="+(start-11)+"&to="+(end-11)+"&facility_id="+facility_id+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'id='previous'>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
}
out.println("<A  HREF='../jsp/ViewPrepareDischargeAdviseListQueryResult.jsp?from="+(start+11)+"&to="+(end+11)+"&facility_id="+facility_id+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'text-decoration='none' style='display:none'id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
		</td>
		</tr>
		</table><br>
		<br>
		<br>
		</P>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	    <script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
<BODY class='CONTENT'>

<table align='center' border="1" width="100%" cellspacing='0' cellpadding='0'>
<thead id='table_header'>
<tr>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmittingPractitioner.label","ip_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.BedNumber.Label","ds_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PrepareDischargeAdvice.label","ip_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Date/Time.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedatetime.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisDetails.label","common_labels")%>&nbsp;</th>
<th nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")%>&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.details.label","common_labels")%>&nbsp;</th>
</tr></thead>

<%
String  classValue = "" ;
if(rs != null)
{
	if ( start != 1 )
	for(  j=1; j<start; i++,j++ )
	rs.next() ;

  while(rs.next() && i<=end)
	{ 
     if ( i % 2 == 0 )
			classValue = "QRYEVENSMALL" ;
		else
			classValue = "QRYODDSMALL" ;
    
	out.println("<tr>");
	 String patient_id=rs.getString("patient_id"); if(patient_id == null) patient_id="";
	 out.println("<td class='"+classValue+"' nowrap>"+patient_id+"&nbsp;</td>");
	 String patient_name=rs.getString("patient_name"); if(patient_name == null) patient_name="";
	 out.println("<td class='"+classValue+"' nowrap>"+patient_name+"&nbsp;</td>");
	 String encounter_id=rs.getString("encounter_id"); if(encounter_id == null) encounter_id="";
	 out.println("<td class='"+classValue+"' nowrap>"+encounter_id+"&nbsp;</td>");
	 String gender=rs.getString("gender"); if(gender == null) gender="";
	 out.println("<td class='"+classValue+"' nowrap>"+gender+"&nbsp;</td>");
	 String age=rs.getString("age"); if(age == null) age="";
	 out.println("<td class='"+classValue+"' nowrap>"+age+"&nbsp;</td>");
	 String admission_date_time=rs.getString("admission_date_time"); if(admission_date_time == null) admission_date_time="";
	 out.println("<td class='"+classValue+"' nowrap>"+admission_date_time+"&nbsp;</td>");
	 String admit_practitioner=rs.getString("admit_practitioner"); if(admit_practitioner == null) admit_practitioner="";
	 out.println("<td class='"+classValue+"' nowrap>"+admit_practitioner+"&nbsp;</td>");
	 String attend_practitioner=rs.getString("attend_practitioner"); if(attend_practitioner == null) attend_practitioner="";
	 out.println("<td class='"+classValue+"' nowrap>"+attend_practitioner+"&nbsp;</td>");
	 String nursing_unit_desc=rs.getString("nursing_unit_desc"); if(nursing_unit_desc == null) nursing_unit_desc="";
	 out.println("<td class='"+classValue+"' nowrap>"+nursing_unit_desc+"&nbsp;</td>");
	 String bed_class_short_desc=rs.getString("bed_class_short_desc"); if(bed_class_short_desc == null) bed_class_short_desc="";
	 out.println("<td class='"+classValue+"' nowrap>"+bed_class_short_desc+"&nbsp;</td>");
	 String bed_type_short_desc=rs.getString("bed_type_short_desc"); if(bed_type_short_desc == null) bed_type_short_desc="";
	 out.println("<td class='"+classValue+"' nowrap>"+bed_type_short_desc+"&nbsp;</td>");
	 String bed_no=rs.getString("bed_no"); if(bed_no == null) bed_no="";
	 out.println("<td class='"+classValue+"' nowrap>"+bed_no+"&nbsp;</td>");
	 String modified_date=rs.getString("modified_date"); if(modified_date == null) modified_date="";
	 out.println("<td class='"+classValue+"' nowrap>"+modified_date+"&nbsp;</td>");
	 String discharge_type_code=rs.getString("discharge_type_code"); if(discharge_type_code == null) discharge_type_code="";
	 out.println("<td class='"+classValue+"' nowrap>"+discharge_type_code+"&nbsp;</td>");
	 String expected_discharge_date=rs.getString("expected_discharge_date"); if(expected_discharge_date == null) expected_discharge_date="";
	 out.println("<td class='"+classValue+"' nowrap>"+expected_discharge_date+"&nbsp;</td>");
	 String diagnosis=rs.getString("diagnosis"); if(diagnosis == null) diagnosis="";
	 out.println("<td class='"+classValue+"' nowrap>"+diagnosis+"&nbsp;</td>");
	 String procedure_recording=rs.getString("procedure_recording"); if(procedure_recording == null) procedure_recording="";
	 out.println("<td class='"+classValue+"' nowrap>"+procedure_recording+"&nbsp;</td>");
	 out.println("</tr>");
	 i++;
	 maxRecords++;
}
}

if(maxRecords<12 || !(rs.next())){ %>	
			<SCRIPT LANGUAGE="JavaScript">
				document.getElementById("next").style.display="none";
			</SCRIPT>
		<%}else{  %>	
			<SCRIPT LANGUAGE="JavaScript">
				document.getElementById("next").style.display="inline";
			</SCRIPT>			
<%}
if(maxRecords==0){%>
			<SCRIPT LANGUAGE="JavaScript">
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				parent.frames[2].location.href ='../../eCommon/html/blank.html';
				
			</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</table>

</body>
<%
		if(rs != null)	rs.close();
		if(pstmt != null)	pstmt.close();
	}catch(Exception e)
	{ 
		out.println("Error  : "+e.toString());	
		e.printStackTrace();
	}
	finally
	{     
		ConnectionManager.returnConnection(con,request);
	}	

%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>	

