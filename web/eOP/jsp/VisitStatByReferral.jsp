<!DOCTYPE html>

<%--
Filename		: VisitStatByReferral.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String locale=(String)session.getAttribute("LOCALE");
%>
<html>
<HEAD>
<SCRIPT>

function clearFields(obj)
{ 
	document.forms[0].frm_location_desc.value="";
	document.forms[0].frm_location.value="";
	if(obj.value !="")
	{ 
		document.forms[0].frm_location_desc.disabled=false;
	    document.getElementById("frmLoc").disabled=false;
    }
	else
	{ 
		document.forms[0].frm_location_desc.disabled=true;
	    document.getElementById("frmLoc").disabled=true;
	}

}

function disable_source(obj)
{
  if (obj.value ==""){
       document.forms[0].fm_ref_source.value="";
	   document.forms[0].fm_ref_source.disabled= true;
	   document.forms[0].fm_ref_source_but.disabled= true;
	 document.forms[0].fm_ref_location.disabled=true;
	document.forms[0].frm_location_desc.disabled=true;
	document.getElementById("frmLoc").disabled=true;
  
  }else 
  if (obj.value =="L"){
    if (obj.name =="fm_ref_type"){
	   document.forms[0].fm_ref_location.value="";
	   document.forms[0].frm_location_desc.value="";
	   document.forms[0].frm_location.value="";
	   document.forms[0].fm_ref_source.value="<%=p_facility_id%>";
	   document.forms[0].fm_ref_source.disabled= true;
	   document.forms[0].fm_ref_source_but.disabled= true;
	   document.forms[0].fm_ref_location.disabled=false;
	   //document.forms[0].frm_location_desc.disabled=false;
	   //document.getElementById("lgn").disabled=false;
	}
	
  }

  else{
    if (obj.name =="fm_ref_type"){
	    document.forms[0].fm_ref_location.value="";
	   document.forms[0].frm_location_desc.value="";
	   document.forms[0].frm_location.value="";
	  
	   document.forms[0].fm_ref_source.value="";
	   document.forms[0].fm_ref_source.disabled= false;
	   document.forms[0].fm_ref_source_but.disabled= false;
	 document.forms[0].fm_ref_location.disabled=true;
	document.forms[0].frm_location_desc.disabled=true;
	document.getElementById("frmLoc").disabled=true;
	}
	else{
	   document.forms[0].fm_ref_location.value="";
	   document.forms[0].frm_location_desc.value="";
	   document.forms[0].frm_location.value="";
	  document.forms[0].fm_ref_source.disabled= true;
	   document.forms[0].fm_ref_source_but.disabled= true;
	   document.forms[0].fm_ref_location.disabled=true;
	document.forms[0].frm_location_desc.disabled=true;
	 document.getElementById("lgn").disabled=true;
	 //  document.forms[0].to_ref_source.value="";
	 //  document.forms[0].to_ref_source.readOnly= false;
	 //  document.forms[0].to_ref_source_but.disabled= false;
	}
  }

}
<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 for incorporating enterable look-ups --%>


