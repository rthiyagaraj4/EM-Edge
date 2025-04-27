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

public final class __diettypequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DietTypeQueryCriteria.jsp", 1709116718000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!-- Added Against ML-MMOH-CRF-0670-US001 -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!-- Added Against ML-MMOH-CRF-0670-US001 -->\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            {DSCommonBeanObj.setFacilityId(session.getAttribute("facility_id").toString()
                );
            }_bw.write(_wl_block6Bytes, _wl_block6);
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
	String longDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LongDescription.Label","ot_labels") ;
	String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ShortDescription.Label","ot_labels") ;
	String ageGroup =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AgeGroup.Label","common_labels");
	String defaultDiet =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DefaultDietType.Label","common_labels");
	String orderCatalogDescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels");
	String defaultFeed =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DefaultFeedType.Label","common_labels");
	String dietCycle =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietCycleType.Label","common_labels");
	String dietCategory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DietCategory.Label","common_labels");
	String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	//ML-MMOH-CRF-0820
	String IPDietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.IPDietType.Label","ds_labels");   
	String DCDietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.DCDietType.Label","ds_labels");   //ML-MMOH-CRF-0820
	String OPDietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.OPDietType.Label","ds_labels");   //ML-MMOH-CRF-0418
	String EMDietType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.EMDietType.Label","ds_labels");    //ML-MMOH-CRF-0418
	String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.yes.Label","ot_labels");
	String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.no.Label","ot_labels");
	String applstafforderyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ApplForStaffOrder.Label","ds_labels"); //ML-MMOH-CRF-0419
	String attdntorderappl_yn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ApplicableFor.Label","ds_labels") +" "+ DSCommonBeanObj.getAttendantLabel(); //ML-MMOH-CRF-0670-US001
	StringBuffer strbuff;

Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rst = null;

	String sql_ageGroup = "select age_group_code code,short_desc sdesc from am_age_group_lang_vw where language_id = '"+locale+"' and eff_status = 'E' order by sdesc";
	String sql_feedType = "select feed_type code,short_desc sdesc from ds_feed_type_lang_vw where language_id = '"+locale+"' and eff_status = 'E' order by sdesc";
	String sql_dietCategory = "select diet_category_code code,description sdesc from ds_diet_category_lang_vw where language_id = '"+locale+"' order by description";
	String sql_orderCatlog = "SELECT A.SHORT_DESC sdesc,A.order_catalog_code code FROM OR_ORDER_CATALOG_LANG_VW A  WHERE A.order_category = 'DS' and A.LANGUAGE_ID='"+locale+"' and a.eff_status='E' order by 1";
	StringBuffer strBuff = new StringBuffer();
