/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var result1    =   false ;
var message1   =   "" ;
var flag1      =   "" ;
function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}
function getReArrangeSeqFlag(){
	var Slate_Booking_Verification=document.forms[0].Slate_Booking_Verification.value;
	var messageFrame = ( Slate_Booking_Verification=="BOOKING_VER_TAB" )?window.messageFrame:f_query_add_mod.messageFrame;
	if(Slate_Booking_Verification=="BOOKING_VER_TAB")
		var formObj=parent.content.f_query_add_mod.f_query_add_mod.document.VerificationSearchForm;
	else if(Slate_Booking_Verification=="SLATE_VER_TAB")
		var formObj=f_query_add_mod.frames[1].frames[1].document.forms[0];
//	var frmobj= f_query_add_mod.frames[1].document.forms[0];
	var facility_id=formObj.facility_id.value;  
	var sql="select RESEQUENCE_REASON_MANDATORY_YN from ot_param_for_facility where operating_facility_id='"+facility_id+"' ";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	return retVal;
}

function apply(){	
	//Modified  by subramanian on 4/07/2005
	var submit_flag=false;
	
	//var msg ="APP-OT0031 Reason Cannot be Blank...."
	//var msg = getMessage("REASON_CODE_NOT");
	var msg_blank = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg_blank.split("&");
	//var msg = msgArray[0]+" Reason "+msgArray[1];
	var msg = msgArray[0]+getLabel("Common.reason.label","Common")+" "+msgArray[1];
	var Slate_Booking_Verification=document.forms[0].Slate_Booking_Verification.value;
	var messageFrame = ( Slate_Booking_Verification=="BOOKING_VER_TAB" )?window.messageFrame:f_query_add_mod.messageFrame;
	if(Slate_Booking_Verification=="BOOKING_VER_TAB")
		var formObj=parent.content.f_query_add_mod.f_query_add_mod.document.VerificationSearchForm;
	else if(Slate_Booking_Verification=="SLATE_VER_TAB")
		var formObj=f_query_add_mod.frames[1].frames[1].document.forms[0];
	var re_arange_seq_flag=getReArrangeSeqFlag();
	if(formObj.chk_sequence.checked==true && re_arange_seq_flag=="Y"){
			if(validateReason()==false){
				submit_flag=false;
			}else{
				submit_flag=true;
			}
	}else{
		submit_flag=true;
	}	
	if(Slate_Booking_Verification=="BOOKING_VER_TAB" && typeof window.f_query_add_mod.qa_query_result.qa_query_result!="undefined")
	var objForm1=window.f_query_add_mod.qa_query_result.qa_query_result.document.VerificationDtlForm;
	else if(Slate_Booking_Verification=="SLATE_VER_TAB" && typeof f_query_add_mod.f_tab_frames.qa_query_result.qa_query_result!="undefined")
		var objForm1=f_query_add_mod.frames[1].frames[2].frames[0].document.forms[0];
	//var reason_flag=true;
		if(objForm1!=null)
	{
		 var stagecode; 
		var max_no=objForm1.maxno.value;
		var from=objForm1.from.value;
		var to=objForm1.to.value;		
if(formObj.chk_sequence.checked==false)
	{
		if (from!=''&&from!=null){
			max_no=parseInt(max_no);
			from=parseInt(from-1);
			to=parseInt(to-1);		
			for(pos=0;pos<max_no;pos++){
				var stagecode=eval("objForm1.to_stage_code"+pos+".value");
				var stageFinalizationCode=eval("objForm1.finalizationcode"+pos+".value");
				var facilityid=eval("objForm1.facilityid"+pos+".value");
				var patient_id=eval("objForm1.patient_id"+pos+".value");
				var order_id=eval("objForm1.order_id"+pos+".value");
				var booking_num=eval("objForm1.booking_num"+pos+".value");
				if(stagecode==stageFinalizationCode)
				{
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					var temp_jsp="BookingValidation.jsp?booking_no="+booking_num+"&facility_id="+facilityid+"&patient_id="+patient_id+"&mode=insert"+"&orderid="+order_id;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					var resText =trimString1(xmlHttp.responseText);
					
					
					var pt_array  = resText.split("##");
					if(pt_array[0]=="E")
					{
							alert(pt_array[2]);
							alert(pt_array[3]);
							submit_flag=false;
						
					}
					if(pt_array[0]=="S" && pt_array[1]=="S")
					{
						alert(pt_array[2]);
						submit_flag=false;
						
					}

					
					if(pt_array[0]=="S" && pt_array[1]=="O")
					{
						if(window.confirm(pt_array[2]))
						{
							submit_flag=true;
						}
						else 
						{
							submit_flag=false;
						}
					}
					
					if(pt_array[0]=="S" && pt_array[1]=="A")
					{
						submit_flag=true;
						
					}
					if(pt_array[0]=="S" && pt_array[1]=="M")
					{
						alert(pt_array[2]);
						submit_flag=true;
						
					}

				if(submit_flag==false)
				{
					msg="";
				}

				}
				
			}
		}
}		
	if(submit_flag==true){
		//alert(frames[1].frames[2].name)
		if(Slate_Booking_Verification=="BOOKING_VER_TAB" )
		var objForm=window.f_query_add_mod.qa_query_result.qa_query_result.document.VerificationDtlForm;
		else if(Slate_Booking_Verification=="SLATE_VER_TAB")
		var objForm=f_query_add_mod.frames[1].frames[2].frames[0].document.forms[0];
		
		var xmlStr= collectAllDetails(objForm);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr="<root>"+xmlStr;
		xmlStr+="</root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(xmlStr.indexOf("<root></root>")!=-1){
		var msg1 = getMessage("NO_CHANGE_TO_SAVE","Common");
		//parent.content.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg1;
		return;
	    }
		xmlHttp.open("POST", "../../servlet/eOT.BookingServlet", false);
		xmlHttp.send(xmlDoc);
		var resTxt=xmlHttp.responseText;
		var objf=parent.content.document.forms[0];
		//window.commontoolbarFrame.document.location.href=objf.qury.value;
		var messageFrame = ( Slate_Booking_Verification=="BOOKING_VER_TAB" )?window.messageFrame:f_query_add_mod.messageFrame;		
		if(Slate_Booking_Verification=="BOOKING_VER_TAB"){
			//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
			window.commontoolbarFrame.document.location.href=objf.qury.value;
			window.f_query_add_mod.qa_query_result.qa_query_result.document.location.href="../../eOT/jsp/VerificationSchSearch.jsp?"+objForm.param1.value;
		}else if(Slate_Booking_Verification=="SLATE_VER_TAB"){
			//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
			f_query_add_mod.frames[1].frames[2].frames[0].document.location.href="../../eOT/jsp/VerificationSchSearch.jsp?"+objForm.param1.value;
		}
		//messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
		//var msg_inserted = "APP-SM0001 Operation Completed Successfully ...." ;
		if(localTrimString(resTxt) =="")
		{
		var msg_inserted = getMessage("RECORD_INSERTED","SM");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg_inserted;	
		}else
		{
		var msg_dis = getMessage("PRC-OT0058","OT");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg_dis;
		}
	}else
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
//var objf=parent.content.document.form(0);
	}else
		{  //alert("192")
		   var mesg1=getMessage("NO_CHANGE_TO_SAVE","Common");
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+mesg1;
		   //return;
		}
   }
   
   //newly added method by subramanian on 4/07/2005
    function validateReason(){
		var Slate_Booking_Verification=document.forms[0].Slate_Booking_Verification.value;

		if(Slate_Booking_Verification=="BOOKING_VER_TAB")
		var objForm=parent.content.f_query_add_mod.qa_query_result.qa_query_result.document.VerificationDtlForm;
		else if(Slate_Booking_Verification=="SLATE_VER_TAB")
		var objForm=f_query_add_mod.frames[1].frames[2].frames[0].document.forms[0];
		
		//alert("objForm"+objForm.name);
		var reason_flag=true;
		 var seq; var reason;var bookingseqno;
		var max_no=objForm.maxno.value;
		if (max_no!=null && max_no!=''){
			max_no=parseInt(max_no,10);
			for(pos=0;pos<=max_no-1;pos++){
				seq=eval("objForm.seq_no"+pos+".value");
				bookingseqno=eval("objForm.sequence_no"+pos+".value");
				reason = eval("objForm.reason_code"+pos+".value");
				//alert("reason--"+reason);

				if((seq==""|| seq==999) && reason!="")
				{
					reason="";
				}
				//alert("reason-->"+reason+"pos--"+pos);
				//alert("seq-->"+seq+"pos---"+pos);
				if(  (seq!=999 && seq!="" && reason!="" ) || ( (seq==999 || seq=="") && reason=="" ) )  { 
					continue;
				}else{
					reason_flag=false;
				break;
			}
		}
		return reason_flag;
	 }
   }

