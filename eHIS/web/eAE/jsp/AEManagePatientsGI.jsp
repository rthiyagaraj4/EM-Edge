<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eAE/js/AEManagePatientGI.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
</head>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null; 
	ResultSet			rs			=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String	 facility_id				    =	"";
	String	 login_user_id			    =	"";
	String	 queue_refresh_interval	    =	"";
	String	 p_cutoff_hours_prv_day_visit =   "";	
	String	 called_from_ca			    =	"";
	String checkout_yn                 =   "N";
	String query_string =  "";
	String pid_length   =  "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start*/
	String five_level_triage_appl_yn	=  "N";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 End*/
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
    called_from_ca	= request.getParameter("called_from_ca");
	if((called_from_ca==null) || (called_from_ca.equals("null")) || (called_from_ca=="") || (called_from_ca.equals("")))	called_from_ca			= "";
	String source = url + params ;

	try
	{
		con				=	(Connection)	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
		/*five_level_triage_appl_yn Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start*/
		String sqlQuery		= " select five_level_triage_appl_yn,queue_refresh_interval,CUTOFF_HOURS_PRV_DAY_VISIT,(AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+login_user_id+"','C','','MANAGE_QUEUE_YN')) OsVal,(select patient_id_length from mp_param where module_id='MP') pid_length  from ae_param where OPERATING_FACILITY_ID=?";		
	   String OsVal = "";
		pstmt  = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facility_id);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()) {
			queue_refresh_interval			=	rs.getString("queue_refresh_interval");
			p_cutoff_hours_prv_day_visit    =	rs.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
			pid_length					    =	rs.getString("pid_length"); // Monday, May 17, 2010 venkat s PE_EXE
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 Start*/
			five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 End*/
			if(pid_length==null || pid_length.equals(""))
			pid_length	= "20";
			OsVal    =	rs.getString("OsVal");
			if(OsVal.equals("1"))
				{
				if(called_from_ca .equals("Y")) {
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';</script>");
					 }else{
						 out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					 }
				}else if(OsVal.equals("2")) {
					if(called_from_ca .equals("Y")) {
					   out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';</script>");
					}else{
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}else  if(OsVal.equals("3"))	{
					if(called_from_ca .equals("Y")) {
					   out.print(" <script>alert(getMessage('AE_MANAGEQ_NOT_ALL_OPERSTN','AE'));top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';</script>");
					}else{
						out.print(" <script>alert(getMessage('AE_MANAGEQ_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}

				}else  if(OsVal.equals("4")) {
					if(called_from_ca .equals("Y")) {
					out.print(" <script>alert('Not valid facility/user id');top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';</script>");
					}else{
					out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}else if(OsVal.equals("5")) {
					if(called_from_ca .equals("Y")) {
					   out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';</script>");
					}else{
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
				}
				else if (!OsVal.equals("1") && !OsVal.equals("2") && !OsVal.equals("3") && !OsVal.equals("4") && !OsVal.equals("5"))
				{
					System.out.println("OsVal"+OsVal);
					query_string = "queue_refresh_interval="+queue_refresh_interval+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&p_cutoff_hours_prv_day_visit="+p_cutoff_hours_prv_day_visit+"&checkout_yn="+checkout_yn+"&called_from_ca="+called_from_ca+"&oper_stn_id="+OsVal+"&pid_length="+pid_length+" ";					
					query_string = query_string + "&five_level_triage_appl_yn="+five_level_triage_appl_yn; 	
				 if(called_from_ca .equals("Y"))  
	             {                  
				   query_string = query_string+"&from_service_yn =N";
                  %>
		             <frameset rows='6%,91%,4%' >
                  <%
	             }
	             else 
	             {
                  %>
                  <%
	             }						  
                  %>
 						<iframe name='commontoolbarFrame' src='<%=source%>' frameborder='0'  scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' src='../../eAE/jsp/AEManagePatientMainGI.jsp?<%=query_string%>' frameborder=0 scrolling='no' noresize style='height:84vh;width:100vw'></iframe>
						<iframe name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>				
						<iframe name='dummyFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>				
		         <%
				}
				else
				{
					 if(called_from_ca .equals("Y")) {
						 %>
							<script language='javascript'>
							alert(getMessage('AE_MANAGEQ_NOT_ALL_OPERSTN','AE'));
							top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';
							</script>
			      <%}else{	%>

							<script language='javascript'>
							alert(getMessage('AE_MANAGEQ_NOT_ALL_OPERSTN','AE'));
							document.location.href= '../../eCommon/jsp/dmenu.jsp';
							</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<%
                 }
				}
		} else {
			out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}
		
	if(rs!=null)	rs.close();
	if(pstmt!=null)	pstmt.close();
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

