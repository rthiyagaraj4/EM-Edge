<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       		Edit History      Name        		Description
-----------------------------------------------------------------------
?             	100            		?           		created
21/10/2015		IN057196		Ramesh G		Recording Of Consent Form
-----------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, java.text.*, java.net.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
   <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
  <script language='javascript' src="../../eOR/js/EncSearchCriteria.js"></script>
  <script language='javascript' src="../../eOR/js/EncSearchMain.js"></script>
  <Script language='javascript' src='../../eMP/js/natAltIDComponentCriteria.js'></Script>
<Script src="../../eMP/js/SmartCard.js" language="JavaScript"></Script>
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
</head>
<body OnMouseDown='CodeArrest();' onLoad='FocusFirstElement()' onKeyDown='lockKey()'>
<form name='enc_search_form' id='enc_search_form'>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  String locale           = (String) session.getAttribute("LOCALE");
  String cnsnt_with_order_yn=request.getParameter("cnsnt_with_order_yn")==null?"N":request.getParameter("cnsnt_with_order_yn"); //IN057196
  Connection con = ConnectionManager.getConnection(request);
  Statement stmt = null;
  PreparedStatement pstmt	= null;
  ResultSet rs			= null ;


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
	String nat_id_onKeyPress = "";
	String alt_id1_accept_alphanumeric_yn = "";
	
	String patient_id		= request.getParameter("patient_id");
	String alert_reqd_yn	= request.getParameter("alert_reqd_yn");
    String hidetbl	= request.getParameter("hidetbl")==null?"":request.getParameter("hidetbl"); 
	String validateIDFn = "";
    String validateIdYN	= request.getParameter("validateIdYN")==null?"Y":request.getParameter("validateIdYN"); 

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

  String pat_id_length = "";
	try 
	{
		String jsp_name =request.getParameter("jsp_name");
		if( jsp_name == null) jsp_name="";
		String window_styl=request.getParameter("window_styl");
		if( window_styl == null) window_styl="";
		String close_yn	=request.getParameter("close_yn");
		if( close_yn == null) close_yn="";
		String win_top =request.getParameter("win_top");
		if( win_top == null) win_top="";
		String win_height =request.getParameter("win_height");
		if(win_height ==null) win_height="";
		String win_width =request.getParameter("win_width");
		if( win_width == null) win_width="";
		
		String call_function=request.getParameter("call_function");
		if(call_function == null) call_function="";		

		String modal=request.getParameter("modal");
		if(modal == null) modal="";			
		String dialogTop =request.getParameter("dialogTop");
		if(dialogTop ==null) dialogTop="";			
		
		String module=request.getParameter("module");
		if(module == null) module="";

		String model_window=request.getParameter("model_window");
		if( model_window == null) model_window="";
		
		String function_id=request.getParameter("function_id");
		if( function_id == null) function_id="";
		
		String prog_id=request.getParameter("prog_id");
		if( prog_id == null) prog_id="";

		String practitioner_id=request.getParameter("practitioner_id");
		if( practitioner_id == null) practitioner_id="";
		
		String wherecondn = request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	

		String operstn	= request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	

		String encounterID_repDischargeAdvice=request.getParameter("encounter_id");
		if( encounterID_repDischargeAdvice == null) encounterID_repDischargeAdvice="";
		String loginUser = (String)session.getValue("login_user");
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String SystemDate = "";

			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') SystemDate from dual");
 				 if (rs.next() && rs != null)
					 SystemDate = rs.getString(1);
			
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
			}
			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select patient_id_length from mp_param");
 				 if (rs.next() && rs != null)
					 pat_id_length = rs.getString(1);

			}catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
			}
			String SystemDate_display = DateUtils.convertDate(SystemDate,"DMY" ,"en",localeName);
%>
	



