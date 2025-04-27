<%
/*
---------------------------------------------------------------------------------------------------------------
Date		Edit History	 Name			Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
21/10/2024     70704	   Gunasekar R	              	22/10/2024	    Ashwini Ragupathi          ML-MMOH-CRF-1759
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String imgUrl="";
		if(sStyle.equals("IeStyle.css"))
		 {
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
   	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMenstHistDtl.js'></script> 
 	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecClinicalLinkMenstCriteriaForm' id='RecClinicalLinkMenstCriteriaForm'>
<%
	String	query_title				=	"";
	String  patient_id				=	"";
	String  result_linked_rec_type	=	"";
	String  sec_hdg_code            =   "";
	String  short_desc				=	"";
	String  return_format			=	"";
	String 	dispResLinkHYMLYN		=	"";
	String  call_from_link_doc_btn  =   "";
	
	patient_id				=	(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	return_format			=	(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	sec_hdg_code			=	(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
	result_linked_rec_type	=	(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	dispResLinkHYMLYN 		= 	(request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");
	call_from_link_doc_btn 	= 	(request.getParameter("call_from_link_doc_btn")==null)?"":request.getParameter("call_from_link_doc_btn");
	

 	String ca_bean_id = "@CAMenstrualHistDtlTransBean";
 	String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
 	CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(ca_bean_id, ca_bean_name, request);
 	short_desc = bean.getShortDesc(result_linked_rec_type,locale);

%>
<table align=center border='0' width='100%'  cellspacing='0' cellpadding='3'>
<tr>
		<td class='columnheader' colspan=4 ><b><%=short_desc%></b></td>
</tr>	

<tr>
	  	<td class="LABEL" width='25%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	  	<td class="fields"  width='25%' >
      	<input type="radio" name="event_type" id="event_type" value="LMP" checked onclick="radio(this);"><fmt:message key="eCA.LastMenstrualPeriod.label" bundle="${ca_labels}"/></td>
      	<td class="fields" width='25%'>
      	<input type="radio" name="event_type" id="event_type" value="USOD" onclick="radio(this);"><fmt:message key="eCA.UnsureOfDate.label" bundle="${ca_labels}"/></td>
      	<td width='25%'>&nbsp;</td>
</tr>

 <tr>
		<td class="LABEL" width='25%'><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
		<td class="fields"  width='10%'> <input type="checkbox" name="event_status_a" id="event_status_a" value="A" checked >&nbsp;&nbsp;<fmt:message key="Common.active.label" bundle="${common_labels}"/></td>
   	    <td class="fields"  width='10%'> <input type="checkbox" name="event_status_ac" id="event_status_ac" value="AC" checked>&nbsp;&nbsp;<fmt:message key="eCA.AutoClose.label" bundle="${ca_labels}"/></td>
        <td class="fields"  width='10%' > <input type="checkbox" name="event_status_c" id="event_status_c" value="C" checked>&nbsp;&nbsp;<fmt:message key="Common.close.label" bundle="${common_labels}"/></td>
</tr>	

<tr>
		<td class="LABEL" width='25%'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td class="fields"  width='25%'><input type='text'  name='from_date_time' id='from_date_time' value="" size='14' maxLength='16'  onBlur='Check_Date(this,"DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');"></td>
		<td class="LABEL"  width='25%' ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%' ><input type='text'  name='to_date_time' id='to_date_time' value="" size='14' maxLength='16'   onBlur='checkingDate(this,"DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');"></td>
</tr>

<tr>
		<td   class="label"  width='25%'><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
		<td   class="fields"  width='25%'>
		<input type="radio" name="order_by" id="order_by" value="A" checked><fmt:message key="Common.ascending.label" bundle="${common_labels}"/>
		<input type="radio" name="order_by" id="order_by" value="D"><fmt:message key="Common.descending.label" bundle="${common_labels}"/></td>
		<td width='25%'></td>
		<td width='25%' align='right'> 
		<input type="button" class="button" name="btnSearch" id="btnSearch" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="funSearchnew();">	
		<input type="button" class="button" name="clearSearch" id="clearSearch" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="Clear_Allnew();">	
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>		
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="result_linked_rec_type" id="result_linked_rec_type" value="<%=result_linked_rec_type%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>">

<%
if(call_from_link_doc_btn.equals("YES"))
{
%>
	<script>
		funSearchnew();
	</script>
<%
}
else{ 
%>
	<script>
		funSearchnew();
	</script>
<%
}
%>
</form>
</center>
</body>
</html>

