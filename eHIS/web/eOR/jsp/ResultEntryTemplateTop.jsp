<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
10/01/2013	IN037280�		 Chowminya G Incident No: IN037280�- System is displaying internal server error, when we link  diagnosis with "%" character
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultEntry" ;
	String bean_name = "eOR.ResultEntryBean";
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
		//System.out.println("====B=======");
		//templateText = java.net.URLDecoder.decode((String)bean.getResultData(row_index),"UTF-8");//Commentted IN037280�
			
		templateText =(String)bean.getResultData(row_index);//UnCommentted IN037280�

		//System.out.println("====B===templateText===="+templateText);
	}
	else if(data_from.equals("T") || templateText==null || templateText.trim().equals("null"))
	{
		//System.out.println("====T=======");
		//templateText = java.net.URLDecoder.decode((String)bean.getResultTemplate(template_id),"UTF-8");//Commentted IN037280�
		templateText = bean.getResultTemplate(template_id);//UnCommentted IN037280�
	//System.out.println("====T===templateText===="+templateText);
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
	//  var text = window.clipboardData.getData("Text");
	 var text = document.getElementById("clipTxtBtn");
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

