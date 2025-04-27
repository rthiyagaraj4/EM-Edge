<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
15/03/2023		IN41670								15/03/2023								<Security>Privacy Violation: Autocomplete:AuthorizePinAccess.jsp
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCA.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	}
  String path = request.getContextPath(); 
  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>

<link href="<%=path%>/eCommon/html/login.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src="<%=path%>/eCA/js/CATabLogin.js" language="javascript"></script>
	<script type="text/javascript">
		var contextPath = "<%=path%>";
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 
</head>

<body>

<form id='login_form' name='login_form' id='login_form' method="post" action="<%=path%>/tablogin" class="mform">
<div id="Maincontainer">		
    <div id="Contentcontainer" style="background-image:url('../../eCommon/images/LoginBg.jpg')">
       	<div id="Contentcontainerbg" >
       	  <table align="center" width="637px" height="425px" border="0" cellspacing="0" cellpadding="0" style="background-image:url('../../eCommon/images/LoginWidget.png')">
     <tr>
    <td height="140" colspan="2" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tr>
        <td  class="version">12.9.1</td>
      </tr>
      <tr>
        <td style="padding-right:20px;" align="right" class="version">&nbsp;</td>
      </tr>
    </table></td>
  </tr>

	<tr>
			<td width="387" valign="top" style="padding-left:40px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr><td>&nbsp;</td>      </tr>
     
	  <tr><td>&nbsp;</td>
											<td class="username" id="displayUserID" style="display:none">
											</td><td>&nbsp;</td>
										</tr>
      <tr>
        <td class="heading" height="35px" id="userNameID" >User ID</td>
      </tr>
		<tr>
        <td id="userNameTextID" class="heading">
          <input name="name" id="name" style="padding-top:5px;"  type="text" size="46" maxlength="40" height="30px" onkeypress="" onblur="" onkeydown="" tabindex="1"/ AUTOCOMPLETE="OFF" class="inputH" />
       </td>
      </tr>
		<tr>
        <td class="heading" id="passwordID" height="35px">Password </td>
      </tr>
      <tr>
        <td id="passwordTextID"><span class="heading">
          <input class="inputH" style="padding-top:3px;" name="password" id="password" type="password" size="47" maxlength="30" onkeypress="" onkeydown="" tabindex="2" autocomplete="off" />  <!--41670 autocomplete="off"-->
        </span></td>
      </tr>
	   <tr>
        <td>&nbsp;</td>
      </tr>
 <tr>
        <td><table align="left" border="0" cellspacing="0" cellpadding="0" >
          <tr>
            <td><table  style="border-collapse: collapse;">
              <tr>
			  <td width="8px">&nbsp;</td>
                <td width="auto" height="36px;">
                	<input type="button" value="Login" class="button" style="cursor:pointer; color:#FFFFFF;" tabindex="3"  onclick="submit_user_pwd()" />
                </td>
                <td>&nbsp</td>
              </tr>
            </table></td>
            <td>&nbsp;&nbsp; </td>
            <td><table style="border-collapse: collapse;">
              <tr>
                <td width="8px">&nbsp;</td>
                <td width="auto"><input type="button" class="button" tabindex="4" onclick="" onkeypress="" id="cancelID" style="cursor:pointer;color:#FFFFFF;" value="Cancel" /></td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>

		<tr>
        <td>&nbsp;</td>
      </tr>
		 </table></td>
    <td ><table width="250px" border="0" cellspacing="0" cellpadding="0">
	

	<tr>
        <td align="left">Logo</td>
        <td width="90%" class="heading" ><span style="width:100px;">DXC</span></td>
      </tr>


      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr id="errMSGID0" style="display:none">
        <td colspan="2"><img src="../../eCommon/images/Alert.png" /></img>
		<span id="errMSGID" class="loginError" style="font-color:red;"></span></td>
      </tr>
  <tr >
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      </table></td>
  </tr>
  </table>
</div>
</div>
</div>  
		<input type="hidden" name="mode" id="mode" value="begin"/> 
		<input type="hidden" name="responsibility_id" id="responsibility_id" id="responsibility_id" value=""/>
		<input type="hidden" name="responsibility_name" id="responsibility_name" id="responsibility_name" value=""/> 
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value=""/> 
		<input type="hidden" name="login_user" id="login_user" id="login_user" value="null"/>
		<input type="hidden" name="facility_name" id="facility_name" id="facility_name" value=""/> 
		<input type="hidden" name="level" id="level" id="level" value="1"/> 
		<input type="hidden" name="clientIP" id="clientIP" id="clientIP" value=""/> 
		<input type="hidden" name="user" id="user" id="user" value=""/> 
		<input type="hidden" name="compname" id="compname" value="TAB" id="compname"/> 
		<input type="hidden" name="domain" id="domain" id="domain" value=""/> 
		<input type="hidden" name="error_num" id="error_num" id="error_num" value="0"/> 
		<input type="hidden" name="locale" id="locale" id="locale" value="en"/>
		<input type="hidden" name="RespFaciList" id="RespFaciList" id="RespFaciList" value="en"/>   
</form>
</body>
</html>

