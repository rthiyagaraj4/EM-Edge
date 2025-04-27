/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM ;
import eAM.OPPractitioner.*;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import org.apache.commons.fileupload.*; // added by mujafar for AAKH-CRF-0079.4
import org.apache.commons.io.*;
import eCommon.XSSRequestWrapper;


//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;

public class PractitionerServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;

java.util.Properties p;
 //java.util.Hashtable env;
String practtype;
String practitionerid ;
String practitionername;
String shortname ;
String sex;
String sex_i; // added by mujafar for AAKH-CRF-0079.4
String birthdate;
String birthplace;
String maritalstatus="";
String aliasname;
String citizen;
String citizen_tmp; // added by mujafar for AAKH-CRF-0079.4
String nationalidno;
//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
String credential1;
String credential2;
String credential3;
//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
String jobtitle;
String jobtitle_tmp; // added by mujafar for AAKH-CRF-0079.4
String emplstatus;
String emplstatus_tmp; // added by mujafar for AAKH-CRF-0079.4
String degree;
String primaryspecialitycode;
String allfacilities;
String allfacilities_tmp; // added by mujafar for AAKH-CRF-0079.4
String repfacility;
String repfacility_tmp; // added by mujafar for AAKH-CRF-0079.4
String restelno;
String pagerno;
String mobileno;
String offtelno;
String offtelext;
String faxno;
String emailid;
String prefmode;
String prefmode_tmp; // added by mujafar for AAKH-CRF-0079.4
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
String offcountrycode_tmp; // added by mujafar for AAKH-CRF-0079.4
String mailaddln1;
String mailaddln2;
String mailaddln3;
String mailaddln4;
String mailpostalcode;
String mailcountrycode;
String mailcountrycode_tmp; // added by mujafar for AAKH-CRF-0079.4
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;
String enable_virtual_consultation ;//added by Himanshu Saxena for ML-MMOH-CRF-1930(U1)
String facilityId ;
String client_ip_address ;
//String serviceURL ;
//String objectName ;
String employeeid;

String degree1 = "";
String degree2 = "";
String degree3 = "";
String degree4 = "";

String year1 = "";
String year2 = "";
String year3 = "";
String year4 = "";

String univ1 = "";
String univ2 = "";
String univ3 = "";
String univ4 = "";

String con1 = "";
String con2 = "";
String con3 = "";
String con4 = "";

String det1 = "";
String det2 = "";
String det3 = "";
String det4 = "";

String apc_no = "";
String function_id="";
String locale="";
String longname="";
//Below line Added for this CRF HSA-CRF-160
String other_alt_type="";
String other_alt_no="";

String pract_sign=""; // added by mujafar for AAKH-CRF-0079.4
String docName1					= "";
String docName2                 ="";// added by manjunath for TH-KW-CRF-0161.1
long	docSize1					= 0;
long	docSize2					= 0;// added by manjunath for TH-KW-CRF-0161.1
String docType1					= "";
String docType2					= "";// added by manjunath for TH-KW-CRF-0161.1
int it_cnt = 0;
int it_cnt2 = 0;                      // added by manjunath for TH-KW-CRF-0161.1
DiskFileUpload upload1			= null;
FileItem Item1					= null;
FileItem  fileItem1=null;
FileItem  fileItem2=null;    // added by manjunath for TH-KW-CRF-0161.1
String signimage1 = "";
String stampimage1 = "";     // added by manjunath for TH-KW-CRF-0161.1

//Below line added for this CRF ML-MMOH-CRF-0862
String cerner_practitioner_id="";

String fppPractYn = "";//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

