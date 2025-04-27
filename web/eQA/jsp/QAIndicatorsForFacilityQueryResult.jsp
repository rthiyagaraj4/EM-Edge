<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()' >");

	String whereClause = request.getParameter("whereclause");

	//String sql ;
	StringBuffer sql		= new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	//sql="";
		if (sql.length() > 0) sql.delete(0,sql.length());
	String facilityid 	= request.getParameter("operating_facility_id");	
	if(facilityid==null) facilityid="";
	String facility_name 	= request.getParameter("facility_name");	
	if(facility_name==null) facility_name="";

	String qind_clind_id 	= request.getParameter("qind_clind_id");
	if(qind_clind_id==null) qind_clind_id="";
	
	String qind_clind_desc 	= request.getParameter("qind_clind_desc");
	if(qind_clind_desc==null) qind_clind_desc	="";

	String dflt_rep_periodicity 	= request.getParameter("dflt_rep_periodicity");	
	if(dflt_rep_periodicity==null||dflt_rep_periodicity.equals("S")) dflt_rep_periodicity="";

	String dflt_bd_by_gender_yn 	= request.getParameter("dflt_bd_by_gender_yn");	
	if(dflt_bd_by_gender_yn==null||dflt_bd_by_gender_yn.equals("S")) dflt_bd_by_gender_yn="";

	String dflt_bd_age_range_id	= request.getParameter("dflt_bd_age_range_id");
	if(dflt_bd_age_range_id==null) dflt_bd_age_range_id="";

	int andCheck = 0;

	facilityid=facilityid.toUpperCase();
	
	if ( !(facilityid == null || facilityid.equals("")) )
	{		if (sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where operating_facility_id like '"+facilityid+"%'");
		andCheck = 1;
	}
	if ( !(facility_name == null || facility_name.equals("")) )
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where upper(facility_name) like upper( '"+facility_name+"%')");
		andCheck = 1;
	}

	if ( !(qind_clind_desc == null || qind_clind_desc.equals("")) )
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where qind_clind_desc like '"+qind_clind_desc+"%'");
		andCheck = 1;
	}
	if ( !(qind_clind_id == null || qind_clind_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("qind_clind_id like  upper('"+qind_clind_id+"%') " );
		}
		else
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where qind_clind_id like upper('"+qind_clind_id+"%') ");
			andCheck = 1;
		}
	}
	
	if ( !(dflt_rep_periodicity == null || dflt_rep_periodicity.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(dflt_rep_periodicity) like  upper('"+dflt_rep_periodicity+"%')" );
		}
		else
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(dflt_rep_periodicity) like upper('"+dflt_rep_periodicity+"%')" );
			andCheck = 1;
		}
	}
	if ( !(dflt_bd_by_gender_yn == null || dflt_bd_by_gender_yn.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			//sql.append(sql)
			sql.append(" and ");
			sql.append("  upper(dflt_bd_by_gender_yn)  like  upper('"+dflt_bd_by_gender_yn+"%') " );
		}
		else
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper( dflt_bd_by_gender_yn) like  upper('"+dflt_bd_by_gender_yn+"%') " );
			andCheck = 1;
		}
	}	
	
	
	if ( !(dflt_bd_age_range_id == null || dflt_bd_age_range_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(dflt_bd_age_range_id) like  upper('"+dflt_bd_age_range_id+"%')" );
		}
		else
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper(dflt_bd_age_range_id) like upper('"+dflt_bd_age_range_id+"%')" );
			andCheck = 1;
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
			{
				sql.append(ord[i]);
				sql.append(",");
			}
		}
	}
} //end of where clause IF
	else 
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
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
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
StringBuffer strsql1 = new StringBuffer();
strsql1.append("select count(*) as total from qa_qind_facility_clind_vw ");
strsql1.append(sql.toString());

rs = stmt.executeQuery(strsql1.toString());
rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");

if(stmt!=null) 	stmt.close();
StringBuffer strsql2  = new StringBuffer();
strsql2.append("select * from qa_qind_facility_clind_vw ");
strsql2.append(sql.toString());;

stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2.toString());

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorsForFacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorsForFacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>Next</A>");
%>
</td>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th>Facility ID</th>
<th>Facility Name</th>
<th>Indicator ID</th>
<th>Periodicity</th>
<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  
while ( rs.next() && i<=end )
{
       if ( i % 2 == 0 )
	  	classValue = "QRYEVEN" ;
	  else
	  	classValue = "QRYODD" ;
	  


	out.println("<tr><td class='" + classValue + "' >");
	String operating_facility_id 	= rs.getString("operating_facility_id");
	String qind_clind_id	= rs.getString("qind_clind_id");
	String facilityname	= rs.getString("facility_name");
	String dflt_bd_by_gender_yn 	= rs.getString("dflt_bd_by_gender_yn");	
	if(dflt_bd_by_gender_yn==null||dflt_bd_by_gender_yn.equals("N"))dflt_bd_by_gender_yn="";
	String dflt_rep_periodicity 	= rs.getString("DFLT_REP_PERIODICITY_DESC");	
if(dflt_rep_periodicity==null)dflt_rep_periodicity="&nbsp;";
	String dflt_bd_age_range_id 	= rs.getString("dflt_bd_age_range_id");	
	if(dflt_bd_age_range_id==null)dflt_bd_age_range_id="&nbsp;";
	
	
	
	
	



	
	out.println("<a href='../../eQA/jsp/QAModifyIndicatorsForFacility.jsp?operating_facility_id="+operating_facility_id+"&qind_clind_id="+qind_clind_id+"' target='f_query_add_mod' >");
	out.println(operating_facility_id +"</a></td><td class='" + classValue + "' >");
	
	out.println(facilityname+"</td><td class='" + classValue + "' >");
	
	out.println(qind_clind_id+"</td><td class='" + classValue + "' >");

	out.println(dflt_rep_periodicity+"</td>");
/*	out.println(dflt_bd_age_range_id+"</td><td class='" + classValue + "' align=center> ");
	if (dflt_bd_by_gender_yn.equals("Y") )
	{

	out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			
	}
	else
	{
	
	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");;
	}*/	
	out.println("</td>");



	
		
	i++;

  }//endwhile
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	if(rs!=null) 	rs.close();
	if(stmt!=null) 	stmt.close();
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/FacilitySectionqueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/FacilitySectionqueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
rs.close();
%-->
</center>
</BODY>
</HTML>

