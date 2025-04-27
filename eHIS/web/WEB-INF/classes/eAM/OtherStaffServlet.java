/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM ;
import eAM.OtherStaff.*;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;

public class OtherStaffServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
java.util.Properties p;
String otherstafftype;
String otherstaffid ;
String otherstaffname;
String shortname ;
String sex;
String birthdate;
String birthplace;
String maritalstatus;
String aliasname;
String citizen;
String nationalidno;
String Position;
String emplstatus;
String degree;
String allfacilities;
String repfacility;
String restelno;
String pagerno;
String mobileno;
String offtelno;
String offtelext;
String faxno;
String emailid;
String prefmode;
String resaddln1;
String resaddln2;
String resaddln3;
String resaddln4;
String respostalcode;
String rescountrycode;
String offaddln1;
String offaddln2;
String offaddln3;
String offaddln4;
String offpostalcode;
String offcountrycode;
String mailaddln1;
String mailaddln2;
String mailaddln3;
String mailaddln4;
String mailpostalcode;
String mailcountrycode;
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;
String facilityId ;
String client_ip_address ;
String employeeid;
String locale="";
String longname="";

//Below line Added for this CRF HSA-CRF-160
String other_alt_type="";
String other_alt_no="";

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
       res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);		
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		locale=(String)session.getAttribute("LOCALE"); 
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");



	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function");

		
	if ( operation.equals("insert") )
		insertOperation(req, res);
	if ( operation.equals("modify"))
			updateOperation(req, res);
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
    }


public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException {
	try	{
		this.out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='Javascript' src='../eAM/js/OtherStaff.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=VisitType' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	} catch(Exception e)	{
	e.printStackTrace();}
}


