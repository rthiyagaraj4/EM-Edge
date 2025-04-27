<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.* "%>
 <html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eOA/js/AppointmentDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<title><fmt:message key="eOA.NoShowappt.label" bundle="${oa_labels}"/></title>


</head>
 <% request.setCharacterEncoding("UTF-8");	
	 Connection conn = null;
    PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rsas=null;
	String locale="";
	String patient_id=request.getParameter("patient_id");
	if(patient_id ==null) patient_id="";
	String facility_name="";
	String Appointment_date="";
	String Appointment_from_time="";
	String Appointment_to_time="";
	String Location="";
	String resource="";
	String contact_reason="";
	String Visit_type=""; 
	String classValue		="";
	int i=0;
	String facility="",appttype="",apptypecode="";

try
{

	conn = ConnectionManager.getConnection(request);
	 stmt = conn.createStatement();
	locale = (String)session.getAttribute("LOCALE");
	
	java.util.HashMap hm=getColorCodeDetails(conn); //Added for this incident [IN:037012]

	//String sql="SELECT sm_get_desc.sm_facility_param(facility_id,'"+locale+"','1') facility_name,TO_CHAR (appt_date,'DD/MM/YYYY')AppointmentDate,TO_CHAR (APPT_SLAB_FROM_TIME, 'HH24:MI') Appointment_from_Time,TO_CHAR (APPT_SLAB_TO_TIME, 'HH24:MI') Appointment_to_Time,OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,'"+locale+"','1') clinic_name, DECODE(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'))  practitioner_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID,APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc,AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,'"+locale+"','1') CONTACT_REASON FROM oa_appt WHERE APPT_STATUS='1' AND PATIENT_ID='"+patient_id+"' AND TRUNC(APPT_DATE) BETWEEN TRUNC(SYSDATE-(SELECT NVL(PER_CHK_FOR_NO_SHOW_ALERT,0) FROM OA_PARAM WHERE MODULE_ID='OA')) AND TRUNC(SYSDATE) AND to_date(to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:mi'),'dd/mm/yyyy HH24:mi') < sysdate order by AppointmentDate,Appointment_from_Time";

String sql="SELECT facility_id, appt_type_code, sm_get_desc.sm_facility_param(facility_id,?,'1') facility_name,TO_CHAR (appt_date,'DD/MM/YYYY')AppointmentDate,TO_CHAR (APPT_SLAB_FROM_TIME, 'HH24:MI') Appointment_from_Time,TO_CHAR (APPT_SLAB_TO_TIME, 'HH24:MI') Appointment_to_Time,OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, DECODE(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID,APPT_TYPE_CODE,?,'2') visit_type_short_desc,AM_GET_DESC.AM_CONTACT_REASON(CONTACT_REASON_CODE,?,'1') CONTACT_REASON FROM oa_appt WHERE APPT_STATUS='1' AND PATIENT_ID=? AND TRUNC(APPT_DATE) BETWEEN TRUNC(SYSDATE-(SELECT NVL(PER_CHK_FOR_NO_SHOW_ALERT,0) FROM OA_PARAM WHERE MODULE_ID='OA')) AND TRUNC(SYSDATE) AND to_date(to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:mi'),'dd/mm/yyyy HH24:mi') < sysdate order by AppointmentDate,Appointment_from_Time";	
	
	
	//Aboev Query Modified for this incident 
	
	//rsas=stmt.executeQuery(sql);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,locale);
	pstmt.setString(3,locale);
	pstmt.setString(4,locale);
	pstmt.setString(5,locale);
	pstmt.setString(6,locale);
	pstmt.setString(7,locale);
	pstmt.setString(8,locale);
	pstmt.setString(9,patient_id);
	rsas = pstmt.executeQuery();
		
 %>
 
 </head>
 <body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onunload="clear_from_sess()">

<table border='1' cellpadding='0' cellspacing='0' width='102%' align='center' >
	<tr>
			<td class='COLUMNHEADER'   nowrap><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'   nowrap><b><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></b></td>
			<td class='COLUMNHEADER'   nowrap><b><fmt:message key="Common.totime.label" bundle="${common_labels}"/></b></td>
			<td class='COLUMNHEADER'   nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'   nowrap><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'   nowrap><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'  nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
	</tr>
	

<%
			if(rsas!=null)
			{
				while(rsas.next())
				{
					if ( i % 2 == 0 )
					{
					  classValue = "QRYEVEN" ;
					}else{
					  classValue = "QRYODD" ;
					}
					String colour_indicator="";
				/*Below line Added for Bru-HIMS-CRF-177 linked incident [IN:037012]*/	
				facility=rsas.getString("facility_id")==null?"":rsas.getString("facility_id");
                appttype=rsas.getString("appt_type_code")==null?"":rsas.getString("appt_type_code"); 	
               
				 facility_name=rsas.getString("facility_name");
				 Appointment_date=rsas.getString("AppointmentDate");
				 Appointment_from_time=rsas.getString("Appointment_from_Time");
				 Appointment_to_time=rsas.getString("Appointment_to_Time");
				 Location=rsas.getString("clinic_name");
				 resource=rsas.getString("practitioner_name");
				 contact_reason=rsas.getString("CONTACT_REASON");
				 Visit_type=rsas.getString("visit_type_short_desc");
				
				/*Below line Added for Bru-HIMS-CRF-177 linked incident [IN:037012]*/
				apptypecode=appttype+facility;				
                if(apptypecode==null || apptypecode.equals("null")) apptypecode="";
				colour_indicator =(String)hm.get(apptypecode);		
				if(colour_indicator==null || colour_indicator.equals("null")) colour_indicator="";

				out.println("<tr>");
				out.println("<td  class='"+classValue+"'>"+facility_name+"</td>");
				out.println("<td  class='"+classValue+"'>"+Appointment_date+"</td>");
				out.println("<td  class='"+classValue+"'>"+Appointment_from_time+"</td>");
				out.println("<td  class='"+classValue+"'>"+Appointment_to_time+"</td>");
				out.println("<td  class='"+classValue+"'>"+Location+"</td>");
				out.println("<td  class='"+classValue+"'>"+resource+"</td>");
				out.println("<td  class='"+classValue+"'>"+contact_reason+"</td>");
				out.println("<td  class='"+classValue+"' style=background-color:"+colour_indicator+">"+Visit_type+"</td>");

				out.println("</tr>");;
%>

	 
	<%	
			i++;
				}
			}	


%>
	</table>



<%
	
if(stmt!=null) stmt.close();
if(rsas !=null) rsas.close();

}catch(Exception e){
	//out.println(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
    ConnectionManager.returnConnection(conn,request);
}

