 //saved on 04/11.2005
var message		= "" ;

function reset() {
//frames[1].location.href="../../ePH/jsp/DrugInfoEnqDtlRepCriteria.jsp";
frames(1).document.formPhWaitTimeCriteria.reset();

}



function run() {

frames(1).document.formPhWaitTimeCriteria.from_dt.value=frames(1).document.formPhWaitTimeCriteria.p_enq_date_from.value;
frames(1).document.formPhWaitTimeCriteria.to_dt.value=frames(1).document.formPhWaitTimeCriteria.p_enq_date_to.value;
	
	var frmObject =frames[1].document.formPhWaitTimeCriteria;
	if(frames[1].document.formPhWaitTimeCriteria) {
		var fields= new Array (frmObject.p_enq_date_from, frmObject.p_enq_date_to);
		var names= new Array (getLabel("ePH.EnquiryDateFrom.label","PH"), getLabel("ePH.EnquiryDateTo.label","PH"));
		if(checkFields(fields,names,messageFrame) ) {
			var locale = frmObject.language_id.value;
			frmObject.p_locn_code.value = frmObject.disp_locn.value;
			//frmObject.from_dt.value = frmObject.p_enq_date_from.value;
			//frmObject.to_dt.value = frmObject.p_enq_date_to.value;
			frmObject.from_dt.value = convertDate(frmObject.p_enq_date_from.value,'DMY',locale,"en");
			frmObject.to_dt.value =	convertDate(frmObject.p_enq_date_to.value,'DMY',locale,"en");
			frmObject.p_reg_time_fm.value = frmObject.register_from.value;
			frmObject.p_reg_time_to.value = frmObject.register_to.value;
			if(!isBefore(frmObject.p_enq_date_to.value,frmObject.sys_dt.value,"DMY",frmObject.p_language_id.value)) {
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false
		}

		if(!isBefore(frmObject.p_enq_date_from.value,frmObject.p_enq_date_to.value,"DMY",frmObject.p_language_id.value)) {
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
			alert(errors);
			return false;			
		}
			if(frames[1].document.formPhWaitTimeCriteria.p_report_type.value =="DT")
			{ 
			frames[1].document.formPhWaitTimeCriteria.p_report_id.value="PHPTWAITTIME_SRR";
			}
			else if(frames[1].document.formPhWaitTimeCriteria.p_report_type.value =="SM"){
				
			frames[1].document.formPhWaitTimeCriteria.p_report_id.value="PHPTWAITTIME_SRR";
			}
			
			frmObject.submit();
		}
	}
}


function setdate(obj){
	if(!CheckDate(obj))
		return false;
	if(obj.name =="p_enq_date_from"&& parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value =="1")
	{   parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value=obj.value ;

	}
	else if (obj.name == 'p_enq_date_to'&& parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value =='1')
	{	parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_from.value=obj.value ;
	}

	
}

function calcToDate(obj){

	var blank = obj.value;
	if( blank == "")
	{
		alert(getMessage("DATE_CANT_BE_BLANK","PH"));
		return false;
	}
	
	/*if(!CheckDate(obj))
		return false;

	if(parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value != '2')
		return false;*/
	var start_date	=	obj.value;

	var fromarray;
		
	var finalDt="";
	var finalDt1="";

	if(start_date.length > 0)
	{
		fromarray = start_date.split("/");
	}

	var dt = LastDateofMonth(""+fromarray[1]+"/"+fromarray[2]+"/"+fromarray[0]);

	
	var date= ""+dt+"";
	var month= ""+fromarray[1]+"";
	
	if(date.length == 1)
		date="0"+date;
	if(month.length == 1)
		month="0"+month;
	
	finalDt += date + "/";
	finalDt += month + "/";
	finalDt += fromarray[2];

	finalDt1 += 01+ "/";
	finalDt1 += month + "/";
	finalDt1 += fromarray[2];

	parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value=finalDt ;
	parent.frames[1].document.formPhWaitTimeCriteria.focus();

}			
function LastDateofMonth(Object) {
    var strDate;
    var strMonth;
    var strYear;
    var datefield = Object;
    var strDateArray = new Array();
    strDate = datefield;

    strDateArray = strDate.split("/");
    strMonth = strDateArray[0];
    strYear = strDateArray[1];

    if  (strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12)
        return 31;
    else if (strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11)
        return 30;
    else if (strMonth == 2) {
        if (LeapYear(strYear) == true) {
            return 29;
        }
        else {
            return 28;
        }
    }
}

