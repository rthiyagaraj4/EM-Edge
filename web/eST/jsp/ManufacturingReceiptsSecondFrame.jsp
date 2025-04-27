
 <%@ page  import=" java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title> </title>
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eST/js/ManufacturingReceipts.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<%
	eST.ManufacturingReceiptsBean bean = (eST.ManufacturingReceiptsBean)getBeanObject( "ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean", request );
	bean.setLanguageId(locale);
%>

	<frameset rows="45%,*">
		<frame name='frameHeader'				src="../../eST/jsp/ManufacturingReceiptsHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="30%,*" >
			<frame name='frameDetail'			src='../../eCommon/html/blank.html'  					frameborder=0 scrolling='auto'   noresize> 
			<frame name='frameList'			src="../../eST/jsp/ManufacturingReceiptsListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no' noresize>
			<%
putObjectInBean("ManufacturingReceiptsBean",bean,request);
%>
			</frameset>
		</frameset>
	</frameset>
	<!--
	* @Name - Priya
	* @Date - 21/12/2009
	* @Inc# - IN017084
	* @Desc - To avoid the duplication records display in Modify mode
	 -->
		<script>
		//clearMessageFrame();
		</script>
</html>
