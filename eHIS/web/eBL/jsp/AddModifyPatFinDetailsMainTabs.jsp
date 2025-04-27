<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	ResultSet rs = null;
	PreparedStatement pstmt=null;
	Statement stmt				= null;
	String strAllParam = "";
	try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		con = ConnectionManager.getConnection();	
		strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";
		String strModuleId =  request.getParameter("calling_module_id") ==null ? "" : request.getParameter("calling_module_id");	
		String patient_id =  request.getParameter("patient_id") ==null ? "" : request.getParameter("patient_id");	
		String billing_mode =  request.getParameter("billing_mode") == null? "" :request.getParameter("billing_mode");
		String operation =  request.getParameter("operation") == null? "" :request.getParameter("operation");

		String functionId =  request.getParameter("calling_function_id") == null? "" :request.getParameter("calling_function_id");

		String facilityId =  request.getParameter("facilityId") == null? "" :request.getParameter("facilityId");

		String sex = request.getParameter("sex") == null? "" :request.getParameter("sex");

		String slmt_ind = "", cash_pay_pat_YN="N", class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
		String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "", dependent_inc_freq = "";
		String tot_inc_asset = "";
		String no_of_dependants = "", blng_grp_id = "", blng_grp_desc = "", valid_from = "", valid_to = "", last_date = "";

		String blng_grp_changed_YN="N", fam_mem_incl_YN="N";
		String classStartDate="",classEndDate="";String sql = "";
		String blng_grp_id_temp="";
		
		String delimiter="::";
		String prevPatId="";
		String classTypChangeAuthYN="";
		String changePatAuthYN="";
		
		String classTypChangeAuthYnPatId			= (String)session.getAttribute("classTypChangeAuthYnPatId");
		System.err.println("classTypChangeAuthYnPatId maintabs"+classTypChangeAuthYnPatId);
		//System.err.println(" bef loop prevPatId "+prevPatId);
		// System.err.println("bef loop classTypChangeAuthYN :: "+classTypChangeAuthYN);
		 
		if(classTypChangeAuthYnPatId != null){
			
			System.err.println("In loop classTypChangeAuthYnPatId maintabs"+classTypChangeAuthYnPatId);
			 String[] classTypChangeTokens=classTypChangeAuthYnPatId.split(delimiter);
			 //System.out.println("classTypChangeTokens "+classTypChangeTokens);
			 prevPatId=classTypChangeTokens[0];
			 //System.err.println("prevPatId "+prevPatId);
			 classTypChangeAuthYN=classTypChangeTokens[1];
			 //System.err.println("classTypChangeAuthYN :: "+classTypChangeAuthYN);
		}

		if((!strModuleId.equals("IP") || billing_mode.equals("Add")) && (!functionId.equals("CHG_PAT_DTLS")))
		{
/*
			slmt_ind = request.getParameter("slmt_ind") == null? "" :request.getParameter("slmt_ind");

			class_type = request.getParameter("class_type") == null? "" :request.getParameter("class_type");
			
			class_code = request.getParameter("class_code") == null? "" :request.getParameter("class_code");
			
			class_desc = request.getParameter("class_desc") == null? "" :request.getParameter("class_desc");
			
			remarks = request.getParameter("remarks") == null? "" :request.getParameter("remarks");
			
			social_pensioner_id = request.getParameter("social_pensioner_id") == null? "" : request.getParameter("social_pensioner_id");
			
			inc_asset_ind = request.getParameter("inc_asset_ind") == null? "" : request.getParameter("inc_asset_ind");
			
			ind_inc = request.getParameter("ind_inc") == null? "" :request.getParameter("ind_inc");
			
			ind_inc_freq = request.getParameter("ind_inc_freq") == null? "" :request.getParameter("ind_inc_freq");
			
			spouse_inc = request.getParameter("spouse_inc") == null? "" :request.getParameter("spouse_inc");
			
			spouse_inc_freq = request.getParameter("spouse_inc_freq") == null? "" :request.getParameter("spouse_inc_freq");
			
			dependent_inc = request.getParameter("dependent_inc") == null? "" :request.getParameter("dependent_inc");
			
			dependent_inc_freq = request.getParameter("dependent_inc_freq") == null? "" :request.getParameter("dependent_inc_freq");
			
			tot_inc_asset = request.getParameter("tot_inc_asset") == null? "" :request.getParameter("tot_inc_asset");
			
			no_of_dependants = request.getParameter("no_of_dependants") == null? "" :request.getParameter("no_of_dependants");
			
			blng_grp_id = request.getParameter("blng_grp_id") == null? "" :request.getParameter("blng_grp_id");
			
			blng_grp_desc = request.getParameter("blng_grp_desc") == null? "" :request.getParameter("blng_grp_desc");
			
			valid_from = request.getParameter("valid_from") == null? "" :request.getParameter("valid_from");
			
			valid_to = request.getParameter("valid_to") == null? "" :request.getParameter("valid_to");
			
			last_date = request.getParameter("last_date")== null ? "" : request.getParameter("last_date");
*/			
		}
		
		String encounter_date_aft_trunc="",encounter_date_time="",sys_date_wht_sec="",sysDate = "";
		int noofdecimal=2;
		
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2),to_char(sysdate,'dd/mm/yyyy HH24:MI'),to_char(sysdate,'dd/mm/yyyy') from  sm_acc_entity_param where acc_entity_id='ZZ'");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				noofdecimal  =  rs.getInt(1);
				sys_date_wht_sec = rs.getString(2);
				sysDate = rs.getString(3);
			}	
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}
		
		
		encounter_date_time = request.getParameter("encounter_date_time");
		System.err.println("encounter_date_time :"+encounter_date_time);
		if(encounter_date_time == null) encounter_date_time="";

		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

		//	stmt = con.createStatement();
			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1,encounter_date_time);
		
			rs = pstmt.executeQuery() ;

			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}
		

