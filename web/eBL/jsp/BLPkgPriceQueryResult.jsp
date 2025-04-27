<!DOCTYPE html>
<!--
----------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
----------------------------------------------------------------------------------------------
23-Oct-2012      100           	Karthikeyan.K       created
----------------------------------------------------------------------------------------------
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

	StringBuffer sql = new StringBuffer();
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String facility_id = (String) session.getValue("facility_id");
	String locale = (String) session.getAttribute("LOCALE");

	String userIdParam= request.getParameter("userId");	
	String statusParam = request.getParameter("status");
	String dateParam = request.getParameter("date");

	if (!(facility_id == null || facility_id.equals(""))) {
		sql.append(" where operating_facility_id='" + facility_id + "'   ");
	}
	
	if (!(userIdParam == null || userIdParam.equals(""))) {
		sql.append(" and upper(USER_ID) like upper('%" + userIdParam + "%')  ");
	}

	if (!(statusParam == null || statusParam.equals(""))) {
		if(statusParam.equals("V")){
		sql.append(" and ERROR_FLAG=0  and  EFF_STATUS = 1 ");
		}
		else if(statusParam.equals("I")){
		sql.append(" and ERROR_FLAG=1 ");
		}
	}
	
	if (!(dateParam == null || dateParam.equals(""))) {
		sql.append(" and EFF_FROM_DATE>to_date('"+dateParam+"','DD/MM/YYYY') " );
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
		strSql.append(BlRepository.getBlKeyValue("BLPKGPRICEQUERY_PKG_PRICE_MAIN"));
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
				out.println("<A HREF='../../eBL/jsp/BLPkgPriceQueryResult.jsp?from="
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
					out.println("<A id='nextvalue' HREF='../../eBL/jsp/BLPkgPriceQueryResult.jsp?from="
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
		<th width='20%'><fmt:message key="Common.user.label" bundle="${common_labels}" /></th>
		<th width='15%'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${common_labels}" /></th>
		<th width='15%'><fmt:message key="eBL.CustomerCode.label" bundle="${common_labels}" /></th>
		<th width='15%'><fmt:message key="eBL.BillingGroup.label" bundle="${common_labels}" /></th>
		<th width='15%'><fmt:message key="eBL.BillingClassDesc.label" bundle="${common_labels}" /></th>
		<th width='10%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}" /></th>
		<th width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}" /></th>
<%
	}
		if (i % 2 == 0)
			classValue = "QRYEVEN";
		else
			classValue = "QRYODD";

		
		String USER_ID = rs.getString("USER_ID");
		if (USER_ID == null)
			USER_ID = "&nbsp;";
			
		String CUST_GROUP_CODE = BLHelper.fetchCustGroupDesc(rs.getString("CUST_GROUP_CODE"),con);
		if (CUST_GROUP_CODE == null)
			CUST_GROUP_CODE = "&nbsp;";
			
		String CUST_CODE = BLHelper.fetchCustDesc(rs.getString("CUST_CODE"),con);
		if (CUST_CODE == null)
			CUST_CODE = "&nbsp;";
			
		String BLNG_GRP_ID = BLHelper.fetchDescription(BlRepository.getBlKeyValue("BLPKGPRICEQUERY_BLNGGRP_DESC"),rs.getString("BLNG_GRP_ID"),con);
		if (BLNG_GRP_ID == null)
			BLNG_GRP_ID = "&nbsp;";		
			
		String BLNG_CLASS_CODE = BLHelper.fetchDescription(BlRepository.getBlKeyValue("BLPKGPRICEQUERY_BLNGCLASS_DESC"),rs.getString("BLNG_CLASS_CODE"),con);
		if (BLNG_CLASS_CODE == null)
			BLNG_CLASS_CODE = "&nbsp;";					
			
		String EFF_FROM_DATE = rs.getString("EFF_FROM_DATE");
		if (EFF_FROM_DATE == null)
			EFF_FROM_DATE = "&nbsp;";
		else
			EFF_FROM_DATE=formatDate(EFF_FROM_DATE);
			
		String EFF_TO_DATE = rs.getString("EFF_TO_DATE");
		if (EFF_TO_DATE == null)
			EFF_TO_DATE = "&nbsp;";
		else
			EFF_TO_DATE=formatDate(EFF_TO_DATE);
	
		out.println("<tr><td class='" + classValue + "'>");
		out.println(USER_ID+"</a></td><td class='"+ classValue + "'>");
		out.println(CUST_GROUP_CODE+"</a></td><td class='"+ classValue + "'>");
		out.println(CUST_CODE+ "</td><td  class='"	+ classValue + "'>");
		out.println(BLNG_GRP_ID + "</td><td  class='" + classValue	+ "'>");
		out.println(BLNG_CLASS_CODE + "</td><td  class='" + classValue	+ "'>");
		out.println(EFF_FROM_DATE + "</td><td  class='" + classValue	+ "'>");
		out.println(EFF_TO_DATE + "</td></tr>");
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

