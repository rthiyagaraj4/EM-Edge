<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eOH.* ,eOH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
/* Mandatory checks end */

/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//bean.clear() ;
	bean.setMode( mode ) ;
/* Initialize Function specific end */
	String template_id = request.getParameter("template_id");
	String msr_desc = request.getParameter("msr_desc");
	String row_index = request.getParameter("row_index");
	String data_from = request.getParameter("data_from");
	String readonly = request.getParameter("readonly");
	if(template_id==null)	template_id="";
	if(msr_desc==null)	msr_desc="";
	if(row_index==null)	row_index="";
	if(data_from==null)	data_from="";
	if(readonly==null)	readonly="";
	String templateText = "";
	
	if(data_from.equals("B"))
	{
		templateText = java.net.URLDecoder.decode((String)bean.getResultData(row_index),"UTF-8");
			
		//templateText =(String)bean.getResultData(row_index);

	}
	else if(data_from.equals("T") || templateText==null || templateText.trim().equals("null"))
	{
		templateText = java.net.URLDecoder.decode((String)bean.getResultTemplate(template_id),"UTF-8");
		//templateText = bean.getResultTemplate(template_id);
	}
	if(templateText == null)templateText= "";
	/*if(templateText!=null && !templateText.equals(""))
		templateText = templateText.replace('\"','\n');*/
	//out.println("template_id= "+template_id+"msr_desc="+msr_desc+);
%>

<html>
<head>
	
	<title><fmt:message key="Common.ResultTemplate.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../js/ResultEntry.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<script>
  function putSometexttoClipBoard()
  {
	  var text = window.clipboardData.getData("Text");
	  if(text == "" || text == null)
	  {
		if(document.getElementById("clipTxtBtn")!=null)
		{
			var clipBoardVal=document.getElementById("clipTxtBtn").createTextRange();
			clipBoardVal.select();
			clipBoardVal.execCommand("copy","","");
			clipBoardVal.execCommand("Unselect","","");
		}
	  }
  }
</script>
<body style='background-color:#E2E3F0;'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" onload="putSometexttoClipBoard();">
<FORM name='result_entry_template_top' id='result_entry_template_top' METHOD=POST ACTION="./ResultEntryTemplateSave.jsp">
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
<tr>
	<td class=columnheader><%=msr_desc%></td>
</tr>
<!--<script>alert(1+"<%=templateText%>");</script>-->
<tr>
	<td class='fields'>
		<TEXTAREA NAME="templateText" ROWS="13" COLS="108" <%=readonly%>><%=templateText%></TEXTAREA><%-- onBlur=makeValidString(this);--%>
		<input type='hidden' name='row_index' id='row_index' value='<%=row_index%>'>
	</td>
</tr>
<input type='button' name='clipTxtBtn' id='clipTxtBtn' style='display:none' value='Clip Text'>
</table>
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