Boolean siteSpec=false;
		
		try
		{
			
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_FIN_CLASS_DTLS_BLANK");
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}
		String finDetClose="";
//		if((functionId.equals("CHG_PAT_DTLS") || functionId.equals("PAT_REG")) && (billing_mode.equals("Modify")))
		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
//			System.err.println("Financial Session value in Tabs.jsp:"+bl_data);
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				finDetClose = ((String)bl_data.get("fin_det_close")).trim();
				if(finDetClose == null) finDetClose="";
				
				System.out.println("finDetClose BEF:::AddModifyPatFinDetailsMainTabs.jsp :"+finDetClose);
				if(siteSpec)
				{
				if(strModuleId.equals("IP") || strModuleId.equals("DC")) {
					 
					if(finDetClose.equals("Y")){
						System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::finDetClose "+ind_inc_freq);
						blng_grp_id=((String)bl_data.get("blng_grp")).trim();
						if(blng_grp_id == null) blng_grp_id="";
						slmt_ind=((String)bl_data.get("slmt_ind")).trim();
						if(slmt_ind == null) slmt_ind="";
						class_type=((String)bl_data.get("class_type")).trim();
						if(class_type == null) class_type="";
						class_code=((String)bl_data.get("class_code")).trim();
						if(class_code == null) class_code="";
						remarks=((String)bl_data.get("fin_remarks")).trim();
						if(remarks == null) remarks="";
						inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
						if(inc_asset_ind == null) inc_asset_ind="";
						ind_inc=((String)bl_data.get("ind_inc")).trim();
						if(ind_inc == null) ind_inc="";
						ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
						if(ind_inc_freq == null) ind_inc_freq="";
						spouse_inc=((String)bl_data.get("spouse_inc")).trim();
						if(spouse_inc == null) spouse_inc="";
						spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
						if(spouse_inc_freq == null) spouse_inc_freq="";
						dependent_inc=((String)bl_data.get("dependent_inc")).trim();
						if(dependent_inc == null) dependent_inc="";
						dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
						if(dependent_inc_freq == null) dependent_inc_freq="";
						no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
						if(no_of_dependants == null) no_of_dependants="";
						valid_from=((String)bl_data.get("valid_from")).trim();
						if(valid_from == null) valid_from="";
						valid_to=((String)bl_data.get("valid_to")).trim();
						if(valid_to == null) valid_to="";
						last_date=((String)bl_data.get("last_date")).trim();
						if(last_date == null) last_date="";
						if(inc_asset_ind.equals("I"))
						{
							tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
							if(tot_inc_asset == null) tot_inc_asset=""; 
						}
						else if(inc_asset_ind.equals("A"))
						{
							tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
							if(tot_inc_asset == null) tot_inc_asset=""; 
						}
						social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
						if(social_pensioner_id == null) social_pensioner_id="";
					}else{
						System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::else "+ind_inc_freq);
						valid_from=((String)bl_data.get("valid_from")).trim();
						if(valid_from == null) valid_from="";	

						valid_to=((String)bl_data.get("valid_to")).trim();
						if(valid_to == null) valid_to="";
						
						last_date=((String)bl_data.get("last_date")).trim();
						if(last_date == null) last_date="";
						
						blng_grp_id_temp=((String)bl_data.get("blng_grp")).trim();
						if(blng_grp_id_temp == null) blng_grp_id_temp="";
					
					}
				}else{
					System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::2nd else "+ind_inc_freq);
					blng_grp_id=((String)bl_data.get("blng_grp")).trim();
					if(blng_grp_id == null) blng_grp_id="";
					slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(slmt_ind == null) slmt_ind="";
					class_type=((String)bl_data.get("class_type")).trim();
					if(class_type == null) class_type="";
					class_code=((String)bl_data.get("class_code")).trim();
					if(class_code == null) class_code="";
					remarks=((String)bl_data.get("fin_remarks")).trim();
					if(remarks == null) remarks="";
					inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
					if(inc_asset_ind == null) inc_asset_ind="";
					ind_inc=((String)bl_data.get("ind_inc")).trim();
					if(ind_inc == null) ind_inc="";
					ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
					if(ind_inc_freq == null) ind_inc_freq="";
					spouse_inc=((String)bl_data.get("spouse_inc")).trim();
					if(spouse_inc == null) spouse_inc="";
					spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
					if(spouse_inc_freq == null) spouse_inc_freq="";
					dependent_inc=((String)bl_data.get("dependent_inc")).trim();
					if(dependent_inc == null) dependent_inc="";
					dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
					if(dependent_inc_freq == null) dependent_inc_freq="";
					no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if(no_of_dependants == null) no_of_dependants="";
					valid_from=((String)bl_data.get("valid_from")).trim();
					if(valid_from == null) valid_from="";
					valid_to=((String)bl_data.get("valid_to")).trim();
					if(valid_to == null) valid_to="";
					last_date=((String)bl_data.get("last_date")).trim();
					if(last_date == null) last_date="";
					if(inc_asset_ind.equals("I"))
					{
						tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					else if(inc_asset_ind.equals("A"))
					{
						tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
					if(social_pensioner_id == null) social_pensioner_id="";
				}

			}
				else{
					System.err.println("AddModifyPatFinDetailsMainTabs.jsp ::3rd else "+ind_inc_freq);
					blng_grp_id=((String)bl_data.get("blng_grp")).trim();
					if(blng_grp_id == null) blng_grp_id="";
					slmt_ind=((String)bl_data.get("slmt_ind")).trim();
					if(slmt_ind == null) slmt_ind="";
					class_type=((String)bl_data.get("class_type")).trim();
					if(class_type == null) class_type="";
					class_code=((String)bl_data.get("class_code")).trim();
					if(class_code == null) class_code="";
					remarks=((String)bl_data.get("fin_remarks")).trim();
					if(remarks == null) remarks="";
					inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
					if(inc_asset_ind == null) inc_asset_ind="";
					ind_inc=((String)bl_data.get("ind_inc")).trim();
					if(ind_inc == null) ind_inc="";
					ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
					if(ind_inc_freq == null) ind_inc_freq="";
					spouse_inc=((String)bl_data.get("spouse_inc")).trim();
					if(spouse_inc == null) spouse_inc="";
					spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
					if(spouse_inc_freq == null) spouse_inc_freq="";
					dependent_inc=((String)bl_data.get("dependent_inc")).trim();
					if(dependent_inc == null) dependent_inc="";
					dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
					if(dependent_inc_freq == null) dependent_inc_freq="";
					no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
					if(no_of_dependants == null) no_of_dependants="";
					valid_from=((String)bl_data.get("valid_from")).trim();
					if(valid_from == null) valid_from="";
					valid_to=((String)bl_data.get("valid_to")).trim();
					if(valid_to == null) valid_to="";
					last_date=((String)bl_data.get("last_date")).trim();
					if(last_date == null) last_date="";
					if(inc_asset_ind.equals("I"))
					{
						tot_inc_asset = ((String)bl_data.get("annual_income")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					else if(inc_asset_ind.equals("A"))
					{
						tot_inc_asset = ((String)bl_data.get("family_asset")).trim();
						if(tot_inc_asset == null) tot_inc_asset=""; 
					}
					social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
					if(social_pensioner_id == null) social_pensioner_id="";
				}
			}
		}

		if(siteSpec){
		sql = "SELECT to_char(CLASSIFICATION_START_DATE,'dd/mm/yyyy') CLASSIFICATION_START_DATE,to_char(CLASSIFICATION_END_DATE,'dd/mm/yyyy') CLASSIFICATION_END_DATE FROM BL_PATIENT_FIN_DTLS WHERE PATIENT_ID=?";
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				classStartDate = rs.getString(1);		
		    	classEndDate = rs.getString(2);
		    	System.out.println("classStartDate::classEndDate :: "+classStartDate+"::"+classEndDate);
		    	
			}
		}
		catch(Exception e)
		{
			System.err.println("Exception from ASSESSMENT_MONTHS:"+e );
		}
		finally
		{
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		}

		if(classStartDate==null) classStartDate="";
		if(classEndDate==null) classEndDate="";
		valid_from=classStartDate;
		valid_to=classEndDate;
		}
		
		Boolean SiteSpec=false;
		Boolean boolPatientFoundMP=false;
		boolean boolSecurity = false;
			String SiteSpecific ="";
			try
			{				
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in site specific "+e);
			}
			if(SiteSpec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}
	if(!patient_id.equals("")){	
		try
			{
				String sqlCiti = "select a.citizen_yn,to_char(a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, b.gl_holder_name gl_holder_name, b.pat_reln_with_gl_holder pat_reln_with_gl_holder from mp_patient a, bl_patient_fin_dtls b where a.patient_id = ? and a.patient_id=b.patient_id";
				
				pstmt = con.prepareStatement(sqlCiti);
				pstmt.setString(1,patient_id);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
					while( rs.next() )
					{  
						boolPatientFoundMP = true;
					}
				}
				if (rs != null) rs.close();
				if(pstmt!=null) pstmt.close();	
			}
			catch(Exception e)
			{
			}
		}
		if (((strModuleId.equals("MP")) && (boolPatientFoundMP == true)) || ((strModuleId.equals("IP") || strModuleId.equals("DC") ||           strModuleId.equals("OP")||strModuleId.equals("AE")) && (boolPatientFoundMP == true)))
		{
			boolSecurity = true;
		}
