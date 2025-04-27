
var	function_id		= "" ;
var xmlDoc = "" ;
var xmlHttp = new XMLHttpRequest();
var  enableFlag=false;
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactors.jsp?mode=insert' ; 
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/HealthRiskFactorsQueryCriteria.jsp';
}
function reset(){
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();
}
function apply(){

	var formobj= f_query_add_mod.document.HealthRiskFactorsfrm;
	if(formobj != null){
		var fields = new Array (formobj.risk_factor_id,formobj.risk_fact_desc,formobj.factor_type);
		var names = new Array (getLabel("Common.code.label",'common_labels'),getLabel("Common.description.label",'common_labels'),getLabel("eCA.RiskFactorType.label",'CA'));

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			var factorType = formobj.factor_type.value;
			if(factorType=="AG"){
				var fields_ = new Array (formobj.ageGroup_id);
				var names_ = new Array (getLabel("eCA.AgeGrp.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
				 //Age Group
					var agradioButtons=f_query_add_mod.document.getElementsByName("AGRFI");
					for(var i=0;i<agradioButtons.length;i++){
						if(agradioButtons[i].checked)
							formobj.agrfiID.value=agradioButtons[i].value;
					}
					xmlStr ="<root><SEARCH ";
					xmlStr += "module_id=\"AGPATSEX\" " ;
					xmlStr += "sub_code=\""+formobj.ageGroup_id.value+"\" " ;
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "HealthRiskFactorsIntermediate.jsp",false ) ;
					xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
					responseText=xmlHttp.responseText ;
					eval(responseText);

					formobj.submit();
				}
			}else if(factorType=="AL"){
				var fields_ = new Array (formobj.adverse_event_id,formobj.allergen_id);
				var names_ = new Array (getLabel("eCA.AdverseEventType.label",'CA'),getLabel("eCA.Allergen.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
				 //Allergen
					var agradioButtons=f_query_add_mod.document.getElementsByName("ALRFI");
					for(var i=0;i<agradioButtons.length;i++){
						if(agradioButtons[i].checked)
							formobj.allergenRFIId.value=agradioButtons[i].value;
					}
					setPatientSex("A");
					formobj.submit();
				}
			}else if(factorType=="BM"){
				var fields_ = new Array (formobj.weight_desc,formobj.height_desc);
				var names_ = new Array (getLabel("eCA.Weight.label",'CA'),getLabel("eCA.Height.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
				 //BM
					gridValidation(formobj);
				}
			}else if(factorType=="CC"){
				var fields_ = new Array (formobj.complaint_desc);
				var names_ = new Array (getLabel("eCA.ChiefComplaint.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
				 //Chief Complaint
					var agradioButtons=f_query_add_mod.document.getElementsByName("CCRFI");
					for(var i=0;i<agradioButtons.length;i++){
						if(agradioButtons[i].checked)
							formobj.chiefComplaintRFIId.value=agradioButtons[i].value;
					}
					setPatientSex("A");
					formobj.submit();
				}
			}else if(factorType=="CA"){
				var fields_ = new Array (formobj.discreate_desc);
				var names_ = new Array (getLabel("eCA.DiscreteMeasure.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
					// Discrete Measure
						gridValidation(formobj);				
				}
			}else if(factorType=="LB"){
				var fields_ = new Array (formobj.lbCatalog_desc);
				var names_ = new Array (getLabel("eCA.LabResults.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
					// Lab Results
					gridValidation(formobj);
				}
			}else if(factorType=="OR"){
				var fields_ = new Array (formobj.oRCatalog_desc);
				var names_ = new Array (getLabel("eCA.OrderCatalog.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
					// Order Catalog
					gridValidation(formobj);
				}
			}else if(factorType=="PH"){
				var fields_ = new Array (formobj.drug_name);
				var names_ = new Array (getLabel("eCA.DrugName.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
				 //Chief Complaint
					var agradioButtons=f_query_add_mod.document.getElementsByName("PHRFIId");
					for(var i=0;i<agradioButtons.length;i++){
						if(agradioButtons[i].checked)
							formobj.pharmacyRFIId.value=agradioButtons[i].value;
					}
					setPatientSex("A");
					formobj.submit();
				}

			}else if(factorType=="RD"){
				var fields_ = new Array (formobj.rDCatalog_desc);
				var names_ = new Array (getLabel("eCA.Radiology.label",'CA'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
					// Radiology
					gridValidation(formobj);
				}
			}else if(factorType=="TS"){
				var fields_ = new Array (formobj.termSet_desc);
				var names_ = new Array (getLabel("Common.diagnosis.label",'common_labels'));
				if(f_query_add_mod.checkFieldsofMst( fields_, names_, messageFrame))
				{
					// TermSet
					var agradioButtons=f_query_add_mod.document.getElementsByName("TSRFI");
					for(var i=0;i<agradioButtons.length;i++){
						if(agradioButtons[i].checked)
							formobj.termSetRFIId.value=agradioButtons[i].value;
					}
					setPatientSex("A");
					formobj.submit();
				}
			}
		}
	}else{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}
function gridValidation(formobj){
	var countRow= formobj.rowId.value;
	var flag =false;
	loop1:
	for(var i=0;i<=countRow;i++){
		var genderObj			= eval("f_query_add_mod.document.getElementById('gender"+i+"')");						
		if(genderObj!=null){
			var gender			= eval("f_query_add_mod.document.getElementById('gender"+i+"').value");	
			var startAge		= eval("f_query_add_mod.document.getElementById('startAge"+i+"').value");
			var startAgeUnit	= eval("f_query_add_mod.document.getElementById('startAgeUnit"+i+"').value");
			var endAge			= eval("f_query_add_mod.document.getElementById('endAge"+i+"').value");
			var endAgeUnit		= eval("f_query_add_mod.document.getElementById('endAgeUnit"+i+"').value");
			var operator		= eval("f_query_add_mod.document.getElementById('operator"+i+"').value");
			loop2:
			for(var j=0;j<=countRow;j++){
				if(i!=j){
					var genderObj_	= eval("f_query_add_mod.document.getElementById('gender"+j+"')");
					if(genderObj_!=null){	
						var gender_	= eval("f_query_add_mod.document.getElementById('gender"+j+"').value");
						var operator_		= eval("f_query_add_mod.document.getElementById('operator"+j+"').value");
						if(operator==operator_ && ( gender=="A" || gender_=="A" || gender==gender_ ) ){
							var startAge_		= eval("f_query_add_mod.document.getElementById('startAge"+j+"').value");
							var startAgeUnit_	= eval("f_query_add_mod.document.getElementById('startAgeUnit"+j+"').value");
							var endAge_			= eval("f_query_add_mod.document.getElementById('endAge"+j+"').value");
							var endAgeUnit_		= eval("f_query_add_mod.document.getElementById('endAgeUnit"+j+"').value");
							
							var StartAgeDays 	= 0
							var endAgeDays		= 0;
							
							var StartAgeDays_ 	= 0
							var endAgeDays_		= 0;
							
							if(startAgeUnit=="M")
								StartAgeDays = parseInt(startAge) * 30 + 1;
							else if(startAgeUnit=="Y")
								StartAgeDays = parseInt(startAge) * 365 + 1;
							else
								StartAgeDays = parseInt(startAge);
								
							if(endAgeUnit=="M")
								endAgeDays = parseInt(endAge) * 30 - 1;
							else if(endAgeUnit=="Y")
								endAgeDays = parseInt(endAge) * 365 - 1;
							else
								endAgeDays = parseInt(endAge);
								
							if(startAgeUnit_=="M")
								StartAgeDays_ = parseInt(startAge_) * 30 + 1;
							else if(startAgeUnit_=="Y")
								StartAgeDays_ = parseInt(startAge_) * 365 + 1;
							else
								StartAgeDays_ = parseInt(startAge_);
								
							if(endAgeUnit_=="M")
								endAgeDays_ = parseInt(endAge_) * 30 - 1;
							else if(endAgeUnit_=="Y")
								endAgeDays_ = parseInt(endAge_) * 365 - 1;
							else
								endAgeDays_ = parseInt(endAge_);
							
							
							if(StartAgeDays_>StartAgeDays && StartAgeDays_<=endAgeDays){
								flag=true;
								break loop1;
							}else if(endAgeDays_>StartAgeDays && endAgeDays_<=endAgeDays){
								flag=true;
								break loop1;
							}
						}
						
					}
				}
			}
		}
	}
	if(!flag){
		var boolflag = false;
		for(var i=0;i<=countRow;i++){
			var genderObj			= eval("f_query_add_mod.document.getElementById('gender"+i+"')");						
			if(genderObj!=null){
				var operator	= eval("f_query_add_mod.document.getElementById('operator"+i+"').value");				
				var frmValue=eval("f_query_add_mod.document.getElementById('operatorFromValue"+i+"').value");
				if(operator=="B"){
					var toValue=eval("f_query_add_mod.document.getElementById('operatorToValue"+i+"').value");
					if(frmValue=="" || toValue==""){
						boolflag = true;
						break
					}
				}else if(operator=="PV"){
					var increDecre=eval("f_query_add_mod.document.getElementById('operatorIncreDecre"+i+"').value");
					var opeOccur=eval("f_query_add_mod.document.getElementById('operatorOccur"+i+"').value");
					if(frmValue=="" || increDecre=="" || opeOccur==""){
						boolflag = true;
						break
					}
				}else{
					if(frmValue==""){
						boolflag = true;
						break
					}
				}
			}		
		}
		if(!boolflag){
			formobj.submit();
		}else{
			alert("Please enter Mandatory fields.");
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
		}
	}else{
		alert('Conflict in Risk Factor Definition Could Not Proceed. Please Redifine.');
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactors.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactors.jsp?mode=update&risk_factor_id='+f_query_add_mod.document.forms[0].risk_factor_id.value;
	}
	else
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function selectFactoryType(){
	var factType=document.HealthRiskFactorsfrm.factor_type.value;
	var mode=document.HealthRiskFactorsfrm.mode.value;
	if(factType==""){
		document.getElementById("displayGrid_").style.display = 'none';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
	}else if(factType=="AG"){
		document.getElementById("displayGrid_").style.display = 'none';

		document.getElementById("ageGroup_").style='display';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
		populateData(factType,"",mode);
	}else if(factType=="AL"){
		document.getElementById("displayGrid_").style.display = 'none';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style='display';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';

		populateData(factType,"",mode);
	}else if(factType=="BM"){
		document.getElementById("displayGrid_").style='display';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style='display';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
		refreshGrid();
	}else if(factType=="CC"){
		document.getElementById("displayGrid_").style.display = 'none';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style='display';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
	}else if(factType=="CA"){
		document.getElementById("displayGrid_").style='display';
		//document.getElementById("discreteMeasureDisplayGrid_").style.display = 'inline';
		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style='display';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
		refreshGrid();
	}else if(factType=="LB"){
		document.getElementById("displayGrid_").style='display';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style='display';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
		refreshGrid();
	}else if(factType=="OR"){
		document.getElementById("displayGrid_").style='display';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = '';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
		refreshGrid();
	}else if(factType=="PH"){
		document.getElementById("displayGrid_").style.display = 'none';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style='display';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style.display = 'none';
	}else if(factType=="RD"){
		document.getElementById("displayGrid_").style='display';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style='display';
		document.getElementById("termSet_").style.display = 'none';
		document.HealthRiskFactorsfrm.rowId.value = '-1';
		refreshGrid();
	}else if(factType=="TS"){
		document.getElementById("displayGrid_").style.display = 'none';

		document.getElementById("ageGroup_").style.display = 'none';
		document.getElementById("allergy_").style.display = 'none';
		document.getElementById("bmi_").style.display = 'none';
		document.getElementById("chiefComplaint_").style.display = 'none';
		document.getElementById("discreteMeasure_").style.display = 'none';
		document.getElementById("labResult_").style.display = 'none';
		document.getElementById("orderCatalog_").style.display = 'none';
		document.getElementById("pharmacyItems_").style.display = 'none';
		document.getElementById("radiology_").style.display = 'none';
		document.getElementById("termSet_").style='display';
	}


}
function refreshGrid(){
	document.HealthRiskFactorsfrm.rowId.value = '-1';
	deleteAllRows("CADisplayGrid");
	addRowCADisplayGrid("CADisplayGrid","");	
}
function populateData(objValue,subValue,mode,subValue1){
	xmlStr ="<root><SEARCH " ;
	xmlStr += "module_id=\""+objValue+"\" " ;
	xmlStr += "sub_code=\""+subValue+"\" " ;
	xmlStr += "mode=\""+mode+"\" " ;
	xmlStr += "sub_code1=\""+subValue1+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "HealthRiskFactorsIntermediate.jsp",false ) ;
	xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
function clearAgeGroups(mode){
	var len = eval("document.HealthRiskFactorsfrm.ageGroup_id.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.HealthRiskFactorsfrm.ageGroup_id.remove(\"ageGroup_id\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval("document.createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	if(mode!="update")
		eval("document.HealthRiskFactorsfrm.ageGroup_id.add(opt)") ;
}
function addAgeGroups(code,value,mode)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	if(mode=="update"){
		//element.disabled='disabled';
	}
	document.HealthRiskFactorsfrm.ageGroup_id.add(element);
}
function clearAdverseEvents(mode){
	var len = eval("document.HealthRiskFactorsfrm.adverse_event_id.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.HealthRiskFactorsfrm.adverse_event_id.remove(\"adverse_event_id\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval("document.createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	if(mode!="update")
		eval("document.HealthRiskFactorsfrm.adverse_event_id.add(opt)") ;
}
function addAdverseEvents(code,value,mode)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	if(mode=="update"){
		element.disabled='disabled';
		element.selected = true;
	}
	document.HealthRiskFactorsfrm.adverse_event_id.add(element);
}
function setEffStauts(obj){
	if(obj.checked){
		document.HealthRiskFactorsfrm.eff_status.value="E";
	}else{
		document.HealthRiskFactorsfrm.eff_status.value="D";
	}
}
function clearAllergens(mode){
	var len = eval("document.HealthRiskFactorsfrm.allergen_id.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.HealthRiskFactorsfrm.allergen_id.remove(\"allergen_id\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval("document.createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	if(mode!="update")
		eval("document.HealthRiskFactorsfrm.allergen_id.add(opt)") ;
}
function addAllergens(code,value,mode)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	if(mode=="update"){
		element.disabled='disabled';
		element.selected = true;
	}
	document.HealthRiskFactorsfrm.allergen_id.add(element);
}
async function getViewCode(objCode)
{
	var target	= document.forms[0].complaint_desc.value;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.ChiefComplaint.label","ca_labels");

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT COMPLAINT_ID code,COMPLAINT_DESC description FROM CA_CHIEF_COMPLAINT where  ";

	sql=sql+" upper(COMPLAINT_ID) like upper(?) and upper(COMPLAINT_DESC) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		document.forms[0].complaint_id.value=arr[0];
		document.forms[0].complaint_desc.value=arr[1];

	}else{
		document.forms[0].complaint_id.value="";
		document.forms[0].complaint_desc.value="";

	}
}
function addChiefComplaint(code,value){
	document.HealthRiskFactorsfrm.complaint_id.value = code;
	document.HealthRiskFactorsfrm.complaint_desc.value = value;
}

async function getDiscreateId(target)
{
	var target		= document.forms[0].discreate_desc.value;
	var mode 		= document.forms[0].mode.value;
	var locale		= document.forms[0].locale.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.DiscreteMeasure.label","Common");

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "select dm.discr_msr_id code, dm_l.short_desc description from am_discr_msr dm, am_discr_msr_lang dm_l where dm.discr_msr_id=dm_l.discr_msr_id  and dm_l.language_id='"+locale+"'  ";

	sql=sql+"and dm.result_type IN ('C','D','E','N','I','L','H','F')";

	sql=sql+"and upper(dm.discr_msr_id) like upper(?) and upper(dm_l.short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");

		document.forms[0].discreate_id.value=arr[0];
		document.forms[0].discreate_desc.value=arr[1];		
		refreshGrid();
		populateData(factType,arr[0],mode,"0");
	}else{
		document.forms[0].discreate_id.value="";
		document.forms[0].discreate_desc.value="";
	}
}

async function getLBCatalogId(target)
{
	var target		= document.forms[0].lbCatalog_desc.value;
	var locale		= document.forms[0].locale.value;
	var mode 		= document.forms[0].mode.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Lab Results";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT ORDER_CATALOG_CODE code,SHORT_DESC description FROM OR_ORDER_CATALOG_LANG_VW WHERE  LANGUAGE_ID='"+locale+"'  AND ORDER_CATEGORY='LB' AND ORDER_CATALOG_NATURE!='P' ";

	sql=sql+"and upper(ORDER_CATALOG_CODE) like upper(?) and upper(short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		document.forms[0].lbCatalog_id.value=arr[0];
		document.forms[0].lbCatalog_desc.value=arr[1];
		refreshGrid();
		populateData(factType,arr[0],mode,"0");
	}else{
		document.forms[0].lbCatalog_id.value="";
		document.forms[0].lbCatalog_desc.value="";

	}
}
async function getOrderCatalogId(target)
{
	var target	= document.forms[0].oRCatalog_desc.value;
	var locale		= document.forms[0].locale.value;
	var mode 		= document.forms[0].mode.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Order Catalog";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT ORDER_CATALOG_CODE code,SHORT_DESC description FROM OR_ORDER_CATALOG_LANG_VW WHERE ORDER_CATEGORY NOT IN ('LB','RD','PH','CS') AND CHART_RESULT_TYPE !='D' AND ORDER_CATALOG_NATURE!='P' AND  LANGUAGE_ID='"+locale+"' ";

	sql=sql+"and upper(ORDER_CATALOG_CODE) like upper(?) and upper(short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		document.forms[0].oRCatalog_id.value=arr[0];
		document.forms[0].oRCatalog_desc.value=arr[1];
		refreshGrid();
		populateData(factType,arr[0],mode,"0");
	}else{
		document.forms[0].oRCatalog_id.value="";
		document.forms[0].oRCatalog_desc.value="";

	}
}
async function getRDCatalogId(target)
{
	var target	= document.forms[0].rDCatalog_desc.value;
	var locale		= document.forms[0].locale.value;
	var mode 		= document.forms[0].mode.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Radiology";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT ORDER_CATALOG_CODE code,SHORT_DESC description FROM OR_ORDER_CATALOG_LANG_VW WHERE  LANGUAGE_ID='"+locale+"' AND ORDER_CATALOG_NATURE!='P' AND ORDER_CATEGORY='RD' ";

	sql=sql+"and upper(ORDER_CATALOG_CODE) like upper(?) and upper(short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		document.forms[0].rDCatalog_id.value=arr[0];
		document.forms[0].rDCatalog_desc.value=arr[1];
		refreshGrid();
		populateData(factType,arr[0],mode,"0");
	}else{
		document.forms[0].rDCatalog_id.value="";
		document.forms[0].rDCatalog_desc.value="";

	}
}
async function getTermSetCode(target)
{
	var target	= document.forms[0].termSet_desc.value;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Term Set";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT TERM_CODE code,SHORT_DESC description FROM MR_TERM_CODE where ";

	sql=sql+"upper(TERM_CODE) like upper(?) and upper(short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");
		document.forms[0].termSet_code.value=arr[0];
		document.forms[0].termSet_desc.value=arr[1];
	}else{
		document.forms[0].termSet_code.value="";
		document.forms[0].termSet_desc.value="";

	}
}
function setPatientSex(patSex){
	if(patSex=="")patSex="A";
	f_query_add_mod.document.HealthRiskFactorsfrm.patientSex.value=patSex;
}
function addRowCADisplayGrid(tableID,objValue,objValue1){
	var factType		= document.HealthRiskFactorsfrm.factor_type.value;

	var operator_ind 	= document.HealthRiskFactorsfrm.operator_ind.value;
	var mode			=  document.HealthRiskFactorsfrm.mode.value;
	var validate=false;
	var message = null;
	if(objValue!=""){
		if(factType=="CA"){
			var discreateId		= document.HealthRiskFactorsfrm.discreate_id.value;
			if(discreateId=="")
				message ="Please Select Discrete Measure.";
			else
				validate=true;
		}else if(factType=="LB"){
			var catalogId		= document.HealthRiskFactorsfrm.lbCatalog_id.value;
			if(catalogId=="")
				message ="Please Select Lab Results.";
			else
				validate=true;
		}else if(factType=="OR"){
			var catalogId		= document.HealthRiskFactorsfrm.oRCatalog_id.value;
			if(catalogId=="")
				message ="Please Select Order Catalog.";
			else
				validate=true;
		}else if(factType=="RD"){
			var catalogId		= document.HealthRiskFactorsfrm.rDCatalog_id.value;
			if(catalogId=="")
				message ="Please Select Radiology.";
			else
				validate=true;
		}else if(factType=="BM"){
			var bmWeight		= document.HealthRiskFactorsfrm.weight_id.value;
			if(bmWeight=="")
				message ="Please Select Weight.";
			else{				
				var bmHeight		= document.HealthRiskFactorsfrm.height_id.value;
				if(bmHeight=="")
					message ="Please Select Height.";
				else
					validate=true;
			}
		}else{
			validate = true;
		}
	}else{
		validate = true;
	}

	if(validate){
		var rowid=0;
		if(mode=="insert"){
			rowid=document.HealthRiskFactorsfrm.rowId.value;
			rowid = parseInt(rowid)+1;
		}else if( mode=="update"){
			if(objValue1!=undefined){
				rowid=objValue1;
			}else{
				rowid=document.HealthRiskFactorsfrm.rowId.value;
				rowid = parseInt(rowid)+1;
			}
		}
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);
			cell1.className = 'gridData';
		var cell2 = row.insertCell(1);
			cell2.className = 'gridData';
		var cell3 = row.insertCell(2);
			cell3.className = 'gridData';
		var cell4 = row.insertCell(3);
			cell4.className = 'gridData';
		var cell5 = row.insertCell(4);
			cell5.className = 'gridData';
		var cell6 = row.insertCell(5);
			cell6.className = 'gridData';
		var cell7 = row.insertCell(6);
			cell7.className = 'gridData';
		var cell8 = row.insertCell(7);
			cell8.className = 'gridData';
		var cell9 = row.insertCell(8);
			cell9.className = 'gridData';
		var cell10 = row.insertCell(9);
			cell10.className = 'gridData';
		var cell11 = row.insertCell(10);
			cell11.className = 'gridData';
		var cell12 = row.insertCell(11);
			cell12.className = 'gridData';
		var cell13 = row.insertCell(12);
			cell13.className = 'gridData';

		var element1 = document.createElement("input");
			element1.type = "checkbox";
			element1.id  ="cKbox"+rowid;
			element1.name="cKbox"+rowid;
			element1.value=rowid;
		cell1.appendChild(element1);

		/*var element2 = document.createElement("input");
			element2.type = "hidden";
			element2.id="rowNum"+(rowCount-3);
			element2.name="rowNum"+(rowCount-3);
			element2.value=(rowCount-3);
		cell1.appendChild(element2);
		*/
		
		var element3 = document.createElement("select");
			element3.id="gender"+rowid;
			element3.name="gender"+rowid;
			element3.style.width="70px";
				var genderoption1 = document.createElement("option");
					genderoption1.value	= "A";
					genderoption1.text 	= "All";
					element3.add(genderoption1);
				var genderoption2 = document.createElement("option");
					genderoption2.value	= "M";
					genderoption2.text 	= "Male"
					element3.add(genderoption2);
				var genderoption3 = document.createElement("option");
					genderoption3.value	= "F";
					genderoption3.text 	= "Female";
					element3.add(genderoption3);
				var genderoption4 = document.createElement("option");
					genderoption4.value	= "U";
					genderoption4.text 	= "Unknown";
					element3.add(genderoption4);
		cell2.appendChild(element3);

		var element4 = document.createElement("input");
			element4.type = "checkbox";
			element4.id="allAge"+rowid;
			element4.name="allAge"+rowid;
			element4.onclick = function(){clickAllAge(this,rowid);};
			element4.value="";
		cell3.appendChild(element4);

		var element5 = document.createElement("input");
			element5.style.width="30px";
			element5.type = "text";
			element5.id="startAge"+rowid;
			element5.name="startAge"+rowid;
			element5.size="3";
			element5.maxLength="3";
			element5.onkeypress = function(){if(validateNum(event))return true;else return false;};
			element5.readonly= true;
			element5.value="1";
		cell4.appendChild(element5);

		var element6 = document.createElement("select");
			element6.id="startAgeUnit"+rowid;
			element6.name="startAgeUnit"+rowid;
			element6.style.width="70px";
				var startAgeOption1 = document.createElement("option");
					startAgeOption1.value	= "D";
					startAgeOption1.text 	= "Days";
					startAgeOption1.disabled='disabled';
					startAgeOption1.selected = true;
					element6.add(startAgeOption1);
				var startAgeOption2 = document.createElement("option");
					startAgeOption2.value	= "M";
					startAgeOption2.text 	= "Months";
					startAgeOption2.disabled='disabled';
					element6.add(startAgeOption2);
				var startAgeOption3 = document.createElement("option");
					startAgeOption3.value	= "F";
					startAgeOption3.text 	= "Years";
					startAgeOption3.disabled='disabled';
					element6.add(startAgeOption3);
		cell5.appendChild(element6);

		var element7 = document.createElement("input");
			element7.style.width="30px";
			element7.type = "text";
			element7.id="endAge"+rowid;
			element7.name="endAge"+rowid;
			element7.size="3";
			element7.maxLength="3";
			element7.onkeypress = function(){if(validateNum(event))return true;else return false;};
			element7.readonly= true;
			element7.value="150";
		cell6.appendChild(element7);

		var element8 = document.createElement("select");
			element8.id="endAgeUnit"+rowid;
			element8.name="endAgeUnit"+rowid;
			element8.style.width="70px";
				var endAgeOption1 = document.createElement("option");
					endAgeOption1.value	= "D";
					endAgeOption1.text 	= "Days";
					endAgeOption1.disabled='disabled';
					element8.add(endAgeOption1);
				var endAgeOption2 = document.createElement("option");
					endAgeOption2.value	= "M";
					endAgeOption2.text 	= "Months";
					endAgeOption2.disabled='disabled';
					element8.add(endAgeOption2);
				var endAgeOption3 = document.createElement("option");
					endAgeOption3.value	= "F";
					endAgeOption3.text 	= "Years";
					endAgeOption3.disabled='disabled';
					endAgeOption3.selected = true;
					element8.add(endAgeOption3);
		cell7.appendChild(element8);

		var element9= document.createElement("select");
			element9.id="operator"+rowid;
			element9.name="operator"+rowid;
			element9.style.width="110px";
			element9.onchange = function(){operatorChage(this,rowid); return false;};
				/*var operatoOption1 = document.createElement("option");
					operatoOption1.value	= "";
					operatoOption1.text 	= "		---- Select ----	";
					element9.add(operatoOption1);*/
				/*var operatoOption2 = document.createElement("option");
					operatoOption2.value	= "AB";
					operatoOption2.text 	= "Abnormal"
					element9.add(operatoOption2);
				var operatoOption3 = document.createElement("option");
					operatoOption3.value	= "B";
					operatoOption3.text 	= "Between";
					element9.add(operatoOption3);
				var operatoOption4 = document.createElement("option");
					operatoOption4.value	= "E";
					operatoOption4.text 	= "Equal";
					element9.add(operatoOption4);
				var operatoOption5 = document.createElement("option");
					operatoOption5.value	= "L";
					operatoOption5.text 	= "Less";
					element9.add(operatoOption5);
				var operatoOption6 = document.createElement("option");
					operatoOption6.value	= "G";
					operatoOption6.text 	= "Greater";
					element9.add(operatoOption6);
				var operatoOption7 = document.createElement("option");
					operatoOption7.value	= "LE";
					operatoOption7.text 	= "Less or Equal";
					element9.add(operatoOption7);
				var operatoOption8 = document.createElement("option");
					operatoOption8.value	= "GE"
					operatoOption8.text 	= "Greater or Equal";
					element9.add(operatoOption8);
				var operatoOption9 = document.createElement("option");
					operatoOption9.value	= "L";
					operatoOption9.text 	= "Like";
					element9.add(operatoOption9);
				var operatoOption10 = document.createElement("option");
					operatoOption10.value	= "C";
					operatoOption10.text 	= "Contains";
					element9.add(operatoOption10);
				var operatoOption11 = document.createElement("option");
					operatoOption11.value	= "EW";
					operatoOption11.text 	= "Ends With";
					element9.add(operatoOption11);
				var operatoOption12 = document.createElement("option");
					operatoOption12.value	= "NM";
					operatoOption12.text 	= "Normal";
					element9.add(operatoOption12);	*/
		cell8.appendChild(element9);

		//var element14 = document.createElement("&nbsp;");
		//cell9.appendChiled(element14);
		cell9.id="opratorTdId"+rowid;
		cell9.innerHTML = "&nbsp;";

		var element10 = document.createElement("input");
			element10.type = "radio";
			element10.id="riskFactorInd"+rowid;
			element10.name="riskFactorInd"+rowid;
			element10.checked = true;
			element10.value="H";
			element10.onclick = function(){clickriskFactorInd('H',rowid);};
		cell10.appendChild(element10);

		var element11 = document.createElement("input");
			element11.type = "radio";
			element11.id="riskFactorInd"+rowid;
			element11.name="riskFactorInd"+rowid;
			element11.value="A";
			element11.onclick = function(){clickriskFactorInd('A',rowid);};
		cell11.appendChild(element11);

		var element12 = document.createElement("input");
			element12.type = "radio";
			element12.id="riskFactorInd"+rowid;
			element12.name="riskFactorInd"+rowid;
			element12.value="L";
			element12.onclick = function(){clickriskFactorInd('L',rowid);};
		cell12.appendChild(element12);

		var element13 = document.createElement("input");
			element13.style.width="100px";
			element13.type = "text";
			element13.id="remarks"+rowid;
			element13.name="remarks"+rowid;
			element13.value="";
		cell13.appendChild(element13);

		var element14 = document.createElement("input");
			element14.type = "hidden";
			element14.id="riskFactorIndValue"+rowid;
			element14.name="riskFactorIndValue"+rowid;
			element14.value="";
		cell12.appendChild(element14);

		var element15 = document.createElement("input");
			element15.type = "hidden";
			element15.id="allAgeValue"+rowid;
			element15.name="allAgeValue"+rowid;
			element15.value="";
		cell3.appendChild(element15);

		document.HealthRiskFactorsfrm.rowId.value =rowid;
		eval("document.HealthRiskFactorsfrm.allAge"+rowid).checked=true;
		eval("document.HealthRiskFactorsfrm.allAgeValue"+rowid).value="Y";
		eval("document.HealthRiskFactorsfrm.startAge"+rowid).readOnly=true;
		eval("document.HealthRiskFactorsfrm.endAge"+rowid).readOnly=true;

		var agradioButtons=eval('document.HealthRiskFactorsfrm.riskFactorInd'+rowid);
		for(var i=0;i<agradioButtons.length;i++){
			if(agradioButtons[i].value=="H")
				agradioButtons[i].checked=true;
		}
		eval("document.HealthRiskFactorsfrm.riskFactorIndValue"+rowid).value="H";
		setOperators(rowid);

		addOperatorValue(operator_ind,discreateId,mode,rowid);

	}else{
		alert(message);
	}
}
function clickriskFactorInd(objVal,val){
	eval("document.HealthRiskFactorsfrm.riskFactorIndValue"+val).value=objVal;
}
function deleteAllRows(tableID){
	var table = document.getElementById(tableID);
	var rowCount_ = table.rows.length;
		for(var i=3; i<rowCount_; i++) {
				table.deleteRow(i);
				rowCount_--;
				i--;
		}
}
function deleteRowDisplayGrid(tableID){
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	rowCount = rowCount - 3;
	var selectedCheckBoxs=0;

	for(var i=0;i<rowCount;i++){
		if(document.getElementById('cKbox'+i)!=undefined){
			if(document.getElementById('cKbox'+i).checked)
				selectedCheckBoxs++;
		}
	}

	if(rowCount!=selectedCheckBoxs){
		var rowCount_ = table.rows.length;
		for(var i=3; i<rowCount_; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[0].childNodes[0];
			if(null != chkbox && true == chkbox.checked) {
				table.deleteRow(i);
				rowCount_--;
				i--;
			}
		}
	}else{
		alert('Please keep one record...');
	}
}

