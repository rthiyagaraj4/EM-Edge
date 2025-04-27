<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.XHReturnArray"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
Connection con=null;
String applsql=null;
ResultSet applrs=null;
Statement applstmt=null;
XHReturnArray arr=new XHReturnArray();
String string[][]=null;
try
{
  con=ConnectionManager.getConnection();
  applsql="SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW WHERE LANGUAGE_ID='"+locale+"'";  
  applstmt=con.createStatement();
  applrs=applstmt.executeQuery(applsql);
	
}catch(Exception e1)        
{
	System.out.println("(ViewMsgInteractiveAuditLogHeader.jsp:Exception-1) :"+e1.toString());
}
%>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/ViewMessagesInteractiveAuditLog.js'></script>
<script language="JavaScript">
//********************************************************************************************
function setValues()
{
	var select_boxf=document.getElementById("facility");
	var select_boxa=document.getElementById("appl_name");
	var select_boxm=document.getElementById("msg_type");
	var select_boxe=document.getElementById("event_type");
	var select_boxs=document.getElementById("status");
	var img1=document.getElementById("img1");
	
	var optn=new Array();
	var winarg=new Array();
  
	winarg=window.dialogArguments;
	if(winarg!=null)
	{
		
		this.document.forms[0].mode.value=winarg[0];
		if(this.document.forms[0].mode.value=='L')
		{
			parent.commontoolbarFrame.document.forms[0].home.disabled=true;
			parent.commontoolbarFrame.document.forms[0].reset.disabled=true;
			this.document.forms[0].search.style.display='none';
			img1.style.display='none';
			//***********************************************************
			//for application population
			var tempa=0;	
			for( var j=0;j<select_boxa.options.length;j++)
			{
				if(select_boxa.options[j].value==winarg[1])
				{
					select_boxa.options[j].selected=true; 
					tempa=1;
					this.document.forms[0].appl_name.value=winarg[1];
				}
			}
        
			if(tempa==0)
			{
				optna= document.createElement("OPTION");
				optna.text =winarg[2];
				optna.value =winarg[1];
				select_boxa.options.add(optna);
				for( var j=0;j<select_boxa.options.length;j++)
				{	
					if(select_boxa.options[j].value==winarg[1])
					{
						select_boxa.options[j].selected=true;
						this.document.forms[0].appl_name.value=winarg[1];
					}
				}
			}
          
        //**********************************************************
			//for facility population 
			var temp=0;		       
			for( var j=0;j<select_boxf.options.length;j++)
			{	if(select_boxf.options[j].value==winarg[3])
				{
				select_boxf.options[j].selected=true;
			    temp=1;
				this.document.forms[0].facility.value=winarg[3];
				}
			}
          
			if(temp==0)
			{
				
				optnf= document.createElement("OPTION");
				optnf.text =winarg[4];
				optnf.value =winarg[3];
				select_boxf.options.add(optnf);
				for( var j=0;j<select_boxf.options.length;j++)
				{	
					if(select_boxf.options[j].value==winarg[3])
					{
						select_boxf.options[j].selected=true;
						this.document.forms[0].facility.value=winarg[3];
					}
				}
			}
			
       //*************************************************************/
		//for eventtype population 
			var tempe=0;		       
			for( var j=0;j<select_boxe.options.length;j++)
			{	if(select_boxe.options[j].value ==winarg[6])
				{
				select_boxe.options[j].selected=true;
			    tempe=1;
				this.document.forms[0].event_type.value=winarg[6];
				}
			}
          
			if(tempe==0)
			{
				optne= document.createElement("OPTION");
				optne.text =winarg[7];
				optne.value =winarg[6];
				select_boxe.options.add(optne);
				for( var j=0;j<select_boxe.options.length;j++)
				{	
					if(select_boxe.options[j].value ==winarg[6])
					{
						select_boxe.options[j].selected=true;
						this.document.forms[0].event_type.value=winarg[6];
					}
				}
			}
			
			//**********************************************************
			removeAllOptions(select_boxm);
			
			this.document.forms[0].msg_id.value=winarg[5];
			
			this.document.forms[0].amsg_dt1.value="";
			this.document.forms[0].amsg_dt2.value="";
			this.document.forms[0].msg_type.value=" ";
			
			goSearch();
			select_boxf.disabled=true;
			select_boxa.disabled=true;
			select_boxe.disabled=true;
			select_boxm.disabled=true;
			this.document.forms[0].msg_id.disabled=true;
			this.document.forms[0].status.disabled=true;
			
			//***********************************************************
			}
	}
   
	
	else{
        
	<%
	String appl_name=request.getParameter("appl_name");
	String facility=request.getParameter("facility");
	String msg_type=request.getParameter("msg_type");
	String amsg_dt1=request.getParameter("amsg_dt1");
	String amsg_dt2=request.getParameter("amsg_dt2");
	String status=request.getParameter("status");
	String msg_id=request.getParameter("msg_id");
	
	
    if(appl_name==null) appl_name=""; 
	
	%>  
	for( var j=0;j<select_boxa.options.length;j++)
	{
	   if(select_boxa.options[j].value =='<%=appl_name%>')
       select_boxa.options[j].selected=true;
	}
	removeAllOptions(select_boxf);
    <% 
	  string=arr.returnArray(con,appl_name,locale);
	  
      for(int i=0;i<string.length;i++)
	  {
	%>
   	 optn[<%=i%>] = document.createElement("OPTION");
	 optn[<%=i%>].text ='<%=string[i][0]%>';
	 optn[<%=i%>].value ='<%=string[i][1]%>';
	 select_boxf.options.add(optn[<%=i%>]);
	<%	
	}
	
	if(facility==null) facility="";
    %>  
	for( var j=0;j<select_boxf.options.length;j++)
	{
	 if(select_boxf.options[j].value =='<%=facility%>')
     select_boxf.options[j].selected=true;
	}
	removeAllOptions(select_boxm);
    <%
	string=arr.returnMsgArray(con,appl_name,facility,locale);
	for(int i=0;i<string.length;i++)
	{
	%>
	optn[<%=i%>] = document.createElement("OPTION");
	optn[<%=i%>].text ='<%=string[i][0]%>';
	optn[<%=i%>].value ='<%=string[i][1]%>';
	select_boxm.options.add(optn[<%=i%>]);
	<%	
	}

	if(msg_type==null) msg_type="";
	%>  
	for( var j=0;j<select_boxm.options.length;j++)
	{
	  if(select_boxm.options[j].value =='<%=msg_type%>')
      select_boxm.options[j].selected=true;
	}
	removeAllOptions(select_boxe);
    <%
	 string=arr.returnEventArray(con,appl_name,facility,msg_type,locale);
	 for(int i=0;i<string.length;i++)
	 {
	%>
	optn[<%=i%>] = document.createElement("OPTION");
	optn[<%=i%>].text ='<%=string[i][0]%>';
	optn[<%=i%>].value ='<%=string[i][1]%>';
	select_boxe.options.add(optn[<%=i%>]);
	<%	
	} 
	if(amsg_dt1==null) amsg_dt1="";
	if(amsg_dt2==null) amsg_dt2="";
	if(status==null) status="";
	if(msg_id==null) msg_id="";
	%>
	
	for( var j=0;j<select_boxs.options.length;j++)
	{
	 if(select_boxs.options[j].value =='<%=status%>')
     select_boxs.options[j].selected=true;
	}
	
	this.document.forms[0].amsg_dt1.value='<%=amsg_dt1%>';
	this.document.forms[0].amsg_dt2.value='<%=amsg_dt2%>';
	this.document.forms[0].msg_id.value='<%=msg_id%>';
	
	}
	
}
//***************************************************************************************
function removeAllOptions(selectbox)
{
var i;
for(i=selectbox.options.length-1;i>=1;i--)
{
selectbox.remove(i);
}
}
//**************************************************************************************
function removeModeAllOptions(selectbox)
{
var i;
for(i=selectbox.options.length-1;i>=0;i--)
{
selectbox.remove(i);
}
}
//**********************************************************************************************
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="setValues()">

