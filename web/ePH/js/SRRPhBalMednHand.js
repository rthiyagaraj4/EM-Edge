  //saved on 04/11.2005
function run() {

	var frmObject = f_query_add_mod.document.formPhBalMednHand;
	if(f_query_add_mod.document.formPhBalMednHand) {
	var fields= new Array (frmObject.p_enq_date_from1,frmObject.p_enq_date_to1);
	var names= new Array (getLabel("ePH.DispenseDateFrom.label","ph"),getLabel("Common.todate.label","Common"));
	var fac= f_query_add_mod.document.formPhBalMednHand.p_facility_code.value;

	if(checkFields(fields,names,messageFrame) ) {
	/*if(f_query_add_mod.document.formPhBalMednHand.p_facility_code.value=="")
		f_query_add_mod.document.formPhBalMednHand.p_facility_id.value="";
	else 
		f_query_add_mod.document.formPhBalMednHand.p_facility_id.value=fac;*/

	//f_query_add_mod.document.formPhBalMednHand.p_frdate.value = frmObject.p_enq_date_from.value;
	//f_query_add_mod.document.formPhBalMednHand.p_todate.value = frmObject.p_enq_date_to.value;
	f_query_add_mod.document.formPhBalMednHand.p_drug_from.value = frmObject.drug_code.value;

	if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhBalMednHand.p_enq_date_from1, f_query_add_mod.document.formPhBalMednHand.p_enq_date_to1, messageFrame ) ) {
					var locale = f_query_add_mod.document.formPhBalMednHand.p_language_id.value;
					var P_FRM_DISPN_DATE=convertDate(frmObject.p_enq_date_from1.value,"DMY",locale,"en"); //Added Variables for the incident num:26432==By Sandhya
					var P_TO_DISPN_DATE=convertDate(frmObject.p_enq_date_to1.value,"DMY",locale,"en");
					
	frmObject.p_enq_date_from.value=P_FRM_DISPN_DATE;
	frmObject.p_enq_date_to.value=P_TO_DISPN_DATE;
					f_query_add_mod.document.formPhBalMednHand.submit();
				}
				
			}
		}
}

function reset() {		
	f_query_add_mod.location.reload();  
}



function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	history.go(-1);
}


function validate_date(Obj,ref) {
                

	if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_enq_date_to;
	  to = document.forms[0].p_enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_enq_date_from;
	  to = document.forms[0].p_enq_date_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].p_enq_date_to;
	  to = parent.frames[1].document.forms[0].p_enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
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

function searchDrugName()
{
	var formObj = document.frames.formPhBalMednHand;
	var search_criteria = formObj.drug_med_supply.value
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var lookup_name = getLabel("Common.ItemName.label","Common");
	if (search_criteria == 'Y')
	{
	  argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.language_id.value+"' and DRUG_YN = 'Y'";
	  lookup_name = getLabel("Common.DrugName.label","Common");
	}else if (search_criteria == 'N' )
	{
	   argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.language_id.value+"' and DRUG_YN = 'N'";	  
	}else
	{
	argumentArray[0]   = escape(document.getElementById("sql_ph_drug_search_select").value)+"'"+formObj.language_id.value+"'";
	}
	//alert(argumentArray[0]);
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.drug_name.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 
	retVal = CommonLookup(lookup_name, argumentArray );

	if(retVal != null && retVal != "" )  
	{
		formObj.drug_name.value = retVal[1] ;
		formObj.drug_code.value = retVal[0];
		
		formObj.drug_name.disabled  = true;
		formObj.drug_name_search.disabled = true;
		
	}
}

function callCriteriaChange(){
var formObj = document.frames.formPhBalMednHand;
formObj.drug_name.disabled  = false;
formObj.drug_name_search.disabled = false;
formObj.drug_name.value = '' ;
formObj.drug_code.value ='';

}

function populateDispLocs(obj, language_id)
{
	var formObj =document.formPhBalMednHand;
	var facility_id = obj.value;	
	var bean_id		= "SRRPHRepDispStatisByDispBean" ; ;
	var bean_name	= "ePH.SRRPHRepDispStatisByDispBean" ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateDispLocs"+"&facility_id="+facility_id+"&locale="+language_id.value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}

function clearList(){
	
	var disp_loc_len =document.formPhBalMednHand.p_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formPhBalMednHand.p_disp_locn.remove("p_disp_locn") ;
	}
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.defaultSelect.label","Common")+"--";
	//opt.text = desc ;
	opt.text = decodeURIComponent(desc,"UTF-8") ; 
	opt.value = code ;	
	document.formPhBalMednHand.p_disp_locn.add(opt);

}
