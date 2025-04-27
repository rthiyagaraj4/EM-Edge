<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");
%>

<HTML>
	<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
		Connection conn  =  null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rset=null;
		ResultSet rs = null;
	try{
		conn  =  ConnectionManager.getConnection(request);
		String whereClause = request.getParameter("whereclause");
		if(whereClause==null) whereClause="";

		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String sql = " ";
		//String trmt_desc = " ";

		String task_code = request.getParameter("task_code")==null?"":request.getParameter( "task_code" ).toUpperCase();
		String task_desc =request.getParameter("task_desc")==null?"":request.getParameter( "task_desc" ).toUpperCase();
		String order_catalog_code =request.getParameter("order_catalog_code")==null?"":request.getParameter( "order_catalog_code" );
		String eff_status = request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");
		if ((whereClause == null || whereClause.equals(""))){
			if ( !(task_code == null || task_code.equals(""))){
				sql = sql + " AND UPPER(TASK_CODE ) LIKE UPPER('"+task_code +"%')";
			}

			if ( !(task_desc == null || task_desc.equals(""))){
				sql = sql + " AND UPPER(TASK_DESC) LIKE '"+task_desc+"%'"; // modified by yadav for OH-IN015723
			}
		    if( !(order_catalog_code == null || order_catalog_code.equals(""))){
				sql = sql + " AND UPPER(ORDER_CATALOG_CODE) LIKE '"+order_catalog_code+"%'";
			}
		
			if ( !(eff_status == null || eff_status.equals("")) ){
				if( eff_status.equals("E") ){
					sql = sql+" AND NVL(EFF_STATUS,'E')='E' ";
				}
				if ( eff_status.equals("D") ){
					sql = sql+" AND EFF_STATUS='D'";
				}
				if ( eff_status.equals("B") ){
						sql = sql; //nothing is added to get both E and D
				}
			}			
			//appending order by clause
			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) ){
				sql=sql+" ORDER BY ";
				for ( int i=0;i < ord.length;i++ ){
					if ( i == ord.length - 1 )
						sql=sql+ord[i];
					else
						sql=sql+ord[i]+",";
				}
			}
		} //end of where clause IF
		else{
			sql = whereClause;
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
			String strsql="SELECT COUNT(*) AS TOTAL FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ? "+sql;
									
			String strsql1="SELECT TASK_CODE, TASK_DESC, ORDER_CATALOG_CODE, EFF_STATUS FROM OH_TASKS_LANG_VW WHERE LANGUAGE_ID = ? "+sql;
			// IN PLACE OF 1=1 REPLACE WITH LANGUAGE_ID = ? WHEN TASK_LANG_VW IS READY
			stmt = conn.prepareStatement(strsql);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();
			rs.next();
			maxRecord = rs.getInt("total");
			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			stmt1=conn.prepareStatement(strsql1);
			stmt1.setString(1,locale);
			rset = stmt1.executeQuery();
		}catch(Exception e){
			out.println("Err Msg From MTasksQueryResult.jsp "+e);
		}
%>
<form name='QueryResult' id='QueryResult'>

<P>
  <table align='right'>
	<tr>
		<td>
		<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eOH/jsp/MTasksQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eOH/jsp/MTasksQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
  </table>
  <br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/>
	</td>
		
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.CatalogCrossReference.label" bundle="${common_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	
	</td>
	
	<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rset.next() ;
			String classValue= " ";
			while ( rset.next() && i<=end  ){
				if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
					classValue = "QRYODD" ;
				out.println("<tr><td align=='left' class='" + classValue + "'>");

				task_code = rset.getString(1);
			    task_desc=rset.getString(2);
			    order_catalog_code= rset.getString(3);
				eff_status= rset.getString(4);
				
				String mode="modify";
				
				out.println("<a href='../../eOH/jsp/MTasksAddModify.jsp?mode="+mode+"&task_code="+ task_code+"' target='f_query_add_mod' >");
				out.println(task_code+"</a></td>");
  				out.println("<td class='" + classValue+"'>"+task_desc+"</td>");
				if(order_catalog_code==null){
					order_catalog_code="";
				}
				out.println("<td class='" + classValue+"'>"+order_catalog_code+"</td>");
			    out.println("<td class='" + classValue + "' align='center'>");
				if ( rset.getString("eff_status").equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");

				i++;
			} 
		%>
				
        </td>
	</tr>
</table>
</center>

<br><center>
<%
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	ConnectionManager.returnConnection(conn,request);
}
catch(Exception e){
	out.println("Err Msg From MTasks.jsp ::"+e);
}finally {
	try{
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(conn!=null) 
			ConnectionManager.returnConnection(conn,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>
</center>
</form>
</BODY>
</HTML>

