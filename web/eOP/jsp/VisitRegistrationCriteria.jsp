<!DOCTYPE html>

 <%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,webbeans.op.CurrencyFormat,blopin.*,eBL.*,com.ehis.util.*,eCommon.XSSRequestWrapper" 
 contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<meta http-equiv="Expires" content="0">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../../eMP/js/PatientRegistration.js" language="JavaScript"></Script>
	<Script src="../../eOP/js/VisitRegistrationQuery.js" language="JavaScript"></Script> 
    <Script src="../../eOP/js/VisitRegistration1.js" language="JavaScript"></Script>	
	<Script src="../../eOP/js/VisitRegistration.js" language="JavaScript"></Script>	
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<Script src="../../eCommon/js/FieldFormatMethods.js" language="JavaScript"></Script>
 	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../../eOP/js/OPPractitionerComponent.js' language='javascript'></script>
	<!-- Below line added by Venkatesh.S on 15/Feb/2013 against CHL-SCF-0013 [IN035559] -->
	<script src='../../eMP/js/PatientSearch.js' language='javascript'></script>
	<!-- End CHL-SCF-0013 [IN035559] -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
	String bean_id1		= "PkgAssociateBean" ;
	String bean_name1	= "eBL.PkgAssociateBean";
	PkgAssociateBean bean1			= (PkgAssociateBean)getBeanObject( bean_id1, bean_name1, request ) ;
	String bean_id2		= "PkgSubsBean" ;
	String bean_name2= "eBL.PkgSubsBean";
	PkgSubsBean bean2			= (PkgSubsBean)getBeanObject( bean_id2, bean_name2, request ) ;

	String bean_id3		= "PkgEnterReceptRefundBean" ;
	String bean_name3= "eBL.PkgEnterReceptRefundBean";
	PkgEnterReceptRefundBean bean3	= (PkgEnterReceptRefundBean)getBeanObject( bean_id3, bean_name3, request ) ; 
	
	String bean_id4		= "PkgDiscountBean" ;
	String bean_name4	= "eBL.PkgDiscountBean";
	PkgDiscountBean bean4			= (PkgDiscountBean)PersistenceHelper.getBeanObject( bean_id4, bean_name4, request) ;			

	bean.clearBean();
	bean1.clearBean();
	bean2.clearBean();
	bean3.clearBean();
	bean4.clearBean();
	
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
	putObjectInBean(bean_id2,bean2,request);
	putObjectInBean(bean_id3,bean3,request);
	putObjectInBean(bean_id4,bean4,request);
	
	Connection con = null;
    PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
   	String facilityid = checkForNull((String) session.getValue("facility_id"));	
	String locale = checkForNull((String)session.getAttribute("LOCALE"));
	String login_user = checkForNull((String)session.getAttribute("login_user"));//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	String entitlement_by_cat_yn="";
	String First_Name_Accept_Yn ="";
	String First_Name_Prompt ="";
	String Second_Name_Accept_Yn ="";
	String Second_Name_Prompt ="";
	String Third_Name_Accept_Yn ="";
	String Third_Name_Prompt ="";
	String Family_Name_Accept_Yn ="";
	String Family_Name_Prompt ="";
	String Name_Suffix_Accept_Yn ="";
	String query_string=request.getParameter("query_string")==null?"":request.getParameter("query_string");	
	
	String patient=request.getParameter("patient")==null?"":request.getParameter("patient");
	String referral_id =request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
	String register_visit_walkin=request.getParameter("register_visit_walkin")==null?"":request.getParameter("register_visit_walkin");
	String register_visit_referral=request.getParameter("register_visit_referral")==null?"":request.getParameter("register_visit_referral");
	String Name_Suffix_Prompt ="";
	String Name_Prefix_Accept_Yn = "";
	String register_visit_yn=request.getParameter("register_visit_yn")==null?"":request.getParameter("register_visit_yn");
	String Name_Prefix_Prompt = "";
	String First_Name_Reqd_Yn ="";
	String Second_Name_Reqd_Yn ="";
	String Third_Name_Reqd_Yn ="";
	String Family_Name_Reqd_Yn ="";
	String Name_Suffix_Reqd_Yn ="";
	String Name_Prefix_Reqd_Yn ="";		
	String pat_name_as_multipart_yn="";
    String register_pat_yn="N";
	String names_in_oth_lang_yn="";
	String build_episode_rule 
   	=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
    String emer_regn_allow_yn=(request.getParameter("emer_regn_allow_yn") == null)?"N":request.getParameter("emer_regn_allow_yn");
	String visit_for_inpat_yn=(request.getParameter("visit_for_inpat_yn") == null)?"N":request.getParameter("visit_for_inpat_yn");
	
	//Added for this incident 52619
	String locn_code=(request.getParameter("locn_code") == null)?"":request.getParameter("locn_code");
	String practitioner_id=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");
	String bl_interface_yn=request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");
	String functionId=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
	
	String wait_list_inv=(request.getParameter("wait_list_inv") == null)?"":request.getParameter("wait_list_inv");
	String oa_install_yn=(request.getParameter("oa_install_yn") == null)?"":request.getParameter("oa_install_yn");
   
	String or_install_yn=(request.getParameter("or_install_yn") == null)?"":request.getParameter("or_install_yn");
	
	String oper_stn_id=(request.getParameter("oper_stn_id") == null)?"":request.getParameter("oper_stn_id");
	register_pat_yn=(request.getParameter("register_pat_yn") == null)?"":request.getParameter("register_pat_yn");

	String tabName=request.getParameter("objName")==null?"":request.getParameter("objName");
	
	
	String accept_dis_inv_no=(request.getParameter("accept_dis_inv_no") == null)?"":request.getParameter("accept_dis_inv_no");
	
	String appt_refno_flag=(request.getParameter("q_appt_ref_no") == null)?"":request.getParameter("q_appt_ref_no"); //modified this line incident[52415] 
	
	String appt_service_code=(request.getParameter("service_code") == null)?"":request.getParameter("service_code"); //modified this line incident[52513] 
	
	String invitation_no=(request.getParameter("invitation_no") == null)?"":request.getParameter("invitation_no"); //modified this line incident[52619]
	
	String facility_id=(request.getParameter("facility_id") == null)?"":request.getParameter("facility_id"); //modified this line incident[52619] 
	
	String episode=(request.getParameter("episode") == null)?"":request.getParameter("episode"); //added this line incident[52854] 
	String record=(request.getParameter("record") == null)?"":request.getParameter("record"); //added this line incident[52854] 
	//String oper_stn_id=(request.getParameter("oper_stn_id") == null)?"":request.getParameter("oper_stn_id"); //added this line incident[52854] 
	
	String currentdate="";
	String currentdate_display="";
	String res_area_prompt = "";
	String res_town_prompt = "";
	String region_prompt = "";
	String loctype = "";
	String loctypedesc = ""; 
	String alt_id1_desc = "";
	String alt_id2_desc = "";
	String alt_id3_desc = "";
	String alt_id4_desc = "";
	String upt_contact_dtls_oa_yn="";//added changes for HSA-CRF-0226 [IN:050599]
	int pat_id_len = 0; 
    int First_Name_Order=0;
	int Second_Name_Order =0;
	int Third_Name_Order =0;
	int Family_Name_Order =0;
 	String sql="";
	String customer_id="";
	boolean isSiteSpe_change_pat_dtls=false;// added by munisekhar for MMS-QH-CRF-0162
	boolean isVirtualConsultationVisit=false;// added by Lakhsmanan for ML-MMOH-CRF-1930 US007
	boolean isPractoApptApplYN=false;//Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446]

	String  family_name_length	= "";
	String 	fam_name_ind		= "N";/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
