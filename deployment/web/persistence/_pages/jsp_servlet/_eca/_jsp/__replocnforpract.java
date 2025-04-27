package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;

public final class __replocnforpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eCA/jsp/repLocnForPract.jsp", 1653382701439L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1653382731955L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<html>\r\n<HEAD>\r\n<TITLE></TITLE>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\r\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script src=\"../../eCommon/js/common.js\"></script>\r\n<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\r\n<script src=\'../../eCA/js/repResetRunList.js\' language=\'javascript\'></script>\r\n<script>\r\n\r\nfunction search_Code(obj,target)\r\n{\t\r\n\tvar p_facility_id=document.repLocnForPract.p_facility_id.value;\r\n\tif(obj.name==\'p_fr_practitioner_id1\')\r\n\t{\r\n\t\tif((obj.value) == \"null\" || (obj.value ==\"\"))\r\n\t\t{\r\n\t\t\treturn false;\t\t\t\r\n\t\t}\r\n\t\telse\r\n\t\t{\t\t\t\r\n\t\t\r\n\t\t\tvar descriptionval=obj.value;\r\n\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\r\n\r\n\t        var HTMLVal=\"<html><body><form name=\'tempform1\' method=\'post\' action=\'../../eCA/jsp/CAMasterCodeListIntermediate.jsp\'><input type=\'hidden\' name=\'practitioner_id\' value=\'\"+descriptionval+\"\'><input type=\'hidden\' name=\'p_facility_id\' value=\'\"+p_facility_id+\"\'><input type=hidden name=\'PageName\' value=\'repLocnForPract\'><input type=hidden name=\'selFunVal\' value=\'Fr_Practitioner\'></form></body></html>\";\r\n\t\t\t//alert(HTMLVal);\r\n\t\t\tparent.f_query_intermediate.document.write(HTMLVal);\r\n\t\t\t\tif(parent.f_query_intermediate.document.tempform1)\r\n\t\t\t\t\t\tparent.f_query_intermediate.document.tempform1.submit(); \r\n\t\t\t\r\n\t\t}\r\n\t}\r\n\telse if(obj.name==\'p_to_practitioner_id1\')\r\n\t{\r\n\t\tif((obj.value) == \"null\" || (obj.value ==\"\"))\r\n\t\t{\r\n\t\t\treturn false;\t\t\t\r\n\t\t}\r\n\t\telse\r\n\t\t{\t\t\t\r\n\t\t\tvar objname=obj.name;\r\n\t\t\tvar descriptionval=obj.value;\r\n\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\r\n\t        var HTMLVal=\"<html><body><form name=\'tempform1\' method=\'post\' action=\'../../eCA/jsp/CAMasterCodeListIntermediate.jsp\'><input type=\'hidden\' name=\'practitioner_id\' value=\'\"+descriptionval+\"\'><input type=\'hidden\' name=\'p_facility_id\' value=\'\"+p_facility_id+\"\'><input type=hidden name=\'PageName\' value=\'repLocnForPract\'><input type=hidden name=\'selFunVal\' value=\'To_Practitioner\'></form></body></html>\";\r\n\t\t\tparent.f_query_intermediate.document.write(HTMLVal);\r\n\t\t\tif(parent.f_query_intermediate.document.tempform1)\r\n\t\t\t\tparent.f_query_intermediate.document.tempform1.submit(); \r\n\t\t}\r\n\t}\r\n\telse if(obj.name==\'pract\' || obj.name==\'pract1\')\r\n\t{\t\t\r\n\t\tsearchCode(obj,target);\r\n\t}\r\n\t\r\n}\r\nfunction searchCode(obj,target)\r\n{\r\n\t\t\tvar p_facility_id=document.repLocnForPract.p_facility_id.value;\r\n\t\t\tvar retVal = \tnew String();\r\n\t\t\tvar dialogHeight= \"28\" ;\r\n\t\t\tvar dialogWidth\t= \"43\" ;\r\n\t\t\tvar status = \"no\";\r\n\t\t\tvar arguments\t= \"\" ;\r\n\t\t\tvar sql=\"\";\r\n\t\t\tvar search_code=\"\";\r\n\t\t\tvar search_desc=\"\";\r\n\t\t\tvar tit=\"\";\t\t\r\n\t\t\tvar  fac_id=\'\';\r\n\t\t\tif(obj.name==\"pract\" || obj.name==\"p_fr_practitioner_id1\" || obj.name==\"pract1\" || obj.name==\"p_to_practitioner_id1\")\r\n\t\t\t{\r\n\t\t\t\t\r\n\t\t\t\ttitle=getLabel(\'Common.practitioner.label\',\'common\');\r\n\t\t\t\tsql=\" select distinct b.practitioner_id code, b.practitioner_name description \";\r\n\t\t\t\tsql+=\" from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where \";\r\n\t\t\t\tsql+=\" b.practitioner_id = a.func_role_id and b.operating_facility_id =\'\"+p_facility_id+\"\' and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2\" ;\r\n\t\t\t\tsearch_code=\"practitioner_id\";\r\n\t\t\t\tsearch_desc= \"practitioner_name\";\r\n\t\t\t\t\t\t\r\n\t\t\t}\r\n\t\t\t\tvar argArray = new Array();\r\n\t\t\t\tvar namesArray = new Array();\r\n\t\t\t\tvar valuesArray = new Array();\r\n\t\t\t\tvar datatypesArray = new Array();\r\n\t\t\t\t\r\n\t\t\t\targArray[0] = sql;\r\n\t\t\t\targArray[1] = namesArray;\r\n\t\t\t\targArray[2] = valuesArray;\r\n\t\t\t\targArray[3] = datatypesArray;\r\n\t\t\t\targArray[4] = \"1,2\";\r\n\t\t\t\targArray[5] = target.value;\r\n\t\t\t\targArray[6] = DESC_LINK;\r\n\t\t\t\targArray[7] = CODE_DESC;\r\n\t\t\t\tretArray = CommonLookup( title,argArray );\r\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\r\n\t\t\t\t{\r\n\t\t\t\t\tif(obj.name==\"pract1\") //|| obj.name==\"p_to_practitioner_id1\")\r\n\t\t\t\t\t{\t\t\t\t\t\t\t\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_to_practitioner_id1.value= retArray[1];\t\t\t\t\t\t\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_to_practitioner_id.value= retArray[0];\t\t\t\t\t\t\r\n\t\t\t\t\t}\r\n\t\t\t\t\telse if(obj.name==\"pract\")// || obj.name==\"p_fr_practitioner_id1\")\r\n\t\t\t\t\t{\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_fr_practitioner_id1.value= retArray[1];\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_fr_practitioner_id.value= retArray[0];\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\telse\r\n\t\t\t\t{\r\n\t\t\t\t\tif(obj.name==\"pract1\")// || obj.name==\"p_to_practitioner_id1\")\r\n\t\t\t\t\t{\t\t\t\t\t\t\t\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_to_practitioner_id1.value= \"\";\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_to_practitioner_id.value= \"\";\r\n\t\t\t\t\t}\r\n\t\t\t\t\telse if(obj.name==\"pract\")// || obj.name==\"p_fr_practitioner_id1\")\r\n\t\t\t\t\t{\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_fr_practitioner_id1.value= \"\";\r\n\t\t\t\t\t\tdocument.repLocnForPract.p_fr_practitioner_id.value= \"\";\r\n\t\t\t\t\t}\t\t\t\r\n\t\t\t\t}\r\n}\r\n\r\n\r\n</script>\r\n\r\n</HEAD>\r\n\r\n<BODY onload=\'FocusFirstElement()\' onKeyDown=\"lockKey()\">\r\n<br>\r\n<br>\r\n<form name=\"repLocnForPract\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\r\n<table width=\'80%\' align=\'center\' cellpadding=3 >\r\n<tr>\r\n\t\t<td class=\'COLUMNHEADERCENTER\'  >";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \r\n\t\t</td>\r\n\t\t</tr>\r\n\t<tr>\r\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\r\n\t\t\t<table width=\'80%\' cellPadding=\"3\" cellSpacing=\"0\"  align=\'center\' >\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"center\" width=\"35%\"></td>\r\n\t\t\t\t\t\t<td class=\"label\" width=\"20%\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\r\n\t\t\t\t\t\t<td class=\"label\" width=\"40%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\r\n\t\t\t\t\t\t<td class=\'fields\' width=\'30%\'  ><input type=text onblur=\'search_Code(this, p_fr_practitioner_id1)\'  name=\'p_fr_practitioner_id1\' size=\"25\" maxlength=\"20\" align=\"center\"><input type=\'hidden\'  name=\'p_fr_practitioner_id\' value=\'\'><input type=\'button\' name=\'pract\' value=\'?\' class=\'button\' onclick=\'search_Code(this, p_fr_practitioner_id1)\'>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td  class=\'fields\' width=\'20%\'><input type=text  name=\'p_to_practitioner_id1\' onblur=\'search_Code(this, p_to_practitioner_id1)\' size=\"25\" maxlength=\"20\" align=\"center\"><input type=\'hidden\'  name=\'p_to_practitioner_id\' value=\'\'><input type=\'button\' name=\'pract1\' value=\'?\' class=\'button\' onclick=\'search_Code(this, p_to_practitioner_id1)\'>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\t\t\t\r\n\t\t</table>\r\n\t</td>\r\n</tr>\r\n</table>\r\n<input type=\"hidden\" name=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\r\n<input type=\"hidden\" name=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\r\n<input type=\"hidden\" name=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\r\n<input type=\"hidden\" name=\"p_user_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\r\n\r\n</form>\r\n</BODY>\r\n</HTML>\r\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");	
	String p_module_id		= "CA" ;
	String p_report_id		= "CABLCFPR" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;


            _bw.write(_wl_block4Bytes, _wl_block4);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
