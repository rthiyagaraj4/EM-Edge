<!DOCTYPE html>
 <%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	</script>
	
	</head>
<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con					= null;
	Statement  stmt1				= null;
	ResultSet  rset1				= null;
	try
	{
		Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
		con		= ConnectionManager.getConnection(request);
		enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY"); // Added by shagar for ML-MMOH-CRF-1328
		
//		String patientId	= checkForNull(request.getParameter("patientId"));
//		String filename		= checkForNull(request.getParameter("Filename"));
		String encounter_id = checkForNull(request.getParameter("encounter_id"));
		String facilityId	= (String)session.getValue("facility_id");
		String facility_id	= checkForNull(request.getParameter("facility_id"), facilityId);

		String classValue	= "";
		StringBuffer sqlQuery	= new StringBuffer();

		//sqlQuery.append("SELECT TO_CHAR(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time ,a.added_by_id ,A.trn_date_time,decode(A.trn_type,'D', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'),'L',IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_nursing_unit,'"+locale+"','2')) to_nursing_unit_short_desc,decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no,decode(A.trn_type,'D',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),'L',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),AM_GET_DESC.AM_PRACTITIONER(a.to_practitioner_id,'"+locale+"','1')) to_practitioner_long_name,decode(A.trn_type,'D',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),'L',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),AM_GET_DESC.AM_SPECIALITY(a.to_specialty_code,'"+locale+"','2')) to_specialty_short_desc,DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transferred','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave') remarks,AM_GET_DESC.AM_CONTACT_REASON(a.cancel_reason_code,'"+locale+"','1') Reason ,a.trn_code,(CASE WHEN a.trn_type = 'A' THEN IP_GET_DESC.IP_ADMISSION_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'T' THEN IP_GET_DESC.IP_TRANSFER_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'D' THEN IP_GET_DESC.IP_DISCHARGE_TYPE(a.trn_code,'"+locale+"','2') END ) trn_desc FROM IP_ADT_TRN A WHERE A.facility_id='"+facility_id+"' AND A.encounter_id='"+encounter_id+"' AND a.srl_no like '%%' UNION SELECT TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy hh24:mi')trans_date_time, a.added_by_id, a.ADDED_DATE trn_date_time, IP_GET_DESC.IP_NURSING_UNIT(B.facility_id, B.to_nursing_unit,'"+locale+"','2') to_nursing_unit_short_desc , B.to_room_no , B.to_bed_no , NULL to_practitioner_long_name ,NULL to_specialty_short_desc , DECODE(A.MOVEMENT_TYPE,'A','Arrived at ','D','Departed to ')|| decode(TO_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_locn_code,'"+locale+"','2') , OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.to_locn_code,'"+locale+"','1')) remarks, null Reason , NULL trn_code, AM_GET_DESC.AM_CONTACT_REASON(a.MOVEMENT_REASON_CODE,'"+locale+"','1') trn_desc FROM PR_PATIENT_MOVEMENT A, ip_adt_trn B WHERE A.facility_id='"+facility_id+"' AND B.encounter_id='"+encounter_id+"' AND A.srl_no like '%%' AND A.FROM_LOCN_TYPE IS NOT NULL AND A.FACILITY_ID = B.FACILITY_ID AND A.ENCOUNTER_ID = B.ENCOUNTER_ID and b.added_date = (select max(added_date) from ip_adt_trn where FACILITY_ID = B.FACILITY_ID AND ENCOUNTER_ID = B.ENCOUNTER_ID) ORDER BY trn_date_time");



		sqlQuery.append("SELECT TO_CHAR(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time ,a.added_by_id ,A.trn_date_time,decode(A.trn_type,'D', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'),'L',IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_nursing_unit,'"+locale+"','2')) to_nursing_unit_short_desc,decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no,decode(A.trn_type,'D',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),'L',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),AM_GET_DESC.AM_PRACTITIONER(a.to_practitioner_id,'"+locale+"','1')) to_practitioner_long_name,decode(A.trn_type,'D',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),'L',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),AM_GET_DESC.AM_SPECIALITY(a.to_specialty_code,'"+locale+"','2')) to_specialty_short_desc,DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transferred','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave') remarks,AM_GET_DESC.AM_COMPLAINT( B.CHIEF_COMPLAINT , '"+locale+"','1') Reason ,a.trn_code,(CASE WHEN a.trn_type = 'A' THEN IP_GET_DESC.IP_ADMISSION_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'T' THEN IP_GET_DESC.IP_TRANSFER_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'D' THEN IP_GET_DESC.IP_DISCHARGE_TYPE(a.trn_code,'"+locale+"','2') END ) trn_desc FROM IP_ADT_TRN A ,PR_ENCOUNTER B WHERE A.facility_id='"+facility_id+"' AND A.encounter_id='"+encounter_id+"' AND  A.encounter_id= B.encounter_id AND a.srl_no like '%%' and a.facility_id = b.facility_id UNION SELECT TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy hh24:mi')trans_date_time, a.added_by_id, a.ADDED_DATE trn_date_time, IP_GET_DESC.IP_NURSING_UNIT(B.facility_id, B.to_nursing_unit,'"+locale+"','2') to_nursing_unit_short_desc , B.to_room_no , B.to_bed_no , NULL to_practitioner_long_name ,NULL to_specialty_short_desc , DECODE(A.MOVEMENT_TYPE,'A','Arrived at ','D','Departed to ')|| decode(TO_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_locn_code,'"+locale+"','2') ,  'C', op_get_desc.op_clinic (a.facility_id, a.to_locn_code, '"+locale+"', '2' ), 'E', op_get_desc.op_clinic (a.facility_id, a.to_locn_code,'"+locale+"','2' ),'Y', op_get_desc.op_clinic (a.facility_id,  a.to_locn_code, '"+locale+"', '2'  ),  'O', (SELECT short_desc  FROM ot_oper_room_lang_vw   WHERE oper_room_code = a.to_locn_code  AND language_id ='"+locale+"'),'W', (SELECT short_desc   FROM rd_clinic_lang_vw  WHERE clinic_code = a.to_locn_code  AND language_id = '"+locale+"'),  'R', (SELECT short_desc  FROM am_facility_room_lang_vw   WHERE room_num = a.to_locn_code  AND language_id = '"+locale+"')) remarks, null Reason , NULL trn_code, AM_GET_DESC.AM_CONTACT_REASON(a.MOVEMENT_REASON_CODE,'"+locale+"','1') trn_desc FROM PR_PATIENT_MOVEMENT A, ip_adt_trn B WHERE A.facility_id='"+facility_id+"' AND B.encounter_id='"+encounter_id+"' AND A.srl_no like '%%' AND A.FROM_LOCN_TYPE IS NOT NULL AND A.FACILITY_ID = B.FACILITY_ID AND A.ENCOUNTER_ID = B.ENCOUNTER_ID and b.added_date = (select max(added_date) from ip_adt_trn where FACILITY_ID = B.FACILITY_ID AND ENCOUNTER_ID = B.ENCOUNTER_ID) ORDER BY trn_date_time desc");
System.out.println("sqlQuery last details::"+sqlQuery.toString());


		
%>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
	
		<table cellspacing=0 cellpadding=2 align='center' width='130%' border='1'>
		<tr>
			<td  colspan='10' class='CAGROUPHEADING'>&nbsp;<fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td>
		</tr>
			
		<tr>
			<td class="COLUMNHEADER"><fmt:message key="eIP.Activity.label" bundle="${ip_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="eIP.ActivityReason.label" bundle="${ip_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<%//f(!(filename.equals("CurrentEncounterMain")))
	        
	//%>		<!-- below lines commented by venkatesh.s(em_id:4008) on 19/Sep/2011 for the incident SRR20056-SCF-7120-INO26963-->
	<!--<td class="COLUMNHEADER"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td> -->
	<!--end for the incident SRR20056-SCF-7120-INO26963-->	
	        <%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
			<td class="COLUMNHEADER"><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></td>
			<%}else {%>
			<td class="COLUMNHEADER"><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/></td>
			<%}%>
		</tr>

		<% 	
		
		stmt1 = con.createStatement();	
		rset1 = stmt1.executeQuery(sqlQuery.toString());
		
		System.err.println("LastAdmissionResult.jsp sqlQuery 75==>"+sqlQuery);
		while(rset1.next()) 
		{ 
		  String trn_date_time_converted = "";
		  String trn_desc				= checkForNull(rset1.getString("trn_desc"));
		    if(trn_desc.equals("")) trn_desc = "&nbsp;";
		  String trn_date_time				= checkForNull(rset1.getString("trans_date_time"));
		  String to_nursing_unit_short_desc	= checkForNull(rset1.getString("to_nursing_unit_short_desc"),"&nbsp;");
		  String to_room_no					= checkForNull(rset1.getString("to_room_no"),"&nbsp;");
		  String to_bed_no					= checkForNull(rset1.getString("to_bed_no"),"&nbsp;");
		  String to_practitioner_long_name	= checkForNull(rset1.getString("to_practitioner_long_name"),"&nbsp;");
		  String added_by = checkForNull(rset1.getString("added_by_id"),"&nbsp;");

		  String to_specialty_short_desc	= checkForNull(rset1.getString("to_specialty_short_desc"),"&nbsp;");
		  String remarks					= checkForNull(rset1.getString("remarks"),"&nbsp;");
		  String reason						= checkForNull(rset1.getString("reason"),"&nbsp;");
		  if(!(trn_date_time.equals("") || trn_date_time.equals("&nbsp;") || trn_date_time == null))
					trn_date_time_converted = DateUtils.convertDate(trn_date_time,"DMYHM","en",locale); 
	
		  
		  if (classValue.equals("") || classValue.equals("QRYODDSMALL"))  
			  classValue = "QRYEVENSMALL";
		  else
			  classValue = "QRYODDSMALL";

		  if(remarks.equalsIgnoreCase("Admission Cancelled"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelledAdmission.label","ip_labels");
			}
		else if(remarks.equalsIgnoreCase("Admitted"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Transferred"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Transferred.label","ip_labels");
			}
		else if(remarks.equalsIgnoreCase("Discharged"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Leave"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Leave Cancelled"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels")+' '+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Rejoined from Leave"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejoinedFromLeave.label","ip_labels");
			}
	   %>
		<tr>
			<td class=<%=classValue%> ><%=remarks%></td>
			<td class=<%=classValue%> ><%=trn_date_time_converted%></td>
			<td class=<%=classValue%> ><%=trn_desc%></td>
			<td class=<%=classValue%> ><%=to_nursing_unit_short_desc%></td>
			<td class=<%=classValue%> ><%=to_room_no%></td>
			<td class=<%=classValue%> ><%=to_bed_no%></td>
			<td class=<%=classValue%> ><%=to_practitioner_long_name%></td>
			<td class=<%=classValue%> ><%=to_specialty_short_desc%></td>
	     <!--   <td class=<%=classValue%> style = 'word-break:break-all;'><%=reason%></td> -->
			<td class=<%=classValue%> ><%=added_by%></td>
		</tr>
	<%		}
	if(rset1!=null)	rset1.close();
	if(stmt1!=null) stmt1.close();
	%>
	</table>
</FORM>


<% } catch(Exception e) {/* out.println(e); */e.printStackTrace(); }
finally
{
	try{
		if(rset1!=null)	rset1.close();
		if(stmt1!=null) stmt1.close();
		ConnectionManager.returnConnection(con,request);
	} catch(Exception ee) {/* out.println("Error while closing the connections :"+ee.toString()); */ ee.printStackTrace();}
}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

