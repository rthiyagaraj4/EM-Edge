<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.XHReturnArray"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
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
  applsql="SELECT APPLICATION_ID,APPLICATION_NAME FROM  XH_APPLICATION_LANG_VW where LANGUAGE_ID='"+locale+"'";
  applstmt=con.createStatement();
  applrs=applstmt.executeQuery(applsql);
	
}catch(Exception e1)
{
	System.out.println("(ViewDebugInteractiveInfoHeader.jsp :Exception-1) :"+e1.toString());
}
%>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function goSearch
function goSearch(str)
{
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	var select_boxf=document.getElementById("vfacility");
	var select_boxa=document.getElementById("vapplname");
	var select_boxe=document.getElementById("veventtype");
	
	var tab1=document.getElementById("trigger");
    var tabspan1=document.getElementById("trigger_tabspan");
    var tab2=document.getElementById("procedure");
    var tabspan2=document.getElementById("procedure_tabspan");

	
	if(str=='trigger')
	{
	    tab1.className='tabClicked';
	    tabspan1.className='tabSpanclicked';
		tab2.className='tabA';
		tabspan2.className='tabAspan';

	   this.document.forms[0].action='../../eXH/jsp/DebugInteractiveInfoTrigger.jsp';
	   this.document.forms[0].target='f_query_add_mod';
	   this.document.forms[0].action_type.value='S';
	   this.document.forms[0].submit();
	   if(this.document.forms[0].mode.value=='L')
		{
			
			select_boxf.disabled=true;
			select_boxa.disabled=true;
			select_boxe.disabled=true;
			this.document.forms[0].vmsgid.disabled=true;
			
		}
		
	}               
    
	if(str=='procedure')
	{
	    tab2.className='tabClicked';
	    tabspan2.className='tabSpanclicked';
		tab1.className='tabA';
		tabspan1.className='tabAspan';

	   this.document.forms[0].action='../../eXH/jsp/DebugInfoProcedure.jsp';
	   this.document.forms[0].target='f_query_add_mod';
	   this.document.forms[0].action_type.value='S';
	     this.document.forms[0].submit();
	   if(this.document.forms[0].mode.value=='L')
	   {
		 	select_boxf.disabled=true;
			select_boxa.disabled=true;  
			select_boxe.disabled=true;
			this.document.forms[0].vmsgid.disabled=true;
			
	   }
  
	}
}
//function populateAction
function populateAction(obj)
{
	this.document.forms[0].action='../../eXH/jsp/ViewDebugInteractiveInfoHeader.jsp';
	this.document.forms[0].target='f_query_header';
	this.document.forms[0].submit();
}
//function setValues
function setValues()
{
	var select_boxf=document.getElementById("vfacility");
	var select_boxa=document.getElementById("vapplname");
	var select_boxe=document.getElementById("veventtype");
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
						
			//***********************************************************
			//for application population
			var tempa=0;	
			for( var j=0;j<select_boxa.options.length;j++)
			{
				if(select_boxa.options[j].value==winarg[1])
				{
					select_boxa.options[j].selected=true; 
					tempa=1;
					this.document.forms[0].vapplname.value=winarg[1];
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
						this.document.forms[0].vapplname.value=winarg[1];
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
				this.document.forms[0].vfacility.value=winarg[3];
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
						this.document.forms[0].vfacility.value=winarg[3];
					}
				}
			}
			
       //*************************************************************/
		//for eventtype population 
			var tempe=0;		       
			for( var j=0;j<select_boxe.options.length;j++)
			{	if(select_boxe.options[j].value ==winarg[5])
				{
				select_boxe.options[j].selected=true;
			    tempe=1;
				this.document.forms[0].veventtype.value=winarg[5];
				}
			}
          
			if(tempe==0)
			{
				optne= document.createElement("OPTION");
				optne.text =winarg[6];
				optne.value =winarg[5];
				select_boxe.options.add(optne);
				for( var j=0;j<select_boxe.options.length;j++)
				{	
					if(select_boxe.options[j].value ==winarg[5])
					{
						select_boxe.options[j].selected=true;
						this.document.forms[0].veventtype.value=winarg[5];
					}
				}
			}
			
			//**********************************************************
			this.document.forms[0].vmsgid.value=winarg[7];
			
			//***********************************************************
			}
	}
   
	
	else{
       
		<%
	String vapplname=request.getParameter("vapplname");
	String vfacility=request.getParameter("vfacility");
	String vmsgid=request.getParameter("vmsgid");
	String veventtype=request.getParameter("veventtype");
	if(vapplname==null) vapplname=""; 
	%>  
	for( var j=0;j<select_boxa.options.length;j++)
	{
	   if(select_boxa.options[j].value =='<%=vapplname%>')
       select_boxa.options[j].selected=true;
	}
	removeAllOptions(select_boxf);
    <% 
	  string=arr.returnDebugFacilityArray(con,vapplname,locale);
	  for(int i=0;i<string.length;i++)
	  {
	%>
   	 optn[<%=i%>] = document.createElement("OPTION");
	 optn[<%=i%>].text ='<%=string[i][0]%>';
	 optn[<%=i%>].value ='<%=string[i][1]%>';
	 select_boxf.options.add(optn[<%=i%>]);
	<%	
	}
	
	if(vfacility==null) vfacility="";
    %>  
	for( var j=0;j<select_boxf.options.length;j++)
	{
	 if(select_boxf.options[j].value =='<%=vfacility%>')
     select_boxf.options[j].selected=true;
	}
	removeAllOptions(select_boxe);
    <%
	string=arr.returndebugeventArray(con,vapplname,vfacility,locale);
    for(int i=0;i<string.length;i++)
	{
	%>
	optn[<%=i%>] = document.createElement("OPTION");
	optn[<%=i%>].text ='<%=string[i][0]%>';
	optn[<%=i%>].value ='<%=string[i][1]%>';
	select_boxe.options.add(optn[<%=i%>]);
	<%	
	} 
	if(vmsgid==null) vmsgid="";
	%>
    <%  if(veventtype==null) veventtype=""; %>
	for( var j=0;j<select_boxe.options.length;j++)
	{
	 if(select_boxe.options[j].value =='<%=veventtype%>')
     select_boxe.options[j].selected=true;
	}
	this.document.forms[0].vmsgid.value='<%=vmsgid%>';
	}

}
//function removeAllOptions
function removeAllOptions(selectbox)
{
var i;
for(i=selectbox.options.length-1;i>=1;i--)
{
selectbox.remove(i);
}
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="setValues()" >
<form name="view_debug_info_header_form" id="view_debug_info_header_form">
<input type="hidden" name=sortMode id=sortMode value='A' />
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=""/>
<input type="hidden" name="action_type" id="action_type" value='0'/>
<input type="hidden" name="mode" id="mode"/>
<input type="hidden" name="vapplname1" id="vapplname1"/>
<input type="hidden" name="veventtype1" id="veventtype1"/>
<input type="hidden" name="vfacility1" id="vfacility1"/>
<input type="hidden" name="vmsgid1" id="vmsgid1"/>

<table cellspacing=0 cellpadding=0 width='100%' border=0 align=center>

<tr>
<td width='10%'></td> 
<td width='40%'></td> 
<td width='10%'></td> 
<td width='40%'></td> 
</tr>

<tr>
<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='fields'><select name="vapplname" id="vapplname" id="vapplname" onchange='populateAction(this);'>
<option value="">   ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----    </option>
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
	{ 
			System.out.println("(ViewDebugInteractiveInfoHeader.jsp :Exception-2) :"+e1.toString()); }
	finally{
			try{
				if(applrs!=null)applrs.close();
				if(applstmt!=null)applstmt.close();
				ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				out.println("Exception is "+e);
				}
	}//end of finally block
%>

<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name ="vfacility" id ="vfacility" onchange='populateAction(this);' >
<option value="">    ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----    </option>
</select></td></tr>
<tr>
<td width='10%'></td> 
<td width='40%'></td> 
<td width='10%'></td> 
<td width='40%'></td> 

</tr>
<tr>
<td class=label ><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
<td class='fields'><input type=text name=vmsgid id=vmsgid size=20 onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))' onBlur='return(CheckNum(this))'>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td><td class='fields'><select name="veventtype" id="veventtype" id="veventtype" >
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- </option>
</select>

</td>
</tr>
<tr>
<td width='10%'></td> 
<td width='40%'></td> 
<td width='10%'></td> 
<td width='40%'></td> 

</tr>
</table>

<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
        <tr><td class="white">
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title='<fmt:message key="eXH.Triggers.Label" bundle="${xh_labels}"/>'>
				<a onclick="goSearch('trigger')" class="tabA" id='trigger' >
					<span class="tabAspan" id="trigger_tabspan"><fmt:message key="eXH.Triggers.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title='<fmt:message key="Common.Procedures.label" bundle="${common_labels}"/>'>
				<a onclick="goSearch('procedure')" class="tabA" id="procedure" >
					<span class="tabAspan" id="procedure_tabspan"><fmt:message key="Common.Procedures.label" bundle="${common_labels}"/></span>
				</a>
		   </li>
		   </ul>
	 </td>
   </tr>
</table>

</form>
</body>
</html>

