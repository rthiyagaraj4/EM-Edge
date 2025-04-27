<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
%>
<HTML>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
	</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<%
	try{
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" ),"1") ;
    String to = checkForNull(request.getParameter( "to" ),"14" ) ;
    String sql = " ";
    String chart_code = checkForNull(request.getParameter("chartid"));
	String chart_desc = checkForNull(request.getParameter( "chart_desc" ));
	String status = checkForNull(request.getParameter( "status"));

	  if ( (whereClause == null || whereClause.equals("")) ) {

		int cnt=0;

		if ( !(chart_code == null || chart_code.equals("")) ){
	        sql = sql + " where upper(chart_code ) like upper('"+chart_code +"%')";
			cnt++;
        }

        if ( !(chart_desc == null || chart_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and UPPER(chart_desc) like upper('"+chart_desc+"%')";
			else{
				sql=sql+" where UPPER(chart_desc) like upper('"+chart_desc+"%')";
				cnt=1;
			}

        }
	   	if ( !(status == null || status.equals("")) ){
		  if( status.equals("E") ){
			if(cnt>0)
			   sql = sql+" and nvl(eff_status,'E')='E' ";
			else{
				sql=sql+ " where  nvl(eff_status,'E')='E' ";
				cnt=1;
			}
         }

		 if ( status.equals("D") ){
            if(cnt>0)
			   sql = sql+" and eff_status='D'";
			else
				sql=sql+ "where  eff_status='D'";
         }

         if ( status.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
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
	start = Integer.parseInt( from ) ;
	end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);

	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{
		
		//String strsql="select count(*) as total from OH_PERIODONTAL_CHART_DEF_HDR WHERE LANGUAGE_ID =? "+sql;
		//String strsql1="Select chart_code, long_desc, short_desc, nvl(eff_status,'E') status from OH_PERIODONTAL_CHART_DEF_HDR Where LANGUAGE_ID = ? "+sql;
		String strsql="SELECT COUNT(*) AS TOTAL FROM OH_PERIODONTAL_CHART_DEF_HDR "+sql;
		String strsql1="SELECT CHART_CODE, CHART_DESC, NVL(EFF_STATUS,'E') STATUS FROM OH_PERIODONTAL_CHART_DEF_HDR "+sql;

		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("TOTAL");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		System.err.println("Error in PeriodontalChartQueryResult "+e);
		out.println("Error in PeriodontalChartQueryResult "+e);
	}
%>
<P>
<form name='QueryResult' id='QueryResult' >
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/PeriodontalChartQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/PeriodontalChartQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>


</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.ChartID.label" bundle="${common_labels}"/>
	</td>
		
	<td class="ColumnHeaderCenter">
			<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>

	<td class="ColumnHeaderCenter">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	
	</td> 
	
	<%
	   if ( start != 1 )
	     for( int j=1; j<start; i++,j++ )
	      rset.next() ;
			String classValue= " ";
		      while ( rset.next() && i<=end  ) {
			    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
					classValue = "QRYODD" ;
				out.println("<tr><td align=='left' class='" + classValue + "'>");
				chart_code = rset.getString(1);
				chart_desc=rset.getString(2);
				status= rset.getString(3);
				String mode="modify";
				out.println("<a href='../../eOH/jsp/PeriodontalChartMain.jsp?mode="+mode+"&chartid="+ chart_code+"' target='f_query_add_mod' >");
				out.println(chart_code+"</a></td>");
				out.println("<td class='" + classValue+"'>"+chart_desc+"</td>");
				out.println("<td class='" + classValue + "' align='center'>");
				if ( rset.getString("status").equals("E") || rset.getString("status").equals("null"))
				   out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");
				
				i++;
			}

%>

</td></tr>
</table>
</center>
<br>
<center>
<%
				if(stmt!=null)	stmt.close();
				if(stmt1!=null)	stmt1.close();
				if(rs!=null)	rs.close();
				if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception e)
		{
			System.err.println("Error in PeriodontalChartQueryResult "+e);
			out.println("Error in PeriodontalChartQueryResult "+e);
		}
%>
</center>
</form>
</BODY>
</HTML>

