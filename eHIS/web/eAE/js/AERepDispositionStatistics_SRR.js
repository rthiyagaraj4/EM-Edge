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
				var error=getMessage("DISPOSI_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - "+str+" Disposition Date should not be greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}*/

function reset() {
	
	if(f_query_add_mod.document.RepDispositionStatistics){
	   f_query_add_mod.document.RepDispositionStatistics.reset() ;
	}

}

function run() 
{
 /*Below line modified for this SCF [ SRR20056-SCF-9516]*/
	//var locale=f_query_add_mod.document.RepDispositionStatistics.localeName.value;
	var locale=f_query_add_mod.document.RepDispositionStatistics.locale.value;
	

var fields = new Array (f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date1,f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date1);
var names  = new Array ( getLabel("eAE.DispositionDateFrom.label","AE"),getLabel("eAE.DispositionDateTo.label","AE"));

var fields1 = new Array (f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_type,f_query_add_mod.document.RepDispositionStatistics.p_to_disp_type										);
var names1 = new Array (getLabel("eAE.DispositionCodeFrom.label","AE"),getLabel("eAE.DispositionCodeTo.label","AE"));
var error_page = "../../eCommon/jsp/error.jsp";
 if( f_query_add_mod.CheckString1(getLabel("Common.treatmentarea.label","Common"), f_query_add_mod.document.forms[0].p_fr_tmt_area_code,f_query_add_mod.document.forms[0].p_to_tmt_area_code, messageFrame )  )
if( f_query_add_mod.CheckString1(getLabel("eAE.DispositionTypeCode.label","AE"), f_query_add_mod.document.forms[0].p_fm_disp_type,f_query_add_mod.document.forms[0].p_to_disp_type, messageFrame )  )
	
if(f_query_add_mod.checkFields( fields, names, messageFrame)){
	  if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date1.value,"DMY",locale)){
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date1.value,"DMY",locale)){
					if(f_query_add_mod.isBefore(f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date1.value,f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date1.value,"DMY",locale)){
					f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date.value=convertDate(f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date1.value,"DMY",f_query_add_mod.document.RepDispositionStatistics.locale.value,"en");
					f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date.value=convertDate(f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date1.value,"DMY",f_query_add_mod.document.RepDispositionStatistics.locale.value,"en");
						
					f_query_add_mod.document.RepDispositionStatistics.submit() ;
					}else{
						
						var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
						var visit=f_query_add_mod.getLabel("eAE.DispositionDate.label","AE");
						var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
						error=error.replace("$",visitto);
						error=error.replace("#",visit);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
						return false;
		}

			 }else{
				
                 var error=f_query_add_mod.getMessage("DISPOSI_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}

		 }else{
                 var error=f_query_add_mod.getMessage("DISPOSI_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}
}




} //e.o.run

async function searchCode(obj,target)
	{ 
		
			var retVal = 	new String();
			var dialogHeight= "35vh" ;
			var dialogWidth	= "48vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.RepDispositionStatistics.locale.value+"`";
			if(obj.name=="disposition type")
			{
				tit=encodeURIComponent(getLabel("Common.DispType.label","Common"))
				sql="select disp_type,short_desc from am_disposition_type_lang_vw where EFF_STATUS=`E` and language_id="+locale;
				search_code="disp_type";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

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
function doDate(obj)
{
	if(obj.value!='')
	{
		if(!validDateObj(obj,'DMY',localeName))
		{
			obj.select();
		}
		else
		{
		if(isBeforeNow(obj.value,"DMY",localeName))
		return true;
	else {
		alert(getMessage("START_DATE_GREATER_SYSDATE",'Common'));
					obj.select();
					return false ;
	 }
	}
	}
}
