<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* " %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	String locale =((String)session.getAttribute("LOCALE"));
	
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<%
	Connection con = ConnectionManager.getConnection(request);
	ArrayList  Arr_Of_HashMap=new ArrayList();
	HashMap  general_HashMap=new HashMap();
	String user_specialty_code="";
    String user_pract_type="";
    String user_job_title="";
    String user_gender="";
	String specialty_disabled="";
	String pract_type_disabled="";
	String job_title_disabled="";
	String gender_disabled="";
	String start_end_cont_disabled="";
	String pract_id_disabled="disabled";
    String practname=request.getParameter("pract_name")==null?"":request.getParameter("pract_name");
    if(!practname.equals("")){
	start_end_cont_disabled="";
	}
	PreparedStatement pstm2=null;
	Statement stmt=null;
	ResultSet rset=null ;
    
    if(!practname.equals("")){
    	start_end_cont_disabled="";
    	}
			PreparedStatement pstmt 	= null;
			ResultSet rs = null;
			
			
	String description="";
	String code="";
	String en="";
    boolean cernerIdSiteSpecific = false;


	 user_specialty_code=request.getParameter("primary_specialty")==null?"":request.getParameter("primary_specialty");  
	 
	if(user_specialty_code==null) user_specialty_code="";
	specialty_disabled=user_specialty_code.equals("")?"":"disabled";  
	
	user_pract_type=request.getParameter("practitioner_type"); 
	if(user_pract_type==null) user_pract_type="";
	pract_type_disabled=user_pract_type.equals("")?"":"disabled";

	user_gender=request.getParameter("gender");         
	if(user_gender==null) user_gender="";
	gender_disabled=user_gender.equals("")?"":"disabled";

	user_job_title=request.getParameter("job_title");    
	if(user_job_title==null) user_job_title="";
	job_title_disabled=user_job_title.equals("")?"":"disabled";	 

	String position_dsbl="";
	if(user_pract_type.equals(""))
	{
		position_dsbl="disabled";
	}
			String clinicianId =(String)session.getValue("ca_practitioner_id");
			String facility_id=(String) session.getValue("facility_id");

