package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.Common.DlQuery;
import eCommon.Common.CommonBean;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eDS.*;
import eDS.MealClassServlet;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealclassaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealClassAddModify.jsp", 1728218090000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" <!--Added Against ML-MMOH-CRF-1005-US1 -->\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eDS/js/MealClass.js\'></script>\n<script language=\'javascript\' src=\'../../eDS/js/DSCommon.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onload=\"parent.commontoolbarFrame.document.forms[0].apply.disabled=false;\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<br>\n\t\t<form name=\"mealClass_form\" id=\"mealClass_form\"  onload=\'FocusFirstElement()\'  action=\"../../servlet/eDS.MealClassServlet\" method=\"post\" target=\"messageFrame\">\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"mealClass\" id=\"mealClass\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onkeypress=\"restrictSpecialChars(event)\" size=\"4\" maxlength=\"2\" onkeyup=\"setFieldToUpperCase(this)\"  onkeypress=\"return checkAlpha(event)\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"longDesc\" id=\"longDesc\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  onkeypress=\"restrictSpecialChars(event)\" size=\"30\" maxlength=\"30\" />\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"shortDesc\" id=\"shortDesc\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onkeypress=\"restrictSpecialChars(event)\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<!-- ML-MMOH-CRF-0419-US8 Starts-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"applstafforder_yn\" id=\"applstafforder_yn\"  checked=\"checked\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"applstafforder_yn\" id=\"applstafforder_yn\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"applstafforder_yn\" id=\"applstafforder_yn\" checked=\"checked\" />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- ML-MMOH-CRF-0669-US1 Starts-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"editmenuappl_yn\" id=\"editmenuappl_yn\"  checked=\"checked\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"editmenuappl_yn\" id=\"editmenuappl_yn\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"editmenuappl_yn\" id=\"editmenuappl_yn\" checked=\"checked\" />\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\t<!-- ML-MMOH-CRF-0669-US1 Ends-->\n\t\t\t\t\t<!-- ML-MMOH-CRF-1005-US1 Starts Here-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<option>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"attdntorderappl_yn\" id=\"attdntorderappl_yn\"  checked=\"checked\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"attdntorderappl_yn\" id=\"attdntorderappl_yn\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"attdntorderappl_yn\" id=\"attdntorderappl_yn\"  checked=\"checked\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- ML-MMOH-CRF-1005-US1 Ends Here-->\n\t\t\t\t\t\n\t\t\t\t<!--Added Start Against 673 CRF-->\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t<div id=\"MealClassCheck\" style=\"visibility:visible;overflow:auto;height: 20vh;width: 300px;border: 1px outset white\" align=\"left\" >\n\t\t\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<input id=\"bedClassId";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" name=\"check\" type=\"checkbox\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="  onclick=\"checkValue(this)\";/>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<BR>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" onclick=\"checkValue(this)\";/>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<!-- Insert mode -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<BR>\n\t\t\t\t\t<input type=\"hidden\" id=\"bedclassValue";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" name=\"bedClassValue";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!--Added End Against 673 CRF-->\n\t\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"enabledYn\" id=\"enabledYn\"  checked=\"checked\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"enabledYn\" id=\"enabledYn\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"enabledYn\" id=\"enabledYn\"  checked=\"checked\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'> \n\t\t\t<input type=\'hidden\' name=\'updMealClass\' id=\'updMealClass\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t<input type=\'hidden\' name=\"bedClassCode\" id=\"bedClassCode\" value=\"\"/>\n\t\t</form>\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );
 
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
 
	String locale = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            {DSCommonBeanObj.setFacilityId(session.getAttribute("facility_id").toString()
                );
            }_bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String mealClass = "";
	String shortDesc = "";
	String longDesc = "";
	String enabledYn = "";
	String mealClassCode = request.getParameter("mealClass");	
	String disabled_flag = "";
	String readOnlyFlag = "";
	String applstafforder_yn="";//ML-MMOH-CRF-0419-US8
	String editmenuappl_yn ="";//ML-MMOH-CRF-0669-US1
	String attdntorderappl_yn ="";//ML-MMOH-CRF-1005-US1
	//ML-MMOH-CRF-0673
	String bedClassCode ="";
	//ML-MMOH-CRF-0673
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String mode = request.getParameter("mode");
	//ML-MMOH-CRF-0673
	try{
	TreeMap<String,String> mealMap = new TreeMap<String,String>();
	ConcurrentHashMap<String,String> bedMap = DSCommonBeanObj.getBedClass(locale);
	TreeMap<String,String> Temp_map = new TreeMap<String,String>();
	//TreeMap<String,String> Check_map = new TreeMap<String,String>();
	TreeMap<String,String> initMealMap = new TreeMap<String,String>();
	String chk1="";
	String disabled="";
	//ArrayList<String> codesList = new ArrayList<String>(); // checkstyle
	Set<String> tempSet = new HashSet<String>();
	HashMap<String,String> getmealMap = DSCommonBeanObj.getMealClass();	
	//ML-MMOH-CRF-0673
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_CLASS);
	   		pstmt.setString(1,mealClassCode);
	   		rst = pstmt.executeQuery();
			while(rst.next()){
	   			mealClass = rst.getString("meal_class");
	   			longDesc = rst.getString("long_desc");
				shortDesc = rst.getString("short_desc");
				enabledYn = rst.getString("eff_status");
				applstafforder_yn = rst.getString("appl_staff_order_yn"); //ML-MMOH-CRF-0419-US8
				editmenuappl_yn =rst.getString("EDIT_MENU_APPL_YN");//ML-MMOH-CRF-0669-US1
				bedClassCode =rst.getString("BED_CLASS_CODE");//ML-MMOH-CRF-0673
				attdntorderappl_yn =rst.getString("APPL_ATT_YN");//ML-MMOH-CRF-1005-US1
	   		}
			//ML-MMOH-CRF-0673
			
			if(bedClassCode !=null){
			String[] myStrArr = bedClassCode.split(",");
			for( int i=0 ; i<myStrArr.length ; i++){
				String str_ip_bed_class=  "SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? AND BED_CLASS_CODE=? ORDER BY 2 ";
				pstmt = con.prepareStatement(str_ip_bed_class);			
		   		pstmt.setString(1,locale);
		   		pstmt.setString(2,myStrArr[i]);
		   		rst = pstmt.executeQuery();
	   		while(rst.next()){
				mealMap.put(rst.getString("BED_CLASS_CODE"),rst.getString("SHORT_DESC"));
				}		
			} 			
			Temp_map.putAll(mealMap);
			mealMap.putAll(bedMap);
			}			
			//ML-MMOH-CRF-0673
			
			for (String temp : getmealMap.values()) { // Part-1
			StringTokenizer st = new StringTokenizer(temp, ",");
			String[] tempArr = new String[st.countTokens()];

			for (int i = 0; i < tempArr.length; i++) {
				tempArr[i] = st.nextToken();
				tempArr[i] = tempArr[i].trim();
				tempSet.add(tempArr[i].toString());
			}
			}
			for (String tempString : tempSet){ // Part-2
			StringTokenizer st1 = new StringTokenizer(tempString, ",");
			String[] myStrArr = new String[st1.countTokens()];
			for( int j=0 ; j<myStrArr.length ; j++){
				myStrArr[j] = st1.nextToken();
				myStrArr[j] = myStrArr[j].trim();
				String str_ip_bed_class=  "SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? and bed_class_code=? ";
				pstmt = con.prepareStatement(str_ip_bed_class);			
		   		pstmt.setString(1,locale);
		   		pstmt.setString(2,myStrArr[j]);
		   		rst = pstmt.executeQuery();
	   		while(rst.next()){
				initMealMap.put(rst.getString("BED_CLASS_CODE"),rst.getString("SHORT_DESC"));
				}		
			}
		}  // Part-2 ending 
  	}catch(Exception e){
	   		System.err.println("100,Error in Modify Mode Meal Class->"+e);
			e.printStackTrace();
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("110,Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
   }else{
   		try{
   			con = ConnectionManager.getConnection(request);
			for (String temp : getmealMap.values()) {
			StringTokenizer st = new StringTokenizer(temp, ",");
			String[] tempArr = new String[st.countTokens()];
			for (int i = 0; i < tempArr.length; i++) {
				tempArr[i] = st.nextToken();
				tempArr[i] = tempArr[i].trim();
				tempSet.add(tempArr[i].toString());
			}
				}
			for(String tempString : tempSet) {
			StringTokenizer st1 = new StringTokenizer(tempString, ",");
			String[] myStrArr = new String[st1.countTokens()];
			for( int j=0 ; j<myStrArr.length ; j++){
				myStrArr[j] = st1.nextToken();
				myStrArr[j] = myStrArr[j].trim();
				String str_ip_bed_class=  "SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? and bed_class_code=? ";
				pstmt = con.prepareStatement(str_ip_bed_class);			
		   		pstmt.setString(1,locale);
		   		pstmt.setString(2,myStrArr[j]);
		   		rst = pstmt.executeQuery();
	   		while(rst.next()){
				initMealMap.put(rst.getString("BED_CLASS_CODE"),rst.getString("SHORT_DESC"));
				}		
			}
		 }
		}catch(Exception e){
	   		System.err.println("170,Error in Meal Class->"+e);
			e.printStackTrace();
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("179,Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
}  

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mealClass ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disabled_flag ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(longDesc ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(shortDesc ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if("modify".equals(mode)){
							if("Y".equals(applstafforder_yn)){
							
            _bw.write(_wl_block18Bytes, _wl_block18);
}
							else{
							
            _bw.write(_wl_block19Bytes, _wl_block19);
}
						}
						else{ 
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if("modify".equals(mode)){
							if("Y".equals(editmenuappl_yn)){
							
            _bw.write(_wl_block22Bytes, _wl_block22);
}
							else{
							
            _bw.write(_wl_block23Bytes, _wl_block23);
}
						}
						else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(DSCommonBeanObj.getAttendantLabel()));
            _bw.write(_wl_block27Bytes, _wl_block27);
if("modify".equals(mode)){
							if("Y".equals(attdntorderappl_yn)){
							
            _bw.write(_wl_block28Bytes, _wl_block28);
}
							else{
							
            _bw.write(_wl_block29Bytes, _wl_block29);
}
						}
						else{ 
            _bw.write(_wl_block30Bytes, _wl_block30);
} 
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if("modify".equals(mode)){						
					int j = 0;
					boolean value1 = Temp_map.isEmpty();
					if(value1==true){
					 for (String keymap : bedMap.keySet()) {  //Part-3
						if(initMealMap.containsKey(keymap)){			
							disabled="disabled";	
						}
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(keymap));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedMap.get(keymap)));
            _bw.write(_wl_block37Bytes, _wl_block37);
j++;
					disabled="";	
					}
					}else{
					mealMap.putAll(bedMap);
					for(String key : mealMap.keySet()){
					
					if(Temp_map.containsKey(key)){
							chk1="checked";
					}else if(initMealMap.containsKey(key)){			
							disabled="disabled";	
					}
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(key));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(chk1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(mealMap.get(key)));
            _bw.write(_wl_block37Bytes, _wl_block37);
j++;
					chk1="";
					disabled="";
					}
					}
					}
					else{ 
            _bw.write(_wl_block40Bytes, _wl_block40);

					int i = 0;
					for(String key : bedMap.keySet()){
					if(initMealMap.containsKey(key)){			
					disabled="disabled";
					}
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(key));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( bedMap.get(key)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(key));
            _bw.write(_wl_block44Bytes, _wl_block44);
 //i++;
					disabled="";
						}
					}
					
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if("modify".equals(mode)){
							if("E".equals(enabledYn)){
							
            _bw.write(_wl_block46Bytes, _wl_block46);
}
							else{
							
            _bw.write(_wl_block47Bytes, _wl_block47);
}
						}
						else{ 
            _bw.write(_wl_block48Bytes, _wl_block48);
} 
            _bw.write(_wl_block49Bytes, _wl_block49);
}catch(Exception e){
							System.err.println("e====="+e.getMessage());
							e.printStackTrace();
						}
						finally
						{
							try{						
							}
								catch(Exception ee){
								ee.printStackTrace();	
							}
						}
						
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.LongDescription.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ShortDescription.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ApplForStaffOrder.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ApplicableEditMenu.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ApplicableFor.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DefaultMealClassforBedClasses.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Enabled.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
