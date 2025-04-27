<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,java.util.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.net.InetAddress,java.net.UnknownHostException" %>
<%@taglib uri="/WEB-INF/tld/iba-autocompletetag.tld" prefix="ibaAutoComplete" %>
<% 
	response.setContentType("text/html;charset=UTF-8");
		response.setDateHeader ("Expires", 0);
	response.setHeader ("Pragma", "no-cache");
	if (request.getProtocol().equals ("HTTP/1.1")) {
		response.setHeader ("Cache-Control", "no-cache");
	}
	
	String computerName = "", ipAddress = "";
	String serverName = "", serverIPAddress = "";
	 try {
        InetAddress address = InetAddress.getLocalHost();        
        serverName = address.getHostName();
        serverIPAddress = address.getHostAddress();
        
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } 
    
    try {
    	computerName = request.getParameter("computerName");
    	ipAddress = request.getParameter("ipAddress");
    	
    	if (computerName == null)
    		computerName = serverName;
    	
    	if (ipAddress == null)
    		ipAddress = serverIPAddress;
    	
    } catch (Exception e) {
        e.printStackTrace();
    } 
  
/* String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";*/
  %>
<head>
	 <link href="../../eCommon/html/login.css" rel="stylesheet" type="text/css" /> 
	<!-- <link href="../../eCommon/html/style.css" rel="stylesheet" type="text/css" /> -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eSM/js/login.js" language="javascript"></script>

	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script> 
	<!--  --> 

	<script src="../../eCommon/js/logout.js" language="javascript"></script>
	
	<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
	<script src='../../eXH/js/ExternalApplication.js' language="javascript"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	

	<ibaAutoComplete:setup></ibaAutoComplete:setup>	
</head>
<%
	Connection con =null ;
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
    boolean isSSOIntegrationAppl = false;

	try{

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "SSO_INTEGRATION");

	
	String level			= request.getParameter( "level" ) ;
	String error_num			= request.getParameter( "error_num" ) ;
	if(error_num==null)
		error_num="0";
	String resp_count			= request.getParameter( "resp_count" ) ;
	int count_res=0;
	String checklogin		= request.getParameter( "invalidlogin" ) ;
	String name 			= (String) session.getValue( "login_user" ) ;
	String login_user 			= (String) session.getValue( "login_user" ) ;
	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;
	String responsibility_name	= (String) session.getValue( "responsibility_name" ) ;
	String has_resp	= request.getParameter( "resp" ) ;
	
	System.err.println("Level= "+level); //null
	System.err.println("resp_count= "+resp_count); //null
	System.err.println("checklogin= "+checklogin); //null
	System.err.println("name= "+name); //null
	System.err.println("login_user"+login_user); //null
	System.err.println("responsibility_id= "+responsibility_id);  //OP
	System.err.println("responsibility_name= "+responsibility_name);  //undefined
	System.err.println("has_resp= "+has_resp); // null


	Properties p;
	String userName="";
	if(has_resp==null)
		has_resp="";
	String locale = null;
	String mode="begin";
	String change_pass="";
	String user_name_pass="";

	if ( level 			== null ) level 			= "" ;
	if ( checklogin 			== null ) checklogin 			= "N" ;
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
		change_pass=request.getParameter( "change_pass" ) ;
		user_name_pass=request.getParameter( "user_name_pass" ) ;
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
	String copyrights_dtls = "";//Added by Kamatchi S for PMG2021-COMN-CRF-0002
	try{
		//Maheshwaran modified for the MMS-QH-CRF-0149
		//Modified By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		//Modified by Kamatchi S for PMG2021-COMN-CRF-0002
		String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME,(select count(*) from sm_function_control x,sm_site_param y where module_id='SM' and FUNCTIONALITY_ID='CHECK_PROXY'        and x.site_id=y.customer_id) proxy_check,b.case_sensitive_password_yn,b.allowed_spl_char_in_password,b.enforce_password_policy_yn,b.first_login_change_password_yn,b.change_password_mandatory_yn,b.multiple_login_allowed_yn,a.COPYRIGHTS_DTLS COPYRIGHTS_DTLS from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
		if(pstmt!=null)
			pstmt.close();
		pstmt=con.prepareStatement(inst_info);
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
			copyrights_dtls=rs.getString("COPYRIGHTS_DTLS");//Added by Kamatchi S for PMG2021-COMN-CRF-0002
			}
		if(version_info==null || version_info.equals(""))
		version_info="";
		if(copyright_info==null || copyright_info.equals(""))
			copyright_info="";
		//Added by Kamatchi S for PMG2021-COMN-CRF-0002
		if(copyrights_dtls==null || copyrights_dtls.equals(""))
				copyrights_dtls="";

		session.setAttribute("version_no",version_info);
		session.setAttribute("product_description",product_description);
		session.setAttribute("copyrights_dtls",copyrights_dtls);//Added by Kamatchi S for PMG2021-COMN-CRF-0002
	}catch(Exception ex){
		out.println(ex.toString());
		ex.printStackTrace();
	}
