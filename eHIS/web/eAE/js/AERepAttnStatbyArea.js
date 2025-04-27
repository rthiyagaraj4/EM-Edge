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
				var error=getMessage("ATTEND_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - "+str+" Attendance Date should not be greater than current Date";		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}*/

function reset() {
	
	if(f_query_add_mod.document.RepAttnStatbyArea){
	   f_query_add_mod.document.RepAttnStatbyArea.reset() ;
	}

}

function run() 
{
	//MOdified by Shanmukh on 28th-JUNE-2018 for ML-MMOH-CRF-1043
	if(f_query_add_mod.document.RepAttnStatbyArea.isSearchByState.value=="true"){
	if(f_query_add_mod.document.RepAttnStatbyArea.p_reg_state_code1.value=="" || f_query_add_mod.document.RepAttnStatbyArea.p_reg_state_code1.value==null){
			  
			  f_query_add_mod.document.RepAttnStatbyArea.p_reg_state_code.value="";
	}}
	//END
var fields = new Array (f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date,f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date);
var attdtfrom=getLabel("eAE.AttendanceDate.label","AE")+" "+getLabel("Common.from.label","Common");
var names  = new Array (attdtfrom,getLabel("eAE.AttendanceDateTo.label","AE"));
var locale=f_query_add_mod.document.RepAttnStatbyArea.localeName;

var fields1 = new Array (f_query_add_mod.document.RepAttnStatbyArea.p_fm_res_area_code,f_query_add_mod.document.RepAttnStatbyArea.p_to_res_area_code);
	var names1 = new Array (getLabel("eAE.ResidenceAreaCodeFrom.label","AE"),getLabel("eAE.ResidenceAreaCodeTo.label","AE"));
	var error_page = "../../eCommon/jsp/error.jsp";	

if(f_query_add_mod.document.RepAttnStatbyArea){
          if(f_query_add_mod.checkFields( fields, names, messageFrame)){

				if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date.value,"DMY",locale)){
			 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date.value,"DMY",locale)){
					if(f_query_add_mod.isBefore(f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date.value,f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date.value,"DMY",locale)){
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
                        f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.RepAttnStatbyArea.submit() ;
					}else{
						var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
						var visit=f_query_add_mod.getLabel("eAE.AttendanceDate.label","AE");
						var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
						error=error.replace("$",visitto);
						error=error.replace("#",visit);
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
						return false;
		}

			 }else{
                 var error=f_query_add_mod.getMessage("ATTEND_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}

		 }else{
                 var error=f_query_add_mod.getMessage("ATTEND_DATE_GT_CURR",'AE');
				error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}

                /* if((Checkcurrdate( f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date, f_query_add_mod.document.RepAttnStatbyArea.p_curr_date,getLabel("Common.from.label","Common"), messageFrame )) &&(Checkcurrdate( f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date, f_query_add_mod.document.RepAttnStatbyArea.p_curr_date, getLabel("Common.to.label","Common"),messageFrame ))){
					        if((doDateCheck(f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date, f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date, messageFrame ))){
                                 f_query_add_mod.document.RepAttnStatbyArea.submit() ;
							}
				 }*/
		  }
}

/*if(f_query_add_mod.document.RepAttnStatbyArea)
{
	if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
	{
		if((doDateCheck(f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date, f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date, messageFrame )))						{
		if((Checkcurrdate( f_query_add_mod.document.RepAttnStatbyArea.p_fm_attend_date, f_query_add_mod.document.RepAttnStatbyArea.p_curr_date,"From", messageFrame )) &&
		  ( f_query_add_mod.CheckString('Residence Area Code', f_query_add_mod.document.RepAttnStatbyArea.p_fm_res_area_code,f_query_add_mod.document.RepAttnStatbyArea.p_to_res_area_code, messageFrame ) ) &&
		(Checkcurrdate( f_query_add_mod.document.RepAttnStatbyArea.p_to_attend_date, f_query_add_mod.document.RepAttnStatbyArea.p_curr_date, "To",messageFrame )))
			{

			if(f_query_add_mod.checkFields( fields, names, messageFrame))
	          {
			f_query_add_mod.document.RepAttnStatbyArea.submit() ;
	          }
			

			}
	}
}
}*/
}//e.o.run

async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;//var dialogHeight= "28" ;
			var dialogWidth	= "95vh" ;//var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var dispDescFirst="";
			if(obj.name=="res area code")
			{
				tit=encodeURIComponent(getLabel("Common.residence.label","Common")+" "+getLabel("Common.area.label","Common"))
				sql="select res_area_code,short_desc from mp_res_area_lang_vw where LANGUAGE_ID = `"+localeName+"` and EFF_STATUS=`E`";
				search_code="res_area_code";
				search_desc= "short_desc"
			}
			//MOdified by Shanmukh on 28th-JUNE-2018 for ML-MMOH-CRF-1043
			else if(obj.name=="state area code"){
				tit=encodeURIComponent(getLabel("Common.State.label","Common")+" "+getLabel("Common.area.label","Common"))
				sql="select region_code,short_desc from mp_region_lang_vw where LANGUAGE_ID = `"+localeName+"` and EFF_STATUS=`E`";
				search_code="region_code";
				search_desc= "short_desc";
				dispDescFirst="dispDescFirst";
				}
				
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&dispDescFirst="+dispDescFirst+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{   
				retVal=retVal.split("::");
				target.value=retVal[0];
				if(obj.name=="state area code"){
				document.RepAttnStatbyArea.p_reg_state_code.value=retVal[1];	
				}
			}
			else
				target.focus();
	}
			//END
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