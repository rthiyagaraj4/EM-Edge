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
import eDS.Common.JSONObject;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __placesupplementaryorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/PlaceSupplementaryOrder.jsp", 1738425524000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=5,8,9\" >\n  <meta charset=\"utf-8\">\n    <title>Place Supplementary Order</title>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\t\t\n\t<script language=\"JavaScript\" src=\"../../framework/js/PopupWindow.js\" type=\"text/javascript\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/navbar.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/simpletreemenu.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../framework/js/hashtable.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/PlaceDietOrder.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\t\t\n\t<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"Javascript\" src=\"../../eDS/js/Moment.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/MomentRange.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/PlaceSupplementaryOrder.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/css/jquery-ui.css\"/>\n\t \n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/timepicker.css\"/>\n\n\t\n\t\n\t\n\t\n\t\n  \n\t<!-- ML-MMOH-CRF-409 -->\n\t<script src=\"../../eDS/js/Moment.js\"></script>\n\t<script src=\"../../eDS/js/MomentRange.js\"></script>\n\t<!-- ML-MMOH-CRF-409 -->\n  \n\t<!--<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-th.js\"></script>-->\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".js\"></script>  \n\t\t\n\t<script type=\"text/javascript\">\n\t   $(document).ready(function () {\n\t\tvar localeName=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n           //$(\'#mealType\').SumoSelect({placeholder: \'All Suburbs\'});\t\n\t\t\tgetSavedSupplementaryMeal();\n\t\t\tFormSupplementaryOrderTable();\n\t});\n    </script>\n\t<style type=\"text/css\">\n        body{font-family: \'Helvetica Neue\', Helvetica, Arial, sans-serif;color:#444;font-size:13px;}\n        p,div,ul,li{padding:0px; margin:0px;}\n\t\t.popupgrid\n\t\t{\n\t\twidth:100%;height:75%; POSITION: absolute;overflow-y: scroll;width:100%;border: 1px outset #9999FF;    word-break: break-word;border-bottom: 1pt solid black;\n\t\t}\n\t\t//new\n\t\tth, td { white-space: nowrap; }\n\t\t\n\t.thwrap{\n\t\t\tposition: relative;\n            \t\ttop: expression(this.offsetParent.scrollTop);\n\t\t\t/*white-space:nowrap;*/\n\t\t\t/*color:#ff0000;*/\n\t\t\tfont-size:12px;\n\t\t\twidth:auto;\t\t\n\t\t\tbackground: url(\"../../eCommon/images/headerSeparator.jpg\") repeat-y;\n\t\t\tbackground-position:right;\n\t\t\tCOLOR: white ;\n\t\t\tbackground-color:#83AAB4;\n\t\t\tborder:2px;\n\t\t\tpadding-left:3px;\n\t\t\tfont-family: Verdana;\n\t\t\tfont-size: 8pt;\n\t\t\t/*font-weight:bold;*/\n\t\t\tborder-collapse:collapse; \n\t\t\t/*position:absolute;*/\n\t\t\tleft:0;\t\t\t\n\t\t\t}\n\t\t\t.datawrap{\n\t\t\t/*align:center;*/\n    </style>\n    \n</head>\n<body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form action=\"\" style=\"width:100%;height:100%;\">\n<div id=\"SearchLayer\" style=\"width:100%;height:28vh;border: 0px outset #9999FF;\">\n<br>\n<br>\n<table width=\"100%\" border=\"0\" align=\"center\" CELLSPACING=\"2\" cellpadding=\"0\" >\n\t\t<tr>\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"supplementaryfor\" id=\"supplementaryfor\" id=\"supplementaryfor\" onChange=\"\">\n\t\t\t\t<option value=\"B\">Both</option>\t\t\t\t\t\t\t\n\t\t\t\t<option value=\"P\">Patient</option>\t\t\t\t\t\t\t\n\t\t\t\t<option value=\"A\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option> \t\t\t\t\t\t\t\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"text\" id=\"date\" name=\"date\" id=\"date\" value=\"\" onkeypress=\"return checkForSpecCharsforID(event);\"  onblur=\"isValidDate(this);\" size=\"10\" maxlength=\"10\">\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"return showCalendar(\'date\');\">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' />\n\t\t\t</td>\n\t\t\t<td class=\"label\" id=\"mealTypesId\" onclick=\"return mealTypeSpFoodItems(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\">\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t<select name=\"itemtype\" id=\"itemtype\" id=\"itemtype\" onChange=\"clearFoodItem();\">\n\t\t\t<option value=\"\">--select--</option>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' />\n\t\t\t</td>\n\t\t\t<td class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"item\" id=\"item\" id=\"item\" value=\"\" onblur=\"itemLookUp();\">\n\t\t\t\t<input type=\"button\" name=\"click\" id=\"click\" value=\"?\" onclick=\"itemLookUp();\">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t<input type=\"hidden\" id=\"itemcode\" name=\"itemcode\" id=\"itemcode\" value=\"\">\n\t\t\t</td>\n\t\t\t<td class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<input type=\"text\" name=\"qty\" id=\"qty\" id=\"qty\" value=\"\" maxlength=\"6\" size=\"6\" onkeyup=\"if(!CheckForNumber(this.value))this.value=\'\'\">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t<td></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</td>\n\t\t\t<td >\n\t\t\t\t<textarea style=\"resize: none;\" name=\"Instructions\" cols=\'30\' id=\"Instructions\" onkeypress=\"restrictSpecialChars(event)\" onblur=\"textAreaLimit(this,150);\"></textarea>\n\t\t\t</td>\n\t\t\t<!-- td></td-->\n\t\t\t<td>\t\t\t\t\t\t\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t</td>\n\t\t\t<td></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td></td>\n\t\t\t<td>\t\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<td align=\"right\">\n\t\t\t\t\t\n\t\t\t<input type=\"button\" name=\"button1\" id=\"button1\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\"button\" onClick=\"addSupplementaryFood()\"/>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t<a href=\"#\" onClick=\"viewAllRecord();\">View All</a>\n\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\n\t\t\t<input type=\"button\" align=\"right\" name=\"button2\" id=\"button2\" id=\"cancelButton\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" class=\"button\" onClick=\"RemoveItem()\" disabled/>\n\t\t\t</td>\t\t\t\t\t\n\t\t</tr>\n\t\t</table>\n</div>\n\t<div id=\"ResultLayer\" class=\"popupgrid\" style=\"width:100%;border: 1px outset #9999FF;overflow-y: scroll;width:100%;border: 1px outset #9999FF;\">\n\t<table border=\'1\' cellpadding=\'1\' cellspacing=\'2\' width=\'100%\' align=\'center\' id=\"SupplementaryOrderTable\" style=\"border-bottom: 1pt solid black;\">\n\t\t<!--tbody></tbody-->\n\t</table>\n\t</div>\n\t<input type=\"hidden\" id=\"patientId\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" id=\"encounterId\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" id=\"locationCode\" name=\"locationCode\" id=\"locationCode\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" id=\"patientClass\" name=\"patientClass\" id=\"patientClass\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" id=\"room\" name=\"room\" id=\"room\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" id=\"bed\" name=\"bed\" id=\"bed\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" id=\"locationType\" name=\"locationType\" id=\"locationType\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" id=\"dateOfBirth\" name=\"dateOfBirth\" id=\"dateOfBirth\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" id=\"gender\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" id=\"facility_id\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" id=\"locale\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" id=\"maximum_days_allowed\" name=\"maximum_days_allowed\" id=\"maximum_days_allowed\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" id=\"Attendent_Label_Name\" name=\"Attendent_Label_Name\" id=\"Attendent_Label_Name\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<!-- Added Against Start ML-MMOH-CRF-825 -->\n\t<input type=\"hidden\" name=\"suppl_diet_order_yn\" id=\"suppl_diet_order_yn\" id=\"suppl_diet_order_yn\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" />\n\t<input type=\"hidden\" name=\"current_date\" id=\"current_date\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\t\n\t<!-- Added Against End ML-MMOH-CRF-825 -->\n</form>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n<script>\nwindow.onbeforeunload = function() \n{\t\n\tvar dataModifyFlag=checkDataModification();\n\tif(\n\t$(\"#supplementaryfor\").val()!=\"B\" ||\n\t$(\"#date\").val()\t!=\"\" ||\n\t$(\"#itemtype\").val()!=\"\" ||\n\t$(\"#item\").val()!=\"\" ||\n\t$(\"#itemcode\").val()!=\"\" ||\n\t$(\"#qty\").val()!=\"\" ||\n\t$(\"#Instructions\").val()!=\"\" \n\t//|| meal_Type_Arr.length!=0\n\t){\n\t\tdataModifyFlag=false;\n\t}\n\tif(!dataModifyFlag){\n\t\t\n\t\treturn getMessage(\"DS_UNSAVED_CHANGE_LOST\",\"DS\");\n\t}\t\n\t};\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            {DSCommonBeanObj.setFacilityId(session.getAttribute("facility_id").toString()
                );
            }_bw.write(_wl_block1Bytes, _wl_block1);
            {DSCommonBeanObj.setLocale(session.getAttribute("LOCALE").toString()
                );
            }_bw.write(_wl_block2Bytes, _wl_block2);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip = "",current_date="";//Added Against ML-MMOH-CRF-0825-US007
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";	
	
	ArrayList<JSONObject> DS_Param_List = new ArrayList<JSONObject>();
	String maximum_days_allowed="",Attendent_Label_Name="";
	try{
		DS_Param_List=DSCommonBeanObj.getDSParameterValue();
		JSONObject paramObj=new JSONObject();
		Iterator<JSONObject> itr1=DS_Param_List.iterator();
		while(itr1.hasNext()){
			paramObj=itr1.next();
			maximum_days_allowed=paramObj.get("Maximum_Days_Allowed").toString();
			Attendent_Label_Name=paramObj.get("Attendent_Label_Name").toString();	
	}
	//Added Against Starts ML-MMOH-CRF-0825-US007
	Connection conn = null;
	conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String suppl_diet_order_yn="";
	String gPQuery = "select GRACE_PERIOD_APPLICABLE_YN,GRACE_PERIOD,restrict_date_inpatients_yn,nvl(maximum_days_allowed,'1') maximum_days_allowed,GEN_MEALPLAN_FOR_NBM_PAT_YN,LATE_IRREGULAR_DIET_ORD_FOR_SP,IRREGULAR_MEAL_ORD_MESSAGE,Attendent_Label_Name,NVL(No_Of_Attendant,'0') No_Of_Attendant from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	try{
		pstmt = conn.prepareStatement(gPQuery);
		rs	= pstmt.executeQuery();
	if(rs != null && rs.next()){
		suppl_diet_order_yn=checkForNull(rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_SP"));
		}
	pstmt = conn.prepareStatement(sql_curr_date);
	rs	= pstmt.executeQuery();
	if(rs!=null && rs.next()){
		current_date = com.ehis.util.DateUtils.convertDate(rs.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	if(rs != null) rs.close();
	}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception es){
			es.printStackTrace();
		} 
	}
	//  Added Against Ends ML-MMOH-CRF-0825-US007
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String patientId=request.getParameter("patientId");
	String encounterId=request.getParameter("encounterId");
	String locationCode=request.getParameter("locationCode");
	String patientClass=request.getParameter("patientClass");
	String room=request.getParameter("room");
	String bed=request.getParameter("bed");
	String locationType=request.getParameter("locationType");
	String dateOfBirth=request.getParameter("dateOfBirth");
	String gender=request.getParameter("gender");
	String fecthedMealTypes="";
	ArrayList<JSONObject> SupplementarykeyValueList = new ArrayList<JSONObject>();
						
	SupplementarykeyValueList=DSCommonBeanObj.getSupplementaryMeal();						
						
	Iterator<JSONObject> itr=SupplementarykeyValueList.iterator();
	JSONObject childobject=new JSONObject();
	if(SupplementarykeyValueList.size()>0){
	while(itr.hasNext()){
		childobject=itr.next();
		String code=childobject.get("Meal_Type").toString();
		String Desc=childobject.get("Short_Desc").toString();
		//Added Against ML-MMOH-CRF-0825 Starts Here
		String ServingStartTimeSUP=childobject.get("Serving_Start_Time_sup").toString();
		String ServingEndTimeSUP=childobject.get("Serving_End_Time_sup").toString();
		String IrregularStartTimeSUP=childobject.get("Irregular_Start_Time_sup").toString();
		String IrregularEndTimeSUP=childobject.get("Irregular_End_Time_sup").toString();
		String nextServingStartTimeSUP=childobject.get("next_Serving_Start_Time_sup").toString();
		//Added Against ML-MMOH-CRF-0825 Ends Here							
		fecthedMealTypes+=code+","+Desc+",";//Commented Against ML-MMOH-CRF-0825		
		}
		}
				

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fecthedMealTypes));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

				ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
						
				keyValueList=DSCommonBeanObj.getItemTypes();
				System.err.println("keyValueList in jsp--->"+keyValueList);
						
				itr=keyValueList.iterator();
				//JSONObject childobject=new JSONObject();
				while(itr.hasNext()){
					childobject=itr.next();
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(childobject.get("Code") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( childobject.get("Short_Desc")));
            _bw.write(_wl_block20Bytes, _wl_block20);
	
				}
				 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locationCode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(room));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(suppl_diet_order_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block41Bytes, _wl_block41);

			}catch(Exception e)
			{
				e.printStackTrace();
			}

            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.SupplementaryDietFor.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.mealTypes.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ItemType.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.FoodItem.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.qty.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instructions.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
