/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
// Added by Sridhar Reddy on 08/12/2008
var prevObjID;
var prevImgObj;
//end
// Added by Uma on 4/8/2009
var disappeardelay= 250;
var headTop = -1;
var FloatHead1;
//end
//onKeyPress -
function OrAllowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}


//onBlur -
function OrCheckPositiveNumber(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;


	if(obj.value == ""){
		return true;
	}


	if(!OrCheckNumber(obj))
		return false;


	if(parseFloat(obj.value) == 0){
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR')); //Here is the Change
			obj.focus();
			return false;
	}


	if(obj != null ){
		if(parseFloat(obj_value) > 0){
			return true;
		}else{
			alert(parent.getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
	}else{
		return true;
	}

/*   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getOrMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }*/
}


 //onBlur -  Plz don't remove the function
function OrCheckPositiveNumber1(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;



	if(obj.value == ""){
		return true;
	}

	if(!OrCheckNumber1(obj))
		return false;

	if(parseFloat(obj.value) == 0){
			alert(getMessage('ONLY_POSITIVE_NUM','OR')); //Here is the Change
			obj.focus();
			return false;
	}

	if(obj != null ){
		if(parseFloat(obj_value) > 0){
			return true;
		}else{
			alert(getMessage('ONLY_POSITIVE_NUM','OR')); //Here is the Change
			obj.focus();
			return false;
		}
	}else{
		return true;
	}

/*   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getOrMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }*/
}


//onKeyPress -
function OrAllowNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}


//onBlur -
function OrCheckNumber(obj) {
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

//onBlur -
function OrCheckNumber1(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(getMessage('ONLY_POSITIVE_NUM','OR'));
			obj.focus();
			return false;
		}
   }

   return true ;
}



function OrAllowDecimalNumber(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46)) ) {
       return false;
   }

}



function OrAllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}



//onKeyPress -
function OrAllowTime(){
   var key = window.event.keyCode;
   if( ! ((  key>=48 ) && ( key<=58 ) )) {
       return false;
   }

}

//onBlur -
function OrCheckTime(obj) {
   var sequence = "1234567890:";
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
}


//onBlur -
function OrIsValidDecimal(obj) {

   var sequence = "1234567890.";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {

        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(getMessage('INVALID_DECIMAL_NUMBER','OR'));
			obj.focus();
			return false;
		}
   }
}


//on Apply
function allowNonZero(obj){
	var count = 0;
	for(i=0; i<obj.value.length; i++){
		if(obj.value.charAt(i) == "0"){
			count++
		}
	}
	if(count == obj.value.length && count!=0){
	   return false
	}

}


function checkDecimal(obj){

  if(!OrCheckPositiveNumber(obj)){
	  return false;
  }else{
  	    var objVal  = obj.value ;
		if(objVal.indexOf(".") != -1) {
			alert(parent.getMessage('DECIMAL_NOT_ALLOWED','OR'));
			obj.focus();
			obj.value = "";
		}
  }
}



function checkDecimal1(obj){ //Don't remove this

  if(!OrCheckPositiveNumber1(obj)){
	  return ;
  }else{
  	    var objVal  = obj.value ;
		if(objVal.indexOf(".") != -1) {
		  	alert(getMessage('DECIMAL_NOT_ALLOWED','OR'));
			obj.focus();
			obj.value = "";
		}
  }
}



/**
Check Date and give app return 's
if from = to returns 0
if from > to returns 1
if from < to returns -1
*/
function doDateCheckOR(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  0 ;

   }

} //End of function


//Checks Date and time Passed
function doDatetimeCheckAlert(from,to) {
	var fromarray;
	var toarray;
	var fromDt;
	var fromdate = from;
	var todate = to;
	if(fromdate.length > 0 && todate.length > 0 )
	{
	  	fromDt = fromdate.split(" ");
	  	fromarray = fromDt[0].split("/");

	  	toDt = todate.split(" ");
	  	toarray = toDt[0].split("/");

		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if(Date.parse(todt) == Date.parse(fromdt))
		{
			fromTime = fromDt[1];
			toTime   = toDt[1];

			if(toTime < fromTime)
			{
				return true;
			}
		}

		if(Date.parse(todt) < Date.parse(fromdt))
		{
			return true;
		}
		else
		{
			if(Date.parse(todt) >= Date.parse(fromdt))
			return false;
		}

	}
}


//Function to disable all special characters in master codes.
//onKeypress
function CheckForSpecCharsWithoutSpace(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
//	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
//		return (event.keyCode -= 32);
	return true ;
}


