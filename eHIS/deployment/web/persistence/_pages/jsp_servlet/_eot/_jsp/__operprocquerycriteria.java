package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import eCommon.Common.*;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __operprocquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperProcQueryCriteria.jsp", 1709120274000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");;
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

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();


String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
//String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
//String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LongDesc.label","or_labels");
//String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ShortDesc.label","or_labels");
String longdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
String shortdescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
String longDesc =longdescription;//com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LongDesc.label","or_labels");
String shortDesc =shortdescription;//com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ShortDesc.label","or_labels");
//String equipmentCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.EquipmentCode.Label","ot_labels");
//String equipments =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Equipments.Label","ot_labels");
String operationsProcedures =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
String catalogCrossReference =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CatalogCrossReference.label","common_labels");
String speciality =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String operationCode =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationCode.Label","ot_labels");
String operationType =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationType.Label","ot_labels");
String status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");

StringBuffer strbuff;

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
ArrayList secondItem = new ArrayList();
ArrayList thirdItem = new ArrayList();
ArrayList fourthtem = new ArrayList();
ArrayList fifthitem = new ArrayList();
ArrayList sixthitem = new ArrayList();
ArrayList ninthItem = new ArrayList();



Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
		
firstItem.add("Text");           //Type of item
firstItem.add(operationCode);     // label
firstItem.add("oper_code");   //name of field
firstItem.add("10"); // SIZE
firstItem.add("10"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr



secondItem.add("Text");          //Type of item
secondItem.add(longdescription);    // label
secondItem.add("long_desc");  //name of field
secondItem.add("60");   // SIZE
secondItem.add("60");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr



thirdItem.add("Text");          //Type of item
thirdItem.add(shortdescription);    // label
thirdItem.add("short_desc");  //name of field
thirdItem.add("40");   // SIZE Modified Against ML-MMOH-CRF-0432
thirdItem.add("40");   //LENGTH Modified Against ML-MMOH-CRF-0432
finAr.add(thirdItem);    //add to ArrayList obj finAr



fourthtem.add("Text");          //Type of item
fourthtem.add(operationType);    // label
fourthtem.add("oper_type_code");  //name of field
fourthtem.add("4");   // SIZE
fourthtem.add("4");   //LENGTH
finAr.add(fourthtem);    //add to ArrayList obj finAr




fifthitem.add("Text");          //Type of item
fifthitem.add(catalogCrossReference);    // label
fifthitem.add("order_catalog_code");  //name of field
fifthitem.add("20");   // SIZE
fifthitem.add("20");   //LENGTH
finAr.add(fifthitem);    //add to ArrayList obj finAr



sixthitem.add("Text");          //Type of item
sixthitem.add(speciality);    // label
sixthitem.add("speciality_code");  //name of field
sixthitem.add("4");   // SIZE
sixthitem.add("4");   //LENGTH
finAr.add(sixthitem);    //add to ArrayList obj finAr

				


ninthItem.add("List");   //Type of item
ninthItem.add(nature);  // label
ninthItem.add("status");//name
ninthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
finAr.add(ninthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = operationCode;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
	orderByCols[3] = status;

	orderByColVals[0] = "oper_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "status";


strbuff = qrypg.getQueryPage( con,finAr,operationsProcedures,"../../eOT/jsp/OperProcQueryResult.jsp",sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthtem.clear();
	fifthitem.clear();
	sixthitem.clear();
	ninthItem.clear();

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
