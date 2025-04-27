package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;

public final class __operationsubcategoriesquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationSubCategoriesQueryCriteria.jsp", 1709120270000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")	;
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String sortOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")	;
//String specialityDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels");
//String longdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");	
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label" ,"common_labels");	
String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label" ,"common_labels");
String both=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String nature=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String subcategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SubCategory.Label","ot_labels");
String category =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels");
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
//String locationType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
//String noteType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");

Connection   con  =  ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("List");           //Type of item
firstItem.add(speciality);     // label
firstItem.add("oper_group_code"); 
firstItem.add("SELECT A.SPECIALITY_CODE OPER_GROUP_CODE,B.SHORT_DESC SPECIALITY_DESC  FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"'  AND NVL(EFF_STATUS, 'X')='E' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE ORDER BY 2"); 
finAr.add(firstItem);//add to ArrayList obj finAr
ArrayList secondItem = new ArrayList();
secondItem.add("List");          //Type of item
secondItem.add(category);    // label
secondItem.add("oper_cat_code");  //name of field
//secondItem.add("SELECT OPER_CAT_CODE OPER_CAT_CODE,LONG_DESC OPER_CAT_DESC  FROM OT_OPER_CATEGORY ");  
secondItem.add("SELECT OPER_CAT_CODE OPER_CAT_CODE,LONG_DESC OPER_CAT_DESC  FROM OT_OPER_CATEGORY_LANG_VW where LANGUAGE_ID = '"+locale+"'");   // SIZE
finAr.add(secondItem);    //add to ArrayList obj finAr
ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(subcategory);    // label
thirdItem.add("oper_sub_cat_code");  //name of field
thirdItem.add("4");   // SIZE
thirdItem.add("4");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();
fourthItem.add("Text");
fourthItem.add(description);
fourthItem.add("long_desc");
fourthItem.add("30");
fourthItem.add("30");
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();
fifthItem.add("List");   //Type of item
fifthItem.add(nature);  // label
fifthItem.add("status");//name
fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled+"");//static values that need to be displayed as 
finAr.add(fifthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = speciality ;
	orderByCols[1] = category;
	orderByCols[2] = subcategory;
    orderByCols[3] = description;

	orderByColVals[0] = "short_desc";
	orderByColVals[1] = "a.long_desc";
	orderByColVals[2] = "oper_sub_cat_code";
	orderByColVals[3] = "long_desc";
String params=request.getQueryString();
try {
strbuff = qrypg.getQueryPage( con,finAr,speciality,"../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?"+params,sortOrder,QueryCriteria,select ,orderby,orderByCols, orderByColVals,executequery	);

strbuff = qrypg.getQueryPage( con,finAr,"OperationSubCategories" ,"../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?"+params,sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);
out.println(strbuff.toString());

} catch (Exception e){
	e.printStackTrace();
}

finally
{
	finAr.clear();firstItem.clear();	secondItem.clear();
	thirdItem.clear();	fourthItem.clear();fifthItem.clear();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
