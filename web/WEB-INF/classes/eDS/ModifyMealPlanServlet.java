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
import java.io.PrintWriter;//Added Against ML-MMOH-CRF-0674
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;//Added Against ML-MMOH-CRF-0674
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eCommon.Common.CommonBean;//Added Against ML-MMOH-CRF-0674
/**
 * Servlet implementation class ModifyMealPlanServlet
 */
public class ModifyMealPlanServlet extends HttpServlet {
	// Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;
	PrintWriter out;//Added Against ML-MMOH-CRF-0674
	int encounter_id=0;
	int item_Qty=0;
	String service_date="";
	String kitchenCode="";
	String mealType="";
	String dietType="";
	String frequency="";
	String item_Type="";
	String item_Code="";
	String meal_Category="";
	String patient_Class="";
	String status="";
	String serving_Uom_Code="";
	String item_slr="";
	String spl_Food_Item_Yn = "";
	String freq_Yn = "";
	String short_Desc="";
	//Added for MMS-KH-CRF-0029.1 - US009 Start
	String order_id = "";
	int order_line_num = 0;
	String order_catalog_code = "";
	String drug_code;
	String remarks;
	String enableDrugYN="";
	//Added for MMS-KH-CRF-0029.1 - US009 End
	
	String dietDescription = "";
	String shortDescription = "";
	String ageGroup = "";
    String defaultDietType = "";
    String defaultFeedType = "";
    String dietCycleType = "";
    String orderCatlogcode = "";
    String dietCategory = "";
    String enabled = "";
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	String language_id = "";
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
   // CommonCheckPk commonChk = null;
	private String locale = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMealPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	// MMS-KH-CRF-029.1
	private String checkForNull(String parameter) {
		// TODO Auto-generated method stub
		String ret = "";
		if(parameter == null){
			ret = "";
		}
		else{
			ret = parameter;
		}
		return ret;
	}
	// MMS-KH-CRF-029.1

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends 

