package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __opfooddislikes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/OPFoodDislikes.jsp", 1745232036238L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nFile Name\t\t: OPFoodDislikes.jsp\nFile Description: This file is for selecting Food Dislike Items.\nCRF#\t\t\t: Bru-HIMS-CRF-230\nAuthor\t\t\t: Abirami\nDate\t\t\t: Aug-2013\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n<body>\n\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n\t\t\t\t\t<TR align=\"center\">\n\t\t\t\t\t\t<TD align=\"center\" colspan=\"2\" class=\"lable\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"foodType\" id=\"foodType\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"foodDesc\" id=\"foodDesc\" value=\"\" onblur=\"showLookupLocal(this)\"/>\n\t\t\t\t\t\t\t<input type=\"button\" name=\"click\" id=\"click\" value=\"?\" onClick=\'showLookup(document.getElementById(\"foodDesc\"));\' class=\"Button\"/>\n\t\t\t\t\t\t\t\n<!-- \t\t\t\t\t\t\t<input type=\"text\" name=\"foodDesc\" id=\"foodDesc\" value=\"\" onblur=\"showLookup(this)\"> -->\n<!-- \t\t\t\t\t\t\t<input type=\"button\" name=\"click\" id=\"click\" value=\"?\" onClick=\"showLookup(document.getElementById(foodDesc))\" class=\"Button\"/> -->\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"2\" align=\"right\">\n\t\t\t\t\t\t\t<input type=\"button\" name=\"\" id=\"\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onClick=\"AddFoodDislikeItem();\" class=\"Button\">\n\t\t\t\t\t\t\t <input type=\"button\" name=\"cancel\" id=\"cancel\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onClick=\"return deleteFoodDislikesRow();\" class=\"Button\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"rowNo\" id=\"rowNo\" value=\"\">\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</table>\n\t\t<TR>\n\t\t\t<td>\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<tr style=\"BACKGROUND-COLOR:white;\">\n\t\t\t\t\t\t<br/>\n\t\t\t\t\t\t<td colspan=\"2\">\n\t\t\t\t\t\t\t<div id=\"listContentLayer\" style=\"display:block;visibility:visible;overflow-y: scroll;height:75vh;width:100%;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t\t\t\t\t\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'75%\' align=\'center\' id=\"listContentTable\">\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<th>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD colspan=\"4\" align=\"right\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"button\" name=\"\" id=\"\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onClick=\"getFoodDislikeDtls()\" class=\"Button\">\n\t\t\t\t\t\t\t<input type=\"button\" name=\"\" id=\"\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onClick=\"OPFoodDislikeclose();\" class=\"Button\">\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</TR>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<script type=\"text/javascript\">\n\tvar foodDislikeList = new Array();\n\tvar recordUpd = false;\n\tif(dialogArguments != \"undefined\" && dialogArguments != \"\")\n\t{\n\t\tvar foodARR = new Array();\n\t\tfoodARR = dialogArguments.split(\",\");\n\t\t\n\t\tvar tableObj = document.getElementById(\"listContentTable\");\n\t\tvar count=0;\n\t\tvar nRowCount = 0; \n\t\tfor (var nCount = 0; nCount < foodARR.length; ) {\n\t\t\t\n\t\t\tfoodDislikeList[nRowCount] =  new Array();\n\t\t\tfoodDislikeList[nRowCount][0] = foodARR[nCount++];\n\t\t\tfoodDislikeList[nRowCount][1] = foodARR[nCount++];\n\t\t\tfoodDislikeList[nRowCount][2] = foodARR[nCount++];\n\t\t\t\n\t\t\tvar obj = foodDislikeList[nRowCount];\n\t\t\n\t\t\tif (foodDislikeList[nRowCount][2] != null) {\n\t\t\t\tif (foodDislikeList[nRowCount][2] != \"-1\") {\n\t\t\t\t\n\t\t            var countRow = tableObj.rows.length;\n\t\t            var row_ind = 1;\n\t\t            var newRow = tableObj.insertRow(row_ind);\n\t\t            newRow.id = nRowCount;\n\t\t            var newCellitemType = newRow.insertCell(newRow.cells.length);\n\t\t            var sub = \"<A href=\\\"#\\\" onclick=\\\"return fetchFoodDislikesRow(\'\" + nRowCount + \"\');\\\" >\" + obj[1] + \"</A>\";\n\t\t\t\t\t\t\t//alert(sub)\n\t\t            newCellitemType.innerHTML = sub;\n\t\t\t\t}\n\t\t\t}\n\t\t\tnRowCount++;\n\t\t}\n\t}\n\t\n\tfunction fetchFoodDislikesRow(val) {\n\t\tdocument.all(\"foodType\").value = foodDislikeList[val][0];\n\t\tdocument.all(\"foodDesc\").value = foodDislikeList[val][1];\n\t\tdocument.all(\"rowNo\").value = val;\n\t}\n\t\n\tvar warnOnClose = false;\n\tfunction OPFoodDislikeclose()\n\t{ \n\t\twarnOnClose = true;\n\t\t\n\t\tif(window.confirm(\"The Changes will not be Saved. Are you sure you wish to continue?\"))\n\t\t{\n\t\t\twindow.returnValue = false;\n\t\t\ttop.close();\n\t\t}\n\t\telse\n\t\t\twarnOnClose = false;\n\t\t\t\n\t\t/*var sMsg = \"The Changes will not be Saved. Are you sure you wish to continue? \";\n\t\tvar dialogUrl1 = \"../../eDS/jsp/CommonDialogBox.jsp?dialogMessage=\"+sMsg;\n\t\tvar dialogFeatures = \"dialogHeight:5;dialogWidth:30;status:no;scroll:no\";\n\t\tvar returnValue = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);\n\n\t\tif(returnValue)\n\t\t{\n\t\t\twindow.returnValue = false;\n\t\t\ttop.close();\n\t\t}else\n\t\t\twarnOnClose = false; */\n\t}\n\t\n\twindow.onbeforeunload  = function OPautoClose() {\n\t\tif(!warnOnClose)\n\t\t\treturn \"\";\n\t};\n\t\n\tfunction getFoodDislikeDtls() {\n\t\tvar tmpfoodDislikeList = \"\";\n\t\ttmpfoodDislikeList += foodDislikeList;\n\t\tif(recordUpd)\n\t\t\tparent.document.getElementById(\'dialog-body\').contentWindow.returnValue = foodDislikeList;\n\t\telse\n\t\t\tparent.document.getElementById(\'dialog-body\').contentWindow.returnValue = false;\n\t\t\n\t\twarnOnClose = true;\n\t\t//window.close();\n\t\tparent.document.getElementById(\'dialog_tag\').close();\n\t}\n\t\n\t//Function: Fetching the selected row value in the header: \n\tfunction AddFoodDislikeItem(){\n\t\tvar countRowValue = 0;\n\t\tif (document.getElementById(\"foodType\").value == \"\" || document.getElementById(\"foodDesc\").value ==\"\") {\n\t\t\tvar msg = \"Item Cannot be Blank\";\n\t\t\talert(msg);\n\t\t\treturn false;\n\t\t}\n\t\tif (document.getElementById(\"rowNo\").value == \"\") {\n\t\t\t\tif (foodDislikeList && foodDislikeList.length > 0) {\n\t\t\t\t\tcountRowValue = foodDislikeList.length;\n\t\t\t\t\tfor (var i = 1; i < foodDislikeList.length; i++) {\n\t\t\t\t\t\tvar obj = foodDislikeList[i];\n\t\t\t\t\t\tif (obj != null) {\n\t\t\t\t\t\t\tif (obj[2] != \"-1\") {\n\t\t\t\t\t\t\t\tif (obj[0] == document.all(\"foodType\").value) {\n\t\t\t\t\t\t\t\t\talert(\"This Food Item Is Already Exits\");\n\t\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse{\n\t\t\tcountRowValue = document.getElementById(\"rowNo\").value;\n\t\t}\n\t\trecordUpd = true;\n\t\tfoodDislikeList[countRowValue] = new Array();\n\t\tfoodDislikeList[countRowValue][0] = document.all(\"foodType\").value;\n\t\tfoodDislikeList[countRowValue][1] = document.all(\"foodDesc\").value;\n\t\tfoodDislikeList[countRowValue][2] = \"0\";\n\t\tcountRowValue++;\n\t\tvar tableObj = document.getElementById(\"listContentTable\");\n\t\t\twhile (tableObj.rows.length > 1) {\n\t\t\t\t\ttableObj.deleteRow(1);\n\t\t\t\t}\n\t\tfor (var ntempCount = 0; ntempCount < foodDislikeList.length; ntempCount++) { \n\t\t\t\tvar obj = foodDislikeList[ntempCount];\n\t\t\t\t\t\n\t\t\t\t\tif (obj != null && obj[2] != \"-1\") {\n\t\t\t\t\t\t\tvar countRow = tableObj.rows.length;\n\t\t\t\t\t\t\tvar row_ind = 1;\n\n\t\t\t\t\t\t\tvar newRow = tableObj.insertRow(row_ind);\n\t\t\t\t\t\t\tvar newCellitemType = newRow.insertCell(newRow.cells.length);\n\t\t\t\t\t\t\tvar sub = \"<A href=\\\"#\\\" onclick=\\\"return fetchFoodDislikesRow(\'\" + ntempCount + \"\');\\\" >\" + foodDislikeList[ntempCount][1] + \"</A>\";\n\t\t\t\t\t\t\tnewCellitemType.innerHTML = sub;\n\t\t\t\t\t}\n\t\t\t\n\t\t\t\tdocument.all(\"foodType\").value = \"\";\n\t\t\t\tdocument.all(\"foodDesc\").value = \"\";\n\t\t\t\tdocument.getElementById(\"rowNo\").value = \"\";\n\n\t\t}\n\t}\n\n\tfunction deleteFoodDislikesRow() {\n\t\tvar tableObj = document.getElementById(\"listContentTable\");\n\n\t\tif (document.all(\"rowNo\").value == \"\" || document.getElementById(\"foodType\").value == \"\" || document.getElementById(\"foodDesc\").value ==\"\") {\n\t\t\t\talert(\"Please Select Atleast One Record to delete\");\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\trecordUpd = true;\n\t\t\twhile (tableObj.rows.length > 1) {\n\t\t\t\ttableObj.deleteRow(1);\n\t\t\t}\n\t\t\tif (document.all(\"rowNo\").value != \"\") {\n\t\t\t\tfoodDislikeList[document.all(\"rowNo\").value][2] = \"-1\";\n\t\t\t}\n\t\t\t\n\t\t\tvar row_ind = 1;\n\t\t\tvar obj;\n\t\t\tfor (var i = 0; i < foodDislikeList.length; i++) {\n\t\t\t\tif(foodDislikeList[i] != undefined){\n\t\t\t\t\tobj = foodDislikeList[i];\n\t\t\t\t\tif (obj != null) {\n\t\t\t\t\t\tif (obj[2] != \"-1\") {\n\t\t\t\t\t\t\tvar newRow = tableObj.insertRow(row_ind);\n\t\t\t\t\t\t\tvar newCellitemType = newRow.insertCell(newRow.cells.length);\n\t\t\t\t\t\t\tvar sub = \"<A href=\\\"#\\\" onclick=\\\"return fetchFoodDislikesRow(\'\" + i + \"\');\\\" >\" + obj[1] + \"</A>\";\n\t\t\t\t\t\t\tnewCellitemType.innerHTML = sub;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tdocument.getElementById(\"rowNo\").value = \"\";\n\t\t\tdocument.getElementById(\"foodType\").value = \"\";\n\t\t\tdocument.getElementById(\"foodDesc\").value=\"\";\n\t}\n\n\tasync function showLookup(obj) {\n\tvar locale = document.getElementById(\"language_id\").value;\n\tvar argumentArray = new Array();\n\tvar dataNameArray = new Array();\n\tvar dataValueArray = new Array();\n\tvar dataTypeArray = new Array();\n\n\tvar sql = \"SELECT A.FOOD_ITEM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS =\'E\' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID LIKE \'\"+locale+\"\'\";\n\n\targumentArray[0] = sql;\n\targumentArray[1] = dataNameArray;\n\targumentArray[2] = dataValueArray;\n\targumentArray[3] = dataTypeArray;\n\targumentArray[4] = \"2,1\";\n\targumentArray[5] = obj.value;\n\t//argumentArray[6] = DESC_LINK;\n\t//argumentArray[7] = DESC_CODE;\n\targumentArray[6] = CODE_LINK;\n\targumentArray[7] = CODE_DESC;\n\n\tretArr = await CommonLookup(\"Item\", argumentArray);\n\tif (retArr != null && retArr != \"\" && retArr != undefined) {\n\t\tvar str =unescape(retArr);\n\t\tvar arr = str.split(\",\");\n\t\tdocument.getElementById(\"foodType\").value = arr[0];\n\t\tdocument.getElementById(\"foodDesc\").value = arr[1];\n\t}\n}\n\n\tfunction showLookupLocal(obj)\n\t{\n\t\tif(obj.value!=\'\')\n\t\t\tshowLookup(obj);\n\t\telse \n\t\t\tdocument.getElementById(\"foodType\").value=\'\'\n\t}\n\t</script>\n</body>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	//Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
				String locale = (String)session.getAttribute("LOCALE");

	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.foodDislikes.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Ok.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
