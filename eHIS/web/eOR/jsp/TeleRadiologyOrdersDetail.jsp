<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		Ramesh G       GHL-CRF-0487 [IN:065642]
14/02/2018      IN066695        Prathyusha p     14/02/2018        Ramesh G        GHL-CRF-0487_US001 [IN:065642]

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eOR.* ,eOR.Common.*, java.util.*,java.lang.*,eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<title>
Audit Trail
</title>
	<%

	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 Properties properties = (Properties)session.getValue("jdbc");
	String locale	= (String) properties.getProperty("LOCALE");
	String facilityId = (String)session.getValue("facility_id");

	 String bean_id					= "TeleRadiologyOrdersBean" ;
		String bean_name				= "eOR.TeleRadiologyOrdersBean";
		TeleRadiologyOrdersBean bean	= (TeleRadiologyOrdersBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(locale);
		
		String order_id = request.getParameter("order_id") == null ? "" : request.getParameter("order_id") ;
		String catalog_desc = request.getParameter("catalog_desc") == null ? "" : request.getParameter("catalog_desc") ;
		String ordering_facility_id = request.getParameter("ordering_facility_id") == null ? "" : request.getParameter("ordering_facility_id") ;
		String ordered_by = request.getParameter("ordered_by") == null ? "A" : request.getParameter("ordered_by") ;
		String operating_facility_id = request.getParameter("operating_facility_id") == null ? "" : request.getParameter("operating_facility_id") ;
		String performed_by = request.getParameter("performed_by") == null ? "" : request.getParameter("performed_by") ;
		String exam_status=request.getParameter("exam_status") == null ? "" : request.getParameter("exam_status") ;
		String request_num=request.getParameter("request_num") == null ? "" : request.getParameter("request_num") ;
		String request_line_num=request.getParameter("request_line_num") == null ? "" : request.getParameter("request_line_num") ;
		
		ArrayList auditTrailsList = (ArrayList)bean.auditTrailDetails(operating_facility_id, request_num, request_line_num);
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../js/TeleRadiologyOrderDetails.js"></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="TeleRadiologyOrdersDetailsForm"  >
<table border="0" cellpadding="4" cellspacing="0"  width="100%"  >
	<tr>
		<td class=label width="10%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=label width="2%"> : </td>
		<td class=label width="20%"><%=order_id%></td>
		<td class=label width="10%"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class=label width="2%"> : </td>
		<td class=label width="20%"><%=catalog_desc%></td>
		<td class=label width="12%"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/> / <fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class=label width="2%"> : </td>
		<td class=label width="24%"><%=ordered_by%>/<%=ordering_facility_id%></td>
	</tr>
	<tr>
		<td class=label width="10%"><fmt:message key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class=label width="2%"> : </td>
		<td class=label width="20%"><%=ordering_facility_id%></td>
		<td class=label width="10%"><fmt:message key="Common.Performed.label" bundle="${common_labels}"/> <fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td class=label width="2%"> : </td>
		<td class=label width="20%"><%=performed_by%></td>
		<td class=label width="38%" colspan="3">&nbsp;</td>
	</tr>

</table>

<div id='table_container_left' style='overflow:auto;width:100%;' >  
	<table  width="100%"  class='grid' id='titleTable' >
        <tr  style='height:60px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2);'>
			<th  class='COLUMNHEADER' ><fmt:message key="eOR.ExamStatus.label" bundle="${or_labels}"/></th>
            <th  class='COLUMNHEADER' ><fmt:message key="eOR.DateandTime.label" bundle="${or_labels}"/> </th>
			<th  class='COLUMNHEADER' >	<fmt:message key="Common.RepFacility.label" bundle="${common_labels}"/></th>
            <th class='COLUMNHEADER' >	<fmt:message key="Common.Assigned.label" bundle="${common_labels}"/>  <fmt:message key="eOR.radiologist.label" bundle="${or_labels}"/></th>
			<th  class='COLUMNHEADER' >	User</th>
            <th  class='COLUMNHEADER' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>        
        </tr>
        <%for(int i=0;i<auditTrailsList.size();i=i+7) {%>
        <tr>
            <td class='gridDataChart' nowrap><%=auditTrailsList.get(i) %></td>
            <td class='gridDataChart' nowrap><%=auditTrailsList.get(i+1) %></td>
            <td class='gridDataChart' nowrap><%=auditTrailsList.get(i+2) %></td>
			<td class='gridDataChart' nowrap><%=auditTrailsList.get(i+3) %></td>
			<td class='gridDataChart' nowrap><%=auditTrailsList.get(i+6) %></td>
            <%             
            if(auditTrailsList.get(i+4).equals("")){%>
			<td class='gridDataChart' nowrap> </td>
			<%}else {
				String encodeRemarks =java.net.URLEncoder.encode((String)auditTrailsList.get(i+4), "UTF-8");
			%>				
			 <td    class="gridDataChart"   nowrap onMouseOver = 'showToolTipsForChnFldRmks(this,"<%=encodeRemarks%>")' style="color: blue"><fmt:message key="eOR.ViewRemarks.label" bundle="${or_labels}"/></td>
           <%}%>
		</tr>  
        <%}%>
    </table>
</div>        
<input type='hidden' name='locale_detail' id='locale_detail' value ='<%=locale%>'>
</form>
</body>
</html>

