<!DOCTYPE html>
 <html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,,webbeans.eCommon.*" %>
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

<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence.js" ></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body bgcolor=#B2B6D7 CLASS="MESSAGE" >
<form > 
<% 
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
    java.util.Date d=new java.util.Date();
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
   String  usr_added_by_id="";
//   String usr_added_by_date="";
   String  usr_added_at_ws_no="";
  // String Modified_added_by_id="";
  // String Modified_added_by_date="";
   //String  Mdofied_added_at_ws_no="";
   MessageManager mm=new MessageManager();
	//MessageManager mm=new MessageManager();
   // String dateval=d.getInstance();
	String SysDate=d.getMonth()+"/"+d.getDate()+"/"+(d.getYear()+1900);
		//req=request;

		
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
    ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
    try
    { 
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
	    usr_added_by_id=(String)arrAudit.get(0);
		  usr_added_at_ws_no=(String)arrAudit.get(1);
// usr_added_by_date=(String)arrAudit.get(2);
 
//System.out.println(usr_added_by_id+"usr_added_at_ws_no"+usr_added_at_ws_no+"usr_added_by_date"+SysDate);

// Modified_added_by_id=(String)arrAudit.get(3);
// Modified_added_by_date=(String)arrAudit.get(4);
  //Mdofied_added_at_ws_no=(String)arrAudit.get(1);
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


      ostmt = connection.prepareCall("{ CALL xg_prc.XH_PROTOCOL_LINK_RULES_IN_UP(?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
		////System.out.println("prepareCall XH_PROTOCOL_LINK_DERVN_RULESs");
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
    		 //System.out.println("values"+mode+"applicationid,"+applicationid+"elementid,"+elementid+"derivation_type,"+derivation_type+"cond_exprsn,"+cond_exprsn+"expected_value,"+expected_value+"execution_order,"+execution_order+"position,"+position_value+"SysDate"+SysDate);

//System.out.println("usr_added_by_id"+usr_added_by_id+"usr_added_at_ws_no"+usr_added_at_ws_no+"usr_added_by_date"+usr_added_by_date);

		  ostmt.setString(1,mode);
		  ostmt.setString(2,execution_order);
		  ostmt.setString(3,applicationid);
		  ostmt.setString(4,elementid);
		  ostmt.setString(5,derivation_type);
		  ostmt.setString(6,cond_exprsn);
		  ostmt.setString(7,expected_value);
	      ostmt.setString(8,position_value);
		  ostmt.setString(9,usr_added_by_id);
		  ostmt.setString(10,expected_value2);
    	  ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(11);
	      //System.out.println("status"+status);
          message_text = ostmt.getString(12);
      
        if (status.equals("0"))
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message"));

		 if(mode.equals("D"))
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "XH1036", "XH") ;
	  		    status = ((String) mesg.get("message"));
			}
			else
			{
final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
	  		    status = ((String) mesg.get("message"));
			}
out.println(status);
 
         //System.out.println("status12"+status);
        }

else if(status.equals("2"))
		 {
	final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "common") ;
	  		    status = ((String) mesg.get("message"));
		 }

        else
        {
        //  boolean chkStat=false;
          connection.rollback();
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1043", "XH") ;
	  		    status = ((String) mesg.get("message"));
           out.println(status);
		 
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		 
		      
		  /*if(chkStat)
		  {
			   //final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		      // status = ((String) mesg.get("message"));
		  }
		  else 
		  {
              // final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	           //status = ((String) mesg.get("message"));
	
		  }*/
        

		}

		
      
      
       if(ostmt!=null)ostmt.close();
                   
      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of Protocollinkrecord.jsp :"+exp.toString());
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

