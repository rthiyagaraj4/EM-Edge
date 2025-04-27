<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String totalvalues= request.getParameter("totalvalues");
	if(totalvalues == null) totalvalues="";

	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String  req_start   =   "", req_end     =   "";
	String  checkedOnes         =   "";

	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	String search_by1="";
	String search_by2="";


	if(search_by.equals("01"))
	{
	   search_by1="SERVICE_CODE";
	   search_by2="SERVICE_CODE";
	}
	else if(search_by.equals("02"))
	{
		search_by1="SERVICE_LONG_DESC";
		search_by2="LONG_DESC";
	}

	
	req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
    req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
    int j=0;

	 if(from != null && to != null)
	 {
		for( int i2=(Integer.parseInt(req_start)); i2<=(Integer.parseInt(req_end)); i2++)
		{
			    if(request.getParameter("chk"+(i2-1)) != null)
			    {
				checkedOnes = request.getParameter("enable"+(i2-1));
				if(!(accessRightRecSet.containsObject(checkedOnes)))
				    accessRightRecSet.putObject(checkedOnes);

				j++;
			    }
		 }
	    out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
	    out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	if (from == null)
	{
		start = 0 ;
	}
	else
	{
		start = Integer.parseInt( from ) ;
	}
	if (to == null)
	{
		end = 11 ; 
	}   
	else 
	{
		end = Integer.parseInt( to ) ;
	}
	String facility_id=(String)request.getParameter("facility_id");
	if(facility_id == null)
		facility_id="";
	String dept_code=(String)request.getParameter("dept_code");

	if(dept_code == null) dept_code="";
	

//String sql=" Select Service_code, Service_long_Desc, Eff_Status, decode(eff_status,'E','Y','N') upd_ind  from AM_Facility_Service_vw where Operating_Facility_Id = '"+facility_id+"' And Dept_Code = '"+dept_code+"' Union Select Service_Code, long_Desc Service_long_Desc, Eff_Status, 'N' upd_ind from AM_Service where EFF_status = 'E' AND Service_Code NOT IN (select service_code from AM_Facility_Service where Operating_Facility_Id = '"+facility_id+"' And Dept_Code = '"+dept_code+"')order by Service_long_Desc";

 String sql =" Select Service_code, Service_long_Desc, Eff_Status, decode(eff_status,'E','Y','N') upd_ind  from AM_Facility_Service_vw where Operating_Facility_Id = '"+facility_id+"' And Dept_Code = '"+dept_code+"'";
 if(!search_by.equals("") && !search_txt.equals(""))
          sql = sql +" and upper("+search_by1+")  like upper('"+search_txt+"%')"; 
 
 sql = sql +" Union Select Service_Code, long_Desc Service_long_Desc, Eff_Status, 'N' upd_ind from AM_Service where EFF_status = 'E'";
 if(!search_by.equals("") && !search_txt.equals(""))
          sql = sql +" and upper("+search_by2+")  like upper('"+search_txt+"%')"; 
 
 sql = sql +" AND Service_Code NOT IN (select service_code from AM_Facility_Service where Operating_Facility_Id = '"+facility_id+"' And Dept_Code = '"+dept_code+"'";
 
 sql = sql +")order by Service_long_Desc";


	Connection conn = null;
	ResultSet rset=null;
	Statement stmt = null;
	try
	{
		conn = ConnectionManager.getConnection(request);

		stmt = conn.createStatement();
		
		rset = stmt.executeQuery(sql);
		
	%>
<html>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../../eAM/js/Serviceinfacility.js'  language='javascript'></script>
	<script>
		function submitPrevNext(from, to)
		{
		   document.forms[0].totalvalues.value=parent.frames[0].temp;

		   document.forms[0].from.value = from;
		   document.forms[0].to.value = to;
		   document.forms[0].submit();
		}
	</script>

<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='serviceinfacilityResult_form' id='serviceinfacilityResult_form' action='../../eAM/jsp/md_addModifyServiceinfacilityResult.jsp' method='post' >

	<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
	<tr>
		<td class="white">
			<table border='0' align='right'>
			<tr>
				

<%

	 int i=0;
	 if (start != 0)
	 {
		for(int j2=1; j2<=start; i++,j2++){
		rset.next() ;
	 }
	}

	while(rset.next() && i<=end)
{
		if(maxRecord==0)
	{

    if ( !(start <= 1))
	{
%>
   <td id='prev' name='prev' ><a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)'  text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
 //   if ( !((start+12) >= maxRecord ))
	{
%>
   <td id='next'><a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)'  text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
			
			</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td>
			<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
				<td class='columnheader' width='60%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='15%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			</tr>

<% }
String classValue="";
String chk="";

	
	if(rset.getString("upd_ind").equals("Y"))
		chk="CHECKED";
	else
		chk="";

	if(i%2 == 0)
		classValue="QRYODD";
	else
		classValue="QRYEVEN";
	out.println("<tr>");
	out.println("<td class='"+classValue+"'>"+rset.getString(2)+"<input type='hidden'  value='"+rset.getString("service_code")+"$"+rset.getString(3)+"$"+rset.getString(4).substring(0,1)+"'  name='enable"+i+"' id='enable"+i+"' ></td>");
	out.println("<td class='"+classValue+"' align='center' ><input type='checkbox' onClick='parent.frames[0].changeValue(enable"+i+",this,totalvalues)'  "+chk+"   value='"+rset.getString(3)+"'  name='chk"+i+"' id='chk"+i+"'></td>");
	out.println("</tr>");
	i++;
	maxRecord++;
 }//end of while
 if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
    out.println("<script>parent.frames[1].document.location.href='../../eCommon/html/blank.html';</script>");
}

if ( maxRecord < 12 || (!rset.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

		StringTokenizer steff=new StringTokenizer(totalvalues,"~");
		int temp1=steff.countTokens();
		for(int u3=0;u3<temp1;u3++)
		{
			String st4=steff.nextToken();
			StringTokenizer st5=new StringTokenizer(st4,"$");
			st5.nextToken();
			String status=st5.nextToken();
			st5.nextToken();
			String name=st5.nextToken();
			
			if(status.equals("E"))
				out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=true;</script>");
			else
				out.println("<script>if(document.forms[0]."+name+") document.forms[0]."+name+".checked=false;</script>");
		}
}
catch(Exception e)
{
	out.println(e);
	e.printStackTrace();
}
finally
{
	try
	{
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);
}
%>
			</table>
		</td>
	</tr>
	</table>
	<input type='hidden' name='operating_facility_id' id='operating_facility_id' value='<%=facility_id%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >

	<input type='hidden' name='dept_code' id='dept_code' value='<%=dept_code%>' >
	<input type='hidden' name='function_name' id='function_name' value='insert' >
	<input type='hidden' name='count' id='count' value='<%=j%>' >

	<input type=hidden name=totalvalues id=totalvalues value="<%=totalvalues%>">
	<input type=hidden name=from id=from  value='<%=start%>'>
	<input type=hidden name=to id=to value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
	<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>

</form>
</body>
</html>

