package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.WardChkOutBean;
import java.util.*;
import com.ehis.util.*;

public final class __wardchkoutsearchresultsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/WardChkOutSearchResultsFrame.jsp", 1724157254000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<!-- <div id=\"WardChkOutResultsFrame\" > -->\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<iframe name=\"f_ward_chk_out_frame\" id=\"f_ward_chk_out_frame\" style=\"height:90vh; width: 100vw;\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/WardChkOutOTResults.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></iframe>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<iframe name=\"f_ward_chk_out_frame\" id=\"f_ward_chk_out_frame\" style=\"height:90vh; width: 100vw;\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/WardChkOutRDResults.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></iframe>\t\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<iframe name=\"f_header_frame\" id=\"f_header_frame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" > </iframe>\n\t\t\t\t<iframe name=\"f_ward_chk_out_frame\" id=\"f_ward_chk_out_frame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" ></iframe> \n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<!-- </div> -->\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<script language=\"javascript\">\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t//enableSearchCriteria();\n\t</script>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</body>\n</html>\n\t\n";
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

//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*"

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String params		= request.getQueryString() ;
	String surgery_date	= request.getParameter("surgery_date");
	String nursing_unit	= request.getParameter("nursing_unit");
	String patient_id	= request.getParameter("patient_id");
	String view_by		= request.getParameter("view_by");
	String bookings_type= request.getParameter("bookings_type");
	String current_ip_ward_yn= request.getParameter("current_ip_ward_yn");
	String bean_id		= "WardChkOutBean";
	String bean_name	= "eOT.WardChkOutBean";
	String appt_yn ="";
	if(view_by.equals("A"))
		appt_yn = "";
	else if(view_by.equals("S"))
		appt_yn = "Y";
	else if(view_by.equals("U"))
		appt_yn = "N";
//BLEnterServiceRequestBean ServPanlBean			= (BLEnterServiceRequestBean)getBeanObject( str_or_bean_id, "eBL.BLEnterServiceRequestBean", request ) ;
	WardChkOutBean bean	= (WardChkOutBean) mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	boolean ward_dtls_flag = false;
	String header_flag = "";
	if(bookings_type.equals("S")){
		ward_dtls_flag = bean.loadSurgeryBkgWardChkOutDtls(surgery_date,nursing_unit,patient_id,appt_yn,current_ip_ward_yn);
		header_flag="SURGERY_WARD_CHECK_OUT";
	}else if(bookings_type.equals("R")){
		ward_dtls_flag = bean.loadRadiologyBkgWardChkOutDtls(surgery_date,nursing_unit,patient_id);
		header_flag = "RADIOLOGY_WARD_CHECK_OUT";
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

			if(ward_dtls_flag==true){
			//System.out.println("ward_dtls_flag1: " + ward_dtls_flag) ;
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);

				if(bookings_type.equals("S")){ // OT checklist
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(params));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}else{
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}else{
			
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

		if(ward_dtls_flag==false){
	
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
	
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
