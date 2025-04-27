package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __implantsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ImplantsQueryCriteria.jsp", 1709120232000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
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

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


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
String speciality =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String category1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels");
String type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");
String consignmentItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ConsignmentItem.Label","ot_labels");
String depositRequired =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DepositRequired.Label","ot_labels");
String crossRefMMItem =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CrossRefMMItem.Label","ot_labels");
String prosthesisCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ProsthesisCode.Label","ot_labels");
String implants =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Implants.Label","ot_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String ph_module_yn = request.getParameter("ph_module_yn");

String params = request.getQueryString();
Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(prosthesisCode);     // label
firstItem.add("prosthesis_code");   //name of field
firstItem.add("4"); // SIZE
firstItem.add("4"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(longdescription);    // label
secondItem.add("long_desc");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(shortdescription);    // label
thirdItem.add("short_desc");  //name of field
thirdItem.add("15");   // SIZE
thirdItem.add("15");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

/*ArrayList fourthItem = new ArrayList();

fourthItem.add("Checkbox");   //Type of item
fourthItem.add("Enabled");  // label
fourthItem.add("nature_type");//name
fourthItem.add("EL,Elective,EM,Emergency");//static values that need to be displayed as 
finAr.add(fourthItem); //add to ArrayList obj finAr*/

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(speciality);  // label
fourthItem.add("speciality_code");//name
fourthItem.add("SELECT B.SPECIALITY_CODE,A.SHORT_DESC FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 1");//static values that need to be displayed as 
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");          //Type of item
fifthItem.add(category1);    // label
fifthItem.add("prosthesis_cat_code");  //name of field
fifthItem.add("SELECT PROSTHESIS_CAT_CODE,PROSTHESIS_CAT_DESC FROM OT_PROSTHESIS_CATEGORY WHERE NVL(STATUS,'E') = 'E'ORDER BY 1");   // SIZE
finAr.add(fifthItem);    //add to ArrayList obj finAr


ArrayList sixthItem = new ArrayList();

sixthItem.add("List");          //Type of item
sixthItem.add(type);    // label
sixthItem.add("prosthesis_type");  //name of field
sixthItem.add("SELECT PROSTHESIS_TYPE,PROSTHESIS_TYPE_DESC FROM OT_PROSTHESIS_TYPE WHERE NVL(STATUS,'E') = 'E'ORDER BY 1");   
finAr.add(sixthItem);    //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();
seventhItem.add("List");   //Type of item
seventhItem.add(consignmentItem);  // label
seventhItem.add("consignment_item_yn");//name
seventhItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(seventhItem);

ArrayList eigthItem = new ArrayList();
eigthItem.add("List");   //Type of item
eigthItem.add(depositRequired);  // label
eigthItem.add("deposit_reqd_yn");//name
eigthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(eigthItem);

/*if(ph_module_yn.equals("Y")){

	ArrayList ninthItem = new ArrayList();

	ninthItem.add("List");   //Type of item
	ninthItem.add(crossRefMMItem);  // label
	ninthItem.add("mm_item_code");//name
	ninthItem.add("SELECT ITEM_CODE MM_ITEM_CODE,SUBSTR(SHORT_DESC,1,15) MM_ITEM_DESC  FROM MM_ITEM_LANG_VW WHERE NVL(EFF_STATUS, 'D') = 'E' AND LANGUAGE_ID = '"+locale+"' ORDER BY 1");//static values that need to be displayed as 
	finAr.add(ninthItem);
}*/
ArrayList tenthItem = new ArrayList();
tenthItem.add("List");   //Type of item
tenthItem.add(nature);  // label
tenthItem.add("status");//name
tenthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as 
finAr.add(tenthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

if(ph_module_yn.equals("Y")){
	orderByCols = new String[9];
	orderByColVals = new String[9];

	orderByCols[0] = prosthesisCode;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
    orderByCols[3] = speciality;
    orderByCols[4] = category1;
    orderByCols[5] = type;
    orderByCols[6] = consignmentItem;
    orderByCols[7] = depositRequired;

    orderByCols[8] = crossRefMMItem;

    //orderByCols[3] = "Enabled";

	orderByColVals[0] = "prosthesis_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "a.short_desc";
	orderByColVals[3] = "speciality_code";
    orderByColVals[4] = "prosthesis_cat_code";
	orderByColVals[5] = "prosthesis_type";
	orderByColVals[6] = "consignment_item_yn";
	orderByColVals[7] = "deposit_reqd_yn";
	orderByColVals[8] = "mm_item_code";
}else{
	orderByCols = new String[8];
	orderByColVals = new String[8];

	orderByCols[0] = prosthesisCode;
	orderByCols[1] = longDesc;
	orderByCols[2] = shortDesc;
    orderByCols[3] = speciality;
    orderByCols[4] = category1;
    orderByCols[5] = type;
    orderByCols[6] = consignmentItem;
    orderByCols[7] = depositRequired;
    //orderByCols[3] = "Enabled";

	orderByColVals[0] = "prosthesis_code";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "a.short_desc";
	orderByColVals[3] = "speciality_code";
    orderByColVals[4] = "prosthesis_cat_code";
	orderByColVals[5] = "prosthesis_type";
	orderByColVals[6] = "consignment_item_yn";
	orderByColVals[7] = "deposit_reqd_yn";
}

/*strbuff = qrypg.getQueryPage( con,finAr,"Implants ","../../eOT/jsp/ImplantsQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");*/

strbuff = qrypg.getQueryPage( con,finAr,implants,"../../eOT/jsp/ImplantsQueryResult.jsp?"+params,sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());


} catch (Exception e) {e.printStackTrace();}

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
