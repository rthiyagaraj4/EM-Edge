/*
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
var invalidCode = "";
*/

function create() {		
	commontoolbarFrame.document.forms[0].apply.disabled=false;
	revenuedetail.location.href='../../eBL/jsp/BLRevnRecgStageAdd.jsp';	
}

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	revenuedetail.location.href='../../eBL/jsp/BLRevnRecgStageQueryCriteria.jsp';
}

function checkIfNotValidForProceed()
{
	var count=0;
	//var formObj = revenuedetail.document.forms[0];	
	//var formObj = revenuedetail.document.BLRevnRecgStageCreate;
	var fm_date=revenuedetail.document.BLRevnRecgStageCreate.p_fm_date.value;
	var ordr_cat=revenuedetail.document.BLRevnRecgStageCreate.order_cat.value;
	var ordercode=revenuedetail.document.BLRevnRecgStageCreate.order_type.value;
	var rev_stage=revenuedetail.document.BLRevnRecgStageCreate.Revenue_Stage.value;
	if(ordercode == '--Select--')
	{
		ordercode = '';
	}		
	if (ordr_cat =='SLT' || ordr_cat =='') {
		alert('Order Category can not be empty');
		ordr_cat.focus();	
		return false;
	}else if (ordercode =='' || ordercode =='SLT') {
		alert('Order Type can not be empty');
		ordercode.focus();	
		return false;
	}else if (rev_stage =='' || rev_stage == 'SLT') {	
		alert('Revenue Stage can not be empty');
		rev_stage.focus();
		return false;
	}else if (fm_date =='') {	
		alert('From Date can not be empty');
		fm_date.focus();
		return false;
	}else {
		return true;
	}
}

function apply() {	
	if (checkIfNotValidForProceed() ) {
		var formObj = revenuedetail.document.forms[0];
		formObj.target = 'messageFrame';  //Setting target so that it prints the output message from servlet inside Message Frame Down
        formObj.method='post';
		formObj.action="../../servlet/eBL.BLRevenueStageServlet";		
		formObj.submit();
		//revenuedetail.document.location.reload();		//IN073854
	}
  }

function onSuccess() {
	revenuedetail.document.location.reload(); //IN073854
}

function reset(){	
	revenuedetail.location.reload();	
}

function toFromDateChk(obj)
{  	
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.getElementById("p_fm_date").value;
		if(validDate(obj.value,'DMY',locale))
		{	
	/*if(  effToDt!=getCurrentDate('DMY',locale) && isBeforeNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL8147",'BL'));
				obj.value = '';
				return true;
			}
			if(effToDt==getCurrentDate('DMY',locale)){
			//	alert("152");
				alert(getMessage("BL8147",'BL'));
				obj.value = '';
				return false;
				
			}
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		//alert("160");
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
		}*/
		return true;
		}
	}
	else
	{
		return false;
	}
}

function checkDateBL(entered_date){
	var locale=document.forms[0].locale.value;
	var effFromDt =document.getElementById("p_fm_date").value;
	if(entered_date.value!="")
  	{	
  		if(validDate(entered_date.value,'DMY',locale))
		{	if(isBeforeNow(entered_date.value,'DMY',locale)){
				alert(getMessage("BL00659",'BL'));
  				entered_date.value='';
  				return false;
  			}
			if(  effFromDt!=getCurrentDate('DMY',locale) && isAfterNow(effFromDt,'DMY',locale)==true){
				
				return true;
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
