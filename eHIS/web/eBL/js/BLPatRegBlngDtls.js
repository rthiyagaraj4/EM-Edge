function reset()
{
	 PatRegBlngDtlsMainFrame.document.location.reload();
}

function localTrimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function create()
{
	commontoolbarFrame.document.forms[0].apply.disabled=false;
	var formObj = document.forms[0];
	PatRegBlngDtlsMainFrame.location.href="../../eBL/jsp/BLPatientRegnBillingDtlsFrame.jsp?mode=insert";
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	commontoolbarFrame.document.forms[0].reset.disabled=false;
	var formObj = document.forms[0];
	PatRegBlngDtlsMainFrame.location.href="../../eBL/jsp/BLPatRegBlngDtlsQueryCriteria.jsp"
}

function apply()
{
	var err_mess="";

	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].pat_ser_code.value == "")
	{
		err_mess = getMessage("PAT_SER_NOT_CREATED","MP")+"<br>";
	}

	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].blng_grp_code.value == "")
	{
		err_mess += getMessage("BL9301","BL")+"<br>";
	}

	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].blng_grp_code.value != "" && PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].blng_grp_code.value == '**')
	{
		if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_grp_code.value == "" && PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_code.value != "")
		{
			err_mess += getMessage("BL6277","BL")+"<br>";
		}
		else if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_grp_code.value != "" && PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_code.value == "")
		{
			err_mess += getMessage("BL9532","BL")+"<br>";
		}
		else
		{
			if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_grp_code.value == "")
				PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_grp_code.value = "**";
			if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_code.value == "")
				PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_code.value = "**";
		}
	}
	else
	{
		if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].slmt_ind.value != "C")
		{
			if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_grp_code.value == "")
			{
				err_mess += getMessage("BL6277","BL")+"<br>";
			}

			if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].slmt_ind.value != "C" && PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_code.value == "")
			{
				err_mess += getMessage("BL9532","BL")+"<br>";
			}
		}
		else
		{
			PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_grp_code.value = "**";
			PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].payer_code.value = "**";
		}
	}
/*
	if((PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].chargeble_yn.checked==false && PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].charge_non_chargeable_yn.checked==false))
	{
		err_mess += "Patient Registration Chargeable at Registration/Encounter should be selected"+"<br>";
	}
*/
	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].chargeble_yn.checked==false && PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].charge_non_chargeable_yn.checked==false)
	{
		if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].serv_panel_code.value != "")
		{
			err_mess += getMessage("BL7185","BL")+"<br>";
		}
	}

	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].chargeble_yn.checked == true || PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].charge_non_chargeable_yn.checked == true)
	{
		if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].serv_panel_code.value=="" || PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].serv_panel_code.value=="")
		{
			err_mess += getMessage("BL6253","BL");
		}
	}

	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].chargeble_dur_renwel.checked == true) {
		if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].renewal_code.value=="") {
			err_mess += getMessage("BL0818","BL");
		}
	}

	if(err_mess=="")
	{
		PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].submit();
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	}
}

function onSuccess()
{
	if(PatRegBlngDtlsMainFrame.PatRegBilDtlMain.document.forms[0].mode.value=="insert")
		PatRegBlngDtlsMainFrame.location.href="../../eBL/jsp/BLPatientRegnBillingDtlsFrame.jsp?mode=insert";
	else
         PatRegBlngDtlsMainFrame.location.reload();
}

function pat_series_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].pat_ser_code ;
	var target = document.forms[0].pat_ser_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].pat_ser_desc.value='';
			document.forms[0].pat_ser_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("eMP.PatientSeries.label","MP"); 
	title=encodeURIComponent(title);		
		
	sql = "select PAT_SER_GRP_CODE PAT_SER_GRP_CODE,SHORT_DESC SHORT_DESC from MP_PAT_SER_GRP_LANG_VW where language_id='"+locale+"'";	

	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
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

