<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%

	Connection con = null;
	PreparedStatement pstmt	= null;
	PreparedStatement pstmt1 =	null;
	Statement stmt	= null;
	ResultSet rs	= null;
	ResultSet rs2	= null;
	Statement stmtDate1 = null;
	String locale			= (String)session.getAttribute("LOCALE");

	try
  	{	
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);
		String sys_date = "",sys_date_wht_sec="";
		String non_ins_settlement_ind ="",non_ins_adm_flag="",query_cust="";
//		String ar_install_yn="";
		String slmt_type_code="",dflt_slmt_type_code="", cash_slmt_flag="";
		String mcust_4="",mcust_group_4="",mcredit_doc_ref3="",mcredit_doc_date3="",mcash_set_type2="";
		String non_ins_cust_code="", non_ins_short_name="";
		String str_cust_curr_code="", str_cust_curr_desc="";
		String non_ins_cust_group_code="", non_ins_cust_group_desc="";
		String cust_valid_from_date = "", cust_valid_to_date = "";
		String mcredit_doc_st_date3="";
		String non_insur_blng_grp="";
		String billing_group="";
		String rtn_blng_grp="";
		String rtn_non_ins_blng_grp ="";
		String rtn_non_ins_credit_doc_reqd_yn="";
		String rtn_non_ins_slmt_type_code="";
		String rtn_non_ins_inst_ref ="";
		String rtn_non_ins_inst_date="";
		String rtn_non_ins_inst_remarks ="";
		String rtn_non_ins_cust_code="";
		String rtn_non_ins_cust_group_code = "";
		String rtn_non_ins_credit_doc_ref="";
		String rtn_non_ins_credit_doc_start_date="";
		String rtn_non_ins_credit_doc_end_date  ="";	
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";
		
		String payerGrpBySetup=request.getParameter("payerGrpBySetup");

		String encounter_date_time = "", encounter_date_aft_trunc="";

		String fin_class_flag_YN="N",autoFinChk="N";

		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			billing_mode="Add";
			operation="Insert";
		}

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(bl_data!=null)
			{
				rtn_blng_grp=((String)bl_data.get("blng_grp")).trim();
				rtn_non_ins_blng_grp =((String)bl_data.get("non_ins_blng_grp")).trim();
				rtn_non_ins_credit_doc_reqd_yn=((String)bl_data.get("non_ins_credit_doc_reqd_yn")).trim();
				rtn_non_ins_slmt_type_code=((String)bl_data.get("non_ins_slmt_type_code")).trim();
				rtn_non_ins_inst_ref =((String)bl_data.get("non_ins_inst_ref")).trim();
				rtn_non_ins_inst_date=((String)bl_data.get("non_ins_inst_date")).trim();
				rtn_non_ins_inst_remarks  =((String)bl_data.get("non_ins_inst_remarks")).trim();
				rtn_non_ins_cust_code=((String)bl_data.get("non_ins_cust_code")).trim();
				rtn_non_ins_cust_group_code=((String)bl_data.get("non_ins_cust_group_code")).trim();
				rtn_non_ins_credit_doc_ref=((String)bl_data.get("non_ins_credit_doc_ref")).trim();
				rtn_non_ins_credit_doc_start_date=((String)bl_data.get("non_ins_credit_doc_start_date")).trim();
				rtn_non_ins_credit_doc_end_date  =((String)bl_data.get("non_ins_credit_doc_end_date")).trim(); 
			}
		}
		else
		{
			billing_group=request.getParameter("billing_group");
		}

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
//			String non_insur_blng_grp= request.getParameter("non_insur_blng_grp");
			non_insur_blng_grp= rtn_non_ins_blng_grp;
			if( non_insur_blng_grp == null) non_insur_blng_grp="";
		}
		else
		{
			non_insur_blng_grp= request.getParameter("non_insur_blng_grp");
			if( non_insur_blng_grp == null) non_insur_blng_grp="";
		}

/*		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";
*/		
		String strCreditDoc_YN = "N";
		
		String strModuleId = request.getParameter("calling_module_id");
		if (strModuleId==null) strModuleId="";    

		String str_function_id = request.getParameter("calling_function_id");
		if(str_function_id == null) str_function_id="";

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
//			mcust_4 = request.getParameter("cust_4");
			mcust_4 = rtn_non_ins_cust_code;
			mcust_group_4 = rtn_non_ins_cust_group_code;
//			mcredit_doc_ref3 = request.getParameter("credit_doc_ref3");
			mcredit_doc_ref3 =rtn_non_ins_credit_doc_ref;
//			mcredit_doc_date3 = request.getParameter("credit_doc_date3");
			mcredit_doc_date3 =	rtn_non_ins_credit_doc_end_date;
//			mcredit_doc_st_date3 = request.getParameter("credit_doc_start_date3");
			mcredit_doc_st_date3 =rtn_non_ins_credit_doc_start_date;
			if (mcredit_doc_st_date3==null) mcredit_doc_st_date3 = "";

