<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
    String p_module_id      = "OP" ;
    String p_report_id      = "OPRREFVT" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;

	StringBuffer StrVal =new StringBuffer();
	StrVal.setLength(0);
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
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var x_Vals = new Array ();
var e_Vals = new Array ();
var l_Vals = new Array ();
var i=0


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

    async function searchCode(obj,target)
    {
            var sql="";
            var sqlSecond="";
			var facilityid = "<%=p_facility_id%>";
            var tit="";
			/*var practitionerName="";
			var practitionerValue="";
			var practitionerTypeValue="";*/
			var locale = "<%=localeName%>";

			target.value=trimString(target.value);

			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);

            if(obj.name=="toservice" || obj.name=="fromservice")
            {
                tit=getLabel("Common.service.label","Common");

				//SQL

                //argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service where '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				 argumentArray[0]="select SERVICE_CODE code, short_desc description from am_service_lang_vw where language_id='"+locale+"' AND '1' like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else if(obj.name=="tosubservice" || obj.name=="fromsubservice")
            {
                tit=getLabel("Common.subservice.label","Common");

				//SQL

                //argumentArray[0]="select SUBSERVICE_CODE code, short_desc description from am_subservice where '1' like ? and upper(subservice_code) like upper(nvl(?,subservice_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select SUBSERVICE_CODE code, short_desc description from am_subservice_lang_vw where language_id='"+locale+"' and '1' like ? and upper(subservice_code) like upper(nvl(?,subservice_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
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

                argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
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

				sql="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) OR  UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
				//sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

				sqlSecond="SELECT practitioner_id, am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)practitioner_name,  am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) practitioner_type, position_code job_title, gender,  am_get_desc.AM_SPECIALITY(primary_speciality_code,'"+locale+"',2)  primary_specialty FROM  am_practitioner WHERE   UPPER(pract_type) LIKE UPPER(NVL(?,pract_type)) AND  UPPER(primary_speciality_code) LIKE UPPER(NVL(?,primary_speciality_code)) AND (UPPER(practitioner_id) LIKE UPPER(NVL(?,practitioner_id)) and UPPER(am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1)))) AND  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown') LIKE NVL(UPPER(?),  DECODE(UPPER(gender),'M','MALE','F','FEMALE','U','Unknown')) AND  UPPER(NVL(position_code,'123')) LIKE UPPER(NVL(?,NVL(position_code,'123')))AND eff_status='E' ORDER BY 2 ";

				
				practitionerName=target.name;
				practitionerValue=target.value;
				
				*/
				
				if(obj.name=="pract_id1" && document.forms[0].fm_pract_type)
					practitionerTypeValue=document.forms[0].fm_pract_type.value;
				else if(document.forms[0].to_pract_type)
						practitionerTypeValue=document.forms[0].to_pract_type.value;
				
				await getPractitioner(obj,target,'','',practitionerTypeValue,'','','','','',"Q2");

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


	<%-- Code added/modified by Tushar .T. Bhat on 07-Feb-04 ends --%>



    function getRefVals(obj)
    {
        if(obj.name == "src_type" )
        {
            deleteValues(document.getElementById("p_fm_ref_source"))
            deleteValues(document.getElementById("p_to_ref_source"))
			
			if(obj.value == 'L')
            {
                for(var i=0; i<l_Vals.length;i++)
                {
                     var opt=document.createElement("OPTION");
                     var temp = l_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_fm_ref_source").add(opt)
                     
                     var opt=document.createElement("OPTION");
                     var temp = l_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_to_ref_source").add(opt)
                }
            }
            if(obj.value == 'E')
            {
                for(var i=0; i<e_Vals.length;i++)
                {
                     var opt=document.createElement("OPTION");
                     var temp = e_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_fm_ref_source").add(opt)
                     
                     var opt=document.createElement("OPTION");
                     var temp = e_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_to_ref_source").add(opt)
                }
            }
            else if(obj.value == 'X')
            {
                for(var i=0; i<x_Vals.length;i++)
                {
                     var opt= document.createElement("OPTION");
                     var temp = x_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_fm_ref_source").add(opt)
                     
                     var opt= document.createElement("OPTION");
                     var temp = x_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_to_ref_source").add(opt)
                }
            }
        }
        else
        {
            deleteValues(document.getElementById("p_fm_ref_dest"))
             deleteValues(document.getElementById("p_to_ref_dest"))
            
            if(obj.value == 'E')
            {
                for(var i=0; i<e_Vals.length;i++)
                {
                     var opt=document.createElement("OPTION");
                     var temp = e_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_fm_ref_dest").add(opt)
                      
                     var opt=document.createElement("OPTION");
                     var temp = e_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_to_ref_dest").add(opt)
                }
            }
            else if(obj.value == 'X')
            {
                for(var i=0; i<x_Vals.length;i++)
                {
                     var opt=document.createElement("OPTION");
                     var temp = x_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_fm_ref_dest").add(opt)
                     
                     var opt=document.createElement("OPTION");
                     var temp = x_Vals[i].split('`') ;
                     opt.text=temp[1];
                     opt.value=temp[0];
                     document.getElementById("p_to_ref_dest").add(opt)
                }
            }
        }
    }

	function deleteValues(obj)
    {
        while(obj.options.length>1) obj.options.remove(1)
    }
    
</script>
</HEAD>

<BODY onMouseDown="CodeArrest();" onLoad="Focusing('p_fm_visit_date')" onKeyDown = 'lockKey();'>

<%
    Connection con  =  null;
    Statement stmt =null;
	ResultSet rset =null;
    String sql = "" ;

    try
    {
		con  =  ConnectionManager.getConnection(request);
        stmt = con.createStatement() ; 
	sql = "Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='"+localeName+"' and STATUS = 'E' order by 1" ;
     rset = stmt.executeQuery(sql );
        
    while(rset.next())
    {
        %>
            <script>
                e_Vals[i] = "<%=rset.getString(2)%>`<%=rset.getString(1)%>"
                i++;
            </script>
        <%
    }
	    
    out.println("<script>i=0</script>") ;
	
	if(rset !=null) rset.close() ;

	sql = "Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='"+localeName+"' and STATUS = 'E' and facility_id='"+p_facility_id+"' order by 1" ;
    rset = stmt.executeQuery(sql );
        
    while(rset.next())
    {
        %>
            <script>
                l_Vals[i] = "<%=rset.getString(2)%>`<%=rset.getString(1)%>"
                i++;
            </script>
        <%
    }

	if(rset != null) rset.close();
    
	out.println("<script>i=0</script>") ;

    sql = "Select LONG_DESC, referral_Code from am_referral_lang_vw where language_id='"+localeName+"' and eff_status = 'E' order by 1" ;
    rset = stmt.executeQuery(sql );
    while(rset.next())
    {
        %>
            <script>
                x_Vals[i] = "<%=rset.getString(2)%>`<%=rset.getString(1)%>"
                i++;
            </script>
        <%
    }    
    if(rset !=null) rset.close() ;

	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_LANG_VW Where language_id='"+localeName+"' and EFF_STATUS = 'E' order by 2" ;
    rset = stmt.executeQuery(sql);

	if(rset != null)
	{
		while(rset.next())
		{
			StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
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

<form name="repReferredVisits" id="repReferredVisits" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
				<table width='80%' align='center' valign='top' border='0'>
				<tr>
					<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				</tr>
				</table>
                <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
                <tr>
                    <td width="33%">&nbsp;</td>
                    <td class="querydata" width="33%" style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
                    <td class="querydata" width="33%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
                </tr>
                <tr>
                    <td class="label"><fmt:message key="eOP.VisitDueDate.label" bundle="${op_labels}"/></td>
                    <td class='fields'><input type=text   name='p_fm_visit_date' id='p_fm_visit_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_visit_date');" style="cursor='hand'"></img>
					<img src='../../eCommon/images/mandatory.gif'></img></td>
                    <td class='fields'> <input type=text   name='p_to_visit_date' id='p_to_visit_date' size="10" maxlength="10" align="center" onblur="validDateObj(this,'DMY',localeName);"><img type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_visit_date');" style="cursor='hand'"></img>
					<img src='../../eCommon/images/mandatory.gif'></img></td>                    
                </tr>                
                <tr>
                    <td class="label"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fm_service_code' id='p_fm_service_code' size="4" maxlength="4" align="center" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_service_code' id='p_to_service_code' size="4" maxlength="4" align="center" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'></td>
				</tr>               
                <tr>
                   <td class="label"><fmt:message key="eOP.SubServiceCode.label" bundle="${op_labels}"/></td>
                   <td class='fields'><input type=text  name='p_fm_subservice_code' id='p_fm_subservice_code' size="4" maxlength="4" align="center" onBlur='searchCode(fromsubservice,this)'><input type='button' name='fromsubservice' id='fromsubservice' value='?' class='button' onclick='searchCode(this,p_fm_subservice_code)'></td>
                   <td class='fields'> <input type=text  name='p_to_subservice_code' id='p_to_subservice_code' size="4" maxlength="4" align="center" onBlur='searchCode(tosubservice,this)'><input type='button' name='tosubservice' id='tosubservice' value='?' class='button' onclick='searchCode(this,p_to_subservice_code)'></td>                  </tr>                
                <tr>
                    <td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
                    <td class='fields'><input type=text  name='p_fm_locn_code' id='p_fm_locn_code' size="4" maxlength="4" align="center" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'></td>
                    <td class='fields'> <input type=text  name='p_to_locn_code' id='p_to_locn_code' size="4" maxlength="4" align="center" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'></td>
		
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
                   <td class='fields'><input type=text  name='p_fm_pract_id' id='p_fm_pract_id' size="15" maxlength="15" align="center" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this,p_fm_pract_id)'></td>
                   <td> <input type=text  name='p_to_pract_id' id='p_to_pract_id' size="15" maxlength="15" align="center" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this,p_to_pract_id)'></td>
             </tr>
             <tr>
                <td class="label"><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
                <td colspan=2 class='fields'>
                <select onchange='getRefVals(this)' name='src_type' id='src_type'>
                            <option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</option>
                            <option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
							<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
                            <option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
                        </select>
                </td>				
                </tr>                
                <tr>
                    <td class="label"><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
                    <td class='fields'>
<!--					<select onchange='getRefVals(this)' name='p_fm_ref_source' id='p_fm_ref_source'> -->
                        <select name='p_fm_ref_source' id='p_fm_ref_source'>
                            <option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</option>
                        </select>
                    </td>
                    <td class='fields'>
<!--                         <select onchange='getRefVals(this)' name='p_to_ref_source' id='p_to_ref_source'> -->
                        <select name='p_to_ref_source' id='p_to_ref_source'>
                            <option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</option>
                        </select>
                    </td>
                </tr>                
                <tr>
                    <td class="label"><fmt:message key="Common.DestinationType.label" bundle="${common_labels}"/></td>
                    <td  class='fields' colspan=2 >
                        <select onchange='getRefVals(this)' name='dest_type' id='dest_type'>
                            <option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</option>
                            <option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
							<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
                            <option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
                        </select>
                    </td>					
                </tr>                
                <tr>
                    <td class="label"><fmt:message key="eOP.ReferralDestination.label" bundle="${op_labels}"/></td>
                    <td class='fields'>
<!--                         <select onchange='getRefVals(this)' name='p_fm_ref_dest' id='p_fm_ref_dest'> -->
                        <select name='p_fm_ref_dest' id='p_fm_ref_dest'>
                            <option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</option>
                        </select>
                    </td>
                    <td class='fields'>
<!--                         <select onchange='getRefVals(this)' name='p_to_ref_dest' id='p_to_ref_dest'> -->
                        <select name='p_to_ref_dest' id='p_to_ref_dest'>
                            <option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</option>
                        </select>
                    </td>
                </tr>              
                
                 <tr>
                    <td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
                    <td colspan=2 class='fields'>
                        <select name='p_1' id='p_1'>
                            <!-- <option value='0'>&nbsp;&nbsp;------ Select ------&nbsp;&nbsp;</option> -->
                            <option value='1'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
                            <option value='2'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
                        </select>
                    </td>					
                </tr>                
            </table>
			
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

<%
StrVal.setLength(0);
%>

</form>

</BODY>
</HTML>

