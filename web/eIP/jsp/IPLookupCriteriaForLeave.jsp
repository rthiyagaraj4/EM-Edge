<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%

	
	Connection con 			= null;
	Statement  stmt			= null;
	ResultSet  rs 			= null;
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	 
	String facility_id		= (String)session.getValue("facility_id");
	String p_oper_stn_id	= request.getParameter("oper_stn_id");;
	String loginUser		= (String)session.getValue("login_user");
	String jsp_name =request.getParameter("jsp_name");
	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";			
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";			
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";
	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String practitioner_id=request.getParameter("practitioner_id");
	if( practitioner_id == null) practitioner_id="";
	String wherecondn = request.getParameter("wherecondn");
	if(wherecondn == null) wherecondn ="";	
	String patient_id_length					= "";
	try{
	String sbSql = ("select patient_id_length  from mp_param where  module_id = 'MP' ");
	con=ConnectionManager.getConnection(request);
	stmt = con.createStatement();
		rs = stmt.executeQuery(sbSql);
		if(rs!=null)
		{
			while(rs.next())
			{
			patient_id_length = rs.getString("patient_id_length");
			
			}
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e){
	e.printStackTrace();
	}finally{
		if (con!= null) ConnectionManager.returnConnection(con,request);
	}
	
%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
// To get the Available Nursing Unit.
async function getNursingUnit(aNursingUnit, aFacilityId, aLoginUser, pOperStnID, wherecondn)
{
	var nursingUnit = aNursingUnit.value; 
	var facilityId	= aFacilityId;
	var loginUserId	= aLoginUser;
	var	operStnID	= pOperStnID;
	var splty_code=document.forms[0].Splcode.value;
	var pract_id="";
	var call_function =document.forms[0].call_function.value;
	var tit			= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnit)+"&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+loginUserId+"&oper_id="+operStnID+"&title="+encodeURIComponent(tit)+"&facility_id="+facilityId+"&call_function="+call_function;
	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	var arr=new Array();
	if(retVal != null && retVal != "" )
	{
		arr=retVal.split("~");
		document.forms[0].nursing_unit.value	=	arr[0];		document.forms[0].nursing_unit_desc.value	=	arr[1];
	    document.forms[0].nursing_unit_desc.focus();
	}
	else
	{
		document.forms[0].nursing_unit.value	=	"";		document.forms[0].nursing_unit_desc.value	=	"";
	}
}

function submitPage()
{
	
	var condition=""
	for(var i=0; i<document.forms[0].elements.length; i++)
			condition+= document.forms[0].elements[i].name +"="+ document.forms[0].elements[i].value+"&"
	
	var oper_stn = document.forms[0].operstn.value;
	document.forms[0].search.disabled=true;

	if(document.forms[0].modal.value == 'yes')
	{
	parent.frames[1].location.href= '../../eIP/jsp/IPLookupQueryResultForLeave.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn
	}
	else
	parent.frames[2].location.href= '../../eIP/jsp/IPLookupQueryResultForLeave.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn
}

function popDynamicValues(Obj){		}
		
function DisReset()
{
	if('<%=call_function%>' != 'rep')
		parent.frames[0].document.getElementById("reset").disabled=true; 
}

function clearForm()
{
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	document.forms[0].search.disabled=false;
}

// To get the Specialty using common lookup.
async function getSpecialtyValue()
{
	var target			= document.forms[0].Splcode_desc;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;

	sql = " Select speciality_code code,short_desc description from AM_SPECIALITY_LANG_VW where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) and language_id  = '"+locale+"' ";
	//sql = " Select speciality_code code,am_get_desc.AM_SPECIALITY(speciality_code,'"+locale+"',2) description from AM_SPECIALITY where eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?)  ";

	tit=getLabel("Common.speciality.label","Common");
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].Splcode_desc.value=arr[1];
	}
	else
	{
		document.forms[0].Splcode.value="";
		document.forms[0].Splcode_desc.value="";
	}
} 

function DateCompare(from,to) 
{
	if(from.value != '' && to.value != '' )
	{
		if(validDate(from.value,"DMY","en") && validDate(to.value,"DMY","en"))
		{
			var fromDt	= convertDate(from.value,"DMY",localeName,"en");
			var toDt	= convertDate(to.value,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date.select();
			}
		}
	}
}

function validSplchars1(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=getLabel("Common.encounterid.label","Common");
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
</head>
	<body onLoad= 'FocusFirstElement();' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
				<tr>
					<td  class='label' width="25%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					<td width="25%" class='fileds'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15 onChange="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>','<%=wherecondn%>');"  ><input type=button class=button name=nursing_unit_lookup value='?' onClick="getNursingUnit(nursing_unit_desc,'<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>','<%=wherecondn%>');" ><input type=hidden name="nursing_unit" id="nursing_unit" ></td>
					<td class='label' nowrap width="25%" ><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
					<td width="25%" class='fileds'><input type='text' maxlength='10' size='10' id='blockfrom'  name='from_date' id='from_date'  value='' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(this, to_date);'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('blockfrom');"> - <input type='text' value='' maxlength='10' size='10' id='blockto'  name='to_date' id='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");DateCompare(from_date, to_date);'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('blockto');"></td>

			   </tr>
			   <tr>
					<td  class='label' width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					<td class='fileds'><input type=text name='Splcode_desc' id='Splcode_desc' maxlength=15 size=15 onChange="getSpecialtyValue();"><input type=hidden name='Splcode' id='Splcode' ><input type=button name='Splcode_lookup' id='Splcode_lookup' value='?' class=button onClick="getSpecialtyValue();"></td>
					<td  class='label'  width="25%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
					<td class='fileds'>
						<jsp:include page="PractitionerComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
					</td>
				</tr>
				<tr>
					
					<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='2' class='fileds'><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>
					<td class='label' colspan='2'></td>
				</tr>

				<tr>
					<td colspan=4 class='fileds'>
						<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
					</td>
				</tr>	
			</table>
			<table align='right' border='0'>
				
					<tr>
					<td class='fileds'>
				
						
						<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage();'>
						<input type='button'  size="100" name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearForm();'>
				</td>
				</tr>
			</table>				
								
			
			
		<input type='hidden' name='jsp_name' id='jsp_name' value='<%=jsp_name%>' >
		<input type='hidden' name='win_height' id='win_height' value='<%=win_height%>' >
		<input type='hidden' name='win_width' id='win_width' value='<%=win_width%>' >
		<input type='hidden' name='param' id='param' value='<%=call_function%>' >	
		<input type='hidden' name='dialogTop' id='dialogTop' value='<%=dialogTop%>' >
		<input type='hidden' name='modal' id='modal' value='<%=modal%>' >
		<input type='hidden' name='module' id='module' value='<%=module%>' >
		<input type='hidden' name='model_window' id='model_window' value='<%=model_window%>' >
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
		<input type='hidden' name='call_function' id='call_function' value='<%=call_function%>' >
		<input type='hidden' name='prog_id' id='prog_id' value='<%=prog_id%>' >
		<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>' >
		<input type='hidden' name='wherecondn' id='wherecondn' value='<%=wherecondn%>' >
		<input type='hidden' name='operstn' id='operstn' value="<%=p_oper_stn_id%>" >
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='patient_id_length' id='patient_id_length' value="<%=patient_id_length%>" >
		</form>
	</body>
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

