/*****************************DEVELOPED BY RAMANA CV**********************************************/
var Item_code = "";
	function callItemSearchScreen (obj) 
	{
		var search_string=obj.value;	
		var store_code="";
		var category ="A";
		var sole_source ="A";
		var ps_item ="A";
		var mfg_item ="A";
		var expiry ="A";
		var consignment ="A";
		var item_class ="";
		var store_disable ="Y";
		var retVal=callItemSearchWindow(search_string,store_code,category,sole_source,ps_item,mfg_item,expiry,item_class,consignment,"","",store_disable);
		if(retVal!=null)
		{
			var item_C = retVal[0];
			item_Cod = item_C;
			var unit_cost = retVal[14];
			var exp_yn = retVal[2];
			var store_code = retVal[20];
			document.AmendSalePriceCriteria.item_code.value = item_C;
			Item_code=item_C;
			searchDetails();
		}
	}
	async function showHistory(trObj) 
	{
		var batch_id =trObj.cells[0].innerText;
		var item_code=document.formAmendSalePriceResult.item_code.value;
		var trade_name =trObj.cells[2].innerText;;
		retVal=await window.showModalDialog("../../eST/jsp/AmendSalePriceHistory.jsp?&item_code="+item_code+"&batch_id="+batch_id+"&trade_name="+trade_name,'','dialogHeight:30vh; dialogWidth:55vw; center:0; status: no; dialogLeft :75; dialogTop :250;');
	}

	function searchDetails()
	{
		top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		var errorPage = "../../eCommon/jsp/error.jsp";
		var item_code=document.forms[0].item_code.value;
		var messageFrame=top.content.messageFrame;
		var fields	= new Array ( document.forms[0].item_code);
		var names	= new Array (getLabel("Common.ItemCode.label","Common"));
		var blankObject = null;
		if (item_code=="") 
		{
			blankObject = getBlankField( fields, names, messageFrame,errorPage);
			//parent.messageFrame.location.href=errorPage+"?err_num="+getMessage("ITEM_CAN_NOT_BLANK");//change 16/7/08 modified
			return;
		}
		blankObject = getBlankField( fields, names, messageFrame,errorPage);
		var batch_id = document.forms[0].batch_id.value;
		var exp_date = document.forms[0].exp_date.value;
 		if (blankObject==null)
		{
			parent.frames[2].location.href="../../eST/jsp/AmendSalePriceResult.jsp?&item_code="+item_code+"&batch_id="+batch_id+"&exp_date="+exp_date;
		}
	} 
	function reset() 
	{
	    parent.frames[2].location.reload();

	}
	async function confirmFinalize() 
	{
		
		/** @user - ST_PREPARE_HDR */
		var retVal="";
		var dialogHeight= "8vh" ;
		var dialogWidth	= "25vw" ;
		var dialogTop = "250" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: no " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eST/jsp/ConfirmAmendSalePrice.jsp";
		retVal = await window.showModalDialog(url,arguments,features);
		if(retVal == null) 
		{
			retVal="";
		}
		return retVal;
	}

//** @ Modified on 22/7/08      **/
async function apply() 
{
		var errorPage = "../../eCommon/jsp/MstCodeError.jsp";
		var frmobj=f_query_add_mod.document.forms[0];
		var fields = new Array (frmobj.item_code);
		var names	= new Array (getLabel("Common.ItemCode.label","Common"));
		if(f_query_add_mod.checkSTFields( fields, names, messageFrame))
        var response	=	await confirmFinalize(); 
		if (response==YES)
		{	

			var frmobj=frames[2].document.formAmendSalePriceResult;
			//alert("frmobj-->" +frmobj.name);
			var responseText = formApply(frmobj, ST_CONTROLLER);
			//alert(responseText)
		    eval(responseText);
			//messageFrame.location.href = errorPage + "?err_num=" + message;
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+message;
			
			if (result) 
			{
				onSuccess();
			}
	   }
	   else
	   {
           	frameAmendSalePriceResult.location.href="../../eCommon/html/blank.html";
	   }
}
function assignResult( _result, _message, _flag ) 
{
		result = _result ;
		message  = _message ;
		flag = _flag ;
}
function onSuccess()
{
		f_query_add_mod.location.reload();
		frameAmendSalePriceResult.location.href="../../eCommon/html/blank.html";
}
/*****************************ends here**********************************************/
