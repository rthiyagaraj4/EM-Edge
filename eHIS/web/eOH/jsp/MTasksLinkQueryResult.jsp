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
	<script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

	<%	
			Connection 	con = ConnectionManager.getConnection(request);
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
			ResultSet rs=null;
			ResultSet rset=null;

		try{
			String whereClause = request.getParameter("whereclause");
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			String trmt_code =request.getParameter("trmt_code")==null?"":request.getParameter( "trmt_code" );
			String task_code = request.getParameter("task_code")==null?"":request.getParameter( "task_code" );
			String task_desc = request.getParameter("task_desc")==null?"":request.getParameter( "task_desc" );
			String sql="";
			String trmt_desc="";
			String seq_no="";

			if ((whereClause == null || whereClause.equals(""))){
				int cnt=0;
				if ( !(trmt_code == null || trmt_code.equals(""))){
					sql = sql + " AND UPPER(A.TRMT_CODE ) LIKE UPPER('"+trmt_code +"%')";
					cnt++;
				}
				if ( !(task_code == null || task_code.equals(""))){
					if(cnt>0)
						sql = sql + " AND UPPER(A.TASK_CODE) LIKE UPPER('"+task_code+"%')";
					else{
						sql=sql+" AND UPPER(A.TASK_CODE) LIKE UPPER('"+task_code+"%')";
						cnt=1;
					}
				}
				if (!(task_desc == null || task_desc.equals(""))){
					if(cnt>0)
						sql = sql + " AND UPPER(B.TASK_DESC) LIKE UPPER('"+task_desc+"%')";
					else{
						sql=sql+" AND UPPER(B.TASK_DESC) LIKE UPPER('"+task_desc+"%')";
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

			//con = ConnectionManager.getConnection(request);
			int maxRecord = 0;
			try{
				//String strsql1 = "SELECT A.TRMT_CODE, A.TASK_CODE, B.TASK_DESC FROM  OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B WHERE A.TASK_CODE=B.TASK_CODE AND B.LANGUAGE_ID = '"+locale+"'" + sql;
				
				String strsql1 = "SELECT A.TRMT_CODE, C.TRMT_DESC, A.TASK_CODE, B.TASK_DESC,A.SEQ_NO FROM OH_TREATMENT_TASKS A, OH_TASKS_LANG_VW B, OH_TREATMENT_LANG_VW C WHERE A.TASK_CODE=B.TASK_CODE AND B.LANGUAGE_ID = C.LANGUAGE_ID AND A.TRMT_CODE = C.TRMT_CODE AND B.LANGUAGE_ID = '"+locale+"'" + sql;
				stmt = con.prepareStatement(strsql1);
				rs = stmt.executeQuery();
				int total=0;
				while(rs.next()){
					total++;
				}
				maxRecord=total;
				if(maxRecord == 0)
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
					
				stmt1=con.prepareStatement(strsql1);
				rset = stmt1.executeQuery();
		
			}catch(Exception e){
				System.err.println("Err MessageMTasksLinkQueryResult ::" +e);
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
							out.println("<A HREF='../jsp/MTasksLinkQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

						if ( !( (start+14) > maxRecord ) )
							out.println("<A HREF='../jsp/MTasksLinkQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

					%>
					</td>
				</tr>
			</table>
		</p>
		<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding=3 >
		  <tr>
			<td class="columnHeader">
				<fmt:message key="Common.Treatment.label" bundle="${common_labels}"/>
			</td>
			<td class="columnHeader">
				<fmt:message key="eOH.TreatmentDescription.Label" bundle="${oh_labels}"/>
			</td>
			<td class="columnHeader">
				<fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/>
			</td>
			<td class="columnHeader">
				<fmt:message key="eOH.TaskDescription.Label" bundle="${oh_labels}"/>
			</td>
			<td class="columnHeader">
				<fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/>
			</td>

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
					trmt_code = rset.getString(1);
					trmt_desc = rset.getString(2);
					task_code = rset.getString(3);
					task_desc = rset.getString(4);
					seq_no =    rset.getString(5); 	 
					out.println(trmt_code+"</td><td class='" + classValue + "'>");
					out.println(trmt_desc+"</td><td class='" + classValue + "'>");
					out.println(task_code+"</td><td class='" + classValue + "'>");
					out.println(task_desc+"</td><td class='" + classValue + "'>");
					out.println(seq_no+"</td>");
		
					i++;
				}
			%>

		  </tr>
		</table>
		<br><center>
		<%
		if(rset!=null)	rset.close();
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
	}
	catch(Exception e){
		System.err.println("Err Message: MTasksLinkQueryResult ::" +e);
	}
	finally{
		if(rset!=null)	rset.close();
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

