<%@ page import="java.sql.*, java.net.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
    String whereClause = request.getParameter("whereclause");
    StringBuffer sbQuery = new StringBuffer();
    String from = request.getParameter("from");
    String to = request.getParameter("to");

    if (whereClause == null || whereClause.equals("")) {
        String case_type_code = request.getParameter("case_type_code");
        if (case_type_code != null) case_type_code = case_type_code.toUpperCase();
        String longdesc = request.getParameter("long_desc");
        if (longdesc != null) longdesc = longdesc.toUpperCase();
        String enabled = request.getParameter("enabled");

        int andCheck = 0;

        if (!(case_type_code == null || case_type_code.equals(""))) {
            sbQuery.append("where upper(case_type_code) like '");
            sbQuery.append(case_type_code);
            sbQuery.append("%'");
            andCheck = 1;
        }

        if (!(longdesc == null || longdesc.equals(""))) {
            if (andCheck == 1) {    
                sbQuery.append(" and ");
                sbQuery.append("upper(long_desc) like  '");
                sbQuery.append(longdesc);
                sbQuery.append("%'");
            } else {
                sbQuery.setLength(0);
                sbQuery.append("where upper(long_desc) like '");
                sbQuery.append(longdesc);
                sbQuery.append("%'");
                andCheck = 1;
            }
        }

        if (!(enabled == null || enabled.equals("") || enabled.equals("B"))) {
            String strEffStatus = "";
            if (enabled.equals("E")) strEffStatus = "E";
            else if (enabled.equals("D")) strEffStatus = "D";

            if (andCheck == 0) {
                sbQuery.setLength(0);
                sbQuery.append("where eff_status='").append(strEffStatus).append("'");
            } else if (!enabled.equals("B")) {
                sbQuery.append(" and eff_status='").append(strEffStatus).append("'");
            }
        }

        // Appending order by clause
        String[] ord = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord .equals("")) )
	{
            sbQuery.append(" order by ");
            for (int i = 0; i < ord.length; i++) {
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
				}else{
                sbQuery.append(ord[i]);
					sbQuery.append(",");
            }
			}
        } else {
            sbQuery.append(" order by case_type_code");
        }
    } else {
        sbQuery.setLength(0);
        sbQuery.append(whereClause);
    }

    int start = (from == null) ? 1 : Integer.parseInt(from);
    int end = (to == null) ? 14 : Integer.parseInt(to);

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = ConnectionManager.getConnection(request);
        pstmt = conn.prepareStatement("select * from AE_CASE_TYPE " + sbQuery.toString());
        rs = pstmt.executeQuery();

        int i = start; // Initialize i here

        // Skip rows before the start index
        if (start != 1) {
            for (int j = 1; j < start; j++) {
                if (rs.next()) {
                    i++;
                } else {
                    break; // Stop if there are not enough rows
                }
            }
        }

        String classValue = "";
        int cnt = 0;

        while (i <= end && rs.next()) {
            if (cnt == 0) {
%>
                <P>
                <table align='right'>
                <tr>
                <%
                    if (start > 1) {
                        out.println("<td align='right' id='prev'><A HREF='../../eAE/jsp/QueryResultCaseType.jsp?from=" + (start - 14) + "&to=" + (end - 14) + "&whereclause=" + URLEncoder.encode(sbQuery.toString(), "UTF-8") + "' text-decoration='none'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.previous.label", "common_labels") + "</A></td>");
                    }
                %>
                <td align='right' id='next' style='visibility:hidden'>
                <%
                    out.println("<A HREF='../../eAE/jsp/QueryResultCaseType.jsp?from=" + (start + 14) + "&to=" + (end + 14) + "&whereclause=" + URLEncoder.encode(sbQuery.toString(), "UTF-8") + "' text-decoration='none'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.next.label", "common_labels") + "</A>");
                %>
                </td>
                </tr>
                </table>
                <BR><BR>
                </P>

                <table border="1" width="100%" cellspacing='0' cellpadding='0'>
                <th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
                <th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
                <th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th>Effective To</th-->
                <th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
            <% }
            classValue = (i % 2 == 0) ? "QRYEVEN" : "QRYODD";
            out.println("<tr><td class='" + classValue + "'>");
            String code = rs.getString("case_type_code");
            out.println("<a href='../../eAE/jsp/AddModifyCaseType.jsp?case_type_code=" + code + "&function=modify' target='f_query_add_mod'>" + code + "</a></td><td class='" + classValue + "'>");
	out.println(code+"</a></td><td class='" + classValue + "'>");
            out.println(rs.getString("long_desc"));
            out.println("</td><td class='" + classValue + "'>");
            out.println(rs.getString("short_desc"));
            out.println("</td><td class='" + classValue + "' align='center'>");
            out.println(rs.getString("eff_status").equals("E") ? "<img src='../../eCommon/images/enabled.gif'/>" : "<img src='../../eCommon/images/RRnwd.gif'/>");
            i++;
            cnt++;
        }

        if (cnt == 0) {
            out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
        } else {
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
            %>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
            <script>
                if (document.getElementById('next')) {
                    document.getElementById('next').style.visibility = '<%= flag ? "hidden" : "visible" %>';
                }
            </script>
            <% 
        }
%>
        </td></tr>
        </table>
        <br><center>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { /* Log error */ }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { /* Log error */ }
            if (conn != null) ConnectionManager.returnConnection(conn, request);
        }
%>
</center>
</BODY>
</HTML>

<%!    
    private String checkForNull(String inputString) {
        return (inputString == null) ? "" : inputString;
    }
    public static String checkForNull(String inputString, String defaultValue) {
        return ((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString;
    }
%>
