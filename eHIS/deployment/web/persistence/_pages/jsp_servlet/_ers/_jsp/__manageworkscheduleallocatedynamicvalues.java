package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;

public final class __manageworkscheduleallocatedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleAllocateDynamicValues.jsp", 1709121636184L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\tparent.ManageWorkScheduleAllocate_frames.document.getElementById(\"productive\").innerText=\"\"+\"    \"+\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"+\"      \"+\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\tparent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.mnemonic.value = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\tparent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.shift_start_time.value = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\tparent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.shift_end_time.value = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\tparent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.shift_indicator.value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tparent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.productive_flag.value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
//String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);


Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String shift_val = request.getParameter("shift_val");
String p_schedule_date = request.getParameter("p_schedule_date");
try
{
	con = ConnectionManager.getConnection(request);
	String sql = "select PRODUCTIVE_FLAG,SHIFT_INDICATOR, decode(SHIFT_INDICATOR,'P','Productive','U','Unproductive')SHIFT_IND,decode(PRODUCTIVE_FLAG,'W','Working','O','Oncall') PROD_FLAG,mnemonic_key mnemonic,?||to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_time from am_shift where shift_code=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,p_schedule_date);
	pstmt.setString(2,p_schedule_date);
	pstmt.setString(3,shift_val);
	rs = pstmt.executeQuery();
	String shift_indicator = "";
	String productive_flag = "";
	String shift_ind = "";
	String prod_flag = "";
	String mnemonic = "";
	String shift_start_time = "";
	String shift_end_time = "";
	if(rs!=null){
		if(rs.next()){
			shift_indicator = rs.getString("SHIFT_IND");
			productive_flag = rs.getString("PROD_FLAG")==null?"":rs.getString("PROD_FLAG");
			mnemonic = rs.getString("mnemonic");
			shift_ind = rs.getString("SHIFT_INDICATOR");
			prod_flag = rs.getString("PRODUCTIVE_FLAG");
			shift_start_time = rs.getString("shift_start_time");
			shift_end_time = rs.getString("shift_end_time");
		}
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(shift_indicator));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(mnemonic));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(shift_start_time));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(shift_end_time));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(shift_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(prod_flag));
            _bw.write(_wl_block10Bytes, _wl_block10);

}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	try
	{
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	ConnectionManager.returnConnection(con,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
}

            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