// This function is added by Anjaneya Prasad on 9/7/2007 for order catalog time validation
function checktime(obj) 
{
	if(obj.value=="")
		return false;
	var timearray;
	var time=obj.value;
	timearray=time.split(":");
	if(timearray[0]!=null && timearray[1]!=null)
	{
		if(timearray[0]>24 || timearray[1]>59)
		{
		alert(getMessage('INVALID_TIME_FMT','OR'));
		obj.focus();
		obj.value = "";
		}
	}
	else
	{
		alert(getMessage('INVALID_TIME_FMT','OR'));
		obj.focus();
		obj.value = "";
	}
}

//Function to disable all special characters in master codes.
//onBlur
function CheckForSpecCharsWithoutSpaceBlur(obj){

    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
	var values = obj.value
	var lenValue  = values.length

	if(values == "")
		return true;


	for(i=0; i<lenValue; i++){
        if(strCheck.indexOf(values.charAt(i)) == -1){
			alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','OR'));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true
}

// to set the value in the editor
 function setPreviewTemplate(obj){
	if(obj!=null && obj!=""){
 		var new_value = "~"+obj+"`";     
  	    parent.editor.RTEditor0.document.body.focus();
		parent.editor.RTEditor0.document.clear();
  		var object_result = parent.editor.RTEditor0.document.execCommand("paste","",new_value);
 		if(!object_result)
			alert(getMessage("TRY_AFTER","OR"))
	}
 }

 function setPreviewDescTemplate(obj, description){
	if(obj!=null && obj!=""){
	 	var new_value = description+"    "+"~"+obj+"`";     
  		parent.editor.RTEditor0.document.body.focus();
		parent.editor.RTEditor0.document.clear();
  		object_result = parent.editor.RTEditor0.document.execCommand("paste","",new_value);
		if(!object_result)
			alert(getMessage("TRY_AFTER","OR"))
	}
 }

function setEditorTemplate(){
		// Setting the value to the editor.
		var RTEText = document.getElementById("RTEText").value;
		if(RTEText!="") {
 			alert(getMessage("DO_WANT_VIEW","OR"));
			
		parent.editor.RTEditor0.document.body.innerHTML = RTEText;
}
		if(document.editorButtonForm.effective_status.value=="D")
		{
			previewEditor();
			storeEditor();
		}
	}

// used for the layer
	function hideToolTip()	{
		  document.getElementById("tooltiplayer").style.visibility = 'hidden'
	}
	function showTable(){
  		var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 			tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eCA.NoofRows.label","CA")+"</td><td class='fields'><input type='text' name='rows' id='rows' size='2' maxLength='2' value='5' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td><td class='data' nowrap"+getLabel("eOR.NoofColumns.label","OR")+"</td><td class='fields'><input type='text' name='cols' id='cols' size='1' maxLength='1'  value='3' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
						tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' value="+getLabel("Common.ok.label","Common")+" onClick='setBuildTable()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 			tab_dat     += "</table> "
			resizeWindow(tab_dat);
			//table_count = document.getElementById("table_count").value;
			//if(table_count=="") table_count = 0;
			//document.getElementById("table_count").value = parseInt(table_count)+1;
	}

	function resizeWindow(tab_dat){
		document.getElementById("t").innerHTML					= tab_dat;
		document.getElementById("tooltiplayer").style.posLeft		= 202
	 	document.getElementById("tooltiplayer").style.posTop		= 0
		document.getElementById("tooltiplayer").style.visibility	='visible'
	}

	 

	function setBuildTable(){

		var rows = document.getElementById("rows").value;
		var cols = document.getElementById("cols").value;
		var table =  parent.editor.RTEditor0.document.body.all.tags("TABLE");
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
	 	parent.editor.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",htmlTable);
		hideToolTip();
		
 		/*if(table_length!="" && document.getElementById("table_count").value <=1)
		{*/
			document.getElementById("add_table").style.visibility = 'visible'
			document.getElementById("add_table_gif").style.visibility = 'visible'
			document.getElementById("delete_table").style.visibility = 'visible'
			document.getElementById("delete_table_gif").style.visibility = 'visible'
 		/*}
		else
		{
			document.getElementById("add_table").style.visibility = 'hidden'
			document.getElementById("add_table_gif").style.visibility = 'hidden'
			document.getElementById("delete_table").style.visibility = 'hidden'
			document.getElementById("delete_table_gif").style.visibility = 'hidden'
		}*/

	}
}

 
function deleteTable(){
//	var table	 =  parent.editor.RTEditor0.document.body.all.tags("TABLE");
//	table_length = table.length;
// 	if(document.getElementById("table_count").value!="" && document.getElementById("table_count").value <=1) {
//	if(table_length!="" && table_length >0) {
		var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 			tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNotobedeleted.label","OR")+"</td><td class='fields'><input type='text' name='delete_row' id='delete_row' size='2' maxLength='2' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
			tab_dat     += "<td class='label'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='deleteTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 			tab_dat     += "</table> "
			resizeWindow(tab_dat);	
//	}
//	}
}
function deleteTableRow(){
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

		if(eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no) && 		eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".rows["+rows+"]"))
		{
			eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".deleteRow("+rows+")");
 			if(eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".rows.length==0")){
				eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".clear");
 			}
		}
}

