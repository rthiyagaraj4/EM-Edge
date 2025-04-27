package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.GatewayServiceBO;
import java.util.ArrayList;
import java.util.List;

public final class __centralizedcommunicationprocess extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/Centralizedcommunicationprocess.jsp", 1733051188580L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Gateway single Record</title>\n\n<script type=\"text/javascript\" language=\"JAVASCRIPT\"\n\tsrc=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<link rel=\'StyleSheet\' href=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\'></link>\n\t\n<style type=\"text/css\">\n\n.COLUMNHEADER {\n\tBACKGROUND-COLOR: #83AAB4;\n\tCOLOR: white;\n\tFONT-SIZE: 8pt;\n\tfont-weight: bolder;\n}\n\n</style>\n\n\n</head>\n<body>\n\t<form name=\"gatewayserverform\" id=\"gatewayserverform\"\n\t\taction=\"../servlet/eXH.CentralizedServlet\" method=\"get\">\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<div style=\"display:block; border: medium; overflow-y:scroll;overflow-x:no;\" >\n\t\t<table id=\"mytable\" cellspacing=0 cellpadding=2 style=\"margin-top: 0px; padding-top: 0px; height: 100%; width: 100%; display:";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =";\"\n\t\t\tborder=\"1\" height=\"100\">\n\t\t\t<thead style=\"text-align: left;\">\n\t\t\t\t<tr>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> status </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> Process status </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> Process </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> ProcessType </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> Application </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> Gateway </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> CommunicationClient </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> StartDateTime </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> EndDateTime </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> LastOutboundRetries </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> LastCommunicationTime </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> LastMsgId </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> TotalMessages </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> TotalQueries </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> StartedBy </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> StoppedBy </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> AddedWorkStation </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> ModifiedWorkStation </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> AddedFacility </font></th>\n\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'><font color=white> ModifiedFacility </font></th>\n\t\t\t\t</tr>\n\t\t\t</thead>\n\t\t\t<tbody>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t<img\n\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t\t\t\t\t\t\talign=\"middle\" height=10 >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td nowrap class=\"QRYEVEN\"><font size=1> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t<td nowrap class=\"QRYEVEN\"><font size=1> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</tbody>\n\t\t</table>\n</div>\n\t\t<table id=\"norecordtable\"\n\t\t\tstyle=\"width: 100%; display:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";\">\n\t\t\t<tr align=\"center\">\n\t\t\t\t<td align=\"center\"><br> <br> <br> <b> <label>Query\n\t\t\t\t\t\t\tcaused no records to be retrived!!!!</label></b></td>\n\t\t\t</tr>\n\t\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		List<GatewayServiceBO> boundList=new ArrayList<GatewayServiceBO>();
		String noResultDisp="none";
		String chkDisp="block";
		
		boundList = (List<GatewayServiceBO>) request
					.getAttribute("commprocesslist");
		
		if(boundList!=null && boundList.size()>0)
		{
			chkDisp="block";
			noResultDisp="none";
		}
		else
		{
			chkDisp="none";
			noResultDisp="block";
		}
			pageContext.setAttribute("boundList", boundList);
			pageContext.setAttribute("chkDisp", chkDisp);
			pageContext.setAttribute("noResultDisp", noResultDisp);

		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(chkDisp ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(noResultDisp ));
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag0 = null ;
        int __result__tag0 = 0 ;
        boolean _skipPage__tag0= false;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("listObject", java.lang.String .class,"var"));
        __tag0.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${boundList}",java.lang.Object.class,pageContext,_jspx_fnmap));
        __tag0.setVarStatus(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("loopStatus", java.lang.String .class,"varStatus"));
        try {_activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block10Bytes, _wl_block10);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.status}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block11Bytes, _wl_block11);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.commStatus}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.processID}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.comType}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.applicationName}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.protocolLinkName}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.clientName}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.startDateTime}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.stopDateTime}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.numOfRetries}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.lastCommDateTime}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.lastMsgId}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.totalMsgs}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.totalQueries}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.startedBy}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.stoppedBy}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.addedWorkStation}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.modifiedWorkStation}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.addFacility}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${listObject.modifiedFacility}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                } while (__tag0.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag0 = true;
                return true;
            }
            _activeTag=__tag0.getParent();
            _skipPage__tag0 = false;
        } catch (java.lang.Throwable __t){
            __tag0.doCatch(__t);
        } finally {
            __tag0.doFinally();
            if (!_skipPage__tag0){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
                __tag0.release();
            }else{
                _releaseTags(pageContext, __tag0);
            }
        }
        return false;
    }
}
