/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------
Date       Edit History     	    Name        	Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
?             100           	     ?           										created
21/04/2014	IN047658		Vijayakumar K		14/03/2014		Chowminya G		Reopen - Result Reporting > Result Entry 'Comments-webpage dialog', 'OK' button disappear from the screen.
28/11/2017	IN061890		Kamalakannan G		28/11/2017		Ramesh G		ML-MMOH-CRF-542		
05/12/2017	IN066006		Kamalakannan G		05/12/2017		Ramesh G		OR-ML-MMOH-CRF-0542/01
04/06/2018	IN066548		Kamalakannan G		04/06/2018		Ramesh G		ML-MMOH-CRF-1076
06/06/2018	IN067881 		Kamalakannan G		04/06/2018		Ramesh G		CA-ML-MMOH-CRF-1076/01-Result Reporting
--------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;

// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function checkAll(){
	
	if (document.complete_order_dtl.select_all.checked == true)
	{
		for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
			if(val) 
			{
				if(!val.disabled)
				{
					val.checked = true;
					val.value = 'Y';
				}
			}			
		}

	}else{
		document.complete_order_dtl.select_all.value = 'N';
		for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
		{
			val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
			if(val) {
				val.checked = false;
				val.value = 'N';
			}
			eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+cnt).value = "";
			eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+cnt).value ="";
		}
		parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value = "";
		parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value = "";
	
	}

}
async function clickAll(complete_remarks_mand_yn){
	if (complete_remarks_mand_yn =="Y")
	{
		if(document.complete_order_dtl.select_all.checked == true){
		var retVal = await checkHeader(document.complete_order_dtl.select_all,complete_remarks_mand_yn);
		
			if (retVal != null) {
			 var returnVal	= retVal.split("||") ;	
     
			for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
			{
				val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
				if(val) 
				{
					if(!val.disabled)
					{
						val.checked = true;
						val.value = 'Y';
					}
				}
				eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+cnt).value = returnVal[0];
                eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+cnt).value = returnVal[1];

			}
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value = returnVal[0];
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value = returnVal[1];
			//clickHeader();
		}else if(retVal == null){
			
			document.complete_order_dtl.select_all.value = 'N';
			document.complete_order_dtl.select_all.checked = false;
            for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
			{
				val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
				if(val) {
					val.checked = false;
					val.value = 'N';
				}
				eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+cnt).value = "";
                eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+cnt).value ="";
			}
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value = "";
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value = "";
		}

		}else{
			document.complete_order_dtl.select_all.value = 'N';
            for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
			{
				val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
				if(val) {
					val.checked = false;
					val.value = 'N';
				}
				eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+cnt).value = "";
                eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+cnt).value ="";
			}
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value = "";
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value = "";
		}
	}else if (complete_remarks_mand_yn =="N")
	{
		var retVal = await checkHeader(document.complete_order_dtl.select_all,complete_remarks_mand_yn);
		if (retVal != null) {
			 var returnVal	= retVal.split("||") ;	
     
			for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
			{
				/*val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
				if(val) {
					val.checked = true;
					val.value = 'Y';
				}*/
				eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+cnt).value = returnVal[0];
                eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+cnt).value = returnVal[1];

			}
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value = returnVal[0];
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value = returnVal[1];
			//clickHeader();
		}else if(retVal == null){
			
			document.complete_order_dtl.select_all.value = 'N';
			document.complete_order_dtl.select_all.checked = false;
            for(cnt=0; cnt<parent.CompleteOrderDtl.document.complete_order_dtl.total_recs.value; cnt++)
			{
				val = eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+cnt);
				if(val) {
					val.checked = false;
					val.value = 'N';
				}
				eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+cnt).value = "";
                eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+cnt).value ="";
			}
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value = "";
			parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value = "";
		}
	}
		
}


async function viewOrderFormatLineCmts1(can_reason,line,order_line_num,orderId){
	var instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");
		var dialogHeight ='14' ;
		//IN047658 reopen starts
		//var dialogWidth = '29' ;
		var dialogWidth = '40' ;
		//IN047658 reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
			
		if("E" == instrn_type)
		{
			dialogHeight ='30' ;			
			dialogWidth = '40' ;
		}
		//IN047658 reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 reopen ends

		var arguments = "";
		var line_narration = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Cmts"+line+".value");
		//var finalString	= "&can_reason="+can_reason+"&order_line_num="+order_line_num+"&orderId="+orderId;
		var finalString	= "&can_reason="+can_reason+"&order_line_num="+order_line_num+"&orderId="+orderId+'&instrn_type='+instrn_type;
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewLineComment.jsp?"+finalString,arguments,features);

}



function clickHeader(){
	var ord_cat = parent.CompleteOrderDtl.document.complete_order_dtl.ord_category.value;
	var completed_at = "header"
	var reason_desc = parent.CompleteOrderDtl.complete_order_dtl.complete_all_desc.value
	//addCompleteComments(ord_cat,completed_at,reason_desc)

}


function clickLine(){
	var ord_cat = parent.CompleteOrderDtl.document.complete_order_dtl.ord_category.value;
	var completed_at = "line"

	var reason_desc = parent.CompleteOrderDtl.complete_order_dtl.complete_all_desc.value
	//addCompleteComments(ord_cat,completed_at,reason_desc)

}

