package eBL;

import java.lang.reflect.Method;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.StringTokenizer;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import eBL.PkgParameters.*;
import eBL.*;
import com.ehis.persist.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList ;
import eCommon.Common.*;
import com.ehis.eslp.ServiceLocator;
import eBL.PkgAdhocDiscountBean.*;



/**
 * Servlet implementation class BLZATCAResponseServlet
 */
public class BLZATCAResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;

	java.util.Properties p;

	HttpSession session;

	Connection con;

	PreparedStatement pstmt;

	ResultSet rs;	

	Hashtable messageHashtable=new Hashtable();
	String msg="";

	StringBuffer sb = new StringBuffer();

	String str_facility_id, str_client_ip_address, str_user_id ;

	String locale;

	String sStyle = "";

	String str_module_id = "", str_function_id = "", str_audit_no = "", str_trx_doc_ref = "" , str_trx_doc_ref_line_num = "", str_trx_doc_ref_seq_num = ""; String str_episode_type = "", str_patient_id = "", str_encounter_id = "";
	String str_bill_doc_type = "", str_bill_doc_num = "", str_query_string = "";

	String str_tot_rec="";

	String str_error_level = "", str_error_text = "", str_sys_message_id = "";
	
	int totalRecords=0;
	HashMap<String, ArrayList<String>> zatcaResubmissionRecords = new HashMap<String, ArrayList<String>>();
	ArrayList<String> zatcaResubmissionRecord;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLZATCAResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.err.println("Entered in do post of BLZATCAResponseServlet.java");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");

		this.str_facility_id = (String) session.getValue("facility_id");
		if(str_facility_id == null) str_facility_id="";
		
		System.err.println("str_facility_id.........................................."+str_facility_id);

		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";

		str_client_ip_address = p.getProperty("client_ip_address");
		if(str_client_ip_address == null) str_client_ip_address="";

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";

		locale = p.getProperty("LOCALE");

		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			
			ZATCAReSubmission(req, res);

		} 
		catch (Exception e) 
		{
			System.err.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			//out.println(e.toString());
		} 
	}

	private void ZATCAReSubmission(HttpServletRequest req,HttpServletResponse res) throws SQLException
	{
		try 
		{
			con	=	ConnectionManager.getConnection(req);

			String sys_error = "";
			String str_error_level = "", str_error_text = "", str_sys_message_id = "";
			java.util.HashMap results = new HashMap();
			
			CallableStatement call = null;
		
			zatcaResubmissionRecords = (HashMap<String, ArrayList<String>>) session.getAttribute("ZATCARESUBMISSIONRECORDS");
			System.err.println("zatcaResubmissionRecords "+zatcaResubmissionRecords);
			ArrayList<String> zatcaResubmissionRecord=zatcaResubmissionRecords.get("ZATCA");
			
			System.err.println("zatcaResubmissionRecord : : "+zatcaResubmissionRecord);
			int zatcaResubmissionRecordsize=zatcaResubmissionRecord.size();
			System.err.println("zatcaResubmissionRecordsize : : "+zatcaResubmissionRecordsize);

			boolean inserted = true;
			
			for (int i=0;i<zatcaResubmissionRecordsize;i++)				
			{				
				boolean update = false;
										
				StringTokenizer zatcaBillDtlsString = new StringTokenizer(zatcaResubmissionRecord.get(i),"|");
				System.err.println("zatcaBillDtlsString===>>"+zatcaBillDtlsString);
				
				// selectedIndex+"|"+patientID+"|"+encounterID+"|"+billNum+"|"+ZATCA_ERROR_CODE;
				
				String selectedIndex = zatcaBillDtlsString.hasMoreTokens()?zatcaBillDtlsString.nextToken():"";
				if(selectedIndex.equals("") || selectedIndex.equals("null") ) selectedIndex = "N";
				System.err.println("selectedIndex:: "+selectedIndex);				
				
				String doc_type_code = zatcaBillDtlsString.hasMoreTokens()?zatcaBillDtlsString.nextToken():"";
				if(doc_type_code.equals("") || doc_type_code.equals("null")  ) doc_type_code = "";
				System.err.println("doc_type_code:: "+doc_type_code);
				
				String doc_num = zatcaBillDtlsString.hasMoreTokens()?zatcaBillDtlsString.nextToken():"";
				if(doc_num == null || doc_num.equals("null") ) doc_num = "";
				System.err.println("doc_num :: "+doc_num);	

				String oper_fac_id = zatcaBillDtlsString.hasMoreTokens()?zatcaBillDtlsString.nextToken():"";
				if(oper_fac_id == null || oper_fac_id.equals("null") ) oper_fac_id = "";
				System.err.println("oper_fac_id:: "+oper_fac_id);
				
				String ACTIVE_FLAG_YN = zatcaBillDtlsString.hasMoreTokens()?zatcaBillDtlsString.nextToken():"";
				if(ACTIVE_FLAG_YN == null || ACTIVE_FLAG_YN.equals("null") ) ACTIVE_FLAG_YN = "Y";
				System.err.println("ACTIVE_FLAG_YN :: "+ACTIVE_FLAG_YN);				

				if("Y".equals(selectedIndex)){
					try
					{
						call = con.prepareCall("{ call BL_ZATCA_REVALIDATE_BILL(?,?,?,?) }");
				
						call.setString(1, oper_fac_id);
						call.setString(2, doc_type_code);
						call.setString(3, doc_num);
						call.setString(4, ACTIVE_FLAG_YN);
						call.execute();
						
						if(str_error_level == null) str_error_level="";
						if(str_error_text == null) str_error_text="";
						if(str_sys_message_id == null) str_sys_message_id="";						
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("****Inside Error Text Zatca Resubmission:" + str_error_text);
								inserted = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("****Inside Sys Message Zatca Resubmission:"+str_sys_message_id);
								inserted = false;
							}
						}
						else
						{
							System.err.println("****Inside Rec Success Zatca Resubmission");
							inserted = true;
						} 
						
						//call.close();
						
					} catch (Exception e) 
					{
						System.err.println("Exception in Zatca Resubmission=" + e.toString());
						e.printStackTrace();
						inserted = false;
					} 	
				}					
			}
//for end
			System.err.println(" inserted value hdr 907: "+inserted);		
			
			String error_value="0";
			if(inserted)
			{
				error_value = "1" ;		
				con.commit();
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(success_msg,"UTF-8"  )+"&err_value="+error_value );
			}
			else
			{
				con.rollback();
				if(!str_error_level.equals("") && !str_error_text.equals(""))
				{

				}
				else if(!str_sys_message_id.equals(""))
				{

				}

				if(!str_error_text.equals(""))
				{
					System.err.println("str_error_text in msg");
					out.println("<script>parent.parent.frames(0).location.href='../eCommon/jsp/commonToolbar.jsp?"+str_query_string+"';parent.parent.frames(2).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
					System.err.println("syserr in BLZATCAResponseServlet");
				}
			}
		} //main try
		catch (Exception e) 
		{
			System.err.println("exception in BLZATCAResponseServlet=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by BLZATCAResponseServlet ...So Records Not inserted </h3> Foll: Error Received : "
							+ e.toString() + sb.toString());
			out.println("Values sent are : <br>");
			System.err.println("709,exception in BLZATCAResponseServlet" );
			if(con!=null) con.close();
		} 
	}
}