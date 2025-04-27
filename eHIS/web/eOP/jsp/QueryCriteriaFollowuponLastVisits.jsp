<!DOCTYPE html>

<html>

<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String pid_length="";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
<script src='../../eOP/js/FollowuponLastVisits.js' language='javascript'></script>
<script src='../../eOP/js/OPPractitionerComponent.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<%	request.setCharacterEncoding("UTF-8");	%>
<%
	Connection con=null ;
	try {
        con  =  ConnectionManager.getConnection(request);
		Statement stmt=null;
		ResultSet rset=null;
		Statement stmt1=null;
		ResultSet rset1=null;
		String sql="";
		
		String dte="";
		String operating_facility_id="";
		 String locale=(String)session.getAttribute("LOCALE");
		operating_facility_id=(String) session.getValue("facility_id");
		String dte_display = "";

		 stmt1 = con.createStatement();
		 String sql4 = "select patient_id_length from mp_param";
		 rset1 = stmt1.executeQuery(sql4);
		if(rset1 != null){
		if(rset1.next())
			  pid_length = rset1.getString(1);
          
		}
		if(pid_length==null || pid_length.equals(""))
			pid_length = "20";
        if(rset1 != null) rset1.close();
		if(stmt1 != null) stmt1.close();
%>

<script  language="javascript">

	
	/*
	
	function searchValues(target_id,target)
	{
			var facility_id = "<%=operating_facility_id%>";
			var tit="";
			
			var argumentArray=new Array(8);

			target.value=trimString(target.value);

			if(target.value=="" && window.event.target == target)
			{
				target_id.value="";
				return;
			}
			
			if(target_id.name == "speciality_code")
			{
				tit="Speciality";

				//SQL
				
				argumentArray[0]="select SPECIALITY_CODE code, SHORT_DESC description from AM_SPECIALITY where EFF_STATUS like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";

				argumentArray[1]=new Array("EFF_STATUS");
				argumentArray[2]=new Array("E");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
				
			}
			else if(target_id.name == "service_code")
			{
				tit="Service";
				
				//SQL

				argumentArray[0]="select SERVICE_CODE code, SHORT_DESC description from AM_SERVICE where EFF_STATUS like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";

				argumentArray[1]=new Array("EFF_STATUS");
				argumentArray[2]=new Array("E");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
				
			}
			else if(target_id.name == "clinic_code")
			{
				tit="Clinic";

				//SQL
				
				argumentArray[0]="select CLINIC_CODE code, SHORT_DESC description from OP_CLINIC where facility_id like ? and EFF_STATUS like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";
				
				argumentArray[1]=new Array("facility_id","EFF_STATUS");
				argumentArray[2]=new Array(facility_id,"E");
				argumentArray[3]=new Array(STRING,STRING);
				argumentArray[4]="3,4";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else if(target_id.name == "practitioner_id")
			{
				
				var sql="select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(a.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) job_title, decode(a.gender,'M','Male','F','Female','U','Unknown') gender, b.primary_speciality_desc primary_specialty from am_practitioner a,  AM_PRACT_FOR_FACILITY_VW b where b.OPERATING_FACILITY_ID = '"+facility_id+"' and b.EFF_STATUS = 'E' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ";
				
				var sqlSecond="select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(a.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee') job_title, decode(a.gender,'M','Male','F','Female','U','Unknown') gender, b.primary_speciality_desc primary_specialty from am_practitioner a,  AM_PRACT_FOR_FACILITY_VW b where b.OPERATING_FACILITY_ID = '"+facility_id+"' and b.EFF_STATUS = 'E' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name)) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ";

				var speciality="";

				if(document.forms[0].speciality_code!=null)
					speciality=document.forms[0].speciality_code.value;
				
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + target.name + "\"";
				xmlStr += " practName_FValue=\"" + target.value + "\"";
				xmlStr += " sql=\"" +escape(sql)+"\"";
				xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
				xmlStr += " practitioner_type=\"" + "" + "\"";
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

				return;

				
			}
			

			var retVal=CommonLookup(tit,argumentArray);
			
			if(retVal ==null || retVal=="" || !retVal)
			{
				target.value="";
				target_id.value="";
			}
			else
			{
				target_id.value=retVal[0];
				target.value=retVal[1];
			}
			

	}

	
	
	function PractLookupRetVal(retVal,objName)
	{

		var arr;

		if (retVal != null && trimString(retVal) != "")
		{
			arr=retVal.split("~");
		
			document.forms[0].practitioner_id.value=arr[0];
			document.forms[0].practitioner_name.value=arr[1];			
		
		
		}
		else
		{
		
			document.forms[0].practitioner_id.value="";		document.forms[0].practitioner_name.value="";			
		
			
		}
	
	}

	
	<%-- Code added/modified by Tushar .T. Bhat on 06-Feb-04 ends --%>


    function addOrderByCol() {
        var from = document.getElementById("item")("OrderbyCols");
        if ( from.options.length > 0 ) {
            var to = document.getElementById("item")("OrderbyColumns");
            var element = document.createElement("OPTION");
            element.text = from.options[from.selectedIndex].text;
            element.value= from.options[from.selectedIndex].value;
            to.add(element);
            from.remove(from.selectedIndex);
        }
    }

    function removeOrderByCol() {
        var from = document.getElementById("item")("OrderbyColumns");
        if ( from.options.length > 0 ) {
            var to = document.getElementById("item")("OrderbyCols");
            var element = document.createElement("OPTION");
            element.text = from.options[from.selectedIndex].text;
            element.value = from.options[from.selectedIndex].value; to.add(element);
            from.remove(from.selectedIndex);
        }
    }

    function SelectAll() {
        var i = 0; document.getElementById("OrderbyColumns").selectedIndex=0;
        while ( i < document.getElementById("OrderbyColumns").length) {
            document.getElementById("OrderbyColumns").options[i].selected=true;
            i++;
        }
    }

    function execQuery() {
//        SelectAll();
        query_form.submit();
        var date_from = query_form.date_from.value;
        var date_to = query_form.date_to.value;
		var speciality_code = query_form.speciality_code.value;
        var service_code = query_form.service_code.value;
        var clinic_code = query_form.clinic_code.value;
        var practitioner_id = query_form.practitioner_id.value;

		parent.frames[1].location.href="../../eOP/jsp/QueryResultFollowuponLastVisits.jsp?date_from="+date_from+"&date_to="+date_to+"&speciality_code="+speciality_code+"&service_code="+service_code+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id;
    
	query_form.search.disabled=true;
	}

    function chkk(obj)
    {
		
        if(obj.value !='')
		{
			if(CheckDate(obj)){
		var bool=doDateCheckAlert(parent.frames[0].document.forms[0].date_from,parent.frames[0].document.forms[0].date_to);
        if(!bool){
			alert(getMessage("TO_DT_GR_EQ_FM_DT"));
            obj.select();
			obj.focus();
		}
			}
		}
	}

    function clearform()
    {
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		}*/

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="query_form" id="query_form" action="../../eOP/jsp/QueryResultFollowuponLastVisits.jsp" method="post" onSubmit="SelectAll()" target='query_result'>
<table width='100%' align='center' cellpadding='0' cellspacing='0' border='0'>
    <tr>
        <td width='100%'>
            <table width="100%" align="center" cellpadding='0' cellspacing='0' border='0'>
                <tr>
                    <td width="20%" class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
                    <td width="30%" class='fields'>
                    <%
                        try
                        {
                            stmt=con.createStatement();
                            sql="select to_char(sysdate,'dd/mm/yyyy') from dual";
                            rset=stmt.executeQuery(sql);
                            if(rset!=null)
                            {
                                if(rset.next())
                                {
                                    dte=rset.getString(1);
                                }
                            }
                        }
                        catch(Exception e){out.print(e);}
                        finally
                        {
                            if(stmt!=null)      stmt.close();
                            if(rset!=null)      rset.close();
                        }

						dte_display=DateUtils.convertDate(dte,"DMY","en",locale);
                    %>
				<input type="text" id='date_from' name ="date_from" size="10" maxlength="10" value="<%=dte_display%>" onblur="validDateObj(this,'DMY',localeName);" ><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('date_from');" style="cursor='hand'"></img></td>

				<td width="20%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td width="30%" class='fields'><input type="text" id='date_to' name ="date_to" maxlength="10" size="10" value="<%=dte_display%>"  onblur="validDateObj(this,'DMY',localeName);"><img  src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('date_to').focus();return showCalendar('date_to');" style="cursor='hand'"></img></td>
				</tr>
				<tr>
				<td class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id ="speciality_desc" name ="speciality_desc" maxlength="15" size="15" onBlur="searchValues(speciality_code,speciality_desc)">
				<input type='button' class='button'  name='speciality_button' id='speciality_button' value='?' onclick="searchValues(speciality_code,speciality_desc)">
				<input type='hidden' name='speciality_code' id='speciality_code' value=''></td>

				<td  class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td  class='fields'><input type="text" name ="service_desc" id ="service_desc" maxlength="15" size="15" onBlur="searchValues(service_code,service_desc)">
				<input type='button' class='button'  name='service_button' id='service_button' value='?' onclick="searchValues(service_code,service_desc)">
				<input type='hidden' name='service_code' id='service_code' value=''></td>
				</tr>
				<tr>
				<td  class="label"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
				<td  class='fields'><input type="text" name ="clinic_name" id ="clinic_name" size="15" maxlength="15" onBlur="searchValues(clinic_code,clinic_name)">
				<input type='button' class='button'  name='clinc_button' id='clinc_button' value='?' onclick="searchValues(clinic_code,clinic_name)">
				<input type='hidden' name='clinic_code' id='clinic_code' value=''></td>

				<td class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name ="practitioner_name" id ="practitioner_name" maxlength="30" size="30" onBlur="searchValues(practitioner_id,practitioner_name)">
				<input type='button' class='button'  name='pract_button' id='pract_button' value='?' onclick="searchValues(practitioner_id,practitioner_name)">
				<input type='hidden' name='practitioner_id' id='practitioner_id' value=''></td>
		</tr>

		<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='pat_id' id='pat_id' size='20' onKeyPress="return(CheckForSpecChars(event))" maxlength='<%=pid_length%>'>
			<input type='button' class='button' name='patbutton' id='patbutton' value='?'  onclick='patqry()'></td>
			<td class="label"><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></td>
			<td class='fields'  width='25%'><input type='text' name='created_by' id='created_by' onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' maxlength='30' onBlur='GetCancellLookupBlur(this);'>
			<input type='hidden' name='user' id='user' size='40' maxlength='30' value='' readonly>
			<input type='button' class='BUTTON' value="?"  name='cancel_search' id='cancel_search'onclick='GetCancellLookup(created_by)' ></td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
			<td class='fields'  width='25%'><input type="text" id='visit_date' name ="visit_date" size="10" maxlength="10" value="" onblur="validDateObj(this,'DMY',localeName);validDt(this);" ><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visit_date');" style="cursor='hand'"></img></td>
		</tr>
		<tr>
         			<td colspan=3>&nbsp;</td>
					<td class='fields'>
					<input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onclick='execQuery();'>
					<input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearform()'>
					<input type='hidden' name='defdate' id='defdate' value="<%=dte%>"></td>
        </tr>
        </td>
    </tr>
</table>

    <input type='hidden' name='facility_id' id='facility_id' value='<%=operating_facility_id%>'>				
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>	
	<input type='hidden' name='sys_dt' id='sys_dt' value='<%=dte%>'>	

</form>
</body>
<%
}
catch(Exception e) {out.println(e);}
finally
{
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</html>



