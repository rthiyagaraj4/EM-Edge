<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.ConnectionManager,java.sql.Statement,java.sql.ResultSet,java.sql.Connection" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%
	Connection con 			= null;
	Statement  stmt			= null;
	ResultSet  rs 			= null;
	StringBuffer sbSql		= new StringBuffer();

	try
	{
		con = ConnectionManager.getConnection(request);
		String facilityID	= (String)session.getValue("facility_id");
		String loginUser	= (String)session.getValue("login_user");
		String jsp_name		= checkForNull(request.getParameter("jsp_name"));
		String win_height	= checkForNull(request.getParameter("win_height"));
		String win_width	= checkForNull(request.getParameter("win_width"));
		String call_function= checkForNull(request.getParameter("call_function"));
		String modal		= checkForNull(request.getParameter("modal"));
		String dialogTop	= checkForNull(request.getParameter("dialogTop"));
		String module		= checkForNull(request.getParameter("module"));
		String model_window	= checkForNull(request.getParameter("model_window"));
		String function_id	= checkForNull(request.getParameter("function_id"));
		String prog_id		= checkForNull(request.getParameter("prog_id"));
		String wherecondn	= checkForNull(request.getParameter("wherecondn"));
		String operstn		= checkForNull(request.getParameter("wherecondn"));
		String targetURL	= checkForNull(request.getParameter("targetURL"));
		String practitioner_id	= checkForNull(request.getParameter("practitioner_id"));
		String patient_id_length					= "";

		sbSql.append(" select a.oper_stn_id oper_stn_id, (select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b ");
		sbSql.append(" where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	");
		sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' ");
		sbSql.append(" and trunc(sysdate) between b.eff_date_from and ");
		sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");

		stmt = con.createStatement();
		rs = stmt.executeQuery(sbSql.toString());
		
		if(rs!=null)
		{
			while(rs.next())
			{
			
				patient_id_length = rs.getString("patient_id_length");
				operstn	= rs.getString("oper_stn_id");
				if(operstn == null) operstn ="";
			}
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

%>	
<script>


// Added by Sridhar on 2 FEB 2004
// These Function's will check for empty values before calling up the common lookup func..
function BeforeGetNursingUnit(obj1,obj2)
{
	if(document.forms[0].nursing_unit_desc.value != "")
		getNursingUnitValue(obj1,obj2);
	else
		document.forms[0].nursing_unit.value = "";
}

function BeforeGetSpecialtyValue(obj1,obj2)
{
	if(document.forms[0].specialty_desc.value != "")
		getSpecialtyValue(obj1,obj2);
	else
		document.forms[0].Splcode.value = "";
}
	

function compareDates(Obj)
{
	if(Obj.value != '')
	{
		if(validDateObj(Obj,"DMY", localeName))
		{
			if(document.forms[0].from_date.value!='' && document.forms[0].to_date.value!='')
			{
				var fromDt = convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
				var toDt = convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
				
				if(!isBefore(fromDt,toDt,'DMY','en'))// DateUtils.js
				{
					alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
					document.forms[0].to_date.select();
				}
			}
		}
	}
}

          
function clearAll()
{
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	if(parent.messageFrame)
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	document.forms[0].search.disabled=false;
}

function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Encounter ID";
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}
</script>
	
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
// By Annadurai 2/5/2004., starts.....
// To get the nursing unit using common lookup.
async function getNursingUnitValue(aNursingUnit, getFacilitID)
{
	var locale = document.forms[0].locale.value;
	var msg					= "";
	var facility_id			= getFacilitID;
	var loginUser			= '<%=loginUser%>';
	var operstn				= '<%=operstn%>';
	var target				= document.forms[0].nursing_unit_desc;
	var retVal				= new String();
	var sql					= "";
	var tit					= "";
	var wherecondn			= '<%=wherecondn%>';
	var retVal				= new String();
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	
	if (wherecondn.length>0)
	{
		if(wherecondn=='REVISE_LEAVE_YN')
		{
			sql = " select a.nursing_unit_code code, a.short_desc description from IP_NURSING_UNIT_LANG_VW a, AM_OS_USER_LOCN_ACCESS_VW b where a.language_id = '"+locale+"' and a.facility_id like ? and a.eff_status = 'E' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+operstn+"' and b.appl_user_id ='"+loginUser+"' and b."+wherecondn+" = 'Y' and a.patient_class='IP' and upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)  ";
		}
		else
		{
			sql = " select a.nursing_unit_code code, a.short_desc description from IP_NURSING_UNIT_LANG_VW a, AM_OS_USER_LOCN_ACCESS_VW b where a.language_id = '"+locale+"' and a.facility_id like ? and a.eff_status = 'E' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+operstn+"' and b.appl_user_id ='"+loginUser+"' and b."+wherecondn+" = 'Y' and upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?) ";
		}

		dataNameArray[0]	= "a.facility_id" ;
		dataValueArray[0]	= facility_id;
		dataTypeArray[0]	= STRING ;
		argumentArray[4] = "2, 3";
	}
	else if('<%=call_function%>'=="BedSideReferral")
	{
		sql = " SELECT locn_code code, b.short_desc description FROM AM_LOCN_FOR_OPER_STN a, IP_NURSING_UNIT_LANG_VW b where b.language_id = '"+locale+"' and oper_stn_id =(SELECT OPER_STN_ID FROM AM_USER_FOR_OPER_STN WHERE FACILITY_ID like ? AND appl_user_id='"+loginUser+"' AND eff_date_from <=SYSDATE AND NVL(eff_date_to,SYSDATE) >= SYSDATE) AND a.locn_type='N' AND a.locn_code=b.nursing_unit_code and upper(locn_code) like upper(?) and upper(short_desc) like upper(?) ";

		dataNameArray[0]	= "facility_id" ;
		dataValueArray[0]	= facility_id;
		dataTypeArray[0]	= STRING ;
		argumentArray[4] = "2,3";
	}
	else
	{
		sql = " Select nursing_unit_code code,short_desc description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and facility_id like ? and eff_status='E' and locn_type = 'N' and upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) ";

		dataNameArray[0]	= "facility_id" ;
		dataValueArray[0]	= facility_id;
		dataTypeArray[0]	= STRING;

		argumentArray[4] = "2, 3";
	} 
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[5] = aNursingUnit.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	search_code="nursing_unit_code";
	search_desc="short_desc";
	tit=getLabel("Common.nursingUnit.label","Common");
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].nursing_unit.value=arr[0];
		document.forms[0].nursing_unit_desc.value=arr[1];
	}
	else
	{
		document.forms[0].nursing_unit.value		= "";
		document.forms[0].nursing_unit_desc.value	= "";
	}
}

