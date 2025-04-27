package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.util.ArrayList;
import eDS.Common.JSONObject;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __displayoldsupplementaryorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DisplayOldSupplementaryOrder.jsp", 1738425190000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- This file created against MMS-QH-CRF-0079  for September 2016 Release -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\t\t\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../framework/js/PopupWindow.js\" type=\"text/javascript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\t\t\n\t\t<script language=\"Javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n\t\t<!-- script language=\"Javascript\" src=\"../../eDS/js/PlaceSupplementaryOrder.js\"></script-->\n\t\t<style>\n\t\t\n\t\t\n\t.thwrap{\n\t\t\tposition: relative;\n            top: expression(this.offsetParent.scrollTop);\n\t\t\t/*white-space:nowrap;*/\n\t\t\t/*color:#ff0000;*/\n\t\t\tfont-size:12px;\n\t\t\twidth:auto;\t\t\n\t\t\tbackground: url(\"../images/headerSeparator.jpg\") repeat-y;\n\t\t\tbackground-position:right;\n\t\t\tCOLOR: white ;\n\t\t\tbackground-color:#83AAB4;\n\t\t\tborder:2px;\n\t\t\tpadding-left:3px;\n\t\t\tfont-family: Verdana;\n\t\t\tfont-size: 8pt;\n\t\t\t/*font-weight:bold;*/\n\t\t\tborder-collapse:collapse; \n\t\t\t/*position:absolute;*/\n\t\t\tleft:0;\t\t\n\t\t\n\t\t\t}\n\t\t\t.datawrap{\n\t\t\t/*align:center;*/\n\t\t</style>\n\t\t<script type=\"text/javascript\">\n\t\tforViewAllTable\t=function(){\n\n\t\t\tvar table\t\t= $(\'#ViewOldSupplementaryOrders\');\n\n\t\t\t$(\"#ViewOldSupplementaryOrders\").find(\"tr\").remove();\n\t\t\t\n\t\t\tvar row=$(\'<tr><th>\'+getLabel(\"Common.date.label\",\"common\")+\'</th></tr>\').addClass(\"thwrap\").appendTo(table);\n\t\t\t\n\t\t\t$(\'<th>\'+getLabel(\"eDS.SupplementaryDietFor.Label\",\"DS\")+\'</th>\').appendTo(row);\n\t\t\t$(\'<th>\'+getLabel(\"eOT.ItemType.Label\",\"ot_labels\")+\'</th>\').appendTo(row);\n\t\t\t$(\'<th>\'+getLabel(\"eDS.FoodItem.Label\",\"DS\")+\'</th>\').appendTo(row);\n\t\t\t$(\'<th>\'+getLabel(\"eOT.qty.Label\",\"ot_labels\")+\'</th>\').appendTo(row);\n\t\t\t$(\'<th>\'+getLabel(\"eDS.MealType.Label\",\"DS\")+\'</th>\').appendTo(row);\n\t\t\t$(\'<th>\'+getLabel(\"Common.Instructions.label\",\"common\")+\'</th>\').appendTo(row);\n\t\t\t\n\t\t\tvar params=\"mode=Get_OLD_SUPPLEMENTARY_MEAL_ORDER\";\n\t\t\tvar locale=$(\"#locale\").val();\n\t\t\tvar encounter_id=$(\"#encounter_id\").val();\n\t\t\tvar facility_id=$(\"#facility_id\").val();\n\t\t\t\n\t\t\tparams+=\"&encounter_id=\"+encounter_id;\n\t\t\tparams+=\"&locale=\"+locale;\n\t\t\tparams+=\"&facility_id=\"+facility_id;\n\t\t\t\t\t\t\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\n\t\t\txmlHttp.open(\"POST\", \"../../servlet/eDS.SupplementaryOrderServlet?\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar retVal = xmlHttp.responseText;\t\n\t\t\t\n\t\t\tvar jsonObjResponse=eval(\'(\' + retVal + \')\');\t\n\n\t\t\tvar tempSupplementaryMeals=new Array();\n\t\t\ttempSupplementaryMeals = jsonObjResponse;\n\t\t\t\n\t\t\t$.each(tempSupplementaryMeals, function (i, item){\n\t\t\t\t\t\t\tvar row1=$(\"<tr><td>\"+item.Date+\"</td></tr>\").appendTo(table);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t$(\'<td align=\"left\">\'+item.SupplementaryOrderForDesc+\'</td>\').appendTo(row1);\n\t\t\t\t\t\t\t$(\'<td align=\"left\">\'+item.Item_Type_Desc+\'</td>\').appendTo(row1);\n\t\t\t\t\t\t\t$(\'<td align=\"left\">\'+item.Item_Desc+\'</td>\').appendTo(row1);\n\t\t\t\t\t\t\t$(\'<td align=\"left\">\'+item.Qty+\'</td>\').appendTo(row1);\n\t\t\t\t\t\t\tif(item.Meal_Type_Desc==\" \"){\n\t\t\t\t\t\t\t\t$(\'<td align=\"center\"> &nbsp; </td>\').appendTo(row1);\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(\'<td align=\"left\"> \'+item.Meal_Type_Desc+\' </td>\').appendTo(row1);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(trim(item.Instructions)==\" \" || trim(item.Instructions)==\"undefined\" ||trim(item.Instructions)==\"null\" || trim(item.Instructions)==\"\"){\n\t\t\t\t\t\t\t\t$(\'<td align=\"left\" >&nbsp;</td>\').appendTo(row1);\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t$(\'<td align=\"left\" style=\" word-break: break-all\">\'+item.Instructions+\'</td>\').appendTo(row1);\n\t\t\t\t\t\t\t}\n\t\t\t});\n\t\t}\n\t\t\n        $(document).ready(function () {\n\t\tvar localeName=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\tforViewAllTable();\n});\n\n    </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\ntable {\n    border-collapse: separate;\n    //empty-cells: hide;\n}\n</style>\n\t</head>\n\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\t\t\n\t\t<form action=\"\">\n\t\t<div id=\"listContentLayer\" style=\"display:block;visibility:visible;overflow-y: scroll;height:650;width:100%;border: 1px outset #9999FF;word-break: break-word;\" align=\"center\">\n\t\t<table border=\'1\' cellpadding=\'1\' cellspacing=\'2\' width=\'100%\' align=\'center\' id=\"ViewOldSupplementaryOrders\" style=\"overflow-y: scroll;overflow-x: scroll;width:100%;border: 1px outset #9999FF;\">\n\t\t<tbody></tbody>\n\t\t</table>\n\t\t</div>\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";
	String encounter_id=request.getParameter("encounter_id");

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.SupplementaryOrderAuditTrail.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