function assignResult( _result, _message, _flag){
    result1 = _result ;
    message1  = _message ;
    flag1 = _flag ;
} 

function beforePost(str){}

function reset(){	
	var cou=0;
     var frame1=frames[1].f_query_add_mod_1;
var frameObj="";
var slate_search_frame="";
	 if(frame1!=null)
	{      
		frames[1].frames[1].location.reload();	
		frames[1].frames[2].location.href="../../eCommon/html/blank.html";
	}else{
		 frameObj=frames[1].frames[0];
		 slate_search_frame=frames[1].frames[1];	
			 	

		if("f_tab_frames"==slate_search_frame.name){
		frames[1].frames[1].location.reload();	
		}
	}

		if(frameObj.name=="f_query_add_mod"){
			//frameObj.document.forms[0].reset();
			//frames[1].frames[1].document.location.href ="../../eCommon/html/blank.html";
	
		commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_TO_BE_RESCHD_CASES&function_name=To be Rescheduled Cases&function_type=F&access=NNNNY&desktopFlag=N";

		}else if(slate_search_frame.name == "f_query_add_mod")
		{
			commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_BOOKING&function_name=Booking&function_type=F&access=NNNNY&desktopFlag=N";
			//http://indbgl-app25:8899/eHIS/eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_BOOKING&function_name=Booking&function_type=F&access=NNNNY&desktopFlag=N&facility_id=HS
		}else if(slate_search_frame.name == "qa_query_result")
		{
			commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_TO_BE_RESCHD_CASES&function_name=To be Rescheduled Cases&function_type=F&access=NNNNY&desktopFlag=N";
			//javascript:selectLink('../../eOT/jsp/ToBeRescheduledCases.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_TO_BE_RESCHD_CASES&function_name=To be Rescheduled Cases&function_type=F&access=NNNNY&desktopFlag=N','OT_TO_BE_RESCHD_CASES')
		}
}

