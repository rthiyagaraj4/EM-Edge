<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page  contentType="text/html;"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.*,eCommon.XSSRequestWrapper " %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	///////////
	/////////////
	//String queryString=request.getQueryString();
	Connection con = ConnectionManager.getConnection(request);
	ArrayList  Arr_Of_HashMap=new ArrayList();
	HashMap  general_HashMap=new HashMap();
	String specialty_disabled="";
	String pract_type_disabled="";
	String job_title_disabled="";
	String gender_disabled="";
	String start_end_cont_disabled="";
	 
String pract_id_disabled="disabled";

String practname=request.getParameter("practname");
String temp_practID	= request.getParameter( "temp_practID" )==null?"":request.getParameter( "temp_practID" ) ;
String pract_retval	= request.getParameter( "pract_retval" )==null?"":request.getParameter( "pract_retval" ) ;

if(practname==null) practname="";

if(!practname.equals("")){
	start_end_cont_disabled="";
	}

//String sql	=request.getParameter("sql");         
//if(sql==null) sql="";

String sql       = (String) session.getValue("sql")==null?"":(String) session.getValue("sql");

String sqlSec       = (String) session.getValue("sqlSec");

//String sqlSec	=request.getParameter("sqlSec");         
//if(sqlSec==null) sqlSec="";

//out.println("<script> alert(\" in criteria sql:---"+sql+"\"); </script>");
//out.println("<script> alert(\" in criteria sqlSec:---"+sqlSec+"\"); </script>");
//out.println("<script> alert(\" in criteria practname:---"+practname+"\"); </script>");
/*
*these 4 variables are passed in the query string ..they are specially included in the where criteria of the    *user passed sql
*/
String user_specialty_code="";
String user_pract_type="";
String user_job_title= "";
String user_gender="";
user_pract_type=request.getParameter("practitioner_type");  
// ********this block will get the values only if the user sql is passed
if(!sql.equals(""))
{
	user_specialty_code=request.getParameter("specialty_code");         
	if(user_specialty_code==null) user_specialty_code="";
	specialty_disabled=user_specialty_code.equals("")?"":"disabled";

	user_pract_type=request.getParameter("practitioner_type");         
	if(user_pract_type==null) user_pract_type="";
	pract_type_disabled=user_pract_type.equals("")?"":"disabled";

//out.println("<script> alert(\" in criteria user_pract_type:---"+user_pract_type+"\"); </script>");

	user_gender=request.getParameter("gender");         
	if(user_gender==null) user_gender="";
	gender_disabled=user_gender.equals("")?"":"disabled";

	//out.println("<script>alert(\"user_gender:-----"+gender_disabled+"\")</script>");

	user_job_title=request.getParameter("job_title");         
	if(user_job_title==null) user_job_title="";
	job_title_disabled=user_job_title.equals("")?"":"disabled";

}
// ********block ends

//out.println("<script>alert(\"specialty_code:-----"+specialty_code+"\")</script>");