// To get the Specialty using common lookup.
async function getSpecialtyValue(aSpecialty, getFacilitID)
{
	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].specialty_desc;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;

	sql = " Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where language_id = '"+locale+"' and eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) ";
	tit=getLabel("Common.speciality.label","Common");
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aSpecialty.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].specialty_desc.value=arr[1];
	}
	else
	{
		document.forms[0].specialty_desc.value = "";
		document.forms[0].Splcode.value = "";
	}
}
 
function submitPage()
{
	var condition=""
	for(var i=0; i<document.forms[0].elements.length; i++)
	condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
		
	document.forms[0].search.disabled=true;
	oper_stn = document.forms[0].operstn.value;
	if(document.forms[0].modal.value == 'yes')
	{
		parent.frames[1].location.href= '../../eIP/jsp/ConfirmBedsideReferralQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y';
	}
	else
	{
		parent.frames[2].location.href= '../../eIP/jsp/ConfirmBedsideReferralQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y';
	}
}

function dateFromTo(Obj)
{
	var dateTo=Obj;
	var dateFrom=document.Inpatientlookup_Form.from_date;
	
	if(!doDateCheckAlert(dateFrom,dateTo))
	alert(getMessage('TO_DT_GR_EQ_FM_DT',"SM"));

}
			
function DisReset()
{
	if('<%=call_function%>' != 'rep')
	{
		if(parent.frames[0].document.getElementById("reset") != null)
			parent.frames[0].document.getElementById("reset").disabled=true; 
	}

	
}  
function popDynamicValues(obj)
{}

