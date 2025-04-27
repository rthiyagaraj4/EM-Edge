/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
07/09/2012	  IN32540		 Nijitha S		IE 9 is creating an issue in the CA module 
16/12/2013  IN034536		Nijitha S		Bru-HIMS-CRF-133	
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        Rev.Date 	Rev.by 		Description
--------------------------------------------------------------------------------------------------------------
27/02/2015		IN048463			Karthi L							Bed Side Referral Status
06/04/2015		IN048704			Nijitha S							HSA-CRF-0175
01/11/2018  	IN063285            prathyusha                          ML-MMOH-CRF-0757
06/01/2022		27605				Ramesh G 							Common-ICN-0086
31/10/2022                          Kamatchi S                          TH-KW-CRF-0143
--------------------------------------------------------------------------------------------------------------
*/  
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eOP.StartCons.*;
import eOP.QmgmtRe_AssignPract.*;

public class CAOpenChartServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
    {
        super.init(cfg);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		
		String patientid			= "",	mode			= "";
		String visitid				= "",	episodeid		= "";
		String locationcode			= "",	locationtype	= "";
		String bednum				= "",	roomnum			= "";	
		String episodetype			= "",	dischargedate	= "";
		String visitadmdate			= "",	episodeStatus	= "";
		String sex					= "",	dob				= "";
		String age					= "",	pline			= "";
		String clinicianid			= "",	facilityid		= "";
		String loginuserid			= "",	respid			= "";
		String securitylevel		= "",	protectionind	= "";
		String Opphysicianid		= "",	relnreqyn		= "";
		String insertop				= "",	pract_type		= "";
		String client_ip_address	= "",	medical_team	= "";
		String bl_operational		= "",	from_service_yn = "";
		String accession_number		= "",	accession_type	= "";
		String sStyle				= "",	patient_class	= "";
		String strRelnYn			= "",	strRelnReqYn	= "";
		String function_id			= "",	jspChart		= "";
		String specialty_code		= "";
		String referral_id			= "",	unAssigned_yn	= "";
		String fromNewFunction = "N";
		String patChartCalledFrm	= ""; //IN038776
//		String screen_yn			= "";
		String episode_id_new		= "";//IN063285
		String visit_Id				= "";//Added by Kamatchi S for TH-KW-CRF-0143

		java.util.Properties p			=	null;
		HttpSession   session			=   null;
		java.io.PrintWriter    out		=   null;
		
		Connection con			= null;
		PreparedStatement stmt  = null ;
        ResultSet rs            = null ;

		session			=   request.getSession(true) ;
		
		sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

        p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

        response.setContentType("text/html");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
        out =   response.getWriter() ;

        try
        {
			con = ConnectionManager.getConnection(request);
            response.setContentType("text/html");

            out.println ("<html><head>");
//            out.println("<script src='../eCA/js/CAMessages.js' language='javascript'></script>");
            out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link></head>");
            out.println ("<body class='MESSAGE' onload='showDialog()'>");
			 
			  out.println ("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
            out.println("<script src='../eCA/js/CAMenu.js' language='javascript'></script><script src='../eCA/js/CAMainMenu.js' language='javascript'></script>");
            out.println("<script src='../eAE/js/AEManagePatient.js' language='javascript'></script>");
			out.println("<script src='../eCommon/js/common.js' language='javascript'></script>");
			
			clinicianid		=(String) session.getValue("ca_practitioner_id");
            pract_type		=(String) session.getValue("practitioner_type");
            respid			=(String) session.getValue("responsibility_id");
            facilityid		=(String) session.getValue("facility_id");
            loginuserid		=(String) session.getValue("login_user");
			bl_operational	=(String) session.getAttribute( "bl_operational" ) ;

			client_ip_address	= p.getProperty("client_ip_address");
            Opphysicianid		= request.getParameter("Opphysician_id")==null?"":request.getParameter("Opphysician_id");
            patientid			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
            visitid				= request.getParameter("episode_visit_id")==null?"":request.getParameter("episode_visit_id");
            visit_Id			= request.getParameter("visit_id");//Added by Kamatchi S for TH-KW-CRF-0143
			
			if(visitid.equals("null")) 
				visitid="";

            episodeid			= request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			episode_id_new		= request.getParameter("episode_id_new")==null?"":request.getParameter("episode_id_new");//IN063285
            locationcode		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
            locationtype		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
            bednum				= request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
            roomnum				= request.getParameter("room_num")==null?"":request.getParameter("room_num") ;
            episodetype			= request.getParameter("episode_type")==null?"":request.getParameter("episode_type") ;
            dischargedate		= request.getParameter("discharge_date")==null?"":request.getParameter("discharge_date") ;
            visitadmdate		= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date") ;
            episodeStatus		= request.getParameter("episode_Status")==null?"":request.getParameter("episode_Status") ;
            sex					= request.getParameter("sex")==null?"":request.getParameter("sex") ;
            dob					= request.getParameter("dob")==null?"":request.getParameter("dob") ;
            age					= request.getParameter("age")==null?"":request.getParameter("age") ;
            securitylevel		= request.getParameter("security_level")==null?"":request.getParameter("security_level");
            protectionind		= request.getParameter("protection_ind")==null?"":request.getParameter("protection_ind");
            relnreqyn			= request.getParameter("reln_req_yn")==null?"N":request.getParameter("reln_req_yn");
            pline				= request.getParameter("pline")==null?"":request.getParameter("pline")   ;
            insertop			= request.getParameter("insert_op")==null?"N":request.getParameter("insert_op")   ;
			patient_class		= request.getParameter("patient_class") == null?"":request.getParameter("patient_class");
			medical_team		= request.getParameter("medical_team") == null?"":request.getParameter("medical_team");
			from_service_yn		= request.getParameter("from_service_yn") == null?"":request.getParameter("from_service_yn");
			accession_number	= request.getParameter("accession_number") == null?"":request.getParameter("accession_number");
			accession_type		= request.getParameter("accession_type") == null?"":request.getParameter("accession_type");
			strRelnYn			= request.getParameter("reln_Yn") == null?"":request.getParameter("reln_Yn");
			strRelnReqYn		= request.getParameter("reln_reqYn") == null?"":request.getParameter("reln_reqYn");
			specialty_code		= request.getParameter("specialty_code") == null?"":request.getParameter("specialty_code");
			function_id			= request.getParameter("function_id") == null?"":request.getParameter("function_id");
			unAssigned_yn		= request.getParameter("unAssigned_yn") == null?"Y":request.getParameter("unAssigned_yn");
			referral_id			= request.getParameter("referral_id") == null?"":request.getParameter("referral_id");
			fromNewFunction			= request.getParameter("fromNewFunction") == null?"N":request.getParameter("fromNewFunction");
			String ConsOrdChartYn	= request.getParameter("ConsOrdChartYn") == null?"N":request.getParameter("ConsOrdChartYn");
			String startConsYN	= request.getParameter("startConsYN") == null?"":request.getParameter("startConsYN");
			//String CA_PATLIST_BY_LOCN_CHART_TYPE	= request.getParameter("CA_PATLIST_BY_LOCN_CHART_TYPE") == null?"":request.getParameter("CA_PATLIST_BY_LOCN_CHART_TYPE");//Checkstyle Fix
			//String MNG_PAT_QUEUE_CHART_TYPE	= request.getParameter("MNG_PAT_QUEUE_CHART_TYPE") == null?"":request.getParameter("MNG_PAT_QUEUE_CHART_TYPE");//CheckStyle Fix
			patChartCalledFrm	= request.getParameter("patChartCalledFrm") == null?"":request.getParameter("patChartCalledFrm"); //IN038776
			/*if(fromNewFunction.equals("N"))*/ jspChart = "CAMainChart.jsp";
			//else jspChart = "CAMainChart_new.jsp";

			String fromfunction = request.getParameter("from_function")==null?"":request.getParameter("from_function")   ;
            String called_function_id = request.getParameter("called_function_id")==null?"":request.getParameter("called_function_id")   ;
            String assign_confirm_referral_yn = request.getParameter("assign_confirm_referral_yn")==null?"":request.getParameter("assign_confirm_referral_yn")   ;//IN048704
            String assignorConfirmKey = request.getParameter("assignorConfirmKey")==null?"":request.getParameter("assignorConfirmKey")   ;//CRF 175
            String recentPaLstFlag = request.getParameter("recentPatLstDtl")==null?"":request.getParameter("recentPatLstDtl") ;
            String pq="Y";
            String ca="Y";

			if(unAssigned_yn.equals("N"))
			{
				try
				{
					updatePractId(request, clinicianid, referral_id, facilityid, loginuserid, client_ip_address);
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
			}

			try
			{	
				StringBuffer plinesql = new StringBuffer();

				if(plinesql.length() > 0) 
					plinesql.delete(0,plinesql.length());

				plinesql.append(" select (patient_name||','||substr(get_age(date_of_birth, deceased_date),1,20)||','||decode(sex,'F','Female','M','Male','Unknown')) p_line ");
				plinesql.append(" from mp_patient where patient_id = ? ");
				
				stmt    = con.prepareStatement(plinesql.toString());
				stmt.setString(1, patientid);
				
				rs          = stmt.executeQuery();
				
				if(rs.next())
					pline = rs.getString("p_line")==null?"":rs.getString("p_line");

				//pline	= java.net.URLEncoder.encode(pline,"UTF-8");

				if( rs!= null) rs.close();
				if(stmt !=null) stmt.close();

	            if(fromfunction.equals("M"))
				{
					pq="N";
					insertop = "N";				
				
					String selectsql = "";
					
					if(!selectsql.equals(""))
					{
						rs  = stmt.executeQuery(selectsql);
						
						if(rs.next())
						{
							episodeStatus	= rs.getString("episode_status")==null?"0":rs.getString("episode_status");
							episodetype		= rs.getString("episode_type")==null?"":rs.getString("episode_type");
							sex				= rs.getString("sex")==null?"":rs.getString("sex");
							dob				= rs.getString("dob")==null?"":rs.getString("dob");
							age				= rs.getString("age")==null?"":rs.getString("age");
							visitadmdate	= rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
							dischargedate	= rs.getString("discharge_date")==null?"":rs.getString("discharge_date");
							locationcode	= rs.getString("location_code")==null?"":rs.getString("location_code");
							locationtype	= rs.getString("location_type")==null?"":rs.getString("location_type");
							roomnum			= rs.getString("CUR_ROOM_NUM")==null?"":rs.getString("CUR_ROOM_NUM");
							bednum			= rs.getString("CUR_BED_NUM")==null?"":rs.getString("CUR_BED_NUM");
							securitylevel	= rs.getString("SECURITY_LEVEL")==null?"":rs.getString("SECURITY_LEVEL");
							protectionind	= rs.getString("PROTECTION_IND")==null?"":rs.getString("PROTECTION_IND");
						}
					}

					if( rs!= null) rs.close();
					if(stmt !=null) stmt.close();

					selectsql = " Select nvl(ESTABLISH_RELN_REQ_YN ,'N') ESTABLISH_RELN_REQ_YN from CA_ENCNTR_PARAM ";
					stmt    = con.prepareStatement(selectsql);
					
					rs  = stmt.executeQuery();
					
					if(rs.next())
					{
						relnreqyn = rs.getString("ESTABLISH_RELN_REQ_YN");
						
						if (relnreqyn==null)
							relnreqyn="N";
					}					

					if( rs!= null) rs.close();
					if(stmt !=null) stmt.close();

				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception@30 from CAOpenChartServlet.java:" + e.toString());
				
			}
			try
			{
				String uniquewinname = patientid+episodeid+visitid;
				//String uniquewinname = "";

				if(called_function_id.equals("REL_PAT_TREAT") || episodeid.equals("")  || episodeid.equals("0"))
					mode = "V";
				else
					mode = "R";

				if(called_function_id.equals("NEW_BORN"))
					mode = "R";

				StringBuffer qs = new StringBuffer("patient_id="+patientid+"&visit_id="+visitid+"&episode_id="+episodeid+"&encounter_id="+episodeid+"&location_code="+locationcode+"&location_type="+locationtype+"&bed_num="+bednum+"&room_num="+roomnum+"&episode_type="+episodetype+"&discharge_date="+dischargedate+"&visit_adm_date="+visitadmdate+"&episode_Status="+episodeStatus+"&Sex="+sex+"&Age="+age+"&Dob="+dob+"&security_level="+securitylevel+"&protection_ind="+protectionind+"&reln_req_yn="+relnreqyn+"&patient_class="+patient_class+"&PQ="+pq+"&CA="+ca+"&from_service_yn="+from_service_yn+"&accession_number="+accession_number+"&accession_type="+accession_type+"&mode="+mode+"&RelnYn="+strRelnYn+"&RelnReqYn="+strRelnYn+"&speciality_code="+specialty_code+"&ConsOrdChartYn="+ConsOrdChartYn+"&visit_Id="+visit_Id);//Visit_Id Added by Kamatchi S for TH-KW-CRF-0143
				qs.append("&patChartCalledFrm="+patChartCalledFrm);  //IN038776
				
				qs.append("&referral_id="+referral_id);  //IN048704
				qs.append("&assign_confirm_referral_yn="+assign_confirm_referral_yn);  //IN048704
				qs.append("&assignorConfirmKey="+assignorConfirmKey);  //IN048704
				qs.append("&episode_id_new="+episode_id_new);//IN063285
				qs.append("&recentPatLstDtl="+recentPaLstFlag);
				out.println("<script>");
				out.println("async function showDialog() {");
				out.println("var  screenHeight=screen.height;");
				out.println("var  screenWidth=screen.width;");				

				if(startConsYN.equals("")||(startConsYN.equals("Y")))
				{
					if((patient_class.equals("OP") || patient_class.equals("EM")) && !episodeStatus.equals("") && Integer.parseInt(episodeStatus) < 4)
						UpdateQueueStatus(request,facilityid,episodeid,Opphysicianid,clinicianid,patientid,locationcode,visitadmdate,client_ip_address,p,out);
				}
			   
				String ret = "";
				if(relnreqyn.equals("Y"))
				{
					try
					{
						ret = chkActiveRelation(clinicianid, patientid, facilityid, episodeid, episodetype, visitid,request);


						if(ret == null)
							ret = "";

						if(ret.equals("") && pract_type.equals("NS") && !episodeid.equals(""))
						{							
							ret = createRelationshipforNurse(request,facilityid,episodeid,out,patientid,clinicianid,loginuserid,client_ip_address,locale);
							
							if (ret.equals("NO_REL_FOR_NURSE"))
							{
								out.println("</script>");
								ret="";
								return;
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						out.println("Exception@29.25 from CAOpenChartServlet.java:" + e.toString());
						
					}
				}
									
				if(!ret.equals("")||relnreqyn.equals("N"))
				{					
					try
					{
						if (patient_class.equals(""))
						{
							patient_class="XT";
						}
						maintainPatientLog(request, patientid, clinicianid, respid, ret, facilityid,loginuserid, episodeid,  "",locationcode,specialty_code,patient_class);
				
						if(ret.equals("`")) ret="";
						//qs.append("&relationship_id="+ret);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						out.println("Exception@29.5 from CAOpenChartServlet.java:" + e.toString());
						
					}

					out.println("var  firstwindow = top.window ;") ;
					out.println("if( top.content != null )") ;
					out.println("firstwindow = top.content;") ;
					out.println("if(firstwindow.CommonToolbar != null)");
					out.println("{");
					out.println("firstwindow= firstwindow.CommonToolbar.firstwindow;") ;
				/*	out.println("for(var k=0;k<top.content.CommonToolbar.pat_info.length;k++) ");
					out.println("{");
					out.println("var window_ref=top.content.CommonToolbar.pat_info[k].window_obj;");
					out.println("window_ref.top.content.CommonToolbar.pat_info= top.content.CommonToolbar.pat_info;");
					out.println("}");*/
					//out.println("top.content.CommonToolbar.pat_info[top.content.CommonToolbar.pat_info.length] = new SelectedPatient('"+patientid+"','"+episodeid+"','"+visitid+"','"+episodetype+"','"+locationcode+"','"+locationtype+"','',\""+pline+"\",window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes'));");// Commented for IE 9 FIX
					//27605 Start.
					//out.println("top.content.CommonToolbar.pat_info[top.content.CommonToolbar.pat_info.length] =  top.content.CommonToolbar.SelectedPatient1('"+patientid+"','"+episodeid+"','"+visitid+"','"+episodetype+"','"+locationcode+"','"+locationtype+"','',\""+pline+"\",window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes'));");////IN32540 IE 9 Fix
					out.println("top.content.CommonToolbar.pat_info[top.content.CommonToolbar.pat_info.length] =  top.content.CommonToolbar.SelectedPatient1('"+patientid+"','"+episodeid+"','"+visitid+"','"+episodetype+"','"+locationcode+"','"+locationtype+"','',\""+pline+"\",window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes'));");////IN32540 IE 9 Fix
					//27605 End.
					out.flush();
/*******************************************************************************/
				
//					HashMap sessMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					//27605 Start.
					//SelectThisPatient(patientid,episodeid,visitid,episodetype,locationcode,locationtype,pline,"window.open('../../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes')","window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes')",session);
					SelectThisPatient(patientid,episodeid,visitid,episodetype,locationcode,locationtype,pline,"window.open('../../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes')","window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes')",session);
					//27605 End.
//					HashMap patWinMap = (HashMap) sessMap.get(patientid+episodeid+visitid);
					
//					String patWinObject = (String) patWinMap.get("windowObjecServlet"+patientid+episodeid+visitid);
					
					out.println("}"); 
					out.println("else");
					out.println("{");
					//27605 Start.
					//out.println("var win_obj =  window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=1080,width=1920,top=0,left=0,resizable=yes');");
					out.println("var win_obj =  window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes');");
					//27605 End.
					out.println("win_obj.focus();");
					out.println("}");
				}
				else
				{

					out.println("var retVal = '';");
						out.println("var features   = 'dialogHeight:100vh; dialogWidth:100vw; dialogTop:0; status=no' ;");
					out.println("var arguments  = '' ;");

					if(relnreqyn.equals("Y"))
					{
						session.setAttribute("RELN_ASS","N");
						out.println("retVal = await top.window.showModalDialog(\"../../eCA/jsp/AssignRelationship.jsp?modal_yn=Y&fromOpenChart_yn=Y&"+qs.toString()+"&pline="+pline+"\",arguments,features);");
					}
					else
						out.println("retVal = 'OPEN';"); // this condition has been given because if the flag relnreqyn is not Y then the dialog (AssignRelationship.jsp) opens and does not open the chart after showing as alert(alert('CA_ENC_RELN_NO')). to open the chart explicitly this condition has been given
					
					out.println("if(retVal != null && retVal != 'Y')");
					out.println("{");               
					out.println("var  firstwindow = top.window ;") ;
					out.println("if( top.content != null )") ;
					out.println("firstwindow = top.content") ;
					out.println("if(firstwindow.CommonToolbar != null)");
					out.println("{");
					out.println("firstwindow= firstwindow.CommonToolbar.firstwindow");
				/*	out.println("for(var k=0;k<firstwindow.content.CommonToolbar.pat_info.length;k++)");
					out.println("{");
					out.println("var window_ref=firstwindow.content.CommonToolbar.pat_info[k].window_obj;"); 
					out.println("window_ref.top.content.CommonToolbar.pat_info= firstwindow.content.CommonToolbar.pat_info;");
					out.println("}");*/

					//out.println("firstwindow.content.CommonToolbar.pat_info[firstwindow.content.CommonToolbar.pat_info.length] = new SelectedPatient('"+patientid+"','"+episodeid+"','"+visitid+"','"+episodetype+"','"+locationcode+"','"+locationtype+"','',\""+pline+"\",window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"',\""+uniquewinname+"\",'location=0,height=570,width=790,top=0,left=0,resizable=yes'));");//IE 9 Fix
					//27605 Start.
					//out.println("top.content.CommonToolbar.pat_info[top.content.CommonToolbar.pat_info.length] =  top.content.CommonToolbar.SelectedPatient1('"+patientid+"','"+episodeid+"','"+visitid+"','"+episodetype+"','"+locationcode+"','"+locationtype+"','',\""+pline+"\",window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes'));");////IN32540 IE 9 Fix
					out.println("top.content.CommonToolbar.pat_info[top.content.CommonToolbar.pat_info.length] =  top.content.CommonToolbar.SelectedPatient1('"+patientid+"','"+episodeid+"','"+visitid+"','"+episodetype+"','"+locationcode+"','"+locationtype+"','',\""+pline+"\",window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes'));");////IN32540 IE 9 Fix
					//27605 End.
/*******************************************************************************/
				//	HashMap sessMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId());	
					ArrayList ListSess = (ArrayList) session.getAttribute("sessionList"+session.getId());	
					//if(sessMap.size() < 3)
					
					String strReln = (String) session.getAttribute("RELN_ASS");
					
					 if(strReln == null || strReln.equals("") )
							strReln ="N";

					if(strReln.equals("Y") && !ListSess.contains(uniquewinname) )		
					{
						//27605 Start.
						//SelectThisPatient(patientid,episodeid,visitid,episodetype,locationcode,locationtype,pline,"window.open('../../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes')","window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes')",session);
						SelectThisPatient(patientid,episodeid,visitid,episodetype,locationcode,locationtype,pline,"window.open('../../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes')","window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes')",session);
						//27605 End.
//						HashMap patWinMap = (HashMap) sessMap.get(patientid+episodeid+visitid);

//						String patWinObject = (String) patWinMap.get("windowObjecServlet"+patientid+episodeid+visitid);
					}
					
					/*else
					{
						out.println("alert(getCAMessage('MORE_THAN_FOUR_NOT_ALLOWED'));");
					}*/
					out.println("}");
					out.println("else");
					out.println("{");
					//27605 Start.
					//out.println("var win_obj = window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=570,width=790,top=0,left=0,resizable=yes');");
					out.println("var win_obj = window.open('../eCA/jsp/"+jspChart+"?"+qs.toString()+"&window_name="+uniquewinname+"','"+uniquewinname+"','location=0,height=screenHeight,width=screenWidth,top=0,left=0,resizable=yes');");
					//27605 End.
					out.println("win_obj.focus();");
					out.println("}");
					out.println("}");
					//if(ListSess != null) ListSess.clear();
				}			
			
				out.println("if(top.content!=null &&  top.content.messageFrame!=null ){");
				out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp';");
				out.println("} ");
				out.println("} </script></body></html>");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception here@31 from CAOpenChartServlet.java:"+e.toString());
				
			}
        }
        catch(Exception e)
        {
            e.printStackTrace();
			out.println("Exception here@32 from CAOpenChartServlet.java:"+e.toString());
            
        }
        finally
		{
            try
           {	
				if(out  != null) out = null;
				if(rs != null) rs.close();
                if(stmt != null) stmt.close();
				if(con!=null)  ConnectionManager.returnConnection(con,request);
            }
			catch (Exception ce)
			{
			}
        }
    }

    public boolean maintainPatientLog(HttpServletRequest request, String patientid, String clinicianid, String respid, String relnid, String facility_id,String loginuserid, String episodeid,String sessionid,String locationcode, String specialty_code, String patient_class )
    {
		int rs = 0;
        
		Connection con = null;
		PreparedStatement stmt = null;
		CallableStatement cs = null;
        
		boolean ret = true;
        
		try
        {
			con = ConnectionManager.getConnection(request);

			String sql = " INSERT INTO CA_PATIENT_CHART_ACC_LOG (PATIENT_ID ,PRACTITIONER_ID ,START_DATE_TIME ,RESP_ID  ,PRACT_RELN_ID,FACILITY_ID,ENCOUNTER_ID,SPECIALTY_CODE,PATIENT_CLASS,LOCN_CODE   ) VALUES (? ,? ,SYSDATE ,? ,?,?,?,?,?,?  )";

            stmt = con.prepareStatement(sql);

			stmt.setString(1,patientid);
			stmt.setString(2,clinicianid);
			stmt.setString(3,respid);
			stmt.setString(4,relnid);
			stmt.setString(5,facility_id);
			stmt.setString(6,episodeid);
			stmt.setString(7,specialty_code);
			stmt.setString(8,patient_class);
			stmt.setString(9,locationcode);

            rs = stmt.executeUpdate();
            
			if(rs > 0)
                ret = true;
            else
                ret = false;

			if(stmt != null) stmt.close();

			cs = con.prepareCall("{call MAINTAIN_RECENT_LIST (?,?,?,sysdate,?,?,?,?) }" );

	        long ep =0;

		    if(!(episodeid.equals("") || episodeid.equals("null") || episodeid == null))
			     ep = Long.parseLong(episodeid);
       
			cs.setString(1, facility_id);
			cs.setString(2, loginuserid);
			cs.setString(3, patientid);
			cs.setLong(4, ep);
			cs.setString(5, respid);
			cs.setString(6, relnid);
			cs.setString(7, sessionid);

			cs.execute();
			if(cs != null) cs.close();
			con.commit();
	    }
		catch (Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
            
			if(e.toString().indexOf("CA_PATIENT_CHART_ACC_LOG") != -1)
                System.out.println("2 CAOpenChartServlet.java:"+e.toString());
            
			ret = false;
        }
		finally
		{
			try
			{
				if(con!=null)  ConnectionManager.returnConnection(con,request);
			}
			catch (Exception eCS)
			{

			}
		}

		return ret;
    }

private void UpdateQueueStatus(HttpServletRequest request,String facilityid,String episodeid,String Opphysicianid,String clinicianid,String patientid,String locationcode,String visitadmdate, String client_ip_address,java.util.Properties p,java.io.PrintWriter out )
{
	Connection con = null;
	CallableStatement cs = null;
	//IN034536 Starts
	String isPatientEncMovement = request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
	String p_queue_date = request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
	String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	//IN034536 Ends
	try
	{
		con = ConnectionManager.getConnection(request);
		cs = con.prepareCall( "{ call CA_GET_OP_PAT_STATUS( ?, ?, ?, ?, ?, ?) }" ) ;
		
		cs.setString( 1,facilityid  ) ;
		cs.setString( 2,episodeid   ) ;
		cs.registerOutParameter( 3, Types.VARCHAR ) ;
		cs.registerOutParameter( 4, Types.VARCHAR ) ;
		cs.registerOutParameter( 5, Types.VARCHAR ) ;
		cs.registerOutParameter( 6, Types.VARCHAR ) ;
		cs.execute() ;
		String p_visit_type= cs.getString( 3 ) ;
		String p_queue_status= cs.getString( 4 )==null?"0":cs.getString( 4 );
		int    p_queue_status_Int =  Integer.parseInt(p_queue_status) ;
		String p_error_code = cs.getString( 6 );
		p_error_code = (p_error_code==null)?"":p_error_code ;
		
		if (!p_error_code.equals("ERROR") && p_queue_status_Int < 4 ) 
		{

			String sql_for_locn = "select  ASSIGN_CARE_LOCN_TYPE locn_type from pr_encounter where facility_id=? and encounter_id=?";
			String locn_type="";
			PreparedStatement pstmt_locn = con.prepareStatement(sql_for_locn);
			pstmt_locn.setString(1,facilityid);
			pstmt_locn.setString(2,episodeid);
			ResultSet rs_locn = pstmt_locn.executeQuery();
			if(rs_locn!=null)
			{
				while(rs_locn.next())
					locn_type = rs_locn.getString(1)==null?"":rs_locn.getString(1);
			}
			
		if(rs_locn !=null) rs_locn.close();
		if(pstmt_locn !=null) pstmt_locn.close();


		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/StartCons",StartConsHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy kk:mm");
		java.util.Date f    = new java.util.Date();
		String dateString   = dt.format(f);
		String q="*ALL";
		

		if (Opphysicianid.equals("") || Opphysicianid.equals("*ALL"))
				Opphysicianid = clinicianid;
		
			HashMap hashcon = new HashMap();
			hashcon.put("patientid",patientid);
			hashcon.put("facilityId",facilityid);
			hashcon.put("encounterid",episodeid);
			hashcon.put("qstatus",p_queue_status);
			hashcon.put("locncode",locationcode);
			hashcon.put("locntype",locn_type);
			hashcon.put("practitionerid",Opphysicianid);
			hashcon.put("qshift",q);
			hashcon.put("visittype",p_visit_type);
			hashcon.put("consdate",dateString);
			hashcon.put("p_queue_date",visitadmdate.substring(0,10));
			hashcon.put("client_ip_address",client_ip_address);
			//IN034536 Starts
			hashcon.put("isPatientEncMovement",isPatientEncMovement);
			hashcon.put("p_queue_date",p_queue_date);
			hashcon.put("Sydate",Sydate);
			//IN034536 Ends

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashcon;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashcon.getClass();

			java.util.HashMap map = (java.util.HashMap)(busObj.getClass().getMethod("updateRecordStartCons",paramArray)).invoke(busObj,argArray);			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			hashcon.clear();

			map.clear();
			argArray = null;
			paramArray =null;
		}
		
		if(cs!=null) cs.close();
	}

	catch(Exception e)
	{
		
		out.println("exception Occurred " + e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)  ConnectionManager.returnConnection(con,request);
	}

	
} // end of func

public String createRelationshipforNurse(HttpServletRequest request,String facilityid,String episodeid,java.io.PrintWriter out,String patientid,String clinicianid, String loginuserid, String client_ip_address, String locale)
{
	Connection con = null;
	ResultSet rsDetail = null,rsReln = null;
	PreparedStatement pstmtRelnDetail = null,pstmtReln = null,pstmtInsertReln=null;
	String pract_reln_id = "",direct_yn = "N",begin_date_time = "",end_date_time="",patient_class="";

	int nUpdStat = 0;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		patient_class= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	
		pstmtRelnDetail = con.prepareStatement("SELECT DIRECT_YN, TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI') START_DATE,       TO_CHAR (DECODE (EXPIRY_RULE,'DAE', SYSDATE + EXPIRY_PERIOD,'HAE', SYSDATE + EXPIRY_PERIOD / 24,NULL),'DD/MM/YYYY HH24:MI') END_DATE FROM CA_PRACT_RELN WHERE PRACT_RELN_ID = ? ");
		pstmtReln = con.prepareStatement("SELECT CA_GET_PRACT_RELATIONSHIP(A.SPECIALTY_CODE,'NS') PRACT_RELN_ID FROM PR_ENCOUNTER A WHERE FACILITY_ID=? AND ENCOUNTER_ID=? ");

		pstmtReln.clearParameters();
		pstmtReln.setString(1,facilityid);
		pstmtReln.setString(2,episodeid);
		rsReln = pstmtReln.executeQuery();

		while(rsReln.next())
		{
			pract_reln_id = rsReln.getString(1);
		}

		if( rsReln!= null) rsReln.close();
		if(pstmtReln !=null) pstmtReln.close();


		if(pract_reln_id == null) 
		{
			pract_reln_id = "";			
		}
		if(pract_reln_id.equals(""))
		{
			out.println("alert('APP-CA00102 There is no indirect nursing relationship defined. Contact Admin..')");
			return "NO_REL_FOR_NURSE";
		}

		pstmtRelnDetail.clearParameters();
		pstmtRelnDetail.setString(1,pract_reln_id);
		rsDetail = pstmtRelnDetail.executeQuery();

		while(rsDetail.next()){
			direct_yn = rsDetail.getString("DIRECT_YN");
			begin_date_time = rsDetail.getString("START_DATE")==null?"":rsDetail.getString("START_DATE");
			end_date_time = rsDetail.getString("END_DATE")==null?"":rsDetail.getString("END_DATE");
		}

		if(begin_date_time.equals(""))
			begin_date_time = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

		if( rsDetail!= null) rsDetail.close();
		if(pstmtRelnDetail !=null) pstmtRelnDetail.close();


		pstmtInsertReln = con.prepareStatement("INSERT INTO CA_ENCNTR_PRACT_RELN ( FACILITY_ID, PATIENT_ID, PRACT_RELN_ID, PRACTITIONER_ID,ENCOUNTER_ID, PATIENT_CLASS, BEGIN_DATE_TIME, END_DATE_TIME, DIRECT_YN, STATUS, ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) VALUES(?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

		pstmtInsertReln.clearParameters();

		pstmtInsertReln.setString(1,facilityid);
		pstmtInsertReln.setString(2,patientid);
		pstmtInsertReln.setString(3,pract_reln_id);
		pstmtInsertReln.setString(4,clinicianid);
		pstmtInsertReln.setString(5,episodeid);
		pstmtInsertReln.setString(6,patient_class);
		pstmtInsertReln.setString(7,begin_date_time);
		pstmtInsertReln.setString(8,end_date_time);
		pstmtInsertReln.setString(9,direct_yn);
		pstmtInsertReln.setString(10,"01"); //STATUS IS EMPTY
		pstmtInsertReln.setString(11,loginuserid);
		pstmtInsertReln.setString(12,client_ip_address);
		pstmtInsertReln.setString(13,facilityid);
		pstmtInsertReln.setString(14,loginuserid);
		pstmtInsertReln.setString(15,client_ip_address);
		pstmtInsertReln.setString(16,facilityid);

		nUpdStat = pstmtInsertReln.executeUpdate();

		if(nUpdStat > 0)
			con.commit();
		else
			con.rollback();

		if(rsDetail != null) rsDetail.close();
		if(rsReln != null) rsReln.close();
		if(pstmtRelnDetail != null) pstmtRelnDetail.close();
		if(pstmtInsertReln != null) pstmtInsertReln.close();
		if(pstmtReln != null) pstmtReln.close();
	}
	catch(Exception e)
	{
		try
		{
			if(con != null) 
				con.rollback();

			e.printStackTrace();
			
			out.println("Exception in CAMainFramValidateServlet:"+e);
			return "";
		}
		catch(Exception eee)
		{}
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
	
	return pract_reln_id;
}	

public String chkActiveRelation(String clinicianid, String patientid, String facilityid, String episodeid, String episodetype, String visitid,HttpServletRequest request)
{
		Connection con = null;
		PreparedStatement stmt  = null ;
		PreparedStatement pstmt  = null ;
        ResultSet rset      = null ;
        StringBuffer sql     = new StringBuffer();
		StringBuffer retrelnid   = new StringBuffer() ;
        
		try
        {
            con = ConnectionManager.getConnection(request);
			
			String ca_encntr_pract_reln_update ="UPDATE ca_encntr_pract_reln SET STATUS='09' WHERE PATIENT_ID=? AND STATUS='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY'))<SYSDATE ";
			
			pstmt = con.prepareStatement(ca_encntr_pract_reln_update);

			pstmt.setString(1,patientid) ;

			pstmt.executeUpdate();

					
				con.commit();
						

			if(pstmt!=null) pstmt.close();

			 //sql.append(" Select PRACT_RELN_ID PHYS_PROV_RELN_ID from CA_ENCNTR_PRACT_RELN Where PRACTITIONER_ID=? And  PATIENT_ID=? And   FACILITY_ID=? And  STATUS is null And sysdate between BEGIN_DATE_TIME and nvl( END_DATE_TIME,sysdate)  ");
			sql.append("Select PRACT_RELN_ID PHYS_PROV_RELN_ID from CA_ENCNTR_PRACT_RELN Where FACILITY_ID = ? AND NVL(ENCOUNTER_ID,0) = NVL(?,0) AND PRACTITIONER_ID=? AND PATIENT_ID=? AND STATUS ='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY'))AND BEGIN_DATE_TIME<=SYSDATE+.0006 ");	
			
			/* if(!(episodeid == null || episodeid.equals("")))
			{
				sql.append(" AND encounter_id =?");
					
			} */

			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1,facilityid);
			stmt.setString(2,episodeid);
			stmt.setString(3,clinicianid);
			stmt.setString(4,patientid);
			
			/*if(!(episodeid == null || episodeid.equals(""))){
				stmt.setString(4,episodeid);
			}*/
			
			rset = stmt.executeQuery();

            if(rset!=null && rset.next())
            {
				String relnid = rset.getString("PHYS_PROV_RELN_ID")==null?"":rset.getString("PHYS_PROV_RELN_ID");
				retrelnid.append(relnid);
			}
			if(rset!=null)      rset.close();
			if(stmt!=null)  stmt.close();
		}
		catch( Exception e ) 
		{ 
			try
			{
				con.rollback();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
			}
			e.printStackTrace();
			retrelnid.append(e.toString() +"<br>"+ sql.toString()); 
		}

        finally
		{
			try
			{
				
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			catch (Exception ee1)
			{}
		}
	
		return retrelnid.toString() ;
	}

	private void SelectThisPatient(String patientId, String episodeId, String visitId, String episodeType, String locationCode, String locationType, String patOtherDetails, String windowObject, String windowObjecServlet, HttpSession session)
	{
		java.util.HashMap hashMapTempMap = new HashMap();
		java.util.HashMap sessionHashMap = new HashMap();
		java.util.ArrayList sessionList = new ArrayList();
		

		hashMapTempMap.put("patientId"+patientId+episodeId+visitId,patientId);
		hashMapTempMap.put("episodeId"+patientId+episodeId+visitId,episodeId);
		hashMapTempMap.put("visitId"+patientId+episodeId+visitId,visitId);
		hashMapTempMap.put("episodeType"+patientId+episodeId+visitId,episodeType);
		hashMapTempMap.put("locationCode"+patientId+episodeId+visitId,locationCode);
		hashMapTempMap.put("locationType"+patientId+episodeId+visitId,locationType);
		hashMapTempMap.put("patOtherDetails"+patientId+episodeId+visitId,patOtherDetails);
		hashMapTempMap.put("windowName"+patientId+episodeId+visitId,patientId+episodeId+visitId);
		hashMapTempMap.put("windowObject"+patientId+episodeId+visitId,windowObject);		
		hashMapTempMap.put("windowObjecServlet"+patientId+episodeId+visitId,windowObjecServlet);
		
		sessionHashMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId());
		sessionHashMap.put(patientId+episodeId+visitId,hashMapTempMap);

		sessionList = (ArrayList) session.getAttribute("sessionList"+session.getId());
		if(sessionList != null && !sessionList.contains(patientId+episodeId+visitId))
		{
			sessionList.add(patientId+episodeId+visitId);
		}
		



	//	session.setAttribute("patInfoMap"+patientId+episodeId+visitId,hashMapTempMap);
	}// ends 28/2/2006 addition here

	public boolean updatePractId(HttpServletRequest request, String clinicianid, String referral_id, String facilityid, String loginuserid, String client_ip_address)
	{
		Connection con = null;
		PreparedStatement pstmt  = null ;
		int nUpdate = 0;
		boolean retVal = false;

		try
		{
			con = ConnectionManager.getConnection(request);

			//pstmt = con.prepareStatement("update PR_REFERRAL_REGISTER set TO_PRACT_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where REFERRAL_ID = ? "); -- commented for IN048463
			pstmt = con.prepareStatement("update PR_REFERRAL_REGISTER set TO_PRACT_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where REFERRAL_ID = ? and TO_PRACT_ID IS NULL  "); // Modified for IN048463

			pstmt.setString(1,clinicianid);
			pstmt.setString(2,loginuserid);
			pstmt.setString(3,client_ip_address);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,referral_id);

			nUpdate = pstmt.executeUpdate();

			if(nUpdate > 0)
			{
				retVal = true;
				con.commit();
			}
			else
			{
				retVal = false;
				try
				{
					con.rollback();
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			}
			if(pstmt != null) pstmt.close();

		}
		catch (Exception e)
		{
			//con.rollback();
			
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
		return retVal;
	}

	/*private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg	= (String) message.get("message");

		message.clear();
		return(mesg) ;
	}*/

} // end of class CAOpenChartServlet
