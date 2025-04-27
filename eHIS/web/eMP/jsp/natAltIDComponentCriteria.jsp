<!DOCTYPE html>
<!-- Last Modified Date Time : 9/26/2005 4:24 PM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, java.text.*, java.net.*,eCommon.XSSRequestWrapper" %>
<Script language='javascript' src='../../eMP/js/natAltIDComponentCriteria.js'></Script>
<Script src="../../eMP/js/SmartCard.js" language="JavaScript"></Script>

<!-- Added by Ashwin K for AAKH-CRF-0150-->
<Script src="../../eMP/js/SmartCard01.js" language="JavaScript"></Script>
<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
		
<Script src="../../eMP/js/json02.js"></Script>

 <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
<!--<Script src="../../eCommon/js/jquery-3.6.0.min.js"></Script> -->
 <!-- Added By Ashwin K for AAKH-CRF-0150 -->
   
<link href="../../eCommon/html/jquery-ui.css" rel="stylesheet" type="text/css">
<!-- Ended By Ashwin K for AAKH-CRF-0150 -->






<%
	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	%>
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<%
	Connection con			= null;
    PreparedStatement pstmt	= null;
    ResultSet rs			= null ;
	
	con = ConnectionManager.getConnection(request);

	String sql							= "";
	String alt_id1_reqd_yn				= "";
	String alt_id2_reqd_yn				= "";
	String alt_id3_reqd_yn				= "";
	String alt_id4_reqd_yn				= "";
	String alt_id1_type					= "";
	String alt_id2_type					= "";
	String alt_id3_type					= "";
	String alt_id4_type					= "";
	String alt_id1_length				= "";
	String alt_id2_length				= "";
	String alt_id3_length				= "";
	String alt_id4_length				= "";
	String nat_id_length				= "";
	String alt_id1_exp_date_accept_yn	= "";
	String alt_id2_exp_date_accept_yn	= "";
	String alt_id3_exp_date_accept_yn	= "";
	String alt_id4_exp_date_accept_yn	= "";
	String accept_national_id_no_yn		= "";
	String nat_id_accept_alphanumeric_yn= "";
	String nat_id_prompt				= "";
	String alt_id1_desc					= "";
	String alt_id2_desc					= "";
	String alt_id3_desc					= "";
	String alt_id4_desc					= "";
	String alt_id1_no					= "";
	String alt_id2_no					= "";
	String alt_id3_no					= "";
	String alt_id4_no					= "";
	String national_id_no				= "";
	String alt_id1_exp_date				= "";
	String alt_id2_exp_date				= "";
	String alt_id3_exp_date				= "";
	String alt_id4_exp_date				= "";
	String disabledFields				= "";
	String Accept_oth_alt_id_yn			= "";
	String nat_id_check_digit_id = "";
	String nat_data_source_id = "";
	String ext_system_interface_yn = "";
	String biometric_authentication_yn="N";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	String nat_id_onKeyPress = "";
	String alt_id1_accept_alphanumeric_yn = "";
	String tab_name = checkForNull(request.getParameter("tab_name")); //Added by Ashwin K for AAKH-CRF-0150
	
	String patient_id		= request.getParameter("patient_id");
	String alert_reqd_yn	= request.getParameter("alert_reqd_yn");
    String hidetbl	= request.getParameter("hidetbl")==null?"":request.getParameter("hidetbl"); 
	String validateIDFn = "";
    String validateIdYN	= request.getParameter("validateIdYN")==null?"Y":request.getParameter("validateIdYN"); 
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 

	if(validateIdYN.equals("Y")) {
		validateIDFn = "onBlur='validateID(this);'";
	} else {
		validateIDFn = "";
	}

	//Added for disabling fields as per parameter obtained from OP

	String nat_id_disabled = request.getParameter("nat_id_disabled");
	if(nat_id_disabled == null) nat_id_disabled = "N";
	
	if(alert_reqd_yn == null) alert_reqd_yn = "N";
    if (patient_id==null || patient_id.equals("") || patient_id == "") patient_id = "";	
	if(nat_id_disabled.equals("N")) disabledFields = "";

	//Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records

	String mr_transaction = request.getParameter("mr_transaction") == null ? "N" : request.getParameter("mr_transaction");	
	
	try
	{
		if(!patient_id.equals(""))
		{
			disabledFields = "disabled";
			
			sql = "SELECT alt_id1_no, alt_id2_no, alt_id3_no, alt_id4_no, to_char(alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, to_char(alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date, to_char(alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, to_char(alt_id4_exp_date,'dd/mm/yyyy') alt_id4_exp_date, national_id_no FROM mp_patient WHERE patient_id = '"+patient_id+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();			
			
			if (rs!= null&&rs.next())
			{
			
				alt_id1_no = rs.getString("alt_id1_no");
				alt_id2_no = rs.getString("alt_id2_no");
				alt_id3_no = rs.getString("alt_id3_no");
				alt_id4_no = rs.getString("alt_id4_no");
				national_id_no = rs.getString("national_id_no");
				alt_id1_exp_date = rs.getString("alt_id1_exp_date");
				alt_id2_exp_date = rs.getString("alt_id2_exp_date");
				alt_id3_exp_date = rs.getString("alt_id3_exp_date");
				alt_id4_exp_date = rs.getString("alt_id4_exp_date");
			}
			if(alt_id1_no==null) alt_id1_no = "";
			if(alt_id2_no==null) alt_id2_no = "";
			if(alt_id3_no==null) alt_id3_no = "";
			if(alt_id4_no==null) alt_id4_no = "";
			if(national_id_no==null) national_id_no = "";
			if(alt_id1_exp_date==null) alt_id1_exp_date = "";
			if(alt_id2_exp_date==null) alt_id2_exp_date = "";
			if(alt_id3_exp_date==null) alt_id3_exp_date = "";
			if(alt_id4_exp_date==null) alt_id4_exp_date = "";
		}
		
		//for smart card
			pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

			rs = pstmt.executeQuery();	


			if(rs!=null && rs.next())
			{
			Smartcard_path=rs.getString("VALUE_1");
			function_name=rs.getString("VALUE_2");   // alkhaleej smart card

			}		


			if(pstmt!=null)
			pstmt.close();
			if(rs!=null)
			rs.close();
			//for smart card
		//sql = " SELECT nvl(Alt_Id1_reqd_yn,'N') Alt_Id1_reqd_yn, nvl(Alt_Id2_reqd_yn,'N')Alt_Id2_reqd_yn, nvl(Alt_Id3_reqd_yn,'N') Alt_Id3_reqd_yn, nvl(Alt_Id4_reqd_yn,'N') Alt_Id4_reqd_yn, Alt_Id1_type,substr(alt_id1.short_desc,1,15) alt_id1_desc, Alt_Id2_type, substr(alt_id2.short_desc,1,15) alt_id2_desc, Alt_Id3_type,substr(alt_id3.short_desc,1,15) alt_id3_desc, Alt_Id4_type, substr(alt_id4.short_desc,1,15) alt_id4_desc, nvl(Alt_Id1_length,0) Alt_Id1_length, nvl(Alt_Id2_length,0) Alt_Id2_length, nvl(Alt_Id3_length,0) Alt_Id3_length, nvl(Alt_Id4_length,0) Alt_Id4_length, nat_id_length, Accept_oth_alt_id_yn, alt_id1_exp_date_accept_yn, alt_id2_exp_date_accept_yn, alt_id3_exp_date_accept_yn, alt_id4_exp_date_accept_yn, accept_national_id_no_yn, nvl(nat_id_prompt,'National ID No') nat_id_prompt FROM mp_param, mp_alternate_id_type_lang_vw  alt_id1, mp_alternate_id_type_lang_vw  alt_id2, mp_alternate_id_type_lang_vw alt_id3, mp_alternate_id_type_lang_vw  alt_id4 WHERE alt_id1_type = alt_id1.alt_id_type AND alt_id2_type = alt_id2.alt_id_type(+) AND alt_id3_type = alt_id3.alt_id_type(+) AND alt_id4_type = alt_id4.alt_id_type(+) and alt_id1.language_id='"+locale+"' and alt_id2.language_id='"+locale+"' and alt_id3.language_id='"+locale+"' and  alt_id4.language_id='"+locale+"'";
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,"+
				 "        NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,"+
				 "        NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,"+
				 "        NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,"+
				 "        alt_id1_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,"+
				 "        alt_id2_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,"+
				 "        alt_id3_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,"+
				 "        alt_id4_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,"+
				 "        NVL(alt_id1_length,0) alt_id1_length,"+
				 "        NVL(alt_id2_length,0) alt_id2_length,"+
				 "        NVL(alt_id3_length,0) alt_id3_length,"+
				 "        NVL(alt_id4_length,0) alt_id4_length,"+
				 "        nat_id_length,"+
				 "        accept_oth_alt_id_yn,"+
				 "        alt_id1_exp_date_accept_yn,"+
				 "        alt_id2_exp_date_accept_yn,"+
				 "        alt_id3_exp_date_accept_yn,"+
				 "        alt_id4_exp_date_accept_yn,"+
				 "        accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_alphanumeric_yn,"+
				 "        NVL(nat_id_prompt,'National ID No') nat_id_prompt,"+
				 "        nat_id_check_digit_id,nat_data_source_id,ext_system_interface_yn,biometric_authentication_yn"+
				 " FROM   mp_param_lang_vw"+
				 " WHERE  module_id = 'MP' and language_id='"+localeName+"'";

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs != null)
		{
			while(rs.next())
			{
				alt_id1_reqd_yn				= rs.getString("Alt_Id1_reqd_yn");
				alt_id2_reqd_yn				= rs.getString("Alt_Id2_reqd_yn");
				alt_id3_reqd_yn				= rs.getString("Alt_Id3_reqd_yn");
				alt_id4_reqd_yn				= rs.getString("Alt_Id4_reqd_yn");
				alt_id1_type				= rs.getString("Alt_Id1_type");
				alt_id2_type				= rs.getString("Alt_Id2_type");
				alt_id3_type				= rs.getString("Alt_Id3_type");
				alt_id4_type				= rs.getString("Alt_Id4_type");
				alt_id1_length				= rs.getString("Alt_Id1_length");
				alt_id2_length				= rs.getString("Alt_Id2_length");
				alt_id3_length				= rs.getString("Alt_Id3_length");
				alt_id4_length				= rs.getString("Alt_Id4_length");
				nat_id_length				= rs.getString("nat_id_length");
				alt_id1_exp_date_accept_yn	= rs.getString("alt_id1_exp_date_accept_yn");
				alt_id2_exp_date_accept_yn	= rs.getString("alt_id2_exp_date_accept_yn");
				alt_id3_exp_date_accept_yn	= rs.getString("alt_id3_exp_date_accept_yn");
				alt_id4_exp_date_accept_yn	= rs.getString("alt_id4_exp_date_accept_yn");
				accept_national_id_no_yn	= rs.getString("accept_national_id_no_yn");
				nat_id_accept_alphanumeric_yn	= rs.getString("nat_id_accept_alphanumeric_yn");
				nat_id_prompt 				= rs.getString("nat_id_prompt");
				nat_id_check_digit_id		= rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
				nat_data_source_id		= rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
				ext_system_interface_yn		= rs.getString("ext_system_interface_yn")==null?"":rs.getString("ext_system_interface_yn");
				alt_id1_desc 				= rs.getString("alt_id1_desc");
				alt_id2_desc 				= rs.getString("alt_id2_desc");
				alt_id3_desc 				= rs.getString("alt_id3_desc");
				alt_id4_desc 				= rs.getString("alt_id4_desc");
				Accept_oth_alt_id_yn 		= rs.getString("Accept_oth_alt_id_yn");
				alt_id1_accept_alphanumeric_yn 		= rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");
				biometric_authentication_yn 		= rs.getString("biometric_authentication_yn")==null?"N":rs.getString("biometric_authentication_yn");//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
				
			}
		}

		if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";
		if(alt_id2_exp_date_accept_yn == null) alt_id2_exp_date_accept_yn = "N";
		if(alt_id3_exp_date_accept_yn == null) alt_id3_exp_date_accept_yn = "N";
		if(alt_id4_exp_date_accept_yn == null) alt_id4_exp_date_accept_yn = "N";
		if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
		if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";
		if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N";
		if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";
		if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";
		if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";
		if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";
		if(alt_id1_length == null) alt_id1_length = "0";
		if(alt_id2_length == null) alt_id2_length = "0";
		if(alt_id3_length == null) alt_id3_length = "0";
		if(alt_id4_length == null) alt_id4_length = "0";
		if(nat_id_length == null) nat_id_length = "0";
		if(nat_id_prompt == null) nat_id_prompt = "";
		if(nat_id_check_digit_id == null) nat_id_check_digit_id = "";
		if(alt_id1_type == null) alt_id1_type = "";
		if(alt_id2_type == null) alt_id2_type = "";
		if(alt_id3_type == null) alt_id3_type = "";
		if(alt_id4_type == null) alt_id4_type = "";
		if(alt_id1_desc == null) alt_id1_desc = "";
		if(alt_id2_desc == null) alt_id2_desc = "";
		if(alt_id3_desc == null) alt_id3_desc = "";
		if(alt_id4_desc == null) alt_id4_desc = "";
		
		
		if(hidetbl.equals("Y"))
		{%>
		<table cellpadding='2' border='0' cellspacing='0' width='100%' id='moreCrite1' Style="display:none;visibility:hidden">
		<%}else{%>
		<table cellpadding='2' border='0' cellspacing='0' width='100%' id='moreCrite1' >
		<%}
		if(accept_national_id_no_yn.equals("Y"))
			{
				/*
				if ( nat_id_check_digit_id.equals("M11") )
					nat_id_onKeyPress = " return CheckForCharsNatID(event);";
				else
					nat_id_onKeyPress = "return allowValidNumber(this,event,2, 0);";
				*/
				
				 if(nat_id_accept_alphanumeric_yn.equals("Y"))
				 {
					nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
				 }
				 else
				 {
					if(nat_id_check_digit_id.equals("M11"))
						nat_id_onKeyPress = "CheckForCharsNatID(event);";
					else
						nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
				 }
				 String interface_btn = "";
				 if(ext_system_interface_yn.equals("Y") && nat_id_check_digit_id.equals("") && nat_data_source_id.equals("NRIC")) {
					 //Added id='M_btn2' by Ashwin K for AAKH-CRF-0150
					if(function_name.equals("01") && (tab_name.equals("addvisit_tab") ||tab_name.equals("checkin_tab")))
					{
					interface_btn = "<input type='button' value='M' id='M_btn2' class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"MButton_click_AddVisit()\">";
						
					interface_btn = interface_btn+" <input type='checkbox' id='AddVisit_EmiratesID_edit' name='AddVisit_EmiratesID_edit' id='AddVisit_EmiratesID_edit'  >";
					 }
					else if(function_name.equals("05") && (tab_name.equals("addvisit_tab") ||tab_name.equals("checkin_tab")))
					{//Added  by santhosh for TH-KW-CRF-0019.1
					interface_btn = "<input type='button' value='M' id='M_btn2' class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"MButton_click_OPRegVisit()\">";
						
					 }
					 else if(function_name.equals("07")) {
						 interface_btn = "";
					 }
					 else
					 {
						interface_btn = "<input type='button' value='M'  class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"ReadDF2_onclick('CC','NC');\">";
					 }
					// Ended By Ashwin K for AAKH-CRF-0150 
				 } else {
					 interface_btn = "";
				 }
		%>
		<tr>
				<td class='label' width='25%'  ><%=nat_id_prompt%>
				<%if(function_name.equals("01")){%>
						<!-- <applet code="CardReaderApplet.class" name="CardReader"
						codebase="../../eMP/CardReader/" archive="CardReaderApplet.jar" width="5"
						height="5">
						<PARAM name="button_width" value="0" />
						<PARAM name="button_height" value="0" />
						<PARAM name="button_label" value="0" />						
						<param name="separate_jvm" value="true" />
						Sorry, Your browser does not support Java applet!
						</applet> -->

<!--
							 <APPLET style="border:solid 1px gray" id="PublicDataWebComponent" name="PublicDataWebComponent" codebase="../../eMP/CardReader/" CODE="emiratesid.jio.webcomponents.PublicDataReader"
                                                        ARCHIVE="PublicDataApplet-Sagem.jar" WIDTH="0" HEIGHT="0">
                                                        <param name="EncryptParameters" value="false" />
                                                        <param name="RelativeCertPath" value="certs" />
														<param name="separate_jvm" value="true" />
														<PARAM name="button_label" value="0" />	
                                                         This browser does not support Applets.
                                                    </APPLET> -->

													<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->
												 <APPLET style="border:solid 1px gray" id="PublicDataWebComponent" name="PublicDataWebComponent" codebase="../../eMP/CardReader/" CODE="emiratesid.jio.webcomponents.PublicDataReader"
                                                        ARCHIVE="PublicDataApplet-Sagem.jar" WIDTH="0" HEIGHT="0">
                                                        <param name="EncryptParameters" value="false" />
                                                        <param name="RelativeCertPath" value="certs" />
														<param name="separate_jvm" value="true" />
														<PARAM name="button_label" value="0" />	
                                                         This browser does not support Applets.
                                                    </APPLET> 
						<%}%>
				</td>	
				<!-- Added By  Ashwin K id="national_id_no"  for AAKH-CRF-0150 -->
				<td class='fields'  width='25%'><input type='text' <% if(function_name.equals("01") && (tab_name.equals("addvisit_tab") ||tab_name.equals("checkin_tab")) ){ %> id="national_id_no" <% } %> name='national_id_no' maxlength='<%= nat_id_length %>' onKeyPress='return <%=nat_id_onKeyPress%>' size='27' onBlur='validateID(this,"<%=nat_id_check_digit_id%>");' value="<%=national_id_no%>" <%=disabledFields%>><%=interface_btn%>
		
				</td>

				<%
			}
			else
			{
				%>
		<tr>	
				<td class='label'  width='25%'>&nbsp;</td>
				<td class='label'  width='25%'>&nbsp;</td>
				<input type='hidden' name='national_id_no' id='national_id_no' value="">
				<%
			}
			%>
		<input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='<%=nat_id_accept_alphanumeric_yn%>'>
		<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='<%=nat_id_prompt%>'>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label'  width='25%'>&nbsp;</td>
		</tr>
		<tr>
			<input type='hidden' name='h_accept_oth_alt_id_yn' id='h_accept_oth_alt_id_yn' value="<%=Accept_oth_alt_id_yn%>">
			<%
			if(Accept_oth_alt_id_yn.equals("Y"))
			{
				%>
				<td class='label'><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
				
				<td class='fields' width='25%'><select onchange='enabledFields(this);' name='other_alt_type' id='other_alt_type'  <%=disabledFields%>><option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
				sql = "SELECT alt_id_type,long_desc FROM mp_alternate_id_type_lang_vw   WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM) and EFF_STATUS='E' and language_id='"+locale+"' ORDER BY SHORT_DESC";
			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();	
		
				if(rs != null)
				{
					while(rs.next())
					{
						%>		
						<option value="<%=rs.getString("alt_id_type")%>"><%=rs.getString("long_desc")%></option>
						<%
					}
				}
				%>
				</select></td>
				<td class=label ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
				<!-- Lnk Inc: 48147 - Modified the maximum length of other_alt_id field as 20-->
				<td class='fields' ><input type='text' name='other_alt_Id' id='other_alt_Id' value="" size='20' maxlength='20' disabled onKeyPress='return SpecialCharRestriction(event)' onBlur='validateID(this);'></td>
				<input type='hidden' name='alert_reqd_yn' id='alert_reqd_yn' value='<%=alert_reqd_yn%>'>
			<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->
				<input type='hidden' name='mr_transaction' id='mr_transaction' value="<%=mr_transaction%>">	
			<!-- Addition Ends -->
				<%
			}
			else if(!Accept_oth_alt_id_yn.equals("Y") && mr_transaction.equals("Y"))
			{
				%>
				<td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td>
			<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->
				<input type='hidden' name='mr_transaction' id='mr_transaction' value="<%=mr_transaction%>">	
			<!-- Addition Ends -->
			 	<%
			}
			else 
			{
				%>
				<td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td>
				<%
			} 
			%></TR>
			<TR>		
			<%
			if(!alt_id1_type.equals(""))
			{
				%>
				<!--below code change done for SRR20056-SCF-12671-->
				<td class='label'   ><%=alt_id1_desc%></td>
				<td  class='fields' ><input type='text' name='alt_id1_no' id='alt_id1_no' <%=validateIDFn%> onKeyPress='return CheckForSpeclChars(event)' size='27' maxlength="<%=alt_id1_length%>" value="<%=alt_id1_no%>"  <%=disabledFields%>>
				<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value="<%=alt_id1_reqd_yn%>">
				<input type='hidden' name='alt_id1_type' id='alt_id1_type' value="<%=alt_id1_type%>"></td>
				<input type='hidden' name='alt_id1_accept_alphanumeric' id='alt_id1_accept_alphanumeric' value="<%=alt_id1_accept_alphanumeric_yn%>"></td>
				<%
			}
			else
			{
				%><td  class='label'  >&nbsp;</td>
				<td  class='label'  >&nbsp;</td><%
			}
			
			if(!alt_id2_type.equals(""))
			{
				%>
				<td class='label' ><%=alt_id2_desc%></td>
				<!--below code change done for SRR20056-SCF-12671-->
				<td  class='fields' ><input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='//validateID(this);'  size='27' onKeyPress='return altID234Validations(event)' maxlength="<%=alt_id2_length%>" value="<%=alt_id2_no%>"  <%=disabledFields%>>
				<input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value="<%=alt_id2_reqd_yn%>">
				<input type='hidden' name='alt_id2_type' id='alt_id2_type' value="<%=alt_id2_type%>">
				</td>
				<%
			}
			else
			{
				%><td  class='label'  >&nbsp;</td>
					<td  class='label'  >&nbsp;</td><%
			}
			%>
			</tr>
			<tr><%
			if(!alt_id3_type.equals(""))
			{
				%>
				<!--below code change done for SRR20056-SCF-12671-->
				<td class='label' ><%=alt_id3_desc%></td>
				
				<td  class='fields'  ><input type='text' name='alt_id3_no' id='alt_id3_no' onBlur='//validateID(this);' size='27' onKeyPress='return altID234Validations(event)' maxlength="<%=alt_id3_length%>" value="<%=alt_id3_no%>"  <%=disabledFields%>>
				<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value="<%=alt_id3_reqd_yn%>">
				<input type='hidden' name='alt_id3_type' id='alt_id3_type' value="<%=alt_id3_type%>">
				</td>
				<%
			}
			else
			{
				%><td  class='label'  >&nbsp;</td>
					<td  class='label'  >&nbsp;</td><%
			}
		
			if(!alt_id4_type.equals(""))
			{
				%>
				<!--below code change done for SRR20056-SCF-12671-->
				<td class='label'  ><%=alt_id4_desc%></td>
				<td  class='fields'   ><input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='//validateID(this);' size='27' onKeyPress='return altID234Validations(event)' maxlength="<%=alt_id4_length%>" value="<%=alt_id4_no%>" <%=disabledFields%>>
				<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value="<%=alt_id4_reqd_yn%>">
				<input type='hidden' name='alt_id4_type' id='alt_id4_type' value="<%=alt_id4_type%>"></td>
				<%
			}
			else
			{
				%><td  class='label'  >&nbsp;</td>
					<td  class='label' >&nbsp;</td><%
			}
			%>
			</tr>
		</table>
			<!--for smart card-->
	<input type="hidden" name="txtSmartcard_path" id="txtSmartcard_path" value="<%=Smartcard_path%>">
	<input type="hidden" name="txtSmartcard_dup" id="txtSmartcard_dup" value="">
	<input type="hidden" name="txtSmartcard_fn" id="txtSmartcard_fn" value="">
	<input type="hidden" name="txtSmartcard_pat_id" id="txtSmartcard_pat_id" value="">
	<!--for smart card-->
	<!--for Alkhaleej smart card-->
	<input type="hidden" name="txtSmart_fn_name" id="txtSmart_fn_name" value="<%=function_name%>">
	<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023-->
	<input type="hidden" name="biometric_authentication_yn" id="biometric_authentication_yn" value="<%=biometric_authentication_yn%>">
	
		<%
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) 
	{ 
		out.println(e.toString());
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
	<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	%>

<!-- Added By Ashwin K for AAKH-CRF-0150 -->
<script> 
$(document).ready(function(){
$("#M_btn2").prop('disabled', false); 
$("#national_id_no").prop('disabled', true);
$("#AddVisit_EmiratesID_edit").click(function()
 {
	 if($('#AddVisit_EmiratesID_edit').is(':checked'))
	 {
		var auth_userEmirates = EditEmiratesID_authScr();
		if(auth_userEmirates == true)
		 {
			$("#national_id_no").prop('disabled', false);
			$("#M_btn2").prop('disabled', true);
		 }
		else
		 {
		$('#AddVisit_EmiratesID_edit').prop('checked', false);
		 }
	 }
	 else
	 {
			$("#national_id_no").prop('disabled', true);
			$("#M_btn2").prop('disabled', false);
	 }
		  });
	});
async function EditEmiratesID_authScr()
{	
	var retVal=new Array();
	var dialogHeight= "10" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await window.showModalDialog("../../eSM/jsp/AuthorizeMain.jsp?mode=s",arguments,features);
	return retVal;

}
		function MButton_click_AddVisit()
			{
		 	var res = RegAttnSearch_ReadDF1_onclick(<%=function_name%>);
			var arr = res.split("!~");
			var res_natid = arr[0].replace(/^\s+|\s+$/gm,'');
			var res_mobno = arr[1].replace(/^\s+|\s+$/gm,'');
			var patcnt = 0;
			var p_id = "";	
			$.ajax({
				type: "POST",
				url: "../../eMP/jsp/getPatientCount.jsp",
				data: {
					NatID : res_natid,
					smart_data : res	
				},
				async: false
			})
			.done (function(data, textStatus, jqXHR) { 
			res = data;
			var res1 = res.substring(res.indexOf("<patcnt>")+8,res.indexOf("</patcnt>"));
			var res2 = res.substring(res.indexOf("<patid>")+7,res.indexOf("</patid>"));
			patcnt = parseInt(res1);
		p_id = res2;  
		});
if(patcnt == 0)
	{
	alert(getMessage('MOBILE_NO_SEARCH','MP'));
	getPatID_Mbtn(res_mobno);
	}
else
	{
	document.getElementById("pat_id1").value= p_id;
	document.getElementById('srch_code').click();
	}
	}
	function MButton_click_OPRegVisit()
			{
		 	var res = OPRegVisit_ReadDF1_onclick(<%=function_name%>);
			var arr = res.split("!~");
			var res_natid = arr[0].replace(/^\s+|\s+$/gm,'');
			var res_mobno = arr[1].replace(/^\s+|\s+$/gm,'');
			var patcnt = 0;
			var p_id = "";	
			$.ajax({
				type: "POST",
				url: "../../eMP/jsp/getPatientCount.jsp",
				data: {
					NatID : res_natid,
					smart_data : res	
				},
				async: false
			})
			.done (function(data, textStatus, jqXHR) { 
			res = data;
			var res1 = res.substring(res.indexOf("<patcnt>")+8,res.indexOf("</patcnt>"));
			var res2 = res.substring(res.indexOf("<patid>")+7,res.indexOf("</patid>"));
			patcnt = parseInt(res1);
		p_id = res2;  
		});
if(patcnt == 0)
	{
	alert(getMessage('MOBILE_NO_SEARCH','MP'));
	getPatID_Mbtn(res_mobno);
	}
else
	{
	document.getElementById("pat_id1").value= p_id;
	document.getElementById('srch_code').click();
	}
	}
	</script>
<!-- Ended By Ashwin K for AAKH-CRF-0150 -->

