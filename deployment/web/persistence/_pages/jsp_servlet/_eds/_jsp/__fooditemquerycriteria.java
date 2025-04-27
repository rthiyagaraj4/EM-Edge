package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.Common.DlQuery;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;

public final class __fooditemquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/FoodItemQueryCriteria.jsp", 1709116730000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

String locale = (String)session.getAttribute("LOCALE");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String foodItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FoodItemCode.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
String itemType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemType.Label","ot_labels");
String servingUom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ServingUOM.Label","ot_labels");
String preparationFactor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreparationFactor.Label","ot_labels");
String calorieContent =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CalorieContentUOM.Label","ot_labels");
String preparationUom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreparationUOM.Label","ot_labels");
String baseQty =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreparationBaseQty.Label","ot_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");           //Type of item
	firstItem.add(foodItem);     // label
	firstItem.add("food_Item");   //name of field
	firstItem.add("20"); // SIZE
	firstItem.add("20"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("long_Desc");  //name of field
	secondItem.add("60");   // SIZE
	secondItem.add("60");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortDesc);    // label
	thirdItem.add("short_Desc");  //name of field
	thirdItem.add("30");   // SIZE
	thirdItem.add("30");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(itemType);  // label
	fourthItem.add("item_Type");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_ITEM_TYPE);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("item_type")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str1);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(servingUom);  // label
	fifthItem.add("serving_Uom");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("uom_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	fifthItem.add(str2);//static values that need to be displayed as
	finAr.add(fifthItem);
	strBuff.setLength(0);
	
	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(preparationUom);  // label
	sixthItem.add("preparation_Uom");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("uom_code")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	sixthItem.add(str3);//static values that need to be displayed as
	finAr.add(sixthItem);
	strBuff.setLength(0);
	ArrayList seventhItem = new ArrayList();

	seventhItem.add("Text");          //Type of item
	seventhItem.add(preparationFactor);    // label
	seventhItem.add("preparation_Factor");  //name of field
	seventhItem.add("10");   // SIZE
	seventhItem.add("10");   //LENGTH
	finAr.add(seventhItem);    //add to ArrayList obj finAr

	ArrayList eightItem = new ArrayList();

	eightItem.add("Text");          //Type of item
	eightItem.add(baseQty);    // label
	eightItem.add("base_Qty");  //name of field
	eightItem.add("10");   // SIZE
	eightItem.add("10");   //LENGTH
	finAr.add(eightItem);    //add to ArrayList obj finAr


	ArrayList ninthItem = new ArrayList();

	ninthItem.add("Text");          //Type of item
	ninthItem.add(calorieContent);    // label
	ninthItem.add("calorie_Content");  //name of field
	ninthItem.add("10");   // SIZE
	ninthItem.add("10");   //LENGTH
	finAr.add(ninthItem);    //add to ArrayList obj finAr


	ArrayList tenththItem = new ArrayList();

	tenththItem.add("List");   //Type of item
	tenththItem.add(nature);  // label
	tenththItem.add("enable");//name
	tenththItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(tenththItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[10];
	orderByColVals = new String[10];

	orderByCols[1] = calorieContent;
	orderByCols[2] = nature;
	orderByCols[3] = itemType;
    orderByCols[4] = longDesc;
    orderByCols[5] = baseQty;
    orderByCols[6] = preparationFactor;
    orderByCols[7] = preparationUom;
    orderByCols[8] = servingUom;
    orderByCols[9] = shortDesc;
    orderByCols[0] = foodItem;

	orderByColVals[0] = "food_item_code";
	orderByColVals[1] = "calorific_cont_per_uom";
	orderByColVals[2] = "eff_status";
	orderByColVals[3] = "item_type";
	orderByColVals[4] = "long_desc";
	orderByColVals[5] = "prep_base_qty";
	orderByColVals[6] = "prep_factor";
	orderByColVals[7] = "prep_uom";
	orderByColVals[8] = "serving_uom_code";
	orderByColVals[9] = "short_desc";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/FoodItemQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{    //Checkstyle Correction added by Munisekhar
		if(rst!=null)	rst.close();
		if(pstmt!=null) pstmt.close();
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
