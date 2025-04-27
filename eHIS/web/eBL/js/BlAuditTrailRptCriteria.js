/* Created JS against NMC-JD-CRF-0010.1 */

async function payerGroupLookup()
{
	var formObj  =  document.forms[0];
	var sql;		
	sql = "select cust_group_code code,LONG_DESC description from ar_cust_group_lang_vw  where  language_id='"+document.forms[0].locale.value+"' and upper(cust_group_code) like upper(?) and upper(LONG_DESC) like upper(?) order by 1";

	var title									= 	getLabel("eBL.PAYER_GROUP.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.payer_grp_desc.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										= await  CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}				
 
	if(retVal != null && retVal != "")
	{
		formObj.p_payer_grp_code.value			= 	arr[0];
		formObj.payer_grp_desc.value			=  	arr[1];
	}
	else
	{
		formObj.p_payer_grp_code.value = arr[0]; 
		formObj.payer_grp_desc.value = arr[1]; 
		//formObj.p_payer_grp_code.value			= 	"";
		//formObj.payer_grp_desc.value			=  	"";			
	}	    
}	

async function payerLookup(custgrp)
{
	var sql;
	var formObj		=  document.forms[0];
	var custgrpcode ; 
	if(custgrp != 'undefined' || custgrp !=null)
	{
	custgrpcode = custgrp.value;
	
	sql = "select CUST_CODE code,LONG_NAME description from AR_CUSTOMER_LANG_VW  where CUST_GROUP_CODE = '"+custgrpcode+"' AND STATUS IS NULL AND language_id='"+document.forms[0].locale.value+"' and upper(CUST_CODE) like upper(?) and upper(LONG_NAME) like upper(?) order by 1";
	var title									= 	getLabel("Common.Payer.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.cust_desc.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										= await  CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}		
	if(retVal != null && retVal != "")
	{
		formObj.p_cust_code.value	=arr[0];
		formObj.cust_desc.value		=arr[1];
	}
	else
	{
		formObj.p_cust_code.value = arr[0]; 
		formObj.cust_desc.value = arr[1]; 
		//formObj.p_cust_code.value	="";
		//formObj.cust_desc.value		="";
	}
	}	
}	
	
async function policyLookup(custdesc,custgrp)
{	

	var formObj			=  document.forms[0];
	var sql;
	custgrpcode = formObj.p_cust_code.value;
	custdesc=formObj.p_payer_grp_code.value;
	//Query policy based on payer and payer grp
	var sql=" select distinct a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+document.forms[0].locale.value+"' AND b.cust_group_code =  '"+custdesc+"'  AND (b.cust_code = '"+custgrpcode+"' OR b.cust_code = '**') AND a.policy_type_code = b.policy_type_code AND a.operating_facility_id = '"+document.forms[0].p_facility_id.value+"'  AND UPPER (a.language_id) = UPPER ('"+document.forms[0].locale.value+"') AND upper(a.policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
	
	var title									= 	getLabel("eBL.POLICY.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	formObj.policy_desc.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=  await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}	
	if(retVal != null && retVal != "")
	{
		formObj.p_policy_type_code.value	=arr[0];
		formObj.policy_desc.value			=arr[1];
	}
	else
	{
		formObj.p_policy_type_code.value = arr[0]; 
		formObj.policy_desc.value = arr[1]; 
		//formObj.p_policy_type_code.value		="";
		//formObj.policy_desc.value				="";		
	}
}

//Effective From and ToDate Logic
function toFromDateChk(obj)
{
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.forms[0].p_fm_date.value;
		var effToDt =document.forms[0].p_to_date.value;
		if(validDate(obj.value,'DMY',locale))
		{
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL00952",'BL'));
				obj.value = '';
				return false;
				return true;
			}
			if(effToDt==getCurrentDate('DMY',locale)){
				alert(getMessage("BL1470",'BL'));
				obj.value = '';
				return false;
				return true;
			}
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL4115",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}
			}			
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function checkDateBL(entered_date)
	{		
  	var locale=document.forms[0].locale.value;
  	var effFromDt =document.forms[0].p_fm_date.value;
  	var effToDt =document.forms[0].p_to_date.value;
  	if(entered_date.value!="")
  	{
  		if(validDate(entered_date.value,'DMY',locale))
  		{
  			if(!isBeforeNow(entered_date.value,'DMY',locale)){
  				alert(getMessage("BL00951",'BL'));
  				entered_date.value='';
  				return false;
  			}			
  			if(effToDt != ''){
  				if((!isBefore(effFromDt,effToDt,'DMY',locale))){
  					alert(getMessage("BL00953",'BL'));
  					entered_date.value='';
  					return false;
  			}
  			else{
  					return true;
  			}
  			}		
  		}
  		else
  		{	
  			alert(getMessage("INVALID_DATE_FMT","SM"));
  			entered_date.value='';
  			return false;
  		}
  	}
  	else
  	{
  		return true;
  	}
}
//Effective From and ToDate Logic


function dateRegEx(e){  //Added for Character Restriction in date field   29-08-2020
  var pattern = new RegExp("^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\/\-]\d{4}$");
  if (e.value.search(pattern)===0){
    return true;
  }
  else {
    alert("Please provide valid date in format dd/mm/yyyy");
    document.getElementById(e.id).focus();
    return false; 
  } 
} 

function create() 
{
	
}

function reset()
{
	summarydetail.location.reload();
}
	 
function run()  
{	
  var formsObj = parent.content.summarydetail.document.forms[0];
  var p_fm_date	=formsObj.p_fm_date.value;
  var payer_grp_desc	=formsObj.payer_grp_desc.value;
  var policy_desc	=formsObj.policy_desc.value;
	
  var facility_id=parent.content.summarydetail.document.forms[0].facilityId.value;
  var p_report_id=parent.content.summarydetail.document.forms[0].p_report_id.value;
  var locale=parent.content.summarydetail.document.forms[0].locale.value;
  var date=parent.content.summarydetail.document.forms[0].p_fm_date.value;	
	
  var p_to_date =formsObj.p_to_date.value;
  var  cust_desc = formsObj.cust_desc.value;
  if(payer_grp_desc==''||cust_desc==''){
  	alert(getMessage("BL0746",'BL'));
  	return false;
  }
  if(p_fm_date==''||p_to_date==''){
  	alert(getMessage("BL6503",'BL'));
  	return false;
  }
  if(policy_desc==''){
  	alert(getMessage("BL9103",'BL'));
  	return false;
  }
	if(cust_desc != 'undefined'&& cust_desc != null)
	{
		cust_desc =cust_desc.replace(/\#/g,' ');	
		cust_desc =cust_desc.replace(/\&/g,' ');	
		formsObj.cust_desc.value = cust_desc;
	}
	
	var pgm_id=p_report_id;	
	if(p_fm_date==undefined || p_fm_date=='')
	{
		alert(getMessage("BL00004","BL"));
		return;
	}
	if(p_to_date==undefined || p_to_date=='')
	{
		alert(getMessage("BL8560","BL"));
		return;
	}
	var flag="";	
	if(p_fm_date!="" && p_to_date!="")
		{   
      var datearray = p_fm_date.split("/");
      p_fm_date = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
      var datearray = p_to_date.split("/");
      p_to_date = datearray[1] + '/' + datearray[0] + '/' + datearray[2];

      var date1 = new Date(p_fm_date); 
      var date2 = new Date(p_to_date);
      var Difference_In_Time = date2.getTime() - date1.getTime(); 
      var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24);
			if(Difference_In_Days >=30){
  				alert(getMessage("BL6502","BL"));
  				return false;
				}
		}
	formsObj.submit();
}	

function onSuccess()
{
	parent.frames[2].BillingRecordApproval.document.location.reload(); 
}	
