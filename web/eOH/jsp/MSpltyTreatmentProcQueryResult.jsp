<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String locale = (String)session.getAttribute("LOCALE"); 
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

		String trmt_code = request.getParameter("trmt_code")==null?"":request.getParameter( "trmt_code" ).toUpperCase();
		String order_catalog_code =request.getParameter("order_catalog_code")==null?"":request.getParameter( "order_catalog_code" ).toUpperCase();
		String splty_module_id =request.getParameter("splty_module_id")==null?"":request.getParameter( "splty_module_id" );
		String trmt_category_code =request.getParameter("trmt_category_code")==null?"":request.getParameter( "trmt_category_code" );
		//String enabled = request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");

		if ((whereClause == null || whereClause.equals(""))){
			int cnt=0;

			if ( !(trmt_code == null || trmt_code.equals(""))){
				sql = sql + " where UPPER(trmt_code ) = upper('"+trmt_code +"')";
				cnt++;
			}

			if ( !(order_catalog_code == null || order_catalog_code.equals(""))){
				if(cnt>0)
					sql = sql + " and UPPER(order_catalog_code) = '"+order_catalog_code+"'";
				else{
					sql=sql+" where UPPER(order_catalog_code) = '"+order_catalog_code+"'";
					cnt=1;
				}
			}
		    
			if ( !(splty_module_id == null || splty_module_id.equals("")) ){
				if(cnt>0)
					sql = sql + " and UPPER(splty_module_id) = '"+splty_module_id+"'";
				else{
					sql=sql+" where UPPER(splty_module_id) = '"+splty_module_id+"'";
					cnt=1;
				}
			}

			if ( !(trmt_category_code == null || trmt_category_code.equals("")) ){
				if(cnt>0)
					sql = sql + " and UPPER(trmt_category_code) = '"+trmt_category_code+"'";
				else{
					sql=sql+" where UPPER(trmt_category_code) = '"+trmt_category_code+"'";
					cnt=1;
				}
			}

//			if ( !(enabled == null || enabled.equals("")) ){
//				if( enabled.equals("E") ){
//					if(cnt>0)
//						sql = sql+" and nvl(eff_status,'E')='E' ";
//					else{
//						sql=sql+ " where  nvl(eff_status,'E')='E' ";
//						cnt=1;
//					}
//				}
//				if ( enabled.equals("D") ){
//					if(cnt>0)
//						sql = sql+" and eff_status='D'";
//					else
//						sql=sql+ "where  eff_status='D'";
//				}
//				if ( enabled.equals("B") ){
//						//sql = sql; //nothing is added to get both E and D
//				}
//			}

			//appending order by clause
			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) ){
				sql=sql+" order by ";
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
			String strsql="select count(*) as total from OH_TREATMENT "+sql;
			String strsql1="select trmt_code,order_catalog_code, splty_module_id, trmt_category_code from OH_TREATMENT "+sql;

			stmt = conn.prepareStatement(strsql);
			rs = stmt.executeQuery();
			rs.next();
			maxRecord = rs.getInt("total");
			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			stmt1=conn.prepareStatement(strsql1);
			rset = stmt1.executeQuery();
		}catch(Exception e){
			out.println("Err Msg From MSpltyTreatmentProcQueryResult.jsp "+e);
		}
%>
<form name='QueryResult' id='QueryResult'>
<P>
  <table align='right'>
	<tr>
		<td>
		<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eOH/jsp/MSpltyTreatmentProcQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eOH/jsp/MSpltyTreatmentProcQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
  </table>
  <br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.TreatmentProcedure.Label" bundle="${oh_labels}"/>
	</td>
		
	 
	<!-- <td class="ColumnHeaderCenter">
			<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>	
	</td>  -->
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.SpecialityModuleId.Label" bundle="${oh_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.TreatmentCategoryCode.Label" bundle="${oh_labels}"/>
	</td>
	<!-- /* Bhavani Shankar asked to remove this*/ -->
	<!-- <td class="ColumnHeaderCenter">
		<fmt:message key="eOH.OrderCatalogue.Label" bundle="${oh_labels}"/>
	</td> -->
	<!-- <td class="ColumnHeaderCenter">
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	
	</td>  -->
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

				trmt_code = checkForNull(rset.getString(1));
			    //order_catalog_code = checkForNull(rset.getString(2));
				//short_desc= rset.getString(3);
				splty_module_id = checkForNull(rset.getString(3));
			    trmt_category_code = checkForNull(rset.getString(4));

				String mode="modify";
				out.println("<a href='../../eOH/jsp/MSpltyTreatmentProcAddModify.jsp?mode="+mode+"&trmt_code="+ trmt_code+"' target='f_query_add_mod' >");
				out.println(trmt_code+"</a></td>");
				out.println("<td class='" + classValue+"'>"+splty_module_id+"</td>");
			    out.println("<td class='" + classValue+"'>"+trmt_category_code+"</td>");

				/* Bhavani Shankar asked to remove this*/
  				//out.println("<td class='" + classValue+"'>"+order_catalog_code+"</td>");
				

			    //out.println("<td class='" + classValue + "' align='center'>");
//				if ( rset.getString("eff_status").equals("E") )
//					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
//				else
//					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
//				out.println("</td>");

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
	out.println("Err Msg From MSpltyTreatmentProcQueryResult.jsp ::"+e);
}
%>
</center>
</form>
</BODY>
</HTML>

