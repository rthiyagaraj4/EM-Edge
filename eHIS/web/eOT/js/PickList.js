/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Functions of PickGenByDate.jsp

function reset()
{
if(parent.frames[2].frames[1].frames[1].document.location.href.indexOf("PickGenByDate.jsp") != -1){
	 parent.frames[2].frames[1].frames[1].document.forms[0].reset();
	}
	else{
		 parent.frames[2].frames[1].frames[1].frames[1].frames[1].document.forms[0].reset();
	}
}
	

function assignItem( desc,code,flag){
	var frmObj=document.forms[0];
	var descArr=new Array();
	var codeArr=new Array();
	desc=desc.replace("^","(");
	desc=desc.replace("!",")");
	desc=desc.replace("@","'");
	if(flag=='1'){
		selObj=frmObj.theatre_type;
		descArr=desc.split(",");
		codeArr=code.split(",");
		var len=0;
		len=selObj.length-2;
		for( var co=len;co>1;co--)
			selObj.remove(co);   
		for( len=1;len<codeArr.length;len++)
			selObj.options[len]=new Option(descArr[len-1],codeArr[len-1]);
	}else if(flag=='2'){
		selObj=frmObj.theatre;
		descArr=desc.split(",");
		codeArr=code.split(",");
		var len=0;
		len=selObj.length-2;
		for( var co=len;co>1;co--)
		selObj.remove(co);   
		for( len=1;len<codeArr.length;len++)
			selObj.options[len]=new Option(descArr[len-1],codeArr[len-1]);
	}
}

function callPickList(){
	var frmObj=document.forms[0];
	//Added by lakshmi against CRF-0058 starts here
	var scheduledate = frmObj.schedule_date.value;
	scheduledate=changeDate(scheduledate);
	var dat =new Date(scheduledate);
	var sysdate = frmObj.system_date.value;	
	sysdate = changeDate(sysdate);
	var date = new Date(sysdate);
	//Added by lakshmi against CRF-0058 ends here
	
	if(frmObj.schedule_date.value==''||frmObj.schedule_date.value==null){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var scheduleDate =getLabel("Common.ScheduleDate.label","Common");
		alert(msgArray[0]+scheduleDate+msgArray[1]);
		return false;
	}
	
	//Added by lakshmi against CRF-0058 starts here
	if(dat < date){
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var scheduleDate =getLabel("Common.ScheduleDate.label","Common");
		var currentDate =getLabel("Common.CurrentDate.label","Common");
		alert(msgArray[0]+scheduleDate+msgArray[1]+currentDate);
		return false;
	}
	//Added by lakshmi against CRF-0058 ends here

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	var locale=frmObj.locale.value;
	var schedule_date=dateUtils(frmObj.schedule_date.value,locale);
	
	//Added by lakshmi against CRF-0146 05/01/2012
	if(frmObj.Ot_param.value=="Y"){
	if(frmObj.source_code.value==null || frmObj.source_code.value==''){
	var param="room_code="+frmObj.theatre.value+"&schedule_date="+schedule_date+"&patient_id="+frmObj.patientid.value+"&strSourceCode="+frmObj.source_code.value+"&strSrcTypeTemp="; //Modified by lakshmi against CRF-0146
	}
	else{
		var param="room_code="+frmObj.theatre.value+"&schedule_date="+schedule_date+"&patient_id="+frmObj.patientid.value+"&strSourceCode="+frmObj.source_code.value+"&strSrcTypeTemp="+frmObj.source_type.value; //Modified by lakshmi against CRF-0146
		}
	}
	else
	{
		var param="room_code="+frmObj.theatre.value+"&schedule_date="+schedule_date+"&patient_id="+frmObj.patientid.value+"&="+null+"&="+null;		//Modified by lakshmi against CRF-0146
	}
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.PickListServlet?"+param, false);
	xmlHttp.send(xmlDoc);
	var resTxt=trimString(xmlHttp.responseText);
	if(resTxt=="APP-OT0104"){
		alert(getMessage(resTxt,"OT"));
	}else{
		alert(resTxt);		
	}
//Call Report for pickList
}
/*
function callPatientSearch(){
	var patient_id	=	document.forms[0].patientid;
	var return_value =	"";
	return_value	=	PatientSearch();	
	var obj=document.forms[0];
	if(return_value!=null){
		obj.patientid.value	=	return_value;
	}else{
		obj.patientid.value	="";
	}
	obj.submit();
}
*/

async function callReport(){
	var frmObj=document.forms[0];
	//Added by lakshmi against CRF-0058 starts here
	var scheduledate = frmObj.schedule_date.value;
	scheduledate=changeDate(scheduledate);
	var dat =new Date(scheduledate);
	var sysdate = frmObj.system_date.value;
	sysdate = changeDate(sysdate);
	var date = new Date(sysdate);
	//Added by lakshmi against CRF-0058 ends here

	if(frmObj.schedule_date.value==''||frmObj.schedule_date.value==null){
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var scheduleDate =getLabel("Common.ScheduleDate.label","Common");
		alert(msgArray[0]+scheduleDate+msgArray[1]);
		return false;
	}

	//Added by lakshmi against CRF-0058 starts here
	if(dat < date){
		var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
		var msgArray = msg.split("#");
		var scheduleDate =getLabel("Common.ScheduleDate.label","Common");
		var currentDate =getLabel("Common.CurrentDate.label","Common");
		alert(msgArray[0]+scheduleDate+msgArray[1]+currentDate);
		return false;
	}
	//Added by lakshmi against CRF-0058 ends here

	var booking_num  = flag1;
	var dialogHeight = "150px" ;
	var dialogWidth	 = "300px" ;
	var arguments	 = "" ;
	var locale=frmObj.locale.value;
	//var schedule_date=dateUtils(frmObj.schedule_date.value,locale);
	var schedule_date=frmObj.schedule_date.value;
	var features	 = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	var url = "../../eOT/jsp/PickListReport.jsp";
	if(frmObj.Ot_param.value=="Y"){	
		if(frmObj.source_code.value==null || frmObj.source_code.value==''){
		url=url+"?room_code="+frmObj.theatre.DB_VALUE+"&booking_date="+schedule_date+"&patient_id="+frmObj.patientid.value+"&theatre_type="+frmObj.theatre_type.value+"&theatre="+frmObj.theatre.value+"&source_code=&source_type=&source_desc=" //modified by lakshmi against CRF-0146
		}
	else{
		url=url+"?room_code="+frmObj.theatre.DB_VALUE+"&booking_date="+schedule_date+"&patient_id="+frmObj.patientid.value+"&theatre_type="+frmObj.theatre_type.value+"&theatre="+frmObj.theatre.value+"&source_type="+frmObj.source_type.value+"&source_code="+frmObj.source_code.value+"&source_desc="+frmObj.source_desc.value; //modified by lakshmi against CRF-0146
		}
	}
	else{
		url=url+"?room_code="+frmObj.theatre.DB_VALUE+"&booking_date="+schedule_date+"&patient_id="+frmObj.patientid.value+"&theatre_type="+frmObj.theatre_type.value+"&theatre="+frmObj.theatre.value+"&source_code=&source_type=&source_desc="//Modified by lakshmi against CRF-0146
		}
	retVal = await window.showModalDialog(url, arguments, features);		
	//parent.window.returnValue=1;
	//parent.window.close();
let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = 1;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
}

function callCommonServlet(fl,locale){ 
	var locale = document.forms[0].locale.value;
	if(fl!='0'){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root></root>";
		var objFrm =document.forms[0];
		var sql="";
		if(fl=='1')	 			
			sql="SELECT SHORT_DESC SHOR_DESC1, LOCN_TYPE  ORDER_TYPE1 FROM  AM_CARE_LOCN_TYPE_LANG_VW WHERE language_id='"+locale+"' and CARE_LOCN_TYPE_IND = 'O'   ORDER BY 1";
		else if(fl=='2' && objFrm.theatre_type.value !='')
			sql="SELECT SHORT_DESC SHOR_DESC1, OPER_ROOM_CODE ORDER_TYPE1 FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+objFrm.facilityId.value+"' AND THEATRE_TYPE = '"+objFrm.theatre_type.value+"' ORDER BY 1";
		else if( fl=='2'){
			sql="SELECT SHORT_DESC SHOR_DESC1, OPER_ROOM_CODE  ORDER_TYPE1 FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+objFrm.facilityId.value+"' ORDER BY 1";
		}
		var param="sql="+sql+"&flag="+fl;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param, false);
		xmlHttp.send(xmlDoc);
		var resTxt=""+xmlHttp.responseText;
		eval(resTxt);
		if(fl=='1' && document.getElementById('theatre_type').DB_VALUE!=''){
			alert("DB_VALUE :"+DB_VALUE);
		 document.getElementById('theatre_type').value=document.getElementById('theatre_type').DB_VALUE;
		  callCommonServlet('2');
		}else{
			alert("DB_VALUE value :"+DB_VALUE);
		  document.getElementById('theatre_type').DB_VALUE="";
		}
		if(fl=='2' && objFrm.theatre.DB_VALUE!=''){
			alert("DB_VALUE value :"+DB_VALUE);
		 document.getElementById('theatre').value=document.getElementById('theatre').DB_VALUE;
		}	
	}
}
// --------------End of Functions of PickGenByDate.jsp-----------

