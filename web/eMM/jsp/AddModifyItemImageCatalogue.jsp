<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name			Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/04/2017		IN063878			Badmavathi B					        		Unused variables
---------------------------------------------------------------------------------------------------------
*/
%>
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
		String locale			=		(String)session.getAttribute("LOCALE");
//		String primary_lang		=		(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script> <!--  Vaild String -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script> <!-- Code arrest,Focue -->
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script> <!-- On key press,Uppercase -->
	<script language="JavaScript" src="../../eMM/js/ItemImageCatalogue.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement()" >
<%
	/* Mandatory checks start */
	String	mode			=		""		;
//	String	disabled		=		"",		checked			=	""; Commented for unused variables IN063878
	String	bean_id			=		"",		bean_name		=	"";
	/*  Commented for unused variables IN063878
	String	checked_ss_yn	=		"",		checked_st_yn	=	"";
	String	checked_po_yn	=		"",		codeReadOnly	=	"";
	String  disableST		=		"";
	 */
	String disabled_status	=		"";
	String	item_code	= (request.getParameter( "item_code" ) !=null ? (request.getParameter("item_code").trim()):"" );
	String	short_desc	= (request.getParameter( "short_desc" ) !=null ? (request.getParameter("short_desc").trim()):"" );
//	String	srl_no	= (request.getParameter( "srl_no" ) !=null ? (request.getParameter("srl_no").trim()):"" );	Commented for unused variable IN063878
	String	file_name	= (request.getParameter( "file_name" ) !=null ? (request.getParameter("file_name").trim()):"" );
	

	mode					=		request.getParameter( "mode" );
	bean_id					=		"itemImageCatalogueBean";
	bean_name				=		"eMM.ItemImageCatalogueBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ItemImageCatalogueBean bean		=		(ItemImageCatalogueBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;

	ServletContext context =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
	{
		disabled_status ="disabled";
		bean.setItem_code(request.getParameter("item_code"));
		bean.setSerial_no(request.getParameter("srl_no"));
		bean.setImgFileName(request.getParameter("file_name"));
	}
%>

<form name="formItemImageCatalogue" id="formItemImageCatalogue" >
<br><br><br><br><br>
<table cellpadding=0 cellspacing=0 width="75%"  align=center >
<tr>
	<td colspan="3">&nbsp;</td>
</tr>

<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;&nbsp;<input type='text' name="item_desc" id="item_desc"  maxLength='60' size='40' value="<%=short_desc%>" <%=disabled_status%> > <input type='button' class='BUTTON' name="item_search" id="item_search" value='?' onClick="searchItem(item_code,item_desc);" <%=disabled_status%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img> 
		<input type="hidden" name="item_code" id="item_code" value = "<%=item_code%>" ></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>

<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="eMM.ImageCatalogueFileName.label" bundle="${mm_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input type="text" name="file_name" id="file_name"  value="<%=file_name%>" size="40" maxlength="200" >&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>

</table>
	<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="SQL_MM_ITEM_LOOKUP_FOR_ITEM_IMAGE" id="SQL_MM_ITEM_LOOKUP_FOR_ITEM_IMAGE" value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_LOOKUP_FOR_ITEM_IMAGE")%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
</form>
<%
	putObjectInBean(bean_id,bean,request);
	
%>
</body>
</html>