%>	
<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src='../js/AddModifyPatFinClassDetails.js'></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
	</head>
<script>
function tab_change(obj,cald_for)
{
	var params = document.forms[0].params.value;

	var obj_id=obj.id;
	cellref = document.getElementById('tab').rows[0].cells;
	for(i=0; i<cellref.length; i++)
	{
		if(cellref[i].id == 'FinancialClass' || cellref[i].id == 'FinancialDetails')
		{
			if(cellref[i].id == obj_id)
			{
				cellref[i].className='TDCLICKED';
			}
			else
			{
				cellref[i].className='TDNORMAL';
			}
		}
	}
/*
	if(cald_for == 'FC')
	{
		parent.frames[1].location.href = "../../eBL/jsp/AddModifyPatFinClassDetailsMain.jsp?"+params;
	}
	else if (cald_for == 'FD')
	{
		params = params+"&fin_class_flag_YN=N";
		parent.frames[1].location.href = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+params;
	}
*/
}
function load_fin_dtls()
{
/*
	var params = document.forms[0].params.value;
	params = params+"&fin_class_flag_YN=N";
	parent.frames[1].location.href = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+params;
	document.getElementById('fin_class_tab').className = "tabA";
	document.getElementById('FinancialClass').className = "tabAspan";

	document.getElementById('fin_dtl_tab').className = "tabClicked";
	document.getElementById('FinancialDetails').className = "tabSpanclicked";
*/
}

