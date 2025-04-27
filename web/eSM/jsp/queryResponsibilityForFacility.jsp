<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
<% request.setCharacterEncoding("UTF-8");%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  onKeyDown = 'lockKey()'; class='CONTENT' OnMouseDown='CodeArrest()'>
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
	StringBuffer sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
		String cd = request.getParameter("resp_id");
		String rsn = request.getParameter("resp_name");
		String fnm = request.getParameter("facilityname");
		String fac=request.getParameter("facilityid");	
		
		if ( !(cd == null || cd.equals("")) )
		{
		sql.append(" and upper(sm_facility_for_resp.resp_id) like upper('"+cd+"%')");
		
		}

		if ( !(rsn == null || rsn.equals("")) )
		{
		sql.append( " and ");
		sql.append(" upper(sm_resp.resp_name)  like  upper('"+rsn+"%') " );
		
		}

		if ( !(fac == null || fac.equals("")) )
		{
		sql.append(" and ");
		sql.append("upper(sm_facility_for_resp.facility_id) like  upper('"+fac+"%')") ;
		
		}

		if ( !(fnm == null || fnm.equals("")) )
		{
		sql.append(" and ");
		sql.append(" upper(sm_facility_param.facility_name)  like  upper('"+fnm+"%') ");
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
		sql.append(whereClause);

	
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
      request.setCharacterEncoding("UTF-8");
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

rs = stmt.executeQuery("select sm_facility_for_resp.resp_id, sm_resp.resp_name, sm_facility_for_resp.facility_id,sm_facility_param.facility_name from sm_facility_for_resp,sm_facility_param,sm_resp where sm_facility_for_resp.resp_id=sm_resp.resp_id and sm_facility_for_resp.facility_id=sm_facility_param.facility_id "+sql.toString());
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
<%if ( !(start <= 1) ){%>
	
	<A HREF='../../eSM/jsp/queryResponsibilityForFacility.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/>
</A>

<%}if ( endOfRes.equals("1")){%>
	<A id='nextval' HREF='../../eSM/jsp/queryResponsibilityForFacility.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%}%>		
</td>
</tr>
</table>
<br><br>
</p>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<%}

	 if ( i % 2 == 0 )
	 	  	classValue = "QRYEVEN" ;
	 	  else
	 	  	classValue = "QRYODD" ;
	 	  
%>
	<tr><td class='<%= classValue %>'>
<%
	String code = rs.getString("resp_id");
	String fac=rs.getString("facility_id");
%>
	<%=code%></td><td class='<%=classValue%>'>
	<%=rs.getString("resp_name")%>
	</td><td class='<%=classValue %>'>
	<%=fac%>
	</td> <td class='<%=classValue %>'>
	<%=rs.getString("facility_name")%>
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
catch(Exception e){}
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

