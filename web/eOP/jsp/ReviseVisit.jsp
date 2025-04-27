<!DOCTYPE html>
<html>
<head>
	<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOP/js/ReviseVisit.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013-->
	<script language="javascript" src="../../eOP/js/Checkblockscheduleforpract.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->
		
</head>

<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
    	String source = url + params ;
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String userid           = (String) session.getValue("login_user");
		String function_id=request.getParameter("function_id");
		Connection con=null;
		//String revise_visit_yn="";	
		
	try {
       con=ConnectionManager.getConnection(request);        
       Statement stmt=null;
	   ResultSet rs=null;			
	   
	   String OsVal="";
	   String StartDate="";
	   String Canceldays="";	     
	   String Patient_Id_Length="";
	   String package_enabled_yn="";
	   String bl_interfaced_yn="";
	   String queue_date="";
	   String assign_queue_num_by="";
	   String build_episode_rule="";
	   String bl_install_yn = (String) session.getValue("bl_operational")==null?"N":(String)session.getValue("bl_operational");;
	   StringBuffer sqlquery = new StringBuffer();	   
		 
		sqlquery.append("Select a.bl_interfaced_yn,to_char(sysdate ,'dd/mm/yyyy') sys,		to_char(sysdate-a.VISIT_REV_CANCEL_DAYS,'dd/mm/yyyy') sys_1 , build_episode_rule,  assign_queue_num_by,  to_char(sysdate,'dd/mm/yyyy') queue_date,AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','REVISE_VISIT_YN') OsVal, (Select patient_id_length from mp_param where module_id='MP') PatIdLen");
		if(bl_install_yn.equals("Y"))
			sqlquery.append(", b.package_enabled_yn package_enabled_yn from bl_parameters b ,op_param a where a.operating_facility_id='"+fac_id+"' and a.operating_facility_id = b.operating_facility_id");
		else
			sqlquery.append(" from op_param a where a.operating_facility_id='"+fac_id+"' ");		 

        stmt	= con.createStatement();	
		rs	= stmt.executeQuery(sqlquery.toString()) ;
		if(rs!=null && rs.next()) {									
			
			OsVal=rs.getString("OsVal");     
			StartDate=rs.getString("sys");
			Canceldays=rs.getString("sys_1");			
			Patient_Id_Length=rs.getString("PatIdLen");
			if(bl_install_yn.equals("Y"))
				package_enabled_yn=rs.getString("package_enabled_yn");
			bl_interfaced_yn=rs.getString("bl_interfaced_yn");
			build_episode_rule=rs.getString("build_episode_rule");
			assign_queue_num_by=rs.getString("assign_queue_num_by");
			queue_date=rs.getString("queue_date");			

		    if(OsVal.equals("1")) {			
				out.print("<script>alert(getMessage('REVISIT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/			dmenu.jsp';	</script>");
		    }else if(OsVal.equals("2")) 	{
			    out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			} else  if(OsVal.equals("3")) {
			     out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("4")) {
			out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(OsVal.equals("5")) {
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
            else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4"))) {
				%>
			
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		    <iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/SearchVisitQueryCriteria.jsp?function_id=<%=function_id%>&oper_id=<%=OsVal%>&StartDate=<%=StartDate%>&Canceldays=<%=Canceldays%>&Patient_Id_Length=<%=Patient_Id_Length%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&package_enabled_yn=<%=package_enabled_yn%>&build_episode_rule=<%=build_episode_rule%>&assign_queue_num_by=<%=assign_queue_num_by%>&queue_date=<%=queue_date%>&p_mode=REVISEVISIT' style='height:16vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:68vh;width:99vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
			<iframe name='billingfr' id='billingfr' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
	<%}
		} else {
              out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
         }
          
%>
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

