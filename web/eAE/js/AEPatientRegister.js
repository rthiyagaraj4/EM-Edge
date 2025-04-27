


function run() { 

	var fields = new Array (f_query_add_mod.document.AEPatientRegister.p_fr_visit_date,f_query_add_mod.document.AEPatientRegister.p_to_visit_date);
	var names  = new Array ( f_query_add_mod.getLabel("Common.VisitDateFrom.label","Common"),f_query_add_mod.getLabel("Common.VisitDateTo.label","Common"));

	var locale=f_query_add_mod.document.AEPatientRegister.locale.value;

	if(f_query_add_mod.checkFields(fields,names,messageFrame)) {
		 
		 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.AEPatientRegister.p_fr_visit_date.value,"DMY",locale))			{
			
		 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.AEPatientRegister.p_to_visit_date.value,"DMY",locale))				 {
		 if(f_query_add_mod.isBefore(f_query_add_mod.document.AEPatientRegister.p_fr_visit_date.value,f_query_add_mod.document.AEPatientRegister.p_to_visit_date.value,"DMY",locale)){
          if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.VisitTypeCode.label","Common"),f_query_add_mod.document.forms[0].p_fr_visit_type_code,f_query_add_mod.document.forms[0].p_to_visit_type_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fr_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.SpecialityCode.label","Common"),f_query_add_mod.document.forms[0].p_fr_speciality_code,f_query_add_mod.document.forms[0].p_to_speciality_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fr_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fr_practitioner_id,f_query_add_mod.document.forms[0].p_to_practitioner_id,messageFrame)) {
			
						var p_nationality				= f_query_add_mod.document.AEPatientRegister.p_nationality.value;            
						var p_fr_visit_date				= f_query_add_mod.document.AEPatientRegister.p_fr_visit_date.value;              
						var p_to_visit_date				= f_query_add_mod.document.AEPatientRegister.p_to_visit_date.value;        
						var p_fr_visit_type_code	    = f_query_add_mod.document.AEPatientRegister.p_fr_visit_type_code.value;        
						var p_to_visit_type_code		= f_query_add_mod.document.AEPatientRegister.p_to_visit_type_code.value;    
						var p_fr_locn_code				= f_query_add_mod.document.AEPatientRegister.p_fr_locn_code.value;         
						var p_to_locn_code				= f_query_add_mod.document.AEPatientRegister.p_to_locn_code.value;         
						var p_fr_speciality_code		= f_query_add_mod.document.AEPatientRegister.p_fr_speciality_code.value;      
						var p_to_speciality_code		= f_query_add_mod.document.AEPatientRegister.p_to_speciality_code.value;      
						var p_fr_service_code			= f_query_add_mod.document.AEPatientRegister.p_fr_service_code.value;        
						var p_to_service_code			= f_query_add_mod.document.AEPatientRegister.p_to_service_code.value;          
						var p_fr_pract_type				= f_query_add_mod.document.AEPatientRegister.p_fr_pract_type.value;       
						var p_to_pract_type				= f_query_add_mod.document.AEPatientRegister.p_to_pract_type.value;         
						var p_fr_practitioner_id		= f_query_add_mod.document.AEPatientRegister.p_fr_practitioner_id.value;   
						var p_to_practitioner_id		= f_query_add_mod.document.AEPatientRegister.p_to_practitioner_id.value; 
						
						var p_facility_id				= f_query_add_mod.document.AEPatientRegister.p_facility_id.value; 
						var p_module_id					= f_query_add_mod.document.AEPatientRegister.p_module_id.value;                            
						var p_report_id					= f_query_add_mod.document.AEPatientRegister.p_report_id.value; 
						var p_user_name					= f_query_add_mod.document.AEPatientRegister.p_user_name.value; 
						var p_resp_id					= f_query_add_mod.document.AEPatientRegister.p_resp_id.value; 
						var p_curr_date					= f_query_add_mod.document.AEPatientRegister.p_curr_date.value; 
						f_query_add_mod.document.AEPatientRegister.method	= 'POST';
						f_query_add_mod.document.AEPatientRegister.action	= '../../eCommon/jsp/report_options.jsp?p_nationality='+p_nationality+'&p_fr_visit_date='+p_fr_visit_date+'&p_to_visit_date='+p_to_visit_date+'&p_fr_visit_type_code='+p_fr_visit_type_code+'&p_to_visit_type_code='+p_to_visit_type_code+'&p_fr_locn_code='+p_fr_locn_code+'&p_to_locn_code='+p_to_locn_code+'&p_fr_speciality_code='+p_fr_speciality_code+'&p_to_speciality_code='+p_to_speciality_code+'&p_fr_service_code='+p_fr_service_code+'&p_to_service_code='+p_to_service_code+'&p_fr_pract_type='+p_fr_pract_type+'&p_to_pract_type='+p_to_pract_type+'&p_fr_practitioner_id='+p_fr_practitioner_id+'&p_to_practitioner_id='+p_to_practitioner_id+'&p_facility_id='+p_facility_id+'&p_module_id='+p_module_id+'&p_report_id='+p_report_id+'&p_user_name='+p_user_name+'&p_resp_id='+p_resp_id+'&p_curr_date='+p_curr_date+'';	
						f_query_add_mod.document.AEPatientRegister.submit() ;
		 }

		 }else{
			var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
			var visit=f_query_add_mod.getLabel("Common.VisitDate.label","Common");
			var visitto=f_query_add_mod.getLabel("Common.to.label","Common")+" "+visit;
			error=error.replace("$",visitto);
			error=error.replace("#",visit);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
			 
		 }else{
			var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE')
			error=error.replace("$",f_query_add_mod.getLabel("Common.to.label","Common"))
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		}

		 }else{
			 
			var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE')
			error=error.replace("$",f_query_add_mod.getLabel("Common.from.label","Common"))
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;	
	}
}

}





