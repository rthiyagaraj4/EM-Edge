<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.net.*,java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,javax.servlet.http.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	Statement  stmt				= null;
	ResultSet  rs 				= null;
	String nursing_unit_desc	= java.net.URLDecoder.decode(checkForNull(request.getParameter("nursing_unit_desc")),"UTF-8");
	String sql					= checkForNull(request.getParameter("sql"));   
	String facility_id			= checkForNull(request.getParameter("facility_id"));
	String nursingUnitCode		= checkForNull(request.getParameter("nursingUnitCode"));
	String bkg_type				= checkForNull(request.getParameter("bkg_type"));
	String clin_code			= checkForNull(request.getParameter("clin_code"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String open_location_yn		= checkForNull(request.getParameter("open_location_yn"));
	if(nursing_unit_desc.equals(""))
		nursing_unit_desc = nursingUnitCode;

	String splty_code			= checkForNull(request.getParameter("splty_cd"));
	String pract_id				= checkForNull(request.getParameter("pract_id"));
	String login_user			= checkForNull(request.getParameter("login_user"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_id"));
	String patient_class		= checkForNull(request.getParameter("patientclass"));
	String statics_yn			= checkForNull(request.getParameter("statics_yn"));
	String room_no				= checkForNull(request.getParameter("room_no"));
	String specilaty_code		= checkForNull(request.getParameter("specilaty_code"));
	String med_ser_grp			= checkForNull(request.getParameter("med_ser_grp_code"));
	// added for ICN-64475
	String applicable_to ="";
	if(call_function.equals("PatMovList"))
	applicable_to        = checkForNull(request.getParameter("applicable_to"));
	// added for ICN-64475 end


	// This variable is used for passing all the variables to result page.

	String strTmp = "&splty_cd="+splty_code+"&pract_id="+pract_id+"&login_user="+login_user+"&oper_id="+oper_stn_id+"&patientclass="+patient_class+"&facility_id="+facility_id+"&bkg_type="+bkg_type+"&clinic_code="+clin_code+"&statics_yn="+statics_yn+"&call_function="+call_function+"&open_location_yn="+open_location_yn+"&room_no="+room_no+"&specilaty_code="+specilaty_code+"&med_ser_grp="+med_ser_grp;
	

	if(call_function!=null && ( call_function.equals("RENEW_GATE_PASS") || call_function.equals("CHECK_OUT_ACCMP_PERSON") || call_function.equals("CHECK_OUT_LODGER")))
		bkg_type = "I";
		

	try
	{
		con				= ConnectionManager.getConnection(request);
		int codeCount	= 0;
		int descCount	= 0;
		String radioval = "desc";
		String descCountSql = " SELECT count(1) FROM IP_NURSING_UNIT WHERE eff_status LIKE 'E' AND facility_id = '"+facility_id+"' AND UPPER (short_desc) LIKE UPPER (NVL('"+nursingUnitCode+"%', short_desc)) ";
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		stmt = con.createStatement();
		rs = stmt.executeQuery(descCountSql);
		if(rs!=null)
		{
			while(rs.next())
			{
				descCount		= rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		if(descCount == 0)
		{
			String codeCountSql = " SELECT count(1) FROM IP_NURSING_UNIT WHERE eff_status LIKE 'E' AND facility_id = '"+facility_id+"' AND (UPPER (nursing_unit_code) LIKE UPPER (NVL('"+nursingUnitCode+"%', nursing_unit_code))) ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(codeCountSql);
			if(rs!=null)
			{
				while(rs.next())
				{
					codeCount		= rs.getInt(1);
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
		}

	if(codeCount > 0)
		radioval = "code";
	else if(descCount > 0)
		radioval = "desc";

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var radioval='<%=radioval%>';

function closew()
{
	parent.window.close();
}

//Calling result page
function CallDescFrame()
{
	var listval=document.getElementById("search_criteria").options.value;
	var txtbox=document.getElementById("search_text").value;
	parent.frames[1].location.href="../../eCommon/jsp/GeneralSearchResult.jsp?<%=request.getQueryString()%>&search_by="+radioval+"&search_criteria="+listval+"&search_text="+escape(txtbox);
 }

// maintaining which value was selected code or description
function storeVal(currad)
{
	radioval=currad.value;
}

// This function will be called on onload and search button click
function valtext(comp)
{
	if(comp)
		var sql	= "";
	else
		var sql	= "<%=sql%>";

	var rep1 = '';
	var rep2 = '';
	var nursing_unit_code = '';
	var nursing_unit_desc = '';

	if(comp)
	{
		if(radioval == 'code')
		{
			if(document.getElementById("nursing_unit_code"))
			nursing_unit_code = document.getElementById("nursing_unit_code").value;
			nursing_unit_desc = "";

			if(document.getElementById("nursing_unit_code"))
			document.getElementById("nursing_unit_code").value = "";
			if(document.getElementById("nursing_unit_desc"))
			document.getElementById("nursing_unit_desc").value="";

		}
		if(radioval == 'desc')
		{
			nursing_unit_code = "";
			nursing_unit_desc = document.getElementById("nursing_unit_desc").value;

			document.getElementById("nursing_unit_desc").value="";
		}
	}	
	else
	{
		if(radioval == 'code')
		{
			if(document.getElementById("hdd_nursing_unit_code"))
			nursing_unit_code = document.getElementById("hdd_nursing_unit_code").value;
			nursing_unit_desc = '';
		}
		else if(radioval == 'desc')
		{
			nursing_unit_code = '';
			nursing_unit_desc = document.getElementById("nursing_unit_desc").value;
		}
	}

	var start_ends_contains	=document.getElementById("start_ends_contains").value;

// added for ICN-64475	
var applicable_to_hidd=document.getElementById("applicable_to_hidd").value;
if(applicable_to_hidd=="DC" && "<%=call_function%>" == "PatMovList")
{
document.getElementById("applicable_to").options(1).selected=true;
document.getElementById("applicable_to_hidd").value="";
}
// added for ICN-64475 end	
	var appl_to	=	document.getElementById("applicable_to").value;
	var facility_id  = "<%=facility_id%>";
	var tmpVar		 = "<%=strTmp%>";


	var url = "../../eIP/jsp/GeneralNursingUnitSearchResult.jsp?"+tmpVar+"&search_code=nursing_unit_code&search_desc=short_desc&start_ends_contains="+start_ends_contains+"&radioval="+radioval;
	rep1 = "and A.nursing_unit_code like upper(?) ";
	rep2 = "and upper(B.SHORT_DESC) like upper(?) ";
	url = url + "&applicable_to="+appl_to;

	if(nursing_unit_code == "")
	{
		url = url + "&nursing_unit_code="+nursing_unit_code;
		url = url + "&nursing_unit_desc="+nursing_unit_desc;
	}
	else if(nursing_unit_desc == "")
	{
		url = url + "&nursing_unit_desc="+nursing_unit_desc;
		url = url + "&nursing_unit_code="+nursing_unit_code;
	}

	url = url.replace('$',rep2+rep1);
	parent.frames[1].location.href=url;
}

//To clear all the values in criteria page
function on_Clear()
{
	if(radioval == 'code')
	{
		if(document.getElementById("nursing_unit_code"))
			document.getElementById("nursing_unit_code").value="";
		else if(document.getElementById("hdd_nursing_unit_code"))
			document.getElementById("hdd_nursing_unit_code").value="";

		//document.getElementById("nursing_unit_desc").value="";
	}
	if(radioval == 'desc')
		document.getElementById("nursing_unit_desc").value="";

	document.getElementById("start_ends_contains").options[0].selected=true;
	document.getElementById("start_ends_contains").disabled=true;
	parent.frames[1].location.href ='../../eCommon/html/blank.html';
}

function enableSEC()
{
	document.getElementById("start_ends_contains").disabled=false;
}

//Selected code or desc criteria like end with, start with or contains
function valSearch()
{
	if(radioval == 'code')
	{
		document.getElementById("search_text").innerHTML = "<input type='text'  name='nursing_unit_code' id='nursing_unit_code' maxlength='4' size='15'><select name='start_ends_contains' id='start_ends_contains'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select>";

	}
	else if(radioval == 'desc')
	{
		document.getElementById("search_text").innerHTML = "<input type='text' name='nursing_unit_desc' id='nursing_unit_desc' onkeypress='enableSEC();' value='<%=nursing_unit_desc%>' maxlength='15' size='15'><select name='start_ends_contains' id='start_ends_contains'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select>";

		
	}
}
</script>

</head>
<body onload='valtext();' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='general_search_criteria' id='general_search_criteria'>
<input type="hidden" name="applicable_to_hidd" id="applicable_to_hidd" value="<%=applicable_to%>"> <!-- added for ICN-64475 -->
<table   border="0" width='100% 'cellspacing='0' cellpadding='0'>
	<tr width='100'>
		<td class="label" ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td class="fields" colspan=3 nowrap><input type='radio' name= 'search_by' value='code' onClick='storeVal(this);valSearch()'><fmt:message key="Common.code.label" bundle="${common_labels}"/><input type='radio' name= 'search_by' value='desc' checked onClick='storeVal(this);valSearch()'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	</tr>
	<tr width='100'>
		<td class="label" nowrap ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td class= "fields" id='search_text'><input type='text'  name='nursing_unit_desc' id='nursing_unit_desc' onkeypress='enableSEC();' value="<%=nursing_unit_desc%>" maxlength='15' size='15'><select name='start_ends_contains' id='start_ends_contains'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select></td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;<input type="hidden" value="" name="hdd_nursing_unit_code" id="hdd_nursing_unit_code"></td></td>
	</tr>

<%

if(radioval.equals("code"))
{	%>	
	<script>
	document.forms[0].hdd_nursing_unit_code.value ="<%=nursingUnitCode%>";
	document.getElementById("search_by").value ='code';
	document.getElementById("search_by")[0].checked = true;
	</script>
<%	}	%>
	<tr width='100'>
	<td class="label" nowrap ><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
	<td class="fields" id='appl_to' ><select name='applicable_to' id='applicable_to'><option value='IP'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
		
	<%if(bkg_type.equals("D")){%>
	<option value='DC' selected><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
	<%}else{%>	
	<option value='DC'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
	<%}%>
	<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></select></td>
	<td class="fields" >&nbsp;</td>
	<td class="fields"><input type="button"  name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onclick="valtext(true);" class='button' >
	<input type="button"   name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" class='button'  onClick="on_Clear(); "></td>		
	</tr>
	<tr><td class='DEFAULTBLANKROW' colspan=4 width='6'></td></tr>
</table>
<BR>
<BR>


</form>
</body>
<script>
<%
	
if(call_function.equals("Request_Trasnfer") || call_function.equals("Transfer_Out") || call_function.equals("Transfer_In") || call_function.equals("AT") || call_function.equals("Admit_patient") || call_function.equals("IP_Booking") ||  call_function.equals("Revise_Booking")  || call_function.equals("IP_ConfirmBooking") ||  call_function.equals("ASSIGN_BED") || call_function.equals("MODIFY_SERVICE_FOR_INPATIENT") )
{	%>
	var patient_class ='<%=patient_class%>';
	if(patient_class == 'IP')
	{
		var obj =document.forms[0].applicable_to;
		var opt= document.createElement('Option');
		opt.text=getLabel("Common.inpatient.label","Common");
		opt.value='IP'; 
		obj.add(opt)
		opt.selected = true;
		document.forms[0].applicable_to.disabled=true;
	}
	else if(patient_class == 'DC')
	{
		var obj =document.forms[0].applicable_to;
		var opt= document.createElement('Option');
		opt.text=getLabel("Common.daycare.label","Common");
		opt.value='DC'; 
		obj.add(opt)
		opt.selected = true;
		document.forms[0].applicable_to.disabled=true;
	}
		
<%	} %>
</script>
<%
}catch(Exception e)
{
	

	e.printStackTrace();
}
finally
{
	if (con != null) ConnectionManager.returnConnection(con,request);
}		
%>
</html>
<%!
/* getdata() generalized function to fetch values from Database

public ArrayList getData(String sql,String[] whereClause,JspWriter out,Connection con) throws Exception
{

	ArrayList arrL_of_HashMap   		= new ArrayList() ;
	PreparedStatement pstmt				= null ;
	ResultSet resultSet             	= null ;
	ResultSetMetaData resultSetMetaData = null;

	try 
	{
	   pstmt 	= con.prepareStatement(sql) ;
			 
		if (whereClause!=null)
			for (int index=0; index<whereClause.length ;index++ )
				pstmt.setString( index+1, whereClause[index]);

		resultSet = pstmt.executeQuery() ;
		if ( resultSet != null )
		{
			resultSetMetaData   =   resultSet.getMetaData();
			while ( resultSet.next() )
			{
				HashMap hmRecord  =  new HashMap();
				for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
				{
					String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
					if(column_Val==null) column_Val="";	
						hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);
				}	

				arrL_of_HashMap.add(hmRecord) ;
					
 			}
		}
    }catch ( Exception e )
	{
			
			e.printStackTrace() ;
			out.println(e.toString());     
	}
	finally
	{
		try {
				if(pstmt!=null)	pstmt.close();
				if(resultSet!=null)	resultSet.close();

			}
			catch(Exception es) { }
	}
	return arrL_of_HashMap;

}*/
%>


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

