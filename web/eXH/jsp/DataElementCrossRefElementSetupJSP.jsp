<!DOCTYPE html>
<html> 
<%@ page import="java.sql.*,java.lang.*,java.util.*,java.io.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
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
Properties p;		
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");

	request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

//	PrintWriter out=res.getWriter();
	CallableStatement oraclecallablestatement = null;
	Connection con = null;
	MessageManager mm=new MessageManager();
	
	String status="";   

    try
    {
     
      out.println("<head>");
      sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
      out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
      out.println("</head>");
      out.println("<body class='MESSAGE'>");      
   
	}
    catch(Exception exception)
    {
         System.out.println("Error in dopost method od dataelementcrossrefapplicationusageservlet:"+exception.toString());
		exception.printStackTrace(System.err); 
		
    }
	
	try
    {
        con = ConnectionManager.getConnection();
        XHApplicationElementControllerBean xhBean=XHApplicationElementControllerBean.getBean(XHApplicationElementControllerBean.strBeanName,request,session);
        xhBean.action(request,con);

		String strData[][]= xhBean.getDatabaseData();
		ArrayList arrAudit = AuditInfo.getArrayAuditInfo(session);
		xhBean.action(request,con);
		

		for(int i=0;i<strData.length;i++) 
		 {
     
     
	    oraclecallablestatement = con.prepareCall("{call XHMAST.element_code_usage_for_appl(?,?,?,?,?,?,?,?,?)}");
       
		String  usr_added_by_id=(String)arrAudit.get(0);
		String  usr_added_at_ws_no=(String)arrAudit.get(1);
	    oraclecallablestatement.setString(1,strData[i][0]);

/*System.out.println("strData[i][0]"+strData[i][0]);
System.out.println("strData[i][1]"+strData[i][1]);
System.out.println("strData[i][2]"+strData[i][2]);
System.out.println("strData[i][3]"+strData[i][3]);
System.out.println("strData[i][4]"+strData[i][4]);	*/

		oraclecallablestatement.setString(2,strData[i][1]);
		oraclecallablestatement.setString(3,strData[i][2]);
		oraclecallablestatement.setString(4,strData[i][3]);
		oraclecallablestatement.setString(5,strData[i][4]);
		 

	    oraclecallablestatement.setString(6,usr_added_by_id);
		oraclecallablestatement.setString(7,usr_added_at_ws_no);

		oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
		
        oraclecallablestatement.execute();
		
        
		status = oraclecallablestatement.getString(8);
		if(oraclecallablestatement!=null) oraclecallablestatement.close();
        if("0".equals(status))
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

	  }
        out.println("");
        out.println(status);
        out.println("");
        out.println("</body>");  
		
		}catch(Exception exception)
		{
			 System.out.println("Error in calling db realted statements in dopost method of DataElementCrossRefElementSetupJSP.jsp :"+exception.toString());
		    exception.printStackTrace(System.err); 
		
		}finally{
			try
			{
		      
			   ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			   System.out.println("Eroor in closing dbconnection dopost method of DataElementCrossRefElementSetupJSP.jsp :"+ex.toString());
		      ex.printStackTrace(System.err); 
			}
			//if(con!=null) 

		}
%>



  </form>
	  </body>
	  </html>
 

