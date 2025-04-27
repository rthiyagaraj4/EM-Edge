<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
	<HEAD>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../html/<%=sStyle%>' type='text/css' ></link>
	<%
		request.setCharacterEncoding("UTF-8");	
		String localeName=(String)session.getAttribute("LOCALE") ;
		localeName = localeName.toLowerCase();
		String time_format = request.getParameter("timeSet");

		// Commented by Marimuthu on 24/10/2009 for incident IN015512
		//String locn = request.getParameter("locn");
		// End of Comment

		// Added by Marimuthu on 24/10/2009 for incident IN015512
		String locn = request.getParameter("locn")==null?"":request.getParameter("locn"); 
		// End

		String diff_Yr = "0";
		if ( (time_format==null) || (time_format.equals("null") ) )		time_format = "";


		if (locn.indexOf("eOR") != -1 ||locn.indexOf("ePH") != -1 || locn.indexOf("eMM") != -1 || locn.indexOf("eST") != -1)
		{		
		//	diff_Yr = "0";
		}
		//else
		if (localeName.equals("th"))
			diff_Yr = "543";

		%>
        <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
		<script type="text/javascript" src="../../eCommon/js/calScript/<%=localeName%>/calendar.js"></script>
		<script type="text/javascript" src="../../eCommon/js/common.js"></script>
		<script>
		basicTheme = '<%=sStyle%>';
		generateCalendar("","","","","isModal","","","<%=time_format%>","<%=diff_Yr%>");
		</script>
<!-- generateCalendar(Y, M, D,targetId,isModal,divId,basicTheme1,time_format,diff_Yr) -->