function clearAgeUnit(objValue){
	eval("document.HealthRiskFactorsfrm."+objValue+".options.length=0") ;
}
function addAgeUnit(code,value,objValue,mode)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	if(mode==true){
		element.disabled='disabled';
	}
	eval("document.HealthRiskFactorsfrm."+objValue+".add(element)");
}

function clickAllAge(obj,val){
	if(obj.checked){
		document.getElementById('allAgeValue'+val).value="Y";
		document.getElementById('startAge'+val).setAttribute('readOnly','readOnly');
		document.getElementById('startAge'+val).value="1";
		clearAgeUnit("startAgeUnit"+val);
		addAgeUnit("D","Days","startAgeUnit"+val,true);
		addAgeUnit("M","Months","startAgeUnit"+val,true);
		addAgeUnit("Y","Years","startAgeUnit"+val,true);

		document.getElementById('endAge'+val).setAttribute('readOnly','readOnly');
		clearAgeUnit("endAgeUnit"+val);
		addAgeUnit("D","Days","endAgeUnit"+val,true);
		addAgeUnit("M","Months","endAgeUnit"+val,true);
		addAgeUnit("Y","Years","endAgeUnit"+val,true);
		eval("document.getElementById('endAge"+val+"')").value="150";
	}else{
		document.getElementById('allAgeValue'+val).value="N";
		document.getElementById('startAge'+val).removeAttribute("readOnly",false);
		clearAgeUnit("startAgeUnit"+val);
		addAgeUnit("D","Days","startAgeUnit"+val,false);
		addAgeUnit("M","Months","startAgeUnit"+val,false);
		addAgeUnit("Y","Years","startAgeUnit"+val,false);

		document.getElementById('endAge'+val).removeAttribute("readOnly",false);
		clearAgeUnit("endAgeUnit"+val);
		addAgeUnit("D","Days","endAgeUnit"+val,false);
		addAgeUnit("M","Months","endAgeUnit"+val,false);
		addAgeUnit("Y","Years","endAgeUnit"+val,false);
	}
	document.getElementById('startAgeUnit'+val).value="D";
	document.getElementById('endAgeUnit'+val).value="Y";
}
function setOperators(val){
	var factType=document.HealthRiskFactorsfrm.factor_type.value;

	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" || factType=="CC"){
		var element8 = document.createElement('OPTION') ;
			element8.value = "E" ;
			element8.text  = "Equal" ;
			document.getElementById('operator'+val).add(element8);
	}
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" || factType=="BM"){
		var element9 = document.createElement('OPTION') ;
			element9.value = "GE" ;
			element9.text  = "Greater Than" ;
			document.getElementById('operator'+val).add(element9);
	}
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" || factType=="CC" || factType=="BM"){
		var element11 = document.createElement('OPTION') ;
			element11.value = "L" ;
			element11.text  = "Less Than" ;
			document.getElementById('operator'+val).add(element11);
	}
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" || factType=="BM"){
		var element10 = document.createElement('OPTION') ;
			element10.value = "LE" ;
			element10.text  = "Less or Equal Than" ;
			document.getElementById('operator'+val).add(element10);
	}
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" || factType=="BM"){
		var element4 = document.createElement('OPTION') ;
			element4.value = "B" ;
			element4.text  = "Between" ;
			document.getElementById('operator'+val).add(element4);
	}
	//var element12 = document.createElement('OPTION') ;
	//	element12.value = "LS" ;
	//	element12.text  = "Like" ;
	//	document.HealthRiskFactorsfrm.adverse_event_id.add(element12);
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" || factType=="CC"){
		var element6 = document.createElement('OPTION') ;
			element6.value = "C" ;
			element6.text  = "Contains" ;
			document.getElementById('operator'+val).add(element6);
	}
	
	//Start With
	
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" ){
		var element7 = document.createElement('OPTION') ;
			element7.value = "EW" ;
			element7.text  = "End With" ;
			document.getElementById('operator'+val).add(element7);
	}
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="BM" ){
		var element15 = document.createElement('OPTION') ;
			element15.value = "PV" ;
			element15.text  = "Perentage Variance" ;
			document.getElementById('operator'+val).add(element15);
	}
	
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" ){
		var element1 = document.createElement('OPTION') ;
			element1.value = "AB" ;
			element1.text  = "Abnormal" ;
			document.getElementById('operator'+val).add(element1);
	}
	if(factType=="AG" || factType=="PH"  || factType=="TS" ){
		var element2 = document.createElement('OPTION') ;
			element2.value = "AC" ;
			element2.text  = "Active" ;
			document.getElementById('operator'+val).add(element2);
	}
	if(factType=="AG" || factType=="PH"  || factType=="TS" ){
		var element3 = document.createElement('OPTION') ;
			element3.value = "AL" ;
			element3.text  = "ALL" ;
			document.getElementById('operator'+val).add(element3);
	}
	
	//var element5 = document.createElement('OPTION') ;
	//	element5.value = "CL" ;
	//	element5.text  = "Closed" ;
	//	document.HealthRiskFactorsfrm.adverse_event_id.add(element5);

	if(factType=="AG"){
		var element13 = document.createElement('OPTION') ;
			element13.value = "NN" ;
			element13.text  = "None" ;
			document.getElementById('operator'+val).add(element13);
	}
	if(factType=="LB" || factType=="CA"  || factType=="OR" || factType=="RD" ){
		var element14 = document.createElement('OPTION') ;
			element14.value = "NM" ;
			element14.text  = "Normal" ;
			document.getElementById('operator'+val).add(element14);
	}
	
	

}

