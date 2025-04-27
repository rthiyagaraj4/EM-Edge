package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __pendingappointmentbottomright extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PendingAppointmentBottomRight.jsp", 1709117216000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/PendingAppointment.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<script>function_id = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";</script>\n\n</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<frameset rows=\'12%,80%,8%\'>\n\t<frame name=\'CosignOrdersBottomRight0\' src=\'PendingAppointmentBottomRightHeading.jsp?source_type=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&source_code=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&order_by=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&priority=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&ord_cat=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&ord_cat_desc=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&priority_desc=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patientId=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&period_from=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&period_to=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&filter=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0 scrolling=\'no\' noresize>\n\t<frame name=\'CosignOrdersBottomRight1\' src=\'PendingAppointmentBottomRightDtl.jsp?source_type=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&total_recs=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' frameborder=0 scrolling=\'auto\'  noresize>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<frame name=\'CosignOrdersBottomRight2\' src=\'PendingAppointmentBottomRightBtn.jsp\' frameborder=0 scrolling=\'no\' noresize >\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</frameset>\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, false , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block4Bytes, _wl_block4);


	String source_type= request.getParameter( "source_type" )==null?"":request.getParameter( "source_type" );
	String source_code	= request.getParameter( "source_code" ) ==null?"":request.getParameter( "source_code" );
	String order_by			= request.getParameter( "order_by" )==null?"":request.getParameter( "order_by" );
	String priority			= request.getParameter( "priority" ) ==null?"":request.getParameter( "priority" );
	String ord_cat			= request.getParameter( "ord_cat" ) ==null?"":request.getParameter( "ord_cat" );
	String ord_cat_desc	= request.getParameter( "ord_cat_desc" )==null?"":request.getParameter( "ord_cat_desc" );
	String priority_desc	= request.getParameter( "priority_desc" ) ==null?"":request.getParameter( "priority_desc" );
	String total_recs		= request.getParameter( "total_recs" ) ==null?"":request.getParameter( "total_recs" );
	String patientId  	    = request.getParameter("patientId")==null?"":request.getParameter( "patientId" );
	String period_from		= request.getParameter("period_from")==null?"":request.getParameter( "period_from" );
	String period_to		= request.getParameter("period_to")==null?"":request.getParameter( "period_to" );

	/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added for take Filter criteria value from request . 
						*/
	String filter		= request.getParameter("filter")==null?"":request.getParameter( "filter" );	



            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(period_to ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(filter ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(filter ));
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(filter.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
}  
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