try
{
	con = ConnectionManager.getConnection(request);
	 isPractoApptApplYN= CommonBean.isSiteSpecific(con,"OP","OP_AUTO_APPLY_PRACTO_APPT");//Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446]
	 isVirtualConsultationVisit=CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION"); // added by Lakshmanan for ML-MMOH-CRF-1930 US007
	//sql ="Select to_char(sysdate,'dd/mm/yyyy') sysdt, patient_id_length, First_Name_Accept_Yn, First_Name_Order, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn, nat_id_length,pat_name_as_multipart_yn, entitlement_by_pat_cat_yn, names_in_oth_lang_yn from mp_param";
	
	 sql ="Select to_char(sysdate,'dd/mm/yyyy') sysdt, patient_id_length, First_Name_Accept_Yn, First_Name_Order,ENTITLEMENT_BY_PAT_CAT_YN, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn, nat_id_length,pat_name_as_multipart_yn, names_in_oth_lang_yn,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,upt_contact_dtls_oa_yn, NVL(family_name_length,0) family_name_length from mp_param  ";

	 pstmt = con.prepareStatement(sql);
     rs = pstmt.executeQuery();

	 if (rs != null && rs.next() )
     {
		 alt_id1_desc = rs.getString("alt_id1_desc")==null?"":rs.getString("alt_id1_desc");
		 alt_id2_desc = rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
		 alt_id3_desc = rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
		 alt_id4_desc = rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
		 
		 upt_contact_dtls_oa_yn = rs.getString("upt_contact_dtls_oa_yn");//added changes for HSA-CRF-0226 [IN:050599]
		 /*Below line was added by venkatesh.S (4008) on 10-Oct-2012 aginst  ML-BRU-SCF-0336 [IN:034501]*/
		 // customer_id = rs.getString("customer_id")==null?"":rs.getString("customer_id");
		 /*end SCF ML-BRU-SCF-0336 [IN:034501] */
		 
		 names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null?"N":rs.getString("names_in_oth_lang_yn"); 	
		 pat_id_len = rs.getInt("patient_id_length") ;
		 
		 entitlement_by_cat_yn = rs.getString("ENTITLEMENT_BY_PAT_CAT_YN")==null?"N":rs.getString("ENTITLEMENT_BY_PAT_CAT_YN"); 	
		 
	 }

	if(wait_list_inv.equals("N"))
	{         
			First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null?"":rs.getString("First_Name_Accept_Yn");
			First_Name_Order = rs.getInt("First_Name_Order");
			First_Name_Prompt = rs.getString("First_Name_Prompt")==null?"":rs.getString("First_Name_Prompt");
			Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null?"":rs.getString("Second_Name_Accept_Yn");
			Second_Name_Order = rs.getInt("Second_Name_Order");
			Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null?"":rs.getString("Second_Name_Prompt");
			Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null?"":rs.getString("Third_Name_Accept_Yn");
			Third_Name_Order = rs.getInt("Third_Name_Order");
			Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null?"":rs.getString("Third_Name_Prompt");
			Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null?"":rs.getString("Family_Name_Accept_Yn");
			Family_Name_Order = rs.getInt("Family_Name_Order");
			Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null?"":rs.getString("Family_Name_Prompt");
			Name_Suffix_Accept_Yn = rs.getString("name_suffix_accept_yn")==null?"":rs.getString("name_suffix_accept_yn");
			Name_Prefix_Accept_Yn = rs.getString("name_prefix_accept_yn")==null?"":rs.getString("name_prefix_accept_yn");
			Name_Suffix_Prompt = rs.getString("name_suffix_prompt")==null?"":rs.getString("name_suffix_prompt");
			Name_Prefix_Prompt = rs.getString("name_prefix_prompt")==null?"":rs.getString("name_prefix_prompt");
			First_Name_Reqd_Yn = rs.getString("first_name_reqd_yn")==null?"":rs.getString("first_name_reqd_yn");
			Second_Name_Reqd_Yn = rs.getString("second_name_reqd_yn")==null?"":rs.getString("second_name_reqd_yn");
			Third_Name_Reqd_Yn = rs.getString("third_name_reqd_yn")==null?"":rs.getString("third_name_reqd_yn");
			Family_Name_Reqd_Yn = rs.getString("family_name_reqd_yn")==null?"":rs.getString("family_name_reqd_yn");
			Name_Suffix_Reqd_Yn = rs.getString("name_suffix_reqd_yn")==null?"":rs.getString("name_suffix_reqd_yn");
			Name_Prefix_Reqd_Yn = rs.getString("name_prefix_reqd_yn")==null?"":rs.getString("name_prefix_reqd_yn");
			pat_name_as_multipart_yn=rs.getString("pat_name_as_multipart_yn")==null?"":rs.getString("pat_name_as_multipart_yn");
		    currentdate=checkForNull(rs.getString("sysdt")); 

		    /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
		    if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") &&Family_Name_Accept_Yn.equals("Y")){
		   family_name_length=rs.getString("family_name_length")==null?"":rs.getString("family_name_length");
			fam_name_ind ="Y";	
		   	}						 
        
	}

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
		
	if(wait_list_inv.equals("Y"))
	{
		String prompt_sql = "select to_char(sysdate,'dd/mm/yyyy') sysdt, initcap(res_area_prompt)res_area_prompt, initcap(res_town_prompt)res_town_prompt, postal_code_prompt, initcap(region_prompt)region_prompt from sm_site_param_lang_vw where language_id='"+locale+"'";	
		
		stmt=con.createStatement();
		ResultSet rs1 = stmt.executeQuery(prompt_sql) ;

		while(rs1.next())
		{
			res_area_prompt=rs1.getString("res_area_prompt")==null?"":rs1.getString("res_area_prompt");
			res_town_prompt=rs1.getString("res_town_prompt")==null?"":rs1.getString("res_town_prompt");
			region_prompt=rs1.getString("region_prompt")==null?"":rs1.getString("region_prompt");
		    currentdate=checkForNull(rs1.getString("sysdt")); 		
		}
        if(rs1!=null) rs1.close();	 	
     }
		currentdate_display = DateUtils.convertDate(currentdate,"DMY","en",locale);
		
	
	//end  RUT-CRF-0060 [IN029598]
	%>	
             
  </head>    
