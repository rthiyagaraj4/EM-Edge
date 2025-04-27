package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;

public final class __pendingordersschedulevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PendingOrdersScheduleValidate.jsp", 1713262298000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eOR.QueryBean beanQuery= null;{
                beanQuery=(eOR.QueryBean)pageContext.getAttribute("beanQuery");
                if(beanQuery==null){
                    beanQuery=new eOR.QueryBean();
                    pageContext.setAttribute("beanQuery",beanQuery);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
				request.setCharacterEncoding("UTF-8");

	String bean_id 			= request.getParameter( "bean_id" ) ;
	String validate 		= request.getParameter( "validate" ) ;
	//String flag				= request.getParameter("flag");
	String default_val		= request.getParameter("default_val");
	String default_val1		= request.getParameter("default_val1");
	String default_val2		= request.getParameter("default_val2");
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String localeName       = request.getParameter("localeName");

    beanQuery.setLanguageId(localeName);
	//String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	//String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	default_val				= (default_val == null) ? "" : default_val;
	default_val1			= (default_val1 == null) ? "" : default_val1;
	default_val2			= (default_val2 == null) ? "" : default_val2;

//	PatOrderByPrivRelnBean  beanObj = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request , "eOR.PatOrderByPrivRelnBean") ;
//	 PatOrderByPrivRelnBean beanObj = (PatOrderByPrivRelnBean)getBeanObject( bean_id, "eOR.PatOrderByPrivRelnBean", request ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		//String orderCategory = (String)hash.get("order_category") ;
		//ArrayList order_category = beanObj.getOrderCategory();
		ArrayList order_category = beanQuery.getOrderCat(facility_id, properties);
		for( int i=0 ; i< order_category.size() ; i++ ) {
			String[] record = (String[])order_category.get(i);
			out.println( "addCategoryList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		
	}else if ( validate.equals( "order_type" ) ) {
		String order_category = (String)hash.get("order_category") ;
		if ( order_category == null || order_category.equals( "" ) )
			order_category="";

		out.println( "clearOrderTypeList('document') ; " ) ;
		
		ArrayList OrderTypeData = beanQuery.getOrderTypeSpecimen(order_category, properties) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		
		}
		String order_type = "" ;
		out.println( "clearActivityTypeList('document'); " ) ;

		ArrayList ActivityType = beanQuery.getActivityType(order_category, order_type, properties);
		for( int i=0 ; i< ActivityType.size() ; i++ ) {
			String[] record = (String[])ActivityType.get(i);
						
			out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			
		}

	} else if ( validate.equals( "activity_type" ) ) {
		//String order_category = request.getParameter("order_category");
		//String order_type = request.getParameter("order_type") ;
		String order_category= (String)hash.get("order_category") ;
		String order_type =  (String)hash.get("order_type") ;

		out.println( "clearActivityTypeList('document'); " ) ;

		ArrayList ActivityType = beanQuery.getActivityType(order_category, order_type, properties);
		for( int i=0 ; i< ActivityType.size() ; i++ ) {
			String[] record = (String[])ActivityType.get(i);
			out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}else if(validate.equals("patient_class")){

		ArrayList patientClass = beanQuery.getPatientClass(properties);
		for( int i=0 ; i< patientClass.size() ; i++ ) {
			String[] record = (String[])patientClass.get(i);
			out.println( "addPatClass(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}else if ( validate.equals( "perform_locn" ) ) {
		
		ArrayList performing_location = beanQuery.getPerformingLocation(facility_id, properties);
		for( int i=0 ; i< performing_location.size() ; i++ ) {
			String[] record = (String[])performing_location.get(i);
			out.println( "addPerfLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		
	}
	
//	putObjectInBean(bean_id,beanObj,request);

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
