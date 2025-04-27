package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class MPForm60Servlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	
	String locale	= "";
	String facilityId	= "";
	String client_ip_address	= "";
	String addedby_id	= "";
	String firstName	= "";                                           
	String middleName	= "";                                            
	String surname	= "";                                         
	String dobInsOfDec	= "";                                             
	String fatherFirstName	= "";                                                 
	String fatherMiddleName	= "";                                                  
	String fatherSurname	= "";                                               
	String flatRoomNo	= "";                                            
	String floorNo	= "";                                         
	String nameOfPremises	= "";              
	String blockNameNo	= "";              
	String roadStreetLane	= "";              
	String areaLocality	= "";              
	String townCity	= "";                      
	String district	= "";                                      
	String state	= "";                                   
	String country	= "";                                     
	String pinCode	= "";                                     
	String telephoneNo	= "";                                         
	String mobileNo	= "";                                      
	String amountOfTransaction	= "";                                                 
	String dateOfTransaction	= "";                                                 
	String noOfPersonsInvolved	= "";                                                 
	String trans_mode_cash_yn	= "";                                                    
	String trans_mode_cheque_yn	= "";                                                      
	String trans_mode_card_yn	= "";                                                    
	String trans_mode_dbs_yn	= "";                                                   
	String trans_mode_online_transfer_yn	= "";                                                      
	String trans_mode_other_yn	= "";                                                     
	String AdharNoIssuedByUIDAI	= "";                                                  
	String isAppliedForPan	= "";                                             
	String PANAcknowledgement	= "";                                                
	String PANDateOfApplication	= "";                                                  
	String estAgriIncome	= "";                                           
	String estNonAgriIncome	= "";                                              
	String idProofDocCode	= "";                                            
	String idProofDocIdNo	= "";                                            
	String idProofNameAddOfAuthority	= "";                                                       
	String addProofDocCode	= "";                                             
	String addProofDocIdNo	= "";                                             
	String addProofNameAddOfAuthority	= "";   
	String ACKNOWLEDG_NO_FORM60	= "";   
	String form60Status			= "";
	
	String encounterId	= "";
	String patientId	= "";

	HttpSession session;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rset;

	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse res) throws javax.servlet.ServletException,IOException {
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;	
        locale = p.getProperty("LOCALE");			
		
		try
		{
			request.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

					
			String operation			= request.getParameter("operation")==null?"":request.getParameter("operation"); 
			
			encounterId					= checkForNull(request.getParameter("encounterId"));
			ACKNOWLEDG_NO_FORM60		= checkForNull(request.getParameter("ACKNOWLEDG_NO_FORM60"));

			
			if(!operation.equals("cancel")){
				patientId					= checkForNull(request.getParameter("patientId"));
				firstName					= checkForNull(request.getParameter("firstName"));
				middleName					= checkForNull(request.getParameter("middleName"));
				surname						= checkForNull(request.getParameter("surname"));
				dobInsOfDec					= checkForNull(request.getParameter("dobInsOfDec"));
				fatherFirstName				= checkForNull(request.getParameter("fatherFirstName"));
				fatherMiddleName			= checkForNull(request.getParameter("fatherMiddleName"));
				fatherSurname				= checkForNull(request.getParameter("fatherSurname"));
				flatRoomNo					= checkForNull(request.getParameter("flatRoomNo"));
				floorNo						= checkForNull(request.getParameter("floorNo"));
				nameOfPremises				= checkForNull(request.getParameter("nameOfPremises"));
				blockNameNo					= checkForNull(request.getParameter("blockNameNo"));
				roadStreetLane				= checkForNull(request.getParameter("roadStreetLane"));
				areaLocality				= checkForNull(request.getParameter("areaLocality"));
				townCity					= checkForNull(request.getParameter("townCity"));
				district					= checkForNull(request.getParameter("district"));
				state						= checkForNull(request.getParameter("state"));
				country						= checkForNull(request.getParameter("country"));
				pinCode						= checkForNull(request.getParameter("pinCode"));
				telephoneNo					= checkForNull(request.getParameter("telephoneNo"));
				mobileNo					= checkForNull(request.getParameter("mobileNo"));
				//amountOfTransaction			= checkForNull(request.getParameter("amountOfTransaction"));
				//dateOfTransaction			= checkForNull(request.getParameter("dateOfTransaction"));
				noOfPersonsInvolved			= checkForNull(request.getParameter("noOfPersonsInvolved"));
				/*trans_mode_cash_yn			= checkForNull(request.getParameter("trans_mode_cash_yn"),"N");
				trans_mode_cheque_yn		= checkForNull(request.getParameter("trans_mode_cheque_yn"),"N");
				trans_mode_card_yn			= checkForNull(request.getParameter("trans_mode_card_yn"),"N");
				trans_mode_dbs_yn			= checkForNull(request.getParameter("trans_mode_dbs_yn"),"N");
				trans_mode_online_transfer_yn	= checkForNull(request.getParameter("trans_mode_online_transfer_yn"),"N");
				trans_mode_other_yn			= checkForNull(request.getParameter("trans_mode_other_yn"),"N");*/
				AdharNoIssuedByUIDAI		= checkForNull(request.getParameter("AdharNoIssuedByUIDAI"));
				isAppliedForPan				= checkForNull(request.getParameter("isAppliedForPan"));
				PANAcknowledgement			= checkForNull(request.getParameter("PANAcknowledgement"));
				PANDateOfApplication		= checkForNull(request.getParameter("PANDateOfApplication"));
				estAgriIncome				= checkForNull(request.getParameter("estAgriIncome"));
				estNonAgriIncome			= checkForNull(request.getParameter("estNonAgriIncome"));
				idProofDocCode				= checkForNull(request.getParameter("idProofDocCode"));
				idProofDocIdNo				= checkForNull(request.getParameter("idProofDocIdNo"));
				idProofNameAddOfAuthority	= checkForNull(request.getParameter("idProofNameAddOfAuthority"));
				addProofDocCode				= checkForNull(request.getParameter("addProofDocCode"));
				addProofDocIdNo				= checkForNull(request.getParameter("addProofDocIdNo"));
				addProofNameAddOfAuthority	= checkForNull(request.getParameter("addProofNameAddOfAuthority"));
				form60Status				= checkForNull(request.getParameter("form60Status"));
			
			}


		
			if (operation.equals("insert")) generateForm60(request,res);
			else if (operation.equals("modify")) modifyForm60(request,res);
			else if (operation.equals("cancel")) cancelForm60(request,res);
			
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,p);
			}
		}
	}

	private  void generateForm60(HttpServletRequest request,HttpServletResponse res) {
		try
		{

			con=ConnectionManager.getConnection(request);


			String addedById = p.getProperty( "login_user" ) ;

			String modifiedById = addedById ;

			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			StringTokenizer str	= null;
			String day	= "";
			String month	= "";
			String year	= "";
			String dobInsOfDec1	 = "";
			//String dateOfTransaction1	 = ""; //Commented by Suji Keerthi for checkstyle
			String PANDateOfApplication1	 = "";
			HashMap tabdata=new HashMap();

			if(!dobInsOfDec.equals("")){
				dobInsOfDec1=com.ehis.util.DateUtils.convertDate(dobInsOfDec,"DMY",locale,"en");
			
				str=new StringTokenizer(dobInsOfDec1, "/");
				day=str.nextToken();
				month=str.nextToken();		
				year=str.nextToken();
				dobInsOfDec1=year+"-"+month+"-"+day+" 00:00:00.00";		
				tabdata.put("DATE_OF_BIRTH",Timestamp.valueOf((dobInsOfDec1)));
			}

			/*if(!dateOfTransaction.equals("")){
				dateOfTransaction1=com.ehis.util.DateUtils.convertDate(dateOfTransaction,"DMY",locale,"en");
				str=new StringTokenizer(dateOfTransaction1, "/");
				day=str.nextToken();
				month=str.nextToken();		
				year=str.nextToken();
				dateOfTransaction1=year+"-"+month+"-"+day+" 00:00:00.00";	
				tabdata.put("DATE_OF_TRANS",Timestamp.valueOf((dateOfTransaction1))); 
			}*/

			if(!PANDateOfApplication.equals("")){
				PANDateOfApplication1=com.ehis.util.DateUtils.convertDate(PANDateOfApplication,"DMY",locale,"en");
				str=new StringTokenizer(PANDateOfApplication1, "/");
				day=str.nextToken();
				month=str.nextToken();		
				year=str.nextToken();
				PANDateOfApplication1=year+"-"+month+"-"+day+" 00:00:00.00";
				tabdata.put("DATE_OF_APP_PAN",Timestamp.valueOf((PANDateOfApplication1)));
			}

			String sql="select form60_number_generation ACK_NO from dual";			
			pstmt = con.prepareStatement( sql );
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()){
				ACKNOWLEDG_NO_FORM60=rset.getString("ACK_NO");
			}
			if(pstmt !=null) pstmt.close();
			if(rset !=null) rset.close();


			
			tabdata.put("ACKNOWLEDG_NO_FORM60",ACKNOWLEDG_NO_FORM60);
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("ENCOUNTER_ID",encounterId);
			tabdata.put("PATIENT_ID",patientId);
			tabdata.put("FIRST_NAME",firstName);
			tabdata.put("SECOND_NAME",middleName);
			tabdata.put("THIRD_NAME",surname);
			//tabdata.put("DATE_OF_BIRTH",dobInsOfDec1);
		
			tabdata.put("FATHER_FIRST_NAME",fatherFirstName);
			tabdata.put("FATHER_SECOND_NAME",fatherMiddleName);
			tabdata.put("FATHER_THIRD_NAME",fatherSurname);
			tabdata.put("ADDR_FLAT_NO",flatRoomNo);
			tabdata.put("ADDR_FLOOR_NO",floorNo);
			tabdata.put("ADDR_NAME_PREMISES",nameOfPremises);
			tabdata.put("ADDR_BLOCK_NAME",blockNameNo);
			tabdata.put("ADDR_LANE",roadStreetLane);
			tabdata.put("ADDR_LOCALITY",areaLocality);
			tabdata.put("RES_TOWN_DESC",townCity);
			tabdata.put("RES_DISTRICT_DESC",district);
			tabdata.put("STATE_DESC",state);
			tabdata.put("COUNTRY_DESC",country);
			tabdata.put("POSTAL_CODE",pinCode);
			tabdata.put("CONTACT_TEL_NO",telephoneNo);
			tabdata.put("CONTACT_MOB_NO",mobileNo);
			//tabdata.put("TRANS_AMT",amountOfTransaction);
			//tabdata.put("DATE_OF_TRANS",dateOfTransaction1);
		
			tabdata.put("TRANS_NO_PERSONS",noOfPersonsInvolved);
			tabdata.put("AADHAR_NO",AdharNoIssuedByUIDAI);
			tabdata.put("ACKNOWLEDGE_NO_PAN",PANAcknowledgement);
			//tabdata.put("DATE_OF_APP_PAN",PANDateOfApplication1);
		
			tabdata.put("AGRICULTURAL_INCOME",estAgriIncome);
			tabdata.put("AGRICULTURAL_NON_INCOME",estNonAgriIncome);
			tabdata.put("STATUS",form60Status);
			tabdata.put("PAN_APPLIED_YN",isAppliedForPan);
			/*tabdata.put("TRANS_MODE_CASH_YN",trans_mode_cash_yn);
			tabdata.put("TRANS_MODE_CHEQUE_YN",trans_mode_cheque_yn);
			tabdata.put("TRANS_MODE_CARD_YN",trans_mode_card_yn);
			tabdata.put("TRANS_MODE_DBS_YN",trans_mode_dbs_yn);
			tabdata.put("TRANS_MODE_ONLINETRANS_YN",trans_mode_online_transfer_yn);
			tabdata.put("TRANS_MODE_OTHER_YN",trans_mode_other_yn);*/
			
			tabdata.put("ID_PROOF_DOC_CODE",idProofDocCode);
			tabdata.put("ID_PROOF_DOC_ID_NO",idProofDocIdNo);
			tabdata.put("ID_PROOF_ADDR_AUTH",idProofNameAddOfAuthority);
			tabdata.put("ADDR_PROOF_DOC_CODE",addProofDocCode);
			tabdata.put("ADDR_PROOF_DOC_ID_NO",addProofDocIdNo);
			tabdata.put("ADDR_PROOF_ADDR_AUTH",addProofNameAddOfAuthority);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"ACKNOWLEDG_NO_FORM60"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_FORM60";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			//String error_value = "0" ; //Commented by Suji Keerthi for checkstyle
			results.clear();
			if ( inserted ) {
				out.println("<script>parent.onSuccess();parent.window.returnValue= \""+inserted+"\" ;</script>");
			} else {
				out.println("<html><script>parent.frames(1).location.href =\"../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");
			}
			
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();

		}
		//Below added by Suji keerthi for Connection not Closed
		finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,request);
			}
		}
		//Ended by suji keerthi for Connection not Closed

	}
	
	private void modifyForm60(HttpServletRequest request,HttpServletResponse res)
	{

		try
		{
			String addedById = p.getProperty( "login_user" ) ;

			String modifiedById = addedById ;

			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			StringTokenizer str	= null;
			String day	= "";
			String month	= "";
			String year	= "";
			String dobInsOfDec1	 = "";
			//String dateOfTransaction1	 = ""; //Commented by Suji keerthi for checkstyle
			String PANDateOfApplication1	 = "";
			HashMap tabdata=new HashMap();
			if(!dobInsOfDec.equals("")){
				dobInsOfDec1=com.ehis.util.DateUtils.convertDate(dobInsOfDec,"DMY",locale,"en");
			
				str=new StringTokenizer(dobInsOfDec1, "/");
				day=str.nextToken();
				month=str.nextToken();		
				year=str.nextToken();
				dobInsOfDec1=year+"-"+month+"-"+day+" 00:00:00.00";	
				tabdata.put("DATE_OF_BIRTH",Timestamp.valueOf((dobInsOfDec1)));
			
			}

			/*if(!dateOfTransaction.equals("")){
				dateOfTransaction1=com.ehis.util.DateUtils.convertDate(dateOfTransaction,"DMY",locale,"en");
				str=new StringTokenizer(dateOfTransaction1, "/");
				day=str.nextToken();
				month=str.nextToken();		
				year=str.nextToken();
				dateOfTransaction1=year+"-"+month+"-"+day+" 00:00:00.00";	
					tabdata.put("DATE_OF_TRANS", Timestamp.valueOf((dateOfTransaction1)));
			}*/

			if(!PANDateOfApplication.equals("")){
				PANDateOfApplication1=com.ehis.util.DateUtils.convertDate(PANDateOfApplication,"DMY",locale,"en");
				str=new StringTokenizer(PANDateOfApplication1, "/");
				day=str.nextToken();
				month=str.nextToken();		
				year=str.nextToken();
				PANDateOfApplication1=year+"-"+month+"-"+day+" 00:00:00.00";		
				tabdata.put("DATE_OF_APP_PAN",Timestamp.valueOf((PANDateOfApplication1)));
			}


		
			//tabdata.put("FACILITY_ID",facilityId);
			//tabdata.put("ENCOUNTER_ID",encounterId);
			//tabdata.put("PATIENT_ID",patientId);
			tabdata.put("FIRST_NAME",firstName);
			tabdata.put("SECOND_NAME",middleName);
			tabdata.put("THIRD_NAME",surname);
			//tabdata.put("DATE_OF_BIRTH",dobInsOfDec1);
			
			tabdata.put("FATHER_FIRST_NAME",fatherFirstName);
			tabdata.put("FATHER_SECOND_NAME",fatherMiddleName);
			tabdata.put("FATHER_THIRD_NAME",fatherSurname);
			tabdata.put("ADDR_FLAT_NO",flatRoomNo);
			tabdata.put("ADDR_FLOOR_NO",floorNo);
			tabdata.put("ADDR_NAME_PREMISES",nameOfPremises);
			tabdata.put("ADDR_BLOCK_NAME",blockNameNo);
			tabdata.put("ADDR_LANE",roadStreetLane);
			tabdata.put("ADDR_LOCALITY",areaLocality);
			tabdata.put("RES_TOWN_DESC",townCity);
			tabdata.put("RES_DISTRICT_DESC",district);
			tabdata.put("STATE_DESC",state);
			tabdata.put("COUNTRY_DESC",country);
			tabdata.put("POSTAL_CODE",pinCode);
			tabdata.put("CONTACT_TEL_NO",telephoneNo);
			tabdata.put("CONTACT_MOB_NO",mobileNo);
			//tabdata.put("TRANS_AMT",amountOfTransaction);
			//tabdata.put("DATE_OF_TRANS",dateOfTransaction1);
			
			
			tabdata.put("TRANS_NO_PERSONS",noOfPersonsInvolved);
			tabdata.put("AADHAR_NO",AdharNoIssuedByUIDAI);
			tabdata.put("ACKNOWLEDGE_NO_PAN",PANAcknowledgement);
			//tabdata.put("DATE_OF_APP_PAN",PANDateOfApplication1);
	
			tabdata.put("AGRICULTURAL_INCOME",estAgriIncome);
			tabdata.put("AGRICULTURAL_NON_INCOME",estNonAgriIncome);
			tabdata.put("STATUS",form60Status);
			tabdata.put("PAN_APPLIED_YN",isAppliedForPan);
			/*tabdata.put("TRANS_MODE_CASH_YN",trans_mode_cash_yn);
			tabdata.put("TRANS_MODE_CHEQUE_YN",trans_mode_cheque_yn);
			tabdata.put("TRANS_MODE_CARD_YN",trans_mode_card_yn);
			tabdata.put("TRANS_MODE_DBS_YN",trans_mode_dbs_yn);
			tabdata.put("TRANS_MODE_ONLINETRANS_YN",trans_mode_online_transfer_yn);
			tabdata.put("TRANS_MODE_OTHER_YN",trans_mode_other_yn);*/
			
			tabdata.put("ID_PROOF_DOC_CODE",idProofDocCode);
			tabdata.put("ID_PROOF_DOC_ID_NO",idProofDocIdNo);
			tabdata.put("ID_PROOF_ADDR_AUTH",idProofNameAddOfAuthority);
			tabdata.put("ADDR_PROOF_DOC_CODE",addProofDocCode);
			tabdata.put("ADDR_PROOF_DOC_ID_NO",addProofDocIdNo);
			tabdata.put("ADDR_PROOF_ADDR_AUTH",addProofNameAddOfAuthority);

			//tabdata.put("added_by_id",addedById);
			//tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			//tabdata.put("added_facility_id", facilityId);
			//tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("ACKNOWLEDG_NO_FORM60",ACKNOWLEDG_NO_FORM60);

				boolean local_ejbs = isLocalEJB();
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = "MP_FORM60";

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass(); ;
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = String.class;
				
				java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				argArray = null;
				paramArray = null;
				tabdata.clear();

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

				String error = (String) results.get("error") ;
				//String error_value = "0" ; //Commented by Suji Keerthi for checkstyle
		
				
				if ( inserted ) {
				out.println("<script>parent.onSuccess();parent.window.returnValue= \""+inserted+"\" ;</script>");
			} else {
				out.println("<html><script>parent.frames(1).location.href =\"../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");
			}
			condflds.clear();
			results.clear();

				
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ... Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();
		}
	}


	private  void cancelForm60(HttpServletRequest request,HttpServletResponse res) {
		try
		{
			con=ConnectionManager.getConnection(request);

			String addedById = p.getProperty( "login_user" ) ;
			int result			= 0;

			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String modifiedAtWorkstation = client_ip_address ;

			String sql="update MP_FORM60 set STATUS='C',MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where ENCOUNTER_ID='"+encounterId+"' and ACKNOWLEDG_NO_FORM60='"+ACKNOWLEDG_NO_FORM60+"' and STATUS!='C' ";

			
			pstmt = con.prepareStatement( sql );				
			result= pstmt.executeUpdate();							
				
			if ( result > 0 ){
				 con.commit();
				out.println("<script>parent.onSuccessCancel();</script>");
			}else{
				con.rollback();
				out.println("<script>parent.onErrorCancel();</script>");
			}

			if(pstmt !=null) pstmt.close();
		
			
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();

		}finally{
			if(con !=null){
				ConnectionManager.returnConnection(con,p);
			}
		}
	}




	public String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
		public String checkForNull(String inputString, String Defaultstr)
	{
		return((inputString == null) ? Defaultstr : inputString);
	}

	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		else
			return false;
	}
} 