<body onLoad='disableData();focusElement()' onMouseDown="CodeArrest();" onKeyDown ='lockKey()' onSelect="codeArrestThruSelect();" class='content' topmargin='0' bottommargin='0' >
<form name='visit_registration' id='visit_registration' method='post' action='' target="messageFrame">    
		  
<table width='100%' cellspacing=0 cellpadding='1' border=0>
<!-- ******************** -->
<tr >
<td colspan=7>	
	<%
		//Added jsp:param name ="fun_id" tag by Ashwin K for AAKH-CRF-0150 
		if(!wait_list_inv.equals("")) {
		%>
			<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="patient_id"   value= "" />
			<jsp:param name ="alert_reqd_yn"   value= ""  /> 
			<jsp:param name ="nat_id_disabled"  value = "<%=register_pat_yn%>" />	 
			<jsp:param name ="tab_name"  value = "<%=tabName%>" />	
	
			</jsp:include>
		<%
		} else {
		%>
			<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="patient_id"   value= "" />
			<jsp:param name ="alert_reqd_yn"   value= ""  /> 
			<jsp:param name ="nat_id_disabled"  value = "<%=register_pat_yn%>" /> 
			<jsp:param name ="validateIdYN"  value = "N" /> 
			<jsp:param name ="tab_name"  value = "<%=tabName%>" />
	
			</jsp:include>		
		<%
		}
	%>	
</td>
</tr>


