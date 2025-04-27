<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String val1="";
	String val2="";
	String val3="";
	String val4="";
	String val5="";
	String val6="";
	String val7="";
	String val8="";
	String val9="";
	String val10="";
	String val11="";
	String val12="";
	String val13="";
	String val14="";
	String val20="";
	String val21="";
	String ws_by_ip_name_val="";
	String ADDR_LINE1_APPL_YN="";
	String ADDR_LINE2_APPL_YN="";
	String ADDR_LINE3_APPL_YN="";
	String ADDR_LINE4_APPL_YN="";
	String RES_AREA_APPL_YN="";
	String RES_TOWN_APPL_YN="";
	String REGION_PROMPT="";
	String REGION_APPL_YN="";
	String REGION_ORDER="";
	String POSTAL_CODE_APPL_YN="";	


	//14-04-2009
	String POSTAL_CODE_LINK_YN="";	
	String DISPLAY_USER_NAME_YN="";
	//Maheshwaran added for MMS-QH-CRF-0149
	//Start
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CHK_ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String CHK_CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	String spl_char_visibility="";
	String unlock_user_hide="";
	String MULTIPLE_LOGIN_ALLOWED_YN="";
	String UNLOCK_USER_SESSION_HRS="";
	//End
	String NATID_MAND_PRACT_OTHSTAFF_YN="";//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
	String CHK_NATID_MAND_PRACT_OTHSTAFF_YN="";//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
	String FIRST_LOGIN_CHANGE_PASSWORD_YN="";//Added by Maheshwaran for AMs-CRF-0098
	String CHK_FIRST_LOGIN_CHANGE_PASSWORD_YN="";//Added by Maheshwaran for AMs-CRF-0098
	String CHANGE_PASSWORD_MANDATORY_YN="";//Added by Maheshwaran for AMs-CRF-0098
	String CHK_CHANGE_PASSWORD_MANDATORY_YN="";//Added by Maheshwaran for AMs-CRF-0098
	String checkADDR_LINE1_APPL_YN="";
	String checkADDR_LINE2_APPL_YN="";
	String checkADDR_LINE3_APPL_YN="";
	String checkADDR_LINE4_APPL_YN="";
	String checkRES_AREA_APPL_YN="";
	String checkRES_TOWN_APPL_YN="";
	String checkREGION_APPL_YN="";
	String checkPOSTAL_CODE_APPL_YN="";	


		//14-04-2009
	String checkPOSTAL_CODE_LINK_YN="";	
	String checkDISPLAY_USER_NAME_YN="";
	String checkMULTIPLE_LOGIN_ALLOWED_YN="";
	
	String chngatfacyVal="";

	Connection conn=null;
	Statement stmt = null;
	Boolean isGSTCodeApplicable = false; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	//Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115
    Boolean isSpcltyNurSrchCrtAppl=false;
    Boolean NatIdMandPractOthstaff=false; //Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020	
	String chk_spl_nur_unit_to_enable_yn="";
	String SPL_NUR_UNIT_TO_ENABLE_YN="";
	//Added by kamatchi S for ML-BRU-CRF-0594
	String dis_user_val ="";
	Boolean isAutoDisableAppl = false;

	try{
		request.setCharacterEncoding("UTF-8");
		conn = ConnectionManager.getConnection(request);
		stmt= conn.createStatement();
		ResultSet rset=null;
		
		//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
		isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP", "GST_CODE");
		isSpcltyNurSrchCrtAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "SPCLTY_NUR_SRCH_CRT_APPL");//Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115
		NatIdMandPractOthstaff = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "NATID_MAND_PRACT_OTHSTAFF");//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
		isAutoDisableAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "SM", "AUTO_DIS_USER");//Added by Kamatchi S for ML-BRU-CRF-0594
%>
<%