function addTable(){
		var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>"
 			tab_dat     += "<tr><td class='data' nowrap>"+getLabel("eOR.TableNo.label","OR")+"</td><td class='fields'><input type='text' name='table_no' id='table_no' size='2' maxLength='2' value='' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ><td class='data' nowrap>"+getLabel("eOR.RowNo.label","OR")+"</td><td class='fields'><input type='text' name='add_row' id='add_row' size='2' maxLength='2' value='2' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>"
			tab_dat		+="<td class='data' nowrap>"+getLabel("eOR.ColumnNo.label","OR")+"</td><td class='fields'><input type='text' name='add_columns' id='add_columns' size='1' maxLength='1' value='1' onKeyPress='return OrAllowNumber()' onBlur='return OrCheckNumber(this)' ></td>";
			tab_dat     += "<td class='fields'><input type='button' class='button' name='ok' id='ok' Value="+getLabel("Common.ok.label","Common")+" onClick='addTableRow()'></td><td class='label'><input type='button' class='button' name='cancel' id='cancel' Value="+getLabel("Common.cancel.label","Common")+" onClick='hideToolTip()'></td></tr> "
 			tab_dat     += "</table> "
			resizeWindow(tab_dat);	
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
   	 		if(eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no) && rows>0) {
				if(eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".rows.length!=0"))
	  				eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".insertRow("+rows+")");
			}
			for( j=0;j<cols;j++) {
				if(eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no) && eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".rows["+rows+"]"))
					eval("parent.editor.RTEditor0.document.getElementById("table")"+table_no+".rows["+rows+"].insertCell()");
	  		}
		}
	}
}

// For the templates
function showLookUpPractitioner(obj, sql_query){
 		var practName_FName	= "";
		var practName_FValue= "";
		var practId_FName	= "";
 		practName_FName		= document.editor_template.practitioner_id.name;		// object name
		practName_FValue	= document.editor_template.practitioner_id.value;
		if(practName_FValue==null) practName_FValue="";
 		//practId_FName		= eval("document.editor_preview.practitioner_id"+index+".value");
		practId_FName		= "";
  		// Practitioner common Lookup from AM
	 	var sql				= sql_query;
		var sql2			= document.editor_template.prac_sql.value;
 		//var sql2			= "SELECT DISTINCT a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, d.desc_sysdef practitioner_type, e.short_desc primary_specialty,  DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner a, am_pract_type d, am_pract_all_splty_vw c ,am_speciality e WHERE a.pract_type = d.pract_type AND a.practitioner_id = c.practitioner_id AND a.primary_speciality_code = e.speciality_code AND d.pract_type LIKE (?) AND c.specialty_code LIKE UPPER (?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL) ORDER BY a.practitioner_name";
 		//var sql2			= eval("document.editor_preview.query"+index+".value");
  		var splty			= "";
		var facility_id		= "";
		//facility_id		= facilityID;
 		// here not needed job_title , gender, practitioner_type, specialty-code
		var xmlDoc			= "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + splty+ "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";
	 
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText	= xmlHttp.responseText;
		responseText	= trimString(responseText);
		eval(responseText);
 }

function PractLookupRetVal(retVal,target)
{
   	if(retVal != null && retVal != "")
	{
		retVal=retVal.split("~");
 		setEditorValue(retVal);	
 	}
}

function showLookUp(obj){
   	var sql_query			= "";
 	var obj_name			= "";
	var ret_code			= "N";
		 if(document.editor_template) {// When called from editor template in Transaction
    		sql_query		= eval("document.editor_template."+obj+".value");
			ret_code		= "N";	
		 } else if(document.editor_preview) { // When called from editor template in master
			sql_query				= eval("document.editor_preview."+obj+".value");
			ret_code		= "Y";	
		 }
  	if(obj=="PRACTITIONER") {
 		showLookUpPractitioner(obj, sql_query)
 	} else if(obj=="CURRENT_DATE_TIME")
	{
			showCalendar('current_date_time',null,'hh:mm');	
			if(document.editor_template.current_date_time.value!="") {
			retVal	  = new Array();
			retVal[0] = document.editor_template.current_date_time.value
			retVal[1] = document.editor_template.current_date_time.value
		
			setEditorValue(retVal);
		}
	}	
	else {
		showCommonListLookUp(obj, sql_query, ret_code)
	}
}


