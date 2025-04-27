
function run() 
{

    var fields = new Array (f_query_add_mod.document.VisitByStatus_form.p_fm_date,f_query_add_mod.document.VisitByStatus_form.p_to_date);
    var names  = new Array ( f_query_add_mod.getLabel("Common.VisitDateFrom.label","Common"),f_query_add_mod.getLabel("Common.VisitDateTo.label","Common"));
	
   var locale=f_query_add_mod.document.VisitByStatus_form.locale.value;

	if(f_query_add_mod.checkFields(fields,names,messageFrame))
		{
		 
		 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.VisitByStatus_form.p_fm_date.value,"DMY",locale))			{
			
		 if(f_query_add_mod.isBeforeNow(f_query_add_mod.document.VisitByStatus_form.p_to_date.value,"DMY",locale))				 {
		 if(f_query_add_mod.isBefore(f_query_add_mod.document.VisitByStatus_form.p_fm_date.value,f_query_add_mod.document.VisitByStatus_form.p_to_date.value,"DMY",locale)){
          if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.VisitTypeCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_visit_type,f_query_add_mod.document.forms[0].p_to_visit_type,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.SpecialityCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
	     if(f_query_add_mod.CheckString1(f_query_add_mod.getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))
	     	{
				    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				    f_query_add_mod.document.forms[0].target="messageFrame";	
					f_query_add_mod.document.forms[0].submit();
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
     var locale="'"+document.VisitByStatus_form.locale.value+"'";
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
			if(document.forms[0].p_fm_specialty_code)
				speciality=document.forms[0].p_fm_specialty_code.value;

			if(document.forms[0].fm_pract_type)
				practitionerTypeValue=document.forms[0].fm_pract_type.value;

		}
		else
		{
			if(document.forms[0].p_to_specialty_code)
				speciality=document.forms[0].p_to_specialty_code.value;

			if(document.forms[0].to_pract_type)
				practitionerTypeValue=document.forms[0].to_pract_type.value;
		}

		
		/*sql="select a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,"+locale+",1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,"+locale+",2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,"+locale+",2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+p_faclid+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,"+locale+",1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,"+locale+",1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2  ";

				
		sqlSecond="select a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER( a.practitioner_id,"+locale+",1) practitioner_name,am_get_desc.AM_PRACT_TYPE( a.PRACT_TYPE,"+locale+",2) practitioner_type,a.POSITION_CODE  job_title,a.gender gender,am_get_desc.AM_SPECIALITY(a.SPECIALTY_CODE,"+locale+",2) primary_specialty from AM_PRACT_ALL_SPLTY_VW a  where upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and  a.facility_id= '"+p_faclid+"' and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(am_get_desc.AM_PRACTITIONER( a.practitioner_id,"+locale+",1)) like upper(nvl(?,am_get_desc.AM_PRACTITIONER( a.practitioner_id,"+locale+",1)))) and decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(a.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(a.POSITION_CODE ,'123')) like upper(nvl(?,nvl(a.POSITION_CODE ,'123'))) order by 2 ";
			
		practitionerName=target.name;
		practitionerValue=target.value;
	
		if(obj.name=="pract_id1")
		{
			if(document.forms[0].p_fm_specialty_code)
				speciality=document.forms[0].p_fm_specialty_code.value;

			if(document.forms[0].fm_pract_type)
				practitionerTypeValue=document.forms[0].fm_pract_type.value;

		}
		else
		{
			if(document.forms[0].p_to_specialty_code)
				speciality=document.forms[0].p_to_specialty_code.value;

			if(document.forms[0].to_pract_type)
				practitionerTypeValue=document.forms[0].to_pract_type.value;
		}
				

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practitionerName + "\""	;
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
		xmlStr += " practitioner_type=\"" + practitionerTypeValue + "\"";
		xmlStr += " specialty_code=\"" + speciality + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);*/
		getPractitioner(obj,target,p_faclid,speciality,practitionerTypeValue,"Q4",clinic_code,treatment_area_code,open_to_all_prac_for_clinic_yn,open_to_all_pract_yn);
				
		return;            

	}
	var retVal=await CommonLookup(tit,argumentArray);
	var retValueToCommaSeperate=unescape(retVal);
	var arr=retValueToCommaSeperate.split(",");
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
