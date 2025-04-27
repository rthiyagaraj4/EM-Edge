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
import eCommon.XSSRequestWrapper;

public final class __terminologysetforpractitionertypequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologySetForPractitionerTypeQueryCriteria.jsp", 1709117085576L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n   ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n";
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

/*
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*   File Name		:	TerminologySetForPractitionerTypeQueryCriteria.jsp
*	Purpose 			:	to get the criteria for the Query
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

Connection con=null ;
StringBuffer strbuff;
//String orderCatValues = "";

try {
	con = ServiceLocator.getInstance().getConnection(request);
	//HttpSession ss = request.getSession(false);
 
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels"));	  // label
	firstItem.add("term_set_id");	//name of field
	firstItem.add("20");
	firstItem.add("20"); //size
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels")); //label
	secondItem.add("term_set_desc");//name
	secondItem.add("40"); //size
	secondItem.add("60");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));  // label
	thirdItem.add("pract_type");//name
	thirdItem.add("3"); //size
	thirdItem.add("2");  //maxlength
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PractitionerTypeDescription.label","common_labels"));  // label
	fourthItem.add("pract_type_desc");//name
	fourthItem.add("20"); //size
	fourthItem.add("15");  //maxlength
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PractitionerTypeDescription.label","common_labels");

	orderByColVals[0] = "a.term_set_id";
	orderByColVals[1] = "b.term_set_desc";
	orderByColVals[2] = "a.pract_type";
	orderByColVals[3] = "c.desc_userdef";

	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetforPractType.label","mr_labels"),"../jsp/TerminologySetForPractitionerTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( finAr != null )  finAr.clear();

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		ServiceLocator.getInstance().returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