function showCommonListLookUp(obj, sql_query, ret_code){
		//obj.value			    = "";
		//var description		= eval("document.editor_preview.description"+index+".value")
		//eval("document.editor_preview.description"+index+".value=''")

 		var dataNameArray  		= new Array() ;
		var dataValueArray 		= new Array() ;
  		var dataTypeArray 		= new Array() ;
	 	//var sql_query			= "select referral_code code, long_desc description from am_referral where eff_status='E'  and referral_code like ? and long_desc like ? order by 2";
 		//var sql_query			= eval("document.editor_preview.query"+index+".value");
   		var argumentArray  		= new Array() ;
  			argumentArray[0]	= sql_query;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
  			argumentArray[3]	= dataTypeArray ;
  			argumentArray[4]	= "1,2";
  			//argumentArray[5]	= eval("document.editor_preview.description"+index+".value") ;//Target
			argumentArray[5]	= "";
   	 		argumentArray[6]   	= CODE_LINK;  // DESC_LINK ;
	  		argumentArray[7]   	= CODE_DESC ; // DESC_CODE display part
  		var title				= ""+getLabel('eOR.CommonLookUps.label','OR')+"";
  	  	retVal					= CommonLookup( title, argumentArray );
		if(ret_code=="N")
			setEditorValue(retVal);	
		else 
			showCommonTemplate(retVal[0]); //Code is returned back
			
}

function setEditorValue(retVal){
 	if(retVal!=null && retVal!='')
  	{
 		parent.editor.RTEditor0.focus();
		parent.editor.RTEditor0.document.clear();
		object_result = parent.editor.RTEditor0.document.execCommand("paste","",retVal[1]);
		if(!object_result) {
			alert(getMessage("TRY_AFTER","OR"))
 		}
   	}
}

function printPreview()
{
 	parent.preview.focus(); 
	t=new ActiveXObject("WScript.Shell");
	t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header","");
	t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer","");
  	parent.preview.print();
}

function closePreview(){
	window.parent.close();
}


function checkValidations(obj, result_type, count){ 
   if(obj.value!=""){
		if(result_type=="D") {
 			CheckDate(obj,obj);  //2 parameter is the focus flag, here no need,just passing dummy value
	 	} else if(result_type=="T") {
  			if(chkTime(obj.value)==false) {
				alert(getMessage("TIMENOTCORRECT","OR"))
			}
		} else if(result_type=="E") { 
			//callCheckDateTime(obj)		
			doDateTimeChk(obj) 
 		}
   }
}

// For the Next and Prev Logic
// Parameters to be passed are start, end, checkbox_name, form_name
function displayRecords(start, end, checkbox_name, form_name){
 		var formObj					= eval("document."+form_name);
 		if(formObj){

			formObj.from.value		= start;
			formObj.to.value		= end;
   			var checked_items		= 0;
			var get_confirmation	= true;

  			if(checkbox_name!=""){
	 			for(cnt=0; cnt<formObj.total_recs.value; cnt++){
					if( eval("formObj"+"."+checkbox_name+cnt)){
					val = eval("formObj"+"."+checkbox_name+cnt);
   					if(val.checked == true){
						checked_items++;
					}
				}
				}
				if(parseInt(checked_items) > 0){
					 get_confirmation = confirm(getMessage("VIEW_CONFIRM","OR"))
 				}  
			} // End of if checkbox_name
			if(get_confirmation)
				formObj.submit();
	 	} // End of formObj
 } // End of displayRecords
 
// for the Master Function
function showCommonTemplate(code){
	if(code!=null) {
	  	 parent.editor.RTEditor0.document.execCommand("cut");
		 parent.editor.RTEditor0.document.execCommand("paste","","~START`V"+code+"|");
		 parent.editor.RTEditor0.document.execCommand("paste");
		 parent.editor.RTEditor0.document.execCommand("paste","","~END`");
	}
}

 // Added by Sridhar Reddy On 11/12/2008	
	function callMouseOverOnTD(obj,imgObj){
		
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 document.getElementById(prevObjID).className = 'gridDataBlue';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;		
	}

	function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}


// end

	//Added by Uma to display the context menu on click of arrow on 1/7/2009
	function dynamichide(m, e,row)
	{
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
	}

	function isContained(m, e)
	{

		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
	}

	function delayhidemenu(row)
	{

		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(document.getElementById("orderctl" + row))
			document.getElementById("orderctl" + row).className = 'gridDataBlue';
		if(document.getElementById("imgArrow" + row))
			document.getElementById("imgArrow" + row).src = "../../eCommon/images/inactiveArrow.gif";
	}

	function hidemenu()
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}
	//end
	//Added by Uma on 4/8/2009 to Scroll the header
	function processScroll()
	{
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop)
				FloatHead1.style.top = (theTop-headTop) + 'px';
			else
				FloatHead1.style.top = '0px';
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}
	//end

