package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __print_confirm_form extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/print_confirm_form.jsp", 1709119465054L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script language=\"JavaScript\">\nvar iname = \"test\";\n\t\tfunction returnText(val)\n\t\t{\n\t\tif(val == \'O\')\n\t\t\t{\n\t\t\t\tdocument.forms[0].submit();\n\t\t\t}\n\t\t\t\n\t\t\tparent.window.close();\n\n\t\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onKeyDown = \'lockKey();\'>\n\t<form name=\"RegPatReferralPrint_form\" id=\"RegPatReferralPrint_form\" action=\"../../servlet/eOP.RegPatReferralServlet\" method=\"post\" target=\"messageFrame\">\n\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" height=\"100%\">\n\t\t<tr>\n\t\t\t<td align=center class=LABEL>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<b>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</b></td>\n\t\t</tr>\n\t   <tr><td class=\'DEFAULTBLANKROW2PT\' colspan=2>&nbsp;</td></tr></tr>\n\t\t<tr>\n\t\t\t<td align=center  class=LABEL>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n\t\t</tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td align=center>\n\t\t\t\t<input type=\"button\" class=BUTTON value=\'<fmt:message key=\"Common.yes.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\' onClick=\"returnText(\'O\')\"><input type=\"button\" class=BUTTON value=\'<fmt:message key=\"Common.no.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\' onClick=\"returnText(\'C\')\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"call_from\" id=\"call_from\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\t\n\t\t<input type=\"hidden\" name=\"appt_ref_no\" id=\"appt_ref_no\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\t\n\t\t<input type=\"hidden\" name=\"referral_id\" id=\"referral_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\t\n\t\t<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\t\n\t\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\t\n\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\t\n\t\t<input type=\"hidden\" name=\"report_id\" id=\"report_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\t\n\t\t<input type=\"hidden\" name=\"operation_type\" id=\"operation_type\" value=\"print\">\t\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		String referralid = request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
		String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
		
		String appt_ref_no = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");
		String locncode = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		String locntype = request.getParameter("locn_type")==null?"L":request.getParameter("locn_type");
		String message  = request.getParameter("message")==null?"":request.getParameter("message");
		String module_id="";
		String report_id="";
		String display_id = "";
		String confirm="";
		if (call_from.equals("OA_APPT"))
		{
			module_id="OA";
			report_id="OARAPSL";
			display_id= appt_ref_no;
		}
		else
		{
			module_id ="OP";
			report_id ="OPRFLETR";
			display_id= referralid;
		}
		if (call_from.equals("PAT_CHECKOUT"))
		{
			confirm =message + "?";
			message="";
			display_id="";
		}


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(message));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(display_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(confirm));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(referralid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
