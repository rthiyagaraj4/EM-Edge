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
		String locale			=		(String)session.getAttribute("LOCALE");
//		String primary_lang		=		(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script> <!--  Vaild String -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script> <!-- Code arrest,Focue -->
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- On key press,Uppercase -->
</head>
<body onLoad="FocusFirstElement()" >
<%
	/* Mandatory checks start */
	String	mode			=		""		;
	String	disabled		=		"",		checked			=	"";
	String	bean_id			=		"",		bean_name		=	"";
	String	checked_ss_yn	=		"",		checked_st_yn	=	"";
	String	checked_po_yn	=		"",		codeReadOnly	=	"";
	String  disableST		=		"";

	mode					=		request.getParameter( "mode" );
	bean_id					=		"itemClassBean";
	bean_name				=		"eMM.ItemClassBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ItemClassBean bean		=		(ItemClassBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;

	ServletContext context =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
	{
		bean.setMasterCode(request.getParameter("item_class_code"));
		bean.loadData() ;

		bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_MODIFY"), MmRepository.getMmKeyValue("SQL_MM_ITEM_CLASS_UPDATE"));
		//disabled			=	" disabled " ;
		if(bean.getEffStatus().equals("E"))
		{
			checked			=	" CHECKED ";
		}
		else
		{
			checked			=	"";
			//readOnly		=	" readOnly " ;
			disabled		=	" disabled ";
		}
		String instl		=	bean.getStInstalled();
		codeReadOnly		=	" readOnly ";

		if(bean.getApplSsYn().equals("Y"))
			checked_ss_yn	=	" CHECKED ";

		if(bean.getApplStYn().equals("Y"))
			checked_st_yn	=	" CHECKED ";

		if(bean.getApplPoYn().equals("Y"))
			checked_po_yn	=	" CHECKED ";

		if(instl.equals("N")){
			//checked_st_yn	=	"";
			disableST		=	"disabled";
		}
	}
	else
	{
		bean.setSQLOperation(CommonRepository.getCommonKeyValue( "MODE_INSERT"), MmRepository.getMmKeyValue( "SQL_MM_ITEM_CLASS_INSERT"));
		String instl	=	bean.getStInstalled();
		//System.out.println("instl================>"+instl);
		checked			=	" CHECKED ";
		checked_ss_yn	=	" CHECKED ";
		checked_st_yn	=	" CHECKED ";
		checked_po_yn	=	" CHECKED ";
		if(instl.equals("N")){
			//checked_st_yn	=	"";
			disableST		=	"disabled";
		}
	}
%>

<form name="formItemClass" id="formItemClass" >
<br><br><br><br><br>
<table cellpadding=0 cellspacing=0 width="75%"  id="t1" align=center >
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label" width='35%' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;&nbsp;<input class='UPPER' type="text" name="item_class_code" id="item_class_code" value="<%=bean.getMasterCode()%>" size="4" maxlength="4" <%=codeReadOnly%> <%=disabled%> onKeyPress="return CheckForSpecChars(event)" onBlur="convertToUpperCase(this);checkSpecialChars(this);">
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" value="<%=bean.getLongDesc()%>" size="40" maxlength="40" onBlur="makeValidString( this ) ;" <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class=fields  colspan="2">&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" value="<%=bean.getShortDesc()%>" size="15" maxlength="15" onBlur="makeValidString( this ) ;"  <%=disabled%> >
	<img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class=fields colspan="2">&nbsp;<input type="checkbox" name="eff_status" id="eff_status" <%=checked%> value="E" ></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<%
	ArrayList	arrModuleList	=	null;
	arrModuleList				=	bean.getModuleList();
	int arrLength				=	arrModuleList.size();
	if(arrLength>0)
	{
		%>
			<table cellpadding=0  cellspacing=0 width="75%"   id ="t" align=center>
				<tr>
					<th colspan="3" ><fmt:message key="eMM.ModuleApplicability.label" bundle="${mm_labels}"/></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
		<%
		for(int i=0;i<arrLength; i++)
		{
			if( ((String)arrModuleList.get(i)).equals("ST") )
			{
			%>
				<tr>
					<td  class="label" ><fmt:message key="eMM.InventoryManagement.label" bundle="${mm_labels}"/>
					<td class=fields  colspan="2">&nbsp;<input type="checkbox" name="appl_st_yn" id="appl_st_yn" <%=checked_st_yn%> value="Y" <%=disabled%> ></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
			<%
			}
			else if( ((String)arrModuleList.get(i)).equals("SS") )
			{
			%>
				<tr >
					<td  class="label" width='35%' ><fmt:message key="eMM.SterileStock.label" bundle="${mm_labels}"/></td>
					<td class=fields  colspan="2">&nbsp;<input type="checkbox" name="appl_ss_yn" id="appl_ss_yn" <%=checked_ss_yn%> value="Y"  <%=disabled%>></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
		<%
			}

			else if( ((String)arrModuleList.get(i)).equals("PO") )
			{
			%>
				<tr>
					<td  class="label"><fmt:message key="eMM.PurchaseControl.label" bundle="${mm_labels}"/></td>
					<td class=fields  colspan="2">&nbsp;<input type="checkbox" name="appl_po_yn" id="appl_po_yn" <%=checked_po_yn%> value="Y"  <%=disabled%>></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
			<%
			}
		}
	}
	else
	{
%>
		<input type="hidden" name="appl_st_yn" id="appl_st_yn" value="">
		<input type="hidden" name="appl_po_yn" id="appl_po_yn" value="">
		<input type="hidden" name="appl_ss_yn" id="appl_ss_yn" value="">
<%	}
%>
</table>
	<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

