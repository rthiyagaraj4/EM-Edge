var messageFrameReference = parent.parent.messageFrame;
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/SecTempOutputForm.jsp';
}
function reset() 
{
	f_query_add_mod.SecTempOutputFormHeaderFrame.document.location.href="../../eCA/jsp/SecTempOutputFormHeader.jsp";
	f_query_add_mod.SecTempOutputFormPrevEdtrFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.SecTempOutputFormListFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.SecTempOutputFormEdtrFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.SecTempOutputFormEdtrBttnFrame.document.location.href="../../eCommon/html/blank.html";	

}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


//populate section values

function populate(object)
{
	var target = document.forms[0].sect_name;
	if(object.name=='sect_name')
	{
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			
			populateSections();
		}
	}
	else if(object.name=='section_button')
	{
		populateSections();   
	}

}

async function populateSections()
{
	
	var target = document.forms[0].sect_name;	
	var title = getLabel("Common.Section.label","COMMON");
	var sql = "select sec_hdg_code CODE, sec_hdg_desc || ' - ' || NVL(sec_hdr_meta_desc,'') description from ca_section_hdg where eff_status='E' and OUTPUT_FORM_EXISTS_YN='Y' and modifiable_yn='Y' and upper(sec_hdg_desc) like upper(?) and sec_hdg_code like upper(?) ";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "2,1";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray =await CommonLookup( title, argArray );
	var str =unescape(retArray);
	var arr = str.split(",");

	if(retArray != null && retArray !="")	
	{
		document.forms[0].sect_name.value = arr[1];
		document.forms[0].section.value = arr[0];
		/************************/
		if(document.forms[0].section.value !=""){
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr += " section=\""+document.forms[0].section.value+ "\" ";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","SecTempOutputFormIntermediate.jsp",false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;			
			eval( responseText ) ;
		}	
		/************************/
		openEditor(document.forms[0]); 
	}
	else
	{
		document.forms[0].sect_name.value = "";
		document.forms[0].section.value = "";
	}
}
function openEditor(formObj){
	if(parent.frames[0].document.forms[0].section.value!="" ) {
		parent.SecTempOutputFormPrevEdtrFrame.location.href="SecTempOutputFormPreviewTemplate.jsp";
		parent.SecTempOutputFormListFrame.location.href="SecTempOutputFormList.jsp?section="+parent.frames[0].document.forms[0].section.value+"&contentType="+parent.frames[0].document.forms[0].contentType.value;
		parent.SecTempOutputFormEdtrFrame.location.href="../../eCommon/jsp/RTEditor.jsp";
		parent.SecTempOutputFormEdtrBttnFrame.location.href = "SecTempOutputFormEditorButton.jsp?section="+parent.frames[0].document.forms[0].section.value;	
		//parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	 } 
}

// to set the value in the editor
/* function setPrevTemplate(obj){
	 //alert('obj='+obj);
	if(obj!=null && obj!=""){
 		var new_value = "~"+obj+"`";     
  	    parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.focus();
		parent.SecTempOutputFormEdtrFrame.RTEditor0.document.clear();
  		var object_result = parent.SecTempOutputFormEdtrFrame.RTEditor0.document.execCommand("paste","",new_value);
 		if(!object_result)
			alert(getMessage("TRY_AFTER","OR"))
	}
 }*/
/*function setPrevTemplate(obj) {
    if (obj != null && obj !== "") {
        var new_value = "~" + obj + "`";  // Add ~ and ` around the template string

        // Get the editor document
        var editorDoc = parent.SecTempOutputFormEdtrFrame.RTEditor0.document;
        var editorBody = editorDoc.body; // Get the body of the editor

        // Focus on the editor body
        editorBody.focus();

        // Clear the editor content
       // editorBody.innerHTML = ''; // Clear existing content

        // Insert new content into the editor
        var range = editorDoc.createRange();
        var selection = editorDoc.getSelection();

        // Ensure there's a valid selection to insert content
        if (selection.rangeCount > 0) {
            // Get the current range (the selection in the editor)
            range = selection.getRangeAt(0);  // Get the range at the current cursor position

            // Delete the selected content (if any) and insert the new content
           // range.deleteContents(); 
            range.insertNode(editorDoc.createTextNode(new_value)); // Insert the new value as text
        } else {
            // If no selection exists, insert at the cursor or end of the body
            var textNode = editorDoc.createTextNode(new_value);
            editorBody.appendChild(textNode); // Append the text directly into the body
        }

        // Optionally, show a message if the operation failed
        if (new_value === "") {
            alert(getMessage("TRY_AFTER", "OR"));
        }
    }
}*/
/*function setPrevTemplate(obj) {
    if (obj != null && obj !== "") {
        var new_value = "~" + obj + "`";  // Add ~ and ` around the template string

        // Get the editor document
        var editorDoc = parent.SecTempOutputFormEdtrFrame.RTEditor0.document;
        var editorBody = editorDoc.body; // Get the body of the editor

        // Focus on the editor body
        editorBody.focus();

        // Create a text node with the new value
        var textNode = editorDoc.createTextNode(new_value);

        // Append the text node at the end of the editor body
        editorBody.appendChild(textNode); // Always append to the end of the editor body

        // Optionally, show a message if the operation failed
        if (new_value === "") {
            alert(getMessage("TRY_AFTER", "OR"));
        }
    }
}
*/
//append and cursor
// function setPrevTemplate(obj) {
//     if (obj != null && obj !== "") {
//         var new_value = "~" + obj + "`";  // Add ~ and ` around the template string

//         // Get the editor document
//         var editorDoc = parent.SecTempOutputFormEdtrFrame.RTEditor0.document;
//         var editorBody = editorDoc.body; // Get the body of the editor

//         // Focus on the editor body
//         editorBody.focus();

//         // Create a text node with the new value
//         var textNode = editorDoc.createTextNode(new_value);

//         // Append the text node at the end of the editor body
//         editorBody.appendChild(textNode); // Always append to the end of the editor body

//         // Move the cursor to the end of the editor body
//         var range = editorDoc.createRange();
//         var selection = editorDoc.getSelection();
//         range.selectNodeContents(editorBody); // Select the entire contents of the body
//         range.collapse(false); // Collapse to the end of the body
//         selection.removeAllRanges(); // Remove any existing selections
//         selection.addRange(range); // Set the new range to the end of the body

//         // Optionally, show a message if the operation failed
//         if (new_value === "") {
//             alert(getMessage("TRY_AFTER", "OR"));
//         }
//     }
// }
function setPrevTemplate(obj) {
    if (obj != null && obj !== "") {
        var new_value = "~" + obj + "`";  // Add ~ and ` around the template string

        // Get the editor document
        var editorDoc = parent.SecTempOutputFormEdtrFrame.RTEditor0.document;
        var editorBody = editorDoc.body; // Get the body of the editor

        // Focus on the editor body
        editorBody.focus();

        // Get the current selection and range (i.e., the cursor position)
        var selection = editorDoc.getSelection();
        var range = selection.getRangeAt(0);

        // Create a text node with the new value
        var textNode = editorDoc.createTextNode(new_value);

        // Insert the text node at the current cursor position
        range.deleteContents();  // Remove any selected text (if any)
        range.insertNode(textNode);  // Insert the new text at the cursor

        // Move the cursor after the inserted text
        range.setStartAfter(textNode);
        range.setEndAfter(textNode);

        // Update the selection to the new cursor position (after the inserted text)
        selection.removeAllRanges();
        selection.addRange(range);

        // Optionally, show a message if the operation failed
        if (new_value === "") {
            alert(getMessage("TRY_AFTER", "OR"));
        }
    }
}


function setEditorTemplate()
{
	// Setting the value to the editor.
	var RTEText = document.getElementById("RTEText").value;
	parent.SecTempOutputFormHeaderFrame.document.SecTempOutputFormHeaderForm.mode.value=parent.SecTempOutputFormEdtrBttnFrame.document.editorButtonForm.mode.value
	parent.SecTempOutputFormEdtrFrame.RTEditor0.document.designMode = "On";
	parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.focus();
	parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.innerHTML = "";
	parent.SecTempOutputFormEdtrFrame.RTEditor0.document.execCommand("formatBlock","", "Address");
	
	if(RTEText!="") {		
		
 		alert(getMessage("DO_WANT_VIEW","OR"));
		//parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.innerHTML = RTEText;
		parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",RTEText);
	}
		//previewEditor();
		//storeEditor();

}
function checkSplChars( val ) {
    var result = "" ;
    var ch = "" ;

    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;
    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }

    return result ;
}
async function previewEditor(){
	RTEText					= parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.innerHTML
	

	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "html_format=\""+checkSplChars(RTEText)+"\" ";
	xmlStr 			+=" /></root>" ;
//	alert("@@@@ RTEText="+RTEText);
	//alert("@@@@ checkSplChars(RTEText)="+checkSplChars(RTEText));
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SecTempOutputFormIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

	if(RTEText!="") {
		var dialogHeight	= '50vh' ;
		var dialogWidth		= '50vw' ;
		var dialogTop		= '30';
		var dialogLeft		= '100' ;
		var title			= ''
		var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals			=await  window.showModalDialog("../../eCA/jsp/SecTempOutputFormPrev.jsp",arguments,features);
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
	var table =  parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementsByTagName("TABLE");
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
	 	parent.SecTempOutputFormEdtrFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",htmlTable);
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
	document.getElementById("tooltiplayer").style.marginLeft= '200px'
	document.getElementById("tooltiplayer").style.marginTop		= '-22px'
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
		//	console.log(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no));
			if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && rows>0){
			//	console.log("inside 329");
			}
			console.log(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length);
			if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length!=0){
			//	console.log("insiide 333");
			}
		//	console.log(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).insertRow(rows));
   	 		if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && rows>0) {
				if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length!=0)
	  				parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).insertRow(rows);
			}
			for( j=0;j<cols;j++) {
				if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows])
					/*parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no)+".rows["+rows+"].insertCell()";*/
					parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table" + table_no).rows[rows].insertCell();

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
//	console.log(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no));
	
