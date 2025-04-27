/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//var flag_confirmed_yn="";
function reset(){
	
	var formObj_main= parent.f_instr_hdr.document.InstrumentCountListForm;
	var params		= formObj_main.params.value;
	parent.f_instr_hdr.location.href = "../../eOT/jsp/InstrumentCountListFrame.jsp?"+params;
	parent.bio_hazard_frame.location.href = "../../eOT/jsp/Biohazard.jsp?"+params;
	parent.f_create_set.location.href = "../../eOT/jsp/InstrumentCountCreateSetButton.jsp?"+params;	
	parent.f_instr_dtl.location.href = "../../eCommon/html/blank.html";
	parent.f_instr_item_status_confirm.location.href = "../../eCommon/html/blank.html";
	parent.f_instr_dtl_confirm.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}
function apply(){
	var formObj_bio= parent.bio_hazard_frame.document.BiohazardForm;
	var formObj_main= parent.f_instr_hdr.document.InstrumentCountListForm;
	var frame_obj = parent.f_instr_dtl;
	var formObj	= parent.f_instr_dtl.document.InstrumentCountItemDtlsForm;
	//var msg="No Changes To Save.....";
	var msg=getMessage("NO_CHANGE_TO_SAVE","Common");
	var total_sets=formObj_main.total_rows.value;
	var back_color="";
	var tray_num1="";
	var tray_num2="";
	var flag1=true;
	var flag_confirmed_yn=formObj_bio.flag_confirmed_yn.value;
	//alert("flag_confirmed_yn===="+formObj_bio.flag_confirmed_yn.value)
	/*	for(i=1;i<=total_sets;i++)
	  {
       back_color=eval("formObj_main.all.ind_"+i).style.backgroundColor;
	   if(back_color=="blue") 
	    {
		  continue;
		}
	   else 
		  {
          tray_num1= eval("formObj_main.tray_num_"+i).value;
		  if(tray_num2!="")
		  tray_num2=tray_num2+","+tray_num1
		  else
		  tray_num2=tray_num1;
		  //break;
		  }
	 }*/
	if(flag_confirmed_yn=="Y")
	flag1=confirm(getMessage("APP-OT0172","OT"));
	if(flag1==true)
	{
	// alert("total_sets===="+total_sets)
	//if(back_color=="blue")
	//{
	if(total_sets>0){
	//if(parent.f_instr_dtl!=null){
			if(formObj==null){
			// This if block is onvoked whenever the function is opened, and without selecting any SET, it is clicked on Apply button
			var bean_id	    =   formObj_main.bean_id.value;
			var bean_name	= formObj_main.bean_name.value;
			var params		= formObj_main.params.value;
			var patient_id	= formObj_main.patient_id.value;
			var booking_num = formObj_main.booking_num.value;
			var oper_num	= formObj_main.oper_num.value;
			var oper_code	= formObj_main.oper_code.value;
			var tot_count	= 0;
			}
			else {
			// This if block is invoked whenever the function is opened, and atleast one SET details are entered, and clicked on Apply.
			var bean_id		= formObj.bean_id.value;
			var bean_name	= formObj.bean_name.value;
			var params		= formObj.params.value;
			var patient_id	= formObj.patient_id.value;
			var booking_num = formObj.booking_num.value;
			var oper_num	= formObj.oper_num.value;
			var oper_code	= formObj.oper_code.value;
			var tot_count	= formObj.tot_count.value;
			}  
			var bio_hazard_yn = formObj_bio.bio_hazard_yn.value;
			var xmlStr ="<root><SEARCH";
			xmlStr+=" bean_id=\""+bean_id+"\""+" ";
			xmlStr+=" bean_name=\""+bean_name+"\""+" ";
			xmlStr+=" patient_id=\""+patient_id+"\""+" ";
			xmlStr+=" booking_num=\""+booking_num+"\""+" ";
			xmlStr+=" oper_num=\""+oper_num+"\""+" ";
			xmlStr+=" oper_code=\""+oper_code+"\""+" ";
			xmlStr+=" bio_hazard_yn=\""+bio_hazard_yn+"\""+" ";	
			xmlStr +=" /></root>";

			var temp_jsp="InstrumentCountRecordDtls.jsp?"+params;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			//msg="Operation Completed Successfully...";
			msg=getMessage("RECORD_INSERTED","SM");
			alert(msg);
			parent.f_instr_hdr.location.href = "../../eOT/jsp/InstrumentCountListFrame.jsp?"+params;
			parent.f_create_set.location.href = "../../eOT/jsp/InstrumentCountCreateSetButton.jsp?"+params;	
			parent.bio_hazard_frame.location.href = "../../eOT/jsp/Biohazard.jsp?"+params;	
			parent.f_instr_dtl.location.href = "../../eCommon/html/blank.html?";
			parent.f_instr_item_status_confirm.location.href = "../../eCommon/html/blank.html?";
			parent.f_instr_dtl_confirm.location.href = "../../eCommon/html/blank.html?";
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;


		//	alert(trimString(getMessage(responseText)));
			//clearBean();
		
	}else
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
	}else
             
	{
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	/*} else
	{   var msg1="Please Confirm any Set";
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg1;
	}*/
}

 function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}



