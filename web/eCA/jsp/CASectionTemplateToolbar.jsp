<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>
</title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script language="Javascript" src="../../eCA/js/CASectionTemplateMessage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='CASectionTemplateToolbarForm' id='CASectionTemplateToolbarForm' method='post' action='../../servlet/eCA.CASectionTemplateServlet'>
<%
String operation=request.getParameter("operation");
String value="";
String disableEnableHistBtn="disabled";
//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//String locale = (String) p.getProperty("LOCALE");

if(operation == null) 
{
	operation="insert";
	value="N";
}

String comp_id					=	""	,			prompt_id			=	"";
String srl_no					=	""	,			comp_type			=	"";
String formula_def_button	="display:none";
String linking_btn				="display:none";
String link_history_button	="display:none";
String sectionCode				=	request.getParameter("section");
if(sectionCode==null) sectionCode="";
String link_to_std_value_yn		= "";
String dflt_from_hist_appl_yn	= "";
String old_hist_time_frame_unit = "";
String old_hist_time_frame_val	= "";
String list_presentation ="";
String hist_def_yn = "";


if(operation.equals("modify"))
{
	if(comp_id==null) comp_id="";
	comp_id=request.getParameter("comp_id");
	prompt_id=request.getParameter("prompt_id");
	if(prompt_id==null) prompt_id="";
	srl_no=request.getParameter("srl_no");
	if(srl_no==null) srl_no="";
	comp_type=request.getParameter("comp_type");
	if(comp_type==null) comp_type="";
	list_presentation			=	(request.getParameter("list_presentation")==null)	?""	:	request.getParameter("list_presentation");
	link_to_std_value_yn = request.getParameter("link_to_std_value_yn")==null?"":request.getParameter("link_to_std_value_yn");
	dflt_from_hist_appl_yn = request.getParameter("dflt_from_hist_appl_yn")==null?"N":request.getParameter("dflt_from_hist_appl_yn");
	old_hist_time_frame_unit = request.getParameter("old_hist_time_frame_unit")==null?"":request.getParameter("old_hist_time_frame_unit");
	old_hist_time_frame_val = request.getParameter("old_hist_time_frame_val")==null?"":request.getParameter("old_hist_time_frame_val");
	hist_def_yn = request.getParameter("hist_def_yn") == null ? "":request.getParameter("hist_def_yn");

	if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("H"))
	{
		link_history_button = "display";
	}
	else
	{
		link_history_button = "display:none";
	}
	
	if(comp_type.equals("C") || (comp_type.equals("L") && list_presentation.equals("S")))
	{
		formula_def_button="display:none";
		linking_btn="display";
	}

	if(link_to_std_value_yn.equals("N") && dflt_from_hist_appl_yn.equals("Y") && !(comp_type.equals("P") || comp_type.equals("A") || comp_type.equals("R") || comp_type.equals("L")) )
	{
		link_history_button = "display";
	}

	if(dflt_from_hist_appl_yn.equals("Y")){
		if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("H"))
		{
			link_history_button = "display";
		}
		else
		{
			link_history_button = "display:none";
		}
		disableEnableHistBtn = "";
	}

	if(comp_type.equals("A"))
	{
		linking_btn="display:none";
		formula_def_button="display";
		
	}
}
%>
<table  width='100%' cellspacing='5' cellpadding='3' style="border: 1.5px solid blue; border-collapse: collapse;">
<tr>
	<td  colspan = 4 align = right width = '100%'>
	<input type='button' class=button  name='linking' id='linking' value='Dependency' onclick="callOnLinking('<%=sectionCode%>','<%=comp_id%>','<%=comp_type%>','<%=prompt_id%>','<%=srl_no%>')" style='<%=linking_btn%>' > 
	<input type='button' class=button  name='formulaDefinitionBtn' id='formulaDefinitionBtn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FormulaDefinition.label","ca_labels")%>' onclick="callOnFormulaDefinition()" style='<%=formula_def_button%>'>
	<input type='button' class=button  name='linkHistoryBtn' id='linkHistoryBtn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LinkHistory.label","ca_labels")%>' onclick="callOnLinkHistory()" style='<%=link_history_button%>' <%=disableEnableHistBtn%> >  

	<%	if (operation.equals("modify"))
		{ 
			%>	
				<input type ="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" class="button" onClick="Record('Modify')">
				<input type ="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%>" class="button" onClick="Record('Delete')">
			<% 
		}
		else
		{ 
			%>
				<input  type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" class="button" onClick="Record('Insert')">
			<%
		}
	%>
		<input  type="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class="button" onclick='getCancel()'>
	</td>
</tr>
</table>

<input type='hidden' name='section' id='section' value="">
<input type='hidden' name='hitem_type' id='hitem_type' value="">
<input type='hidden' name='srl_no' id='srl_no' value="<%=srl_no%>">
<input type='hidden' name='operation' id='operation' value="<%=operation%>">
<input type='hidden' name='component_type' id='component_type'  value="<%=comp_type%>">
<input type='hidden' name='old_hist_time_frame_val' id='old_hist_time_frame_val' value='<%=old_hist_time_frame_val%>' >
<input type='hidden' name='old_hist_time_frame_unit' id='old_hist_time_frame_unit' value='<%=old_hist_time_frame_unit%>' >
<input type='hidden' name='comp_id' id='comp_id' value='<%=comp_id%>' >
<input type='hidden' name='section_code' id='section_code' value='<%=sectionCode%>'>
<input type='hidden' name='hist_def_yn' id='hist_def_yn' value='<%=hist_def_yn%>'>

</form>
</body>
</html>


