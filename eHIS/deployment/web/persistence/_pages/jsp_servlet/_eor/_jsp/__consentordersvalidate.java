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

public final class __consentordersvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentOrdersValidate.jsp", 1731501084000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eOR.ConsentOrders beanObj= null;{
                beanObj=(eOR.ConsentOrders)pageContext.getAttribute("beanObj");
                if(beanObj==null){
                    beanObj=new eOR.ConsentOrders();
                    pageContext.setAttribute("beanObj",beanObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
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
	String bean_id	 = request.getParameter( "bean_id" ) ;
	String validate	 = request.getParameter( "validate" ) ;

	String practitioner_id	= (String)session.getAttribute("ca_practitioner_id");
	String facility_id		= (String)session.getAttribute("facility_id");
	Properties properties	= (Properties)session.getAttribute( "jdbc" );

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	if ( validate == null || validate.equals( "" ) ) 
		return ;

	//ConsentOrders beanObj = (ConsentOrders)getBeanObject( bean_id, "eOR.ConsentOrders" ,request ) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		String locn_type = (String)hash.get("location_type") ;
		out.println( "clearList('document') ; " ) ;
		
	//	out.println( "alert(\"" + locn_type + "\") ; " ) ;

		ArrayList OrderTypeData = beanObj.getLocation(properties, locn_type,practitioner_id,facility_id) ;
		//out.println( "alert(\"" + beanObj.chk+ "\") ; " ) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}else{
		ConsentOrders bean			= (ConsentOrders)getBeanObject(bean_id,"eOR.ConsentOrders",request);
		bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		if ( validate.equals( "MULTI_CONSENT" ) ) {
			try{
			String order_catalog_code	= (String)hash.get("order_catalog_code") ;
			String order_id				= (String)hash.get("order_id") ;
			String order_line_num		= (String)hash.get("order_line_num") ;
			String type					= (String)hash.get("type") ;
								
			ArrayList multiConsentList	= null;
			StringBuffer noteligible_consent_id = new StringBuffer();
			StringBuffer tmp_consent_desc = new StringBuffer();
			multiConsentList			= bean.MultiListConsents(order_catalog_code,order_id, order_line_num, practitioner_id);
		
			String[] multiConsentValues	= null;
			//System.out.println("==multiConsentList=="+multiConsentList+"====");
			if(multiConsentList !=null && multiConsentList.size()>0 ){
				out.println( "showSelect() ; " ) ;
				for(int i=0;i<multiConsentList.size();i++){
					multiConsentValues		= (String[])multiConsentList.get(i);
					if(multiConsentValues[9].equals("Y")){
						
						if(multiConsentValues[12].equals("N")){
							noteligible_consent_id.append(multiConsentValues[1]);
							noteligible_consent_id.append("~");
							tmp_consent_desc = new StringBuffer();
							tmp_consent_desc.append(multiConsentValues[2]);
							tmp_consent_desc.append("(*)");
							//noteligible_consent_id += multiConsentValues[1] +"~" ;		
							//multiConsentValues[2] += "(*)";
							multiConsentValues[2] = tmp_consent_desc.toString();
						}

						if(type.equals("select-one")){
							out.println( "addConfirmedConsentList(\"" + multiConsentValues[1] + "\",\"" + multiConsentValues[2] + "\",\"" + multiConsentValues[10] + "\") ; " ) ;
						}else{
							
							out.println( "consent_id = \"" + multiConsentValues[1] + "\"; " ) ;
							out.println( "consent_desc =\"" + multiConsentValues[2] + "\"; " ) ;
						}
					}
					if( (multiConsentList.size() -1) == i){
						out.println( "noteligible_consent_id = \"" + noteligible_consent_id.toString()+ "\"; " ) ;
						out.println( "callDefaultSelect() ; " ) ;
					}
				}

			}else{
				
				ArrayList multiNAConsentList= null;
				multiNAConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,order_id,order_line_num, practitioner_id);
				
				if(multiNAConsentList != null && multiNAConsentList.size() > 0)
					out.println( "showSelect() ; " ) ;
				for(int i=0;i<multiNAConsentList.size();i++){
					multiConsentValues		= (String[])multiNAConsentList.get(i);
					if(multiConsentValues[9].equals("Y")){
						
						if(multiConsentValues[12].equals("N")){
							noteligible_consent_id.append(multiConsentValues[1]);
							noteligible_consent_id.append("~");
							tmp_consent_desc = new StringBuffer();
							tmp_consent_desc.append(multiConsentValues[2]);
							tmp_consent_desc.append("(*)");
							//noteligible_consent_id += multiConsentValues[1] +"~" ;		
							//multiConsentValues[2] += "(*)";
							multiConsentValues[2] = tmp_consent_desc.toString();
						}

						if(type.equals("select-one")){
							out.println( "addConfirmedConsentList(\"" + multiConsentValues[1] + "\",\"" + multiConsentValues[2] + "\",\"" + multiConsentValues[10] + "\") ; " ) ;
						}else{
							
							out.println( "consent_id = \"" + multiConsentValues[1] + "\"; " ) ;
							out.println( "consent_desc =\"" + multiConsentValues[2] + "\"; " ) ;
						}
					}
					if( (multiNAConsentList.size() -1) == i){
						out.println( "noteligible_consent_id = \"" + noteligible_consent_id.toString()+ "\"; " ) ;
						out.println( "callDefaultSelect() ; " ) ;
					}
				}

			}

			}catch(Exception e){
				//out.println(e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();
			}
			
		}else if(validate.equals( "CLEAR_CONSENT" )){
			try{
			String index			= (String)hash.get("index");
			String from			= (String)hash.get("from");
			//System.err.println("from"+from);
			HashMap Consent			= bean.getConsentDetail();
			HashMap PatientDetail	= bean.getPatientDetail();
			HashMap Consentform		= bean.getConsentFormId();
			String consent_form_id	= (String)Consentform.get(index);
//	System.out.println("=consent_form_id=="+consent_form_id+"=Consent==="+Consent+"===index=="+index);	
			if(consent_form_id!= null && !consent_form_id.equals("")){
				if(Consent != null)
					Consent.remove(index+consent_form_id);
				if(PatientDetail != null)
					PatientDetail.remove(index);
//System.out.println("=Consent=="+Consent+"=PatientDetail==="+PatientDetail+"===index=="+index);
				bean.setConsentFormId(index, null);
				bean.setConsentDetail(Consent);
				bean.setPatientDetail(PatientDetail);
				//System.err.println("from"+from);
				if(from.equals("Select"))
				{
					out.println( "displayDetails(\""+index+"\",\"true\" ) ; " ) ;
				}
				else if(from.equals("chckbox"))
				{
					//System.err.println("entering here");
					out.println( "callDummy(\""+index+"\") ; " ) ;
				}
			}		

			}catch(Exception e){
				//out.println(e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();
			}
		}else if(validate.equals( "GET_CONSENT_FORM_ID" )){
			String index			= (String)hash.get("index");
			String action			= "";
			HashMap Consentform		= bean.getConsentFormId();
			String consent_form_id	= (String)Consentform.get(index);
			//System.out.println("Consentform##########"+Consentform);
			//System.out.println("consent_form_id###########"+consent_form_id);
			if(hash.containsKey("action"))
				action				= (String)hash.get("action");
			if(action.equals("SHOW_DETAILS"))
				out.println( "consent_id = \"" + consent_form_id + "\"; " ) ;
			else{
				if(consent_form_id!= null && !consent_form_id.equals(""))
					out.println( "setConsentId('"+consent_form_id+"','"+index+"') ; " ) ;
				else
					out.println( "defaultSelect(\""+index+"\" ) ; " ) ;
			}
			
		}
		putObjectInBean(bean_id,bean,request);
	}
	//putObjectInBean(bean_id,bean,request);

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
