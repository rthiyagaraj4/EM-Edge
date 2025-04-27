/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var message;
var alpha = new String();

function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/PrivilegeGroupMain.jsp?mode=1&function_id="+function_id;
}

function reset() {
	f_query_add_mod.location.href = "../../eOR/jsp/PrivilegeGroupMain.jsp?mode=1&function_id="+function_id;
}

function query() {
f_query_add_mod.location.href='../../eOR/jsp/PrivilegeGroupQueryCriteria.jsp?mode=2&function_id='+function_id ;
	}

function getHandleHeader(){
	//alert('in getHandleHeader,f_query_add_mod.header='+f_query_add_mod.header.name);
if(f_query_add_mod.headerFrame == null){
	 return false;
}
 headerDoc	     =f_query_add_mod.headerFrame.document ;
 formObjHeader   =headerDoc.formPrivilegeGroupHdr ;
 }

 function getHandleDetail(){
if(f_query_add_mod.ordercataegorydtls == null)
	 return false;
else
	return true;
}

/*function reset()
{
  if(f_query_add_mod.headerFrame != null){
  	
		getHandleHeader();
		formObjHeader.reset();
		f_query_add_mod.ordercataegorydtls.location.href = "../../eCommon/html/blank.html";
		 }
		else if(f_query_add_mod.document.forms[0]!=null)	   
		f_query_add_mod.document.forms[0].reset(); //reset in query mode
		else{
		frames[0].location.reload(); //reset in query mode
		return false;
		}

}*/
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

function apply()
{
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	getHandleHeader();
	getHandleDetail();

	var chkMandatoryFlag = true ;



	var	fields = new Array (formObjHeader.Privilege_id,formObjHeader.Privilege_long_desc);
	var	names =	new	Array (getLabel("eOR.PrivilegeGroupID.label","OR"),getLabel("eOR.PrivilegeGroupDescription.label","OR"));
	if(!checkFieldsofMst(fields,	names, messageFrame)){
		return ;
	}


	var flds=new Array(formObjHeader.Privilege_id);
	var name=new Array(getLabel("eOR.PrivilegeGroupID.label","OR"));

	if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/error.jsp")){
			return false
	}
	eval(formApply(formObjHeader,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal){
	onSuccess();
	f_query_add_mod.location.href = "../../eOR/jsp/PrivilegeGroupMain.jsp?mode=1&function_id="+function_id;
	}else{
	return false;
	}


}

function onSuccess() {
	getHandleHeader();
	
}




