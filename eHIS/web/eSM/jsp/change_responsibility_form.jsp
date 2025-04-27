<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@taglib uri="/WEB-INF/tld/iba-autocompletetag.tld" prefix="ibaAutoComplete"%>
<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

%>
<head>
<!-- added for new look need to do some changes -->
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/login.css'></link> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<ibaAutoComplete:setup></ibaAutoComplete:setup>
<title><fmt:message key="Common.switchResponsibility.label" bundle="${common_labels}"/></title>

<script language="JavaScript">
	var loadFlag=true;
	var login_resp_flag=true;
	var login_fac_flag=true;
	/*
	if(window.parent.opener!=null)
	{
		if(!window.parent.opener.closed)
		{
			//window.parent.opener.close();
		}
	}
	*/
	function cancelWindow(){
		var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes, fullscreen=yes,scrollbars=no' ;
		var myFeatures = myBars + ', ' + myOptions ;
		var ecisWindow = open( '../../eCommon/jsp/eHIS.jsp', 'eHISMain1', myFeatures ) ;
		ecisWindow.focus() ;
		 window.close();
	}
	function changeFacility( listvalue ) {
		if(listvalue){
			document.forms[0].all.changeOK.disabled=false;
			document.forms[0].all.changeOK.style.cursor="hand";
			var lists=listvalue.split("|");
			var id=lists[0];
			var name=lists[1];
			change_responsibility_form.facility_id.value=id;
			change_responsibility_form.facility_name.value=name;
		}else{
			document.forms[0].all.changeOK.disabled=true;
			document.forms[0].all.changeOK.style.cursor="default";
		}
	}
	function change_resp(obj){
		//login_resp_flag=false;	
		if(obj.getSelectedValue()!=null){
			var id		=obj.getSelectedValue() ;
			var name	=obj.getSelectedText() ;
			change_responsibility_form.responsibility_id.value  = id ;
			change_responsibility_form.responsibility_name.value    = name ;
			document.forms[0].all.changeOK.disabled=true;
			var user_name=change_responsibility_form.current_user.value;
			var resp_ID=change_responsibility_form.responsibility_id.value;
			document.change_responsibility_form.facility_id.value="";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " user_name=\"" + user_name + "\""	;
			xmlStr += " resp_ID=\"" + resp_ID + "\"";
			xmlStr += " from=\"changeresp\"";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eSM/jsp/FacilitySelect.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			addfacility(responseText);
		}else{
			//document.getElementById("facilityRowID").style.display="None";
			document.change_responsibility_form.responsibility_id.value="";
			/*document.getElementById("errMSGID0").style.display="";
			document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
			var obj=document.forms[0].elements[0];
			obj.focus();
			obj.select();*/
			login_resp_flag=false;
		}
	}
	function changeResponsibility( obj ) {
		var facIndex;
		var listvalue=obj.value;
		var lists   = listvalue.split( "|" ) ;
		var id  = lists[0] ;
		var name    = lists[1] ;
		change_responsibility_form.responsibility_id.value  = id ;
		change_responsibility_form.responsibility_name.value    = name ;
		document.forms[0].all.changeOK.disabled=true;
		var user_name=change_responsibility_form.current_user.value;
		var resp_ID=change_responsibility_form.responsibility_id.value;
		document.change_responsibility_form.facility_id.value="";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " user_name=\"" + user_name + "\""	;
		xmlStr += " resp_ID=\"" + resp_ID + "\"";
		xmlStr += " from=\"changeresp\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eSM/jsp/FacilitySelect.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		addfacility(responseText);
	}
	function addfacility(valueText){
		var cap_sep=valueText.split('^')
		var fc_value=cap_sep[0];
		var fc_count=cap_sep[1];
		var ival=0;
		var facilityselectIndex="0";
		var facIndex;
		var facilityString="<select class='select' style='width: 290px' name='facility' id='facility' id=\"facility\"  onchange=\"selectfacility(this)\" onkeypress=\"loginAppl_fac_event(this)\" onblur=\"facility_blur(facility)\">";
		var facility_id_active="";
		facility_id_active=document.change_responsibility_form.facility_id_active.value;
		if(!loadFlag){
			//var facility_id_active="";
			var dol_facility=fc_value.split('$');
			var len=dol_facility.length;
			//facility_id_active=document.change_responsibility_form.facility_id_active.value;
			for(var i=0;i<len;i++){
				var facility_id_local="";
				var facility_name_local="";
				var split_fac=dol_facility[i].split('~');
				facility_id_local=split_fac[0];
				facility_name_local=split_fac[1];
				document.forms[0].all.changeOK.disabled=false;
				document.forms[0].all.changeOK.style.cursor="hand";
				if(facility_id_active==facility_id_local){
					document.change_responsibility_form.facility_id.value    = facility_id_local ;
					document.change_responsibility_form.facility_name.value  = facility_name_local ;
					facIndex=i;
				}
				loadFlag=true;
				facilityString +="<option value="+facility_id_local+"|"+facility_name_local+">"+facility_name_local+"</option>";
			}
			facilityString +="</select>";
			document.getElementById("facilityIDTd").innerHTML=facilityString;
			eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\"onchange\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
			var obj=document.forms[0].elements[0];
			obj.focus();
			obj.select();
			facility.selectOption(facIndex);
			login_resp_flag=true;
			login_fac_flag=true;
		}else{
			if(fc_count==0){
				document.getElementById("facilityRowID").style.display="None";
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("NO_FACILITIES","Common");
			}else{
				document.getElementById("errMSGID0").style.display="None";
				document.getElementById("facilityRowID").style.display="";
				var dol_facility=fc_value.split('$');
				var len=dol_facility.length;
				for(var i=0;i<len;i++){
					var split_fac=dol_facility[i].split('~');
					document.forms[0].all.changeOK.disabled=false;
					document.forms[0].all.changeOK.style.cursor="hand";
					if(i==0){
						change_responsibility_form.facility_id.value    = split_fac[0] ;
						change_responsibility_form.facility_name.value  = split_fac[1] ;
					}
				   
				   var isSelect	 = "";
				   if(split_fac[0]==facility_id_active){
					 isSelect	= "selected";
					 change_responsibility_form.facility_id.value    = split_fac[0] ;
					 change_responsibility_form.facility_name.value  = split_fac[1] ;
				    }
					
					facilityString +="<option value="+split_fac[0]+"|"+split_fac[1]+" "+isSelect+">"+split_fac[1]+"</option>";
				}
				facilityString +="</select>";
				document.getElementById("facilityIDTd").innerHTML=facilityString;
				eval("var facility=dhtmlXComboFromSelect(\"facility\");facility.enableFilteringMode(true);facility.enableOptionAutoPositioning(true);dhtmlxEvent(facility.DOMelem,\"click\",function(){facility._last=(new Date()).valueOf();});facility.attachEvent(\"onOpen\",function(){window.setTimeout(function(){if ((new Date()).valueOf()-(facility._last||0) > 100) return;var text = facility.getComboText();facility.setComboText(\"\");facility.filterSelf();},1);return true;});dhtmlxEvent(facility.DOMelem_input,\"onchange\",function(){selectfacility(this)});dhtmlxEvent(facility.DOMelem_input,\"keypress\",function(){loginAppl_fac_event(this)});dhtmlxEvent(facility.DOMelem_input,\"blur\",function(){facility_blur(facility)});");
				var obj=document.forms[0].elements[0];
				obj.focus();
				obj.select();
				document.forms[0].all.changeOK.disabled=false;
			}
		}
	}
	function facility_blur(obj){
		document.getElementById("errMSGID0").style.display="None";
		document.forms[0].all.changeOK.disabled=false;
		document.forms[0].all.changeOK.style.cursor="hand";
		obj.setComboText((obj.getSelectedText()).replace(/\&amp;/g,'&'));
		if(obj.getSelectedValue()==null){
			document.change_responsibility_form.facility_id.value="";
		}else{
		}
	}
	function responsibility_blur(obj){
		obj.setComboText((obj.getSelectedText()).replace(/\&amp;/g,'&'));
		document.getElementById("errMSGID0").style.display="None";
		document.forms[0].all.changeOK.disabled=false;
		document.forms[0].all.changeOK.style.cursor="hand";
		if(obj.getSelectedValue()==null){
			document.change_responsibility_form.responsibility_id.value="";
			login_resp_flag=false;
		}else{
			login_resp_flag=true;
		}
	}
	function selectfacility(obj){
		document.getElementById("errMSGID0").style.display="None";
		if(obj.getSelectedValue()!=null){
			changeFacility(obj.getSelectedValue());
		}else{
			document.change_responsibility_form.facility_id.value="";
		}
	}
	function loginAppl_resp_event(e){
		document.getElementById("errMSGID0").style.display="None";		
		if(event.keyCode==13){
			if((document.change_responsibility_form.responsibility_id.value!=null && document.change_responsibility_form.responsibility_id.value!="") && (document.change_responsibility_form.facility_id.value!=null && document.change_responsibility_form.facility_id.value!="")){	
					if(login_resp_flag){
						login();
					}else{
						login_resp_flag=true;
					}
			}else{
				document.forms[0].all.changeOK.disabled=true;
				document.forms[0].all.changeOK.style.cursor="default";
				if(document.change_responsibility_form.responsibility_id.value=="" && document.change_responsibility_form.facility_id.value==""){
					document.getElementById("errMSGID0").style.display="";
					document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common");
				}else if(document.change_responsibility_form.responsibility_id.value==""){
					document.getElementById("errMSGID0").style.display="";
					document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
				}else if(document.change_responsibility_form.facility_id.value==""){
					document.getElementById("errMSGID0").style.display="";
					document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
				}
			}
		}else{
			login_resp_flag=false;
		}
	}
	function loginAppl_fac_event(e){
		document.getElementById("errMSGID0").style.display="None";
		if(event.keyCode==13){
			if((document.change_responsibility_form.responsibility_id.value!=null && document.change_responsibility_form.responsibility_id.value!="") && (document.change_responsibility_form.facility_id.value!=null && document.change_responsibility_form.facility_id.value!="")){	
					if(login_fac_flag){
						login();
					}else{
						login_fac_flag=true;
					}
			}else{
				document.forms[0].all.changeOK.disabled=true;
				document.forms[0].all.changeOK.style.cursor="default";
				if(document.change_responsibility_form.responsibility_id.value=="" && document.change_responsibility_form.facility_id.value==""){
					document.getElementById("errMSGID0").style.display="";
					document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common");
				}else if(document.change_responsibility_form.responsibility_id.value==""){
					document.getElementById("errMSGID0").style.display="";
					document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
				}else if(document.change_responsibility_form.facility_id.value==""){
					document.getElementById("errMSGID0").style.display="";
					document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
				}
			}
		}else{
			login_fac_flag=false;
		}
	}
	function login(){
		if((document.change_responsibility_form.responsibility_id.value!=null && document.change_responsibility_form.responsibility_id.value!="") && (document.change_responsibility_form.facility_id.value!=null && document.change_responsibility_form.facility_id.value!="")){					
			document.change_responsibility_form.level.value='2';
			document.change_responsibility_form.submit();
		}else{
			document.forms[0].all.changeOK.disabled=true;
			document.forms[0].all.changeOK.style.cursor="default";
			if(document.change_responsibility_form.responsibility_id.value=="" && document.change_responsibility_form.facility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESP_FACILITY","Common");
			}else if(document.change_responsibility_form.responsibility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_RESPONSIBILITY","Common");
			}else if(document.change_responsibility_form.facility_id.value==""){
				document.getElementById("errMSGID0").style.display="";
				document.getElementById("errMSGID").innerHTML=getMessage("INAVLID_FACILITY","Common");
			}
		}
	}
	function MyAddress(data) {
		var hostIP;
		var index = data.indexOf("&");
		hostName = data.substr(0,index);
		hostIP = data.substr(index+1,data.length);
		document.getElementById("clientIP").value = hostIP;
	}
	function changeresload(){
		var obj=document.forms[0].elements[0];
		obj.focus();
		obj.select();
		document.forms[0].all.changeOK.disabled=false;
		//document.change_responsibility_form.all.changeOK.disabled=true;
		//changeResponsibility(document.forms[0].dflt_respID);
	}
	function helpfunction(){
		var dialogHeight= "38.8" ;
		var dialogTop = "125" ;
		var dialogWidth	= "63.8" ;
		var dialogLeft   = "0";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		retVal 	 	 = window.showModalDialog("../../eCommon/html/Switch_Responsibility.htm",arguments,features); 
	}
	function login_ok_event(e){
		if(event.keyCode==13||event.keyCode==32){
			login();
		}
	}
	function callUnloadFunction(){
		/*var xmlDoc		= new ActiveXObject("Microsoft.XMLDom");
		var xmlHttp		= new ActiveXObject("Microsoft.XMLHTTP");
		xmlStr	="<root><SEARCH " ;
		xmlStr += " from=\"onloadswitchresp\"";
		xmlStr +=" /></root>";
		xmlDoc.loadXML( xmlStr );
		xmlHttp.open( "POST","../../eSM/jsp/FacilitySelect.jsp", false );
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		addfacility(responseText);*/
	}
	</script>
