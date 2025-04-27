<!DOCTYPE html>
<%@ page import="java.util.StringTokenizer" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	request.setCharacterEncoding("UTF-8");
	String natidprompt = request.getParameter("natidprompt");
%>


<html>
<title><%=natidprompt%>&nbsp;<fmt:message key="Common.Values.label" bundle="${common_labels}"/></title>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eMP/js/RegPatReferral.js'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function clickok()
	{
		window.returnValue = 0
		window.close();
	}
	function clickcancel()
	{
		window.returnValue = 1
		window.close();
	}
</script>
<%
String vdateofbirth = request.getParameter("vdateofbirth");
String vDOB = vdateofbirth;

/*
if (!vDOB.equals(""))
{
	if(!localeName.equals("en"))
	{ 	
		vDOB= DateUtils.convertDate(vDOB,"DMY","en",localeName);
	}
}
*/

String dateofbirth = request.getParameter("dateofbirth");
String vsex = request.getParameter("vsex");
if(vsex.equals("M"))
	vsex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
else if(vsex.equals("F"))
	vsex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
else if(vsex.equals("U"))
	vsex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

String vage = request.getParameter("vage")==null?"0":request.getParameter("vage");
String vmonths = request.getParameter("vmonths")==null?"0":request.getParameter("vmonths");
String vdays = request.getParameter("vdays")==null?"0":request.getParameter("vdays");
String vhours = request.getParameter("vhours")==null?"0":request.getParameter("vhours");

String age = request.getParameter("age")==null?"0":request.getParameter("age");
String months = request.getParameter("months")==null?"0":request.getParameter("months");
String days = request.getParameter("days")==null?"0":request.getParameter("days");
String hours = request.getParameter("hours")==null?"0":request.getParameter("hours");

String sex = request.getParameter("sex");
String birthplacedesc = request.getParameter("birthplacedesc");
String vbirthplacedesc = request.getParameter("vbirthplacedesc");

//String placeofbirth = request.getParameter("place_of_birth");

String old_age_value = "";
String new_age_value = "";

if(!vage.equals("0") && !vage.equals(""))
	old_age_value = old_age_value+vage+"Y ";								
if(!vmonths.equals("0") && !vmonths.equals(""))
	old_age_value = old_age_value+vmonths+"M ";								
if(!vdays.equals("0") && !vdays.equals(""))
	old_age_value = old_age_value+vdays+"D ";							
if(!vhours.equals("0") && !vhours.equals(""))
	old_age_value = old_age_value+vhours+"H ";		

if(!age.equals("0") && !age.equals(""))
	new_age_value = new_age_value+age+"Y ";								
if(!months.equals("0") && !months.equals(""))
	new_age_value = new_age_value+months+"M ";								
if(!days.equals("0") && !days.equals(""))
	new_age_value = new_age_value+days+"D ";							
if(!hours.equals("0") && !hours.equals(""))
	new_age_value = new_age_value+hours+"H ";	

if(sex.equals("M"))
	sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
else if(sex.equals("F"))
	sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
else if(sex.equals("U"))
	sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
%>
<table cellspacing=0 cellpadding=0 width='90%' align='center' border=1 height='90%' >
<tr>
	 <td class='COLUMNHEADER'>&nbsp;</td>
     <td  class='COLUMNHEADER' ><fmt:message key="eMP.oldvalues.label" bundle="${mp_labels}"/></td>
     <td class='COLUMNHEADER' ><fmt:message key="eMP.newvalues.label" bundle="${mp_labels}"/></td>
</tr>
<tr>
        <td class='label' align='right' STYLE="COLOR:Navy;"><B><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;<B></td>
        <td class='label' height='15%' ><b><%=vsex%> </b></td>
        <td class='label'><b><%=sex%></td>
    </tr>
    
    <tr>
        <td class='label' align='right'><b><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>  

		 <td class='label'><b><%=old_age_value%></td>
         <td class='label'><b><%=new_age_value%></td>

     </tr>
	 <tr>
        <td class='label' align='right' ><B><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/><B></td>
        <td class='label' height='15%' ><b><%=vDOB%> </b></td>
        <td class='label'><b><%=dateofbirth%></td>
    </tr>
	<tr>
        <td class='label' align='right' ><b><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
        <td class='label'><b>&nbsp;<%=vbirthplacedesc%></td>
        <td class='label'><b>&nbsp;<%=birthplacedesc%></td>
     </tr>
</table>
<table border='0' align='center' cellspacing=0 cellpadding=0>
<tr>
<td class='querydata'><fmt:message key="eMP.Doyouwanttochangethevalues.label" bundle="${mp_labels}"/>?</td>
<td class='label' width='10%'>&nbsp;</td>
<td class='button'><input type=button class=button value='<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onclick='clickok()'>
&nbsp;<input type=button class=button value='<fmt:message key="Common.no.label" bundle="${common_labels}"/>' onclick='clickcancel()'></td>
<td></td>
</tr>
</table>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

