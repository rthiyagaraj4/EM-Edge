<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Jan 2005
--%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script> 
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<SCRIPT LANGUAGE="JavaScript">

function callresult(values)
{
	var termsetid = document.frm_terminology_code.termsetid.value;
	var search_criteria = document.frm_terminology_code.search_criteria.value;
	var search_text = document.frm_terminology_code.search_text.value;
	var termcode = document.frm_terminology_code.termcode.value;
	var codelevel = document.frm_terminology_code.codelevel.value;
	if(codelevel=="") codelevel = "1";
	var srch_text = search_text.toUpperCase();
	var hypval = values;
	if(termsetid!=null)
	{
		if(search_criteria=="S")
		{
			if(search_text!="")
			{
				if((search_text==hypval) || (srch_text==hypval))
				{
					parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
					//document.term_code_result_header.submit();
				}
			}
			else
			{
				parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
				//document.term_code_result_header.submit();
			}
		}
		else
		{	
			if(document.term_code_result_header.className.value=="className")
				className = "className";
			else
				className = "";
			parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"";
			//document.term_code_result_header.submit();
		}
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}




function callresult1(values)
{
	var termsetid = document.term_code_result_header.termsetid.value;
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";
	var srch_text = search_text.toUpperCase();
	var hypval = values;
	if(termsetid!=null)
	{
		if(search_criteria=="S")
		{
			if(search_text!="")
			{
				if((search_text==hypval) || (srch_text==hypval))
				{
					parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
					document.term_code_result_header.submit();
				}
			}
			else
			{
				parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"";
				document.term_code_result_header.submit();
			}
		}
		else
		{	
			if(document.term_code_result_header.className.value=="className")
				className = "className";
			else
				className = "";
			parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"";
			document.term_code_result_header.submit();
		}
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
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
	if(document.term_code_result_header.class_lvl.value==document.term_code_result_header.codelevel.value)
		className = "className";
	else
		className = "";
	if(termsetid!=null)
	{
	   alert("121"+parent.f_term_code_result.name);	parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"";
		//document.term_code_result_header.submit();
		
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
function callres1()
{
	var termsetid = document.term_code_result_header.termsetid.value;
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";
	search_text = search_text.toUpperCase();
	if(document.term_code_result_header.class_lvl.value==document.term_code_result_header.codelevel.value)
		className = "className";
	else
		className = "";
	if(termsetid!=null)
	{
		parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"";
		document.term_code_result_header.submit();
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' topmargin='0' leftmargin='0'>
<FORM METHOD='POST' name='term_code_result_header' id='term_code_result_header' target='f_term_selected_frms' ACTION="../../eMR/jsp/EquivalentTermCodeResult.jsp">
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<TR>
	<TD>&nbsp;</TD>
	<TD class="QUERYDATA" width="35%" id="dynlevel" align='left' >&nbsp;</TD>
	<TD width="35%" class='label' align='left'>&nbsp;&nbsp;Search&nbsp;<INPUT TYPE="text" name="search_text" id="search_text" maxlength='100' size='40'>
	</TD>
	<TD align='left'><SELECT name="search_criteria" id="search_criteria">
	<OPTION Value="C">Contains</OPTION>
	<OPTION value="S">Starts With</OPTION>
	<OPTION Value="E">Ends With</OPTION>
	</SELECT><INPUT TYPE="button" class="button" value="Search" onclick="callres()">
	</TD>    
</TR>
</TABLE>
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<TR>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
	<TD>&nbsp;</TD>
	<TD class="label"><A HREF="javascript:callresult('All')"><U>All</U></A></TD>
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
	<TD class="label"><A HREF="javascript:callresult('OT')"><U>Others</U></A></TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" name='termsetid' id='termsetid' value=''>
<INPUT TYPE="hidden" name='termdesc' id='termdesc' value=''>
<INPUT TYPE="hidden" name='termcode' id='termcode' value=''>
<INPUT TYPE="hidden" name='codelevel' id='codelevel' value=''>
<INPUT TYPE="hidden" name="className" id="className" value="">
<INPUT TYPE="hidden" name="class_lvl" id="class_lvl" value="">
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

