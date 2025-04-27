<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
	<HTML>
	<HEAD>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../html/<%=sStyle%>' type='text/css' ></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	</head>
	<body onKeyDown="lockKey()">
	<form name="cal" id="cal">
		<input type="text" id="destination" name="destination" id="destination" value="">
	
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String localeName=(String)session.getAttribute("LOCALE") ;
		localeName = localeName.toLowerCase();
		String time_format = request.getParameter("timeSet");

		String locn = request.getParameter("locn");

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
</form>
</Body>
		<script type="text/javascript" src="../../eCA/js/calScript/<%=localeName%>/calendar.js"></script>
		<script type="text/javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		basicTheme = '<%=sStyle%>'
		generateCalendar("","","","destination","","","","<%=time_format%>","<%=diff_Yr%>");
		</script>
<!-- generateCalendar(Y, M, D,targetId,isModal,divId,basicTheme1,time_format,diff_Yr) -->


</HTML>

