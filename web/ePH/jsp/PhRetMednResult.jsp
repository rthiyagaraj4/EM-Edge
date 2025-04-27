<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
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
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/PhMednRtn.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script> 
	 <script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="frmPrintDispSheetResult" id="frmPrintDispSheetResult" >
<%
	String bean_id = "ReturnMedicationBean" ;
	String bean_name = "ePH.ReturnMedicationBean";

	ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String patient_id	= CommonBean.checkForNull(request.getParameter("patient_id"));
	String disp_no		= CommonBean.checkForNull(request.getParameter("disp_no"));
	String facility_id=(String) session.getValue( "facility_id" );
	String from = CommonBean.checkForNull(request.getParameter("from"));
	String to = CommonBean.checkForNull(request.getParameter("to"));
	ArrayList result = bean.getBatchDetailsReport(patient_id,disp_no,facility_id,from,to);
	String rtn_medn_no="", prevRtn_medn_no="", currRtn_medn_no="", returned_date="";

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
			<th width='35%' ><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></th>		
			<th width='10%' ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
			<th width='15%' ><fmt:message key="Common.expiryDate.label" 	bundle="${common_labels}"/></th>
			<th width='10%' ><fmt:message key="ePH.ReturnMedicationNo.label" bundle="${ph_labels}"/></th>
			<th width='10%' ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
			<th width='5%' ><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></th>
			<th width='15%' ><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></th>
	<%
		String classvalue	= "";
		for (int i=1;i<result.size();i+=8){
			currRtn_medn_no = (String)result.get(i+6);
			returned_date = (String)result.get(i+7);
			if(!currRtn_medn_no.equals(prevRtn_medn_no)){
				prevRtn_medn_no = currRtn_medn_no;
				rtn_medn_no = currRtn_medn_no ;
			}
			else{
				rtn_medn_no = "";
			}
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr class="<%=classvalue%>">
			<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i)%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i+1)%></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+2),"DMY","en",locale)%></td>
			<td class="<%=classvalue%>" style="font-size=9">
				<font class="hyperlink" style="cursor:pointer" onClick="showReportReturnMedication('<%=rtn_medn_no%>','<%=returned_date%>')"><%=rtn_medn_no%>&nbsp;</font></td>
			<td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i+3)%></td>
             <td class="<%=classvalue%>" style="font-size=9"><%=(String)result.get(i+5)%></td> 
			<td class="<%=classvalue%>" style="font-size=9"><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+4),"DMY","en",locale)%></td>	
			</tr>		
	<%
		}%>
	 </table>
	<%}else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<% } %>

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="disp_no" id="disp_no" value="">
	<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

