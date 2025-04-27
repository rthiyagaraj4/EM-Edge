<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.LoanReturnGroupBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eSS/js/LoanReturnGroup.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<title>Reason For Return</title>
	</head>
<%
		String remarks		=	(String)request.getParameter("remarks")==null?"":(String)request.getParameter("remarks");	
		String visibility	=	(String)request.getParameter("remarks_gif")==null?"visibility:hidden":(String)request.getParameter("remarks_gif");
		String entry_completed_yn =	(String)request.getParameter("entry_completed_yn")==null?"":(String)request.getParameter("entry_completed_yn");
		String function_id		=	(String)request.getParameter("function_id")==null?"":(String)request.getParameter("function_id");	
		
		String readonly = "";
		String disabled = "";

		if(entry_completed_yn.equals("Y") || function_id.equals("LOAN_ACKNOWLEDGE")) {
				disabled = "disabled";
				readonly = "readonly";
		}
	
	%>
<body onload='FocusFirstElement();'>
	<form name= "formLoanReturnGroupRemarks"> 
	
		<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/></td>
		<td class='fields'>	&nbsp;&nbsp;<textarea name="remarks" rows="5" cols="40" <%=readonly%>><%=remarks%></textarea>	
			<input type="hidden" name="remarks_code" id="remarks_code" value="">
			<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code,remarks);" <%=disabled%>>
			<img id="img_remarks"  src="../../eCommon/images/mandatory.gif" style="<%=visibility%>" />
			</td>
	  </tr>
	  <tr>
	  <td colspan=2>&nbsp;</td>
		<td align=center><input type="button" align='center' class="button" name="close" id="close" value=" Ok " onClick="updateRemarks('<%=visibility%>')"></td>
	  </tr>	  
	</table>
			<input type="hidden" name="language_id" id="language_id"								value="<%=locale%>">
			<input type="hidden" name="SQL_SS_TRN_REMARKS_LOOKUP_SELECT" id="SQL_SS_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_REMARKS_LOOKUP_SELECT")%>">
		</form>
	</body>
</html>

