<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'  >

<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.setLength(0);
	sql.append("");
	String serv_code = request.getParameter("service_code");
	String longdesc = request.getParameter("long_desc");
	String shortdesc=request.getParameter("short_desc");
	String enabled = request.getParameter("eff_status");
	String medicalyn=request.getParameter("medical_yn");
	String ancillaryyn=request.getParameter("ancillary_yn");
	int andCheck = 0;

	if ( !(serv_code == null || serv_code.equals("")) )
		{
		sql.setLength(0);
		sql.append("where upper(service_code) like upper('"+serv_code+"%')");
		andCheck = 1;
		}

	

	if ( !(shortdesc == null || shortdesc.equals("")) )
	   {
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append(" upper(short_desc)  like  upper('"+shortdesc+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(short_desc)  like upper('"+shortdesc+"%')" );
			andCheck = 1;
		}
	 }

	if ( !(longdesc == null || longdesc.equals("")) )
	    {
		 if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append("upper(long_desc)  like  upper('"+longdesc+"%')" );
			}
		else
			{
			sql.setLength(0);
				sql.append("where upper(long_desc) like upper('"+longdesc+"%')" );
				andCheck = 1;
			}
	}


	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
		if ( andCheck == 0 ) {
			sql.setLength(0);
			sql.append("where eff_status='E'");
			andCheck = 1; }
		else
			sql.append( " and eff_status='E'");
		}
	   if ( enabled.equals("D") )
		{
		if ( andCheck == 0 ) {
			sql.setLength(0);
			sql.append(" where  eff_status='D'");
			andCheck = 1; }
		else
			sql.append(" and eff_status='D'");
		}
	  
	}
	
		if ( !(medicalyn == null || medicalyn.equals("")) )
		{
		   if ( medicalyn.equals("Y") )
		        {
			if ( andCheck == 0 ) {
				sql.setLength(0);
				sql.append("where medical_yn='Y'");
				andCheck = 1; }
			else
				sql.append(" and medical_yn='Y'");
			}
		   if ( medicalyn.equals("N") )
			{
			if ( andCheck == 0 ) {
				sql.setLength(0);
				sql.append(" where  medical_yn='N'");
				andCheck = 1; }
			else
				sql.append(" and medical_yn='N'");
			}
		
		}

		
		
	if ( !(ancillaryyn == null || ancillaryyn.equals("")) )
		{
		   if ( ancillaryyn.equals("Y") )
		        {
			if ( andCheck == 0 ) {
				sql.setLength(0);
		 	     sql.append("where ancillary_yn='Y'"); 
		 	     andCheck = 1; }
			else
			     sql.append(" and ancillary_yn='Y'");
			}
		   
		   if ( ancillaryyn.equals("N") )
		    {
		        if ( andCheck == 0 ) {
					sql.setLength(0);
			      sql.append(" where  ancillary_yn='N'"); 
			      andCheck = 1; }
			else
		    	     sql.append(" and ancillary_yn='N'");
		    }
		
		 
			
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
	else{
		sql.setLength(0);
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



Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try
{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

int maxRecord = 0;
String strsql2="select service_code,long_desc,short_desc,ancillary_yn,medical_yn,eff_status from am_service "+sql.toString();
rs = stmt.executeQuery(strsql2);

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

while ( i<=end && rs.next() )
{
	if(maxRecord==0)
	{


%>

<p>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ServiceQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ServiceQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.AncillaryMedicalService.label" bundle="${am_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}

	  String classValue = "" ;
	  

        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;


		String code = rs.getString("service_code");
	  
	%>
	<tr>
		
	<td class=<%=classValue%>><a href='../../eAM/jsp/addModifyService.jsp?service_code=<%=code%>' target='f_query_add_mod' ><%=code%></a></td>
		
	<td class=<%=classValue%>><%=rs.getString("long_desc")%></td>
		
	<td class=<%=classValue%>><%=rs.getString("short_desc")%></td>
		
	<td class='<%=classValue%>' align='center' >
		
	<%
		if(rs.getString("medical_yn").equals("Y"))
	{%><img src='../../eCommon/images/enabled.gif'></img><%
	}else{
			%><img src='../../eCommon/images/RRnwd.gif'></img></td>
<%}%>


		<td class='<%=classValue%>' align='center'  >

<%	if(rs.getString("ancillary_yn").equals("Y"))
	{%><img src='../../eCommon/images/enabled.gif'></img><%
	}else{
		%><img src='../../eCommon/images/RRnwd.gif'></img></td>
<%}%>		
		
		<td  class='<%=classValue%>' align='center'>


<%	if ( rs.getString("eff_status").equals("E") )
	{%><img src='../../eCommon/images/enabled.gif'></img><%
	}else{
		%><img src='../../eCommon/images/RRnwd.gif'></img><%
	}
	i++;
	maxRecord++;
	}   //end of while
	

	  if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

if ( maxRecord < 14 || (!rs.next()) ) {
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

	if(rs!=null) 	rs.close();
    if(stmt!=null) 	stmt.close();
}
catch(Exception e) { out.println(e.toString());}

finally {
	try{
  if (stmt != null) stmt.close();
  if (rs != null)   rs.close();
	}
	catch(Exception e)
	{}
  
  ConnectionManager.returnConnection(conn,request);
}


%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