String supervisor_yn	= "N";
String employee_service_number="";  // added by lakshmanan for MO-CRF-20183.2 US001
public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		   req.setCharacterEncoding("UTF-8");
       res.setContentType("text/html;charset=UTF-8");
	   //MMS-ME-SCF-0096 vulnerability Issue
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		HttpSession session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
 locale= p.getProperty("LOCALE");
	try {
		this.out = res.getWriter();
		// Below code added by mujafr for AAKH-CRF-0079.4 start
		out.println("<script src='../eCommon/js/common.js' language='javascript'></script>");
		String operation = "";
		boolean isMultipart1		= FileUpload.isMultipartContent(req);
		it_cnt = 0;
		docName1					= "";
		docSize1					= 0;	
		docType1					= "";	
		if(isMultipart1){
			upload1			= new DiskFileUpload();
			List items1						= null;
			Iterator iter1					= null;	
			items1			= upload1.parseRequest(req);
			iter1			= items1.iterator();
			int img_cnt=0;
			String name1		= "";
			String value1	= "";
			while(iter1.hasNext()){
				Item1 = (FileItem)iter1.next();
				if(Item1.isFormField()){ 
				name1		= Item1.getFieldName();
				value1		= Item1.getString();
				
				if(name1.equals("function")) operation=value1;
				if(name1.equals("degree1")) degree1=value1;
				if(name1.equals("degree2")) degree2=value1;
				if(name1.equals("degree3")) degree3=value1;
				if(name1.equals("degree4")) degree4=value1; 
				
				if(name1.equals("signimage1")) signimage1=value1;
				
				if(name1.equals("stampimage1")) stampimage1=value1;// added by manjunath for TH-KW-CRF-0161.1
				
				if(name1.equals("year1")) year1=value1;
				if(name1.equals("year2")) year2=value1;
				if(name1.equals("year3")) year3=value1;
				if(name1.equals("year4")) year4=value1;
				
				
				if(name1.equals("univ1")) univ1=value1;
				if(name1.equals("univ2")) univ2=value1;
				if(name1.equals("univ3")) univ3=value1;
				if(name1.equals("univ4")) univ4=value1;
				
				
				if(name1.equals("con1")) con1=value1;
				if(name1.equals("con2")) con2=value1;
				if(name1.equals("con3")) con3=value1;
				if(name1.equals("con4")) con4=value1;
				
				if(name1.equals("det1")) det1=value1;
				if(name1.equals("det2")) det2=value1;
				if(name1.equals("det3")) det3=value1;
				if(name1.equals("det4")) det4=value1;
				
				if(name1.equals("apc_no")) apc_no=value1;
				if(name1.equals("pract_type1")) practtype=value1;
				if(name1.equals("practitioner_id1")) practitionerid=value1;
				if(name1.equals("practitioner_name1")) practitionername=value1;
				
				if(name1.equals("short_name1")) shortname=value1;
				if(name1.equals("sex2")) sex=value1;
				if(name1.equals("sex")) sex_i=value1;
				if(name1.equals("date_of_birth1")) birthdate=value1;
				if(name1.equals("birth_place")) birthplace=value1;
				
				if(name1.equals("marital_status"))maritalstatus=value1; 
					/*{ // modified by mujafar for MOHE-SCF-0002
				value1 = checkForNull(value1,"");
					if(maritalstatus.equals("") && !value1.equals("")){
					maritalstatus=value1;
					}
				}*/
				if(name1.equals("alias_name")) aliasname=value1;
				if(name1.equals("citizen2")) citizen=value1;
				if(name1.equals("citizen")) citizen_tmp=value1;
				if(name1.equals("national_id_no")) nationalidno=value1;
				
				if(name1.equals("credential_id1")) credential1=value1;
				if(name1.equals("credential_id2")) credential2=value1;
				if(name1.equals("credential_id3")) credential3=value1;
				if(name1.equals("job_title1")) jobtitle=value1;
				if(name1.equals("job_title")) jobtitle_tmp=value1;
				if(name1.equals("empl_status2")) emplstatus=value1;
				if(name1.equals("empl_status")) emplstatus_tmp=value1;
				if(name1.equals("degree")) degree=value1;
				if(name1.equals("primary_speciality_codeh")) primaryspecialitycode=value1;
				if(name1.equals("all_facilities1")) allfacilities=value1;
				if(name1.equals("all_facilities")) allfacilities_tmp=value1;
				
				if ( allfacilities == null ) allfacilities="N";
				if ( allfacilities_tmp == null )allfacilities_tmp="N";
								
				if(name1.equals("rep_facility")) repfacility=value1; 
				
				if(name1.equals("residencetelno")) restelno=value1;
				if(name1.equals("pagerno")) pagerno=value1;
				if(name1.equals("mobileno")) mobileno=value1;
				
				if(name1.equals("offtelno")) offtelno=value1;
				if(name1.equals("offtelext")) offtelext=value1;
				if(name1.equals("faxno")) faxno=value1;
				if(name1.equals("emailid")) emailid=value1;
				
				if(name1.equals("pref_contact_mode2")) prefmode=value1; 
				if(name1.equals("pref_contact_mode")) prefmode_tmp=value1;
				if(name1.equals("res_add_ln1")) resaddln1=value1;
				if(name1.equals("res_add_ln2")) resaddln2=value1;
				if(name1.equals("res_add_ln3")) resaddln3=value1;
				if(name1.equals("res_add_ln4")) resaddln4=value1;
				
				if(name1.equals("res_code_value")) respostalcode=value1;
				if(name1.equals("res_add_country_code2")) rescountrycode=value1;
				if(name1.equals("res_add_ln2")) resaddln2=value1;
				if(name1.equals("res_add_ln3")) resaddln3=value1;
				if(name1.equals("res_add_ln4")) resaddln4=value1;
				
				if(name1.equals("off_add_ln1")) offaddln1=value1;
				if(name1.equals("off_add_ln2")) offaddln2=value1;
				if(name1.equals("off_add_ln3")) offaddln3=value1;
				if(name1.equals("off_add_ln4")) offaddln4=value1;
				
				if(name1.equals("off_code_value")) offpostalcode=value1;
				if(name1.equals("off_add_country_code2")) offcountrycode=value1; 
				if(name1.equals("off_add_country_code")) offcountrycode_tmp=value1;
				if(name1.equals("mail_add_ln1")) mailaddln1=value1;
				if(name1.equals("mail_add_ln2")) mailaddln2=value1;
				if(name1.equals("mail_add_ln3")) mailaddln3=value1;
				if(name1.equals("mail_add_ln4")) mailaddln4=value1;
				
				if(name1.equals("mail_code_value")) mailpostalcode=value1;
				if(name1.equals("mail_add_country_code2")) mailcountrycode=value1; 
				if(name1.equals("mail_add_country_code")) mailcountrycode_tmp=value1;
				if(name1.equals("eff_date_from")) effectiveDateFrom=value1;
				if(name1.equals("eff_date_to")) effectiveDateTo=value1;
				
				if(name1.equals("eff_status1")) effectiveStatus=value1;
				if(name1.equals("employee_id")) employeeid=value1;
				if(name1.equals("fpp_pract_yn")) fppPractYn=value1;
				fppPractYn = checkForNull(fppPractYn,"N");
				if(name1.equals("supervisor_yn")) supervisor_yn=value1;
				supervisor_yn = checkForNull(supervisor_yn,"N");
				if(name1.equals("other_alt_type")) other_alt_type=value1;
				if(other_alt_type == null) other_alt_type ="";
				if(name1.equals("other_alt_no1")) other_alt_no=value1;
				if(name1.equals("cerner_practitioner_id")) cerner_practitioner_id=value1;
				if(name1.equals("function_id")) function_id=value1;
				if(name1.equals("long_name1")) longname=value1;
				//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
				if(name1.equals("enable_virtual_consultation1")) enable_virtual_consultation=value1;
				if(name1.equals("employee_service_number")) employee_service_number=value1; // Added by Lakshmanan MO-CRF-20183.2
			}
				else //  below CODE added by manjunath for TH-KW-CRF-0161.1
				{ 
			     if(img_cnt==0)
					{
					//Sign Image
					fileItem1	= Item1;				
					docName1		= Item1.getName();				
					docType1		= Item1.getContentType();
					docSize1		= Item1.getSize();				
					img_cnt++;
					}
				 else if(img_cnt==1)
					{
					//Stamp Image
					fileItem2	= Item1;
					docName2		= Item1.getName();
					docType2		= Item1.getContentType();
					docSize2		= Item1.getSize();				
					}
				 }				 
				if(docType1 == null)
				docType1 = "999";
				it_cnt++;
				if(docType2 == null)
				docType2 = "999";
				it_cnt2++;
		    }			
				
		}
	
	if(signimage1.equals(""))
	{
		docName1="";
		docType1="";
		docSize1=0;
	}
	if(stampimage1.equals("")) // added by manjunath for TH-KW-CRF-0161.1
	{
		docName2="";
		docType2="";
		docSize2=0;
	}
// added by mujafar for AAKH-CRF-0079.4 end	

	
	if ( operation.equals("insert") )
	{  
			
		if(sex_i!=null)sex = sex_i; // added by mujafar for AAKH-CRF-0079.4 
		if(citizen_tmp!=null)citizen=citizen_tmp;
		if(jobtitle_tmp!=null)jobtitle = jobtitle_tmp;
		//if(allfacilities_tmp!=null)allfacilities=allfacilities_tmp; // commented by mujafar for MOHE-SCF-0002
		if(emplstatus_tmp!=null)emplstatus = emplstatus_tmp;
	//	if(repfacility_tmp!=null)repfacility = repfacility_tmp;
		if(prefmode_tmp!=null)prefmode = prefmode_tmp;
		if(offcountrycode_tmp!=null)offcountrycode = offcountrycode_tmp ;
		if(mailcountrycode_tmp!=null)mailcountrycode = mailcountrycode_tmp; 

		insertOPPractitioner(req, res);
		
	}
	if ( operation.equals("modify"))
	{	
			modifyOPPractitioner(req, res);
	}
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
    }


