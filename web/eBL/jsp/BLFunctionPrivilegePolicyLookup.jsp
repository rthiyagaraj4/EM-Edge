<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@page import="eBL.BLFunctionPrivilegeBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
}

%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String userType = checkForNull(request.getParameter("userType"));
	String userCode = checkForNull(request.getParameter("userCode"));
	String functionId = checkForNull(request.getParameter("functionId"));
	String privilegeCode = checkForNull(request.getParameter("privilegeCode"));
	String effectiveDate = checkForNull(request.getParameter("effectiveDate"));
	String allowedYn = checkForNull(request.getParameter("allowedYn"));
	
	String payerGroup = decodeParam(request.getParameter("payerGroup"));
	String payerGroupDesc = decodeParam(request.getParameter("payerGroupDesc"));
	String payer = decodeParam(request.getParameter("payer"));
	String payerDesc = decodeParam(request.getParameter("payerDesc"));
	String policy = decodeParam(request.getParameter("policy"));
	String policyDesc = decodeParam(request.getParameter("policyDesc"));
	String fromDate = checkForNull(request.getParameter("fromDate"));
	String toDate = checkForNull(request.getParameter("toDate"));
	int from = 0;
	int to = 0;
	int totalRecords = 0;
	String strStart = checkForNull(request.getParameter("from"));
	String strEnd = checkForNull(request.getParameter("to"));
	if(strStart == null || "".equals(strStart)){
		from = 1;
	}
	else{
		from = Integer.parseInt(strStart);
	}
	
	if(strEnd == null || "".equals(strEnd)){
		to = 20;
	}
	else{
		to = Integer.parseInt(strEnd);
	}
	LinkedHashMap	functionPrivilegeMap	=	null;
	request.setCharacterEncoding("UTF-8");
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLFunctionPrivilegePolicy.js"></script>


<%

String strQueryString= checkForNull(request.getParameter("queryString"));
if(strQueryString.length()==0)	strQueryString= request.getQueryString();

%>

<script language = 'javascript'>
function movePrevthis(start,end)
{
	var params =  document.forms[0].queryString.value;
	

//	var params =  document.forms[0].queryString.value;
 	
  
 	var strt = start-20;
 	var endd= end-20;
	
 
	parent.frames[0].location.href="../../eBL/jsp/BLFunctionPrivilegePolicyLookup.jsp?from="+strt+"&to="+endd+"&"+params;
	
	}
	
function moveNextthis(start,end)
{
	var params =  document.forms[0].queryString.value;



	
	var strt = start +20;
	var endd= end+20 ;


 parent.frames[0].location.href="../../eBL/jsp/BLFunctionPrivilegePolicyLookup.jsp?from="+strt+"&to="+endd+"&"+params;

	
}

function applyFilter(){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	var start = document.forms[0].from.value;
	var end = document.forms[0].to.value;
	
	var policyLookupUrl = "../../eBL/jsp/BLFunctionPrivilegePolicyLookup.jsp?userType="+frm.userType.value+	
	"&userCode="+frm.userCode.value+"&functionId="+frm.functionId.value+
	"&privilegeCode="+frm.privilegeCode.value+"&effectiveDate="+frm.effectiveDate.value+"&allowedYn="+frm.allowedYn.value+
	"&payerGroup="+escape(frm.custGrpCode.value)+"&payerGroupDesc="+escape(frm.custGrpDesc.value)+
	"&payer="+escape(frm.custCode.value)+"&payerDesc="+escape(frm.custDesc.value)+
	"&policy="+escape(frm.policyCode.value)+"&policyDesc="+escape(frm.policyDesc.value);
	
	parent.frames[0].location.href="../../eBL/jsp/BLFunctionPrivilegePolicyLookup.jsp?userType="+frm.userType.value+	
	"&userCode="+frm.userCode.value+"&functionId="+frm.functionId.value+
	"&privilegeCode="+frm.privilegeCode.value+"&effectiveDate="+frm.effectiveDate.value+"&allowedYn="+frm.allowedYn.value+
	"&payerGroup="+escape(frm.custGrpCode.value)+"&payerGroupDesc="+escape(frm.custGrpDesc.value)+
	"&payer="+escape(frm.custCode.value)+"&payerDesc="+escape(frm.custDesc.value)+
	"&policy="+escape(frm.policyCode.value)+"&policyDesc="+escape(frm.policyDesc.value);
}

