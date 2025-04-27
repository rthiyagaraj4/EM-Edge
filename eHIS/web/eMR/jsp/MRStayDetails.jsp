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
		enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY");// Added by shagar for ML-MMOH-CRF-1328
//		String patientId	= checkForNull(request.getParameter("patientId"));
//		String filename		= checkForNull(request.getParameter("Filename"));
		String encounter_id = checkForNull(request.getParameter("encounter_id"));
		String facilityId	= (String)session.getValue("facility_id");
		String facility_id	= checkForNull(request.getParameter("facility_id"), facilityId);

		String classValue	= "";
		StringBuffer sqlQuery	= new StringBuffer();

		
		
		sqlQuery.append("SELECT  DECODE(d.to_locn_type,'N', ip_get_desc.ip_nursing_unit (d.facility_id, d.to_locn_code,'"+locale+"','2'),'C', op_get_desc.op_clinic (d.facility_id, d.to_locn_code,'"+locale+"','2'), 'E', op_get_desc.op_clinic (d.facility_id,d.to_locn_code,'"+locale+"','2'),'Y', op_get_desc.op_clinic (d.facility_id,d.to_locn_code,'"+locale+"','2'),'O', (SELECT short_desc FROM ot_oper_room_lang_vw  WHERE oper_room_code = d.to_locn_code AND language_id = '"+locale+"'),'W', (SELECT short_desc FROM rd_clinic_lang_vw WHERE clinic_code = d.to_locn_code AND language_id = '"+locale+"'),'R', (SELECT short_desc FROM am_facility_room_lang_vw WHERE room_num = d.to_locn_code AND language_id = '"+locale+"')) to_location,DECODE (d.to_locn_type,'C', 'Clinic','E', 'Procedure Unit','N','Nursing Unit','Y','Day Care','O','OT Specific','W','Radiology Wing','R','Room') location_type,sm_get_desc.sm_appl_user (d.added_by_id,'"+locale+"',1) added_by_id, DECODE (movement_type,'D', 'Departed','A', 'Arrived') movement_type,TO_CHAR (d.added_date, 'dd/mm/yyyy hh24:mi') mov_date_time,am_get_desc.am_contact_reason(d.movement_reason_code,'"+locale+"', 1) movement_reason FROM pr_encounter b,pr_patient_movement d  WHERE b.facility_id = '"+facility_id+"' AND d.from_locn_type IS NOT NULL AND b.encounter_id = '"+encounter_id+"' AND b.patient_id = d.patient_id AND b.encounter_id = d.encounter_id order by mov_date_time desc ");
		
		



		
%>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
	
		<table cellspacing=0 cellpadding=2 align='center' width='130%' border='1'>
		<tr>
			<td  colspan='10' class='CAGROUPHEADING'>&nbsp;<fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td>
		</tr>
			
		<tr>
			<td class="COLUMNHEADER"><fmt:message key="eIP.Activity.label" bundle="${ip_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.date.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
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
		 /* String trn_date_time_converted = "";
		  String trn_desc				= checkForNull(rset1.getString("trn_desc"));
		    if(trn_desc.equals("")) trn_desc = "&nbsp;";
		  String trn_date_time				= checkForNull(rset1.getString("trans_date_time")); // MOVEMENT_TYPE
		  String to_nursing_unit_short_desc	= checkForNull(rset1.getString("to_nursing_unit_short_desc"),"&nbsp;");
		  String to_room_no					= checkForNull(rset1.getString("to_room_no"),"&nbsp;");
		  String to_bed_no					= checkForNull(rset1.getString("to_bed_no"),"&nbsp;");
		  String to_practitioner_long_name	= checkForNull(rset1.getString("to_practitioner_long_name"),"&nbsp;");
		  String added_by = checkForNull(rset1.getString("added_by_id"),"&nbsp;");

		  String to_specialty_short_desc	= checkForNull(rset1.getString("to_specialty_short_desc"),"&nbsp;");
		  String remarks					= checkForNull(rset1.getString("remarks"),"&nbsp;");
		  String reason						= checkForNull(rset1.getString("reason"),"&nbsp;");
		  if(!(trn_date_time.equals("") || trn_date_time.equals("&nbsp;") || trn_date_time == null))
					trn_date_time_converted = DateUtils.convertDate(trn_date_time,"DMYHM","en",locale);  */
				
		  String action = checkForNull(rset1.getString("MOVEMENT_TYPE")); //
		String trn_date_time_converted = "";
		   String date_time				= checkForNull(rset1.getString("MOV_DATE_TIME")); 
		   if(!(date_time.equals("") || date_time.equals("&nbsp;") || date_time == null))
					trn_date_time_converted = DateUtils.convertDate(date_time,"DMYHM","en",locale);
				
			String reason						= checkForNull(rset1.getString("MOVEMENT_REASON"),"&nbsp;"); // LOCATION_TYPE
		   String location_type						= checkForNull(rset1.getString("LOCATION_TYPE"),"&nbsp;");
		   String location = checkForNull(rset1.getString("TO_LOCATION"),"&nbsp;"); //ADDED_BY_ID
		 String whoDoneIt = checkForNull(rset1.getString("ADDED_BY_ID"),"&nbsp;");
		  
		  if (classValue.equals("") || classValue.equals("QRYODDSMALL"))  
			  classValue = "QRYEVENSMALL";
		  else
			  classValue = "QRYODDSMALL";

		  if(action.equalsIgnoreCase("Departed"))
			{
				action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Departed.label","op_labels");
			}
		else if(action.equalsIgnoreCase("Arrived"))
			{
				action=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.arrived.label","op_labels");
			}
		
	   %>
		<tr>
			<td class=<%=classValue%> ><%=action%></td>
			<td class=<%=classValue%> ><%=trn_date_time_converted%></td>
			<td class=<%=classValue%> ><%=reason%></td>
			<td class=<%=classValue%> ><%=location_type%></td>
			<td class=<%=classValue%> ><%=location%></td>
			<td class=<%=classValue%> ><%=whoDoneIt%></td>
		</tr>
	<%		}
	if(rset1!=null)	rset1.close();
	if(stmt1!=null) stmt1.close();
	%>
	</table>
</FORM>


<% } catch(Exception e) {/* out.println(e); */ e.printStackTrace(); }
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

