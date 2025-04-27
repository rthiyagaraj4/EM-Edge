//saved on 22/10/2005
var currClass="";
var selectedStressFactor=""; 
var selectedStressFactorWeight="";
var selectedEnergyProvided ="";
var selectedProtein="";  
var selectedProteinWeight="";
var selectedLipid="";
var selectedLipidWeight="";
var selectedFluidRequired="";
var defaultStress ="";
var defaultStressFactorWeight="";
var defaultRecoEnergy="";
var defaultFluidRequired="";
var defaultEnergyProvided="";
var defaultProtein="";
var defaultProteinWeight="";
var defaultLipid="";
var defaultLipidWeight="";
var calcEnergyFlag = 0;
var calcMacroNutFlag = 0;
var tempEnergyProvided ="";
var lastClicked="";
/*To traverse between tabs - Assessment, Standard Regimen....*/
function change_tab_buttons(str){

	//alert(parent.parent.frames[1].document.forms[0].name);
	var patient_id		= document.formTPNRegimenOptions.patient_id.value;
	var weight		= document.formTPNRegimenOptions.patient_weight.value;
	var height		= document.formTPNRegimenOptions.patient_height.value;
	var encounter_id = document.formTPNRegimenOptions.encounter_id.value;
	var bean_id = document.formTPNRegimenOptions.bean_id.value;
	var bean_name = document.formTPNRegimenOptions.bean_name.value;
	var qs			 = document.formTPNRegimenOptions.QueryString.value;
	var bed_num		 = document.formTPNRegimenOptions.bed_num.value;//added for ML-MMOH-CRF-1089
	
	if ((weight=="") || (height=="") || parseFloat(weight) <= 0){
		alert(getMessage("PH_WEIGHT_REQUIRED","PH"));
		return;
	}
	
   	if(str=="tpnregimenassesment"){
	parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegimenAssesmentFrame.jsp?patient_id="+patient_id+"&weight="+weight+"&height="+height+"&encounter_id="+encounter_id+"&bed_num="+bed_num;
	}else if(str=="stdregimen"){
		
/*
		var cho_energy	=	parent.document.frames[1].document.tpnRegimenAssessment.CHO_ENERGY.value;
		var pro_energy	=	parent.document.frames[1].document.tpnRegimenAssessment.PRO_ENERGY.value;
		var lipd_energy	=	parent.document.frames[1].document.tpnRegimenAssessment.LIPD_ENERGY.value;
		var cho_qty		=	parent.document.frames[1].document.tpnRegimenAssessment.CHO_QTY.value;
		var pro_qty		=	parent.document.frames[1].document.tpnRegimenAssessment.PRO_QTY.value;
		var lipd_qty	=	parent.document.frames[1].document.tpnRegimenAssessment.LIPD_QTY.value;
		var fluid		=	parent.document.frames[1].document.tpnRegimenAssessment.fluidReq.value;
		var fluidunit   =	parent.document.frames[1].document.tpnRegimenAssessment.fluid_unit.value;
		
*/

        var cho_energy	=  "0";	 
		var pro_energy	=  "0";
		var lipd_energy	=  "0";
		var cho_qty		=  "0";
		var pro_qty		=  "0";
		var lipd_qty	=  "0";
		var fluid		=  "0";
		var fluidunit   = "ML";

		qs=qs+"&cho_energy="+cho_energy+"&pro_energy="+pro_energy+"&lipd_energy="+lipd_energy+"&cho_qty="+cho_qty+"&pro_qty="+pro_qty+"&lipd_qty="+lipd_qty+"&fluid="+fluid+"&fluidunit="+fluidunit;
		parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegStdRegFrames.jsp?"+qs; 
	}else if(str=="nonstdregimen"){
	   
		parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegNonStdRegFrames.jsp?"+qs;
	}else if(str=="tpn_regimen"){
		alert(getLabel("ePH.UnderConstruction.label","PH"));
//		alert("Under Construction");
	}
}