		// TODO Auto-generated method stub
		String error = "",error_value = "";
		int result = 0;
		//Added Against ML-MMOH-CRF-0674 Starts Here
		try
		{
			ArrayList<String> modifyMealPlan = new ArrayList<String>(); 
			ArrayList<String> dietTypeList = new ArrayList<String>();
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			String mode_diet="";
			mode_diet=checkForNull(request.getParameter("mode_diet")); 
			//Added for MMS-KH-CRF-0029.1 - US009 Start
			if(mode_diet.equals("modify_Meal"))
			{
				modifyMealPlan = modifyMeal(request,response);
				out.println(modifyMealPlan);		
			}
			//Added for MMS-KH-CRF-0029.1 - US009 End
			if(mode_diet.equals("fecthDietTypes_forpatient"))
			{
				dietTypeList = fecthDietTypes(request);
				out.println(dietTypeList);		
			}			
			else
			{
				String total = checkForNull(request.getParameter("totalRecords"));
				//Added Against ML-MMOH-CRF-0674 Ends Here
				if(!total.equals(null) && !total.equals(""))
				{
				//Added for MMS-KH-CRF-0029.1 - US009 Start
				enableDrugYN = checkForNull(request.getParameter("enableDrugYN"));
				if(enableDrugYN.equals("Y")){
					service_date = request.getParameter("service_date");
					encounter_id = Integer.parseInt(request.getParameter("encounter_id"));
					con = ConnectionManager.getConnection(request);
					try{
						String sql = "SELECT b.order_id, b.order_line_num, b.order_catalog_code FROM ds_epsd_diet_profile_hdr a, or_order_line b WHERE a.order_id = b.order_id AND a.encounter_id = ? AND TO_DATE (?, 'dd/mm/yyyy') BETWEEN period_from AND period_to ";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, encounter_id);
						pstmt.setString(2, service_date);
						rst = pstmt.executeQuery();
						if(rst != null && rst.next()){
							order_id = rst.getString(1);
							order_line_num = rst.getInt(2);
							order_catalog_code = rst.getString(3);
						}
						}catch(Exception ee){
							ee.printStackTrace();
							System.err.println("ModifyMealPlanServlet.java in Druge Interaction--->"+ee.getMessage());
						}
						finally{
							try{
								if(rst!=null) rst.close();
								if(pstmt!=null) pstmt.close();
								if(con!=null)ConnectionManager.returnConnection(con);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
				}
				//Added for MMS-KH-CRF-0029.1 - US009 End
					int totalRecords=Integer.parseInt(total);
					for(int i=1;i<=totalRecords;i++) {
					mode=(String)request.getParameter("mode"+i);
					if("insert".equals(mode))
						{
							insertModifyHdr(request,response);
							result = insertModifyDtl(request,response,i);
						}
					else if("update".equals(mode))
						{
							updateModifyHdr(request,response);
							result = updateModifyDtl(request,response,i);
						}
					//Added newly for Cancel operation on 11/22/2012
					else if("delete".equals(mode))
						{
							result = deleteModifyDtl(request,response,i);
						}
					//Added newly for Cancel operation on 11/22/2012
					}

					this.locale  = (String) session.getAttribute("LOCALE");
					MessageManager mm = new MessageManager();
					if(result == 1){
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
						error = (String) mesg.get("message"); //"APP-SM0070 Operation Completed Successfully ....";
						mesg.clear();	//Common-ICN-0044
					}
					else if(result == 0){
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_EXISTS", "DS");
						error = (String) mesg.get("message"); // "APP-000064 Record Already Exists...";
						mesg.clear();	//Common-ICN-0044
					}
					else if(result == 2){
						final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_NOTSAV_TRYAGN", "DS");
						error = (String) mesg.get("message");  // "Record has not saved. Please try again";
						mesg.clear();	//Common-ICN-0044
					}
					error_value = Integer.toString(result);
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
					//Added Against ML-MMOH-CRF-0674
				}// else Closed for ML-MMOH-CRF-0674
			}
			}//try closed for ML-MMOH-CRF-0674
			catch(Exception e)
			{
			e.printStackTrace();
			}
			//for ML-MMOH-CRF-0674
	}


