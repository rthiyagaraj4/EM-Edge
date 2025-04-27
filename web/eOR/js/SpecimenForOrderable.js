/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";

function apply(){
    var message;
	if (! checkIsValidForProceed() )
    {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
     var formObj = f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader;
	 var fields = new Array (formObj.order_catalog_code);
	 var names = new Array (getLabel("Common.ordercatalog.label","Common"));
	 if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
	 var flag = onApplyUpdate();
	 
	if(flag ){
        eval(formApply(formObj,OR_CONTROLLER)) ;
			
             messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
			if(resultGlobal){
				onSuccess();
			}
		      }
		        }
                  }

function create() {
f_query_add_mod.location.href='../../eOR/jsp/SpecimenForOrderableAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

function getHandleHeader(){

       if(parent.parent.f_query_add_mod.f_query_add_mod_header == null)
	   return false;
       headerDoc	     =parent.parent.f_query_add_mod.f_query_add_mod_header.document ;
       formObjHeader   =headerDoc.SpecimenForOrderableHeader;
      // var order_category_id=formObjHeader.document.forms[0].order_catalog_code.value;
       var order_category_id=document.getElementById("order_catalog_code").value;
}

 function before_show_order_catalog_window(target,code){
        getHandleHeader();
       if(formObjHeader!=null){
	   // if(target.value != formObjHeader.document.SpecimenForOrderableHeader.temp_catalog_desc.value) {
    	   if(target.value != document.getElementById("temp_catalog_desc").value) {
		if(target.value!="")
			show_order_catalog_window(target,code);
		else{
		target.value="";
		code.value="";
		//formObjHeader.all.temp_catalog_desc.value= "";
		document.getElementById("temp_catalog_desc").value= "";
	 }
       }
          }
             }
  
  async function show_order_catalog_window(target,code){
	getHandleHeader();
    if(formObjHeader!=null){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//argumentArray[0]   = formObjHeader.document.SpecimenForOrderableHeader.order_catalog_sql.value;
	argumentArray[0]   = document.getElementById("order_catalog_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal =await CommonLookup( getLabel("Common.ordercatalog.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "")
	{
	  code.value=arr[0];
	  target.value=arr[1];
	  //formObjHeader.all.temp_catalog_desc.value=retVal[1];
	  document.getElementById("temp_catalog_desc").value=retVal[1];
    }
	else
	{
      //formObjHeader.all.catalog_desc.value= "";
      document.getElementById("catalog_desc").value= "";
	}
}
}
function dispLink(obj){
       // var order_catalog_code	= document.forms[0].all.order_catalog_code.value;
	 var order_catalog_code	= document.getElementById("order_catalog_code").value;
	    if(order_catalog_code != ""){
		var buttonVal = obj;
		if(buttonVal == "S"){
			//document.forms[0].all.SelectTab.className="clicked";
			document.getElementById("SelectTab").className="clicked";
			//document.forms[0].all.AssociateTab.className="normal";
			document.getElementById("AssociateTab").className="normal";
		}else if(buttonVal == "A"){
			//document.forms[0].all.SelectTab.className="normal";
			document.getElementById("SelectTab").className="normal";
			//document.forms[0].all.AssociateTab.className="clicked";
			document.getElementById("AssociateTab").className="normal";
		}
		var formObjAddMod = document.forms[0];
		formObjAddMod.catalog_desc.disabled=true;
		formObjAddMod.search.disabled=true;
		//document.forms[0].all.tabVal.value = buttonVal;
		document.getElementById("tabVal").value = buttonVal;
       if(parent.frames[1].location.href.indexOf(".jsp") != -1){
         var flag = latestUpdate();
		}
       if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;
       //alert(linkContent);
		if(buttonVal=="A"){
        //document.forms[0].all.linkId.className ="";
        document.getElementById("linkId").className ="";
		//document.forms[0].all.linkId.innerHTML = "&nbsp;";
        document.getElementById("linkId").innerHTML = "&nbsp;";
        parent.frames[1].location.href="../../eOR/jsp/SpecimenForOrderableDetail.jsp?tabVal="+buttonVal+"&order_catalog_code="+order_catalog_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}else{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			//document.forms[0].all.linkId.innerHTML = linkContent;
			document.getElementById("linkId").innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else{
        var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.ordercatalog.label","Common"))));
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}

}
function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	//var fldObj = document.forms[0].order_catalog_code;
	var fldObj = document.getElementById("order_catalog_code");
	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	var order_catalog_code = fldObj.value;
	//alert("order_catalog_code##########"+obj);
 if(order_catalog_code !=""){
		parent.f_query_add_mod_detail.location.href="../../eOR/jsp/SpecimenForOrderableDetail.jsp?order_catalog_code="+order_catalog_code+"&index="+obj+"&tabVal=S";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		//fldObj.disabled=true;
		document.forms[0].catalog_desc.disabled=true;
		document.forms[0].search.disabled=true;
	}
	else{
		parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
		var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.ordercatalog.label","Common"))));

		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
}

   function latestUpdate(){
    // alert("latestUpdate");
	var bean_id		= parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.bean_id.value;
	var bean_name	= parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.bean_name.value;
	var fm_disp		= parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.fm_disp.value;
	var to_disp		= parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.to_disp.value;
	var tabVal		= parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.tabVal.value;
	var value_str	= "";
    var value_str1	= "";
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.select_yn'+i);
		
			if(!value.disabled){

				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";
				value_str += val+"~";

		  if(tabVal=="A")
		{
		  var value1 = eval('parent.f_query_add_mod_detail.document.SpecimenForOrderableDtl.default_yn'+i);
				if(value1.checked){
					val1 = "Y";
					
				}else
					val1 = "N"; 
          value_str1 += val1+"~";
		}
		}
		
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		 if(tabVal=="A")
	   {
		xmlStr += " INDEX_VALUES1=\""+ value_str1+ "\" ";
	   }
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"SpecimenForOrderable\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","SpecimenForOrderableValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert("responseText========="+ responseText ) ;
		return true;
	}
   
function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function onApplyUpdate(){
	 //alert("onApplyUpdate");
	
	var refForm =f_query_add_mod.f_query_add_mod_detail.document.SpecimenForOrderableDtl;
	
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") != -1){
		
		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";
		 var value_str1	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			var value = eval('f_query_add_mod.f_query_add_mod_detail.document.SpecimenForOrderableDtl.select_yn'+i);
			
			if(!value.disabled){
				if(value.checked){
					val = "Y";
					
				}else
					val = "N";
				}
				else
					val ="N";
			value_str += val+"~";

			   if( eval('f_query_add_mod.f_query_add_mod_detail.document.SpecimenForOrderableDtl.default_yn'+i))
			 {
				var value1 = eval('f_query_add_mod.f_query_add_mod_detail.document.SpecimenForOrderableDtl.default_yn'+i);
				if(value1.checked){
					val1 = "Y";
					
				}else
					val1 = "N";
				value_str1 += val1+"~";
			 }
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " INDEX_VALUES1=\""+ value_str1 + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"SpecimenForOrderable\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","SpecimenForOrderableValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}
	else
	{
		return true;
	}

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
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
function reset()
{
	if (f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.document.forms[0].reset();
	}
	else if(f_query_add_mod.f_query_add_mod_header.location.href.indexOf(".jsp") != -1)
	{
		f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader.reset();
		f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader.order_catalog_code.disabled=false;
		f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader.search.disabled=false;
		f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader.catalog_desc.disabled=false;
		f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader.catalog_desc.focus();	
		f_query_add_mod.f_query_add_mod_detail.location.href = '../../eCommon/html/blank.html';
		//create();
	}
	else
	{
		f_query_add_mod.f_query_add_mod_header.document.SpecimenForOrderableHeader.order_catalog_code.disabled=false;
		frames[0].location.reload();
		return false;
	}

}

function onSuccess(){

	f_query_add_mod.location.href='../../eOR/jsp/SpecimenForOrderableAddModify.jsp?mode='+MODE_INSERT
	
}
/***********default_yn value**************/
function defaultYnValue(obj){
if (obj.checked==true)
obj.value="Y";
else
	obj.value="N"
return obj;

}
