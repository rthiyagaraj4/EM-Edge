<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	17 Jan 2005
--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>



<script language="JavaScript" src="../js/TerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
String termsetid = request.getParameter("termsetid");
String codelevel = request.getParameter("codelevel");
if (codelevel==null) codelevel = "";
String termcode2 = "";
String termcode3 = "";
String termcode4 = "";
String termcode5 = "";
String termcode6 = "";
String termcode7 = "";
String termcode8 = "";
String termcode9 = "";
String termcode10 = "";
if (codelevel.equals("2")) 
termcode2 = request.getParameter("termcode");
else if (codelevel.equals("3")) 
termcode3 = request.getParameter("termcode");
else if (codelevel.equals("4")) 
termcode4 = request.getParameter("termcode");
else if (codelevel.equals("5")) 
termcode5 = request.getParameter("termcode");
else if (codelevel.equals("6")) 
termcode6 = request.getParameter("termcode");
else if (codelevel.equals("7")) 
termcode7 = request.getParameter("termcode");
else if (codelevel.equals("8")) 
termcode8 = request.getParameter("termcode");
else if (codelevel.equals("9")) 
termcode9 = request.getParameter("termcode");
else if (codelevel.equals("10")) 
termcode10 = request.getParameter("termcode");
%>
<script>
function dispresultpg(codelevel,termsetid)
{ 
	var termcode;	
	parent.parent.f_term_add_modify.document.term_code_addmodify.term_code.value="";
	parent.parent.f_term_add_modify.document.term_code_addmodify.short_desc.value="";
	parent.parent.f_term_add_modify.document.term_code_addmodify.long_desc.value="";
	parent.parent.f_term_add_modify.document.term_code_addmodify.eff_status.checked=true;
	parent.parent.f_term_add_modify.document.term_code_addmodify.selectable.checked=false;
	parent.parent.f_term_add_modify.document.term_code_addmodify.proc_diag.value="";
	parent.parent.f_term_add_modify.document.term_code_addmodify.proc_diag.disabled=false;
	parent.parent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly=false;
	parent.parent.f_term_add_modify.document.term_code_addmodify.mode.value="";
	var diag_spec_yn = parent.parent.f_term_code_set.document.frm_terminology_code.diag_spec_yn.value ;
	var proc_spec_yn = parent.parent.f_term_code_set.document.frm_terminology_code.proc_spec_yn.value ;

	if(codelevel==1)
	{
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = '<%=termsetid%>';
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		termcode = '<%=termsetid%>'
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = '<%=termsetid%>';
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		document.term_code_displvl.termcode2.value="";
		document.term_code_displvl.termcode3.value="";
		document.term_code_displvl.termcode4.value="";
		document.term_code_displvl.termcode5.value="";
		document.term_code_displvl.termcode6.value="";
		document.term_code_displvl.termcode7.value="";
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
		parent.parent.f_term_selected_frms.f_term_selected_values.document.location.href="../../eMR/jsp/TerminologyCodeSelectedValues.jsp?termsetid="+termcode+"";
	}
	else if (codelevel==2)
	{	
		termcode = document.term_code_displvl.termcode2.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode3.value="";
		document.term_code_displvl.termcode4.value="";
		document.term_code_displvl.termcode5.value="";
		document.term_code_displvl.termcode6.value="";
		document.term_code_displvl.termcode7.value="";
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==3)
	{
		termcode = document.term_code_displvl.termcode3.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode4.value="";
		document.term_code_displvl.termcode5.value="";
		document.term_code_displvl.termcode6.value="";
		document.term_code_displvl.termcode7.value="";
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==4)
	{
		termcode = document.term_code_displvl.termcode4.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode5.value="";
		document.term_code_displvl.termcode6.value="";
		document.term_code_displvl.termcode7.value="";
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==5)
	{
		termcode = document.term_code_displvl.termcode5.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode6.value="";
		document.term_code_displvl.termcode7.value="";
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==6)
	{
		termcode = document.term_code_displvl.termcode6.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode7.value="";
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==7)
	{
		termcode = document.term_code_displvl.termcode7.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode8.value="";
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==8)
	{
		termcode = document.term_code_displvl.termcode8.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode9.value="";
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==9)
	{
		termcode = document.term_code_displvl.termcode9.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
		document.term_code_displvl.termcode10.value="";
	}
	else if (codelevel==10)
	{
		termcode = document.term_code_displvl.termcode10.value;
		parent.parent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;
		parent.parent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = codelevel;
		parent.parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termcode;
	}
	if(termcode!="")
	{
		if(eval(document.term_code_displvl.class_lvl.value)==codelevel)
			className = "className";
		else
			className = "";
		if(codelevel==1)
		{
			termcode = "";
			className = "";
		}
		

		parent.parent.f_term_code_result.location.href="../../eMR/jsp/TerminologyCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&codelevel="+codelevel+"&search_flag=C&className="+className+"&diag_spec_yn="+diag_spec_yn+"&proc_spec_yn="+proc_spec_yn+"";
		parent.parent.f_term_code_result.document.term_code_result.submit();
		var htmlvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_value' id='dynamic_value' method='post' action='../../eMR/jsp/TerminologyCodeDynamicValues.jsp'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='codelevel' id='codelevel' value='"+codelevel+"'><input type='hidden' name='termcode' id='termcode' value='"+termcode+"'></form></body></html>"
		parent.parent.blankFrame.document.write(htmlvalue);
		parent.parent.blankFrame.document.dynamic_value.submit();
	}
	else
	{
		alert(getMessage("HIGHER_LVL_SEL",'MR'));
		//return false;
	}
	// This part is wriiten for deleteing the rows according to the classification
	// level selected in this we take the length of the row and subtract it with the 
	// rwlen value which we store as hidden field in this page.
	if(codelevel!=1)
	{
		cddlvl = eval(codelevel);
		rwlen = parent.parent.f_term_selected_frms.f_term_selected_values.document.getElementById("tableId").rows.length;
		if(cddlvl <= rwlen)
		{
			var baseCounter = cddlvl-1;
			for(var i=baseCounter;i<rwlen;i++)
			{
				parent.parent.f_term_selected_frms.f_term_selected_values.document.getElementById("tableId").deleteRow(baseCounter);
			}
		}
	}
	// End of deleting row.
	parent.parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='term_code_displvl' id='term_code_displvl'>
<%
Connection con = null;
PreparedStatement displvlStmt = null;
ResultSet displvlRs = null;
String displvlSql = "";
String displvl1 = "";
String displvl2 = "";
String displvl3 = "";
String displvl4 = "";
String displvl5 = "";
String displvl6 = "";
String displvl7 = "";
String displvl8 = "";
String displvl9 = "";
String displvl10 = "";
String level_1_code_length = "";
String level_2_code_length = "";
String level_3_code_length = "";
String level_4_code_length = "";
String level_5_code_length = "";
String level_6_code_length = "";
String level_7_code_length = "";
String level_8_code_length = "";
String level_9_code_length = "";
String level_10_code_length = "";
//int displvlcnt = 0;
//int i = 0;
if(termsetid == null) termsetid="";
try
{
	con = ConnectionManager.getConnection(request);
	displvlSql = "select level_1_desc,level_1_code_length,level_2_code_length,level_3_code_length,level_4_code_length,level_5_code_length,level_6_code_length,level_7_code_length,level_8_code_length,level_9_code_length,level_10_code_length,level_2_desc,level_3_desc,level_4_desc,level_5_desc,level_6_desc,level_7_desc,level_8_desc,level_9_desc,level_10_desc from mr_term_set where term_set_id=?";
	displvlStmt = con.prepareStatement(displvlSql);
	displvlStmt.setString(1,termsetid);
	displvlRs = displvlStmt.executeQuery();
	
	if(displvlRs!=null)
	{
		if(displvlRs.next())
		{
			displvl1 = displvlRs.getString("level_1_desc");
			if(displvl1==null) displvl1="";
			displvl2 = displvlRs.getString("level_2_desc");
			if(displvl2==null) displvl2="";
			displvl3 = displvlRs.getString("level_3_desc");
			if(displvl3==null) displvl3="";
			displvl4 = displvlRs.getString("level_4_desc");
			if(displvl4==null) displvl4="";
			displvl5 = displvlRs.getString("level_5_desc");
			if(displvl5==null) displvl5="";
			displvl6 = displvlRs.getString("level_6_desc");
			if(displvl6==null) displvl6="";
			displvl7 = displvlRs.getString("level_7_desc");
			if(displvl7==null) displvl7="";
			displvl8 = displvlRs.getString("level_8_desc");
			if(displvl8==null) displvl8="";
			displvl9 = displvlRs.getString("level_9_desc");
			if(displvl9==null) displvl9="";
			displvl10 = displvlRs.getString("level_10_desc");
			if(displvl10==null) displvl10="";
			level_1_code_length = displvlRs.getString("level_1_code_length");
			level_2_code_length = displvlRs.getString("level_2_code_length");
			level_3_code_length = displvlRs.getString("level_3_code_length");
			level_4_code_length = displvlRs.getString("level_4_code_length");
			level_5_code_length = displvlRs.getString("level_5_code_length");
			level_6_code_length = displvlRs.getString("level_6_code_length");
			level_7_code_length = displvlRs.getString("level_7_code_length");
			level_8_code_length = displvlRs.getString("level_8_code_length");
			level_9_code_length = displvlRs.getString("level_9_code_length");
			level_10_code_length = displvlRs.getString("level_10_code_length");
			if(level_1_code_length==null) level_1_code_length="";
			if(level_2_code_length==null) level_2_code_length="";
			if(level_3_code_length==null) level_3_code_length="";
			if(level_4_code_length==null) level_4_code_length="";
			if(level_5_code_length==null) level_5_code_length="";
			if(level_6_code_length==null) level_6_code_length="";
			if(level_7_code_length==null) level_7_code_length="";
			if(level_8_code_length==null) level_8_code_length="";
			if(level_9_code_length==null) level_9_code_length="";
			if(level_10_code_length==null) level_10_code_length="";
		}
 	if(displvlRs!=null) displvlRs.close();
	if(displvlStmt!=null) displvlStmt.close();
	}
if(!termsetid.equals(""))
{
%>
<table border='1' cellpadding='0' cellspacing='0' align='center'  width='80%' >
<tr>
	<td  class="COLUMNHEADER" colspan='2'><fmt:message key="eMR.ClassificationLevels.label" bundle="${mr_labels}"/></td>
</tr>
<!--<tr>
	<td class='ATCQRYEVEN'onclick='dispresultpg(1,"<%=termsetid%>")'><%=displvl1%></td><td class='ATCQRYEVEN'><%=level_1_code_length%></td>
</tr>-->
<tr>
	<td class='QRYEVEN'><a href="javascript:dispresultpg(1,'<%=termsetid%>')"><%=displvl1%></a></td><td class='QRYEVEN'><%=level_1_code_length%></td>
</tr>
<!--<tr>
	<td class='ATCQRYODD'onclick='dispresultpg(2,"<%=termsetid%>")'><%=displvl2%></td><td class='ATCQRYODD'><%=level_2_code_length%></td>
</tr>-->
<tr>
	<td class='QRYODD'><a href="javascript:dispresultpg(2,'<%=termsetid%>')"><%=displvl2%></a></td><td class='QRYODD'><%=level_2_code_length%></td>
</tr>
<tr>	
	<td class='QRYEVEN'><a href="javascript:dispresultpg(3,'<%=termsetid%>')"><%=displvl3%></a></td><td class='QRYEVEN'><%=level_3_code_length%></td>
</tr>
<tr>
	<td class='QRYODD'><a href="javascript:dispresultpg(4,'<%=termsetid%>')"><%=displvl4%></a></td><td class='QRYODD'><%=level_4_code_length%></td>
</tr>
<tr>
	<td class='QRYEVEN' ><a href="javascript:dispresultpg(5,'<%=termsetid%>')"><%=displvl5%></a></td><td class='QRYEVEN'><%=level_5_code_length%></td>
</tr>
<tr>
	<td class='QRYODD'><a href="javascript:dispresultpg(6,'<%=termsetid%>')"><%=displvl6%></a></td><td class='QRYODD'><%=level_6_code_length%></td>
</tr>
<tr>
	<td class='QRYEVEN' ><a href="javascript:dispresultpg(7,'<%=termsetid%>')"><%=displvl7%></a></td><td class='QRYEVEN'><%=level_7_code_length%></td>
</tr>
<tr>
	<td class='QRYODD' ><a href="javascript:dispresultpg(8,'<%=termsetid%>')"><%=displvl8%></a></td><td class='QRYODD'><%=level_8_code_length%></td>
</tr>
<tr>
	<td class='QRYEVEN' ><a href="javascript:dispresultpg(9,'<%=termsetid%>')"><%=displvl9%></a></td><td class='QRYEVEN'><%=level_9_code_length%></td>
</tr>
<tr>
	<td class='QRYODD' ><a href="javascript:dispresultpg(10,'<%=termsetid%>')"><%=displvl10%></a></td><td class='QRYODD'><%=level_10_code_length%></td>
</tr>
</table>
<%
}
}
catch(Exception e)
{
	//out.println(e);
	e.printStackTrace();
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}
%>
<INPUT TYPE="hidden" name="termcode2" id="termcode2" value="<%=termcode2%>">
<INPUT TYPE="hidden" name="termcode3" id="termcode3" value="<%=termcode3%>">
<INPUT TYPE="hidden" name="termcode4" id="termcode4" value="<%=termcode4%>">
<INPUT TYPE="hidden" name="termcode5" id="termcode5" value="<%=termcode5%>">
<INPUT TYPE="hidden" name="termcode6" id="termcode6" value="<%=termcode6%>">
<INPUT TYPE="hidden" name="termcode7" id="termcode7" value="<%=termcode7%>">
<INPUT TYPE="hidden" name="termcode8" id="termcode8" value="<%=termcode8%>">
<INPUT TYPE="hidden" name="termcode9" id="termcode9" value="<%=termcode9%>">
<INPUT TYPE="hidden" name="termcode10" id="termcode10" value="<%=termcode10%>">
<INPUT TYPE="hidden" name="className" id="className" value="">
<INPUT TYPE="hidden" name="class_lvl" id="class_lvl" value="">
</form>
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

