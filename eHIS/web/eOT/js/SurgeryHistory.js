/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var prevObjID;
var prevImgObj;
var disappeardelay= 250;

function disableMenuButton()
{
	window.parent.frames[0].document.forms[0].apply.disabled=true;

}

function reset() {
	
	var formObj = frames[1].document.forms[0];
	var called_from=formObj.called_from.value;
  //if(frames[1].document.forms[0].document.location.href.indexOf("SurgeryHistory.jsp") != -1){
	if(frames[1].document.location.href.indexOf("SurgeryHistory.jsp") != -1){
		 commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_SURGERY_HISTORY&function_name=Surgery%20History&function_type=F&access=NNNNY"
		   return false;
	 }else{
		 formObj.oper_code.value="";
		 formObj.oper_desc.value="";
		 formObj.to_date.value="";
		 formObj.from_date.value="";	
	if(called_from =="")
		 {			commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_SURGERY_HISTORY&function_name=Surgery%20History&function_type=F&access=NNNNY"
			formObj.patient_id.value="";
			formObj.patient_name.value="";
			formObj.sex.value="";
			formObj.date_of_birth.value="";	
			frames[2].location.href="../../eCommon/html/blank.html";
		 }
	 }
}

async function callPatSearch(){
	var male=getLabel('Common.male.label','Common');
	var female=getLabel('Common.female.label','Common');
	var unknown=getLabel('Common.unknown.label','Common');
	var formObj = document.forms[0];
	var patient_id=formObj.patient_id;
	var patient_name = formObj.patient_name;
	var date_of_birth = formObj.date_of_birth;
	var sex	= formObj.sex;
	var return_value =	"";
	//return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
	if(patient_id.value.length>0)
		return_value= patient_id;
	else
		return_value = await PatientSearch();
	if(return_value==null)  return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP")); 
			patient_id.value="";
			patient_name.value="";
			date_of_birth.value="";
			sex.value = ""; 
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			date_of_birth.value 	= retVal_arr[1];
			if(retVal_arr[2]=="MALE")
				formObj.sex.value=male ;
			else if(retVal_arr[2]=="FEMALE")
				formObj.sex.value=female;
			else
				formObj.sex.value=unknown;
	}
}

function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}

function callNoRecords(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common'));
}

function callNoNotes(str){
/*	
	var msg = "Notes Not Entered";
	//messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num"+msg
	//alert(messageFrame.name);
	//alert("tab_id="+str);
	//Remove the hardcoded msg move to Messages
	if(str=="hold_notes"){
		var msg = "<B><Font style='font-size:11pt;'> APP-OT30  Holding Area Notes Not Entered...</B></font>";
	 }else if(str=="surg_notes"){
		var msg = "<B><Font style='font-size:11pt;'> APP-OT31  Surgeon Notes Not Entered...</B></font>";
	 }else if(str=="rec_notes"){
		var msg = "<B><Font style='font-size:11pt;'> APP-OT32  Recovery Notes Not Entered...</B></font>";
	}else
		var msg = "<B><Font style='font-size:11pt;'> APP-OT33  Operative Notes Not Entered...</B></font>";
	top.messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num="+msg;
*/
// Commented and modified below for Thai Conversion	
	var msg_notes=getMessage("APP-OT0088","OT");
	var msgArray=msg_notes.split("#");
	var notes=getLabel("Common.notes.label","common");
	//var msg=alert(msgArray[0] + notes + msgArray[1]);
	var msg=(msgArray[0] + notes + msgArray[1]);
	//messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num"+msg
	//Remove the hardcoded msg move to Messages
	if(str=="hold_notes"){
		var holdingAreaNotes=getLabel("eOT.HoldingAreaNotes.Label","OT");
		var msg = "<B><Font style='font-size:10pt;'>"+ msgArray[0] + holdingAreaNotes + msgArray[1]+"</B></font>";
	 }else if(str=="surg_notes"){
 		var surgeonNotes=getLabel("eOT.SurgeonNotes.Label","OT");
		var msg = "<B><Font style='font-size:10pt;'>"+msgArray[0] + surgeonNotes + msgArray[1]+ "</B></font>";
	 }else if(str=="rec_notes"){
		 var recoveryNotes=getLabel("eOT.RecoveryNotes.Label","OT");
		 var msg = "<B><Font style='font-size:10pt;'>"+ msgArray[0] + recoveryNotes + msgArray[1]+"</B></font>";
	}else {
	//var operativeNotes=getLabel("eOT.OperativeNotes.Label","OT");--this has missed,need to create
	    var msgerror=getMessage("APP-OT0117","OT");
		var msg = "<B><font style=font-size:11pt>"+msgerror+"</font></B>";
		//var msg = "<B><font style=font-size:11pt> APP-OT33  Operative Notes Not Entered...</font></B>";
	}
	//top.messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num="+msg;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num="+msg;
}

