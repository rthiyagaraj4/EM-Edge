package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import org.springframework.context.*;
import org.springframework.beans.factory.*;
import org.springframework.web.context.support.*;
import net.sf.ehcache.*;

public final class __cacheinnerdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/CacheInnerDetails.jsp", 1709116471775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\t\n\t\t<table>\n\t\t\t<th colspan=2 align=center>Details As On&nbsp;&nbsp;";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</th>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<table>\n\t\t\t\t\t\t<th colspan=2>\n\t\t\t\t\t\t\tCache Details\n\t\t\t\t\t\t</th>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache Name&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache maxElementsInMemory&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache maxElementsOnDisk&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache eternal&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache overflowToDisk&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache timeToIdleSeconds&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache timeToLiveSeconds&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache diskPersistent&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache diskExpiryThreadIntervalSeconds&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache memoryStoreEvictionPolicy&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache inMemorySize&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\n\t\t\t\t\t\t</tr>\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache memoryStoreSize&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache diskStoreSize&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<table>\n\t\t\t\t\t\t<th colspan=2>\n\t\t\t\t\t\t\tCache Statistics\n\t\t\t\t\t\t</th>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Associated Cache Name&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache Hits&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache Misses&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache inMemoryHits&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache onDiskHits&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td><b>Cache objectCount&nbsp;&nbsp;</b></td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table> \n\t\t<br />\n\t\t<table>\n\t\t\t<th colspan=2 align=center>Cache Contents (Valid, Non-expired Keys)</th>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<tr>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td><td>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</table>\n\t\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

	private static transient BeanFactory beanFactory;
	private static transient Cache httpSessionCache;
	private static transient Cache messageCache;
	private static transient Cache labelCache;


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

	String cacheName = request.getParameter("cacheName"); 
	
	if (beanFactory == null){
		ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		beanFactory = (BeanFactory)appCtx;
		httpSessionCache =  (Cache)beanFactory.getBean("httpSessionCache");	
		labelCache =  (Cache)beanFactory.getBean("labelCache");		
		messageCache =  (Cache)beanFactory.getBean("messageCache");		
	}
	
	Cache cache = null;
	if(cacheName.equalsIgnoreCase("http.session.cache")){
		cache = httpSessionCache;
	}else if(cacheName.equalsIgnoreCase("label.cache")){
		cache = labelCache;
	}else if(cacheName.equalsIgnoreCase("message.cache")){
		cache = messageCache;
	}
		
	Statistics statistics = cache.getStatistics();

	List keyList = cache.getKeysWithExpiryCheck();
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(new java.util.Date()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(cache.getCacheConfiguration().getName()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(cache.getCacheConfiguration().getMaxElementsInMemory()));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(cache.getCacheConfiguration().getMaxElementsOnDisk()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(cache.getCacheConfiguration().isEternal()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(cache.getCacheConfiguration().isOverflowToDisk()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(cache.getCacheConfiguration().getTimeToIdleSeconds()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cache.getCacheConfiguration().getTimeToLiveSeconds()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cache.getCacheConfiguration().isDiskPersistent()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cache.getCacheConfiguration().getDiskExpiryThreadIntervalSeconds()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(cache.getCacheConfiguration().getMemoryStoreEvictionPolicy()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cache.calculateInMemorySize()+" in bytes"));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cache.getMemoryStoreSize()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cache.getDiskStoreSize()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(statistics.getAssociatedCacheName()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(statistics.getCacheHits()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(statistics.getCacheMisses()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(statistics.getInMemoryHits()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(statistics.getOnDiskHits()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(statistics.getObjectCount()));
            _bw.write(_wl_block22Bytes, _wl_block22);
 for(int j=0;j<keyList.size();j++){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((j+1)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(keyList.get(j).toString()));
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
