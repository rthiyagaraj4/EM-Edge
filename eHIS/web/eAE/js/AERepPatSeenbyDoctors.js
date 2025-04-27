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
				var error=f_query_add_mod.getMessage("PATSEEN_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - "+str+" Patients Seen Date should not be greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}*/

function reset() {
	
	if(f_query_add_mod.document.RepPatSeenbyDoctors){
	   f_query_add_mod.document.RepPatSeenbyDoctors.reset() ;
	}

}



function run() 
{
var fields = new Array (f_query_add_mod.document.RepPatSeenbyDoctors.p_fm_pat_seen_date,f_query_add_mod.document.RepPatSeenbyDoctors.p_to_pat_seen_date);
var names  = new Array ( getLabel("eAE.PatientsSeenDateFrom.label","AE"),getLabel("eAE.PatientsSeenDateTo.label","AE"));

var fields1 = new Array (f_query_add_mod.document.RepPatSeenbyDoctors.p_fm_pract_id,										f_query_add_mod.document.RepPatSeenbyDoctors.p_to_pract_id										);
var names1 = new Array (getLabel("eAE.PractitionerIDFrom.label","AE"),getLabel("eAE.PractitionerIDTo.label","AE"));
var error_page = "../../eCommon/jsp/error.jsp";
var locale=f_query_add_mod.document.RepPatSeenbyDoctors.localeName;


if(f_query_add_mod.document.RepPatSeenbyDoctors){
  if(f_query_add_mod.checkFields( fields, names, messageFrame)){

	  if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepPatSeenbyDoctors.p_fm_pat_seen_date.value,"DMYHM",locale)){
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepPatSeenbyDoctors.p_to_pat_seen_date.value,"DMYHM",locale)){
					if(f_query_add_mod.isBefore(f_query_add_mod.document.RepPatSeenbyDoctors.p_fm_pat_seen_date.value,f_query_add_mod.document.RepPatSeenbyDoctors.p_to_pat_seen_date.value,"DMYHM",locale)){
					f_query_add_mod.document.RepPatSeenbyDoctors.submit() ;
					}else{
						var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
						var visit=f_query_add_mod.getLabel("eAE.PatientsSeenDate.label","AE");
						var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
						error=error.replace("$",visitto);
						error=error.replace("#",visit);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
						return false;
		}

			 }else{
                 var error=f_query_add_mod.getMessage("PATSEEN_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}

		 }else{
                 var error=f_query_add_mod.getMessage("PATSEEN_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}
      
   }
}


}//e.o.run

async function searchCode(obj,target)
	{
		var facility_id=document.forms[0].p_facility_id.value;
		var specialty_code="";
		var clinic_code="";
		var treatment_area_code="";
		var open_to_all_prac_for_clinic_yn="";
		var open_to_all_pract_yn="";
		var practitioner_type="";

			/*var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.RepPatSeenbyDoctors.locale.value+"`";
			if(obj.name=="practitioner id")
			{
				//var  p_facility_id="`"+'<%=p_facility_id%>'+"`";
				tit=encodeURIComponent(getLabel("Common.practitionerid.label","Common"));
				//sql="select practitioner_id,practitioner_name from am_pract_for_facility";
				sql="select practitioner_id,practitioner_name from  am_practitioner_lang_vw where EFF_STATUS=`E` and language_id="+locale;
				//	"where operating_facility_id = "+p_facility_id;
				search_code="practitioner_id";
				search_desc= "practitioner_name"
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();*/
				await getPractitioner(obj,target,facility_id,specialty_code,practitioner_type,"Q5",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
		}

function PractLookupRetVal(retVal,objName)
{

	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");
	
		if(objName=="p_fm_pract_id")
			document.forms[0].p_fm_pract_id.value=arr[0];
		else
			document.forms[0].p_to_pract_id.value=arr[0];
	}
	else
	{
		
		if(objName=="p_fm_pract_id")
			document.forms[0].p_fm_pract_id.value="";
		else
			document.forms[0].p_to_pract_id.value="";
						
	}
	
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

function showCalendarDateTime(id, date_format,time_format,modal_yn) 
{
	//var el = eval("document.all."+id);
	var el = document.getElementById(id);

	var isModal = "isDiv";
	var timeSet = "";

	if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
	{
			timeSet="dd/mm/yyyy"
	}
	else 
	{
			timeSet=date_format
	}
	if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
	{

		timeSet = timeSet +' '+ time_format;
	}

	//if ( ( ! document.getElementById("CACalanderFun") ) && (eval("document.all."+id+".type") !='hidden') )
	if ( ( ! document.getElementById("CACalanderFun") ) && (document.getElementById(id).type != 'hidden'))

	{
		//eval("document.all."+id).blur();
		document.getElementById(id).blur();
	}

	if(enableFlag)
	{
			return false
	}
	else
	{
		enableFlag=true;
	}

	showInModalDateTime(el,timeSet);
	return false;
}

async function showInModalDateTime(args,timeSet)
{
	var dialogHeight= "25vh" ;
	var dialogWidth	= "30vw" ;
	var status = "no";
	var features =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
	var dateValue = await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);
	
	var formatedDate = dateValue;

	if(formatedDate == undefined)
	{
		args.value = "";
	}
	else
	{
		var date_format = dateValue.split(" ");

		if(args == document.getElementById("hlyattnfrom"))
		{
			formatedDate = date_format[0]+" 00:00";
		}
		else if(args == document.getElementById("hlyattnto"))
		{
			formatedDate = date_format[0]+" 23:59";
		}

		args.value = formatedDate;
	}
	
	if ( ( ! document.getElementById("CACalanderFun") ) && (args.type !='hidden') )
	args.focus();
	enableFlag = false;
}
