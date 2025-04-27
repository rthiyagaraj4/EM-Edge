var message = "" ;
var toolBarString = "";
var result=false;
function create() 
          {
	        f_query_add_mod.location.href="../../ePH/jsp/MedicalItemFrames.jsp?mode="+MODE_INSERT;
          }
function query() 
         {
	       f_query_add_mod.location.href="../../ePH/jsp/MedicalItemQueryCriteria.jsp?mode="+MODE_MODIFY;
         }

function searchItem(obj)
	{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var id=MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.language_id.value;
	var sql_order_type=MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_ph_drug_medical_item_select4.value+" AND b.LANGUAGE_ID ='"+id+"' ORDER BY 2";
 	argumentArray[0]   = sql_order_type;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.item_code.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.ItemName.label","Common"), argumentArray );
	if(retVal != null && retVal != "")
		{
	    	MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_code.value = retVal[0] ;
			MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.value = retVal[1];
			MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_desc.disabled	=true;
			MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_desc.value = retVal[1];
			MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.item_code.value = retVal[0];
		}
      sample(obj)
}
function searchGenericName(obj)
	{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_ph_drug_select14.value+"'"+MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.generic_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.GenericName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )
		{
		MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.generic_name.value = retVal[1] ;
		MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.generic_id.value = retVal[0];
		obj.disabled=true;
		MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.generic_name.readOnly=true;
	   }
  }
