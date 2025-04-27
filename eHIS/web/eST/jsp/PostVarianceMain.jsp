<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="a1" scope="page"  class="eST.PostVarianceBean"/>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="javascript" src="../../eST/js/PostVariance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//pmd 29/01/05	
//String params = request.getQueryString() ;
	String mode = request.getParameter("mode");

	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	mode = mode.trim();
//	java.util.HashMap defaultParameter = null;
	String bean_id = "postVarianceBean";
	String bean_name = "eST.PostVarianceBean";
//	String doc_type_code = request.getParameter("doc_type_code");
//	String doc_no = request.getParameter("doc_no");

	PostVarianceBean bean = (PostVarianceBean) getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.clear();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String disabled = "";
//	String readonly = "";

//	String facility_id = (String) session.getValue("facility_id");	
	boolean editMode = false;	
	//defaultParameter = bean.getSSParameter();
	//String default_doc_type_code = (String)defaultParameter.get("DEF_VAR_DOC_TYPE_CODE");
	//String default_write_off_reason_code = (String)defaultParameter.get("DEF_WRITE_OFF_REASON_CODE");
	//bean.setDefaultDocType(default_doc_type_code);
	//bean.setDefaultWriteOffReasonCode(default_write_off_reason_code);
%>
<body onload='FocusFirstElement();' >
	<form name="formPostVariance" id="formPostVariance" onReset='FocusFirstElement();'>
			<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
			<tr>
			<td width='100%'  class="WHITE">
				<table cellspacing=0 cellpadding=1 width="55%"  border=0 align=center>
				  <tr>
					<td width="40%">&nbsp;</td>
					<td>&nbsp;</td>
				 </tr>
				  <tr>
					<td class=label ><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;<select name="phy_inv_id" id="phy_inv_id" onblur=""> <%=bean.getPhyInvIDs()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" ></td>
				  </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <tr>
					<td class=label ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;<select name="doc_type_code" id="doc_type_code"  <%=editMode?disabled:""%>><%=bean.getDocTypes()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" ></td>
				  </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr>
				  <!-- <tr>
					 
					<td class=label align=right>Doc No</td>
					<td class=label>&nbsp;<input CLASS="NUMBER" maxLength=8 size=8 name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" disabled value="<%=bean.getDoc_no()%>" onBlur="return checkIntegerFormat(this);">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center ></td>
					</tr> -->
				  <!-- <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				  </tr> -->
				  <tr>
					<td class=label ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<!-- onBlur="CheckDate(this);" -->
					<td class=fields>&nbsp;<input type="text" maxLength=10 size=10 name="doc_date" id="doc_date" value= "<%=com.ehis.util.DateUtils.convertDate((String)bean.getDoc_date(),"DMY","en",locale)%>" onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"  ></img>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" ></td>
				 </tr>
				  <tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				 </tr>
				 
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="facility_id" id="facility_id" value="<%=bean.getLoginFacilityId() %>">
			<input type='hidden' name="autono_yn" id="autono_yn" value="No">
			<input type='hidden' name="trn_type" id="trn_type" value="VAR">
			<input type='hidden' name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

