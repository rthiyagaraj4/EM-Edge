 //saved on 02.11.2005
function run() {
		var frmObject = f_query_add_mod.document.formPhPresPatternCriteria;
	//	var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value+"'"+frmObject.language_id.value+"'";
		//frmObject.sql_ph_medn_stat_pract_select1.value="";
		var check='1';
	//alert("=locn_type==="+frmObject.locn_type.value+"=====");
	if(frmObject.locn_type.disabled){
		check='2';
		frmObject.locn_type.disabled=false;
	}
	f_query_add_mod.document.formPhPresPatternCriteria.dt_from.value = convertDate(f_query_add_mod.document.formPhPresPatternCriteria.dt_from1.value,'DMY',f_query_add_mod.document.formPhPresPatternCriteria.p_language_id.value,'en'); // Added for TTM-SCF-0149 [IN:060026]
	f_query_add_mod.document.formPhPresPatternCriteria.dt_to.value = convertDate(f_query_add_mod.document.formPhPresPatternCriteria.dt_to1.value,'DMY',f_query_add_mod.document.formPhPresPatternCriteria.p_language_id.value,'en');	// Added for TTM-SCF-0149 [IN:060026]
		frmObject.p_locn_type.value = frmObject.locn_type.value;
	//	alert("=p_locn_type==="+frmObject.p_locn_type.value+"=====");
		if(f_query_add_mod.document.formPhPresPatternCriteria) {
			var fields= new Array (frmObject.dt_from,frmObject.dt_to,frmObject.p_select_by,frmObject.p_order_by);
			var names= new Array (getLabel("ePH.OrderDateTimeFrom.label","PH"),getLabel("Common.to.label","Common"), getLabel("ePH.SelectBy.label","PH"),getLabel("Common.orderBy.label","Common"));
			if(checkFields(fields,names,messageFrame) ) {
				if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhPresPatternCriteria.dt_from, f_query_add_mod.document.formPhPresPatternCriteria.dt_to, messageFrame ) ) {
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.formPhPresPatternCriteria.submit();
								
				}
			}
		}
		//frmObject.sql_ph_medn_stat_pract_select1.value = temp_qry_1;
		if(check=='2')
		frmObject.locn_type.disabled=true;
	}

// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formPhPresPatternCriteria.p_language_id.value;
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}

	function reset() {
		f_query_add_mod.formPhPresPatternCriteria.reset();
		f_query_add_mod.formPhPresPatternCriteria.drug_search.disabled=true;
		if(f_query_add_mod.formPhPresPatternCriteria.locn_type.disabled==true)
			f_query_add_mod.formPhPresPatternCriteria.locn_type.disabled=false;
		f_query_add_mod.formPhPresPatternCriteria.p_facility_code.focus();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}



	/*function callDrugSearch(obj,mode) {
		var arrCodeDesc = DrugSearch("D",obj);
		alert("stringreturn"+ arrCodeDesc);
		if(arrCodeDesc != null && arrCodeDesc != "" ) {
			if (mode == 1)	
				f_query_add_mod.document.formPhDrugUsageByPractCriteria.drug_code.value = arrCodeDesc[0];
			else if (mode == 2)	
				f_query_add_mod.document.formPhDrugUsageByPractCriteria.tdrug_code.value = arrCodeDesc[0];
			alert(arrCodeDesc[0]); 	
		//	document.formPhDrugUsageByPractCriteria.drug_code.value	=	arrCodeDesc[0];
			obj.value =	arrCodeDesc[1];
			alert(arrCodeDesc[1]);
		}
	} */


	async function callDrugSearch(obj) {
		var arrCodeDesc = await DrugSearch("D",obj);
		if(arrCodeDesc != null && arrCodeDesc != "" ) {
			document.formPhPresPatternCriteria.dyn_code.value = arrCodeDesc[0];
			obj.value =	arrCodeDesc[1];
		}
	}


	function changeLegend(obj)
	{  
			clearList();
			if (obj.value == "PT")
				{	
				
					document.getElementById("PR").innerText="Practitioner";
					formPhPresPatternCriteria.drug_search.disabled=false;
					formPhPresPatternCriteria.dyn_name.value="";
					addList();
				}
			
			else if (obj.value == "DR")
				{	document.getElementById("PR").innerText="Drug";
					formPhPresPatternCriteria.drug_search.disabled=false;
					formPhPresPatternCriteria.dyn_name.value="";
					addList();
				}
			else{
				formPhPresPatternCriteria.dyn_name.value
			}

	//	formPhPresPatternCriteria.drug_search.disabled=true;

		}

	function callFunc(target)
	{ 
		if (formPhPresPatternCriteria.p_select_by.value=="PT")	
		{
		searchPractitionerName(document.formPhPresPatternCriteria.dyn_name);

		}
	  else
		if (formPhPresPatternCriteria.p_select_by.value=="DR")	
		  { 
		   callDrugSearch(document.formPhPresPatternCriteria.dyn_name);
		  }

	}


