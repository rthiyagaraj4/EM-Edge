package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __ordercatalogaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderCatalogAddModify.jsp", 1732189766000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n<!-- OrderItem.jsp -->\n<!--\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       \tEdit History     Name        \tRev.Date\t\tRev.Name\t\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n01/08/2018\tIN64543\t\t\tDinesh T\t\t01/08/2018\tRamesh G\t\tML-MMOH-CRF-0776\t\n28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014\n28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" <!--IN068370,IN068373-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="<!--IN068370,IN068373-->\n<html>\n<head>\n</head>\n<script>function_id =\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";</script>\n<!--<script language=\"javascript\" src=\"../js/OrMessages.js\"></script>-->\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script language=\"javascript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script language=\"javascript\" src=\"../../eOR/js/OrderCatalog.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<table align=\'center\' cellpadding=3 cellspacing=0 border=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t<td  class=\"label\" width=\"100%\">This function is not applicable to this facility</td>\n\t\t</tr>\n\t\t</table>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<iframe name=\'header\' id=\'header\' src=\'../../eOR/jsp/OrderCatalogAddModifyHeader.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0 scrolling=\'no\' style=\"height:25vh;width:99vw\"></iframe>\n\t<iframe name=\'tab\' id=\'tab\' src=\'../../eOR/jsp/OrderCatalogTab.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 scrolling=\'no\' style=\"height:6vh;width:99vw\"></iframe>\n\t<!--<frame name=\'detail\' id=\'detail\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' >--><!--IN64543-->\n\t<iframe name=\'detail\' id=\'detail\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' style=\"height:63vh;width:99vw\"></iframe>\n\t<!--IN64543-->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\'hidden\' name=\'isCatalogApplyAppl\' id=\'isCatalogApplyAppl\'  id=\'isCatalogApplyAppl\' value =\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'/><!--IN068370,IN068373-->\n</html> \n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<!--------\nParamtere to be passed by the Other Modules\n--------------------------------------------\n1) order_catalog_code\n2) long_desc\t\t\n3) short_desc\t\t\n4) module_id\n5) order_category \nH) sql_order_type\n7) sql_setting\n8) sql_auth_level\n9) uom_code\n9) uom_desc\n10)mode\n11)\n--------->\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block4Bytes, _wl_block4);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mod_qry_str   = request.getQueryString();
System.out.println("##### in OrderCatalogAddModify.jsp, mod_qry_str="+mod_qry_str);//added for SKR-SCF-1312

	//IN068370,IN068373, starts
	String bean_id = "Or_OrderCatalog";
	String bean_name = "eOR.OrderCatalogBean";
	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name ,request) ;
	String l_mode = bean.checkForNull(request.getParameter("mode"));
	bean.setGlobalFacilityYn(bean.getSiteSpecificParams("ORDER_CATALOG_FAC_WISE",bean.getLoginFacilityId()));
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");
	String tpn_item_yn=bean.checkForNull(request.getParameter("tpn_item_yn"));//IN068926

	String isCatalogApplyAppl = "Y";
	if(!"Y".equals(bean.getGlobalFacilityYn()) && bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE") &&  "1".equals(l_mode))
	{
		isCatalogApplyAppl = "N";

            _bw.write(_wl_block5Bytes, _wl_block5);

	}
	else
	{
		if("Y".equals(bean.getGlobalFacilityYn()) && bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
			isCatalogApplyAppl = "Y";
		else if(bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
			isCatalogApplyAppl = "N";
		//IN068370,IN068373, ends

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(mod_qry_str));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(mod_qry_str));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}//IN068370,IN068373

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isCatalogApplyAppl));
            _bw.write(_wl_block10Bytes, _wl_block10);

putObjectInBean(bean_id,bean,request);//IN068370,IN068373

            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
