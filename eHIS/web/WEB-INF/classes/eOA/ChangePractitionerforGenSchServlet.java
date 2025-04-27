/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;


import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.net.URLEncoder;
import com.ehis.util.*;


import eOA.ChangePractitionerforGenSch.*;

public class ChangePractitionerforGenSchServlet extends javax.servlet.http.HttpServlet {

PrintWriter out;
java.util.Properties p;

String facilityId;
String client_ip_address ;
String L_clinic_id ="";
String arrDate;
String status="Y";

String finalvals ="";
String fromDate="";
String toDate="";
String remarks="";
String reason="";
String fid="";
String fromPract="";
String toPract="";
int L_fetched_count;
int L_selected_count;
Integer L_fetched_count_big;
Integer L_selected_count_big;

int  rsval = 0;

String day="";

String genrep ="";
String datval = "";
String sqlrep ="";
String datsql ="";

String locncode ="";
String p_report_id ="";
String p_module_id ="";
String P_Report_Title ="";
String[] dateDetail;
String locationType="";
String resourceType="";
String resource_value="";
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

  public void init(ServletConfig config) throws javax.servlet.ServletException {
	  super.init(config);
  }

  public synchronized  void doPost(HttpServletRequest req,HttpServletResponse res) throws javax.servlet.ServletException,IOException {

	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;
	String locale=(String)session.getAttribute("LOCALE");


	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	fid=p.getProperty( "login_user" ) ;

     try {
		this.out = res.getWriter();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		 con = ConnectionManager.getConnection(req);
		String noofrec = req.getParameter("no_of_rec");
		if (noofrec == null ||noofrec.equals(""))
		{
		  noofrec = "0";
		}
		String selrec=req.getParameter("sel_rec");
		if (selrec == null ||selrec.equals(""))
		{
		  selrec = "0";
		}
		 L_fetched_count = Integer.parseInt(noofrec);
		 L_selected_count = Integer.parseInt(selrec);

		 L_fetched_count_big = new Integer(L_fetched_count);
		 L_selected_count_big= new Integer(L_selected_count);


		  day = req.getParameter("day")==null ?"":req.getParameter("day");
		  fromDate = req.getParameter("eff_from")==null ?"":req.getParameter("eff_from");
		  toDate = req.getParameter("eff_to")==null ?"":req.getParameter("eff_to");
		  remarks = req.getParameter("reason")==null ?"":req.getParameter("reason");
		  reason = req.getParameter("reason_code")==null ?"":req.getParameter("reason_code");
		  finalvals = req.getParameter("final_vals")==null ?"":req.getParameter("final_vals");
		  genrep = req.getParameter("genrep")==null ?"":req.getParameter("genrep");
			if((genrep== null)||(genrep.equals("null"))||(genrep.equals(""))) genrep ="N";

		  fromPract = req.getParameter("P_Practitioner_Id")==null ?"":req.getParameter("P_Practitioner_Id");
		  toPract = req.getParameter("P_To_Practitioner_Id")==null ?"":req.getParameter("P_To_Practitioner_Id");
		  locncode = req.getParameter("locncode")==null ?"":req.getParameter("locncode");
		  p_module_id = req.getParameter("p_module_id")==null ?"":req.getParameter("p_module_id");
		  p_report_id = req.getParameter("p_report_id")==null ?"":req.getParameter("p_report_id");
		  P_Report_Title = req.getParameter("P_Report_Title")==null ?"":req.getParameter("P_Report_Title");
          
          locationType=req.getParameter("locnType")==null?"":req.getParameter("locnType");
		  resourceType=req.getParameter("resType")==null?"":req.getParameter("resType");
		  resource_value=req.getParameter("resource_value")==null?"":req.getParameter("resource_value");

		fromDate=DateUtils.convertDate(fromDate,"DMY",locale,"en");
		toDate=DateUtils.convertDate(toDate,"DMY",locale,"en");

		// con = ConnectionManager.getConnection(req);
		 datsql ="select to_char(sysdate,'ddmmyyyyhh24miss') dttm from dual";

   		 pstmt=con.prepareStatement(datsql);

		 rs=pstmt.executeQuery();
		 rs.next();
		 datval =(String)rs.getString("dttm");


		  StringTokenizer st = new StringTokenizer(locncode,"|");
		  while(st.hasMoreTokens())
		  {
	            L_clinic_id = st.nextToken();
	            st.nextToken();
	            st.nextToken();

	      }
          StringTokenizer st1 = new StringTokenizer(finalvals,"~");
	  dateDetail = new String[st1.countTokens()];
	status="Y";

	  int incr = 0;
 		  while(st1.hasMoreTokens())
 		  {
		      arrDate = st1.nextToken();
		      dateDetail[incr] = arrDate;
		      incr++;

		  if(genrep.equals("Y"))
		  {
			GenReport(req,res);
		  }

		  }

	if(genrep.equals("Y"))
		{
			res.sendRedirect("../eOA/jsp/GenReport.jsp?P_From_Date="+fromDate+"&P_To_Date="+toDate+"&P_user_id="+fid+"&P_Day_No="+day+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&P_Facility_id="+facilityId+"&P_Clinic_Code="+L_clinic_id+"&P_Practitioner_Id="+fromPract+"&P_to_practitioner_id="+toPract+"&P_Reason="+remarks+"&P_Event_Date="+datval+"&P_Report_Title="+P_Report_Title );
		}
      else
	{

	  updateChgPractitioner();
	}

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

     } catch(Exception e) {
		 //out.println("Error " +e);
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		 }
      finally{

		ConnectionManager.returnConnection(con,req);
	  }
  }


//Method
private void GenReport(HttpServletRequest req,HttpServletResponse res)
{
	res.setContentType("text/html");
	//Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;


	String addedById = p.getProperty( "login_user" ) ;
	String addedAtWorkstation=client_ip_address;
	String addedFacilityId=facilityId;
	



	try{

     	
rsval=rsval;
	    if (status.equals("Y")){
	     pstmt=con.prepareStatement("delete from oa_appt_list_rep_temp where status='P' ");
	     rsval =pstmt.executeUpdate();
	     status="N";
		 if(pstmt !=null) pstmt.close();
	    }		 

		//Added by Kamatchi S for security issue against COMMON-ICN-0165
		// sqlrep =" insert into oa_appt_list_rep_temp (facility_id,clinic_code,practitioner_id,clinic_date,appl_user_id,event_date,added_by_id,added_date ,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values('"+facilityId+"','"+L_clinic_id+"','"+fromPract+"',to_date('"+arrDate+"','dd/mm/yyyy'),'"+addedById+"',to_date('"+datval+"','dd/mm/yyyyhh24miss'),'"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"')";
		 sqlrep =" insert into oa_appt_list_rep_temp (facility_id,clinic_code,practitioner_id,clinic_date,appl_user_id,event_date,added_by_id,added_date ,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values(?,?,?,to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyyhh24miss'),?,sysdate,?,?,?,sysdate,?,?)";

		 pstmt=con.prepareStatement(sqlrep);
		 pstmt.setString(1, facilityId);
		 pstmt.setString(2, L_clinic_id);
		 pstmt.setString(3, fromPract);
		 pstmt.setString(4, arrDate);
		 pstmt.setString(5, addedById);
		 pstmt.setString(6, datval);
		 pstmt.setString(7, addedById);
		 pstmt.setString(8, addedAtWorkstation);
		 pstmt.setString(9, addedFacilityId);
		 pstmt.setString(10, addedById);
		 pstmt.setString(11, addedAtWorkstation);
		 pstmt.setString(12, addedFacilityId);
		 rsval =pstmt.executeUpdate();
		 con.commit();

		   if (rs != null) rs.close();
		   if (pstmt != null) pstmt.close();

	  }catch(Exception e ){
		  //out.println("Error " +e);
		  e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		  }
	finally{

		
		

		ConnectionManager.returnConnection(con,req);
	}
}//E.o.genreport

  private void updateChgPractitioner() {
     try {
		
		


		if(L_selected_count!=0){

		
		java.util.HashMap passObjects = new java.util.HashMap(); 

		passObjects.put("facilityId",facilityId);
		passObjects.put("client_ip_address",client_ip_address);
		passObjects.put("L_fetched_count_big",L_fetched_count_big);
		passObjects.put("L_selected_count_big",L_selected_count_big);
		passObjects.put("L_clinic_id",L_clinic_id);
		passObjects.put("dateDetail",dateDetail);
		passObjects.put("fromPract",fromPract);
		passObjects.put("toPract",toPract);
		passObjects.put("remarks",remarks);
		passObjects.put("fromDate",fromDate);
		passObjects.put("toDate",toDate);
		passObjects.put("reason",reason);
		passObjects.put("locationType",locationType);
		passObjects.put("resourceType",resourceType);
		passObjects.put("resource_value",resource_value);


		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ChangePractitionerforGenSch",ChangePractitionerforGenSchManagerRemote.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateChgPractitioner",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


       boolean updated = ( ((Boolean) results.get( "status" )).booleanValue() );

       String errors = (String) results.get("error");

       String error_value = "0";
		   if (updated){
			 error_value = "1";
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(errors,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");

		   }else{
			error_value = "0";
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(errors,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");

		   
		   }
		   results.clear();
		   passObjects.clear();
	   } else{
			String error_value = "0";
			String errors = "Error Raised by Servlet";
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(errors,"UTF-8") + "&err_value=" + error_value + "\"</script><body class='message'></html>");

	  }


     } catch(Exception e) {
	   e.printStackTrace();
	  // out.println(e.toString() );
	 }


  }//E.O.Update

}

 
