package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlqrymainframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlQryMainFrames.jsp", 1737435338376L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n\n<form>\n</form>\n</body>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n<iframe name=\'query1\' id=\'query1\'\tsrc=\"BLFinDtlQry1.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  frameborder=0 scrolling=\'no\' noresize style=\'height:25vh;width:100vw\'></iframe>\n<iframe name=\'dummyFrame\' id=\'dummyFrame\'\t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:0vh;width:100vw\'></iframe>\n<iframe name=\'query3\' id=\'query3\'\tsrc=\"BLFinDtlQry2.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:25vh;width:100vw\'></iframe>\n<iframe name=\'query4\' id=\'query4\'\tsrc=\"BLFinDtlQry3.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:28vh;width:100vw\'></iframe>\n<iframe name=\'query2\' id=\'query2\'\tsrc=\"BLFinDtlQry4.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:11vh;width:100vw\'></iframe>\n<iframe name=\'query2\' id=\'query2\'\tsrc=\"BLFinDtlQryBtn.jsp\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<iframe name=\'query1\' id=\'query1\'\tsrc=\"BLFinDtlQry1.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  frameborder=0 scrolling=\'no\' noresize  style=\'height:25vh;width:100vw\'></iframe>\n<iframe name=\'dummyFrame\' id=\'dummyFrame\'\t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:0vh;width:100vw\'></iframe>\n<iframe name=\'query3\' id=\'query3\'\tsrc=\"BLFinDtlQry3.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:50vh;width:100vw\'></iframe>\n<iframe name=\'query2\' id=\'query2\'\tsrc=\"BLFinDtlQry4.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:11vh;width:100vw\'></iframe>\n<iframe name=\'query2\' id=\'query2\'\tsrc=\"BLFinDtlQryBtn.jsp\"  frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\n\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\n<iframe name=\'query1\' id=\'query1\'\tsrc=\"BLFinClassDtlQry.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:95vh;width:100vw\'></iframe>\n<iframe name=\'query2\' id=\'query2\'\tsrc=\"BLFinDtlQryBtn.jsp\"  frameborder=0 scrolling=\'auto\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String strAllParam = "", strSetInd = "", strAdmFlag = ""; 
	String fin_class_flag_YN="N", strCaldFrmClassFinDtls="";

	try
	{
		strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";
//System.err.println("Query String in MainFrames.jsp:"+strAllParam);
		fin_class_flag_YN= request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		strCaldFrmClassFinDtls = request.getParameter("strCaldFrmClassFinDtls");
		if(strCaldFrmClassFinDtls == null) strCaldFrmClassFinDtls="";

		strSetInd = request.getParameter("strSetInd");
		if(strSetInd == null) strSetInd="";

		strAdmFlag = request.getParameter("strAdmFlag");
		if(strAdmFlag == null) strAdmFlag="";

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		if(fin_class_flag_YN.equals("N") ||(fin_class_flag_YN.equals("Y") && strCaldFrmClassFinDtls.equals("F")))
		{
//	System.err.println("Inside Financial Dtls Frames");
		    if((strSetInd.equals("X")) && (strAdmFlag.equals("2")))
			{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			else
			{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
		}
		else if(fin_class_flag_YN.equals("Y") && strCaldFrmClassFinDtls.equals("C"))
		{
//	System.err.println("Inside Financial Class Frames");

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strAllParam));
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
	}
	catch(Exception eX)
	{
		System.out.println("Error in QryMain.jsp= "+eX);
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
