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
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	ResultSet termcodeRs = null;
	ResultSet SearchValues = null;
	PreparedStatement termcodeStmt = null;
	PreparedStatement  SearchPmt=null;
	String termcodeSql = "";
	String termsetid = "";
	String termsetdesc = "";
	String Terminology = "";
	String termset_id = "";
	String termcodeSql_title = "";
	String typeset_title  = "";
	
	Terminology=request.getParameter("termsetid");
	termset_id=request.getParameter("termset_id");


	String type_set = request.getParameter("type_set");

	String sq = "select EQUIVALENT_TERM_CODE from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID=? and TERM_CODE=?";


	con = ConnectionManager.getConnection(request);
	SearchPmt=con.prepareStatement(sq);
	SearchPmt.setString(1,Terminology);
	SearchPmt.setString(2,termset_id);
	SearchValues = SearchPmt.executeQuery();
//	out.println("sq"+sq);
	//out.println("SearchValues"+SearchValues);
	try
		{
			//con = ConnectionManager.getConnection(request);
			termcodeSql_title = "select description from MR_CROSS_REF_RULE where CROSS_REF_TYPE=(select LINKED_CROSS_REF_TYPE FROM MR_CROSS_REF_RULE WHERE CROSS_REF_TYPE =?)";
			
			termcodeStmt = con.prepareStatement(termcodeSql_title);
			termcodeStmt.setString(1,type_set);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					typeset_title = termcodeRs.getString("description");
					
					
				}
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}

		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
 
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../js/EquivalentTermCode.js"></script>
<SCRIPT LANGUAGE="JavaScript">

function callres()
{  

	if(document.frm_terminology_code.terminology_set1.value=="")
	{
	  //var msg="APP-000001 Equivalent Term Set  Cannot be blank...";
	  var msg	=	getMessage("CAN_NOT_BE_BLANK","Common");
	  msg	=	msg.replace("$",getLabel("eMR.EquivalentTermSet.label","MR"));
	  parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  return false ;
	}
	var termsetid = document.frm_terminology_code.termsetid.value;
	var search_criteria = document.frm_terminology_code.search_criteria.value;
	var search_text = document.frm_terminology_code.search_text.value;
	var termcode = document.frm_terminology_code.termcode.value;
	var codelevel = document.frm_terminology_code.codelevel.value;
    var ThirdConbox = document.frm_terminology_code.terminology_set1.value;
	var FirstConbox = document.frm_terminology_code.Terminology.value;
	var SecondValue = document.frm_terminology_code.termset_id.value;
	var searchcode = document.frm_terminology_code.searchName.name;
	var type_set = document.frm_terminology_code.type_set.value;
		

if(type_set == 'EQ')
	 type_set='EQ';
else if(type_set == 'DA')
	type_set = 'AS'
/*else if(type_set == 'EC')
	type_set='CO';*/
/*
	The Above code was commented On 2/1/2010 that code was modified as below 
*/
else if(type_set == 'CO')
	type_set='EC';



	if(codelevel=="") codelevel = "1";
	
	if(search_text.indexOf("'")!=-1)
			{
				
			search_text = search_text.replace("'","''");
		}
	if(document.frm_terminology_code.class_lvl.value==document.frm_terminology_code.codelevel.value)
		className = "className";
	else
		className = "";
	if(termsetid!=null)
	{
		parent.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?codeResult=result&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&codelevel="+codelevel+"&className="+className+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&termsetid="+ThirdConbox+"&searchcode="+searchcode+"&mr_term_set=N&status=Y"+"&type_set="+type_set+" ";
		
	}
		parent.parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";


}

