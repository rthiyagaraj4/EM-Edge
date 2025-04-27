<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*, javax.servlet.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>  -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script>
	<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/TrnDocType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String doc_type_code_list			=	"";
	String trn_type_list				=	"";
	String applicable_to_ph_yn_disabled	=	"";

	mode	= request.getParameter( "mode" ) ;
	bean_id = "trnDocTypeBean" ;
	bean_name = "eST.TrnDocTypeBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	TrnDocTypeBean bean = (TrnDocTypeBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

	bean.clear() ;
	
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
		doc_type_code_list	= bean.getDoc_type_code_List();
		trn_type_list		= bean.getTrn_type_List();
		applicable_to_ph_yn_disabled=bean.isModuleInstalled("PH")?applicable_to_ph_yn_disabled:"disabled";
	}
	else
		return;
%>
<body onLoad="FocusFirstElement();">
	<form name="formTrnDocType" id="formTrnDocType" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%'>
		<tr><td align='center' class='WHITE'>
		<table width='60%' border=1 cellpadding=1 cellspacing=0 align="center">
			<tr>
				<th><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ApplicabletoPharmacy.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.PrintAlertRequired.label" bundle="${st_labels}"/></th>
			</tr>
			<%
				int recCount=2;
				int cnt=0;
				String classvalue = "";
				for (cnt=0;cnt<10;cnt++,recCount++)	 {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
			%>
			<tr>	
				<td align='center' class='<%=classvalue%>' ><select name="doc_type_code_<%=cnt%>" id="doc_type_code_<%=cnt%>" onkeydown="resetColorCode(this);"onmousedown="resetColorCode(this)";><%=doc_type_code_list%></select></td>
				<td align='center' class='<%=classvalue%>'><select name="trn_type_<%=cnt%>" id="trn_type_<%=cnt%>" onkeydown="resetColorCode(this);"onmousedown="resetColorCode(this)"; onChange="checkPHListBox(this,<%=cnt%>);"><%=trn_type_list%></select></td>
				<td align='center' class='<%=classvalue%>'><input type='checkbox' name="applicable_to_ph_yn_<%=cnt%>" id="applicable_to_ph_yn_<%=cnt%>" value='Y' <%=applicable_to_ph_yn_disabled%> disabled></td>
				<td align="center" class='<%=classvalue%>'><input type='checkbox' name="print_alert_reqd_yn_<%=cnt%>" id="print_alert_reqd_yn_<%=cnt%>" value='N' onclick="printreqd(this);"></td>

			</tr>
			<%
				}
			%>
		</table>
		</td></tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="PHInstalled" id="PHInstalled" value="<%= bean.isModuleInstalled("PH")%>">
    <input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=cnt%>">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

