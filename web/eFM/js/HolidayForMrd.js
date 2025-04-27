function create()
{	
	// parent.frames[2].document.getElementById("mrdholiday").rows="8%,20%,*,8%"; 
     document.getElementById("mrdholiday").rows="8%,20%,*,8%";
	/*document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="25vh";
	document.getElementById("f_query_add_mod1").style.height="58vh";
	document.getElementById("messageFrame").style.height="9vh";*/
	 f_query_add_mod.location.href ="../../eFM/jsp/HolidayForMrdSearchCriteria.jsp?function_mode=insert&function_type=mrdHoliday&operation=insert";   
	 //f_query_add_mod1.location.href="../../eCommon/html/blank.html";
	frames[2].location.href="../../eCommon/html/blank.html";
	
}

function query() {  
  
   //parent.frames[2].document.getElementById("mrdholiday").rows="8%,*,2%,8%";
   document.getElementById("mrdholiday").rows="8%,*,2%,8%";
	/*document.getElementById("commontoolbarFrame").style.height="8vh";
	document.getElementById("f_query_add_mod").style.height="83vh";
	document.getElementById("f_query_add_mod1").style.height="2vh";
	document.getElementById("messageFrame").style.height="9vh";*/

   f_query_add_mod.location.href ="../../eFM/jsp/HolidayForMrdQueryPage.jsp?function_mode=modify&operation=multipledelete";
   frames[2].location.href="../../eCommon/html/blank.html";
   //f_query_add_mod1.location.href="../../eCommon/html/blank.html";
   
}