async function getLocation(locobj,loctypeobj)
{
	var tit				= getLabel("Common.Location.label","Common");;
	var locale			= "<%=locale%>";
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;	
	var sql="";
    from_locn_type=loctypeobj.value;
	
	from_fcy_id=document.forms[0].p_facility_id.value;
	if(from_locn_type=="C")
	{
	//sql = "Select short_desc description, clinic_code code from op_clinic where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='C'  and clinic_type='C' and upper(clinic_code) like upper(?) and upper(short_desc)  like upper(?)";
	
	sql = "Select long_desc description, clinic_code code from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"' and language_id='"+locale+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='C'  and clinic_type='C' and upper(clinic_code) like upper(?) and upper(long_desc)  like upper(?)";
	}
else if(from_locn_type=="E")
	{
	//sql = "Select short_desc description, clinic_code code from op_clinic where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='E' and upper(clinic_code) like upper(?) and upper(short_desc)  like upper(?) ";
	
	sql = "Select long_desc description, clinic_code code from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"' and language_id='"+locale+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='E' and upper(clinic_code) like upper(?) and upper(long_desc)  like upper(?) ";
	}
	else if(from_locn_type=="N")
	{
	//sql = "Select a.short_desc description, a.nursing_unit_code code from ip_nursing_unit a   where a.facility_id = '"+from_fcy_id+"' and a.locn_type='N' and a.appl_patient_class = 'IP' and a.eff_status = 'E'  and upper(nursing_unit_code) like upper(?) and upper(short_desc)  like upper(?)";
	
	sql = "Select a.long_desc description, a.nursing_unit_code code from ip_nursing_unit_lang_vw a   where a.facility_id = '"+from_fcy_id+"' and a.language_id='"+locale+"' and a.locn_type='N' and a.patient_class = 'IP' and a.eff_status = 'E'  and upper(nursing_unit_code) like upper(?) and upper(short_desc)  like upper(?)";
	}
	else if(from_locn_type=="Y")
	{
									
	//sql = "Select short_desc description, clinic_code  code  from op_clinic where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='D' and clinic_type='Y' and upper(clinic_code) like upper(?) and upper(short_desc)  like upper(?)";
	
	sql = "Select long_desc description, clinic_code  code  from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"' and language_id='"+locale+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='D' and clinic_type='Y' and upper(clinic_code) like upper(?) and upper(long_desc)  like upper(?)";
	} 


	
				

	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= "";
	argumentArray[6]	= CODE_LINK;
	argumentArray[7]	= CODE_DESC;	
	retVal = await CommonLookup( tit, argumentArray );		
	if(retVal != null && retVal != "" )
	{	
	  
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].frm_location_desc.value=arr[1];
		document.forms[0].frm_location.value=arr[0];			
	}	
	else
	{
	document.forms[0].frm_location_desc.value="";
	document.forms[0].frm_location.value="";			
	}
}


