function reset() {
	f_query_add_mod.document.repOPAttnedance.reset() ;
}

/*function validateDate(obj)
{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/

function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}
function chkWithSysDt(obj)
	{
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}
function run(){  
		f_query_add_mod.document.repOPAttnedance.p_from_clinic_code.value = f_query_add_mod.document.repOPAttnedance.p_fr_clinic_code.value;
		f_query_add_mod.document.repOPAttnedance.p_too_clinic_code.value = f_query_add_mod.document.repOPAttnedance.p_to_clinic_code.value;	

		var fields = new Array( f_query_add_mod.document.repOPAttnedance.P_fr_visit_date,
		f_query_add_mod.document.repOPAttnedance.P_to_visit_date );

		var names = new Array(f_query_add_mod.getLabel("Common.VisitDateFrom.label","Common"), f_query_add_mod.getLabel("Common.VisitDateTo.label","Common"));
		var from			= f_query_add_mod.document.repOPAttnedance.P_fr_visit_date;
		var to			= f_query_add_mod.document.repOPAttnedance.P_to_visit_date;
		var visit_date	= getLabel("Common.VisitDate.label","Common");
		if(f_query_add_mod.checkFields( fields, names, messageFrame)){
			if( f_query_add_mod.doDateChkWithLabel( from, to, messageFrame,'DMY',visit_date) ){
				if(f_query_add_mod.CheckString( getLabel("Common.VisitDate.label","Common"),f_query_add_mod.document.forms[0].P_fr_visit_date,f_query_add_mod.document.forms[0].P_to_visit_date,messageFrame))     	

				if(f_query_add_mod.CheckString( getLabel("Common.clinic.label","Common"),f_query_add_mod.document.forms[0].p_fr_clinic_code,f_query_add_mod.document.forms[0].p_to_clinic_code,messageFrame))     	
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			    	f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.repOPAttnedance.submit() ;
			}
		}
}
function getTablistData(obj,target){
	if(target.value!=""&&target.value!=null){
			searchCode(obj,target);
	}
}
	async function searchCode(obj,target){
		var sm='';
		var locale = document.repOPAttnedance.locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = "SELECT clinic_code CODE,long_desc DESCRIPTION FROM op_clinic_lang_vw WHERE UPPER(clinic_code) LIKE UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) and  language_id='"+locale+"' ";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("Common.clinic.label","Common"), argumentArray );
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
/*Commented On 12/7/2009 for internationalization */

/*function searchCode(obj,target)
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
			var p_user_name = document.repOPAttnedance.p_user_name.value;
			var p_resp_id = document.repOPAttnedance.p_resp_id.value;
			var locale = document.repOPAttnedance.locale.value;
			
			
			if(obj.name=="clinic")
			{
				tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));
				sql="select clinic_code, long_desc FROM op_clinic_lang_vw where language_id=`"+locale+"`";
				search_code="clinic_code";
				search_desc= "long_desc"
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}*/