function clearlocations()
{
	document.getElementById("location0").value = '' ;
	var len=document.forms[0].location1.length;
	var i=1;
	while(i<len)
	{
	len=document.forms[0].location1.length
	document.forms[0].location1.remove(i)
	}
}

function clear_location(obj)
{
	var len=document.forms[0].location1.length;
	var i=1;
	while(i<len)
	{
		len=document.forms[0].location1.length
		document.forms[0].location1.remove(i)
	}

	var ref_to		=	"<%=facilityID%>";
	var sStyle		=	"<%=sStyle%>";
	var loc_type	=	obj;
	var specialty	=	document.forms[0].ref_speciality.value;
	var function_id =   "<%=facilityID%>";
	if((loc_type=='C') || (loc_type == 'D'))
	{
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/ValidateRenewPeriod.jsp?src1=populateLocation&field1=BedSideReferral&loc_type="+loc_type+"&ref_to="+ref_to+"&specialty="+specialty+"'></form></BODY></HTML>";

		parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[4].document.form1.submit();
	}
}

</script>
</head>
<body onLoad='FocusFirstElement();' onSelect="codeArrestThruSelect()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			
			<td   class='fields'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 onblur="BeforeGetNursingUnit(this, '<%=facilityID%>');"><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>');" ></td>
				
			<td  class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				
			<td  class='fields'><input type=text name=specialty_desc size=15  onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>');"><input type=hidden class=label name=Splcode size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>');"></td>
		
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
		<td   nowrap class='fields' width='25%'><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur='compareDates(this);'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_from.focus();return showCalendar('admn_date_from');"/> - <input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='compareDates(this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_to.focus();return showCalendar('admn_date_to');"/></td>
		<td class='label' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>
	</tr>
</table>	
		
		<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
        <tr>
		<td colspan='4' class="COLUMNHEADER"><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td>
		</tr>
	<tr>
				<td  class='label' width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'>

				<SELECT name="ref_speciality" id="ref_speciality" >
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>   

				<%
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					String sql = "";

				sql = " Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
				stmt=con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
	
				%>
					<option value= "<%=rs.getString("Speciality_Code")%>" > <%=rs.getString("Short_Desc")%> </option>
				<%
				}
				%>

				</SELECT>
				</td>

				
				<td class='label' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>

				<td class='fields'  width='310pt'>	
				<SELECT name="ref_priority" id="ref_priority">
				<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value="L" ><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
				<option value="U" ><fmt:message key="Common.semiemergency.label" bundle="${common_labels}"/></option>
				<option value="E" ><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
				</SELECT>
				</td> 

			</tr>

			<tr>
				<td class='label'   nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

				<td class='fields' nowrap>
				<SELECT name="location0" id="location0" onchange='clear_location(this.value)'>
				<option value="" >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value="D" ><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
				</SELECT>
														
				<SELECT name="location1" id="location1" >
				<option value="" align='center' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
				</SELECT>
				</td>

				<td class='label' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='fields' nowrap><jsp:include page="PractitionerComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>

			</tr>
		
			<tr>
				<td  class='label'><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
				<td class='fields' ><INPUT TYPE="text" name="ref_pref_date" id="ref_pref_date"  maxlength='10' size='10' onBlur='validDateObj(this,"DMY","<%=locale%>")'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].ref_pref_date.focus();return showCalendar('ref_pref_date');"/></td>
				<td class='label' nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
				<td align='left' nowrap ><input type="textbox" name="ref_id" id="ref_id" maxlength="14"></td>

			</tr>

			</table>
		<%
			String search = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels");
			String clear = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels");
		%>

			<table align='right' cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align='right' class='white'>
						<input type='button' name='search' id='search' value="<%=search%>" class='button' onclick='submitPage();'>
						<input type='button' name='clear' id='clear' value="<%=clear%>" class='button' onclick='clearAll()'>
					</td>
				</tr>
			</table>
	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
	<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='targetURL' id='targetURL' value="<%=targetURL%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='patient_id_length' id='patient_id_length' value="<%=patient_id_length%>" >
</form>
</body>
<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e)	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

