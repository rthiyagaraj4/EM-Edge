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
<%@ page import ="java.sql.*, java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartComponentAddNew.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>
		<script src='../../eCA/js/ChartSetup.js' language='javascript'></script>
				<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
    String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name='chartComponentAddNewForm' id='chartComponentAddNewForm'>
	<%
	Connection con = null;
	PreparedStatement psAddnew = null;
	PreparedStatement ps = null ;
	ResultSet rsAddnew = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();
	StringBuffer sqlAddNew = new StringBuffer();
	String discr_msr_id = "";
	String discr_msr_desc = "";
	String result_type = "";
	String associate_score_yn = "";
	String taskSearch="";
	String whereClause = "";
	String taskText = "";
	String condition = "";
	String classvalue="";

	String from = request.getParameter("from")==null ? "" : request.getParameter("from");
	String to =  request.getParameter("to")==null ? "" : request.getParameter("to");
	int i = 0;
	int noOfRows = 0;


	int start = 0;
	int end = 0;

	int maxRecord = 0;
	try{
			con = ConnectionManager.getConnection(request);
			whereClause =  request.getParameter("whereclause") == null ? "" : request.getParameter("whereclause");
			taskText =  request.getParameter("text_val") == null ? "" : request.getParameter("text_val");  
			if(whereClause.equals("")){
				condition =  request.getParameter("condition") == null ? "" : request.getParameter("condition");
				taskSearch = request.getParameter("search_val") == null ? "" : request.getParameter("search_val");
				

				if(taskSearch.equals("S")) //if search value is equal to 'Starts with'
				{
					taskText = taskText  + "%";
				}
				else if(taskSearch.equals("E")) //if search value is equal to 'Ends with'
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
					sql.append(" and UPPER(discr_msr_id) like upper(?) order by discr_msr_id ");
				}
		}
		else
		{
			sql.append(whereClause);
			
		}
		sqlAddNew.append("select  discr_msr_id,short_desc,result_type,associate_score_yn from am_discr_msr  where CH_APPL_YN='Y' and eff_status = 'E'  ");
		sqlAddNew.append(sql);
		ps = con.prepareStatement("select  count(*) total from am_discr_msr  where CH_APPL_YN='Y' and eff_status = 'E' " +sql.toString());

		ps.setString(1,taskText);
		rs = ps.executeQuery();
		while(rs.next())
		{
			maxRecord = rs.getInt(1);
		}
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>parent.chartSectionComponentListSummaryFrame.document.getElementById('Search').disabled= false;</script>");
			out.println("<script>document.URL='../../eCommon/html/blank.html' </script>");
		}
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
			out.println("<a href='../../eCA/jsp/ChartComponentAddRow.jsp?from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(sql.toString())+"&text_val="+URLEncoder.encode(taskText)+"'"+"text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");								
		}				
		if(!((start+9)>maxRecord)){
			out.println("<a href='../../eCA/jsp/ChartComponentAddRow.jsp?from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(sql.toString())+"&text_val="+URLEncoder.encode(taskText)+"'"+"text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
		}
%>
						</td>
					</tr>
				</table>
		<table width='100%' class='grid' id='tabList'>
				<tr>
					<th class='columnheader' width='10%' align="left"><fmt:message key="Common.DiscreteMeasureCode.label" bundle="${common_labels}"/></th> 
					<th class='columnheader' width='15%' align="left"><fmt:message key="Common.DiscreteMeasureDescription.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='10%' align="left"><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/></th>
				</tr>	
		<%	
			psAddnew = con.prepareStatement(sqlAddNew.toString());
			psAddnew.setString(1,taskText);
			rsAddnew = psAddnew.executeQuery();
				if(start!=1){
				for(int j=1;j<start;i++,j++){
					rsAddnew.next();
				}
			}
			while(rsAddnew.next() && i<end){
			
				discr_msr_id = rsAddnew.getString(1) == null ? "" : rsAddnew.getString(1);
				discr_msr_desc = rsAddnew.getString(2) == null ? "" : rsAddnew.getString(2);
				result_type = rsAddnew.getString(3) == null ? "" : rsAddnew.getString(3);
				associate_score_yn = rsAddnew.getString(4) == null ? "" : rsAddnew.getString(4);
				if(i%2 == 0){
					classvalue = "gridData";
				}
				else{
					classvalue = "gridData";
				}
				
				out.println("<tr id ='trRowId"+noOfRows+"'>");
				out.println("<td class='" + classvalue + "' >"+discr_msr_id+"</td>");
				out.println("<td class = '"+classvalue+"' >");
				out.println("<a href='javascript:'  onClick='addrow(\""+noOfRows+"\");' class='gridLink'>");
				out.println(discr_msr_desc+"</a></td>");
				out.println("<td width='5%' style='display:none'>" +result_type+"||"+associate_score_yn+ "</td>");
				
				out.println("<td class = '"+classvalue+"' ><input type='checkBox' name='default_yn"+noOfRows+"' id='default_yn"+noOfRows+"' OnClick='activateText(this,"+noOfRows+")'><input type='text' STYLE='visibility:hidden' name='seq_num"+noOfRows+"' id='seq_num"+noOfRows+"' size='6' maxlength='3' onKeyPress='return allowValidNumber(this,event,2,0);' OnBlur='checkSequence(this)'></td>");//IN058155
				out.println("</tr>");
				i++;
				noOfRows++;
		}//end of while
		out.println("<input type='hidden' name='sequence' id='sequence' value='"+noOfRows+"'>");
		%>
<script>
parent.chartSectionComponentListSummaryFrame.document.getElementById('Search').disabled= false;
</script>
<%	
		if(rs!=null) rs.close();
		if(rsAddnew!=null) rsAddnew.close();
		if(ps!=null) ps.close();
		if(psAddnew!=null) psAddnew.close();
		}//end of try
	catch(Exception e){
		//out.println("Exception in try of ChartComponentAddRow"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
	}
	finally{
						
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
	</table>
	</form>
	</body>
</html>
	