try
{
 cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","CERNER_PRACTITIONER_ID");

String splCode="";
String spl_description_disabled="";
String spl_description="";
String comp_desc = "SELECT speciality_code,short_desc FROM am_speciality where speciality_code=?";

pstmt = con.prepareStatement(comp_desc);
pstmt.setString(1, user_specialty_code);
rs = pstmt.executeQuery();
while (rs.next()) {
splCode = rs.getString("speciality_code") == null ? "" : rs.getString("speciality_code");
spl_description = rs.getString("short_desc") == null ? "" : rs.getString("short_desc");
}
if(rs != null)rs.close();
if(pstmt != null)pstmt.close();
if(!spl_description.equals("")){
spl_description_disabled="disabled";
}
%>

<%!
public ArrayList getData(String sql,String locale,Connection con) throws Exception{
	ArrayList arrL_of_HashMap   		= new ArrayList() ;	
	PreparedStatement pstmt         	= null ;
	ResultSet resultSet             	= null ;
	try {
		pstmt 	= con.prepareStatement(sql) ;
		pstmt.setString(1,locale);
	    resultSet = pstmt.executeQuery() ;
		if(resultSet != null){
			while(resultSet.next()){
				HashMap hmRecord  =  new HashMap();
				String code=resultSet.getString("code")==null?"":resultSet.getString("code");
				String description=resultSet.getString("description")==null?"":resultSet.getString("description");
				hmRecord.put("code",code);
				hmRecord.put("description",description);
				arrL_of_HashMap.add(hmRecord) ;
			}
		}
		if(resultSet!=null)	resultSet.close();
		if(pstmt!=null)	pstmt.close();
    }catch(Exception e){
		e.printStackTrace() ;
    }finally{
	}
	return arrL_of_HashMap;
}
%>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>     
        <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>

		<script>

			var radioval="D";
		
/******************************************************/			
function closew()
{
	parent.window.close();
}

/******************************************************/
function storeVal(currad)
{
radioval=currad.value
parent.frames[0].document.getElementById('radiovalue').value=radioval;
 }
/**********************************************/
function toggle(){
	
if(radioval == 'C')
{ 
	document.forms[0].pract_id.disabled = false;
	parent.frames[0].document.getElementById('pract_id').readOnly=false;
	document.forms[0].pract_id.value = document.forms[0].pract_name.value;
	document.forms[0].pract_name.disabled=true;
	document.forms[0].pract_name.value = '';
}
else if(radioval == 'D')
{
document.forms[0].pract_name.disabled=false;
parent.frames[0].document.getElementById('pract_name').readOnly=false;
document.forms[0].pract_name.value = document.forms[0].pract_id.value;
document.forms[0].pract_id.disabled=true;
document.forms[0].pract_id.value = '';
}

}
function allow_nochars( val ) {
	var text_val=val;
	if(text_val.indexOf("#") !=-1){
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		document.getElementById('pract_name').value="";
		window.close();
	}
	
}
/***************************************************/
 function valtext(boolSql2)
 {
	var pract_type				=document.getElementById('pract_type').value;
    var primary_specialty		=document.getElementById('specialty_code').value;  
	var pract_id				=document.getElementById('pract_id').value;
	var pract_name				=document.getElementById('pract_name').value;
	var start_ends_contains	    =document.getElementById('start_ends_contains').value;
	var job_title				=document.getElementById("job_title").value;
	var gender					=document.getElementById('gender').value;
	parent.frames[0].document.getElementById('Search').disabled=true;
	parent.frames[0].document.getElementById('clear').disabled=true;
    allow_nochars(pract_name);

if(boolSql2){
document.getElementById('user_sql1').value=document.getElementById('user_sql2').value
document.getElementById('toggle_sql2').value="Yes";

}

if(pract_name =="#")
{
	pract_name="$";
}
document.forms[0].action = '../../eCA/jsp/GeneralPractitionerSearchResult.jsp?&pract_type='+pract_type+'&primary_specialty='+primary_specialty+'&pract_id='+escape(pract_id)+'&pract_name='+pract_name+'&start_ends_contains='+start_ends_contains+'&job_title='+job_title+'&gender='+gender+"&srch_click=Y";

document.forms[0].method="post";
document.forms[0].target="result_frame";
document.forms[0].submit();
	


}

/*******************************************************************/
function on_Clear(formobj){

var  search_by1=formobj.search_by.value;

if(search_by1 !==''){
document.getElementById('search_by1').checked=true;
document.getElementById('pract_name').disabled=false;
document.getElementById('pract_name').readOnly=false;
document.getElementById('pract_name').value = document.getElementById('pract_id').value;
document.getElementById('pract_id').disabled=true;
document.getElementById('pract_id').value = ''; 
}

if("<%=user_pract_type%>"==""){
document.getElementById('pract_type').options(0).selected=true;
}
if("<%=user_specialty_code%>"==""){
document.getElementById('primary_specialty').options(0).selected=true;
}
document.getElementById('pract_id').value="";
document.getElementById('pract_name').value="";
document.getElementById('start_ends_contains').options(0).selected=true;

if("<%=user_job_title%>"==""){
	document.getElementById("job_title").disabled=true;
	document.getElementById("job_title").value='';
}

if("<%=user_gender%>"==""){
	document.getElementById('gender').options(0).selected=true;
}
parent.frames[1].location.href ='../../eCommon/html/blank.html';
valtext(true); 
}
/*********************************************/

function enableSEC(){
	document.getElementById('start_ends_contains').disabled=false;
}

function callOnLoad(){
		var arraySql=parent.window.dialogArguments;
		var i=0;	
		for(i=0; i<document.getElementById("job_title").options.length;i++){
				if(document.getElementById("job_title").options[i].value=="<%=user_job_title%>")
				document.getElementById("job_title").options[i].selected=true;
		}
		for(i=0; i<document.getElementById('gender').options.length;i++){
				if(document.getElementById('gender').options[i].value=="<%=user_gender%>")
				document.getElementById('gender').options[i].selected=true;
		}
		if(parent.frames[0].document.getElementById('pract_id')){
			if(parent.frames[0].document.getElementById('pract_id').value !=""){
				parent.frames[0].document.getElementById('pract_id').readOnly=true;                     
			}
		}
	if (parent.frames[0].document.getElementById('pract_name')){
		if(parent.frames[0].document.getElementById('pract_name').value !=""){
			parent.frames[0].document.getElementById('pract_name').readOnly=true;               
		}
	}
	if(parent.frames[0].document.getElementById('Search')){
		if(parent.frames[1].document.getElementById('resultPageLoaded') && parent.frames[1].document.getElementById('resultPageLoaded').value =="Y"){
			parent.frames[0].document.getElementById('Search').disabled=false;
		}else{
			parent.frames[0].document.getElementById('Search').disabled=true;
		}
	}
	if(parent.frames[0].document.getElementById('clear')){
		if(parent.frames[1].document.getElementById('resultPageLoaded') && parent.frames[1].document.getElementById('resultPageLoaded').value =="Y"){
			parent.frames[0].document.getElementById('clear').disabled=false;
		}else{
			parent.frames[0].document.getElementById('clear').disabled=true;
		}
	}
		//valtext(true);
}
</script>

<script>
function enabledPosition(obj){
	var pract_type=obj.value;
	if(pract_type !=""){
		document.getElementById("job_title").disabled=false;
	}
	else{
		document.getElementById("job_title").disabled=true;
		document.getElementById("job_title").value='';
	}
}
function populatePosition(obj,locale)
{
var xmlHttp		=  new XMLHttpRequest() ;
xmlStr	="<root><SEARCH " ;
xmlStr += " p_action=\"POPUP_POSITION\"";
xmlStr += " pract_Code=\"" +obj.value + "\"";
xmlStr += " locale=\"" + locale + "\"";
xmlStr +=" /></root>" ;
var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
xmlHttp.open( "POST","../../eCA/jsp/GeneralPractitionerIntermediate.jsp", false ) ;
xmlHttp.send(xmlDoc);
responseText    = xmlHttp.responseText;
responseText	= trimString(responseText);
eval(responseText);
}

function addPositionList(code,desc)
{
var element = document.createElement('OPTION') ;
element.value =  code ;
element.text = desc ;	
eval("document.forms.general_search_criteria.job_title.add(element)");		
}

function clearPositionList() 
{
eval("document.forms.general_search_criteria.job_title.length=0");
var tp = getLabel("Common.defaultSelect.label","Common");
var element = document.createElement('OPTION') ;
element.value = "" ;
element.text = "----------"+tp+"----------" ;	
eval("document.forms.general_search_criteria.job_title.add(element)");		
} 
</script>

</head>
<body onload="callOnLoad()" onKeyDown = 'lockKey()'>
<form name='general_search_criteria' id='general_search_criteria' >
<table   border="0" width='100% 'cellspacing='0' cellpadding='0'>
<tr><td colspan=4>&nbsp;</td></tr>
 <tr width="100">
        <td  class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td  class="label">
        <input type="radio" name="search_by" id="search_by" id='search_by1' class="label" value="D"  checked  onclick="storeVal(this);toggle();"><fmt:message key="Common.description.label"  bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this);toggle();"><fmt:message key="Common.code.label"  bundle="${common_labels}"/>
        </td>
		<td class='label'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td align='left'><select name="start_ends_contains" id="start_ends_contains" <%=start_end_cont_disabled%>>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				</select></td>
 </tr>