function blng_grp_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].blng_grp_code ;
	var target = document.forms[0].blng_grp_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].blng_grp_desc.value='';
			document.forms[0].blng_grp_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var cash_leg=getLabel("eBL.CASH.label","BL");
	cash_leg=encodeURIComponent(cash_leg);
	var credit_leg=getLabel("eBL.CREDIT.label","BL");
	credit_leg=encodeURIComponent(credit_leg);
	var sponsor_leg=getLabel("eBL.SPONSOR.label","BL");
	sponsor_leg=encodeURIComponent(sponsor_leg);
	var ins_leg=getLabel("Common.Insurance.label","common");
	ins_leg=encodeURIComponent(ins_leg);

	var title=getLabel("Common.BillingGroup.label","common"); 
	title=encodeURIComponent(title);		
		
	sql = "select blng_grp_id BLG_GP,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"','**','All')||')' SRT_DESC,SETTLEMENT_IND SLMT_IND,ADM_REC_FLAG ADM_REC_FLAG from BL_BLNG_GRP_ALL_LANG_VW a WHERE a.language_id='"+locale+"'";	

	var column_sizes = escape("30%,70%,0%,0%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var slmt_ind="Settlement Indicator";
	desc=encodeURIComponent(desc);
	var adm_rec_flg="Adm Rec Flag";
	adm_rec_flg=encodeURIComponent(adm_rec_flg);

	column_descriptions = code+","+desc+","+slmt_ind+","+adm_rec_flg;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYNN";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
		document.forms[0].slmt_ind.value = arr[2];
		document.forms[0].adm_rec_flag.value = arr[3];
	}
	else
	{	
		target.value='';
		target_code.value = '';
		document.forms[0].slmt_ind.value = '';
		document.forms[0].adm_rec_flag.value = '';
	}

	if(target.value != '')
	{
		if(document.forms[0].slmt_ind.value == 'C')
		{
			document.forms[0].pyr_grp_desc.disabled = true;
			document.forms[0].pyrgrpbut.disabled = true;

			document.forms[0].payer_desc.disabled = true;
			document.forms[0].payerbut.disabled = true;
		}
		else
		{
			document.forms[0].pyr_grp_desc.disabled = false;
			document.forms[0].pyrgrpbut.disabled = false;

			document.forms[0].payer_desc.disabled = false;
			document.forms[0].payerbut.disabled = false;
		}
	}
	else
	{
		document.forms[0].pyr_grp_desc.disabled = false;
		document.forms[0].pyrgrpbut.disabled = false;

		document.forms[0].payer_desc.disabled = false;
		document.forms[0].payerbut.disabled = false;
	}

	if(document.forms[0].slmt_ind.value !="C")
	{
		document.getElementById("payer_grp_mand_yn").style.visibility = "visible";
		document.getElementById("payer_mand_yn").style.visibility = "visible";
	}
	else
	{
		document.getElementById("payer_grp_mand_yn").style.visibility = "hidden";
		document.getElementById("payer_mand_yn").style.visibility = "hidden";
	}

	document.forms[0].pyr_grp_desc.value = "";
	document.forms[0].payer_grp_code.value = "";
	document.forms[0].payer_desc.value = "";
	document.forms[0].payer_code.value = "";
}

/*
function blng_grp_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].blng_grp_code ;
	var target = document.forms[0].blng_grp_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].blng_grp_desc.value='';
			document.forms[0].blng_grp_code.value = '';
			return;
		}
	}

	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	
	var cash_leg=getLabel("eBL.CASH.label","BL");
	cash_leg=encodeURIComponent(cash_leg);
	var credit_leg=getLabel("eBL.CREDIT.label","BL");
	credit_leg=encodeURIComponent(credit_leg);
	var sponsor_leg=getLabel("eBL.SPONSOR.label","BL");
	sponsor_leg=encodeURIComponent(sponsor_leg);
	var ins_leg=getLabel("Common.Insurance.label","common");
	ins_leg=encodeURIComponent(ins_leg);

	var title=getLabel("Common.BillingGroup.label","common"); 
	title=encodeURIComponent(title);	

	var sql1="SELECT code, description FROM (SELECT '*ALL' code, 'All' description FROM DUAL UNION select blng_grp_id code,short_desc||'('||decode(settlement_ind||adm_rec_flag, 'C','"+cash_leg+"', 'C0','"+cash_leg+"','C1','"+cash_leg+"','C2','"+cash_leg+"','R', '"+credit_leg+"','R0', '"+credit_leg+"','R1', '"+credit_leg+"','R2', '"+credit_leg+"','X1', '"+sponsor_leg+"','X2','"+ins_leg+"')||')' description from BL_BLNG_GRP_LANG_VW a WHERE a.language_id='"+locale+"' AND nvl(status,'X' )!='S' and upper(blng_grp_id) like upper(?) and upper(long_desc) like upper(?))"; 

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = DESC_CODE;				
	retArray = CommonLookup( title, argArray );	

	if(retArray != null && retArray !="")
	{
		target.value=retArray[1];
		target_code.value = retArray[0];
	}
	else
	{	
		target.value='';
		target_code.value = '';
	}
}
*/
function payer_grp_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].payer_grp_code ;
	var target = document.forms[0].pyr_grp_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].pyr_grp_desc.value='';
			document.forms[0].payer_grp_code.value = '';
			return;
		}
	}

	if(document.forms[0].blng_grp_code.value == "")
	{
		alert(getMessage("BL9301","BL"));
		return false;
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("eBL.CUSTOMER_GROUP.label","BL");
	title=encodeURIComponent(title);	
		
//	sql = "select cust_group_code CUST_GRP_CODE,short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"+locale+"' and status is null";
	sql = "select CUST_GRP_CODE CUST_GRP_CODE,SHORT_NAME SHORT_NAME from ar_cust_group_all_lang_vw  where  language_id='"+locale+"'";

	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
		document.forms[0].payer_desc.value='';
		document.forms[0].payer_code.value ='';
	}
	else
	{	
		target.value='';
		target_code.value = '';
		document.forms[0].payer_desc.value='';
		document.forms[0].payer_code.value ='';
	}
}

