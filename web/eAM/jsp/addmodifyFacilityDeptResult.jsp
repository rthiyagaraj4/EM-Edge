<!DOCTYPE html>
<%--
	FileName	: addmodifyFacilityDeptResult.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language=javascript>
	function submitPrevNext(from, to)
	{
		document.forms[0].totalvalues.value=parent.frames[0].temp;

		document.forms[0].from.value = from;
	    document.forms[0].to.value = to;
	    document.forms[0].submit();
	}
 </script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement()" >
	<form name='Facility_dept_result' id='Facility_dept_result' action='../../eAM/jsp/addmodifyFacilityDeptResult.jsp' method='post' >
   <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	int initCount = 1;
	Statement pstmt=null;
	Statement stmt = null;
	
	ResultSet rset=null ;
	ResultSet rstlRs2=null;

	String totalvalues= request.getParameter("totalvalues");
	if(totalvalues == null) totalvalues="";

	String facility=request.getParameter("facility");
	if(facility == null) facility="";
	try
	{
	con = ConnectionManager.getConnection(request);
	    String  chkboxAttribute="";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;

		String search_by=request.getParameter("search_by");
		String search_txt=request.getParameter("search_txt");
		if(search_by == null) search_by="";
		if(search_txt == null) search_txt="";

		String search_by1="";
		String search_by2="";


		if(search_by.equals("01"))
		{
		   search_by1="DEPT_CODE";
		   search_by2="DEPT_CODE";
		}
		else if(search_by.equals("02"))
		{
			search_by1="DEPT_LONG_DESC";
			search_by2="LONG_DESC";
		}

	
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }


String eff_status="";String dept_code="";String prefix_facl_id_for_int_yn="";
//String deptSql="Select dept_code,long_Desc, Eff_Status, upd_ind,upper (long_Desc), prefix_facl_id_for_int_yn  from (Select dept_code, dept_long_Desc long_desc, Eff_Status, 'Y' upd_ind, prefix_facl_id_for_int_yn   from AM_Facility_dept_Vw where eff_status='E' and  Operating_Facility_Id = '"+facility+"' Union  Select dept_Code, long_Desc,'D' Eff_Status,'N' upd_ind, prefix_facl_id_for_int_yn from  AM_dept a, sm_acc_entity_param b, sm_acc_entity_param_facl c where  a.acc_entity_id = b.acc_entity_id and b.acc_entity_id = c.acc_entity_id and c.facility_id = '"+facility+"' and eff_status='E' and dept_Code not in (Select dept_Code from Am_Facility_dept_VW where eff_status='E' and  Operating_Facility_Id = '"+facility+"') )  order by  upper (long_Desc)  ";

String deptSql ="Select dept_code,long_Desc, Eff_Status, upd_ind,upper (long_Desc), prefix_facl_id_for_int_yn  from (Select dept_code, dept_long_Desc long_desc, Eff_Status, 'Y' upd_ind, prefix_facl_id_for_int_yn   from AM_Facility_dept_Vw where eff_status='E' and  Operating_Facility_Id = '"+facility+"'";
if(!search_by.equals("") && !search_txt.equals(""))
          deptSql = deptSql +" and upper("+search_by1+")  like upper('"+search_txt+"%')"; 

 deptSql = deptSql + " Union  Select dept_Code, long_Desc,'D' Eff_Status,'N' upd_ind, prefix_facl_id_for_int_yn from  AM_dept a, sm_acc_entity_param b, sm_acc_entity_param_facl c where  a.acc_entity_id = b.acc_entity_id and b.acc_entity_id = c.acc_entity_id and c.facility_id = '"+facility+"' and eff_status='E'";
 if(!search_by.equals("") && !search_txt.equals(""))
          deptSql = deptSql +" and upper(a."+search_by2+")  like upper('"+search_txt+"%')";

 deptSql = deptSql +" and dept_Code not in (Select dept_Code from Am_Facility_dept_VW where eff_status='E' and  Operating_Facility_Id = '"+facility+"'";
 if(!search_by.equals("") && !search_txt.equals(""))
          deptSql = deptSql +" and upper("+search_by1+")  like upper('"+search_txt+"%')";

  deptSql = deptSql + ") )  order by  upper (long_Desc)  ";

	try
	{
		 pstmt= con.createStatement();
		 rset = pstmt.executeQuery(deptSql);
		 }
	catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}

		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ )
		 {
		  rset.next() ;
		 }
		  initCount+=start;
		  --initCount;
		}

		while( i<=end && rset.next()   )
		{
			if(maxRecord==0)
			{

%>

	<table border='0' cellpadding='0' cellspacing='0' width='98%' align='center'>
	<tr>
		<td class="white">
			<table border='0' align='right'>
			<tr>
				

	<%
	    if ( !(start <= 1)) {
	%>
	   <td id='prev'> <a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)'  text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>

	<%
	    }
	//    if ( !((start+12) > maxRecord )){
	%>
	    <td  id='next'><a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
	 //   }
	%>

			</tr>
			</table>
		</td>
	</tr>

<%

%>

	<tr>
		<td>
			<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
				<td class='columnheader' width='80%'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='10%' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			</tr>

<% }
		String classValue="";String flag="";
			dept_code = rset.getString("dept_code");
				if(dept_code == null) dept_code="";

			eff_status= rset.getString("eff_status");
				if(eff_status ==null) eff_status="";
				 prefix_facl_id_for_int_yn = rset.getString("prefix_facl_id_for_int_yn");
			if (prefix_facl_id_for_int_yn==null) prefix_facl_id_for_int_yn="N";

			if(eff_status.equals("E"))
				chkboxAttribute ="CHECKED";
			else
				chkboxAttribute="";

			if( i%2 == 0)  classValue="QRYEVEN";
			else
			classValue="QRYODD";
			flag=rset.getString(4).trim();
		
				
				out.println("<tr>");
				out.println("<td class='"+classValue+"'>"+rset.getString(2)+"</td>");
				out.println("<td class='"+classValue+"' align='center'><input type='hidden' name='flag"+i+"' id='flag"+i+"' value='"+dept_code+"$"+rset.getString(3).trim()+"$"+flag+"' ><input type='checkbox'  onClick='parent.frames[0].changeValue(flag"+i+",this,totalvalues)'  "+chkboxAttribute+" name='enabled"+i+"' id='enabled"+i+"' value='"+dept_code+"'></td>");
				out.println("</tr>");
				i++;
				maxRecord++;
		}//end of while

	if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
<%}

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
<%}
%>
	<input type=hidden name=from value='<%=start%>'>
	<input type=hidden name=to value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type='hidden' name='facility' id='facility' value="<%=facility%>" >
	<input type='hidden' name='function_name' id='function_name' value='modify'>
	<input type=hidden name='totalvalues' id='totalvalues' value="<%=totalvalues%>">
	<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
	<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>

			</table>
		</td>
	</tr>
	</table>
<%

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
	  //out.print(e);
	  e.printStackTrace();
	}
  finally
  {
	try
	{	if(rstlRs2!=null) rstlRs2.close();
		if(rset!=null) rset.close();
		if(stmt!=null) rstlRs2.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(con,request);
  }
  %>

