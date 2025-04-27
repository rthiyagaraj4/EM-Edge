var message = "" ;
var result=false;
 var function_id = "PH_DISP_LOCN_TABLE" ;

function create()
{
  f_query_add_mod.location.href="../../ePH/jsp/DispLocnTimeTableFrames.jsp?mode="+MODE_INSERT;
}
function reset()
	{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
  	if ( (url.indexOf("displocntimetableframes")!=-1) ) {
    f_query_add_mod.location.href="../../ePH/jsp/DispLocnTimeTableFrames.jsp?mode="+MODE_INSERT;
	
	}
}


function query(){
	f_query_add_mod.location.href="../../ePH/jsp/DispLocnTimeTableQueryCriteria.jsp?function_id="+function_id ;
}

function apply() 
{   
	
  	   if ( !checkIsValidForProceed( "displocntimetableframes" ) ) 
	   {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
		}

		var formObj = f_query_add_mod.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm;
		var formObj1 = f_query_add_mod.DispLocnTimeTableFrame.document.DispLocnTimeTableHeaderform;
		var mode=formObj.mode.value;
		var found=false;
		var fields = new Array(formObj1.DispenseLocation);
		var names = new Array(getLabel("ePH.DispenseLocation.label","PH"));
		   var disp_code=formObj.disp_code.value;
		   //alert("disp_code--->"+disp_code)
	  message="APP-000005 Dispense Location Type Cannot be Blank";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
 if(disp_code!="")
  {
		if( mode == "1" ) 
		 {
		  	for(i=0; i<10; i++)
		 	{
			 var from=eval("f_query_add_mod.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.from_time_hh"+i).value;
			 var to=eval("f_query_add_mod.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value;
		     if(from!=""&&to!="")
			 {
			 found	= true;
			 }
			 else if((from!=""&&to=="")||(from==""&&to!=""))
			 {
			   found	= false;
			   break;
			  }else if(from==""&&to=="")
			  {
			  	found	= true;
			  }

			}
			 if(found){
			   eval(formApply(f_query_add_mod.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm,PH_CONTROLLER ));
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						if( result ) {
						onSuccess(mode,disp_code); 
				  }
			 
				}
				else
					{
						message="From and To Timings both must be entered for day type";
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
								
					 }
				  }
	}
}
function onSuccess(mode,disp_code) {
	f_query_add_mod.DispLocnTimeTableDetailsFrame.location.href="../../ePH/jsp/DispLocnTimeTableDetail.jsp?mode="+mode+"&disp_code="+disp_code;
    
}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function LoadDetail(obj,mode)
{
 parent.DispLocnTimeTableDetailsFrame.location.href="../../ePH/jsp/DispLocnTimeTableDetail.jsp?mode="+mode+"&disp_code="+obj.value;
}
function  appedzero(obj){
	if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { strHr	= "0"+ strHr;}else if(strHr.length==0){strHr = "00"; }
			if(strMi.length==1) { strMi	= "0"+ strMi;}else if(strMi.length==0){strMi = "00"; }
			obj.value=strHr+":"+strMi;
		}else{
			if(from_val.length == 1){obj.value= "0"+from_val+":"+"00";}
			else if (from_val.length == 2){obj.value= from_val+":"+"00";}
		}
	}
}
function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function checkTime(obj)
{
  if(!chkTime(obj.value))
	{
		alert(getMessage("ALT_TIMING_INVALID","PH"));
		return false;
	}
}


function validtime(obj)
{
    var strHr;
	var strMi;
	var timefield = obj.value;
	var strTimeArray = new Array();
	strTimeArray = timefield.split(":");
		strHr = strTimeArray[0];
		strMi = strTimeArray[1];
 		if(strHr>=24||strMi>=60)
	{
        alert(getMessage("ENTER_TIME_FORMAT","PH"));
	    clearData1(obj);
		return false;

	}    else {return true; }
}


