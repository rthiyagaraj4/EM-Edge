<!DOCTYPE html>
 <html> 
<%@ page import="java.sql.*,java.lang.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*" %>
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
<body BGCOLOR="#B2B6D7" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'  >
<form >

<% 		
 Connection connection = null;					   
 MessageManager mm=new MessageManager();
 Properties p;
 p = (Properties) session.getValue("jdbc");	
 String msg="";
 CallableStatement ostmt = null;
 String exceptions="";
 String status="";	    
 String module_id=XHDBAdapter.checkNull(request.getParameter("module_id"));	
 String masterName=XHDBAdapter.checkNull(request.getParameter("master_name")); 
 String applicationID=XHDBAdapter.checkNull(request.getParameter("application"));
 String display=XHDBAdapter.checkNull(request.getParameter("display"));
 String searchText=XHDBAdapter.checkNull(request.getParameter("searchtext"));
 String mod_id= XHDBAdapter.checkNull(request.getParameter("mod_id")); 
 String func_id=XHDBAdapter.checkNull(request.getParameter("func_id"));
 String outbound_yn="X";		  
 String searchpk2=XHDBAdapter.checkNull(request.getParameter("searchpk2")); 	 
 String searchpk3=XHDBAdapter.checkNull(request.getParameter("searchpk3"));
 String start_ends_contains=XHDBAdapter.checkNull(request.getParameter("start_ends_contains")); 
 p = (Properties) session.getValue("jdbc");	


    try					  
    {
       if(connection==null) connection = ConnectionManager.getConnection();
      		
     }catch(Exception exp){
         System.out.println("Error in calling getconnection  XHTranslationExportData.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    																	    
     try			 			  
     {																							    
		ostmt = connection.prepareCall("{ CALL xhdevapi.xh_manage_appl_trigger(?,?,?,?) }" ); 
		ostmt.setString(1,module_id);
  		ostmt.setString(2,masterName);
		ostmt.setString(3,applicationID);
		ostmt.registerOutParameter(4,java.sql.Types.VARCHAR);
	    ostmt.execute();
		status = ostmt.getString(3);
		 if(status.equals("0"))
		 {
			connection.commit(); 
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			msg= ((String) mesg.get("message"));
			mesg.clear();
		 }
		 else
		 {
			connection.rollback();
			final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			msg = ((String) mesg.get("message"));
			mesg.clear();
		 }					   
														   
			if(ostmt!=null)
				{
					ostmt.close();
					ostmt=null;							  					  
				}		 				    
				RequestDispatcher reqDis =	session.getServletContext().getRequestDispatcher("/eXH/jsp/XHTranslationDisplayResult.jsp?message="+msg+"&module_id="+module_id+"&masterName="+masterName+"&application="+applicationID+"&display="+display+"&searchText="+searchText+"&Searchbymod="+mod_id+"&SearchbyFunct="+func_id+"&start_ends_contains="+start_ends_contains+"&outbound_yn="+outbound_yn+"&searchpk2="+searchpk2+"&searchpk3="+searchpk3);  reqDis.forward(request,response);	 			   
																	 	 	  					   
      }															  				   
      catch(Exception exp) 
      {
         System.out.println("Error in calling dbrealted statements in XHTranslationExportData.jsp sqlexeception :"+exp);
	             
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
										 

