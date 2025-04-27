package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;
import java.io.*;
import eST.Common.*;
import ePH.*;
import eST.*;
import eST.Common.*;
import eOR.*;
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __srrcertificateforreimbursementreportvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SRRCertificateForReimbursementReportValidate.jsp", 1732511880588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

try{

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String login_user       = (String)session.getValue("login_user");
		String facility    = (String)session.getValue("facility_id");

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String validate             = request.getParameter("validate") ; 
		if(validate.equals("RECORDS_FOR_CERTIFREIMBURSEMENT")){

		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		String doc_no			= hash.get( "doc_no" )==null?"":(String) hash.get( "doc_no" );
		String mode			=	 hash.get( "mode" )==null?"": (String) hash.get( "mode" );
		String p_store_code			=	 hash.get( "p_store_code" )==null?"": (String) hash.get( "p_store_code" );
	//	String checked_yn = hash.get( "checked_yn" ) == null?"":(String) hash.get( "checked_yn" ) ;
	//	String order_date="";
		SRRCertificateForReimbursementBean beanObj = (SRRCertificateForReimbursementBean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
	
		if (mode.equals("ADD_ELEMENT"))
		{
	        beanObj.setSelectedValue(doc_no);				

   		}else if(mode.equals("REMOVE_ELEMENT"))
		{
			beanObj.removeValue(doc_no);			
		}else if(mode.equals("ADD_ELEMENT_ALL"))
		{
			if(!doc_no.equals(""))
			{
			   if(doc_no.indexOf("~") > 0){
	
				String[] strArr = doc_no.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.setSelectedValue(strArr[i]);	
				}
			}else{
	               beanObj.setSelectedValue(doc_no);				
        		}
			}
		}else if(mode.equals("REMOVE_ELEMENT_ALL"))
		{
			if(!doc_no.equals(""))
			{
                  if(doc_no.indexOf("~") > 0){
				String[] strArr = doc_no.split("~");
				for(int i=0;i<strArr.length;i++){
					beanObj.removeValue(strArr[i]);		
				  }
				}else{
			beanObj.removeValue(doc_no);			
     		}	
		  }
		}else if(mode.equals("PRINT_FOR_CERTIFREIMBURSEMENT")){
		ArrayList active_CertiforReimbursements		=	new ArrayList();
		String []record=new String[11];
		active_CertiforReimbursements	=	beanObj.getCertiforReimbursementRecds();
		for(int i=0;i<active_CertiforReimbursements.size();i++){
		record= (String[])active_CertiforReimbursements.get(i);


	if(record[6].equals("Y")){

    	ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport(facility,"ST","STCERTREIM_SRR") ;
		    
		report1.addParameter("P_REPORT_ID","STCERTREIM_SRR") ;
		report1.addParameter("p_user_name",login_user) ;
		report1.addParameter("P_FACILITY_ID",facility) ;
		report1.addParameter("p_module_id","ST") ;
		report1.addParameter("P_LANGUAGE_ID",locale);
		report1.addParameter("P_DOC_NO",record[2]) ;
		report1.addParameter("P_DOC_DATE",record[0]) ;
		report1.addParameter("P_STORE_CODE",p_store_code) ;
		report1.addParameter("P_REPRINT","Y");
		onlineReports.add(report1) ;
		String ReportOutput = onlineReports.execute(request,response );

		}  

	   }

      }else if(mode.equals("CLEAR")){

	        beanObj.clear();
	    }
		
        putObjectInBean(bean_id,beanObj,request);
      }
		}catch (Exception e) {
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