/*To call modal window on click of the Current Rx*/
async function callCurrentMedication(patient_id, encounter_id, generic_id) {
	if(generic_id == undefined)
	generic_id="";
	var dialogHeight	= "30vh";
	var dialogWidth		= "50vw";
	var dialogTop		= "250";
	var center			= "1";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	var retVal			= await window.showModalDialog("../jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id,arguments,features);
}

/*To change color of tabs - Assessment, Standard Regimen....*/
/*function changeButtonColor(obj,from_name)
{
	if(from_name=="PH_BUTTONS"){
		cellref = parent.f_header.document.prescription_header_form.all.tab.rows(0).cells
		version_no = parent.f_header.document.prescription_header_form.version_no.value;
		}
	else if(from_name=="COMMON")
		cellref = document.getElementById("tab").rows(0).cells
	if(version_no==3) check_val = 4; else check_val = 2;
	for(i=0; i<cellref.length; i++)
	{
		if(i!=check_val && i!=(check_val+1)){
		if(cellref[i].id!="dummy")
		cellref[i].className = 'CAFIRSTSELECTHORZ';
		}
	}
	obj.className = "CASECONDSELECTHORZ";
	currClass ="CASECONDSELECTHORZ";
}*/

function changeButtonColor(obj,from_name,buttonname)
{   
	if(from_name=="PH_BUTTONS"){
		//if(am == "amend"){
		//	cellref = parent.f_options.document.formTPNRegimenOptions.all.tab.rows(0).cells
		//}
		//else
		//{
		cellref = parent.f_tpnregimenselect.document.getElementById('tab').rows[0].cells
		//}
		//version_no = parent.f_tpnregimenselect.document.formTPNRegimenOptions.version_no.value;
		}
	else if(from_name=="COMMON")
		cellref = document.getElementById("tab").rows(0).cells
	
	if ( (buttonname=="nonstdregimen" && lastClicked=="stdregimen")||(buttonname=="stdregimen" && lastClicked=="nonstdregimen"))
	{	     
			res=confirm(getMessage("PH_DISPENSE_DATA_MODIFIED","PH"));
			if (!res)
			{
				return false;
			}
	}
	//check_val=2;
	for(i=0; i<cellref.length; i++)
	{
		//if(i!=check_val && i!=(check_val+1)){
			if(cellref[i].id!="dummy"){
				cellref[i].className = 'CAFIRSTSELECTHORZ';
			}
		//}
	}
	obj.className = "CASECONDSELECTHORZ";
	currClass ="CASECONDSELECTHORZ";

lastClicked=buttonname;
change_tab_buttons(buttonname)


}

/*To change color of tabs on mouse over*/
function callOnMouseOver(obj){
	//alert("mouseOver");
	currClass = obj.className ;
	obj.className = 'CASECONDSELECTHORZ';
}

/*To change color of tabs on mouse out */
function callOnMouseOut(obj,name){

	if (lastClicked!=name)
	{
			obj.className = currClass;
	}

}

function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }

    // get the string
    outString = inString.substring(startPos, endPos + 1);

    return outString;
}



/*called on change of values of Fluid required*/
function checkEnergyLimits(min, max,obj, def){
	var val = obj.value;
	var flag = true;
	if(isNaN(val)){
		alert(getMessage("ONLY_NUMERIC_ALLOWED","PH"));
		obj.value = def;
		obj.focus();
		flag=false;
	}
	if(val < min){
		//alert("Energy Value below permissible limit");
		alert(getMessage("ENERGY_VALUE_BELOW_LIMIT","PH"));
		obj.value = def;
		obj.focus();
		flag=false;
	}
	if(val > max){
		alert(getMessage("ENERGY_ABOVE_LIMIT","PH"));
		obj.value = def;
		obj.focus();
		flag=false;
	}
	if(flag){
		obj.value = trimString(val);
		selectedFluidRequired = trimString(val);
		if((document.tpnRegimenAssessment.energyProv.value == defaultEnergyProvided)&&(val == def)&&(selectedLipid == defaultLipid)&&(selectedLipidWeight == defaultLipidWeight)&&(selectedProtein == defaultProtein)&&(selectedProteinWeight == defaultProteinWeight)&&(defaultFluidRequired==selectedFluidRequired)){
			calcMacroNutFlag = 0;
		}else{
			calcMacroNutFlag = 1;
		}
	}else{
		calcMacroNutFlag = 0;
	}
}

/*called on click of Reset Button*/
function resetDefault(){
	var patient_id = document.tpnRegimenAssessment.patient_id.value;
	var weight		= document.tpnRegimenAssessment.patient_weight.value;
	var height		= document.tpnRegimenAssessment.patient_height.value;
	var encounter_id = document.tpnRegimenAssessment.encounter_id.value;
	parent.f_tpnregimen.location.href="../../ePH/jsp/TPNRegimenAssesmentFrame.jsp?patient_id="+patient_id+"&weight="+weight+"&height="+height+"&encounter_id="+encounter_id;
}

