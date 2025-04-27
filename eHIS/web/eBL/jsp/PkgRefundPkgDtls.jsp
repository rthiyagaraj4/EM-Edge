<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,webbeans.op.CurrencyFormat,eBL.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<%
String title=request.getParameter("title");

%> 
<title><%=title%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../js/PkgRefund.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<% 
	try
	{		
		
		String locale			= (String)session.getAttribute("LOCALE");

		String facility_id			= request.getParameter("facility_id")==null?"": request.getParameter("facility_id");
		String patient_id			= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
		String pkg_code			= request.getParameter("pkg_code")==null?"": request.getParameter("pkg_code");
	
		
		String bean_id		= "PkgRefundBean" ;
		String bean_name	= "eBL.PkgRefundBean";
		PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
		String[] pkg_dtls=bean.getPkgDtls(facility_id,patient_id,locale,pkg_code);

   %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">	
	<form name='PkgRefundPkgDtlsForm' id='PkgRefundPkgDtlsForm' >
	<table cellpadding=0 cellspacing=0 border=0  width="100%" align='center'>
	<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="Common.PackageCode.label"   bundle="${common_labels}"/></td>
			<td class="label" nowrap><%=pkg_code%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
	<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.PKG_DESC.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[0]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.packageSeqNo.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[1]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[2]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[3]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.BillingClassCode.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[4]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
		<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.BillingClassDesc.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[5]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.PAYER_GROUP_CODE.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[6]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.PAYER_GROUP_DESC.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[7]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.PAYER_CODE.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[8]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.PAYER_DESC.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[9]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.PKG_AMT.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[10]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.DEPOSIT_AMT.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[11]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
		  <td class="label" nowrap><fmt:message key="eBL.UtilizedAmt.label"   bundle="${bl_labels}"/></td>
			<td class="label" nowrap><%=pkg_dtls[12]%></td>
			<td class='label' nowrap colspan='2'>&nbsp;</td>				
	</tr>
			<tr>		
			<td class='label' nowrap colspan='4'>&nbsp;</td>				
	</tr>
	<tr>		
			<td class='field' align='right' colspan='4'><input type='button' class='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='window.close()'></td>				
	</tr>
</table>
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from Package Refund header :"+e);
	e.printStackTrace();
}
		%>
		

