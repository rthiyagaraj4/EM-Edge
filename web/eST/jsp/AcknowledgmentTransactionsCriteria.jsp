<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
15/07/2021	TFS:21516		Shazana										MOHE-CRF-0084.1-US014
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page  contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*"%> 
<%@ page  contentType="text/html;charset=UTF-8"%> <!-- Added by Sakti against TTM-SCF-0043 [IN:044469]-->  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id  =  (String) session.getValue( "facility_id" ) ;////MOHE-CRF-0084.1 
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );

		boolean restrict_stores_user_access_yn =false;//Added for TFS id:20203 
		String user_name				=		(String) session.getValue( "login_user" ) ;//MOHE-CRF-0084.1 
	    String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		 try{
				con						= ConnectionManager.getConnection(request);
			    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
		    }
		 catch (Exception exp){
			 exp.printStackTrace();
		
		 }
		    finally{ 
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    }
		 strFacilityParam = bean.getRestrictUserAccessStore();
		
			if(strFacilityParam== null || strFacilityParam.equals(""))
				strFacilityParam = "N"; 
			if(restrict_stores_user_access_yn){
				if(strFacilityParam.equals("Y")){
					restrictInReportYN = "Y";
				}else{
					restrictInReportYN = "N"; 
				}
			}//END 
		
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/AcknowledgmentTransactions.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
			menu_id		= "<%= request.getParameter( "menu_id" ) %>"
			module_id	= "<%= request.getParameter( "module_id" ) %>"
		</script>
	</head>
	<body>
		<form name="formAcknowledgmentTransactionsCriteria" id="formAcknowledgmentTransactionsCriteria" action="../../eST/jsp/AcknowledgmentTransactionsResult.jsp" target="frameAcknowledgementTransactionsResult" method="post"  onReset='FocusFirstElement();'>
			<table border = 0 cellpadding="0" cellspacing= "3" width="100%">
				<tr>
					<td  class="label"><fmt:message key="eST.AcknowledgeDateFrom.label" bundle="${st_labels}"/>&nbsp;</td>
					<td class="fields">
						<input type="text" name="ack_from_date" id="ack_from_date" size="10" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>" maxlength="10" onBlur="CheckDate(this);">
						<img src="../../eCommon/images/CommonCalendar.gif" onmouseover="changeCursor(this);" onClick="return showCalendar('ack_from_date');"></img>
					</td>
					<td  class="label"><fmt:message key="eST.AcknowledgeDateTo.label" bundle="${st_labels}"/> &nbsp;</td>
					<td class="fields">
						<input type="text" name="ack_to_date" id="ack_to_date" size="10" maxlength="10" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>" onBlur="CheckDate(this);">
						<img src="../../eCommon/images/CommonCalendar.gif" onmouseover="changeCursor(this);" onClick="return showCalendar('ack_to_date');"></img>
					</td>
					<td class="label"> <fmt:message key="eST.DrugNonDrug.label" bundle="${st_labels}"/> &nbsp;</td>
					<td class="fields">
						<select name="drug_non_drug" id="drug_non_drug">
							<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
							<option value="D"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="eST.NonDrug.label" bundle="${st_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label">
						<fmt:message key="Common.ItemCodeFrom.label" bundle="${common_labels}"/>&nbsp; 
					</td>
					<td class="fields">
						<input type='text' size='20'  maxlength='21' name='item_code_from' id='item_code_from'  value=""   >&nbsp;<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchItemCode(item_code_from);" >
					</td>
					<td class="label">
						<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td class="fields">
						<input type='text' size='20'  maxlength='21' name='item_code_to' id='item_code_to'  value="">&nbsp;<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchItemCode(item_code_to);" >
					</td>
					<td class="label"> <fmt:message key="eST.RejectQty.label" bundle="${st_labels}"/> &nbsp;</td>
					<td class="fields">
						<select name="rej_qty" id="rej_qty">
							<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
							<option value="Z"><fmt:message key="eST.Zero.label" bundle="${st_labels}"/></option>
							<option value="N"><fmt:message key="eST.NonZero.label" bundle="${st_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eST.IssuingStore.label" bundle="${st_labels}"/>&nbsp;
					</td>
					<td class="fields">
					<%if(restrict_stores_user_access_yn){ %><!-- MOHE-CRF-0084.1 START -->
						<input type='text' size='20'  maxlength='21' name='issue_store_code' id='issue_store_code'  value="" >&nbsp;<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchStoreCode1(issue_store_code);" >
						<%}else{ %>
					<input type='text' size='20'  maxlength='21' name='issue_store_code' id='issue_store_code'  value="" >&nbsp;<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchStoreCode(issue_store_code);" >
					<% } %>
						
					</td>
					<td class="label"><fmt:message key="Common.ReceivingStore.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td class="fields">
					<%if(restrict_stores_user_access_yn){ %>
						<input type='text' size='20'  maxlength='21' name='receiving_store_code' id='receiving_store_code'  value="">&nbsp;<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchStoreCode1(receiving_store_code);" >
						<%}else{ %>
					<input type='text' size='20'  maxlength='21' name='receiving_store_code' id='receiving_store_code'  value="">&nbsp;<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchStoreCode(receiving_store_code);" >
					<% } %> <!-- END -->
						
					</td>
					<td class="fields">&nbsp;
						<input class='button' type='button' name='searchItem' id='searchItem' value='Search' onclick="showResultPage();">
					</td>
					<td class="label">&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>"><!-- MOHE-CRF-0084.1 start-->
			<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"			value="<%=strFacilityParam%>"><!-- MOHE-CRF-0084.1 END-->
			<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=facility_id%>"><!-- end -->
		</form>
	</body>
</html>

