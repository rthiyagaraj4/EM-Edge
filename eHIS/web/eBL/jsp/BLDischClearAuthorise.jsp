<!DOCTYPE html>
<%@ page      import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*,org.apache.commons.codec.binary.Base64" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/FieldFormatMethods.js'></Script>
<script language="javascript" src="../js/BLDischClear.js"></script>
<script language="javascript" src="../../eBL/js/BLDischClearCancel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%= request.getParameter("title")%> </title> 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	try
	{	
		String facilityId = (String)session.getAttribute("facility_id");
		String login_user = checkForNull(request.getParameter("login_user"));
		String window_name = checkForNull(request.getParameter("p_window"));
		String p_privilege_val = checkForNull(request.getParameter("p_privilege_val"));
		String doc_num = checkForNull(request.getParameter("doc_num"));
		String pat_outs_bill = checkForNull(request.getParameter("pat_outs_bill"));	
		float patOutsBill = 0;
		if(!"".equals(pat_outs_bill))
			patOutsBill = Float.parseFloat(pat_outs_bill);
		
		int reasonFlagYN = 1;
		String pin_num = "";
		int sqlSelect = 1;
		if("".equals(window_name))
			sqlSelect = 2;
		System.err.println("sqlSelect is: "+sqlSelect);
		if(!"".equals(login_user))
		{
			try
			{				
				con=ConnectionManager.getConnection(request);
				
				String sqlFacility = "select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id= ? ";
						
				pstmt = con.prepareStatement(sqlFacility);
				pstmt.setString(1,login_user);
				
				rst = pstmt.executeQuery();

				if(rst != null){
					while(rst.next()){ 
						pin_num=rst.getString("pass_wd");
					}
				} 
			}catch(Exception e){
				System.err.println("Exception in BLDischClearAuthorise.jsp-pin: "+e);
			}
		}
%>
	<center>
	<form name='AuthForm' id='AuthForm'>
	<table border='0' cellpadding='1' cellspacing='0' align='center' width='100%'>
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
		<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
		<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' id='user_id' size='20' maxlength='20' onKeyPress='return changeToUpper()' value='<%= "".equals(login_user) ? "" : login_user %>'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
		<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
		<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' id='passwd' size='21' maxlength='64' value='<%= "".equals(pin_num) ? "" : pin_num  %>'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<% if(!(!"".equals(doc_num) && (patOutsBill <= 0) &&  p_privilege_val.equals("N"))){%>
	<tr>
		<td width="50%" class="label" ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td class="fields">			
		<input type='text' name='reason_code' id='reason_code' size='5' id='reason_code' value='' onblur='if(this.value!=""){callAuthReasonDialog(1,<%=sqlSelect%>);}else{fnclearCode(reason_code,reason_value);}' >
		&nbsp;<input type='text' name='reason_value' id='reason_value' id='reason_value' value='' onblur='if(this.value!=""){callAuthReasonDialog(2,<%=sqlSelect%>);}else{fnclearCode(reason_code,reason_value);}' >
		<input type='button' class='button' name="reasonbtn" id="reasonbtn" value='?' onClick='callAuthReasonDialog(2,<%=sqlSelect%>);'/>
			
		<img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<%}else{%>
		<input type="hidden" name='reason_code' id='reason_code' id='reason_code' value='<%=reasonFlagYN%>'>
	<%}%>
	<tr>
		<td width="50%" class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td width="50%" class="fields">
			<textarea name='remarks' id='remarks' rows="2" cols="25" onKeyPress='checkMaxLimit(this,50)' value=''></textarea><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr> <td></td> </tr>
	<tr> <td></td> </tr>
	<tr> <td></td> </tr>
	<tr> <td></td> </tr>
	<tr>
		<% if(!"".equals(window_name)){  %>
		<td align="right">
			<input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" onClick ='confirmPasswdchk();'>
		</td>
		<td align="left">
			<input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.exit.label","bl_labels")%>"  onClick='cancelRecord();'>
		</td>
		<%}else{ %>
		<td align="right">
			<input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" onClick ='cancelClearanceConfirmPasswdchk();'>
		</td>
		<td align="left">
			<input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.exit.label","bl_labels")%>"  onClick='cancelClearanceCancelRecord();'>
		</td>
		<% } %>
	</tr>	
	</table>
	
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
	<input type="hidden" name="window_name" id="window_name" value="<%=window_name%>">
		
	</form>
	</center>
</body>
</html>
<%
	}catch(Exception e){
			out.println("Exception in BLDischClearAuthorise.jsp: "+e);
			System.err.println("Exception in BLDischClearAuthorise.jsp: "+e);
	}finally{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(con,request);		
	}
%>