function payer_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].payer_code ;
	var target = document.forms[0].payer_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].payer_desc.value='';
			document.forms[0].payer_code.value = '';
			return;
		}
	}

	if(document.forms[0].blng_grp_code.value == "")
	{
		alert(getMessage("BL9301","BL"));
		return false;
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("Common.Payer.label","common");
	title=encodeURIComponent(title);
	
	var slmt_ind = document.forms[0].slmt_ind.value;
	var adm_rec_flag = document.forms[0].adm_rec_flag.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;

	if(slmt_ind == "R" && adm_rec_flag=="")
	{
/*		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME"
			+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
			+" where a.language_id = b.language_id" 
			+" and a.language_id='"+locale+"'" 
			+" and b.cust_group_code = c.cust_group_code"
			+" and a.cust_code = c.cust_code" 
			+" and (b.cust_group_code='"+payer_grp_code+"' or '"+payer_grp_code+"' is null)"
			+" and a.patient_flag = 'Y'" 
			+" and a.pat_com_flag = 'Y'" 
			+" and nvl (insurance_yn,'N') = 'N'" 
			+" and a.status is null";
*/
		sql="select a.CUST_CODE CUST_CODE,a.SHORT_NAME SHORT_NAME,a.CUST_GROUP_CODE CUST_GROUP_CODE,a.CUST_GROUP_NAME CUST_GROUP_NAME"
			+" from AR_CUSTOMER_ALL_LANG_VW a"
			+" where a.language_id='"+locale+"'" 
			+" and (a.cust_group_code='"+payer_grp_code+"' or a.cust_code='**' or ('"+payer_grp_code+"' is null or '"+payer_grp_code+"' = '**'))"
			+" and (a.patient_flag = 'Y' or a.patient_flag is null)"
			+" and (a.pat_com_flag = 'Y' or a.pat_com_flag is null)"
			+" and (nvl (insurance_yn,'N') = 'N' or a.insurance_yn is null)";
//			+" and a.status is null";
	}
	else if(slmt_ind == "X" && adm_rec_flag=="1")
	{
/*		sql="select c.cust_code CUST_CODE,a.short_name SHORT_NAME,c.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME"
			+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_cust_by_cust_group c "
			+" where a.language_id = b.language_id" 
			+" and a.language_id='"+locale+"'" 
			+" and b.cust_group_code = c.cust_group_code"
			+" and a.cust_code = c.cust_code" 
			+" and (b.cust_group_code='"+payer_grp_code+"' or '"+payer_grp_code+"' is null)"
			+" and a.patient_flag = 'Y'" 
			+" and a.pat_com_flag = 'N'" 
			+" and nvl (insurance_yn,'N') = 'N'" 
			+" and a.status is null"; 
*/
		sql="select a.CUST_CODE CUST_CODE,a.SHORT_NAME SHORT_NAME,a.CUST_GROUP_CODE CUST_GROUP_CODE,a.CUST_GROUP_NAME CUST_GROUP_NAME"
			+" from AR_CUSTOMER_ALL_LANG_VW a"
			+" where a.language_id='"+locale+"'" 
			+" and (a.cust_group_code='"+payer_grp_code+"' or a.cust_code='**' or ('"+payer_grp_code+"' is null or '"+payer_grp_code+"' = '**'))"
			+" and (a.patient_flag = 'Y' or a.patient_flag is null)"
			+" and (a.pat_com_flag = 'N' or a.pat_com_flag is null)"
			+" and (nvl (insurance_yn,'N') = 'N' or a.insurance_yn is null)";
//			+" and a.status is null";
	}
	else if(slmt_ind == "X" && adm_rec_flag=="2")
	{
/*		sql="select DISTINCT d.cust_code CUST_CODE,a.short_name SHORT_NAME,b.cust_group_code CUST_GROUP_CODE,b.short_desc CUST_GROUP_NAME"
			+" from AR_CUSTOMER_DTL_LANG_VW a,ar_cust_group_lang_vw b,bl_ins_policy_type_hdr c,bl_cust_by_cust_group d,sy_acc_entity e"
			+" where a.acc_entity_code=b.acc_entity_code"
			+" and a.acc_entity_code=e.acc_entity_code"
			+" AND b.acc_entity_code=d.acc_entity_code" 
			+" and c.operating_facility_id=e.acc_entity_id"
			+" and a.language_id=b.language_id" 
			+" and a.language_id='"+locale+"'" 
			+" and b.cust_group_code=c.cust_group_code" 
			+" and c.cust_group_code=d.cust_group_code" 
			+" and (b.cust_group_code='"+payer_grp_code+"' or '"+payer_grp_code+"' is null)" 
			+" and a.cust_code=d.cust_code" 
			+" and (c.cust_code=d.cust_code or c.cust_code='**')" 
			+" and a.patient_flag='Y'" 
			+" and NVL(a.pat_com_flag,'N')='N'" 
			+" and nvl(a.insurance_yn,'Y')='Y'" 
			+" and a.status is null"; 
*/
		sql="select DISTINCT a.cust_code CUST_CODE,a.short_name SHORT_NAME,a.cust_group_code CUST_GROUP_CODE,a.cust_group_name CUST_GROUP_NAME"
			+" from AR_CUSTOMER_ALL_LANG_VW a,bl_ins_policy_type_hdr c,sy_acc_entity e"
			+" where c.operating_facility_id=e.acc_entity_id"
			+" and a.language_id='"+locale+"'" 
			+" and (a.cust_group_code='"+payer_grp_code+"' or a.cust_code='**' or ('"+payer_grp_code+"' is null or '"+payer_grp_code+"' = '**'))"
			+" and (c.cust_code=a.cust_code or c.cust_code='**')" 
			+" and (a.patient_flag = 'Y' or a.patient_flag is null)"
			+" and (a.pat_com_flag = 'N' or a.pat_com_flag is null)"
			+" and (nvl (insurance_yn,'N') = 'Y' or a.insurance_yn is null)";
//			+" and a.status is null"; 
	}
	else
	{
		sql="select a.CUST_CODE CUST_CODE,a.SHORT_NAME SHORT_NAME,a.CUST_GROUP_CODE CUST_GROUP_CODE,a.CUST_GROUP_NAME CUST_GROUP_NAME"
			+" from AR_CUSTOMER_ALL_LANG_VW a"
			+" where a.language_id='"+locale+"'";
	}

	var column_sizes = escape("20%,30%,20%,30%");
	var code=getLabel("eBL.PAYER_CODE.label","BL");
	code=encodeURIComponent(code);	
	var desc=getLabel("eBL.PAYER_DESC.label","BL");
	desc=encodeURIComponent(desc);
	var cust_group_code=getLabel("eBL.PAYER_GROUP_CODE.label","BL");
	cust_group_code=encodeURIComponent(cust_group_code);
	var cust_group=getLabel("eBL.PAYER_GROUP_DESC.label","BL");
	cust_group=encodeURIComponent(cust_group);

	column_descriptions = code+","+desc+","+cust_group_code+","+cust_group;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYYY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
	var arr=new Array();

	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];

		if(target_code.value == '**' && (document.forms[0].payer_grp_code.value == '' || document.forms[0].payer_grp_code.value == '**'))
		{
			document.forms[0].pyr_grp_desc.value=arr[1];
			document.forms[0].payer_grp_code.value =arr[0];
		}
		else
		{
			if(target_code.value != '**' && document.forms[0].payer_grp_code.value != '**')
			{
				document.forms[0].pyr_grp_desc.value=arr[3];
				document.forms[0].payer_grp_code.value =arr[2];
			}
		}
	}
	else
	{	
		target.value='';
		target_code.value = '';
//		document.forms[0].pyr_grp_desc.value='';
//		document.forms[0].payer_grp_code.value = '';
	}
}

