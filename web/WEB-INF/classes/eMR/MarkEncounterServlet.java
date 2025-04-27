/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class MarkEncounterServlet extends HttpServlet 
{
	PrintWriter out;
	Properties p;

	String mlc = "";
	String oscc = "";
	String marked_date = "";
	String file_no = "";
	String mlc_yn = "";
	String oscc_yn = "";
	String marked_by = "";
	String marked_date1 = "";
	String closed_by = ""; 
	String closed_date1 = "";	
	String locale="";
	String facilityId;
	String client_ip_address;
	String encounter_id = "";
	String patient_id = "";
	String sStyle="";
	//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
	String isDateTimeAppl="";
	//Added by Ajay Hatwate for GHL-CRF-0650 on 12/07/2023
	String isMLCAppl = "false";
	String mlcDeathYn = "";
	String polRepNo = "";
	String polStnDtl = "";
	String outsideMlcDtl = "";
	String mlcCaptDate = "";
	String mlcCaptDateAE = "";
	String mlcremark = "";
	String encType = "";

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException,IOException 
	{
		HttpSession session = req.getSession(false);
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try 
		{
			this.out = res.getWriter();
			insertMarkEncounter(req);		
		}
		catch (Exception e)	
		{
			  //out.println(e.toString());
			  e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");

			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/TerminalDigit.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	/* out.println(e.toString()); */ e.printStackTrace();}
	}

	private void insertMarkEncounter(HttpServletRequest req)	
	{	
		
		Connection con =null;
		Statement stmt	= null;
		ResultSet rset	= null;
		try 
		{
			con = ConnectionManager.getConnection(req);
			HashMap tabdata=new HashMap();			
			patient_id = req.getParameter("patient_id")==null?"":req.getParameter("patient_id");
			mlc_yn = req.getParameter("mlc")==null?"N":req.getParameter("mlc");
			if(mlc_yn.equals("Y")) 
				mlc = "MLC";
			else
				mlc = "N";

			oscc_yn = req.getParameter("oscc")==null?"N":req.getParameter("oscc");
			if(oscc_yn.equals("Y")) 
				oscc = "OSCC";
			else
				oscc = "N";

			//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
			isDateTimeAppl = req.getParameter("isDateTimeAppl")==null?"":req.getParameter("isDateTimeAppl");
			
			//marked_by = req.getParameter("marked_by")==null?"":req.getParameter("marked_by");
			marked_by = req.getParameter("marked_by_hid")==null?"":req.getParameter("marked_by_hid");
			
			marked_date1 = req.getParameter("marked_date")==null?"":req.getParameter("marked_date");
			//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
			if(("true").equals(isDateTimeAppl))
			{
				marked_date1 = DateUtils.convertDate(marked_date1,"DMYHM",locale,"en");
			}else
			{
				marked_date1 = DateUtils.convertDate(marked_date1,"DMY",locale,"en");
			}
			marked_date  = marked_date1;

			//closed_by = req.getParameter("closed_by")==null?"":req.getParameter("closed_by");
			closed_by = req.getParameter("closed_by_hid")==null?"":req.getParameter("closed_by_hid");

			closed_date1 = req.getParameter("closed_date")==null?"":req.getParameter("closed_date");

			//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
			if(("true").equals(isDateTimeAppl))
			{
				closed_date1 = DateUtils.convertDate(closed_date1,"DMYHM",locale,"en");
			}else
			{
				closed_date1 = DateUtils.convertDate(closed_date1,"DMY",locale,"en");
			}
			
			encounter_id = req.getParameter("ENCOUNTER_ID")==null?"":req.getParameter("ENCOUNTER_ID");	
						
			//Added by Ajay Hatwate for GHL-CRF-0650
			isMLCAppl = req.getParameter("isMLCAppl")==null?"false":req.getParameter("isMLCAppl");
			 mlcDeathYn = req.getParameter("mlc_death")==null?"N":req.getParameter("mlc_death");
			 polRepNo = req.getParameter("police_rep_no")==null?"":req.getParameter("police_rep_no");
			 polStnDtl = req.getParameter("police_stn_dtls")==null?"":req.getParameter("police_stn_dtls");
			 outsideMlcDtl = req.getParameter("outside_mlc_dtls")==null?"":req.getParameter("outside_mlc_dtls");
			 mlcCaptDate = req.getParameter("date_of_mlc_capture")==null?"":req.getParameter("date_of_mlc_capture");
			 mlcremark = req.getParameter("mlc_remarks")==null?"":req.getParameter("mlc_remarks");

			 encType = req.getParameter("encType")==null?"":req.getParameter("encType");
			 mlcCaptDateAE = mlcCaptDate;
			//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
			if(("true").equals(isDateTimeAppl))
			{
				if(!marked_date1.equals("")){
					StringTokenizer preparetoks = new StringTokenizer (marked_date1," ") ;
					StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(),"/") ;
					String prepareArr[] =new String[3] ;
					for ( int p=0;p<3;p++ )	
						prepareArr[p] = preparetok1.nextToken() ;
					marked_date1 = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken()+":00"  ;
					Timestamp marked_date_stamp= Timestamp.valueOf(marked_date1);
					tabdata.put("MARKED_DATE",marked_date_stamp);
				}else{
					tabdata.put("MARKED_DATE","");
				}	
			}else
			{
				if(!marked_date1.equals(""))
				{
					StringTokenizer preparetoks = new StringTokenizer (marked_date1,"/") ;

					String prepareArr[] =new String[3] ;
					for( int p=0;p<3;p++ )
					prepareArr[p] = preparetoks.nextToken() ;

					marked_date1 = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" 00:00:00"   ;
					Timestamp marked_date_stamp= Timestamp.valueOf(marked_date1);
					tabdata.put("MARKED_DATE",marked_date_stamp);
				}
				else
				{
					tabdata.put("MARKED_DATE","");
				}
			}
			
			//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
			if(("true").equals(isDateTimeAppl))
			{
				if(!closed_date1.equals("")){
					StringTokenizer preparetoks = new StringTokenizer (closed_date1," ") ;
					StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(),"/") ;
					String prepareArr[] =new String[3] ;
					for ( int p=0;p<3;p++ )	
						prepareArr[p] = preparetok1.nextToken() ;
					closed_date1 = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken()+":00"  ;
					Timestamp closed_date_stamp= Timestamp.valueOf(closed_date1);
					tabdata.put("CLOSED_DATE",closed_date_stamp);
				}else{
					tabdata.put("CLOSED_DATE","");
				}	
			}else
			{
				if(!closed_date1.equals("")) 
				{
					StringTokenizer preparetoks2 = new StringTokenizer (closed_date1,"/") ;
					String prepareArr1[] =new String[3] ;
					for( int q=0;q<3;q++ )
						prepareArr1[q] = preparetoks2.nextToken() ;

					closed_date1 = prepareArr1[2] +"-"+prepareArr1[1]+"-"+ prepareArr1[0]+" 00:00:00"   ;
					Timestamp closed_date_stamp= Timestamp.valueOf(closed_date1);
					tabdata.put("CLOSED_DATE",closed_date_stamp);
				}else
				{
					tabdata.put("CLOSED_DATE","");
				}
			}

			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			tabdata.put("mlc_yn",mlc_yn);
			tabdata.put("oscc_yn",oscc_yn);
			tabdata.put("marked_by_id",marked_by );
			tabdata.put("closed_by_id",closed_by );
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			if(("true").equals(isMLCAppl)){
				mlcCaptDate = DateUtils.convertDate(mlcCaptDate,"DMYHMS",locale,"en");
				if(!mlcCaptDate.equals("")){
					StringTokenizer preparetoks = new StringTokenizer (mlcCaptDate," ") ;
					StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(),"/") ;
					String prepareArr[] =new String[3] ;
					for ( int p=0;p<3;p++ )	
						prepareArr[p] = preparetok1.nextToken() ;
					mlcCaptDate = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken();
					Timestamp closed_date_stamp= Timestamp.valueOf(mlcCaptDate);
					tabdata.put("mlc_capture_date",closed_date_stamp);
				}else{
					tabdata.put("mlc_capture_date","");
				}	
				tabdata.put("pol_rep_no",polRepNo );
				tabdata.put("pol_stn_id",polStnDtl );
				tabdata.put("mlc_death_yn",mlcDeathYn );
				tabdata.put("mlc_no_outside_dtls",outsideMlcDtl );
				tabdata.put("mlc_remarks",mlcremark );	
			}

			HashMap tabdata1 = new HashMap();
			tabdata1.put("ENCOUNTER_ID",encounter_id);
	
			String tableName = "PR_ENCOUNTER";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = tabdata1;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = tabdata1.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;		

			if(inserted)
			{

				Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				error = (String) message.get("message") ;

				 /*Below line commented for this SCF HSA-SCF-0144 [IN:051695]*/	  
				/*try
				{
					stmt=con.createStatement();
					String sql=" SELECT file_no from FM_ENCOUNTER_VOLUME_LINK where facility_id = '"+facilityId+"' and patient_id = '"+patient_id+"' and encounter_id = '"+encounter_id+"' ";	

					rset=stmt.executeQuery(sql);
					if(rset.next() && rset!=null)
					{
						file_no = rset.getString("file_no");		
                       					
						printOnlineReports(patient_id,file_no,encounter_id,mlc,oscc,marked_by,marked_date);
					}

					if (stmt != null) stmt.close();
					if (rset != null) rset.close();
				}catch(Exception e) { out.println(e.toString());e.printStackTrace();}*/
				//End  HSA-SCF-0144 [IN:051695]
			}
			else
			{
				error = (String) results.get("error") ;
				error = "Errors Encountered..";
			}

			//error= error.substring(0,error.indexOf("<br>")) ;
			out.println("<script>alert(\""+error+"\");</script>") ;	
			//out.println("<script>parent.window.close();</script>");
			out.println("<script> parent.document.getElementById('dialog_tag').close();</script>");
			if ( tabdata != null) tabdata.clear();
			if ( tabdata1 != null) tabdata1.clear();
			if ( results != null) results.clear();
		}catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}

