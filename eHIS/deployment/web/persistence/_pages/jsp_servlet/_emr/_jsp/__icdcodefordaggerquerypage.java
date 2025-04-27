package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import webbeans.eCommon.*;

public final class __icdcodefordaggerquerypage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDCodeForDaggerQueryPage.jsp", 1709118931970L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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

/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Asterisk Codes for Dagger Codes 
/// Developer		:	SRIDHAR R
/// Created On		:	2 DEC 2004
/// Function 		:   Used to build the query page...
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try 
{
	con=ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList secondItem1=new ArrayList();
		secondItem1.add("Text");  //Type of item
		secondItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DaggerCode.label","mr_labels"));  // label
		secondItem1.add("dagger_code");   //name of field
		secondItem1.add("10");	// SIZE
		secondItem1.add("10");	//LENGTH
	finAr.add(secondItem1); //add to ArrayList obj finAr

	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Dagger.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));	  // label
		firstItem.add("dagger_desc");	//name of field
		firstItem.add("20");	// SIZE
		firstItem.add("70");	//LENGTH 
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AsteriskCode.label","mr_labels"));  // label
		secondItem.add("astk_code");   //name of field
		secondItem.add("10");	// SIZE
		secondItem.add("10");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));  // label
		thirdItem.add("astk_desc");   //name of field
		thirdItem.add("20");
		thirdItem.add("70");	//LENGTH
	finAr.add(thirdItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DaggerCode.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Dagger.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AsteriskCode.label","mr_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Asterisk.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");

	orderByColVals[0] = "DAG_DIAG_CODE";
	orderByColVals[1] = "DAG_SHORT_DESC";
	orderByColVals[2] = "ASTK_DIAG_CODE";
	orderByColVals[3] = "ASTK_SHORT_DESC";


	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AsteriskCodeforDaggerCode.label","mr_labels"),"../jsp/ICDCodeForDaggerQueryPageResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

} catch (Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block8Bytes, _wl_block8);
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
