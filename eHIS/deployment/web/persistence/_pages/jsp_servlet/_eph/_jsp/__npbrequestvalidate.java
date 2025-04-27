package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __npbrequestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/NPBRequestValidate.jsp", 1732509570728L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
		
	String func_mode			= request.getParameter("func_mode");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;

	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String facility_id   = (String)session.getValue( "facility_id" );
	String login_user	= (String)session.getValue("login_user");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	NPBRequestBean bean = (NPBRequestBean)getBeanObject(bean_id,bean_name ,request) ;
	try{
		bean.setLanguageId(locale);
		if(func_mode!= null && func_mode.equals("loadQuantityUOM")){
			String drugCode			= (String) hash.get("drugCode");
			ArrayList QtyDescDetails = null;
			if(drugCode==null || (drugCode.trim()).equals(""))
				QtyDescDetails	= (ArrayList)bean.loadQuantityUOM();
			else
				QtyDescDetails	= (ArrayList)bean.loadQuantityUOM(drugCode);
			String	uom_code	= "";
			String	uom_desc	= "";
			String  dflt_yn		= "";
			String  dflt_uomCode		= "";
			boolean deft_set = false;

			out.println("clearQtyDescList();");
			for(int i=0; i<QtyDescDetails.size(); i+=3)	{
				uom_code	= (String)QtyDescDetails.get(i);
				uom_desc	= (String)QtyDescDetails.get(i+1);
				if(uom_desc!=null && !uom_desc.equals("")){
					uom_desc=uom_desc.replaceAll(" ","%20");
					uom_desc= java.net.URLEncoder.encode(uom_desc,"UTF-8");
					uom_desc=uom_desc.replaceAll("%2520","%20");
				}
			//	if(((String)QtyDescDetails.get(i+2)).equals("Y"))
				dflt_yn		= ((String)QtyDescDetails.get(i+2))==null?"":(String)QtyDescDetails.get(i+2);
				if(dflt_yn.equals("Y"))
					dflt_uomCode= uom_code;
				out.println("addQtyDescList('"+uom_code+"','"+uom_desc+"');");
			}
			if(!dflt_uomCode.equals(""))
				out.println("setDefaultUOM('"+dflt_uomCode+"');");
			
			if(QtyDescDetails == null || QtyDescDetails.size()==0){
				out.println("addQtyDescList('','  ----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label", "common_labels")+"---   ');");
			}
		}		
		else if(func_mode.equals("StoreEditorText")){
			String NPBReqFormText			= java.net.URLDecoder.decode((String) hash.get("NPBReqFormText"),"UTF-8");
			String NPBReqFormId			= (String) hash.get("NPBReqFormId");
			if(!NPBReqFormId.equals(bean.getNPBReqFormId()))
				bean.setNPBReqFormId(NPBReqFormId);
			bean.setNPBReqFormText(NPBReqFormText);
		}
		else if(func_mode.equals("StoreEditorTextAmend")){
			String NPBReqFormText			= java.net.URLDecoder.decode((String) hash.get("NPBReqFormText"),"UTF-8");
			String request_no			= (String) hash.get("request_no");
			bean.setNPBRequestFormText(request_no, NPBReqFormText);
		}
		else if(func_mode.equals("searchNPBRequests")){
		}		 
	}
	catch(Exception e){
		e.printStackTrace();
	}

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
