<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"  %> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<title>
		<fmt:message key="eIP.assignbedmarkpatientarrival.label" bundle="${ip_labels}"/>
	</title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/AgeGroupBkgLimit.js'></script>
	<script language ='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facilityId				= (String) session.getValue("facility_id");
	String loginUser		        =	checkForNull((String)session.getValue("login_user"));
	String oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
	String encounterId				= checkForNull(request.getParameter("encounterId"));
	String patientId				= checkForNull(request.getParameter("patientId"));
	String call_function				= checkForNull(request.getParameter("call_function"));

	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
	String setup_bl_dtls_in_ip_yn	= checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"),"N");
	String chg_nurs_unit_in_assign_bed_yn =	checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String location_code	=	checkForNull(request.getParameter("location_code"));
	String assign_bed_yn	=	"";
	String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
	String weight_on_admn_mandatory	= checkForNull(request.getParameter("weight_on_admn_mandatory")); //Added By Dharma on Oct 28th 2014 against HSA-CRF-0181 [IN:049541]
	String height_on_admn_mandatory	= checkForNull(request.getParameter("height_on_admn_mandatory")); //Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	String enable_height_bmi_pat_cls	= checkForNull(request.getParameter("enable_height_bmi_pat_cls")); //Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	Connection connection	=	null;
	ResultSet resultSet 	=	null; 
	Statement statement 	=	null;
	ResultSet resultSet1 	=	null; 
	Statement statement1 	=	null;
	
	connection	= ConnectionManager.getConnection(request);
	statement	= connection.createStatement();

	try{
		statement1 = connection.createStatement();
		//resultSet1 = statement1.executeQuery("SELECT a.chg_nurs_unit_in_assign_bed_yn chg_nurs_unit_in_assign_bed_yn FROM AM_OPER_STN a WHERE a.facility_id = '"+facilityId+"' AND a.oper_stn_id = (SELECT oper_stn_id FROM AM_USER_FOR_OPER_STN where facility_id = '"+facilityId+"' AND appl_user_id = '"+loginUser+"' AND TRUNC (SYSDATE) BETWEEN eff_date_from AND NVL (eff_date_to, TRUNC (SYSDATE)))") ;
		/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function*/

		resultSet1 = statement1.executeQuery("SELECT a.chg_nurs_unit_in_assign_bed_yn chg_nurs_unit_in_assign_bed_yn,assign_bed_yn FROM am_os_user_locn_access_vw a WHERE a.facility_id = '"+facilityId+"' AND a.oper_stn_id='"+oper_stn_id+"' and a.appl_user_id='"+loginUser+"' and a.locn_code = '"+location_code+"'") ;
		while(resultSet1.next()){	     		
			chg_nurs_unit_in_assign_bed_yn	= resultSet1.getString("chg_nurs_unit_in_assign_bed_yn");
			assign_bed_yn								= checkForNull(resultSet1.getString("assign_bed_yn"),"N");
		} 
	}catch(Exception ex)	{
		
		ex.printStackTrace();
	}finally{
		try{
			if(resultSet1!=null) resultSet1.close();
			if(statement1!=null) statement1.close();

			//if(connection != null)
			//ConnectionManager.returnConnection(connection,request);
		}catch(Exception ee)	{

			ee.printStackTrace();
				
		}

	}


	if(!(call_function.equals("assign_bed"))||(call_function.equals("assign_bed"))){
try{
/*
	Commented On 4/21/2010 For PE Tunining
	String sql = "Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = '"+facilityId+"' and locn_code = '"+location_code+"' and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+loginUser+"' and b.ASSIGN_BED_YN ='N'";
	

	resultSet = statement.executeQuery(sql) ;
	
	if(resultSet != null && resultSet.next()){
				rect_loc_code = resultSet.getString("locn_code");
		}
			 if(!(rect_loc_code.equals(""))){
					
				//out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP')); parent.window.close();</script>");
			}
*/
		if(assign_bed_yn.equals("N")){
			//out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP')); top.window.document.getElementById('dialog_tag').close();</script>");
		}else{
		if(!(call_function.equals("assign_bed"))){
			out.print("<script>var ggp_status = window.confirm(getMessage('BED_CAN_NOT_ASSIGN_CONFIRM','IP'));</script>");
			out.println("<script>if(!ggp_status)top.window.document.getElementById('dialog_tag').close();</script>");
		}
		%>	

<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterId%>&Facility_Id=<%=facilityId%>' noresize  frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
<iframe name='message' id='message'		src='../jsp/AssignBedDetail.jsp?encounterId=<%=encounterId%>&patientId=<%=patientId%>&chg_nurs_unit_in_assign_bed_yn=<%=chg_nurs_unit_in_assign_bed_yn%>&oper_stn_id=<%=oper_stn_id%>&pat_check_in_allowed_yn=<%=pat_check_in_allowed_yn%>&setup_bl_dtls_in_ip_yn=<%=setup_bl_dtls_in_ip_yn%>&weight_on_admn_mandatory=<%=weight_on_admn_mandatory%>&height_on_admn_mandatory=<%=height_on_admn_mandatory%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>' frameborder=0 noresize scrolling='no' style='height:80vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
<iframe name='submitFrame' id='submitFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
	<%
		}
if (resultSet != null) resultSet.close();
		if (statement != null) statement.close();
}catch(Exception e)
{
	
	e.printStackTrace();
}finally
{
	try
			{
				if(resultSet!=null) resultSet.close();
				if(statement!=null) statement.close();

				if(connection != null)
				ConnectionManager.returnConnection(connection,request);
			}
			catch(Exception ee)
			{
				

				ee.printStackTrace();
			}
}
	}
	else {
		%>
		
		<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterId%>&Facility_Id=<%=facilityId%>' noresize  frameborder=0 scrolling='no' style='height:10vh;width:100vw'></iframe>
		<iframe name='message' id='message'		src='../jsp/AssignBedDetail.jsp?encounterId=<%=encounterId%>&patientId=<%=patientId%>&chg_nurs_unit_in_assign_bed_yn=<%=chg_nurs_unit_in_assign_bed_yn%>&oper_stn_id=<%=oper_stn_id%>&pat_check_in_allowed_yn=<%=pat_check_in_allowed_yn%>&setup_bl_dtls_in_ip_yn=<%=setup_bl_dtls_in_ip_yn%>' frameborder=0 noresize scrolling='no' style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe><iframe name='submitFrame' id='submitFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>

	<%}
	%>

</html>
	
<%!
	// By Sridhar R 3/8/2005.., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