function validateCode(obj)
	{
	if(obj.value!="" && obj!=null)
		{
		var bean_id		=	document.MedicalItemAddModifyForm.bean_id.value;
		var bean_name	=	document.MedicalItemAddModifyForm.bean_name.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " pres_base_uom=\""+obj.value+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=pres_base_uom",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	}
}
function DispensingUnitclear()
	{
	var formObj = document.MedicalItemAddModifyForm;
	var len		= document.MedicalItemAddModifyForm.stock_uom.length;
	for(var i=0;i<len;i++) {
	formObj.stock_uom.remove("stock_uom") ;
	}
}
function DispensingUnitAssign()
	{
	var formObj = document.MedicalItemAddModifyForm;
	var element = document.createElement('OPTION') ;
	var select=getLabel("ePH.Select.label","PH");
	element.value		= ""
	element.text		= "-----select-----";
	formObj.stock_uom.add(element);
	}
function DispensingUnit(code,desc)
	{
	var formObj = document.MedicalItemAddModifyForm;
	var element = document.createElement('OPTION') ;
	element.value		=  (code) ;
	element.text		=  (desc) ;
	formObj.stock_uom.add(element);
  }
function validateItemCode(obj)
	{
	var frmObj="";
		frmObj=MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm;
    if(obj.checked==false)
		{
		frmObj.item_code.disabled=true;
		frmObj.item_code_lookup.disabled=true;
		}
	else
		{
		frmObj.item_code.disabled=false;
		frmObj.item_code_lookup.disabled=false;
	   }
	}
function loadButtons(mode,Drug_code_value)
	{
     parent.f_query_add_mod.f_drug_tabs.location.href="../../ePH/jsp/MedicalItemButtons.jsp?mode="+mode+"&Drug_code_value="+Drug_code_value;
   }
function disableReason(obj)
	{
	var frmObj = parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm;
	var req_str = frmObj.req_str.value;
	var val=parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.in_formulary_yn.checked;
	if(val==true)
		{
		frmObj.in_formulary_yn.value = "Y";
		frmObj.in_formulary_yn_value.value = "Y";
		frmObj.mandate_reason.style.visibility	= "visible";
		frmObj.item_code.disabled=false;
		frmObj.drug_code.disabled=true;
		frmObj.drug_desc.disabled=true;
		parent.f_drug_tabs.location.href="../../ePH/jsp/MedicalItemButtons.jsp?"+req_str;
		frmObj.item_code.focus();
		}
	else
	   {
		
		if(parent.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.in_formulary_yn.disabled ==false){
		frmObj.in_formulary_yn.value = "N";
		frmObj.in_formulary_yn_value.value = "N";
		frmObj.mandate_reason.style.visibility	= "hidden";
		frmObj.item_code.disabled=true;
		frmObj.drug_code.disabled=false;
		frmObj.drug_desc.disabled=false;
		frmObj.item_code.value="";
		frmObj.drug_code.value="";
		frmObj.drug_desc.value="";
		parent.f_drug_tabs.location.href="../../eCommon/html/blank.html";
		}
		}
	}
function searchTradeName(obj)
	{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0]   = "ITEM_CODE" ;
    dataValueArray[0]  = MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_code.value;
    dataTypeArray[0]   = STRING ;	
	argumentArray[0]   = parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.sql_ph_drug_select19.value+"'"+parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.trade_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.TradeName.label","Common"), argumentArray );
	if(retVal != null && retVal != "" ) 
	{
		parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.trade_name.value = retVal[1] ;
		parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.trade_id.value = retVal[0];
	}
	searchDescription(retVal[0]);
}
function searchDescription(code,objsrc)
	{
if(objsrc==undefined || objsrc=="" || objsrc==null)
objsrc="";
if(objsrc=="")
	{
     var bean_id		=	parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.bean_id.value;
     var bean_name	=	parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.bean_name.value;
     var link		=	parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.link.value;
   } 
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " code=\""+code+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc.async = "false";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(link=="trade_tab")
	xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=searchManufacturer",false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}
function setManufacturerName(manufacturer_detail)
	{
	var manufacturer	=	manufacturer_detail.split(":");
	parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.manufacturer_id.value = manufacturer[0];
	parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.manufacturer_name.value = manufacturer[1] ;
  }
function addDetail(obj,Drug_code_value)
	{
	
     var frmObj	= parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm;
     var mode=frmObj.mode.value;
	 if(frmObj.link.value=="trade_tab"&&frmObj.trade_name.value!="")
		 {
		  if(obj.value==getLabel("Common.Add.label","Common"))
			{
			submitCurrentForm(Drug_code_value,mode);
			}
			else if(obj.value==getLabel("Common.Modify.label","Common"))
			{
			submitCurrentForm(Drug_code_value,mode);
			}
		
	    }
	}
function submitCurrentForm(Drug_code_value,mode)
    {
	var bean_id		="MedicalItemBean";
    var bean_name   ="ePH.MedicalItemBean";
    var code        = MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_code.value;
	var trade_id=parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.trade_id.value;
	var trade_name=parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.trade_name.value;
	var manufacturer_id=parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.manufacturer_id.value; 
	var manufacturer_name=parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm.manufacturer_name.value; 
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " code=\""+code+"\"";
	xmlStr += " trade_id=\""+trade_id+"\"";
	xmlStr += " trade_name=\""+trade_name+"\"";
	xmlStr += " manufacturer_id=\""+manufacturer_id+"\"";
	xmlStr += " manufacturer_name=\""+manufacturer_name+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " Drug_code_value=\""+Drug_code_value+"\"";
	xmlStr += " mode=\""+mode+"\"";
	xmlStr +=" /></root>";
	xmlDoc.async = "false";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=trade_tab",false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
    clearFields();
}

function clearFields()
	{
       var frmObj	= parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm;
		   frmObj.trade_name.value			=	"";
		   frmObj.trade_id.value			=	"";
		   frmObj.manufacturer_name.value	=	"";
		   frmObj.manufacturer_id.value	=	"";
   }
function Duplicate(Drug_code_value)
  {
parent.f_query_add_mod.f_tab_detail.location.href="../../ePH/jsp/MedicalItemDetail.jsp?Drug_code_value="+Drug_code_value;
  }
function DuplicateNotAllowed()
  {
parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_DUP_TRADE_NAME","PH");
}
function updateTradeNames(size)
	{
	rowno_trade=size;
   }
function callReset()
	{
	frmObj	=		parent.f_query_add_mod.f_tab_add_detail.document.MedicalItemAddDetailForm;
	frmObj.reset();
	frmObj.add_butt.style.display	="inline";
	frmObj.add_butt.style.visibility="visible";
	frmObj.add_butt.value=getLabel("Common.Add.label","Common");
	frmObj.del_butt.style.visibility="hidden";
  }
function reset()
	{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ((url.indexOf("medicalitemquerycriteria")!=-1)) 
	{
		f_query_add_mod.document.query_form.reset();
	}
	else if((url.indexOf("medicalitemframes")!=-1)) 
		{
		if(f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.mode.value == 1)
		{
		f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.reset();
		f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.disp_pres_uom.innerText="";
		f_query_add_mod.f_tab_detail.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.f_tab_add_detail.location.href="../../eCommon/html/blank.html";
		var arrObj =f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.elements;
      for(var i=0;i<arrObj.length;i++)
           arrObj[i].disabled=false;
		}
		else 
		{
			f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.reset();
		}
	}
}
function apply()
  {
	var frmObj	=f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm;
    var val=f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.in_formulary_yn.checked;
   if(val==true)
	{
	var fields = new Array ( frmObj.drug_code, frmObj.item_code, frmObj.drug_desc,frmObj.pres_base_uom,frmObj.stock_uom,frmObj.generic_name);
	var names = new Array ( getLabel("Common.code.label","Common"), getLabel("Common.ItemCode.label","Common"),  getLabel("Common.description.label","Common"),getLabel("ePH.PrescribingUnit.label","PH"),
		getLabel("ePH.DispensingUnit.label","PH"),getLabel("Common.GenericName.label","Common"));
	}else if(val==false)
	{
     var fields = new Array ( frmObj.drug_code,frmObj.drug_desc,frmObj.pres_base_uom,frmObj.stock_uom,frmObj.generic_name);
	var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"),getLabel("ePH.PrescribingUnit.label","PH"),
		getLabel("ePH.DispensingUnit.label","PH"),getLabel("Common.GenericName.label","Common"));
	}
	var mode=frmObj.mode.value;
	 if(f_query_add_mod.checkFieldsofMst(fields, names,messageFrame)) {
     if(mode=="1")
	     {
	     //alert(formApply(frmObj,PH_CONTROLLER ));
	     eval(formApply(frmObj,PH_CONTROLLER ));
	     messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		 if( result ) {
			 onSuccess() 
	        }
        }
		 if(mode=="2")
	     {
	    // alert("mode 2 calling-->");
	     //alert(formApply(frmObj,PH_CONTROLLER ));
	     eval(formApply(frmObj,PH_CONTROLLER ));
	     messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		 if( result ) {
			 onSuccess() 
	        }
        }
    } 
}
async function onSuccess() {

	var or_yn			= f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.or_yn.value;
	var mode			=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.mode.value;
	var or_status		=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.or_status.value;
  
	if(or_yn=="Y")
		{
		var drug_code		=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_code.value;
		var drug_desc		=	escape(f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_desc.value);
		var drug_class		=	"G";
		var schedule_id		=	"";
		var drug_cat_code	=	"";
		var base_unit_code	=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.pres_base_uom.value;
		var base_unit_desc	=	escape(f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.pres_base_uom.options[f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.pres_base_uom.selectedIndex].text);
		var sql_order_type	=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_or_ph_select1.value;
		var sql_setting		=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_or_ph_select2.value;
		var sql_auth_level	=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_or_ph_select3.value;
		var refill_yn		=	"N";
		var language_id		=   f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.language_id.value;	
		var sql_21		=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_ph_drug_search_select21.value;
		var sql_22		=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_ph_drug_search_select22.value;
		var sql_23		=	f_query_add_mod.MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.sql_ph_drug_search_select23.value;
		var chk =	false;
		if(mode=="2" && or_status=='true')
			{
			chk=confirm(getMessage("MODIFY_ORDER_INFO","PH"));
			mode = MODE_MODIFY;
		    }
		else
			{
			chk=confirm(getMessage("SETUP_ORDER_INFO","PH"));
			mode  = MODE_INSERT;
		    }
         if(chk)
		  {
			var sql_order_type=sql_21+"'"+drug_class+"' AND B.LANGUAGE_ID ='"+language_id+"' ORDER BY 2";
			var sql_setting="";
			var sql_auth_level=sql_23+"'"+schedule_id+"' AND EFF_STATUS='E' AND A.LANGUAGE_ID = '"+language_id+"' ";
			var dialogHeight= "35vh" ;
			var dialogWidth	= "50vw" ;
			var dialogTop = "60" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			var retVal = await window.showModalDialog("../../eOR/jsp/OROrderCatalog.jsp?mode="+mode+"&uom_desc="+base_unit_desc+"&uom_code="+base_unit_code+"&order_catalog_code="+drug_code+"&long_desc="+drug_desc+"&short_desc="+drug_desc+"&module_id=PH&order_category=PH&sql_order_type="+drug_class+"&sql_setting="+sql_setting+"&sql_auth_level="+schedule_id+"&update_refill_cont_order_yn="+refill_yn,arguments,features);
          	if(restoreToolbar())
				{
				
				create();
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			    }
		  }
		else
		  {
			
			create();
		  }
	  }
else
	{
	
		create();
	}
 }
