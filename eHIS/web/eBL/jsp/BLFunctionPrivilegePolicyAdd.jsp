<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="eBL.BLFunctionPrivilegeBean"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>    
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!
private String checkForNull(String inputString) {
	return (inputString == null) ? "" : inputString;
}
%>
<%	request.setCharacterEncoding("UTF-8"); 
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String userType = checkForNull(request.getParameter("userType"));
	String userCode = checkForNull(request.getParameter("userCode"));
	String mode = checkForNull(request.getParameter("mode")); 
	String functionId = checkForNull(request.getParameter("functionId"));
	String privilegeCode = checkForNull(request.getParameter("privilegeCode"));
	String effectiveDate = checkForNull(request.getParameter("effectiveDate"));
	String allowedYn = checkForNull(request.getParameter("allowedYn"));
	String privilegeKey = facility_id+"~"+userType+"~"+userCode+"~"+functionId+"~"+privilegeCode;
	
	String beanId = "FunctionPrivilegeBean";
	String beanName = "eBL.BLFunctionPrivilegeBean";
	String readonly = "";
	String disabled = "";
	ArrayList<BLFunctionPrivilegeBean> payerList = null;
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	BLFunctionPrivilegeBean funcPrivilegeBean = null;
	HashMap<String,ArrayList<BLFunctionPrivilegeBean>> payerMap = null;
	try{
		con = ConnectionManager.getConnection(request);
		funcPrivilegeBean = (BLFunctionPrivilegeBean) getBeanObject(beanId, beanName, request);
		if(funcPrivilegeBean.getPayerDtlMap() == null){
			funcPrivilegeBean.setPayerDtlMap(new HashMap<String,ArrayList<BLFunctionPrivilegeBean>>());			
		}
		payerMap = funcPrivilegeBean.getPayerDtlMap();
		if(payerMap.containsKey(privilegeKey)){
			payerList = payerMap.get(privilegeKey);
		}
		/*if(payerList == null || payerList.isEmpty()){
			payerList = new ArrayList<BLFunctionPrivilegeBean>();
			payerList.add(new BLFunctionPrivilegeBean());
		}*/
	}
	catch(Exception e){
		System.err.println("Exception in BLFunctionPrivilegePolicyAdd->"+e);
	}
	finally{
		ConnectionManager.returnConnection(con);
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eBL/js/BLFunctionPrivilegePolicy.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<form name='frmPolicyAdd' id='frmPolicyAdd' action="">
		<table id='tblPayerDetails' name='tblPayerDetails' width='98%' align="center" class='grid' border='1'>
			<tr>
				<td class='COLUMNHEADER' width='26%' nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' width='26%' nowrap><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' width='26%' nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' width='9%' nowrap><fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' width='9%' nowrap><fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='4%' nowrap><fmt:message key="eBL.ALLOWED_YN.label" bundle="${bl_labels}"/></td>				
			</tr>
			<tr style="visibility: collapse;">
				<td class='fields' width='26%' nowrap>
					&nbsp;
				</td>
				<td class='fields' width='26%' nowrap>
					&nbsp;
				</td>
				<td class='fields' width='26%' nowrap>
					&nbsp;
				</td>
				<td class='fields' width='9%' nowrap>
					&nbsp;				
				</td>
				<td class='fields' width='9%' nowrap>
					&nbsp;				
				</td>
				<td class='fields' width='4%' nowrap>
					&nbsp;
				</td>
			</tr>
			<%
			if(!(payerList == null || payerList.isEmpty())){
				int tableIndex = 1;
				String checked = "";
			for (BLFunctionPrivilegeBean bean : payerList) {
				if("I".equals(bean.getStatus())){
					readonly = "";
					disabled = "";
				}
				else if("U".equals(bean.getStatus())){
					readonly = "readonly";
					disabled = "disabled";
				}
			%>
			 <tr rowValue='<%=tableIndex%>'>
				<td class='fields' width='26%' nowrap>
					<input type='text' name='custGrpCode_<%=tableIndex %>' id='custGrpCode_<%=tableIndex %>'  value='<%=checkForNull(bean.getCustGrpCode()) %>' size="15" onblur="if(this.value!=''){ callCommonValidation(1,custGrpDesc_<%=tableIndex %>,custGrpCode_<%=tableIndex %>,1,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>); } else{ fnClearCode(custGrpDesc_<%=tableIndex %>); }">&nbsp;
					<input type='text' name='custGrpDesc_<%=tableIndex %>' id='custGrpDesc_<%=tableIndex %>'  value='<%=checkForNull(bean.getCustGrpDesc()) %>' size="30" onblur="if(this.value!=''){ callCommonValidation(1,custGrpDesc_<%=tableIndex %>,custGrpCode_<%=tableIndex %>,2,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>); } else{ fnClearCode(custGrpCode_<%=tableIndex %>); }">&nbsp;
					<input type='button' class='button' name="custGrpBtn_<%=tableIndex %>" id="custGrpBtn_<%=tableIndex %>" value='?' <%=disabled %> onClick="callCommonValidation(1,custGrpCode_<%=tableIndex %>,custGrpDesc_<%=tableIndex %>,3,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>);" tabindex='2'>
				</td>
				<td class='fields' width='26%' nowrap>
					<input type='text' name='custCode_<%=tableIndex %>' id='custCode_<%=tableIndex %>'  value='<%=checkForNull(bean.getCustCode()) %>' size="15" onblur="if(this.value!=''){ callCommonValidation(2,custDesc_<%=tableIndex %>,custCode_<%=tableIndex %>,1,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>); } else{ fnClearCode(custDesc_<%=tableIndex %>); }">&nbsp;
					<input type='text' name='custDesc_<%=tableIndex %>' id='custDesc_<%=tableIndex %>'  value='<%=checkForNull(bean.getCustDesc()) %>' size="30" onblur="if(this.value!=''){ callCommonValidation(2,custDesc_<%=tableIndex %>,custCode_<%=tableIndex %>,2,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>); } else{ fnClearCode(custCode_<%=tableIndex %>); }">&nbsp;
					<input type='button' class='button' name="custBtn_<%=tableIndex %>" id="custBtn_<%=tableIndex %>" value='?' <%=disabled %> onClick="callCommonValidation(2,custDesc_<%=tableIndex %>,custCode_<%=tableIndex %>,3,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>);" tabindex='2'>
				</td>
				<td class='fields' width='26%' nowrap>
					<input type='text' name='policyCode_<%=tableIndex %>' id='policyCode_<%=tableIndex %>'  value='<%=checkForNull(bean.getPolicyCode()) %>' size="15" onblur="if(this.value!=''){ callCommonValidation(3,policyDesc_<%=tableIndex %>,policyCode_<%=tableIndex %>,1,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>); } else{ fnClearCode(policyDesc_<%=tableIndex %>); }">&nbsp;
					<input type='text' name='policyDesc_<%=tableIndex %>' id='policyDesc_<%=tableIndex %>'  value='<%=checkForNull(bean.getPolicyDesc()) %>' size="30" onblur="if(this.value!=''){ callCommonValidation(3,policyDesc_<%=tableIndex %>,policyCode_<%=tableIndex %>,2,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>); } else{ fnClearCode(policyCode_<%=tableIndex %>); }">&nbsp;
					<input type='button' class='button' name="policyBtn_<%=tableIndex %>" id="policyBtn_<%=tableIndex %>" value='?' <%=disabled %> onClick="callCommonValidation(3,policyDesc_<%=tableIndex %>,policyCode_<%=tableIndex %>,3,custGrpCode_<%=tableIndex %>,custCode_<%=tableIndex %>);" tabindex='2'>
				</td>
				<td class='fields' width='9%' nowrap>
					<input type="text" name='effFrom_<%=tableIndex %>' id='effFrom_<%=tableIndex %>'  value='<%=checkForNull(bean.getEffFromDate()) %>' size='6' onblur='isValidDate(this);checkDates(this,effTo_<%=tableIndex %>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_<%=tableIndex %>' onClick='return showCalendar("effFrom_<%=tableIndex %>")' />
				</td>
				<td class='fields' width='9%' nowrap>
					<input type="text" name='effTo_<%=tableIndex %>' id='effTo_<%=tableIndex %>'  value='<%=checkForNull(bean.getEffToDate()) %>' size='6' onblur='isValidDate(this);checkDates(effFrom_<%=tableIndex %>,this);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_<%=tableIndex %>' name='effTo_ctrl_<%=tableIndex %>' onClick='return showCalendar("effTo_<%=tableIndex %>")' />
				</td>
				<td class='fields' width='4%' nowrap>
					<%if("Y".equals(bean.getAllowable())){ 
						checked = "Checked";
					}
					else{
						checked = "";
					}
					%>
					<input type="checkbox" name='allowableYn_<%=tableIndex %>' id='allowableYn_<%=tableIndex %>'  <%=checked %>>
					<input type='hidden' name='status_<%=tableIndex %>' id='status_<%=tableIndex %>'  value='<%=checkForNull(bean.getStatus()) %>'>
				</td>
			</tr>
			<%if("U".equals(bean.getStatus())){ %>
				<script>makeFieldsDisable('<%=tableIndex %>');</script>
			<%
				}
			tableIndex++;
			}			
			}
			%>
		</table>
		<input type='hidden' name='locale' id='locale'  value='<%=locale%>'>
		<input type='hidden' name='facility_id'  value='<%=facility_id%>'>
		<input type='hidden' name='mode'  value='<%=mode %>'>
		
		<input type='hidden' name='userType' id='userType' value='<%=userType%>'>
		<input type='hidden' name='userCode' id='userCode' value='<%=userCode%>'>
		<input type='hidden' name='functionId' id='functionId' value='<%=functionId %>'>
		<input type='hidden' name='privilegeCode' id='privilegeCode' value='<%=privilegeCode%>'>
		<input type='hidden' name='effectiveDate' id='effectiveDate' value='<%=effectiveDate %>'>
		<input type='hidden' name='privilegeKey' id='privilegeKey' value='<%=privilegeKey %>'>
		<input type='hidden' name='allowedYn' id='allowedYn' value='<%=allowedYn %>'>		
		<input type='hidden' name='rowCount' id='rowCount' value=''>
	</form>
</body>
</html>

