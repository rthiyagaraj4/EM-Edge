<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
		
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form>
		<%
		Connection con			=	null ;
		String whereClause		=	"";
		String menu_id			=	"";
		String root_menu_yn		=	"";
		String short_desc		=	"";
		String long_desc		=	"";
		String eff_status		=	"";
		//String sql				=	"";
		String mode				=	"";
		String patient_chart_yn	=	"";
		String desktop_yn		=	"";
		//String strsql ="";
		//String strsqll="";
		String from ="";
		String to ="";

		//Modified by Archana @10-12-2008
	    String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
        int pageCnt = Integer.parseInt(MstQryPageCnt);

		StringBuffer strsql = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		StringBuffer strsqll = new StringBuffer();

		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
		int maxRecord =	 0;
		ResultSet rset=null;
		ResultSet rs = null;
		try	
		{
			mode="modify";
			whereClause= request.getParameter("whereclause");
			if(whereClause==null) whereClause="";
			from = request.getParameter("from") ;
			to = request.getParameter("to") ;

			menu_id=request.getParameter("menu_id");
			if( menu_id == null)
				menu_id = "";

			root_menu_yn=request.getParameter("root_menu_yn");
			if(root_menu_yn == null)
				root_menu_yn=""; 
			root_menu_yn 	= (root_menu_yn.equals(""))?"D":root_menu_yn ;
			short_desc=request.getParameter("short_desc");
			if(short_desc == null)
				short_desc="";
			long_desc=request.getParameter("long_desc");
			if(long_desc == null)
				long_desc="";
			eff_status=request.getParameter("eff_status");
			if( eff_status == null)
				eff_status = "";
			patient_chart_yn=request.getParameter("patient_chart_yn");
			if(patient_chart_yn == null)
				patient_chart_yn=""; 
			patient_chart_yn 	= (patient_chart_yn.equals(""))?"D":patient_chart_yn ;
			desktop_yn=request.getParameter("desktop_yn");
			if(desktop_yn == null)
				desktop_yn=""; 
			desktop_yn 	= (desktop_yn.equals(""))?"D":desktop_yn ;
			if ((whereClause == null || whereClause.equals("null") || whereClause.equals("")))
			{
				int cnt=0;
				if(sql.length() > 0) sql.delete(0,sql.length());
				if(!(menu_id == null || menu_id.equals("null") || menu_id.equals("")))
				{
					sql.append(" where upper(menu_id) like upper('"+menu_id+"%') ");
					cnt++;
				}
				if (!(root_menu_yn == null || root_menu_yn.equals("null") || root_menu_yn.equals("")))
				{
					if(root_menu_yn.equals("Y"))
					{
						if(cnt>0)
						{
							sql.append(" and root_menu_yn='Y'");
						}
						else
						{
							sql.append(" where root_menu_yn='Y'");
							cnt = 1;
						}
					}
					if (root_menu_yn.equals("N"))
					{
						if(cnt>0)
						{	
							sql.append(" and root_menu_yn='N'");
						}
						else
						{
							sql.append(" where  root_menu_yn='N'");
							cnt = 1;
						}
					}
				}
				if(!(short_desc == null  || short_desc.equals("null") || short_desc.equals("")))
				{
					if(cnt>0)
					{
						sql.append(" and upper(short_desc) like upper('"+short_desc+"%')");
					}
					else
					{
						sql.append(" where upper(short_desc) like  upper('"+short_desc+"%')");
						cnt = 1;
					}
				}
				if(!(long_desc == null  || long_desc.equals("null") || long_desc.equals("")))
				{
					if(cnt>0)
					{
						sql.append(" and upper(long_desc) like upper('"+long_desc+"%')");
					}
					else
					{
						sql.append(" where upper(long_desc) like  upper('"+long_desc+"%')");
						cnt = 1;
					}
				}		
				if (!(desktop_yn == null || desktop_yn.equals("null") || desktop_yn.equals("")))
				{
					if(desktop_yn.equals("E"))
					{
						if(cnt>0)
						{
							sql.append(" and desktop_yn='Y'");
						}	
						else
						{
							sql.append(" where desktop_yn='Y'");
							cnt = 1;
						}
					}	
					if (desktop_yn.equals("D"))
					{
						if(cnt>0)
						{	
							sql.append(" and desktop_yn='N'");
						}
						else
						{
							sql.append(" where  desktop_yn='N'");
							cnt = 1;
						}
					}
				}
				//patient chart....
				if (!(patient_chart_yn == null || patient_chart_yn.equals("null") || patient_chart_yn.equals("")))
				{
					if(patient_chart_yn.equals("E"))
					{
						if(cnt>0)
						{
							sql.append(" and patient_chart_yn='Y'");
						}	
						else
						{
							sql.append(" where patient_chart_yn='Y'");
							cnt = 1;
						}
					}
					if (patient_chart_yn.equals("D"))
					{
						if(cnt>0)
						{
							sql.append(" and patient_chart_yn='N'");
						}	
						else
						{
							sql.append(" where  patient_chart_yn='N'");
							cnt = 1;
						}
					}
				}
				if (!(eff_status == null || eff_status.equals("null") || eff_status.equals("")))
				{
					if( eff_status.equals("E"))
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
				if (!(ord == null  || ord .equals("null") || ord .equals("")))
				{
					sql.append(" order by ");
					for ( int i=0;i < ord.length;i++ )
					{
						if ( i == ord.length - 1 )
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
				sql = new StringBuffer();
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
				end = pageCnt ;
			else
				end = Integer.parseInt(to) ;	

			con  = ConnectionManager.getConnection(request);
			try
			{	if(strsql.length() > 0) strsql.delete(0,strsql.length());
				strsql.append("select count(*) as total from ca_menu_header");
				strsql.append(sql.toString());
				pstmt = con.prepareStatement(strsql.toString());
				rs = pstmt.executeQuery();
				rs.next();
				maxRecord = rs.getInt("total");
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
				}
				if(strsqll.length() > 0) strsqll.delete(0,strsqll.length());
				strsqll.append("select menu_id,root_menu_yn,short_desc,long_desc,eff_status,patient_chart_yn,desktop_yn from ca_menu_header ");
				strsqll.append(sql.toString());
				pstmt1=con.prepareStatement(strsqll.toString());
		
				rset = pstmt1.executeQuery();
			}
			catch (Exception e)
			{
			//	out.println("Exception in CADefineMenuQueryResult.jsp:"+e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		%>
				<table align='center' width='100%' cellpadding=3>
					<tr>
						<td align='right'>
							<%
							if ( !(start <= 1) )
								out.println("<A class='gridLink' HREF='../../eCA/jsp/CADefineMenuQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							if ( !( (start+pageCnt) > maxRecord ) )
								out.println("<A class='gridLink' HREF='../../eCA/jsp/CADefineMenuQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							%>
							</td>
						</tr>
				</table>
								
			<table width='100%' class='grid' align='center' >
				<td class=COLUMNHEADERCENTER ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
				<td class=COLUMNHEADERCENTER><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td class=COLUMNHEADERCENTER><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class=COLUMNHEADERCENTER><fmt:message key="Common.RootMenu.label" bundle="${common_labels}"/></td>
				<td class=COLUMNHEADERCENTER><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class=COLUMNHEADERCENTER><fmt:message key="eCA.Desktop.label" bundle="${ca_labels}"/></td>
				<td class=COLUMNHEADERCENTER><fmt:message key="Common.patientchart.label" bundle="${common_labels}"/></td>
				<%
				if ( start != 1 )
					for( int j=1; j<start; i++,j++ )
						rset.next() ;
				String classValue= "gridData";
				while ( rset.next() && i<=end  )
				{
					/*if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;*/
					menu_id	=(rset.getString(1)==null)?"":rset.getString(1);
					root_menu_yn=(rset.getString(2)==null)?"":rset.getString(2); 
					short_desc=(rset.getString(3)==null)?"":rset.getString(3); 
					long_desc=(rset.getString(4)==null)?"":rset.getString(4); 
					eff_status	=(rset.getString(5)==null)?"":rset.getString(5);
					patient_chart_yn =(rset.getString(5)==null)?"":rset.getString(6);
					desktop_yn	=(rset.getString(5)==null)?"":rset.getString(7);
					out.println("<tr><td  class='" + classValue + "'>");
					out.println("<a class='gridLink' href='../../eCA/jsp/CADefineMenu.jsp?mode="+mode+"&menu_id="+menu_id+"' target='f_query_add_mod' >");
					out.println(menu_id+"</a></td>");
					out.println("<td class='" + classValue + "' >"+short_desc+"</td><td class='" + classValue + "' >"+long_desc+"</td>");
				
					out.println("<td class='" + classValue + "'>");
						if (root_menu_yn.equals("Y"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td>");
					
					out.println("<td class='" + classValue + "' >");
						if (eff_status.equals("E") )
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
						out.println("</td>");
					out.println("<td class='" + classValue + "' >");
		
					if (desktop_yn.equals("Y"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td>");
					out.println("<td class='" + classValue + "'>");
					if (patient_chart_yn.equals("Y"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td></tr>");
					i++;
				}
				%>
			</table>
		<%
			if(rs!=null)rs.close();
			if(rset!=null)rset.close();;
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
		}//end of 1st try block
		catch (Exception e)
		{
			//out.println("Exception :"+e.toString());//COMMON-ICN-0181
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

