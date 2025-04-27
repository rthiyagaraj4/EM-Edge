package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public final class __pmbcodequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/PMBCodeQueryCriteria.jsp", 1709117066123L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--Created by Thamizh selvi on 04/10/2016 for GDOH-CRF-0082-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

try{
	request.setCharacterEncoding("UTF-8");
	Connection conn=null ;
	conn = (Connection) session.getValue( "connection" );
	ArrayList PMBCodeValues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCode.label","mr_labels"));	  
	firstItem.add("PMBCode");	
	firstItem.add("20"); 
	firstItem.add("20"); 
	PMBCodeValues.add(firstItem); 
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text"); 
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCodeDescription.label","mr_labels")); 
	secondItem.add("PMBCode_Desc");
	secondItem.add("60"); 
	secondItem.add("60");  
	PMBCodeValues.add(secondItem); 

    ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");   
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels")); 
	thirdItem.add("TermCode");
	thirdItem.add("20"); 
	thirdItem.add("20");  
	PMBCodeValues.add(thirdItem); 

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCodeDescription.label","common_labels")); 
	fourthItem.add("TermCode_Desc");
	fourthItem.add("60");
	fourthItem.add("60");  
	PMBCodeValues.add(fourthItem);
	
	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCode.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCodeDescription.label","mr_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCodeDescription.label","common_labels");
	orderByColVals[0] = "pmb_code";
	orderByColVals[1] = "pmb_desc";
	orderByColVals[2] = "term_code";
	orderByColVals[3] = "term_desc";

	strbuff = qrypg.getQueryPage(conn,PMBCodeValues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","labelmon_labels"),"../jsp/PMBCodeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( PMBCodeValues != null )  PMBCodeValues.clear();

	} catch (Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}	
	finally	{}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