// ----Functions of  PickListReviewItemSelect.jsp--
var rows = new Array();
function Class_row(){
    this.item_type ="";
	this.item_type_desc="";
    this.item_desc ="";
    this.item_id ="";
    this.no_units = "";
	this.status = "";//MuthuN
	this.request_no = "";//MuthuN
    this.finalize_yn="";
	this.db_mode="";
}

async function createXMLForPickList(){
//Added By MuthuN against CRF - 268 Starts
  var formObj =parent.parent.frames[0].schdule_dtl.document.forms[0];
  var mode ="";
  var function_id ="";
  var module_id ="";
  var doc_type_code = formObj.cssd_doc_type.value;
  var doc_no = "";//empty
  var doc_date =""; //empty
  var req_by_store_code = formObj.cssd_store_req.value;  
  var req_on_store_code = formObj.cssd_store_ret.value;
  var booking_num = formObj.booking_num.value; 
  var surgeryDate = formObj.surgeryDate.value;
  var entry_completed_yn ="Y"; //Y
  var request_type ="N"//N
  var locale=formObj.locale.value;
  var facilityid=formObj.facilityid.value;
  var ot_Param =document.forms[0].ot_Param.value;
//Added By MuthuN against CRF - 268 Ends

  var table_name="OT_PICK_LISTS";
  var len = rows.length;
  var xmlString ="";
  var from_val=document.forms[0].from_val.value;
  var St_module_install=document.forms[0].St_module_install.value;
  var st_interface_flag=document.forms[0].st_interface_flag.value;
  var flag=true;
  var status ="";
  var request_no ="";

  var xmlDoc = "" ;
  var xmlHttp = new XMLHttpRequest() ;
  var xmlStr ="<root><SEARCH ";	
  xmlStr +=" /></root>";
  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
  xmlHttp.open("GET","../../eOT/jsp/ClearPickListBeanObj.jsp?",false);
  xmlHttp.send(xmlDoc);

  for(i=0;i<len;i++){
	  //Added By MuthuN against CRF	
  	var noofunits = rows[i].no_units;
	//if(ot_Param == 'Y' || ot_Param=='y'){
		var item_id =rows[i].item_id; // Need to pass
		var qtyavail = rows[i].qty_avail;
	//}
	  //Added By MuthuN against CRF
	 if(rows[i]!=null && rows[i].db_mode !='DB'){
	// if(rows[i]!=null && rows[i].db_mode !='DB' && rows[i].finalize_yn=='Y'){
		  if(rows[i].finalize_yn=='Y' || ot_Param != 'Y' ){
		if(from_val =="PI" && st_interface_flag =="Y")
		 {
		 var requeststore=rows[i].requeststore;
		 var requeststore_arr=requeststore.split("|");
		 var req_store_code=requeststore_arr[0];

    	 var issuing_store=rows[i].issuing_store;
		 var issuing_store_arr=issuing_store.split("|");
		 var iss_store_code=issuing_store_arr[0];
		  
		 if(requeststore =="" || iss_store_code =="" )
		 {
			 flag=false;
			  var error=getMessage("PRC-OT0053","OT");
			 alert(error);
			 return ;
		 }else
		 {
			  flag=true;
		 }
		 }

//Added By MuthuN against CRF - 268 Starts
	var item_type = rows[i].item_type;
	var flag_status=false;
	if (rows[i].item_type == 'I' || rows[i].item_type == 'P'){
	if(ot_Param == 'Y' || ot_Param=='y'){
	  if(parseInt(qtyavail,10) < parseInt(noofunits,10))
		 {    	 
		var  param="locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&req_by_store_code="+req_by_store_code+"&req_on_store_code="+req_on_store_code+"&booking_num="+booking_num+"&noofunits="+noofunits+"&qtyavail="+qtyavail+"&item_id="+item_id+"&item_type="+item_type;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		flag_status=true;
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("GET","../../eOT/jsp/PickListFinalDtl.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		flag_status=true;
		status="AAA";
		request_no="###";			
		}else
		{
		  flag=true;
		  status="F";
		}	
}
}
//Added By MuthuN against CRF - 268 Ends
	if(flag==true)
		{
		xmlString+="<PICK_DTL"+i+" ";
		xmlString+="item_type=\""+rows[i].item_type+"\""+" ";
		xmlString+="item_id=\""+rows[i].item_id+"\""+" ";
		xmlString+="no_units=\""+rows[i].no_units+"\""+" ";
		//Added MuthuN for CRF-268 Starts 
		if(ot_Param == 'Y' || ot_Param=='y'){
		xmlString+="status=\""+status+"\""+" ";
		xmlString+="request_no=\""+request_no+"\""+" ";
		}
		//Added MuthuN for CRF-268 Ends
		xmlString+="finalize_yn=\""+rows[i].finalize_yn+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		if(from_val =="PI" && st_interface_flag =="Y")
		 {
		xmlString+="requeststore=\""+req_store_code+"\""+" ";
		xmlString+="issuing_store=\""+iss_store_code+"\""+" ";
		xmlString+="reserve_qty=\""+rows[i].reserve_qty+"\""+" ";
		xmlString+="request_qty=\""+rows[i].request_qty+"\""+" ";
		 }
		xmlString+="table_name=\""+table_name+"\"";
		xmlString+=" />";	
	 }
	 }
	 }else if(rows[i]!=null &&  rows[i].finalize_yn=='Y' ){
		if(from_val =="PI" && st_interface_flag =="Y")
		{
		 var requeststore=rows[i].requeststore;
		 var requeststore_arr=requeststore.split("|");
		 var req_store_code=requeststore_arr[0];
    	 var issuing_store=rows[i].issuing_store;
		 var issuing_store_arr=issuing_store.split("|");
		 var iss_store_code=issuing_store_arr[0];
		if(requeststore =="" || iss_store_code =="" )
		{
			 flag=false;
			 var error=getMessage("PRC-OT0053","OT");
			 alert(error);
			 return;
		 }else
		 {
			 flag=true;
		 }
		 }



//Added By MuthuN against CRF - 268 Starts
	var item_type = rows[i].item_type;
	var flag_status=false;
	if (rows[i].item_type == 'I' || rows[i].item_type == 'P' && rows[i].item_type != 'E'){
	if(ot_Param == 'Y' || ot_Param=='y'){
	  if(parseInt(qtyavail,10) < parseInt(noofunits,10) && rows[i].cssd_status != 'Requested')
		 {    	 
		var  param="locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&req_by_store_code="+req_by_store_code+"&req_on_store_code="+req_on_store_code+"&booking_num="+booking_num+"&noofunits="+noofunits+"&qtyavail="+qtyavail+"&item_id="+item_id+"&item_type="+item_type;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("GET","../../eOT/jsp/PickListFinalDtl.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		flag_status=true;
		status="AAA";
		request_no="###";			
		}else if(rows[i].cssd_status != 'Requested')
		{
		  flag=true;
		  status="F";
		}
		else if(parseInt(qtyavail,10) < parseInt(noofunits,10) && rows[i].cssd_status == 'Requested') {
				 continue;
		}
		else if(rows[i].cssd_status == 'Requested' && parseInt(qtyavail,10) >= parseInt(noofunits,10))
				{
		  flag=true;
		  status="F";
				}
}
}
//Added By MuthuN against CRF - 268 Ends

if(flag==true)
		 {
			xmlString+="<PICK_DTL"+i+" ";
			xmlString+="item_type=\""+rows[i].item_type+"\""+" ";
			xmlString+="item_id=\""+rows[i].item_id+"\""+" ";
			xmlString+="no_units=\""+rows[i].no_units+"\""+" ";
		//Added MuthuN for CRF-268 Starts
		if(ot_Param == 'Y' || ot_Param=='y'){
			xmlString+="status=\""+status+"\""+" ";
			xmlString+="request_no=\""+request_no+"\""+" ";
		}
		//Added MuthuN for CRF-268 Ends
			xmlString+="finalize_yn=\""+rows[i].finalize_yn+"\""+" ";
			xmlString+="db_mode=\"DB\""+" ";
		if(from_val =="PI" && st_interface_flag =="Y")
		 {
			xmlString+="req_store_code=\""+req_store_code+"\""+" ";
			xmlString+="iss_store_code=\""+iss_store_code+"\""+" ";
			xmlString+="reserve_qty=\""+rows[i].reserve_qty+"\""+" ";
			xmlString+="request_qty=\""+rows[i].request_qty+"\""+" ";
		 }
			xmlString+="table_name=\""+table_name+"\"";
			xmlString+=" />";	
		 }
	 }
  }
/* Request CSSD page logic Starte Here for CRF - 368 Added by MuthuN */
		if(flag_status==true) {
			var qty_suffi = confirm(getMessage('APP-OT200','OT'));
			if(qty_suffi == true){	
				var retVal = "";
				var dialogHeight = "40";
				var dialogWidth = "65";
				var dialogTop = "200";
				var center = "1";
				var status = "no";
				var title=encodeURIComponent(getLabel("eOT.ConsumablesUsed.Label","OT"));
				var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments = "";
				var url ="../../eSS/jsp/RequestGroup.jsp?"+"mode=1&function_id=SS_REQUEST_GROUP&module_id=OT&beanid=OTPickListBean&beanName=eOT.OTPickListBean&doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&doc_date="+doc_date+"&req_by_store_code="+req_by_store_code+"&req_on_store_code="+req_on_store_code+"&entry_completed_yn="+entry_completed_yn+"&request_type="+request_type+"&title="+title;
				retVal = await window.showModalDialog(url, arguments, features);

		if(retVal == undefined){			
			return;
			}
		if(retVal!=null && retVal != "")
			{
			flag = true;	
			var request_no1=retVal;
			var request_no2=request_no1.split(":");
			request_no=request_no2[1];
			status="R";			
			}
		}else{
			flag = true;
			var equip_not_added =getMessage("APP-OT202","OT");
			alert(equip_not_added);
			status ="N";
			request_no="";
			}
			}
		var statusStr="status="+status;
		var requestNoStr="request_no="+request_no;
		var re=/AAA/g;
		var re1=/###/g;
		xmlString=xmlString.replace(re,status);
		xmlString=xmlString.replace(re1,request_no);
/* Request CSSD page logic Starte Here for CRF - 368 Added by MuthuN */
  return xmlString;
}

function loadDBRows(item_type,item_type_desc,item_desc,item_id,no_units,index,Req_code,Req_on_code,Reserve_qty,Request_qty,avail_stock){ 
  var objrow = newRow();
  var rowLength= rows.length; 
	objrow.item_type= item_type;		 
	objrow.item_type_desc=item_type_desc;		
	objrow.item_desc=item_desc;
    objrow.item_id=item_id;
	objrow.no_units=no_units;
	objrow.requeststore=Req_code;
	objrow.issuing_store=Req_on_code;
	objrow.reserve_qty=Reserve_qty;
	objrow.request_qty=Request_qty;	

	objrow.QOHqty_qty=avail_stock;
	objrow.finalize_yn="N";
	objrow.db_mode="DB";
	objrow.mode="I";
	objrow.exist_db="D";
	rows.push(objrow);	   
}

function loadDBRows_pick(item_type,item_type_desc,item_desc,item_id,cssd_status,qty_avail,no_units,index,Req_code,Req_on_code,Reserve_qty,Request_qty,avail_stock){ 
  var objrow = newRow();
  var rowLength= rows.length; 
	objrow.item_type= item_type;		 
	objrow.item_type_desc=item_type_desc;		
	objrow.item_desc=item_desc;
    objrow.item_id=item_id;
	objrow.no_units=no_units;
	objrow.requeststore=Req_code;
	objrow.issuing_store=Req_on_code;
	objrow.reserve_qty=Reserve_qty;
	objrow.request_qty=Request_qty;
	//Added by MuthuN for CRF-268 Starts
	if(cssd_status == "F")	cssd_status="Finalized";
	if(cssd_status == "R")	cssd_status="Requested";
	if(cssd_status == "N")	cssd_status="Not Requested";
	objrow.cssd_status=cssd_status;
	//objrow.qty_avail=qty_avail;	
	//Added by MuthuN for CRF-268 Ends

	objrow.QOHqty_qty=avail_stock;
	objrow.finalize_yn="N";
	objrow.db_mode="DB";
	objrow.mode="I";
	objrow.exist_db="D";
	objrow.qty_avail=quantityavail_onLoad(item_type,item_id);
	rows.push(objrow);
}

function splitString(strVal){
	var arr = strVal.split('::');
	var frmObj = document.forms[0];
	var ot_Param = document.forms[0].ot_Param.value;
	frmObj.item_type.value=arr[0];
	frmObj.item_id.value=arr[1];
	frmObj.item_desc.value=arr[2];
	frmObj.quantity.value=arr[3];  
	frmObj.recId.value=arr[4];
	var cssd_status_final = arr[12];

	//Added by MuthuN for CRF-268 Starts
	if(frmObj.item_type.value =='I' || frmObj.item_type.value =='P' || frmObj.item_type.value =='E'){
	if(ot_Param == 'Y' || ot_Param=='y'){	
		frmObj.quantity_avail.value=arr[11];
    if(	frmObj.quantity_avail.value =='undefined')
		{
		frmObj.quantity_avail.value='';
		frmObj.quantity_avail.disabled=true;
		}
	frmObj.quantity_avail.disabled=true;//Added newly
	if(cssd_status_final =='Requested'){
		frmObj.quantity.disabled = true;
	}else{
		frmObj.quantity.disabled = false;
	}
	}
}
	//Added by MuthuN for CRF-268 Ends

	var st_interface_flag=parent.frames[1].document.forms[0].st_interface_flag.value;
	if(parent.frames[1].document.forms[0].from_val.value =="PI" && st_interface_flag=="Y")
	{
	frmObj.requeststore.value=arr[5];
	frmObj.issuing_store.value=arr[6];
	frmObj.reserve_qty.value=arr[7];
	frmObj.request_qty.value=arr[8];
	frmObj.QOHqty_qty.value=arr[9];
	frmObj.exist_db.value=arr[10];

	//frmObj.quantity.disabled=true;
		parent.frames[1].document.forms[0].QOHqty_qty.disabled=true;
		parent.frames[1].document.forms[0].reserve_qty.disabled=false;
	}
	frmObj.chkbut.disabled=true;
	frmObj.item_desc.disabled=true;
	//frmObj.selec.disabled=true;
	frmObj.item_type.disabled=true;
	if(frmObj.item_type.value=="R")
		frmObj.document.getElementById("noofperorunits").innerHTML="No Of Persons";
	else
		frmObj.document.getElementById("noofperorunits").innerHTML="No Of Units";	
if(parent.frames[1].document.forms[0].from_val.value =="PI" && st_interface_flag=="Y")
	{
if(frmObj.requeststore.value== "")
	{
	var oper_room_code=parent.frames[1].document.forms[0].OperRoomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklistdefaultreqvalue&oper_room_code="+oper_room_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	if(retVal !="")
		{
	frmObj.requeststore.value=retVal;
		}else
		{
			frmObj.requeststore.value="";
		}

	var store_val=frmObj.requeststore.value.split("|");
	var store_code=store_val[0];
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+frmObj.item_id.value+"&store_code="+store_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	
	if(retVal=="false")
	{
		document.forms[0].QOHqty_qty.value="";
		document.forms[0].reserve_qty.disabled=true;

	}else if(retVal=="false1")
		{
			alert(getMessage("APP-OT0143","OT"));
			parent.frames[1].document.location.reload();

	}else
	{
	document.forms[0].QOHqty_qty.value=retVal;
	document.forms[0].reserve_qty.disabled=false;
	}
	}
	if(frmObj.issuing_store.value =="")	
	{
	var oper_room_code=parent.frames[1].document.forms[0].OperRoomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklistdefaultissuvalue&oper_room_code="+oper_room_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
		if(retVal !="")
		{
	frmObj.issuing_store.value=retVal;
		}else
		{
			frmObj.issuing_store.value="";
		}
	}	
}
}

function changelabel(){
	var formObj = document.forms[0];
	if(formObj.item_type.value=="R"){
		formObj.document.getElementById("noofperorunits").innerHTML="No Of Persons";
	}else{
		formObj.document.getElementById("noofperorunits").innerHTML="No Of Units";
	}
}

function resetFields(){
	var frmObj = document.forms[0];
	//Added by MuthuN for CRF-268 Starts
	var ot_Param = document.forms[0].ot_Param.value;
	if(ot_Param == 'Y' || ot_Param=='y'){	
	if(frmObj.item_type.value == 'I' || frmObj.item_type.value =='P'){
	frmObj.quantity_avail.value='';
	}
	}
	//Added by MuthuN for CRF-268 Ends

	frmObj.item_type.value='';
	frmObj.item_id.value='';
	frmObj.item_desc.value='';
	frmObj.quantity.value='';

	var from_val=frmObj.from_val.value;
	var St_module_install=frmObj.St_module_install.value;
	var st_interface_flag=frmObj.st_interface_flag.value;
	if(from_val == "PI" && st_interface_flag=="Y")
	{	
		frmObj.reserve_qty.value='';
		frmObj.request_qty.value='';
		frmObj.QOHqty_qty.value='';
		frmObj.requeststore.selectedIndex=0;
		frmObj.issuing_store.selectedIndex=0;
	}

	frmObj.mode.value='I';
	frmObj.quantity.disabled=false;
	frmObj.chkbut.disabled=false;
	frmObj.item_type.disabled=false;
	frmObj.item_desc.disabled=false;//Added MuthuN
}

function addRow(){	
	var formObj = document.forms[0];
	var ot_Param = document.forms[0].ot_Param.value;
	var obj = formObj.item_type;
	var item_type=formObj.item_type.value;
	var item_desc=formObj.item_desc.value;
	var item_id=formObj.item_id.value;
	var item_type_desc = formObj.item_type.options[obj.selectedIndex].text;
	var no_units=formObj.quantity.value;

	//Added by MuthuN for CRF-268 Starts//
	var qty_avail="";
	if(item_type =='I' || item_type =='P'){
		if(ot_Param == 'Y' || ot_Param=='y')
		{
			qty_avail=formObj.quantity_avail.value;
		}
	}
	//Added by MuthuN for CRF-268 Ends

	var mode=formObj.mode.value;
	var from_val=formObj.from_val.value;
	var St_module_install=formObj.St_module_install.value;
	var st_interface_flag=formObj.st_interface_flag.value;
	var flag=true;
	var flag1= true;
	if(from_val == "PI" && st_interface_flag=="Y")
	{	
	var selin=formObj.requeststore.options.selectedIndex;
	var req_code=formObj.requeststore.options(selin).value;
	
	var store_arr=req_code.split("|");
	var req_store_code=store_arr[0];
	var  req_store_desc=store_arr[1];

	var selin_iss=formObj.issuing_store.options.selectedIndex;
	var iss_code=formObj.issuing_store.options(selin_iss).value;
	var store_arr2=iss_code.split("|");
	var iss_store_code=store_arr2[0];
	var  iss_store_desc=store_arr2[1];
	var st_interface_flag=formObj.st_interface_flag.value;

	var reserve_qty=formObj.reserve_qty.value;
	var request_qty=formObj.request_qty.value;
	var QOHqty_qty=formObj.QOHqty_qty.value;
		if(parseInt(reserve_qty)>parseInt(QOHqty_qty))
		{
		var err=getMessage("PRC-OT0052","OT");
		alert(err);
		formObj.reserve_qty.value="";
		formObj.request_qty.value="";
		flag1= false;
		}
	}

	var objrow = newRow();	
	var pos=0;
	//var msg = trimString(getMessage("DUPLICATE_RECORD"));
	//var msg="Record Already exist";
	var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
	//"Code already selected.........";


	if(chkEmpty()){
		if(mode=='I' && alreadyExist()) {
		if(from_val == "PI" &&  st_interface_flag=="Y")
	{
		var req_qty=formObj.request_qty.value;
		var res_qty=formObj.reserve_qty.value;
		if(req_qty =="") req_qty="0";
		if(res_qty =="") res_qty="0";
		var sum_val=parseInt(req_qty)+parseInt(res_qty);
		if(req_qty=="" && res_qty =="")
		{			
				flag=false;
				var msg1 = trimString(getMessage("PRC-OT0049","OT"));
				alert(msg1);
	}else
		{
			flag=true;
		}
		if(sum_val == no_units)
		{
			 flag1= true;
		}else
		{			 
			 var msg2 = trimString(getMessage("PRC-OT0048","OT"));
			 alert(msg2);
			 flag1= false;
		}

	if(flag1 ==true)
	{	
		var frmObj=document.forms[0];

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+item_id+"&store_code="+req_code,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText); 
		
		if(retVal=="false")
		{
			document.forms[0].QOHqty_qty.value="";
			document.forms[0].reserve_qty.disabled=true;

		}else if(retVal=="false1")
		{
			alert(getMessage("APP-OT0143","OT"));
			flag1= false;

		}else
		{
		flag1= true;

		}
    
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_store_item&item_id="+item_id+"&store_code="+req_code+"&iss_store="+iss_code,false);
			xmlHttp.send(xmlDoc);

			var retVal = localTrimString(xmlHttp.responseText); 
			if(retVal =="false")
			{
					alert(getMessage("ITEM_STORE_NOT_FOUND","ST"));
					document.forms[0].reserve_qty.value="";
					document.forms[0].request_qty.value="";
					document.forms[0].reserve_qty.disabled=true;
					 flag1= false;
			}else
			{ 
				flag1= true;
			}
		}
		}
		if(flag1 ==true)
			{
			if(from_val == "PI" && st_interface_flag=="Y")
				{					
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");						xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklist_database&booking_no="+formObj.booking_no.value+"&oper_code="+formObj.oper_code.value+"&item_type="+formObj.item_type.value+"&item_id="+formObj.item_id.value+"&strReq_on_code="+iss_store_code+"&strReq_code="+req_store_code,false);
						xmlHttp.send(xmlDoc);
						var retVal = localTrimString(xmlHttp.responseText);						
						if(retVal=="false")
						{							
							flag1= true;
						}else
						{							parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							flag1= false;
						}
				}else
				{
				if(alreadyInDB()==false) 
					parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
					}
			}
			if(flag==true && flag1 ==true)
			{
			objrow.item_type=item_type;
			objrow.item_type_desc=item_type_desc;
			objrow.item_desc=item_desc;
			objrow.item_id=item_id;
			objrow.no_units=no_units;
			//Added by MuthuN for CRF-268 Starts
			if(ot_Param == 'Y' || ot_Param=='y'){	
			objrow.status=status;			
			objrow.qty_avail=qty_avail;
			//objrow.request_no=request_no;
			}
			//Added by MuthuN for CRF-268 Ends

			objrow.mode=mode;
			objrow.exist_db="I";


			if(from_val == "PI" && st_interface_flag=="Y")
			{
				objrow.requeststore=req_code;
				objrow.issuing_store=iss_code;
				objrow.reserve_qty=reserve_qty;
				objrow.request_qty=request_qty;
				objrow.QOHqty_qty=QOHqty_qty;
		
			}

			objrow.finalize_yn="N";
			objrow.db_mode="NW";
			rows.push(objrow);
			resetFields();	
			
			//Added by MuthuN for CRF-268 Starts
			if(ot_Param == 'Y' || ot_Param=='y'){				
			//var qty_avail = document.getElementById("quantity_avail1").value;
			parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp?from_val='+from_val+'&st_interface_flag='+st_interface_flag+'&qty_avail='+qty_avail;
			parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			}else{
			//Added by MuthuN for CRF-268 Ends
			parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp?from_val='+from_val+'&st_interface_flag='+st_interface_flag;
			parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			}
			}else
			{
				
			}
		}else{   
			if(mode=='U' ){
				if(alreadyExist())
				{
					
					updateRow();				  
				}else
				{
				parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				}
				
			  parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp?from_val='+from_val+'&st_interface_flag='+st_interface_flag;
			}else{	
			
				if(alreadyInDB()==false) 
					parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			}	
		}
		if(parent.frames[1].document.forms[0].from_val.value =="PI")
	{
	formObj.item_type.value="S";
	}else 	if(parent.frames[1].document.forms[0].from_val.value =="PD")
	{
	formObj.item_type.value="R";
	}else 	if(parent.frames[1].document.forms[0].from_val.value =="PP")
	{
	formObj.item_type.value="P";
	}else 	if(parent.frames[1].document.forms[0].from_val.value =="IE")
	{
		formObj.item_type.value="";
	}
	if(parent.frames[1].document.forms[0].from_val.value =="PI" && st_interface_flag =="Y")
	{

	var frmObj = document.forms[0];

	var oper_room_code=parent.frames[1].document.forms[0].OperRoomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklistdefaultreqvalue&oper_room_code="+oper_room_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	frmObj.requeststore.value=retVal;

	var oper_room_code=parent.frames[1].document.forms[0].OperRoomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklistdefaultissuvalue&oper_room_code="+oper_room_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	frmObj.issuing_store.value=retVal;

	}
	} else
	{
	}


}

