/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eMR;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.RecordSet;
import com.ehis.util.*;

public class RecordAdverseEventServlet extends HttpServlet implements SingleThreadModel
{
	    
	/*String facilityId="",client_ip_address="", modifiedById="",modifiedAtWorkstation="",mode="",visit_adm_date_time="",assign_care_locn_type="",assign_care_locn_code="",attend_practitioner_id="",adv_event_srl_no="",adv_dtl_srl_num="",other_reaction_main="",
	no_known_allergy="",estimated_date="",final_date="",react_de="",final_date1="",final_date2="";*/
//	String addedAtWorkstation="",addedById="";
	/*Connection conn = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	*/
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		Properties p		= null;
		HttpSession session = null;
		PrintWriter out		= null;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
        session				= req.getSession(false);
        p					= (Properties)session.getValue("jdbc");
		String mode			= "";
		String check_stat	= "";
		String final_val	= "";
		/*facilityId			= (String)session.getValue("facility_id");


       client_ip_address = p.getProperty("client_ip_address");
       modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
       modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	   */
	   String locale		= p.getProperty("LOCALE");

	   
	  // HashMap DETAILS_CODE=(HashMap)session.getAttribute("DETAILS_CODE");
		//DETAILS_CODE = (String)session.getValue("DETAILS_CODE");
		
