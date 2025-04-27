
//********************************************************************************************
//function searchStoreCode
//*******************************************************************************************
function reset(){
	const formObj = f_query_add_mod.document.forms[0] ;
	
	if(formObj){
		formObj.reset() ;
	}
}
async function searchStoreCode(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.Store.label",'Common');
            var target=this.document.forms[0].store_desc;
            var store_code=this.document.forms[0].store_code;
        
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

//********************************************************************************************
//function searchOrgID
//*******************************************************************************************

async function searchOrgID(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.Organization.label",'Common');
            var target=this.document.forms[0].org_desc;
            var org_id=this.document.forms[0].org_id;
        
			sql="SELECT distinct XI_ORGANIZATION_ID code,XI_ORGANIZATION_ID description FROM XI_ITEM WHERE UPPER(XI_ORGANIZATION_ID) LIKE UPPER(?) AND UPPER(XI_ORGANIZATION_ID) LIKE UPPER(?) ORDER BY 1 ";

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
                org_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                org_id.value=tcode;
            }
}// End of searchOrgID

//********************************************************************************************
//function run
//********************************************************************************************
function run() 
{
	//alert("run");
	//alert(f_query_add_mod.document.forms[0].name);

	var view_by = f_query_add_mod.document.forms[0].view_by.value;
	
	if(view_by=='SC'){
		f_query_add_mod.document.forms[0].p_report_id.value = 'XIREQBST';
	}
	else if(view_by=='RO'){
//		alert("RO");
		f_query_add_mod.document.forms[0].p_report_id.value = 'XIREQBOR';
//		f_query_add_mod.document.forms[0].p_report_id.value = 'XIEXCSUD';		
	}
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.forms[0].submit() ;
	
}
//********************************************************************************************
//function sysDateCheck
//********************************************************************************************
function sysDateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                //to.select();
                //to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
//********************************************************************************************
//function validate_date
//********************************************************************************************
function validate_date(Obj,ref) {
                
//	var formObj = document.frames.f_query_add_mod.f_query_criteria.queryPatientDrugProfileCriteria;
//var formObj = document.frames.repRequisitionsSumm;
	var formObj = document.getElementById('repRequisitionsSumm');
	if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = formObj.dt_to;
	  to = formObj.dt_from;
	  error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");  
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = formObj.dt_from;
	  to = formObj.dt_to;
	  error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH"); 
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
//	  from = parent.frames[1].formObj.dt_to;
//	  to = parent.frames[1].formObj.dt_from;
		from = formObj.dt_to;
		to = formObj.dt_from;
		error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			from.value="";
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
}
//********************************************************************************************
//function searchItemCode
//********************************************************************************************
async function searchItemCode(){
 //           alert("searchItemCode");
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.item.label",'Common');
            var target=this.document.forms[0].itemcode_desc;
            var item_code=this.document.forms[0].itemcode_txt;
//			alert("item_code : "+item_code.value);
        
			sql="SELECT XI_ITEM_CODE code,XI_ITEM_DESCRIPTION description FROM XI_ITEM WHERE UPPER(XI_ITEM_CODE) LIKE UPPER(?) AND UPPER(XI_ITEM_DESCRIPTION) LIKE UPPER(?) ORDER BY 1 ";
//			sql="SELECT ITEM_CODE code,ITEM_DESCRIPTION description FROM XI_QRY_ORG_ITM_STATUS WHERE UPPER(ITEM_CODE) LIKE UPPER(?) AND UPPER(ITEM_DESCRIPTION) LIKE UPPER(?) ORDER BY 1 ";
			

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
