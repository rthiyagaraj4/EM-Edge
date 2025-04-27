<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
21/12/2015  IN058155      Krishna Gowtham J								Limit on chart section - 99 rows only allowed
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eCA.ChartComponentAddPanel.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
	<form name='chartComponentAddNewForm' id='chartComponentAddNewForm'>
	<%
				Connection con = null;
				PreparedStatement pstmtAddPanel = null;
				ResultSet resAddPanel = null;	
				PreparedStatement ps = null ;
				ResultSet rs = null;

				String discr_msr_id = "";
				String discr_msr_desc = "";
				String chart_id = request.getParameter("chart_id")==null?"":request.getParameter("chart_id");
				String searchValue ="";
				String condition = "";
				StringBuffer sql = new StringBuffer();
				String whereClause = "";
				String taskText = request.getParameter("text_val") ==null ? "" : request.getParameter("text_val");
				String classvalue="";
				StringBuffer sqlAddPanel = new  StringBuffer();
				//String discr_msr_desc_dup = "";
				//String discr_msr_id_dup = "";
				String from = request.getParameter("from")==null ? "" : request.getParameter("from");
				String to =  request.getParameter("to")==null ? "" : request.getParameter("to");
				int i = 0;
				int noOfRows = 0;
				int start = 0;
				int end = 0;
				int maxRecord = 0;
				//int temp = 0;

				try{
				con = ConnectionManager.getConnection(request);
				whereClause =  request.getParameter("whereclause") == null ? "" : request.getParameter("whereclause");
				if(whereClause.equals("")){
					condition =  request.getParameter("condition") == null ? "" : request.getParameter("condition");
					searchValue = request.getParameter("search_val") == null ? "" : request.getParameter("search_val");
					if(searchValue.equals("S")) //if search value is equal to 'Starts with'
					{
						taskText = taskText  + "%";
					}
					else if(searchValue.equals("E")) //if search value is equal to 'Ends with'
					{
						taskText = "%" + taskText;
					}
					else //if search value is equal to 'Contains'
					{
						taskText = "%" + taskText + "%" ;
					}
					if(condition.equals("D")){
						sql.append(" and UPPER(short_desc) like upper(?) order by short_desc ");
					}
					else{
						sql.append( " and UPPER(discr_msr_id) like upper(?) order by discr_msr_id ");
					}
				}
				else
				{
					sql.append(whereClause);
				}	
				ps = con.prepareStatement("select  count(*) from am_discr_msr a where RESULT_TYPE in ('G') and not exists ( select 1 from  ca_chart_section_comp b where a.DISCR_MSR_ID = b.PANEL_ID and CHART_ID = ?) and a.eff_status='E'  " +sql.toString());
				ps.setString(2,taskText);
				ps.setString(1,chart_id);
				rs = ps.executeQuery();
				while(rs.next())
				{
					maxRecord = rs.getInt(1);
				}

					if(maxRecord == 0)
					{
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
						out.println("<script>parent.chartComponentAddPanelCriteriaFrame.document.getElementById('Search').disabled= false;</script>");
						out.println("<script>document.URL='../../eCommon/html/blank.html' </script>");
					}
					sqlAddPanel.append("select  SHORT_DESC short_desc,DISCR_MSR_ID discr_msr_id from am_discr_msr a where RESULT_TYPE in ('G') and not exists ( select 1 from  ca_chart_section_comp b where a.DISCR_MSR_ID = b.PANEL_ID and CHART_ID = ?) and a.eff_status='E'  ");
					sqlAddPanel.append(sql);
					pstmtAddPanel = con.prepareStatement(sqlAddPanel.toString());
					pstmtAddPanel.setString(1,chart_id);
					pstmtAddPanel.setString(2,taskText);
					%>
					<p>
						<table align='right'>
							<tr>
								<td>
						<%
							if(from.equals("")){
								start = 1;
							}
							else {
								start = Integer.parseInt(from);					
							}
							if(to.equals("")){
								end=9;
							}
							else{
								end = Integer.parseInt(to);
							}
							if(!(start<=1)){
								out.println("<a href='../../eCA/jsp/ChartComponentAddPanel.jsp?from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(sql.toString())+"&text_val="+URLEncoder.encode(taskText)+"&chart_id="+chart_id+"'"+"text-decoration='none' class='gridLink'>Prev</a>");								
							}				
							if(!((start+9)>maxRecord)){
								out.println("<a href='../../eCA/jsp/ChartComponentAddPanel.jsp?from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(sql.toString())+"&text_val="+URLEncoder.encode(taskText)+"&chart_id="+chart_id+"'"+"text-decoration='none' class='gridLink' >Next</a>");
							}

					%>
							</td>
					</tr>
				</table><br/>
		<table width='100%' class='grid' id='tabList'>
				<tr>
					<th class='columnheader' align="left" width='10%'><fmt:message key="Common.PanelID.label" bundle="${common_labels}"/></th> 
					<th class='columnheader' align="left" width='15%'><fmt:message key="Common.PanelDescription.label" bundle="${common_labels}"/></th>
					<th class='columnheader' align="left" width='10%'><fmt:message key="eCA.DisplayOrderSequence.label" bundle="${ca_labels}"/></th>
				</tr>
				<%
					resAddPanel = pstmtAddPanel.executeQuery();
					if(start!=1){
						for(int j=1;j<start;i++,j++){
							resAddPanel.next();
						}
					}

					while(resAddPanel.next() && i<end){
						discr_msr_id = resAddPanel.getString(2) == null ? "" : resAddPanel.getString(2);
						discr_msr_desc = resAddPanel.getString(1) == null ? "" : resAddPanel.getString(1);
						
						if(i%2 == 0){
							classvalue = "gridData";
						}
						else{
							classvalue = "gridData";
						}

						out.println("<tr id ='trRowId"+noOfRows+"'>");
						out.println("<td class='" + classvalue + "' >"+discr_msr_id+"</td>");
						out.println("<td class = '"+classvalue+"' >");
						out.println("<a href='javascript:'  onClick='addPanelForChart(\""+noOfRows+"\");' class='gridLink'>");
						out.println(discr_msr_desc+"</a></td>");
											
						out.println("<td class = '"+classvalue+"' ><input type='checkBox' name='default_yn"+noOfRows+"' id='default_yn"+noOfRows+"' OnClick='activateText(this,"+noOfRows+")'><input type='text' STYLE='visibility:hidden' name='seq_num"+noOfRows+"' id='seq_num"+noOfRows+"' size='6' maxlength='3' onKeyPress='return allowValidNumber(this,event,2,0);' OnBlur='checkSequence(this)'></td>");//IN058155
						out.println("</tr>");
						i++;
						noOfRows++;
				}//end of while

				out.println("<input type='hidden' name='sequence' id='sequence' value='"+noOfRows+"'>");
				%>
				<script>
					parent.chartComponentAddPanelCriteriaFrame.document.getElementById("Search").disabled= false;
				</script>
			<%
					if(rs!=null) rs.close();
					if(resAddPanel!=null) resAddPanel.close();
					if(ps!=null) ps.close();
					if(pstmtAddPanel!=null) pstmtAddPanel.close();
			}//end of try-1
				catch(Exception e){
					//out.println("Exception in try-1 of ChartComponentAddPanel.jsp"+e.toString());//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
				}
				finally{
					
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
			%>			
		</form>
	</body>
</html>

