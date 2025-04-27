<!DOCTYPE html>

<%@ page   import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="alAckDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/SSAcknowledgment.js"></script>
		<script language="JavaScript">
		
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"AckDiscrepancyListBean";
		String bean_name			=		"eSS.AckDiscrepancyListBean";
		String disabled				=		"";
		String strButtonLegend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels"); 

		AckDiscrepancyListBean bean		=	(AckDiscrepancyListBean)getBeanObject( bean_id, bean_name,request );  
		bean.clear();
		bean.setLanguageId(locale);
		String index						=	bean.checkForNull(request.getParameter("index"),"-1");
		String called_from                  =   bean.checkForNull(request.getParameter("called_from"),"");

		if(!index.equals("-1")){
			disabled						=	"disabled";
			strButtonLegend					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels"); 
			bean.initialize((HashMap)alAckDiscrepancyList.get(Integer.parseInt(index)));
		}

	%>
	<body>
		<form name="formAckDiscrepancyDetail" id="formAckDiscrepancyDetail">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="eSS.Instrument.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<select name="item_code" id="item_code"<%=disabled%>>
						<%if(index.equals("-1")){%>
						<%=bean.getItem_code_List(-1)%>
						<%}else{%>
						<%=bean.getItem_code_List()%>
						<%}%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></td>
						<%if(index.equals("-1"))bean.setWrite_off_reason_code("");%>
						<td class="label">&nbsp;&nbsp;<select name="write_off_reason_code" id="write_off_reason_code" <%=disabled%>>
						<%if(index.equals("-1")){%>
						<%=bean.getWrite_off_reason_code_List(-1)%>
						<%}else{%>
						<%=bean.getWrite_off_reason_code_List()%>
						<%}%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="eSS.DiscrepancyQuantity.label" bundle="${ss_labels}"/></td>
						<td class="label" >&nbsp;&nbsp;<input type="text" name="discrepancy_qty" id="discrepancy_qty" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" maxlength = "<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this)" value="<%=index.equals("-1")?"":bean.getDiscrepancy_qty()%>">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td class="label" >&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="20" onKeyPress="return setTextAreaMaxLength(this, 200);"><%=index.equals("-1")?"":bean.getRemarks()%></textarea></td>
					</tr>
					<tr>
						<td align="right" class="label">Cost</td>
						<td class="label">&nbsp;&nbsp;<input type="text" name="discrepancy_cost" id="discrepancy_cost" disabled value="<%=index.equals("-1")?"":bean.getDiscrepancy_cost()%>"	></td>
					</tr>
					<tr>
						<td align="center" class="label" colspan='2'>
							<input type="button" value="<%=strButtonLegend%>" name="apply" class="BUTTON" onClick="return addToDiscrepancyList('<%=called_from%>');">&nbsp;
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" onClick="resetPackingDiscrepancyDetail('<%=called_from%>');">&nbsp;
							<input type="button" value=" Close " name="close" id="close" class="BUTTON" onClick='top.close();'>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="group_code" id="group_code"		value="<%=bean.getGroup_code()%>">
			<input type='hidden' name="tray_no" id="tray_no"			value="<%=bean.getTray_no()%>">
			<input type='hidden' name="index" id="index"			value="<%=index%>">
			<input type='hidden' name="function_id" id="function_id"		value="<%=request.getParameter("function_id")%>">
		</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

