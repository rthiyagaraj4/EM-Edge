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

public final class __srrphrepdlydispsummvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/SRRPhRepDlyDispSummValidate.jsp", 1732509726460L ,"10.3.6.0","Asia/Calcutta")) return true;
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	try {
		String func_mode			= request.getParameter("func_mode");
		String bean_id				=  request.getParameter("bean_id");
		String bean_name			=  request.getParameter("bean_name");
//		String locale = request.getParameter("locale");
		String locale = (String)session.getAttribute("LOCALE");
		//String func_mode = request.getParameter("bean_name");
		
		
		

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		

		if(func_mode!= null && func_mode.equals("populateDispLocs"))
		{
			SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
			bean.setLanguageId(locale);
			String facility_id     =  request.getParameter("facility_id");
						
			out.println("clearList()");
			ArrayList dispLocs = (ArrayList) bean.getDispLocnList(facility_id);	
			out.println("addOption('','A')");
			for(int i=0;i<dispLocs.size();i=i+2){
				
				 //Added code for  replacing spaces in Displocs for the incident num 23336 in spira on 31/Aug/2010
				String displocation=(String)dispLocs.get(i+1)==null?"":(String)dispLocs.get(i+1);	
				displocation=displocation.replaceAll(" ","%20");
				displocation=java.net.URLEncoder.encode(displocation,"UTF-8");
				displocation=displocation.replaceAll("%2520","%20");			
			out.println("addOption('"+dispLocs.get(i)+"','"+displocation+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(func_mode!= null && func_mode.equals("populateDispLocsByLocationType"))
		{
			String facility_id     =  request.getParameter("facility_id");
			String disp_locn_type  =  request.getParameter("disp_locn_type");	
			SRRPHDrugUsageByPractBean bean= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id, bean_name,request ) ;
			out.println("clearList()");
			ArrayList dispLocs = (ArrayList) bean.getDispLocnList(facility_id,disp_locn_type);
			out.println("addOption('','A')");
			for(int i=0;i<dispLocs.size();i=i+2){
				 //Added code for  replacing spaces in Displocs for the incident num 23698 in spira on 08/SEpt/2010
				String displocation1=(String)dispLocs.get(i+1)==null?"":(String)dispLocs.get(i+1);	
				displocation1=displocation1.replaceAll(" ","%20");								
				displocation1=java.net.URLEncoder.encode(displocation1,"UTF-8");		
				displocation1=displocation1.replaceAll("%2520","%20");			//ends		
				out.println("addOption('"+dispLocs.get(i)+"','"+displocation1+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(func_mode!= null && func_mode.equals("populateFillProcIDs")){
			String p_fill_proc_type		= (String) hash.get( "p_fill_proc_type" );
			String p_fill_proc_dt		= (String) hash.get( "p_fill_proc_dt" );
			String process_id			=	"";
			SRRPHRepDispStatisByDispBean bean	= (SRRPHRepDispStatisByDispBean)getBeanObject( bean_id, bean_name,request ) ;
			bean.setLanguageId(locale);
			ArrayList fill_process_id		=	bean.loadFillProcessID(p_fill_proc_type,p_fill_proc_dt);
			
			for(int i=0; i<fill_process_id.size(); i++)	{
				process_id	=	(String)fill_process_id.get(i);		
				out.println("addList('"+process_id+"')");
			}
			putObjectInBean(bean_id, bean, request);
		}
		else if(func_mode!= null && func_mode.equals("populateDispLocs1")){
			String facility_id     =  request.getParameter("facility_id");
			//String disp_locn_type  =  request.getParameter("disp_locn_type");	
			SRRPHDrugUsageByPractBean bean= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id, bean_name,request ) ;
			out.println("clearList()");
			ArrayList dispLocs = (ArrayList) bean.getDispLocnList(facility_id);
			out.println("addOption('','A')");
			for(int i=0;i<dispLocs.size();i=i+2){
				//Added code for  replacing spaces in Displocs   on 01/Oct/2010 ===By Sandhya
				String displocation2=(String)dispLocs.get(i+1)==null?"":(String)dispLocs.get(i+1);	
				displocation2=displocation2.replaceAll(" ","%20");
				displocation2=java.net.URLEncoder.encode(displocation2,"UTF-8");
				displocation2=displocation2.replaceAll("%2520","%20");			//ends
				out.println("addOption('"+dispLocs.get(i)+"','"+displocation2+"')");
			}
			putObjectInBean(bean_id, bean, request);
		} 
		else if(func_mode!= null && func_mode.equals("populateEventType")){
			String hypersensitivity = request.getParameter("hypersensitivity");
			SRRPHDrugUsageByPractBean bean= (SRRPHDrugUsageByPractBean)getBeanObject( bean_id, bean_name,request ) ;
			out.println("clearList_eventType()");
			ArrayList eventType = (ArrayList) bean.getEventTypeList(hypersensitivity);
			out.println("addOption_eventType('','A')");
			for(int i=0;i<eventType.size();i=i+2){
				out.println("addOption_eventType('"+eventType.get(i)+"','"+eventType.get(i+1)+"')");
			}
			putObjectInBean(bean_id, bean, request);
		}
		
	else if(func_mode.equals("CALLPATIENT")){
		ADRReportBean bean = (ADRReportBean)getBeanObject(bean_id,bean_name ,request) ;
		String patient_id			= request.getParameter("patient_id");
		bean.setLanguageId(locale);
	    ArrayList patientdetails = bean.getPatientDetails(patient_id);
		
			if(patientdetails.size()!=0)
			{
				 String p_name=(String)patientdetails.get(0)==null?"":(String)patientdetails.get(0);
				 //Added code for  replacing spaces in Patien name for the incident num 23230 in spira on 11/Aug/2010.
				p_name=p_name.replaceAll(" ","%20");
				p_name=java.net.URLEncoder.encode(p_name,"UTF-8");
				p_name=p_name.replaceAll("%2520","%20");				
				out.println("assignPatientLine(\""+p_name+"\")");
			}
			putObjectInBean(bean_id, bean, request);
		}
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}

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
