package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __paintamendtransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PaintAmendTransfer.jsp", 1720181609263L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<iframe src=\"../../eCommon/jsp/pline.jsp?Facility_Id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&EncounterId=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" name=\"PatientLine_frame\" scrolling=NO noresize style=\"height:10vh;width:98vw\"></iframe>\n\t\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<iframe src=\"ConfirmBookBedTransfer.jsp?encounter_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&booking_ref_no=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&fromFunction=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&oper_stn_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&routine_tfr_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&priority_applicable_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&change_bed_class_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&deactivate_pseudo_bed_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&bed_block_period_max_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&bed_block_period_max_int=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"height:75vh;width:98vw\" name=\"Transfer_frame\" scrolling=\'no\'></iframe> \n\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<iframe src=\"CancelBookBedTransfer.jsp?encounter_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"Transfer_frame\" scrolling=\'no\' style=\"height:75vh;width:98vw\"></iframe>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t\t<iframe src=\"../../eCommon/jsp/error.jsp\" name=\"Dummy_frame\" id=\"Dummy_frame\" scrolling=\'auto\' noresize style=\'height:0vh;width:98vw\'></iframe>\n\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block2Bytes, _wl_block2);

	String function_id					= checkForNull(request.getParameter("function_id"));
	String fromfunction				= checkForNull(request.getParameter("fromFunction"));
	String patientid					= request.getParameter("patientId");
	String encounterid				= request.getParameter("encounterId");
	String bookingrefno				= request.getParameter("booking_ref_no");
	String facilityId					= (String)session.getValue("facility_id");

	// Added by Sridhar R on Mar 11 2005.. for passing parameters to respective calling page...
	String oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
	String routinetfryn				= checkForNull(request.getParameter("routine_tfr_yn"),"N");
	String priority_applicable_yn	= checkForNull(request.getParameter("priority_applicable_yn"),"N");
	String change_bed_class_yn	= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String bed_block_period_max_type= checkForNull(request.getParameter("bed_block_period_max_type"));
	String bed_block_period_max_str	= checkForNull(request.getParameter("bed_block_period_max_int"));
	int bed_block_period_max_int	= 0;
	if(! bed_block_period_max_str.equals(""))
		bed_block_period_max_int	= Integer.parseInt(bed_block_period_max_str);


	if(function_id.equals("CancelRequest"))
		out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmDetails.label","ip_labels")+" </title>");
	else if(function_id.equals("CONFIRM_TRANS_BOOKING"))
		out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmRequestforTransfer.label","ip_labels")+" </title>");
	else
		out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelRequestForTransfer.label","ip_labels")+" </title>");

            _bw.write(_wl_block3Bytes, _wl_block3);


	if(routinetfryn.equals("Y"))
	{	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block6Bytes, _wl_block6);
	if(function_id.equals("CONFIRM_TRANS_BOOKING")) 
		{	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fromfunction));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(routinetfryn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(priority_applicable_yn)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(change_bed_class_yn)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(bl_interfaced_yn)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_block_period_max_type)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bed_block_period_max_int));
            _bw.write(_wl_block19Bytes, _wl_block19);
	}
		else
		{	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fromfunction));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(routinetfryn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(priority_applicable_yn)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(change_bed_class_yn)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(deactivate_pseudo_bed_yn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(bl_interfaced_yn)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_block_period_max_type)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bed_block_period_max_int));
            _bw.write(_wl_block21Bytes, _wl_block21);
	}	
            _bw.write(_wl_block22Bytes, _wl_block22);
	}
	else
	{
		out.println("<script>alert(getMessage('CANNOT_PROCEED','IP'));</script>");
		out.println("<script>window.close()</script>");
	}

            _bw.write(_wl_block23Bytes, _wl_block23);
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
