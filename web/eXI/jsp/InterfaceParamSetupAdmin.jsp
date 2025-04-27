<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXI.XIDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXI/js/InterfaceParam.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></Script>
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
function CheckForSpecCharsforID(event)
{
    var strCheck = '0123456789.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
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

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='funonload()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
Statement stmt2=null;
ResultSet rs2=null;
Statement stmt3=null;
ResultSet rs3=null;
String INTERFACE_YN ="";
String MASTER_CODE_MAP_YN="";     
String FILTER_YN="";              
String DB_CONNECT_STRING=":::";      
int COMM_PROCESS_IDLE_TIME=0;
String TEMPORARY_PURGE_INTERVAL="";
String PERMANENT_PURGE_INTERVAL="";
String Application_id="";
String RAC_CLUSTER="";
String ipAddress="";
String DEF_ITEM_CLASS="";
String DEF_ITEM_Type="";
String DEF_ITEM_CLASS_Desc="";
String Application_id_desc="";
String portNumber="";
String dbString="";
try{
 		con=ConnectionManager.getConnection();
		String sql="SELECT INTERFACE_YN,MASTER_CODE_MAP_YN,FILTER_YN,DB_CONNECT_STRING,COMM_PROCESS_IDLE_TIME ,TEMPORARY_PURGE_INTERVAL,PERMANENT_PURGE_INTERVAL,RAC_CLUSTER,EXT_INV_APPL_ID,DEF_ITEM_CLASS,DEF_ITEM_TYPE FROM XI_PARAM";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs!=null && rs.next())
		{
			INTERFACE_YN=rs.getString(1);
			MASTER_CODE_MAP_YN=rs.getString(2);
			FILTER_YN=rs.getString(3);
			DB_CONNECT_STRING=rs.getString(4);
			COMM_PROCESS_IDLE_TIME=rs.getInt(5);
			TEMPORARY_PURGE_INTERVAL=XIDBAdapter.checkNull(rs.getString(6));
			PERMANENT_PURGE_INTERVAL=XIDBAdapter.checkNull(rs.getString(7));
            RAC_CLUSTER=XIDBAdapter.checkNull(rs.getString(8));
System.out.println("RAC_CLUSTER"+RAC_CLUSTER);

Application_id=XIDBAdapter.checkNull(rs.getString(9));
DEF_ITEM_CLASS=XIDBAdapter.checkNull(rs.getString(10));
DEF_ITEM_Type=XIDBAdapter.checkNull(rs.getString(11));
		}
			


String sql1="select short_desc description from MM_ITEM_CLASS "+
                    "WHERE  NVL(Eff_status, 'D') = 'E' and ITEM_CLASS_CODE='"+DEF_ITEM_CLASS+"' ";
stmt2=con.createStatement();
		rs2=stmt2.executeQuery(sql1);
		if(rs2!=null && rs2.next())
		{
DEF_ITEM_CLASS_Desc=rs2.getString(1);
		}


String sql2="SELECT SHORT_DESC FROM XH_STANDARD_PROFILE WHERE  PROFILE_ID='"+Application_id+"' ";
System.out.println("sql2"+sql2);

stmt3=con.createStatement();
		rs3=stmt3.executeQuery(sql2);
		if(rs3!=null && rs3.next())
		{
Application_id_desc=rs3.getString(1);
		}



		}catch(Exception e)
		{
		out.println("Exception is "+e.toString());
		}
		finally{
			try{
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
			if(stmt2!=null)stmt2.close();
			if(rs2!=null)rs2.close();
			if(stmt3!=null)stmt3.close();
			if(rs3!=null)rs3.close();
			
				}catch(Exception e)
				{
				out.println("Exception is "+e.toString());
			}
		}

         if(TEMPORARY_PURGE_INTERVAL==null) TEMPORARY_PURGE_INTERVAL="";
         if(PERMANENT_PURGE_INTERVAL==null) PERMANENT_PURGE_INTERVAL="";

		if(DB_CONNECT_STRING !=null){
		if(DB_CONNECT_STRING.indexOf(":")!=-1)
			{
		System.out.println("DB_CONNECT_STRING"+DB_CONNECT_STRING);
		session.putValue("dbString",DB_CONNECT_STRING);
		StringTokenizer st=new StringTokenizer(DB_CONNECT_STRING,":");
			while(st.hasMoreTokens())
			{

if((ipAddress=st.nextToken().toString())!=null)
				{

	if ((portNumber=st.nextToken().toString())!=null )
					{
		if((dbString=st.nextToken().toString())!=null)
				{

				}
else
			{


						}
					}
					else
					{
ipAddress=DB_CONNECT_STRING;
					}
				}
				else
				{

				}
	
			}
			}
else
			{
ipAddress=DB_CONNECT_STRING;
			}

			
		}
