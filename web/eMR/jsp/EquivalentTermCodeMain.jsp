<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Created By		:	Bangarraju
*	Created On		:	10 Jan 2007
--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	ResultSet termcodeRs = null;
	ResultSet typecodeRs = null;
	PreparedStatement termcodeStmt = null;
	PreparedStatement typecodeStmt = null;
//	String termcodeSql = "";
	String typecodeSql = "";
//	String termsetid = "";
	String typesetid = "";
	String termsetdesc = "";
	
	String Terminology = "";
	String cross_ref_type = "";
    Terminology=request.getParameter("termsetid");
	  
%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../js/EquivalentTermCode.js"></script>
	<SCRIPT LANGUAGE="JavaScript">
function getdefnlevels()
{
	 
	var termsetid = document.frm_terminology_code.terminology_set.value;
	var type_set = document.frm_terminology_code.type_set.value;
	parent.f_term_code_set.document.frm_terminology_code.search_text.value="";
    parent.f_term_code_set.document.frm_terminology_code.search_criteria.value="C";
	parent.f_term_code_set.document.frm_terminology_code.termcode.value="";
	parent.f_term_code_set.document.frm_terminology_code.codelevel.value="";
	parent.f_term_code_set.document.frm_terminology_code.termcode_text.value="";

	if(termsetid!="")
	{
		
		parent.f_term_code_set.document.frm_terminology_code.termsetid.value= termsetid;
		parent.f_term_code_set.document.frm_terminology_code.type_set.value= type_set;
	    var htmlresvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_result' method='post' action='../../eMR/jsp/EquivalentTermCodeResult.jsp'><input type='hidden' name='termsetid' value='"+termsetid+"'><input type='hidden' name='type_set' value='"+type_set+"'></html>"
	
	
		parent.f_term_code_result.document.write(htmlresvalue);
		
		parent.f_term_code_result.document.dynamic_result.submit();
		
        parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
		parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
	}
	else
	{
		
	
		parent.f_term_code_result.document.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp";
	    parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
		
	}
}

function callres()
{
    
   if(document.frm_terminology_code.type_set.value=="")
	{
	  //var msg="APP-000001 Terminology Set  Cannot be blank...";
	  var msg	=	getMessage("CAN_NOT_BE_BLANK","Common");
	  msg	=	msg.replace("$",getLabel("eMR.CrossReferenceType.label","MR"));
	  parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  return false ;
	} 
	else if(document.frm_terminology_code.terminology_set.value=="")
	{
	  //var msg="APP-000001 Terminology Set  Cannot be blank...";
	  var msg	=	getMessage("TERM_SET_SHOULD_NOT_BE_BLANK","MR");
	  parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  return false ;
	} 
	var termsetid = document.frm_terminology_code.termsetid.value;
	var search_criteria = document.frm_terminology_code.search_criteria.value;
	var search_text = document.frm_terminology_code.search_text.value;
	
	var termcode = document.frm_terminology_code.termcode.value;
	var codelevel = document.frm_terminology_code.codelevel.value;
	var type_set = document.frm_terminology_code.type_set.value;
	var termcode_text = document.frm_terminology_code.termcode_text.value;
	
	if(codelevel=="") codelevel = "1";
	
	if(search_text.indexOf("'")!=-1)
			{
				
			search_text = search_text.replace("'","''");
		}
	termcode_text = termcode_text.toUpperCase();
	if(document.frm_terminology_code.class_lvl.value==document.frm_terminology_code.codelevel.value)
		className = "className";
	else
		className = "";
	if(termsetid!=null)
	{
		
	 	parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?callres=search&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"&status=Y"+"&type_set="+type_set+"&termcode_text="+termcode_text+" ";
		
		
	}
	parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";

}
function ClearFeilds()
{  
	
	document.frm_terminology_code.terminology_set.value="";
	document.frm_terminology_code.termcode_text.value="";
	document.frm_terminology_code.search_text.value="";
	document.frm_terminology_code.search_criteria.value="";
	parent.frames[2].location.href='../../eMR/jsp/EquivalentTermCodeResult.jsp';
	parent.frames[2].location.href= "../../eCommon/html/blank.html";
	getdefnlevels();
	
}

function callresult(values)
{
	
		
  if(document.frm_terminology_code.terminology_set.value=="")
	{
	   //var msg="APP-000001 Terminology Set  Cannot be blank...";
		var msg	=	getMessage("TERM_SET_SHOULD_NOT_BE_BLANK","MR");
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	}

	else
	{	
		var termsetid = document.frm_terminology_code.termsetid.value;
		var search_criteria = document.frm_terminology_code.search_criteria.value;
		var search_text = document.frm_terminology_code.search_text.value;

		
			if(search_text.indexOf("'")!=-1)
					{
						
					search_text = search_text.replace("'","''");
				}

		var termcode = document.frm_terminology_code.termcode.value;
		var codelevel = document.frm_terminology_code.codelevel.value;
		var type_set = document.frm_terminology_code.type_set.value;
		var termsetid = document.frm_terminology_code.terminology_set.value;
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

							
							
							parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&alphalink="+values+"&type_set="+type_set+"&termsetid="+termsetid+"";
							parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
						
					}else{
						
					parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&alphalink="+values+"&type_set="+type_set+"&termsetid="+termsetid+"";
							parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
					}
				}
				else
				{
					
					parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&alphalink="+values+"&type_set="+type_set+"&termsetid="+termsetid+"";
					parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
					
				}		
			}
			else
			{
				
				if(document.frm_terminology_code.className.value=="className")
					className = "className";
				else
					className = "";
				parent.f_term_code_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"&alphalink="+values+"&status=Y&type_set="+type_set+"&termsetid="+termsetid+"";
		
				parent.f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";	
				
			}
		}
		parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
	
}
</SCRIPT>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="" target="messageFrame" name="frm_terminology_code" id="frm_terminology_code">
	
