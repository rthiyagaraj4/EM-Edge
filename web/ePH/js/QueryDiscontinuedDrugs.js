 //saved on 29/10/2005
function query()	{
	f_query_add_mod.location.href="../../ePH/jsp/QueryDiscontinuedDrugsFrames.jsp";
}
/*
function reset()	{
	if(f_query_add_mod.f_query_criteria)	{
	f_query_add_mod.f_query_criteria.document.queryDiscontinuedDrugsCriteria.reset();
	f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.f_query_criteria.document.queryDiscontinuedDrugsCriteria.drug_search.disabled=false;
	}
}
*/
function reset() {

		var formObj = f_query_add_mod.f_query_criteria.document.queryDiscontinuedDrugsCriteria;
		formObj.reset();
		f_query_add_mod.f_query_result.location.href="../../eCommon/html/blank.html";
		formObj.drug_name.disabled		= false;
		formObj.drug_search.disabled	= false;
		f_query_add_mod.location.reload();
	}

async function searchDrugName1(obj){

	var formObj = parent.frames[0].document.queryDiscontinuedDrugsCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = formObj.sql_ph_drug_query_select1.value+"'"+formObj.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");	
	if(retVal != null && retVal != "" )  {
		formObj.drug_name.value = arr[1] ;
		formObj.drug_code.value = arr[0];
		obj.disabled	=	true;
	}

}
function callResultPage1()	{ 
	frm_obj		=	 parent.frames[0].document.queryDiscontinuedDrugsCriteria.dt_from;
	to_obj		=	 parent.frames[0].document.queryDiscontinuedDrugsCriteria.dt_to;
	var formObj = parent.frames[0].document.queryDiscontinuedDrugsCriteria;
	var msg_frame	=	parent.messageFrame;
	if(doDateCheck(frm_obj,to_obj,msg_frame) )	{
	var drug_code			=	formObj.drug_code.value;
	var drug_name			=	formObj.drug_name.value;
	var drug_class			=	formObj.drug_class.value;
	//var dt_from			=	formObj.dt_from.value;
	//var dt_to				=	formObj.dt_to.value;
	var locale				=	formObj.language_id.value;
	var dt_from				=	convertDate(formObj.dt_from.value,'DMY',locale,"en"); 
	var dt_to				=	convertDate(formObj.dt_to.value,'DMY',locale,"en");
	
	parent.frames[1].location.href="../../ePH/jsp/QueryDiscontinuedDrugsResult.jsp?drug_code="+drug_code+"&drug_name="+drug_name+"&drug_class="+drug_class+"&dt_from="+dt_from+"&dt_to="+dt_to;
	}
	else	{
	parent.frames[1].location.href="../../eCommon/html/blank.html"
	}  


}


function checkDateWithSysDate(entered_date,sys_date) 
{
	var enteredDateArray; var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ) 
	{
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) 
		{
			/*  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..
*/
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}

function callDrugDetails(drug_code){
loadPage(drug_code);
}

async function showDiscontinuedDetails(details)	{
	var dialogHeight= "400px" ;
    var dialogWidth = "700px" ;
    var dialogTop = "230" ;
    var center = "1" ;
    var status="no";
    var scrolling="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
    var arguments   = "" ;
    retVal = await window.showModalDialog("../../ePH/jsp/QueryDiscontinuedDetails.jsp?details="+details,arguments,features);
}


function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].dt_to;
	  to = document.forms[0].dt_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].dt_from;
	  to = document.forms[0].dt_to;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].dt_to;
	  to = document.forms[0].dt_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}*/
if(document.forms[0].dt_from.value=='' || document.forms[0].dt_to.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].dt_from.value,document.forms[0].dt_to.value,"DMY",document.forms[0].language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}

	return true;
}

function DateCheck(from,to) {
//alert("from====>" +from.value);
//alert("to====>" +to.value);
    /*var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
      			fromarray = fromdate.split("/");

			toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }*/
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}


		
		
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    return true;
}