</head>
<%
	Connection con =null;
	try {
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt         = null ;
		HashMap respMap=null;
		HashMap facMap=null;
		ResultSet rs                = null ;
		String dflt_respID="";
		String level                = request.getParameter( "level" ) ;
		String current_user         = (String) session.getAttribute( "login_user" ) ;
		String facility_id        = (String) session.getAttribute( "facility_id" ) ;
		String facility_name            = java.net.URLDecoder.decode((String) session.getAttribute( "facility_name" ),"UTF-8");
		
		//session.putValue("Login","Y");
		String responsibility_id        = (String) session.getAttribute( "responsibility_id" ) ;
		String responsibility_name      = (String) session.getAttribute( "responsibility_name" ) ;
		String locale            = (String) session.getAttribute( "LOCALE" ) ;
		locale = (locale == null || locale.equals(""))?"en":locale;
		//java.util.Locale loc = new java.util.Locale(locale);
		String desktop_code="";
		Properties p;
		//boolean flag=false;
		
		
		String userName="";
		p=( java.util.Properties ) session.getValue( "jdbc" ) ;
		userName=(String)session.getAttribute( "appl_user_name");
		if(userName==null || userName.equals("")){
			userName="";
		}
		String product_name="";
		String product_description="";
		String version_info="";
		String copyright_info="";
		String site_name="";
		String copyrights_dtls = "";//Added by Kamatchi S for PMG2021-COMN-CRF-0002
		try{
			//Modified by Kamatchi S for PMG2021-COMN-CRF-0002
			String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME,a.COPYRIGHTS_DTLS COPYRIGHTS_DTLS from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id=?";		
			pstmt=con.prepareStatement(inst_info) ;
			pstmt.setString(1,locale);		
			rs=pstmt.executeQuery() ;
			if(rs!=null && rs.next()){
				product_name=rs.getString("PRODUCT_NAME");
				product_description=rs.getString("PRODUCT_DESCRIPTION");
				version_info=rs.getString("VERSION_NO");
				copyright_info=rs.getString("COPYRIGHT_INFO");
				site_name=rs.getString("SITE_NAME");
				copyrights_dtls=rs.getString("COPYRIGHTS_DTLS");//Added by Kamatchi S for PMG2021-COMN-CRF-0002
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)
			pstmt.close();			
			if(version_info==null || version_info.equals("")){
				version_info="";
			}
			if(copyright_info==null || copyright_info.equals("")){
				copyright_info="";
			}
			//Added by Kamatchi S for PMG2021-COMN-CRF-0002
			if(copyrights_dtls==null || copyrights_dtls.equals("")){
				copyrights_dtls="";
				}
		}catch(Exception ex){		
			ex.printStackTrace();
		}
		//java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		//String sql="select resp_user.resp_id, resp_name,desktop_code  from sm_resp_lang_vw resp, sm_resp_for_user resp_user  where resp.resp_id = resp_user.resp_id and language_id = ? and resp.menu_id in (select menu_id from sm_menu_hdr where dev_tool='J') and resp_user.appl_user_id =? and resp_user.RESP_ID=?    and ( ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to >= trunc(sysdate) ) or ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to is null )  or ( resp_user.eff_date_to >= trunc(sysdate) and resp_user.eff_date_from is null)   or ( resp_user.eff_date_from is null and resp_user.eff_date_to is null ) ) and ( ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to >= trunc(sysdate) )   or ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to is null )  or ( resp.eff_date_to >= trunc(sysdate) and resp.eff_date_from is null)  or ( resp.eff_date_from is null and resp.eff_date_to is null ) ) and resp.eff_status='E' order by 2";
		String sql="SELECT   resp_user.resp_id, resp_name, desktop_code,(SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME FROM sm_resp_lang_vw resp, sm_resp_for_user resp_user WHERE resp.resp_id = resp_user.resp_id  AND language_id = ? AND resp.menu_id IN (SELECT menu_id FROM sm_menu_hdr WHERE dev_tool = 'J') AND resp_user.appl_user_id = ? AND resp_user.resp_id = ? AND NVL(resp_user.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp_user.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND NVL(resp.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND resp.eff_status = 'E' ORDER BY 2";
		try{
			pstmt = con.prepareStatement( sql ) ;
			pstmt.setString( 1, locale ) ;
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, locale ) ;
			pstmt.setString( 4, current_user ) ;
			pstmt.setString( 5, responsibility_id ) ;
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				responsibility_name=rs.getString("RESP_name");
				desktop_code	= rs.getString( "desktop_code" );
				facility_name = rs.getString("FACILITY_NAME");
				
				if(desktop_code!=null){
					session.putValue(responsibility_id,desktop_code);
				}else{
					session.putValue(responsibility_id,null);
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)
					pstmt.close();
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		if(level==null){
			level="1";
		}
%>
<body class="mainSwitchResponsibility" onload='changeresload()' onunload='callUnloadFunction()' onKeyDown = 'lockKey()' scroll="no" onLoad="window.document.title=Switch Responsibility';">
<form name='change_responsibility_form' id='change_responsibility_form' method='post' action='../../servlet/eSM.ChangeResponsibilityServlet'>
<!-- added for new look START-->
<div id="Maincontainer">		
    <div id="Contentcontainer" style="background-image:url('../../eCommon/images/LoginBg.jpg')">
       	<div id="Contentcontainerbg" >
       	  <table align="center" width="637px" height="425px" border="0" cellspacing="0" cellpadding="0" >
     <tr>
	 <!--Added by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
	 <td colspan="2" style="padding-top: 45px;padding-right: 15px;" align="right">
			<br><img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo"  width="57" height="52" /></br>
		</td>
		<tr>
			<td class="heading" style="padding-top: 0px;padding-right: 15px;" align="right" ><%=site_name%></td>
		</tr>
		<!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
		<!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
    <!--<td height="140" colspan="2" valign="bottom">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" >-->
      <!--<tr>-->
       <!-- <td  class="version"><%=version_info%></td>--><!--Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
		   <!--<td ></td>
      </tr>
      <tr>
        <td>&nbsp;</td>--><!--Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
     <!-- </tr>
    </table></td>-->
	<!--Commented End by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
  </tr>
	 
	<tr>
	   <td class="version" height="15px">&nbsp;</td><!--Added by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->

	    <!--<td class="heading" style="padding-left:40px;" height="30px">
		<%=userName%>
		</td>--><!--Commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
											
	</tr>
	<tr class="HEADER">
	<!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
    <td align="center" colspan="2" valign="top" class="heading" style="padding-left:40px; padding-right:40px; padding-top:6px;"><%=version_info%></td><!--Added padding-top:6px;  by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
    </tr> 
	<tr class="HEADER">
    <td align="center" colspan="2" valign="top" class="heading" style="padding-left:40px; padding-right:40px;"><%=userName%>&nbsp;/&nbsp;<%=responsibility_name%>&nbsp;/&nbsp;<%=facility_name%></td>
	<!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
    </tr> 

	<tr>
	<!--Modified width="387" as width="587" by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
			<td width="587" valign="top" style="padding-left:40px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
     
										
										

										<tr>
        <td class="heading" height="35px" ><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
      </tr>
										
											<%
												String  desktop_code_local="";
												//String respsql = "   select resp_user.resp_id, resp_name,desktop_code  from sm_resp_lang_vw resp, sm_resp_for_user resp_user  where resp.resp_id = resp_user.resp_id and language_id = ? and resp.menu_id in (select menu_id from sm_menu_hdr where dev_tool='J' OR (ADHOC_MENU_YN ='Y' AND TRUNC(SYSDATE) BETWEEN Nvl(ADHOC_MENU_EFF_FROM,TRUNC(SYSDATE)) AND NVL(ADHOC_MENU_EFF_TO ,TRUNC(SYSDATE)))) and resp_user.appl_user_id = ?  and ( ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to >= trunc(sysdate) ) or ( resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to is null )  or ( resp_user.eff_date_to >= trunc(sysdate) and resp_user.eff_date_from is null)   or ( resp_user.eff_date_from is null and resp_user.eff_date_to is null ) ) and ( ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to >= trunc(sysdate) )   or ( resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to is null )  or ( resp.eff_date_to >= trunc(sysdate) and resp.eff_date_from is null)  or ( resp.eff_date_from is null and resp.eff_date_to is null ) ) and resp.eff_status='E' order by 2";
												String respsql = "SELECT   RESP_USER.RESP_ID, RESP_NAME, DESKTOP_CODE FROM SM_RESP_LANG_VW RESP, SM_RESP_FOR_USER RESP_USER  WHERE RESP.RESP_ID = RESP_USER.RESP_ID AND language_id =? AND resp.menu_id IN (SELECT menu_id FROM sm_menu_hdr WHERE dev_tool = 'J' OR (adhoc_menu_yn = 'Y' AND TRUNC (SYSDATE) BETWEEN NVL (adhoc_menu_eff_from,TRUNC (SYSDATE)) AND NVL (adhoc_menu_eff_to,TRUNC (SYSDATE)))) AND resp_user.appl_user_id = ? AND NVL(resp_user.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp_user.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND NVL(resp.eff_date_from,TRUNC(SYSDATE)) <= TRUNC (SYSDATE) AND NVL(resp.eff_date_to,TRUNC(SYSDATE)) >= TRUNC (SYSDATE) AND resp.eff_status = 'E' ORDER BY 2";//Fine tuned Query for above Query
												
												pstmt = con.prepareStatement( respsql ) ;
												
												pstmt.setString(1,locale);
												pstmt.setString( 2, current_user ) ;
												rs = pstmt.executeQuery() ;
												int cls=0;
												respMap=new HashMap();
										
													while(rs!=null && rs.next()){
														String respId   = rs.getString( "resp_id" ) ;
														
														String respName = rs.getString( "resp_name" ) ;
														desktop_code_local	= rs.getString( "desktop_code" ) ;
														if(desktop_code_local!=null){ 
															session.putValue(respId,desktop_code_local);
														}else{ 
															session.putValue(respId,null);
														}
														if(responsibility_id.equals(respId)){
															dflt_respID=respId+"|"+respName;
														}
														respMap.put(respId,respName);
														cls++;
													}
													if(rs!=null)rs.close();
													if(pstmt!=null)
														pstmt.close();		
												%>
			
												<tr>										
											<td>
												<ibaAutoComplete:ibaAutoCompleteCombo map="<%=respMap%>" id="loginresponsibility" name="loginresponsibility" defaultSelection="<%=responsibility_id%>" onchange="change_resp(this)" onkeypress="loginAppl_resp_event(this)" onblur="responsibility_blur(loginresponsibility)" width="290"></ibaAutoComplete:ibaAutoCompleteCombo>
											</td>
											
										</tr>
										
										<%/* change starts for cross facility validation 17/Jul/2012*/
											String restrict_facility_by_db="N";
											try{
												pstmt = con.prepareStatement( "SELECT nvl(RESTRICT_FCY_BY_CURR_DB_YN,'N') RESTRICT_FCY_BY_CURR_DB_YN FROM SM_SITE_PARAM" ) ;
												rs = pstmt.executeQuery() ;					
												while(rs!=null && rs.next()){
													restrict_facility_by_db=rs.getString("RESTRICT_FCY_BY_CURR_DB_YN");
												}
											}catch ( Exception ex){
												restrict_facility_by_db="N";
											}finally{
												if (pstmt != null)pstmt.close();
												if (rs != null)rs.close();
											}
											String facSql ="";
											if(restrict_facility_by_db.equals("Y")) {
												facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?)  AND UPPER(CURR_DB)= 	(select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(CURR_DB)+1, LENGTH(CURR_DB))) from sm_db_info) ORDER BY 2";
											}else{
												 facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = ?) ORDER BY 2";
											}
											/* change ends for cross facility validation*/
											
											pstmt = con.prepareStatement( facSql ) ;
											pstmt.setString(1,locale);
											pstmt.setString( 2, current_user ) ;
											pstmt.setString( 3, responsibility_id ) ;
											rs = pstmt.executeQuery() ;
											facMap=new HashMap();
											while(rs!=null && rs.next()){
												String facId   = rs.getString( "facility_id" ) ;
												String facName = rs.getString( "facility_name" ) ;
												facMap.put(facId,facName);
											}
											if(rs!=null)rs.close();
											if(pstmt!=null)
												pstmt.close();
										%>

										<tr>
        <td class="heading" height="35px"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
      </tr>

	  <tr id="facilityRowID">
        <td id="facilityIDTd" class="heading">
		<ibaAutoComplete:ibaAutoCompleteCombo map="<%=facMap%>" id="facility" name="facility" defaultSelection="<%=facility_id%>"  onchange="selectfacility(this)" onkeypress="loginAppl_fac_event(this)" onblur="facility_blur(facility)" width="290"></ibaAutoComplete:ibaAutoCompleteCombo>          
       </td>
      </tr>
					 <tr>
        <td>&nbsp;</td>
      </tr>					
										
										<tr>


        <td><table align="left" border="0" cellspacing="0" cellpadding="0" >
          <tr>
            <td><table  style="border-collapse: collapse;">
              <tr>
			   <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->
			 <!-- <td width="8px"><img src="../../eCommon/images/buttonLeft.PNG" onclick="login()"   style="cursor:pointer"  ></img></td>--><td width="auto"><input type="button" class="button" id="changeOK"  style="cursor:pointer;"  onclick="login()" onkeypress='login_ok_event(event)' onKeyDown='login_ok_event(event)'  value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'/></td>
													<!--	<td><img src="../../eCommon/images/ButtonRight.PNG"  onclick="login()"   style="cursor:pointer"  ></img></td>-->
              </tr>
            </table></td>
            <td>&nbsp;&nbsp; </td>
            <td><table style="border-collapse: collapse;">
              <tr>
			   <!--buttonLeft.PNG & ButtonRight.PNG commented by Suji Keerthi for PMG2021-COMN-CRF-0002 US002 -->
               <!-- <td width="8px"><img src="../../eCommon/images/buttonLeft.PNG" onclick="cancelWindow()"   style="cursor:pointer"  ></img></td>-->
				  <td width="auto"><input type="button"  class="button"  onClick="cancelWindow()" onkeypress="cancelWindow()" style="cursor:pointer;" value='<fmt:message key="Common.cancelhome.label" bundle="${common_labels}"/>'/></td>
														<!--<td><img src="../../eCommon/images/ButtonRight.PNG" onclick="cancelWindow()"   style="cursor:pointer" ></img></td>-->
              </tr>
            </table></td>
			<!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
			<td><table align="centre" border="0" cellspacing="0" cellpadding="0" >
					<tr id="errMSGID0" style="display:none">
					<td style="padding-left:10px;"><img src="../../eCommon/images/Alert.png" /></img> 
					<span id="errMSGID" class="loginError" style="font-color:red;" ></span></td>
					<!--Ended by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
          </tr>
        </table></td>
      </tr>

		<tr>
        <td>&nbsp;</td>
      </tr>
		 </table></td>
		 <!--Commented by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
		 <!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
    <!--<td width="325px" style="padding-right:10px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	

	<tr>
        <td align="left"><img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo"  width="57" height="51" valign="middle" /></td>
        <td width="97%" class="heading" style="padding-left:10px;"><span style="width:100px;"><%=site_name%></span></td>-->
		<!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
     <!-- </tr>


      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr id="errMSGID0" style="display:none">
        <td colspan="2"><img src="../../eCommon/images/Alert.png" /></img>
		<span id="errMSGID" class="loginError" style="font-color:red;"></span></td>
      </tr>
	
		 <tr>
        <td colspan="2">&nbsp;</td>
      </tr>

      <tr>-->
      <!--Below Modified by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
       <!-- <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      </table></td>
  </tr>-->
    <!--<tr>
	<td align="right" valign="top" style="padding-right:10px;padding-bottom:5px" class="heading" ><%=copyrights_dtls%></td>
	  </tr>-->
	<!--<tr>
	   <td colspan="2" align="center" valign="top" class="heading" >&nbsp;</td>-->
	   <!--Ended by Suji Keerthi for PMG2021-COMN-CRF-0002 US002-->
      <!--</tr> -->
	   <!--Commented END by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
