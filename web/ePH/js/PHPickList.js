var result		= false ;
var message		= "" ;
var flag		= "" ; 
var store_code	= "" ;
var scheduleDate=new Date();
var excludeHours;

function submitDispense(dcode){
	
	if (dcode==""){
		clearValues();
		//disableAll(true);
	//	document.formPHPickList.allocate_during_fill_yn.checked=false;
		return;
	}
	clearValues();
	var bean_id		= document.formPHPickList.bean_id.value ;
	var bean_name	= document.formPHPickList.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH/></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "IpFillDispenseLocation.jsp?function=DispenseLocationSelectforpicklist&bean_id=" + bean_id + "&bean_name=" + bean_name +  "&dispense_code=" + dcode, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
}


function clearValues(){
	var	frm=document.formPHPickList;
	//nursingUnitLocationChange(frm.nursing_unit_or_locn,document);
	frm.Nursing_Unit.value	  = "";
	frm.patient_id.value	  = "";
	frm.Nursing_Unit_From_Code.value	  = "";
	frm.Nursing_Unit_To_Code.value		  = "";
	frm.Fill_Period_Unit.value			  = "";
	frm.fill_int_end_date_time.value	  = "";
	frm.fill_int_start_date_time.value	  = "";	
}


async function NursingUnitSearch( target ) {
	var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
	var language_id    = document.formPHPickList.language_id.value;
	var sql="SELECT A.NURSING_UNIT_CODE code,SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW A WHERE  A.FACILITY_ID LIKE ? AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=";
	var ordering_facility_id = document.formPHPickList.OrderingFacility.options[document.formPHPickList.OrderingFacility.selectedIndex].value;
	
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;

	argumentArray[0]   = sql+"'"+language_id+"' order by code";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal=await CommonLookup(getLabel("Common.NursingUnitSearch.label","Common"), argumentArray );
	if (retVal!=""){
    var ret1=unescape(retVal);
                    arr=ret1.split(",");
		target.value = arr[1];
		if (target.name=="Nursing_Unit"){
			document.formPHPickList.Nursing_Unit_From_Code.value=arr[0];
		}
	}
}

async function callPatientSearch(target)
{

	var patient_id	=	document.formPHPickList.patient_id;
	var retun_value =	"";
	return_value	=	await PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}