async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var locale="<%=locale%>";
	var tit="";
	/*var practitionerName="";
	var practitionerValue="";
	var practitionerTypevalue="";
	var speciality="";*/

	target.value=trimString(target.value);
	
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="tovtype" || obj.name=="fromvtype")
	{
		tit=getLabel("Common.visittype.label","Common");

		//SQL


		//argumentArray[0]="select visit_type_code code, short_desc description from op_visit_type where facility_id like ? and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2 ";
		
		argumentArray[0]="select visit_type_code code, short_desc description from op_visit_type_lang_vw where facility_id like ? and language_id='"+locale+"' and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2 ";
		
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;


	}			
	else if(obj.name=="fm_ref_source_but"||obj.name=="to_ref_source_but")
	{
		tit=getLabel("Common.referralsource.label","Common");

		var referralType="";
		
		if (target.name=="fm_ref_source")
			referralType=document.forms[0].fm_ref_type.value;
		else
			referralType=document.forms[0].to_ref_type.value;

		  if (referralType=="X"){
				//argumentArray[0]="Select referral_code code,short_desc description from AM_REFERRAL where '1' like ? and upper(referral_code) like upper(nvl(?,referral_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
				
				argumentArray[0]="Select referral_code code,LONG_DESC description from AM_REFERRAL_lang_vw where '1' like ? and language_id='"+locale+"' and upper(referral_code) like upper(nvl(?,referral_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
				
			argumentArray[1]=new Array("'1'");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;


		  }
		  else if (referralType=="E"){
				//argumentArray[0]="Select facility_id code,facility_name description from SM_FACILITY_PARAM where facility_id not like ? and upper(facility_id) like upper(nvl(?,facility_id)) and upper(facility_name) like upper(nvl(?,facility_name)) order by 2";

				argumentArray[0]="Select facility_id code,facility_name description from SM_FACILITY_PARAM_lang_vw where facility_id not like ? and language_id='"+locale+"' and upper(facility_id) like upper(nvl(?,facility_id)) and upper(facility_name) like upper(nvl(?,facility_name)) order by 2";
				
			argumentArray[1]=new Array("facility_id");
			argumentArray[2]=new Array(facilityid);
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;


		  }
		  else{
				//argumentArray[0]="select referral_code code,short_desc description from (Select facility_id  referral_code ,facility_name short_desc  from SM_FACILITY_PARAM union select referral_code,short_desc from am_referral) where '1' like ? and upper(referral_code) like upper(nvl(?,referral_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select referral_code code,short_desc description from (Select facility_id  referral_code ,facility_name short_desc  from SM_FACILITY_PARAM_lang_vw where language_id='"+locale+"' union select referral_code,LONG_DESC from am_referral_lang_vw where language_id='"+locale+"' and  '1' like ? and upper(referral_code) like upper(nvl(?,referral_code)) and upper(LONG_DESC) like upper(nvl(?,LONG_DESC))) order by 2";
				
			argumentArray[1]=new Array("'1'");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;


		  }

	   }
	   else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
	   {
		tit=getLabel("Common.speciality.label","Common");


		//argumentArray[0]="select speciality_code code, short_desc description from am_speciality where '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

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

		//SQL

		//argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service where '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where '1' like ? and language_id='"+locale+"' and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

	}
	else if(obj.name=="tolocn" || obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");

		//SQL

        //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id like ? and language_id='"+locale+"' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

                
    }	
	else
	{
		/*
		//sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sql="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2";

				
		//sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sqlSecond="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2";

				
		practitionerName=target.name;
		practitionerValue=target.value;
				
		*/
		
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

		await getPractitioner(obj,target,'',speciality,practitionerTypeValue,'','','','','',"Q2");

				
		/*

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practitionerName + "\""	;
		xmlStr += " practName_FValue=\"" + practitionerValue + "\"";
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
		eval(responseText);
		*/		
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


<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 ends --%>




</SCRIPT>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/repOPVisitStatByReferral.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  = null;
    Statement stmt = null;
	ResultSet rset = null;
    String sql = "" ;
	StringBuffer StrVal =new StringBuffer();
	String isSpltyNurUnitToEnableYNAppl="";
	try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		stmt = con.createStatement(); 
    //sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" ;
	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" ;
    rset = stmt.executeQuery(sql);
	
	StrVal.setLength(0);
   
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
	 
	 	if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
%>
<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>
<tr><td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>
<td class="querydata" width='33%' style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td></tr>
<tr>
	<td class="label"><fmt:message key="eOP.StatisticsDate.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type=text   name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('p_fm_date').focus();return showCalendar('p_fm_date');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img></td>	
	<td class='fields'><input type=text  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('p_to_date').focus();return showCalendar('p_to_date');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img></td>

<tr>
	<td class="label"><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_visit_type" id="p_fm_visit_type" size="2" maxlength="2" onBlur='searchCode(fromvtype,this)'><input type='button' name='fromvtype' id='fromvtype' value='?' class='button' onclick='searchCode(this, p_fm_visit_type)'>
	</td>

	<td class='fields'><input type="text" name="p_to_visit_type" id="p_to_visit_type" size="2" maxlength="2" onBlur='searchCode(tovtype,this)'><input type='button' name='tovtype' id='tovtype' value='?' class='button' onclick='searchCode(this, p_to_visit_type)'>
	</td>
<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>

	<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
</tr>
<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_specialty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
					</jsp:include>
					</tr>
<%}else{%>	
<tr>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>

	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr><%}%>

<tr>
	<td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'>
	</td>

	<td class='fields'><input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
	</td>
</tr>	
<tr>
                    <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                    <td class='fields'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>					
                    <td class='fields'><select name="to_pract_type" id="to_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>	
<tr>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
	
	<td class='fields'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this,p_fm_pract_id)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this,p_to_pract_id)'>
	</td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>

	<td class='fields' colspan='2'><select name="fm_ref_type" id="fm_ref_type" onchange = 'disable_source(this)'>
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
			<option value ='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
			<option value ='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
			<option value ='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
		</select>
	</td>	
</tr>	
<tr>
	<td class="label"><fmt:message key="eOP.ReferralSourceCode.label" bundle="${op_labels}"/></td>

	<td class='fields' colspan='2'><input type="text" name="fm_ref_source" id="fm_ref_source" size="4" maxlength="4" onBlur='searchCode(fm_ref_source_but,this)'><input type='button' name='fm_ref_source_but' id='fm_ref_source_but' value='?' class='button' onclick='searchCode(this, fm_ref_source)'>
	</td>

	<!--	<td class='fields'><input type="text" name="to_ref_source" id="to_ref_source" size="4" maxlength="4" onBlur='searchCode(to_ref_source_but,this)'><input type='button' name='to_ref_source_but' id='to_ref_source_but' value='?' class='button' onclick='searchCode(this, to_ref_source)'> 
	</td> -->
