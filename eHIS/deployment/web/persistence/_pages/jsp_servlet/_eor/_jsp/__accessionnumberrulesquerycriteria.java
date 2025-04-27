package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __accessionnumberrulesquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/AccessionNumberRulesQueryCriteria.jsp", 1719923054000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request); 

ArrayList finAr = new ArrayList();



ArrayList firstItem = new ArrayList();

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
firstItem.add("order_category");//name
String temp=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1_ANOTHER");
temp=temp.replace("?","'"+localeName+"'");
firstItem.add(temp);
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
secondItem.add("order_type_code");//name
secondItem.add("15");
secondItem.add("15");
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
thirdItem.add("order_type_desc");//name
thirdItem.add("15");
thirdItem.add("15");
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Format.label","common_labels"));  // label
fourthItem.add("format");//name
fourthItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---,YY,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByYear.label","or_labels")+",YJ,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ByYearandJulianDate.label","or_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.prefix.label","mp_labels"));  // label
sixthItem.add("prefix");//name
sixthItem.add("15");
sixthItem.add("15");
finAr.add(sixthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.prefix.label","mp_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Format.label","common_labels");


orderByColVals[0] = "a.order_category";
orderByColVals[1] = "a.order_type_code";
orderByColVals[2] = "b.short_desc";
orderByColVals[3] = "a.access_num_prefix";
orderByColVals[4] = "a.access_num_format";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/AccessionNumberRulesQueryResults.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
// finAr.clear();
// firstItem.clear();
// secondItem.clear();
// thirdItem.clear();
// fourthItem.clear();
// sixthItem
} catch (Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
	 e.printStackTrace();//COMMON-ICN-0181
}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
