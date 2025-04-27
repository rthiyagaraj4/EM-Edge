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

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0165
import eOA.BlockLiftCancelSch.* ;

public class BlockLiftCancelSchServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;

java.util.Properties p;

String facilityId="",client_ip_address="",finalvals="",finalvals1="",action="",noofrec="",selrec="",efffrom="",effto="",reason="",reason_desc="",fid="";
int n,s,rsval = 0;
String str = "",locn = "", pract ="",dat = "",status="Y",genrep ="",datval = "",sqlrep ="",datsql ="",locncode ="",practid ="",p_report_id ="",p_module_id ="",fromday ="",P_Report_Title ="",P_Action ="",DateStr="",curdat="",resource_Type= "",location_Type= "",start_time="",end_time="",max_patients_per_day="",bulk_blocking_yn="",visit_limit_rule="",blk_time_from="",blk_time_to="";
String blk_schdl_with_appt_yn="";//JD-CRF-0168 changes
int NoOfAppt=0;

String other_remarks; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{

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
	//Added by Kamatchi S for security issue against COMMON-ICN-0165
	req = new XSSRequestWrapper(req);
	res.addHeader("X-XSS-Protection", "1; mode=block");
	res.addHeader("X-Content-Type-Options", "nosniff");
	efffrom = req.getParameter("eff_from");
	effto = req.getParameter("eff_to");
	reason = req.getParameter("reason");
	reason_desc = req.getParameter("reason_desc");
	bulk_blocking_yn="N";
	efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
	effto=DateUtils.convertDate(effto,"DMY",locale,"en");
	finalvals="";
	finalvals = req.getParameter("final_vals");
	finalvals1="";
	finalvals1= req.getParameter("final_vals1");
	action = req.getParameter("action");
	noofrec = req.getParameter("no_of_rec");
	selrec = req.getParameter("sel_rec");

	other_remarks = req.getParameter("other_remarks")==null?"":req.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	bulk_blocking_yn=req.getParameter("bulk_blocking_yn")==null?"N":req.getParameter("bulk_blocking_yn");
	visit_limit_rule=req.getParameter("visit_limit_rule");
	blk_time_from=req.getParameter("blk_time_from")==null?"":req.getParameter("blk_time_from");
	blk_time_to=req.getParameter("blk_time_to")==null?"":req.getParameter("blk_time_to");
	location_Type=req.getParameter("location_type");
	resource_Type =req.getParameter("resourcetype");
	start_time =req.getParameter("start_time");
	end_time =req.getParameter("end_time");
	max_patients_per_day =req.getParameter("max_patients_per_day");
	n = Integer.parseInt(noofrec);
	s = Integer.parseInt(selrec);
	genrep = req.getParameter("genrep");
	if((genrep== null)||(genrep.equals("null"))||(genrep.equals(""))) genrep ="N";
	practid = req.getParameter("practitioner");
	if (practid== null) practid ="";
	locncode = req.getParameter("locncode");
	if (locncode== null) locncode ="";
	String no_Appt="";
	NoOfAppt=0;
	String finalvals2="";
	finalvals2=finalvals.substring(0,finalvals.length() -1);

	DateStr="";
	StringTokenizer st = new StringTokenizer(finalvals2,"-");
		while(st.hasMoreTokens())
		{
			str = st.nextToken();
			StringTokenizer st1 = new StringTokenizer(str,"|");
			while(st1.hasMoreTokens())
			{
				if (st1.hasMoreTokens())
					st1.nextToken();
				if (st1.hasMoreTokens())
				{
					practid=st1.nextToken();
				if(practid=="X" ||practid.equals("X") )practid="";
				}
				if (st1.hasMoreTokens())
				{
					curdat = st1.nextToken();
				}
				if (st1.hasMoreTokens())
					st1.nextToken();
				if (st1.hasMoreTokens())
				{
					no_Appt=st1.nextToken();

				if(Integer.parseInt(no_Appt)>0){
					DateStr=DateStr+curdat+"|";
				}
				NoOfAppt=NoOfAppt+Integer.parseInt(no_Appt);
				}
			}
		}

	p_module_id = req.getParameter("p_module_id");
	if (p_module_id== null) p_module_id ="";
	p_report_id = req.getParameter("p_report_id");
	if (p_report_id== null) p_report_id ="";
	P_Report_Title = req.getParameter("P_Report_Title");
	if (P_Report_Title== null) P_Report_Title ="";
	P_Action = req.getParameter("P_Action");
	if (P_Action== null) P_Action ="";
	blk_schdl_with_appt_yn = req.getParameter("blk_schdl_with_appt_yn");//JD-CRF-0168 changes
	if (blk_schdl_with_appt_yn== null) blk_schdl_with_appt_yn ="N";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
	   	 con = ConnectionManager.getConnection(req);
		 datsql ="select to_char(sysdate,'ddmmyyyyhh24miss') dttm from dual";
   		 pstmt=con.prepareStatement(datsql);
		 rs=pstmt.executeQuery();
		 rs.next();
		 datval =(String)rs.getString("dttm");
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();

	 }catch(Exception e ){
		 //out.println("Error " +e);
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		 }

	  finally{
	 			if(con!=null)
	 			{
				ConnectionManager.returnConnection(con,req);
	 			}
			}

	status="Y";
	if(action.equals("B")){
			BlockSch();
		}
		else if(action.equals("L")){
			LiftSch();}
		else if(action.equals("C")){
			CancelSch();}
		if(genrep.equals("Y"))
		{
			out.println("<script>alert('../../eCommon/jsp/report_options_form.jsp');</script>");
			res.sendRedirect("../eOA/jsp/GenReport.jsp?P_From_Date="+efffrom+"&P_Action="+P_Action+"&P_user_id="+fid+"&P_Day_No="+fromday+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&P_Facility_id="+facilityId+"&P_To_Date="+effto+"&P_Clinic_Code="+locncode+"&P_Practitioner_Id="+practid+"&P_Reason="+reason+"&P_Event_Date="+datval+"&P_Report_Title="+P_Report_Title+"&care_locn_type_ind="+location_Type+"&resource_class="+resource_Type );
		}
		if(n==s){
			OAtransRec();
		}
	}
	catch (Exception e)	{
		//out.println(e+"here 2");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
	}
