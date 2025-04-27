

function reset(){
	if(frames[1].document.repOPRefStatYearwiseform){
	frames[1].document.repOPRefStatYearwiseform.reset() ;
	}
}

function chkGrtr(obj1,obj2)
{		
		if(isBefore(obj1.value,obj2.value,"YY",localeName)==false)
		{
			var str = getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common");
			var str1 = getLabel("Common.year.label","Common");

			var error=getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
			error=error.replace("$",str);
			error=error.replace("#",str1);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function run()
{		
if(frames[1].document.repOPRefStatYearwiseform)
{
var fields = new Array(frames[1].document.repOPRefStatYearwiseform.p_fr_year,frames[1].document.repOPRefStatYearwiseform.p_to_year );
var names = new Array((getLabel("Common.from.label","Common")+" "+getLabel("Common.year.label","Common")), (getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common")));

	if( frames[1].checkFields( fields, names, messageFrame))
	{		
if(chkGrtr(frames[1].document.repOPRefStatYearwiseform.p_fr_year,frames[1].document.repOPRefStatYearwiseform.p_to_year)==true)	if(f_query_add_mod.CheckString(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code, messageFrame )  )
	if(CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))

	   {
		
		      frames[1].document.repOPRefStatYearwiseform.submit() ;
		}
	}
}
} 
async function searchCode1(obj,target_code,target_desc)
				{   
					
				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

				var facilityid = document.forms[0].p_facility_id.value;
				//var p_location_type1=document.forms[0].p_location_type1.value;
				
			
			//	var facility=obj1.value;			
			
			
			if(obj.name=="speciality" || obj.name=="speciality1" || obj.name=="P_FM_SPECIAL" || obj.name=="P_TO_SPECIAL")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code,short_desc description from am_speciality_lang_vw where language_id='"+locale+"' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";				
			}					
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}

function validateYear(obj)
{
	if(obj.value!="")
	{
		if(validDate(obj.value,'YY',localeName)==false)
		{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				obj.select();	
				return false;
		}
			else
				return true;
		}
   }

function CheckString(str,fromobj,toobj,messageFrame) {

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
