<!DOCTYPE html>
 <%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*, webbeans.eCommon.*,java.util.*,javax.servlet.http.*,org.json.simple.*,javax.servlet.jsp.JspWriter,eCommon.XSSRequestWrapper " %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
 String locale			= (String)session.getAttribute("LOCALE");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>	
	<script src='../../eMP/js/RegPatReferral.js' language='javascript'></script>	
	<script src='../../eMP/js/RegPatReferral1.js' language='javascript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>	
	<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
// Added on 24/12/2009 by Muthu against IN017559
function invokeTab(objName)
    {
        // FIRST CHANGE THE CURRENT SELECTED TAB 
		selectTab(objName);		
		goToTab(objName); 		
    }

	function goToTab(objName)
    {
        		
		if(objName == 'ReferredFrom_a') { 
			document.getElementById('referred_from').style.display = 'inline';
			document.getElementById('referred_to').style.display = 'none'; 									
		} else if(objName == 'ReferredTo_a') {			
			document.getElementById('referred_from').style.display = 'none';
			document.getElementById('referred_to').style.display = 'inline';					
		} 		
	}
// End of Comment
function tab_click1(id,id1){
	
	//selectTab(id1);
	if(id=='1')
	{
			document.getElementById('mother_tab').style.visibility='hidden'
			document.getElementById('first').style.visibility='visible'
			document.getElementById('referred_from1').scrollIntoView();
			//alert(document.getElementById('ref_letter_no').disabled);
			if(document.forms[0].referral_type.value == 'L')
			{
			document.getElementById('b_pract').disabled=false;
			}
			if(document.getElementById('ref_letter_no').disabled == false)
			document.getElementById('ref_letter_no').focus();
			
		
	}
	else if(id=='2')
	{
			document.getElementById('mother_tab').style.visibility='visible'
			document.getElementById('first').style.visibility='hidden'
			//document.getElementById('b_pract').disabled=true;
			document.getElementById('referredto1').scrollIntoView();
			if(document.getElementById("to_speciality_code").disabled == false)
			document.getElementById("to_speciality_code").focus();
		   
			
	}
	
	
	        }


			
</script>
<script>

</script>

</head>

