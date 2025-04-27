 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
	 <script language="JavaScript" src="../js/ADRCertainity.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String Certainity_code			=		"";
	String System_Description		=		"";
	String user_desc				=		"";
	String rel_score_from			=		"";
	String rel_score_to				=		"";
	String disabled					=		"";
	String readOnly					=		"";

	String	mode					=		request.getParameter( "mode" ) ;
	String	bean_id					=		"ADRCertainityBean" ;
	String	bean_name				=		"ePH.ADRCertainityBean";
	String img_visible				=		"";
	
	
	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || 
	       mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;

	ADRCertainityBean bean = (ADRCertainityBean)getBeanObject(bean_id,bean_name ,request);
	bean.setLanguageId(locale);

	Certainity_code				=		request.getParameter("Certainity_code").trim();
	System_Description			=		request.getParameter("System_Description").trim();
	user_desc					=		request.getParameter("user_desc").trim();
	rel_score_from				=		request.getParameter("rel_score_from").trim();
	rel_score_to				=		request.getParameter("rel_score_to").trim();

	if(Certainity_code.equals("E"))
	{
		disabled		=	"disabled";
		img_visible		=	"visibility:hidden";
	}
	else
	{
		disabled		=	"";
		readOnly		=	"";
	}
%>
<body onMouseDown="" onKeyDown="lockKey()">
<form name="formADRCertainityModify" id="formADRCertainityModify"  >

<table cellpadding=0 cellspacing=0 width="85%" align="center">
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td   colspan="1"   class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CertainityCode.label" bundle="${ph_labels}"/></td>
				<td  class="label" value="<%=user_desc%>" ><%=Certainity_code%></td>
							
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td colspan="1" class="label">&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.SystemDescription.label" bundle="${common_labels}"/></td>
				<td  class="label" value="<%=user_desc%>"><%=System_Description%></td>
				
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td  colspan="1"  class="label">&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.UserDescription.label" bundle="${common_labels}"/></td>
				<td  >
					<input type="text" name="user_desc" id="user_desc" value="<%=user_desc%>" size="40" maxlength="40" onKeyPress = "return CheckForSpecChars(event);"  >
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>

				
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td  colspan="1" class="label">&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="ePH.RelativeScoreFrom.label" bundle="${ph_labels}"/></td>
				<td  >
					<input type="text" class="NUMBER" name="rel_score_from" id="rel_score_from" value="<%=rel_score_from%>" size="3" maxlength="3"  onBlur="checkSign(rel_score_from);" onKeyPress="return CheckForAlphabets(event);"<%=disabled%> <%=readOnly%>>
					<img src="../../eCommon/images/mandatory.gif" align="center" style="<%=img_visible%>"></img>
				</td>
				
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td  colspan="1" class="label">&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="ePH.RelativeScoreTo.label" bundle="${ph_labels}"/></td>
				<td  >
					<input type="text"  class="NUMBER" name="rel_score_to" id="rel_score_to" value="<%=rel_score_to%>" size="3" maxlength="3" onBlur="checkSign(rel_score_to);" onKeyPress="return CheckForAlphabets(event);" <%=disabled%> <%=readOnly%>>
					<img src="../../eCommon/images/mandatory.gif" align="center" style="<%=img_visible%>"></img>
				</td>
				
			</tr>

			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>

	</table>
	<input type="hidden" name="Certainity_code" id="Certainity_code"	        value="<%=Certainity_code%>">
	<input type="hidden" name="System_Description" id="System_Description"  	value="<%=System_Description%>">
	<input type="hidden" name="user_desc_hidden" id="user_desc_hidden"	    value="<%=user_desc%>">
	<input type="hidden" name="rel_score_from_hidden" id="rel_score_from_hidden"	value="<%=rel_score_from%>">
	<input type="hidden" name="rel_score_to_hidden" id="rel_score_to_hidden"	    value="<%=rel_score_to%>">
	<input type="hidden" name="mode" id="mode"		            value="<%=mode%>">	
	<input type="hidden" name="bean_id" id="bean_id"		            value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	            value="<%=bean_name%>">
	
	
</form>
<%	putObjectInBean(bean_id,bean,request);%>

</BODY>
</HTML>