function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}



async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
		var tit="";


    var p_faclid = document.forms[0].p_facility_id.value;
    var p_usr = document.forms[0].p_user_name.value;
    var p_resp = document.forms[0].p_resp_id.value;

	var practitionerName="";
	var practitionerValue="";
	var practitionerTypeValue="";
	var speciality="";
	var clinic_code="";
	var treatment_area_code="";
	var open_to_all_prac_for_clinic_yn="";
	var open_to_all_pract_yn="";
     var locale="'"+document.AEPatientRegister.locale.value+"'";
	target.value=trimString(target.value);
	
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);
	
	if(obj.name=="tovtype" || obj.name=="fromvtype") 
	{
		tit=getLabel("Common.visittype.label","Common");
		argumentArray[0]="select visit_type_code code, short_desc description from op_visit_type_lang_vw where language_id = "+locale+" and (('"+p_faclid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		
		argumentArray[1]=new Array("'"+p_faclid+"'","appl_user_id","resp_id","'"+p_faclid+"'","facility_id");
		argumentArray[2]=new Array("All",p_usr,p_resp,"All",p_faclid);
		argumentArray[3]=new Array(STRING,STRING,STRING,STRING,STRING);
		argumentArray[4]="6,7";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}
	else if(obj.name=="tolocn" || obj.name=="fromlocn")
	{
		tit=getLabel("Common.Location.label","Common");

		argumentArray[0]="select clinic_code code, short_desc description from op_clinic_lang_vw  where  level_of_care_ind = 'E' and language_id = "+locale+" and (('"+p_faclid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		argumentArray[1]=new Array("'"+p_faclid+"'","appl_user_id","resp_id","'"+p_faclid+"'","facility_id");
		argumentArray[2]=new Array("All",p_usr,p_resp,"All",p_faclid);
		argumentArray[3]=new Array(STRING,STRING,STRING,STRING,STRING);
		argumentArray[4]="6,7";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	}			
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {
        tit=getLabel("Common.speciality.label","Common");
        argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw  where language_id = "+locale+" and '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
               
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
		argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw  where language_id = "+locale+" and  '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
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
			if(document.forms[0].p_fr_speciality_code)
				speciality=document.forms[0].p_fr_speciality_code.value;

			if(document.forms[0].p_fr_pract_type)
				practitionerTypeValue=document.forms[0].p_fr_pract_type.value;

		}
		else
		{
			if(document.forms[0].p_to_speciality_code)
				speciality=document.forms[0].p_to_speciality_code.value;

			if(document.forms[0].p_to_pract_type)
				practitionerTypeValue=document.forms[0].p_to_pract_type.value;
		}
	

		getPractitioner(obj,target,p_faclid,speciality,practitionerTypeValue,"Q4",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
				
		return;            

	}
	var retVal= await CommonLookup(tit,argumentArray);
	
	if(retVal==null || retVal=="")
		target.value="";
	else{
		var result = retVal[0].split(",")[0];
		
	
		target.value=result;
	}
}

function PractLookupRetVal(retVal,objName)
{

	var arr;

	if (retVal != null)
	{
		arr=retVal.split("~");
	
		if(objName=="p_fr_practitioner_id")
			document.forms[0].p_fr_practitioner_id.value=arr[0];
		else
			document.forms[0].p_to_practitioner_id.value=arr[0];
	}
	else
	{
		
		if(objName=="p_fr_practitioner_id")
			document.forms[0].p_fr_practitioner_id.value="";
		else
			document.forms[0].p_to_practitioner_id.value="";
						
	}
	
}