//			mcash_set_type2 = request.getParameter("cash_set_type2");
			mcash_set_type2 = rtn_non_ins_slmt_type_code;

		}
		/** 
			The file modification is done by
			Murugavel on 11/08/2002
			for the Cash Patient., if the Credit doc. is required then
			the Credit doc reference and the
			Credit doc date are Mandatory	

			Credit Doc Date should accept only the future date and the
			
		
		**/	
		
		String sql="select settlement_ind, adm_rec_flag,nvl(credit_doc_ref_reqd_yn,'N'),to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from bl_blng_grp where blng_grp_id = ? ";
		//out.println("sql :"+sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, non_insur_blng_grp);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				non_ins_settlement_ind = rs.getString("settlement_ind");
				non_ins_adm_flag = rs.getString("adm_rec_flag");
				strCreditDoc_YN = rs.getString(3);
				sys_date = rs.getString(4);
				sys_date_wht_sec = rs.getString(5);
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
/*
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy'),to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmtDate1 = con.createStatement();
			ResultSet rsDate = stmtDate1.executeQuery(query_date) ;
			if( rsDate != null ) 
			{
				while( rsDate.next() )
				{  
					sys_date = rsDate.getString(1);
					sys_date_wht_sec = rsDate.getString(2);
				}
			}
			if(rsDate != null) rsDate.close();
			stmtDate1.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmtDate1 = con.createStatement();
			rsDate = stmtDate1.executeQuery(query_date) ;
			if( rsDate != null ) 
			{
				while( rsDate.next() )
				{  
					sys_date_wht_sec = rsDate.getString(1);
				}
			}
			if(rsDate !=null) rsDate.close();
			stmtDate1.close();
		}
		catch(Exception e)
		{
			out.println("Exception @ sysdate"+e);
		}
*/
		encounter_date_time = request.getParameter("encounter_date_time");
		if(encounter_date_time == null) encounter_date_time="";
//		System.out.println("encounter_date_time from Interface Module in 3.jsp:"+encounter_date_time);		
		if(encounter_date_time.equals(""))
			encounter_date_time = sys_date_wht_sec;

//		System.out.println("encounter_date_time in 3.jsp page:"+encounter_date_time);
		
		try
		{
			String sql_trunc_time="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";

			/* stmtDate1 = con.createStatement();
			rs = stmtDate1.executeQuery(sql_trunc_time) ; */

			pstmt = con.prepareStatement(sql_trunc_time);
			pstmt.setString(1, encounter_date_time);
			rs = pstmt.executeQuery();
			if( rs!= null ) 
			{
				while( rs.next() )
				{  
					encounter_date_aft_trunc = rs.getString(1);
				}
			}
			if (rs != null)   rs.close();
			stmtDate1.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while executing sql_trunc_time :"+e);
		}

		if(!("").equals(encounter_date_aft_trunc))
		{
			encounter_date_aft_trunc = com.ehis.util.DateUtils.convertDate(encounter_date_aft_trunc,"DMY","en",locale) ;
		}
	
		/*

		try
		{
		String query_ar="select install_yn from sm_module where module_id='AR'";

		pstmt1 = con.prepareStatement(query_ar);
		rs3 = pstmt1.executeQuery() ;
		if( rs3 != null ) 
		{
			while( rs3.next() )
			{  
				ar_install_yn = rs3.getString("install_yn");
				
			}
		}
		pstmt1.close();

		}
		catch(Exception e)
		{
			out.println("Exception @ install"+e);
		}
		*/

%>
<html>
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>

<script language='javascript'>

function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1);
	}
}

function dfltslmt()
{
	var dfltslmt = document.forms[0].dflt_slmt_type_code.value;	
		
	if(document.forms[0].cash_set_type2 != null)
	{
		for(i=0;i<document.forms[0].cash_set_type2.options.length;i++)
		{									
			var cashSetValue = document.forms[0].cash_set_type2.options[i].value;									
			if (cashSetValue == null)
			{
				continue;
			}

			var len = cashSetValue.length;
			var subValue ="";
			if (len >0)
			{
				subValue = cashSetValue.substring(0,len-1);
			}

			if (subValue == dfltslmt)
			{								
				document.forms[0].cash_set_type2.value = cashSetValue;
			}
		}
	}
}