function selectDeselect(obj){
	var flag;
	 var len = rows.length;
	if(obj.checked==true)
	{		
	   flag='1';
	     for(i=0;i<len;i++){			 
			rows[i].finalize_yn="Y";		
		 }
	}else
	{		
	  flag='2';
	  for(i=0;i<len;i++){
			rows[i].finalize_yn="N";
		 }
	}
	parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp?flag='+flag;
}

function updateRow(){	
	var formObj=document.forms[0];
	var recId=formObj.recId.value;
	var unitVal=formObj.quantity.value;
	var from_val=formObj.from_val.value;
	var St_module_install=formObj.St_module_install.value;
	var st_interface_flag=formObj.st_interface_flag.value;
	var item_id=formObj.item_id.value;
	var item_type = formObj.item_type.value;

	//Added by MuthuN for CRF-268 Starts
	var ot_Param = document.forms[0].ot_Param.value;
	var cssd_Status = formObj.cssdStatus.value;
	//Added by MuthuN for CRF-268 Ends

	var flag=true;
	var flag1=true;
	if(from_val == "PI" && st_interface_flag=="Y")
	{	
	var selin=formObj.requeststore.options.selectedIndex;
	var req_code=formObj.requeststore.options(selin).value;


	var selin_iss=formObj.issuing_store.options.selectedIndex;
	var iss_code=formObj.issuing_store.options(selin_iss).value;

	var reserve_qty=formObj.reserve_qty.value;
	var request_qty=formObj.request_qty.value;
	var QOHqty_qty=formObj.QOHqty_qty.value;


		
	}
			if(from_val == "PI" && st_interface_flag=="Y")
	{
		var req_qty=formObj.request_qty.value;
		var res_qty=formObj.reserve_qty.value;
		if(req_qty =="") req_qty="0";
		if(res_qty =="") res_qty="0";
		var sum_val=parseInt(req_qty)+parseInt(res_qty);

		if(req_qty=="" && res_qty =="")
		{
			
				flag=false;
				var msg1 = trimString(getMessage("PRC-OT0049","OT"));
				alert(msg1);
		}else
		{
			flag=true;
		}
		if(sum_val == unitVal)
		{
			 flag1= true;
		}else
		{
			
			 var msg2 = trimString(getMessage("PRC-OT0048","OT"));
			alert(msg2);
			 flag1= false;
		}
	}

	if( flag1==true)
	{
	if(from_val == "PI" && st_interface_flag=="Y")
				{



			var frmObj=document.forms[0];
                   var req_code1=formObj.requeststore.options(selin).value;
				    req_code1=req_code1.split("|") //  to send pick_lict_QOH function splitting it...
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var xmlStr ="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+item_id+"&store_code="+req_code1[0],false);
					xmlHttp.send(xmlDoc);
					var retVal = localTrimString(xmlHttp.responseText); 
					if(retVal=="false")
					{
						document.forms[0].QOHqty_qty.value="";
						document.forms[0].reserve_qty.disabled=true;

					}else if(retVal=="false1")
					{
						alert(getMessage("APP-OT0143","OT"));
						flag1= false;

					}else
					{
					flag1= true;

					}
				
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_store_item&item_id="+item_id+"&store_code="+req_code+"&iss_store="+iss_code,false);
						xmlHttp.send(xmlDoc);

						var retVal = localTrimString(xmlHttp.responseText); 
						if(retVal =="false")
						{
								alert(getMessage("ITEM_STORE_NOT_FOUND","ST"));
								document.forms[0].reserve_qty.value="";
								document.forms[0].request_qty.value="";
								 flag1= false;

						}else
					{
							 flag1= true;
						}
				}
}
	if(flag == true && flag1 ==true)
	{

	if(rows.length > 0 ){  	
		for(var jj=0,cc=0;jj<rows.length;jj++,cc++){			
			if(rows[jj]!=null){
				if(cc==recId){
					if(rows[jj].db_mode='DB') 
					rows[jj].db_mode='DBU';
					rows[jj].no_units=unitVal;

					//Added by MuthuN for CRF-268 Starts
			if(item_type =='I' || item_type =='P'){
				if(ot_Param == 'Y' || ot_Param=='y'){	
					var qty_avail=formObj.quantity_avail.value;
					rows[jj].qty_avail=qty_avail;
					rows[jj].status=status;					
					rows[jj].mode="U";	
						}
				}
				//Added by MuthuN for CRF-268 Ends
					rows[jj].mode="U";
					if(from_val == "PI" && st_interface_flag=="Y")
				{
					rows[jj].requeststore=req_code;
					rows[jj].issuing_store=iss_code;
					rows[jj].reserve_qty=reserve_qty;
					rows[jj].request_qty=request_qty;
					rows[jj].QOHqty_qty=QOHqty_qty;
				
				}
				}
			}else 
				cc--;
		}	  
	}
	}

				

	resetFields();
}

