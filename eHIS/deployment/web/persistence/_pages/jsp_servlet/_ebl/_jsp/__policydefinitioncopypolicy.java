package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __policydefinitioncopypolicy extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PolicyDefinitionCopyPolicy.jsp", 1709114757990L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version             TFS\t\t\tSCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V201207            9896\t\t  MMS-KH-SCF-0114       Ramkumar/MuthuN\n-----------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Copy Policy</title>\n<script language=\"javascript\" src=\"../../eBL/js/PolicyDefinition.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<body>\n<form name=\'frmCopyPolicy\' id=\'frmCopyPolicy\' method=\'post\'>\n\t<table width=\"90%\" align=\"center\">\n\t\t<tr>\n\t\t\t<td width=\'35%\' class=\'label\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t<td width=\'65%\' class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'payerGroup2\' id=\'payerGroup2\' size=\'40\' maxlength=\'40\' value=\'\' onblur=\'if(this.value!=\"\"){ callCommonValidation(3,payerGroup2,payerCode2); validateCopyPolicy(payerCode2,payerCode,policyTypeCode)}\'/>\n\t\t\t\t<input type=\'hidden\' name=\'payerCode2\' id=\'payerCode2\' value=\'\'>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerGroup2_btn\" id=\"payerGroup2_btn\" value=\'?\' onClick=\"callCommonValidation(3,payerGroup2,payerCode2);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>   \n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  width=\'35%\' class=\'label\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t<td  width=\'65%\' class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'payerGroup1\' id=\'payerGroup1\' size=\'40\' maxlength=\'40\'  value=\'\' onblur=\'if(this.value!=\"\"){ callCommonValidation(2,payerGroup1,payerCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);}\'/>\n\t\t\t\t<input type=\'hidden\' name=\'payerCode\' id=\'payerCode\' value=\'\'>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"payerGroup1_btn\" id=\"payerGroup1_btn\" value=\'?\' onClick=\"callCommonValidation(2,payerGroup1,payerCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>   \n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t</tr>\t\t\n\t\t<tr>\n\t\t\t<td  width=\'35%\' class=\'label\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td  width=\'65%\' class=\'fields\' >\n\t\t\t\t<input type=\'text\' name=\'policyType\' id=\'policyType\' size=\'40\' maxlength=\'40\' value=\'\' onblur=\'if(this.value!=\"\"){ callCommonValidation(4,policyType,policyTypeCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);}\'/>\n\t\t\t\t<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\' value=\'\'>\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"policyType_btn\" id=\"policyType_btn\" value=\'?\'  onClick=\"callCommonValidation(4,policyType,policyTypeCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);\" tabindex=\'2\'>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>  \n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\'35%\'></td>\n\t\t\t<td width=\'65%\'>\n\t\t\t<input type=\'button\' class=\'button\' value=\'Apply\' onclick=\'fnApplyCopyPolicy(payerCode2,payerCode,policyTypeCode)\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\'button\' type=\'button\' value=\'Cancel\' onclick=\'fnCancelCopyPolicy()\'></td>\n\t\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n    <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=\'hidden\' name=\'toPayerCode\' id=\'toPayerCode\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n    <input type=\'hidden\' name=\'toPayer\' id=\'toPayer\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\'toPolicy\' id=\'toPolicy\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'startDate\' id=\'startDate\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'endDate\' id=\'endDate\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<!-- V201207 -->\n\t<input type=\'hidden\' name=\'pageInfo\' id=\'pageInfo\' id=\'pageInfo\' value=\'PolicyInfo\'>\n\t<input type=\'hidden\' name=\'siteSpecPolDefIncExc\' id=\'siteSpecPolDefIncExc\' id=\'siteSpecPolDefIncExc\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\'hidden\' name=\"siteSpecPolDefRemarks\" id=\"siteSpecPolDefRemarks\" id=\"siteSpecPolDefRemarks\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<!-- V201207 -->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	String locale = request.getParameter("locale");
	String facility_id = request.getParameter("facility_id"); 
	String toPayerCode = request.getParameter("toPayerCode");
	String toPayer = request.getParameter("toPayer"); 
	String toPolicy = request.getParameter("toPolicy");
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	//V201207
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	Boolean siteSpecPolDefRemarks=false;
	siteSpecPolDefRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");
	//V201207	

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
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(toPayerCode ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(toPayer ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(toPolicy ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(startDate ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(endDate ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(siteSpecPolDefRemarks ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(siteSpecPolDefRemarks ));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_TYPE.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
