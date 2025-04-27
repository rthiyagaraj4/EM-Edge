<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>



<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >
<%
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String facilityid=(String)session.getValue("facility_id");
	
	StringBuffer sql=new StringBuffer();
	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.append("where C.appl_user_id=A.appl_user_id and C.resp_id=B.resp_id ");
	String userid = request.getParameter("user_id");
	String username=request.getParameter("user_name");
	String responsibilityid = request.getParameter("resp_id");
	String responsibilityname = request.getParameter("resp_name");
	String employeeNo = request.getParameter("emp_no");

	userid=userid.toUpperCase();
	responsibilityid=responsibilityid.toUpperCase();

	if ( !(userid == null || userid.equals("")) )
		{
			sql.append("and upper(C.appl_user_id) like upper('"+userid+"%' )");
			//andCheck = 1;
		}

	if ( !(username == null || username.equals("")) )
		{
			sql.append("and upper(A.appl_user_name) like upper('"+username+"%') ");
			//andCheck = 1;
		}

	if ( !(responsibilityid == null || responsibilityid.equals("")) )
		{
			sql.append("and upper(C.resp_id) like upper('"+responsibilityid+"%')");
			//andCheck = 1;
		}

	if ( !(responsibilityname == null || responsibilityname.equals("")) )
		{
			sql.append("and upper(B.resp_name)  like upper('"+responsibilityname+"%') ");
			//andCheck = 1;
		}

	if ( !(employeeNo == null || employeeNo.equals("")) )
		{
			sql.append("and upper(A.employee_no) like upper('"+employeeNo+"%') ");
			//andCheck = 1;
		}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
		 	{
			 	if ( i == ord.length - 1 )
				sql.append(ord[i]);
				else
				sql.append(ord[i]+",");
			}
		}
	} //end of where clause IF

 else
    {
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(whereClause);
    }
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
		
	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		

Connection conn=null;
			try{
			conn = ConnectionManager.getConnection(request);

java.sql.Statement stmt1=null;
ResultSet rset=null;
int cnt = 0;
String endOfRes="1";
try{

stmt1 = conn.createStatement();
String strSQL1="select C.appl_user_id,A.appl_user_name,C.resp_id,B.resp_name,C.eff_date_from,C.eff_date_to,A.employee_no from sm_appl_user A,sm_resp B,sm_resp_for_user C "+sql.toString();
rset = stmt1.executeQuery(strSQL1);
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "" ;
	while ( rset.next() && i<=end ){
		if(cnt==0){

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../jsp/ResponsibilityforUserQuery.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%}
if (endOfRes.equals("1"))
	{%>
	<A id='nextval' HREF='../jsp/ResponsibilityforUserQuery.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></th>

<%}

	
	java.util.Date date=new java.util.Date();
	java.util.Date date1=new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");

        if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		
		
%>
	<tr><td class='<%=classValue%>'>

<%
	String uid = rset.getString(1);
	String uname = rset.getString(2);
	String rid = rset.getString(3);
	String rname = rset.getString(4);

%>
	<%=uid%></td><td class='<%=classValue%>'>
	<%=uname%></td><td class='<%=classValue%>'>
	<%=rid%></td><td class='<%=classValue%>'>
	<%=rname%></td><td class='<%=classValue%>'>
<%
	if ( rset.getDate("eff_date_from") != null )
	{
	  date = rset.getDate("eff_date_from");
	 
	 String dateString = formatter.format(date);
	 if( dateString==null) dateString="";
	 else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
	 out.println(dateString);
	 dateString = null;
	
	}
	else
	{%>
		&nbsp;
	<%}%>
	 </td><td class='<%=classValue%>'> 
	<%
	if ( rset.getDate("eff_date_to") != null )
	{
	  date1 = rset.getDate("eff_date_to");
	 	 
	 String dateString = formatter.format(date1);
	 if( dateString==null) dateString="";
	 else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
	 out.println(dateString);
	 
	
	}
	else
	{%>
		
		&nbsp;
	<%}%>
	</td>
	<% 
		String emp_no=rset.getString("employee_no");
	if(emp_no==null)
		emp_no="&nbsp;";
	%>
	<td class='<%=classValue%>'><%=emp_no%>
	<%	i++;
		cnt++;
	}
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rset.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById("nextval").innerHTML=" ";
		</script>
	<%}     
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
}catch(Exception e){
	e.toString();
}
%>

 </td></tr>
</table>
<br><center>

</center>
</BODY>
</HTML>
<%

		}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>