function resetFilter(){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	parent.frames[0].location.href="../../eBL/jsp/BLFunctionPrivilegePolicyLookup.jsp?userType="+frm.userType.value+	
	"&userCode="+frm.userCode.value+"&functionId="+frm.functionId.value+
	"&privilegeCode="+frm.privilegeCode.value+"&effectiveDate="+frm.effectiveDate.value+"&allowedYn="+frm.allowedYn.value;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<style>

	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}		

		TD.YELLOW 
		{
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		</style>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%

String bean_id	= 	"FunctionPrivilegeBean" ;
String bean_name = 	"eBL.BLFunctionPrivilegeBean";
BLFunctionPrivilegeBean	functionPrivilegeBean = 	(BLFunctionPrivilegeBean)getBeanObject( bean_id, bean_name, request ) ;
//effectiveDate = "21-OCT-2024";

functionPrivilegeMap = functionPrivilegeBean.getPolicyCustDetails(facility_id, userType, userCode, functionId, privilegeCode, effectiveDate, payerGroup, payer, policy, fromDate, toDate,from,to,allowedYn);

if(functionPrivilegeMap.containsKey("totalRecords"))
	totalRecords =  (Integer) functionPrivilegeMap.get("totalRecords");
	
functionPrivilegeMap.remove("totalRecords");

%>
	<form  id="frmPolicyInclExclCoverage">	
	
	<%
	
	/*int start = 0 ;
	int end = 0 ;
	int i=1;
	
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter("to"));
	
	
	
	
	if ( from.length()== 0 )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
	if ( to.length()==0)
	  	end = 20 ;
	else
		end = Integer.parseInt( to ) ;*/
			
	%>
	
	<%
if ( !(from <= 1) )
	out.println("<A HREF='javascript:movePrevthis("+from+","+to+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if(totalRecords > to)
	out.println("<A id='nextvalue' HREF='javascript:moveNextthis("+from+","+to+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
	
	
      	<table class='grid' border='1' width='250%' cellpadding='3'  cellspacing=0 align="center" id='PayerTable'>
      	<div id="tableContainer">
      	<thead>  
      		<tr>
      			<td class='COLUMNHEADER' nowrap>S No</td>
      			<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Description.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>				
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ALLOWED_YN.label" bundle="${bl_labels}"/></td>
			 </tr>
			 <tr>
			 	<td nowrap><input type='button' id='apply_filter' name='apply_filter' value='Search' onclick='applyFilter()'>&nbsp;
			 		<input type='button' id='apply_filter' value='Reset' onclick='resetFilter()'>
			 	</td>
			 	<td nowrap>
			 		<input type='text' name='custGrpCode' id='custGrpCode'  size="20" value='<%=payerGroup %>' onblur="if(this.value!=''){ callCommonValidationQryCriteria(1,custGrpDesc,custGrpCode,1); } else{ fnClearCode(custGrpDesc); }">
				</td>
				<td nowrap>
					<input type='text' name='custGrpDesc' id='custGrpDesc'  size="40" value='<%=payerGroupDesc %>' onblur="if(this.value!=''){ callCommonValidationQryCriteria(1,custGrpDesc,custGrpCode,2); } else{ fnClearCode(custGrpCode); }">&nbsp;
					<input type='button' class='button' name="custGrpBtn" id="custGrpBtn" value='?'  onClick="callCommonValidationQryCriteria(1,custGrpDesc,custGrpCode,2);" tabindex='2'>
				</td>
				<td nowrap>
					<input type='text' name='custCode' id='custCode'  size="20" value='<%=payer %>' onblur="if(this.value!=''){ callCommonValidationQryCriteria(2,custDesc,custCode,1); } else{ fnClearCode(custDesc); }">				</td>
				<td nowrap>
					<input type='text' name='custDesc' id='custDesc' size="40" value='<%=payerDesc %>' onblur="if(this.value!=''){ callCommonValidationQryCriteria(2,custDesc,custCode,2); } else{ fnClearCode(custCode); }">&nbsp;
					<input type='button' class='button' name="custBtn" id="custBtn" value='?'  onClick="callCommonValidationQryCriteria(2,custDesc,custCode,2);" tabindex='2'>
				</td>
				<td nowrap>
					<input type='text' name='policyCode' id='policyCode' size="20" value='<%=policy %>' onblur="if(this.value!=''){ callCommonValidationQryCriteria(3,policyDesc,policyCode,1); } else{ fnClearCode(policyDesc); }">
				</td>
				<td nowrap>
					<input type='text' name='policyDesc' id='policyDesc'  size="40" value='<%=policyDesc %>' onblur="if(this.value!=''){ callCommonValidationQryCriteria(3,policyDesc,policyCode,2); } else{ fnClearCode(policyCode); }">&nbsp;
					<input type='button' class='button' name="policyBtn" id="policyBtn" value='?'  onClick="callCommonValidationQryCriteria(3,policyDesc,policyCode,2);" tabindex='2'>				</td> 
				<td nowrap>
					&nbsp;
				</td>
				<td nowrap>
					&nbsp;				
				</td>	
				<td nowrap>
					&nbsp;				
				</td>				
			 </tr>
			 </thead>
			 <TBODY>
			<%
			BLFunctionPrivilegeBean		bean = null;
			Iterator iterator= functionPrivilegeMap.keySet().iterator();
			int sNo = 0;
			while(iterator.hasNext())
			{
				
				int index =    (Integer)iterator.next();
				sNo = index+1;
				bean = (BLFunctionPrivilegeBean) functionPrivilegeMap.get(index);  
			%>	
			 <tr onclick='fnLoadPayerData("<%=index%>")'>
			 	<td nowrap class='fields'>
			 		<%=sNo %>
			 	</td>
			 	<td nowrap class='fields'>
					<span id="payer_group_code<%=index%>"	name="payer_group_code<%=index%>">    <%=checkForNull(bean.getCustGrpCode()) %></span>
				</td>
				<td nowrap class='fields'>
					<span id="payer_group_desc<%=index%>"	name="payer_group_desc<%=index%>">    <%=checkForNull(bean.getCustGrpDesc()) %></span>
				</td>
				<td nowrap class='fields'>
					<span id="payer_code<%=index%>"	name="payer_code<%=index%>">    <%=checkForNull(bean.getCustCode()) %></span>
				</td>
				<td nowrap class='fields'>
					<span id="payer_desc<%=index%>"	name="payer_desc<%=index%>">    <%=checkForNull(bean.getCustDesc()) %></span>
				</td>

				<td nowrap class='fields'>
					<span id="policy<%=index%>"	name="policy<%=index%>">    <%=checkForNull(bean.getPolicyCode()) %></span>
				</td>
				<td nowrap class='fields'>
					<span id="policy_desc<%=index%>"	name="policy_desc<%=index%>">    <%=checkForNull(bean.getPolicyDesc()) %></span>
				</td>
				<td nowrap class='fields'>
					<span id="eff_from<%=index%>"	name="eff_from<%=index%>">    <%=checkForNull(bean.getEffFromDate()) %></span>
				</td>
				<td nowrap class='fields'>
					<span id="eff_to<%=index%>"	name="eff_to<%=index%>">    <%=checkForNull(bean.getEffToDate()) %></span>
				</td>	
				<td nowrap class='fields'>
					<span id="allowableYn<%=index%>"	name="allowableYn<%=index%>">    <%=checkForNull(bean.getAllowable()) %></span>
				</td>			
			</tr>
			<%
			} %>
      	</table>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
		<input type='hidden' name='userType' id='userType' value='<%=userType %>'>
		<input type='hidden' name='userCode' id='userCode' value='<%=userCode %>'>
		<input type='hidden' name='functionId' id='functionId' value='<%=functionId %>'>
		<input type='hidden' name='privilegeCode' id='privilegeCode' value='<%=privilegeCode %>'>
		<input type='hidden' name='allowedYn' id='allowedYn' value='<%=allowedYn %>'>	
		<input type='hidden' name='effectiveDate' id='effectiveDate' value='<%=effectiveDate %>'>
		<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup %>'>
		<input type='hidden' name='payerGroupDesc' id='payerGroupDesc' value='<%=payerGroupDesc %>'>
		<input type='hidden' name='payer' id='payer' value='<%=payer %>'>
		<input type='hidden' name='payerDesc' id='payerDesc' value='<%=payerDesc %>'>
		<input type='hidden' name='policy' id='policy' value='<%=policy %>'>
		<input type='hidden' name='policyDescHdn' id='policyDescHdn' value='<%=policyDesc %>'>
		<input type='hidden' name='fromDate' id='fromDate' value='<%=fromDate %>'>
		<input type='hidden' name='toDate' id='toDate' value='<%=toDate %>'>

		<input type='hidden' name='queryString' id='queryString' value="<%=strQueryString%>">
		<input type='hidden' name='from' id='from' value="<%=from%>">
		<input type='hidden' name='to' id='to' value="<%=to%>">
		
     </form>
     <div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
</body>
</TBODY>	
	
	</div>
    <%!
     private String checkForNull(String inputString) {
 		if(inputString == null || "null".equals(inputString)){
 			inputString = "";
 		}
 		return inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
     %>
	 <div class='COLUMNHEADER' name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden; background-color:blue;'>
	 	<table id='tooltiptable' cellpadding="0" cellspacing=0 border-collapse=collapse  style='position:absolute;' width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

