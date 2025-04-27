<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.* " %>
<html>
<head>
			<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
      		
<title><fmt:message key="eOP.ConcludeEpisode.label" bundle="${op_labels}"/></title>

	<script>
		function checkMaxLen(obj)
		{
		if (obj.value.length>500)
			{
			    var error = getMessage("REMARKS_CANNOT_EXCEED","COMMON");
				error = error.replace("$",getLabel('Common.notes.label','Common'));
				error = error.replace("#","500");
			    alert(error)
				obj.focus();
			}
		}
			function PutVal()
			{
				var val 	= window.dialogArguments;
	           if(val==null) val='';	
					document.forms[0].conclude_episode_notes.value=val;
				//	if(document.forms[0].Notesprev.value != "")
				//		document.forms[0].conclude_episode_notes.value = document.forms[0].Notesprev.value;
			}
	
			function Okay()
			{
					if(document.forms[0].conclude_episode_notes.value.length < 2)
				 	{
					  var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
						  error = error.replace('$',getLabel('Common.notes.label','Common'));
						  alert(error);
					}
					else
					{
						var addval = new String(addval);
						addval = document.forms[0].notestext.value;
						addval += document.forms[0].conclude_episode_notes.value;
						window.returnValue=addval;
						//window.close();
						const dialogTag = parent.document.getElementById("dialog_tag");    
					    dialogTag.close();
					}
			}
			
			function Close_win()
			{
					window.returnValue="";
					//window.close();
					const dialogTag = parent.document.getElementById("dialog_tag");    
				    dialogTag.close();
			}
	</script>

</head>

<body onLoad='PutVal();FocusFirstElement()' onKeyDown = 'lockKey();'>
<form name="Conclude_episode" id="Conclude_episode">

<%
	//String Encounterid = request.getParameter("Encounter");
	String CnlNotes = request.getParameter("ConcludeNotes");
	
//	CnlNotes=java.net.URLDecoder.decode(CnlNotes,"UTF-8");
	String locale = localeName;
	String service_desc = (request.getParameter("service_desc") == null)?"":request.getParameter("service_desc");

	String start_date = (request.getParameter("visit_adm_date_time") == null)?"":request.getParameter("visit_adm_date_time");

	String end_date = (request.getParameter("sysdate") == null)?"":request.getParameter("sysdate");

	String start_date_display=DateUtils.convertDate(start_date,"DMYHM","en",locale);
	String end_date_display=DateUtils.convertDate(end_date,"DMYHM","en",locale);

	//Statement stmt 	= null;
	//ResultSet rs		 	= null;

	//String fac_id    	= (String) session.getValue( "facility_id" ) ;
	//String sql				="";
	StringBuffer alltext		=new StringBuffer();

				//Connection conn = null;


				%><table border='0' cellpadding='0'cellspacing='0' width='96%' align='center'>
<%

				try
				{
					/*conn=ConnectionManager.getConnection(request);

						stmt = conn.createStatement();
						sql  = "Select c.short_desc service_desc, to_char(a.start_date_time,'dd/mm/yyyy hh24:mi') start_date, "+
					 			 " to_char(sysdate,'dd/mm/yyyy hh24:mi') end_date "+
					 			 " from OP_EPISODE_FOR_SERVICE a, PR_ENCOUNTER b, AM_SERVICE c "+
						 		 " where b.facility_id = '"+fac_id+"' and b.encounter_id = '"+Encounterid+"' and a.patient_id = b.patient_id and a.operating_facility_id = b.facility_id and a.episode_id = b.episode_id and b.service_code = c.service_code";
						rs = stmt.executeQuery(sql);
						rs.next();*/

						alltext.append("Y#");
						%>
						<tr>
							<td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
							<td class='QUERYDATA' colspan=3><%=service_desc%></td>							
						</tr>
						<br>
					<%
					 	alltext.append(service_desc);
						alltext.append("#");
					%>
						<tr>
							<td  colspan='4'>&nbsp;</td>
						</tr>

						<tr>
							<td  class='label' width='20%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
							<td  class='QUERYDATA'><%=start_date_display%></td>
						<%
						alltext.append(start_date);
							alltext.append("#");
					%>
							<td  width='20%' class='label'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
							<td class='QUERYDATA'><%=end_date_display%></td>							
						</tr> 
						<%
						alltext.append(end_date);
							alltext.append("#");
					%>
						<tr>
						<td colspan='4'>&nbsp;</td>
						</tr>
						<%
						
				}
				catch ( Exception e ){ }
				finally
				{
					//if ( stmt != null ) stmt.close() ;
					//if ( rs != null ) rs.close() ;
					//if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}

				%>

				<tr>
					<td class='label' valign=top><fmt:message key="Common.notes.label" bundle="${common_labels}"/>
					<td class='fields' colspan='3' valign=top> <textarea name='conclude_episode_notes' rows=3 cols=47 onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,500)'> </textarea><img src='../../eCommon/images/mandatory.gif' valign='down'></td>
				</tr> 
			</table>
				<!--<br> -->
				 <table border='0' cellpadding='0' cellspacing='0' align=center width='96%'   >
				<tr><td align='right'> <input type='button' class='Button' name='record' id='record' onClick='Okay()' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' ></td><td><input type='button' class='Button' name='cancel' id='cancel' onClick='Close_win()' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'> </td> </tr> </table>
				
				<input type="hidden" name="notestext" id="notestext"  value ='<%=alltext.toString()%>' >
				<input type="hidden" name="Notesprev" id="Notesprev"  value ='<%=CnlNotes%>' >
<%
  alltext.setLength(0);
%>
</form>
</body>
</html>