<%
	Connection con = null;
	String facilityid = (String) session.getValue("facility_id");
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rset=null ;
	ResultSet rs=null ;
	ResultSet mod_rs=null ;
	Statement stmt = null;
	String sel				 = "";	
	String facilityname			= "";	
	String pat_name_as_multipart_yn = "";	
	String ass_func_id			= "";	
	String service_desc	=	"";
	String calling_from			= request.getParameter("calling_from");		
	String p_calling_function	= request.getParameter("p_calling_function");
	if (p_calling_function==null) p_calling_function="";
	
	String p_to_locn_type=request.getParameter("p_to_locn_type");
	 if(p_to_locn_type == null) p_to_locn_type="";
	String p_to_locn_code=request.getParameter("p_to_locn_code");
	 if(p_to_locn_code == null) p_to_locn_code="";
	 String contextURL= request.getContextPath();

    if(p_calling_function.equals("OP_REG_VISIT"))
	{
		ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
	}
	
	String res_class=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");

	String mode = request.getParameter("mode");	
	
	if(mode==null || mode.equals("")) mode="insert";

	String pat_ID = request.getParameter("pat_ID");	
	if(pat_ID == null) pat_ID="";
		
	String hcaresettingtypecode = "";
	String speciality_code	= request.getParameter("speciality_code");
	if(speciality_code==null) speciality_code="";

	
	String service_code	= request.getParameter("service_code");
	if(service_code==null) service_code="";
	String practitioner	= request.getParameter("practitioner");
	if(practitioner==null) practitioner="";
	String practitioner_name	= request.getParameter("practitioner_name");
	if(practitioner_name==null) 	practitioner_name="";

		
	if (calling_from==null) calling_from="";
		
	String sys_date="";
	
	String sql				= "";
	StringBuffer mod_sql			= new StringBuffer();
	String referral_id	= request.getParameter("referral_id");
	if (referral_id==null) referral_id="";
	String patientid		= "";
	String ca_patient_id= (request.getParameter("ca_patient_id") == null)?"":request.getParameter("ca_patient_id");
	String from_ref_code	= "";
	String referral_letter_no= "";
	String referral_priority = "";
	String from_locn_desc	= "";
	String referral_date	= "";
	String received_date	= "";
	String preferred_treatment_date="";
	String from_pract_name	= "";
	String to_speciality_code= "";
	String to_locn_type		= "";
	String to_locn_code		= "";	
	String to_service_code	= "";
	String to_pract_id		= "";	
	String from_hcare_setting_type="";
	String ref_notes		= "";
	String from_fcy_id		= "";
	String to_pract_name	= "";
	String from_pract_id	= "";
	String from_ref_type	= "";
	String from_pract_name1	= "";
	String from_locn_id		= "";
	String from_locn_type	= "";	
	String pract_res_tel_num =""; 
	String pract_mobile_num=""; 
	String pract_pager_num =""; 
	String referral_reason_code =""; 
	String referral_reason_desc="";
	String other_doc_att=""; 
	String exam_and_clin_findings="";
	String diagnosisTab="";
	String treatmentTab="";	
	String from_speciality_code="";
	String referred_for_ip="";
	String locntypecode="";
	String locntypedesc="";
	String transfer_case_yn="N";  //Added by Afruddin for ML-MMOH-CRF-1527 US3 On 28-july-2020
	String tc_chk=""; //Added by Afruddin for ML-MMOH-CRF-1527 US3 On 28-july-2020
	StringBuffer specstr=new StringBuffer();
	specstr.setLength(0);

    String curr_year="";   	

	String or_operational_yn="";
	String entitlement_by_pat_cat_yn="";
    String patient_name="";
	String status="";

	String or_catalog_desc="";
	String or_catalog_code="";
	String rd_operational_yn="";
	String selval="";
	String seldis="";
	Clob note = null;
	String smartCardFunc="";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023

	ArrayList Arr_Of_HashMap=new ArrayList();
	HashMap general_HashMap=new HashMap();
    //Below Added by Suji Keerthi for NMC-JD-CRF-0130
	String priority_Code="";
    String priority_Desc="";
	JSONObject RefPriorityJson = new JSONObject();
	JSONArray refPriorityjsonArr = new JSONArray();	
	
	//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
	String p_service_desc	=	request.getParameter("p_service_desc");
	String p_service_code	=	request.getParameter("p_service_code");
	//End
	
	try
	{
		con = ConnectionManager.getConnection(request);
		smartCardFunc = isSiteSpecificforBiometric(con);//Added by Himanshu for AAKH-CRF-0175
		Boolean isTransferCase	= eCommon.Common.CommonBean.isSiteSpecific(con,"MP","BMI_REG_PAT_CHNGES_RH101"); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
        //Below Added by Suji Keerthi for NMC-JD-CRF-0130
        Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
        RefPriorityJson = eIP.IPCommonBean.getReferralPriority(con); 
		refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
		
		
		if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
		{
			mod_sql.append("SELECT a.from_speciality_code,a.pract_res_tel_num pract_res_tel_num, a.pract_mobile_num pract_mobile_num, a.pract_pager_num pract_pager_num , a.referral_reason_code referral_reason_code,(SELECT am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"','1')  FROM am_contact_reason  WHERE contact_reason_code  = a.referral_reason_code and reason_for_referral_yn ='Y') referral_reason_desc ,a.other_doc_att, a.exam_and_clin_findings,a.referral_letter_no ref_letter_no, a.diagnosis,a.treatment, a.referral_id, a.from_ref_type from_ref_type, a.patient_id,a.PATIENT_NAME, a.from_ref_code, a.referral_priority, a.referral_letter_no, a.from_locn_desc,TO_CHAR(a.referral_date,'dd/mm/yyyy hh24:mi')referral_date, TO_CHAR(a.received_date,'dd/mm/yyyy hh24:mi') received_date, TO_CHAR(a.preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date,a.from_facility_id, a.from_pract_name, a.to_speciality_code,a.to_locn_type to_locn_type,a.to_locn_code to_locn_code, a.to_service_code,a.to_pract_id,a.status stat,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, a.from_hcare_setting_type, a.ref_notes, am_get_desc.am_practitioner(a.TO_PRACT_ID,'en',1) to_pract_name,(case when a.FROM_REF_TYPE='X' then am_get_desc.am_ext_practitioner(a.FROM_PRACT_ID,?,1) else am_get_desc.am_practitioner(a.FROM_PRACT_ID,?,1) end) from_pract_name1,a.from_pract_id from_pract_id ,a.FROM_PRACT_NAME free_text_pract_name,from_locn_code from_locn_id, from_locn_type,referred_for_ip,transfer_case_yn FROM pr_referral_register a"); //Modified by Afruddin for ML-MMOH-CRF-1527 US3 On 28-july-2020

			if(mode.equals("modify"))
			{
				  mod_sql.append(" where a.referral_id =? ");
			}
			else if(mode.equals("RegisterMoreReferral"))
			{

				if(!pat_ID.equals(""))
				{
				  mod_sql.append(" where a.patient_id =? order by a.referral_id ");
				}
				else
				{
					mod_sql.append(" where a.referral_id =? order by a.referral_id ");
				}
			}
			
			pstmt = con.prepareStatement(mod_sql.toString());
			
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);

			if(mode.equals("modify"))
			{
				pstmt.setString(3,referral_id);
			}
			else if(mode.equals("RegisterMoreReferral"))
			{
				if(!pat_ID.equals(""))
				{
				pstmt.setString(3,pat_ID);
				}
				else
				{
				pstmt.setString(3,referral_id);
				}	
			}

		
			mod_rs = pstmt.executeQuery();
	

			while(mod_rs !=null&& mod_rs.next())
			{	
				referred_for_ip            = mod_rs.getString("referred_for_ip");
				if (referred_for_ip==null) referred_for_ip="";

				from_pract_id           = mod_rs.getString("from_pract_id");
				if (from_pract_id==null) from_pract_id=""; 
				//treatmentTab	= java.net.URLEncoder.encode(mod_rs.getString("treatment"),"UTF-8");
				treatmentTab            = mod_rs.getString("treatment");
				if (treatmentTab==null) treatmentTab="";
				//diagnosisTab	= java.net.URLEncoder.encode(mod_rs.getString("diagnosis"),"UTF-8");
				diagnosisTab            =mod_rs.getString("diagnosis");
				if (diagnosisTab==null) diagnosisTab="";
				//exam_and_clin_findings	= java.net.URLEncoder.encode(mod_rs.getString("exam_and_clin_findings"),"UTF-8");
				exam_and_clin_findings          = mod_rs.getString("exam_and_clin_findings");		
				
				if (exam_and_clin_findings==null) exam_and_clin_findings="";
				
				other_doc_att           = mod_rs.getString("other_doc_att");
				if (other_doc_att==null) other_doc_att="";
				referral_reason_code            = mod_rs.getString("referral_reason_code");
				if (referral_reason_code==null) referral_reason_code="";
				referral_reason_desc            = mod_rs.getString("referral_reason_desc");
				if (referral_reason_desc==null) referral_reason_desc="";

				pract_pager_num                 = mod_rs.getString("pract_pager_num");
				if (pract_pager_num==null) pract_pager_num="";

				pract_mobile_num                = mod_rs.getString("pract_mobile_num");
				if (pract_mobile_num==null) pract_mobile_num="";

				pract_res_tel_num               = mod_rs.getString("pract_res_tel_num");
				if (pract_res_tel_num==null) pract_res_tel_num="";

				from_fcy_id		 = mod_rs.getString("from_facility_id");
				if (from_fcy_id==null) from_fcy_id="";
				from_locn_id		 = mod_rs.getString("from_locn_id");
				if (from_locn_id==null) from_locn_id="";
				from_locn_type		 = mod_rs.getString("from_locn_type");
				if (from_locn_type==null) from_locn_type="";
				from_ref_type		 = mod_rs.getString("from_ref_type");				 
				if (from_ref_type==null) from_ref_type="";
				from_speciality_code            = mod_rs.getString("from_speciality_code");
				if (from_speciality_code==null) from_speciality_code="";
				//Added by Afruddin for ML-MMOH-CRF-1527 US3 on 28-july-2020
				transfer_case_yn = mod_rs.getString("transfer_case_yn"); 
				
				if (transfer_case_yn==null ||transfer_case_yn=="") transfer_case_yn="N";
				
				if(transfer_case_yn.equals("Y"))
				{
					tc_chk="Checked";
				}
				//Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 28-july-2020
				from_ref_code		=mod_rs.getString("from_ref_code");
				if (from_ref_code==null) from_ref_code="";
				from_hcare_setting_type=mod_rs.getString("from_hcare_setting_type");
				if (from_hcare_setting_type==null) from_hcare_setting_type="";
				patient_name=mod_rs.getString("patient_name");
				patientid			=mod_rs.getString("patient_id");
				if (patientid==null) patientid="";
				referral_priority	=mod_rs.getString("referral_priority");
				if (referral_priority==null) referral_priority="";
				referral_letter_no	=mod_rs.getString("referral_letter_no");
				if (referral_letter_no==null) referral_letter_no="";
				from_locn_desc		=mod_rs.getString("from_locn_desc");
				if (from_locn_desc==null) from_locn_desc="";
				referral_date		=mod_rs.getString("referral_date");
				if (referral_date!=null) 
					referral_date=DateUtils.convertDate(referral_date,"DMYHM","en",localeName);	
				else
					referral_date="";
				received_date		=mod_rs.getString("received_date");
				if (received_date!=null)
					received_date=DateUtils.convertDate(received_date,"DMYHM","en",localeName);
				else
					received_date="";
				

				preferred_treatment_date=mod_rs.getString("preferred_treatment_date");
				if (preferred_treatment_date!=null)
					preferred_treatment_date=DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
				else
					preferred_treatment_date="";
				from_pract_name=mod_rs.getString("from_pract_name");
				if (from_pract_name==null) from_pract_name="";
				to_speciality_code=mod_rs.getString("to_speciality_code");
				if (to_speciality_code==null) to_speciality_code="";
				to_locn_type=mod_rs.getString("to_locn_type");
				if (to_locn_type==null) to_locn_type="";		 
				to_locn_code=mod_rs.getString("to_locn_code");
				if (to_locn_code==null) to_locn_code="";

				status=mod_rs.getString("stat");
				if(status == null) status="";
		
				or_catalog_code=mod_rs.getString("ORDER_CATALOG_CODE");
				if(or_catalog_code == null) or_catalog_code="";


				to_service_code=mod_rs.getString("to_service_code");
				if (to_service_code==null) to_service_code="";
				
				to_pract_id=mod_rs.getString("to_pract_id");
				if (to_pract_id==null) to_pract_id="";
				from_pract_name1	 = mod_rs.getString("from_pract_name1");
				if (from_pract_name1==null) from_pract_name1="";
				to_pract_name		 = mod_rs.getString("to_pract_name");
				if (to_pract_name==null) to_pract_name="";			 
				note=mod_rs.getClob("ref_notes");

				ref_notes = "";
				java.io.BufferedReader r = null;
				if(note!=null)
				{
				r = new java.io.BufferedReader(note.getCharacterStream());
				String line = null;
				while((line=r.readLine()) != null) 	ref_notes=ref_notes+line+"\n";
				
				}			
			}	



			if(mod_rs != null) mod_rs.close();
			if(pstmt != null) pstmt.close();
			mod_sql.setLength(0);
		}

		
%>
<%!
/*************getdata1() more generalized*******************/

		public ArrayList getData1(String sql,String[] whereClause,JspWriter out,Connection con) throws Exception
		{

			ArrayList arrL_of_HashMap                            = new ArrayList() ;
			PreparedStatement pstmt                              = null ;
			ResultSet resultSet                                  = null ;
			ResultSetMetaData resultSetMetaData  = null;
			HashMap hmRecord = null;

			try {	
				pstmt = con.prepareStatement(sql) ;                 
				if (whereClause!=null)
						for (int index=0; index<whereClause.length ;index++ )
								pstmt.setString( index+1, whereClause[index]);
				resultSet = pstmt.executeQuery() ;
				if (resultSet != null) {
					resultSetMetaData   =   resultSet.getMetaData();			
					while (resultSet.next()) {	
						hmRecord	=  new HashMap();			
						for (int i=1; i<=resultSetMetaData.getColumnCount(); i++) {
							String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
							if(column_Val==null) column_Val="";     
							hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);	
						}
						arrL_of_HashMap.add(hmRecord) ;				
					} 
				}
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e) {
				
				e.printStackTrace() ;
				out.println(e.toString()); 
			}
			finally {		
				try {
					if(resultSet!=null)     resultSet.close();
					if(pstmt!=null) pstmt.close();
				 }catch(Exception es) { es.printStackTrace();}
			}	
			return arrL_of_HashMap;
		}		