function addOperatorValue(objValue,subValue,mode,val){
	document.HealthRiskFactorsfrm.operator_ind.value=objValue;
	if(subValue=="B"){
		if(objValue=="I"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)'/>&nbsp;-&nbsp;<input type='text' id='operatorToValue"+val+"' name='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="N"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input type='text' id='operatorToValue"+val+"' name='operatorToValue"+val+"' id='operatorToValue"+val+"' value=''  onkeypress='return CheckForSpecCharsNoCaps_new(event)'/>"
		}else if(objValue=="C"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input type='text' id='operatorToValue"+val+"' name='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="L"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input type='text' id='operatorToValue"+val+"' name='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="H"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value=''  onkeypress='return CheckForSpecCharsNoCaps_new(event)'/>&nbsp;-&nbsp;<input type='text' id='operatorToValue"+val+"' name='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="D"){
				document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' id='operatorFromValue"+val+"' size=10  maxlength=10   value=''  onBlur=\"CheckDate(this);\"><input type='image' id=adm_cal1  src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate1('opratorValue"+val+"');\"> &nbsp; - &nbsp; <input type='text' name='operatorToValue"+val+"' id='operatorToValue"+val+"' id='operatorToValue"+val+"'  size=10 maxlength=10   value=''  onBlur=\"CheckDate(this);\"><input type='image' id=adm_cal1  src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate1('opratorValue"+val+"_');\">"
		}else if(objValue=="E"){
				document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"'  id='operatorFromValue"+val+"' size='14'  value='' OnBlur='CheckDateTime(this)' OnKeyPress=\"return CheckForNumsAndColon(event)\" maxlength='16'>&nbsp;<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick=\"return showCalendarValidate('opratorValue"+val+"')\" >&nbsp; - &nbsp; <input type='text' size='14'  name='operatorToValue"+val+"' id='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' OnBlur='CheckDateTime(this)' OnKeyPress=\"return CheckForNumsAndColon(event)\" maxlength='16'>&nbsp;<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick=\"return showCalendarValidate('opratorValue"+val+"_')\" >"
		}else{
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input type='text' id='operatorToValue"+val+"' name='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}
	}else if(subValue=="PV"){
		
		if(objValue=="I"){
			document.getElementById('opratorTdId'+val).innerHTML ="<select name='operatorIncreDecre"+val+"' id='operatorIncreDecre"+val+"'><option value='I'>Increase</option><option value='D'>Decrease</option><option value='E'>Equal</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:40px;' type='text' id='operatorOccur"+val+"' name='operatorOccur"+val+"' id='operatorOccur"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input style='width:40px;' type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;<B>%</B>"
		}else if(objValue=="N"){
			document.getElementById('opratorTdId'+val).innerHTML ="<select name='operatorIncreDecre"+val+"' id='operatorIncreDecre"+val+"'><option value='I'>Increase</option><option value='D'>Decrease</option><option value='E'>Equal</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:40px;' type='text' id='operatorOccur"+val+"' name='operatorOccur"+val+"' id='operatorOccur"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input style='width:40px;' type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;<B>%</B>"
		}else if(objValue=="C"){
			document.getElementById('opratorTdId'+val).innerHTML ="<select name='operatorIncreDecre"+val+"' id='operatorIncreDecre"+val+"'><option value='I'>Increase</option><option value='D'>Decrease</option><option value='E'>Equal</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:40px;' type='text' id='operatorOccur"+val+"' name='operatorOccur"+val+"' id='operatorOccur"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input style='width:40px;' type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;<B>%</B>"
		}else if(objValue=="L"){
			document.getElementById('opratorTdId'+val).innerHTML ="<select name='operatorIncreDecre"+val+"' id='operatorIncreDecre"+val+"'><option value='I'>Increase</option><option value='D'>Decrease</option><option value='E'>Equal</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:40px;' type='text' id='operatorOccur"+val+"' name='operatorOccur"+val+"' id='operatorOccur"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input style='width:40px;' type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;<B>%</B>"
		}else if(objValue=="H"){
			document.getElementById('opratorTdId'+val).innerHTML ="<select name='operatorIncreDecre"+val+"' id='operatorIncreDecre"+val+"'><option value='I'>Increase</option><option value='D'>Decrease</option><option value='E'>Equal</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:40px;' type='text' id='operatorOccur"+val+"' name='operatorOccur"+val+"' id='operatorOccur"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input style='width:40px;' type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;<B>%</B>"
		}else if(objValue=="D"){
				document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' id='operatorFromValue"+val+"' size=10  maxlength=10   value=''  onBlur=\"CheckDate(this);\"><input type='image' id=adm_cal1  src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate1('opratorValue"+val+"');\"> &nbsp; - &nbsp; <input type='text' name='operatorToValue"+val+"' id='operatorToValue"+val+"' id='operatorToValue"+val+"'  size=10 maxlength=10   value=''  onBlur=\"CheckDate(this);\"><input type='image' id=adm_cal1  src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate1('opratorValue"+val+"_');\">"
		}else if(objValue=="E"){
				document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"'  id='operatorFromValue"+val+"' size='14'  value='' OnBlur='CheckDateTime(this)' OnKeyPress=\"return CheckForNumsAndColon(event)\" maxlength='16'>&nbsp;<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick=\"return showCalendarValidate('opratorValue"+val+"')\" >&nbsp; - &nbsp; <input type='text' size='14'  name='operatorToValue"+val+"' id='operatorToValue"+val+"' id='operatorToValue"+val+"' value='' OnBlur='CheckDateTime(this)' OnKeyPress=\"return CheckForNumsAndColon(event)\" maxlength='16'>&nbsp;<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick=\"return showCalendarValidate('opratorValue"+val+"_')\" >"
		}else{
			
			document.getElementById('opratorTdId'+val).innerHTML ="<select name='operatorIncreDecre"+val+"' id='operatorIncreDecre"+val+"'><option value='I'>Increase</option><option value='D'>Decrease</option><option value='E'>Equal</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:40px;' type='text' id='operatorOccur"+val+"' name='operatorOccur"+val+"' id='operatorOccur"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;-&nbsp;<input style='width:40px;' type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />&nbsp;<B>%</B>"
		}
	}else{
		if(objValue=="I"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)'  />"
		}else if(objValue=="N"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="C"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="L"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value=''onkeypress='return CheckForSpecCharsNoCaps_new(event)'  />"
		}else if(objValue=="H"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)' />"
		}else if(objValue=="D"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' size=10 maxlength=10  id='operatorFromValue"+val+"' value=''  onBlur=\"CheckDate(this);\"><input type='image' id=adm_cal1  src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate1('opratorValue"+val+"');\">"
		}else if(objValue=="E"){
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' size='14'  name='operatorFromValue"+val+"' id='operatorFromValue"+val+"'  id='operatorFromValue"+val+"' value='' OnBlur='CheckDateTime(this)' OnKeyPress=\"return CheckForNumsAndColon(event)\" maxlength='16'>&nbsp;<input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick=\"return showCalendarValidate('opratorValue"+val+"')\" >"
		}else{
			document.getElementById('opratorTdId'+val).innerHTML ="<input type='text' id='operatorFromValue"+val+"' name='operatorFromValue"+val+"' id='operatorFromValue"+val+"' value='' onkeypress='return CheckForSpecCharsNoCaps_new(event)'  />"
		}
	}
	
}