</table>
		<tr>
	<td align="right" valign="top" style="padding-right:10px;padding-bottom:5px" class="heading" ><%=copyrights_dtls%></td><!--Modified by Kamatchi for PMG2022-COMN-CRF-0012 US001-->
	  </tr>
        </div>
    </div>
</div>
<!-- added for new look END-->
<input type="hidden" name="responsibility_id" id="responsibility_id"  value="<%=responsibility_id%>">
<input type="hidden" name="responsibility_name" id="responsibility_name">
<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
<input type="hidden" name="facility_id_active" id="facility_id_active" value="<%=facility_id%>">
<input type="hidden" name="facility_name" id="facility_name">
<input type="hidden" name="level" id="level"               value="<%= level %>">
<input type="hidden" name="dflt_respID" id="dflt_respID"               value="<%= dflt_respID %>">

<!-- added  on 7/2/2003 for ip/name-->
<input type="hidden" name="clientIP" id="clientIP" value="">          
<input type="hidden" name="user" id="user" value="">
<input type="hidden" name="compname" id="compname" value="">
<input type="hidden" name="domain" id="domain" value="">
<input type="hidden" name="current_user" id="current_user" value="<%=current_user%>">

<!-- added  on 7/2/2003 for ip/name-->
 </form>
</body>
<% respMap.clear();
    }catch(Exception e){
		//out.println("Error "+e);
		e.printStackTrace();
		}
    finally { 
    ConnectionManager.returnConnection(con,request);
	//if(rs!=null)rs.close();
	//if(pstmt!=null)
			//pstmt.close();
			
    }
    %>

<Script Language="VBScript">
    Dim objNet
    On Error Resume Next

	'Set WshShell33 = CreateObject("WScript.Shell")
	'WshShell33.SendKeys "{F11}"
    
    Set objNet = CreateObject("WScript.NetWork") 
    
    Dim user
    Dim compname
    Dim domain
    Set TheForm = Document.forms("change_responsibility_form")
    
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

</Script>

    <!-- <APPLET code="eCommon.ClientIP.class" MAYSCRIPT  archive="../applet/clientIP.jar" height=0 width=0></APPLET>  -->

