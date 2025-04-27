package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import webbeans.eCommon.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;

public final class __factorquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/FactorQueryCriteria.jsp", 1709117051108L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teMR\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tHema Malini B\n*\tCreated On\t\t:\t27th Dec 2004\n-->\n\n<!--FactorQueryCriteria.jsp-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n   ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage querypage= new ecis.utils.CommonQueryPage();
StringBuffer strbuf;

Connection con=null;
//String function_id=request.getParameter("function_id");

try{
	con=ConnectionManager.getConnection(request);
	
	ArrayList finalArray=new ArrayList();

	ArrayList firstItem=new ArrayList();
	firstItem.add("Text"); //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorCode.label","mr_labels")); // label
	firstItem.add("factor_code"); //name
	firstItem.add("10");  //size
    firstItem.add("10");   //Length
	finalArray.add(firstItem);

    ArrayList secondItem=new ArrayList();
	secondItem.add("Text"); //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorDescription.label","mr_labels")); // label
	secondItem.add("factor_description"); //name
	secondItem.add("30");  //size
    secondItem.add("30");   //Length
	finalArray.add(secondItem);

	ArrayList ThirdItem=new ArrayList();
	ThirdItem.add("List"); //Type of item
	ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorTypes.label","mr_labels")); // label
	ThirdItem.add("factor_type"); //name
	ThirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DefiningCharacteristics.label","mr_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Related.label","mr_labels")+",K,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Risk.label","mr_labels"));  //Values to be passed
   	finalArray.add(ThirdItem);

	ArrayList FourthItem=new ArrayList();
	FourthItem.add("List"); //Type of item
	FourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); // label
	FourthItem.add("eff_status"); //name
	FourthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));  //values to be passed

	finalArray.add(FourthItem);

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorCode.label","mr_labels");
	orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.FactorDescription.label","mr_labels");
	
	orderByColVals[0] = "factor_code";
	orderByColVals[1] = "long_desc";


   strbuf = querypage.getQueryPage(con,finalArray,"factor","../jsp/FactorQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
   out.println(strbuf.toString());

	if ( firstItem != null ) firstItem.clear(); 
	if ( secondItem != null ) secondItem.clear(); 
	if ( ThirdItem != null ) ThirdItem.clear(); 
	if ( FourthItem != null ) FourthItem.clear(); 
	if ( finalArray != null ) finalArray.clear(); 

}catch(Exception e)
{/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	if(con != null)
		ConnectionManager.returnConnection(con,request);
}



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
