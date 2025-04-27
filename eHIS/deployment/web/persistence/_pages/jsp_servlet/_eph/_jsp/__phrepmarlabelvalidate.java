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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __phrepmarlabelvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PhRepMARLabelValidate.jsp", 1732509662086L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String from					= hash.get( "from" )==null?"0":(String) hash.get( "from" );

	PhRepMARLabelBean beanObj	= (PhRepMARLabelBean)getBeanObject(bean_id, bean_name, request);
	beanObj.setLanguageId(locale);
	try {
		String facility_id			= (String) hash.get( "facility_id" );
		String disp_locn_code		= (String) hash.get( "disp_locn_code" );
		String validate             = request.getParameter("validate")==null?"":request.getParameter("validate"); 
		if( validate.equals("patientsearch" ) ){
			String patient_id					= (String) hash.get("patient_id");
			ArrayList patientdetails	= beanObj.getPatientDetails(patient_id);
			if(patientdetails.size()==0){
				out.println("chkpatID('N');") ;
			}
			else{
				out.println("chkpatID('Y');") ;
			}
		}
		else if( validate.equals("UPDATESELECTION" ) ){
			String order_id					= (String) hash.get("order_id");
			String order_line_num					= (String) hash.get("order_line_num");
			String select_yn					= (String) hash.get("select_yn");
			String iv_prep_yn					= (String) hash.get("iv_prep_yn");
			String p_report_id = "";
			String key=order_id+"~"+order_line_num;
	
			if(iv_prep_yn.equals(""))
				p_report_id = "PHPRMARLBL";
			else if(iv_prep_yn.equals("3"))
				p_report_id = "PHPRMARINTLBL";
			else if (iv_prep_yn.equals("1"))
				p_report_id = "PHPRMARWALBL";
			else if (iv_prep_yn.equals("5"))
				p_report_id = "PHPRMARWOALBL";
			HashMap hmPrintList	= beanObj.getPrintList();
			if(hmPrintList!=null && select_yn.equals("N")) {
				hmPrintList.remove(key);
			}
			else if(select_yn.equals("Y"))
				hmPrintList.put(key, p_report_id);
			beanObj.setPrintList(hmPrintList);
		}
		else if(validate != null && validate.equals("UPDATESELECTIONALL" ) ){
			String selectAll_yn					= (String) hash.get("selectAll_yn");
			String order_id, order_line_num, key, iv_prep_yn, report_id="";
			ArrayList alOrdersList	= beanObj.getOrdersList();
			HashMap hmPrintList	= beanObj.getPrintList();
			for(int i=1;i<alOrdersList.size();i+=10){
				order_id=(String)alOrdersList.get(i+2);
				order_line_num=(String)alOrdersList.get(i+3);
				iv_prep_yn = (String)alOrdersList.get(i+9);
				key = order_id+"~"+order_line_num;
				if(!iv_prep_yn.equals("") && !order_line_num.equals("1")) //to avaoind duplicate label print when IV orders with fluid & Additives 
					continue;
				if(hmPrintList!=null && selectAll_yn.equals("N")) {
					hmPrintList.remove(key);
				}
				else if(selectAll_yn.equals("Y")){
					if(iv_prep_yn.equals(""))
						report_id = "PHPRMARLBL";
					else if(iv_prep_yn.equals("3"))
						report_id = "PHPRMARINTLBL";
					else if (iv_prep_yn.equals("1"))
						report_id = "PHPRMARWALBL";
					else if (iv_prep_yn.equals("5"))
						report_id = "PHPRMARWOALBL";
					hmPrintList.put(key, report_id);
				}
			}
			beanObj.setPrintList(hmPrintList);
		}		
		else if(validate.equals("PRINTMARLABELCHEK" ) ){
			HashMap hmPrintList	= beanObj.getPrintList();
			if(hmPrintList==null || hmPrintList.size()==0){
				out.println("alert(getMessage('PH_ATLEAST_ONE_SELECTED','PH'));") ;
			}
			else{
				out.println("assignResult('Y') ");
			}
			return ;
		}
		else if(validate.equals("PRINTMARLABEL" ) ){
			HashMap hmPrintList	= beanObj.getPrintList();
			String p_report_id = "",  ReportOutput="", key="", order_id="", order_line_num="" ;
			ecis.utils.OnlineReports onlineReports	= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReport report  = null;
			ArrayList keyList = new ArrayList(hmPrintList.keySet());
			String p_user_name		= (String)hash.get("p_user_name");
			String p_facility_id	= (String)hash.get("p_facility_id");
			String p_language_id   =(String)hash.get("p_language_id");
			for(int i=0;i<keyList.size();i++){
				key = (String)keyList.get(i);
				if(key!=null && key.indexOf("~")>-1){
					order_id = key.substring(0, key.indexOf("~"));
					order_line_num = key.substring( key.indexOf("~")+1, key.length());
					p_report_id		= (String)hmPrintList.get(key);
					report		= new ecis.utils.OnlineReport( p_facility_id, "PH",p_report_id) ;
					report.addParameter("p_report_id",p_report_id) ;
					report.addParameter("p_order_id",order_id);
					report.addParameter("p_order_line_num",order_line_num);
					report.addParameter("p_user_name",p_user_name) ;
					report.addParameter("p_facility_id",p_facility_id) ;
					report.addParameter("p_module_id", "PH") ;
					report.addParameter("p_language_id", p_language_id) ;
					onlineReports.add( report) ;
				}
			}
			ReportOutput = onlineReports.execute( request, response );
			beanObj.clear();
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
