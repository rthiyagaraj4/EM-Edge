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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;

public final class __mealcategoryquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealCategoryQueryCriteria.jsp", 1709116736000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            {DSCommonBeanObj.setFacilityId(session.getAttribute("facility_id").toString()
                );
            }_bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);

String locale = (String)session.getAttribute("LOCALE");
String ph_module_yn = request.getParameter("ph_module_yn");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String dietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietType.Label","ot_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.select.Label","ot_labels");
String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String mealClass =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealClass.Label","ot_labels") ;
String mealCategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealCategory.Label","ot_labels") ;
//ML-MMOH-CRF-0406
String Attendent_Label_Name="";
String facility_id	= (String)session.getAttribute("facility_id");
//String DS_Param_Sql="select Attendent_Label_Name from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
//ML-MMOH-CRF-0406
StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;//,pstmt1=null;//ML-MMOH-CRF-406
ResultSet rst = null;//,rs1=null;//ML-MMOH-CRF-406
StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("List");   //Type of item
	firstItem.add(mealCategory);  // label
	firstItem.add("meal_Category");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CATEGORY);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_category_code")+","+rst.getString("description"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	firstItem.add(str1);//static values that need to be displayed as
	finAr.add(firstItem);
	strBuff.setLength(0);
	

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");   //Type of item
	secondItem.add(dietType);  // label
	secondItem.add("diet_Type");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("diet_type")+","+rst.getString("short_desc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	secondItem.add(str3);//static values that need to be displayed as
	finAr.add(secondItem);
	strBuff.setLength(0);
	

	ArrayList thirdItem = new ArrayList();
	//Checkstyle Violation commented by Munisekhar
	//String strChk = "";
	thirdItem.add("List");   //Type of item
	thirdItem.add(mealClass);  // label
	thirdItem.add("meal_Class");//name
	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("meal_class")+","+rst.getString("short_desc"));
	}
   //Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	thirdItem.add(str2);//static values that need to be displayed as
	//seventhItem.add("B,"+both+",E,"+"Yes"+",D,"+"No");
	finAr.add(thirdItem);
	strBuff.setLength(0);
	

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = mealCategory;
	orderByCols[1] = dietType;
	orderByCols[2] = mealClass;

	orderByColVals[0] = "meal_category_code";
	orderByColVals[1] = "default_diet_type";
	orderByColVals[2] = "default_meal_class";
	//ML-ML-MMOH-CRF-0406 STARTS
	//pstmt1 = con.prepareStatement(DS_Param_Sql);	
	/*rs1=pstmt1.executeQuery();
	if(rs1.next()){
		//Attendent_Label_Name=rs1.getString("Attendent_Label_Name");
		System.err.println("INSIDE Attendent_Label_Name:"+Attendent_Label_Name);
	}*/
	Attendent_Label_Name=DSCommonBeanObj.getAttendantLabel();
	//ML-MMOH-CRF-0406 ENDS
	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/MealCategoryQueryResult.jsp?ph_module_yn="+ph_module_yn+"&Attendent_Label_Name="+Attendent_Label_Name,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");//ML-MMOH-CRF-0406
	out.println(strbuff.toString());
} catch (Exception e) {
	System.err.println("Exception is ->"+e);
}

finally
{

    if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
