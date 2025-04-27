
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<HTML>
<HEAD>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<SCRIPT LANGUAGE="JavaScript" SRC="../js/OrderPrintRouting.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/common.js">                 </script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js">        </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<TITLE><fmt:message key="eOR.InstructionDetails.label" bundle="${or_labels}"/></TITLE>
</HEAD>
<script>

function closeWindow(){
window.returnValue =formInstruction.instruction.value;
window.close();
}

</script>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >


	  <%
	  request.setCharacterEncoding("UTF-8");
	  String textVal=request.getParameter("textVal");
	  if(textVal==null||textVal.equals(""))textVal="";
	  %>

	<FORM name="formInstruction" id="formInstruction" >
		<TABLE CELLPADDING="3" CELLSPACING="0" WIDTH="100%" ALIGN="center" >
		<!--size=500 maxlength=500  -->
		<TR>
			<TD COLSPAN="2" class=label>
			<textarea name='instruction'   cols=54 rows=14 title="Fill Instruction"  onBlur="SPCheckMaxLen('Instruction',this,500,'');" value="" onkeyPress='return checkMaxLimit(this,500)'><%=textVal%> </textarea>
			
			</TD>
		</TR>
		<TR>
			<TD WIDTH="60%" CLASS="label" COLSPAN="100%"><B></B></TD>
		</TR>
		
		<TR>
			<TD class='button' COLSPAN="2" ALIGN="center" >
			<INPUT TYPE="button" CLASS="button" name="closebtn" id="closebtn" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="closeWindow();" title="Close Window">
			</TD>
		</TR>
		</TABLE>
	</FORM>
</BODY>
</HTML>


