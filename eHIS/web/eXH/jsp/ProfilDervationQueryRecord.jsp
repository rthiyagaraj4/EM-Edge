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
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence1.js" ></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 


<%

   Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
    
    String exceptions="";
    String mode="";
	String applicationid="";
	 String elementid="";
	 String derivation_type="";
	   String cond_exprsn="";
	   String expected_value="";
	    String execution_order="";
		  String expected_value2="";
		  String position_value="";
   
	MessageManager mm=new MessageManager();
		//req=request;
		 Properties p;
	
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
  
    try
    { 
		out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
     out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
     out.println("<body class='MESSAGE'>"); 
		 mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
			//System.out.println("mode : "+mode);
	  
	  applicationid=XHDBAdapter.checkNull(request.getParameter("application_id"));
	        //System.out.println("applicationid : "+applicationid);
     
       elementid=XHDBAdapter.checkNull(request.getParameter("element_id"));
	        //System.out.println("elementid : "+elementid);
	
      derivation_type=XHDBAdapter.checkNull(request.getParameter("derivation_type"));
	        //System.out.println("derivation_type : "+derivation_type);

       cond_exprsn=XHDBAdapter.checkNull(request.getParameter("cond_exprsn"));
	        //System.out.println("cond_exprsn : "+cond_exprsn);
		     
       expected_value=XHDBAdapter.checkNull(request.getParameter("expected_value"));
	  //System.out.println("expected_value : "+expected_value);
	
       execution_order=XHDBAdapter.checkNull(request.getParameter("execution_order"));
	  //System.out.println("execution_order : "+execution_order);

       expected_value2=XHDBAdapter.checkNull(request.getParameter("expected_value2"));
	  //System.out.println("expected_value : "+expected_value2);
	
	   position_value=XHDBAdapter.checkNull(request.getParameter("Position_value"));
	  //System.out.println("Position_value : "+position_value);
 
     // System.out.println("arrFilterInfo : "+arrFilterInfo);
//	  request.getParameter("jspmode");
     // arrAudit = AuditInfo.getArrayAuditInfo(session);
	  // System.out.println("arrAudit : "+arrAudit);
    }
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {
      ostmt = connection.prepareCall("{ CALL xg_prc.xh_profile_derivation_rules(?,?,?,?,?,?,?,?,?,?,?) }" ); 
		//System.out.println("prepareCall xg_prc.xh_profile_derivation_rules");
/*
      arrFilterInfo.add(mode);
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("rowid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("applicationid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("elementid")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("derivation_type")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("cond_exprsn")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("expected_value")));
      arrFilterInfo.add(XHDBAdapter.checkNull(request.getParameter("execution_order")));
*/
    	
		 //System.out.println("values"+mode+"applicationid,"+applicationid+"elementid,"+elementid+"derivation_type,"+derivation_type+"cond_exprsn,"+cond_exprsn+"expected_value,"+expected_value+"execution_order,"+execution_order+"position,"+position_value);
		  ostmt.setString(1,mode);
		  ostmt.setString(2,execution_order);
		  ostmt.setString(3,applicationid);
		  ostmt.setString(4,elementid);
		  ostmt.setString(5,derivation_type);
		  ostmt.setString(6,cond_exprsn);
		  ostmt.setString(7,expected_value);
		      ostmt.setString(8,position_value);
		  ostmt.setString(9,expected_value2);
	 
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(10);
		//System.out.println("status"+status);
        message_text = ostmt.getString(11);

        if (status.equals("0"))
        {
          connection.commit(); 

		  if(mode.equals("D"))
			{
			  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
		  status = ((String) mesg.get("message"));
         ////System.out.println("status12"+status);
			}
			else
			{
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
         //System.out.println("status12"+status);
			}
        }
		else if(status.equals("2"))
		 {
	final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "common") ;
	  		    status = ((String) mesg.get("message"));
		 }
        else
        {
         // boolean chkStat=false;
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		        //System.out.println("status123"+status);
		  //if(chkStat)
		  //{
			 //  final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		       //status = ((String) mesg.get("message"));
		 // }
		 // else 
		  //{

			   if(mode.equals("I"))
			{
                final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "common") ;
	  		    status = ((String) mesg.get("message"));
			}
			else
			{
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	  		    status = ((String) mesg.get("message"));
			}
	
		 // }
        }


		out.println("");
       out.println(status);
       out.println("");
       out.println("</body>");  
       if(ostmt!=null)ostmt.close();
                   
      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of XHDataElementCrossRefElementIDServlet :"+e.toString());
	      e.printStackTrace(System.err);
	  }



%>
	  </form>
	  </body>
	  </html>
 