<%
		
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
				 "        nat_id_check_digit_id,nat_data_source_id,ext_system_interface_yn"+
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
		<table id='moreCrite1' border='0' cellpadding='3' cellspacing='0' width='100%' height='auto' >
		<%}else{%>
		<table id='moreCrite1' border='0' cellpadding='3' cellspacing='0' width='100%' height='auto' >
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
					 interface_btn = "<input type='button' value='M' class= 'button' name='myKadBtn' id='myKadBtn' onClick=\"ReadDF2_onclick('CC','NC');\">";
				 } else {
					 interface_btn = "";
				 }
		%>
		<tr>
				<td class='label' width='25%'  ><span><%=nat_id_prompt%></span></td>				
				<td class='fields'  width='25%'><span><input type='text' name='national_id_no' id='national_id_no' maxlength='<%= nat_id_length %>' onKeyPress='return <%=nat_id_onKeyPress%>' size='27' onBlur='validateID(this,"<%=nat_id_check_digit_id%>");' value="<%=national_id_no%>" <%=disabledFields%>><%=interface_btn%></span></td>
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
				<td class='label' width='25%'><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
				
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
				<td class=label width='25%'><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'><input type='text' name='other_alt_Id' id='other_alt_Id' value="" size='27' maxlength='15' disabled></td>
				<input type='hidden' name='alert_reqd_yn' id='alert_reqd_yn' value='<%=alert_reqd_yn%>'>
			<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->
				<input type='hidden' name='mr_transaction' id='mr_transaction' value="<%=mr_transaction%>">	
			<!-- Addition Ends -->
				<%
			}
			else if(!Accept_oth_alt_id_yn.equals("Y") && mr_transaction.equals("Y"))
			{
				%>
				<td  class='label'  width='25%'>&nbsp;</td>
				<td  class='label'  width='25%'>&nbsp;</td>
				<td  class='label' width='25%' >&nbsp;</td>
				<td  class='label'  width='25%'>&nbsp;</td>
			<!-- Added on 21.08.2004 By Sen for disabling alerts when called from Medical Records -->
				<input type='hidden' name='mr_transaction' id='mr_transaction' value="<%=mr_transaction%>">	
			<!-- Addition Ends -->
			 	<%
			}
			else 
			{
				%>
				<td  class='label' width='25%' >&nbsp;</td>
				<td  class='label'  width='25%'>&nbsp;</td>
				<td  class='label'  width='25%'>&nbsp;</td>
				<td  class='label'  width='25%'>&nbsp;</td>
				<%
			} 
			%></TR>
			<TR>		
			<%
			if(!alt_id1_type.equals(""))
			{
				%>
				<td class='label'   width='25%'><%=alt_id1_desc%></td>
				<td  class='fields' width='25%'><input type='text' name='alt_id1_no' id='alt_id1_no' <%=validateIDFn%> onKeyPress='return CheckForSpeclChars(event)' size='27' maxlength="<%=alt_id1_length%>" value="<%=alt_id1_no%>"  <%=disabledFields%>>
				<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value="<%=alt_id1_reqd_yn%>">
				<input type='hidden' name='alt_id1_type' id='alt_id1_type' value="<%=alt_id1_type%>"></td>
				<input type='hidden' name='alt_id1_accept_alphanumeric' id='alt_id1_accept_alphanumeric' value="<%=alt_id1_accept_alphanumeric_yn%>"></td>
				<%
			}
			else
			{
				%><td  class='label'  width='25%'>&nbsp;</td>
				<td  class='label' width='25%' >&nbsp;</td><%
			}
			
			if(!alt_id2_type.equals(""))
			{
				%>
				<td class='label' width='25%'><%=alt_id2_desc%></td>
				<td  class='fields' width='25%'><input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='//validateID(this);'  size='27' maxlength="<%=alt_id2_length%>" value="<%=alt_id2_no%>"  <%=disabledFields%>>
				<input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value="<%=alt_id2_reqd_yn%>">
				<input type='hidden' name='alt_id2_type' id='alt_id2_type' value="<%=alt_id2_type%>">
				</td>
				<%
			}
			else
			{
				%><td  class='label'  width='25%'>&nbsp;</td>
					<td  class='label'  width='25%'>&nbsp;</td><%
			}
			%>
			</tr>
			<tr><%
			if(!alt_id3_type.equals(""))
			{
				%>
				<td class='label' width='25%'><%=alt_id3_desc%></td>
				
				<td  class='fields'  width='25%'><input type='text' name='alt_id3_no' id='alt_id3_no' onBlur='//validateID(this);' size='27' maxlength="<%=alt_id3_length%>" value="<%=alt_id3_no%>"  <%=disabledFields%>>
				<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value="<%=alt_id3_reqd_yn%>">
				<input type='hidden' name='alt_id3_type' id='alt_id3_type' value="<%=alt_id3_type%>">
				</td>
				<%
			}
			else
			{
				%><td  class='label'  width='25%'>&nbsp;</td>
					<td  class='label'  width='25%'>&nbsp;</td><%
			}
		
			if(!alt_id4_type.equals(""))
			{
				%>
				<td class='label' width='25%' ><%=alt_id4_desc%></td>
				<td  class='fields'  width='25%' ><input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='//validateID(this);' size='27' maxlength="<%=alt_id4_length%>" value="<%=alt_id4_no%>" <%=disabledFields%>>
				<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value="<%=alt_id4_reqd_yn%>">
				<input type='hidden' name='alt_id4_type' id='alt_id4_type' value="<%=alt_id4_type%>"></td>
				<%
			}
			else
			{
				%><td  class='label' width='25%' >&nbsp;</td>
					<td  class='label' width='25%'>&nbsp;</td><%
			}
			%>
			</tr>
	<%
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) 
	{ 
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	
%>			
	<tr>
				<td width='25%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td width='25%' class="fields"><input type='text'  name='PatientId' id='PatientId' size="20" maxlength="65" onKeypress='return CheckForSpecChars(event);' align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'><img src='../../eCommon/images/mandatory.gif' align='center' id='encTypePatID' style="visibility:hidden"></img>
				<td class="label" width="25%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="fields" width="25%"><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this);EncTypeMand(this);"></td>			
	</tr>
	<tr>
		<td class="label" width="25%"><fmt:message key="eMR.EncPeriod.label" bundle="${mr_labels}"/></td>
		<td class="fields" width="25%"><input type="text" name="alt_id1_exp_date" id="alt_id1_exp_date"  style="width:60px" maxlength='10' id='altidexpdt1'  onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(this,alt_id2_exp_date);" onkeypress="return Valid_DT(event)"></input><img src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].alt_id1_exp_date.focus();return showCalendar('altidexpdt1');">-<input type="text" name="alt_id2_exp_date" id="alt_id2_exp_date"  maxlength='10' id='altidexpdate2' style="width:60px" onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(alt_id1_exp_date,this);" onkeypress="return Valid_DT(event)" ></input><img src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].alt_id2_exp_date.focus();return showCalendar('altidexpdate2');">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id='encDate_img' style="visibility:hidden"></img></td>

<%	
	
	if( call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL"))
		{	%>
			<script>
				document.forms[0].patID_img.style.visibility = "hidden";
				document.forms[0].alt_id1_exp_date.value = "<%=SystemDate_display%>";
				document.forms[0].alt_id2_exp_date.value = "<%=SystemDate_display%>";
			</script>
	
	<%
		}	
		
	%>
		
	<%	
	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
	%>			
			<td width="25%" class="label" ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
			<td  class="fields">
				<select name="lstPatientClass" id="lstPatientClass" onChange="chkMandPatient(this);">
				<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%	
					if(rs != null) rs.close();
										
					rs = stmt.executeQuery("select patient_class, short_desc from am_patient_class_lang_vw where language_id='"+locale+"' order by 1");
					

					if(rs != null)
					{									
						while (rs.next())
						{	
						%>
							<option value='<%=rs.getString("patient_class")%>'><%=rs.getString("short_desc")%></option>
						<%
						}
					}	
					if(rs!=null) rs.close();
					
					%>

					</select><img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img' name='encType_img' style="visibility:hidden"></img></td>

	<% 
	}
	else 
	{ 
	%>
				<td width='25%' class='label'></td>			
				<td width='25%' class='label'></td>	
	<% 
	} 
%>
</tr>

<% if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("DIAG_RECODE") || call_function.equals("MR_VIEW_DTH_REG"))
{
%>
	<tr>
	<% 
	  if (call_function.equals("MR_VIEW_DTH_REG"))
		{
	%>
			<td width="25%" class="label" ><fmt:message key="eMR.DeceasedPeriod.label" bundle="${mr_labels}"/></td>
			<td width="25%" class="fields"><input name='p_discharge_date_from' id='p_discharge_date_from'  onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(this,p_discharge_date_to);DscdPeriodChk(this);" value='' size='10' maxlength='10' onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].p_discharge_date_from.focus();return showCalendar('p_discharge_date_from','dd/mm/y',null );" ></input>-<input name='p_discharge_date_to' id='p_discharge_date_to'  value='' size='10' maxlength='10' onblur="validDateObj(this,'DMY','<%=locale%>');ComparePeriodFromToTime(p_discharge_date_from,this);DscdPeriodChk(this);" onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_discharge_date_to','dd/mm/y',null );"></input></td>
	<%
		} 
		else 
		{
	%>
			<td width="25%" class="label"><fmt:message key="eMR.DischPeriod.label" bundle="${mr_labels}"/></td>
			<td width="25%" class="fields"><input name='p_discharge_date_from' id='p_discharge_date_from'  value='' size="10" maxlength='10' onkeypress="return Valid_DT(event)" onblur='validDateObj(this,"DMYHM","<%=locale%>");CompareDisPeriodFromToTime(this,p_discharge_date_to);disChargePeriodChk(this);'><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_discharge_date_from',null,'hh:mm' );"></input><input name='p_discharge_date_to' id='p_discharge_date_to' id='p_discharge_date_to' value='' size="10" maxlength='10' onblur="validDateObj(this,'DMYHM','<%=locale%>');CompareDisPeriodFromToTime(p_discharge_date_from,this);disChargePeriodChk(this);'" onkeypress="return Valid_DT(event)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_discharge_date_to',null,'hh:mm' );"></input><img src='../../eCommon/images/mandatory.gif' align='center' id='DischDate_img' style="visibility:hidden"></img></td>

	<% 
	} 
	if(call_function.equals("DIAG_RECODE"))
	{
	%>

		<script>
			document.forms[0].p_discharge_date_to.value = "<%=SystemDate_display%>";
			document.forms[0].p_discharge_date_from.value = "<%=SystemDate_display%>";
			document.forms[0].patID_img.style.visibility = "hidden";
		    document.forms[0].encDate_img.style.visibility = "hidden";
		</script>
	<%
	}
	%>
		<td width="25%"  class='label'>&nbsp;</td>			
		<td width="25%"   class='label'>&nbsp;</td>		
		<td width="25%"   class='label'>&nbsp;</td>		
		<td width="25%"   class='label'>&nbsp;</td>		
	</tr>
<% } %>
	<tr>
		<td class="label" width="25%" nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td nowrap width="25%" ><select name="orderBy" id="orderBy"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value="ED" selected><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></option>
			<option value="ET"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></option>
			</select>		
		</td>
		<td class="label" width="25%"></td>
		<td class="label" width="25%"></td>
	</tr>
	<tr>
		<%
			if(call_function.equals("MR_REC_PAT_VAL"))
			{
		%>
				<td width="25%" class='label' colspan='1'><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></td>
				<td width="25%"  class='fields' colspan='1'><input type="checkbox" name="discharge_val" id="discharge_val" onclick="callcheck_val();"></td>
		<%
			}
			else 
			{
			%>
				<td width="25%" colspan='1'></td>
				<td  width="25%" colspan='1'></td>

			<%
			}
			%>
			<td width="25%" class='label' colspan='1'></td>
			<td width="25%" class='button' colspan=3 nowrap><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'></td>
		</tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
     </div>

	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
	<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='SystemDate' id='SystemDate' value="<%=SystemDate%>" >
	<input type='hidden' name='qerString' id='qerString' value="<%=request.getQueryString()%>" >

     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBIPFFPRC'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='sys_date' id='sys_date' value=''></input>
	 <input type='hidden' name='cnsnt_with_order_yn' id='cnsnt_with_order_yn' value='<%=cnsnt_with_order_yn%>'></input>  <!-- IN057196 -->

	<%	
	if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") )
	{	
	%>
		<script>
			 document.getElementById('encType_img').style.visibility = 'visible';
			 document.forms[0].encDate_img.style.visibility = 'visible';
		</script>
	<%
	}
	if(call_function.equals("DIAG_RECODE"))
	{
	%>
		<script>
			 document.forms[0].DischDate_img.style.visibility = 'visible';
			 document.getElementById('encType_img').style.visibility = 'visible';
		</script>
		 
	 <%
	}
	 if(call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
	{
	%>
			<script>
				 document.getElementById('encType_img').style.visibility = 'visible';
			</script>
		 
	 <%
	 }
     } catch(Exception e) {
          //out.println(e.toString());//COMMON-ICN-0181
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
          e.printStackTrace();//COMMON-ICN-0181
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }
%>
  </form>
</body>

</html>
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

