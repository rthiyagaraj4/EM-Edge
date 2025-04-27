<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8"); 
    String p_report_id      = "OPBWTDTL" ;
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id"); //Added by Ashwini on 20-Mar-2019 for TBMC-SCF-0056
	String locale=(String)session.getAttribute("LOCALE");

%>
<html>
<HEAD>
<SCRIPT>
/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				obj.select();	
				alert(getMessage("INVALID_DATE_FMT","SM"));
				return false;
			}
			else
				return true;
		}
}*/

/*Modified by Ashwini on 20-Mar-2019 for TBMC-SCF-0056*/
async function searchCodeClk(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var facilityid = "<%=p_facility_id%>";
	var locale="<%=locale%>";
	var tit="";

	
	if(obj.name=="location")
	{
		tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
		//sql="select clinic_code, short_desc, facility_id from op_clinic";
		sql="select clinic_code, long_desc, facility_id from op_clinic_lang_vw where language_id=`"+locale+"`";
		search_code="clinic_code";
		search_desc= "long_desc";
		
	}			

	if(obj.name=="pract1")
	{
		tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
		//sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner";
		sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where language_id=`"+locale+"`";
		search_code="PRACTITIONER_ID";
		search_desc= "PRACTITIONER_NAME";
				
	}			
if(obj.name=="pract2")
	{
		tit=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
		//sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner";
		sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where language_id=`"+locale+"`";
		search_code="PRACTITIONER_ID";
		search_desc= "PRACTITIONER_NAME";
		
	}		
	
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

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

/*Added by Ashwini on 20-Mar-2019 for TBMC-SCF-0056*/
async function searchCode(obj,target)
{
	var p_faclid	= VisitByStatus_form.p_facility_id.value;
	var p_usr		= VisitByStatus_form.p_user_name.value;
	var p_resp		= VisitByStatus_form.p_resp_id.value;
	var tit = "";
	var speciality = "";
	var locale = "<%=localeName%>";

	target.value=trimString(target.value);
	
	if(target.value == "" && window.event.target == target)
	return;
	
	var argumentArray = new Array(8);
	
	if(obj.name=="fmLocation" || obj.name=="toLocation")
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
	else
	{				
		if(obj.name=="pract1")
		{
			if(document.forms[0].p_fm_specialty_code)
				speciality=document.forms[0].p_fm_specialty_code.value;
		}
		else
		{
			if(document.forms[0].p_to_specialty_code)
				speciality=document.forms[0].p_to_specialty_code.value;
		}
				
		getPractitioner(obj,target,'',speciality,'','','','','','',"Q2");

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
	
		if(objName=="fm_practitioner_id")
			document.forms[0].fm_practitioner_id.value=arr[0];
		else
			document.forms[0].to_practitioner_id.value=arr[0];				
	}
	else
	{
		if(objName=="fm_practitioner_id")
			document.forms[0].fm_practitioner_id.value="";
		else
			document.forms[0].to_practitioner_id.value="";				
	}
}
/*End TBMC-SCF-0056*/

async function SpecialityCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	var locale = "<%=localeName%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	return;
	var argumentArray=new Array(8);
          tit=getLabel("Common.speciality.label","Common");
		argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
       			argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
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



</SCRIPT>

<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<!-- <script src="../../eOP/js/repWaitTimeDetails.js" language="javascript"></script>
 --><script src="../../eCommon/js/common.js" language="javascript"></script>
 <!--Added by Ashwini on 20-Mar-2019 for TBMC-SCF-0056-->
 <script src="../../eOP/js/OPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br><br><br>
<%//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
    Connection con  =null; 
    String isSpltyNurUnitToEnableYNAppl="";
	Boolean displayQueueStatus=false;  
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);	
	displayQueueStatus = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "OP_REPORT_QUEUE_STATUS");//Maheshwaran K added for ML-MMOH-CRF-1956 as 03-11-2022
    }
	 catch(Exception e){out.println(e);}
	 finally
	 {		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

%>
<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>


<tr>
<td width='33%'>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class="label"> <fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text  id='mdsfrom' name='fm_date' id='fm_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img>
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
	<td class='fields'><input type=text id='mdsto'  name='to_date' id='to_date' size="10" maxlength="10" align="left" onBlur='validDateObj(this,"DMY",localeName);'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
	
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="fm_locn_code" id="fm_locn_code" size="4" maxlength="4" <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>onBlur='searchCode(fmLocation, this)'<%}%>><input type='button' value='?' class='button' <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>name='fmLocation' onclick='searchCode(this, fm_locn_code)'<%}else{%>name='location' onclick='searchCodeClk(this, fm_locn_code)'<%}%>>
	</td>
	<td class='fields'><input type="text" name="to_locn_code" id="to_locn_code" size="4" maxlength="4" <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>onBlur='searchCode(toLocation, this)'<%}%>><input type='button' value='?' class='button' <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>name='toLocation' onclick='searchCode(this, to_locn_code)'<%}else{%> name='location' onclick='searchCodeClk(this, to_locn_code)'<%}%>>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="fm_practitioner_id" id="fm_practitioner_id" size="15" maxlength="15" <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>onBlur='searchCode(pract1, this)'<%}%>><input type='button' name='pract1' id='pract1' value='?' class='button' <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>onclick='searchCode(this, fm_practitioner_id)'<%}else{%>onclick='searchCodeClk(this, fm_practitioner_id)'<%}%>>
	</td>
	<td class='fields'>
	    <input type="text" name="to_practitioner_id" id="to_practitioner_id" size="15" maxlength="15" <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>onBlur='searchCode(pract2, this)'<%}%>><input type='button' name='pract2' id='pract2' value='?' class='button' <%if(!isSpltyNurUnitToEnableYNAppl.equals("N")){%>onclick='searchCode(this, to_practitioner_id)'<%}else{%>onclick='searchCodeClk(this, to_practitioner_id)'<%}%>>
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
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='SpecialityCode(this,p_fm_specialty_code)'><input type='button' name='fromspec' id='fromspec' value='?' class='button' onclick='SpecialityCode(this,p_fm_specialty_code)'>
	</td>	
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='SpecialityCode(this,p_to_specialty_code)'><input type='button' name='tospec' id='tospec' value='?' class='button' onclick='SpecialityCode(this,p_to_specialty_code)'>
	</td>
