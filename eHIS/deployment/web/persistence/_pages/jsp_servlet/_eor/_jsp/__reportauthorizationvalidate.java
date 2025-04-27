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

public final class __reportauthorizationvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ReportAuthorizationValidate.jsp", 1743590447250L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String flag		= request.getParameter("flag");

	String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ReportAuthorizationBean beanObj = (ReportAuthorizationBean)getBeanObject( bean_id, "eOR.ReportAuthorizationBean" , request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	//System.out.println("====hash==="+hash);
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    if (flag == null || flag.equals("")) {
		if ( validate.equals( "location" ) ) {
			String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;
			//System.out.println("facility_id"+facility_id+"practitioner_id"+practitioner_id+"locn_type"+locn_type);
			ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				//out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				String selected = "false";
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
			}
		}
	} else if (flag.equalsIgnoreCase("true")) {
		if ( validate.equals( "location" ) ) {
			//String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;
			out.println( "clearActivityTypeList('document'); " ) ;

			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			//System.out.println("practitioner_id"+practitioner_id+"resp_id"+resp_id);
			ArrayList OrderTypeData = beanObj.getOrderCategory(practitioner_id, resp_id);
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				String selected = "false";
				//out.println("alert('in:"+OrderTypeData.size()+"')");
				if (OrderTypeData.size() == 1 && i == 0) {
					//out.println("alert('in')");
					selected = "true";
				}
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
				if (OrderTypeData.size() == 1) {
					out.println("populateLocnOrdType('locn');");
				} else {
					out.println("formObj.locn.value='';");
				}
			}
			
		} else if ( validate.equals( "ord_type" ) ) {
			String orderCategory = (String)hash.get("locn") ;
			out.println( "clearTypeList('document') ; " ) ;
			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			//System.out.println("orderCategory"+orderCategory+"practitioner_id"+practitioner_id+"resp_id"+resp_id);
			ArrayList OrderTypeData = beanObj.getOrderType(orderCategory, practitioner_id, resp_id);
			
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
			String order_type = "" ;
			out.println( "clearActivityTypeList('document'); " ) ;
			//System.out.println("orderCategory"+orderCategory+"order_type"+order_type);
			ArrayList ActivityType = beanObj.getActivityType(orderCategory, order_type);
			for( int i=0 ; i< ActivityType.size() ; i++ ) {
				String[] record = (String[])ActivityType.get(i);
							
				out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				
			}
			String isPerformingLocnYN = "N";

           /* if (!(practitioner_id == null || practitioner_id.equals("")))
				isPerformingLocnYN = beanObj.isPerformingLocnYN("",practitioner_id,orderCategory);
			if ((isPerformingLocnYN == null || isPerformingLocnYN.equals("N")) && !(resp_id == null || resp_id.equals("")))
                isPerformingLocnYN = beanObj.isPerformingLocnYN(resp_id,"",orderCategory);*/
				isPerformingLocnYN = beanObj.isPerformingLocnYN(resp_id,practitioner_id,orderCategory);

            if (isPerformingLocnYN.equalsIgnoreCase("Y")) {
            	out.println("formObj.performing_locn_lbl_show.innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingLocation.label","common_labels")+"'");
            	out.println("formObj.performing_locn_show.innerHTML=\"<select name='performing_location_code' id='performing_location_code'><option value=''>   ---Select---   </option></select>\"");
            	out.println( "clearPerformingLocnList('document') ; " ) ;
	            ArrayList PerformingLocn = new ArrayList();

				if (!(practitioner_id == null || practitioner_id.equals("")))
	            	PerformingLocn = beanObj.getPerformingLocn("", practitioner_id, orderCategory);

	            if ((PerformingLocn.size() == 0) && !(resp_id == null || resp_id.equals("")))
	            	PerformingLocn = beanObj.getPerformingLocn(resp_id,"",orderCategory);

				for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					String[] record = (String[])PerformingLocn.get(i);
					out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			} else {
				//out.println("formObj.all.performing_locn_lbl_show.innerHTML = \"&nbsp;\"");
				//out.println("formObj.all.performing_locn_show.innerHTML = \"&nbsp;\"");
				//out.println("alert('resp_id="+resp_id+",practitioner_id="+practitioner_id+",orderCategory="+orderCategory+"')");
			}
		} else if( validate.equals( "fing_values" ) ) {
    	  // String fingurePrnYN	= "N";
		   String fingurePrnYN = beanObj.fingurePrintYN();
    	   out.println("fingurePrnYN='"+fingurePrnYN+"'");
		   //System.out.println("fingurePrnYN======report======================="+fingurePrnYN+"----");
    	   //out.println("alert('Incorporate The Fingure Signature Function. Please Contact Srikanta');");
    	}else if ( validate.equals( "activity_type" ) ) {
			String order_category = request.getParameter("order_category");
			String order_type = request.getParameter("order_type") ;
			out.println( "clearActivityTypeList('document'); " ) ;

			ArrayList ActivityType = beanObj.getActivityType(order_category, order_type);
			for( int i=0 ; i< ActivityType.size() ; i++ ) {
				String[] record = (String[])ActivityType.get(i);
							
				out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				
			}
			
		}else if(validate.equals( "ResultEntryReport" ) ) {
			 Hashtable allValues  =  beanObj.getPrintValues();
		     if ((allValues != null) && (allValues.size() > 0)) {
				//out.println("alert('APP-OR0148 Report has been Submitted to thePrinter')");
				OnLinePrinting online_print = new OnLinePrinting();
				online_print.printResultEntryReport(allValues,request,response);
				
			}

		}
	}
	
	putObjectInBean(bean_id,beanObj,request);

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
