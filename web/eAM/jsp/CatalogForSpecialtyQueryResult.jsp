<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = ConnectionManager.getConnection(request);///(Connection) session.getValue( "connection" ) ;
	//String facility_id = (String)session.getValue( "facility_id" );
	Statement stmt = null;
	ResultSet rs = null;
	
	stmt = conn.createStatement();
	out.println("<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link> </head><BODY   OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql= new StringBuffer() ;
	String order_cat_id ="";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		String specialty_code = request.getParameter("SPECIALITY_CODE");
		String splty_desc = request.getParameter("SPECIALITY_DESC");		
		order_cat_id = request.getParameter("ORDER_CATALOG_CODE");
		String stat_grp_desc1 = request.getParameter("ORDER_CATALOG_DESC");
		String ordcaty = request.getParameter("ORDER_CATEGORY");
		int andCheck 				= 0;
		
		


		if ( !(specialty_code == null || specialty_code.equals("")) )
		{
			
			if( andCheck == 1)
			{
			sql.append(" and upper(SPECIALITY_CODE) like upper('"+specialty_code+"%')");			
			andCheck 	= 1;
			
			}else
			{
			  sql.setLength(0);
			  sql.append(" where upper(SPECIALITY_CODE) like upper('"+specialty_code+"%')");
			  andCheck 	= 1;

			}
		}
		if ( !(splty_desc == null || splty_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				//sql.append(" and ");
				sql.append(" and upper(SPECIALITY_DESC) like upper('"+splty_desc+"%')");	
			}
			else
			{
				sql.setLength(0);
				sql.append(" where upper(SPECIALITY_DESC) like upper('"+splty_desc+"%')");
				andCheck 	= 1;
			}
		}
	
		if ( !(ordcaty == null || ordcaty.equals("")) )
		{
			if ( andCheck == 1 )
			{
				//sql.append(" and ");
				sql.append( " and upper(ORDER_CATEGORY) like upper('"+ordcaty+"%')");					
			}
			else
			{
				sql.setLength(0);
				sql.append( " where upper(ORDER_CATEGORY) like upper('"+ordcaty+"%')");
				andCheck 	= 1;
			}
		}
		
		if ( !(order_cat_id == null || order_cat_id.equals("")) )
		{
			if ( andCheck == 1 )
			{
				//sql.append(" and ");
				sql.append( " and upper(ORDER_CATALOG_CODE) like upper('"+order_cat_id+"%')");			
				andCheck 	= 1;
			}
			else
			{
				sql.setLength(0);
				sql.append( " where upper(ORDER_CATALOG_CODE) like upper('"+order_cat_id+"%')");
			}
		}
		if ( !(stat_grp_desc1 == null || stat_grp_desc1.equals("")) )
		{
			if ( andCheck == 1 )
			{
				//sql.append(" and ");		
				sql.append(" and upper(ORDER_CATALOG_DESC)  like  upper('"+stat_grp_desc1+"%') ");		
			}
			else
			{
				sql.setLength(0);
				sql.append(" where upper(ORDER_CATALOG_DESC)  like  upper('"+stat_grp_desc1+"%') ");	
				andCheck 	= 1;
			}
		}
		
		String ord[] = request.getParameterValues("orderbycolumns");
	
		
		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]).append(",");
			}
		}
	} //end of where clause IF
	else
	{
		sql.setLength(0);
		sql.append( whereClause );
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

	int maxRecord = 0;

	try{

	

	String strsql2="select SPECIALITY_CODE, SPECIALITY_DESC, ORDER_CATEGORY, ORDER_CAT_DESC, ORDER_CATALOG_CODE, ORDER_CATALOG_DESC from AM_CATALOG_FOR_SPECIALITY_VW "+sql.toString();

	rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	while ( i<=end && rs.next()  )
	{
		if(maxRecord==0)
		{
%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/CatalogForSpecialtyQueryResult.jsp?&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A  HREF='../../eAM/jsp/CatalogForSpecialtyQueryResult.jsp?&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></th>
<% }
 
	  String classValue = "" ;
	  
        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;
	
	out.println("<tr><td class='" + classValue + "'>");
	String specialty_code = rs.getString("SPECIALITY_CODE");
	String stat_grp_id6 = rs.getString("SPECIALITY_DESC");
	String stat_grp_id2 = rs.getString("ORDER_CATALOG_CODE");
	String stat_grp_id3 = rs.getString("ORDER_CATALOG_DESC");
	String dord = rs.getString("ORDER_CAT_DESC");
			
	out.println(specialty_code+"</td><td class='" + classValue + "'>");
	
	out.println(stat_grp_id6+"</a></td><td class='" + classValue + "'>");

	out.println(dord+"</a></td><td class='" + classValue + "'>");
	
	out.println(stat_grp_id2+"</a></td><td class='" + classValue + "'>");

	out.println(stat_grp_id3+"</a></td>");
	
	i++;
	maxRecord++;
	}//end of while

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

  if(rs !=null )rs.close();
  if(stmt != null )stmt.close();
  sql.setLength(0);

}
catch(Exception e) {
	//out.println(e);
	e.printStackTrace();
	}
	finally {
		try{
			  if (rs != null)   rs.close();
			  if (stmt != null) stmt.close();
		}catch(Exception e){}
	  if( conn != null) ConnectionManager.returnConnection(conn,request);
	}

%>

</td></tr>
</table>
<br><center>


</center>
</BODY>
</HTML>

