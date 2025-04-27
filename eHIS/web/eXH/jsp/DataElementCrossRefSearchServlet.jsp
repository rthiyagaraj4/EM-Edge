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

Properties p;
	
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");
  
    String appliction_Mode="";
		
	appliction_Mode=request.getParameter("Mode");
	
	String status="";
    
  //String Action_type=request.getParameter("Mode");
//System.out.println("Action_type25"+appliction_Mode);
	  
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "";
   
    String exceptions="";
   


	MessageManager mm=new MessageManager();

		
		
    	
  
    
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of DataElementCrossRefSearchServlet.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {
		 //System.out.println("varuthu ithula11111");

 XHApplicationDerivationSetupControllerBean xhBean=XHApplicationDerivationSetupControllerBean.getBean(XHApplicationDerivationSetupControllerBean.strBeanName,request,session); 
    xhBean.action(request,connection);
	//System.out.println("varuthu ithula");
     String strData[][] = xhBean.getDatabaseData();
	 ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		
        String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
	//System.out.println("strData[i][0]"+strData.length);

 for(int i=0;i<strData.length;i++)
	 { 
 	  



	  //System.out.println("strData[i][1]"+strData[i][0]);
		 //System.out.println("strData[i][2]"+strData[i][2]);
		/* System.out.println("strData[i][3]"+strData[i][3]);
	  System.out.println("strData[i][4]"+strData[i][4]);
System.out.println("strData[i][5]"+strData[i][5]);
		 System.out.println("strData[i][6]"+strData[i][6]);
		 System.out.println("strData[i][7]"+strData[i][7]);
		 System.out.println("strData[i][8]"+strData[i][8]);
	  System.out.println("strData[i][9]"+strData[i][9]);
System.out.println("strData[i][10]"+strData[i][10]);
System.out.println("strData[i][11]"+strData[i][11]);   */
 ostmt =connection.prepareCall("{ CALL Xg_prc.xh_appl_derivation_rules(?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
		System.out.println("prepareCall XH_PROTOCOL_LINK_DERVN_RULES");
          ostmt.setString(1,appliction_Mode);
		    ostmt.setString(2,strData[i][1]);
//ostmt.setString(1,Action_type);
		  ostmt.setString(3,strData[i][4]);
		  ostmt.setString(4,strData[i][7]);
		  ostmt.setString(5,strData[i][5]);
		  ostmt.setString(6,strData[i][6]);
		  ostmt.setString(7,strData[i][8]);
		 ostmt.setString(8,strData[i][9]);
		  ostmt.setString(9,usr_added_by_id);
		  ostmt.setString(10,usr_added_at_ws_no);
	     
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(12,java.sql.Types.VARCHAR);
ostmt.setString(13,strData[i][10]);
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
         //System.out.println("status12"+status);
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
       System.out.println("Error in  DataElementCrossRefSearchServlet.jsp :"+exp.toString());	
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

