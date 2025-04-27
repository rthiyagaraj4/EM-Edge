package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __blpolicytypequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPolicyTypeQueryCriteria.jsp", 1709114576946L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--  \nSr No        Version           Incident        SCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V200904            72977         NMC-JD-CRF-0059       Mohana Priya K\n2  \t\t\t V211020\t\t\t\t\t\t\t\t\t\t\tMohanapriya K\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	String sortorder =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
	String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
	String code =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.POLICY_TYPE_CODE.label","bl_labels");
	String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GosiPolicy.label","bl_labels");
	String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");

	StringBuffer strbuff;
	boolean siteSpec=false;
	String sitespecval="N";
	PreparedStatement stmt = null;
	ResultSet rs = null;

	Connection con=null ;
	try{
		con=ConnectionManager.getConnection(request);
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_TYPES");
			if(siteSpec){
				sitespecval="Y";
			}else{
				sitespecval="N";
			}
			}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception in sitespec is "+e);
			}
			finally{
				try{
					if(stmt!=null) stmt.close();
					if(rs!=null)rs.close();
					//ConnectionManager.returnConnection(con); //V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					//out.println("Exception is "+e);
				}
			}
	try {
			//con  =  ConnectionManager.getConnection(request); //V211020

			ArrayList finAr = new ArrayList();
			ArrayList firstItem = new ArrayList();
			firstItem.add("Text");           //Type of item
			firstItem.add(code);     // label
			firstItem.add("policy_type_code"); 
			firstItem.add("40"); 
			firstItem.add("20"); 
			finAr.add(firstItem);//add to ArrayList obj finAr

			ArrayList secondItem = new ArrayList();

			secondItem.add("Text");          //Type of item
			secondItem.add(description);    // label
			secondItem.add("long_desc");  //name of field
			secondItem.add("40");   // SIZE
			secondItem.add("100");   //LENGTH
			finAr.add(secondItem);    //add to ArrayList obj finAr

			ArrayList thirdItem = new ArrayList();
			thirdItem.add("Text");          //Type of item
			thirdItem.add(shortDesc);    // label
			thirdItem.add("short_desc");  //name of field
			thirdItem.add("40");   // SIZE
			thirdItem.add("40");   //LENGTH
			finAr.add(thirdItem);    //add to ArrayList obj finAr

			if("Y".equals(sitespecval)){
				ArrayList fourthItem = new ArrayList();
				fourthItem.add("Check");   //Type of item
				fourthItem.add(nature);  // label
				fourthItem.add("gosipolicy");//name
				finAr.add(fourthItem);
			}

			String[] orderByCols=null;
			String[] orderByColVals=null;

			orderByCols = new String[2];
			orderByColVals = new String[2];

			orderByCols[0] = description;
			orderByCols[1] = shortDesc;

			orderByColVals[0] = "long_desc";
			orderByColVals[1] = "short_desc";

			strbuff = qrypg.getQueryPage( con,finAr,code ,"../../eBL/jsp/BLPolicyTypeQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);

			out.println(strbuff.toString());
		} catch (Exception e) {
			e.printStackTrace();
			//out.println("Exception in BLPolicyType=="+e);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
