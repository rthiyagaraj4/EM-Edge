<!DOCTYPE html>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	07 Feb 2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>


<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<SCRIPT LANGUAGE="JavaScript">
<%
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String termsetid = request.getParameter("termsetid");
String defn_levels = request.getParameter("defn_levels");
%>
function callresult(values){
	var termsetid = document.term_code_result_header.termsetid.value;
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";
	//var srch_text = search_text.toUpperCase();
	search_text = search_text.toUpperCase();
	var hypval = values;
	if(termsetid!=null){
		//	if(search_criteria=="S")
		//	{
		if(search_text!=""){
			if((search_text==hypval)){
			parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
			//document.term_code_result_header.submit(); //for 17320 Modified by Venkats (12/23/2009)
			document.term_code_result_header.search_text.value="";
			}else{
			document.term_code_result_header.search_text.value="";
			parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+hypval+"&termcode="+termcode+"&codelevel="+codelevel+"";
			document.term_code_result_header.submit();
			}
		}else{
			parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
			// alert(parent.f_term_code_result.location.href)
			document.term_code_result_header.submit();
		}
		/*	}
		else
		{	
		parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
		document.term_code_result_header.submit();
		} */
	}
}
function callres()
{
	var termsetid = document.term_code_result_header.termsetid.value;
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";
	search_text = search_text.toUpperCase();
	if(termsetid!=null)
	{
		parent.f_term_code_result.location.href="../../eMR/jsp/SelectTermCodeResult.jsp?termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
		//	document.term_code_result_header.submit();
	}
}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<!--<FORM METHOD='POST' name='term_code_result_header' id='term_code_result_header' target='blankFrame' ACTION="../../eMR/jsp/SelectTermCodeResult.jsp">-->
<FORM METHOD='POST' name='term_code_result_header' id='term_code_result_header' target='blankFrame'>
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<TR>
	<TD>&nbsp;</TD>
	<TD class="QUERYDATA" width="35%" id="dynlevel" align='left' ><fmt:message key="eMR.ClassificationLevels.label" bundle="${mr_labels}"/> <%=defn_levels%></TD>
	<TD width="35%" class='label' align='left' nowrap >&nbsp;&nbsp;<fmt:message key="Common.search.label" bundle="${common_labels}"/>&nbsp;<INPUT TYPE="text" name="search_text" id="search_text" maxlength='100' size='40'>
	</TD>
	<TD align='left'><SELECT name="search_criteria" id="search_criteria" style="margin-left: 5px;">
	<OPTION Value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
	<OPTION value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></OPTION>
	<OPTION Value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
	</SELECT><INPUT TYPE="button" class="button" style="margin-left: 5px;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="callres()">
	</TD>    
</TR>
</TABLE>
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<TR>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
	<TD class="label" nowrap><A HREF="javascript:callresult('All')"><U><fmt:message key="Common.all.label" bundle="${common_labels}"/></U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('A')"><U>A</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('B')"><U>B</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('C')"><U>C</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('D')"><U>D</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('E')"><U>E</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('F')"><U>F</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('G')"><U>G</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('H')"><U>H</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('I')"><U>I</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('J')"><U>J</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('K')"><U>K</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('L')"><U>L</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('M')"><U>M</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('N')"><U>N</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('O')"><U>O</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('P')"><U>P</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('Q')"><U>Q</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('R')"><U>R</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('S')"><U>S</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('T')"><U>T</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('U')"><U>U</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('V')"><U>V</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('W')"><U>W</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('X')"><U>X</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('Y')"><U>Y</U></A></TD>
	<TD class="label"><A HREF="javascript:callresult('Z')"><U>Z</U></A></TD>
	<TD class="label">&nbsp;</TD>
	<TD class="label">&nbsp;</TD>
	<TD class="label" nowrap><A HREF="javascript:callresult('OT')"><U><fmt:message key="Common.others.label" bundle="${common_labels}"/></U></A></TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" name='termsetid' id='termsetid' value='<%=termsetid%>'>
<INPUT TYPE="hidden" name='termdesc' id='termdesc' value=''>
<INPUT TYPE="hidden" name='termcode' id='termcode' value=''>
<INPUT TYPE="hidden" name='codelevel' id='codelevel' value=''>
<INPUT TYPE="hidden" name='defn_levels' id='defn_levels' value='<%=defn_levels%>'>
</FORM>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

