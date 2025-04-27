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
	<script language="JavaScript" src="../js/MmCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/MmMessages.js"></script> -->
	<script language="JavaScript" src="../js/BinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad="FocusFirstElement()" >

<%
	/* Mandatory checks start */
//	String codeReadOnly			=	"" ;
//	String readOnly				=	"" ;
	String disabled				=	"" ;
	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"binLocationBean";
	String bean_name			=	"eMM.BinLocationBean";
	String store_code			=	"";	

	if ( mode == null || mode.equals("") ) 
		return;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
			return;
	/* Mandatory checks end */

	
	/* Initialize Function specific start */
	BinLocationBean bean = (BinLocationBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);

	bean.clear() ;
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	
	/* Initialize Function specific end */
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
	{
		
		String binlocation_code		=	request.getParameter( "binlocation_code" ) ;
//		String long_desc			=	request.getParameter( "long_desc" ) ;
//		String short_desc			=	request.getParameter( "short_desc" ) ;
		store_code					=	request.getParameter( "store_code" ) ;
//		String eff_status			=	request.getParameter( "eff_status" ) ;
		
		bean.setCode(0,binlocation_code.trim());
		bean.setStoreCode(store_code) ;

		
		bean.loadData() ;
		if(bean.getEff_status(0).equals("D"))
				disabled = "disabled" ;
		bean.getStoreList() ;
//		codeReadOnly ="readonly" ;

	}
%>
<form name="formBinLocation" id="formBinLocation" >		
<br><br><br><br><br>

<table cellpadding=0 cellspacing=0 width="90%" align=center >
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
	<td   class=fields colspan="2">&nbsp;&nbsp;<select name="store_code" id="store_code" disabled ><option value="">&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
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
		if(code.trim().equals(bean.getStoreCode().trim()))
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
<tr>
	<th colspan="3" ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.BinLocationCode.label" bundle="${mm_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="code_0" id="code_0" value="<%= bean.getCode(0) %>" size="10" maxlength="10" disabled>
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class=fields   colspan="2">&nbsp;&nbsp;<input type="text" name="long_desc_0" id="long_desc_0" value="<%=bean.getLong_desc(0)%>" size="30" maxlength="30" <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="short_desc_0" id="short_desc_0" value="<%= bean.getShort_desc(0) %>" size="15" maxlength="15" onBlur="makeValidString( this ) ;"  <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;<input type="checkbox" name="eff_status_0" id="eff_status_0" <%=(bean.getEff_status(0)).equals("E")?"checked":"" %> value="E" ></td>
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

