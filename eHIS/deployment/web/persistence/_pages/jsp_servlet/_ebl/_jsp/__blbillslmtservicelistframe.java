package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmtservicelistframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtServiceListFrame.jsp", 1737915591544L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script type=\"text/javascript\">\n\n\n$(document).ready(function(){\n\t\n\t  function serviceLookUp(){\n\t\t\tvar locale = \"en\";\n\t\t\tvar argumentArray  = new Array();\n\t\t\tvar dataNameArray  = new Array();\n\t\t\tvar dataValueArray = new Array();\n\t\t\tvar dataTypeArray  = new Array();\n\t\t\tvar sql \t\t   = \'\';\n\t\t\tvar title \t\t   = \'\';\n\t\t    sql = \"Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where upper(language_id) = upper(\'\"+locale+\"\') Union Select \'All Billing Services\',\'**\' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2\";\n\n\t\t\targumentArray[0] = sql;\n\t\t\targumentArray[1] = dataNameArray;\n\t\t\targumentArray[2] = dataValueArray;\n\t\t\targumentArray[3] = dataTypeArray;\n\t\t\targumentArray[4] = \"2,1\";\n\t\t\targumentArray[5] = $(\"#service_text\").val();\n\t\t\targumentArray[6] = DESC_LINK;\n\t\t\targumentArray[7] = DESC_CODE;\n\n\t\t\tvar retval = CommonLookup(title, argumentArray );\n\t\t\tif((retval != null) && (retval != \"\") )  {\n\t\t\t\tvar ret1 = unescape(retval);\n\t\t\t\tarr = ret1.split(\",\");\n\t\t\t\t$(\"#service_text\").val(arr[0]);\n\t\t\t\t$(\"#ServiceListDiv\").load(\"../../eBL/jsp/BLBillSlmtServiceList.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"+\"&service_selected=\"+ $(\"#service_text\").val());\n\t\t\t}\n\t  }\n\t\n \t  $(\"#ServiceListDiv\").load(\"../../eBL/jsp/BLBillSlmtServiceList.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"+\"&all_service_criteria=\"+$(\"#all_service_criteria\").val());\n\t    \n\t  $(\"#service_text\").blur(function(){\n\t\t  if($(\"#service_text\").val()!=\'\'){\n\t\t  \tserviceLookUp();\n\t\t  }\n\t  }); \n\t  \n\t  $(\"#service_text_lookup\").click(function(){\n\t\t  serviceLookUp();\n\t  }); \n\t  \n\t  $(\"#search_text_lookup\").click(function(){\n\t\t  $(\"#ServiceListDiv\").load(\"../../eBL/jsp/BLBillSlmtServiceList.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t  }); \n\t  \n\t  $(\"#close_text_lookup\").click(function(){\n\t\t  window.close();\n\t  }); \n\t  \n\t  \n\t  $(\"#service_selected\").change(function(){\n\t\t  $(\"#ServiceListDiv\").load(\"../../eBL/jsp/BLBillSlmtServiceList.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"+\"&service_selected=\"+ $(\"#service_selected\").val());\n\t\t  }); \n\t  \n});\n\n\n</script>\n\n<HTML>\n<HEAD>\n<TITLE>\n</TITLE>\n</HEAD>\n</HEAD>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<BODY>\n<FORM name=\'BillSlmtServiceSelectedListFrameForm\' id=\'BillSlmtServiceSelectedListFrameForm\' id=\'BillSlmtServiceSelectedListFrameForm\'>\n<table widht=\"100%\">\n<tr>\n<td width=\"25%\" class=\"label\">Billing Service</td>\n<td width=\"25%\">\n\t<input type=\"text\" name=\"service_text\" id=\"service_text\" id=\"service_text\">\n\t<input type=button\tclass=button id=\'service_text_lookup\' name=\'service_text_lookup\' id=\'service_text_lookup\' value=\'?\'>\n</td>\n<td width=\"25%\">\n<input type=button\tclass=button id=\'search_text_lookup\' value=\'Search\'>\n</td>\n<td width=\"25%\">\n<input type=button\tclass=button id=\'close_text_lookup\'  value=\'Close\'>\n</td>\n</tr>\n</table>\n<!-- \tSTYLE=\"width:100%; height:600; overflow: auto;\" -->\n<div id=\"ServiceListDiv\"></div>\n</FORM>\n</BODY>\n\n</HTML>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(params));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);

String strbilldoctypecode = request.getParameter("bill_doc_type_selected");	
if(strbilldoctypecode==null || strbilldoctypecode.equals("")) strbilldoctypecode="";		
String strbilldocnum = request.getParameter("bill_doc_no_selected");	
if(strbilldocnum==null || strbilldocnum.equals("")) strbilldocnum="";


            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