        try
        {
            res.setContentType("text/html");
            out				= res.getWriter();
            mode			= req.getParameter("mode") != null ? req.getParameter("mode") : "";
			check_stat		= req.getParameter("check_stat");
			if(check_stat==null) check_stat = "";

            if(mode.equalsIgnoreCase("insert"))
			{
                insert(req,res);
			}else if(mode.equalsIgnoreCase("record"))
			{
				if(check_stat.equals("mark_error"))
				{
					final_val = req.getParameter("final_value");
					/*String  count_va = req.getParameter("count_val");
					int count_v = Integer.parseInt(count_va);
					String chk_react = req.getParameter("chk_react");
					int chk_re = Integer.parseInt(chk_react);
*/					
					if(final_val.length() > 0)
					{
						modify(req,res);
					}
					else
					{
						java.util.Hashtable message = MessageManager.getMessage( locale,"NO_SELECTION","IP");
						String mesge = (String) message.get("message");
						//out.println("<script>alert('"+mesge+"');</script>");
						message.clear();
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(mesge,"UTF-8"));
					}
				}else
				{
					modify(req,res);
				}
				
			}
        }
        catch(Exception e)
        {
            //out.println(e.toString());
			e.printStackTrace(System.err);
        }
    }
	
	private void insert(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
		Properties p		= null;
		HttpSession session = null;
		PrintWriter out		= null;
		session				= req.getSession(false);
        p					= (Properties)session.getValue("jdbc");
		out					= res.getWriter();
		Connection conn		= null;
		ResultSet rs		= null;
		//ResultSet rs1		= null;
		Statement stmt		= null;
		//PreparedStatement pstmt=null;
		String facilityId	= "";
		String client_ip_address		= "";
		String modifiedById	= "";
		String modifiedAtWorkstation	= "";
		String locale		= "";
		String PatientId	= "";
		String	certainity	= "";	
		String	severity_head			= "";
		String	adv_event_ind			= "";
		String	adv_event_type			= "";
		String	allergen	= "";
		String	onset_date	= "";
		String Encounter_Id	= "";
		String cause_sub	= "";
		String allergyAlertby	= "";
		String	since_date	= "";
		String route_exp	= "";
		String allergy_test_res			= "";
		String treat_advice	= "";
		String remarks		= "";
		String sou_of_info	= "";
		String react_values_main		= "";
		String diagnosis_code			= "";
		String term_code	= "";
		String status_date	= "";
		String react_code_val			= "";
		String drug_code	= "";
		String status1		= "";
		String count_val	= "";
		String other_reaction_counter_val= "";
		String estimated_duration_yn	= "";
		String Site_Of_Reac_oth			= "";
		String severity_oth				= "";
		String other_reaction_date		= "";
		String other_reaction			= "";
		String visit_adm_date_time		= "";
		String assign_care_locn_type	= "";
		String assign_care_locn_code	= "";
		String attend_practitioner_id	= "";
		String adv_event_srl_no			= "";
		//String adv_dtl_srl_num			= "";
		String other_reaction_main		= "";
		String no_known_allergy			= "";
		//String estimated_date			= "";
		//String final_date				= "";
		//String react_de					= "";
		//String final_date1				= "";
		//String final_date2				= "";
		String reaction_date			= "";
		String reaction_code			= "";
		String severity					= "";
		String Site_Of_Reac_val			= "";
		String AllergyConfirmYN			= "";//Added for the crf - RUT-CRF-0064
		String allergy_conf_reqd_yn			= "N";//Added for the crf - RUT-CRF-0064
		
		/*Below line added for this CRF Bru-HIMS-CRF-133*/		
         String isPatientEncMovement="";
		 String Sydate="";
		 String p_queue_date="";
		 String p_queue_status="";	
		//End Bru-HIMS-CRF-133
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		 String onset_type="";
		 String comments="";
		 /*end ML-MMOH-CRF-0366 */
		 String otherAllergenFreeTxt = "";//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
		
		try
        {

			facilityId			= (String)session.getValue("facility_id");
			client_ip_address	= p.getProperty("client_ip_address");
			modifiedById		= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
			modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
			locale				= p.getProperty("LOCALE");
			conn				= ConnectionManager.getConnection(req);
			stmt				= conn.createStatement();
			java.sql.Date added_date  = null; 
			PatientId			= req.getParameter("PatientId");
			if(PatientId ==null) PatientId="";
			
			certainity			= req.getParameter("certainity");
			if(certainity ==null) certainity="";

			severity_head		= req.getParameter("severity_head");
			if(severity_head ==null) severity_head="";
			
			adv_event_ind		= req.getParameter("adv_event_ind");
			if(adv_event_ind==null)adv_event_ind="";

			adv_event_type		= req.getParameter("adv_event_type");
			if(adv_event_type==null) adv_event_type="";

			allergen			= req.getParameter("allergen_id");
			if(allergen ==null) allergen="";
			
			otherAllergenFreeTxt = checkForNull(req.getParameter("allergen_free_text"));//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
			
			onset_date			= req.getParameter("onset_date"); 
			if(onset_date ==null) onset_date="";

			Encounter_Id		= req.getParameter("Encounter_Id");
			if(Encounter_Id ==null) Encounter_Id="";

			cause_sub			= req.getParameter("cause_sub");
			if(cause_sub ==null) cause_sub="";
			allergyAlertby			= req.getParameter("allergyAlertby");
			if(allergyAlertby ==null) allergyAlertby="";

			since_date			= req.getParameter("since_date");
			if(since_date ==null) since_date="";

			route_exp			= req.getParameter("route_of_expo");
			if(route_exp==null) route_exp="";

			//String severity=req.getParameter("severity");
			//if(severity ==null) severity="";
			//String reaction_date=req.getParameter("reaction_date");
			//if(reaction_date ==null) reaction_date="";
			//String other_reaction=req.getParameter("other_reaction");
			//if(other_reaction ==null) other_reaction="";
			//String Site_Of_Reac=req.getParameter("Site_Of_Reac");
			//if(Site_Of_Reac ==null) Site_Of_Reac="";
			allergy_test_res	= req.getParameter("allergy_test_res");
			if(allergy_test_res ==null) allergy_test_res="";

			treat_advice		= req.getParameter("treat_advice");
			if(treat_advice ==null) treat_advice="";

			remarks				= req.getParameter("remarks");
			if(remarks==null) remarks="";

			sou_of_info			= req.getParameter("sou_of_info");
			if(sou_of_info==null) sou_of_info="";

			//req.getParameter("react_values_main");
			//if(react_values_main ==null) react_values_main="";
			diagnosis_code		= req.getParameter("diagnosis_code");
			if(diagnosis_code ==null) diagnosis_code="";
			
			term_code			= req.getParameter("term_code");
			if(term_code==null) term_code="";

			status_date			= req.getParameter("date_time");
			if(status_date ==null)status_date="";

			react_code_val		= req.getParameter("react_code_final1");
			if(react_code_val ==null) react_code_val="";

			drug_code			= req.getParameter("drug_code");
			if(drug_code ==null) drug_code="";

			status1				= req.getParameter("status_val");
			if(status1 ==null) status1="";

			count_val			= req.getParameter("count_val");
			if(count_val ==null) count_val="";

			other_reaction_counter_val=	req.getParameter("oth_reaction_counter");
			if(other_reaction_counter_val ==null) other_reaction_counter_val="";

			 no_known_allergy = req.getParameter("no_known_allergy");
			if(no_known_allergy ==null) no_known_allergy="";

			AllergyConfirmYN=req.getParameter("AllergyConfirmYN");//Added for the crf RUT-CRF-0064
			if(AllergyConfirmYN ==null) AllergyConfirmYN="N";
			allergy_conf_reqd_yn = req.getParameter("allergy_conf_reqd_yn");
			if(allergy_conf_reqd_yn==null)allergy_conf_reqd_yn="N";
			estimated_duration_yn = req.getParameter("estimated_duration_yn");
			if(estimated_duration_yn == null) estimated_duration_yn="N";
          
		  /*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
			onset_type= req.getParameter("onset_type");
			if(onset_type == null)
			 onset_type="";
			comments=req.getParameter("comments");
			if(comments == null)
			  comments=""; 
            
			/*end ML-MMOH-CRF-0366 */
            /*below line added for this CRF Bru-HIMS-CRF-133*/
            isPatientEncMovement=req.getParameter("isPatientEncMovement")==null?"":req.getParameter("isPatientEncMovement");
            Sydate=req.getParameter("Sydate")==null?"":req.getParameter("Sydate");
            p_queue_date=req.getParameter("p_queue_date")==null?"":req.getParameter("p_queue_date");
            p_queue_status=req.getParameter("p_queue_status")==null?"":req.getParameter("p_queue_status");
            //End Bru-HIMS-CRF-133*		 
 	   

    		/*String Site_Of_Reac_oth=req.getParameter("Site_Of_Reac_oth");
			if(Site_Of_Reac_oth ==null) Site_Of_Reac_oth="";
			String severity_oth=req.getParameter("severity_oth");
			if(severity_oth ==null) severity_oth="";

			String other_reaction_date=req.getParameter("other_reaction_date");
			if(other_reaction_date ==null) other_reaction_date="";
			String other_reaction=req.getParameter("reaction_oth");
			if(other_reaction ==null) other_reaction="";*/

			onset_date			= DateUtils.convertDate(onset_date,"DMYHMS",locale,"en");
			status_date			= DateUtils.convertDate(status_date,"DMY",locale,"en");
			since_date			= DateUtils.convertDate(since_date,"DMY",locale,"en");
			/*other_reaction_date=DateUtils.convertDate(other_reaction_date,"DMYHM",locale,"en");*/

			int counter		=	0;
			counter			= Integer.parseInt(count_val);
			int other_reaction_counter = 0;
			other_reaction_counter = Integer.parseInt(other_reaction_counter_val);

			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			added_date = java.sql.Date.valueOf( addedDate ) ;

			try
			{
				String sql_pr_encounter = "select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy') VISIT_ADM_DATE_TIME ,ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE,ATTEND_PRACTITIONER_ID from pr_encounter where patient_id='"+PatientId+"'and ENCOUNTER_ID='"+Encounter_Id+"' and FACILITY_ID='"+facilityId+"' ";
				rs=stmt.executeQuery(sql_pr_encounter);
				if(rs !=null && rs.next())
				{
					 visit_adm_date_time	= rs.getString("VISIT_ADM_DATE_TIME");
					 if(visit_adm_date_time ==null) visit_adm_date_time="";
					 assign_care_locn_type	= rs.getString("ASSIGN_CARE_LOCN_TYPE");
					 if(assign_care_locn_type ==null) assign_care_locn_type="";
					 assign_care_locn_code	= rs.getString("ASSIGN_CARE_LOCN_CODE");
					 if(assign_care_locn_code==null) assign_care_locn_code="";
					 attend_practitioner_id	= rs.getString("ATTEND_PRACTITIONER_ID");
					 if(attend_practitioner_id==null) attend_practitioner_id="";
				 }
				if(rs !=null) rs.close();
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			
			try
			{
				String sql_srl_num_one = "select nvl(max(ADV_EVENT_SRL_NO),0)+1 ADV_EVENT_SRL_NO from PR_ALLERGY_SENSITIVITY where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
				rs=stmt.executeQuery(sql_srl_num_one);
				if(rs !=null && rs.next())
				 {
					adv_event_srl_no = rs.getString("ADV_EVENT_SRL_NO");
					if(adv_event_srl_no ==null) adv_event_srl_no="";
				 }
				if(rs !=null) rs.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}

			try
			{
				for (int i=0;i<=counter-1 ;i++ )
				{
					reaction_date = req.getParameter("reaction_date"+i);

					reaction_date = DateUtils.convertDate(reaction_date,"DMYHM",locale,"en");

					reaction_code = req.getParameter("reaction_code"+i);
					severity=req.getParameter("severity"+i);
					if(severity.equals("")) severity="$";

					Site_Of_Reac_val = req.getParameter("Site_Of_Reac"+i);
					if(Site_Of_Reac_val.equals("")) Site_Of_Reac_val="$";
					
					react_values_main = react_values_main+"@"+reaction_date +"`"+reaction_code+"`"+severity+"`"+Site_Of_Reac_val;

				
				}
			}
			catch (Exception e3)
			{
				e3.printStackTrace();
			}
			
			/*if(!other_reaction.equals(""))
			{
			if(severity_oth.equals("")) severity_oth="$";
			if(Site_Of_Reac_oth.equals("")) Site_Of_Reac_oth="$";
			other_reaction_main=other_reaction_date+"*"+other_reaction+"*"+severity_oth+"*"+Site_Of_Reac_oth;
			}else
			{
				other_reaction_main="";
			}*/

			try
			{
				for (int i=0;i<=other_reaction_counter-1 ;i++ )
				{
					other_reaction_date = req.getParameter("other_reaction_date"+i);
					other_reaction_date = DateUtils.convertDate(other_reaction_date,"DMYHM",locale,"en");
					other_reaction      = req.getParameter("reaction_oth"+i);
					severity_oth        = req.getParameter("severity_oth"+i);
					if(severity_oth.equals("")) severity_oth="$";
					Site_Of_Reac_oth=req.getParameter("Site_Of_Reac_oth"+i);
					if(Site_Of_Reac_oth.equals("")) Site_Of_Reac_oth="$";
					
					other_reaction_main = other_reaction_main+"@"+other_reaction_date +"`"+other_reaction+"`"+severity_oth+"`"+Site_Of_Reac_oth;
				
				}
			}
			catch (Exception e4)
			{
				e4.printStackTrace();
			}
			
			HashMap hashmap = new HashMap();
            hashmap.put("p", p);
			hashmap.put("PatientId",PatientId);
            hashmap.put("certainity", certainity);
           // hashmap.put("severity_head", severity_head);
            hashmap.put("adv_event_ind", adv_event_ind);
            hashmap.put("adv_event_type", adv_event_type);
            hashmap.put("allergen", allergen);
			hashmap.put("otherAllergenFreeTxt", otherAllergenFreeTxt);//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
            hashmap.put("onset_date", onset_date);
			hashmap.put("Encounter_Id",Encounter_Id);
			hashmap.put("cause_sub", cause_sub);
			hashmap.put("allergyAlertby", allergyAlertby);
			hashmap.put("route_exp",route_exp);
           // hashmap.put("severity", severity);
           // hashmap.put("reaction_date", reaction_date);
           // hashmap.put("other_reaction", other_reaction);
          //  hashmap.put("Site_Of_Reac", Site_Of_Reac);
            hashmap.put("allergy_test_res", allergy_test_res);
            hashmap.put("treat_advice", treat_advice);
            hashmap.put("remarks",remarks);
			hashmap.put("sou_of_info",sou_of_info);
			hashmap.put("react_values_main",react_values_main);
			hashmap.put("other_reaction_main",other_reaction_main);
			hashmap.put("facilityId",facilityId);
			hashmap.put("modifiedById",modifiedById);
			hashmap.put("modifiedAtWorkstation",modifiedAtWorkstation);
			hashmap.put("added_date", added_date);
			hashmap.put("visit_adm_date_time",visit_adm_date_time);
			hashmap.put("assign_care_locn_type",assign_care_locn_type);
			hashmap.put("assign_care_locn_code",assign_care_locn_code);
			hashmap.put("attend_practitioner_id",attend_practitioner_id);
			hashmap.put("adv_event_srl_no", adv_event_srl_no);
			hashmap.put("diagnosis_code",diagnosis_code);
			hashmap.put("term_code",term_code);
			//hashmap.put("status_date",status_date);
			hashmap.put("status_date",since_date);
			hashmap.put("react_code_val",react_code_val);
			hashmap.put("drug_code",drug_code);
			hashmap.put("status1",status1);
			hashmap.put("no_known_allergy",no_known_allergy);
			hashmap.put("estimated_duration_yn",estimated_duration_yn);
			hashmap.put("AllergyConfirmYN",AllergyConfirmYN);//Added for the crf - RUT-CRF-0064
			hashmap.put("allergy_conf_reqd_yn",allergy_conf_reqd_yn);//Added for the crf - RUT-CRF-0064

			//hashmap.put("react_values_main",react_values_main);
			//hashmap.put("Site_Of_Reac_oth",Site_Of_Reac_oth);
			//hashmap.put("severity_oth",severity_oth);
			//hashmap.put("other_reaction_date",other_reaction_date);
			//hashmap.put("other_reaction",other_reaction);
			
			/*Below line added for this CRF Bru-HIMS-CRF-133*/
			hashmap.put("isPatientEncMovement",isPatientEncMovement);
			hashmap.put("Sydate",Sydate);
			hashmap.put("p_queue_date",p_queue_date);
			hashmap.put("p_queue_status",p_queue_status);
			//End Bru-HIMS-CRF-133
			
			/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
			hashmap.put("onset_type",onset_type);
			hashmap.put("comments",comments);
			/*end ML-MMOH-CRF-0366 */
			
			boolean flag = false;
            flag = true;
            Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecordAdverseEvent", eMR.RecordAdverseEvent.RecordAdverseEventHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[2];
            aobj[0] = p;
            aobj[1] = hashmap;
            Class aclass[] = new Class[2];
            aclass[0] = p.getClass();
            aclass[1] = hashmap.getClass();
            HashMap hashmap1 = (HashMap)obj1.getClass().getMethod("insertAdveEvent", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
            boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
 	
			if(flag1)
			{

				//out.println("<script>parent.parent.parent.frames(2).frames(2).frames(4).Onsuccess();</script>");
				//out.println("<script>alert(parent.frames(3).frames(3).name;</script>");
				//out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.reaction_view.Onsuccess();} else{alert(\""+errorMsg+"\");}</script>");
			
											
		//	out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.submitframe.document.submit_form.record.disabled = false;parent.workAreaFrame.reaction_view.Onsuccess();} else{console.log(parent) parent.submitframe.document.submit_form.record.disabled = false;parent.frames[0].Onsuccess();}</script>");				
				out.println("<script>" +
					    "if (parent.workAreaFrame != null) {" +
					        "parent.workAreaFrame.submitframe.document.submit_form.record.disabled = false;" +
					        "parent.workAreaFrame.reaction_view.Onsuccess();" +
					    "} else {" +		
					        "var diaglogFrame = '';" +
					        " if (top.document.getElementById('dialog-body'))"+
					        " 		diaglogFrame = top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-1].contentWindow;"	+
					        " else "+
					        " 	 diaglogFrame = parent;"+
					        "diaglogFrame.submitframe.document.getElementById('record').disabled = false;" +
					        "diaglogFrame.frames[0].Onsuccess();" +
					    "}" +
					"</script>");
			
			}else
			{
				
			}

			hashmap.clear();
			hashmap1.clear();  
        }catch(Exception e)
        {
			//out.println("<h3> Exception raise by Servlet ... So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace();
        }finally
		{
			try
			{
				 if(stmt !=null) stmt.close();
				if(conn !=null) ConnectionManager.returnConnection(conn,req);
			}
			catch (Exception e)
			{
			}
		}
   }//Method

   private void modify(HttpServletRequest req,HttpServletResponse res) throws IOException
   {
		
        Properties p		= null;
		HttpSession session = null;
		PrintWriter out		= null;
		session				= req.getSession(false);
        p					= (Properties)session.getValue("jdbc");
		out					= res.getWriter();
		Connection conn		= null;
		ResultSet rs		= null;
		//ResultSet rs1		= null;
		Statement stmt		= null;
		PreparedStatement pstmt=null;
		String facilityId	= "";
		String client_ip_address		= "";
		String modifiedById	= "";
		String modifiedAtWorkstation	= "";
		String locale		= "";
		String PatientId	= "";
		String	certainity	= "";	
		String	severity_head			= "";
		String	adv_event_ind			= "";
		String	adv_event_type			= "";
		String	allergen	= "";
		String	onset_date	= "";
		String Encounter_Id	= "";
		String cause_sub	= "";
		String allergyAlertby= "";
		//String	since_date	= "";
		String route_exp	= "";
		String allergy_test_res			= "";
		String treat_advice	= "";
		String remarks		= "";
		String sou_of_info	= "";
		String react_values_main		= "";
		String diagnosis_code			= "";
		//String term_code	= "";
		String status_date	= "";
		String react_code_val			= "";
		String drug_code	= "";
		String status1		= "";
		String count_val	= "";
		String other_reaction_counter_val= "";
		String estimated_duration_yn	= "";
		String Site_Of_Reac_oth			= "";
		String severity_oth				= "";
		String other_reaction_date		= "";
		String other_reaction			= "";
		//String visit_adm_date_time		= "";
		//String assign_care_locn_type	= "";
		//String assign_care_locn_code	= "";
		//String attend_practitioner_id	= "";
		String adv_event_srl_no			= "";
		String adv_dtl_srl_num			= "";
		String no_known_allergy			= "";
		//String estimated_date			= "";
		String final_date				= "";
		String react_de					= "";
		//String final_date1				= "";
		//String final_date2				= "";
		String reaction_date			= "";
		String reaction_code			= "";
		String severity					= "";
		String Site_Of_Reac_val			= "";
		String other_reaction_main		= "";
		String adv_event_rxn_srl_no		= "";
		String Site_Of_Reac				= "";
		String err_remarks				= "";
		String chkreact1				= "";
		String add_reation_yn			= "";
		String AllergyConfirmYN			= "N";//Added for the crf - RUT-CRF-0064
		String allergy_conf_reqd_yn			= "N";//Added for the crf - RUT-CRF-0064
		/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751 Start*/
		String advEventSrlNo			= "";
		String otherAllergenFreeTxt		= "";
		/*End*/

		try
        {
			facilityId					= (String)session.getValue("facility_id");
			client_ip_address			= p.getProperty("client_ip_address");
			modifiedById				= p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
			modifiedAtWorkstation		= client_ip_address != null ? client_ip_address : "";
			locale						= p.getProperty("LOCALE");
			conn						= ConnectionManager.getConnection(req);
			stmt						= conn.createStatement();
			java.sql.Date added_date	= null; 
			HashMap hashmap				= new HashMap();
			HashMap  hashmap1			= new HashMap();
			PatientId					= req.getParameter("PatientId");
			if(PatientId ==null) PatientId = "";
			certainity					= req.getParameter("certainity");
			if(certainity ==null) certainity ="";
			severity_head				= req.getParameter("severity_head");
			if(severity_head ==null) severity_head = "";
			adv_event_ind				= req.getParameter("adv_event_ind");
			if(adv_event_ind==null)adv_event_ind = "";
			adv_event_type				= req.getParameter("adv_event_type");
			if(adv_event_type==null) adv_event_type = "";
			allergen					= req.getParameter("causative_code");
			if(allergen ==null) allergen = "";
			onset_date					= req.getParameter("onset_date");
			if(onset_date ==null) onset_date = "";
			Encounter_Id				= req.getParameter("Encounter_Id");
			if(Encounter_Id ==null) Encounter_Id = "";
			cause_sub					= req.getParameter("cause_sub");
			if(cause_sub ==null) cause_sub = "";
			allergyAlertby					= req.getParameter("allergyAlertby");
			if(allergyAlertby ==null) allergyAlertby = "";
			route_exp					= req.getParameter("route_of_expo");
			if(route_exp==null) route_exp = "";
			//String severity=req.getParameter("severity");
			//if(severity ==null) severity="";
			//String reaction_date=req.getParameter("reaction_date");
			//if(reaction_date ==null) reaction_date="";
			//String other_reaction=req.getParameter("other_reaction");
			//if(other_reaction ==null) other_reaction="";
			Site_Of_Reac				= req.getParameter("Site_Of_Reac");
			if(Site_Of_Reac ==null) Site_Of_Reac = "";
			allergy_test_res			= req.getParameter("allergy_test_res");
			if(allergy_test_res ==null) allergy_test_res = "";
			treat_advice				= req.getParameter("treat_advice");
			if(treat_advice ==null) treat_advice = "";
			remarks						= req.getParameter("remarks");
			if(remarks==null) remarks = "";
			sou_of_info					= req.getParameter("sou_of_info");
			if(sou_of_info==null) sou_of_info = "";
			react_values_main			= req.getParameter("react_values_main");
			if(react_values_main ==null) react_values_main = "";

			status1						= req.getParameter("status1");
			if(status1 ==null) status1 = "";
			err_remarks					= req.getParameter("err_remark");
			if(err_remarks ==null) err_remarks = "";
	
			diagnosis_code				= req.getParameter("diagnosis_code");
			if(diagnosis_code==null) diagnosis_code = "";

			status_date					= req.getParameter("date_time");
			if(status_date ==null)status_date = "";
			//String react_code_val=req.getParameter("react_code_final1");
			react_code_val				= req.getParameter("react_code_final");
			if(react_code_val ==null) react_code_val = "";


			drug_code					= req.getParameter("drug_code");
			if(drug_code ==null) drug_code="";

			count_val					= req.getParameter("count_val");
			if(count_val ==null) count_val="";

			other_reaction_counter_val	= req.getParameter("oth_reaction_counter");
			if(other_reaction_counter_val ==null) other_reaction_counter_val="";

			int other_reaction_counter	= 0;
			other_reaction_counter		= Integer.parseInt(other_reaction_counter_val);	

			no_known_allergy			= req.getParameter("no_known_allergy");
			if(no_known_allergy ==null) no_known_allergy="";
			/*Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751 Start*/
			advEventSrlNo		 = checkForNull(req.getParameter("advEventSrlNo"));
			otherAllergenFreeTxt = checkForNull(req.getParameter("allergen_free_text"));
			/*End*/
			AllergyConfirmYN=req.getParameter("AllergyConfirmYN");//Added for the crf RUT-CRF-0064
			if(AllergyConfirmYN == null) AllergyConfirmYN="N";
			allergy_conf_reqd_yn=req.getParameter("allergy_conf_reqd_yn");//Added for the crf RUT-CRF-0064
			if(allergy_conf_reqd_yn ==null) allergy_conf_reqd_yn="N";
			
			chkreact1					= req.getParameter("chkreact1");
			if(chkreact1 == null) chkreact1 = "N";
			estimated_duration_yn		= req.getParameter("estimated_duration_yn");
			if(estimated_duration_yn == null) estimated_duration_yn="N";
			add_reation_yn				= req.getParameter("add_reation_yn");
			if(add_reation_yn == null) add_reation_yn="N";
			if(add_reation_yn!=null && add_reation_yn.equals("Y")){
				String adv_event_srl_no_local="";
				
				try
				{
					String sql_adv_dtl_srl_num="select nvl(max(ADV_EVENT_DTL_SRL_NO),0) ADV_EVENT_DTL_SRL_NO from PR_ADVERSE_EVENT where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
		

					if(rs !=null)rs.close();
						rs=stmt.executeQuery(sql_adv_dtl_srl_num);
					if(rs !=null && rs.next()){
						adv_event_srl_no_local =rs.getString("ADV_EVENT_DTL_SRL_NO");
						if(adv_event_srl_no_local ==null) adv_event_srl_no_local="";
					}
				}
				catch (Exception e5)
				{
					e5.printStackTrace();
				}
				
				
				//String sql="select a.CAUSATIVE_SUBSTANCE,a.ROUTE_OF_EXPOSURE ROUTE_OF_EXPOSURE,b.SEVERITY,b.OTHERS_REACTION,b.REACTION_SITE,a.INFORMATION_SOURCE INFORMATION_SOURCE,a.ALLERGY_TEST_RESULT ALLERGY_TEST_RESULT,a.TREATMENT_ADVICE TREATMENT_ADVICE,a.REMARKS REMARKS from PR_ADVERSE_EVENT a, PR_ADVERSE_EVENT_REACTION b where a.patient_id='"+PatientId+"' and a.ADV_EVENT_TYPE='"+adv_event_type+"' and a.ALLERGEN_CODE='"+allergen+"' and a.patient_id=b.patient_id and a.ALLERGEN_CODE=b.ALLERGEN_CODE and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE AND b.adv_event_rxn_srl_no="+adv_event_srl_no_local+" AND a.adv_event_dtl_srl_no="+adv_event_srl_no_local;
				try
				{
					String sql="SELECT CAUSATIVE_SUBSTANCE,ROUTE_OF_EXPOSURE,INFORMATION_SOURCE,ALLERGY_TEST_RESULT,TREATMENT_ADVICE,REMARKS FROM PR_ADVERSE_EVENT WHERE patient_id='"+PatientId+"' AND ADV_EVENT_TYPE='"+adv_event_type+"' AND ALLERGEN_CODE='"+allergen+"'  AND adv_event_dtl_srl_no="+adv_event_srl_no_local ;
			
			
					if(rs !=null)rs.close();
					if(allergy_test_res.equals("") || treat_advice.equals("") || remarks.equals("")){
					
						rs=stmt.executeQuery(sql);
						if(rs !=null && rs.next()){
							/*sou_of_info=rs.getString("INFORMATION_SOURCE");
							if(sou_of_info ==null) sou_of_info="";
							route_exp=rs.getString("ROUTE_OF_EXPOSURE");
							if(route_exp ==null) route_exp="";*/
							allergy_test_res=rs.getString("ALLERGY_TEST_RESULT");
							if(allergy_test_res ==null) allergy_test_res="";
							treat_advice=rs.getString("TREATMENT_ADVICE");
							if(treat_advice ==null) treat_advice="";
							remarks=rs.getString("REMARKS");
							if(remarks ==null) remarks="";
						}
					
						if(rs !=null)rs.close();
					}
				}
				catch (Exception e6)
				{
					e6.printStackTrace();
				}
				
				
			}
				

			String final_value = req.getParameter("final_value");
			
			String reac_desc_val = req.getParameter("reac_desc_val");
			if(reac_desc_val == null) reac_desc_val = "";



			String	allergen1=req.getParameter("allergen");
			if(allergen1 ==null) allergen1="";

			boolean inserted1 = true;
			int rese1 = 0;

			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			added_date = java.sql.Date.valueOf( addedDate ) ;
			try
			{
				String sql_adv_srl_num="Select max(ADV_EVENT_SRL_NO) ADV_EVENT_SRL_NO from PR_ALLERGY_SENSITIVITY where PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
				rs=stmt.executeQuery(sql_adv_srl_num);
			
				if(rs !=null && rs.next())
				{
					adv_event_srl_no =rs.getString("ADV_EVENT_SRL_NO");
					if(adv_event_srl_no ==null) adv_event_srl_no="";
				}
				if(rs !=null) rs.close();
			}
			catch (Exception e7)
			{
				e7.printStackTrace();
			}
			
			//Added by Thamizh selvi on 2nd Jan 2018 against ML-MMOH-CRF-0751
			if(advEventSrlNo != "")
				adv_event_srl_no = advEventSrlNo;
			
			/*10/18/2008  0083 */
			//if(status1.equals("A"))
			//{
				try
				{
					String sql_adv_dtl_srl_num="select nvl(max(ADV_EVENT_DTL_SRL_NO),0)+1 ADV_EVENT_DTL_SRL_NO from PR_ADVERSE_EVENT where  PATIENT_ID='"+PatientId+"' and ADV_EVENT_TYPE_IND='"+adv_event_ind+"' and ADV_EVENT_TYPE ='"+adv_event_type+"' and ALLERGEN_CODE='"+allergen+"'";
					rs=stmt.executeQuery(sql_adv_dtl_srl_num);
					if(rs !=null && rs.next())
					{
						adv_dtl_srl_num=rs.getString("ADV_EVENT_DTL_SRL_NO");
						if(adv_dtl_srl_num ==null) adv_dtl_srl_num="";
					}
					if(rs !=null) rs.close();
				}
				catch (Exception e8)
				{
					e8.printStackTrace();
				}
				 
		//	}/*10/18/2008  0083 */
			

			onset_date=DateUtils.convertDate(onset_date,"DMYHMS",locale,"en");
			status_date=DateUtils.convertDate(status_date,"DMY",locale,"en");
			//other_reaction_date=DateUtils.convertDate(other_reaction_date,"DMYHM",locale,"en");

/////////////////////////////////////10/2/2008

StringTokenizer StrToken = new StringTokenizer(final_value,"$");
				
			
				
				while(StrToken.hasMoreTokens())
					
				{

				final_date=StrToken.nextToken();
				
				react_de=StrToken.nextToken();
				
				adv_event_rxn_srl_no=StrToken.nextToken();
				
				/*String sev =StrToken.nextToken();
				if(sev == null) sev = "";
				String sit =StrToken.nextToken();
				if(sit == null) sit = "";
				*/
				
				
				
				
				//final_date=new String("Other Reactions:tr");
				//int length=final_date.length();
				
				if(final_date.length()>15)
					{
				String otherReaction=new String("Other Reactions");
				String subOther=final_date.substring(0,15);

				if(subOther.equals(otherReaction))
					{
						int length=final_date.length();
						final_date=final_date.substring(16,length)	;
						//sql code
						
							try
							{
								String sql_status = "update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate ,modified_facility_id = ? where  patient_id = ? and allergen_code = ? and adv_event_type_ind =? and adv_event_type = ? and adv_reac_code = ? and others_reaction = ? and adv_event_rxn_srl_no=?";


								pstmt=conn.prepareStatement(sql_status.toString());

								pstmt.setString(1,modifiedById);
								pstmt.setString(2,modifiedAtWorkstation);
								pstmt.setString(3,facilityId);
								pstmt.setString(4,PatientId);
								pstmt.setString(5,allergen1);
								pstmt.setString(6,adv_event_ind);
								pstmt.setString(7,adv_event_type);
								pstmt.setString(8,"Oth");
								pstmt.setString(9,final_date.trim());
								pstmt.setString(10,adv_event_rxn_srl_no);

								rese1= pstmt.executeUpdate();

								if(pstmt != null) pstmt.close();
								if(rese1 !=0){
									conn.commit(); 
									inserted1 = true;

								}
								else{
									conn.rollback();
								
									inserted1 = false;
								}
							}
							catch (Exception Ex)
							{
								Ex.printStackTrace();
							}
							

				}else
						{
						try
						{
							String sql_status = "update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate ,modified_facility_id = ? where  patient_id = ? and allergen_code = ? and adv_event_type_ind =? and adv_event_type = ? and adv_reac_code = ? and adv_event_rxn_srl_no=?";


							pstmt=conn.prepareStatement(sql_status.toString());

							pstmt.setString(1,modifiedById);
							pstmt.setString(2,modifiedAtWorkstation);
							pstmt.setString(3,facilityId);
							pstmt.setString(4,PatientId);
							pstmt.setString(5,allergen1);
							pstmt.setString(6,adv_event_ind);
							pstmt.setString(7,adv_event_type);
							
							pstmt.setString(8,final_date);
							pstmt.setString(9,adv_event_rxn_srl_no);
							
							rese1= pstmt.executeUpdate();

							if(pstmt != null) pstmt.close();
							if(rese1 !=0){
									conn.commit(); 
									inserted1 = true;

								}
							else{
								conn.rollback();
								
								inserted1 = false;
							}
						}
						catch (Exception ex)
						{
							ex.printStackTrace();
						}
						
					
				}
			}
				else
					{
						
						try
						{
							String sql_status = "update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate ,modified_facility_id = ? where  patient_id = ? and allergen_code = ? and adv_event_type_ind =? and adv_event_type = ? and adv_reac_code = ?  and adv_event_rxn_srl_no=?";


							pstmt=conn.prepareStatement(sql_status.toString());

							pstmt.setString(1,modifiedById);
							pstmt.setString(2,modifiedAtWorkstation);
							pstmt.setString(3,facilityId);
							pstmt.setString(4,PatientId);
							pstmt.setString(5,allergen1);
							pstmt.setString(6,adv_event_ind);
							pstmt.setString(7,adv_event_type);
							
							pstmt.setString(8,final_date);
							pstmt.setString(9,adv_event_rxn_srl_no);
							
							
							rese1= pstmt.executeUpdate();

							if(pstmt != null) pstmt.close();
							if(rese1 !=0){
									conn.commit(); 
									inserted1 = true;

								}
							else{
								conn.rollback();
								
								inserted1 = false;
							}
						}
						catch (Exception exx)
						{
							exx.printStackTrace();
						}
						//sql
						
				
				}

									

/*
				react_de=StrToken.nextToken();
				
//StringTokenizer oth_react = new StringTokenizer(final_date,":");
StringTokenizer oth_react1 = new StringTokenizer(final_date,":");	
						if(oth_react1.hasMoreTokens()){
							final_date2=oth_react1.nextToken();
							final_date1=oth_react1.nextToken();

							if(!(final_date1 == null)&&!(final_date1.equals(""))){

							//String Sql="update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ? and allergen_code = ? adv_reac_code =? values ('"+modifiedById+"','"+modifiedAtWorkstation+"',sysdate,'"+PatientId+"','"+allergen+"','"+adv_reac_code+"')";

							String sql_status = "update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ? and allergen_code = ? and adv_event_type_ind =? and adv_event_type = ? and adv_reac_code = ? and others_reaction = ?";


							pstmt=conn.prepareStatement(sql_status.toString());

							pstmt.setString(1,modifiedById);
							pstmt.setString(2,modifiedAtWorkstation);
							pstmt.setString(3,PatientId);
							pstmt.setString(4,allergen1);
							pstmt.setString(5,adv_event_ind);
							pstmt.setString(6,adv_event_type);
							
							pstmt.setString(7,null);
							pstmt.setString(8,final_date1);
							
							rese1= pstmt.executeUpdate();

							if(pstmt != null) pstmt.close();
							if(rese1 !=0){
									conn.commit(); 
									inserted1 = true;

								}
							else{
								conn.rollback();
								
								inserted1 = false;
							}

						}	
						}
						/*else
						{	
						//final_date=finaldate1;
						

				/*	while(oth_react.hasMoreTokens())
					
					{
						final_date1=oth_react.nextToken();
						StringTokenizer oth_react1 = new StringTokenizer(final_date1,":");	
						if(oth_react1.hasNext()){
							x=hasNext()
						}
							else
								final=finaldate1;

						/*final_date2=oth_react.nextToken();




*//*

				if(!(final_date == null)&&!(final_date .equals(""))){*/

							//String Sql="update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ? and allergen_code = ? adv_reac_code =? values ('"+modifiedById+"','"+modifiedAtWorkstation+"',sysdate,'"+PatientId+"','"+allergen+"','"+adv_reac_code+"')";
/*
							String sql_status = "update PR_ADVERSE_EVENT_REACTION set STATUS='E',modified_by_id = ?,modified_at_ws_no = ?, modified_date = sysdate  where  patient_id = ? and allergen_code = ? and adv_event_type_ind =? and adv_event_type = ? and adv_reac_code = ? ";


							pstmt=conn.prepareStatement(sql_status.toString());

							pstmt.setString(1,modifiedById);
							pstmt.setString(2,modifiedAtWorkstation);
							pstmt.setString(3,PatientId);
							pstmt.setString(4,allergen1);
							pstmt.setString(5,adv_event_ind);
							pstmt.setString(6,adv_event_type);
							
							pstmt.setString(7,final_date);
							
							
							rese1= pstmt.executeUpdate();

							if(pstmt != null) pstmt.close();
							if(rese1 !=0){
									conn.commit(); 
									inserted1 = true;

								}
							else{
								conn.rollback();
								
								inserted1 = false;
							}
				}

			}	*/

			//}
		}
		










/***************************************************10/2/2008

			
			/*String Site_Of_Reac_oth=req.getParameter("Site_Of_Reac_oth");
			if(Site_Of_Reac_oth ==null) Site_Of_Reac_oth="";
			String severity_oth=req.getParameter("severity_oth");
			if(severity_oth ==null) severity_oth="";

			String other_reaction_date=req.getParameter("other_reaction_date");
			if(other_reaction_date ==null) other_reaction_date="";
			String other_reaction=req.getParameter("reaction_oth");
			if(other_reaction ==null) other_reaction="";*/
	
			

			
/***************************************/

if(rese1 == 0)	
			{
/**************************************/
			int counter=0;
			counter=Integer.parseInt(count_val);


			//String react_values="";
		  
//10/26/2008 for not adding reaction when mode in not active
//if(!reac_desc_val.equals("")){
//10/26/2008
			
			try
			{
				for (int i=0;i<=counter-1 ;i++ )
				{
					if(add_reation_yn!=null && add_reation_yn.equals("Y")){
						reaction_date=req.getParameter("reaction_date"+i);
						if(reaction_date == null) reaction_date = "";
						reaction_code=req.getParameter("reaction_code"+i);
						if(reaction_code == null) reaction_code = "";
						severity=req.getParameter("severity"+i);
						if(severity == null) severity = "$";
						Site_Of_Reac_val=req.getParameter("Site_Of_Reac"+i);
						if(Site_Of_Reac_val == null) Site_Of_Reac_val = "$";

					}else if(add_reation_yn!=null && add_reation_yn.equals("N")){
						/*
						reaction_date=req.getParameter("react_description"+i);
						if(reaction_date == null) reaction_date = "";
						reaction_code=req.getParameter("reaction_code"+i);
						if(reaction_code == null) reaction_code = "";
						severity=req.getParameter("severity_desc"+i);
						if(severity == null) severity = "$";
						Site_Of_Reac_val=req.getParameter("site_desc"+i);
						if(Site_Of_Reac_val == null) Site_Of_Reac_val = "$";
						*/
						reaction_date=req.getParameter("reaction_date"+i);
						if(reaction_date == null) reaction_date = "";
						reaction_code=req.getParameter("reaction_code"+i);
						if(reaction_code == null) reaction_code = "";
						severity=req.getParameter("severity"+i);
						if(severity == null) severity = "$";
						Site_Of_Reac_val=req.getParameter("Site_Of_Reac"+i);
						if(Site_Of_Reac_val == null) Site_Of_Reac_val = "$";

					}
					//reaction_date=req.getParameter("reaction_date"+i);
					//reaction_date=req.getParameter("react_description"+i);
					
					

					reaction_date=DateUtils.convertDate(reaction_date,"DMYHM",locale,"en");

					//reaction_code=req.getParameter("reaction_code"+i);
					//reaction_code=req.getParameter("error_status"+i);

					//severity=req.getParameter("severity"+i);
					//severity=req.getParameter("severity_desc"+i);
					if(severity.equals("") ) severity="$";
					else if(severity.equals("Mild"))
						severity="M";
					else if(severity.equals("Moderate"))
						severity="O";
					else if(severity.equals("Severe"))
						severity="S";
					else if(severity.equals("Unknown"))
						severity="U";

					//Site_Of_Reac_val=req.getParameter("Site_Of_Reac"+i);
					//Site_Of_Reac_val=req.getParameter("site_desc"+i);
					if(Site_Of_Reac_val.equals("") ) Site_Of_Reac_val="$";

					react_values_main=react_values_main+"@"+reaction_date +"`"+reaction_code+"`"+severity+"`"+Site_Of_Reac_val;
			
				
				}
			}
			catch (Exception er)
			{
				er.printStackTrace();
			}
			
		
			/*if(!other_reaction.equals(""))
			{
			if(severity_oth.equals("")) severity_oth="$";
			if(Site_Of_Reac_oth.equals("")) Site_Of_Reac_oth="$";
			other_reaction_main=other_reaction_date+"*"+other_reaction+"*"+severity_oth+"*"+Site_Of_Reac_oth;
			}else
			{
				other_reaction_main="";
			}*/

			

			other_reaction_main="";
			try
			{
				for (int i=0;i<=other_reaction_counter-1 ;i++ ){
					other_reaction_date=req.getParameter("other_reaction_date"+i);
		
					other_reaction_date=DateUtils.convertDate(other_reaction_date,"DMYHM",locale,"en");
					other_reaction=req.getParameter("reaction_oth"+i);
						
					severity_oth=req.getParameter("severity_oth"+i);
						if(severity_oth.equals("")) severity_oth="$";
					if(severity_oth.equals("Mild"))
						severity_oth="M";
					else if(severity_oth.equals("Moderate"))
						severity_oth="O";
					else if(severity_oth.equals("Severe"))
						severity_oth="S";
					else if(severity_oth.equals("Unknown"))
						severity_oth="U";
					
					Site_Of_Reac_oth=req.getParameter("Site_Of_Reac_oth"+i);

					if(Site_Of_Reac_oth.equals("")) Site_Of_Reac_oth="$";
								
					other_reaction_main=other_reaction_main+"@"+other_reaction_date +"`"+other_reaction+"`"+severity_oth+"`"+Site_Of_Reac_oth;
					
		
				}
							
			}
			catch (Exception eo)
			{
				eo.printStackTrace();
			}
				
		
	if(severity.equals("Mild"))
		severity="M";
	else if(severity.equals("Moderate"))
		severity="O";
	else if(severity.equals("Severe"))
		severity="S";
	else if(severity.equals("Unknown"))
		severity="U";

	if(severity_oth.equals("Mild"))
		severity_oth="M";
	else if(severity_oth.equals("Moderate"))
		severity_oth="O";
	else if(severity_oth.equals("Severe"))
		severity_oth="S";
	else if(severity_oth.equals("Unknown"))
		severity_oth="U";
			
					
			//HashMap hashmap = new HashMap();
            hashmap.put("p", p);
			hashmap.put("PatientId",PatientId);
            hashmap.put("certainity", certainity);
           // hashmap.put("severity_head", severity_head);
            hashmap.put("adv_event_ind", adv_event_ind);
            hashmap.put("adv_event_type", adv_event_type);
            hashmap.put("allergen", allergen);
            hashmap.put("onset_date", onset_date);
            hashmap.put("reaction_date", reaction_date);
			hashmap.put("sou_of_info",sou_of_info);
			hashmap.put("remarks",remarks);
			hashmap.put("treat_advice",treat_advice);
			hashmap.put("allergy_test_res",allergy_test_res);
			hashmap.put("Site_Of_Reac",Site_Of_Reac);
			//hashmap.put("other_reaction",other_reaction);
			hashmap.put("severity",severity);
			hashmap.put("route_exp",route_exp);
			hashmap.put("cause_sub",cause_sub);
			hashmap.put("allergyAlertby",allergyAlertby);
			hashmap.put("Encounter_Id",Encounter_Id);
			hashmap.put("react_values_main",react_values_main);
			hashmap.put("status1", status1);
            hashmap.put("status_date",status_date);
			hashmap.put("react_code_val",react_code_val);
			hashmap.put("err_remarks",err_remarks);
			hashmap.put("facilityId",facilityId);
			hashmap.put("modifiedById",modifiedById);
			hashmap.put("modifiedAtWorkstation",modifiedAtWorkstation);
			hashmap.put("added_date", added_date);
			hashmap.put("adv_event_srl_no", adv_event_srl_no);
			hashmap.put("adv_dtl_srl_num",adv_dtl_srl_num);
			hashmap.put("diagnosis_code",diagnosis_code);
			hashmap.put("drug_code",drug_code);
			hashmap.put("other_reaction_main",other_reaction_main);
			hashmap.put("no_known_allergy",no_known_allergy);
			hashmap.put("chkreact1",chkreact1);
			hashmap.put("estimated_duration_yn",estimated_duration_yn);
			hashmap.put("reac_desc_val",reac_desc_val);
			hashmap.put("AllergyConfirmYN",AllergyConfirmYN);//Added for the crf - RUT-CRF-0064
			hashmap.put("allergy_conf_reqd_yn",allergy_conf_reqd_yn);//Added for the crf - RUT-CRF-0064
			hashmap.put("otherAllergenFreeTxt", otherAllergenFreeTxt);//Added by Thamizh selvi on 15th Jan 2018 against ML-MMOH-CRF-0751

			


			boolean flag = false;
            flag = true;
            Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecordAdverseEvent", eMR.RecordAdverseEvent.RecordAdverseEventHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[2];
            aobj[0] = p;
            aobj[1] = hashmap;
            Class aclass[] = new Class[2];
            aclass[0] = p.getClass();
            aclass[1] = hashmap.getClass();
             hashmap1 = (HashMap)obj1.getClass().getMethod("modifyAdveEvent", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			boolean inserted = ( ((Boolean) hashmap1.get( "status" )).booleanValue() ) ;
			
			if(inserted )
			{

				

				
			 // out.println("<script>parent.parent.parent.frames(2).frames(2).frames(4).Onsuccess();</script>");
			 // out.println("<script>parent.frames(2).frames(3).Onsuccess();</script>");
			 //out.println("<script>parent.workAreaFrame.reaction_view.Onsuccess();</script>");
			// out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.reaction_view.Onsuccess();} else{alert(\""+errorMsg+"\");}</script>");	

			//out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.submitframe.document.submit_form.record.disabled = false;parent.workAreaFrame.reaction_view.Onsuccess();} else{parent.submitframe.document.submit_form.record.disabled = false;parent.frames[0].Onsuccess();}</script>");	
				out.println("<script>" +
					    "if (parent.workAreaFrame != null) {" +
					        "parent.workAreaFrame.submitframe.document.submit_form.record.disabled = false;" +
					        "parent.workAreaFrame.reaction_view.Onsuccess();" +
					     "} else {" +		
					        "var diaglogFrame = '';" +
					        " if (top.document.getElementById('dialog-body'))"+
					        " 		diaglogFrame = top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-1].contentWindow;"	+
					        " else "+
					        " 	 diaglogFrame = parent;"+
					        "diaglogFrame.submitframe.document.getElementById('record').disabled = false;" +
					        "diaglogFrame.frames[0].Onsuccess();" +
					    "}" +
					"</script>");

			}
/**********************************/
		}
/***********************************/
			if(inserted1 )
			{

				

				
			 // out.println("<script>parent.parent.parent.frames(2).frames(2).frames(4).Onsuccess();</script>");
			 // out.println("<script>parent.frames(2).frames(3).Onsuccess();</script>");
			 //out.println("<script>parent.workAreaFrame.reaction_view.Onsuccess();</script>");
			// out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.reaction_view.Onsuccess();} else{alert(\""+errorMsg+"\");}</script>");	
			/*java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM");
			String mess = (String) message.get("message");
			//out.println("<script>alert('"+mesge+"');</script>");
			
			out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.reaction_view.Onsuccess();} else{alert('"+mess+"');parent.parent.window.close();}</script>");	
			message.clear();*/

			//out.println("<script>if(parent.workAreaFrame!=null){parent.workAreaFrame.submitframe.document.submit_form.record.disabled = false;parent.workAreaFrame.reaction_view.Onsuccess();} else{parent.submitframe.document.submit_form.record.disabled = false;parent.frames[0].Onsuccess();}</script>");	
				out.println("<script>" +
					    "if (parent.workAreaFrame != null) {" +
					        "parent.workAreaFrame.submitframe.document.submit_form.record.disabled = false;" +
					        "parent.workAreaFrame.reaction_view.Onsuccess();" +
					    "} else {" +		
					        "var diaglogFrame = '';" +
					        " if (top.document.getElementById('dialog-body'))"+
					        " 		diaglogFrame = top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-1].contentWindow;"	+
					        " else "+
					        " 	 diaglogFrame = parent;"+
					        "diaglogFrame.submitframe.document.getElementById('record').disabled = false;" +
					        "diaglogFrame.frames[0].Onsuccess();" +
					    "}" +
					"</script>");

			}
			hashmap.clear();
			hashmap1.clear();  
	}catch (Exception e)
	{
		e.printStackTrace();
	}finally
		{
			try
			{
				 if(stmt !=null) stmt.close();
				if(conn !=null) ConnectionManager.returnConnection(conn,req);	
			}
			catch (Exception e)
			{
			}
		}
	}//Method
	public static String checkForNull(String inputString)
	{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
}
