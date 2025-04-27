 //saved on 02.11.2005
function run() {
	//[IVAD, IV With Additives+fluids(Direct),IVAD----->1
	//IVAA,                                   IVAA----->2
	//IV With Additives+fluids(Admx),     IVID----->3 
	//IVID, IV Intermittent(Direct),      IVIA---->4
	//	IVIA,                                 IVWA----->5
	//IV Intermittent(Admx),
	//IVWA, IV Without Additive]
	var frmObject = f_query_add_mod.document.formPhMednOrderListCriteria;
	if(f_query_add_mod.document.formPhMednOrderListCriteria) {
        if(frmObject.p_order_by.value=="T") {
			var temp=f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order.value;
			//alert(temp);
			if(temp=="IVAD")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="1"
			else if(temp=="IVAA")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="2"
			else if(temp=="IVID")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="3"
			else if(temp=="IVIA")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="4"
			else if(temp=="IVWA")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="5"
			else if(temp=="CO")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="6"
			else if(temp=="TD")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="7"
			else if(temp=="TA")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="8"
			else if(temp=="CD")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="9"
			else if(temp=="CA")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="0"
			else if(temp=="NOR")
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="NULL"
			else
				f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="ALL"
		}
		else{
			f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="ALL"		
		}
		
		var fields= new Array (frmObject.p_facility_code,frmObject.dt_from1,frmObject.dt_to1,frmObject.p_disp_loc_code,frmObject.p_order_status);//changed from dt_from to dt_from1 AND dt_to to dt_to1 for TTM-SCF-0089 [IN:047613]
		var names= new Array (getLabel("Common.FacilityName.label","Common"),getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("ePH.OrderDateTo.label","PH"),getLabel("ePH.DispenseLocation.label","PH"),getLabel("Common.OrderStatus.label","Common"));
		if(checkFields(fields,names,messageFrame) ) {
		if(!f_query_add_mod.ValidateDateTime(f_query_add_mod.document.formPhMednOrderListCriteria.dt_from1, f_query_add_mod.document.formPhMednOrderListCriteria.dt_to1) ) { //changed from dt_from to dt_from1 AND dt_to to dt_to1 for TTM-SCF-0089 [IN:047613]
			alert("PH_FROM_TIME_ALERT","PH"); 
			f_query_add_mod.document.formPhMednOrderListCriteria.dt_from1.select;
		}
		else
			if(f_query_add_mod.CheckString("Drug From", f_query_add_mod.document.formPhMednOrderListCriteria.drug_code, f_query_add_mod.document.formPhMednOrderListCriteria.tdrug_code, messageFrame) ) {
				//ModifyDates();
				//f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="";
				frmObject.drug_name_desc.value=escape(frmObject.drug_name.value);
				frmObject.tdrug_name_desc.value=escape(frmObject.tdrug_name.value);
				var locale = frmObject.p_language_id.value;
				if(locale!='en'){ //Added for Date Conversion for TTM-SCF-0089 [IN:047613] -start
					frmObject.dt_from.value = convertDate(frmObject.dt_from1.value,'DMYHM',locale,'en'); 
					frmObject.dt_to.value = convertDate(frmObject.dt_to1.value,'DMYHM',locale,'en');
				}
				else{
					frmObject.dt_from.value =frmObject.dt_from1.value; 
					frmObject.dt_to.value = frmObject.dt_to1.value; 
				}//Added for Date Conversion for TTM-SCF-0089 [IN:047613] -end
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.formPhMednOrderListCriteria.submit();
				frmObject.drug_name_desc.value=unescape(frmObject.drug_name.value);
				frmObject.tdrug_name_desc.value=unescape(frmObject.tdrug_name.value);
				//}
			}
		}
	}
	
}

