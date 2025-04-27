/*Created by Thamizh selvi on 2nd feb 2017 against ML-MMOH-CRF-0634*/
function reset() {
	f_query_add_mod.location.reload();
}

function validatefromToWithCurrentDtAlert(obj,type) {
	
		var from = obj.value;
		var to   = document.forms[0].current_date.value;
        var fromarray = from.split("/");
		var toarray	  = to.split("/");
		var invaldt		 = getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;

		if (type=='M'){
			
			var fromdt = new Date(fromarray[1],fromarray[0]);
			var todt = new Date(toarray[1],toarray[0]);

			if (!isBeforeNow(obj.value,"MY",localeName)){

				if(Date.parse(todt) < Date.parse(fromdt)) {
					if (obj.name=='p_fm_Date')
						var visit_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.month.label","Common"));
					else
						var visit_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.month.label","Common"));
					var currentDate  = "Current month";	
					invaldt=invaldt.replace('$',visit_date);
					invaldt=invaldt.replace('#',currentDate);
					alert(invaldt);
					obj.value='';
					obj.focus();
				}
			}
		}

		if (type=='D'){

			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			
			if(Date.parse(todt) < Date.parse(fromdt)) {
				if (obj.name=='p_fm_Date')
					var visit_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.VisitDate.label","Common"));
				else
					var visit_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.VisitDate.label","Common"));
				var currentDate  = "Current date";
				invaldt=invaldt.replace('$',visit_date);
				invaldt=invaldt.replace('#',currentDate);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}
		}

		if (type=='Y'){

			if(parseInt(toarray[2]) < fromarray) {
				if (obj.name=='p_fm_Date')
					var visit_date = (getLabel("Common.from.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.year.label","Common"));
				else
					var visit_date = (getLabel("Common.to.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.year.label","Common"));
				var currentDate  = "Current year";	
				invaldt=invaldt.replace('$',visit_date);
				invaldt=invaldt.replace('#',currentDate);
				alert(invaldt);
				obj.value='';
				obj.focus();
			}	
		}

}

