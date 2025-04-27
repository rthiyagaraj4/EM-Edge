<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Jan 2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script> 

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<SCRIPT LANGUAGE="JavaScript">

function callresult(values)
{
	
	document.getElementById("alphalink").value=values;
	var diag_spec_yn = parent.f_term_code_set.document.frm_terminology_code.diag_spec_yn.value ;
	var proc_spec_yn = parent.f_term_code_set.document.frm_terminology_code.proc_spec_yn.value ;
	var termsetid = document.term_code_result_header.termsetid.value;
	if(termsetid=="")
	{
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.TerminologySet.label","Common"));
		parent.frames[7].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		parent.f_term_result_header.location.href="../../eMR/jsp/TerminologyCodeResultHeader.jsp";
		return false ;
	}
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	if(search_text.indexOf("'")!=-1)
		{			
			search_text = search_text.replace("'","''");
		}

	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";

	//parent.f_term_add_modify.location.href="../../eMR/jsp/TerminologyCodeAddModify.jsp?termsetid="+termsetid+"&codelevel="+codelevel;
	var srch_text = search_text.toUpperCase();
	var hypval = values;
	if(srch_text=="")
	{					  
		parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_text="+srch_text+"&termcode="+termcode+"&codelevel="+codelevel+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"";
	}
	else if(termsetid!=null)
	{
		if(search_criteria=="S")
		{			
				parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+srch_text+"&termcode="+termcode+"&codelevel="+codelevel+"&diag_spec_yn ="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"";
				//document.term_code_result_header.submit();						
					
		}
		else
		{			
				if(document.term_code_result_header.className.value=="className")
						className = "className";
				else
						className = "";
				parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+srch_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"&diag_spec_yn ="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"";
				//document.term_code_result_header.submit();			
						
		}
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
function callres()
{
	var termsetid = document.term_code_result_header.termsetid.value;
	var diag_spec_yn = parent.f_term_code_set.document.frm_terminology_code.diag_spec_yn.value ;
	var proc_spec_yn = parent.f_term_code_set.document.frm_terminology_code.proc_spec_yn.value ;
	if(termsetid=="")
	{
		var msg=getMessage("CAN_NOT_BE_BLANK","Common");
		msg= msg.replace('$',getLabel("Common.TerminologySet.label","Common"));
		parent.frames[7].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		return false ;
	}
	var search_criteria = document.term_code_result_header.search_criteria.value;
	var search_text = document.term_code_result_header.search_text.value;
	var termcode = document.term_code_result_header.termcode.value;
	var codelevel = document.term_code_result_header.codelevel.value;
	if(codelevel=="") codelevel = "1";
	search_text = search_text.toUpperCase();
	if(search_text.indexOf("'")!=-1)
			{
				
			search_text = search_text.replace("'","''");
		}
	
	if(document.term_code_result_header.class_lvl.value==document.term_code_result_header.codelevel.value)
		className = "className";
	else
		className = "";
	
	if(termsetid!=null)
	{
	      parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_flag=C"+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"";
		//document.term_code_result_header.submit();
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD='POST' name='term_code_result_header' id='term_code_result_header' target='blankFrame' ACTION="../../eMR/jsp/TerminologyCodeResult.jsp">
<TABLE border="0" cellpadding="5" cellspacing="0" width="100%" align='center'>
<TR>
	<TD class="QUERYDATA" width="20%" id="dynlevel" ></TD>
	<TD width="15%" class='label' ><fmt:message key="Common.search.label" bundle="${common_labels}"/></td><td class='fields' width='25%'><INPUT TYPE="text" name="search_text" id="search_text" maxlength='100' size='40'>
	</TD>
	<TD class='fields' width='20%'><SELECT name="search_criteria" id="search_criteria">
	<OPTION Value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
	<OPTION value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></OPTION>
	<OPTION Value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
	</SELECT></td><TD class='button' width='40%'><INPUT TYPE="button" class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="callres()">
	</TD>    
</TR>
</TABLE>
<TABLE border="0" cellpadding="5" cellspacing="0" width="100%" align='center'>
<TR>
	<TD class="label"><A HREF="javascript:callresult('All')"><U><fmt:message key="Common.all.label" bundle="${common_labels}"/></U></A></TD>
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
	<TD class="label"><A HREF="javascript:callresult('OT')"><U><fmt:message key="Common.others.label" bundle="${common_labels}"/></U></A></TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" name='termsetid' id='termsetid' value=''>
<INPUT TYPE="hidden" name='termdesc' id='termdesc' value=''>
<INPUT TYPE="hidden" name='termcode' id='termcode' value=''>
<INPUT TYPE="hidden" name='codelevel' id='codelevel' value=''>
<INPUT TYPE="hidden" name="className" id="className" value="">
<INPUT TYPE="hidden" name="class_lvl" id="class_lvl" value="">
<INPUT TYPE="hidden" name="alphalink" id="alphalink" value="">
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

