package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __otcheckoutfromor extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTCheckOutFromOR.jsp", 1709117270000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<title>";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</title>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n\t<script type=\'text/javascript\' src=\'../../eOT/js/CheckInToOR.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eOT/js/CheckOutFromOR.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eOT/js/OTCommon.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<frameset rows=\"42,*,50\">\n    <frame name=\"commontoolbarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t\n\t\t<frameset rows=\'11%,12%,14%,19%,6%,*\' border=\'0\'>\n\t\t\t <frame name=\'OtPatientLineFrame\' src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" frameborder=0  scrolling=\"no\" noresize></frame>\n\t\t\t<frame name=\'common_patient_hdr_frame\' SRC=\'../../eOT/jsp/CommonOperDtlsHdr.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  scrolling=\'no\' noresize></frame>\n\t\t\t<frame name=\'common_oper_dtls_frame\' SRC=\'../../eOT/jsp/CommonOperationDtls.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  scrolling=\'auto\' noresize>\n\t\t\t<frame name=\'recovery_frame\' SRC=\'../../eOT/jsp/CheckOutFromOR.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' scrolling=\'auto\' noresize></frame>\n\n\t\t\t\t<frameset rows=\'0%,*\' border=\'0\'>\n\t\t\t\t\t<frame name=\'ObjectCollect\' SRC=\'../../eOT/jsp/NursingObjectCollect.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  scrolling=\'no\' noresize=\'no\'></frame>\n\t\t\t\t\t<frame name=\'tab_frame\' SRC=\'../../eOT/jsp/ChkInRecoveryTab.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  scrolling=\'auto\' noresize></frame>\t\n\t\t\t\t</frameset>\n\t\t\t<frame name=\'result_frame\' =SRC=\'../../eCommon/html/blank.html\'  scrolling=\'no\' noresize=\'no\'></frame> \n\t\t</frameset>\n\t <frame name=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\">\n</frameset>\n\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<form name=\"OTCheckInToORForm\" >\n\t\t<input type=\'hidden\' name=\'params\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckOutFromOR.Label","ot_labels")));
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
  
	String facility_id  = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String recovery_in_out_flag="CHECK_OUT_FROM_OR";
	String params = request.getQueryString()+"&facility_id="+facility_id+"&recovery_in_out_flag="+recovery_in_out_flag;
	String source = url + params ;

	//String oper_dtls = params+"&title=Operation Details&editable_yn=N&booking_oper_flag=OPER&booking_num=";

String operationdetails_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels");

String oper_dtls = params+"&title="+operationdetails_title+"&editable_yn=N&booking_oper_flag=OPER&booking_num=";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oper_dtls));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oper_dtls));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oper_dtls));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(params));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