function datechange(){

	 if (document.getElementById("report_type").value=='M')
	 {
		 
		  document.getElementById("MY1").innerHTML=getLabel("Common.Visit.label","Common")+"&nbsp;"+getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_mth' maxlength='7' size='7' onblur='if(invalidDateCheck(this,document.getElementById("report_type").value))validatefromToWithCurrentDtAlert(this,document.getElementById("report_type").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_mth','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_mth1' maxlength='7' size='7' onblur='if(invalidDateCheck(this,document.getElementById("report_type").value))validatefromToWithCurrentDtAlert(this,document.getElementById("report_type").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_mth1','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
	 }
	 else  if (document.getElementById("report_type").value=='Y')
	 {
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.Visit.label","Common")+"&nbsp;"+getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='4' size='4' onblur='if(invalidDateCheck(this,document.getElementById("report_type").value))validatefromToWithCurrentDtAlert(this,document.getElementById("report_type").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='4' size='4' onblur='if(invalidDateCheck(this,document.getElementById("report_type").value))validatefromToWithCurrentDtAlert(this,document.getElementById("report_type").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 
	 }
	  else  if (document.getElementById("report_type").value=='D')
	 {
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.VisitDate.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='10' size='10' onblur='if(invalidDateCheck(this,document.getElementById("report_type").value))validatefromToWithCurrentDtAlert(this,document.getElementById("report_type").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='10' size='10' onblur='if(invalidDateCheck(this,document.getElementById("report_type").value))validatefromToWithCurrentDtAlert(this,document.getElementById("report_type").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' align='center' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>" ;
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
    
	tit=getLabel("Common.treatmentarea.label","Common");

	
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

function resetOnChangeTermSet(){
		document.forms[0].P_FM_TERM_CODE.value="";
		document.forms[0].P_TO_TERM_CODE.value="";
}

function enable_code()
{
	document.forms[0].P_FM_TERM_CODE.value='';
	document.forms[0].P_TO_TERM_CODE.value='';
	document.forms[0].P_Free_Text.value=''; 
	var sel=document.forms[0].P_TERM_SET_ID.value;
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST","../../eMR/jsp/AdverseEventType.jsp?validate=FREE_TEXT_YN&termSetID="+sel,false);
	xmlHttp.send(null);
	responseText=xmlHttp.responseText;  
	var proceed = trimString(responseText); 
	proceed=proceed.substring(0,1);

	if(sel=="" || sel==null)
	{
		 document.forms[0].P_FM_TERM_CODE.value="";
		 document.forms[0].P_TO_TERM_CODE.value="";
		 document.forms[0].P_Free_Text.value="";
		 document.forms[0].P_FM_TERM_CODE.disabled=true;
		 document.forms[0].P_TO_TERM_CODE.disabled=true;
		 document.forms[0].P_Free_Text.disabled=true;
		 document.forms[0].diag_frmbutton.disabled=true;
		 document.forms[0].diag_tobutton.disabled=true;
		 document.forms[0].start_ends_contains.disabled=true;
		 document.forms[0].start_ends_contains.value="S";
	}
	else 
	{
		 document.forms[0].P_FM_TERM_CODE.disabled=false;
		 document.forms[0].P_TO_TERM_CODE.disabled=false;
		 document.forms[0].diag_frmbutton.disabled=false;
		 document.forms[0].diag_tobutton.disabled=false;

		 if(proceed == "Y")
			document.forms[0].P_Free_Text.disabled=false;
		 else
			document.forms[0].P_Free_Text.disabled=true;
		 
		 if(proceed == "Y")
			document.forms[0].start_ends_contains.disabled=false;
		 else
			{
			  document.forms[0].start_ends_contains.disabled=true;
			  document.forms[0].start_ends_contains.value="S";
			}	
	}
}


async function searchgrpCode(obj,target)
{
    		var retVal =    new String();
            var dialogHeight= "35vh" ;
            var dialogWidth = "55vw" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";
			
	 
	        tit=getLabel("Common.diagnosis.label","Common");

			if(document.forms[0].P_TERM_SET_ID.value !=""){
			sql="select TERM_CODE,short_desc FROM MR_TERM_CODE_LANG_VW where term_set_id = `"+document.forms[0].P_TERM_SET_ID.value+"` AND language_id =`"+localeName+"` AND term_code != `*OTH` ";}
 
			search_code="term_code"; 
            search_desc= "short_desc"
	     
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
}


function splCharChk(obj,event)
{
	if(obj.name == "P_Free_Text"){
		var strCheck = ' 0123456789abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	}
	else if(obj.name == "P_TO_TERM_CODE" || obj.name == "P_FM_TERM_CODE"){
		var strCheck = '0123456789.abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	}
	else if(obj.name == "P_TO_TREAT_CODE" || obj.name == "P_FM_TREAT_CODE"){
		var strCheck = '0123456789*_abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	}
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false; 
}

function run()
{
	var fields = new Array(f_query_add_mod.document.repTotalVisitReg.p_fm_Date,f_query_add_mod.document.repTotalVisitReg.p_to_Date);
	var reptype=f_query_add_mod.document.repTotalVisitReg.report_type.value;
	if(reptype=="M")
	{	
		var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.month.label","Common"));
	}
	else if(reptype=="Y")
	{
		var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.Visit.label","Common")+" "+getLabel("Common.year.label","Common"));
	}
	else
	{
		var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.VisitDate.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.VisitDate.label","Common"));	
	}

	if(reptype=="M")
	{					  
	
		var names1  = new Array ( getLabel("Common.Visit.label","Common")+" "+getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ))
			{
				if( f_query_add_mod.CheckString(getLabel("Common.treatmentarea.label","Common"),f_query_add_mod.document.forms[0].P_FM_TREAT_CODE,f_query_add_mod.document.forms[0].P_TO_TREAT_CODE, messageFrame )  )
				{
					
					if( f_query_add_mod.CheckTerm(getLabel("Common.TermCode.label","Common"),f_query_add_mod.document.forms[0].P_FM_TERM_CODE,f_query_add_mod.document.forms[0].P_TO_TERM_CODE, messageFrame ))
						f_query_add_mod.document.repTotalVisitReg.submit() ;
				}	
			}
		}	
	}
	else if(reptype=="Y")
	{
		var names1  = new Array ( getLabel("Common.Visit.label","Common")+" "+getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ))
			{
				if(f_query_add_mod.CheckString(getLabel("Common.treatmentarea.label","Common"),f_query_add_mod.document.forms[0].P_FM_TREAT_CODE,f_query_add_mod.document.forms[0].P_TO_TREAT_CODE, messageFrame ))
				{
					
					if(f_query_add_mod.CheckTerm(getLabel("Common.TermCode.label","Common"),f_query_add_mod.document.forms[0].P_FM_TERM_CODE,f_query_add_mod.document.forms[0].P_TO_TERM_CODE, messageFrame ))
						f_query_add_mod.document.repTotalVisitReg.submit() ;
				}	
			}
		}
	}
	else
	{
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if( doDateCheckAlertLocal( getLabel("Common.VisitDate.label","Common"),f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			{
				if(f_query_add_mod.CheckString(getLabel("Common.treatmentarea.label","Common"),f_query_add_mod.document.forms[0].P_FM_TREAT_CODE,f_query_add_mod.document.forms[0].P_TO_TREAT_CODE, messageFrame ))
				{
					if(f_query_add_mod.CheckTerm(getLabel("Common.TermCode.label","Common"),f_query_add_mod.document.forms[0].P_FM_TERM_CODE,f_query_add_mod.document.forms[0].P_TO_TERM_CODE, messageFrame ))
						f_query_add_mod.document.repTotalVisitReg.submit() ;
				}	
			}
		}
	}
}

function CheckTerm(str ,fromobj,toobj,messageFrame) 
{
	var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");

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

function doDateCheckAlertLocal(str,from,to,messageFrame){
	    var fromdate = from.value ;
		var todate = to.value ;
		var localeName=f_query_add_mod.document.repTotalVisitReg.locale.value;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
		if(from.value!=""&&to.value!=""){
		if(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,"DMY","en"))
		{
			
			return true;
		}
		else 
		{
			var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
			
			error=error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error=error.replace("#",str);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
		}
		return true;
}

function invalidDateCheck(obj,type)
{
	if(obj.value!='')
	{
		if(type == 'D')
		{
			if(!validDateObj(obj,'DMY',localeName))
			{
				obj.select();
			}
			else
			{
				return true;
			}
		}
		if(type == 'M')
		{
			if(!validDateObj(obj,'MY',localeName))
			{
				obj.select();
			}
			else
			{
				return true;
			}
		}
		if(type == 'Y')
		{
			if(!validDateObj(obj,'YY',localeName))
			{
				obj.select();
			}
			else
			{
				return true;
			}
		}
	}

}

