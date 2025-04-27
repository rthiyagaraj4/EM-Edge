
<%@page import="java.sql.Date,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eBL.Common.BlRepository"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.PkgSubsBean,eBL.PkgEnterReceptRefundBean,eCommon.Common.*,webbeans.eCommon.*"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>



<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />



<%
	String locale = (String) session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue("facility_id");
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();
	String calledFrom = request.getParameter("calledFrom");

	CallableStatement cstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		if (calledFrom.equals("AssociateSubscribedPackage")) {
			String functionId = request.getParameter("function_id");
			System.out.println("functionId " + functionId);
			String packageCode = request.getParameter("packageCode");
			String fromDate = request.getParameter("fromDate");
			String pkgPrice = "";
			String pkgvaliddays = "";
			String pkgpricefactor = "";
			String custdiscountind = "";
			String custdiscountamt = "";
			String strErrorLevel = "";
			String strErrorText = "";
			String strMessageId = "";
			String effToDate = "";

			cstmt = con
					.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI:SS'),?,?,?,?,?,?,?,?,?)}");  //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
			cstmt.setString(1, facilityId);
			cstmt.setString(2, packageCode);
			cstmt.setString(3, "");
			cstmt.setString(4, "");
			cstmt.setString(5, "");
			cstmt.setString(6, fromDate);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(15, java.sql.Types.VARCHAR); //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
			cstmt.execute();
			pkgPrice = cstmt.getString(7);
			pkgvaliddays = cstmt.getString(8);
			pkgpricefactor = cstmt.getString(9);
			custdiscountind = cstmt.getString(10);
			custdiscountamt = cstmt.getString(11);
			strErrorLevel = cstmt.getString(12);
			strMessageId = cstmt.getString(13);
			strErrorText = cstmt.getString(14);

			if (pkgPrice == null)
				pkgPrice = "0.00";
			if (pkgvaliddays == null)
				pkgvaliddays = "0";
			if (pkgpricefactor == null)
				pkgpricefactor = "1";
			if (custdiscountind == null)
				custdiscountind = "N";
			if (custdiscountamt == null)
				custdiscountamt = "0.00";

			if (strErrorLevel == null)
				strErrorLevel = "";
			if (strMessageId == null)
				strMessageId = "";
			if (strErrorText == null)
				strErrorText = "";

			JsonObject ob = new JsonObject();

			if (!(strMessageId.equals(""))
					|| !(strErrorLevel.equals(""))
					|| !(strErrorText.equals(""))) {
				System.out.println("if");
				ob.addProperty("success", "N");
				ob.addProperty("messageId", strMessageId);
				ob.addProperty("messageText", strErrorText);
				ob.addProperty("messageLevel", strErrorLevel);

			}

			else {
				System.out.println("else");
				ob.addProperty("success", "Y");
			}

			System.out.println("message Id / message / level "
					+ strMessageId + "/" + strErrorText + "/"
					+ strErrorLevel);

			String sql = "";

			System.out.println("fromDate " + fromDate.length());
			if (fromDate.length() > 16) {
				sql = "SELECT to_char(to_date(?,'dd/mm/yyyy HH24:MI:SS')+ ? - 1/86400,'dd/mm/yyyy HH24:MI:SS') toDate FROM DUAL";
			} else {
				sql = "SELECT to_char(to_date(?,'dd/mm/yyyy HH24:MI')+ ? - 1/86400,'dd/mm/yyyy HH24:MI') toDate FROM DUAL";
			}

			System.out.println("sql " + sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fromDate);
			pstmt.setInt(2, Integer.parseInt(pkgvaliddays));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				effToDate = rs.getString("toDate");

			}
			if (effToDate == null)
				effToDate = "";

			System.out.println("effto date" + effToDate);

			ob.addProperty("toDate", effToDate);
			out.println(ob);

		}

		//Added By Vijay For MMS-ICN-00015

		else if ("patientPayerValidation".equals(calledFrom)) {
			try {

				String outPutNewPkg = "";
				String outPutExPkg = "";
				String outputNewPkgTemp="";
				String outputExPkgTemp="";
				
				
				
				String payerCode = request.getParameter("payerCode");
				if (payerCode == null || "null".equals(payerCode)) payerCode = "";
				System.err.println("payerCode " + payerCode);
				
				String payerGrpCode = request.getParameter("payerGrpCode");
				if (payerGrpCode == null || "null".equals(payerGrpCode)) payerGrpCode = "";
				System.err.println("payerGrpCode " + payerGrpCode);
				
				String payerGrpCodeExistingPkg = request.getParameter("payerGrpCodeExistingPkg");
				if (payerGrpCodeExistingPkg == null || "null".equals(payerGrpCodeExistingPkg)) payerGrpCodeExistingPkg = "";
				
				System.err.println("payerGrpCodeExistingPkg "+ payerGrpCodeExistingPkg);
				
				String payerCodeExistingPkg = request.getParameter("payerCodeExistingPkg");
				if (payerCodeExistingPkg == null || "null".equals(payerCodeExistingPkg)) payerCodeExistingPkg = "";
				
				System.err.println("payerCodeExistingPkg "+payerCodeExistingPkg);
				
				String episodeId = request.getParameter("episodeId");
				System.err.println("episodeId " + episodeId);
				
				String visitId = request.getParameter("visitId");
				System.err.println("visitId " + visitId);
				
				JSONObject ob = new JSONObject();

				String sql = "SELECT 'Y' flag FROM bl_encounter_payer_priority WHERE operating_facility_id=? AND ((episode_type IN ('O','E') AND episode_id = ? AND visit_id = ?) OR (episode_type IN ('I','D') AND episode_id = ?)) "
						+ " AND cust_group_code = ? "
						+ " AND cust_code = ? "
						+ " AND cust_group_code IS NOT NULL "
						+ " AND cust_code IS NOT NULL "
						+ " AND ROWNUM = 1 ORDER BY policy_type_code, priority ";
				System.err.println("sql " + sql);

				String[] payerGrpSplit = payerGrpCode.split(",");
				String[] payerCodeSplit = payerCode.split(",");

				String[] payerGrpCodeExistingPkgSplit = payerGrpCodeExistingPkg
						.split(",");
				String[] payerCodeExistingPkgSplit = payerCodeExistingPkg
						.split(",");
				pstmt = con.prepareStatement(sql);

				if (payerGrpCode.length() > 1) {

					System.out.println("new Pkgs");
					pstmt.setString(1, facilityId);
					pstmt.setString(2, episodeId);
					pstmt.setString(3, visitId);
					pstmt.setString(4, episodeId);
					for (int i = 0; i < payerGrpSplit.length; i++) {
						pstmt.setString(5, payerGrpSplit[i]);//payerGrpSplit[i]);
							System.err.println("payerGrpSplit[i] "+payerGrpSplit[i]);
						if (payerCodeSplit.length > 0) {
							pstmt.setString(6, payerCodeSplit[i]);
							System.err.println("payerCodeSplit[i] "+payerCodeSplit[i]);
						} else {
							pstmt.setString(6, "");
						}

						rs = pstmt.executeQuery();
						if(rs!=null){
							outPutNewPkg+="N";
							
						while (rs.next()) {

							outPutNewPkg = rs.getString("flag");
							/* outPutNewPkg+=outPutNewPkg; */
							System.out.println("outPutNewPkg in loop "
							+ outPutNewPkg);


							outputNewPkgTemp+=outPutNewPkg;
							

							

						}
					
						outputNewPkgTemp+=outPutNewPkg;
						
						
						}
						
						System.err.println("outputNewPkgTemp outside rs "+outputNewPkgTemp);
						if (outputNewPkgTemp.contains("N")) {
							outPutNewPkg="N";
							break;
						}
						

					}
				}
				if (payerGrpCodeExistingPkg.length() > 0) {
					System.err.println("existing pkgs ");
					pstmt.setString(1, facilityId);
					pstmt.setString(2, episodeId);
					pstmt.setString(3, visitId);
					pstmt.setString(4, episodeId);

					for (int i = 0; i < payerGrpCodeExistingPkgSplit.length; i++) {
						pstmt.setString(5,
								payerGrpCodeExistingPkgSplit[i]);//payerGrpSplit[i]);
						System.out.println("payerGrpCodeExistingPkgSplit[i] "+payerGrpCodeExistingPkgSplit[i]);
						if (payerCodeExistingPkgSplit.length > 0) {
							pstmt.setString(6,
									payerCodeExistingPkgSplit[i]);
							System.out.println("payerCodeExistingPkgSplit[i] "+payerCodeExistingPkgSplit[i]);

						} else {
							pstmt.setString(6, "");

						}
						rs = pstmt.executeQuery();
						if(rs!=null){
							outPutExPkg="N";
						while (rs.next()) {
							outPutExPkg = rs.getString("flag");
							outputExPkgTemp+=outPutExPkg;
							System.out.println("outPutExPkg " + outPutExPkg);
							System.out.println("outputExPkgTemp " + outputExPkgTemp);
								
						
						}
						
						outputExPkgTemp+=outPutExPkg;
						}
										
					System.out.println("outputExPkgTemp "+outputExPkgTemp);
					if (outputExPkgTemp.contains("N")) {
						outPutExPkg="N";
						break;
					}
						
					}
				}
				System.out.println("outPutExPkg final "+outPutExPkg);
				System.out.println("outPutNewPkg final "+outPutNewPkg);

				if (outPutNewPkg.equals("N") || outPutExPkg.equals("N")) {
					ob.put("flag", "N");
				} else {
					ob.put("flag", "Y");
				}
				out.print(ob);
				out.flush();

			} catch (Exception e) {

				e.printStackTrace();
				System.err
						.println("Exception in BLPkgAscteValidation(patientPayerValidation) "
								+ e);

			}

		}

		// -- Ends Here --

	} catch (Exception e) {
		System.err.println("Exception in BLPkgAscteValidation " + e);
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}
%>