try
{
%>
	<html><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script src='../../eSM/js/SiteParameter.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		//not to allowing manually to enter any text
		function onkeyPressEvent(e){
			return false;
		}
		</script>
		</head><body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>

<%
	//Maheshwaran modified the query for MMS-QH-CRF-0149
	//String sql = "SELECT site_id, site_name, gstin_site, addr_line1_prompt, addr_line1_order, addr_line2_prompt, addr_line2_order, addr_line3_prompt, addr_line3_order, addr_line4_prompt ,addr_line4_order ,res_area_prompt ,res_area_order ,res_town_prompt ,res_town_order ,postal_code_prompt ,postal_code_order ,ws_by_ip_name, change_ws_at_fcy_yn ,ADDR_LINE1_APPL_YN, ADDR_LINE2_APPL_YN, ADDR_LINE3_APPL_YN ,ADDR_LINE4_APPL_YN, RES_AREA_APPL_YN, RES_TOWN_APPL_YN, REGION_PROMPT, REGION_APPL_YN, POSTAL_CODE_APPL_YN, REGION_ORDER, POSTAL_CODE_LINK_YN, DISPLAY_USER_NAME_YN,MULTIPLE_LOGIN_ALLOWED_YN,ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,FIRST_LOGIN_CHANGE_PASSWORD_YN,CHANGE_PASSWORD_MANDATORY_YN FROM sm_site_param ";
	String sql = "SELECT site_id, site_name, gstin_site, addr_line1_prompt, addr_line1_order, addr_line2_prompt, addr_line2_order, addr_line3_prompt, addr_line3_order, addr_line4_prompt ,addr_line4_order ,res_area_prompt ,res_area_order ,res_town_prompt ,res_town_order ,postal_code_prompt ,postal_code_order ,ws_by_ip_name, change_ws_at_fcy_yn ,ADDR_LINE1_APPL_YN, ADDR_LINE2_APPL_YN, ADDR_LINE3_APPL_YN ,ADDR_LINE4_APPL_YN, RES_AREA_APPL_YN, RES_TOWN_APPL_YN, REGION_PROMPT, REGION_APPL_YN, POSTAL_CODE_APPL_YN, REGION_ORDER, POSTAL_CODE_LINK_YN, DISPLAY_USER_NAME_YN,ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,FIRST_LOGIN_CHANGE_PASSWORD_YN,CHANGE_PASSWORD_MANDATORY_YN,MULTIPLE_LOGIN_ALLOWED_YN,UNLOCK_USER_SESSION_HRS,SPL_NUR_UNIT_TO_ENABLE_YN,NATID_MAND_PRACT_OTHSTAFF_YN,DIS_USER_VAL FROM sm_site_param ";

	rset = stmt.executeQuery(sql);

	rset.next();
	String site_name = rset.getString("site_name");
	String gstin_site = rset.getString("gstin_site")== null ? "":rset.getString( "gstin_site");

%>
	<br>
	<form name='siteparameter_form' id='siteparameter_form' action='../../servlet/eSM.SiteParameterServlet' method='post' enctype='multipart/form-data' target='messageFrame' > <div align='left'><br><table border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>

	<tr><td width='0%'>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td width='0%'>&nbsp;</td></tr><tr><td>&nbsp;</td><td class='label' width='25%' ><fmt:message key="eSM.SiteID.label" bundle="${sm_labels}"/></td><td class="fields"><!-- width='60%'-->

	<input type='text' name='site_id' id='site_id'  value='<%=rset.getString("site_id")%>' size='2'  maxlength='2' readonly >

	<img src='../../eCommon/images/mandatory.gif'></img>

	</td><td>&nbsp;</td></tr>
	
	<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
	<%if(isGSTCodeApplicable)
	{%>
	<tr><td>&nbsp;</td><td width="25%" class="label"><fmt:message key="Common.GoodsandServicesTaxID.label" bundle="${common_labels}"/></td><td class='fields'><input type="text" name="gstin_site" id="gstin_site" size="20" maxlength="20" onKeyPress="return SpCharChkForSite(event);" onBlur="ZeroChkForSite(this);" value='<%=gstin_site%>'>
	&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</td><td>&nbsp;</td></tr>
	<%}%>
	
	<tr><td>&nbsp;</td><td class='label' width='25%'><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></td><td class="fields"> <input type='text' name='site_name' id='site_name' onBlur='makeValidString(this);'  size='30' maxlength='30' value='<%=site_name%>'>
	&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	</td><td>&nbsp;</td></tr>
	
	<TR><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></TR></table> <input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'>

<%
									 val1=rset.getString("addr_line1_prompt");
									 val2=rset.getString("addr_line1_order");
									 val3=rset.getString("addr_line2_prompt");
									 val4=rset.getString("addr_line2_order");
									 val5=rset.getString("addr_line3_prompt");
									 val6=rset.getString("addr_line3_order");
									 val7=rset.getString("addr_line4_prompt");
									 val8=rset.getString("addr_line4_order");
									 val9=rset.getString("res_area_prompt");
									 val10=rset.getString("res_area_order");
									 val11=rset.getString("res_town_prompt");
									 val12=rset.getString("res_town_order");
									 val13=rset.getString("postal_code_prompt");
									 val14=rset.getString("postal_code_order");
									 val20=rset.getString("ws_by_ip_name");
									 
									 if(val20.equals("I")){
									 ws_by_ip_name_val="IP Address";
									 }
									 else if(val20.equals("N")){	 
										ws_by_ip_name_val="Machine Name";
									 }
									val21=rset.getString("change_ws_at_fcy_yn");

		ADDR_LINE1_APPL_YN	= rset.getString("ADDR_LINE1_APPL_YN");  
		ADDR_LINE2_APPL_YN	= rset.getString("ADDR_LINE2_APPL_YN");
		ADDR_LINE3_APPL_YN	=rset.getString("ADDR_LINE3_APPL_YN");  
		ADDR_LINE4_APPL_YN	=rset.getString("ADDR_LINE4_APPL_YN");   
		RES_AREA_APPL_YN		=rset.getString("RES_AREA_APPL_YN");    
		RES_TOWN_APPL_YN		=rset.getString("RES_TOWN_APPL_YN");     
		REGION_PROMPT			=rset.getString("REGION_PROMPT");          
		REGION_APPL_YN			=rset.getString("REGION_APPL_YN");          
		REGION_ORDER				=rset.getString("REGION_ORDER");             
		POSTAL_CODE_APPL_YN=rset.getString("POSTAL_CODE_APPL_YN");

		//14-04/2009
		POSTAL_CODE_LINK_YN=rset.getString("POSTAL_CODE_LINK_YN");
	
		DISPLAY_USER_NAME_YN=rset.getString("DISPLAY_USER_NAME_YN");
		//Maheshwaran added for MMS-QH-CRF-0149
		//Start
		ENFORCE_PASSWORD_POLICY_YN=rset.getString("ENFORCE_PASSWORD_POLICY_YN");
		CASE_SENSITIVE_PASSWORD_YN=rset.getString("CASE_SENSITIVE_PASSWORD_YN");
		ALLOWED_SPL_CHAR_IN_PASSWORD=rset.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
		//End
		NATID_MAND_PRACT_OTHSTAFF_YN=rset.getString("NATID_MAND_PRACT_OTHSTAFF_YN");//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
		//Added by Maheshwaran for AMs-CRF-0098
		FIRST_LOGIN_CHANGE_PASSWORD_YN=rset.getString("FIRST_LOGIN_CHANGE_PASSWORD_YN");
		CHANGE_PASSWORD_MANDATORY_YN=rset.getString("CHANGE_PASSWORD_MANDATORY_YN");
		MULTIPLE_LOGIN_ALLOWED_YN=rset.getString("MULTIPLE_LOGIN_ALLOWED_YN");
		UNLOCK_USER_SESSION_HRS=rset.getString("UNLOCK_USER_SESSION_HRS");
		if(UNLOCK_USER_SESSION_HRS==null) UNLOCK_USER_SESSION_HRS = "";
		
		SPL_NUR_UNIT_TO_ENABLE_YN=rset.getString("SPL_NUR_UNIT_TO_ENABLE_YN");//Added by shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115
		
		//Added by Kamatchi S for ML-BRU-CRF-0594
		dis_user_val=rset.getString("DIS_USER_VAL");
		if(dis_user_val==null) dis_user_val = "";

		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(val21.equals("Y"))
			chngatfacyVal="Checked";
		else
			chngatfacyVal="";

		if(val1==null) val1="";
		if(val2==null) val2="";
		if(val3==null) val3="";
		if(val4==null) val4="";
		if(val5==null) val5="";
		if(val6==null) val6="";
		if(val7==null) val7="";
		if(val8==null) val8="";
		if(val9==null) val9="";
		if(val10==null) val10="";
		if(val11==null) val11="";
		if(val12==null) val12="";
		if(val13==null) val13="";
		if(val14==null) val14="";

		if(ADDR_LINE1_APPL_YN==null) ADDR_LINE1_APPL_YN = "N";
		if( ADDR_LINE2_APPL_YN==null) ADDR_LINE2_APPL_YN = "N";
		if( ADDR_LINE3_APPL_YN==null) ADDR_LINE3_APPL_YN = "N";
		if( ADDR_LINE4_APPL_YN==null) ADDR_LINE4_APPL_YN = "N";
		if( RES_AREA_APPL_YN==null) RES_AREA_APPL_YN = "N";
		if( RES_TOWN_APPL_YN==null) RES_TOWN_APPL_YN = "N";
		if( REGION_APPL_YN==null) REGION_APPL_YN = "N";
		if( POSTAL_CODE_APPL_YN==null) POSTAL_CODE_APPL_YN = "N";

		if( POSTAL_CODE_LINK_YN==null) POSTAL_CODE_LINK_YN = "N";
		if( DISPLAY_USER_NAME_YN==null) DISPLAY_USER_NAME_YN = "N";
		if(MULTIPLE_LOGIN_ALLOWED_YN==null) MULTIPLE_LOGIN_ALLOWED_YN = "Y";

		
		if(ADDR_LINE1_APPL_YN.equals("Y")) 	checkADDR_LINE1_APPL_YN="checked";
		if( ADDR_LINE2_APPL_YN.equals("Y"))   checkADDR_LINE2_APPL_YN="checked";
		if( ADDR_LINE3_APPL_YN.equals("Y"))   checkADDR_LINE3_APPL_YN="checked";
		if( ADDR_LINE4_APPL_YN.equals("Y"))   checkADDR_LINE4_APPL_YN="checked";
		if( RES_AREA_APPL_YN.equals("Y"))   checkRES_AREA_APPL_YN="checked";
		if( RES_TOWN_APPL_YN.equals("Y"))   checkRES_TOWN_APPL_YN="checked";
		if( REGION_APPL_YN.equals("Y")) checkREGION_APPL_YN="checked";
		if( POSTAL_CODE_APPL_YN.equals("Y")) checkPOSTAL_CODE_APPL_YN="checked";

		
		if(REGION_PROMPT==null ) REGION_PROMPT="";
		if(REGION_ORDER==null ) REGION_ORDER="";	


		//14-04/2009

		
		if(POSTAL_CODE_LINK_YN.equals("Y")) 
	    {
			checkPOSTAL_CODE_LINK_YN="checked";
	    }
		else
	    {
			checkPOSTAL_CODE_LINK_YN="";
			
	    }

		if(DISPLAY_USER_NAME_YN.equals("Y")) 
		   {
			checkDISPLAY_USER_NAME_YN="checked";
		   }
		else
			{
			checkDISPLAY_USER_NAME_YN="";
		
			}
		//Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020
		if(NATID_MAND_PRACT_OTHSTAFF_YN.equals("Y")) 
		   {
			CHK_NATID_MAND_PRACT_OTHSTAFF_YN="checked";
		   }
		else
			{
			CHK_NATID_MAND_PRACT_OTHSTAFF_YN="";
			}
		//Ended for MOHE-CRF-0011
		//Maheshwaran added for MMS-QH-CRF-0149	
		if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")) 
		   {
			CHK_ENFORCE_PASSWORD_POLICY_YN="checked";
			spl_char_visibility="";
		   }
		else
			{
			CHK_ENFORCE_PASSWORD_POLICY_YN="";
			spl_char_visibility="none";
			}
		if(CASE_SENSITIVE_PASSWORD_YN.equals("Y")) 
		   {
			CHK_CASE_SENSITIVE_PASSWORD_YN="checked";
		   }
		else
			{
			CHK_CASE_SENSITIVE_PASSWORD_YN="";
			}
			if(MULTIPLE_LOGIN_ALLOWED_YN.equals("Y")) 
		   {
			checkMULTIPLE_LOGIN_ALLOWED_YN="checked";
			unlock_user_hide="none";
		   }
		else
			{
			checkMULTIPLE_LOGIN_ALLOWED_YN="";
		
			}
			//Added by Maheshwaran for AMs-CRF-0098
		if(FIRST_LOGIN_CHANGE_PASSWORD_YN.equals("Y")) 
		   {
			CHK_FIRST_LOGIN_CHANGE_PASSWORD_YN="checked";
			CHK_CHANGE_PASSWORD_MANDATORY_YN="";
			if(CHANGE_PASSWORD_MANDATORY_YN.equals("Y")) 
				{
				CHK_CHANGE_PASSWORD_MANDATORY_YN="checked";
				}
		   }
		else
			{
			CHANGE_PASSWORD_MANDATORY_YN="N";
			CHK_FIRST_LOGIN_CHANGE_PASSWORD_YN="";
			CHK_CHANGE_PASSWORD_MANDATORY_YN="disabled";
			}//Added by Maheshwaran for AMs-CRF-0098
		//Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115	
		if(SPL_NUR_UNIT_TO_ENABLE_YN.equals("Y")) 
		   {
			chk_spl_nur_unit_to_enable_yn="checked";
		   }
		else
			{
			chk_spl_nur_unit_to_enable_yn="";
			}
	%>
		<table  border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>
		<th>&nbsp;</th><th >&nbsp;<fmt:message key="Common.Address.label" bundle="${common_labels}"/></th><th ><fmt:message key="eSM.Prompts.label" bundle="${sm_labels}"/></th><th align='left'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
		<tr><td colspan='4'>&nbsp;</td></tr>
		<tr>
		<td>&nbsp;</td><td class='label' width='25%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;1</td>
		<td class="fields"><input type='text' name='addr_line1_prompt' id='addr_line1_prompt' onBlur="makeValidString(this);" size='15' onBlur="makeValidString(this);"  maxlength='15'
		value="<%=val1%>">
		</td>
		<td class="fields"><input type='checkbox' name='ADDR_LINE1_APPL_YN' id='ADDR_LINE1_APPL_YN' value='<%=ADDR_LINE1_APPL_YN%>' <%=checkADDR_LINE1_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

<%/********************************** hidden Values *********************************/%>
		<input type='hidden' name='addr_line1_order' id='addr_line1_order' onBlur="makeValidString(this);" size='1' maxlength='1' value="1"  onKeyPress='return allowValidNumber(this,event,1,0);return checkNumberRange()'>	
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td class='label' width='25%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;2</td>
		<td class="fields">
		<input type='text' name='addr_line2_prompt' id='addr_line2_prompt' onBlur="makeValidString(this);"  size='15' maxlength='15' value="<%=val3%>">
		</td>
		<td class="fields">
		<input type='checkbox' name='ADDR_LINE2_APPL_YN' id='ADDR_LINE2_APPL_YN'  value="<%=ADDR_LINE2_APPL_YN%>" <%=checkADDR_LINE2_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
<%/********************************** hidden Values *********************************/%>
		<input type='hidden' name='addr_line2_order' id='addr_line2_order' onBlur="makeValidString(this);"  size='1' maxlength='1' value="2" onKeyPress='return allowValidNumber(this,event,1,0);'> 
		</td>
		</tr>

		<tr>
		<td>&nbsp;</td><td class='label' width='25%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;3</td>
		<td class="fields"><input type='text' onBlur="makeValidString(this);"  name='addr_line3_prompt' id='addr_line3_prompt' size='15' maxlength='15' value="<%=val5%>">
		</td>
		<td class="fields"><input type='checkbox' name='ADDR_LINE3_APPL_YN' id='ADDR_LINE3_APPL_YN' size='1' value="<%=ADDR_LINE3_APPL_YN%>" <%=checkADDR_LINE3_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

<!-- ******************hidden values*********************************** -->
		<input type='hidden' name='addr_line3_order' id='addr_line3_order' size='1' onBlur="makeValidString(this);"  maxlength='1' value="3" onKeyPress='return allowValidNumber(this,event,1,0);'> 
  
		</tr>

		<tr>
		<td>&nbsp;</td><td class='label' width='25%'><fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;4</td>
		<td class="fields"><input type='text' name='addr_line4_prompt' id='addr_line4_prompt' size='15' onBlur="makeValidString(this);"   maxlength='15' value="<%=val7%>">
		</td>
		<td class="fields">
		<input type='checkbox' name='ADDR_LINE4_APPL_YN' id='ADDR_LINE4_APPL_YN' size='1' value="<%=ADDR_LINE4_APPL_YN%>" <%=checkADDR_LINE4_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<input type='hidden' name='addr_line4_order' id='addr_line4_order' size='1' maxlength='1'  onBlur="makeValidString(this);"  value="4" onKeyPress='return allowValidNumber(this,event,1,0);' >

		</tr>
		<tr>
		<td>&nbsp;</td>
		<td class='label' width='25%'><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='text' name='res_town_prompt' id='res_town_prompt' size='15' onBlur="makeValidString(this);"  maxlength='15' value="<%=val11%>" >
		 </td>
		<td class="fields"><input type='checkbox' name='RES_TOWN_APPL_YN' id='RES_TOWN_APPL_YN' size='1' maxlength='1'   value="<%=RES_TOWN_APPL_YN%>" <%=checkRES_TOWN_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<input type='hidden' name='res_town_order' id='res_town_order' size='1' maxlength='1'  onBlur="makeValidString(this);"  value="5" onKeyPress='return allowValidNumber(this,event,1,0);'>
	 
		</tr>
		<tr>
		<td>&nbsp;</td><td class='label' width='25%'><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='text' name='res_area_prompt' id='res_area_prompt' size='15' maxlength='15' onBlur="makeValidString(this);"  value="<%=val9%>" >
		</td>
		<td class="fields">
		<input type='checkbox' name='RES_AREA_APPL_YN' id='RES_AREA_APPL_YN' size='1' maxlength='1'  value="<%=RES_AREA_APPL_YN%>" <%=checkRES_AREA_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 

		<input type='hidden' name='res_area_order' id='res_area_order' size='1' maxlength='1' onBlur="makeValidString(this);"  value="6" onKeyPress='return allowValidNumber(this,event,1,0);'> 
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td class='label' width='25%'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		<td class="fields">
		<input type='text' name='REGION_PROMPT' id='REGION_PROMPT' size='15'   maxlength='15' onBlur="makeValidString(this);"  value="<%=REGION_PROMPT%>" >
		</td>
		<td class="fields"><input type='checkbox' name='REGION_APPL_YN' id='REGION_APPL_YN' size='1'  value="<%=REGION_APPL_YN%>" <%=checkREGION_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<input type='hidden' name='REGION_ORDER' id='REGION_ORDER' size='1' maxlength='1'  onBlur="makeValidString(this);"  value="7" onKeyPress='return allowValidNumber(this,event,1,0);'>
		</tr>
 
		<tr>
		<td>&nbsp;</td><td class='label' width='25%'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/></td>
		<td class="fields"> <input type='text' name='postal_code_prompt' id='postal_code_prompt' size='15' maxlength='15' onBlur="makeValidString(this);"  value="<%=val13%>" >
		</td>
		<td class="fields"><input type='checkbox' name='POSTAL_CODE_APPL_YN' id='POSTAL_CODE_APPL_YN' size='1' maxlength='1' value="<%=POSTAL_CODE_APPL_YN%>" <%=checkPOSTAL_CODE_APPL_YN%> onclick="checkValues(this)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<input type='hidden' name='postal_code_order' id='postal_code_order' size='1' maxlength='1'  onBlur="makeValidString(this);"  value="8" onKeyPress='return allowValidNumber(this,event,1,0);'>
		</tr>
		<tr> 
		<td>&nbsp;</td><td class='label' width='25%' nowrap><fmt:message key="eSM.SiteLogoLoginScreen.label" bundle="${sm_labels}"/></td>
		<td class='fields'><input type="file" name="siteLogoUrl" id="siteLogoUrl" id="fac_logo_id" value=""  size=40 maxlength=40 onkeypress="return onkeyPressEvent(event);"onchange="fac_logo_check();">
		</td>
		<td colspan='2'>&nbsp;</td>
		</tr>
		<tr><td colspan='4'>&nbsp;</td></tr>
			
		</table>
		<table  border='0' cellpadding='0' cellspacing='0' width='70%' align='center'>
		<th>&nbsp;</th>
			<th >&nbsp;</th>

		<tr><td>&nbsp;</td></tr>
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.PostalCodeLinkRequired.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='postal_code_link_yn' id='postal_code_link_yn'   value="<%=POSTAL_CODE_LINK_YN%>" <%=checkPOSTAL_CODE_LINK_YN%>
		onclick="checkValues(this)"></td>
		<td>
		
		</tr>
		
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.DisplayUserNameApplHeader.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='display_user_name_yn' id='display_user_name_yn' value="<%=DISPLAY_USER_NAME_YN%>" <%=checkDISPLAY_USER_NAME_YN%> onclick="checkValues(this)"></td>

		<td>
		</tr>
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.ChangePasswordFirstLogin.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='first_login_change_password_yn' id='first_login_change_password_yn' value="<%=FIRST_LOGIN_CHANGE_PASSWORD_YN%>" <%=CHK_FIRST_LOGIN_CHANGE_PASSWORD_YN%> onclick="checkValues(this); FirstLoginChangePassword(this);"></td>
		<td>
		</tr>
		
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.ChangePasswordMandatory.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='change_password_mandatory_yn' id='change_password_mandatory_yn' value="<%=CHANGE_PASSWORD_MANDATORY_YN%>" <%=CHK_CHANGE_PASSWORD_MANDATORY_YN%> onclick="checkValues(this); "></td>
		<td>
		</tr>
		<!--Maheshwaran k Added for MMS-QH-CRF-0149-->
		<!--Start-->
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.CaseSensitivePassword.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='case_sensitive_password_yn' id='case_sensitive_password_yn' value="<%=CASE_SENSITIVE_PASSWORD_YN%>" <%=CHK_CASE_SENSITIVE_PASSWORD_YN%> disabled></td>
		<td>
		</tr>
		<!--Added by Shanmukh on 7th-AUG-2018 for ML-MMOH-CRF-1115-->
		<%if(isSpcltyNurSrchCrtAppl){%>
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="Common.Enable.label" bundle="${common_labels}"/>&nbsp;<b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b>&nbsp;<fmt:message key="eSM.SrhCrtForSpltyAndNursingUnit.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='SPL_NUR_UNIT_TO_ENABLE_YN' id='SPL_NUR_UNIT_TO_ENABLE_YN'  value="<%=SPL_NUR_UNIT_TO_ENABLE_YN%>" <%=chk_spl_nur_unit_to_enable_yn%> onclick="chkSpltyNursUnitYN();" ></td>
		</tr>
		<%}else{%><input type='hidden' name='SPL_NUR_UNIT_TO_ENABLE_YN' id='SPL_NUR_UNIT_TO_ENABLE_YN' value='Y'>
		<%}%>
		<!-- Added by Suji Keerthi for MOHE-CRF-0011 on 21-Apr-2020 -->
		<%if(NatIdMandPractOthstaff){%>
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.NatIDMandForCitizenInPractAndOtherStaff.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='natid_mand_pract_othstaff_yn' id='natid_mand_pract_othstaff_yn' value="<%=NATID_MAND_PRACT_OTHSTAFF_YN%>" <%=CHK_NATID_MAND_PRACT_OTHSTAFF_YN%> onclick="chkNatIDPractOthStaffYN();" ></td>
		</tr>
		<%}else{%><input type='hidden' name='natid_mand_pract_othstaff_yn' id='natid_mand_pract_othstaff_yn' value='N'>
		<%}%>
		<!-- Ended for MOHE-CRF-0011 -->
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.EnforcePasswordPolicy.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='enforce_password_policy_yn' id='enforce_password_policy_yn' value="<%=ENFORCE_PASSWORD_POLICY_YN%>" <%=CHK_ENFORCE_PASSWORD_POLICY_YN%> onclick="checkValues(this); spl_char_display(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>');"></td>
		<td>
		</tr>
	
		<tr><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.MultipleLoginAllowed.label" bundle="${sm_labels}"/></td>
		<td><input type='checkbox' name='multiple_login_allowed_yn' id='multiple_login_allowed_yn'  value="<%=MULTIPLE_LOGIN_ALLOWED_YN%>" <%=checkMULTIPLE_LOGIN_ALLOWED_YN%> onclick="checkValues(this);checkUnlockSession(this);"></td>

		<td>
		</tr>
		<tr id='unlock_user_hide' style='display:<%=unlock_user_hide%>'  ><td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.UnlockUserSessionAfter.label" bundle="${sm_labels}"/></td>
		<tr id='unlock_user_hide' style='display:<%=unlock_user_hide%>'  >
		<td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.UnlockUserSessionAfter.label" bundle="${sm_labels}"/></td>
		<td class='fields'><input type='text'   name='unlock_user_session_hrs' id='unlock_user_session_hrs' value="<%=UNLOCK_USER_SESSION_HRS%>" maxlength="2" size="3"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='SPCheckPositiveNumber(this);'/>&nbsp;<fmt:message key="Common.Hrs.label" bundle="${common_labels}"/></td>

		<td>
		</tr>
		
	
		<tr id='spl_char_display' style='display:<%=spl_char_visibility%>'>
		<td class='label' width='86%'>&nbsp;&nbsp;<fmt:message key="eSM.AllowSplCharInPassword.label" bundle="${sm_labels}"/></td>
		<td><input type='text' size='12' name='allowed_spl_char_in_password' id='allowed_spl_char_in_password' value='<%=ALLOWED_SPL_CHAR_IN_PASSWORD%>' disabled></td>
		<td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr id='spl_char_legend_display' style='display:<%=spl_char_visibility%>'>
		 <td class='label' width='86%' style='color:red'>&nbsp;&nbsp;<b><fmt:message key="eSM.PASSWORD_POLICY.label" bundle="${sm_labels}"/></b>&nbsp;<fmt:message key="eSM.PASSWORD_POLICY1.label" bundle="${sm_labels}"/><%=ALLOWED_SPL_CHAR_IN_PASSWORD%></td>
		</tr>

		<% if(isAutoDisableAppl) { %>
		<tr>
		<td class='label' >&nbsp;&nbsp;<fmt:message key="eSM.AutoDisbleInactiveUser.label" bundle="${sm_labels}"/></td>
		<td class='fields'><input type='text' size='4' maxlength = '4' name='dis_user_val' id='dis_user_val' value="<%=dis_user_val%>" onBlur="CheckNum(this);CheckZeroVal(this);" onkeypress = "return(ChkNumberInput(this,event,0))">&nbsp;&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>
		</td>
		</tr>

		<%}%>
					

		<!--End-->
		</table>
		</div>
		<!--<div align='left'><br>-->


		
		
		<input type='hidden' name='eff_date_from1' id='eff_date_from1' value=''>
		<input type='hidden' name='eff_date_to1' id='eff_date_to1' value=''>
		
		<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
		<input type="hidden" name="isGSTCodeApplicable" id="isGSTCodeApplicable" value="<%=isGSTCodeApplicable%>">
		</form>
		

<%
	    
	}
	catch ( Exception e ) {
	}
	
	if ( rset != null ) rset.close() ;
	if(stmt!=null) stmt.close();
	}catch(Exception e){
		
		out.println(e);
		
		}
	finally {	
		
				ConnectionManager.returnConnection(conn,request);

			}
 
%>
</body>
</html>

