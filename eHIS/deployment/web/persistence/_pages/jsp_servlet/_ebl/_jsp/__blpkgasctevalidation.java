package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Date;
import java.text.*;
import java.text.SimpleDateFormat;
import eBL.Common.BlRepository;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.PkgSubsBean;
import eBL.PkgEnterReceptRefundBean;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blpkgasctevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPkgAscteValidation.jsp", 1739259223260L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	String locale = (String) session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue("facility_id");
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();
	String calledFrom = request.getParameter("calledFrom");

	CallableStatement cstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		if (calledFrom.equals("AssociateSubscribedPackage")) {
			String functionId = request.getParameter("function_id");
			System.out.println("functionId " + functionId);
			String packageCode = request.getParameter("packageCode");
			String fromDate = request.getParameter("fromDate");
			String pkgPrice = "";
			String pkgvaliddays = "";
			String pkgpricefactor = "";
			String custdiscountind = "";
			String custdiscountamt = "";
			String strErrorLevel = "";
			String strErrorText = "";
			String strMessageId = "";
			String effToDate = "";

			cstmt = con
					.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI:SS'),?,?,?,?,?,?,?,?,?)}");  //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
			cstmt.setString(1, facilityId);
			cstmt.setString(2, packageCode);
			cstmt.setString(3, "");
			cstmt.setString(4, "");
			cstmt.setString(5, "");
			cstmt.setString(6, fromDate);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(15, java.sql.Types.VARCHAR); //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
			cstmt.execute();
			pkgPrice = cstmt.getString(7);
			pkgvaliddays = cstmt.getString(8);
			pkgpricefactor = cstmt.getString(9);
			custdiscountind = cstmt.getString(10);
			custdiscountamt = cstmt.getString(11);
			strErrorLevel = cstmt.getString(12);
			strMessageId = cstmt.getString(13);
			strErrorText = cstmt.getString(14);

			if (pkgPrice == null)
				pkgPrice = "0.00";
			if (pkgvaliddays == null)
				pkgvaliddays = "0";
			if (pkgpricefactor == null)
				pkgpricefactor = "1";
			if (custdiscountind == null)
				custdiscountind = "N";
			if (custdiscountamt == null)
				custdiscountamt = "0.00";

			if (strErrorLevel == null)
				strErrorLevel = "";
			if (strMessageId == null)
				strMessageId = "";
			if (strErrorText == null)
				strErrorText = "";

			JsonObject ob = new JsonObject();

			if (!(strMessageId.equals(""))
					|| !(strErrorLevel.equals(""))
					|| !(strErrorText.equals(""))) {
				System.out.println("if");
				ob.addProperty("success", "N");
				ob.addProperty("messageId", strMessageId);
				ob.addProperty("messageText", strErrorText);
				ob.addProperty("messageLevel", strErrorLevel);

			}

			else {
				System.out.println("else");
				ob.addProperty("success", "Y");
			}

			System.out.println("message Id / message / level "
					+ strMessageId + "/" + strErrorText + "/"
					+ strErrorLevel);

			String sql = "";

			System.out.println("fromDate " + fromDate.length());
			if (fromDate.length() > 16) {
				sql = "SELECT to_char(to_date(?,'dd/mm/yyyy HH24:MI:SS')+ ? - 1/86400,'dd/mm/yyyy HH24:MI:SS') toDate FROM DUAL";
			} else {
				sql = "SELECT to_char(to_date(?,'dd/mm/yyyy HH24:MI')+ ? - 1/86400,'dd/mm/yyyy HH24:MI') toDate FROM DUAL";
			}

			System.out.println("sql " + sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fromDate);
			pstmt.setInt(2, Integer.parseInt(pkgvaliddays));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				effToDate = rs.getString("toDate");

			}
			if (effToDate == null)
				effToDate = "";

			System.out.println("effto date" + effToDate);

			ob.addProperty("toDate", effToDate);
			out.println(ob);

		}

		//Added By Vijay For MMS-ICN-00015

		else if ("patientPayerValidation".equals(calledFrom)) {
			try {

				String outPutNewPkg = "";
				String outPutExPkg = "";
				String outputNewPkgTemp="";
				String outputExPkgTemp="";
				
				
				
				String payerCode = request.getParameter("payerCode");
				if (payerCode == null || "null".equals(payerCode)) payerCode = "";
				System.err.println("payerCode " + payerCode);
				
				String payerGrpCode = request.getParameter("payerGrpCode");
				if (payerGrpCode == null || "null".equals(payerGrpCode)) payerGrpCode = "";
				System.err.println("payerGrpCode " + payerGrpCode);
				
				String payerGrpCodeExistingPkg = request.getParameter("payerGrpCodeExistingPkg");
				if (payerGrpCodeExistingPkg == null || "null".equals(payerGrpCodeExistingPkg)) payerGrpCodeExistingPkg = "";
				
				System.err.println("payerGrpCodeExistingPkg "+ payerGrpCodeExistingPkg);
				
				String payerCodeExistingPkg = request.getParameter("payerCodeExistingPkg");
				if (payerCodeExistingPkg == null || "null".equals(payerCodeExistingPkg)) payerCodeExistingPkg = "";
				
				System.err.println("payerCodeExistingPkg "+payerCodeExistingPkg);
				
				String episodeId = request.getParameter("episodeId");
				System.err.println("episodeId " + episodeId);
				
				String visitId = request.getParameter("visitId");
				System.err.println("visitId " + visitId);
				
				JSONObject ob = new JSONObject();

				String sql = "SELECT 'Y' flag FROM bl_encounter_payer_priority WHERE operating_facility_id=? AND ((episode_type IN ('O','E') AND episode_id = ? AND visit_id = ?) OR (episode_type IN ('I','D') AND episode_id = ?)) "
						+ " AND cust_group_code = ? "
						+ " AND cust_code = ? "
						+ " AND cust_group_code IS NOT NULL "
						+ " AND cust_code IS NOT NULL "
						+ " AND ROWNUM = 1 ORDER BY policy_type_code, priority ";
				System.err.println("sql " + sql);

				String[] payerGrpSplit = payerGrpCode.split(",");
				String[] payerCodeSplit = payerCode.split(",");

				String[] payerGrpCodeExistingPkgSplit = payerGrpCodeExistingPkg
						.split(",");
				String[] payerCodeExistingPkgSplit = payerCodeExistingPkg
						.split(",");
				pstmt = con.prepareStatement(sql);

				if (payerGrpCode.length() > 1) {

					System.out.println("new Pkgs");
					pstmt.setString(1, facilityId);
					pstmt.setString(2, episodeId);
					pstmt.setString(3, visitId);
					pstmt.setString(4, episodeId);
					for (int i = 0; i < payerGrpSplit.length; i++) {
						pstmt.setString(5, payerGrpSplit[i]);//payerGrpSplit[i]);
							System.err.println("payerGrpSplit[i] "+payerGrpSplit[i]);
						if (payerCodeSplit.length > 0) {
							pstmt.setString(6, payerCodeSplit[i]);
							System.err.println("payerCodeSplit[i] "+payerCodeSplit[i]);
						} else {
							pstmt.setString(6, "");
						}

						rs = pstmt.executeQuery();
						if(rs!=null){
							outPutNewPkg+="N";
							
						while (rs.next()) {

							outPutNewPkg = rs.getString("flag");
							/* outPutNewPkg+=outPutNewPkg; */
							System.out.println("outPutNewPkg in loop "
							+ outPutNewPkg);


							outputNewPkgTemp+=outPutNewPkg;
							

							

						}
					
						outputNewPkgTemp+=outPutNewPkg;
						
						
						}
						
						System.err.println("outputNewPkgTemp outside rs "+outputNewPkgTemp);
						if (outputNewPkgTemp.contains("N")) {
							outPutNewPkg="N";
							break;
						}
						

					}
				}
				if (payerGrpCodeExistingPkg.length() > 0) {
					System.err.println("existing pkgs ");
					pstmt.setString(1, facilityId);
					pstmt.setString(2, episodeId);
					pstmt.setString(3, visitId);
					pstmt.setString(4, episodeId);

					for (int i = 0; i < payerGrpCodeExistingPkgSplit.length; i++) {
						pstmt.setString(5,
								payerGrpCodeExistingPkgSplit[i]);//payerGrpSplit[i]);
						System.out.println("payerGrpCodeExistingPkgSplit[i] "+payerGrpCodeExistingPkgSplit[i]);
						if (payerCodeExistingPkgSplit.length > 0) {
							pstmt.setString(6,
									payerCodeExistingPkgSplit[i]);
							System.out.println("payerCodeExistingPkgSplit[i] "+payerCodeExistingPkgSplit[i]);

						} else {
							pstmt.setString(6, "");

						}
						rs = pstmt.executeQuery();
						if(rs!=null){
							outPutExPkg="N";
						while (rs.next()) {
							outPutExPkg = rs.getString("flag");
							outputExPkgTemp+=outPutExPkg;
							System.out.println("outPutExPkg " + outPutExPkg);
							System.out.println("outputExPkgTemp " + outputExPkgTemp);
								
						
						}
						
						outputExPkgTemp+=outPutExPkg;
						}
										
					System.out.println("outputExPkgTemp "+outputExPkgTemp);
					if (outputExPkgTemp.contains("N")) {
						outPutExPkg="N";
						break;
					}
						
					}
				}
				System.out.println("outPutExPkg final "+outPutExPkg);
				System.out.println("outPutNewPkg final "+outPutNewPkg);

				if (outPutNewPkg.equals("N") || outPutExPkg.equals("N")) {
					ob.put("flag", "N");
				} else {
					ob.put("flag", "Y");
				}
				out.print(ob);
				out.flush();

			} catch (Exception e) {

				e.printStackTrace();
				System.err
						.println("Exception in BLPkgAscteValidation(patientPayerValidation) "
								+ e);

			}

		}

		// -- Ends Here --

	} catch (Exception e) {
		System.err.println("Exception in BLPkgAscteValidation " + e);
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
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
