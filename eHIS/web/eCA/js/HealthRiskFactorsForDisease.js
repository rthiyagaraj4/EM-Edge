/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
03/05/2013	  IN039555		Karthi L	 Health Risk Factor for Disease->System is not displaying error 									
---------------------------------------------------------------------------------------------------------
*/
var addedRowCount = 0;
var	function_id		= "" ;

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactorsForDisease.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
function query()
{			
	f_query_add_mod.location.href='../../eCA/jsp/CAHealthRiskFactorsForDiseaseCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}
function reset(){
	var formobj= f_query_add_mod.document.HealthRiskFactorsForDisease;
	if(formobj != null){
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.location.reload();	
	} else {
	
		if(f_query_add_mod.document.forms[0])
			f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.location.reload();
	}	
	//var modeObj =f_query_add_mod.document.HealthRiskFactorsForDisease.mode.value ;
}
function apply()
{	
	var formobj= f_query_add_mod.document.HealthRiskFactorsForDisease;
	
	if(formobj != null){
		if(eval("f_query_add_mod.document.HealthRiskFactorsForDisease") != undefined ) {
			var modeObj =f_query_add_mod.document.HealthRiskFactorsForDisease.mode.value ;
			if(modeObj == "1") {
				
				var fields = new Array (f_query_add_mod.document.HealthRiskFactorsForDisease.terminology_set); //terminology_set risk_factor_code_
				var names = new Array (getLabel("eMR.DiagnosisSet.label",'eMR')); 
				var tableID = 'risk_fact_disease';
				var table = f_query_add_mod.document.getElementById(tableID);
				var rowCount = table.rows.length;
				//alert("INNER HTML " + table.innerHTML);
				if(checkFieldsofMst(fields,names,messageFrame))
				{	
					var fields = "";
					var names = "";
					if(rowCount < 2) {
						fields = new Array( f_query_add_mod.document.HealthRiskFactorsForDisease.diagprob_code,f_query_add_mod.document.HealthRiskFactorsForDisease.risk_factor_code_); 
						names = new Array (getLabel("Common.DiagnosisCode.label",'Common'), getLabel("eCA.riskfactor.label",'eCA')); 
					} else {
						fields = new Array( f_query_add_mod.document.HealthRiskFactorsForDisease.diagprob_code); 
						names = new Array (getLabel("Common.DiagnosisCode.label",'Common')); 
					}
					if(checkFieldsofMst(fields,names,messageFrame))
					{	
						f_query_add_mod.document.HealthRiskFactorsForDisease.action="../../servlet/eCA.HealthRiskFactorsForDiseaseServlet";
						f_query_add_mod.document.HealthRiskFactorsForDisease.target="messageFrame";
						f_query_add_mod.document.HealthRiskFactorsForDisease.method="post";
						f_query_add_mod.document.HealthRiskFactorsForDisease.submit();	
					}	
				}
			}	
		}
	}
	else {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	}	
}
function onSuccess()
{	
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactorsForDisease.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	f_query_add_mod.location.reload();
	
}
async function riskFactorsearchOnClick(risk_fact_obj)
{	
	var search_by_ =  document.HealthRiskFactorsForDisease.search_by_.value;
	if(risk_fact_obj.value ==undefined)
	{
		risk_fact_obj.value ="";
	}
	
	if(search_by_=="" || search_by_==null) {
		alert(" Please select any of the risk type");
		 document.HealthRiskFactorsForDisease.risk_factor_desc_.value = "";
		return false;
	}
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var sql;
	if(search_by_ == 'I') {
		sql =" SELECT RISK_FACTOR_TYPE code,RISK_FACTOR_DESC description FROM CA_RISK_FACTOR_TYPE where eff_status='E' and upper(RISK_FACTOR_TYPE) like upper(?) and  upper(RISK_FACTOR_DESC) like upper(?) "; 
	}	
	else {
		sql = "SELECT RISK_FACTOR_GROUP code,RISK_FACTOR_DESC description FROM CA_GROUP_RISK_FACTOR_TYPE  where eff_status='E'  and upper(RISK_FACTOR_GROUP) like upper(?) and upper(RISK_FACTOR_DESC) like upper(?)";
	}	
	sql = sql +"ORDER BY  2";
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=risk_fact_obj.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	retval= await CommonLookup(getLabel("eCA.riskfactor.label","CA"),argumentArray);
	var str =unescape(retval);
	var arr = str.split(",");
	if(retval !=null && retval != ""){
		risk_fact_obj.value=retval[0];
		eval("document.HealthRiskFactorsForDisease.risk_factor_code_").value = arr[0];
		eval("document.HealthRiskFactorsForDisease.risk_factor_desc_").value = arr[1];
		
	}
}
async function show_window()
{
	var searchtext = document.HealthRiskFactorsForDisease.diagprob_code.value;
	var practitioner_id = document.HealthRiskFactorsForDisease.Practitioner_Id.value;
	var term_set_id = document.HealthRiskFactorsForDisease.terminology_set.value;
	
	var speciality_code = "";
	var dob = "";
	var age = "";
	var sex = "";
	var Encounter_Id = "";
	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "500px" ;
	var dialogWidth = "800px" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
	retVal =await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);
	if(retVal != null){
		retcode=retVal; 
		document.HealthRiskFactorsForDisease.diagprob_code.value = retcode;		
		populateData("TS",retVal,"",term_set_id);
	}
	
}
function populateData(objValue,subValue,mode,subValue1){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "module_id=\""+objValue+"\" " ;
	xmlStr += "sub_code=\""+subValue+"\" " ;
	xmlStr += "mode=\""+mode+"\" " ;
	xmlStr += "sub_code1=\""+subValue1+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "HealthRiskFactorsIntermediate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	
}
  
