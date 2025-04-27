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

var count=0;

function reset(){
	var formObj = window.frames[1].document.forms[0];
	formObj.reset();
	commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_ANAESTHESIA_HISTORY&function_name=Anesthesia History&function_type=F&access=NNNNY"
	window.frames[2].location.href="../../eCommon/html/blank.html";
 }

function autoCall(patient_id,patient_name){
	//top.commontoolbarFrame.document.forms[0].reset.disabled=true;
	parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
	//alert(top.commontoolbarFrame.document.forms[0].reset.name);
	var formObj = document.forms[0];
	formObj.patient_id.value = patient_id;
	formObj.patient_id.disabled=true;
	formObj.patient_name.value=patient_name;
	formObj.clear.disabled=true;
	callSearch();
}

/*  function callPatientSearch(){
	var formObj = document.forms[0];
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var column_sizes = escape("9%,25%");               
	var locale=formObj.locale.value
	var column_descriptions = getLabel('Common.patientId.label','common')+','+getLabel('Common.PatientName.label','Common');
	column_descriptions = encodeURIComponent(column_descriptions);
	
	//var column_descriptions = escape("PatientId","PatientName");  
	
	//var sql=escape("SELECT PATIENT_ID ID,SHORT_NAME NAME FROM MP_PATIENT_MAST WHERE NVL(STATUS,'E') = 'E'");
	// Modified bt Rajesh for displaying name in local language.
	var sql=escape("SELECT PATIENT_ID ID,decode ('"+locale+"','en',SHORT_NAME, NVL(SHORT_NAME_LOC_LANG,SHORT_NAME)) NAME FROM MP_PATIENT_MAST WHERE NVL(STATUS,'E') = 'E'");
	
	var title=encodeURIComponent(getLabel("Common.patient.label","Common"));
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+document.forms[0].patient_id.value;
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	if(retVal!=null){
		var arr = retVal.split('::');
		document.forms[0].patient_id.value=arr[0];
		document.forms[0].patient_name.value=arr[1];
	}else{
		document.forms[0].patient_id.value="";
		document.forms[0].patient_name.value="";
	}
}
*/
async function callPatSearch(){
	//alert("entered callPatSearch()");
	var formObj = document.forms[0];
	var patient_id=formObj.patient_id;
	var patient_name = formObj.patient_name;
	var date_of_birth = formObj.date_of_birth;
/*	var sex	= formObj.sex;
	var male=getLabel("Common.male.label","Common");
	var female=getLabel("Common.female.label","Common");
	var unknown=getLabel("Common.unknown.label","Common");
*/	
	var return_value =	"";
	return_value	=	(patient_id.value.length>0)?patient_id.value:await PatientSearch();
	
	//alert("return_value : "+return_value);
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
		//	date_of_birth.value="";
		//	sex.value = ""; 
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			//patient name is coming with "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  at the beginning.
			const toRemove = "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  ";
			const regex = new RegExp("^" + toRemove);
		  patient_name.value = patient_name.value.replace(regex, "");
		//alert("if : patient name :"+patient_name.value+"\n patient id : "+return_value);
		//	date_of_birth.value 	= retVal_arr[1];
		/*	if(retVal_arr[2]=="MALE")
				formObj.sex.value=male ;
			else if(retVal_arr[2]=="FEMALE")
				formObj.sex.value=female;
			else
				formObj.sex.value=unknown;*/
	}
}

function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}

function callNoRecords(){
	var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");
	//var msg = "APP-002415 Query caused no records to be retrieved";
	alert(msg);
}


