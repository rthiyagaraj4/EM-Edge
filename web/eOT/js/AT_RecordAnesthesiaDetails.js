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

async function searchSurgeon3(obj)
{
var formObj = document.forms[0];
var locale = formObj.locale.value;
var facility_id = document.forms[0].facility_id.value;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1 ";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var surgeon = getLabel("Common.Surgeon.label","Common");
	returnedValues = await CommonLookup(surgeon, argumentArray);
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].surgeon_name.value = arr[1];
		document.forms[0].surgeon_code.value = arr[0];	
		}
	else
		{
			document.forms[0].surgeon_name.value = '';
			document.forms[0].surgeon_code.value = '';
			nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		//obj.value = returnedValues[1];
	} 
}

function callSurgeon()
{
	var facility_id = document.forms[0].facility_id.value;
	var column_sizes = escape("60%,40%");               
	var column_descriptions = getLabel('Common.name.label','Common')+','+getLabel('Common.code.label','Common');
	column_descriptions = encodeURIComponent(column_descriptions); 
	var sql=escape("SELECT SHORT_NAME  SHORT_NAME1,PHYSICIAN_ID PHYSICIAN_ID1 FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'X') <> 'S'");
	
//	var title='Surgeon';
	var  title = getLabel("Common.Surgeon.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].surgeon_name.value = arr[0];
			document.forms[0].surgeon_code.value = arr[1];	
		}
	else
		{
			document.forms[0].surgeon_name.value = '';
			document.forms[0].surgeon_code.value = '';
		}
}

async function searchSpeciality3(obj){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var specialiity_title = getLabel("Common.speciality.label","Common");
	returnedValues = await CommonLookup(specialiity_title,argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].speciality_desc.value = arr[1];
		document.forms[0].speciality_code.value = arr[0];	
		}
	else
		{
			document.forms[0].speciality_desc.value = '';
			document.forms[0].speciality_code.value ='';	
			nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];			

	} 
}

function callSpeciality()
{
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var column_sizes = escape("70%,30%");               	
	var  desc =getLabel("Common.description.label","Common");
	var  code = getLabel("Common.code.label","Common");
	var column_descriptions = escape(desc,code);  
	var sql=escape("SELECT SHORT_DESC SHORT_DESC1,A.SPECIALITY_CODE SPECIALITY_CODE1 FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  NVL(A.EFF_STATUS,'X') = 'E' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ");
	//var title='Speciality Search';
	
	var  title = getLabel("Common.speciality.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].speciality_desc.value = arr[0];
			document.forms[0].speciality_code.value = arr[1];	
		}
	else
		{
			document.forms[0].speciality_desc.value = '';
			document.forms[0].speciality_code.value ='';		
		}
}
function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}
function funClearAllPendingorder()
{
	var obj=document.forms[0];
	obj.patient_name.disabled=false;
	obj.surgery_date.value='';
	obj.surgeon_name.value='';
	obj.surgeon_code.value='';
	obj.speciality_desc.value='';
	obj.speciality_code.value=''; 
	obj.patient_id.value='';    
	obj.patient_name.value='';  
	parent.parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html?";
}

function funClearAll()
{
	var obj=document.forms[0];
	obj.patient_name.disabled=false;
	obj.surgery_date.value='';
	obj.surgery_date.value='';
	obj.surgeon_name.value='';
	obj.surgeon_code.value='';
	obj.speciality_desc.value='';
	obj.speciality_code.value=''; 
	obj.patient_id.value='';    
	obj.patient_name.value='';  
	parent.parent.frames[2].frames[2].location.href = "../../eCommon/html/blank.html?";
}

function reset()

{		
	var frame1=frames[1].name;	
 if(frame1!=null)
	{
	window.parent.parent.parent.frames[2].frames[2].location.reload();
	commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_RECORD_ANESTHESIA&function_name=Record Anaesthesia Details&function_type=F&access=YYNNY";
}
}

function callPatientSearch()
{
	parent.parent.dummy.location.href = '../../eCommon/html/blank.html';
	var return_value =           "";
    return_value       =          PatientSearch();
	if(return_value!=null && return_value!="undefined" && return_value!=""){
	document.RecordAnesthesiaDetailsForm.patient_id.value=return_value;
	var htmlVal = "<html><head></head><body>"
	htmlVal += "<form name='frm_temp' id='frm_temp' method='post' action='../../eOT/jsp/AT_AnaesthesiaDetailsDynamicVlaue.jsp' target='dummy'>"
	htmlVal += "<input type='hidden' name='patient_id' id='patient_id' value='"+return_value+"'>"
	htmlVal += "</form></body></html>"
	parent.parent.dummy.document.body.insertAdjacentHTML("afterBegin",htmlVal);
	parent.parent.dummy.document.frm_temp.submit();

	}else{
	patient_id.value='';
	}
}