function setTermCodeDesc(code,val){
	
	document.HealthRiskFactorsForDisease.diagprob_code.value=code;
	document.HealthRiskFactorsForDisease.diagprob_desc.value=val;
	getRiskFactorsDiseaseData();
}

function addRiskFactorsCode(tableID, modeObj)
{	
	var risk_factor_desc = document.HealthRiskFactorsForDisease.risk_factor_desc_.value;
	var risk_fact_code = eval("document.HealthRiskFactorsForDisease.risk_factor_code_").value;
	var dupCheck = "";
	var index = 0;
	if(risk_factor_desc == "" || risk_factor_desc == null)
	{	
		alert(" Please choose risk factor code to add new row ");
		return false;
	}
	if(risk_fact_code == "" || risk_fact_code == null)
	{	
		alert(" Please enter valid risk factor code... ");
		document.HealthRiskFactorsForDisease.risk_factor_desc_.value = "";
		return false;
	}
	var increment = 0;
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length
	var flagT = false;
	//alert("ADDED ROW COUNT " + addedRowCount);
	if(rowCount >1 ){
		for(var k=index;k<addedRowCount;k++){
			if(eval("document.HealthRiskFactorsForDisease.risk_fact_code"+k) != undefined )
			{
				dupCheck = "repeatLoop";
				var tes = eval("document.HealthRiskFactorsForDisease.risk_fact_code"+k).value;
				if(tes==risk_fact_code){
					eval("document.HealthRiskFactorsForDisease.risk_factor_desc_").value = "";
					flagT= true;
					break;
				}
				else {
					index++;
				}
			}
			else {
				index++;
			}	
		}
	}
	
	if(!flagT){
		var row = table.insertRow(rowCount);
		var rowid;
		
		if(modeObj ==1 ){
			rowid = (parseInt(document.HealthRiskFactorsForDisease.rowID.value))+1;
		}
		else {
			rowid = (parseInt(document.HealthRiskFactorsForDisease.rowID.value));
		}
		
		var cell1 = row.insertCell(0);
			cell1.className = 'gridData';
			desc = eval("document.HealthRiskFactorsForDisease.search_by_").value;
			if(desc=='I')
				desc='Individual';
			else if(desc=='G')
				desc='Group';
			cell1.innerHTML=desc;
		var cell2 = row.insertCell(1);
			cell2.className = 'gridData';
			cell2.innerHTML=eval("document.HealthRiskFactorsForDisease.risk_factor_desc_").value;
		var cell3 = row.insertCell(2);
			cell3.className = 'gridData';
		var cell4 = row.insertCell(3);
			cell4.className = 'gridData';
		
		var element1 = document.createElement("input");
			element1.style.width="230px";
			element1.type = "hidden";
			element1.id="search_by"+rowid;
			element1.name="search_by"+rowid;
			element1.readonly= true;
			searchby = eval("document.HealthRiskFactorsForDisease.search_by_").value;
			if(searchby=='I')
				desc='Individual';
			else if(searchby=='G')
				desc='Group';
			element1.value=searchby;
			cell1.appendChild(element1);	
		var element2 = document.createElement("input");
			element2.style.width="230px";
			element2.type = "hidden";
			element2.id="risk_fact_desc"+rowid;
			element2.name="risk_fact_desc"+rowid;
			element2.readonly= true;
			element2.value=eval("document.HealthRiskFactorsForDisease.risk_factor_desc_").value;
			eval("document.HealthRiskFactorsForDisease.risk_factor_desc_").value = "";
			cell2.appendChild(element1);			
		var element3 = document.createElement("input");
			element3.align = "center";
			element3.type = "checkbox";
			element3.id  ="mandatory"+rowid;
			element3.name="mandatory"+rowid;		
			element3.value="";
			element3.onclick = function(){if(this.checked)element3.value = 'Y'; else element3.value = 'N';};
			cell3.appendChild(element3);	
		var element4 = document.createElement("input");
			element4.align = "center";
			element4.type = "checkbox";
			element4.id  ="remove"+rowid;
			element4.name="remove"+rowid;		
			element4.value=rowid;
			cell4.appendChild(element4);	
		
		var element5 = document.createElement("input");
			element5.style.width="230px";
			element5.type = "hidden";
			element5.id="risk_fact_code"+rowid;
			element5.name="risk_fact_code"+rowid;
			element5.readonly= true;
			element5.value=eval("document.HealthRiskFactorsForDisease.risk_factor_code_").value;
			cell4.appendChild(element5);	
			
		document.HealthRiskFactorsForDisease.rowID.value = rowid;
		addedRowCount++;
	}
	else {
		alert(" Duplicate Risk Factor Code is not Allowed. ");
	}
}
function deleteRow(tableID){
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var rowChecked = 0;
	var modeObj =document.HealthRiskFactorsForDisease.mode.value 
	if(modeObj ==1 ){
		totalRows = (parseInt(document.HealthRiskFactorsForDisease.rowID.value))+1;
	}
	else {
		totalRows = (parseInt(document.HealthRiskFactorsForDisease.rowID.value));
	}
	for(var j=0; j<rowCount; j++) 
	{
		var row = table.rows[j];
		var chkbox = row.cells[3].childNodes[0];
		if(null != chkbox && true == chkbox.checked) 
		{	
			rowChecked ++;
		}
	}
	if(rowChecked < 1) {
		alert(" Please select atleast one checkbox to remove row ...");
		return false;
	}
	
	/*if(rowChecked == totalRows)
	{
		alert(" You should not delete all risk factor code ...");
		return false;
	} */
	
	var confirm_val= window.confirm(getMessage("DELETE ROWS","OR"));
	for(var i=0; i<rowCount; i++) 
	{
		if(confirm_val) 
		{
			var row = table.rows[i];
			var chkbox = row.cells[3].childNodes[0];
			if(null != chkbox && true == chkbox.checked) 
			{	
				table.deleteRow(i);
				rowCount--;
				i--;
				document.HealthRiskFactorsForDisease.risk_factor_code_.value = ""; //added for IN039555
			}
		}
	}
}
function showOtherFields(modeObj)
{
	
	var term_set_code = document.HealthRiskFactorsForDisease.terminology_set.value;
	if((term_set_code.length > 0 && modeObj == "2") || (term_set_code.length > 0 && modeObj == "1"))
	{
		document.getElementById("diag_diplay").style='display';
	  document.getElementById("search_diplay").style='display';
	 document.getElementById("search_diplay1").style='display';
		document.getElementById("search_data").style='display';
	}
	else
	{	
		document.getElementById("diag_diplay").style.display = 'none';
		document.getElementById("search_diplay").style.display = 'none';
		document.getElementById("search_diplay1").style.display = 'none';
		document.getElementById("search_data").style.display = 'none';
	}
}	

