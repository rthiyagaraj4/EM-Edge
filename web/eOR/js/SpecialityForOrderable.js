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
	var group_by=f_query_add_mod.f_query_add_mod_header.document.SpecialityForOrderableHeader.group_by.value;
	
	var formObj = f_query_add_mod.f_query_add_mod_dtl_header.document.SpecialityForOrderableDtlHeader;
	if(group_by=="O")
	{
		var fields = new Array (formObj.order_catalog_code);
		var names = new Array (getLabel("Common.ordercatalog.label","Common"));
	}
	else if(group_by=="S")
	{
		var fields = new Array (formObj.splty_code);
		var names = new Array (getLabel("Common.speciality.label","Common"));
	}

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

function create() 
{		
		f_query_add_mod.location.href='../../eOR/jsp/SpecialityForOrderableAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

function getHandleHeader()
{

       if(parent.parent.f_query_add_mod.f_query_add_mod_dtl_header == null)
	   return false;
       headerDoc	     =parent.parent.f_query_add_mod.f_query_add_mod_dtl_header.document ;
       formObjHeader   =headerDoc.SpecialityForOrderableDtlHeader;
	   if(parent.parent.f_query_add_mod.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value=="O")
		{
			var order_category_id= document.getElementById("order_catalog_code").value;
		}
	   else if (parent.parent.f_query_add_mod.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value=="S")
	   {
		   var speclty_code=document.getElementById("splty_code").value;
	   }

}

 function before_show_order_catalog_window(target,code){
        getHandleHeader();
       if(formObjHeader!=null){
	    if(target.value != document.getElementById("temp_catalog_desc").value) {
		if(target.value!="")
			show_order_catalog_window(target,code);
		else{
		target.value="";
		code.value="";
		document.getElementById("temp_catalog_desc").value= "";
	 }
       }
          }
             }
  
  async function show_order_catalog_window(target,code){
	getHandleHeader();
	var spl_code=new Array();
	
	
	var bean_id=document.getElementById("bean_id").value;
	var bean_name=document.getElementById("bean_name").value;
	var order_catalog_splty="SPLTY";
    
	if(formObjHeader!=null){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = document.getElementById("order_catalog_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal =await CommonLookup( getLabel("Common.ordercatalog.label","Common"), argumentArray );
	
	if(retVal != null && retVal != ""){
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	
	  code.value=arr[0];
	  target.value=arr[1];
	  document.getElementById("temp_catalog_desc").value=arr[1];
	  
	  var xmlStr ="<root><SEARCH ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " ORDER_CATALOG_SPLTY=\""+ order_catalog_splty + "\" ";
		xmlStr += " ORDER_CATALOG_CODE=\""+ retVal[0] + "\" ";
		xmlStr += " CLASS_NAME=\"SpecialityForOrderable\"";
		xmlStr +=" /></root>";
  //    var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
  //	var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlDom = new DOMParser().parseFromString(xmlStr, "text/xml");
		var xmlHttp = new XMLHttpRequest();
		//xmlDom.loadXML(xmlStr);
		xmlHttp.open("POST","SpecialityForOrderableValidate.jsp",false);
		xmlHttp.send(xmlDom);
		responseText=xmlHttp.responseText ;
		spl_code=responseText.split('"');
		if(spl_code[1]!="null" && spl_code[1]!="")
		{
			document.splty_speci_ind.style.visibility="visible";
		}
		else
		{
			document.splty_speci_ind.style.visibility="hidden";
		}
		return true;
    }
	else
	{
      formObjHeader.catalog_desc.value= "";
	}
}
}

  
  function dispLink(obj)
{
	var group_by=parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value;
	if(group_by=="O")
	{
        var order_catalog_code	= document.getElementById("order_catalog_code").value;
	}
	else if(group_by=="S")
	{
		//var speclty_code	= document.forms[0].all.splty_code.value;
		var speclty_code	= document.getElementById("splty_code").value;
		
	}
	
	if(group_by=="O")
	{
	    if(order_catalog_code != "")
		{
			var buttonVal = obj;
			if(buttonVal == "S")
			{
				document.getElementById("SelectTab").className="clicked";
				document.getElementById("AssociateTab").className="normal";
			}else if(buttonVal == "A")
			{
				document.getElementById("SelectTab").className="normal";
				document.getElementById("AssociateTab").className="clicked";
			}
			var formObjAddMod = document.forms[0];
			if(parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value=="O")
			{
				parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
				formObjAddMod.catalog_desc.disabled=true;
			}
			else if (parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value=="S")
			{
				parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
				formObjAddMod.splty_desc.disabled=true;
			}
			parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
			formObjAddMod.search.disabled=true;
			document.getElementById("tabVal").value = buttonVal;
			if(parent.frames[2].location.href.indexOf(".jsp") != -1)
			{
				var flag = latestUpdate();
			}
			if(linkContent=="")
				linkContent	=	document.getElementById("linkId").innerHTML;
       //alert(linkContent);
			if(buttonVal=="A")
			{
				document.getElementById("linkId").className ="";  
				document.getElementById("linkId").innerHTML = "&nbsp;";
     			parent.frames[2].location.href="../../eOR/jsp/SpecialityForOrderableDetail.jsp?tabVal="+buttonVal+"&order_catalog_code="+order_catalog_code+"&group_by="+group_by;
	

				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
		   else
			{
				parent.frames[2].location.href="../../eCommon/html/blank.html";
				document.getElementById("linkId").innerHTML = linkContent;
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
		}
		else
		{
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.ordercatalog.label","Common"))));
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
	}
	else if (group_by=="S")
	{
		if(speclty_code != "")
		{
			var buttonVal = obj;
			if(buttonVal == "S")
			{
				document.getElementById("SelectTab").className="clicked";
				document.getElementById("AssociateTab").className="normal";
			}
		    else if(buttonVal == "A")
			{
		    	document.getElementById("SelectTab").className="normal";
		    	document.getElementById("AssociateTab").className="clicked";
			}
			var formObjAddMod = document.forms[0];
			if(parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value=="O")
			{
				parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
				formObjAddMod.catalog_desc.disabled=true;
			}
			else if (parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value=="S")
			{
				parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
				formObjAddMod.splty_desc.disabled=true;
			}
			parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
			formObjAddMod.search.disabled=true;
			document.getElementById("tabVal").value = buttonVal;
			if(parent.frames[2].location.href.indexOf(".jsp") != -1)
			{
				
				var flag = latestUpdate();
			}
		    if(linkContent=="")
				linkContent	=	document.getElementById("linkId").innerHTML;
       //alert(linkContent);
			if(buttonVal=="A")
			{
				document.getElementById("linkId").className =""; 
				document.getElementById("linkId").innerHTML = "&nbsp;"; 
      
				parent.frames[2].location.href="../../eOR/jsp/SpecialityForOrderableDetail.jsp?tabVal="+buttonVal+"&splty_code="+speclty_code+"&group_by="+group_by;
	

				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
		    else
			{
				parent.frames[2].location.href="../../eCommon/html/blank.html";
				document.getElementById("linkId").innerHTML = linkContent;
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
	  }
	 else
	 {
         var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new  Array(encodeURIComponent(getLabel("Common.speciality.label","Common"))));
		 parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	 }
  }

}

function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	
    var group_by=parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value;
	if(parent.frames[2].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	if(group_by=="O")
	{
		var fldObj = document.getElementById("order_catalog_code");
		var order_catalog_code = fldObj.value;
	
		 if(order_catalog_code !="")
		{
			parent.f_query_add_mod_detail.location.href="../../eOR/jsp/SpecialityForOrderableDetail.jsp?order_catalog_code="+order_catalog_code+"&index="+obj+"&group_by="+group_by+"&tabVal=S";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	
			document.forms[0].catalog_desc.disabled=true;
			document.forms[0].search.disabled=true;
			parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
		}
		else
		{
			parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.ordercatalog.label","Common"))));

			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
	}
	else if(group_by=="S")
	{
		//var speclty_code=document.forms[0].splty_code.value;
		var speclty_code=document.getElementById("splty_code").value;
		if(speclty_code !="")
		{
			parent.f_query_add_mod_detail.location.href="../../eOR/jsp/SpecialityForOrderableDetail.jsp?splty_code="+speclty_code+"&index="+obj+"&group_by="+group_by+"&tabVal=S";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		//fldObj.disabled=true;
			document.forms[0].splty_desc.disabled=true;
			document.forms[0].search.disabled=true;
			parent.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=true;
		}
		else
		{
			parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
			var msg = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.speciality.label","Common"))));

			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
	}
}

function latestUpdate()
{

 	var bean_id		= parent.f_query_add_mod_detail.document.SpecialityForOrderableDtl.bean_id.value;
	var bean_name	= parent.f_query_add_mod_detail.document.SpecialityForOrderableDtl.bean_name.value;
	var fm_disp		= parent.f_query_add_mod_detail.document.SpecialityForOrderableDtl.fm_disp.value;
	var to_disp		= parent.f_query_add_mod_detail.document.SpecialityForOrderableDtl.to_disp.value;
	var tabVal		= parent.f_query_add_mod_detail.document.SpecialityForOrderableDtl.tabVal.value;
	var value_str	= "";
    var value_str1	= "";
	var order_catalog_code="";
	var order_catalog_splty="";
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
		var value = eval('parent.f_query_add_mod_detail.document.SpecialityForOrderableDtl.select_yn'+i);
		
			if(!value.disabled)
			{

				if(value.checked)
					val = "Y";
				else
					val = "N";
			}
			else
				val ="N";
				value_str += val+"~";
		 
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
	xmlStr += " ORDER_CATALOG_SPLTY=\""+ order_catalog_splty + "\" ";
	xmlStr += " ORDER_CATALOG_CODE=\""+order_catalog_code + "\" ";
	xmlStr += " CLASS_NAME=\"SpecialityForOrderable\"";
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SpecialityForOrderableValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert("responseText========="+ responseText ) ;
	return true;
}
   
function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function onApplyUpdate(){
	 // alert("onApplyUpdate");
	
	//var refForm = document.frames[1].frames[2].document.forms[0];
	var refForm = f_query_add_mod.headerFrame;
	//if(document.frames[1].frames[2].location.href.indexOf(".jsp") != -1){
	if(parent.parent.frames[1].document.location.href.indexOf(".jsp")!= -1){
		//var bean_id		= refForm.bean_id.value;
		var bean_id = f_query_add_mod.f_query_add_mod_header.document.getElementById("bean_id").value;
		//var bean_name	= refForm.bean_name.value;
		var bean_name = f_query_add_mod.f_query_add_mod_header.document.getElementById("bean_name").value;
		//var fm_disp		= refForm.fm_disp.value;
		var fm_disp		= f_query_add_mod.f_query_add_mod_detail.document.getElementById("fm_disp").value;
		//var to_disp		= refForm.to_disp.value;
		var to_disp		= f_query_add_mod.f_query_add_mod_detail.document.getElementById("to_disp").value
		//var tabVal		= refForm.tabVal.value;
		var tabVal = f_query_add_mod.f_query_add_mod_header.document.getElementById("tabVal").value;
		var value_str	= "";
    var value_str1	= "";
	var order_catalog_code="";
	var order_catalog_splty="";
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
		//var value = eval('refForm.select_yn'+i);
		var value = eval(f_query_add_mod.f_query_add_mod_detail.document.getElementById("select_yn")+i);
		
			if(!value.disabled)
			{

				if(value.checked)
					val = "Y";
				else
					val = "N";
			}
			else
				val ="N";
				value_str += val+"~";
		 
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
	xmlStr += " ORDER_CATALOG_SPLTY=\""+ order_catalog_splty + "\" ";
	xmlStr += " ORDER_CATALOG_CODE=\""+order_catalog_code + "\" ";
	xmlStr += " CLASS_NAME=\"SpecialityForOrderable\"";
	xmlStr +=" /></root>";
	//alert(xmlStr);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SpecialityForOrderableValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//alert("responseText========="+ responseText ) ;
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
	else if(document.f_query_add_mod.location.href.indexOf(".jsp") != -1)
	{
		//if(document.frames[1].frames[0].document.forms[0])
		if(f_query_add_mod.f_query_add_mod_dtl_header.SpecialityForOrderableDtlHeader)
		{
			//document.frames[1].frames[0].document.forms[0].reset();
			f_query_add_mod.f_query_add_mod_dtl_header.SpecialityForOrderableDtlHeader.reset();
			//document.frames[1].frames[0].document.forms[0].group_by.disabled=false;
			f_query_add_mod.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.disabled=false;
		}
		//if(document.frames[1].frames[1].document.forms[0])
		if(f_query_add_mod.f_query_add_mod_dtl_header.SpecialityForOrderableDtlHeader)
		{
			//document.frames[1].frames[1].location.href="../../eOR/jsp/SpecialityForOrderableAddModifyDtlHeader.jsp?group_by="+document.frames[1].frames[0].document.forms[0].group_by.value;
			f_query_add_mod.f_query_add_mod_dtl_header.location.href="../../eOR/jsp/SpecialityForOrderableAddModifyDtlHeader.jsp?group_by="+f_query_add_mod.f_query_add_mod_header.SpecialityForOrderableHeader.group_by.value;
			//document.frames[1].frames[2].location.href = '../../eCommon/html/blank.html';
			f_query_add_mod.f_query_add_mod_detail.location.href = '../../eCommon/html/blank.html';
		}
		//create();
	}
	else
	{
		//document.frames[1].frames[0].document.forms[0].order_catalog_code.disabled=false;
		f_query_add_mod.f_query_add_mod_header.SpecialityForOrderableHeader.order_catalog_code.disabled=false;
		//frames[0].location.reload();
		commontoolbarFrame.location.reload();
		return false;
	}

}

function onSuccess(){

	f_query_add_mod.location.href='../../eOR/jsp/SpecialityForOrderableAddModify.jsp?mode='+MODE_INSERT
	
}
/***********default_yn value**************/
function defaultYnValue(obj){
if (obj.checked==true)
obj.value="Y";
else
	obj.value="N"
return obj;

}

function loadHeaderDtl(obj)
{
	parent.f_query_add_mod_dtl_header.location.href="../../eOR/jsp/SpecialityForOrderableAddModifyDtlHeader.jsp?group_by="+obj.value;

}

function before_show_splty_window(target,code)
{
        getHandleHeader();
       if(formObjHeader!=null)
	  {
			if(target.value != document.getElementById("temp_splty_desc").value) 
			{
				if(target.value!="")
					show_splty_window(target,code);
				else
				{
					target.value="";
					code.value="";
					document.getElementById("temp_splty_desc").value= "";
				}
			}
        }
  }
  
 async function show_splty_window(target,code)
 {
	getHandleHeader();
    if(formObjHeader!=null)
	{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		//argumentArray[0]   = formObjHeader.document.SpecialityForOrderableDtlHeader.splty_sql.value;
		argumentArray[0]   = document.getElementById("splty_sql").value;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray;
		argumentArray[3]   = dataTypeArray;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = await CommonLookup( getLabel("Common.speciality.label","Common"), argumentArray );
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
			document.getElementById("temp_splty_desc").value=arr[1];
		}
		else
		{
		  //formObjHeader.all.splty_desc.value= "";
			document.getElementById("splty_desc").value= "";
		}
	}
}
function specialityCode(speciality_code)
{
}
