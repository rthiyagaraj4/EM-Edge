function isValidDateTime(obj){	
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var dateTimeObj = obj.value;
		var dateTimeArr = dateTimeObj.split(" ");
		if(dateTimeArr.length != 2)  flag=false;
		var str_date = dateTimeArr[0];
		var str_time = dateTimeArr[1];

		if(!(checkDt1(str_date))){

			
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}

		if(!(isValidTime(str_time))){
		
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function checkDt1(date1)
{
	if (date1.value != undefined)
	{
		date1 = date1.value;
	}
	else
	{
		date1=date1;
	}
    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3)
    {
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]
        
        if(date1d.length != 2) return false;
        if(date1m.length != 2) return false;
        if(date1y.length != 4) return false;

		if (isNaN(date1d)==true) return false;
		if (isNaN(date1m)==true) return false;
		if (isNaN(date1y)==true) return false;

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

		if(date1m<=12)
        {

            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
            {
                retval= false
            }

            if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
            {
                retval= false
            }
            if ((date1y.length <4) || (date1y.length >4))
            {
                retval= false
            }
            if (date1m == 2) {
                if (date1d< 1) return false;

                if (LeapYear(date1yy) == true) {
                    if (date1d> 29) return false;
                }
                else {
                    if (date1d > 28) return false;
                }
            }

            if (isNaN(date1d)==true) retval = false;
            if (isNaN(date1m)==true) retval = false;
            if (isNaN(date1yy)==true) retval = false;
        }
        else
        {
            retval= false;
        }
    }
    else
    {
        retval= false;
    }
    return retval;
}

function isValidTime(time1)
{
	if (time1.value != undefined)
	{
		time1 = time1.value;
	}
	else
	{
		time1=time1;
	}
   time1=trimString(time1); 
   var retval=true;
   var strCheck = ':0123456789';
    for(var i=0;i<=time1.length;i++) {
        if (strCheck.indexOf(time1.charAt(i)) == -1){
            retval = false;
            break;
        }
    }			
    if (retval)
    {		
       var time1arr=new Array()
       time1arr=time1.split(":")
			
            if(time1arr.length==3)
            {
                var time1hr=time1arr[0];
                var time1min=time1arr[1];
                var time1sec = time1arr[2];
				if (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)
				{
					 retval=false;
				}

                time1hr=eval(time1hr)
                time1min=eval(time1min)
                time1sec = eval(time1sec)
                if(time1hr<=23)
                {
                    if(time1min>59)
                    {
                            retval=false;                      
                    }
                    if(time1sec>59){
                    	retval=false;
                    }
                }
                else
                        retval=false;
            }
            else{						
                retval=false;
			}
        
    }			
    return retval;
}
function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}

function callCommonLookupCode(obj, code, sqlSelect, codeDesc, commonCode) 
{
		var locale=$('#locale').val();
	var patient_id=$('#patient_id').val();
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = '';
	var title = '';
	var codeval = '';
	switch (sqlSelect) 
	{
	case 1: {
		sql = " Select code,description from (Select Module_id code ,Module_Name description  From Sm_Module_LANG_VW WHERE LANGUAGE_ID='"+locale+"') where upper(code) like upper(?)  and upper(description) like upper(?) order by 1 ";
		title = 'Modules';
		break;
				
	}
	case 2:{
		
		sql=" Select code , description from (SELECT EPISODE_ID Code,LAST_VISIT_ID||' -Visit ID'  Description FROM OP_EPISODE A WHERE A.PATIENT_ID ='"+patient_id+"' " +
			" AND EXISTS (SELECT B.EPISODE_ID FROM BL_PATIENT_CHARGES_INTERFACE B WHERE B.PATIENT_ID = A.PATIENT_ID AND  NVL(B.EPISODE_ID,0) = NVL(A.EPISODE_ID,0) " +
			" AND NVL(BILL_YN,'N')='N')) where upper(code) like upper(?)  and upper(description) like upper(?) order by 1,2 ";
		title="Episode ID"	
	
	}
	}
		

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if (codeDesc == '1') {
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
	} else if (codeDesc == '2') {
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = CODE_DESC;
	}
	returnedValues = CommonLookup(title, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];
		codeval = code.value;
	} else {
		obj.value = '';
		code.value = '';
	}


if(sqlSelect==2)
	{
	var obj=obj.value;
	
	obj=obj.slice(0,-9);
	$('#visitid').val(obj);
	}

}


function fnClearCode(obj) {
	obj.value = '';
}



function getPatID()
{	
	var pat_id=PatientSearch();	
	if( pat_id != null )						
	document.forms[0].patient_id.value = pat_id ;					
}