%>
<form name="MasterInterfaceForm" id="MasterInterfaceForm" target='messageFrame' method='post' action='../../servlet/eXI.AdminInterfaceParamSetupServlet'>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
	<td class=label align=right><fmt:message key="eXH.EnableInterface.Label" bundle="${xh_labels}"/></td>
	<td	align=left><input type=checkbox name=enable_interface id=enable_interface  <%=INTERFACE_YN.equals("Y")?"checked":""%>  value='<%=INTERFACE_YN.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);'></td>
</tr>
	<th align=left colspan=2><fmt:message key="Common.general.label" bundle="${common_labels}"/></th>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
</table>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class=label align=right><fmt:message key="eXH.SetupMasterCodeMapping.Label" bundle="${xh_labels}"/></td>	
	<td align=left><input type=checkbox name=setup_master_code id=setup_master_code <%=MASTER_CODE_MAP_YN.equals("Y")?"checked":""%>  value='<%=MASTER_CODE_MAP_YN.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);'></td>
	
	<td class=label align=right><fmt:message key="eXH.Temporarypurgeinterval.Label" bundle="${xh_labels}"/></td>	
	<td align=left><input type=text name=temp_purge_interval id=temp_purge_interval  value='<%=TEMPORARY_PURGE_INTERVAL%>'
	onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='return(CheckNum(this))'  maxlength="5" size=5></td>
</tr>
<tr>
	<td class=label align=right><fmt:message key="eXH.EnableEventFiltering.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=checkbox name=enable_event_filtering id=enable_event_filtering <%=FILTER_YN.equals("Y")?"checked":""%> value='<%=FILTER_YN.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);'></td>
	<td class=label align=right><fmt:message key="eXH.Permanentpurgeinterval.Label" bundle="${xh_labels}"/></td>	
	<td align=left><input type=text name=permanent_purge_interval id=permanent_purge_interval  value='<%=PERMANENT_PURGE_INTERVAL%>'
	onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='return(CheckNum(this))' maxlength="5" size=5></td>
</tr>
</table>


<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>

</tr>
<th align=left colspan=6><fmt:message key="eXH.CommunicationProcesSettings.Label" bundle="${xh_labels}"/></th>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>

</tr>
<tr >
	<td class=label id="colon" align=right><fmt:message key="eXH.DBConnectString.Label" bundle="${xh_labels}"/></td>
	<td align=lef id="colon1" colspan=3>
    <input type=text name='db_conn_string1' id='db_conn_string1' title='IP Address'  size=15 maxlength=15 value='<%=ipAddress%>'  >:
	<input type = text name='db_conn_string2' id='db_conn_string2' title='Port Number'   size=4 maxlength=4 value='<%=portNumber%>' onblur='checkValid(this)' >:
	<input type=text name='db_conn_string3' id='db_conn_string3' title='Database Name'  size=10 value='<%=dbString%>' ><img src='../../eCommon/images/mandatory.gif' align=middle>



	</td>
	<td class=label id="colon2" align=right><fmt:message key="eXI.clustertns.Label" bundle="${xh_labels}"/></td>
<td align=left  id="colon3" colspan=3>
<textarea name="DBconnection_string_txt" id="DBconnection_string_txt" rows=2 cols=50 ><%=(ipAddress+portNumber+dbString)%></textarea><img src='../../eCommon/images/mandatory.gif' align=middle></td>

	<td class=label align=right><fmt:message key="eXI.raccluster.Label" bundle="${xi_labels}"/></td>
	<td><input type=checkbox name=rac_cluster id=rac_cluster value='<%=RAC_CLUSTER%>'   <%=RAC_CLUSTER.equals("Y")?"checked":""%>   onClick='connStringArea()'  ></td>
</tr>


<tr>
	<td class=label align=right><fmt:message key="eXH.IdleTime.Label" bundle="${xh_labels}"/></td>
	<td><input type=text name=idle_time id=idle_time size=4 maxlength=4 value='<%=COMM_PROCESS_IDLE_TIME%>' onblur='check(this)'></td> 
	<td colspan=4>&nbsp;</td>
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr> 
</table>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<th align=left colspan=6><fmt:message key="eXI.DefaultAttributes.Label" bundle="${xi_labels}"/></th>

<tr>
	<td class=label align=right><fmt:message key="eXI.ExtApplication.Label" bundle="${xi_labels}"/></td>
	<td align=left >
		<input type=text name='Application_type' id='Application_type' title='Application_ID'  size=15 onBlur="if(this.value!='')searchProfileID();else Application_type_id.value='' "  value='<%=Application_id_desc%>' ><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ApplicationSearch id=ApplicationSearch value='?'    onClick="searchProfileID()">
<input type="hidden" name="Application_type_id" id="Application_type_id" value="<%=Application_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>

	
	
	<td class=label align=right><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
	<td align=left >
		<input type=text name='item_class' id='item_class' title='Item Class'  size=15 onBlur="if(this.value!='')searchItemClass();else Itemclass_txt.value='' " maxlength=15 value='<%=DEF_ITEM_CLASS_Desc%>' ><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ItemSearch id=ItemSearch value='?'    onClick="searchItemClass()">
