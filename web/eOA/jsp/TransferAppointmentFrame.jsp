<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										 
---------------------------------------------------------------------------------------------------------------
--> 

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>  

<html>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
PreparedStatement pstmt =null;
String appt_day1 = request.getParameter("appt_day1");
String locale=(String)session.getAttribute("LOCALE");
if (appt_day1==null) appt_day1="";
if (!(appt_day1.equals(""))){
	if(appt_day1.equals("Sunday"))	{
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
	}else if(appt_day1.equals("Monday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
	}else if(appt_day1.equals("Tuesday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
	}else if(appt_day1.equals("Wednesday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
	}else if(appt_day1.equals("Thursday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
	}else if(appt_day1.equals("Friday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
	}else if(appt_day1.equals("Saturday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
	}
}
String i_appt_date = request.getParameter("i_appt_date");
Connection con=null;
ResultSet rs=null;
String visit_limit_rule="";
String slot_appt_ctrl="";
String alcn_criteria="";
String appt_ref_no=request.getParameter("i_appt_ref_no");
String facilityid=(String)session.getValue("facility_id");
String old_visit_type_ind1 = "";
String old_alcn_catg_code1 = "";
int no_of_slots_value1 = 0;
String patient_id1 = "";
String old_pract_id1 = "";
String old_clinic_code = "";
int curr_month=0;
String order_catalog_code="";
String order_id=request.getParameter("order_id");//--[IN027165]
try{
	con=ConnectionManager.getConnection(request);
	String alcn_crit="select slot_appt_ctrl ,visit_limit_rule,alcn_criteria,(select to_char(sysdate,'mm')from dual) curmon  from oa_param where module_id='OA' ";
	pstmt=con.prepareStatement(alcn_crit);
	rs = pstmt.executeQuery();
	while (rs !=null && rs.next()){
		visit_limit_rule= rs.getString("visit_limit_rule");
		slot_appt_ctrl  = rs.getString("slot_appt_ctrl");
		alcn_criteria= rs.getString("alcn_criteria");
		if(alcn_criteria==null) alcn_criteria="";
		curr_month= rs.getInt("curmon");
	}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();
	alcn_crit="select a.practitioner_id,a.clinic_code,a.patient_id,a.alcn_catg_code,b.visit_type_ind,a.no_of_slots,a.order_catalog_code from oa_appt a, op_visit_type b where a.facility_id = ? and a.appt_ref_no=? and b.facility_id = a.facility_id and b.visit_type_code = a.appt_type_code ";
	pstmt=con.prepareStatement(alcn_crit);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,appt_ref_no);	
	rs = pstmt.executeQuery();
	while (rs !=null && rs.next()){
		old_visit_type_ind1 = rs.getString("visit_type_ind");
		old_alcn_catg_code1=rs.getString("alcn_catg_code");
		if(old_alcn_catg_code1==null  || old_alcn_catg_code1.equals("")){
			old_alcn_catg_code1="";
		}
		no_of_slots_value1=rs.getInt("no_of_slots");
		patient_id1=rs.getString("patient_id");
		if(patient_id1==null) patient_id1="";
		old_pract_id1=rs.getString("practitioner_id");
		if(old_pract_id1==null) old_pract_id1="";
		order_catalog_code=rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
		old_clinic_code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}catch(Exception ex){
	//out.println("Exception " +  ex);
	ex.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	if(con!=null) 	ConnectionManager.returnConnection(con,request);
}
if (appt_day1==null) appt_day1="";
String i_appt_date_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);
if (!(appt_day1.equals(""))){
%>
<!--below title modified aganist ML-MMOH-CRF-609 by Mano-->
<head><title><fmt:message key="eOA.RescheduleAppointmentfor.label" bundle="${oa_labels}"/><%=i_appt_date_display%> (<%=appt_day1%>)</title>

<%
}else{
%>
<head><title><fmt:message key="Common.RescheduleAppointment.label" bundle="${common_labels}"/></title>
<%}%>
	<%
	/*old_clinic_code passed by S.Sathish for IN019815 onMonday, March 15, 2010, //modified - [IN027165]*/
		String s=request.getQueryString()+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&old_visit_type_ind1="+old_visit_type_ind1+"&old_alcn_catg_code1="+old_alcn_catg_code1+"&no_of_slots_value1="+no_of_slots_value1+"&patient_id1="+patient_id1+"&old_pract_id1="+old_pract_id1+"&curr_month="+curr_month+"&order_catalog_code="+order_catalog_code+"&old_clinic_code="+old_clinic_code+"&order_id="+order_id;		
		
		%>
		<!-- <frameset rows='*,8%'>
			<frameset cols='30%,*'>
				<frame name='apptdairy' src='../../eOA/jsp/ApptDairy.jsp?<%=s%>' noresize frameborder=0 scrolling='no'>
					<frameset rows='10%,20%,*'>
						<frame name='appt_pat_details' src='../../eOA/jsp/DisplayApptPatDetails.jsp?<%=s%>' noresize frameborder=0 >
						<frame name='appt_details' src='../../eOA/jsp/DisplayApptDetails.jsp?<%=s%>' noresize frameborder=0>
						<frame name='DispOAResult' src='../../eOA/jsp/DisplayOAResultsForTransfer.jsp?<%=s%>' noresize frameborder=0>
					</frameset>					
			</frameset>
				<frame name='DispOAResultCB' src='../../eOA/jsp/CheckBoxDisplayDairy.jsp' noresize frameborder='0' scrolling='no'>		
		</frameset>  -->
				 <iframe name='apptdairy' id='apptdairy' src='../../eOA/jsp/ApptDairy.jsp?<%=s%>' noresize frameborder='0' scrolling='no' style='height:92vh;width:30vw' align='left'></iframe>
						<iframe name='appt_pat_details' id='appt_pat_details' align='right' src='../../eOA/jsp/DisplayApptPatDetails.jsp?<%=s%>' noresize frameborder='0' style='height:13vh;width:65vw'></iframe>
						<iframe name='appt_details' id='appt_details' align='right' src='../../eOA/jsp/DisplayApptDetails.jsp?<%=s%>' noresize frameborder='0' style='height:20vh;width:65vw'></iframe>
						<iframe name='DispOAResult' id='DispOAResult' align='right' src='../../eOA/jsp/DisplayOAResultsForTransfer.jsp?<%=s%>' noresize frameborder='0' style='height:60vh;width:65vw'></iframe>					
				<iframe name='DispOAResultCB' id='DispOAResultCB' src='../../eOA/jsp/CheckBoxDisplayDairy.jsp' noresize frameborder='0' scrolling='no' style='height:8vh;width:100vw'></iframe>	
		
	</head>
</html>