/*called onload to store all default values*/
function defaultValues(){
	//var stressObj = document.tpnRegimenAssessment.tags("SELECT").item(0);
	var stressObj = document.tpnRegimenAssessment.stressFactor;
	for(i=0;i<stressObj.options.length;i++){
		if(stressObj.options(i).selected){
			defaultStress = stressObj.options(i).text;
		}
	}
	defaultStressFactorWeight = stressObj.value;
//	alert(document.tpnRegimenAssessment.recoEnergy.value);
	defaultRecoEnergy = document.tpnRegimenAssessment.recoEnergy.value;
	defaultFluidRequired = document.tpnRegimenAssessment.fluidReq.value;
	selectedFluidRequired = document.tpnRegimenAssessment.fluidReq.value;
	defaultEnergyProvided = document.tpnRegimenAssessment.energyProv.value;
	tempEnergyProvided = defaultEnergyProvided;
	selectedEnergyProvided = document.tpnRegimenAssessment.energyProv.value;
	//var proteinObj = document.tpnRegimenAssessment.tags("SELECT").item(1);
	var proteinObj = document.tpnRegimenAssessment.protein;
	for(i=0;i<proteinObj.options.length;i++){
		if(proteinObj.options(i).selected){
			defaultProtein = proteinObj.options(i).text;
			selectedProtein =  proteinObj.options(i).text;
		}
	}
	defaultProteinWeight = proteinObj.value;
	selectedProteinWeight = proteinObj.value;
	//var lipidObj = document.tpnRegimenAssessment.tags("SELECT").item(2);
	var lipidObj = document.tpnRegimenAssessment.lipid;
	for(i=0;i<lipidObj.options.length;i++){
		if(lipidObj.options(i).selected){
			defaultLipid = lipidObj.options(i).text;
			selectedLipid = lipidObj.options(i).text;
		}
	}
	defaultLipidWeight = lipidObj.value;
	selectedLipidWeight = lipidObj.value;
	document.tpnRegimenAssessment.calc_energy_by[0].checked=true;
	document.tpnRegimenAssessment.protein[1].selected = true;
	document.tpnRegimenAssessment.lipid[1].selected = true;	
}

/*called on stress Factor change*/
function stressFactorChange(obj){

if(document.tpnRegimenAssessment.calc_energy_by[0].checked == true)
	{

		for(i=0;i<obj.options.length;i++){
			if(obj.options(i).selected){
				selectedStressFactor = obj.options(i).text;
			}
		}
		selectedStressFactorWeight = obj.value;
		if(calcEnergyFlag==0)
			calcEnergyFlag = 1;
		if(calcMacroNutFlag==0)
			calcMacroNutFlag = 1;
		calcEnergyFlag = 1;
		calcMacroNutFlag = 1;

		if(selectedStressFactor == defaultStress){
			document.tpnRegimenAssessment.recoEnergy.value = defaultRecoEnergy;
			document.tpnRegimenAssessment.energyProv.value = defaultRecoEnergy;
			tempEnergyProvided = defaultRecoEnergy;
			calcEnergyFlag = 0;
			//calcMacroNutFlag = 0;
		}
		formobj=document.tpnRegimenAssessment;
		weight=formobj.patient_weight.value;
		height=formobj.patient_height.value;
		sex=formobj.patient_sex.value;
		age=formobj.patient_age.value;
		calculateRecommendedEnergy(weight,height,sex,age);
	}
	else
	{
		calRecommenedEnergy();
	}
}

/*called on click of Calculate Recommended Energy Button*/
function calculateRecommendedEnergy(weight,height,sex,age){
//	alert("calculating recommend"+calcEnergyFlag +" "+ calcMacroNutFlag);
	var recenergy;
	var totcalreq;
	calcEnergyFlag = 0;
	calcMacroNutFlag = 1;
//	alert("selected stress factor is"+selectedStressFactor + " " +defaultStress );
	//alert("sex is"+sex);
	if(selectedStressFactor != defaultStress && selectedStressFactor !=""){
		if(sex=="M"){
			recenergy  = 66.5 + (13.75 * weight ) + (5.003 * height) - (6.775 * age);
			recenergy = Math.ceil(recenergy);
		//	alert("Male"+recenergy);			
		}
		if(sex=="F"){
			recenergy = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
			recenergy = Math.ceil(recenergy);
	//		alert("feMale"+recenenergy);
		}
//		alert("stress factor is"+selectedStressFactorWeight);
		totcalreq = recenergy * selectedStressFactorWeight;
		document.tpnRegimenAssessment.recoEnergy.value = totcalreq;
		document.tpnRegimenAssessment.energyProv.value = totcalreq;
		selectedEnergyProvided = totcalreq;
		tempEnergyProvided = totcalreq;
	}
}