function anesthesiaPatientDetails()
{
	var formObj=document.RecordAnesthesiaDetailsForm;
	var locale=formObj.locale.value;
	var surgery_date=trimString(dateUtils(formObj.surgery_date.value,locale));
	var order_date=trimString(dateUtils(formObj.order_date.value,locale));
	
	//AAKH CRF-00069
	var surgery_date2=trimString(dateUtils(formObj.surgery_date2.value,locale));
	var order_date2=trimString(dateUtils(formObj.order_date2.value,locale));
	//AAKH CRF-00069
	if(surgery_date=="" && surgery_date2!="")
	{		
		var error = getMessage("APP-OT0206","OT").replace("#", getLabel("eOT.SurgeryDateFrom.Label","OT"));
		alert(error);
		return false;
	}

	if(order_date=="" && order_date2!="")
	{
		var error = getMessage("APP-OT0206","OT").replace("#", getLabel("eOT.AnaesthesiaOrderedDateFrom.Label","OT"));
		alert(error);
		return false;
	}

	if(surgery_date=="" && order_date==""){
		alert(getMessage("APP-OT0123","OT"));
		return false;
	}
	//AAKH CRF-00069
	if(!dateCheck(surgery_date,surgery_date2,getLabel("eOT.SurgeryDateFrom.Label","OT"),getLabel("eOT.SurgeryDateTo.Label","OT"))) return;
	if(!dateCheck(order_date,order_date2,getLabel("eOT.AnaesthesiaOrderedDateFrom.Label","OT"),getLabel("eOT.AnaesthesiaOrderedDateTo.Label","OT"))) return;	
	//AAKH CRF-00069
	var facility_id=formObj.facility_id.value;
	var surgeon_name=trimString(formObj.surgeon_name.value);
	var surgeon_code=formObj.surgeon_code.value;
	var speciality_desc=trimString(formObj.speciality_desc.value);
	var speciality_code=trimString(formObj.speciality_code.value);
	var patient_id=trimString(formObj.patient_id.value);
	var param ="facility_id="+facility_id+"&surgery_date="+surgery_date+"&surgeon_name="+surgeon_name+"&surgeon_code="+surgeon_code+"&speciality_desc="+speciality_desc+"&speciality_code="+speciality_code+"&patient_id="+patient_id+"&order_date="+order_date+"&surgery_date2="+surgery_date2+"&order_date2="+order_date2;//AAKH CRF-00069
	parent.parent.at_tab_frame.record_anethesia_details_hdr_frame.location.href = "../../eOT/jsp/AT_AnaesthesiaPatientDetailsHdr.jsp?";
	parent.parent.at_tab_frame.record_anethesia_details_frame.location.href = "../../eOT/jsp/AT_AnaesthesiaPatientDetails.jsp?"+param;
	parent.parent.at_tab_frame.record_anethesia_colors_ind_frame.location.href = "../../eOT/jsp/AT_AnaesthesiaColorInd.jsp?";
}

function anesthesiaPendingOrders()
{
	var formObj=document.RecordAnesthesiaDetailsForm;
	var facility_id=formObj.facility_id.value;
	var locale=formObj.locale.value;
	//FD-GHL-CRF-0357
	var searchFlag = false;
	var surgeryDate = formObj.surgeryDate.value;
	var surgery_date = formObj.surgery_date.value;
	//AAKH CRF-0069
	var surgery_date2 = formObj.surgery_date2.value;
	var surgeryDate2 = formObj.surgeryDate2.value;
	//AAKH CRF-0069
	
	var patient_id = formObj.patient_id.value;
	var surgeon_name = formObj.surgeon_name.value;
	var speciality_desc = formObj.speciality_desc.value;
	if(surgeryDate != '' || surgery_date != '' || patient_id != '' || surgeon_name != '' || speciality_desc != '')
		searchFlag = true;
	//FD-GHL-CRF-0357
	//AAKH CRF-0069
	if(surgeryDate=="" && surgeryDate2!="")
	{
		
		var error = getMessage("APP-OT0206","OT").replace("#", getLabel("eOT.SurgeryDateFrom.Label","OT"));
		alert(error);

		return false;
	}

	if(surgery_date=="" && surgery_date2!="")
	{

		var error = getMessage("APP-OT0206","OT").replace("#", getLabel("eOT.AnaesthesiaOrderedDateFrom.Label","OT"));
		alert(error);

		return false;
	}
	if(!dateCheck(surgeryDate,surgeryDate2,getLabel("eOT.SurgeryDateFrom.Label","OT"),getLabel("eOT.SurgeryDateTo.Label","OT"))) return;
	if(!dateCheck(surgery_date,surgery_date2,getLabel("eOT.AnaesthesiaOrderedDateFrom.Label","OT"),getLabel("eOT.AnaesthesiaOrderedDateTo.Label","OT"))) return;
	//AAKH CRF-0069
	if(searchFlag)
	{
		var surgeon_name=trimString(formObj.surgeon_name.value);
		var surgeon_code=formObj.surgeon_code.value;
		var speciality_desc=trimString(formObj.speciality_desc.value);
		var speciality_code=formObj.speciality_code.value;
		var patient_id=trimString(formObj.patient_id.value);
		var surgery_date=trimString(dateUtils(formObj.surgery_date.value,locale)); //FD-GHL-CRF-0357
		var surgeryDate=trimString(formObj.surgeryDate.value);//FD-GHL-CRF-0357
		var param = "facility_id="+facility_id+"&surgeryDate="+surgeryDate+"&surgery_date="+surgery_date+"&surgeon_name="+surgeon_name+"&surgeon_code="+surgeon_code+"&speciality_desc="+speciality_desc+"&speciality_code="+speciality_code+"&patient_id="+patient_id+"&surgeryDate2="+surgeryDate2+"&surgery_date2="+surgery_date2;//AAKH CRF-0069

		parent.parent.at_tab_frame.record_anethesia_details_hdr_frame.location.href = "../../eOT/jsp/AT_AnaesthesiaPatientDetailsHdr.jsp?flag=pending_orders";
		parent.parent.at_tab_frame.record_anethesia_details_frame.location.href = "../../eOT/jsp/AT_AnaesthesiaPendingOrders.jsp?"+param;
	}
	else
	{
/*
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var patientid_value=getLabel("Common.patientId.label","common");
		var SurgeryDate_value=getLabel("eOT.SurgeryDate.Label","OT");
		alert(msgArray[0]+SurgeryDate_value+(msgArray[1]));
*/
		alert(getMessage("APP-OT0225","OT"));//FD-GHL-CRF-0357
	}
}

 function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

