<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'></link> 
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='javascript' src='../../eXH/js/CommnSettingsForApplication.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="onLoadOfpage()">
<%
String APPLICATION_ID="";         
String INBOUND_YN="";
String INBOUND_COMM_MODE="";
String INBOUND_DIRECTORY="";      
String INBOUND_ACK_TYPE="";

String PROCESSING_ID="";          
String FILTER_RULE_TYPE="";
String OUTBOUND_YN="";                    
String OUTBOUND_COMM_MODE="";             
String OUTBOUND_DIRECTORY="";             
String OUTBOUND_IP_ADDRESS="";            
String OUTBOUND_PORT_NUMBER="";           
String OUTBOUND_ACK_TYPE="";              
String OUTBOUND_RETRY_INTERVAL="";        
String OUTBOUND_MAXIMUM_RETRIES="";
String FACILITY_ID="";
String AUTOMATIC_RESTART_TYPE=""; 
String AUTOMATIC_RESTART_TIME=""; 

ResultSet rs1=null;
ResultSet rs2=null;
Statement stmt1=null;
Statement stmt2=null;
Connection con=null;

String mode=request.getParameter("mode");
try
{
con=ConnectionManager.getConnection();
}
catch(Exception ex){
ex.printStackTrace(System.err);
}
if(mode.equals("U"))
{
APPLICATION_ID=request.getParameter("appl_name");
FACILITY_ID=request.getParameter("facility");

String sql1="SELECT PROCESSING_ID,FILTER_RULE_TYPE,OUTBOUND_YN,OUTBOUND_COMM_MODE,OUTBOUND_DIRECTORY,OUTBOUND_IP_ADDRESS,OUTBOUND_PORT_NUMBER,OUTBOUND_ACK_TYPE,OUTBOUND_RETRY_INTERVAL,OUTBOUND_MAXIMUM_RETRIES,AUTOMATIC_RESTART_TYPE,TO_CHAR(AUTOMATIC_RESTART_TIME,'HH24:MI') FROM XH_APPL_FOR_FACILITY WHERE APPLICATION_ID='"+APPLICATION_ID+"' AND FACILITY_ID='"+FACILITY_ID+"'";

String sql2="SELECT INBOUND_YN,INBOUND_COMM_MODE,INBOUND_DIRECTORY,INBOUND_ACK_TYPE FROM XH_APPL_FOR_INBOUND WHERE APPLICATION_ID='"+APPLICATION_ID+"'";
	try
	{
		
		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);
		stmt2=con.createStatement();
		rs2=stmt2.executeQuery(sql2);
		if(rs1.next())
		{
			PROCESSING_ID=rs1.getString(1);          
			FILTER_RULE_TYPE=rs1.getString(2);
			OUTBOUND_YN=rs1.getString(3);                    
			OUTBOUND_COMM_MODE=rs1.getString(4);             
			OUTBOUND_DIRECTORY=rs1.getString(5);             
			OUTBOUND_IP_ADDRESS=rs1.getString(6);            
			OUTBOUND_PORT_NUMBER=rs1.getString(7);           
			OUTBOUND_ACK_TYPE=rs1.getString(8);              
			OUTBOUND_RETRY_INTERVAL=rs1.getString(9);        
			OUTBOUND_MAXIMUM_RETRIES=rs1.getString(10);
			AUTOMATIC_RESTART_TYPE=rs1.getString(11);
			AUTOMATIC_RESTART_TIME=rs1.getString(12);
		}
		if(OUTBOUND_DIRECTORY==null) OUTBOUND_DIRECTORY="";
		if(OUTBOUND_IP_ADDRESS==null) OUTBOUND_IP_ADDRESS="";
		if(OUTBOUND_PORT_NUMBER==null) OUTBOUND_PORT_NUMBER="";
		if(OUTBOUND_RETRY_INTERVAL==null) OUTBOUND_RETRY_INTERVAL="";
		if(OUTBOUND_MAXIMUM_RETRIES==null) OUTBOUND_MAXIMUM_RETRIES="";
		if(AUTOMATIC_RESTART_TYPE==null) AUTOMATIC_RESTART_TYPE="";
		if(AUTOMATIC_RESTART_TIME==null) AUTOMATIC_RESTART_TIME="";
		if(rs2.next())
		{
			INBOUND_YN=rs2.getString(1);
			INBOUND_COMM_MODE=rs2.getString(2);
			INBOUND_DIRECTORY=rs2.getString(3);     
			INBOUND_ACK_TYPE=rs2.getString(4);

       	}
		if(INBOUND_DIRECTORY==null) INBOUND_DIRECTORY="";


	}catch(Exception e1)
	{
		System.out.println("(CommunicationSettingForAppl.jsp:Exception-1) : "+e1.toString());
	}
	
	finally{
			try{
					if(rs1!=null)rs1.close();
					if(rs2!=null)rs2.close();
					if(stmt1!=null) stmt1.close();
					if(stmt2!=null) stmt2.close();
									
				}catch(Exception e)
				{
				out.println("Exception is "+e);
				}		
			}//end of finally block
}//end of mode=U
%>
<form name="CommmnSettingsAppl" id="CommmnSettingsAppl" id="CommmnSettingsAppl"  target='messageFrame' method='post' action='../../servlet/eXH.CommunicationSettingsForApplServlet'>
<table cellspacing=0 cellpadding=3 width='100%' align=center >
<tr><td class=label ><fmt:message key="eXH.Application.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name=appl_name id=appl_name  title='Application' onchange='check_status_appl(this);'>
<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
<%
String sql3="SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW WHERE IN_USE_YN='Y' AND LANGUAGE_ID='"+locale+"' ORDER BY APPLICATION_ID";
ResultSet rs3=null;
Statement stmt3=null;

