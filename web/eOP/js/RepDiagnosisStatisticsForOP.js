function reset() {
	f_query_add_mod.document.location.reload() ;
}


function run() 
{
	var p_term_set_id=f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_term_set_id.value;
	var p_fm_term_code=f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_fm_term_code.value;
	var p_to_term_code=f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_to_term_code.value;
	if(p_term_set_id !=""){
              var fields = new Array ( f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_fm_date,f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_to_date,f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_fm_term_code,f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_to_term_code);
              var period=getLabel("Common.Period.label","Common");
			  var names = new Array(getLabel("Common.from.label","Common")+" "+period,getLabel("Common.to.label","Common")+" "+period,getLabel("Common.from.label","Common")+" "+getLabel("Common.DiagnosisCode.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.DiagnosisCode.label","Common"));	
	}else{
			var fields = new Array ( f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_fm_date,f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_to_date);
			var period=getLabel("Common.Period.label","Common");
			var names = new Array(getLabel("Common.from.label","Common")+" "+period,getLabel("Common.to.label","Common")+" "+period);	
	}
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{	 
		 if(chkGrtr(f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_fm_date,
					f_query_add_mod.document.repDiagnosisStatisticsForOP_form.p_to_date)==true)
		{	    
			if(f_query_add_mod.CheckString(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_splty_code,f_query_add_mod.document.forms[0].p_to_splty_code,messageFrame))
			if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
			if(f_query_add_mod.CheckString(getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
			if(f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_prct_code,f_query_add_mod.document.forms[0].p_to_prct_code,messageFrame))

           
			f_query_add_mod.document.repDiagnosisStatisticsForOP_form.submit() ;
		 }
	}
	
}

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

async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid =document.forms[0].p_all_facility_id.value;
	var p_usr = document.forms[0].p_user_name.value;
	var p_resp =document.forms[0].p_resp_id.value;
	var tit="";	
	var locale = document.forms[0].p_locale.value;
		
	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="tolocn" || obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");
		
		/*argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;*/

		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and (('"+facilityid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + facilityid + "' != ? and facility_id like ?)) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
        

		argumentArray[1]=new Array("'"+facilityid+"'","appl_user_id","resp_id","'"+facilityid+"'","facility_id");
		argumentArray[2]=new Array("All",p_usr,p_resp,"All",facilityid);
		argumentArray[3]=new Array(STRING,STRING,STRING,STRING,STRING);
		argumentArray[4]="6,7";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
                
    }
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {               
		 tit=getLabel("Common.speciality.label","Common");
			
		argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;			
     }
	 else if(obj.name=="toservice" || obj.name=="fromservice")
     {
		 tit=getLabel("Common.service.label","Common");
								
		 argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where language_id='"+locale+"' AND '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
		 argumentArray[1]=new Array("'1'");
		 argumentArray[2]=new Array("1");
		 argumentArray[3]=new Array(STRING);
		 argumentArray[4]="2,3";
		 argumentArray[5]=target.value;
		 argumentArray[6]=CODE_DESC_LINK;
		 argumentArray[7]=CODE_DESC;
	 }
	 else
	{
		 if(obj.name=="pract_id1")
		{		
			if(document.forms[0].p_fm_pract_type)
				practitionerTypeValue=document.forms[0].p_fm_pract_type.value;
		}
		else
		{	
			if(document.forms[0].p_to_pract_type)
				practitionerTypeValue=document.forms[0].p_to_pract_type.value;
		}

		getPractitioner(obj,target,'','',practitionerTypeValue,'','','','','',"Q2");
         return;
	}

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
function PractLookupRetVal(retVal,objName)
{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
		
			if(objName=="p_fm_prct_code")
				document.forms[0].p_fm_prct_code.value=arr[0];
			else
				document.forms[0].p_to_prct_code.value=arr[0];						
		}
		else
		{		
			if(objName=="p_fm_prct_code")
				document.forms[0].p_fm_prct_code.value="";
			else
				document.forms[0].p_to_prct_code.value="";						
		}
	
	}

async function call_Diagnosis(obj)
{ 
	var dialogTop	  = "50";
	var dialogHeight  = "35vh" ;
	var dialogWidth   = "50vw" ;
	var features    ="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;	
	var term_set   = document.forms[0].p_term_set_id.value;
	var encounter_id	= '';
	
	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?term_set_id="+term_set+"&p_diag_code="+diag_code+"&p_diag_scheme_desc="+diag_desc+"&Encounter_Id="+encounter_id+"&cause_indicator=";
		
	var retVal = await window.showModalDialog(params,arguments,features);
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=obj.name;
		
		 eval("document.forms[0]."+ objname+".value=retdata[0]");	
    }
}
function enable_code()
{	
	document.forms[0].p_fm_term_code.value='';
	document.forms[0].p_to_term_code.value='';
	var sel=document.forms[0].p_term_set_id.value;	
	if(sel=="" || sel==null)
	{
	 document.forms[0].p_fm_term_code.disabled=true;
	 document.forms[0].p_to_term_code.disabled=true;
	 document.forms[0].fm_diag_button.disabled=true;
	 document.forms[0].to_diag_button.disabled=true;
	 document.forms[0].fm_i_diag_code.style.visibility="hidden";
	 document.forms[0].to_i_diag_code.style.visibility="hidden";
	}
	else
	{
	 document.forms[0].p_fm_term_code.disabled=false;
	 document.forms[0].p_to_term_code.disabled=false;
	 document.forms[0].fm_diag_button.disabled=false;
	 document.forms[0].to_diag_button.disabled=false;
	 document.forms[0].fm_i_diag_code.style.visibility="visible";
	 document.forms[0].to_i_diag_code.style.visibility="visible";
	}	
}

function setDate(Object){ 
    if(Object.value!="")
	{
	   if(isBeforeNow(Object.value,"DMY",localeName)){
            return true;
        }
        else{
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
}