function  populate_btm_frame(indx)
{
	//alert('indx'+indx);
	var patient_id=$(parent.result_frame.document).find('#patId_'+indx).val();
	var episode_id=$(parent.result_frame.document).find('#epiId_'+indx).val();
	var visit_id=$(parent.result_frame.document).find('#visId_'+indx).val();
	var patient_name=$(parent.result_frame.document).find('#patName_'+indx).val();
	var charge_state=$(parent.result_frame.document).find('#chargestate_'+indx).val();	
//	alert('pat id '+patient_id)
//	alert('epi id '+episode_id);
//	alert('visit id'+visit_id);
//	alert('pat name'+patient_name);
//	alert('charge_state'+charge_state);
	$(parent.bottom_frame.document).find('#patient_no').text(patient_id);
	$(parent.bottom_frame.document).find('#episode_id').text(episode_id);
	$(parent.bottom_frame.document).find('#visit_id').text(visit_id);
	$(parent.bottom_frame.document).find('#patient_name').text(patient_name);
	$(parent.bottom_frame.document).find('#charging_state').val(charge_state);

	$(parent.bottom_frame.document).find('#charging_state').change(function()
	{
		if(this.text!=charge_state)
			{
			$(parent.bottom_frame.document).find('#charging_state').text(charge_state);
					
			}
	});


}


function process_btn(){
	

	
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	
	var dynamicParams="";
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	var facility_id=$('#facilityid').val();
	var locale=$('#locale').val();
	var user_id=$('#strLoggedUser').val();
	var episode_type=$('#episode_type').val();
	var count=0;
	 for (var i=1;i<=indx;i++)
		{

		if($(parent.result_frame.document).find('#selectindividual_'+i).prop("checked"))
			 {	 var check=trimString($(parent.result_frame.document).find('#mod_'+i).text());
		  
		dynamicParams+='primarykey_id'+i+'='+$(parent.result_frame.document).find('#module_'+i).text()+'&'+
						'primarykey_main'+i+'='+$(parent.result_frame.document).find('#primarykey_'+i).text()+'&'+
						'seckeymoduleid'+i+'='+trimString($(parent.result_frame.document).find('#mod_'+i).text())+'&'+
						'seckeymain'+i+'='+trimString($(parent.result_frame.document).find('#secondarykey_'+i).text())+'&'+
						'seckeylineno'+i+'='+$(parent.result_frame.document).find('#lin_'+i).text()+'&'+
						'pat_id'+i+'='+$(parent.result_frame.document).find('#patId_'+i).val()+'&'+
						'epiid'+i+'='+$(parent.result_frame.document).find('#epiId_'+i).val()+'&'+
						'vis_id'+i+'='+$(parent.result_frame.document).find('#visId_'+i).val()+'&';
					
		count++;
	}			
		}
	 
	 if(count<1)
		{
		
		alert(getMessage('BL1259','BL'));
		 return ;
		}
		 $.ajax({
		 	
		 	type:'POST',
		 	url:"../../servlet/eBL.BLBillGenInterfaceServlet?indx="+indx+"&facility_id="+facility_id+"&locale="+locale+"&user_id="+user_id+"&episode_type="+episode_type,
		 	data:dynamicParams,
		 	async:false,
		 	success:function(data){
		 		if(data.Success=='N')
		 			{
		 		alert(data.error);
		 			}
		 		else
		 			{
		 			$(parent.parent.BillReceiptTab.document).find('#billCumReceipt').click();
					$(parent.parent.BillReceiptTab.document).find('#billCumReceipt').addClass('CASECONDSELECTHORZ');
		 			}
		 		}
		 });
}

/*
function reset()
{
	
	alert("bsdfjaw");

    $('input:checkbox').removeAttr('checked');
	
	/*$('#episode_type').val($('#episodeType').val());
	$('#encounter').val('A');
	$('#patient').val('A');
	$('#records').val('A');
	$('#patient_no').val('');
	$('#episode_id').val('');
	$('#visitid').val('');
	$('#prkeymain').val('');
	$('#prmodule').val('');
	$('#pr_module').val('');
	$('#encounter_from_date').val($('#sy_date').val());
	$('#encounter_to_date').val($('#cur_date').val());*/


//}
function clear_fields()
{
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	for( var i=0;i<=indx;i++){
		
		if($(parent.result_frame.document).find('#selectindividual_'+i).prop("checked")){
			
			$(parent.result_frame.document).find('#selectindividual_'+i).removeAttr('checked');
			$(parent.result_frame.document).find('#select_all').removeAttr('checked');
		}
	}	
}	


