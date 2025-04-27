<!DOCTYPE html>
<%@page import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
	//String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id		= "holidayBean" ;
	String bean_name	= "ePH.HolidayBean";
	String mode			= request.getParameter("mode");
	String disab = "";
	String holiday_date	= "";
	String reason		= "";
	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		holiday_date	= request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");
		reason			= request.getParameter("reason")==null?"":request.getParameter("reason");
		disab			= "disabled";
	}
	HolidayBean bean = (HolidayBean)getBeanObject( "holidayBean","ePH.HolidayBean", request ) ;  
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/Holiday.js"></SCRIPT>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="HolidayMainform" id="HolidayMainform" >
			<table border=0 cellspacing=0 cellpadding=0 height="15%" width="100%"  align="center" >			    
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<tr>
				    
					<td  class=label><fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>
					<td class='fields'>
					<input type=text name='holiday_date' id='holiday_date' size=10 maxlength=10 value="<%=holiday_date%>" <%=disab%> onBlur="CheckDate(this);">
					<input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('holiday_date');" <%=disab%>>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
                <tr>
				     <td class=label><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					 </td>
					 <td class='fields'><input type=text name='reason' id='reason' size=140 maxlength=100 value="<%=reason%>"><img src="../../eCommon/images/mandatory.gif" align="center"></img>
					 </td>
				</tr>
		 </table>
	<%
putObjectInBean(bean_id,bean,request);
%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		</form>
		<script>
		document.forms[0].holiday_date.focus();</script>
	</body>
</HTML>

