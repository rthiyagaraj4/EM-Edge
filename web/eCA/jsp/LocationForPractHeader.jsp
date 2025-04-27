<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs1=null;

String dis="";
String spl_code="",spl_desc="";
String facility_id ="";
String practitioner_id="";
practitioner_id=request.getParameter("practitioner_id");

if(practitioner_id==null) 
{
	practitioner_id ="";
}

String practitioner_name="";
String sqlSpec = "Select speciality_code, short_desc from am_speciality where eff_status ='E' order by 2";
try
{
	con=ConnectionManager.getConnection(request);
	facility_id = (String)session.getValue("facility_id");
%>
<html>
	<head>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/LocationForPractitioner.js'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function getPractitionerId1(target)
{
	var speciality = document.forms[0].spl.value;
	var field=document.forms[0].spl;
	var name="Speciality";
	var p_facility_id="`"+'<%=facility_id%>'+"`";
	var retVal	=  new String();
	var dialogTop			= "30";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features	="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments= "" ;
	var search_code="";
	var search_desc="";
	var sql="";
	var title= getLabel("Common.practitioner.label","common");
	search_code="practitioner_id";
	search_desc= "practitioner_name";
	
	if(document.forms[0].spl.value)
	{
		sql ="select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ="+p_facility_id+" and b.primary_speciality_code=`"+speciality+"`";
	}
	if(!(document.forms[0].spl.value))
	{
		sql ="select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ="+p_facility_id+" ";
	}
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.forms[0].pctr.value=arr[0];
		document.forms[0].practitioner_id.value=arr[1];
		document.forms[0].searchpctr.disabled=false;
		PopulateName1(arr[1]);
	}
	document.forms[0].flag.value="true";
}


</script>	
</head>
	<body class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
		<form name="LPract" id="LPract">
			<table border=0 cellspacing=0 cellpadding='3' width='100%' align='center'>
			<tr><td class=label colspan='4'>&nbsp;</td></tr>
				<tr>
					<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
					<td class='fields' ><input type="hidden" name="spl_code" id="spl_code" size="20" maxlength="20" value=""><input type="text" name="spl" id="spl" <%=dis%> size='25' maxlength='20' onBlur='getSplCode(this);chekcSplTxt(this)' OnChange='resetValues();setValue();clearValFrame()'><input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='resetValues();getSplCode(this)'></td>


		<!-- 			<td class='fields'><select name=spl <%=dis%>  onChange='clearValFrame()'>
					<option value=''>------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------</option>
<%
try
{
  pstmt = con.prepareStatement(sqlSpec);
  rs1 = pstmt.executeQuery();
  while(rs1!=null && rs1.next())
  {
	spl_code=rs1.getString(1);
	spl_desc=rs1.getString(2);
	out.println("<option value='"+spl_code+"'>"+spl_desc+"</option>");
  }


}//try 

catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//common-icn-0181
   eg.printStackTrace();//COMMON-ICN-0181
}
	
%>
</select>&nbsp;</td> -->

<td class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
<td class='fields' ><input type="hidden" name="practitioner_id" id="practitioner_id" size="20" maxlength="20" value="<%=practitioner_id%>"><input type="text" name="pctr" id="pctr" value="<%=practitioner_name%>"
size='25' maxlength='20'  onBlur='getPractCode(this)' OnChange='resetValues();setValue()'
><input type="button" value="?" class="button" name='searchpctr' id='searchpctr' onClick='resetValues();getPractCode(this)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
</table>
<%
if(rs1!=null) rs1.close();	
if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
//out.println("Exception @ LocationforPractHeader "+e.toString());//COMMON-ICN-0181
e.printStackTrace();//COMMON-ICN-0181
}
finally
{
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

<input type='hidden' name='flag' id='flag' value='true'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
</form>
</body>
</html>

