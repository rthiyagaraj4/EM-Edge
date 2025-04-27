function create()
{	 
    //document.getElementById("mrpholiday").rows="8%,20%,*,8%"; 	
	f_query_add_mod.location.href ="../../eMR/jsp/HolidayForMedicalReportSearchCriteria.jsp?function_mode=insert&function_type=mrpholiday&operation=insert";   
	frames[2].location.href="../../eCommon/html/blank.html";
	
}
function query() {   
   //document.getElementById("mrpholiday").rows="8%,*,2%,8%";
   f_query_add_mod.location.href ="../../eMR/jsp/HolidayForMrpQueryResult.jsp?function_mode=modify&operation=multipledelete";
   frames[2].location.href="../../eCommon/html/blank.html";
  
   
}

function holidayResultForMrd(){  
	var fields=new Array();
	var names = new Array();
	if (parent.f_query_add_mod.document.mrpHolidaySearch){
	fields[0]= parent.f_query_add_mod.document.mrpHolidaySearch.holidaydate;
	fields[1]= parent.f_query_add_mod.document.mrpHolidaySearch.holiday_end;
	names = new Array(getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"))
	var holiday_date=parent.f_query_add_mod.document.mrpHolidaySearch.holidaydate.value; 
	var holiday_end=parent.f_query_add_mod.document.mrpHolidaySearch.holiday_end.value;  
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
		if(parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame))
		{
			 
          // parent.document.getElementById("mrpholiday").rows="8%,30%,*,8%";			
			
		   parent.frames[2].document.location.href="../../eMR/jsp/HolidayForMedicalReportResult.jsp?holiday_date="+holiday_date+"&holiday_end="+holiday_end+"&operation="+parent.f_query_add_mod.document.mrpHolidaySearch.operation.value;
			
		}
	
	
	}

}
function SpeCharRestriction(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = '`~!@#$%^&*()_-+={[]}|\\:;"\'<,.>?/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}


function validate_date_from(from)
{
	var sys=document.mrpHolidaySearch.sys_date;
	if(from.value!=""){
		if(!validDateObj(from,"DMY",localeName)){
				from.value="";
				parent.frames[2].document.location.href="../../eCommon/html/blank.html"; // added by mujafar on 28/08/2017
				return ;
		}
	var obj1=convertDate(from.value,"DMY",localeName,"en");
		if(isBefore(sys.value,obj1,'DMY',localeName)==false){
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				from.value="";
				from.select();	
				parent.frames[2].document.location.href="../../eCommon/html/blank.html"; // added by mujafar on 28/08/2017
				return false;
		 }
			else
				return true;

	}
	else
	{
		parent.frames[2].document.location.href="../../eCommon/html/blank.html"; // added by mujafar on 28/08/2017
	}
}
function validate_date_to(to,from)
{
	if(to.value!=""){
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			parent.frames[2].document.location.href="../../eCommon/html/blank.html";  // added by mujafar on 28/08/2017
			return ;
	    }
		if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();
				parent.frames[2].document.location.href="../../eCommon/html/blank.html"; //  added by mujafar on 28/08/2017
				return false;
			}
			else
				return true;
		}
    }
	else
	{
		parent.frames[2].document.location.href="../../eCommon/html/blank.html"; // added by mujafar on 28/08/2017
	}
}

function compare_from(from,to)
{ 
if(from.value!="" && to.value!="" )
		{ 
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();
				parent.frames[2].document.location.href="../../eCommon/html/blank.html"; // added by mujafar on 28/08/2017
				return false;
			}
			else
				return true;
		}
}



function year_check(from,to)
{
	if(from.value!="" && to.value!="")
	{
	var year_count=yearsBetween(from.value,to.value,'DMY',localeName);
	
		
	if(year_count >= 1)
				{
					
						var error = getMessage('HOLIDAY_GREATER_THAN_YEAR','OA');	
						alert(error);
						document.mrpHolidaySearch.holiday_end.value="";
						document.mrpHolidaySearch.holiday_end.focus();
					
					tosubmit=false;
				}else
				{
					tosubmit=true;
				}

}

}
function validate_date_to_chk(from)
{
	var sys=document.mrpHolidaySearch.sys_date;
	if(from.value!=""){
		if(!validDateObj(from,"DMY",localeName)){
				from.value="";
				return ;
		}
	var obj1=convertDate(from.value,"DMY",localeName,"en");
		if(isBefore(sys.value,obj1,'DMY',localeName)==false){
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				from.value="";
				from.select();
				parent.frames[2].document.location.href="../../eCommon/html/blank.html"; // added by mujafar on 28/08/2017				
				return false;
		 }
			else
				return true;

	}
	else
	{
		parent.frames[2].document.location.href="../../eCommon/html/blank.html";  // added by mujafar on 28/08/2017
	}
}

