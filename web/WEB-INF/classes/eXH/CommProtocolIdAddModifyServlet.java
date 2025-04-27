/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
/**
 *  Class used to update CommProtocolId setup
 *
 */
public class CommProtocolIdAddModifyServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for CommProtocolId setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */

	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		PrintWriter out;
		out=response.getWriter();
		req=request;
		
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = XHDBAdapter.checkNull(p.getProperty("LOCALE"));

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		
		String p_mode=request.getParameter("act_mode");	
		String protocol_id=XHDBAdapter.checkNull(request.getParameter("protocol_id"));
		String protocol_name=XHDBAdapter.checkNull(request.getParameter("protocol_name"));
		String protocol_type=XHDBAdapter.checkNull(request.getParameter("protocol_type"));
		String protocol_mode=request.getParameter("protocol_mode");	
		String file_dir=XHDBAdapter.checkNull(request.getParameter("file_dir"));
		String file_type=XHDBAdapter.checkNull(request.getParameter("file_type"));
		String ip_address=XHDBAdapter.checkNull(request.getParameter("ip_address"));
		String port_no= "";
		String ack_type=XHDBAdapter.checkNull(request.getParameter("ack_type"));
		String retry_intrvl=XHDBAdapter.checkNull(request.getParameter("retry_intrvl"));
		String max_retries=XHDBAdapter.checkNull(request.getParameter("max_retries"));
		String file_intrvl=XHDBAdapter.checkNull(request.getParameter("file_intrvl"));
		String filenaming_api=XHDBAdapter.checkNull(request.getParameter("filenaming_api"));
		String data_intrvl=XHDBAdapter.checkNull(request.getParameter("data_intrvl"));
		String datainput_api=XHDBAdapter.checkNull(request.getParameter("datainput_api"));
		String statistics_api=XHDBAdapter.checkNull(request.getParameter("statistics_api"));
		String auto_restart_type=XHDBAdapter.checkNull(request.getParameter("auto_restart_type"));
		String auto_restart_time=XHDBAdapter.checkNull(request.getParameter("auto_restart_time"));
		String module_id=XHDBAdapter.checkNull(request.getParameter("module_Id"));
		String db_conn_string=XHDBAdapter.checkNull(request.getParameter("db_conn_string"));
		String db_driver=XHDBAdapter.checkNull(request.getParameter("db_driver"));
		String fax_id=XHDBAdapter.checkNull(request.getParameter("fax_id"));
		String mail_id=XHDBAdapter.checkNull(request.getParameter("mail_id"));
		String solicitedYN = request.getParameter("solicitedYN");
		String oracle_table_qry=XHDBAdapter.checkNull(request.getParameter("oracle_table_qry"));
		String oracle_table_ins_qry=XHDBAdapter.checkNull(request.getParameter("oracle_table_ins_qry"));
		String ack_dir=XHDBAdapter.checkNull(request.getParameter("ack_dir"));
		String stylesht_path=XHDBAdapter.checkNull(request.getParameter("stylesht_path"));
		String sub_module_id=XHDBAdapter.checkNull(request.getParameter("sub_module_Id"));
		String error_dir=XHDBAdapter.checkNull(request.getParameter("error_dir"));
		String odbc_uid=XHDBAdapter.checkNull(request.getParameter("odbc_uid"));
		String odbc_pwd=XHDBAdapter.checkNull(request.getParameter("odbc_pwd"));
		String odbc_sid=XHDBAdapter.checkNull(request.getParameter("odbc_sid"));
		String db_link=XHDBAdapter.checkNull(request.getParameter("dblink_name"));
		String oracle_table_qry2=XHDBAdapter.checkNull(request.getParameter("oracle_table_qry2"));
		String url = XHDBAdapter.checkNull(request.getParameter("url"));
		String userName = XHDBAdapter.checkNull(request.getParameter("userName"));
		String password = XHDBAdapter.checkNull(request.getParameter("password"));

        //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification 
		String httpSoapAction = XHDBAdapter.checkNull(request.getParameter("httpSoapAction"));
		String userAgent = XHDBAdapter.checkNull(request.getParameter("userAgent"));
		String contentType = XHDBAdapter.checkNull(request.getParameter("contentType"));
		String httpTransferEncoding = XHDBAdapter.checkNull(request.getParameter("httpTransferEncoding"));
		String httpContentLength = XHDBAdapter.checkNull(request.getParameter("httpContentLength"));
		String CommProcessIdleTimeStr = XHDBAdapter.checkNull(request.getParameter("hidCommProcessIdleTime"));
		
		//Added By Niveditha on 22/01/2020 for AAKH-CRF-0113
		String mail_uid=XHDBAdapter.checkNull(request.getParameter("mail_uid"));
		String mail_pwd=XHDBAdapter.checkNull(request.getParameter("mail_pwd"));
		String mail_host=XHDBAdapter.checkNull(request.getParameter("mail_host"));
		String mail_port=XHDBAdapter.checkNull(request.getParameter("mail_port"));
		String mail_config=XHDBAdapter.checkNull(request.getParameter("mail_config"));
		String mail_smtp_auth_flag=request.getParameter("mail_smtp_auth_flag");
		String mail_smtp_starttls_flag=request.getParameter("mail_smtp_starttls_flag");
		String mail_attachment_flag=request.getParameter("mail_attachment_flag");

		
		int CommProcessIdleTime = 0;


		if (CommProcessIdleTimeStr.length() > 0)
		{
			CommProcessIdleTime = Integer.parseInt(CommProcessIdleTimeStr);
		}
		
		  //System.out.println("::: CommProcessIdleTime ::: "+CommProcessIdleTime);
		  //System.out.println("::: protocol_type ::: "+protocol_type);

        if(protocol_type.equals("D"))
		{
			oracle_table_qry = oracle_table_qry2;
		}
		else if(protocol_type.equals("W") || protocol_type.equals("H") || protocol_type.equals("SL") || protocol_type.equals("S")  || protocol_type.equals("SO"))
		{
			stylesht_path = url;
			odbc_uid = userName;
			odbc_pwd = password;
		}
		else if(protocol_type.equals("JM") )
		{
			odbc_uid = mail_uid;
			odbc_pwd = mail_pwd;
			//System.out.println("-----------------------------------------------");
			//System.out.println("::: JM mail_uid ::: "+mail_uid);
			//System.out.println("::: JM mail_pwd ::: "+mail_pwd);			
			//System.out.println("::: JM mail_host ::: "+mail_host);
			//System.out.println("::: JM mail_port ::: "+mail_port);			
			//System.out.println("::: JM mail_config ::: "+mail_config);
			//System.out.println("::: JM mail_smtp_auth_flag ::: "+mail_smtp_auth_flag);
			//System.out.println("::: JM mail_smtp_starttls_flag ::: "+mail_smtp_starttls_flag);
			//System.out.println("::: JM mail_attachment_flag ::: "+mail_attachment_flag);
			//System.out.println("-----------------------------------------------");
		}

        if(protocol_mode.equals("I")){
			    port_no = request.getParameter("port_noI");	
                if(p_mode.equals("I"))
			{
                 ip_address="000.00.000.000";
			}
				datainput_api	=	"XHBUILDER.PROCESS_QUERY_MESSAGE";
				statistics_api		=	"XHCORE.UPDATE_INBOUND_QUERY_MSG_INFO";
		}
	    if(protocol_mode.equals("O")){
			    port_no = request.getParameter("port_noO");	
				datainput_api	=	"XHCORE.GET_APPLICATION_MESSAGE";
				statistics_api		=	"XHCORE.UPDATE_APPL_MESSAGE_INFO";
		}