	private int updateModifyHdr(HttpServletRequest request,HttpServletResponse response) {
		int rslt = 0;
		int err_no = 0;
		String sql;
		status = request.getParameter("status");
		try{
		session = request.getSession(false);
		language_id = (String)session.getAttribute("LOCALE");
		encounter_id = Integer.parseInt(request.getParameter("encounter_id"));
		mealType = request.getParameter("mealType");
		kitchenCode = request.getParameter("kitchenCode");
		patient_Class = request.getParameter("patient_Class");
		meal_Category = request.getParameter("meal_Category");
		service_date = request.getParameter("service_date");
		
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		con = ConnectionManager.getConnection(request);

		sql = "update ds_epsd_meal_plan_hdr set status = ?,meal_plan_modified_yn='Y'  where operating_facility_id = ? and to_char(serving_date,'dd/mm/yyyy')  = ? and encounter_id    = ? and nvl(meal_type,'##') = ? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setString(2, facility_id);
     	pstmt.setString(3, service_date);
		pstmt.setInt(4, encounter_id);
		pstmt.setString(5, mealType);
		rslt= pstmt.executeUpdate();
		err_no = 1;
		con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Modify Meal Plan UpdateHdr -> "+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
				con.close();
			}
			catch(Exception e){
				System.err.println("Exception in Meal Create:"+e);
			}
		}
		return err_no;
	}

	private int updateModifyDtl(HttpServletRequest request,HttpServletResponse response, int i) {
		int rslt = 0;
		int err_no = 0;
		int rslt1 = 0;
		String sql;
		// Checkstyle Violation commented by Munisekhar
		//String status = request.getParameter("status");
		try{
			session = request.getSession(false);
			language_id = (String)session.getAttribute("LOCALE");
			
			encounter_id = Integer.parseInt(request.getParameter("encounter_id"));
			mealType = request.getParameter("mealType");
			item_Code = request.getParameter("hid_item_Code"+i);
			spl_Food_Item_Yn = request.getParameter("hid_spl_Food_Item_Yn"+i);
			service_date = request.getParameter("service_date");
			item_Qty = Integer.parseInt(request.getParameter("hid_item_Qty"+i));
			
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			con = ConnectionManager.getConnection(request);

			sql = "update ds_epsd_meal_plan_dtl set item_qty = ? where operating_facility_id = ? and   to_char(serving_date,'dd/mm/yyyy')  = ? and encounter_id = ? and nvl(meal_type,'##') = ? and item_code = ? and spl_food_item_yn = ?";


			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, item_Qty);
			pstmt.setString(2, facility_id);
		 	pstmt.setString(3, service_date);
			pstmt.setInt(4, encounter_id);
			pstmt.setString(5, mealType);
			pstmt.setString(6, item_Code);
			pstmt.setString(7, spl_Food_Item_Yn);

			rslt= pstmt.executeUpdate();
			
			//Added for MMS-KH-CRF-0029.1-US009 Start
			if(enableDrugYN.equals("Y")){
				remarks = checkForNull(request.getParameter("remarksVal"));				
				String sql1 = "UPDATE OR_ORDER_DRUG_INTERACTION SET OVERRIDE_REASON = ? WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ? AND ORDER_CATALOG_CODE = ?";

				pstmt1 = con.prepareStatement(sql1);
					
				pstmt1.setString(1, remarks);
				pstmt1.setString(2, order_id);
				pstmt1.setInt(3, order_line_num);
				pstmt1.setString(4, order_catalog_code);
					
				rslt1= pstmt1.executeUpdate();
			}
			//Added for MMS-KH-CRF-0029.1-US009 End
		err_no = 1;
		con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Modify Meal Plan UpdateDtl -> "+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
				con.close();
			}
			catch(Exception e){
				System.err.println("Exception in Meal Create:"+e);
			}
		}
		return err_no;
	}


	private int insertModifyHdr(HttpServletRequest request, HttpServletResponse response) {
		int rslt = 0;
		int err_no = 0;
		String sql;
		// Checkstyle Violation commented by Munisekhar
		//int flag;
		try{
		session = request.getSession(false);
		language_id = (String)session.getAttribute("LOCALE");
			
		encounter_id = Integer.parseInt(request.getParameter("encounter_id"));
		mealType = request.getParameter("mealType");
		kitchenCode = request.getParameter("kitchenCode");
		patient_Class = request.getParameter("patient_Class");
		meal_Category = request.getParameter("meal_Category");
		status = request.getParameter("status");
		service_date = request.getParameter("service_date");
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		con = ConnectionManager.getConnection(request);

		sql = "INSERT INTO DS_EPSD_MEAL_PLAN_HDR(OPERATING_FACILITY_ID, ENCOUNTER_ID, MEAL_TYPE, KITCHEN_CODE, PATIENT_CLASS, MEAL_CATEGORY, STATUS, MODIFIED_FACILITY_ID, ADDED_BY_ID, MODIFIED_AT_WS_NO, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, SERVING_DATE, ADDED_DATE, MODIFIED_DATE,MEAL_PLAN_MODIFIED_YN) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),SYSDATE,SYSDATE,'Y')";

		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, facility_id);
		pstmt.setInt(2, encounter_id);
		pstmt.setString(3, mealType);
		pstmt.setString(4, kitchenCode);
		pstmt.setString(5, patient_Class);
		pstmt.setString(6, meal_Category);
		pstmt.setString(7, status);
		pstmt.setString(8, facility_id);
		pstmt.setString(9, login_user);
		pstmt.setString(10, client_ip_address);
		pstmt.setString(11, facility_id);
		pstmt.setString(12, client_ip_address);
		pstmt.setString(13, login_user);
		pstmt.setString(14, service_date);
		rslt= pstmt.executeUpdate();
		err_no = 1;
		con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Modify Meal Plan insertModifyHdr ->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				//ConnectionManager.returnConnection(con);
				//con.close();
				if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
			}
			catch(Exception e){
				System.err.println("Exception in Meal Create:"+e);
			}

		}
		return err_no;
	}

	private int insertModifyDtl(HttpServletRequest request, HttpServletResponse response, int i) {
		int rslt = 0;
		int rslt1 = 0;
		int err_no = 0;
		String sql;
		// Checkstyle Violation commented by Munisekhar
		//int flag;
		try{
		session = request.getSession(false);
		language_id = (String)session.getAttribute("LOCALE");
		encounter_id = Integer.parseInt(request.getParameter("encounter_id"));
		mealType = request.getParameter("mealType");
		kitchenCode = request.getParameter("kitchenCode");
		patient_Class = request.getParameter("patient_Class");
		meal_Category = request.getParameter("meal_Category");
		status = request.getParameter("status");
		item_slr = request.getParameter("hid_item_slr"+i);
		item_Type = request.getParameter("hid_item_Type"+i);
		item_Code = request.getParameter("hid_item_Code"+i);
		item_Qty = Integer.parseInt(request.getParameter("hid_item_Qty"+i));
		spl_Food_Item_Yn = request.getParameter("hid_spl_Food_Item_Yn"+i);
		freq_Yn = request.getParameter("hid_freq_Yn"+i);
		service_date = request.getParameter("service_date");
		this.prop = (java.util.Properties) session.getValue( "jdbc" );
		this.facility_id = (String) session.getValue( "facility_id" );
		login_user = this.prop.getProperty( "login_user" );
		client_ip_address = this.prop.getProperty("client_ip_address");

		con = ConnectionManager.getConnection(request);

		sql = "INSERT INTO DS_EPSD_MEAL_PLAN_DTL(ITEM_SL, ITEM_TYPE, ENCOUNTER_ID, MEAL_TYPE, ITEM_CODE, ITEM_QTY, PREF_OPTION, KITCHEN_CODE, MEAL_CATEGORY, PATIENT_CLASS, MODIFIED_FACILITY_ID, ADDED_BY_ID, MODIFIED_AT_WS_NO, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, SPL_FOOD_ITEM_YN, FREQ_YN, OPERATING_FACILITY_ID,SERVING_DATE,ADDED_DATE,MODIFIED_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),SYSDATE,SYSDATE)";

		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, item_slr);
		pstmt.setString(2, item_Type);
		pstmt.setInt(3, encounter_id);
		pstmt.setString(4, mealType);
		pstmt.setString(5, item_Code);
		pstmt.setInt(6, item_Qty);
		pstmt.setString(7, "M");
		pstmt.setString(8, kitchenCode);
		pstmt.setString(9, meal_Category);
		pstmt.setString(10, patient_Class);
		pstmt.setString(11, facility_id);
		pstmt.setString(12, login_user);
		pstmt.setString(13, client_ip_address);
		pstmt.setString(14, facility_id);
		pstmt.setString(15, client_ip_address);
		pstmt.setString(16, login_user);
		pstmt.setString(17, spl_Food_Item_Yn);
		pstmt.setString(18, freq_Yn);
		pstmt.setString(19, facility_id);
		pstmt.setString(20, service_date);
		rslt= pstmt.executeUpdate();
		
		//Added for MMS-KH-CRF-0029.1-US009 Start
		try{
			if(enableDrugYN.equals("Y")){
				drug_code = request.getParameter("hid_drug_Code"+i);
				if(!drug_code.equals(null) && !drug_code.equals("")){
					remarks = checkForNull(request.getParameter("remarksVal"));				
					
					String sql1 = "INSERT INTO OR_ORDER_DRUG_INTERACTION(ORDER_ID, ORDER_LINE_NUM, ORDER_CATALOG_CODE, DRUG_INTERACTION_CODE, ORDERING_MODULE_ID, INTERACTION_STATUS, OVERRIDE_REASON, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,?,'DS',?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

					pstmt1 = con.prepareStatement(sql1);
					pstmt1.setString(1, order_id);
					pstmt1.setInt(2, order_line_num);
					pstmt1.setString(3, order_catalog_code);
					pstmt1.setString(4, drug_code);
					pstmt1.setString(5, "Y");
					pstmt1.setString(6, remarks);
					pstmt1.setString(7, login_user);
					pstmt1.setString(8, client_ip_address);
					pstmt1.setString(9, facility_id);
					pstmt1.setString(10, login_user);
					pstmt1.setString(11, client_ip_address);
					pstmt1.setString(12, facility_id);
					rslt1= pstmt1.executeUpdate();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			remarks = checkForNull(request.getParameter("remarksVal"));				
			String sql1 = "UPDATE OR_ORDER_DRUG_INTERACTION SET OVERRIDE_REASON = ? WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ? AND ORDER_CATALOG_CODE = ?";

			pstmt1 = con.prepareStatement(sql1);
			
			pstmt1.setString(1, remarks);
			pstmt1.setString(2, order_id);
			pstmt1.setInt(3, order_line_num);
			pstmt1.setString(4, order_catalog_code);
			
			rslt1= pstmt1.executeUpdate();
			//err_no = 2;
		}
		//Added for MMS-KH-CRF-0029.1-US009 End
		err_no = 1;
		con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("eDS Exception Modify Meal Plan insertModifyDtl ->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
				System.err.println("Exception in Meal Create:"+e);
			}
		}
		return err_no;
	}

	private int deleteModifyDtl(HttpServletRequest request,
			HttpServletResponse response, int i) {
		int result = 0;
		String sql;
		try{
			session = request.getSession(false);
			language_id = (String)session.getAttribute("LOCALE");
			encounter_id = Integer.parseInt(request.getParameter("encounter_id"));
		    mealType = request.getParameter("mealType");
		    kitchenCode = request.getParameter("kitchenCode");
		    item_slr = request.getParameter("hid_item_slr"+i);
		    item_Type = request.getParameter("hid_item_Type"+i);
		    item_Code = request.getParameter("hid_item_Code"+i);
		    service_date = request.getParameter("service_date");
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			sql = "delete FROM DS_EPSD_MEAL_PLAN_DTL where ENCOUNTER_ID=?  and  KITCHEN_CODE=? and MEAL_TYPE=? and OPERATING_FACILITY_ID=? and ITEM_SL=? and ITEM_TYPE=? and  ITEM_CODE=? and TRUNC(SERVING_DATE)=TO_DATE(?,'DD/MM/YYYY') ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, encounter_id);
			pstmt.setString(2, kitchenCode);
			pstmt.setString(3, mealType);
			pstmt.setString(4, facility_id);
		    pstmt.setString(5, item_slr);
		    pstmt.setString(6, item_Type);
		    pstmt.setString(7, item_Code);
			pstmt.setString(8, service_date);
			pstmt.execute();
			result = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			result = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet Create:"+e);
			}
		}
		return result;
	}
	