try
{
%>

<%!
/*********************getdata() generalized function to fetch values from Database*******************/

public ArrayList getData(String sql,String[] whereClause,JspWriter out,Connection con) throws Exception
{

   ArrayList arrL_of_HashMap   		= new ArrayList() ;
//   Connection con				= null ;
   PreparedStatement pstmt         		= null ;
   ResultSet resultSet             			= null ;
   ResultSetMetaData resultSetMetaData 	= null;
   //ArrayList deBug   			= new ArrayList() ;

 try {

  // con 	= ConnectionManager.getConnection(request);
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
            	System.err.println( "Error loading values from database" ) ;
            	e.printStackTrace() ;
				//out.println(e.toString());//COMMON-ICN-0181     
        }
        finally
        {
            try {
               		if(pstmt!=null)	pstmt.close();
		if(resultSet!=null)	resultSet.close();
	//ConnectionManager.returnConnection(con,request);
              	}
                catch(Exception es) { }
        }
	return arrL_of_HashMap;

}
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

var pract_type				= document.getElementById("pract_type").value;
var primary_specialty		= document.getElementById("primary_specialty").value;
var pract_id				= document.getElementById("pract_id").value;
var pract_name				= document.getElementById("pract_name").value;
var start_ends_contains		= document.getElementById("start_ends_contains").value;
var job_title				= document.getElementById("job_title").value;
var gender					= document.getElementById("gender").value;
var temp_practID			= document.getElementById("temp_practID").value;
var pract_retval			= document.getElementById("pract_retval").value;


//alert("in valtext prim spec:-"+document.getElementById("primary_specialty").value);
if(boolSql2){
document.getElementById("user_sql1").value=document.getElementById("user_sql2").value
document.getElementById("toggle_sql2").value="Yes";
//alert("in valtext sql1:-"+document.getElementById("user_sql1").value)
}
//alert("in result call"+sql);
document.forms[0].action = '../../eOR/jsp/NewPractLookupQueryResult.jsp?&pract_type='+pract_type+'&primary_specialty='+primary_specialty+'&pract_id='+escape(pract_id)+'&pract_name='+escape(pract_name)+'&start_ends_contains='+start_ends_contains+'&job_title='+job_title+'&gender='+gender+"&temp_practID="+temp_practID+"&pract_retval="+pract_retval;
//parent.frames[1].location.href='../../eAM/jsp/GeneralPractitionerSearchResult.jsp?&pract_type='+pract_type+'&primary_specialty='+primary_specialty+'&pract_id='+escape(pract_id)+'&pract_name='+escape(pract_name)+'&start_ends_contains='+start_ends_contains+'&job_title='+job_title+'&gender='+gender;
document.forms[0].method="post";
document.forms[0].target="result_frame";
document.forms[0].submit();
	
//if(parent.frames[0].document.getElementById("pract_type"))
//parent.frames[0].document.getElementById("pract_type").disabled=true;                 

//if(parent.frames[0].document.getElementById("primary_specialty"))
//parent.frames[0].document.getElementById("primary_specialty").disabled=true;     

if(parent.frames[0].document.getElementById("pract_id"))
parent.frames[0].document.getElementById("pract_id").readOnly=true;                     

if(parent.frames[0].document.getElementById("pract_name"))
parent.frames[0].document.getElementById("pract_name").readOnly=true;               

//if(parent.frames[0].document.getElementById("job_title"))
//parent.frames[0].document.getElementById("job_title").disabled=true;                     

//if(parent.frames[0].document.getElementById("gender"))
//parent.frames[0].document.getElementById("gender").disabled=true;

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
	var arraySql=parent.window.dialogArguments;
	
//	document.forms[0].user_sql1.value=arraySql[0];
//	document.forms[0].user_sql2.value=arraySql[1];
	
	document.forms[0].user_sql1.value="<%=sql%>";
	document.forms[0].user_sql2.value="<%=sqlSec%>";
	
	var i=0;	
	for(i=0; i<document.getElementById("job_title").options.length;i++)
	{
			if(document.getElementById("job_title").options[i].value=="<%=user_job_title%>")
			document.getElementById("job_title").options[i].selected=true;
	}
	
	for(i=0; i<document.getElementById("gender").options.length;i++)
	{
			if(document.getElementById("gender").options[i].value=="<%=user_gender%>")
			document.getElementById("gender").options[i].selected=true;
	}
	valtext(false);
}
</script>

</head>
<body onload="callOnLoad()">
<form name='general_search_criteria' id='general_search_criteria' >
<table align='right'  border="0" width='100% 'cellspacing='0' cellpadding='0'>
 <tr width="100">
        <td align='right' class='label'>Search By</td>
        <td colspan=2  class="label">
        <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="storeVal(this);toggle();">Description
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this);toggle();">Code
        </td>
        <td>&nbsp<select name="start_ends_contains" id="start_ends_contains" <%=start_end_cont_disabled%>>
					<option value="S">Starts With</option>
					<option value="E">Ends With</option>
					<option value="C">Contains</option>
				</select></td>
 </tr>
<tr width='100'>
		<td colspan=1  class="label" nowrap align='right'>Practitioner ID</td>
		<td align='left'>&nbsp;<input type='text'  name='pract_id' id='pract_id'maxlength='15' onkeypress='enableSEC();' <%=pract_id_disabled%>></td>
		<td colspan=1  class="label" nowrap align='right'>Practitioner type</td>
		<td align='left'>&nbsp;<select name="pract_type" id="pract_type" <%=pract_type_disabled%>><option value="">---------- Select ----------</option>
<%
String Sql="SELECT pract_type,desc_sysdef FROM am_pract_type WHERE eff_status='E' ORDER BY 2";
Arr_Of_HashMap= getData( Sql, null, out,con);


