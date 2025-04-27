<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page  contentType="text/html;charset=UTF-8" import =" java.sql.*, java.net.*,java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* " %>

<%
request.setCharacterEncoding("UTF-8");
	Connection con = null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
	String specialty_disabled="";
	
	///String pract_type_disabled="";
	
	//String job_title_disabled="";
	
	String gender_disabled="";
	
	String start_end_cont_disabled="";
	
	String pract_id_disabled="disabled";
    
	String practValue=request.getParameter("practValue");
    
	if(practValue==null) practValue="";
	
	String practName=request.getParameter("practName");
	
	if(practName==null) practName="";
	
	String sql=request.getParameter("sql");
    if(sql==null) sql="";
  sql=java.net.URLEncoder.encode(sql);
    //out.println("<script> alert(\" in search queryString:---"+sql+"\"); </script>");






String user_specialty_code="";
String user_pract_type="";
String user_job_title="";
String user_gender="";




%>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




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
	parent.frames[0].document.getElementById("radiovalue").value=radioval;
 }
/**********************************************/
function toggle(){
	
if(radioval == 'C')
{
//alert(document.forms[0].pract_id.disabled);
document.forms[0].pract_id.disabled = false;
//alert(document.getElementById("pract_id").readonly);
parent.frames[0].document.getElementById("pract_id").readOnly=false;
document.forms[0].pract_id.value = document.forms[0].pract_name.value;
document.forms[0].pract_name.disabled=true;
document.forms[0].pract_name.value = '';
}
else if(radioval == 'D')
{
document.forms[0].pract_name.disabled=false;
parent.frames[0].document.getElementById("pract_name").readOnly=false;
document.forms[0].pract_name.value = document.forms[0].pract_id.value;
document.forms[0].pract_id.disabled=true;
document.forms[0].pract_id.value = '';
}

}
/***************************************************/
 function valtext(boolSql2)
 {

//alert("in valtext:-"+boolSql2);

var pract_type					=document.getElementById("pract_type").value;
var primary_specialty		=document.getElementById("primary_specialty").value;
var pract_id						=document.getElementById("pract_id").value;
var pract_name				=document.getElementById("pract_name").value;
var start_ends_contains	=document.getElementById("start_ends_contains").value;
var job_title						=document.getElementById("job_title").value;
var gender						=document.getElementById("gender").value;


var sql="<%=sql%>";
//alert(sql);
document.forms[0].action = '../../eAM/jsp/GenPractSearchResult.jsp?&pract_type='+pract_type+'&primary_specialty='+primary_specialty+'&pract_id='+escape(pract_id)+'&pract_name='+escape(pract_name)+'&start_ends_contains='+start_ends_contains+'&job_title='+job_title+'&gender='+gender+'&sql='+sql;

document.forms[0].method="post";
document.forms[0].target="result_frame";
document.forms[0].submit();
	
     

if(parent.frames[0].document.getElementById("pract_id"))
parent.frames[0].document.getElementById("pract_id").readOnly=true;                     

if(parent.frames[0].document.getElementById("pract_name"))
parent.frames[0].document.getElementById("pract_name").readOnly=true;               


if(parent.frames[0].document.getElementById("Search"))
parent.frames[0].document.getElementById("Search").disabled=true;
	
if(parent.frames[0].document.getElementById("clear"))
parent.frames[0].document.getElementById("clear").disabled=true;	
}

/*******************************************************************/
function on_Clear(){


if("<%=user_pract_type%>"=="")
document.getElementById("pract_type").options(0).selected=true;

if("<%=user_specialty_code%>"=="")
document.getElementById("primary_specialty").options(0).selected=true;


document.getElementById("pract_id").value="";
document.getElementById("pract_name").value="";
document.getElementById("start_ends_contains").options(0).selected=true;
document.getElementById("start_ends_contains").disabled=true;

if("<%=user_job_title%>"=="")
document.getElementById("job_title").options(0).selected=true;

if("<%=user_gender%>"=="")
document.getElementById("gender").options(0).selected=true;

// clearing the result page
parent.frames[1].location.href ='../../eCommon/html/blank.html';
}
/*********************************************/
function enableSEC()
{

document.getElementById("start_ends_contains").disabled=false;

}
function callOnLoad()
{
	

	valtext(false);
}
</script>