async function checkHeader(obj,complete_remarks_mand_yn) {
  //  if (obj.checked == true) {
        var dialogHeight= '41vh' ;
		//IN047658 reopen starts
        //var dialogWidth = '24' ;
		var dialogWidth = '42vw' ;
		//IN047658 reopen ends
        var dialogTop	= '10';
        var dialogLeft 	= '30' ;
        var title 	= ''
        var from_function = "SearchResult"
        var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+';scroll=no; status=no';
        var arguments 	= "";
     //   obj.value = "Y";

        var complete_remarks	= parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_remarks.value;
        var order_complete_date	= parent.CompleteOrderDtl.document.complete_order_dtl.complete_all_date.value;
        var start_date_time	= parent.CompleteOrderDtl.document.complete_order_dtl.start_all_date_time.value;

		var curr_sys_date	= parent.CompleteOrderDtl.document.complete_order_dtl.curr_sys_date.value;
		var curr_sys_date_sec	= parent.CompleteOrderDtl.document.complete_order_dtl.curr_sys_date_sec.value;

        var retVals = await window.showModalDialog("../../eOR/jsp/CompleteOrderRemarks.jsp?&complete_remarks="+encodeURIComponent(complete_remarks)+"&order_complete_date="+order_complete_date+"&curr_sys_date="+curr_sys_date+"&curr_sys_date_sec="+curr_sys_date_sec+"&start_date_time="+start_date_time+"&complete_remarks_mand_yn="+complete_remarks_mand_yn,arguments,features);
		if (retVals != null) return retVals
//	}		
		
}

//Added by Sridhar Reddy On 12/06/2010 for PMG20089-CRF-0804
async function callCompleteOrderRemarks(rec_num,complete_remarks_mand_yn){
	var dialogHeight= '30vh' ;
	//IN047658 reopen starts
	//var dialogWidth = '24' ;
	var dialogWidth = '25vw' ;
	//IN047658 reopen ends
	var dialogTop	= '20';
	var dialogLeft 	= '20' ;
	var title 	= ''
	var from_function = "SearchResult"
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	var arguments 	= "";
	//eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).value = 'Y';

	var complete_remarks	= parent.CompleteOrderDtl.document.getElementById('complete_remarks'+rec_num).value;
	var order_complete_date	= parent.CompleteOrderDtl.document.getElementById('complete_date'+rec_num).value;
	
	var start_date_time	= eval("parent.CompleteOrderDtl.document.complete_order_dtl.start_date_time"+rec_num).value;
	
	var curr_sys_date	= parent.CompleteOrderDtl.document.complete_order_dtl.curr_sys_date.value;
	var curr_sys_date_sec	= parent.CompleteOrderDtl.document.complete_order_dtl.curr_sys_date_sec.value;

	var retVals = await top.window.showModalDialog("../../eOR/jsp/CompleteOrderRemarks.jsp?&complete_remarks="+encodeURIComponent(complete_remarks)+"&order_complete_date="+order_complete_date+"&curr_sys_date="+curr_sys_date+"&curr_sys_date_sec="+curr_sys_date_sec+"&start_date_time="+start_date_time+"&complete_remarks_mand_yn="+complete_remarks_mand_yn,arguments,features);
	//var str =unescape(retVals);
	//var arr = str.split(",");
	if (retVals != null) {
		var returnVal		= retVals.split("||") ;
		parent.CompleteOrderDtl.document.getElementById('complete_remarks'+rec_num).value = returnVal[0];
		parent.CompleteOrderDtl.document.getElementById('complete_date'+rec_num).value = returnVal[1];
		
	}else if(retVals == null) 
  {
		eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).value = 'N';
		eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).checked = false;
		eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+rec_num).value = "";
		eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+rec_num).value = "";
	
	}

}
function checkLine1(rec_num,complete_remarks_mand_yn) {		
		if(eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).checked == true )
		{
			eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).value = 'Y';
		} else {
		   eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).value = 'N';
		   parent.CompleteOrderDtl.document.complete_order_dtl.select_all.value = 'N';
		   parent.CompleteOrderDtl.document.complete_order_dtl.select_all.checked = false;
		   eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+rec_num).value = "";
		   eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+rec_num).value = "";
		}
}  
//End
async function checkLine(rec_num,complete_remarks_mand_yn) {	
	if (complete_remarks_mand_yn =="Y")
	{
		if(eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).checked == true )
		{
			eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).value = 'Y';
			await callCompleteOrderRemarks(rec_num,complete_remarks_mand_yn);
		} else {
		   eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+rec_num).value = 'N';
		   eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+rec_num).value = "";
		   eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_date"+rec_num).value = "";
		}
	}else if (complete_remarks_mand_yn =="N")
	{
		await callCompleteOrderRemarks(rec_num,complete_remarks_mand_yn);
	}    
}

function checkValidDateTime(obj){
	if(obj.value!='') {
		if(!doDateTimeChk1(obj)) {
	    	alert(getMessage("INVALID_DATE_TIME_FORMAT","OR"));
			document.completeRemarks.order_complete_date.focus();			
	    	document.completeRemarks.order_complete_date.select();
			document.completeRemarks.order_complete_date.value="";	
	    }
    }
	//var curr_sys_date_sec			= document.completeRemarks.curr_sys_date_sec;
	var curr_sys_date			= document.completeRemarks.curr_sys_date;
	var start_date_time		= document.completeRemarks.start_date_time;
	
	if(obj!=null && obj.value !=""){
	//if(!ValidateDateTime1(start_date_time, obj)){
	if(!ValidateDateTime(start_date_time, obj)){
		alert(getMessage("COMPLETE_DATE_TIME_START_DATE_TIME_CHK","OR"));		
		document.completeRemarks.order_complete_date.focus();
	    document.completeRemarks.order_complete_date.select();
		document.completeRemarks.order_complete_date.value="";
		return false
		
	}
	//if(!ValidateDateTime1(obj,curr_sys_date_sec )){
	if(!ValidateDateTime(obj,curr_sys_date )){
		alert(getMessage("COMPLETE_DATE_TIME_SYSDATE_TIME_CHK","OR"));		
		document.completeRemarks.order_complete_date.focus();
	    document.completeRemarks.order_complete_date.select();
		document.completeRemarks.order_complete_date.value="";
		return false
		
	}
	}
}
/************Date validations in the format dd/mm/yyyy hh:mi:ss***************/

