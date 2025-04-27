<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*, eXH.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
String resultMessage = XHDBAdapter.checkNull(request.getParameter("message"));
%>

<HEAD>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = ((String)session.getAttribute("LOCALE"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXH/js/InterfaceParam.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script language="JavaScript">

//function validatecheckbox
function validatecheckbox(obj)
{
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";								  
}

//function check_operation
function check_operation(obj)				   
{
	if(obj.checked==true)
	{
		var name1=obj.name;
		var fd=name1.split("_");
		var ob=fd[0]+"_OP_YN";
		if(eval('document.forms[0].'+ob+'.checked')==true) obj.value="Y";
		else
		{
			alert("Check Operational First");
			obj.value="N";
			obj.checked=false;
		}
	}
}
//function reset_options
function reset_options(obj)
{
	if(obj.checked==false)
	{
		var name1=obj.name;
		var fd=name1.split("_");
		eval('document.forms[0].'+fd[0]+"_AUDIT"+'.checked=false');
		eval('document.forms[0].'+fd[0]+"_DEBUG"+'.checked=false');
		eval('document.forms[0].'+fd[0]+"_OUTBOUND"+'.checked=false');
		eval('document.forms[0].'+fd[0]+"_INBOUND"+'.checked=false');
	}
}	

</script>

<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initFunc();">
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String INTERFACE_YN ="";
String MASTER_CODE_MAP_YN="";     
String FILTER_YN="";              
String dbConnectionStr = "";
String TEMPORARY_PURGE_INTERVAL="";
String PERMANENT_PURGE_INTERVAL="";
String dbString[] = new String[3];
String offliePurgeYN = "";
String rec2PurgePerIteration = "";
String autoDispStage = "";

int COMM_PROCESS_IDLE_TIME=0;

try
{
	con=ConnectionManager.getConnection();
	String sql = "SELECT INTERFACE_YN,MASTER_CODE_MAP_YN,FILTER_YN,DB_CONNECT_STRING,COMM_PROCESS_IDLE_TIME ,TEMPORARY_PURGE_INTERVAL,PERMANENT_PURGE_INTERVAL,OFFLINE_PURGE_YN,PURGE_RECORD_COUNT_EACH_LOOP,AUTO_DISP_STAGE FROM XH_PARAM ";
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs!=null && rs.next())
	{
		INTERFACE_YN=rs.getString(1);
		MASTER_CODE_MAP_YN=rs.getString(2);
		FILTER_YN=rs.getString(3);
		dbConnectionStr = rs.getString(4);
		COMM_PROCESS_IDLE_TIME=rs.getInt(5);
		TEMPORARY_PURGE_INTERVAL=rs.getString(6);
		PERMANENT_PURGE_INTERVAL=rs.getString(7);
		offliePurgeYN = rs.getString("OFFLINE_PURGE_YN");
		rec2PurgePerIteration = rs.getString("PURGE_RECORD_COUNT_EACH_LOOP");
		autoDispStage = rs.getString("AUTO_DISP_STAGE");
	}
	System.out.println("autoDispStage ::: "+autoDispStage);

}catch(Exception e)
{
	out.println("InterfaceParamSetupAdmin:General)Exception: "+e.toString());
	e.printStackTrace(System.err);
}
finally{
	try
	{
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
	}
	catch(Exception e)
	{
		out.println("InterfaceParamSetupAdmin:Gfinally)Exception: "+e.toString());
	}
}

if(TEMPORARY_PURGE_INTERVAL == null || TEMPORARY_PURGE_INTERVAL.equals("")) TEMPORARY_PURGE_INTERVAL = "2";
if(PERMANENT_PURGE_INTERVAL == null || PERMANENT_PURGE_INTERVAL.equals("")) PERMANENT_PURGE_INTERVAL = "180";
if(rec2PurgePerIteration == null || rec2PurgePerIteration.equals("")) rec2PurgePerIteration = "";
if(MASTER_CODE_MAP_YN == null) MASTER_CODE_MAP_YN = "";

if(dbConnectionStr !=null)
{
	session.putValue("dbString",dbConnectionStr);
	StringTokenizer st = new StringTokenizer(dbConnectionStr,":");
	for(int i = 0; st.hasMoreTokens(); i++)
	{
		dbString[i] = st.nextToken();			
	}
}
%>
<form name="MasterInterfaceForm" id="MasterInterfaceForm" method='post' action='../../servlet/eXH.AdminInterfaceParamSetupServlet'>

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td colspan="1" class=label><fmt:message key="eXH.EnableInterface.Label" bundle="${xh_labels}"/></td>
	<td colspan="5" ><input type=checkbox name=enable_interface id=enable_interface  <%=INTERFACE_YN.equals("Y")?"checked":""%>  value='<%=INTERFACE_YN.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);'></td>
	
</tr>

<th align=left colspan=6><fmt:message key="Common.general.label" bundle="${common_labels}"/></th>

<tr>
	<td class=label><fmt:message key="eXH.SetupMasterCodeMapping.Label" bundle="${xh_labels}"/></td>	
	<td><input type=checkbox name=setup_master_code id=setup_master_code <%=MASTER_CODE_MAP_YN.equals("Y")?"checked":""%>  value='<%=MASTER_CODE_MAP_YN.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);'></td>
	<td class=label><fmt:message key="eXH.Temporarypurgeinterval.Label" bundle="${xh_labels}"/></td>	
	<td><input type=text name=temp_purge_interval id=temp_purge_interval value='<%=TEMPORARY_PURGE_INTERVAL%>' onBlur="return IsNumericMax(this,'1','7');" onKeyPress="checkMaxLength(this);" maxlength="5" size=5><img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td class=label><fmt:message key="eXH.NoofPurgeRecords.Label" bundle="${xh_labels}"/></td>	
	<td><input type=text name=rec2PurgeIteration id=rec2PurgeIteration value='<%=rec2PurgePerIteration%>' size=5></td>
</tr>
<tr>
	<td class=label><fmt:message key="eXH.EnableEventFiltering.Label" bundle="${xh_labels}"/></td>
	<td><input type=checkbox name=enable_event_filtering id=enable_event_filtering <%=FILTER_YN.equals("Y")?"checked":""%> value='<%=FILTER_YN.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);'></td>
	<td class=label><fmt:message key="eXH.Permanentpurgeinterval.Label" bundle="${xh_labels}"/></td>	
	<td><input type=text name=permanent_purge_interval id=permanent_purge_interval  value='<%=PERMANENT_PURGE_INTERVAL%>' onBlur="IsDecimal(this);IsNumericMax(this,'7');" onKeyPress="checkMaxLength(this);" maxlength="6" size=5></td>
	<td class=label><fmt:message key="eXH.OfflinePurgeYN.Label" bundle="${xh_labels}"/></td>
	<td><INPUT TYPE="checkbox" name="offlinePurgeYN" id="offlinePurgeYN" <%=(offliePurgeYN != null && offliePurgeYN.equals("Y"))?"checked":""%> value="<%=(offliePurgeYN != null && offliePurgeYN.equals("Y"))?"Y":"N"%>" onClick='validatecheckbox(this);'></td>
</tr>
</table>

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td colspan=2 width='40%'></td>
	<td colspan=2 width='60%'></td>
</tr>
<th align=left colspan=4><fmt:message key="eXH.CommunicationProcesSettings.Label" bundle="${xh_labels}"/></th>
<tr>
	<td colspan=2 width='40%'></td>
	<td colspan=2 width='60%'></td>
</tr>
<tr>
	<td colspan=1 class=label><fmt:message key="eXH.DBConnectString.Label" bundle="${xh_labels}"/></td>
	<td colspan=3>
		<INPUT TYPE="text" name="dbConnStr" id="dbConnStr" SIZE="100" title="db_machine:port:sid" VALUE="<%= XHDBAdapter.checkNull(dbConnectionStr) %>">
	</td>
</tr>
<tr>
	<td class=label><fmt:message key="eXH.IdleTime.Label" bundle="${xh_labels}"/></td>
	<%
	String commProcessIdleTime = "";
	if(COMM_PROCESS_IDLE_TIME == 0) commProcessIdleTime = "";
	else commProcessIdleTime = String.valueOf(COMM_PROCESS_IDLE_TIME);
	%>
	<td><input type=text name=idle_time id=idle_time size=4 maxlength=4 value='<%= commProcessIdleTime %>' onblur='IsNumeric(this);'><img src='../../eCommon/images/mandatory.gif'></td> 	
</tr>
</table>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<th rowspan=2 align=center width='50%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
<!--	<th colspan=4 align=center><fmt:message key="eXH.Log.Label" bundle="${xh_labels}"/></th>	-->
</tr>
<!--
<tr>
	<th align=center width='10%'><fmt:message key="eXH.Audit.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Debug.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></th>
</tr>
-->

</table>
<div style="overflow:auto; height:390px;"> 
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
Statement stmt1 = null;
ResultSet rs1 = null;
String classValue = " ";
String FACILITY_ID = "";
String FACILITY_NAME = "";
String AUDIT_YN = "";
String DEBUG_YN = "";     
String OUTBOUND_LOG_YN = "";              
String INBOUND_LOG_YN = "";   
String CHK_OPERATIONAL = "";
String status = "";
int i = 0;
boolean colorIndicatorStatus = false;

try
{
	String sql1="SELECT X.FACILITY_ID,X.FACILITY_NAME,Y.AUDIT_YN,Y.DEBUG_YN,Y.OUTBOUND_LOG_YN,Y.INBOUND_LOG_YN,Z.OPERATIONAL_YN,'N' FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+locale+"'AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID " +
				"UNION "+
				"SELECT X.FACILITY_ID,X.FACILITY_NAME,'N','N','N','N',Z.OPERATIONAL_YN,'Y' FROM SM_FACILITY_PARAM_LANG_VW X,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+locale+"' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Z.FACILITY_ID AND X.FACILITY_ID NOT IN (SELECT FACILITY_ID  FROM XH_PARAM_FOR_FACILITY )";

	stmt1=con.createStatement();
	rs1=stmt1.executeQuery(sql1);

	while(rs1.next())
	{
		if ( i % 2 == 0 ) classValue = "QRYEVEN" ;
		else classValue = "QRYODD" ;

		FACILITY_ID		= rs1.getString(1);
		FACILITY_NAME	= rs1.getString(2);
		AUDIT_YN		= XHDBAdapter.checkNullForCheckBox(rs1.getString(3));
		DEBUG_YN		= XHDBAdapter.checkNullForCheckBox(rs1.getString(4));     
		OUTBOUND_LOG_YN = XHDBAdapter.checkNullForCheckBox(rs1.getString(5));              
		INBOUND_LOG_YN	= XHDBAdapter.checkNullForCheckBox(rs1.getString(6));  
		CHK_OPERATIONAL = XHDBAdapter.checkNullForCheckBox(rs1.getString(7));  
		status = XHDBAdapter.checkNullForCheckBox(rs1.getString(8));

		if(status != null && status.equals("Y"))
		{
			colorIndicatorStatus = true;
		}

%>
<tr>
	<td class='<%=classValue%>' align=left width='50%'><FONT COLOR="<%=status.equals("Y")?"green":""%>"><%=FACILITY_NAME%></FONT></td>
</tr>
<%
		i++;
	} // end of while
	if(colorIndicatorStatus)
	{
%>
	</table>
	<table>
		<tr>
		<td class=label><img src='../../eXH/images/green_square.jpg' width=40 height=15 >
		Recently Enabled Elements
		</td>
		</tr>
<%
	}

}catch(Exception e)
{
	out.println("(InterfaceParamSetupAdmin:Facility)Exception: "+e.toString());
	e.printStackTrace(System.err);
}
finally{
	try
	{
		if(stmt1!=null)stmt1.close();
		if(rs1!=null)rs1.close();
		ConnectionManager.returnConnection(con);
	}
	catch(Exception e)
	{
		out.println("InterfaceParamSetupAdmin:finally)Exception: "+e.toString());
	}
}
%>
</table>

<%

	PreparedStatement pstmt		= null;
	ResultSet rs2				= null;
	int dispStageCount = 0;
	boolean isDebugYN = false; 

	try {

		isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		con = ConnectionManager.getConnection();

		String sqlStatement = " select count(*) auto_disp_count from SM_FUNCTION_CONTROL a, sm_site_param b "
							+ "	where a.MODULE_ID = 'XH' and a.FUNCTIONALITY_ID like '%AUTODISPSTAGE%' and a.SITE_ID = b.customer_id "
							+ "	and a.KEY_1 = ? AND VALUE_1 = 'Y' ";
		pstmt = con.prepareStatement(sqlStatement);
		pstmt.setString(1,"AUTODISPSTAGE");

		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() ) 
			{
				dispStageCount = rs2.getInt("auto_disp_count");
			}
		}
		
		if(isDebugYN)
			System.out.println("*** Inside Auto Dispense Stage Validation - SQL... "+sqlStatement+" *** Disp Stage Count  : "+dispStageCount);
	}
	catch (Exception e){
		System.out.println("***Inside Auto Dispense Stage Validation - Exception in fetching dispense stage validation "+e );
	}
	finally 
	{
		if (rs2 != null)   rs2.close();
		if (pstmt != null) pstmt.close();	
		ConnectionManager.returnConnection(con);
		if(isDebugYN)
			System.out.println("***Inside Auto Dispense Stage Validation - Conection closed");		
	}

	if (dispStageCount>0)
	{
%>

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<th align=center colspan=4><fmt:message key="eXH.externalSetup.label" bundle="${xh_labels}"/></th>
<tr>
	<td class=label nowrap  width='24%'><fmt:message key="eXH.AutoDispStage.label" bundle="${xh_labels}"/></td>
	<td colspan="3" class=label align = "left"  width='76%' ><select class='select' name='auto_disp_stage' id='auto_disp_stage' >
			<%
			if(null != autoDispStage){
			%>
				<option value='<%=autoDispStage%>'>
			<%
			} if(null == autoDispStage){
			%>
			<option value=''>--------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------</option>
			<option value='IP'><fmt:message key="eXH.IP.label" bundle="${xh_labels}" /></option>
		    <option value='OP'><fmt:message key="eXH.OP.label" bundle="${xh_labels}" /></option>
		    <option value='DO'><fmt:message key="eXH.DO.label" bundle="${xh_labels}" /></option>
			<option value='*A'><fmt:message key="eXH.*A.label" bundle="${xh_labels}" /></option>
			<%
			 }else if(autoDispStage.equals("IP")){
			%>
			<fmt:message key="eXH.IP.label" bundle="${xh_labels}" /></option>
			<option value='OP'><fmt:message key="eXH.OP.label" bundle="${xh_labels}" /></option>
		    <option value='DO'><fmt:message key="eXH.DO.label" bundle="${xh_labels}" /></option>
		    <option value='*A'><fmt:message key="eXH.*A.label" bundle="${xh_labels}" /></option>
			<%
				}else if(autoDispStage.equals("OP")){
			%>
			<fmt:message key="eXH.OP.label" bundle="${xh_labels}" /></option>
			<option value='IP'><fmt:message key="eXH.IP.label" bundle="${xh_labels}" /></option>
		    <option value='DO'><fmt:message key="eXH.DO.label" bundle="${xh_labels}" /></option>
		    <option value='*A'><fmt:message key="eXH.*A.label" bundle="${xh_labels}" /></option>
			<%
				}else if(autoDispStage.equals("DO")){
			%>
			<fmt:message key="eXH.DO.label" bundle="${xh_labels}"/></option>
			<option value='IP'><fmt:message key="eXH.IP.label" bundle="${xh_labels}" /></option>
		    <option value='OP'><fmt:message key="eXH.OP.label" bundle="${xh_labels}" /></option>
		    <option value='*A'><fmt:message key="eXH.*A.label" bundle="${xh_labels}" /></option>
			<%
			} else if(autoDispStage.equals("*A")){
			%>
			<fmt:message key="eXH.*A.label" bundle="${xh_labels}" /></option>
			<option value='IP'><fmt:message key="eXH.IP.label" bundle="${xh_labels}" /></option>
		    <option value='OP'><fmt:message key="eXH.OP.label" bundle="${xh_labels}" /></option>
		    <option value='DO'><fmt:message key="eXH.DO.label" bundle="${xh_labels}" /></option>
			<%}%>
			
</select></td>	
		
</tr>
</table>

	<%
	}
	%>

</div>
<input type="hidden" name="resultMessage" id="resultMessage" id="resultMessage" value="<%= resultMessage %>">
</form>
</body>
</html>

