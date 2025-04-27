package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __rcrdapprovalpolicydetailstab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/RcrdApprovalPolicyDetailsTab.jsp", 1732867407584L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\'../js/EncounterSpecPolicyDefnSrch.js\'></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction fnShowMainTabDetails(object){\n\t\t\n\t\tif(object == \'inclExclCoverage\'){\n\t\t\tvar mode = parent.PolicyDetailsPage.document.forms[0].mode.value;\n\t\t\tvar payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;\n\t\t\tvar payer = parent.PolicyDetailsPage.document.forms[0].payer.value;\n\t\t\tvar policy = parent.PolicyDetailsPage.document.forms[0].policy.value;\n\t\t\tvar patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;\n\t\t\tvar startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;\n\t\t\tvar endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;\n\t\t\t\n\t\t\tvar visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;\n\t\t\tvar acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;\n\t\t\tvar priority = parent.PolicyDetailsPage.document.forms[0].priority.value;\n\t\t\tvar episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;\n\t\t\tvar episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;\n\t\t\tvar auth = parent.PolicyDetailsPage.document.forms[0].auth.value;\n\t\t\tdocument.getElementById(\'inclExclCoverage\').className = \"tabClicked\";\n\t\t\tdocument.getElementById(\'inclExclCoveragespan\').className = \"tabSpanclicked\";\n\t\t\tdocument.getElementById(\'preApproval\').className = \"tabA\";\n\t\t\tdocument.getElementById(\'preApprovalspan\').className = \"tabAspan\";\t\n\t\t\t//getXMLString(\'preApproval\');\n\t\t\tparent.PolicyDetailsPage.location.href = \'../../eBL/jsp/RcrdApprovalPolicyDetailsInclExcl.jsp?mode=\'+mode+\'&payergroupCode=\'+payerGroup+\'&payerCode=\'+payer+\'&policyCode=\'+policy+\'&patinetId=\'+patientId+\'&startDate=\'+startDate+\'&endDate=\'+endDate+\n\t\t\t\t\t\t\t\t\t\t\t\t\t\'&visitId=\'+visitId+\'&acctSeq=\'+acctSeq+\'&priority=\'+priority+\'&episodeType=\'+episodeType+\'&episodeId=\'+episodeId+\'&auth=\'+auth;\n\t\t}\n\t\telse if(object == \'preApproval\'){\n\t\t\tvar mode = parent.PolicyDetailsPage.document.forms[0].mode.value;\n\t\t\tvar payerGroup = parent.PolicyDetailsPage.document.forms[0].payerGroup.value;\n\t\t\tvar payer = parent.PolicyDetailsPage.document.forms[0].payer.value;\n\t\t\tvar policy = parent.PolicyDetailsPage.document.forms[0].policy.value;\n\t\t\tvar patientId = parent.PolicyDetailsPage.document.forms[0].patientId.value;\n\t\t\tvar startDate = parent.PolicyDetailsPage.document.forms[0].startDate.value;\n\t\t\tvar endDate = parent.PolicyDetailsPage.document.forms[0].endDate.value;\n\t\t\t\n\t\t\tvar visitId = parent.PolicyDetailsPage.document.forms[0].visitId.value;\n\t\t\tvar acctSeq = parent.PolicyDetailsPage.document.forms[0].acctSeq.value;\n\t\t\tvar priority = parent.PolicyDetailsPage.document.forms[0].priority.value;\n\t\t\tvar episodeType = parent.PolicyDetailsPage.document.forms[0].episodeType.value;\n\t\t\tvar episodeId = parent.PolicyDetailsPage.document.forms[0].episodeId.value;\n\t\t\tvar auth = parent.PolicyDetailsPage.document.forms[0].auth.value;\n\t\t\tdocument.getElementById(\'preApproval\').className = \"tabClicked\";\n\t\t\tdocument.getElementById(\'preApprovalspan\').className = \"tabSpanclicked\";\n\t\t\tdocument.getElementById(\'inclExclCoverage\').className = \"tabA\";\n\t\t\tdocument.getElementById(\'inclExclCoveragespan\').className = \"tabAspan\";\t\n\t\t\t//getXMLString(\'inclExclCoverage\');\n\t\t\tparent.PolicyDetailsPage.location.href = \'../../eBL/jsp/RcrdApprovalPolicyDetailsPreApproval.jsp?mode=\'+mode+\'&payergroupCode=\'+payerGroup+\'&payerCode=\'+payer+\'&policyCode=\'+policy+\'&patinetId=\'+patientId+\'&startDate=\'+startDate+\'&endDate=\'+endDate+\n\t\t\t\t\t\t\t\t\t\t\t\t\t\'&visitId=\'+visitId+\'&acctSeq=\'+acctSeq+\'&priority=\'+priority+\'&episodeType=\'+episodeType+\'&episodeId=\'+episodeId+\'&auth=\'+auth;\n\t\t}\n\t}\n\t\n\tfunction resizeFramesRd(){\n\t\tdocument.getElementById(\'resizeLink\').style.visibility = \'hidden\';\n\t\tdocument.getElementById(\'resizeBtn\').style.visibility = \'hidden\';\n\t\tdocument.getElementById(\'resetLink\').style.visibility = \'visible\';\n\t\tdocument.getElementById(\'resetBtn\').style.visibility = \'visible\';\n\t\t///parent.document.getElementById(\'ContainerFrame\').rows=\"0%,8%,86%,6%\"; /*cmt for EDGE Work*/\n\t\t//parent.PolicyCoverageMain.document.getElementById(\'ContainerCoverage\').rows=\"100%,0%,0%\";\n\t\t\n\t\tparent.document.getElementById(\"PolicyCoverageMain\").style.height=\"0vh\";\n\t\tparent.document.getElementById(\"PolicyDetailsTab\").style.height=\"8vh\";\n\t\tparent.document.getElementById(\"PolicyDetailsPage\").style.height=\"86vh\";\n\t\tparent.document.getElementById(\"PolicyDetailsAdd\").style.height=\"6vh\";\n\t\t\n\t\t\n\t}\n\n\tfunction resetFramesRd(){\n\t\tdocument.getElementById(\'resizeLink\').style.visibility = \'visible\';\n\t\tdocument.getElementById(\'resizeBtn\').style.visibility = \'visible\';\n\t\tdocument.getElementById(\'resetLink\').style.visibility = \'hidden\';\n\t\tdocument.getElementById(\'resetBtn\').style.visibility = \'hidden\';\n\t\t///parent.document.getElementById(\'ContainerFrame\').rows=\"55%,8%,30%,7%\";\n\t\t//parent.PolicyCoverageMain.document.getElementById(\'ContainerCoverage\').rows=\"36%,10%,54%\";\n\t\t\n\t\tparent.document.getElementById(\"PolicyCoverageMain\").style.height=\"55vh\";\n\t\tparent.document.getElementById(\"PolicyDetailsTab\").style.height=\"8vh\";\n\t\tparent.document.getElementById(\"PolicyDetailsPage\").style.height=\"30vh\";\n\t\tparent.document.getElementById(\"PolicyDetailsAdd\").style.height=\"7vh\";\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<table cellpadding=3 cellspacing=0 border=0 width=\'100%\' align=\"center\">\n<tr width=\'100%\'>\n\t<td width=\"100%\" class=\"white\">\n\t\t<ul id=\'tablist\' class=\'tablist\' style=\'padding-left:0px\'>\n\t\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t\t\t<a onclick=\"fnShowMainTabDetails(\'inclExclCoverage\')\" class=\"tabClicked\" id=\"inclExclCoverage\">\n\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"inclExclCoveragespan\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t</span></a>\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t<a onclick=\"fnShowMainTabDetails(\'preApproval\')\" class=\"tabA\" id=\"preApproval\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"preApprovalspan\">\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\t\n\t\t\t\t\t</span></a>\n\t\t\t</li>\n\t\t\t<li>\n\t\t\t<a id=\"resizeLink\" href=\'javascript:resizeFramesRd()\' style=\"visibility: visible;\"><img id=\"resizeBtn\" alt=\"\" src=\"../../eOT/images/ShowLess.gif\" style=\"visibility: visible;\"> </a>\n\t\t\t<a id=\"resetLink\" href=\'javascript:resetFramesRd()\' style=\"visibility: hidden;\"><img id=\"resetBtn\" alt=\"\" src=\"../../eOT/images/ShowMore.gif\" style=\"visibility: hidden;\"></a>\n\t\t\t</li>\n\t\t</ul>\n\t</td>\t\n\t</tr>\n</table>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PolicyInclExclCoverage.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PolicyInclExclCoverage.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PreApprovalDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PreApprovalDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
