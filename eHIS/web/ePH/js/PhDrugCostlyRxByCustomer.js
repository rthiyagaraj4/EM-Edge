/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/02/2017		IN063478		Badmavathi B							Modified date validation for greater than sysdate
24/02/2023	39764				SREENADH.M                            Ramesh G	    PMG2022-MMS-CRF-0002
13/04/2023  43567           SREENADH.M            Ramesh.G      PMG2022-MMS-CRF-0002
27/04/2023  44346           SREENADH.M            Ramesh.G      PMG2022-MMS-CRF-0002
---------------------------------------------------------------------------------------------------------
*/
function CheckDateT(obj){
	
	var locale=document.formDrugCostlyRxByCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.value="";
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

/*function setValueCustTo(obj){
	if(obj.P_CUST_FRM_CODE.value!=null && obj.P_CUST_FRM_CODE.value!=undefined){
		obj.P_CUST_TO_CODE.value=obj.P_CUST_FRM_CODE.value;
	}
}*/

function DateCheck(from,to) {
//Modified against MMS-JU-SCF-0075
/*
    var fromarray;
    var toarray;
    var fromdate =from.value;
    var todate = to.value ;
      if(fromdate.length > 0 && todate.length > 0 ) {
    	fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)){
			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(invaldt);
			to.value="";
			to.focus();
			return false;
		}
		else if(Date.parse(todt) <= Date.parse(fromdt)){		
			validate_date(to,'TO_DATE_LESS_FROM');
			return true;
		}
	}
	return true;
*/
	if(from.value=="" || to.value=="")
	{ 
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].p_language_id.value)) {
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			to.select();
			return false;
		}
	}
	return true;
}
//PMG2022-MMS-CRF-0002 [44346] START
function checkDate(obj,format,locale)
{
	if(obj.value != '') 
	{		
		var fromDt = document.getElementById("p_doc_from_date");
		var toDt = document.getElementById("p_doc_to_date");
		
		if(validDateObj(obj,format,locale))
		{			
			if(fromDt.value != "" || toDt.value != "")
			{
				validateFromToDates(fromDt,toDt,format,locale);
			}
		}		
	}
}

