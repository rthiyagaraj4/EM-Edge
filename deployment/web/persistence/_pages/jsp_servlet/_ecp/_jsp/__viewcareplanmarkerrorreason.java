package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __viewcareplanmarkerrorreason extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanMarkErrorReason.jsp", 1709116630324L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<title>View Mark Evaluation Error</title>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script>\n<script src=\"../../eCP/js/ViewCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\"view_cp_mrk_err_rsn_form\" id=\"view_cp_mrk_err_rsn_form\" method=\"post\" target=\"blanFrame\" action=\"\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t\t<td align=\'left\' class=\'label\'><B>Error Remarks</B><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t</tr>\n\t<tr>\n\t\t<td align=\'right\'>&nbsp;&nbsp;<TEXTAREA NAME=\"mrk_reason\" ROWS=\"10\" COLS=\"50\" readOnly>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</TEXTAREA>&nbsp;&nbsp;</td>\n\t</tr>\n\n\t<tr>\n\t\t<td align=\"right\"><INPUT TYPE=\"button\" value=\"Close\" class=\"button\" onclick=\"window.close();\">\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td align=\'left\' class=\'label\'>&nbsp;</td>\n\t</tr>\n</table>\n<INPUT TYPE=\"hidden\" name=\"md_plan_id\" id=\"md_plan_id\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n<INPUT TYPE=\"hidden\" name=\"care_plan_id\" id=\"care_plan_id\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n<INPUT TYPE=\"hidden\" name=\"eval_id\" id=\"eval_id\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n</form>\n</body>\n</head>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String md_plan_id = request.getParameter("md_plan_id");
String care_plan_id = request.getParameter("care_plan_id");
String eval_id = request.getParameter("eval_id");
String error_remarks = request.getParameter("error_remarks");

Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String sql = "select status_remarks from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and eval_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,md_plan_id);
		pstmt.setString(2,care_plan_id);
		pstmt.setString(3,eval_id);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				error_remarks = rs.getString("status_remarks")==null?"":rs.getString("status_remarks");
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch (Exception e)
	{
		e.printStackTrace(System.err);
		System.out.println("Exception in ViewCarePlanMarkErrorReason.jsp="+e.toString());
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(error_remarks));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(md_plan_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(care_plan_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(eval_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
