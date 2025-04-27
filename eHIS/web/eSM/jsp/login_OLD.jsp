<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/WEB-INF/tld/iba-autocompletetag.tld" prefix="ibaAutoComplete" %>
<% 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	}
  
/* String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";*/
  %>
<head>
	 <link href="../../eCommon/html/login.css" rel="stylesheet" type="text/css" /> 
	<!-- <link href="../../eCommon/html/style.css" rel="stylesheet" type="text/css" /> -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="requiresActiveX=true"/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eSM/js/login.js" language="javascript"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/logout.js" language="javascript"></script>

	<ibaAutoComplete:setup></ibaAutoComplete:setup>	
</head>
<%
	Connection con =null ;
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{

	request.setCharacterEncoding("UTF-8");

	
	String level				= request.getParameter( "level" ) ;
	String error_num			= request.getParameter( "error_num" ) ;
	if(error_num==null)
		error_num="0";
	String resp_count			= request.getParameter( "resp_count" ) ;
	int count_res=0;
	String checklogin			= request.getParameter( "invalidlogin" ) ;
	String name 				= (String) session.getValue( "login_user" ) ;
	String login_user 			= (String) session.getValue( "login_user" ) ;
	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;
	String responsibility_name	= (String) session.getValue( "responsibility_name" ) ;
	String has_resp	= request.getParameter( "resp" ) ;

	Properties p;
	String userName="";
	if(has_resp==null)
		has_resp="";
	String locale = null;
	String mode="begin";
	String change_pass="";
	String user_name_pass="";

	if ( level 			== null ) level 			= "" ;
	if ( checklogin 	== null ) checklogin 			= "N" ;
	if ( name 			== null ) name 			= "" ;
	if ( responsibility_id 	== null ) responsibility_id	= "" ;
	if ( responsibility_name== null ) responsibility_name = "" ;
	
	if ( level.equals( "" ) ) {
		level = "1" ;
	}
	locale = (String)session.getValue("LOCALE");
	if(level.equals("1")){
		if(locale == null || locale.equals("")){
			Locale  lc = request.getLocale();
			locale= lc.toString().substring(0,2);
			session.putValue("LOCALE",locale);
		}
	}
	locale = (locale == null || locale.equals(""))?"en":locale;
	if(level.equals("1")){
	change_pass=request.getParameter( "change_pass" );
	user_name_pass=request.getParameter( "user_name_pass" );
	if(change_pass==null) change_pass="";
	}
	if ( level.equals( "2" ) ){
	 count_res=Integer.parseInt(resp_count);
	}
	if(level.equals("2")){
	p=( java.util.Properties ) session.getValue( "jdbc" ) ;
	userName=p.getProperty("appl_user_name");
	if(userName==null || userName.equals(""))
		userName="";
	}
	request.setCharacterEncoding("UTF-8");
	String product_name="";
	String product_description="";
	String version_info="";
	String copyright_info="";
	String site_name="";
	String proxy_check="0";
	String case_sensitive_password_yn="";//Maheshwaran added for the MMS-QH-CRF-0149
	String allowed_spl_char_in_password="";
	String enforce_password_policy_yn="";
	String first_login_change_password_yn="";//Added by Maheshwaran for AMs-CRF-0098
	String change_password_mandatory_yn="";//Added by Maheshwaran for AMs-CRF-0098
	String multiple_login_allowed_yn	= "";//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
	try{
		//Maheshwaran modified for the MMS-QH-CRF-0149
		//Modified By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME,(select count(*) from sm_function_control x,sm_site_param y where module_id='SM' and FUNCTIONALITY_ID='CHECK_PROXY'        and x.site_id=y.customer_id) proxy_check,b.case_sensitive_password_yn,b.allowed_spl_char_in_password,b.enforce_password_policy_yn,b.first_login_change_password_yn,b.change_password_mandatory_yn,b.multiple_login_allowed_yn from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
		if(pstmt!=null)
			pstmt.close();
		pstmt=con.prepareStatement(inst_info) ;
		if(rs!=null)rs=null;
		rs=pstmt.executeQuery() ;
		if(rs!=null && rs.next()){
			product_name=rs.getString("PRODUCT_NAME");
			product_description=rs.getString("PRODUCT_DESCRIPTION");
			version_info=rs.getString("VERSION_NO");
			copyright_info=rs.getString("COPYRIGHT_INFO");
			site_name=rs.getString("SITE_NAME");
			proxy_check=rs.getString("proxy_check");
			case_sensitive_password_yn=rs.getString("case_sensitive_password_yn");//Maheshwaran added for the MMS-QH-CRF-0149
			allowed_spl_char_in_password=rs.getString("allowed_spl_char_in_password");//Maheshwaran added for the MMS-QH-CRF-0149
			enforce_password_policy_yn=rs.getString("enforce_password_policy_yn");//Maheshwaran added for the MMS-QH-CRF-0149
			first_login_change_password_yn=rs.getString("first_login_change_password_yn");//Added by Maheshwaran for AMs-CRF-0098
			change_password_mandatory_yn=rs.getString("change_password_mandatory_yn");//Added by Maheshwaran for AMs-CRF-0098
			multiple_login_allowed_yn	= rs.getString("multiple_login_allowed_yn");//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
			}
		if(version_info==null || version_info.equals(""))
		version_info="";
		if(copyright_info==null || copyright_info.equals(""))
			copyright_info="";
		session.setAttribute("version_no",version_info);
		session.setAttribute("product_description",product_description);
	}catch(Exception ex){
		ex.printStackTrace();
	}

%>
<script>
		var localeName = "<%=locale%>";
/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/
	window.onbeforeunload = function (e) {
		if(document.getElementById("action").value=="logout"){
			fnLogout(document.getElementById('login_user').value);
		}
	}
	/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/
	</script>

</head>
<body class="main" <%if(level.equals("1")){%>onLoad="window.document.title='<%=product_name%>';getLabels();Focusing('name')"<%}else if(level.equals("2")){%>onLoad="loadResp();"<%}%> scroll="no" style="border:0px;">

		 <script Language="vbscript">
			On Error Resume next
			Dim everyvisit
			Dim ProxyEnable
			Dim ProxyOverride
			Dim url
			Set WSHShell = CreateObject("WScript.Shell")

			everyvisit = WSHShell.RegRead("HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\SyncMode5")
			ProxyEnable=WSHShell.RegRead("HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyEnable")
			ProxyOverride=WSHShell.RegRead("HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyOverride")
					
			url=window.location.href 
		
			If everyvisit <> 3  Then
				MsgBox "Your browser setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator"
				window.opener="SOMETHING"
				close()
			End If
			If <%=proxy_check%> = 1 and ProxyEnable = 1 and InStr(ProxyOverride,";<local>") =0  Then			
				MsgBox "Your proxy setting is not proper, Application usage will result in inconsistency.. Please contact System Administrator"
				window.opener="SOMETHING"
				close()
			End If
	 </script>

<form name="login_form" id="login_form" method="post" action="../../servlet/eSM.LoginResponseServlet"  >
<%if(level.equals("1")){%>

<div id="Maincontainer">		
    <div id="Contentcontainer" style="background-image:url('../../eCommon/images/LoginBg.jpg')">
       	<div id="Contentcontainerbg" >
       	  <table align="center" width="637px" height="425px" border="0" cellspacing="0" cellpadding="0" style="background-image:url('../../eCommon/images/LoginWidget.png')">
     <tr>
    <td height="140" colspan="2" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tr>
        <td  class="version"><%=version_info%></td>
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
          <input name="name" id="name" style="padding-top:5px;"  type="text" size="46" maxlength="40" height="30px" onkeypress="checkvisible();return CheckForSpecChars(event);checkuser_event(event)" onblur="checkvisible()" onkeydown="return noescUser()" tabindex="1"/ AUTOCOMPLETE="OFF" class="inputH" />
       </td>
      </tr>
		<tr>
        <td class="heading" id="passwordID" height="35px">Password </td>
      </tr>
      <tr>
        <td id="passwordTextID"><span class="heading">
          <input class="inputH" style="padding-top:3px;" name="password" id="password" type="password" size="47" maxlength="30"  
												onkeypress="login_enter_event(event)" onkeydown="return noescPassword()" tabindex="2"/>
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
			  <td width="8px"><img src="../../eCommon/images/buttonLeft.PNG" onclick="check_user_password();" style="cursor:pointer" /></td>
                <td width="auto" height="36px;"><input type="button" class="button" id="loginID" style="cursor:pointer; color:#FFFFFF;" tabindex="3" onclick="check_user_password();" onkeypress="check_user_password_event(event)" value="Login" /></td>
                <td><img src="../../eCommon/images/ButtonRight.PNG" onclick="check_user_password();" style="cursor:pointer" /></td>
              </tr>
            </table></td>
            <td>&nbsp;&nbsp; </td>
            <td><table style="border-collapse: collapse;">
              <tr>
                <td width="8px"><img src="../../eCommon/images/buttonLeft.PNG" onclick="cancelbutton();" style="cursor:pointer" /></td>
                <td width="auto"><input type="button" class="button" tabindex="4" onclick="cancelbutton()" onkeypress="cancelbutton_event(event)" id="cancelID" style="cursor:pointer;color:#FFFFFF;" value="Cancel" /></td>
                <td><img src="../../eCommon/images/ButtonRight.PNG" width="8" height="36" style="cursor:pointer" onclick="cancelbutton();" /></td>
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
        <td align="left"><img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo"  width="57" height="51" valign="middle" /></td>
        <td width="90%" class="heading" ><span style="width:100px;"><%=site_name%></span></td>
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
       	       
				
				

										
										
										
										
										
									
											
											
        	
    
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="responsibility_id" id="responsibility_id" value="">
	<input type="hidden" name="responsibility_name" id="responsibility_name" value="">
	<input type="hidden" name="facility_id" id="facility_id" value="">
	<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
	<input type="hidden" name="dfltFacilityId" id="dfltFacilityId" value="">
	<input type="hidden" name="dfltFacilityIdName" id="dfltFacilityIdName" value="">
	<input type="hidden" name="facility_name" id="facility_name" value="">
	<input type="hidden" name="level" id="level"				value="<%=level%>">
	<input type="hidden" name="clientIP" id="clientIP" value="">			
	<input type="hidden" name="user" id="user" value="">
	<input type="hidden" name="compname" id="compname" value="">
	<input type="hidden" name="domain" id="domain" value="">
	<input type="hidden" name="error_num" id="error_num" value="<%=error_num%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="everyvisit" id="everyvisit" value="">
	<input type="hidden" name="ProxyEnable" id="ProxyEnable" value="">
	<input type="hidden" name="ProxyOverride" id="ProxyOverride" value="">
	<input type="hidden" name="url" id="url" value="">
	<input type="hidden" name="proxy_check" id="proxy_check" value="<%=proxy_check%>">
	<input type='hidden' name='enforce_password_policy_yn' id='enforce_password_policy_yn' value='<%=enforce_password_policy_yn%>'>
	<input type="hidden" name="first_login_change_password_yn" id="first_login_change_password_yn" value="<%=first_login_change_password_yn%>">
	<input type="hidden" name="change_password_mandatory_yn" id="change_password_mandatory_yn" value="<%=change_password_mandatory_yn%>">	
	<input type='hidden' name='allowed_spl_char_in_password' id='allowed_spl_char_in_password' value='<%=java.net.URLEncoder.encode(allowed_spl_char_in_password)%>'>
	<input type="hidden" name="case_sensitive_password_yn" id="case_sensitive_password_yn" value="<%=case_sensitive_password_yn%>"><!---//Maheshwaran added for the MMS-QH-CRF-0149-->
	<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start-->
	<input type="hidden" name="multiple_login_allowed_yn" id="multiple_login_allowed_yn" id="multiple_login_allowed_yn" value="<%=multiple_login_allowed_yn%>"> 
	<input type='hidden' name='action' id='action' value="" />
	<!--Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End-->
</form>
</body>
<%
if(change_pass.equals("change_pass")){
%>
	<script>
	Focusing('password');	
	login_form.password.focus();
	</script>
<%
}

} catch (Exception e ) {
	out.println(e);
	e.printStackTrace();
	}
finally {
if(pstmt !=null) pstmt.close();
if(rs !=null) rs.close();
if (con!=null)
ConnectionManager.returnConnection(con,request);
}
%>


<!-- added  on 7/2/2003 for ip/name-->
<Script Language="VBScript">
	Dim objNet
	On Error Resume Next
    
	Set objNet = CreateObject("WScript.NetWork") 
	
	Dim user
	Dim compname
	Dim domain
	Set TheForm = Document.forms("login_form")
	
	TheForm.user.Value = objNet.UserName
	TheForm.compname.Value = objNet.ComputerName
	TheForm.domain.Value = objNet.UserDomain
	'msgBox TheForm.user

	strInfo = "Your Logged User Name is: " & TheForm.user.Value & vbCRLF & _
				"Your PC Computer Name is: " & TheForm.compname.Value & vbCRLF & _
	          "Your Active Domain Name : " & TheForm.domain.Value
	


	user = objNet.UserName
	compname = objNet.ComputerName
	domain = objNet.UserDomain

	Set objNet = Nothing  
	
	
	Dim everyvisitval
	Dim ProxyEnableval
	Dim ProxyOverrideval
	Dim urlval
	Set WSHShell1 = CreateObject("WScript.Shell")

	everyvisitval = WSHShell1.RegRead("HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\SyncMode5")
	ProxyEnableval=WSHShell.RegRead("HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyEnable")
	ProxyOverrideval=WSHShell.RegRead("HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyOverride")				
	urlval=window.location.href 

	Set TheForm1 = Document.forms("login_form")
	
	TheForm1.everyvisit.Value = everyvisitval
	TheForm1.ProxyEnable.Value = ProxyEnableval
	TheForm1.ProxyOverride.Value = ProxyOverrideval
	TheForm1.url.Value = urlval
</Script>