async function callSurgeryNotes(facility_id,oper_num,speciality_code,doc_level){
	if(doc_level=="AS"){
		speciality_code="*ALL";
	}
	var params = "facility_id="+facility_id+"&oper_num="+oper_num+"&speciality_code="+speciality_code;
	var url = "../../eOT/jsp/SurgeryHistoryNotes.jsp?"+params;
	var retVal="";
	var dialogHeight = "90vh" ;
	var dialogWidth  = "65vw";
	var dialogTop    = "0vh";
	var dialogLeft   = "0vh";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await top.window.showModalDialog(url, arguments, features);
}

//function callSurgeryDetails(facility_id,patient_id,oper_date,oper_num,oper_code,surgeon_code,check_in_time,check_in_or_time,check_in_rec_time,check_out_rec_time,patient_class,encounter_id,episode_id,episode_type,speciality_code,booking_num,order_id,login_user){
	async function callSurgeryDetails(facility_id,patient_id,oper_date,oper_num,oper_code,surgeon_code,check_in_time,check_in_or_time,check_out_or_time,recovery_room_desc,check_in_rec_time,check_out_rec_time,patient_class,encounter_id,episode_id,episode_type,speciality_code,booking_num,order_id,login_user){ //Modified by lakshmi against IN29152

	//var params ="facility_id="+facility_id+"&oper_num="+oper_num+"&patient_id="+patient_id+"&oper_date="+oper_date+"&oper_num="+oper_num+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code+"&check_in_time="+check_in_time+"&check_in_or_time="+check_in_or_time+"&check_in_rec_time="+check_in_rec_time+"&check_out_rec_time="+check_out_rec_time+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&booking_num="+booking_num+"&order_id="+order_id+"&login_user="+login_user;
	//alert("callSurgeryDetails in SurgeryHistory.js "+params); //muthu

	var params ="facility_id="+facility_id+"&oper_num="+oper_num+"&patient_id="+patient_id+"&oper_date="+oper_date+"&oper_num="+oper_num+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code+"&check_in_time="+check_in_time+"&check_in_or_time="+check_in_or_time+"&check_out_or_time="+check_out_or_time+"&recovery_room_desc="+recovery_room_desc+"&check_in_rec_time="+check_in_rec_time+"&check_out_rec_time="+check_out_rec_time+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&speciality_code="+speciality_code+"&booking_num="+booking_num+"&order_id="+order_id+"&login_user="+login_user; //Modified by lakshmi against IN29152
		
	var url = "../../eOT/jsp/SurgeryHistoryDetails.jsp?"+params;
	var retVal="";
	var dialogHeight = "90vh" ;
	//var dialogWidth  		= window.screen.availWidth;
	var dialogWidth  		= "100vw";
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = await top.window.showModalDialog(url, arguments, features);
}

