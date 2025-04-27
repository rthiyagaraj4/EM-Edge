<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));
locale = "en"; %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>										    
  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>							  
<Script Language="JavaScript" src="../../eXH/js/MachineForAutoDispenser.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD> 

<BODY  leftmargin=0 topmargin=0  bgcolor='' onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
String mode=request.getParameter("mode");
System.out.println("MachineForAutoDispenser mode.."+mode);
String Machine_Code = "";
String Long_Desc = "";
String Short_Desc = "";
String EFF_Status = "";

String login_id="";
String user_id = "";

String help="";

user_id=request.getParameter("usr_name");
String facility_id	= (String) session.getValue("facility_id");
System.out.println("MachineForAutoDispenser function_id.."+facility_id);
%>
<form name="Master_machine_for_auto_dispenser" id="Master_machine_for_auto_dispenser" id="Master_machine_for_auto_dispenser" target='messageFrame' method='post' action='../../servlet/eXH.MachineForDispenserServlet'>
<%
	if(mode.equals("I")){

%>
<table cellpadding=0 cellspacing=0 width="60%"  align="center" border="1" name="machineForAutoDispenserMasterTable" id="machineForAutoDispenserMasterTable" id="machineForAutoDispenserMasterTable">
<tr>
	<th width="25%"><fmt:message key="eXH.MachineCode.label" bundle="${xh_labels}"/></th>
	<th width="25%"><fmt:message key="eXH.LongDesc.label" bundle="${xh_labels}"/></th>
	<th width="25%"><fmt:message key="eXH.ShortDesc.label" bundle="${xh_labels}"/></th>
	<th width="12%"><fmt:message key="eXH.EFFStatus.label" bundle="${xh_labels}"/></th>
	<th width="12%"><button type="button" onclick="addRow()"><fmt:message key="eXH.addRow.label" bundle="${xh_labels}"/></button></th>
</tr>
 <%
   String  classValue = "";
   for(int count=0 ; count < 10 ; count++)
   {
       if ( count % 2 == 0 )
           classValue = "QRYEVEN" ;
       else
           classValue = "QRYODD" ;
       %>
	   
	   <tr >
	   
	   <td width="25%" nowrap class='label' style="text-align: center;">
		 <input type='text' name='Machine_Code<%=count%>' id='Machine_Code<%=count%>' id = 'Machine_Code<%=count%>' size='15'  maxlength="2"  onBlur="ChangeUpperCase(this);checkNumber(this);">
		   <input type='hidden' name='Machine_Code<%=count%>' id='Machine_Code<%=count%>'>
       </td>
	   <td width="25%" nowrap class='label' style="text-align: center;">
			<input type='text' name='Long_Desc<%=count%>' id='Long_Desc<%=count%>' id='Long_Desc<%=count%>'  size='50' maxlength="60"  onBlur="ChangeUpperCase(this);"/>
		   <input type='hidden' name='Long_Desc<%=count%>' id='Long_Desc<%=count%>'>
	   </td>
	   <td width="25%" nowrap class='label' style="text-align: center;">
			<input type='text' name='Short_Desc<%=count%>' id='Short_Desc<%=count%>' id='Short_Desc<%=count%>'  size='50' maxlength="30"  onBlur="ChangeUpperCase(this);"/>
		   <input type='hidden' name='Short_Desc<%=count%>' id='Short_Desc<%=count%>'>
	   </td>
	   <td width="12%" class='fields' style="text-align: center;" >
		   <input type=checkbox name ='EFF_Status<%=count%>' <%=EFF_Status.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=EFF_Status.equals("Y")?"Y":"N"%>'>
		</td>
		<td width="12%">&nbsp;</td>
		  
   </tr >

   <%
           }//for loop
   %>

</table>
<%
}
if(mode.equals("U")){
	String rslt_machineCode = request.getParameter("machineCode");
	String rslt_longDesc = request.getParameter("longDesc");
	String rslt_shortDesc = request.getParameter("shortDesc");
	String rslt_effStatus = request.getParameter("effStatus");
%>
<table border=1 cellspacing=0 cellpadding=0 width='60%' align=center id="machineForAutoDispenserMasterTable">
<tr>
	<th width="25%"><fmt:message key="eXH.MachineCode.label" bundle="${xh_labels}"/></th>
	<th width="25%"><fmt:message key="eXH.LongDesc.label" bundle="${xh_labels}"/></th>
	<th width="25%"><fmt:message key="eXH.ShortDesc.label" bundle="${xh_labels}"/></th>
	<th width="25%" COLSPAN=2><fmt:message key="eXH.EFFStatus.label" bundle="${xh_labels}"/></th>
	
</tr>
<tr >	   
	<td width="25%" nowrap class='label' style="text-align: left;">
	  <input type='text' name='Machine_Code' id='Machine_Code' id = 'Machine_Code'  size="15" maxlength="2" value='<%=rslt_machineCode%>' onBlur="ChangeUpperCase(this);checkNumber(this);" disabled><input type='hidden' name='hid_Machine_Code' id='hid_Machine_Code' value='<%=rslt_machineCode%>' />
	</td >
	<td width="25%" nowrap class='label' style="text-align: left;">
		<input type='text' name='Long_Desc' id='Long_Desc' id='Long_Desc' value='<%=rslt_longDesc%>' size='50' maxlength="60" onBlur="ChangeUpperCase(this);"/> 
	</td>
	<td width="25%" nowrap class='label' style="text-align: left;">
		<input type='text' name='Short_Desc' id='Short_Desc' id='Short_Desc' value='<%=rslt_shortDesc%>' size='50' maxlength="30" onBlur="ChangeUpperCase(this);"/>
	</td>
	<td width="25%" class='fields' style="text-align: center;" COLSPAN=2>
		 <input type=checkbox name ='EFF_Status' <%=rslt_effStatus.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=rslt_effStatus.equals("Y")?"Y":"N"%>'>
	</td>	
</tr >
</table>
<%
}
%>
<input type=hidden name=mode value='<%=mode%>'>
<input type=hidden name=collected_string value=''>
<input type=hidden name='update_mode_login' id='update_mode_login' value=<%=login_id%>>
<input type=hidden name='locale' id='locale' value='<%=locale%>'>
<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>"/>

</body>
</form>
</html>	
	