</tr><%}%>
<%
//Maheshwaran K added for ML-MMOH-CRF-1956 as 03-11-2022
if(displayQueueStatus){%>
<tr>
       <td class="label"><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></td>
       <td class='fields' colspan='2'><select name="p_queue_status" id="p_queue_status" >
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
			<option value ='01'><fmt:message key="Common.CheckedIn.label" bundle="${common_labels}"/></option>
		    <option value ='02'><fmt:message key="eOP.ArrivedAtNursingCounter.label" bundle="${op_labels}"/></option>
			<option value ='04'><fmt:message key="eOP.ConsultationStarted.label" bundle="${op_labels}"/></option>
			<option value ='07'><fmt:message key="Common.CheckedOut.label" bundle="${common_labels}"/></option>
</Select>
</td>
</tr>    
<%}%>
</table>

	<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=p_user_name %>">
		<input type="hidden" name="p_fm_date" id="p_fm_date"		    value="">
		<input type="hidden" name="p_to_date" id="p_to_date"		value="">
		<input type="hidden" name="p_fm_locn_code" id="p_fm_locn_code" 		value="">
		<input type="hidden" name="p_to_locn_code" id="p_to_locn_code" 		value="">
		<input type="hidden" name="p_fm_practitioner_id" id="p_fm_practitioner_id"		value="">
		<input type="hidden" name="p_to_practitioner_id" id="p_to_practitioner_id"		value=""> 
		<!--Added by Ashwini on 20-Mar-2019 for TBMC-SCF-0056-->
		<input type="hidden" name="p_resp_id" id="p_resp_id" value="<%=p_resp_id%>"></input>

		<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>
		
	
</form>
</body>
</center>

<br>
<br>
</html>

