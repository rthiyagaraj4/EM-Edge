<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
 
<%
	request.setCharacterEncoding("UTF-8");
	String facility_id					=	(String) session.getValue("facility_id");
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	StringBuffer orderby = new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	if ( (whereClause == null || whereClause.equals("")) ) {
		 String  priority_zone	    = request.getParameter("priority_zone");
		 String  priority_zone_desc			= request.getParameter(" priority_zone_desc");
		 String  priority_zone_tab_desc          = request.getParameter("priority_zone_tab_desc");
		  int andCheck 				= 0;
		 // Changing to Upper case and checking
		 	priority_zone		=  priority_zone.toUpperCase();
	
	 if ( !( priority_zone== null ||  priority_zone.equals("")) ){
	  sql.append( " where upper( PRIORITY_ZONE) like upper('"+priority_zone+"%')");
	  andCheck 	= 1;
	 }
	
	if ( !( priority_zone_desc == null ||  priority_zone_desc.equals("")) )
	 {

	    if ( andCheck == 1 )
	    {
			  sql.append(" and ");
	     	  sql.append(" upper( PRIORITY_ZONE_DESC) like upper('"+priority_zone_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(PRIORITY_ZONE_DESC) like upper('"+ priority_zone_desc+"%')");
			 andCheck 	= 1;
	    }
	 }
     if ( !( priority_zone_tab_desc == null ||  priority_zone_tab_desc.equals("")) )
	 {

	    if ( andCheck == 1 )
	    {
			  sql.append(" and ");
	     	  sql.append(" upper( priority_zone_tab_desc) like upper('"+priority_zone_tab_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(priority_zone_tab_desc) like upper('"+priority_zone_tab_desc+"%')");
			 andCheck 	= 1;
	    }
	 }
	  
	//appending order by clause
String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{

		orderby.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 ){
	 		orderby.append(ord[i]);
		}
		else{
			orderby.append(ord[i]+",");
		}
		}
	}  
	} //end of where clause IF
	else 
		{

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

		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  stmt = con.createStatement();
	  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	  PreparedStatement pstmt			= null;
	  ResultSet rset					    = null;
	  String five_level_triage_appl_yn	= "N";
	  String AcessSql   = "SELECT five_level_triage_appl_yn FROM AE_PARAM WHERE OPERATING_FACILITY_ID=? ";
	  pstmt=con.prepareStatement(AcessSql);
	  pstmt.setString(1,facility_id);
	  rset=pstmt.executeQuery();
	  while(rset!=null && rset.next()) {
		  five_level_triage_appl_yn	=  (rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
	
	  
	  if(!five_level_triage_appl_yn.equals("Y")){
		  if(sql.toString().equals(""))
			  sql.append(" where priority_zone not in ('B','W')");
		  else
			  sql.append(" and priority_zone not in ('B','W')");
	  }
	  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/

	  StringBuffer strsql2=new StringBuffer("select * from AE_PRIORITY_ZONE");
	  if(!sql.toString().equals("")){
	  	strsql2.append(sql.toString());
	  }
	  strsql2.append(orderby.toString());
 	  rs = stmt.executeQuery(strsql2.toString());
	  String classValue = "" ;
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs.next() ;
		  }
  
	 while (i<=end && rs.next()){
		if(cnt==0){
%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/PriorityZoneQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/PriorityZoneQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='10%'><fmt:message key="eAE.PriorityZoneCode.label" bundle="${ae_labels}"/></th>
<th width='50%'><fmt:message key="eAE.PriorityZoneColorDesc.label" bundle="${ae_labels}"/></th>
<th width='100%'><fmt:message key="eAE.PriorityZoneTabDesc.label" bundle="${ae_labels}"/></th> 

<%}

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String priority_zone_disp = rs.getString("PRIORITY_ZONE");
	out.println("<a href='../../eAE/jsp/AddModifyPriorityZone.jsp?priority_zone="+priority_zone_disp+"&five_level_triage_appl_yn="+five_level_triage_appl_yn+"' target='f_query_add_mod' >");
	out.println(priority_zone_disp+"</a></td><td class='" + classValue + "'>");
	String long_desc_disp= rs.getString("PRIORITY_ZONE_DESC");
	out.println(long_desc_disp+"</td><td class='" + classValue + "'>");
	String short_desc_disp = rs.getString("PRIORITY_ZONE_TAB_DESC");
	out.println(short_desc_disp+"</td><td align='center' class='" + classValue + "'>");
	i++;
 	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%} 
 %>
</td></tr>
</table>
<br><center>
</center>
<%

 }catch(Exception e)
     {
			e.printStackTrace();
     }
	finally   
	{
		 if(stmt!=null)	stmt.close();
		 if(rs!=null)	rs.close();
		 ConnectionManager.returnConnection(con,request);
    }
%>
 
</BODY>
</HTML>