<input type="hidden" name="Itemclass_txt" id="Itemclass_txt" value="<%=DEF_ITEM_CLASS%>"></td>
</td>
<td class=label align=right><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></td>
<td align=left >
		<input type=text name='ItemType_txt' id='ItemType_txt' title='Item Type'  size=15 maxlength=15 value='<%=DEF_ITEM_Type%>' ><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ItemSearch1 id=ItemSearch1 value='?'    onClick="">
<!--<input type="hidden" name="ItemType_txt" id="ItemType_txt" value="<%=DEF_ITEM_Type%>"></td></td>--->
<input type="hidden" name='db_conn_string_txt' id='db_conn_string_txt' value='<%=(ipAddress+":"+portNumber+":"+dbString)%>' >
		
	</td> 
</tr>

</table>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<th rowspan=2 align=center width='50%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
	<!---<th colspan=4 align=center><fmt:message key="eXH.Log.Label" bundle="${xh_labels}"/></th>--------->
</tr>
<tr>
	<!---<th align=center width='10%'><fmt:message key="eXH.Audit.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Debug.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></th>
	<th align=center width='10%'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></th>----->
</tr>
</table>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
	Statement stmt1=null;
	ResultSet rs1=null;
	String classValue= " ";
	String FACILITY_ID="";
	String FACILITY_NAME="";
	String AUDIT_YN ="";
	String DEBUG_YN="";     
	String OUTBOUND_LOG_YN="";              
	String INBOUND_LOG_YN="";   
	String CHK_OPERATIONAL="";
	int i=0;
	try{
	    String sql1="SELECT X.FACILITY_ID,X.FACILITY_NAME,Y.AUDIT_YN,Y.DEBUG_YN,Y.OUTBOUND_LOG_YN,Y.INBOUND_LOG_YN,Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM_LANG_VW X,XI_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en'AND Z.MODULE_ID='XH' AND     X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID UNION SELECT X.FACILITY_ID,X.FACILITY_NAME,'N','N','N','N',Z.OPERATIONAL_YN FROM SM_FACILITY_PARAM_LANG_VW X,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='en' AND Z.MODULE_ID='XH' AND X.FACILITY_ID=Z.FACILITY_ID AND X.FACILITY_ID NOT IN (SELECT FACILITY_ID  FROM XH_PARAM_FOR_FACILITY )";
    	stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);
		
		while(rs1.next())
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			FACILITY_ID=rs1.getString(1);
			FACILITY_NAME=rs1.getString(2);
			AUDIT_YN =XIDBAdapter.checkNullForCheckBox(rs1.getString(3));
			DEBUG_YN=XIDBAdapter.checkNullForCheckBox(rs1.getString(4));     
			OUTBOUND_LOG_YN=XIDBAdapter.checkNullForCheckBox(rs1.getString(5));              
			INBOUND_LOG_YN=XIDBAdapter.checkNullForCheckBox(rs1.getString(6));  
			CHK_OPERATIONAL=XIDBAdapter.checkNullForCheckBox(rs1.getString(7));  

			String id_for_audit=FACILITY_ID+"_AUDIT";
			String id_for_debug=FACILITY_ID+"_DEBUG";	
			String id_for_outbound=FACILITY_ID+"_OUTBOUND";
			String id_for_inbound=FACILITY_ID+"_INBOUND";	
			
			%>
			<tr><td class='<%=classValue%>' align=center width='10%'><%=FACILITY_NAME%></td>

			<!---<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_audit%>' id='<%=id_for_audit%>' <%=AUDIT_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=AUDIT_YN.equals("Y")?"Y":"N"%>'></td>
			
			<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_debug%>' id='<%=id_for_debug%>' <%=DEBUG_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=DEBUG_YN.equals("Y")?"Y":"N"%>'></td>
			
			<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_outbound%>' id='<%=id_for_outbound%>' <%=OUTBOUND_LOG_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=OUTBOUND_LOG_YN.equals("Y")?"Y":"N"%>'></td>
			
			<td class='<%=classValue%>' align=center width='10%'><input type=checkbox name='<%=id_for_inbound%>' id='<%=id_for_inbound%>' <%=INBOUND_LOG_YN.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=INBOUND_LOG_YN.equals("Y")?"Y":"N"%>'></td>--->
			
			</tr>
		<%
			
		i++;
			
		}
			
	}catch(Exception e)
	{
		out.println("Exception is "+e.toString());
	}
	finally{
			try{
			
			if(stmt1!=null)stmt1.close();
			if(rs1!=null)rs1.close();
			
			
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				out.println("Exception is "+e.toString());
				}
			}
%>
</table>
</form>
</body>
</html>

