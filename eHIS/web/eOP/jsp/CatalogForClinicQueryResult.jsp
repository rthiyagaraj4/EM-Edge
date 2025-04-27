<!DOCTYPE html>
<!-- /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic	
*/ -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	String facility_id = (String)session.getValue( "facility_id" );
	String locn_type= "";
	String care_locn_type_ind="";
	Statement stmt = null;
	ResultSet rs = null;
		
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	out.println("<HTML><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY   OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >");

	String whereClause = request.getParameter("whereclause");
	locn_type = request.getParameter("locn_type");

	if(locn_type.equals("C"))
	{
		care_locn_type_ind="C";
	}
	else if(locn_type.equals("E"))
	{
		care_locn_type_ind="E";
	}
	else
	{
		//care_locn_type_ind="D";  	// Added the below code for IN023645 on 06.09.2010 by Suresh M
		care_locn_type_ind="Y";
	}
	
	StringBuffer sql= new StringBuffer() ;
	String order_cat_id ="";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		String visit_type_id = request.getParameter("CLINIC_CODE");
		String ldesc = request.getParameter("CLINIC_DESC");
		
		order_cat_id = request.getParameter("ORDER_CATALOG_CODE");
		String stat_grp_desc1 = request.getParameter("ORDER_CATALOG_DESC");
		String ordcaty = request.getParameter("ORDER_CATEGORY");

		if ( !(visit_type_id == null || visit_type_id.equals("")) )
		{
			sql.append(" and upper(CLINIC_CODE) like upper('"+visit_type_id+"%')");
			
		}
	
		if ( !(locn_type == null || locn_type.equals("")) )
		{
			sql.append(" and upper(CARE_LOCN_TYPE_IND) like upper('"+care_locn_type_ind+"%')");
						
		}
		if ( !(ordcaty == null || ordcaty.equals("")) )
		{
			sql.append( " and upper(ORDER_CATEGORY) like upper('"+ordcaty+"%')");
						
		}
		if ( !(ldesc == null || ldesc.equals("")) )
		{
			sql.append(" and upper(CLINC_DESC) like upper('"+ldesc+"%')");
						
		}
		if ( !(order_cat_id == null || order_cat_id.equals("")) )
		{
			sql.append( " and upper(ORDER_CATALOG_CODE) like upper('"+order_cat_id+"%')");
						
		}
		if ( !(stat_grp_desc1 == null || stat_grp_desc1.equals("")) )
		{
			sql.append(" and upper(ORDER_CATALOG_DESC)  like  upper('"+stat_grp_desc1+"%') ") ;
						
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
	else{
		sql.append( whereClause );

	}
	
	int endOfRes = 1;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int cnt = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

	//int maxRecord = 0;

	try{

	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

	/*String strsql1 = "select count(*) total from OP_CATALOG_FOR_CLINIC_VW where facility_id ='"+facility_id+"'"+sql.toString();

	rs = stmt.executeQuery(strsql1);	
	rs.next();
	maxRecord = rs.getInt("total");

	if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	}

	if(rs != null )rs.close();*/

	String strsql2="select CLINIC_CODE, CLINC_DESC, CARE_LOCN_TYPE_IND, LOCN_TYPE_DESC, ORDER_CATEGORY, ORDER_CAT_DESC, ORDER_CATALOG_CODE, ORDER_CATALOG_DESC from OP_CATALOG_FOR_CLINIC_VW where facility_id='"+facility_id+"' and rd_appl_yn = 'N'"+sql.toString();
	//out.println(strsql2);
	rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rs.next() ;

	while( i<=end && rs.next() )
	{
		if (cnt == 0)
		{
    %>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eOP/jsp/CatalogForClinicQueryResult.jsp?&from="+(start-14)+"&to="+(end-14)+"&locn_type="+locn_type+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( endOfRes == 1 )
	out.println("<A id='nextval' HREF='../../eOP/jsp/CatalogForClinicQueryResult.jsp?&from="+(start+14)+"&to="+(end+14)+"&locn_type="+locn_type+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.OrderCatalogDescription.label" bundle="${common_labels}"/></th>
<%
		}
 	
	String classValue = "" ;
	  
	if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;
	
	out.println("<tr><td class='" + classValue + "'>");
	String visit_type_id = rs.getString("CLINIC_CODE");
	String locn_type_desc=rs.getString("LOCN_TYPE_DESC");
	String stat_grp_id6 = rs.getString("CLINC_DESC");
	String stat_grp_id2 = rs.getString("ORDER_CATALOG_CODE");
	String stat_grp_id3 = rs.getString("ORDER_CATALOG_DESC");
	String dord = rs.getString("ORDER_CAT_DESC");
			
	out.println(locn_type_desc+"</td><td class='" + classValue + "'>");

	out.println(visit_type_id+"</td><td class='" + classValue + "'>");
	
	out.println(stat_grp_id6+"</a></td><td class='" + classValue + "'>");

	out.println(dord+"</a></td><td class='" + classValue + "'>");
	
	out.println(stat_grp_id2+"</a></td><td class='" + classValue + "'>");

	out.println(stat_grp_id3+"</a></td>");
	
	i++;
	cnt++;
	}

if (cnt == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if( !rs.next() && cnt!=0 )
{
%>
<script>
	document.getElementById("nextval").innerHTML = " ";
</script>
<%
}

if(rs !=null )rs.close();
if(stmt != null )stmt.close();
sql.setLength(0);

}
catch(Exception e) {out.println(e);}
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