async function searchPractitionerName(target) {

		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;

			
			var temp='';
		dataNameArray[0]="p_user_name";
		dataValueArray[0]=document.formPhPresPatternCriteria.p_user_name.value;
		dataTypeArray[0]=STRING;
		dataNameArray[1]="p_facility_id";
		dataValueArray[1]=document.formPhPresPatternCriteria.p_facility_id.value;
		dataTypeArray[1]=STRING;
		dataNameArray[2]="p_facility_id";
		dataValueArray[2]=document.formPhPresPatternCriteria.p_facility_id.value;
		dataTypeArray[2]=STRING;
		dataNameArray[3]="p_locn_type";
		dataValueArray[3]=document.formPhPresPatternCriteria.p_locn_type.value;
		dataTypeArray[3]=STRING;
		
		argumentArray[0] = escape(document.getElementById("sql_ph_medn_stat_pract_select1").value)+"'"+document.formPhPresPatternCriteria.language_id.value+"'";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "5,6";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = DESC_CODE ;

		retArray = await CommonLookup(getLabel("Common.SearchCriteria.label","Common"), argumentArray );
		var ret1=unescape(retArray);
	 	arr=ret1.split(",");
		if(retArray != null && retArray != "") {
			formPhPresPatternCriteria.dyn_name.value = arr[1];
			formPhPresPatternCriteria.dyn_code.value = arr[0];
		}
	}



	function GoBack() {
		alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
		history.go(-1);
	}


	function clearList()	{
		var len =formPhPresPatternCriteria.p_order_by.options.length;
			for(var i=0;i<len;i++) {
				formPhPresPatternCriteria.p_order_by.remove("p_order_by") ;
			}

			var tp = "   --- Select ---   " ;
			var opt = document.createElement("OPTION") ;
			opt.text = tp ;
			opt.value = "" ;
			formPhPresPatternCriteria.p_order_by.add(opt);
	}

	function addList()	{
			var element = document.createElement('OPTION') ;
			
			if (formPhPresPatternCriteria.p_select_by.value=="PT")
			{	
				element.value		= "DG";
				element.text		= "Drug";
				formPhPresPatternCriteria.p_order_by.add(element);
			
				element = document.createElement('OPTION') ;
				element.value		= "UP" ;
				element.text		= "Usage Percent" ;
				formPhPresPatternCriteria.p_order_by.add(element);
			}
			else
			{	element.value		= "PR";
				element.text		= "Practitioner";
				formPhPresPatternCriteria.p_order_by.add(element);

				element = document.createElement('OPTION') ;
				element.value		= "UP" ;
				element.text		= "Usage Percent" ;
				formPhPresPatternCriteria.p_order_by.add(element);
			}
	//		formPhPresPatternCriteria.p_order_by.add(element);
	}




	function disableLocation(val)
	{

		if (val=="")
		{
			f_query_add_mod.document.formPhPresPatternCriteria.query_search.disabled=true;
			formPhPresPatternCriteria.dyn_name.value="";
			
		}
		else
		{
			f_query_add_mod.document.formPhPresPatternCriteria.query_search.disabled=false;
			formPhPresPatternCriteria.dyn_name.value="";
		}
		

	}

function callLocation(obj){
//alert(obj.value);
	formPhPresPatternCriteria.p_locn_type.value= obj.value;
//	alert(formPhPresPatternCriteria.p_locn_type.value);
}

function enableLocation(Obj){
	if(Obj.value==""){
		formPhPresPatternCriteria.locn_type.value="";
		formPhPresPatternCriteria.locn_type.selectedIndex=0;
		formPhPresPatternCriteria.locn_type.disabled=true;

	}
	else{
		formPhPresPatternCriteria.locn_type.disabled=false;
	}
}



function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].dt_to;
	  to = document.forms[0].dt_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].dt_from;
	  to = document.forms[0].dt_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE',"PH");
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].dt_to;
	  to = parent.frames[1].document.forms[0].dt_from;
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
}*/
//========================================================================================================
		if(document.forms[0].dt_from1.value=='' || document.forms[0].dt_to1.value=='')
		{ 
					return false;
		}
		else{
				if(!isBefore(document.forms[0].dt_from1.value,document.forms[0].dt_to1.value,"DMY",document.forms[0].language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
				}
			

		}
	return true;
//========================================================================================================
}


function DateCheck(from,to) {

    /*var fromarray;
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
    }*/
	//==============================================================================================
	if(from.value=="" || to.value=="")
	{ 
		
		return false;
	}
	else{
		
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
//====================================================================================================
    return true;
}

