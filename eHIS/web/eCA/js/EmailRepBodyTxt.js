var messageFrameReference = parent.parent.messageFrame;
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/EmailRepBodyTxt.jsp?mode=insert';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/EmailRepBodyTxtQueryCriteria.jsp?mode=modify';
}
 
function reset() 
{
	var frameObj=f_query_add_mod
	if(frameObj.EmailRepBodyTxtHdrFrame != null)
	{ 
		var mode=frameObj.EmailRepBodyTxtHdrFrame.document.EmailRepBodyTxtHdrForm.mode.value
		if(mode=="insert"){
		frameObj.EmailRepBodyTxtHdrFrame.document.location.href="../../eCA/jsp/EmailRepBodyTxtHdr.jsp?mode=insert";
		frameObj.EmailRepBodyTxtPrevEdtrFrame.document.location.href="../../eCommon/html/blank.html";
		frameObj.EmailRepBodyTxtListFrame.document.location.href="../../eCommon/html/blank.html";
		frameObj.EmailRepBodyTxtEdtrFrame.document.location.href="../../eCommon/html/blank.html";
		frameObj.EmailRepBodyTxtEdtrBttnFrame.document.location.href="../../eCommon/html/blank.html";	
		}else{
			f_query_add_mod.location.reload();
		}
	}
	else if(frameObj.document.forms[0])
	{
		frameObj.document.forms[0].reset();
	}
}

function populateReportId(obj){
	document.EmailRepBodyTxtHdrForm.module_id.value=obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "module_id=\""+obj.value+"\" " ;
	xmlStr += "mode=\""+document.EmailRepBodyTxtHdrForm.mode.value+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EmailRepBodyTxtIntermediate.jsp",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}
function clearReportId( docObj ) 
{
	var len = eval(docObj+".EmailRepBodyTxtHdrForm.reportId.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".EmailRepBodyTxtHdrForm.reportId.remove(\"report_id\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".EmailRepBodyTxtHdrForm.reportId.add(opt)") ;
}
function addReportId(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.EmailRepBodyTxtHdrForm.reportId.add(element);
}

function openEditor(){
	var formObj=parent.EmailRepBodyTxtHdrFrame.document.EmailRepBodyTxtHdrForm
	formObj.module_id.value=formObj.moduleId.value;
	formObj.report_id.value=formObj.reportId.value;
	if((formObj.module_id.value!="") && (formObj.report_id.value!="")) {
		formObj.moduleId.disabled=true;
		formObj.reportId.disabled=true;
		parent.EmailRepBodyTxtPrevEdtrFrame.location.href="EmailRepBodyTxtPrevTemp.jsp";		parent.EmailRepBodyTxtListFrame.location.href="EmailRepBodyTxtList.jsp?module_id="+formObj.module_id.value+"&report_id="+formObj.report_id.value+"&body_text_ref="+formObj.body_text_ref.value;
		parent.EmailRepBodyTxtEdtrFrame.location.href="../../eCommon/jsp/RTEditor.jsp";
		parent.EmailRepBodyTxtEdtrBttnFrame.location.href = "EmailRepBodyTxtEdtrBtn.jsp?module_id="+formObj.module_id.value+"&report_id="+formObj.report_id.value+"&body_text_ref="+formObj.body_text_ref.value+"&mode="+formObj.mode.value;	
	 }else{
	 	formObj.moduleId.disabled=false;
		formObj.reportId.disabled=false;
	 } 
}

// to set the value in the editor
 function setPrevTemplate(obj){
	if(obj!=null && obj!=""){
 		var new_value = "~"+obj+"`";     
  	    parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.body.focus();
		parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.clear();
  		var object_result = parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.execCommand("paste","",new_value);
 		if(!object_result)
			alert(getMessage("TRY_AFTER","OR"))
	}
 }

function setEditorTemplate(){
	// Setting the value to the editor.
	var RTEText = document.getElementById("RTEText").value;
	if(RTEText!="") {		
 		alert(getMessage("DO_WANT_VIEW","OR"));
		parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.body.innerHTML = RTEText;
	}
}

async function previewEditor(){
	RTEText					= parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.body.innerHTML
	
	var xmlDoc 				= "";
	var xmlHttp 			= new XMLHttpRequest() ;
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "html_format=\""+checkSpl(RTEText)+"\" ";
	xmlStr 			+=" /></root>" ;
//	alert("@@@@ RTEText="+RTEText);
//	alert("@@@@ checkSpl(RTEText)="+checkSpl(RTEText));
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EmailRepBodyTxtIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

	if(RTEText!="") {
		var dialogHeight	= '32vh' ;
		var dialogWidth		= '50vw' ;
		var dialogTop		= '30';
		var dialogLeft		= '100' ;
		var title			= ''
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals			=  await window.showModalDialog("../../eCA/jsp/EmailRepBodyTxtPrev.jsp",arguments,features);
	}
 }

function showTable(){
  	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eCA.NoofRows.label","CA")+"</td><td class='fields'><input type='text' name='rows' id='rows' size='2' maxLength='2' value='5' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td><td class='data' nowrap"+getLabel("eOR.NoofColumns.label","OR")+"</td><td class='fields'><input type='text' name='cols' id='cols' size='1' maxLength='1'  value='3' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>"
	tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' value="+getLabel("Common.ok.label","Common")+" onClick='setBuildTable()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 	tab_dat     += "</table> "
	resizeWindow(tab_dat);

}

function CaAllowNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}

function CaCheckNumber(obj) {
	var sequence = "0123456789";
	var obj_value = obj.value;
	var obj_length = obj_value.length;

	for (i=0; i<obj_length; i++)   {
		if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
   }

   return true ;
}

function setBuildTable(){

	var rows = document.getElementById("rows").value;
	var cols = document.getElementById("cols").value;
	var table =  parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementsByTagName("TABLE");
	var table_length = table.length;
   	if(rows > 0 && cols > 0) {
  		var htmlTable	= 	"<TABLE id='table"+table_length+"'  border=1 CELLPADDING='3' CELLSPACING='0' BORDERCOLOR='black' align=center>";
		for(i=0;i<rows;i++) {
			htmlTable	+= "<TR>";
			for(j=0;j<cols;j++) {
				htmlTable	+= "<TD></TD>";
			}
			htmlTable	+= "</TR>";
		}
		htmlTable+="</TABLE>";
	 	parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",htmlTable);
		hideToolTip();

		document.getElementById("add_table").style.visibility = 'visible'
		document.getElementById("add_table_gif").style.visibility = 'visible'
		document.getElementById("delete_table").style.visibility = 'visible'	
		document.getElementById("delete_table_gif").style.visibility = 'visible'
	}
}


function hideToolTip()	{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

function addTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNo.label","OR")+"</td><td class='fields'><input type='text' name='add_row' id='add_row' size='2' maxLength='2' value='2' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>"
	tab_dat		+="<td class='data' nowrap>"+getLabel("eOR.ColumnNo.label","OR")+"</td><td class='fields'><input type='text' name='add_columns' id='add_columns' size='1' maxLength='1' value='1' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>";
	tab_dat     += "<td class='fields'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='addTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 	tab_dat     += "</table> "
	resizeWindow(tab_dat);	
}

function resizeWindow(tab_dat){
	document.getElementById("t").innerHTML					= tab_dat;
	document.getElementById("tooltiplayer").style.posLeft		= 202
	document.getElementById("tooltiplayer").style.posTop		= 0
	document.getElementById("tooltiplayer").style.visibility	='visible'
}

function addTableRow(){	
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
 		table_no	= parseInt(table_no-1);
 	}	
	else
		table_no	= 0;
   	if(table_no>=0){
   		var rows		= document.getElementById("add_row").value;
		var cols		= document.getElementById("add_columns").value;
 		if(rows > 1) {
			rows	 = rows-1;
			if(cols!="" && cols>0)
				cols = parseInt(cols);
   	 		if(parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && rows>0) {
				if(parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length!=0)
	  				parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).insertRow(rows);
			}
			for( j=0;j<cols;j++) {
				if(parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows])
					parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows].insertCell();
	  		}
		}
	}
}


