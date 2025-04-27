<!DOCTYPE html>
<!-- 
	Developer		: Sridevi Joshi
	Completed On	: 07/06/07
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
	try{
		String whereClause = request.getParameter("whereclause");
		if(whereClause==null) whereClause="";

		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String sql = " ";

		String composition_class_code = request.getParameter("composition_class_code")==null?"":request.getParameter( "composition_class_code" ).toUpperCase();
		String composition_desc = request.getParameter("composition_desc")==null?"":request.getParameter( "composition_desc" ).toUpperCase();
		String composition_code = request.getParameter("composition_code")==null?"":request.getParameter( "composition_code" ).toUpperCase();		
		String enabled = request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");
		String anesthesia_yn = request.getParameter("anesthesia_yn")==null?"":request.getParameter( "anesthesia_yn");

		if ((whereClause == null || whereClause.equals(""))){
			if ( !(composition_code == null || composition_code.equals(""))){
				sql = sql + " AND UPPER(COMPOSITION_CODE ) LIKE UPPER('"+composition_code +"%')";
			}
			if ( !(composition_desc == null || composition_desc.equals(""))){
				sql = sql + " AND UPPER(COMPOSITION_DESC) LIKE '"+composition_desc+"%'";
			}
		  	if ( !(composition_class_code == null || composition_class_code.equals("")) ){
				sql = sql + " AND UPPER(COMPOSITION_CLASS_CODE) LIKE '"+composition_class_code+"%'";
			}
			if ( !(enabled == null || enabled.equals("")) ){
				if( enabled.equals("E") ){
					sql = sql+" AND NVL(EFF_STATUS,'E')='E' ";
				}
				if ( enabled.equals("D") ){
					sql = sql+" AND NVL(EFF_STATUS,'E')='D'";
				}
				if ( enabled.equals("B") ){
						//sql = sql; //nothing is added to get both E and D
				}
			}

			if ( !(anesthesia_yn == null || anesthesia_yn.equals("")) ){
				if( anesthesia_yn.equals("Y") ){
					sql = sql+" AND NVL(ANESTHESIA_YN,'N')='Y' ";
				}
				if ( anesthesia_yn.equals("N") ){
					sql = sql+" AND NVL(ANESTHESIA_YN,'N')='N'";
				}
				if ( anesthesia_yn.equals("B") ){
						//sql = sql; //nothing is added to get both E and D
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

		Connection conn  =  ConnectionManager.getConnection(request);
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int maxRecord = 0;
		ResultSet rset=null;
		ResultSet rs = null;

		try{
			String strsql="SELECT COUNT(*) AS TOTAL FROM OH_COMPOSITION_LANG_VW WHERE LANGUAGE_ID = ? "+sql;
			String strsql1="SELECT COMPOSITION_CODE, COMPOSITION_DESC, COMPOSITION_CLASS_CODE, NVL(EFF_STATUS,'E') EFF_STATUS, NVL(ANESTHESIA_YN,'N') ANESTHESIA_YN FROM OH_COMPOSITION_LANG_VW WHERE LANGUAGE_ID = ? "+sql;

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
			out.println("Err Msg From MProcCompositionQueryResult.jsp "+e);
		}
%>
<form name='QueryResult' id='QueryResult'>
<P>
  <table align='right'>
	<tr>
		<td>
		<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eOH/jsp/MProcCompositionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eOH/jsp/MProcCompositionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
  </table>
  <br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.CompositionCode.Label" bundle="${oh_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.CompositionClass.Label" bundle="${oh_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	
	</td> 
	<td class="ColumnHeaderCenter">
			<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>	
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

				composition_code = rset.getString(1);
			    composition_desc=rset.getString(2);
			    composition_class_code= rset.getString(3);

				String mode="modify";
				out.println("<a href='../../eOH/jsp/MProcCompositionAddModify.jsp?mode="+mode+"&composition_code="+ composition_code+"' target='f_query_add_mod' >");
				out.println(composition_code+"</a></td>");
  				out.println("<td class='" + classValue+"'>"+composition_desc+"</td>");
			    out.println("<td class='" + classValue+"'>"+composition_class_code+"</td>");
			    out.println("<td class='" + classValue + "' align='center'>");
				if ( rset.getString("eff_status").equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");
			    out.println("<td class='" + classValue + "' align='center'>");

				if ( rset.getString("ANESTHESIA_YN").equals("Y") )
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
	out.println("Err Msg From MProcCompositionQueryResult.jsp ::"+e);
}
%>
</center>
</form>
</BODY>
</HTML>