</script>

<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onLoad="load_fin_dtls();refreshAuthValue()">
	<FORM name='' action="" method='post'>
	  <TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%' id='tab'>
	  <tr>
	  <!--
		<td id='FinancialDetails' class="tabSpanclicked" border='3' width="25%" align='left' onclick="tab_change(this,'FD');" ><a style='color:white;cursor:pointer' ><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></a></td>

		<td id='FinancialClass' class="TDCLICKED" border='3' width="25%" align='left' onclick="tab_change(this,'FC');"><a style='color:white;cursor:pointer' >Financial Classification</a></td>
-->
		<td width= "100%" class="white">
			<ul id="tablist" class="tablist" >
				<li class="tablistitem" title='<fmt:message key="eBL.FIN_CLASS.label" bundle="${bl_labels}"/>'>
					<a onclick="tab_click('fin_class_tab')" class="tabClicked" id="fin_class_tab" >
						<span class="tabSpanclicked" id="FinancialClass"><fmt:message key="eBL.FIN_CLASS.label" bundle="${bl_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title='<fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/>'>
					<a onclick="tab_click('fin_dtl_tab')" class="tabA" id="fin_dtl_tab">
					<span class="tabAspan" id="FinancialDetails"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
		</tr>
<!--
		<td class="label" width="25%">&nbsp;</td>
	  </tr>
