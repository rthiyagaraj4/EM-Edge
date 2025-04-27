
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.net.*,java.text.*,java.io.*,ecis.utils.*,eCommon.Common.*,webbeans.eCommon.*,com.ehis.util.*,java.util.HashMap, java.util.ArrayList" %>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

<script language="javascript">
	//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022
	var reportURL='';
	//function to get the specific value from the String
	function param_val(url,name) {
		if(url !== undefined && url !== null ) {
			return (url.split(name + '=')[1] || '').split('+')[0];
		}
	}
	async function callReportOptionsFrameset( params,reportServerEnableFlag,report_option) {
		
		var url		= "../../eCommon/jsp/report_options_frameset.jsp?"+params ;
		/*
		var dialogHeight	= "11" ;
		var dialogWidth	= "25" ;
		*/
		var dialogTop = "10px" ; ///added by vijayan
		var dialogHeight	="220px";
		var dialogWidth	= "340px";
		
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	
		reportURL 	= await window.showModalDialog( url, arguments, features ) ;
		var report_option_val=param_val(reportURL,"REPORT_OPTION");
		var file_dir =param_val(reportURL,"desname");
		var file_name =param_val(reportURL,"filename");
		if ( reportURL != null ) {  // try this as a an ajax submission ----
		//Check the Report Server Post Method is enabled in SM Function control
			if(reportServerEnableFlag=='Y')
			{
				//IF it is View mode ,Form is submitted in below format
				if(report_option_val  == "V")
				{
					var form = document.createElement('FORM');
					form.method='POST';
					form.action = 'report_open.jsp';
					form.target = '_self';
					//form.style = 'width: 100%';
					var input = document.createElement("INPUT");
					input.name = "report_option";
					input.type = "hidden";
					input.value = report_option_val;
					form.appendChild(input);
					var input1 = document.createElement("INPUT");
					input1.name = "report_url";
					input1.type = "hidden";
					input1.value = reportURL;
					form.appendChild(input1);
					var input2 = document.createElement("INPUT");
					input2.name = "file_dir";
					input2.type = "hidden";
					input2.value = file_dir;
					form.appendChild(input2);
					var input3 = document.createElement("INPUT");
					input3.name = "file_name";
					input3.type = "hidden";
					input3.value = file_name;
					form.appendChild(input3);
					document.body.appendChild(form);	
					form.submit();
				}
				else 
				{
					//IF it is File or Printer mode ,Form is submitted in below format
					var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='report_server_form1' id='report_server_form1' method='post' action='report_open.jsp'><input name='report_option' id='report_option' type='hidden' value='"+report_option_val+"'><input name='report_url' id='report_url' type='hidden' value='"+reportURL+"'><input name='file_dir' id='file_dir' type='hidden' value='"+file_dir+"'></form></body></html>";	
					document.body.insertAdjacentHTML('afterbegin', HTMLVal);
					document.report_server_form1.submit();	
				}
			}
			else
			{
				reportURL		= "report_process.jsp?" + reportURL ;
				var myBars 		= 'directories=no,location=no,menubar=no' ;
				//var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
				var myOptions 	= 'width=1500px !important, height=750px !important, resizable=yes' ; //Maheshwaran K modified as on 19-11-2021 for MOHE-SCF-0147
				var myFeatures 	= myBars + ', ' + myOptions ;
	
				var reportWindow 	= open( reportURL, '_blank', myFeatures ) ;
	
				reportWindow.title= "Medicom Report Viewer" ;
				reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
				reportWindow.moveTo( 0,0 ) ;
				reportWindow.focus() ;
			}
		}
	}
</script>
<body CLASS='MESSAGE' onKeyDown = 'lockKey()' style="width:100 !important %;height:100% !important;">

<%
request.setCharacterEncoding("UTF-8");
	String params		= request.getQueryString() ;
	String report_option	= request.getParameter( "report_option" ) ;
	String destype	= request.getParameter( "destype" ) ;
	//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022
	Connection con=null;
	String reportServerEnableFlag="";		
	try 
		{
		con	= ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		}
	catch(Exception e)
		{
		e.printStackTrace();	
		}
	finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
	//End
	if ( params == null ) params = "" ;
	out.println( "<script language=\"JavaScript\"> callReportOptionsFrameset(\"" + java.net.URLDecoder.decode(params) + "\",\"" +reportServerEnableFlag+ "\",\"" +report_option+ "\" )</script>" ) ;
	//Ends MOHE-SCF-0147
/*
	String url			= "../../eCommon/jsp/report_options_frameset.jsp?" + params ;
	String dialogHeight	= "11" ;
	String dialogWidth	= "20" ;

	out.println( "<script language='JavaScript'>" ) ;
	out.println( "window.name = 'report_options'" )  ;
	out.println( "var url 		= '" + url + "'" ) ;
	out.println( "var arguments 	= ''" ) ;
	out.println( "var features	= 'dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"'" ) ;
	out.println( "window.showModelessDialog( url, arguments, features )" ) ;
//	out.println( "alert( 'Report URL = ' + reportURL + ');" ) ;
	out.println( "</script>" ) ;
*/

/*
	String queryString	= request.getQueryString() ;
	

	String level 		= request.getParameter( "level" ) ;
	String url			= "report_options_form.jsp?level=1" ;
	String dialogHeight	= "8" ;
	String dialogWidth	= "20" ;

	if ( queryString == null ) queryString = "" ;
	if ( level == null ) level = "1" ;
	if ( report_option == null ) report_option = "" ;

//	out.println( "<script language='JavaScript'>alert( '" + queryString + "' );</script>" ) ;

	if ( level.equals( "1" ) ) {
		if ( !queryString.equals( "" ) )
			url = url + "?" + queryString ;

		out.println( "<script language='JavaScript'>" ) ;
		out.println( "window.name = 'report_options'" )  ;
		out.println( "var url 		= '" + url + "'" ) ;
		out.println( "var arguments 	= ''" ) ;
		out.println( "var features	= 'dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"'" ) ;
		out.println( "window.showModelessDialog( url, arguments, features )" ) ;
		out.println( "</script>" ) ;
	}

 	if ( level.equals( "2" ) ) {
		if ( report_option.equals( "F" ) ) {
			url = "report_options_form.jsp?level=2&report_option=F" ;

			if ( !queryString.equals( "" ) )
				url = url + "?" + queryString ;

			dialogHeight = "12" ;
			dialogWidth = "30" ;

			out.println( "<script language='JavaScript'>" ) ;
			out.println( "window.name = 'report_options'" )  ;
			out.println( "var url 		= '" + url + "'" ) ;
			out.println( "var arguments 	= ''" ) ;
			out.println( "var features	= 'dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"'" ) ;
			out.println( "window.showModelessDialog( url, arguments, features )" ) ;
			out.println( "</script>" ) ;
		} else {
			out.println( "To be re-directed to Report Server ) " ) ;
			out.println( queryString ) ;
		}
	}
*/
%>

</body>