async function noninscustlkup(clng_evnt)
{		
	var target			= document.forms[0].cust_4_desc;	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].cust_4_desc.value='';
			document.forms[0].cust_4.value = '';
			return;
		}
	}

	var retVal			= new String();	
	var dialogTop			= "0vh";//40
	var dialogHeight		= "60vh" ;//10
	var dialogWidth			= "50vw" ;//40
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var message = '';	

	var search_by_items = document.forms[0].search_by_items.value;
	var search_code = document.forms[0].search_code.value;

	var locale = document.forms[0].locale.value;
	var strModuleId = document.forms[0].calling_module_id.value;
	var encounter_date_aft_trunc = document.forms[0].encounter_date_aft_trunc.value;
	var non_ins_settlement_ind =document.forms[0].non_ins_settlement_ind.value;
	var non_ins_adm_flag =document.forms[0].non_ins_adm_flag.value;
	var strCustGroupCode = document.forms[0].non_ins_cust_group_code.value;
	var blng_grp_curr_code = parent.parent.frames[0].frames[2].document.forms[0].currency_code_for_bg.value;
	
	var cust_valid_from_date="", cust_valid_to_date = "";
	
	var column_sizes = escape("5%,25%,5%%,25%,10%,10%,10%,10%,0%,0%");

	var title=getLabel("Common.Customer.label","common"); 
	title=encodeURIComponent(title);

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var cust_group_code=getLabel("eBL.CUST_GROUP_CODE.label","BL");
	cust_group_code=encodeURIComponent(cust_group_code);
	var cust_group=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	cust_group=encodeURIComponent(cust_group);
	var country = getLabel("Common.country.label","common");
	country = encodeURIComponent(country);
	var region = getLabel("eMP.region.label","MP");
	region = encodeURIComponent(region);
	var cust_valid_frm=getLabel("eBL.VALID_FROM.label","BL");
	cust_valid_frm=encodeURIComponent(cust_valid_frm);	
	var cust_valid_to=getLabel("eBL.VALID_TO.label","BL");
	cust_valid_to=encodeURIComponent(cust_valid_to);	
	var curr_code=getLabel("eBL.CURR_CODE.label","BL");
	curr_code=encodeURIComponent(curr_code);
	var curr_desc=getLabel("eBL.CURR_DESC.label","BL");
	curr_desc=encodeURIComponent(curr_desc);

	var column_descriptions = code+","+desc+","+cust_group_code+","+cust_group+","+country+","+region+","+cust_valid_frm+","+cust_valid_to+","+curr_code+","+curr_desc;
	
	sql = "called_for=NONINSCUSTLKUP&locale="+locale+"&module_id="+strModuleId+"&search_code="+search_code+"&search_by_items="+search_by_items+"&cust_grp_code="+strCustGroupCode+"&non_ins_slmt_ind="+non_ins_settlement_ind+"&non_ins_adm_flag="+non_ins_adm_flag;
/*
	if( non_ins_settlement_ind == 'R')
	{
		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
		+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC" 
		+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
		+" where a.language_id = b.language_id" 
		+" and a.language_id='"+locale+"'" 
		+" and b.cust_group_code = c.cust_group_code"
		+" and a.cust_code = c.cust_code" 
		+" and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
		+" and a.patient_flag = 'Y'" 
		+" and a.pat_com_flag = 'Y'" 
		+" and nvl (insurance_yn,'N') = 'N'" 
		+" and a.status is null" 
		+" and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')" 
		+" or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')" 
		+" or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))" 
		+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
	}
	else if(non_ins_settlement_ind == 'X' && non_ins_adm_flag == '1')
	{
		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME,"
		+" a.country_name COUNTRY_NAME,a.region_name REGION_NAME,VALID_FROM VALID_FROM,VALID_TO VALID_TO,a.CURRENCY_CODE CURRENCY_CODE,a.CURRENCY_DESC CURRENCY_DESC" 
		+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
		+" where a.language_id = b.language_id" 
		+" and a.language_id='"+locale+"'" 
		+" and b.cust_group_code = c.cust_group_code"
		+" and a.cust_code = c.cust_code" 
		+" and (b.cust_group_code='"+strCustGroupCode+"' or '"+strCustGroupCode+"' is null)"
		+" and a.patient_flag = 'Y'" 
		+" and a.pat_com_flag = 'N'" 
		+" and nvl (insurance_yn,'N') = 'N'" 
		+" and a.status is null" 
		+" and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y')" 
		+" or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y')" 
		+" or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y'))" 
		+" and decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')) = nvl('"+search_code+"',decode('"+search_by_items+"','CY',nvl(a.country_code,'XXXX'),'RN',nvl(a.region_code,'XXXX')))";
	}
//	sql = escape(sql);							
*/
//	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";;

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYYYYYYNN";

	retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		

	var arr=new Array();		

    if(retVal == null) retVal='';

	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");				   

			cust_valid_from_date = arr[6].substring(0,10);
			cust_valid_to_date = arr[7].substring(0,10);
			cust_curr_code = arr[8];
			cust_curr_desc = arr[9];

			if(cust_valid_from_date != "")
			{
				var cust_valid_from_date_loc = cust_valid_from_date;
				if(locale != 'en')
					cust_valid_from_date_loc=convertDate(cust_valid_from_date_loc,'DMY','en',locale);

				if(!isAfter(encounter_date_aft_trunc,cust_valid_from_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					return false;
				}
			}
			if(cust_valid_to_date != "")
			{
				var cust_valid_to_date_loc= cust_valid_to_date
				if(locale != 'en')
					cust_valid_to_date_loc=convertDate(cust_valid_to_date_loc,'DMY','en',locale);

				if(!isBefore(encounter_date_aft_trunc,cust_valid_to_date_loc,'DMY',locale))
				{
					alert(getMessage("BL8227","BL"));
					return false;
				}
			}

			if((blng_grp_curr_code != "" && cust_curr_code == "") || (blng_grp_curr_code == "" && cust_curr_code != "") || (blng_grp_curr_code != "" && cust_curr_code != "" && cust_curr_code != blng_grp_curr_code))
			{
				alert(getMessage("BL6312","BL"));
				document.forms[0].cust_4_desc.value='';
				document.forms[0].cust_4.value = '';
				document.forms[0].cust_curr_code.value = "";
				document.forms[0].cust_curr_desc.value = "";
				document.getElementById('cust_curr_desc_disp').style.display="none";
				document.getElementById('cust_curr_desc_val').innerText="";
				return false;
			}
			else
			{
				document.forms[0].cust_curr_code.value = cust_curr_code;
				document.forms[0].cust_curr_desc.value = cust_curr_desc;
			}


			document.forms[0].cust_4_desc.value=arr[1];
			document.forms[0].cust_4.value=arr[0];
			document.forms[0].non_ins_cust_group_desc.value=arr[3];
			document.forms[0].non_ins_cust_group_code.value=arr[2];
			document.forms[0].non_ins_cust_valid_from_date.value=cust_valid_from_date;
			document.forms[0].non_ins_cust_valid_to_date.value=cust_valid_to_date;
		}
		else
		{
			document.forms[0].cust_4_desc.value='';
			document.forms[0].cust_4.value = '';
			target.focus();
		}
	}
	curr_desc_1();
}

