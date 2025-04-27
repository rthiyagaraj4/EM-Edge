<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.io.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" %>

<head>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<script type='text/javascript' src="../../eCommon/js/DateUtils.js"></script>
<script type='text/javascript' src="../../eCommon/js/AlertUtils.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script Language="JavaScript" src="../../eCommon/js/logout.js"></script>

<%
	String responsibility_id=(String) session.getValue( "responsibility_id" ) ;		
	String desktop_code="" ;
	desktop_code=(String) session.getValue( responsibility_id ) ;
	request.setCharacterEncoding("UTF-8");	
    String jdbc_user =  "";
	String jdbc_user_id="";
	String display_user_name_yn="";	
	String facility_id = (String) session.getValue( "facility_id" ) ;
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String locale = (String) session.getValue( "LOCALE" ) ;
    String called_from_ca_yn =request.getParameter( "called_from_ca_yn" ) ;
    String desktop_summary_type =request.getParameter( "desktop_summary_type" ) ;
	if (desktop_summary_type==null) desktop_summary_type="";
	PreparedStatement pstmt=null;
	String facility_name = "" ;
	
	if (called_from_ca_yn==null) called_from_ca_yn="N";

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			Connection con=ConnectionManager.getConnection();

			/*String sql = "SELECT SITE_NAME,DISPLAY_USER_NAME_YN FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = ?)";*/
			
			/*Added by Ashwini on 27-Jul-2020 for ML-MMOH-CRF-1549*/
			JSONObject LicKeyJson = new JSONObject();
			LicKeyJson = eMP.MPCommonBean.getKeyForValidation(con);
			String lic_key = (String)LicKeyJson.get("lic_key");
			if (lic_key == null) lic_key = "";
			String licence_date = "";
			String decrypted_date = "";
			String lic_exp_yn = "N";
			
			/*if(("DEF_DURATION").equals(lic_key))
			{
				JSONObject LicDateJson = new JSONObject();
				LicDateJson = eMP.MPCommonBean.getLicenceEncDate(con,facility_id);
				licence_date = (String)LicDateJson.get("licence_date");
				if (licence_date == null) licence_date = "";
				
				if(!("").equals(licence_date))
				{
					decrypted_date = eCommon.Common.CommonBean.decrypt(licence_date);
					if (decrypted_date == null) decrypted_date = "";
					
					if(!("").equals(decrypted_date))
					{
						JSONObject LicExpYNJson = new JSONObject();
						LicExpYNJson = eMP.MPCommonBean.getLicenceExpYN(con,decrypted_date);
						lic_exp_yn = (String)LicExpYNJson.get("lic_exp_yn");
						if (lic_exp_yn == null) lic_exp_yn = "Y";
					}
				}
			}*/
			/*End ML-MMOH-CRF-1549*/

			String sql = "SELECT (SELECT site_name FROM sm_site_param_lang_vw WHERE language_id = ? AND 'Y' = (SELECT display_site_name_yn FROM sm_facility_param WHERE facility_id = ?)) site_name, display_user_name_yn FROM sm_site_param_lang_vw WHERE language_id = ?"; //Modified by Ashwini on 13-Nov-2018 for ARYU-SCF-0159 and TBMC-SCF-0003

			pstmt =  con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale); //Added by Ashwini on 13-Nov-2018 for ARYU-SCF-0159 and TBMC-SCF-0003
			ResultSet rset=null;
			 rset = pstmt.executeQuery() ;//Changed  for PE By Sudhakar

			String site = "" ;
			if(rset !=null)	{
				if(rset.next()) {
					
					site = (rset.getString("SITE_NAME") == null)?"":(rset.getString("SITE_NAME")); //Modified by Ashwini on 13-Nov-2018 for ARYU-SCF-0159 and TBMC-SCF-0003

					display_user_name_yn= rset.getString("DISPLAY_USER_NAME_YN");//Changed  for PE By Sudhakar
				}
			}
			if(rset !=null) rset.close();
			if(pstmt !=null) pstmt.close();
			if(rset !=null) rset.close();
			pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,p_user_name);
			rset = pstmt.executeQuery();
			
			if(rset !=null)	{
				if(rset.next()) {
					jdbc_user = rset.getString("APPL_USER_NAME");
					jdbc_user_id = rset.getString("APPL_USER_ID");
					facility_name = rset.getString("FACILITY_NAME");
				}
			}
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			
			/*Prasanna*/
			/**
			* Code to check if the alerts icon is to be displayed or not.
			*/
			String masterConfigCode = "";
			String masterConfigValue = "";
			String strSql = "SELECT MASTER_CONFIG_CODE, MASTER_CONFIG_VALUE FROM UA_ALERT_MASTER_CONFIG WHERE MASTER_CONFIG_CODE = 'USEALERT'";
			pstmt = con.prepareStatement(strSql);
			rset = pstmt.executeQuery();
			
			if(rset != null){
				if(rset.next()){
					masterConfigCode = rset.getString("MASTER_CONFIG_CODE");
					masterConfigValue = rset.getString("MASTER_CONFIG_VALUE");
				}
			}
			if(masterConfigValue == "")
				masterConfigValue = "N";
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			/*Prasanna*/
			
			ConnectionManager.returnConnection(con);
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script>
/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/
/*For ALT+F4*/
	window.onbeforeunload = function (e) {
		e = e || window.event;
			if(e.altKey && e.keyCode==0){
			fnLogout("<%=p_user_name%>");
		}
	}