function doDateTimeChk1(obj)
{
if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
{
	
      retval= false
      obj.focus()
}
else
{
	var comp=obj
	obj=obj.value
	var dttime = obj.split(" ");
	var dt
	var time
	var retval=true
		
	if(dttime.length>1)
	{
		dt=dttime[0]
		time=dttime[1]
			var ccnt=0;
			var b;
			for(b=0;b<time.length;b++)
		{
			if(time.charAt(b)==":")
			ccnt++;
		}
				
		
		if(ccnt==1)
		{
				time+=':00';
		}
		parent.document.completeRemarks.order_complete_date.value=dt+" "+time;
		if(!checkDt1(dt) )
		{
			retval= false
			comp.focus()
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
				 comp.focus()
			}
			else
			{
				if(!chkTime1(time))
				{
					retval= false
					comp.focus()
				}
			}
		}
	}
	else
	{
		retval= false
		comp.focus()
	}
	if(retval)
	{
		//callDateFunction(comp)
	}
	}
	return retval
}

function checkDt1(date1)
{
	retval=true
	var date1arr=new Array()

    date1arr=date1.split("/")
	if(date1arr.length==3)
	{
		var date1d=date1arr[0]
		var date1m=date1arr[1]
		var date1y=date1arr[2]
							
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
function chkTime1(time1)
{
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
	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")
		if(time1arr.length==3)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]
            var time1sec=time1arr[2]
			time1hr=eval(time1hr)
			time1min=eval(time1min)
			time1sec=eval(time1sec)
			if(time1hr<=23)
			{
				if(time1min>59)
				{
					retval=false;
				}
				if(time1sec>59)
				{
					 retval=false;
				}

			}
			else
				retval=false;
		}
		else
			retval=false;
	}
	else
		retval=false;
}
		return retval
}
/*function ValidateDateTime1 (from,obj)
{

		to   = obj.value
	    from = from.value
        var a=  from.split(" ")
        splitdate=a[0];
        splittime=a[1]
	
		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")
		
		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]),eval(splittime1[2]))
	 
		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]
		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")


		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]),eval(splittime1[1]), eval(splittime1[2]))

     
	 if(Date.parse(to_date) < Date.parse(from_date))
      {
        
	     return false;
      }else
		  return true;
}*/
/************End of Date validations in the format dd/mm/yyyy hh:mi:ss***************/

function closeRemarks() 
{
	var complete_remarks_mand_yn = document.completeRemarks.complete_remarks_mand_yn.value;
	if (complete_remarks_mand_yn=="Y")
	{
		if(document.completeRemarks.order_complete_date.value=="")
		{
			alert(getMessage("COMPLETE_DATE_TIME_CANNOT_BLANK","OR"));
			return false;
		}
		if(!trimCheck(document.completeRemarks.complete_remarks.value))
		{		
			alert(getMessage("SPECIMEN_COLLECTION_DISPATCH_REMARKS_BLANK","OR"));
			return false;		  		 
		}
	}					

	window.returnValue = document.completeRemarks.complete_remarks.value+"||"+document.completeRemarks.order_complete_date.value;		
	window.close();	   
}

function chkRemarksLength() 
{
	if (document.completeRemarks.complete_remarks.value.length > 255) 
	{
        alert(getMessage("REMARK_CANT_EXCEED_255_CHAR","OR"));
		document.completeRemarks.complete_remarks.focus();
        return false;
    }else 
		return true;
}

async function addCompleteComments(ord_cat,completed_at,reason_desc){
		var dialogHeight ='12' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;

		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "ord_cat="+ord_cat+"&completed_at="+completed_at+"&reason_desc="+reason_desc;

		var retVals = await window.showModalDialog("../../eOR/jsp/CompleteComment.jsp?"+finalString,arguments,features);
		parent.CompleteOrderDtl.complete_order_dtl.complete_all_desc.value = retVals
}


async function viewAllCompleteComments(){
		var all_cmnts = parent.CompleteOrderDtl.complete_order_dtl.complete_all_desc.value
		var dialogHeight ='12' ;
		var dialogWidth = '30' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var finalString	= "all_cmnts="+all_cmnts;

		var retVals = await window.showModalDialog("../../eOR/jsp/CompleteOrderAllCmts.jsp?"+finalString,arguments,features);

}

function displayDesc(obj){
	document.complete_comment.reason_desc.value = obj.value;
}


function CheckMaxLength(obj,max) {
	if(obj.value.length >= max) {
		//alert("Max limit of Text is 255 Characters");
		alert(getMessage('MAX_255_CHARS','OR'))
		return false;
	} else return true;
}

function selectReason(){
	if(document.complete_comment.reason_desc.value == ""){
//		alert("Reason Can not be Blank...");
alert(getMessage("REASON_CANT_BLANK","OR"));
		return false;
	}
	if(document.complete_comment.reason_desc.value.length >= 255) {
		//alert("Cannot exceed 255 Characters...");
		alert(getMessage("NUM_OF_CHARACTERS","OR"));
		return false;
	}
	window.returnValue = document.complete_comment.reason_desc.value;
	window.close();
}