async function noninscustgrouplkup(clng_evnt)
{
	

	var target				= document.forms[0].non_ins_cust_group_desc;	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].non_ins_cust_group_desc.value='';
			document.forms[0].non_ins_cust_group_code.value = '';
			return;
		}
	}
	var msg="";

	var retVal				= new String();
	var dialogTop			= "0vh";//40
	var dialogHeight		= "60vh" ;//10
	var dialogWidth			= "50vw" ;//40
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var message				= "";
	var column_sizes = escape("30%,70%");

	var locale = document.forms[0].locale.value;
		
	sql = "	select cust_group_code cust_group_code, short_desc short_name from ar_cust_group_lang_vw " + 
			" where  language_id='"+locale+"' and status is null";	

	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL"); 
	title=encodeURIComponent(title);	
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql = escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");
		
		document.forms[0].non_ins_cust_group_desc.value=arr[1];
	    document.forms[0].non_ins_cust_group_code.value=arr[0];					
	}
	else
	{	
		document.forms[0].non_ins_cust_group_desc.value='';
	    document.forms[0].non_ins_cust_group_code.value='';												
	}
}

function srch_by_crit_for_cust()
{
	var non_ins_settlement_ind = document.forms[0].non_ins_settlement_ind.value;
	if(non_ins_settlement_ind != 'C')
	{
		var srch_by = document.forms[0].search_by_items.value;

		if(srch_by == "CG")
		{
			document.getElementById('srch_by_leg').innerText=getLabel("eBL.CUSTOMER_GROUP.label","BL");
		}
		else if (srch_by == "CY")
		{
			document.getElementById('srch_by_leg').innerText=getLabel("Common.country.label","common");
		}
		else if (srch_by == "RN")
		{
			document.getElementById('srch_by_leg').innerText=getLabel("eMP.region.label","MP");
		}

		document.forms[0].srch_by_desc.value='';
		document.forms[0].search_code.value = '';
	}
}

async function srchbylkup(clng_evnt)
{	
	

	var srch_by = document.forms[0].search_by_items.value;
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].search_code ;
	var target = document.forms[0].srch_by_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].srch_by_desc.value='';
			document.forms[0].search_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "0vh";
	var dialogHeight		= "60vh" ;
	var dialogWidth			= "50vw" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";
	
	if(srch_by == "CG")
	{
		var title=getLabel("eBL.CUSTOMER_GROUP.label","BL"); 
		title=encodeURIComponent(title);		
		
		sql = "	select cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and status is null";	
	}
	else if (srch_by == "CY")
	{
		var title=getLabel("Common.country.label","common"); 
		title=encodeURIComponent(title);		
		
		sql = "select country_code COUNTRY_CODE,short_name SHORT_NAME from mp_country_lang_vw where language_id='"+locale+"' and eff_status = 'E'";	
	}
	else if (srch_by == "RN")
	{
		var title=getLabel("eMP.region.label","MP"); 
		title=encodeURIComponent(title);		
		
		sql = "select region_code REGION_CODE,short_desc SHORT_NAME from mp_region_lang_vw where language_id='"+locale+"' and eff_status = 'E'";	
	}

	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
	}
	else
	{	
		target.value='';
		target_code.value = '';
	}
}