//		String lang_id=XHDBAdapter.checkNull(request.getParameter("lang_id"));
		
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		
		arrColumn=new ArrayList();

		arrColumn.add(p_mode);
		arrColumn.add(protocol_id);
		arrColumn.add(protocol_name);
		arrColumn.add(protocol_type);
		arrColumn.add(protocol_mode);		
		arrColumn.add(file_dir);
		arrColumn.add(file_type);
		arrColumn.add(ip_address);
		arrColumn.add(port_no);
		arrColumn.add(ack_type);
		arrColumn.add(retry_intrvl);
		arrColumn.add(max_retries);
		arrColumn.add(file_intrvl);
		arrColumn.add(filenaming_api);
		arrColumn.add(data_intrvl);
		arrColumn.add(datainput_api);
		arrColumn.add(statistics_api);
		arrColumn.add(auto_restart_type);
		arrColumn.add(auto_restart_time);
		arrColumn.add(module_id);
		arrColumn.add(db_conn_string);
		arrColumn.add(db_driver);
		arrColumn.add(fax_id);
		arrColumn.add(mail_id); 
		if(solicitedYN != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}
//		arrColumn.add(lang_id);
		   
  		arrColumn.add(oracle_table_qry);
		arrColumn.add(oracle_table_ins_qry);
		arrColumn.add(ack_dir);
		arrColumn.add(stylesht_path);
		arrColumn.add(sub_module_id);
		arrColumn.add(error_dir);
		arrColumn.add(odbc_uid);
		arrColumn.add(odbc_pwd);
		arrColumn.add(odbc_sid);
		arrColumn.add(db_link);

		arrColumn.add(httpSoapAction);
		arrColumn.add(userAgent);
		arrColumn.add(contentType);
		arrColumn.add(httpTransferEncoding);
		arrColumn.add(httpContentLength);
		arrColumn.add(CommProcessIdleTime);
		
		// Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 
		arrColumn.add(mail_host);
		arrColumn.add(mail_port);
		arrColumn.add(mail_config);
		
		// Added By Niveditha on 12/02/2020 for AAKH-CRF-0113 
		if(mail_smtp_auth_flag != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}
		
		// Added By Niveditha on 12/02/2020 for AAKH-CRF-0113 
		if(mail_smtp_starttls_flag != null){
			arrColumn.add("Y");
		}
		else{
			arrColumn.add("N");
		}
		
		if(mail_attachment_flag != null){
			arrColumn.add("Y");
			//System.out.println("is Y-----"+mail_attachment_flag);
		}
		else{
			arrColumn.add("N");
			//System.out.println("is N-----"+mail_attachment_flag);
		}

		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrColumn);
		details_hm.put("gen_details",array_audit);
		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale );	
		
		
		
        RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        reqDis.forward(request,response);	
        
        arrColumn.clear();
        array_audit.clear();
        details_hm.clear();
        result_hm.clear();

	}// end of do post

 /**
	 * callEJB method is used to call CommProtocolId setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale )
   {
	Connection connection = null;
	CallableStatement ostmt = null;
	PreparedStatement pstmt	= null;
	ResultSet rs   = null;
	String message_text2 = "";
	String status="";
	String exceptions="";
	HashMap result_hm=new HashMap();
	MessageManager mm=new MessageManager();
		
	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");

	int commFlag = 0;
	  
    try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of CommProtocolIdAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
      }
 
	
	try
	{

    //changed by prithivi for ML-MMOH-CRF.-0491 on 20/07/2016 -eNotification
	 ostmt = connection.prepareCall("{ call Xg_prc.xh_protocol(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  p_mode=(String)row_arr.get(0);
   	      String  protocol_id=(String)row_arr.get(1);
		  String  protocol_name=(String)row_arr.get(2);
		  String  protocol_type=(String)row_arr.get(3);
		  String  protocol_mode=(String)row_arr.get(4);
		  String  file_dir=(String)row_arr.get(5);
		  String  file_type=(String)row_arr.get(6);
   	      String  ip_address=(String)row_arr.get(7);
		  String  port_no=(String)row_arr.get(8);
		  String  ack_type=(String)row_arr.get(9);
   	      String  retry_intrvl=(String)row_arr.get(10);
		  String  max_retries=(String)row_arr.get(11);
          String  file_intrvl=(String)row_arr.get(12);
   	      String  filenaming_api=(String)row_arr.get(13);
		  String  data_intrvl=(String)row_arr.get(14);
          String  datainput_api=(String)row_arr.get(15);
	      String  statistics_api=(String)row_arr.get(16);
  	      String  auto_restart_type=(String)row_arr.get(17);
   	      String  auto_restart_time=(String)row_arr.get(18);
          String  module_id=(String)row_arr.get(19);
	      String  db_conn_string=(String)row_arr.get(20);
   	      String  db_driver=(String)row_arr.get(21);
		  String  fax_id=(String)row_arr.get(22);
          String  mail_id=(String)row_arr.get(23); 
		  String  solicitedYN = (String)row_arr.get(24);
   	      String  oracle_table_qry=(String)row_arr.get(25);
		  String  oracle_table_ins_qry = (String)row_arr.get(26);
	      String  ack_dir=(String)row_arr.get(27); 
  	      String  stylesht_path=(String)row_arr.get(28); 
		  String  sub_module_id=(String)row_arr.get(29); 
		  String  error_dir=(String)row_arr.get(30); 
          String  odbc_uid=(String)row_arr.get(31); 
		  String  odbc_pwd=(String)row_arr.get(32); 
		  String  odbc_sid=(String)row_arr.get(33); 
		  String  db_link=(String)row_arr.get(34); 
		  
		  // Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 
		  /*
		  String  mail_host=(String)row_arr.get(41); 
		  System.out.println("mail_host"+(String)row_arr.get(41));
		  String  mail_port=(String)row_arr.get(42); 
		  System.out.println("mail_port"+(String)row_arr.get(42));
		  String  mail_config=(String)row_arr.get(43); 
		  System.out.println("mail_config"+(String)row_arr.get(43));
		  String  mail_smtp_auth_flag=(String)row_arr.get(44); 
		  System.out.println("mail_smtp_auth_flag"+(String)row_arr.get(44));
		  String  mail_smtp_starttls_flag=(String)row_arr.get(45); 
		  System.out.println("mail_smtp_starttls_flag"+(String)row_arr.get(45));
		 
		  String  mail_attachment_flag=(String)row_arr.get(46); 
		  System.out.println("mail_attachment_flag"+(String)row_arr.get(46));
		  */

				
				
				
			//          String  lang_id=(String)row_arr.get(23);
   
		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,p_mode);
			 //System.out.println("Call EJB p_mode : "+p_mode);
		 ostmt.setString(2,protocol_id);
 	 		 //System.out.println("Call EJB protocol_id : "+protocol_id);
	     ostmt.setString(3,protocol_name);
		 //System.out.println("Call EJB protocol_name : "+protocol_name);
		 ostmt.setString(4,protocol_type);
 	 		 //System.out.println("Call EJB protocol_type : "+protocol_type);
		 ostmt.setString(5,protocol_mode);
  	 		 //System.out.println("Call EJB protocol_mode : "+protocol_mode);
		 ostmt.setString(6,file_dir);
			//System.out.println("Call EJB file_dir : "+file_dir);
		 ostmt.setString(7,file_type);
   	 		 //System.out.println("Call EJB file_type : "+file_type);
		 ostmt.setString(8,ip_address);
			//System.out.println("Call EJB ip_address : "+ip_address);
	     ostmt.setString(9,port_no);
	   		//System.out.println("Call EJB port_no : "+port_no);
		 ostmt.setString(10,ack_type);
	   	 	//System.out.println("Call EJB ack_type : "+ack_type);
		 ostmt.setString(11,retry_intrvl);
	 		//System.out.println("Call EJB retry_intrvl : "+retry_intrvl);
		 ostmt.setString(12,max_retries);
			//System.out.println("Call EJB protocol_mode : "+max_retries);
		 ostmt.setString(13,file_intrvl);
			//System.out.println("Call EJB protocol_mode : "+file_intrvl);
		 ostmt.setString(14,filenaming_api);
	 		//System.out.println("Call EJB filenaming_api : "+filenaming_api);
		 ostmt.setString(15,data_intrvl);
			//System.out.println("Call EJB data_intrvl : "+data_intrvl);
		 ostmt.setString(16,datainput_api);
   	 		//System.out.println("Call EJB datainput_api : "+datainput_api);
		 ostmt.setString(17,statistics_api);
			//System.out.println("Call EJB statistics_api : "+statistics_api);
		 ostmt.setString(18,auto_restart_type);
			//System.out.println("Call EJB auto_restart_type : "+auto_restart_type);
	 	 ostmt.setString(19,auto_restart_time);
   	 		 //System.out.println("Call EJB auto_restart_time : "+auto_restart_time);
		 ostmt.setString(20,module_id);
			//System.out.println("Call EJB module_id : "+module_id);
	     ostmt.setString(21,db_conn_string);
		 	 //System.out.println("Call EJB db_conn_string : "+db_conn_string);
		 ostmt.setString(22,db_driver);
		 	 //System.out.println("Call EJB db_driver : "+db_driver);
		 ostmt.setString(23,fax_id);
		 	 //System.out.println("Call EJB fax_id : "+fax_id);
		 ostmt.setString(24,mail_id);
		 	 //System.out.println("Call EJB mail_id : "+mail_id);

		//		 ostmt.setString(23,lang_id);
		 		 		  
		 ostmt.setString(25,usr_added_by_id);
			//System.out.println("Call EJB usr_added_by_id : "+usr_added_by_id);
		 ostmt.setString(26,usr_added_at_ws_no);
			//System.out.println("Call EJB usr_added_at_ws_no : "+usr_added_at_ws_no);
	 
	     ostmt.registerOutParameter(27,java.sql.Types.VARCHAR);
	     ostmt.registerOutParameter(28,java.sql.Types.VARCHAR);

		 ostmt.setString(29,solicitedYN);
		 //System.out.println("Call EJB solicitedYN : "+solicitedYN);
	 	 ostmt.setString(30,oracle_table_qry);
		 //System.out.println("Call EJB oracle_table_qry : "+oracle_table_qry);
		 ostmt.setString(31,oracle_table_ins_qry);
		 //System.out.println("Call EJB oracle_insqry : "+oracle_table_ins_qry);	
		 ostmt.setString(32,ack_dir);
		 //System.out.println("Call EJB ack_dir : "+ack_dir);	
 		 ostmt.setString(33,stylesht_path);
	 		 //System.out.println("Call EJB stylesht_path : "+stylesht_path);	
	 	 ostmt.setString(34,sub_module_id);
	 		 //System.out.println("Call EJB sub_module_id : "+sub_module_id);	
		 ostmt.setString(35,error_dir);
			//System.out.println("Call EJB error_dir : "+error_dir);		  
 		 ostmt.setString(36,odbc_uid);
			//System.out.println("Call EJB odbc_uid : "+odbc_uid);	
	 	 ostmt.setString(37,odbc_pwd);
		 	//System.out.println("Call EJB odbc_pwd : "+odbc_pwd);	
		 ostmt.setString(38,odbc_sid);
		 	//System.out.println("Call EJB odbc_sid : "+odbc_sid);		  
		 ostmt.setString(39,db_link);
		 	//System.out.println("Call EJB db_link : "+db_link);	
          //ostmt.setClob(40,null);
		  //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification Generic Changes for all interface aplications.
          ostmt.setString(40,(String)row_arr.get(35)); // soap action
		  //System.out.println("Call EJB soap action : "+(String)row_arr.get(35));
		  ostmt.setString(41,(String)row_arr.get(36)); //user agent
		  //System.out.println("Call EJB user agent : "+(String)row_arr.get(36));
		  ostmt.setString(42,(String)row_arr.get(37)); // content type
		  //System.out.println("Call EJB content type) : "+(String)row_arr.get(37));
		  ostmt.setString(43,(String)row_arr.get(38)); // http transfer encoding
		  //System.out.println("Call EJB  http transfer encoding : "+(String)row_arr.get(38));
		  ostmt.setString(44,(String)row_arr.get(39)); // http content length
		  //System.out.println("Call EJB http content length : "+(String)row_arr.get(39));
		  //Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 --->
		  ostmt.setString(45,(String)row_arr.get(41)); // host mail
