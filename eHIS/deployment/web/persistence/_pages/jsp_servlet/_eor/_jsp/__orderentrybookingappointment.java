package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eOR.Common.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrybookingappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eor/jsp/OrderEntryBookingAppointment.jsp", 1731155108000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-----------------------------------------------------------------------
Date        	Edit History   		Name        	Description
-----------------------------------------------------------------------
?             		100         	 ?           	 created
27/09/2012		 IN035299			Nijithas		CRF-OR- Bru-HIMS-CRF-263/03-Schedule Appointment window is not prompted
18/16/2013       IN039429           Nijithas        Alpha-OTMS-OT-Unable to book multiple procedures for a patient
12/12/2013		 IN045109 			VijayakumarK    While placing RD order from Ripas Facility in CA with performing facility as Tutong and booking appt, System is not displaying the Tutong faciltiy wing in the LOV . Hence unable to book
-------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Review Date 		Review Name 		Description
-------------------------------------------------------------------------------------------------------------------------------------
27/12/2022		37051			Ramesh Goli		27/12/2022			Ramesh G 			ML-MMOH-CRF-1939.1
-------------------------------------------------------------------------------------------------------------------------------------

*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
    
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter( "bean_id" ) ;
	String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String localeName=request.getParameter("localeName");	
	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");

	if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
		return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	/* Initialize Function specific start */
	//OrderEntryBean beanObj = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		beanQueryObj.setLanguageId(localeName);

	OrderEntryBean beanObj		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		beanObj.setLanguageId(localeName);

	/* Initialize Function specific end */
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;
 
	Properties properties		= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
   	String patient_id			= beanObj.checkForNull((String)hash.get("patient_id"),"") ;
  	String location_code		= beanObj.checkForNull((String)hash.get("location_code"),"") ;
   	String location_type		= beanObj.checkForNull((String)hash.get("location_type"),"") ;
   	String ordering_practitioner= beanObj.checkForNull((String)hash.get("ordering_practitioner"),"") ;
   	String specialty_code		= beanObj.checkForNull((String)hash.get("specialty_code"),"") ;
	String appt_reqd_yn			= "",	catalog_code		= "";	
	String order_id				= "",	order_line_num		= "";
	String fpp_yn				= "",	fpp_category		= "";//37051
	String start_date_time		= "",   catalog_code_dc		= "",performing_facility_id = "";
	int total_records			= 0;
    String order_status_code1    ="",   order_category		= "", prompt_yn = "" ;
	Hashtable hashOABookAppt	= null;
	performing_facility_id = beanObj.checkForNull(request.getParameter("performing_facility_id"),"");//IN045109
	// Called to check whether the particular catalog which has been placed an order has an 
	// appt_reqd_yn , If it is there for it then call the OA Booking Appointment to book an appointment
	// for that order_id 

	if ( func_mode.equals("CALL_OA_APPT"))  
	{
		hashOABookAppt		= 	beanObj.getOABookApptValues();  //Will get an Hashtable
		if(hashOABookAppt!=null && hashOABookAppt.size() > 0)
		{
 			total_records						= Integer.parseInt(beanObj.checkForNull((String)hashOABookAppt.get("total_records"),"0"));
			for(int i=0; i<(total_records-1); i++)
			{
				appt_reqd_yn		= beanObj.checkForNull((String)hashOABookAppt.get("appt_reqd_yn"+i),"N");
				order_id			= beanObj.checkForNull((String)hashOABookAppt.get("order_id"+i),"");
				order_line_num		= beanObj.checkForNull((String)hashOABookAppt.get("order_line_num"+i),"");
				catalog_code		= beanObj.checkForNull((String)hashOABookAppt.get("catalog_code"+i),"");
				catalog_code_dc		= beanObj.checkForNull((String)hashOABookAppt.get("catalog_code_dc"+i),"");
				start_date_time		= beanObj.checkForNull((String)hashOABookAppt.get("start_date_time"+i),"");
				order_status_code1   = beanObj.checkForNull((String)hashOABookAppt.get("order_status_code"+i),"");
				performing_facility_id   = beanObj.checkForNull((String)hashOABookAppt.get("performing_facility_id"+i),"");
				fpp_yn	  = beanObj.checkForNull((String)hashOABookAppt.get("fpp_yn"+i),"");   //37051
				fpp_category   = beanObj.checkForNull((String)hashOABookAppt.get("fpp_category"+i),"");  //37051
				order_category      = order_id.substring(0,2);
				prompt_yn = beanQueryObj.getApptPromptYN(properties,order_category);

				if(!start_date_time.equals(""))
				{ // Pass only the time, remove the hours and mins
					start_date_time		= start_date_time.substring(0,10);  //dd/mm/yyyy
	 			}

				if(appt_reqd_yn.equals("Y") && order_status_code1.equals("OS") && prompt_yn.equalsIgnoreCase("Y")) 
				{ // If appointment is there, call the OA Book appointment
					out.println( "callAppointmentBooking(\""+patient_id+"\",\"" +location_code+"\" ,\""+location_type+"\",\""+ordering_practitioner+"\",\""+specialty_code+"\",\""+order_id+"\",\""+order_line_num+"\",\"" +catalog_code+"\" ,\""+start_date_time+"\" ,\""+catalog_code_dc+"\",\""+performing_facility_id+"\",\""+facility_id+"\",\""+fpp_yn+"\",\""+fpp_category+"\") ; " ) ;
				} // End of if
			} // End of for 
		} // End of if hashOABookAppt	
	} // End of CALL_OA_APPT
	else if ( func_mode.equals("CALL_OT_APPT"))  
	{ //If it is an OT APPT, to get the surgeon name and the pref_date , query from the database and pass as an parameter.
		hashOABookAppt		= 	beanObj.getOABookApptValues();  //Will get an Hashtable

		if(hashOABookAppt!=null && hashOABookAppt.size() > 0)	
		{
			ArrayList OTBookAppointment = null;
			String records[]			= null;
			String practitioner_id		= null, practitioner_name	= "";
			String pref_surg_date		= null;
			String order_status_code    ="";
			String performing_dept_loc_code = null; //IN31901
			int app_promt_applicable = 0; //IN31901
			String order_id_new = "";//IN039429
			String ot_instal_yn	= beanObj.checkForNull(beanObj.getFacilityModuleInstallYn("OT"),"N"); // check whether the lb_module is installed or not,
 			total_records				= Integer.parseInt(beanObj.checkForNull((String)hashOABookAppt.get("total_records"),"0"));
  			// Since this will be total_records +1 (subtract 1)
 			for(int i=0; i<(total_records-1); i++)
			{			//FOR OT, Because of Primary speciality concept, there will be only one record
 				appt_reqd_yn		= beanObj.checkForNull((String)hashOABookAppt.get("appt_reqd_yn"+i),"N");
				order_id			= beanObj.checkForNull((String)hashOABookAppt.get("order_id"+i),"");
  				order_status_code   = beanObj.checkForNull((String)hashOABookAppt.get("order_status_code"+i),"");
  			    //IN035299 Starts
  				order_line_num		= beanObj.checkForNull((String)hashOABookAppt.get("order_line_num"+i),"");
				catalog_code		= beanObj.checkForNull((String)hashOABookAppt.get("catalog_code"+i),"");
				catalog_code_dc		= beanObj.checkForNull((String)hashOABookAppt.get("catalog_code_dc"+i),"");
				start_date_time		= beanObj.checkForNull((String)hashOABookAppt.get("start_date_time"+i),"");
				performing_facility_id   = beanObj.checkForNull((String)hashOABookAppt.get("performing_facility_id"+i),"");
				fpp_yn	  = beanObj.checkForNull((String)hashOABookAppt.get("fpp_yn"+i),"");   //37051
				fpp_category   = beanObj.checkForNull((String)hashOABookAppt.get("fpp_category"+i),"");  //37051
				order_category      = order_id.substring(0,2);
				//IN035299 Ends
				//IN31901 Starts
				performing_dept_loc_code		= (String)hashOABookAppt.get("performing_dept_loc_code"+i);
				if("".equals(performing_dept_loc_code)){
					app_promt_applicable++;
				}
				//IN31901 Ends
				prompt_yn = beanQueryObj.getApptPromptYN(properties,order_category);
				
				// Get this order_id to query the necessary details.
				if(order_id!=null && !order_id.equals("")) 
				{
 					OTBookAppointment	= beanQueryObj.getOTBookingDetails(properties, order_id);
 					if(OTBookAppointment!=null && OTBookAppointment.size()>0) 
					{
						for(int k=0; k<OTBookAppointment.size(); k++)   //Anyway only one record
						{
 							records				= (String[])OTBookAppointment.get(k);
							pref_surg_date		= (beanQueryObj.checkForNull(records[0],""));
 							practitioner_id		= (beanQueryObj.checkForNull(records[1],""));
							practitioner_name	= (beanQueryObj.checkForNull(records[2],""));
						} //End of for OTBookAppointment
					} // End of if OTBookAppointment
				} //End of !order_id.equals("")
				//IN035299 Starts
				if(ot_instal_yn.equals("Y")  && appt_reqd_yn.equals("Y") && order_status_code.equals("OS") && prompt_yn.equalsIgnoreCase("Y") && !"".equals(performing_dept_loc_code)  )
				{
					out.println( "callAppointmentBooking(\""+patient_id+"\",\"" +location_code+"\" ,\""+location_type+"\",\""+ordering_practitioner+"\",\""+specialty_code+"\",\""+order_id+"\",\""+order_line_num+"\",\"" +catalog_code+"\" ,\""+start_date_time+"\" ,\""+catalog_code_dc+"\",\""+performing_facility_id+"\",\""+facility_id+"\",\""+fpp_yn+"\",\""+fpp_category+"\") ; " ) ;
				}
				//IN035299 Ends
				//IN039429 Starts
				if(ot_instal_yn.equals("Y") && order_status_code.equals("OS") && prompt_yn.equalsIgnoreCase("Y") &&  "".equals(performing_dept_loc_code) && !order_id_new.equals(order_id)){//IN31901
				order_id_new = order_id;
				out.println( "callOTAppointment(\""+order_id+"\",\""+practitioner_id+"\", \""+practitioner_name+"\", \""+pref_surg_date+"\",\""+fpp_yn+"\",\""+fpp_category+"\") ; " ) ;
				}
				//IN039429 Ends
			} // End of loop for total_records
			//THERE WILL BE ONLY ONE RECORD, so call the javascript function from here itself 
			
			//if(ot_instal_yn.equals("Y") && order_status_code.equals("OS") && prompt_yn.equalsIgnoreCase("Y")){//IN31901 
			//Commented for IN039429 
			/*if(ot_instal_yn.equals("Y") && order_status_code.equals("OS") && prompt_yn.equalsIgnoreCase("Y") && app_promt_applicable > 0){//IN31901
				out.println( "callOTAppointment(\""+order_id+"\",\""+practitioner_id+"\", \""+practitioner_name+"\", \""+pref_surg_date+"\") ; " ) ;
			}*/
			// Nullifying the objects
			OTBookAppointment		= null; records  = null;
		} // End of if 	hashOABookAppt	 
	} // End of CALL_OT_APPT
	else if ( func_mode.equals("CALL_RD_APPT"))  
	{ //If it is an RD APPT, if RD is installed , call the FORM version
		String performing_dept_loc_code	= "";
		/*	ws_no				= "",	j2_parameter	= "";
			String session_id				= "", user_id			= "",	user_password	= "";
			String jdbc_dns					= "", database_name		= "",	facility_id		= "";
			String responsibility_id		= "", error_message		= "",	function_id     = "";
			//String user_id_password			= "";
			String build_form_string = "",   user_details	= ""; 
		*/
		String order_status_code2="";
		hashOABookAppt					= beanObj.getOABookApptValues();  //Will get an Hashtable
		if(hashOABookAppt!=null && hashOABookAppt.size() > 0 )//
		{
			//user_id						= (String) session.getAttribute( "login_user" ) ;
			// Query and take the database user_id and password
			//user_password				= beanObj.checkForNull(beanQueryObj.getUserIdPassword(properties,user_id ));
			total_records				= Integer.parseInt(beanObj.checkForNull((String)hashOABookAppt.get("total_records"),"0"));

			/*facility_id					= (String)session.getValue("facility_id");
			responsibility_id			= "RD_MANAGER";
			session_id					= session.getId();
			ws_no						= properties.getProperty( "client_ip_address");
			jdbc_dns					= properties.getProperty( "ecis_jdbc_dns" );
			database_name				= "";
			if(jdbc_dns!=null)
				database_name			= jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());
			user_details				= (user_id)+"/"+(user_password)+"@"+(database_name);
			function_id					= "RD_ORDRD_EXM_APPT";
			*/

			for(int i=0; i<(total_records-1); i++)
			{
				appt_reqd_yn		= beanObj.checkForNull((String)hashOABookAppt.get("appt_reqd_yn"+i),"N");
				catalog_code_dc		= beanObj.checkForNull((String)hashOABookAppt.get("catalog_code_dc"+i),"");
				order_id			= beanObj.checkForNull((String)hashOABookAppt.get("order_id"+i),"");
				order_category      = order_id.substring(0,2);				
				prompt_yn = beanQueryObj.getApptPromptYN(properties,order_category);

				//order_id			= beanObj.checkForNull((String)hashOABookAppt.get("order_id"+i),"");
				//order_line_num		= beanObj.checkForNull((String)hashOABookAppt.get("order_line_num"+i),"");
				//catalog_code		= beanObj.checkForNull((String)hashOABookAppt.get("catalog_code"+i),"");
				//start_date_time		= beanObj.checkForNull((String)hashOABookAppt.get("start_date_time"+i),"");
				//if(!start_date_time.equals("")){ // Pass only the time, remove the hours and mins
				//		start_date_time		= start_date_time.substring(0,10);  //dd/mm/yyyy
				//}
				order_status_code2   = beanObj.checkForNull((String)hashOABookAppt.get("order_status_code"+i),"");
			
			
				if(appt_reqd_yn.equals("Y") && order_status_code2.equals("OS") && prompt_yn.equalsIgnoreCase("Y")) 
				{ // If RD is installed, call the Forms Version
					performing_dept_loc_code= beanObj.checkForNull((String)hashOABookAppt.get("performing_dept_loc_code"+i),"");
					//IN045109 starts
					performing_facility_id   = beanObj.checkForNull((String)hashOABookAppt.get("performing_facility_id"+i),"");
					//out.println( "getRDAppointmentConfirm(\""+bean_id+"\", \""+bean_name+"\", \""+patient_id+"\", \""+performing_dept_loc_code+"\", \""+catalog_code_dc+"\") ; " ) ;
					out.println( "getRDAppointmentConfirm(\""+bean_id+"\", \""+bean_name+"\", \""+patient_id+"\", \""+performing_dept_loc_code+"\", \""+catalog_code_dc+"\", \""+performing_facility_id+"\") ; " ) ;
					//IN045109 ends
 				
				//j2_parameter			= "||P_PATIENT_ID="+patient_id+"|P_WING_CODE="+performing_dept_loc_code;
				//error_message		= beanObj.checkForNull(beanQueryObj.getJ2fInterface(properties, ws_no, function_id,j2_parameter,session_id, user_details, facility_id,responsibility_id));
				//	if(!error_message.equals("")){
				//		out.println( "callRDAlert(\""+error_message+"\") ; " ) ;
				//	} else {  //Open the Forms window.
  				//		 build_form_string = "IFRUN60.exe SMJNAVIG  "+user_details+" P_LANGUAGE_ID=US P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id;
				//		 out.println( "callRDAppointment(\""+build_form_string+"\", \""+catalog_code_dc+"\") ; " ) ;	
				//	} // End of !error_message
				} // End of if
			} // End of for total_records
		} // End of if hashOABookAppt	
	}	// End of CALL_RD_APPT
	else if ( func_mode.equals("CALL_RD_INSTAL_APPT"))  
	{ //If it is an RD APPT, if RD is installed , call the FORM version
		String performing_dept_loc_code	= "", ws_no				= "",	j2_parameter	= "";
		String session_id				= "", user_id			= "",	user_password	= "";
		String jdbc_dns					= "", database_name		= "";
		String responsibility_id		= "", error_message		= "",	function_id     = "";
		String build_form_string		= "", user_details		= ""; 

 
		user_id						= (String) session.getAttribute( "login_user" ) ;
		// Query and take the database user_id and password
		user_password				= beanObj.checkForNull(beanQueryObj.getUserIdPassword(properties, user_id ));
 		responsibility_id			= "RD_MANAGER";
		session_id					= session.getId();
		ws_no						= properties.getProperty( "client_ip_address");
 		jdbc_dns					= properties.getProperty( "ecis_jdbc_dns" );
		database_name				= "";
		if(jdbc_dns!=null)
			database_name			= jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());
		user_details				= (user_id)+"/"+(user_password)+"@"+(database_name);
		//function_id					= "RD_ORDRD_EXM_APPT";
		function_id					= "RD_WRKLSK";
 
		//appt_reqd_yn				= beanObj.checkForNull((String)hash.get("appt_reqd_yn"),"N") ;
  		performing_dept_loc_code	= beanObj.checkForNull((String)hash.get("performing_dept_loc_code"),"") ;  

		j2_parameter				= "||P_PATIENT_ID="+patient_id+"|P_WING_CODE="+performing_dept_loc_code;
		//As per Balan's requirement, it is commented. starts
		//error_message				= beanObj.checkForNull(beanQueryObj.getJ2fInterface(properties, ws_no, function_id,j2_parameter,session_id, user_details, facility_id,responsibility_id));
		//ends
		error_message				="";//beanObj.checkForNull(beanQueryObj.getJ2fInterface(properties, ws_no, function_id,j2_parameter,session_id, user_details, facility_id,responsibility_id));
		//As per Balan's requirement, it is commented. starts
		//if(!error_message.equals("")){
			//out.println( "callRDAlert(\""+error_message+"\") ; " ) ;
		//} else {  //Open the Forms window.
  			 //build_form_string = "IFRUN60.exe SMJNAVIG  "+user_details+" P_LANGUAGE_ID=US P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id;
		//ends
			//IN045109 starts
			 //build_form_string = "IFRUN60.exe RDIORLKP P_USER_ID="+ user_id + " P_PWD="+ user_password + " P_HOSTSTRING="+database_name+" P_LANGUAGE_ID="+locale+"  P_FACILITY_ID="+facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id+"  P_PATIENT_ID="+patient_id+" P_ACCESS_RIGHTS=YYYNN P_FUNCTION_ID=RD_ORDRD_EXM_APPT P_invoke=IBAEHIS";
			 build_form_string = "IFRUN60.exe RDIORLKP P_USER_ID="+ user_id + " P_PWD="+ user_password + " P_HOSTSTRING="+database_name+" P_LANGUAGE_ID="+locale+"  P_FACILITY_ID="+performing_facility_id+" P_WS_NO="+ws_no+" P_RESP_ID="+responsibility_id+"  P_PATIENT_ID="+patient_id+" P_ACCESS_RIGHTS=YYYNN P_FUNCTION_ID=RD_ORDRD_EXM_APPT P_invoke=IBAEHIS";
			 //IN045109 ends
			//As per Balan's requirement, it is commented. starts
			//P_WING_CODE="+performing_dept_loc_code+" P_PATIENT_ID="+patient_id+ "";
			//ends

			// out.println( "callRDAppointment(\""+build_form_string+"\", \""+catalog_code_dc+"\") ; " ) ;	
			 out.println( "callRDAppointment(\""+build_form_string+"\") ; " ) ;
		//As per Balan's requirement, it is commented. starts
		//} // End of !error_message
		//ends
  	}	// End of CALL_RD_APPT

	// Nullifying the Objects
	hashOABookAppt		= null;

	// set it back persistence
	// no need for persistence
	//putObjectInBean(bean_id,beanObj,request);


            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
