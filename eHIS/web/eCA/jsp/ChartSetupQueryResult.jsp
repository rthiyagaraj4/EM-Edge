<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartQueryResult.label" bundle="${ca_labels}"/></title>
		<script src='../../eCA/js/ChartSetup.js' language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
 request.setCharacterEncoding("UTF-8");
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<!-- Added by Arvind @ 08-12-08 -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	</head>
	<body class='content'   OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
		<form name='ChartQueryResult' id='ChartQueryResult' action='ChartSetupServlet'>
		<%
		Connection con = null;
		String whereclause = "";
		String chart_id = "";
		String long_desc = "";
		String short_desc = "";
		String eff_status = "";
		//String day_summary_req_yn = "";
		//String day_start_time = "";
		//String day_end_time = "";
		//String shift_summary_req_yn = "";
		String mode = "";
		String sql = "";
		String from = "";
		String to = "";
		String classvalue = "";

		StringBuffer sbModify = new StringBuffer();
		StringBuffer sbSQLQuery = new StringBuffer();
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
	 int pageCnt = Integer.parseInt(MstQryPageCnt);
		
		int totRec = 0;
		int count =0;
		int start = 0;
		int end = 0;
		PreparedStatement pstmtmodify = null;
		PreparedStatement pstmtmod = null;
		ResultSet resModify = null;
		ResultSet resmod = null;

		try{
			whereclause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
			from = request.getParameter("from");
			to = request.getParameter("to");
			chart_id = request.getParameter("chart_id")==null?"":request.getParameter("chart_id");
			long_desc = request.getParameter("long_desc")==null?"":request.getParameter("long_desc");
			short_desc = request.getParameter("short_desc")==null?"":request.getParameter("short_desc");
			eff_status = request.getParameter("enabled")==null?"":request.getParameter("enabled");
	
			if((whereclause==null)||(whereclause.equals("null"))||(whereclause.equals(""))){
				count=0;
				if(!((chart_id==null)||(chart_id.equals(""))||(chart_id.equals("null")))){
					sbModify.append(" where upper(chart_id) like upper('"+chart_id+"%') ");	
					count++;
				}
				if(!(long_desc==null || long_desc.equals("null") || long_desc.equals(""))){
					if(count>0){
						sbModify.append(" and upper(long_desc) like upper('"+long_desc+"%') ");
					}
					else{
						sbModify.append(" where upper(long_desc) like upper('"+long_desc+"%') ");
						count=1;
					}
				}
				if(!(short_desc==null || short_desc.equals("null") || short_desc.equals(""))){
					if(count>0){
						sbModify.append(" and upper(short_desc) like upper('"+short_desc+"%') ");
					}
					else{
						sbModify.append(" where upper(short_desc) like upper('"+short_desc+"%') ");
						count=1;
					}
				}
				if(!(eff_status==null || eff_status.equals("") || eff_status.equals("null"))){
					if(eff_status.equals("E")){
						if(count>0){
							sbModify.append(" and eff_status='E' ");
						}
						else{
							sbModify.append(" where eff_status='E' ");
						}
					}
					if(eff_status.equals("D")){
						if(count>0){
							sbModify.append(" and eff_status='D' ");
						}
						else{
							sbModify.append(" where eff_status='D' ");
						}
					}
				}
				String order[] = request.getParameterValues("orderbycolumns");
				if(!(order==null || order.equals("null") || order.equals(""))){
					sbModify.append(" order by ");
					for(int i=0;i<order.length;i++){
						if(i==order.length-1){
							sbModify.append(order[i]);
						}
						else{
							sbModify.append(order[i]);
							sbModify.append(",");
						}
					}//for of order
				}//if of order

			}//if of whereclause
			else{
				sbModify.append(whereclause);
			}
			int i = 0;
			if(from==null){
				start = 1;
			}
			else {
				start = Integer.parseInt(from);					
			}
			if(to==null){
				end=pageCnt;
			}
			else{
				end = Integer.parseInt(to);
			}
			con = ConnectionManager.getConnection(request);
			try{
				sql = "select count(*) as total from ca_chart "  + sbModify.toString();
				pstmtmod = con.prepareStatement(sql);
				resmod = pstmtmod.executeQuery();
				resmod.next();

				totRec = resmod.getInt("total");

				if(totRec == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.back();</script>");
				}
				sbSQLQuery.append("select chart_id,long_desc,short_desc,eff_status from ca_chart");
				sbSQLQuery.append(sbModify.toString());
				pstmtmodify = con.prepareStatement(sbSQLQuery.toString());
				resModify = pstmtmodify.executeQuery();
			}//end of try-2
			catch(Exception e){
				//out.println("Exception in try-2 of ChartSetupQueryResult.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			%>
		
				<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
					<tr>
					<td class='white' width='88%'></td> 
					<td  align='right' width='12%'>
							<%
							if(!(start<=1)){
								out.println("<a class='gridLink' href='../../eCA/jsp/ChartSetupQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sbModify.toString())+"'" +"text-decoration='none' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");								
							}				
							if(!((start+pageCnt)>totRec)){
								out.println("&nbsp;<a class='gridLink'  href='../../eCA/jsp/ChartSetupQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sbModify.toString())+"'" +"text-decoration='none' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
							}
							%>
						</td>
					</tr>
				</table>
			<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center'>
				<th class ='columnheadercenter' width='10%' align='left' style="color: white;"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
				<th class ='columnheadercenter' width='45'  align='left' style="color: white;"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th class ='columnheadercenter' width='30%' align='left' style="color: white;"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th class ='columnheadercenter' width='15%' align='left' style="color: white;"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 
				<%
				if(start!=1){
					for(int j=1;j<start;i++,j++){
						resModify.next();
					}
				}
				while(resModify.next() && i<end){
					if(i%2 == 0){
						classvalue = "gridData";
					}
					else{
						classvalue = "gridData";
					}
					chart_id = (resModify.getString(1)==null)?"":resModify.getString(1);
					long_desc = (resModify.getString(2)==null)?"":resModify.getString(2);
					short_desc = (resModify.getString(3)==null)?"":resModify.getString(3);
					eff_status = (resModify.getString(4)==null)?"":resModify.getString(4);
					out.println("<tr><td  class = '"+classvalue+"'>");
					out.println("<a class='gridLink' href = '../../eCA/jsp/ChartSetupAddModify.jsp?mode="+mode+"&chart_id="+chart_id+"' target = 'f_query_add_mod' >");
					out.println(chart_id+"</a></td>");
					out.println("<td class='" + classvalue + "' >"+long_desc+"</td><td class='" + classvalue + "' >"+short_desc+"</td>");
					out.println("<td class='" + classvalue + "' >");
					if (eff_status.equals("E") )
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td>");
					i++;
				}
				%>
				</table>
				<%
			if(resmod!=null)resmod.close();
			if(pstmtmod!=null)pstmtmod.close();
			if(resModify!=null)resModify.close();
			if(pstmtmodify!=null)pstmtmodify.close();
		}//end of try-1		
		catch(Exception e){
			out.println("Exception in try-1 of ChartSetupQueryResult.jsp"+e.toString());
		}
		finally{
			
			if(con!=null) ConnectionManager.returnConnection(con,request);

		}
				%>
	
		</form>
	</body>
</html>

