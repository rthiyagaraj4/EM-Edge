<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>

<html>
<head>

<style>
	TD.OABRUHEALTH{
		BACKGROUND-COLOR:Bisque;  
		FONT-SIZE: 8pt ;
		border-style: SOLID;
		border-left-color: #B2B6D7;
		border-right-color: #B2B6D7;
		border-top-color: #E2E3F0;
		border-bottom-color: #E2E3F0;
	}
</style>

<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

	Connection con = null;

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	 Boolean isSlotStartMidEndAppl = false;

	String mod = request.getParameter("mod");
	if(mod == null ) mod ="";

try
{
	con = ConnectionManager.getConnection(request);

	isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<table border='1' width='100%'>
	<tr>
	<%

	if(mod.equals("tfr"))
		{
	%>
			<td width="3%" class='OABLOCK'>&nbsp;</td>
			<td width="20%" class='oalabel'><fmt:message key="eOA.Break.label" bundle="${oa_labels}"/></td>
			<td width="3%" class='OARED'>&nbsp;</td>
			<td width="20%" class='oalabel'><fmt:message key="Common.blocked.label" bundle="${common_labels}"/></td>
			<td width="3%"  class='OAFORCED'>&nbsp;</td>
			<td width="20%" class='oalabel'><fmt:message key="eOA.ForcedAppointment.label" bundle="${oa_labels}"/></td>

			<%if(isSlotStartMidEndAppl){%>
				<td width="3%"  class='OABRUHEALTH'>&nbsp;</td>
				<td width="20%" class='oalabel'><fmt:message key="eOA.BruHealthSlot.label" bundle="${oa_labels}"/></td>
			<%}%>

			<td  width="8%" class='button'><input type='button' class='button' value ='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name='Close' OnClick ='parent.window.close()'></td>
	<%}
	else {
	%>
			<td width="3%" class='OABLOCK'>&nbsp;</td>
			<td width="20%" class='oalabel'><fmt:message key="eOA.Break.label" bundle="${oa_labels}"/></td>
			<td width="3%"  class='OARED'>&nbsp;</td>
			<td width="20%"  class='oalabel'><fmt:message key="Common.blocked.label" bundle="${common_labels}"/></td>
			<td width="3%"  class='OAFORCED'>&nbsp;</td>
			<td width="20%"  class='oalabel'><fmt:message key="eOA.ForcedAppointment.label" bundle="${oa_labels}"/></td>

			<%if(isSlotStartMidEndAppl){%>
				<td width="3%"  class='OABRUHEALTH'>&nbsp;</td>
				<td width="20%" class='oalabel'><fmt:message key="eOA.BruHealthSlot.label" bundle="${oa_labels}"/></td>
			<%}%>
	<% } %>
	</tr>

	</table>
	</body>

	<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
	%>

	</html>