/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/
</script>
</head>

<!--onLoad Added by Ashwini on 27-Jul-2020 for ML-MMOH-CRF-1549-->
<body class="HEADER" OnMouseDown='CodeArrest()' <%if(("DEF_DURATION").equals(lic_key)){%>onLoad = "LoginLicenceValidation('<%=lic_exp_yn%>');"<%}%> onKeyDown = 'lockKey()'>
<%

if (!called_from_ca_yn.equals("Y")) { %>

<table width="100%" border="0" cellpadding=0 cellspacing=0>
  <tr>
    <td width='100%' align="left" class="HEADERTITLE">&nbsp;<font size="2"><%= session.getAttribute("product_description") %>
      <label class="version">(Version <%= session.getAttribute("version_no") %>) </label>
      </font></td>
  </tr>
</table>
<%}%>
 
 <table width="100%" cellpadding=0 cellspacing=0>
	
<tr class="HEADER">
      <td class="HEADER" align="center" width="5%" id='headerImageID'>
		<img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo" width="40" height="40">
    </td>
  <td class="HEADER" align="left" width="42%"><b><font size="-1"><%= facility_name %><BR>
    <%=site%> </font></b></td>
  <td class="HEADER" align="left" width="23%"><b><font size="-1">
    <%if(display_user_name_yn.equals("Y")){ %>
	<%= jdbc_user %>
    <%}else{%>
    <%= jdbc_user_id %>
    <%}%>
    </font> </b></td>
  <td class="HEADER" align="left" width="20%" nowrap style="height:50px;"><font size="-1"> <b> 
    
    <!-- added date/time -->
    <div id="datetime" style="font-size: 80%; text-align: center; padding: 2px" value=""> </div>
    <!-- end- added date/time -->

    <%
    %>
    </b> </font></td>
  <%if(masterConfigCode.equalsIgnoreCase("USEALERT") && masterConfigValue.equalsIgnoreCase("Y")){ %>
  <td class="HEADER" align = "left" widht="5%" nowrap><jsp:include page="AlertHeader.jsp"/>
</td>
<% }%>
<!--Modified by kamatchi s for PMG2021-COMN-CRF-0002-->
<td class="HEADER" align="center" width="5%" style="padding-right:10px;" ><img src="../images/DXC_logo.png" alt="Dedalus" height="22px" width="158px"></td>
<tr></tr>
</tr>
</table> 
<div id="desktopheader" >
<%
	if(desktop_code!=null && desktop_summary_type.equals("N")) {

%>
		<jsp:include page="../../eCommon/jsp/UserDeskTopTitle.jsp" flush="true"/>					
		
<%
	}
%> 
</div>
</body>
<Script Language="VBScript">

'Set WshShell33 = CreateObject("WScript.Shell")
'WshShell33.SendKeys "{F11}"

</Script>
<script>

	function displaydatetime(){
		document.getElementById('datetime').innerHTML = getCurrentDate("DMYHM","<%=locale%>");	
		
		
	}

	window.setInterval("displaydatetime()", "60000");
	displaydatetime();
	
</script>

