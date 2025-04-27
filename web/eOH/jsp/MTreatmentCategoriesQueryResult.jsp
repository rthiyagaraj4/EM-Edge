<!DOCTYPE html>
<!-- 
	Developer		: Sridevi Joshi
	Completed On	: 10/05/07
	Modified On		: 07/06/07 
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

		String trmt_category_code = request.getParameter("trmt_category_code")==null?"":request.getParameter( "trmt_category_code" ).toUpperCase();
		String trmt_category_desc =request.getParameter("trmt_category_desc")==null?"":request.getParameter( "trmt_category_desc" ).toUpperCase();
		String splty_module_id =request.getParameter("splty_module_id")==null?"":request.getParameter( "splty_module_id" );
		String trmt_category_type =request.getParameter("trmt_category_type")==null?"":request.getParameter( "trmt_category_type" );
		String enabled = request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");

		if ((whereClause == null || whereClause.equals(""))){

			if ( !(trmt_category_code == null || trmt_category_code.equals(""))){
				sql = sql + " AND UPPER(TRMT_CATEGORY_CODE ) LIKE UPPER('"+trmt_category_code +"%')";
			}
			if ( !(trmt_category_desc == null || trmt_category_desc.equals(""))){
				sql = sql + " AND UPPER(TRMT_CATEGORY_DESC) LIKE '"+trmt_category_desc+"%'";
			}
		    if ( !(splty_module_id == null || splty_module_id.equals("")) ){
				sql = sql + " AND UPPER(SPLTY_MODULE_ID) LIKE '"+splty_module_id+"%'";
			}
			if ( !(trmt_category_type == null || trmt_category_type.equals("")) ){
				sql = sql + " AND UPPER(TRMT_CATEGORY_TYPE) LIKE '"+trmt_category_type+"%'";
			}
			if ( !(enabled == null || enabled.equals("")) ){
				if( enabled.equals("E") ){
					sql = sql+" AND NVL(EFF_STATUS,'E')='E' ";
				}
				if ( enabled.equals("D") ){
					sql = sql+" AND EFF_STATUS='D'";
				}
				if ( enabled.equals("B") ){
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
			String strsql="SELECT COUNT(*) AS TOTAL FROM OH_TREATMENT_CATEGORY_LANG_VW WHERE LANGUAGE_ID = ? "+sql;
			String strsql1="SELECT TRMT_CATEGORY_CODE, TRMT_CATEGORY_DESC, SPLTY_MODULE_ID, TRMT_CATEGORY_TYPE, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_TREATMENT_CATEGORY_LANG_VW WHERE LANGUAGE_ID = ? "+sql;

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
			out.println("Err Msg From MTreatmentCategoriesQueryResult.jsp "+e);
		}
%>
<form name='QueryResult' id='QueryResult'>
<P>
  <table align='right'>
	<tr>
		<td>
		<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eOH/jsp/MTreatmentCategoriesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eOH/jsp/MTreatmentCategoriesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
  </table>
  <br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.TreatmentCategoryCode.Label" bundle="${oh_labels}"/>
	</td>
		
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.SpecialityModuleId.Label" bundle="${oh_labels}"/>
	</td>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.TreatmentCategoryType.Label" bundle="${oh_labels}"/>
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

				trmt_category_code = rset.getString(1);
			    trmt_category_desc=rset.getString(2);
				splty_module_id=rset.getString(3);
			    trmt_category_type= rset.getString(4);

				String mode="modify";
				out.println("<a href='../../eOH/jsp/MTreatmentCategoriesAddModify.jsp?mode="+mode+"&trmt_category_code="+ trmt_category_code+"' target='f_query_add_mod' >");
				out.println(trmt_category_code+"</a></td>");
  				out.println("<td class='" + classValue+"'>"+trmt_category_desc+"</td>");
				out.println("<td class='" + classValue+"'>"+splty_module_id+"</td>");
			    out.println("<td class='" + classValue+"'>"+trmt_category_type+"</td>");
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
	out.println("Err Msg From MTreatmentCategoriesQueryResult.jsp ::"+e);
}
%>
</center>
</form>
</BODY>
</HTML>

