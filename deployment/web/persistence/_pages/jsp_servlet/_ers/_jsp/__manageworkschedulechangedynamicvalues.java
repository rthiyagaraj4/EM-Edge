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
import java.util.*;
import com.ehis.util.*;

public final class __manageworkschedulechangedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleChangeDynamicValues.jsp", 1709121637277L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!-- ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\n\t\n\tparent.ManageWorkScheduleChange_frame.document.getElementById(\"productive\").innerText=\"\"+\"    \"+\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"+\"      \"+\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tparent.ManageWorkScheduleChange_frame.document.ChangeShift.new_mnemonic.value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tparent.ManageWorkScheduleChange_frame.document.ChangeShift.new_shift_start_time.value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\tparent.ManageWorkScheduleChange_frame.document.ChangeShift.new_shift_end_time.value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\tparent.ManageWorkScheduleChange_frame.document.ChangeShift.new_shift_indicator.value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\tparent.ManageWorkScheduleChange_frame.document.ChangeShift.new_productive_flag.value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\n</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String shift_val = request.getParameter("shift_val");
	String p_schedule_date = request.getParameter("p_schedule_date");

	try{
		con = ConnectionManager.getConnection(request);
		//String sql = "select decode(SHIFT_INDICATOR,'P','Productive','U','Unproductive') SHIFT_INDICATOR,decode(PRODUCTIVE_FLAG,'W','Working','O','Oncall') PRODUCTIVE_FLAG,mnemonic_key new_mnemonic,?||to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_time from am_shift where shift_code=?";
		String sql = "select decode(SHIFT_INDICATOR,'P','Productive','U','Unproductive') SHIFT_INDICATOR,decode(PRODUCTIVE_FLAG,'W','Working','O','Oncall') PRODUCTIVE_FLAG,mnemonic_key new_mnemonic,?||to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_time from am_shift where shift_code=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,p_schedule_date);
		pstmt.setString(2,p_schedule_date);
		pstmt.setString(3,shift_val);
		rs = pstmt.executeQuery();
		String new_shift_indicator = "";
		String new_productive_flag = "";
		String new_mnemonic="";
		String new_shift_start_time="";
		String new_shift_end_time="";
		String new_shft_indicator_chng="";
		String new_shft_product_flag_chng="";

		if(rs!=null){
			if(rs.next()){
				new_shift_indicator = rs.getString("SHIFT_INDICATOR")==null?"":rs.getString("SHIFT_INDICATOR");
				new_productive_flag = rs.getString("PRODUCTIVE_FLAG")==null?"":rs.getString("PRODUCTIVE_FLAG");
				new_mnemonic = rs.getString("new_mnemonic");
				new_shift_start_time = rs.getString("shift_start_time");
				new_shift_end_time = rs.getString("shift_end_time");
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();

			if(new_shift_indicator.equalsIgnoreCase("Productive")){
				new_shft_indicator_chng="P";
			}
			else if(new_shift_indicator.equalsIgnoreCase("Unproductive")){
				new_shft_indicator_chng="U";
			}

			if(new_productive_flag.equalsIgnoreCase("Working")){
				new_shft_product_flag_chng="W";
			}
			else if(new_productive_flag.equalsIgnoreCase("Oncall")){
				new_shft_product_flag_chng="O";
			}
		}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(new_shift_indicator));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(new_productive_flag));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(new_mnemonic));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(new_shift_start_time));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(new_shift_end_time));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(new_shft_indicator_chng));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(new_shft_product_flag_chng));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	catch (Exception e){
		out.println(e.toString());
	}
	finally{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