/*called on change of value of Energy Provided*/
function energyProvidedChange(){
	calcMacroNutFlag = 1;
	var val = document.tpnRegimenAssessment.energyProv.value;
	if(val<=0||val==""){
		alert(getMessage("ENER_TO_PRO_CANNOT_BLANK","PH"));
//		alert("Value should be more than 0");
		document.tpnRegimenAssessment.energyProv.focus;
		document.tpnRegimenAssessment.energyProv.value = document.tpnRegimenAssessment.recoEnergy.value;
	}
	if(isNaN(val)){
		alert(getMessage("ONLY_NUMERIC_ALLOWED","PH"));
//		alert("Only Numeric values allowed");
		document.tpnRegimenAssessment.energyProv.focus;
		document.tpnRegimenAssessment.energyProv.value = document.tpnRegimenAssessment.recoEnergy.value;
	}
	selectedEnergyProvided = document.tpnRegimenAssessment.energyProv.value;
	tempEnergyProvided = selectedEnergyProvided;
	if((document.tpnRegimenAssessment.energyProv.value ==defaultEnergyProvided)&&(selectedLipid == defaultLipid)&&(selectedLipidWeight == defaultLipidWeight)&&(selectedProtein == defaultProtein)&&(selectedProteinWeight == defaultProteinWeight)&&(defaultFluidRequired==selectedFluidRequired)){
		calcMacroNutFlag = 0;
	}else{
		calcMacroNutFlag = 1;
	}
}

/*called of change of Protein select change*/
function proteinChange(obj,unit){
	
	calcMacroNutFlag = 1;

	for(i=0;i<obj.options.length;i++){
		if(obj.options(i).selected){
			selectedProtein = obj.options(i).text;
			//alert("hai1:"+obj.value);
			//tab.rows(3).cells(2).innerText = obj.value+" "+unit; 
			document.getElementById("ProteinValue").innerText = obj.value+" "+unit; 
		}
	}
	
	selectedProteinWeight = obj.value;
	if((document.tpnRegimenAssessment.energyProv.value ==defaultEnergyProvided)&&(selectedProtein == defaultProtein)&&(selectedProteinWeight == defaultProteinWeight)&&(selectedLipid == defaultLipid)&&(selectedLipidWeight == defaultLipidWeight)&&(defaultFluidRequired==selectedFluidRequired)){
			calcMacroNutFlag = 0;
	}else{
		calcMacroNutFlag = 1;
	}

}

/*called of change of Lipid select change*/
function lipidChange(obj,unit){
	calcMacroNutFlag = 1;

	for(i=0;i<obj.options.length;i++){
		if(obj.options(i).selected){
			selectedLipid = obj.options(i).text;
			//alert("from 2:"+obj.value);
			//tab.rows(3).cells(5).innerText ="  "+obj.value+" "+unit;
			document.getElementById("LipidValue").innerText = obj.value+" "+unit;
		}
	}
	selectedLipidWeight = obj.value;
	if((document.tpnRegimenAssessment.energyProv.value ==defaultEnergyProvided)&&(selectedLipid == defaultLipid)&&(selectedLipidWeight == defaultLipidWeight)&&(selectedProtein == defaultProtein)&&(selectedProteinWeight == defaultProteinWeight)&&(defaultFluidRequired==selectedFluidRequired)){
		calcMacroNutFlag = 0;
	}else{
		calcMacroNutFlag = 1;
	}
}