function showCalendarValidate(str){

	var flg = showCalendarHRF(str,null,'hh:mm');
	eval("document.HealthRiskFactorsfrm."+str).focus();
    return flg;
}
function showCalendarValidate1(str){

	var flg = showCalendarHRF(str,null,null);
	eval("document.HealthRiskFactorsfrm."+str).focus();
    return flg;
}
function showCalendarHRF(id, date_format,time_format) {
	var el 		= eval("document.HealthRiskFactorsfrm."+id);
	var isModal	=	"isDiv";
	var timeSet	=	"";
	if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
		timeSet="dd/mm/yyyy" ;
	else
		timeSet=date_format ;

	if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
		timeSet = timeSet +' '+ time_format;

	if ( ( ! document.getElementById("CACalanderFun") ) && ( document.getElementById(id).type !='hidden') )
		//eval("document.HealthRiskFactorsfrm."+id).blur();
		  document.getElementById(id).blur();

	if(enableFlag)
			return false ;
	else
		enableFlag=true;

	showInModalHRF(el,timeSet);
	return false;

}
async function showInModalHRF(args,timeSet){
	var dialogHeight= "500px" ;
	var dialogWidth	= "800px" ;
	var status = "no";
	var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
	var  dateValue= await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);

	var formatedDate = dateValue;
	if(formatedDate==undefined)
		args.value= "";
	else
		args.value =formatedDate;

	if ( ( ! document.getElementById("CACalanderFun") ) && (args.type !='hidden') )
	args.focus();
	enableFlag=false;
}
function CheckForNumsAndColon(event){
    var strCheck = '0123456789:/ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function CheckDateTime(objText,admDtChk)
{
	var locale		= document.HealthRiskFactorsfrm.locale.value;
	if(objText.value !='')
	{
		if(isBeforeNow(objText.value,"DMYHM",locale))
		{
			if(doDateTimeChk(objText.value)==false)
			{
				alert(getMessage("INVALID_DATE_TIME","CA"));
				objText.select();
				objText.focus();
				return false;
			}
		}
		if(!validDateObj(objText,"DMYHM",locale))
		{
			return false
		}
		if(!(isBeforeNow(objText.value,"DMYHM",locale) ))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			objText.select();
			objText.focus();
			return false;
		}
	}
}
function getDescripMsrDtls(code,val){
	document.HealthRiskFactorsfrm.discreate_id.value = code;
	document.HealthRiskFactorsfrm.discreate_desc.value = val;
}
function operatorChage(obj,val){
	var operator_ind = document.HealthRiskFactorsfrm.operator_ind.value;
	var mode = document.HealthRiskFactorsfrm.mode.value;
	addOperatorValue(operator_ind,obj.value,mode,val);
}
function setfactorSetIdCode(val,val1){
	document.HealthRiskFactorsfrm.factor_set_id.value = val;
	document.HealthRiskFactorsfrm.factor_code.value = val1;
}
function setLBOrderCataLogDtls(code,val){
	document.HealthRiskFactorsfrm.lbCatalog_id.value = code;
	document.HealthRiskFactorsfrm.lbCatalog_desc.value = val;
}
function setOROrderCataLogDtls(code,val){
	document.HealthRiskFactorsfrm.oRCatalog_id.value = code;
	document.HealthRiskFactorsfrm.oRCatalog_desc.value = val;
}
function setRDOrderCataLogDtls(code,val){
	document.HealthRiskFactorsfrm.rDCatalog_id.value = code;
	document.HealthRiskFactorsfrm.rDCatalog_desc.value = val;
}

