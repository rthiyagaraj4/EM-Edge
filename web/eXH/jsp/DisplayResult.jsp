<!DOCTYPE html>
<html> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,java.util.regex.Pattern,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 
<script language="JavaScript">
function formLoad()																		 			   
{					
	var qryString = document.getElementById("queryString").value;
	if(document.forms[0].gen_flag.value=='G')	   
	{																				 
		if(document.forms[0].exec_nature.value=='T' )								 	  
		{			
		   	parent.frames[1].document.forms[0].downloadApi.disabled=false;  							 
		}
		//parent.frames[0].document.location.href='../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=YYYYY&desktopFlag=N','XH_J_INBOUND_DATA_MAPPING'; 
		parent.frames[0].document.location.href='../eCommon/jsp/commonToolbar.jsp?'+qryString,'XH_J_INBOUND_DATA_MAPPING';
	}			
	else																			  
	{		
	
		if(document.forms[0].fun_id.value==''||document.forms[0].fun_id.value==null)	    
		{
		//	if(document.forms[0].devconf_flag=='true'){
				//parent.frames[0].document.location.href="../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=NYYNY";
				parent.frames[0].document.location.href="../eCommon/jsp/commonToolbar.jsp?"+qryString;
		//	}
		}													  
		else																							    
		{														    
						
				if(document.forms[0].fun_id.value=='SWTCHEVENT')
				{	
					//parent.parent.frames[0].document.location.href='../../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=NYNNN&desktopFlag=N&home_required_yn=N','XH_J_INBOUND_DATA_MAPPING';
					parent.parent.frames[0].document.location.href='../../eCommon/jsp/commonToolbar.jsp?'+qryString,'XH_J_INBOUND_DATA_MAPPING';
				}
				else
				{ 			
					//parent.frames[0].document.location.href='../eCommon/jsp/commonToolbar.jsp?&function_type=F&access=YYYNN&desktopFlag=N','XH_J_INBOUND_DATA_MAPPING';
					parent.frames[0].document.location.href='../eCommon/jsp/commonToolbar.jsp?'+qryString,'XH_J_INBOUND_DATA_MAPPING';
				}
		}
						
	}								   
}
</script>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>
											   
</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="formLoad()">
<form>
<p align="left">																					    
<%
																						    
	String result=(String)request.getParameter( "message" );
	String gen_flag=XHDBAdapter.checkNull((String)request.getParameter("gen_flag")); 			  
	String exec_nature=XHDBAdapter.checkNull((String)request.getParameter("exec_nature"));  
	String fun_id=XHDBAdapter.checkNull((String)request.getParameter("fun_id"));   
	String devconf_flag=XHDBAdapter.checkNull((String)request.getParameter("devconf_flag"));   
	
	String queryString = session.getValue("queryString").toString();

	//System.out.println("result 19"+result);												 
	//System.out.println("gen_flag :"+gen_flag);		   
 															  		 	   					 
%>
<%=result%>									    
</p>	
<input type=hidden name="fun_id" id="fun_id" value="<%=fun_id%>">    
<input type=hidden name="gen_flag" id="gen_flag" value="<%=gen_flag%>"> 
<input type=hidden name="exec_nature" id="exec_nature" value="<%=exec_nature%>"> 	 
<input type=hidden name="devconf_flag" id="devconf_flag" value="<%=devconf_flag%>">
<input type=hidden name="queryString" id="queryString" value="<%=queryString%>"> 	 
</form>
</BODY>															  
</html>																						 		 

