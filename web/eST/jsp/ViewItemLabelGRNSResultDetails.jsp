<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    			Name				Rev. Date		Rev. By			Description
----------------------------------------------------------------------------------------------------------------------------------

02/08/2017		MMS-DM-CRF-099.2			Shazana hasan		02/08/2017				Chandra				Newly Added ViewItemLabelGRNSResultDetails.jsp for MMS-DM-CRF-099.2
------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>


<%@page
	import="java.util.*,eST.*,eST.Common.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
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
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>		
		<script language='javascript' src='../../eST/js/ViewItemLabelGRNS.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
		<form name='ViewGRNsResultFrom' id='ViewGRNsResultFrom' action="ViewItemLabelGRNSResultDetails.jsp" method='post' target='messageFrame'>
			<%
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;	  
				String strFacilityId = "", strOpt = "P" , strStoreCode = "";
				String strDateFrom = "", strDateTo = "";
				String strDocType = "", strDocNo = "";
				String from = "", to = "";
				String strStatus = "", strDispLeg = "";
				String strSelDocType = "", strSelDocNo = "";
				String strSelDoc = "", strChecked = "";
				String strValue = "N";
				String span = "1";
				String ibaDocNum = "", ibaDocTypeCode = "", processedById = "", processedDate = "", suppCode="";
				String strSupplierCode="";
				String classvalue			=		"";
				
				int maxRecord = 0;
				int start = 0;
				int end = 0;
				int i = 1;
				int nIdx = 0;																	   
				StringBuffer sbQuery = new StringBuffer();	   
				strFacilityId = (String) session.getValue("facility_id");
				strDateFrom = CommonBean.checkForNull(request.getParameter("dt_from"));
				//strDateFrom = checkForNull(request.getParameter("dt_from"));
				strDateTo = checkForNull(request.getParameter("dt_to"));
				from = checkForNull(request.getParameter("from"), "1");
				to = checkForNull(request.getParameter("to"), "8");
				
				strStoreCode = checkForNull(request.getParameter("store_code"));
				strSupplierCode=checkForNull(request.getParameter("supp_code"));
				
				 
				//strSelDoc = checkForNull(request.getParameter("selDoc"));
				start = Integer.parseInt(from);
				end = Integer.parseInt(to);	
				System.out.println("---------------------------------------------------->");
				System.out.println("----------------------------------strDateFrom------------------>"+strDateFrom);
				System.out.println("-----------------------------------strDateTo----------------->"+strDateTo);
				System.out.println("-----------------------------------strStoreCode----------------->"+strStoreCode);
				System.out.println("-----------------------------------strSupplierCode----------------->"+strSupplierCode);
				
				
				try {
					/*if (!strSelDoc.equals("")) {
						StringTokenizer stTemp = new StringTokenizer(strSelDoc,
						"~~");

						if (stTemp.hasMoreTokens())
					strSelDocType = stTemp.nextToken();

						if (stTemp.hasMoreTokens())
					strSelDocNo = stTemp.nextToken();
					}	*/								  
					con = ConnectionManager.getConnection(request);
					
					sbQuery.append("SELECT DISTINCT DOC_TYPE_CODE,DOC_NO,TRANS_STATUS,IBA_DOC_NUM, IBA_DOC_TYPE_CODE, PROCESSED_BY_ID, to_char(GRN_DATE,'dd/mm/yyyy'),SUPP_CODE FROM XI_TRN_GRN WHERE FACILITY_ID = ? AND TRANS_STATUS='P' AND STORE_CODE = NVL(?,  STORE_CODE)  AND GRN_DATE BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'dd/mm/yyyy')  AND TO_DATE(?,'DD/MM/YYYY')+0.9999 AND  SUPP_CODE = NVL(?,  SUPP_CODE)  ORDER BY DOC_TYPE_CODE,doc_no ");
					
					pstmt = con.prepareStatement(sbQuery.toString());

				
						pstmt.setString(1, strFacilityId);
						pstmt.setString(2, strStoreCode);
						pstmt.setString(3, strDateFrom);
						pstmt.setString(4, strDateTo);
						pstmt.setString(5, strSupplierCode);
					
					rs = pstmt.executeQuery();

		
					
					if (rs != null) {
						while (rs.next())
					maxRecord++;
					}
					System.out.println("------------------------------maxRecord---------------------->"+maxRecord);
					
					if(maxRecord ==0){
						%>
							<script>
								alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
							</script>
						<%		
					}	
					
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception ee) {
					System.out.println("Exception in ViewItemLabelGRNSResultDetails.jsp 111=" + ee);
					ee.printStackTrace();
				}

				try {
					if (maxRecord > 0) {
			%>
			<table border="1" cellpadding='0' cellspacing='0' id='tableId'
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
					
					<td nowrap class='COLUMNHEADER'>
						<fmt:message key="Common.Supplier.label" bundle="${xi_labels}" />
					</td>
					
				</tr>

				<%
				}

				pstmt = con.prepareStatement(sbQuery.toString());

				if (strOpt.equals("U")) {
					pstmt.setString(1, strFacilityId);
					pstmt.setString(2, strStoreCode);
					pstmt.setString(3, strDateFrom);
					pstmt.setString(4, strDateTo);
					pstmt.setString(5, strSupplierCode);
					span = "3";
				} else {
					pstmt.setString(1, strFacilityId);
					pstmt.setString(2, strStoreCode);
					pstmt.setString(3, strDateFrom);
					pstmt.setString(4, strDateTo);
					pstmt.setString(5, strSupplierCode);
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
					if (maxRecord % 2 == 0)
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
					while (rs.next() && i <= end) {

					if (strOpt.equals("U")) {
						strDocType = checkForNull(rs.getString(1));
						strDocNo = checkForNull(rs.getString(2));
						strStatus = "&nbsp";
						ibaDocNum = checkForNull(rs.getString(3),"&nbsp");
						ibaDocTypeCode = checkForNull(rs.getString(4), "&nbsp");
						processedById = "&nbsp";
						processedDate = "&nbsp";
					} else {
						strDocType = checkForNull(rs.getString(1));
						strDocNo = checkForNull(rs.getString(2));
						strStatus = checkForNull(rs.getString(3));
						ibaDocNum = checkForNull(rs.getString(4),"&nbsp");
						ibaDocTypeCode = checkForNull(rs.getString(5), "&nbsp");
						processedById = checkForNull(rs.getString(6), "&nbsp");
						processedDate = checkForNull(rs.getString(7), "&nbsp");
						suppCode= checkForNull(rs.getString(8), "&nbsp");
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
					<td class="<%=classvalue%>">
						<%=strDocType%>
					</td>
					 <td class="<%=classvalue%>" >
						<table border="0" cellpadding='3' cellspacing='0' width='100%'>
							<tr>
								<td >
									<%=strDispLeg%>									
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
								
								
								<!--  <td nowrap class='label' align='center'>
									&nbsp;
								</td>-->

							</tr>
						</table>
						<input type='hidden' name='doctype_<%=nIdx%>' id='doctype_<%=nIdx%>'
							value="<%=strDocType%>">
						<input type='hidden' name='docno_<%=nIdx%>' id='docno_<%=nIdx%>' value="<%=strDocNo%>">
					</td>

					<%
					if (strOpt.equals("P") || strOpt.equals("E")) {
					%>
					<td class="<%=classvalue%>">
						<%=ibaDocTypeCode%>
					</td>
					<td class="<%=classvalue%>">						
						<a href='#'	OnClick="showDocDetails('<%=ibaDocNum%>','<%=ibaDocTypeCode%>')"><%=ibaDocNum%></a>
					</td>
					<%
					System.out.println("ViewItemLabelGRNSResultDetails.jsp Doc Number " + ibaDocNum);
					%>					
					<td class="<%=classvalue%>">
						<%=processedDate%>
					</td>
					
					<td class="<%=classvalue%>">
						<%=suppCode%>
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
					System.out.println("ViewItemLabelGRNSResultDetails.jsp sbQuery 76:"	+ sbQuery.toString());
					
					System.out.println("ViewItemLabelGRNSResultDetails.jsp strFacilityId " + strFacilityId);
					System.out.println("ViewItemLabelGRNSResultDetails.jsp strDateFrom " + strDateFrom);
					System.out.println("ViewItemLabelGRNSResultDetails.jsp strDateTo "	+ strDateTo);
			%>
			<!-- <script>
			var errorMsg =  getMessage("XI1021","XI");		   
			//parent.f_query_rst.location.href='../../eCommon/html/blank.html';
			parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+errorMsg;
			</script> -->
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