function newRow(){
  var objrow = new Class_row();
   return(objrow);
}

function alreadyInDB(){
	var formObj = document.forms[0];
	var codeDtl = parent.frames[1].code;	
	var item_id = formObj.item_id.value;
	var item_type = formObj.item_type.value;
	var codeRecord = item_type+item_id;
	var checkData='';
	if(rows.length > 0 ){  	
		for(var jj=0,cc=0;jj<rows.length;jj++,cc++){
			if(rows[jj]!=null){
				if(rows[jj].db_mode=='DBD'){
					checkData=rows[jj].item_type+rows[jj].item_id;
					if(checkData==codeRecord){
						rows[jj].db_mode='DB';
						rows[jj].no_units=formObj.quantity.value;
						resetFields();
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						return true;
					}
				 }
			}
		}		
		return false;
	}
}

function alreadyExist(){
	var formObj = document.forms[0];
	var codeDtl = parent.frames[2].code;	
	var codeDtl_mode = parent.frames[2].code_mode;	
	var exist_db =  parent.frames[1].document.forms[0].exist_db.value;
	var item_id = formObj.item_id.value;
	var item_type = formObj.item_type.value;
	
	var st_interface_flag = formObj.st_interface_flag.value;
	var from_val=formObj.from_val.value;
	var codeRecord = "";
	var codeRecord_mode = "";
	var mode=formObj.mode.value;
if(from_val =="PI" && st_interface_flag=="Y" )
	{
	var req_val = formObj.requeststore.value;
	var iss_val = formObj.issuing_store.value;
	var req_arr=req_val.split("|");
	var req_code=req_arr[0];
	var iss_arr=iss_val.split("|");
	var iss_code=iss_arr[0];
	 codeRecord = item_type+item_id+req_code+iss_code;
	 codeRecord_mode= item_type+item_id+req_code+iss_code+mode;

	}else
	{
	 codeRecord = item_type+item_id;
	}
	if(codeDtl.indexOf(codeRecord)>=0)
	{
		if(mode =="U")
		{
	
		if(codeDtl_mode.indexOf(codeRecord_mode)>=0)
		{
			
			if(exist_db !="I")
			{
			 return true ;
			}else
			{
			return false;
			}
		}else
		{
		
			if(exist_db !="I")
			{
			 return false;
			}else
			{
			return true;
			}
		}
		}else
		{

			return false;
		}
	  

	}else
	{
	 return true;
		
	}
}