function callNoNotes(str){
	var msg = "";
	if(str=="PRE"){
		var msg_1 = getMessage("APP-OT0088","OT");
		var msgArray = msg_1.split("#");
		msg = msgArray[0]+(getLabel("eOT.PreAnaesthesiaNotes.Label","OT"))+(msgArray[1]);	
	 }else if(str=="INTRA"){
		var msg_1 = getMessage("APP-OT0088","OT");
		var msgArray = msg_1.split("#");
		msg = msgArray[0]+(getLabel("eOT.IntraAnaesthesia.Label","OT"))+(msgArray[1]);
	 }else if(str=="POST"){
		var msg_1 = getMessage("APP-OT0088","OT");
		var msgArray = msg_1.split("#");
		msg = msgArray[0]+(getLabel("eOT.PostAnaesthesiaNotes.Label","OT"))+(msgArray[1]);
	}
	//top.messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num="+msg;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?&err_num="+msg;
}
async function callAnaesthesiaNotes(facility_id,anaesthesia_srl_no,accession_num,patient_id,patient_name){
	var formObj = document.forms[0];
	var source_order_id=formObj.src_order_id.value;
	var params = "facility_id="+facility_id+"&anaesthesia_srl_no="+anaesthesia_srl_no+"&accession_num="+accession_num+"&patient_id="+patient_id+"&patient_name="+encodeURIComponent(patient_name)+"&source_order_id="+source_order_id;
	var url = "../../eOT/jsp/AT_AnaesthesiaHistoryNotesFrames.jsp?"+params;
	var retVal="";
	//var dialogHeight = "100";
	//var dialogWidth  = "100";
	//var dialogTop    = "0";
	var dialogHeight = "500px";
	var dialogWidth  = "700px";
	var dialogTop    = "0px";
	var dialogLeft   = "0px";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no;scrolling=no" ;
	var arguments    = "" ;
	retVal 	   = await parent.window.showModalDialog(url, arguments, features);
	 
}

async function callAnaesthesiaDetails(facility_id,anaesthesia_srl_no,accession_num,patient_id,patient_name,oper_desc,source_order_id){
	var params = "facility_id="+facility_id+"&anaesthesia_srl_no="+anaesthesia_srl_no+"&accession_num="+accession_num+"&patient_id="+patient_id+"&patient_name="+encodeURIComponent(patient_name)+"&oper_desc="+oper_desc+"&source_order_id="+source_order_id;
	var url = "../../eOT/jsp/AT_AnaesthesiaHistoryFrames.jsp?"+params;
	//alert(url);
	var retVal="";
	var dialogHeight = "594px";
	var dialogWidth  = "700px";
	var dialogTop    = "0px";
	var dialogLeft   = "0px";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ ";status=no;help=no;scroll:no" ;
	var arguments    = "" ;
	retVal 	   = await parent.window.showModalDialog(url, arguments, features);
}


function  displayToolTip(facility_id,patient_id,patient_name,sex,anaesthesia_srl_no,called_from,surgeon,anesthetist_name,orderctlHDR,imgObj){
	var menu_id_list = "";
	var menu_name_list	= "";
	var PatientDemographics =getLabel("eOT.PatientDemographics.Label","OT");
	var PatientHistory =getLabel("Common.PatientHistory.label","Common");
	var SurgeryHistory =getLabel("eOT.SurgeryHistory.Label","OT");
	
	//alert(called_from)
	/*if(called_from=="MAIN_MENU"){
		menu_id_list		= new Array("1","2");
		menu_name_list	= new Array("Patient Demographics","Patient History");
	}else{
		menu_id_list		= new Array("1","2","3");
		menu_name_list	= new Array("Patient Demographics","Patient History","Surgery History");
	}*/
	menu_id_list		= new Array("1","2","3");	
	
	menu_name_list	= new Array(PatientDemographics,PatientHistory,SurgeryHistory);
	//var param=facility_id+"::"+patient_id+"::"+patient_name+"::"+sex+"::"+anesthesia_srl_no+"::"+proc_module_id;
	var param=facility_id+"::"+patient_id+"::"+called_from;
		
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat="<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var jj=0; jj<menu_name_list.length; jj++ )
	{
		var id_colval		= menu_id_list[jj];
		var id_name_colval  = menu_name_list[jj];
		if(id_colval!="")
		{
			tab_dat+="<tr>";
			tab_dat+="<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callMenuFunctions('"+id_colval+"','"+param+"');\")>"+id_name_colval + "</a> </td>"
			tab_dat+="</tr> ";
		}
	}
	tab_dat+="</table>";	
	//alert(tab_dat);
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow(orderctlHDR);
	//resizeWindow();
}


