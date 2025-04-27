/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
03/07/2019      [IN:067952]     Devindra            MMS-KH-CRF-0013 [IN:067952]
05/11/2019		IN070606		Ramesh Goli			MMS-KH-CRF-0029 
23/08/2020		IN073641		Manickavasagam			MMS-KH-CRF-0034 
---------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function create(){
      f_query_add_mod.location.href="../../ePH/jsp/DrugInteractionFrames.jsp?mode="+MODE_INSERT+"&call_from=CREATE";
      //f_query_add_mod.location.href="../../ePH/jsp/DrugInteractionAddModify.jsp.jsp?mode="+MODE_INSERT;
      messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
 }
function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugInteractionQueryCriteria.jsp?mode="+MODE_MODIFY;
	 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
 }

function reset(){
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if (url.indexOf("druginteractionquery")==-1)  {
		var mode = f_query_add_mod.f_drug_interaction.document.DrugInteracionAddModify.mode.value;
		if(mode != MODE_INSERT)
			f_query_add_mod.f_drug_interaction.document.DrugInteracionAddModify.reset();
		else
			create();
	}
	/*else if (url.indexOf("druginteractionframes")==-1 ) {  // commented for FD-RUT-CRF-0066.1 [IN036975]
		query();  
	}*/
}

function Modify(intr_option, intr_code1, intr_code2, form_code1, form_code2,intr_type){ //intr_type added for IN070606
	if(parent.f_query_add_mod!=undefined)// if else Added for MMS-KH-CRF-0013
	   parent.f_query_add_mod.location.href="../../ePH/jsp/DrugInteractionFrames.jsp?mode="+MODE_MODIFY+"&intr_option="+intr_option+"&intr_code1="+intr_code1+"&intr_code2="+intr_code2+"&form_code1="+form_code1+"&form_code2="+form_code2+"&intr_type="+intr_type; //intr_type added for IN070606
    else if(f_query_add_mod!=undefined)
	   f_query_add_mod.location.href="../../ePH/jsp/DrugInteractionFrames.jsp?mode="+MODE_MODIFY+"&intr_option="+intr_option+"&intr_code1="+intr_code1+"&intr_code2="+intr_code2+"&form_code1="+form_code1+"&form_code2="+form_code2+"&intr_type="+intr_type; //intr_type added for IN070606
}

function update(intr_option, intr_code1, intr_code2, form_code1, form_code2){
	parent.f_drug_interaction.location.href="../../ePH/jsp/DrugInteractionAddModify.jsp?mode=1&call_from=UPDATE&intr_option="+intr_option+"&intr_code1="+intr_code1+"&intr_code2="+intr_code2+"&form_code1="+form_code1+"&form_code2="+form_code2;
}

function Clear(){
	parent.f_drug_interaction.location.href="../../ePH/jsp/DrugInteractionAddModify.jsp?mode=1";
}
/*
function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else{
			errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "\n" ;
		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}
*/
function chkduplvalidation(){
	var InteractionType = document.DrugInteracionAddModify.InteractionType.value;  //IN070606
	if(InteractionType=='D'){  //IN070606
		if(document.DrugInteracionAddModify.intr_code1.value==document.DrugInteracionAddModify.intr_code2.value){
			alert(getMessage("PH_DRUG_GENERIC_CANNOT_BE_SAME","PH"));
			return false;
		}
	} //IN070606
	return true;
}
function onChangeDrugInteraction(){
	clearflds();
	clearDosageForm('1');
	clearDosageForm('2');
	var InteractionType = document.DrugInteracionAddModify.InteractionType.value; //IN070606
	
	if(document.getElementById('InteractionBy').value=="D"){
		document.getElementById('lblIntName1').innerText = getLabel("Common.DrugName.label","Common");
		if(InteractionType=='D') //IN070606
			document.getElementById('lblIntName2').innerText = getLabel("Common.DrugName.label","Common");
	}
	else if(document.getElementById('InteractionBy').value=="G"){
		document.getElementById('lblIntName1').innerText = getLabel("Common.GenericName.label","Common");
		if(InteractionType=='D') //IN070606
			document.getElementById('lblIntName2').innerText = getLabel("Common.GenericName.label","Common");
	}
}

