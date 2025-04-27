<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<HTML><head>
   <%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT'>
<%
 request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
	StringBuffer sql=new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		String cd = request.getParameter("user_id");
		String fnm = request.getParameter("username");
		String facilityid=request.getParameter("facilityid");
		String facility_name=request.getParameter("facilityname");
		String employeeNo = request.getParameter("emp_no");
		//int andCheck = 0;
		
		if ( !(cd == null || cd.equals("")) )
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("and upper(sm_facility_for_user.appl_user_id) like upper('"+cd+"%')");
		//andCheck = 1;
		}



		if ( !(facilityid == null || facilityid.equals("")) )
		{
			sql.append(" and ");
			sql.append("upper(sm_facility_for_user.facility_id) like  upper('"+facilityid+"%')");
		}

		if ( !(employeeNo == null || employeeNo.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(sm_appl_user.employee_no) like  upper('"+employeeNo+"%') ");
		}

		if ( !(fnm == null || fnm.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(sm_appl_user.appl_user_name) like  upper('"+fnm+"%') ");
		}
		
		if ( !(facility_name == null || facility_name.equals("")) )
		{
			sql.append(" and ");
			sql.append(" upper(sm_facility_param.facility_name)  like  upper('"+facility_name+"%') ");
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
Statement stmt=null;
ResultSet rs=null;
int cnt = 0;
String endOfRes="1";

try
{

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
if(rs!=null)rs.close();
rs = stmt.executeQuery("select sm_facility_for_user.appl_user_id, sm_appl_USER.appl_user_name, sm_facility_for_user.facility_id,sm_facility_param.facility_name, sm_facility_for_user.remarks,sm_appl_user.employee_no,sm_facility_for_user.access_eff_date_from, sm_facility_for_user.access_eff_date_to from sm_facility_for_user,sm_facility_param,sm_appl_user where sm_facility_for_user.appl_user_id=sm_appl_user.appl_user_id and sm_facility_for_user.facility_id=sm_facility_param.facility_id "+sql.toString());
 	if ( start != 1 )
 	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;
	  
	  while ( i<=end  && rs.next()){
		  if(cnt==0){
%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../../eSM/jsp/queryFacilityForUser.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%}
if ( endOfRes.equals("1")){%>
	<A id='nextval' HREF='../../eSM/jsp/queryFacilityForUser.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}%>
</td>
</tr>
</table>
<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></th>
<%}

	  java.util.Date date =new java.util.Date();
      java.util.Date date1 =new java.util.Date();
	  java.text.SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	  
	 if ( i % 2 == 0 )
	 	  	classValue = "QRYEVEN" ;
	 	  else
	 	  	classValue = "QRYODD" ;
	 %>	  

	<tr><td class='<%=classValue%>'>
	<%=rs.getString("appl_user_id")%></td><td class='<%=classValue%>'>
	<%=rs.getString("appl_user_name")%></td><td class='<%=classValue%>'>
	<%=rs.getString("facility_id")%></td><td class='<%=classValue%>'>
	<%=rs.getString("facility_name")%>
	</td><td class='<%=classValue%>'>
	<%if ( rs.getDate("access_eff_date_from") != null )
	{
		  date = rs.getDate("access_eff_date_from");
		 
		 String dateString = formatter.format(date);
		 if( dateString==null) dateString="";
		else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
		 out.println(dateString);
		 //dateString = null;
		// formatter = null;
		}
		else
		{%>
			&nbsp;
		<%}%>
		</td><td class='<%=classValue%>'>
		<%	
		if ( rs.getDate("access_eff_date_to") != null )
		{
		  date1 = rs.getDate("access_eff_date_to");
		 
		 String dateString = formatter.format(date1);
		 if( dateString==null) dateString="";
		else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
		 out.println(dateString);
		}
		else
		{%>
			&nbsp;
	<%}%>
		</td> <td class='<%=classValue%>'>
	<%
		String employeee_no=rs.getString("employee_no");
	if(employeee_no==null)
		employeee_no="&nbsp;";
	%>
	<%=employeee_no%>
	</td>
	<%
	i++;
	cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById('nextval').innerHTML=" ";
		</script>
	<%} 
	if(rs!=null) 	rs.close();
	if(stmt!=null)	stmt.close();	
}
catch(Exception e){out.print(e);}
finally
{
	ConnectionManager.returnConnection(conn,request);
}%>

</td></tr>
</table>
<br><center>

</center>
</BODY>
</HTML>