//System.out.println(" --- HOSTMAIL "+(String)row_arr.get(41));
		  ostmt.setString(46,(String)row_arr.get(42)); // host port
//System.out.println(" --- HOSTPORT "+(String)row_arr.get(42));
		  ostmt.setString(47,(String)row_arr.get(43)); // host config
//System.out.println(" --- HOSTCONFIG "+(String)row_arr.get(43));
		  ostmt.setString(48,(String)row_arr.get(44)); // mail smtp auth flag
//System.out.println(" --- MAILSMTPAUTHFLAG "+(String)row_arr.get(44));
		  ostmt.setString(49,(String)row_arr.get(45)); // mail smtp starttls flag
//System.out.println(" --- MAILSMTPSTARTTLSFLAG "+(String)row_arr.get(45));

		  ostmt.setString(50,(String)row_arr.get(46)); // mail attachment flag
//System.out.println(" --- MAILATTACHMENTFLAG "+(String)row_arr.get(46));

			 //System.out.println("**************DONE**************");
			 
			 
  		  int  CommProcessIdleTime = (Integer)row_arr.get(40); 

		  int recordUpdated = 1;

		  	 	 	 
		//System.out.println("Xg_prc.xh_protocol('"+p_mode+"', '"+protocol_id+"', ' "+protocol_name+"', '"+protocol_type+"', '"+protocol_mode+"', '"+file_dir+"', '"+file_type+"', '"+ip_address+"', '"+port_no+"', '"+ack_type+"', '"+retry_intrvl+"', '"+max_retries+"', '"+file_intrvl+"', '"+filenaming_api+"', '"+data_intrvl+"', '"+datainput_api+"', '"+statistics_api+"', '"+auto_restart_type+"', '"+auto_restart_time+"', '"+module_id+"', '"+db_conn_string+"', '"+db_driver+"', '"+db_driver+"', '"+fax_id+"', '"+mail_id+"', '"+usr_added_by_id+"', '"+usr_added_at_ws_no+"', '"+solicitedYN+"', '"+oracle_table_qry+"', '"+oracle_table_ins_qry+"', '"+ack_dir+"', '"+stylesht_path+"', '"+sub_module_id+"', '"+error_dir+"', '"+odbc_uid+"', '"+odbc_pwd+"', '"+odbc_sid+"', '"+db_link+"', '"+(String)row_arr.get(35)+"', '"+(String)row_arr.get(36)+"', '"+(String)row_arr.get(37)+"', '"+(String)row_arr.get(38)+"', '"+(String)row_arr.get(39)+"', '"+(String)row_arr.get(41)+"', '"+(String)row_arr.get(42)+"', '"+(String)row_arr.get(43)+"', '"+(String)row_arr.get(44)+"', '"+(String)row_arr.get(45)+"', '"+(String)row_arr.get(46)+"')");


	     ostmt.execute();
	
	     String status2= ostmt.getString(27);
         //System.out.println("CommProtocolIdAddModifyServlet.java Call EJB status2 : "+status2);
		
	     message_text2 = ostmt.getString(28);

		 //System.out.println("CommProtocolIdAddModifyServlet.java Call EJB message_text2 : "+message_text2);
		 //System.out.println("Susccesfully Inserted");

	     ostmt.close();

		 String queryCommApplication = "Select COMM_PROCESS_IDLE_TIME from     XH_PROTOCOL a,    XH_PROTOCOL_LINK b,    XH_INTERACTIVE_CONNECT_PARAM c "
											+ " where  a.PROTOCOL_ID = b.PROTOCOL_ID and b.APPLICATION_ID = c.PLUGIN_TYPE and a.PROTOCOL_ID = ?";
		pstmt = connection.prepareStatement(queryCommApplication);
		
		pstmt.setString(1, protocol_id);
		rs	 =	pstmt.executeQuery();	

		while(rs.next())
		{
			commFlag = 1;
		}
		
		//System.out.println("**************commFlag************** "+commFlag);

		if (commFlag > 0)
		{
			String updateCommApplication = "Update XH_INTERACTIVE_CONNECT_PARAM set COMM_PROCESS_IDLE_TIME = ? where PLUGIN_TYPE in (Select c.PLUGIN_TYPE from     XH_PROTOCOL a,    XH_PROTOCOL_LINK b,    XH_INTERACTIVE_CONNECT_PARAM c "
											+ " where  a.PROTOCOL_ID = b.PROTOCOL_ID and b.APPLICATION_ID = c.PLUGIN_TYPE and a.PROTOCOL_ID = ?)";
			pstmt = connection.prepareStatement(updateCommApplication);
			if (CommProcessIdleTime > 0)	
				pstmt.setInt(1, CommProcessIdleTime);
			else
				pstmt.setNull(1, java.sql.Types.INTEGER);

			pstmt.setString(2, protocol_id);
			recordUpdated	 =	pstmt.executeUpdate();
		}

		//System.out.println("**************recordUpdated : "+recordUpdated);

	    
		if(status2.equals("0") && recordUpdated == 1)
		{
			//System.out.println("************** Inside COmmit 1 ************");
                connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			    status = ((String) mesg.get("message"));
			    mesg.clear();
		}
		else if(status2.equals("2")  && recordUpdated == 1)
		{
			//System.out.println("************** Inside COmmit 2 ************");
			    connection.commit();
			final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
			//	final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			    status = ((String) mesg.get("message"));	
			    mesg.clear();
		}
        else 
		{
			//System.out.println("************** Inside ROllback ************");
                connection.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			//	final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
				status = ((String) mesg.get("message"));	
				mesg.clear();
		}
	
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of CommProtocolIdAddModifyServlet  :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);
	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of CommProtocolIdAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); }
	finally{
		XHUtil.closeDBResources(null, pstmt, null);
		row_arr.clear();
		gen_arr.clear();
	}
//	 System.out.println("status "+status);   
//	 System.out.println("message_text2 "+message_text2);   
	    
//	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);

	return result_hm;  
}// end of callEJB function

}// end of class