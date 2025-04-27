/* Created Against ML-MMOH-CRF-1208 [IN:068081] */

function showSearchResults(){
	var query_string		=	document.forms[0].query_string.value;
	var fromDateTime	=	document.forms[0].fromDateTime.value;
	var toDateTime		=	document.forms[0].toDateTime.value;
	var noteType			=	document.forms[0].noteType.value;	
	var returnVal=compareDate(toDateTime,fromDateTime);
		if(returnVal==false){
			alert(getMessage("APP-OT0134","OT"));
			return;
		}
	query_string+=	"&fromDateTime="+fromDateTime+"&toDateTime="+toDateTime+"&noteType="+noteType;
	parent.OTNotesSearchResultFrame.location.href = "../../eOT/jsp/OTNotesSearchResult.jsp?"+query_string;
}

function callRecordSurgeonNotes(url){	
	var query_string = document.forms[0].query_string.value;
	var dialogHeight	=	"37.5" ;
	var dialogWidth		=	"50" ;
	var arguments		=	"" ;	
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	window.showModalDialog(url,arguments,features);	
	window.location.reload();
}

function showNoteStatus(accession_num, tblrow_id){
	var retArray		=	new Array();
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesSearchMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url			+=	"?accession_num="+accession_num+"&operation_mode=ViewNoteStatus";
	retArray			=	window.showModalDialog(action_url,arguments,features);
	window.location.reload();
} 

function checkForSpecCharsforID(event){
    var strCheck = '0123456789:/ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function isValidDate(obj){
	if(obj.value!=""){
		var	locale = document.forms[0].locale.value;
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		var str_date1;
		if( flag != false){
			str_date1 = convertDate(str_date,'DMY',locale,'en');		
			arr_date = str_date1.split('/');
		}
		dt_date.setYear(arr_date[2]);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		if(obj.name=='p1_disp'){
			document.forms[0].p1.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='p2_disp'){
			document.forms[0].p2.value=convertDate(obj.value,'DMY',locale,'en');
		}
		
		if(obj.name=='param1_disp'){
			document.forms[0].param1.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='param2_disp'){
			document.forms[0].param2.value=convertDate(obj.value,'DMY',locale,'en');
		}
		
		if(obj.name=='P_FROM_DATE_DISP'){
			document.forms[0].P_FROM_DATE.value=convertDate(obj.value,'DMY',locale,'en');
		}else if(obj.name=='P_TO_DATE_DISP'){
			document.forms[0].P_TO_DATE.value=convertDate(obj.value,'DMY',locale,'en');
		}		
	}else{		
		if(obj.name=='p1_disp'){
			document.forms[0].p1.value='';
		}else if(obj.name=='p2_disp'){
			document.forms[0].p2.value='';
		}
		
		if(obj.name=='param1_disp'){
			document.forms[0].param1.value='';
		}else if(obj.name=='param2_disp'){
			document.forms[0].param2.value='';
		}
		
		if(obj.name=='P_FROM_DATE_DISP'){
			document.forms[0].param1.value='';
		}else if(obj.name=='P_TO_DATE_DISP'){
			document.forms[0].param2.value='';
		}
	}
	return true;
}

function cal_error(str_message,obj){
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}

function compareDate(fromdate,todate){
    var fromarray; 
	var toarray;
	var flag=true;
    if(fromdate.length > 0 && todate.length > 0 ){
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
	        var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)){
                flag=false;
            }
    }
	return flag;
}

function isDateCheck(obj)
{
	var formObj	= document.OTNotesSearchCriteriaForm;
	var fromDate=formObj.fromDateTime.value;
	var toDate  =formObj.toDateTime.value;
	var objName = obj.name
	var	locale = formObj.locale.value;
	var returnVal=compareDate(toDate,fromDate);
	var enConvertDate = convertDate(obj.value,"DMY",locale,"en");
	var dateArr = enConvertDate.split("/");
	var date1 = new Date(dateArr[2],dateArr[1]-1,dateArr[0]);
	var today = new Date();	
	if(date1>today){
		if(objName=="fromDateTime"){
		alert("APP-000016 From Date cannot be greater than System Date");
		formObj.fromDateTime.focus();			
		formObj.fromDateTime.select();			
		return false;
		}else if(objName=="toDateTime"){
		alert("APP-000016 To Date cannot be greater than System Date");
		formObj.toDateTime.focus();			
		formObj.toDateTime.select();			
		return false;
		}
	}
	if(objName=="fromDateTime"){		
		if(returnVal==false){
			alert("APP-OT0134 From Date can not be greater than To Date");	
			formObj.fromDateTime.focus();			
			formObj.fromDateTime.select();			
			return false;
		}	
	}else if(objName=="toDateTime"){
		if(returnVal==false){
			alert("APP-OT0134 To Date should be greater than or equal to From Date");
			formObj.toDateTime.focus();			
			formObj.toDateTime.select();			
			return false;
		}		
	}
}

function openDocWindow(accession_num,note_type) //Added Against ML-MMOH-CRF-1977.1
{
	window.open("../../eCA/jsp/RecClinicalNotesMultiFileListMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}