-->
</TABLE>
<input type='hidden' name='params' id='params' value='<%=strAllParam%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'  />
<input type='hidden' name='calling_module_id' id='calling_module_id' id='calling_module_id' value='<%=strModuleId%>'> 
<input type='hidden' name='calling_function_id' id='calling_function_id' value='<%=functionId%>'>
<input type='hidden' name='modify_flag' id='modify_flag' value='N' >
<input type='hidden' name='slmt_ind' id='slmt_ind' value='<%=slmt_ind%>'>	
<input type='hidden' name='cash_pay_pat_YN' id='cash_pay_pat_YN' value='<%=cash_pay_pat_YN%>'>	

<input type='hidden' name='class_type' id='class_type' id='class_type' value='<%=class_type%>' >
<input type='hidden' name='class_code' id='class_code' value='<%=class_code%>' >	
<input type='hidden' name='class_desc' id='class_desc' value='<%=class_desc%>' >
<input type='hidden' name='fam_mem_incl_YN' id='fam_mem_incl_YN' value='<%=fam_mem_incl_YN%>' >
<input type='hidden' name='operation' id='operation' value='<%=operation%>' >
<input type='hidden' name='SiteSpecific' id='SiteSpecific' id='SiteSpecific' value="<%=SiteSpecific%>" /> 
<input type='hidden' name='boolean_security' id='boolean_security' id='boolean_security' value="<%=boolSecurity%>" /> 
<input type='hidden' name='remarks' id='remarks' value='<%=remarks%>' >			
<input type='hidden' name='social_pensioner_id' id='social_pensioner_id' value='<%=social_pensioner_id%>' >				
<input type='hidden' name='inc_asset_ind' id='inc_asset_ind' value='<%=inc_asset_ind%>' >			
<input type='hidden' name='ind_inc' id='ind_inc' value='<%=ind_inc%>' >				
<input type='hidden' name='ind_inc_freq' id='ind_inc_freq' value='<%=ind_inc_freq%>' >		
<input type='hidden' name='spouse_inc' id='spouse_inc' value='<%=spouse_inc%>' >			
<input type='hidden' name='spouse_inc_freq' id='spouse_inc_freq' value='<%=spouse_inc_freq%>' >	
<input type='hidden' name='dependent_inc' id='dependent_inc' value='<%=dependent_inc%>' >	
<input type='hidden' name='dependent_inc_freq' id='dependent_inc_freq' value='<%=dependent_inc_freq%>' >

<input type='hidden' name='tot_inc_asset' id='tot_inc_asset' value='<%=tot_inc_asset%>' >	
<input type='hidden' name='no_of_dependants' id='no_of_dependants' value='<%=no_of_dependants%>' >

