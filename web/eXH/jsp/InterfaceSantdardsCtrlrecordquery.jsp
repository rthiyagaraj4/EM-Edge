<!DOCTYPE html>
<html> 
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
<body BGCOLOR="#B2B6D7"  CLASS="MESSAGE" >
<form > 


<%

	String status="";
		Connection connection = null;
    	CallableStatement ostmt = null;
	    String message_text2 = "";
	   	MessageManager mm=new MessageManager();
	    String exceptions="";
	  
		
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
		 String locale  = p.getProperty("LOCALE");
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
		String p_mode=request.getParameter("act_mode");	
		String segment_type_id=XHDBAdapter.checkNull(request.getParameter("segment_type_id"));
		String standard_desc=XHDBAdapter.checkNull(request.getParameter("element_seq"));

		if(standard_desc.equals("")||standard_desc.equals(null))
		{
standard_desc="1";
		}
		

		String ele_val_id=XHDBAdapter.checkNull(request.getParameter("ele_val_id"));
		String standard_code1=XHDBAdapter.checkNull(request.getParameter("standard_code"));
		String Control_id=XHDBAdapter.checkNull(request.getParameter("element_controlID"));
//System.out.println("standard_code1"+standard_code1);
		//System.out.println("Control_id"+Control_id);
		String msg_start=request.getParameter("def_val_id");	
    	ArrayList array_audit=null;
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);		
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of InterfaceStandardAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
 
	
	try
	{

	 ostmt = connection.prepareCall("{ call xg_prc.xh_standard_control_seg(?,?,?,?,?,?,?,?,?,?,?) }" ); 
  
		  String  usr_added_by_id=(String)array_audit.get(0);
		  String  usr_added_at_ws_no=(String)array_audit.get(1);
		 
		 
		 ostmt.setString(1,p_mode);

	   //System.out.println("Call EJB p_mode : "+p_mode);

         ostmt.setString(2,segment_type_id);
		 	   //System.out.println("Call standard_code : "+segment_type_id);
		 ostmt.setString(3,ele_val_id);
	   //System.out.println("Call standard_type : "+ele_val_id);
         ostmt.setInt(4,Integer.parseInt(standard_desc));
	   ////System.out.println("Call standard_desc : "+standard_desc);
         ostmt.setString(5,msg_start);
		 	   //System.out.println("Call msg_start : "+msg_start);
         ostmt.setString(6,usr_added_by_id);
         ostmt.setString(7,usr_added_at_ws_no);
        ostmt.setString(8,standard_code1);
		ostmt.setString(9,Control_id);
        ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
	    ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

       ostmt.execute();
	   String status2= ostmt.getString(10);
			 //System.out.println("Call EJB status2 : "+status2);
	     message_text2 = ostmt.getString(11);

	     ostmt.close();
	    
//	     if(message_text2.equals("0"))
	     if(status2.equals("0"))
		{
		connection.commit();
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
       // RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
        //reqDis.forward(request,response);	

		}
		else if(status2.equals("2"))
		{
		
final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "common") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
       // RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
        //reqDis.forward(request,response);	

		}
	 else
		{
		 connection.rollback();


		 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	  		    status = ((String) mesg.get("message"));
				out.println(status);
		  //RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+status);
      //  reqDis.forward(request,response);	
		}
	 XHDBAdapter.closeCursor(ostmt);
	
	}catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceSantdardsCtrlrecordquery :"+ex.toString());
		exceptions=exceptions+"3"+"*"+ex.toString();
		ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in  InterfaceSantdardsCtrlrecordquery.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }
%>
</form>
	  </body>
	  </html>