async function  displayToolTipAnaesDetails(facility_id,patient_id,patient_name,sex,anesthesia_srl_no,proc_module_id,date_of_birth,patient_class,encounter_id,order_id,accession_num,intraop_done_yn,orderctlHDR,imgObj)
{
	var param=facility_id+"::"+patient_id+"::"+patient_name+"::"+sex+"::"+anesthesia_srl_no+"::"+proc_module_id+"::"+date_of_birth+"::"+patient_class+"::"+encounter_id+"::"+order_id+"::"+accession_num;
	var PatientDemographics			=getLabel("eOT.PatientDemographics.Label","OT");
	var	PatientHistory				=getLabel("Common.PatientHistory.label","Common");
	var SurgeryHistory				=getLabel("eOT.SurgeryHistory.Label","OT");
	var RecordPostAnaesthesiaDetails = getLabel("eOT.RecordPostAnaesthesiaDetails.Label","OT");
	var AnaesthesiaHistory=	getLabel("eOT.AnaesthesiaHistory.Label","OT");
	var RecordIntraAnaesthesiaDetails = getLabel("eOT.RecordIntraAnaesthesiaDetails.Label","OT");
	var ReEvaluation				  = getLabel("eOT.ReEvaluation.Label","OT");
	var ViewPreAnaesthesiaEvaluationDetails= getLabel("eOT.ViewPreAnaesthesiaEvaluationDetails.Label","OT");
	if(intraop_done_yn=="Y"){
		var menu_id_list		= new Array("A1","A2","A3","A4","A5","A6","A7","A8");
		var	menu_name_list	= new Array(PatientDemographics,PatientHistory,SurgeryHistory,ViewPreAnaesthesiaEvaluationDetails,ReEvaluation,RecordIntraAnaesthesiaDetails,RecordPostAnaesthesiaDetails,AnaesthesiaHistory);
	}else if(intraop_done_yn=="N"){
		// Do not show "Record Post Anaesthesia" in the menu--- added by bshankar (SCR-3271)
		var menu_id_list		= new Array("A1","A2","A3","A4","A5","A6","A8");
		var	menu_name_list	= new Array(PatientDemographics,PatientHistory,SurgeryHistory,ViewPreAnaesthesiaEvaluationDetails,ReEvaluation,RecordIntraAnaesthesiaDetails,AnaesthesiaHistory);
	}
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ )
	{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!="")
		{
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callFunctionsAnaesDetails('"+id_colval+"','"+param+"');\")> "+id_name_colval + "</a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	//resizeWindow();
	//resizeWindow(orderctlHDR);
	resizeWindowForAnaeDetails(orderctlHDR);
}