<input type='hidden' name='blng_grp_id' id='blng_grp_id' value='<%=blng_grp_id%>' >
<input type='hidden' name='blng_grp_desc' id='blng_grp_desc' value='<%=blng_grp_desc%>' >
<input type='hidden' name='valid_from' id='valid_from' value='<%=valid_from%>' >
<input type='hidden' name='valid_to' id='valid_to' value='<%=valid_to%>' >
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>' >
<input type='hidden' name='sex' id='sex' value='<%=sex%>' >	
<input type='hidden' name='last_date' id='last_date' value='<%=last_date%>'  />
<input type='hidden' name='soc_pensr_id_mand_yn' id='soc_pensr_id_mand_yn' value="" >
<input type='hidden' name='inc_asset_mand_YN' id='inc_asset_mand_YN' value="" >	
<input type='hidden' name='remarks_mand_YN' id='remarks_mand_YN' value=""  />

<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value='<%=encounter_date_aft_trunc%>'  />
<input type='hidden' name='blng_grp_changed_YN' id='blng_grp_changed_YN' value='<%=blng_grp_changed_YN%>'  />		
<input type='hidden' name ='siteSpec' id ='siteSpec' value='<%=siteSpec%>'/>
<input type='hidden' name ='blng_grp_id_temp' value='<%=blng_grp_id_temp%>'/>

<input type='hidden' name ='change_flag' id ='change_flag' value='N' />
<input type='hidden' name='patientId' id='patientId' id='patientId' value='<%=patient_id%>'  />
<input type='hidden' name='prevPatId' id='prevPatId' id='prevPatId' value='<%=prevPatId%>'>
<input type='hidden' name='classTypChangeAuthYN' id='classTypChangeAuthYN' id='classTypChangeAuthYN' value='<%=classTypChangeAuthYN%>'>
<input type='hidden' name='changePatAuthYN' id='changePatAuthYN' id='changePatAuthYN' value='<%=changePatAuthYN%>'>

	<input type='hidden' name='class_type_prev' id='class_type_prev' value='<%=class_type%>' />	
	<input type='hidden' name='class_code_prev' id='class_code_prev' value='<%=class_code%>' />	
	<input type='hidden' name='class_desc_prev' id='class_desc_prev' value='<%=class_desc%>' />
	<input type='hidden' name='social_pensioner_id_prev' id='social_pensioner_id_prev' value='<%=social_pensioner_id%>' />	
	<input type='hidden' name='inc_asset_ind_prev' id='inc_asset_ind_prev' value='<%=inc_asset_ind%>' />	
	<input type='hidden' name='ind_inc_prev' id='ind_inc_prev' value='<%=ind_inc%>' />	
	<input type='hidden' name='ind_inc_freq_prev' id='ind_inc_freq_prev' value='<%=ind_inc_freq%>' />	
	<input type='hidden' name='spouse_inc_prev' id='spouse_inc_prev' value='<%=spouse_inc%>' />	
	<input type='hidden' name='spouse_inc_freq_prev' id='spouse_inc_freq_prev' value='<%=spouse_inc_freq%>'/>	
	<input type='hidden' name='dependent_inc_prev' id='dependent_inc_prev' value='<%=dependent_inc%>' />		
	<input type='hidden' name='dependent_inc_freq_prev' id='dependent_inc_freq_prev' value='<%=dependent_inc_freq%>' />				
	<input type='hidden' name='tot_inc_asset_prev' id='tot_inc_asset_prev' value='<%=tot_inc_asset%>' />	
	<input type='hidden' name='no_of_dependants_prev' id='no_of_dependants_prev' value='<%=no_of_dependants%>' />	
	<input type='hidden' name='blng_grp_desc_prev' id='blng_grp_desc_prev' value='<%=blng_grp_desc%>' />
	<input type='hidden' name='blng_grp_id_prev' id='blng_grp_id_prev' value='<%=blng_grp_id%>' />
<%-- 	<input type='hidden' name='class_typ_change_authYN' id='class_typ_change_authYN' value='<%=classTypChangeAuthYN%>' /> --%>


</FORM>
<script>
	var params = document.forms[0].params.value;
	var SiteSpecific = document.forms[0].SiteSpecific.value;
	parent.frames[1].location.href = "../../eBL/jsp/AddModifyPatFinClassDetailsMain.jsp?"+params+"&SiteSpecific="+SiteSpecific;
</script>
</BODY>	
</HTML>
<%
	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}
%> 

