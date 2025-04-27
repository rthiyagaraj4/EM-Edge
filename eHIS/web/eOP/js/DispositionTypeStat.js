function run() 
{
	var fields = new Array(f_query_add_mod.document.forms[0].p_fm_date1,f_query_add_mod.document.forms[0].p_to_date1);
	var names = new Array(getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common"));	
	if(f_query_add_mod.checkFields(fields,names,messageFrame))
	{
		if(chkGrtr(f_query_add_mod.document.forms[0].p_fm_date1,f_query_add_mod.document.forms[0].p_to_date1)==true)	
		if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label",'Common'),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
		if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))	
		if(f_query_add_mod.CheckString( getLabel("Common.ServiceCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_service_code,f_query_add_mod.document.forms[0].p_to_service_code,messageFrame))
		if(f_query_add_mod.CheckString( getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))		
			f_query_add_mod.document.forms[0].submit();	
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

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}

async function searchCode(obj,target)
{	
	var sql="";
	var sqlSecond="";
	var tit="";
	var p_faclid =document.forms[0].P_facilityid.value;
	var p_usr = document.forms[0].p_user_name.value;
	var p_resp = document.forms[0].p_resp_id.value;
	var locale=document.forms[0].locale.value;
	var practitionerName="";
	var practitionerValue="";
	var practitionerTypeValue="";
	var speciality="";
	

	target.value=trimString(target.value);
	
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);
	
	if(obj.name=="tolocn" || obj.name=="fromlocn")
	{
		tit=getLabel("Common.Location.label","Common");		

		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and (('"+p_faclid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";

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

        argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where '1' like ? and language_id='"+locale+"' and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

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
			if(document.forms[0].p_fm_pract_type)
				practitionerTypeValue=document.forms[0].p_fm_pract_type.value;
		}
		else
		{
			if(document.forms[0].p_to_specialty_code)
				speciality=document.forms[0].p_to_specialty_code.value;
			if(document.forms[0].p_to_pract_type)
				practitionerTypeValue=document.forms[0].p_to_pract_type.value;
		}		
		getPractitioner(obj,target,'',speciality,practitionerTypeValue,'','','','','',"Q2");		
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

function setDate(Object)
{ 
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
    if(Object.value!=""){
	   if (isBeforeNow(Object.value,"DMY",localeName)){
          return true;
        }
        else{
          alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
		  Object.value="";
          Object.focus();            
        }
    }
}

function chkFormat(obj){
	if(obj.value!=''){
		if(obj.name=='p_fm_date1'){			
			document.forms[0].p_fm_date.value=convertDate(document.forms[0].p_fm_date1.value,'DMY',localeName);			
		}else{				
			document.forms[0].p_to_date.value=convertDate(document.forms[0].p_to_date1.value,'DMY',localeName);				
		}
	}
}
