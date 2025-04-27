package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;

public final class __fooditemareaquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/FoodItemAreaQueryCriteria.jsp", 1709116728000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);

String locale = (String)session.getAttribute("LOCALE");
String facilityId=(String)session.getAttribute("facility_id");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String queryCriteria = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String kitchen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Kitchen.Label","ot_labels");
String kitchenArea =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.KitchenArea.Label","ot_labels");
String foodItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FoodItem.Label","ot_labels");
// Checkstyle Violation commented by Munisekhar
//String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
//String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

String sql_kitchen = "select kitchen.kitchen_Code code,kitchen.short_Desc sdesc from Ds_Kitchens_Lang_Vw kitchen where kitchen.operating_Facility_Id like '"+facilityId+"'and   kitchen.language_Id = '"+locale+"'and   kitchen.eff_Status ='E'";
String sql_kitchenArea = "select area.kitchen_Area_Code code,area.short_Desc sdesc from Ds_Kitchen_Area area where area.operating_Facility_Id like '"+facilityId+"'	and area.eff_Status ='E'";
String sql_foodItem = "select foodItem.food_Item_Code code,	foodItem.short_Desc sdesc from Ds_Food_Item_Lang_Vw foodItem where foodItem.language_Id like '"+locale+"'	and foodItem.eff_Status ='E'";
StringBuffer strBuff = new StringBuffer();

try {
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	
	firstItem.add("List");   //Type of item
	firstItem.add(kitchen);  // label
	firstItem.add("kitchen");//name
	
	pstmt = con.prepareStatement(sql_kitchen);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str1);//static values that need to be displayed as
	finAr.add(firstItem);
	strBuff.setLength(0);
	//Checkstyle Correction added by Munisekhar
	if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();

	ArrayList secondItem = new ArrayList();
	
	secondItem.add("List");   //Type of item
	secondItem.add(kitchenArea);  // label
	secondItem.add("kitchenArea");//name
	
	pstmt = con.prepareStatement(sql_kitchenArea);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str2);//static values that need to be displayed as
	finAr.add(secondItem);
	strBuff.setLength(0);
	//Checkstyle Correction added by Munisekhar
    if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();
	ArrayList thirdItem = new ArrayList();
	
	thirdItem.add("List");   //Type of item
	thirdItem.add(foodItem);  // label
	thirdItem.add("foodItem");//name
	
	pstmt = con.prepareStatement(sql_foodItem);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str3);//static values that need to be displayed as
	finAr.add(thirdItem);
	strBuff.setLength(0);
	//Checkstyle Correction added by Munisekhar
	if(rst!=null)rst.close();
	if(pstmt!=null)pstmt.close();
	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];
	
	orderByCols[0] = kitchen;
	orderByCols[1] = kitchenArea;
	orderByCols[2] = foodItem;
	
	orderByColVals[0] = "kitchen";
	orderByColVals[1] = "kitchen_Area";
	orderByColVals[2] = "food_Item";
	
	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/FoodItemForKitchenAreaQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	
}
catch (Exception e) {
	System.err.println("Exception is ->"+e);
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
