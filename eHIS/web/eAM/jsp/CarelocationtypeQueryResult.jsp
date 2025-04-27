<!DOCTYPE html>
<%--
	FileName	: CarelocationtypeQueryResult.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='Carelocn_form_query' id='Carelocn_form_query'>
<%
	request.setCharacterEncoding("UTF-8");
	String id[]={"R","C","N","S","T","E","B","W","O","D"};

	String val[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StudyLocation.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OperationTheatreAll.label","am_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExamProcedureUnit.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Bed.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OperationTheatrespec.label","am_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")};
	String clti="";

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{	
		sql.setLength(0);
		sql.append("");

		String locntype    = request.getParameter("locn_type")==null ?"":request.getParameter("locn_type");	
		String longdesc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");	
		String locntypelist    = request.getParameter("LocnTypeList")==null ?"":request.getParameter("LocnTypeList");	
		//out.println("<script>alert('"+locntypelist+"')</script>");
		String user_defined = request.getParameter("user_defined") == null ?"":request.getParameter("user_defined");
	
		int andCheck = 0;

		locntype=locntype.toUpperCase();

		if ( !(locntype == null || locntype.equals("")) )
		{
		   sql.setLength(0);
		   sql.append("where upper(locn_type) like upper('"+locntype+"%')");
		   andCheck = 1;
		}
		
		if ( !(user_defined == null || user_defined.equals("B")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and sys_user_def_ind like '"+user_defined+"%'");

				   }
				   else
				   {
					sql.setLength(0);
					sql.append("where sys_user_def_ind like '"+user_defined+"%'" );
					andCheck = 1;
				   }
		}
		
		
		
		
		if ( !(longdesc == null || longdesc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and upper(long_desc)  like upper('"+longdesc+"%') ");

				   }
				   else
				   {
					sql.setLength(0);
					sql.append("where upper(long_desc)  like upper('"+longdesc+"%') " );
					andCheck = 1;
				   }
		}

		if ( !(locntypelist == null || locntypelist.equals("")) )
		{
		   if ( locntypelist.equals("R") )
		   {
			if ( andCheck == 0 )
			   {
				sql.setLength(0);
				sql.append("where care_locn_type_ind='R'");
			   }
			else
				sql.append(" and care_locn_type_ind='R'");
		    }
		    if ( locntypelist.equals("C") )
		    {
			if ( andCheck == 0 )
				{
				sql.setLength(0);
				sql.append(" where  care_locn_type_ind='C'");
				}
			else
				sql.append(" and care_locn_type_ind='C'");
		    }
		    if ( locntypelist.equals("N") )
		    {
		    	if ( andCheck == 0 )
				{
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='N'");
				}
		    	else
					sql.append(" and care_locn_type_ind='N'");
				
		    }
		    
		    if ( locntypelist.equals("S") )
		    {
		    	if ( andCheck == 0 )
				{	
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='S'");
				}
		    	else

		    		sql.append(" and care_locn_type_ind='S'");
		    }
		    
		    if ( locntypelist.equals("T") )
		    {
		    	if ( andCheck == 0 )
				{	
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='T'");
				}
		    	else
		    		sql.append(" and care_locn_type_ind='T'");
		    }
			if ( locntypelist.equals("E") )
		    {
		    	if ( andCheck == 0 )
				{	
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='E'");
				}
		    	else
		    		sql.append(" and care_locn_type_ind='E'");
		    }
			if ( locntypelist.equals("B") )
		    {
		    	if ( andCheck == 0 )
				{	
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='B'");
				}
		    	else
		    		sql.append(" and care_locn_type_ind='B'");
		    }
			if ( locntypelist.equals("W") )
		    {
		    	if ( andCheck == 0 )
				{
		    		sql.append(" where  care_locn_type_ind='W'");
				}
		    	else
		    		sql.append(" and care_locn_type_ind='W'");
		    }
			if ( locntypelist.equals("O") )
		    {
		    	if ( andCheck == 0 )
				{	
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='O'");
				}
		    	else
		    		sql.append(" and care_locn_type_ind='O'");
		    }
				if ( locntypelist.equals("D") )
		    {
		    	if ( andCheck == 0 )
				{	
					sql.setLength(0);
		    		sql.append(" where  care_locn_type_ind='D'");
				}
		    	else
		    		sql.append(" and care_locn_type_ind='D'");
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
else
{
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

Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
Connection conn = ConnectionManager.getConnection(request);
int maxRecord = 0;
try{

stmt = conn.createStatement();



String strsql2="select * from am_care_locn_type "+sql;
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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/CarelocationtypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/CarelocationtypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>

</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </th>
<th><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></th>

<% }
 	
	  String classValue = "" ;
	  
       if ( i % 2 == 0 )
       	  	classValue = "QRYEVEN" ;
       	  else
       	  	classValue = "QRYODD" ;
       	  

	out.println("<tr><td class='" + classValue + "'>");
	String locntype = rs.getString("locn_type");
	String userdefined = rs.getString("sys_user_def_ind");

	out.println("<a href='../../eAM/jsp/addmodifyCarelocationtype.jsp?locn_type="+ locntype +"&sys_user_def_ind="+userdefined+"'target='f_query_add_mod' >");
	out.println(locntype+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	clti=rs.getString("care_locn_type_ind") ;
	
	for(int l=0; l<10; l++){
		if(id[l].equals(clti))
		out.println(val[l]);
	}
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("sys_user_def_ind").equals("S") )
	{
	
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	}
	else
	{
	
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	}
	i++;
	maxRecord++;
  }//endwhile

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

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

}//end of try
catch(Exception e){
		out.print(e.toString());
}
	finally 
	{
		try
		{
			if(rs!=null)	rs.close();
			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>

<%
rs.close();
%>

</center>
</BODY>
</HTML>