function Checkcurrdate(from,to,str,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var error=f_query_add_mod.getMessage("VISIT_DATE_GT_CURR",'AE');
				error=error.replace("$",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
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


function fnExportToExcel(){
	

var fields = new Array (document.AEPatientRegister.p_fr_visit_date,document.AEPatientRegister.p_to_visit_date);
    var names  = new Array ( getLabel("Common.VisitDateFrom.label","Common"),getLabel("Common.VisitDateTo.label","Common"));
var locale = document.AEPatientRegister.locale.value;


if(checkFields( fields, names, parent.frames[2]))
		{
		 
		 if(isBeforeNow(document.AEPatientRegister.p_fr_visit_date.value,"DMY",locale))			{
			
		 if(isBeforeNow(document.AEPatientRegister.p_to_visit_date.value,"DMY",locale))				 {
		 if(isBefore(document.AEPatientRegister.p_fr_visit_date.value,document.AEPatientRegister.p_to_visit_date.value,"DMY",locale)){
          if(CheckString1(getLabel("Common.VisitTypeCode.label","Common"),document.forms[0].p_fr_visit_type_code,document.forms[0].p_to_visit_type_code,parent.frames[2]))
	     if(CheckString1(getLabel("Common.locationcode.label","Common"),document.forms[0].p_fr_locn_code,document.forms[0].p_to_locn_code,parent.frames[2]))
	     if(CheckString1(getLabel("Common.SpecialityCode.label","Common"),document.forms[0].p_fr_speciality_code,document.forms[0].p_to_speciality_code,parent.frames[2]))
	     if(CheckString1(getLabel("Common.ServiceCode.label","Common"),document.forms[0].p_fr_service_code,document.forms[0].p_to_service_code,parent.frames[2]))
	     if(CheckString1(getLabel("Common.practitionerid.label","Common"),document.forms[0].p_fr_practitioner_id,document.forms[0].p_to_practitioner_id,parent.frames[2]))
			 			{
			
					var nationality				= document.forms[0].p_nationality.value;            
					var visitDateFrom			= document.forms[0].p_fr_visit_date.value;              
					var visitDateTo				= document.forms[0].p_to_visit_date.value;        
					var visitTypeCodeFrom		= document.forms[0].p_fr_visit_type_code.value;        
					var visitTypeCodeTo			= document.forms[0].p_to_visit_type_code.value;    
					var locationCodeFrom		= document.forms[0].p_fr_locn_code.value;         
					var locationCodeTo			= document.forms[0].p_to_locn_code.value;         
					var specialityCodeFrom		= document.forms[0].p_fr_speciality_code.value;      
					var specialityCodeTo		= document.forms[0].p_to_speciality_code.value;      
					var serviceCodeFrom			= document.forms[0].p_fr_service_code.value;        
					var serviceCodeTo			= document.forms[0].p_to_service_code.value;          
					var practitionerTypeFrom	= document.forms[0].p_fr_pract_type.value;       
					var practitionerTypeTo		= document.forms[0].p_to_pract_type.value;         
					var practitionerIdFrom		= document.forms[0].p_fr_practitioner_id.value;   
					var practitionerIdTo		= document.forms[0].p_to_practitioner_id.value; 

					var nationalityTxt			= "";
					var practitionerTypeFromTxt	= "";
					var practitionerTypeToTxt	= "";

					if(nationality!="")
						nationalityTxt			= document.forms[0].p_nationality.options[document.forms[0].p_nationality.selectedIndex].innerHTML;
					if(practitionerTypeFrom!="")
						practitionerTypeFromTxt	= document.forms[0].p_fr_pract_type.options[document.forms[0].p_fr_pract_type.selectedIndex].innerHTML;
					if(practitionerTypeTo!="")
						practitionerTypeToTxt		= document.forms[0].p_to_pract_type.options[document.forms[0].p_to_pract_type.selectedIndex].innerHTML;

					parent.frames[1].document.forms[0].method	= "POST";
					parent.frames[1].document.forms[0].action	= '../../servlet/eAE.repPatientRegisterServlet?nationality='+nationality+'&visitDateFrom='+visitDateFrom+'&visitDateTo='+visitDateTo+'&visitTypeCodeFrom='+visitTypeCodeFrom+'&visitTypeCodeTo='+visitTypeCodeTo+'&locationCodeFrom='+locationCodeFrom+'&locationCodeTo='+locationCodeTo+'&specialityCodeFrom='+specialityCodeFrom+'&specialityCodeTo='+specialityCodeTo+'&serviceCodeFrom='+serviceCodeFrom+'&serviceCodeTo='+serviceCodeTo+'&practitionerTypeFrom='+practitionerTypeFrom+'&practitionerTypeTo='+practitionerTypeTo+'&practitionerIdFrom='+practitionerIdFrom+'&practitionerIdTo='+practitionerIdTo+'&nationalityTxt='+nationalityTxt+'&practitionerTypeFromTxt='+practitionerTypeFromTxt+'&practitionerTypeToTxt='+practitionerTypeToTxt;
					parent.frames[1].document.forms[0].submit();
	    }

		 }else{
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			var visit=getLabel("Common.VisitDate.label","Common");
			var visitto=getLabel("Common.to.label","Common")+" "+visit;
			error=error.replace("$",visitto);
			error=error.replace("#",visit);
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
			 
		 }else{
			var error=getMessage("VISIT_DATE_GT_CURR",'AE')
			error=error.replace("$",getLabel("Common.to.label","Common"))
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;		}

		 }else{
			 
			var error=getMessage("VISIT_DATE_GT_CURR",'AE')
			error=error.replace("$",getLabel("Common.from.label","Common"))
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;	
	}
}





	
	
	
}
