<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
		
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

	 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
	 <script language="JavaScript" src="../js/PhCommon.js"></script>
	 <script language="JavaScript" src="../js/ADRQuestion.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	

	String	mode							=		(request.getParameter( "mode" ) !=null ? (request.getParameter("mode").trim()):"" );
	String	ques_code						=		(request.getParameter( "ques_code" ) !=null ? (request.getParameter("ques_code").trim()):"" );
	String	ques_desc						=		(request.getParameter( "ques_desc" ) !=null ? (request.getParameter("ques_desc").trim()):"" );
	String	seq_no							=		(request.getParameter( "seq_no" ) !=null ? (request.getParameter("seq_no").trim()):"" );
	String	relative_score_yes				=		(request.getParameter( "relative_score_yes" ) !=null ? (request.getParameter("relative_score_yes").trim()):"" );
	String	relative_score_no				=		(request.getParameter( "relative_score_no" ) !=null ? (request.getParameter("relative_score_no").trim()):"" );
	String	relative_score_not_known		=		(request.getParameter( "relative_score_not_known" ) !=null ? (request.getParameter("relative_score_not_known").trim()):"" );
	String	eff_status						=		(request.getParameter( "eff_status" ) !=null ? (request.getParameter("eff_status").trim()):"E" );
	String  checked							=		"";
	
	
	
	String	codeDisabled					=		"";
	
	String	bean_id							=		"ADRQuestionBean" ;
	String	bean_name						=		"ePH.ADRQuestionBean";

	ADRQuestionBean bean					= (ADRQuestionBean)getBeanObject(bean_id,bean_name ,request);
	bean.setLanguageId(locale);
	bean.setMode(mode);
	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || 
	       mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.setEffStatus(eff_status);
		if(eff_status.equals("E"))
		{
				checked="Checked";
	
		}
	else
	{
		checked="";
	}
}

%>
<!-- <body onload='FocusFirstElement();'> -->
<body onMouseDown="" onKeyDown="lockKey()" onload='FocusFirstElement();'>

	<form name="formADRQuestionAddModify" id="formADRQuestionAddModify" onreset="FocusFirstElement()">
    <style>
		textarea {
		resize: none;
		}
	</style>
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
	<tr>
	<td width='100%'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align=center>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>

	<tr>
		<td  class="label"><fmt:message key="ePH.QuestionCode.label" bundle="${ph_labels}"/></td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td class="fields">&nbsp;&nbsp;
		<input type="text"  value="<%=ques_code%>" name="ques_code" size='4' maxLength='4' class='UPPER' oninput="this.value = this.value.toUpperCase()" onKeyPress="return CheckForSpecChars(event);" <%=codeDisabled%>  >
		<%}
		 else {%>

		<td class="fields">&nbsp;&nbsp;<input type="text"  value="" name="ques_code" id="ques_code" size='4' maxLength='4' class='UPPER' oninput="this.value = this.value.toUpperCase()" onKeyPress="return CheckForSpecChars(event);" <%=codeDisabled%>  >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
			<%}%>	
	</tr>

	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
	
		<td  class="label"><fmt:message key="ePH.QuestionDescription.label" bundle="${ph_labels}"/></td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td class="fields">&nbsp;&nbsp;<textarea rows="2" cols="30" maxLength="400"  size="400"   name="ques_desc" onBlur="checkMaxLength(ques_desc)" ><%=ques_desc%></textarea>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		<%}
		 else {%>

		<td class="fields">&nbsp;&nbsp;
		<textarea rows="2" cols="30" size="400" maxLength="400" name="ques_desc" id="ques_desc" onBlur="checkMaxLength(ques_desc)" ></textarea>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
			<%}%>	
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
<tr>
		<td  class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>

		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>

		<td class="fields">&nbsp;&nbsp;<input type="text"  value="<%=seq_no%>" name="seq_no" id="seq_no" size='4' maxLength='4' class='NUMBER' onBlur="checkSeqNo(seq_no);" onKeyPress="return CheckForSequence(event);"    ><img src="../../eCommon/images/mandatory.gif" align="center"></img>
		<%}
		 else {%>
		<td class="fields">&nbsp;&nbsp;<input type="text"  value="" name="seq_no" id="seq_no" size='3' maxLength='3' class='NUMBER' onBlur="checkSeqNo(seq_no);" onKeyPress="return CheckForSequence(event);"   >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
					<%}%>	
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><b><fmt:message key="ePH.RelativeScoresForResponse.label" bundle="${ph_labels}"/></b></td>
			<td>&nbsp;</td>
				
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></td>

		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>

		<td class="fields">&nbsp;&nbsp;
		
		<input type="text"  value="<%=relative_score_yes%>" name="relative_score_yes"  id="relative_score_yes" size='3' maxLength='3' class='NUMBER' onBlur="checkSign(relative_score_yes);" onKeyPress="return CheckForAlphabets(event);" >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		<%}
		 else {%>

		<td class="fields">&nbsp;&nbsp;
		
		<input type="text"  value="" name="relative_score_yes" id="relative_score_yes" size='3' maxLength='3' class='NUMBER' onBlur="checkSign(relative_score_yes);" onKeyPress="return CheckForAlphabets(event);"  >
		
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		</td>
				
					<%}%>	
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td class="fields">&nbsp;&nbsp;<input type="text"  value="<%=relative_score_no%>" name="relative_score_no"  id="relative_score_no"size='3' maxLength='3' class='NUMBER' onBlur="checkSign(relative_score_no);" onKeyPress="return CheckForAlphabets(event);"   >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		<%}
		 else {%>
		<td class="fields">&nbsp;&nbsp;<input type="text"  value="" name="relative_score_no" id="relative_score_no" size='3' maxLength='3'  class='NUMBER' onBlur="checkSign(relative_score_no);" onKeyPress="return CheckForAlphabets(event);"   >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
			<%}%>	
				
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="Common.NotKnown.label" bundle="${common_labels}"/></td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td class="fields">&nbsp;&nbsp;
		<input type="text"  value="<%=relative_score_not_known%>" name="relative_score_not_known" id="relative_score_not_known" size='3' maxLength='3' class='NUMBER'onBlur="checkSign(relative_score_not_known);" onKeyPress="return CheckForAlphabets(event);"   >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
		<%}
		 else {%>
		<td class="fields">&nbsp;&nbsp;<input type="text"  value="" name="relative_score_not_known" id="relative_score_not_known" size='3' maxLength='3' class='NUMBER'   onBlur="checkSign(relative_score_not_known);" onKeyPress="return CheckForAlphabets(event);" >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
				<%}%>		
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td class="fields">&nbsp;&nbsp;<input type="checkbox"  value="<%=bean.getEff_Status()%>" name="eff_status" id="eff_status" <%=checked%> onClick="check_Status(eff_status);"  >
		<%}
		 else {%>
		
			<td class="fields">&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" onClick="return check_Status(eff_status);"   checked>
			<%}%>		
		</td> 
	</tr>
	<tr>
		<td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
	
<input type="hidden" name="mode" id="mode"		value="<%=mode%>">	
<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">	
<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">	

	
	
</form>

</BODY>
</HTML>

