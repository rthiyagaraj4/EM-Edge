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
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __capturepregnencydetailvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/CapturePregnencyDetailValidation.jsp", 1722335170548L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
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

try{
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id    = request.getParameter( "bean_id" ) ;
	String bean_name  = request.getParameter( "bean_name" ) ;
	
	String identity   = request.getParameter( "identity" ) ;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	CapturePregnencyDetailBean bean = (CapturePregnencyDetailBean)getBeanObject( bean_id,bean_name,request) ;
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	 if (identity.equals("POPULATEENCOUNTER")){
		String patient_id	= request.getParameter( "patient_id" ) ;
		out.println("clearEncList();") ;
		ArrayList patientdetails	= bean.getPatientDetails(patient_id);
		if(patientdetails.size()>0) {
			ArrayList encounterDetails =bean.getEncounterIdDetails(patient_id) ; //HC00003199
			if(encounterDetails!=null && encounterDetails.size()>0){
				for (int i=0; i<encounterDetails.size(); i++) {
					out.println("addEncList('"+ encounterDetails.get(i) + "');") ;
				}
				out.println("defCurrEncounter('"+ encounterDetails.get(0) + "');") ;
			}
			out.println("chkpatID('N');") ;
		}
		else{
			out.println("chkpatID('Y');") ;
		}
	}
	else if (identity.equals("POPULATELOCATION")){
		String encounter_id	= request.getParameter( "encounter_id" ) ;
		String locn_desc, locn_code,pract_name , admin_date;
		ArrayList locationDetails =new ArrayList();
		locationDetails =bean.getLocationForEID(encounter_id) ;
		for (int i=0; i<locationDetails.size(); i+=4) {//i+=2
			locn_desc=(String)locationDetails.get(i);
			locn_desc=locn_desc.replaceAll(" ","%20");
			locn_desc = java.net.URLEncoder.encode(locn_desc,"UTF-8");
			locn_desc=locn_desc.replaceAll("%2520","%20");
			locn_code=(String)locationDetails.get(i+1);
			pract_name=(String)locationDetails.get(i+2);
			pract_name=pract_name.replaceAll(" ","%20");
			pract_name = java.net.URLEncoder.encode(pract_name,"UTF-8");
			pract_name=pract_name.replaceAll("%2520","%20");
			admin_date=(String)locationDetails.get(i+3);
			out.println("addlocation('"+ locn_desc + "','"+ locn_code + "','"+ pract_name + "','"+ admin_date + "');") ;
		} 
	}
	else if (identity.equals("CALEXPECTEDDATE")){
		String lmp_date	= request.getParameter( "lmp_date" ) ;
		String exp_date =(String)bean.getCalExpectedDeate(lmp_date) ;
		out.println("addexpecteddate('"+ exp_date + "');") ;
	}
	else if (identity.equals("CALPERGSTAGE")){
		String lmp_date	= request.getParameter( "lmp_date" ) ;
		String preg_week =(String)bean.getCalPregStage(lmp_date) ;
		
		out.println("addpregweek('"+ preg_week + "');") ;
	}
	else if (identity.equals("GETTRIMSTER")){
		String preg_week	= request.getParameter( "preg_week" ) ;
		String trimster =(String)bean.getTrimster(preg_week) ;
		out.println("assignTrimster('"+ trimster + "');") ;
	} 
	else if (identity.equals("PREG_DAYS")){
		String lmp_date	= request.getParameter( "lmp_date" ) ;
		String temp_date	= request.getParameter( "temp_date" ) ;
		String obj	= request.getParameter( "temp_name" ) ;
		String flag	= request.getParameter( "flag" ) ;
		String preg_days =(String)bean.getPregnencyDays(lmp_date,temp_date) ;
		out.println("chkpregDaysAlert('"+ preg_days + "','"+ obj + "','"+ flag + "');") ;
	} 
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
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
