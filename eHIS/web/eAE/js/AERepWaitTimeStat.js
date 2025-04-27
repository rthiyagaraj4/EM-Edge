/*function Checkcurrdate(from,to,str,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - "+str+" Visit Date should not be greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}*/


function reset() {
	
	if(f_query_add_mod.document.RepWaitTimeStat){
	   f_query_add_mod.document.RepWaitTimeStat.reset() ;
	}

}

function run() 
{
	var locale=f_query_add_mod.document.RepWaitTimeStat.locale.value;
var fields = new Array (f_query_add_mod.document.RepWaitTimeStat.p_fm_visit_date,f_query_add_mod.document.RepWaitTimeStat.p_to_visit_date);
var names  = new Array ( getLabel("Common.VisitDateFrom.label","Common"),getLabel("Common.VisitDateTo.label","Common"));

if(f_query_add_mod.document.RepWaitTimeStat){
     if(f_query_add_mod.checkFields( fields, names, messageFrame)){
         if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepWaitTimeStat.p_fm_visit_date.value,"DMY",locale)){
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepWaitTimeStat.p_to_visit_date.value,"DMY",locale)){
					if(f_query_add_mod.isBefore(f_query_add_mod.document.RepWaitTimeStat.p_fm_visit_date.value,f_query_add_mod.document.RepWaitTimeStat.p_to_visit_date.value,"DMY",locale)){
						  f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		                  f_query_add_mod.document.forms[0].target="messageFrame";
						  f_query_add_mod.document.RepWaitTimeStat.submit() ;
					}else{
						var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
						var visit=f_query_add_mod.getLabel("Common.VisitDate.label","Common");
						var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
						error=error.replace("$",visitto);
						error=error.replace("#",visit);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
						return false;
		}

			 }else{
                 var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}

		 }else{
                 var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}



          
	}
}


}//e.o.run

/*Added by Ashwini on 08-Feb-2018 for ML-MMOH-CRF-0892*/
async function searchCode1(obj,target)
{
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
	var p_faclid = document.forms[0].p_facility_id.value;
    var p_usr = document.forms[0].p_user_name.value;
    var locale = document.forms[0].locale.value;

	tit=getLabel("Common.Location.label","Common");

	sql="select clinic_code code, short_desc description from OP_clinic where Facility_id = '"+p_faclid+"' and  LEVEL_OF_CARE_IND ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;
	
	var retVal=await CommonLookup(tit,argumentArray);
		var ret1=unescape(retVal);
			 var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=arr[0];
}

function clearDetail1(obj)
{
	if(obj.value==null||obj.value==""){
        document.forms[0].p_fr_tmt_area_code.value='';
		document.forms[0].p_to_tmt_area_code.value='';
		}
	else{
	    document.forms[0].p_fr_tmt_area_code.value='';
        document.forms[0].p_to_tmt_area_code.value='';
	}
}

async function nursCode(obj,target)
{
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
	var p_faclid = document.forms[0].p_facility_id.value;
    var p_usr = document.forms[0].p_user_name.value;
    var locale = document.forms[0].locale.value;
    var p_fr_locn_code = document.forms[0].p_fr_locn_code.value;

    tit=getLabel("Common.treatmentarea.label","Common");

	if(p_fr_locn_code!="")
	{
		sql="select TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and clinic_code= '"+p_fr_locn_code+"'  and facility_id='"+p_faclid+"' and upper(TREATMENT_AREA_CODE) like upper(nvl(?,TREATMENT_AREA_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))  order by 2";
	}
	else
		sql="select distinct TREATMENT_AREA_CODE code, SHORT_DESC description  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and  facility_id='"+p_faclid+"' and upper(TREATMENT_AREA_CODE) like upper(nvl(?,TREATMENT_AREA_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC))  order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;
	
	var retVal=await CommonLookup(tit,argumentArray);	
	var ret1=unescape(retVal);
		 var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=arr[0];
}
/*End ML-MMOH-CRF-0892*/