%>
<script>

$(document).ready(function() {   
	/*
	var documentModeStr = document.documentMode;
	alert(" Document mode : "+documentModeStr);
	*/
	
	var computerName = document.getElementById("compname").value;
	var ipAddress = document.getElementById("clientIP").value;
	
	console.log(" Login JSP 220 ComputerName : "+computerName+" IP Address : "+ipAddress);

	/*
	$.getJSON("https://api.ipify.org?format=json", function(data) {
	     
	    // Setting text of element P with id gfg
	    //$("#gfg").html(data.ip);
	    
	    //alert("IP Address for Computer Name : "+data.ip);	
	    //document.getElementById("compname").value = data.ip;
	    
	    document.getElementById("compname").value = "BLESSAN-HP";
	});
	*/
	
});



/*

*/

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

<form   name="login_form" id="login_form" method="post" action="../../servlet/eSM.LoginResponseServlet"  >
<%if(level.equals("1")){%>

<div id="Maincontainer">		
    <div id="Contentcontainer" style="background-image:url('../../eCommon/images/LoginBg.jpg')">
       	<div id="Contentcontainerbg" >
       	  <table align="center" width="637px" height="425px" border="0" cellspacing="0" cellpadding="0" style="background-image:url('../../eCommon/images/LoginWidget.png')"><!--Modified height=425px as 418px by Suji Keerthi for PMG2021-COMN-CRF-0002 US001--><!--Modified height=418px as 425px by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
     
	 
	
	 <tr>
	 <!--<td height="140" colspan="2" valign="bottom">--><!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
		<!-- Added by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
		<td height="33" colspan="2" valign="top" style="PADDING-TOP: 123px; PADDING-LEFT: 25px">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		  <tr> 
		    <td align="center" class="version" style="padding-top:15px;"><%=version_info%></td><!--Modified padding-top:15px; as padding-top:16px; by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
		    </tr>
    </table></td>
		<td colspan="2" style="padding-top: 45px;padding-right: 15px;" align="right">
			<br><img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo"  width="97" height="92" /></br>
			<p class="heading" ><%=site_name%></p>
		</td>
		<!-- <tr>
			<td class="heading" style="padding-top: 0px;padding-right: 15px;" align="right" ><%=site_name%></td>
		</tr>-->

	</tr>
	<!-- Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
   <!--Below Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
      <!--<table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tr>
        <td  class="version"><%=version_info%></td>
      </tr>
      <tr>
        <td style="padding-right:20px;" align="right" class="version">&nbsp;</td>
      </tr>
    </table>-->
	<!--</td>
	</tr>--><!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
      <!--Below added by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	 <!--<tr>
		<td height="33" colspan="2" valign="top" style="padding-left:40px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		  <tr> 
		    <td align="center" class="version" style="padding-top:15px;"><%=version_info%></td>--><!--Modified padding-top:15px; as padding-top:16px; by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
		    <!--</tr>
    </table></td>
  </tr>--> 
  <!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002--> 

	<tr>
	<!--Modified width="387" as width="587" by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
	<td width="587" valign="top" style="padding-left:40px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">

	  
	    <tr>
	      <td class="heading" height="35px" id="userNameID"><strong>User ID</strong></td><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	      </tr>
	    <tr>
		  <!--Modified by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
	      <td id="userNameTextID" class="heading">
		  <input name="name" id="name" style="padding-top:5px; padding-left:5px;" type="text" size="40" maxlength="40" height="30px" onKeyPress="checkvisible();return CheckForSpecChars(event);checkuser_event(event)" onBlur="checkvisible();<%if(isSSOIntegrationAppl){%>checkADAndEMUserYN(this);<%}%>" onKeyDown="return noescUser()" tabindex="1"/ AUTOCOMPLETE="OFF" class="inputH" /><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	      </td>
	      </tr>
	    <tr>
	      <td class="heading" id="passwordID" height="35px">Password </td>
	      </tr>
	    <tr>
	      <td id="passwordTextID"><span class="heading">
	        <input class="inputH" style="padding-top:5px;padding-left:5px;" name="password" id="password" type="password" size="41" maxlength="30" 
			onkeypress="login_enter_event(event)" onKeyDown="return noescPassword()" tabindex="2"/><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	        </span></td>
	      </tr>
	    <tr>
	      <td>&nbsp;</td>
	      </tr>
	    <tr>
	      <td><table align="left" border="0" cellspacing="0" cellpadding="0" >
	        <tr>
	          <td><table width="100%" cellpadding="0" cellspacing="0"  style="border-collapse: collapse;"><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	            <tr>
				  <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->
	              <!--  <td width="8px"><img src="../../eCommon/images/buttonLeft.PNG" onClick="check_user_password();" style="cursor:pointer" /></td>-->
	              <td width="auto" height="36px;"><input type="button" class="button" id="loginID" style="cursor:pointer;" tabindex="3" onClick="check_user_password();" onKeyPress="check_user_password_event(event)" value="Login" /></td>
	              <!--<td><img src="../../eCommon/images/ButtonRight.PNG" onClick="check_user_password();" style="cursor:pointer" /></td>-->
	              </tr>
	            </table></td>
	          <td>&nbsp;&nbsp; </td>
	          <td><table width="100%" cellpadding="0" cellspacing="0" style="border-collapse: collapse;"><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	            <tr>
				   <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->
	              <!-- <td width="8px"><img src="../../eCommon/images/buttonLeft.PNG" onClick="cancelbutton();" style="cursor:pointer" /></td>-->
	              <td width="auto"><input type="button" class="button" tabindex="4" onClick="cancelbutton()" onKeyPress="cancelbutton_event(event)" id="cancelID" style="cursor:pointer;"  value="Cancel" /></td>
	              <!-- <td><img src="../../eCommon/images/ButtonRight.PNG" width="8" height="36" style="cursor:pointer" onClick="cancelbutton();" /></td>-->
				  <!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
				<td><table align="centre" border="0" cellspacing="0" cellpadding="0" >
					<tr id="errMSGID0" style="display:none">
					<td style="padding-left:10px;"><img src="../../eCommon/images/Alert.png" /></img> 
					<span id="errMSGID" class="loginError" style="font-color:red;" ></span></td>
					<!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
					</tr>
	              </tr>
	            </table></td>
	          </tr>
	        </table></td>
	      </tr>
	    <tr>
	      <td>&nbsp;</td>
	      </tr>
	    </table></td>
	  <!--<td><table width="250px" border="0" cellspacing="0" cellpadding="0">-->
	  <!--below code commented for PMG2022-COMN-CRF-0012 US001-->
	    <!--<tr>
	      <td align="left"><img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo"  width="57" height="52" valign="middle" /></td>
	      <td width="90%" class="heading" style="padding-left:10px;"><span style="width:100px;"><%=site_name%></span></td>--><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	      
	      <!--</tr>-->
	    <!--<tr>
	      <td colspan="2">&nbsp;</td>
	    </tr>-->
	    <!--<tr id="errMSGID0" style="display:none">
	      <td colspan="2"><img src="../../eCommon/images/Alert.png" /></img> 
		  <span id="errMSGID" class="loginError" style="font-color:red;"></span></td>
	    </tr>
	    <tr>-->
		<!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
	     <!-- <td colspan="2">&nbsp;</td>
	    </tr>
	    <tr>
	      <td colspan="2">&nbsp;</td>
	    </tr>-->
	   <!-- </table></td>-->
	   <!--<tr>
	  	<td align="right" valign="top" style="padding-right:10px;padding-bottom:5px" class="heading" ><%=copyrights_dtls%></td>
      </tr>--><!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
	  </tr>
	  <!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
      </table>
	  <!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
	  <tr>
	  	<td align="right" valign="top" style="padding-right:10px;padding-bottom:5px" class="heading" ><%=copyrights_dtls%></td>
      </tr>
	  <!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
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
	<input type="hidden" name="clientIP" id="clientIP" value="<%=ipAddress%>">			
	<input type="hidden" name="user" id="user" value="">
	<input type="hidden" name="compname" id="compname" value=<%=computerName%>>
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

	<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
	<input type='hidden' name='isSSOIntegrationAppl' id='isSSOIntegrationAppl' value=<%=isSSOIntegrationAppl%>>
	<input type='hidden' name='login_user_type' id='login_user_type' value="">

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


