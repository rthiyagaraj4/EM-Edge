/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/SetupOperationTimeRangesAddModify.jsp?mode=insert';
}

function apply()
{ 
	var formObj = f_query_add_mod.document.forms[0];
	if(formObj!=null)
    {
	var time_range_code = f_query_add_mod.document.forms[0].time_range_code.value;
	var mode = f_query_add_mod.document.forms[0].mode.value;
	var timeRangeCode=getLabel("eOT.TimeRangeCode.Label","OT");
	var timeSlot=getLabel("eOT.TimeSlot.Label","OT");
	var fields = new Array (f_query_add_mod.document.forms[0].time_range_code,f_query_add_mod.document.forms[0].time_slot_1,f_query_add_mod.document.forms[0].time_slot_2,f_query_add_mod.document.forms[0].time_slot_3,f_query_add_mod.document.forms[0].time_slot_4,f_query_add_mod.document.forms[0].time_slot_5,f_query_add_mod.document.forms[0].time_slot_6,f_query_add_mod.document.forms[0].time_slot_7,f_query_add_mod.document.forms[0].time_slot_8,f_query_add_mod.document.forms[0].time_slot_9,f_query_add_mod.document.forms[0].time_slot_10);
	//var names = new Array ("Time Range Code","Time Slot One","Time Slot Two","Time Slot Three","Time Slot Four","Time Slot Five","Time Slot Six","Time Slot Seven","Time Slot Eight","Time Slot Nine","Time Slot Ten");
  var names = new Array (timeRangeCode,timeSlot+" "+"1",timeSlot+" "+"2",timeSlot+" "+"3",timeSlot+" "+"4",timeSlot+" "+"5",timeSlot+" "+"6",timeSlot+" "+"7",timeSlot+" "+"8",timeSlot+" "+"9",timeSlot+" "+"10");
	if(checkFieldsofMst( fields, names, messageFrame)) 
		{
		  if(chkForDuplicates()){
			 if(checkTime()){
			  f_query_add_mod.document.forms[0].submit();
             if(mode=="insert")
			{
				 // f_query_add_mod.document.forms[0].submit();
               f_query_add_mod.location.href='../../eOT/jsp/SetupOperationTimeRangesAddModify.jsp?mode=insert';
			 commontoolbarFrame.location.reload();
	    
			}
	        else
			{
              // f_query_add_mod.document.forms[0].submit();
			   f_query_add_mod.location.href='../../eOT/jsp/SetupOperationTimeRangesAddModify.jsp?mode=modify&time_range_code='+time_range_code;
		       f_query_add_mod.location.reload();

		       commontoolbarFrame.location.reload();
	            
		  }
		 }//end of checkTime
	  }//end of chkForDuplicates
	}
    } else{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}		
   
}
function chkForDuplicates()
{
	
	var formObj=f_query_add_mod.document.forms[0];
    var time_range_code=formObj.time_range_code.value;
	var time_range_code_from_DB=formObj.time_range_code_from_DB.value;
	//var err_txt="APP-OT40 Time Range Code Cannot be Duplicated...";
	var err_txt=getMessage("DUPLICATE_CODE_EXISTS","common");
    if(time_range_code_from_DB.indexOf(time_range_code)>=0 ){
			window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		 return false;
	 }else       
	  return true;
}
function checkTime(){
	var arrObj=f_query_add_mod.document.forms[0].elements;
	var err_txt="";

		for(var i=0;i<arrObj.length;i++){
			if(arrObj[i].type=="text" && arrObj[i].name!="time_range_code"){
				var k=0;
				if (arrObj[i].name=="time_slot_1" || arrObj[i].name=="time_slot_2"){
					  k=1
				}else if (arrObj[i].name=="time_slot_3" || arrObj[i].name=="time_slot_4"){
					 k=2
				}else if (arrObj[i].name=="time_slot_5" || arrObj[i].name=="time_slot_6"){
					 k=3
				}else if (arrObj[i].name=="time_slot_7" || arrObj[i].name=="time_slot_8"){
					 k=4
				}else if (arrObj[i].name=="time_slot_9" || arrObj[i].name=="time_slot_10"){
					 k=5
				}

					if(arrObj[i+1].value>arrObj[i].value){
						continue;
					}else if(arrObj[i+1].value==arrObj[i].value){
						
						if(arrObj[i].name=="time_slot_1" ||arrObj[i].name=="time_slot_3" ||arrObj[i].name=="time_slot_5" ||arrObj[i].name=="time_slot_7" ||arrObj[i].name=="time_slot_9"){
							// err_txt="Slot "+(k)+"   From Time should not be equal  to To time ";
							 err_txt="Slot "+(k)+"  "+" From Time should  be less than to To time ";
						}else{
							err_txt="Slot   "+k+ "  "+"To time should  be less than to Slot "+(k+1)+ "  "+"From time"; 
						}
					      arrObj[i].focus();
                          arrObj[i].select();							
						  window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
						  return false;					
						  }else{
						if(arrObj[i].name=="time_slot_1" ||arrObj[i].name=="time_slot_3" ||arrObj[i].name=="time_slot_5" ||arrObj[i].name=="time_slot_7" ||arrObj[i].name=="time_slot_9"){

						  //err_txt="Time Field "+i+" cannot be greater than time field "+(i+1);//Time Field 1 cannot be greater than time field 2 

						 err_txt="Slot "+(k)+"  From Time  should  be less than to To time ";
						
						}
					     arrObj[i].focus();
                         arrObj[i].select();
						  //window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
						  window.parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
						  return false;
					}
			  }
				
		}//for end
      return true;
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/SetupOperationTimeRangesAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SetupOperationTimeRangesAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("SetupOperationTimeRanges.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("SetupOperationTimeRangesQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/SetupOperationTimeRangesQueryCriteria.jsp?';
}

function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}