//called when the cancel button is pressed
function completeOrder(){
	var no_of_checked = 0;
	var formObj = parent.CompleteOrderDtl.document.complete_order_dtl


	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("formObj.chk"+cnt);
		if(val){
			if(val.checked == true){
				if(eval("formObj.complete_remarks"+cnt).value == "")
					eval("formObj.complete_remarks"+cnt).value = "Auto Complete";
				no_of_checked++;
			}else{
			}
		}
	}

	if(parseInt(no_of_checked) == 0){
		alert(getMessage("CLICK_ANY_ONE","OR"));
		return false
	}


//the fg for loop is used to check the Imediate orderstatus of the order
//while cancelling the line level record  -------- Begin
var found = 0;
var ord_st_val = "";
	for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("formObj.chk"+cnt);

		if(val){
			if(val.checked == true){
				//no_of_checked++;
			}else{
				if(found == 0){
					var ord_st =  eval("formObj.line_status"+cnt);
					found++
					ord_st_val = ord_st.value
					formObj.line_stat_to_updt.value = ord_st_val
				}else{
					continue
				}
			}
		}else{
			if(found == 0){
				ord_st =  eval("formObj.line_status"+cnt);
				found++
				ord_st_val = ord_st.value
				formObj.line_stat_to_updt.value = ord_st_val
			}else{
				continue
			}
		}
	}
	if(parseInt(no_of_checked) == 1){
		ord_st =  formObj.line_status0
		found++
		ord_st_val = ord_st.value
		formObj.line_stat_to_updt.value = ord_st_val
	}
//-------- End


	if(parent.CompleteOrderDtl.document.complete_order_dtl.select_all.checked == true)
		formObj.complete_type.value = "H";
	else
		formObj.complete_type.value = "L";

	eval(formApply( parent.CompleteOrderDtl.document.complete_order_dtl,OR_CONTROLLER)) ;
	//alert(result)

	if( result ) {
		alert(getMessage("RECORD_MODIFIED","SM") ) // this will display "operation compelted successfully" - message
		onSuccess();
	}else{
		if( getMessage(message,"OR") != "" ){
			message = getMessage(message,"OR");
			if(invalidCode != "" && eval(parent.CompleteOrderDtl.document.getElementById("status"+invalidCode)))
				eval(parent.CompleteOrderDtl.document.getElementById("status"+invalidCode)).className = "orcancel";
		}
		if (message.indexOf("<br>") != -1) 
		{
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message);
	}
}

function assignResult(_result, _message, _flag, _code){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;

}


function onSuccess() {

	//window.close();
	parent.parent.document.getElementById('dialog_tag').close();
	//	parent.parent.parent.frames[1].location.href=qry_string
	//	qry_string_fr_print = qry_string_fr_print.substr(1,qry_string_fr_print.length)
		//alert(qry_string_fr_print)
		//window.open("OnlinePrinting.jsp?"+qry_string_fr_print,"Test","height=200,width=400,status=no,toolbar=no,menubar=no,location=yes")
		//qry_string_fr_print = "";
}



//this function will give the final xml string on click of apply
/*function beforePost(str) {
	alert(str)
}*/


//function viewCompletePrepsData(line){
async function viewCompletePrepsData(line,order_line_num){
	var instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");
		var dialogHeight ='12' ;
		//IN047658 reopen starts
		//var dialogWidth = '30' ;
		var dialogWidth = '40' ;
		//IN047658 reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
			
		if("E" == instrn_type)
		{
			dialogHeight ='30' ;			
			dialogWidth = '40' ;
		}
		//IN047658 reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 reopen ends

		var arguments = "";
		//var preps_data = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Preps"+line+".value");
		//var finalString	= 'line='+line;
		var finalString	= 'line='+line+'&order_line_num='+order_line_num+'&instrn_type='+instrn_type;		
		//alert("finalString"+finalString);
		
		var retVals = await window.showModalDialog("../../eOR/jsp/ViewPrepsData.jsp?"+finalString,arguments,features);

}


//function viewCompleteDeptData(line){
async function viewCompleteDeptData(line,order_line_num){
	var instrn_type = eval("document.complete_order_dtl.instrn_type"+line+".value");
		var dialogHeight ='12' ;
		//IN047658 - reopen starts
		//var dialogWidth = '30' ;
		var dialogWidth = '40' ;
		//IN047658 - reopen ends
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
			
		if("E"==instrn_type)
		{
			dialogHeight ='30' ;		
			dialogWidth = '40' ;
		}
			
		//IN047658 - reopen starts
		//var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
		//IN047658 - reopen ends

		var arguments = "";
		//var dept_data = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Depts"+line+".value");
		//var finalString	= 'dept_data='+ encodeURIComponent(dept_data);
		//var finalString	= 'line='+line;
		var finalString	= 'line='+line+'&order_line_num='+order_line_num+'&instrn_type='+instrn_type;

		var retVals = await window.showModalDialog("../../eOR/jsp/ViewDeptData.jsp?"+finalString,arguments,features);

}

