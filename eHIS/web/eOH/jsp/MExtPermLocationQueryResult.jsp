<!DOCTYPE html>
<!-- 
	Developer   : Muraleedhar
	Created On  : 01/10/2009
 -->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
		String sql = "";
		String sql1 = "";

		String extPermLoc_code = request.getParameter("ext_Loc_code")==null?"":request.getParameter( "ext_Loc_code" ).toUpperCase();
		String extPermLoc_desc = request.getParameter("ext_Loc_desc")==null?"":request.getParameter( "ext_Loc_desc" ).toUpperCase();
		String enabled = request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");
		
		if ((whereClause == null || whereClause.equals(""))){
			if ( !(extPermLoc_code == null || extPermLoc_code.equals(""))){
				sql = sql + " WHERE UPPER(EXT_LOC_CODE ) LIKE UPPER('"+extPermLoc_code +"%')";
			}
			if ( extPermLoc_code == null || extPermLoc_code.equals("")){
				if ( !(extPermLoc_desc == null || extPermLoc_desc.equals(""))){
					sql = sql + " WHERE UPPER(EXT_LOC_DESC) LIKE '"+extPermLoc_desc+"%'";
				}
			}else{
				if ( !(extPermLoc_desc == null || extPermLoc_desc.equals(""))){
					sql = sql + " AND UPPER(EXT_LOC_DESC) LIKE '"+extPermLoc_desc+"%'";
				}
			}

			if ( extPermLoc_code == null || extPermLoc_code.equals("")){
				if ( extPermLoc_desc == null || extPermLoc_desc.equals("")){
					if ( !(enabled == null || enabled.equals("")) ){
						if( enabled.equals("E") ){
							sql = sql+" WHERE NVL(EFF_STATUS,'E')='E' ";
						}
						if ( enabled.equals("D") ){
							sql = sql+" WHERE EFF_STATUS='D'";
						}
						if ( enabled.equals("B") ){
								//sql = sql; //nothing is added to get both E and D
						}
					}
				}else{
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
				}
			}

			if ( !(extPermLoc_code == null || extPermLoc_code.equals(""))){
				if ( extPermLoc_desc == null || extPermLoc_desc.equals("")){
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
				}
			}

			sql1 = sql;//Added by SRidevi Joshi on 5/18/2010 for IN021464

	/*	if ( extPermLoc_code == null || extPermLoc_code.equals("")){//Added by SRidevi Joshi on 5/18/2010 for IN021464
				if ( extPermLoc_desc == null || extPermLoc_desc.equals("")){
						sql1 = sql+" WHERE LANGUAGE_ID = '"+locale+"'";
				}else{
						sql1 = sql+" AND LANGUAGE_ID = '"+locale+"'";
				}
			}

			if ( !(extPermLoc_code == null || extPermLoc_code.equals(""))){//Added by SRidevi Joshi on 5/18/2010 for IN021464
				if ( extPermLoc_desc == null || extPermLoc_desc.equals("")){
					sql1 = sql+" AND LANGUAGE_ID = '"+locale+"'";
				}
			}*/
		if ((extPermLoc_code == null || extPermLoc_code.equals("")) &&
				(extPermLoc_desc == null || extPermLoc_desc.equals("")) && enabled.equals("B")){
						sql1 = sql+" WHERE LANGUAGE_ID = '"+locale+"'";
				}else{
						sql1 = sql+" AND LANGUAGE_ID = '"+locale+"'";
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
			String strsql="SELECT COUNT(*) AS TOTAL FROM OH_EXT_PERFORM_LOCATIONS"+sql;
			//String strsql1="SELECT EXT_LOC_CODE, EXT_LOC_DESC, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_EXT_PERFORM_LOCATIONS"+sql;
			String strsql1="SELECT EXT_LOC_CODE, EXT_LOC_DESC, NVL(EFF_STATUS,'E') EFF_STATUS FROM OH_EXT_PERFORM_LOC_LANG_VW "+sql1; //Added by SRidevi Joshi on 5/18/2010 for IN021464

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
			conn.rollback();
			out.println("Err Msg From MExtPermLocationQueryResult.jsp "+e);
		}
%>
<form name='QueryResult' id='QueryResult'>
<P>
  <table align='right'>
	<tr>
		<td>
		<%
			if ( !(start <= 1) )
				out.println("<A HREF='../../eOH/jsp/MExtPermLocationQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eOH/jsp/MExtPermLocationQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
  </table>
  <br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.ExternalPerformingLocationCode.Label" bundle="${oh_labels}"/>
	</td>
		
	<td class="ColumnHeaderCenter">
		<fmt:message key="eOH.ExternalPerformingLocationDesc.Label" bundle="${oh_labels}"/>
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

				extPermLoc_code = rset.getString(1);
			    extPermLoc_desc=rset.getString(2);
				
				String mode="modify";
				out.println("<a href='../../eOH/jsp/MExtPermLocationAddModify.jsp?mode="+mode+"&extPermLoc_code="+ extPermLoc_code+"' target='f_query_add_mod' >");
				out.println(extPermLoc_code+"</a></td>");
  				out.println("<td class='" + classValue+"'>"+extPermLoc_desc+"</td>");
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
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}
catch(Exception e){
	out.println("Err Msg From MExtPermLocationQueryResult.jsp ::"+e);
	//conn.rollback();
}
%>
</center>
</form>
</BODY>
</HTML>

