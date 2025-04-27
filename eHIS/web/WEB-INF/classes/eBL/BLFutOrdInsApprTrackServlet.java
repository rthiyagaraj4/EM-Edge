package eBL;

import java.text.SimpleDateFormat;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import eBL.Common.*;
import eCommon.XSSRequestWrapper; //V220324

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class BLFutOrdInsApprTrackServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; // commented against V210416.
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	BLFutOrdInsApprTrackBean outPatBean = null;
	String sql = "";
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String locale = "";
	Locale loc = null;
	ResourceBundle rb = null;
	ResourceBundle rb1 = null;
	ResourceBundle rb2 = null;

	String payerRefCode  = ""; //V211027
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLFutOrdInsApprTrackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	private String checkForNull(String inputString) {
 		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
 	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("Inside doPost method");
		con = ConnectionManager.getConnection(request);
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		try{
			System.err.println("Inside doPost method1");
			session = request.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			System.err.println("Inside doPost method2");
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			rb2 = ResourceBundle.getBundle("eBL.resources.MessagesExtOne",loc);
			System.err.println("Inside doPost method2:"+request.getQueryString());
			
			HashMap returnMap = new HashMap();
			System.err.println("Inside doPost method3");
			String beanId = "bl_BLFutOrdInsApprTrackBean";
			String beanName = "eBL.BLFutOrdInsApprTrackBean";
			
			String p_action_id = request.getParameter("p_action_id");
			String p_facility_id = request.getParameter("p_facility_id");			
			String p_patient_id = request.getParameter("p_patient_id");
			String p_episode_type = request.getParameter("p_episode_type");
			String p_encounter_id = request.getParameter("p_encounter_id");
			String p_speciality_code = request.getParameter("p_speciality_code");
			String p_payer_grp_code = request.getParameter("p_payer_grp_code");
			String p_payer_code = request.getParameter("p_payer_code");
			String p_policy_type_code = request.getParameter("p_policy_type_code");
			String p_enc_frm_date = request.getParameter("p_enc_frm_date");
			String p_enc_to_date = request.getParameter("p_enc_to_date");
			String p_blng_grp_id = request.getParameter("p_blng_grp_id");			
			String p_serv_grp_code = request.getParameter("p_serv_grp_code");
			String p_serv_class_code = request.getParameter("p_serv_class_code");
			String p_order_line_status = request.getParameter("p_order_line_status");			
			String p_coding_status = request.getParameter("p_coding_status");			
			String p_ins_status = request.getParameter("p_ins_status");
			
			String queryString = "&p_action_id="+p_action_id+"&p_facility_id="+p_facility_id+"&p_patient_id="+p_patient_id+"&p_episode_type="+p_episode_type+"&p_encounter_id="+p_encounter_id+"&p_speciality_code="+p_speciality_code+"&p_payer_grp_code="+p_payer_grp_code+"&p_payer_code="+p_payer_code+"&p_policy_type_code="+p_policy_type_code+"&p_blng_grp_id="+p_blng_grp_id+"&p_serv_grp_code="+p_serv_grp_code+"&p_serv_class_code="+p_serv_class_code+"&p_order_line_status="+p_order_line_status+"&p_coding_status="+p_coding_status+"&p_ins_status="+p_ins_status+"&p_enc_frm_date="+p_enc_frm_date+"&p_enc_to_date="+p_enc_to_date;
			
			System.err.println("Inside doPost method4:"+queryString);			
			
			BLFutOrdInsApprTrackBean policyBean = (BLFutOrdInsApprTrackBean)PersistenceHelper.getBeanObject(beanId, beanName, request);	
			
			System.err.println("Inside doPost method5");
			
			if("E".equals(p_action_id)){
				exportData(request,response);
			}
			else{			
				try{
					System.err.println("Inside doPost method6");
					HashMap<String, List<BLFutOrdInsApprTrackBean>> futOrdInsMap  = policyBean.getPolicyMap();
					futOrdInsMap.get("BLFutOrdInsApprTrackInfo");
					if(!futOrdInsMap.isEmpty()){
						returnMap=updateFutOrdApprTrackInfo(request,response,policyBean);
					}else{
						returnMap.put("status", true);
					}
					
					System.err.println("Returned map:"+returnMap);
					
				}catch(Exception ex){
					System.err.println("Exception here is : "+ex);
				}
			   
				System.err.println("Returned map:");
				
				if (((Boolean) returnMap.get("status")).booleanValue())   //V230210
				{
					con.commit();
				}
				else 
				{
					con.rollback();				
				}	
				
				String error_msg = "";
				String mapValue = "";
				String error = "";
				int err_val = 1;
				for (Iterator iterator = returnMap.keySet().iterator(); iterator.hasNext();) {
					String type = (String) iterator.next();
					if(!("status".equals(type))){
						mapValue = (String) returnMap.get(type);
						if(mapValue != null){
								error = error+mapValue+"<br/>";
								err_val = 2;		
						}
					}				
				}
				
				if(error.length()==0){    
					try{
						error = rb1.getString("RECORD_INSERTED");
					}
					catch(Exception rbException){
						rbException.printStackTrace();
						System.err.println("Exceprion in RB ->"+rbException);
						error = "APP-SM0070 Operation Completed Successfully ....";					
					}
				}
				else{
					error_msg = "Record not saved";
					if(error.length()!=0)
						error_msg = error_msg + "<br/>"+error;    
					error = error_msg;
				}
				
				/* if (((Boolean) returnMap.get("status")).booleanValue()){
					if("B".equals(p_action_id))
						exportData(request,response);
				} */
				
				System.err.println("error is: "+error);
				response.sendRedirect("../eBL/jsp/BLFutOrdInsApprTrackError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val+queryString);
			}
		}
		catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
	}
	
	private HashMap updateFutOrdApprTrackInfo(HttpServletRequest request,
			HttpServletResponse response, BLFutOrdInsApprTrackBean policyBean) {
				System.err.println("Inside drug category details function");
		HashMap returnMap = new HashMap();
		//HashMap returnPopup = new HashMap();
		boolean insertable = false;		
		String operating_facility_id="";
		String primary_key_module_id="";
		String primary_key_main="";
		String primary_key_line_no="";
		String serv_item_code="";
		String blng_serv_code="";
        String appr_info_to_pat_yn="";
        String appr_info_by_id="";
        String appr_info_date="";
        String appr_start_date="";
        String appr_expire_date="";
        String service_perform_date="";
        String service_status="";
        String service_remarks="";
        String follow_up_visit_appt_yn="";
        String appt_date_time="";
        String follow_up_vist_adm="";
        
		try{
			HashMap<String,List<BLFutOrdInsApprTrackBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<BLFutOrdInsApprTrackBean> inclList = null; 
			
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ; //V221004
			facilityId = (String) session.getValue( "facility_id" ) ;  //V221004
			client_ip_address = this.p.getProperty("client_ip_address"); //V221004
			login_user = this.p.getProperty( "login_user" ) ; //V221004
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			if(!(policyMap == null || policyMap.isEmpty())){
				inclList = policyMap.get("BLFutOrdInsApprTrackInfo");  //V221004
				System.err.println("Policy map is called..");
				System.err.println("inclList contains:"+inclList);
				if(inclList == null){
					inclList = new ArrayList<BLFutOrdInsApprTrackBean>();
					outPatBean = new BLFutOrdInsApprTrackBean();
					inclList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<BLFutOrdInsApprTrackBean>>();
				inclList = new ArrayList<BLFutOrdInsApprTrackBean>();
				outPatBean = new BLFutOrdInsApprTrackBean();
				inclList.add(outPatBean);		
			}
			
			for(BLFutOrdInsApprTrackBean outPatBean : inclList)
			{
				operating_facility_id = outPatBean.getOperating_facility_id();
				primary_key_module_id = outPatBean.getPrimary_key_module_id();
				primary_key_main = outPatBean.getPrimary_key_main();
				primary_key_line_no = outPatBean.getPrimary_key_line_no();
				serv_item_code = outPatBean.getServ_item_code();
				blng_serv_code = outPatBean.getBlng_serv_code();
				
				appr_info_to_pat_yn=outPatBean.getAppr_info_to_pat_yn();
			    appr_info_by_id=outPatBean.getAppr_info_by_id();
			    appr_info_date=outPatBean.getAppr_info_date();
			    appr_start_date=outPatBean.getAppr_start_date();
			    appr_expire_date=outPatBean.getAppr_expire_date();
			    service_perform_date=outPatBean.getService_perform_date();
			    service_status=outPatBean.getService_status();
			    service_remarks=outPatBean.getService_remarks();
			    follow_up_visit_appt_yn=outPatBean.getFollow_up_visit_appt_yn();
			    appt_date_time=outPatBean.getAppt_date_time();
			    follow_up_vist_adm=outPatBean.getFollow_up_vist_adm();
				
				int col_count = 0;
			    
			    sql = "UPDATE BL_FUTURE_ORD_INS_APPR_TRK  SET  ";
			    if(!"".equals(appr_info_to_pat_yn)){
					col_count = 1;
			    	sql = sql + " APPR_INFO_TO_PAT_YN = nvl(?,APPR_INFO_TO_PAT_YN) ";
			    }
				
				if(!"".equals(appr_info_by_id)){
					if(col_count == 1)
						sql = sql + " ,APPR_INFO_BY_ID = nvl(?,APPR_INFO_BY_ID) ";
					else
						sql = sql + " APPR_INFO_BY_ID = nvl(?,APPR_INFO_BY_ID) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(appr_info_date)){
					if(col_count == 1)
						sql = sql + " ,APPR_INFO_DATE = nvl(to_date(?,'dd/mm/yyyy'),APPR_INFO_DATE) ";
					else
						sql = sql + " APPR_INFO_DATE = nvl(to_date(?,'dd/mm/yyyy'),APPR_INFO_DATE) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(appr_start_date)){
					if(col_count == 1)
						sql = sql + " ,APPR_START_DATE = nvl(to_date(?,'dd/mm/yyyy'),APPR_START_DATE) ";
					else
						sql = sql + " APPR_START_DATE = nvl(to_date(?,'dd/mm/yyyy'),APPR_START_DATE) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(appr_expire_date)){
					if(col_count == 1)
						sql = sql + " ,APPR_EXPIRE_DATE = nvl(to_date(?,'dd/mm/yyyy'),APPR_EXPIRE_DATE) ";
					else
						sql = sql + " APPR_EXPIRE_DATE = nvl(to_date(?,'dd/mm/yyyy'),APPR_EXPIRE_DATE) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(service_perform_date)){
					if(col_count == 1)
						sql = sql + " ,SERVICE_PERFORM_DATE = nvl(to_date(?,'dd/mm/yyyy'),SERVICE_PERFORM_DATE) ";
					else
						sql = sql + " SERVICE_PERFORM_DATE = nvl(to_date(?,'dd/mm/yyyy'),SERVICE_PERFORM_DATE) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(service_status)){
					if(col_count == 1)
						sql = sql + " ,SERVICE_STATUS = nvl(?,SERVICE_STATUS) ";
					else
						sql = sql + " SERVICE_STATUS = nvl(?,SERVICE_STATUS) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(service_remarks)){
					if(col_count == 1)
						sql = sql + " ,SERVICE_REMARKS = nvl(?,SERVICE_REMARKS) ";
					else
						sql = sql + " SERVICE_REMARKS = nvl(?,SERVICE_REMARKS) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(follow_up_visit_appt_yn)){
					if(col_count == 1)
						sql = sql + " ,FOLLOW_UP_VISIT_APPT_YN = nvl(?,FOLLOW_UP_VISIT_APPT_YN) ";
					else
						sql = sql + " FOLLOW_UP_VISIT_APPT_YN = nvl(?,FOLLOW_UP_VISIT_APPT_YN) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(appt_date_time)){
					if(col_count == 1)
						sql = sql + " ,APPT_DATE_TIME = nvl(to_date(?,'dd/mm/yyyy'),APPT_DATE_TIME) ";
					else
						sql = sql + " APPT_DATE_TIME = nvl(to_date(?,'dd/mm/yyyy'),APPT_DATE_TIME) ";
					
					col_count = 1;					
			    }
				
				if(!"".equals(follow_up_vist_adm)){
					if(col_count == 1)
						sql = sql + " ,FOLLOW_UP_VIST_ADM = nvl(?,FOLLOW_UP_VIST_ADM) ";
					else
						sql = sql + " FOLLOW_UP_VIST_ADM = nvl(?,FOLLOW_UP_VIST_ADM) ";
			    }
				
				sql=sql+" WHERE OPERATING_FACILITY_ID = ? and "+
					  " PRIMARY_KEY_MODULE_ID = ? and "+
					  " PRIMARY_KEY_MAIN = ? and "+
					  " PRIMARY_KEY_LINE_NO = ? and "+
					  " SERV_ITEM_CODE = ? and "+
					  " BLNG_SERV_CODE = ? ";
			    System.err.println(" Final update sql:"+sql);
			    pstmt = con.prepareStatement(sql);
			    
			    int i=1;
			    if(!"".equals(appr_info_to_pat_yn)){
					System.err.println(" Final update sql1:"+appr_info_to_pat_yn);
			    	 pstmt.setString(i,appr_info_to_pat_yn);
			    	 i++;
			    }if(!"".equals(appr_info_by_id)){
					System.err.println(" Final update sql2:"+appr_info_by_id);
			    	 pstmt.setString(i,appr_info_by_id);
			    	 i++;
			    }if(!"".equals(appr_info_date)){
					System.err.println(" Final update sql3:"+appr_info_date);
			    	 pstmt.setString(i,appr_info_date);
			    	 i++;
			    }if(!"".equals(appr_start_date)){
					System.err.println(" Final update sql4:"+appr_start_date);
			    	 pstmt.setString(i,appr_start_date);
			    	 i++;
			    }if(!"".equals(appr_expire_date)){
					System.err.println(" Final update sql5:"+appr_expire_date);
			    	 pstmt.setString(i,appr_expire_date);
			    	 i++;
			    }if(!"".equals(service_perform_date)){
					System.err.println(" Final update sql6:"+service_perform_date);
			    	 pstmt.setString(i,service_perform_date);
			    	 i++;
			    }if(!"".equals(service_status)){
					System.err.println(" Final update sql7:"+service_status);
			    	 pstmt.setString(i,service_status);
			    	 i++;
			    }if(!"".equals(service_remarks)){
					System.err.println(" Final update sql8:"+service_remarks);
			    	 pstmt.setString(i,service_remarks);
			    	 i++;
			    }if(!"".equals(follow_up_visit_appt_yn)){
					System.err.println(" Final update sql9:"+follow_up_visit_appt_yn);
			    	 pstmt.setString(i,follow_up_visit_appt_yn);
			    	 i++;
			    }if(!"".equals(appt_date_time)){
					System.err.println(" Final update sql10:"+appt_date_time);
			    	 pstmt.setString(i,appt_date_time);
			    	 i++;
			    }if(!"".equals(follow_up_vist_adm)){
					System.err.println(" Final update sql11:"+follow_up_vist_adm);
			    	 pstmt.setString(i,follow_up_vist_adm);
			    	 i++;
			    }
				
				System.err.println(" Final update sql:"+operating_facility_id);
				System.err.println(" Final update sql:"+primary_key_module_id);
				System.err.println(" Final update sql:"+primary_key_main);
				System.err.println(" Final update sql:"+primary_key_line_no);
				System.err.println(" Final update sql:"+serv_item_code);
				System.err.println(" Final update sql:"+blng_serv_code);
			    
			    pstmt.setString(i++,operating_facility_id);
			    pstmt.setString(i++,primary_key_module_id);
			    pstmt.setString(i++,primary_key_main);
			    pstmt.setString(i++,primary_key_line_no);
			    pstmt.setString(i++,serv_item_code);
			    pstmt.setString(i++,blng_serv_code);
			    
			    pstmt.executeUpdate();
				if(pstmt != null)    pstmt.close();
				insertable = true;
			
				System.err.println("Value of execute query is: "+insertable);
			}			
		}
		catch(Exception e){
			
			e.printStackTrace();
			System.err.println("Exception is "+e);
			insertable = false;
			returnMap.put("internalError", "Internal Error");
		}
		finally{
			
			System.err.println("Value of insertable is: "+insertable);
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}

	@SuppressWarnings("deprecation")
	private void exportData(HttpServletRequest request,	HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		java.util.Properties p = null;
		HttpSession session = null;

		Connection conn=null;
		String facilityId		= "";
		String locale			= "";
		CallableStatement callStmt = null;

		String reportId 		= "BLRFORD";
		String moduleId 		= "BL";
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;		
		
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc");
		facilityId = (String) session.getValue("facility_id");
		conn = ConnectionManager.getConnection(request);
		locale = p.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		//java.util.Locale loc = new java.util.Locale(locale);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());       
		 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "inline");
		response.setHeader("Content-Disposition","attachment;filename="+reportId+"-"+timestamp+".csv");
			
		
		try {
				
			java.util.Date dNow = new java.util.Date();
			java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"); 
			String repGenDateTime		= ft.format(dNow);			
						
			String repHdr		= "";
			String repRes		= "";
			String repCellWidth	= "";
			String repQuery		= "";
			String repQuery1		= "";
			String argumentList	= "";
			
			pstmt = conn.prepareStatement("select REP_COL_HDR,REP_COL_RES,REP_COL_WIDTH,REP_QUERY,REP_QUERY1,REP_ARGS from SM_REP_EXL_EXPORT where REPORT_ID = '"+reportId+"' ");
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				repHdr	= checkForNull(rs.getString("REP_COL_HDR"));//Header 
				repRes	= checkForNull(rs.getString("REP_COL_RES"));//Result Columns
				repCellWidth	= checkForNull(rs.getString("REP_COL_WIDTH"));//Cell Width
				repQuery	= checkForNull(rs.getString("REP_QUERY"));//Query
				repQuery1	= checkForNull(rs.getString("REP_QUERY1"));//Query
				argumentList	= checkForNull(rs.getString("REP_ARGS"));//Arguments
			}

			repQuery	= repQuery + " "+ repQuery1;

			if(pstmt != null)    pstmt.close();
			if(rs != null)    rs.close();
			
			ArrayList<String> resColumnsArr = new ArrayList<String>();
			ArrayList<String> resColumnsWidthArr = new ArrayList<String>();
			StringTokenizer resultTokens=new StringTokenizer(repRes,",");
			StringTokenizer repCellWidthTokens=new StringTokenizer(repCellWidth,",");
			
			while(resultTokens.hasMoreTokens() && repCellWidthTokens.hasMoreTokens()){
				String resCol	= resultTokens.nextToken();
				String resColWidth	= repCellWidthTokens.nextToken();
				resColumnsArr.add(resCol);
				resColumnsWidthArr.add(resColWidth);
			}		
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(reportId);

			String hdrSql =  "{call get_header_dtls(?,?,?,?,?,?,?,?)}";
			callStmt = conn.prepareCall(hdrSql);
			callStmt.setString(1, moduleId);
			callStmt.setString(2, reportId);
			callStmt.setString(3, facilityId);
			callStmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			callStmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			callStmt.setString(8, locale);
			String reportName 		= "";
			String reportExecName 	= "";
			String facilityName 	= "";
			String siteName 		= "";

			try{
				callStmt.execute();
				reportName 		= callStmt.getString(4);
				reportExecName 	= callStmt.getString(5);
				facilityName 	= callStmt.getString(6);
				siteName 		= callStmt.getString(7);
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{
				callStmt.close();
			}
			int i=1;
			int rowCount =1;
			HSSFRow row = null;
			
			
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short)12);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFont(font);

			HSSFCellStyle style1=workbook.createCellStyle();
			style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);


			Region cellRegion1 = new Region(1, (short)3, 1, (short)4); 
			Region cellRegion2 = new Region(2, (short)3, 2, (short)4); 
			Region cellRegion3 = new Region(3, (short)3, 3, (short)4); 
			sheet.addMergedRegion(cellRegion1);
			sheet.addMergedRegion(cellRegion2);
			sheet.addMergedRegion(cellRegion3);
			
			row				= sheet.createRow(rowCount++);
			HSSFCell hc1	= row.createCell(3);	
			hc1.setCellValue(siteName);
			hc1.setCellStyle(style);
			
			HSSFCell hc4	= row.createCell(5);	
			hc4.setCellValue(repGenDateTime);
			hc4.setCellStyle(style1);

			row				= sheet.createRow(rowCount++);
			HSSFCell hc2	= row.createCell(3);	
			hc2.setCellValue(facilityName);
			hc2.setCellStyle(style);

			row = sheet.createRow(rowCount++);
			HSSFCell hc3 = row.createCell(3);	
			hc3.setCellValue(reportName);
			hc3.setCellStyle(style);

			rowCount	= rowCount+2;

			i=0;
			row = sheet.createRow(rowCount);		
	
		HSSFCellStyle style2=workbook.createCellStyle();

		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			/*Generating Header*/
			StringTokenizer hdrTokens=new StringTokenizer(repHdr,"~");
			repCellWidthTokens=new StringTokenizer(repCellWidth,",");
			while(hdrTokens.hasMoreTokens() && repCellWidthTokens.hasMoreTokens()){
				String hdr 			= hdrTokens.nextToken(); 
				int width 			= Integer.valueOf(repCellWidthTokens.nextToken()); 
				HSSFCell c1 		= row.createCell(i);	
				c1.setCellValue(hdr);
				sheet.setColumnWidth(i, width);
				c1.setCellStyle(style2);
				i++;
			}
			
			/*Replacing Arguments List with Query*/
			StringTokenizer argumentListTokens=new StringTokenizer(argumentList,",");
			while(argumentListTokens.hasMoreTokens()){
				String arg	= argumentListTokens.nextToken();
				String reqArg	= arg.substring(1);
				String argVal	= "'"+checkForNull(request.getParameter(reqArg))+"'";
				if(!arg.equals(":"))
					repQuery		= repQuery.replaceAll(arg, argVal);
			}
			
			rowCount++;
			i=0;
			
			HSSFCellStyle styleRes=workbook.createCellStyle();

			styleRes.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleRes.setBorderLeft(HSSFCellStyle.BORDER_THIN);

			
			
			if(!repQuery.equals("")){
				System.err.println("repQuery:"+repQuery);
				pstmt = conn.prepareStatement(repQuery);
				rs = pstmt.executeQuery();
				
				JSONArray arrJSON		= new JSONArray();
				while(rs!=null && rs.next()){
					JSONObject json			= new JSONObject();
					for(int c=0;c<resColumnsArr.size();c++){
						int width 			= Integer.valueOf(resColumnsWidthArr.get(c));
						json.put(resColumnsArr.get(c), checkForNull(rs.getString(resColumnsArr.get(c))));
						json.put(resColumnsArr.get(c)+"_width", width);
						
					}
					arrJSON.add(json);
				}
				
				if(pstmt != null)    pstmt.close();
				if(rs != null)    rs.close();
				for(int count=0;count<arrJSON.size();count++){
					i=0;
					row = sheet.createRow(rowCount);
					JSONObject objects = (JSONObject)arrJSON.get(count);
					for(int k=0;k<resColumnsArr.size();k++){
						String resCol  		= (String) objects.get(resColumnsArr.get(k));;
						Integer resColWidth  = (Integer) objects.get(resColumnsArr.get(k)+"_width");
						int width 			= Integer.valueOf(resColWidth);

						HSSFCell cc 		= row.createCell(i);	
						cc.setCellValue(resCol);
						sheet.setColumnWidth(i,width );
						cc.setCellStyle(styleRes);
						i++;
					}
					rowCount++;			
				}
			}
			workbook.write(response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, request);
			
		}
	}
}