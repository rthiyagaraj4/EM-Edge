<!DOCTYPE html>

<%--
Filename		: repVisitStatClinicPract.jsp
Modified On		: 1-3-2005
Version			: 3
--%>
<%@ page import="java.sql.*, webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/repVisitStatClinicPract.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<%

	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale=(String)session.getAttribute("LOCALE");
%>
<html>
<HEAD>
<SCRIPT>

<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 for incorporating enterable look-ups --%>

async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var locale="<%=locale%>";
	var tit="";
	/*var practitionerName="";
	var practitionerValue="";
	var practitionerTypeValue="";
	var speciality="";*/
	
	target.value=trimString(target.value);
	
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);
	
	
	if(obj.name=="tovtype" || obj.name=="fromvtype")
	{
		tit=getLabel("Common.visittype.label","Common");

		//SQL


		//argumentArray[0]="select visit_type_code code, short_desc description from op_visit_type where facility_id like ? and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select visit_type_code code, short_desc description from op_visit_type_lang_vw where facility_id like ? and language_id='"+locale+"' and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
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
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {
        tit=getLabel("Common.speciality.label","Common");

		//SQL

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
	else
	{
		/*
		//sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sql="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
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
		
		getPractitioner(obj,target,'',speciality,practitionerTypeValue,'','','','','',"Q2");
		
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

</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name="VisitByStat_form" id="VisitByStat_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    Statement stmt = null;
	ResultSet rset = null;
	String sql = "" ;
	StringBuffer StrVal = new StringBuffer();
	String isSpltyNurUnitToEnableYNAppl="";

	//Added by Arthi on 30-May-2022 for MOHE-CRF-0136
	Boolean repBasedOnGovernorate = false;
	String region_prompt = "";

	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
    stmt = con.createStatement(); 
    
	//Added by Arthi on 30-May-2022 for MOHE-CRF-0136
	repBasedOnGovernorate = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VISIT_STAT_REP_GOVERNORATE");
	JSONObject Json	= eOP.OPCommonBean.getSMSiteParamDetail(con,locale);
	region_prompt = (String) Json.get("region_prompt");
	if(region_prompt==null || region_prompt.equals(""))
		region_prompt = "";
	if(region_prompt.equals("")) 
		region_prompt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels");

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

		if(rset != null) rset.close();
		if(stmt != null) stmt.close();

	 }
	 catch(Exception e){out.println(e);}
%>

<br><br>
<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>


<table cellpadding='2' border = '0' cellspacing='0' width='80%'>

<!--Added by Arthi on 30-May-2022 for MOHE-CRF-0136-->
<%if(repBasedOnGovernorate){%>
<tr>
	<td class="label" nowrap><%=region_prompt%></td>

	<td colspan = '2' class = 'fields'><select name = 'p_governorate_code' onChange = 'changeFacility(this);'>
	<option value="All"><fmt:message key="Common.AllGovernorates.label" bundle="${common_labels}"/></option>
	<%
			String gov_code = "";
			String gov_name = "";	
			
			//String sql_gov = "select 'All' region_code, 'All Governorates' region_desc from dual union select region_code, long_desc region_desc from mp_region_lang_vw where language_id = '"+locale+"' order by 2";

			String sql_gov = "select region_code, long_desc region_desc from mp_region_lang_vw where language_id = '"+locale+"' order by 2";

			stmt = con.createStatement();
			rset = stmt.executeQuery(sql_gov);

			if(rset != null)
			{
			   while(rset.next())
			   {
					gov_code = rset.getString("region_code");
					gov_name = rset.getString("region_desc");

					if(gov_code.equals("All"))
						out.println("<option value='"+gov_code+"' selected>"+gov_name+"</option>");
					else
					    out.println("<option value='"+gov_code+"'>"+gov_name+"</option>");
			   }
			}

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
	%>
	</td>

</tr>
<%}%>
<!--End MOHE-CRF-0136-->

<tr>
					<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan ="2"> 
						<select name='p_facilityid' id='p_facilityid' >
						<option value="ALL"><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
							<%
							try
							{ Statement stmt1= null; 
								stmt1=con.createStatement();
								String fid ;
								String fname;
								//String sql1 = "select 'ALL' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";			
								
								String sql1 = "select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";
								ResultSet rset1=stmt1.executeQuery(sql1);

								if(rset1!=null)
								{
								   while(rset1.next())
								   {
									fid=rset1.getString("facility_id");
									fname=rset1.getString("facility_name");
									if(fid.equals("ALL"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
									else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");							 
								 }
								}

								if(rset1 != null) rset1.close();
								if(stmt1 != null) stmt1.close();
							}catch(Exception e)
							{	out.println(e); }
							finally { ConnectionManager.returnConnection(con,request); }
							%>	
						</select>
					</td>
				</tr>	

<tr>
<td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class="label"><fmt:message key="eOP.StatisticsDate.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type=text  id='mdsfrom' name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
	<td class='fields'><input type=text id='mdsto'  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
</tr>
<tr>
	<td class="label"><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_visit_type" id="p_fm_visit_type" size="2" maxlength="2" onBlur='searchCode(fromvtype,this)'><input type='button' name='fromvtype' id='fromvtype' value='?' class='button' onclick='searchCode(this, p_fm_visit_type)'>
	</td>
	<td class='fields'>
	    <input type="text" name="p_to_visit_type" id="p_to_visit_type" size="2" maxlength="2" onBlur='searchCode(tovtype,this)'><input type='button' name='tovtype' id='tovtype' value='?' class='button' onclick='searchCode(this, p_to_visit_type)'>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>
	<td class='fields'>
	    <input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
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
	<td class='fields'>
	    <input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
	</td>
</tr>

    <tr>
                    <td class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                    <td class='fields'><select name="fm_pract_type" id="fm_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;</option>
						<%=StrVal.toString()%>
						</select>
					</td>					
                    <td class='fields'><select name="to_pract_type" id="to_pract_type">
						<option value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;</option>
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
		<td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
    <td class='fields' colspan='2'><select name="p_group_by" id="p_group_by" >
			<option value ='1'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
			<option value ='2'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			
		</select>
		</td>	
	</tr>
</table>

	<br>

		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
 		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPVSCLPR"> 
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">

		<!--Added by Arthi on 30-May-2022 for MOHE-CRF-0136-->
		<input type="hidden" name="locale" id="locale"			value="<%= locale %>">

		<input type="hidden" name="p_visit_type_from" id="p_visit_type_from"		value="">
	    <input type="hidden" name="p_visit_type_to" id="p_visit_type_to" 		value="">

	    <input type="hidden" name="p_clinic_from" id="p_clinic_from"		value="">
		<input type="hidden" name="p_clinic_to" id="p_clinic_to" 		value="">

		<input type="hidden" name="p_specialty_code_from" id="p_specialty_code_from"		value="">
		<input type="hidden" name="p_specialty_code_to" id="p_specialty_code_to" 		value="">

		<input type="hidden" name="p_service_code_from" id="p_service_code_from"		value="">
		<input type="hidden" name="p_service_code_to" id="p_service_code_to" 		value="">

		<input type="hidden" name="p_pract_id_from" id="p_pract_id_from"		value="">
		<input type="hidden" name="p_pract_id_to" id="p_pract_id_to" 		value="">


	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

<%
StrVal.setLength(0);
%>
</form>
</body>
</center>

<br>
<br>
</html>

