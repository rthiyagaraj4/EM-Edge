package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __bookingdetailframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/BookingDetailFrame.jsp", 1740044928000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="                \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head > </head>\n<script type=\"text/javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/CancelTransfer.js\'></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\n\n<script language=\'javascript\'>\nfunction setAssignValue(dat){\n\treturn dat;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<form name=\'hiddenFrm\' id=\'hiddenFrm\'>\n <input type=\'hidden\' name=\'booking_date\' id=\'booking_date\' value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n <input type=\'hidden\' name=\'room_code\' id=\'room_code\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n <input type=\'hidden\' name=\'seq_change_yn\' id=\'seq_change_yn\'\n value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n<input type=\'hidden\' name=\'transfer\' id=\'transfer\'\n value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n </form>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<TITLE>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TITLE>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\"  scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\"height:4vh;width:97vw\" frameborder=\'0\'></iframe>\n<iframe name=\"OTPatientLineFrame\" id=\"OTPatientLineFrame\"  scrolling=\"no\" noresize src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=\'0\' style=\"height:15vh;width:97vw\"></iframe>\n\t <iframe name=\'header_frame\' id=\'header_frame\'\tsrc=\"../../eOT/jsp/BookingDetail.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"   scrolling=\"no\"  nowrap frameborder=\'0\' style=\"height:23vh;width:97vw\"></iframe>\n\t<iframe name=\'message_search_frame\' id=\'message_search_frame\'\t src=\"../../eOT/jsp/BookingCommonFrame.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" noresize frameborder=\'0\' style=\"height:50vh;width:97vw\"></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\'  noresize frameborder=\'0\' style=\"height:7vh;width:97vw\"></iframe>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'../../eCommon/html/blank.html\'  noresize  frameborder=\'0\' style=\'height:0vh;width:97vw\'></iframe>\n<iframe name=\"OTPatientLineFrame\" id=\"OTPatientLineFrame\"  scrolling=\"no\" noresize src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" frameborder=\'0\' style=\'height:18vh;width:99vw\'></iframe>\n\t <iframe name=\'header_frame\' id=\'header_frame\'\tsrc=\"../../eOT/jsp/BookingDetail.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"   scrolling=\"no\"   nowrap frameborder=\'0\' style=\'height:20vh;width:99vw\'></iframe>\n\t<iframe name=\'message_search_frame\' id=\'message_search_frame\'\t src=\"../../eOT/jsp/BookingCommonFrame.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"   frameborder=\'0\' noresize style=\'height:56vh;width:99vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\'  noresize frameborder=\'0\' style=\'height:0vh;width:99vw\'></iframe>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getParameter("booking_date")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getParameter("room_code")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("seq_change_yn")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getParameter("transfer")));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String source="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT";
	String transfer=CommonBean.checkForNull(request.getParameter("transfer"));
	String strCancelFlag=CommonBean.checkForNull(request.getParameter("cancel_flag"));
	String called_from=CommonBean.checkForNull(request.getParameter("called_from"));
	String menu_reqd=CommonBean.checkForNull(request.getParameter("menu_required_yn"));
	if(called_from.equals("CHK_OUT_WARD")){ // When "View Booking Details" is called from Check-Out from Ward function
		menu_reqd = "N";
	}

	String title="";
if(transfer.equals("1")==true){
	source=source+"&access=NYNNY&home_required_yn=N";
	title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
}else if(transfer.equals("5")==true) {
	source=source+"&access=NNNNY&home_required_yn=N";
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
}else if(transfer.equals("6")==true){
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RescheduleForm.Label","ot_labels");
	source=source+"&access=NYNNY&home_required_yn=N";
} else {
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels");

if(strCancelFlag.equals("1"))
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CancelViewDetails.Label","ot_labels");//title="Cancel View Details";
source+=("BookingQry".equals(called_from))?"&access=NNNNN&home_required_yn=N":"&access=NYNNN&home_required_yn=N";
source=source+"&access=NYNNN&home_required_yn=N";
}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(title));
            _bw.write(_wl_block12Bytes, _wl_block12);

if(!menu_reqd.equals("N") && (!called_from.equals("BookingQry"))){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
