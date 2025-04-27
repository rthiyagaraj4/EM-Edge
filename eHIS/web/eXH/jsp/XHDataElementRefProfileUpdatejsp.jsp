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
  

	
	 String Action_type=request.getParameter("Mode");
//System.out.println("Action_type25"+Action_type);
	  
    Connection connection = null;
    CallableStatement ostmt = null;
    String message_text = "",status="0";
   
    String exceptions="";
   
	/*String applicationid="";
	 String elementid="";
	 String derivation_type="";
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
         System.out.println("Error in calling getconnection method of dooperate method of XHDataElementRefProfileUpdatejsp.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {
		 //System.out.println("varuthu ithula11111");

 XHApplicationDerivationProfileSetupControllerBean xhBean=XHApplicationDerivationProfileSetupControllerBean.getBean(XHApplicationDerivationProfileSetupControllerBean.strBeanName,request,session); 
    xhBean.action(request,connection);
	//System.out.println("varuthu ithula");
     String strData[][] = xhBean.getDatabaseData();
//System.out.println("varuthu ithulasadda");
     //ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
	 xhBean.action(request,connection);
    // MessageManager mm=new MessageManager();
	//System.out.println("strData[i][0]"+strData.length);

	 for(int i=0;i<strData.length;i++)
	 {
	
		/* System.out.println("strData[i][1]"+strData[i][1]);
		 System.out.println("strData[i][2]"+strData[i][2]);
		 System.out.println("strData[i][3]"+strData[i][3]);
	  System.out.println("strData[i][4]"+strData[i][4]);
System.out.println("strData[i][5]"+strData[i][5]);
		 System.out.println("strData[i][6]"+strData[i][6]);
		 System.out.println("strData[i][7]"+strData[i][7]);
		 System.out.println("strData[i][8]"+strData[i][8]);
	  System.out.println("strData[i][9]"+strData[i][9]);	  */
//System.out.println("strData[i][10]"+strData[i][10]);
 ostmt = connection.prepareCall("{ CALL xg_prc.xh_profile_derivation_rules(?,?,?,?,?,?,?,?,?,?,?) }" ); 
 ostmt.setString(1,Action_type);
		  ostmt.setString(3,strData[i][10]);
		  ostmt.setString(4,strData[i][1]);
		  ostmt.setString(5,strData[i][4]);
		  ostmt.setString(6,strData[i][7]);
		  ostmt.setString(7,strData[i][5]);
		  ostmt.setString(2,strData[i][6]);
		  ostmt.setString(9,strData[i][8]);
	      ostmt.setString(8,strData[i][9]);
		 
		//  ostmt.setString(11,usr_facility_by_id);
		  ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(11,java.sql.Types.VARCHAR);

        ostmt.execute();
        status = ostmt.getString(10);
		//System.out.println("status"+status);
        message_text = ostmt.getString(11);
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
          //boolean chkStat=false;
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
         System.out.println("Error in calling dbrealted statements in dooperate method of XHDataElementRefProfileUpdatejsp.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
		
        
      }
      try{
      ConnectionManager.returnConnection(connection);
	  }catch(Exception e)
		 {
	      System.out.println("Error in closing dbconnection in  XHDataElementRefProfileUpdatejsp.jsp :"+e.toString());
	      e.printStackTrace(System.err);
	  }
 
	%>
  </form>
	  </body>
	  </html>
 

