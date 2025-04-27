/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS;
import java.text.SimpleDateFormat;
import java.util.*;//MMS-DM-CRF-0043
import java.sql.Date;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.MessageManager;

import eDS.Common.CommonCheckPk;
import eDS.Common.DlQuery;


/**
 * Servlet implementation class DietTypeServlet
 */
public class GenerateMealPlanServlet extends HttpServlet {
    // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String strServDate		=  "";
	String strDietCategory =  "";
	String strkitchen =  "";
	String strMealType =  "";
	String strNursingUnit =  "";
	String strMealClass =  "";
	String strRegnYn =  "";
	String strDietType =  "";
	String[] strDietTypeArray = null;//MMS-DM-CRF-0043
	String strPatientId =  "";
	String strFrequencyYn =  "";
	String strLoginId =  "";
	String strWorkstation =  "";
	String strFeedType =  "";//KDAH-CRF-0352
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	String locale = "";
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
    CallableStatement cstmt = null;
    ResultSet rst = null;
    CommonCheckPk commonChk = null;
    String servingToDate="";//GDOH-CRF-083
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateMealPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


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
		String tab_id = request.getParameter("tab_id");
		int result = 0;
		String error = "",error_value = "";
		if("GenerateMealPlan".equals(tab_id)){
			result = updateMealPlanGenerate(request,response);
		}
		else if("DsMealPlanDischarge".equals(tab_id)){
			result = dischargePatient(request,response);
		}