</tr>	

<tr>
	<td class="label"><fmt:message key="Common.Referred.label" bundle="${common_labels}"/> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

	<td class='fields'><select name="fm_ref_location" id="fm_ref_location"  disabled onchange = 'clearFields(this)'>
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
			<% 
	
	stmt = con.createStatement(); 
    //sql = "SELECT   short_desc,  locn_type FROM   AM_CARE_LOCN_TYPE WHERE  locn_type IN ('C','E','Y','N')  ORDER BY short_desc" ;
	sql = "SELECT   short_desc,  locn_type FROM   AM_CARE_LOCN_TYPE_lang_vw WHERE  locn_type IN ('C','E','Y','N') and language_id='"+locale+"'  ORDER BY short_desc" ;
    rset = stmt.executeQuery(sql);
	
	
   
	while(rset.next())
			{%>
		<option value='<%=rset.getString("locn_type")%>'><%=rset.getString("short_desc")%></option>
			<%}if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
		
	
	%>
	</select>
	</td>
	<td class='fields'><input type="text" name="frm_location_desc" id="frm_location_desc" size="30"  disabled onBlur=''><input type='button' name='frmLoc' id='frmLoc' value='?'  disabled  class='button' onclick='getLocation(this,fm_ref_location)'></td>
	<input type='hidden' name='frm_location' id='frm_location' value=''>	
  <!-- <td align="right" class="label">&nbsp;&nbsp;</td>

	<td>&nbsp;
			<select name="to_ref_type" id="to_ref_type" onchange = 'disable_source(this)'>
			<option value =''>&nbsp;--- Select ---&nbsp;</option>
			<option value ='L'>Login Facility</option>
			<option value ='E'>Enterprise</option>
			<option value ='X'>External</option>
		</select>
	</td>
 --></tr>
	<tr>
		<td class="label"><fmt:message key="eOP.IncludeNoShow.label" bundle="${op_labels}"/> <fmt:message key="Common.statistics.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='2'><input type="checkbox" name="statistics" id="statistics"></td>			
	</tr>	
	<tr>
		<td class="label"><fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='2'><select name="visit_status" id="visit_status" >
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
			<option value ='C'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option value ='I'><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			<option value ='A'><fmt:message key="eOP.AutoComplete.label" bundle="${op_labels}"/></option>
		</select>
		</td>		
	</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
		<input type="hidden" name="p_facility" id="p_facility"  		value="<%=p_facility_id %>">
		
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
<!-- 		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPVSBCLS"> -->
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPBVTREF">
		<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=p_user_name %>">
		
		<input type="hidden" name="p_clinic_from" id="p_clinic_from"		value="">
		<input type="hidden" name="p_clinic_to" id="p_clinic_to" 		value="">
		
		<input type="hidden" name="p_pract_from" id="p_pract_from" 		value="">
		<input type="hidden" name="p_pract_to" id="p_pract_to"		    value="">

		<input type="hidden" name="p_fm_ref_type" id="p_fm_ref_type"		value="">
		<input type="hidden" name="p_to_ref_type" id="p_to_ref_type" 		value="">

		<input type="hidden" name="p_fm_ref_source" id="p_fm_ref_source"		value="">
		<input type="hidden" name="p_to_ref_source" id="p_to_ref_source" 	value="">
		
		<input type="hidden" name="p_incl_no_show" id="p_incl_no_show" 		value="">
		<input type="hidden" name="p_visit_status" id="p_visit_status"		value="">
		
		<input type="hidden" name="p_date_from" id="p_date_from"		    value="">
		<input type="hidden" name="p_date_to" id="p_date_to" 		    value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

<%
 }
	 catch(Exception e){out.println(e);}
	 finally
	 {
		 try{
		if(rset != null)    rset.close();
		if(stmt != null)    stmt.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }


		StrVal.setLength(0);
%>
</form>
</body>
</center>
</html>