//Method
private synchronized void GenReport(HttpServletRequest req)
{

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String addedById = p.getProperty( "login_user" ) ;
	String addedAtWorkstation=client_ip_address;
	String addedFacilityId=facilityId;
	try{
    	 con = ConnectionManager.getConnection(req);

		rsval=rsval;
	    if (status.equals("Y"))
	    {
	     pstmt=con.prepareStatement("delete from oa_appt_list_rep_temp where status='P' ");
	     rsval =pstmt.executeUpdate();
	     status="N";
		 if(pstmt !=null) pstmt.close();
	    }

		 sqlrep =" insert into oa_appt_list_rep_temp (facility_id,clinic_code ,practitioner_id,clinic_date ,appl_user_id,event_date ,added_by_id,added_date ,added_at_ws_no,added_facility_id ,modified_by_id,modified_date ,modified_at_ws_no,modified_facility_id )values('"+facilityId+"','"+locn+"', '"+pract+"', to_date('"+dat+"','dd/mm/yyyy'), '"+addedById+"', to_date('"+datval+"','dd/mm/yyyyhh24miss'), '"+addedById+"', sysdate , '"+addedAtWorkstation+"','"+addedFacilityId+"', '"+addedById+"',sysdate, '"+addedAtWorkstation+"','"+addedFacilityId+"')";
   		 pstmt=con.prepareStatement(sqlrep);
		 rsval =pstmt.executeUpdate();
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();

	  }catch(Exception e ){
		  //out.println("Error " +e);
		  e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		  }
	  	finally{
					if(con!=null)
					{
						ConnectionManager.returnConnection(con,req);
					}
				}
}//E.o.genreport
private synchronized void BlockSch()	{
try {

	String error="";
	String error_value = "0" ;

	if(s==0){
		error_value = "1" ;
		error= "No records to be generated";
		out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
		}
	else
	{
		Integer n1= new Integer(n);
		Integer s1= new Integer(s);
			java.util.HashMap passObjects = new java.util.HashMap();
			passObjects.put("n1",n1);
			passObjects.put("s1",s1);
			passObjects.put("finalvals1",finalvals);
			passObjects.put("efffrom",efffrom);
			passObjects.put("effto",effto);
			passObjects.put("reason",reason);
			passObjects.put("reason_desc",reason_desc);
			passObjects.put("fid",fid);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("location_Type",location_Type);
			passObjects.put("resource_Type",resource_Type);
			passObjects.put("start_time",start_time);
			passObjects.put("end_time",end_time);
			passObjects.put("max_patients_per_day",max_patients_per_day);
			passObjects.put("bulk_blocking_yn",bulk_blocking_yn);
			passObjects.put("visit_limit_rule",visit_limit_rule);
			passObjects.put("blk_time_from",blk_time_from);
			passObjects.put("blk_time_to",blk_time_to);
			passObjects.put("blk_schdl_with_appt_yn",blk_schdl_with_appt_yn);//JD-CRF-0168 changes
			passObjects.put("other_remarks",other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114




			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BlockLiftCancelSch",BlockLiftCancelSchManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("BlockSch",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		 error = (String) results.get("error") ;
		 error_value = "0" ;
		if ( inserted ){
				if(NoOfAppt>0){
					doOnlineReports( locncode, this.facilityId,practid,reason,DateStr,"B");
				}
				error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
		}else{
				error = (String) results.get("error") ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "\"</script>");

			}
		passObjects.clear();
		results.clear();

		}
	}catch ( Exception e ) {
		//out.print(e+"here");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}

private synchronized void LiftSch()	{
try {

			Integer n1= new Integer(n);
			Integer s1= new Integer(s);
			java.util.HashMap passObjects = new java.util.HashMap();
			passObjects.put("n1",n1);
			passObjects.put("s1",s1);
			passObjects.put("finalvals1",finalvals);
			passObjects.put("efffrom",efffrom);
			passObjects.put("effto",effto);
			passObjects.put("reason",reason);
			passObjects.put("reason_desc",reason_desc);
			passObjects.put("fid",fid);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("location_Type",location_Type);
			passObjects.put("resource_Type",resource_Type);
			passObjects.put("start_time",start_time);
			passObjects.put("end_time",end_time);
			passObjects.put("blk_schdl_with_appt_yn",blk_schdl_with_appt_yn);//JD-CRF-0168 changes
			passObjects.put("other_remarks",other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BlockLiftCancelSch",BlockLiftCancelSchManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("LiftSch",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
	if ( inserted )
		{
			error_value = "1" ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");

	}else{
			error = (String) results.get("error") ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "\"</script>");
		}
		passObjects.clear();
		results.clear();
	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}
private synchronized void CancelSch()	{
try {


			Integer n1= new Integer(n);
			Integer s1= new Integer(s);
			java.util.HashMap passObjects = new java.util.HashMap();
			passObjects.put("n1",n1);
			passObjects.put("s1",s1);
			passObjects.put("finalvals1",finalvals);
			passObjects.put("efffrom",efffrom);
			passObjects.put("effto",effto);
			passObjects.put("reason",reason);
			passObjects.put("reason_desc",reason_desc);
			passObjects.put("fid",fid);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("location_Type",location_Type);
			passObjects.put("resource_Type",resource_Type);
			passObjects.put("blk_schdl_with_appt_yn",blk_schdl_with_appt_yn);//JD-CRF-0168 changes
			passObjects.put("other_remarks",other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BlockLiftCancelSch",BlockLiftCancelSchManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("CancelSch",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		if ( inserted )
			{
				if(NoOfAppt>0){
					doOnlineReports( locncode, this.facilityId,practid,reason,DateStr,"C");
				}
				error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
			}else{
				error = (String) results.get("error") ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "\"</script>");
			}
			passObjects.clear();
			results.clear();
	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}
private synchronized void OAtransRec()	{
try {

			Integer n1= new Integer(n);
			Integer s1= new Integer(s);
			java.util.HashMap passObjects = new java.util.HashMap();
			passObjects.put("n1",n1);
			passObjects.put("s1",s1);
			passObjects.put("finalvals1",finalvals);
			passObjects.put("efffrom",efffrom);
			passObjects.put("effto",effto);
			passObjects.put("reason",reason);
			passObjects.put("reason_desc",reason_desc);
			passObjects.put("action",action);
			passObjects.put("fid",fid);
			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("location_Type",location_Type);
			passObjects.put("resource_Type",resource_Type);
			passObjects.put("other_remarks",other_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BlockLiftCancelSch",BlockLiftCancelSchManagerHome.class,local_ejbs);
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
		out.println("from transRec inserted  :"+inserted);
		passObjects.clear();
			results.clear();
	} catch ( Exception e ) {
		//out.print(e+"here");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
}

private void doOnlineReports( String lcn_CD, String fac_id, String pract_id, String rsn, String frm_DT, String Status)
        throws ServletException, IOException, SQLException
    {
	String locale = p.getProperty("LOCALE");
        String s4 = " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID = 'OABBCLTR' and language_id = '"+locale+"'";
        String s10 = "p_appt_date,p_practitioner_id,p_clinic_code,p_facility_id,p_reason,p_appt_status,p_care_locn_type_ind,p_resource_class";
        String s11 =  frm_DT+ "," + pract_id+ "," + lcn_CD+ "," + fac_id+"," + rsn +"," + Status+","+location_Type+","+resource_Type;
	      StringBuffer s12=new StringBuffer();
		s12 =s12.append( " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
        s12 = s12.append("</head><body class='message'>");
        s12 = s12.append("<script language = 'JavaScript'>");
        s12.append("  var dialogHeight    = '45vh' ;");
		s12.append(" var dialogWidth = '65vw' ;");
		s12.append("var dialogTop = 58;");
        s12 = s12.append("  var arguments =   ''; ");
        s12 = s12.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString=" + URLEncoder.encode(s4,"UTF-8") + "&reportParamNames=" + s10 + "&reportParamValues=" + s11+ "';");
        s12 = s12.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        s12 = s12.append("  retVal           =  await window.showModalDialog(getUrl,arguments,features); ");
		s12 = s12.append("</script>");
        out.println(s12.toString());
		s12.setLength(0);
    }
}