/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {
	try	{
		this.out = res.getWriter();
		res.setContentType("text/html");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='Javascript' src='../eAM/js/Practitioner.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=VisitType' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	} catch(Exception e)	{	}
}*/


private void modifyOPPractitioner(HttpServletRequest req, HttpServletResponse res)	{
  
        Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;


	try {
	
	//degree1 =req.getParameter("degree1"); // commented by mujafar for AAKH-CRF-0079.4
	if(degree1==null) degree1 ="";
	//degree2 =req.getParameter("degree2");
	if(degree2==null) degree2 ="";
	//degree3 =req.getParameter("degree3");
	if(degree3==null) degree3 ="";
	//degree4 =req.getParameter("degree4");
	if(degree4==null) degree4 ="";

	//year1 =req.getParameter("year1");
	if(year1==null) year1 ="";
	//year2 =req.getParameter("year2");
	if(year2==null) year2 ="";
	//year3 =req.getParameter("year3");
	if(year3==null) year3 ="";
	//year4 =req.getParameter("year4");
	if(year4==null) year4 ="";

	//univ1 =req.getParameter("univ1");
	if(univ1==null) univ1 ="";
	//univ2 =req.getParameter("univ2");
	if(univ2==null) univ2 ="";
	//univ3 =req.getParameter("univ3");
	if(univ3==null) univ3 ="";
	//univ4 =req.getParameter("univ4");
	if(univ4==null) univ4 ="";

	//con1 =req.getParameter("con1");
	if(con1==null) con1 ="";
	//con2 =req.getParameter("con2");
	if(con2==null) con2 ="";
	//con3 =req.getParameter("con3");
	if(con3==null) con3 ="";
	//con4 =req.getParameter("con4");
	if(con4==null) con4 ="";

	//det1 =req.getParameter("det1");
	if(det1==null) det1 ="";
	//det2=req.getParameter("det2");
	if(det2==null) det2 ="";
	//det3 =req.getParameter("det3");
	if(det3==null) det3 ="";
	//det4 =req.getParameter("det4");
	//apc_no =req.getParameter("apc_no");
	if(det4==null) det4 ="";
	if(apc_no==null) apc_no ="";

	//practtype =req.getParameter("pract_type1");
	//practitionerid=req.getParameter("practitioner_id1");
	//practitionername=req.getParameter("practitioner_name1");
	//shortname=req.getParameter("short_name1");
	//sex=req.getParameter("sex2");
	//birthdate=req.getParameter("date_of_birth1");

	birthdate=DateUtils.convertDate(birthdate,"DMY",locale,"en");

	//birthplace=req.getParameter("birth_place");
	//maritalstatus=req.getParameter("marital_status");
	//aliasname=req.getParameter("alias_name");
	//citizen=req.getParameter("citizen2");
	//nationalidno=req.getParameter("national_id_no");
	//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
	//credential1=req.getParameter("credential_id1");
	//credential2=req.getParameter("credential_id2");
	//credential3=req.getParameter("credential_id3");
	//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
	//jobtitle=req.getParameter("job_title1");
	//emplstatus=req.getParameter("empl_status2");
	//degree=req.getParameter("degree");
	//primaryspecialitycode=req.getParameter("primary_speciality_codeh");
	//allfacilities=req.getParameter("all_facilities1");
	if ( allfacilities == null )
			allfacilities="N";

	//repfacility=req.getParameter("rep_facility2");
	//restelno=req.getParameter("residencetelno");
	//pagerno=req.getParameter("pagerno");
	//mobileno=req.getParameter("mobileno");

	//offtelno=req.getParameter("offtelno");
	//offtelext=req.getParameter("offtelext");
	//faxno=req.getParameter("faxno");
	//emailid=req.getParameter("emailid");
	//prefmode=req.getParameter("pref_contact_mode2");
	//resaddln1=req.getParameter("res_add_ln1");
	//resaddln2=req.getParameter("res_add_ln2");
	//resaddln3=req.getParameter("res_add_ln3");
	//resaddln4=req.getParameter("res_add_ln4");
	//respostalcode=req.getParameter("res_code_value");
	//rescountrycode=req.getParameter("res_add_country_code2");
	//offaddln1=req.getParameter("off_add_ln1");
	//offaddln2=req.getParameter("off_add_ln2");
	//offaddln3=req.getParameter("off_add_ln3");
	//offaddln4=req.getParameter("off_add_ln4");
	//offpostalcode=req.getParameter("off_code_value");
	//offcountrycode=req.getParameter("off_add_country_code2");
	//mailaddln1=req.getParameter("mail_add_ln1");
	//mailaddln2=req.getParameter("mail_add_ln2");
	//mailaddln3=req.getParameter("mail_add_ln3");
	//mailaddln4=req.getParameter("mail_add_ln4");
	//mailpostalcode=req.getParameter("mail_code_value");
	//mailcountrycode=req.getParameter("mail_add_country_code2");
	//effectiveDateFrom = req.getParameter("eff_date_from");
	//effectiveDateTo = req.getParameter("eff_date_to");
	effectiveDateFrom=DateUtils.convertDate(effectiveDateFrom,"DMY",locale,"en");
	effectiveDateTo=DateUtils.convertDate(effectiveDateTo,"DMY",locale,"en");
	//effectiveStatus = req.getParameter("eff_status1");
	//employeeid = req.getParameter("employee_id");
	if(employeeid == null) employeeid ="";

	//fppPractYn = checkForNull(req.getParameter("fpp_pract_yn"),"N");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

    //Below line Added for this CRF HSA-CRF-160
	//other_alt_type=req.getParameter("other_alt_type");	
	if(other_alt_type == null) other_alt_type ="";
	//other_alt_no=req.getParameter("other_alt_no1");	
	if(other_alt_no == null) other_alt_no ="";
	
	//Added for this CRF ML-MMOH-CRF-0862
	//cerner_practitioner_id =req.getParameter("cerner_practitioner_id");	
	if(cerner_practitioner_id == null) cerner_practitioner_id ="";

	if ( effectiveStatus == null )
		effectiveStatus="D";
	//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
	if(enable_virtual_consultation==null)
		enable_virtual_consultation="D";
	//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 End -->
	if(employee_service_number==null) // added by lakshmanan for MO-CRF-20183.2 US001 
		employee_service_number="";
		
//function_id=req.getParameter("function_id");
if(function_id == null) function_id="";
//longname=req.getParameter("long_name1");
if(longname == null || longname == "") longname="";

/*Below line added for this CRF ML-MMOH-CRF-0862*/
String sql="";
con=ConnectionManager.getConnection();
stmt=con.createStatement();
int count=0;
boolean statussp=true;
boolean migrate_pract_status=false;
boolean cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","CERNER_PRACTITIONER_ID");

 if(cernerIdSiteSpecific) {
	  if(function_id.equals("PRACTITIONER"))
	   {
		  sql="select count(*) from am_ext_practitioner where practitioner_long_id='"+cerner_practitioner_id+"'";	  	  
		  rs=stmt.executeQuery(sql);
		  if(rs.next()){
			  count=rs.getInt(1);
		  }
		  if(count>0){
			  statussp=false;
			  migrate_pract_status=true;
		  }else{
			  statussp=true;
		  }	  

	   }else if(function_id.equals("EXT_PRACT")){
		  sql="select count(*) from am_practitioner where practitioner_long_id='"+cerner_practitioner_id+"'";				  
		  rs=stmt.executeQuery(sql);
		  if(rs.next()){
			  count=rs.getInt(1);
		  }
		  if(count>0){
			  statussp=false;
			  migrate_pract_status=true;
		  }else{
			  statussp=true;
		  } 
	   }
	   if(rs!=null) rs.close();
	   if(stmt!=null) stmt.close();
  } 
//End this CRF ML-MMOH-CRF-0862


	/*InitialContext context = new InitialContext();
	Object homeObject = context.lookup("java:comp/env/PractitionerManager");
	final PractitionerHome practitionerHome = (PractitionerHome) PortableRemoteObject.narrow(homeObject ,PractitionerHome.class);

	final PractitionerRemote practitionerRemote = practitionerHome.create();
	final java.util.Hashtable results = practitionerRemote.updateOPPractitioner(	p,
						practtype,practitionerid,practitionername,shortname,sex,birthdate,birthplace,maritalstatus,aliasname,citizen,nationalidno,credential1,credential2,credential3,jobtitle,emplstatus,degree,primaryspecialitycode,allfacilities,repfacility,
						restelno,pagerno,mobileno,offtelno,offtelext,faxno,emailid,prefmode,
						resaddln1,resaddln2,resaddln3,resaddln4,respostalcode,rescountrycode,
						offaddln1,offaddln2,offaddln3,offaddln4,offpostalcode,offcountrycode,
						mailaddln1,mailaddln2,mailaddln3,mailaddln4,mailpostalcode,mailcountrycode,
						effectiveDateFrom,
						effectiveDateTo,	effectiveStatus,
						facilityId, client_ip_address,						employeeid,degree1,degree2,degree3,degree4,year1,year2,year3,year4,univ1,univ2,univ3,univ4,con1,con2,con3,con4,det1,det2,det3,det4,apc_no,function_id
						) ;*/
						
				if(statussp){ //Added for this CRF ML-MMOH-CRF-0862		

					boolean local_ejbs = false;

					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PractitionerManager",PractitionerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					HashMap hashmap = new HashMap();
					hashmap.put("p",p);
						hashmap.put("mobileno",mobileno);
					hashmap.put("birthplace",birthplace);
					hashmap.put("practtype",practtype);
					hashmap.put("practitionerid",practitionerid);
					hashmap.put("practitionername",practitionername);
					hashmap.put("shortname",shortname);
					hashmap.put("sex",sex);
					hashmap.put("birthdate",birthdate);
					hashmap.put("maritalstatus",maritalstatus);
					hashmap.put("aliasname",aliasname);
					hashmap.put("citizen",citizen);
						hashmap.put("nationalidno",nationalidno);
						hashmap.put("credential1",credential1);
						hashmap.put("credential2",credential2);
						hashmap.put("credential3",credential3);
						hashmap.put("jobtitle",jobtitle);
						hashmap.put("emplstatus",emplstatus);
						hashmap.put("degree",degree);
						hashmap.put("primaryspecialitycode",primaryspecialitycode);
						hashmap.put("allfacilities",allfacilities);
						hashmap.put("repfacility",repfacility);
						hashmap.put("restelno",restelno);
						hashmap.put("pagerno",pagerno);
						hashmap.put("offtelno",offtelno);
						hashmap.put("offtelext",offtelext);
						hashmap.put("faxno",faxno);
						hashmap.put("emailid",emailid);
						hashmap.put("prefmode",prefmode);
						hashmap.put("resaddln1",resaddln1);
						hashmap.put("resaddln2",resaddln2);
						hashmap.put("resaddln3",resaddln3);
						hashmap.put("resaddln4",resaddln4);
						hashmap.put("respostalcode",respostalcode);
						hashmap.put("rescountrycode",rescountrycode);
							hashmap.put("offaddln1",offaddln1);
							hashmap.put("offaddln2",offaddln2);
							hashmap.put("offaddln3",offaddln3);
							hashmap.put("offaddln4",offaddln4);
							hashmap.put("offpostalcode",offpostalcode);
							hashmap.put("offcountrycode",offcountrycode);
							hashmap.put("mailaddln1",mailaddln1);
							hashmap.put("mailaddln2",mailaddln2);
							hashmap.put("mailaddln3",mailaddln3);
							hashmap.put("mailaddln4",mailaddln4);
							hashmap.put("mailpostalcode",mailpostalcode);
							hashmap.put("mailcountrycode",mailcountrycode);
							hashmap.put("effectiveDateFrom",effectiveDateFrom);
							hashmap.put("effectiveDateTo",effectiveDateTo);
							hashmap.put("effectiveStatus",effectiveStatus);
							hashmap.put("addedFacilityId",facilityId);
							hashmap.put("addedAtWorkstation",client_ip_address);
							hashmap.put("employeeid",employeeid);
							hashmap.put("degree1",degree1);
							hashmap.put("degree2",degree2);
							hashmap.put("degree3",degree3);
							hashmap.put("degree4",degree4);
							hashmap.put("year1",year1);
							hashmap.put("year2",year2);
							hashmap.put("year3",year3);
							hashmap.put("year4",year4);
							hashmap.put("univ1",univ1);
							hashmap.put("univ2",univ2);
							hashmap.put("univ3",univ3);
							hashmap.put("univ4",univ4);
							hashmap.put("con1",con1);
							hashmap.put("con2",con2);
							hashmap.put("con3",con3);
							hashmap.put("con4",con4);
							hashmap.put("det1",det1);
							hashmap.put("det2",det2);
							hashmap.put("det3",det3);;
							hashmap.put("det4",det4);
							hashmap.put("apc_no",apc_no);
							hashmap.put("function_id",function_id);
							hashmap.put("longname",longname);

							hashmap.put("fppPractYn",fppPractYn);//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
							hashmap.put("supervisor_yn",supervisor_yn);//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4
							
							hashmap.put("employee_service_number",employee_service_number); // added by lakshmanan for MO-CRF-20183.2 US001
                     
					     //Below line Added for this CRF HSA-CRF-160
						 hashmap.put("other_alt_type",other_alt_type);
						 hashmap.put("other_alt_no",other_alt_no);
                      
					    //Added for this CRF ML-MMOH-CRF-0862
						hashmap.put("cerner_practitioner_id",cerner_practitioner_id);	
						
						//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
						hashmap.put("enable_virtual_consultation",enable_virtual_consultation);
	                     

					Object argArray[] = new Object[1];
					argArray[0]=hashmap;


							Class [] paramArray = new Class[1];
							paramArray[0] = hashmap.getClass();


		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateOPPractitioner",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


         /* String error = (String) results.get("error") ;
    	  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=1"  );
		  hashmap.clear();
           results.clear();*/
		   
		   /*Above line commented and Below line added for ML-MMOH-CRF-0862*/
		    boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		    String error = (String) results.get("error") ;
		    String error_value = "0" ;

			if ( inserted )	{ 			
				if(!docName1.equals(""))
				{  				
				insertPractSign(con,req,"Sign");								
				}
				if(!docName2.equals(""))
				{  				
				insertPractSign(con,req,"Stamp");				
				}				
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{  		
				if(!docName1.equals(""))
				{  				
				insertPractSign(con,req,"Sign");						
				}
				if(!docName2.equals(""))
				{  			
				insertPractSign(con,req,"Stamp");
				}
				error = (String) results.get("error") ;
						
				if(error.contains("ORA-20099")){
					MessageManager mm = new MessageManager();
					final java.util.Hashtable validateError = mm.getMessage(locale, "FUTURE_APPT_EXISTS", "AM") ;
					error = ((String) validateError.get("message"));					
				}				
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
				hashmap.clear();
			}
				results.clear();
		  }else{		        			   
				String error="";
				String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;
				
				//Added for this CRF ML-MMOh-CRF-0862
				if(migrate_pract_status) CODE_ALREADY_EXISTS="MIGRATION_PRACTITIONER_ID";				
				//End this CRF ML-MMOh-CRF-0862
				
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				error=(String) message.get("message");
				String error_value = "0" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			} 		   
		   //End this CRF ML-MMOH-CRF-0862		   
		   

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( practitionerid + " "+practitionername + " "+shortname +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus );
			e.printStackTrace();
			}finally{
			
			try
			{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				//if(con != null)      ConnectionManager.returnConnection(con,p);
			}catch(Exception conExp) {
			    conExp.printStackTrace();
			}
			
			if(con != null)      ConnectionManager.returnConnection(con,p);
		}
	}
private void insertOPPractitioner(HttpServletRequest req, HttpServletResponse res)	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
	try {

	//degree1 =req.getParameter("degree1");
	if(degree1==null) degree1 ="";
	//degree2 =req.getParameter("degree2");
	if(degree2==null) degree2 ="";
	//degree3 =req.getParameter("degree3");
	if(degree3==null) degree3 ="";
	//degree4 =req.getParameter("degree4");
	if(degree4==null) degree4 ="";

	//year1 =req.getParameter("year1");
	if(year1==null) year1 ="";
	//year2 =req.getParameter("year2");
	if(year2==null) year2 ="";
	//year3 =req.getParameter("year3");
	if(year3==null) year3 ="";
	//year4 =req.getParameter("year4");
	if(year4==null) year4 ="";

	//univ1 =req.getParameter("univ1");
	if(univ1==null) univ1 ="";
	//univ2 =req.getParameter("univ2");
	if(univ2==null) univ2 ="";
	//univ3 =req.getParameter("univ3");
	if(univ3==null) univ3 ="";
	//univ4 =req.getParameter("univ4");
	if(univ4==null) univ4 ="";

	//con1 =req.getParameter("con1");
	if(con1==null) con1 ="";
	//con2 =req.getParameter("con2");
	if(con2==null) con2 ="";
	//con3 =req.getParameter("con3");
	if(con3==null) con3 ="";
	//con4 =req.getParameter("con4");
	if(con4==null) con4 ="";

	//det1 =req.getParameter("det1");
	if(det1==null) det1 ="";
	//det2=req.getParameter("det2");
	if(det2==null) det2 ="";
	//det3 =req.getParameter("det3");
	if(det3==null) det3 ="";
	//det4 =req.getParameter("det4");
	//apc_no =req.getParameter("apc_no");
	if(det4==null) det4 ="";
	if(apc_no==null) apc_no ="";
	//practtype =req.getParameter("pract_type1");
	//practitionerid=req.getParameter("practitioner_id1");
	//practitionername=req.getParameter("practitioner_name1");
	//shortname=req.getParameter("short_name1");
	//sex=req.getParameter("sex");
	//birthdate=req.getParameter("date_of_birth1");


	birthdate=DateUtils.convertDate(birthdate,"DMY",locale,"en");


	//birthplace=req.getParameter("birth_place");
	//maritalstatus=req.getParameter("marital_status");
	//aliasname=req.getParameter("alias_name");
	//citizen=req.getParameter("citizen");
	//nationalidno=req.getParameter("national_id_no");
	//Added on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
	//credential1=req.getParameter("credential_id1");
	//credential2=req.getParameter("credential_id2");
	//credential3=req.getParameter("credential_id3");
	//End of addition on 22/04/2003 by Mallikarjuna Reddy for Credential 1,2,3
	//jobtitle=req.getParameter("job_title");
	//emplstatus=req.getParameter("empl_status");
	//degree=req.getParameter("degree");
	//primaryspecialitycode=req.getParameter("primary_speciality_codeh");
	//allfacilities=req.getParameter("all_facilities");
	if ( allfacilities == null )
				allfacilities="N";
	//repfacility=req.getParameter("rep_facility");
	//restelno=req.getParameter("residencetelno");
	//pagerno=req.getParameter("pagerno");
	//mobileno=req.getParameter("mobileno");
	//offtelno=req.getParameter("offtelno");
	//offtelext=req.getParameter("offtelext");
	//faxno=req.getParameter("faxno");
	//emailid=req.getParameter("emailid");
	//prefmode=req.getParameter("pref_contact_mode");
	//resaddln1=req.getParameter("res_add_ln1");
	//resaddln2=req.getParameter("res_add_ln2");
	//resaddln3=req.getParameter("res_add_ln3");
	//resaddln4=req.getParameter("res_add_ln4");
	//respostalcode=req.getParameter("res_code_value");
	//rescountrycode=req.getParameter("res_add_country_code");
	//offaddln1=req.getParameter("off_add_ln1");
	//offaddln2=req.getParameter("off_add_ln2");
	//offaddln3=req.getParameter("off_add_ln3");
	//offaddln4=req.getParameter("off_add_ln4");
	//offpostalcode=req.getParameter("off_code_value");
	//offcountrycode=req.getParameter("off_add_country_code");
	//mailaddln1=req.getParameter("mail_add_ln1");
	//mailaddln2=req.getParameter("mail_add_ln2");
	//mailaddln3=req.getParameter("mail_add_ln3");
	//mailaddln4=req.getParameter("mail_add_ln4");
	//mailpostalcode=req.getParameter("mail_code_value");
	//mailcountrycode=req.getParameter("mail_add_country_code");
	//effectiveDateFrom = req.getParameter("eff_date_from");
	//effectiveDateTo = req.getParameter("eff_date_to");
	//effectiveStatus = req.getParameter("eff_status1");

	//fppPractYn = checkForNull(req.getParameter("fpp_pract_yn"),"N");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

	//employeeid = req.getParameter("employee_id");
		if(employeeid == null) employeeid ="";
		
		//Below line Added for this CRF HSA-CRF-160
	//other_alt_type=req.getParameter("other_alt_type");	
	if(other_alt_type == null) other_alt_type ="";
	//other_alt_no=req.getParameter("other_alt_no1");	
	if(other_alt_no == null) other_alt_no ="";
	
	//Below line Added fro this CRF ML-MMOH-CRF-0862
	//cerner_practitioner_id=req.getParameter("cerner_practitioner_id");	
	if(cerner_practitioner_id == null) cerner_practitioner_id ="";


	if ( effectiveStatus == null )
			effectiveStatus="D";
	
	//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
	if ( enable_virtual_consultation == null )
		enable_virtual_consultation="D";
	//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 End -->
	
	if(employee_service_number==null) // added by lakshmanan for MO-CRF-20183.2 US001 
		employee_service_number="";	
	
//function_id =req.getParameter("function_id");
if(function_id == null) function_id="";
//longname =req.getParameter("long_name1");
if(longname == null|| longname =="") longname="";
String sql="";
con=ConnectionManager.getConnection();
//stmt=con.createStatement();
int count=0;
boolean statussp=true;

//Added for this CRF ML-MMOH-CRF-0862
boolean migrate_pract_status=false;
String migrate_pract_sql="";
//boolean migrate_pract_status=false;
boolean cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","CERNER_PRACTITIONER_ID");

  if(function_id.equals("PRACTITIONER"))
   {
	  sql="select count(*) from am_ext_practitioner where PRACTITIONER_ID='"+practitionerid+"'";
	  stmt=con.createStatement();
	  rs=stmt.executeQuery(sql);
	  if(rs.next()){
		  count=rs.getInt(1);
	  }
	  if(count>0){
		  statussp=false;
	  }else{
		  statussp=true;
	  }	
    
    /*Below line added for this CRF ML-MMOH-CRF-0862*/ 
	if(count==0 && cernerIdSiteSpecific){
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();		
		migrate_pract_sql="select count(*) from am_ext_practitioner where practitioner_long_id='"+cerner_practitioner_id+"'";
		stmt=con.createStatement();
	    rs=stmt.executeQuery(migrate_pract_sql);
		if(rs.next()){
			count=rs.getInt(1);
		}
		if(count>0){
			  statussp=false;
			  migrate_pract_status=true;
		}else{
			  statussp=true;
		}	
	}
    //End this CRF ML-MMOH-CRF-0862	


   }
  else if(function_id.equals("EXT_PRACT"))
   {
	  sql="select count(*) from am_practitioner where PRACTITIONER_ID='"+practitionerid+"'";
	  stmt=con.createStatement();
	  rs=stmt.executeQuery(sql);
	  if(rs.next()){
		  count=rs.getInt(1);
	  }
	  if(count>0){
		  statussp=false;
	  }else{
		  statussp=true;
	  }	
		  
	/*Below line added for this CRF ML-MMOH-CRF-0862*/ 
	if(count==0 && cernerIdSiteSpecific){
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		stmt=con.createStatement();
		migrate_pract_sql="select count(*) from am_practitioner where practitioner_long_id='"+cerner_practitioner_id+"'";
		stmt=con.createStatement();
	    rs=stmt.executeQuery(migrate_pract_sql);
		if(rs.next()){
			count=rs.getInt(1);
		}
		if(count>0){
			  statussp=false;
			  migrate_pract_status=true;
		}else{
			  statussp=true;
		}	
	}
    //End this CRF ML-MMOH-CRF-0862	 

   }
   if(rs!=null) rs.close();
   if(stmt!=null) stmt.close();
	/*//final InitialContext context = new InitialContext( env );
	//InitialContext context = new InitialContext();
	//Object homeObject = context.lookup("java:comp/env/PractitionerManager");
	//final PractitionerHome practitionerHome = (PractitionerHome) PortableRemoteObject.narrow(homeObject ,PractitionerHome.class);

	//final PractitionerRemote practitionerRemote = practitionerHome.create();
	//final java.util.Hashtable results = practitionerRemote.insertOPPractitioner(	p,
						practtype,practitionerid,practitionername,shortname,sex,birthdate,birthplace,maritalstatus,aliasname,citizen,nationalidno,credential1,credential2,credential3,jobtitle,emplstatus,degree,primaryspecialitycode,allfacilities,repfacility,
						restelno,pagerno,mobileno,offtelno,offtelext,faxno,emailid,prefmode,
						resaddln1,resaddln2,resaddln3,resaddln4,respostalcode,rescountrycode,
						offaddln1,offaddln2,offaddln3,offaddln4,offpostalcode,offcountrycode,
						mailaddln1,mailaddln2,mailaddln3,mailaddln4,mailpostalcode,mailcountrycode,
						effectiveDateFrom,
						effectiveDateTo,	effectiveStatus,
						facilityId, client_ip_address,					employeeid,degree1,degree2,degree3,degree4,year1,year2,year3,year4,univ1,univ2,univ3,univ4,con1,con2,con3,con4,det1,det2,det3,det4,apc_no,function_id
					) ;*/
					//Newly added for Avoiding Duplicate Id entry
					if(statussp){
					boolean local_ejbs = false;

					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PractitionerManager",PractitionerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



				HashMap hashmap = new HashMap();
					hashmap.put("p",p);
					hashmap.put("practtype",practtype);
					hashmap.put("mobileno",mobileno);
					hashmap.put("birthplace",birthplace);
					hashmap.put("practitionerid",practitionerid);
					hashmap.put("practitionername",practitionername);
					hashmap.put("shortname",shortname);
					hashmap.put("sex",sex);
					hashmap.put("birthdate",birthdate);
					hashmap.put("maritalstatus",maritalstatus);
					hashmap.put("aliasname",aliasname);
					hashmap.put("citizen",citizen);
						hashmap.put("nationalidno",nationalidno);
						hashmap.put("credential1",credential1);
						hashmap.put("credential2",credential2);
						hashmap.put("credential3",credential3);
						hashmap.put("jobtitle",jobtitle);
						hashmap.put("emplstatus",emplstatus);
						hashmap.put("degree",degree);
						hashmap.put("primaryspecialitycode",primaryspecialitycode);
						hashmap.put("allfacilities",allfacilities);
						hashmap.put("repfacility",repfacility);
						hashmap.put("restelno",restelno);
						hashmap.put("pagerno",pagerno);
						hashmap.put("offtelno",offtelno);
						hashmap.put("offtelext",offtelext);
						hashmap.put("faxno",faxno);
						hashmap.put("emailid",emailid);
						hashmap.put("prefmode",prefmode);
						hashmap.put("resaddln1",resaddln1);
						hashmap.put("resaddln2",resaddln2);
						hashmap.put("resaddln3",resaddln3);
						hashmap.put("resaddln4",resaddln4);
						hashmap.put("respostalcode",respostalcode);
						hashmap.put("rescountrycode",rescountrycode);
							hashmap.put("offaddln1",offaddln1);
							hashmap.put("offaddln2",offaddln2);
							hashmap.put("offaddln3",offaddln3);
							hashmap.put("offaddln4",offaddln4);
							hashmap.put("offpostalcode",offpostalcode);
							hashmap.put("offcountrycode",offcountrycode);
							hashmap.put("mailaddln1",mailaddln1);
							hashmap.put("mailaddln2",mailaddln2);
							hashmap.put("mailaddln3",mailaddln3);
							hashmap.put("mailaddln4",mailaddln4);
							hashmap.put("mailpostalcode",mailpostalcode);
							hashmap.put("mailcountrycode",mailcountrycode);
							hashmap.put("effectiveDateFrom",effectiveDateFrom);

							hashmap.put("effectiveDateTo",effectiveDateTo);
							hashmap.put("effectiveStatus",effectiveStatus);
							hashmap.put("addedFacilityId",facilityId);
							hashmap.put("addedAtWorkstation",client_ip_address);
							hashmap.put("employeeid",employeeid);
							hashmap.put("degree1",degree1);
							hashmap.put("degree2",degree2);
							hashmap.put("degree3",degree3);
							hashmap.put("degree4",degree4);
							hashmap.put("year1",year1);
							hashmap.put("year2",year2);
							hashmap.put("year3",year3);
							hashmap.put("year4",year4);
							hashmap.put("univ1",univ1);
							hashmap.put("univ2",univ2);
							hashmap.put("univ3",univ3);
							hashmap.put("univ4",univ4);
							hashmap.put("con1",con1);
							hashmap.put("con2",con2);
							hashmap.put("con3",con3);
							hashmap.put("con4",con4);
							hashmap.put("det1",det1);
							hashmap.put("det2",det2);
							hashmap.put("det3",det3);
							hashmap.put("det4",det4);
							hashmap.put("apc_no",apc_no);
							hashmap.put("function_id",function_id);
							hashmap.put("longname",longname);
							
							hashmap.put("fppPractYn",fppPractYn);//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
							hashmap.put("supervisor_yn",supervisor_yn);//Added by Dharma on 19th Aug 2020 against AAKH-CRF-0122.4

                          //Below line Added for this CRF HSA-CRF-160
						 hashmap.put("other_alt_type",other_alt_type);
						 hashmap.put("other_alt_no",other_alt_no);
						 
						 //Below line added for this CRF ML-MMOH-CRF-0862
						 hashmap.put("cerner_practitioner_id",cerner_practitioner_id); 
						 
						//added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
						 hashmap.put("enable_virtual_consultation",enable_virtual_consultation);
						 hashmap.put("employee_service_number",employee_service_number); // added by lakshmanan for MO-CRF-20183.2 US001 

					Object argArray[] = new Object[1];
					argArray[0]=hashmap;


							Class [] paramArray = new Class[1];
							paramArray[0] = hashmap.getClass();

		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertOPPractitioner",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
        // added by manjunath for TH-KW-CRF-0161.1
     
	  
		if ( inserted )
			{   
				if(!docName1.equals(""))
				{  
				insertPractSign(con,req,"Sign");
				}
				if(!docName2.equals(""))
				{  
			  	insertPractSign(con,req,"Stamp");								
				}		
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{    
			     
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
				 hashmap.clear();
			}
					results.clear();
		}else{
		     		
				String error="";
				String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS" ;				
				//Added for this CRF ML-MMOh-CRF-0862
				if(migrate_pract_status) CODE_ALREADY_EXISTS="MIGRATION_PRACTITIONER_ID";				
				//End this CRF ML-MMOh-CRF-0862
				
				java.util.Hashtable message = MessageManager.getMessage( locale, CODE_ALREADY_EXISTS ,"Common") ;
				error=(String) message.get("message");
				String error_value = "0" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
		} catch ( Exception e ) {
		out.println(e.getMessage());
		out.println(e.toString());
		e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e) {}
			if(con != null)      ConnectionManager.returnConnection(con,p);
		}

	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return ( ((inputString == null) || (("").equals(inputString)) || (("null").equals(inputString)) ) ? defaultValue : inputString );
	}
	
 // Below Code modified by manjunath for TH-KW-CRF-0161.1	
public boolean insertPractSign(Connection con,HttpServletRequest req,String signStamp)
    {	 	
		String table = "";	
		PreparedStatement ps1= null;
		ResultSet rs = null;
	//	Connection con = ConnectionManager.getConnection();
		try
      {
		
		if(function_id.equals("PRACTITIONER")) table = "am_practitioner";
		else
		if(function_id.equals("EXT_PRACT")) table = "am_ext_practitioner";
		String sql1="";	
       
		if(signStamp.equals("Sign"))
			{
			sql1 = "update "+table+" set PRACTITIONER_SIGN=empty_blob() where PRACTITIONER_ID= ? ";	
			}
		else if(signStamp.equals("Stamp"))
			{
			sql1 = "update "+table+" set PRACTITIONER_STAMP=empty_blob() where PRACTITIONER_ID= ? ";
			}		
		ps1=con.prepareStatement(sql1);			
		ps1.setString(1,practitionerid);
		int updt_blob_result = ps1.executeUpdate();
		
		if (ps1 != null) ps1.close();
			if(updt_blob_result>0)
			{
				if(signStamp.equals("Sign"))
				{
				
				java.sql.Blob img_blob2 = null;	
          		java.io.OutputStream blobOutputStream2 = null;		
				if(rs!=null) rs.close();
				String sql = "select PRACTITIONER_SIGN from "+table+" WHERE PRACTITIONER_ID = ? for update";
				ps1=con.prepareStatement(sql);
				ps1.setString(1,practitionerid);
				rs= ps1.executeQuery();
					if(rs!=null && rs.next())
					{  
						if(fileItem1 != null)
						{						            
						img_blob2			=	(java.sql.Blob)rs.getBlob(1);
						blobOutputStream2	= img_blob2.setBinaryStream(0);
						int docs			=	 (int)docSize1;
						blobOutputStream2.write(fileItem1.get(),0,docs);
						blobOutputStream2.close();
						}							
					}
					if(rs!=null) rs.close();
					if(ps1!=null)	ps1.close();					 						
					//	con.commit();					
			}
			if(signStamp.equals("Stamp"))
				{
				java.sql.Blob img_blob2 = null;	
          		java.io.OutputStream blobOutputStream2 = null;			
				if(rs!=null) rs.close();
				String sql = "select PRACTITIONER_STAMP from "+table+" WHERE PRACTITIONER_ID = ? for update";
				ps1=con.prepareStatement(sql);
				ps1.setString(1,practitionerid);
				rs= ps1.executeQuery();
				if(rs!=null && rs.next())
					{  
						if(fileItem2 != null)
						{	 
						img_blob2			=	(java.sql.Blob)rs.getBlob(1);
						blobOutputStream2	= img_blob2.setBinaryStream(0);
						int docs			=	 (int)docSize2;
						blobOutputStream2.write(fileItem2.get(),0,docs);
						blobOutputStream2.close();
						}							
					}					
				if(rs!=null) rs.close();
				if(ps1!=null)	ps1.close();					 						
				//	con.commit();
					
			}
				con.commit();
			}
	   }		
		catch (Exception e)
			{
				
		     e.printStackTrace();
		    }
	//	finally
	//		{
		
		//     if(con != null)      
		//	ConnectionManager.returnConnection(con,p);
	//	    }

		return true;
 }
}


	
	
	
	
