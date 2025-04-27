
//*********************************************************************************
//FUNCTION RESET 
//*********************************************************************************
function reset()
{
//	alert("QueryTransaction reset");
	window.frames[1].document.forms[0].reset();
}

//********************************************************************************************
//function searchStoreCode
//*******************************************************************************************

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
//function searchItemCode
//*******************************************************************************************

async function searchItemCode(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.item.label",'Common');
            var target=this.document.forms[0].item_desc;
            var item_code=this.document.forms[0].item_code;
//			alert("item_code : "+item_code.value);
        
			sql="SELECT distinct XI_ITEM_CODE code,XI_ITEM_DESCRIPTION description FROM XI_ITEM WHERE UPPER(XI_ITEM_CODE) LIKE UPPER(?) AND UPPER(XI_ITEM_DESCRIPTION) LIKE UPPER(?) ORDER BY 1 ";

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
//function searchFinalizedBy
//*******************************************************************************************

async function searchFinalizedBy(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("eXI.FinalizedBy.Label",'XI');
            var target=this.document.forms[0].finalized_by_desc;
            var finalized_by_id=this.document.forms[0].finalized_by_id;
        
			sql="SELECT APPL_USER_ID code,APPL_USER_NAME description FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) ORDER BY 1 ";

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
                finalized_by_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                finalized_by_id.value=tcode;
            }
}// End of searchFinalizedBy

//********************************************************************************************
//function searchEnteredBy
//*******************************************************************************************

async function searchEnteredBy(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
			var tit	= getLabel("Common.EnteredBy.label",'Common');
            var target=this.document.forms[0].entered_by_desc;
//			var org_id = this.document.forms[0].org_id.value;
//			alert("mod id : "+module_id);
            var entered_by_id=this.document.forms[0].entered_by_id;
        
			sql="SELECT APPL_USER_ID code,APPL_USER_NAME description FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) ORDER BY 1 ";

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
                entered_by_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                entered_by_id.value=tcode;
            }
}// End of searchEnteredBy