function reset() {
	f_query_add_mod.formPhMednOrderListCriteria.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function callDrugSearch(obj,mode) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		if (mode == 1){  
			document.getElementById('drug_code').value	=	escape(arrCodeDesc[0]);
			document.getElementById('drug_name').value	=	escape(arrCodeDesc[1]);
		}
		if (mode == 2){
			document.formPhMednOrderListCriteria.tdrug_code.value	=	escape(arrCodeDesc[0]);
			document.formPhMednOrderListCriteria.tdrug_name.value	=	escape(arrCodeDesc[1]);
		}
		obj.value =	unescape(arrCodeDesc[1]);
	}
}

function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

function ValidateTime(obj){
	fr_dt = document.formPhMednOrderListCriteria.dt_to;
	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.focus;
			return false;
		}
		if (fr_dt.value!=""){
			if(!ValidateDateTime(obj,fr_dt)){
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
				//document.formPhMednOrderListCriteria.dt_to.value="";
				obj.value="";
				return false;
			}
		}
	}
}

function ValidatetoTime(obj){
	fr_dt = document.formPhMednOrderListCriteria.dt_from1;
	if(obj.value!=""){
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.focus;
			return false;
		}
		else{
			if (fr_dt.value!=""){
				if(!ValidateDateTime(fr_dt,obj)){
					alert(getMessage("TO_DT_GR_EQ_FM_DT","PH"));
					obj.select();
					return false;
				}
			}
		}
	}
	return true;
}

function populateDispLocn(facility_id){

	bean_id		=	document.formPhMednOrderListCriteria.bean_id.value;
	bean_name	=	document.formPhMednOrderListCriteria.bean_name.value;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();

    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " facility_id=\""+facility_id+"\"";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","PhRepMednOrdersValidation.jsp",false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= unescape(desc) ;
	document.formPhMednOrderListCriteria.p_disp_loc_code.add(element);
}

function clearList()	{
	var len			= document.formPhMednOrderListCriteria.p_disp_loc_code.options.length;
	for(var i=0;i<len;i++) {
		document.formPhMednOrderListCriteria.p_disp_loc_code.remove("p_disp_loc_code") ;
	}
	var tp = "     --- Select ---       " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	
	document.formPhMednOrderListCriteria.p_disp_loc_code.add(opt);
}

function qryCreate(obj){

	var qryValue ='';

	if(obj.value == "OS"){
		qryValue = "AND B.ORDER_LINE_STATUS IN ('OS','RG','VF')";
	} 
	else if(obj.value == "IR"){
		qryValue = "AND B.ORDER_LINE_STATUS IN ('DP')";
	} 
	else if(obj.value == "CD"){
		qryValue = "AND B.ORDER_LINE_STATUS IN ('DF')";
	}
	document.formPhMednOrderListCriteria.p_orderstatus_qry.value = qryValue;
}

function ModifyDates(){
	var form_obj=f_query_add_mod.document.formPhMednOrderListCriteria;
	var from_date=form_obj.dt_from1.value;
	var to_date=form_obj.dt_to1.value;
	var strDateArray=new Array() ; 
	if(from_date != ''){
		strDateArray = from_date.split(" ");
		form_obj.dt_from1.value=strDateArray[0]+' 00:00';
	}
	if(to_date != ''){
		strDateArray = to_date.split(" ");
		form_obj.dt_to1.value=strDateArray[0]+' 23:59';
	}
}

function showtypeoforder(){
	var form_obj=document.formPhMednOrderListCriteria;
	if(form_obj.p_order_by.value=="T"){
		form_obj.p_type_of_order.disabled=false;
		//document.getElementById("tp1").style.visibility = "visible";
		//document.getElementById("tp2").style.display = "inline";
	}
	else{
		//form_obj.p_type_of_order.value="";
		//f_query_add_mod.document.formPhMednOrderListCriteria.p_type_of_order_val.value="Doesn't Exist"
		form_obj.p_type_of_order.value=" ";
		form_obj.p_type_of_order.disabled=true;
		//document.getElementById("tp1").style.visibility = "hidden";
		//document.getElementById("tp2").style.display = "none";
	}
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhMednOrderListCriteria.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMYHM',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMYHM',locale,'en');
	}
}