<form name="viewmsg_audit_logheader_form" id="viewmsg_audit_logheader_form" >

<input type="hidden" name=sortMode id=sortMode value='A'/>
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=""/>
<input type="hidden" name="action_type" id="action_type" value='S'/>
<input type="hidden" name=locale id=locale value='<%=locale%>' />

<input type="hidden" name="mode" id="mode" />

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='10%'></td> 
	<td width='40%'></td>
	<td width='10%'></td> 
	<td width='40%'></td> 
</tr>

<!-- APPLICATION POPULATION FROM DATABSE-->
<tr>
	<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="appl_name" id="appl_name" id="appl_name" onchange='populateAction(this);'>
	<option value=" ">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
	<%
	try
	{ 
		while(applrs.next())
		{ %>	
			<option value='<%=applrs.getString(1)%>'><%=applrs.getString(2)%></option>
			<%	}
		%>
	</select></td>
	<%
	}catch(Exception e1)
	{ System.out.println("ViewMsgInteractiveAuditLogHeader.jsp:Exception-2 :"+e1.toString()); }
	finally{
			try{
				if(applrs!=null)applrs.close();
				if(applstmt!=null)applstmt.close();
				//XHDBAdapter.closeCursor(applstmt);	
				ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				out.println("Exception is "+e);
				}
	}//end of finally block