function calcFromDate(obj){
	var blank = obj.value;
	if( blank == "")
	{
		alert(getMessage("DATE_CANT_BE_BLANK","PH"));
		return false;
	}
	
	if(!CheckDate(obj))
		return false;
	if(parent.frames[1].document.formPhWaitTimeCriteria.p_report_type.value != '2')
		return false;

	var to_date	=	obj.value;
	
	if(to_date.length > 0)
	{
		fromarray = to_date.split("/");
	}


	var dt = LastDateofMonth(""+fromarray[1]+"/"+fromarray[2]+"/"+fromarray[0]);
    var dt1="";


	var finalDt1="";
	finalDt1 += dt + "/";
	finalDt1 += fromarray[1] + "/";
	finalDt1 += fromarray[2];



	if( fromarray[0] <= dt)
		dt1= "1";

	var date= ""+dt1+"";
	var month= ""+fromarray[1]+"";
	
	if(date.length == 1)
		date="0"+date;
	if(month.length == 1)
		month="0"+month;
	
	var finalDt="";
	finalDt += date + "/";
	finalDt += month + "/";
	finalDt += fromarray[2];


	
	parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_from.value=finalDt ;
	//parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value=finalDt1 ;

}
function setTOandFromDate(obj){

	parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_from.value="" ;
	parent.frames[1].document.formPhWaitTimeCriteria.p_enq_date_to.value="" ;

}
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}




function validate_date(Obj,ref) {
                
if(document.forms[0].p_enq_date_from.value=='' || document.forms[0].p_enq_date_to.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].p_enq_date_from.value,document.forms[0].p_enq_date_to.value,"DMY",document.forms[0].p_language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}

	return true;
	
	
}


/*function DateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from ;
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
				return false;
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt))
		{		
				
				validate_date(to,'TO_DATE_LESS_FROM')
				return true;
    }
   
} return true;
}*/

//above function commented and written below for IN24351 --10/11/2010-- priya
function DateCheck(from,to) {
	
    /*var fromarray;
    var toarray;
    var fromdate = from ;
    var todate = to.value ;

    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) // Here fromdt is system_date
            {
				
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.value="";
                to.focus();
				return false;
                    
            }
	}
 
			var  to_dt_obj_val = document.forms[0].p_enq_date_to.value;
			var  frm_dt_obj_val= document.forms[0].p_enq_date_from.value;

		  if(frm_dt_obj_val.length > 0 && to_dt_obj_val.length > 0 ) {
            fromarray = frm_dt_obj_val.split("/");
            toarray = to_dt_obj_val.split("/");
             fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
             todt = new Date(toarray[2],toarray[1],toarray[0]);

			 if(Date.parse(todt) < Date.parse(fromdt))
			  {
					validate_date(to,'TO_DATE_LESS_FROM');
			  }
		  }*/
		  if(from=="" || to.value=="")
	{ 
		
		return false;
	}
	else{
		if(!isBefore(to.value,from,"DMY",document.forms[0].p_language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
		  return true;

}

function allowPositiveNumber() { //alert()
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}	
function  appendzero(obj){
	if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr; }else if(strHr.length==0){strHr = "00"; }else if(strHr.length>2){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi; }else if(strMi.length==0){strMi = "00"; }else if(strMi.length>2){strMi = "00"; }
			obj.value=strHr+":"+strMi;
		}else{
			if(from_val.length == 1){
				obj.value= "0"+from_val+":"+"00";
			}else if (from_val.length == 2){
				obj.value= from_val+":"+"00";
			}
		}
	}
	if(!chkTime(obj.value)){
	//	obj.value="";
	//	alert(getMessage("INVALID_TIME_FMT"));
		return false;

	}
}
function validtime(obj,obj1)
{
	var strHr;
	var strMi;
	var timefield = obj.value;
	var strTimeArray = new Array();	
    
	strTimeArray = timefield.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];

    
	if(strHr>=24 || strMi>=60){
	        alert(getMessage("ALT_TIMING_INVALID","PH"));
	        clearData1(obj);
	 		return false;

	}
	else if((obj.value!=""&&obj1.value!="")&&(obj.value<obj1.value)){
        alert(getMessage("FROM_TIME_GREATER_THAN_TO_TIME","PH"));
	        clearData1(obj);
		 		return false;
	}else{
		return true;
	}
}

function clearData1(obj) {
	obj = eval(obj);
	//alert(obj.value);
	var len = obj.length;
 		obj.value="";
		obj.focus();
		 
}

function ChkSplChars(obj)
{
	var str=obj.value;
	
	var chk="1234567890:";
	for(var i=0; i<str.length; i++)
	{
		
		  if (chk.indexOf(str.charAt(i)) == -1) 
			{
				  alert(getMessage("INVALID_TIME", "PH"));
				  obj.select();
				  obj.focus();
				  return;
			}
	}
}