%><%
	try{			
			String sqlQuery = "select facility_name,hcare_setting_type_code,TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') sys_date, TO_CHAR (SYSDATE, 'rrrr') curr_year,(SELECT operational_yn FROM sm_modules_facility WHERE module_id = 'RD' AND facility_id = ?) rd_operational_yn,(SELECT operational_yn FROM sm_modules_facility WHERE module_id = 'OR' AND facility_id =?) or_operational_yn, (SELECT  SHORT_DESC FROM AM_SERVICE_LANG_VW WHERE  SERVICE_CODE=? and language_id=?) short_desc, (select entitlement_by_pat_cat_yn  from mp_param) entitlement_by_pat_cat_yn from SM_FACILITY_PARAM_LANG_VW where FACILITY_ID = ? and language_id=?";	
			pstmt=con.prepareStatement(sqlQuery);		
			pstmt.setString(1,facilityid);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,to_service_code);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,locale);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next())	{
				service_desc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
				facilityname = rs.getString("facility_name")==null?"":rs.getString("facility_name");;
				hcaresettingtypecode = rs.getString("hcare_setting_type_code")==null?"":rs.getString("hcare_setting_type_code");
				sys_date=rs.getString("sys_date")==null?"":rs.getString("sys_date");;
				curr_year=rs.getString("curr_year")==null?"":rs.getString("curr_year");;
				rd_operational_yn=rs.getString("rd_operational_yn")==null?"":rs.getString("rd_operational_yn") ;
				or_operational_yn=rs.getString("or_operational_yn")==null?"":rs.getString("or_operational_yn") ;
				entitlement_by_pat_cat_yn=rs.getString("entitlement_by_pat_cat_yn");
			}	
			
			sys_date=DateUtils.convertDate(sys_date,"DMYHM","en",localeName);	
			if(received_date.equals("")) received_date=sys_date;		

			if(pstmt!=null)pstmt.close();
		 } catch(Exception e){
				
				e.printStackTrace() ;
		}
		
	 try{

		sql="Select Short_Desc,Speciality_Code from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
		Arr_Of_HashMap=getData1(sql,null,out,con);
		general_HashMap.clear();
		for(int i=0; i<Arr_Of_HashMap.size();i++)	{
			general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
			specstr.append(" <option value='"+general_HashMap.get("SPECIALITY_CODE")+"'>"+general_HashMap.get("SHORT_DESC")+"</option>");					
		}		
		}catch(Exception e) {
			
			e.printStackTrace() ;
		}
	%>
	<!--defaultLoginFacility() Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178]-->
	<!--reftype() Added by Afruddin on 28-jun-2020 for ML-MMOH-CRF-1527 US3 -->
	<body OnMouseDown='CodeArrest()' onKeyDown ='lockKey()' onload='chkforref();<%if(!mode.equals("modify")){%>defaultLoginFacility();<%}%><%if(isTransferCase){%>reftype();<%}%>' onSelect = "resMove()">
		

	
	
	  <form name="RegPatReferral_form" id="RegPatReferral_form" action="../../servlet/eMP.RegPatReferralServlet" target=messageFrame method=post>
	   <div id = 'referred_from'>
			<input type='hidden' name='ct_tab_name' id='ct_tab_name' >
			<a name='firstanc' id='firstanc'></a>
			<input type='hidden' name='help_function_id' id='help_function_id' value='REGISTER_PAT_REFERRAL'>
			<a name='fromref' id='fromref' ></a>
			
	  
	    <ul id="tablist" class="tablist" style="padding-left:0px" >
	   <li class="tablistitem" title='<fmt:message  key="Common.ReferredFrom.label" bundle="${common_labels}"/>'>
		  <a onclick="invokeTab('ReferredFrom_a')" class="tabClicked" id="ReferredFrom_a" >
		  <span class="tabSpanclicked" id="ReferredFrom_aspan"><fmt:message  key="Common.ReferredFrom.label" bundle="${common_labels}"/></span>
		  </a>
	  </li>
	   <li class="tablistitem" title='<fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/>'>
	       <a onclick="invokeTab('ReferredTo_a')" class="tabA" id="ReferredTo_a" >
	        <span class="tabAspan" id="ReferredTo_aspan"><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></span>
			</a>
		</li>
       </ul>
	
	  <table cellpadding='1' cellspacing=0 border=0 width="100%" id='first'>
			<tr>
			<td  class='COLUMNHEADER' colspan=6><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/> </td>
			<tr>
					<td align='left' class=LABEL  ><fmt:message key="eMP.ReferralLetterNo.label" bundle="${mp_labels}"/></td>
					<td class='FIELDS' >
					<input type="text" name="ref_letter_no" id="ref_letter_no"  onBlur = 'makeValidString(this);' onKeyPress='return CheckForSpecChars1(event)' size=15 maxlength=30 tabIndex='1' >
					</td>
					<td align='left' class='label' ><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/>
					</td>
					<td  class='FIELDS' >
					<input type="text" id="received_date" name="received_date" value="<%=sys_date%>"  size=14 maxlength=16 onBlur="javascript:return validateDates(this,'RE');" tabIndex='2'><input type='image' name= "recd" id= "recd" src='../../eCommon/images/CommonCalendar.gif' onClick="return  showCalendar('received_date',null,'hh:mm');" ><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
					</tr>
					<tr>
					<td align='left'  class='label' ><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/>
					</td>
					<td class='FIELDS' ><input type="text"  name="referral_date" id="referral_date" size=14 maxlength=16 value="<%=sys_date%>" onBlur="javascript:return validateDates(this,'R')" tabIndex='3' ><input type='image' name= "red" id= "red" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('referral_date',null,'hh:mm');" ><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
				
					<td align='left'  class='label'><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
					<td class='FIELDS'>
						<input type="text" id="preferred_date" name="preferred_date"  size=10 maxlength=10 onBlur="javascript:return validateDates(this,'P')" tabIndex='4'><input type='image' name= "pred" id= "pred" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('preferred_date');"  ></img></td>
					</tr>
					<tr>	
					<td align=left class=LABEL  width='195pt'><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></td>
					<td width='299pt' class='FIELDS'><input type='text' name='referral_reason_desc' id='referral_reason_desc' onBlur ='getReasonForRefblur(document.getElementById("refReason"));'  size=30 maxlength=30 value="<%=referral_reason_desc%>" tabIndex='5'><input type='button' class='button' name='ref_reason' id='ref_reason' value='?' id = 'refReason' onclick="getReasonForRef(this);" ><input type='hidden' name='referral_reason_code' id='referral_reason_code'  value=""></td>
					
					<td align=left class=LABEL width='243pt'><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
					<td class='FIELDS' >
					      <!-- Below line modified by Afruddin for ML-MMOH-CRF-1527 US3 -->
						<select name="referral_type" id="referral_type" onchange='getval3(this);<%if(isTransferCase){%>reftypechange();<%}%>' tabIndex='6'>	
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
							<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
							<option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>		
						</select><img id=id1 src='../../eCommon/images/mandatory.gif'>
					</td>
				    
					 <!-- Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020 -->
					 
					 <% if(isTransferCase){
						 
					  %>
					  <td align=left class='label' id= 'transfer_case' nowrap ><fmt:message key="eMP.TransferCase.label" bundle="${mp_labels}"/>
			         <input type='checkbox'  name='transfer_case_yn' id='transfer_case_yn'value="<%=transfer_case_yn%>" onclick='ChangeState(this)' <%=tc_chk%>>
                      </td>
					 <%
						  }
					 %>
					<!-- Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 28-jun-2020-->
                     </tr>
						<tr>
						<td align=left class=LABEL  ><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
					<td  class='FIELDS'>
						<select name="hcare_type" id="hcare_type" onchange='getval3(this)' tabIndex='7'>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<%
								sel="";
								String sql_hcare="SELECT hcare_setting_type_code,short_desc FROM AM_HCARE_SETTING_TYPE_LANG_VW  WHERE eff_status='E' and  language_id='"+locale+"' ORDER BY 2";
								Arr_Of_HashMap=getData1(sql_hcare,null,out,con);							
								general_HashMap.clear();
								for(int i=0; i<Arr_Of_HashMap.size();i++)
								{
									sel="";		
									 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);								 if(general_HashMap.get("HCARE_SETTING_TYPE_CODE").equals(from_hcare_setting_type)) sel="selected";	
								%>	
									<option value='<%=general_HashMap.get("HCARE_SETTING_TYPE_CODE")%>' <%=sel%>><%=general_HashMap.get("SHORT_DESC")%></option>
								<%						
								}
								%>
						</select><img align=center src='../../eCommon/images/mandatory.gif'></img>
					</td>
					  <!--Legend name  modified  for PMG2014-CRF-0007 [IN:046756] -->
									<td  align=left class=LABEL ><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></td>
					<td  class='FIELDS' >						
							<%	
								String disp_val="";
								String disp_val_bkup="";
								String disp_val_id="";
								String disp_val_lng_name="***";

								if(mode.equals("modify") || mode.equals("RegisterMoreReferral")){									
									if (from_ref_type.equals("X")){
										sql = "Select a.LONG_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc,nvl(a.long_name,'***') long_name from AM_REFERRAL_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.short_desc";	
										pstmt=con.prepareStatement(sql);
										rs = pstmt.executeQuery();			
										while(rs!=null && rs.next()){											
											if (rs.getString("referred_to_id").equals(from_ref_code)){
												disp_val=rs.getString("referred_to_id_desc");
												disp_val_bkup=disp_val;
												disp_val_id=rs.getString("hcare_setting_type")+"~"+rs.getString("referred_to_id");
												disp_val_lng_name=rs.getString("long_name");
											}			
										}											
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									 }else if (from_ref_type.equals("L")){ 		
										 if (from_fcy_id.equals(facilityid)){		
											 /*
											sql = " select facility_name from SM_FACILITY_PARAM_LANG_VW where facility_id = '"+facilityid+"' and b.language_id='"+locale+"'";											
											pstmt=con.prepareStatement(sql);
											rs = pstmt.executeQuery();
											while(rs!=null && rs.next()){
												disp_val=rs.getString("facility_name");
												disp_val_bkup=disp_val;												
												disp_val_id=from_hcare_setting_type+"~"+facilityid;
												disp_val_lng_name="***";												
											}											
											if(rs != null) rs.close();
											if(pstmt != null) pstmt.close();		
											*/
												disp_val=facilityname;
												disp_val_bkup=disp_val;												
												disp_val_id=from_hcare_setting_type+"~"+facilityid;
												disp_val_lng_name="***";		
										}else{												
											sql = " SELECT a.FACILITY_ID Referral_Code ,a.FACILITY_NAME referred_to_id_desc   ,a.hcare_setting_type_code hcare_setting_type_code , b.short_desc hcare_setting_type_desc FROM  sm_facility_param_lang_vw a ,  am_hcare_setting_type_lang_vw b WHERE a.facility_id != '"+facilityid+"'  AND a.hcare_setting_type_code= '"+from_hcare_setting_type+"'   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN ( SELECT to_hcare_setting_type_code   FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code = a.hcare_setting_type_code AND ( ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id='"+localeName+"' AND b.language_id='"+localeName+"' ORDER BY  a.facility_name";
											
											pstmt=con.prepareStatement(sql);
											rs = pstmt.executeQuery();
											sel ="";			
											while(rs!=null && rs.next()){													
												if (rs.getString("Referral_Code").equals(from_fcy_id)){
													
													disp_val=rs.getString("referred_to_id_desc");
													disp_val_bkup=disp_val;
													disp_val_id=rs.getString("hcare_setting_type_code")+"~"+rs.getString("Referral_Code");
													disp_val_lng_name="***";
												}		   
											}//while Close		

											if(rs != null) rs.close();
											if(pstmt != null) pstmt.close();
										}  //else close
									}else{			
										sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW  b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facilityid+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name";									
										
										pstmt=con.prepareStatement(sql);
										rs = pstmt.executeQuery();			 
										sel ="";
										while(rs!=null && rs.next()){
											 sel ="";
											if (rs.getString("referred_to_id").equals(from_fcy_id)){
												disp_val=rs.getString("referred_to_id_desc");
												disp_val_bkup=disp_val;
												disp_val_id=rs.getString("hcare_setting_type_code")+"~"+rs.getString("referred_to_id");
												disp_val_lng_name="***";
											}											
										}
										
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									}		
								}
								%>						
						<input type='text' name='referral_source' id='referral_source' size='25' maxlength="15" onBlur ='clear_ref();' value="<%=disp_val%>"><input type='button' class='button' name='referral_source_lkp_but' id='referral_source_lkp_but' value='?' onClick="referralSourceLookup(this)" ><%if(disp_val_lng_name.equals("***")){%><img src='../../eCommon/images/more.gif' name="lng_name" id="lng_name" align=center style="visibility:hidden"><%}else{%><img src='../../eCommon/images/more.gif' name="lng_name" id="lng_name" align=center alt="<%=disp_val_lng_name%>"><%}%>
					<input type='hidden' name='referral_source_lkp_bkup_text' id='referral_source_lkp_bkup_text' size='15' maxlength="15" value="<%=disp_val_bkup%>">
					<input type='hidden' name='referral_source_lkp_id' id='referral_source_lkp_id' size='5' maxlength="15" value="<%=disp_val_id%>">
					
					</td>
				</tr>
				<tr>
					<td align=left class=LABEL><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					<td class='FIELDS'>
						<select name='speciality' id='speciality' onchange='clearLocationList(this);' tabIndex='9'>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option><%=specstr.toString()%>
							</select></td>
					<td align='right'colspan=2>
                      <input type='button' style='width:78pt'class='button' name='clinical_details' id='clinical_details' value='<fmt:message key="eMP.clinicaldetails.label" bundle="${mp_labels}"/>' onclick="Modal_Clinical_Details(this,'<%=calling_from%>','<%=mode%>');" tabIndex='16'><input type='hidden' name = 'from_practitioner' id = 'from_practitioner' value=""><!-- </td><td align='left'> --><input type="button" style='width:40pt' class=BUTTON value='<fmt:message key="Common.notes.label" bundle="${common_labels}"/>'onClick="javascript:showTextArea('referral_notes','<%=calling_from%>','<%=mode%>')" tabIndex='17'>   
					</td>
					</tr>
					<tr>
					<!--Added 'id' for incident IN023039 by Suresh M on 24.08.2010 -->
					<td  id = 'E_locationtype' class=LABEL><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					
					<% 
						if(!mode.equals("modify") && !mode.equals("RegisterMoreReferral")){%>
							<td  id ='E_location' class='FIELDS' >
							<select name=location0 id=location0  onchange='clear_location(this)' tabIndex='10'>
								<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>    
							</select></td><td class=label id='enew_location1'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td   colspan=1  id ='Enew_location' >
							<select name="from_locn" id="from_locn" onChange='clear_pract(this)' tabIndex='11'>
								<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							</select></td>			
							<%
						}else{ 

							if (from_ref_type.equals("X")){	%>
								<td  id ='E_location' class='FIELDS'  >
								<input type='text' name='from_locn' id='from_locn' size=30 maxlength=30 onBlur = 'makeValidString(this)' tabIndex='11'></td> 
								<td class=label id='enew_location1'></td><td  id ='Enew_location' class='FIELDS'></td>
							<%}else{%>
								<td  id ='E_location' class='FIELDS' >
								<select name=location0 id=location0 onchange='clear_location(this)' tabIndex='10'><option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								<%sql = " select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facilityid+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";
								
								pstmt=con.prepareStatement(sql);
								rs = pstmt.executeQuery();
								int ip=0;
								int op=0;

								stmt=con.createStatement();
								while(rs!=null && rs.next()) {
									ip= rs.getInt("ip");
									op= rs.getInt("op");
									mod_sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in (");
									
									if (op>0){
										mod_sql.append("'C',");
									}
									mod_sql.append("'E','D'");
									if(ip>0){
									  mod_sql.append(",'N'");
									}
									mod_sql.append(") and locn_type in(");
									if(op>0){
									  mod_sql.append("'C',");
									}
									mod_sql.append("'E','Y' ");
									if(ip>0){
									  mod_sql.append(",'N'");
									}
									mod_sql.append(" ) and sys_user_def_ind='S' and language_id='"+locale+"' order by 2");

								
									rset=stmt.executeQuery(mod_sql.toString());
									if(rset != null){
										while(rset.next()){	
										  locntypecode=rset.getString("locn_type");
										  locntypedesc=rset.getString("short_desc");
											%>
												<option value='<%=locntypecode%>'><%=locntypedesc%>
											<%		 
										}
									}%>
									</select></td>
									<%if(rset != null) rset.close();						
									mod_sql.setLength(0);

								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								if(stmt != null) stmt.close();
						%>
								 <td class=label id='enew_location1'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td  id ='Enew_location' class='FIELDS'><select name=from_locn onChange='clear_pract(this)'><option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								<%		
					
								if(from_locn_type.equals("C") ){
									sql = "Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw  where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and ALLOW_REFERRAL_YN='Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='C'  and clinic_type='C' and language_id='"+locale+"' order by 1";

									
								}else if(from_locn_type.equals("E")){
									sql = "Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='E' and language_id='"+locale+"' order by 1";

								}else if(from_locn_type.equals("N")){
									sql = "Select a.long_desc dat, a.nursing_unit_code id, 'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a   where a.facility_id = '"+from_fcy_id+"' and a.locn_type='N' and a.PATIENT_CLASS = 'IP' and a.eff_status = 'E' and a.language_id='"+locale+"' order by 1";
								}else if(from_locn_type.equals("Y")){
									
									sql = "Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='D' and clinic_type='Y' and language_id='"+locale+"' order by 1";
								}              

								if(from_locn_type.equals("C") || from_locn_type.equals("N") || from_locn_type.equals("Y") || from_locn_type.equals("E"))
								{
									pstmt=con.prepareStatement(sql);					   
									rs = pstmt.executeQuery();
									sel ="";
									while(rs!=null && rs.next()){
										sel ="";
										if (rs.getString("id").equals(from_locn_id)) 
											sel="selected";	
										
										out.println("<option value='"+rs.getString("id")+ "'"+sel+" >" + rs.getString("dat")+"</option>");
									}
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
								}
							}
						}
						%>
           
					</td>		
				</tr>
				<tr>
						<td align=left class=LABEL ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					
					<td  class='FIELDS' >		
					<input type='text' name='from_practitioner_id' id='from_practitioner_id' onchange="disable_ext_pract(this);" onBlur = "makeValidString(this);chg_pract(this);onBlurCallPractitionerSearch(document.forms[0].b_pract,document.forms[0].from_practitioner_id);disable_ext_pract(this);" tabIndex='12' size=25 maxlength=30><input type='button' class='button' name='b_pract' id='b_pract' value='?' onclick="callPractSearch(this,document.forms[0].from_practitioner_id);" >


					 <input type='text' name='from_ext_practitioner_id' id='from_ext_practitioner_id' onchange="disable_pract(this);"  onBlur = "disable_pract(this);" tabIndex='12' size=25 maxlength=30 id = 'pract_ext_name' style = 'display:none'>
					</td>	

					<td align='left' class='label'><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
				
					
					<td class='FIELDS' >
					<input type="text" id="" name="tel_no" id="tel_no" size=10 maxlength=18 onKeyPress='return CheckForSpecChars1(event)' onBlur = 'makeValidString(this);' tabIndex='13'>
					</tr>
					<tr>	
					<td class=label><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>
					</td>
					<td class='FIELDS'>	
					<input type="text" id="" name="mobile_no" id="mobile_no" onKeyPress='return CheckForSpecChars1(event)' onKeyPress='return CheckForSpecChars(event)' size=10 maxlength=18 onBlur = 'makeValidString(this);' tabIndex='14' >
					</td>	
					<td class=label>	
					<fmt:message key="Common.PagerNo.label" bundle="${common_labels}"/> 
					</td><td  class='FIELDS' >	
					<input type="text" id="" name="pager_no" id="pager_no" size=10 maxlength=18 onKeyPress='return CheckForSpecChars1(event)' onBlur = 'makeValidString(this);if(document.getElementById('ref_letter_no')){document.getElementById('ref_letter_no').focus();}' tabIndex='15'>
					</td>	
					</tr>
				
		 </table>
		</div>

		 <div id = 'referred_to' style = 'display:none'> 
		
		 <ul id="tablist" class="tablist" style="padding-left:0px">
	     <li class="tablistitem" title='<fmt:message  key="Common.ReferredFrom.label" bundle="${common_labels}"/>'>
		  <a onclick="invokeTab('ReferredFrom_a')" class="tabA" id="ReferredFrom_b" >
		  <span class="tabAspan" id="ReferredFrom_bspan"><fmt:message  key="Common.ReferredFrom.label" bundle="${common_labels}"/></span>
		  </a>
	     </li>
	   <li class="tablistitem" title='<fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/>'>
	       <a onclick="invokeTab('ReferredTo_a')" class="tabClicked" id="ReferredTo_b" >
	        <span class="tabSpanclicked" id="ReferredTo_bspan"><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></span>
			</a>
		</li>
        </ul>	
		<table id='mother_tab' width="100%" cellpadding=2 cellspacing=0 border=0 >	
				<tr>
					<td  class='COLUMNHEADER' colspan=4><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
				<td  align=left class=LABEL  width='20%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					<td class='FIELDS'  width='304pt'>
 						<select name="to_speciality_code" id="to_speciality_code" onChange="populatetolocn(this)"  > 
							<option value='' >-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option><%=specstr.toString()%>
						</select>							
						<img align=center src='../../eCommon/images/mandatory.gif'></img>
						<script>
						document.forms[0].to_speciality_code.value="<%=to_speciality_code%>";
						</script>
					</td>
				<td  align=left class=LABEL><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
					<td class='FIELDS'>
						<select name="priority" id="priority"  > 
							<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
                               <% if(isReferralPriorityAppl){ 	

								   refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
					
					              for(int i = 0 ; i < refPriorityjsonArr.size() ; i++) 
				                  {
                             
									JSONObject jsonObj = (JSONObject) refPriorityjsonArr.get(i);
									priority_Code		= checkForNull((String) jsonObj.get("priority_Code"));
									priority_Desc		= checkForNull((String) jsonObj.get("priority_Desc"));
									out.println("<option value='"+priority_Code+"'>"+priority_Desc+"</option>");						
							
						         } 
								 }else{%>

						<!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->
							<option value="L"><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
							<option value="U"><fmt:message key="Common.semiemergency.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						<%} %>		<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
						</select><img align=center src='../../eCommon/images/mandatory.gif'></img></td>
			
		
					
					</tr>
					<tr>
						
					<td align=left class=LABEL ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td class='FIELDS'>
						<%
							String restric="N";
						if( p_calling_function.equals("IP_ADMIT") || p_calling_function.equals("IP_BOOKING") ||	 p_calling_function.equals("CHG_ADM_DTLS"))
							restric="Y";
						else if(p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equals("OA_MODIFY_APPT")|| ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED"))
							restric="O";
						else if(p_calling_function.equals("CHG_REG_DTLS") ||p_calling_function.equals("AE_REGISTER_ATTN") ||p_calling_function.equals("REV_VISIT_DTLS"))
							restric="C";
						else if(p_calling_function.equals("OP_REG_VISIT")&&ass_func_id.equals("VISIT_REGISTRATION")){
							
							restric="E";
						}
                        	String lcare="";
	 					if(p_calling_function.equals("CHG_REG_DTLS")||p_calling_function.equals("AE_REGISTER_ATTN"))
						{
							
							to_locn_type="C";
							to_speciality_code=speciality_code;
							p_to_locn_code="";
							lcare="and level_of_care_ind ='E' ";
						}
						if(p_calling_function.equals("REV_VISIT_DTLS")) {
							
							lcare="and level_of_care_ind in ('A','E') ";
							to_locn_type = p_to_locn_type;
							to_speciality_code=speciality_code;
						}

						else
						{
							lcare="and level_of_care_ind in ('A','E') ";
						}

						if(restric.equals("O"))
						{
							selval="selected";
							if(!p_calling_function.equals("OA_MODIFY_APPT"))
								seldis="disabled";
						}
						else
						{
							selval="";
							seldis="";
						}
					
						if( p_calling_function.equals("REV_VISIT_DTLS") || p_calling_function.equals("OA_MODIFY_APPT") ||	 p_calling_function.equals("CHG_ADM_DTLS")|| ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED"))
                         seldis="disabled"; 
						%>
						<select name='locationT0' id='locationT0' onchange='clear_location(this)' <%=seldis%>>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------- 	
						<%
						mod_sql.append("select locn_type,short_desc from AM_CARE_LOCN_TYPE_LANG_VW  where ");
						
						
						if(restric.equals("C"))
						{
							mod_sql.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
						}
						else if(restric.equals("E"))
						{
                            
							mod_sql.append(" care_locn_type_ind in ('E','C')  and locn_type in('E','C') and");
						}
						else if(restric.equals("O"))
						{
							if(p_to_locn_type.equals("D"))
								to_locn_type="Y";
							else
								to_locn_type=p_to_locn_type;

							to_speciality_code=speciality_code;
							to_locn_code=p_to_locn_code;
													
							if(p_to_locn_type.equals("C"))
							{
								mod_sql.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
							}
							else if(p_to_locn_type.equals("D"))
							{
								mod_sql.append(" care_locn_type_ind in ('D') and locn_type in('Y') and ");
							}
							else if(p_to_locn_type.equals("E"))
							{
								mod_sql.append(" care_locn_type_ind in ('E') and locn_type in('E') and ");
							}
						}
						else if(restric.equals("Y"))
						{
							mod_sql.append(" care_locn_type_ind in ('N')  and locn_type in('N') and");
							to_locn_type="N";
							to_speciality_code=speciality_code;
						}
						else
						{
							if(rd_operational_yn.equals("Y"))
							{
								mod_sql.append(" care_locn_type_ind in ('C','E','D','N','W') and locn_type in('C','E','Y','N','W') and  ");
							}else
							{
								mod_sql.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");
							}
							
						}		  
			  
						mod_sql.append(" sys_user_def_ind='S' and language_id='"+locale+"' order by 2");	 

						
						
						pstmt=con.prepareStatement(mod_sql.toString());
						rs=pstmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{	
								locntypecode=rs.getString("locn_type");
								locntypedesc=rs.getString("short_desc");
								%>
									<option value='<%=locntypecode%>' <%=selval%>><%=locntypedesc%>
								<%			 
							}
						}

						if(rs != null) rs.close();
						if(pstmt !=null) pstmt.close();								
						%>
						<script>
							if(parent.frames[1].document.forms[0].locationT0 != null)
							{
										
								popToLocationType('<%=to_locn_type%>');
							}
						</script>
						</select><img align=center src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td class=label><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td><td class='FIELDS'   id ='T_location'>
						<select name=to_locn id=to_locn  onchange='clear_pract(this)' <%=seldis%>>
							<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
							<%
							sel="";
							if(!to_locn_type.equals("")) {
								if(to_locn_type.equals("C")) {
									sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw  where facility_id = '"+facilityid+"'  and allow_visit_regn_yn = 'Y' and ALLOW_REFERRAL_YN='Y' and eff_status = 'E' "+lcare+" and speciality_code = '"+to_speciality_code+"' and CARE_LOCN_TYPE_IND = 'C' and clinic_type='C' and clinic_code=nvl('"+p_to_locn_code+"',clinic_code) and language_id='"+locale+"' order by 1 ";
								} else if(to_locn_type.equals("E")) {
									sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw where facility_id = '"+facilityid+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+to_speciality_code+"' and CARE_LOCN_TYPE_IND = 'E' and clinic_code=nvl('"+p_to_locn_code+"',clinic_code) and language_id='"+locale+"' order by 1 ";
								}// Fix Against ML-BRU-SCF-1200 [IN:045701] By Saanthaakumar 
								else if (to_locn_type.equals("N")) {
									sql="Select a.long_desc dat, a.nursing_unit_code id,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+facilityid+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and locn_type='N' and PATIENT_CLASS = 'IP'and a.facility_id = b.facility_id and b.specialty_code = '"+to_speciality_code+"' and a.nursing_unit_code = nvl('"+p_to_locn_code+"',a.nursing_unit_code) and a.language_id='"+locale+"' order by 1";
								} else if(to_locn_type.equals("Y")) {									
									sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw  where facility_id = '"+facilityid+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+to_speciality_code+"' and CARE_LOCN_TYPE_IND = 'D' and clinic_type='Y' and clinic_code=nvl('"+p_to_locn_code+"',clinic_code) and language_id='"+locale+"' order by 1 ";
								} else if(to_locn_type.equals("W")) {
									sql="SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+facilityid+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL";
								}
								if(mode.equals("modify") && p_calling_function.equals(""))
									  p_to_locn_code = to_locn_code;
								pstmt=con.prepareStatement(sql);
								rs=pstmt.executeQuery();
								if(rs != null) {
									while(rs.next()) {											
										if(p_to_locn_code.equals(rs.getString("id"))){
											sel="selected";
										} else {
											sel="";
										}
										%>
										<option value='<%=rs.getString("id")+"$"+rs.getString("open_to_all_pract_yn")%>' <%=sel%>><%=(rs.getString("dat") == null)?"":rs.getString("dat")%>
										<%
									   }
									}				
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
							}						
					%>
					</select>
					</td>
					</tr>
						<tr>
						<td  align=left class=LABEL  width='245pt'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>	<!--REFERAL_REQUIRED ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005-->
					<td class='FIELDS'><INPUT TYPE="text" name="to_service_desc" id="to_service_desc" <%if(ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")){%> value="<%=p_service_desc%>" disabled<%}else{%> value="<%=service_desc%>"<%}%> onblur="getService1(this,'<%=facilityid%>','<%=to_locn_type%>',to_service_code)" size=18 ><input type='button' class='button'  name='search_service' id='search_service' value='?' onclick="getService(to_service_desc,'<%=facilityid%>','<%=to_locn_type%>',to_service_code);" >
		         <%if(mode.equals("insert")) 
		             {%>
		              <input type=hidden name='to_service_code' id='to_service_code' <%if(ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")){%> value='<%=p_service_code%>'<%}else{%> value=''<%}%>>
		           <%}else
		              {%>
		              <input type=hidden name='to_service_code' id='to_service_code' value='<%=to_service_code%>'>
		             <%}%>
					 </td>
					
					<td align=left class=LABEL><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='FIELDS' >
						<input type='text' name='to_practitioner_id' id='to_practitioner_id' size=30 maxlength=30 onblur="onBlurCallPractitionerSearch(document.forms[0].b_pract1,document.forms[0].to_practitioner_id);" disabled><input type='button' class='button' name='b_pract1' id='b_pract1' value='?' onclick="callPractSearch(document.forms[0].b_pract1,document.forms[0].to_practitioner_id);" disabled><input type='hidden' name = 'to_practitioner' id = 'to_practitioner' value="">
					</td>
							</tr>
							
							<%
			String dis1="";
			String ronly="";

		if(or_operational_yn.equals("Y")) {
			if(mode.equals("modify")) {
				pstmt=con.prepareStatement("select short_desc from or_order_catalog where ORDER_CATALOG_CODE='"+or_catalog_code+"' ");
				rs = pstmt.executeQuery();
				if(rs != null && rs.next()) {
					 or_catalog_desc=rs.getString(1);
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		}

		if(mode.equals("modify")) {
		   if(to_locn_type.equals("N")){
			  dis1="disabled";
			  ronly="readOnly";
		   }else{
			 dis1="";
			 ronly="";
		   }
		}else {
			dis1="disabled";
			ronly="readOnly";
		}
		%>
		
		
	

		<tr>	
		<td align=left class=LABEL ><fmt:message key="eMP.OrderableProcedure.label" bundle="${mp_labels}"/></td>
		<td class='FIELDS'><input type='text' align='left' name='order_catalog_desc' id='order_catalog_desc' size=30 maxlength=30 <%=ronly%>  value='<%=or_catalog_desc%>' onblur='if(this.value !="") populate_order(document.getElementById("catalog_but_id"));'><input type='button' class='button' value='?' name='catalog_but' id='catalog_but' id='catalog_but_id' <%=dis1%>  onClick='populate_order(this);' onblur="getFocus('priority');">
		
		<input type='hidden' name='order_catalog' id='order_catalog' value='<%=or_catalog_code%>'>
				
		</td>
		

		<%}else{
			%>
		<td align=left class=LABEL ></td>
		<td> 
		<input type='hidden' name='order_catalog' id='order_catalog' value=''>
				
		</td>
		<%}%>
		<td  align=left class=LABEL ><fmt:message key="eMP.ReferredForIP.label" bundle="${mp_labels}"/></td>
			<td class='FIELDS'>
			<select name="referred_for_ip" id="referred_for_ip" onblur="getFocus('refferd')";> 
			<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
			<option value='A'><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>
			<option value='B'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></option>
			</select><img align=center src='../../eCommon/images/mandatory.gif' name='refforipimg'></img>
			</td>
			</tr>
				<%if(mode.equals("modify"))
		{%> 
				<td class='COLUMNHEADER' colspan=4><fmt:message key="Common.followup.label" bundle="${common_labels}"/>/<fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></td>
				
	<%
		
		String apptNo="";
	    String dis="";

		if(status.equals("X") || status.equals("D") || status.equals("N"))
			dis="disabled";
		else if (status.equals("C") || status.equals("O"))
			dis="";
	%>
	<tr>
	<td align='left' class='label' ><fmt:message key="Common.action.label" bundle="${common_labels}"/> </td>
	<td class='FIELDS' ><select name='action' id='action' onchange="clear_text(this);" <%=dis%>><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
	<% if(status.equals("C")){%>
	<option value='RF'><fmt:message key="Common.followup.label" bundle="${common_labels}"/></option>
	<%}else if(status.equals("O")){%>
	<option value='RF'><fmt:message key="Common.followup.label" bundle="${common_labels}"/></option>
	<option value='RR'><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
	<%}%>
	</select>
	</td>
	<td align='left' class='label' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
	<td class='FIELDS' ><input type='text' name='reason_txt' id='reason_txt' size='30' onblur="if(this.value!=''){populate_reason(this);}"  maxlength='40 'value='' readonly><input type='button' class='button' name='reason_but' id='reason_but' value='?' onclick="populate_reason(this,reason_txt);" disabled></td>
	<input type='hidden' name='reason_code' id='reason_code' value=''>
	</tr>
	<tr>
	<td align='left' class='label' ><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></td>
	<td class='FIELDS' ><input type='text' name='apptNo' id='apptNo' onKeyPress="return CheckForSpecChars(event)" value='' size=22 maxlength=20 ></td>
	
	<td align='left' class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='FIELDS' ><input type='text' name='remarks' id='remarks' size=35 maxlength=30 value='' readonly></td>
	
	<!-- <input type='hidden' name='apptNo' id='apptNo' value='<%=apptNo%>'> -->
	</tr>
		<%}%>
	<tr><td class='white'></td></tr>
	<tr><td class='white'></td></tr>
	<tr><td class='white'></td></tr>
	</table>
    <table  cellpadding=0 cellspacing=0 border=1 width="100%">		
	<!-- <tr style="height:36px;"> -->
		
	<%
		
		if(mode.equals("modify"))
		{
	   
		sql="select to_char(a.ACTION_DATE_TIME,'dd/mm/yyyy hh24:mi')  ACTION_DATE_TIME,a.ACTION_TYPE,DECODE(a.ACTION_TYPE,'AS', 'Appt Scheduled','AR', 'Appt Re-scheduled','AC', 'Appt Cancelled','RF', 'Referral Follow-up','RR', 'Referral Rejected','CO', 'Completed/Encounter Registered') ACTION_TYPE_DESC,a.ACTION_REASON_CODE,b.CONTACT_REASON ACTION_REASON_DESC,a.ACTION_REF_ID   ACTION_REF_ID,a.ACTIONED_BY ACTIONED_BY,a.ACTION_REMARKS ACTION_REMARKS from PR_REFERRAL_REGISTER_ACTION a, am_contact_reason b where a.ACTION_REASON_CODE=b.CONTACT_REASON_CODE(+) and a.FACILITY_ID='"+facilityid+"' and a.referral_id='"+referral_id+"' order by  a.ACTION_DATE_TIME desc ";

		
		
		pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=pstmt.executeQuery();
		
		int i=0;		
		int maxRecord=0;

		String classValue="";
		String action_ref_id="";
		String action_reason=""; 		
		String action_remarks="";
		String action_date_time = "";
		String action_type_desc = "";
		String actioned_by = "";

		if(rs != null)
		{
			rs.last();
			maxRecord=rs.getRow();
			rs.beforeFirst();

			if(maxRecord > 0)
			{
		%>
		<tr>
			<th width='15%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
			<th width='25%'><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
			<th width='24%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
			<th width='8%'><fmt:message key="eMP.Reference.label" bundle="${mp_labels}"/></th>
			<th width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>			
			<th width='8%' ><fmt:message key="Common.action.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th> <!-- Thursday, December 24, 2009  17559 (Venkat S) -->
		</tr>
		<%
			while(rs.next())
			{
				 if(i % 2 == 0)
					classValue 		  = "QRYODD" ;
		         else
					classValue 		  = "QRYEVEN" ;

				action_date_time = rs.getString("ACTION_DATE_TIME") == null?"&nbsp;":rs.getString("ACTION_DATE_TIME"); 
				action_type_desc = rs.getString("ACTION_TYPE_DESC") == null?"&nbsp;":rs.getString("ACTION_TYPE_DESC"); 				
				action_ref_id = rs.getString("ACTION_REF_ID") == null?"&nbsp;":rs.getString("ACTION_REF_ID"); 
				action_reason = rs.getString("ACTION_REASON_DESC") == null?"&nbsp;":rs.getString("ACTION_REASON_DESC"); 
				action_remarks = rs.getString("ACTION_REMARKS") == null?"&nbsp;":rs.getString("ACTION_REMARKS");			
				actioned_by = rs.getString("ACTIONED_BY") == null?"&nbsp;":rs.getString("ACTIONED_BY");			

				out.println("<tr>");
				out.println("<td width='15%' class='"+classValue+"'><font size='1'>"+action_date_time+"</td>");
				out.println("<td width='25%' class='"+classValue+"'><font size='1'>"+action_type_desc+"</td>");
				out.println("<td width='24%' class='"+classValue+"'><font size='1'>"+action_reason+"</td>");
				out.println("<td width='8%' class='"+classValue+"'><font size='1'>"+action_ref_id+"</td>");
				out.println("<td width='20%' class='"+classValue+"'><font size='1'>"+action_remarks+"</td>");
				out.println("<td width='8%' class='"+classValue+"' ><font size='1'>"+actioned_by+"</td>");
				
				out.println("</tr>");
			    i++;
			}

			}

		}
		
			if(rs != null) rs.close();
		    if(pstmt != null) pstmt.close();


				
		}
	specstr.setLength(0);
	%>
	</tr>
	</table>
	</a>	
		<!-- added on 1/15/2004 -->
		<input type="hidden" name="from_fac_id" id="from_fac_id" value="">	
		<input type="hidden" name="operation_type" id="operation_type" value="<%=mode%>">
		<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
		<input type="hidden" name="from_hcare_setting_type" id="from_hcare_setting_type" value="">	
		<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>'>
		<input type='hidden' name='ServerDate11' id='ServerDate11' value='<%=sys_date%>'>
		<input type='hidden' name='ServerDatetime' id='ServerDatetime' value='<%=sys_date%>'>
		<input type='hidden' name='function_id' id='function_id' value='REGISTER_PAT_REFERRAL'>		
		<input type='hidden' name='current_year' id='current_year' value='<%=curr_year%>'>
		<input type='hidden' name='facility_name' id='facility_name' value="<%=facilityname%>">	
		<input type='hidden' name='to_hcare_setting_type_code' id='to_hcare_setting_type_code' value="<%=hcaresettingtypecode%>">		
		<input type = 'hidden' name="referral_notes" id="referral_notes" value="<%=ref_notes%>" ></input>
		<input type = 'hidden' name="other_doc_att" id="other_doc_att" value="<%=other_doc_att%>" ></input>
			
		<!-- ***** Hidden variables for clinical details**********-->		

		<input type = 'hidden' name="exm_clinical_find" id="exm_clinical_find" value="<%=exam_and_clin_findings%>"></input>
		<input type = 'hidden' name="diagnosis" id="diagnosis" value="<%=diagnosisTab%>"></input>
		<input type = 'hidden' name="treatment" id="treatment" value="<%=treatmentTab%>"></input>

		<input type='hidden' name='calling_from' id='calling_from' value='<%=calling_from%>'>		
		<input type='hidden' name='practitioner' id='practitioner' value='<%=practitioner%>'>		
		<input type='hidden' name='service_code' id='service_code' value='<%=service_code%>'>		
		<input type='hidden' name='referral_id' id='referral_id' value=''>	
		<input type='hidden' name='pat_id' id='pat_id' value=''>
		<input type='hidden' name='service1' id='service1' value=''>		
		<input type='hidden' name='to_pract1' id='to_pract1' value=''>		
		<input type='hidden' name='referral_source1' id='referral_source1' value=''>	
		<input type='hidden' name='race_code1' id='race_code1' value=''>
		<input type='hidden' name='res_class' id='res_class' value="<%=res_class%>">
		<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>		
		<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>		
		<input type='hidden' name='p_calling_function' id='p_calling_function' value='<%=p_calling_function%>'>	
		<input type='hidden' name='ass_func_id' id='ass_func_id' value='<%=ass_func_id%>'>	
		<input type="hidden" name='reason_for_ref_hid' id='reason_for_ref_hid' value ='<%=referral_reason_desc%>'>
		<input type='hidden' name='citizenvalue' id='citizenvalue' value=''>
		<input type='hidden' name='illegalvalue' id='illegalvalue' value=''>
		<!-- <input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='<%=pat_name_as_multipart_yn%>' > -->
		<input type='hidden' name='birth_place' id='birth_place' value=''>
		<input type='hidden' name='Birth_place_code' id='Birth_place_code' value=''>
		<input type='hidden' name='ethnic_group' id='ethnic_group' value=''>
		<input type='hidden' name='place_of_birth' id='place_of_birth' value=''>
		<input type='hidden' name='race_code' id='race_code' value=''>
		<input type='hidden' name='patient_id' id='patient_id' value=''>
		<input type='hidden' name='patient_name' id='patient_name' value='<%=patient_name%>'>
			<input type='hidden' name='pat_name1' id='pat_name1' value='<%=patient_name%>'>
		<input type='hidden' name='name_prefix1' id='name_prefix1' value=''>
		<input type='hidden' name='first_name' id='first_name' value=''>

		<input type='hidden' name='second_name' id='second_name' value=''>
		<input type='hidden' name='third_name' id='third_name' value=''>
		<input type='hidden' name='family_name' id='family_name' value=''>
		<input type='hidden' name='name_suffix1' id='name_suffix1' value=''>

		<input type='hidden' name='first_name_oth_lang' id='first_name_oth_lang' value=''>
		<input type='hidden' name='second_name_oth_lang' id='second_name_oth_lang' value=''>
		<input type='hidden' name='third_name_oth_lang' id='third_name_oth_lang' value=''>
		<input type='hidden' name='family_name_oth_lang' id='family_name_oth_lang' value=''>
		<input type='hidden' name='name_prefix_oth_lang' id='name_prefix_oth_lang' value=''>
		<input type='hidden' name='name_suffix_oth_lang' id='name_suffix_oth_lang' value=''>
		<input type='hidden' name='patient_name_local_lang' id='patient_name_local_lang' value=''>
		<input type='hidden' name='patient_name_long' id='patient_name_long' value=''>
		<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value=''>

		<input type='hidden' name='sex' id='sex' value=''>
		<input type='hidden' name='date_of_birth' id='date_of_birth' value=''>
		<input type='hidden' name='b_age' id='b_age' value=''>
		<input type='hidden' name='b_months' id='b_months' value=''>
		<input type='hidden' name='b_days' id='b_days' value=''>
		<input type='hidden' name='dob' id='dob' value=''>
		<input type='hidden' name='nationality_code1' id='nationality_code1' value=''>
		<input type='hidden' name='citizen_yn0' id='citizen_yn0' value=''>
		<input type='hidden' name='citizen_yn1' id='citizen_yn1' value=''>
		<input type='hidden' name='legal_yn0' id='legal_yn0' value=''>
		<input type='hidden' name='legal_yn1' id='legal_yn1' value=''>
		<input type='hidden' name='national_id_no' id='national_id_no' value=''>
		<input type='hidden' name='alt_id1_no' id='alt_id1_no' value=''>
		<input type='hidden' name='alt_id2_no' id='alt_id2_no' value=''>
		<input type='hidden' name='alt_id3_no' id='alt_id3_no' value=''>
		<input type='hidden' name='alt_id4_no' id='alt_id4_no' value=''>
		<input type='hidden' name='alt_id1_exp_date' id='alt_id1_exp_date' value=''>
		<input type='hidden' name='alt_id2_exp_date' id='alt_id2_exp_date' value=''>
		<input type='hidden' name='alt_id3_exp_date' id='alt_id3_exp_date' value=''>
		<input type='hidden' name='alt_id4_exp_date' id='alt_id4_exp_date' value=''>
		<input type='hidden' name='other_alt_type' id='other_alt_type' value=''>
		<input type='hidden' name='other_alt_Id' id='other_alt_Id' value=''>
		<input type='hidden' name='addr_line1' id='addr_line1' value=''>
		<input type='hidden' name='addr_line2' id='addr_line2' value=''>
		<input type='hidden' name='addr_line3' id='addr_line3' value=''>
		<input type='hidden' name='addr_line4' id='addr_line4' value=''>
		<input type='hidden' name='res_town_code' id='res_town_code' value=''>
		<input type='hidden' name='res_area_code' id='res_area_code' value=''>
		<input type='hidden' name='postal_code' id='postal_code' value=''>
		<input type='hidden' name='postal_desc' id='postal_desc' value=''>
		<input type='hidden' name='region_code' id='region_code' value=''>
		<input type='hidden' name='country_code' id='country_code' value=''>
		<input type='hidden' name='mail_addr_line1' id='mail_addr_line1' value=''>
		<input type='hidden' name='mail_addr_line2' id='mail_addr_line2' value=''>
		<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value=''>
		<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value=''>
		<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value=''>
		<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value=''>
		<input type='hidden' name='mail_postal_code' id='mail_postal_code' value=''>
		<input type='hidden' name='mail_postal_desc' id='mail_postal_desc' value=''>
		<input type='hidden' name='mail_region_code' id='mail_region_code' value=''>
		<input type='hidden' name='mail_country_code' id='mail_country_code' value=''>
		<input type='hidden' name='contact1_no' id='contact1_no' value=''>
		<input type='hidden' name='contact2_no' id='contact2_no' value=''>
		<input type='hidden' name='email' id='email' value=''>

		<!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start-->
		<input type='hidden' name='alt_addr_line1' id='alt_addr_line1' value="">
		<input type='hidden' name='alt_addr_line2' id='alt_addr_line2' value="">
		<input type='hidden' name='alt_addr_line3' id='alt_addr_line3' value="">
		<input type='hidden' name='alt_addr_line4' id='alt_addr_line4' value="">
		<input type='hidden' name='alt_town_code' id='alt_town_code' value="">
		<input type='hidden' name='alt_town_desc' id='alt_town_desc' value="">
		<input type='hidden' name='alt_area_code' id='alt_area_code' value="">
		<input type='hidden' name='alt_area_desc' id='alt_area_desc' value="">
		<input type='hidden' name='alt_postal_code' id='alt_postal_code' value="">
		<input type='hidden' name='alt_postal_desc' id='alt_postal_desc' value="">
		<input type='hidden' name='alt_region_code' id='alt_region_code' value="">
		<input type='hidden' name='alt_region_desc' id='alt_region_desc' value="">
		<input type='hidden' name='alt_country_code' id='alt_country_code' value="">
		<input type='hidden' name='alt_country_desc' id='alt_country_desc' value="">
		<!--End-->
		
		<input type='hidden' name='rd_operational_yn' id='rd_operational_yn' value='<%=rd_operational_yn%>'>
		<input type='hidden' name='or_operational_yn' id='or_operational_yn' value='<%=or_operational_yn%>'>
		<input type='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value='<%=entitlement_by_pat_cat_yn%>'>
		<input type='hidden' name='p_to_locn_type' id='p_to_locn_type' value='<%=p_to_locn_type%>'>
		<input type='hidden' name='p_to_locn_code' id='p_to_locn_code' value='<%=p_to_locn_code%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='contextURL' id='contextURL' value='<%=contextURL%>'>
		<!--<input type='hidden' name='reloadYN' id='reloadYN' value='N'>-->

		<!--  code added for 20854 -->

		<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value=''>
		<input type='hidden' name='from_locn_hid' id='from_locn_hid' value=''>
		<input type='hidden' name='to_locn_hid' id='to_locn_hid' value=''>
		<!--Below lines Added by afruddin for ML-MMOH-CRF-1527 on 28 jun 2020-->
        <input type='hidden' name='isTransferCase' id='isTransferCase' value='<%=isTransferCase%>'> 
		<input type='hidden' name='from_ref_type' id='from_ref_type' value='<%=from_ref_type%>'> 
		<input type='hidden' name='transfer_case_hidd' id='transfer_case_hidd' value='<%=transfer_case_yn%>'> 
		<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023-->
		<input type='hidden' name='smartCardFunc' id='smartCardFunc' value='<%=smartCardFunc%>'> 
		
		<!--Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 28-jun-2020-->

		<%
         
		
		
		
		 if (calling_from.equals("SEARCH"))     		
		 out.println("<script>document.forms[0].to_speciality_code.value='"+speciality_code+"';if(document.forms[0].to_speciality_code.value != ''){document.forms[0].to_speciality_code.disabled=true;}if(document.forms[0].to_speciality_code.value != ''){ document.forms[0].b_pract1.disabled = false;}else{document.forms[0].b_pract1.disabled = true;} if(document.forms[0].to_service_code.value != ''){document.forms[0].to_service_code.disabled=true;}if(document.getElementById('res_class').value == 'P' && document.forms[0].p_calling_function.value != 'OA_MODIFY_APPT'){document.forms[0].to_practitioner_id.value='"+practitioner_name+"'; document.forms[0].to_practitioner.value='"+practitioner+"';if(document.forms[0].to_practitioner_id.value != ''){document.forms[0].to_practitioner_id.readonly=true;}}</script>");  
         //document.forms[0].to_service_code.value='"+service_code+"';	 
		if(mode.equals("RegisterMoreReferral") || p_calling_function.equals("CHG_REG_DTLS") || !ca_patient_id.equals("") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS"))
		{
			patientid = pat_ID; 
			
		}

		if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
		{	
// Below Variables Newly Added Against Incident : ML-BRU-SCF-1200 [IN:045701] By Saanthaakumar		
		%>
			<script>
					
			var from_pract_name1 = "<%=from_pract_name1%>";
			var from_pract_name = "<%=from_pract_name%>";
			var to_pract_name = "<%=to_pract_name%>";
			
			setTimeout("SecondframesValidation('<%=referred_for_ip%>','<%=referral_priority%>','<%=to_service_code%>','<%=referral_date%>','<%=referral_letter_no%>','<%=received_date%>','<%=preferred_treatment_date%>','<%=from_speciality_code%>','<%=referral_reason_code%>','<%=from_ref_type%>','<%=pract_res_tel_num%>','<%=pract_mobile_num%>','<%=pract_pager_num%>',from_pract_name,'<%=from_locn_desc%>','<%=from_ref_code%>',from_pract_name1,'<%=from_pract_id%>','<%=from_fcy_id%>','<%=from_locn_type%>','<%=mode%>','<%=referral_id%>','<%=patientid%>','<%=from_hcare_setting_type%>',to_pract_name,'<%=to_pract_id%>')",700)
			</script>
		<%	
		}	
		%>

		<script>
		if(parent.frames[1].document.getElementById('p_calling_function') != null)
		{
			if(parent.frames[1].document.getElementById('p_calling_function').value=='IP_ADMIT' || parent.frames[1].document.getElementById('p_calling_function').value=='CHG_ADM_DTLS' )
			{
				parent.frames[1].document.forms[0].referred_for_ip.value='A';
				parent.frames[1].document.forms[0].referred_for_ip.disabled=true;

			}

			if(parent.frames[1].document.getElementById('p_calling_function').value=='IP_BOOKING')
			{
				parent.frames[1].document.forms[0].referred_for_ip.value='B';
				parent.frames[1].document.forms[0].referred_for_ip.disabled=true;

			}
		}
		</script>
		<script>	
			if(parent.frames[0].document.getElementById('patient_id') != null)
			{	
				if(parent.frames[0].document.getElementById('patient_id').disabled==false)
				   parent.frames[0].document.getElementById('patient_id').focus();
			}	
		</script>
		<%	
			if(!mode.equals("RegisterMoreReferral"))
			{	
					if(mode.equals("modify")){
					%>
				<script>
					
					setTimeout("tab_click('rejfrom_tab')",300);
				</script>
				<%}else{
				%>
				<script>
						
					setTimeout("tab_click('reffrom_tab')",300);
				</script>
				<%
					}
			}
			else if(mode.equals("RegisterMoreReferral"))
			{	
				%>
				<script>
					
					setTimeout('enableDisableFrom()',200);
				</script>
				<%
			}
			%>
				<input type="hidden" name="localeth" id="localeth" value="<%=locale%>">
	</form>
</body>
<%
}
catch(Exception e)
{
	out.print("exception in regpatreff"+e.toString());
	e.printStackTrace();
}
finally
{
	try{		
			if(rset!=null)	rset.close();
			if(rs!=null)	rs.close();
			if(mod_rs!=null)	mod_rs.close();
			if(pstmt!=null)	pstmt.close();
			if(pstmt1 != null) pstmt1.close();
	}catch(Exception ee){ee.printStackTrace();}
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
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
public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 		}
	 	}
	 	return function_name;
}
%>

