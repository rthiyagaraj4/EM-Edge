 //saved on 29/10/2005
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryDispDrugFrames.jsp";
}

function reset(clearBottom){
	
	if (clearBottom==""){
		clearBottom=0;
	}
	url=frames.f_query_add_mod.location.href;

	if (url.indexOf('blank')!=-1){
			return;
	}
	var formObj = frames.f_query_add_mod.f_queryCriteria.FormQueryDispDrug;//.FormQueryPresVsDispDrug;
	formObj.reset();
	frames.f_query_add_mod.f_orderframe.location.href="../../eCommon/html/blank.html";
	if (clearBottom==0){
		frames.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	formObj.Drug_Name.focus();
   
}
//for Patient Lookup
function callPatientSearch(obj){
	var patient_id = PatientSearch();
	if (patient_id!="undefined" && patient_id!="") {
		obj.value = patient_id;
	}
}
function clearvalues(){
	document.FormQueryDispDrug.Drug_Name.value="";
	if (document.FormQueryDispDrug.searchby[1].checked==true){
	    document.getElementById("drug_trade_legend").innerHTML=getLabel("Common.TradeName.label","Common");
	}
	else{
		document.getElementById("drug_trade_legend").innerHTML=getLabel("Common.DrugName.label","Common");
	}
	addDefRoutes();
}
//for Drug Lookup
async function searchDrugName(obj){
	var formObj = obj;
	var drug_code ="";
	if (obj.searchby[0].checked==true){
		retVal = await DrugSearch( "D", obj.Drug_Name,"QueryDDP" );
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != undefined && retVal!=null && retVal != "" )  {
			formObj.Drug_Name.value = arr[1] ;
			formObj.Drug_Code.value = arr[0];	
			formObj.trade_Code.value="";
			drug_code = arr[0];
	    }
		else{
			formObj.Drug_Name.value = '' ;
			formObj.Drug_Code.value = '';	
		}
	}
	else{
		retVal = await searchTrade();
		/*if(retVal != undefined && retVal!=null && retVal != "" )  {
			formObj.Drug_Name.value = retVal[1] ;
			formObj.trade_Code.value = retVal[0];	
			formObj.Drug_Code.value="";
	    }
		else{
			formObj.Drug_Name.value = '' ;
			formObj.trade_Code.value = '';	
		}*/
	}
	if (obj.searchby[0].checked==true && drug_code!=""){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&called_from=routeForDrug"+"&drug_code="+drug_code, false ) ;
		xmlHttp.send( xmlDoc ) ;
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText);
	}
	else
		addDefRoutes();
}

function validateDate(obj){
	CheckDate(obj);
}

function loadOrderDetails(ordid,order_line_num,patientdetails,patient_id){//  patiend id added for SCF No : 0892 Inc No:[40991]
	parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispDrugOrderLine.jsp?order_id="+ordid+"&order_line_num="+order_line_num+"&patient_details="+patientdetails+"&patient_id="+patient_id;// patiend id added for SCF No : 0892 Inc No:[40991]
	parent.OrderFrameSet.rows="5%,40%,15%,*";
}

function loadBatchDetails(dispno,patientdetails){
	parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispDrugOrderLine.jsp?disp_no="+dispno+"&patient_details="+patientdetails;
	parent.OrderFrameSet.rows="5%,40%,15%,*";

}

function loadDrugDetails(order_id,drugdesc,uom,drugcode,disp_no){
	//drugdesc				=	encodeURIComponent(drugdesc,"UTF-8");

	parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryDispDrugDisplayDrug.jsp?drug_desc="+drugdesc;
	parent.f_totaldetailsframe.location.href="../../ePH/jsp/QueryDispDrugTotalDetails.jsp?order_id="+order_id+"&drug_code="+drugcode+"&uom="+uom+"&disp_no="+disp_no;
}

