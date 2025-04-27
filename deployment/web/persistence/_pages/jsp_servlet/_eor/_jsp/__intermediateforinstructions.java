package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __intermediateforinstructions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/IntermediateForInstructions.jsp", 1722320040000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	String bean_id = "OR_OrderEntryQueryBean" ;
	String bean_name = "eOR.OrderEntryQueryBean";
	OrderEntryQueryBean bean = (OrderEntryQueryBean)getBeanObject( bean_id, bean_name , request ) ;
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.clear() ;
	bean.setMode( mode ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String action = (String)hash.get("action");
	if("VALIDATE_FOR_WINDOW_INVOKE".equalsIgnoreCase(action)){
		String order_catalog_nature =  (String)hash.get("order_catalog_nature");
		String contr_msr_panel_id =  (String)hash.get("contr_msr_panel_id"); 
		String measure_id =  (String)hash.get("measure_id");
		String category =  (String)hash.get("category");
		bean_id  = (String)hash.get("bean_id");
		bean_name   =  (String)hash.get("bean_name");
		String catalog_code  =  (String)hash.get("catalog_code"); 
		String catalog_desc  =  (String)hash.get("catalog_desc");
		String encounter_id   =  (String)hash.get("encounter_id");
		String patient_class   =  (String)hash.get("patient_class");
		String admission_date   =  (String)hash.get("admission_date");
		String discharge_date_time    =  (String)hash.get("discharge_date_time"); 
		String pract_type    = (String)hash.get("pract_type");
		if("P".equals(order_catalog_nature)){
			int PanelCount = bean.getCatalogCodeForPanelCount((String)hash.get("contr_msr_panel_id"));
			out.println("openInstructionModal('"+PanelCount+"','"+measure_id+"','"+contr_msr_panel_id+"','"+order_catalog_nature+"','"+category+"','"+bean_id+"','"+bean_name+"','"+catalog_desc+"','"+encounter_id+"','"+patient_class+"','"+admission_date+"','"+discharge_date_time+"','"+catalog_code+"','"+pract_type+"')");
		}else if("S".equals(order_catalog_nature)){
			int OrderSetCount = bean.getCatalogCodeForOrderSetCount((String)hash.get("measure_id"));
			out.println("openInstructionModal('"+OrderSetCount+"','"+measure_id+"','"+contr_msr_panel_id+"','"+order_catalog_nature+"','"+category+"','"+bean_id+"','"+bean_name+"','"+catalog_desc+"','"+encounter_id+"','"+patient_class+"','"+admission_date+"','"+discharge_date_time+"','"+catalog_code+"','"+pract_type+"')");
		}
	}else if("INVOKE_MULTIPLE_INSTRN".equalsIgnoreCase(action)){
		String strIndex =  (String)hash.get("index");
		int index = Integer.parseInt(strIndex);
		String catalogCode =  (String)hash.get("catalogCode");
		String key =  (String)hash.get("key");
		
			out.println("loadValueInIntermediate('"+index+"','"+key+"','"+catalogCode+"')");
		
	}else if("VALIDATE_ORDERSET_TAB".equals(action)){
		String care_sets =  (String)hash.get("care_sets");
		int OrderSetCount = bean.getCatalogCodeForOrderSetCount((String)hash.get("care_sets"));
		if(OrderSetCount>0)
			out.println("ENABLE");
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