async function getCustDet()
{
	var cust_4=document.forms[0].cust_4.value;				
				
	if((cust_4!=""))
	{
		var retVal;
		var dialogHeight= "14" ;
		var dialogWidth	= "23" ;
		var dialogTop = "350" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLCustomerDet.jsp?cust_code="+cust_4;
		retVal = await window.showModalDialog(url,arguments,features);
	}
}

function curr_desc_1()
{
	var non_ins_settlement_ind = document.forms[0].non_ins_settlement_ind.value;

	if(non_ins_settlement_ind == 'X' || non_ins_settlement_ind == 'R')
	{
		var cust_curr_desc = document.forms[0].cust_curr_desc.value;

		if(cust_curr_desc != "")
		{
			document.getElementById('cust_curr_desc_disp').style.display="inline";
			document.getElementById('cust_curr_desc_val').innerText=cust_curr_desc;
		}
		else
		{
			document.getElementById('cust_curr_desc_disp').style.display="none";
			document.getElementById('cust_curr_desc_val').innerText="";
		}
	}
}

function enablectrlbut()
{
	parent.parent.parent.frames[0].document.getElementById('modify_button').disabled = false;
	parent.parent.parent.frames[0].document.getElementById('close_button').disabled = false;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<%

		if(operation.equals("Update"))
		{if(!("Y").equalsIgnoreCase(payerGrpBySetup))
		{
			%>
<body onLoad='disableAllElements();curr_desc_1(); disable();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<%
			}
			else{
				%>	
				<body onLoad='curr_desc_1(); disable();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
				<%
			}
		}
		else
		{
%>
<body onLoad='dfltslmt();curr_desc_1(); disable();' onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
		}
%>
<form name='PatFinCase4Form' id='PatFinCase4Form' method='post' action=''  scrolling=no >
<table border='0' cellpadding='1' cellspacing='0' width='100%'>
<%
	if(!(non_ins_settlement_ind.equals("C")))
	{
		if ( non_ins_settlement_ind.equals("R") ) 
		{
//			System.out.println("Inside R");

			if ( mcust_4 != null )
			{		
//6/10/2008		query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = '"+mcust_4+"' and (b.cust_group_code='"+mcust_group_4+"' or '"+mcust_group_4+"' is null)";	

				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'Y' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = ? and (b.cust_group_code=? or ? is null)";	
		
				pstmt = con.prepareStatement(query_cust) ;
				pstmt.setString(1, locale);
				pstmt.setString(2, strModuleId);
				pstmt.setString(3, strModuleId);
				pstmt.setString(4, strModuleId);
				pstmt.setString(5, mcust_4);
				pstmt.setString(6, mcust_group_4);
				pstmt.setString(7, mcust_group_4);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						non_ins_cust_code = rs.getString( "cust_code" ) ;
						non_ins_short_name = rs.getString( "short_name" ) ;
						non_ins_cust_group_code = rs.getString( "CUST_GROUP_CODE" ) ;
						non_ins_cust_group_desc = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;	
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;

				if (non_ins_cust_code == null ) non_ins_cust_code = "";
				if (non_ins_short_name == null ) non_ins_short_name = "";		
				if (non_ins_cust_group_code == null ) non_ins_cust_group_code = "";	
				if (non_ins_cust_group_desc == null ) non_ins_cust_group_desc = "";	
				if(cust_valid_from_date == null) cust_valid_from_date = "";
				if(cust_valid_to_date == null) cust_valid_to_date = "";
			}
		}
		else if (non_ins_settlement_ind.equals("X") && non_ins_adm_flag.equals("1"))
		{
//			System.out.println("Inside X 1");

			if ( mcust_4 != null )
			{		
//6/10/2008		query_cust="select a.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b where a.language_id = b.language_id and a.language_id='"+locale+"' and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or ('"+strModuleId+"' = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = '"+mcust_4+"' and (b.cust_group_code='"+mcust_group_4+"' or '"+mcust_group_4+"' is null)";

				query_cust="select c.cust_code cust_code, a.short_name short_name,to_char(VALID_FROM,'dd/mm/yyyy') VALID_FROM,to_char(VALID_TO,'dd/mm/yyyy') VALID_TO,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_DESC from ar_customer_lang_vw a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c where a.language_id = b.language_id and a.language_id=? and b.cust_group_code = c.cust_group_code and a.cust_code = c.cust_code and a.patient_flag = 'Y' and a.pat_com_flag = 'N' and nvl (a.insurance_yn,'N') = 'N' and a.status is null and ((? in ('OP','AE') and nvl(a.op_yn,'N') = 'Y') or (? in ('IP','DC') and nvl(a.ip_yn,'N') = 'Y') or (? = 'MP' and nvl(a.ref_yn,'N') = 'Y')) and a.cust_code = ? and (b.cust_group_code=? or ? is null)";
		
				pstmt = con.prepareStatement(query_cust) ;
				pstmt.setString(1, locale);
				pstmt.setString(2, strModuleId);
				pstmt.setString(3, strModuleId);
				pstmt.setString(4, strModuleId);
				pstmt.setString(5, mcust_4);
				pstmt.setString(6, mcust_group_4);
				pstmt.setString(7, mcust_group_4);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{
					while( rs.next() ) 
					{
						non_ins_cust_code = rs.getString( "cust_code" ) ;
						non_ins_short_name = rs.getString( "short_name" ) ;
						non_ins_cust_group_code = rs.getString( "CUST_GROUP_CODE" ) ;
						non_ins_cust_group_desc = rs.getString( "CUST_GROUP_DESC" ) ;
						cust_valid_from_date = rs.getString( "VALID_FROM" ) ;	
						cust_valid_to_date = rs.getString( "VALID_TO" ) ;		
					}
				}
				if(rs !=null) rs.close();
				pstmt.close() ;

				if (non_ins_cust_code == null ) non_ins_cust_code = "";
				if (non_ins_short_name == null ) non_ins_short_name = "";		
				if (non_ins_cust_group_code == null ) non_ins_cust_group_code = "";	
				if (non_ins_cust_group_desc == null ) non_ins_cust_group_desc = "";	
				if(cust_valid_from_date == null) cust_valid_from_date = "";
				if(cust_valid_to_date == null) cust_valid_to_date = "";
			}
		}

		if(!mcust_4.equals(""))
		{
			String cust_curr_desc_qry="Select CURRENCY_CODE,CURRENCY_DESC from ar_customer_lang_vw where cust_code=? and language_id=? ";
//			System.out.println("cust_curr_desc_qry:"+cust_curr_desc_qry);
			pstmt = con.prepareStatement( cust_curr_desc_qry ) ;
			pstmt.setString(1, mcust_4);
			pstmt.setString(2, locale);
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() ) 
				{
					str_cust_curr_code = rs.getString(1);
					str_cust_curr_desc = rs.getString(2);
				}
				if(str_cust_curr_code == null) str_cust_curr_code="";
				if(str_cust_curr_desc == null) str_cust_curr_desc="";

				if (rs != null) rs.close();
					pstmt.close();	
			}	
		}
