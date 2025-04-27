package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.net.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __consentnotesvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentNotesValidate.jsp", 1731501070000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
12/11/2018	  IN069014		Prakash C		12/11/2018		Ramesh G		CA-MMOH-Consent Checkbox
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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

	request.setCharacterEncoding("UTF-8");
	String bean_id ="";
	String bean_name = "";
	String index = "";
	String consent_form_text = "";
	String consent_form_id = "";
	String count	= "0";
 
	//String Consentdetail = request.getParameter( "Consentdetail" ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	bean_id = (String)hash.get("bean_id");
	bean_name = (String)hash.get("bean_name");
	index = (String)hash.get("index");
	consent_form_text = (String)hash.get("consent_form_text");
	consent_form_id = (String)hash.get("consent_form_id");
	
	//System.out.println("index====================="+index);
	//System.out.println("consent_form_id====================="+consent_form_id);

	count	= (String)hash.get("count");
	String consent_text = "";
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( consent_form_id == null || consent_form_id.equals( "" ) ) consent_form_id = "";
	if ( count == null || count.equals( "" ) ) count = "0";

	String patient_name		= (String)hash.get("patient_name");
	if ( patient_name == null || patient_name.equals( "" ) ) patient_name = "";
	String practitioner_name = (String)hash.get("practitioner_name");
	if ( practitioner_name == null || practitioner_name.equals( "" ) ) practitioner_name = "";
	String reln_box			= (String)hash.get("reln_box");
	if ( reln_box == null || reln_box.equals( "" ) ) reln_box = "";
	String dat_time			= (String)hash.get("dat_time");
	if ( dat_time == null || dat_time.equals( "" ) ) dat_time = "";
	String remarks			= (String)hash.get("remarks");
	if ( remarks == null || remarks.equals( "" ) ) remarks = "";
	String practitioner_id			= (String)hash.get("practitioner_id");
	if ( practitioner_id == null || practitioner_id.equals( "" ) ) practitioner_id = "";
	String self			= (String)hash.get("self");
	if ( self == null || self.equals( "" ) ) self = "n";
	
    
	int count_records = Integer.parseInt(count);
	//String consent_form_id = "";
	//HashMap consentCatalog = new HashMap();

	ConsentOrders beanObj = (ConsentOrders)getBeanObject( bean_id, bean_name ,request) ;
	HashMap consent= (HashMap)beanObj.getConsentDetail();
	HashMap patient_detail= (HashMap)beanObj.getPatientDetail();
	ArrayList patient_info = new ArrayList();
		
	if(count_records>0){
		for(int i=0;i<count_records;i++){
			consent_text = (String)hash.get("consent_form_text"+i);
			consent_form_id = (String)hash.get("consent_form_id"+i);
	 		consent.put(index+consent_form_id,consent_text);
			//catalog = catalog+"||";
			if(!practitioner_name.equals("")){//IN069014
				beanObj.setConsentFormId(index, consent_form_id);
			}//IN069014
 		}
		//consentCatalog.put(index, catalog);
	} else {
		consent.put(index,consent_form_text);
		beanObj.setConsentFormId(index, consent_form_id);
  	}
	
	// Storing it in a arraylist , then storing it in the hashmap with the index as key
	//patient_info.add(patient_name);//IN036697
	patient_info.add(URLDecoder.decode(patient_name, "UTF-8"));//IN036697
	patient_info.add(practitioner_name);
	patient_info.add(reln_box);
	patient_info.add(dat_time);
	patient_info.add(remarks);
	patient_info.add(practitioner_id);
	patient_info.add(self);
	

	patient_detail.put(index, patient_info);
	beanObj.setConsentDetail(consent);
	beanObj.setPatientDetail(patient_detail);
	//out.println("consent"+consent);
	//consent = beanObj.getConsentDetail();

	//String consentStr = (String)consent.get(index);
	patient_info = null;
 	patient_detail = null;

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
