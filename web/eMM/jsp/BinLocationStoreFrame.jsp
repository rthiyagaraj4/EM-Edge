<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script> -->
	<script language="JavaScript" src="../js/BinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();' >
<%
	/* Mandatory checks start */
	String disabled				=	"" ;
	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"BinLocationBean";
	String bean_name			=	"eMM.BinLocationBean";
	String store_code			=	"";	

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	BinLocationBean bean = (BinLocationBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.clear() ;
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	
	/* Initialize Function specific end */

%>
		
<form name="formBinLocation_store" id="formBinLocation_store" >
<br>

<table cellpadding=0 cellspacing=0 width="90%" align=center>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label" width='35%'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	<td  class=fields  colspan="2">&nbsp;&nbsp;<select name="store_code" id="store_code" <%=disabled%>><option value="">&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
	<%
	
	ArrayList	arrStore		=	null;
	HashMap		hmStore			=	null;	
	String code = "",	desc		=	"";
	String store_select				=	"";

	arrStore		=	bean.getStoreList();
	int arrLength	=	arrStore.size();
	for(int i=0;i<arrLength; i++)
	{
		hmStore      		=	(HashMap) arrStore.get(i);

		code				=	(String)hmStore.get("code");
		desc				=	(String)hmStore.get("desc");
		if(code.trim().equals(store_code.trim()))
		{
			store_select	=	"Selected";
		}
		else
			store_select	=	"";

		%>
			<option value="<%=code%>" <%=store_select%> ><%=desc%></option>
		<%
	}
	%>
	</select><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
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