String sql4="SELECT A.FACILITY_ID,B.FACILITY_NAME FROM XH_PARAM_FOR_FACILITY A ,SM_FACILITY_PARAM_LANG_VW B WHERE A.FACILITY_ID=B.FACILITY_ID AND LANGUAGE_ID='"+locale+"' ORDER BY FACILITY_ID";
ResultSet rs4=null;
Statement stmt4=null;
try
	{
	stmt3=con.createStatement();
	rs3=stmt3.executeQuery(sql3);
	while(rs3.next())
		{
	%>	
			<option value='<%=rs3.getString(1)%>' <%=rs3.getString(1).equals(APPLICATION_ID)?"selected":""%>><%=rs3.getString(2)%></option>
	<%		
		}
	%>
		</select><img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>	
	<%
	}catch(Exception e1)
	{
		System.out.println("(CommunicationSettingForAppl.jsp:Exception-2) : "+e1.toString());
	}
	finally{
			try{
					if(rs3!=null)rs3.close();
					if(stmt3!=null) stmt3.close();
				
				}catch(Exception e)
				{
				out.println("Exception is "+e);
				}

			}//end of finally block
%>
<tr><td class=label ><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
	<td class='fields'><select name =facility  title='Facility' onchange='check_status_fac(this);'>
	<option value=''>----------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>--------</option>
<%
try
	{
		stmt4=con.createStatement();
		rs4=stmt4.executeQuery(sql4);
		while(rs4.next())
		{
	%>	
			<option value='<%=rs4.getString(1)%>' <%=rs4.getString(1).equals(FACILITY_ID)?"selected":""%>><%=rs4.getString(2)%></option>
	<%	
		}
	%>
		</select><img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>
	
	<%
	}catch(Exception e1)
	{
		System.out.println("(CommunicationSettingForAppl.jsp:Exception-3) : "+e1.toString());
	}
	finally{
			try{
					
					if(rs4!=null)rs4.close();
					if(stmt4!=null) stmt4.close();
					if(con!=null) con.close();
				}catch(Exception e)
				{
				out.println("Exception is "+e);
				}
			}//end of finally block
%>
<tr>
<td class=label><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name='out_use' id='out_use' <%=OUTBOUND_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=OUTBOUND_YN.equals("Y")?"Y":"N"%>' onChange="onLoadOfpage();" onBlur="onLoadOfpage();"></td></tr>