function  displayToolTipPendingOrders(facility_id,patient_id,patient_name,sex,anesthesia_srl_no,proc_module_id,request_source_type,source_id,parent_source_id,anathestist_code,patient_class,episode_id,encounter_id,surgeon_code,surgeon_name,date_of_birth,orderctlHDR,imgObj)
{		
	var menu_id_list		= new Array("A1","A2","A3","A4","A5");
	var param=facility_id+"::"+patient_id+"::"+patient_name+"::"+sex+"::"+anesthesia_srl_no+"::"+proc_module_id+"::"+request_source_type+"::"+source_id+"::"+parent_source_id+"::"+anathestist_code+"::"+patient_class+"::"+episode_id+"::"+encounter_id+"::"+surgeon_code+"::"+surgeon_code+"::"+date_of_birth;
	var PatientDemographics			=getLabel("eOT.PatientDemographics.Label","OT");
	var	PatientHistory				=getLabel("Common.PatientHistory.label","Common");
	var SurgeryHistory				=getLabel("eOT.SurgeryHistory.Label","OT");
	var RecordPostAnaesthesiaDetails = getLabel("eOT.RecordPostAnaesthesiaDetails.Label","OT");
	var AnaesthesiaHistory=	getLabel("eOT.AnaesthesiaHistory.Label","OT");
	var PreAnaesthesiaEvaluation = getLabel("eOT.PreAnaesthesiaEval.Label","OT");
	var	menu_name_list	= new Array(PatientDemographics,PatientHistory,SurgeryHistory,AnaesthesiaHistory,PreAnaesthesiaEvaluation);
	callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
	for( var i=0; i<menu_name_list.length; i++ )
	{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		if(id_colval!="")
		{
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callFunctionsPendingOrders('"+id_colval+"','"+param+"');\")>"+id_name_colval + "</a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	//resizeWindow1();
	resizeWindow(orderctlHDR);
}

function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
function callFunctionsAnaesDetails(obj,para){
	var par=new Array();
	par=para.split("::");

	var dialogHeight = "60" ;
	var dialogWidth  = "130" ;
	var dialogTop    = "0";
	var dialogLeft   = "0";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop;

	hideToolTip();

	//alert(obj);
	if(obj=="A1")
	{

		var	param="facility_id="+par[0]+"&Patient_ID="+par[1];
		retVal=window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}
	if(obj=="A2")
	{
		var HTML = "<html>"
		HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
		HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
		HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +par[1]+ "'>";
		HTML += "<input type='text' name='patient_class' id='patient_class' value= '"+par[7]+"'>";
		HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '"+par[8]+"'>";
		HTML += "<input type='text' name='mode' id='mode' value= 'R'>"; 
		HTML += "<input type='text' name='accession_type' id='accession_type' value= 'OT'>"; 
		HTML += "</form>"
		HTML += "</html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
		parent.parent.messageFrame.document.historyForm.submit();
	}
	if(obj=="A3")
	{
		var param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2])+"&sex="+encodeURIComponent(par[3])+"&dob="+par[6]+"&function_name=Surgery History"+"&called_from=OPER_REG";
		var retVal=window.showModalDialog('../../eOT/jsp/SurgeryHistory.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	}

	if(obj=="A4")
	{
		var	param="facility_id="+par[0]+"&anesthesia_srl_no="+par[4];
		var retVal=window.showModalDialog('../../eOT/jsp/AT_PreAnaesDtlsView.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	}
	if(obj=="A5")
	{
		var	param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2])+"&sex="+encodeURIComponent(par[3])+"&anesthesia_srl_no="+par[4]+"&proc_module_id="+par[5]+"&order_id="+par[9]+"&tab_name="+"AnesthesiaDetails"+"&accession_num="+par[10];
		retVal=window.showModalDialog('../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param,window,"dialogHeight: 900px; dialogWidth:1050px; center: yes; help: no; resizable: yes; status: no;");
		parent.parent.at_tab_frame.record_anethesia_details_frame.location.reload();

	}
	if(obj=="A6")
	{
		var	param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2])+"&sex="+encodeURIComponent(par[3])+"&anesthesia_srl_no="+par[4]+"&proc_module_id="+par[5]+"&order_id="+par[9]+"&accession_num="+par[10];
		retVal=window.showModalDialog('../../eOT/jsp/AT_IntraAnaesthesia.jsp?'+param,window,"dialogHeight: 900px; dialogWidth:1050px; center: yes; help: no; resizable: yes; status: no;");	
		parent.parent.at_tab_frame.record_anethesia_details_frame.location.reload();

	}
	if(obj=="A7")
	{
		//dhana
		var	param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2])+"&sex="+encodeURIComponent(par[3])+"&anesthesia_srl_no="+par[4]+"&proc_module_id="+par[5]+"&order_id="+par[9];
//		alert("Record Anesthesia"+param);
		retVal=window.showModalDialog('../../eOT/jsp/AT_PostAnaesthesia.jsp?'+param,window,"dialogHeight: 900px; dialogWidth:1050px; center: yes; help: no; resizable: yes; status: no;");				parent.parent.at_tab_frame.record_anethesia_details_frame.location.reload();

	}

	if(obj=="A8")
	{
		//called_from=REC_ANES&home_required_yn=N&patient_id="+patient_id+"&patient_name="+patient_name
		var dialogHeight 		= "80";
		var dialogWidth  		= "80";
		var dialogTop   		= "10";
		var dialogLeft   		= "50";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var	param="called_from=REC_ANES&home_required_yn=N&facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+par[2];//+"&anesthesia_srl_no="+par[4]+"&proc_module_id="+par[5];
		retVal=window.showModalDialog("../../eOT/jsp/AT_AnaesthesiaHistory.jsp?"+param,arguments,features);

	}
}
function callFunctionsPendingOrders(obj,para)
{
	var par=new Array();
	par=para.split("::");
	hideToolTip();
	if(obj=="A1")
	{
	var dialogHeight	= "45";
	var dialogWidth		= "60";
	var dialogTop		= "35";
	var dialogLeft		= "80";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
		var	param="facility_id="+par[0]+"&Patient_ID="+par[1];
		retVal=window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}
	if(obj=="A2")
	{	
		var dialogHeight 		= "75"; //"100";//window.screen.availHeight;//"80";
		var dialogWidth  		= "75";//"100";//window.screen.availWidth;//"80";
		var dialogTop   		= "5";//"10";
		var dialogLeft   		= "50";//"50";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var HTML = "<html>"
		HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
		HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +par[1]+ "'>";
		HTML += "<input type='text' name='patient_class' id='patient_class' value= '"+par[10]+"'>";
		HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '"+par[12]+"'>";
		HTML += "<input type='text' name='mode' id='mode' value= 'R'>"; 
		HTML += "<input type='text' name='accession_type' id='accession_type' value= 'OT'>"; 
		HTML += "</form>"
		HTML += "</html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
		parent.parent.messageFrame.document.historyForm.submit();

	}
	if(obj=="A3")
	{
		var dialogHeight 		= "75"; //"100";//window.screen.availHeight;//"80";
	var dialogWidth  		= "75";//"100";//window.screen.availWidth;//"80";
	var dialogTop   		= "5";//"10";
	var dialogLeft   		= "50";//"50";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
		var param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2])+"&sex="+encodeURIComponent(par[3])+"&dob="+par[15]+"&function_name=Surgery History"+"&called_from=OPER_REG";
		var retVal=window.showModalDialog('../../eOT/jsp/SurgeryHistory.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");
	}
	if(obj=="A4")
	{
		var dialogHeight 		= "75"; //"100";//window.screen.availHeight;//"80";
	var dialogWidth  		= "75";//"100";//window.screen.availWidth;//"80";
	var dialogTop   		= "5";//"10";
	var dialogLeft   		= "50";//"50";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
		var	param="called_from=REC_ANES&home_required_yn=N&facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2]);//+"&anesthesia_srl_no="+par[4]+"&proc_module_id="+par[5];
		retVal=window.showModalDialog("../../eOT/jsp/AT_AnaesthesiaHistory.jsp?"+param,arguments,features);	
	}
	if(obj=="A5")
	{
		var dialogHeight 		= "75"; //"100";//window.screen.availHeight;//"80";
	var dialogWidth  		= "75";//"100";//window.screen.availWidth;//"80";
	var dialogTop   		= "5";//"10";
	var dialogLeft   		= "50";//"50";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
		var	param="facility_id="+par[0]+"&patient_id="+par[1]+"&patient_name="+encodeURIComponent(par[2])+"&sex="+encodeURIComponent(par[3])+"&anesthesia_srl_no="+par[4]+"&proc_module_id="+par[5]+"&request_source_type="+par[6]+"&source_id="+par[7]+"&parent_source_id="+par[8]+"&anathestist_code="+par[9]+"&patient_class="+par[10]+"&episode_id="+par[11]+"&encounter_id="+par[12]+"&encounter_id="+par[13]+"&encounter_id="+par[14]+"&tab_name="+"PendingOrders";
		retVal=window.showModalDialog('../../eOT/jsp/AT_PreAnaesthesia.jsp?'+param,window,"dialogHeight: 800px; dialogWidth:900px; center: yes; help: no; resizable: yes; status: no;");
		parent.parent.at_tab_frame.record_anethesia_details_frame.location.reload();
	}
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

