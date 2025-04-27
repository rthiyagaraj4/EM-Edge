<!DOCTYPE html>
<%@page import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String bean_id		= "holidayBean" ;
	//String bean_name	= "ePH.HolidayBean";
	//String mode			= request.getParameter("mode");
	String classValue	= "";
	HolidayBean bean = (HolidayBean)getBeanObject( "holidayBean","ePH.HolidayBean", request ) ;
	bean.setLanguageId(locale);
	ArrayList alDtlRecords = new ArrayList();
	alDtlRecords=bean.loadData();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/Holiday.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<table border=1 cellspacing=0 cellpadding=0 width="100%"  align="center" >
		<th align="center" width="20%">Holiday Date</th>
		<th align="center">Reason</th>
		<%
			for(int i=0;i<alDtlRecords.size();i++){
				HashMap hmTemp = new HashMap();
					hmTemp=(HashMap)alDtlRecords.get(i);
				if(i%2==0) classValue="QRYEVEN";
				else classValue="QRYODD"; 
		%>
		<tr onclick="Modify(this)">
			<td class="<%=classValue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK' ><%=hmTemp.get("holiday_date")%></font>
			</td>
			<td class="<%=classValue%>" onclick='disableClick(event);'><%=hmTemp.get("reason")%></td>
		</tr>
		<%
			}
		%>
		</table>
    </body>
</html>