function refresh(){
  var formObj = document.forms[0];
//  var params = formObj.params.value;
  parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp'
  parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='

}
function removeRow1(){
	var formObj = document.forms[0];
	var recId = document.forms[0].recId.value;
	var st_interface_flag = document.forms[0].st_interface_flag.value;
	var from_val = document.forms[0].from_val.value;
	if(from_val == "PI" && st_interface_flag =="Y")
	{
	var	issue_store=rows[i].issuing_store;
	var	req_store=rows[i].requeststore;
	var issue_split_arr=issue_store.split("|");
	var req_split_arr=req_store.split("|");
	var iss_code=issue_split_arr[0];
	var req_code=req_split_arr[0];
	}
	
	if(rows.length > 0 ){  	
		for(var jj=0,cc=0;jj<rows.length;jj++,cc++){
			if(rows[jj]!=null){
				if(cc==recId){			
					if(rows[jj].db_mode=='NW'){
						delete rows[jj];
						resetFields();
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
						break;
					}else{
						rows[jj].db_mode='DBD'; 			 
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						resetFields();
						//alert("Already Existing Records Cannot be Deleted");
					}
				}
			}else{
				cc--;
				continue;
			}
		}//end for-Loop 
	}else
		{
		resetFields();
		}

/*	if(rows.length > 0 ){  	
		for(var jj=0,cc=0;jj<rows.length;jj++,cc++){
			if(rows[jj]!=null){
				if(cc==recId){			
					if(rows[jj].db_mode=='NW'){
						delete rows[jj];
						resetFields();
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
						break;
					}else{
						rows[jj].db_mode='DBD'; 			 
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						resetFields();
						//alert("Already Existing Records Cannot be Deleted");
					}
				}
			}else{
				cc--;
				continue;
			}
		}//end for-Loop 
	}else
		resetFields();*/
}
function removeRow(){	
	var formObj = document.forms[0];
	
	//Added by MuthuN against CRF-268 on 12/17/2012 Starts Here
	var booking_num =formObj.booking_no.value;
	var item_id =formObj.item_id.value;
	var facilityid = formObj.facilityid.value;
	var surgeryDate = formObj.surgery_date.value	
	if(formObj.quantity.disabled){
		if(formObj.item_type.value == 'I'){
		var  param="func_mode=pick_list_item_request_id&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&booking_num="+booking_num;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var request_id = retVal;
		alert('Please cancel the raised CSSD request id '+request_id+' from the CSSD Module');
		//return;
		}else if(formObj.item_type.value == 'P'){
		var  param="func_mode=pick_list_package_request_id&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&booking_num="+booking_num;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
		var request_id = retVal;
		alert('Please cancel the raised CSSD request id '+request_id+' from the CSSD Module');
		//return;
		}
	}
	//else{//Muthu Commented
//Added by MuthuN against CRF-268 on 12/17/2012	Ends Here
	var recId = document.forms[0].recId.value;
	var st_interface_flag = document.forms[0].st_interface_flag.value;
	var from_val = document.forms[0].from_val.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(from_val == "PI" && st_interface_flag =="Y")
	{
	var	issue_store=rows[i].issuing_store;
	var	req_store=rows[i].requeststore;
	var issue_split_arr=issue_store.split("|");
	var req_split_arr=req_store.split("|");
	//alert("issue_split_arr"+issue_split_arr);
	//	alert("req_split_arr"+req_split_arr);
	var iss_code=issue_split_arr[0];
	var req_code=req_split_arr[0];
	}
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=delete_picklist&booking_no="+formObj.booking_no.value+"&oper_code="+formObj.oper_code.value+"&item_type="+formObj.item_type.value+"&item_id="+formObj.item_id.value+"&strReq_on_code="+iss_code+"&strReq_code="+req_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);

if(retVal=="true")
{
	var msg=getMessage("RECORD_DELETED","SM");
	alert(msg);
parent.frames[1].document.location.reload();
resetFields();
}else
	{
	if(rows.length > 0 ){  	
		for(var jj=0,cc=0;jj<rows.length;jj++,cc++){
			if(rows[jj]!=null){
				if(cc==recId){			
					if(rows[jj].db_mode=='NW'){
						delete rows[jj];
						resetFields();
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
						break;
					}else{
						rows[jj].db_mode='DBD'; 			 
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						resetFields();
						//alert("Already Existing Records Cannot be Deleted");
					}
				}
			}else{
				cc--;
				continue;
			}
		}//end for-Loop 
	}else
		{
		resetFields();
		}
		var msg=getMessage("RECORD_DELETED","SM");
	alert(msg);
}
/*	if(rows.length > 0 ){  	
		for(var jj=0,cc=0;jj<rows.length;jj++,cc++){
			if(rows[jj]!=null){
				if(cc==recId){			
					if(rows[jj].db_mode=='NW'){
						delete rows[jj];
						resetFields();
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
						break;
					}else{
						rows[jj].db_mode='DBD'; 			 
						parent.frames[2].location.href='../../eOT/jsp/PickListReviewItemDtl.jsp';
						resetFields();
						//alert("Already Existing Records Cannot be Deleted");
					}
				}
			}else{
				cc--;
				continue;
			}
		}//end for-Loop 
	}else
		resetFields();*/
	//}//Muthu Commented
}

