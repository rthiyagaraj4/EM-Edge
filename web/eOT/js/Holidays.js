/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	f_query_add_mod.location.href='../../eOT/jsp/HolidaysAddModify.jsp?mode=insert';
}

function apply(){

	var frm=f_query_add_mod.document.forms[0];
	if(frm!=null){

			if(frm.mode.value=="modify"){
				//f_query_add_mod.document.forms[0].submit();
				var fields = new Array (f_query_add_mod.document.forms[0].holiday_date,f_query_add_mod.document.forms[0].reason_for_holiday);
				var holiday_date = getLabel("Common.HolidayDate.label","Common");
				var locale=frm.locale.value;
				var reasonfor_holiday = getLabel("Common.ReasonForHoliday.label","Common");
				var names = new Array ( holiday_date,reasonfor_holiday);
				var holiday_date=dateUtils(frm.holiday_date.value,locale);
				frm.holiday_date.value=holiday_date;
				if(checkFieldsofMst( fields, names, messageFrame)){	
					f_query_add_mod.document.forms[0].submit();
				}
			}else{
				var fields = new Array (f_query_add_mod.document.forms[0].holiday_date,f_query_add_mod.document.forms[0].reason_for_holiday);
				var holiday_date = getLabel("Common.HolidayDate.label","Common");
				var locale=frm.locale.value;
				var reasonfor_holiday = getLabel("Common.ReasonForHoliday.label","Common");
				var names = new Array ( holiday_date,reasonfor_holiday);
				var holiday_date=dateUtils(frm.holiday_date.value,locale);
				//Modified by DhanasekarV against IN025643 on 31/12/2010 
				frm.holiday_date.value=holiday_date;
				if(checkFieldsofMst( fields, names, messageFrame)){	
					f_query_add_mod.document.forms[0].submit();					
				}
			}
	}else{
		
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}		
}

function onSuccess(){

	if(f_query_add_mod.document.forms[0].mode.value=="insert"){
		
		f_query_add_mod.location.href='../../eOT/jsp/HolidaysAddModify.jsp?mode=insert';
	}else{
		var formObj = f_query_add_mod.document.forms[0];
		var locale =  formObj.locale.value;

		//Modified by DhanasekarV against INO25643  on 23/12/2010
		var holiday_date = convertDate(formObj.holiday_date.value,'DMY','en',locale);
		f_query_add_mod.location.href="../../eOT/jsp/HolidaysAddModify.jsp?holiday_date="+holiday_date+"&mode=modify";
	}
}

function deleterecord(){  
	var frm=f_query_add_mod.document.forms[0];

	if(frm!=null){
		if(frm.name=='query_form' || frm.name=='QueryResult'){
				alert(commontoolbarFrame.document.forms[0].apply.disabled)
				commontoolbarFrame.location.reload();
				//commontoolbarFrame.document.forms[0].apply.disabled=true;

		}else{
			var frmobj=f_query_add_mod.document.forms[0];
			if(frmobj.mode.value=='insert'  ){
				  commontoolbarFrame.location.reload();
					return;
			}else{
				if(f_query_add_mod.document.forms[0]!=null){
					var locale =f_query_add_mod.document.forms[0].locale.value;
					//Modified by DhanasekarV against INO25643  on 23/12/2010
					var holiday_date=convertDate(f_query_add_mod.document.forms[0].holiday_date.value,'DMY',locale);
					var status =f_query_add_mod.document.forms[0].mode.value;
					if(status!="insert"){
						var model="delete";
						var answer =window.confirm(getMessage("DELETE_RECORD","Common"));
						if(answer == true){


							var action="../../servlet/eOT.HolidaysServlet?holiday_date="+holiday_date+"&mode=delete";
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest() ;
							var xmlStr ="<root></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST",action,false);
							xmlHttp.send(xmlDoc);
							var responseText=xmlHttp.responseText ;
							var result="APP-SM0071 Operation Completed Successfully ...."
							if(responseText.length>1){
							window.parent.frames[2].frames[0].location.reload();
							window.parent.frames[2].frames[1].location.href="../../eOT/jsp/HolidaysAddModify.jsp?mode=insert";
							window.parent.frames[2].frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+result;
							}
						}else{

							window.parent.frames[2].frames[0].location.reload();
						}	
					}
				}else{
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
				}	
		 }
	  }
	}else{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}


function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("HolidaysAddModify.jsp") != -1){
		if(f_query_add_mod.document.location.href.indexOf("Holidays.jsp") != -1){
		  return false;
		}
	 else
		{
		 f_query_add_mod.document.forms[0].reset();
		  if(window.parent.parent.frames[2].frames[1].document.getElementById("date")!=null)
		  {
		  window.parent.parent.frames[2].frames[1].document.forms[0].holiday_date.value="";
		  window.parent.parent.frames[2].frames[1].document.forms[0].week_day.value="";
		 }
		}
	}if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("HolidaysQueryCriteria.jsp") != -1)
	{
	 f_query_add_mod.document.forms[0].reset();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	commontoolbarFrame.document.forms[0].Delete.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/HolidaysQueryCriteria.jsp';
}

function setCheckValue(){
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}


//Temp

function dateUtils(date,locale,format){
		format=(format!=null)?format:"DMY";
	    //alert("Date="+date+"locale="+locale+"Format="+format);
		return (locale=="en")?date:trimString(convertDate(date,format,locale,"en"));
	}


	function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText = xhr.responseText
	return(xhr.responseText);
}

function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}
