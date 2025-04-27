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
	sql.append(" where A.REQUESTOR_CODE=C.REQUESTOR_ID and b.CHK_LIST_CODE=c.CHK_LIST_CODE ");
	String requestor_code = request.getParameter("requestor_code");
	String long_description=request.getParameter("long_description");
	String chk_list_code = request.getParameter("chk_list_code");
	String chk_list_desc = request.getParameter("chk_list_desc");
	

	requestor_code=requestor_code.toUpperCase();
	chk_list_code=chk_list_code.toUpperCase();

	if ( !(requestor_code == null || requestor_code.equals("")) )
		{
			sql.append("and upper(c.REQUESTOR_ID) like upper('"+requestor_code+"%' )");
			
		}

	if ( !(long_description == null || long_description.equals("")) )
		{
			sql.append("and upper(a.LONG_DESC) like upper('"+long_description+"%') ");
			
		}

	if ( !(chk_list_code == null || chk_list_code.equals("")) )
		{
			sql.append("and upper(c.chk_list_code) like upper('"+chk_list_code+"%')");
			
		}

	if ( !(chk_list_desc == null || chk_list_desc.equals("")) )
		{
			sql.append("and upper(b.long_desc)  like upper('"+chk_list_desc+"%') ");
			
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
String strSQL1="select a.REQUESTOR_code,a.LONG_DESC req_long_desc,a.SHORT_DESC req_short_desc,b.CHK_LIST_CODE,b.LONG_DESC chk_long_desc,b.SHORT_DESC chk_short_desc from mr_requestor a,chk_list_medical_report b,mr_chklist_for_requestor c "+sql.toString();

rset = stmt1.executeQuery(strSQL1);
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "" ;
	while ( rset.next() && i<=end )
	{
		if(cnt==0)
		{

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../jsp/ChecklistForRequestorQuery.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%}
if (endOfRes.equals("1"))
	{%>
	<A id='nextval' HREF='../jsp/ChecklistForRequestorQuery.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMR.CheckLists.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMR.CheckLists.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMR.CheckLists.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>


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
	String requestor_code1 = rset.getString("REQUESTOR_code");
	String req_long_desc = rset.getString("req_long_desc");
	String req_short_desc = rset.getString("req_short_desc");
	String chk_code = rset.getString("CHK_LIST_CODE");
	String chk_long_desc = rset.getString("chk_long_desc");
	String chk_short_desc = rset.getString("chk_short_desc");
%>
	<%=requestor_code1%></td><td class='<%=classValue%>'>
	<%=req_long_desc%></td><td class='<%=classValue%>'>
	<%=req_short_desc%></td><td class='<%=classValue%>'>
	<%=chk_code%></td><td class='<%=classValue%>'>
	<%=chk_long_desc%></td><td class='<%=classValue%>'>
	<%=chk_short_desc%></td><td class='<%=classValue%>'>

	 </td>
	
	
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

 </tr>
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

