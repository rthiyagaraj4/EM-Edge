<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                                 
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>		
<script language="javascript">
	var rows_for_consumables = new Array();
	var rows_for_equipments = new Array();
	var rows_for_instruments = new Array();
	var rows_for_prosthesis = new Array();
	var rows_for_personnel = new Array();
</script>
<script language="javascript">

function createXMLForOT_OPER_PACKAGE(){
//function createXMLForPackage(){
	 var rows=window.parent.frames[1].rows_for_consumables;
     var masterFrame=window.parent.frames[0];
	 var formObj=masterFrame.document.forms[0];
	 var len = rows.length;
	 var table_name = "OT_OPER_PACKAGE";
	 var xmlString ="";
	 var header ="";
	 for(i in rows){
			if(rows[i].mode!='L'){
  //  for(var i=0;i<len;i++){
//	  if(rows[i]!=null && rows[i].mode!='L' ){
		//alert("in the createXMLForOT_OPER_PACKAGE function");
		if(rows[i].mode=='D'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='D1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='D2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='D3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="D4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='D5';
		}else if(rows[i].mode=='U'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='U1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='U2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='U3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="U4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='U5';
		}
		xmlString+="<OPER_PACKAGE"+i+" ";
		xmlString+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		xmlString+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		xmlString+="category_code=\""+formObj.category_code.value+"\""+" ";
		xmlString+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		xmlString+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		xmlString+="package_code=\""+rows[i].packs_code+"\""+" ";
		xmlString+="package_qty=\""+rows[i].no_Of_Units+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
 }
		return xmlString;
}

function createXMLForOT_OPER_EQUIPMENT(){
//function createXMLForEquipment(){
  var rows=window.parent.frames[1].rows_for_equipments;
  var masterFrame=window.parent.parent.frames[1].frames[0];
  var formObj=masterFrame.document.forms[0];
  var len = rows.length;
  var table_name = "OT_OPER_EQUIPMENT";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		//alert("in the createXMLForOT_OPER_EQUIPMENT function");
		//alert("rows[i].mode===="+rows[i].mode);
		if(rows[i].mode=='D'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='D1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='D2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='D3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="D4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='D5';
		}else if(rows[i].mode=='U'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='U1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='U2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='U3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="U4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='U5';
		}
		xmlString+="<OPER_EQUIPMENT"+i+" ";
		xmlString+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		xmlString+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		xmlString+="category_code=\""+formObj.category_code.value+"\""+" ";
		xmlString+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		xmlString+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		xmlString+="equipment_code=\""+rows[i].equipment_code+"\""+" ";
		xmlString+="no_Of_Units=\""+rows[i].no_Of_Units+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		}


	 }
  
 return xmlString;
}

function createXMLForOT_OPER_INSTRUMENT(){
//function createXMLForInstrument(){
	//alert("inside createXMLForOT_OPER_INSTRUMENT");
  var rows=window.parent.frames[1].rows_for_instruments;
  var masterFrame=window.parent.parent.frames[1].frames[0];
  var formObj=masterFrame.document.forms[0];
  var len = rows.length;
  var table_name = "OT_OPER_INSTRUMENT";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		//alert("in the createXMLForOT_OPER_INSTRUMENT function");
		//alert("rows[i].mode===="+rows[i].mode);
		if(rows[i].mode=='D'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='D1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='D2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='D3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="D4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='D5';
		}else if(rows[i].mode=='U'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='U1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='U2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='U3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="U4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='U5';
		}
		xmlString+="<OPER_INSTRUMENT"+i+" ";
		xmlString+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		xmlString+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		xmlString+="category_code=\""+formObj.category_code.value+"\""+" ";
		xmlString+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		xmlString+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		xmlString+="instr_code=\""+rows[i].instr_code+"\""+" ";
		xmlString+="no_Of_Units=\""+rows[i].no_Of_Units+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString=="+xmlString);
		
		}


	 }
  
 return xmlString;
}

function createXMLForOT_OPER_PROSTHESIS(){
//function createXMLForpProsthesis(){
	//alert("inside createXMLForOT_OPER_PROSTHESIS");
  var rows=window.parent.frames[1].rows_for_prosthesis;
  var masterFrame=window.parent.parent.frames[1].frames[0];
  var formObj=masterFrame.document.forms[0];
  var len = rows.length;
  var table_name = "OT_OPER_PROSTHESIS";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		//alert("in the createXMLForOT_OPER_PROSTHESIS function");
		//alert("rows[i].mode===="+rows[i].mode);
		if(rows[i].mode=='D'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='D1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='D2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='D3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="D4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='D5';
		}else if(rows[i].mode=='U'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='U1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='U2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='U3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="U4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='U5';
		}
		xmlString+="<OPER_PROSTHESIS"+i+" ";
		xmlString+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		xmlString+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		xmlString+="category_code=\""+formObj.category_code.value+"\""+" ";
		xmlString+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		xmlString+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		xmlString+="prosthesis_code=\""+rows[i].prosthesis_code+"\""+" ";
		xmlString+="no_Of_Units=\""+rows[i].no_Of_Units+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString=="+xmlString);
		
		}


	 }
  
 return xmlString;
}

