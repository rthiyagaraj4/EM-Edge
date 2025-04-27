function reset()
{
	search_frame.location.reload();
}	

function userValidation(obj,blng_serv_code,serv_item_code,cld_frm)
{	
	var user_name = document.forms[0].adhoc_user_id.value;
	var pass_wrd = document.forms[0].user_password.value;

	var module_id = document.forms[0].module_id.value;
	var cal_frm_obj="";
	if(cld_frm=="U")
	{
		cal_frm_obj=obj.value;		
	}
	else if(cld_frm=="P")
	{
		cal_frm_obj=obj.value;	

		if(cal_frm_obj != '' && user_name == '')
		{
			alert(getMessage("BL9112","BL"));
			return false;
		}
	}

	if(cal_frm_obj != "")
	{
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();			
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var param="user_name="+user_name+"&blng_serv_code="+blng_serv_code+"&serv_item_code="+serv_item_code+"&pass_wrd="+pass_wrd+"&called_frm=user_pass&module_id="+module_id;
		var temp_jsp="../../eBL/jsp/BLAdhocDiscValidation.jsp?"+param;			
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText = trimString(xmlHttp.responseText);		
//		eval(xmlHttp.responseText);
		var arr_msg = new Array();
		arr_msg=responseText.split("|");

		var valid_user_mess = arr_msg[0];
		if(valid_user_mess == " ") valid_user_mess="";
		
		var valid_password_mess=arr_msg[1];	
		if(valid_password_mess == " ") valid_password_mess="";

		var disc_allwd = arr_msg[2];
		if(disc_allwd == " ") disc_allwd="";

		if(valid_user_mess != "")
		{
			alert(getMessage(valid_user_mess,"BL"));
//			document.forms[0].adhoc_user_id.select();			
			return false;
		}
		else
		{
			if(pass_wrd == "")
			{
				document.forms[0].user_password.disabled = false;
//				document.forms[0].user_password.focus();
			}
		}

		if(valid_password_mess != "")
		{
			alert(getMessage(valid_password_mess,"BL"));
			document.forms[0].user_password.disabled = false;
			document.forms[0].user_password.value="";
//			document.forms[0].user_password.focus();
			return false;
		}

		if(disc_allwd != "")
		{
			alert(getMessage(disc_allwd,"BL"));
//			document.forms[0].adhoc_user_id.select();			
			return false;
		}

		if(valid_user_mess == "" && valid_password_mess == "")
		{
			var serv_max_disc_per  = arr_msg[3];
			var serv_max_disc_amt  = arr_msg[4];
			var payer_max_disc_per = arr_msg[5];
			var payer_max_disc_amt = arr_msg[6];

			document.forms[0].serv_max_disc_per.value = serv_max_disc_per;
			document.forms[0].serv_max_disc_amt.value = serv_max_disc_amt;
			document.forms[0].payer_max_disc_per.value = payer_max_disc_per;
			document.forms[0].payer_max_disc_amt.value = payer_max_disc_amt;

//			document.forms[0].adhoc_disc_perc.disabled=false;
			document.forms[0].adhoc_disc_amt.disabled=false;
		}
		return true;
	}
/*
	else
	{
		if(cld_frm=="U")
		{
			alert(getMessage("BL9112","BL"));
			document.forms[0].adhoc_user_id.focus();
			return false;
		}
		else
		{
			alert(getMessage("BL9541","BL"));
			document.forms[0].user_password.focus();
			return false;
		}
	}
*/
}

function disc_amt_valiation(disc_amt,act_gross_amt,serv_max_disc_per,serv_max_disc_amt,payer_max_disc_per,payer_max_disc_amt,called_frm_frame)
{	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var param="disc_amt="+disc_amt+"&act_gross_amt="+act_gross_amt+"&serv_max_disc_per="+serv_max_disc_per+"&serv_max_disc_amt="+serv_max_disc_amt+"&payer_max_disc_per="+payer_max_disc_per+"&payer_max_disc_amt="+payer_max_disc_amt+"&called_frm_frame="+called_frm_frame+"&called_frm=disc_amt";
	var temp_jsp="../../eBL/jsp/BLAdhocDiscValidation.jsp?"+param;			
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);		
	
	if(responseText != "")
	{
		alert(getMessage(responseText,"BL"));
		document.forms[0].adhoc_disc_amt.value="";
//		document.forms[0].adhoc_disc_amt.select();
		return false;
	}
	return true;
}

function refresh_payer_disc(i,trx_doc_ref,trx_doc_ref_line_no,trx_doc_ref_seq_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id)
{	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var param="sel_rec="+i+"&trx_doc_ref="+trx_doc_ref+"&trx_doc_ref_line_no="+trx_doc_ref_line_no+"&trx_doc_ref_seq_no="+trx_doc_ref_seq_no+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&called_frm=refresh_payer_disc";
	var temp_jsp="../../eBL/jsp/BLAdhocDiscValidation.jsp?"+param;			
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);		
	
	if(responseText != "")
	{
		return responseText;
	}
}

function refresh_serv_disc(i,trx_doc_ref,trx_doc_ref_line_no,existing_reason_code,patient_id,episode_type,episode_id,visit_id)
{	
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();			
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var param="sel_rec="+i+"&trx_doc_ref="+trx_doc_ref+"&trx_doc_ref_line_no="+trx_doc_ref_line_no+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&called_frm=refresh_serv_disc";
	var temp_jsp="../../eBL/jsp/BLAdhocDiscValidation.jsp?"+param;			
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText = trimString(xmlHttp.responseText);		
	
	if(responseText != "")
	{
		return responseText;
	}
}

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function putdeci(object)
	{
		if(object.value!='')
		{
			var decimal=document.forms[0].noofdecimal.value;
			putDecimal(object,17,decimal);
		}
	}