//		System.out.println("str_cust_curr_code:"+str_cust_curr_code);
//		System.out.println("str_cust_curr_desc:"+str_cust_curr_desc);
%>	
<td align='left' class='COLUMNHEADER' colspan='6'><fmt:message key="eBL.NON_INS_FRAME_TITLE.label" bundle="${bl_labels}"/></td>
	<tr>	
		<td width="25%" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></div></td>
		<td width="25%" class="fields">
			
				<select name='search_by_items' id='search_by_items' onChange='srch_by_crit_for_cust();'>
<!--
					<option value='CG' SELECTED><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></option>
-->
					<option value='CY'><fmt:message key="Common.country.label" bundle="${common_labels}"/></option>
					<option value='RN' SELECTED><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></option>
				</select>
		</td>

		<td width="25%" class="label"><b id='srch_by_leg'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
		<td width="25%" class='fields' ><input type='text' name="srch_by_desc" id="srch_by_desc" maxlength='30' size='30'  tabindex='0' value="" onBlur="return srchbylkup('B')"><input type='button' class='button' name="srchbybut" id="srchbybut" value='?' onClick="return srchbylkup('C')" tabindex='0'><input type= 'hidden' name="search_code" id="search_code"  value=""></td>			
	</tr>

	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></div></td>
		<td width="25%" class="fields"><input type='text' name="non_ins_cust_group_desc" id="non_ins_cust_group_desc" maxlength='15' size='30'  tabindex='0' value="<%=non_ins_cust_group_desc%>" onBlur="return noninscustgrouplkup('B')"><input type='button' class='button' name="cust1but" id="cust1but" value='?' onClick="return noninscustgrouplkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'><input type= 'hidden' name="non_ins_cust_group_code" id="non_ins_cust_group_code"  value="<%=non_ins_cust_group_code%>"></td>
		<td width="25%">&nbsp;</td>
		<td width="25%">&nbsp;</td>
	</tr>

	<tr> 
		<td width="25%" class="label"><a href="javascript:getCustDet();"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<div id="cust_curr_desc_disp" style="display:none"><Font color='red'><b id="cust_curr_desc_val"></b></font></div>	
		<input type='hidden' name='Case_1' id='Case_1' value='1'></td>
		<td width="25%" class='fields' nowrap><input type='text' name="cust_4_desc" id="cust_4_desc" maxlength='40' size='30'  tabindex='0' value="<%=non_ins_short_name%>" onBlur="return noninscustlkup('B')"><input type='button' class='button' name="cust1but" id="cust1but" value='?' onClick="return noninscustlkup('C')" tabindex='0'><img src='../../eCommon/images/mandatory.gif'></td>

		<input type= 'hidden' name="cust_4" id="cust_4"  value="<%=non_ins_cust_code%>">
		<input type='hidden' name='cust_curr_code' id='cust_curr_code' value="<%=str_cust_curr_code%>">
		<input type= "hidden" name="cust_curr_desc" id="cust_curr_desc"  value="<%=str_cust_curr_desc%>">
		<input type= 'hidden' name="non_ins_cust_valid_from_date" id="non_ins_cust_valid_from_date"  value="<%=cust_valid_from_date%>">
		<input type= 'hidden' name="non_ins_cust_valid_to_date" id="non_ins_cust_valid_to_date"  value="<%=cust_valid_to_date%>">

		<td width="25%" class="label"><fmt:message key="eBL.CREDIT_DOC_REF.label" bundle="${bl_labels}"/></td>