<tr width='100'>
		<td colspan=1  class="label" nowrap ><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td align='left'><input type='text'  name='pract_id' id='pract_id' id='pract_id' maxlength='15' onkeypress='enableSEC();' <%=pract_id_disabled%>></td>
		<td colspan=1  class="label" nowrap ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
		<td align='left'><select name="pract_type" id="pract_type" <%=pract_type_disabled%> onchange ='enabledPosition(this);return populatePosition(this,"<%=locale%>")'><option value="">-------&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-------</option>
<%
String sqlfac="SELECT A.PRACT_TYPE CODE, A.DESC_USERDEF DESCRIPTION FROM AM_PRACT_TYPE_LANG_VW A INNER JOIN CA_PRACT_CONSULTA_TAG B ON B.PRACT_TYPE=A.PRACT_TYPE WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY 2";
PreparedStatement pstmt2 = con.prepareStatement(sqlfac);
pstmt2.setString(1, locale);
rset=pstmt2.executeQuery();
if(rset!=null)
{
while(rset.next())
{
code=rset.getString("CODE");
description=rset.getString("DESCRIPTION");
out.println("<option value='"+code+ "' "+en +">"+description);
} 
}  
%>
</select>
</td>
</tr>
<tr width='100'>
		
<td colspan=1  class="label" nowrap ><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
<td align='left'><input type='text' maxlength='30' size='30'name='pract_name'  onkeypress='enableSEC();' value="<%=practname%>">
</td>
<td colspan=1  class="label" nowrap ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
<td align='left'><input type='text' maxlength='24' size='24'name='primary_specialty'  onkeypress='' value="<%=spl_description%>" <%=spl_description_disabled%> >
<input type='hidden' name='specialty_code' id='specialty_code' value='<%=splCode%>'>  
</td>
</td>
</tr>
<tr width='100'>
<td colspan=1  class="label" nowrap ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
<td align='left'><select name='gender' id='gender' <%=gender_disabled%>>
<option value="">------&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;------</option>
<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
</select>
</td>
<td colspan=1  class="label" nowrap ><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
<td align='left' name='position_job'><select name='job_title' id='job_title' <%=job_title_disabled%> <%=position_dsbl%>>>  <!-- tttt -->
<option value="">------&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;------</option>
</select>
</td>		
</tr>
<tr>
<td colspan=3>&nbsp;</td>
<td ><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(true); " class='button' >&nbsp;
<input type="button"  align="left" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick="on_Clear(this.form);">
</td>
</tr>
<tr><td colspan=4>&nbsp;</td></tr>
</table>
	<input type="hidden"  name=user_sql1 id=user_sql1 value="" >
	<input type="hidden"  name=user_sql2 id=user_sql2 value="" >
    <input type="hidden"  name=toggle_sql2 id=toggle_sql2 value="" >
	<input type="hidden" name=radiovalue id=radiovalue value="">
		
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
<script>
if("<%=cernerIdSiteSpecific%>"=="true"){
if(document.getElementById('start_ends_contains'))document.getElementById('start_ends_contains').options(2).selected=true;
}
</script>
</html>

