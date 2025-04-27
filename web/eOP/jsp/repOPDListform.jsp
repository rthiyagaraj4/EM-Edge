<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBVSTVT" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eOP/js/repResetRunlist.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

	/*ction changerep()
	{
		if(repOPDListform.p_patientwise_sort_yn.value == "Y")
			repOPDListform.p_report_id.value= "OPBVSTPT";
		else
			repOPDListform.p_report_id.value= "OPBVSTVT";
	}
*/
    
	<%-- Code added/modified by Tushar .T. Bhat on 07-Feb-04 for incorporating enterable practitioner look-up --%>

	/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
	}*/
	
  // added by mujafar for TTM-SCF-0153
	function valDate(obj, format, localeName) 
	{
		if(obj.name=="p_fr_appt_date_1")
		{ 
				var from ='';
				if(obj.value!=''){
					from = convertDate(obj.value,"DMY",localeName,"en");
					document.forms[0].p_fr_appt_date.value = from;
				}else{
					document.forms[0].p_fr_appt_date.value = '';
				}
				
		}
		if(obj.name=="p_to_appt_date_1")
		{ 
				var from ='';
				if(obj.value!=''){
					from = convertDate(obj.value,"DMY",localeName,"en");
					document.forms[0].p_to_appt_date.value = from;
				}else{
					document.forms[0].p_to_appt_date.value = '';
				}
				
		}
		
	}
	
	async function searchCode(obj,target)
    {
            var sql="";
			var sqlSecond="";
            var tit="";
            var facilityid = "<%=p_facility_id%>";
			/*var practitionerName="";
			var practitionerValue="";
			var speciality="";
			var practitionerTypeValue="";*/
			var locale = "<%=localeName%>";

			target.value=trimString(target.value);
			
			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);

            if(obj.name=="fromlocationcode" || obj.name=="tolocationcode")
            {
                tit=getLabel("Common.Location.label","Common");

                //SQL
				
				//argumentArray[0]="select Clinic_code code, short_desc description from OP_clinic where Facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select Clinic_code code, long_desc description from OP_clinic_lang_vw where language_id='"+locale+"' and Facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";

				argumentArray[1]=new Array("Facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

            }
			else if(obj.name=="fromVisittype" || obj.name=="toVisittype")
            {
                tit=getLabel("Common.visittype.label","Common");

                //SQL
				
				argumentArray[0]="select visit_type_code code,short_desc description from op_visit_type_lang_vw where language_id='"+locale+"' and Facility_id like ? and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[1]=new Array("Facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else if(obj.name=="fromSpecialty" || obj.name=="toSpecialty")
            {
				tit=getLabel("Common.speciality.label","Common");;

				//SQL

                argumentArray[0]="select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW  where language_id='"+locale+"' and '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
			}
			else if(obj.name=="fromMedicalTeam" || obj.name=="toMedicalTeam")
            {
                tit=getLabel("Common.medicalteam.label","Common");

				//SQL

                argumentArray[0]="select team_id code, short_desc description from AM_MEDICAL_TEAM_LANG_VW where language_id='"+locale+"' AND Facility_id like ? and upper(team_id) like upper(nvl(?,team_id)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[1]=new Array("Facility_id");
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
				//If Practitioner text boxes do this

                //sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

				sql="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
				//sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

				sqlSecond="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
				practitionerName=target.name;
				practitionerValue=target.value;
				
				*/

				if(obj.name=="Practitionerid1")
				{
					if(document.forms[0].p_fr_specialty_code)
						speciality=document.forms[0].p_fr_specialty_code.value;

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
				xmlStr += " specialty_code=\"" + speciality+ "\"";
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
		
			if(objName=="p_fr_physician_id")
				document.forms[0].p_fr_physician_id.value=arr[0];
			else
				document.forms[0].p_to_physician_id.value=arr[0];
						
		}
		else
		{
		
			if(objName=="p_fr_physician_id")
				document.forms[0].p_fr_physician_id.value="";
			else
				document.forms[0].p_to_physician_id.value="";
						
		}
	
	}

	


<%-- Code added/modified by Tushar .T. Bhat on 07-Feb-04 ends --%>


     
</script>
</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="Focusing('p_fr_appt_date_1')" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repOPDListform" id="repOPDListform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =null; 
    Statement stmt = null;
    String sql = "" ;
	StringBuffer StrVal =new StringBuffer();
	ResultSet rset=null;
	String isSpltyNurUnitToEnableYNAppl="";
try
    {
		con  =  ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		stmt = con.createStatement(); 
	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where language_id='"+localeName+"' and EFF_STATUS = 'E' order by 2" ;
    rset = stmt.executeQuery(sql);
	StrVal.setLength(0);
   
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append( "<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
			if(rset != null)    rset.close();
			if(stmt != null)    stmt.close();
	 }
	 catch(Exception e){
		 
		 //out.println(e);
		 e.printStackTrace();

		 }
	 finally
	 {
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

%>
			<table width='80%' align='center' valign='top'>
				<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</table>
            <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
                <tr>
                    <td width="33%">&nbsp;</td>
                    <td class="querydata" width="33%" style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
                    <td class="querydata" width="33%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
                <tr>
                    <td class="label"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
					<!-- valDate added for TTM-SCF-0153-->
                    <input type=text   name='p_fr_appt_date_1' id='p_fr_appt_date_1' size="10" maxlength="10" align="center" onblur="valDate(this,'DMY','<%=localeName%>');validDateObj(this,'DMY',localeName);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_appt_date_1');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
                    <td class='fields'> 
                    <input type=text  id='mdsto' name='p_to_appt_date_1' id='p_to_appt_date_1' size="10" maxlength="10" align="center" onblur="valDate(this,'DMY','<%=localeName%>');validDateObj(this,'DMY',localeName);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
                <input type="hidden" name="p_fr_appt_date" id="p_fr_appt_date">
			<input type="hidden" name="p_to_appt_date" id="p_to_appt_date">
				</tr> 
					
                <tr>
                    <td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fr_clinic_code' id='p_fr_clinic_code' size="4" maxlength="4" align="center" onBlur='searchCode(fromlocationcode,this)'><input type='button' name='fromlocationcode' id='fromlocationcode' value='?' class='button' onclick='searchCode(this, p_fr_clinic_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_clinic_code' id='p_to_clinic_code' size="4" maxlength="4" align="center" onBlur='searchCode(tolocationcode,this)'><input type='button' readOnly name='tolocationcode' id='tolocationcode' value='?' class='button' onclick='searchCode(this, p_to_clinic_code)'></td>
                </tr> 
			<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
			<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fr_specialty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
					</jsp:include>
					</tr>
			<%}else{%>
                <tr>
                    <td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fr_specialty_code' id='p_fr_specialty_code' size="4" maxlength="4" align="center" onBlur='searchCode(fromSpecialty,this)'><input type='button' name='fromSpecialty' id='fromSpecialty' value='?' class='button' onclick='searchCode(this, p_fr_specialty_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_specialty_code' id='p_to_specialty_code' size="4" maxlength="4" align="center" onBlur='searchCode(toSpecialty,this)'><input type='button' name='toSpecialty' id='toSpecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'></td>
			</tr><%}%>              

                <tr>
                    <td class="label"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fr_medical_team' id='p_fr_medical_team' size="6" maxlength="6" align="center" onBlur='searchCode(fromMedicalTeam,this)'><input type='button' name='fromMedicalTeam' id='fromMedicalTeam' value='?' class='button' onclick='searchCode(this, p_fr_medical_team)'></td>
                    <td class='fields'> <input type=text  name='p_to_medical_team' id='p_to_medical_team' size="6" maxlength="6" align="center" onBlur='searchCode(toMedicalTeam,this)'><input type='button' name='toMedicalTeam' id='toMedicalTeam' value='?' class='button' onclick='searchCode(this, p_to_medical_team)'></td>
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
                    <td class='fields'><input type=text  name='p_fr_physician_id' id='p_fr_physician_id' size="15" maxlength="15" align="center" onBlur='searchCode(Practitionerid1,this)'><input type='button' name='Practitionerid1' id='Practitionerid1' value='?' class='button' onclick='searchCode(this,p_fr_physician_id)'></td>
                    <td class='fields'> <input type=text  name='p_to_physician_id' id='p_to_physician_id' size="15" maxlength="15" align="center" onBlur='searchCode(Practitionerid2,this)'><input type='button' name='Practitionerid2' id='Practitionerid2' value='?' class='button' onclick='searchCode(this,p_to_physician_id)'></td>
                </tr>
               
				<tr>
                    <td class="label"><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fr_visit_type' id='p_fr_visit_type' size="2" maxlength="2" align="center" onBlur='searchCode(fromVisittype,this)'><input type='button' name='fromVisittype' id='fromVisittype' value='?' class='button' onclick='searchCode(this, p_fr_visit_type)'></td>
                    <td class='fields'> <input type=text  name='p_to_visit_type' id='p_to_visit_type' size="2" maxlength="2" align="center" onBlur='searchCode(toVisittype,this)'><input type='button' name='toVisittype' id='toVisittype' value='?' class='button' onclick='searchCode(this, p_to_visit_type)'></td>
                </tr>               

                
                <!--tr>
                    <td align='right' width='30%' class="label">Nature of Visit&nbsp;</td>
                    <td  width='20%' align="left">
                        <select name='p_nature_of_visit' id='p_nature_of_visit'>
                        <option value='1'>All Visits
                        <option value='2'>Routine
                        <option value='3'>Emergency
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr

                <tr>
                    <td align='right' width='30%' class="label">Group By&nbsp;</td>
                    <td  width='30%' align="left">
                        <select name='p_patientwise_sort_yn' id='p_patientwise_sort_yn' onchange='changerep()'>
                        <option value='N'>Visit Date
                        <option value='Y'>Patient ID 
                
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>-->

            </table>
			
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"   value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"   value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"   value="<%= p_user_name %>">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

<%
  StrVal.setLength(0);
%>

</form>

</BODY>
</HTML>

