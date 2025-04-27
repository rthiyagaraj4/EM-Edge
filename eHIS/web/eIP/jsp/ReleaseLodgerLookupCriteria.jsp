<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
	String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		
 %>
<html>
    <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
// To get the Available Nursing Unit.
async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID)
{
	var nursingUnit = aNursingUnit.value;
	var facilityId	= aFacilityId;
	var loginUserId	= aLoginUser;
	var	operStnID	= pOperStnID;
	var locale      = document.forms[0].locale.value;
	var call_function			= document.forms[0].call_function.value

	var retVal =    new String();
	
	/*var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	sql=" select a.nursing_unit_code code,a.short_desc description from IP_NURSING_UNIT_LANG_VW  a, AM_OS_USER_LOCN_ACCESS_VW b where a.language_id='"+locale+"' and a.facility_id  like ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and a.eff_status = 'E' and b.locn_type = 'N' and b.oper_stn_id  like ? and b.appl_user_id  like ? and check_lodger_yn ='Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";
*/

	var tit						= getLabel("Common.nursingUnit.label","Common");
	/*var dialogHeight			= "41" ;
	var dialogWidth				= "65" ;*/
	var dialogHeight        = "600px" ;
    var dialogWidth         = "1000px"; 
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnit)+"&login_user="+loginUserId+"&oper_id="+operStnID+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&patientclass=&call_function="+call_function+"&&bkg_type=";

/*
	
	dataNameArray[0]	= "a.facility_id" ;
	dataValueArray[0]	= facilityId;
	dataTypeArray[0]	= STRING ;
	
	dataNameArray[1]	= "b.oper_stn_id" ;
	dataValueArray[1]	= operStnID;
	dataTypeArray[1]	= STRING ;
	
	dataNameArray[2]	= "b.appl_user_id" ;
	dataValueArray[2]	= loginUserId;
	dataTypeArray[2]	= STRING ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "4, 5";
	argumentArray[5] = nursingUnit;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	var tit=getLabel("Common.nursingUnit.label","Common");

	retVal = await CommonLookup( tit, argumentArray );
*/
	retVal =  await window.showModalDialog(jsp_name,arguments, features);
		
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split("~");
		//arr=ret1.split(",");
		document.forms[0].nursing_unit.value		= arr[0];		
		document.forms[0].nursing_unit_desc.value	= arr[1];
	    document.forms[0].nursing_unit_desc.focus();
	}
	else
	{
		document.forms[0].nursing_unit.value		= "";		
		document.forms[0].nursing_unit_desc.value	= "";
	}
} // End of getNursingUnit().
// By Annadurai 2/10/2004 ends.

async function callPatientSearch()
{
	var patient_id	= await PatientSearch();
	if((patient_id != null))
	{
		document.forms[0].name.value =patient_id;
	}
}

function submitPage()
{
	var condition=""
	for(var i=0; i<document.forms[0].elements.length; i++)
	{
		condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&";
	}

   var call_function = document.forms[0].call_function.value;
   
	if(call_function == 'RENEW_GATE_PASS')
	{
	           //Code changes starts by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
	            var chk_status = document.getElementById("loc_lang").status; 
				if(chk_status ==true)	
			    {
					document.forms[0].loc_lang.value='th';
			    }
		//Code changes ends by Srinivas YN For SRR20056-SCF-7177 [IN:027133] on 19/09/2011
		parent.f_query_add_mod.location.href="../jsp/RenewGatePassLookupResult.jsp?function_id=<%=function_id%>&"+condition;
	
	}
	else
	{
		parent.f_query_add_mod.location.href="../jsp/ReleaseLodgerLookupResult.jsp?function_id=<%=function_id%>&"+condition;
	}
}


function popDynamicValues(obj){}


function clearAll()
{
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	document.forms[0].search.disabled=false;
}  

async function NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID)
{
	var msg="";
	var locale      = document.forms[0].locale.value;
	var Facility_ID				=	"`"+Facility_ID+"`";
	var Login_User				=	"`"+Login_User+"`";
	var Operator_Station_ID		=	"`"+Operator_Station_ID+"`";

	var target					= document.forms[0].nursing_unit_desc;
	var retVal					=    new String();
	var dialogTop				= "40";
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var features				= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments				= "" ;
	var sql						= "";
	var search_desc				= "";
	var tit						= "";

	sql=" select a.nursing_unit_code, a.short_desc from IP_NURSING_UNIT_LANG_VW a, AM_OS_USER_LOCN_ACCESS_VW b where a.language_id='"+locale+"' and a.facility_id="+Facility_ID+" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and a.eff_status = 'E' and b.locn_type = 'N' and  b.oper_stn_id="+Operator_Station_ID+" and b.appl_user_id="+Login_User+" and b.check_lodger_yn=`Y` "; 

	search_code="a.nursing_unit_code";
	search_desc="a.short_desc";
	tit=getLabel("Common.nursingUnit.label","Common");
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array();

	if (!(retVal == null))
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		
		document.forms[0].nursing_unit_desc.value	= arr[0];
		document.forms[0].nursing_unit.value		= arr[1];
		document.forms[0].nursing_unit_desc.focus();
	}
	else
	{
		document.forms[0].nursing_unit_desc.value	= '';
		document.forms[0].nursing_unit.value		= '';
		target.focus();
	}
}


