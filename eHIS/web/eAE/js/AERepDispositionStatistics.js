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
	var locale=f_query_add_mod.document.RepDispositionStatistics.localeName;

var fields = new Array (f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date,f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date);
var names  = new Array ( getLabel("eAE.DispositionDateFrom.label","AE"),getLabel("eAE.DispositionDateTo.label","AE"));

var fields1 = new Array (f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_type,f_query_add_mod.document.RepDispositionStatistics.p_to_disp_type										);
var names1 = new Array (getLabel("eAE.DispositionCodeFrom.label","AE"),getLabel("eAE.DispositionCodeTo.label","AE"));
var error_page = "../../eCommon/jsp/error.jsp";
if(f_query_add_mod.checkFields( fields, names, messageFrame)){
	if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date.value,"DMY",locale)){
		  if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date.value,"DMY",locale)){
				 if(f_query_add_mod.isBefore(f_query_add_mod.document.RepDispositionStatistics.p_fm_disp_date.value,f_query_add_mod.document.RepDispositionStatistics.p_to_disp_date.value,"DMY",locale)){
					 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; f_query_add_mod.document.forms[0].target="messageFrame";
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
			var dialogHeight= "50vh" ;
			var dialogWidth	= "40vw" ;
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
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
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