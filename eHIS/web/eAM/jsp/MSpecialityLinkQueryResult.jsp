<!DOCTYPE html>
 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eAM/js/MSpecialityLink.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

	<%
			Connection 	conn = ConnectionManager.getConnection(request);
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			ResultSet rs=null;
			ResultSet rset=null;
		try{
			String whereClause = request.getParameter("whereclause");
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			String speciality_module =request.getParameter("speciality_module")==null?"":request.getParameter( "speciality_module" );
			String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter( "speciality_code" );
			String speciality_desc = request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" );
			String sql="";

			if ((whereClause == null || whereClause.equals(""))){
				int cnt=0;
				if ( !(speciality_module == null || speciality_module.equals(""))){
					sql = sql + " AND UPPER(A.MODULE_ID ) LIKE UPPER('"+speciality_module +"%')";
					cnt++;
				}
				if ( !(speciality_desc == null || speciality_desc.equals(""))){
					if(cnt>0)
						sql = sql + " AND UPPER(B.SHORT_DESC) LIKE UPPER('"+speciality_desc+"%')";
					else{
						sql=sql+" AND UPPER(B.SHORT_DESC) LIKE UPPER('"+speciality_desc+"%')";
						cnt=1;
					}
				}
				if (!(speciality_code == null || speciality_code.equals(""))){
					if(cnt>0)
						sql = sql + " AND UPPER(A.SPECIALITY_CODE) LIKE UPPER('"+speciality_code+"%')";
					else{
						sql=sql+" AND UPPER(A.SPECIALITY_CODE) LIKE UPPER('"+speciality_code+"%')";
						cnt=1;
					}	
				}
	
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
			}//end of where clause IF
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
				String strsql1 = "SELECT C.MODULE_NAME, A.SPECIALITY_CODE, B.SHORT_DESC FROM AM_SPLTY_FOR_SPLTY_MODULES A, AM_SPECIALITY_LANG_VW B,SM_MODULE C WHERE A.SPECIALITY_CODE = B.SPECIALITY_CODE AND A.MODULE_ID=C.MODULE_ID  AND LANGUAGE_ID = '"+locale+"'" + sql;

				stmt = conn.prepareStatement(strsql1);
				rs = stmt.executeQuery();
				int total=0;
				while(rs.next()){
					total++;
				}
				maxRecord=total;
				if(maxRecord == 0)
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
					
				stmt1=conn.prepareStatement(strsql1);
				rset = stmt1.executeQuery();
		
			}catch(Exception e){
				e.printStackTrace() ;
			}		
	%>
	<form name='QueryResult' id='QueryResult'>
	<br><br>
		<p>
			<table cellspacing=0 cellpadding=3  align='right'>
				<tr>
					<td>
					<%
						if ( !(start <= 1) )
							out.println("<A HREF='../jsp/MSpecialityLinkQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

						if ( !( (start+14) > maxRecord ) )
							out.println("<A HREF='../jsp/MSpecialityLinkQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

					%>
					</td>
				</tr>
			</table>
		</p>
		<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding=3 >
			<th class="columnHeader">
				<fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/>
			</th>
			<th class="columnHeader">
				<fmt:message key="Common.description.label" bundle="${common_labels}"/>
			</th>
			<th class="columnHeader">
				<fmt:message key="eAM.SpecialityModule.Label" bundle="${am_labels}"/>
			</th>

			<%
 				if ( start != 1 )
					for(int j=1; j<start; i++,j++ ){
						rset.next() ;
					}

				String classValue = "" ;
				while ( rset.next() && i<=end ){
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					out.println("<tr><td class='" + classValue + "'>");
					speciality_module = rset.getString(1);
					speciality_code = rset.getString(2);
					speciality_desc = rset.getString(3);
	 
					out.println(speciality_code+"</td><td class='" + classValue + "'>");
					out.println(speciality_desc+"</td><td class='" + classValue + "'>");
					out.println(speciality_module+"</td>");
		
					i++;
				}
			%>

		</table>
		<br><center>
		<%
		/*if(rset!=null)	rset.close();
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();*/
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(rset!=null)	rset.close();
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		//if(conn!=null)	conn.close(); //Commented for checkstyle
		//Added for checkstyle for COOMMON-ICN-0056
		if(conn!=null)	ConnectionManager.returnConnection(conn, request); 
	}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