<%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
<!--
	      <td width="25%" class='fields'><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='30' maxlength='30' value="<%=mcredit_doc_ref3%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
	      <td width="25%" class='fields'><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='30' maxlength='30' value="<%=mcredit_doc_ref3%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
<%
			}
			else
			{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='30' maxlength='30' onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif' ></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='30' maxlength='30' onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)'><img src='../../eCommon/images/mandatory.gif' ></td>
<%
			}
%>
	</tr>
<%
		}
		else if(non_ins_settlement_ind.equals("C"))
		{
%>
	<td colspan='15' class='COLUMNHEADER'><fmt:message key="eBL.NON_INS_FRAME_TITLE.label" bundle="${bl_labels}"/></td>
	<tr>
		<td width="25%" class="label"><fmt:message key="Common.SettlementType.label" bundle="${common_labels}"/><input type='hidden' name='Case_1' id='Case_1' value='2'></td>
		<td width="25%" class='fields' ><select name='cash_set_type2' id='cash_set_type2' ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			
			pstmt = con.prepareStatement( "Select dflt_slmt_type_code from bl_blng_grp where BLNG_GRP_ID=? "); 
			pstmt.setString(1, non_insur_blng_grp);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					dflt_slmt_type_code=rs2.getString(1) ;
//					System.out.println("dflt_slmt_type_code:"+dflt_slmt_type_code);
					if(dflt_slmt_type_code==null) dflt_slmt_type_code="";
				}
			}
			
			if(rs2 !=null) rs2.close();
			pstmt.close() ;

			pstmt = con.prepareStatement( "Select slmt_type_code, short_desc, cash_slmt_flag from bl_slmt_type_lang_vw where language_id=? and status is null order by short_desc " ) ;
			pstmt.setString(1, locale);
			rs2 = pstmt.executeQuery() ;
			if( rs2 != null ) 
			{
				while( rs2.next() ) 
				{
					slmt_type_code = rs2.getString( "slmt_type_code" ) ;
					String short_desc = rs2.getString( "short_desc" ) ;
					cash_slmt_flag=rs2.getString("cash_slmt_flag") ;
					//if(billing_mode.equals("Modify"))
					//{
						if(mcash_set_type2.equals(slmt_type_code))
						{
							out.println("<option selected value=\""+slmt_type_code+""+cash_slmt_flag+"\">"+short_desc+"</option>");
						}
						else
						{
							out.println( "<option value='"+slmt_type_code+""+cash_slmt_flag+"' >" + short_desc ) ;
						}
				}
			}
			if(rs2 != null) rs2.close();
			pstmt.close() ;
%>      
	</select><img src='../../eCommon/images/mandatory.gif'></td>

	<% 
		/***
			The Following code is added by Murugavel on
			11 Aug 2002	for the above requirements
			Purpose : If the Customer has the Credit Doc Required flag
						Yes., then it is mandatory for him to 
						provide the cred doc date and the 
						reference
			New Variables: strCreditDoc_YN.
			New Hidden Form field: credit_doc_yn

		***/
			
			if (strCreditDoc_YN.equals("Y"))		
			{
%>

		<td width="25%" class="label"><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='15' maxlength='30' value="<%=mcredit_doc_ref3%>" onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='15' maxlength='30' value="<%=mcredit_doc_ref3%>" onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
<%
				}
				else
				{
%>
<!--
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='15' maxlength='30' onKeyPress='return CheckForSpecChars_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
-->
		<td width="25%" class='fields' ><input type='text' name='credit_doc_ref3' id='credit_doc_ref3' size='15' maxlength='30' onKeyPress='return CheckForSpecCharsAllNotAlwSpc_local(event)'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>    
<%
				}	// Modify operation end if;
			}	// Credit Doc_YN end if;
		}	// Settlement Ind. end if

		if (strCreditDoc_YN.equals("Y") || (!(non_ins_settlement_ind.equals("C"))))		
		{
%>
	<tr>
		<td width="25%" class="label"><fmt:message key="eBL.DOC_START_DATE.label" bundle="${bl_labels}"/></td>
<%
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
	   <td width="25%" class='fields' ><input type='text' name='credit_doc_st_date3' id='credit_doc_st_date3' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_st_date3,"DMY","en",locale)%>'' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);'><img  src="../../eCommon/images/CommonCalendar.gif" onBlur="return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);" onClick="return showCalendar_loc('credit_doc_st_date3',document.forms[0].credit_doc_st_date3);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_st_date3' id='credit_doc_st_date3' size='10' maxlength='10' onBlur='return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);'><img  name='stdate3but'  src="../../eCommon/images/CommonCalendar.gif" onBlur="return chkDtLessEqualThanEncDateNew(document.forms[0].credit_doc_st_date3,document.forms[0].encounter_date_aft_trunc);" onClick="return showCalendar_loc('credit_doc_st_date3',document.forms[0].credit_doc_st_date3);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
