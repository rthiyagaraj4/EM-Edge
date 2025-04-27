<!DOCTYPE html>
  <!--This file is saved on 07/11/2005-->

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.ScreeningDetails.label" bundle="${ph_labels}"/></title>
</head>
 <%
	//String qs = "battery_id=QT2&episode_id=100124620001&dob=3/12/1979&Sex=M&module_id=PH&mode=U&patient_id=SD00000867&patient_class=OP&last_record_date=?";
	String qs = request.getQueryString();
	//out.println("qs---->"+qs);
	String frameSet="*,7%,7%";
 %>
<frameset rows='<%=frameSet%>'  class='<%=request.getParameter("cname")%>' >
	<frame name ='addModifyFrame' border="0" marginwidth=0 marginheight=0 frameborder=NO src='../../ePH/jsp/DisDataChartingRecord.jsp?<%=qs%>'  noresize > </frame>
	<frame name ='toolsFrame' border="0"  marginwidth=0 marginheight=0 frameborder=NO scrolling=NO src='../../ePH/jsp/DisDataChartingTools.jsp?<%=qs%>'  noresize > </frame>
	<frame name ='messageFrame' border="0"  marginwidth=0 marginheight=0 frameborder=NO scrolling=NO src='../../eCommon/jsp/error.jsp'  noresize > </frame>
</frameset>

</html>

