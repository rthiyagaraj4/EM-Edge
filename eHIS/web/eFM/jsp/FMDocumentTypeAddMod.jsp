<!DOCTYPE html>
<%@ page import=" java.sql.*,java.text.*,webbeans.eCommon.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
%>
<HTML>
<HEAD>
<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT language='javascript' src='../../eFM/js/FMDocumentType.js'></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
function ValidString(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)||(event.keyCode==32)))
	{
		return true
	}
	else
	{	
		return false
	}
}
function curser_focus()
{
	document.DocumentType_Form.doc_type_code.focus();
}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<style>
textarea {
  resize: none;
}
</style>
<BODY onMouseDown='CodeArrest();' onLoad='curser_focus();' onKeyDown = 'lockKey();'>
<%
	String operation = "insert";
	String doc_type_code = "";
	String doc_type_name = "";
	String doc_desc = "";
	String doc_no = "";
	String eff_status = "";
	String check = "checked";
	String readonly="";
	String code = request.getParameter("doc_fld_id");
	try{	
		con = ConnectionManager.getConnection(request);
		stmt= con.createStatement();
		if(code == null) 		
			code = "";
		else
		{
			check = "";
			operation  = "modify";
			readonly = "readonly";
			pstmt = con.prepareStatement("select * from fm_doc_type where doc_type_code=?");
			pstmt.setString(1,code);
			rset=pstmt.executeQuery();
			rset.next();
			doc_type_code = checkForNull(rset.getString("DOC_TYPE_CODE"));
			doc_type_name = checkForNull(rset.getString("DOC_TYPE_NAME"));
			doc_desc = checkForNull(rset.getString("DOC_DESC"));
			doc_no = checkForNull(rset.getString("DOC_NO"));
			eff_status = checkForNull(rset.getString("EFF_STATUS"));
			if(eff_status.equals("E"))
				check="checked";
			else
				check="";
		}
	if(rset	 != null)   rset.close();
	if(pstmt != null)	pstmt.close();
	if(stmt != null)	stmt.close();
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
<FORM name='DocumentType_Form' id='DocumentType_Form' action='../../servlet/eFM.FMDocumentTypeServlet' method='post' target='messageFrame'>
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<TABLE border='0' cellpadding='5' cellspacing='0' width='80%' align='center'>
<TR>
	<TD class='label' width='30%' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
	<TD class='fields' width='70%' ><INPUT type='text' name='doc_type_code' id='doc_type_code' value='<%=doc_type_code%>' size='6' maxlength='3' <%=readonly%> onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);" >
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
</TR>
<TR>
	<TD class='label' width='30%' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></TD>
	<TD class='fields' width='70%' ><INPUT type='text' name='doc_type_name' id='doc_type_name' value='<%=doc_type_name%>' size='40' maxlength='60' onkeypress="return ValidString(event)">
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
</TR>
<TR>
	<TD class='label' width='30%' ><fmt:message key="Common.description.label" bundle="${common_labels}"/>
	<TD class='fields' width='70%' ><TEXTAREA NAME="doc_description" COLS="35" maxlength='200' onkeypress="return ValidString(event)" onBlur="checkLength(this)"><%=doc_desc%></TEXTAREA>
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
</TR>
<TR>
	<TD class='label' width='30%' ><fmt:message key="eFM.DocumentID.label" bundle="${fm_labels}"/></TD>
	<TD class='fields' width='70%' ><INPUT type='text' name='doc_number' id='doc_number' value='<%=doc_no%>' size='15' maxlength='15' onkeypress="return ValidString(event)">
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
</TR>
<TR>
	<TD class='label' width='30%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
	<TD class='fields' width='70%' ><INPUT type='checkbox' name='eff_status' id='eff_status' value='E' onblur='curser_focus();' <%=check%>></TD>
</TR>
</TABLE>
<input type="Hidden" name="operation" id="operation" value="<%=operation%>">
</FORM>
<%!
     public static String checkForNull(String inputString)
	 {
		 return((inputString==null)? "": inputString);
	 }
%>
</BODY>
</HTML>
	

