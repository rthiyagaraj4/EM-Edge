<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<%

	String alternateBooking = request.getParameter("alternateBooking");
	 //ML-MMOH-CRF-1939-US005
	String fpp_yn = request.getParameter("fpp_yn");
	String fpp_category = request.getParameter("fpp_category");
	System.err.println("FPP :"+fpp_yn+" Cat:"+fpp_category);
	//String alternateBooking = request.getParameter("alternateBooking");
	if(alternateBooking != null && alternateBooking.equals("Y"))
	{
		String sStyle =		request.getParameter("sStyle");
		String locale =		request.getParameter("locale");
		String facility_id = request.getParameter("facility_id");
		String ordering_facility_id = request.getParameter("ordering_facility_id");
		String resp_id = request.getParameter("resp_id");
		String login_user = request.getParameter("login_user");
		String bl_operational = request.getParameter("bl_operational");
		String client_ip_address = request.getParameter("client_ip_address");
		//set session variables
		session.setAttribute("PREFERRED_STYLE", sStyle);
		session.setAttribute("facility_id",facility_id);
		session.setAttribute("bl_operational",bl_operational);
		session.putValue("LOCALE",locale);
		session.putValue("PREFERRED_STYLE",sStyle);
		session.putValue("login_user",login_user);
		session.putValue("ordering_facility_id",ordering_facility_id);
		session.putValue("responsibility_id",resp_id);
		javax.servlet.jsp.jstl.core.Config.set(session, javax.servlet.jsp.jstl.core.Config.FMT_LOCALE, locale);
		javax.servlet.jsp.jstl.core.Config.set(session, javax.servlet.jsp.jstl.core.Config.FMT_FALLBACK_LOCALE, "en");
		Properties p = (Properties)session.getAttribute("jdbc");
		if(p == null)
		{
			p = new Properties();
		}
		p.setProperty("LOCALE", locale);
		p.setProperty("facility_id", facility_id);
		p.setProperty("login_user", login_user);
		p.setProperty("login_by_id", login_user);
		p.setProperty("client_ip_address", client_ip_address);
		session.putValue("jdbc", p);
	}
%>
<%
		String locale = (String)session.getValue("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);		
%>
<HTML>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<head>
<TITLE> <%=common_labels.getString("Common.booking.label")%> </TITLE>
</head>
<!--<frameset rows="3%,10%,50%,5%"> 
-->


<frameset rows="0,*">

<frame name="dummy" id="dummy" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" >

<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/CalendarFrame.jsp?<%=request.getQueryString()%>">

<!--<frame name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/CalendarTab.jsp?<%=request.getQueryString()%>">

<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/DiarySheduleSearch.jsp?<%=request.getQueryString()%>" >

<frame name='qa_query_result' id='qa_query_result' 		src="../../eCommon/html/blank.html" frameborder=0>

<frame name='qa_query_result_tail' id='qa_query_result_tail' src="../../eCommon/html/blank.html" frameborder=0>
-->
</frameset>
</html>

