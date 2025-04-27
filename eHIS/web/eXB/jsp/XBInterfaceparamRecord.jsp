<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <html> 
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,eXH.XHDBAdapter,java.sql.Clob;" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 
<% 

MessageManager mm=new MessageManager();
Properties p;
p = (Properties) session.getValue("jdbc");	
String locale  = p.getProperty("LOCALE");
String msg="";
// Statement s=null;
 // ResultSet r = null;
Connection connection = null;
CallableStatement ostmt = null;
String message_text = "",status="";
String Filter_group="";

	p = (Properties) session.getValue("jdbc");	
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method  of XBInterfaceparamRecord.jsp.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
        // exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {

        String  mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
        String enable_interface=XHDBAdapter.checkNull(request.getParameter("enable_interface")).equals("")?"N":request.getParameter("enable_interface");
		String profile_id=request.getParameter("Profile_id");
		String dbf_table_name=request.getParameter("dbf_table_name"); 
		String dbf_source_directory=request.getParameter("dbf_source_directory"); 
		String dbf_dest_directory=request.getParameter("dbf_dest_directory");
		String log_directory=request.getParameter("log_directory");
        String dbf_table_create_stmt=request.getParameter("dbf_table_create_stmt"); 
		String dbf_column_hdng=request.getParameter("dbf_column_hdng");
        String dbf_trace_yn=XHDBAdapter.checkNull(request.getParameter("dbf_trace_yn")).equals("")?"N":request.getParameter("dbf_trace_yn");
		String exe_name=request.getParameter("exe_name");
		String drg_query=request.getParameter("drg_query");
		String dbf_column_dt=request.getParameter("dbf_column_dt");
        String sdx_diag_cnt=request.getParameter("sdx_diag_cnt"); 
		String proc_diag_cnt=request.getParameter("proc_diag_cnt");
		String user_def_str=request.getParameter("user_def_str");
        String cc_trace_yn=XHDBAdapter.checkNull(request.getParameter("cc_trace_yn")).equals("")?"N":request.getParameter("cc_trace_yn");
 	    ArrayList arrAudit = ArrayAuditInfo.getArrayAuditInfo(session);
  	    String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1); 
		String usr_added_by_date=(String)arrAudit.get(2);
		//String drgreplace=drg_query.replaceAll("'","''");			
		/*System.out.println("Xg_prc.XB_PARAM('"+mode+"'"+","+"'"+profile_id+"'"+","+"'"+enable_interface+"'"+","+"'"+dbf_table_name+"'"+","+"'"+dbf_source_directory+"'"+","+"'"+dbf_dest_directory+"'"+","+"'"+exe_name+"'"+","+"'"+dbf_table_create_stmt+"'"+","+"'"+dbf_column_hdng+"'"+","+"'"+dbf_column_dt+"'"+","+"'"+dbf_trace_yn+"'"+","+"'"+drgreplace+"'"+","+""+","+""+","+""+","+""+","+""+","+"'"+usr_added_by_id+"'"+","+"'"+usr_added_by_date+"'"+","+"'"+usr_added_by_id+"'"+","+"'"+usr_added_by_date+"'"+","+"'"+usr_added_at_ws_no+"'"+","+"'"+usr_added_at_ws_no+"'"+","+"'"+cc_trace_yn+"'"+","+"'"+log_directory+"')");*/

        ostmt = connection.prepareCall("{ CALL Xg_prc.XB_PARAM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
  
		ostmt.setString(1,mode);
		ostmt.setString(2,profile_id);
		ostmt.setString(3,enable_interface);
		ostmt.setString(4,dbf_table_name);
		ostmt.setString(5,dbf_source_directory);
		ostmt.setString(6,dbf_dest_directory);
		ostmt.setString(7,exe_name); 
		ostmt.setString(8,dbf_table_create_stmt);  
		ostmt.setString(9,dbf_column_hdng);
		ostmt.setString(10,dbf_column_dt);
		ostmt.setString(11,dbf_trace_yn);
		java.io.Reader reader = new java.io.StringReader(drg_query);
		ostmt.setCharacterStream(12,reader,drg_query.length());
		ostmt.setString(13,null);
		ostmt.setString(14,null);
		ostmt.setString(15,null);
		ostmt.setString(16,null);
		ostmt.setString(17,usr_added_by_id); 
		ostmt.setString(18,usr_added_by_date);
		ostmt.setString(19,usr_added_by_id);
		ostmt.setString(20,usr_added_by_date);
		ostmt.setString(21,usr_added_at_ws_no); 
		ostmt.setString(22,usr_added_at_ws_no); 
		ostmt.setString(23,cc_trace_yn);
		ostmt.setString(24,log_directory);
		ostmt.setString(25,sdx_diag_cnt);
		ostmt.setString(26,proc_diag_cnt);
		ostmt.setString(27,user_def_str);
		ostmt.registerOutParameter(28,java.sql.Types.VARCHAR);
		ostmt.registerOutParameter(29,java.sql.Types.VARCHAR);
		ostmt.execute();
		status = ostmt.getString(28); 
		message_text = ostmt.getString(29);		  	  
				 
        out.println("<html><head></head><body bgcolor=#B2B6D7 >"); 
//        System.out.println("status 126:"+status);
		
        out.println("</body></html>");     
	 
		if (status.equals("0"))  
        {
          connection.commit(); 
          final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001","XH") ;
          msg= ((String) mesg.get("message"));
		  out.println(msg);
          
		
		}
		else if (status.equals("2"))  
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message")); 
          final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024","XH") ;
			    status = ((String) mesg.get("message"));
		  out.println(status);        
		
		}
		else
        {      
			connection.rollback();
			// chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000","XH") ;
		    msg = ((String) mesg.get("message"));
			out.println(msg);	   	   
        }	
      }
      catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in Xg_prc.XB_PARAM of  XBInterfaceparamRecord.jsp:"+e.toString());
	      e.printStackTrace(System.err);
	  }

	  finally
	  {
		try{
			if(ostmt!=null)
			{
			  ostmt.close();
			 }
			ConnectionManager.returnConnection(connection);
		}catch(Exception e)
		{
			System.out.println("Error in closing dbconnection in XBInterfaceparamRecord.jsp.jsp :"+e.toString());
			e.printStackTrace(System.err);
		}
	  }
	  %>
<input type=hidden name=filter_code value='<%=Filter_group%>'>

<script>
</script>

</form>
</body>
</html>

