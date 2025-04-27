package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __ordersetcomponentdetailtab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetComponentDetailTab.jsp", 1721793694000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<script>\n\n  var alpha = new String();\n\n  function callOnAlphaLink(obj1,obj2)\n  {\n\n\t//f_query_add_mod.detail.detailUpper.document.getElementById(\"searchTxt\").style.display = \"inline\";\n\tdocument.getElementById(\"searchTxt\").style.display = \"inline\";\n\t//document.detailUpperForm.search_text.value = \"\";\n\tdocument.getElementById(\"searchTxt\").value = \"\";\n\n\tif(obj1 == \"OTH\")\n\t\tobj1 = \"Others\" ;\n    alpha = obj1;\n\tchangeAlphaColor(obj2);\n\tdocument.detailUpperForm.searchinglink.value=alpha;\n\tparent.parent.parent.OderCatalogForSelectedIndex(obj1,\"\");\n  } \n\n  /* function notAllowOtherChar(event)\n   {\t  \n\tif((alpha.charAt(1)).toUpperCase()!=\'T\'){\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    if (whichCode == 13) \n    {\n\t return false; \n    }\n    key = String.fromCharCode(whichCode);  // Get key value from key code\n    var sText = new String();\n    sText = document.detailUpperForm.search_text.value;\n\tif(sText.length==0)\n\t{\n       if((key.toUpperCase())!=(alpha.charAt(0)).toUpperCase())\n\t   {\n\t\t   return false;\n\t   }  \n\t}\n   }\n   }*/\n\n\n\nfunction notAllowOtherChar(event)\n   {\t \n\t    var whichCode = (window.Event) ? event.which : event.keyCode;\n\t    var key = String.fromCharCode(whichCode); \n\t\tvar sText = new String();\n\t\tsText = document.detailUpperForm.search_text.value;\n\t\tif((alpha.charAt(1)).toUpperCase()!=\'T\'){\n\t\t\t\tif (whichCode == 13) \n\t\t\t\t{\n\t\t\t\t\treturn false; \n\t\t\t\t}\t\t\t\n\t\t\n  \t\t\t\t/*if(sText.length==0)\n\t\t\t\t{\n\t\t\t\t\tif((key.toUpperCase())!=(alpha.charAt(0)).toUpperCase())\n\t\t\t\t\t{\n\t\t\t\t\t\t return false;\n\t\t\t\t\t}  \n\t\t\t\t}*/\n\t\t}\n\t\telse\n\t\t{\t\t\n\t\t\tvar strCheck = \'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\t\n  \t\t\tif (whichCode == 13) \n\t\t\t{\n\t\t\t\treturn false; \n\t\t\t}\t\n\t\t\t/*if(sText.length==0)\n\t\t\t{\n\t\t\t\n\t\t\tif (strCheck.indexOf(key) == -1) \n\t\t\t\treturn true; \n\t\t\telse \n\t\t\t\treturn false ;\n\t\t\t}*/\n\n\t    }\n   }\n\n  /* function callSearch()\n   {\n\t  \n\t   var sText = document.detailUpperForm.search_text.value;\n\t   alert(\"sText--\"+document.detailUpperForm.search_text.value);\n\t  if((sText==\"\")||(sText==null)||(sText==\"null\"))\n\t  {\n\t\talert(\"2\");\n\t\tparent.parent.parent.OderCatalogForSelIndx(sText);\n\t  }\n\t  else\n\t  { \n\t   alert(\"1\");\n\t   if((alpha.charAt(1)).toUpperCase()!=\'T\'){\n\t   if((sText.charAt(0)).toUpperCase()==(alpha.charAt(0)).toUpperCase())\n\t   {\n         if(sText == \"OTH\")\n    \t sText = \"Others\" ;\n\t   parent.parent.parent.OderCatalogForSelIndx(sText);\n\t   }\n\t   else\n\t   {\t\t \n\t//  var message  = \"APP-002415 Query caused no records to be retrieved\";\n  //  parent.parent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+ message;\n    \tdocument.detailUpperForm.search_text.value = \"\";\n    //\tparent.parent.parent.detailLowerDoc.location.href=\"../../eCommon/html/blank.html\";\n\t   }\t   \n\t   sText = \"\";\n\t   }else\n\t   {\n\t\t    //parent.parent.parent.OderCatalogForSelIndx(sText);\n\t\t\tvar strCheck = \'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\t\t\tvar temp=sText.charAt(0);\n\t\t   \n\t\t\tif (strCheck.indexOf(temp) == -1) \n\t\t\t{\t parent.parent.callOderCatalog(searchlink,sText);}\n\t\t\telse \n\t\t    {\t\n\t\t\t\tdocument.CatalogSectionHeader.search_text.value = \"\";\n\t\t\t\t//return false ;\n\t\t\t}\n\t   }\n\t  }\n\t \n   }*/\n   function callSearch()\n   {\t   \n\t   var sText = new String();\n\t   sText = document.detailUpperForm.search_text.value;\n\t   var searchlink=document.detailUpperForm.searchinglink.value;\t  \n\t /*  if((sText==\"\")||(sText==null)||(sText==\"null\"))\n\t   {\t\t   \n\t\t //parent.parent.callOderCatalog(searchlink,sText);\t\t \n\t\t parent.parent.parent.OderCatalogForSelectedIndex(searchlink,sText);\n\t   }\n\t   else\n\t   {\n\t\tif((alpha.charAt(1)).toUpperCase()!=\'T\')\n\t\t{\t\t\t\n\t\t\tif((sText.charAt(0)).toUpperCase()==(alpha.charAt(0)).toUpperCase())\n\t\t\t{\n\t\t         if(sText == \"OTH\")\n\t\t\t\t\t sText = \"Others\" ;\n\t\t\t\t //parent.parent.callOderCatalog(searchlink,sText);\n\t\t\t\t  parent.parent.parent.OderCatalogForSelectedIndex(searchlink,sText);\n\t\t   }\n\t\t   else\n\t\t   {\n\t\t\t    document.detailUpperForm.search_text.value= \"\";\n\t\t\t\t//parent.parent.callOderCatalog(searchlink,sText);\n\t\t   }\n\t\t\tsText = \"\";\n\t   }\n\t   else\n\t   {\n\t\t   // parent.parent.callOderCatalog(searchlink,sText);\t\t \n\t\t  if(sText.length==0){\n\t\t\t   parent.parent.parent.OderCatalogForSelectedIndex(searchlink,sText);\n\t\t   }\n\t\t   else\n\t\t   {\n\t\t   var strCheck = \'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\';\n\t\t   var temp=sText.charAt(0);\n\t\t   \n\t\t\tif (strCheck.indexOf(temp) == -1) \n\t\t\t{\n\t\t\t\t parent.parent.parent.OderCatalogForSelectedIndex(searchlink,sText);\n\t\t\t}\n\t\t\telse \n\t\t    {\n\t\t\t\tdocument.detailUpperForm.search_text.value = \"\";\n\t\t\t\treturn false ;\n\t\t\t}\n\t\t   }\n\t    }\n\t   }*/\n\t    parent.parent.parent.OderCatalogForSelectedIndex(searchlink,sText);\n   }\n\n\n</script>\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/Tabs.css\'></link>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<STYLE TYPE=\"text/css\">\n\tA:active {\n\t\tCOLOR: white;\n\t}\n\tA:visited {\n\t\tCOLOR: white;\n\t}\n\tA:link {\n\t\tCOLOR: white;\n\t}\n\t</STYLE>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n</head>\n \n<body  STYLE=\"\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<form name=\"detailUpperForm\" id=\"detailUpperForm\" method=\"post\" >\n\n<table border=0 id=\"headerTab\" cellpadding=3 cellspacing=0 width=\'100%\' align=\"center\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<tr>\n\t<td colspan=\'2\'>\n\n\t<table align=\'left\' cellspacing=\'3\' id=\"innerCellTab\" cellpadding=\'1\' width=\"30%\" border=\'1\' style=\"\">\n\t\t<tr>\n\t\t\t<td id=\"SelectTab\" class=\"clicked\" width=\"15%\" height=\"20\" onClick=\'parent.parent.parent.selectInsert()\'><a href=\"#\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t\t\t<td id=\"AssociateTab\" class=\"normal\" width=\"15%\" height=\"20\" onClick=\'parent.parent.parent.associated()\'><a href=\"#\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></td>\n\t\t</tr>\n\t</table>\n\t</td>\n</tr>\n\n\n<tr>\n\t<td colspan=\"2\">\n\t<table align=\'center\' cellspacing=\'1\' id=\"alphabet\" cellpadding=\'1\' width=\'100%\' border=\'0\' style=\"\">\n\t<tr>\n\t\t<td>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t</tr>\n\t</table>\n\t</td>\n</tr>\n\n<tr>\n\t<td colspan=\"2\">\n\t<table align=\'center\' cellspacing=\'1\' id=\"searchTxt\" cellpadding=\'1\' width=\"100%\" border=\'0\' style=\"display:none\">\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<td class=\'fields\'>\n\t\t\t<INPUT TYPE=\"text\" name=\"search_text\" id=\"search_text\" value=\"\" onKeyPress=\"return notAllowOtherChar(event)\"; maxlength=\'100\' size=\'40\' ><INPUT TYPE=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\"callSearch()\">\n\t\t</td>    \n\t</tr>\n\t</table>\n\t</td>\n</tr>\n\n\n\n</table>\n\n\n<!-- <input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"> -->\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"alphabetsHtml\" id=\"alphabetsHtml\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' value=\'1\' name=\'mode\' id=\'mode\'>\n<input type=\'hidden\' value=\'N\' name=\'detailPageMode\' id=\'detailPageMode\'>\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"\">\n<input class=\'fields\' type=\"hidden\" name=\"searchinglink\" id=\"searchinglink\" value=\"\">\n\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</form>\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 if(sStyle!=null && sStyle.equals("IeStyle.css")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
  } 
            _bw.write(_wl_block10Bytes, _wl_block10);

	/* Mandatory checks start */
	
	String mode	   = request.getParameter("mode") ;
	// String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	// String Alphabets ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String AlphabetsHtml =  "";
	// String readOnly = "" ;
	// String disabled = "" ;

            _bw.write(_wl_block11Bytes, _wl_block11);
try {
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="OrCommonAlphaLink.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(AlphabetsHtml));
            _bw.write(_wl_block21Bytes, _wl_block21);
}catch(Exception e){
	e.printStackTrace();

}
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Associate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
