<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page    import ="eBL.*,eBL.Common.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- JSP Page specific a8ttributes end --%>

<%!
	
public String formatDate(String inputDate){
	if(inputDate==null || inputDate.equals("")){
		return "";
	}
	else
	{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Timestamp inputTimeStamp = null;
    String outputDate=inputDate;
    long longTimeStamp = 0;
    inputTimeStamp = Timestamp.valueOf(inputDate);
    longTimeStamp = inputTimeStamp.getTime();
    outputDate=sdf.format(longTimeStamp);
    return outputDate;	
	}
}
%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"
			+ sStyle
			+ "'></link></head><BODY  class='CONTENT'  onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String facility_id = (String) session.getValue("facility_id");
	String locale = (String) session.getAttribute("LOCALE");
	if ((whereClause == null || whereClause.equals(""))) {

		String card_type_code = request.getParameter("card_type_code");
		String status = request.getParameter("status");
		String long_desc = request.getParameter("long_desc");


		if (!(facility_id == null || facility_id.equals(""))) {
			sql.append(" where operating_facility_id='" + facility_id
					+ "'   ");
		}

		if (!(card_type_code == null || card_type_code.equals(""))) {
			sql.append(" and upper(card_type_code) like upper('%" + card_type_code + "%')   ");
		}

		if (!(status == null || status.equals("") || status.equals("A"))) {
			sql.append(" and upper(status)=upper('" + status + "')  ");
		}
		
		if (!(long_desc == null || long_desc.equals(""))) {
			sql.append(" and upper(long_desc) like upper('%" + long_desc + "%')  ");
		}
		

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if (!(ord == null || ord.equals(""))) {
			sql.append(" order by ");
			for (int i = 0; i < ord.length; i++) {
				if (i == ord.length - 1)
					sql.append(ord[i]);
				else
					sql.append(ord[i] + ",");
			}
		}
	} //end of where clause IF
	else {
		sql.append(whereClause);
	}


	
	int start = 0;
	int end = 0;
	int i = 1;

	if (from == null)
		start = 1;
	else
		start = Integer.parseInt(from);
	if (to == null)
		end = 14;
	else
		end = Integer.parseInt(to);

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	try {
		con = ConnectionManager.getConnection(request);

		StringBuffer strSql = new StringBuffer();
		System.out.println(sql);
		strSql.append(BlRepository.getBlKeyValue("BL_HEALTHCARD_DEFN_QRYRESULT"));
		strSql.append(sql.toString());
		
		stmt = con.prepareStatement(strSql.toString());
		rs = stmt.executeQuery();
		String classValue = "";
		int cnt = 0;
		String endOfRes = "1";
		if (start != 1)
			for (int j = 1; j < start; i++, j++) {
				rs.next();
			}
		while (i <= end && rs.next()) {
			if (cnt == 0) {
%>
<p>
	<table align='right'>
		<tr>
			<td>
<%
	if (!(start <= 1))
					out.println("<A HREF='../../eBL/jsp/HealthCardMasterQueryResult.jsp?from="
							+ (start - 14)
							+ "&to="
							+ (end - 14)
							+ "&whereclause="
							+ URLEncoder.encode(sql.toString())
							+ "'"
							+ " text-decoration='none'>"
							+ com.ehis.util.BundleMessage
									.getBundleMessage(pageContext,
											"Common.previous.label",
											"common_labels") + "</A>");

				if (endOfRes.equals("1"))
					out.println("<A id='nextvalue' HREF='../../eBL/jsp/HealthCardMasterQueryResult.jsp?from="
							+ (start + 14)
							+ "&to="
							+ (end + 14)
							+ "&whereclause="
							+ URLEncoder.encode(sql.toString())
							+ "'"
							+ " text-decoration='none'>"
							+ com.ehis.util.BundleMessage
									.getBundleMessage(pageContext,
											"Common.next.label",
											"common_labels") + "</A>");
%>
			</td>
		</tr>
	</table>
	</p>
	<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th width='10%'><fmt:message key="eBL.CARD_TYPE.label" bundle="${common_labels}" /></th>
		<th width='35%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}" /></th>
		<th width='5%'> <fmt:message key="Common.status.label" bundle="${common_labels}" /></th>
		<th width='25%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}" /></th>
		<th width='25%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}" /></th>
<%
	}
			if (i % 2 == 0)
				classValue = "QRYEVEN";
			else
				classValue = "QRYODD";

			String card_type_code = rs.getString("card_type_code");
			if (card_type_code == null)
				card_type_code = "&nbsp;";
				
			String long_desc = rs.getString("long_desc");
			if (long_desc == null)
				long_desc = "&nbsp;";
				
			String status = rs.getString("status");
			if (status == null)
				status = "&nbsp;";
				
			String effective_from = rs.getString("effective_from");
			if (effective_from == null)
				effective_from = "&nbsp;";
			else
				effective_from=formatDate(effective_from);
				
			String effective_to = rs.getString("effective_to");
			if (effective_to == null)
				effective_to = "&nbsp;";
			else
				effective_to=formatDate(effective_to);

				
			String URL="../../eBL/jsp/HealthCardMaster.jsp?action_mode=update";
			StringBuilder modifyURLParam = new StringBuilder();
			modifyURLParam.append("&card_type_code="+URLEncoder.encode(card_type_code,"UTF-8"));
			modifyURLParam.append("&long_desc="+URLEncoder.encode(long_desc,"UTF-8"));
			modifyURLParam.append("&status="+URLEncoder.encode(status,"UTF-8"));
			modifyURLParam.append("&effective_from="+URLEncoder.encode(effective_from,"UTF-8"));
			modifyURLParam.append("&effective_to="+URLEncoder.encode(effective_to,"UTF-8"));
			
			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href="+ URL + modifyURLParam.toString() + "&target='f_query_add_mod'>");
			out.println(card_type_code+"</a></td><td class='"+ classValue + "'>");
			out.println(long_desc+ "</td><td  class='"	+ classValue + "'>");
			out.println(status + "</td><td  class='" + classValue	+ "'>");
			out.println(effective_from + "</td><td  class='" + classValue	+ "'>");
			out.println(effective_to + "</td></tr>");
			i++;
			cnt++;
		}//endwhile
		if (cnt == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		if (!rs.next() && cnt != 0) {
			endOfRes = "0";
%>
	<script>
		document.getElementById('nextvalue').innerHTML=" ";
	</script>
<%
	}
%>
		</td></tr>
</table>
<br><center>
</center>
<%
	sql.setLength(0);
		strSql.setLength(0);

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
	} catch (Exception e) {
		e.toString();
		out.println(e.toString());
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
%>

</BODY>
</HTML>

