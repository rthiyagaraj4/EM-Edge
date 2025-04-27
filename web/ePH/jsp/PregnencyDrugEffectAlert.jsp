<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");

	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/Prescription_1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.PregnencyEffect.label" bundle="${ph_labels}"/></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="pregnencyeffectform" id="pregnencyeffectform" >
<%
		String pregnency_cat			=	request.getParameter("pregnency_cat");
		String preg_effect			    =	request.getParameter("preg_effect");
		String preg_category_code	=	request.getParameter("preg_category_code");
		String pregnency_cat_desc		=	request.getParameter("pregnency_cat_desc");
		String preg_remarks			    =	request.getParameter("preg_remarks");
		String drug_desc                =   request.getParameter("drug_desc");
		String trimester                =   request.getParameter("trimester");
		String bean_id					= "@PrescriptionBean_1";
	    String bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		preg_effect=java.net.URLDecoder.decode(preg_effect,"UTF-8");//code added for IN040512
%>
		<table cellpadding=0 cellspacing=0 width="100%" align="" border="0">
			<tr>
				<th class="COLUMNHEADER" colspan="3" align='left'><fmt:message key="ePH.PregnencyEffect.label" bundle="${ph_labels}"/></th>
			<tr>
		<tr>
		<td colspan="2">&nbsp;</td></tr>
		<tr>
			<td class="label" rowspan='2' width='1px' align='right'><img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" name="preg_alert" value="" src="../../ePH/images/Pregnancy.bmp" height='20 ' width='20'></img>
			</td>
			<td width='*' colspan="2">&nbsp;<fmt:message key="ePH.PregnencyCategory.label" bundle="${ph_labels}"/>
			</td>
		</tr>
		<tr>
		   <td class="label" colspan="2">&nbsp;&nbsp;<label id="preg_cat"><b><%=pregnency_cat_desc%></b></label></td> 
		</tr>

		<tr><td colspan="3">&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			 <td class="label"colspan="2" style="padding:15px;"><%=drug_desc%></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td class="label" colspan="2">&nbsp;&nbsp;<b><fmt:message key="ePH.DrugEffectToPregnancy.label" bundle="${ph_labels}"/></b></td>
		</tr>

		<tr >
			<td>&nbsp;</td>
			 <td class="label"colspan="2" style="padding:15px;"><font color='red'><%=preg_effect%></font></td>
		 </tr>
		 <tr>
			<td>&nbsp;</td>
			<td class="label" colspan="2">&nbsp;&nbsp;<b><fmt:message key="ePH.PregnancyTrimester.label" bundle="${ph_labels}"/> = <%=trimester%></b></td>
		</tr>
		<tr><td colspan="3">&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td class="label" colspan="2">&nbsp;&nbsp;<font color='red'><b><fmt:message key="ePH.DrugRiskCategory.label" bundle="${ph_labels}"/> = <%=preg_category_code%></b></font></td>
		</tr>
		<tr><td colspan="3">&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td class="label" width='25%' style='vertical-align:top;padding:15px;'><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></td>
			<td class='label'><textarea size="200" name="preg_remarks" cols="45" rows="5" onKeyPress="return checkMaxLimit(this,200);" onblur ="return checkPregRemarksMaxLimit(this,200);"><%=preg_remarks%></textarea><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" ></td>
		 </tr>

		 <tr><td colspan="3">&nbsp;</td></tr>
		 <tr>
			 <td class="white" width="4%"  align='right' colspan='3' >
				<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savePregRemarks(document.pregnencyeffectform);">&nbsp;&nbsp;&nbsp;
				<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='window.close();'>
			</td>
		</tr>
		</table>
		</form>
	</body>
</html>