function collectAllDetails(objForm){
	var max=objForm.maxno.value;

	var maxno;
	var stage;	var priority;	var sequence; 
	var reason ="";
	//changed by subramanian var modified; to var modified=true on 2/06/2005
	var modified=true;
	var xmlString="";
	if (max!=''&&max!=null){
		maxno=parseInt(max,10);

		for(pos=0;pos<=maxno-1;pos++){
		if(modified==true){
			xmlString+="<DTL"+pos+"  ";
			xmlString+=formXmlString(objForm,pos);
			xmlString+="/>";
		}
	  }	
	}
	return xmlString;
}


function checkspl( val )
{
    var result = "" ;
    var ch = "" ;
    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
        val = val.replace("\n","\"")
    }

    var spChars = new Array( "<", ">", "&", "\"", "'" );
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;");
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    //alert(result)
    return result ;
}



function formXmlString(frmObj,pos)
{
 var xmlString='patient_id=\"'+checkspl(eval("frmObj.patient_id"+pos+".value"))+'\"';
 xmlString+='	booking_date=\"'+checkspl(eval("frmObj.booking_date"+pos+".value"))+'\"';
 xmlString+='	room_code=\"'+checkspl(eval("frmObj.room_code"+pos+".value"))+'\"';
 xmlString+='	from_stage_code=\"'+checkspl(eval("frmObj.from_stage_code"+pos+".value"))+'\"';
 //xmlString+='	to_stage_code=\"'+checkspl(eval("frmObj.to_stage_code"+pos+".value"))+'\"';
 xmlString+='	booking_num=\"'+checkspl(eval("frmObj.booking_num"+pos+".value"))+'\"';
 xmlString+='	seq_change_yn=\"'+frmObj.chk_sequence.value+'\"';
 xmlString+='	order_id=\"'+checkspl(eval("frmObj.order_id"+pos+".value"))+'\"';

 if(eval("frmObj.to_stage_code"+pos)!=null&&eval("frmObj.to_stage_code"+pos)!='undefined'  )
	if(eval("frmObj.to_stage_code"+pos+".value")!=eval("frmObj.to_stage_code"+pos+".DB_VALUE"))
		xmlString+='   to_stage_code=\"'+checkspl(eval("frmObj.to_stage_code"+pos+".value"))+'\"';
	else
		xmlString+='   to_stage_code=\"\"';

if(eval("frmObj.priority_code"+pos)!=null&&eval("frmObj.priority_code"+pos)!='undefined'  )
	if(eval("frmObj.priority_code"+pos+".value")!=eval("frmObj.priority_code"+pos+".DB_VALUE"))
		xmlString+='   priority_code=\"'+checkspl(eval("frmObj.priority_code"+pos+".value"))+'\"';
	else
		xmlString+='   priority_code=\"\"';

if(eval("frmObj.seq_no"+pos)!=null&&eval("frmObj.seq_no"+pos)!='undefined') 
	xmlString+=' sequence_no=\"'+checkspl(eval("frmObj.seq_no"+pos+".value"))+'\"';
if(eval("frmObj.reason_code"+pos)!=null&&eval("frmObj.reason_code"+pos)!='undefined') 
	xmlString+=' reason_code=\"'+checkspl(eval("frmObj.reason_code"+pos+".value"))+'\"';
 return xmlString;
}



