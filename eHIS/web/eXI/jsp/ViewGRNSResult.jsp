<!DOCTYPE html>
<%@page
	import="java.util.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>

		<%
					String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
			type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script type="text/javascript"
			src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript'
			src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eXI/js/ViewGRNS.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
		<form name='ViewGRNsResultFrm' id='ViewGRNsResultFrm' action="ViewGRNSResult.jsp"
			method='post' target='messageFrame'>
			<%
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;	  
				String strFacilityId = "", strOpt = "";
				String strDateFrom = "", strDateTo = "";
				String strDocType = "", strDocNo = "";
				String from = "", to = "";
				String strStatus = "", strDispLeg = "";
				String strSelDocType = "", strSelDocNo = "";
				String strSelDoc = "", strChecked = "";
				String strValue = "N";
				String span = "1";
				String ibaDocNum = "", ibaDocTypeCode = "", processedById = "", processedDate = "";
				int maxRecord = 0;
				int start = 0;
				int end = 0;
				int i = 1;
				int nIdx = 0;																	   
				StringBuffer sbQuery = new StringBuffer();	   
				strFacilityId = (String) session.getValue("facility_id");
				strOpt = checkForNull(request.getParameter("opt"), "U");
				strDateFrom = checkForNull(request.getParameter("dt_from"));
				strDateTo = checkForNull(request.getParameter("dt_to"));
				from = checkForNull(request.getParameter("from"), "1");
				to = checkForNull(request.getParameter("to"), "8");
				strSelDoc = checkForNull(request.getParameter("selDoc"));
				start = Integer.parseInt(from);
				end = Integer.parseInt(to);								 
				try {
					if (!strSelDoc.equals("")) {
						StringTokenizer stTemp = new StringTokenizer(strSelDoc,
						"~~");

						if (stTemp.hasMoreTokens())
					strSelDocType = stTemp.nextToken();

						if (stTemp.hasMoreTokens())
					strSelDocNo = stTemp.nextToken();
					}									  
					con = ConnectionManager.getConnection(request);
					if (strOpt.equals("U")) {
						sbQuery
						.append("(SELECT DISTINCT DOC_TYPE_CODE,DOC_NO,IBA_DOC_NUM, IBA_DOC_TYPE_CODE FROM XI_TRN_GRN WHERE FACILITY_ID = ? AND GRN_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')+0.9999 AND TRANS_STATUS IS NULL )");
						//Added to remove the duplicates which are processed at a line level with error
						sbQuery.append(" MINUS (SELECT DISTINCT DOC_TYPE_CODE,DOC_NO,IBA_DOC_NUM, IBA_DOC_TYPE_CODE FROM XI_TRN_GRN WHERE FACILITY_ID = ? AND TRANS_STATUS ='E' ) ");
					} else if(strOpt.equals("P")) {
						sbQuery.append("SELECT DISTINCT DOC_TYPE_CODE,DOC_NO,TRANS_STATUS,IBA_DOC_NUM, IBA_DOC_TYPE_CODE, PROCESSED_BY_ID, to_char(GRN_DATE,'dd/mm/yyyy') FROM XI_TRN_GRN WHERE FACILITY_ID = ? AND ((TRANS_STATUS='P') AND GRN_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')+0.9999 ) ORDER BY DOC_TYPE_CODE,doc_no ");
					}
					else if(strOpt.equals("E")) {
						sbQuery.append("SELECT DISTINCT DOC_TYPE_CODE,DOC_NO,TRANS_STATUS,IBA_DOC_NUM, IBA_DOC_TYPE_CODE, PROCESSED_BY_ID, to_char(GRN_DATE,'dd/mm/yyyy hh24:mi:ss') FROM XI_TRN_GRN WHERE FACILITY_ID = ? AND ((TRANS_STATUS='E') AND GRN_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')+0.9999 ) ORDER BY DOC_TYPE_CODE,doc_no ");
					}
					
					pstmt = con.prepareStatement(sbQuery.toString());

					if (strOpt.equals("U")) {
						pstmt.setString(1, strFacilityId);
						pstmt.setString(2, strDateFrom);
						pstmt.setString(3, strDateTo);
						pstmt.setString(4, strFacilityId);
					} else {
//						System.out.println(strDateFrom);
//						System.out.println(strDateTo);
						pstmt.setString(1, strFacilityId);
						pstmt.setString(2, strDateFrom);
						pstmt.setString(3, strDateTo);
					}

					rs = pstmt.executeQuery();

					if (rs != null) {
						while (rs.next())
					maxRecord++;
					}

					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception ee) {
					System.out.println("Exception in ViewGRNSResult.jsp 111=" + ee);
					ee.printStackTrace();
				}

				try {
					if (maxRecord > 0) {
			%>
			<table border="0" cellpadding='3' cellspacing='0' id='tableId'
				width="100%">
				<tr>
					<td colspan='6' align='right' style="color:blue;background:white">
						<%
						if (!(start <= 1)) {
						%>
						<a href='javascript:submitPrevNext(<%=(start - 8)%>,<%=(end - 8)%>)'
							text-decoration='none'>Previous</a>
						<input type=hidden name='whichPage' id='whichPage' value='prev'>
						<%
									}
									if (!((start + 8) > maxRecord)) {
						%>
						<a href='javascript:submitPrevNext(<%=(start + 8)%>,<%=(end + 8)%>)'
							text-decoration='none'>Next</a>
						<input type=hidden name='whichPage' id='whichPage' value='next'>
						<%
						}
						%>
					</td>
				</tr>
				<%
				if (strOpt.equals("U")) {
				%>
				<tr>
					<td nowrap width="50%" id='thDateId' border='0' colspan='3'
						class='COLUMNHEADER'>
						<fmt:message key="Common.Document.label" bundle="${common_labels}" />
						<fmt:message key="Common.type.label" bundle="${common_labels}" />
					</td>
					<td nowrap id='thDateId' border='0' align='left' colspan='3'
						class='COLUMNHEADER'>
						<fmt:message key="Common.Document.label" bundle="${common_labels}" />
						<fmt:message key="eXI.no.Label" bundle="${xi_labels}" />
					</td>
				</tr>
				<%
				} else {
				%>
				<tr>
					<td nowrap class='COLUMNHEADER'>
						<fmt:message key="Common.Document.label" bundle="${common_labels}" />
						<fmt:message key="Common.type.label" bundle="${common_labels}" />
					</td>
					<td nowrap class='COLUMNHEADER'>
						<fmt:message key="Common.Document.label" bundle="${common_labels}" />
						<fmt:message key="eXI.no.Label" bundle="${xi_labels}" />
					</td>
					<td nowrap class='COLUMNHEADER'>
						<fmt:message key="eXI.Generated.Label" bundle="${xi_labels}" />
						<fmt:message key="Common.documenttype.label"
							bundle="${common_labels}" />
					</td>
					<td nowrap class='COLUMNHEADER'>
						<fmt:message key="eXI.Generated.Label" bundle="${xi_labels}" />
						<fmt:message key="Common.DocumentNumber.label"
							bundle="${common_labels}" />
					</td>					
					<td nowrap class='COLUMNHEADER'>
						<fmt:message key="eXI.GrnDate.Label" bundle="${xi_labels}" />
					</td>
				</tr>

				<%
							}

							pstmt = con.prepareStatement(sbQuery.toString());

							if (strOpt.equals("U")) {
						pstmt.setString(1, strFacilityId);
						pstmt.setString(2, strDateFrom);
						pstmt.setString(3, strDateTo);
						pstmt.setString(4, strFacilityId);
						span = "3";
							} else {
						pstmt.setString(1, strFacilityId);
						pstmt.setString(2, strDateFrom);
						pstmt.setString(3, strDateTo);
						span = "1";
							}

							rs = pstmt.executeQuery();

							if (rs != null) {
						if (start != 0) {
							for (int j = 1; j < start; i++, j++) {
								rs.next();
							}
						}

						if (rs != null) {
							while (rs.next() && i <= end) {

								if (strOpt.equals("U")) {
							strDocType = checkForNull(rs.getString(1));
							strDocNo = checkForNull(rs.getString(2));
							strStatus = "&nbsp";
							ibaDocNum = checkForNull(rs.getString(3),
									"&nbsp");
							ibaDocTypeCode = checkForNull(rs
									.getString(4), "&nbsp");
							processedById = "&nbsp";
							processedDate = "&nbsp";
								} else {
							strDocType = checkForNull(rs.getString(1));
							strDocNo = checkForNull(rs.getString(2));
							strStatus = checkForNull(rs.getString(3));
							ibaDocNum = checkForNull(rs.getString(4),
									"&nbsp");
							ibaDocTypeCode = checkForNull(rs
									.getString(5), "&nbsp");
							processedById = checkForNull(rs
									.getString(6), "&nbsp");
							processedDate = checkForNull(rs
									.getString(7), "&nbsp");
								}

								strDispLeg = strDocNo;

								if (strDocType.equals(strSelDocType)
								&& strDocNo.equals(strSelDocNo)) {
							strChecked = "checked";
							strValue = "Y";
								} else {
							strChecked = "";
							strValue = "N";
								}

								if (strStatus.equals("E"))
							strDispLeg = strDispLeg + "   E";
				%>

				<tr class='label'>
					<td nowrap class='label' align='center' colspan='<%=span%>'>
						<%=strDocType%>
					</td>
					<td colspan='<%=span%>'>
						<table border="0" cellpadding='3' cellspacing='0' width='100%'>
							<tr>
								<td width='50%' nowrap class='label' align='left'>
									<a href='#'
										OnClick="showDocDetails('<%=strDocType%>','<%=strDocNo%>')"><%=strDispLeg%>
									</a>
								</td>
								<%
								if (strStatus.equals("E")) {
								%>
								<td nowrap class='label' align='right'>
									<input id='Reprocess_<%=nIdx%>' class='button'
										value='<fmt:message key="eXI.reprocess.Label" bundle="${xi_labels}"/>'
										onClick="doProcess('<%=nIdx%>')" type='button' name='proc'
										id='proc'>
								<%
								}
								%>
								
								
								<td nowrap class='label' align='center'>
									&nbsp;
								</td>

							</tr>
						</table>
						<input type='hidden' name='doctype_<%=nIdx%>' id='doctype_<%=nIdx%>'
							value="<%=strDocType%>">
						<input type='hidden' name='docno_<%=nIdx%>' id='docno_<%=nIdx%>' value="<%=strDocNo%>">
					</td>

					<%
					if (strOpt.equals("P") || strOpt.equals("E")) {
					%>
					<td nowrap class='label' align='center'>
						<%=ibaDocTypeCode%>
					</td>
					<td nowrap class='label' align='center'>
						<%=ibaDocNum%>
					</td>					
					<td nowrap class='label' align='center'>
						<%=processedDate%>
					</td>
					<%
					}
					%>
				</tr>
				<%
								nIdx++;
								i++;
							}
				%>
			</table>
			<%
					}

					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
						}
					} else {
					System.out.println("ViewGRNSResult.jsp sbQuery 76:"	+ sbQuery.toString());
					System.out.println("ViewGRNSResult.jsp strFacilityId " + strFacilityId);
					System.out.println("ViewGRNSResult.jsp strDateFrom " + strDateFrom);
					System.out.println("ViewGRNSResult.jsp strDateTo "	+ strDateTo);
			%>
			<script>
			var errorMsg =  getMessage("XI1021","XI");		   
			parent.f_query_rst.location.href='../../eCommon/html/blank.html';
			parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+errorMsg;
			</script>
			<%
				}
				} catch (Exception e1) {
					e1.printStackTrace(System.err);
					System.out.println("Error in Result Page " + e1.getMessage());
					System.out.println("ViewGRNSResult.jsp sbQuery 76:"	+ sbQuery.toString());
					System.out.println("ViewGRNSResult.jsp strFacilityId " + strFacilityId);
					System.out.println("ViewGRNSResult.jsp strDateFrom "	+ strDateFrom);
					System.out.println("ViewGRNSResult.jsp strDateTo "	+ strDateTo);
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();

					if (con != null)
						ConnectionManager.returnConnection(con, request);
				}
			%>
			<input type=hidden name=from value='<%=start%>'>
			<input type=hidden name=to value='<%=end%>'>
			<input type=hidden name=opt value='<%=strOpt%>'>
			<input type=hidden name=dt_from value='<%=strDateFrom%>'>
			<input type=hidden name=dt_to value='<%=strDateTo%>'>
			<input type=hidden name='start' id='start' value='<%=start%>'>
			<input type=hidden name='end' id='end' value='<%=end%>'>
			<input type=hidden name='maxidx' id='maxidx' value='<%=nIdx%>'>
			<input type=hidden name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>
			<input type=hidden name='selDoc' id='selDoc' value='<%=strSelDoc%>'>

		</form>
	</body>
</html>

<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue) {
		return (inputString == null) ? defaultValue : inputString;
	}%>