function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'ORMENU';
}

function callOnMouseOut(obj)
{
	obj.className = currClass;
}


async function callPreMorbidValues(obj,target)
{
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";				
	if(target.name == desc_name){
		var v1=getLabel("eOT.PremorbidDetails.Label","OT");
		tit= v1 ;
		sql="SELECT LONG_DESC description, PREMORBID_CODE code FROM AT_PREMORBID_MAST WHERE NVL(STATUS,'E') = 'E' and upper(LONG_DESC) like upper(?) and upper(PREMORBID_CODE) like upper(?) order by 2";
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = tdesc;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
		}
	}else{
		target.value="";
		obj.value="";
	}
}

function apply()
{   
	var HdrformObj = parent.parent.pre_anesth_header_frame.RecordAnesthesiaHdrForm; 
	var StatusformObj = window.parent.parent.frames[8].document.forms[0];
	var DtlfrmObj = parent.parent.parent.pre_anesthesia_objectcollect_frame;
	var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
	var facility_id = HdrformObj.facility_id.value;
	var anesthesia_srl_no = HdrformObj.anesthesia_srl_no.value;
	var ASA_SCORE_CODE=trimString(HdrformObj.stages1.value); // Added by selvin for crf-0021
	var weight = trimString(HdrformObj.weight.value);
	var height = trimString(HdrformObj.height.value);
	var status_desc = trimString(HdrformObj.status_desc.value);

	//var bsa = trimString(HdrformObj.bsa.value);
	var bsa = trimString(HdrformObj.bsaDisp.value);
	var bmi = trimString(HdrformObj.bmi.value);
	var preop_asse_done_yn=StatusformObj.preop_asse_done_yn.value;
	var status = trimString(HdrformObj.status.value);
	var source_order_id = trimString(HdrformObj.source_id.value);
	var chk_box = StatusformObj.preop_asse_done;
//	var remarks =encodeURIComponent( HdrformObj.remarks.value);
	var remarks =HdrformObj.remarks.value;
	if(status=='OS')
	{
		status='PR';
	}

	var flag=0;
	if (weight=='' && height!='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Weight  = getLabel("Common.weight.label","Common");
		err_txt=msgArray[0]+Weight +msgArray[1];
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_txt;
		return false;
	}
	if(weight!='' && height=='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Height  = getLabel("Common.height.label","Common");
		err_txt=msgArray[0]+Height +msgArray[1];
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_txt;
		return false;
	}

	if (weight!='' && height!='' && status_desc=='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var err_msg=msgArray[0]+" BMI Details Description "+(msgArray[1])
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_msg;
		return false;
	}
}
function checkSpl( val ) {
    var result = "" ;
    var ch = "" ;

    var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
        val = val.replace("\n","\"")
    }

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
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
  return result ;
}
function createXMLForPreHdr()
{
	var StatusformObj = window.parent.parent.frames[8].document.forms[0];
	var chk_box = StatusformObj.intraop_done;
	var table_name="AT_ANAESTHESIA_RECORD_HDR";
	var xmlString ="";
	xmlString+="<PRE_HDR"+" ";
	xmlString+="weight=\""+weight+"\""+" ";
	xmlString+="height=\""+height+"\""+" ";
	xmlString+="bsa=\""+bsa+"\""+" ";
	xmlString+="bmi=\""+bmi+"\""+" ";
	xmlString+="preop_asse_done_yn=\""+preop_asse_done_yn+"\""+" ";
	xmlString+="status=\""+status+"\""+" ";
	xmlString+="source_order_id=\""+source_order_id+"\""+" ";
	xmlString+="remarks=\""+remarks+"\""+" ";
	xmlString+="db_mode=\"U\""+" ";
	xmlString+="table_name=\""+table_name+"\""+" />";
	return xmlString;
 }	
