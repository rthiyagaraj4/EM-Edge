function callPatientLookup(){
	var formObj = parent.f_query_add_mod.document.forms[0];
	var patient_id = PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.patient_id.value = patient_id;
		formObj.patient_id.focus();
     }
}	

function CheckForSpecCharsforID(event){
		var strCheck = '0123456789';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}	
	
	function showResult()
	{
			var formObj = parent.f_query_add_mod.document.forms[0];
		   	var adr_reported_date_from="";
	var adr_reported_date_to ="";						   					 
	var locale = formObj.p_language_id.value;
	var doc_type_code=formObj.doc_type_code.value;
	var patient_id = formObj.patient_id.value;
	adr_reported_date_from = formObj.p_disp_date_from.value;				 
	adr_reported_date_from=convertDate(adr_reported_date_from,"DMY",locale); 
	adr_reported_date_to = formObj.p_disp_date_to.value;
	adr_reported_date_to=convertDate(adr_reported_date_to,"DMY",locale); 	 	 
	var sale_doc_no_from = formObj.sale_doc_no_from.value;
	var sale_doc_no_to = formObj.sale_doc_no_to.value;
	var store_code = formObj.store.value;

	var selectIndex=formObj.store.options.selectedIndex;
	var store_desc=formObj.store.options[selectIndex].text;


		var fields = new Array (formObj.p_disp_date_from,formObj.p_disp_date_to,formObj.store);
	var names= new Array (getLabel("Common.DateFrom.label","Common"),getLabel("Common.DateTo.label","Common"),getLabel("Common.Store.label","Common"));
	if(checkFields(fields,names,parent.messageFrame)) 																																															  
	{
			parent.f_query_results.location.href="../../eST/jsp/SRRMedicationListReportQueryCriteriaResult.jsp?patient_id="+patient_id+"&locale="+locale+"&adr_reported_date_from="+adr_reported_date_from+"&adr_reported_date_to="+adr_reported_date_to+"&doc_type_code="+doc_type_code+"&sale_doc_no_from="+sale_doc_no_from+"&sale_doc_no_to="+sale_doc_no_to+"&store_code="+store_code+"&store_desc="+store_desc;	    
		    parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";	 																																																			  
												 
	}																					 
							 																																																															  
	}	
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
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

                to.select();
                to.focus();

                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;							  
}
	function validate_date(Obj,ref) {
                
	if (CheckDate1(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_disp_date_from;
	  to = document.forms[0].p_disp_date_to;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');

	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');

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
			parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

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
function CheckDate1(Object2,focusflag) {

	 var datefield = Object2;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}


    if (ChkDate(Object2) == false) {
        alert(getMessage("INVALID_DATE_FMT", "SM"));
		parent.f_query_results.document.location.href='../../eCommon/html/blank.html';

        if (datefield.value != undefined && focusflag == null)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
} 

function isAfterCurrDate(obj)
{		  
	var date = obj.value;
		

	if(isValidDate(obj) && date.length > 0 )    
	{
		if(!isBeforeNow(date,'DMY',"en"))							    
		{
			alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + getMessage("NOT_LESS_THAN_SYSDATE", "ST");
			  obj.value = "";
			//obj.focus();
			return false;
		}  													   
	}
}
	  function isValidDate(obj)
{	
	var date = obj.value;

	
	if(date.length > 0 )
	{
		if(!validDate(date,'DMY',"en"))
		{
			obj.value = "";
			return false;
		}												  
		else
		{
			return true;
		}
	}				   
}
						  

function numberValidation(from_no,to_no)
{
	if(parseInt(from_no.value)>parseInt(to_no.value))
	{
		var msg=getMessage("LESS_OR_EQUAL_VALIDATE", "ST").replace(/@/g,"Doc.No");
		alert(msg); 
		to_no.value="";
	}
}	
function enableCheck(obj)
{
	if(obj.checked)
	{
	  obj.value="Y";
	}
	else
	{
	   obj.value="N";
	}
	
}

function selectAllCheck(obj,cou)
{
	 	   if(obj.checked)
	{
	   obj.value="Y";
	  // document.getElementById(cou+"selectYN").value="Y";
		document.forms[0].selectYN.value="Y";
	}						 
	else										    
	{
	    obj.value="N";
	 //document.getElementById(cou+"selectYN").value="N";	
	  document.forms[0].selectYN.value="N";   	  
	}
	document.forms[0].rule.value ="N";		  	  
	document.forms[0].action_type.value ="R";
	var act = '../../eST/jsp/SRRMedicationListReportQueryCriteriaResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target='';	     
	this.document.forms[0].submit();    
			
}		
//********************************************************************************************
//function funAction
//**********************************************************************************************
function funAction(type)
{

  if(type=="N")
 {
   document.forms[0].pageCount.value=parseInt(document.forms[0].pageCount.value)+1;
 }
 else
{
  document.forms[0].pageCount.value=parseInt(document.forms[0].pageCount.value)-1;
}

	funSubmit(type);  
}																				 

//***********************************************************************************************
function funSubmit(type)
{
	 document.forms[0].action_type.value = type; 
	 var page=document.forms[0].pageCount.value;		  
	/*	   if(document.forms[0].selectAll.checked)			    
	{
	   document.forms[0].selectAll.value="Y";
	   document.forms[0].selectYN.value="Y";								 
	   
	  //document.getElementById(page+"selectYN").value="Y";

	}						 				 		  				   
	else										   
	{
	    document.forms[0].selectAll.value="N";
		document.forms[0].selectYN.value="N";	
		// document.getElementById(page+"selectYN").value="N";
	}	 		*/


		 
	 document.forms[0].rule.value ="Y";	  
	var act = '../../eST/jsp/SRRMedicationListReportQueryCriteriaResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target='';	    
	this.document.forms[0].submit();	  
}
																		 
	function showPrint(facility_id){

	headerObj=parent.f_query_results.document.forms[0];

	var allElements = headerObj.elements;
	var cnt = 0;			 
	   	headerObj=parent.f_query_results.document.forms[0];

	var allElements = headerObj.elements;
	var cnt = 0;
	/*for (i = 1; i < allElements.length; i++) {
		if (allElements[i].type == "checkbox") {
			objName = allElements[i].name;	
			if (allElements[i].checked)
			{
				cnt++;
			}
		 }
		}
																				  
	if (cnt == 0)  
	{
	 var Msg=getMessage("ST_NO_RECORDS_FOR_PRINT",'ST');
	 //alert("APP-ST593 No records are selected for print");
	 alert(Msg);
	 return false;
	}  						 
		 */
		/* bean_id="";
		 bean_name="";
	mode="PRINT_FOR_CERTIFREIMBURSEMENT";
 	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
//	xmlStr += " record_cnt=\""+record_cnt+"\"";					 
//	xmlStr += " checked_yn=\""+checked_yn+"\"";
	xmlStr += " mode=\""+mode+"\"";	
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","SRRMedicationListReportValidate.jsp?validate=RECORDS_FOR_MEDICATIONLIST",false);
	xmlHttp.send(xmlDoc);
		alert(xmlHttp.responseText);
	eval(xmlHttp.responseText); */       
	parent.f_query_results.document.forms[0].action_type.value ="R";
	var act = '../../eST/jsp/SRRMedicationListReportValidate.jsp';
	parent.f_query_results.document.forms[0].action = act;
	parent.f_query_results.document.forms[0].target='messageFrame';	    
	//duplicateFrame
	parent.f_query_results.document.forms[0].submit(); 
}														  


function funCheck(obj)
{
  	document.forms[0].P_DOC_DATE.value=obj.getAttribute("doc_date");  
	document.forms[0].P_DOC_NO.value=obj.getAttribute("doc_no");   
	document.forms[0].P_STORE_CODE.value=obj.getAttribute("store_code");
	
	var doc_valid=obj.getAttribute("doc_valid_code");		    
	 //if(document.getElementById(doc_valid+"chk").checked)  		 
	//{
	  document.forms[0].submit();			    
	//}
	 //else													   
	//{
	//	 alert(getMessage("ATLEAST_ONE_SELECTED", "common"));  	   
	//}

	  							  			   
}			

function reset() {			  
	f_query_add_mod.document.forms[0].reset();
	f_query_results.document.location.href='../../eCommon/html/blank.html';
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}											 										  
