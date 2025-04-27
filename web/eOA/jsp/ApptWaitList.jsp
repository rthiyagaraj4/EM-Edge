<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<title><fmt:message key="eOA.CreateAppointmentWaitList.label" bundle="${oa_labels}"/>
</title>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/common.js">	</script>
	<script language="javascript" src="../../eOA/js/ApptWaitList.js"> </script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;
	Connection con = null;
	PreparedStatement pstmt = null;
	String facilityId=(String) session.getValue("facility_id");
	String globaluser = (String)session.getValue("login_user");
	String alcn_criteria_yn = "" ;
			String waitlist_category_appl_yn = "" ;
			String invitation_list_appl_yn = "" ;
			String waitlist_category_reqd_yn = "" ;
			String restrict_wl_cat_agst_splty_yn = "" ;
			String dttm = "" ;
			String prd = "" ;
			String curr_month = "" ;
			String install_yn = "" ;
			String rd_oa_integration_yn = "N" ;
	
	//String oper_stn_access_rule="";			

	String from = request.getParameter("from")==null?"":request.getParameter("from");
	 
	String calling_mode=request.getParameter("calling_mode");
	String oper_stn_id="";
	ResultSet rs=null;
	try{
		con = ConnectionManager.getConnection(request);		 
		 String sqlQuery = "" ;
		 sqlQuery = "SELECT NVL (alcn_criteria, 'None') alcn_criteria, waitlist_category_appl_yn, invitation_list_appl_yn,       waitlist_category_reqd_yn, restrict_wl_cat_agst_splty_yn, TO_CHAR (SYSDATE, 'dd/mm/yyyy') dttm,NVL (forceclose_period, 0) prd, TO_CHAR (SYSDATE, 'mm') curr_month,(SELECT operational_yn FROM sm_modules_facility WHERE facility_id = ? AND module_id = 'OR') install_yn,AM_OPER_STN_ACCESS_CHECK(?,?,'X','','CREATE_WAIT_LIST_YN') oper_stn_id,rd_oa_integration_yn FROM oa_param";
		 pstmt = con.prepareStatement(sqlQuery);
		 pstmt.setString(1,facilityId);
		 pstmt.setString(2,facilityId);
		 pstmt.setString(3,globaluser);
		 rs = pstmt.executeQuery();
		if(rs !=null && rs.next()) {			
	     	 oper_stn_id=rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
	     	 alcn_criteria_yn=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");;
	     	 waitlist_category_appl_yn=rs.getString("waitlist_category_appl_yn")==null?"":rs.getString("waitlist_category_appl_yn");;
			 invitation_list_appl_yn=rs.getString("invitation_list_appl_yn")==null?"":rs.getString("invitation_list_appl_yn");;
			 waitlist_category_reqd_yn=rs.getString("waitlist_category_reqd_yn")==null?"":rs.getString("waitlist_category_reqd_yn");;
			 restrict_wl_cat_agst_splty_yn=	rs.getString("restrict_wl_cat_agst_splty_yn")==null?"":rs.getString("restrict_wl_cat_agst_splty_yn");;
			 dttm=rs.getString("dttm")==null?"":rs.getString("dttm");;
			 prd=rs.getString("prd")==null?"":rs.getString("prd");;
			 curr_month=rs.getString("curr_month")==null?"":rs.getString("curr_month");;
			 install_yn=rs.getString("install_yn")==null?"":rs.getString("install_yn");;
			 rd_oa_integration_yn=rs.getString("rd_oa_integration_yn")==null?"N":rs.getString("rd_oa_integration_yn");;
		}
		
            if(oper_stn_id.equals("1")) 
			{
			 out.println("<script>alert(getMessage('NO_OPER_STN_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';				</script>");
		    }else if(oper_stn_id.equals("2"))
			{
			out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");			
			}else if(oper_stn_id.equals("3"))
			{
				out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");		
			}else  if(oper_stn_id.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(oper_stn_id.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else	if(!oper_stn_id.equals(""))
			{

%>
		
	       <%if (from.equals("ScheduleAppt")){%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src="../../eOA/jsp/OAToolbar.jsp?calling_mode=<%=calling_mode%>&from=<%=from%>"   scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
 
				<iframe name='f_query_add_mod' id='f_query_add_mod'    src="../../eOA/jsp/ApptWaitListlMainPage.jsp?<%=source%>& operation=insert&from=ScheduleAppt&oper_stn_id=<%=oper_stn_id%>&alcn_criteria_yn=<%=alcn_criteria_yn%>&waitlist_category_appl_yn=<%=waitlist_category_appl_yn%>&invitation_list_appl_yn=<%=invitation_list_appl_yn%>&waitlist_category_reqd_yn=<%=waitlist_category_reqd_yn%>&restrict_wl_cat_agst_splty_yn=<%=restrict_wl_cat_agst_splty_yn%>&dttm=<%=dttm%>&prd=<%=prd%>&curr_month=<%=curr_month%>&install_yn=<%=install_yn%>&rd_oa_integration_yn=<%=rd_oa_integration_yn%>"  noresize scrolling=auto style='height:82vh;width:100vw' frameborder='0'></iframe>
	        <%}else {%>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%>  scrolling=no noresize style='height:8vh;width:100vw' frameborder='0'></iframe>

                <iframe name='f_query_add_mod' id='f_query_add_mod'    src="../../eOA/jsp/ApptWaitListlMainPage.jsp?<%=source%>&oper_stn_id=<%=oper_stn_id%>&alcn_criteria_yn=<%=alcn_criteria_yn%>&waitlist_category_appl_yn=<%=waitlist_category_appl_yn%>&invitation_list_appl_yn=<%=invitation_list_appl_yn%>&waitlist_category_reqd_yn=<%=waitlist_category_reqd_yn%>&restrict_wl_cat_agst_splty_yn=<%=restrict_wl_cat_agst_splty_yn%>&dttm=<%=dttm%>&prd=<%=prd%>&curr_month=<%=curr_month%>&install_yn=<%=install_yn%>&rd_oa_integration_yn=<%=rd_oa_integration_yn%>"  noresize scrolling=auto style='height:82vh;width:100vw' frameborder='0'> </iframe>
			<%}%>
			<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' noresize scrolling=auto style='height:9vh;width:100vw' frameborder='0'></iframe>
			<iframe name='dummyFrame' id='dummyFrame'	 src='../../eCommon/jsp/error.jsp'  noresize scrolling=auto style='height:0vh;width:100vw' frameborder='0'></iframe>
		




</html>

<%
		}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();
}
catch(Exception es){
	es.printStackTrace();
	//out.println(es);
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

