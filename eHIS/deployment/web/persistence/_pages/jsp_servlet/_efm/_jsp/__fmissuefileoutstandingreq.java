package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmissuefileoutstandingreq extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFileOutstandingReq.jsp", 1709116777795L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eFM/js/FMIssueFiles.js\' language=\'javascript\'></script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script language=\"JavaScript\">\n\t<!--\n\t//\tsetTimeout(\"document.location.reload();\",1000*60*";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =")\n\t//-->\n\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <frameset cols=\'22%,*\'>\n\t\t <frameset rows=\'60%,40%\' >\n \t\t     <frame name=\'OutstaListFrame1\' src=\'../../eFM/jsp/FMIssueFileOutstandingList1.jsp?userSecurity=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&resLocnIdentities=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&file_type_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&strLocn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&access_all=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 scrolling=auto noresize>\n\t\t\t<frame name=\'OutstaListFrame2\' src=\'../../eCommon/html/blank.html\' scrolling=auto frameborder=0 noresize>\n\t\t\n\t\t</frameset>\n\t\t<frameset rows=\'40%,*,6%\' >\n\t\t    <frame name=\'OutstaHeader\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=auto noresize >\n\t\t\t<frame name=\'OutstanListDetail\' src=\'../../eCommon/html/blank.html\' scrolling=auto frameborder=0 noresize>\n\t\t\t<frame name=\'OutstanListButton\' src=\'../../eCommon/html/blank.html\'  scrolling=no frameborder=0 noresize>\n\t\t</frameset>\n\t </frameset>\n\t  \n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<frameset rows=\'90%,*\'>\n\t\t\t<frame name=\'OutstanListDetail\' src=\'../../eFM/jsp/FMIssueFileOutstandingDetail.jsp?userSecurity=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&s_file_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&s_fs_locn_code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&s_fs_narration=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&s_request_date=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&s_request_by_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&file_no_concat=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&s_fs_locn_identity=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&volume_no_concat=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&s_file_type=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&s_volume_no=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' scrolling=auto frameborder=0 noresize>\n\t\t\t<frame name=\'OutstanListButton\' src=\'../../eFM/jsp/FMIssueFileOutstandingButton.jsp?resLocnIdentities=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  style=\'border-style: solid;\tborder-color:black; border-width:1\' scrolling=no frameborder=0 noresize>\n\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\n</html>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String userSecurity		= checkForNull( request.getParameter("userSecurity"));
	String resLocnIdentities	= checkForNull( request.getParameter("resLocnIdentities"));
	String strLocn				= checkForNull( request.getParameter("strLocn"));
	String s_file_no				= checkForNull( request.getParameter("s_file_no"));
	String s_fs_locn_code		= checkForNull( request.getParameter("s_fs_locn_code"));
	String s_fs_narration		= checkForNull( request.getParameter("s_fs_narration"));
	String s_request_date		= checkForNull( request.getParameter("s_request_date"));
	String s_request_by_id	= checkForNull( request.getParameter("s_request_by_id"));
	String s_fs_locn_identity	= checkForNull( request.getParameter("s_fs_locn_identity"));
	String refresh				= checkForNull( request.getParameter("refresh"));
	String file_type_yn			= checkForNull( request.getParameter("file_type_yn"));
	String s_file_type			= checkForNull( request.getParameter("s_file_type"));
	String s_volume_no		= checkForNull( request.getParameter("s_volume_no"));
	String access_all  = checkForNull( request.getParameter("access_all"),"access_all");
	String file_no_concat=checkForNull( request.getParameter("file_no_concat"));
	String volume_no_concat=checkForNull( request.getParameter("volume_no_concat"));
	String isOutStandingReqAvialble=checkForNull( request.getParameter("isOutStandingReqAvialble"));
	s_file_type		=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
	s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(isOutStandingReqAvialble.equals("true")){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(s_fs_locn_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(s_fs_narration));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(s_request_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(s_request_by_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(file_no_concat));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s_fs_locn_identity));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(volume_no_concat));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block28Bytes, _wl_block28);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