function callresult(values)
{
	if(document.frm_terminology_code.terminology_set1.value=="")
	{
	  //var msg="APP-000001 Equivalent Term Set  Cannot be blank...";
	  var msg	=	getMessage("CAN_NOT_BE_BLANK","Common");
	  msg	=	msg.replace("$",getLabel("eMR.EquivalentTermSet.label","MR"));
	  parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	}
  else
	{
	
		var termsetid = document.frm_terminology_code.termsetid.value;
		var search_criteria = document.frm_terminology_code.search_criteria.value;
		var search_text = document.frm_terminology_code.search_text.value;
		var termcode = document.frm_terminology_code.termcode.value;
		var codelevel = document.frm_terminology_code.codelevel.value;
		if(codelevel=="") codelevel = "1";
		var srch_text = search_text.toUpperCase();
		var hypval = values;
		var ThirdConbox = document.frm_terminology_code.terminology_set1.value;
		var FirstConbox = document.frm_terminology_code.Terminology.value;
		var SecondValue = document.frm_terminology_code.termset_id.value;
		var type_set = document.frm_terminology_code.type_set.value;

if(type_set == 'EQ')
	 type_set='EQ';
else if(type_set == 'DA')
	type_set = 'AS'
/*else if(type_set == 'EC')
	type_set='CO';*/
/*
	The Above code was commented On 2/1/2010 that code was modified as below 
*/

else if(type_set == 'CO')
	type_set='EC';


		if(search_text.indexOf("'")!=-1)
			{
				
			search_text = search_text.replace("'","''");
		}
		
	if(termsetid!=null)
	{
		
		if(search_criteria=="S")
		{
			 
			if(search_text!="")
			{ 
				if((search_text==hypval) || (srch_text==hypval))
				{
					
					parent.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code='Y'&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&alphalink="+values+"&codelevel="+codelevel+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&termsetid="+ThirdConbox+"&mr_term_set=N&type_set="+type_set+" ";
					
				}
				else{

					parent.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code='Y'&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&alphalink="+values+"&codelevel="+codelevel+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&termsetid="+ThirdConbox+"&mr_term_set=N&type_set="+type_set+" ";
				}
			}
			else
			{	
					parent.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code='Y'&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&alphalink="+values+"&codelevel="+codelevel+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&termsetid="+ThirdConbox+"&mr_term_set=N&type_set="+type_set+"";
			}
		}
		else
		{	
			
			if(document.frm_terminology_code.className.value=="className")
				className = "className";
			else
				className = "";
		
		parent.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code='Y'&termdesc="+values+"&termsetid="+termsetid+"&search_criteria="+search_criteria+"&search_text="+search_text+"&termcode="+termcode+"&alphalink="+values+"&codelevel="+codelevel+"&className="+className+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&termsetid="+ThirdConbox+"&&status=Y"+"&mr_term_set=N&type_set="+type_set+" ";
			
		}
	}
	parent.parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
 }
}
function getdefnlevels()
{
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	var termsetid = document.frm_terminology_code.terminology_set1.value;
	
	var Terminology = document.frm_terminology_code.Terminology.value;
	var termset_id = document.frm_terminology_code.termset_id.value;
	var type_set = document.frm_terminology_code.type_set.value;	

if(type_set == 'EQ')
	 type_set='EQ';
else if(type_set == 'DA')
	type_set = 'AS'
/*else if(type_set == 'EC')
	type_set='CO';*/
/*
	The Above code was commented On 2/1/2010 that code was modified as below 
*/
else if(type_set == 'CO')
	type_set='EC';

	parent.f_query_criteria.document.frm_terminology_code.search_text.value="";
	
	parent.f_query_criteria.document.frm_terminology_code.search_criteria.value="C";
	parent.f_query_criteria.document.frm_terminology_code.termcode.value="";
	parent.f_query_criteria.document.frm_terminology_code.codelevel.value="";
	document.frm_terminology_code.termsetid.value =termsetid;     
		 
	parent.parent.f_term_selected_frms.f_batch_result.document.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termsetid="+termsetid+"&Terminology="+Terminology+"&termset_id="+termset_id+"&mr_term_set=N&type_set="+type_set+" ";		

	
}
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' OnLoad='getdefnlevels()'>
<FORM METHOD=POST ACTION="" target="messageFrame" name="frm_terminology_code" id="frm_terminology_code">
<INPUT TYPE="hidden" name="terminology" id="terminology" value="">  
<font = 'verdana' class = "COLUMNHEADER" size = '2' style='COLOR: black;'><b><%=typeset_title%></b></font>
<TABLE border="0" cellpadding="4" cellspacing="0" width="100%" align='center'>
<TR>
	<TD class='label' width='20%'><fmt:message key="eMR.EquivalentTermSet.label" bundle="${mr_labels}"/></TD>
	<TD class='fields' width='25%'>
	<%try
		{
	
	if(type_set.equals("DA")  || type_set.equals("CO")){%>
		
		<SELECT name="terminology_set1" id="terminology_set1" disabled >
		<!--<OPTION value="<%=Terminology%>" disabled><%=Terminology%></OPTION>-->
	
		<%
			
		//con = ConnectionManager.getConnection(request);
			termcodeSql = "select term_set_id,term_set_desc from MR_TERM_SET where eff_status='E' and term_set_id=?";
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeStmt.setString(1,Terminology);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next()){
				termsetid = termcodeRs.getString("term_set_id");
				termsetdesc = termcodeRs.getString("term_set_desc");
				out.println("<option value='"+Terminology+"'>"+termsetdesc+"</option>");
				}

			}


	}else{%>
		<SELECT name="terminology_set1" id="terminology_set1"  onchange="getdefnlevels()">
		<OPTION value=""> ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- </OPTION>
		<%
		
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
		
			termcodeSql = "select term_set_id,term_set_desc from MR_TERM_SET where eff_status='E' and term_set_id NOT IN (?) order by term_set_desc";
			
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeStmt.setString(1,Terminology);
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
			}

		}
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
	<TD  width="10%" class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/></td>
	<td width="30%" class='fields'><INPUT TYPE="text" name="search_text" id="search_text" maxlength='100' size='17'><SELECT name="search_criteria" id="search_criteria">
	<OPTION Value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
	<OPTION value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></OPTION>
	<OPTION Value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
	</SELECT></TD>
	<TD width='15%' class='button'><INPUT TYPE="button" class="button" id="SearchId" name="searchName" id="searchName" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onclick="callres()">
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
	<TD class="label"><A HREF="javascript:callresult('OT')"><U><fmt:message key="Common.others.label" bundle="${common_labels}"/></U></A></TD>
	</TR>
</TABLE>
<INPUT TYPE="hidden" name='dyanmic_level' id='dyanmic_level' value="">  
<INPUT TYPE="hidden" name='termsetid' id='termsetid'     value=''> 
<INPUT TYPE="hidden" name='termdesc' id='termdesc'      value=''>
<INPUT TYPE="hidden" name='termcode' id='termcode'      value=''>
<INPUT TYPE="hidden" name='codelevel' id='codelevel'     value=''>
<INPUT TYPE="hidden" name="className" id="className"     value="">
<INPUT TYPE="hidden" name="class_lvl" id="class_lvl"     value="">
<INPUT TYPE="hidden" name="Terminology" id="Terminology" value="<%=Terminology%>">
<INPUT TYPE="hidden" name="termset_id" id="termset_id" value="<%=termset_id%>">
<input type = 'hidden' name = 'type_set' value=<%=type_set%>>
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