%>
<table border='0' cellpadding='0' cellspacing='0' width='5%' align='right' 	id='allbuttons'>

<tr>
<td  align='right'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onclick='exitwin_normal()'>
</td>
</tr>
</table>
</body>
</html>


<%!     /*Below function Added for this CRF [Bru-HIMS-CRF-177]  linked incident [IN:037012]*/
   HashMap getColorCodeDetails(Connection con1)
    {
		java.sql.Statement colorcodestmt		= null;
        ResultSet colorcoderset				= null; 
		 String colour_indicator_code="",visite_code="",facility="";
		   java.util.HashMap colorhm=new java.util.HashMap ();
	  try{
	   String colour_indicator_query1="select VISIT_TYPE_CODE,FACILITY_ID,COLOR_INDICATOR from op_visit_type"; 	  
       colorcodestmt = con1.createStatement();				 
		colorcoderset = colorcodestmt.executeQuery(colour_indicator_query1);
		  while( colorcoderset != null && colorcoderset.next()){
		            String visitcode_facility=""; 
				    visite_code=colorcoderset.getString("VISIT_TYPE_CODE")==null?"":colorcoderset.getString("VISIT_TYPE_CODE");
					facility=colorcoderset.getString("FACILITY_ID")==null?"":colorcoderset.getString("FACILITY_ID");					
				    colour_indicator_code=colorcoderset.getString("COLOR_INDICATOR")==null?"":colorcoderset.getString("COLOR_INDICATOR");
					visitcode_facility=visite_code+facility;
                    if(visitcode_facility==null || visitcode_facility.equals("null")) visitcode_facility="";					
				    colorhm.put(visitcode_facility,colour_indicator_code);									
		  }			
          if(colorcodestmt!=null) colorcodestmt.close();					
		  if(colorcoderset !=null)colorcoderset.close();
	  
	  }catch(Exception e){
	e.printStackTrace();
	}
	   return colorhm;
		
		
		
	}	/*Endthis CRF [Bru-HIMS-CRF-177]*/
%>