%>
<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name="facility" id="facility" id="facility" onchange='populateAction(this);' >
<option value=" ">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
</select></td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
<td class='fields'><select name="msg_type" id="msg_type" id="msg_type" onchange='populateAction(this);'>
<option value=" ">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
</select></td>

<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td class='fields'><select name="event_type" id="event_type" id="event_type">
<option value=" ">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
</select>
</td>
</tr>

<tr id="img1" name="" style="display:block">
<td class=label  ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=text name="amsg_dt1" id="amsg_dt1" id="amsg_dt1" size=15 onBlur='CheckDate(this)'>
 <input type="image"  OnClick="return showCalendar('amsg_dt1','dd/mm/y');"  src='../../eCommon/images/CommonCalendar.gif' ></td>

<td class=label  ><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
<td ><input type=text name="amsg_dt2" id="amsg_dt2" id="amsg_dt2" size=15 onBlur='CheckDate(this)'> <input type="image" onClick="return showCalendar('amsg_dt2','dd/mm/y');"  src='../../eCommon/images/CommonCalendar.gif' ><td>

</tr>
<tr>
<td  class=label><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
<td class='fields'>
<select name="status" id="status" id="status">
<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value='A'><fmt:message key="eXH.Acknowledged.Label" bundle="${xh_labels}"/></option>
	<option value='M'><fmt:message key="eXH.MessageAmended.Label" bundle="${xh_labels}"/></option>
	<option value='P'><fmt:message key="eXH.MessageReplayed.Label" bundle="${xh_labels}"/></option>
	<option value='R'><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
	<option value='F'><fmt:message key="eXH.TransferFailed.Label" bundle="${xh_labels}"/></option>
	<option value='S'><fmt:message key="eXH.TransferSuccessful.Label" bundle="${xh_labels}"/></option>
</select>
</td>
<td class=label ><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name="msg_id" id="msg_id" id="msg_id" size=15 onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))' onBlur='return(CheckNum(this))'></td>
</tr>


<tr>
<td colspan=4 class='BUTTON'><input class='BUTTON' type="button"  name=search id=search value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="goSearch();"></td>
</tr>

<tr>
<td width='10%'></td> 
<td width='40%'></td> 
<td width='10%'></td> 
<td width='40%'></td> 

</tr>
</table>
</form>
</body>
</html>

