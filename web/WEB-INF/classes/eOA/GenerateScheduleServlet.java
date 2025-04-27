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
import eCommon.Common.CommonBean;
import java.net.URLEncoder;
import com.ehis.util.*; 
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class GenerateScheduleServlet extends javax.servlet.http.HttpServlet	{
	public void init(ServletConfig config)throws ServletException{ 
		super.init(config);
	}
	
	public  void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)throws javax.servlet.ServletException,IOException{
		try{
			GenerateSchedule(httpservletrequest, httpservletresponse);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private void GenerateSchedule(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse){
		Connection con= null;
		CallableStatement cstmt = null;
		PrintWriter out = null;
		Properties p;
		String facilityId;
		String fid;
		String client_ip_address;
		String locncode = null;
		String constr;
		String efffrom;
		String effto;
		String locn;
		String res_type;
		String locn_type;
		boolean inserted;
		//boolean flag=true; //Commented for checkstyle
		try{
			HttpSession httpsession = httpservletrequest.getSession(false);
			facilityId = (String)httpsession.getValue("facility_id");            
			p = (Properties)httpsession.getValue("jdbc");
			client_ip_address = p.getProperty("client_ip_address");
			fid = p.getProperty("login_user");			
			con = ConnectionManager.getConnection(httpservletrequest);
			con.setAutoCommit(false);
			out = httpservletresponse.getWriter();
			String s = "";
			//Added by Kamatchi S for NMC-JD-CRF-0212
			boolean isGenerateSchedule = false;
			isGenerateSchedule=eCommon.Common.CommonBean.isSiteSpecific(con,"OA","OVERLAP_SCH_LOG");
			System.err.println("isGenerateSchedule=============>"+isGenerateSchedule);
			String transactionId = "";
			String overlapValue = "";
			String todaysDate = "";
			String overlapYN= "";
			String overlapValueYN= "N";
			int practCount= 0;
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			Calendar cal = Calendar.getInstance();
			todaysDate=dateFormat.format(cal.getTime());
			transactionId = fid + client_ip_address +todaysDate;
			if(isGenerateSchedule)
			{
			transactionId = transactionId;
			overlapValue = "Y";
			}
			else
			{
			transactionId = "N";
			overlapValue = "N";
			}
			System.err.println("transactionId=============>"+transactionId);
			System.err.println("overlapValue=============>"+overlapValue);
			String locale = p.getProperty("LOCALE");
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			locn = httpservletrequest.getParameter("clinic");
			for(StringTokenizer stringtokenizer = new StringTokenizer(locn, "|"); stringtokenizer.hasMoreTokens();){
				locncode = stringtokenizer.nextToken();
				stringtokenizer.nextToken();
			}
			constr = httpservletrequest.getParameter("con_days");
			efffrom = httpservletrequest.getParameter("eff_from");
			effto = httpservletrequest.getParameter("eff_to");
			locn_type = httpservletrequest.getParameter("locationType");	
			efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
			effto=DateUtils.convertDate(effto,"DMY",locale,"en");
			int i = 0;
			int k=0;	
			StringTokenizer stringtokenizer1 = new StringTokenizer(constr, "|");
			//cstmt = con.prepareCall("{call OA_GENERATE_SCHEDULE_PARAM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ArrayList msg=new ArrayList();
			String res_list="";
			String res_typ_list=""; 
			for(; stringtokenizer1.hasMoreTokens(); inserted = true){
				//if(cstmt != null)cstmt.close();//Commented for checkstyle
				cstmt = con.prepareCall("{call OA_GENERATE_SCHEDULE_PARAM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				String as[] = new String[9];
				as[0] = null;
				as[1] = null;
				as[2] = null;
				as[3] = null;
				as[4] = null;
				as[5] = null;
				as[6] = null;
				as[7] = null;
				as[8] = null;				
				String s2 = stringtokenizer1.nextToken();
				for(StringTokenizer stringtokenizer2 = new StringTokenizer(s2, "-"); stringtokenizer2.hasMoreTokens();){
					as[i] = stringtokenizer2.nextToken();				
					i++;
				}
				k++;
				i = 0;
				inserted = false;				
				String s6 = "";
				res_type = as[1];		
				if(!as[0].equals("Y")){
					int j = res_type.indexOf("*");
					s6 = res_type.substring(0, j);
					if(s6.equals("")){
						res_list="*,";
					}else{
						res_list=s6+",";
					}
					practCount++;
					res_typ_list = res_type.substring(j + 1);				
				}
				cstmt.setString(1, facilityId);
				cstmt.setString(2, locncode);
				cstmt.setString(3, res_list);
				cstmt.setString(4, as[2]);
				cstmt.setString(5, as[3]);
				cstmt.setString(6, as[4]);
				cstmt.setString(7, as[5]);
				cstmt.setString(8, as[6]);
				cstmt.setString(9, as[7]);
				cstmt.setString(10, as[8]);
				cstmt.setString(11, efffrom);
				cstmt.setString(12, effto);
				cstmt.setString(13, as[0]);
				cstmt.setString(14, fid);
				cstmt.setString(15, locn_type);
				cstmt.setString(16, res_typ_list);
				cstmt.setString(17, client_ip_address);	
				System.err.println("p_facility_id ==============="+facilityId);				
				System.err.println("p_clinic_code ==============="+locncode);		
				System.err.println("p_pract_id==============="+res_list);		
				System.err.println("p_day1==============="+as[2]);		
				System.err.println("p_day2==============="+as[3]);		
				System.err.println("p_day3==============="+as[4]);		
				System.err.println("p_day4==============="+as[5]);		
				System.err.println("p_day5==============="+as[6]);		
				System.err.println("p_day6==============="+as[7]);	
				System.err.println("p_day7==============="+as[8]);	
				System.err.println("p_from==============="+efffrom);	
				System.err.println("p_to==============="+effto);	
				System.err.println("p_pract_null==============="+ as[0]);	
				System.err.println("p_user==============="+fid);	
				System.err.println("p_care_locn_type_ind==============="+locn_type);	
				System.err.println("p_resource_class==============="+res_typ_list);	
				System.err.println("p_added_at_ws_no==============="+client_ip_address);	
				System.err.println("p_trans_id==============="+transactionId);	
				System.err.println("p_over_lap_LOG_YN==============="+overlapValue);	

				cstmt.registerOutParameter(18, 12);
				cstmt.setString(19, transactionId);
				cstmt.setString(20, overlapValue);	
				cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
				cstmt.execute();		
				s = cstmt.getString(18);
				overlapYN = checkForNull(cstmt.getString(21));
				
				if(s!=null){
					s=s.trim();
					msg.add(s);
				}
				
				System.err.println("p_err_msg==============="+s);	
				System.err.println("p_over_lap==============="+overlapYN);
				if(overlapYN.equals("Y")) overlapValueYN = "Y";
				if((s.equals("SUCCESS")) || (overlapYN.equals("Y")) ){
					con.commit();
				}else{
					con.rollback();
					if(!s.equals("Schedules Not Generated")){
						//System.out.println("s :"+s);
						//System.out.println("s2 :"+s2);
					}
				}
				if(cstmt!= null) cstmt.close() ; //Added for checkstyle
			}
			for(int m=0;m<msg.size();m++){
				if(((String)msg.get(m)).equals("SUCCESS")){
					s=(String)msg.get(m);
					break;
				}else{
					s=(String)msg.get(m);
				}
			}		
			//if(s.equals("SUCCESS")){ // atleaset one schedule generated in transaction								
			if(s.equals("SUCCESS") && overlapValueYN.equals("N")){ // atleaset one schedule generated in transaction
				java.util.Hashtable message = MessageManager.getMessage(locale, "SCH_GENE_SUCCESSFULLY", "OA");
				String error = ((String) message.get("message"));
				String s5 = "1";
				out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + s5 + "\"</script><body class='message'></html>");			
			}else if(overlapValueYN.equals("Y")  && ((s.equals("Schedules Not Generated") && overlapYN.equals("N")) || (s.equals("Schedules Not Generated") && overlapYN.equals("")) || (s.equals("SUCCESS") && overlapYN.equals("Y")) || (s.equals("SUCCESS") && overlapYN.equals("N")) || (s.equals("SUCCESS") && overlapYN.equals("")) || (s.equals("Schedules Not Generated") && overlapYN.equals("Y")))){ 
				java.util.Hashtable message = MessageManager.getMessage(locale, "NO_RECORDS_FOR_GENE_SCH", "OA");
				String error =((String) message.get("message"));
				out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&transactionId=" + transactionId + "&practCount=" + practCount + "&res_typ_list=" + res_typ_list + "&overlapYN=" + overlapValueYN + "\"</script><body class='message'></html>");		
			}else{ // block to handle an acutual error while generating the schedule				
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));			
				out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");
			}
		}catch(Exception e){
			e.printStackTrace();
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are :<br>" ) ;
		}finally{
			try{
				if(cstmt != null)cstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			if(con != null)  ConnectionManager.returnConnection(con, httpservletrequest);
		}
	}// end mehod

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

} // end class