private void updateOperation(HttpServletRequest req, HttpServletResponse res)	{
	try {

		HashMap tabData=new HashMap();

	otherstafftype =req.getParameter("other_staff_type1")== null ? "":req.getParameter("other_staff_type1");
	otherstaffid=req.getParameter("other_staff_id1")== null ? "":req.getParameter("other_staff_id1");
	otherstaffname=req.getParameter("other_staff_name1")== null ? "":req.getParameter("other_staff_name1");
	shortname=req.getParameter("short_name1")== null ? "":req.getParameter("short_name1");
	sex=req.getParameter("sex2")== null ? "":req.getParameter("sex2");
	birthdate=req.getParameter("date_of_birth1")== null ? "":req.getParameter("date_of_birth1");
	
	
	birthdate=DateUtils.convertDate(birthdate,"DMY",locale,"en");
	


	birthplace=req.getParameter("birth_place")== null ? "":req.getParameter("birth_place");
	maritalstatus=req.getParameter("marital_status")== null ? "":req.getParameter("marital_status");
	aliasname=req.getParameter("alias_name")== null ? "":req.getParameter("alias_name");
	citizen=req.getParameter("citizen2")== null ? "":req.getParameter("citizen2");
	nationalidno=req.getParameter("national_id_no")== null ? "":req.getParameter("national_id_no");
	Position=req.getParameter("Position")== null ? "":req.getParameter("Position");
	emplstatus=req.getParameter("empl_status2")== null ? "":req.getParameter("empl_status2");
	degree=req.getParameter("degree")== null ? "":req.getParameter("degree");
	allfacilities=req.getParameter("all_facilities1")== null ? "N":req.getParameter("all_facilities1");
	repfacility=req.getParameter("rep_facility")== null ? "":req.getParameter("rep_facility");
	restelno=req.getParameter("residencetelno")== null ? "":req.getParameter("residencetelno");
	pagerno=req.getParameter("pagerno")== null ? "":req.getParameter("pagerno");
	mobileno=req.getParameter("mobileno")== null ? "":req.getParameter("mobileno");
	offtelno=req.getParameter("offtelno")== null ? "":req.getParameter("offtelno");
	offtelext=req.getParameter("offtelext")== null ? "":req.getParameter("offtelext");
	faxno=req.getParameter("faxno")== null ? "":req.getParameter("faxno");
	emailid=req.getParameter("emailid")== null ? "":req.getParameter("emailid");
	prefmode=req.getParameter("pref_contact_mode2")== null ? "":req.getParameter("pref_contact_mode2");
	resaddln1=req.getParameter("res_add_ln1")== null ? "":req.getParameter("res_add_ln1");
	resaddln2=req.getParameter("res_add_ln2")== null ? "":req.getParameter("res_add_ln2");
	resaddln3=req.getParameter("res_add_ln3")== null ? "":req.getParameter("res_add_ln3");
	resaddln4=req.getParameter("res_add_ln4")== null ? "":req.getParameter("res_add_ln4");
	respostalcode=req.getParameter("res_add_postal_code2")== null ? "":req.getParameter("res_add_postal_code2");
	rescountrycode=req.getParameter("res_add_country_code2")== null ? "":req.getParameter("res_add_country_code2");
	offaddln1=req.getParameter("off_add_ln1")== null ? "":req.getParameter("off_add_ln1");
	offaddln2=req.getParameter("off_add_ln2")== null ? "":req.getParameter("off_add_ln2");
	offaddln3=req.getParameter("off_add_ln3")== null ? "":req.getParameter("off_add_ln3");
	offaddln4=req.getParameter("off_add_ln4")== null ? "":req.getParameter("off_add_ln4");
	offpostalcode=req.getParameter("off_add_postal_code2")== null ? "":req.getParameter("off_add_postal_code2");
	offcountrycode=req.getParameter("off_add_country_code2")== null ? "":req.getParameter("off_add_country_code2");
	mailaddln1=req.getParameter("mail_add_ln1")== null ? "":req.getParameter("mail_add_ln1");
	mailaddln2=req.getParameter("mail_add_ln2")== null ? "":req.getParameter("mail_add_ln2");
	mailaddln3=req.getParameter("mail_add_ln3")== null ? "":req.getParameter("mail_add_ln3");
	mailaddln4=req.getParameter("mail_add_ln4")== null ? "":req.getParameter("mail_add_ln4");
	mailpostalcode=req.getParameter("mail_add_postal_code2")== null ? "":req.getParameter("mail_add_postal_code2");
	mailcountrycode=req.getParameter("mail_add_country_code2")== null ? "":req.getParameter("mail_add_country_code2");
	effectiveDateFrom = req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from") ;
	effectiveDateTo = req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status1")== null ? "D":req.getParameter("eff_status1");
	employeeid = req.getParameter("employee_id") == null ? "":req.getParameter("employee_id");
	longname=req.getParameter("long_name1")== null ? "":req.getParameter("long_name1"); 
	
	 //Below line Added for this CRF HSA-CRF-160
	other_alt_type=req.getParameter("other_alt_type")==null?"":req.getParameter("other_alt_type");	
	other_alt_no=req.getParameter("other_alt_no1")==null?"":req.getParameter("other_alt_no1");	
	
		if(Position==null || Position.equals("null")) Position="";
tabData.put("otherstafftype",otherstafftype);

tabData.put("otherstaffid",otherstaffid);
tabData.put("otherstaffname",otherstaffname);
tabData.put("shortname",shortname);
tabData.put("sex",sex);
tabData.put("birthdate",birthdate);
tabData.put("birthplace",birthplace);
tabData.put("maritalstatus",maritalstatus);
tabData.put("aliasname",aliasname);
tabData.put("citizen",citizen);
tabData.put("nationalidno",nationalidno);
tabData.put("Position",Position);
tabData.put("emplstatus",emplstatus);
tabData.put("degree",degree);
tabData.put("allfacilities",allfacilities);
tabData.put("repfacility",repfacility);
tabData.put("restelno",restelno);
tabData.put("pagerno",pagerno);
tabData.put("mobileno",mobileno);
tabData.put("offtelno",offtelno);
tabData.put("offtelext",offtelext);
tabData.put("faxno",faxno);
tabData.put("emailid",emailid);
tabData.put("prefmode",prefmode);
tabData.put("resaddln1",resaddln1);
tabData.put("resaddln2",resaddln2);
tabData.put("resaddln3",resaddln3);
tabData.put("resaddln4",resaddln4);
tabData.put("respostalcode",respostalcode);
tabData.put("rescountrycode",rescountrycode);
tabData.put("offaddln1",offaddln1);
tabData.put("offaddln2",offaddln2);
tabData.put("offaddln3",offaddln3);
tabData.put("offaddln4",offaddln4);
tabData.put("offpostalcode",offpostalcode);
tabData.put("offcountrycode",offcountrycode);
tabData.put("mailaddln1",mailaddln1);
tabData.put("mailaddln2",mailaddln2);
tabData.put("mailaddln3",mailaddln3);
tabData.put("mailaddln4",mailaddln4);
tabData.put("mailpostalcode",mailpostalcode);
tabData.put("mailcountrycode",mailcountrycode);
tabData.put("effectiveDateFrom",effectiveDateFrom);
tabData.put("effectiveDateTo",effectiveDateTo);
tabData.put("effectiveStatus",effectiveStatus);
tabData.put("facilityId",facilityId);
tabData.put("client_ip_address",client_ip_address);
tabData.put("employeeid",employeeid);
tabData.put("longname",longname);
//Below line Added for this CRF HSA-CRF-160
tabData.put("other_alt_type",other_alt_type);
tabData.put("other_alt_no",other_alt_no);

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OtherStaff", eAM.OtherStaff.OtherStaffHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = p;
				aobj[1] = tabData;
				Class aclass[] = new Class[2];
				aclass[0] = p.getClass();
				aclass[1] = tabData.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("updateOperation", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

        String error = (String) results.get("error") ;
    	  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=1"  );

          tabData.clear();
		  results.clear();

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			}
	}
private void insertOperation(HttpServletRequest req, HttpServletResponse res)	{
	try {
		HashMap tabData = new HashMap();
		
	otherstafftype =req.getParameter("other_staff_type1")== null ? "":req.getParameter("other_staff_type1");
	otherstaffid=req.getParameter("other_staff_id1")== null ? "":req.getParameter("other_staff_id1");
	otherstaffname=req.getParameter("other_staff_name1")== null ? "":req.getParameter("other_staff_name1");
	shortname=req.getParameter("short_name1")== null ? "":req.getParameter("short_name1");
	sex=req.getParameter("sex")== null ? "":req.getParameter("sex");
	birthdate=req.getParameter("date_of_birth1")== null ? "":req.getParameter("date_of_birth1");
	
	
	birthdate=DateUtils.convertDate(birthdate,"DMY",locale,"en");
	

	birthplace=req.getParameter("birth_place")== null ? "":req.getParameter("birth_place");
	maritalstatus=req.getParameter("marital_status")== null ? "":req.getParameter("marital_status");
	aliasname=req.getParameter("alias_name")== null ? "":req.getParameter("alias_name");
	citizen=req.getParameter("citizen")== null ? "":req.getParameter("citizen");
	nationalidno=req.getParameter("national_id_no")== null ? "":req.getParameter("national_id_no");
	Position=req.getParameter("Position")== null ? "":req.getParameter("Position");
	emplstatus=req.getParameter("empl_status")== null ? "":req.getParameter("empl_status");
	degree=req.getParameter("degree")== null ? "":req.getParameter("degree");
	allfacilities=req.getParameter("all_facilities")== null ? "N":req.getParameter("all_facilities");
	repfacility=req.getParameter("rep_facility")== null ? "":req.getParameter("rep_facility");
	restelno=req.getParameter("residencetelno")== null ? "":req.getParameter("residencetelno");
	pagerno=req.getParameter("pagerno")== null ? "":req.getParameter("pagerno");
	mobileno=req.getParameter("mobileno")== null ? "":req.getParameter("mobileno");
	offtelno=req.getParameter("offtelno")== null ? "":req.getParameter("offtelno");
	offtelext=req.getParameter("offtelext")== null ? "":req.getParameter("offtelext");
	faxno=req.getParameter("faxno")== null ? "":req.getParameter("faxno");
	emailid=req.getParameter("emailid")== null ? "":req.getParameter("emailid");
	prefmode=req.getParameter("pref_contact_mode")== null ? "":req.getParameter("pref_contact_mode");
	resaddln1=req.getParameter("res_add_ln1")== null ? "":req.getParameter("res_add_ln1");
	resaddln2=req.getParameter("res_add_ln2")== null ? "":req.getParameter("res_add_ln2");
	resaddln3=req.getParameter("res_add_ln3")== null ? "":req.getParameter("res_add_ln3");
	resaddln4=req.getParameter("res_add_ln4")== null ? "":req.getParameter("res_add_ln4");
	respostalcode=req.getParameter("res_add_postal_code")== null ? "":req.getParameter("res_add_postal_code");
	rescountrycode=req.getParameter("res_add_country_code")== null ? "":req.getParameter("res_add_country_code");
	offaddln1=req.getParameter("off_add_ln1")== null ? "":req.getParameter("off_add_ln1");
	offaddln2=req.getParameter("off_add_ln2")== null ? "":req.getParameter("off_add_ln2");
	offaddln3=req.getParameter("off_add_ln3")== null ? "":req.getParameter("off_add_ln3");
	offaddln4=req.getParameter("off_add_ln4")== null ? "":req.getParameter("off_add_ln4");
	offpostalcode=req.getParameter("off_add_postal_code")== null ? "":req.getParameter("off_add_postal_code");
	offcountrycode=req.getParameter("off_add_country_code")== null ? "":req.getParameter("off_add_country_code");
	mailaddln1=req.getParameter("mail_add_ln1")== null ? "":req.getParameter("mail_add_ln1");
	mailaddln2=req.getParameter("mail_add_ln2")== null ? "":req.getParameter("mail_add_ln2");
	mailaddln3=req.getParameter("mail_add_ln3")== null ? "":req.getParameter("mail_add_ln3");
	mailaddln4=req.getParameter("mail_add_ln4")== null ? "":req.getParameter("mail_add_ln4");
	mailpostalcode=req.getParameter("mail_add_postal_code")== null ? "":req.getParameter("mail_add_postal_code");
	mailcountrycode=req.getParameter("mail_add_country_code")== null ? "":req.getParameter("mail_add_country_code");
	effectiveDateFrom = req.getParameter("eff_date_from")== null ? "":req.getParameter("eff_date_from");
	effectiveDateTo = req.getParameter("eff_date_to")== null ? "":req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status1")== null ? "D":req.getParameter("eff_status1");
	employeeid = req.getParameter("employee_id") == null ? "":req.getParameter("employee_id");
	longname=req.getParameter("long_name1")== null ? "":req.getParameter("long_name1");    
	
	//Below line Added for this CRF HSA-CRF-160
	other_alt_type=req.getParameter("other_alt_type")==null?"":req.getParameter("other_alt_type");	
	other_alt_no=req.getParameter("other_alt_no1")==null?"":req.getParameter("other_alt_no1");

tabData.put("otherstafftype",otherstafftype);
tabData.put("otherstaffid",otherstaffid);
tabData.put("otherstaffname",otherstaffname);
tabData.put("shortname",shortname);
tabData.put("sex",sex);
tabData.put("birthdate",birthdate);
tabData.put("birthplace",birthplace);
tabData.put("maritalstatus",maritalstatus);
tabData.put("aliasname",aliasname);
tabData.put("citizen",citizen);
tabData.put("nationalidno",nationalidno);
tabData.put("Position",Position);
tabData.put("emplstatus",emplstatus);
tabData.put("degree",degree);
tabData.put("allfacilities",allfacilities);
tabData.put("repfacility",repfacility);
tabData.put("restelno",restelno);
tabData.put("pagerno",pagerno);
tabData.put("mobileno",mobileno);
tabData.put("offtelno",offtelno);
tabData.put("offtelext",offtelext);
tabData.put("faxno",faxno);
tabData.put("emailid",emailid);
tabData.put("prefmode",prefmode);
tabData.put("resaddln1",resaddln1);
tabData.put("resaddln2",resaddln2);
tabData.put("resaddln3",resaddln3);
tabData.put("resaddln4",resaddln4);
tabData.put("respostalcode",respostalcode);
tabData.put("rescountrycode",rescountrycode);
tabData.put("offaddln1",offaddln1);
tabData.put("offaddln2",offaddln2);
tabData.put("offaddln3",offaddln3);
tabData.put("offaddln4",offaddln4);
tabData.put("offpostalcode",offpostalcode);
tabData.put("offcountrycode",offcountrycode);
tabData.put("mailaddln1",mailaddln1);
tabData.put("mailaddln2",mailaddln2);
tabData.put("mailaddln3",mailaddln3);
tabData.put("mailaddln4",mailaddln4);
tabData.put("mailpostalcode",mailpostalcode);
tabData.put("mailcountrycode",mailcountrycode);
tabData.put("effectiveDateFrom",effectiveDateFrom);
tabData.put("effectiveDateTo",effectiveDateTo);
tabData.put("effectiveStatus",effectiveStatus);
tabData.put("facilityId",facilityId);
tabData.put("client_ip_address",client_ip_address);
tabData.put("employeeid",employeeid);
tabData.put("longname",longname);
//Below line Added for this CRF HSA-CRF-160
tabData.put("other_alt_type",other_alt_type);
tabData.put("other_alt_no",other_alt_no);


				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OtherStaff", eAM.OtherStaff.OtherStaffHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = p;
				aobj[1] = tabData;
				Class aclass[] = new Class[2];
				aclass[0] = p.getClass();
				aclass[1] = tabData.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("insertOperation", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		if ( inserted )
			{
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8"  ) );
			}

			tabData.clear();
		  results.clear();
		} catch ( Exception e ) {
		out.println(e.getMessage());
		out.println(e.toString());
		e.printStackTrace();
		}


	}

	}
