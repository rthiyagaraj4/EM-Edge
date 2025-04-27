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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eMR.TerminologySetForPractitioner.*;


public class TerminologySetForPractionerServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String term_set_id;
	String pract_type;
	String facilityId1 ;
	String client_ip_address ;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId1 = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			SpecialityAddModify(req,res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req = req;
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
		}
		catch(Exception e)	
		{	
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	private void SpecialityAddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
	        HashMap tabdata=new HashMap();
            RecordSet	 TerminologyForPractitioner	=	null;
            RecordSet	 TerminologyForPractitioner1	=	null;
            String checkedOnes = "";
            String	from	=	"",	to		=	"";
			//String dftcheckedOnes="";
			term_set_id = req.getParameter("term_set_id");
			if(term_set_id == null) term_set_id="";
			pract_type = req.getParameter("pract_type");
			if(pract_type == null) pract_type="";
			tabdata.put("term_set_id",term_set_id );
			tabdata.put("pract_type",pract_type );
            from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
			TerminologyForPractitioner	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologyForPractitioner");
			TerminologyForPractitioner1	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologyForPractitioner1");
			if(from != null && to != null)
			{
					from	=	from.trim();
					to		=	to.trim();
					
					for( int i=(Integer.parseInt(from)); i<=(Integer.parseInt(to)); i++)
					{
						//if(req.getParameter(("chk"+i)) != null)|| req.getParameter(("dftselect"+i)) != null)
						if(req.getParameter(("chk"+i)) != null) 
						{
							checkedOnes = req.getParameter(("chk"+i));
							if(!(TerminologyForPractitioner.containsObject(checkedOnes)))
								TerminologyForPractitioner.putObject(checkedOnes);
							

						}


						

						String removeCode = checkForNull(req.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String practCode = req.getParameter("practCode"+(i));
							if((TerminologyForPractitioner.containsObject(practCode)))
							{
								int removeCodeIndex = TerminologyForPractitioner.indexOfObject(practCode);
								TerminologyForPractitioner.removeObject(removeCodeIndex);
							}
						}



						if(req.getParameter(("dftselect"+i)) != null)
					{
						checkedOnes = req.getParameter(("dftselect"+i));
				
						if(!(TerminologyForPractitioner1.containsObject(checkedOnes)))
							TerminologyForPractitioner1.putObject(checkedOnes);
					}

					String dftremoveCode = checkForNull(req.getParameter("dftremoveCode"+(i)));
					if(dftremoveCode.equals("Y"))
					{
						String dftpractTypeCode = req.getParameter("dftpractTypeCode"+(i));
						if((TerminologyForPractitioner1.containsObject(dftpractTypeCode)))
						{
							int removeCodeIndex = TerminologyForPractitioner1.indexOfObject(dftpractTypeCode);
							TerminologyForPractitioner1.removeObject(removeCodeIndex);
						}
					}

					}
			}

           int size=TerminologyForPractitioner.getSize();
			int size1=TerminologyForPractitioner1.getSize();
			for(int i=0;i< size1;i++){}

			for(int i=0;i< size;i++){
				tabdata.put( ("chk"+i), (String)TerminologyForPractitioner.getObject(i) );
				//tabdata.put( ("dftselect"+i), (String)TerminologyForPractitioner1.getObject(i) );
			}
			String slCount	=	""+TerminologyForPractitioner.getSize();
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId1 ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("totCount", new Integer(slCount) );
			tabdata.put("recordSet",TerminologyForPractitioner1);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TerminologySetForPractitioner",TerminologySetForPractitionerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("SpecialityAddModify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		} 
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();

		}
	}//E.O.Method

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}
}