async function viewCompleteApptData(line){
		var dialogHeight ='27' ;
		var dialogWidth = '36' ;
		var dialogTop	= '189';
		var dialogLeft = '167' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var appt_ref_num = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Appt"+line+".value");
		var appt_date = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Appt_date"+line+".value");
		var appt_locn	 			= eval("parent.CompleteOrderDtl.document.complete_order_dtl.appt_locn"+line+".value");
		var appt_resched_yn			= eval("parent.CompleteOrderDtl.document.complete_order_dtl.appt_resched_yn"+line+".value");
		var appt_resched_reason		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.appt_resched_reason"+line+".value");
		var no_of_reschedules		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.no_of_reschedules"+line+".value");
		var order_category			= eval("parent.CompleteOrderDtl.document.complete_order_dtl.order_category"+line+".value");

		var cont_order_ind = eval("parent.CompleteOrderDtl.document.complete_order_dtl.cont_order_indicator"+line+".value");
		var parent_order_id = eval("parent.CompleteOrderDtl.document.complete_order_dtl.parent_order_id"+line+".value");
		var parent_order_line_num = eval("parent.CompleteOrderDtl.document.complete_order_dtl.parent_order_line_num"+line+".value");
		var bean_id = parent.CompleteOrderDtl.document.complete_order_dtl.bean_id.value;
		var bean_name = parent.CompleteOrderDtl.document.complete_order_dtl.bean_name.value;
		var function_from = parent.CompleteOrderDtl.document.complete_order_dtl.function_from.value;
		//Modifed by Uma on 3/17/2010 for IN020017
		var finalString				= "appt_ref_num="+ escape(appt_ref_num)+"&appt_date="+escape(appt_date)+"&cont_order_ind="+escape(cont_order_ind)+"&parent_order_id="+escape(parent_order_id)+"&parent_order_line_num="+escape(parent_order_line_num)+"&appt_locn="+escape(appt_locn)+"&appt_resched_yn="+escape(appt_resched_yn)+"&appt_resched_reason="+escape(appt_resched_reason)+"&no_of_reschedules="+escape(no_of_reschedules)+"&order_category="+escape(order_category);
		finalString					+= "&bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&function_from="+escape(function_from)

		var retVals = await window.showModalDialog("../../eOR/jsp/ViewApptFrameset.jsp?"+finalString,arguments,features);

}

async function viewOACompleteApptData(line){
	
	/*var dialogHeight ='30' ;
	var dialogWidth = '48' ;
	var dialogTop	= '100';
	var dialogLeft = '30' ;*/
	var dialogHeight ='37.5' ;
	var dialogWidth = '50' ;
	var dialogTop	= '189';
	var dialogLeft = '167' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var appt_ref_num = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Appt"+line+".value");
		var appt_date = eval("parent.CompleteOrderDtl.document.complete_order_dtl.Appt_date"+line+".value");
 		var cont_order_ind = eval("parent.CompleteOrderDtl.document.complete_order_dtl.cont_order_indicator"+line+".value");
		var parent_order_id = eval("parent.CompleteOrderDtl.document.complete_order_dtl.parent_order_id"+line+".value");
		var parent_order_line_num = eval("parent.CompleteOrderDtl.document.complete_order_dtl.parent_order_line_num"+line+".value");
		var bean_id = parent.CompleteOrderDtl.document.complete_order_dtl.bean_id.value;
		var bean_name = parent.CompleteOrderDtl.document.complete_order_dtl.bean_name.value;
		var function_from = parent.CompleteOrderDtl.document.complete_order_dtl.function_from.value;
		var patient_id = parent.CompleteOrderDtl.document.complete_order_dtl.patient_id.value;
		var date1=appt_date.split(" ");
		appt_date=date1[0];
		var finalString				= 'i_appt_ref_no='+ escape(appt_ref_num)+'&i_appt_date='+appt_date+'&cont_order_ind='+escape(cont_order_ind)+'&parent_order_id='+escape(parent_order_id)+'&parent_order_line_num='+escape(parent_order_line_num);
		finalString					+= '&bean_id='+escape(bean_id)+'&bean_name='+escape(bean_name)+'&function_from='+escape(function_from)+'&patient_id='+patient_id+'&flag=Visit_Reg'
		var retVals = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?"+finalString,arguments,features);

}

async function checkOrderable(index) {
	//alert(index);
    if(eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+index).checked == true ){
        var dialogHeight= '39vh' ;
        var dialogWidth = '52vw' ;
        var dialogTop	= '10';
        var dialogLeft 	= '10' ;
        var title 	= ''
        var from_function = "SearchResult"
        var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
        var arguments 	= "";
        eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+index).value = 'Y';

        var complete_remarks	= eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+index).value
		
		var catalog_desc		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.catalog_desc"+index).value
		var catalog_code		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.catalog_code"+index).value
		
		var qrystr = eval("parent.CompleteOrderDtl.document.complete_order_dtl.qrystr").value
				
        //var retVals = window.showModalDialog("../../eOR/jsp/ReplaceAddOrderableFrameset.jsp?"+qrystr+"&complete_remarks="+complete_remarks+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&order_line_num="+index,arguments,features);
        var retVals =await window.showModalDialog("../../eOR/jsp/ReplaceAddOrderableRemarks.jsp?"+qrystr+"&complete_remarks="+complete_remarks+"&catalog_code="+catalog_code+"&catalog_desc="+encodeURIComponent(catalog_desc)+"&line_num="+parseInt(eval(index)+1)+"&function_from=Replace",arguments,features);
		if(retVals!=null && retVals=="replaced")
			window.close();
		else{
			eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+index).value = 'N';
			eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+index).checked = false;
		}

        /*if (retVals != null) {
            eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+index).value = retVals
        }*/
    }
	else {
	   eval("parent.CompleteOrderDtl.document.complete_order_dtl.chk"+index).value = 'N';
	}
}
/*function insertRow(index){
	index++;
	
	var row_cnt= document.replaceOrderableTop.row_cnt.value;
	row_cnt++;
	if(row_cnt >= 1 && row_cnt <10){
	
		eval("document.getElementById("replaceRow")"+row_cnt).style.display = "inline";
		document.replaceOrderableTop.row_cnt.value = row_cnt;
	}
	
	//alert(row_cnt);

}
function deleteRow(index){
	var row_cnt= document.replaceOrderableTop.row_cnt.value;
	if(row_cnt >= 1 && row_cnt <10){
		eval("document.getElementById("replaceRow")"+index).style.display = "none";
		document.replaceOrderableTop.row_cnt.value = --row_cnt;
	}
	
}*/