function display(obj){
	var tabvalue=obj;
	var mode=document.tab.mode.value;
	var currentview=document.tab.currentview.value;
	if(parent.headerFrame == null)
	{
				return false;
	}
	else
	{		
		if(parent.headerFrame.document.formPrivilegeGroupHdr)
		{
			if((parent.headerFrame.document.formPrivilegeGroupHdr.Privilege_id.value==null)&&(parent.headerFrame.document.formPrivilegeGroupHdr.Privilege_long_desc.value==null))
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	if(tabvalue=="Associate")
	{
		parent.mainDetails.location.href = "../../eOR/jsp/PrivilegeGroupMainAssociate.jsp?mode="+mode+"&tabvalue="+tabvalue+"&currentview="+currentview ;
		parent.tabFrame.document.getElementById("viewtabs").style.visibility='hidden';
		parent.colorcode.location.href = "../../eOR/jsp/PrivilegeGroupColourCode.jsp";
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
	else if(tabvalue=="select")
	{
		parent.tabFrame.document.getElementById("viewtabs").style.visibility='visible';
		parent.colorcode.location.href = "../../eCommon/html/blank.html";
		parent.mainDetails.location.href = "../../eCommon/html/blank.html"
	}
	else
	{
	parent.mainDetails.location.href = "../../eOR/jsp/PrivilegeGroupMainSelect.jsp?mode="+mode+"&tabvalue="+tabvalue ;
	parent.colorcode.location.href = "../../eOR/jsp/PrivilegeGroupColourCode.jsp";
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
	
}
function displayOnStart(obj)
{
var tabvalue=obj;
var mode=document.tab.mode.value;
parent.mainDetails.location.href = "../../eOR/jsp/PrivilegeGroupMainSelect.jsp?mode="+mode+"&tabvalue="+tabvalue ;
	parent.colorcode.location.href = "../../eOR/jsp/PrivilegeGroupColourCode.jsp";
}
function saveAssociateCategory(tabvalue,code,obj,i)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	var mode=document.forms[0].mode.value;
	if(mode=="2"){
		var vari2='a_cate'+i;
	document.getElementById(vari2).style.visibility='visible';
	var modeQuery="savecategory";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += " tabvalue=\""+ tabvalue +"\" " ;
	xmlStr += " type=\""+ code +"\" " ;
	xmlStr += " mode=\""+ mode +"\" " ;
	xmlStr += " obj=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	}
}

function saveAssociateType(tabvalue,category,code,obj,i)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	var mode=document.forms[0].mode.value;
	if(mode=="2")
	associate_results.document.getElementById('a_type'+i).style.visibility='visible';
	var modeQuery="saveordertype";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += " tabvalue=\""+ tabvalue +"\" " ;
	xmlStr += " type=\""+ code +"\" " ;
	xmlStr += " mode=\""+ mode +"\" " ;
	xmlStr += " obj=\""+ obj.value +"\" " ;
	xmlStr += " order_category=\""+ category +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function saveAssociateCatalog(tabvalue,category,type,code,obj,i)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	var mode=document.forms[0].mode.value;
	if(mode=="2"){
		var vari1='a_cata'+i;
	document.getElementById(vari1).style.visibility='visible';
	var modeQuery="savecatalog";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += " tabvalue=\""+ tabvalue +"\" " ;
	xmlStr += " type=\""+ code +"\" " ;
	xmlStr += " mode=\""+ mode +"\" " ;
	xmlStr += " obj=\""+ obj.value +"\" " ;
	xmlStr += " order_category=\""+ category +"\" " ;
	xmlStr += " order_type=\""+ type +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	}
}

function saveChanged(tabvalue,type,obj,key,i,undo)
{
	i=parseInt(i);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id=document.getElementById('bean_id').value;
	var bean_name=document.getElementById('bean_name').value;
	var mode=document.getElementById('mode').value;
	if(key=="category")
	{
	var modeQuery = "savecategory";
	if(mode=="2" && undo!="X"){
		//alert("visible");
		var vari1='a_cata'+i;
	ordercataegorydtls.document.getElementById(vari1).style.visibility='visible';
	}
	}
	else if(key=="type")
	{
		//alert("3");
		var vari2='a_type'+i;
	var modeQuery = "saveordertype";
	var order_category=document.forms[0].order_category.value;
	if(mode=="2"  && undo!="X"){
	ordertypedtls_result.document.getElementById(vari2).style.visibility='visible';
	}
	}
	else if(key=="catalog")
	{
	var modeQuery = "savecatalog";
	var order_category=document.forms[0].order_category.value;
	var order_type=document.forms[0].order_type.value;
	if(mode=="2"  && undo!="X"){
		var vari3='a_cata'+i;
	detailLowerForm.document.getElementById(vari3).style.visibility='visible';
	}
	}
	

	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += " tabvalue=\""+ tabvalue +"\" " ;
	xmlStr += " type=\""+ type +"\" " ;
	xmlStr += " mode=\""+ mode +"\" " ;
	xmlStr += " obj=\""+ obj.value +"\" " ;
	if(key=="type")
	xmlStr += " order_category=\""+ order_category +"\" " ;
	if(key=="catalog")
	{
	xmlStr += " order_category=\""+ order_category +"\" " ;
	xmlStr += " order_type=\""+ order_type +"\" " ;
	}
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}


function loadOrdertypes(order_category_code,order_category_desc)
{
	parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	parent.parent.detailFrameCatalog.location.href = "../../eCommon/html/blank.html";
	parent.parent.detailFramecatalogDetails.location.href = "../../eCommon/html/blank.html";
	var tabValue=document.ordercataegorydtls.tabValue.value;
	var mode=document.ordercataegorydtls.mode.value;
	var finalString="&order_category_code="+order_category_code+"&order_category_desc="+order_category_desc+"&tabValue="+tabValue+"&mode="+mode;

	parent.parent.ordertypedtls.location.href = "../../eOR/jsp/PrivilegeGroupOrderType.jsp?"+finalString;
}
function enableCatalog(order_type)
{
	parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	parent.parent.detailFramecatalogDetails.location.href = "../../eCommon/html/blank.html";
	var order_category=document.ordertypedtls_result.order_category.value;
	var tabValue=document.ordertypedtls_result.tabValue.value;
	var mode=document.ordertypedtls_result.mode.value;
	var finalString="&order_category="+order_category+"&order_type="+order_type+"&tabValue="+tabValue+"&mode="+mode;
	parent.parent.detailFrameCatalog.location.href = "../../eOR/jsp/PrivilegeGroupCatalog.jsp?"+finalString;
}
function OderCatalogForSelIndx(indx,limit_text)
{
	var order_category=detailFrameCatalog.document.detailUpperForm.order_category.value;
	var order_type=detailFrameCatalog.document.detailUpperForm.order_type.value;
	var tabValue=detailFrameCatalog.document.detailUpperForm.tabValue.value;
	var mode=detailFrameCatalog.document.detailUpperForm.mode.value;
	/*Modified by Uma on 9/27/2009 for PMG-CRF-641*/
	var finalString="&order_category="+order_category+"&order_type="+order_type+"&alp="+indx+"&tabValue="+tabValue+"&mode="+mode+"&limit_text="+limit_text;
	/*Ends Here*/
	detailFramecatalogDetails.location.href="../../eOR/jsp/PrivilegeGroupOrderCatalog.jsp?"+finalString;
}



function populateOrderTypes(OrderCategory)
{
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var modeQuery = "test";
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += OrderCategory.name+"=\""+ OrderCategory.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&fill=OrderCategory",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );

	parent.parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	//top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentResultFrame.document.location.href="../../eCommon/html/blank.html";
	//top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentResultHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	
}
function change(obj)
{
	if(obj.checked)
	{
		document.formPrivilegeGroupHdr.eff_status_yn.value="E";
	}
	else
	{
		document.formPrivilegeGroupHdr.eff_status_yn.value="D";
	}
}
function undoChanges(tabvalue,typecode,type,place,undovalue,index)
{
	index=parseInt(index);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var modeQuery = "undo";
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += " tabvalue=\""+ tabvalue +"\" " ;
	xmlStr += " typecode=\""+ typecode +"\" " ;
	xmlStr += " type=\""+ type +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	eval("document.forms[0].accessspecifier"+index).value=undovalue;
	if(type=="C")
		document.getElementById('a_cate'+index).style.visibility='hidden';
	if(type=="T")
	document.getElementById('a_type'+index).style.visibility='hidden';
	if(type=="I")
		document.getElementById('a_cata'+index).style.visibility='hidden';
	/*if(place=="A")
	parent.associateDetails.location.reload();
	else if(place=="C")
	parent.ordercataegorydtls_result.location.reload();
	else if(place=="T")
	parent.ordertypedtls_result.location.reload();
	else if(place=="I")
	parent.ordercatalog_result.location.reload();*/
}
function fillCopyFrom(tabvalue,obj)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var modeQuery = "copy";
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += " tabvalue=\""+ tabvalue +"\" " ;
	xmlStr += " obj=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PrivilegeGroupFetchValues.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
	parent.parent.parent.mainDetails.location.reload();
}

function clearPrivilegeGroupOrderType( docObj ) 
{
	
	var len = eval(docObj+".formPrivilegeGroupDtl.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".formPrivilegeGroupDtl.order_type.remove(\"order_type\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".formPrivilegeGroupDtl.order_type.add(opt)") ;
		
}

function addorderTypeData2List(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.formPrivilegeGroupDtl.order_type.add(element);
}

function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
	if(messageGlobal=="CLICK_ONE_ORDERABLE" && resultGlobal==false){
		messageGlobal=getMessage('CLICK_ONE_ORDERABLE',"OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		return false;
	}
}

function update(tabvalue)
{
	parent.parent.parent.tabFrame.document.getElementById('currentview').value=tabvalue;
}
/*Added by Uma on 9/27/2009 for PMG-CRF-641*/
function callOnAlphaLink(obj1,obj2)
{
	//document.detailUpperForm.all.searchTxt.style.display = "inline";
	var limitText = new String();
	document.detailUpperForm.search_text.value = "";
	if(document.detailUpperForm.limt_auth_to)
		limitText = document.detailUpperForm.limt_auth_to.value;

	if(obj1 == "OTH")
		obj1 = "Others" ;
	alpha = obj1;
	changeAlphaColor(obj2);
	parent.OderCatalogForSelIndx(obj1,limitText);
}


function notAllowOtherChar(event)
{	  
	var whichCode = (window.Event) ? event.which : event.keyCode;
	if (whichCode == 13) 
	{
		return false; 
	}
	key = String.fromCharCode(whichCode);  // Get key value from key code
	var sText = new String();
	sText = document.detailUpperForm.search_text.value;
	if(sText.length==0)
	{
	   if((key.toUpperCase())!=(alpha.charAt(0)).toUpperCase())
	   {
		   return false;
	   }  
	}
}

function callSearch()
{
   var sText = new String();
   var limitText = new String();
   sText = document.detailUpperForm.search_text.value;
   limitText = document.detailUpperForm.limit_text.value;
   if((sText.charAt(0)).toUpperCase()==(alpha.charAt(0)).toUpperCase())
   {
	 if(sText == "OTH")
	 sText = "Others" ;
	  parent.OderCatalogForSelIndx(sText,limitText);
   }
   else
   {		 
		var message  = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");
		parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		document.detailUpperForm.search_text.value = "";
		parent.detailFramecatalogDetails.location.href="../../eCommon/html/blank.html";
   }
   sText = "";
}

function callLimitText(obj)
{
	var sText = new String();
	sText = document.detailUpperForm.search_text.value;
	parent.OderCatalogForSelIndx(sText,obj.value);
}

function callSearchText()
{
   var sText = new String();
   var limitText = new String();
   var cell;
   sText = document.detailUpperForm.search_text.value;
   if(document.detailUpperForm.limt_auth_to)
	limitText = document.detailUpperForm.limt_auth_to.value;
   parent.OderCatalogForSelIndx(sText,limitText);
	for(var i=0; i<26; i++)
	{
		cell=eval("cell"+i);
		cell.className="normal";
	}
	celloth.className="normal";

}
/*Ends Here*/