<tr>
	<td class='label'  width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='text' name='pat_id1' id='pat_id1' value='<%=patient%>' maxlength='<%=pat_id_len%>' size='25'    onBlur="setValue('patient',this);" onChange="ChangeUpperCase(this);if(document.getElementById('srch_code')!=null)document.getElementById('srch_code').click();" onkeypress="readyToBlur(event);"><input type='button' class='button' value='?' name='srch' id='srch' onClick="getPatID()"> 
	    <%// added by munisekhar for MMS-QH-CRF-0162
				 isSiteSpe_change_pat_dtls= CommonBean.isSiteSpecific(con,"OP","INVOKE_CHANGE_PATIENT_DETIALS");
				 int userFunRightsCount		= 0;//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
				if(isSiteSpe_change_pat_dtls)
				{
					userFunRightsCount	= CommonBean.getUserFunRightsCount(con,login_user,"CHG_PAT_DTLS","MP");//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
					if(userFunRightsCount > 0) {
					%> <!--Below line modified for this CRF MMS-QH-CRF-0162.1-->
						 <img  align='center'  style="visibility:hidden"  id="Update_pat" Title="Change Patient Details" src='../../eCommon/images/update.jpg' 
					  onClick="getPatientDetails(document.forms[0].pat_id1.value);image_click1('search','<%=oa_install_yn%>',pat_id1.value,referal_id1.value)" />
				  <%}
                }%>
				<input type='hidden' name='isSiteSpe_change_pat_dtls' id='isSiteSpe_change_pat_dtls' value="<%=isSiteSpe_change_pat_dtls%>"> 
				<input type='hidden' name='userFunRightsCount' id='userFunRightsCount' value="<%=userFunRightsCount%>"> <!--Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]-->
				<input type='hidden' name='appt_refno_flag' id='appt_refno_flag' value="<%=appt_refno_flag%>"> <!--this line added for this incident[52415] -->
				<input type='hidden' name='blflag_op_yn' id='blflag_op_yn' value=""> <!--this line added for this incident[52415] -->
				<input type='hidden' name='appt_service_code' id='appt_service_code' value="<%=appt_service_code%>"> <!--Added this line incident[52513] -->
				<input type='hidden' name='invitation_no' id='invitation_no' value="<%=invitation_no%>"> <!--Added this line incident[52619] -->
				<input type='hidden' name='inviate_facility_id' id='inviate_facility_id' value="<%=facility_id%>"> <!--Added this line incident[52619] -->
				<input type='hidden' name='locn_code' id='locn_code' value="<%=locn_code%>"> <!--Added this line incident[52619] -->
				<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>"> <!--Added this line incident[52619] -->
				
				<input type='hidden' name='episode' id='episode' value="<%=episode%>"> <!--Added this line incident[52854] -->
				<input type='hidden' name='record' id='record' value="<%=record%>"> <!--Added this line incident[52854] -->
				
	</td>



	<%
		if(wait_list_inv.equals("Y"))
       {%>
                 <td class='label' width='25%'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
     <%}
    else
	   if(wait_list_inv.equals("N"))
        {%>
                 <td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
      <%}
	    else
           {%>
                 <td class='label' width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
         <%}%>

    <%
		
	if(wait_list_inv.equals("Y"))
       {%>
		<td class='fields' ><input type=text name='nationality_desc' id='nationality_desc'  size='25' maxlength='20' value='' onblur='if(this.value !="")searchCountry(nationality_id,nationality_desc);'><input type='button' name='nat_id' id='nat_id' value='?' class='button' onclick='searchCountry(this,nationality_desc)'></td>
		<td ></td><td></td>
		<INPUT TYPE="hidden"  name='nationality_id' id='nationality_id'>
     <%}
      else if(wait_list_inv.equals("N"))
	     { %>
	     <td class='fields' width='25%'><select name='gender' id='gender'><option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/>
		    <option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
		    <option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
		    <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
            </select>   
	     </td><td></td>
      </tr> 
	  <tr>  
	   <td class='label'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
        <td  class='fields' width='25%'>
			<INPUT TYPE="text" name="nationality_iddesc" id="nationality_iddesc"   onblur='selectNationality1(nationality_iddesc,nationality_id);return makeValidString(this);'  value='' size='25'><input type=button class=button value='?' name='nat1' id='nat1' onClick='selectNationality(nationality_iddesc,nationality_id);' >
			<INPUT TYPE="hidden"  name='nationality_id' id='nationality_id'>
	   </td>
	  <%if(names_in_oth_lang_yn.equals("Y")) { %>
			<td class='label' ><fmt:message key="eMP.SearchNameWithLocalLang.label" bundle="${mp_labels}"/></td>
	   <td  class='fields' >
			<input type='checkbox' name='local_lang' id='local_lang' value='Y' onClick="localLang(this);" checked>
			
	   </td>
   <%}else {%>
	
	  <td  class='fields' >
						
	   </td>
	  <%}%> 
	   </tr>
</table>
<table width='100%' cellspacing=0 cellpadding='1' border=0>
<tr>
   
			
			<%
     if ( Name_Prefix_Accept_Yn.equals("Y") )
      {%>
         <td class='label' width='25%'><%=Name_Prefix_Prompt%></td>
      <%}
	  
	if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) 
	{%>
	 <td class='label' ><%=First_Name_Prompt%></td>
	<%}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ){%>
			<td class='label' ><%=Second_Name_Prompt%></td>
	<%}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ){%>
			<td class='label' ><%=Third_Name_Prompt%></td>
	<%}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ){%>
		   <td class='label' ><%=Family_Name_Prompt%></td>
	<%}
	  
	if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) 
	{%> 
		<td class='label'><%=First_Name_Prompt%></td>
	<%}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {%>
		<td class='label'><%=Second_Name_Prompt%></td><%
	}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {%>
		<td class='label'><%=Third_Name_Prompt%></td>
	<%}else  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ){%>
		<td class='label'><%=Family_Name_Prompt%></td><%}

	 
	 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {%>
        <td class='label'><%=First_Name_Prompt%></td>
     <%}else 
	 if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {%>
        <td class='label'><%=Second_Name_Prompt%></td>
    <%}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {%>
        <td class='label'><%=Third_Name_Prompt%></td>
     <%}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {%>
        <td class='label' ><%=Family_Name_Prompt%></td>
     <%}
	 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {%>
        <td class='label' ><%=First_Name_Prompt%></td>
     <%}else  if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {%>
         <td class='label'><%=Second_Name_Prompt%></td><%}
      else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {%>
         <td class='label'><%=Third_Name_Prompt%></td>
      <%} else
	  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4  && Family_Name_Prompt!=null  ) {%>
          <td class='label'><%=Family_Name_Prompt%></td>
     
	  
	  <%}if ( Name_Suffix_Accept_Yn.equals("Y") && Name_Suffix_Prompt!=null){%>
           <td class='label'><%=Name_Suffix_Prompt%></td>
    <%}%>