		this.locale = (String) session.getAttribute("LOCALE");
		MessageManager mm = new MessageManager();
		if(result == 1){
			final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
			error = (String) mesg.get("message"); //"APP-SM0070 Operation Completed Successfully ....";
			mesg.clear(); //Common-ICN-0044
		}
		else if(result == 0){
			final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_EXISTS", "DS");
			error = (String) mesg.get("message"); // "APP-000064 Record Already Exists...";
			mesg.clear(); //Common-ICN-0044
		}
		else if(result == 2){
			final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_NOTSAV_TRYAGN", "DS");
			error = (String) mesg.get("message");  // "Record has not saved. Please try again";
			mesg.clear(); //Common-ICN-0044
		}
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);

	}


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


	private int updateMealPlanGenerate(HttpServletRequest request,HttpServletResponse response) {
         // Checkstyle Violation commented by Munisekhar
		//boolean rslt = false;
		int err_no = 0;
		try{
				session = request.getSession(false);
				String language_id = (String)session.getAttribute("LOCALE");
				strServDate		=  checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("servingDate"),"DMY", language_id, "en"));
				strDietCategory =  checkForNull(request.getParameter("dietCategory"));
				strkitchen =  checkForNull(request.getParameter("kitchen"));
				strMealType =  checkForNull(request.getParameter("mealType"));
				strNursingUnit =  checkForNull(request.getParameter("nursingUnit"));
				strMealClass =  checkForNull(request.getParameter("mealClass"));
				strRegnYn =  checkForNull(request.getParameter("regnYn"));
				strDietType =  checkForNull(request.getParameter("dietType"));
				strDietTypeArray = request.getParameterValues("dietType");//MMS-DM-CRF-0043
				servingToDate=checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("servingToDate"),"DMY", language_id, "en"));//GDOH-CRF-083
				strFeedType =  checkForNull(request.getParameter("feedType"));//KDAH-CRF-0352
				
				//MMS-DM-CRF-0043 Start
				StringBuffer retDietType = new StringBuffer("");
				
		        for (int i = 0; strDietTypeArray != null && i < strDietTypeArray.length; i++) {
		            retDietType.append(strDietTypeArray[i]);
		            if (i < strDietTypeArray.length - 1) {
		                retDietType.append(',');
		            }
		        }
				//MMS-DM-CRF-0043 End	
				
				strPatientId =  checkForNull(request.getParameter("patientId"));				
				strFrequencyYn =  checkForNull(request.getParameter("frequencyYn"));
				this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
				this.facility_id = (String) session.getValue( "facility_id" ) ;
				login_user = this.prop.getProperty( "login_user" ) ;
				client_ip_address = this.prop.getProperty("client_ip_address") ;

				if("on".equals(strRegnYn)){
					strRegnYn = "Y";
				}
				else{
					strRegnYn = "N";
				}

				if("on".equals(strFrequencyYn)){
					strFrequencyYn = "Y";
				}
				else{
					strFrequencyYn = "N";
				}

				Date servDate = new Date(sdf.parse(strServDate).getTime());
				Date servToDate = new Date(sdf.parse(servingToDate).getTime());//GDOH-CRF-083
				con = ConnectionManager.getConnection(request);
				cstmt = con.prepareCall("{call Ds_Meal_Plan_Generation.Proc_Gen_Meal_Plan_Pat(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

				
				/*if(strDietTypeArray != null && strDietTypeArray.length > 0)//MMS-DM-CRF-0043 starts
				{
					
					for(int i = 0; i<strDietTypeArray.length; i++)
					{
						strDietType = strDietTypeArray[i];
						//System.err.println("173====strDietType===="+strDietType);
						
						cstmt.setString(1, facility_id);
						cstmt.setDate(2, servDate);
						cstmt.setString(3, strDietCategory);
						cstmt.setString(4, strkitchen);
						cstmt.setString(5, strMealType);
						cstmt.setString(6, strNursingUnit);
						cstmt.setString(7, strMealClass);
						cstmt.setString(8, strRegnYn);
						cstmt.setString(9, strDietType);
						cstmt.setString(10, strPatientId);
						cstmt.setString(11,strFrequencyYn);
						cstmt.setString(12, login_user);
						cstmt.setString(13, client_ip_address);
						cstmt.registerOutParameter(14, Types.VARCHAR);
						cstmt.execute();
					}
				}//MMS-DM-CRF-0043 ends
				else
				{*/
				System.err.println("facility_id : "+facility_id);
				System.err.println("servDate : "+servDate);
				System.err.println("strDietCategory : "+strDietCategory);
				System.err.println("strkitchen "+strkitchen);
				System.err.println("strMealType "+strMealType);
				System.err.println("strNursingUnit :"+strNursingUnit);
				System.err.println("strMealClass:"+strMealClass);
				System.err.println("strRegnYn:"+strRegnYn);
				System.err.println("strPatientId:"+strPatientId);
				System.err.println("strFrequencyYn:"+strFrequencyYn);
				System.err.println("login_user:"+login_user);
				System.err.println("client_ip_address:"+client_ip_address);
				System.err.println("strFeedType:"+strFeedType);
				
					cstmt.setString(1, facility_id);
					cstmt.setDate(2, servDate);
					cstmt.setDate(3,servToDate);//GDOH-CRF-083
					cstmt.setString(4, strDietCategory);
					cstmt.setString(5, strkitchen);
					cstmt.setString(6, strMealType);
					cstmt.setString(7, strNursingUnit);
					cstmt.setString(8, strMealClass);
					cstmt.setString(9, strRegnYn);
					cstmt.setString(10, retDietType.toString());//MMS-DM-CRF-0043
					cstmt.setString(11, strPatientId);
					cstmt.setString(12,strFrequencyYn);
					cstmt.setString(13, login_user);
					cstmt.setString(14, client_ip_address);
					cstmt.setString(15, strFeedType);//KDAH-CRF-0352
					cstmt.registerOutParameter(16, Types.VARCHAR);	

					cstmt.execute();
					System.err.println("====err_text======"+cstmt.getString(16));
				//}

				err_no = 1;
				con.commit();
	}
	catch(Exception e)
	{
		System.err.println("eDS Exception updateMealPlanGenerate->"+e);
		e.printStackTrace();
		err_no = 2;
	}
	finally{
		try{
			if(cstmt!=null) cstmt.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			System.err.println("Exception in updateMealPlanGenerate:"+e);
		}
	}
		return err_no;
	}



	private int dischargePatient(HttpServletRequest request,HttpServletResponse response) {
         // Checkstyle Violation commented by Munisekhar
		//boolean rslt = false;
		int err_no = 0;
		try{

			strServDate		=  checkForNull(request.getParameter("servingDate"));
			strDietCategory =  checkForNull(request.getParameter("dietCategory"));
			strMealType =  checkForNull(request.getParameter("mealType"));
			Date servDate = new Date(sdf.parse(strServDate).getTime());
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			cstmt = con.prepareCall("{call Ds_Meal_Plan_Generation.Proc_Dis_Patients(?,?,?,?,?,?)}");

				cstmt.setString(1, facility_id);
				cstmt.setDate(2, servDate);
				cstmt.setString(3, strDietCategory);
				cstmt.setString(4, strMealType);
				cstmt.setString(5, login_user);
				cstmt.setString(6, client_ip_address);
				err_no = 1;
				con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception dischargePatient->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(cstmt!=null) cstmt.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in dischargePatient:"+e);
			}
		}
			return err_no;
	}




}