function populateDetails(row_num){	
	var formObj		= document.InstrumentCountListForm;
	var formObj_bio= parent.bio_hazard_frame.document.BiohazardForm;
	var flag_confirmed_yn=formObj_bio.flag_confirmed_yn.value;
	//alert("flag_confirmed_yn===="+formObj_bio.flag_confirmed_yn.value)
	flag1=true;
	if(flag_confirmed_yn=="Y")
	flag1=confirm(getMessage("APP-OT0172","OT"));
	if(flag1==true)
	{
	var oper_code	= eval("formObj.oper_code_"+row_num).value;
	var set_code	= eval("formObj.set_code_"+row_num).value;
	var tray_num	= eval("formObj.tray_num_"+row_num).value;
	var initial_count_cmpl_yn	= eval("formObj.initial_count_cmpl_yn_"+row_num).value;
	var final_count_cmpl_yn		= eval("formObj.final_count_cmpl_yn_"+row_num).value;
	var params		= formObj.params.value;

	//alert("oper_code===="+oper_code)
	
	params="set_oper_code="+oper_code+"&initial_count_cmpl_yn="+initial_count_cmpl_yn+"&final_count_cmpl_yn="+final_count_cmpl_yn+"&set_code="+set_code+"&tray_num="+tray_num+"&row_num="+row_num+"&"+params;
//	parent.f_instr_item_hdr.location.href="../../eOT/jsp/InstrumentCountHeader.jsp?"+params+"&instr_called_from=ITEM";
	parent.f_instr_dtl.location.href="../../eOT/jsp/InstrumentCountItemDtls.jsp?"+params;
	parent.f_instr_item_status_confirm.location.href="../../eOT/jsp/InstrumentCountStatusConfirm.jsp?"+params+"&instr_called_from=ITEM";
	parent.f_instr_dtl_confirm.location.href="../../eOT/jsp/InstrumentCountItemConfirm.jsp?"+params;	
	var total_rows   = formObj.total_rows.value;
	for(i=1;i<=total_rows;i++){
		eval(document.getElementById("tray_"+i)).style.backgroundColor = eval(document.getElementById("oper_"+i)).style.backgroundColor;
		eval(document.getElementById("set_"+i)).style.backgroundColor = eval(document.getElementById("oper_"+i)).style.backgroundColor;
	}
	eval(document.getElementById("tray_"+row_num)).style.backgroundColor = "lightgreen";//"#A9BFBF";
	eval(document.getElementById("set_"+row_num)).style.backgroundColor = "lightgreen";//"#A9BFBF";
	formObj_bio.flag_confirmed_yn.value="";
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}else
	{
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
}
function confirmItemDtls(){
	var formObj		= parent.document.InstrumentCountItemDtlsForm;
	var params		= formObj.params.value;
	var tot_count	= formObj.tot_count.value;
	for(i=1;i<=tot_count;i++){

	}
	/*
		pass these parameters to a temp jsp/bean(hashmap) and store the session data
		finally on apply, submit this jsp for further commit.(only update no insert)
	*/
}
function assignCheckboxValue(obj){
	var formObj_bio= parent.bio_hazard_frame.document.BiohazardForm;
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
	
	formObj_bio.flag_confirmed_yn.value="Y";
}
function assignCheckboxValue1(obj){
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
}
function confirmItem(){
	var confirm_formObj = document.InstrumentCountItemConfirmForm;
	var row_num = confirm_formObj.row_num.value;
	var status_formObj = parent.f_instr_item_status_confirm.document.InstrumentCountStatusConfirmForm;
	var formObj = parent.f_instr_dtl.document.InstrumentCountItemDtlsForm;
	var formObj_bio=parent.bio_hazard_frame.document.BiohazardForm;
	var params		= formObj.params.value;
	var tot_count	= formObj.tot_count.value;

	var initial_count_cmpl_yn=status_formObj.initial_count_cmpl_yn.value;
	var final_count_cmpl_yn=status_formObj.final_count_cmpl_yn.value

	if(final_count_cmpl_yn=="Y"){
		if(initial_count_cmpl_yn=="N"){
			
			alert(getMessage("APP-OT0171","OT"));
			status_formObj.initial_count_cmpl_yn.focus;
			return;
		}
	}
	var xmlStr ="<root><SEARCH";
	xmlStr+=" bean_id=\""+formObj.bean_id.value+"\""+" ";
	xmlStr+=" bean_name=\""+formObj.bean_name.value+"\""+" ";
	xmlStr+=" patient_id=\""+formObj.patient_id.value+"\""+" ";
	xmlStr+=" booking_num=\""+formObj.booking_num.value+"\""+" ";
	xmlStr+=" oper_num=\""+formObj.oper_num.value+"\""+" ";
	xmlStr+=" oper_code=\""+formObj.oper_code.value+"\""+" ";
	xmlStr+=" set_code=\""+formObj.set_code.value+"\""+" ";
	xmlStr+=" tray_num=\""+formObj.tray_num.value+"\""+" ";
	xmlStr+=" initial_status_cmpl_yn=\""+status_formObj.initial_count_cmpl_yn.value+"\""+" ";
	xmlStr+=" final_status_cmpl_yn=\""+status_formObj.final_count_cmpl_yn.value+"\""+" ";
	xmlStr+=" tot_count=\""+formObj.tot_count.value+"\""+" ";


	for(i=1;i<=tot_count;i++){
		xmlStr+=" item_code_"+i+"=\""+eval("formObj.item_code_"+i).value+"\""+" ";		
		xmlStr+=" cssd_qty_"+i+"=\""+eval("formObj.cssd_qty_"+i).value+"\""+" ";		
		xmlStr+=" open_qty_"+i+"=\""+eval("formObj.open_qty_"+i).value+"\""+" ";		
		xmlStr+=" initial_status_"+i+"=\""+eval("formObj.initial_status_"+i).value+"\""+" ";		
		xmlStr+=" initial_status_remarks_"+i+"=\""+encodeURIComponent(eval("formObj.initial_status_remarks_"+i).value)+"\""+" ";		
		xmlStr+=" return_qty_"+i+"=\""+eval("formObj.return_qty_"+i).value+"\""+" ";		
		xmlStr+=" final_status_"+i+"=\""+eval("formObj.final_status_"+i).value+"\""+" ";		
		xmlStr+=" final_remarks_"+i+"=\""+encodeURIComponent(eval("formObj.final_remarks_"+i).value)+"\""+" ";		
		xmlStr+=" general_remarks_"+i+"=\""+encodeURIComponent(eval("formObj.general_remarks_"+i).value)+"\""+" ";	
       
        var return_qty_local=eval("formObj.return_qty_"+i).value;
		if(initial_count_cmpl_yn == "Y"){
			initial_status = eval("formObj.initial_status_"+i).value;
			if(initial_status==""){
				var msg_1 = getMessage("CANNOT_BE_BLANK","OT");
		        var msgArr = msg_1.split("&");
		        var intial_status_label = getLabel("eOT.InitialStatus.Label","OT");
		
		        alert(msgArr[0]+intial_status_label+msgArr[1]);
				//alert("Initial Status cannot be blank");
				eval("formObj.initial_status_"+i).focus();
				return;
			}
		}
		if(final_count_cmpl_yn == "Y"){
			final_status = eval("formObj.final_status_"+i).value;
			if(final_status==""){
	            var msg_1 = getMessage("CANNOT_BE_BLANK","OT");
		        var msgArr = msg_1.split("&");
		        var final_status_label = getLabel("eOT.FinalStatus.Label","OT");
		
		        alert(msgArr[0]+final_status_label+msgArr[1]);
				//alert("Final Status cannot be blank");
				eval("formObj.final_status_"+i).focus();
				return;
			}
		}
		
		if(eval("formObj.return_qty_"+i).disabled==false && final_count_cmpl_yn == "Y"){ // Applicable only for non-consunable Items
			if(return_qty_local==""){
			    var msg_1 = getMessage("CANNOT_BE_BLANK","OT");
		        var msgArr = msg_1.split("&");
		        var return_qty_label = getLabel("Common.ReturnQty.label","Common");
		
		        alert(msgArr[0]+return_qty_label+msgArr[1]);
				//alert("Return Quantity cannot be blank");
				eval("formObj.return_qty_"+i).focus();
				return;
			}
		}

	}
	xmlStr +=" /></root>";
//	alert('before calling');
	var temp_jsp="InstrumentCountValidation.jsp?"+params+"&func_mode=item_confirm";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);

	var instr_hdr_formObj = parent.f_instr_hdr.InstrumentCountListForm;
	//eval("instr_hdr_formObj.all.ind_"+row_num).style.backgroundColor = "blue";//"#A9BFBF";
	document.getElementById("ind_" + row_num).style.backgroundColor = "blue";//"#A9BFBF";
	formObj_bio.flag_confirmed_yn.value="";
	//alert(responseText);
	if(responseText=="Item Details are stored")
	alert(getMessage("APP-OT0173","OT"));
//	window.close();
	return responseText;
}
async function openRemarks(obj,called_from,row_num,disabled_yn){
	var formObj = document.InstrumentCountItemDtlsForm;
	var formObj_bio= parent.bio_hazard_frame.document.BiohazardForm;
	var item_name = eval("formObj.item_name_"+row_num).value;
	var remarks_obj = obj;
	var remarks_title = "";
	var remarks = "";
	var initialStatusRemarks =getLabel("eOT.InitialStatusRemarks.Label","OT");
    
	var Initial=getLabel("eOT.Initial.Label","OT");
	var Final=getLabel("Common.final.label","Common");
	var General=getLabel("Common.general.label","Common");
	//alert("called_from===="+called_from)

	if(called_from == Initial){
		
		remarks_title= initialStatusRemarks  ;

		remarks_obj = eval("formObj.initial_status_remarks_"+row_num);
	}
	if(called_from == Final){
		
		var msg = getLabel("eOT.FinalStatusRemarks.Label","OT");
		remarks_title=  msg ;
		remarks_obj = eval("formObj.final_remarks_"+row_num);
	}
	if(called_from == General){
		
		var generalRemarks =getLabel("Common.generalRemarks.label","Common");
		remarks_title= generalRemarks;
		remarks_obj = eval("formObj.general_remarks_"+row_num);
	}
	
	 var msg = " "+getLabel("Common.for.label","Common")+" ";
	 msg=encodeURIComponent(msg);
	remarks_title = remarks_title+ msg+item_name;
	remarks_title=encodeURIComponent(remarks_title);
	//alert("remarks_title=="+remarks_title)
	remarks = remarks_obj.value;
	//alert("remarks=="+remarks)
	remarks = trimString(remarks);
	remarks = encodeURIComponent(remarks);
	//remarks=remarks.replace("%E","@")
	if(remarks==null)
		remarks="";
	if(remarks=="null")
		remarks="";
	var dialogHeight	= "16";
	var dialogWidth		= "33";
	var dialogTop		= "145";
	var dialogLeft		= "350";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal = await window.showModalDialog("../../eOT/jsp/InstrumentCountRemarks.jsp?row_num="+row_num+"&remarks_title="+remarks_title+"&new_remarks="+remarks+"&disable_yn="+disabled_yn,arguments, features);
	if(retVal==null || retVal=="null" || retVal=="undefined" || disabled_yn=="disabled" ||  retVal == "CL_REM")
	{
		new_remarks = remarks;
		new_remarks = decodeURIComponent(new_remarks);
	}
	else
	{
		new_remarks = retVal;
		formObj_bio.flag_confirmed_yn.value="Y";
	}
	// assign the new_remarks respectively
	if(called_from == Initial){
		eval("formObj.initial_status_remarks_"+row_num).value=new_remarks;
	}
	if(called_from == Final){
		eval("formObj.final_remarks_"+row_num).value=new_remarks;
	}
	if(called_from == General){
		eval("formObj.general_remarks_"+row_num).value=new_remarks;
	}

}
async function createSet(){
	var formObj = document.InstrumentCountCreateSetButtonForm;
	var params = formObj.params.value;
	var dialogHeight= "10" ;  // 7
	var dialogWidth	= "35" ; // 22
	var dialogTop = (window.screen.availHeight-dialogHeight)/3;//"210" ;
	var dialogLeft = (window.screen.availWidth-dialogWidth)/4;// "240" ;
	var center = "1" ;
	var status="no";
	var scroll="no";
    var myBars = 'directories=no;location=no;menubar=no' ;
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop+myBars;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../eOT/jsp/InstrumentCountCreateSet.jsp?"+params,arguments, features);
	if(retVal=='RECORD_INSERTED')	reset();
}
function insertNewTray(){
	var formObj = document.InstrumentCountCreateSetForm;

	// CRF-268 Instrument Count - Rajesh V //OT204
	var otParam = formObj.ot_Param.value;
	if(otParam == 'Y' || otParam=='y'){
		var patient_id =formObj.patient_id.value;
		var surgery_date =formObj.surgery_date.value;
		var qty_on_hand = formObj.units.value;
		var tray_num = formObj.tray_num.value;
		var req_qty = formObj.req_qty.value;
		if(req_qty.length<1){
			alert(getMessage("APP-OT0204","OT"));
			return false;
		}
	//Added Newly by MuthuN against 32077
		if(parseInt(qty_on_hand) == 0){
			var qtyonhand_zero =confirm(getMessage("APP-OT204","OT"));
			if (qtyonhand_zero != true)
			{				
				window.close();
			}
		}
	//Added Newly by MuthuN against 32077
		else if(parseInt(req_qty) > parseInt(qty_on_hand)){
			var qtyonhand = getMessage("APP-OT203","OT");
			alert(qtyonhand);	
			return false;			
		}
	}
	//CRF-268 Instrument Count - Rajesh V

	var params = formObj.params.value;
	if(formObj.oper_code.value==null || formObj.oper_code.value=="") {
		//alert("Tray Information cannot be blank");
		//alert(getMessage("APP-OT0049"));
		var msg_1 = getMessage("CANNOT_BE_BLANK","OT");
		var msgArr = msg_1.split("&");
		var set_label = getLabel("Common.operation.label","common");
		//var msg =getLabel("
		//alert(msgArr[0]+" Tray Information "+msgArr[1]);
		alert(msgArr[0]+set_label+msgArr[1]);
	}else if(formObj.set_code.value==null || formObj.set_code.value=="") {
		//alert("Tray Information cannot be blank");
		//alert(getMessage("APP-OT0049"));
		var msg_1 = getMessage("CANNOT_BE_BLANK","OT");
		var msgArr = msg_1.split("&");
		var set_label = getLabel("Common.Set.label","Common");
		//var msg =getLabel("
		//alert(msgArr[0]+" Tray Information "+msgArr[1]);
		alert(msgArr[0]+set_label+msgArr[1]);
	}else if(formObj.tray_num.value==null || formObj.tray_num.value=="") {
		//alert("Tray Information cannot be blank");
		//alert(getMessage("APP-OT0049"));
		var msg_1 = getMessage("CANNOT_BE_BLANK","OT");
		var msgArr = msg_1.split("&");
		var tray_label = getLabel("Common.Tray.label","Common");
		//var msg =getLabel("
		//alert(msgArr[0]+" Tray Information "+msgArr[1]);
		alert(msgArr[0]+tray_label+msgArr[1]);
	}else{
		var xmlStr ="<root><SEARCH";
		xmlStr+=" patient_id=\""+formObj.patient_id.value+"\""+" ";
		xmlStr+=" booking_num=\""+formObj.booking_num.value+"\""+" ";
		xmlStr+=" oper_num=\""+formObj.oper_num.value+"\""+" ";
		xmlStr+=" oper_code=\""+formObj.oper_code.value+"\""+" ";
		xmlStr+=" set_code=\""+formObj.set_code.value+"\""+" ";
		xmlStr+=" tray_num=\""+formObj.tray_num.value+"\""+" ";
		xmlStr +=" /></root>";
		var temp_jsp="InstrumentCountValidation.jsp?"+params+"&func_mode=check_tray_duplication";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=trimString(xmlHttp.responseText);
		//alert("Res"+responseText);
		if(responseText=="NO_DUPLICATE_FOUND"){
			window.name = "test";
			formObj.target="test";
			formObj.submit();
			//window.returnValue='';
			//window.close();
			//reset();
		}else{
			//alert("This Set and Tray combination already exists!");
			alert(getMessage("APP-OT0050","OT"));
			return false;
		}
	}
}