/*called on click of Calculate Macro Nutrients*/
function calculateMacroNutrients(weight, proteinValueUnit, lipidValueUnit){
	//alert(calcEnergyFlag);
	if(calcEnergyFlag == 0){
		calcMacroNutFlag = 0;
		selectedEnergyProvided = document.tpnRegimenAssessment.energyProv.value;
		proteinVal = document.tpnRegimenAssessment.protein.value;
		lipidVal = document.tpnRegimenAssessment.lipid.value;
		var xmlStr ="";
		var bean_id = document.tpnRegimenAssessment.bean_id.value;
		var bean_name = document.tpnRegimenAssessment.bean_name.value;
		var func_mode ="getData";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var calcByHBF = "";
	if(document.tpnRegimenAssessment.calc_energy_by[0].checked == true)
		calcByHBF = "Y";
	else
		calcByHBF = "N";

	var carboPerc = document.tpnRegimenAssessment.carbohydrate.value;
	var lipidPerc = document.tpnRegimenAssessment.lipid1.value;
	var proteinPerc	= document.tpnRegimenAssessment.protein1.value;


	var iStressFactorIndex =document.tpnRegimenAssessment.stressFactor.selectedIndex;
	var iBodyWeightIndex;
	for(var i=0;i<document.tpnRegimenAssessment.body_weight.length;i++)
		if(document.tpnRegimenAssessment.body_weight[i].checked== true)
			iBodyWeightIndex = i;
	var sEnergy = document.tpnRegimenAssessment.energy.value;
	var sRecoEnergy =  document.tpnRegimenAssessment.recoEnergy.value;
	var sFluid = document.tpnRegimenAssessment.fluidReq.value;
	var sEnergyProvided = document.tpnRegimenAssessment.energyProv.value;
	var iProteinSelIndex = document.tpnRegimenAssessment.protein.selectedIndex;
	var iLipidSelIndex = document.tpnRegimenAssessment.lipid.selectedIndex;
	var bActFactor = document.tpnRegimenAssessment.incld_actvt_factor.checked;

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert("TPNAssessmentDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&selectedEnergyProvided="+selectedEnergyProvided+ "&proteinVal=" + proteinVal+ "&lipidVal=" + lipidVal+ "&weight=" + weight+ "&proteinValueUnit=" + proteinValueUnit+ "&lipidValueUnit=" + lipidValueUnit);
	xmlHttp.open( "POST", "TPNAssessmentDetails.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&calcByHBF="+calcByHBF+"&carboPerc="+carboPerc+"&lipidPerc="+lipidPerc+"&proteinPerc="+proteinPerc+"&selectedEnergyProvided="+selectedEnergyProvided+ "&proteinVal=" + proteinVal+ "&lipidVal=" + lipidVal+ "&weight=" + weight+ "&proteinValueUnit=" + proteinValueUnit+ "&lipidValueUnit=" + lipidValueUnit +"&iStressFactorIndex="+ iStressFactorIndex +"&iBodyWeightIndex="+ iBodyWeightIndex +"&sEnergy="+ sEnergy +"&sRecoEnergy="+ sRecoEnergy +"&sFluid="+ sFluid +"&sEnergyProvided="+ sEnergyProvided +"&iProteinSelIndex="+ iProteinSelIndex +"&iLipidSelIndex="+ iLipidSelIndex +"&bActFactor="+ bActFactor,false) ;

	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText) ;
	recordData(bean_id,bean_name)
			
	}else{
		//alert("Not clicked Calculate Energy Button after Stress Factor change");
		alert(getMessage("NOT_CLICKED_CALC_ENERGY_AFTER_STRESS_FACTOR","PH"));
	}
}

function assignMacroNutrients(proteinEnergy,lipidEnergy,carboEnergy,proteinEnergyUnit,lipidEnergyUnit,carboEnergyUnit,proteinStrengthVal,lipidStrengthVal,carboStrengthVal,proteinOrderQuantityVal,lipidOrderQuantityVal,carboOrderQuantityVal,proteinValueUnit,lipidValueUnit){
	

	//alert(tab.name);

	document.getElementById("CarboEnergy").innerText = carboEnergy+" "+carboEnergyUnit;
	document.tpnRegimenAssessment.CHO_ENERGY.value=carboEnergy;

	document.getElementById("CarboOrdQtyVal").innerText = carboOrderQuantityVal+" "+proteinValueUnit+"/Day";
	document.tpnRegimenAssessment.CHO_QTY.value=carboOrderQuantityVal;

	document.getElementById("CarboStnVal").innerText = carboStrengthVal +" "+proteinValueUnit+" /kg";

	document.getElementById("ProteinEnergy").innerText = proteinEnergy+" "+proteinEnergyUnit;
	document.tpnRegimenAssessment.PRO_ENERGY.value=proteinEnergy;

	document.getElementById("ProteinOrdQtyVal").innerText = proteinOrderQuantityVal+" "+proteinValueUnit+"/Day";
	document.tpnRegimenAssessment.PRO_QTY.value=proteinOrderQuantityVal;

	document.getElementById("ProteinStnVal").innerText = proteinStrengthVal +" "+proteinValueUnit+" /kg";

	document.getElementById("LipidEnergy").innerText = lipidEnergy+" "+lipidEnergyUnit;
	document.tpnRegimenAssessment.LIPD_ENERGY.value=lipidEnergy;

	document.getElementById("LipidOrdQtyVal").innerText = lipidOrderQuantityVal+" "+lipidValueUnit+"/Day";
	document.tpnRegimenAssessment.LIPD_QTY.value=lipidOrderQuantityVal;

	document.getElementById("LipidStnVal").innerText = lipidStrengthVal+" "+lipidValueUnit+" /kg";

	if( carboEnergy < 0){
		alert(getMessage("PH_TPN_CARBOHYDRATE_NOT_NAGATIVE","PH"));
		document.tpnRegimenAssessment.energyProv.select();
		document.tpnRegimenAssessment.energyProv.focus();
		//return false;
	}

/*
			for(i=1;i<tab.rows.length;i++){
				for(j=1;j<tab.rows(i).cells.length;j++){
					if(i==j==1){
						tab.rows(i).cells(j).innerText = carboEnergy+" "+carboEnergyUnit;
						document.tpnRegimenAssessment.CHO_ENERGY.value=carboEnergy;
					}
					if(i==1 && j==2){
						if( carboEnergy < 0){
							alert(getMessage("PH_TPN_CARBOHYDRATE_NOT_NAGATIVE","PH"));
							document.tpnRegimenAssessment.energyProv.select();
							document.tpnRegimenAssessment.energyProv.focus();
							return false;
						}
						tab.rows(i).cells(j).innerText = carboOrderQuantityVal+" "+proteinValueUnit+"/Day";
						document.tpnRegimenAssessment.CHO_QTY.value=carboOrderQuantityVal;
					}
					if(i==1 && j==3){
						tab.rows(i).cells(j).innerText = carboStrengthVal +" "+proteinValueUnit+" /kg";
					}
					if(i==2 && j==1){
						tab.rows(i).cells(j).innerText = proteinEnergy+" "+proteinEnergyUnit;
						document.tpnRegimenAssessment.PRO_ENERGY.value=proteinEnergy;
					}
					if(i==2 && j==2){
						tab.rows(i).cells(j).innerText = proteinOrderQuantityVal+" "+proteinValueUnit+"/Day";
						document.tpnRegimenAssessment.PRO_QTY.value=proteinOrderQuantityVal;
					}
					if(i==2 && j==3){
						tab.rows(i).cells(j).innerText = proteinStrengthVal +" "+proteinValueUnit+" /kg";
					}
					if(i==3 && j==1){
						tab.rows(i).cells(j).innerText = lipidEnergy+" "+lipidValueUnit;
						document.tpnRegimenAssessment.LIPD_ENERGY.value=lipidEnergy;
					}
					if(i==3 && j==2){
						tab.rows(i).cells(j).innerText = lipidOrderQuantityVal+" "+lipidValueUnit+"/Day";
						document.tpnRegimenAssessment.LIPD_QTY.value=lipidOrderQuantityVal;
					}
					if(i==3 && j==3){
						tab.rows(i).cells(j).innerText = lipidStrengthVal+" "+lipidValueUnit+" /kg";
					}
				}
			}
			*/

}


