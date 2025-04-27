package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __phtpnconslimitsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PHTPNConsLimitsQueryCriteria.jsp", 1742454628255L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);


request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block0Bytes, _wl_block0);

	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//String qry=PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_SELECT1" );
	 String qry = "SELECT AGE_GROUP_CODE,SHORT_DESC, DECODE(GENDER,'M','male','F','female','Both') GENDER,MIN_AGE, MAX_AGE, AGE_UNIT FROM AM_AGE_GROUP_LANG_VW AM_AGE_GROUP WHERE EFF_STATUS='E' AND LANGUAGE_ID =";
     String s1 = qry+"'"+locale+"'"; 

	
	
	//String qry2=PhRepository.getPhKeyValue( "SQL_PH_TPN_REGIMEN_MAST_SELECT13" );
	String qry2="SELECT TPN_REGIMEN_CODE,LONG_NAME FROM PH_TPN_REGIMEN WHERE STANDARD_REGIMEN_YN = 'N' ORDER BY 1 ";
	

	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
String non_standard_regimen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Non-StandardRegimen.label","ph_labels");

		firstItem.add("List");  //Type of item
		firstItem.add(non_standard_regimen);  // label
		firstItem.add("TPN_REGIMEN_CODE");   //name of field
		firstItem.add(qry2);
		finAr.add(firstItem); //add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

String age_group=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels");

		secondItem.add("List");  //Type of item
		secondItem.add(age_group);  // label
		secondItem.add("AGE_GROUP_CODE");   //name of field
		secondItem.add(s1);
		finAr.add(secondItem); //add to ArrayList obj finAr
	
		ArrayList thirdItem = new ArrayList();
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String constituent_group=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ConstituentGroup.label","ph_labels");
String fluid=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Fluid.label","ph_labels");
String electrolytes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Electrolytes.label","ph_labels");
String trace_elements=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TraceElements.label","ph_labels");
String vitamins=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Vitamins.label","ph_labels");
String other_components=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OtherComponents.label","ph_labels");
String macro_nutrient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MacroNutrient.label","ph_labels");


		thirdItem.add("List");  //Type of item
		thirdItem.add(constituent_group);  // label
		thirdItem.add("B.CONST_GROUP_CODE");   //name of field
		thirdItem.add("  ,"+defaultSelect+",FL,"+fluid+",MN,"+macro_nutrient+",EL,"+electrolytes+",TR,"+trace_elements+",VT,"+vitamins+",OT,"+other_components);
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		//=====================================================================
		
		//ArrayList thirdItem = new ArrayList();

		//thirdItem.add("List");  //Type of item
		//thirdItem.add("Infusion Line");  // label
		//thirdItem.add("INFUSION_LINE");   //name of field
		//thirdItem.add("  ,----Select----,C,Central,P,Peripheral");
		//thirdItem.add("30");	//LENGTH
		//finAr.add(thirdItem); //add to ArrayList obj finAr
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");		
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String TPN_constituent_limits=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNConstituentLimits.label","ph_labels");
String _sjsp="PHTPNConsLimitsQueryResult.jsp" ;

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];
		orderByCols[0] = non_standard_regimen;
		orderByCols[1] = age_group;
		orderByCols[2] = constituent_group;
		orderByColVals[0] = "TPN_REGIMEN_CODE";
		orderByColVals[1] = "AGE_GROUP_CODE";
		orderByColVals[2] = "B.CONST_GROUP_CODE";
		strbuff = qrypg.getQueryPage( null , finAr, TPN_constituent_limits ,_sjsp,Sort_order,QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals,ExecuteQuery,true);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		e.printStackTrace();
		out.println( "main " + e );
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
