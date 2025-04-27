<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	 
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 	<script language='javascript' src='../../eCommon/js/common.js'></script> 
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='javascript' src='../../eMP/js/genPatWithNatIdCreate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>

<body onLoad="FocusFirstElement()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='generatePatIdForm' id='generatePatIdForm' method='post' action='../../servlet/eMP.genPatWithNatIdServlet' target="messageFrame">
<%

	try
	{
		
		String patient_id_length	= request.getParameter("patient_id_length")==null?"0":request.getParameter("patient_id_length");
		String nat_id_accept_alphanumeric_yn	= request.getParameter("nat_id_accept_alphanumeric_yn")==null?"N":request.getParameter("nat_id_accept_alphanumeric_yn");
		String nat_id_check_digit_id	= request.getParameter("nat_id_check_digit_id")==null?"":request.getParameter("nat_id_check_digit_id");
		String nat_id_prompt		= request.getParameter("nat_id_prompt");
		String nat_id_length		= request.getParameter("nat_id_length");
		String invoke_routine		= request.getParameter("invoke_routine");
		String invoke_routine_name	= request.getParameter("invoke_routine_name");
		String nat_id_chk_len	= request.getParameter("nat_id_chk_len");





		String nat_id_onKeyPress	= "";
		if(nat_id_prompt!=null && nat_id_prompt.equals("")){
			nat_id_prompt=java.net.URLDecoder.decode(nat_id_prompt);
		}
		if(nat_id_accept_alphanumeric_yn.equals("Y")) {
			nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
		} else {
			if(nat_id_check_digit_id.equals("M11"))
				nat_id_onKeyPress = "CheckForCharsNatID(event);";
			else
				nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
		}




		%>
		<table width='100%' border='0' cellspacing='0' cellpadding='5'>
			
			<tr>
				<td align='left' width='15%' class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
				<td  align="left" width="25%"><input type=text name='patientId' id='patientId' size="20" value = '' maxlength="<%=patient_id_length%>" onBlur='getPatientStatus(this.value),changeCase(this)' 
					onKeyPress='return CheckForSpecChars(event)'  /><input type='button' name='pat_id' id='pat_id' value='?' class='button' onclick='PatSearch()'>
					&nbsp;<img src='../images/mandatory.gif'></img></td>
				<td>&nbsp;</td>
				<td  width='25%'>&nbsp;</td>
			</tr>
			<tr>
				<td align='left' width='15%' class="label">
					<%=nat_id_prompt%>&nbsp;</td>
				<td  align="left" width="25%"><input type=text name='nationalId' id='nationalId' size="20" value = '' disabled onkeypress='return <%=nat_id_onKeyPress%>' maxlength='<%=nat_id_length%>'  onBlur='validateNationality(this,"<%=nat_id_accept_alphanumeric_yn%>","<%=invoke_routine%>","<%=invoke_routine_name%>","<%=nat_id_check_digit_id%>","<%=nat_id_chk_len%>","<%=nat_id_length%>");'/>
					&nbsp;<img src='../images/mandatory.gif' id="nat_id_gif" style="visibility:hidden"></img></td>
				<td  width='25%'>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			
		</table>
				
			<input type='hidden' name="nat_id_prompt" id="nat_id_prompt" value="<%=nat_id_prompt%>" >
			<input type='hidden' name="nat_id_accept_alphanumeric_yn" id="nat_id_accept_alphanumeric_yn" value="<%=nat_id_accept_alphanumeric_yn%>" >
		
			</form>
		<%
      
	
	} catch(Exception e)	{
		//out.println(e);
		e.printStackTrace();
	} finally {
		
	}
%>
</body>
</html>