function  displayToolTip(facility_id,patient_id,oper_num,oper_code,surgeon_code,oper_date,patient_class,encounter_id,episode_id,episode_type,speciality_code,booking_num,slate_user_id,called_from,orderctlHDR,imgObj){
	var patientDemographics=getLabel("eOT.PatientDemographics.Label","OT");
	var patientHistory=getLabel("Common.PatientHistory.label","common");
	var bookingDetails=getLabel("eOT.ViewBookingDetails.Label","OT");
	var anaesthesiaHistory=getLabel("eOT.AnaesthesiaHistory.Label","OT");
/*****************     modified By Yadav 14268   ******************* */
	if(booking_num!="")
	{
	var menu_id_list		= new Array("1","2","3","4");
	var menu_name_list	= new Array(patientDemographics,patientHistory,bookingDetails,anaesthesiaHistory);
	}
	else
	{
	var menu_id_list		= new Array("1","2","4");
	var menu_name_list	= new Array(patientDemographics,patientHistory,anaesthesiaHistory);
	}
/*****************  End   modified By Yadav 14268   ******************* */
	/*if(booking_num.length>0){
		if(called_from=="OT_SLATE" || called_from=="OPER_REG" ){
			 menu_id_list = new Array("1","3");
			 menu_name_list	= new Array("Patient Demographics","Booking Details","Anaesthesia History");
		}else{
			 menu_id_list		= new Array("1","2","3","4");
			 menu_name_list	= new Array("Patient Demographics","Patient History","Booking Details","Anaesthesia History");
		}
	}else{
			
			if(called_from=="OT_SLATE" || called_from=="OPER_REG" ){
				menu_id_list		= new Array("1");
				menu_name_list	= new Array("Patient Demographics","Anaesthesia History");
			}else{
				menu_id_list		= new Array("1","2");
				menu_name_list	= new Array("Patient Demographics","Patient History","Anaesthesia History");
			}
		
	}*/

	//var param=facility_id+"::"+patient_id+"::"+patient_name+"::"+sex+"::"+anesthesia_srl_no+"::"+proc_module_id;
	var param=facility_id+"::"+patient_id+"::"+oper_num+"::"+oper_code+"::"+surgeon_code+"::"+oper_date+"::"+patient_class+"::"+encounter_id+"::"+episode_id+"::"+episode_type+"::"+speciality_code+"::"+booking_num+"::"+slate_user_id+"::"+called_from;
callMouseOverOnTD(orderctlHDR,imgObj);
  var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var jj=0; jj<menu_name_list.length; jj++ )
	{
		var id_colval		= menu_id_list[jj];
		var id_name_colval  = menu_name_list[jj];
		if(id_colval!="")
		{
			tab_dat     += "<tr>";
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callMenuFunctions('"+id_colval+"','"+param+"');\")>"+id_name_colval + "</a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat+="</table>";	
	
	document.getElementById("tooltiplayer1").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);
//	resizeWindow();
}
function hideToolTip(){
  document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

async function callMenuFunctions(obj,str){
		var arr=new Array();
		 arr=str.split("::");
		//var dialogHeight 		= window.screen.availWidth;
		//var dialogWidth  		= window.screen.availHeight
		var dialogHeight		="100vh";
		var dialogWidth			="100vw"
		var dialogTop   		= "0";
		var dialogLeft   		= "0";
		var features			= "dialogLeft:"+dialogLeft+";dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		hideToolTip();
		if(obj=="1"){
			var	param="facility_id="+arr[0]+"&Patient_ID="+arr[1];
			retVal=await top.window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
		}else if(obj=="2"){
			var count = parent.parent.frames[1].count;
			var HTML = "<html>";
				parent.parent.frames[1].count =(arr[13]=="OT_SLATE"||arr[13]=="OPER_REG")?++count:count=1;
				//alert(count+""+arr[arr.length-1]+"Len-->"+arr.length);
			if(count==1){
			HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
			}else{
				HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
			}
			var encounter_id=document.forms[0].encounter_id.value;
			var patient_class=document.forms[0].patient_class.value;
			HTML += "<input type='text' name='from_service_yn' id='from_service_yn' value= 'Y'>";
			HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
			HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +arr[1]+ "'>"; 
			HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '" + encounter_id+ "'>";
			HTML += "<input type='text' name='patient_class' id='patient_class' value= '" + patient_class+ "'>";
			HTML += "</form>"
			HTML += "</html>"
			parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
			parent.parent.messageFrame.document.historyForm.submit();
		}else if(obj=="3"){
			var param="facility_id="+arr[0]+"&booking_no="+arr[11]+"&orderid=0&transfer=5&patient_id="+arr[1]+"&menu_required_yn=N";  
			retVal=await top.window.showModalDialog("../../eOT/jsp/BookingDetailFrame.jsp?"+param,arguments,features);
		}else if(obj=="4"){
			var param="called_from=REC_ANES&home_required_yn=N&patient_id="+arr[1]+"&patient_name=";
			retVal=await top.window.showModalDialog("../../eOT/jsp/AT_AnaesthesiaHistory.jsp?"+param,arguments,features);
	}

}

function callSearch(){ 
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	if(patient_id!=''){
		var facility_id = formObj.fac_id.value;
		var surgeon_code = formObj.surgeon_code.value;
		var oper_code = formObj.oper_code.value;
		var locale = formObj.locale.value;
		var from_date = dateUtils(formObj.from_date.value,locale);
		 var to_date = dateUtils(formObj.to_date.value,locale);
	if(!isValidDateSequence()) return;
		var called_from = formObj.called_from.value;
		var params = "facility_id="+facility_id+"&patient_id="+patient_id+"&surgeon_code="+surgeon_code+"&oper_code="+oper_code+"&from_date="+from_date+"&to_date="+to_date+"&called_from="+called_from;
		parent.ResultFrame.document.location.href="../../eOT/jsp/SurgeryHistoryResultFrames.jsp?"+params;
	}else{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var patientid_value=getLabel("Common.patientId.label","common");
		var msgArray = msg.split("&");
		var err = msgArray[0]+" "+patientid_value+" "+msgArray[1];
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
	    return;
	}
}

/*function resizeWindow(){
	bodwidth = parent.parent.frames[2].document.body.offsetWidth
	bodheight = parent.parent.frames[2].document.body.offsetHeight
	var x =event.x
	var y =  event.y;
	x = x + (document.getElementById("tooltiplayer1").offsetWidth)
	y = y + (document.getElementById("tooltiplayer1").offsetHeight)
	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer1").offsetWidth*1)
	if(y<bodheight)
	{
		 y =event.y
	}
	else
	{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*1)
	}
	y+=document.body.scrollTop
	x+=document.body.scrollLeft
	document.getElementById("tooltiplayer1").style.posLeft= x
	document.getElementById("tooltiplayer1").style.posTop = y
	document.getElementById("tooltiplayer1").style.visibility='visible'
}

/*function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'OTMENU';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}*/

async function searchOperation2(obj)
{
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//SELECT  HOLDING_AREA_DESC description,HOLDING_AREA_CODE code FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID='"+facility_id+ "' AND NVL(STATUS,'E') = 'E'  and upper(HOLDING_AREA_DESC) like upper(?) and upper(HOLDING_AREA_CODE) like upper(?) order by 2
	//var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY A, OT_SPECIALITIES B  WHERE  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";

	//var sql="SELECT SHORT_DESC DESCRIPTION,OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 1";//MMS-QH-CRF-0199

	var sql="SELECT LONG_DESC DESCRIPTION,OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 1";//MMS-QH-CRF-0199

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified By Rajesh For Lookup ISsue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup("Operation", argumentArray );
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].oper_code.value= arr[0];
		document.forms[0].oper_desc.value= arr[1];
		//obj.value = returnedValues[1];
	}else{
		document.forms[0].oper_code.value= '';
		document.forms[0].oper_desc.value= '';

	}
}