function month_check()
{          
			var strDate=document.mrpHolidaySearch.holidaydate.value;
			var end_date=document.mrpHolidaySearch.holiday_end.value;
			var tosubmit=true;

			var fromarray1; var toarray1;
			var fromdate1 = end_date ;
			var todate1   = strDate ;
			if(fromdate1.length > 0 && todate1.length > 0 ) 
			{

				var strDate1=convertDate(strDate,"DMY",localeName,"en");
				var end_date1=convertDate(end_date,"DMY",localeName,"en");


				fromarray1 = strDate1.split("/");
				toarray1 = end_date1.split("/");
					
				var fromdt = new Date((parseInt(fromarray1[2])),(parseInt(fromarray1[1])+1),fromarray1[0]);
				var todt   = new Date(toarray1[2],toarray1[1],toarray1[0]);


				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH steps='Holiday_date' strDate=\""+strDate1+"\" end_date=\""+end_date1+"\"/></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText); 
				eval(responseText);  
				if(flag=="0")	
				{
						var error = getMessage('FMHOLIDAY_GREATER_THAN_MONTH','FM');	
						alert(error);
						document.mrpHolidaySearch.holiday_end.value="";
						document.mrpHolidaySearch.holiday_end.focus();
					
					tosubmit=false;
				}else
				{
				tosubmit=true;
				}

			}
	

}
function reset() {

  f_query_add_mod.document.forms[0].reset() ;
  if(frames[2].document.forms[0])
  {
	frames[2].location.href="../../eCommon/html/blank.html";
  }

}

function apply(){  
  var fields=new Array();
  var names = new Array(); 
  
  	if(frames[2].document.forms[0]&&frames[2].document.forms[0].operation.value=="insert")
		{  
			      frames[2].document.HolidayForMRD_Result.action="../../servlet/eMR.MRPHolidayServlet";
				  frames[2].document.HolidayForMRD_Result.target="messageFrame";				
				  frames[2].document.HolidayForMRD_Result.submit();
				 
		  }else if(frames[1].document.mrpHolidaySearch && frames[1].document.mrpHolidaySearch.operation.value=="modify")
		  { 
			var flag=true;
			if(frames[1].document.mrpHolidaySearch.reason_for_holiday.value!=""){
				flag=true;
			}else{
				flag=false;
				var error=getMessage("REASON_FOR_FMHOLIDAY","FM");
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			}
			if(flag){
				frames[1].document.mrpHolidaySearch.action="../../servlet/eMR.MRPHolidayServlet";						
				frames[1].document.mrpHolidaySearch.submit();
			}
		} 
		else
		{
	          	  
			  messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			   
	     }
	
}

/*function onSuccessMrdlocn()
{  
	
	//parent.frames[1].location.reload();
	parent.frames[2].location.href="../eCommon/html/blank.html";
} */
function onSuccess() {  
  
     if(frames[2].document.forms[0]&&frames[2].document.forms[0].operation.value=="insert"){	 
		create();
	 }else if(frames[1].document.mrdHolidaySearch && frames[1].document.mrdHolidaySearch.operation.value=="delete"){ 
	 query();
	
	 }else if(frames[1].document.MRPHolidayQueryResult && frames[1].document.MRPHolidayQueryResult.operation.value=="multipledelete"){  
	 query();
	
	 }	
	
}
function onSuccess1() { 
	f_query_add_mod.location.reload();
	
}
function chkChar(obj)
{  
	 var sequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 "; // added one space for ML-MMOH-CRF-981
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){

			var msg=getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM")
			alert(msg);
			obj.value="";
			obj.focus();
			obj.select();
			return false;
		}
   }

   return true ;
}
function reasonCheck(obj1,obj2)
{
	var reason=eval("document.forms[0].holiday_reasion_"+obj2).value;
	
	if(reason =="")
	{
  
		if(eval("document.forms[0].selected_"+obj2).checked ==true)
		{
		eval("document.forms[0].selected_"+obj2).checked=false;
		}
	}
}

