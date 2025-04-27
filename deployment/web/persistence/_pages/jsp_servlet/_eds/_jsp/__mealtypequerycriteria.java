package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __mealtypequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealTypeQueryCriteria.jsp", 1709116744000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String locale = (String)session.getAttribute("LOCALE");
	String ph_module_yn = request.getParameter("ph_module_yn");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	String sortorder =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
	String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
	String mealType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MealType.Label","ot_labels") ;
	String order =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Order.Label","ot_labels") ;
	String comSelect   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
	String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
	String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String OPMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OPMealOrder.Label","ot_labels");
	String EMMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.EMMealOrder.Label","ds_labels");
	String SupplDietOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.SupplementaryDietOrder.Label","ds_labels");//MMS-QH-CRF-0079
	//String STMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.PlaceStaffMealOrder.Label","ds_labels");//ML-MMOH-CRF-0820 and (Commented Against ML-MOH-CRF-1006)
	String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.yes.Label","ot_labels");
	String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.no.Label","ot_labels");
	StringBuffer strbuff;
	String IPMealOrder =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.IPMealOrder.Label","ds_labels"); //Added Against ML-MOH-CRF-1006
	Connection con=null ;

try {

		con  =  ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");
		firstItem.add(mealType);
		firstItem.add("meal_Type");
		firstItem.add("4");
		firstItem.add("4");
		finAr.add(firstItem);

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");          //Type of item
		secondItem.add(longDesc);    // label
		secondItem.add("long_Desc");  //name of field
		secondItem.add("30");   // SIZE
		secondItem.add("30");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");          //Type of item
		thirdItem.add(shortDesc);    // label
		thirdItem.add("short_Desc");  //name of field
		thirdItem.add("15");   // SIZE
		thirdItem.add("15");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");
		fourthItem.add(order);
		fourthItem.add("order_np");
		fourthItem.add("2");
		fourthItem.add("2");
		finAr.add(fourthItem);

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(nature);  // label
		fifthItem.add("enabled_Yn");//name
		fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
		finAr.add(fifthItem);
		
		//Added Against Start ML-MOH-CRF-1006
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("List");   //Type of item
		sixthItem.add(IPMealOrder);  // label
		sixthItem.add("IPMealOrderYn");//name
		sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(sixthItem);
		//Added Against End ML-MOH-CRF-1006
		
		ArrayList seventhItem = new ArrayList();
		seventhItem.add("List");   //Type of item
		seventhItem.add(OPMealOrder);  // label
		seventhItem.add("OPMealOrder_Yn");//name
		seventhItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(seventhItem);

		ArrayList eightItem = new ArrayList();
		eightItem.add("List");   //Type of item
		eightItem.add(EMMealOrder);  // label
		eightItem.add("EM_Meal_Order_Yn");//name
		eightItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(eightItem);

		//MMS-QH-CRF-0079 Starts
		ArrayList ninthItem = new ArrayList();
		ninthItem.add("List");   //Type of item
		ninthItem.add(SupplDietOrder);  // label
		ninthItem.add("supldietorder_yn");//name
		ninthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(ninthItem);
		//MMS-QH-CRF-0079 Starts

		//ML-MMOH-CRF-0820 Starts
		/* Commented Against ML-MOH-CRF-1006 
		ArrayList tenthItem = new ArrayList();
		tenthItem.add("List");   //Type of item
		tenthItem.add(STMealOrder);  // label
		tenthItem.add("stmealorder_yn");//name
		tenthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
		finAr.add(tenthItem); 
		*/ 
		//ML-MMOH-CRF-0820 Starts

		String[] orderByCols=null;
		String[] orderByColVals=null;

		orderByCols = new String[5];
		orderByColVals = new String[5];

		orderByCols[0] = mealType;
		orderByCols[1] = longDesc;
		orderByCols[2] = shortDesc;
		orderByCols[3] = order;
		orderByCols[4] = nature;

		orderByColVals[0] = "meal_type";
		orderByColVals[1] = "long_desc";
		orderByColVals[2] = "short_desc";
		orderByColVals[3] = "meal_order";
		orderByColVals[4] = "eff_status";

		strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/MealTypeQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
		out.println(strbuff.toString());

	} catch (Exception e) {
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
