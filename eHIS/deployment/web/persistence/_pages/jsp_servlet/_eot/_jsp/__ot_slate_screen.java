package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.OT_Slate_Bean;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __ot_slate_screen extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OT_slate_screen.jsp", 1709120298000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="  \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<head>\n<meta charset=\"utf-8\" />\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<meta name=\"keywords\" content=\"\" />\n\t<meta name=\"description\" content=\"\" />\n\t<link rel=\"stylesheet\" href=\"../../eOT/html/style.css\" type=\"text/css\" media=\"screen, projection\" /> </link>\n</head> \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eOT/html/style.css\"></link>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script> \n\tfunction closeHelp()\n\t\t{ \n\t\t    var key = event.keyCode; \n\t\t\tif (key == 27)\n\t\t\t{\n\t\t\t\tif(parent.parent.opener != null)\n\t\t\t\t {\n\t\t\t\t\tparent.parent.opener.closeDashboard();\n\t\t\t\t }\n\t\t\t\telse\n\t\t\t\t  {\n\t\t\t\t\t window.close();\t\n\t\t\t\t  }\n\t\t\t}\n\t\t} \t\n</script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body  OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'  onkeypress=\"closeHelp()\" >\n\n\t<div class=\"detailslot\"  >\n\t\t<div id=\"div_dynamic_height\">\n\t\t\t<div class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =", slotex\">\n\t\t\t\t<div class=\"detailpanel\" >\n\t\t\t\t\t<div class=\"roomdetailcontainer\" >\n\t\t\t\t\t\t<div class=\"rdheadercontainer\">\n\t\t\t\t\t\t\t<div class=\"rdcheaderleft\"></div>\n\t\t\t\t\t\t\t<div class=\"rdcheader\">\n\t\t\t\t\t\t\t\t<div class=\"hdtext\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" : ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div>  <!-- IN047845 -->\n\t\t\t\t\t\t\t\t<div class=\"bookingtext\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =": ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t- ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" to ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"rdcheaderright\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"rdccontent\">\n\t\t\t\t\t\t\t <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"pinfoname trancolor\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t  <td>\n\t\t\t\t\t\t\t\t\t<marquee direction=\"up\" scrollamount=\"2\"   height=\"50\" > \n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<br/>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <br/>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</marquee>\n\t\t\t\t\t\t\t\t </td>\n\t\t\t\t\t\t\t\t <td>\n\t\t\t\t\t\t\t\t\t<marquee direction=\"up\" scrollamount=\"2\"   height=\"50\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="  <br/>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\t\t \n\t\t\t\t\t\t\t\t\t </marquee>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t  </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<div class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t<div class=\"patientinfodetail\" >\n\t\t\t\t\t<div class=\"patientinfoheader\">\n\t\t\t\t\t\t<div class=\"distable\" >\n\t\t\t\t\t\t\t<div class=\"disrow\" >\n\t\t\t\t\t\t\t\t<div class=\"discellleft\" >\n\t\t\t\t\t\t\t\t\t<div class=\"pribbonhead\" >\n\t\t\t\t\t\t\t\t\t<div class=\"bgsss\" ></div>\n\t\t\t\t\t\t\t\t\t<div class=\"bgscolor\" >\n\t\t\t\t\t\t\t\t\t\t<div class=\"infoid\" >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"infotime\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="-";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div> <!-- IN046724 -->\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"bgsstrip\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"discellright\">\n\t\t\t\t\t\t\t\t\t<div class=\"distablefix\" >\n\t\t\t\t\t\t\t\t\t\t<div class=\"disrow\" >\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"statustext\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"alignrighttext\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"statustextat\">\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\tat ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"inbutton\" style=\"background-color:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t<div class=\"distablefix\" >\n\t\t\t\t\t\t\t\t\t\t<div class=\"disrow\" >\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"statustext\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class =\'alignrighttext\' >\n\t\t\t\t\t\t\t\t\t\t\t\t <div class =\"new\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t </div>\t\n\t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"patientdetail\" >\n\t\t\t\t\t\t<div class=\"pinfoname\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</div>\n\t\t\t\t\t\t<div class=\"pinfodetail\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =",&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =", &nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"proceduredetail\">\n\t\t\t\t\t\t<div class=\"prodetailhd\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" </div>\n\t\t\t\t\t\t<div class=\"pinfodetail\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<br>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</br>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\n\t\t\t\n\t\t\t\t\n\t\t\t</div>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<div class=\"detailpanelpage\">\n\t\t\t<div class=\"ssss\" >\t\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</span>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\n\t\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</div>\n\t\t</div>\n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\n\t<div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String strRoomCode="";
	String str_append="rs";
	int from = 0; 
	int to = 0;	
	int autoRefreshTime = 0;
	int frameCountStyle = 0;
	int bookingCount = 0;
	int noOfPatients = 0;
	String fromTime = "";
	String toTime = "";
	String operDuration = "";
	String operDurationHr = "";
	int operDurationMin = 0;
	String operTime = "";
	int operHr = 0;
	int operMin = 0;
	String anestStaffName = "";
	String nurseStaffName = "";
	String room_no = request.getParameter("room_no") == null ? "" : request.getParameter("room_no");
	String room_name = request.getParameter("room_name") == null ? "" : request.getParameter("room_name");
	String statusBeanId = "PatientRoomStatusBean_" + room_no;
	String statusBeanName = "eOT.PatientRoomStatusBean";
	String fromMenu = request.getParameter("fromMenu");
	String ClassStyle="";
	String unSchedStatus="";
	String unSchedColorCode="";
	String str_comma=",";
	PatientRoomStatusBean patientRoomStatusBean = (PatientRoomStatusBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
	String bean_id	 = "OT_Slate_Bean_" + room_no;
	String bean_name = "eOT.OT_Slate_Bean";
	OT_Slate_Bean bean	 = (OT_Slate_Bean)mh.getBeanObject( bean_id, request, bean_name );

	String frameCount = request.getParameter("frameCount") == null ? "1" : request.getParameter("frameCount");
	String staffAssignmentId = request.getParameter("staffAssignmentId") == null ? "" : request.getParameter("staffAssignmentId");
	
	frameCountStyle = Integer.parseInt(frameCount);
	if(staffAssignmentId != null && staffAssignmentId.equalsIgnoreCase("Y"))
		frameCountStyle = Integer.parseInt(frameCount) + 1;
	
	String Class_Multi_Single	= frameCountStyle==1 ? "singlecol_patientinfopanel" : "patientinfopanel";
	if(frameCount != null && frameCount.equals("1") && frameCountStyle==1)
		noOfPatients = 6;
	else
		noOfPatients = 3;

	String refreshIntervalId = request.getParameter("refreshIntervalId") == null ? "1" : request.getParameter("refreshIntervalId");
	String intervalId = request.getParameter("intervalId") == null ? "" : request.getParameter("intervalId");

	ArrayList<OT_Slate_Bean> dataList = bean.getBookingDtlsCount(room_no);
	if(dataList!=null && dataList.size()>0)
	{
		for(OT_Slate_Bean dataListVal : dataList)
		{
			if(dataListVal.getTotalBookingCount() != null && dataListVal.getTotalBookingCount().trim().length() > 0)
			bookingCount = Integer.parseInt(dataListVal.getTotalBookingCount());
			else
				bookingCount = 0;
			fromTime = dataListVal.getStrFromTime();
			toTime = dataListVal.getStrToTime();
		}
	}

	if(patientRoomStatusBean.NO_OF_PATIENTS != noOfPatients)
	{
		patientRoomStatusBean.NO_OF_PATIENTS = noOfPatients;
		patientRoomStatusBean.clear();
		patientRoomStatusBean.populateInformation(bookingCount);
	}
	Map<String,Integer> pageInfoMap = patientRoomStatusBean.getCurrentPageInformation();
	from = pageInfoMap.get("FROM");
	to = pageInfoMap.get("TO");

	if(intervalId != null && intervalId.equalsIgnoreCase("SS"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId);
	else if(intervalId != null && intervalId.equalsIgnoreCase("MM"))
		autoRefreshTime = Integer.parseInt(refreshIntervalId) * 60;
	response.setIntHeader("Refresh", autoRefreshTime);
	Map<String, List<OT_Slate_Bean>> beanMap = bean.getBookingDtls(room_no, String.valueOf(from), String.valueOf(to));
	List<OT_Slate_Bean> beanList = beanMap.get("ROOMDETAILS");
	List<OT_Slate_Bean> beanList1 = bean.getAnaesthetistDtls(room_no);
	List<OT_Slate_Bean> beanList2 = bean.getStaffDtls(room_no);
	String bean_id1	 = "OTWidgetSelectionBean";
	String bean_name1 = "eOT.OTWidgetSelectionBean";

	OTWidgetSelectionBean bean1	 = (OTWidgetSelectionBean)mh.getBeanObject( bean_id1, request, bean_name1 );
	Map map =  bean1.getWidgetDtls();
	if(beanList!=null && beanList.size()>0)
	{
		for(OT_Slate_Bean otSlateBean : beanList)
		{
			strRoomCode = CommonBean.checkForNull((String)otSlateBean.getStrOperRoomCode());
		}
	}
	if(strRoomCode == null || strRoomCode.trim().length() == 0)
		strRoomCode = room_name;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getParameter("class")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(room_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bookingCount));
            _bw.write(_wl_block16Bytes, _wl_block16);

									if(fromTime != null && fromTime !="")
									{
								
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(CommonBean.checkForNull((String)fromTime)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CommonBean.checkForNull((String)toTime)));
            _bw.write(_wl_block19Bytes, _wl_block19);

									}
								
            _bw.write(_wl_block20Bytes, _wl_block20);

										for(OT_Slate_Bean getAnaesthetistdtl : beanList1) 
											{
											if(anestStaffName != null && !anestStaffName.equals(getAnaesthetistdtl.getRoleTypeDescSysDef()))
											{
												anestStaffName = getAnaesthetistdtl.getRoleTypeDescSysDef();

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(getAnaesthetistdtl.getRoleTypeDescSysDef()));
            _bw.write(_wl_block22Bytes, _wl_block22);

											}
										
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(getAnaesthetistdtl.getStrSurgeon()));
            _bw.write(_wl_block24Bytes, _wl_block24);

											}
										
            _bw.write(_wl_block25Bytes, _wl_block25);

										for(OT_Slate_Bean getStaffDtls : beanList2) 
										{
											if(nurseStaffName != null && !nurseStaffName.equals(getStaffDtls.getRoleTypeDescSysDef()))
											{
												nurseStaffName = getStaffDtls.getRoleTypeDescSysDef();

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(getStaffDtls.getRoleTypeDescSysDef()));
            _bw.write(_wl_block22Bytes, _wl_block22);

											}
									
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(getStaffDtls.getStrStaff()));
            _bw.write(_wl_block27Bytes, _wl_block27);

										}
									
            _bw.write(_wl_block28Bytes, _wl_block28);

				if(beanList!=null && beanList.size()>0)
				{
					for(OT_Slate_Bean otSlateBean : beanList)	
					{
						operTime = CommonBean.checkForNull((String)otSlateBean.getStrOperNum());
					if(operTime != null && operTime.trim().length() > 0 && operTime.indexOf(":") != -1)
					{
							if(operTime.contains(","))
							{
		                     	int totalmin=0;		  
					 String[] splits = operTime.split(",");
								for(int spltime=0; spltime<splits.length; spltime++)
								{
					  int splhours=0;int splmin=0;	
					  String asset=splits[spltime];		
					  splhours = Integer.parseInt(asset.substring(0, asset.indexOf(":")));
					if(splhours > 0)
						splhours = splhours * 60;
					    totalmin =totalmin+Integer.parseInt(asset.substring(asset.indexOf(":") + 1, asset.length())) + splhours;
					  }
					  operMin=totalmin;
							}
							else
							{
					   operHr = Integer.parseInt(operTime.substring(0, operTime.indexOf(":")));
					   if(operHr > 0)
						  operHr = operHr * 60;
					      operMin = Integer.parseInt(operTime.substring(operTime.indexOf(":") + 1, operTime.length())) + operHr;					 
					 }
					}
					String caseType=CommonBean.checkForNull((String)otSlateBean.getCaseType());
					
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Class_Multi_Single));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrPatientID())));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrFromTime())));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrToTime())));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrDisplayStatus())));
            _bw.write(_wl_block34Bytes, _wl_block34);

												if((String)otSlateBean.getStrDisplayTime() != null && ((String)otSlateBean.getStrDisplayTime()).trim().length() > 0)
												{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrDisplayTime())));
            _bw.write(_wl_block2Bytes, _wl_block2);

												}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrColorCode())));
            _bw.write(_wl_block37Bytes, _wl_block37);

										if(caseType.equals("0"))
										{
									ClassStyle="";
									unSchedStatus = "UnScheduled";		
									unSchedColorCode = "style='color:#FF0000'";		
									
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(unSchedColorCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(unSchedStatus));
            _bw.write(_wl_block40Bytes, _wl_block40);

													}	
												
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrPatientName())));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(otSlateBean.getStrAge()+""+str_append));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrGender())));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrShortDesc())));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrOperDesc())));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrSurgeonName())));
            _bw.write(_wl_block49Bytes, _wl_block49);

						if(((String)otSlateBean.getStrSurgeonName() != null && ((String)otSlateBean.getStrSurgeonName()).trim().length() > 0) && ((String)otSlateBean.getStrAsstSurgeonOne() != null && ((String)otSlateBean.getStrAsstSurgeonOne()).trim().length() > 0))
							{
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(str_comma));
            _bw.write(_wl_block49Bytes, _wl_block49);

						}
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrAsstSurgeonOne())));
            _bw.write(_wl_block49Bytes, _wl_block49);

									if(((String)otSlateBean.getStrAsstSurgeonOne() != null && ((String)otSlateBean.getStrAsstSurgeonOne()).trim().length() > 0) && ((String)otSlateBean.getStrAsstSurgeonTwo() != null && ((String)otSlateBean.getStrAsstSurgeonTwo()).trim().length() > 0))
						{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_comma));
            _bw.write(_wl_block49Bytes, _wl_block49);

						}
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(CommonBean.checkForNull((String)otSlateBean.getStrAsstSurgeonTwo())));
            _bw.write(_wl_block50Bytes, _wl_block50);
 
				}
				}

            _bw.write(_wl_block51Bytes, _wl_block51);

		if(beanList!=null && beanList.size()>0)
		{
	
            _bw.write(_wl_block52Bytes, _wl_block52);

						String span1Class = "";
						String span2Class = "";
						String span3Class = "";
						if(pageInfoMap.get("PAGE_NO_1") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span1Class = "selectedpagePagination";
							span2Class = "unselectedpagePagination";
							span3Class = "unselectedpagePagination";
						}
						else if(pageInfoMap.get("PAGE_NO_2") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span2Class = "selectedpagePagination";
							span1Class = "unselectedpagePagination";
							span3Class = "unselectedpagePagination";
						}
						else if(pageInfoMap.get("PAGE_NO_3") == pageInfoMap.get("CURRENT_PAGE"))
						{
							span3Class = "selectedpagePagination";
							span1Class = "unselectedpagePagination";
							span2Class = "unselectedpagePagination";
						}
						int pageNo2 = pageInfoMap.get("PAGE_NO_2");
						int pageNo3 =  pageInfoMap.get("PAGE_NO_3");
					
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(span1Class));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_1") ));
            _bw.write(_wl_block55Bytes, _wl_block55);

						if(patientRoomStatusBean.getNoOfPages() >= pageNo2)
						{
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(span2Class));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_2") ));
            _bw.write(_wl_block55Bytes, _wl_block55);

						}
						if(patientRoomStatusBean.getNoOfPages() >= pageNo3)
						{
					
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(span3Class));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pageInfoMap.get("PAGE_NO_3") ));
            _bw.write(_wl_block55Bytes, _wl_block55);

						}
					
            _bw.write(_wl_block57Bytes, _wl_block57);

		}
	
            _bw.write(_wl_block58Bytes, _wl_block58);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationRoom.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Bookings.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