function callNoRecord()
{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}



function trimString1(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);

    while ( ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) && startPos<inString.length) {
        startPos++;
        ch = inString.charAt(startPos);
		
    }
    if(startPos>0)
        inString = inString.substring(startPos, inString.length) ;
		
    // where do we end?
    endPos = inString.length - 1;


    ch = inString.charAt(endPos);
    while ( ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) && endPos>0  ) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    // get the string
    outString = inString.substring(0, (endPos+1) );
    return outString;
}

function checkReturnString(str){
	var valid_str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ:@#%'!$^&*()-+\/?.,;";
	var checked_str = "";
	for(var jj=0;jj<str.length;jj++){
		if( valid_str.indexOf( str.charAt(jj) )!=-1 )
			checked_str+=str.charAt(jj);
	}
	//alert(checked_str);
	return checked_str;
 }


  function assignchangestages(obj)
 {
	 //alert(parent.f_query_add_mod.document.forms[0].name);
	 var frmobj1= parent.f_query_add_mod.document.VerificationSearchForm;
	if(frmobj1.chk_sequence.checked==false)
{
	 var next_stage_code=frmobj1.next_stage_code_1.value;
	var next_specific_ind=frmobj1.next_specific_ind_1.value;
	var next_action_done=frmobj1.next_action_done_1.value;
	var next_stage_desc=frmobj1.next_stage_desc_1.value;
	var previlage=frmobj1.previlage_1.value;
	//alert("next_action_done---"+next_action_done);
	 if(obj.value!=next_stage_code){
		  var msg_1 = getMessage("APP-OT0071","OT");
		  var msgArray = msg_1.split("#");
		  var not_done_msg = msgArray[0]+next_stage_desc+msgArray[1];
		  if(next_action_done=='S'){
			  //alert(next_stage_desc+" is not done");
			  alert(not_done_msg);
			  obj.value="";
			  return;
		  }
		  if(next_action_done=='A'){
			  //alert(next_stage_desc+" is not done");
			  alert(not_done_msg);
		  }   
	  }
	  if(previlage=='N' && next_specific_ind=='SPC'){
		//alert("User doesn't have privilege to change the stage");
		alert(getMessage("APP-OT0072","OT"));
		objCheck.value="";
		return;
	 }

var frmobj= parent.frames[2].qa_query_result.document.VerificationDtlForm;

var stage_no=frmobj1.stages.options[frmobj1.stages.selectedIndex].value;
var	stagedesc=frmobj1.stages.options[frmobj1.stages.selectedIndex].text;
var selectedIndex = obj.selectedIndex;
var length = obj.options.length;
var value = obj.options[obj.selectedIndex].value;
var text  = obj.options[obj.selectedIndex].text;
var max_no=frmobj.maxno.value;

//alert(frmobj1.chk_sequence.checked);

	if (max_no!=''&&max_no!=null)
	{
		max_no=parseInt(max_no,10);

			for(pos=0;pos<=max_no-1;pos++)
			{
				var stagecodeno=eval("frmobj.from_stage_code"+pos+".value");
				if(eval("frmobj.to_stage_code"+pos+".disabled")==false)
				{
					if(parseInt(stage_no)>parseInt(stagecodeno))
					{
						//alert(eval("frmobj.to_stage_code"+pos).options.length);
						if(obj.options.length==eval("frmobj.to_stage_code"+pos).options.length)
						{
							length=obj.options.length;
						}						
				if(obj.options.length-eval("frmobj.to_stage_code"+pos).options.length==1)
				{
					length=eval("frmobj.to_stage_code"+pos).options.length;
				}
				if(obj.options.length-eval("frmobj.to_stage_code"+pos).options.length==2)	
				{	
					length=eval("frmobj.to_stage_code"+pos).options.length;
				}
				//alert("---"+length);
				//if(obj.options.length=eval("frmobj.to_stage_code"+pos).options.length;
						eval("frmobj.to_stage_code"+pos).options[length] = new Option(text,value);
						eval("frmobj.to_stage_code"+pos).remove(length);
						eval("frmobj.to_stage_code"+pos).options[obj.selectedIndex].selected=true
						
					
					}
				}
			}
	}
}
}

function clearreasonvalue(obj1,obj2,obj3)
{
	//alert("obj1--"+obj1.value);
	//alert("obj2	--"+obj2.value);
	//alert("obj3--"+obj3.value);
	if(obj3.value!="")
	{
		if(obj2.value!="")
		{
			obj2.value="";
			obj1.value="";
		}
	}
}
