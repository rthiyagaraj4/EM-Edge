<!DOCTYPE html>
 <html>
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle ="IeStyle.css";
//(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript" >
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
									  
</head>
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' CLASS="MESSAGE" >	    
<form > 
<% 																	    
 Connection connection = null;
 MessageManager mm=new MessageManager();
 Properties p;
p = (Properties) session.getValue("jdbc");	
String msg="";
 CallableStatement ostmt = null;
 String message_text = "",status="0";
 String Filter_group="";
 String	mode="";
 String exceptions="";
 int Transaction_number=1;
String applicationID=request.getParameter("applicationID");
String facilityID=request.getParameter("facilityID"); 
String event_type=request.getParameter("event_type");
String protocol_link_id=request.getParameter("protocol_link");
 p = (Properties) session.getValue("jdbc");	
    request.setCharacterEncoding("UTF-8");
   	response.setContentType("text/html;charset=UTF-8");

    try
    { 
 		mode=XHDBAdapter.checkNull(request.getParameter("actualmode"));
    } 
	catch(Exception exp)
    {
       System.out.println("Error in dooperate method of FilterAndSchedulingUpdateRecord.jsp.jsp :"+exp.toString());	
	   exp.printStackTrace(System.err);
    }
    try
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterAndSchedulingupdateRecord.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
     try
     {

Filter_group=request.getParameter("Filter_group_desc_id");
Transaction_number=Integer.parseInt(request.getParameter("Tranaction_number"));
ostmt = connection.prepareCall("{ CALL xhgenericfilter.XH_APPL_FILTER_RULE_DETAIL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 
	      ostmt.setString(1,mode);
  		  ostmt.setInt(2,Transaction_number);
		  ostmt.setString(3,Filter_group);									  
		  ostmt.setString(4,applicationID);
		  ostmt.setString(5,facilityID);
		  ostmt.setString(6,event_type);
		  ostmt.setString(7,protocol_link_id);
		  ostmt.setString(8,XHDBAdapter.checkNull(request.getParameter("1Filter_element_desc"))); 
          ostmt.setString(9,XHDBAdapter.checkNull(request.getParameter("1Filter_subtype_desc_combo"))); 
          ostmt.setString(10,XHDBAdapter.checkNull(request.getParameter("Element_code_Query1"))); 
          ostmt.setString(11,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys1")));   
		  ostmt.setString(12,XHDBAdapter.checkNull(request.getParameter("2Filter_element_desc"))); 
          ostmt.setString(13,XHDBAdapter.checkNull(request.getParameter("2Filter_subtype_desc_combo"))); 
          ostmt.setString(14,XHDBAdapter.checkNull(request.getParameter("Element_code_Query2"))); 
          ostmt.setString(15,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys2")));  
		  ostmt.setString(16,XHDBAdapter.checkNull(request.getParameter("3Filter_element_desc"))); 
          ostmt.setString(17,XHDBAdapter.checkNull(request.getParameter("3Filter_subtype_desc_combo"))); 
          ostmt.setString(18,XHDBAdapter.checkNull(request.getParameter("Element_code_Query3"))); 
          ostmt.setString(19,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys3")));   
		  ostmt.setString(20,XHDBAdapter.checkNull(request.getParameter("4Filter_element_desc")));           ostmt.setString(21,XHDBAdapter.checkNull(request.getParameter("4Filter_subtype_desc_combo"))); 
          ostmt.setString(22,XHDBAdapter.checkNull(request.getParameter("Element_code_Query4"))); 
          ostmt.setString(23,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys4")));  
    	  ostmt.setString(24,XHDBAdapter.checkNull(request.getParameter("5Filter_element_desc"))); 
          ostmt.setString(25,XHDBAdapter.checkNull(request.getParameter("5Filter_subtype_desc_combo"))); 
          ostmt.setString(26,XHDBAdapter.checkNull(request.getParameter("Element_code_Query5"))); 
          ostmt.setString(27,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys5")));     
		  ostmt.setString(28,XHDBAdapter.checkNull(request.getParameter("6Filter_element_desc"))); 
          ostmt.setString(29,XHDBAdapter.checkNull(request.getParameter("6Filter_subtype_desc_combo"))); 
          ostmt.setString(30,XHDBAdapter.checkNull(request.getParameter("Element_code_Query6"))); 
          ostmt.setString(31,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys6")));  
		  ostmt.setString(32,XHDBAdapter.checkNull(request.getParameter("7Filter_element_desc"))); 
          ostmt.setString(33,XHDBAdapter.checkNull(request.getParameter("7Filter_subtype_desc_combo"))); 
          ostmt.setString(34,XHDBAdapter.checkNull(request.getParameter("Element_code_Query7"))); 
          ostmt.setString(35,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys7")));  
    	  ostmt.setString(36,XHDBAdapter.checkNull(request.getParameter("8Filter_element_desc"))); 
          ostmt.setString(37,XHDBAdapter.checkNull(request.getParameter("8Filter_subtype_desc_combo"))); 
          ostmt.setString(38,XHDBAdapter.checkNull(request.getParameter("Element_code_Query8"))); 
          ostmt.setString(39,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys8")));   
		  ostmt.setString(40,XHDBAdapter.checkNull(request.getParameter("9Filter_element_desc"))); 
          ostmt.setString(41,XHDBAdapter.checkNull(request.getParameter("9Filter_subtype_desc_combo"))); 
          ostmt.setString(42,XHDBAdapter.checkNull(request.getParameter("Element_code_Query9"))); 
          ostmt.setString(43,XHDBAdapter.checkNull(request.getParameter("Element_code_Querys9")));  
    	  ostmt.registerOutParameter(44,java.sql.Types.VARCHAR);
          ostmt.registerOutParameter(45,java.sql.Types.VARCHAR);
		  ostmt.registerOutParameter(46,java.sql.Types.VARCHAR);
          ostmt.execute();
          status = ostmt.getString(45); 
          message_text = ostmt.getString(46);
		   if(ostmt!=null)
			 {
	    	ostmt.close();
	    	ostmt=null;
			 }
		
        out.println("<html><head></head><body bgcolor=#B2B6D7 >"); 
        out.println("</body></html>");
       
       if (status.equals("0"))  
        {
          connection.commit(); 
	      final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 msg = ((String) mesg.get("message")); 
		   out.println(msg);
           if(ostmt!=null)   ostmt.close();
           out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");
		}

		else if (status.equals("2"))  
        {
          connection.commit(); 
		  //final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
		 // status = ((String) mesg.get("message")); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1024", "XH") ;
		 msg = ((String) mesg.get("message")); 
		  out.println(msg);
          out.println("<script>parent.frames[4].location.href='../../eCommon/html/blank.html';  </script>");
		
		}
		else
        {
         
          connection.rollback();
		  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
		  msg = ((String) mesg.get("message"));
		  out.println(msg);
		  if(ostmt!=null)
		  ostmt.close();
		  
        }

 
      }
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in dooperate method of sqlexeception :"+exp);
	             
      }
finally
{
if(ostmt!=null)
			   	   ostmt.close();
ConnectionManager.returnConnection(connection);
}

      
	  
	  %>
<input type=hidden name=filter_code value='<%=Filter_group%>'>

<script>
parent.frames[3].location.href="../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code="+document.forms[0].filter_code.value;
</script>

	  </form>
	  </body>
	  </html>
										 			  

