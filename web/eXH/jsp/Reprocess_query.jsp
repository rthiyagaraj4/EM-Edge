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
<script src='../../eXH/js/filterlayerrefrence.js' language='javascript'></script>
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

String ApplicationId="";
String FacilityId="";
String Query_id="";
String Querystatus="";

String exceptions="";
		MessageManager mm=new MessageManager();
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
  
    try
    { 
 	
 ApplicationId=request.getParameter("application_id");
 FacilityId=request.getParameter("Facility_id");
 Query_id=request.getParameter("queryid");
 Querystatus=request.getParameter("qstatus");
 
	  //System.out.println("ApplicationId"+ApplicationId+"FacilityId"+FacilityId+"Query_id"+Query_id+"Querystatus"+Querystatus);

    }
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of ReSend_query.jsp :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method ofReprocess_query.jspp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {


      ostmt = connection.prepareCall("{ CALL XG_PRC.REPROCESS_QUERY(?,?,?,?,?,?) }" ); 
	
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
    		 

//System.out.println("usr_added_by_id"+usr_added_by_id+"usr_added_at_ws_no"+usr_added_at_ws_no+"usr_added_by_date"+usr_added_by_date);

		
		  
		
		  ostmt.setString(1,ApplicationId);
		  ostmt.setString(2,FacilityId);
		  ostmt.setString(3,Querystatus);
		  ostmt.setString(4,Query_id);
		       
    	  ostmt.registerOutParameter(5,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(5);
	      //System.out.println("status"+status);
          message_text = ostmt.getString(6);
            if (status.equals("0"))
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message"));
                  
				 
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
				

out.println(status);
    
        }
        else
        {
 
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		out.println(message_text);

		   
		  
        }

  
      
       if(ostmt!=null)ostmt.close();
                   
      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of Reprocess_query.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in dooperate method of Reprocess_query.jsp :"+e.toString());
	      e.printStackTrace(System.err);
	  }
	  %>

<script>


</script>


	  </form>
	  </body>
	  </html>
 