async function viewpickList()
{
	var formObj = document.formPHPickList;
	var disp_locn_code			 = formObj.disp_locn_code.value;
	var	nursing_unit_or_locn	 = formObj.nursing_unit_or_locn.value; // value hardcoded N stand for Nursing Unit
	var compound_drug_ind		 = formObj.compound_drug_ind.value; // value hardcoded B stand for Both Compound as (Single + Compound)
	var disp_locn_desc			 = formObj.disp_locn_code.options[formObj.disp_locn_code.selectedIndex].text;
	var OrderingFacility_code	 = formObj.OrderingFacility.value;
	var OrderingFacility_desc	 = formObj.OrderingFacility.options[formObj.OrderingFacility.selectedIndex].text;
	var	Nursing_Unit	 = formObj.Nursing_Unit.value;
	var	Nursing_Unit_From_Code	 = formObj.Nursing_Unit_From_Code.value; 
	if(Nursing_Unit==""){
		Nursing_Unit=getLabel("Common.Highest.label","Common");
	}
	var	Nursing_Unit_From		 = formObj.Nursing_Unit_From_Code.value;
	var	patient_id		 = formObj.patient_id.value;
	//var Nursing_Unit_To			 = formObj.Nursing_Unit_To_Code.value;
	var fill_int_start_date_time = formObj.fill_int_start_date_time.value;
	var fill_int_end_date_time	 = formObj.fill_int_end_date_time.value;
	var ip_fill_prd_unit			= formObj.Fill_Period_Unit.value;
	var val							= formObj.fill_int_start_date_time.value;
	var arr							= val.split(" ");
	var cut_off_limit_for_new_ord	= arr[1];
	if(Nursing_Unit_From!= "" && disp_locn_code!=""){
		
		//if(parent.f_generatefilllist.CheckString(getLabel("Common.NursingUnitDetails.label","Common"), document.formPHPickList.Nursing_Unit_From, document.formPHPickList.Nursing_Unit_To, parent.messageFrame)){
			var dialogHeight= "42vh" ;
			var dialogWidth	= "64vw" ;
			var dialogTop = "" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal = await top.window.showModalDialog("../../ePH/jsp/PHViewPickListFrames.jsp?Nursing_Unit_From="+Nursing_Unit_From+"&disp_locn_code="+disp_locn_code+"&disp_locn_desc="+disp_locn_desc+"&fill_int_start_date_time="+fill_int_start_date_time+"&fill_int_end_date_time="+fill_int_end_date_time+"&Nursing_Unit="+Nursing_Unit+"&ip_fill_prd_unit="+ip_fill_prd_unit+"&cut_off_limit_for_new_ord="+cut_off_limit_for_new_ord+"&OrderingFacility_desc="+OrderingFacility_desc+"&nursing_unit_or_locn="+nursing_unit_or_locn+"&compound_drug_ind="+compound_drug_ind+"&OrderingFacility_code="+OrderingFacility_code+"&patient_id="+patient_id+"&Nursing_Unit_From_Code="+Nursing_Unit_From_Code,arguments,features);
			//alert("retVal--->"+retVal);
			if(retVal != '' && retVal != undefined){
				var retResult = retVal.split("~");
				if(retResult.length > 1) {
					flag=retResult[0];
					message=retResult[1];
				}
				else
				flag=retResult[0];
				//flag = retVal;
				message = retVal;
				onSuccess();
			}else{
				parent.f_generatefilllist.location.href = "../../ePH/jsp/PHPickListFrames.jsp";
			   }
			
	  // }//end CheckString	Method 
	} else {
		
		if(disp_locn_code === ""){
			alert(getMessage('PH_DISPENSE_LOCATION','PH'));
			return;
		}
		if(Nursing_Unit_From === ""){
			alert(getMessage('PH_NURSING_CANNOT_BLANK','PH'));
			return;	
		}
	}
	
}


