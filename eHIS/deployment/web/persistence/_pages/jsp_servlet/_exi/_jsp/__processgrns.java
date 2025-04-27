package jsp_servlet._exi._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __processgrns extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/exi/jsp/ProcessGRNs.jsp", 1709117599283L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\nvar opt = \'\'; var dt_from = \'\'; var dt_to = \'\'; var strSelDoc = \'\'; var\nstart = \'\'; var end = \'\'; var from = \'\'; var to = \'\'; if\n(parent.f_query_rst.ViewGRNsResultFrm.opt) opt =\nparent.f_query_rst.ViewGRNsResultFrm.opt.value; if (opt!=\'U\') { dt_from\n= parent.f_query_rst.ViewGRNsResultFrm.dt_from.value; dt_to =\nparent.f_query_rst.ViewGRNsResultFrm.dt_to.value; } if\n(parent.f_query_rst.ViewGRNsResultFrm.from) from =\nparent.f_query_rst.ViewGRNsResultFrm.from.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.to) to =\nparent.f_query_rst.ViewGRNsResultFrm.to.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.strSelDoc) strSelDoc =\nparent.f_query_rst.ViewGRNsResultFrm.strSelDoc.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.start) start =\nparent.f_query_rst.ViewGRNsResultFrm.start.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.end) end =\nparent.f_query_rst.ViewGRNsResultFrm.end.value; var qryString =\n\"dt_from=\"+dt_from+\"&opt=\"+opt+\"&dt_to=\"+dt_to+\"&from=\"+from+\"&to=\"+to+\"&strSelDoc=\"+strSelDoc;\n\nvar errorMsg = getMessage(\'XI1001\',\'XI\');\nparent.messageFrame.location.href =\n\'../../eCommon/jsp/error.jsp?err_num=\'+errorMsg;\nparent.f_query_rst.location.href=\"../../eXI/jsp/ViewGRNSResult.jsp?\"+qryString;\nparent.f_query_rst_dtl.location.href=\"../../eCommon/html/blank.html\";\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\nvar opt = \'\'; var dt_from = \'\'; var dt_to = \'\'; var strSelDoc = \'\'; var\nstart = \'\'; var end = \'\'; var from = \'\'; var to = \'\'; if\n(parent.f_query_rst.ViewGRNsResultFrm.opt) opt =\nparent.f_query_rst.ViewGRNsResultFrm.opt.value; if (opt!=\'U\') { dt_from\n= parent.f_query_rst.ViewGRNsResultFrm.dt_from.value; dt_to =\nparent.f_query_rst.ViewGRNsResultFrm.dt_to.value; } if\n(parent.f_query_rst.ViewGRNsResultFrm.from) from =\nparent.f_query_rst.ViewGRNsResultFrm.from.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.to) to =\nparent.f_query_rst.ViewGRNsResultFrm.to.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.strSelDoc) strSelDoc =\nparent.f_query_rst.ViewGRNsResultFrm.strSelDoc.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.start) start =\nparent.f_query_rst.ViewGRNsResultFrm.start.value; if\n(parent.f_query_rst.ViewGRNsResultFrm.end) end =\nparent.f_query_rst.ViewGRNsResultFrm.end.value; var qryString =\n\"dt_from=\"+dt_from+\"&opt=\"+opt+\"&dt_to=\"+dt_to+\"&from=\"+from+\"&to=\"+to+\"&strSelDoc=\"+strSelDoc;\n\nparent.messageFrame.location.href =\n\'../../eCommon/jsp/error.jsp?err_num=\'+\'\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\';\nparent.f_query_rst.location.href=\"../../eXI/jsp/ViewGRNSResult.jsp?\"+qryString;\nparent.f_query_rst_dtl.location.href=\"../../eCommon/html/blank.html\";\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/javascript");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/javascript");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

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

            _bw.write(_wl_block2Bytes, _wl_block2);

} else {

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(strErrText));
            _bw.write(_wl_block4Bytes, _wl_block4);

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

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