/*called on click of Record Button*/
function recordData(bean_id,bean_name){

	//alert("Inside recordData..."+bean_name);
	//alert(calcEnergyFlag +" "+ calcMacroNutFlag);
	var xmlStr ="";
	//var bean_id = formObj.bean_id.value;
	//var bean_name = formObj.bean_name.value;
	if((tempEnergyProvided == defaultEnergyProvided)&&(selectedLipid == defaultLipid)&&(selectedLipidWeight == defaultLipidWeight)&&(selectedProtein == defaultProtein)&&(selectedProteinWeight == defaultProteinWeight)&&(defaultFluidRequired==selectedFluidRequired)){
		calcMacroNutFlag = 0;
	}
	if((calcEnergyFlag == 0) &&(calcMacroNutFlag == 0)){
		
	////Added encodeURIComponet for getting data into thai language regarding incident num:23718-reopen on 27/Sept/2010---By Sandhya
		xmlStr+="&Carbohydrate_Energy="+ document.getElementById("CarboEnergy").innerText;

		xmlStr+="&Cabohydrate_Order_Quantity="+encodeURIComponent(CarboOrdQtyVal.innerText,"UTF-8") ; 
		
		

		xmlStr+="&Cabohydrate_Strength_Weight=" + CarboStnVal.innerText;

		xmlStr+="&Protein_Energy=" + ProteinEnergy.innerText ;

		xmlStr+="&Protein_Order_Quantity=" + encodeURIComponent(ProteinOrdQtyVal.innerText,"UTF-8"); 

		xmlStr+="&Protein_Strength_Weight=" + ProteinStnVal.innerText;

		xmlStr+="&Lipid_Energy=" + LipidEnergy.innerText;

		xmlStr+="&Lipid_Order_Quantity=" + encodeURIComponent(LipidOrdQtyVal.innerText,"UTF-8");

		xmlStr+="&Lipid_Strength_Weight=" + LipidStnVal.innerText;

		xmlStr+= "&bean_id=" + bean_id;
		xmlStr+= "&bean_name=" + bean_name;
		
		var temp_jsp="TPNAssessmentRecord.jsp?func_mode=record_data"+xmlStr;
		
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var Str="<root><SEARCH " ;
		Str+="tmp"+"=\""+ "tmp" +"\" " ;
		Str+=" /></root>" ;
		xmlDoc.loadXML(Str);
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
//alert(responseText);
		calcEnergyFlag =0;
		calcMacroNutFlag =0;
	}else{
		if(calcEnergyFlag != 0){
//			alert("Not clicked Calculate Energy Button after Stress Factor change");
			alert(getMessage("NOT_CLICKED_CALC_ENERGY_AFTER_STRESS_FACTOR","PH"));
		}
		if(calcMacroNutFlag != 0){
//			alert("Not clicked Calculate MacroNutrients Button after data change");
			alert(getMessage("NOT_CLICKED_CALC_ENERGY_AFTER_DATA_CHANGE","PH"));
		}
	}
}