/*Below line commented for this SCF HSA-SCF-0144 [IN:051695]*/	  
	/// ADDED BY SRIDHAR R on 3 Nov 2004...to call online reports..if file no exists..
/*	private void printOnlineReports(String patient_id, String file_no, String encounter_id, String mlc_yn, String oscc_yn, String marked_by, String marked_dt)throws ServletException, IOException, SQLException
	{
		String sqlString	= "";		

		try
		{
			sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRPFLBL' ";

			String reportParamNames = "P_PATIENT_ID,P_ENCOUNTER_ID,P_FILE_NO,P_MLC,P_OSCC,P_MARKED_BY,P_MARKED_DATE";
			String reportParamValues = ""+patient_id+","+encounter_id+","+file_no+","+mlc_yn+","+oscc_yn+","+marked_by+","+marked_dt+"";
			
			StringBuffer htmlFor = new StringBuffer();

			htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link> ");
			htmlFor.append("</head><body class	='message'> ");
			htmlFor.append("<script language	= 'JavaScript'> ");
			htmlFor.append("  var dialogHeight	= '25'; ");
			htmlFor.append("  var dialogWidth	= '65'; ");
			htmlFor.append("  var dialogTop		= '58'; ");
			htmlFor.append("  var arguments		= ''; ");
	    	// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append("  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=PROCEDURE_FOR_ENCOUNTER&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"'; ");
			htmlFor.append(" var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;'; ");
			htmlFor.append(" retVal = window.showModalDialog(getUrl,arguments,features); parent.window.close(); ");
			htmlFor.append(" </script> ");
			out.println(htmlFor.toString());
			out.println(" </body></html> ");
		
		}
		catch ( Exception e )
		{
			out.println("Encountered error while Processing Online Reports from MLC/OSCC : "+e.toString());
			e.printStackTrace();
		}
	}*/
	/*End this SCF HSA-SCF-0144 [IN:051695]*/	  




}

