<!DOCTYPE html>

<%--
Filename		: repOPRefStatYearwiseform.jsp
Modified On		: 2-3-2005
Version			: 3
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8"); 
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con=null; 

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBYRRFC" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
    String ID="";
    String dat="";
    String en="";
	String isSpltyNurUnitToEnableYNAppl="";
    try{
	con=ConnectionManager.getConnection(request); 
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
%>

<HEAD>
<script>
	async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	/*var practitionerName="";
	var practitionerValue="";
	var practitionerTypevalue="";*/
	var locale = "<%= localeName %>";
		
	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="tolocn" || obj.name=="fromlocn")
    {
        tit=getLabel("Common.Location.label","Common");

		//SQL

        //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
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
	else
	{
		/*
		//sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sql="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
		//sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

		sqlSecond="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
		practitionerName=target.name;
		practitionerValue=target.value;
				
		*/
		
		if(obj.name=="pract_id1" && document.forms[0].fm_pract_type)
			practitionerTypeValue=document.forms[0].fm_pract_type.value;
		else if(document.forms[0].to_pract_type)
			practitionerTypeValue=document.forms[0].to_pract_type.value;

		getPractitioner(obj,target,'','',practitionerTypeValue,'','','','','',"Q2");
				
		/*
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practitionerName + "\""	;
		xmlStr += " practName_FValue=\"" + practitionerValue + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
		xmlStr += " practitioner_type=\"" + practitionerTypeValue + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
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




</script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eOP/js/repResetRunlist.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repOPRefStatYearwiseform" id="repOPRefStatYearwiseform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
      
				<table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
					<tr>
               		<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
                    <td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
                    <%
                    stmt=con.createStatement();
                    //rset=stmt.executeQuery("SELECT FACILITY_NAME,FACILITY_ID from sm_facility_for_user_vw WHERE APPL_USER_ID='"+p_user_name+"'  order by FACILITY_NAME ");
					rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");
                    if(rset!=null)
                    {
                    while(rset.next())
                    {
                    dat=rset.getString("FACILITY_NAME");
                    ID=rset.getString("FACILITY_ID");

                    out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
                    }%>
                    </select>
                    <%  }

                    %>
                    </td>
                </tr> 
				<tr>
						<td width='33%'>&nbsp;</td>
						<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
          <!--   <tr>
				<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4"  onBlur='if(this.value !="") searchCode1(this,p_fm_locn_code,p_fm_locn_code1)'><input type="hidden" name="p_fm_locn_code1" id="p_fm_locn_code1"><input type='button' name='location' id='location' value='?' class='button' onclick='searchCode1(this,p_fm_locn_code,p_fm_locn_code1)'>
				</td>
				<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='if(this.value !="") searchCode1(this,p_to_locn_code,p_to_locn_code1)'><input type="hidden" name="p_to_locn_code1" id="p_to_locn_code1"><input type='button' name='location1' id='location1' value='?' class='button' onclick='searchCode1(this,p_to_locn_code,p_to_locn_code1)'>
				</td>
			</tr>

			<tr>
			<td  class="label" ><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/>

			</td>

			<td class='fields' nowrap>
				<input type="text" name="P_FM_SPECIAL" id="P_FM_SPECIAL" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, P_FM_SPECIAL,p_fm_speciality)' ><input type="hidden" name="p_fm_speciality" id="p_fm_speciality"><input type='button' name='speciality' id='speciality' value='?' class='button'  onclick='searchCode1(this, P_FM_SPECIAL,p_fm_speciality)'>
			</td>
			

			<td class='fields' nowrap>
				<input type="text" name="P_TO_SPECIAL" id="P_TO_SPECIAL" size="4" maxlength="4" onblur='if(this.value !="") searchCode1(this, P_TO_SPECIAL,p_to_speciality)'><input type="hidden" name="p_to_speciality" id="p_to_speciality"><input type='button' name='speciality1' id='speciality1' value='?' class='button' onclick='searchCode1(this, P_TO_SPECIAL,p_to_speciality)'>
			</td>
	  </tr>-->
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
<tr class='fields'>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr><%}%>

                <tr>
                    <td class="label"><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fr_year' id='p_fr_year' size="4" maxlength="4" onBlur="validateYear(this);" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></img>
                    </td>				
                    <td class='fields'><input type=text  name='p_to_year' id='p_to_year' size="4" maxlength="4" onBlur="validateYear(this);" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eCommon/images/mandatory.gif'></img>
                    </td>              
                </tr>                
            </table>       
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>


<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>
</BODY>
<% }
catch(Exception e) {out.println(e.toString());}
finally{
	try{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
if(con!=null)
    ConnectionManager.returnConnection(con,request);

}
                    %>

</HTML>