function onChangeIntrByQuery(){
	clearfldsQuery();
	var InteractionType =document.query_form.InteractionType.value; //IN070606
	var InteractionBy =document.query_form.InteractionBy.value;
	var orderbycolsObj =document.query_form.orderbycols;
	var len =orderbycolsObj.options.length;
	for(var i=0;i<len;i++) {
		orderbycolsObj.remove("orderbycols") ;
	}
	len =document.query_form.orderbycolumns.options.length;
	for(var i=0;i<len;i++) {
		document.query_form.orderbycolumns.remove("orderbycolumns") ;
	}
	if(InteractionBy == "G"){
		document.getElementById('lblIntName1').innerText = getLabel("Common.GenericName.label","Common");
		var opt = document.createElement("OPTION") ;
		//IN070606 Start.
		if(InteractionType=="D"){
			document.getElementById('lblIntNametd').innerHTML = "<label id='lblIntName2'>"+getLabel("Common.GenericName.label","Common")+"</label>2";			
			opt.text = getLabel("Common.GenericName.label","Common")+2;			
		}else if(InteractionType=="F"){
			document.getElementById('lblIntNametd').innerText =  getLabel("ePH.FoodItemIngredients.label","PH");
			opt.text = getLabel("ePH.FoodItemIngredients.label","PH");
		}else if(InteractionType=="L"){
			document.getElementById('lblIntNametd').innerText = getLabel("ePH.LaboratoryTestCode.label","PH");
			opt.text = getLabel("ePH.LaboratoryTestCode.label","PH");
		}else if(InteractionType=="I"){//Added for MMS-DM-CRF-0229
			document.getElementById('lblIntNametd').innerText = getLabel("Common.TermCode.label","Common");
			opt.text = getLabel("Common.TermCode.label","Common");
		}
		//IN070606 End.
		opt.value = "intr_name2" ;
		orderbycolsObj.add(opt);

		var opt = document.createElement("OPTION") ;
		opt.text =  getLabel("Common.GenericName.label","Common")+1;
		opt.value = "intr_name1" ;
		document.query_form.orderbycolumns.add(opt);
	}
	else if(InteractionBy== "D"){
		document.getElementById('lblIntName1').innerText = getLabel("Common.DrugName.label","Common");
		var opt = document.createElement("OPTION") ;
		//IN070606 start.
		if(InteractionType=="D"){
			document.getElementById('lblIntNametd').innerHTML = "<label id='lblIntName2'>"+getLabel("Common.DrugName.label","Common")+"</label>2";			
			opt.text = getLabel("Common.DrugName.label","Common")+2;			
		}else if(InteractionType=="F"){
			document.getElementById('lblIntNametd').innerText = getLabel("ePH.FoodItemIngredients.label","PH");
			opt.text = getLabel("ePH.FoodItemIngredients.label","PH");
		}else if(InteractionType=="L"){
			document.getElementById('lblIntNametd').innerText = getLabel("ePH.LaboratoryTestCode.label","PH");
			opt.text = getLabel("ePH.LaboratoryTestCode.label","PH");
		}else if(InteractionType=="I"){//Added for MMS-DM-CRF-0229
			document.getElementById('lblIntNametd').innerText = getLabel("Common.TermCode.label","Common");
			opt.text = getLabel("Common.TermCode.label","Common");
		}
		//IN070606 end.
		opt.value = "intr_name2" ;
		orderbycolsObj.add(opt);
		
		var opt = document.createElement("OPTION") ;
		opt.text =  getLabel("Common.DrugName.label","Common")+1;
		opt.value = "intr_name1" ;
		document.query_form.orderbycolumns.add(opt);
	}
	var opt = document.createElement("OPTION") ;
	opt.text =   getLabel("ePH.DosageForm.label","PH")+" 1";
	opt.value = "dosage_form11" ;
	orderbycolsObj.add(opt);
	
	if(InteractionType=="D"){ //IN070606
		var opt = document.createElement("OPTION") ;
		opt.text =   getLabel("ePH.DosageForm.label","PH")+" 2"
		opt.value = "dosage_form12" ;
		orderbycolsObj.add(opt);
	} //IN070606
	var opt = document.createElement("OPTION") ;
	opt.text =   getLabel("Common.Severity.label","Common")+" "+ getLabel("Common.Level.label","Common");
	opt.value = "intr_severity_level" ;
	orderbycolsObj.add(opt);

	var opt = document.createElement("OPTION") ;
	opt.text =   getLabel("Common.significant.label","Common")+" "+ getLabel("Common.Level.label","Common");
	opt.value = "intr_signif_level" ;
	orderbycolsObj.add(opt);

	var opt = document.createElement("OPTION") ;
	opt.text =  getLabel("ePH.documentation.label","PH"); // probability modified as documentation for FD-RUT-CRF-0066.1 [IN036975]
	opt.value = "intr_prob_level" ;
	orderbycolsObj.add(opt);

	var opt = document.createElement("OPTION") ;
	opt.text =  getLabel("Common.Nature.label","Common");
	opt.value = "eff_status" ;
	orderbycolsObj.add(opt);
}

function clearCode(codeObj, objNum){
	codeObj.value="";
	clearDosageForm( objNum)
}
function clearDosageForm( objNum){
	var doseFomObj = eval("document.DrugInteracionAddModify.dosageForm"+objNum)
	var len = doseFomObj.options.length ;
	if (len>0){
		for(var i=0;i<len;i++){
			doseFomObj.remove(doseFomObj.name) ;
		}
	}
	var InteractionBy = document.DrugInteracionAddModify.InteractionBy.value;
	var Intr_code =  eval("document.DrugInteracionAddModify.intr_code"+objNum).value;
	if(Intr_code==""){
		var element = document.createElement('OPTION') ;
		element.value		=  ""  ;
		element.text		='------'+ getLabel("Common.defaultSelect.label","common")+'-------' ;
		doseFomObj.add(element);
	}
	else if(InteractionBy =='G'){
		var element = document.createElement('OPTION') ;
		element.value		=  "*A"  ;
		element.text		= getLabel("Common.all.label","common") ;
		doseFomObj.add(element);
	}
}

