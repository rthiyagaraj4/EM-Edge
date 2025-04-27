<!DOCTYPE html>
 <%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
			int pageCnt = Integer.parseInt(MstQryPageCnt);

		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<br>
		<form>
		<%
		Connection con			=	null ;
		PreparedStatement stmt=null;
		PreparedStatement stmt1=null;
		ResultSet rset=null;
		ResultSet rs = null;
		String whereClause		=	"";
		String research_categ_fact_id = "";
		String research_categ_fact_desc = "";
		String eff_status = "";
		StringBuffer sql	=new StringBuffer();
		String mode				=	"";
		try	{
			mode="modify";
			whereClause= request.getParameter("whereclause");
			if(whereClause==null) whereClause="";
			String from = request.getParameter("from") ;
			String to = request.getParameter("to") ;
			research_categ_fact_id=(request.getParameter("RESEARCH_CATEG_FACT_ID")==null)?"":(String)request.getParameter("RESEARCH_CATEG_FACT_ID");
			research_categ_fact_desc=(request.getParameter("RESEARCH_CATEG_FACT_DESC")==null)?"":(String)request.getParameter("RESEARCH_CATEG_FACT_DESC");
			eff_status=request.getParameter("EFF_STATUS");
			if(eff_status == null) eff_status = "";
			if ((whereClause == null || whereClause.equals("null") || whereClause.equals("")))
			{
				int cnt=0;
				if(!(research_categ_fact_id == null || research_categ_fact_id.equals("null") || research_categ_fact_id.equals("")))
				{
					sql.append(" where upper(research_categ_fact_id) like upper('"+research_categ_fact_id+"%') ");
					cnt++;
				}	
				if(!(research_categ_fact_desc == null || research_categ_fact_desc.equals("null") || research_categ_fact_desc.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(research_categ_fact_desc) like upper('"+research_categ_fact_desc+"%')");
					}
					else
					{
						sql.append(" where upper(research_categ_fact_desc) like  upper('"+research_categ_fact_desc+"%')");
						cnt = 1;
					}
				}
				if (!(eff_status == null || eff_status.equals("null") || eff_status.equals("")))
				{
					if(eff_status.equals("E"))
					{
						if(cnt>0)
						{
							sql.append(" and eff_status='E'");
						}	
						else
						{
							sql.append(" where eff_status='E'");
						}
					}
					if (eff_status.equals("D"))
					{
						if(cnt>0)
						{
							sql.append(" and eff_status='D'");
						}
						else
						{
							sql.append(" where  eff_status='D'");
						}
					}
				}
				String ord[] = request.getParameterValues("orderbycolumns");
				if (!(ord == null || ord .equals("null") || ord .equals("")))
				{
					sql.append(" order by ");
					for (int i=0;i < ord.length;i++)
					{
						if (i == ord.length - 1)
						{
							sql.append(ord[i]);
						}
						else
						{
							sql.append(ord[i]+",");
						}
					}			
				}//if ord
			}// if of where clause
			else
			{
				sql.append(whereClause);
			}
			int start = 0 ;
			int end = 0 ;
			int i=1;
			if (from == null)
				start = 1 ;
			else
				start = Integer.parseInt(from) ;
			if (to == null)
				end = pageCnt;
			else
				end = Integer.parseInt(to) ;	
			con  = ConnectionManager.getConnection(request);
			
			int maxRecord =	 0;
			
			try
			{
				StringBuffer strsql=new StringBuffer();
				strsql.append("select count(*) as total from ca_research_category_fact");

				strsql.append(sql.toString());
				StringBuffer strsqll=new StringBuffer();
				strsqll.append("select research_categ_fact_id,research_categ_fact_desc,eff_status from ca_research_category_fact");
				stmt = con.prepareStatement(strsql.toString());	
				rs = stmt.executeQuery();
				rs.next();
				maxRecord = rs.getInt("total");
				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				strsqll.append(sql.toString());
				stmt1=con.prepareStatement(strsqll.toString());
				rset = stmt1.executeQuery();
			}
			catch (Exception e)
			{
				//out.println("Exception :"+e.getMessage());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		%>
				<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
					<tr>
						<td class='white' width='88%'></td> 
						<td  align='right' width='12%'>			
			<%
							if (!(start <= 1))
								out.println("<A HREF='../../eCA/jsp/ResearchPatientCategoryFactorsMasterResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							if (!((start+pageCnt) > maxRecord ))
								out.println("&nbsp;<A HREF='../../eCA/jsp/ResearchPatientCategoryFactorsMasterResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							%>
						</td>
					</tr>
				</table>
			
			<table  width='100%' class='grid' align='center' >
				<tr>
				<th class='columnheadercenter' width='15%' align="left"><fmt:message key="eCA.ResearchCategoryFactorCode.label" bundle="${ca_labels}"/></th>
				<th class='columnheadercenter' width='40%' align="left"><fmt:message key="eCA.ResearchCategoryFactorDescription.label" bundle="${ca_labels}"/></th>
				<th class='columnheadercenter' width='10%' align="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				</tr>
				<%
				if (start != 1)
					for(int j=1; j<start; i++,j++)
						rset.next() ;
				String classValue= " ";
				while (rset.next() && i<=end)
				{
					if (i % 2 == 0)
						classValue = "gridData" ;
					else
						classValue = "gridData" ;
					research_categ_fact_id	=(rset.getString(1)==null)?"":rset.getString(1);
					research_categ_fact_desc=(rset.getString(2)==null)?"":rset.getString(2); 
					eff_status=(rset.getString(3)==null)?"":rset.getString(3);
					out.println("<tr><td  class='" + classValue + "'>");
					out.println("<a href='../../eCA/jsp/ResearchPatientCategoryFactorsMaster.jsp?mode="+mode+"&research_categ_fact_id="+research_categ_fact_id+"' target='f_query_add_mod' class='gridLink'>");
					out.println(research_categ_fact_id+"</a></td>");
					out.println("<td class='" + classValue + "' >"+research_categ_fact_desc+"</td><td class='" + classValue + "' >");
					if (eff_status.equals("E"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td></tr>");
					i++;
				}
				%>
			</table>
		<%
			if(rs!=null) 	rs.close();
			if(stmt!=null)  stmt.close();
			if(rset!=null) 	rset.close();
			if(stmt1!=null)  stmt1.close();
			}//end of 1st try block
		catch (Exception e)
		{
			//out.println("Exception in try of ResearchPatientCategoryFactorsMasterResult.jsp:"+e.toString());//COMMON-ICN-0181
					  e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
		</form>
	</body>
</html>