function callOrder(){
	//alert("replace order-->");
	//var row_cnt= parent.ReplaceAddOrderable.document.replaceOrderableTop.row_cnt.value;
	
	
	/*for(var x=0;x<=row_cnt;x++){
		
		//alert(eval("frmObj.replaceOrderableTop.replaceadd_orderable"+x).value+"-x-"+x);
		order_catalog[x]= eval("frmObj.replaceOrderableTop.replaceadd_orderable"+x).value;
		if(order_catalog.length >1){
			for(var y=0;y<order_catalog.length;y++){
		alert("--order_catalog["+x+"]-"+order_catalog[x]+"--order_catalog["+y+"]-"+order_catalog[y]);
				if(order_catalog[x] == order_catalog[y] && x != y){
					alert("Duplicate selection of orderables are not allowed");
					eval("frmObj.replaceOrderableTop.replaceadd_orderable"+x).focus();
					return false;
				}
			}
		}
	}*/
	//alert(order_catalog.length)
	
/*

	var dialogHeight ='27' ;
	var dialogWidth = '48' ;
	var dialogTop	= '129';
	var dialogLeft = '11' ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';

	var arguments = "";
	var qrystr = eval("parent.ReplaceAddRemarks.document.completeRemarks.qrystr").value;
	var practitioner_id =parent.ReplaceAddRemarks.document.completeRemarks.practitioner_id.value;
	//alert(qrystr);
	var finalString	= "&"+qrystr+"&practitioner_id="+practitioner_id;


	var retVals = window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?function_from=REPLACE_ADD&p_order_catalog_code=ABDASP&exist_order_category=TR&exist_order_type_code=GENS"+finalString, arguments,features);
*/
if(completeRemarks.function_from.value == "Replace"){
//IN066548 start
/*if(completeRemarks.replace_orderable0.value == ""){
	alert(getMessage("NEW_ORDER_CATALOG_BLANK","OR"));
	return false;*/
	
	if(completeRemarks.l_repl_ord_thro_termset_yn.value=='Y'){
		if(completeRemarks.rep_type.value=='C'){	
			if(completeRemarks.replace_orderable_code.value == ""){
				alert(getMessage("NEW_ORDER_CATALOG_BLANK","OR"));
				return false;
			}
		}else{
			if(completeRemarks.replace_orderable_code1.value == ""){
				alert(getMessage("NEW_ORDER_CATALOG_BLANK","OR"));
				return false;
			}//IN066548 end
		}
	}else{
		if(completeRemarks.replace_orderable0.value == ""){
			alert(getMessage("NEW_ORDER_CATALOG_BLANK","OR"));
			return false;
		}
	}
//IN066548 End.
if(completeRemarks.complete_remarks.value == ""){
	alert(getMessage("SPECIMEN_COLLECTION_DISPATCH_REMARKS_BLANK","OR"));
	return false;
}
}else if(completeRemarks.function_from.value == "ChargeType"){
if(completeRemarks.new_charge_type.value == ""){
	alert(getMessage("NEW_CHARGE_TYPE_BLANK","OR"));
	return false;
}
if(completeRemarks.charge_type_code.value==completeRemarks.new_charge_type.value){
	alert(getMessage("CHARGE_TYPE_NOT_SAME","OR"));
	return false;
}
}

	eval(formApply( document.completeRemarks,OR_CONTROLLER)) ;
	if( result ) {
		alert(getMessage("RECORD_MODIFIED","SM")); // this will display "operation compelted successfully" - message
		printValues(document.completeRemarks.bean_id.value,document.completeRemarks.bean_name.value);
		window.returnValue="replaced";
		window.close();		
	}else{
		if (message.indexOf("<br>") != -1) 
		{
			message = message.substring(0,message.indexOf("<br>"))
		}
		alert(message);
		return false;
	}
}
function clickClose(){
window.returnValue="closed";
window.close();
}

async function ChangeChargeType(index) {

        var dialogHeight= '21' ;
        var dialogWidth = '28' ;
        var dialogTop	= '290';
        var dialogLeft 	= '280' ;
        var title 	= ''
        var from_function = "SearchResult"
        var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
        var arguments 	= "";
       
        var complete_remarks	= eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+index).value
		
		var catalog_desc		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.catalog_desc"+index).value
		var catalog_code		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.catalog_code"+index).value
		var order_category		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.order_category"+index).value
		var charge_type_code		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.charge_type_code"+index).value
		var charge_type_desc		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.charge_type_desc"+index).value
		var patient_class		= eval("parent.CompleteOrderDtl.document.complete_order_dtl.patient_class"+index).value
		var patient_id		= parent.CompleteOrderDtl.document.complete_order_dtl.patient_id.value
		
		var qrystr = eval("parent.CompleteOrderDtl.document.complete_order_dtl.qrystr").value
			
        //var retVals = window.showModalDialog("../../eOR/jsp/ReplaceAddOrderableFrameset.jsp?"+qrystr+"&complete_remarks="+complete_remarks+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&order_line_num="+index,arguments,features);
        var retVals = await window.showModalDialog("../../eOR/jsp/ChangeChargeTypeRemarks.jsp?"+qrystr+"&complete_remarks="+complete_remarks+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&order_line_num="+index+"&order_category="+order_category+"&charge_type_code="+charge_type_code+"&charge_type_desc="+charge_type_desc+"&patient_class="+patient_class+"&patient_id="+patient_id+"&function_from=ChargeType",arguments,features);
		if(retVals!=null && retVals=="replaced")
			window.close();
		
        /*if (retVals != null) {
            eval("parent.CompleteOrderDtl.document.complete_order_dtl.complete_remarks"+index).value = retVals
        }*/

}