function highlightRow(obj,qryClass){
	var frm =  document.blinterfacesearchresult;
	var rowClicked = $('#rowClicked').val();

	if(rowClicked != obj){

	
		if(rowClicked.length > 0){
			
			$('#row_'+rowClicked+' td' ).each(function(){
				$(this).attr('class','label');
			});	
			
		}	
		
		$('#row_'+obj+' td' ).each(function(){
			$(this).attr('class','LocalYellow');			
		});
		
	
		frm.spanColor.value = document.getElementById("spanColor"+obj).value;	
		frm.selectindividual.value = document.getElementById("selectindividual_"+obj).value;		
		frm.module.value = document.getElementById("module_"+obj).value;		
		frm.clinic.value = document.getElementById("clinic_"+obj).value;		
		frm.physicianid.value = document.getElementById("physicianid_"+obj).value;

		frm.blngservcode.value = document.getElementById("blngservcode_"+obj).value;
		frm.description.value = document.getElementById("description_"+obj).value;
		frm.primarykey.value = document.getElementById("primarykey_"+obj).value;
		frm.line.value = document.getElementById("line_"+obj).value;
		frm.mod.value = document.getElementById("mod_"+obj).value;
		// frm.billPrintFlag.value =
		// document.getElementById("bill_print_flag"+obj).value;
		frm.secondarykey.value = document.getElementById("secondarykey_"+obj).value;		
		frm.lin.value = document.getElementById("lin_"+obj).value;		
		frm.servitemcode.value = document.getElementById("servitemcode_"+obj).value;

		frm.desc.value = document.getElementById("desc_"+obj).value;
		frm.interfaceddate.value = document.getElementById("interfaceddate_"+obj).value;
		frm.charged.value = document.getElementById("charged_"+obj).value;
		frm.grossamt.value = document.getElementById("grossamt_"+obj).value;
		frm.discount.value = document.getElementById("discount_"+obj).value;

		frm.netamt.value = document.getElementById("netamt_"+obj).value;
		frm.details.value = document.getElementById("details_"+obj).value;

		
		
		
	}
	$('#rowClicked').val(obj);
	
		
	}
	


function fnSelectAll(){
	
	var check = 'N';
	if($('#select_all').prop('checked')){
	
		check = 'Y';
		$('[id^=selectindividual_]').each(function(){

			$(this).attr('checked','checked');
		});				
	}
	else{
	
		$('[id^=selectindividual_]').each(function(){
			$(this).prop('checked',false);
		});
	}
}




function fnSelectindividual(obj){
	var frm =  document.blinterfacesearchresult;

	var totSelected = 0;
	var lastIndex = $('#bilgeninterface tr:last').attr('data-id');
	var count = lastIndex

	var rowIndx=1		
for(i=0;i<=lastIndex;i++){
	if($('#selectindividual_'+i).prop("checked")){
		totSelected = parseInt(totSelected) + rowIndx  ; 
	}
}	

	if(totSelected   ==  count ){
	
		$('#select_all').prop('checked',true);
	}
else{

	$('#select_all').prop('checked',false);
}
	

}




function frame_call(){
	var indx=$(parent.result_frame.document).find('#bilgeninterface tr:last').attr('data-id');
	var visitid=$('#visitid').val();
	var episode_id=$('#episode_id').val();
	var records=$('#records').val();
	var modules=$('#modules').val();
	var prmodule=$('#prmodule').val();
	var pr_module=$('#pr_module').val();
	//var prkeymain=$('#prkeymain').val();
	var episode_type=$('#episode_type').val();
	var patient=$('#patient').val();
	var patient_no=$('#patient_no').val();
	var encounter=$('#encounter').val();
	var service_location_code=$('#serviceLocation').val();
	var service_location_desc=$("#serviceLocation option:selected").text();
	var encounter_from_date=$('#encounter_from_date').val();
	var encounter_to_date=$('#encounter_to_date').val();
	var module_id=$('#prmodule').val();
	var site_id=$('#site_id').val();
	var futureYn = $('#futureYn').val();
	
	
	if($('#modules').val()=='S'){
		if(module_id ==''){
			alert(getMessage('BL00954','BL'));
			return false;
		}
	}
	parent.dummy_frame.location.href= '../../eCommon/jsp/process.jsp';
var url="../../eBL/jsp/BLBillGenInterfaceSearchResult.jsp?&episode_id="+episode_id+"&visit_id="+visitid+"&records="+records+"&modules="+modules+
"&prmodule="+prmodule+
"&pr_module="+pr_module+
//"&prkeymain="+prkeymain+
"&episode_type="+episode_type+
"&patient="+patient+
"&patient_no="+patient_no+
"&encounter="+encounter+
"&service_location_code="+service_location_code+
"&service_location_desc="+service_location_desc+
"&encounter_from_date="+encounter_from_date+
"&encounter_to_date="+encounter_to_date+
"&module_id="+module_id+
"&site_id="+site_id+
"&futureYn="+futureYn;
parent.result_frame.location.href=url;
//parent.dummy_frame.location.href='../../eCommon/html/blank.html';
}

