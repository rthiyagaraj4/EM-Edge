<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.ItemApproval.label" bundle="${st_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoDuoHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
    </script>
	
	</head>
<body >
<%
	String codeDisabled						=				"";
	String docNoDisabled					=				"";
	String disabled							=				"";
	String sys_date							=				"";

	String doc_dateDisabled					=				"";
	String item_classDisabled				=				"";
	String item_classDisable				=				"";
	String from_Store_1						=				"";
	String purchasetype						=				"";
	String documdate						=				"";
	String isAutoNo							=				 "No";
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String fromstorecode					=				request.getParameter("fromstorecode");
	String purchase_type						=				request.getParameter("purchase_type");
	String documentdate						=				request.getParameter("documentdate");
	String mode								=				request.getParameter("mode");
	String po_mode							=				request.getParameter("po_mode");
	
	//String function_id					=				request.getParameter("function_id");
	
	String default_value					=				"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	PurchaseOrderBean bean					=				(PurchaseOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	

	sys_date							=			bean.getSystemDate();


	

%>
<form name="formPOApproval" id="formPOApproval">
	<table border='0' cellpadding='2' cellspacing='0' width='102%' height='100%' align=center>
				<tr>
					<td  class="label"><fmt:message key="eST.ApprovedBy.label" bundle="${st_labels}"/></td>
					<td class="fields">&nbsp <input type="text" class="NUMBER" value="<%=bean.getLoginById()%>" name="approved_by" maxLength="8" size="8" disabled>
					</td>
					
					<td  class="label"><fmt:message key="eST.ApprovalDate.label" bundle="${st_labels}"/></td>
					<td class="fields">&nbsp <input type="text" class="NUMBER" value="<%=sys_date%>" name="approval_date" maxLength="8" size="8" disabled>
					</td>
					
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="eST.ApprovalRefNo.label"   bundle="${st_labels}"/></td>
					<td class="fields">&nbsp <input type="text" value="" name="aprvl_ref_no" id="aprvl_ref_no"  maxLength="20" size="20" ><%=bean.getImage("M")%></td>
					<td  colspan='6'  align="right"><input type="button" name="Close" id="Close" value= 'Close'  class="button" onClick="close_modal()">
					<td>&nbsp </td>

				</tr>
	</table>
	<input type="hidden" name=sys_date				value="<%=sys_date%>">
	<input type="hidden" name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
	<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">


	
</form>
<%
		putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