//********************************************************************************************
//function funSearch
//*******************************************************************************************
function funSearch()
{
	parent.QueryTransactionframeset.rows="30,120,260,30";
//	alert("doc_type : "+this.document.forms[0].doc_type.value);
	var doc_type = this.document.forms[0].doc_type.value;
	var status		 = this.document.forms[0].status.value;
//	alert("status : "+status);
	var store_code	 = this.document.forms[0].store_code.value;
	var item_code	 = this.document.forms[0].item_code.value;
	var org_id	 = this.document.forms[0].org_id.value;
	var doc_no	 = this.document.forms[0].doc_no.value;		
	var from_date	 = this.document.forms[0].from_date.value;
	var to_date		 = this.document.forms[0].to_date.value;
	var finalized_by_id	 = this.document.forms[0].finalized_by_id.value;
	var entered_by_id		 = this.document.forms[0].entered_by_id.value;
	
    var param = 		"doc_type="+doc_type+"&status="+status+"&store_code="+store_code+"&item_code="+item_code+"&org_id="+org_id+"&doc_no="+doc_no+"&from_date="+from_date+"&to_date="+to_date+"&finalized_by_id="+finalized_by_id+"&entered_by_id="+entered_by_id;
	parent.f_query_add_mod_detail.location.href="../../eXI/jsp/QueryTransactionStatusSearchResult.jsp?"+param;
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

//********************************************************************************************
//function changeStatus
//*******************************************************************************************
function changeStatus(obj){
//	alert("changeStatus");
	var status_obj	=	document.forms[0].status;
	var statuslen		=	status_obj.options.length;
	var i;
	for(i=statuslen-1;i>=0;i--) {
		status_obj.remove(i);
	}

    var selectLbl = getLabel("Common.defaultSelect.label",'Common');
    var dfltSelect = "----------"+selectLbl+"----------";
	var codeArr = new Array('','P','A','X','R','NPI');
	//	var descArr =  new Array('----------Select----------','Finalized','Entered','Approved','Unapproved/Cancelled','Received','Not Processed By IBA','Not Processed By Ext System');
	var descArr =  new Array(dfltSelect,getLabel("Common.Finalized.label",'Common'),getLabel("Common.Approved.label",'Common'),getLabel("eXI.UnapprOrCancel.Label",'Common'),getLabel("Common.received.label",'Common'),getLabel("eXI.NotProcByIBA.Label",'Common'));
	
	var codeArr1 = new Array('','NPI','U','P');
	var descArr1 =  new Array(dfltSelect,getLabel("eXI.NotProcByIBA.Label",'Common'),getLabel("Common.Entered.label",'Common'),getLabel("Common.Finalized.label",'Common'));

	var codeArr2 = new Array('','U','NPE','P');
	var descArr2 =  new Array(dfltSelect,getLabel("Common.Entered.label",'Common'),getLabel("eXI.NotProcByExtSys.Label",'Common'),getLabel("Common.Finalized.label",'Common'));

	var element = "";

	if(obj.value=='RP'){
	for(j=0;j<codeArr.length;j++){
		element = document.createElement('OPTION') ;
		element.value		=  codeArr[j] ;
		element.text		    = descArr[j] ;
		status_obj.add(element);
	}
	}
	else if(obj.value=='GRO' || obj.value=='GR' ){
	for(j=0;j<codeArr1.length;j++){
		element = document.createElement('OPTION') ;
		element.value		=  codeArr1[j] ;
		element.text		    = descArr1[j] ;
		status_obj.add(element);
	}
	}
	else if(obj.value=='GRNR' || obj.value=='NR' ){ 
	for(j=0;j<codeArr2.length;j++){
		element = document.createElement('OPTION') ;
		element.value		=  codeArr2[j] ;
		element.text		    = descArr2[j] ;
		status_obj.add(element);
	}
	}

//	alert("status_obj len : "+status_obj.options.length)

/*	if(obj.value=='RP'){
		status_obj.remove(6) ;
		status_obj.remove(1) ;
//		status_obj.remove(0) ;
	}
	else if(obj.value=='GRO' || obj.value=='GR' ){
		status_obj.remove(7) ;
		status_obj.remove(5) ;
		status_obj.remove(4) ;
		status_obj.remove(3) ;
//		status_obj.remove(0) ;
	}
	else if(obj.value=='GRNR' || obj.value=='NR' ){
		status_obj.remove(6) ;
		status_obj.remove(5) ;
		status_obj.remove(4) ;
		status_obj.remove(3) ;
//		status_obj.remove(0) ;
	} */
	parent.f_query_add_mod_detail.location.href="../../eCommon/html/blank.html";
}// End of changeStatus

//********************************************************************************************
//function funSubmit
//*******************************************************************************************

function funSubmit()
{
	// #MOD#01
	var act = '../../eXI/jsp/QueryTransactionStatusSearchResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();

}
//*******************************************************************************************
//function funModify
//*******************************************************************************************

async function funModify(obj)
{
	// #MOD#02
//	alert(	"frm Name : "+parent.commontoolbarFrame.document.forms[0].name);
//	parent.commontoolbarFrame.document.forms[0].apply.style.display='block';

//	alert("obj : "+obj);
//	alert("fn Mdfy doc_type1 : "+this.document.forms[0].doc_type1.value);
    var doc_type1	 = this.document.forms[0].doc_type1.value;
		    var store_code	 = this.document.forms[0].store_code.value;
		    var item_code	 = this.document.forms[0].item_code.value;
		    var finalized_by_id	 = this.document.forms[0].finalized_by_id.value;
		    var entered_by_id	 = this.document.forms[0].entered_by_id.value;		
		    var from_date	 = this.document.forms[0].from_date.value;
		    var to_date	 = this.document.forms[0].to_date.value;			


	var doc_no		 = obj.getAttribute('doc_no');
//		alert("doc_no : "+obj.getAttribute('doc_no'));
	this.document.forms[0].doc_no.value = obj.getAttribute('doc_no');
	this.document.forms[0].doc_date.value = obj.getAttribute('doc_date');
	this.document.forms[0].store_from.value = obj.getAttribute('store_from');
	this.document.forms[0].destination.value = obj.getAttribute('destination');
	this.document.forms[0].p_status.value = obj.getAttribute('p_status');
//	alert("p_status : "+obj.getAttribute('p_status'));
	this.document.forms[0].doc_type.value = obj.getAttribute('doc_type');
	doc_type	 = this.document.forms[0].doc_type.value;
    var doc_date = 	this.document.forms[0].doc_date.value;
    var p_status = 	this.document.forms[0].p_status.value;
			var url     = "../../eXI/jsp/QueryTransactionStatusDetailsResult.jsp?doc_type1="+doc_type1+"&doc_type="+doc_type+"&doc_no="+doc_no+"&store_code="+store_code+"&item_code="+item_code+"&finalized_by_id="+finalized_by_id+"&entered_by_id="+entered_by_id+"&doc_date="+doc_date+"&from_date="+from_date+"&to_date="+to_date+"&p_status="+p_status;
			/*var dialogTop   = "65";
			var dialogHeight= "44" ;
			var dialogWidth = "65" ;*/

			var dialogTop   = "340";
			var dialogHeight= "20" ;
			var dialogWidth = "65" ;
			var arguments   = "" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	        var returnval =await window.showModalDialog( url, arguments, features ) ;
	//	}
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
                // commented to avoid infinite alerts popping
//                to.select();
//                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
