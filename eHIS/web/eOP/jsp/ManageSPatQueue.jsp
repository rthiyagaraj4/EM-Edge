<!DOCTYPE html>
<!--
    Developed by    :   R.Nanda Kumar 
    Created on		:   22/12/2000
    Module			:   Out Patient Management
    Function		:   This file is used for dynamically generating toolbar for the
						function. Here 1 frame is defined for the function.
                it is from op_param table and column name is queue_refresh_interval
-->

<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eOP/js/ManageSPatQueueVsign.js'></script>
    <script language='javascript' src='../../eOP/js/ManageSPatQueueChkout.js'></script>
    <script language='javascript' src='../../eOP/js/ManageSPatQueue.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>
		<fmt:message key="Common.ManagePatQ.label" bundle="${common_labels}"/>	
	</title>
</head>
	

<%
        Connection con=null;
        try{ 		
					
            con=ConnectionManager.getConnection(request);        
			Statement stmt=null;
			ResultSet rs=null;
			String fac_id       = (String) session.getValue( "facility_id" ) ;
			String userid           = (String) session.getValue("login_user");
			String bl_oper_yn = (String)session.getValue("bl_operational")==null?"N":(String)session.getValue("bl_operational");
			String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
			StringBuffer sql = new StringBuffer();
			int refresh_interval = 0;			
			String oper_stn_access_rule="";			
			String OsVal="";
			String OsVal_chkout="";
			String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"); 
			//String ca_install_yn = "N";
			String pat_id_length = "";
			String bl_package_enabled_yn = "N";
			String sdate = "";
			String caInsYn = "N";
			String allergy_yn = "N";
			String assign_queue_num_by = "";
			String open_search_reqd_yn = "N";
			String action_on_pending_bill	= "";// Added For MMS-QH-CRF-0126 [IN:041880]
			int mins1_for_wait_time = 0;
			int mins2_for_wait_time = 0;
			
			boolean isQMSapplicable=false;
			isQMSapplicable=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","EXT_QUEUE_NO"); //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
	
			sql.append(" select queue_refresh_interval, oper_stn_access_rule, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','MANAGE_QUEUE_YN') osval, (Select patient_id_length from mp_param where module_id = 'MP') pat_id_length,");
			
			if(bl_oper_yn.equals("Y")) {
				sql.append(" (select PACKAGE_ENABLED_YN from bl_parameters where operating_facility_id ='"+fac_id+"') bl_package_enabled_yn, ");
			}
			
			sql.append(" to_char(sysdate,'hh24:mi') sdate, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') OsVal_chkout, (select install_yn from sm_module where module_id ='CA') install_yn, GET_TASK_APPLICABILITY('ALLERGIES', NULL, '"+resp_id+"', NULL) allergy_yn, ASSIGN_QUEUE_NUM_BY,open_search_reqd_yn,MINS1_FOR_WAIT_TIME,MINS2_FOR_WAIT_TIME,ACTION_ON_PENDING_BILL from op_param where operating_facility_id='"+fac_id+"' ");	
			
			stmt	= con.createStatement();			
			rs	= stmt.executeQuery(sql.toString()) ;
			if(rs!=null && rs.next()) {	

				refresh_interval = (rs.getInt("queue_refresh_interval") * 60)*1000; 			
				oper_stn_access_rule = rs.getString("oper_stn_access_rule") == null?"":rs.getString("oper_stn_access_rule");
				OsVal = rs.getString("osval") == null?"":rs.getString("osval");
				//ca_install_yn = rs.getString("ca_install_yn") == null?"N":rs.getString("ca_install_yn");
				pat_id_length = rs.getString("pat_id_length") == null?"":rs.getString("pat_id_length");
				
				if(bl_oper_yn.equals("Y")) {
					bl_package_enabled_yn = rs.getString("bl_package_enabled_yn") == null?"N":rs.getString("bl_package_enabled_yn");
				}

				sdate = rs.getString("sdate") == null?"":rs.getString("sdate");

				OsVal_chkout = rs.getString("OsVal_chkout") == null?"":rs.getString("OsVal_chkout");
				allergy_yn = rs.getString("allergy_yn") == null?"N":rs.getString("allergy_yn");
				caInsYn = rs.getString("install_yn") == null?"N":rs.getString("install_yn");
				assign_queue_num_by = rs.getString("assign_queue_num_by") == null?"":rs.getString("assign_queue_num_by");
				open_search_reqd_yn = rs.getString("open_search_reqd_yn") == null?"N":rs.getString("open_search_reqd_yn");
				action_on_pending_bill	= rs.getString("ACTION_ON_PENDING_BILL") == null?"":rs.getString("ACTION_ON_PENDING_BILL"); // Added For MMS-QH-CRF-0126 [IN:041880]
				mins1_for_wait_time = rs.getInt("MINS1_FOR_WAIT_TIME");
				mins2_for_wait_time = rs.getInt("MINS2_FOR_WAIT_TIME");
					
					

				if(OsVal.equals("1"))
				{
					out.print(" <script>alert(getMessage('MANAGE_QUEUE_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else if(OsVal.equals("2"))
				{
					out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("3"))
				{
					out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("4"))
				{
					out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("5"))
				{
					out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}
				else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
				{
				} 										
           } else {
				out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
           }
                

    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString();
	String source = url + params ;
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String function_id=request.getParameter("function_id");
	 
    if(function_id == null) function_id = "";
/*
 Below is defined a frameset having 3 frames :
	1.	The first frame is for the common toolbar .
	2.	The second frame displays the main functionality page.
	3.	The third frame is for the messages and the inetrmediate jsp validations.
*/
%>		
	<%
	if(call_from.equals("CA"))	{
	%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe> 
		<iframe name='frame1' id='frame1' 	src='../../eOP/jsp/ManageMPatQueueQuery.jsp?function_id=<%=function_id%>&QQue=Que&refresh=<%=refresh_interval%>&access_rule=<%=oper_stn_access_rule%>&oprstn=<%=OsVal%>&call_from=<%=call_from%>&speciality_code=<%=speciality_code%>&pat_id_length=<%=pat_id_length%>&bl_package_enabled_yn=<%=bl_package_enabled_yn%>&sdate=<%=sdate%>&open_search_reqd_yn=<%=open_search_reqd_yn%>&action_on_pending_bill=<%=action_on_pending_bill%>' frameborder=0 scrolling='no' noresize style='height:40vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>

	<%} else {%>

<!--Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297]  -->
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe> 
		<iframe name='frame1' id='frame1' src='../../eOP/jsp/ManageSPatQueueFr2.jsp?function_id=<%=function_id%>&Que=Que&refresh=<%=refresh_interval%>&oper_stn_access_rule=<%=oper_stn_access_rule%>&oper_id=<%=OsVal%>&call_from=<%=call_from%>&pat_id_length=<%=pat_id_length%>&bl_package_enabled_yn=<%=bl_package_enabled_yn%>&sdate=<%=sdate%>&open_search_reqd_yn=<%=open_search_reqd_yn%>&action_on_pending_bill=<%=action_on_pending_bill%>' frameborder='0' scrolling='no' noresize style='height:85vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
	<%}%>
	<script>
		refresh_param = <%=refresh_interval%> 
    </script>

	<input type = 'hidden' name = 'OsVal_chkout' id = 'OsVal_chkout' value = '<%=OsVal_chkout%>'>
	<input type = 'hidden' name = 'allergy_yn' id = 'allergy_yn' value = '<%=allergy_yn%>'>
	<input type = 'hidden' name = 'caInsYn' id = 'caInsYn' value = '<%=caInsYn%>'>
	<input type = 'hidden' name = 'assign_queue_num_by' id = 'assign_queue_num_by' value = '<%=assign_queue_num_by%>'>
	<input type = 'hidden' name = 'open_search_reqd_yn' id = 'open_search_reqd_yn' value = '<%=open_search_reqd_yn%>'>
	<input type = 'hidden' name = 'mins1_for_wait_time' id='mins1_for_wait_time' value = '<%=mins1_for_wait_time%>'>
	<input type = 'hidden' name = 'mins2_for_wait_time' id = 'mins2_for_wait_time' value = '<%=mins2_for_wait_time%>'>
	<input type = 'hidden' name = 'action_on_pending_bill' id = 'action_on_pending_bill' value = '<%=action_on_pending_bill%>'><!--  Added For MMS-QH-CRF-0126 [IN:041880] -->
	<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
	<input type = 'hidden' name = 'isQMSapplicable' id = 'isQMSapplicable'  value = '<%=isQMSapplicable%>'>
	<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started-->
	
 

</html>
<%
	if (stmt != null)    stmt.close();
    if (rs != null)       rs.close(); 	
}catch(Exception e) {e.printStackTrace();}
finally{	
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

