<!DOCTYPE html>
<!--
	Developed by 	:	R.Nanda Kumar 
	Created on 	:	22/12/2000
	Module		:	Out Patient Management
	Function	:	This file is used for dynamically generating toolbar for the
				function. Here 1 frame is defined for the function.
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>  
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->

<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src="../../eOP/js/ManageSPatQueue.js"></script>
	<script language='javascript' src='../../eOP/js/ManageSPatQueueChkout.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
  <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		Connection con=null;
		int refresh_interval = 0;
		String oper_stn_access_rule="";
		try {
				con=ConnectionManager.getConnection(request);
				Statement stmt=null;
				ResultSet rs=null;
			
				String fac_id    	= (String) session.getValue( "facility_id" ) ;	
				String userid           = (String) session.getValue("login_user");
				String bl_oper_yn = (String)session.getValue("bl_operational")==null?"N":(String)session.getValue("bl_operational");
				StringBuffer sql = new StringBuffer();
				String pat_id_length = "";
				String bl_package_enabled_yn = "N";
				String sdate = "";
				String OsVal = "";
				String open_search_reqd_yn = "N";
				int mins1_for_wait_time=0;
				int mins2_for_wait_time=0;
				//String sql="select queue_refresh_interval,oper_stn_access_rule from op_param where operating_facility_id='"+fac_id+"'";

				sql.append(" select queue_refresh_interval, oper_stn_access_rule, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') osval, (Select patient_id_length from mp_param where module_id = 'MP') pat_id_length,");
			
				if(bl_oper_yn.equals("Y")) {
					sql.append(" (select PACKAGE_ENABLED_YN from bl_parameters where operating_facility_id ='"+fac_id+"') bl_package_enabled_yn, ");
				}
			
				sql.append(" to_char(sysdate,'hh24:mi') sdate,open_search_reqd_yn,MINS1_FOR_WAIT_TIME,MINS2_FOR_WAIT_TIME from op_param where operating_facility_id='"+fac_id+"' ");	
				

				stmt	= con.createStatement();	
				//rs	= stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual") ;
				rs	= stmt.executeQuery(sql.toString()) ;
				if(rs!=null && rs.next()) {	

					refresh_interval = (rs.getInt("queue_refresh_interval") * 60)*1000; 			
					oper_stn_access_rule = rs.getString("oper_stn_access_rule") == null?"":rs.getString("oper_stn_access_rule");
					OsVal = rs.getString("osval") == null?"":rs.getString("osval");						

					pat_id_length = rs.getString("pat_id_length") == null?"":rs.getString("pat_id_length");
					mins1_for_wait_time=rs.getInt("mins1_for_wait_time");
					mins2_for_wait_time=rs.getInt("mins2_for_wait_time");
					if(bl_oper_yn.equals("Y")) {
						bl_package_enabled_yn = rs.getString("bl_package_enabled_yn") == null?"N":rs.getString("bl_package_enabled_yn");

					}

					sdate = rs.getString("sdate") == null?"":rs.getString("sdate");	
					open_search_reqd_yn = rs.getString("open_search_reqd_yn") == null?"":rs.getString("open_search_reqd_yn");	
							
				
					if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('CHECKOUT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");

					} else if(OsVal.equals("2")) {
						out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					} else  if(OsVal.equals("3")) {
						out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					} else  if(OsVal.equals("4")) {
						out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5")) {
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					}
				} else {
					out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
				}
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
					
				String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
				String params = request.getQueryString() ;
				String source = url + params ; 
				String function_id=request.getParameter("function_id");
				if(function_id == null) function_id = "";

            %>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='frame1' id='frame1' src='../../eOP/jsp/ManageSPatQueueFr2.jsp?function_id=<%=function_id%>&ChkOut=ChkOut&refresh=<%=refresh_interval%>&oper_stn_access_rule=<%=oper_stn_access_rule%>&oper_id=<%=OsVal%>&pat_id_length=<%=pat_id_length%>&bl_package_enabled_yn=<%=bl_package_enabled_yn%>&sdate=<%=sdate%>' frameborder=0  style='height:85vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
			<form>
	<input type=hidden name='function_id' id='function_id' value='<%=function_id%>'>
	<input type=hidden name='mins1_for_wait_time' id='mins1_for_wait_time' value='<%=mins1_for_wait_time%>'>
	<input type=hidden name='mins2_for_wait_time' id='mins2_for_wait_time' value='<%=mins2_for_wait_time%>'>
	<input type=hidden name='open_search_reqd_yn' id='open_search_reqd_yn' value='<%=open_search_reqd_yn%>'>
	</form>
	<script>
		refresh_ChkOut=(<%=refresh_interval%>);
	</script>
</html>
<%
if(stmt != null) stmt.close();
if(rs != null) rs.close();
}catch(Exception e) {
	e.printStackTrace();
	out.println(e.toString());
}
finally{
if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>




