package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.toolbar.bc.ToolBarDisplayBC;
import eBL.toolbar.response.ToolbarResponse;
import eBL.toolbar.request.ToolbarRequest;
import java.util.*;
import com.ehis.util.*;

public final class __bltoolbardisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLToolbarDisplay.jsp", 1737916842445L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="    \n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<style>\n.myButton {\n\t\n\tbackground-color: #83AAB4;\n\tborder-radius:8px;\n\tdisplay:inline-block;\n\tcursor:pointer;\n\tcolor:#ffffff;\n\tfont-family:arial;\n\tfont-size:10px;\n\tfont-weight:bold;\n\tpadding:5px 12px;\n\ttext-decoration:none;\n\ttext-shadow:0px 1px 0px #3d768a;\n\tBORDER-STYLE: outset;\n\tBORDER-LEFT-COLOR: #83AAB4;\n\tBORDER-RIGHT-COLOR: #83AAB4;\n\tBORDER-TOP-COLOR: #83AAB4;\n\tBORDER-BOTTOM-COLOR: #83AAB4 \n}\n.myButton:hover {\n\tbackground-color:#44919E;\n\tBORDER-STYLE: inset;\n}\n.myButton:active {\n\tposition:relative;\n\ttop:1px;\n}\n.iconBarRow\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBG.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n.iconBarRowBlue\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGBlue.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n.iconBarRowLime\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGLime.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n.iconBarRowOrange\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGOrange.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n.iconBarRowViolet\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGViolet.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tIMG.imageClass\n\t{\n\t\tvertical-align: middle;\n\t}\n</style>\n<script>\n$(document).ready(function(){\n\t$(\'span:last\').css(\'padding-right\',\'0px\')\n});\nfunction loadFunction(url){\n\talert(\'Url ->\'+url);\n}\n\nfunction refresh(){\n\tparent.refresh();\n}\n\nfunction closeWindow(){\n\tparent.closeWindow();\n}\n</script>\n</head>\n<body>\n\t<form action=\"\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<div class=\'iconBarRow";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<span style=\"padding-right: 30px;  \">\n\t\t\t\t\t\t\t<img src=\"../images/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" width=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" height=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"cursor: pointer;\" title=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onclick=\"loadFunction(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\">\n\t\t\t\t\t\t</span>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<span style=\"padding-right: 30px; \">\n\t\t\t\t\t<img src=\"../images/refresh.jpg\" width=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\"cursor: pointer;\" title=\"Refresh Page\" onclick=\'refresh();\'>\n\t\t\t\t</span>\n\t\t\t\t<span style=\"padding-right: 30px; \">\n\t\t\t\t\t<img src=\"../images/MI_CloseT1.gif\" width=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" style=\"cursor: pointer;\" title=\"Close Window\" onclick=\'closeWindow();\'>\n\t\t\t\t</span>\n\t\t\t</div>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String styleMap = "";
	 if("IeStyleBlue.css".equals(sStyle))
	 {
		styleMap = "Blue";
	 }
	 else if("IeStyleLime.css".equals(sStyle))
	 {
		styleMap = "Lime";
	 }
	 else if("IeStyleOrange.css".equals(sStyle))
	 {
		styleMap = "Orange";
	 }
	 else if("IeStyleVoilet.css".equals(sStyle))
	 {
		styleMap = "Violet";
	 }
	 else
	 {
		styleMap = "";
	 }
	String width = "25px;";
	String height = "25px;";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String userId = checkForNull(request.getParameter("userid"));
		String responsibilityId = checkForNull(request.getParameter("userrespid"));
		String functionId = checkForNull(request.getParameter("functionid"));
		String facilityId = (String) session.getValue( "facility_id" ) ;
		ToolbarRequest toolbarRequest = new ToolbarRequest();
		toolbarRequest.setUserId(userId);
		toolbarRequest.setResponsibilityId(responsibilityId);
		toolbarRequest.setFacilityId(facilityId);
		toolbarRequest.setFunctionId(functionId);
		ToolBarDisplayBC toolBarBC = new ToolBarDisplayBC(); 
		ToolbarResponse toolbarResponse = toolBarBC.getToolBarForUser(toolbarRequest);
		HashMap toolBarMap = toolbarResponse.getToolBarMap();
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block9Bytes, _wl_block9);

				if(toolBarMap!=null){
					ToolbarResponse bean = null;
					Iterator iterator= toolBarMap.keySet().iterator();
					int index = 0;
					int sNo = 0;
					while(iterator.hasNext())
					{
						index =    (Integer)iterator.next();
						sNo	  =		index+1;
						bean =  (ToolbarResponse) toolBarMap.get(index);
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean.getToolbarIcon() ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(width ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(height ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean.getToolbarFunction()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean.getToolbarUrl()));
            _bw.write(_wl_block15Bytes, _wl_block15);
		
					}
				}
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(width ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(height ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(width ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(height ));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
