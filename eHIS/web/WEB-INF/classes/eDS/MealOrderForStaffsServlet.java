/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;//Added Against ML-MMOH-CRF-0674
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ehis.util.DateUtils;
// Added Againt Start ML-MOH-CRF-825
import java.sql.Timestamp;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
// Added Againt Start ML-MOH-CRF-825
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eCommon.Common.CommonBean;//CRF-684 and Added Against ML-MMOH-CRF-0674
import eCommon.XSSRequestWrapper;

/**
 * Servlet implementation class RejectedItemsServlet
 */
public class MealOrderForStaffsServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	//Connection con; // commented for testing
	PreparedStatement pstmt;
	ResultSet rs;
	HashMap support_data = new HashMap();
	String msg="";

	StringBuffer sb = new StringBuffer();

	Boolean updateStatus_SuccessFlag,header_SuccessFlag=false;
	String tabId,facility_id,str_user_id,str_client_ip_address,login_user,mealOrderFromDate,mealOrderToDate,mealCategory,dietType,mealClass,mealType,noOfOrders,recordId,dietLocation,practitionerId,complaintCode,menuType,mode,staff_order_idValue,recordIdValue,practId,modeValue,othersComplaintsDesc,irregular_flag,lateIrregDietOrdStaff,currentTime;//Modified against CRF-0419,0678 and ML-MMOH-CRF-0730 and Modified against CRF-0419,0678,0684,0674,CRF-832,CRF-1125-US5,ML-MOH-CRF-825
	Date serving_Date;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); //Added Against ML-MOH-CRF-825
	int totalRows,staffOrderLineNum,orderId,totalNoOfMealsServed,noOfMealsServed,noOfMealsreceived,noOfMealsreject,totalNoOfMealsreceived=0,totalNoOfMealsrejected=0,totalMealReceive=0,totalMealReject=0; // Added for ML-MMOH-CRF-0730

	String locale;
	String sStyle = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealOrderForStaffsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
     response.addHeader("X-XSS-Protection", "1; mode=block");
     response.addHeader("X-Content-Type-Options", "nosniff"); 
     //Added Against MMS Vulnerability Issue - Ends 

	 //Added Against ML-MMOH-CRF-0674 Starts Here
	 Connection con=null; 
	 String error_value = "0" ;
	 try
	 {
	 	ArrayList<String> dietTypeList = new ArrayList<String>();
	 	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		this.out = response.getWriter();			
	    mode=CommonBean.checkForNull(request.getParameter("mode"));		   
		con	= ConnectionManager.getConnection(request); // Added for testing
		con.setAutoCommit(false);

	   if(mode.equals("fecthDietTypes_forstaff"))
	   {
		   dietTypeList = fecthDietTypes(request,con);
			out.println(dietTypeList);
	   }else{		 		  
		  //Added Against ML-MMOH-CRF-0674 Ends Here
			//String error_value = "0" ;
		String error = "";
		boolean flag=true;
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) request.getParameter("facilityId");
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		this.recordId=(String)request.getParameter("recordId");
		this.tabId = (String) request.getParameter("tabId");
		this.lateIrregDietOrdStaff = (String) request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_ST"); //Added Against ML-MOH-CRF-825

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";
		locale = prop.getProperty("LOCALE");
		try
		{	
		/* Commaneted Against Start CRF-832			
			this.mealOrderFromDate=(String)request.getParameter("mealOrderFrom");
			this.mealOrderFromDate = DateUtils.convertDate(this.mealOrderFromDate,"DMY", locale, "en"); // Date Localization 			
			this.mealOrderToDate=(String)request.getParameter("mealOrderTo");
			this.mealOrderToDate = DateUtils.convertDate(this.mealOrderToDate,"DMY", locale, "en"); //Date Localization 			
			this.mealCategory=(String)request.getParameter("mealCategory");
			//Added Against Crf-0419 starts here			
			this.dietLocation=(String)request.getParameter("dietLocation");
		    //Added Against Crf-0419 Ends here
			this.menuType=(String)request.getParameter("menuType");//CRF-684			
			//Added Against Crf-0678 starts here
 			if(mealCategory.equalsIgnoreCase("DOC")){       		this.practitionerId=(String)request.getParameter("practitioner");}else{ this.practitionerId=""; } 
		//Commaneted Against End CRF-832 */
		   //Added Against Crf-0678 Ends here
			MessageManager mm = new MessageManager();
			
			if(tabId.equals("mealOrderTab")) {
				this.totalRows=Integer.parseInt((String)request.getParameter("totalRows"));
				System.err.println("156,totalRows======"+totalRows);	
				if (recordId != null && recordId != "") {
					//updateStatus_SuccessFlag=updateStatus(request,response,con);//commented Against 832-CRF
				}				
				//CRF-832
				for(int i=1;i<=totalRows;i++){
	           	this.modeValue=(String)CommonBean.checkForNull(request.getParameter("mode"+i));
				System.err.println("155,modeValue============================"+modeValue);
				getData(request,i);
				if("insert".equals(modeValue) || "".equals(modeValue)){
					this.orderId=getOrderId(request,response,con)+1;
					header_SuccessFlag=insertStaffOrderHeader(request,response,con); // for testing
					flag= flag && insertStaffOrderDtl(request,response,con); // for testing	
				System.err.println("153,Insert,header_SuccessFlag======"+header_SuccessFlag+",flag===="+flag);
				}
				else if("update".equals(modeValue)){
					header_SuccessFlag=updateStaffOrderHeader(request,response,con);
					flag= flag && updateStaffOrderDtl(request,response,con);
				System.err.println("165,Update,header_SuccessFlag======"+header_SuccessFlag+",flag===="+flag);	
				}
				//CRF-832
				}
				if ( header_SuccessFlag && flag )
				{
					error_value = "1" ;
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
					error = (String) mesg.get("message");// "APP-SM0070 Operation Completed Successfully ....";
					mesg.clear(); 	//Common-ICN-0044
				}
				else
				{
					if (!header_SuccessFlag) {
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_HDRREC_NOTSAV_TRYAGN", "DS");
						error = (String) mesg.get("message"); //"Header record has not been saved. Please try again";
						mesg.clear(); 	//Common-ICN-0044
					}
					if (!flag) {
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_MORREC_NOTSAV_TRYAGN", "DS");
						error = (String) mesg.get("message");// "One or more detail records have not been saved. Please try again";
						mesg.clear(); 	//Common-ICN-0044
						}
				}
			}
			else if(tabId.equals("mealServedTab")) {
				if (recordId != null && recordId != "") {
					updateStatus_SuccessFlag=update_MealServed_Details(request,response,con);
					if (updateStatus_SuccessFlag) {
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
						error = (String) mesg.get("message"); // "APP-SM0070 Operation Completed Successfully ....";
						error_value = "1" ;
						mesg.clear(); 	//Common-ICN-0044
					}
					else {
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_NOTSAV_TRYAGN", "DS");
						error = (String) mesg.get("message"); //"Record has not been saved. Please try again";
						mesg.clear(); 	//Common-ICN-0044
					}
				}
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );				
		}catch (Exception e){
			System.err.println("207,Exception in doPost=" + e.toString());
			e.printStackTrace();
			if(con!=null)
			ConnectionManager.returnConnection(con);
			}		
		}
		}catch (Exception e){
			System.err.println("214,Exception in doPost=" + e.toString());
			e.printStackTrace();			
		}finally{//Added Against ML-MMOH-CRF-0674 Ends Here
			/*  if(!"0".equals(error_value))
				con.commit();
			else
				con.rollback();  
			*/
		try{			
			if(con!=null)
			ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("Exception in Meal Create:"+e);
			}
		}
	}

	private boolean updateStatus(HttpServletRequest req, HttpServletResponse res,Connection con) throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			//con	=	ConnectionManager.getConnection(req); // commented for testing
			String strQuery="update DS_STAFF_ORDERS_HDR set STATUS=? where FACILITY_ID=? and STAFF_ORDER_ID=?";
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,"CM");
			pstmt.setString(2,facility_id);
			pstmt.setString(3,recordId);
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in updateStatus method=" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
		}
		finally {
			if(pstmt!=null) pstmt.close();
			if(isUpdateSuccess) con.commit();
			else con.rollback();
		}
		return isUpdateSuccess;

	}

	private int getOrderId(HttpServletRequest req,HttpServletResponse res,Connection con) throws SQLException {
		//boolean isUpdateSuccess=false;
		int id=0;
		try {
			//con	=	ConnectionManager.getConnection(req);
			String strQuery="select max(to_number(staff_order_id)) from DS_STAFF_ORDERS_HDR";
			pstmt = con.prepareStatement(strQuery);

			rs=pstmt.executeQuery();
			if(rs!=null)
			{
			   while(rs.next())
			        {
				   		id=rs.getInt(1);
			        }
		 	 }
				}
		catch(Exception e) {
			System.err.println("exception in getOrderId method=" + e.toString());
			e.printStackTrace();
			}
		finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		return id;
	}

	private boolean insertStaffOrderHeader(HttpServletRequest request,HttpServletResponse response, Connection con)  throws SQLException {
		boolean isInsertSuccess=false;
		//CRF-684
        boolean isMenuType =false;        
		//Connection con = ConnectionManager.getConnection(request);
		isMenuType = CommonBean.isSiteSpecific(con,"DS","DS_MENU_TYPE");
		//CRF-684
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="INSERT INTO DS_STAFF_ORDERS_HDR (MEAL_CATEGORY, ORDER_FROM_DATE, ORDER_TO_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, STATUS, FACILITY_ID, STAFF_ORDER_ID,LOCATION_CODE,PRACTITIONER_ID,MENU_TYPE) values (?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";//CRF-419 and CRF-0678
					   
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,mealCategory);
			pstmt.setString(2,mealOrderFromDate);
			pstmt.setString(3,mealOrderToDate);
			pstmt.setString(4,login_user);
			pstmt.setTimestamp(5,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(6,facility_id);
			pstmt.setString(7,str_client_ip_address);
			pstmt.setString(8,login_user);
			pstmt.setTimestamp(9,new  java.sql.Timestamp(System.currentTimeMillis()));			
			pstmt.setString(10,facility_id);
			pstmt.setString(11,str_client_ip_address);
			pstmt.setString(12,null);
			pstmt.setString(13,facility_id);
			pstmt.setString(14,Integer.toString(orderId));
			pstmt.setString(15,dietLocation);//CRF-0419			
			pstmt.setString(16,practitionerId);//CRF-0678
			if(isMenuType){
			pstmt.setString(17,menuType);//CRF-0684
			}
			else{
			pstmt.setString(17,"");//CRF-0684	
			}
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		catch(SQLException sqle) {
			System.err.println("exception in insertStaffOrderHeader method=" + sqle.toString());
			sqle.printStackTrace();
			//con.close();
			isInsertSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in insertStaffOrderHeader method=" + e.toString());
			e.printStackTrace();
			//con.close();
			isInsertSuccess = false;
		}
		finally {
			if(pstmt!=null) pstmt.close();
			if(isInsertSuccess) con.commit();
			else con.rollback();
		}
		return isInsertSuccess;
	}
	
	private boolean insertStaffOrderDtl(HttpServletRequest request,HttpServletResponse response, Connection con)  throws SQLException {
		boolean isInsertSuccess=false;
		String currentDate = "",meal_code="",meal_desc="",IrrStartTime="",IrrEndTime="";  //Added Against ML-MOH-CRF-825
		StringBuffer mealtypeCat = new StringBuffer();
		try {
			
			String strQuery="insert into DS_STAFF_ORDERS_DTL (MEAL_CLASS, MEAL_TYPE, DIET_TYPE, NO_OF_MEALS_ORDERS, NO_OF_MEALS_SERVED, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, FACILITY_ID, STAFF_ORDER_ID, STAFF_ORDER_LINE_NUM,IRREGULAR_FLAG_YN) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //Modified Against ML-MOH-CRF-825
			
			/* Added Against Start ML-MOH-CRF-825 */
			String sysdateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate , TO_CHAR (SYSDATE, 'HH24:MI') currentTime from dual";
			pstmt = con.prepareStatement(sysdateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
				currentTime = rs.getString("currentTime");
			}
			System.err.println("361,currentTime=="+currentTime+"==currentDate=="+currentDate);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			

			mealtypeCat.append( " SELECT MEAL_TYPE,SHORT_DESC ");
			if(!mealCategory.equals("") && mealCategory.length()>0){	
			if(mealCategory.equals("DOC"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_DOC,IRREGULAR_END_TIME_DOC");
			else if(mealCategory.equals("OPS"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_OPS,IRREGULAR_END_TIME_OPS");
			else if(mealCategory.equals("ONC"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_ONC,IRREGULAR_END_TIME_ONC");
			else if(mealCategory.equals("STF"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_STF,IRREGULAR_END_TIME_STF");
			else if(mealCategory.equals("STU"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_STU,IRREGULAR_END_TIME_STU");
			}	

			mealtypeCat.append( " FROM DS_MEAL_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND (EFF_STATUS='E')");	
			if(!mealCategory.equals("") && mealCategory.length()>0){	
				if(mealCategory.equals("DOC"))
					mealtypeCat.append(" AND DOC_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("OPS"))
					mealtypeCat.append(" AND OPS_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("ONC"))
					mealtypeCat.append(" AND ONC_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("STF"))
					mealtypeCat.append(" AND STF_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("STU"))
					mealtypeCat.append(" AND STU_MEAL_ORDER_YN ='Y'");
			}
				mealtypeCat.append(" AND meal_type = ? ");
				mealtypeCat.append(" ORDER BY MEAL_ORDER");
			
			pstmt = con.prepareStatement(mealtypeCat.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,mealType);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				meal_code = (String)CommonBean.checkForNull(rs.getString(1));
				meal_desc = (String)CommonBean.checkForNull(rs.getString(2));
				IrrStartTime = (String)CommonBean.checkForNull(rs.getString(3));
				IrrEndTime = (String)CommonBean.checkForNull(rs.getString(4));
			}
			String startDate = mealOrderFromDate+" "+IrrStartTime;
			String endDate = currentDate+" "+IrrEndTime;
			String sysDate = currentDate+" "+currentTime;			
			irregular_flag= "N";
			if(lateIrregDietOrdStaff.equalsIgnoreCase("Y") && startDate.length()==16 && endDate.length()==16 && sysDate.length()==16){
			irregular_flag  = compareDatesByDateMethods(sdf, sdf.parse(endDate), sdf.parse(startDate),  sdf.parse(sysDate));			
			} 
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			/* Added Against End ML-MOH-CRF-825 */
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,mealClass);
			pstmt.setString(2,mealType);
			pstmt.setString(3,dietType);
			pstmt.setString(4,noOfOrders);
			pstmt.setString(5,null);
			pstmt.setString(6,login_user);
			pstmt.setTimestamp(7,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(8,facility_id);
			pstmt.setString(9,str_client_ip_address);
			pstmt.setString(10,login_user);
			pstmt.setTimestamp(11,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(12,facility_id);
			pstmt.setString(13,str_client_ip_address);
			pstmt.setString(14,facility_id);
			pstmt.setString(15,Integer.toString(orderId));
			pstmt.setInt(16,staffOrderLineNum);
			pstmt.setString(17,irregular_flag); //Added Against ML-MOH-CRF-825

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		  catch(ParseException sqle) { //Added Against ML-MOH-CRF-825
			System.err.println("exception in insertStaffOrderDtlMethod="+sqle.toString());
			sqle.printStackTrace();			
			isInsertSuccess = false;
		}  
		catch(SQLException sqle) {
			System.err.println("exception in insertStaffOrderDtlMethod="+sqle.toString());
			sqle.printStackTrace();
			//con.close();
			isInsertSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in insertStaffOrderDtlMethod===" + e.toString());
			e.printStackTrace();
			//con.close();
			isInsertSuccess = false;
		}
		finally {
			if(pstmt!=null) pstmt.close();
			if(isInsertSuccess) con.commit();
			else con.rollback();
		}
		return isInsertSuccess;
	}
	
		/* Added Against Start ML-MOH-CRF-825 */
		public String compareDatesByDateMethods(DateFormat sdf2,java.util.Date endDate, java.util.Date startDate, java.util.Date sysDate) {
		if (endDate.after(sysDate) && startDate.before(sysDate)){			
			irregular_flag = "Y";
		}
		return irregular_flag;
	}
	
	/* Added Against End ML-MOH-CRF-825 */
	
	private boolean updateStaffOrderHeader(HttpServletRequest request,HttpServletResponse response,Connection con)  throws SQLException {
		boolean isUpdateSuccess=false;
        boolean isMenuType =false;        
		//Connection con = ConnectionManager.getConnection(request);
		isMenuType = CommonBean.isSiteSpecific(con,"DS","DS_MENU_TYPE");
		int index=1;
		//Added Against Start DS-ML-MMOH-CRF-0832/03-[IN:065777]
		int index1=1;
		int flag=0;
		String _mealCategory="";
		String _mealOrderFromDate="";
		String _mealOrderToDate="";
		String _dietLocation="";
		String _practitionerId="";
		String _menuType="";
		//Added Against End DS-ML-MMOH-CRF-0832/03-[IN:065777]
		try {
			con	=	ConnectionManager.getConnection(request);
			//Added Against Start DS-ML-MMOH-CRF-0832/03-[IN:065777]
			StringBuffer strQuery = new StringBuffer();
			StringBuffer str_query = new StringBuffer();
			//Modified Start Against 065835
			str_query.append(" select meal_category, TO_CHAR(order_from_date,'DD/MM/YYYY') as order_from_date ");
			str_query.append(" , TO_CHAR(order_to_date,'DD/MM/YYYY') as order_to_date ");
			//Modified End Against 065835
			str_query.append(" ,location_code, practitioner_id, menu_type ");
			str_query.append(" from ds_staff_orders_hdr ");
			str_query.append(" where facility_id = ? ");
			str_query.append(" and staff_order_id = ? ");
			pstmt = con.prepareStatement(str_query.toString());
			pstmt.setString(index1++,facility_id);
			pstmt.setString(index1++,staff_order_idValue);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				_mealCategory = CommonBean.checkForNull(rs.getString("meal_category"));						
				_mealOrderFromDate = CommonBean.checkForNull(rs.getString("order_from_date"));					
				_mealOrderToDate = CommonBean.checkForNull(rs.getString("order_to_date"));
				_dietLocation = CommonBean.checkForNull(rs.getString("location_code"));						
				_practitionerId = CommonBean.checkForNull(rs.getString("practitioner_id"));						
				_menuType = CommonBean.checkForNull(rs.getString("menu_type"));						
			}

			
			if(!_mealCategory.equals(mealCategory) || !_mealOrderFromDate.equals(mealOrderFromDate) || !_mealOrderToDate.equals(mealOrderToDate) || !_dietLocation.equals(dietLocation) || !_practitionerId.equals(practitionerId) || !_menuType.equals(menuType) ){ // Modified Against 065835
				flag=1;
			}			
			strQuery.append(" UPDATE DS_STAFF_ORDERS_HDR SET MEAL_CATEGORY = ?, ORDER_FROM_DATE = to_date(?,'dd/mm/yyyy'), ORDER_TO_DATE =to_date(?,'dd/mm/yyyy') ");
			if(flag==1){
			strQuery.append(" ,MODIFIED_BY_ID = ?, MODIFIED_DATE = ?, MODIFIED_FACILITY_ID = ?,  MODIFIED_AT_WS_NO = ? ");
			}
			strQuery.append(" ,LOCATION_CODE = ?, PRACTITIONER_ID =?, MENU_TYPE =? ");
			strQuery.append(" WHERE FACILITY_ID = ? AND STAFF_ORDER_ID = ? ");
			
			//Added Against End DS-ML-MMOH-CRF-0832/03-[IN:065777]
					  					   
			/* 1.MEAL_CATEGORY=?, 2.ORDER_FROM_DATE=?, 3.ORDER_TO_DATE=?, 4.MODIFIED_BY_ID=?, 5.MODIFIED_DATE=?, 	6.MODIFIED_FACILITY_ID=?, 7.MODIFIED_AT_WS_NO=?, 8.LOCATION_CODE=?, 9.PRACTITIONER_ID=?, 10.MENU_TYPE=?, 11.FACILITY_ID=?, 12.STAFF_ORDER_ID= ? */
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			pstmt = con.prepareStatement(strQuery.toString());
			pstmt.setString(index++,mealCategory);
			pstmt.setString(index++,mealOrderFromDate);
			pstmt.setString(index++,mealOrderToDate);
			if(flag==1){ //Added Against Start DS-ML-MMOH-CRF-0832/03-[IN:065777]
			pstmt.setString(index++,login_user);
			pstmt.setTimestamp(index++,new java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(index++,facility_id);
			pstmt.setString(index++,str_client_ip_address);
			} //Added Against End DS-ML-MMOH-CRF-0832/03-[IN:065777]
			pstmt.setString(index++,dietLocation);
			pstmt.setString(index++,practitionerId);
			if(isMenuType){
			pstmt.setString(index++,menuType);
			}else{
			pstmt.setString(index++,"");
			}
			pstmt.setString(index++,facility_id);
			pstmt.setString(index++,staff_order_idValue);
			
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;				
			}
			if(pstmt!=null) pstmt.close();
		}
		catch(SQLException sqle) {
			System.err.println("SQLException in updateStaffOrderHeader method=" + sqle.toString());
			sqle.printStackTrace();
			//con.close();
			isUpdateSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in updateStaffOrderHeader method=" + e.toString());
			e.printStackTrace();
			//con.close();
			isUpdateSuccess = false;
		}
		finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(isUpdateSuccess) con.commit();
			else con.rollback();
		}
		return isUpdateSuccess;
	}
	
	private boolean updateStaffOrderDtl(HttpServletRequest request, HttpServletResponse response, Connection con)  throws SQLException {
		boolean isUpdateSuccess=false;
		int index=1;
		//Added Against Start DS-ML-MMOH-CRF-0832/03-[IN:065777]
		int index1=1;
		int flag=0;
		String _mealClass="";
		String _mealType="";
		String _dietType="";
		String _noOfOrders="";
		//Added Against End DS-ML-MMOH-CRF-0832/03-[IN:065777]
		String currentDate = "",meal_code="",meal_desc="",IrrStartTime="",IrrEndTime="";  //Added Against ML-MOH-CRF-825		
		try {
			/* Added Against Start ML-MOH-CRF-825 */
			String sysdateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate , TO_CHAR (SYSDATE, 'HH24:MI') currentTime from dual";
			pstmt = con.prepareStatement(sysdateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
				currentTime = rs.getString("currentTime");
			}
			//System.err.println("361,currentTime=="+currentTime+"==currentDate=="+currentDate);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();	
			StringBuffer mealtypeCat = new StringBuffer();
			mealtypeCat.append( " SELECT MEAL_TYPE,SHORT_DESC ");
			if(!mealCategory.equals("") && mealCategory.length()>0){	
			if(mealCategory.equals("DOC"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_DOC,IRREGULAR_END_TIME_DOC");
			else if(mealCategory.equals("OPS"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_OPS,IRREGULAR_END_TIME_OPS");
			else if(mealCategory.equals("ONC"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_ONC,IRREGULAR_END_TIME_ONC");
			else if(mealCategory.equals("STF"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_STF,IRREGULAR_END_TIME_STF");
			else if(mealCategory.equals("STU"))
				mealtypeCat.append(" ,IRREGULAR_START_TIME_STU,IRREGULAR_END_TIME_STU");
			}	

			mealtypeCat.append( " FROM DS_MEAL_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND (EFF_STATUS='E')");	
			if(!mealCategory.equals("") && mealCategory.length()>0){	
				if(mealCategory.equals("DOC"))
					mealtypeCat.append(" AND DOC_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("OPS"))
					mealtypeCat.append(" AND OPS_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("ONC"))
					mealtypeCat.append(" AND ONC_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("STF"))
					mealtypeCat.append(" AND STF_MEAL_ORDER_YN ='Y'");
				else if(mealCategory.equals("STU"))
					mealtypeCat.append(" AND STU_MEAL_ORDER_YN ='Y'");
			}
				mealtypeCat.append(" AND meal_type = ? ");
				mealtypeCat.append(" ORDER BY MEAL_ORDER");
			
			pstmt = con.prepareStatement(mealtypeCat.toString());
			//System.err.println("376,mealtypeCat==="+mealtypeCat.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,mealType);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				meal_code = (String)CommonBean.checkForNull(rs.getString(1));
				meal_desc = (String)CommonBean.checkForNull(rs.getString(2));
				IrrStartTime = (String)CommonBean.checkForNull(rs.getString(3));
				IrrEndTime = (String)CommonBean.checkForNull(rs.getString(4));
			}
			if(pstmt!=null) pstmt.close(); //Common-ICN-0044
			String startDate = mealOrderFromDate+" "+IrrStartTime;
			String endDate = currentDate+" "+IrrEndTime;
			String sysDate = currentDate+" "+currentTime;			
			//System.err.println("411,startDate=="+startDate);
			//System.err.println("412,endDate=="+endDate);
			//System.err.println("413,sysDate=="+sysDate);
				
			irregular_flag= "N";
			//System.err.println("463,Before,compare_yn==");
			if(lateIrregDietOrdStaff.equalsIgnoreCase("Y") && startDate.length()==16 && endDate.length()==16 && sysDate.length()==16){
				irregular_flag  = compareDatesByDateMethods(sdf, sdf.parse(endDate), sdf.parse(startDate),  sdf.parse(sysDate));			
			} 
			/* Added Against End ML-MOH-CRF-825 */
			//System.err.println("421,irregular_flag=="+irregular_flag);			
			/* Added Against End ML-MOH-CRF-825 */
			//Added Against Start DS-ML-MMOH-CRF-0832/03-[IN:065777]
			StringBuffer strQuery = new StringBuffer();
			StringBuffer str_query = new StringBuffer();
			str_query.append("SELECT meal_class, meal_type, diet_type, no_of_meals_orders");
			str_query.append(" FROM ds_staff_orders_dtl");
			str_query.append(" WHERE facility_id = ? ");
			str_query.append(" AND staff_order_id = ? "); 
			str_query.append(" AND staff_order_line_num = ? ");
			pstmt = con.prepareStatement(str_query.toString());
			pstmt.setString(index1++,facility_id);
			pstmt.setString(index1++,staff_order_idValue);
			pstmt.setInt(index1++,staffOrderLineNum);			
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				_mealClass = CommonBean.checkForNull(rs.getString("meal_class"));						
				_mealType = CommonBean.checkForNull(rs.getString("meal_type"));						
				_dietType = CommonBean.checkForNull(rs.getString("diet_type"));						
				_noOfOrders = CommonBean.checkForNull(rs.getString("no_of_meals_orders"));						
			}
			if(pstmt!=null) pstmt.close(); //Common-ICN-0044
			if(!_mealClass.equals(mealClass) || !_mealType.equals(mealType) || !_dietType.equals(dietType) || ! _noOfOrders.equals(noOfOrders) ){
				flag=1;				
			}			
			strQuery.append(" UPDATE DS_STAFF_ORDERS_DTL SET MEAL_CLASS = ?, MEAL_TYPE = ?, DIET_TYPE = ?, NO_OF_MEALS_ORDERS = ?  ");
			if(flag==1){
			strQuery.append(" , MODIFIED_BY_ID = ?, MODIFIED_DATE = ?, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");	
			}
			strQuery.append(" ,IRREGULAR_FLAG_YN = ? "); //Added Against ML-MMOH-CRF-825
			strQuery.append(" WHERE FACILITY_ID = ? AND STAFF_ORDER_ID = ? AND STAFF_ORDER_LINE_NUM = ? ");	
			//Added Against End DS-ML-MMOH-CRF-0832/03-[IN:065777]
			
			/* 1.meal_class 2.meal_type 3.diet_type 4.no_of_meals_orders 5.MODIFIED_BY_ID 6.MODIFIED_DATE 		7.MODIFIED_FACILITY_ID 8.MODIFIED_AT_WS_NO 9.FACILITY_ID 10.STAFF_ORDER_ID 11.staff_order_line_num
			*/			
			pstmt = con.prepareStatement(strQuery.toString());
			pstmt.setString(index++,mealClass);
			pstmt.setString(index++,mealType);
			pstmt.setString(index++,dietType);
			pstmt.setString(index++,noOfOrders);
			if(flag==1){  //Added Against Start DS-ML-MMOH-CRF-0832/03-[IN:065777]
			pstmt.setString(index++,login_user);
			pstmt.setTimestamp(index++,new  java.sql.Timestamp(System.currentTimeMillis()));
			
			pstmt.setString(index++,facility_id);
			pstmt.setString(index++,str_client_ip_address);
			}  //Added Against End DS-ML-MMOH-CRF-0832/03-[IN:065777]
			pstmt.setString(index++,irregular_flag); //Added Against ML-MMOH-CRF-825
			pstmt.setString(index++,facility_id);
			pstmt.setString(index++,staff_order_idValue);
			pstmt.setInt(index++,staffOrderLineNum);

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
			if(pstmt!=null) pstmt.close();
		}
		catch(SQLException sqle) {
			System.err.println("exception in updateStaffOrderDtl method="+sqle.toString());
			sqle.printStackTrace();
			//con.close();
			isUpdateSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in updateStaffOrderDtl method=" + e.toString());
			e.printStackTrace();
			//con.close();
			isUpdateSuccess = false;
		}
		finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(isUpdateSuccess) con.commit();
			else con.rollback();			
		}
		return isUpdateSuccess;
	}
	
	private boolean update_MealServed_Details(HttpServletRequest req, HttpServletResponse res, Connection con) throws SQLException {
		boolean isUpdateSuccess=false,isMealComplaints=false;//CRF-1125-US5
		this.staffOrderLineNum=Integer.parseInt((String)req.getParameter("recordOrderLineNum"));
		String totMealsServed = req.getParameter("totalNoOfMealsServed");
		String noMealsServed = req.getParameter("noOfMealsServed");
		if(totMealsServed.equals("") || totMealsServed.equals("null")){
			totMealsServed = "0";
		}
		if(noMealsServed.equals("") || noMealsServed.equals("null")){
			noMealsServed = "0";
		}
		this.totalNoOfMealsServed=Integer.parseInt(totMealsServed);
		this.noOfMealsServed=Integer.parseInt(noMealsServed);
		/* Added Start for ML-MMOH-CRF-0730 */
		String totalMealsreceived = req.getParameter("totalnoOfMealsreceived");
		if(totalMealsreceived.equals("") || totalMealsreceived.equals("null")){
			totalMealsreceived = "0";
		}
		String MealsReceived = req.getParameter("noOfMealsreceived");
		if(MealsReceived.equals("") || MealsReceived.equals("null")){
			MealsReceived = "0";
		}
		String totalMealsrejected = req.getParameter("totalNoOfMealsreject");
		if(totalMealsrejected.equals("") || totalMealsrejected.equals("null")){
			totalMealsrejected = "0";
		}
		String MealsRejected = req.getParameter("noOfMealsreject");
		if(MealsRejected.equals("") || MealsRejected.equals("null")){
			MealsRejected = "0";
		}
		this.totalNoOfMealsreceived=Integer.parseInt(totalMealsreceived);
		this.noOfMealsreceived=Integer.parseInt(MealsReceived);
		this.totalNoOfMealsrejected=Integer.parseInt(totalMealsrejected);
		this.noOfMealsreject=Integer.parseInt(MealsRejected);
		this.complaintCode=req.getParameter("complaintCode");		
		this.totalMealReceive=totalNoOfMealsreceived+noOfMealsreceived;		
		this.totalMealReject=totalNoOfMealsrejected+noOfMealsreject;
		isMealComplaints=Boolean.valueOf(req.getParameter("isMealComplaints"));
		this.othersComplaintsDesc=req.getParameter("othersComp");	//Added Against CRF-1125	
		if(othersComplaintsDesc==null) othersComplaintsDesc="";	//Added If Else Condtion Against 36428
		//Added Against ML-MMOH-CRF-1816 Starts
		else if(othersComplaintsDesc.contains("& #39;"))
		othersComplaintsDesc = othersComplaintsDesc.replace("& #39;", "'");	
		//Added Against ML-MMOH-CRF-1816 Ends	
		/* Added End for ML-MMOH-CRF-0730 */
		int index=1; // Added Against IN-065835
	
	try {
		//con	=	ConnectionManager.getConnection(req);
		StringBuffer sb1 = new StringBuffer();		
		sb1.append("update DS_STAFF_ORDERS_DTL set NO_OF_MEALS_SERVED=?");
		sb1.append(" , MODIFIED_BY_ID=?");
		sb1.append(" , MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?");
		sb1.append(" , NO_OF_MEALS_RECEIVED=?, NO_OF_MEALS_REJECTED=? ");
		if(noOfMealsreceived > 0)
		sb1.append(", RECEIVED_BY_ID=?");
		if(noOfMealsreject > 0){
		sb1.append(", REJECTED_BY_ID=?");
		sb1.append(", COMPLAINT_CODE=?");
		if(isMealComplaints)
			sb1.append(", OTH_COMPLAINT_DESC=?"); //Added Against ML-MOH-CRF-1125	
		}
		sb1.append(" where FACILITY_ID=? and STAFF_ORDER_ID=? and STAFF_ORDER_LINE_NUM=? "); // Added for ML-MMOH-CRF-0730 14,15,16
			pstmt = con.prepareStatement(sb1.toString());
			pstmt.setInt(index++,totalNoOfMealsServed+noOfMealsServed);
			pstmt.setString(index++,login_user);
			pstmt.setString(index++,facility_id);
			pstmt.setString(index++,str_client_ip_address);
			/* Added Start for ML-MMOH-CRF-0730 */
			pstmt.setInt(index++,totalNoOfMealsreceived+noOfMealsreceived);
			pstmt.setInt(index++,totalNoOfMealsrejected+noOfMealsreject);
			if(noOfMealsreceived > 0 && noOfMealsreject > 0){		
				pstmt.setString(index++,login_user);
				pstmt.setString(index++,login_user);
				pstmt.setString(index++,complaintCode);
				if(isMealComplaints)
				pstmt.setString(index++,othersComplaintsDesc); //Added Against ML-MOH-CRF-1125	
				pstmt.setString(index++,facility_id);
				pstmt.setString(index++,recordId);
				pstmt.setInt(index++,staffOrderLineNum);
			}else if(noOfMealsreceived > 0 && noOfMealsreject == 0 ){			
				pstmt.setString(index++,login_user);
				pstmt.setString(index++,facility_id);
				pstmt.setString(index++,recordId);
				pstmt.setInt(index++,staffOrderLineNum);
			}else if(noOfMealsreject > 0 && noOfMealsreceived == 0 ){			
				pstmt.setString(index++,login_user);
				pstmt.setString(index++,complaintCode);
				if(isMealComplaints)
				pstmt.setString(index++,othersComplaintsDesc); //Added Against ML-MOH-CRF-1125	
				pstmt.setString(index++,facility_id);
				pstmt.setString(index++,recordId);
				pstmt.setInt(index++,staffOrderLineNum);
			}
			else
			{				
				pstmt.setString(index++,facility_id);
				pstmt.setString(index++,recordId);
				pstmt.setInt(index++,staffOrderLineNum);			
			}
			/* Added End for ML-MMOH-CRF-0730 */
			int row=pstmt.executeUpdate();
			if (row >0)
				isUpdateSuccess = true;
		}
		catch(NumberFormatException e) {
			System.err.println("exception in NumberFormatException method=" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in updateStatus method=" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
		}
		finally {
			if(pstmt!=null) pstmt.close();
			if(isUpdateSuccess) con.commit();
			else con.rollback();
		}
		return isUpdateSuccess;
	}

	private void getData(HttpServletRequest request,int i) {
		/*DS_STAFF_ORDERS_HDR Datas*/
		/* Below Added Start checkForNull Against DS-ML-MMOH-CRF-0832-US004/01 [IN:065738]*/
		this.mealOrderFromDate=(String)CommonBean.checkForNull(request.getParameter("mealOrderFrom"+i));
		this.mealOrderFromDate = DateUtils.convertDate(this.mealOrderFromDate,"DMY", locale, "en");
		this.mealOrderToDate=(String)CommonBean.checkForNull(request.getParameter("mealOrderTo"+i));
		this.mealOrderToDate = DateUtils.convertDate(this.mealOrderToDate,"DMY", locale, "en"); 
		this.mealCategory=(String)CommonBean.checkForNull(request.getParameter("mealCategory"+i));
		if(mealCategory.equalsIgnoreCase("DOC")){		
		this.practitionerId=(String)CommonBean.checkForNull(request.getParameter("practId"+i));
		}else{
		this.practitionerId="";
		}
		staff_order_idValue=(String)CommonBean.checkForNull(request.getParameter("staff_order_id"+i));		
		this.dietLocation=(String)CommonBean.checkForNull(request.getParameter("dietLocation"+i));
		this.menuType=(String)CommonBean.checkForNull(request.getParameter("menuType"+i));
		/*DS_STAFF_ORDERS_DTL Datas*/
		this.dietType=(String)CommonBean.checkForNull(request.getParameter("dietTypeValue"+i));
		this.mealClass=(String)CommonBean.checkForNull(request.getParameter("mealClassValue"+i));
		this.mealType=(String)CommonBean.checkForNull(request.getParameter("mealTypeValue"+i));
		this.noOfOrders=(String)CommonBean.checkForNull(request.getParameter("noOfOrders"+i));
		/* Below Added End checkForNull Against DS-ML-MMOH-CRF-0832-US004/01 [IN:065738]*/
		this.staffOrderLineNum=1;
	}
	
//Added Against ML-MMOH-CRF-0674 Starts here
	
public ArrayList<String> fecthDietTypes(HttpServletRequest request,Connection con){
	ArrayList<String> list = new ArrayList<String>();
	//con = ConnectionManager.getConnection(request);           
	String diettypeauto=request.getParameter("diettype_auto");			
	diettypeauto=diettypeauto+"%";
	try {					
			String diet_Types = "select diet_Type,short_Desc from Ds_Diet_Type_Lang_Vw where language_Id='en' and eff_Status ='E'  AND LOWER(short_desc) LIKE LOWER(?)  order by  LOWER (short_desc)";//Added Against ML-MMOH-CRF-0674
		
			pstmt = con.prepareStatement(diet_Types);
	}catch (SQLException e1) {
		e1.printStackTrace();
		System.err.println("MealOrderForStaffsServlet.java--->"+e1.getMessage());
	}
	try{				
			pstmt.setString(1, diettypeauto);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				String diet_Type = rs.getString(1);
				String short_Desc = rs.getString(2).replace(",","");
				list.add(diet_Type);
				list.add(short_Desc);
			}				
	if(rs!=null) rs.close();
	}catch(Exception ee){
		ee.printStackTrace();
		System.err.println("MealOrderForStaffsServlet.java in fecthDietTypes--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception e){}
	}
	return list;
}
	//Added Against ML-MMOH-CRF-0674 Ends here
}
