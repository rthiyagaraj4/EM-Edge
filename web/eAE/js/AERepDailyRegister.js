/*function Checkcurrdate(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
                var error=f_query_add_mod.getMessage("DATE_GT_CURR",'AE');
				error=error.replace("$",getLabel('Common.Visit.label','Common'));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - Visit Date should be not greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}
*/
function reset() {
	
	if(f_query_add_mod.document.repDailyRegister){
	   f_query_add_mod.document.repDailyRegister.reset() ;
	   f_query_add_mod.document.forms[0].elements(0).focus();

	}

}

/*Modified by Ashwini on 26-Jun-2019 for ML-MMOH-CRF-1413*/
function run()   
{
	var fields = new Array (parent.parent.frames[2].frames[1].document.repDailyRegister.p_fm_visit_date,parent.parent.frames[2].frames[1].document.repDailyRegister.p_to_visit_date);
	var names  = new Array (getLabel("Common.from.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.Date/Time.label","Common"), getLabel("Common.to.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.Date/Time.label","Common"));
   var locale=f_query_add_mod.document.repDailyRegister.localeName;
	var fields1 = new Array (f_query_add_mod.document.repDailyRegister.p_fm_patient_type,						
	   f_query_add_mod.document.repDailyRegister.p_to_patient_type);
	var names1 = new Array (getLabel("eAE.PatientTypeFrom.label","AE"),getLabel("eAE.PatientTypeTo.label","AE"));
	var error_page = "../../eCommon/jsp/error.jsp";	
	if(f_query_add_mod.checkFields( fields, names, messageFrame)){
	if(f_query_add_mod.document.repDailyRegister){
	if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
	{
		if(	(f_query_add_mod.CheckString(getLabel("Common.patienttype.label","Common"), f_query_add_mod.document.repDailyRegister.p_fm_patient_type,f_query_add_mod.document.repDailyRegister.p_to_patient_type, messageFrame ))&&(parent.parent.frames[2].frames[1].checkFields( fields, names, messageFrame)))
		{
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.repDailyRegister.p_fm_visit_date.value,"DMYHM",locale)){
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.repDailyRegister.p_to_visit_date.value,"DMYHM",locale)){
			 if(f_query_add_mod.isBefore(f_query_add_mod.document.repDailyRegister.p_fm_visit_date.value,f_query_add_mod.document.repDailyRegister.p_to_visit_date.value,"DMYHM",locale)){
				 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
                 f_query_add_mod.document.forms[0].target="messageFrame";	
				 f_query_add_mod.document.repDailyRegister.submit() ;
			 }else{
					var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
					var visit=f_query_add_mod.getLabel("Common.Visit.label","Common")+" "+f_query_add_mod.getLabel("Common.Date/Time.label","Common");
					var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
					error=error.replace("$",visitto);
					error=error.replace("#",visit);
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
					return false;
				  }
			 }else{
				var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				error=error.replace("Date",f_query_add_mod.getLabel("Common.Date/Time.label","Common"));
				error=error.replace("Date.",f_query_add_mod.getLabel("Common.Date/Time.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			 }
			 }else{
				var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				error=error.replace("Date",f_query_add_mod.getLabel("Common.Date/Time.label","Common"));
				error=error.replace("Date.",f_query_add_mod.getLabel("Common.Date/Time.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			 }
		}	
	}
	} 
	}
}//e.o.run
//Patient Daily Register
async function searchCode(obj,target)
	{
			var retVal = 	new String();
//			var dialogHeight= "500px" ;
//			var dialogWidth	= "800px" ;
			var dialogHeight= "40vh" ;
			var dialogWidth	= "70vw" ;
//			var dialogHeight= "28" ;
//			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.repDailyRegister.locale.value+"`";
  		    if(obj.name=="patient type") 
			{
				tit=encodeURIComponent(getLabel("Common.patienttype.label","Common"));
				sql="select patient_type,short_desc from am_patient_type_lang_vw where  language_id ="+locale+" and EFF_STATUS=`E`";
				search_code="patient_type"
				search_desc= "short_desc"
			}
           
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await top.window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function validSplchars(obj,name)
			{				
				 var fields=new Array();
				 var names=new Array();

				 fields[0]=obj;
				 names[0]=name;									
				if(SpecialCharCheck( fields, names,'',"A",''))
					return true;
				else
				{
					obj.select();
					obj.focus();
					return false;
				}
			}