function chkEmpty(){
	var formObj = document.forms[0];
	var from_val=formObj.from_val.value;
	var St_module_install=formObj.St_module_install.value;
	var st_interface_flag=formObj.st_interface_flag.value;
	var fields="";
	if(from_val == "PI" && st_interface_flag=="Y")
	{
		//Commented by rajesh bcoz item type is going as blank
		//fields	= new  Array(formObj.item_type,formObj.item_desc,formObj.quantity,formObj.requeststore,formObj.issuing_store);
		fields	= new  Array(formObj.item_desc,formObj.quantity,formObj.requeststore,formObj.issuing_store);
	}else
	{
		////Commented by rajesh bcoz item type is going as blank
		//fields	= new  Array(formObj.item_type,formObj.item_desc,formObj.quantity);
		fields	= new  Array(formObj.item_desc,formObj.quantity);
	}
	var noofUnits			="";
	var itemType			=getLabel("Common.Itemtype.label","Common");
	var itemDescription		=getLabel("Common.ItemDescription.label","Common");
	if(from_val == "PD")
	{
		noofUnits=	getLabel("eOT.NoOfPersons.Label","OT");
	}else
	{
		noofUnits=	getLabel("eOT.NoofUnits.Label","OT");
	}
	var Request_store    =getLabel("eOT.RequestingStore.Label","OT");
	var issuing_store		=getLabel("eOT.IssuingStore.Label","OT");

	var names = "";
	if(from_val == "PI" && st_interface_flag=="Y")
	{
		names=	new Array(itemDescription,noofUnits,Request_store,issuing_store);
	}else
	{
		names=	new Array(itemDescription,noofUnits);
	}


	
	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
	 return true;
	
}

function validateUnits(obj){
	if(obj.value == '' || obj.value < '1' || obj.value >'9'){
		//alert('Unit value should be numeric  and  more than 0');
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
		obj.focus();
	}
}

function isModify(){
	for(var len=0;len<rows.length;len++)
		if(rows[len]!=null &&(rows[len].db_mode=='I' || rows[len].finalize_yn=='Y'))
			return true;
	
	return false;
}

function applyRecord(){
	var frmObj=document.forms[0];
	var frmObj1 =parent.frames[2].document.forms[0];
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var xmldata;
	var param="patient_id="+frmObj.patient_id.value+"&surgery_date="+frmObj.surgery_date.value+"&surgeoncode="+frmObj.surgeoncode.value+"&booking_no="+frmObj.booking_no.value+"&oper_code="+frmObj.oper_code.value+"&from_val="+frmObj.from_val.value+"&St_module_install="+frmObj.St_module_install.value+"&st_interface_flag="+frmObj.st_interface_flag.value;
	xmldata=createXMLForPickList();
	xmldata=xmldata;
	xmlStr+=xmldata;
	xmlStr+="</root>";
	if(xmldata)
		{
		if(xmldata.length == 0)  
		return ;	 
		var action = "../../servlet/eOT.PickListReviewServlet?"+param;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		alert(retVal);
		parent.parent.location.reload();
		}
	}

