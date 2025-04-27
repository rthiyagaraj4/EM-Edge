 /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           NandhiniM
 */
package eBL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class BLRevenueStageServlet
 */
public class BLRevenueStageServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	String[] record1=null;
	//HashMap support_data = new HashMap();
	String msg="";
	//BLRevenueStageBean bean =new  BLRevenueStageBean(); //IN74043
	StringBuffer sb = new StringBuffer();
	ArrayList CategoryData = new ArrayList();
	String[] finrecord = new String[100];
	String facility_id="",str_user_id="",str_client_ip_address="",login_user="",locale="",mode="";	
	Boolean isUpdateSuccess=false;
	String long_desc="",short_desc="",Order_type="",Revenue_Stage="",p_fm_date="",p_to_date="";
	String order_cat="";
	//to take bean values
	String Ord_typ_bean="",Rev_Stg_bean="",fm_date_bean="";
    	/**
     * @see HttpServlet#HttpServlet()
     */
    public BLRevenueStageServlet() {
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
		// TODO Auto-generated method stub
		//System.err.println("BLRevenueStageservlet start");	
		String error_value = "0" ;
		String error = "";
		boolean flag = true;
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		//this.facility_id = //(String) request.getParameter("facilityId");
		this.facility_id = (String) session.getValue("facility_id");						  
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		locale = prop.getProperty("LOCALE");
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();			
			int cnt=0;			
			con	=	ConnectionManager.getConnection(request);
			con.setAutoCommit(false);	
			//CategoryData= bean.getOrderCategory();	//IN74043	
			order_cat=(String)request.getParameter("order_cat");			
			long_desc=(String)request.getParameter("long_desc");			
			short_desc=(String)request.getParameter("short_desc");
			Order_type=(String)request.getParameter("order_type");			
			Revenue_Stage=(String)request.getParameter("Revenue_Stage");			
			p_fm_date=(String)request.getParameter("p_fm_date");
					
			String orderCategoryExisting  = "";
			String OrderTypeCodeExisting = "";
			String RevenueStageExisting ="";
			String effFromExisting = "";
			String effFromMin = "";
			String effFromMax = "";
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate =sdf.parse(p_fm_date);
				try{					
					pstmt1 = con.prepareStatement("SELECT to_char(MIN(eff_from),'dd/mm/yyyy') eff_from,to_char(nvl(MAX(eff_TO),to_date('01/01/9999','dd/mm/yyyy')),'dd/mm/yyyy') eff_TO FROM bl_order_revenue_stage hdr where   upper(hdr.order_category) like upper('"+order_cat +"%') and upper(hdr.order_type_code) like '"+Order_type+"%'  and OPERATING_FACILITY_ID ='"+facility_id+"'");
					rs1=pstmt1.executeQuery();
					while(rs1 != null && rs1.next()){
						effFromMin = checkForNull(rs1.getString(1));
						effFromMax = checkForNull(rs1.getString(2));
					}

					Date effFromMinDt = null;
					Date tempDate =sdf.parse("01/01/9999"); //IN073854
					if (effFromMin !=null && !effFromMin.equals(""))  
						 effFromMinDt =sdf.parse(effFromMin);						
					Date effFromMaxDt =sdf.parse(effFromMax);							
				
						if ( (effFromMin != null && !effFromMin.equals("")) && ((effFromMinDt.compareTo(fromDate) < 0 && 
						(effFromMaxDt.compareTo(fromDate) > 0 && effFromMaxDt.compareTo(tempDate)!=0) ||effFromMinDt.compareTo(fromDate) == 0  ))){ //IN073854
							error_value = "0" ;
							error = "App-BL0917 Duplicate Record Exists.";		
							isUpdateSuccess	= false;
							//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  "&err_value="+error_value );						//IN073854	
						} else if ((effFromMin != null && !effFromMin.equals("")) && effFromMinDt.compareTo(fromDate) > 0) {		
							Date dateBefore = new Date(effFromMinDt.getTime() - 1 * 24 * 3600 * 1000l);
							String formattedDate = sdf.format(dateBefore);
							String strQuery1="INSERT INTO BL_ORDER_REVENUE_STAGE (OPERATING_FACILITY_ID,ORDER_CATEGORY,LONG_DESC, SHORT_DESC , ORDER_TYPE_CODE,REV_SATGE,EFF_FROM,EFF_TO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,to_date(sysdate,'dd/mm/yyyy'),?,?,?,to_date(sysdate,'dd/mm/yyyy'),?,?)";							
							pstmt = con.prepareStatement(strQuery1);
							pstmt.setString(1,facility_id);
							pstmt.setString(2,order_cat);
							pstmt.setString(3,long_desc);
							pstmt.setString(4,short_desc);
							pstmt.setString(5,Order_type);
							pstmt.setString(6,Revenue_Stage);
							pstmt.setString(7,p_fm_date);
							pstmt.setString(8,formattedDate);		
							pstmt.setString(9,str_user_id);						
							pstmt.setString(10,str_client_ip_address);
							pstmt.setString(11,facility_id);
							pstmt.setString(12,str_user_id);
							pstmt.setString(13,str_client_ip_address);							
							pstmt.setString(14,facility_id);	
							cnt=pstmt.executeUpdate();
							if(cnt<=0) isUpdateSuccess=false;													
							else isUpdateSuccess = true;							
							if (pstmt!=null)   pstmt.close();						
						} else if (effFromMaxDt.compareTo(fromDate) < 0 || (effFromMaxDt.compareTo(fromDate) > 0 || effFromMaxDt.compareTo(tempDate)==0))  {	//IN073854
						//} else if (effFromMaxDt.compareTo(fromDate) > 0) {	
							Date dateBefore = new Date(fromDate.getTime() - 1 * 24 * 3600 * 1000l);
							String formattedDate = sdf.format(dateBefore);							
							String strQuery="UPDATE BL_ORDER_REVENUE_STAGE SET EFF_TO=to_date(?,'dd/mm/yyyy'), MODIFIED_BY_ID='"+str_user_id+"', MODIFIED_DATE =to_date(sysdate,'dd/mm/yyyy'),MODIFIED_AT_WS_NO = '"+str_client_ip_address+"',MODIFIED_FACILITY_ID = '"+facility_id+"' where  ORDER_CATEGORY=? and ORDER_TYPE_CODE=? and EFF_TO is null and OPERATING_FACILITY_ID='"+facility_id+"'";
							pstmt = con.prepareStatement(strQuery);							
							pstmt.setString(1,formattedDate);							
							pstmt.setString(2,order_cat);
							pstmt.setString(3,Order_type);
							cnt=pstmt.executeUpdate();			
							if (pstmt!=null)   pstmt.close();							
							//inserting New row for Changed Revenue Stage 	
							String strQuery1="INSERT INTO BL_ORDER_REVENUE_STAGE (OPERATING_FACILITY_ID,ORDER_CATEGORY,LONG_DESC, SHORT_DESC , ORDER_TYPE_CODE,REV_SATGE,EFF_FROM,EFF_TO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,to_date(sysdate,'dd/mm/yyyy'),?,?,?,to_date(sysdate,'dd/mm/yyyy'),?,?)";	
							pstmt = con.prepareStatement(strQuery1);	
							pstmt.setString(1,facility_id);
							pstmt.setString(2,order_cat);
							pstmt.setString(3,long_desc);
							pstmt.setString(4,short_desc);
							pstmt.setString(5,Order_type);
							pstmt.setString(6,Revenue_Stage);
							pstmt.setString(7,p_fm_date);
							pstmt.setString(8,p_to_date);			
							pstmt.setString(9,str_user_id);						
							pstmt.setString(10,str_client_ip_address);
							pstmt.setString(11,facility_id);
							pstmt.setString(12,str_user_id);
							pstmt.setString(13,str_client_ip_address);							
							pstmt.setString(14,facility_id);	
							cnt=pstmt.executeUpdate();							
							if(cnt<=0)	isUpdateSuccess=false;							
							else 		isUpdateSuccess = true;							
							if (pstmt!=null)   pstmt.close();
						}else {
						String strQuery1="INSERT INTO BL_ORDER_REVENUE_STAGE (OPERATING_FACILITY_ID,ORDER_CATEGORY,LONG_DESC, SHORT_DESC , ORDER_TYPE_CODE,REV_SATGE,EFF_FROM,EFF_TO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,to_date(sysdate,'dd/mm/yyyy'),?,?,?,to_date(sysdate,'dd/mm/yyyy'),?,?)";	
							pstmt = con.prepareStatement(strQuery1);
							pstmt.setString(1,facility_id);						
							pstmt.setString(2,order_cat);
							pstmt.setString(3,long_desc);
							pstmt.setString(4,short_desc);
							pstmt.setString(5,Order_type);
							pstmt.setString(6,Revenue_Stage);
							pstmt.setString(7,p_fm_date);
							pstmt.setString(8,p_to_date);		
							pstmt.setString(9,str_user_id);						
							pstmt.setString(10,str_client_ip_address);
							pstmt.setString(11,facility_id);
							pstmt.setString(12,str_user_id);
							pstmt.setString(13,str_client_ip_address);							
							pstmt.setString(14,facility_id);	
							cnt=pstmt.executeUpdate();							
							if(cnt<=0)	isUpdateSuccess=false;							
							else 		isUpdateSuccess = true;							
							if (pstmt!=null)   pstmt.close();
					}
				}catch(SQLException sqle){
					System.err.println("SQLException in BLRevenueStageServlet" + sqle.toString());
					sqle.printStackTrace();
					isUpdateSuccess = false;
				}catch(Exception e){
					System.err.println("Exception in BLRevenueStageServlet" + e.toString());
					e.printStackTrace();
					isUpdateSuccess = false;				
				}								
			if(isUpdateSuccess){			
				error_value = "1" ;
				error = "APP-SM0070 Operation Completed Successfully ....";
			}else{
				error_value = "0" ;
				error = "APP-BL0917 Duplicate Record Exists.";			
			}		
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);			
			if(pstmt!=null){
			pstmt.close();
			}						
		}catch(SQLException sqle){
			System.err.println("SQLException in BLRevenueStageServlet" + sqle.toString());
			sqle.printStackTrace();
			isUpdateSuccess = false;
		}catch(Exception e){
			System.err.println("Exception in BLRevenueStageServlet" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;			
		}finally{
			try{
				if(isUpdateSuccess){
					con.commit();
				}else{  
					con.rollback();
				}
				if(pstmt!=null){ 
					pstmt.close();
				}
				if(con!=null){ 				
					con.close();
				}
				else{
					con.close();
				}
				//Added against V210416
				if(pstmt1!=null){ 
					pstmt1.close();
				}
				
			}catch(Exception e){
				e.printStackTrace();	
				System.err.println("Final catch Exception in BLRevenueStageServlet" + e.toString());	
			}
		}
	}
	public String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
}