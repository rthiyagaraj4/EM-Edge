<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0419 -->

<%@  page import 
="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String ph_module_yn = request.getParameter("ph_module_yn");
try{
		String whereClause = request.getParameter("whereclause");
		if(whereClause==null) whereClause="";
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String sql = " ";
		String dietLocationCode = request.getParameter("dietLocationCode")==null?"":request.getParameter( "dietLocationCode" ).trim().toUpperCase();
		String longDesc =request.getParameter("longDesc")==null?"":request.getParameter( "longDesc" ).trim().toUpperCase();
		String shortDesc =request.getParameter("shortDesc")==null?"":request.getParameter( "shortDesc" ).trim().toUpperCase();
		String defaultYn=request.getParameter("defaultlocation")==null?"":request.getParameter( "defaultlocation");
		String enabledYn = request.getParameter("enabledYn")==null?"":request.getParameter( "enabledYn");
		
		if ( (whereClause == null || whereClause.equals("")) )
		{
		int cnt=0;

			if ( !(dietLocationCode == null || dietLocationCode.equals("")) ){
				sql = sql + " where upper(LOCATION_CODE ) like upper('"+dietLocationCode +"%')";
				cnt++;
			}

			if ( !(longDesc == null || longDesc.equals("")) ){
				if(cnt>0)
					sql = sql + " and upper(long_desc) like '"+longDesc+"%'";
				else{
					sql=sql+" where upper(long_desc) like '"+longDesc+"%'";
					cnt=1;
				}

			}
		   if ( !(shortDesc == null || shortDesc.equals("")) ){
				if(cnt>0)
					sql = sql + " and upper(short_desc) like '"+shortDesc+"%'";
				else{
					sql=sql+" where upper(short_desc) like '"+shortDesc+"%'";
					cnt=1;
				}

			}


         if (!(defaultYn.equals("B"))){

			if(defaultYn.equals("Y")){
				if(cnt>0)
					   sql = sql+" and nvl(DEFAULT_DIET_REQUEST_LOCATION,'N')='Y' ";
					else{
						sql=sql+ " where nvl(DEFAULT_DIET_REQUEST_LOCATION,'N')='Y' ";
						cnt=1;
					}
			}
			else if(defaultYn.equals("N")){
				if(cnt>0)
					   sql = sql+" and nvl(DEFAULT_DIET_REQUEST_LOCATION,'N')='N' ";
					else{
						sql=sql+ " where nvl(DEFAULT_DIET_REQUEST_LOCATION,'N')='N' ";
						cnt=1;
					}
			}
		}
		if (!(enabledYn.equals("B"))){

			if(enabledYn.equals("E")){
				if(cnt>0)
					   sql = sql+" and nvl(eff_status,'D')='E' ";
					else{
						sql=sql+ " where nvl(eff_status,'D')='E' ";
						cnt=1;
					}
			}
			else if(enabledYn.equals("D")){
				if(cnt>0)
					   sql = sql+" and nvl(eff_status,'D')='D' ";
					else{
						sql=sql+ " where nvl(eff_status,'D')='D' ";
						cnt=1;
					}
			}
		}
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";
			}
		}

		} //end of where clause IF
		else
				sql = whereClause;


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

	Connection conn  =  ConnectionManager.getConnection(request);

	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{

		String strsql="select count(*) as total from ds_diet_request_loc "+sql;
		String strsql1="select location_code,long_desc,short_desc,DEFAULT_DIET_REQUEST_LOCATION,eff_status from ds_diet_request_loc "+sql;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();

	}catch(Exception e){
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/DietRequestLocationQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/DietRequestLocationQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<!-- Location Code for Staff -->
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.LocationCode.Label" bundle="${ds_labels}"/>
</th>
<!-- Long Description for Staff -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</th>
<!-- Short Description for Staff -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</th>
<!-- Default Diet request Location for Staff -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.DefaultDietRequestLocation.Label" bundle="${ds_labels}"/>
</th>
<!-- Nature for Staff -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th>

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
      while ( rset.next() && i<=end  )
	{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    dietLocationCode = rset.getString(1);
    longDesc=rset.getString(2);
    shortDesc= rset.getString(3);
	defaultYn=rset.getString(4);
    enabledYn = rset.getString(5);


	String mode="modify";
	out.println("<a href='../../eDS/jsp/DietRequestLocationAddModify.jsp?mode="+mode+"&dietLocationCode="+ dietLocationCode+"' target='f_query_add_mod' >");
    out.println(dietLocationCode+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
	    out.println("<td class='" + classValue + "' align='center'>");
    if ( defaultYn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

    out.println("<td class='" + classValue + "' align='center'>");
    if ( enabledYn.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	
	e.printStackTrace();
}
%>

</center>
</form>
</body>
</html>

