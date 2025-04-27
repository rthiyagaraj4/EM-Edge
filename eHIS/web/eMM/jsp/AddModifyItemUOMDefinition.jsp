<!DOCTYPE html>
<%@ page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String  locale			= (String)session.getAttribute("LOCALE");
//	String  primary_lang	= (String)session.getAttribute("PRIMARY_LANG");
	String  sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String  checked			=	"";
%>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src='../../eCommon/js/common.js' ></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eMM/js/ItemUOMDefinition.js"></script>
</head>

<body onLoad = "defaultOne('N');FocusFirstElement();" OnMouseDown='CodeArrest()'>

<%	
	String mode				=	"";
	String bean_id			=	"";
	String bean_name		=	"";

	mode	= request.getParameter( "mode" ) ;
	String	item_code	= (request.getParameter( "item_code" ) !=null ? (request.getParameter("item_code").trim()):"" );
	String	item_desc	= (request.getParameter( "item_desc" ) !=null ? (request.getParameter("item_desc").trim()):"" );
	String	uom_code	= (request.getParameter( "uom_code" )  !=null ? (request.getParameter("uom_code").trim()):"" );
	String	uom_desc	= (request.getParameter( "uom_desc" )  !=null ? (request.getParameter("uom_desc").trim()):"" );
	String	equom_code	= (request.getParameter( "equom_code" )!=null ? (request.getParameter("equom_code").trim()):"" );
	String	conversion	= (request.getParameter( "conversion" )!=null ? (request.getParameter("conversion").trim()):"" );
	String	eff_status	= (request.getParameter( "eff_status" )!=null ? (request.getParameter("eff_status").trim()):"E" );
	
	String	disabled_status	 = "";
	String chked			 = "";
	String	equom_qty	= "";
	bean_id					 = "ItemUOMDefinition" ;
	bean_name				 = "eMM.ItemUOMDefinition";

	
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) ) {
		return ;
	}
	
	ItemUOMDefinition bean = (ItemUOMDefinition)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
	{
		//bean.setItem_desc(item_desc);
		//bean.setUOM_code(uom_code);
		//bean.setEquiUOM_code(equom_code);
		//bean.setConversion(conversion);
		//bean.setEff_Status(eff_status);
		bean.loadData(item_code,uom_code,equom_code);
		disabled_status ="disabled";
		conversion=bean.getConversion();
		eff_status=bean.getEff_Status();
		equom_qty =bean.getEqUOMQty();
	}
	if(((String)eff_status).equals("E"))
	{	chked = "checked";

	}
%>

	<form name='ItemUOM_form' id='ItemUOM_form'  method='post' target='messageFrame'>
	<br><br><br><br><br><br><br><br><br>
	<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
	<tr>
		<td class='label' colspan = "4">&nbsp;</td>
	</tr> 	
	
	<tr>
		<td class='label'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class= 'fields' colspan="3"><input type='text' name="item_desc" id="item_desc"  maxLength='60' size='40' value="<%=item_desc%>" <%=disabled_status%> > <input type='button' class='BUTTON' name="item_search" id="item_search" value='?' onClick="searchItem(item_code,item_desc);" <%=disabled_status%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" ></img> 
		<input type="hidden" name="item_code" id="item_code" value = "<%=item_code%>" >
		</td> 	
	</tr>
	
	<tr>
		<td class='label' colspan="4">&nbsp;</td>
	</tr>
	
	<tr>
		<td class='label'><fmt:message key="eST.BaseUOMQuantity.label" bundle="${st_labels}"/></td>
		<%if(((String)eff_status).equals("D")) {%>
		<td class='label'><input type='text' name='conversion' id='conversion' size='15' maxlength='6' value="<%=conversion%>" <%=disabled_status%> style='text-align:right'  onKeyPress='return allowValidNumber(this,event,6,0)' onblur="checkIntegerFormat(this);" >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>&nbsp;</td>
		<%}
		 else  {%>
		<td class='label'><input type='text' name='conversion' id='conversion' size='15' maxlength='6' value="<%=conversion%>" style='text-align:right'  onKeyPress='return allowValidNumber(this,event,6,0)' onblur="checkIntegerFormat(this);" >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>&nbsp;</td>
		<%}%>
		<td class='label' style="text-align:right"><fmt:message key="eST.BaseUOMCode.label" bundle="${st_labels}"/></td>
		<td class='label'><input type=text name='uom_desc' id='uom_desc' value='<%=uom_desc%>' disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	</tr>

	<!--<tr>
		<td class='label'>&nbsp;</td>
		<td class='label'><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class ='label'>
		<!-- <select name='uom_code' id='uom_code'  <%=disabled_status%>><%= bean.getUOM(uom_code) %></select>
		<input type=text name='uom_desc' id='uom_desc' value='<%=uom_desc%>' disabled></td>
		<td class='label'>&nbsp;</td>
	</tr>  -->

	<tr>
		<td class='label' colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class='label'><fmt:message key="eST.EquivalentUOMQuantity.label" bundle="${st_labels}"/></td>
		<%if(((String)eff_status).equals("D")) {%>
		<td class='label'><input type='text' name='equom_qty' id='equom_qty' size='15' maxlength='8' value="<%=equom_qty%>" <%=disabled_status%> style='text-align:right'  onKeyPress='return isValidInteger();' >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<%} else {%>
		<td class='label'><input type='text' name='equom_qty' id='equom_qty' size='15' maxlength='8' value="<%=equom_qty%>"style='text-align:right'  onKeyPress='return isValidInteger();' >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<%}%>
		<td class='label' style="text-align:right"><fmt:message key="eST.EquivalentUOMCode.label" bundle="${st_labels}"/></td>
		<td class='label'><select name='equom_code' id='equom_code' <%=disabled_status%>  onchange="defaultOne('Y');"><%= bean.getEquivalentUOM (equom_code)%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>

	<tr>
		<td class='label' colspan = "4">&nbsp;</td>
	</tr>

	
	<tr>
		<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan="3">&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>"  <%=chked%> onclick="assignValue(this);"></td>
	</tr>

	<tr>
		<td class='label' colspan = "4">&nbsp;</td>
	</tr>		

	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="uom_code" id="uom_code" value="<%=uom_code%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="SQL_MM_ITEM_UOM_LOOKUP" id="SQL_MM_ITEM_UOM_LOOKUP" value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_UOM_LOOKUP")%>">
	</table>
</form>

<%
putObjectInBean(bean_id,bean,request);
%>


</body>
</html>