function getRiskFactorsDiseaseData(){
	var termSetID = document.HealthRiskFactorsForDisease.terminology_set.value;
	var diagProbCode = document.HealthRiskFactorsForDisease.diagprob_code.value;
	var tableID = document.getElementById('risk_fact_disease');
	var rowCount = tableID.rows.length;
	
	for (var i = document.getElementById("risk_fact_disease").rows.length; i > 1; i--) {
            document.getElementById("risk_fact_disease").deleteRow(i - 1);
    } 
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "termSetID=\""+termSetID+"\" " ;
	xmlStr += "diagProbCode=\""+diagProbCode+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "HealthRiskFactorsDiseaseIntermediate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ); 
}

function setRiskFactorCodesForDisease(risk_fact_id,risk_fact_desc,fact_mand_yn,risk_grp_type,rSize){
	var tableID = 'risk_fact_disease';
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;

	var rowid = (parseInt(rSize))-1;
	var row = table.insertRow(rowCount);

	var cell1 = row.insertCell(0);
		cell1.className = 'gridData';
		desc = risk_grp_type;
		if(desc=='I')
			desc='Individual';
		else if(desc=='G')
			desc='Group';
		cell1.innerHTML=desc;
	var cell2 = row.insertCell(1);
		cell2.className = 'gridData';
		cell2.innerHTML= risk_fact_desc;
	var cell3 = row.insertCell(2);
		cell3.className = 'gridData';
	var cell4 = row.insertCell(3);
		cell4.className = 'gridData';
		
	var element1 = document.createElement("input");
			element1.style.width="230px";
			element1.type = "hidden";
			element1.id="search_by"+rowid;
			element1.name="search_by"+rowid;
			element1.readonly= true;
			searchby = risk_grp_type;
			element1.value=searchby;
			cell1.appendChild(element1);	
	var element2 = document.createElement("input");
			element2.style.width="230px";
			element2.type = "hidden";
			element2.id="risk_fact_code"+rowid;
			element2.name="risk_fact_code"+rowid;
			element2.readonly= true;
			element2.value= risk_fact_id;
			cell2.appendChild(element2);			
	var element3 = document.createElement("input");
			element3.align = "center";
			element3.type = "checkbox";
			element3.id  ="mandatory"+rowid;
			element3.name="mandatory"+rowid;		
			element3.value=fact_mand_yn;
			element3.onclick = function(){if(this.checked)element3.value = 'Y';else element3.value = 'N';};
			cell3.appendChild(element3);	
			
	var element4 = document.createElement("input");
			element4.align = "center";
			element4.type = "checkbox";
			element4.id  ="remove"+rowid;
			element4.name="remove"+rowid;		
			element4.value=rowid;
			cell4.appendChild(element4);	

	var element5 = document.createElement("input");
			element5.type = "hidden";
			element5.id="risk_fact_code"+rowid;
			element5.name="risk_fact_code"+rowid;
			element5.value= risk_fact_id;
			
	if(fact_mand_yn=="Y"){
		document.getElementById("mandatory"+rowid).checked=true;
	}
	
	document.HealthRiskFactorsForDisease.rowID.value = rowid;
	addedRowCount++;
}
function refreshFields(){
	var term_set = document.HealthRiskFactorsForDisease.terminology_set.value;
	var diag_code =  document.HealthRiskFactorsForDisease.diagprob_code.value;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	if((term_set != "" && diag_code != "") || (term_set =="" && diag_code != "")) {
		var confirm_val= window.confirm(getMessage("CA_DIAG_SET_RESET","CA"));
		if(confirm_val) 
		{
			document.HealthRiskFactorsForDisease.diagprob_code.value = "";
			document.HealthRiskFactorsForDisease.diagprob_desc.value = "";
			document.HealthRiskFactorsForDisease.search_by_.value = "";
			for (var i = document.getElementById("risk_fact_disease").rows.length; i > 1; i--) {
					document.getElementById("risk_fact_disease").deleteRow(i - 1);
			} 
		}
	}	
}