async function searchForDrug(target)
{
	var target		= document.HealthRiskFactorsfrm.drug_name.value;
	var mode 		= document.forms[0].mode.value;
	var locale		= document.forms[0].locale.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="Pharmacy Items";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "SELECT GENERIC_ID CODE,GENERIC_NAME DESCRIPTION FROM PH_GENERIC_NAME_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  ";

	sql=sql+" AND UPPER(GENERIC_ID) LIKE UPPER(?) AND UPPER(GENERIC_NAME) LIKE UPPER(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");

		document.HealthRiskFactorsfrm.drug_id.value=arr[0];
		document.HealthRiskFactorsfrm.drug_name.value=arr[1];
		document.HealthRiskFactorsfrm.factor_set_id.value = "PH";
		document.HealthRiskFactorsfrm.factor_code.value = "PH";
	}else{
		document.HealthRiskFactorsfrm.drug_id.value="";
		document.HealthRiskFactorsfrm.drug_name.value="";
		document.HealthRiskFactorsfrm.factor_set_id.value = "PH";
		document.HealthRiskFactorsfrm.factor_code.value = "PH";
	}
}
function setPharmacyDtls(code,val){
	document.HealthRiskFactorsfrm.drug_id.value=code;
	document.HealthRiskFactorsfrm.drug_name.value=val;
}
async function show_diagnosis()
{
	var term_set_id = document.HealthRiskFactorsfrm.diagnosisSet_code.value;
	var mode 		= document.HealthRiskFactorsfrm.mode.value;
	var locale		= document.HealthRiskFactorsfrm.locale.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	if(term_set_id!=""){
		var p_auth_yn = "N";
		var retVal =    new String();
		var dialogHeight= "700px" ;
		var dialogWidth = "1200px" ;
		var status = "no";
		var arguments = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		
		retVal = await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?term_set_id="+term_set_id+"&termsetid="+term_set_id,arguments,features);
		
		if(retVal != null){
			populateData(factType,retVal,mode,term_set_id);
		}
	}else{
		alert("Please Select Diagnosis Set.");
	}
}
function setTermCodeDesc(code,val){
	document.HealthRiskFactorsfrm.termSet_code.value=code;
	document.HealthRiskFactorsfrm.termSet_desc.value=val;
}
async function getWeightDiscreateId(target)
{
	var target		= document.forms[0].weight_desc.value;
	var mode 		= document.forms[0].mode.value;
	var locale		= document.forms[0].locale.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="BMI";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "select dm.discr_msr_id code, dm_l.short_desc description from am_discr_msr dm, am_discr_msr_lang dm_l where dm.discr_msr_id=dm_l.discr_msr_id  and dm_l.language_id='"+locale+"'  ";

	sql=sql+"and upper(dm.discr_msr_id) like upper(?) and upper(dm_l.short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");

		document.forms[0].weight_id.value=arr[0];
		document.forms[0].weight_desc.value=arr[1];
		refreshGrid();
		populateData(factType,arr[0],mode,"0");
	}else{
		document.forms[0].weight_id.value="";
		document.forms[0].weight_desc.value="";
	}
}
async function getHeightDiscreateId(target)
{
	var target		= document.forms[0].height_desc.value;
	var mode 		= document.forms[0].mode.value;
	var locale		= document.forms[0].locale.value;
	var factType	= document.HealthRiskFactorsfrm.factor_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="BMI";

	var retVal				=  new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

	sql = "select dm.discr_msr_id code, dm_l.short_desc description from am_discr_msr dm, am_discr_msr_lang dm_l where dm.discr_msr_id=dm_l.discr_msr_id  and dm_l.language_id='"+locale+"'  ";

	sql=sql+"and upper(dm.discr_msr_id) like upper(?) and upper(dm_l.short_desc) like upper(?) ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );

	var arr=new Array();

	if(retVal != null && retVal != "" ){
		var retVal=unescape(retVal);
		arr=retVal.split(",");

		document.forms[0].height_id.value=arr[0];
		document.forms[0].height_desc.value=arr[1];
		refreshGrid();
		populateData(factType,arr[0],mode,"0");
	}else{
		document.forms[0].height_id.value="";
		document.forms[0].height_desc.value="";
	}
}
function setBMIWeightDtls(code,val){
	document.HealthRiskFactorsfrm.weight_id.value=code;
	document.HealthRiskFactorsfrm.weight_desc.value=val;
}
function setBMIHeightDtls(code,val){
	document.HealthRiskFactorsfrm.height_id.value=code;
	document.HealthRiskFactorsfrm.height_desc.value=val;
}
function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
function validateNum(event){	
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function CheckForSpecCharsNoCaps_new(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*. ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
function displayLable(str,str1){
	var disValue="";
	if(str=='C')
		disValue="Check Box";
	else if(str=='D')
		disValue="Date";
	else if(str=='E')
		disValue="Date / Time";
	else if(str=='N')
		disValue="Decimal Numeric";
	else if(str=='P')
		disValue="Embedded Component";
	else if(str=='A')
		disValue="Formula";
	else if(str=='R')
		disValue="Grid Component";
	else if(str=='I')
		disValue="Integer Numeric";
	else if(str=='L')
		disValue="List";
	else if(str=='F')
		disValue="Long Text";
	else if(str=='X')
		disValue="Matrix Component";
	else if(str=='H')
		disValue="Short Text";
	else if(str=='S')
		disValue="SummaryComponent";
	else if(str=='T')
		disValue="Time";
	document.getElementById(str1).innerHTML = 'Component Type : <B>'+disValue+"</B>";
}
//[IN039490] Start.
function clearTermSetDtl(){
	document.HealthRiskFactorsfrm.termSet_desc.value="";
	document.HealthRiskFactorsfrm.termSet_code.value="";
}
//[IN039490] End.

