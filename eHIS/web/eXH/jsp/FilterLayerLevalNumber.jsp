<!DOCTYPE html>
 <%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>

<%-- Mandatory declarations end --%> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

	 ResultSet rset = null;
  
  Statement stmt=null;
 Connection connection = null;

 String status="";
String exceptions="";


String levelcount="";
MessageManager mm=new MessageManager();
int levelcount1=0;
	String filter_group = request.getParameter("filter_code");
	System.out.println("filter_group"+filter_group);

	Properties p;		
  		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");
    try 
    {																		    
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayerLevalNumber.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
    try																		   
     { 
 stmt= connection.createStatement();
 rset = stmt.executeQuery("select max(LEVEL_NUMBER) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+filter_group+"'");
 rset.next();
 levelcount1 = rset.getInt("rowcount") ;
rset.close() ;  
stmt.close();

stmt= connection.createStatement();
String sq="select 'Y'  from xh_filter_group  where FILTER_group_code='"+filter_group+"' and total_levels>= '"+(levelcount1+1)+"' ";
rset = stmt.executeQuery(sq);
System.out.println(sq);

 
if(rset.next())
 {
String levalcount2="";
levelcount=levalcount2.valueOf(levelcount1+1);
 }
else
 {
final java.util.Hashtable mesg = mm.getMessage(locale,"XH1044", "XH") ;
  status = ((String) mesg.get("message"));
  status = status.replace("$","test");

  out.println("<script>alert('"+status+"'); parent.frames[3].document.forms[0].reset();</script>");
//RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("../../eXH/jsp/DisplaySleepParameterResult1.jsp?message="+status+"");
  //        reqDis.forward(request,response);
 }

rset.close() ; 
 stmt.close();
/*levelcount=levelcount1;
if(group_level_status.equals("Y"))
 {


 }
else
 {
  //    final java.util.Hashtable mesg = mm.getMessage(locale, "XH1034", "XH") ;
	//  		    status = ((String) mesg.get("message"));
//RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("../../eXH/jsp/DisplaySleepParameterResult1.jsp?message="+status+"");
  //          reqDis.forward(request,response);
 }*/

      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in FilterLayerLevalNumber.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
  
      }
      try{
      ConnectionManager.returnConnection(connection);					  
	  } catch(Exception exp)
    {
       System.out.println("Error in FilterLayerLevalNumber.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
	  finally{


              		
               
		}
		
%> 
<html>
<head>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE">
<form>
<input type=hidden name=input_value value='<%=levelcount+""%>'>
<script>
var levelnumber;
levelnumber=document.forms[0].input_value.value;

parent.frames[3].document.forms[0].Event_type.value=levelnumber;
parent.frames[3].document.forms[0].Level_number.value=levelnumber;
</script>
</form>
</body>

</html>

