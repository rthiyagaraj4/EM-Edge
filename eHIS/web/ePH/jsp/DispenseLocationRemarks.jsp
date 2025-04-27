<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*,java.util.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseLocation.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
    String	bean_id				= "DispenseLocationBean" ;
	String	bean_name			= "ePH.DispenseLocationBean";
	DispenseLocationBean bean		= (DispenseLocationBean)getBeanObject( bean_id, bean_name, request);
	
	String disp_locn_code = bean.checkForNull(request.getParameter("disp_locn_code"),"");
	String mode1 = bean.checkForNull(request.getParameter("mode1"),"");
	String SQL_PH_DISP_LOCN_SELECT11 =  PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT11");
		//if( mode1.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )))
	String  remarks_code		= bean.getRemarksCode()==null?"":bean.getRemarksCode();
	String	reason_desc			= bean.getReasonDesc()==null?"":bean.getReasonDesc();
	String	remarks_desc		=bean.getRemarksDesc()==null?"":bean.getRemarksDesc();

	
	ArrayList param_legends =new ArrayList();
	param_legends=(ArrayList)bean.getBMSRemarksDescription(disp_locn_code);
	if(remarks_code.equals("") && param_legends.size()!=0){
	remarks_code=(String)param_legends.get(0)==null?"":(String)param_legends.get(0);
	
	}
	if(reason_desc.equals("") && param_legends.size()!=0){
	reason_desc=java.net.URLDecoder.decode(java.net.URLEncoder.encode((String)param_legends.get(1)==null?"":(String)param_legends.get(1)));

	}
	if(remarks_desc.equals("") && param_legends.size()!=0)
	remarks_desc=java.net.URLDecoder.decode(java.net.URLEncoder.encode((String)param_legends.get(2)==null?"":(String)param_legends.get(2)));
	
	%>
     
</head>
<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </title>


<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"
>
<FORM name="formDispenseremarks" id="formDispenseremarks">
<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	<tr >
					<td  width="15%" class='label'> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					</td>	<td  width="60%"><input type='text' name='remarks' id='remarks' 
					size='54' maxlength='100'   readonly value='<%=reason_desc%>'>
					<input type="button" name="remarks_search" id="remarks_search" value="?" class="button" 
					onClick="searchReasonCode(remarks);">
					
					</td>
					<input type='hidden' value='' name='reason_code' id='reason_code'>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					</tr>

	<tr>
	<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td ><textarea rows="7" cols="60" name="remarks_desc" maxLength="500" readonly  style='resize:none'><%=remarks_desc%></textarea></td>
	
		

	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
</tr>
	<TR>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
		<td class='label' align='left'>
			<input type='Button' class='Button' name='Ok' id='Ok'  value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick='saveRemarks();' >
		</TD>
	</TR>
</table>
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%= locale %>">

	<INPUT TYPE="hidden" name="SQL_PH_DISP_LOCN_SELECT11" id="SQL_PH_DISP_LOCN_SELECT11" VALUE="<%= SQL_PH_DISP_LOCN_SELECT11 %>">
</form>
</body>

</html>
	
<% 

%>