</tr>
<tr>
<%if (Name_Prefix_Accept_Yn.equals("Y") )
{
    if(pat_name_as_multipart_yn.equals("N"))  {%>
       <td class='label' width='25%'><Select name='name_prefix' id='name_prefix' >
     <%}
	   else{%>
            <td class='fields'><Select name='name_prefix' id='name_prefix' >
         <%}%>
            <Option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
       
	   <%
		
	  
	  sql="Select decode('"+locale+"', 'en', Name_Prefix, name_prefix_loc_lang) Name_Prefix from Mp_Name_Prefix where eff_status='E' order by 1";
	
		
		pstmt=con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs != null)
		{
          while( rs.next() ) {%>
            <Option value="<%=checkForNull(rs.getString("Name_Prefix"))%>" ><%=checkForNull(rs.getString("Name_Prefix"))%></option>
          <%}
		 }

		 if(rs!=null) rs.close();
		 if(pstmt!=null) pstmt.close();
  %>
    </Select>
    <%
	if (Name_Prefix_Reqd_Yn.equals("Y")  ){%>
		 <input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>
	<%}else{%>
		 <input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>
	<%}%>
	</td>
<%}

  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
   {%>
		<td class='fields' ><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  tabIndex='15'>
		<%if (First_Name_Reqd_Yn.equals("Y")  ){%>
		<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>
		<%}else{%>
		<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>
		<%}%>
		</td>
 <% } else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
       {%>
			<td class='fields' ><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  tabIndex='15'>
			<%
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{%>
			    <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>
			<%}
			else
			{%>
			    <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>
			<%}%>
			</td>
     <%}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
{%>
		<td class='fields' ><input type='text' name='third_name' id='third_name' maxlength='15' size='15'  tabIndex='15'>
		<%if (Third_Name_Reqd_Yn.equals("Y")  )
		{%>
		    <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>
		<%}else{%>
		    <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>
		<%}%>
		</td>
<%}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
{/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/
  if(fam_name_ind.equals("Y")){ %>

  	<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='<%=family_name_length%>' size="<%=family_name_length%>" >
  	
 <% }else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
  if(pat_name_as_multipart_yn.equals("N"))
   {%>
      <td class='fields'><input type='text' name='family_name' id='family_name' maxlength='40' size='40'  >
 <%}else{%>
     <td class='fields'><input type='text' name='family_name' id='family_name' maxlength='15' size='15'  >
 <%}
 }if ( Family_Name_Reqd_Yn.equals("Y") ){%>
     <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>
 <%}else{%>
     <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>
 <%}out.println("</td>");}
 
  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ){%>
     <td class='fields'><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  tabIndex='16'>		
  <%if (First_Name_Reqd_Yn.equals("Y")  ){%>
     <input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>
  <%}else{%>
   <input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>
<%}%>
</td>
<%}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ){%>
   <td class='fields'><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  tabIndex='16'>
<%
if (Second_Name_Reqd_Yn.equals("Y")  )
{%>
  <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>
<%}else{%>
  <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>
<%}%>
</td>
<%}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
{%>
    <td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='16'>
<%if (Third_Name_Reqd_Yn.equals("Y")  ){%>
    <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>
<%}else{%>
    <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>
<%}%>
</td>
<%}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
{
if(fam_name_ind.equals("Y")){ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/ %>

  	<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='<%=family_name_length%>' size="<%=family_name_length%>" >
  	
 <% }else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
	 if(pat_name_as_multipart_yn.equals("N")){%>
	   <td class='fields'><input type='text' name='family_name' id='family_name' maxlength='40' size='40' >
	<%}else{%>
		  <td class='fields'><input type='text' name='family_name' id='family_name' maxlength='15' size='15' >
	<%}
	}
	if (Family_Name_Reqd_Yn.equals("Y")  ){%>
	   <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>
	<%}else{%>
		<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>
	<%}%>
  </td>
