/*function reset() {
	f_query_add_mod.location.reload();
	f_query_results.location.reload();

		//f_query_add_mod.document.forms[0].reset();
		//f_query_results.document.location.href="../../eCommon/html/blank.html"
	    messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}*/
function reset() {
	f_query_add_mod.SRRPhFillListbyNursingUnitCriteriaForm.reset();
    f_query_results.location.href	="../../eCommon/html/blank.html";
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function resetLocation(){
	var formObj = document.frames.SRRPhFillListbyNursingUnitCriteriaForm;
	formObj.locn_code.value="";
}

function locationLookup(target){
	var formObj = document.frames.SRRPhFillListbyNursingUnitCriteriaForm;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;

			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(document.getElementById("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1").value)+"'"+formObj.language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( "", argumentArray );
			if(retVal != null && retVal != "" )  {
				formObj.locn_code.value=retVal[0];
				target.value = retVal[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
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
	if(from.value=="" || to.value=="")
	{ 
		//alert("1");
		return false;
	}
	else{
		if(!isBefore(to.value,from.value,"DMY",document.forms[0].language_id.value)) {
		
			
		var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
		alert(errors);
		return false;
	}
	}
    return true;
}
function validate_date(Obj,ref) {
                

	/*if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.forms[0].p_fill_proc_to_dt;
	  to = document.forms[0].p_fill_proc_fr_dt;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.forms[0].p_fill_proc_fr_dt;
	  to = document.forms[0].p_fill_proc_to_dt;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = document.forms[0].p_fill_proc_to_dt;
	  to = document.forms[0].p_fill_proc_fr_dt;
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
//alert("document.forms[0].p_fill_proc_fr_dt.value======138===>" +document.forms[0].p_fill_proc_fr_dt.value);

	if(document.forms[0].p_fill_proc_fr_dt.value=='' || document.forms[0].p_fill_proc_to_dt.value=='')
{ 
					return false;
}
	else{
		if(!isBefore(document.forms[0].p_fill_proc_fr_dt.value,document.forms[0].p_fill_proc_to_dt.value,"DMY",document.forms[0].language_id.value)) {
			
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			
				alert(errors);
				return false;
	}
			

}

	return true;
}


function resetNursingBuilding(){
	var select = document.forms[0].p_select.value;
	if(select == "N")
	{
			
		
	 document.forms[0].p_build.disabled = true;
	 document.forms[0].p_build.value = "";
	 document.forms[0].btnnur.disabled = false;
	 document.forms[0].p_fr_nurs_unit.disabled = false;
	 document.forms[0].p_to_nurs_unit.disabled = false;
	 
	 document.forms[0].btntonurs.disabled = false;
	}
else if(select == "L")
	{
		
	 document.forms[0].p_build.disabled = false;
	 document.forms[0].btnnur.disabled = true;
     document.forms[0].p_fr_nurs_unit.disabled = true;
	 document.forms[0].p_to_nurs_unit.disabled = true;
	 document.forms[0].p_fr_nurs_unit.value = "";
	 document.forms[0].p_to_nurs_unit.value = "";
	 document.forms[0].btntonurs.disabled = true;
	}
	else{

		document.forms[0].p_build.value = "";
		
		document.forms[0].p_fr_nurs_unit.value = "";
		 document.forms[0].p_to_nurs_unit.value = "";
		 document.forms[0].p_fr_nurs_unit.disabled = true;
	 document.forms[0].p_to_nurs_unit.disabled = true;
	 document.forms[0].btnnur.disabled = true;
	 document.forms[0].btntonurs.disabled = true;

	}
}
function searchNursingUnit(target,target1){

	var formObj = document.frames.SRRPhFillListbyNursingUnitCriteriaForm;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

     
	dataNameArray[0]   = "facility_id" ;
	dataValueArray[0]  = formObj.p_facility_id.value;
	dataTypeArray[0]   = STRING ;
	  
	argumentArray[0]   = document.getElementById("SQL_PH_DISP_MEDICATION_SELECT32").value+"'"+formObj.p_language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
	if(retVal != null && retVal != "" )  {
		if(target.name=="p_fr_nurs_unit") {
			formObj.p_fr_nurs_unit.value = retVal[0];
		} else {
			formObj.p_to_nurs_unit.value = retVal[0];
		}
		
		//alert(retVal[0]);
		target1.value=retVal[0];
		target.value = retVal[1] ;
		target.disabled = true;
	}
}
function showResults(){
	
	var formObj = parent.f_query_add_mod.document.forms[0];
	var fill_proc_fr_dt="";
	var fill_proc_to_dt ="";
	var locale = formObj.language_id.value;
	var p_facility_id = formObj.p_facility_id.value;
	var p_disp_facility_id = formObj.p_disp_facility_id.value;
	var p_fill_proc_ty = formObj.p_fill_proc_ty.value;
	var p_select = formObj.p_select.value;
	//var p_fr_nurs_unit = formObj.p_fr_nurs_unit.value; commented for the incident num:25068 on 1/Dec/2010===By sandhya 
	//var p_to_nurs_unit = formObj.p_to_nurs_unit.value;
	var p_fr_nurs_unit = formObj.locn_code.value;
	var p_to_nurs_unit = formObj.locn_code1.value;
	var p_build = formObj.p_build.value;
	var p_rep_type = formObj.p_rep_type.value;
	var p_fill_proc_fr_dt = formObj.p_fill_proc_fr_dt.value;
	fill_proc_fr_dt=convertDate(p_fill_proc_fr_dt,"DMY",locale); 
	var p_fill_proc_to_dt = formObj.p_fill_proc_to_dt.value;
	fill_proc_to_dt=convertDate(p_fill_proc_to_dt,"DMY",locale); 
	
	if(p_select == "N"){
		var fields = new Array (formObj.p_select,formObj.p_rep_type);
	var names= new Array (getLabel("Common.defaultSelect.label","Common"), getLabel("Common.reporttype.label","Common"));
	if(checkFields(fields,names,parent.messageFrame)) 
	{ 
		/*==========================================================================================*/
		if(fill_proc_fr_dt != "")//Add this condition for SRR20056-SCF-7186[IN027144]
		{
			if(!isBefore(formObj.p_fill_proc_fr_dt.value,formObj.sysdate.value,"DMY",document.forms[0].language_id.value)) {
				var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
				alert(errors);
				return false
			}
		  if(p_fill_proc_to_dt != "") //Add this conditions for SRR20056-SCF-7186[IN027144]
		  {
			if(!isBefore(formObj.p_fill_proc_fr_dt.value,formObj.p_fill_proc_to_dt.value,"DMY",document.forms[0].language_id.value)) {
				var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 			
				alert(errors);
				return false;			
			}
		  }
		}
		if(p_fill_proc_to_dt != "") // This conditions and statements add for SRR20056-SCF-7186[IN027144]
		{
		
			if(!isBefore(formObj.p_fill_proc_to_dt.value,formObj.sysdate.value,"DMY",document.forms[0].language_id.value)) {
				var errors=getMessage("START_DATE_GREATER_SYSDATE","Common") ;
				alert(errors);				
				return false
			}
		}	
		
		/*=======================================================================================================*/
			
		if(parent.f_query_add_mod.CheckString("Nursing Unit", parent.f_query_add_mod.document.SRRPhFillListbyNursingUnitCriteriaForm.p_fr_nurs_unit,parent.f_query_add_mod.document.SRRPhFillListbyNursingUnitCriteriaForm.p_to_nurs_unit, parent.messageFrame) )					
		{

			if(doDateCheck(formObj.p_fill_proc_fr_dt,formObj.p_fill_proc_to_dt,parent.messageFrame))
			{
				parent.f_query_results.location.href="../../ePH/jsp/SRRPhFillListbyNursingUnitResult.jsp?p_disp_facility_id="+p_disp_facility_id+"&p_fill_proc_ty="+p_fill_proc_ty+"&p_select="+p_select+"&p_fr_nurs_unit="+p_fr_nurs_unit+"&p_to_nurs_unit="+p_to_nurs_unit+"&p_build="+p_build+"&p_rep_type="+p_rep_type+"&p_fill_proc_fr_dt="+fill_proc_fr_dt+"&p_fill_proc_to_dt="+fill_proc_to_dt+"&p_facility_id="+p_facility_id;
						
			}
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		}
	}
	else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
	}

	}
	else{
		var fields = new Array (formObj.p_select,formObj.p_build,formObj.p_rep_type);
	var names= new Array (getLabel("Common.defaultSelect.label","Common"),getLabel("Common.building.label","Common"), getLabel("Common.reporttype.label","Common"));
	if(checkFields(fields,names,parent.messageFrame)) 
	{
		if(doDateCheck(formObj.p_fill_proc_fr_dt,formObj.p_fill_proc_to_dt,parent.messageFrame))		parent.f_query_results.location.href="../../ePH/jsp/SRRPhFillListbyNursingUnitResult.jsp?p_disp_facility_id="+p_disp_facility_id+"&p_fill_proc_ty="+p_fill_proc_ty+"&p_select="+p_select+"&p_fr_nurs_unit="+p_fr_nurs_unit+"&p_to_nurs_unit="+p_to_nurs_unit+"&p_build="+p_build+"&p_rep_type="+p_rep_type+"&p_fill_proc_fr_dt="+fill_proc_fr_dt+"&p_fill_proc_to_dt="+fill_proc_to_dt+"&p_facility_id="+p_facility_id;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
	else{
	parent.f_query_results.location.href='../../eCommon/html/blank.html';
	}


	}

	
		

		
		
}

function SubmitLink(from,to,p_disp_facility_id,p_fill_proc_ty,p_fill_proc_fr_dt,p_fill_proc_to_dt,p_select,p_facility_id,p_fr_nurs_unit,p_to_nurs_unit,p_build){
	
	var obj=document.frames.SRRPhFillListbyNursingUnitResult;
	
	
	obj.from.value=from;
	obj.to.value=to;
	
	obj.p_disp_facility_id.value=p_disp_facility_id;
	
	obj.p_fill_proc_ty.value=p_fill_proc_ty;

	obj.p_fill_proc_fr_dt.value=p_fill_proc_fr_dt;

	obj.p_fill_proc_to_dt.value=p_fill_proc_to_dt;

	obj.p_select.value=p_select;

	obj.p_facility_id.value=p_facility_id;

	obj.p_fr_nurs_unit.value=p_fr_nurs_unit;

	obj.p_to_nurs_unit.value=p_to_nurs_unit;

	obj.p_build.value=p_build;

	
	obj.submit();
}


function showPrintReport( nursing_unit_code,fill_proc_id,fill_proc_date,fill_proc_type,locale){
	
	//var formObj = parent.f_query_add_mod.SRRPhFillListbyNursingUnitCriteriaForm;
	var formObj = parent.f_query_add_mod.document.forms[0];
	//alert("formObj====>" +formObj.name);
	var p_rep_type = formObj.p_rep_type.value;
	
   if(p_rep_type!='A'){

		formObj.P_FILL_PROC_DT.value = fill_proc_date;
		formObj.P_FILL_PROC_ID.value = fill_proc_id ;
		formObj.P_FILL_PROC_TY.value = fill_proc_type ;
		formObj.p_nurs_unit.value = nursing_unit_code ;
			
		if(p_rep_type == "B" )
		{
		formObj.p_report_id.value = "PHFILLBYNUPAT" ;
		}
		else  if(p_rep_type == "P")
		{
			formObj.p_report_id.value = "PHFILLBYNUDRUG" ;
		}
		
	  parent.f_query_add_mod.document.forms[0].submit();   //Added on 20/sept/2010 regarding incident num:23846: By Sandhya
   }else{
	   
		 var xmlDoc				=	"";
		var xmlHttp		        =	new XMLHttpRequest();
		var xmlAppend				=	"";
		xmlAppend += "nursing_unit_code"+"=\""+nursing_unit_code+"\" " ;
		xmlAppend += "fill_proc_id"+"=\""+fill_proc_id+"\" " ;	
		xmlAppend += "fill_proc_date"+"=\""+fill_proc_date+"\" " ;	
		xmlAppend += "fill_proc_type"+"=\""+fill_proc_type+"\" " ;	
		xmlAppend += "locale"+"=\""+locale+"\" " ;	
		var  xmlStr ="<root><SEARCH " ;
		xmlStr = xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "SRRPhRepTokenSeriesValidation.jsp?validate=FILL_LIST_BY_NURS_UNIT" , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		
		alert(getMessage("REPORT_SUBMITTED","PH"));
		//alert("Reports Are Submitted to Report Server "+responseText);
	
	
   }


}


