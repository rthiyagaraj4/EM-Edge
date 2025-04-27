<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*,java.util.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseLocation.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
    String	bean_id				= "DispenseLocationBean" ;
	String	bean_name			= "ePH.DispenseLocationBean";
	DispenseLocationBean bean		= (DispenseLocationBean)getBeanObject( bean_id, bean_name, request);
	
	String disp_locn_code = bean.checkForNull(request.getParameter("disp_locn_code"),"");


	ArrayList view_ranges =new ArrayList();
	view_ranges=(ArrayList)bean.getDailySpecificRange();
	

	%>
     
</head>
<!-- <title><fmt:message key="ePH.VIEWRANGES.label" bundle="${ph_labels}"/> </title> -->
<title>Defined Sequence Ranges</title>


<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"
>
<FORM name="formViewRanges" id="formViewRanges">
<table width='100%' border='1' cellspacing='0' cellpadding='0' align='center'>
	<tr >
				<TH ALIGN="left" >Dispence Location</TH>
				<TH ALIGN="left" >Sequence Range</TH>
	</tr>
	
	<%

	for(int i=0;i<view_ranges.size();i+=4)
	{
	%>
	<tr>
	<td  class = "QRYEVEN" ALIGN="center"><%=view_ranges.get(i)%> </td>
	<td  class = "QRYEVEN" ALIGN="center"><%=view_ranges.get(i+1)%>&nbsp;-&nbsp;<%=view_ranges.get(i+2)%></td>
	</tr>
	<%}%>
</table>


	
</form>
</body>

</html>
	
<% 

%>

