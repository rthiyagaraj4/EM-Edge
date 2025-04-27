<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	 <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ChangeExpiryFlag.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Script>
		function tab_click2(id) 
		{
			selectTab(id);
			if  (id=='transaction')
				populateEnterpise();
			if  (id=='storelevel')
					populateStore();
			if  (id=='batchdetails')
					populateBatch();
		}
	</Script>
</head>
<body onSelect="">	 <!-- codeArrestThruSelect(); -->
<%

	String item_code=request.getParameter("item_code");
	ChangeExpiryFlagBean bean = (ChangeExpiryFlagBean) getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request );
	bean.setLanguageId(locale);
	bean.loadData();

%>
<%  if (bean.getUnfinalisedRecords()){ //HIDE THE Batch Details Tab%>

<form name="formChangeExpiryFlagEnterprise" id="formChangeExpiryFlagEnterprise">
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
				<td class="white">
					<ul id="tablist" class="tablist" style="padding-left:0px;">
						<li class="tablistitem" title=<fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>>
							<a onclick="tab_click2('transaction')" class="tabClicked" id="transaction" >
								<span class="tabSpanclicked" id="transactionspan"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title='<fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/>'>
							<a onclick="tab_click2('storelevel')" class="tabA" id="storelevel" >
								<span class="tabAspan" id="storelevelspan"><fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/></span>
							</a>
						</li>	
					</ul>
				</td>
			</tr>
		</table>
	<!-- 	<table border="0" cellpadding="1" cellspacing="0" width='85%'  align=center>
			<a name="tab1"></a>
			<img  src="../../eST/images/Transaction.gif" border=0 onclick="populateEnterpise();"><a  href="javascript:tab7.scrollIntoView();" onFocus="javascript:tab1.scrollIntoView();"><img  src="../images/Store Level_click.gif" border=0 onclick="populateStore();"></a>
			</table> -->
			<br><br><br><br>
			<input type=hidden name=enableApply value=false>
	</form>

	<form name="formChangeExpiryFlagStore" id="formChangeExpiryFlagStore">
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
				<td class="white">
					<ul id="tablist" class="tablist" style="padding-left:0px;">
						<li class="tablistitem" title='<fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>'>
							<a onclick="tab_click2('transaction')" class="tabClicked" id="transaction" >
								<span class="tabSpanclicked" id="transactionspan"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title='<fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/>'>
							<a onclick="tab_click2('storelevel')" class="tabA" id="storelevel" >
								<span class="tabAspan" id="storelevelspan"><fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/></span>
							</a>
						</li>	
					</ul>
				</td>
			</tr>
		</table>
			<!-- <table border="0" cellpadding="0" cellspacing="0" width='85%'  align=center>
			<tr>
				<td   class='white'><a  href="javascript:tab1.scrollIntoView();" onFocus="javascript:tab7.scrollIntoView();" name="tab7"><img  src="../images/Transaction_click.gif" border=0 onclick="populateEnterpise();"><img  src="../images/Store Level.gif" border=0 onclick="populateStore();"></a></td>
			</tr>
			</table> -->
									<input type=hidden name=enableApply value=false>
		<input type=hidden name=item_code value="<%=item_code%>">
<br><br><br><br>
</form>
<%}else  {%>
<form name="formChangeExpiryFlagEnterprise" id="formChangeExpiryFlagEnterprise">
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
				<td class="white">
					<ul id="tablist" class="tablist" style="padding-left:0px;">
						<li class="tablistitem" title='<fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>'>
							<a onclick="tab_click2('transaction')" class="tabClicked" id="transaction" >
								<span class="tabSpanclicked" id="transactionspan"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title='<fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/>'>
							<a onclick="tab_click2('batchdetails')" class="tabA" id="batchdetails" >
								<span class="tabAspan" id="batchdetailsspan"><fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></span>
							</a>
						</li>	
					</ul>
				</td>
			</tr>
		</table>
		<!-- <table border="0" cellpadding="1" cellspacing="0" width='85%' align=center>
			<a  name="tab1"></a>
			<img  src="../../eST/images/Transaction.gif" border=0 ><a  href="javascript:tab2.scrollIntoView();" onFocus="javascript:tab1.scrollIntoView();"><img  src="../images/Store Level_click.gif" border=0 onclick="populateStore();"></a><a  href="javascript:tab3.scrollIntoView();" onFocus="javascript:tab1.scrollIntoView();"><img  src="../images/Batch Details_click.gif" border=0 onclick="populateBatch();"></a>
			</table> -->
			<input type=hidden name=enableApply value=true>
			<br><br><br><br>
			</form>
<form name="formChangeExpiryFlagStore" id="formChangeExpiryFlagStore">
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
				<td class="white">
					<ul id="tablist" class="tablist" style="padding-left:0px;">
						<li class="tablistitem" title='<fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>'>
							<a onclick="tab_click2('transaction')" class="tabClicked" id="transaction" >
								<span class="tabSpanclicked" id="transactionspan"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title='<fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/>'>
							<a onclick="tab_click2('batchdetails')" class="tabA" id="batchdetails" >
								<span class="tabAspan" id="batchdetailsspan"><fmt:message key="Common.BatchDetails.label" bundle="${common_labels}"/></span>
							</a>
						</li>	
					</ul>
				</td>
			</tr>
		</table>
		<!-- <table border="0" cellpadding="1" cellspacing="0" width='85%'  align=center>
			<a  name="tab2"></a>
			<a  href="javascript:tab1.scrollIntoView();" onFocus="javascript:tab2.scrollIntoView();"><img  src="../../eST/images/Transaction_click.gif" border=0 onclick="populateEnterpise();"></a><img  src="../images/Store Level.gif" border=0><a  href="javascript:tab3.scrollIntoView();" onFocus="javascript:tab2.scrollIntoView();"><img  src="../images/Batch Details_click.gif" border=0 onclick="populateBatch();"></a>
			</table> -->
			<br><br><br><br>
				<input type=hidden name=enableApply value=true>
				</form>
<form name="formChangeBatchDetails" id="formChangeBatchDetails">
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
			<tr>
				<td class="white">
					<ul id="tablist" class="tablist" style="padding-left:0px;">
						<li class="tablistitem" title='<fmt:message key="Common.Transaction.label" bundle="${common_labels}"/>'>
							<a onclick="tab_click2('transaction')" class="tabClicked" id="transaction" >
								<span class="tabSpanclicked" id="transactionspan"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title='<fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/>'>
							<a onclick="tab_click2('storelevel')" class="tabA" id="storelevel" >
								<span class="tabAspan" id="storelevelspan"><fmt:message key="eST.StoreLevel.label" bundle="${st_labels}"/></span>
							</a>
						</li>	
					</ul>
				</td>
			</tr>
		</table>
		<!-- <table border="0" cellpadding="1" cellspacing="0" width='85%'  align=center>
			<a  name="tab3"  id=tab_3></a>
			<a  href="javascript:tab1.scrollIntoView();" onFocus="javascript:tab3.scrollIntoView();"><img  src="../../eST/images/Transaction_click.gif" border=0 onclick="populateEnterpise();"></a><a  href="javascript:tab2.scrollIntoView();" onFocus="javascript:tab3.scrollIntoView();"><img  src="../images/Store Level_click.gif" border=0 onclick="populateStore();"></a><img  src="../images/Batch Details.gif" border=0 >
			</table> -->
				<input type=hidden name=enableApply value=true>
			<br><br><br><br>
	</form>
<%}%>
<%
putObjectInBean("ChangeExpiryFlagBean",bean,request);
%>
	</body>
</html>