async function searchSurgeon2(obj){
	var facility_id = document.forms[0].facility_id.value;
	var locale= document.forms[0].locale.value;
	//var tcode = obj.value;
	//var tdesc = target.value;
	//obj.value='';
	//target.value='';
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.Surgeon.label","Common");				
	//var sql="SELECT SHORT_NAME DESCRIPTION,PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD','SG')AND NVL(STATUS,'X') <> 'S'  AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 1";
//	var sql="SELECT PRACTITIONER_ID CODE, SHORT_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2"

	//Code altered by rajesh for including role_type on 09/07/08
	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1 ";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		//var ret1=unescape(retVal);
		//arr=ret1.split(",");
		//target.value=arr[1];
		document.forms[0].surgeon_code.value= retVal[0];
		document.forms[0].surgeon_desc.value= retVal[1];
		obj.value=retVal[1];
		//document.forms[0].surgeon_desc.disabled=true;		
	}else{

		document.forms[0].surgeon_code.value='';
		document.forms[0].surgeon_desc.value='';
	}
}

function isValidDateSequence(){
	var formObj = document.forms[0];
	var from_date = formObj.from_date.value;
	var to_date = formObj.to_date.value;
	if(from_date!="" && to_date!=""){
		var error = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT").replace("#",getLabel("Common.todate.label","Common")).replace("#",getLabel("Common.fromdate.label","Common"));
		if(Date.parse(to_date) < Date.parse(from_date) ) {
			 alert(error);	
             return false;
		}else
			return true;
	}else
		return true;
}

