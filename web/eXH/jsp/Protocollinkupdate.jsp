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

<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence.js" ></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body bgcolor=#B2B6D7 class="Message" >
<form > 
<% 
  String Action_type=request.getParameter("Mode");
//System.out.println("Action_type25"+Action_type);
	  
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
   
    String exceptions="";
   
	//String applicationid="";
	// String elementid="";
	 /*String derivation_type="";
	   String cond_exprsn="";
	   String expected_value="";
	    String execution_order="";
		  String expected_value2="";
		  String position_value="";*/

	MessageManager mm=new MessageManager();

		//req=request;
		 Properties p;
	
		p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");
    	request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
  
    
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
		 //

 XHApplicationDerivationProfileSetupControllerBean xhBean=XHApplicationDerivationProfileSetupControllerBean.getBean(XHApplicationDerivationProfileSetupControllerBean.strBeanName,request,session); 
    xhBean.action(request,connection);

     String strData[][] = xhBean.getDatabaseData();
	  ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
     String  usr_added_by_id=(String)arrAudit.get(0);

     //ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
	// xhBean.action(request,connection);
    // MessageManager mm=new MessageManager();


 for(int i=0;i<strData.length;i++)
	 { 
 	  

/*applicationid=XHDBAdapter.checkNull(request.getParameter(i+"Profile_ID")); 
	        System.out.println("applicationid : "+applicationid);
     
       elementid=XHDBAdapter.checkNull(request.getParameter(i+"Element_ID"));
	        System.out.println("elementid : "+elementid);
	
      derivation_type=XHDBAdapter.checkNull(request.getParameter(i+"_Combo"));
	        System.out.println("derivation_type : "+derivation_type);

       cond_exprsn=XHDBAdapter.checkNull(request.getParameter(i+"_C/E"));
	        System.out.println("cond_exprsn : "+cond_exprsn);
		     
       expected_value=XHDBAdapter.checkNull(request.getParameter(i+"_EV"));
	  System.out.println("expected_value : "+expected_value);
	
       execution_order=XHDBAdapter.checkNull(request.getParameter(i+"_EO"));
	  System.out.println("execution_order : "+execution_order);

       expected_value2=XHDBAdapter.checkNull(request.getParameter(i+"_EV2"));
	  System.out.println("expected_value : "+expected_value2);
	
	   position_value=XHDBAdapter.checkNull(request.getParameter(i+"_PO"));
	  System.out.println("Position_value : "+position_value);*/

	 
      ostmt = connection.prepareCall("{ CALL XG_PRC.XH_PROTOCOL_LINK_RULES_IN_UP(?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
		//System.out.println("prepareCall XH_PROTOCOL_LINK_DERVN_RULES");
          ostmt.setString(1,Action_type);
		    ostmt.setString(2,strData[i][6]);
//ostmt.setString(1,Action_type);
		  ostmt.setString(3,strData[i][10]);
		  ostmt.setString(4,strData[i][1]);
		  ostmt.setString(5,strData[i][4]);
		  ostmt.setString(6,strData[i][7]);
		  ostmt.setString(7,strData[i][5]);
		 ostmt.setString(8,strData[i][9]);
		  ostmt.setString(9,usr_added_by_id);
		  ostmt.setString(10,strData[i][8]);
	     
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(11);
		//System.out.println("status"+status);
        message_text = ostmt.getString(12);
  if(ostmt!=null)ostmt.close();
        if (status.equals("0"))
        {
          connection.commit(); 
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		  status = ((String) mesg.get("message"));
         ///System.out.println("status12"+status);
        }
        else
        {
          
          connection.rollback();
		 // chkStat=containsSubstring(message_text,"APP-SY0127  Fatal Error ! Note and inform DBA:ORA-01410: invalid ROWID");
		   //     System.out.println("status123"+status);
		  //if(chkStat)
		  //{
			//   final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
		      // status = ((String) mesg.get("message"));
		  //}
		  //else 
		  //{
               final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
	           status = ((String) mesg.get("message"));
	
		  //}
        }
	 }
	 out.println(status);
	  
    }
	catch(Exception exp)
    {
       //System.out.println("Error in dooperate method of XHDataElementCrossRefElementIDServlet :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
	finally
	{
		 
		if(ostmt!=null)
	    	ostmt.close();
		ConnectionManager.returnConnection(connection);
	}
   
      
	  %>
	  </form>
	  </body>
	  </html>

