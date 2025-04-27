
//********************************************************************************************
//function searchStoreCode
//*******************************************************************************************

function searchStoreCode(){
     
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
        
			sql="SELECT a.STORE_CODE code,b.SHORT_DESC description FROM XI_ITEM a,MM_STORE b WHERE a.STORE_CODE=b.STORE_CODE AND UPPER(a.STORE_CODE) LIKE UPPER(?) AND UPPER(b.SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";
			
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

function searchOrgID(){
     
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
//*******************************************************************************************

function run() 
{
//	alert("run");
//	alert(window.f_query_add_mod.document.forms[0].name);

	var sum_status = f_query_add_mod.document.forms[0].req_status.value;
	var rep_type = f_query_add_mod.document.forms[0].report_type.value;
	if(rep_type=='S'){
		f_query_add_mod.document.forms[0].p_report_id.value = 'XIRECSUS';
	}
	else if( rep_type=='D'){
		f_query_add_mod.document.forms[0].p_report_id.value = 'XIRECSUD';
	}
	else{
		f_query_add_mod.document.forms[0].p_report_id.value = 'XIRECSUS';
	}
//	alert("report_id : "+f_query_add_mod.document.forms[0].p_report_id.value);
	f_query_add_mod.document.forms[0].submit() ;

//	window.f_query_add_mod.document.repGoodsReceipts.submit() ;
}

//********************************************************************************************
//function validate_date
//*******************************************************************************************

function validate_date(Obj,ref) {                

	if (CheckDate(Obj))
	{
		
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].from_date;
	  to = document.forms[0].to_date;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].from_date;
	  to = document.forms[0].to_date;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else	
	if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].from_date;
	  to = parent.frames[1].document.forms[0].to_date;
  	  error_id = getMessage('XH1009','XH');
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
		if(Date.parse(fromdt) > Date.parse(todt)) {		   
			alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(fromdt) <= Date.parse(todt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
}

//********************************************************************************************
//function DateCheck
//*******************************************************************************************

function DateCheck(from,to) {

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
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