<tr>
	<td class=label><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=checkbox name='in_use' id='in_use' <%=INBOUND_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=INBOUND_YN.equals("Y")?"Y":"N"%>' onChange="onLoadOfpage()" onBlur="onLoadOfpage();"></td></tr>
</table>
<!----------------------------------OUTBOUND APPLICATION  --------------------------------->
<div id='outbounddiv' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td class='CAGROUP' colspan=2 align=left><font color=blue><fmt:message key="eXH.OutboundSettings.Label" bundle="${xh_labels}"/></font></td>
</tr>
<tr></tr>
<tr>
<td class='COLUMNHEADER' colspan=2 ><fmt:message key="eXH.MessageHeaderSegmentSettings.Label" bundle="${xh_labels}"/></td>
</tr>

<tr>
<td class=label><fmt:message key="eXH.ProcessingID.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='proc_id' >
<option value='P' <%=PROCESSING_ID.equals("P")?"selected":""%>><fmt:message key="eXH.Production.Label" bundle="${xh_labels}"/></option>
<option value='T' <%=PROCESSING_ID.equals("T")?"selected":""%>><fmt:message key="eXH.Training.Label" bundle="${xh_labels}"/></option>
<option value='D' <%=PROCESSING_ID.equals("D")?"selected":""%>><fmt:message key="eXH.Debugging.Label" bundle="${xh_labels}"/></option>
</select>
</td></tr>

<tr>
<td class=label><fmt:message key="eXH.AcknowlegementType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='out_ack_type' >
<option value='NE' <%=OUTBOUND_ACK_TYPE.equals("NE")?"selected":""%>><fmt:message key="eXH.Never.Label" bundle="${xh_labels}"/></option>
<option value='AL' <%=OUTBOUND_ACK_TYPE.equals("AL")?"selected":""%>><fmt:message key="eXH.Always.Label" bundle="${xh_labels}"/></option>
<option value='ER' <%=OUTBOUND_ACK_TYPE.equals("ER")?"selected":""%>><fmt:message key="eXH.ErrorReject.Label" bundle="${xh_labels}"/></option>
</select>
</td></tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
<td class='COLUMNHEADER'  colspan=2 ><fmt:message key="eXH.CommunicationSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
<td class=label><fmt:message key="eXH.CommunicationMode.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='out_comm_mode' onchange='change_outbound_comm_mode();'>
<option value='T' <%=OUTBOUND_COMM_MODE.equals("T")?"selected":""%>><fmt:message key="eXH.TCPIP.Label" bundle="${xh_labels}"/></option>
<option value='F' <%=OUTBOUND_COMM_MODE.equals("F")?"selected":""%>><fmt:message key="eXH.ASCIIFile.Label" bundle="${xh_labels}"/></option>
</select>
</td></tr>
<tr>
<td class=label><fmt:message key="eXH.AutomaticRestart.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='auto_restart_type'>
<option value='A' <%=AUTOMATIC_RESTART_TYPE.equals("A")?"selected":""%>><fmt:message key="eXH.At.Label" bundle="${xh_labels}"/></option>
<option value='E' <%=AUTOMATIC_RESTART_TYPE.equals("E")?"selected":""%>><fmt:message key="eXH.Every.Label" bundle="${xh_labels}"/></option>
</select> <input type=text name ='auto_restart_time' size=6 value='<%=AUTOMATIC_RESTART_TIME%>' maxlength=5 onblur='checkt(this);'  onkeypress='checkFormat(this)' onChange='checkFormat(this);'>
</td></tr>
<tr id='outbound_file' style="display:none">
<td class=label><fmt:message key="eXH.OutboundDirectoryName.Label" bundle="${xh_labels}"/></td>
<td  class='fields'><input type=text name ='out_dir_name' size=50 value='<%=OUTBOUND_DIRECTORY%>'></td></tr>
<tr id='outbound_tcp_ip_addr' style='display:none'>
<td class=label><fmt:message key="eXH.TCPIPAddress.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name ='out_tcp_addr' size=16 value='<%=OUTBOUND_IP_ADDRESS%>' onblur='checkIpAddress(this)'> <img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>
<tr id='outbound_tcp_ip_port' style='display:none'>
<td class=label><fmt:message key="eXH.Port.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name ='out_port_num' size=4 value='<%=OUTBOUND_PORT_NUMBER%>' onblur='checkValid(this)'> <img src='../../eCommon/images/mandatory.gif' align=middle></td> </tr>
<tr id='outbound_tcp_retry_interval' style='display:none'>
<td class=label><fmt:message key="eXH.RetryInterval.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name ='re_try_time' size=5 value='<%=OUTBOUND_RETRY_INTERVAL%>' maxlength=4
onblur='check(this)'></td></tr>
<tr id='outbound_tcp_ip_max_retries' style='display:none'>
<td class=label><fmt:message key="eXH.MaximumRetries.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name ='max_re_try' size=5 value='<%=OUTBOUND_MAXIMUM_RETRIES%>' maxlength=4 onblur='checkNumber(this)'></td></tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<script>
	disp_outbound_comm_settings();