<%
}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
 {%>
	<td class='fields'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' tabIndex='17'>
 <%if (First_Name_Reqd_Yn.equals("Y")  ){%>
        <input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>
   <%}else{%>
        <input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>
   <%}%>
</td>
<%}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
{%>

  <td class='fields'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' tabIndex='17'>
 <%if (Second_Name_Reqd_Yn.equals("Y")  )
    {%>
       <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>
   <%}else{%>
       <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>
   <%}%>
    </td>
   <%} else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
   {%>
      <td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='17'>
   <%if (Third_Name_Reqd_Yn.equals("Y")  )
      {%>
       <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>
    <%}else{%>
       <input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>
    <%}%>
</td>
<%
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
{	
	if(fam_name_ind.equals("Y")){ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/ %>

  	<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='<%=family_name_length%>' size='<%=family_name_length%>'  >
  <%}else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
	if(pat_name_as_multipart_yn.equals("N")){%>
    <td class='fields'><input type='text' name='family_name' id='family_name' maxlength='40' size='40' >
    <%}else{%>
    <td class='fields'><input type='text' name='family_name' id='family_name' maxlength='15' size='15' >
    <%} }
    if (Family_Name_Reqd_Yn.equals("Y")  ){%>
    <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>
    <%}
    else
   {%>
    <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>
   <%}%>
</td>
<%
}
if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
{%>
	<td class='fields'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' tabIndex='18'>
	<%if (First_Name_Reqd_Yn.equals("Y")  )
	{%>
		<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>
	<%}else{
	%>
		<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>
	<%}%>
	</td>
<%}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ){%>
     <td class='fields'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' tabIndex='18'>
<%
if (Second_Name_Reqd_Yn.equals("Y")  ){
%>
     <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>
<%}else{
%>
     <input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>
<%}%>
</td>
<%}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
{%>
	<td class='fields'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='18'>
	<%

	if (Third_Name_Reqd_Yn.equals("Y")  )
	{%>
		<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>
	<%
	}else
	{%>
		<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>
	<%}%>
	</td>
<%}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
{
if(fam_name_ind.equals("Y")){ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/ %>

  	<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='<%=family_name_length%>' size='<%=family_name_length%>'  >
  <%}else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
if(pat_name_as_multipart_yn.equals("N"))
{%>
	<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='40' size='40'  >
	<%}else{%>
	<td class='fields'><input type='text' name='family_name' id='family_name' maxlength='15' size='15' >
<%} }
if (Family_Name_Reqd_Yn.equals("Y")  )
{%>
     <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>
<%}else
{%>
     <input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>
<%}%>
</td>
<%}if ( Name_Suffix_Accept_Yn.equals("Y") )
{%>
   <td class='fields'><Select name='name_suffix' id='name_suffix' tabIndex='19'>
	<Option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option>
	<%
	
	sql="Select decode('"+locale+"', 'en', Name_Suffix, Name_Suffix_loc_lang) Name_Suffix from Mp_Name_Suffix where eff_status='E' order by 1";

	pstmt=con.prepareStatement(sql);
	rs = pstmt.executeQuery();
    if(rs != null ) 
	 {
       while(rs.next()) { %>
       <Option value='<%=checkForNull(rs.getString("name_suffix"))%>' ><%=checkForNull(rs.getString("Name_Suffix"))%></option>
    <%}
	}

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

   if (Name_Suffix_Reqd_Yn.equals("Y")  )
   { %>
	</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'></input>
   <%}else{%>
	</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'></input>
  <%}%>
</td>
<%}%>
</tr>
</table>
</td>
</tr>
</table>
<table width='100%' align='center'  cellpadding="1" cellspacing="0" border=0>
  <tr>
	<td class='label' width='24%'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'>
	
	<!--below lines modified by Suresh.M on 28-Nov-2012 againist RUT-SCF-0160 [IN:033589] and  RUT-CRF-0060 [IN029598]  -->
<input type='text' name='appt_ref_no' id='appt_ref_no' size='15' maxlength='8' onkeypress="readyToBlur(event);">  
 <!--RUT-SCF-0160 [IN:033589] and RUT-CRF-0060 [IN029598] -->



	<td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
    <td class='fields' ><input type="text" name="pract_name" id="pract_name" maxlength="30" size="25" onBlur="onBlurCallPractitionerSearch(document.forms[0].pract_butt,pract_name)"  ><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" onClick="callPractSearch(this,pract_name);" >
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="">	
    </td>
	</td>
	</tr>
	<tr>
	
	<td class='label' width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><select name="locn_type" id="locn_type" onchange='clearList();'><option value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
							<%

							try{
								
								String sql_locn = "select locn_type,short_desc from am_care_locn_type_lang_vw where ";

								if(functionId.equals("VISIT_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind in ('C','E') and locn_type in ('C','E') and ";
								}
								else if(functionId.equals("PROCD_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind ='E' and locn_type = 'E' and ";
								}
								
								sql_locn = sql_locn + " SYS_USER_DEF_IND='S' and language_id='"+localeName+"' order by short_desc ";

								pstmt=con.prepareStatement(sql_locn);
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										loctype=checkForNull(rs.getString("locn_type"));
										loctypedesc=checkForNull(rs.getString("short_desc"));					
										%>
											<option value="<%=loctype%>" ><%=loctypedesc%>
										<%
									}
								}
								
							if(rs != null ) rs.close();
							if(pstmt != null ) pstmt.close();							

							}catch(Exception e)
							{
								e.printStackTrace();
							}

				%>
				
			</select>
		</td>

	<td class='label' width='25%'>
	<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'><INPUT TYPE="text" name="clinic_desc" id="clinic_desc"   onblur='selectClinic1(clinic_desc,clinic_code);return makeValidString(this);'  value='' size='25'><input type=button class=button value='?' name='clinic1' id='clinic1' onClick='selectClinic(clinic_desc,clinic_code);' >
	<INPUT TYPE="hidden"  name='clinic_code' id='clinic_code'>
	</td>
	
	</tr>
	<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->
	<%if(isPractoApptApplYN){%>
	<tr>
	<td class='label' width='25%'><fmt:message key="eOA.ExternalAppointmentsOnly.label" bundle="${oa_labels}"/></td>
	<td class='fields' width='25%'><input type='checkbox' name='extApptOnly' id='extApptOnly' value='Y'></td>

	<td class='label'colspan="2">&nbsp;</td>
	
	</tr>
	<%}%>
	<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->
	<%if (isVirtualConsultationVisit) { // Added by lakshmanan on 17mar2023 for ML-MMOH-CRF-1930 US007 start %>
	<tr>
	<td class='label' width='25%'><fmt:message key="Common.virtualConsultation.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Visit.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='checkbox' name='virtualConsultVisit' id='virtualConsultVisit' value='N' ></td>
	<td class='label'colspan="2">&nbsp;</td>
	</tr>
	<% } // Added by lakshmanan on 17mar2023 for ML-MMOH-CRF-1930 US007 end  %>
	<tr>
	
	<td colspan=4 align='right'><input type=button class=button value='<fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/>' name='bookingappointment' onclick="appointment(false,'','','','','','','','','','');"> <input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'   onClick="image_clickappt('search')"   class="Button">             
    <input type="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'      onClick="clear_all()" class="Button"></td>
   </tr>
