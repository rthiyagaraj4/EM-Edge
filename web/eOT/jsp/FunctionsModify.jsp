<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Functions.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.commontoolbarFrame.document.forms[0].reset.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body onLoad="parent.commontoolbarFrame.document.forms[0].reset.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
PreparedStatement stmt1=null;
ResultSet rs1=null;
String mode=request.getParameter("mode");
//out.println(mode);
String function_id = request.getParameter("function_id")==null?"":request.getParameter( "function_id" );
String chk_checked="";
String chk_checked1="";
String chk_checked2="";


String chk_value1="";
String chk_value2="";
String chk_value3="";
String disable_flag="";
String function_id_disable="";
String function_desc_sys="";
String function_desc_disable="";
String function_desc_user="";
String url_desc =""; 
String url_disable =""; 
String linked_status_code="";
String linked_status_desc="";
String linked_status_desc_disable="";
String check_for_check_list_compl="";
String allow_barcode="";
String verification_applicable="";
String linked_status_desc1="";
String sql = "";
if(mode.equals("modify"))
{
	try{
	con=ConnectionManager.getConnection(request);

//sql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE, B.STATUS_DESC LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC FROM OT_FUNCTIONS A, OT_STATUS B WHERE A.LINKED_STATUS_CODE = B.STATUS_CODE (+) and a.function_id=? ";

//		sql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE, B.STATUS_DESC LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC FROM OT_FUNCTIONS_LANG_VW A, OT_STATUS B WHERE A.LANGUAGE_ID ='"+locale+"' AND A.LINKED_STATUS_CODE = B.STATUS_CODE (+) AND A.FUNCTION_ID=? ";

//sql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE, B.STATUS_DESC LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC FROM OT_FUNCTIONS_LANG_VW A, OT_STATUS_LANG_VW B WHERE A.LANGUAGE_ID ='"+locale+"' AND B.LANGUAGE_ID ='"+locale+"' AND A.LINKED_STATUS_CODE = B.STATUS_CODE (+) AND A.FUNCTION_ID=? ";

sql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE, GET_DESC(?,'OT_STATUS_LANG_VW','STATUS_DESC','STATUS_CODE',A.LINKED_STATUS_CODE) LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC FROM OT_FUNCTIONS_LANG_VW A, OT_STATUS B WHERE A.LANGUAGE_ID =? AND A.LINKED_STATUS_CODE = B.STATUS_CODE (+) AND A.FUNCTION_ID=? ";

		 
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);		
		stmt.setString(2,locale);		
		stmt.setString(3,function_id);		
		rs=stmt.executeQuery();
		
		if(rs!=null && rs.next())
		{
			function_id=rs.getString(1);
			function_desc_sys=rs.getString(2);
			function_desc_user=rs.getString(3);
			linked_status_code=checkForNull(rs.getString(4));
		    linked_status_desc=checkForNull(rs.getString(5));
			check_for_check_list_compl=rs.getString(6);
            allow_barcode=rs.getString(7);
			verification_applicable=rs.getString(8);
            url_desc=rs.getString(9);
			
		}
       if(linked_status_code==null || linked_status_code.equals("null"))
	     {
		   linked_status_code="";
	       linked_status_desc="";
          }
	   if(url_desc==null || url_desc.equals("null"))
		   url_desc="";
	     
		
		if(check_for_check_list_compl.equals("Y"))
	     {
            //check_for_check_list_compl="Y";
			chk_checked="checked";
			chk_value1="Y";
			disable_flag="";
			
		 }
		 else
	       {
			 disable_flag="disabled";
			 //check_for_check_list_compl="N";
			 chk_checked="";
			 chk_value1="N";
		   }
		if(allow_barcode.equals("Y"))
	    {
			//allow_barcode="Y";
			 chk_checked1="checked";
			chk_value2="Y";
			disable_flag="";
			 
		}
		else
	       {
			 disable_flag="disabled";
			 //check_for_check_list_compl="N";
			 chk_checked1="";
			 chk_value2="N";
		   }
		if(verification_applicable.equals("Y"))
		{
			chk_checked2="checked";
			chk_value3="Y";
			disable_flag="";
			
			
			
		}
		else
		{
			disable_flag="disabled";
			 //check_for_check_list_compl="N";
			 chk_checked2="";
			 chk_value3="N";
		}

		
		
	function_id_disable="disabled";	
	function_desc_disable="disabled";
	url_disable="disabled";
//	linked_status_desc_disable="disabled";

}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("here "+e);
    }finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		   }catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
		    }
		}
}

%>
<form name="functions_form" id="functions_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.FunctionsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3  width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="function_id" id="function_id" value="<%=function_id%>" size=2 maxlength=2  <%=function_id_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ></td>
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.SystemDefinedDescription.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="function_desc_sys" id="function_desc_sys" value="<%=function_desc_sys%>"  size=40 maxlength=40 <%=function_desc_disable%>>
	</td>
</tr>
<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
		<input type="text" name="function_desc_user" id="function_desc_user" value="<%=function_desc_user%>"   size='40' maxlength='40' >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.URL.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="url_desc" id="url_desc" value="<%=url_desc%>"   size='50' maxlength='50' <%=url_disable%>>
	
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.LinkedStatus.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	 <input type='hidden' name='linked_status_code' id='linked_status_code' value="<%=linked_status_code%>" > 
	<input type="text" name="linked_status_desc" id="linked_status_desc" value="<%=linked_status_desc%>"   size='40' maxlength='40' <%=linked_status_desc_disable%> onBlur="if(this.value!='')searchCode(linked_status_code, linked_status_desc, 'Status', document.forms[0].sql_status.value); else linked_status_code.value='' " disabled>
	<!-- <input type='button' class='button' value='?' name='linklkp' id='linklkp' onClick="searchCode(linked_status_code, linked_status_desc, 'Status', document.forms[0].sql_status.value)" > -->
	
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.CheckForChecklistCompleted.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="checkbox" name="check_for_check_list_compl" id="check_for_check_list_compl" onClick='checkforchecklistcompl();' value='<%=chk_value1%>' <%=chk_checked%>></td>
	
</tr>
<%
if(function_id.equals("01") || function_id.equals("05")){
%>
<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.AllowBarcode.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="checkbox" name="allow_barcode" id="allow_barcode" onClick='allowBarcode();' value='<%=chk_value2%>' <%=chk_checked1%>></td>
</tr>
<%}else{
%>
	<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.AllowBarcode.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="checkbox" name="allow_barcode" id="allow_barcode" onClick='' value=''disabled></td>
</tr>
<%}%>

<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.VerificationApplicable.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="checkbox" name="verification_applicable" id="verification_applicable" onClick='verificationApplicable();' value='<%=chk_value3%>' <%=chk_checked2%> ></td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=function_id1 value="<%=function_id%>">
<input type=hidden name=function_desc_sys1 value="<%=function_desc_sys%>">
<input type=hidden name=function_desc_user1 value="<%=function_desc_user%>">
<input type=hidden name=linked_status_code1 value="<%=linked_status_code%>">
<input type=hidden name=url_desc1 value="<%=url_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="sql_status" id="sql_status" value="SELECT STATUS_DESC DESCRIPTION, STATUS_CODE CODE FROM OT_STATUS_LANG_VW where upper(STATUS_DESC) like upper(?) and upper(STATUS_CODE) like upper(?)order by 1" disabled>
</form>
</body>
</html>