async function apply()
{
console.log(window.parent.parent.frames[2].document.forms[0]);
//var HdrformObj = document.getElementById('RecordAnesthesiaHdrForm');
	var HdrformObj = parent.parent.pre_anesth_header_frame.RecordAnesthesiaHdrForm; 
		var StatusformObj = window.parent.parent.frames[8].document.forms[0];
	//var StatusformObj =window.parent.parent.frames[2].document.forms[0];
	var DtlfrmObj = parent.parent.parent.pre_anesthesia_objectcollect_frame;
	//var DtlfrmObj = document.getElementById('pre_anesthesia_objectcollect_frame');;
	var msg = getMessage("NO_CHANGE_TO_SAVE","Common");
	
	var facility_id = HdrformObj.facility_id.value;
	//var facilityElement = document.getElementById('facility_id');
	//var anesthesia_srl_no = HdrformObj.anesthesia_srl_no.value;
	var anesthesia_srl_no = document.getElementById('anesthesia_srl_no');
	var ASA_SCORE_CODE=trimString(HdrformObj.stages1.value); // Added by selvin for crf-0021
	var weight = trimString(HdrformObj.weight.value);
	var height = trimString(HdrformObj.height.value);
	var status_desc = trimString(HdrformObj.status_desc.value);
	
	
	
	
	
	
	
	/*var stages1Element = document.getElementById('stages1');
var weightElement = document.getElementById('weight');
var heightElement = document.getElementById('height');
var statusDescElement = document.getElementById('status_desc');

 var bsa =document.getElementById('bsaDisp');
 console.log("bsa");
 console.log(bsa);
var bmi = document.getElementById('bmi');
var preop_asse_done_yn = document.getElementById('preop_asse_done_yn');
var status = document.getElementById('status');
var source_order_id = document.getElementById('source_id');

var chk_box = document.getElementById('preop_asse_done');

// Get the checked status of the checkbox
//var isChkBoxChecked = chk_box.checked;

// Retrieve the remarks value
var remarks = document.getElementById('remarks');
*/






	//var bsa = trimString(HdrformObj.bsa.value);
	var bsa = trimString(HdrformObj.bsaDisp.value);
	var bmi = trimString(HdrformObj.bmi.value);
	var preop_asse_done_yn=StatusformObj.preop_asse_done_yn.value;
	var status = trimString(HdrformObj.status.value);
	var source_order_id = trimString(HdrformObj.source_id.value);
	var chk_box = StatusformObj.preop_asse_done;
//	var remarks =encodeURIComponent( HdrformObj.remarks.value);
	var remarks =HdrformObj.remarks.value;
	
	
	
	
	if(status=='OS')
	{
		status='PR';
	}

	var flag=0;
	if (weight=='' && height!='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Weight  = getLabel("Common.weight.label","Common");
		err_txt=msgArray[0]+Weight +msgArray[1];
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_txt;
		return false;
	}
	if(weight!='' && height=='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Height  = getLabel("Common.height.label","Common");
		err_txt=msgArray[0]+Height +msgArray[1];
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_txt;
		return false;
	}

	if (weight!='' && height!='' && status_desc=='')
	{
		flag=1;
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var err_msg=msgArray[0]+" BMI Details Description "+(msgArray[1])
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_msg;
		return false;
	}


if(flag==0)
{
	if(chk_box.checked==false)
	{
				if(window.confirm(getMessage("APP-OT0078","OT"))==false){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
		    }
		}
	 var param = "facility_id="+facility_id+"&anesthesia_srl_no="+anesthesia_srl_no+"&ASA_SCORE_CODE="+ASA_SCORE_CODE; //0021
	 var xmlDoc = "";
	 var xmlHttp = new XMLHttpRequest();
	 var xmlStr="<root>";
//	 alert("767 : "+param)
	 var action = '../../servlet/eOT.AT_RecordAnesthesiaServlet?'+param;
	 xmlStr+=createXMLForPreHdr();
	 xmlStr+=DtlfrmObj.createXMLForPreMorbid();
	 xmlStr+="</root>";
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST",action,false);
	 xmlHttp.send(xmlDoc);
	 var retVal =xmlHttp.responseText;
	 retVal = trimString(retVal);
		if(retVal!=null && retVal!="" && retVal!="undefined")
		{
		  if(retVal == "RECORD_INSERTED")
		  {
					var result_msg=getMessage("RECORD_INSERTED","SM");
					alert(result_msg);
					window.returnValue=true;
					//Added for Alpha-OT-[IN:048239] start
					if(chk_box.checked==true)
					{
					 var param="func_mode=deleteOnSaveAnes&facility_id="+facility_id+"&source_order_id="+source_order_id;
					 var xmlDoc = "" ;
					 var xmlHttp = new XMLHttpRequest() ;
					 var xmlStr ="<root><SEARCH ";
					 xmlStr +=" /></root>";
					 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					 xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
					 xmlHttp.send(xmlDoc);
					 var retVal = localTrimString(xmlHttp.responseText);
					//Added for Alpha-OT-[IN:048239] End
				}
					window.close();
				}
				else
				{
					alert(retVal);
					window.returnValue=true;
					window.close();
				}
			}
			xmlStr="";
	}
	else
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}


function CheckBmiPositiveNumberHt(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 1) {
		displyBSAandBMI();
    }
    else {
			document.RecordAnesthesiaHdrForm.bsa.value="";
			document.RecordAnesthesiaHdrForm.bsaDisp.value="";
			document.RecordAnesthesiaHdrForm.bmi.value="";
			document.RecordAnesthesiaHdrForm.status_desc.value="";
        if ( obj.value.length > 0 || obj.value<2) {
            alert(getMessage("APP-OT0165","OT"));			
            obj.value="";
            obj.focus();
        }
    }
}
function CheckBmiPositiveNumber(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
		displyBSAandBMI();
    }
    else {
			document.RecordAnesthesiaHdrForm.bsa.value="";
			document.RecordAnesthesiaHdrForm.bsaDisp.value="";
			document.RecordAnesthesiaHdrForm.bmi.value="";
			document.RecordAnesthesiaHdrForm.status_desc.value="";
        if ( obj.value.length > 0 ) {
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));			
            obj.value="";
        }
    }
}