function serv_panel_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;

	var target_code	= document.forms[0].serv_panel_code ;
	var target = document.forms[0].serv_panel_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].serv_panel_desc.value='';
			document.forms[0].serv_panel_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("eBL.BILLING_SERVICE_PANEL.label","BL");
	title=encodeURIComponent(title);
	
	var serv_panel_ind = document.forms[0].serv_panel_ind.value;
	var module_id = "MP";

	if(serv_panel_ind == "S")
	{
		sql="select a.BLNG_SERV_CODE BLNG_SERV_CODE,a.SHORT_DESC SHORT_DESC from BL_BLNG_SERV_LANG_VW a where a.LANGUAGE_ID='"+locale+"' and a.status is NULL";
	}
	else if(serv_panel_ind == "L")
	{
		sql="select a.PANEL_CODE PANEL_CODE,a.SHORT_DESC SHORT_DESC from BL_PANEL_HDR_LANG_VW a, BL_PANEL_HDR b where a.LANGUAGE_ID='"+locale+"' and a.status is NULL and a.PANEL_CODE=b.PANEL_CODE";
	}
	
	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
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

function change_pnl_serv_leg()
{
	var seld_option = document.forms[0].serv_panel_ind.value;
	if(seld_option == 'S')
	{
		document.getElementById("serv_leg").style.display='inline';
		document.getElementById("panel_leg").style.display='none';
	}
	else if(seld_option == 'L')
	{
		document.getElementById("serv_leg").style.display='none';
		document.getElementById("panel_leg").style.display='inline';
	}
	
	document.forms[0].serv_panel_code.value = "";
	document.forms[0].serv_panel_desc.value = "";
}

