<!DOCTYPE html>
<html>
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.*,eCommon.XSSRequestWrapper " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
     request.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
 	String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<%
	Connection con = ConnectionManager.getConnection(request);

try
{
	String start_end_cont_disabled="";

    String nursingunit_desc=request.getParameter("nursing_unit_desc")==null?"":request.getParameter("nursing_unit_desc");
  	if(!nursingunit_desc.equals("")){
	start_end_cont_disabled="";
	}
   // String nursingunit=request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
%>



<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
	var radioval="D";
		
 function closew()
{
	parent.window.close();
}

function storeVal(currad)
{
radioval=currad.value
	parent.frames[0].document.getElementById("radiovalue").value=radioval;
 }
function toggle(){
	
if(radioval == 'C')
{
document.forms[0].treatment_code.disabled = false;
 parent.frames[0].document.getElementById("treatment_code").readOnly=false;
document.forms[0].treatment_code.value = document.forms[0].treatment_desc.value;
document.forms[0].treatment_desc.disabled=true;
document.forms[0].treatment_desc.value = '';
}
else if(radioval == 'D')
{
document.forms[0].treatment_desc.disabled=false;
parent.frames[0].document.getElementById("treatment_desc").readOnly=false;
document.forms[0].treatment_desc.value = document.forms[0].treatment_code.value;
document.forms[0].treatment_code.disabled=true;
document.forms[0].treatment_code.value = '';
}

}
function allow_nochars( val ) {
	var text_val=val;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		document.getElementById("treatment_desc").value="";
		window.close();
	}
	}
/***************************************************/
 function valtext(boolSql2)
 {
	var nursingunit						=document.getElementById("treatment_code").value;
	var nursingunit_desc				=document.getElementById("treatment_desc").value;
	var treatment_cliniccode		 =document.getElementById("treatment_cliniccode").value;

    allow_nochars(nursingunit_desc);

if(boolSql2){
document.getElementById("user_sql1").value=document.getElementById("user_sql2").value
document.getElementById("toggle_sql2").value="Yes";

}

if(nursingunit_desc =="#")
{
	nursingunit_desc="$";
}
document.forms[0].action = '../../eAE/jsp/AETreatmentAreaResult.jsp?&nursingunit_desc='+nursingunit_desc+' &nursingunit='+escape(nursingunit)+'&treatment_cliniccode='+treatment_cliniccode+'&treatment_cliniccode='+treatment_cliniccode+"&srch_click=Y";

document.forms[0].method="post";
document.forms[0].target="result_frame";
document.forms[0].submit();

}

function on_Clear(){

document.getElementById("treatment_code").value="";
document.getElementById("treatment_desc").value="";
document.getElementById("treatment_cliniccode").value="";
parent.frames[1].location.href ='../../eCommon/html/blank.html';
}


function callOnLoad()
{
	var arraySql=parent.window.dialogArguments;
	
	var i=0;	
	
	if(parent.frames[0].document.getElementById("treatment_code"))
	{
		if(parent.frames[0].document.getElementById("treatment_code").value !="")
	{
	parent.frames[0].document.getElementById("treatment_code").readOnly=true;                     
	}
	}

if (parent.frames[0].document.getElementById("treatment_desc"))
{
if(parent.frames[0].document.getElementById("treatment_desc").value !="")
	{
	
    parent.frames[0].document.getElementById("treatment_desc").readOnly=true;               
	}
}

if(parent.frames[0].document.getElementById("Search"))
parent.frames[0].document.getElementById("Search").disabled=true;
	
if(parent.frames[0].document.getElementById("clear"))
parent.frames[0].document.getElementById("clear").disabled=true;	


}
</script>

<body  onLoad='callOnLoad(); valtext(this);' onKeyDown = 'lockKey()'>
<form name='treatmentarea_search_criteria' id='treatmentarea_search_criteria' >
<table   border="0" width='100% 'cellspacing='0' cellpadding='0'>
 <tr width="100">
        <td  class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td colspan=2  class="label">
        <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="storeVal(this);toggle();"><fmt:message key="Common.description.label"  bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this);toggle();"><fmt:message key="Common.code.label"  bundle="${common_labels}"/>
        </td>
 </tr>
<tr width='100'>
		<td colspan=1  class="label" nowrap ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<input type='text'  name='treatment_code' id='treatment_code' maxlength='15'size='30' value=""></td>
	</tr>
		<tr width='100'>
		
		<td colspan=1  class="label" nowrap ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<input type='text' maxlength='30' size='30'name='treatment_desc' value="<%=nursingunit_desc%>">
		</td>
		<td colspan=1  class="label" nowrap ><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<input type='text' maxlength='30' size='30'name='treatment_cliniccode' value="">
		</td>
		</tr>

	 	<tr>
		<td colspan=3>&nbsp;</td>
		<td ><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(true); " class='button' >&nbsp;&nbsp;
		<input type="button"  align="left" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button'  onClick="on_Clear(); ">
		</td>
	</tr>

</table>
<BR>
<BR>
	<input type="hidden"  name=user_sql1 value="" >
	<input type="hidden"  name=user_sql2 value="" >
    <input type="hidden"  name=toggle_sql2 value="" >
	<input type="hidden" name=radiovalue value="">	
	
</form>
	
</body>

<%
}catch(Exception e)
{
	e.printStackTrace();
}
	finally
	{
		if (con != null) 
			ConnectionManager.returnConnection(con,request);
	}		
		%>
</html>