/*function showCalendar1(id, date_format,time_format,modal_yn)
{
var chk;
	chk=showCalendar(id,date_format,time_format);
	alert(chk)
	return chk;
}*/

async function callBilling(row_value,order_id,patient_id,performing_facility_id,encounter_id,patient_class,sex,colval,colval1,order_set_id)
{
	/*var dialogTop   = "300";
	var dialogLeft   = "300";
	var dialogHeight= "40" ;
	var dialogWidth = "60" ;*/
	var dialogTop   = "10";
	var dialogLeft   = "10";
	var dialogHeight= "90vh" ;
	var dialogWidth = "90vw" ;
	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +';dialogLeft:'+dialogLeft +'; scroll=yes; status=no';

	var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&sex="+ sex+"&patient_id="+ patient_id;
		finalString += "&encounter_id=" + encounter_id;
		finalString += "&row_value=" + row_value;
		//finalString += "&location_details=" + location_details;
		//finalString += "&priority=" + Priority;
		finalString += "&patient_class=" + patient_class;
		//finalString += "&order_type_code=" + order_type_code;
		//finalString += "&source_type=" + source_type;
		//finalString += "&source_code=" + source_code;
		finalString += "&orderId=" + order_id;
		finalString += "&performing_facility_id=" + performing_facility_id;
		finalString += "&order_set_id=" + order_set_id;


	var arguments	= "";
	var retVal 			= await top.window.showModalDialog("../../eOR/jsp/OrderEntryBillingFrameset.jsp?"+finalString,arguments,features);

}

function alignHeading()
{
	if(document.getElementById("headerTab")!=null)
	{
				document.getElementById("headerTab").width =	eval(document.getElementById("detailTab").offsetWidth);
				for (j=0; j < document.getElementById("detailTab").rows[0].cells.length; j++) 
				{
					var wid=eval(document.getElementById("detailTab").rows[0].cells[j].offsetWidth);
					
					if(document.getElementById("headerTab").rows[0].cells[j] != null)
					{
						document.getElementById("headerTab").rows[0].cells[j].width=wid;
					}
				}
		}
		
	}

