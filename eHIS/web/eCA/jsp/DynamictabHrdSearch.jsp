<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script language="javascript" src="../js/ChartHistoryTemplate.js"></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>

	</head>

	<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<%  	request.setCharacterEncoding("UTF-8");	%>
	<%
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			
			String summaryid=request.getParameter("summaryid")==null?"":request.getParameter("summaryid");
			String summarydupid=request.getParameter("summarydupid")==null?"":request.getParameter("summarydupid");
			
			
			String resSummaryId="";
			int count=0;
			try
			{
					con=ConnectionManager.getConnection(request);

						if (!summaryid.equals(""))
						{
							if(summaryid.equals(summarydupid)) summaryid=summaryid;
							else	 summaryid=summaryid+"%";
						}
					
					String sql="SELECT SUMMARY_ID,SUMMARY_DESC FROM CA_CHART_SUMM_HEADER  where  upper(SUMMARY_ID) like upper(?)  ";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,summaryid);
					rset=pstmt.executeQuery();

					while(rset.next())
					{
								resSummaryId=rset.getString("SUMMARY_ID");
								count=count+1;
					}
					if (count==1)
					{ 
								out.println("<script>");
								out.println("parent.frames[1].frames[0].document.forms[0].summaryid.value='"+resSummaryId+"'");
								out.println("parent.frames[1].frames[0].checkRecord(parent.frames[1].frames[0].document.forms[0].summaryid)");
								out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }
			
					if (count>1  || count==0)
					{ 	%>
						<script language=javascript>
								parent.frames[1].frames[0].document.forms[0].search.disabled=true;
								callfunction();
						</script>
				<% }
				if (rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Error Raise"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}finally
			{
					
					if (con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
	</body>