%>		
		<td width="25%"  class="label"><fmt:message key="eBL.DOC_END_DATE.label" bundle="${bl_labels}"/></td>
<%	
			if((billing_mode.equals("Modify")) || (operation.equals("Update")))
			{
%>
		<td width="25%" class='fields' ><input type='text' name='credit_doc_date3' id='credit_doc_date3' size='10' maxlength='10' value='<%=com.ehis.util.DateUtils.convertDate(mcredit_doc_date3,"DMY","en",locale)%>' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);'><img  src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);'  onClick="return showCalendar_loc('credit_doc_date3',document.forms[0].credit_doc_date3);"><img src='../../eCommon/images/mandatory.gif'></td>
<%
			}
			else
			{
%>
		<td width="25%" class='fields'><input type='text' name='credit_doc_date3' id='credit_doc_date3' size='10' maxlength='10' onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);'><img  src="../../eCommon/images/CommonCalendar.gif" onBlur='return chkDtGreaterEqualThanEncDateNew(document.forms[0].credit_doc_date3,document.forms[0].encounter_date_aft_trunc);'   onClick="return showCalendar_loc('credit_doc_date3',document.forms[0].credit_doc_date3);"><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
<%
			}
		}
		else
		{
%>	
		<td width="" class="label"></td>
		<td width=""  colspan="5" class="label"></td>	
    
<%
		}
%>
	</tr>

	<tr>
		<td colspan="15"></td>
	</tr>
	<tr>
		<td colspan="15"></td>
	</tr>
	<tr>
		<td colspan="15"></td>
	</tr>
	<tr>
		<td colspan="15"></td>
	</tr>
	<tr>
		<td colspan="15"></td>
	</tr>

<input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value='<%=strCreditDoc_YN%>'>	
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>		
<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type=hidden name='operation' id='operation'	value='<%=operation%>'>
<input type=hidden name='billing_mode' id='billing_mode' 	value='<%=billing_mode%>'>
<input type='hidden' name="dflt_slmt_type_code" id="dflt_slmt_type_code"  value='<%=dflt_slmt_type_code%>'>
<input type='hidden' name="non_ins_settlement_ind" id="non_ins_settlement_ind"  value='<%=non_ins_settlement_ind%>'>
<input type='hidden' name="non_ins_adm_flag" id="non_ins_adm_flag"  value='<%=non_ins_adm_flag%>'>
<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value='<%=encounter_date_aft_trunc%>'>
<input type='hidden' name='calling_module_id' id='calling_module_id' value='<%=strModuleId%>'>
<input type='hidden' name="function_id" id="function_id" value='<%=str_function_id%>'>	
<input type='hidden' name='sel_frm_prev_enc' id='sel_frm_prev_enc' value='<%=sel_frm_prev_enc%>'>

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='autoFinChk' id='autoFinChk' value='<%=autoFinChk%>'>
<%
	/*	String query_cash_slmt_type="Select cash_slmt_flag from bl_slmt_type where 				slmt_type_code='"+slmt_type_code+"'";
		stmt=con.createStatement();
		rs21=stmt.executeQuery(query_cash_slmt_type);
		if(rs21 != null)
		{
			while(rs21.next())
			{
				cash_slmt_flag=rs21.getString("cash_slmt_flag");
			}
		}
		if(!(cash_slmt_flag.equals("CASH")))
		{
		%->
		<tr>
			<td width="50%" align="right" class="label">Cash Instrument Ref</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_ref' id='cash_insmt_ref' size='15' maxlength='15'></td>
			</tr>
		<tr>
			<td width="50%" align="right" class="label">Cash Instrument Date</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_date' id='cash_insmt_date' size='15' maxlength='15'></td>
		</tr>
		<tr>
			<td width="50%" align="right" class="label">Cash Instrument Remarks</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_rmks' id='cash_insmt_rmks' size='15' maxlength='15'>
			</td>
		</tr>
		<%
		}
		*/
		%>
			
<% 
	} 
	catch(Exception e )
	{ 
	e.printStackTrace();
		out.println(e);
	}
	finally
	{
		if(stmt   != null)stmt.close();
		if(pstmt  != null)pstmt.close();
		if(pstmt1 != null)pstmt1.close();	
		ConnectionManager.returnConnection(con, request);
	}
	%> 
</table>
</form>
</body>
</html>
	