function selectAll_S(obj){
	len=document.getElementsByClassName("checkBox").length; 
	if (len!=null){
		if (obj.checked){
			for (i=1;i<=len;i++){
				document.getElementById("check_Box"+i).checked=true;
			}
		}else{
			for (i=1;i<=len;i++){
				document.getElementById("check_Box"+i).checked=false;
			}
		}
	}else{
		if (obj.checked){
			document.getElementById("checkBox").checked=true;
		}else{
			document.getElementById("checkBox").checked=false;
		}
	}
}
function checkBoxOnClick(obj,i){ 
if (obj.checked==false){
	document.getElementById("selectall").checked=false;
}

}

function deleterecord()
{  
              
      if(frames[1].document.mrpHolidaySearch && frames[1].document.mrpHolidaySearch.operation.value=="modify"){ 
	        frames[1].document.mrpHolidaySearch.operation.value="delete";
			
	  }
	  if(frames[1].document.mrpHolidaySearch && frames[1].document.mrpHolidaySearch.operation.value=="delete")
	  {  
			var flag=true;
			if(frames[1].document.mrpHolidaySearch.reason_for_holiday.value!=""){
				flag=true;
			}else{
				flag=false;
				var error=getMessage("REASON_FOR_FMHOLIDAY","FM");
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			}
			if(flag){
				frames[1].document.mrpHolidaySearch.action="../../servlet/eMR.MRPHolidayServlet";
				frames[1].document.mrpHolidaySearch.target="messageFrame";				
				frames[1].document.mrpHolidaySearch.submit();
			}
			
		}
			else if(f_query_add_mod.document.forms[0]&&f_query_add_mod.document.forms[0].name=="MRPHolidayQueryResult")
			{  
						
			var selValues="";
			var selValues1="";
			len=f_query_add_mod.document.MRPHolidayQueryResult.checkBox.length;  
			obj=f_query_add_mod.document.MRPHolidayQueryResult.checkBox;
			Obj=f_query_add_mod.document.MRPHolidayQueryResult;
			
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=f_query_add_mod.replace(str,i+1,'1') ;
						selValues1=Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
						
					}
				}
			}else if(len==null){		
				      if(obj.checked){
							var str="10000000000000";
							selValues=Obj.holidayDate.value+'|';
			          }
				
			}						
			f_query_add_mod.document.MRPHolidayQueryResult.selectedValues.value=selValues;
			f_query_add_mod.document.MRPHolidayQueryResult.selCheckBoxes.value=str;
			var fromPage=f_query_add_mod.document.MRPHolidayQueryResult.currentPage.value;
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlStr ="<root><SEARCH steps='FMHoliday' fromPage=\""+fromPage+"\" currSelHolidays=\""+selValues+"\"/></root>";			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","../../eFM/jsp/FMConfirmPullingListConfirmAll.jsp",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText=responseText.replace("<!DOCTYPE html>","");
			eval(responseText);
	
			
			if (result){
				f_query_add_mod.document.MRPHolidayQueryResult.submit();
				
	
			}
			else{
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				parent.frames[2].document.getElementById("mrpholiday").rows="8%,*,2%,8%";
			}
		}else{
		      
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				
			}
						
}
function ClearMsg(){
	
	
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function modifyMRPHoliday(holiday_date,holidayreason,holiday,facilityId){ 

	parent.frames[1].location.href="../../eMR/jsp/HolidayForMedicalReportSearchCriteria.jsp?function_mode=modify&operation=modify&holiday_date="+holiday_date+"&holiday="+holiday+"&facilityId="+facilityId+"&holidayreason="+holidayreason; 
	
}

function replace(str,pos,chr){
  var len= str.length;
  return(str.substr(0,parseInt(pos))+chr+str.substr(parseInt(pos)+1,len));
}

function prevnextsubmission(flag1,holiday_date,prevnextsub,operation,check){

	if(prevnextsub=="Y"){ 
		var msg=getMessage("RECORD_DELETED","SM");
		alert(msg)
		parent.document.getElementById("mrpholiday").rows="8%,*,0%,8%";
		
		parent.f_query_add_mod.location.href ="../eMR/jsp/HolidayForMrpQueryResult.jsp?holiday_date="+holiday_date+"&operation=multipledelete";
		
	}else{ 
		
	
		var msg=getMessage("RECORD_DELETED","SM");
		alert(msg);
		//parent.document.getElementById("mrpholiday").rows="8%,*,2%,8%";
		parent.f_query_add_mod.location.href ="../eMR/jsp/HolidayForMrpQueryResult.jsp?function_mode=modify&operation=multipledelete" ;
		parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num=";
		
	}
}
