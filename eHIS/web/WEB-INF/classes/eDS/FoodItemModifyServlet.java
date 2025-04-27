//Newly Created for KDAH-CRF-0359.1
package eDS;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eDS.Common.JSONArray;
import eDS.Common.JSONObject;
import eDS.Common.DlQuery;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
 * File Name  :  FoodItemModifyServlet.java
 */
public class FoodItemModifyServlet extends javax.servlet.http.HttpServlet {	
	PrintWriter out;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	java.util.Properties prop;
	HttpSession session;
	String error_value = "0" ;
	String error = "";
	String locale;
	
	String selectedMenus="";
	String NewFoodItemCode="";
	String NewFoodItemType="";
	String ExistingFoodItem="";
	String facility_id="";
	String Modified_By_Id="";
	String Modified_At_Ws_No="";
	Boolean updateStatus_SuccessFlag=false;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		selectedMenus=request.getParameter("selectedMenus");
		NewFoodItemCode=request.getParameter("NewFoodItemCode");
		ExistingFoodItem=request.getParameter("ExistingFoodItem");
		facility_id=request.getParameter("facility_id");
		Modified_By_Id=request.getParameter("Modified_By_Id");
		Modified_At_Ws_No=request.getParameter("Modified_At_Ws_No");
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		locale = prop.getProperty("LOCALE");
		try
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			MessageManager mm = new MessageManager();
			updateStatus_SuccessFlag=updateStatus(request,response);
		
			if (updateStatus_SuccessFlag){
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
					error = (String) mesg.get("message"); // "APP-SM0070 Operation Completed Successfully ....";
					error_value = "1" ;
					mesg.clear(); //Common-ICN-0044
				}
				else {
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_NOTSAV_TRYAGN", "DS");
					error = (String) mesg.get("message"); //"Record has not been saved. Please try again";
					mesg.clear(); //Common-ICN-0044
				}
					System.err.println("Message=" + error);
					out.println(error);				
				}

		catch (Exception e)
		{
			System.err.println("Exception in FoodItemModifyServlet.java::::" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		}
	}
	
	private boolean updateStatus(HttpServletRequest req, HttpServletResponse res) throws SQLException
	{
		boolean isUpdateSuccess=false;
		try {
		
			con	=	ConnectionManager.getConnection(req);			
			String strQuery_ItemType="select ITEM_TYPE from ds_Food_item where FOOD_ITEM_CODE =?";
			pstmt = con.prepareStatement(strQuery_ItemType);
			pstmt.setString(1,NewFoodItemCode);
			rs=pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				NewFoodItemType=rs.getString(1);
			}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			String strQuery_MenuitemUpdate="update ds_menu_item set item_code =? ,ITEM_TYPE =?,MODIFIED_BY_ID=?,MODIFIED_DATE= SYSDATE,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? where menu_code IN ("+selectedMenus+") and item_code =?";	
			
			pstmt = con.prepareStatement(strQuery_MenuitemUpdate);
			pstmt.setString(1,NewFoodItemCode);
			pstmt.setString(2,NewFoodItemType);
			pstmt.setString(3,Modified_By_Id);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,Modified_At_Ws_No);
		    pstmt.setString(6,ExistingFoodItem);

			int row=pstmt.executeUpdate();			
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("Exception in FoodItemModifyServlet.java::::" + e.toString());
			e.printStackTrace();
			if(con!=null) ConnectionManager.returnConnection(con);
			isUpdateSuccess = false;
		}
		finally {		
			pstmt.close();
			if(isUpdateSuccess)con.commit();
			else con.rollback();
			con.close();
		}
		System.err.println("isUpdateSuccess FoodItemModifyServlet.java::::" + isUpdateSuccess);
		return isUpdateSuccess;
	}
}
