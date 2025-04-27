/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
07/06/2020	IN072524	Nijitha S     07/06/2020	Ramesh G	ML-MMOH-CRF-1229.2
------------------------------------------------------------------------------------------------------------------------------
*/
/**************Global Variable for all function ****************/
var function_id          = "" ;
var resultGlobal	     = false;
var messageGlobal	     = "" ;
var invalidCodeGlobal	 = "" ;
var flagGlobal		     = true;
var detailPageMode		 = "N";	//Select,Associated,None{s,A,N}
var selFlag			     = false ;
var chkVal_flag			 = false ;
/***************************************************************/
var flagChk          = false; //Only to DiBug
/*************Handle to the Frame 's and the form Object ****************/
var headerDoc		= null	;
var detailDoc		= null ;
var formObjHeader	= null	;
var formObjDetail	= null ;
/********************Intialise function*************************************/
function instialiseGlobal(){
	resultGlobal			= false;
	messageGlobal			= "" ;
    flagGlobal				= true;
	flagChk					= false;
	selFlag				    = false ;
}
/************************Set detial Page Mode***********************/
function setDetailPageMode(val){
detailPageMode = val;
}
/*********Click Function"s Start Here**********/

/********************Create function*************************************/
function create() {
	setDetailPageMode('N');
	instialiseGlobal();
f_query_add_mod.location.href="../../eOR/jsp/CatalogsBySectionMultiple.jsp?mode=1&function_id="+function_id
}
/********************Query function*************************************/
function query() {
	f_query_add_mod.location.href="../../eOR/jsp/CatalogsBySectionQueryCriteria.jsp?function_id="+function_id;
}
/******************Select function when section code Combo opt selected****/
function select(obj){
	getHandleDetail();
	getHandleHeader();
 	ShowHtml();
	setCombinationMode(true);

	if(obj.value != "")
	{
		changeCellStyle("show");
	}else{
		changeCellStyle("hide");
		detailDoc.location.href="../../eCommon/html/blank.html";
	}
}
/*******************Select TAB*****************************/
function selectInsert()
{
	//chk  whether detail form is present

	if(!chkDulplicateSeqNo())
	return false;

	getHandleHeader();
//	instialiseGlobal();
	getHandleDetailDoc();
	ShowHtml();
   	formObjHeader.search_text.value = "";
	headerDoc.SelectTab.className="clicked";
	headerDoc.AssociateTab.className="normal";

	if(detailPageMode == 'N')
	{//Current Page Mode == No
		detailDoc.location.href="../../eOR/jsp/CatalogsBySectionDetail.jsp?&action=select" + "&order_category="+ formObjHeader.order_category.value + "&tick_sheet_id="+ formObjHeader.tick_sheet.value+"&section_code="+ formObjHeader.section.value+ "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
	}
	else
	{
		getHandleDetail();
		formObjDetail.action.value="select";
		formObjDetail.submit();
	}
	detailPageMode = 'N' ;
	detailDocObj.location.href="../../eCommon/html/blank.html";
}
/*******************Associated TAB*****************************/
function associated()
{

	//chk  whether detail form is present
	if(!chkDulplicateSeqNo())
	return false;

	selFlag			 = true ;

	getHandleHeader();
//	instialiseGlobal();
	clearHtmlABC();

	headerDoc.SelectTab.className="normal";
	headerDoc.AssociateTab.className="clicked";


	if(detailPageMode == 'N')
	{
		getHandleDetail();//Current Page Mode == No
		detailDoc.location.href="../../eOR/jsp/CatalogsBySectionDetail.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value + "&tick_sheet_id="+ formObjHeader.tick_sheet.value +"&section_code="+ formObjHeader.section.value + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode+"&tabVal=A" ;
	}
	else
	{
		getHandleDetail();
		formObjDetail.nextPrevFlag.value='next';
		formObjDetail.action.value="associated";
		formObjDetail.submit();
	}
}
/********************apply function*************************************/
function apply()
{
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	getHandleDetail();
	getHandleHeader();
	var fields = new Array ( formObjHeader.order_category,
							 formObjHeader.tick_sheet,
							 formObjHeader.section);
	var names = new Array ( getLabel("Common.OrderCategory.label","Common") , getLabel("eOR.TickSheet.label","OR") , getLabel("Common.Section.label","COMMON") );
	if(!checkFieldsofMst( fields, names, messageFrame)) 
	{
		return false;
	}
	//chk  whether detail form is present
	if(!chkDulplicateSeqNo())
	return false;
	if(!selFlag)
	{
		var msg = getMessage('CLICK_ONE_ORDERABLE','OR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		return false;
	}
	/*if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	var tempHtml = "<input type='hidden' value='1' name='mode' id='mode'><input type='hidden' value='N' name='detailPageMode' id='detailPageMode'>"
	formObjHeader.insertAdjacentHTML("AfterEnd", tempHtml);
	eval(formApply(formObjHeader));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+
	messageGlobal;
	return false;
	}*/
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") != -1)
	{
		onApplyUpdate();
	}
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1)
	{
		eval(formApply(formObjHeader,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+
		messageGlobal;
		if(!resultGlobal)
		{
			if(invalidCodeGlobal != "" && invalidCodeGlobal != "null")
			{
				var msg = messageGlobal + invalidCodeGlobal;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			}
		//associated();
			return false;
		}
		return true;
	}

	if(!ValidateEntry())
	return false;

	if(!chkVal_flag)
	{
		var msg = getMessage('CLICK_ONE_ORDERABLE','OR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		return false;
	}
	//var kk=formObjDetail.tick_sheet_seq_num0.value;
	//alert("kk=");
	eval(formApply(formObjDetail,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal)
	{
		instialiseGlobal();
		detailDoc.location.href="../../eCommon/html/blank.html" ;
		onSuccess();
		return true ;
	}
	else
	{

		if(invalidCodeGlobal != "" && invalidCodeGlobal != "null")
		{
			var msg = messageGlobal + invalidCodeGlobal;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		}
	}

}

/********************reset *************************************/
function reset() {
	if(f_query_add_mod.f_query_add_mod_header !=null){
	getHandleDetail();
	getHandleHeader();
	instialiseGlobal();
	setCombinationMode(false);
	selFlag			 = false ;
	formObjHeader.order_category.selectedIndex = 0 ;
	detailPageMode			="N";
	removeOptions(headerDoc.section_option ,"sectionOption");
	removeOptions( headerDoc.tick_sheet_option,"tickSheetOption");
	sectionList();

	changeCellStyle("hide");
	detailDoc.location.href = "../../eCommon/html/blank.html";
	formObjHeader.search_text.value = "";
	}else{
		if(f_query_add_mod.document.forms[0]!=null)
        f_query_add_mod.document.forms[0].reset();//reset in query mode
		else
		{
			frames[0].location.reload();
			return false;
		
		}
	}
}
/**************function to fill combo Box Dynamically********************/
function fillComboOptions(obj) {

	getHandleDetail();
	getHandleHeader();

	var OrderCategory = "";
	var tickSheet = "";
	var  xmlAppend = "";


	//Clear detail Page and the All Anchor tags
	detailDoc.location.href="../../eCommon/html/blank.html";
	currentIndexSelected = "";

	var bean_id				= formObjHeader.bean_id ;
	var tick_sheet			= formObjHeader.tick_sheet ;
	var section				= formObjHeader.section ;
	var tick_sheet_option	= headerDoc.tick_sheet_option ;
	var section_option		= headerDoc.section_option ;


	if(obj.name == "order_category" )
	{
		//removeOptions(section_option ,"sectionOption");
		sectionList();
		if(obj.value == "" )
		{
			removeOptions(tick_sheet_option ,"tickSheetOption");
			changeCellStyle("hide");
			return ;
		}else{
		OrderCategory = obj.value ;
		xmlAppend += "order_category"+"=\""+ OrderCategory+"\" " ;
		xmlAppend += "type"+"=\"OrderCategory\"" ;
		}
	}

	if(obj.name == "tick_sheet" )
	{
		sectionList();
		if(obj.value == "" )
		{
			//removeOptions(section_option ,"sectionOption");
			sectionList();
			changeCellStyle("hide");
			return ;
		}else{
			tickSheet = obj.value;
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
function callOderCatalog(alphalink,search)
{
	if(!chkDulplicateSeqNo())
	return ;

	selFlag			 = true ;

	getHandleDetail();
	getHandleHeader();
	clearMessageFrame();

	var order_category = formObjHeader.order_category.value ;
	var tick_sheet_id  = formObjHeader.tick_sheet.value ;
	var section_code   = formObjHeader.section.value ;
	var fpp_yn="";//IN072524
	if(null!=formObjHeader.fpp_yn &&undefined!=formObjHeader.fpp_yn )//IN072524
	 fpp_yn =  formObjHeader.fpp_yn.value ;//IN072524
	if(detailDoc.location.href.indexOf(".jsp") != -1)
	{
			var flag = latestUpdate();
	}

	//if(detailPageMode == "N"){
	detailDoc.location.href="../../eOR/jsp/CatalogsBySectionDetail.jsp?OrderCatalogIndex="+encodeURIComponent(alphalink) + "&action=IndexSelect" + "&order_category="+order_category + "&tick_sheet_id="+tick_sheet_id +"&section_code="+section_code + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode+"&searchingValue="+encodeURIComponent(search)+"&fpp_yn="+fpp_yn ;///IN072524
	//}else{
	/*formObjDetail.nextPrevFlag.value='next';
	formObjDetail.OrderCatalogIndex.value=obj;
	formObjDetail.section_code.value=section_code;
	formObjDetail.order_category.value=order_category;
	formObjDetail.action.value="IndexSelect";
	formObjDetail.submit();
	}*/
}
/********************NExt- Prevoius function******************************/
function getNext(flagSelect)
{

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
function onSuccess() {
	create();
}
/*****************assign result function*************************************/
function assignResult(res,msg,mod ,invcode){
	resultGlobal			=res ;
	messageGlobal			=msg ;
	flagGlobal				=mod;
	invalidCodeGlobal		=invcode ;
}

/********************Clear the Options-- function***********************/
function removeOptions(comboObject,optionName){
	var tickSheetOption = '&nbsp;<select name="tick_sheet" id="tick_sheet" <%=readOnly%> onChange="fillComboOptions(this);"><option>        --- '+getLabel("Common.defaultSelect.label","Common")+'---        </option></select><img src="../../eCommon/images/mandatory.gif"></img>';

	var sectionOption = '&nbsp;<select name="section" id="section" <%=readOnly%> onChange="parent.parent.select(this)"><option>        --- '+getLabel("Common.defaultSelect.label","Common")+' ---        </option></select><img src="../../eCommon/images/mandatory.gif"></img>';

   
	if(optionName == "tickSheetOption")
	 comboObject.innerHTML = tickSheetOption;

	if(optionName == "sectionOption")
	 comboObject.innerHTML = sectionOption;
  }

/********************Dynamically add Option function************************/
function addComboObject(comboObjectString,Object){
		getHandleDetail();
		getHandleHeader();

		var tick_sheet_option		= 	headerDoc.tick_sheet_option ;
		var section_option	    	= 	headerDoc.section_option ;
		comboObjectString = comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"));
		if(Object == "order_category")
		tick_sheet_option.innerHTML = comboObjectString ;

		if(Object == "tick_sheet")
		{
			//alert("comboObjectString"+comboObjectString);
			/*if((comboObjectString.indexOf("<option>")>0) &&(comboObjectString.indexOf("</option>")>0))
			{
				var combovaluetemp=comboObjectString.split("</option>");	
				for(var j=1;j<combovaluetemp.length-1;j++)
				{
					var temp =combovaluetemp[j];
					temp=temp.split(">");
					tempkey = temp[0].split("'");
					addListValues(tempkey[1],decodeURIComponent(temp[1]));		
				}
			}*/
		section_option.innerHTML = comboObjectString ;
	}

   }
/********************Show html function*************************************/
function ShowHtml(){

	getHandleDetail();
	getHandleHeader();

	detailDoc.location.href="../../eCommon/html/blank.html";

	if(headerDoc.mode.value == "1")	{
		changeCellStyle("show");
	}else{
	;
	}


}

/********************Clear A,B,C Alphabet and SearchCriteria functions******************/

function clearHtmlABC(){
	getHandleHeader();
	headerDoc.alphabet.style.display	 = "none" ;
	headerDoc.searchTxt.style.display	 = "none" ;
}

/********************Check Duplicate function******************************/
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
	for(i=form-1;i<to;i++)
	{

		var obj  = eval("formObjDetail.tick_sheet_seq_num" +i) ;
		if(obj==undefined)
		{
			SqnArrayLocal[i] = "";
		}
		else
		{
			if(obj.value != "" && obj.value != null )
				SqnArrayLocal[i] = obj.value ;
			else
				SqnArrayLocal[i] = "";
		}
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
//		var message  ="APP-OR0005 Duplicate values are passed";
		var message = getMessage("SEQ_ORDER_CAT_SECTION_CHK","OR") ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}


	return true;

}//End of Duplicate Function

/*****************Validate Method*************************************/
function ValidateEntry()
{

	getHandleDetail();
	getHandleHeader();

	var mode = formObjHeader.mode.value ;
	var refForm = f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail;

	//var form =parseInt(formObjDetail.previousRecord.value) ;
	//var to   =parseInt(formObjDetail.nextRecord.value) ;

	var flagValidateSeqNo  = true ;
	//var flagValidateChkBox = true ;

	//for(i=form-1;i<to;i++){
	var fm_disp		= refForm.fm_disp.value;
	var to_disp		= refForm.to_disp.value;
	fm_disp = parseInt(fm_disp,10);
	to_disp = parseInt(to_disp,10);

	for(i=fm_disp; i<=to_disp; i++)
	{

		var objChkBox  = eval("formObjDetail.include" +i) ;
		var objSeqNo   =  eval("formObjDetail.tick_sheet_seq_num" +i) ;

		if(objChkBox.checked == true)
		{
			chkVal_flag = true;//alert();
			if(objSeqNo.value == "" || objSeqNo.value == null || objSeqNo.value == 0 )
			flagValidateSeqNo = false ;
		}

		if(objSeqNo.value != "" && objSeqNo.value != 0 )
		{
				if(objChkBox.checked == false)
				//flagValidateChkBox = false ;
				eval("formObjDetail.tick_sheet_seq_num" +i).value=="";
		}

	}

	/*if(flagValidateChkBox == false && mode == '1'){
	  var message  ="APP-OR0005 Sequence no's cannot be entered for the Check Box not checked.... " ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  return false ;
	 }*/

	 if(flagValidateSeqNo == false){
	  var message  =getMessage("SEQUENCE_NUMBER_FOR_CHKBOX","OR");
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  return false ;
	 }

	return true ;
}
/*************************************************************/
 function setCombinationMode(flag)
 {
	 getHandleHeader();
	 formObjHeader.order_category.disabled = flag;
 	 formObjHeader.tick_sheet.disabled = flag;
 	 formObjHeader.section.disabled = flag;
 }

/*********************Clear Message Frame*****************************/
function clearMessageFrame(){
	  	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
}
/*********************Header Handle*****************************/
function getHandleHeader(){
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
 formObjHeader   =headerDoc.CatalogSectionHeader ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.CatalogsBySectionDetail ;
}
/**************************************************************************/
function getHandleDetailDoc(){
 detailDocObj		 =f_query_add_mod.f_query_add_mod_detail.document ;
}
/****************************************************************************/
function changeCellStyle(pattern){
getHandleHeader();
if(pattern == "hide" ){
	headerDoc.alphabet.style.display	 = "none" ;
	headerDoc.innerCellTab.style.display = "none" ;
	headerDoc.searchTxt.style.display    = "none" ;
}else if(pattern == "show" ){
	headerDoc.alphabet.style.display	 = "" ;
	headerDoc.alphabet.style.visibility	 = "visible" ;
	headerDoc.innerCellTab.style.display = "inline" ;
  //  headerDoc.searchTxt.style.display	 = "inline" ;
    headerDoc.alphabet.style.visibility	 = "visible" ;
}

}


function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

/*Added by Uma on 9/9/2009 for IN013057*/
function dispLink(obj)
{
	if(!chkDulplicateSeqNo())
	return false;

	getHandleHeader();
	getHandleDetailDoc();
	var buttonVal			   	= obj;
	if(buttonVal=="S")
		ShowHtml();
	else if(buttonVal=="A")
		clearHtmlABC();

	selFlag			 = true ;
	if(buttonVal=="A")
	{
		headerDoc.SelectTab.className="normal";
		headerDoc.AssociateTab.className="clicked";
	}
	else if(buttonVal=="S")
	{
		headerDoc.SelectTab.className="clicked";
		headerDoc.AssociateTab.className="normal";
	}

   	formObjHeader.search_text.value = "";

	var formObj				   	= document.forms[0];

	if(buttonVal == "S")
	{
		f_query_add_mod.f_query_add_mod_header.document.getElementById('SelectTab').className="clicked";
		f_query_add_mod.f_query_add_mod_header.document.getElementById('AssociateTab').className="normal";
	}
	else if(buttonVal == "A")
	{
		f_query_add_mod.f_query_add_mod_header.document.getElementById('SelectTab').className="normal";
		f_query_add_mod.f_query_add_mod_header.document.getElementById('AssociateTab').className="clicked";
	}
	f_query_add_mod.f_query_add_mod_header.document.getElementById('tabVal').value = buttonVal;
	if(f_query_add_mod.frames[1].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}

	if(buttonVal=="A")
	{
		getHandleDetail();//Current Page Mode == No
		detailDoc.location.href="../../eOR/jsp/CatalogsBySectionDetail.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value + "&tick_sheet_id="+ formObjHeader.tick_sheet.value +"&section_code="+ formObjHeader.section.value +  "&detailPageMode="+detailPageMode+"&tabVal=A" ;
	}
	else
	{
		getHandleDetail();
		if(formObjDetail)
		{
			if(formObjDetail.location)
				formObjDetail.location.href="../../eCommon/html/blank.html";
		}
		
	}
}

function latestUpdate()
{

	var bean_id		= f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.bean_id.value;
	var bean_name	= f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.bean_name.value;
	var fm_disp		= f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.previousRecord.value;
	var to_disp		= f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.nextRecord.value;
	var tabVal		= f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.tabVal.value;

	var value_str	= "";
	var seq_str = "";
	var catalog_str = "";
	var ord_type_str = "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
			var value = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.include'+i);

			if(!value.disabled)
			{
				if(value.checked)
				{
					val = "Y";
				}
				else
				{
					val = "N";
				}				
			}
			else
			{
				val ="N";
			}				

				value_str += val+"~";

		 
				tick_sheet_seq_num = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.tick_sheet_seq_num'+i).value;

				catalog_code = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.catalog_code'+i).value;
				order_type_code = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.order_type_code'+i).value;
					
				if(tick_sheet_seq_num=="")
				{
					tick_sheet_seq_num = "N";
				}

			
				seq_str += tick_sheet_seq_num+"~";
				catalog_str += catalog_code+"~";
				ord_type_str += order_type_code+"~";

		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " TICK_SHEET_SEQ_NUM=\""+ seq_str + "\" ";
		xmlStr += " CATALOG_CODE=\""+ catalog_str + "\" ";
		xmlStr += " ORDER_TYPE_CODE=\""+ ord_type_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"CatalogsBySectionBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CatalogsbySectionValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;
	}

	function checkVal(obj)
	{
		document.CatalogsBySectionDetail.dispMode.value = obj;
		document.CatalogsBySectionDetail.submit();
	}

	function onApplyUpdate()
	{

		var refForm = f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail;
		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";
		var seq_str = "";
		var catalog_str = "";
		var ord_type_str = "";
			
		fm_disp = parseInt(fm_disp,10);
		to_disp = parseInt(to_disp,10);

		for(i=fm_disp; i<=to_disp; i++)
		{
			var value = eval('refForm.include'+i);
			if(!value.disabled)
			{
				if(value.checked)
				{
					val = "Y";
				}
				else
					val = "N";
			}
			else
				val ="N";

			value_str += val+"~";
			tick_sheet_seq_num = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.tick_sheet_seq_num'+i).value;

			catalog_code = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.catalog_code'+i).value;

			order_type_code  = eval('f_query_add_mod.f_query_add_mod_detail.document.CatalogsBySectionDetail.order_type_code'+i).value;
				
			if(tick_sheet_seq_num=="")
			{
				tick_sheet_seq_num = "N";
			}

		
			seq_str += tick_sheet_seq_num+"~";
			catalog_str += catalog_code+"~";
			ord_type_str += order_type_code+"~";

	}

	var xmlStr ="<root><SEARCH ";
	xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
	xmlStr += " TICK_SHEET_SEQ_NUM=\""+ seq_str + "\" ";
	xmlStr += " CATALOG_CODE=\""+ catalog_str + "\" ";
	xmlStr += " ORDER_TYPE_CODE=\""+ ord_type_str + "\" ";
	xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
	xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
	xmlStr += " CLASS_NAME=\"CatalogsBySectionBean\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CatalogsbySectionValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}

function addListValues(code,value) 
{
	getHandleHeader();
	var element = headerDoc.CatalogSectionHeader.document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	headerDoc.CatalogSectionHeader.document.getElementById("section").add(element);	
}

function sectionList() 
{
	docObj = "document.frames[1].frames[0].document";
	getHandleHeader();
	//var len = headerDoc.CatalogSectionHeader.document.getElementById("section").options.length;
	var len = docObj+".section.options.length" ; 
	for(var i=0;i<len;i++)
	{
		eval(docObj+".section.remove(\"atc_class_l2_code\")") ;
	}
	var tp ="-----"+ getLabel("Common.defaultSelect.label","Common")+"-----" ;
	var opt = docObj+".createElement(\"OPTION\")" ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	docObj+".section.add(opt)" ;
}
/*added by Uma on IN013057 Ends here*/


/****************************************************************************/
/**
Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	CatalogBySection.jsp---->CatalogBySection.js
		|
		|------MstToolBar
		|
		|------CatalogsBySectionMultiple.jsp
		|		|
		|		|---CatalogsBySectionHeader.jsp
		|		|		Document ---headerDoc
		|		|		FormObect---formObjHeader
		|		|
		|		|---CatalogsBySectionDetail.jsp
		|		|		Document ---detailDoc
		|		|		FormObect---formObjDetail
		|
		|------MessageFrame
		|

**/

