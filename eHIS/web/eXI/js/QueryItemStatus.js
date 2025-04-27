
//*********************************************************************************
//FUNCTION RESET 
//*********************************************************************************
function reset()
{
}
//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
	parent.QueryItemStatusframeset.rows="30,120,260,30";
//	alert("item_code : "+this.document.forms[0].item_code.value);
    var  item_code = this.document.forms[0].item_code.value;
    var  item_catg = this.document.forms[0].item_catg.value;
    var  org_id = this.document.forms[0].org_id.value;
    var  status = this.document.forms[0].status.value;
	parent.f_query_add_mod_detail.location.href="../../eXI/jsp/QueryItemStatusSearchResult.jsp?item_code="+item_code+"&item_catg="+item_catg+"&org_id="+org_id+"&status="+status;
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//********************************************************************************************
//function searchItemCode
//*******************************************************************************************

function searchItemCode(){
 //           alert("searchItemCode");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Item " ;
            var target=this.document.forms[0].item_desc;
            var item_code=this.document.forms[0].item_code;
//			alert("item_code : "+item_code.value);
        
			sql="SELECT XI_ITEM_CODE code,XI_ITEM_DESCRIPTION description FROM XI_ITEM WHERE UPPER(XI_ITEM_CODE) LIKE UPPER(?) AND UPPER(XI_ITEM_DESCRIPTION) LIKE UPPER(?) ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                item_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                item_code.value=tcode;
            }
}// End of searchItemCode

//********************************************************************************************
//function searchOrgID
//*******************************************************************************************

function searchOrgID(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Organization" ;
            var target=this.document.forms[0].org_desc;
//			var org_id = this.document.forms[0].org_id.value;
//			alert("mod id : "+module_id);
            var org_id=this.document.forms[0].org_id;
        
			sql="SELECT distinct XI_ORGANIZATION_ID code,XI_ORGANIZATION_ID description FROM XI_ITEM WHERE UPPER(XI_ORGANIZATION_ID) LIKE UPPER(?) AND UPPER(XI_ORGANIZATION_ID) LIKE UPPER(?) ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
//		    argumentArray[4] = "2,1";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                org_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                org_id.value=tcode;
            }
}// End of searchOrgID

//********************************************************************************************
//function funSubmit
//*******************************************************************************************

function funSubmit()
{
	// #MOD#01

}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

function funModify(obj)
{
	// #MOD#02
//	alert(	"frm Name : "+parent.commontoolbarFrame.document.forms[0].name);
//	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

//	alert("obj : "+obj);
//	alert("fn Mdfy doc_type : "+this.document.forms[0].doc_type.value);
/*    var doc_type	 = this.document.forms[0].doc_type.value;
	this.document.forms[0].doc_no.value = obj.getAttribute('doc_no');
	this.document.forms[0].doc_date.value = obj.getAttribute('doc_date');
	this.document.forms[0].store_from.value = obj.getAttribute('store_from');
	this.document.forms[0].destination.value = obj.getAttribute('destination');
	this.document.forms[0].status.value = obj.getAttribute('status');
	this.document.forms[0].doc_type.value = obj.getAttribute('doc_type');
	doc_type	 = this.document.forms[0].doc_type.value;
	alert("fn Mdfy doc_type : "+doc_type);
	var act = "../../eXI/jsp/QueryTransactionStatusDetailsResult.jsp?doc_type="+doc_type;
	this.document.forms[0].action = act;
	this.document.forms[0].submit(); */
}
//*******************************************************************************************
//function funAction
//*******************************************************************************************

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	funSubmit();
}
//*******************************************************************************************