function holidayResultForMrd(){
	var fields=new Array();
	var names = new Array();
	if (parent.f_query_add_mod.document.mrdHolidaySearch){
	fields[0]= parent.f_query_add_mod.document.mrdHolidaySearch.holiday;
	fields[1]= parent.f_query_add_mod.document.mrdHolidaySearch.holiday_end;
	fields[2]= parent.f_query_add_mod.document.mrdHolidaySearch.mrd_location;
	names = new Array(getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"),getLabel("eFM.MrdLocation.label","eFM"))
	var holiday=parent.f_query_add_mod.document.mrdHolidaySearch.holiday.value;
	var holiday_end=parent.f_query_add_mod.document.mrdHolidaySearch.holiday_end.value;
	var mrd_location=parent.f_query_add_mod.document.mrdHolidaySearch.mrd_location.value;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	parent.frames[2].document.location.href="../../eCommon/html/blank.html";
		if(parent.f_query_add_mod.checkFields( fields, names, parent.messageFrame)){
			//document.getElementById("mrdholiday").rows="8%,20%,*,8%";
			//document.getElementById("mrdholiday").rows="8%,20%,*,8%";  
           parent.document.getElementById("mrdholiday").rows="8%,20%,*,8%";			
			//document.forms[0].target="f_query_add_mod1";
		   parent.frames[2].document.location.href="../../eFM/jsp/HolidayForMrdSearchResult.jsp?holiday="+holiday+"&holiday_end="+holiday_end+"&mrd_location="+mrd_location+"&operation="+parent.f_query_add_mod.document.mrdHolidaySearch.operation.value;
			 //f_query_add_mod1.location.href="../../eFM/jsp/HolidayForMrdSearchResult.jsp?holiday_date="+holiday_date+"&holiday_end="+holiday_end+"&mrd_location="+mrd_location+"&operation="+parent.f_query_add_mod.document.mrdHolidaySearch.operation.value;
		}
	
	
	}

}
function apply(){
  var fields=new Array();
  var names = new Array(); 
  //var nochkbox=frames[2].document.forms[0].nochkbox.value;  
  //alert("nochkbox===>"+nochkbox);
 
 //for(var m=0; m<nochkbox;m++){
   
//	var chkselected=eval('frames[2].document.forms[0].selected_'+m).checked;
 // if(eval('frames[2].document.forms[0].selected_'+m).checked)){
   //alert("chkselected===>"+chkselected);
    //if(chkselected){ 
	         //names[m] = new Array(getLabel("Common.ReasonForHoliday.label","Common"));  
             //fields[m]=eval('frames[2].document.forms[0].holiday_reasion_'+m);	
			// alert("fields===>"+fields.name);
			//if(parent.frames[2].checkFields(fields, names, parent.messageFrame)){
			//alert("111==>"+frames[2].document.forms[0].name); alert("22==>"+parent.frames[2].document.forms[0].name);
			if(frames[2].document.forms[0]&&frames[2].document.forms[0].operation.value=="insert"){
			      frames[2].document.HolidayForMRD_Result.action="../../servlet/eFM.FMHolidayServlet";
				  frames[2].document.HolidayForMRD_Result.target="messageFrame";				
				  frames[2].document.HolidayForMRD_Result.submit();
				  /*f_query_add_mod1.document.forms[0].action="../../servlet/eFM.FMHolidayServlet";
				  f_query_add_mod1.document.forms[0].target="messageFrame";
				  f_query_add_mod1.document.forms[0].submit();*/
				 // f_query_add_mod1.document.forms[0].submit();
				//f_query_add_mod1.document.forms[0].submit();
				//frames[2].document.HolidayForMRD_Result.submit();
		  }else if(frames[1].document.mrdHolidaySearch && frames[1].document.mrdHolidaySearch.operation.value=="modify"){
			var flag=true;
			if(frames[1].document.mrdHolidaySearch.reason_for_holiday.value!=""){
				flag=true;
			}else{
				flag=false;
				var error=getMessage("REASON_FOR_FMHOLIDAY","FM");
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			}
			if(flag){
				frames[1].document.mrdHolidaySearch.action="../../servlet/eFM.FMHolidayServlet";				
				//frames[2].document.mrdHolidaySearch.target="messageFrame";	
                //frames[1].document.mrdHolidaySearch.action="messageFrame";					
				frames[1].document.mrdHolidaySearch.submit();
			}
		} else{
	          	  
			  messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			   
	      }
	
}
function deleterecord(){ 
              
      if(frames[1].document.mrdHolidaySearch && frames[1].document.mrdHolidaySearch.operation.value=="modify"){ 
	        frames[1].document.mrdHolidaySearch.operation.value="delete";
	  }
	  if(frames[1].document.mrdHolidaySearch && frames[1].document.mrdHolidaySearch.operation.value=="delete"){ 
			var flag=true;
			if(frames[1].document.mrdHolidaySearch.reason_for_holiday.value!=""){
				flag=true;
			}else{
				flag=false;
				var error=getMessage("REASON_FOR_FMHOLIDAY","FM");
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
			}
			if(flag){
				frames[1].document.mrdHolidaySearch.action="../../servlet/eFM.FMHolidayServlet";
				frames[1].document.mrdHolidaySearch.target="messageFrame";				
				frames[1].document.mrdHolidaySearch.submit();
			}
			}else if(f_query_add_mod.document.forms[0]&&f_query_add_mod.document.forms[0].name=="FMHolidayQueryResult"){  
			/* var maxRecordCount=parseInt(f_query_add_mod.document.forms[0].maxRecordCount.value);
			 var flag=false;
			 for(var i=0;i<maxRecordCount;i++){			   
			   if(f_query_add_mod.document.forms[0].checkBox[i]&&f_query_add_mod.document.forms[0].checkBox[i].checked==true){
			      flag=true;
			   }
			  }	
              if(!flag){ alert('117');
				var error=getMessage("NO_RECORD_INSERTION","FM");
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;	
              }				
			  if(flag){ alert('121');
				f_query_add_mod.document.forms[0].action="../../servlet/eFM.FMHolidayServlet";
				f_query_add_mod.document.forms[0].target="messageFrame";				
				f_query_add_mod.document.forms[0].submit();
			}*/
			
			var selValues="";
			var selValues1="";
			len=f_query_add_mod.document.FMHolidayQueryResult.checkBox.length;  
			obj=f_query_add_mod.document.FMHolidayQueryResult.checkBox;
			Obj=f_query_add_mod.document.FMHolidayQueryResult;
			
			if (Obj.selectall.checked){
				var str="111111111111111";
			}else{
				var str="000000000000000";
			}
			if (len!=null && len!=''){
				for (i=0;i<len;i++){
					if (obj[i].checked){ 
						str=f_query_add_mod.replace(str,i+1,'1') ;
						selValues1=Obj.holiday_fs_locn_code[i].value+'$'+Obj.holidayDate[i].value+'|';
						selValues+=selValues1;
						
					}
				}
			}else if(len==null){		
				      if(obj.checked){
							var str="10000000000000";
							selValues=Obj.holiday_fs_locn_code.value+'$'+Obj.holidayDate.value+'|';
			          }
				
			}						
			f_query_add_mod.document.FMHolidayQueryResult.selectedValues.value=selValues;
			f_query_add_mod.document.FMHolidayQueryResult.selCheckBoxes.value=str;
			var fromPage=f_query_add_mod.document.FMHolidayQueryResult.currentPage.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH steps='FMHoliday' fromPage=\""+fromPage+"\" currSelHolidays=\""+selValues+"\"/></root>";			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","FMConfirmPullingListConfirmAll.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			eval(responseText)
			if (result){
				f_query_add_mod.document.FMHolidayQueryResult.submit();
				//parent.frames[2].document.getElementById("holiday").rows="8%,28%,*,8%";
	
			}else{
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				parent.frames[2].document.getElementById("mrdholiday").rows="8%,*,2%,8%";
			}
		}else{
		//if(frames[2].document.forms[0]&&frames[2].document.forms[0].operation.value=="insert"){
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				
			}
			
			  
		
			
}
  




//Added


function validate_date_from(from)
{
	var sys=document.mrdHolidaySearch.sys_date;
	if(from.value!=""){
		if(!validDateObj(from,"DMY",localeName)){
				from.value="";
				return ;
		}
	var obj1=convertDate(from.value,"DMY",localeName,"en");
		if(isBefore(sys.value,obj1,'DMY',localeName)==false){
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				from.value="";
				from.select();	
				return false;
		 }
			else
				return true;

	}
}
function validate_date_to(to,from)
{
	if(to.value!=""){
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
	    }
		if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
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
						document.mrdHolidaySearch.holiday_end.value="";
						document.mrdHolidaySearch.holiday_end.focus();
					
					tosubmit=false;
				}else
				{
					tosubmit=true;
				}

}

}
function month_check()
{          
			var strDate=document.mrdHolidaySearch.holiday.value;
			var end_date=document.mrdHolidaySearch.holiday_end.value;
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
						document.mrdHolidaySearch.holiday_end.value="";
						document.mrdHolidaySearch.holiday_end.focus();
					
					tosubmit=false;
				}else
				{
				tosubmit=true;
				}

			}
	

}
function onSuccessMrdlocn()
{  
	
	//parent.frames[1].location.reload();
	parent.frames[2].location.href="../eCommon/html/blank.html";
}
function reset() { 
	if(f_query_add_mod.document.forms[0])f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {  
  
     if(frames[2].document.forms[0]&&frames[2].document.forms[0].operation.value=="insert"){	 
		create();
	 }else if(frames[1].document.mrdHolidaySearch && frames[1].document.mrdHolidaySearch.operation.value=="delete"){ 
	 query();
	
	 }else if(frames[1].document.FMHolidayQueryResult && frames[1].document.FMHolidayQueryResult.operation.value=="multipledelete"){  
	 query();
	
	 }	
	
}
function modifyFMHoliday(holiday_fs_locn_code,holiday_date,holidayreason,holiday,holiday_fs_locn_desc,facilityId){ 

	parent.frames[1].location.href="../../eFM/jsp/HolidayForMrdSearchCriteria.jsp?function_mode=modify&operation=modify&holiday_date="+holiday_date+"&holiday="+holiday+"&facilityId="+facilityId+"&holiday_fs_locn_code="+holiday_fs_locn_code+"&holiday_fs_locn_desc="+encodeURIComponent(holiday_fs_locn_desc)+"&holidayreason="+holidayreason; 
	
}
function checkBoxOnClick(obj,i){ 
if (obj.checked==false){
	document.getElementById("selectall").checked=false;
}

}

function ClearMsg(){
	
	//document.getElementById("show_prev_next").style.visibility='hidden';
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function selectAll_S(obj){
	var len= document.querySelectorAll('input[type=checkbox]').length; 
	if (len!=null){
		if (obj.checked){
			for (i=0;i<len;i++){
				document.querySelectorAll('input[type=checkbox]')[i].checked=true;
			}
		}else{
			for (i=0;i<len;i++){
				document.querySelectorAll('input[type=checkbox]')[i].checked=false;
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

function onSuccess1() { 
	f_query_add_mod.location.reload();
	//f_query_add_mod1.location.reload();
	//f_query_add_mod1.location.href="../eCommon/html/blank.html";
}

function prevnextsubmission(flag1,fs_locn_code,long_desc,holiday_date,orderCols,prevnextsub,operation){

	if(prevnextsub=="Y"){
		var msg=getMessage("RECORD_DELETED","SM");
		alert(msg)
		parent.document.getElementById("mrdholiday").rows="8%,*,0%,8%";
		//parent.f_query_add_mod.location.href="../../eCommon/html/blank.html";
		//parent.f_query_add_mo1.location.href="../../eCommon/html/blank.html";
		parent.f_query_add_mod.location.href ="../eFM/jsp/HolidayForMrdQueryResult.jsp?fs_locn_code="+fs_locn_code+"&long_desc="+long_desc+"&holiday_date="+holiday_date+"&orderCols="+orderCols+"&operation=multipledelete";
		//parent.f_query_add_mod.location.href ="../eFM/jsp/HolidayForMrdQueryResult.jsp?orderCols="+orderCols+"&operation=multipledelete";
		//parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num="+msg;
	}else{
		var msg=getMessage("RECORD_DELETED","SM");
		alert(msg);
		parent.document.getElementById("mrdholiday").rows="8%,*,2%,8%";
		parent.f_query_add_mod.location.href ="../eFM/jsp/HolidayForMrdQueryPage.jsp" ;
		parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num=";
		//frames[2].location.href="../../eCommon/html/blank.html";
	}
}
function replace(str,pos,chr){
  var len= str.length;
  return(str.substr(0,parseInt(pos))+chr+str.substr(parseInt(pos)+1,len));
}

function reset() {

  f_query_add_mod.document.forms[0].reset() ;
  if(frames[2].document.forms[0])
  {
	frames[2].location.href="../../eCommon/html/blank.html";
  }

}
function SpeCharRestriction(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = '`~!@#$%^&*()_-+={[]}|\\:;"\'<,.>?/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}
function reasonCheck(obj1,obj2)
{
	var reason=eval("document.forms[0].holiday_reasion_"+obj2).value;
	
	if(reason =="")
	{
  //alert("document.forms[0].select_yn"+obj2);
		if(eval("document.forms[0].selected_"+obj2).checked ==true)
		{
		eval("document.forms[0].selected_"+obj2).checked=false;
		}
	}
}