function roundTwoDigits(a)
{
			var a=a+"";
			
			//alert("befor round the number"+a);
		//	alert(a.indexOf("."));
			if (a.indexOf(".")==-1)
			{
				bb=a.substr(0,a.length);
			}
			else
			{
				bb=a.substr(a.indexOf("."),a.length);
				if (bb.length>3)
				{
					bb=a.substr(0,a.indexOf(".")+3);
				}
				else
				{
					bb=a;
				}
			
			}

			return bb;
	}
async function callActiveOrdersforTPN(patient_id,encounter_id,generic_id)	{
	if(generic_id==undefined)
		generic_id="";
	
	var dialogHeight= "40vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "0" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/PrescriptionActiveOrderDetailsFrame.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&generic_id="+generic_id+"&called_frm=PH",arguments,features);

}



async function showDrugProfileforTPN(patient_id,called_frm){
    //alert("comes to js"+patient_id);
	var pat_class	=	document.formTPNRegimenOptions.patient_class.value;
	var dialogHeight	= "40vh";//"34" ;
	var dialogWidth		= "50vw" ;
	var dialogTop		= "" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				= await window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&pat_class="+pat_class+"&called_frm=Prescription", arguments, features );
}

 async function ScreeningDetails(patient_id,encounter_id,patient_class,accession_num,note_type,date_of_birth,sex,tpn_screening_type){
    if(tpn_screening_type=="N")
	{
	var function_id="SPCL_NOTE";
    BeforeCheckNoteType(encounter_id,note_type,patient_id)
	var accession_num  =  document.formTPNRegimenOptions.accession_num.value;
	window.open("../../eCA/jsp/RecClinicalNotesModal.jsp?patient_id="+escape(patient_id)+"&encounter_id="+encounter_id+"&note_type="+note_type+"&patient_class="+patient_class+"&accession_num="+accession_num+"&function_id="+function_id+"&appl_task_id=PH_NOTES",null,"height=650,width=1010,top=75,left=0,resizable=yes,status=yes,toolbar=no,menubar=no,location=no");
	}
	else if(tpn_screening_type=="D")
	{
	   BeforeCheckDiscrete(encounter_id,note_type,patient_id)
	   var test_observ_dt_tm  =  document.formTPNRegimenOptions.test_observ_dt_tm.value;
	   var mode="";
	   var module_id="PH";
	   var ca_practitioner_id="";
	   if(test_observ_dt_tm=='')
	   {
		   mode="I";
	   }else{
		mode="U";
		} 
	  //alert("mode---->"+mode);
	   var dialogHeight	= "34vh" ;
	   var dialogWidth	= "50vw" ;
	   var dialogTop	= "100" ;
	   var center		= "1" ;
	   var status		= "no";
	   var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	   var arguments	= "" ;
	   retVal			= await window.showModalDialog( "../../ePH/jsp/DisDataChartingFrame.jsp?date_of_birth="+date_of_birth+"&patient_id="+escape(patient_id)+"&sex="+sex+"&mode="+mode+"&last_record_date="+test_observ_dt_tm+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&battery_id="+note_type+"&module_id="+module_id+"&patient_class="+patient_class+"&ca_practitioner_id="+ca_practitioner_id, arguments, features );

	 }
}

function BeforeCheckDiscrete(encounter_id,note_type,patient_id)
  {
	
	 //alert("encounter_id--->"+encounter_id)
	// alert("note_type--->"+note_type)
	 //alert("patient_id--->"+patient_id)
	var bean_id="TPNRegimenBean";
	var bean_name="ePH.TPNRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","TPNAssessmentDetails.jsp?encounter_id="+encounter_id+"&note_type="+note_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=Discrete",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText)
  }

 function beforDiscrete(test_observ_dt_tm){
	   document.formTPNRegimenOptions.test_observ_dt_tm.value=test_observ_dt_tm;  
  }


 function BeforeCheckNoteType(encounter_id,note_type,patient_id)
  {
	
	var bean_id="TPNRegimenBean";
	var bean_name="ePH.TPNRegimenBean";
	
	var xmlStr 			="<root><SEARCH /></root>";
	var xmlDoc			= "";
    var xmlHttp			= new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","TPNAssessmentDetails.jsp?encounter_id="+encounter_id+"&note_type="+note_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&validate=before",false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
	//alert(responseText)
  }
  function beforAccessionNumber(accession_num){
      document.formTPNRegimenOptions.accession_num.value=accession_num;  
  }

  
function loadWeightValues(gender)
{
	var actualWeight =  parent.parent.f_header.document.prescription_header_form.weight.value;
	var height = parent.parent.f_header.document.prescription_header_form.height.value
	//To convert the height value from cm to feet (whole number)
	var weightFactor = 0;
	var weightMultiply = 0;
	var feet = ((height/2.54)/12).toString().split('.')[0] ;
	var inches = (height/2.54)%12;

	if(feet >= 5)
		weightFactor = 2.3*(inches + ((feet-5)*12));
	
	if(gender == 'M')
		weightMultiply = 50;
	else
		weightMultiply =45.5;

	var idelBodyWeight = weightMultiply+weightFactor;

	document.tpnRegimenAssessment.act_bdy_wgt[0].value = actualWeight;
	document.tpnRegimenAssessment.act_bdy_wgt[1].value = roundTwoDigits(idelBodyWeight)
	document.tpnRegimenAssessment.act_bdy_wgt[2].value = roundTwoDigits(idelBodyWeight + (0.4*(actualWeight-idelBodyWeight)));
}


function calRecommenedEnergy()
{
	if(document.tpnRegimenAssessment.calc_energy_by[1].checked == true &&document.tpnRegimenAssessment.energy.value!= '')
	{
		var recommendedEnergy =0;
		for(var i=0;i<3;i++)
		{
			if(document.tpnRegimenAssessment.body_weight[i].checked == true)
			{
				if(document.tpnRegimenAssessment.incld_actvt_factor.checked == true)
					recommendedEnergy = document.tpnRegimenAssessment.act_bdy_wgt[i].value *document.tpnRegimenAssessment.energy.value ;
				else
					recommendedEnergy = document.tpnRegimenAssessment.act_bdy_wgt[i].value *document.tpnRegimenAssessment.energy.value * document.tpnRegimenAssessment.stressFactor.value;
			}
		}
		document.tpnRegimenAssessment.recoEnergy.value=document.tpnRegimenAssessment.energyProv.value=recommendedEnergy;
	}

}

function checkForNull()
{
	if (document.tpnRegimenAssessment.energyProv.value == '')
	{
		alert(getMessage("ENER_TO_PRO_CANNOT_BLANK","PH"));
		return false;
	}
	if(document.tpnRegimenAssessment.stressFactor.selectedIndex == 0)
	{
		alert(getMessage("STR_FACT_CANNOT_BLANK","PH"));
		return false;
	}
	if(document.tpnRegimenAssessment.calc_energy_by[1].checked == true)
	{
		if(document.tpnRegimenAssessment.energy.value == '')
		{
			alert(getMessage("ENER_CANNOT_BLANK","PH"));
			return false;
		}
		else if(document.tpnRegimenAssessment.carbohydrate.value == '')
		{
			alert(getMessage("CARB_PER_CANOT_BLANK","PH"));
			return false;
		}
		else if(document.tpnRegimenAssessment.lipid1.value == '')
		{
			alert(getMessage("LIPID_PER_CANOT_BLANK","PH"));
			return false;
		}
		else if(document.tpnRegimenAssessment.protein1.value == '')
		{
			alert(getMessage("PRO_PER_CANOT_BLANK","PH"));
			return false;
		}
		else if(document.tpnRegimenAssessment.carbohydrate.value != '' || document.tpnRegimenAssessment.lipid1.value != '' || document.tpnRegimenAssessment.protein1.value != '')
		{
			if(parseFloat(document.tpnRegimenAssessment.carbohydrate.value) + parseFloat(document.tpnRegimenAssessment.lipid1.value) + parseFloat(document.tpnRegimenAssessment.protein1.value) != 100)
			{
				alert(getMessage("COMBINED_PER_SHD_100","PH"));
				return false;
			}
		}
	}
	return true;
}

function clearWeightValues()
{
	document.tpnRegimenAssessment.carbohydrate.value = '';
	document.tpnRegimenAssessment.lipid1.value ='';
	document.tpnRegimenAssessment.protein1.value ='';
	document.tpnRegimenAssessment.energy.value ='';
	document.tpnRegimenAssessment.act_bdy_wgt[0].value ='';
	document.tpnRegimenAssessment.act_bdy_wgt[1].value ='';
	document.tpnRegimenAssessment.act_bdy_wgt[2].value ='';
}
	
