package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;

public final class __preoperchklistframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PreOperChkListFrames.jsp", 1729068056000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n<HTML>\n<head> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<!-- <FRAMESET  rows=\'54%,*\'  border=\'0\'> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!-- <FRAMESET  rows=\'12%,34%,*\'  border=\'0\'> -->\n\t\t\t\t<iframe name=\'OtPatientLineFrame\' src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" noresize scrolling=\'no\' ></iframe>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<iframe name=\'ChkListRecordFrame\' id=\'ChkListRecordFrame\' src=\"../../eOT/jsp/PreOperChkListHdr.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" noresize scrolling=\'yes\' frameborder=\'0\' style=\"height:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";width:100vw;\"></iframe>\n\t<iframe name=\'ChkListDetailFrame\' id=\'ChkListDetailFrame\' src=\"../../eOT/jsp/PreOperativeChkListDtlsFrames.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" noresize scrolling=\'no\'frameborder=\'0\' style=\"height:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =";width:100vw;\"></iframe>\n<!-- <FRAMESET> -->\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<!-- <FRAMESET  rows=\'12%,33%,*\'  border=\'0\'> -->\n\t<iframe name=\'OtPatientLineFrame\' src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" noresize scrolling=\'no\' ></iframe>\n\t<iframe name=\'ChkListRecordFrame\' src=\"../../eOT/jsp/PreOperChkListHdr.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" noresize scrolling=\'yes\' style=\"height:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";width:100vw;\"></iframe>\n\t<iframe name=\'ChkListDetailFrame\' src=\"../../eOT/jsp/PreOperativeChkListDtlsFrames.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" noresize scrolling=\'no\' style=\"height:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =";width:100vw;\"></iframe>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</head>\n<body  onKeyDown = \'lockKey()\' >\n<form name=\"PreOperChkListForm\" >\n\t<input type=\'hidden\' name=\'params\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\n\t<input type=\'hidden\' name=\'tab_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n</form>\n</body>\n</HTML>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block4Bytes, _wl_block4);

	String params = request.getQueryString();
    String	tab_id = CommonBean.checkForNull(request.getParameter("tab_id"));
	String	called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	//System.out.println("====called_from====PreOperChkListFrames======"+called_from);
	params+="&tab_id="+tab_id;
	String bean_id = "CheckInBean";
	String bean_name = "eOT.CheckInBean";
	CheckInBean bean = (CheckInBean)mh.getBeanObject(bean_id, request, bean_name);
	bean.clear();	
	String height1 =""; 
	String height2 =""; 
	String height3 =""; 
	if(called_from.equals("OT_MENU") || called_from.equals("BOOKING"))
	{
		if(called_from.equals("OT_MENU"))
		{
			height1 ="";
			height2 ="58vh";
			height3 ="44vh";

            _bw.write(_wl_block5Bytes, _wl_block5);

		}
		else if(called_from.equals("BOOKING"))
		{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(params));
            _bw.write(_wl_block7Bytes, _wl_block7);

		}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(height2 ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(height3 ));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else if(called_from.equals("OT_SLATE")) 
	{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(params));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(height2 ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(height3 ));
            _bw.write(_wl_block18Bytes, _wl_block18);

	}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tab_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