/* Below function for getting the quantity value during the selection of item_description & Package_description */
//Added by MuthuN for CRF-268 Instrument & Package Starts
function quantityavail(){
	var formObj = parent.frames[1].document.forms[0];
	var formObj_flt = parent.parent.frames[0].frames[1].document.forms[0];
	var locale=formObj.locale.value;
	var ot_Param = formObj.ot_Param.value;
	var surgeryDate=formObj.surgery_date.value;
	var facilityid = formObj.facilityid.value;
	var cssd_store_req = formObj_flt.cssd_store_req.value;
	var cssd_store_ret = formObj_flt.cssd_store_ret.value;	
	var item_type = document.forms[0].item_type.value;
	var item_id =formObj.item_id.value;
//	if (item_type =='I' || item_type =='P')
	if (item_type =='I'){
	var  param="func_mode=pick_list_item_select&locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	}else if(item_type =='P'){
	var  param="func_mode=pick_list_package_select&locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	}

	var qty_avail =retVal;	
		if (item_type =='I' || item_type =='P')
		{
		if(ot_Param == 'Y' || ot_Param=='y')
			{
				formObj.quantity_avail.value =qty_avail;
			}
		}
	}

function quantityavail_onLoad(itemType,itemId){
	var formObj = parent.frames[1].document.forms[0];
	var formObj_flt = parent.parent.frames[0].frames[1].document.forms[0];
	var locale=formObj.locale.value;
	var ot_Param = formObj.ot_Param.value;
	var surgeryDate=formObj.surgery_date.value;
	var facilityid = formObj.facilityid.value;
	var cssd_store_req = formObj_flt.cssd_store_req.value;
	var cssd_store_ret = formObj_flt.cssd_store_ret.value;	
	var item_type = itemType;
	var item_id =itemId;
	var qty_avail=0;
	//if (item_type =='I' || item_type =='P')
	//alert("item_type"+item_type+"*******");
	if (item_type =='I'){
	var  param="func_mode=pick_list_item_select&locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	}else if(item_type =='P'){
	var  param="func_mode=pick_list_package_select&locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	//alert("retVal"+retVal);
	}

		qty_avail =retVal;	
		if (item_type =='I' || item_type =='P')
		{
		if(ot_Param == 'Y' || ot_Param=='y')
			{
				//formObj.quantity_avail.value =qty_avail;
				//alert("qty_avail in quantityavail_onLoad"+qty_avail);
				return qty_avail;
			}
		}
		return qty_avail;
	}
//Added by MuthuN for CRF-268 Instrument & Package Ends

var code =new String();
function sendparams(index){
	var formObj = parent.frames[1].document.forms[0];
	var formObj_flt = parent.parent.frames[0].frames[1].document.forms[0];
	var ot_Param = document.forms[0].ot_Param.value;
	var rows = parent.frames[1].rows[index];
	var item_type=rows.item_type;
	var item_desc = rows.item_desc;
	var item_id = rows.item_id;
	var quantity= rows.no_units;
	var exist_db=rows.exist_db;
	var st_interface_flag=parent.frames[1].document.forms[0].st_interface_flag.value;
	var cssd_status =rows.cssd_status

//Added by MuthuN for CRF-268 for instrument Starts
//if (item_type == 'I' || item_type == 'P'){	
if (item_type == 'I'){	
	if(ot_Param == 'Y' || ot_Param=='y'){		
	var locale=formObj.locale.value;
	var surgeryDate=formObj.surgery_date.value;
	var facilityid = formObj.facilityid.value;
	var cssd_store_req = formObj_flt.cssd_store_req.value;
	var cssd_store_ret = formObj_flt.cssd_store_ret.value;		
	var  param="func_mode=pick_list_item_select&locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
    var quant_avail= retVal;
	}
}
//Added by MuthuN for CRF-268 for instrument Ends
//Added by MuthuN for CRF-268 for package Starts
if (item_type == 'P'){	
	if(ot_Param == 'Y' || ot_Param=='y'){		
	var locale=formObj.locale.value;
	var surgeryDate=formObj.surgery_date.value;
	var facilityid = formObj.facilityid.value;
	var cssd_store_req = formObj_flt.cssd_store_req.value;
	var cssd_store_ret = formObj_flt.cssd_store_ret.value;		
	var  param="func_mode=pick_list_package_select&locale="+locale+"&facilityid="+facilityid+"&surgeryDate="+surgeryDate+"&item_id="+item_id+"&cssd_store_req="+cssd_store_req+"&cssd_store_ret="+cssd_store_ret;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
    var quant_avail= retVal;
	}
}
//Added by MuthuN for CRF-268 for package Ends

	var requeststore= rows.requeststore;
	var issuing_store= rows.issuing_store;
	var reserve_qty="";
	reserve_qty=	rows.reserve_qty;
	var request_qty="";
	request_qty=	rows.request_qty;
	var qoh_qty="";
	qoh_qty=	rows.QOHqty_qty;
	var recId = index;

//Added by MuthuN for CRF-268 Starts
	if (item_type == 'I' || item_type == 'P')
	{	
		if(ot_Param == 'Y' || ot_Param=='y'){
		var str = item_type+'::'+item_id+'::'+item_desc+'::'+quantity+'::'+recId+'::'+requeststore+'::'+issuing_store+'::'+reserve_qty+'::'+request_qty+'::'+qoh_qty+'::'+exist_db+'::'+quant_avail+'::'+cssd_status;
		}
else{	
		var str = item_type+'::'+item_id+'::'+item_desc+'::'+quantity+'::'+recId+'::'+requeststore+'::'+issuing_store+'::'+reserve_qty+'::'+request_qty+'::'+qoh_qty+'::'+exist_db;//Old Str
	}
	}else{	
		var str = item_type+'::'+item_id+'::'+item_desc+'::'+quantity+'::'+recId+'::'+requeststore+'::'+issuing_store+'::'+reserve_qty+'::'+request_qty+'::'+qoh_qty+'::'+exist_db;//Old Str
	}
	//Added by MuthuN for CRF-268 Ends

	var frmObj = parent.frames[1];
	frmObj.document.forms[0].mode.value='U';
	if(parent.frames[1].document.forms[0].from_val.value =="PI" && st_interface_flag=="Y")
	{
	parent.frames[1].document.forms[0].QOHqty_qty.disabled=false;
	parent.frames[1].document.forms[0].requeststore.disabled=false;
	}
	parent.frames[1].document.forms[0].cancel.disabled=false;
	frmObj.splitString(str);
}

function chkBoxChecked(obj,index){
	 var rows = parent.frames[1].rows[index];      
	 if(obj.checked==true)	
	{
		 rows.finalize_yn="Y";
	} else
	{
			rows.finalize_yn="N";
			if(parent.frames[1].document.forms[0].select.checked==true)
			{
				parent.frames[1].document.forms[0].select.checked=false;
			}
	}

 }

function checkBoxCheckedAll(dat){
	var rows = parent.frames[0].rows;
	for(var len=0;len<rows.length;len++){
	 if(rows[len]!=null)
       rows[len].finalize_yn=dat;
	}
}



async function callPatSearch(){
//	alert("ca");
	var formObj = document.forms[0];
	var patient_id=formObj.patientid;
	var patient_name = formObj.patientname;
	if(formObj.Ot_param.value=="Y"){
	formObj.source_code.value='';//Added by lakshmi against CRF-0146 05/01/2012
	formObj.source_desc.value='';//Added by lakshmi against CRF-0146 05/01/2012
	formObj.source_type.value='W';//Added by lakshmi against CRF-0146 05/01/2012
	}
	var return_value =	"";
	return_value	=	(patient_id.value.length>0)?patient_id.value:await PatientSearch();
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
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];

	}
}


function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patientid.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientname.value="";
	
}

function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}

function select_request_store(obj)
{

var item_id=document.forms[0].item_id.value;
var store=obj.value;
var store_arr=store.split("|");
var store_code=store_arr[0];
var store_desc=store_arr[1];


	if(item_id !="" && store_code !="")
	{
	var frmObj=document.forms[0];
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+item_id+"&store_code="+store_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	
	if(retVal=="false")
	{
		document.forms[0].QOHqty_qty.value="";
		document.forms[0].reserve_qty.disabled=true;

	}else if(retVal=="false1")
		{
			alert(getMessage("APP-OT0143","OT"));
			obj.value="";
			document.forms[0].item_id.value="";
			
		frmObj.reserve_qty.value='';
		frmObj.request_qty.value='';
		frmObj.QOHqty_qty.value='';
		frmObj.requeststore.selectedIndex=0;
		frmObj.issuing_store.selectedIndex=0;

		}else
	{
	document.forms[0].QOHqty_qty.value=retVal;
	document.forms[0].reserve_qty.disabled=false;

	}
	}
}


