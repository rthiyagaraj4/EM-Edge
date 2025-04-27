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

public final class __blinsrcmpayerspecclaimsplittingpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLInsRCMPayerSpecClaimSplittingPersistence.jsp", 1725509317991L ,"10.3.6.0","Asia/Calcutta")) return true;
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

public String checkForNull(String inp) {
		return (inp == null) ? "" : inp;
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

	String params = request.getQueryString();
	String beanId = "bl_ClaimSplittingBean";
	String beanName = "eBL.ClaimSplittingBean";
	ClaimSplittingBean fmtDtlsBean = null;
	List<ClaimSplittingBean> documents = null;
	ClaimSplittingBean docBean = (ClaimSplittingBean) getBeanObject(beanId, beanName, request);

	Connection con = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	if (docBean.getClaimTypeList() == null) {
		docBean.setClaimTypeList(new ArrayList<ClaimSplittingBean>());
	}

	Connection connection = null;
	try {
		connection = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");

		String locale = (String) session.getAttribute("LOCALE");
		String facility_id = (String) session.getAttribute("facility_id");

		String func_mode = request.getParameter("func_mode");

		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		String mode = (String) hash.get("mode");

		if (func_mode != null && func_mode.equals("addClaimTypes")) {
			boolean flag = false;
			int total = Integer.parseInt((String) hash.get("typeRowCount"));
			System.err.println("total->>>>>>>>>>>>>>>>>>>>>>" + total);
			String claimTypeCode = "", claimTypeDesc = "", cName = "", all = "N", appl_ip = "N", appl_op = "N",
					appl_dc = "N", appl_em = "N", dfltClaimType = "N", dfltSubgroup = "", dfltSubgroupCode = "";
			ClaimSplittingBean cBean = new ClaimSplittingBean();
			ClaimSplittingBean cListBean = new ClaimSplittingBean();
			ArrayList<ClaimSplittingBean> cList = new ArrayList<ClaimSplittingBean>();
			HashMap<String, ArrayList<ClaimSplittingBean>> cMap = docBean.getClassificationList();
			ArrayList<ClaimSplittingBean> cMapList = new ArrayList<ClaimSplittingBean>();
			int idx = 1;
			for (int i = 1; i < total; i++) {
				while (hash.get("claimTypeCode_" + idx) == null) {
					idx++;
				}
				cBean = new ClaimSplittingBean();
				claimTypeCode = (String) hash.get("claimTypeCode_" + idx);
				claimTypeDesc = (String) hash.get("claimTypeDesc_" + idx);
				cName = (String) hash.get("cName_" + idx);
				all = (String) hash.get("all_" + idx);
				System.err.println("all----->" + all);
				appl_ip = (String) hash.get("appl_ip_" + idx);
				appl_op = (String) hash.get("appl_op_" + idx);
				appl_dc = (String) hash.get("appl_dc_" + idx);
				appl_em = (String) hash.get("appl_em_" + idx);
				dfltClaimType = (String) hash.get("dfltClaimType_" + idx);
				dfltSubgroupCode = (String) hash.get("dfltSubgroupCode_" + idx);
				dfltSubgroup = (String) hash.get("dfltSubgroup_" + idx);

				cBean.setClaimTypeCode(claimTypeCode);
				cBean.setClaimTypeDesc(claimTypeDesc);
				cBean.setEpisodeAll(all);
				cBean.setEpisodeIP(appl_ip);
				cBean.setEpisodeOP(appl_op);
				cBean.setEpisodeDC(appl_dc);
				cBean.setEpisodeER(appl_em);
				cBean.setDefClaimType(dfltClaimType);
				cBean.setDefSubGroupCode(dfltSubgroupCode);
				cBean.setDefSubGroupDesc(dfltSubgroup);
				cBean.setClassificationName(cName);
				if (cMap.containsKey(cName)) {
					System.err.println("here->>>>>>>>>>>>>>>>>>>>>>" + cName);
					cMapList = cMap.get(cName);
					for (int j = 0; j < cMapList.size(); j++) {
						cMapList.get(j).setEpisodeAll(all);
						cMapList.get(j).setEpisodeIP(appl_ip);
						cMapList.get(j).setEpisodeOP(appl_op);
						cMapList.get(j).setEpisodeDC(appl_dc);
						cMapList.get(j).setEpisodeER(appl_em);
						cMapList.get(j).setClaimTypeCode(claimTypeCode);
					}
				}
				docBean.getClassificationList().put(cName, cMapList);
				cList.add(cBean);
				idx++;

			}
			docBean.setClaimTypeList(cList);
			System.err.println("Size of claimTypeList=" + docBean.getClaimTypeList().size());
			System.err.println("Size of classifcationList=" + docBean.getClassificationList().size());

		} else if (func_mode != null && func_mode.equals("validateAndUpdateService")) {
			String sName = (String) hash.get("sName");
			int total = Integer.parseInt((String) hash.get("serviceRowCount"));
			System.err.println("total->>>>>>>>>>>>>>>>>>>>>>" + total);
			System.err.println("sName->>>>>>>>>>>>>>>>>>>>>>" + sName);

			ClaimSplittingBean cBean = new ClaimSplittingBean();
			ArrayList<ClaimSplittingBean> cList = new ArrayList<ClaimSplittingBean>();
			if ((total - 1) != 0) {
				if (docBean.getClassificationList().containsKey(sName)) {
					String claimTypeCode = request.getParameter("claimType");
					String all = request.getParameter("all");
					String ip = request.getParameter("appl_ip");
					String op = request.getParameter("appl_op");
					String dc = request.getParameter("appl_dc");
					String em = request.getParameter("appl_em");
					System.err.println("claimType->>>>>>>>>>>>>>>>>>>>>>" + claimTypeCode);
					System.err.println("all->>>>>>>>>>>>>>>>>>>>>>" + all);
					System.err.println("ip->>>>>>>>>>>>>>>>>>>>>>" + ip);
					System.err.println("op->>>>>>>>>>>>>>>>>>>>>>" + op);
					System.err.println("dc->>>>>>>>>>>>>>>>>>>>>>" + dc);
					System.err.println("em->>>>>>>>>>>>>>>>>>>>>>" + em);
					int idx = 1;
					for (int i = 1; i < total; i++) {
						while (hash.get("bg_code_" + idx) == null) {
							idx++;
						}
						cBean = new ClaimSplittingBean();
						cBean.setClaimTypeCode(claimTypeCode);
						cBean.setEpisodeAll(all);
						cBean.setEpisodeIP(ip);
						cBean.setEpisodeOP(op);
						cBean.setEpisodeDC(dc);
						cBean.setEpisodeER(em);
						cBean.setClassificationName(sName);
						cBean.setBlngServCode((String) hash.get("bg_code_" + idx));
						cBean.setBlngServDesc((String) hash.get("bg_desc_" + idx));
						cBean.setClaimSubgroup((String) hash.get("claimSubgroupCode_" + idx));
						cBean.setClaimSubgroupDesc((String) hash.get("claimSubgroup_" + idx));
						cBean.setClassType((String) hash.get("classType_" + idx));
						cList.add(cBean);
						idx++;
					}
					System.err.println("im from validateAndUpdateService cList>>>" + cList.size());
					docBean.getClassificationList().put(sName, cList);
					System.err.println("docBean>>>" + docBean.getClassificationList().get(sName).size());
					System.err.println("docBean>>>" + sName);
				}

			}

		} else if (func_mode != null && func_mode.equals("InfoFrame")) {
			System.out.println("here in info frame -------------------------> claim Spliting ");

			String payerGroupCode = (String) hash.get("payerGroupCode");
			String payerCode = (String) hash.get("payerCode");
			String policyCode = (String) hash.get("policyCode");

			String active = (String) hash.get("active");
			String splitByAuth = (String) hash.get("splitByAuth");
			String claimResub = (String) hash.get("claimResub");
			//String submitRecs = (String) hash.get("submitRecs");

			docBean.setPayerGroupCode(payerGroupCode);
			docBean.setPayerCode(payerCode);
			docBean.setPolicyTypeCode(policyCode);
			if (active.equals("Y")) {
				docBean.setActive("E");
			} else {
				docBean.setActive("D");
			}

			docBean.setSplitByAuth(splitByAuth);
			docBean.setClaimResub(claimResub);
			//docBean.setSubRecs(submitRecs);

			System.err.println("Assigned InfoFrame Header values for setup");

		} else if (func_mode != null && func_mode.equals("validateServicePersistance")) {
			boolean flag = false;
			String cName = request.getParameter("cName");
			String servCode = request.getParameter("servCode");
			if (docBean.getClassificationList().size() > 0) {

				System.err.println("------------------------------------------------");
				outerLoop: for (Map.Entry<String, ArrayList<ClaimSplittingBean>> entry : docBean
						.getClassificationList().entrySet()) {
					List<ClaimSplittingBean> l = entry.getValue();
					for (int i = 0; i < l.size(); i++) {
						if (l.get(i).getBlngServCode().equals(servCode)) {
							out.println("Y");
							flag = true;
							break outerLoop;
						}
					}

				}

			}
			if (!flag) {
				out.println("N");

			}

		} else if (func_mode != null && func_mode.equals("deleteClaimType")) {

			String cName = request.getParameter("cName");
			if (!cName.equals("")) {
				System.err.println("size->>>>>>>>>>>>>>" + docBean.getClassificationList().size());
				docBean.getClassificationList().remove(cName);
				System.err.println("size->>>>>>>>>>>>>>" + docBean.getClassificationList().size());
			}

		} else if (func_mode != null && func_mode.equals("deleteServiceRow")) {

			String cName = request.getParameter("cName");
			String blngServCode = request.getParameter("blngServCode");
			if (!cName.equals("")) {
				System.err.println("blng list before size->>>>>>>>>>>>>>" + blngServCode);
				System.err.println("classification list before size->>>>>>>>>>>>>>"
						+ docBean.getClassificationList().get(cName).size());
				for (int i = 0; i < docBean.getClassificationList().get(cName).size(); i++) {
					System.err.println("blngServ---------->"
							+ docBean.getClassificationList().get(cName).get(i).getBlngServCode());
					if (docBean.getClassificationList().get(cName).get(i).getBlngServCode()
							.equals(blngServCode)) {
						docBean.getClassificationList().get(cName).remove(i);
						System.err.println("Service Row deletedddddd");
					}
				}

				System.err.println("classification list size->>>>>>>>>>>>>>"
						+ docBean.getClassificationList().get(cName).size());
			}

		} else if (func_mode != null && func_mode.equals("addServiceRowPersist")) {
			ArrayList<ClaimSplittingBean> cList = new ArrayList<ClaimSplittingBean>();
			ClaimSplittingBean cBean = null;
			int count = Integer.parseInt((String) hash.get("serviceRowCount"));

			String sName = (String) hash.get("sName");
			String[] parts = sName.split("-");
			String ip = "N", op = "N", dc = "N", em = "N", all = "N";
			String claimType = parts[0];
			for (int i = 1; i < parts.length; i++) {
				if (parts[i].equals("All")) {
					ip = "Y";
					op = "Y";
					dc = "Y";
					em = "Y";
					all = "Y";
					break;
				} else {
					if (parts[i].equals("IP"))
						ip = "Y";
					else if (parts[i].equals("OP"))
						op = "Y";
					else if (parts[i].equals("DC"))
						dc = "Y";
					else if (parts[i].equals("EM"))
						em = "Y";
				}
			}
			int idx = 1;
			for (int i = 1; i < count; i++) {
				while (hash.get("bg_code_" + idx) == null) {
					idx++;
				}
				System.err.println((String) hash.get("bg_code_" + idx));
				cBean = new ClaimSplittingBean();
				cBean.setBlngServCode((String) hash.get("bg_code_" + idx));
				cBean.setBlngServDesc((String) hash.get("bg_desc_" + idx));
				cBean.setClaimSubgroupDesc((String) hash.get("claimSubgroup_" + idx));
				cBean.setClaimSubgroup((String) hash.get("claimSubgroupCode_" + idx));
				cBean.setClassType((String) hash.get("classType_" + idx));
				cBean.setClaimTypeCode(claimType);
				cBean.setEpisodeIP(ip);
				cBean.setEpisodeOP(op);
				cBean.setEpisodeDC(dc);
				cBean.setEpisodeER(em);
				cBean.setEpisodeAll(all);
				cBean.setClassificationName(sName);
				cList.add(cBean);
				idx++;

			}
			System.err.println("cList>>>" + cList.size());
			docBean.getClassificationList().put(sName, cList);
			System.err.println("docBean>>>" + docBean.getClassificationList().get(sName).size());

		}

	} catch (Exception e) {
		e.printStackTrace();

	} finally {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (connection != null)
			ConnectionManager.returnConnection(connection);

	}
	putObjectInBean("bl_ClaimSplittingBean", docBean, request);

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
