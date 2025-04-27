<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*, eST.Common.*"%>
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
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>  -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/TrnDocType.js"></script>
		<!-- <script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled =	"";
	String doc_type_code	=	"";
	String applicable_to_ph_yn_disabled	=	"";
	String applicable_to_ph_yn_disabled_not_sales	=	"";
    String print_alert_reqd_yn="";
	mode	= request.getParameter( "mode" ) ;
	bean_id = "trnDocTypeBean" ;
	bean_name = "eST.TrnDocTypeBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	TrnDocTypeBean bean = (TrnDocTypeBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
	bean.clear() ;
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		doc_type_code	=	request.getParameter( "doc_type_code" ) ;
		if (doc_type_code == null ) {
			return;		
		}
		bean.setDoc_type_code(doc_type_code,0) ;
		bean.loadData();
		applicable_to_ph_yn_disabled=bean.isModuleInstalled("PH")?applicable_to_ph_yn_disabled:"disabled";

		if (!(bean.getTrn_type(0).equals("SAL")||bean.getTrn_type(0).equals("SRT"))) {
			applicable_to_ph_yn_disabled_not_sales="disabled";
		}

	}
	print_alert_reqd_yn=bean.getPrint_alert_reqd_yn(0);
	String print_app;
if((bean.getTrn_type(0).equals("PRQ"))||(bean.getTrn_type(0).equals("SPB"))||(bean.getTrn_type(0).equals("CBL")))
print_app="disabled";
else
print_app="";



%>
<body onLoad="FocusFirstElement();">
	<form name="formTrnDocType" id="formTrnDocType" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%'>
		<tr><td align='center' class='WHITE'>
		<table width='60%' cellpadding=5 cellspacing=0 align="center">
			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr>	
					<td align='right' class='label'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="doc_type_code_0" id="doc_type_code_0" <%=codeDisabled%>>
							<%=bean.getDoc_type_code_List()%>
						</select><%=bean.getImage("M")%>
					</td>
			</tr>

			<tr>	
					<td align='right' class='label'><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="trn_type_0" id="trn_type_0" <%=codeDisabled%>>
							<%=bean.getTrn_type_List()%>
						</select><%=bean.getImage("M")%>
					</td>
			</tr>
			<tr>	
					<td align='right' class='label'><fmt:message key="eST.ApplicabletoPharmacy.label" bundle="${st_labels}"/></td>
					<td>&nbsp;<input type='checkbox' name="applicable_to_ph_yn_0" id="applicable_to_ph_yn_0" value='Y' <%=applicable_to_ph_yn_disabled_not_sales%> <%=applicable_to_ph_yn_disabled%> <%=bean.getChecked(bean.getApplicable_to_ph_yn(0))%>>
					</td>
			</tr>

			<tr>	
					<td align='right' class='label'><fmt:message key="eST.PrintAlertRequired.label" bundle="${st_labels}"/></td>
					<%if(print_alert_reqd_yn.equals("Y")	){	%>
					<td>&nbsp;<input type='checkbox' name="print_alert_reqd_yn_0" id="print_alert_reqd_yn_0" value='<%=print_alert_reqd_yn%>' 
					checked onclick="printreqd(this);" <%=print_app%>></td>
					<%}
					else
						{%>
                    <td>&nbsp;<input type='checkbox' name="print_alert_reqd_yn_0" id="print_alert_reqd_yn_0" value='<%=print_alert_reqd_yn%>' onclick="printreqd(this);" <%=print_app%>></td>
						<%}%>
			</tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
		    </table>
		    </td></tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
    <input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

