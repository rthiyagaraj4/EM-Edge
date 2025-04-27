<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*"
	contentType="text/javascript"%>
<%
	Connection con = null;
	CallableStatement cstmt = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String strDocType = "", strDocNo = "";
	String strFacilityId = "", strErrText = "";
	String strDtFrom = "", strDtUpto = "";
	String strSelOpt = "";
	//java.sql.Date   sys_date	=	null;
	String user_name = (String) session.getValue("login_user");

	strDocType = checkForNull(request.getParameter("doc_type"));
	strDocNo = checkForNull(request.getParameter("doc_no"));
	strDtFrom = checkForNull(request.getParameter("dtfrom"));
	strDtUpto = checkForNull(request.getParameter("dtUpto"));
	strSelOpt = checkForNull(request.getParameter("selopt"));
	strFacilityId = checkForNull((String) session
			.getValue("facility_id"));

	try {
		con = ConnectionManager.getConnection(request);

		cstmt = con
		.prepareCall("{call STGRN_MAIN.CALL_MAIN(?,?,?,?,?)}");
		cstmt.setString(1, strFacilityId);
		cstmt.setString(2, strDocType);
		cstmt.setString(3, strDocNo);
		cstmt.setString(4, "N");
		cstmt.registerOutParameter(5, Types.VARCHAR);
		cstmt.execute();
		con.commit();

		stmt = con.createStatement();

		String sql_query = "SELECT PROCESS_TEXT FROM ST_PROCESS_STATUS WHERE DOC_TYPE_CODE='"
		+ strDocType
		+ "' and DOC_NO="
		+ strDocNo
		+ " and  FACILITY_ID='"
		+ strFacilityId
		+ "' AND ROWNUM = 1 AND PROCESS_TEXT IS NOT NULL ORDER BY FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO, STORE_CODE, ITEM_CODE, BATCH_ID, EXPIRY_DATE";
		rs = stmt.executeQuery(sql_query);

		if (rs != null) {
			if (rs.next()) {
		strErrText = rs.getString(1);
			} else
		strErrText = "";
		} else
			strErrText = "";

		if (strErrText.equals("")) {

			pstmt = con
			.prepareStatement("update XI_TRN_GRN set PROCESSED_BY_ID = ?, PROCESSED_DATE = to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss') where DOC_NO = ? and  DOC_TYPE_CODE = ?");
			pstmt.setString(1, user_name);
			pstmt.setString(2, strDocNo);
			pstmt.setString(3, strDocType);
			int updated = pstmt.executeUpdate();
			con.commit();
			if (updated > 0) {
			} else {
			}
%>
var opt = ''; var dt_from = ''; var dt_to = ''; var strSelDoc = ''; var
start = ''; var end = ''; var from = ''; var to = ''; if
(parent.f_query_rst.ViewGRNsResultFrm.opt) opt =
parent.f_query_rst.ViewGRNsResultFrm.opt.value; if (opt!='U') { dt_from
= parent.f_query_rst.ViewGRNsResultFrm.dt_from.value; dt_to =
parent.f_query_rst.ViewGRNsResultFrm.dt_to.value; } if
(parent.f_query_rst.ViewGRNsResultFrm.from) from =
parent.f_query_rst.ViewGRNsResultFrm.from.value; if
(parent.f_query_rst.ViewGRNsResultFrm.to) to =
parent.f_query_rst.ViewGRNsResultFrm.to.value; if
(parent.f_query_rst.ViewGRNsResultFrm.strSelDoc) strSelDoc =
parent.f_query_rst.ViewGRNsResultFrm.strSelDoc.value; if
(parent.f_query_rst.ViewGRNsResultFrm.start) start =
parent.f_query_rst.ViewGRNsResultFrm.start.value; if
(parent.f_query_rst.ViewGRNsResultFrm.end) end =
parent.f_query_rst.ViewGRNsResultFrm.end.value; var qryString =
"dt_from="+dt_from+"&opt="+opt+"&dt_to="+dt_to+"&from="+from+"&to="+to+"&strSelDoc="+strSelDoc;

var errorMsg = getMessage('XI1001','XI');
parent.messageFrame.location.href =
'../../eCommon/jsp/error.jsp?err_num='+errorMsg;
parent.f_query_rst.location.href="../../eXI/jsp/ViewGRNSResult.jsp?"+qryString;
parent.f_query_rst_dtl.location.href="../../eCommon/html/blank.html";

<%
} else {
%>

var opt = ''; var dt_from = ''; var dt_to = ''; var strSelDoc = ''; var
start = ''; var end = ''; var from = ''; var to = ''; if
(parent.f_query_rst.ViewGRNsResultFrm.opt) opt =
parent.f_query_rst.ViewGRNsResultFrm.opt.value; if (opt!='U') { dt_from
= parent.f_query_rst.ViewGRNsResultFrm.dt_from.value; dt_to =
parent.f_query_rst.ViewGRNsResultFrm.dt_to.value; } if
(parent.f_query_rst.ViewGRNsResultFrm.from) from =
parent.f_query_rst.ViewGRNsResultFrm.from.value; if
(parent.f_query_rst.ViewGRNsResultFrm.to) to =
parent.f_query_rst.ViewGRNsResultFrm.to.value; if
(parent.f_query_rst.ViewGRNsResultFrm.strSelDoc) strSelDoc =
parent.f_query_rst.ViewGRNsResultFrm.strSelDoc.value; if
(parent.f_query_rst.ViewGRNsResultFrm.start) start =
parent.f_query_rst.ViewGRNsResultFrm.start.value; if
(parent.f_query_rst.ViewGRNsResultFrm.end) end =
parent.f_query_rst.ViewGRNsResultFrm.end.value; var qryString =
"dt_from="+dt_from+"&opt="+opt+"&dt_to="+dt_to+"&from="+from+"&to="+to+"&strSelDoc="+strSelDoc;

parent.messageFrame.location.href =
'../../eCommon/jsp/error.jsp?err_num='+'
<%=strErrText%>
';
parent.f_query_rst.location.href="../../eXI/jsp/ViewGRNSResult.jsp?"+qryString;
parent.f_query_rst_dtl.location.href="../../eCommon/html/blank.html";

<%
	}
	} catch (Exception e1) {
		System.out.println(" Error from Process View GRN : "
		+ e1.getMessage());
		e1.printStackTrace(System.err);
	} finally {
		if (cstmt != null)
			cstmt.close();
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
%>
<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}%>
