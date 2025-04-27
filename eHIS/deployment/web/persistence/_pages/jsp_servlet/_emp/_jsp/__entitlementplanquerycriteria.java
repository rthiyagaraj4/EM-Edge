package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __entitlementplanquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/EntitlementPlanQueryCriteria.jsp", 1709116995767L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n\tQuery Criteria for Entitlement Plan\n\tCreated\t\t: 2/10/2006 11:08 AM\n\tModified\t\t: 2/10/2006 11:08 AM\n\tCreated By\t: Vinod Babu MV\n-->\t\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	public static String checkForNull(String inputStr,String defaultVal)
	{
		 return ( ((inputStr==null) || (inputStr=="null") || (inputStr=="") ) ?  defaultVal : inputStr );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con=null ;

            _bw.write(_wl_block2Bytes, _wl_block2);

try
{
	    
	con = ConnectionManager.getConnection(request);
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	String ip_install_yn = "N";
	String op_install_yn = "N";
	String module_id = "";
	Statement stmt = null;
	ResultSet rs  = null;
	stmt = con.createStatement();
	rs = stmt.executeQuery("SELECT module_id, install_yn FROM sm_module WHERE module_id = 'IP' or module_id = 'OP'");
	if (rs != null)
	while(rs.next())
	{
		module_id = rs.getString("module_id");
		if (module_id.equals("IP"))
			ip_install_yn = rs.getString("install_yn");
		else
		if (module_id.equals("OP"))
			op_install_yn = rs.getString("install_yn");
	}
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


ecis.utils.CommonQueryPage  qryPage = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels"));	// label
firstItem.add("PAT_CAT_CODE");	//name of field
firstItem.add("15");			// SIZE
firstItem.add("15");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("List");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EntitlementBy.label","mp_labels"));	 // label
secondItem.add("ENTITLEMENT_CRITERIA");	 //name of field
secondItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+",1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+",");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));        // label
thirdItem.add("ENTITLEMENT_FACILITY_ID");   	 	 //name
thirdItem.add("48");			 // SIZE
thirdItem.add("35");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));  	 //label
fourthItem.add("ENTITLEMENT_CARE_LOCN_IND");  	 //name

if ( (ip_install_yn.equals("Y")) && (op_install_yn.equals("Y")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
else
if ( (ip_install_yn.equals("Y")) && (op_install_yn.equals("N")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"));
else
if ( (ip_install_yn.equals("N")) && (op_install_yn.equals("Y")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"));
else
if ( (ip_install_yn.equals("N")) && (op_install_yn.equals("N")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--");

finAr.add(fourthItem);			 //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));        // label
fifthItem.add("ENTITLEMENT_CRITERIA_CODE");   	 	 //name
fifthItem.add("30");			 // SIZE
fifthItem.add("30");			 //LENGTH
finAr.add(fifthItem); 			 //add to ArrayList obj finAr

String orderByCols[] 	= new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EntitlementBy.label","mp_labels");

orderByColVals[0] = "pat_cat_code";
orderByColVals[1] = "entitlement_criteria";


strbuff = qryPage.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EntitlementPlan.label","mp_labels"),"../jsp/EntitlementPlanQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

if ( firstItem != null ) firstItem.clear(); 
if ( secondItem != null ) secondItem.clear(); 
if ( thirdItem != null ) thirdItem.clear(); 
if ( fourthItem != null ) fourthItem.clear(); 
if ( fifthItem != null ) fifthItem.clear(); 
if ( finAr != null ) finAr.clear(); 

}catch(Exception e)
{
	e.printStackTrace();
}
finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
