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

public final class __reprintformsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ReprintFormsValidate.jsp", 1732515404000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	//String flag		= request.getParameter("flag");

	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id");

	//out.println("alert('in')");
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ReprintFormsBean beanObj = (ReprintFormsBean)getBeanObject( bean_id,"eOR.ReprintFormsBean" , request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
//System.out.println("validate"+validate);
    	if ( validate.equals( "location" ) ) {

			String location	 = request.getParameter("location");
			if (location.equalsIgnoreCase("source")) {
				String locn_type = (String)hash.get("source_type") ;
				out.println( "clearList1('document') ; " ) ;
				out.println("clearList2('document');");
				//out.println( "alert(\"" + locn_type + "\") ; " ) ;
				ArrayList LocationData = beanObj.getLocation(locn_type,location) ;
				//out.println( "alert(\"" + beanObj.chk+ "\") ; " ) ;
				for( int i=0 ; i< LocationData.size() ; i++ ) {
					String[] record = (String[])LocationData.get(i);
					out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
					out.println( "addLocationList2(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			} else if (location.equalsIgnoreCase("print")) {
				String locn_type = (String)hash.get("print_at") ;
				out.println("clearList3('document');");
				ArrayList LocationData = beanObj.getLocation(locn_type,location) ;
				for( int i=0 ; i< LocationData.size() ; i++ ) {
					String[] record = (String[])LocationData.get(i);
					out.println( "addLocationList3(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			}

		}
		else if ( validate.equals( "ord_cat" ) ) {
			String report_type = (String)hash.get("report") ;
			out.println( "clearCategoryList('document') ; " ) ;
            ArrayList OrderCategoryData = new ArrayList();
			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			OrderCategoryData = beanObj.getSearchOrderCategory();
            //String isLBInstalled = beanObj.isModuleInstalled(facility_id,"RL");changed on 7/19/2007 for lab_install check change by uma 
            String isRDInstalled = beanObj.isModuleInstalled(facility_id,"RD");
			//out.println("alert('"+report_type+","+isLBInstalled+","+isRDInstalled+"')");
			for( int i=0 ; i< OrderCategoryData.size() ; i++ ) {
				String selected = "false";
				String[] record = (String[])OrderCategoryData.get(i);
				//out.println("alert('"+(((record[1].equalsIgnoreCase("LB")) && (!isLBInstalled.equalsIgnoreCase("Y"))) || ((record[1].equalsIgnoreCase("RD")) && (!isRDInstalled.equalsIgnoreCase("Y"))))+"')");
				//System.out.println("report_type"+report_type);
				if (report_type.equalsIgnoreCase("R")) {
					//if (((record[1].equalsIgnoreCase("LB")) && (!isLBInstalled.equalsIgnoreCase("Y"))))changed on 7/19/2007 for lab_install check change by uma 
					if (((record[1].equalsIgnoreCase("LB"))))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
					else if ((record[1].equalsIgnoreCase("RD")) && (!isRDInstalled.equalsIgnoreCase("Y")))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
					else if ((!record[1].equalsIgnoreCase("RD")) && (!record[1].equalsIgnoreCase("LB")))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
				} else if (report_type.equalsIgnoreCase("L")) {
					if (record[1].equalsIgnoreCase("LB"))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
				}else {
					out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
				}
			}
		} else if ( validate.equals( "ord_type" ) ) {
			String orderCategory = (String)hash.get("ord_cat") ;
			out.println( "clearTypeList('document') ; " ) ;
            ArrayList OrderTypeData = new ArrayList();
            OrderTypeData = beanObj.getSearchOrderType(orderCategory);

   for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
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
