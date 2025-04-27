package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import eST.*;
import eST.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __releasebatchesvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReleaseBatchesValidate.jsp", 1721041347980L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	try {
		String called_from			= request.getParameter("called_from");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String from					= (String) hash.get( "from" );
		if(from==null || from.equals(""))
			from	=	"1";

		if(called_from!= null && called_from.equals("override")) {
			OverRideBMSBean beanObj		= (OverRideBMSBean)getBeanObject(bean_id,bean_name,request);
			Enumeration keys		= hash.keys();
			String key				=	null;
			String value			=  null;

			while(keys.hasMoreElements()) {
				key				= (String)keys.nextElement();
				value			= (String)hash.get(key);
				
				if(key.startsWith("chk_")){
					beanObj.getRecordStatus().put(key.substring(4,key.length()),value);
				}
			}
			putObjectInBean(bean_id,beanObj,request);
		} 
		else if(called_from!= null && called_from.equals("release")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id,bean_name, request);
			
			Enumeration keys		= hash.keys();
			String key				=	null;
			String value			=  null;
			while(keys.hasMoreElements()) {
				key				= (String)keys.nextElement();
				value			= (String)hash.get(key);
				if(key.startsWith("chk_")){
					beanObj.getRecordStatus().put(key.substring(4,key.length()),value);
				}
				if(key.startsWith("rcode_")){
					beanObj.getRsnCodes().put(key.substring(6,key.length()),value);
				}
			}
			// Added for SRR20056-SCF-7734 ICN 28022 - Start
			String incompleteAdmixORdID = hash.get("incompleteAdmixORdID")==null?"":(String) hash.get("incompleteAdmixORdID");
			if(!incompleteAdmixORdID.equals("")){
				beanObj.setIncompleteAdmixFoundPrev("Y");
				beanObj.setPrevAdmixOrderID(incompleteAdmixORdID);
			}
			// Added for SRR20056-SCF-7734 ICN 28022 - End
			putObjectInBean(bean_id,beanObj,request);	
		}
		// Added for SRR20056-SCF-7734 ICN 28022 - Start
		else if(called_from!= null && called_from.equals("AdmixtureGroup")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id,bean_name, request);
			String order_id = (String) hash.get("order_id");
			String Nxtorder_line_num = (String) hash.get("Nxtorder_line_num");
			String select_yn = (String) hash.get("select_yn");
			String sWorkSheetId = (String) hash.get("WorkSheetId");
			if(select_yn != null && select_yn.equals("Y")){
				beanObj.setPrevAdmixOrderID(order_id);
				beanObj.setPrevAdmixWorkSheetId(sWorkSheetId);
			}
			else{
				beanObj.setPrevAdmixOrderID("");
				beanObj.setPrevAdmixWorkSheetId("");
				beanObj.setPrevAdmixReasonCode("");
				HashMap  rsnCodes =  beanObj.getRsnCodes();
				Set keyset		= rsnCodes.keySet();
				Iterator keyIter = keyset.iterator();
				String key				=	null;
				String value			=  null;
				while(keyIter.hasNext()) {
					key				= (String)keyIter.next();

					if(key!=null && key.indexOf(order_id+Nxtorder_line_num)!= -1){
						out.println("document.frmReleaseBatchesResult.incompleteAdmixFound.value='Y';");
						beanObj.setPrevAdmixOrderID(order_id);
						break;
					}
				}
			}

			putObjectInBean(bean_id,beanObj,request);	
		}
		else if(called_from!= null && called_from.equals("AdmixtureGroupReason")) {
			ReleaseBatchesBean beanObj		= (ReleaseBatchesBean)getBeanObject(bean_id,bean_name, request);
			String reason_code = (String) hash.get("reason_code");
			beanObj.setPrevAdmixReasonCode(reason_code);
			putObjectInBean(bean_id,beanObj,request);	
		}
		// Added for SRR20056-SCF-7734 ICN 28022 - End
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}

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
