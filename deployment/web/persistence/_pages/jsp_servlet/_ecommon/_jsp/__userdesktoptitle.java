package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __userdesktoptitle extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/UserDeskTopTitle.jsp", 1709116513732L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n <head>\t\n \t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<STYLE TYPE=\"text/css\">\n\tA.imageClass1 \n\t{\n\t\twidth:30px;\n\t\theight:28px;\n\t\tmargin-left:0;\n\t\tmargin-right:0;\n\t\tmargin-top:0;\n\t\tmargin-bottom:0;\n\t\tpadding-left:3px;\n\t\tpadding-right:3px;\n\t\tpadding-top:2px;\n\t\tpadding-bottom:1px;\n\t\tborder-top:0px;\n\t}\n\tA.imageClass2 \n\t{\n\t\tbackground-color:#FFFFFF;\n\t\twidth:30px;\n\t\theight:28px;\n\t\tmargin-left:0;\n\t\tmargin-right:0;\n\t\tmargin-top:0;\n\t\tmargin-bottom:0;\n\t\tpadding-left:2px;\n\t\tpadding-right:2px;\n\t\tpadding-top:2px;\n\t\tpadding-bottom:1px;\n\t\tborder-left:1px solid;\n\t\tborder-right:1px solid;\n\t\tBORDER-COLOR: #75768B;\n\t}\n\timg\n\t{\n\t\tborder:0;\n\t}\n\n\tTR.iconBarRow\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBG.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowBlue\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGBlue.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowLime\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGLime.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowOrange\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGOrange.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowViolet\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGViolet.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tIMG.imageClass\n\t{\n\t\tvertical-align: middle;\n\t}\n\n</STYLE>\n      <script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n      <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\nfunction goHomePage() {\n\tparent.location.reload();\n\t//parent.menucontent.location.href = \"../../eCommon/jsp/UserDesktop.jsp\";\t\n} \n\nfunction showMenu(obj) {\t\n\tparent.menucontent.expand();\n\tif(obj.name == \'ShowMenu\') {\t\t\n\t\tdocument.getElementById(\"ShowMenu\").style.display=\'none\';\n\t\tdocument.getElementById(\"HideMenu\").style.display=\'inline\';\n\t} else {\t\t\n\t\tdocument.getElementById(\"ShowMenu\").style.display=\'inline\';\n\t\tdocument.getElementById(\"HideMenu\").style.display=\'none\';\n\t}\n\n}\nfunction hotStateImage(obj) {\n\tobj.className = \'imageClass2\';\n}\n\nfunction restorePrevState(obj) {\n\tobj.className = \'imageClass1\';\n}\n</script>\n</head>\n  <table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n        <tr  class=\'iconBarRow";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\t\t\n\t\t\t<td width=\'5%\'><a href=\"#\" class=\"imageClass1\" ><img align=\'center\' src=\'../../eCA/images/MI_Show.gif\' name=\'ShowMenu\' style=\'\' onclick=\"showMenu(this);\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' accesskey=\'M\' alt=\'Show Menu\'></img>\n\t\t\t<img align=\'center\' src=\'../../eCA/images/MI_Hide.gif\' name=\'HideMenu\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'display:none\'  onclick=\"showMenu(this);\" accesskey=\'M\' alt=\'Hide Menu\'></img></a>\n\t\t\t<a href=\"#\" class=\"imageClass1\" ><img onclick=\"goHomePage();\" id=\'searchPatHome\' src=\'../../eCA/images/MI_Home.gif\' alt=\'Home Page\' align=\'center\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'></img></a></td>\n\t\t</tr>\n    </table>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			 
			 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
			 {
				styleMap = "Blue";
			 }
			 else if(sStyle.equals("IeStyleLime.css"))
			 {
				styleMap = "Lime";
			 }
			 else if(sStyle.equals("IeStyleOrange.css"))
			 {
				styleMap = "Orange";
			 }
			 else if(sStyle.equals("IeStyleVoilet.css"))
			 {
				styleMap = "Violet";
			 }
			 else
			 {
				styleMap = "";
			 }
			


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
