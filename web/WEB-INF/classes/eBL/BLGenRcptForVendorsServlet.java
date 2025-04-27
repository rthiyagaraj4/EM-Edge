package eBL;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;

import com.ehis.persist.PersistenceHelper;

import eCommon.Common.CommonAdapter;

/**
 * Servlet implementation class BLGenRcptForVendorsServlet
 */
public class BLGenRcptForVendorsServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; //commented checkstyle

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BLGenRcptForVendorsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached Servlet BLGenRcptForVendorsServlet");
		try {
			insertData(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertData(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		String bean_id = "bl_BLGenRcptForVendorsBean";
		String bean_name = "eBL.BLGenRcptForVendorsBean";
		BLGenRcptForVendorsBean bean = (BLGenRcptForVendorsBean) PersistenceHelper
				.getBeanObject(bean_id, bean_name, request);
		String errorLevel = "", errorCode = "", errorText = "";
		Connection con = null;
		CallableStatement cstmt = null;
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			con = ConnectionManager.getConnection(request);
			cstmt = con.prepareCall("{ call BL_GENERATE_RECPT_FOR_VENDORS.GET_VENDOR_RECEIPT_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			
			if(bean.getList().size() > 0) {
				List<BLGenRcptForVendorsBean> list = findDuplicatesInArrayList(bean.getList());
				bean.setList(list);
				for (int i = 0; i < bean.getList().size(); i++) {
					BLGenRcptForVendorsBean rcptBean = bean.getList().get(i);
					Date utilDate = format.parse((String) rcptBean.getPractoReceiptDate());
				    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					cstmt.setString(1, bean.getFacilityId());
					cstmt.setString(2, bean.getLanguageId());
					cstmt.setString(3, bean.getVendorType());
					cstmt.setString(4, rcptBean.getPatientId());
					cstmt.setString(5, "R");
					cstmt.setString(6, rcptBean.getPractoDocTypeCode());
					cstmt.setString(7, rcptBean.getPractoDocNo());
					cstmt.setDate(8, sqlDate);
					cstmt.setString(9, "AD");
					cstmt.setString(10, "5");
					cstmt.setString(11, rcptBean.getPractoReceiptAmount());
					cstmt.setString(12, bean.getStatus());
					cstmt.setString(13, bean.getLoginUser());
					cstmt.setString(14, bean.getLoginWsNo());
					cstmt.setString(15, rcptBean.getSlmtDocRefDesc());
					utilDate = format.parse((String) rcptBean.getSlmtDocRefDate());
				    sqlDate = new java.sql.Date(utilDate.getTime());
					cstmt.setDate(16, sqlDate);				
					cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmt.execute();
	
					errorLevel += CommonAdapter.checkForNull(cstmt.getString(17));
					errorCode += CommonAdapter.checkForNull(cstmt.getString(18));
					errorText += CommonAdapter.checkForNull(cstmt.getString(19));
					if (!"".equals(errorCode) || !"".equals(errorLevel) || !"".equals(errorText)) {
						break;
					}
				}
	
				/*if (!"".equals(errorCode) || !"".equals(errorLevel) || !"".equals(errorText)) {
					System.err.println("BLGenRcptForVendorsServlet.java->Error: "+errorLevel+", "+errorCode+", "+errorText);

					@SuppressWarnings("rawtypes")
					Hashtable messageHashtable=new Hashtable();
					messageHashtable = MessageManager.getMessage(bean.getLanguageId(), errorCode, "BL");
					String msg= (String)messageHashtable.get("message")+"<br>";
					
					con.rollback();
					
					if(null != errorCode && !"".equals(errorCode)) {
						response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("BL_GENERATE_RECPT_FOR_VENDORS.GET_VENDOR_RECEIPT_DTLS Returning Error - "+msg, "UTF-8"));
					} else if(null != errorText && !"".equals(errorText)) {
						response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("BL_GENERATE_RECPT_FOR_VENDORS.GET_VENDOR_RECEIPT_DTLS Returning Error - "+errorText, "UTF-8"));
					} else {
						response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("BL_GENERATE_RECPT_FOR_VENDORS.GET_VENDOR_RECEIPT_DTLS Returning Error", "UTF-8"));
					}
				} else {
					con.commit();
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-SM0070 Operation Completed Successfully ....", "UTF-8"));
				}*/
				con.commit();
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-SM0070 Operation Completed Successfully ....", "UTF-8"));
			} else {
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode("APP-BL0800 No Records Found to Generate Bill...", "UTF-8"));
			}

		} catch (Exception e) {
			System.err.println("Error in BLGenRcptForVendorsServlet: " + e);
			con.rollback();
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + e);
			e.printStackTrace();
		} finally {
			bean.clearBean();
			if(con != null) {
				ConnectionManager.returnConnection(con, request);
			} if(cstmt != null) {
				cstmt.close();
			}
		}
	}
	
	private List<BLGenRcptForVendorsBean> findDuplicatesInArrayList(List<BLGenRcptForVendorsBean> arrayList)
	{
		try {			
			for (int i = 0; i < arrayList.size(); i++) 
			{
				for (int j = i+1; j < arrayList.size(); j++) 
				{
					if(arrayList.get(i).getChkBoxName().equals(arrayList.get(j).getChkBoxName()))
					{
						arrayList.remove(j);
					}
				}
			}
			return arrayList;
		} catch(Exception ex) {
			System.out.println("Error in findDuplicatesInArrayList: "+ex);
			ex.printStackTrace();
			return null;
		}
	}
}
