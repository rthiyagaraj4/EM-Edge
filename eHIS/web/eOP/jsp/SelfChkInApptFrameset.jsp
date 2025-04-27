<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*,eCommon.Common.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eOP/js/SelfChkInAppt.js"></script>


<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	request.setCharacterEncoding("UTF-8");
	Connection con=null;


	try {
		con						=  ConnectionManager.getConnection(request);
		String facility_id		=	(String)session.getAttribute("facility_id");
		String locale			= (String) session.getValue( "LOCALE" ) ;
		String userid           = (String) session.getValue("login_user");
		if(userid == null || userid.equals("null"))
			userid = "";

		String oper_stn_id		= CommonBean.getOperStationId(con,facility_id, userid,"REGISTER_VISIT_YN");
		

		if(oper_stn_id.equals("1"))
		 {
		 out.print(" <script>alert(getMessage('VISIT_REGN_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		 }else if(oper_stn_id.equals("2"))
			{
			out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(oper_stn_id.equals("3"))
			{
			out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(oper_stn_id.equals("4"))
			{
			out.print(" <script>alert(getMessage('INVALD_USER_FCY','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(oper_stn_id.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}

	
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='searchCriteria' id='searchCriteria' src='../../eOP/jsp/SelfChkInAppCriteria.jsp?oper_stn_id=<%=oper_stn_id%>' frameborder=0  scrolling='auto' style='height:10vh;width:100vw'></iframe>
	<iframe name='SearchResults' id='SearchResults' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:70vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
<%
	} catch(Exception e){
		e.printStackTrace();
	}
   finally
    {
		ConnectionManager.returnConnection(con,request);
    }
	%>	

