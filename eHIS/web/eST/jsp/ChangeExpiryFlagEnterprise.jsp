<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ChangeExpiryFlag.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onSelect="codeArrestThruSelect();">	 
<%
	//String mode;
	//String bean_id;
	//String bean_name;
	//String function_id;
	//String codeDisabled =	"";
	//String disabled		=	"";
	//String store_code ="";

	//String item_analysis = "";
	//String checked = "";
	String item_code=request.getParameter("item_code");
	
	ChangeExpiryFlagBean bean = (ChangeExpiryFlagBean) getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request );
	bean.initialize();
	bean.setLanguageId(locale);
	bean.setItem_code(item_code);
	bean.loadData();
	String noRecords="";
	if(bean.getUnfinalisedRecords())
		noRecords="true";
	else
		noRecords="false";
	/* Mandatory checks start */
	//boolean editMode = false;
	//String bin_locations = "";
	
%>
<form name="formChangeExpiryFlagEnterprise" id="formChangeExpiryFlagEnterprise" onload="">
		<table border="1" cellpadding="1" cellspacing="0" width='85%'  align=center>
			<th colspan=4 ><fmt:message key="eST.NoofUnfinalised/GLUninterfacedTransactions.label" bundle="${st_labels}"/></th>
		 	<tr>
				<th width="30%"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
				<th  width="20%"  class='label'><fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
				<th  width="30%"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
				<th  width="20%"><fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
			</tr> 
			<tr>
				<td  class="QRYODD" ><fmt:message key="eST.GRN.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYODD><b><%=bean.getGRNCount()%></b></td>
				<td  class="QRYODD"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYODD><b><%=bean.getSALCount()%></b></td>
			</tr>
			<tr>
				<td  class="QRYEVEN"><fmt:message key="eST.ReturntoVendor.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYEVEN><b><%=bean.getRTVCount()%></b></td>
				<td  class="QRYEVEN"><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYEVEN><b><%=bean.getSRTCount()%></b></td>
			</tr>
			<tr>
				<td  class="QRYODD"><fmt:message key="eST.RequisitionIssues.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYODD><b><%=bean.getISSCount()%></b></td>
				<td  class="QRYODD"><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYODD><b><%=bean.getADJCount()%></b></td>
			</tr>
			<tr>
				<td  class="QRYEVEN"><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYEVEN><b><%=bean.getURGCount()%></b></td>
				<td  class="QRYEVEN"><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYEVEN><b><%=bean.getTFRCount()%></b></td>
			</tr>
			<tr>
				<td  class="QRYODD"><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYODD><b><%=bean.getRETCount()%></b></td>
				<td  class="QRYODD"><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYODD><b><%=bean.getPRTCount()%></b></td>
			</tr>
			<tr>
				<td  class="QRYEVEN"><fmt:message key="eST.ManufactureReceipts.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td  class=QRYEVEN><b><%=bean.getMFGCount()%></b></td>
				<td  class="QRYEVEN">&nbsp;&nbsp;</td>
				<td  class=QRYEVEN>&nbsp;&nbsp;</td>
			</tr>
			</table>
			<input type=hidden name=noRecords id=noRecords value="<%=noRecords%>">
		</form>
</table>
<input type=hidden name=item_code id=item_code>
<input type=hidden name=expiry_yn id=expiry_yn>

<script>
	enableDisableExpiryFlag();
</script>

</form>
<%
putObjectInBean("ChangeExpiryFlagBean",bean,request);
%>
</body>
</html>

