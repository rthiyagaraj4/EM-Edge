package jsp_servlet._eipad._jsp._chartwidgets._orders;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eIPAD.chartsummary.orderentry.bc.MOrderEntryBC;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __moeitemselection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/orders/MoeItemSelection.jsp", 1738426356664L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!DOCTYPE html>\n<html> \n<head> \n<title></title>  \n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/kendo.default.min.css\" />\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/js/lib/kendo/kendo2013q3/kendo.web.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/js/lib/kendo/kendo2013q3/kendo.mobile.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/js/lib/kendo/kendo2013q3/kendo.mobile.scroller.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/console.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/jquery.mobile-1.0.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/css/iPADThemeA.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/css/iPADNew.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/js/iscroll.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/css/PlaceOrders.css\" />\n<script src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/js/PlaceOrders.js\"></script>\n\n<script type=\"text/javascript\">\n\n\n\n\n\n\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\n<style>\n\n\n</style>\n</head>\n<body style=\"display: block; margin: 0px; height: 100%; width: 100%;\">\n<form id=\"ChartSummaryForm\" name = \"ChartSummaryForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" onclick=\"\" data-popid=\"\"></div>\n<div id=\"OrdSearchSFS\" class=\"orderSearchSfs\" style=\"display:none\" >\n\t<div id=\"sfsarrow\" data-role=\"none\" class=\"sfs-bubble-arrow sfs-bubble-arrowIPTheme\"></div>\n\t<div data-role=\"none\" class=\"ordSfsSmall sfsIPTheme\"  style=\"display:block\">\n\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" height=\"300px\" width=\"340px\" src=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/jsp/chartwidgets/orders/MoeAddlSearchCrit.jsp\"></iframe>  \n\t</div> \n</div>\n\n<div class=\"ordSelParent\"> \n\t<!--  Header START-->\n\t<div class=\"ordSelHeaderMenu\">\n\t\t<div class=\"ordSelHeaderMenuCont\">\n\t\t\t<div class=\"row\">\n\t\t\t\t<div class=\"ordSelMenuCont\">\n\t\t\t\t\t<div class=\"ordSelMenuIconbg\">\n\t\t\t\t\t\t<div class=\"ordSelMenuIcon\"> </div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ordSelMenuCont ordSelMenuTitle\"> Order </div>\n\t\t\t\t<div class=\"ordSelMenuright ordSelHeaderBtnTheme\" id=\"OrderSelectMaximizeBtn\" onclick=\"maximizeOrderSel_selpage()\">\n\t\t\t  \t\t<div class=\"ordSelHdrBtnIcon\"><img src=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/max.PNG\" width=\"12\" height=\"13\" id=\"OrderSelectMaximizeImg\" /></div>\n\t\t\t  \t</div>\n\t\t\t\t<div class=\"ordSelMenuright ordSelHeaderBtnTheme\" onClick=\"toggleAddlSearch()\">\n\t\t\t  \t\t<div class=\"ordSelHdrBtnIcon\"><img src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/Search.png\" width=\"16\" height=\"16\" /></div>\n\t\t\t  \t</div>\n\t\t\t\t<div class=\"ordSelMenuright\">\n\t\t\t\t  \t<div class=\"ordTickDropdownContTheme\" data-role=\"none\">\n\t\t\t\t    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<select name=\"cmbTickSheetSelect\" id=\"cmbTickSheetSelect\" id=\"cmbTickSheetSelect\" data-role=\"none\">\n\t\t\t\t\t\t\t<option>Select TickSheet</option>\n\t\t\t\t  \t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\tinitTicksheetCombo();\n\t\t\t\t\t\t});\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\t<!--  Header END--> \n  \n  \t<!-- Ticksheet Combo START-->\n  \n\t<div class=\"tickSectComboCont\" id=\"TickSectCombocontainer\">\n    \t<div  class=\"tickSectCombo\" style=\"height:40px;position: relative;\">\n    \t\t<input id=\"cmbTicksheetSection\" name=\"cmbTicksheetSection\" id=\"cmbTicksheetSection\" data-type=\"ComboBox\" data-role=\"none\" />\n\t\t    <script>\n\t\t\t\t/* $(document).ready(function() {\n\t\t\t\t\tinitTicksheetSectCombo();\n\t\t\t\t}); */\n\t\t\t</script>\n\t\t</div>\n  \t</div>\n  \n  <!-- Ticksheet Combo END-->\n        <style>\n\n      \n      \n      </style>\n  <!-- Order Results START -->\n\t<div class=\"ordSelItemsCont\">\n    \t<div class=\"ordItemsCont\">\n    \t<!-- Panel Order Results START -->\n\t\t\t<div class=\"table ordItemsBox3\" id=\"Panel_Orders\" style=\"display:none\">\n\t\t\t\t<div class=\"ordItemBoxIn\">\n\t\t\t  \t\t<div class=\"ordItemBoxTable\">\n\t\t\t    \t\t<div class=\"row ordItemBoxRowHd\">\n\t\t\t      \t\t\t<div class=\"ordItemBoxCellHd\">\n\t\t\t        \t\t\t<div class=\"table\" style=\"width:100%;\">\n              \t\t\t\t\t\t<div  class=\"row\">\n              \t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t        \t\t\t<div class=\"ordItemBoxHdr\">\n\t\t\t\t\t\t          \t\t\t\t<div class=\"ordItemBoxHdrTxt\">Panel<span id=\"Panel_Count\"></span></div>\n\t\t\t\t\t\t        \t\t\t</div>\n\t\t\t\t        \t\t\t\t</div>\n\t\t\t\t        \t\t\t</div>\n\t\t\t        \t\t\t</div>\n\t\t\t      \t\t\t</div>\n\t\t\t    \t\t</div>\n\t\t\t    \t\t<div class=\"row ordItemBoxRowCon\">\n\t\t\t      \t\t\t<div class=\"ordItemBoxRowConCell\" style=\"position:relative;\">\n\t\t\t\t      \t\t\t<div class=\"table\">\n              \t\t\t\t\t\t<div  class=\"row\">\n              \t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t      \t\t\t<div> <iframe name=\"Panel_Frame\" id=\"Panel_Frame\"  src=\"\" scrolling=\"yes\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" vspace=\"0\" hspace=\"0\" \n\t\t\t\t                         \t\t\tstyle=width:100%;height:100%;position:absolute;\"></iframe>\n\t\t\t\t\t\t\t      \t\t\t</div>\n\t\t\t\t\t\t      \t\t\t</div>\n\t\t\t\t\t      \t\t\t</div>\n\t\t\t\t      \t\t\t</div>\n\t\t\t      \t\t\t</div>\n\t\t\t    \t\t</div>\n\t\t\t  \t\t</div>\n\t\t\t\t</div>\n\t     \t</div>\n      <!-- Panel Order Results END -->\n\n      <!-- OrderSet Order Results START -->\n      \t\t<div class=\"table ordItemsBox3\" id=\"OrderSet_Orders\" style=\"display:none\">\n        \t\t<div class=\"ordItemBoxIn\">\n\t\t\t\t\t<div class=\"ordItemBoxTable\">\n            \t\t\t<div class=\"row ordItemBoxRowHd\">\n              \t\t\t\t<div class=\"ordItemBoxCellHd\">\n                \t\t\t\t<div class=\"table\" style=\"width:100%;\">\n              \t\t\t\t\t\t<div  class=\"row\">\n              \t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t                \t\t\t\t<div class=\"ordItemBoxHdr\">\n\t\t\t                  \t\t\t\t\t<div class=\"ordItemBoxHdrTxt\">Order Set<span id=\"OrderSet_Count\"></span></div>\n\t\t\t                \t\t\t\t</div>\n\t\t                \t\t\t\t</div>\n\t\t                \t\t\t</div>\n                \t\t\t\t</div>\n              \t\t\t\t</div>\n            \t\t\t</div>\n            \t\t\t<div class=\"row ordItemBoxRowCon\">\n              \t\t\t\t<div class=\"ordItemBoxRowConCell\" style=\"position:relative;\">\n              \t\t\t\t\t<div class=\"table\">\n              \t\t\t\t\t\t<div  class=\"row\">\n              \t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t              \t\t\t\t\t<div><iframe name=\"OrderSet_Frame\" id=\"OrderSet_Frame\"  src=\"\" scrolling=\"yes\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" vspace=\"0\" hspace=\"0\" \n\t\t\t\t                         \t\t\tstyle=width:100%;height:100%;position:absolute;\"></iframe> \n\t\t\t\t\t\t\t      \t\t\t</div>\n\t\t\t\t\t\t      \t\t\t</div>\n\t\t\t\t\t\t      \t\t</div>\n\t\t\t\t      \t\t\t</div>\n\t\t\t\t\t\t\t</div>\n            \t\t\t</div>\n          \t\t\t</div>\n        \t\t</div>\n      \t\t</div>\n      <!-- OrderSet Order Results END -->\n    \n    \t<!-- Individual Order Results START -->\n      \t\t<div class=\"table ordItemsBox3\" id=\"Individual_Orders\" style=\"display:none\">\n        \t\t<div class=\"ordItemBoxIn\">\n          \t\t\t<div class=\"ordItemBoxTable\">\n\t\t\t\t\t\t<div class=\"row ordItemBoxRowHd\">\n              \t\t\t\t<div class=\"ordItemBoxCellHd\">\n              \t\t\t\t\t<div class=\"table\" style=\"width:100%;\">\n              \t\t\t\t\t\t<div  class=\"row\">\n              \t\t\t\t\t\t\t<div class=\"cell\">\n             \t\t\t\t\t\t\t\t<div class=\"ordItemBoxHdr\">\n                 \t\t\t\t\t\t\t\t<div class=\"ordItemBoxHdrTxt\">Individual<span id=\"Individual_Count\"></span></div>\n               \t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t</div>\n              \t\t\t\t\t</div>\n              \t\t\t\t</div>\n            \t\t\t</div>\n            \t\t\t<div class=\"row ordItemBoxRowCon\">\n              \t\t\t\t<div class=\"ordItemBoxRowConCell\" style=\"position:relative;\">\n              \t\t\t\t\t<div class=\"table\">\n              \t\t\t\t\t\t<div  class=\"row\">\n              \t\t\t\t\t\t\t<div class=\"cell\">\n\t\t              \t\t\t\t\t\t<div>\n\t\t\t\t\t\t      \t\t\t\t <iframe name=\"Individual_Frame\" id=\"Individual_Frame\"  src=\"\" scrolling=\"yes\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" vspace=\"0\" hspace=\"0\" \n\t\t\t                         \t\t\tstyle=width:100%;height:100%;position:absolute;\"></iframe>\n\t\t\t\t\t\t      \t\t\t\t</div>\n\t\t\t\t      \t\t\t\t\t</div>\n\t\t\t\t      \t\t\t\t</div>\n\t\t\t\t      \t\t\t</div>\n              \t\t\t\t</div>\n\t\t\t            </div>\n\t\t\t\t\t</div>\n\t\t\t   \t</div>\n\t\t\t</div>\n      <!-- Individual Order Results END -->\n      \n      <!-- No Results START -->\n      <div id=\"No_Orders\" style=\"display:none\">No Orders were found</div>\n      \n      <!-- No Results END -->\n\t\t</div>\n\t</div>\n  <!-- Order Results END -->\n</div>\n<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
String or_bean_name = "eOR.OrderEntryBean";
OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);

MOrderEntryBC bc = new MOrderEntryBC();
MOrderEntryFieldResponse tickSheetListResponse = bc.getTickSheetList(bean, null, true);
ArrayList<MOrderEntryFieldItem> tickSheetList = tickSheetListResponse.getFieldItems();

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(tickSheetListResponse.getResponseStatus()!=tickSheetListResponse.FIELD_DATAFETCH_FAILURE && tickSheetList!=null && !tickSheetList.isEmpty()){ 
            _bw.write(_wl_block23Bytes, _wl_block23);

						MOrderEntryFieldItem tickSheetItem;
						for(int i=0;i<tickSheetList.size();i++) {
						 	tickSheetItem = tickSheetList.get(i);
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tickSheetItem.getCode() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tickSheetItem.getDesc() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
  } 
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