function DateCompare(from,to) 
{
	if(from.value != '' && to.value != '')
	{
		if(validDate(from.value,"DMY",localeName) && validDate(to.value,"DMY",localeName))
		{
			var fromDt	= convertDate(from.value,"DMY",localeName,"en");
			var toDt	= convertDate(to.value,"DMY",localeName,"en");
			if(!isBefore(fromDt,toDt,'DMY',localeName))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.value='';
				document.forms[0].to_date.select();
			}
		}
	}
}

</script>

<%
	String func = checkForNull(request.getParameter("function_id"));
	String LodgerType = "";
	if(func.equals("CHECK_OUT_LODGER"))
	{
		LodgerType = "L"; // Lodger
	}
	else if(func.equals("CHECK_OUT_ACCMP_PERSON"))
	{
		LodgerType = "A"; // Accompanying Person
	}

	String PageVal = "";
	if(func.equals("RENEW_GATE_PASS"))
		PageVal="GatePass";
	else
		PageVal="";

	String facility_id		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String p_oper_stn_id	= checkForNull(request.getParameter("oper_stn_id"));
	String patIDLength	= checkForNull(request.getParameter("patIDLength"));
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	
	//String patIDLength	= "";
	try
	{
		con = ConnectionManager.getConnection(request);	
		if(patIDLength.equals(""))
		{
		StringBuffer patIdLengthSql = new StringBuffer();
		patIdLengthSql.append("select PATIENT_ID_LENGTH from mp_param ");
		stmt = con.createStatement();
		rs = stmt.executeQuery(patIdLengthSql.toString());
		if(rs.next())
			patIDLength = rs.getString(1);
		}

	%>
	</head>
	<body onLoad="FocusFirstElement();" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name='ReleaseLodgerCriteria_Form' id='ReleaseLodgerCriteria_Form' action='../jsp/ReleaseLodgerLookupResult.jsp' target='ReleaseBed_details' >
	<table cellspacing=2 cellpadding=0 align='center' width='100%' border='0'>
			
		
			<%if(!func.equals("CHECK_OUT_LODGER") && !func.equals("CHECK_OUT_ACCMP_PERSON") && !PageVal.equals("GatePass")) {%>
					
			<tr>
				<td nowrap width='22%' class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
				<td width='25%' class='fields' nowrap><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 onChange="getNursingUnit(this,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');"  ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=hidden name="nursing_unit" id="nursing_unit" onChange=''></td>
			<%}%>

			<%if(PageVal.equals("GatePass")){%>

			<tr>
				<td nowrap width='22%' class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
				<td width='25%' class='fields' nowrap><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 onChange="getNursingUnit(this,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');"  ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=hidden name="nursing_unit" id="nursing_unit" onChange=''></td>
					
				<td class='label' width='23%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					
				<td width='28%' class='fields' nowrap><input type='text' maxlength='<%=patIDLength%>' size='20' name='name' value="" onKeyPress='return CheckForSpecChars(event)' onBlur="makeValidQueryCriteria(this);"><input type=button class=button name=lodger_butt id=lodger_butt value="?" onClick="callPatientSearch()"></td>

		</TR>
		
		<TR>
			
				<td class='label' width='24%' nowrap><fmt:message key="eIP.ChkdInDt.label" bundle="${ip_labels}"/></td>
					
				<td width='25%' class='fields' nowrap ><input type='text' id='blockfrom' maxlength='10' size='10' name='from_date' id='from_date' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(this, to_date);' value='' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="from_date.focus();return showCalendar('blockfrom');"/>&nbsp;-&nbsp;<input type='text' id='blockto' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(from_date,this);' maxlength='10' size='10' name='to_date'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="to_date.focus();return showCalendar('blockto');"/></td>
					
				<TD class='label' width='25%' nowrap >&nbsp;</td>
				<TD class='label' width='25%' nowrap >&nbsp;</td>
					
			</tr>



		<table cellspacing=1 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td  class='COLUMNHEADER'><fmt:message key="eIP.AccompanyingPersonDetails.label" bundle="${ip_labels}"/></th>
			</tr>
		</table>	
		
	<table cellspacing=1 cellpadding=0 align='center' width='100%' border='0'>
			
		<tr>
			<td>
			<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="patient_id"   value= "" />
				<jsp:param name ="alert_reqd_yn"   value= ""  /> 
			</jsp:include>	
			</td>
		</tr>
			
		<tr ><td>
			<jsp:include page="IPPatientDetailCriteria.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="function_id"   value= "RENEW_GATE_PASS"  /> 
			</jsp:include></td>
		</tr>

	</table>	


			<%}else if(func.equals("CHECK_OUT_LODGER"))
			{	%>

			<tr>
				
				<td nowrap width='25%' class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
				<td width='25%' class='fields' nowrap><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 onChange="getNursingUnit(this,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');"  ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=hidden name="nursing_unit" id="nursing_unit" onChange=''></td>


				<td class='label'width='25%' ><fmt:message key="eIP.LodgerPersonID.label" bundle="${ip_labels}"/></td>
				
				<td  class='fields' width='25%' ><input type='text' maxlength='<%=patIDLength%>' size='20' name='name'  value="" onKeyPress='return CheckForSpecChars(event)' onBlur="makeValidQueryCriteria(this);"><input type=button class=button name=lodger_butt id=lodger_butt value="?" onClick="callPatientSearch()"> </td></tr>
				

			<%}else if(func.equals("CHECK_OUT_ACCMP_PERSON"))
			{	%>
		
			<tr>
				<td nowrap width='25%' class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
				<td width='25%' class='fields' nowrap><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 onChange="getNursingUnit(this,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');"  ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" ><input type=hidden name="nursing_unit" id="nursing_unit" onChange=''></td>


				<td class='label' width='25%' ><fmt:message key="eIP.AccompanyingPersonID.label" bundle="${ip_labels}"/></td>

				<td  class='fields' width='25%' ><input type='text' maxlength='<%=patIDLength%>' size='20' name='name'  value="" onKeyPress='return CheckForSpecChars(event)' onBlur="makeValidQueryCriteria(this);"><input type=button class=button name=lodger_butt id=lodger_butt value="?" onClick="callPatientSearch()"> </td></tr>
				
				

			<%}%>
			
			
			
				
			<%if(func.equals("CHECK_OUT_ACCMP_PERSON"))
			{	%>
			
	
		
		<tr>
		
				<td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				
				<td width='25%' class='fields' nowrap><input type='text' maxlength='<%=patIDLength%>' size='20' name='lodger_id'  value="" onKeyPress='return CheckForSpecChars(event)' onBlur="makeValidQueryCriteria(this);"><input type=button class=button name=pat_button id=pat_button value="?" onClick="callPatientSearch()"></td>

				<td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					
				<td width='25%' class='fields' nowrap><select name='gender' id='gender' tabIndex='0'>
						<option value=''selected>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						</select>
				</td>
		</tr>

		<tr>

				<td class='label' width='25%'><fmt:message key="eIP.ChkdInDt.label" bundle="${ip_labels}"/></td>
					
				<td width='25%' class='fields' nowrap><input type='text' id='blockfrom' maxlength='10' size='10' name='from_date' id='from_date' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(this, to_date);' value='' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="from_date.focus();return showCalendar('blockfrom');"/>&nbsp;-&nbsp;<input type='text' id='blockto' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(from_date,this);' maxlength='10' size='10' name='to_date'><img src="../../eCommon/images/CommonCalendar.gif" onClick="to_date.focus();return showCalendar('blockto');"/></td>

				<td class='label' width='25%'>&nbsp;</td>
				<td  class='label'>
				
				<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'><input type="hidden" name="PageValue" id="PageValue" value="<%=PageVal%>">
				<input type="hidden" name="call_function" id="call_function" value="<%=func%>">
				</td>
		</tr>

			<%}else{%>
				
				
			
			<%}%>

		
</table>

	

<table cellspacing=2 cellpadding=0 align='center' width='100%' border='0'>
<%	if(PageVal.equals("GatePass"))
	{	%>
			
<%	}
	else
	{	
%>		<input type="hidden" name="lodger_type" id="lodger_type" value="<%=LodgerType%>">
<%	}	%>

<%	
	if(PageVal.equals("GatePass"))
	{	
%>
		<td  colspan='4' class='white' align='right'><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'><input type="hidden" name="PageValue" id="PageValue" value="<%=PageVal%>"><input type="hidden" name="call_function" id="call_function" value="<%=func%>">
			</td>
		</tr>
<%	}	
	if(!PageVal.equals("GatePass") && !func.equals("CHECK_OUT_ACCMP_PERSON") )
	{	
%>
		<td class='label' width='25%'><fmt:message key="eIP.ChkdInDt.label" bundle="${ip_labels}"/></td>
	
		<td class='fields' class='label' width='25%'><input type='text' id='blockfrom' maxlength='10' size='10' name='from_date' id='from_date' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(this, to_date);' value='' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="from_date.focus();return showCalendar('blockfrom');"/>&nbsp;-&nbsp;<input type='text' id='blockto' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(from_date,this);' maxlength='10' size='10' name='to_date'><img src="../../eCommon/images/CommonCalendar.gif" onClick="to_date.focus();return showCalendar('blockto');"/></td>	
			
		<td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			
		<td class='fields' class='label' width='25%' ><select name='gender' id='gender' tabIndex='0'>
			<option value=''selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			</select>
		</td>

	</tr>

	<tr>
			<td  colspan='4' class='white' align='right'>
			<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'><input type="hidden" name="PageValue" id="PageValue" value="<%=PageVal%>">
			<input type="hidden" name="call_function" id="call_function" value="<%=func%>">
			</td>		
	</tr>
<%	}	%>
		
	   </table>
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
<%
	}catch (Exception e)
	{
		out.println("Error in Query " + e);
	}
	finally
	{
			if (rs!=null)		rs.close();
			if (stmt!=null)		stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

