<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/04/2017		IN063878			Badmavathi B					        		Unused variables
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" ePO.AmendPurchaseOrderDetailBean,ePO.AmendPurchaseOrderBean, ePO.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="ePO.OverrideWarning.label" bundle="${po_labels}"/></title>
	<%
		
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<script language="javascript" src="../../ePO/js/PoCommon.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
		
		String bean_id						=			"amendPurchaseOrderBean";
		String bean_name					=			"ePO.AmendPurchaseOrderBean";
		AmendPurchaseOrderBean bean				=			(AmendPurchaseOrderBean) getBeanObject(bean_id, bean_name,request );  
		bean.setLanguageId(locale);
		ArrayList alBudgetRecord1 = new ArrayList();
			String override_Budget = "";
					String balance_amt = "" ;
					HashMap amountHandler = (HashMap)bean.newOverride();
					System.out.println("amountHandler in override = "+ amountHandler);
					Iterator it = amountHandler.entrySet().iterator();
					while (it.hasNext()) {
					//	ArrayList alCommtRecord = new ArrayList(); Commented for unused variable IN063878
						ArrayList alBudgetRecord = new ArrayList();
						Map.Entry pairs = (Map.Entry)it.next();
						for (String retval: ((String)pairs.getKey()).split("-")){
							alBudgetRecord.add(retval); //COMMNT_CODE , DEPT_NO
						}
						String override_amt = (String)pairs.getValue();
						System.out.println("override_amt outside= "+ override_amt);
				
						 override_Budget = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_OVERRIDE"),alBudgetRecord).get("OVERRIDE_BUDGET");
						 System.out.println("override_Budget outside= "+override_Budget);
						 balance_amt = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_BALANCE"),alBudgetRecord).get("BALANCE_BDGT_AMT");
							System.out.println("balance_amt outside= "+balance_amt);
					
						
				
						if(Double.parseDouble(override_amt) > Double.parseDouble(balance_amt)){
							if(override_Budget.equals("W")){
							
								System.out.println("alBudgetRecord = "+alBudgetRecord);
								alBudgetRecord1.add(alBudgetRecord);
								//throw new Exception("OVERRIDE_WARNING");
							}else if(override_Budget.equals("E")){
								//throw new Exception("OVERRIDE_ERROR");
							}else if(override_Budget.equals("N")){
								//throw new Exception("OVERRIDE_NOTAPPLICABLE");
							}
						}
					}
					


%>



<body onLoad='document.getElementById("yes").focus();'>
<form name='ConfirmTransactionForm' id='ConfirmTransactionForm' method='post'>

	<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr>
		<td  colspan=2>
			<center> <h5> Budget Amount Exceeded! \n Commitment Code and Department ID = <%=alBudgetRecord1%></h5> </center>
		</td>
	</tr>
	<tr>
		<td colspan=2> 
			<center>
			<input type='button' class='button' name='yes' id='yes' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onClick='return clickYes();'> &nbsp;&nbsp;&nbsp;
			<input type='button' class='button' name='no' id='no' 
			value='  <fmt:message key="Common.cancel.label" bundle="${common_labels}"/>  '  onClick='return clickNo();'>
			</center>
		</td>
	</tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	</table>
</form>
</body>
</html>