<%
}else{%>
	<td  class='Fields' >
	<input type='text' name='referal_id1' id='referal_id1' value='<%=referral_id%>' maxlength='20' size='25' onblur="setValue('referral',this);"   onChange= "setValue('referral',this);if(document.getElementById('srch_code')!=null)document.getElementById('srch_code').click()"><input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()'></td>
     <%} 
	if(wait_list_inv.equals("")){%>
	</tr>
	<tr>
	 <td align='right' colspan=4> <input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="image_click1('search','<%=oa_install_yn%>',pat_id1.value,referal_id1.value)"  name='srch_code' id='srch_code'>&nbsp;<input type='button' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearData()' name='clear1'></td>
	<td   align='center' id='button_item1'></td>
<!-- <td width='20%'></td> -->
<%}%>
</tr>
<%if(wait_list_inv.equals("Y")){%>
	<tr>
	 <td class=label ><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
	 <td class='Fields' ><input type=text name='r_town_code' id='r_town_code' size='25'  maxlength='30' onchange="if(this.value != '')searchCommonCode(town_code,r_town_code,'<%=res_town_prompt%>')"><INPUT TYPE='button' class='button' name='town_code' id='town_code' value='?' onclick='searchCommonCode(this,r_town_code,"<%=res_town_prompt%>")' tabindex='$'>
	 </td>
	<td class=label ><fmt:message key="Common.area.label" bundle="${common_labels}"/> </td>
	<td class=Fields align=left>	
	<input type='text' name='r_area_code' id='r_area_code' size='25'  onchange= "if(this.value != '')searchCommonCode(area_code,r_area_code,'<%=res_area_prompt%>')"><input type='button' name='area_code' id='area_code' value='?' class='button' onclick="searchCommonCode(this,r_area_code,'<%=res_area_prompt%>')"></td></tr><tr><td class=label  ><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td><td class=fields colspan=4><input type=text name='r_region_code' id='r_region_code'  size='25'   onchange= "if(this.value != '')searchCommonCode(region_code,r_region_code,'<%=region_prompt%>')"><input type='button' name='region_code' id='region_code' value='?' class='button' onclick="searchCommonCode(this,r_region_code,'<%=region_prompt%>')" ></td></tr>
	<tr>
    <td  class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td><td>
	<%
	String sql5 = " Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
	rs = stmt.executeQuery(sql5);
	%>
	<select name="speciality" id="speciality" tabindex=1 > 
	<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
	<%
	while(rs.next()){
		out.println("<option value='" + checkForNull(rs.getString("Speciality_Code")) + "' >" + checkForNull(rs.getString("Short_Desc"))+"</option>");
	}
	%>
	</select>
	</td>
	<%if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();  
	
%>
	<td class='label'   ><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td><td class='fields'>
	<input type=text name='category_desc_txt' id='category_desc_txt' size='25' onblur="clear_vals()" ><input type='button' class='button' value='?'  name='search_or' id='search_or' onClick="callCataegorySearch();"   tabindex=0>
	<input type="hidden" name="category_code" id="category_code">	
	</td> 
	<td ></td>
	</tr>
	
	<tr><td class='label'  ><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></td><td><input type=text name='WaitListNo' id='WaitListNo' size='27' maxlength='12' value='' tabindex=4></td>
	<td class='label'   ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td><td  class='Fields' ><select name='priority' id='priority'>
	<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
	<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
	<option value='S'><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/> &nbsp</option>
	<option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/> &nbsp</option>
	</select>
	</td>
	</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><select name="locn_type" id="locn_type" onchange='clearList();'><option value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
							<%

							try{
								
								String sql_locn = "select locn_type,short_desc from am_care_locn_type_lang_vw where ";

								if(functionId.equals("VISIT_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind in ('C','E') and locn_type in ('C','E') and ";
								}
								else if(functionId.equals("PROCD_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind ='E' and locn_type = 'E' and ";
								}
								
								sql_locn = sql_locn + " SYS_USER_DEF_IND='S' and language_id='"+localeName+"' order by short_desc ";

								pstmt=con.prepareStatement(sql_locn);
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										loctype=checkForNull(rs.getString("locn_type"));
										loctypedesc=checkForNull(rs.getString("short_desc"));					
										%>
											<option value="<%=loctype%>" ><%=loctypedesc%>
										<%
									}
								}
								
							if(rs != null ) rs.close();
							if(pstmt != null ) pstmt.close();							

							}catch(Exception e)
							{
								e.printStackTrace();
							}

				%>
				
			</select>
		</td>

	<td class='label' width='25%'>
	<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'><INPUT TYPE="text" name="clinic_desc" id="clinic_desc"   onblur='selectClinic1(clinic_desc,clinic_code);return makeValidString(this);'  value='' size='25'><input type=button class=button value='?' name='clinic1' id='clinic1' onClick='selectClinic(clinic_desc,clinic_code);' >
	<INPUT TYPE="hidden"  name='clinic_code' id='clinic_code'>
	</td>
	</tr>
	

<tr>
	<td class='label'  ><fmt:message key="eOP.InvitationPeriod.label" bundle="${op_labels}"/></td><td class='Fields'><input type='text' name='frmDate'  id='appt_from_dt' value='<%=currentdate_display%>' size='8' maxlength='10' onBlur="validDateObj(this,'DMY',localeName);"><img id='img1' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_from_dt');" style="cursor='hand'"></img>-<input type=text name='ToDate'  id='appt_to_dt' size='8' maxlength='10' value='<%=currentdate_display%>' onBlur="validDateObj(this,'DMY',localeName);" tabindex=10><img id='img2'   src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_to_dt');" style="cursor='hand'"></img>
	<!-- if (CheckDate(this)) validate_date1(document.forms[0].frmDate,this); -->
	</td> 
	</td>
	<td align='right' colspan=2><input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick="WaitList();" tabindex=12><input type=button name='Clear' id='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearData();' tabindex=13>
	<td ></td>
	</tr>
