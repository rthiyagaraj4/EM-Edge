function payerGrpLkup(called_from){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var target = document.forms[0].payer_group;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&target='+target.value;	
	
	if(target.value == "" && called_from == 'D'){
		 document.forms[0].payer_grp_code.value = "";
		 return false;
	}		
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.PAYER_GROUP.label","BL");
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=PAYER_GROUP_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].payer_grp_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].payer_grp_code.value = "";
	}
}

function payerLkup(called_from){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;
	var target = document.forms[0].payer;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&payer_grp_code='+payer_grp_code+'&target='+target.value;	
	
	if(target.value == "" && called_from == 'D'){
		 document.forms[0].payer_code.value = "";
		 return false;
	}	
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.PAYER.label","BL");
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=PAYER_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].payer_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].payer_code.value = "";
	}
}

function policyLookup(called_from){
	
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var payer_grp_code = document.forms[0].payer_grp_code.value;
	var payer_code = document.forms[0].payer_code.value;
	var target = document.forms[0].policy;
	var qryParam = '&facility_id='+facility_id+'&locale='+locale+'&payer_grp_code='+payer_grp_code+'&payer_code='+payer_code+'&target='+target.value;	
	
	if(target.value == "" && called_from == 'D'){
		 document.forms[0].policy_type_code.value = "";
		 return false;
	}	
		
	
	var retVal				= new String();
	var dialogTop			= "40" ;
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+" dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				= "";
	
	var title = getLabel("eBL.POLICY_TYPE.label","BL");
	
	title = encodeURIComponent(title);
	
	var column_sizes = escape("70%,30%"); 
	
	var code_lbl = getLabel("Common.code.label","common");

	var desc_lbl=getLabel("Common.description.label","common");
	desc_lbl=encodeURIComponent(desc_lbl);
	
	var column_descriptions = desc_lbl+","+code_lbl;
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY"+qryParam;
	
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=POLICY_LKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	{
		retVal=unescape(retVal);
		var arr=retVal.split("^~^");
		target.value = arr[0];
		document.forms[0].policy_type_code.value = arr[1];
	}
    else
	{
		 target.value = "";
		 document.forms[0].policy_type_code.value = "";
	}
}
