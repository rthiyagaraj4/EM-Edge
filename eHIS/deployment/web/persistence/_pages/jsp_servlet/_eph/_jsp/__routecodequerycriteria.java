package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __routecodequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/RouteCodeQueryCriteria.jsp", 1742385684391L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block6Bytes, _wl_block6);
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

request.setCharacterEncoding("UTF-8");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block0Bytes, _wl_block0);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String exProductLink="N";
	
	try {
		ArrayList finAr = new ArrayList();
      String RouteCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteCode.label","ph_labels");

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(RouteCode);	  // label
		firstItem.add("route_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		 String RouteDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteDescription.label","ph_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(RouteDesc);  // label
		secondItem.add("route_desc");   //name of field
		secondItem.add("22");	// SIZE
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

	/*	ArrayList localItem=new ArrayList();
 String LocalLanguage
	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LocalLanguage.label","ph_labels");
		localItem.add("Text");  //Type of item
		localItem.add(LocalLanguage);  // label
		localItem.add("route_local");   //name of field
		localItem.add("22");	// SIZE
		localItem.add("20");	//LENGTH
		finAr.add(localItem); //add to ArrayList obj finAr*/


String ExternalProductRoute
	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalProductRoute.label","ph_labels");

		if (exProductLink.equals("Y"))
		{
		ArrayList thirdItem=new ArrayList();
	
		
		thirdItem.add("Text");  //Type of item
		thirdItem.add(ExternalProductRoute);  // label
		thirdItem.add("ext_route_code");   //name of field
		thirdItem.add("22");	// SIZE
		thirdItem.add("20");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();
        
		String ExternalRouteDesc
	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalRouteDesc.label","ph_labels");
		fourthItem.add("Text");  //Type of item
		fourthItem.add(ExternalRouteDesc);  // label
		fourthItem.add("ext_route_desc");   //name of field
		fourthItem.add("22");	// SIZE
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		}

		ArrayList fifthItem=new ArrayList();
       String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;
 
  String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		fifthItem.add("List");  //Type of item
		fifthItem.add(Nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
		//=====================================================================
		

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String DrugCategory=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");

		if (exProductLink.equals("Y"))
		{
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];
		orderByCols[0] = RouteCode;
		orderByCols[1] = RouteDesc;
		//orderByCols[2] = LocalLanguage;

		orderByColVals[0] = "ROUTE_CODE";
		orderByColVals[1] = "ROUTE_DESC";
		//orderByColVals[2] = "ROUTE_DESC_LOCAL_LANG";

		orderByCols[2] = "External Route Code";
		orderByCols[3] = "External Route Desc";
		
		
		
		orderByColVals[2] = "EXT_ROUTE_CODE";
		orderByColVals[3] = "EXT_ROUTE_DESC";

		strbuff = qrypg.getQueryPage(null, finAr, DrugCategory , "RouteCodeQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());

		}
		else
		{
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];
		orderByCols[0] = RouteCode;
		orderByCols[1] = RouteDesc;
		//orderByCols[2] = LocalLanguage;

		orderByColVals[0] = "ROUTE_CODE";
		orderByColVals[1] = "ROUTE_DESC";
		//orderByColVals[2] = "ROUTE_DESC_LOCAL_LANG";
        
		


		strbuff = qrypg.getQueryPage(null, finAr, DrugCategory , "RouteCodeQueryResult.jsp", Sort_order,QueryCriteria, defaultSelect,orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());

		}
	}
	catch (Exception e) {
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
