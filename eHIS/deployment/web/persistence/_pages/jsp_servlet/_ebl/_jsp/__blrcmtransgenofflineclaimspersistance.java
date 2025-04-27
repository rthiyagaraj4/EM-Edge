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

public final class __blrcmtransgenofflineclaimspersistance extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLRCMTransGenOfflineClaimsPersistance.jsp", 1727248168729L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n";
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
/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V240828							MOHE-CRF-0166.3-US005    			Khaled Samir
*/ 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

	System.err.println("Persitence file called.");
	String params = request.getQueryString();
	
	String beanId = "bl_BLRCMTransactionsBean";
	String beanName = "eBL.BLRCMTransactionsBean";
	
	BLRCMTransactionsBean policyBean = (BLRCMTransactionsBean) getBeanObject(beanId, beanName, request);
	List<BLRCMTransactionsBean> covList = new ArrayList<BLRCMTransactionsBean>();
	BLRCMTransactionsBean covBean = null;
	
	if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<BLRCMTransactionsBean>>());
	}
	
	HashMap<String, List<BLRCMTransactionsBean> > policyMap = policyBean.getPolicyMap();

	
	Connection con=null;
	PreparedStatement pstmt=null;
	int rs=0;
	CallableStatement cstmt=null;
		
	try 
	{
		
		request.setCharacterEncoding("UTF-8");
		con=ConnectionManager.getConnection(request);
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		boolean proceed=true;
	
			Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash = (Hashtable)hash.get( "SEARCH" ) ;	
			
			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");
			//String rcmTransFieldsMOHYN = (String)hash.get("rcmTransFieldsMOHYN");			
			int cnt = Integer.parseInt((String)hash.get("bill_tot_rec"));
			
			
			
			System.err.println("Rowcount is:"+cnt);
			String patient_id="",encounter_id="",episode_type="", bill_doc_type_code="", bill_doc_num="", claim_id="",claim_type="";
			String status="";
			String sql="insert into bl_rcm_rep_selected_bills (PATIENT_ID,ENCOUNTER_ID,EPISODE_TYPE,BILL_DOC_TYPE_CODE,BILL_DOC_NUM,CLAIM_ID,CLAIM_TYPE) VALUES (?,?,?,?,?,?,?)";
			String procSql="{ call bl_moh_eclaims_rcm_data(?) }";
			try{
				con.setAutoCommit(false);
			
				for(int i=0; i<cnt; i++){
					status=(String) hash.get("check_payer"+i);
					if(status.equals("Y")){
						
						covBean = new BLRCMTransactionsBean();
						System.err.println("covList is:"); 
						//System.err.println("Status is:"+hash.get("checkedStatus_"+i));
						
						covBean.setFacilityId((String)hash.get("facility_id"));
						covBean.setClaimID((String)hash.get("claimID_" + i));
						covBean.setPatientId((String)hash.get("patientId_" + i));
						covBean.setBillDocTypeCode((String)hash.get("billDocTypeCode_" + i));
						covBean.setBillNum((String)hash.get("billNum_" + i));
						covBean.setEpisodeType((String)hash.get("episodeType_"+i));
						covBean.setEncounterId((String)hash.get("encounterId_" + i));
						covBean.setCheckedStatus((String)hash.get("checkedStatus_" + i));
						covBean.setClaimTypeCode((String)hash.get("claimTypeCode_"+i));
						covBean.setPreAuthRefNo((String)hash.get("preAuthRefNo_"+i));
						covBean.setPreAuthSplit((String)hash.get("preAuth_split_checker"));
						

						covList.add(covBean); 
						System.err.println("covList .."+covList.isEmpty());   	
						
						patient_id=(String)hash.get("patientId_" + i);
						encounter_id=(String)hash.get("encounterId_" + i);
						episode_type=(String)hash.get("episodeType_" + i);
						bill_doc_type_code=(String)hash.get("billDocTypeCode_" + i);
						bill_doc_num=(String)hash.get("billNum_" + i);
						claim_id=(String)hash.get("claimID_" + i);
						claim_type=(String)hash.get("claimTypeCode_" + i);
						
						System.err.println("claimTypecode:"+claim_type);
						
						pstmt=con.prepareStatement(sql);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,encounter_id);
						pstmt.setString(3,episode_type);
						pstmt.setString(4,bill_doc_type_code);
						pstmt.setString(5,bill_doc_num);
						pstmt.setString(6,claim_id);
						pstmt.setString(7,claim_type);
						
						rs=pstmt.executeUpdate();
						if(rs>0){
							System.out.println("data inserted");
						}else{
							proceed=false;
							System.out.println("data failed");
						}
						System.err.println(patient_id+","+encounter_id+","+episode_type+","+bill_doc_type_code+","+bill_doc_type_code+","+claim_id);
					}
					   
				}
				if(proceed){
					con.commit();
					cstmt = con.prepareCall(procSql);
					cstmt.setString(1,facilityId);
					cstmt.execute();
				}else{
					con.rollback();
				}
				
				
				if(!(covList.isEmpty()))
					policyMap.put("BLSELOFFCLM", covList);  
				
			System.err.println("Data is in Policy Map..");
			for(int i=0;i<covList.size();i++){
				System.err.println("covList size:"+ covList.size());
				System.err.println("covList size:"+ covList.get(i).getEncounterId());
			}
		
				
					
				
			}catch(Exception e) {
				e.printStackTrace();
			}	
				
	
		
	}catch (Exception e) {	
		e.printStackTrace();
	}
	finally{
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(con,request);		
	}		
	
	putObjectInBean("bl_BLRCMTransactionsBean",policyBean,request);   
	
	
	

        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
