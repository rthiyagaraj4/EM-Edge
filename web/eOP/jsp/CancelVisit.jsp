<!DOCTYPE html>
<!-- 	Function Name Cancel Visit
	Created by M.Sathis Kumar on 28/02/2000 -->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
    <meta http-equiv="Expires" content="0">
  
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<Script src="../../eOP/js/CancelVisit.js" language="JavaScript"></Script>
		<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		//String url1 = "../../eOP/jsp/CancelVisitFrameset1.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;		
		String function_id = request.getParameter("function_id");
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
            con=ConnectionManager.getConnection(request);		
			String fac_id       = (String) session.getValue( "facility_id" ) ;
			String userid           = (String) session.getValue("login_user");			
			String OsVal="";
			String Patient_Id_Length="";			
			String StartDate="";
			String Canceldays="";
			String inc_arrive_cons_start_pats_yn="";
			String bl_interfaced_yn="";

			String sqlquery = "select bl_interfaced_yn, to_char(sysdate ,'dd/mm/yyyy')sys, to_char(sysdate-a.VISIT_REV_CANCEL_DAYS,'dd/mm/yyyy')sys_1, inc_arrive_cons_start_pats_yn, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','X','','CANCEL_VISIT_YN') OsVal, (Select patient_id_length from mp_param where module_id='MP') Patient_Id_Length from op_param a where operating_facility_id='"+fac_id+"' "	;			
			stmt	= con.createStatement();	
			rs	= stmt.executeQuery(sqlquery) ;
			if(rs!=null && rs.next()) {					
				OsVal=rs.getString("OsVal");        	
				StartDate=rs.getString("sys");
				Canceldays=rs.getString("sys_1");
				inc_arrive_cons_start_pats_yn=rs.getString("inc_arrive_cons_start_pats_yn");
				Patient_Id_Length=rs.getString("Patient_Id_Length");        	
				bl_interfaced_yn=rs.getString("bl_interfaced_yn");   
				
				if(OsVal.equals("1"))	{													
					out.print("<script>alert(getMessage('CANCEL_VISIT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/		dmenu.js p';</script>");
				}else if(OsVal.equals("2")) {
					out.print(" <script>					alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("3")) {
					out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("4")) {
					out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else  if(OsVal.equals("5")) {
					out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				}else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5"))) {	   
				%>
			
					<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='group_head' id='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/SearchVisitQueryCriteria.jsp?function_id=<%=function_id%>&oper_id=<%=OsVal%>&StartDate=<%=StartDate%>&Canceldays=<%=Canceldays%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&inc_arrive_cons_start_pats_yn=<%=inc_arrive_cons_start_pats_yn%>&Patient_Id_Length=<%=Patient_Id_Length%>&p_mode=CANCELVISIT' style='height:21vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto' style='height:62vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>			
			
		    <%}  
		 } else {
               out.println("<script>alert(parent.frames[0].getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
         }
					%>
</html>
<%
        }catch(Exception e) {e.printStackTrace();}
finally{	
	if (stmt != null)    stmt.close();
    if (rs != null)       rs.close();
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

