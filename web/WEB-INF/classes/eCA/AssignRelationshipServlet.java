/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA ;

import java.sql.* ;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.naming.*;
import javax.rmi.*;
import eCA.AssignRelationship.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import java.util.*;

public class AssignRelationshipServlet extends HttpServlet 
{
   
   public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		HttpSession session	=	null;
		//String user_id = "";
		String strTerminateReln = "";
        session		=	request.getSession(true) ;

		java.io.PrintWriter out =	response.getWriter() ;

		try
        {
            //user_id		=	(String)session.getValue("login_user") ;
			strTerminateReln = request.getParameter("terminate");
			if(strTerminateReln.equals("N")){//new Relation
	            insertRelationshipAssignment(request,response,session,out);
			}else{//modify exisiting reln
	            updateRelationshipAssignment(request,response,session,out);			
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@Servlet:1 : "+e);//common-icn-0181
			e.printStackTrace();
		}
    }

	private void insertRelationshipAssignment(HttpServletRequest request, HttpServletResponse response, HttpSession session, java.io.PrintWriter out) throws ServletException, java.io.IOException
	{
		java.util.Properties	p		=	null;
		
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		p =	(java.util.Properties)session.getValue("jdbc") ;
		String locale = (String) p.getProperty("LOCALE");

		out.println ("<html><head>");
		out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		out.println ("<title>Result</title></head>");
		out.println ("<body class='MESSAGE'>");

		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null; 
//		String added_by_id = "",modified_by_id = "";

		String patient_id = "", facility_id = "", episode_type = "", episode_id = "";
		String visit_id = "", phys_prov_id = "", phys_prov_reln_id = "", begin_date_time = "";
		String end_date_time = "", resp_id = "", login_user_id = "" ;
		String  modal_yn = "",patient_class="",added_at_ws_no="",fromOpenChart_yn="",specialty_code="";
	    String reason_Short_Desc="";
		String reason_text="";

		java.util.HashMap htAssignRelationship = new java.util.HashMap();

		try
        {
			session	=	request.getSession(false);
			//con		=	(Connection) session.getValue("connection");

			con = ConnectionManager.getConnection(request);

			login_user_id		=	(String) session.getValue("login_user");

			facility_id			=	(String) session.getValue("facility_id");

			patient_id			=	request.getParameter("patient_id");

			episode_type		=	request.getParameter("episode_type");
			episode_id			=	request.getParameter("episode_id");
			visit_id			=	request.getParameter("visit_id");
			//phys_prov_id		=	request.getParameter("act_clinician_id");
			phys_prov_id		=	request.getParameter("clinician_id");
			phys_prov_reln_id	=	request.getParameter("phys_prov_reln_id");
			begin_date_time		=	request.getParameter("start_date");
			end_date_time		=	request.getParameter("end_date");
			resp_id				=	request.getParameter("resp_id");
			modal_yn			=	request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
			added_at_ws_no		=	request.getRemoteAddr();
			patient_class		=	request.getParameter("patient_class") ==null?"":request.getParameter("patient_class");
			fromOpenChart_yn	=	request.getParameter("fromOpenChart_yn") ==null?"N":request.getParameter("fromOpenChart_yn");
			specialty_code	=	request.getParameter("speciality_code") ==null?"":request.getParameter("speciality_code");
			
			String query_string = request.getParameter("query_string") == null ? "" :  request.getParameter("query_string");
			String location_code = request.getParameter("location_code") == null ? "" :  request.getParameter("location_code");
			String location_type = request.getParameter("location_type") == null ? "" :  request.getParameter("location_type");
			String patOtherDetails = request.getParameter("pline") == null ? "" :  request.getParameter("pline");
			 reason_Short_Desc= request.getParameter("reason_Short_Desc") == null ? "" :  request.getParameter("reason_Short_Desc");
			 reason_text=request.getParameter("reason_text") == null ? "" :  request.getParameter("reason_text");
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ reason_Desc"+reason_text);
			begin_date_time		=	com.ehis.util.DateUtils.convertDate(begin_date_time,"DMYHM",locale,"en");
			end_date_time		=	com.ehis.util.DateUtils.convertDate(end_date_time,"DMYHM",locale,"en");

			StringBuffer plinesql = new StringBuffer();

			if(plinesql.length() > 0) 
				plinesql.delete(0,plinesql.length());

			plinesql.append(" select (patient_name||','||substr(get_age(date_of_birth, deceased_date),1,20)||','||decode(sex,'F','Female','M','Male','Unknown')) p_line ");
			plinesql.append(" from mp_patient where patient_id = ? ");
			
			pstmt    = con.prepareStatement(plinesql.toString());
			pstmt.setString(1, patient_id);
			
			rs          = pstmt.executeQuery();
			
			if(rs.next())
				patOtherDetails = rs.getString("p_line")==null?"":rs.getString("p_line");

			if(rs!= null) rs.close();
			if(pstmt !=null) pstmt.close();
/*
			query_check_duplicate = "select 1 from ca_encntr_phys_prov_reln where patient_id = ? and operating_facility_id = ? and episode_type = ? and episode_id = ?  and visit_id = ? and phys_prov_id = ? and nvl(status,'X')!='9' and sysdate between to_date(?,'dd/mm/yyyy hh24:mi') and nvl(?, sysdate) ";

			//out.println("query_check_duplicate : "+query_check_duplicate);
*-/
			try
			{
/*				pstmt	=	con.prepareStatement(query_check_duplicate);

				pstmt.setString(1,patient_id);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,episode_type);
				pstmt.setString(4,episode_id);
				pstmt.setString(5,visit_id);
				pstmt.setString(6,phys_prov_id);
				pstmt.setString(7,begin_date_time);
				pstmt.setString(8,end_date_time);

				rs	=	pstmt.executeQuery();
			}
			catch(Exception e)
			{
				out.println("Exception while executing Query!"+e);
			}
			if(rs.next())
			{
				out.println("APP-CA0009 There is a active Relationship with the patient... Still you want to create a new relationship? ");
			}
			else
			{
		*/
				try
				{
					if(end_date_time.equals("")) end_date_time = "";
	/*				out.println("<br>patient_id			: "+ patient_id);
					out.println("<br>facility_id		: "+ facility_id);
					out.println("<br>episode_type		: "+ episode_type);
					out.println("<br>episode_id			: "+ episode_id);
					out.println("<br>visit_id			: "+ visit_id);
					out.println("<br>phys_prov_id		: "+ phys_prov_id);
					out.println("<br>phys_prov_reln_id	: "+ phys_prov_reln_id);
					out.println("<br>begin_date_time	: "+ begin_date_time);
					out.println("<br>end_date_time		: "+ end_date_time);
					out.println("<br>resp_id			: "+ resp_id);
					out.println("<br>login_user_id		: "+ login_user_id);
*/
					htAssignRelationship.put ( "patient_id",			patient_id			);
					htAssignRelationship.put ( "facility_id",			facility_id			);
					htAssignRelationship.put ( "episode_type",			episode_type		);
					htAssignRelationship.put ( "episode_id",			episode_id			);
					htAssignRelationship.put ( "visit_id",				visit_id			);
					htAssignRelationship.put ( "phys_prov_id",			phys_prov_id		);
					htAssignRelationship.put ( "phys_prov_reln_id",		phys_prov_reln_id	);
					htAssignRelationship.put ( "begin_date_time",		begin_date_time		);
					htAssignRelationship.put ( "end_date_time",			end_date_time		);
					htAssignRelationship.put ( "resp_id",				resp_id				);
					htAssignRelationship.put ( "login_user_id",			login_user_id		);


					htAssignRelationship.put ( "patient_class",	patient_class);
					htAssignRelationship.put ( "practitioner_id",phys_prov_id);
					htAssignRelationship.put ( "added_facility_id",facility_id);
					htAssignRelationship.put ( "added_at_ws_no",added_at_ws_no);
					htAssignRelationship.put ( "fromOpenChart_yn",fromOpenChart_yn);
					htAssignRelationship.put ( "locale",locale);
					htAssignRelationship.put ( "remarks",reason_text);
					

					//htAssignRelationship.put ( "status",				"null"				);

				}
				catch(Exception e)
				{
					out.println("Exception while putting HashMap datas!"+e);
					e.printStackTrace();
					throw e;
				}

				try
				{
					/*InitialContext context = new InitialContext();

					Object homeObject = context.lookup("java:comp/env/AssignRelationship");

					AssignRelationshipHome assignRelationshipHome = (AssignRelationshipHome) PortableRemoteObject.narrow (homeObject, AssignRelationshipHome.class);

					AssignRelationshipRemote assignRelationshipRemote = assignRelationshipHome.create();

					java.util.HashMap results = assignRelationshipRemote.insertAssignRelationship(p, htAssignRelationship);*/

					
					boolean local_ejbs = false;
					
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AssignRelationship",AssignRelationshipHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = htAssignRelationship;
		
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = htAssignRelationship.getClass();
		


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAssignRelationship",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		htAssignRelationship.clear();
					
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String err_msg = (String) results.get("error") ;
					results.clear();
					
					if(!(modal_yn.equals("Y")))
					{
						if(inserted)
						{
							session.setAttribute("RELN_ASS","Y");
/*
							HashMap tempPatMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
							ArrayList tempPatList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());
							tempPatMap = new HashMap();
							tempPatList = new ArrayList();
							session.setAttribute("sessionMainMap"+session.getId(), new HashMap());
							session.setAttribute("sessionList"+session.getId(), new ArrayList());
							*/

							out.println(err_msg);
							out.println("<script>var query_string=top.content.workAreaFrame.AssignRelationshipViewFrame.document.forms[0].query_string.value;");
							out.println("top.content.workAreaFrame.AssignRelationshipViewFrame.location.href = \"../eCA/jsp/AssignRelationshipView.jsp?\"+query_string;");
							out.println("top.content.workAreaFrame.AssignRelationshipFrame.location.href=\"../eCA/jsp/AssignRelationshipMain.jsp?\"+query_string;</script>");

							/*
							out.println("<script>var query_string=parent.frames(4).frames(1).frames(0).document.forms(0).query_string.value;");
							out.println("parent.frames(4).frames(1).frames(0).location.href = \"../eCA/jsp/AssignRelationshipView.jsp?\"+query_string;");
							out.println("parent.frames(4).frames(1).frames(1).location.href=\"../eCA/jsp/AssignRelationshipMain.jsp?\"+query_string;</script>");*/
						} // end of if
						else
						{
							out.println(err_msg);
							if(err_msg.lastIndexOf("<br>") >=0 )
							{
								err_msg = err_msg.substring(0,err_msg.lastIndexOf("<br>"));
							}
							//out.println("<script>alert('"+err_msg+"')</script>");
							//out.println("APP-SM0009 Operation Failed : "+err_msg);
						} // end of else
					}
					else
					{
					
						if(err_msg.lastIndexOf("<br>") >=0 )
						{
							err_msg = err_msg.substring(0,err_msg.lastIndexOf("<br>"));
						}
					
						out.println(err_msg);
					
						if(inserted)
						{
							session.setAttribute("RELN_ASS","Y");	
							String uniquewinname = patient_id+episode_id+visit_id;
							String windowObject = "window.open('../../eCA/jsp/CAMainChart.jsp?"+query_string+"&window_name="+uniquewinname+"','"+uniquewinname+"','height=570,width=790,top=0,left=0,resizable=yes')";

							String windowObjecServlet = "window.open('../eCA/jsp/CAMainChart.jsp?"+query_string+"&window_name="+uniquewinname+"','"+uniquewinname+"','height=570,width=790,top=0,left=0,resizable=yes')";

							java.util.HashMap hashMapTempMap = new HashMap();
							java.util.HashMap sessionHashMap = new HashMap();
							java.util.ArrayList sessionList = new ArrayList();
					try{ // added by shaiju

							hashMapTempMap.put("patientId"+patient_id+episode_id+visit_id,patient_id);
							hashMapTempMap.put("episodeId"+patient_id+episode_id+visit_id,episode_id);
							hashMapTempMap.put("visitId"+patient_id+episode_id+visit_id,visit_id);
							hashMapTempMap.put("episodeType"+patient_id+episode_id+visit_id,episode_type);
							hashMapTempMap.put("locationCode"+patient_id+episode_id+visit_id,location_code);
							hashMapTempMap.put("locationType"+patient_id+episode_id+visit_id,location_type);
							hashMapTempMap.put("patOtherDetails"+patient_id+episode_id+visit_id,patOtherDetails);
							hashMapTempMap.put("windowName"+patient_id+episode_id+visit_id,patient_id+episode_id+visit_id);
							hashMapTempMap.put("windowObject"+patient_id+episode_id+visit_id,windowObject);		
							hashMapTempMap.put("windowObjecServlet"+patient_id+episode_id+visit_id,windowObjecServlet);

							sessionHashMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId());

							sessionList = (ArrayList) session.getAttribute("sessionList"+session.getId());
							if(!sessionList.contains(patient_id+episode_id+visit_id))
							{
								sessionList.add(patient_id+episode_id+visit_id);
								sessionHashMap.put(patient_id+episode_id+visit_id,hashMapTempMap);
							}
					   }
					catch(Exception e)
					  {
						
						out.println("Exception while putting data in HashMap "+e);
						
						e.printStackTrace();
					  }
							maintainPatientLog(request, patient_id, phys_prov_id,resp_id, phys_prov_reln_id,facility_id,login_user_id,episode_id,specialty_code,patient_class,location_code, "",out);//, episode_type);
							out.println("<script>parent.parent.document.getElementById('dialog-body').contentWindow.returnValue=\""+phys_prov_reln_id+"\";parent.parent.document.getElementById('dialog_tag').close();</script>");
						}
						else
							out.println("<script>parent.parent.document.getElementById('dialog-body').contentWindow.returnValue='F';parent.parent.document.getElementById('dialog_tag').close();;</script>");
					}

				}
				catch(Exception e)
				{
					//out.println("Assign Relationship Servlet Exception:"+e);
					
					e.printStackTrace();
					//out.println("<script>alert('"+e.toString()+"')</script>");//common-icn-0181
					//out.println("Exception while accessing AssignRelationship EJB for Inseting Records!"+e);//common-icn-0181
					
				}

		//	} // end of else -- if(rs.next())
        } // end of try
		catch(Exception e)
		{
			out.println("Exception@Insert:1 of AssignRelationshipServlet.java---: "+e);
			
			e.printStackTrace();
		} // end of catch
		finally
		{
			if(con!=null) { ConnectionManager.returnConnection(con,request); }
			out.println("</body></html>");

		} // end of finally
    } // end of method insertRelationshipAssignment

	private java.sql.Timestamp getTimeStamp(String date_time)
	{
		String token_date_dd = "", token_date_mm = "", token_date_yyyy = "";
		String token_time_hh24 = "", token_time_mi = "";
		StringBuffer dateTimeString = new StringBuffer();

		String dateString = date_time.substring(0,10);
		String timeString = date_time.substring(11,date_time.length());
		java.util.StringTokenizer stocken_date  = new java.util.StringTokenizer(dateString,"/");
		java.util.StringTokenizer stocken_time  = new java.util.StringTokenizer(timeString,":");

	try { //Added by shaiju

		while(stocken_date.hasMoreTokens())
		{
			token_date_dd	= stocken_date.nextToken();
			token_date_mm	= stocken_date.nextToken();
			token_date_yyyy = stocken_date.nextToken();
		}
		while(stocken_time.hasMoreTokens())
		{
			token_time_hh24	=	stocken_time.nextToken();
			token_time_mi	=	stocken_time.nextToken();
		}
	}
	catch(Exception e)
		{
		//out.println("Exception while getting the tokens... "+e);
		
		e.printStackTrace();
		}
		dateTimeString.append(token_date_yyyy + "-" + token_date_mm + "-" + token_date_dd);

		dateTimeString.append(" "+token_time_hh24 + ":" + token_time_mi + ":"+"00"+":"+"00");

		java.sql.Timestamp returnTimestamp = java.sql.Timestamp.valueOf(dateTimeString.toString());

		return returnTimestamp;
	} // end of getTimeStamp(String)

	
	public boolean maintainPatientLog(HttpServletRequest request, String patientid, String clinicianid, String respid, String relnid, String facility_id,String loginuserid, String episodeid,String specialty_code,String patient_class,String locn_code, String sessionid,java.io.PrintWriter out)//, String episodetype)
	{
		//Connection con = (Connection) session.getValue("connection");

		Connection con = null;
		int rs = 0;
		PreparedStatement stmt = null;
		CallableStatement cs = null;
		boolean ret = true;
		try
		{
			con = ConnectionManager.getConnection(request);

/*			String sql = " INSERT INTO CA_PATIENT_CHART_ACC_LOG "+
					" (PATIENT_ID "+
					" ,PHYS_PROV_ID "+
					" ,START_DATE_TIME "+
					" ,RESP_ID "+
					" ,PHYS_PROV_RELN_ID "+
					" ) "+
					" VALUES "+
					" ('"+patientid+"' "+
					" ,'"+clinicianid+"' "+
					" ,SYSDATE "+
					" ,'"+respid+"' "+
					" ,'"+relnid+"' "+
					" )";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(sql);

			if(rs != 0)
				ret = true;
			else
				ret = false;

			CallableStatement cs = con.prepareCall("{call MAINTAIN_RECENT_LIST (?,?,?,sysdate,?,?,?,?,?) }" );

			int ep = 0;
			int vis = 0;

			if(episodetype.equals("I"))
				visitid = "";

			if(!(episodeid.equals("") || episodeid == null))
				 ep = Integer.parseInt(episodeid);

			if(!(visitid.equals("") || visitid == null))
				vis = Integer.parseInt(visitid);

			cs.setString(1, facility_id);
			cs.setString(2, loginuserid);
			cs.setString(3, patientid);

			if( (episodeid==null) || (episodeid.equals("")) )
			{
				cs.setNull(4,Types.NUMERIC);
			}
			else
			{
				cs.setInt(4, ep);
			}

			if( (visitid==null) || (visitid.equals("")) )
			{
				cs.setNull(5,Types.NUMERIC);
			}
			else
			{
				cs.setInt(5,vis );
			}

			cs.setString(6, respid);
			cs.setString(7, relnid);
			cs.setString(8, sessionid);

			cs.execute();
*/
			StringBuffer sql =new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" INSERT INTO CA_PATIENT_CHART_ACC_LOG ");
			sql.append(" (PATIENT_ID ");
			sql.append(" ,PRACTITIONER_ID ");
			sql.append(" ,START_DATE_TIME ");
			sql.append(" ,RESP_ID ");
			sql.append(" ,PRACT_RELN_ID ");
			sql.append(" ,FACILITY_ID ");
			sql.append(" ,ENCOUNTER_ID ");
			sql.append(" ,SPECIALTY_CODE ");
			sql.append(" ,PATIENT_CLASS ");
			sql.append(" ,LOCN_CODE ");
			sql.append(" ) ");
			sql.append(" VALUES ");
			sql.append(" (? ");
			sql.append(" ,? ");
			sql.append(" ,SYSDATE ");
			sql.append(" ,? ");
			sql.append(" ,? ");
			sql.append(" ,? ");
			sql.append(" ,? ");//ENCOUNTER_ID
			sql.append(" ,? ");//ENCOUNTER_ID
			sql.append(" ,? ");//ENCOUNTER_ID
			sql.append(" ,? ");//ENCOUNTER_ID
			sql.append(" )");

			/*,ENCOUNTER_ID,SPECIALTY_CODE,PATIENT_CLASS,LOCN_CODE*/

			stmt = con.prepareStatement(sql.toString());

			stmt.setString(1,patientid);
			stmt.setString(2,clinicianid);
			stmt.setString(3,respid);
			stmt.setString(4,relnid);
			stmt.setString(5,facility_id);
			stmt.setString(6,episodeid);
			stmt.setString(7,specialty_code);
			stmt.setString(8,patient_class);
			stmt.setString(9,locn_code);

			rs = stmt.executeUpdate();
			if(rs != 0)
				ret = true;
			else
				ret = false;
		cs = con.prepareCall("{call MAINTAIN_RECENT_LIST (?,?,?,sysdate,?,?,?,?) }" );

		long ep =0l;
		//long vis =0l;

		if(!(episodeid.equals("") || episodeid.equals("null") || episodeid == null))
			 ep = Long.parseLong(episodeid);
			//ep = episodeid;
		
		//if(!(visitid.equals("") || visitid.equals("null") || visitid == null))
			//vis = Long.parseLong(visitid);
			//vs = visitid;
		cs.setString(1, facility_id);
		cs.setString(2, loginuserid);
		cs.setString(3, patientid);
		cs.setLong(4, ep);
		//cs.setInt(4,vis );
		cs.setString(5, respid);
		cs.setString(6, relnid);
		cs.setString(7, sessionid);

		cs.execute();
		con.commit();

		}
		catch (Exception e)
		{
			try{
				con.rollback();
			}catch(Exception ex){}
			//out.println("<script>alert('"+e.toString()+"');</script>");//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
			ret = false;
		}
		finally
		{
			try{
				if(stmt!=null) stmt.close();
				if(cs!=null) cs.close();
				if(con!=null) { ConnectionManager.returnConnection(con,request); }
			}catch(Exception e){}
		}
		return ret;
	}


	private void updateRelationshipAssignment(HttpServletRequest request, HttpServletResponse response, HttpSession session,java.io.PrintWriter out) throws ServletException, java.io.IOException
	{
		java.util.Properties	p		=	null;
//		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

       p =	(java.util.Properties)session.getValue("jdbc") ;
	   String locale = (String) p.getProperty("LOCALE");

		out.println ("<html><head>");
		out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
		out.println ("<title>Result</title></head>");
		out.println ("<body class='MESSAGE'>");

	//	Connection			con		=	null;
	//	PreparedStatement	pstmt	=	null;
	//	ResultSet			rs		=	null;

		String patient_id = "", facility_id = "",episode_id = "",added_date="";
		String phys_prov_id = "", phys_prov_reln_id = "" ;
		String end_date_time = "", resp_id = "", login_user_id = "" ;
		String  modal_yn = "", added_at_ws_no="" ;
		String  patient_class="",specialty_code="",location_code="";
	    String reason_Short_Desc="";
		String reason_text="";

		java.util.HashMap htAssignRelationship = new java.util.HashMap();

		try
        {
			session	=	request.getSession(false);
			//con		=	(Connection) session.getValue("connection");

			login_user_id		=	(String) session.getValue("login_user");
			facility_id			=	(String) session.getValue("facility_id");

			patient_id			=	request.getParameter("patient_id");
			//episode_type		=	request.getParameter("episode_type");
			episode_id			=	request.getParameter("episode_id");
			//visit_id			=	request.getParameter("visit_id");
			//phys_prov_id		=	request.getParameter("act_clinician_id");
			//phys_prov_id		=	request.getParameter("clinician_id"); COMMENDED ON 3/5/2007 BY RAJAN/SHAIJU
			phys_prov_id		=	request.getParameter("phys_prov_id");
			phys_prov_reln_id	=	request.getParameter("relationship");
			//begin_date_time		=	request.getParameter("start_date");
			end_date_time		=	request.getParameter("end_date");
			resp_id				=	request.getParameter("resp_id");
			added_date			=	request.getParameter("added_date");
			modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
			added_at_ws_no = request.getRemoteAddr();

			patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
			specialty_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
			location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
			 reason_Short_Desc= request.getParameter("reason_Short_Desc") == null ? "" :  request.getParameter("reason_Short_Desc");
			 reason_text=request.getParameter("reason_text") == null ? "" :  request.getParameter("reason_text");
			 //System.out.println("@@@@@@@@@@@@@@@@@@@@ reason_Desc"+reason_text);
			
			/*
				out.println("<script>");
				out.println("alert('login_user_id "+login_user_id+"');");
				out.println("alert('facility_id "+facility_id+"');");
				out.println("alert('patient_id "+patient_id+"');");
				out.println("alert('phys_prov_id"+phys_prov_id+"');");
				out.println("alert('phys_prov_reln_id"+phys_prov_reln_id+"');");
				out.println("alert('begin_date_time"+begin_date_time+"');");
				out.println("alert('end_date_time"+end_date_time+"');");
				out.println("alert('added_date "+added_date+"');");
				out.println("</script>");
			*/
				try
				{
					if(end_date_time == null ) end_date_time = "";


					end_date_time		= com.ehis.util.DateUtils.convertDate(end_date_time,"DMYHM",locale,"en");

					htAssignRelationship.put ( "patient_id",			patient_id			);
					htAssignRelationship.put ( "facility_id",			facility_id			);
					htAssignRelationship.put ( "phys_prov_id",			phys_prov_id		);
					htAssignRelationship.put ( "phys_prov_reln_id",		phys_prov_reln_id	);
					htAssignRelationship.put ( "end_date_time",			end_date_time		);
					htAssignRelationship.put ( "login_user_id",			login_user_id		);
					htAssignRelationship.put ( "practitioner_id",phys_prov_id);
					htAssignRelationship.put ( "added_facility_id",facility_id);
					htAssignRelationship.put ( "added_at_ws_no",added_at_ws_no);
					htAssignRelationship.put ( "added_date",added_date);
					htAssignRelationship.put ( "locale",locale);
					htAssignRelationship.put ( "remarks",reason_text);

				}
				catch(Exception e)
				{
					out.println("Exception while putting HashMap datas!"+e);
					e.printStackTrace();
					throw e;
				}

				try
				{
					/*InitialContext context = new InitialContext();

					Object homeObject = context.lookup("java:comp/env/AssignRelationship");

					AssignRelationshipHome assignRelationshipHome = (AssignRelationshipHome) PortableRemoteObject.narrow (homeObject, AssignRelationshipHome.class);

					AssignRelationshipRemote assignRelationshipRemote = assignRelationshipHome.create();

					java.util.HashMap results = assignRelationshipRemote.updateAssignRelationship(p, htAssignRelationship);*/

					
					
		boolean local_ejbs = false;
					
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AssignRelationship",AssignRelationshipHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = htAssignRelationship;
		
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = htAssignRelationship.getClass();
		


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateAssignRelationship",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		htAssignRelationship.clear();
					
					
					
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String err_msg = (String) results.get("error") ;
					results.clear();
					
					
					if(!(modal_yn.equals("Y")))
					{
						if(inserted)
						{
							out.println(err_msg);
							/*out.println("<script>var query_string=parent.frames(4).frames(1).frames(0).document.forms(0).query_string.value;");
							out.println("parent.frames(4).frames(1).frames(0).location.href = \"../eCA/jsp/AssignRelationshipView.jsp?\"+query_string;");
							out.println("parent.frames(4).frames(1).frames(1).location.href=\"../eCA/jsp/AssignRelationshipMain.jsp?\"+query_string;</script>");*/

							out.println("<script>var query_string=top.content.workAreaFrame.AssignRelationshipViewFrame.document.forms[0].query_string.value;");
							out.println("top.content.workAreaFrame.AssignRelationshipViewFrame.location.href = \"../eCA/jsp/AssignRelationshipView.jsp?\"+query_string;");
							out.println("top.content.workAreaFrame.AssignRelationshipFrame.location.href=\"../eCA/jsp/AssignRelationshipMain.jsp?\"+query_string;</script>");

							session.setAttribute("RELN_ASS","N");//shaiju
						} // end of if
						else
						{
							out.println(err_msg);
							if(err_msg.lastIndexOf("<br>") >=0 )
							{
								err_msg = err_msg.substring(0,err_msg.lastIndexOf("<br>"));
							}
							out.println("<script>alert('"+err_msg+"')</script>");
							//out.println("APP-SM0009 Operation Failed : "+err_msg);
						} // end of else
					}
					else
					{
					
						if(err_msg.lastIndexOf("<br>") >=0 )
						{
							err_msg = err_msg.substring(0,err_msg.lastIndexOf("<br>"));
						}
						//out.println("<script>alert(\""+err_msg+"\")</script>");
						out.println(err_msg);
						//out.println("<script>alert('Error While Commiting')</script>");
						if(inserted)
						{
							
							maintainPatientLog(request, patient_id, phys_prov_id,resp_id, phys_prov_reln_id,facility_id,login_user_id,episode_id,specialty_code,patient_class,location_code, "",out);//, episode_type);
							out.println("<script>parent.parent.document.getElementById('dialog-body').contentWindow.returnValue=\""+phys_prov_reln_id+"\";parent.parent.document.getElementById('dialog_tag').close();</script>");
						}
						else
							out.println("<script>parent.parent.document.getElementById('dialog-body').contentWindow.returnValue='F';parent.parent.document.getElementById('dialog_tag').close();</script>");
					}

				}
				catch(Exception e)
				{
					//out.println("<script>alert('"+e.toString()+"')</script>");//common-icn-0181
					e.printStackTrace();
				}

		//	} // end of else -- if(rs.next())
        } // end of try
		catch(Exception e)
		{
			out.println("Exception@Update:1 : from AssignRelationshipServlet.java --- "+e);
			
			e.printStackTrace();
		} // end of catch
		finally
		{
			//if(con!=null) { ConnectionManager.returnConnection(con,request); }
			out.println("</body></html>");

		} // end of finally
    } // end of method updateRelationshipAssignment
} // end of class AssignRelationshipServlet
