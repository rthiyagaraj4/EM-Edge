<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eOP/js/QryCancelledOPVisits.js'></script>
<%

Connection conn  =null;
Statement stmt = null;
ResultSet rs = null;

try{

		conn  =  ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		String locale=(String)session.getAttribute("LOCALE");
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' onMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>");

		Boolean isRemarksFieldAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "REMARKS_FOR_OTHERS"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	  
		StringBuffer sql= new StringBuffer();
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		//int andCheck = 0;
		String endOfRes="1";	
			
		String operatingfacilityid=(String)session.getValue("facility_id") == null?"":(String)session.getValue("facility_id");
		String fromdate = request.getParameter("date_from") == null?"":request.getParameter("date_from");         
        String todate = request.getParameter("date_to") == null?"":request.getParameter("date_to");           
        String speciality_code = request.getParameter("splty_code")== null?"":request.getParameter("splty_code");              
        String servicecode = request.getParameter("service_code")== null?"":request.getParameter("service_code");             
        String cliniccode = request.getParameter("locn_code")== null?"":request.getParameter("locn_code");          
        String practitionerid = request.getParameter("pract_id")== null?"":request.getParameter("pract_id");            
        String patientid = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");            
        String whereclause = request.getParameter("whereclause")== null?"":request.getParameter("whereclause");  
		
		if(whereclause.equals(""))
		{        
		
			if(!fromdate.equals(""))
			{
				sql.append(" and trunc(a.queue_date) >= trunc(to_date('"+fromdate+"','dd/mm/yyyy')) ");
			}

			if(!todate.equals(""))
			{
				sql.append(" and trunc(a.queue_date) <= trunc(to_date('"+todate+"','dd/mm/yyyy')) ");
			}

			if(!speciality_code.equals(""))
			{
				sql.append(" and a.speciality_code = '"+speciality_code+"' ");
			}

			if(!servicecode.equals(""))
			{
				sql.append(" and a.service_code = '"+servicecode+"' ");
			}

			if(!patientid.equals(""))
			{
				sql.append(" and a.patient_id = '"+patientid+"' ");
			}

			if(!practitionerid.equals(""))
			{
				sql.append(" and a.practitioner_id = '"+practitionerid+"' ");
			}

			if(!cliniccode.equals(""))
			{
				sql.append(" and a.locn_code = '"+cliniccode+"' ");
			}   

		}
		else
		{
			sql.append(whereclause);
		}
   
		String queue_date = "" ;
		String encounter_id = "";
		String patient_id = "";
		String patient_name = "";
		String age = "";
		String sex = "";
		String locn_desc = "";
		String service_desc = "";
		String speciality_desc = "";
		String practitioner_name = "";
		String classValue = "" ;
		String cancelled_date = "";
		String cancel_reason_desc = "";
		String cancelled_by_id = "";
		String cancel_visit_remarks = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 10 ;
		else
			end = Integer.parseInt( to ) ;

		rs = stmt.executeQuery(" select a.queue_date queue_date, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date1, a.ENCOUNTER_ID, a.PATIENT_ID, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, get_age(b.date_of_birth) age, b.sex sex, op_get_desc.op_clinic(a.facility_id, a.locn_code,'"+locale+"',1) LOCN_DESC, am_get_desc.am_service(a.SERVICE_CODE,'"+locale+"',2) service_desc, am_get_desc.am_speciality(a.SPECIALITY_CODE,'"+locale+"',2) speciality_desc, am_get_desc.am_practitioner (a.practitioner_id,'"+locale+"',1) practitioner_name, to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi') cancelled_date, am_get_desc.am_contact_reason(a.cancel_reason_code,'"+locale+"', 1) cancel_reason_desc, a.MODIFIED_BY_ID cancelled_by_id, a.cancel_visit_remarks from op_patient_queue a, mp_patient b where a.FACILITY_ID = '"+operatingfacilityid+"' and a.queue_status='99' and a.patient_class='OP' and a.patient_id=b.patient_id "+sql.toString()+"order by a.queue_date "); //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
      
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		int cnt=0;

		while ( i<=end && rs.next() )
		{
			if( cnt == 0 )
			{		
		%>
		<P>
		<table align='right'>
		<tr>
		<td>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF='../../eOP/jsp/QryCancelledOPVisitsResults.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( endOfRes.equals("1"))
			out.println("<A id='nextval' HREF='../../eOP/jsp/QryCancelledOPVisitsResults.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table><br>
		</P>


		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> <fmt:message key="Common.on.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> <fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<%if(isRemarksFieldAppl){%>
		<th class='columnheader'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th> 
		<%}%>
		<th class='columnheader'><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></th>		

		<%

		} 
	 
        if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;		

		queue_date = rs.getString("queue_date") == null?"&nbsp;":rs.getString("queue_date1");
		queue_date =DateUtils.convertDate(queue_date,"DMYHM","en",locale);//Added by Rameswar on 30-Sep-15 for Leap Year Issue 
		encounter_id = rs.getString("encounter_id") == null?"&nbsp;":rs.getString("encounter_id");
		patient_id = rs.getString("patient_id") == null?"&nbsp;":rs.getString("patient_id");

		patient_name = rs.getString("patient_name") == null?"&nbsp;":rs.getString("patient_name");
		age = rs.getString("age") == null?"&nbsp;":rs.getString("age");
		sex = rs.getString("sex") == null?"&nbsp;":rs.getString("sex");

		if(sex.equals("M"))
		{
		   sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); 
		}
		else if(sex.equals("F"))
		{
		   sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); 
        }
        else if(sex.equals("U"))
		{
		   sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}

		locn_desc = rs.getString("locn_desc") == null?"&nbsp;":rs.getString("locn_desc");
		service_desc = rs.getString("service_desc") == null?"&nbsp;":rs.getString("service_desc");
		speciality_desc = rs.getString("speciality_desc") == null?"&nbsp;":rs.getString("speciality_desc");
		practitioner_name = rs.getString("practitioner_name") == null?"&nbsp;":rs.getString("practitioner_name");
		cancelled_date = rs.getString("cancelled_date") == null?"&nbsp;":rs.getString("cancelled_date");
		cancel_reason_desc = rs.getString("cancel_reason_desc") == null?"&nbsp;":rs.getString("cancel_reason_desc");
		cancelled_by_id = rs.getString("cancelled_by_id") == null?"&nbsp;":rs.getString("cancelled_by_id");
		cancel_visit_remarks = rs.getString("cancel_visit_remarks") == null?"&nbsp;":rs.getString("cancel_visit_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

		out.println("<tr><td class='"+classValue+"' nowrap>");
		out.println(queue_date);
		out.println("</td><td class='"+classValue+"'>");
		out.println(encounter_id);
		out.println("</td><td class='"+classValue+"'>");
		out.println(patient_id);
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(patient_name);
		out.println("</td><td class='"+classValue+"'>");
		out.println(age);		
		out.println("</td><td class='"+classValue+"'>");
		out.println(sex);
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(locn_desc);
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(service_desc);
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(speciality_desc);
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(practitioner_name);
		out.println("</td><td class='"+classValue+"' nowrap>");
		cancelled_date=DateUtils.convertDate(cancelled_date,"DMYHM","en",locale); //Added by Rameswar on 30-Sep-15 for Leap Year Issue 
		out.println(cancelled_date);
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(cancel_reason_desc);
		//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		if(isRemarksFieldAppl){
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(cancel_visit_remarks);
		}
		out.println("</td><td class='"+classValue+"' nowrap>");
		out.println(cancelled_by_id);
		out.println("</td></tr>");

		i++;
		cnt++;
	}

   if (!rs.next() && cnt!=0 )
    {
    endOfRes = "0";	
	%>
		<script>
		document.getElementById("nextval").innerHTML=" ";
		//document.getElementById("nextval").style.visibility='hidden';
		</script>
		<!--<tr>
			<td class='labelcenter' colspan='14'><fmt:message key="Common.EndofResults.label" bundle="${common_labels}"/></td>
		</tr>-->
	<%
 }

//}
if(rs!=null)rs.close();
if(stmt != null) stmt.close();

sql.setLength(0);

if( cnt == 0 ){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
}

}
catch(Exception e){out.println(e);}
finally{
out.println("<script>parent.frames[1].query_criteria_form.search_button.disabled=false;</script>");
if(stmt!=null)stmt.close();
if(rs!=null)rs.close();

if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

%>

</td></tr>
</table>
</center>

<br><center>

</center>
</BODY>
</HTML>

