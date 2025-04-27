<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,ecis.utils.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	 <script>			
			function CheckPositiveNumber1(obj) {
				if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
				}
				else {
					if ( obj.value.length > 0 ) {
						alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
						obj.select();
						obj.focus();
					}
					else if ( obj.value.length == 0 )
						obj.value = 1;
				}
			}
	 </script>
<%

	request.setCharacterEncoding("UTF-8");
	String step = request.getParameter("step");
	if (step==null) step	="";
	String classValue		="";
	String appt_no           ="";
	Properties p			=	 (java.util.Properties) session.getValue( "jdbc" );
	String login_user		=	 p.getProperty( "login_user" ) ;
	String ws_no1			=	 p.getProperty("client_ip_address");
	String locale			=	 (String)session.getAttribute("LOCALE");
	String sys_date			= "";
	String enc_id			="";
	String perm_fs_locn_code="";

	//Added by Ashwini for NMC-JD-SCF-0151
	String queryKey = "";
	String langg_id = "";
	String facc_id = "";
	String clinic_code = "";
	String visit_type = "";
	String sql_query = "";
	
	//Added by Ashwini for MOHE-SCF-0102 & MOHE-SCF-0026
	String sqlstring_querykey = "";
	String sql_querykey = "";

	perm_fs_locn_code=request.getParameter("perm_fs_locn_code");
		if (perm_fs_locn_code==null) perm_fs_locn_code="";
    
	String p_enter_fcy = request.getParameter("p_enter_fcy") == null?"":request.getParameter("p_enter_fcy");
	String p_called_from = request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");

	String national_id_no = request.getParameter("national_id_no") == null?"":request.getParameter("national_id_no");
	String Photo_upload_yn = request.getParameter("Photo_upload_yn") == null?"":request.getParameter("Photo_upload_yn");
	
	if (step.equals("1")){	
/*Below line appt_no variable added by venkatesh.s on 25-MARCH-2013 against RUT-CRF-0006.1 [IN036541]*/	
        appt_no=request.getParameter("appt_no");
		 if(appt_no==null)appt_no="";
	    String sql = request.getParameter("sqlString");
		
		String rep_id = request.getParameter("rep_id")==null?"":request.getParameter("rep_id");		
		if (sql==null) sql="";
		String encounterid = request.getParameter("EncounterId");
		if (encounterid==null) encounterid="";
		String encounter_id = request.getParameter("EncounterId");
		if (encounter_id==null) encounter_id="";
		String enc_facilityId = request.getParameter("p_facility_id");
		if (enc_facilityId==null) enc_facilityId="";
		String patient_id = request.getParameter("Patient_ID");
		String p_encounter_id = request.getParameter("p_encounter_id");
		String capture_photo_yn = request.getParameter("capture_photo_yn");
		if (capture_photo_yn==null) capture_photo_yn = "N";
		if (patient_id==null) patient_id = "";
		if(p_encounter_id==null)p_encounter_id="";

		if(encounterid.equals(""))	
			encounterid = "Patient_ID="+patient_id;
		else
			encounterid = "EncounterId="+encounterid;  
	
		//if (encounterid.equals(""))	encounterid = "Patient_ID="+patient_id;
	/*FYI: The Below line was commented For Module Calling From MR on 9/25/2009*/
	/*else
		encounterid = "EncounterId="+encounterid;*/
		//else
		//encounterid=request.getParameter("EncounterId");
		/*String Newencounterid = request.getParameter("EncounterId");
		enc_id = Newencounterid;*/

		String dest_locn_type = request.getParameter("dest_locn_type");
		if (dest_locn_type==null) dest_locn_type="";
		String dest_locn_code = request.getParameter("dest_locn_code");
		if (dest_locn_code==null) dest_locn_code="";

		String reportParamNames = request.getParameter("reportParamNames");
		if (reportParamNames==null) reportParamNames = "";
		String reportParamValues = request.getParameter("reportParamValues");
		if (reportParamValues==null) reportParamValues = "";
		String function_id  = request.getParameter("P_function_id");
		if (function_id==null) function_id="";
		//Added by Ajay Hatwate for MOHE-SCF-0242
		if(function_id.equals("AE_REGISTER_ATTN"))
		{
			sql = (String)session.getAttribute("AE_REG_ATTN_SQL");
		}
		//Added by Ashwini for MOHE-SCF-0102 & MOHE-SCF-0026
		if(function_id.equals("IPINTERNALREPORTREPRINT"))
		{
			sqlstring_querykey = (String)session.getAttribute("SQLSTRING_QUERYKEY");
		}
		else if(function_id.equals("ADMISSION"))
		{
			sql_querykey = request.getParameter("sql_querykey");

			if(sql_querykey.equals("SQLSTRING_QUERYKEYIPMP")){
				sqlstring_querykey = (String)session.getAttribute("SQLSTRING_QUERYKEYIPMP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEYMPIP")){
				sqlstring_querykey = (String)session.getAttribute("SQLSTRING_QUERYKEYMPIP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEYMP")){
				sqlstring_querykey = (String)session.getAttribute("SQLSTRING_QUERYKEYMP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEYIP")){
				sqlstring_querykey = (String)session.getAttribute("SQLSTRING_QUERYKEYIP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEY")){
				sqlstring_querykey = (String)session.getAttribute("SQLSTRING_QUERYKEY");
			}
		}
		else if(function_id.equals("VISIT_REGISTRATION"))
		{
			sql_querykey = request.getParameter("sql_querykey");

			if(sql_querykey.equals("VISIT_SQLSTRINGOP")){
				sqlstring_querykey = (String)session.getAttribute("VISIT_SQLSTRINGOP");
			}else if(sql_querykey.equals("VISIT_SQLSTRINGMP")){
				sqlstring_querykey = (String)session.getAttribute("VISIT_SQLSTRINGMP");
			}else if(sql_querykey.equals("VISIT_SQLSTRING")){
				sqlstring_querykey = (String)session.getAttribute("VISIT_SQLSTRING");
			}
		}
		//Added for Bru-HIMS-CRF-195
		String module_id = request.getParameter("P_MODULE_ID");
		if (module_id==null) module_id="";
		
		//Added by Ashwini for NMC-JD-SCF-0151
		if(function_id.equals("OPINTERNALREP")){
			queryKey = request.getParameter("queryKey");
			if (queryKey==null) queryKey="";
			langg_id = request.getParameter("locale");
			if (langg_id==null) langg_id="";
			facc_id = request.getParameter("facilityId");
			if (facc_id==null) facc_id="";
			clinic_code = request.getParameter("Clinic_Code");
			if (clinic_code==null) clinic_code="";
			visit_type = request.getParameter("Visit_Type");
			if (visit_type==null) visit_type="";
		}
	

%>
<!-- Below line "appt_no" variable added by venkatesh.s on 25-MARCH-2013 against RUT-CRF-0006.1 [IN036541] -->
<html><head><title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title></head>
<!-- Added for MOHE-SCF-0242 by Ajay H on 14/07/2023 -->
<%
if(function_id.equals("AE_REGISTER_ATTN")){
	//out.println("<iframe name='pline' id='pline' src=\"../../eCommon/jsp/pline.jsp?\"+encounterid+\"&P_MODULE_ID=\"+module_id+\"&P_FUNCTION_ID=\"+function_id scrolling='no' noresize style='height:14vh;width:100vw'></iframe><iframe name='main' id='main'    src=\"../../eCommon/jsp/InternalReportsPrint.jsp?step=2&Patient_ID=\"+patient_id+\"&P_function_id=\"+function_id+\"&p_facility_id=\"+enc_facilityId+\"&capture_photo_yn=\"+capture_photo_yn+\"&reportParamNames=\"+reportParamNames+\"&reportParamValues=\"+reportParamValues+\"&EncounterId=\"+encounterid+\"&dest_locn_type=\"+dest_locn_type+\"&dest_locn_code=\"+dest_locn_code+\"&first_time_only=Y&rep_id=\"+rep_id+\"&p_encounter_id=\"+p_encounter_id+\"&perm_fs_locn_code=\"+perm_fs_locn_code+\"&p_enter_fcy=\"+p_enter_fcy+\"&p_called_from=\"+p_called_from+\"&encounter_id=\"+encounter_id+\"&appt_no=\"+appt_no+\"&national_id_no=\"+national_id_no+\"&Photo_upload_yn=\"+Photo_upload_yn+\"&langg_id=\"+langg_id+\"&facc_id=\"+facc_id+\"&clinic_code=\"+clinic_code+\"&visit_type=\"+visit_type scrolling='no' noresize style='height:100vh;width:100vw'></iframe></html>");
out.println("<iframe name='pline' id='pline' src='../../eCommon/jsp/pline.jsp?" + encounterid + "&P_MODULE_ID=" + module_id + "&P_FUNCTION_ID=" + function_id + "' scrolling='no' frameborder='0' noresize style='height:15vh;width:95vw'></iframe>");
out.println("<iframe name='main' id='main' src='../../eCommon/jsp/InternalReportsPrint.jsp?step=2&Patient_ID=" + patient_id + "&P_function_id=" + function_id + "&p_facility_id=" + enc_facilityId + "&capture_photo_yn=" + capture_photo_yn + "&reportParamNames=" + reportParamNames + "&reportParamValues=" + reportParamValues + "&EncounterId=" + encounterid + "&dest_locn_type=" + dest_locn_type + "&dest_locn_code=" + dest_locn_code + "&first_time_only=Y&rep_id=" + rep_id + "&p_encounter_id=" + p_encounter_id + "&perm_fs_locn_code=" + perm_fs_locn_code + "&p_enter_fcy=" + p_enter_fcy + "&p_called_from=" + p_called_from + "&encounter_id=" + encounter_id + "&appt_no=" + appt_no + "&national_id_no=" + national_id_no + "&Photo_upload_yn=" + Photo_upload_yn + "&langg_id=" + langg_id + "&facc_id=" + facc_id + "&clinic_code=" + clinic_code + "&visit_type=" + visit_type + "' scrolling='no' frameborder='0' noresize style='height:75vh;width:95vw'></iframe>");
out.println("</html>");
}
else{
//out.println("<iframe name='pline' id='pline' src=\"../../eCommon/jsp/pline.jsp?\"+encounterid+\"&P_MODULE_ID=\"+module_id+\"&P_FUNCTION_ID=\"+function_id scrolling='no' noresize style='height:15vh;width:100vw'></iframe><iframe name='main' id='main'    src=\"../../eCommon/jsp/InternalReportsPrint.jsp?step=2&Patient_ID=\"+patient_id+\"&P_function_id=\"+function_id+\"&p_facility_id=\"+enc_facilityId+\"&capture_photo_yn=\"+capture_photo_yn+\"&reportParamNames=\"+reportParamNames+\"&reportParamValues=\"+reportParamValues+\"&EncounterId=\"+encounterid+\"&sqlString=\"+java.net.URLEncoder.encode(sql)+\"&dest_locn_type=\"+dest_locn_type+\"&dest_locn_code=\"+dest_locn_code+\"&first_time_only=Y&rep_id=\"+rep_id+\"&p_encounter_id=\"+p_encounter_id+\"&perm_fs_locn_code=\"+perm_fs_locn_code+\"&p_enter_fcy=\"+p_enter_fcy+\"&p_called_from=\"+p_called_from+\"&encounter_id="+encounter_id+"&appt_no="+appt_no+"&national_id_no="+national_id_no+"&Photo_upload_yn="+Photo_upload_yn+"&queryKey=\"+queryKey+\"&langg_id=\"+langg_id+\"&facc_id=\"+facc_id+\"&clinic_code=\"+clinic_code+\"&visit_type=\"+visit_type+\"&sql_querykey=\"+sql_querykey scrolling='no' noresize style='height:85vh;width:100vw'></iframe></html>");
out.println("<iframe name='pline' id='pline' src='../../eCommon/jsp/pline.jsp?" + encounterid + "&P_MODULE_ID=" + module_id + "&P_FUNCTION_ID=" + function_id + "' scrolling='no' frameborder='0' noresize style='height:15vh;width:95vw'></iframe>");
out.println("<iframe name='main' id='main' src='../../eCommon/jsp/InternalReportsPrint.jsp?step=2&Patient_ID=" + patient_id + "&P_function_id=" + function_id + "&p_facility_id=" + enc_facilityId + "&capture_photo_yn=" + capture_photo_yn + "&reportParamNames=" + reportParamNames + "&reportParamValues=" + reportParamValues + "&EncounterId=" + encounterid + "&sqlString=" + java.net.URLEncoder.encode(sql) + "&dest_locn_type=" + dest_locn_type + "&dest_locn_code=" + dest_locn_code + "&first_time_only=Y&rep_id=" + rep_id + "&p_encounter_id=" + p_encounter_id + "&perm_fs_locn_code=" + perm_fs_locn_code + "&p_enter_fcy=" + p_enter_fcy + "&p_called_from=" + p_called_from + "&encounter_id=" + encounter_id + "&appt_no=" + appt_no + "&national_id_no=" + national_id_no + "&Photo_upload_yn=" + Photo_upload_yn + "&queryKey=" + queryKey + "&langg_id=" + langg_id + "&facc_id=" + facc_id + "&clinic_code=" + clinic_code + "&visit_type=" + visit_type + "&sql_querykey=" + sql_querykey + "' scrolling='no' frameborder='0'  noresize style='height:75vh;width:95vw'></iframe>");
out.println("</html>");

}

}else{
	String first_time_only = request.getParameter("first_time_only");
	if (first_time_only==null) first_time_only = "N";
	if (first_time_only.equals("Y")){ 
      /*Below line appt_no variable added by venkatesh.s on 25-MARCH-2013 against RUT-CRF-0006.1 [IN036541]*/
        appt_no=request.getParameter("appt_no");
		 if(appt_no==null)appt_no="";
		
		//Reports building.
		Connection con = ConnectionManager.getConnection(request);
		Statement stmt=null,langStmt=null;
		ResultSet rset=null,langrSet=null;
		PreparedStatement prepstmt = null;
		String patient_id = request.getParameter("Patient_ID");
		String capture_photo_yn = request.getParameter("capture_photo_yn");
		String rep_id = request.getParameter("rep_id")==null?"":request.getParameter("rep_id");		
		if (capture_photo_yn==null) capture_photo_yn = "";
		if (patient_id==null) patient_id = "";

		String sql = request.getParameter("sqlString");
		if (sql==null) sql="";
		String fac_id = (String) session.getValue("facility_id");
		String encounterid = request.getParameter("EncounterId");
		String Newencounterid = request.getParameter("EncounterId");
		String p_encounter_id = request.getParameter("p_encounter_id");
		enc_id = Newencounterid;
		if (encounterid==null) encounterid="";
		String p_module_id = request.getParameter("p_module_id");
		if (p_module_id==null) p_module_id= "";
		String enc_facilityId = request.getParameter("p_facility_id");
		if (enc_facilityId==null) enc_facilityId="";
		String p_function_id  = request.getParameter("P_function_id");
		if (p_function_id==null) p_function_id="";
		String reportParamNames = request.getParameter("reportParamNames");
		if (reportParamNames==null) reportParamNames = "";

		String reportParamValues = request.getParameter("reportParamValues");
		if (reportParamValues==null) reportParamValues = "";

String encounter_id = request.getParameter("encounter_id");

		//Added by Ashwini for MOHE-SCF-0102 & MOHE-SCF-0026
		if(p_function_id.equals("IPINTERNALREPORTREPRINT"))
		{
			sql = (String)session.getAttribute("SQLSTRING_QUERYKEY");
		}
		else if(p_function_id.equals("ADMISSION"))
		{	
			sql_querykey = request.getParameter("sql_querykey");	

			if(sql_querykey.equals("SQLSTRING_QUERYKEYIPMP")){
				sql = (String)session.getAttribute("SQLSTRING_QUERYKEYIPMP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEYMPIP")){
				sql = (String)session.getAttribute("SQLSTRING_QUERYKEYMPIP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEYMP")){
				sql = (String)session.getAttribute("SQLSTRING_QUERYKEYMP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEYIP")){
				sql = (String)session.getAttribute("SQLSTRING_QUERYKEYIP");
			}else if(sql_querykey.equals("SQLSTRING_QUERYKEY")){
				sql = (String)session.getAttribute("SQLSTRING_QUERYKEY");
			}
		}
		else if(p_function_id.equals("VISIT_REGISTRATION"))
		{
			sql_querykey = request.getParameter("sql_querykey");

			if(sql_querykey.equals("VISIT_SQLSTRINGOP")){
				sql = (String)session.getAttribute("VISIT_SQLSTRINGOP");
			}else if(sql_querykey.equals("VISIT_SQLSTRINGMP")){
				sql = (String)session.getAttribute("VISIT_SQLSTRINGMP");
			}else if(sql_querykey.equals("VISIT_SQLSTRING")){
				sql = (String)session.getAttribute("VISIT_SQLSTRING");
			}
		}else if(p_function_id.equals("AE_REGISTER_ATTN")){
			sql = (String)session.getAttribute("AE_REG_ATTN_SQL");//Added by Ajay Hatwate for MOHE-SCF-0242
		}
		
		//Added by Ashwini for NMC-JD-SCF-0151
		if(p_function_id.equals("OPINTERNALREP")){
			queryKey = request.getParameter("queryKey");
			if (queryKey==null) queryKey="";
			langg_id = request.getParameter("langg_id");
			if (langg_id==null) langg_id="";
			facc_id = request.getParameter("facc_id");
			if (facc_id==null) facc_id="";
			clinic_code = request.getParameter("clinic_code");
			if (clinic_code==null) clinic_code="";
			visit_type = request.getParameter("visit_type");
			if (visit_type==null) visit_type="";
			
			MessageManager mm = new MessageManager();
			java.util.Hashtable mesg = mm.getMessage(locale, queryKey, "opsql");
			sql_query = (String) mesg.get("message");
		}

		String dest_locn_type = request.getParameter("dest_locn_type");
		if (dest_locn_type==null) dest_locn_type="";
		String dest_locn_code = request.getParameter("dest_locn_code");
		if (dest_locn_code==null) dest_locn_code="";
		String ws_no        = request.getRemoteAddr() ;
		String report_option    = "P" ;
		String message ="";
		String P_copies="";
		String P_queue_name = "";
		String rep_server_key = "";//IN037658
		CallableStatement cs  = null;
		CallableStatement cs1 = null;
		String facilityId = (String)session.getValue("facility_id");
		String disableChkbox = "";
		ArrayList arrayList=new ArrayList();
		String langCode="";
		String langDesc="";
		String p_out_status="";
		String p_out_error="";
		String langChkSql = "";
		String patLangCode = "";
		try{
			stmt =  con.createStatement();
			/*if(rset != null)		rset.close();
            if(stmt != null)		stmt.close();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);*/
			
			//Added by Ashwini for NMC-JD-SCF-0151
			if(p_function_id.equals("OPINTERNALREP")){
				prepstmt = con.prepareStatement(sql_query);
				prepstmt.setString(1,langg_id);
				prepstmt.setString(2,facc_id);
				prepstmt.setString(3,clinic_code);
				prepstmt.setString(4,visit_type);
				rset = prepstmt.executeQuery();  
		
			}else{
				rset = stmt.executeQuery(sql);	
			}
			//Added by Ashwini for MOHE-SCF-0102 & MOHE-SCF-0026
			if(p_function_id.equals("IPINTERNALREPORTREPRINT"))
			{
				session.removeAttribute("SQLSTRING_QUERYKEY");
			}
			else if(p_function_id.equals("ADMISSION"))
			{
				sql_querykey = request.getParameter("sql_querykey");

				if(sql_querykey.equals("SQLSTRING_QUERYKEYIPMP")){
					session.removeAttribute("SQLSTRING_QUERYKEYIPMP");
				}else if(sql_querykey.equals("SQLSTRING_QUERYKEYMPIP")){
					session.removeAttribute("SQLSTRING_QUERYKEYMPIP");
				}else if(sql_querykey.equals("SQLSTRING_QUERYKEYMP")){
					session.removeAttribute("SQLSTRING_QUERYKEYMP");
				}else if(sql_querykey.equals("SQLSTRING_QUERYKEYIP")){
					session.removeAttribute("SQLSTRING_QUERYKEYIP");
				}else if(sql_querykey.equals("SQLSTRING_QUERYKEY")){
					session.removeAttribute("SQLSTRING_QUERYKEY");
				}
			}
			else if(p_function_id.equals("VISIT_REGISTRATION"))
			{
				sql_querykey = request.getParameter("sql_querykey");

				if(sql_querykey.equals("VISIT_SQLSTRINGOP")){
					session.removeAttribute("VISIT_SQLSTRINGOP");
				}else if(sql_querykey.equals("VISIT_SQLSTRINGMP")){
					session.removeAttribute("VISIT_SQLSTRINGMP");
				}else if(sql_querykey.equals("VISIT_SQLSTRING")){
					session.removeAttribute("VISIT_SQLSTRING");
				}
			}else if(p_function_id.equals("AE_REGISTER_ATTN")){
				session.removeAttribute("AE_REG_ATTN_SQL");
			}

				langStmt=con.createStatement();
				langrSet=langStmt.executeQuery("select LANGUAGE_ID,SHORT_NAME from sm_language where EFF_STATUS='E'");
				while(langrSet!=null && langrSet.next()){
					langCode=langrSet.getString("LANGUAGE_ID");
					langDesc=langrSet.getString("SHORT_NAME");
					arrayList.add(langCode+"|~"+langDesc);
				}

			if(langrSet != null)langrSet.close();
            if(langStmt != null)langStmt.close();
			/*Below line was added by venkatesh.s on 25-MARCH-2013 against RUT-CRF-0006.1 [IN036541]*/
			if(!appt_no.equals("")){
				langChkSql="SELECT dflt_lang_online_report FROM mp_language WHERE lang_id = (SELECT LANGUAGE_ID FROM OA_APPT WHERE APPT_REF_NO='"+appt_no+"' and facility_id='"+fac_id+"')" ;
			}else if(!encounter_id.equals("")){				
				langChkSql = "SELECT dflt_lang_online_report FROM mp_language WHERE lang_id = (SELECT language_id FROM mp_patient a, pr_encounter b WHERE a.patient_id = b.patient_id and b.encounter_id ='"+encounter_id+"' and b.facility_id = '"+fac_id+"')";
			}else{
				langChkSql = "SELECT dflt_lang_online_report FROM mp_language WHERE lang_id = (SELECT language_id FROM mp_patient WHERE patient_id = '"+patient_id+"') ";
			}
			
			langStmt = con.createStatement();
			langrSet=langStmt.executeQuery(langChkSql);
			if(langrSet!=null && langrSet.next()){
				patLangCode=langrSet.getString("dflt_lang_online_report");
			}
			if (patLangCode==null) patLangCode="";
			
			%>
			<html>
			<body onKeyDown = 'lockKey()' onload="click_photo()">
			<form name='test' id='test' target="main" method='post' action='InternalReportsPrint.jsp'>
			<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
			<script language="JavaScript" src="../../eMP/js/ViewPatDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
				<script>
				function ValidateChk() {
			
					var rep_id=document.forms[0].rep_id.value;
					var obj; 
					var obj1; 
					var cnt = document.forms[0].total.value; 
					for (i=0;i<cnt;i++) { 
						obj=eval('document.forms[0].chk'+i);
						if (obj.checked) {
							return true;
						}
					}
					return false;
				}
				async function click_photo(){
				
					if(document.forms[0].capture_photo_yn.value=='Y'){
						if(document.forms[0].Photo_upload_yn.value=='Y'){
							if(document.forms[0].national_id_no.value!=''){
								// Start  Selayang & WCH  SmartKad
								var msg=getMessage("PHOTO_UPLOAD_PATH", "Common");
								var fso, f;
								fso = new ActiveXObject("Scripting.FileSystemObject");

								if(fso.FileExists("C:\\MyKad\\" + document.forms[0].national_id_no.value+".jpg")){
									msg=msg+ "  C:\\MyKad\\" +document.forms[0].national_id_no.value+".jpg";
								}
								if(fso.FileExists("C:\\IBS\\" + document.forms[0].national_id_no.value+".jpg")){
									msg=msg+ "  C:\\IBS\\" +document.forms[0].national_id_no.value+".jpg";
								}

								alert(msg);								
								// end  Selayang & WCH  SmartKad
								var url				= "../../eMP/jsp/photo_upload_main.jsp?patient_id="+document.forms[0].Patient_ID.value+"&photoCount=0";
								var dialogHeight	= "17";
								var dialogWidth		= "45";
								var arguments		= "";
								var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
								var reportURL		= await window.showModalDialog( url, arguments, features ) ;
								
								//if(reportURL=='close')
									//window.close();
								}
						}
					} 
				}
				</script>
				</head>							
				<table width='100%' border='1' cellspacing='0' cellpadding='0'>
				<%if(capture_photo_yn.equals("Y")){%>
				<TR><th align='left'><img align=center src='../../eCommon/images/Camera.gif' style="cursor:pointer" onClick="capturePhotoMain('<%=patient_id%>');"></img></th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th></TR>
				<%}%>
				<TR><th align='left'><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.required.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.copies.label" bundle="${common_labels}"/></th><th><fmt:message key="eSM.PreferredLanguage.label" bundle="${sm_labels}"/></th></TR>

			<%				
				String myReportID = "",myReportName="", numofCopies="", moduleID="";
				int i =0;	
				
					//Commented for NMC-JD-SCF-0151
					/*if (!rset.next()){	
					
					if(!p_function_id.equals("OPINTERNALREP")){
						rset.beforeFirst();
					}*/
					
					int cntr=0;
					
					while (rset.next()){
						myReportID = rset.getString(1);
						myReportName = rset.getString(2);
						numofCopies = rset.getString(3);
						moduleID = rset.getString(4);
						cntr++;

						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//PMG2012-CRF-0027 IN:037658  additional parameter added
						cs.setString( 1,    moduleID ) ;
						cs.setString( 2,    myReportID ) ;	
						
					

						if(myReportID.equals("FMFLRQSL")){
							cs.setString( 3,    "F" ) ;
							cs.setString( 4,    perm_fs_locn_code ) ;							
						}else{
							cs.setString( 3,    dest_locn_type ) ;
							cs.setString( 4,    dest_locn_code ) ; 							
						}									
						if(p_called_from.equals("FM_REQ_FILE")) { 
							cs.setString( 5,p_enter_fcy ) ;
						} else {
							cs.setString( 5,facilityId ) ;
						}						
						cs.setString( 6,    ws_no1 ) ;
						cs.setString( 7,    report_option ) ;
						cs.registerOutParameter( 8,  Types.VARCHAR ) ;
						cs.registerOutParameter( 9,  Types.VARCHAR ) ;
						cs.registerOutParameter( 10, Types.VARCHAR ) ;
						cs.registerOutParameter( 11, Types.VARCHAR ) ;
						cs.registerOutParameter( 12, Types.VARCHAR ) ;
						cs.registerOutParameter( 13, Types.VARCHAR ) ;
						cs.registerOutParameter( 14, Types.VARCHAR ) ;
						cs.registerOutParameter( 15, Types.VARCHAR ) ;
						cs.registerOutParameter( 16, Types.VARCHAR ) ;						
						cs.registerOutParameter( 17, Types.VARCHAR ) ;						
						cs.execute() ;						
						P_copies		= cs.getString( 10 ) ;
						P_queue_name	= cs.getString( 12 ) ;
	                    message			= cs.getString( 15 ) ;						
	                    rep_server_key			= cs.getString( 17 ) ;//IN037658
						//PMG2012-CRF-0027 IN:037658  additional parameter added
						if (message==null) message="";		   
						if (message.equals(""))
							disableChkbox = "checked";
						else
							disableChkbox = "disabled";	
	                    // Added the below changes by Abirami - Bru-HIMS-CRF-313 start- To get the report print option
	                    if ( message.equals("") ) // If there is no message, it will proceed to enable print option
	                    {
	                    	if(p_function_id!="") //If functionid is available, it will get the report print option from the settings table.   
	                    	{
	                    		message = CommonBean.getDefaultOnlinePrint(request, p_function_id, myReportID, moduleID);
								if("y".equalsIgnoreCase(message)) //if it is yes, it checks print option
				                    disableChkbox = "checked";
				                else if("n".equalsIgnoreCase(message)) //if it is no, it unchecks the print option
				                    disableChkbox = "";
				                else //if there is no record, apply existing logic which checks print options for the given report. 
				                	disableChkbox = "checked";
	                    	}else //If functionid is not available, apply existing logic which checks print options for all the report. 
	                    	{
	                    		disableChkbox = "checked";
	                    	}
	                    }
						else  // else If there is message, it will disable print option
						{
							disableChkbox = "disabled";
						}
		                // Bru-HIMS-CRF-313 end
						if(P_copies==null){
							P_copies="";
						}
										
						if(cs != null)		cs.close();

						out.println("<tr>");
						out.println("<td width='75%' align='left' class='"+classValue+"'>"+myReportName+"<input type='hidden' name='reportid"+i+"' id='reportid"+i+"' value='"+myReportID+"'><input type='hidden' name='moduleid"+i+"' id='moduleid"+i+"' value='"+moduleID+"'></td>");
						out.println("<td width='10%' align='center' class='"+classValue+"'><input type='checkbox' "+disableChkbox+" name='chk"+i+"' id='chk"+i+"' width='15%' value='Y'></td>");
						out.println("<td  align='center' class='"+classValue+"'><input type='text' name='noofcopies"+i+"' id='noofcopies"+i+"' align='right' maxlength='3' size='2' onKeyPress='return(ChkNumberInput(this,event,0));'  onblur='CheckPositiveNumber1(this)' value='"+P_copies+"' "+disableChkbox+"></td>");
						out.print("<td  align='center' class='"+classValue+"'><select name='prefLang"+i+"' id='prefLang"+i+"' value='"+i+"' "+disableChkbox+">");
						for(int cnt=0;cnt<arrayList.size();cnt++){
							String str=(String)arrayList.get(cnt);
							StringTokenizer token=new StringTokenizer(str,"|~");
							langCode=token.nextToken();
							langDesc=token.nextToken();
							String selecteYN="";
							
							if(!patLangCode.equals("")){
							if(patLangCode.equalsIgnoreCase(langCode)){
								selecteYN="selected";								
							} 
							}else{
								if(locale.equals(langCode)){
									selecteYN="selected";
									
								}
							}					
						 
							if(disableChkbox.equals("disabled")){
								out.print("<option value='' selected>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Select.label","common_labels")+"--</option>");
							}
							out.print("<option value=\""+langCode+"\" "+selecteYN+">"+langDesc+"</option>");
						}
						out.println("</select></td>");
						out.println("</tr>");
						i++;
					}
				
						if(rset != null)	rset.close();
						//if(cs != null)		cs.close();
                        con.commit();
				//}else{//Commented for NMC-JD-SCF-0151	

					
					if(cntr==0){
				
					//out.println("<script>alert(getMessage('REPORT_RULE_NOT_DEFINED','Common'));</script>"); Commented by Rameswar on 20-Oct-15 against HSA-CRF-0319
					if(rep_id.equals("IPBWBLBW")){
						out.println("<script>parent.parent.frames[1].location.href='../../eIP/jsp/IPPrintPatientWristbandCriteria.jsp';parent.parent.frames[2].location.href='../../eCommon/html/blank.html';</script>");							
					}else{
						//out.println("<script>parent.window.close();</script>");
						out.println("<script> const diagElement = parent.parent.document.getElementsByTagName('dialog');var i = 0; var j = 0;for (i = 0; i < diagElement.length; i++) {for (j = 0; j < diagElement[i].children.length; j++) {var element = diagElement[i].children[j];let dialogSrc = element.src;if (typeof dialogSrc !== 'undefined'){ const dialogTag = diagElement[i];dialogTag.close();}}}</script>");
						
					}
				}
				%>
				</table>			
				<input type='hidden' name='total' id='total' value='<%=i%>'>
				<input type='hidden' name='step' id='step' value='2'>
				<input type='hidden' name='rep_id' id='rep_id' value='<%=rep_id%>'>
				<input type='hidden' name='reportParamNames' id='reportParamNames' value="<%=reportParamNames%>">
				<input type='hidden' name='reportParamValues' id='reportParamValues' value="<%=reportParamValues%>">
				<input type='hidden' name='dest_locn_type' id='dest_locn_type' value="<%=dest_locn_type%>">
				<input type='hidden' name='dest_locn_code' id='dest_locn_code' value="<%=dest_locn_code%>">	
				<input type='hidden' name='p_language_id' id='p_language_id' value="<%=locale%>">	
				<input type='hidden' name='enc_facilityId' id='enc_facilityId' value="<%=enc_facilityId%>">	
				<input type='hidden' name='p_encounter_id' id='p_encounter_id' value="<%=p_encounter_id%>">	
				<input type='hidden' name='p_function_id' id='p_function_id' value="<%=p_function_id%>">	
				<input type='hidden' name='p_enter_fcy' id='p_enter_fcy' value="<%=p_enter_fcy%>">	
				<input type='hidden' name='p_called_from' id='p_called_from' value="<%=p_called_from%>">	
					<input type='hidden' name='Patient_ID' id='Patient_ID' value="<%=patient_id%>">	
				<input type='hidden' name='perm_fs_locn_code' id='perm_fs_locn_code' value="<%=perm_fs_locn_code%>">	
				<input type='hidden' name='rep_server_key' id='rep_server_key' value="<%=rep_server_key%>">	<!--IN037658-->
				<input type='hidden' name='national_id_no' id='national_id_no' value="<%=national_id_no%>">
				<input type='hidden' name='Photo_upload_yn' id='Photo_upload_yn' value="<%=Photo_upload_yn%>">
				<input type='hidden' name='capture_photo_yn' id='capture_photo_yn' value="<%=capture_photo_yn%>">
					
 			
				<center style="margin-top: 25px;"><input type='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>   ' class='Button' onclick='if(ValidateChk()){
						document.forms[0].submit();
						
						alert(getMessage("REPORT_SUBMIT_SERVER","Common"));
						if("<%=rep_id%>"=="IPBWBLBW"){
							parent.parent.frames[1].location.href="../../eIP/jsp/IPPrintPatientWristbandCriteria.jsp";
							parent.parent.frames[2].location.href="../../eCommon/html/blank.html";
						}else{
							parent.window.close();
						}
						}else{
						alert(getMessage("ATLEAST_ONE_REP_SELECT","Common"));
						}'>&nbsp;&nbsp;&nbsp;
						<input type='Button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='Button' onclick='if("<%=rep_id%>"=="IPBWBLBW"){parent.parent.frames[1].location.href="../../eIP/jsp/IPPrintPatientWristbandCriteria.jsp";parent.parent.frames[2].location.href="../../eCommon/html/blank.html";}else{parent.window.close()}'></center>
							
							
						</form>
				</body>
				</html>
			<% 
		}
		catch(Exception e) { out.println(e.toString());e.printStackTrace();}
		finally {
     		  if(cs != null)		cs.close();
			  if (stmt != null)    stmt.close();
			  if (prepstmt != null) prepstmt.close();
			  if(con!=null) ConnectionManager.returnConnection(con,request);  
		}
	}else{
		//Reports Execution
			
  		String facilityId = (String)session.getValue("facility_id");
		String prefLang="";
		Statement stmt=null;
		ResultSet rset=null;
		ResultSet rs = null;
		String p_patient_id		= request.getParameter("Patient_ID")==null?"":request.getParameter("Patient_ID");
		String encounterid		= request.getParameter("Encounter_ID")==null?"":request.getParameter("Encounter_ID");
		String reportParamNames = request.getParameter("reportParamNames")==null?"":request.getParameter("reportParamNames");
		String p_language_id	= request.getParameter("p_language_id")==null?"":request.getParameter("p_language_id");
		String rep_id			= request.getParameter("rep_id")==null?"":request.getParameter("rep_id");		
		String reportParamValues= request.getParameter("reportParamValues")==null?"":request.getParameter("reportParamValues");
        String req_no="";			
		String dest_locn_type	= request.getParameter("dest_locn_type")==null?"":request.getParameter("dest_locn_type");
		String enc_facilityId	= request.getParameter("enc_facilityId")==null?"":request.getParameter("enc_facilityId");
		String p_encounter_id	= request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");
		String p_function_id	= request.getParameter("p_function_id")==null?"":request.getParameter("p_function_id");
		String dest_locn_code	= request.getParameter("dest_locn_code")==null?"":request.getParameter("dest_locn_code");
		 perm_fs_locn_code	= request.getParameter("perm_fs_locn_code")==null?"":request.getParameter("perm_fs_locn_code");
		String ws_no			= request.getRemoteAddr() ;		
		Connection con = ConnectionManager.getConnection(request);
		CallableStatement cs1 = null;
		CallableStatement cs  = null;
		PreparedStatement pstmt = null;
		String session_id	= "";
		String global_name	= ""; 		
		boolean fireQuery	= false;
		boolean commit		= false;
		StringBuffer stringBuffer = new StringBuffer();
		int intcopy  = 0;  		
		String copy			= "";		
		int k=0;
		
		try{
			stmt =  con.createStatement();
			rset = stmt.executeQuery("select TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') sys_date from dual");
			if(rset.next()){
				sys_date = rset.getString("sys_date");
			}
			if(rset!=null)rset.close();
			java.util.StringTokenizer paramNameTokens = new java.util.StringTokenizer(reportParamNames,",");
			java.util.StringTokenizer paramValueTokens = new java.util.StringTokenizer(reportParamValues,",");

			String repparamNames[] = new String[paramNameTokens.countTokens()];
			String repparamValues[] = new String[paramNameTokens.countTokens()];
			int i = 0;
			while (paramNameTokens.hasMoreTokens()){
				repparamNames[i] = paramNameTokens.nextToken();
				if (paramValueTokens.hasMoreTokens())
					repparamValues[i] = paramValueTokens.nextToken();
				else
					repparamValues[i] = "";				
				if(repparamNames[i].equals("P_req_no"))
				{
					req_no=repparamValues[i];
				}
				i++;
			}			
			String total = request.getParameter("total");
			if (total==null) total="0";
			String reportid = "", ncopy="", nreqd="", moduleid="";
			int totalCnt = Integer.parseInt(total);
			if (totalCnt>0){
				OnlineReports onlineReports = new OnlineReports();				
				for(int j=0;j<totalCnt;j++){
					reportid = request.getParameter("reportid"+j);
					ncopy = request.getParameter("noofcopies"+j);
					nreqd = request.getParameter("chk"+j);
					prefLang = request.getParameter("prefLang"+j);
					if (nreqd==null) nreqd="";
					moduleid = request.getParameter("moduleid"+j);

					String exe_name = "";

					if(reportid.equals("MPBIDLBL"))
					{						
						//stringBuffer.append(" select executable_name_bm from SM_REPORT where report_id = 'MPBIDLBL' ");
						//stmt = con.createStatement();
						rs = stmt.executeQuery("select executable_name_bm from SM_REPORT where report_id = 'MPBIDLBL' ");
						if(rs!=null && rs.next())
						{
							exe_name  = rs.getString("executable_name_bm");
						}
						if(rs != null) rs.close();
						//if(stmt != null) stmt.close();
						if(exe_name.equals("MPMODIDL"))
						{
							copy = request.getParameter("noofcopies"+j);
							intcopy = Integer.parseInt(copy);
							fireQuery = true;
						}
					}

					if(fireQuery)
					{
						try
						{
							if(p_patient_id.equals("") && !encounterid.equals(""))
							{
								if(stringBuffer.length() > 0) stringBuffer.delete(0,stringBuffer.length());
								stringBuffer.append(" select patient_id, global_name, userenv('sessionid') from PR_ENCOUNTER, GLOBAL_NAME where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
								//stmt = con.createStatement();
								rs = stmt.executeQuery(stringBuffer.toString());
								if(rs!=null && rs.next())
								{
									p_patient_id  = rs.getString("patient_id");
									global_name  = rs.getString(2);
									session_id  = rs.getString(3);
								}
								if(rs != null) rs.close();
								//if(stmt != null) stmt.close();
							}
							else if(!p_patient_id.equals("") && encounterid.equals(""))
							{
								if(stringBuffer.length() > 0) stringBuffer.delete(0,stringBuffer.length());
								stringBuffer.append(" select global_name, userenv('sessionid') from GLOBAL_NAME ");
								//stmt = con.createStatement();
								rs = stmt.executeQuery(stringBuffer.toString());
								if(rs!=null && rs.next())
								{
									global_name  = rs.getString(1);
									session_id  = rs.getString(2);
								}
								if(rs != null) rs.close();
								//if(stmt != null) stmt.close();
							}
							//for(int m=0;m<intcopy;m++)
							//{
								if(stringBuffer.length() > 0) stringBuffer.delete(0,stringBuffer.length());
								//stringBuffer.append(" insert into SY_REPORT_GENERATE_REQUEST (OPERATING_FACILITY_ID, USER_ID, MACHINE_NAME, WS_NO, PGM_ID, SESSION_ID, REQUEST_DATE, PGM_TYPE, CMD_LINE_ARG, URGENT_INDICATOR) values ('"+facilityId+"', '"+login_user+"', '"+ws_no1+"', '"+ws_no1+"', 'MPRPATID', '"+session_id+"', SYSDATE, 'C', 'MPRPATID appluser/appluser@"+global_name+" "+session_id+" "+p_patient_id+" "+facilityId+" "+ws_no1+" MPBIDLBL O "+intcopy+"', 'U') ");

								rs = stmt.executeQuery("SELECT APP_PASSWORD.DECRYPT(APPL_USER_PASSWORD) FROM SM_APPL_USER WHERE APPL_USER_ID = '"+login_user+"'");
								String pwd="";
								if(rs!=null && rs.next()){
									pwd  = rs.getString(1);									
								}
								if(rs != null) rs.close();

								stringBuffer.append(" insert into SY_REPORT_GENERATE_REQUEST (OPERATING_FACILITY_ID, USER_ID, MACHINE_NAME, WS_NO, PGM_ID, SESSION_ID, REQUEST_DATE, PGM_TYPE, CMD_LINE_ARG, URGENT_INDICATOR) values ('"+facilityId+"', '"+login_user+"', '"+ws_no1+"', '"+ws_no1+"', 'MPRPATID', '"+session_id+"', SYSDATE, 'C', 'MPRPATID "+login_user+"/"+pwd+"@"+global_name+" "+session_id+" "+p_patient_id+" "+facilityId+" "+ws_no1+" MPBIDLBL O "+intcopy+"', 'U') ");

								try
								{
									pstmt = con.prepareStatement(stringBuffer.toString());
									int insert = 0;
									insert = pstmt.executeUpdate();
									if(insert == 0)
									{
										commit = false;
									}
									else
									{
										commit = true;
									}
									if(pstmt != null) pstmt.close();
								}catch(Exception exp) 
								{ 
									exp.printStackTrace();
								}
							//}
							if(commit)
							{
								con.commit();
							}
							if(rs != null) rs.close();
							if(stmt != null) stmt.close();
						}
						catch(Exception e) 
						{ 
							out.println("Exception in report insertion : "+e.toString());
							e.printStackTrace();
						}
						finally 
						{
							ConnectionManager.returnConnection(con,request);
						}
					}

					if (!exe_name.equals("MPMODIDL")) {

						if (nreqd.equals("Y")){						
						String tmp1=dest_locn_type;
						String tmp2=dest_locn_code;												
						if(reportid.equals("FMFLRQSL")){
							dest_locn_type="F";
							dest_locn_code=perm_fs_locn_code;
						}					
						OnlineReport fm_report=new OnlineReport();						
						OnlineReport report=null;

						ArrayList arlst_temp=new ArrayList();
						ArrayList dest_locn_code_temp=new ArrayList();
												
						if(p_called_from.equals("FM_REQ_FILE")){ 
							stmt =  con.createStatement();
							String sql="select distinct CURR_FS_LOCN_CODE from fm_req_dtl where REQ_NO='"+req_no+"'";							
							rset = stmt.executeQuery(sql);
							if(rset!=null)
							{													
								while(rset.next()){ 
									dest_locn_code=rset.getString("CURR_FS_LOCN_CODE");
									dest_locn_code_temp.add(dest_locn_code);									
									fm_report = new OnlineReport(p_enter_fcy,moduleid,reportid,dest_locn_type,dest_locn_code);
									arlst_temp.add(fm_report);									
								}
							 }
						} else {
							report = new OnlineReport(facilityId,moduleid,reportid,dest_locn_type,dest_locn_code);
						}						
						
						if(reportid.equals("FMFLRQSL")){
							dest_locn_type=tmp1;
							dest_locn_code=tmp2;
						}					

						if(p_called_from.equals("FM_REQ_FILE")){ 
							for(k=0; k<arlst_temp.size(); k++){
								fm_report=(ecis.utils.OnlineReport) arlst_temp.get(k);								
								fm_report.addParameter( "p_facility_id", p_enter_fcy ) ;
								fm_report.addParameter( "p_report_id",     reportid ) ;
								fm_report.addParameter( "p_module_id",     moduleid ) ;
								fm_report.addParameter( "copies",  ncopy ) ;
								for (int x=0;x<repparamNames.length;x++){
										if(repparamNames[x].equals("p_encounter_id")){
											if(repparamValues[x].equals("TEMP*12*")){
												fm_report.addParameter(repparamNames[x],"");
											}else{
												fm_report.addParameter(repparamNames[x], repparamValues[x]);
											}
										}else{
											fm_report.addParameter(repparamNames[x], repparamValues[x]);
										}
								}
								fm_report.addParameter( "p_language_id",  prefLang ) ;	
								fm_report.addParameter( "p_user_name",  login_user ) ;//added for the SCF - AMS-SCF-0257	
								fm_report.addParameter( "p_dest_locn_code",  (String)dest_locn_code_temp.get(k) ) ;									
							}
						} else {
							report.addParameter( "p_facility_id", facilityId ) ;	 
							report.addParameter( "p_report_id",     reportid ) ;
							report.addParameter( "p_module_id",     moduleid ) ;
							report.addParameter( "p_user_name",     login_user ) ;//added for the SCF - AMS-SCF-0257
							report.addParameter( "copies",  ncopy ) ;
						
							for (int x=0;x<repparamNames.length;x++){
								if(repparamNames[x].equals("p_encounter_id")){
									if(repparamValues[x].equals("TEMP*12*")){
										report.addParameter(repparamNames[x],"");
									}else{
										report.addParameter(repparamNames[x], repparamValues[x]);
									}
								}else{
									report.addParameter(repparamNames[x], repparamValues[x]);
								}
							}
							report.addParameter( "p_language_id",  prefLang ) ;	
						}
						if (reportid.equals("MPSTBCER") || reportid.equals("MPBNBFRM") ||  reportid.equals("MPBIRCER") || reportid.equals("MRDTHCER")){							
							cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? ) }" ) ;
							cs.setString( 1,    moduleid ) ;
							cs.setString( 2,    reportid ) ;
							cs.setString( 3,    dest_locn_type ) ;
							cs.setString( 4,    dest_locn_code ) ;
							cs.setString( 5,    facilityId ) ;
							cs.setString( 6,    ncopy ) ;
							cs.setString( 7,    "P" ) ;
							cs.registerOutParameter( 8,  Types.VARCHAR ) ;
							cs.registerOutParameter( 9,  Types.VARCHAR ) ;
							cs.registerOutParameter( 10, Types.VARCHAR ) ;
							cs.registerOutParameter( 11, Types.VARCHAR ) ;
							cs.registerOutParameter( 12, Types.VARCHAR ) ;
							cs.registerOutParameter( 13, Types.VARCHAR ) ;
							cs.registerOutParameter( 14, Types.VARCHAR ) ;
							cs.registerOutParameter( 15, Types.VARCHAR ) ;
							cs.registerOutParameter( 16, Types.VARCHAR ) ;
							cs.registerOutParameter( 17, Types.VARCHAR ) ;
							cs.execute() ;							
							String P_copies		= cs.getString( 10 ) ;
							String P_queue_name	= cs.getString( 12 ) ;
							String message			= cs.getString( 15 ) ;
							String rep_server_key			= cs.getString( 17 ) ;//IN037658

							cs1 = con.prepareCall( "{ call SM_PRINT_ROUTING_AUDIT_PROC( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }" ) ;
							cs1.setString( 1,enc_facilityId) ;
							cs1.setString( 2,p_encounter_id) ;
							cs1.setString( 3,p_patient_id ) ;
							cs1.setString( 4,moduleid ) ;
							cs1.setString( 5,reportid ) ;
							cs1.setString( 6,p_function_id) ;
							cs1.setString( 7,ncopy ) ;
							cs1.setString( 8,P_queue_name) ;
							cs1.setString( 9,login_user ) ;
							cs1.setString( 10,sys_date) ;
							cs1.setString( 11,ws_no1 ) ;
							cs1.setString( 12,facilityId ) ;
							cs1.registerOutParameter( 13, Types.VARCHAR ) ;
							cs1.registerOutParameter( 14, Types.VARCHAR ) ;
							cs1.execute() ;

							String p_out_status		= cs1.getString( 13 ) ;
	                        String p_out_error			= cs1.getString( 14 ) ;
                            if (p_out_status==null) p_out_status="";
                            if (p_out_error==null) p_out_error="";

							if(cs1 != null)		cs1.close();

							if (p_out_status.equals("E")){
								out.println("<script>alert('"+p_out_error+"');</script>");
							}else{
								con.commit();
							}
						}												
						if(p_called_from.equals("FM_REQ_FILE")){
							for(k=0; k<arlst_temp.size(); k++){
								fm_report=(ecis.utils.OnlineReport) arlst_temp.get(k);								
								onlineReports.add( fm_report ) ;	
							}
						}else{							
							onlineReports.add( report ) ;	
						}
					}  
				  }
				}
				//String ReportOutput = 
				onlineReports.execute( request, response ) ;
				
			}
		}catch(Exception e){
			out.println(e);
			e.printStackTrace();
		}finally{
			if (stmt != null)    stmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
}
%>

