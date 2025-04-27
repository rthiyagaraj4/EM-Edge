package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.XHUtil;
import java.util.*;
import com.ehis.util.*;

public final class __showmultiexternalapplications extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ShowMultiExternalApplications.jsp", 1733051677671L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>External applications</title>\n<style type=\"text/css\">\n#centerTable {\n    position:fixed;\n    top: 10%;\n    left: 15%;\n    margin-top: 2em; /*set to a negative number 1/2 of your height*/\n    margin-left: 3em; /*set to a negative number 1/2 of your width*/\n}\n</style>\n<SCRIPT TYPE=\"text/javascript\" SRC=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eXH/js/ExternalApplication.js\"></SCRIPT>\n<SCRIPT TYPE=\"text/javascript\" SRC=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eCommon/js/jquery-3.6.3.js\"></SCRIPT>\n<script src=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<FORM ID=\"showExternalApps\" name=\"showExternalApps\" id=\"showExternalApps\" METHOD=\"post\">\n<BODY leftmargin=0 topmargin=0 >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<TABLE CELLSPACING=\"1\" CELLPADDING=\"3\" ALIGN=\"center\" ID=\"centerTable\">\n<TR>\n\t<TD CLASS=\"LABEL\">Applications</TD>\n\t<TD CLASS=\"FIELDS\">\n\t\t<SELECT ID=\"applicationID\" name=\"applicationID\" id=\"applicationID\" onChange=\"invokeEMExternalApp(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\" STYLE=\"width:150px\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</OPTION>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</SELECT>\n\t</TD>\n</TR>\n</TABLE>\n<INPUT TYPE=\'hidden\' name=\'P_USE_ID\' id=\'P_USE_ID\' ID=\'P_USE_ID\' VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_INV_ORG_ID\' id=\'P_INV_ORG_ID\' ID=\'P_INV_ORG_ID\' VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ENCNTR_DATE\' id=\'P_ENCNTR_DATE\' ID=\'P_ENCNTR_DATE\' VALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_EPISODE_ID\' id=\'P_EPISODE_ID\' ID=\'P_EPISODE_ID\' VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT TYPE=\'hidden\' name=\'callType\' id=\'callType\' ID=\'callType\' VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ACCESSION_NUM\' id=\'P_ACCESSION_NUM\' ID=\'P_ACCESSION_NUM\' VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_MULTI_LANG_YN\' id=\'P_MULTI_LANG_YN\' ID=\'P_MULTI_LANG_YN\' VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_CUST_CODE\' id=\'P_CUST_CODE\' ID=\'P_CUST_CODE\' VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_RESP_ID\' id=\'P_RESP_ID\' ID=\'P_RESP_ID\' VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_Ext_Input_Key\' id=\'P_Ext_Input_Key\' ID=\'P_Ext_Input_Key\' VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ACCESS_RIGHTS\' id=\'P_ACCESS_RIGHTS\' ID=\'P_ACCESS_RIGHTS\' VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_PHYSICIAN_ID\' id=\'P_PHYSICIAN_ID\' ID=\'P_PHYSICIAN_ID\' VALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_PATIENT_ID\' id=\'P_PATIENT_ID\' ID=\'P_PATIENT_ID\' VALUE=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ORDER_TYPE_CODE\' id=\'P_ORDER_TYPE_CODE\' ID=\'P_ORDER_TYPE_CODE\' VALUE=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_FUNCTION_ID\' id=\'P_FUNCTION_ID\' ID=\'P_FUNCTION_ID\' VALUE=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_Ext_Application_ID\' id=\'P_Ext_Application_ID\' ID=\'P_Ext_Application_ID\' VALUE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_MODULE_ID\' id=\'P_MODULE_ID\' ID=\'P_MODULE_ID\' VALUE=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_Connect_string\' id=\'P_Connect_string\' ID=\'P_Connect_string\' VALUE=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_FACILITY_ID\' id=\'P_FACILITY_ID\' ID=\'P_FACILITY_ID\' VALUE=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_LOCN_CODE\' id=\'P_LOCN_CODE\' ID=\'P_LOCN_CODE\' VALUE=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_LANGUAGE_ID\' id=\'P_LANGUAGE_ID\' ID=\'P_LANGUAGE_ID\' VALUE=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ITEM_CODE\' id=\'P_ITEM_CODE\' ID=\'P_ITEM_CODE\' VALUE=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_pwd\' id=\'P_pwd\' ID=\'P_pwd\' VALUE=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_MULTI_SITE_YN\' id=\'P_MULTI_SITE_YN\' ID=\'P_MULTI_SITE_YN\' VALUE=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_EPISODE_TYPE\' id=\'P_EPISODE_TYPE\' ID=\'P_EPISODE_TYPE\' VALUE=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_LOCN_TYPE\' id=\'P_LOCN_TYPE\' ID=\'P_LOCN_TYPE\' VALUE=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_WS_NO\' id=\'P_WS_NO\' ID=\'P_WS_NO\' VALUE=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_Ext_Function\' id=\'P_Ext_Function\' ID=\'P_Ext_Function\' VALUE=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ORDER_ID\' id=\'P_ORDER_ID\' ID=\'P_ORDER_ID\' VALUE=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_VISIT_ID\' id=\'P_VISIT_ID\' ID=\'P_VISIT_ID\' VALUE=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_ENC_STATUS\' id=\'P_ENC_STATUS\' ID=\'P_ENC_STATUS\' VALUE=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<INPUT TYPE=\'hidden\' name=\'P_LOCN_DESC\' id=\'P_LOCN_DESC\' ID=\'P_LOCN_DESC\' VALUE=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n</BODY>\n</FORM>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
             org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("reqParams", java.lang.String .class,"var"));
            __tag0.setValue( XHUtil.getRequestParams(request) 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_USE_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_INV_ORG_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ENCNTR_DATE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_EPISODE_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.callType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ACCESSION_NUM}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_MULTI_LANG_YN}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_CUST_CODE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_RESP_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_Ext_Input_Key}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ACCESS_RIGHTS}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_PHYSICIAN_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_PATIENT_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ORDER_TYPE_CODE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_FUNCTION_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_Ext_Application_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_MODULE_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_Connect_string}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_FACILITY_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_LOCN_CODE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_LANGUAGE_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ITEM_CODE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_pwd}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_MULTI_SITE_YN}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_EPISODE_TYPE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_LOCN_TYPE}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_WS_NO}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_Ext_Function}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ORDER_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_VISIT_ID}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_ENC_STATUS}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${reqParams.P_LOCN_DESC}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag1 = null ;
        int __result__tag1 = 0 ;
        boolean _skipPage__tag1= false;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("application", java.lang.String .class,"var"));
        __tag1.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${applications}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag1;
            __result__tag1 = __tag1.doStartTag();

            if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block11Bytes, _wl_block11);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${application.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${application.value}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag1 = true;
                return true;
            }
            _activeTag=__tag1.getParent();
            _skipPage__tag1 = false;
        } catch (java.lang.Throwable __t){
            __tag1.doCatch(__t);
        } finally {
            __tag1.doFinally();
            if (!_skipPage__tag1){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
                __tag1.release();
            }else{
                _releaseTags(pageContext, __tag1);
            }
        }
        return false;
    }
}