</head>
<body onload="callOnLoad()" onKeyDown='lockKey();'>
<form name='general_search_criteria' id='general_search_criteria' >
<table align='right'  border="0" width='100% 'cellspacing='0' cellpadding='0'>
 <tr width="100">
        <td align='right' class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td colspan=2  class="label">
        <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="storeVal(this);toggle();">Description
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this);toggle();">Code
        </td>
        <td>&nbsp<select name="start_ends_contains" id="start_ends_contains" <%=start_end_cont_disabled%>>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				</select></td>
 </tr>
<tr width='100'>
		<td colspan=1  class="label" nowrap align='right'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<input type='text'  name='pract_id' id='pract_id'maxlength='15' onkeypress='enableSEC();' <%=pract_id_disabled%>></td>
		<td colspan=1  class="label" nowrap align='right'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<select name="pract_type" id="pract_type" ><option value="">---------- ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- ----------</option>

   <%
   try{
	   con = ConnectionManager.getConnection(request);       
   String Sql="SELECT pract_type,desc_sysdef FROM am_pract_type WHERE eff_status='E' ORDER BY 2";
   pstmt 	= con.prepareStatement(Sql) ;
   rs=pstmt.executeQuery();
   while(rs.next())
   {%>
	
	<option value='<%=rs.getString("pract_type")%>'><%=rs.getString("desc_sysdef")%></option>

	<%}if(rs!=null) rs.close();if(pstmt!=null) pstmt.close();
   
   
   %>


</select>
		</td>
		
	
	</tr>
		<tr width='100'>
		
		<td colspan=1  class="label" nowrap align='right'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<input  type='text' maxlength='30' size='30' name='pract_name' id='pract_name' onkeypress='enableSEC();' value="<%=practValue%>">
		</td>
		<td colspan=1  class="label" nowrap align='right'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<select name="primary_specialty" id="primary_specialty" <%=specialty_disabled%>>
				<option value="">------------ ------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------- -----------</option>
     <%
   Sql="select speciality_code,short_desc from am_speciality WHERE eff_status='E'  order by 2";
  
   pstmt 	= con.prepareStatement(Sql) ;
   rs=pstmt.executeQuery();
   while(rs.next())
   {%>
	
	<option value='<%=rs.getString("speciality_code")%>'><%=rs.getString("short_desc")%></option>

	<%}if(rs!=null) rs.close();if(pstmt!=null) pstmt.close();
   
   
   %>
                    
				
				</select>
		</td>
	</tr>
	<tr width='100'>
		<td colspan=1  class="label" nowrap align='right'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<select name='gender' id='gender' <%=gender_disabled%>>
				<option value="">------- ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------ ------</option>
				<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select>
		</td>
		<td colspan=1  class="label" nowrap align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<select name='job_title' id='job_title' >
		<option value="">------- ------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------ ------</option>
		 <%
   Sql="select position_code,position_desc from am_position where role_type='P' and eff_status='E'  order by 2";
  
   pstmt 	= con.prepareStatement(Sql) ;
   rs=pstmt.executeQuery();
   while(rs.next())
   {%>
	
	<option value='<%=rs.getString("position_code")%>'><%=rs.getString("position_desc")%></option>

	<%}if(rs!=null) rs.close();if(pstmt!=null) pstmt.close();
   }catch(Exception e)
   {
	   //out.println("Exception in Jsp"+e.toString());
	   e.printStackTrace();
	   }
   finally{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
   }
   
   
   %>
		
		</select>
		</td>
		
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
		<td align='right'><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(true); " class='button' >&nbsp;&nbsp;
		<input type="button"  align="left" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button'  onClick="on_Clear(); ">
		</td>
	</tr>
</table>
<BR>
<BR>
	<input  type="hidden"   name=user_sql1 id=user_sql1 value="" >
	<input  type="hidden"   name=user_sql2 id=user_sql2 value="" >
<input  type="hidden"   name=toggle_sql2 id=toggle_sql2 value="" >
	<input  type="hidden"  name=radiovalue id=radiovalue value="">	
		</form>
	
</body>

		<script>
		

		//document.general_search_criteria.Search.click()
	

		</script>
		</html>

