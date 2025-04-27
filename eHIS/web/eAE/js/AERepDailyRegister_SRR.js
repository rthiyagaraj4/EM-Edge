function reset() { 
	
	if(f_query_add_mod.document.repDailyRegister){
	   f_query_add_mod.document.repDailyRegister.reset() ;
	   f_query_add_mod.document.forms[0].elements(0).focus();

	}

}

function run()   
{
        /*Below line modified for this SCF [SRR20056-9516] */
		var fields = new Array ( parent.parent.frames[2].frames[1].document.repDailyRegister.p_visit_date);
		var names  = new Array ( getLabel("Common.VisitDate.label","Common"));
		var locale = f_query_add_mod.document.repDailyRegister.locale;
		var p_visit_date1 =convertDate(f_query_add_mod.document.repDailyRegister.p_visit_date1.value,"DMY",locale.value,"en"); 
		f_query_add_mod.document.repDailyRegister.p_visit_date.value=p_visit_date1;
		//End [SRR20056-9516]
		var error_page = "../../eCommon/jsp/error.jsp";	
		var fields1 = new Array (f_query_add_mod.document.repDailyRegister.p_fr_locn_code);
		var names1 = new Array ('Location from');

		var fields2 = new Array (f_query_add_mod.document.repDailyRegister.p_fr_tmt_area_code,			
		f_query_add_mod.document.repDailyRegister.p_to_tmt_area_code);
		var names2 = new Array ('treatmentarea from','treatmentarea to');

		if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		if(f_query_add_mod.document.repDailyRegister){
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
		{
		if (f_query_add_mod.SpecialCharCheck(fields2,names2,messageFrame,"M",error_page))
		{ 
		if(	(f_query_add_mod.CheckString1(getLabel("Common.treatmentarea.label","Common"), f_query_add_mod.document.repDailyRegister.p_fr_tmt_area_code,f_query_add_mod.document.repDailyRegister.p_to_tmt_area_code, messageFrame ))&&(parent.parent.frames[2].frames[1].checkFields( fields, names, messageFrame)))
		{ /*Below line modified for this SCF [SRR20056-9516] */ 
		if(isBeforeNow(p_visit_date1,"DMY",locale ))
		f_query_add_mod.document.repDailyRegister.submit() ;	
		else
		{	
		var error=f_query_add_mod.getMessage("DATE_GT_CURR",'AE');
		error=error.replace("$",getLabel('Common.Visit.label','Common'));
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;	
		return false;
		}
		} 
		}
		}
		}	
		}
		}
	
//e.o.run
/* //Patient Daily Register
function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
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
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}





	*/

function searchCode1(obj,target)
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
	

	var retVal=CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[0];

}

function nursCode(obj,target)
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
    //title="Nursing Unit";
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
	

	var retVal=CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[0];
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

function CheckString1(str ,fromobj,toobj,messageFrame) {

 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}



function clearDetail1(obj){
if(obj.value==null||obj.value==""){
        document.forms[0].p_fr_tmt_area_code.value='';
		document.forms[0].p_to_tmt_area_code.value='';

		}
	else{
	    document.forms[0].p_fr_tmt_area_code.value='';
        document.forms[0].p_to_tmt_area_code.value='';
     
	}
}