function checkBMICalculation(){
	var formObj=document.forms[0];
	var height=formObj.height.value;
	var weight=formObj.weight.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkBMIDetails&weight="+weight+"&height="+height;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	var amt=9999.99;
	if(retVal>amt){
		alert("BMI Details Cannot be Greater than 9999.99.")
		formObj.height.value="";
		formObj.status_desc.value="";
		formObj.bsa.value="";
		formObj.bsaDisp.value="";
		formObj.bmi.value="";
//		formObj.height.focus();
		return false;
	}
	return true;
}
function displyBSAandBMI()
{
	var weight="";
	var height="";
	weight=document.RecordAnesthesiaHdrForm.weight.value;
	height=document.RecordAnesthesiaHdrForm.height.value;

	if( weight!="" && weight!=null && weight!="undefined" && height!="" && height!=null && height!="undefined")
	{
	//	checkBMICalculation();
		parent.parent.dummy_frame.location.href = "../../eCommon/html/blank.html";
		parent.parent.dummy_frames.location.href = "../../eCommon/html/blank.html";
		var htmlVal = "<html><head></head><body>";
		htmlVal += "<form name='frm_temp' id='frm_temp' method='post'; action='../../eOT/jsp/AT_PreAnaesHdrDynamicValue.jsp' target='dummy_frames'>";
		htmlVal += "<input type='hidden' name='weight' id='weight' value='"+weight+"'>";
		htmlVal += "<input type='hidden' name='height' id='height' value='"+height+"'>";
		htmlVal += "</form></body></html>";
		parent.parent.dummy_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		parent.parent.dummy_frame.document.frm_temp.submit();

	}else{
	}
}
async function openNewDialogWindow(strVal,size){
	var frmObj=document.forms[0];
	var remarks = frmObj.remarks.value;
	var remarks_title = encodeURIComponent(getLabel("Common.remarks.label","common"));
	var size="100";
	remarks = encodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	var param="heading="+remarks_title+"&para="+remarks+"&size="+size+"&remarks="+remarks;
	if(frmObj.preop_asse_done_yn.value=="Y"){
		 window.showModalDialog('../../eOT/jsp/TextArea.jsp?'+param,window,"dialogHeight: 150px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;scrolling: no;");
		if(retext=='undefined'||retext==''||retext==null)
		retext=frmObj.remarks.value;
		frmObj.remarks.value=retext;
	}else{

		var retext= await window.showModalDialog('../../eOT/jsp/LeftFrameTextArea.jsp?'+param ,window,"dialogHeight:120px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no; scrolling: no;");
		if(retext=='undefined'||retext==''||retext==null)
		{
		retext=frmObj.remarks.value;
	}else
		{
		frmObj.remarks.value=retext;
		}
	}
}

function preAnaesCheckedYN()
{
	if(document.forms[0].preop_asse_done.checked==true)
		document.forms[0].preop_asse_done_yn.value="Y";
	else
		document.forms[0].preop_asse_done_yn.value="N";
}

async function callPreAnaesNotes1(login_user)
{
	var window_close="Y";
	var speciality_code= ""; 
	var hide_header="N";
	var tab_yn="N";
	var locn_type="70";
	var called_from="PRE_ANES";
	var formObjHdr=parent.pre_anesth_header_frame.RecordAnesthesiaHdrForm;
	var anesthesia_srl_no = formObjHdr.anesthesia_srl_no.value;
	var anesthesia_accession_num =  formObjHdr.accession_num.value;
	var accession_num="";
	var facility_id = formObjHdr.facility_id.value;
	var patient_id = formObjHdr.patient_id.value;
	var episode_id = formObjHdr.episode_id.value;
	var patient_class = formObjHdr.patient_class.value;
	var encounter_id = formObjHdr.encounter_id.value;
	var contr_mod_accession_num="";
	contr_mod_accession_num = facility_id+anesthesia_srl_no+"PRE"+anesthesia_accession_num;	
	var preAnesthesiaDetails    =getLabel("eOT.PreAnaesthesiaDetails.Label","OT");
	var title = preAnesthesiaDetails ;
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Pre_anesthesia_notes&accession_num="+anesthesia_accession_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&contr_mod_accession_num="+contr_mod_accession_num,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arr_spec=retVal.split(",");
	var arr2_spec="";
	var note_type_value="";
	var note_type="";
	var note_type_desc="";
	note_type =arr_spec[0];
	note_type_desc=arr_spec[1];
	update_mode=arr_spec[3];
	accession_num=arr_spec[4];
	//Added performed_by_ql on 1/19/2011 by Anitha for 25928
	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+encodeURIComponent(title)+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&performed_by_ql="+formObjHdr.strUser.value;
	var title1="";
	var dialogHeight= "42";
	var dialogWidth	= "85";
	dialogTop    = "55";
		 dialogLeft   = "30";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal  = await window.showModalDialog(action_url, title1, features);
}

function callNoRecord()
{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}


function  reasonToolTip(order_id){

		var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=order_catalog_desc&order_id="+order_id;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	var arrMsg=retVal;
	var arr=new Array();
	var frmObj=document.forms[0];
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
		var id_name_colval  = arr[0];	
			tab_dat     += "<tr>"
			tab_dat     += "<td class='COLUMNHEADERCENTER' nowrap >"+id_name_colval+"</td>";
			tab_dat     += "</tr>";
	for( cou=1;cou<arr.length;cou++)
	{
			msg=arr[cou];
			tab_dat     += "<tr>"
			tab_dat     += "<td class='label' > <B>"+msg+ " </B></td>"		
			tab_dat     += "</tr> ";	
		}
			tab_dat     += "</table> ";	
 
        //Commented against MMS-QH-CRF-0199
        /*document.getElementById("tooltiplayer").innerHTML = tab_dat;
	 	resizeWindow1();*/
		return tab_dat;//Added against MMS-QH-CRF-0199
}

function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			//alert("Invalid Date Format");
			alert(getMessage("INVALID_DATE_FMT","OT"));
			obj.select();
		}
	}
}

