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
import com.ehis.util.*;

import eOA.TransferClinicSch.* ;
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0165


public class TransferClinicSchServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;

String facilityId;
String client_ip_address ;

String finalvals ;
String noofrec ;
String selrec ;
String efffrom;
String effto;
String reason;
String dateday;
String fid;
int n;
int s;
int  rsval = 0;
String status="Y";

String P_To_Day_No ="";
String datsql ="";
String str = "";
String locn = "";
String pract ="";
String curdat = "";
String curdayno = "";
String transdat="";
String transdayno = "";
String genrep ="";
String datval = "";
String sqlrep ="";
String locncode ="";
String practid ="";
String p_report_id ="";
String p_module_id ="";
String fromday ="";
String today ="";
String FromStr="";
String ToStr="";
String finalvals1;
String locationType="";
String resourceType="";

String other_remarks; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

Connection con=null;

int noofappts_no=0;


public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{

	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;
	//String locale=(String)session.getAttribute("LOCALE"); 
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	//Added by Kamatchi S for security issue against COMMON-ICN-0165
	req = new XSSRequestWrapper(req);
	res.addHeader("X-XSS-Protection", "1; mode=block");
	res.addHeader("X-Content-Type-Options", "nosniff");
	fid=p.getProperty( "login_user" ) ;

	try {
	this.out = res.getWriter();
	efffrom = req.getParameter("eff_from");
	effto = req.getParameter("eff_to");
	reason = req.getParameter("reason");
	finalvals = req.getParameter("final_vals");
	finalvals1= req.getParameter("final_vals1");

	other_remarks = req.getParameter("other_remarks")==null?"":req.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	//efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
	//effto=DateUtils.convertDate(effto,"DMY",locale,"en");

	noofrec = req.getParameter("no_of_rec");
	selrec = req.getParameter("sel_rec");
	dateday = req.getParameter("date_day");
	curdayno = req.getParameter("cur_day_no");
	transdayno = req.getParameter("trans_day_no");
	n = Integer.parseInt(noofrec);
	s = Integer.parseInt(selrec);
	genrep = req.getParameter("genrep");

	practid = req.getParameter("practid");
	if (practid== null) practid ="";

	locncode = req.getParameter("locncode");
	if (locncode== null) locncode ="";

	p_module_id = req.getParameter("p_module_id");
	p_report_id = req.getParameter("p_report_id");

	fromday = req.getParameter("fromday");
	if (fromday== null) fromday ="";

	today = req.getParameter("today");
	if (today== null) today ="";

	P_To_Day_No = req.getParameter("P_To_Day_No");
		if (P_To_Day_No== null) P_To_Day_No ="";

    locationType=req.getParameter("locnType")==null?"":req.getParameter("locnType");
	resourceType=req.getParameter("resType")==null?"":req.getParameter("resType");
    
	if((genrep== null)||(genrep.equals("null"))||(genrep.equals("")))genrep ="N";
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		con = ConnectionManager.getConnection(req);
		datsql ="select to_char(sysdate,'ddmmyyyyhh24miss') dttm from dual";
   		pstmt=con.prepareStatement(datsql);
		rs=pstmt.executeQuery();
		rs.next();
		datval =(String)rs.getString("dttm");

	   if (rs != null) rs.close();
		 if (pstmt != null) pstmt.close();

	 }catch(Exception e ){
		 //out.println("Error " +e);
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}finally{

		if(con!=null) ConnectionManager.returnConnection(con,req);
	
	}

	status="Y";
	FromStr="";
	ToStr="";
	String no_Appt="";
	noofappts_no=0;
	String finalvals2=finalvals.substring(0,finalvals.length() -1);


	StringTokenizer st = new StringTokenizer(finalvals2,"-");
	StringTokenizer st1=null;
		while(st.hasMoreTokens())
		{
			str = st.nextToken();
			st1 = new StringTokenizer(str,"|");
			while(st1.hasMoreTokens())
			{	
				if (st1.hasMoreTokens())
				{
				locn = st1.nextToken();
				}
				if (st1.hasMoreTokens())
				{
				pract = st1.nextToken();
				if (pract.equals("~"))	pract="";
				}
				if (st1.hasMoreTokens())
				{
				curdat = st1.nextToken();
				FromStr=FromStr+curdat+"|";
				}
				if (st1.hasMoreTokens())
				{
				transdat = st1.nextToken();
				ToStr=ToStr+transdat+"|";
				}
				if (st1.hasMoreTokens())
				{
					no_Appt=st1.nextToken();

				noofappts_no=noofappts_no+Integer.parseInt(no_Appt);
				
				}
			
			}
			if(genrep.equals("Y")){
				GenReport(req);
			}
		}
			
		if(genrep.equals("N")){
		UpdateSch(req);
		}
		if(genrep.equals("Y"))
		{
			res.sendRedirect("../eOA/jsp/GenReport.jsp?P_From_Date="+efffrom+"&P_To_Day_No="+P_To_Day_No+"&P_Day_No="+fromday+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&P_Facility_id="+facilityId+"&P_user_id="+fid+"&P_To_Date="+effto+"&P_Clinic_Code="+locncode+"&P_Practitioner_Id="+practid+"&P_Reason="+reason+"&P_Action=Transfer Schedule"+"&P_Event_Date="+datval+"&P_Report_Title=List of Appointments for Transfer" );
		}

	if(n==s)
		OAtransRec();

	}
	catch (Exception e)	{
		//out.println(e+"here 2");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
	}

public void doGet(HttpServletResponse res)
throws javax.servlet.ServletException,IOException
{
try	{
this.out = res.getWriter();
res.setContentType("text/html;charset=UTF-8");
out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/NamePrefix.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/commonToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
}
catch(Exception e)	{
	//out.println(e+"here 222");
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
}

private synchronized void GenReport(HttpServletRequest req)
{
	
	//Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;


	String addedById = p.getProperty( "login_user" ) ;
	String addedAtWorkstation=client_ip_address;
	String addedFacilityId=facilityId;

	String modifiedById = addedById ;
	String modifiedAtWorkstation = addedAtWorkstation ;
	String modifiedFacilityId = addedFacilityId ;
	


	try{

     	
rsval=rsval;
 	    if (status.equals("Y"))
	    {
	     pstmt=con.prepareStatement("delete from oa_appt_list_rep_temp where status='P' ");
	     rsval =pstmt.executeUpdate();
	     status="N";
		 if(pstmt !=null) pstmt.close();
	    }

		//Below query modified for security issue by Kamatchi S against COMMON-ICN-0165
		// sqlrep =" insert into oa_appt_list_rep_temp (	facility_id,clinic_code,practitioner_id,clinic_date,appl_user_id,event_date,added_by_id,added_date ,added_at_ws_no,added_facility_id,modified_by_id,modified_date ,modified_at_ws_no,modified_facility_id  )values('"+facilityId+"','"+locn+"','"+pract+"',to_date('"+curdat+"','dd/mm/yyyy'),'"+addedById+"', to_date('"+datval+"','dd/mm/yyyyhh24miss'),'"+addedById+"', sysdate , 		 '"+addedAtWorkstation+"','"+addedFacilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"' )  ";
		sqlrep =" insert into oa_appt_list_rep_temp (	facility_id,clinic_code,practitioner_id,clinic_date,appl_user_id,event_date,added_by_id,added_date ,added_at_ws_no,added_facility_id,modified_by_id,modified_date ,modified_at_ws_no,modified_facility_id  )values(?,?,?,to_date(?,'dd/mm/yyyy'),?, to_date(?,'dd/mm/yyyyhh24miss'),?, sysdate ,?,?,?,sysdate,?,? )  ";

   		 pstmt=con.prepareStatement(sqlrep);
		 pstmt.setString    (    1,    facilityId        );
		 pstmt.setString    (    2,    locn        );
		 pstmt.setString    (    3,    pract        );
		 pstmt.setString    (    4,    curdat        );
		 pstmt.setString    (    5,    addedById        );
		 pstmt.setString    (    6,    datval        );
		 pstmt.setString    (    7,    addedById        );
		 pstmt.setString    (    8,    addedAtWorkstation        );
		 pstmt.setString    (    9,    addedFacilityId        );
		 pstmt.setString    (    10,    modifiedById        );
		 pstmt.setString    (    11,    modifiedAtWorkstation        );
		 pstmt.setString    (    12,    modifiedFacilityId        );
		 rsval =pstmt.executeUpdate();


		   if (rs != null) rs.close();
		   if (pstmt != null) pstmt.close();
	  }catch(Exception e ){
		  //out.println("Error " +e);
		  e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	  }finally{

			if(con!=null) ConnectionManager.returnConnection(con,req);
		}
}//E.o.genreport


private synchronized void UpdateSch(HttpServletRequest req)	{
try {
	String error="";
	String error_value = "0" ;

	if(s==0){
		error_value = "1" ;
		error= "No records to be generated";
		out.print("<script>alert('"+error_value+error+s+"') </script>");

		out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value +"\"</script><body class='message'></html>");

	}
	else
	{
		if(pract.equals("null") ) pract="";
		else if ( pract == null) pract="";

		Integer nBigInt=new Integer(n);
		Integer sBigInt=new Integer(s);

		
		java.util.HashMap passObjects = new java.util.HashMap(); 
		passObjects.put("nBigInt",nBigInt);
		passObjects.put("sBigInt",sBigInt);
		passObjects.put("finalvals1",finalvals1);
		passObjects.put("efffrom",efffrom);
		passObjects.put("effto",effto);
		passObjects.put("reason",reason);
		passObjects.put("curdayno",curdayno);
		passObjects.put("transdayno",transdayno);
		passObjects.put("dateday",dateday);
		passObjects.put("fid",fid);
		passObjects.put("facilityId",facilityId);
		passObjects.put("client_ip_address",client_ip_address);
		passObjects.put("locationType",locationType);
		passObjects.put("resourceType",resourceType);
		passObjects.put("other_remarks",other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		
		boolean local_ejbs = false;

		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TransferClinicSch",TransferClinicSchManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		

		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;
				
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("UpdateSch",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		error = (String) results.get("error") ;
	
		error_value = "0" ;
		String locncode=req.getParameter("locncode");
	

		if ( inserted ){
			if(noofappts_no>0){
				doOnlineReports(locncode,  facilityId,pract,reason,FromStr,ToStr);
			}
			
			error_value = "1" ;
			
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value +"\"</script><body class='message'></html>");
			
		}else{
			error = (String) results.get("error") ;

			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script><body class='message'></html>");
		}	
		results.clear();
		passObjects.clear();
	 }
	 
}//E.O.TRY
	catch ( Exception e ) {
		//out.print(e+"prog here");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}//E.O.UPDATE



	private void doOnlineReports( String lcn_CD,String fac_id, String pract_id, String rsn, String frm_DT, String to_DT)
        throws ServletException, IOException, SQLException
    {
        String locale = p.getProperty("LOCALE");
		String s4 = " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID = 'OABTRLTR' and language_id = '"+locale+"'";

        String s10 = "p_appt_date,p_old_date,p_practitioner_id,p_clinic_code,p_facility_id,p_reason,care_locn_type_ind,resource_class";
        String s11 = to_DT + "," + frm_DT+ "," + pract_id+ "," + lcn_CD+ "," + fac_id+"," + rsn+","+locationType+","+resourceType;
		
		StringBuffer s12 = new StringBuffer("");
			
		s12.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
        s12.append("</head><body class='message'>");
        s12.append( "<script language = 'JavaScript'>");
		s12.append("  var dialogHeight    = '45vh' ;");
		s12.append(" var dialogWidth = '65vw' ;");
		s12.append("var dialogTop = 58;");
        s12.append( "  var arguments =   ''; ");
    	// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        s12.append( "  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=TRANSFER_CANCEL_APPT&step=1&sqlString=" + URLEncoder.encode(s4,"UTF-8") + "&reportParamNames=" + s10 + "&reportParamValues=" + s11+ "';");
        s12.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        s12.append( "  retVal            =   window.showModalDialog(getUrl,arguments,features); ");
		s12.append( "</script>");
        out.println(s12.toString());
		s12.setLength(0);
    }





private synchronized void OAtransRec()	{
try {
	
	if(pract.equals("null") )
				pract="";
	else if ( pract == null)
			pract="";


		Integer nBigInt=new Integer(n);
		Integer sBigInt=new Integer(s);

		
		java.util.HashMap passObjects = new java.util.HashMap(); 

		passObjects.put("nBigInt",nBigInt);
		passObjects.put("sBigInt",sBigInt);
		passObjects.put("finalvals1",finalvals1);
		passObjects.put("efffrom",efffrom);
		passObjects.put("effto",effto);
		passObjects.put("reason",reason);
		passObjects.put("other_remarks",other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		passObjects.put("curdayno",curdayno);
		passObjects.put("transdayno",transdayno);
		passObjects.put("fid",fid);
		passObjects.put("facilityId",facilityId);
		passObjects.put("client_ip_address",client_ip_address);

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TransferClinicSch",TransferClinicSchManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		

		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;

		
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();
		

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("OAtransRec",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ; 


		if ( inserted ){			

			error_value = "1" ;

			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
		}else{
			error = (String) results.get("error") ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");
		}
		results.clear();
		passObjects.clear();

	} catch ( Exception e ) {
		//out.print(e+"rep here");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}

} 
