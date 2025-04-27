package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;

public final class __picklistreviewframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PickListReviewFrame.jsp", 1723530926000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!--Added by lakshmi against CRF-0146-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<!--<frameset rows=\'0%,100%\'>-->\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t <frameset rows=\'0%,15%,*\'>\n\t\t <frame name=\'schedule_hdr\' id=\'schedule_hdr\'\tsrc=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\'no\' noresize>\t\n\t\t <!--Added by lakshmi against CRF-0146-->\t \n\t\t <frame name=\'schdule_fltr\' id=\'schdule_fltr\' \tsrc=\"../../eOT/jsp/PickListReviewFilter.jsp\" noresize frameborder=0 scrolling=\'no\'>\t\n\t\t <frame name=\'schdule_dtl\' id=\'schdule_dtl\' \t\tsrc=\"../../eOT/jsp/PickListReviewDtl.jsp\"  noresize frameborder=0 scrolling=\'yes\'>\n\t\t </frameset>\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <frameset rows=\'0%,*\'>\n\t\t <frame name=\'schedule_hdr\' id=\'schedule_hdr\'\tsrc=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\'no\' noresize>\t\n\t\t <frame name=\'schdule_dtl\' id=\'schdule_dtl\' \tsrc=\"../../eOT/jsp/PickListReviewDtl.jsp\"  noresize frameborder=0 scrolling=\'yes\'>\n\t\t </frameset>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t \n\n <!--Added by lakshmi against CRF-0146-->\n<input type=\'hidden\' name=\'Ot_param\' id=\'Ot_param\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block6Bytes, _wl_block6);

	// String strLegends="Surgery Date,Patient ,Surgeon,Booking No,Operation";
	// String strSizes="10,25,25,10,30";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="";
	 source=source+param;
//Added by lakshmi against CRF-0146
	  Connection conn=null;
	  PreparedStatement pstmt_sm_report_display = null;
	  ResultSet rst_sm_report_display=null;
	  conn=ConnectionManager.getConnection(request);

	String Ot_param="";
	String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST from OT_PARAM where rownum = 1";
	pstmt_sm_report_display=conn.prepareStatement(sql_sm_report);
	rst_sm_report_display=pstmt_sm_report_display.executeQuery();
	if(rst_sm_report_display !=null && rst_sm_report_display.next())
	   {
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
       if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
	   if(conn!=null) ConnectionManager.returnConnection(conn,request);
	 
            _bw.write(_wl_block7Bytes, _wl_block7);
if(Ot_param.equalsIgnoreCase("Y")){
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
	else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(source));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Ot_param));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
