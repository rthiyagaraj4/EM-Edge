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

public final class __menutimetablequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MenuTimeTableQueryCriteria.jsp", 1709116748000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
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
String facility_id  = (String) session.getValue("facility_id");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String dietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietType.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String kitchenCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.KitchenCode.Label","ot_labels") ;
String mealClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealClass.Label","ot_labels") ;
String mealType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealType.Label","common_labels");
String dayNo =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DayNo.Label","common_labels");
String menu =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Menu.Label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
/*Added Against Start ML-MOH-CRF-1006-US6*/
String patientClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String emergency =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
String inpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
String Outpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
String Staff =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Staff.label","common_labels");
/*Added Against End ML-MOH-CRF-1006-US6*/
StringBuffer strbuff;
Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;
StringBuffer strBuff = new StringBuffer();
try{
   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();	
	/* Added Against Start ML-MOH-CRF-1006-US6 */
	ArrayList PatClassItem = new ArrayList();
	PatClassItem.add("List");
	PatClassItem.add(patientClass);
	PatClassItem.add("patient_class");
	PatClassItem.add("All,"+all+",EM,"+emergency+",IP,"+inpatient+",OP,"+Outpatient+",ST,"+Staff);
	finAr.add(PatClassItem);
	/* Added Against End ML-MOH-CRF-1006-US6 */
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");
	firstItem.add(kitchenCode);
	firstItem.add("kitchen_Code");
	pstmt = con.prepareStatement(DlQuery.DL_GET_KITCHEN_CODE);
	pstmt.setString(1, locale);
	pstmt.setString(2, facility_id);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("kitchen_code")+","+rst.getString("long_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str1);
	finAr.add(firstItem);
	strBuff.setLength(0);
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("List");
	secondItem.add(dietType);
	secondItem.add("diet_Type");
	pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("diet_type")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str2);
	finAr.add(secondItem);
	strBuff.setLength(0);

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");
	thirdItem.add(mealClass);
	thirdItem.add("meal_Class");
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_class")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str3);//static values that need to be displayed as
	finAr.add(thirdItem);
	strBuff.setLength(0);
	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(mealType);  // label
	fourthItem.add("meal_Type");//name
	
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_TYPE);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_type")+","+rst.getString("short_desc"));
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str4 = "";
	str4 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str4);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");
	fifthItem.add(dayNo);
	fifthItem.add("day_No");
	fifthItem.add("5");
	fifthItem.add("5");
	finAr.add(fifthItem);

	ArrayList sixthItem = new ArrayList();
	sixthItem.add("List");
	sixthItem.add(menu);
	sixthItem.add("menu_code");
	pstmt = con.prepareStatement(DlQuery.DL_DS_GET_MENU_FOR_QUERY_CRITERIA);
	pstmt.setString(1, locale);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		// Fix for IN034544
		strBuff.append(","+rst.getString("menu_code")+","+(rst.getString("short_desc").replace(',', ' ')));
		// IN034544 Fix ends
	}
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str5 = "";
	str5 =  strBuff.substring(1, strBuff.length());
	sixthItem.add(str5);
	finAr.add(sixthItem);
	strBuff.setLength(0);

	ArrayList seventhItem = new ArrayList();
	seventhItem.add("List");   //Type of item
	seventhItem.add(nature);  // label
	seventhItem.add("enable");//name
	seventhItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(seventhItem);

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[8];
	orderByColVals = new String[8];

	orderByCols[0] = patientClass;
	orderByCols[1] = kitchenCode;
	orderByCols[2] = dietType;
	orderByCols[3] = mealClass;
    orderByCols[4] = mealType;
    orderByCols[5] = dayNo;
    orderByCols[6] = menu;
    orderByCols[7] = nature;

	orderByColVals[0] = "patient_class";
	orderByColVals[1] = "kitchen_code";
	orderByColVals[2] = "diet_type";
	orderByColVals[3] = "meal_class";
	orderByColVals[4] = "meal_type";
	orderByColVals[5] = "day_no";
	orderByColVals[6] = "menu_code";
	orderByColVals[7] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Menu Time Table ","../../eDS/jsp/MenuTimeTableQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
}catch(Exception e){
	System.err.println("Exception in MenuTimeTableQueryCriteria.jsp--->"+e);
	e.printStackTrace();
}finally{
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
