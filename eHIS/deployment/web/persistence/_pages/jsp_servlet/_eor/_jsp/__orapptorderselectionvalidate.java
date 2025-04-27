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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orapptorderselectionvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORApptOrderSelectionValidate.jsp", 1732513038000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		Chowminya G 	Created:To capture Pre-consultation orders in Appointment Scheduling
13/09/2013    IN030284.1 	Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)	
---------------------------------------------------------------------------------------------------------------
*/
	request.setCharacterEncoding("UTF-8");
	String bean_id ="refusalOrdersBean";
	String validate = request.getParameter( "validate" ) ;
    String localeName=(String)session.getAttribute("LOCALE");
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,"eOR.RefusalOrdersBean",request) ;
	beanObj.setLanguageId(localeName);
	try
	{
	if ( validate.equals( "ref_ord" ) ) 
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String ordercat = (String)hash.get("ordercategory") ;
		String order_type = (String)hash.get("order_type") ;		
		out.println( "clearList(\"document\") ; " ) ;
		ArrayList OrderTypeData = beanObj.getLocation(ordercat) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
		{
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		out.println( "clearActivityList(\"document\") ; " ) ;
		ArrayList ActivityTypeData = beanObj.getActivityType(ordercat, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) 
		{
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if ( validate.equals( "ref_order_type" ) ) 
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
	    String ordercat = (String)hash.get("ordercategory") ;
		String order_type = (String)hash.get("order_type") ;	
 		out.println( "clearActivityList(\"document\") ; " ) ;
		ArrayList ActivityTypeData = beanObj.getActivityType(ordercat, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) 
		{
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;		
		}
	}//end of else loop
	else if(validate.equals("Remove_Temp_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		String from = beanObj.checkForNull(request.getParameter("from")) ;
		String to = beanObj.checkForNull(request.getParameter("to")) ;
		String flag = "box_unchecked";
		beanObj.setfrom(from);
		beanObj.setto(to);
		beanObj.setflag(flag);
		beanObj.removeTempOrderCatalogs(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
	}
	else if(validate.equals("Add_Temp_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		String nature = beanObj.getCatalogNature(key);
		int orderSetCount = beanObj.getorderSetCount();
		
		if(!beanObj.containsObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no))
		{
			if(nature.equals("S"))
			{
				if(orderSetCount>=1)
				{
					out.println("addCatalog(\"ORDER_SET_SELECTED\");");
				}
				else
				{
					beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
					out.println("addCatalog(\"SAVE\");");
				}
			}
			else
			{
				beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
				out.println("addCatalog(\"SAVE\");");
			}
		}
	}
	else if(validate.equals("Remove_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;	
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		String from = beanObj.checkForNull(request.getParameter("from")) ;
		String to = beanObj.checkForNull(request.getParameter("to")) ;
		String flag = "box_unchecked";
		beanObj.setfrom(from);
		beanObj.setto(to);
		beanObj.setflag(flag);
		beanObj.removeOrderCatalogs(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
	}
	else if(validate.equals("Add_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;	
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String appt_ref_no = beanObj.checkForNull(request.getParameter("appt_ref_no")) ;
		if(!beanObj.containsObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no))
		{
			beanObj.putObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category+"~~"+appt_ref_no);
		}
	}
	else if(validate.equals("Reset_Order_Catalog"))
	{
		beanObj.clearObject();
	}
	else if(validate.equals("Submit_Order_Catalog"))
	{
		beanObj.finalOrderable();
	}
	else if(validate.equals("Clear_Order_Catalogs"))
	{
		beanObj.clearObject(); 
		beanObj.clearTempObject();
	}	
	else if(validate.equals("Record_order_catalog"))
	{
		
	}
	}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	putObjectInBean(bean_id,beanObj,session);	

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