function genPickList(){
	var flag1=true;
    var selectArray  = new Array() ;
    var patArray  = new Array() ;
    var orderArray  = new Array() ;
    var patient_id="";
    var order_id="";
    var checkbox ="";
    var rec_count=parent.fill_list.document.formPHViewFillList.total_patients.value;
	var Nursing_Unit_From_Code=parent.fill_list.document.formPHViewFillList.Nursing_Unit_From_Code_grn.value;
	var fill_int_end_date_time=parent.fill_list.document.formPHViewFillList.fill_int_end_date_time_grn.value;
	var fill_int_start_date_time=parent.fill_list.document.formPHViewFillList.fill_int_start_date_time_grn.value;
	var facility_id=parent.fill_list.document.formPHViewFillList.facility_id.value;
	var disp_locn_code=parent.fill_list.document.formPHViewFillList.store_code.value;
	var formObj = document.formPHViewFillList;
	var print_picklist_date="";
	var printpatient_orderdetails="#";
	var Orderwise_print_picklist_date="";
	var patient_orderdetail = new Array() ;
	var print_picklist_date_array = new Array() ;
	var remain_dosage_for_strip="";
	var remain_dosage = new Array();
	var Orderwise_remain_dosage="";
	for(i=0;i<rec_count;i++)
	{  
		
		if(eval("parent.fill_list.document.formPHViewFillList.select_patients"+i).checked){
			patient_id=eval("parent.fill_list.document.formPHViewFillList.patient_id_check"+i).value;
			
			order_id=eval("parent.fill_list.document.formPHViewFillList.order_id_"+patient_id);
			if (typeof order_id === 'undefined' || order_id === null || (typeof order_id !== 'object') || (typeof order_id.length === 'undefined')) {
				order_id = [order_id]; 
				}
			
			if (typeof printpatient_orderdetails === 'undefined' || printpatient_orderdetails === null || (typeof printpatient_orderdetails !== 'object') || (typeof printpatient_orderdetails.length === 'undefined')) {
				printpatient_orderdetails = [printpatient_orderdetails]; 
				}
			printpatient_orderdetails="#"+patient_id+"@@@";
				for (var j = 0;j < order_id.length; j++) 
				{
					orderArray.push(order_id[j].value.replace(/'/g, ''));
					printpatient_orderdetails += "'" + order_id[j].value.replace(/'/g, '') + "'";
					if (j < order_id.length - 1) {
		                printpatient_orderdetails += ',';
		            }
					//printpatient_orderdetails=printpatient_orderdetails+","+order_id[j].value;
				}

				patient_orderdetail.push(printpatient_orderdetails);
			flag1=false;
			}
		}
	 if(flag1==true)
	    alert(getMessage('PH_ATLEAST_ONE_SELECTED','PH'));
	 else
	{
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var bean_id   = parent.fill_list.document.formPHViewFillList.bean_id.value
	    var bean_name = parent.fill_list.document.formPHViewFillList.bean_name.value
		xmlStr ="<root><SEARCH " ;
		xmlStr += "orderArray=\""+ orderArray +"\" " ;
		xmlStr += "patient_orderdetail=\""+ patient_orderdetail +"\" " ;
		xmlStr += "Nursing_Unit_From_Code=\""+ Nursing_Unit_From_Code +"\" " ;
		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PHPickListIntermediate.jsp?function=GENERATEPICKlIST&bean_id=" + bean_id + "&bean_name=" + bean_name+ "&facility_id=" + facility_id+ "&fill_int_end_date_time=" + fill_int_end_date_time+ "&fill_int_start_date_time=" + fill_int_start_date_time+ "&Nursing_Unit_From_Code=" + Nursing_Unit_From_Code+ "&patient_orderdetail=" + patient_orderdetail+ "&disp_locn_code=" + disp_locn_code   , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ; 
		eval( responseText ) ;
		window.returnValue = flag+'<BR>'+message;
		window.close();
	}
}


function clearTextFlds(){
	document.formPHPickList.p_fr_nurs_unit.value="";
	document.formPHPickList.p_to_nurs_unit.value="";
}
function reset() {
	f_picklist.formPHPickList.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function validateProcessDt(obj){
	var from = obj;
	var to = document.forms[0].sys_dt;

	var flag = ValidateDateTime(from ,to)
	if(!flag){
		alert(getMessage(" !!! ...Cannot be grater than sysdate","Common"));
		//obj.focus();
		//obj.select();
	}
}


async function onSuccess(){
	if(message != '')
		flag = flag
	parent.messageFrame.location.href		= "../../eCommon/jsp/error.jsp?err_num=<br> <B>"+getMessage("PH_PICKLISTGEN_IS","PH") +"</B>";
	parent.f_picklist.location.href = "../../ePH/jsp/PHPickList.jsp";
	//disp_locn_code=document.formPHPickList.disp_locn_code.value
    //proc_type	= document.formPHPickList.Proc_Type.value ;
	//var fill_proc_id		= flag.split("<BR>");	f_picklist
	var dialogHeight	= "35vh";//"34" ;
	var dialogWidth		= "50vw" ;
	var dialogTop		= "100" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	//retVal				= window.showModalDialog( "../../ePH/jsp/IpFillOnlineReport.jsp?disp_locn_code="+disp_locn_code+"&flag="+fill_proc_id[0]+"&proc_type="+proc_type, arguments, features );
}


function assignResult( result1, message1, flag1 ,temp) {
	result	= result1 ;
    message	= message1 ;
    flag	= flag1 ;
}
