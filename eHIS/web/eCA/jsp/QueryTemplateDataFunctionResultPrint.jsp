<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String facility_id = session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String qryDesc = request.getParameter("qryDesc")==null?"":request.getParameter("qryDesc");
	String site_name = "";
	String facility_name = "";
	
	QueryTemplateDataFunctionBean qryDataBean = (QueryTemplateDataFunctionBean)getObjectFromBean("qryDataBean","eCA.QueryTemplateDataFunctionBean",session);
	
	String sys_date_time	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale); 

	List<String> resObj = qryDataBean.getQueryResults(); 
	Map<String,String> dateCompMap = (HashMap<String,String>)qryDataBean.getDateCompWithDesc();  //IN057467
	Set<String> datecompKey = null;  //IN057467
	Integer totalColumns = 8;//IN057467
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;	
	try
	{
		String sqlQry = "SELECT site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?";
		con = ConnectionManager.getConnection();
		pst = con.prepareStatement(sqlQry);
		pst.setString(1, locale);
		rs = pst.executeQuery();

		if(rs.next())
		{
			site_name = rs.getString(1) == null ? "" : rs.getString(1);
		}

		if (rs != null)
		{
			rs.close();
		}

		if (pst != null)
		{
			pst.close();
		}


		sqlQry = "select facility_name from sm_facility_param where facility_id = ?";
		con = ConnectionManager.getConnection();
		pst = con.prepareStatement(sqlQry);
		pst.setString(1, facility_id);
		rs = pst.executeQuery();

		if(rs.next())
		{
			facility_name = rs.getString(1) == null ? "" : rs.getString(1);
		}

		if (rs != null)
		{
			rs.close();
		}

		if (pst != null)
		{
			pst.close();
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(con != null)
			{
				con.close();
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

%>
<html>
<head>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<style>
		.printData
		{
			background-color: #FFFFFF;
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #000000;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:0px;
			vertical-align:middle;
			border-bottom:0px;
			border-top:0px;
			border-left:0px;
			border-right:0px;
			border-style:normal;
			border-color:#EEEEEE;
		}

		.printHeader
		{
			height:20px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #000000;
			font-weight:bold;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:top;
		}

	</style>	
	<title><fmt:message key="Common.PrintPreview.label" bundle="${common_labels}"/></title>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script>
	function SysPreview()
	{
		var OLECMDID = 7;
		var PROMPT =2;
		
		try
		{
			var oWebBrowser = document.getElementById("WebBrowser1");

			if(oWebBrowser == null)
			{
				var sWebBrowser = '<OBJECT ID = "WebBrowser1" width = 0 height =0 CLASSID ="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"> </OBJECT>';

				document.body.insertAdjacentHTML('beforeend',sWebBrowser);

				oWebBrowser = document.getElementById("WebBrowser1");
			}
			
			oWebBrowser.ExecWB(OLECMDID,PROMPT,null,null);
		}
		catch (e)
		{
			alert("Failed");
		}
	}
	function setHeader()
	{
		t = new ActiveXObject("WScript.Shell"); 
						
		temp_hdr=t.RegRead("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header");
		temp_foot=t.RegRead("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer");					 var pat_info1="Preliminary Report";
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header",pat_info1+" &bPage &p of &P" ); 
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer",  pat_info1+"&b&d")	
	}

	function theEnd()
	{
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header"," &bPage &p of &P" ); 
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer",  "&u&b&d");
		window.close();
	}

	</script>
	
 </head>
 <!-- <body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "setHeader(); PrintDoc();" onUnload = "theEnd();"> -->
 <body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "PrintDoc();" onUnload = "">
	<form>
	<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >
		<tr>
			<td align='center' width='5%' id='headerImageID'>
				<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'>
			</td>
			<td  align="center"><h3><%=site_name%></h3></td>
			<td  align="right"><%=sys_date_time%></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td align="center"><h3><%=facility_name%></h3></td>
			<td >&nbsp;</td>
		</tr>
		<tr>
			<td width='5%'>&nbsp;</td>
			<td align="center"><h4><%=qryDesc%></h4></td>
			<td >&nbsp;</td>
		</tr>
	 </table>
	 <br>
	 <br>
	<table width='100%' cellpadding='3' cellspacing='0' border='0' id='tblCrc' name='tblCrc' id='tblCrc'>
		<!-- IN057467 Start.-->
		<tr>
			<td colspan="<%=totalColumns%>" id="THead"><hr/></td>
		</tr>
		<!-- IN057467 end.-->
		<tr>
			<td class='printHeader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="Common.DOB.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='printHeader'><fmt:message key="eCA.NumberofOccurrences.label" bundle="${ca_labels}"/></td>
			<%
				//IN057467 start.
				if(dateCompMap!=null){
					if(dateCompMap.keySet().size()>0){
						datecompKey = dateCompMap.keySet();
						for (String key : datecompKey)
						{						
							%><td class='printHeader'><%=((String)dateCompMap.get(key))%></td><%
							totalColumns++;
						}
					}
				}
				//IN057467 End.
			%>
		</tr>
		<tr>
		<td colspan="<%=totalColumns%>"><hr/></td>
		</tr>
		<%
			Set<String> ptCnt = new HashSet<String>();
			if(resObj != null)
			{
				for(String str : resObj)
				{%>

				<tr>
				<%
					String []st = str.split("`~");
					ptCnt.add(st[0]);
					//IN057467 Start.
					//for(int i = 0; i < st.length; i++)
					//{
					%>
						<td class='gridData' ><%=st[0]%></td>
						<td class='gridData' ><%=st[1]%></td>
						<td class='gridData' ><%=st[2]%></td>
						<td class='gridData' ><%=st[3]%></td>
						<td class='gridData' ><%=st[4]%></td>
						<td class='gridData' ><%=st[5]%></td>
						<td class='gridData' ><%=st[6]%></td>
						<td class='gridData' ><%=st[7]%></td>					
					<%//}
						if(dateCompMap!=null){
							for (String key : datecompKey)
							{
								if(key.equals(st[9])){
									%><td class='gridData' ><%=st[8]%></td><%
								}else{
									%><td class='gridData' >&nbsp;</td><%
								}
							}
						}
						//IN057467 End.
					%>
				</tr>
				<%
				}
			}
		%>
		<tr>
			<td colspan="<%=totalColumns%>"><hr/></td>
		</tr>
		</table>		
		
		<table width='100%' cellpadding='3' cellspacing='0' border='0' id='tblCrc' name='tblCrc' id='tblCrc'>
		<tr>		
			<td class='printData' colspan='<%=totalColumns%>'><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/>:&nbsp;<%=ptCnt.size()%> </td>
		</tr>
		<%
			ptCnt = null;
		%>
	</table>	
	</form>
	<script language='javascript'>
		document.getElementById("THead").colSpan = "<%=totalColumns%>";
		async function PrintDoc()
		{
			var i = 0
			var res = confirm('Continue printing?');
			if(res)
			{
				while( i < document.applets.length ) 
				{
					var j = 0 ;
					while ( !document.applets[i].isActive() && j++ <=75000 ) 
						window.status = i;
					i++;
				}
				await window.print();
				//SysPreview();
			
			}
			setTimeout(function() {
				window.close();	
			}, 1000);
			
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </body>
 
 </html>
 

