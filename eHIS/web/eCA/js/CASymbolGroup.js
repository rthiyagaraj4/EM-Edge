/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
08/04/2013    IN030708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
28/05/2013    IN040319        Karthi	System is not responding
---------------------------------------------------------------------------------------------------------
*/
var addedRowCount = 0;

function create()
{ 
	f_query_add_mod.location.href='../../eCA/jsp/AddModifySymbolGroup.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/CASymbolGroupQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}
function reset(){
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();
}
function apply()
{	
	var formobj= f_query_add_mod.document.SymbolGroup;
	if(formobj != null){
		var fields = "";
		var names = "";
		var tableID = 'NoteGroupGrid';
		var table = f_query_add_mod.document.getElementById(tableID);
		var rowCount = table.rows.length;
		
		if(rowCount < 2) {
			var note_grp_id = f_query_add_mod.document.SymbolGroup.note_group_id_.value;
			// added for IN040319
			if(rowCount ==1)
			{
				note_grp_id = "";
			}
			fields = new Array (f_query_add_mod.document.SymbolGroup.group_id, f_query_add_mod.document.SymbolGroup.group_desc,note_grp_id); // modified for IN040319 
			names = new Array (getLabel("eCA.symbolgrpid.label",'CA'),getLabel("eCA.symbolgrpdesc.label",'CA'),getLabel("eCA.ntegrpntetypemand.label",'CA')); 
		} else {
			fields = new Array (f_query_add_mod.document.SymbolGroup.group_id, f_query_add_mod.document.SymbolGroup.group_desc); 
			names = new Array (getLabel("eCA.symbolgrpid.label",'CA'),getLabel("eCA.symbolgrpdesc.label",'CA')); 
		}
		
		if(checkFieldsofMst(fields,names,messageFrame))
		{	
			f_query_add_mod.document.SymbolGroup.action="../../servlet/eCA.CASymbolGroupServlet";
			f_query_add_mod.document.SymbolGroup.target="messageFrame";
			f_query_add_mod.document.SymbolGroup.method="post";
			f_query_add_mod.document.SymbolGroup.submit();	
		}
	}
	else {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
	}
}
function onSuccess()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifySymbolGroup.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

async function  getNoteGroupCode()
{	
	var search_by =  document.SymbolGroup.search_by_.value;
	var noteDescObj = document.SymbolGroup.note_group_desc_.value;
	if(noteDescObj == undefined)
	{
		noteDescObj ="";
	}
	
	if(search_by=="" || search_by==null) {
		alert(" Please select any of the type code");
		 document.SymbolGroup.note_group_desc_.value = "";
		return false;
	}
	
	var sql = "";
	var title = "";
	if(search_by == "G") {
		sql = "SELECT note_group code, note_group_desc description FROM ca_note_group where eff_status='E' and upper(note_group) like upper(?) and  upper(note_group_desc) like upper(?) order by 2";
		title  = getLabel("eCA.NoteGroup.label","CA");
	}
	else {
		sql =  "SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) order by 2";
		title = getLabel("Common.NoteType.label","Common"); 
	}
	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = noteDescObj;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray =await CommonLookup( title, argArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	document.SymbolGroup.note_group_desc_.value =""; //added for IN040319
	if(retArray != null && retArray !="")	
	{
		document.SymbolGroup.note_group_desc_.value = arr[1];
		document.SymbolGroup.note_group_id_.value = arr[0];
	} 
}

function addNoteType(tableID, modeObj)
{	
	var note_group_desc = document.SymbolGroup.note_group_desc_.value;
	var note_group_id = eval("document.SymbolGroup.note_group_id_").value; 
	var search_by_id =  eval("document.SymbolGroup.search_by_").value; 
	if(note_group_desc == "" || note_group_desc == null)
	{	
		//alert(" Please choose note group & note type codes to add new row "); commented for IN041021
		alert(getMessage("NOTEGROUP_NOTETYPE","CA")); // modified for IN041021
		return false;
	}
	if(note_group_id == "" || note_group_id == null)
	{	
		alert(" Please enter valid code... ");
		document.SymbolGroup.note_group_desc_.value = "";
		return false;
	}
	
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length
	var flagT = false;
	var index = 0;
	if(modeObj ==1 ){
		addedRowCountaddedRowCount = (parseInt(document.SymbolGroup.rowID.value))+1;
	}
	else if(modeObj ==2 && addedRowCount < document.SymbolGroup.rowID.value ){
		addedRowCount = document.SymbolGroup.rowID.value;
	}
	if(rowCount >1){	
		for(var k=index;k<rowCount;k++){
			if((eval("document.SymbolGroup.note_group_id"+k) != undefined) && (eval("document.SymbolGroup.search_by"+k) != undefined))
			{
				dupCheck = "repeatLoop";
			
				var note_group = eval("document.SymbolGroup.note_group_id"+k).value;
				var search_by =  eval("document.SymbolGroup.search_by"+k).value;
				if(note_group == note_group_id && search_by == search_by_id){
					eval("document.SymbolGroup.note_group_desc_").value = "";
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
		var rowid = addedRowCount;
		var cell1 = row.insertCell(0);
			cell1.className = 'gridData';
			desc = eval("document.SymbolGroup.search_by_").value;
			if(desc=='G')
				desc='Note Group';
			else if(desc=='T')
				desc='Note Type';
			cell1.innerHTML=desc;
		var cell2 = row.insertCell(1);
			cell2.className = 'gridData';
			cell2.innerHTML=eval("document.SymbolGroup.note_group_desc_").value;
		
		var cell3 = row.insertCell(2);
			cell3.className = 'gridData';

		var element1 = document.createElement("input");
			element1.style.width="230px";
			element1.type = "hidden";
			element1.id="search_by"+rowid;
			element1.name="search_by"+rowid;
			element1.readonly= true;
			searchby = eval("document.SymbolGroup.search_by_").value;
			if(searchby=='G')
				desc='Note Group';
			else if(searchby=='T')
				desc='Note Type';
			element1.value=searchby;
			cell1.appendChild(element1);	
		var element2 = document.createElement("input");
			element2.style.width="230px";
			element2.type = "hidden";
			element2.id="note_group_id"+rowid;
			element2.name="note_group_id"+rowid;
			element2.readonly= true;
			element2.value=eval("document.SymbolGroup.note_group_id_").value;
			eval("document.SymbolGroup.note_group_desc_").value = "";
			cell2.appendChild(element2);		
		
		var element3 = document.createElement("input");
			element3.type = "checkbox";
			element3.id  ="remove"+rowid;
			element3.name="remove"+rowid;		
			element3.value=rowid;
			cell3.appendChild(element3);	
		
		document.SymbolGroup.rowID.value = rowid;
		addedRowCount++;
		
	}else {
		alert(" Duplicate Code is not Allowed. ");
	}
}
function deleteRow(tableID){
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var rowChecked = 0;
	var modeObj =document.SymbolGroup.mode.value 
	if(modeObj ==1 ){
		totalRows = (parseInt(document.SymbolGroup.rowID.value))+1;
	}
	else {
		totalRows = (parseInt(document.SymbolGroup.rowID.value));
	}
	for(var j=0; j<rowCount; j++) 
	{
			var row = table.rows[j];
			var chkbox = row.cells[2].childNodes[0];
			if(null != chkbox && true == chkbox.checked) 
			{	
				rowChecked ++;
			}
	}
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
			var chkbox = row.cells[2].childNodes[0];
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
		document.SymbolGroup.eff_status.value="E";
	}else{
		document.SymbolGroup.eff_status.value="D";
	}
}

function refreshFooter(){
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
}
function enableDisableFields(mode) {
	
	var search_by_id = document.SymbolGroup.search_by_.value;
	var table = document.getElementById('NoteGroupGrid');
	var rowCount = table.rows.length;	
	
	if(search_by_id.length > 0 || mode == "2") {
		
		document.getElementById("note_idicator_enable").style='display';
		document.getElementById("eff_status_enable").style='display';
		document.getElementById("note_table_enable").style='display';
		if(search_by_id == 'G')
		{
			document.getElementById("note_grp_type").innerHTML =  getLabel("eCA.NoteGroup.label","ca_labels"); 
			document.SymbolGroup.note_group_desc_.value = "";
		}
		else
		{	
			document.getElementById("note_grp_type").innerHTML =  getLabel("Common.NoteType.label","common_labels"); 
			document.SymbolGroup.note_group_desc_.value = "";
		}
	}
	else if(rowCount < 2){
		document.getElementById("note_idicator_enable").style.display = "none";
		document.getElementById("eff_status_enable").style.display = "none";
		document.getElementById("note_table_enable").style.display = "none";
	}
	else {
		if(search_by_id == 'G')
		{
			document.getElementById("note_grp_type").innerHTML =  getLabel("eCA.NoteGroup.label","ca_labels"); 
			document.SymbolGroup.note_group_desc_.value = "";
		}
		else
		{	
			document.getElementById("note_grp_type").innerHTML =  getLabel("Common.NoteType.label","common_labels"); 
			document.SymbolGroup.note_group_desc_.value = "";
		}
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
