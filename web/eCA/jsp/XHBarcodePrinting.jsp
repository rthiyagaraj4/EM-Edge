<!DOCTYPE html>
<!--[if IE 6]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if IE 7]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if gte IE 7]>  
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<![endif]-->

<%@ page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.io.*,java.net.*,webbeans.eCommon.*,javax.servlet.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>	
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />		
	</head>
	<%	
	StringBuffer htmlData = new StringBuffer();
	
	String barcode = "", itemname = "", batchid = "", expdate = "";
	int printNo = 0;

	String printData = "";
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;

	String notesHtmlData = "";
	String strHtmlData = "";	
	
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	facilityId	= (String)session.getValue("facility_id");
	
	barcode = request.getParameter("barcode")==null?"":request.getParameter("barcode");
	itemname = request.getParameter("itemname")==null?"":request.getParameter("itemname");
	batchid = request.getParameter("batchid")==null?"":request.getParameter("batchid");
	expdate = request.getParameter("expdate")==null?"":request.getParameter("expdate");
	
	/*
		Read from table, CLOB Data.
		printData
	*/
		System.out.println(" Print Data from Table ::: "+printData);
		
		if (printData.length() > 0){
		
			printData =  printData.replace("$barcode$", barcode); 
			printData =  printData.replace("$itemname$", itemname); 
			printData =  printData.replace("$batchid$", batchid); 
			printData =  printData.replace("$expdate$", expdate); 		
		
		}	

		System.out.println(" Print Data after replace ::: "+printData);
		
	
	%>

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>	
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



	<script>
		var docReadyCount = 0;
		var divCount = 0;
		
		function printPage(){
			
			if (<%=printFlag%> == "1")
			{	
				
				docReadyCount = docReadyCount + 1;	
				if (docReadyCount == divCount) 
				{				
					if(PrintCommandObject)
					{		
						try{	
							PrintCommandObject.ExecWB(6,2);
					 		PrintCommandObject.outerHTML = "";
					 		window.close();
					 	}
					 	catch(e){			
					 		window.print();
					 	}
					}
					else{
					 	window.print();
					}
				}
			}
			
		}
			 
		
		$(document).ready(function() {
			
			divCount = document.getElementById("divCount").value;	
			
			if (navigator.appName == "Microsoft Internet Explorer"){			
			 	// attach and initialize print command ActiveX object
				try{
			 		var PrintCommand = '<object id="PrintCommandObject" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" width="0" height="0"></object>';		 		
			 		document.body.insertAdjacentHTML('afterbegin', PrintCommand);
				}
			 	catch(e){}
			}	
				
		});
		
		$(window).load(function() 
		{		
			if (<%=printFlag%> == "1")
			{	
				if (divCount == 0)
				{		
					if(PrintCommandObject)
					{
						try{			
							PrintCommandObject.ExecWB(6,2);
					 		PrintCommandObject.outerHTML = "";
					 		window.close();
					 	}
					 	catch(e){	 		
					 		window.print();
					 	}
					}
					else{
					 	window.print();
					}
				}
			}
		});
		
		function pagePrint(){
			window.print();	
		}
	</script>
	<body>		
		<form name="XHBarcodePrintForm" id="XHBarcodePrintForm">
			<%= printData%>				
		</form>
	</body>
</html>