try {

   con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");           //Type of item
	firstItem.add(dietType);     // label
	firstItem.add("dietType");   //name of field
	firstItem.add("25"); // SIZE
	firstItem.add("20"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(longDesc);    // label
	secondItem.add("longDesc");  //name of field
	secondItem.add("65");   // SIZE
	secondItem.add("50");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");          //Type of item
	thirdItem.add(shortDesc);    // label
	thirdItem.add("shortDesc");  //name of field
	thirdItem.add("40");   // SIZE
	thirdItem.add("30");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(ageGroup);  // label
	fourthItem.add("ageGroup");//name
	pstmt = con.prepareStatement(sql_ageGroup);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str1 = "";
	str1 =  strBuff.substring(1, strBuff.length());
	fourthItem.add(str1);//static values that need to be displayed as
	finAr.add(fourthItem);
	strBuff.setLength(0);
	

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(defaultDiet);  // label
	fifthItem.add("defaultDiet");//name
	fifthItem.add("B,"+both+",Y,"+"Yes"+",N,"+"No");//static values that need to be displayed as
	finAr.add(fifthItem);

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(orderCatalogDescription);  // label
	sixthItem.add("orderCatalogDescription");//name
	pstmt = con.prepareStatement(sql_orderCatlog);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str3 = "";
	str3 =  strBuff.substring(1, strBuff.length());
	sixthItem.add(str3);//static values that need to be displayed as
	finAr.add(sixthItem);
	strBuff.setLength(0);
	

	ArrayList seventhItem = new ArrayList();
	//Checkstyle Violation commented by Munisekhar
	//String strChk = "";
	seventhItem.add("List");   //Type of item
	seventhItem.add(defaultFeed);  // label
	seventhItem.add("defaultFeed");//name
	pstmt = con.prepareStatement(sql_feedType);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	String str2 = "";
	str2 =  strBuff.substring(1, strBuff.length());
	seventhItem.add(str2);//static values that need to be displayed as
	//seventhItem.add("B,"+both+",E,"+"Yes"+",D,"+"No");
	finAr.add(seventhItem);
	strBuff.setLength(0);
    

	ArrayList eightItem = new ArrayList();

	eightItem.add("List");   //Type of item
	eightItem.add(dietCycle);  // label
	eightItem.add("dietCycle");//name
	eightItem.add("B,"+both+",R,"+enabled+",O,"+disabled);//static values that need to be displayed as
	finAr.add(eightItem);

	ArrayList ninthItem = new ArrayList();

	ninthItem.add("List");   //Type of item
	ninthItem.add(dietCategory);  // label
	ninthItem.add("dietCategory");//name
	pstmt = con.prepareStatement(sql_dietCategory);
	rst = pstmt.executeQuery();
	strBuff.append(","+" "+","+select);
	while(rst.next()){
		strBuff.append(","+rst.getString("code")+","+rst.getString("sdesc"));
	}
	//Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
	
	String str4 = "";
	str4 =  strBuff.substring(1, strBuff.length());
	ninthItem.add(str4);//static values that need to be displayed as
	finAr.add(ninthItem);
	strBuff.setLength(0);


	//ML-MMOH-CRF-0820
	ArrayList tenththItem = new ArrayList();
	tenththItem.add("List");   //Type of item
	tenththItem.add(IPDietType);  // label
	tenththItem.add("ipdiettype_yn");//name
	tenththItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(tenththItem);

	ArrayList eleventhItem = new ArrayList();
	eleventhItem.add("List");   //Type of item
	eleventhItem.add(DCDietType);  // label
	eleventhItem.add("dcdiettype_yn");//name
	eleventhItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(eleventhItem);
	//ML-MMOH-CRF-0820
	
	//ML-MMOH-CRF-0418
	ArrayList twelethItem = new ArrayList();
	twelethItem.add("List");   //Type of item
	twelethItem.add(OPDietType);  // label
	twelethItem.add("opdiettype_yn");//name
	twelethItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(twelethItem);
	//ML-MMOH-CRF-0418

	ArrayList thirteenthItem = new ArrayList();
	thirteenthItem.add("List");   //Type of item
	thirteenthItem.add(EMDietType);  // label
	thirteenthItem.add("emdiettype_yn");//name
	thirteenthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(thirteenthItem);	
	
	//ML-MMOH-CRF-0419 starts Here
	ArrayList forteenthItem = new ArrayList();
	forteenthItem.add("List");   //Type of item
	forteenthItem.add(applstafforderyn);  // label
	forteenthItem.add("applstafforder_yn");//name
	forteenthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(forteenthItem);	
   //ML-MMOH-CRF-0419 Ends Here

   //Added Against ML-MMOH-CRF-0670-US001 Starts Here
	ArrayList fifteenthItem = new ArrayList();
	fifteenthItem.add("List");   //Type of item
	fifteenthItem.add(attdntorderappl_yn);  // label
	fifteenthItem.add("attdntorderappl_yn");//name
	fifteenthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as
	finAr.add(fifteenthItem);
	//Added Against ML-MMOH-CRF-0670-US001 Ends Here
	
	ArrayList sixteenthItem = new ArrayList();
	sixteenthItem.add("List");   //Type of item
	sixteenthItem.add(nature);  // label
	sixteenthItem.add("enable");//name
	sixteenthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(sixteenthItem);	   
	

	String[] orderByCols=null;
	String[] orderByColVals=null;

	orderByCols = new String[10];
	orderByColVals = new String[10];

	orderByCols[0] = dietType;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
    orderByCols[3] = ageGroup;
    orderByCols[4] = defaultDiet;
    orderByCols[5] = orderCatalogDescription;
    orderByCols[6] = defaultFeed;
    orderByCols[7] = dietCycle;
    orderByCols[8] = dietCategory;
    orderByCols[9] = "Nature";

	orderByColVals[0] = "diet_type";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "age_group_code";
	orderByColVals[4] = "default_yn";
	orderByColVals[5] = "order_catalog_code";
	orderByColVals[6] = "default_feed_type";
	orderByColVals[7] = "diet_cycle_type";
	orderByColVals[8] = "diet_category_code";
	orderByColVals[9] = "eff_status";

	strbuff = qrypg.getQueryPage( con,finAr,"Instruments ","../../eDS/jsp/DietTypeQueryResult.jsp?ph_module_yn="+ph_module_yn,sortorder,queryCriteria,comSelect ,orderby,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	
	}catch (Exception e){
		e.printStackTrace();
	System.err.println("Exception is DietTypeQueryCriteria.jsp-->"+e);
}
finally
{
   //Checkstyle Correction added by Munisekhar
    if(rst !=null) rst.close();
    if(pstmt !=null) pstmt.close();
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
