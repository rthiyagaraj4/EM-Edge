<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*, java.util.*, java.text.*, java.net.*" contentType="text/html;charset=UTF-8" import ="java.sql.*" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<Script language='javascript' src='../../eMP/js/natAltIdComponent.js'></Script>
<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script language='javascript' src='../../eMP/js/SmartCard.js'></Script>
<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>			
<Script src="../../eMP/js/json02.js"></Script>
<Script src="../../eMP/js/jquery.min.js"></Script>	
<%
	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	%>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	Connection con = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null ;
	String sql="";
	String alt_id1_reqd_yn="";
	String alt_id2_reqd_yn="";
	String alt_id3_reqd_yn="";
	String alt_id4_reqd_yn="";
	String alt_id1_type="";
	String alt_id2_type="";
	String alt_id3_type="";
	String alt_id4_type="";
	String alt_id1_length="";
	String alt_id2_length="";
	String alt_id3_length="";
	String alt_id4_length="";
	String nat_id_length="";
	String pat_id_length = "";
	String citizen_yn = "Y";
	String alt_id1_exp_date_accept_yn="";
	String alt_id2_exp_date_accept_yn="";
	String alt_id3_exp_date_accept_yn="";
	String alt_id4_exp_date_accept_yn="";
	String accept_national_id_no_yn="";
	String nat_id_accept_alphanumeric_yn="";
	String alt_id1_accept_alphanumeric_yn = "";
	String alt_id1_exp_warn_yn = "";
	String nat_id_prompt="";
	String alt_id1_no = "";
	String alt_id2_no = "";
	String alt_id3_no = "";
	String alt_id4_no = "";
	String national_id_no = "";
	String alt_id1_exp_date = "";
	String alt_id2_exp_date = "";
	String alt_id3_exp_date = "";
	String alt_id4_exp_date = "";
	String disabledFields = "";
	String alt_id1_desc = "";
	String alt_id2_desc = "";
	String alt_id3_desc = "";
	String alt_id4_desc = "";
	String Accept_oth_alt_id_yn = "";

	String nat_id_chk_len = "";
	String  alt_id1_len_validation_yn = "";
    String  alt_id2_len_validation_yn = "";
	String  alt_id3_len_validation_yn = "";
	String  alt_id4_len_validation_yn = "";

	String defaultncode = "";
	String defaultndesc = "";

	String name_dervn_logic = "";
	String name_dervn_logic_long="";
	String name_dervn_logic_oth_lang_long="";

	String pat_name_as_multipart_yn= "";
	String patient_id = request.getParameter("patient_id");
	String call_function = request.getParameter("call_function");
	if(call_function == null) call_function = "";
	String ca_patient_id = request.getParameter("ca_patient_id");
	if(ca_patient_id==null) ca_patient_id = "";
	String op_call = request.getParameter("op_call");
	if(op_call == null) op_call = "";
	String alert_reqd_yn = request.getParameter("alert_reqd_yn");
	String bodyFrame = request.getParameter("bodyFrame");
	String ext_system_interface_yn="";
	String nat_data_source_id="";
	String dflt_patient_name = "";
	String nat_id_check_digit_id = "";
	String biometric_authentication_yn = "";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
	String nat_id_onKeyPress = "";
	//String appt_date=request.getParameter("i_appt_date");
	String readonly_yn = request.getParameter("readonly_yn")==null?"N":request.getParameter("readonly_yn");
	String Smartcard_path="" ; //added for smart card 
	String function_name="" ; //added for Alkhalej smart card 


	if(bodyFrame == null)
	{
		bodyFrame = "parent.frames[1]";
	}
	String submitFrame = request.getParameter("submitFrame");
	if(submitFrame == null)
	{
		submitFrame = "parent.frames[2]";
	}
	
	if(alert_reqd_yn == null) alert_reqd_yn = "N";
    if (patient_id==null||patient_id.equals("")||patient_id=="") patient_id="";
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try
	{
		con = ConnectionManager.getConnection(request);
		/*Added By Dharma on jan 17th 2014 for [IN:046495] Start*/
		boolean isAltId1ManNonCtz=eOP.QMSInterface.isSiteSpecific(con,"MP","ALT_ID1_MAN_NON_CTZN");
		/*Added By Dharma on jan 17th 2014 for [IN:046495] End*/

		if(!patient_id.equals(""))
		{
			disabledFields = "disabled";
			
			sql = "select alt_id1_no,alt_id2_no,alt_id3_no,alt_id4_no,to_char(alt_id1_exp_date,'dd/mm/yyyy')alt_id1_exp_date,to_char(alt_id2_exp_date,'dd/mm/yyyy')alt_id2_exp_date,to_char(alt_id3_exp_date,'dd/mm/yyyy')alt_id3_exp_date,to_char(alt_id4_exp_date,'dd/mm/yyyy')alt_id4_exp_date,national_id_no,citizen_yn from mp_patient where patient_id = '"+patient_id+"'";
			
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
				citizen_yn = rs.getString("citizen_yn");

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
		
	
		sql = "SELECT NVL(alt_id1_reqd_yn,'N') alt_id1_reqd_yn,"+
				 "        NVL(alt_id2_reqd_yn,'N') alt_id2_reqd_yn,"+
				 "        NVL(alt_id3_reqd_yn,'N') alt_id3_reqd_yn,"+
				 "        NVL(alt_id4_reqd_yn,'N') alt_id4_reqd_yn,"+
				 "        alt_id1_type,"+
				 "        alt_id2_type,"+
				 "        alt_id3_type,"+
				 "        alt_id4_type,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,"+
				 "        mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,"+
				 "        NVL(alt_id1_length,0) alt_id1_length,"+
				 "        NVL(alt_id2_length,0) alt_id2_length,"+
				 "        NVL(alt_id3_length,0) alt_id3_length,"+
				 "        NVL(alt_id4_length,0) alt_id4_length,"+
				 "        nat_id_length,"+
				 "        patient_id_length,"+
				 "        alt_id1_exp_date_accept_yn,"+
				 "        alt_id2_exp_date_accept_yn,"+
				 "        alt_id3_exp_date_accept_yn,"+
				 "        alt_id4_exp_date_accept_yn,"+
				 "        accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_alphanumeric_yn,"+
				 "        accept_oth_alt_id_yn,"+
				 "        NVL(nat_id_prompt,'National ID No') nat_id_prompt,"+
				 "        name_dervn_logic,NAME_DERVN_LOGIC_LONG,NAME_DERVN_LOGIC_OTH_LANG_LONG,"+ //NAME_DERVN_LOGIC_LONG added on 19/06/2012
				 "        pat_name_as_multipart_yn,"+
				 "        citizen_nationality_code,"+
				 "        mp_get_desc.MP_COUNTRY(citizen_nationality_code,'"+locale+"',1) citizen_nationality_desc,"+
				 "        alt_id1_len_validation_yn,"+
				 "        alt_id2_len_validation_yn,"+
				 "        alt_id3_len_validation_yn,"+
				 "        alt_id4_len_validation_yn,"+
				 "        nat_id_chk_len,"+
				 "        alt_id1_exp_warn_yn,"+
				 "        ext_system_interface_yn,"+
				 "        nat_data_source_id, "+
				 "        dflt_patient_name, "+
				 "        nat_id_check_digit_id, "+
				  "       biometric_authentication_yn "+
				 
				 " FROM   mp_param_lang_vw"+
				 " WHERE  module_id = 'MP' and language_id='"+localeName+"'";
		
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if (rs!= null)
		{
			while(rs.next())
			{
				alt_id1_reqd_yn				= rs.getString("Alt_Id1_reqd_yn");
				alt_id2_reqd_yn				= rs.getString("Alt_Id2_reqd_yn");
				alt_id3_reqd_yn				= rs.getString("Alt_Id3_reqd_yn");
				alt_id4_reqd_yn				= rs.getString("Alt_Id4_reqd_yn");
				alt_id1_type					= rs.getString("Alt_Id1_type");
				alt_id2_type					= rs.getString("Alt_Id2_type");
				alt_id3_type					= rs.getString("Alt_Id3_type");
				alt_id4_type					= rs.getString("Alt_Id4_type");
				alt_id1_length					= rs.getString("Alt_Id1_length");
				alt_id2_length					= rs.getString("Alt_Id2_length");
				alt_id3_length					= rs.getString("Alt_Id3_length");
				alt_id4_length					= rs.getString("Alt_Id4_length");
				nat_id_length					= rs.getString("nat_id_length");
				pat_id_length					= rs.getString("Patient_Id_Length");
				
				alt_id1_len_validation_yn	= rs.getString("alt_id1_len_validation_yn");
				alt_id1_len_validation_yn	= rs.getString("alt_id1_len_validation_yn");
				alt_id2_len_validation_yn	= rs.getString("alt_id2_len_validation_yn");
				alt_id3_len_validation_yn	= rs.getString("alt_id3_len_validation_yn");
				alt_id4_len_validation_yn	= rs.getString("alt_id4_len_validation_yn");
				nat_id_chk_len					= rs.getString("nat_id_chk_len");

				alt_id1_exp_date_accept_yn	= rs.getString("alt_id1_exp_date_accept_yn");
				alt_id2_exp_date_accept_yn	= rs.getString("alt_id2_exp_date_accept_yn");
				alt_id3_exp_date_accept_yn	= rs.getString("alt_id3_exp_date_accept_yn");
				alt_id4_exp_date_accept_yn	= rs.getString("alt_id4_exp_date_accept_yn");
				accept_national_id_no_yn		= rs.getString("accept_national_id_no_yn");
				nat_id_accept_alphanumeric_yn		= rs.getString("nat_id_accept_alphanumeric_yn");
				alt_id1_accept_alphanumeric_yn 		= rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");
				nat_id_prompt 					= rs.getString("nat_id_prompt");
				alt_id1_desc 						= rs.getString("alt_id1_desc");
				alt_id2_desc 						= rs.getString("alt_id2_desc");
				alt_id3_desc 						= rs.getString("alt_id3_desc");
				alt_id4_desc 						= rs.getString("alt_id4_desc");
				Accept_oth_alt_id_yn 			= rs.getString("Accept_oth_alt_id_yn");

				defaultncode = rs.getString("citizen_nationality_code");
				defaultndesc = rs.getString("citizen_nationality_desc");

				name_dervn_logic         =  rs.getString("name_dervn_logic");
				if(name_dervn_logic == null)
				{
					name_dervn_logic = "";
				}
				
				name_dervn_logic_long = rs.getString("NAME_DERVN_LOGIC_LONG");
				
				if (name_dervn_logic_long == null)
				{
					name_dervn_logic_long="";
				}

				

				name_dervn_logic_oth_lang_long = rs.getString("name_dervn_logic_oth_lang_long");
				
				if (name_dervn_logic_oth_lang_long == null)
				{
					name_dervn_logic_oth_lang_long="";
				}

				

				pat_name_as_multipart_yn = rs.getString("pat_name_as_multipart_yn");
				if(pat_name_as_multipart_yn == null)
				{
					pat_name_as_multipart_yn = "";
				}
			    alt_id1_exp_warn_yn = rs.getString("alt_id1_exp_warn_yn");
				ext_system_interface_yn = rs.getString("ext_system_interface_yn")==null?"N":rs.getString("ext_system_interface_yn");
				nat_data_source_id = rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
				dflt_patient_name = rs.getString("dflt_patient_name")==null?"":rs.getString("dflt_patient_name");
				nat_id_check_digit_id = rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
				biometric_authentication_yn = rs.getString("biometric_authentication_yn")==null?"N":rs.getString("biometric_authentication_yn");//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
			}
          if(defaultncode==null)defaultncode="";
		  if(defaultndesc==null)defaultndesc="";
		}

		name_dervn_logic = name_dervn_logic.replace('+','!');
				if(alt_id1_reqd_yn == null) alt_id1_reqd_yn = "N";
				if(alt_id2_reqd_yn == null) alt_id2_reqd_yn = "N";
				if(alt_id3_reqd_yn == null) alt_id3_reqd_yn = "N";
				if(alt_id4_reqd_yn == null) alt_id4_reqd_yn = "N";
				if(alt_id1_type == null) alt_id1_type = "";
				if(alt_id2_type == null) alt_id2_type = "";
				if(alt_id3_type == null) alt_id3_type = "";
				if(alt_id4_type == null) alt_id4_type = "";
				if(alt_id1_length == null) alt_id1_length = "0";
				if(alt_id2_length == null) alt_id2_length = "0";
				if(alt_id3_length == null) alt_id3_length = "0";
				if(alt_id4_length == null) alt_id4_length = "0";
				if(nat_id_length == null) nat_id_length = "0";
				if(alt_id1_exp_date_accept_yn == null) alt_id1_exp_date_accept_yn = "N";
				if(alt_id2_exp_date_accept_yn == null) alt_id2_exp_date_accept_yn = "N";
				if(alt_id3_exp_date_accept_yn == null) alt_id3_exp_date_accept_yn = "N";
				if(alt_id4_exp_date_accept_yn == null) alt_id4_exp_date_accept_yn = "N";
				if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
				if(nat_id_accept_alphanumeric_yn == null) nat_id_accept_alphanumeric_yn = "N";
				if(nat_id_prompt == null) nat_id_prompt = "";
				if(alt_id1_desc == null) alt_id1_desc = "";
				if(alt_id2_desc == null) alt_id2_desc = "";
				if(alt_id3_desc == null) alt_id3_desc = "";
				if(alt_id4_desc == null) alt_id4_desc = "";
				if(Accept_oth_alt_id_yn == null) Accept_oth_alt_id_yn = "N";
	
	%>
    
   <script>
	function checklength(Obj)
	{
		
		var maxlength = 0;
		var desc = "";
		if(Obj.name == 'national_id_no')
		{
		  maxlength = '<%=nat_id_length%>'
		  desc = "<%=nat_id_prompt%>"
		}
		if(Obj.name == 'alt_id1_no')
		{
		  maxlength = '<%=alt_id1_length%>'
		  desc = "<%=alt_id1_desc%>"
		}
		if(Obj.name == 'alt_id2_no')
		{
		  maxlength = '<%=alt_id2_length%>'
		  desc = "<%=alt_id2_desc%>"
		}
		if(Obj.name == 'alt_id3_no')
		{
		  maxlength = '<%=alt_id3_length%>'
		  desc = "<%=alt_id3_desc%>"
		}
		if(Obj.name == 'alt_id4_no')
		{
		  maxlength = '<%=alt_id4_length%>'
		  desc = "<%=alt_id4_desc%>"
		}
		if(Obj.value != "")
		{
		if ( Obj.value.length == maxlength)
				return true;
 		else
		{
				var msg = getMessage("ALT_ID_CHARS",'MP')
				msg =msg.replace('$',desc)
				msg =msg.replace('@',maxlength)
				alert(msg)
				Obj.focus();
				return false;
		}
	  }
	}
	//below code change done for SRR20056-SCF-12671
	function altID1Validation(event){
		var alt_id1_accept_alphanumeric_yn = document.forms[0].alt_id1_accept_alphanumeric_yn.value;
		var strCheck = '';
		if (alt_id1_accept_alphanumeric_yn=='Y')
		{
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		}
		else
		{
			strCheck = '0123456789';
		}   
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return true ;
	}
	</script>
	<input type ='hidden' name='dflt_patient_name' id='dflt_patient_name' value='<%=dflt_patient_name%>'>
	<!--for smart card-->
	<input type="hidden" name="txtSmartcard_path" id="txtSmartcard_path" value="<%=Smartcard_path%>">
	<input type="hidden" name="txtSmartcard_dup" id="txtSmartcard_dup" value="">
	<!--for smart card-->
	<!--for Alkhaleej smart card-->
	<input type="hidden" name="txtSmart_fn_name" id="txtSmart_fn_name" value="<%=function_name%>">
     <jsp:include page="PatIdComponent.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name='patidsize' value="<%=pat_id_length%>" />
			<jsp:param name='AltId1Type' value="<%=alt_id1_type%>" />
			<jsp:param name='AltId2Type' value="<%=alt_id2_type%>" />
			<jsp:param name='AltId3Type' value="<%=alt_id3_type%>" />
			<jsp:param name='AltId4Type' value="<%=alt_id4_type%>" />
		    <jsp:param name='AcceptOtherAltId' value="<%=Accept_oth_alt_id_yn%>" />
			<jsp:param name='AltId1No' value="<%=alt_id1_no%>" />
			<jsp:param name='AltId2No' value="<%=alt_id2_no%>" />
			<jsp:param name='AltId3No' value="<%=alt_id3_no%>" />
			<jsp:param name='AltId4No' value="<%=alt_id4_no%>" />
			<jsp:param name='name_dervn_logic' value="<%=name_dervn_logic%>" /> 
			<jsp:param name='name_dervn_logic_long' value="<%=name_dervn_logic_long%>" /> 
			<jsp:param name='name_dervn_logic_oth_lang_long' value="<%=name_dervn_logic_oth_lang_long%>" /> 
			
		    <jsp:param name='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>" />
			<jsp:param name='bodyFrame' value="<%=bodyFrame%>" />
			<jsp:param name='submitFrame' value="<%=submitFrame%>" />
			<jsp:param name='alert_reqd_yn' value="<%=alert_reqd_yn%>" />
			<jsp:param name='defaultncode' value="<%=defaultncode%>" />
			<jsp:param name='defaultndesc' value="<%=defaultndesc%>" />
	  </jsp:include>        
  	<table border='0' cellpadding="2" cellspacing="0" width="100%" align='left' tabindex=-1>
	<tr>
	<td align='left' class='label' width='20%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td nowrap class='FIELDS' >
	 <%if(op_call.equals("ae_reg_pat")){%>
	<input type= 'text' name='patient_id' id='patient_id' size='<%=pat_id_length%>'  maxlength='<%=pat_id_length%>'  onchange='ChangeUpperCase(this);' onblur='ChangeUpperCase(this);checkPatient(this)' onKeyPress='return CheckForSpecChars(event)' value="<%=patient_id%>" tabIndex='1'>  	
	<%}else{%>
	<input type= 'text' name='patient_id' id='patient_id' size='<%=pat_id_length%>'  maxlength='<%=pat_id_length%>'  onchange='ChangeUpperCase(this);checkforOA()' onblur='if (this.value != "") ChangeUpperCase(this); checkPatient(this)' onKeyPress='return CheckForSpecChars(event)' value="<%=patient_id%>" tabIndex='1'>
	<%}%>
		<%if(!ca_patient_id.equals("")) { %>
		<input type='button' name='search' id='search' value='?' disabled class="BUTTON" onClick='patSearch()' tabIndex="-1" >
		<%}else if(call_function.equals("OT")) { %>
		<input type='button' name='search' id='search' value='?' disabled class="BUTTON" onClick='patSearch()' tabIndex="-1" >
		<%}else{%>
	<input type='button' name='search' id='search' value='?'  class="BUTTON" onClick='patSearch()' tabIndex="-1" >
	<%}%>
	<img id='patgif' src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='patgif'></img>	
	</td>
	<td  colspan='2' class='querydata' id='patient_name1'>
	</td>	 		
	<input type='hidden' name='patient_name' id='patient_name' value=''>
 	<input type='hidden' name='name_dervn_logic_long' id='name_dervn_logic_long' value='<%=name_dervn_logic_long%>'>
 	<input type='hidden' name='name_dervn_logic_oth_lang_long' id='name_dervn_logic_oth_lang_long' value='<%=name_dervn_logic_oth_lang_long%>'>
 	
	<input type='hidden' name='patient_name_long' id='patient_name_long' value=''>
	<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value=''>
	
</tr>  
<tr>
	  <!--Code for dynamically generating NRIC No Starts here -->
	<%
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
	%>
		<td  class= 'label' align = 'left' nowrap ><%=nat_id_prompt %></td>
		<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='<%=nat_id_prompt%>'>
		<td  class='FIELDS' nowrap width=30%>
		<%if(nat_id_chk_len.equals("Y")){%>
		<input type='text' name='national_id_no' id='national_id_no' maxlength='<%= nat_id_length %>' onKeyPress='return <%=nat_id_onKeyPress%>'  size='<%=nat_id_length%>' onBlur='validateID(this,"<%=nat_id_check_digit_id%>");checklength(this)' value="<%=national_id_no%>" <%=disabledFields%> tabIndex='2'><%}else{%>
		<input type='text' name='national_id_no' id='national_id_no' maxlength='<%= nat_id_length %>' onKeyPress='return <%=nat_id_onKeyPress%>' size='<%=nat_id_length%>' onBlur='validateID(this,"<%=nat_id_check_digit_id%>");' value="<%=national_id_no%>" tabIndex='2' <%=disabledFields%>><%}%>	
		<%//added by gomathi.
		if(ext_system_interface_yn.equals("Y") && nat_data_source_id.equals("NRIC") && nat_id_check_digit_id.equals(""))
		{
			if(function_name.equals("07")) { // added by Lakshmanan MOHE-CRF-0164.1
				%><input type='hidden'  name='myKadBtn' id='myKadBtn' value=''><%
			} else {
			%><input type='button' value='M' class= 'button' name='myKadBtn' id='myKadBtn' onClick="ReadDF1_onclick('<%=bodyFrame%>','IC','<%=submitFrame%>','<%=op_call%>');" tabindex=-1 <%=disabledFields%> > 
			<% }
		}
		%>
		<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='nat_gif'></img> 
	<%
		}
		else
		{
	%>
			<!-- <td colspan=2 class= 'label' align = 'left'></td> -->
			<td colspan=2 class= 'label'><input type='hidden' name='national_id_no' id='national_id_no' maxlength='' onKeyPress='' size='20' onChange="" value="" ><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='nat_gif'></img></td>
	<%
		}
	%>
		<input type='hidden' name='alt_id1_desc' id='alt_id1_desc' value='<%=alt_id1_desc%>'>
		<input type='hidden' name='alt_id2_desc' id='alt_id2_desc' value='<%=alt_id2_desc%>'>
		<input type='hidden' name='alt_id3_desc' id='alt_id3_desc' value='<%=alt_id3_desc%>'>
		<input type='hidden' name='alt_id4_desc' id='alt_id4_desc' value='<%=alt_id4_desc%>'>
		<input type='hidden' name='readonly_yn' id='readonly_yn' value='<%=readonly_yn%>'>
		<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	-->
		<input type='hidden' name='biometric_authentication_yn' id='biometric_authentication_yn' value='<%=biometric_authentication_yn%>'>		
		<input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='<%=nat_id_accept_alphanumeric_yn%>'>
		<input type='hidden' name='alt_id1_accept_alphanumeric_yn' id='alt_id1_accept_alphanumeric_yn' value='<%=alt_id1_accept_alphanumeric_yn%>'>
		<td  colspan='2' class='querydata' id='patient_name_local_lang1' ></td>
		<input type='hidden' name='patient_name_local_lang' id='patient_name_local_lang' value=''>
</tr>
	<%
		if(!alt_id1_type.equals(""))
		{
	%>
		<tr>
	    <td class= 'label' align = 'left'  nowrap ><%=alt_id1_desc %></td>
		<td nowrap  class='FIELDS' >
	<%
		if(alt_id1_len_validation_yn.equals("Y"))
		{
        
		out.println("<input type='text' name='alt_id1_no' id='alt_id1_no' onBlur='enabledFields(this);validateID(this);checklength(this)' maxlength='"+alt_id1_length+"' size='"+alt_id1_length+"' value='"+alt_id1_no+"' onKeyPress='return altID1Validation(event)'  "+disabledFields+" tabIndex='4'>");
		}
		else
		{
		 out.println("<input type='text' name='alt_id1_no' id='alt_id1_no' onBlur='enabledFields(this);validateID(this);' maxlength='"+alt_id1_length+"' size='"+alt_id1_length+"' value='"+alt_id1_no+"' onKeyPress='return altID1Validation(event)' "+disabledFields+" tabIndex='4'>");
		}
		if(alt_id1_reqd_yn.equals("N"))
		{
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_gif' id='alt1_gif' ></img>") ;
		}
		else
		{
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_gif' id='alt1_gif'></img>") ;
		}
		out.println("<input type='hidden' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='"+alt_id1_reqd_yn+"'> ");
		// Code for dynamically generated Alternate ID1 Ends here

		// Code for dynamically generating Alternate Id1 Exp Date Starts here
	  if(alt_id1_exp_date_accept_yn.equals("Y"))  
	  {
		out.println("<td class=label width='25%' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
		
		if(alt_id1_exp_warn_yn.equals("Y"))
		out.println("<td   class='FIELDS' ><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName);checkExpiry1(this);' value = \""+alt_id1_exp_date+"\" "+disabledFields+" tabIndex='5' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt1' name='alt_id_exp_dt1' onClick=\"document.forms[0].alt_id1_exp_date.select();return showCalendar('alt_id1_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img> <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_exp_date1' id='alt1_exp_date1'></img></td>");
		else
		 out.println("<td  class='FIELDS'><input type='text' name='alt_id1_exp_date' id='alt_id1_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName);' value = \""+alt_id1_exp_date+"\" "+disabledFields+" tabIndex='5' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt1' name='alt_id_exp_dt1' onClick=\"document.forms[0].alt_id1_exp_date.select();return showCalendar('alt_id1_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img> <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='alt1_exp_date1' id='alt1_exp_date1'></img></td>");
	  }
	  else
			{
			  out.println("<td ></td><td ></td>");	
			}
	 out.println("</td><input type='hidden' name='alt_id1_type' id='alt_id1_type' value=\""+alt_id1_type+"\">");
	 out.println("<input type='hidden' name='alt_date1_reqd_yn' id='alt_date1_reqd_yn' value='N'> ");
		
		/*alt1_exp_date1,alt_id1_reqd_yn and alt1_gif added by dharma on 17 th jan 2014 for [IN:046495] */
	
	}
	
	
	// Code for dynamically generating Alternate Id1 Exp Date Ends here
	%>
</tr>
<tr>
	<!-- Code for dynamically generating Alternate ID2 Starts here cut-->
    <!-- Code for generated Other Alternate ID Ends here -->
<%
		
		if(!alt_id2_type.equals(""))
		{
	%>
		<td class= 'label' align = 'left' nowrap ><%=alt_id2_desc%> </td>
		<td  nowrap  class='FIELDS'>
	<%
		//below code change done for SRR20056-SCF-12671
      	if(alt_id2_len_validation_yn.equals("Y"))
		{
			out.println("<input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='enabledFields(this);checklength(this);validateID(this);' maxlength='"+alt_id2_length+"' size='"+alt_id2_length+"' value='"+alt_id2_no+"' onKeyPress='return altID234Validations(event)' tabIndex='6' "+disabledFields+">");
		}
		else
		{
			out.println("<input type='text' name='alt_id2_no' id='alt_id2_no' onBlur='enabledFields(this);validateID(this);' maxlength='"+alt_id2_length+"' size='"+alt_id2_length+"' value='"+alt_id2_no+"' onKeyPress='return altID234Validations(event)' tabIndex='6'  "+disabledFields+">");
		}
		out.println("<input type='hidden' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='"+alt_id2_reqd_yn+"'> ");
	 if(alt_id2_reqd_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' name='alt2_gif'></img>") ;
	 else
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' name='alt2_gif'></img>") ;
	
	 // Code for dynamically generated Alternate ID2 Ends here

	 // Code for dynamically generating Alternate Id2 Exp Date Starts here
	 if(alt_id2_exp_date_accept_yn.equals("Y"))  
	 {
		out.println("<td  class='label' width='25%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
		out.println("<td  class='FIELDS'><input type='text' name='alt_id2_exp_date' id='alt_id2_exp_date' maxlength='10' size='8' onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName)' value = \""+alt_id2_exp_date+"\" "+disabledFields+" tabIndex='7' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt2' name='alt_id_exp_dt2' onClick=\"document.forms[0].alt_id2_exp_date.select();return showCalendar('alt_id2_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img></td>");
	 }
	  else
			{
		      out.println("<td ></td><td ></td>");
			}
			

		out.println("</td><input type='hidden' name='alt_id2_type' id='alt_id2_type' value=\""+alt_id2_type+"\">");	
	}
	out.println("</tr><tr>");
// Code for dynamically generating Alternate Id2 Exp Date Ends here
// Code for dynamically generated Alternate ID3 Starts here

	if(!alt_id3_type.equals(""))
		{
			
%>
		<td class= 'label' align = 'left' nowrap ><%= alt_id3_desc %></td>
		<td nowrap  class='FIELDS'>
<%
		//below code change done for SRR20056-SCF-12671
		if(alt_id3_len_validation_yn.equals("Y"))
		{
		out.println("<input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='"+alt_id3_length+"' onBlur='enabledFields(this);validateID(this);checklength(this);' size='"+alt_id3_length+"' value='"+alt_id3_no+"' onKeyPress='return altID234Validations(event)' tabIndex='8' "+disabledFields+">");
		}
		else
			{
			 out.println("<input type='text' name='alt_id3_no' id='alt_id3_no' maxlength='"+alt_id3_length+"' onBlur='enabledFields(this);validateID(this);' size='"+alt_id3_length+"' value='"+alt_id3_no+"' onKeyPress='return altID234Validations(event)' tabIndex='8' "+disabledFields+">");
			}
		out.println("<input type='hidden' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='"+alt_id3_reqd_yn+"'> ");
	  if(alt_id3_reqd_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/mandatory.gif' name='alt3_gif' style='visibility:hidden'></img>") ;
	  else
		out.println("<img src='../../eCommon/images/mandatory.gif' name='alt3_gif' style='visibility:hidden'></img>") ;
	  
// Code for dynamically generated Alternate ID3 Starts here

// Code for dynamically generating Alternate Id3 Exp Date Starts here
	  if(alt_id3_exp_date_accept_yn.equals("Y"))  
	  {
		out.println("<td  class='label' width='25%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"</td>") ;
		out.println("<td  class='FIELDS'><input type='text' name='alt_id3_exp_date' id='alt_id3_exp_date' maxlength='10' size='8'  onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName)'  value = \""+alt_id3_exp_date+"\" tabIndex='9' "+disabledFields+" disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt3' name='alt_id_exp_dt3' onClick=\"document.forms[0].alt_id3_exp_date.select();return showCalendar('alt_id3_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img></td> ");
	  }
	  else
			{
			  out.println("<td ></td><td ></td>");	
			}
	  
		out.println("</td><input type='hidden' name='alt_id3_type' id='alt_id3_type' value=\""+alt_id3_type+"\">");		
	}
	
	
	// Code for dynamically generating Alternate Id3 Exp Date Ends here
%>

<tr></tr>
<%
		if(!alt_id4_type.equals(""))
		{
			
%>
		<td class= 'label' align = 'left' nowrap ><%= alt_id4_desc%></td>
		<td  nowrap  class='FIELDS'>
<%
		//below code change done for SRR20056-SCF-12671
		if(alt_id4_len_validation_yn.equals("Y"))
		{
		out.println("<input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='enabledFields(this);validateID(this);checklength(this)' maxlength='"+alt_id4_length+"' size='"+alt_id4_length+"' value='"+alt_id4_no+"' onKeyPress='return altID234Validations(event)' "+disabledFields+" tabIndex='10' >");
		}
		else
		{
		 out.println("<input type='text' name='alt_id4_no' id='alt_id4_no' onBlur='enabledFields(this);validateID(this);' maxlength='"+alt_id4_length+"' size='"+alt_id4_length+"' value='"+alt_id4_no+"' onKeyPress='return altID234Validations(event)' "+disabledFields+" tabIndex='10' >");
		}
		out.println("<input type='hidden' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value=\""+alt_id4_reqd_yn+"\"> ");
	  if(alt_id4_reqd_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' name='alt4_gif'></img>") ;
	  else
		out.println("<img src='../../eCommon/images/mandatory.gif' name='alt4_gif' style='visibility:hidden'></img>") ;
      
	  out.println("</td>");

		
	  %>
	   
	 <% if(alt_id4_exp_date_accept_yn.equals("Y")) 
	  {
		out.println("<td  class='label' width='25%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+"") ;
		out.println("<td  class='FIELDS'><input type='text' name='alt_id4_exp_date' id='alt_id4_exp_date' maxlength='10' size='8' onblur='makeValidString(this);validDateObj(this,\""+"DMY"+"\",localeName)' value = \""+alt_id4_exp_date+"\" "+disabledFields+" tabIndex='11' disabled><img src='../../eCommon/images/CommonCalendar.gif' id='alt_id_exp_dt4' name='alt_id_exp_dt4' onClick=\"document.forms[0].alt_id4_exp_date.select();return showCalendar('alt_id4_exp_date');\" tabindex=-1 style=\"pointer-events: none;\"></img>");
	  }
	  else
			{
			  out.println("<td ></td><td ></td>");	
			}
		out.println("</td><input type='hidden' name='alt_id4_type' id='alt_id4_type' value=\""+alt_id4_type+"\">");
		}
	
// Code for dynamically generating Alternate Id1 Exp Date Ends here
%> 
	 <!-- Code for generated Other Alternate ID Starts here -->

 
</tr>
 <tr>
 <%
		if(Accept_oth_alt_id_yn.equals("Y"))
		{
		  
%>
	<td class='label' nowrap align='left' valign='center'><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td><td><select onchange='enabledFields(this);' name='other_alt_type' id='other_alt_type' tabIndex='12'>
	<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------
<%
		sql = "SELECT alt_id_type,long_desc FROM MP_ALTERNATE_ID_TYPE_LANG_VW WHERE language_id='"+localeName+"' and alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM  where module_id='MP' UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and EFF_STATUS='E'";
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	    pstmt = con.prepareStatement(sql);
	    rs = pstmt.executeQuery();	
	    if(rs != null)
		{
			while (rs.next())
			{          
			out.println ( "<Option value=\""+rs.getString("alt_id_type")+"\" >"+rs.getString("long_desc")+"</Option>" ) ;
			}
	  }
		
		}
%>
	</select></td><td class=label><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/></td><td  class='FIELDS'><input type ='text' name = 'other_alt_Id' id = 'other_alt_Id' value="" onKeyPress='return SpecialCharRestriction(event)' size='15' maxlength='20' onBlur='validateID(this);' tabIndex='13' disabled></td></tr>
 <tr><td colspan='8' class='white'></td></tr>
 </table>	
<!-- @ Code Added for Title Family Name and Suffix on 4th Feb 2004-->

 <jsp:include page="PatDemographicDtlsComponent.jsp" ><jsp:param name="flush" value="true" />
		    <jsp:param name='alert_reqd_yn' value="<%=alert_reqd_yn%>"/>
			<jsp:param name='name_dervn_logic' value="<%=name_dervn_logic%>"/> 
			<jsp:param name='name_dervn_logic_long' value="<%=name_dervn_logic_long%>"/> 
			<jsp:param name='name_dervn_logic_oth_lang_long' value="<%=name_dervn_logic_oth_lang_long%>"/> 
			
		    <jsp:param name='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>"/>
    		<jsp:param name='citizen_yn' value="<%=citizen_yn%>"/>
			<jsp:param name='bodyFrame' value="<%=bodyFrame%>"/>
			<jsp:param name='submitFrame' value="<%=submitFrame%>"/>   
			<jsp:param name='op_call' value="<%=op_call%>"/>   
   </jsp:include>

<input type='hidden' name='alt_id1_man_non_ctz' id='alt_id1_man_non_ctz' value="<%=isAltId1ManNonCtz%>"><!-- Added By Dharma on jan 17th 2014 for [IN:046495] -->
<%
	}
	catch(Exception e) 
	{ 
		out.println(e.toString());
	}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	    if(con!=null) ConnectionManager.returnConnection(con,request);
	}	
%> 