function printValues(bean_id, bean_name) 
{
	// Call the intermediate jsp, to make the values print.......
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var func_mode = "PRINT_VALUES";
	var called_from = "COMPLETEORDER";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " FUNC_MODE=\""+ func_mode + "\" ";
	xmlStr += " CALLED_FROM=\""+ called_from + "\" ";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert("xmlStr"+xmlStr);
	xmlHttp.open( "POST", "CompleteOrderValidate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//responseText	= xmlHttp.responseText ;
	//alert("responseText"+responseText);
	eval( responseText ) ;
	//alert(eval( responseText ));
}
//IN061890 starts
function clearTermsetCatalog(docObj,form_name)
{
	//function commented for IN066548
	/*var len = eval(form_name+".replace_orderable0.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(form_name+".replace_orderable0.remove(\"replace_orderable0\")") ;
	}
	var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
	var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(form_name+".replace_orderable0.add(opt)") ;*/
}
function onChangeTermSetID()
{
	clearTermsetCatalog('document','document.completeRemarks')
	document.getElementById("term_code").value="";
	document.getElementById("term_desc").value="";
	document.getElementById("temp_term_desc").value="";
	document.getElementById("replace_orderable_desc1").value = ""; //IN067881
	document.getElementById("replace_orderable_code1").value = "";//IN067881
	document.getElementById("complete_remarks").value = "";//IN067881
	if(document.getElementById("term_set_id").value!='')
	{
		document.getElementById("term_desc").disabled=false;
		document.getElementById("term_code_button").disabled=false;
		document.getElementById("replace_orderable_desc1").disabled=false;//IN067881
		document.getElementById("replace_orderable_code_button1").disabled=false;//IN067881
	}
	else
	{
		document.getElementById("term_desc").disabled=true;
		document.getElementById("term_code_button").disabled=true;
		document.getElementById("replace_orderable_desc1").disabled=true;//IN067881
		document.getElementById("replace_orderable_code_button1").disabled=true;//IN067881
		document.getElementById("replace_orderable_desc1").value='';////IN067881
    	document.getElementById("replace_orderable_code1").value = "";////IN067881
	}
	document.getElementById("replace_orderable_desc1").disabled=true;////IN067881
	document.getElementById("replace_orderable_code_button1").disabled=true;
	document.getElementById("replace_orderable_desc1").value='';//IN067881
	document.getElementById("replace_orderable_code1").value = "";//IN067881
}
function before_show_term_code_window(obj)
{
	if(obj.value!=''){
		//IN067881 start
			 document.getElementById("replace_orderable_desc1").disabled=true;
			 document.getElementById("replace_orderable_code_button1").disabled=true;
			 document.getElementById("replace_orderable_desc1").value='';
		     document.getElementById("replace_orderable_code1").value = "";//IN067881 end 
			 show_window(obj);
	}
}
function show_term_code_window(obj)
{			
	if(document.getElementById("term_set_id").value != "")
		show_window(obj);	
}
async function show_window(obj) 
{
	var returnVal =    new String();
    var dialogHeight= "33" ;
    var dialogWidth = "44" ;
    var status = "no";
	var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var l_catalog_code = document.getElementById("catalog_code").value;
	var l_term_set_id = document.getElementById("term_set_id").value;
	returnVal= await window.showModalDialog("../../eMR/jsp/TermCodeFrameSet.jsp?title="+encodeURIComponent(obj.options[obj.selectedIndex].text)+"&term_set_id="+obj.value+"&term_desc="+encodeURIComponent(document.getElementById("term_desc").value)+"&mulitple_yn=N",arguments,features);
	if(returnVal != null)
    {      
		var retValCode		= returnVal.split("~") ;
		var retVal		= retValCode[0].split("||") ;

		document.getElementById("term_code").value		= trimString(retVal[0]);
		document.getElementById("term_desc").value		= retVal[1];
    //IN066548 start
		document.getElementById("replace_orderable_desc1").disabled=false;
		document.getElementById("replace_orderable_code_button1").disabled=false;
    //IN066548 end
		loadTermSetCatalogs(l_catalog_code,l_term_set_id,document.getElementById("term_code").value);		
	}
	else
	{
		document.getElementById("term_code").value="";//IN066006
		document.getElementById("term_desc").value="";//IN066006
		document.getElementById("temp_term_desc").value="";//IN066006
		clearTermsetCatalog('document','document.completeRemarks');
	}
}
//IN066548 start
async function populateReplaceOrderableForCategory(target,code) 
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var formobj=document.completeRemarks;
	
	
 	var sql=formobj.replace_orderable_query_for_category.value;
 	
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval= await CommonLookup("Replace Orderable",argumentArray);//IN067697
	var str =unescape(retval);
	var arr = str.split(",");
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
}
async function populateReplaceOrderableForTermSet(target,code) 
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var formobj=document.completeRemarks;
	
	
 	var sql=formobj.replace_orderable_query.value;
 	var termset_id=formobj.term_set_id.value;
 	var term_code=formobj.term_code.value;
 	sql=sql.replace("##termsetCode##", "'"+term_code+"'");
 	sql=sql.replace("##termsetId##", "'"+termset_id+"'");
 	sql=sql.replace("##termsetId##", "'"+termset_id+"'");
 	sql=sql.replace("##termsetCode##", "'"+term_code+"'");
 	
 	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	
	retval= await CommonLookup("Replace Orderable",argumentArray);//IN067697
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
}
//IN066548 end
function loadTermSetCatalogs(catalog_code, term_set_id , term_code_id)
{
//	var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();

	var bean_id = document.getElementById("bean_id").value;
	var bean_name = document.getElementById("bean_name").value;

	var func_mode = "POPULATE_TERMSET_CATALOGS";
	var called_from = "COMPLETEORDER";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " FUNC_MODE=\""+ func_mode + "\" ";
	xmlStr += " CALLED_FROM=\""+ called_from + "\" ";
	xmlStr += " p_catalog_code=\""+ catalog_code + "\" ";
	xmlStr += " p_term_set_id=\""+ term_set_id + "\" ";
	xmlStr += " p_term_code_id=\""+ term_code_id + "\" ";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CompleteOrderValidate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}
function setTermsetCatalog(code, desc)
{
	//var element = document.createElement('OPTION') ;
	//element.value =  code ;
	//element.text = desc ;
	//eval("document.getElementById("replace_orderable0")").add(element);
}
//IN061890 ends
//IN066548 start
 function onChangeRepType(obj){
	var termID = document.getElementById("termID");
	var termCode = document.getElementById("termCode");
	var lookupForCategory = document.getElementById("lookupForCategory");
	var lookupForTermSet = document.getElementById("lookupForTermSet");
    if(obj.value == 'C'){
    	termID.style.display = "none";
    	termCode.style.display = "none";
    	lookupForTermSet.style.display = "none";
    	lookupForCategory.style.display = "block";
    	document.getElementById("replace_orderable_desc").value = ""; 
    	document.getElementById("replace_orderable_code").value = "";//IN067881
     	document.getElementById("complete_remarks").value = "";
    }
    else if(obj.value == 'T'){
    	termID.style.display = "block";
    	termCode.style.display = "block";
    	lookupForTermSet.style.display = "block";
    	lookupForCategory.style.display = "none";
    	document.getElementById("replace_orderable_desc1").value='';
    	document.getElementById("replace_orderable_code1").value = "";//IN067881
        document.getElementById("term_set_id").value='';  
    	document.getElementById("term_desc").value='';
    	document.getElementById("complete_remarks").value = "";
    	document.getElementById("term_desc").disabled=true;//IN067881
		document.getElementById("term_code_button").disabled=true;//IN067881
		document.getElementById("replace_orderable_desc1").disabled=true;//IN067881
		document.getElementById("replace_orderable_code_button1").disabled=true;//IN067881
    }
}
 //start IN067881
 function onChangeRepOrdForCat(obj,repCode){
		 populateReplaceOrderableForCategory(obj,repCode)
 }
 function onChangeRepOrdForTrm(obj,repCode){
		 populateReplaceOrderableForTermSet(obj,repCode)
 }
 //end IN067881
//IN066548 stop

