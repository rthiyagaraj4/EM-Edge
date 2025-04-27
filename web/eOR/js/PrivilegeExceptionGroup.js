/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*******************Select TAB*****************************/
/*  function selectInsert(){
	//chk  whether detail form is present

	if(!chkDulplicateSeqNo()) 
	return false;   

	getHandleHeader();
	instialiseGlobal();
	getHandleDetailDoc();
	ShowHtml();
	headerDoc.all.innerCellTab.rows(0).cells(0).className="CAFIRSTSELECTHORZ";
	headerDoc.all.innerCellTab.rows(0).cells(1).className="CAFIRSTNOSELECT";

if(detailPageMode == 'N'){//Current Page Mode == No
	detailDoc.location.href="../../eOR/jsp/PrivilegeExceptionGroupDetail.jsp?action=select" + "&order_category="+ formObjHeader.order_category.value + "&tick_sheet_id="+ formObjHeader.tick_sheet.value+"&section_code="+ formObjHeader.section.value+ "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
}else{
	getHandleDetail();
	formObjDetail.action.value="select";
	formObjDetail.submit();
}
	detailPageMode = 'N' ;
	detailDocObj.location.href="../../eCommon/html/blank.html";
}
/*******************Associated TAB*****************************/
/*
function associated(){
	
	//chk  whether detail form is present
	if(!chkDulplicateSeqNo()) 
	return false;                  

	getHandleHeader();
	instialiseGlobal();
	clearHtml();
	headerDoc.all.innerCellTab.rows(0).cells(1).className="CAFIRSTSELECTHORZ";
	headerDoc.all.innerCellTab.rows(0).cells(0).className="CAFIRSTNOSELECT";
	
	if(detailPageMode == 'N'){ //Current Page Mode == No
	detailDoc.location.href="../../eOR/jsp/CatalogsBySectionDetail.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value + "&tick_sheet_id="+ formObjHeader.tick_sheet.value +"&section_code="+ formObjHeader.section.value + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
	}else{
		getHandleDetail();
		formObjDetail.nextPrevFlag.value='next';
		formObjDetail.action.value="associated";
		formObjDetail.submit();
	}
}
/********************apply function*************************************/
/*
function apply(){
	getHandleDetail();
	getHandleHeader();
	
	//chk  whether detail form is present
	if(!chkDulplicateSeqNo()) 
	return false;                  
	                          
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	/*var tempHtml = "FORM name='fff' name=''><input type='hidden' value='1' name='mode' id='mode'></form>;"
	document.fff.submit();
	alert(formApply(formObjDetail));*/
	/*}
	
	if(!ValidateEntry())      
	return false;         
	

	alert(formApply(formObjDetail));
	//eval(formApply(formObjDetail));	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal){
	instialiseGlobal();
	detailDoc.location.href="../../eCommon/html/blank.html" ;	
	onSuccess();
	return true ;
	}else{
	return false;	
	}
	
}

/********************reset *************************************/
/*
function reset() {
	getHandleDetail();
	getHandleHeader();
	instialiseGlobal();
	setCombinationMode(false);
	formObjHeader.order_category.selectedIndex = 0 ;
	detailPageMode			="N";
	removeOptions(headerDoc.all.section_option ,"sectionOption");
	removeOptions( headerDoc.all.tick_sheet_option,"tickSheetOption");
	clearHtml();
	changeCellStyle("hide");
	detailDoc.location.href = "../../eCommon/html/blank.html";
}

/**************function to fill combo Box Dynamically********************/
/*
function fillComboOptions(obj) {

	getHandleDetail();
	getHandleHeader();

	var OrderCategory = "";
	var tickSheet = "";
	var  xmlAppend = ""; 


	//Clear detail Page and the All Anchor tags
	detailDoc.location.href="../../eCommon/html/blank.html";
	currentIndexSelected = "";
	clearHtml();
	
	var bean_id				= formObjHeader.bean_id ;
	var tick_sheet			= formObjHeader.tick_sheet ; 
	var section				= formObjHeader.section ; 
	var tick_sheet_option	= headerDoc.all.tick_sheet_option ; 
	var section_option		= headerDoc.all.section_option ; 


	if(obj.name == "order_category" ) 
	{
		removeOptions(section_option ,"sectionOption");
		if(obj.value == "" ) 
		{
			removeOptions(tick_sheet_option ,"tickSheetOption");
			clearHtml();
			return ;		
		}else{
		OrderCategory = obj.value ;	
		xmlAppend += "order_category"+"=\""+ OrderCategory+"\" " ;
		xmlAppend += "type"+"=\"OrderCategory\"" ;
		}
	}
	
	if(obj.name == "tick_sheet" ) 
	{
		
		if(obj.value == "" ) 
		{
			removeOptions(section_option ,"sectionOption");
			clearHtml();
			return ;		
		}else{
			tickSheet = obj.value ;	
			xmlAppend += "tick_sheet"+"=\""+ tickSheet+"\" " ;
			xmlAppend += "order_category"+"=\""+ formObjHeader.order_category.value+"\" " ;
			xmlAppend += "type"+"=\"tickSheet\"" ;
		}
	}

		
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;



	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CatalogSectionComboFill.jsp?bean_id="+bean_id.value,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	
	if(flagChk ==  true )
	{
	//	alert(responseText);
		eval(responseText ) ;
	}
	
	if(flagChk ==  false )
	{
		flagChk = true ;
	//	alert(responseText);
		eval( responseText ) ;
	}

}
/********************function called when index is clicked*********************/
/*
function callOderCatalog(obj){

	if(!chkDulplicateSeqNo())
	return ;
	
	getHandleDetail();
	getHandleHeader();
	clearMessageFrame();

	var order_category = formObjHeader.order_category.value ;
	var tick_sheet_id  = formObjHeader.tick_sheet.value ;
	var section_code   = formObjHeader.section.value ;

	if(detailPageMode == "N"){
	detailDoc.location.href="../../eOR/jsp/CatalogsBySectionDetail.jsp?OrderCatalogIndex="+obj + "&action=IndexSelect" + "&order_category="+order_category + "&tick_sheet_id="+tick_sheet_id +"&section_code="+section_code + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
	}else{
	formObjDetail.nextPrevFlag.value='next';
	formObjDetail.OrderCatalogIndex.value=obj;
	formObjDetail.section_code.value=section_code;
	formObjDetail.order_category.value=order_category;
	formObjDetail.action.value="IndexSelect";
	formObjDetail.submit();
	}
	
	
}
/********************NExt- Prevoius function******************************/
/*
function getNext(flagSelect){

if(!chkDulplicateSeqNo())
return ;

getHandleDetail();
getHandleHeader();
messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
formObjDetail.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
formObjDetail.action.value="nextPrev";
formObjDetail.submit();
}
/*******END OF CLICK FUNCTIONS***********/
/********************sucess********************************/
/*
function onSuccess() {

}
/*****************assign result function*************************************/
/*
function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
}

/********************Clear the Options-- function***********************/
/*
function removeOptions(comboObject,optionName){
	var tickSheetOption = '&nbsp;<select name="tick_sheet" id="tick_sheet" <%=readOnly%> onChange="fillComboOptions(this);"><option>-------------Select----------</option></select><img src="../../eCommon/images/mandatory.gif"></img>';

	var sectionOption = '&nbsp;<select name="section" id="section" <%=readOnly%> onChange="parent.parent.select(this)"><option>-------------Select----------</option></select><img src="../../eCommon/images/mandatory.gif"></img>';


	if(optionName == "tickSheetOption")
	 comboObject.innerHTML = tickSheetOption;

	if(optionName == "sectionOption")
	 comboObject.innerHTML = sectionOption;
  }

/********************Dynamically add Option function************************/
/*function addComboObject(comboObjectString,Object){
		getHandleDetail();
		getHandleHeader();
	   
		var tick_sheet_option		= 	headerDoc.all.tick_sheet_option ;
		var section_option	    	= 	headerDoc.all.section_option ; 

		if(Object == "order_category")		  	
		tick_sheet_option.innerHTML = comboObjectString ;

		if(Object == "tick_sheet")		  	
		section_option.innerHTML = comboObjectString ;

   }
/********************Show html function*************************************/
/*function ShowHtml(){

	getHandleDetail();
	getHandleHeader();
	
	var alphabetCell =  headerDoc.all.alphabet ;
	var alphabetHtml =  formObjHeader.alphabetsHtml.value ;
	detailDoc.location.href="../../eCommon/html/blank.html";

	if(headerDoc.all.mode.value == "1")		
	alphabetCell.innerHTML  = alphabetHtml ;
	else
	alphabetCell.innerHTML  = alphabetHtml  + '&nbsp;<a href=javascript:parent.parent.callOderCatalog("all")>ALL</a>';
			
}

/********************Clear A,B,C Alphabet function**************************/
/*
function clearHtml(){
	getHandleHeader();	
	var alphabetCell		 =  headerDoc.all.alphabet ;
	alphabetCell.innerHTML	 = "&nbsp;" ;
}

/********************Check Duplicate function******************************/
/*
function chkDulplicateSeqNo(){

	//Chk whether detail form present or not
//	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	return true;
	}

	getHandleDetail();
	getHandleHeader();

	var SqnArrayLocal  = new Array()
	var arrLocalLen = 0;

	var form =parseInt(formObjDetail.previousRecord.value) ;
	var to   =parseInt(formObjDetail.nextRecord.value) ;


	 //Construct arrLocal array for the Page
	for(i=form-1;i<to;i++){

		var obj  = eval("formObjDetail.tick_sheet_seq_num" +i) ;

		if(obj.value != "" && obj.value != null )
			SqnArrayLocal[i] = obj.value ;
		else
			SqnArrayLocal[i] = "";
	}


	arrLocalLen = SqnArrayLocal.length ;

	//CODE FOR CHK DUPLICATES on Local Page
	var chkDuplicate = false ;

	for(k=0;k<(SqnArrayLocal.length-1);k++)
	{
		var chk = SqnArrayLocal[k] ;

		if(chk != "" && chk != null )
		{
				for(h=k+1;h<SqnArrayLocal.length;h++)
				{	
					if(parseInt(chk) == parseInt(SqnArrayLocal[h]))
					chkDuplicate = true ;
				}
		}
	
	}

	if(chkDuplicate == true)
	{
		var message  ="APP-OR0005 Duplicate values are passed";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}


	return true;
	
}//End of Duplicate Function

/*****************Validate Method*************************************/
/*
function ValidateEntry(){

	getHandleDetail();
	getHandleHeader();
	
	var mode = formObjHeader.mode.value ;

	var form =parseInt(formObjDetail.previousRecord.value) ;
	var to   =parseInt(formObjDetail.nextRecord.value) ;

	var flagValidateSeqNo  = true ;
	var flagValidateChkBox = true ;

	for(i=form-1;i<to;i++){

		var objChkBox  = eval("formObjDetail.include" +i) ;
		var objSeqNo   =  eval("formObjDetail.tick_sheet_seq_num" +i) ;

		if(objChkBox.checked == true){
			if(objSeqNo.value == "" || objSeqNo.value == null || objSeqNo.value == 0 )
			flagValidateSeqNo = false ;
		}

		
	if(objSeqNo.value != "" && objSeqNo.value != 0 ){
			if(objChkBox.checked == false)
			flagValidateChkBox = false ;
		}

	}

	if(flagValidateChkBox == false && mode == '1'){
	  var message  ="APP-OR0005 Sequence no's cannot be entered for the Check Box not checked.... " ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  return false ;
	 }	

	 if(flagValidateSeqNo == false){
	  var message  ="APP-OR0005 Sequence no's for Check Box Checked should be filled.... " ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  return false ;
	 }

	return true ;	

}

 /*************************************************************/
 /*
 function setCombinationMode(flag)
 {
	 getHandleHeader();
	 formObjHeader.order_category.disabled = flag;
 	 formObjHeader.tick_sheet.disabled = flag;
 	 formObjHeader.section.disabled = flag;
 }

/*********************Clear Message Frame*****************************/
/*
function clearMessageFrame(){
	  	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
}
/*********************Header Handle*****************************/
/*
function getHandleHeader(){
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;	
 formObjHeader   =headerDoc.CatalogSectionHeader ;
}
/**********************Detail Handle**********************************/
/*
function getHandleDetail(){
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;	
 formObjDetail	 =detailDoc.CatalogsBySectionDetail ;
}
/**************************************************************************/
/*
function getHandleDetailDoc(){
 detailDocObj		 =f_query_add_mod.f_query_add_mod_detail.document ;	
}
/****************************************************************************/
/*
function changeCellStyle(pattern){
getHandleHeader();
var cellObj0 = headerDoc.all.innerCellTab.rows(0).cells(0) ;
var cellObj1 = headerDoc.all.innerCellTab.rows(0).cells(1) ;
if(pattern == "show"){
		cellObj0.className="CAFIRSTNOSELECT";
		cellObj0.innerHTML="<a>Selected</a>";
		cellObj0.onclick=selectInsert;
		cellObj1.className="CAFIRSTNOSELECT";
		cellObj1.innerHTML="<a>Associated</a>";
		cellObj1.onclick=associated;
	}
if(pattern == "hide"){
		cellObj0.className="";
		cellObj0.innerHTML="&nbsp";
		cellObj0.onclick='';
		cellObj1.className="";
		cellObj1.innerHTML="&nbsp";
		cellObj1.onclick='';
	}

}
/****************************************************************************/
/**
Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	CatalogSectionBy.jsp---->CatalogBySection.js
		|
		|------MstToolBar
		|
		|------CatalogsBySectionMultiple.jsp
		|		|
		|		|---CatalogsBySectionDetail.jsp
		|		|		Document ---headerDoc
		|		|		FormObect---formObjHeader	
		|		|
		|		|---CatalogsBySectionHeader.jsp     
		|		|		Document ---detailDoc
		|		|		FormObect---formObjDetail
		|
		|------MessageFrame
		|

**/