function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}
function CheckNum(obj) {
	//var formObj_bio= parent.bio_hazard_frame.document.BiohazardForm;
   //formObj_bio.flag_confirmed_yn.value="Y";
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}
function changeFlag()
{
var formObj_bio= parent.bio_hazard_frame.document.BiohazardForm;
formObj_bio.flag_confirmed_yn.value="Y";
}

function checkForSpecCharsforID(event)
{   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,= ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if(event.keyCode<200)
	{
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;
	}
	return true ;
}
function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
            if ((str.charCodeAt(u)==42)||((str.charCodeAt(u)>=44) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10) ||(str.charCodeAt(u)>200));
            else{
                specCharsExist = true;
                break;
            }
        }
        return specCharsExist;
    }
	function CheckChars1(obj)
	{
	   var specCharsExist=CheckChars2(obj);
	   if(specCharsExist==true) 
		{
		 alert("Special Characters other than _ * / - . , =   are not allowed");
		  obj.focus();
	      return;
		}
	}

	//CRF-268 Instrument Count - Rajesh V
	function assignTary(obj){
		var selVal = obj.value;
		var selText = obj[obj.selectedIndex].text;
		var frmObj = document.forms[0];
		frmObj.tray_num.value = selText;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH  /></root>";
		var param="func_mode=getQOH&instrument_code="+selVal;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var qoh = localTrimString(xmlHttp.responseText);	
		frmObj.units.value = qoh;
	}

	function localTrimString(sInString) {
		return sInString.replace(/^\s+|\s+$/g,"");
	}
	//CRF-268 Instrument Count - Rajesh V