function addDosageForm( formCode, formDesc, objNum){
	var doseFomObj = eval("document.DrugInteracionAddModify.dosageForm"+objNum)
	var len = doseFomObj.options.length ;
	var element = document.createElement('OPTION') ;
	element.value		=  formCode  ;
	element.text		= decodeURIComponent(formDesc,"UTF-8");
	doseFomObj.add(element);
}
//IN070606 Start.
function searchCode1( target, code_obj, mode, objNum ){
	if(objNum=='1'){
		clearDosageForm( objNum);
		if((document.forms[0].intr_name1.value)!=""){
			searchCode( target, code_obj, mode, objNum );
		}else{
			document.forms[0].intr_code1.value="";
			document.forms[0].intr_name1.value="";	
		}
	}else if(objNum=='2'){
		if((document.forms[0].InteractionType.value)=="D")
			clearDosageForm( objNum);
		if((document.forms[0].intr_name2.value)!=""){
			searchCode( target, code_obj, mode, objNum );
		}else{
			document.forms[0].intr_code2.value="";
			document.forms[0].intr_name2.value="";	
		}
	}
	
}
function searchCode2( target, code_obj, mode, objNum ){
	if(objNum=='1'){		
		if((document.forms[0].intr_name1.value)!=""){
			searchCode( target, code_obj, mode, objNum );
		}else{
			document.forms[0].intr_code1.value="";
			document.forms[0].intr_name1.value="";	
		}
	}else if(objNum=='2'){
		if((document.forms[0].intr_name2.value)!=""){
			searchCode( target, code_obj, mode, objNum );
		}else{
			document.forms[0].intr_code2.value="";
			document.forms[0].intr_name2.value="";	
		}
	}	
}
//IN070606 end.
async function searchCode( target, code_obj, mode, objNum ) {
	var sql = '';
	var title = '';
	var formObj;

	if(mode == MODE_INSERT){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		formObj = document.DrugInteracionAddModify;
	}
	else{
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		formObj = document.query_form;
	}
	var language_id  = formObj.locale.value;
	var InteractionBy = formObj.InteractionBy.value;
	var InteractionType = formObj.InteractionType.value;//IN070606
	var term_set_code = "";// Adding start for MMS-DM-CRF-0229
	if(InteractionType=="I"){
        term_set_code   = formObj.TermSetList.value;
		if(term_set_code==""){
			alert("Please Select Term Set to Procced");
			return;
		}//Adding end 
	}
	if(objNum=='1'){//IN070606
		if(InteractionBy =='D'){
			sql =formObj.sql_ph_drug_lookup.value+"'"+language_id+"' ORDER BY 2"
			title = getLabel("Common.DrugName.label","Common");
		}
		else{
			sql=formObj.sql_ph_generic_name_lookup.value+"'"+language_id+"' ORDER BY 2"
			title = getLabel("Common.GenericName.label","Common");
		}
	//IN070606 Start.
	}else if(objNum=='2'){
		if(InteractionType=='D'){
			if(InteractionBy =='D'){
				sql =formObj.sql_ph_drug_lookup.value+"'"+language_id+"' ORDER BY 2"
				title = getLabel("Common.DrugName.label","Common");
			}
			else{
				sql=formObj.sql_ph_generic_name_lookup.value+"'"+language_id+"' ORDER BY 2"
				title = getLabel("Common.GenericName.label","Common");
			}
		}else if(InteractionType=='F'){
			sql =formObj.sql_ds_foodItem_lookup.value+" ORDER BY 2";  
			title = getLabel("ePH.FoodItemIngredients.label","PH"); 
		}else if(InteractionType=='L'){
			sql =formObj.sql_lb_labOrderCatalog_lookup.value+" ORDER BY 2"; 
			title = getLabel("ePH.LaboratoryTestCode.label","PH"); 
		}else if(InteractionType=='I'){//Adding start for MMS-DM-CRF-0229
			sql ="SELECT   term_code code, short_desc description FROM mr_term_code WHERE term_set_id='"+term_set_code+"' AND eff_status = 'E' AND UPPER (term_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ORDER BY 2"; 
			title = getLabel("Common.TermCodeforDrug.label","Common"); 
		}//Adding end for MMS-DM-CRF-0229
	}
	//IN070606 end.
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;

    argumentArray[0] = sql
    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
    argumentArray[5]   = target.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( title, argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
    if(retVal != null && retVal != "" )  {
        target.value = arr[1] ;
        code_obj.value = arr[0] ;
		if(InteractionType=='D' || objNum=='1'){ //IN070606
			if(mode == MODE_INSERT)
				loadDosageForms(InteractionBy, code_obj.value, objNum);
		}
	//IN070606 Start.	
	}else{
		target.value = "" ;
        code_obj.value = "" ;
	}
	//IN070606 End.
}
function loadDosageForms(InteractionBy, intrCode, objNum){
			var bean_id			=	document.DrugInteracionAddModify.bean_id.value;
			var bean_name			=	document.DrugInteracionAddModify.bean_name.value;
	var intr_option			=	document.DrugInteracionAddModify.InteractionBy.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "intr_option=\""+intr_option +"\" " ;
	xmlStr += "intrCode=\""+ intrCode +"\" " ;
	xmlStr += "objNum=\""+ objNum +"\" " ;
	xmlStr += "bean_id=\""+ bean_id +"\" " ;
	xmlStr += "bean_name=\""+ bean_name +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DrugInteractionValidate.jsp?func_mode=loadDosageForm", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	updateDup = eval(xmlHttp.responseText);
}

function setValue(obj, callFrom){
	if(callFrom =='ES'){
		if(obj.checked)
			obj.value='E';
		else
			obj.value='D';
	}
	else{
		if(obj.checked)
			obj.value='Y';
		else
			obj.value='N';
	}
}
function checkForDuplicate(){
	var fields  = new Array() ;
	var names   = new Array() ;
	var i=0;
	var InteractionType = document.DrugInteracionAddModify.InteractionType.value; //IN070606
	if(InteractionType=='I'){//Adding start for MMS-DM-CRF-0229
		var term_set_code =document.DrugInteracionAddModify.TermSetList.value;
		if(term_set_code==""){
			fields[i]   = document.DrugInteracionAddModify.TermSetList;
		    names[i++]   = getLabel("Common.TermSet.label","Common");
		}
		}//Adding end for MMS-DM-CRF-0229
	if(document.DrugInteracionAddModify.intr_name1.value!="" && document.DrugInteracionAddModify.intr_code1.value==""){
		alert(getMessage("PH_DRUG_GENERIC_SELECTED_FROM_LOOKUP","PH"));
		return false;
	}
	if(document.DrugInteracionAddModify.intr_name2.value!="" && document.DrugInteracionAddModify.intr_code2.value==""){
		alert(getMessage("PH_DRUG_GENERIC_SELECTED_FROM_LOOKUP","PH"));
		return false;
	}
	if(document.DrugInteracionAddModify.intr_code1.value==""){
		fields[i]   = document.DrugInteracionAddModify.intr_code1;
		names[i++]   = document.getElementById('lblIntName1').innerText +'1';
	}
	if(document.DrugInteracionAddModify.intr_code2.value=="") {
		fields[i]   = document.DrugInteracionAddModify.intr_code2;
		if(InteractionType=='D')//IN070606
			names[i++]   = document.getElementById('lblIntName2').innerText+'2' ;
		else if(InteractionType=='F' || InteractionType=='L' || InteractionType=='I')//IN070606 //Added I for MMS-DM-CRF-0229
			names[i++]   = document.getElementById('lblIntNametd').innerText;//IN070606
	}
	if(document.DrugInteracionAddModify.dosageForm1.value==""){
		fields[i]   = document.DrugInteracionAddModify.dosageForm1;
		names[i++]   = getLabel("ePH.DosageForm.label","PH")+"1";
	}
	if(InteractionType=='D'){ //IN070606
		if(document.DrugInteracionAddModify.dosageForm2.value=="") {
			fields[i]   = document.DrugInteracionAddModify.dosageForm2;
			names[i++]   = getLabel("ePH.DosageForm.label","PH")+"2";
		}
	}
	if(document.DrugInteracionAddModify.interaction_desc.value==""){
		fields[i]   = document.DrugInteracionAddModify.interaction_desc;
		names[i++]   = getLabel("ePH.Interaction.label","PH")+' '+getLabel("Common.description.label","Common");
	}
	if(document.DrugInteracionAddModify.Probability.value==""){
		fields[i]   = document.DrugInteracionAddModify.Probability;
		names[i++]   = getLabel("ePH.documentation.label","PH");
	}
	
	messageFrame = parent.parent.messageFrame;
	if(checkFieldsofMst(fields,names,messageFrame )){
		if(chkduplvalidation()){
			var updateDup;
			var call_from			=	document.DrugInteracionAddModify.call_from.value;
			if(call_from == 'UPDATE'){
				AddRecord();
				return;
			}
			var bean_id			=	document.DrugInteracionAddModify.bean_id.value;
			var bean_name			=	document.DrugInteracionAddModify.bean_name.value;
			var intr_option			=	document.DrugInteracionAddModify.InteractionBy.value;
			var intr_code1		=	document.DrugInteracionAddModify.intr_code1.value;
			var intr_code2		=	document.DrugInteracionAddModify.intr_code2.value;
			var form_code1		=	document.DrugInteracionAddModify.dosageForm1.value;
			var form_code2		=	document.DrugInteracionAddModify.dosageForm2.value;
			var intr_type		=	document.DrugInteracionAddModify.InteractionType.value; //IN070606
			if(form_code2=="")form_code2="*A"; //IN070606
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += "intr_option=\""+intr_option +"\" " ;
			xmlStr += "intr_code1=\""+ intr_code1 +"\" " ;
			xmlStr += "intr_code2=\""+ intr_code2 +"\" " ;
			xmlStr += "form_code1=\""+ form_code1 +"\" " ;
			xmlStr += "form_code2=\""+ form_code2 +"\" " ;
			xmlStr += "bean_id=\""+ bean_id +"\" " ;
			xmlStr += "bean_name=\""+ bean_name +"\" " ;
			xmlStr += "intr_type=\""+ intr_type +"\" " ; //IN070606
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DrugInteractionValidate.jsp?func_mode=checkForDuplicate", false ) ;
			xmlHttp.send( xmlDoc ) ;	
			updateDup = eval(xmlHttp.responseText);
			if(updateDup)
				AddRecord();
			else
				return false;
		}
	}
}

function AddRecord(){
	var bean_id			=	document.DrugInteracionAddModify.bean_id.value;
	var bean_name			=	document.DrugInteracionAddModify.bean_name.value;
	var intr_Type			=	document.DrugInteracionAddModify.InteractionType.value;
	var intr_option			=	document.DrugInteracionAddModify.InteractionBy.value;
	var intr_code1		=	document.DrugInteracionAddModify.intr_code1.value;
	var intr_code2		=	document.DrugInteracionAddModify.intr_code2.value;
	var intr_name1		=	document.DrugInteracionAddModify.intr_name1.value;
	var intr_name2			=	document.DrugInteracionAddModify.intr_name2.value;
	var severity_level		=	document.DrugInteracionAddModify.Severity_Level.value;
	var significant_level	=	document.DrugInteracionAddModify.Significant_level.value;
	var probability			=	document.DrugInteracionAddModify.Probability.value;
	var interaction_desc	=	document.DrugInteracionAddModify.interaction_desc.value;
	var restrict_transaction=	document.DrugInteracionAddModify.restrict_transaction.value;
	var dosageForm1 = document.DrugInteracionAddModify.dosageForm1;
	var dosageForm2 = document.DrugInteracionAddModify.dosageForm2;
	var form_code1		=	dosageForm1.options[dosageForm1.selectedIndex].value;
	var form_desc1		=	dosageForm1.options[dosageForm1.selectedIndex].text;
	var lab_ord_check_for_upto = document.DrugInteracionAddModify.lab_ord_check_for_upto.value;
	var term_set_code ="";//Adding start for MMS-DM-CRF-0229
	var termSetForm  = document.DrugInteracionAddModify.TermSetList;
	 if(intr_Type=="I")
          term_set_code  = termSetForm.options[termSetForm.selectedIndex].value;//Adding end for MMS-DM-CRF-0229
	// alert("term_set_code@@=="+term_set_code);

	//IN070606 Start.
	var form_code2		=	"*A";  
	var form_desc2			=	"";  
	if(intr_Type=="D"){
		form_code2		= dosageForm2.options[dosageForm2.selectedIndex].value;
		form_desc2			=	dosageForm2.options[dosageForm2.selectedIndex].text;
	}
	//IN070606 End.
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += "intr_Type=\""+intr_Type +"\" " ;
	xmlStr += "intr_option=\""+intr_option +"\" " ;
	xmlStr += "intr_code1=\""+ intr_code1 +"\" " ;
	xmlStr += "intr_code2=\""+ intr_code2 +"\" " ;
	xmlStr += "intr_name1=\""+ encodeURIComponent(intr_name1) +"\" " ;
	xmlStr += "intr_name2=\""+ encodeURIComponent(intr_name2) +"\" " ;
	xmlStr += "term_set_code=\""+ term_set_code +"\" " ;//Added for MMS-DM-CRF-0229
	xmlStr += "severity_level=\""+ severity_level +"\" " ;
	xmlStr += "significant_level=\""+ significant_level +"\" " ;
	xmlStr += "probability=\""+ probability +"\" " ;
	xmlStr += "interaction_desc=\""+ encodeURIComponent(interaction_desc) +"\" " ;
	xmlStr += "restrict_transaction=\""+ restrict_transaction +"\" " ;
	xmlStr += "form_code1=\""+ form_code1 +"\" " ;
	xmlStr += "form_code2=\""+ form_code2 +"\" " ;
	xmlStr += "form_desc1=\""+ encodeURIComponent(form_desc1) +"\" " ;
	xmlStr += "form_desc2=\""+ encodeURIComponent(form_desc2) +"\" " ;
	xmlStr += "bean_id=\""+ bean_id +"\" " ;
	xmlStr += "bean_name=\""+ bean_name +"\" " ;
	xmlStr += "lab_ord_check_for_upto=\""+ lab_ord_check_for_upto +"\" " ;
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DrugInteractionValidate.jsp?func_mode=AddRecord", false ) ;
	xmlHttp.send( xmlDoc ) ;	
	eval(xmlHttp.responseText);	
}

function LoadDrugIntrList(){
	parent.f_drug_interaction_list.location.href="../../ePH/jsp/DrugInteractionList.jsp?mode=1";
	parent.f_drug_interaction.location.href="../../ePH/jsp/DrugInteractionAddModify.jsp?mode=1";
}

function apply(){
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	if(f_query_add_mod.f_drug_interaction!=undefined){
		formObj =   f_query_add_mod.f_drug_interaction.document.DrugInteracionAddModify;
		var mode = formObj.mode.value;
		var intr_type= formObj.InteractionType.value;
		var flg=false;

		if(mode== MODE_INSERT){
			if(f_query_add_mod.f_drug_interaction_list.FormDrugInteractionList!=undefined){
				formObj1 = f_query_add_mod.f_drug_interaction_list.FormDrugInteractionList;
				recCount = formObj1.recCount.value;
				var recSlected=false;
				for(i=0; i<recCount; i++){
					if(eval("formObj1.eff_status_"+i).checked){
						recSlected = true;
						break;
					}
				}
				if(recSlected){
					eval(formApply(formObj1, PH_CONTROLLER));
					if( result ) {
						onSuccess();	
					}
					else
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
				}
				else{
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_SELECTED","Common");
					return false;
				}
			}
			else{ //added for RUT-SCF-0372 [IN:046812]
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("SELECT_ATLEAST_ONE_RECORD","PH");
				return false;
			}
		}
		else if( mode == MODE_MODIFY ){
			var fields  = new Array() ;
			var names   = new Array() ;
			var i=0;
			if(formObj.interaction_desc.value==""){
				fields[i]   = formObj.interaction_desc;
				names[i++]   = getLabel("ePH.Interaction.label","PH")+' '+getLabel("Common.description.label","Common");
			}
			if(formObj.dosageForm1.value==""){
				fields[i]   = formObj.dosageForm1;
				names[i++]   = getLabel("ePH.DosageForm.label","PH")+'1';
			}
			if(intr_type=="D"){
				if(formObj.dosageForm2.value==""){
					fields[i]   = formObj.dosageForm2;
					names[i++]   = getLabel("ePH.DosageForm.label","PH")+'2';
				}
			}
			if(formObj.Probability.value==""){
				fields[i]   = formObj.Probability;
				names[i++]   = getLabel("ePH.documentation.label","PH");
			}
			if(checkFieldsofMst(fields,names, messageFrame)){
				formObj.interact_desc.value = encodeURIComponent(formObj.interaction_desc.value,"UTF-8");
			  /*eval(formApply(formObj, PH_CONTROLLER));
				if( result ) {
					onSuccess();	
				}
				else
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message; */ // commented for MMS-KH-CRF-0013 [IN:067952]			    
				if((formObj.intractn_req_yn.value==true || formObj.intractn_req_yn.value=="true") && formObj.eff_status_old.value!=formObj.eff_status.value && !confirm(getMessage("INTR_ACTN_MODIFIED","PH"))){ // if else Added for MMS-KH-CRF-0013 [IN:067952] - Start   
			    	   Modify(formObj.intr_option.value, formObj.intr_code1.value, formObj.intr_code2.value, formObj.form_code1.value, formObj.form_code2.value); // Added for PO Issue MMS-KH-CRF-0013
			    	
			    } 
			    else{
				eval(formApply(formObj, PH_CONTROLLER));
				if( result ) {
					onSuccess();	
				}
				else
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
			    } // if else Added for MMS-KH-CRF-0013 [IN:067952] - End
			}
		}
	}
}


//MMS-KH-CRF-0034 - start
function validateCheck(obj){

	if(obj.value!=""){
	 if(obj.value=="0" || obj.value=="00"){
		 obj.value = "";
		document.DrugInteracionAddModify.lab_ord_chk_upto.value="";
		 alert("Drug Lab Interaction Check Days should be greater than Zero");
		return false;
	 }else{
		document.DrugInteracionAddModify.lab_ord_chk_upto.value=obj.value;
	 }
	}else{
		document.DrugInteracionAddModify.lab_ord_chk_upto.value="";
	}
}
//MMS-KH-CRF-0034 - end
function assignResult( _result, _message, _flag, _invalidCode) {
	result 	= _result ;
	message		= _message ;
	flag		= _flag ;
	invalidCode = _invalidCode ;
	alert(message);
}

function onSuccess() {
    formObj =   f_query_add_mod.f_drug_interaction.document.DrugInteracionAddModify;
    var mode = formObj.mode.value;
    if( mode == MODE_INSERT ) {
		create();
    }
    else if(mode == MODE_MODIFY ){
		var formObj =f_query_add_mod.f_drug_interaction.document.DrugInteracionAddModify;
		var intr_option = formObj.InteractionBy.value;
		var intr_code1 = formObj.intr_code1.value;
		var intr_code2 = formObj.intr_code2.value;
		var form_code1 = formObj.form_code1.value;
		var form_code2 = formObj.form_code2.value;
		var intr_type = formObj.InteractionType.value; //IN070606
		f_query_add_mod.location.href="../../ePH/jsp/DrugInteractionFrames.jsp?mode="+MODE_MODIFY+"&intr_option="+intr_option+"&intr_code1="+intr_code1+"&intr_code2="+intr_code2+"&form_code1="+form_code1+"&form_code2="+form_code2+"&intr_type="+intr_type;  // intr_type added for IN070606
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		//f_query_add_mod.f_drug_interaction.document.DrugInteracionAddModify;
    }
}

function clearflds(){
	document.getElementById("intr_code1").value="";
	document.getElementById("intr_name1").value="";
	document.getElementById("intr_code2").value="";
	document.getElementById("intr_name2").value="";
	document.getElementById("interaction_desc").value=""
	document.getElementById("Severity_Level").selectedIndex=0;
	document.getElementById("Probability").selectedIndex=0;
	document.getElementById("Significant_level").selectedIndex=0;
	document.getElementById("restrict_transaction").checked=false;
}

function clearfldsQuery(){
	document.getElementById("intr_code1").value="";
	document.getElementById("intr_name1").value="";
	document.getElementById("intr_code2").value="";
	document.getElementById("intr_name2").value="";
	document.getElementById("Severity_Level").selectedIndex=0;
	document.getElementById("Probability").selectedIndex=0;
	document.getElementById("Significant_level").selectedIndex=0;
	document.getElementById("nature").selectedIndex=0;
	document.getElementById("TermSetList").selectedIndex=0;//54512
}

function addOrderByCol(){  
	var i=0;
	var from = document.getElementById('orderbycols'); 
	if ( from.options.length > 0 ) {
		var to = document.getElementById('orderbycolumns'); 
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value= from.options[from.selectedIndex].value; 
			to.add(element);      
			from.remove(from.selectedIndex);
			if(from.options[i])
				from.options[i].selected=true ;
			i++;
		}
	} 
} 

