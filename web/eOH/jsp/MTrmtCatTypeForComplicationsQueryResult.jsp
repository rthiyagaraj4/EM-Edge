<!DOCTYPE html>
<!-- 
	Developer   : Bhavani Shankar
	Created On  : 18/02/08
 -->

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

		String complication_code = request.getParameter("complication_code")==null?"":request.getParameter( "complication_code" ).toUpperCase();
		String complication_desc =request.getParameter("complication_desc")==null?"":request.getParameter( "complication_desc" ).toUpperCase();
		String trmt_category_type =request.getParameter("trmt_category_type")==null?"":request.getParameter( "trmt_category_type" );

	if ((whereClause == null || whereClause.equals(""))){
			if ( !(complication_code == null || complication_code.equals(""))){
				sql = sql + " AND UPPER(A.COMPLICATION_CODE ) LIKE UPPER('"+complication_code +"%')";
			}
			if ( !(complication_desc == null || complication_desc.equals(""))){
				sql = sql + " AND UPPER(B.COMPLICATION_DESC) LIKE '"+complication_desc+"%'";
			}
		   if ( !(trmt_category_type == null || trmt_category_type.equals("")) ){
				sql = sql + " AND UPPER(A.TRMT_CATEGORY_TYPE) LIKE '"+trmt_category_type+"%'";
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
		String strsql="";
		String strsql1="";
		try{
			strsql="SELECT COUNT(*) AS TOTAL FROM OH_COMPLICATION_TRMT_CAT_TYPE A, OH_COMPLICATION B WHERE A.COMPLICATION_CODE = B.COMPLICATION_CODE "+sql;
			
			strsql1="SELECT A.COMPLICATION_CODE,B.COMPLICATION_DESC,A.TRMT_CATEGORY_TYPE FROM OH_COMPLICATION_TRMT_CAT_TYPE A, OH_COMPLICATION_LANG_VW B WHERE A.COMPLICATION_CODE = B.COMPLICATION_CODE AND B.LANGUAGE_ID = ? "+sql;
			
            stmt = conn.prepareStatement(strsql);
			rs = stmt.executeQuery();
			rs.next();
			maxRecord = rs.getInt("TOTAL");

			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			
			stmt1=conn.prepareStatement(strsql1);
			stmt1.setString(1,locale);
			rset = stmt1.executeQuery();
		}catch(Exception e){
			out.println("Err Msg From MTrmtCatTypeForComplicationsQueryResult.jsp "+e);
			out.println("strsql: "+strsql);
			out.println("strsql1: "+strsql1);
		}
%>
<form name='QueryResult' id='QueryResult'>
<P>
  <table align='right'>
	<tr>
		<td>
		<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eOH/jsp/MTrmtCatTypeForComplicationsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eOH/jsp/MTrmtCatTypeForComplicationsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
  </table>
  <br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.ComplicationCode.Label" bundle="${oh_labels}"/>
	</td>
		
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.TreatmentCategoryType.Label" bundle="${oh_labels}"/>
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

				complication_code = rset.getString(1);
			    complication_desc=rset.getString(2);
				trmt_category_type= rset.getString(3);
				//String mode="modify";
				//out.println("<a href='../../eOH/jsp/MTrmtCatTypeForComplicationsQueryResult.jsp?mode="+mode+"&complication_code="+ complication_code+"' target='f_query_add_mod' >");
  				out.println(complication_code+"</td>");
  				out.println("<td class='" + classValue+"'>"+complication_desc+"</td>");
			    out.println("<td class='" + classValue+"'>"+trmt_category_type+"</td>");
			    out.println("<td class='" + classValue + "' align='center'>");

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
	out.println("Err Msg From MTrmtCatTypeForComplicationsQueryResult.jsp ::"+e);
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

