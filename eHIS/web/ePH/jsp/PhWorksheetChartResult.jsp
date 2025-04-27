<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	  	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<!--<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
	<script language="JavaScript" src="../../ePH/js/PhWorksheetChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmPrintPrescriptionReportResult" id="frmPrintPrescriptionReportResult" >
<%
	
	String bean_id = "PHRepDispStatisByDispBean" ;
	String bean_name = "ePH.PHRepDispStatisByDispBean";

	PHRepDispStatisByDispBean bean = (PHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);

	String report_type = CommonBean.checkForNull(request.getParameter("report_type"));
	String patient_class = CommonBean.checkForNull(request.getParameter("patient_class"));
	String stage = CommonBean.checkForNull(request.getParameter("stage"));
	String disp_locn_code = CommonBean.checkForNull(request.getParameter("disp_locn_code"));
	String from_date  = CommonBean.checkForNull(request.getParameter("from_date"));
	String to_date = CommonBean.checkForNull(request.getParameter("to_date"));
	String facility_id=(String) session.getValue( "facility_id" );
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));

	ArrayList result = bean.getAllWorksheets(report_type,patient_class,stage,disp_locn_code,from_date,to_date,facility_id,from,to);

	if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
		out.println(result.get(0));
	%>
		</td></tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th ><fmt:message key="ePH.WorksheetID.label" bundle="${ph_labels}"/></th><th ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
		
		<th><fmt:message key="Common.PreparedBy.label" bundle="${common_labels}"/></th><!-- added for for  PMG2021-MOHE-CRF-0003.6 -->
	
	<%

		ArrayList record=new ArrayList();
		for (int i=1;i<result.size();i++){
			record= (ArrayList)result.get(i);
			String classvalue="";
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=record.get(0)%>','<%=report_type%>','<%=stage%>','<%=record.get(3)%>')"><%=record.get(0)%></font></td>
			<%
		
	String dtdkval = com.ehis.util.DateUtils.convertDate((String)record.get(1),"DMYHM","en",locale);

	
		%>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;&nbsp;<%=dtdkval%></td>
			<td class="<%=classvalue%>" style="font-size=9">&nbsp;&nbsp;<%=record.get(2)%></td>
	
		</tr>
	<%
		}
	}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
	}
	%>

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