function removeOrderByCol(){
	var j=0;
	var from = document.getElementById('orderbycolumns');
	if ( from.options.length > 0 ){ 
		var to = document.getElementById('orderbycols');
		var element = document.createElement('OPTION');
		var seltdIndex = from.selectedIndex;
		if(seltdIndex > -1){
			element.text = from.options[from.selectedIndex].text;
			element.value = from.options[from.selectedIndex].value;
			to.add(element);    from.remove(from.selectedIndex);
			if(from.options[j]) 
				from.options[j].selected=true; 
			j++;
		}
	}
}  

function SelectAll(){
	var i = 0;
	document.getElementById('orderbycolumns').selectedIndex=0; 
	while ( i < document.getElementById('orderbycolumns').length) {
		document.getElementById('orderbycolumns').options[i].selected=true;
		i++; 
	}
}  

function execQuery(){
	if(document.getElementById("orderbycolumns").options.length >0 ){
		SelectAll(); 
		document.query_form.submit();
	}
	else{
		alert(getMessage('ORDERBY_NOT_BLANK',"Common"))
	}
}

function callCheckMaxLen(obj,noOfChars, frm) { 
	var val = obj.value;
	if(obj.value.length > noOfChars) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.Interaction.label","PH") +" "+getLabel("Common.description.label","common"));
		msg = msg.replace("#",noOfChars);
		obj.value = val.substring(0,noOfChars);
		alert(msg);
		if(frm == "blr")
			obj.select();
		return false;
	}
}