//	console.log(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows["+rows+"]);
//	console.log(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows]);
	
	
	if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no)){
	//	console.log("iniosde 365");
	}
	if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows]){
	//	console.log("inside 368");
	}
	if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no) && parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows[rows])
	{
		parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).deleteRow("+rows+");
 		if(parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).rows.length==0){
			parent.SecTempOutputFormEdtrFrame.RTEditor0.document.getElementById("table"+table_no).clear;
 		}
	}
}

function apply(){
	var formObj			= f_query_add_mod.SecTempOutputFormHeaderFrame.document.SecTempOutputFormHeaderForm;
	RTEText					= f_query_add_mod.SecTempOutputFormEdtrFrame.RTEditor0.document.body.innerHTML
		

	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "html_format=\"" +checkSplChars(RTEText)+"\" ";
	xmlStr 			+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SecTempOutputFormIntermediate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
//	alert("@@@@ formObj.mode="+formObj.mode.value);
	eval( responseText ) ;
		
	formObj.submit();
}
function onSuccess()
{
	
	//alert('onSUccess');
	if(f_query_add_mod.SecTempOutputFormHeaderFrame.document.forms[0].mode.value=="insert"){
		//alert("111111");
		f_query_add_mod.location.href='../../eCA/jsp/SecTempOutputForm.jsp?mode=insert';
	}
	else if(f_query_add_mod.SecTempOutputFormHeaderFrame.document.forms[0].mode.value=="modify"){
		//alert("2222");
			f_query_add_mod.SecTempOutputFormEdtrFrame.location.reload();
		   f_query_add_mod.SecTempOutputFormEdtrBttnFrame.location.reload();
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function handleKeyDown(event) {
    // Handle the Enter key
    if (event.key === 'Enter') {
        event.preventDefault(); // Prevent default behavior of inserting a new block element
        
        // Insert a line break
        const selection = window.getSelection();
        const range = selection.getRangeAt(0);
        const br = document.createElement('br');
        
        // Insert the <br> tag to create a new line
        range.deleteContents();
        range.insertNode(br);
        
        // Move the cursor to the new line after the <br>
        range.setStartAfter(br);
        range.setEndAfter(br);
        selection.removeAllRanges();
        selection.addRange(range);
    }
}
