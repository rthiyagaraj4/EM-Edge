function reset()
{	
	f_query_add_mod.document.repIntBetAdmandArrForm.reset() ;
}


function run() 
{
		
		var fromdate=f_query_add_mod.document.repIntBetAdmandArrForm.dis_date_from;
		var todate=f_query_add_mod.document.repIntBetAdmandArrForm.dis_date_to;
	 
		var fields = new Array(fromdate,todate);
		var names = new Array(getLabel('Common.admissiondate.label','Common')+' '+getLabel('Common.from.label','Common'),getLabel('Common.admissiondate.label','Common')+' '+getLabel('Common.to.label','Common'));

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			
		  if( f_query_add_mod.CheckString(getLabel('Common.nursingUnit.label','Common'), f_query_add_mod.document.repIntBetAdmandArrForm.P_FR_NURSING_UNIT,f_query_add_mod.document.repIntBetAdmandArrForm.P_TO_NURSING_UNIT, messageFrame )  )
			{
              if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','Common'), f_query_add_mod.document.repIntBetAdmandArrForm.P_FR_SPEC_CODE,f_query_add_mod.document.repIntBetAdmandArrForm.P_TO_SPEC_CODE, messageFrame )  )
				{
				    if( f_query_add_mod.CheckString(getLabel('Common.service.label','Common'), f_query_add_mod.document.repIntBetAdmandArrForm.P_FR_SERV_CODE,f_query_add_mod.document.repIntBetAdmandArrForm.P_TO_SERV_CODE, messageFrame )  )
				        {			
			                 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
                             f_query_add_mod.document.forms[0].target="messageFrame";
			                 f_query_add_mod.document.repIntBetAdmandArrForm.submit();
			             }
			
			     }

            }
        }

}

/*function CheckString(str,fromobj,toobj,messageFrame) {
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0053 - To " + str + " should be greater than or equal to From " + str ;
            return false;
        }
    }
    else {
        return true;
    }
}*/


function DateCompare(from,to,messageFrame,getVal) 
{
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate != "" && todate != "" ) 
	{
		if(validDate(fromdate,"DMY","en") && validDate(todate,"DMY","en"))
		{
			var greg_fromDate = convertDate(fromdate,'DMY',localeName,'en');
			var greg_toDate = convertDate(todate,'DMY',localeName,'en');
			 if(!isBefore(greg_fromDate,greg_toDate,'DMY','en'))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
				return false;
			}
			else 
			{
				return true;
			}
		}
	  }
	return true;
 }

async function searchCode(obj,target,Ar_installed)
  {
	
    var retVal = 	new String();
   /* var dialogHeight= "28" ;
    var dialogWidth	= "43" ;*/
    var dialogTop = "10px" ;
    var dialogHeight= "400px" ;
    var dialogWidth="900px";
    var status = "no";
    var arguments	= "" ;
    var sql="";
    var search_code="";
    var search_desc="";
	//var locale=repIntBetAdmandArrForm.locale.value;
	var locale=localeName;
    var tit="";
 if(obj.name=="specality")
    {
	   tit="Specialty";
	   //sql="select speciality_code, short_desc from am_speciality";
	   sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
	   search_code="speciality_code";
	   search_desc= "short_desc";
   }
else if(obj.name=="Service")
   {
	   tit="Service";
	   //sql="select service_code, short_desc from am_service";
	   sql="select service_code, short_desc from am_service_lang_vw where language_id=`"+locale+"` ";
	   search_code="service_code";
	    search_desc= "short_desc";
   }
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

if (!(retVal == null))
	target.value=retVal;
else
	target.focus();
}

async function searchCode11(obj,target)
	{
			var retVal = 	new String();
			/*var dialogHeight= "28" ;
			var dialogWidth	= "43" ;*/
			var dialogTop = "10px" ;
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var locale=repIntBetAdmandArrForm.locale.value;
			var locale=localeName
			

			if(obj.name=="nursing_unit_code")
			{
				tit="Nursing Unit"
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit  ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME") )
			}
		}
	}