/*function assignTitle(count, intr_desc){
	eval("document.getElementById('intr_desc')"+count).title=decodeURIComponent(intr_desc,"UTF-8");
}*/

function assignTitle(count, intr_desc) {
    var elementId = 'intr_desc' + count; // Constructing the id of the element
    var element = document.getElementById(elementId); // Getting the element by id
    if (element) {
        var decodedDesc = decodeURIComponent(intr_desc); // Decoding the description
        element.title = decodedDesc; // Assigning the decoded description as the title
    }
}



function setFormCode(selObj, index){
	eval("document.DrugInteracionAddModify.dosageForm"+index).value = selObj.value;
}
//IN070606 Start.
function onChangeInteractionType(obj){
	//MMS-KH-CRF-0034
	if(obj.value=="D" || obj.value=="F" || obj.value=="I"){//Added || obj.value=="I" for MMS-DM-CRF-0229
		document.getElementById("LabOrdChkUpto").style.display = 'none';
		document.getElementById("LabOrdChkUpto1").style.display = 'none';
	}
	else{
	
		document.getElementById("LabOrdChkUpto").style.display = '';
			document.getElementById("LabOrdChkUpto1").style.display = '';
	}

	if('D'==obj.value){
		
		var InteractionBy =document.DrugInteracionAddModify.InteractionBy.value;
		if(InteractionBy=="D"){
			document.getElementById('lblIntNametd').innerHTML = "<label id='lblIntName2'>"+getLabel("Common.DrugName.label","Common")+"</label>2";
		}
		else if(InteractionBy=="G"){
			document.getElementById('lblIntNametd').innerHTML = "<label id='lblIntName2'>"+getLabel("Common.GenericName.label","Common")+"</label>2";
		}
		document.getElementById("dosageFormtd1").style.display = '';
		document.getElementById("dosageFormtd2").style.display = '';
		document.getElementById("foodFormtd1").style.display = 'none';
		document.getElementById("foodFormtd2").style.display = 'none';
		document.getElementById("labCatlogCodetd1").style.display = 'none';
		document.getElementById("labCatlogCodetd2").style.display = 'none';
		document.getElementById("term_set").style.visibility = 'hidden';//Adding start for MMS-DM-CRF-0229
		document.getElementById("TermSetList").style.visibility = 'hidden';
		document.getElementById("term_mandatory").style.visibility = 'hidden';//Adding end for MMS-DM-CRF-0229
	}else if('F'==obj.value){
		
		document.getElementById('lblIntNametd').innerText = getLabel("ePH.FoodItemIngredients.label","PH");
		document.getElementById("dosageFormtd1").style.display = 'none';
		document.getElementById("dosageFormtd2").style.display = 'none';
		document.getElementById("foodFormtd1").style.display = '';
		document.getElementById("foodFormtd2").style.display = '';
		document.getElementById("labCatlogCodetd1").style.display = 'none';
		document.getElementById("labCatlogCodetd2").style.display = 'none';
		document.getElementById("term_set").style.visibility = 'hidden';//Adding start for MMS-DM-CRF-0229
		document.getElementById("TermSetList").style.visibility = 'hidden';
		document.getElementById("term_mandatory").style.visibility = 'hidden';//Adding end for MMS-DM-CRF-0229
	}else if('L'==obj.value){
		
		document.getElementById('lblIntNametd').innerText = getLabel("ePH.LaboratoryTestCode.label","PH");
		document.getElementById("dosageFormtd1").style.display = 'none';
		document.getElementById("dosageFormtd2").style.display = 'none';
		document.getElementById("foodFormtd1").style.display = 'none';
		document.getElementById("foodFormtd2").style.display = 'none';
		document.getElementById("labCatlogCodetd1").style.display = '';
		document.getElementById("labCatlogCodetd2").style.display = '';
		document.getElementById("term_set").style.visibility = 'hidden';//Adding start for MMS-DM-CRF-0229
		document.getElementById("TermSetList").style.visibility = 'hidden';
		document.getElementById("term_mandatory").style.visibility = 'hidden';//Adding end for MMS-DM-CRF-0229
	}else if('I'==obj.value){
		
		document.getElementById('lblIntNametd').innerText = getLabel("Common.TermCode.label","Common");
		document.getElementById("dosageFormtd1").style.display = 'none';
		document.getElementById("dosageFormtd2").style.display = 'none';
		document.getElementById("foodFormtd1").style.display = 'none';
		document.getElementById("foodFormtd2").style.display = 'none';
		document.getElementById("labCatlogCodetd1").style.display = 'none';
		document.getElementById("labCatlogCodetd2").style.display = 'none';
		document.getElementById("term_set").style.visibility = 'visible';
		document.getElementById("TermSetList").style.visibility = 'visible';
		document.getElementById("term_mandatory").style.visibility = 'visible';
	}
	clearflds();
}
function onChangeInteractionType1(obj){
	if('D'==obj.value){		
		var InteractionBy =document.query_form.InteractionBy.value;
		if(InteractionBy=="D"){
			document.getElementById('lblIntNametd').innerHTML = "<label id='lblIntName2'>"+getLabel("Common.DrugName.label","Common")+"</label>2";
		}
		else if(InteractionBy=="G"){
			document.getElementById('lblIntNametd').innerHTML = "<label id='lblIntName2'>"+getLabel("Common.GenericName.label","Common")+"</label>2";
		}
		document.getElementById("term_set").style.visibility = 'hidden';
		document.getElementById("TermSetList").style.visibility = 'hidden';
	}else if('F'==obj.value){		
		document.getElementById('lblIntNametd').innerText = getLabel("ePH.FoodItemIngredients.label","PH");
		document.getElementById("term_set").style.visibility = 'hidden';
		document.getElementById("TermSetList").style.visibility = 'hidden';
	}else if('L'==obj.value){		
		document.getElementById('lblIntNametd').innerText = getLabel("ePH.LaboratoryTestCode.label","PH");
		document.getElementById("term_set").style.visibility = 'hidden';
		document.getElementById("TermSetList").style.visibility = 'hidden';
	}else if('I'==obj.value){//Added for MMS-DM-CRF-0229		
		document.getElementById('lblIntNametd').innerText = getLabel("Common.TermCode.label","Common");
		document.getElementById('term_set').style.visibility = 'visible';
		document.getElementById('TermSetList').style.visibility = 'visible';
	}
	onChangeIntrByQuery();
}
//IN070606 End.
//MMS-KH-CRF-0034
function enableLabOrdCheck(){
	if(document.DrugInteracionAddModify.InteractionType.value=="D" || document.DrugInteracionAddModify.InteractionType.value=="F" || document.DrugInteracionAddModify.InteractionType.value=="I"){//Added I condition for MMS-DM-CRF-0229
		document.getElementById("LabOrdChkUpto").style.display = 'none';
		document.getElementById("LabOrdChkUpto1").style.display = 'none';
	}
	else{
		document.getElementById("LabOrdChkUpto").style.display = '';
		document.getElementById("LabOrdChkUpto1").style.display = '';
	}
}
