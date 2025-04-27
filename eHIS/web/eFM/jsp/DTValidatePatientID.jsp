<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<SCRIPT language='javascript' src='../../eCommon/js/CommonCalendar.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eFM/js/FMDocumentFolder.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
		function doDateCheckFrom(from,today) 
		{ //args objects 1st is this object & second is the date object
			if(from.value != "")
			{
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) 
				{
					fromarray = fromdate.split("/");
					toarray = todate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) > Date.parse(fromdt)) 
					{
						var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
						parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
						today.focus();
						today.select();
						return false;
					}
					else if(Date.parse(todt) <= Date.parse(fromdt))
					{
						parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?' ;
						return true;
					}
				}
				return true;
			}
			return true;
		}
		function doDateCheckto(from,today) 
		{ //args objects 1st is this object & second is the date object
			if(today.value != "")
			{
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
			
				if(fromdate.length > 0 && todate.length > 0 ) 
				{
					fromarray = fromdate.split("/");
					toarray = todate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) > Date.parse(fromdt)) 
					{
						var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
						parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
						from.focus();
						from.select();
						return false;
					}
					else if(Date.parse(todt) <= Date.parse(fromdt))
					{
						parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?' ;
						return true;
					}
				}
				return true;
			}
			return true;
		}
		function CheckSystemDateLesser(from,today) 
		{ //args objects 1st is this object & second is the date in dd/mm/yyyy
			if(today != "" && from.value !="" )
			{
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
					fromarray = fromdate.split("/");
					toarray = todate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt))
					{//var msg ="APP-FM0041 Date Entered should be lesser than System Date"
						var msg = getMessage("DATE_LESS_SYS_DATE","FM");
						parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
						from.focus();
						from.select();
						return false;
					}
					else if(Date.parse(todt) >= Date.parse(fromdt))
					{
						parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?' ;
						return true;
					}
				}
				return true;
			}
			return true;
		}
	</SCRIPT>
</HEAD>
<BODY onKeyDown = 'lockKey()'>
<%
	Connection conn	 = null;
	try
	{
		conn				= ConnectionManager.getConnection(request);
		String patient_id		= request.getParameter("patient_id");  
		String facility_id		= request.getParameter("facility_id"); 
		String from				= request.getParameter("from"); 
		String to				= request.getParameter("to"); 
		String doc_folder_type	= request.getParameter("doc_folder_type"); 

		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(facility_id == null || facility_id.equals("null"))
			facility_id = "";
		if(from == null || from.equals("null"))
			from = "";
		if(to == null || to.equals("null"))
			to = "";
		if(doc_folder_type == null || doc_folder_type.equals("null"))
			doc_folder_type = "";

		if(doc_folder_type.equals("P"))
		{
			if(!patient_id.equals(""))
			{
				webbeans.op.PatientData patdata = new webbeans.op.PatientData();
				patdata.setFacility_id(facility_id);
				String patient_status = patdata.CheckStatus(conn,patient_id);
				if(patient_status.equals("INVALID_PATIENT"))
				{
%>
					<SCRIPT>
						var msg = getMessage('INVALID_VALUE','Common'); 
						msg = msg.replace('#',getLabel('Common.patientId.label','Common'));
						alert(msg);
						parent.frames[1].document.forms[0].patient_id.select();
					</SCRIPT>
<%
				}
				else
				{
%>					<SCRIPT>
						parent.frames[1].document.forms[0].doc_folder_type.disabled = false;	
						parent.frames[1].document.forms[0].action="../../servlet/eFM.FMDocumentFolderServlet";
						parent.frames[1].document.forms[0].method="post";
						parent.frames[1].document.forms[0].target="messageFrame";
						parent.frames[1].document.forms[0].submit();
					</SCRIPT>
<%
				}
			}
		}
		else if(doc_folder_type.equals("D"))
		{
%>			<SCRIPT>
				var from = parent.frames[1].document.forms[0].from;
				var to = parent.frames[1].document.forms[0].to;
				
				if((doDateCheckFrom(to,from)))
				{
					parent.frames[1].document.forms[0].doc_folder_type.disabled = false;	
					parent.frames[1].document.forms[0].action="../../servlet/eFM.FMDocumentFolderServlet";
					parent.frames[1].document.forms[0].method="post";
					parent.frames[1].document.forms[0].target="messageFrame";
					parent.frames[1].document.forms[0].submit();
				}
			</SCRIPT>
<%
		}
%>
		<SCRIPT>
			parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		</SCRIPT>
<%
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
%>
</BODY>
</HTML>

