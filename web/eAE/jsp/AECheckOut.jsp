<!DOCTYPE html>
﻿<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection			con			=	null; 
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String	 facility_id				=	"";
	String	 login_user_id			=	"";
	String	 queue_refresh_interval		=	"";
	String	 count		=	"";
	StringBuffer query_string		=	new StringBuffer();
	String  sys_date				=   "";
	 String OsVal = "";
	String  checkout_yn ="Y";
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String url						=	"../../eCommon/jsp/commonToolbar.jsp?" ;
	String params					=	request.getQueryString() ;
	String source					=	url + params ;
	String pid_length				=	""; //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
	String five_level_triage_appl_yn	= "N";
	String cutoff_hours_prv_day_visit	= "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
	try
	{

		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
		StringBuffer queryOPParam = new StringBuffer();
        queryOPParam.append("select to_char(sysdate ,'hh24:mi') hmin, queue_refresh_interval, (select 1  from ae_param  where OPERATING_FACILITY_ID=?) count, (Select AM_OPER_STN_ACCESS_CHECK(?,?,'C','','CHECKOUT_PAT_YN') FROM dual) OsVal, (SELECT patient_id_length FROM mp_param) patient_id_length, (select five_level_triage_appl_yn  from ae_param  where OPERATING_FACILITY_ID='"+facility_id+"') five_level_triage_appl_yn, (select CUTOFF_HOURS_PRV_DAY_VISIT  from ae_param  where OPERATING_FACILITY_ID='"+facility_id+"') CUTOFF_HOURS_PRV_DAY_VISIT from op_param where operating_facility_id = ?"); //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012 - Modified query to add 'patient_id_length'

        //queryOPParam.append("(select 1  from ae_param  where OPERATING_FACILITY_ID=?) count, ");
        //queryOPParam.append("(Select AM_OPER_STN_ACCESS_CHECK(?,?,'C','','CHECKOUT_PAT_YN') ");
		//queryOPParam.append(" FROM dual ) OsVal from op_param where operating_facility_id = ? ");	
		pstmt			=	con.prepareStatement(queryOPParam.toString());
		pstmt.setString	(	1,	facility_id		);
		pstmt.setString	(	2,	facility_id		);
		pstmt.setString	(	3,	login_user_id	);
		pstmt.setString	(	4,	facility_id		);
		rs				=	pstmt.executeQuery();

		if(rs!=null && rs.next())	{			
			sys_date	=	rs.getString("hmin")==null?"":rs.getString("hmin");
			queue_refresh_interval	=	rs.getString("queue_refresh_interval")==null?"":rs.getString("queue_refresh_interval");
			count	=	rs.getString("count")==null?"":rs.getString("count");
			OsVal	=	rs.getString("OsVal")==null?"":rs.getString("OsVal");	
			pid_length	=	rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length"); //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012				
			five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
			cutoff_hours_prv_day_visit	=  (rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT")==null || rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT")=="")?"N":rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
			if(count.equals("")) {
				out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
			} else { 
					if(OsVal.equals("1")) 	{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 } else if(OsVal.equals("2")) {
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }else  if(OsVal.equals("3")) {
						out.print(" <script>alert(getMessage('CHECKOUT_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }else  if(OsVal.equals("4")) {
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 } else  if(OsVal.equals("5")) {
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5"))) {
						 query_string.append(source);	query_string.append("&queue_refresh_interval="+queue_refresh_interval+"&checkout_yn="+checkout_yn+"&sys_date="+sys_date+"&oper_stn_id="+OsVal+"&pid_length="+pid_length+"&five_level_triage_appl_yn="+five_level_triage_appl_yn+"&p_cutoff_hours_prv_day_visit="+cutoff_hours_prv_day_visit+" "); //Rameez for ML-BRU-SCF-0605 [IN:036358] on 23-11-2012 - added 'pid_length' param
					 %>
					<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eAE/jsp/AEManagePatientMain.jsp?<%=query_string.toString()%>' frameborder=0 scrolling='no' noresize style='height:84vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>				
	     			<%
					}
				}
		 } else {
	%>		<script>	
				alert(getMessage('OP_PARAM_NOT_FOUND','OP'));
				window.location.href = '../../eCommon/jsp/dmenu.jsp' ;
			</script>
	<%}

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if((queryOPParam != null) && (queryOPParam.length() > 0)) {
			queryOPParam.delete(0,queryOPParam.length());
		}         
        if((query_string != null) && (query_string.length() > 0)) {
			query_string.delete(0,query_string.length());
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</html>

