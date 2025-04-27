
//****************************************************************************************
//function searchStoreCode
//****************************************************************************************

async function searchStoreCode(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.Store.label",'Common');
            var target=this.document.forms[0].p_store_desc;
            var store_code=this.document.forms[0].p_store_code;
        
			sql="SELECT distinct a.STORE_CODE code,b.SHORT_DESC description FROM XI_ITEM a,MM_STORE b WHERE a.STORE_CODE=b.STORE_CODE AND UPPER(a.STORE_CODE) LIKE UPPER(?) AND UPPER(b.SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";
			
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
         
            retVal = await CommonLookup( tit, argumentArray );
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                store_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                store_code.value=tcode;
            }
}// End of searchStoreCode

//****************************************************************************************
//function searchItemCode
//****************************************************************************************

async function searchItemCode(){
  			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Item " ;
            var target=this.document.forms[0].p_item_desc;
            var item_code=this.document.forms[0].p_item_code;
			
			sql="SELECT distinct XI_ITEM_CODE code,XI_ITEM_DESCRIPTION description FROM XI_ITEM WHERE UPPER(XI_ITEM_CODE) LIKE UPPER(?) AND UPPER(XI_ITEM_DESCRIPTION) LIKE UPPER(?) ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
		    argumentArray[4] = "1,2";
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

//****************************************************************************************
//function searchItemClass
//****************************************************************************************

async function searchItemClass(){
 //           alert("searchItemCode");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="ItemClass" ;
            var target=this.document.forms[0].p_itemclass_desc;
            var itemclass_code=this.document.forms[0].p_itemclass_code;

			sql="SELECT distinct A.ITEM_CLASS_CODE code,B.SHORT_DESC description FROM XI_ITEM A,MM_ITEM_CLASS B WHERE A.ITEM_CLASS_CODE=B.ITEM_CLASS_CODE AND UPPER(A.ITEM_CLASS_CODE) LIKE UPPER(?) AND UPPER(B.SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";			

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
                itemclass_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                itemclass_code.value=tcode;
            }
}// End of searchItemClass
//****************************************************************************************
//function run
//****************************************************************************************

function run() 
{
//	alert("report_id : "+f_query_add_mod.document.forms[0].p_report_id.value);
	f_query_add_mod.document.forms[0].submit() ;
}

