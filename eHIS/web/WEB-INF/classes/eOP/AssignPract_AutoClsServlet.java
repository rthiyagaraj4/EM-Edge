/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

import eOP.QmgmtRe_AssignPract.*;

public class AssignPract_AutoClsServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;

	Connection conn;

	PreparedStatement pstmt = null;

	ResultSet rset = null;

	String encounterid = "";
	String patientid = "";
	String asslocncode = ""; 
	String asslocntype = "";
	String assvisittypecode = "";
	String queue_num = "";
	String service_code = "";
	String practitionerId = "";
	String practid = "";
	String pmode = "";
	String curlocncode = "";
	String curlocntype = "";
	String curvisittypecode = "";
	String asspractid = "";
	String facilityId = "";
	String client_ip_address;
	String locale = "";	
	String cnt_str = "";
	String pract_val = "";
	String locntype = "";
	String locncode = "";
	String curpracttype = "";
	String open_to_all_pract_yn = "";
	String emsg = "";
	String IDENT_AT_CHECKIN = "";
	String other_res_type = "";
	String other_res_code = "";
	String subservice_code = "";
	String visitcase = "";
	String episode_visit_num = "";
	String arr_date_time = "";
	String episode_id = "";
	String room_change = "";
	String room_cur = "";
	String room_num = "";
	String appt_id = "";
	String appt_walk_ind = "";
	String curpractid = "";
	int pat_cnt;
	String queue_id = "";
	String p_team_id = "";
	String p_queue_date = "";	
	StringBuffer errBuffer = new StringBuffer();
	String speciality = "";	
	String error = "";
	String module_id = "";
	String ass_tmt_area_time = "";
	String tmt_area_code = "";
	String priority_zone = "";
	String prev_status = "";
	
	HashMap tabdata = new HashMap();

 
	HttpSession session=null;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		

        session = req.getSession(false);
		this.facilityId = (String) session.getValue("facility_id");
		this.conn = ConnectionManager.getConnection(req);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");				
		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();		

			assignPractForAutoClose(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, req);
		}
	}

	private void assignPractForAutoClose(HttpServletRequest req,
			HttpServletResponse res) {

			int updtd_rec_cnt=0;
			int not_updtd_cnt = 0;
			int recToBean = 0;
			String strBLMessage = "0";

			try {

			out.println("<html><script>");
			cnt_str = req.getParameter("pract_cnt");
			module_id = req.getParameter("module_id");
			pat_cnt = Integer.parseInt(cnt_str);

			for (int i=1;i<=pat_cnt;i++) {

				pract_val=req.getParameter("ass_pract_val"+i);	
				
				getParams(pract_val);			

				if( !(asspractid.equals("")) )
				{
					InsertTabdata(req);						
			
					boolean insertable = false;

				try {				

					int cnt1 = 0;
					String sql1 = "";
					
					if (open_to_all_pract_yn.equals("N")) {
						sql1 = "select count(*) from op_visit_type a, OP_PRACT_FOR_CLINIC b where a.FACILITY_ID='"
								+ facilityId
								+ "' and a.visit_type_code='"
								+ assvisittypecode
								+ "' and a.facility_id=b.facility_id and b.CLINIC_CODE='"
								+ asslocncode
								+ "' and b.PRACTITIONER_ID='"
								+ asspractid
								+ "' and decode(a.visit_type_ind,'F',b.fi_visit_type_appl_yn,        'L',b.fu_visit_type_appl_yn,'R',b.rt_visit_type_appl_yn,'E',b.em_visit_type_appl_yn,  'S',b.sr_visit_type_appl_yn,'C',b.cs_visit_type_appl_yn)='Y' ";
					} else {
						sql1 = "select count(*) from OP_VISIT_TYPE_FOR_CLINIC where facility_id='"
								+ facilityId
								+ "' and clinic_code='"
								+ asslocncode
								+ "' and visit_type_code='"
								+ assvisittypecode + "' ";
					}
					pstmt = conn.prepareStatement(sql1);
					rset = pstmt.executeQuery();
					if (rset != null) {
						if (rset.next()) {
							cnt1 = rset.getInt(1);
						}
					}
					if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();
					if (cnt1 != 0) {
						insertable = true;
						emsg = "";
					} else {
						insertable = false;
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale,
								"VISIT_TYPE_NOT_APPL_PRACT", "Common");
						emsg = (String) mesg.get("message");
						
					}				
			} catch (Exception e) {
				insertable = false;
				e.printStackTrace();
			}
			
			if (insertable) {
				recToBean++;
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter(
						"LOCAL_EJBS") != null)
						&& (getServletConfig().getServletContext()
								.getInitParameter("LOCAL_EJBS")
								.equalsIgnoreCase("TRUE")))
					local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance()
						.getHome("java:comp/env/QmgmtRe_AssignPractManager",
								QmgmtRe_AssignPractHome.class, local_ejbs);
				Object busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = tabdata;
				Class[] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();

				java.util.HashMap results = (java.util.HashMap) (busObj
						.getClass().getMethod("updatePrEncounter", paramArray))
						.invoke(busObj, argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);

				boolean inserted = (((Boolean) results.get("status"))
						.booleanValue());

				error = (String) results.get("error");	

				
				try {
					strBLMessage = (String) results.get("bl_message");
					if ((strBLMessage == null) || (strBLMessage.equals(" "))) {
						strBLMessage = "0";
					}
				} catch (Exception exceptionBL) {
					strBLMessage = "0";
					exceptionBL.printStackTrace();
				}							
				
				if(inserted)
					updtd_rec_cnt++;
				else
					not_updtd_cnt++;

						argArray = null;
						paramArray = null;						
						results.clear();
						tabdata.clear();

				} 
				else {
				out.println("alert(\"" + emsg
						+ "\");");
				}
				}
			    }
				if(recToBean>0)
				{
					if(updtd_rec_cnt>0)
					{	

							MessageManager mm = new MessageManager();
							final java.util.Hashtable mesg = mm.getMessage(
									locale, "RECORD_MODIFIED", "SM");
							String msg1 = (String) mesg.get("message");	
							out.println("alert('" + msg1
									+ " for " + updtd_rec_cnt + " records ');");	

							if (error.lastIndexOf("<br>") >= 0)
								error = error.substring(0, error.lastIndexOf("<br>"));	

							if (!(strBLMessage.equals("0"))) {
							out.println("<script language='JavaScript'>alert('"
								+ strBLMessage + "'); </script>");
							}
							session.removeAttribute("financial_details");
					}					
					
					if(not_updtd_cnt>0) {
						
						out.println("alert(\"" + error
							+ "\");");
					}					
						
				   }	
				   out.println("parent.frames(2).location.href='../eOP/jsp/AssignPractForAutoClose.jsp?module_id="+module_id+"';parent.frames(3).location.href='../eCommon/html/blank.html';");

				   out.println("</script></html>");
				   
		
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void getParams(String prValue) {
		if(prValue != null) {

			StringTokenizer st = new StringTokenizer(prValue,"|");		
		
			while (st.hasMoreTokens()) {

					encounterid = st.nextToken();
					patientid = st.nextToken();
					locncode = st.nextToken();
					locntype = st.nextToken();
					assvisittypecode = st.nextToken();
					queue_num = st.nextToken();
					service_code = st.nextToken();					
					open_to_all_pract_yn = checkNull(st.nextToken());
					curpractid = st.nextToken();
					appt_walk_ind = st.nextToken();
					p_queue_date = st.nextToken();
					speciality = st.nextToken();
					curpracttype = checkNull(st.nextToken());
					other_res_type = checkNull(st.nextToken());
					other_res_code = checkNull(st.nextToken());
					room_num = checkNull(st.nextToken());
					subservice_code = checkNull(st.nextToken());
					queue_id = checkNull(st.nextToken());
					visitcase = checkNull(st.nextToken());
					episode_id = checkNull(st.nextToken());
					episode_visit_num = checkNull(st.nextToken());
					appt_id = checkNull(st.nextToken());
					ass_tmt_area_time = checkNull(st.nextToken());
					tmt_area_code = checkNull(st.nextToken());
					priority_zone = checkNull(st.nextToken());
					prev_status = checkNull(st.nextToken());

					if(st.hasMoreTokens())
						asspractid = st.nextToken();
					else 
						asspractid ="";

					/*if(st.hasMoreTokens())
						curpracttype = checkNull(st.nextToken());
					else
						curpracttype="";
					*/
						
				}			
		}
		 		 
		 
		 curlocntype = locntype;
		 curlocncode = locncode;
		 asslocntype = locntype;
		 asslocncode = locncode;
		 curvisittypecode = assvisittypecode;	
		 practid = curpractid;
     	 room_change = room_num	;
		 room_cur = room_num ;
			
	}

	public void InsertTabdata(HttpServletRequest req) {

		if(module_id.equals("OP"))
		{

				tabdata.put("facilityId", facilityId);
				tabdata.put("patientid", checkNull(patientid));
				tabdata.put("locntype", checkNull(locntype));
				tabdata.put("locncode", checkNull(locncode));
				tabdata.put("encounterid", checkNull(encounterid));		
				tabdata.put("queue_num", queue_num);
				tabdata.put("pmode", checkNull(req.getParameter("pmode")));
				tabdata.put("curlocncode", checkNull(curlocncode));
				tabdata.put("curlocntype", checkNull(curlocntype));
				tabdata.put("asslocncode", asslocncode);
				tabdata.put("asslocntype", asslocntype);
				tabdata.put("asspractid", asspractid);
				tabdata.put("curvisittypecode", checkNull(curvisittypecode));
				tabdata.put("assvisittypecode", checkNull(assvisittypecode));
				tabdata.put("chg_flag", checkNull(req.getParameter("chg_flag")));
				tabdata.put("service_code", checkNull(service_code));
				tabdata.put("client_ip_address", client_ip_address);		
				String bl_install_yn=req.getParameter("bl_install_yn")==null?"N":req.getParameter("bl_install_yn");
				tabdata.put("bl_install_yn",bl_install_yn );
				tabdata.put("unlinkapptcaseyn", checkNull(req
						.getParameter("unlinkapptcaseyn")));
				tabdata.put("curpractid", curpractid);
				tabdata.put("curpracttype", curpracttype);
				tabdata.put("IDENT_AT_CHECKIN", IDENT_AT_CHECKIN);
				tabdata.put("other_res_type", other_res_type);
				tabdata.put("other_res_code", other_res_code);
				tabdata.put("subservice_code", subservice_code);
				tabdata.put("visitcase", visitcase);
				tabdata.put("episode_visit_num", episode_visit_num);
				tabdata.put("ARRIVE_DATE_TIME", arr_date_time);

				tabdata.put("episode_id", episode_id);
				tabdata.put("room_cur", room_cur);
				tabdata.put("room_change", room_change);
				tabdata.put("p_queue_date", p_queue_date);
				tabdata.put("room_num", room_num);
				tabdata.put("appt_id", appt_id);
				tabdata.put("appt_walk_ind", appt_walk_ind);
				tabdata.put("practid", practid);
				tabdata.put("queue_id", queue_id);
				tabdata.put("p_team_id", p_team_id);			

				if(bl_install_yn.equalsIgnoreCase("Y")){
				HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");		
				tabdata.put("fin_dtls",(HashMap)fin_dtls);		
				}	
		}
		else {
				tabdata.put("practitioner_id", asspractid);
				tabdata.put("locn_code", checkNull(locncode));
				tabdata.put("locn_type", checkNull(locntype));	
				tabdata.put("previous_status", prev_status);
				tabdata.put("selection_mode", "AssignTreatmentArea");
				tabdata.put("visit_type_code", checkNull(curvisittypecode));
				tabdata.put("pract_type", curpracttype);
				tabdata.put("login_user_id", (String) session.getValue("login_user"));
				tabdata.put("assign_tmt_area_time", ass_tmt_area_time);					tabdata.put("prev_tmt_area_code", tmt_area_code);
				tabdata.put("episode_visit_num", episode_visit_num);
				tabdata.put("locale", locale);

				tabdata.put("priority_value", priority_zone);
				tabdata.put("queue_status", "02");
				tabdata.put("login_at_ws_no", req.getRemoteAddr());	
				tabdata.put("episode_id", episode_id);

				String bl_install_yn=req.getParameter("bl_install_yn")==null?"N":req.getParameter("bl_install_yn");
				tabdata.put("bl_install_yn", bl_install_yn);
				tabdata.put("queue_date", p_queue_date);
				tabdata.put("patient_id", checkNull(patientid));
				tabdata.put("facility_id", facilityId);
				tabdata.put("treatment_area_code", tmt_area_code);
				tabdata.put("encounter_id", checkNull(encounterid));
				
			    
		}

	}
	
	public static String checkNull(String str) {
		return ((str == null || str.equals("null") || str.equals(" ")) ? "" : str);
	}

}