function hideToolTip(){
  document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

function checkEncIdPatClass(){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var facility_id=formObj.facility_id.value;
	var src_order_id=formObj.source_order_id.value;
	var sql="";
	if(oper_num!=""){
		sql="select encounter_id,patient_class from OT_POST_OPER_HDR where operating_facility_id='"+facility_id+"' and oper_num='"+oper_num+"' ";
	}else{
		sql="select encounter_id,patient_class from OT_BOOKING_HDR where operating_facility_id='"+facility_id+"' and order_id='"+src_order_id+"' ";
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getEncIdPatClass&oper_num="+oper_num+"&facility_id="+facility_id+"&sql="+sql;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	return retVal;
}

async function callMenuFunctions(obj,str){
	var arr=new Array();
	//alert(parent.parent.frames[1].name);
	var count = parent.parent.frames[1].count;
	var encId_patClass=checkEncIdPatClass();
	var split_str=encId_patClass.split("&&");
	//alert(count);
	 arr=str.split("::");
	 //alert(arr+"--"+count);
	var dialogHeight 		= "100vh";
	var dialogWidth  		= "100vw";
	var dialogTop   		= "10";
	var dialogLeft   		= "50";
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	hideToolTip();
	
	if(obj=="1"){
		var	param="facility_id="+arr[0]+"&Patient_ID="+arr[1];
		retVal=await parent.window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}

	if(obj=="2"){
		parent.parent.frames[1].count =(arr[2]=="OT_SLATE"||arr[2]=="REC_ANES")?++count:count=1;
		//alert(count);
		var HTML = "<html>";
		if(count==1)
			HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
		else
		
		HTML += "<form name='historyForm' id='historyForm' action='../eCA/jsp/OpenChartWrapper.jsp'>";
		HTML += "<input type='text' name='from_service_yn' id='from_service_yn' value= 'Y'>";
		HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
		HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +arr[1]+ "'>"; 
		HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '" + split_str[0]+ "'>";
		HTML += "<input type='text' name='patient_class' id='patient_class' value= '" + split_str[1]+ "'>";
		HTML += "</form>"
		HTML += "</html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
		parent.parent.messageFrame.document.historyForm.submit();
	}
	if(obj=="3"){
		var param="called_from=OPER_REG&patient_id="+arr[1]+"&function_name=Surgery History&home_required_yn=N"; 
		var	url= "../../eOT/jsp/SurgeryHistory.jsp?"+param;
		var dialogHeight = "90vh" ;
		var dialogWidth  = "70vw";
		var dialogTop    = "200";
		var dialogLeft   = "100";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;
		hideToolTip();
		retVal=await parent.window.showModalDialog(url,arguments,features);
		
	}

}

function callSearch(){

	var formObj = document.forms[0];
	var locale=formObj.locale.value;
	var male=getLabel('Common.male.label','Common');
	var female=getLabel('Common.female.label','Common');
	var unknown=getLabel('Common.unknown.label','Common');
	var patient_id = formObj.patient_id.value;
	var facility_id = formObj.facility_id.value;
	var surgeon_code = formObj.surgeon_desc.value;
	var srgn_code=formObj.surgeon_code.value;
	var anaesthetist_code = formObj.anaesthetist_code.value;
	var speciality_code = formObj.sptly_code.value;
	//var oper_code = formObj.oper_code.value;
	//var from_date = formObj.from_date.value;
	//var to_date =   formObj.to_date.value;
	var from_date = dateUtils(formObj.from_date.value,locale); 
	var to_date = dateUtils(formObj.to_date.value,locale); 
	
	var called_from = formObj.called_from.value;	
	
	if(compareDatesAH(from_date,to_date)){

	//Modifed by rajesh for SCF-1744 on 24th Apr 2008
	//var sql = "SELECT STATUS,PATIENT_ID, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1	,DECODE(SEX,'M','Male','F','Female','U','Unknown'),ANAESTHESIA_SERIAL_NUM,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') REQUEST_DATE,SPECIALITY_DESC,ORDER_CATALOG_DESC,ACCESSION_NUM,SURGEON_NAME,ANAESTHETIST_NAME FROM AT_PRE_INTRA_OPER_VW A WHERE OPERATING_FACILITY_ID='"+facility_id+"'";

	//Modified against MMS-QH-CRF-0199
	var sql = "SELECT SOURCE_ORDER_ID,STATUS,PATIENT_ID, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1	,DECODE(SEX,'M','"+male+"','F','"+female+"','U','"+unknown+"'),ANAESTHESIA_SERIAL_NUM,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') REQUEST_DATE,SPECIALITY_DESC,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','ORDER_CATALOG_CODE',ORDER_CATALOG_CODE) ORDER_CATALOG_DESC,ACCESSION_NUM,SURGEON_NAME,ANAESTHETIST_NAME FROM AT_PRE_INTRA_OPER_VW A WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND A.LANGUAGE_ID='"+locale+"' ";
	var whereclause ="";

	if(to_date.length>0 && from_date.length>0){
		whereclause+=" AND TRUNC(REQUEST_DATE) BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY') AND TO_DATE('"+to_date+"','DD/MM/YYYY')";
	}else if(from_date.length>0){
			whereclause+=" AND TRUNC(REQUEST_DATE)>=TO_DATE('"+from_date+"','DD/MM/YYYY')";
	}
	if(patient_id.length>0){
		whereclause+=" AND PATIENT_ID='"+patient_id+"'";
	}
	if(surgeon_code.length>0){
		whereclause+=" AND SURGEON_CODE='"+srgn_code+"'";
	}
	if(anaesthetist_code.length>0){
		whereclause+=" AND ((ANAESTHETIST_CODE='"+anaesthetist_code+"') OR ('"+anaesthetist_code+"' IN (SELECT PRACTITIONER_ID FROM AT_PERSONNEL WHERE PRACT_TYPE IN ('MA','AA') AND ANAESTHESIA_SERIAL_NUM = A.ANAESTHESIA_SERIAL_NUM)) OR ('"+anaesthetist_code+"' IN (SELECT PRACTITIONER_ID FROM OT_POST_OPER_PERSONNEL WHERE ROLE_TYPE IN ('MA','AA') AND OPER_NUM = A.ACCESSION_NUM)) OR ('"+anaesthetist_code+"' IN (SELECT ANESTHETIST_CODE FROM OT_POST_OPER_HDR WHERE OPER_NUM = A.ACCESSION_NUM)))";
	}
	if(speciality_code.length>0){
		whereclause+=" AND  SPECIALITY_CODE='"+speciality_code+"'";
	}

	/*if(to_date.length>0 && from_date.length>0){
		whereclause+=" AND TRUNC(REQUEST_DATE) BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY') AND TO_DATE('"+to_date+"','DD/MM/YYYY')";
	}*/
	sql+=whereclause;
	var params = "&facility_id="+facility_id+"&patient_id="+patient_id+"&surgeon_code="+surgeon_code+"&speciality_code="+speciality_code+"&anaesthetist_code="+anaesthetist_code+"&from_date="+from_date+"&to_date="+to_date+"&called_from="+called_from;
	sql = encodeURIComponent(sql);
	sql = sql.replace(/\(/g,"%28").replace(/\)/g,"%29").replace(/\'/g,"%27");
	parent.ResultFrame.document.location.href="../../eOT/jsp/AT_AnaesthesiaHistoryResultFrames.jsp?"+"sql="+sql+params;
	}
}

//This function only compare DD/MM/YYYY Format only and not any other format
function compareDatesAH(from_date,to_date){
	if(to_date!=""){
		var from_date=from_date.split("/").reverse().join("/");
		var to_date=to_date.split("/").reverse().join("/");
		if(!from_date){//alert("From Date Cannot be blank...")
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var FromDate=getLabel("Common.fromdate.label","Common");
			alert(msgArray[0]+FromDate+(msgArray[1]));
			return false;
		}
		var flag = Date.parse(to_date)>=Date.parse(from_date);
		if(!flag) {//alert("From Date Cannot be Greater than To Date");
			//alert(getMessage("FROM_DATE_GREATER_TO_DATE","OT"));
			//alert(getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT"));
			var FromDate=getLabel("Common.fromdate.label","Common");
			var ToDate=getLabel("Common.todate.label","Common");
			var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT").replace("#",FromDate).replace("#",ToDate);
			var msgArray = msg.split("#");
			alert(msg);
		}
		return flag;
	}else
		return true;
}

function resizeWindow1(){
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer").style.posLeft= x
	document.getElementById("tooltiplayer").style.posTop = y
	document.getElementById("tooltiplayer").style.visibility='visible'
}

function callMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'OTMENU';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}


async function LookUpSearch(code,desc,obj){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var function_name = obj.name;
	var argumentArray = new Array();
	//alert(function_name);
	switch(function_name){
		case 'lkup_speciality': 
				//var	tit="Search Specialty";					
				var	tit=getLabel("Common.speciality.label","Common");
				var	sql="SELECT A.SHORT_DESC description, A.SPECIALITY_CODE code FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";
				break;
		case 'lkup_surgeon': 
			//var tit="Search Surgeon";
			var tit=getLabel("Common.Surgeon.label","Common");

//			var sql="SELECT PRACTITIONER_NAME description,PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('MD','SG')  and upper(PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 2";

			//Qry altered by rajesh for including role_type changes on 09/07/08
			var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
				break;
		case 'lkup_anaesthetist': 
				//var tit="Search Anaesthetist";
				var tit= getLabel("Common.Anaesthetist.label","Common");
				//var sql="SELECT PRACTITIONER_NAME description,PRACTITIONER_ID code  FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ('AN')  and upper(PRACTITIONER_NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) order by 1";
//Qry altered by rajesh for including role_type changes on 09/07/08
				var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='MA') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
				break;
	}
	argumentArray[0] = sql;
	argumentArray[1] = new Array();
	argumentArray[2] = new Array() ;
	argumentArray[3] = new Array() ;
	argumentArray[4] = "2,1";
	argumentArray[5] = desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	var retVal = await CommonLookup(tit, argumentArray );
	if(retVal!=null && retVal!="" ){
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		code.value= arr[0];
		desc.value=arr[1];
	}else{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		code.value= "";
		desc.value="";
	}
}


function clearForm(){
	var formObj = document.forms[0];
	formObj.reset();
}

function isValidDate(obj){
	if(obj.value!=""){
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length!=3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is DD/MM/YYYY.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);	
	}
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	// obj.focus();
	// obj.select();
	return null;

}

