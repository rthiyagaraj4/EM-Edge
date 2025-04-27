package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __existingorderprintvalidatelab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingOrderPrintValidateLab.jsp", 1732512858000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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



String checkForNull( String inputString, String defaultValue ) {
	return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
}
String checkForNull( String inputString ) {
        return ( inputString == null )  ?   ""  :   inputString;
}


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
 /*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
03/07/2013    IN039857		 Chowminya G    	Print Button from result view page for LB order-Added the file
25/02/2015	  IN053439		 Vijayakumar K		MMS-QF-SCF-0486 [IN:053439] - Not able to print the 
												result � showing status partial resulted and colour status Expired	
26/05/2015	  IN054720		 Vijayakumar K		ML-BRU-SCF-1580 [IN:054720]
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
24/02/2022	 	25671			Ramesh G											NMC-JD-CRF-0091.2 
-------------------------------------------------------------------------------------------------------------------------------------
*/
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
try{
	 con=ConnectionManager.getConnection(request);
	Hashtable allValues = (Hashtable)XMLobj.parseXMLString( request ) ;
    allValues = (Hashtable)allValues.get( "SEARCH" ) ;
    String order_catalog_code = (String)allValues.get("order_catalog_code");//IN061961
    String view_by = (String)allValues.get("view_by");//IN061961
	String bean_id = (String)allValues.get("bean_id");
	request.setCharacterEncoding("UTF-8");
	String localeName=request.getParameter("localeName");
	String bean_name = "eOR.ViewOrder";
 	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request   ) ;

	bean.setLanguageId(localeName);
	OnLinePrinting online_print = new OnLinePrinting();

	//Hashtable resultHash	= new Hashtable();//commented for IN061961 checkstyle
	Hashtable orderHash		= new Hashtable();
	//boolean isviewLineDtls= bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961	
	boolean isviewLineDtls = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
	int order_count			= 0;
	orderHash.put("ord_typ_code"+order_count,((String)allValues.get("ord_typ_code")));
	orderHash.put("ord_typ_desc"+order_count,((String)allValues.get("ord_typ_desc")));
	orderHash.put("patient_class"+order_count,((String)allValues.get("patient_class")));
	orderHash.put("priority"+order_count,((String)allValues.get("priority")));
	orderHash.put("ord_id"+order_count,((String)allValues.get("ord_id")));
	orderHash.put("source_type"+order_count,((String)allValues.get("source_type")));
	orderHash.put("location_code"+order_count,((String)allValues.get("location_code")));
	orderHash.put("order_category"+order_count,((String)allValues.get("order_category")));
	orderHash.put("cont_order_ind"+order_count,((String)allValues.get("cont_order_ind"))); //IN053439
	orderHash.put("performing_facility_id"+order_count,((String)allValues.get("performing_facility_id"))); //IN054720
	orderHash.put("order_catalog_code"+order_count,((String)allValues.get("order_catalog_code")));//IN061961
	orderHash.put("view_by"+order_count,((String)allValues.get("view_by")));//IN061961
			
 	order_count++;

	orderHash.put("order_entry","ViewOrder");
 	orderHash.put("facility_id",checkForNull((String)allValues.get("facility_id")));
	orderHash.put("mode",checkForNull((String)allValues.get("mode")));
	orderHash.put("total_recs",""+order_count);
	orderHash.put("isviewLineDtls",isviewLineDtls);//IN061961
	orderHash.put("includeESignature",((String)allValues.get("includeESignature"))); //25671

	online_print.callOnlinePrint(orderHash, request, response);
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
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
