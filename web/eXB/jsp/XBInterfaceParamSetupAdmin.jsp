<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>

<HEAD>
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String locale = ((String)session.getAttribute("LOCALE"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXB/js/XBInterfaceParam.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script language="JavaScript">
function CheckForSpecNumber(event){
		var strCheck = '0123456789';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	} 
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789abcdefghitjklmnopqrsuvwxyzABCDEFGHIJKLMNOTPQRSUVWXYZ';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
	function checklength(event,obj) 
{
    var bool=true;
	if(obj.name=='appl_id')
	{
	
		  if(obj.value.length<=10)
		{
			bool=true;
		}
		else
		{
			bool=false;
		}
	}
	else
	{
		if(obj.value.length<=16)
		{
			bool=true;
		}
		else
		{
			bool=false;

		}
	}
	return bool;
}
//function validatecheckbox
function validatecheckbox(obj)
{
	if(obj.checked==true)
	{
		obj.value="Y";
	}
	else
	{
		obj.value="N";								  
	}
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

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
String mode="U";
String user_def_str="";
String profile_id="", interface_yn="", dbf_table_name="", dbf_source_directory="", dbf_dest_directory="", external_exe_name="", dbf_table_create_stmt="", dbf_column_hdng="", dbf_column_dt="", dbf_trace_yn="", drg_query="", cc_trace_yn="", log_dir="",sec_dig="",proc_dig="";

try
{
	con=ConnectionManager.getConnection();
	String sql="SELECT PROFILE_ID, INTERFACE_YN, DBF_TABLE_NAME, DBF_SOURCE_DIRECTORY, DBF_DEST_DIRECTORY, EXTERNAL_EXE_NAME, DBF_TABLE_CREATE_STMT, DBF_COLUMN_HDNG, DBF_COLUMN_DT, DBF_TRACE_YN, DRG_QUERY, CC_TRACE_YN, LOG_DIR,SDX_DIAG_CNT, PROC_DIAG_CNT,USER_DEFINED_STRING FROM XB_PARAM ";
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	if(rs!=null && rs.next())
	{
		profile_id=rs.getString(1);
		String interfacey=XHDBAdapter.checkNull(rs.getString(2));
				if(interfacey.equals(""))
		{
			interface_yn="N";
		}
		else
		{
		interface_yn= rs.getString(2);
		}

		
		dbf_table_name=rs.getString(3);
		dbf_source_directory=rs.getString(4);
		dbf_dest_directory=rs.getString(5);
		external_exe_name=rs.getString(6);
		dbf_table_create_stmt=rs.getString(7);
		dbf_column_hdng = rs.getString(8);
		dbf_column_dt= rs.getString(9);

		String dbf_trace= XHDBAdapter.checkNull(rs.getString(10));
		if(dbf_trace.equals(""))
		{
			dbf_trace_yn="N";
		}
		else
		{
		dbf_trace_yn= rs.getString(10);
		}
		drg_query= rs.getString(11);
//		System.out.println("enga 149");
		String cc_trace=XHDBAdapter.checkNull(rs.getString(12));
		
		if(cc_trace.equals(""))
		{
			cc_trace_yn="N";
		}
		else
		{
		cc_trace_yn= rs.getString(12);
		}
	
		log_dir=XHDBAdapter.checkNull(rs.getString(13));
		sec_dig= XHDBAdapter.checkNull(rs.getString(14));
		proc_dig= XHDBAdapter.checkNull(rs.getString(15));
		user_def_str= XHDBAdapter.checkNull(rs.getString(16));
	}
	else
	{
		mode="I";
	}

}catch(Exception e)
{
	out.println("Exception is "+e.toString());
}
finally{
	try
	{
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e)
	{
		out.println("Exception is "+e.toString());
	}
}



 
%>
<form name="MasterInterfaceForm" id="MasterInterfaceForm" target='messageFrame' method='post' action='../../eXB/jsp/XBInterfaceparamRecord.jsp'>

<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td width='20%'></td>
	<td width='80%'></td>
</tr>
<tr>
	<td colspan=1 class=label><fmt:message key="eXH.EnableInterface.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=checkbox name=enable_interface id=enable_interface value='<%=interface_yn.equals("Y")?"Y":"N"%>' onClick='validatecheckbox(this);' <%=interface_yn.equals("Y")?"checked":""%>></td>
</tr>
<tr>  
	<td class=label><fmt:message key="eXH.ProfileId.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type='text' name=Profile_id id=Profile_id value='<%=profile_id%>' maxlength=15 onKeyPress='return CheckForSpecCharsforID(event);return checklength(event,this);' size=20 disabled > <img src='../../eCommon/images/mandatory.gif' align=middle></td> 
</tr>
<%---<input type="hidden" name="drg_query" id="drg_query" id="drg_query" value="<%=drg_query%>" >---%>
<tr>
	<td width='20%'></td>
	<td width='80%'></td>
</tr>
</table>

<%---<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
     <td colspan=2 class=label>DRG Query&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name='log_directory' id='log_directory' rows=2 cols=50 ><%=drg_query%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>
</table>----%>
<table cellspacing=0 cellpadding=3 width='100%' align=center border =0>
<th align=left colspan=4><fmt:message key="eXH.DrgDetails.Label" bundle="${xh_labels}"/></th>
<tr>
	<td width='20%'></td>
	<td width='80%'></td>
</tr>
<tr>
	<td colspan=1 class=label><fmt:message key="eXH.DbfTableName.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name='dbf_table_name' id='dbf_table_name' value='<%=dbf_table_name%>' size=35 maxlength=300 value=''> <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
</tr>
<tr>
	<td class=label colspan=1><fmt:message key="eXH.DbfSourceDir.Label" bundle="${xh_labels}"/></td>
	<td align=left><textarea name='dbf_source_directory' id='dbf_source_directory' rows=2 cols=80 ><%=dbf_source_directory%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	
</tr>
<tr>
	<td  class=label colspan=1><fmt:message key="eXH.DbfDestDir.Label" bundle="${xh_labels}"/></td>
	<td align=left><textarea name='dbf_dest_directory' id='dbf_dest_directory' rows=2 cols=80 ><%=dbf_dest_directory%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	
</tr>
<tr>
	<td  class=label colspan=1><fmt:message key="eXH.ExternalExeName.Label" bundle="${xh_labels}"/></td>
	<td align=left ><textarea name='exe_name' id='exe_name' rows=1 cols=80 ><%=external_exe_name%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	
</tr>

<tr>
	<td class=label><fmt:message key="eXH.SecDiagCount.Label" bundle="${xh_labels}"/></td>
	<td align=left ><input type='text' name='sdx_diag_cnt' id='sdx_diag_cnt' id='sdx_diag_cnt' value='<%=sec_dig%>' onkeypress='return CheckForSpecNumber(event)' maxlength=10 size=20> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr> 
	<td class=label><fmt:message key="eXH.PrcDiagCount.Label" bundle="${xh_labels}"/></td>
	<td align=left >
	<input type='text' name='proc_diag_cnt' id='proc_diag_cnt' id='proc_diag_cnt' value='<%=proc_dig%>' onkeypress='return CheckForSpecNumber(event)' maxlength=10 size=20> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr>
	<td  class=label colspan=1><fmt:message key="eXH.DbfTableCreateStmt.Label" bundle="${xh_labels}"/></td>
	<td align=left ><textarea name='dbf_table_create_stmt' id='dbf_table_create_stmt' rows=3 cols=80 ><%=dbf_table_create_stmt%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	
</tr>
<tr>
	<td  class=label><fmt:message key="eXH.DbfColumnHdng.Label" bundle="${xh_labels}"/></td>
	<td align=left ><textarea name='dbf_column_hdng' id='dbf_column_hdng' rows=3 cols=80 ><%=dbf_column_hdng%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	
</tr>

<tr>
     <td colspan=1 class=label><fmt:message key="eXH.DRGQry.Label" bundle="${xh_labels}"/></td>
	<td align=left><textarea name='drg_query' id='drg_query' rows=2 cols=80 ><%=drg_query%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>
<tr> 
	<td  class=label colspan=1><fmt:message key="eXH.UserDefStr.Label" bundle="${xh_labels}"/></td>
	<td align=left ><textarea name='user_def_str' id='user_def_str' rows=2 cols=80 ><%=user_def_str%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	
</tr>

<input type=hidden name="dbf_column_dt" id="dbf_column_dt" id="dbf_column_dt"  value='<%=dbf_column_dt%>'>
<%----<tr>
	<td class=label>DBF Column DT
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name='dbf_column_dt' id='dbf_table_create_dt' rows=2 cols=60 ><%=dbf_column_dt%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle></td> 	</tr>----%>
<tr>
	<td class=label colspan=1><fmt:message key="eXH.DbfTraceY/N.Label" bundle="${xh_labels}"/></td>
	<td align=left ><input type=checkbox name=dbf_trace_yn id=dbf_trace_yn value='<%=dbf_trace_yn%>' <%=dbf_trace_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);'></td>
	</tr>
<th align=left colspan=4><fmt:message key="eXH.CCDetails.Label" bundle="${xh_labels}"/></th>
<tr>
	<td class=label><fmt:message key="eXH.LogDir.Label" bundle="${xh_labels}"/></td>
	<td align=left ><input type='text' name='log_directory' id='log_directory' id='log_directory' value='<%=log_dir%>' size=60> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>

<tr>	
	<td class=label><fmt:message key="eXH.CCTraceY/N.Label" bundle="${xh_labels}"/></td>
	<td align=left ><input type=checkbox name=cc_trace_yn id=cc_trace_yn value='<%=cc_trace_yn%>' onClick='validatecheckbox(this);' <%=cc_trace_yn.equals("Y")?"checked":""%>></td>
	</tr>
<tr>
	<td width='20%'></td>
	<td width='80%'></td>
</tr>
</table>

<input type=hidden value="<%=mode%>" name="actualmode"> 

</form>
</body>
</html>

