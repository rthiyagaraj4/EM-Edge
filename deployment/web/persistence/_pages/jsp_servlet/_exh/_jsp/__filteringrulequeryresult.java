package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHSelectQuery;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __filteringrulequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilteringRuleQueryResult.jsp", 1709122339085L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"JavaScript\">\n//function funUpdate\nfunction funUpdate(obj)\n{\n\nthis.document.forms[0].FILTER_ELEMENT_TYPE.value = obj.getAttribute(\'FILTER_ELEMENT_TYPE\');\nthis.document.forms[0].ELEMENT_TYPE_DESC.value = obj.getAttribute(\'ELEMENT_TYPE_DESC\');\nthis.document.forms[0].FILTER_ELEMENT_CODE.value = obj.getAttribute(\'FILTER_ELEMENT_CODE\');\nthis.document.forms[0].ELEMENT_CODE_DESC.value = obj.getAttribute(\'ELEMENT_CODE_DESC\');\n\t\nthis.document.forms[0].FILTER_SUB_ELEMENT_TYPE.value = obj.getAttribute(\'FILTER_SUB_ELEMENT_TYPE\');\nthis.document.forms[0].SUB_ELEMENT_TYPE_DESC.value = obj.getAttribute(\'SUB_ELEMENT_TYPE_DESC\');\nthis.document.forms[0].FILTER_SUB_ELEMENT_CODE.value = obj.getAttribute(\'FILTER_SUB_ELEMENT_CODE\');\nthis.document.forms[0].SUB_ELEMENT_CODE_DESC.value = obj.getAttribute(\'SUB_ELEMENT_CODE_DESC\');\n\nthis.document.forms[0].FILTER_SUB1_ELEMENT_TYPE.value = obj.getAttribute(\'FILTER_SUB1_ELEMENT_TYPE\');\nthis.document.forms[0].SUB1_ELEMENT_TYPE_DESC.value = obj.getAttribute(\'SUB1_ELEMENT_TYPE_DESC\');\nthis.document.forms[0].FILTER_SUB1_ELEMENT_CODE.value = obj.getAttribute(\'FILTER_SUB1_ELEMENT_CODE\');\nthis.document.forms[0].SUB1_ELEMENT_CODE_DESC.value = obj.getAttribute(\'SUB1_ELEMENT_CODE_DESC\');\n\nthis.document.forms[0].FILTER_SUB2_ELEMENT_TYPE.value = obj.getAttribute(\'FILTER_SUB2_ELEMENT_TYPE\');\nthis.document.forms[0].SUB2_ELEMENT_TYPE_DESC.value = obj.getAttribute(\'SUB2_ELEMENT_TYPE_DESC\');\nthis.document.forms[0].FILTER_SUB2_ELEMENT_CODE.value = obj.getAttribute(\'FILTER_SUB2_ELEMENT_CODE\');\nthis.document.forms[0].SUB2_ELEMENT_CODE_DESC.value = obj.getAttribute(\'SUB2_ELEMENT_CODE_DESC\');\nthis.document.forms[0].rowid.value = obj.getAttribute(\'rowid\');\n\nthis.document.forms[0].action = \'../../eXH/jsp/FilterRulesAddModifyFunctionality.jsp\';\nthis.document.forms[0].target = \'recordframe\';\nthis.document.forms[0].submit();\n\n}\n//function funModify\nfunction funModify(obj)\n {\n\t\n\tthis.document.forms[0].SEGMENTRULE.value = obj.getAttribute(\'SEGMENTRULE\');\n\tthis.document.forms[0].FILTERSEGRULE.value = obj.getAttribute(\'FILTERSEGRULE\');\n\tthis.document.forms[0].FILTERSEGELTYPE.value = obj.getAttribute(\'FILTERSEGELTYPE\');\n    this.document.forms[0].rowid.value = obj.getAttribute(\'rowid\');\n\tthis.document.forms[0].actualmode.value = \'M\';\n\tthis.document.forms[0].jspmode.value = \'G\';\n\tthis.document.forms[0].action = \'../../eXH/jsp/SegmentRuleSetup.jsp\';\n    this.document.forms[0].target = \'filterframe\';\n\tparent.recordframe.location.href=\"../../eCommon/html/blank.html\";\n    this.document.forms[0].submit();\n\t\n }\n//function delrecord\nfunction delrecord(str)\n{\n\n this.document.forms[0].rowid.value = str;\n this.document.forms[0].actualmode.value = \'D\';\n if(this.confirm(getMessage(\'XH1020\',\'XH\'))==true){\n this.document.forms[0].action = \'../../servlet/eXH.XHFilterRuleRecordServlet\';\n this.document.forms[0].target = \'messageFrame\';\n this.document.forms[0].submit();\n }\n}\n//function delSegrecord\nfunction delSegrecord(str,str1,str2,str3)\n{\n\n this.document.forms[0].rowid.value = str;\n this.document.forms[0].segment_type.value = str1;\n this.document.forms[0].segment_class.value = str2;\n this.document.forms[0].segment_element.value = str3;\n this.document.forms[0].actualmode.value = \'D\';\n if(this.confirm(getMessage(\'XH1020\',\'XH\'))==true){\n this.document.forms[0].action = \'../../servlet/eXH.XHFilterRuleRecordServlet\';\n this.document.forms[0].target = \'messageFrame\';\n this.document.forms[0].submit();\n }\n\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY  leftmargin=0 topmargin=0  onLoad=\"callFunction()\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"QueryResultForm\" id=\"QueryResultForm\" method=\"post\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<div id =\"filterrule\" style=\'display:block\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nalert(getMessage(\'XH1021\',\'XH\'));\n</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr>\n<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onClick=\'funUpdate(this);\' FILTER_ELEMENT_TYPE=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' ELEMENT_TYPE_DESC=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  FILTER_ELEMENT_CODE=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  ELEMENT_CODE_DESC=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' \n\t\nFILTER_SUB_ELEMENT_TYPE=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  SUB_ELEMENT_TYPE_DESC=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'  FILTER_SUB_ELEMENT_CODE=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'  SUB_ELEMENT_CODE_DESC=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' \n\t\nFILTER_SUB1_ELEMENT_TYPE=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  SUB1_ELEMENT_TYPE_DESC=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  FILTER_SUB1_ELEMENT_CODE=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  SUB1_ELEMENT_CODE_DESC=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' \n\t\nFILTER_SUB2_ELEMENT_TYPE=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  SUB2_ELEMENT_TYPE_DESC=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  FILTER_SUB2_ELEMENT_CODE=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  SUB2_ELEMENT_CODE_DESC=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' \n\t>\n<a href=\'#\' style=\'cursor:pointer\'>&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</a>\n</td>\n<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><input class=\'button\' type=\'button\'  name=\'Delete\' id=\'Delete\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'\nonClick=\"delrecord(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\" ></td>\n</tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</table>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</div>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<div id =\"segmentrule\" style=\'display:block\'>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\'funModify(this);\'\n\nSEGMENTRULE=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' FILTERSEGRULE=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  FILTERSEGELTYPE=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' \nrowid=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'\n\t>\n<a href=\'#\' style=\'cursor:pointer\'>&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' onClick=\"delSegrecord(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\"></td>\n\n</tr>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</table>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n<input type=\'hidden\' name=\'applicationid\' id=\'applicationid\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'message_type\' id=\'message_type\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\n<input type=\'hidden\' name=\'filter_type\' id=\'filter_type\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type=\'hidden\' name=\'filter_sub_type\' id=\'filter_sub_type\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'filter_sub1_type\' id=\'filter_sub1_type\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type=\'hidden\' name=\'filter_sub2_type\' id=\'filter_sub2_type\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\n<input type=\'hidden\' name=\'FILTER_ELEMENT_TYPE\' id=\'FILTER_ELEMENT_TYPE\' >\n<input type=\'hidden\' name=\'ELEMENT_TYPE_DESC\' id=\'ELEMENT_TYPE_DESC\' >\n<input type=\'hidden\' name=\'FILTER_ELEMENT_CODE\' id=\'FILTER_ELEMENT_CODE\' >\n<input type=\'hidden\' name=\'ELEMENT_CODE_DESC\' id=\'ELEMENT_CODE_DESC\' >\n\n<input type=\'hidden\' name=\'FILTER_SUB_ELEMENT_TYPE\' id=\'FILTER_SUB_ELEMENT_TYPE\' >\n<input type=\'hidden\' name=\'SUB_ELEMENT_TYPE_DESC\' id=\'SUB_ELEMENT_TYPE_DESC\' >\n<input type=\'hidden\' name=\'FILTER_SUB_ELEMENT_CODE\' id=\'FILTER_SUB_ELEMENT_CODE\' >\n<input type=\'hidden\' name=\'SUB_ELEMENT_CODE_DESC\' id=\'SUB_ELEMENT_CODE_DESC\' >\n\n<input type=\'hidden\' name=\'FILTER_SUB1_ELEMENT_TYPE\' id=\'FILTER_SUB1_ELEMENT_TYPE\' >\n<input type=\'hidden\' name=\'SUB1_ELEMENT_TYPE_DESC\' id=\'SUB1_ELEMENT_TYPE_DESC\' >\n<input type=\'hidden\' name=\'FILTER_SUB1_ELEMENT_CODE\' id=\'FILTER_SUB1_ELEMENT_CODE\' >\n<input type=\'hidden\' name=\'SUB1_ELEMENT_CODE_DESC\' id=\'SUB1_ELEMENT_CODE_DESC\' >\n\n<input type=\'hidden\' name=\'FILTER_SUB2_ELEMENT_TYPE\' id=\'FILTER_SUB2_ELEMENT_TYPE\' >\n<input type=\'hidden\' name=\'SUB2_ELEMENT_TYPE_DESC\' id=\'SUB2_ELEMENT_TYPE_DESC\' >\n<input type=\'hidden\' name=\'FILTER_SUB2_ELEMENT_CODE\' id=\'FILTER_SUB2_ELEMENT_CODE\' >\n<input type=\'hidden\' name=\'SUB2_ELEMENT_CODE_DESC\' id=\'SUB2_ELEMENT_CODE_DESC\' >\n\n<input type=\'hidden\' name=\'SEGMENTRULE\' id=\'SEGMENTRULE\' >\n<input type=\'hidden\' name=\'FILTERSEGRULE\' id=\'FILTERSEGRULE\' >\n<input type=\'hidden\' name=\'FILTERSEGELTYPE\' id=\'FILTERSEGELTYPE\' >\n\n<input type=\'hidden\' name=\'segment_type\' id=\'segment_type\' >\n<input type=\'hidden\' name=\'segment_class\' id=\'segment_class\' >\n<input type=\'hidden\' name=\'segment_element\' id=\'segment_element\' >\n\n<input type=\'hidden\' name=\'jspmode\' id=\'jspmode\'>\n<input type=\'hidden\' name=\'actualmode\' id=\'actualmode\' value=\'M\'>\n<input type=\'hidden\' name=\'rowid\' id=\'rowid\' value=\'\'>\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	ArrayList arrRow = null,arrCol=null;
	XHSelectQuery xhSelect = null;
	String strApplicationId = request.getParameter("applicationid").trim();
	String strFacilityId = request.getParameter("facilityid").trim();
	String strMessageType = request.getParameter("message_type").trim();
	String jspmode = request.getParameter("jspmode").trim();
	

	String filter_type="";
	String filter_sub_type="";
	String filter_sub1_type="";
	String filter_sub2_type="";
	if(jspmode.equalsIgnoreCase("F"))
    {
       filter_type = request.getParameter("filter_type").trim();
	   filter_sub_type = request.getParameter("filter_sub_type").trim();
	   filter_sub1_type = request.getParameter("filter_sub1_type").trim();
	   filter_sub2_type = request.getParameter("filter_sub2_type").trim();
	}
	String strOddClz = "QRYODD";
	String strEvnClz = "QRYEVEN";
	String strClz = "";
	String sql = "";
	

            _bw.write(_wl_block8Bytes, _wl_block8);

