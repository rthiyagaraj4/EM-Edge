var addedRowCount = 0;
function create()
{ 
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactorGroup.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/CAHealthRiskFactorGroupQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}
function reset(){
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();
}
function apply()
{	
	var formobj= f_query_add_mod.document.HealthRiskFactorGroup;
	if(formobj != null){
		var fields = "";
		var names = "";
		var tableID = 'RiskFactGrid';
		var table = f_query_add_mod.document.getElementById(tableID);
		var rowCount = table.rows.length;
		
		if(rowCount < 2) {
			fields = new Array (f_query_add_mod.document.HealthRiskFactorGroup.risk_factor_code_,f_query_add_mod.document.HealthRiskFactorGroup.group_id, f_query_add_mod.document.HealthRiskFactorGroup.group_desc); 
			names = new Array (getLabel("eCA.riskfactor.label",'eCA'), getLabel("Common.code.label",'Common'),getLabel("Common.description.label",'Common')); 
		} else {
			fields = new Array (f_query_add_mod.document.HealthRiskFactorGroup.group_id, f_query_add_mod.document.HealthRiskFactorGroup.group_desc); 
			names = new Array ( getLabel("Common.code.label",'Common'),getLabel("Common.description.label",'Common')); 
		}
		
		if(checkFieldsofMst(fields,names,messageFrame))
		{	
			f_query_add_mod.document.HealthRiskFactorGroup.action="../../servlet/eCA.RiskFactorGroupServlet";
			f_query_add_mod.document.HealthRiskFactorGroup.target="messageFrame";
			f_query_add_mod.document.HealthRiskFactorGroup.method="post";
			f_query_add_mod.document.HealthRiskFactorGroup.submit();	
		}
	}
	else {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	}
}
function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyHealthRiskFactorGroup.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	
	//f_query_add_mod.location.reload();        	
}
	
async function riskFactorsearchOnClick(risk_fact_obj)
{	
	if(risk_fact_obj.value ==undefined)
	{
		risk_fact_obj.value ="";
	}
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var sql ="SELECT RISK_FACTOR_TYPE code,RISK_FACTOR_DESC description FROM CA_RISK_FACTOR_TYPE where eff_status='E' and upper(RISK_FACTOR_TYPE) like upper(?) and  upper(RISK_FACTOR_DESC) like upper(?)"; 
	sql = sql +"ORDER BY  2";
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=risk_fact_obj.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	retval= await CommonLookup(getLabel("eCA.RiskFactorId.label","CA"),argumentArray);

	if(retval !=null && retval != ""){
		var str =unescape(retval);
	 	var arr = str.split(",");
		risk_fact_obj.value=arr[0];
		eval("document.HealthRiskFactorGroup.risk_factor_code_").value = arr[0];
		eval("document.HealthRiskFactorGroup.risk_factor_desc_").value = arr[1];
		
	}
}

function addRiskFactorsCode(tableID, modeObj)
{	
	var risk_factor_desc = document.HealthRiskFactorGroup.risk_factor_desc_.value;
	var risk_fact_code = eval("document.HealthRiskFactorGroup.risk_factor_code_").value;
	var risk_fact_code = eval("document.HealthRiskFactorGroup.risk_factor_code_").value;
	if(risk_factor_desc == "" || risk_factor_desc == null)
	{	
		alert(" Please choose risk factor code to add new row ");
		return false;
	}
	if(risk_fact_code == "" || risk_fact_code == null)
	{	
		alert(" Please enter valid risk factor code... ");
		document.HealthRiskFactorGroup.risk_factor_desc_.value = "";
		return false;
	}
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length
	var flagT = false;
	var index = 0;
	if(modeObj ==1 ){
		addedRowCount = (parseInt(document.HealthRiskFactorGroup.rowID.value))+1;
	}
	else {
		addedRowCount = document.HealthRiskFactorGroup.rowID.value;
	}	
	if(rowCount >1){
		for(var k=index;k<addedRowCount;k++){
			if(eval("document.HealthRiskFactorGroup.risk_fact_code"+k) != undefined )
			{
				dupCheck = "repeatLoop";
				var tes = eval("document.HealthRiskFactorGroup.risk_fact_code"+k).value;
				
				if(tes==risk_fact_code){
					eval("document.HealthRiskFactorGroup.risk_factor_desc_").value = "";
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
	//	var rowid = table.rows.length-1;
		var rowid = addedRowCount;
		
	/*	if(modeObj ==1 ){
			rowid = (parseInt(document.HealthRiskFactorGroup.rowID.value))+1;
		}
		else {
			rowid = (parseInt(document.HealthRiskFactorGroup.rowID.value));
			 
		} */
		var cell1 = row.insertCell(0);
	
			cell1.className = 'gridData';
			cell1.innerHTML=eval("document.HealthRiskFactorGroup.risk_factor_desc_").value;
		var cell2 = row.insertCell(1);
			cell2.className = 'gridData';

		var element1 = document.createElement("input");
			element1.style.width="230px";
			element1.type = "hidden";
			element1.id="risk_fact_code"+rowid;
			element1.name="risk_fact_code"+rowid;
			element1.readonly= true;
			element1.value=eval("document.HealthRiskFactorGroup.risk_factor_code_").value;
			eval("document.HealthRiskFactorGroup.risk_factor_desc_").value = "";
			cell1.appendChild(element1);		
		var element2 = document.createElement("input");
				element2.type = "checkbox";
				element2.id  ="remove"+rowid;
				element2.name="remove"+rowid;		
				element2.value=rowid;
			cell2.appendChild(element2);	
		
		document.HealthRiskFactorGroup.rowID.value = rowid;
		
		addedRowCount++;
		
	}else {
		alert(" Duplicate Risk Factor Code is not Allowed. ");
	}
}
function deleteRow(tableID){
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var rowChecked = 0;
	var modeObj =document.HealthRiskFactorGroup.mode.value 
	if(modeObj ==1 ){
		totalRows = (parseInt(document.HealthRiskFactorGroup.rowID.value))+1;
	}
	else {
		totalRows = (parseInt(document.HealthRiskFactorGroup.rowID.value));
	}
	for(var j=0; j<rowCount; j++) 
	{
			var row = table.rows[j];
			var chkbox = row.cells[1].childNodes[0];
			if(null != chkbox && true == chkbox.checked) 
			{	
				rowChecked ++;
			}
	}
	/* if(rowChecked == totalRows)
	{
		alert(" You should not delete all risk factor code ...");
		return false;
	} */
	if(rowChecked < 1) {
		alert(" Please select atleast one checkbox to remove row ...");
		return false;
	}
	var confirm_val= window.confirm(getMessage("DELETE ROWS","OR"));
	for(var i=0; i<rowCount; i++) 
	{
		if(confirm_val) 
		{
			var row = table.rows[i];
			var chkbox = row.cells[1].childNodes[0];
			if(null != chkbox && true == chkbox.checked) 
			{	
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		}
	}
}
function setEffStauts(obj){
	if(obj.checked){
		document.HealthRiskFactorGroup.eff_status.value="E";
	}else{
		document.HealthRiskFactorGroup.eff_status.value="D";
	}
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

function refreshFooter(){
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
}