function restoreToolbar()
	{
	var bean_id		="MedicalItemBean";
    var bean_name   ="ePH.MedicalItemBean";
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=toolBar&"+toolBarString,false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText)
	return true
  }

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function stock_uom_value(obj,pres_base_uom)
{   
	
	var bean_id		="MedicalItemBean";
    var bean_name   ="ePH.MedicalItemBean";
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " pres_base_uom_value=\""+pres_base_uom.value+"\"";
	xmlStr += " stock_uom=\""+obj.value+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc.async = "false";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=packSize",false);
    xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
   
}
function assignPackSize(eqvl_value)
{
		
	document.MedicalItemAddModifyForm.disp_pres_uom.innerText=eqvl_value+" "+document.MedicalItemAddModifyForm.pres_base_uom.options[document.MedicalItemAddModifyForm.pres_base_uom.selectedIndex].text ;
	document.MedicalItemAddModifyForm.pack_size.value=eqvl_value;
}
function sample(obj)
{
	var bean_id		="MedicalItemBean";
    var bean_name   ="ePH.MedicalItemBean";
   	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " Drug_code=\""+obj.value+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc.async = "false";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=drug_code_check",false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}
function DrugCodeCheck()
{
	alert(getMessage('PH_DRUG_ALREADY_EXISTS','PH'));
	MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.item_code.value="";
	MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_code.value="";
	MedicalItemAddModifyFrame.document.MedicalItemAddModifyForm.drug_desc.value="";
}
function sampleValues(j)
{
	var mode=document.MedicalItemDetailForm.mode.value;
	var vaY=""; 
	var trade_id=""; 
	var checkvalue=eval("document.MedicalItemDetailForm.select"+j).checked;
    trade_id=eval("document.MedicalItemDetailForm.trade_id"+j).value
    if(checkvalue==true)
	{
      vaY=eval("document.MedicalItemDetailForm.select_chk1"+j).value="E";
           
	}
	else if(checkvalue==false)
	{
      vaY=eval("document.MedicalItemDetailForm.select_chk1"+j).value="D";
	}
	var bean_id		="MedicalItemBean";
    var bean_name   ="ePH.MedicalItemBean";
   	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " vaY=\""+vaY+"\"";
	xmlStr += " mode=\""+mode+"\"";
	xmlStr += " trade_id=\""+trade_id+"\"";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";
	xmlDoc.async = "false";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MedicalItemValidate.jsp?func_mode=Trade_check",false);
    xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);		
  }
function Modify(obj)
{
	
parent.f_query_add_mod.location.href="../../ePH/jsp/MedicalItemFrames.jsp?mode="+MODE_MODIFY+"&Drug_code_value="+obj;
}