function check_item()
{
	if(document.forms[0].chargeble_yn.checked) {
		document.forms[0].charge_non_chargeable_yn.checked = false;
		document.forms[0].charge_non_chargeable_yn.disabled = true;
		//Commented V190401-MuthuKumarN/IN70056 & IN:070057
		//document.forms[0].chargeble_dur_renwel.checked = false;
		//document.forms[0].chargeble_dur_renwel.disabled = true;
		
	} else if(document.forms[0].charge_non_chargeable_yn.checked) {
		document.forms[0].chargeble_yn.checked = false;
		document.forms[0].chargeble_yn.disabled = true;
		//Commented V190401-MuthuKumarN/IN70056 & IN:070057
		//document.forms[0].chargeble_dur_renwel.disabled = true;
		//document.forms[0].chargeble_dur_renwel.checked = false;
		
	} else {
		document.forms[0].chargeble_yn.checked = false;
		document.forms[0].chargeble_yn.disabled = false;
		document.forms[0].charge_non_chargeable_yn.checked = false;
		document.forms[0].charge_non_chargeable_yn.disabled = false;
	}

	if(document.forms[0].chargeble_dur_renwel.checked)
	{
		//Added V190404-MuthuKumarN/AMRI-CRF-0357.1
		document.getElementById("renewDescLabel").style.visibility='visible';
		document.getElementById("renewDescText").style.visibility='visible';
		//document.getElementById("renewal_desc").value = '';
		//document.getElementById("renewal_code").value = '';
		//Added V190404-MuthuKumarN/AMRI-CRF-0357.1
		
	} else {
		document.getElementById("renewDescLabel").style.visibility='hidden';
		document.getElementById("renewDescText").style.visibility='hidden';
		document.getElementById("renewal_desc").value = '';
		document.getElementById("renewal_code").value = '';
	}
}

function renew_desc_lkup(clng_evnt)
{
	var locale = document.forms[0].locale.value;
	var target_code	= document.forms[0].renewal_code;
	var target = document.forms[0].renewal_desc;
	
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].renewal_desc.value='';
			document.forms[0].renewal_code.value = '';
			return;
		}
	}

	var message="";
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var title				= "";
	var column_descriptions = "";

	var title=getLabel("eBL.BILLING_SERVICE_PANEL.label","BL");
	title=encodeURIComponent(title);
	
	var serv_panel_ind = document.forms[0].serv_panel_ind.value;
	var module_id = "MP";

	if(serv_panel_ind == "S")
	{
		sql="select a.BLNG_SERV_CODE BLNG_SERV_CODE,a.SHORT_DESC SHORT_DESC from BL_BLNG_SERV_LANG_VW a where a.LANGUAGE_ID='"+locale+"' and a.status is NULL";
	}
	else if(serv_panel_ind == "L")
	{
		sql="select a.PANEL_CODE PANEL_CODE,a.SHORT_DESC SHORT_DESC from BL_PANEL_HDR_LANG_VW a, BL_PANEL_HDR b where a.LANGUAGE_ID='"+locale+"' and a.status is NULL and a.PANEL_CODE=b.PANEL_CODE";
	}
	
	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
	
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
