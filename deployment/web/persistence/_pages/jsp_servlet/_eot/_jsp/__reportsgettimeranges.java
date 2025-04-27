package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import java.util.*;

public final class __reportsgettimeranges extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ReportsGetTimeRanges.jsp", 1709117280000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String time_range_code = request.getParameter("time_range_code");
	StringBuffer append_str = new StringBuffer();
	append_str.append("::");
	String slot_1 = "";
	String slot_2 = "";
	String slot_3 = "";
	String slot_4 = "";
	String slot_5 = "";
	String slot_6 = "";
	String slot_7 = "";
	String slot_8 = "";
	String slot_9 = "";
	String slot_10 = "";
	String sql = "";
	try{
		connection = ConnectionManager.getConnection(request);
// GET THE TIME RANGES
		sql="SELECT TO_CHAR(TIME_1_SLOT,'HH24:MI') AS SLOT_1, TO_CHAR(TIME_2_SLOT,'HH24:MI') AS SLOT_2, 	TO_CHAR(TIME_3_SLOT,'HH24:MI') AS SLOT_3, TO_CHAR(TIME_4_SLOT,'HH24:MI') AS SLOT_4, TO_CHAR(TIME_5_SLOT,'HH24:MI') AS SLOT_5, TO_CHAR(TIME_6_SLOT,'HH24:MI') AS SLOT_6, TO_CHAR(TIME_7_SLOT,'HH24:MI') AS SLOT_7, TO_CHAR(TIME_8_SLOT,'HH24:MI') AS SLOT_8, TO_CHAR(TIME_9_SLOT,'HH24:MI') AS SLOT_9, TO_CHAR(TIME_10_SLOT,'HH24:MI') AS SLOT_10 FROM OT_OPER_TIME_RANGE WHERE TIME_RANGE_CODE = '"+time_range_code+"' ORDER BY 1";
		pstmt = connection.prepareStatement(sql);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			 slot_1 = resultset.getString("SLOT_1");
			 slot_1=slot_1==null?"":slot_1;
			 slot_1=slot_1.equalsIgnoreCase("null")?"":slot_1;
			 slot_2	= resultset.getString("SLOT_2");
			 slot_2=slot_2==null?"":slot_2;
			 slot_2=slot_2.equalsIgnoreCase("null")?"":slot_2;
			 slot_3	= resultset.getString("SLOT_3");
			 slot_3=slot_3==null?"":slot_3;
			 slot_3=slot_3.equalsIgnoreCase("null")?"":slot_3;
			 slot_4	= resultset.getString("SLOT_4");
			 slot_4=slot_4==null?"":slot_4;
			 slot_4=slot_4.equalsIgnoreCase("null")?"":slot_4;
			 slot_5 = resultset.getString("SLOT_5");
			 slot_5=slot_5==null?"":slot_5;
			 slot_5=slot_5.equalsIgnoreCase("null")?"":slot_5;
			 slot_6	= resultset.getString("SLOT_6");
			 slot_6=slot_6==null?"":slot_6;
			 slot_6=slot_6.equalsIgnoreCase("null")?"":slot_6;
			 slot_7	= resultset.getString("SLOT_7");
			 slot_7=slot_7==null?"":slot_7;
			 slot_7=slot_7.equalsIgnoreCase("null")?"":slot_7;
			 slot_8	= resultset.getString("SLOT_8");
			 slot_8=slot_8==null?"":slot_8;
			 slot_8=slot_8.equalsIgnoreCase("null")?"":slot_8;
			 slot_9	= resultset.getString("SLOT_9");
			 slot_9=slot_9==null?"":slot_9;
			 slot_9=slot_9.equalsIgnoreCase("null")?"":slot_9;
			 slot_10= resultset.getString("SLOT_10");
			 slot_10=slot_10==null?"":slot_10;
			 slot_10=slot_10.equalsIgnoreCase("null")?"":slot_10;
		}
		append_str.append(slot_1+"::"+slot_2+"::"+slot_3+"::"+slot_4+"::"+slot_5+"::"+slot_6+"::"+slot_7+"::"+slot_8+"::"+slot_9+"::"+slot_10);	
		
	}catch(Exception e){
		System.err.println("Err Msg in StatBySpltyReportGetTimeRanges.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	out.println(append_str);
	append_str.setLength(0);

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