function trimToSize(arr){
	//alert("b4 Trim"+arr.length)
	for(j in arr){
	 if(arr[j]=="") arr.splice(j,1);
	}
	//alert("aftr Trim"+arr.length);
	return arr;
}

function  reasonToolTip(indx){
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj.reason"+indx+".value");
	var arr=trimToSize(arrMsg.split("::"));
	//arr = trimToSize(arr);
	var tab_data="<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_data+="<tr>"
	tab_data+="<td class='columnHeader'>"+arr[0]+"</td>"
	tab_data+="</tr>";
	for(var j=1;j<arr.length;j++){
		tab_data+="<tr>";
		//tab_data+="<td class='label'><B>"+j+"."+arr[j]+"</B></td>";
		tab_data+="<td class='label'><B>"+arr[j]+"</B></td>";
		tab_data+="</tr>";
	}
	tab_data+="</table>";	
	//Commented against MMS-QH-CRF-0199
    /*var obj=document.getElementById("tooltiplayer");
	obj.innerHTML = tab_data;
	resizeWindow1();*/
	return tab_data;//Added against MMS-QH-CRF-0199
}

function changeTab(objStr){
	selectTab(objStr);
	var formObj=document.forms[0];
	var param = formObj.param.value;
	
	var tab_index = new Array();
	tab_index['PRE_NOTES']='1';
	tab_index['INTRA_NOTES']='2';
	tab_index['POST_NOTES']='3';
	var title_arr=new Array();
	title_arr['1']=getLabel("eOT.PreAnaesthesiaNotes.Label","OT");
	title_arr['2']=getLabel("eOT.IntraAnaesthesiaNotes.Label","OT");
	title_arr['3']=getLabel("eOT.PostAnaesthesiaNotes.Label","OT");
	var key = tab_index[objStr];
	var title = title_arr[key];

	

	var spanKey="SP"+key;
	var hrefKey="HF"+key;
	var param = formObj.param.value;
	
	var tab_id=(key==1)?"PRE":(key==2)?"INTRA":"POST";
	var param = formObj.param.value+"&tab_id="+tab_id;
/*
	var hrefObj = document.getElementsByTagName('a');
for(var i=0;i<hrefObj.length;i++){
		document.getElementById(hrefObj[i].id).className="TABOFF";
	}

	var spanObj = document.getElementsByTagName('span');
	for(var i=0;i<spanObj.length;i++){
		document.getElementById(spanObj[i].id).className="TABOFF";
		
	}
	document.getElementById(spanKey).className="TABON";
	document.getElementById(hrefKey).className="TABON";*/

	parent.TitleFrame.location.href='../../eOT/jsp/AT_AnaesthesiaHdr.jsp?function_name='+title;
	parent.ResultFrame.location.href='../../eOT/jsp/AT_AnaesthesiaHistoryAllNotes.jsp?'+param;
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	 	
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

//Newly added for Amazon Changes......

function callMouseOver(obj)	{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}


// function resizeWindow(orderctlHDR)
// {
// 	var orderctlHDR1 = orderctlHDR.id;
// 	var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
// 	var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;		
	
// 	var wdth1 = getPos(orderctlHDR).x +wdth;
// 	var hght = getPos(orderctlHDR).y ;	

// 	bodwidth  = document.body.offsetWidth
// 	bodheight = document.body.offsetHeight

// 	var z = bodwidth- (event.x + wdth);	
	
// 	var x 	  = event.x;
// 	var y 	  = event.y;	

// 	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
// 	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

// 	if(x<bodwidth){
// 		x= wdth1;			
// 	}else{			
// 		x = getPos(orderctlHDR).x;
// 	}
// 	if(y<bodheight){			
// 		y = hght;
		
// 	}else
// 	{
// 		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
// 	}

// 	document.getElementById("tooltiplayer").style.posLeft= x;
// 	document.getElementById("tooltiplayer").style.posTop = y;
// 	document.getElementById("tooltiplayer").style.visibility='visible'
// }
function resizeWindow(orderctlHDR) {
    var tooltip = document.getElementById("tooltiplayer");
    var rect = orderctlHDR.getBoundingClientRect();
    
    var x = rect.left + window.scrollX + orderctlHDR.offsetWidth; // Position to the right of element
    var y = rect.top + window.scrollY; // Align top

    var bodyWidth = document.body.offsetWidth;
    var bodyHeight = document.body.offsetHeight;
    
    // Adjust if tooltip goes beyond window boundaries
    // if (x + tooltip.offsetWidth > bodyWidth) {
    //     x =tooltip.offsetWidth- rect.left + window.scrollX ; // Position to the left if overflow
    // }
    // if (y + tooltip.offsetHeight > bodyHeight) {
    //     y = tooltip.offsetHeight- rect.top + window.scrollY ;
	// 	console.log("entered if overflow : "+y); // Position above if overflow
    // }

    // Set position and make visible
    tooltip.style.left = x + "px";
    tooltip.style.top = y + "px";
    tooltip.style.visibility = "visible";
}

function callMouseOverOnTD(obj,imgObj){
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 eval(document.getElementById(prevObjID)).className = 'gridDataBlue';
			 eval(document.getElementById(prevImgObj)).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
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

/*function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);
	}
function dynamichide(m, e,row)
{
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
}

function isContained(m, e)
{
		alert(m,e)
		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
}

function delayhidemenu(row)
{
		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(eval("document.getElementById("orderctl")"+row))
			eval("document.getElementById("orderctl")"+row).className='gridDataBlue';
		if(eval("document.getElementById("imgArrow")"+row))
			eval("document.getElementById("imgArrow")"+row).src = "../../eCommon/images/inactiveArrow.gif";
}*/

function hidemenu()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
//Amazon Changes Ends Here....

function openDocWindow(accession_num,note_type) //Added Against ML-MMOH-CRF-1977.1
{
	window.open("../../eCA/jsp/RecClinicalNotesMultiFileListMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}