function createXMLForOT_OPER_PERSONNEL_REQD(){
	//alert("inside createXMLForOT_OPER_PERSONNEL_REQD");
  var rows=window.parent.frames[1].rows_for_personnel;
  var masterFrame=window.parent.frames[0];
  var formObj=masterFrame.document.forms[0];
  var len = rows.length;
  var table_name = "OT_OPER_PERSONNEL_REQD";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].mode!='L' ){
		//alert("in the createXMLForOT_OPER_PERSONNEL_REQD function");
		//alert("rows[i].mode===="+rows[i].mode);
		if(rows[i].mode=='D'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='D1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='D2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='D3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="D4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='D5';
		}else if(rows[i].mode=='U'){
			if(formObj.appl_desc.value=='AOPR')
                rows[i].mode='U1';
			else if(formObj.appl_desc.value=='SSPL')
				rows[i].mode='U2';
			else if(formObj.appl_desc.value=='SCAT')
				rows[i].mode='U3';
			else if(formObj.appl_desc.value=='SSUB')
				rows[i].mode="U4";
			else if(formObj.appl_desc.value=='SOPR')
				rows[i].mode='U5';
		}
		xmlString+="<OPER_PERSONNEL_REQUIRED"+i+" ";
		xmlString+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		xmlString+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		xmlString+="category_code=\""+formObj.category_code.value+"\""+" ";
		xmlString+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		xmlString+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		xmlString+="role_id=\""+rows[i].role_id+"\""+" ";
		xmlString+="no_Of_Persons=\""+rows[i].no_Of_Persons+"\""+" ";
		xmlString+="mode=\""+rows[i].mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		//alert("xmlString=="+xmlString);
		
		}


	 }
  
 return xmlString;
}

function createXMLForOT_OPER_SURGICAL_ACCESSORIES(){
  //alert("inside createXMLForOT_OPER_SURGICAL_ACCESSORIES");
  var masterFrame=window.parent.frames[0];
  var formObj=masterFrame.document.forms[0];
  var table_name = "OT_OPER_SURGICAL_ACCESSORIES";
  var mode = formObj.mode.value;
  var xmlString ="";
  var header ="";
	//	alert("in the createXMLForOT_OPER_SURGICAL_ACCESSORIES function");
		xmlString+="<OPER_SURGICAL_ACCESSORIES"+" ";
		//xmlString+="surgeon_code=\""+formObj.surgeon_code.value+"\""+" ";
		xmlString+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		xmlString+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		xmlString+="category_code=\""+formObj.category_code.value+"\""+" ";
		xmlString+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		xmlString+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		xmlString+="mode=\""+mode.toUpperCase()+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";


	   header= createXMLForOT_OPER_PACKAGE();
	if (header.indexOf("/>")!=-1){
		    xmlString+=header;
			// return xmlString;
	   }
	 var header_1= createXMLForOT_OPER_EQUIPMENT();
		if (header_1.indexOf("/>")!=-1){
			
		     xmlString+=header_1;
			// return xmlString;
	   }
	var instrument=createXMLForOT_OPER_INSTRUMENT();
	if (instrument.indexOf("/>")!=-1){
				
		     xmlString+=instrument;
			// return xmlString;
	   }
	  var prosthesis=createXMLForOT_OPER_PROSTHESIS();
	  if (prosthesis.indexOf("/>")!=-1){
			
		     xmlString+=prosthesis;
			// return xmlString;
	   }
	   var reqd=createXMLForOT_OPER_PERSONNEL_REQD();
	    if (reqd.indexOf("/>")!=-1){
				
		     xmlString+=reqd;
			 //return xmlString;
	   }
	   	 return xmlString;

}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectCollectForm" id="ObjectCollectForm">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>
//OT_OPER_PERSONNEL_REQD ----personnel required
//OT_OPER_PACKAGE ----consumables
//OT_OPER_EQUIPMENT --equipments
//OT_OPER_INSTRUMENT===instruments
//OT_OPER_PROSTHESIS====prosthesis


