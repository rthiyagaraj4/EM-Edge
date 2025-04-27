package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __querydispspecialdrugorderframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryDispSpecialDrugOrderFrame.jsp", 1709121324284L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--This file is saved on 28/10/2005-->\n<html>                                \n<head>                                \n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\n\t<script language=\"javascript\" src=\"../js/PhCommon.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>                               \n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n<iframe name=\"f_drugdetailsframe\" id=\"f_drugdetailsframe\"  src=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:5%;width:100vw\"></iframe><iframe name=\"f_orderdetailsframe\" id=\"f_orderdetailsframe\" src=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:70%;width:100vw\"></iframe><iframe name=\"f_totaldetailsframe\" id=\"f_totaldetailsframe\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:15%;width:100vw\"></iframe><iframe name=\"f_orderdetailsframe1\" id=\"f_orderdetailsframe1\" src=\"../../eCommon/html/blank.html\" noresize scrolling=\"auto\" frameborder=\"0\"  style=\"height:100vh;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<iframe name=\"f_summaryframe\" id=\"f_summaryframe\"  src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:80%;width:100vw\"></iframe><iframe name=\"f_drugdetailsframe\" id=\"f_drugdetailsframe\"  src=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"no\" style=\"height:4%;width:100vw\"></iframe><iframe name=\"f_orderdetailsframe\" id=\"f_orderdetailsframe\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:6%;width:100vw\"></iframe><iframe name=\"f_totaldetailsframe\" id=\"f_totaldetailsframe\" src=\"../../eCommon/html/blank.html\" frameborder=\"0\" noresize scrolling=\"no\"  style=\"height:4%;width:100vw\"></iframe><iframe name=\"f_orderdetailsframe1\" id=\"f_orderdetailsframe1\" src=\"../../eCommon/html/blank.html\" noresize scrolling=\"auto\" frameborder=\"0\"  style=\"height:6%;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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

	String dt_from	=	request.getParameter("dt_from");
	String  dt_to	=	request.getParameter("dt_to");
	String  drug_code	=	request.getParameter("drug_code");


String url1= "../../ePH/jsp/QueryDispSpecialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;

String url2="../../ePH/jsp/QueryDispSpecialDrugSummary.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;

if ( (!(drug_code.equals("")))&&(drug_code!=null))
	{
		url1= "../../ePH/jsp/QueryDispSpecialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&fromSummary=0";

		out.println("inside if");

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(url1));
            _bw.write(_wl_block2Bytes, _wl_block2);

	}
else
{ out.println("inside else");

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(url2));
            _bw.write(_wl_block4Bytes, _wl_block4);

	}

            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