function validateFromToDates(from,to,format,locale)
{
		if(!(from.value == "" ))
		{
			if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(getMessage("START_DATE_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
				if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				   {
					   if(isAfter(to.value,from.value, format, locale))
					   {
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","Common")); 
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("START_DATE_GREATER_SYSDATE","Common")); 
						to.select();
						to.focus();
						return false;
				   }
				}
			}
				
		}
		else
		{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("START_DATE_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
		}
}
//PMG2022-MMS-CRF-0002 [44346] END 
function validate_date(Obj,ref) {
	if (CheckDate(Obj)){
		if(ref == "TO_DT_GR_EQ_FM_DT"){
			from = document.forms[0].dt_to;
			to = document.forms[0].from_dt;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		else if(ref == "TO_DT_GR_EQ_FM_DT1"){
			from = document.forms[0].from_dt;
			to = document.forms[0].dt_to;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		else if(ref == "TO_DATE_LESS_FROM"){
			from = parent.frames[1].document.forms[0].p_doc_to_date;
			to = parent.frames[1].document.forms[0].p_doc_from_date;
			error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
		}
		
		var fromarray;
		var toarray;
		var fromdate = eval(from).value ;
		var todate = eval(to).value ;
		
		if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) {	
				alert(error_id);
				from.value="";
				from.focus();
				return true ;
			}
		}
		return true;
	}
}

function run() {
	var frmObject = f_query_criteria.document.formDrugCostlyRxByCriteria;
	var SiteSpecificYN = frmObject.SiteSpecificYN.value;  // 39764 
	messageFrame.location.href="../../eCommon/jsp/error.jsp?" ;
	//var fields = new Array (frmObject.from_dt,frmObject.dt_to);//frmObject.pract_name,frmObject.specialist,frmObject.p_fm_cust_group_code,frmObject.p_to_cust_group_code,frmObject.p_cust_code,frmObject.P_patient_class,frmObject.policy_from,frmObject.policy_to,
	//var names   = new Array(getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
	
	//if(f_query_criteria.checkFields( fields, names, messageFrame)){
		/*if(!isBefore(frmObject.from_dt.value,frmObject.currentdate.value,"DMY",frmObject.p_language_id.value)){
			var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
			alert(errors);
			return false;*/
	 if(frmObject.p_doc_from_date.value==""){
		alert(getLabel("Common.fromdate.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
		frmObject.p_doc_from_date.focus();
		return false;
	}
	else if(frmObject.p_doc_to_date.value==""){
		alert(getLabel("Common.todate.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
		frmObject.p_doc_to_date.focus();
		return false;
	}
	else if(!isBefore(frmObject.p_doc_from_date.value,frmObject.currentdate.value,"DMY",frmObject.p_language_id.value)){
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	// 39764 START
	if(SiteSpecificYN){
		 if(frmObject.P_CUST_GRP_FRM_DESC.value==""){
		 	//alert(getLabel("ePH.CustomerGroup.label","PH")+" "+getLabel("Common.Cannotbeblank.label","Common"));
			alert(getMessage("CUSTOMER_GROUP_CANNOT_BLANK",'PH'));  //43567
			frmObject.P_CUST_GRP_FRM_DESC.focus();
			return false;
		}
		 if(frmObject.P_CUST_FRM_DESC.value==""){
		        //alert(getLabel("Common.Customer.label","Common")+" "+getLabel("Common.Cannotbeblank.label","Common"));
			alert(getMessage("CUSTOMER_CANNOT_BLANK",'PH'));   //43567
			frmObject.P_CUST_FRM_DESC.focus();
			return false;
		}
	}
	// 39764 END
	var locale = frmObject.locale.value;
	var P_patient_class = frmObject.P_patient_class.value;
	var p_sal_trn_type = "";
	if(P_patient_class=='XT')
		p_sal_trn_type = 'R';
	else if(P_patient_class!="")
		p_sal_trn_type = P_patient_class.substring(0,1);

	frmObject.p_doc_from_date.value=convertDate(frmObject.p_doc_from_date.value,'DMY',locale,"en");
	frmObject.p_doc_to_date.value=convertDate(frmObject.p_doc_to_date.value,'DMY',locale,"en");
	frmObject.P_CUST_TO_CODE.value=frmObject.P_CUST_FRM_CODE.value; //added for MMS-QH-CRF-0110[IN045590] 
	frmObject.p_sal_trn_type.value =p_sal_trn_type;
	var custgrpfrom=frmObject.P_CUST_GRP_FRM_CODE.value;
	var custfrom=frmObject.P_CUST_FRM_CODE.value;
	var custto=frmObject.P_CUST_FRM_CODE.value;
	var fromdate=frmObject.p_doc_from_date.value;
	var todate=frmObject.p_doc_to_date.value;
	var p_sal_trn_type=frmObject.p_sal_trn_type.value;
	//39764 - START
    if(custfrom == "**")
    	custfrom = "";
    if(custto == "**")
    	custto = "";
	// 39764 - END	
	var xmlDoc  = "";
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";

	xmlStr += " custgrpfrom=\""+custgrpfrom+"\"";
	xmlStr += " custfrom=\""+custfrom+"\"";
	xmlStr += " custto=\""+custto+"\"";
	xmlStr += " fromdate=\""+fromdate+"\"";
	xmlStr += " todate=\""+todate+"\"";
	xmlStr += " p_sal_trn_type=\""+p_sal_trn_type+"\"";

	xmlStr +=" /></root>"; 
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhReportsValidation.jsp?validate=Querycount",false);
	xmlHttp.send( xmlDoc ) ;
	var count=eval(xmlHttp.responseText);
	if(count>0)	{
		frmObject.submit();
	}
	else{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")) ;
	}
}

// 39764 START
function customerGroupCodeDescLookup(obj,code,sqlSelect,codeDesc)
{  
	var retVal			=  new String();
	var title			= getLabel("ePH.CustomerGroup.label","PH");
	var target			="";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	
	var lang = document.formDrugCostlyRxByCriteria.p_language_id.value;
	parNameArray[0] ="~LANGUAGE_ID`";
	parValueArray[0]=lang;
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	
	if(codeDesc == '1'){
		target			= document.forms[0].CUST_GRP_FRM_CODE;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = CODE_LINK;
		argArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		target			= document.forms[0].P_CUST_GRP_FRM_DESC;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;
	}
	
	argArray[12]  = "SQL_PH_CUSTOMER_GROUP_SELECT1";
	argArray[13]  = "ePH.Common.PhRepository";
	
	argArray[14]  = parNameArray;
	argArray[15]  = parValueArray;
	retVal      = CommonLookup( title, argArray );
		
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].P_CUST_GRP_FRM_DESC.value = retVal[1];
		document.forms[0].CUST_GRP_FRM_CODE.value = retVal[0];
		document.forms[0].P_CUST_GRP_FRM_CODE.value = retVal[0];
	}
    else
	{
		document.forms[0].P_CUST_GRP_FRM_DESC.value = "";
		document.forms[0].P_CUST_GRP_FRM_CODE.value = "";
		document.forms[0].CUST_GRP_FRM_CODE.value = "";
	} 
	
}

//function customerCodeNameLookup()
function customerCodeNameLookup(obj,code,sqlSelect,codeDesc) //43567
{  
	//var target			= document.forms[0].P_CUST_FRM_DESC;
	var target			= ""; //43567
	var retVal			=  new String();
	var title			= getLabel("Common.Customer.label","Common");
	
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	
	var lang = document.formDrugCostlyRxByCriteria.p_language_id.value;
	var custGroupCd = document.formDrugCostlyRxByCriteria.CUST_GRP_FRM_CODE.value;
	parNameArray[0] ="~CUST_GROUP_CODE`";
	parValueArray[0]=custGroupCd;
	parNameArray[1] ="~LANGUAGE_ID`";
	parValueArray[1]=lang;
	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;

	if(codeDesc == '1'){  // 43567 
		target			= document.forms[0].CUST_FRM_CODE;  // 43567 
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = CODE_LINK; // 43567 START
		argArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		target			= document.forms[0].P_CUST_FRM_DESC;
		argArray[4] = "2,1";
		argArray[5] = target.value;  // 43567 END
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;
	} // 43567 END
	
	argArray[12]  = "SQL_PH_CUSTOMER_SELECT1";
	argArray[13]  = "ePH.Common.PhRepository";
	
	argArray[14]  = parNameArray;
	argArray[15]  = parValueArray;
	retVal      = CommonLookup( title, argArray );
	
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].P_CUST_FRM_DESC.value = retVal[1];
		document.forms[0].P_CUST_FRM_CODE.value = retVal[0];
		document.forms[0].CUST_FRM_CODE.value = retVal[0];
	}
    else
	{
		document.forms[0].P_CUST_FRM_DESC.value = "";
		document.forms[0].CUST_FRM_CODE.value = "";
		document.forms[0].P_CUST_FRM_CODE.value = "";
	} 
	
}
//39764 END

function fnClearCode(obj,obj1){
	obj.value = '';
	obj1.value = '';
}

function getCustomerBasedonCustgrp(obj) {//added for MMS-QH-CRF-0110[IN045590] start
	var frmObject = document.formDrugCostlyRxByCriteria;
	var len=frmObject.P_CUST_FRM_CODE.options.length;
	for(var i=0;i<len;i++) {
		frmObject.P_CUST_FRM_CODE.remove("P_CUST_FRM_CODE");
	}
	var tp = "---"+getLabel("Common.all.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	frmObject.P_CUST_FRM_CODE.add(opt);
	
	var custgrpfrom=obj.value;
	if(custgrpfrom!=""){
		var xmlDoc  = "";
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " custgrpfrom=\""+custgrpfrom+"\"";
		xmlStr +=" /></root>"; 
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PhReportsValidation.jsp?validate=custgrp",false);
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}//added for MMS-QH-CRF-0110[IN045590] end

function loadCustomer(objCode,objDesc){  //added for MMS-QH-CRF-0110[IN045590] start
	var formObj = document.formDrugCostlyRxByCriteria;
	var element = document.createElement('OPTION') ;
	element.value		=  (objCode) ;
	element.text		=  (objDesc) ;
	formObj.P_CUST_FRM_CODE.add(element);
}
function AllowDateFormat(){   //added for MMS-QH-CRF-0110[IN045590] end
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
	   return false;
   }
}

function reset() {
	f_query_criteria.location.href = '../../ePH/jsp/PhDrugCostlyRxByCustomerCriteria.jsp';
	messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