function clearForm(){
	var formObj = document.forms[0];
	parent.ResultFrame.document.location.href="../../eCommon/html/blank.html";
	formObj.reset();
}

	function callVerifyCheckList(checklists){
		var formObj = document.forms[0]; 
		var tab_id = formObj.tab_id.value;
		if(tab_id=="pre_oper_checklist_tab"){
			var pre_or_post="P";
			var checklist_stage = "C20";
		}else{
			var pre_or_post="O";
			var checklist_stage = "C50";
		}
		var order_id = formObj.order_id.value;
		var checklist_arr = checklists.split("##");
		var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
		var count=1;
		for(i=1;i<checklist_arr.length;i++){
		   count++;
		   //verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		   verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
		}
		var booking_or_oper_flag = "B";
		if(order_id!=null && order_id!="null" && order_id!="")
		booking_or_oper_flag = "ORD";
		disable_checklist_fields = "disabled"
		access="NNNNY";
		var booking_num = formObj.booking_no.value;
		if(booking_num!=null && booking_num!="null" && booking_num!="" && booking_num!="NULL"){
		order_id = "";
		}else if(order_id!=null && order_id!="null" && order_id!="" && order_id!="NULL"){
			booking_num = "";
		}
		slate_user_id = (formObj.login_user_id.value).toUpperCase();
		var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
		var viewchecklist_legend = getLabel("eOT.ViewCheckList.Label","OT");	

		var function_string = "&function_id=OT_CHECK_LIST&function_name="+viewchecklist_legend;
		var db_param = db_param_1 + function_string;
		var url_desc = "VerifyCheckListMain.jsp";
		var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage="+checklist_stage+"&pre_or_post="+pre_or_post+"&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+formObj.no_of_verifications.value+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+booking_num+"&oper_num="+"&disable_checklist_fields="+disable_checklist_fields+"&query_flag_yn=Y";
		document.location.href=url;
	}

	function autoCall(patientId,patientName,dob,gender){
		if(parent.commontoolbarFrame.reset)
			parent.commontoolbarFrame.reset.disabled=true;
		if(parent.commontoolbarFrame.apply)
			parent.commontoolbarFrame.apply.disabled=true;
			with(document.forms[0]){
			patient_id.value = patientId;
			patient_name.value=patientName;
			date_of_birth.value=dob;
			sex.value=gender;
		}
		callSearch();
	}

function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
		}
	}
}


function callDateCheck(from,to) {
	var fromarray; var toarray;
    var fromdate = from ;
    var todate = to ;
	 var arr = new Array(todate,fromdate)
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			var error = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT").replace("#",getLabel("Common.todate.label","Common")).replace("#",getLabel("Common.fromdate.label","Common"));
			alert(error);
			 return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}

function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patient_id.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patient_name.value="";
	formObj.sex.value="";
	formObj.date_of_birth.value="";
}

//Newly added for Amazon Changes......

	function callMouseOver(obj)	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';
	}

	function callOnMouseOut(obj){
		obj.className = 'contextMenuItem';
	}
 
	function resizeWindow(orderctlHDR)
	{

	    var orderctlHDR1 = orderctlHDR.id;
		//var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
		//var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;	
		var wdth = eval(document.getElementById(orderctlHDR1)).offsetWidth;
		var hght1 = eval(document.getElementById(orderctlHDR1)).offsetHeight;		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	
		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
		var z = bodwidth- (event.x + wdth);	
		var x 	  = event.x;
		var y 	  = event.y;	
		x 	  = x + (document.getElementById("tooltiplayer1").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer1").offsetHeight);	
		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(orderctlHDR).x;
		}
	/*	if(y<bodheight){			
			y = hght;
		}else
		{
			y = y - (document.getElementById("tooltiplayer1").offsetHeight*2) + hght1 ;	
		}*/
		y = hght;
		document.getElementById("tooltiplayer1").style.left= x+"px";
		document.getElementById("tooltiplayer1").style.top = y+"px";
		document.getElementById("tooltiplayer1").style.visibility='visible'
	}

function callMouseOverOnTD(obj,imgObj){
		
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 //eval("document.all."+prevObjID).className = 'gridDataBlue';
			 //eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";	
			 eval(document.getElementById(prevObjID)).className = 'gridDataBlue';
			 eval(document.getElementById(prevImgObj)).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		//eval("document.all."+imgObj).src = "../../eCommon/images/activeArrow.gif";
		eval(document.getElementById(imgObj)).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;		
	}

	function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}
function hidemenu()
{
	document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}
//Amazon Changes Ends Here....

function openDocWindow(accession_num,note_type) //Added Against ML-MMOH-CRF-1977.1
{
	window.open("../../eCA/jsp/RecClinicalNotesMultiFileListMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}

