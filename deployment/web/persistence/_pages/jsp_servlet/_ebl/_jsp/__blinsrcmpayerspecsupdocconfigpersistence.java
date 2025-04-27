package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.omg.PortableInterceptor.ACTIVE;
import eBL.PayerConfigDocumentValidations;
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

public final class __blinsrcmpayerspecsupdocconfigpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLInsRCMPayerSpecSupDocConfigPersistence.jsp", 1726819560245L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\r\n";
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


public String checkForNull(String inp){
	return (inp==null) ? "":inp;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	System.out.println("IM here persistence");
	String params = request.getQueryString();
	String beanId = "bl_DocumentMasterBean" ;
	String beanName = "eBL.DocumentMasterBean";
	
	
	DocumentMasterBean fmtDtlsBean = null;
	List<DocumentMasterBean> documents = null;
	DocumentMasterBean docBean = (DocumentMasterBean) getBeanObject(beanId, beanName, request);

	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	if(docBean.getDocMap() == null)
	{
		docBean.setDocMap(new HashMap<String, List<DocumentMasterBean>>());
	}
	

	
	
	HashMap<String, List<DocumentMasterBean> > docMap = docBean.getDocMap();
	Connection 	connection = null;
	try 
	{
		connection = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String facility_id = (String)session.getAttribute("facility_id");
		
		
		System.out.println("the facility id is :-> " +facility_id);
		
		String func_mode = request.getParameter("func_mode");

		System.out.println("function mode is  : "+func_mode+", "+locale+","+facility_id);

		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String mode = (String)hash.get("mode");	
		
		
		if(func_mode!= null && func_mode.equals("docsInfo"))
		{			
			List<DocumentMasterBean> dList = new ArrayList<DocumentMasterBean>();
			DocumentMasterBean dBean = null;
			int count = Integer.parseInt((String)hash.get("docRowCount"));
			
			int indx=0;
				
			for(int i=0; i<count;i++){
				
		
					while(hash.get("reportId_"+indx)==null){
					indx++;
				}

				dBean = new DocumentMasterBean();
				dBean.setReportId((String)hash.get("reportId_" + indx));
				dBean.setReportName((String)hash.get("reportName_" + indx));
				dBean.setRepSeq(checkForNull((String)hash.get("reportSeq_" + indx)));
				
				dBean.setAppl_ip((String)hash.get("appl_ip_" + indx));
				dBean.setAppl_dc((String)hash.get("appl_dc_" + indx));
				dBean.setAppl_op((String)hash.get("appl_op_" + indx));
				dBean.setAppl_em((String)hash.get("appl_em_" + indx));
				dBean.setAll((String)hash.get("all_" + indx));
	
				System.out.print(" we added docsInfo id "+ dBean.getReportId());
				dList.add(dBean);			
					indx++;
				
			}
				
			docMap.put("docsInfo", dList);
			
			System.out.println("what are u do : "+docMap.get("docsInfo"));
			
		
		}
		else if(func_mode!= null && func_mode.equals("deleteRow"))
		{	

			String payerGroup	= request.getParameter( "payerGroup" );
			String payer	= request.getParameter( "payer" );
			String policy	= request.getParameter( "policy" );
			String reportId= request.getParameter( "reportId" );
			
	
			
			int rsCnt = 0;
			pstmt = con.prepareStatement( "SELECT count(1) total FROM BL_SUPPORT_DOC_SETUP WHERE CUST_GROUP_CODE= ? and CUST_CODE = ? and POLICY_TYPE_CODE = ? and operating_facility_id=? and REPORT_ID=?");
			
			pstmt.setString(1,payerGroup);
			pstmt.setString(2,payer);
			pstmt.setString(3,policy);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,reportId);
			
			rs = pstmt.executeQuery();	
			while(rs!=null && rs.next())
			{
				rsCnt  =  rs.getInt("total");
			}
			
			pstmt = null;
			rs = null;
			if(docBean.getPopupList()==null){
			
				docBean.setPopupList(new ArrayList<String>());
				
			}
		
			if(!docBean.getPopupList().contains(reportId)&&rsCnt>0){
				docBean.getPopupList().add(reportId);
			}
			
		
		}
		
		
		
		else if(func_mode!= null && func_mode.equals("infoFrame"))
		{			
			
			docBean.setPayerCode((String)hash.get("payerCode"));
			docBean.setPayerGroupCode((String)hash.get("payerCode2"));
			docBean.setPolicyTypeCode((String)hash.get("policyTypeCode"));
			docBean.setFacility_id(facility_id);
			

			
		}
		else if (func_mode != null && func_mode.equals("supportDocConfigVar"))
		{
			docBean.setActive((String)hash.get("active"));
			docBean.setMergePdfReport((String)hash.get("mergeReports"));
			docBean.setIcludeExternalReports((String)hash.get("icludeExternalReports"));
			docBean.setBackDatedJobRun_Sup((String)hash.get("backdatedJobRunSup"));

		}
		
		else if (func_mode != null && func_mode.equals("generalFrame")) {
		    String newBornLimitStr = (String) hash.get("new_born_limit");
		    String newBornLimitInd = (String) hash.get("new_born_limit_ind");

		    System.out.println("The limit value is " + newBornLimitStr);
		    System.out.println("The limit IND is " + newBornLimitInd);

		    try {
		        if (newBornLimitStr != null) {
		            
		            docBean.setNewBornLimit(newBornLimitStr);
		        } else {
		            docBean.setNewBornLimit("30");
		        }
		    } catch (NumberFormatException e) {
		        System.err.println("Invalid number format for new_born_limit: " + newBornLimitStr);
		        docBean.setNewBornLimit("30"); 
		    }

		    if (newBornLimitInd != null) {
		        docBean.setNewBornLimitInd(newBornLimitInd);
		    } else {
		        docBean.setNewBornLimitInd("D"); 
		    }
		}
		
		
		else if (func_mode != null && func_mode.equals("validationsParam")){
			docBean.setBackDatedJobRun_Val((String)hash.get("backdatedJobRunVal"));
			System.out.println("the backdatedJobRunVal is : "+docBean.getBackDatedJobRun_Val());
		}
		else if(func_mode != null && func_mode.equals("validationsRow"))
		{
			
			  List<PayerConfigDocumentValidations> validations = new ArrayList();
			  
			  int numOfRows = Integer.parseInt((String) hash.get("numOfRows"));
			  
			  for(int i= 0 ; i < numOfRows ; i++){
				  String validationType  = (String) hash.get("validationType_"+i);
				  String validationDescription  = (String) hash.get("validationName_"+i);
				  String app_ip          = (String) hash.get("appl_ip_"+i);
				  String app_op          = (String) hash.get("appl_op_"+i);
				  String app_em			 = (String) hash.get("appl_em_"+i);	
				  String app_dc          = (String) hash.get("appl_dc_"+i);
				  String app_all         = (String) hash.get("all_"+i);
				  PayerConfigDocumentValidations validationObj = new  PayerConfigDocumentValidations();
				  validationObj.setValidationType(validationType);
				  validationObj.setValidationDescription(validationDescription);
				  validationObj.setApp_all(app_all);
				  validationObj.setAppl_dc(app_dc);
				  validationObj.setAppl_em(app_em);
				  validationObj.setAppl_ip(app_ip);
				  validationObj.setAppl_op(app_op);
				  validations.add(validationObj);
			  }
			  docBean.setValidations(validations);
			  System.out.println("the validation size is :-> "+validations.size());
			  
		}

		 else if(func_mode!=null && func_mode.equals("validateCombination"))	
		{
			String payerGroup	= request.getParameter( "payerGroup" );
			String payer	= request.getParameter( "payer" );
			String policy	= request.getParameter( "policy" );
			int rsCnt = 0;
			pstmt = con.prepareStatement( "SELECT count(1) total FROM BL_SUPPORT_DOC_SETUP_HDR WHERE CUST_GROUP_CODE= ? and CUST_CODE = ? and POLICY_TYPE_CODE = ? and operating_facility_id=?");
			pstmt.setString(1,payerGroup);
			pstmt.setString(2,payer);
			pstmt.setString(3,policy);
			pstmt.setString(4,facility_id);
			
			rs = pstmt.executeQuery();	
			while(rs!=null && rs.next())
			{
				rsCnt  =  rs.getInt("total");
			}
			if(rsCnt>0){
				out.println("N");
			}else{
				out.println("Y");
			}
			pstmt = null;
			rs = null;
		}
		
		
		
		
	}catch (Exception e) {	
		e.printStackTrace();
		
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}
	putObjectInBean("bl_DocumentMasterBean",docBean,request);

            _bw.write(_wl_block1Bytes, _wl_block1);
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