try
{
	con = ConnectionManager.getConnection(request);
	if(jspmode.equalsIgnoreCase("F"))
    {
	sql = " SELECT "+ "FILTER_ELEMENT_TYPE,ELEMENT_TYPE_DESC,FILTER_ELEMENT_CODE,ELEMENT_CODE_DESC,FILTER_SUB_ELEMENT_TYPE,"+
"SUB_ELEMENT_TYPE_DESC,FILTER_SUB_ELEMENT_CODE,SUB_ELEMENT_CODE_DESC,FILTER_SUB1_ELEMENT_TYPE,"+
"SUB1_ELEMENT_TYPE_DESC,FILTER_SUB1_ELEMENT_CODE,SUB1_ELEMENT_CODE_DESC,FILTER_SUB2_ELEMENT_TYPE,"+
"SUB2_ELEMENT_TYPE_DESC,FILTER_SUB2_ELEMENT_CODE,SUB2_ELEMENT_CODE_DESC,ROW_ID FROM XH_APPL_FIL_RULE_DTL_LANG_VW  "+
	" WHERE APPLICATION_ID='"+strApplicationId+"'   "+
	" AND FACILITY_ID='"+strFacilityId+"' AND "+
	" MESSAGE_TYPE='"+strMessageType+"'"+ 
	" AND FILTER_TYPE='"+filter_type+"'"+
    " AND FILTER_SUB_TYPE='"+filter_sub_type+"'"+
    " AND FILTER_SUB1_TYPE='"+filter_sub1_type+"'"+
    " AND FILTER_SUB2_TYPE='"+filter_sub2_type+"'"+
	" AND LANGUAGE_ID='"+locale+"'";

		xhSelect = new XHSelectQuery();
		HashMap hashmpParams = new HashMap(5);
		hashmpParams.put("connection",con);
		hashmpParams.put("sql",sql);
		hashmpParams.put("col","17");
		arrRow = xhSelect.getResults(hashmpParams);
		arrCol = null;	
		xhSelect = null;
		hashmpParams.clear();
	}
	
	if(jspmode.equalsIgnoreCase("G"))
    {
	sql = "SELECT SEGMENT_TYPE,SEGMENT_TYPE,"+
" FILTER_ATTRIBUTE_TYPE,FILTER_ATTRIBUTE_TYPE"+
",FILTER_ATTRIBUTE_CODE,FILTER_ATTRIBUTE_CODE,"+
  " ROWID FROM XH_APPL_SEG_FILTER_RULE  WHERE FACILITY_ID='"+strFacilityId+"' AND "+ "APPLICATION_ID='"+strApplicationId+"' AND MESSAGE_TYPE='"+strMessageType +"'";
		xhSelect = new XHSelectQuery();
		HashMap hashmpParams = new HashMap(5);
		hashmpParams.put("connection",con);
		hashmpParams.put("sql",sql);
		hashmpParams.put("col","7");
		arrRow = xhSelect.getResults(hashmpParams);
		arrCol = null;	
		xhSelect = null;
		hashmpParams.clear();
	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
 if(jspmode.equalsIgnoreCase("F"))
    { 
            _bw.write(_wl_block9Bytes, _wl_block9);

if(arrRow.size()==0)
{

            _bw.write(_wl_block10Bytes, _wl_block10);
 } else { 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

for(int j=0;j<arrRow.size();j++)
{
	arrCol = (ArrayList) arrRow.get(j);
	if (j%2 == 0)
	{
		strClz = strOddClz;

	}	
	else
	{
		strClz = strEvnClz;
	}


            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrCol.get(0).equals("null")?"":arrCol.get(0)+""));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(arrCol.get(1).equals("null")?"":arrCol.get(1)+""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(arrCol.get(2).equals("null")?"":arrCol.get(2)+""));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(arrCol.get(3).equals("null")?"":arrCol.get(3)+""));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(arrCol.get(4).equals("null")?"":arrCol.get(4)+""));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(arrCol.get(5).equals("null")?"":arrCol.get(5)+""));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(arrCol.get(6).equals("null")?"":arrCol.get(6)+""));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(arrCol.get(7).equals("null")?"":arrCol.get(7)+""));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(arrCol.get(8).equals("null")?"":arrCol.get(8)+""));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(arrCol.get(9).equals("null")?"":arrCol.get(9)+""));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(arrCol.get(10).equals("null")?"":arrCol.get(10)+""));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(arrCol.get(11).equals("null")?"":arrCol.get(11)+""));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(arrCol.get(12).equals("null")?"":arrCol.get(12)+""));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(arrCol.get(13).equals("null")?"":arrCol.get(13)+""));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(arrCol.get(14).equals("null")?"":arrCol.get(14)+""));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(arrCol.get(15).equals("null")?"":arrCol.get(15)+""));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(3).equals("null")?"":arrCol.get(3)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(5).equals("null")?"":arrCol.get(5)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(7).equals("null")?"":arrCol.get(7)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(9).equals("null")?"":arrCol.get(9)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(11).equals("null")?"":arrCol.get(11)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(13).equals("null")?"":arrCol.get(13)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(15).equals("null")?"":arrCol.get(15)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(arrCol.get(16)));
            _bw.write(_wl_block37Bytes, _wl_block37);

}

            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);
 } if(jspmode.equalsIgnoreCase("G"))
    {
            _bw.write(_wl_block40Bytes, _wl_block40);

if(arrRow.size()==0)
{

            _bw.write(_wl_block10Bytes, _wl_block10);
 } else { 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

for(int j=0;j<arrRow.size();j++)
{
	arrCol = (ArrayList) arrRow.get(j);
	if (j%2 == 0)
	{
		strClz = strOddClz;

	}	
	else
	{
		strClz = strEvnClz;
	}

String seg_type="";
String int_seg_type="";
seg_type=(String)arrCol.get(1);

if(seg_type.equalsIgnoreCase("AL1")) int_seg_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.PatientAllergy.Label","xh_labels");
String s_filter_type="";
String str_filter_type="";
s_filter_type=(String)arrCol.get(3);
if(s_filter_type.equalsIgnoreCase("A")) str_filter_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.AllergyClass.Label","xh_labels");
String s_element_type="";
String str_element_type="";
s_element_type=(String)arrCol.get(5);

if(s_element_type.equalsIgnoreCase("F")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Food.Label","xh_labels");
if(s_element_type.equalsIgnoreCase("D")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Drug.Label","xh_labels");
if(s_element_type.equalsIgnoreCase("G")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.General.Label","xh_labels");
if(s_element_type.equalsIgnoreCase("A")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.All.Label","xh_labels");
 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(arrCol.get(0).equals("null")?"":arrCol.get(0)+""));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(2).equals("null")?"":arrCol.get(2)+""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrCol.get(4).equals("null")?"":arrCol.get(4)+""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrCol.get(6)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(int_seg_type+""));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str_filter_type+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str_element_type+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strClz));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrCol.get(6)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(0)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(2)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(4)));
            _bw.write(_wl_block48Bytes, _wl_block48);

}

            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
 } 
if(arrCol!=null) arrCol.clear();
if(arrRow!=null) arrRow.clear();
try
{
	
	ConnectionManager.returnConnection(con);
}
catch(Exception exp)
      {

		 
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }



            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strApplicationId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strMessageType));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(filter_type));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(filter_sub_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(filter_sub1_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(filter_sub2_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ElementType.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Element.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SubElementType.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SubElement.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Sub1ElementType.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Sub1Element.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Sub2ElementType.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Sub2Element.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Delete.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SegmentType.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.FilterType.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ElementType.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }
}