<%}%>

</table>

<%
}
  catch(Exception e) { 
	  out.println(e.toString());
	  e.printStackTrace();
	  }
  finally 
  {
	 ConnectionManager.returnConnection(con,request);
  }

%>	
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>
<input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='<%=emer_regn_allow_yn%>'>
<input type='hidden' name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='<%=visit_for_inpat_yn%>'>
<input type='hidden' name='build_episode_rule' id='build_episode_rule' value="<%=build_episode_rule%>">

<input type='hidden' name='register_visit_yn' id='register_visit_yn' value="<%=register_visit_yn%>">

<input type='hidden' name='oa_install_yn' id='oa_install_yn' value="<%=oa_install_yn%>">
<input type='hidden' name='or_install_yn' id='or_install_yn' value="<%=or_install_yn%>">
<input type='hidden' name='functionId' id='functionId' value="<%=functionId%>">
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>">
<input type='hidden' name='wait_list_inv' id='wait_list_inv' value="<%=wait_list_inv%>">
<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=bl_interface_yn%>">
<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
<input type='hidden' name='register_visit_walkin' id='register_visit_walkin' value="<%=register_visit_walkin%>">
<input type='hidden' name='register_visit_referral' id='register_visit_referral' value="<%=register_visit_referral%>">
<input type='hidden' name='register_pat_yn' id='register_pat_yn' value="<%=register_pat_yn%>">
<input type='hidden' name='currentdate' id='currentdate' value="<%=currentdate%>">
<!--below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] -->
<input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value="<%=upt_contact_dtls_oa_yn%>">

<input type='hidden' name='alt_id1_desc' id='alt_id1_desc' value="<%=alt_id1_desc%>">
<input type='hidden' name='alt_id2_desc' id='alt_id2_desc' value="<%=alt_id2_desc%>">
<input type='hidden' name='alt_id3_desc' id='alt_id3_desc' value="<%=alt_id3_desc%>">
<input type='hidden' name='alt_id4_desc' id='alt_id4_desc' value="<%=alt_id4_desc%>">
<input type='hidden' name='names_in_oth_lang_yn' id='names_in_oth_lang_yn' value="<%=names_in_oth_lang_yn%>">
<input type='hidden' name='accept_dis_inv_no' id='accept_dis_inv_no' value="<%=accept_dis_inv_no%>">
<input type='hidden' name='tabName' id='tabName' value="<%=tabName%>">
<input type='hidden' name='isPractoApptApplYN' id='isPractoApptApplYN' value="<%=isPractoApptApplYN%>"> <!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446]-->
<input type='hidden' name='isVirtualConsultationVisit' id='isVirtualConsultationVisit' value="<%=isVirtualConsultationVisit %>" <!--  Added by lakshmanan ML-MMOH-CRF-1930 -->
<input type=hidden name='r_town' id='r_town' value=''> 
<input type=hidden name='m_town' id='m_town' value=''> 
<input type=hidden name='r_area' id='r_area' value=''> 
<input type=hidden name='m_area' id='m_area' value=''> 
<input type=hidden name='r_region' id='r_region' value=''> 
<input type=hidden name='m_region' id='m_region' value=''> 
<input type=hidden name='locale' id='locale' value='<%=locale%>'> 
<input type=hidden name='queryString' id='queryString' value='<%=query_string%>'> 
 <input type=hidden name='entitlement_by_cat_yn' id='entitlement_by_cat_yn' value='<%=entitlement_by_cat_yn%>'> 
 
</form>
</html>