for(int i=0; i<Arr_Of_HashMap.size();i++)
	{
	 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
if(general_HashMap.get("PRACT_TYPE").equals(user_pract_type)) {
%>
<option value= '<%=general_HashMap.get("PRACT_TYPE")%>' selected> <%=general_HashMap.get("DESC_SYSDEF")%></option>
<%}else{
%>
<option value= '<%=general_HashMap.get("PRACT_TYPE")%>' > <%=general_HashMap.get("DESC_SYSDEF")%></option>	

<%
}
	}
%>
</select>
		</td>
		
		<!-- <td colspan=1  class="label" nowrap align='right'>Practitioner Name</td>
		<td align='left'>&nbsp;<input type='text' maxlength='30' size='30'name='pract_name' onkeypress='enableSEC();' value="<%=practname%>">
		</td> -->
	</tr>
		<tr width='100'>
		
		<td colspan=1  class="label" nowrap align='right'>Practitioner Name</td>
		<td align='left'>&nbsp;<input type='text' maxlength='30' size='30'name='pract_name' onkeypress='enableSEC();' value="<%=practname%>">
		</td>
		<td colspan=1  class="label" nowrap align='right'>Specialty</td>
		<td align='left'>&nbsp;<select name="primary_specialty" id="primary_specialty" <%=specialty_disabled%>>
				<option value="">------------ Select -----------</option>
<%
String Sql1="select speciality_code,short_desc from am_speciality WHERE eff_status='E'  order by 2";
	Arr_Of_HashMap= getData( Sql1, null,out,con);
	
	general_HashMap.clear();
	
	for(int i=0; i<Arr_Of_HashMap.size();i++)
	{
	 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
if(general_HashMap.get("SPECIALITY_CODE").equals(user_specialty_code)) {
%>
<option value= '<%=general_HashMap.get("SPECIALITY_CODE")%>' selected> <%=general_HashMap.get("SHORT_DESC")%></option>
<%}else{
	%>
<option value= '<%=general_HashMap.get("SPECIALITY_CODE")%>' > <%=general_HashMap.get("SHORT_DESC")%></option>
	<%
		}
	}
%>

				
				</select>
		</td>
	</tr>
	<tr width='100'>
		<td colspan=1  class="label" nowrap align='right'>Gender</td>
		<td align='left'>&nbsp;<select name='gender' id='gender' <%=gender_disabled%>>
				<option value="">------- Select ------</option>
				<option value="M">Male</option>
				<option value="F">Female</option>
				<option value="U">Unknown</option>
				</select>
		</td>
		<td colspan=1  class="label" nowrap align='right'>Position</td>
		<td align='left'>&nbsp;<select name='job_title' id='job_title' <%=job_title_disabled%>>
		<option value="">------- Select ------</option>
		<%
		String	Sql2="select position_code,position_desc from am_position where role_type='P' and eff_status='E'  order by 2";


			Arr_Of_HashMap= getData( Sql2, null,out,con);
			general_HashMap.clear();
	
			for(int i=0; i<Arr_Of_HashMap.size();i++){
				general_HashMap=(HashMap)Arr_Of_HashMap.get(i);%>
				<option value= '<%=general_HashMap.get("POSITION_CODE")%>' > <%=general_HashMap.get("POSITION_DESC")%></option>
				<%				
			}
		%>
		</select>
		</td>
		
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
		<td align='right'><input type="button" align="left" name="Search" id="Search" value="Search" onClick="valtext(true); " class='button' >&nbsp;&nbsp;
		<input type="button"  align="left" name="clear" id="clear" value="Clear" class='button'  onClick="on_Clear(); ">
		</td>
	</tr>
</table>
<BR>
<BR>
	<input type="hidden"  name=user_sql1 value="" >
	<input type="hidden"  name=user_sql2 value="" >
<input type="hidden"  name=toggle_sql2 value="" >
	<input type="hidden" name=radiovalue value="">	
	<input type="hidden" name=temp_practID value="<%=temp_practID%>">	
	<input type="hidden" name=pract_retval value="<%=pract_retval%>">	
		</form>
	
</body>

<%
}catch(Exception e)
{
		
	//	out.println(e.toString);

}
	finally
	{
		if (con != null) 
			ConnectionManager.returnConnection(con,request);
	}		
		%>
		<script>
		

		//document.general_search_criteria.Search.click()
	

		</script>
		</html>