//Added Against ML-MMOH-CRF-0674 Starts here	
public ArrayList<String> fecthDietTypes(HttpServletRequest request){
	ArrayList<String> list = new ArrayList<String>();
	con = ConnectionManager.getConnection(request);		
	String diettypeauto=request.getParameter("diettype_auto");		
	diettypeauto=diettypeauto+"%";
	try {					
			String diet_Types = "select diet_Type,short_Desc from Ds_Diet_Type_Lang_Vw where language_Id='en' and eff_Status ='E'  AND LOWER(short_desc) LIKE LOWER(?)  order by  LOWER (short_desc)";		
			pstmt = con.prepareStatement(diet_Types);
		}catch (Exception e1) {
		e1.printStackTrace();
		System.err.println("ModifyMealPlanServlet.java--->"+e1.getMessage());
	}
	try{				
			pstmt.setString(1, diettypeauto);
			rst = pstmt.executeQuery();
			while(rst != null && rst.next()){
				String diet_Type = rst.getString(1);
				short_Desc = rst.getString(2).replace(",","");
				list.add(diet_Type);
				list.add(short_Desc);
			}				
	if(rst!=null) rst.close();
	}catch(Exception ee){
		ee.printStackTrace();
		System.err.println("ModifyMealPlanServlet.java in fecthDietTypes--->"+ee.getMessage());
	}
	finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null)ConnectionManager.returnConnection(con);
		}catch(Exception e){}
	}
	return list;
}
//Added Against ML-MMOH-CRF-0674 Ends here