</script>
<tr>
<td class='COLUMNHEADER' colspan=2 ><fmt:message key="eXH.Filtering.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.FilterRuleType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='filter_rule_type' >
<option value='R' <%=FILTER_RULE_TYPE.equals("R")?"selected":""%>><fmt:message key="eXH.Restricted.Label" bundle="${xh_labels}"/></option>
<option value='U' <%=FILTER_RULE_TYPE.equals("U")?"selected":""%>><fmt:message key="eXH.Unrestricted.Label" bundle="${xh_labels}"/></option>
</select>
</td></tr>
<tr>
	<td width='30%'></td>
	<td width='70%'></td>
</tr>
</table>
</div>	
<!-------------------------------  THE INBOUND ------------------------------------->
<div id='inbounddiv' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
<td class='CAGROUP' colspan=2 align=left><font color=blue><fmt:message key="eXH.InboundSettings.Label" bundle="${xh_labels}"/></font></td>
</tr>
<tr></tr>
<tr>
<td class='COLUMNHEADER' colspan=2 ><fmt:message key="eXH.MessageHeaderSegmentSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.AcknowlegementType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='in_ack_type' >
<option value='NE' <%=INBOUND_ACK_TYPE.equals("NE")?"selected":""%>><fmt:message key="eXH.Never.Label" bundle="${xh_labels}"/></option>
<option value='AL' <%=INBOUND_ACK_TYPE.equals("AL")?"selected":""%>><fmt:message key="eXH.Always.Label" bundle="${xh_labels}"/></option>
<option value='ER' <%=INBOUND_ACK_TYPE.equals("ER")?"selected":""%>><fmt:message key="eXH.ErrorReject.Label" bundle="${xh_labels}"/></option>
</select>
</td></tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
<td class='COLUMNHEADER' colspan=2 ><fmt:message key="eXH.CommunicationSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.CommunicationMode.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='in_comm_mode' onchange='change_inbound_comm_mode();' >
<option value='T' <%=INBOUND_COMM_MODE.equals("T")?"selected":""%>><fmt:message key="eXH.TCPIP.Label" bundle="${xh_labels}"/></option>
<option value='F' <%=INBOUND_COMM_MODE.equals("F")?"selected":""%>><fmt:message key="eXH.ASCIIFile.Label" bundle="${xh_labels}"/></option>
</select>
</td></tr>
<tr id='inbound_file' style='display:none'>
<td class=label ><fmt:message key="eXH.InboundDirectory.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name ='in_dir_name' size=50 value='<%=INBOUND_DIRECTORY%>' OnBlur="validDir(this)"></td></tr>
<script>
disp_inbound_comm_settings();
</script>
<tr>
	<td width='30%'></td>
	<td width='70%'></td>
</tr>
</table>
</div>
<!---------------------------     END OF INBOUND --------------------------------------->
<input type=hidden name='tab_mode' id='tab_mode' value=<%=mode%>>		
<input type=hidden name='update_mode_appl' id='update_mode_appl' value=<%=APPLICATION_ID%>>	
<input type=hidden name='update_mode_fac' id='update_mode_fac' value=<%=FACILITY_ID%>>
<input type=hidden name='mode' id='mode' value=<%=mode%>>	
</form>	
</BODY>
</HTML>