function enablestore(obj)
{
	if(document.forms[0].from_val.value =="PI" &&   document.forms[0].st_interface_flag.value =="Y")
	{


		var item_id=document.forms[0].item_id.value;
		var store=document.forms[0].requeststore.value;
		var store_arr=store.split("|");
		var store_code=store_arr[0];
		var store_desc=store_arr[1];

		var frmObj=document.forms[0];

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+item_id+"&store_code="+store_code,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText); 
		if(retVal=="false")
		{
			document.forms[0].QOHqty_qty.value="";
			document.forms[0].reserve_qty.disabled=true;

		}else if(retVal=="false1")
		{
			alert(getMessage("APP-OT0143","OT"));
			obj.value="";
			document.forms[0].item_id.value="";
			
		frmObj.reserve_qty.value='';
		frmObj.request_qty.value='';
		frmObj.QOHqty_qty.value='';
	//	frmObj.requeststore.selectedIndex=0;
	//	frmObj.issuing_store.selectedIndex=0;

		}else
		{
		document.forms[0].QOHqty_qty.value=retVal;
		document.forms[0].reserve_qty.disabled=false;

		}
	}
}
function select_issue_store(obj)
{
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function chknum(obj)
{
	var quantity=obj.value;
	if(obj.value !="")
	{
	if(quantity<1)
		{
	  alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
	  obj.select();
	  obj.value="";
		}
	}
}

function loaddefaultcodes()
{
if(parent.frames[1].document.forms[0].from_val.value =="PI")
	{
	var frmObj = document.forms[0];
if(frmObj.st_interface_flag.value !="N")
		{
	var oper_room_code=parent.frames[1].document.forms[0].OperRoomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklistdefaultreqvalue&oper_room_code="+oper_room_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	frmObj.requeststore.value=retVal;

	var oper_room_code=parent.frames[1].document.forms[0].OperRoomCode.value
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=picklistdefaultissuvalue&oper_room_code="+oper_room_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	frmObj.issuing_store.value=retVal;
		}

	}
}

//Added by lakshmi against CRF-0146 starts here
function getLongNameRefSrc(){
	var formObj=document.forms[0];
	var ref_src_id=formObj.HLongRefSrcId.value;
	var strSourceDesc=formObj.source_desc.value;
	var strSrcTypeTemp=formObj.source_type.value;
	var locale=formObj.locale.value;
	var param="func_mode=ref_long_name&locale="+locale+"&ref_src_id="+ref_src_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal!="null"  && strSrcTypeTemp=="E" && strSourceDesc!=""){
		document.getElementById("more_img").style.visibility = 'visible';
	}else{
		document.getElementById("more_img").style.visibility = 'hidden';
	}
	return retVal;
}

function searchSourceTypeSelect(obj){
	var formObj=document.forms[0];
	var patient_class=formObj.source_type.value;
	if(patient_class=="E"){
		formObj.patientid.value ='';//Added by lakshmi against CRF-0146 05/01/2012
		formObj.patientname.value='';//Added by lakshmi against CRF-0146 05/01/2012
		searchsourcetypeReferal(obj);
	}else{
		formObj.patientid.value ='';//Added by lakshmi against CRF-0146 05/01/2012
		formObj.patientname.value='';//Added by lakshmi against CRF-0146 05/01/2012
		searchsourcetype(obj);	
	}
}

function callchangeMoreIcon(){
	var formObj=document.forms[0];
	var Source_code=formObj.source_code.value;
	formObj.source_code.value='';
	formObj.HLongRefSrcId.value='';
	if(Source_code==""){
		document.getElementById("more_img").style.visibility = 'hidden';
	} 
}

function searchsourcetype(source_type){
	var formObj=document.forms[0];	
	var locale=formObj.locale.value;
	var title="";
	var sql="";
	if(formObj.source_type.value=='W'){
		title=getLabel("Common.nursingUnit.label","common");
		sql="SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+formObj.facilityId.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;				
	}else if(formObj.source_type.value=='C'){
		title = getLabel("Common.clinic.label","common");
		sql="SELECT LONG_DESC DESCRIPTION, CLINIC_CODE CODE FROM  OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+formObj.facilityId.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
	}else if(formObj.source_type.value=='E'){
		title= getLabel("Common.referral.label","common");
		sql="SELECT LONG_DESC  DESCRIPTION, REFERRAL_CODE  CODE FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(REFERRAL_CODE) like upper(?)  order by 1" ;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+" "+getLabel("Common.SourceType.label","Common")+" "+msgArray[1]);
		 return false;
	}
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = formObj.source_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = CommonLookup(title, argumentArray );
	if( (returnedValues != null) && (returnedValues != "") )  {
		//obj.value = returnedValues[1];
		formObj.source_code.value=returnedValues[0];
		formObj.source_desc.value=returnedValues[1];
		formObj.HLongRefSrcId.value=returnedValues[0];
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.source_desc.value="";
		formObj.source_code.value="";
	}
}



function searchsourcetypeReferal(obj){
	var formObj=document.forms[0];
	var column_sizes = escape("60%,20%,10%");        
	var locale = formObj.locale.value;
	var surg_type_desc=obj.value
	var tit = getLabel('Common.code.label','Common')+','+getLabel('Common.description.label','Common')+','+getLabel('Common.longname.label','Common'); 
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT REFERRAL_CODE CODE, LONG_DESC DESCRIPTION, LONG_NAME LONG_NAMES FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	var title=getLabel("Common.referral.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		formObj.HLongRefSrcId.value=arr[0];
		formObj.source_code.value=arr[0];
		formObj.source_desc.value=arr[1];
		if(arr[2]==""){
			document.getElementById("more_img").style.visibility = 'hidden';
		}else{
			document.getElementById("more_img").style.visibility = 'visible';
		}
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.source_code.value="";
		formObj.source_desc.value="";
	}
}

function searchSourceTypeSelectFilter(obj){
	var formObj=document.forms[0];
	var patient_class=formObj.source_type.value;
	if(patient_class=="E"){
		formObj.patientid.value ='';//Added by lakshmi against CRF-0146 05/01/2012
		searchsourcetypeReferal(obj);
	}else{
		formObj.patientid.value ='';//Added by lakshmi against CRF-0146 05/01/2012
		searchsourcetype(obj);	
	}
}

function SearchPickListFilter(){
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	var error="";
	var msg = getMessage("ANY_ONE_CRITERIA",'Common');
	var msgArray = msg.split("&");
	//if(frmObj.room_code.value ==''|| frmObj.room_code.value==null)//Commented on 1/18/2011 by Anitha (25897)
	//if(frmObj.patientid.value ==''&& frmObj.source_type.value==''){
	if(frmObj.patientid.value ==''&& frmObj.source_code.value==''){
	 error = msgArray[0]+" "+msgArray[1]+"\n";	
	   if(error.length > 0){
		alert (error);
		return false;
	   }
	}
	else{
		var param="facility_id="+frmObj.facilityId.value+"&patient_id="+frmObj.patientid.value+"&source_type="+frmObj.source_type.value+"&source_code="+frmObj.source_code.value;
		var url =  "../../eOT/jsp/PickListReviewDtl.jsp?"+param;
        parent.frames[2].location.href=url;
	  }
	 
}

function ClearFilter(){
	var frmObj1=document.forms[0];
	frmObj1.patientid.value='';
	frmObj1.source_type.value='W';
	frmObj1.source_code.value='';
	frmObj1.source_desc.value='';
	var param="facility_id="+frmObj1.facilityId.value+"&patient_id="+frmObj1.patientid.value+"&source_type="+frmObj1.source_type.value+"&source_code="+frmObj1.source_code.value;
	parent.frames[2].location.href="../../eOT/jsp/PickListReviewDtl.jsp?"+param;
}

function callPatSearchFilter(){
	var formObj = document.forms[0];
	var patient_id=formObj.patientid;
	formObj.source_code.value='';//Added by lakshmi against CRF-0146 05/01/2012
	formObj.source_desc.value='';//Added by lakshmi against CRF-0146 05/01/2012
	formObj.source_type.value='W';//Added by lakshmi against CRF-0146 05/01/2012
	var return_value =	"";
	return_value	=	(patient_id.value.length>0)?patient_id.value:PatientSearch();
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
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
	}
}
//Added by lakshmi against CRF-0146 ends here
