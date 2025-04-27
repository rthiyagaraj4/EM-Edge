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
String Application_Specific_txt="";
Properties p;		
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
 Connection connection = null;
	    CallableStatement  oraclecallablestatement = null;
		MessageManager mm=new MessageManager();
	    String p_mode=request.getParameter("act_mode");	
		String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
		String ProfileId=XHDBAdapter.checkNull(request.getParameter("profile_id"));
		String Short_desc=XHDBAdapter.checkNull(request.getParameter("short_desc"));
		String Long_desc=request.getParameter("Long_desc");	
		String version_spcific=XHDBAdapter.checkNull(request.getParameter("Version_Specific"));
		String Geography_specific=XHDBAdapter.checkNull(request.getParameter("Geography_Specific"));
		String Site_Specific=XHDBAdapter.checkNull(request.getParameter("Site_Specific"));
		String Application_specific=XHDBAdapter.checkNull(request.getParameter("Application_Specific"));
		String Version_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Version_Specific_txt"));	
        String Geography_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Geography_Specific_txt"));

		
		 Application_Specific_txt=XHDBAdapter.checkNull(request.getParameter("application_id1"));
				
        String Site_Specific_txt=XHDBAdapter.checkNull(request.getParameter("Site_Specific_txt"));



		ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
        
try
	{
	out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
     out.println("<body class='MESSAGE'>"); 
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of Interfacesatndaredqueryrecord.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

	  try
		{
		  //System.out.println(p_mode+"ProfileId"+ProfileId+"Short_desc"+Short_desc+"LONG"+Long_desc+"S_code"+standard_code+"Specific_txt_v"+version_spcific+"TXT"+Version_Specific_txt+"Specific_txt1_g"+Geography_specific+"TXT"+Geography_Specific_txt+"Specific_txt_A"+Application_specific+"TXT"+Application_Specific_txt+"Site_Specific_txt"+Site_Specific+"TXT"+Site_Specific_txt+""+usr_added_by_id+""+usr_added_at_ws_no);
        oraclecallablestatement = connection.prepareCall("{ call Xg_prc.xh_standard_profile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
        //System.out.println("p_mode"+p_mode);
		
		oraclecallablestatement.setString(1,p_mode);

   //System.out.println("ProfileId"+ProfileId);
		oraclecallablestatement.setString(2,ProfileId);
 //System.out.println("Short_desc"+Short_desc);
		oraclecallablestatement.setString(3,Short_desc);

		//System.out.println("LONG"+Long_desc);
	    oraclecallablestatement.setString(4,Long_desc);
//System.out.println("standard_code"+standard_code);
        oraclecallablestatement.setString(5,standard_code);
//System.out.println("version_spcific"+version_spcific);
        oraclecallablestatement.setString(6,version_spcific);
//System.out.println("Version_Specific_txt"+Version_Specific_txt);
	    oraclecallablestatement.setString(7,Version_Specific_txt);
//System.out.println("Geography_specific"+Geography_specific);
		oraclecallablestatement.setString(8,Geography_specific);
////System.out.println("Geography_Specific_txt"+Geography_Specific_txt);
		oraclecallablestatement.setString(9,Geography_Specific_txt);
		//System.out.println("Application_specific"+Application_specific);
        oraclecallablestatement.setString(10,Application_specific);
		//System.out.println("Application_Specific_txt"+Application_Specific_txt);
        oraclecallablestatement.setString(11,Application_Specific_txt);
		//System.out.println("Site_Specific"+Site_Specific);
		oraclecallablestatement.setString(12,Site_Specific);
		//System.out.println("Site_Specific_txt"+Site_Specific_txt);
	    oraclecallablestatement.setString(13,Site_Specific_txt);
	
        oraclecallablestatement.setString(14,usr_added_by_id);	
		
        oraclecallablestatement.setString(15,usr_added_at_ws_no);	
	
	    oraclecallablestatement.registerOutParameter(16,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(17,java.sql.Types.VARCHAR);
	    oraclecallablestatement.execute();
        String status2 = oraclecallablestatement.getString(16);
		String status="";
        //System.out.println("Status2"+status2);

	if(oraclecallablestatement!=null) oraclecallablestatement.close();
	  
	   	if(status2.equals("0"))
		{
			connection.commit();

			out.println("<script>parent.frames[1].document.forms[0].Refresh.disabled=false;</script>");
			if(p_mode.equals("D"))
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
				status = ((String) mesg.get("message"));

			}
			else
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				status = ((String) mesg.get("message"));
			}
		}
		else if(status2.equals("2"))
		{
		 	connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
			status = ((String) mesg.get("message"));
			
		}
	    else
		{
		 	connection.rollback();
		 	final java.util.Hashtable mesg = mm.getMessage(locale, "XH1042", "XH") ;
 		 	status = ((String) mesg.get("message"));
		 	out.println("<script>parent.frames[1].document.forms[0].Refresh.disabled=true;</script>");

		}
       	out.println("");
       	out.println(status);
       	out.println("");

       	out.println("</body>");  

		out.println("<script> </script>");
	}
	catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in Interfacesatndaredqueryrecord.jsp  :"+ex.toString());
		//exceptions=exceptions+"3"+"*"+ex.toString();
		//ex.printStackTrace(System.err);

	}
	try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ 
		System.out.println("Error in closing dbrealted statements in Interfacesatndaredqueryrecord.jsp :"+ex.toString());
		ex.printStackTrace(System.err); 
	}
	 //System.out.println("status "+status2);  
	 

//RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
       // reqDis.forward(request,response);
		
		

	/*	arrColumn.add(p_mode);
		arrColumn.add(standard_code);
		arrColumn.add(standard_desc);
		arrColumn.add(standard_type);
		arrColumn.add(msg_start);		
		arrColumn.add(msg_end);
		arrColumn.add(seg_start);
		arrColumn.add(seg_end);
		arrColumn.add(fld_separator);
		arrColumn.add(elmnt_separator);
  //	arrColumn.add(lang_id);*/
		   
				
        //RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
        //reqDis.forward(request,response);		


	
%>

</form>
	  </body>
	  </html>

