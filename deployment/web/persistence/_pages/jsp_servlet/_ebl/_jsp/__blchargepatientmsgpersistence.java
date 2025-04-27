package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blchargepatientmsgpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientMsgPersistence.jsp", 1709114094209L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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


	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

 private String getMessageString(String messageId, Connection con) {
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String output = "";
	String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
	try{
		pstmt = con.prepareStatement(messageQuery);
		pstmt.setString(1, messageId);
		rst = pstmt.executeQuery();
		if(rst != null && rst.next()){
			output = messageId+"-"+rst.getString("message_text_sysdef");
		}						
		
	}
	catch(Exception e){
		System.err.println("Exception in getting Message String ->"+e);
		output = messageId;
	}
	finally{
		pstmt = null;
		rst = null;
		
	}
	return output;
}	


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
// Page Added by Rajesh V. To Persist all the services in New Order 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "BLChargePatientMessage" ;
	String beanName = "eBL.BLChargePatientMessage";
	Connection con = null;
	BLChargePatientMessage messageBean = (BLChargePatientMessage) getObjectFromBean(beanId, beanName, session);
	if(messageBean == null){
		messageBean = new BLChargePatientMessage();
	}
	ResourceBundle rb = null;
	Locale loc = null;
	String locale = (String) session.getAttribute("LOCALE");
	try 
	{
		loc = new Locale(locale);
		rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		con = ConnectionManager.getConnection();
		String func_mode = request.getParameter("func_mode");
		System.err.println("func_mode"+func_mode);
		
		if(func_mode!= null && "storeErrWarn".equals(func_mode)){
			List<BLChargePatientMessage> warnList = new ArrayList<BLChargePatientMessage>();
			List<BLChargePatientMessage> errorList = new ArrayList<BLChargePatientMessage>();
					
			BLChargePatientMessage loopBean = null;
			int warningCount = 0;
			int errorCount = 0;
			try{
				warningCount = Integer.parseInt(request.getParameter("warningCount"));
			}
			catch(Exception e){
				warningCount = 0;
			}

			try{
				errorCount = Integer.parseInt(request.getParameter("errorCount"));
			}
			catch(Exception e){
				errorCount = 0;
			}
			System.err.println("warningCount"+warningCount);
			System.err.println("errorCount"+errorCount);
			if(warningCount > 0){
				String warnText = "";
				String warnServ = "";
				String warnTrx = "";
				for(int i=1;i<=warningCount;i++){
					loopBean = new BLChargePatientMessage();
					warnTrx = request.getParameter("warningTrx"+i);
					warnServ =  request.getParameter("warningServ"+i);
					warnText = request.getParameter("warningMess"+i);
					try{
						warnText = rb.getString(warnText);
					}
					catch(Exception rbException){
						warnText = getMessageString(warnText,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					loopBean.setTrxDoc(warnTrx);
					loopBean.setBlngServ(warnServ);
					loopBean.setCode(warnText);
					warnList.add(loopBean);
				}
			}
			
			if(errorCount > 0){
				String errorText = "";
				String errorServ = "";
				String errorTrx = "";
				for(int i=1;i<=errorCount;i++){
					loopBean = new BLChargePatientMessage();
					errorTrx = request.getParameter("errorTrx"+i);
					errorServ =  request.getParameter("errorServ"+i);
					errorText = request.getParameter("errorMess"+i);
					try{
						errorText = rb.getString(errorText);
					}
					catch(Exception rbException){
						errorText = getMessageString(errorText,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					loopBean.setTrxDoc(errorTrx);
					loopBean.setBlngServ(errorServ);
					loopBean.setCode(errorText);
					errorList.add(loopBean);
				}				
			}
			messageBean.setErrorList(errorList);
			messageBean.setWarningList(warnList);
		}
		
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Message Persistence :" + e);
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con);
	}
	

	putObjectInBean(beanId,messageBean,request);


            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