function callResultPage(){
	//Chek if Patient Id is null
	var formObj	=	parent.document.f_queryCriteria.FormQueryDispDrug;
	var localeName = formObj.language_id.value; 
	var fields	=new Array();
	var names=new Array();
	var searchby =formObj.searchby;
		fields[0]=formObj.Drug_Name;
	if (searchby[0].checked==true){
		names[0]=getLabel("Common.DrugName.label","Common");
	}
	else{
		names[0]=getLabel("Common.TradeName.label","Common");
	}
	var errorPage	= "../../eCommon/jsp/error.jsp" ;
	var blankObj 	= null ;
	blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

	if (blankObject!=null){
		blankObject.focus() ;
		//parent.parent.reset(1);
		return;
	}
	names[0]=getLabel("ePH.DispensedDateFrom.label","PH");
	fields[1]=formObj.Dispense_Date_From;
	blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;
	if (blankObject!=null){
		blankObject.focus() ;
		//parent.parent.reset(1);
		return;

	}
	names[0]=getLabel("ePH.DispensedDateTo.label","PH");
	fields[2]=formObj.Dispense_Date_To;
	blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

	if (blankObject!=null){
		blankObject.focus() ;
		//parent.parent.reset(1);
		return;
	}
	//Validate from date and to date
	//	var dt_from	=	formObj.Dispense_Date_From.value;
	//	var dt_to	=	formObj.Dispense_Date_To.value;
	var dt_from = convertDate(formObj.Dispense_Date_From.value,'DMY',localeName); 
	var dt_to  = convertDate(formObj.Dispense_Date_To.value,'DMY',localeName); 
	if (dt_from!="" && dt_to!=""){
		if(!doDateCheck(formObj.Dispense_Date_From,formObj.Dispense_Date_To,parent.parent.messageFrame)){
			formObj.Dispense_Date_To.select();
			formObj.Dispense_Date_To.focus();
			//parent.parent.reset(1);
			return;
		}
	} 
	var drug_code				=		formObj.Drug_Code.value;
	var route_code				=		formObj.route_code.value;
	var disploc_code			=		formObj.DispenseLocation.value;
	var billinggroup_code		=       "";
	var billingYN				=       formObj.billingYN.value;
	if(billingYN=="Y"){
		var billinggroup_code		=		formObj.billingGroupcode.value;
	}
	parent.f_orderframe.location.href="../../ePH/jsp/QueryDispDrugOrderFrame.jsp?route_code="+route_code+"&drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&disploc_code="+disploc_code+"&billinggroup_code="+billinggroup_code+"&trade_Code="+formObj.trade_Code.value;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function SubmitLink(from,to){
	var obj				=	document.formDispensedDrugs;
	obj.from.value		=	from;
	obj.to.value		=	to;
	obj.submit();
}

function clearList(){
	var route_len =document.FormQueryDispDrug.route_code.options.length;
	for(var i=0;i<route_len;i++) {
		FormQueryDispDrug.route_code.remove("route_code") ;
	}
}

function addOption(code,desc,fntColor,backgrndColor){ // fntColor added for CRF RUT-CRF-0034.1[IN:037389]
	var opt = document.createElement("OPTION") ;
	opt.text = decodeURIComponent(desc,"UTF-8") ; //added for IN26128reopen --09/02/2011-- priya
	opt.value = code ;
	opt.style.color=fntColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	opt.style.backgroundColor=backgrndColor;// added for CRF RUT-CRF-0034.1[IN:037389]
	document.FormQueryDispDrug.route_code.add(opt);
}
//to check date validation
function checkSysDate(from,to,systemdate){
	var FormQueryDispDrug = document.frames.FormQueryDispDrug;
	var sysdate=FormQueryDispDrug.systemdate.value;
	var locale=FormQueryDispDrug.language_id.value;
	var fromDate=convertDate(from.value,'DMY',locale,"en");
	var toDate =convertDate(to.value,'DMY',locale,"en");
	var message;
	//messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	if(!doDateCheckAlert(fromDate,systemdate,0)){
		message=getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH");
		parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		from.select();
		from.focus();
		return false;
	}
	if(!doDateCheckAlert(toDate,systemdate,0)){
		//alert("To Should be Less than Sysdate");//For less then Sys date
		message=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH");
         parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		to.select();
		to.focus();
		return false;
	}
    if(!doDateCheck(fromDate,toDate,messageFrame)){
		//alert("To Should be Greater than From");//For less then Sys date
		message=getMessage("TO_DT_GR_EQ_FM_DT","PH");
		parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		to.select();
		to.focus();
		return false;
	}
	parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	return true;
}


async function searchTrade(){
	var formObj        = document.FormQueryDispDrug;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	formObj.trade_Code.value = "";
	dataNameArray[0]	="language_id";
	dataValueArray[0]	=formObj.language_id.value;
	dataTypeArray[0]	=STRING;
	argumentArray[0]	= formObj.TRADE_QUERY.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.Drug_Name.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup(getLabel("Common.TradeName.label","Common"), argumentArray);
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if(arr[1]==undefined) 
	 	{
		 	arr[0]="";	
		 	arr[1]="";	
	 	}
	if(retVal != null && retVal != "") {
		formObj.trade_Code.value = arr[0];
		formObj.Drug_Name.value =arr[1] ;
		formObj.Drug_Code.value ="" ;
	}
	else{
		formObj.Drug_Name.value = '' ;
		formObj.trade_Code.value = '';	
	}
}

function addDefRoutes(){
	var formObj =document.FormQueryDispDrug;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ReportsValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&called_from=defRoutes", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
