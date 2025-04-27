<!DOCTYPE html>
 <html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >
<form > 
<% 
	Connection con = null; 
	
	  CallableStatement ostmtleval = null; 
	Statement segstmt=null;
	String status="0";
	ResultSet levelset=null;  
	
		MessageManager mm=new MessageManager();
	Properties p;
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE"); 
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");
  String message_text2="";
   
    try
    {
       if(con==null) con = ConnectionManager.getConnection(request);
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of MsgForApplEventTypeJsp:"+exp.toString());
	     exp.printStackTrace(System.err);
      //   exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	 
   
try
    {
//        System.out.println("coming : here 47");
	   String event_type=request.getParameter("event_type");
		String appl_id=request.getParameter("appl_id");
		String standard_code = XHDBAdapter.checkNull(request.getParameter("stnd_code"));
		System.out.println("stnd_code"+standard_code+"appl_id :"+appl_id+"msg_type :"+event_type);

	    	request.setAttribute("application_Id",appl_id);
			request.setAttribute("message_type",event_type);
            request.setAttribute("standard_code",standard_code); 

        XHMsgForEventwiseElementControllerBean xhBean=XHMsgForEventwiseElementControllerBean.getBean(XHMsgForEventwiseElementControllerBean.strBeanName,request,session);
        xhBean.action(request,con);
		String strData[][]= xhBean.getDatabaseData();
		ArrayList arrAudit = ArrayAuditInfo.getArrayAuditInfo(session);
		xhBean.action(request,con);
	   ostmtleval =  con.prepareCall("{ call xhmast.segment_for_application(?,?,?,?,?,?,?,?,?,?,?) }" ); 
		for(int i=0;i<strData.length;i++) 
		 {
     
		
//         System.out.println("strData[i][5]"+strData[i][5]);
//		 System.out.println("strData[i][6]"+strData[i][6]);
//		 System.out.println("strData[i][7]"+strData[i][7]);
	
	    
//        System.out.println("set field 91:"+strData[i][8]); 
//	      System.out.println("in use :"+strData[i][2]);
 //         System.out.println("appl_id :"+appl_id);
         
 

     																								  
		 
//		  System.out.println("Comm TYpe : "+comm_type);
       
		  String  usr_added_by_id=(String)arrAudit.get(0);
		  String  usr_added_at_ws_no=(String)arrAudit.get(1);
		  //String  s1=(String)gen_arr.get(2);
			  
   
           // if(strData[i][8].equals("Y"))
			 //{
				 ostmtleval.setString(1,appl_id); 
				 ostmtleval.setString(2,strData[i][7]);
				 ostmtleval.setString(3,strData[i][1]);
				 ostmtleval.setString(4,strData[i][6]); 
				 ostmtleval.setString(5,strData[i][3]);
				 ostmtleval.setString(6,strData[i][4]); 
				  
				 ostmtleval.setString(7,usr_added_by_id);
				 ostmtleval.setString(8,usr_added_at_ws_no);
				 ostmtleval.setString(9,strData[i][9]);
				 ostmtleval.registerOutParameter(10,java.sql.Types.VARCHAR);
				 ostmtleval.registerOutParameter(11,java.sql.Types.VARCHAR); 
				 ostmtleval.execute();
				
				 String status2 = 	ostmtleval.getString(10);	
					 System.out.println("status2 : "+status2);
					 message_text2 = ostmtleval.getString(11);	
					 System.out.println("message_text2 : "+message_text2);
				
						 if("0".equals(status2))
						{
							con.commit();
						final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
						status = ((String) mesg.get("message"));
						}
						 else
						{
						  con.rollback();
						  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ; 
							status = ((String) mesg.get("message")); 
						}
		//	 }
			// else 
			// {
			// }
			
	  }
	  if(ostmtleval!=null)ostmtleval.close();
        out.println("");
        out.println(status);
        out.println("");
        out.println("</body>");  
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of dataelementcrossrefapplicationusageservlet :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		      if(ostmtleval!=null)ostmtleval.close();
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of dataelementcrossrefapplicationusageservlet :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 

		}

    



    
       
        

  
      



    




                   
     
      try{
		    if(ostmtleval!=null)ostmtleval.close();
        if(levelset!=null)levelset.close();
        if(segstmt!=null)segstmt.close();
      ConnectionManager.returnConnection(con);
	  }
	  catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
        // exceptions=exceptions+"1"+"*"+exp.toString();
     }    
	  %>


 
	  </form>
	  </body>
	  </html>
 