function finalcompare(frmtime,i){
	
	var to_time=eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value;
	
	var fromtime=frmtime.value;
	var totime=to_time;
	
	var strHr1;
	var strMi1;
	var strHr2;
	var strMi2;

   	var timefield1 = fromtime;
	var strTimeArray1 = new Array();
	var timefield2 = totime;
	var strTimeArray2 = new Array();

	
	if(	timefield1 != null  && timefield1 != ""){
	strTimeArray1 = timefield1.split(":");
		strHr1 = strTimeArray1[0];
		strMi1 = strTimeArray1[1];
	}
    if(	timefield2 != null && timefield2 != ""){
    strTimeArray2 = timefield2.split(":");
		strHr2 = strTimeArray2[0]; 
		strMi2 = strTimeArray2[1];
	}
	
 
	if(strHr1!=undefined){
	if((strHr1==strHr2)&&(strMi1==strMi2)){
			alert("FROM AND TO TIMINGS CANNOT BE SAME");
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value="";
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).focus();
		
	}
	else if((strMi1==strMi2)&&(strHr1==strHr2))
	{
		    alert("FROM AND TO TIMINGS CANNOT BE SAME");
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value="";
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).focus();
		
	}
	}
}

function finalcompare11(to_time,i){
	var frmtime=eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.from_time_hh"+i).value;
	var fromtime=frmtime;
	var totime=to_time.value;
	var strHr1;
	var strMi1;
	var strHr2;
	var strMi2;
   	var timefield1 = fromtime;
	var strTimeArray1 = new Array();
	var timefield2 = totime;
	var strTimeArray2 = new Array();

	if(	timefield1 != null  && timefield1 != ""){
	strTimeArray1 = timefield1.split(":");
		strHr1 = strTimeArray1[0];
		strMi1 = strTimeArray1[1];
	}
    if(	timefield2 != null && timefield2 != ""){
    strTimeArray2 = timefield2.split(":");
		strHr2 = strTimeArray2[0]; 
		strMi2 = strTimeArray2[1];
	}

	if(strHr2!=undefined){
	if((strHr1==strHr2)&&(strMi1==strMi2))
	{
			alert("FROM AND TO TIMINGS CANNOT BE SAME");
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value="";
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).focus();
		
	}
	else if((strMi1==strMi2)&&(strHr1==strHr2))
	{      
		   alert("FROM AND TO TIMINGS CANNOT BE SAME");
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value="";
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).focus();
		
	}
	}
	
}

function clearData1(obj) {
	obj = eval(obj);
	//alert(obj.value);
	var len = obj.length;
 		obj.value="";
		obj.focus();
		 
}
function allowPositiveNumber() { //alert()
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
       return false;
   }
}	


function FromTimeCheck(obj,i)
{
	
    fromTime=obj.value;
	var fromTimea1 =fromTime.substring(0,1);
	var fromTimea2 =fromTime.substring(1,2);
	var fromTimea3 =fromTime.substring(2,3);
	var fromTimea4 =fromTime.substring(4,5);
	if(fromTime!="")
	{
	if(fromTimea1==0&&fromTimea2==0&&fromTimea3==0&&fromTimea4!=4||fromTime.length==4||fromTime.length==6)
		{
		  alert(getMessage("ENTER_TIME_FORMAT","PH"));
		 eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.from_time_hh"+i).value="";
 		 eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.from_time_hh"+i).focus();
		}
	}
}
function ToTimeCheck(obj,i)
{
   ToTime=obj.value;
	var ToTimea1 =ToTime.substring(0,1);
	var ToTimea2 =ToTime.substring(1,2);
	var ToTimea3 =ToTime.substring(2,3);
	var ToTimea4 =ToTime.substring(4,5);
	if(ToTime!="")
	{
	if(ToTimea1==0&&ToTimea2==0&&ToTimea3==0&&ToTimea4!=4||ToTime.length==4||ToTime.length==6)
		{
		  alert(getMessage("ENTER_TIME_FORMAT","PH"));
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).value="";
		    eval("parent.DispLocnTimeTableDetailsFrame.document.DispLocnTimeDetailForm.to_time_hh"+i).focus();

		}
	}
}




 