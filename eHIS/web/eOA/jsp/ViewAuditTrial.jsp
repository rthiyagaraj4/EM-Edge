<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" %>
      
<html>  
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eOA/js/AppointmentDetails.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
request.setCharacterEncoding("UTF-8");	
%>
<%
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
//String p_sql = "";
//String patientid="";
//String pname="";
//String dob="";
//String gender="";
//String modifiedbyid="";
//String modifieddate="";
//String resource="";
//String res_class_desc="";
//String genderdesc="";
//String resource_name="";
String apptrefno=request.getParameter("apptrefno1");
//String date=request.getParameter("date");
//String loc=request.getParameter("loc");
//String res=request.getParameter("res");
String locale			= (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getValue("facility_id");

%>
<body onKeyDown = 'lockKey()'>
<form name='view_audittrail' id='view_audittrail'  method='post'>

<%
try{
	
%>

<table  width='100%' align='center'>	 
	 <tr ><td  colspan='12'  >&nbsp;</td></tr>
</table>
<table border='1'  cellspacing='0' width='100%' align='center'>
<tr><td  class='COLUMNHEADER' colspan='12' align='center'  >&nbsp;<fmt:message key="Common.CancelledDetail.label" bundle="${common_labels}"/> </td></tr>
<tr><td  class='COLUMNHEADER' colspan='12' align='center'  >&nbsp;</td></tr>
<tr>
		<td class='COLUMNHEADER'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' colspan='2'><fmt:message key="Common.ApptDate/Time.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>		
		<td class='COLUMNHEADER' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' colspan='2'><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' colspan='2' ><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' colspan='2'><fmt:message key="Common.CancellationDate.label" bundle="${common_labels}"/></td>			
	 </tr>
	 
	 <%try{
	con	= ConnectionManager.getConnection(request); 
     
    String apptdatetime="",specialty="",location="",resource="",cancellationreson="",cancelledby="",cancelleddate="",cancelledapptrefno="";
	 
	 //Query tuning for full table scan [IN:051268]
	 //String dtl_sql_cancelled="SELECT am_get_desc.am_speciality(NVL(FROM_SPECIALITY_CODE,SPECIALITY_CODE),'en','1')SPECIALITY_DESC, op_get_desc.op_clinic(FACILITY_ID,NVL(FROM_CLINIC_CODE,CLINIC_CODE),'en','1') CLINIC_DESC,decode(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'en','1'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'en','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'en','2')) RESOURCE_NAME,to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:MI') APPT_DATE_TIME,am_get_desc.am_contact_reason(REASON_FOR_CANCEL,'en','1') Reason_FOR_CANCEL,sm_get_desc.sm_appl_user(ADDED_BY_ID,'en','1') CANCELLED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi') CANCELLED_DATE,APPT_REF_NO from OA_APPT_DEL_TR WHERE FACILITY_ID='"+facility_id+"' and NEW_APPT_REF_NO='"+apptrefno+"' and appt_status = 'C' and FACILITY_ID BETWEEN NVL ('%%','%%')  AND NVL ('',FACILITY_ID)";	 
	 String dtl_sql_cancelled="SELECT am_get_desc.am_speciality(NVL(FROM_SPECIALITY_CODE,SPECIALITY_CODE),'en','1')SPECIALITY_DESC, op_get_desc.op_clinic(FACILITY_ID,NVL(FROM_CLINIC_CODE,CLINIC_CODE),'en','1') CLINIC_DESC,decode(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'en','1'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'en','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'en','2')) RESOURCE_NAME,to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:MI') APPT_DATE_TIME,am_get_desc.am_contact_reason(REASON_FOR_CANCEL,'en','1') Reason_FOR_CANCEL,sm_get_desc.sm_appl_user(ADDED_BY_ID,'en','1') CANCELLED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi') CANCELLED_DATE,APPT_REF_NO from OA_APPT_DEL_TR WHERE FACILITY_ID=? and NEW_APPT_REF_NO=? and appt_status = 'C' and FACILITY_ID BETWEEN NVL ('%%','%%')  AND NVL ('',FACILITY_ID)";	 
	 
	 stmt	= con.createStatement();
	// rs		= stmt.executeQuery(dtl_sql_cancelled);
	 pstmt = con.prepareStatement(dtl_sql_cancelled);
	 pstmt.setString(1,facility_id);
	 pstmt.setString(2,apptrefno);
	 rs = pstmt.executeQuery();
	 while(rs!=null &&rs.next()){	 
	
	   apptdatetime=rs.getString("APPT_DATE_TIME")==null?"&nbsp;":rs.getString("APPT_DATE_TIME");
	   apptdatetime=DateUtils.convertDate(apptdatetime,"DMYHM","en",locale);	
	   specialty=rs.getString("SPECIALITY_DESC")==null?"&nbsp;":rs.getString("SPECIALITY_DESC");
	   location=rs.getString("CLINIC_DESC")==null?"&nbsp;":rs.getString("CLINIC_DESC");
	   resource=rs.getString("RESOURCE_NAME")==null?"&nbsp;":rs.getString("RESOURCE_NAME");
	   cancellationreson=rs.getString("REASON_FOR_CANCEL")==null?"&nbsp;":rs.getString("REASON_FOR_CANCEL");
	   cancelledby=rs.getString("CANCELLED_BY_ID")==null?"&nbsp;":rs.getString("CANCELLED_BY_ID");	  
	   cancelleddate=rs.getString("CANCELLED_DATE")==null?"&nbsp;":rs.getString("CANCELLED_DATE");				
	   cancelleddate=DateUtils.convertDate(cancelleddate,"DMYHM","en",locale);			
	   cancelledapptrefno=rs.getString("APPT_REF_NO")==null?"&nbsp;":rs.getString("APPT_REF_NO");			
	   out.println("<tr>");
				   out.println("<td FONT-SIZE: 6pt nowrap >"+cancelledapptrefno+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap colspan='2'>"+apptdatetime+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap >"+specialty+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+location+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+resource+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap colspan='2'>"+cancellationreson+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap colspan='2'>"+cancelledby+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap colspan='2'>"+cancelleddate+"</td>");
	  out.println("</tr>"); 
	 }if(rs !=null) rs.close();if(stmt !=null) stmt.close();
	 
	 } catch(Exception e){
	//out.println(e);
	 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	 }%>	 
	 <tr><td  nowrap colspan='12'   >&nbsp;</td></tr>
	 <tr>
		<td class='COLUMNHEADER' colspan='4' align='center'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' colspan='4' align='center'><fmt:message key="Common.current.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.modifieddatetime.label" bundle="${common_labels}"/></td>
	</tr>
		<tr>
		<td class='COLUMNHEADER' ><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.ApptDate/Time.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.ApptDate/Time.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'>&nbsp;</td>
		<td class='COLUMNHEADER'>&nbsp;</td>
		<td class='COLUMNHEADER'>&nbsp;</td>
		<td class='COLUMNHEADER'>&nbsp;</td>
		</tr>
<%
		try{
			//String dtl_sql="SELECT am_get_desc.am_speciality(NVL(FROM_SPECIALITY_CODE,SPECIALITY_CODE),'"+locale+"','1')PREV_SPECIALITY_DESC, op_get_desc.op_clinic(FACILITY_ID,NVL(FROM_CLINIC_CODE,CLINIC_CODE),'"+locale+"','1') PREV_CLINIC_DESC, decode(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PREV_RESOURCE_NAME,to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:MI') PREV_APPT_DATE_TIME,RESOURCE_CLASS, am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"','1') SPECIALITY_DESC,  op_get_desc.op_clinic(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_DESC,decode(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(TR_PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) RESOURCE_NAME,to_char(APPT_TR_DATE,'dd/mm/yyyy') || ' ' || to_char(TR_APPT_SLAB_FROM_TIME,'hh24:mi') APPT_DATE_TIME, decode(appt_status,'N','Transfer','T','Transfer Schedule') action,(Case when appt_status in ('N','T') then am_get_desc.am_contact_reason(REASON_FOR_TRANSFER,'"+locale+"','1') else '' end) Reason,sm_get_desc.sm_appl_user(MODIFIED_BY_ID,'"+locale+"','1') MODIFIED_BY_ID, to_char(MODIFIED_DATE,'dd/mm/yyyy hh24:mi') MODIFIED_DATE, MODIFIED_DATE MODIFIED_DATE1 from OA_APPT_DEL_TR WHERE FACILITY_ID='"+facility_id+"' and APPT_REF_NO='"+apptrefno+"' and appt_status in ('N','T') order by MODIFIED_DATE1 desc";
			String dtl_sql="SELECT am_get_desc.am_speciality(NVL(FROM_SPECIALITY_CODE,SPECIALITY_CODE),?,'1')PREV_SPECIALITY_DESC, op_get_desc.op_clinic(FACILITY_ID,NVL(FROM_CLINIC_CODE,CLINIC_CODE),?,'1') PREV_CLINIC_DESC, decode(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) PREV_RESOURCE_NAME,to_char(APPT_DATE,'dd/mm/yyyy') || ' ' || to_char(APPT_TIME,'HH24:MI') PREV_APPT_DATE_TIME,RESOURCE_CLASS, am_get_desc.am_speciality(SPECIALITY_CODE,?,'1') SPECIALITY_DESC,  op_get_desc.op_clinic(FACILITY_ID,CLINIC_CODE,?,'1') CLINIC_DESC,decode(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(TR_PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) RESOURCE_NAME,to_char(APPT_TR_DATE,'dd/mm/yyyy') || ' ' || to_char(TR_APPT_SLAB_FROM_TIME,'hh24:mi') APPT_DATE_TIME, decode(appt_status,'N','Transfer','T','Transfer Schedule') action,(Case when appt_status in ('N','T') then am_get_desc.am_contact_reason(REASON_FOR_TRANSFER,?,'1') else '' end) Reason,sm_get_desc.sm_appl_user(MODIFIED_BY_ID,?,'1') MODIFIED_BY_ID, to_char(MODIFIED_DATE,'dd/mm/yyyy hh24:mi') MODIFIED_DATE, MODIFIED_DATE MODIFIED_DATE1 from OA_APPT_DEL_TR WHERE FACILITY_ID=? and APPT_REF_NO=? and appt_status in ('N','T') order by MODIFIED_DATE1 desc";
			stmt	= con.createStatement();
			String prev_splty_desc="";
			String prev_clinic_desc="";
			String prv_resource_class="";
			String prv_resource_name="";
			String prev_appt_date_time="";
			String cur_splty_desc="";
			String cur_clinic_desc="";
			String cur_resource_class="";
			String cur_resource_name="";
			String cur_appt_date_time="";
			String action="";
			String reason="";
			String modified_by_id="";
			String modified_date="";
			//rs		= stmt.executeQuery(dtl_sql);
			pstmt = con.prepareStatement(dtl_sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			pstmt.setString(9,locale);
			pstmt.setString(10,locale);
			pstmt.setString(11,locale);
			pstmt.setString(12,locale);
			pstmt.setString(13,facility_id);
			pstmt.setString(14,apptrefno);
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()){
				prev_splty_desc=rs.getString("PREV_SPECIALITY_DESC")==null?"":rs.getString("PREV_SPECIALITY_DESC");
				prev_clinic_desc=rs.getString("PREV_CLINIC_DESC")==null?"":rs.getString("PREV_CLINIC_DESC");
				prv_resource_class=rs.getString("RESOURCE_CLASS")==null?"":rs.getString("RESOURCE_CLASS");
				prv_resource_name=rs.getString("PREV_RESOURCE_NAME")==null?"":rs.getString("PREV_RESOURCE_NAME");
				prev_appt_date_time=rs.getString("PREV_APPT_DATE_TIME")==null?"":rs.getString("PREV_APPT_DATE_TIME");				
				prev_appt_date_time=DateUtils.convertDate(prev_appt_date_time,"DMYHM","en",locale);				
				cur_splty_desc=rs.getString("SPECIALITY_DESC")==null?"":rs.getString("SPECIALITY_DESC");
				cur_clinic_desc=rs.getString("CLINIC_DESC")==null?"":rs.getString("CLINIC_DESC");
				cur_resource_name=rs.getString("RESOURCE_NAME")==null?"":rs.getString("RESOURCE_NAME");
				cur_appt_date_time=rs.getString("APPT_DATE_TIME")==null?"":rs.getString("APPT_DATE_TIME");				
				cur_appt_date_time=DateUtils.convertDate(cur_appt_date_time,"DMYHM","en",locale);				
				action=rs.getString("action")==null?"&nbsp;":rs.getString("action");
				reason=rs.getString("Reason")==null?"&nbsp;":rs.getString("Reason");
				modified_by_id=rs.getString("MODIFIED_BY_ID")==null?"&nbsp;":rs.getString("MODIFIED_BY_ID");
				modified_date=rs.getString("MODIFIED_DATE")==null?"&nbsp;":rs.getString("MODIFIED_DATE");				
				modified_date=DateUtils.convertDate(modified_date,"DMYHM","en",locale);				
				if(prv_resource_class.equals("P")){
					prv_resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(prv_resource_class.equals("E")){
					prv_resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(prv_resource_class.equals("R")){
					prv_resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(prv_resource_class.equals("O")){
					prv_resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}else if(prv_resource_class.equals("B")){
					prv_resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels");
				}

				cur_resource_class=prv_resource_class;
				out.println("<tr>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+prev_splty_desc+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+prev_clinic_desc+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+prv_resource_class+"/"+prv_resource_name+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+prev_appt_date_time+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+cur_splty_desc+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+cur_clinic_desc+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+cur_resource_class+"/"+cur_resource_name+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+cur_appt_date_time+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+action+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+reason+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+modified_by_id+"</td>");
				  out.println("<td FONT-SIZE: 6pt nowrap>"+modified_date+"</td>");
				out.println("</tr>");
			} if(rs !=null) rs.close();if(stmt !=null) stmt.close();
		}catch(Exception ex){
			//out.println("OA view audit Exception =>"+ex);
			ex.printStackTrace();
		}


%>
<tr>
	 </table>
 <form>
</body>
<%  if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
		 } catch(Exception e){
		//out.println(e);
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
   finally
    {
    	if(con!=null)
		ConnectionManager.returnConnection(con,request);
    }
%>
</html>

