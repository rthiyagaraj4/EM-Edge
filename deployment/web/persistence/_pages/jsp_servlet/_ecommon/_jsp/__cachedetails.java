package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.web.context.support.*;
import net.sf.ehcache.*;

public final class __cachedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/CacheDetails.jsp", 1709116502654L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n\t<head>\n\t\t<title> EHCache Details for IBA-EHIS </title>\n\t\t<meta name=\"generator\" content=\"editplus\" />\n\t\t<meta name=\"author\" content=\"\" />\n\t\t<meta name=\"keywords\" content=\"\" />\n\t\t<meta name=\"description\" content=\"\" />\n\t\t<script type=\"text/javascript\">\n\t\t\t\n\t\t\tfunction getXHR(){\n\t\t\t\tvar request = false;\n\t\t\t\ttry {\n\t\t\t\t\trequest = new XMLHttpRequest();\n\t\t\t\t}catch (trymicrosoft) {\n\t\t\t\t\ttry {\n\t\t\t\t\t\trequest = new ActiveXObject(\"Msxml2.XMLHTTP\");\n\t\t\t\t\t}catch (othermicrosoft) {\n\t\t\t\t\t\ttry {\n\t\t\t\t\t\t\trequest = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t\t\t\t\t} catch (failed) {\n\t\t\t\t\t\t\trequest = false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif (!request){\n\t\t\t\t\talert(\"System Error initializing XMLHttpRequest!\");\n\t\t\t\t\treturn;\n\t\t\t\t}else return request;\n\t\t\t}\n\n\n\t\t\tfunction showDetails(cache){\n\t\t\t\tvar xhr =  getXHR();\n\t\t\t\tvar url = \"../../eCommon/jsp/CacheInnerDetails.jsp?cacheName=\"+cache;\n\t\t\t\txhr.open(\"POST\", url, false);\n\t\t\t\txhr.setRequestHeader(\"Content-Type\",\"text/html\")\n\t\t\t\txhr.send(\"\");\n\t\t\t\tvar resText = xhr.responseText;\n\t\t\t\tvar t = document.getElementsByTagName(\"DIV\");\n\t\t\t\tfor(j=0;j<t.length;j++){\t\t\t\t\t\n\t\t\t\t\tif (t[j].id == \'DetailsTable\') {\t\t\t\t\t\t\n\t\t\t\t\t\tt[j].innerHTML = resText; \n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\t\n\t\t\t}\n\t\t</script>\n\t</head>\n\t<body onKeyDown = \'lockKey()\'>\n\t\t<table id=\"MainTable\">\n\t\t\t<tr>\n\t\t\t\t<td><b>Cache Name&nbsp;&nbsp;</b></td>\n\t\t\t\t<td><b>Statistics&nbsp;&nbsp;</b></td>\n\t\t\t\t<td><b>Contents&nbsp;&nbsp;</b></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td><b>Http Session Cache&nbsp;&nbsp;</b></td>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&nbsp;&nbsp;</td>\n\t\t\t\t<td><a href=\"javascript:showDetails(\'http.session.cache\')\"><b>Contents</b></a></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td><b>Label Cache&nbsp;&nbsp;</b></td>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&nbsp;&nbsp;</td>\n\t\t\t\t<td><a href=\"javascript:showDetails(\'label.cache\')\"><b>Contents</b></a></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td><b>Message Cache&nbsp;&nbsp;</b></td>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&nbsp;&nbsp;</td>\n\t\t\t\t<td><a href=\"javascript:showDetails(\'message.cache\')\"><b>Contents</b></a></td>\n\t\t\t</tr>\n\t\t</table>\t\t\n\t\t<div id=\"DetailsTable\">\t\t\t\n\t\t</div>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	private static transient BeanFactory beanFactory;
	private static transient Cache httpSessionCache;
	private static transient Cache messageCache;
	private static transient Cache labelCache;
	private static transient CacheManager cacheManager;


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);


	if (beanFactory == null){
		ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		beanFactory = (BeanFactory)appCtx;
		cacheManager = (CacheManager)beanFactory.getBean("ehCacheManager");
		
		httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");	
		labelCache =  (Cache)beanFactory.getBean("labelCache");		
		messageCache =  (Cache)beanFactory.getBean("messageCache");		
	}

	/*String[]cacheNames = cacheManager.getCacheNames();
	*/
	

	Statistics sessionStatistics = httpSessionCache.getStatistics();
	Statistics labelStatistics = labelCache.getStatistics();
	Statistics messageStatistics = messageCache.getStatistics();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sessionStatistics.toString()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(labelStatistics.toString()));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(messageStatistics.toString()));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
