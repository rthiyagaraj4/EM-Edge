package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.model.BillReceiptExclusionDiscount;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
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

public final class __billreceiptexclusionpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptExclusionPersistence.jsp", 1709114078490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
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


	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
// Page Added by Rajesh V. To Persist all the Excluded Service 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

//	String params = request.getQueryString(); //checklist
//	String sqlCoverage = ""; //checklist
//	PreparedStatement pstmt = null; //checklist
//	ResultSet rst = null; //checklist
	String beanId = "BillReceiptExistOrderExclusion" ;
	String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
	BillReceiptExistOrderExclusion exclusionBean = null;

	try 
	{
		exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
		if(exclusionBean.getServiceExclusion() == null){
			exclusionBean.setServiceExclusion(new HashSet<String>());
		}
		
		if(exclusionBean.getInterExclusion() == null){
			exclusionBean.setInterExclusion(new HashSet<String>());
		}
		if(exclusionBean.getGroupExclusion() == null){
			exclusionBean.setGroupExclusion(new HashSet<String>());
		}
		if(exclusionBean.getLineExclusion() == null){
			exclusionBean.setLineExclusion(new HashSet<String>());
		}
		
		if(exclusionBean.getDiscountMap() == null){
			exclusionBean.setDiscountMap(new HashMap<String,BillReceiptExclusionDiscount>());
		}
		Set<String> serviceSet = exclusionBean.getServiceExclusion();
		Set<String> interSet = exclusionBean.getInterExclusion();
		Set<String> groupExclusion = exclusionBean.getGroupExclusion();
		Set<String> lineExclusion = exclusionBean.getLineExclusion();
		HashMap<String,BillReceiptExclusionDiscount> discountMap = exclusionBean.getDiscountMap();
		HashMap<String,BillReceiptExclusionDiscount> interDiscount = exclusionBean.getInterDiscount();
		
//		String facility_id = (String)session.getAttribute("facility_id");//checklist
		request.setCharacterEncoding("UTF-8");
		
//		String locale = (String)session.getAttribute("LOCALE");//checklist
		String func_mode = request.getParameter("func_mode");
//		String event = (request.getParameter("event") == null ? "" : request.getParameter("event")); //checklist
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
		if(func_mode!= null && "excludeService".equals(func_mode)){
			//String status = "";//checklist
			String blngServCode = "";
			String trxDocRef = "";
			String trxDocRefLineNum = "";
			//String trxDocRefSeqNum = ""; //checklist
			//String servGroupKey = (String)hash.get("servGroupKey");			//checklist
			BillReceiptExclusionDiscount discBean = null;
			if(serviceSet == null){
				serviceSet = new HashSet<String>();
			}
			if(interSet == null){
				interSet = new HashSet<String>();
			}
			serviceSet.addAll(interSet);
			/*String excludedUnChecked = checkForNull((String)hash.get("excludedUnChecked"));
			String[] excludedUnChkArr = excludedUnChecked.split("####");
			for(int l=0;l<excludedUnChkArr.length;l++){
				if(serviceSet.contains(excludedUnChkArr[l]))	serviceSet.remove(excludedUnChkArr[l]);
			}*/
			int totalService = 0;
			try{
				totalService = Integer.parseInt((String)hash.get("totalService"));
				
			}
			catch(Exception NE){
				totalService = 0;
			}
			String serviceComb = "";
			int maxPayer = Integer.parseInt((String)hash.get("maxPayer"));
			for(int i=0;i<totalService;i++){
				blngServCode = (String)hash.get("serv_grp_code"+i);
				trxDocRef = (String)hash.get("trxDocRef"+i);
				trxDocRefLineNum = (String)hash.get("trxDocRefLineNum"+i);
				//trxDocRefSeqNum = (String)hash.get("trxDocRefSeqNum"+i);
				serviceComb = blngServCode+":::"+trxDocRef+":::"+trxDocRefLineNum;
						System.err.println("serviceComb->"+serviceComb);
						System.err.println("Checked->"+(String)hash.get("serv_grp_chk"+i));
						//System.err.println("seq no->"+(String)hash.get("trxDocRefSeqNumC"+i));
				if("Y".equals((String)hash.get("serv_grp_chk"+i))){					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							
						}
						else{
							serviceSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						System.err.println("Added->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								
							}
							else{
								serviceSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
								System.err.println("Added->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}
				}
				else{					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							serviceSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
							System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(serviceSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								serviceSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
								System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}											
				}				
			}
			
			List<BillReceiptExclusionDiscount> exclDisc = new ArrayList<BillReceiptExclusionDiscount>();
			HashMap<String,BillReceiptExclusionDiscount> copyDiscMap = new HashMap<String,BillReceiptExclusionDiscount>();
			discountMap.putAll(interDiscount);			
			copyDiscMap.putAll(discountMap);
			discBean = null;
			for (Iterator iterator = serviceSet.iterator(); iterator.hasNext();) {
				String combo = (String) iterator.next();
				if(copyDiscMap.containsKey(combo)){
					copyDiscMap.remove(combo);
				}
				String[] comboArr = combo.split(":::");
				discBean = new BillReceiptExclusionDiscount();
				discBean.setBlngServCode(comboArr[0]);
				discBean.setTrxDocRef(comboArr[1]);
				discBean.setTrxDocRefLineNum(comboArr[2]);
				discBean.setTrxDocRefSeqNum(comboArr[3]);
				discBean.setDiscOrExcl("E");
				exclDisc.add(discBean);
			}
			
			discBean = null;
			for (Iterator iterator = copyDiscMap.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				if(copyDiscMap.containsKey(key)){
					discBean = (BillReceiptExclusionDiscount) copyDiscMap.get(key);
					exclDisc.add(discBean);
				}
			}
			exclusionBean.setExclDiscList(exclDisc);	
			exclusionBean.setDiscountMap(copyDiscMap);
			exclusionBean.setInterDiscount(new HashMap<String,BillReceiptExclusionDiscount>());
			/*if(serviceSet.isEmpty()){
				if(serviceMap.containsKey(servGroupKey)){
					serviceMap.remove(servGroupKey);
					status = "true";
				}
				else{
					status = "false";
				}
				
			}
			else{
				serviceMap.put(servGroupKey, serviceSet);
				status = "true";
			}
			out.println(status);*/
			
		}
		else if(func_mode!= null && "nextPrevExcluded".equals(func_mode)){
			//String status = ""; //checklist
			String blngServCode = "";
			String trxDocRef = "";
			String trxDocRefLineNum = "";
			//String trxDocRefSeqNum = "";//checklist
			//String servGroupKey = (String)hash.get("servGroupKey");		//checklist	

			if(interSet == null){
				interSet = new HashSet<String>();
			}

			int totalService = 0;
			try{
				totalService = Integer.parseInt((String)hash.get("totalService"));				
			}
			catch(Exception NE){
				totalService = 0;
			}
			String serviceComb = "";
			int maxPayer = Integer.parseInt((String)hash.get("maxPayer"));
			for(int i=0;i<totalService;i++){
				blngServCode = (String)hash.get("serv_grp_code"+i);
				trxDocRef = (String)hash.get("trxDocRef"+i);
				trxDocRefLineNum = (String)hash.get("trxDocRefLineNum"+i);
				//trxDocRefSeqNum = (String)hash.get("trxDocRefSeqNum"+i);
				serviceComb = blngServCode+":::"+trxDocRef+":::"+trxDocRefLineNum;
						System.err.println("serviceComb->"+serviceComb);
						System.err.println("Checked->"+(String)hash.get("serv_grp_chk"+i));
						System.err.println("seq no->"+(String)hash.get("trxDocRefSeqNumC"+i));
				if("Y".equals((String)hash.get("serv_grp_chk"+i))){					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							
						}
						else{
							interSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								
							}
							else{
								interSet.add(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
														System.err.println("Added->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}
				}
				else{					
					if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumC"+i)))){
						if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i))){
							interSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumC"+i));
						}
					}
					
					for(int m=1;m<=maxPayer;m++){
						if(!"".equals(checkForNull((String)hash.get("trxDocRefSeqNumP"+m+i)))){
							if(interSet.contains(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i))){
								interSet.remove(serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
						System.err.println("Removed->"+serviceComb+":::"+(String)hash.get("trxDocRefSeqNumP"+m+i));
							}
						}
					}											
				}				
			}		
		}
		else if(func_mode!= null && "checkServicesExcluded".equals(func_mode)){
		//	String status = "true";//checklist
			/*if(serviceMap.isEmpty()){
						= "false";
			}*/
		//	out.println(status);//checklist
		}
		else if(func_mode!= null && "excludeGroupAdd".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			groupExclusion.add(servGroup);
		}
		else if(func_mode!= null && "excludeLineAdd".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			String servLine = (String)hash.get("serv_line_code");
			lineExclusion.add(servGroup+"::::"+servLine);
		}
		else if(func_mode!= null && "excludeGroupRemove".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			groupExclusion.remove(servGroup);
		}
		else if(func_mode!= null && "excludeLineRemove".equals(func_mode)){
			String servGroup = (String)hash.get("serv_grp_code");
			String servLine = (String)hash.get("serv_line_code");
			lineExclusion.remove(servGroup+"::::"+servLine);
		}		
	}catch (Exception e) {	
		e.printStackTrace() ;
		System.err.println("Exception from BillReceiptExclusionPersistence.jsp:" + e);
	}
	finally
	{
		
	}
	putObjectInBean(beanId,exclusionBean,request);

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