<TABLE border="0" cellpadding="4" cellspacing="0" width="100%"  align='center'>
<TR>
	<TD class='label' width='20%'><fmt:message key="eMR.CrossReferenceType.label" bundle="${mr_labels}"/></TD>
	<TD class='fields' width='25%' ><SELECT name="type_set" id="type_set" onchange='ClearFeilds();callTermSet(this);'>
		<OPTION value="" > ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- </OPTION> 
		<%
		try
		
		{
			con = ConnectionManager.getConnection(request);
			typecodeSql ="select cross_ref_type,description from MR_CROSS_REF_RULE where cross_ref_appl_yn='Y'";
			
			typecodeStmt = con.prepareStatement(typecodeSql);
			typecodeRs = typecodeStmt.executeQuery();
			if(typecodeRs!=null)
			{
				while(typecodeRs.next())
				{
					typesetid = typecodeRs.getString("description");
					cross_ref_type=typecodeRs.getString("cross_ref_type");
			     out.println("<option value='"+cross_ref_type+"'>"+typesetid+"</option>");
				}
				if(typecodeRs!=null) typecodeRs.close();
				if(typecodeStmt!=null) typecodeStmt.close();
			}

		}
		catch (Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(typecodeRs!=null) typecodeRs.close();
			if(typecodeStmt!=null) typecodeStmt.close();
			ConnectionManager.returnConnection(con,request);
		}
		%>		
		</SELECT><img src='../../eCommon/images/mandatory.gif'></img>

	</TD>
	<TD width="25%" class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/></td><td width="30%" class='fields' ><INPUT TYPE="text" name="search_text" id="search_text" maxlength='100' size='17'><SELECT name="search_criteria" id="search_criteria">
	<OPTION Value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
	<OPTION value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></OPTION>
	<OPTION Value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
	</SELECT>
	</TD>
	<td class='label' width='10%'></td>
	</TR>

<TR>
	<TD class='label' width='20%'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TD>
	<TD class='fields' width='25%' ><SELECT name="terminology_set" id="terminology_set"  onchange="getdefnlevels()">
		<OPTION value=""> ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- </OPTION>
		<%
		try
		{/*Tuesday, February 16, 2010 18717 , query executed in RetICDDescVal.jsp*/
			/*con = ConnectionManager.getConnection(request);
			termcodeSql = "select term_set_id,term_set_desc from MR_TERM_SET where eff_status='E' and term_set_id NOT IN ('"+Terminology+"') order by term_set_desc";
			
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					termsetid = termcodeRs.getString("term_set_id");
					termsetdesc = termcodeRs.getString("term_set_desc");
					out.println("<option value='"+termsetid+"'>"+termsetdesc+"</option>");
				}
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}*/

		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
		finally
		{
			if(termcodeRs!=null) termcodeRs.close();
			if(termcodeStmt!=null) termcodeStmt.close();
			ConnectionManager.returnConnection(con,request);
		}
		%>		
		</SELECT><img src='../../eCommon/images/mandatory.gif'></img>
	</TD>
	<TD width="10%" class='label'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td><td width="30%" class='fields' ><INPUT TYPE="text" name="termcode_text" id="termcode_text" maxlength='100' size='17' value=''></TD>
	<TD width='10%' class='button'><INPUT TYPE="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onclick="callres()"> 
	</TD>
	</TR>
</TABLE>

<TABLE border="0" cellpadding="4" cellspacing="0" width="100%" align='center'>
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
	<TD class="label"></TD>
	<TD class="label"></TD>
	<TD class="label"><A HREF="javascript:callresult('OT')"><U><fmt:message key="Common.others.label" bundle="${common_labels}"/></U></A></TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" name='dyanmic_level' id='dyanmic_level' value="">  
<INPUT TYPE="hidden" name='termsetid' id='termsetid' value=''> 
<INPUT TYPE="hidden" name='termdesc' id='termdesc' value=''>
<INPUT TYPE="hidden" name='termcode' id='termcode' value=''>
<INPUT TYPE="hidden" name='codelevel' id='codelevel' value=''>
<INPUT TYPE="hidden" name="className" id="className" value="">
<INPUT TYPE="hidden" name="class_lvl" id="class_lvl" value="">
<INPUT TYPE="hidden" name="alphalink" id="alphalink" value="">
<INPUT TYPE="hidden" name="terminology" id="terminology" value="">  
<INPUT TYPE="hidden" name="term_set_desc" id="term_set_desc" value="<%=termsetdesc%>">  
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

