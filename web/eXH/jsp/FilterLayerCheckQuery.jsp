<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,java.util.StringTokenizer" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<html>
<head>

<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>



//

</script>
</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE">
<form>


<%
String Status="FALSH";
	 ResultSet rset = null;
  
  Statement stmt=null;
 Connection connection = null;

    // String status="";
     String exceptions="";


//    String levelcount="";
//    MessageManager mm=new MessageManager();
//    int levelcount1=0;
	String query = request.getParameter("Query");

	//System.out.println("query 42"+query);
	String fieldname=request.getParameter("fieldname");
	//System.out.println("query"+query);
    String replacestr="%";
	
    String reSecond = new String("'"+replacestr+"'");

    //System.out.println("reSecond :"+reSecond);
    if(query.indexOf(":1")!=-1)
	{ 
         query=query.replace(":1","null");
		 query=query.trim();
//replacestr
//rset.getString(3);
	} 
else
	{
		query=query.trim();
	}


     if(query.indexOf(":2")!=-1)
	{
         query=query.replace(":2","null");
		 query=query.trim();
	}
	else
	{
		query=query.trim();
	}





//System.out.println("query 67"+query);
	Properties p;		
  		p = (Properties) session.getValue("jdbc");	
       // String locale  = p.getProperty("LOCALE");
    try 
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayerCheckQuery.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
    try
     { 
 stmt= connection.createStatement();
 rset = stmt.executeQuery(query);
 rset.next();


 
if(rset.next())
 {
 }

 Status="TRUE";
      }
      catch(Exception exp) 
      {
        
          if(fieldname.equals("Element_subtype"))
		  {
			  out.println("<script>alert(getMessage('XH1046','XH'));parent.frames[3].document.forms[0].Element_subtype.focus();</script>"); 
		  }
		  else if(fieldname.equals("Filter_Element_Query"))
		  {
           out.println("<script>alert(getMessage('XH1046','XH'));parent.frames[3].document.forms[0].Filter_Element_Query.focus();</script>"); 
		  }
		  else
		  {          out.println("<script>alert(getMessage('XH1046','XH'));parent.frames[3].document.forms[0].Element_query.focus();</script>"); 
		  }
					 
         System.out.println("Error in calling dbrealted statements in dooperate method of FilterLayerCheckQuery.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
		 
      }
      try{
      ConnectionManager.returnConnection(connection);
	  rset.close() ;  
      stmt.close();
	  } catch(Exception exp)
    {
		
       System.out.println("Error in populatexhcodedesc method of FilterLayerCheckQuery.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
	  finally{


              		
               
		}
		
%> 


</form>
</body>

</html>

