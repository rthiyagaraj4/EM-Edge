<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
eCA.RegEmailRecipientBean CA_RegEmailRecipientBean = (eCA.RegEmailRecipientBean)getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
CA_RegEmailRecipientBean.clearBean();

String mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
String mailer_id=(request.getParameter("mailer_id")==null)?"":request.getParameter("mailer_id");
java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
String locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");
String mailer_name="";
String email_id="";
String password="";
String from_date="";
String to_date="";
String srl_no="";
String eff_status="";
String enabled_checked1="";	
String status="";	
String readOnly="";
String authorized = "";
String checkedAuthorize = "";
String serialNumber = "";
String sqlSerialNumber = "select max(srl_no) srl_no from sm_regd_mail_user_pwd where mailer_id=? ";
Connection con=null;

	if(mode=="insert" || mode.equals("insert") || mode == null) 
	{
		mode="insert";
		enabled_checked1 = "checked";
		eff_status="E";
	}else{
		mode="update";
	}

	if(mode.trim().equalsIgnoreCase("insert")){
		status="enabled";
		readOnly = "";
		from_date		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	}
	if(mode.trim().equalsIgnoreCase("update")) 
	{
		readOnly = "readonly";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="";
		try
		{
			con =	ConnectionManager.getConnection(request);

			stmt=con.prepareStatement(sqlSerialNumber);
			stmt.setString(1,mailer_id);
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 serialNumber = (rs.getString("srl_no")==null)?"":rs.getString("srl_no");
			}
			if(rs!=null)  rs.close(); 
			if(stmt!=null)  stmt.close();

			sql ="select a.mailer_id mailer_id,a.mailer_name,a.email_id,b.srl_no,b.from_date,b.to_date, app_password.decrypt(b.password) password,a.eff_status,a.AUTHORIZE_YN from SM_REGD_MAILING_LST a, sm_regd_mail_user_pwd b where a.mailer_id=b.mailer_id(+) and a.mailer_id=? and b.srl_no(+) = ?" ;
			stmt=con.prepareStatement(sql);
			stmt.setString(1,mailer_id);
			stmt.setString(2,serialNumber);
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 mailer_id		=(rs.getString("mailer_id")==null)?"":rs.getString("mailer_id");
				 mailer_name		=(rs.getString("mailer_name")==null)?"":rs.getString("mailer_name");
				 email_id		=(rs.getString("email_id")==null)?"":rs.getString("email_id");
				 authorized		=(rs.getString("AUTHORIZE_YN")==null)?"N":rs.getString("AUTHORIZE_YN");
				 srl_no		=(rs.getString("srl_no")==null)?"":rs.getString("srl_no");
				 from_date		=(rs.getString("from_date")==null)?"":rs.getString("from_date");
				 to_date		=(rs.getString("to_date")==null)?"":rs.getString("to_date");
				 password		=(rs.getString("password")==null)?"":rs.getString("password");
				 
				 eff_status		=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
				 /*Thai date validations 29/07/2008 start */
				if(from_date==null || from_date.equals("null") || (from_date.equals(""))) from_date="";
				if(to_date==null || to_date.equals("null") || (to_date.equals(""))) to_date="";
				if(!locale.equals("en")){
				from_date = com.ehis.util.DateUtils.convertDate(from_date,"DMYHM","en",locale);
				to_date=com.ehis.util.DateUtils.convertDate(to_date,"DMYHM","en",locale);
				}
				/*Thai date validations 29/07/2008 end */
							 				 						
			}

			if(rs!=null)  rs.close(); 
			if(stmt!=null)  stmt.close();
	}catch(Exception e){
		
		//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
	if(eff_status.equals("E")){
		status="enabled" ;		
		enabled_checked1 = "checked";
		}else{
		status="disabled"; 		
		enabled_checked1 = "";
		}
	}

	if(authorized.equals("Y"))
	{
		checkedAuthorize = " checked  disabled";
	}
	else
	{
		checkedAuthorize = "";
	}
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="RegEmailRecipientForm" id="RegEmailRecipientForm" action="../../servlet/eCA.RegEmailRecipientServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding='3' width='90%' align=center>
<tr>
	<td class=label><fmt:message key="eCA.RegisteredRecipientID.label" bundle="${ca_labels}"/></td>
	<td class='fields' colspan=2>&nbsp;<input type="text" name="mailerId" id="mailerId" size=4 maxlength=4  value="<%=mailer_id%>" <%=status%> <%=readOnly%> onkeypress="return CheckForSpecChars(event)"  
	onBlur='ChangeUpperCase(this);' ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="eCA.RegisteredRecipientName.label" bundle="${ca_labels}"/></td>
	<td class='fields' colspan=2 >&nbsp;<input type="text" name="mailerName" id="mailerName" value="<%=mailer_name%>" <%=status%> size=30 maxlength=100  onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.EmailId.label" bundle="${ca_labels}"/></td>
	<td class='fields' colspan=2>&nbsp;<input type="text" name="emailId" id="emailId" value="<%=email_id%>" <%=status%> maxlength='100' size='34.5' onBlur="return chkValidEmail(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2'><input type="checkbox" name="authoriseChkBox" id="authoriseChkBox" value="" <%=checkedAuthorize%>  OnClick ='checkForPassword(this)'></td>
</tr>
<tr><td class="label" ><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
<%if(mode.equals("update")){%>	
	<td class='fields' colspan='2'>&nbsp;<input type="password" name="password" id="password" value="<%=password%>" readonly size='8' maxlength='8' autocomplete="off">&nbsp;<input type="button" class='button' name="pwd_history" id="pwd_history" id='pwdHistID' value='<fmt:message key="eCA.ManagePassword.label" bundle="${ca_labels}"/>' onclick="managePwd()">   <!--41670 autocomplete="off"-->
<%}else{%>
	<td class='fields'>&nbsp;<input type="password" name="password" id="password" value="<%=password%>" readonly size='8' maxlength='8' autocomplete="off">   <!--41670 autocomplete="off"-->
<%}%>
&nbsp;<a href='#' onclick="viewPwd()" id='viewPwdID' style='display:none'><fmt:message key="Common.view.label" bundle="${common_labels}"/></a></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2'><input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=enabled_checked1%> OnClick ='checkForMode(this)'></td>
</tr>

</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="mailer_id" id="mailer_id" value="<%=mailer_id%>">
<input type=hidden name="mailer_name" id="mailer_name" value="<%=mailer_name%>">
<input type=hidden name="email_id" id="email_id" value="<%=email_id%>">
<input type=hidden name="srl_no" id="srl_no" value="<%=srl_no%>">
<input type=hidden name="from_date" id="from_date" value="<%=from_date%>">
<input type=hidden name="to_date" id="to_date" value="<%=to_date%>">
<input type=hidden name="authorized" id="authorized" value="<%=authorized%>">
</form>
</body>
</html>
<%putObjectInBean("CA_RegEmailRecipientBean",CA_RegEmailRecipientBean,session);	
%>
<script>
	if(document.getElementById("pwdHistID") != null)
	{
		if('<%=authorized%>' != 'Y')
			document.getElementById("pwdHistID").style.display = 'none';
		else
			document.getElementById("pwdHistID").style.display = 'inline';
	}
</script>