function checkLimit(field, limit){
	 if (field.value.length > limit){
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}


function clearPatientName(){
	var formObj = document.forms[0];
	formObj.patient_name.value='';
}



async function callPatSearch(){
	var formObj=document.RecordAnesthesiaDetailsForm;
	var patient_id = document.RecordAnesthesiaDetailsForm.patient_id;
	var patient_name = document.RecordAnesthesiaDetailsForm.patient_name;
	var male=getLabel("Common.male.label","Common");
	var female=getLabel("Common.female.label","Common");
	var unknown=getLabel("Common.unknown.label","Common");
	//Clearing all these values when patient ID is changed after encounter id is selected
//	var frmObj=document.PreOperHdr;
	formObj.patient_name.value="";
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
		console.log("entered if retVal : "+retVal);
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
						//patient name is coming with "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  at the beginning.
			const toRemove = "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  ";
			const regex = new RegExp("^" + toRemove);
		  patient_name.value = patient_name.value.replace(regex, "");
		console.log("patient name : "+patient_name.value);
		  			const toRemoveAgain = "<!DOCTYPE html>  ";
			const regexAgain = new RegExp("^" + toRemoveAgain);
			var testPatientNameValue = patient_name.value.replace(regexAgain, "");
			patient_name.value=testPatientNameValue;
		console.log("test PatientName Value :"+testPatientNameValue);
	}
}


function callCurrentRx(){
	var formObj = document.RecordAnesthesiaTabForm;
	var patient_id	 = formObj.patient_id.value;
	var encounter_id = formObj.encounter_id.value;
	var patient_class = formObj.patient_class.value;
	var param = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&called_frm=OT&title=Current Medication Alert";
	var	url = "../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?"+param;
	var dialogHeight 		= "80";
	var dialogWidth  		= "80";
	var dialogTop   		= "15";
	var dialogLeft   		= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no;";
	var arguments    = "" ;
	retVal 	   = await window.showModalDialog(url, arguments, features);
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


function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;
	//var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	  //var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;
	  var wdth = eval("document.getElementById('"+orderctlHDR1+"')").offsetWidth;
	  var hght1 = eval("document.getElementById('"+orderctlHDR1+"')").offsetHeight;
   
	  var wdth1 = getPos(orderctlHDR).x +wdth;
	  var hght = getPos(orderctlHDR).y ;
   
	  bodwidth  = document.body.offsetWidth
	  bodheight = document.body.offsetHeight
   
	  var z = bodwidth- (event.x + wdth);
   
	  var x 	  = event.x;
	  var y 	  = event.y;
   
	  x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	  y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);
   
	  if(x<bodwidth){
		  x= wdth1;
	  }else{
		  x = getPos(orderctlHDR).x;
	  }
	  if(y<bodheight){
		console.log("entered bodHeight")
		  y = hght;
   
	  }else
	  {
		console.log("entered else of bodheight")
		console.log("result : "+y +"  : hght1 : "+ hght1+"   : offset height :"+(document.getElementById("tooltiplayer").offsetHeight*2))
		  y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;
	  }
	  document.getElementById("tooltiplayer").style.left= x+"px";
	  document.getElementById("tooltiplayer").style.top = y+"px";
	  document.getElementById("tooltiplayer").style.visibility='visible'
  }


function resizeWindowForAnaeDetails(orderctlHDR){
	var orderctlHDR1 = orderctlHDR.id;
	//var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	  //var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;
	  var wdth = eval("document.getElementById('"+orderctlHDR1+"')").offsetWidth;
	  var hght1 = eval("document.getElementById('"+orderctlHDR1+"')").offsetHeight;
   
	  var wdth1 = getPos(orderctlHDR).x +wdth;
	  var hght = getPos(orderctlHDR).y ;
   
	  bodwidth  = document.body.offsetWidth
	  bodheight = document.body.offsetHeight
   
	  var z = bodwidth- (event.x + wdth);
   
	  var x 	  = event.x;
	  var y 	  = event.y;
   
	  x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	  y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);
   
	  if(x<bodwidth){
		  x= wdth1;
	  }else{
		  x = getPos(orderctlHDR).x;
	  }
	  if(y<bodheight){
		console.log("entered bodHeight")
		  y = hght;
   
	  }else
	  {
		console.log("entered else of bodheight")
		console.log("result : "+y +"  : hght1 : "+ hght1+"   : offset height :"+(document.getElementById("tooltiplayer").offsetHeight*2))
		  y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;
	  }
	  document.getElementById("tooltiplayer").style.left= x+"px";
	  document.getElementById("tooltiplayer").style.top = y+89+"px";
	  document.getElementById("tooltiplayer").style.visibility='visible'
  }

function callMouseOverOnTD(obj,imgObj){
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 document.getElementById(prevObjID).className = 'gridDataBlue';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
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
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
function checkSpecCharsforID(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // 
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}
// Added by selvin for crf-0021
function check_asa(obj)
{	
	var formObj = document.forms[0];
	var asa = formObj.stages1.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_asa&asa="+asa,false);	
	xmlHttp.send(xmlDoc);	
	var retVal = trimString(xmlHttp.responseText);	
	document.getElementById('asa_score_code').innerHTML = retVal;	
}
// End for crf-0021
//AAKH CRF-0069 START
function dateCheck(from, to, fieldFromChk,fieldToChk) 
{
	var fromarray; var toarray;
    var fromdate = from ;
    var todate = to ;
	 var arr = new Array(todate,fromdate)
    if(fromdate.length > 0 && todate.length > 0 ) 
    {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) 
            {
				var error = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT").replace("#", fieldFromChk).replace("#", fieldToChk );
				alert(error);
				return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
	return true;
}
//AAKH CRF-0069 END

