function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/CAExternalApplDtlAddModify.jsp?mode=insert';
}


function View_OrderType(obj)
{
	//alert(obj.value);
		var len = parent.frames[1].document.CAExternalApplDtlMainForm.order_type.length;
		
		if(len > 1 )
		{
			for(var i = 2;i<=len;i++){
			parent.frames[1].document.forms[0].order_type.options.remove(i);
			//alert(i);
			}
		}
		/*var opt = parent.frames[1].document.createElement('OPTION');
		opt.text = "--- ALL ---";
		opt.value="*ALL";
		parent.frames[1].document.forms[0].order_type.add(opt);*/

	//alert(parent.frames[1].document.CAExternalApplDtlMainForm.order_type.length);
	var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAExternalApplDtlViewOrderType.jsp'><input type=hidden name=order_category value='"+obj.value+"'></form></body></html>"

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', htmlVal);
	parent.messageFrame.document.tempForm.submit();

}

async function show_order_catalog()
{
		var order_category = document.CAExternalApplDtlMainForm.order_category.value;  
		var order_type_code = document.CAExternalApplDtlMainForm.order_type.value;
		
		var target				= document.CAExternalApplDtlMainForm.order_catalog1;
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		var title=getLabel("Common.ordercatalog.label","Common");
		var sql=" select ORDER_CATALOG_CODE ,SHORT_DESC from or_order_catalog where  ORDER_CATEGORY = `"+order_category+"` and ORDER_TYPE_CODE    =`"+order_type_code+"` and eff_status=`E`";
		
		//alert(sql);
		var order_catalog = document.CAExternalApplDtlMainForm.order_catalog.value;

		search_code="ORDER_CATALOG_CODE";
		search_desc="SHORT_DESC";
	
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();

		if (retVal != null && retVal != ''){

			var retVal=unescape(retVal);
			arr=retVal.split("::");

		   	var arrs=arr[0];
			document.CAExternalApplDtlMainForm.order_catalog1.value=arr[1];
			document.CAExternalApplDtlMainForm.order_catalog.value=arr[0];
			document.CAExternalApplDtlMainForm.order_catalog1.focus();
		}
		
	}


function apply()
{
	var fields = new Array(f_query_add_mod.document.CAExternalApplDtlMainForm.application,f_query_add_mod.document.CAExternalApplDtlMainForm.order_category,f_query_add_mod.document.CAExternalApplDtlMainForm.order_catalog);
    
	var names = new Array (getLabel("Common.Application.label",'common'),getLabel("Common.OrderCategory.label",'common'),getLabel("Common.ordercatalog.label",'common'));

	if(checkFieldsofMst(fields, names, messageFrame))
	{
		f_query_add_mod.document.CAExternalApplDtlMainForm.submit();
	}
}


function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

function enable_Check(obj)
{
	if(obj.checked)
	{
		document.CAExternalApplDtlMainForm.eff_status.value = 'E'
	}
	else
	{
		document.CAExternalApplDtlMainForm.eff_status.value = 'D'
	}
}

function onSuccess(){
f_query_add_mod.location.reload();
}

function reset()
{
	f_query_add_mod.location.reload();
}

function query()
{
	f_query_add_mod.location.href="../../eCA/jsp/CAExternalApplDtlCriteria.jsp";
}

async function show_facility_id()
{
		var target				= document.CAExternalApplDtlMainForm.facility_id;
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		var title=getLabel("Common.facility.label","Common");
		var sql=" select facility_id ,facility_name from sm_facility_param where  status=`E`";
		
		//alert(sql);
		var order_catalog = document.CAExternalApplDtlMainForm.order_catalog.value;

		search_code="facility_id";
		search_desc="facility_name";
	
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();

		if (retVal != null && retVal != ''){

			var retVal=unescape(retVal);
			arr=retVal.split("::");

		   	var arrs=arr[0];
			document.CAExternalApplDtlMainForm.facility_id1.value=arr[0];
			document.CAExternalApplDtlMainForm.facility_id.value=arr[1];
			document.CAExternalApplDtlMainForm.facility_id1.focus();
		}
		
	}

function get_order_catalog(obj)
{
	var temp=document.CAExternalApplDtlMainForm.order_catalog1.value;	
	if(temp!=getLabel("Common.all.label","Common"))
	{
		var order_category = document.CAExternalApplDtlMainForm.order_category.value; 
		var order_type_code = document.CAExternalApplDtlMainForm.order_type.value;

		if(obj.value=="" || obj.value=="null"){
				//obj.value=getLabel("Common.all.label","Common");
				//document.forms[0].order_catalog.value="*ALL";
		}
		else
		{
		
		  var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'> <form name=tempForm method=post action='../../eCA/jsp/CAExternalApplDtlGetOrderCatalog.jsp'><input type=hidden name=search_value value='"+obj.value+"'><input type=hidden name=order_category value='"+order_category+"'><input type=hidden name=order_type_code value='"+order_type_code+"'></form></body></html>"
		  
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', htmlVal);
		parent.messageFrame.document.tempForm.submit();

		}
	}
}

function enable_order_catalog(obj)
{

	document.forms[0].order_catalog1.value = getLabel("Common.all.label","Common");
	document.forms[0].order_catalog.value = "*ALL";

	if(obj.value!="" && obj.value!="*ALL" )
	{
		document.forms[0].order_catalog1.disabled = false;
		document.forms[0].catalog_buttn.disabled = false;
	}
	 else
	{
		document.forms[0].order_catalog1.disabled = true;
		document.forms[0].catalog_buttn.disabled = true;
	}
}

function get_facility(obj)
{
	var temp=document.CAExternalApplDtlMainForm.facility_id1.value;
	if(temp!=getLabel("Common.all.label","Common"))
	{
		if(obj.value=="" || obj.value=="null")
		{
			//obj.value=getLabel("Common.all.label","Common");
			//document.forms[0].facility_id.value="*ALL";
		}
		else
		{
			var htmlVal = "<html><head><link ref='stylesheet' type='text/css' href='../../eCommon/html/IeStyle/css'> </link> </head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name=tempForm id=tempForm method=post action='../../eCA/jsp/CAExternalApplDtlGetFacilityCode.jsp'><input type=hidden name=search_value id=search_value value='"+obj.value+"'></form></body></html>"
		  	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', htmlVal);
			parent.messageFrame.document.tempForm.submit();
		}
	}
}

function clear_message()
{
	//alert(parent.messageFrame.location.href);
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}

