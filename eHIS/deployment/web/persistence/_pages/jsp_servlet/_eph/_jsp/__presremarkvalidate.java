package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __presremarkvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PresRemarkValidate.jsp", 1721363269546L ,"10.3.6.0","Asia/Calcutta")) return true;
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	try{
		String bean_id = request.getParameter( "bean_id" ) ;
		String bean_name = request.getParameter( "bean_name" ) ;
		String validate = request.getParameter( "validate" ) ;
		String objname = request.getParameter( "object" ) ;
		String calledFrom = request.getParameter( "calledFrom" ) ;
		if ( bean_id == null || bean_id.equals( "" ) )
			return ;
		if ( validate == null || validate.equals( "" ) )
			return ;
		PresRemarkBean beanObj = ( PresRemarkBean )getBeanObject(bean_id,bean_name,request ) ;
		Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
		hash = ( Hashtable )hash.get( "SEARCH" ) ;

		if ( validate.equals( "Formcode" ) ) {
			String suffix = objname.substring( objname.lastIndexOf( "_" ) + 1 ) ;
			out.println( "clearList( 'document.formPresRemark.ROUTE_CODE_', " + suffix + " ) ; " ) ;
			String form_code = ( String )hash.get( objname ) ;
			ArrayList routeOfDrug = new ArrayList();
			routeOfDrug = beanObj.getRouteOfDrug( form_code );
			String route_color="", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
			if (routeOfDrug.size() != 0) {
				for (int i = 0; i < routeOfDrug.size(); i+=3) {
					route_color=(String)routeOfDrug.get(i+2) ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
					if(route_color!= null && !route_color.equals("")){
						if(route_color.length()==12){
							fntColor= route_color.substring(0, 6);
							backgrndColor= route_color.substring(6, 12);
						}
					}
					else{
						fntColor= "";
						backgrndColor= "";
					}// added for CRF RUT-CRF-0034.1[IN:037389]-end
					out.println( "addList( '" + routeOfDrug.get(i) + "','" + routeOfDrug.get(i+1) + "','document.formPresRemark.ROUTE_CODE_','" + suffix +"','" + fntColor +"','" + backgrndColor +"') ; " ) ;
				}
			}
		}
		else if ( validate.equals( "FormCodeforMod" ) ) {
			String form_code = ( String )hash.get( objname ) ;
			ArrayList routeOfDrug = new ArrayList();
			routeOfDrug = beanObj.getRouteOfDrug( form_code );
			String route_color="", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]
			if (routeOfDrug.size() != 0) {
				if (calledFrom.equals("1")) {
					out.println( "clearList( 'f_query_add_mod.document.formPresRemark.ROUTE_CODEANDDESC', '' ) ; " ) ;
					for (int i = 0; i < routeOfDrug.size(); i+=3) {
						route_color=(String)routeOfDrug.get(i+2) ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}
						else{
							fntColor= "";
							backgrndColor= "";
						}// added for CRF RUT-CRF-0034.1[IN:037389]-end
						out.println( "addList( '" + routeOfDrug.get(i) + "','" + routeOfDrug.get(i+1) + "','f_query_add_mod.document.formPresRemark.ROUTE_CODEANDDESC', '','" + fntColor +"','" + backgrndColor +"') ; " ) ;
					}
				}
				else if (calledFrom.equals("2")) {
					out.println( "clearList( 'document.formPresRemark.ROUTE_CODEANDDESC', '' ) ; " ) ;
					for (int i = 0; i < routeOfDrug.size(); i+=3) {
						route_color=(String)routeOfDrug.get(i+2) ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}
						else{
							fntColor= "";
							backgrndColor= "";
						}// added for CRF RUT-CRF-0034.1[IN:037389]-end
						out.println( "addList( '" + routeOfDrug.get(i) + "','" + routeOfDrug.get(i+1) + "','document.formPresRemark.ROUTE_CODEANDDESC', '','" + fntColor +"','" + backgrndColor +"') ; " ) ;
					}
				}
			}
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) {
		e.printStackTrace();
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
