<!DOCTYPE html>
<%@ page import ="eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,java.util.HashMap,eOT.*,eOT.Common.*"%><%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<HTML>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/PreOperCheckIn.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String params = request.getQueryString();
	String bill_flag = request.getParameter("bill_flag");
	String called_from = request.getParameter("called_from");
	String order_id =CommonBean.checkForNull(request.getParameter("order_id"));	
%>
<form name = 'RecordOperationForm' id = 'RecordOperationForm' >
<table border='0'  cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr> 
	  <td class='label' width='25%'>
	  <fmt:message key="Common.operation.label" bundle="${common_labels}"/> 
	  </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='operation_code' id='operation_code' maxlength='10' 
		  onBlur="if(this.value!='')searchOperations();else clearDescValue();"> 
		  <input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick='searchOperations();' >
		  <img name='imageflag1' src='../../eCommon/images/mandatory.gif'></img>
	  </td>
<!--     <td  width='25%'></td>
	    <td  width='25%'></td>
 --> 
	  <td  class='label' width='25%' >
		<fmt:message key="Common.description.label" bundle="${common_labels}"/> 
	  </td>
	  <td class='fields' width='25%'>
		<input type='text' name='operation_desc' id='operation_desc' maxlength='10' readonly> 
	  </td>
 </tr>

<tr>
	<td class='label' width='25%' >
		<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/> 
	</td>
	<td  class='fields' width='25%' >
		<select name='side_applicable' id='side_applicable' DB_VALUE='' >
		<option value='' >
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
		<option value='R' >
			<fmt:message key="eOT.RightSide.Label" bundle="${ot_labels}"/>
		</option>
		<option value='L' >
			<fmt:message key="eOT.LeftSide.Label" bundle="${ot_labels}"/>
		</option>
		<option value='B' >
			<fmt:message key="eOT.Bilateral.Label" bundle="${ot_labels}"/>
		</option>
		</select>
		<img src='../../eCommon/images/mandatory.gif' name='imageflag'></img>
	</td>
	<td class='label' width='25%' valign='top'>
		<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 
	</td>
	<td class='fields' width='25%' >
		<textarea rows='4' cols='30' name='remarks' id='remarks' onkeypress="return checkForSpecCharsforID(event);" Onblur="return CheckChars1(this);" onChange='checkLimit(this,2000)'></textarea>
	</td>
</tr>
<tr>
	<td class='fields'   width='25%'>
	</td>
	<td class='fields'   width='25%'>
	</td>
		<td class='fields'   width='25%'>
	</td>
	<td class='fields'   width='25%'>
		<!--<fmt:message key="Common.select.label" bundle="${common_labels}"/>-->
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='callRecordfunction();' >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='funCheckDeletion();' >
	</td>
</tr>
<style>
textarea {
  resize: none;
}
</style>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='params' id='params' value='<%=params%>'>
<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
<input type='hidden' name='collect_speciality_code' id='collect_speciality_code' value=''>
<input type='hidden' name="side_applicable_yn" id="side_applicable_yn" value=''>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='bill_flag' id='bill_flag' value="<%=bill_flag%>">
<input type='hidden' name='catalog_code' id='catalog_code' value="">
</form>
</BODY>
</HTML>