function deleteTable(){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 	tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='1' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNotobedeleted.label","OR")+"</td><td class='fields'><input type='text' name='delete_row' id='delete_row' size='2' maxLength='2' value='1' onKeyPress='return CaAllowNumber()' onBlur='return CaCheckNumber(this)' ></td>"
	tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='CAdeleteTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 	tab_dat     += "</table> "
	resizeWindow(tab_dat);	
}

function CAdeleteTableRow(){
	hideToolTip();
	var table_no	= document.getElementById("table_no").value;
	if(table_no!="" && table_no!=0) {
 		table_no	= parseInt(table_no-1);
	}	
	else
		table_no	= 0;
	var rows = document.getElementById("delete_row").value;
	if(rows!="")
		rows = parseInt(rows) - 1;
	if(parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && 	parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows])
	{
		parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).deleteRow(rows);
 		if(parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length==0){
			parent.EmailRepBodyTxtEdtrFrame.RTEditor0.document.getElementById("table"+table_no).clear;
 		}
	}
}

function apply(){
	if(f_query_add_mod.EmailRepBodyTxtHdrFrame !=null){
		var formObj			= f_query_add_mod.EmailRepBodyTxtHdrFrame.document.EmailRepBodyTxtHdrForm;
		var fields = new Array (formObj.module_id,formObj.report_id,formObj.body_text_ref,formObj.body_text_dec);

		var names = new Array ( getLabel("Common.Module.label","COMMON"),getLabel("Common.report.label","COMMON"),getLabel("eCA.ReportBodyTextID.label","CA"),getLabel("eCA.ReportBodyTextDesc.label","CA"));
		if(f_query_add_mod.EmailRepBodyTxtHdrFrame.checkFieldsofMst( fields, names, messageFrame)) {
			RTEText					= f_query_add_mod.EmailRepBodyTxtEdtrFrame.RTEditor0.document.body.innerHTML
				
			var xmlDoc 				= "";
			var xmlHttp 			= new XMLHttpRequest() ;
			xmlStr					= "<root><SEARCH " ;
			xmlStr					+= "html_format=\"" +checkSpl(RTEText)+"\" ";
			xmlStr 			+=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "EmailRepBodyTxtIntermediate.jsp", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;
				
			formObj.submit();
		}
	}else{
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
}
function onSuccess()
{
	f_query_add_mod.location.reload();

}