//Added for MMS-KH-CRF-0029.1 - US009 Start
public ArrayList<String> modifyMeal(HttpServletRequest request,HttpServletResponse response)
{
	con = ConnectionManager.getConnection(request);	
	ArrayList<String> modify_menu = new ArrayList<String>();
	String num="";
	String ing_1="";
	try{
		//String language_Id =  request.getParameter("language_Id");	//Common-ICN-0044
		String facility	=  request.getParameter("facility");
		String encounterID	=  request.getParameter("encounter");
		String fromDate	=  request.getParameter("fromDate");
		String dateTo = request.getParameter("dateTo");	
		item_Code = request.getParameter("item_Code");	
		String Modify_meal = "Select ds_drug_interaction(?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy')) ing from dual";
		//Common-ICN-0044
		ResultSet rs1 = null;	
		ResultSet rs2 = null;	
		PreparedStatement pstmt2 = null;	
		//Common-ICN-0044
		pstmt = con.prepareStatement(Modify_meal);
		pstmt.setString(1,facility);
		pstmt.setString(2,encounterID);
		pstmt.setString(3,fromDate);				
		pstmt.setString(4,dateTo);				
		rst = pstmt.executeQuery();
		if( rst!=null && rst.next())
		{
			ing_1=checkForNull(rst.getString("ing"));
		}
		if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
		if(rst!=null) rst.close();	//Added Against Common-ICN-0031
		String strArray1[] = ing_1.split("!");
		
		String strArray[] = strArray1[1].split(",");
		for (int j=0; j < strArray.length; j++)
		{
			String sql="SELECT 1 FROM ds_food_item_ingredients b WHERE b.food_item_code = '"+item_Code+"' AND b.ingredient_code = '"+strArray[j]+"' AND NVL(b.EFF_STATUS,'!') = 'E'";			
			pstmt1 = con.prepareStatement(sql);
			rs1 = pstmt1.executeQuery();

			if(rs1 != null && rs1.next()){
			num = rs1.getString(1);
			}
			if(pstmt1!=null) pstmt1.close();	//Added Against Common-ICN-0031
			if(rs1!=null) rs1.close();	//Added Against Common-ICN-0031
			if(num.equals("1"))
			{
				String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status,f.drug_code FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+strArray[j]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_Code+"'AND c.ingredient_code = e.ingredient_code And a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";	
				
				 pstmt2 = con.prepareStatement(sql1);
				 rs2 = pstmt2.executeQuery();
				
				while(rs2 != null && rs2.next()){
				String one = rs2.getString(1);
				String two = rs2.getString(2);
				String thr = rs2.getString(3);
				String four = rs2.getString(4);
				String five = rs2.getString(5);
				String six = rs2.getString(6);
				String sev = rs2.getString(7);
				String eig = rs2.getString(8);
				String nin = rs2.getString(9);
				
				modify_menu.add(fromDate);
				modify_menu.add(one);
				modify_menu.add(two);
				modify_menu.add(thr);
				modify_menu.add(four);
				modify_menu.add(five);
				modify_menu.add(six);
				modify_menu.add(sev);
				modify_menu.add(eig);
				modify_menu.add(nin);
				if(pstmt2!=null) pstmt2.close();	//Added Against Common-ICN-0031
				if(rs2!=null) rs2.close();	//Added Against Common-ICN-0031
				}
			}
		}
	}
	catch(Exception ee){
		ee.printStackTrace();
	}
	finally {
		try {
			ConnectionManager.returnConnection(con);
		} 
		catch(Exception es){
			es.printStackTrace() ;
		}
	}

return modify_menu;	
				}
//Added for MMS-KH-CRF-0029.1 - US009 End
}
