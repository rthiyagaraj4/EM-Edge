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
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
Connection con=null;
ResultSet facilityrs=null;
Statement facilitystmt=null;

ResultSet processrs=null;
Statement processstmt=null;

String facilitySql=null;
String processSql=null;

try
{
con=ConnectionManager.getConnection();
}catch(Exception e1)
{
	System.out.println("(ERROR:ViewServerInteractiveErrors.jsp) :"+e1.toString());
}
%>

<script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/ViewServerProcessInteractiveErrors.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<script>
//*************************************************************************************
function setValues()
{
	var select_boxf=document.getElementById("sfacility");
	var select_boxp=document.getElementById("sprocessid");
	var img1=document.getElementById("img1");
	var img2=document.getElementById("img2");
	
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
			img2.style.display='none';
			//**********************************************************
			//for facility population 
			var temp=0;		       
			for( var j=0;j<select_boxf.options.length;j++)
			{	if(select_boxf.options[j].value==winarg[1])
				{
				select_boxf.options[j].selected=true;
			    temp=1;
				this.document.forms[0].sfacility.value=winarg[1];
				}
			}
          
			if(temp==0)
			{
				
				optnf= document.createElement("OPTION");
				optnf.text =winarg[2];
				optnf.value =winarg[1];
				select_boxf.options.add(optnf);
				for( var j=0;j<select_boxf.options.length;j++)
				{	
					if(select_boxf.options[j].value==winarg[1])
					{
						select_boxf.options[j].selected=true;
						this.document.forms[0].sfacility.value=winarg[1];
					}
				}
			}

			      
			for( var j=0;j<select_boxp.options.length;j++)
			{	if(select_boxp.options[j].value==winarg[3])
				{
				select_boxp.options[j].selected=true;
			 	this.document.forms[0].sprocessid.value=winarg[3];
				}
			}
			//this.document.forms[0].sprocessid.value=winarg[3];
       	//	this.document.forms[0].sprocessid.value="";	
		   // alert(this.document.forms[0].sprocessid.value);
			this.document.forms[0].smsg_dt1.value="";
			this.document.forms[0].smsg_dt2.value="";
		
			
			goSearch();
			select_boxf.disabled=true;
			this.document.forms[0].sprocessid.disabled=true;
					
			//***********************************************************
			}
	}
   
	
}
//******************************************************************************************
</script>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onFocus="" OnLoad="setValues();">

<form name="view_server_errors_form" id="view_server_errors_form" id="view_server_errors_form" >

<input type="hidden" name=sortMode id=sortMode value='A'/>
<input type="hidden" name="action_type" id="action_type" value='S'/>
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=""/>
<input type="hidden" name="mode" id="mode" />
<input type="hidden" name=locale id=locale value='<%=locale%>' />


<table cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
		<td colspan=2></td>
	</tr>
<tr>
<td class="label"><fmt:message key="Common.Program.label" bundle="${common_labels}"/></td>
<td class="fields"><select name="sprocessid" id="sprocessid" id="sprocessid" >
<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
<%
try
{
	processSql="SELECT distinct PGM_ID, long_desc FROM sy_prog_id_lang_vw  WHERE  language_id='"+locale+"'";
	processstmt=con.createStatement();
	processrs=processstmt.executeQuery(processSql);
	while(processrs.next())
	{
	%>	
	<option value='<%=processrs.getString(1)%>'><%=processrs.getString(2)%></option>
	<%	 } %>
</select></td></tr>
<%	}catch(Exception exception)
	{	
		System.out.println("EXCEPTION IN ViewServerErrors.jsp :"+exception.toString());
		exception.printStackTrace(System.err);
	}
	finally{
	try{
		if(processrs!=null)processrs.close();
		if(processstmt!=null)processstmt.close();
		}catch(Exception e)
		{	out.println("Exception is "+e);
		}
		}//end of finally block
%>
</tr>
<tr>
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select name ="sfacility" id ="sfacility" >
<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
<%
try
{
	
	/*facilitySql="SELECT B.FACILITY_ID,B.FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"'  ORDER BY FACILITY_ID ";	 */
	 facilitySql ="SELECT DISTINCT A.FACILITY_ID, s.facility_name  FROM 	xh_appl_for_facility a, sm_facility_param_lang_vw s  WHERE s.language_id='"+locale+"' and	a.facility_id = s.facility_id";
	facilitystmt=con.createStatement();
	facilityrs=facilitystmt.executeQuery(facilitySql);
	while(facilityrs.next())
	{
	%>	
	<option value='<%=facilityrs.getString(1)%>'><%=facilityrs.getString(2)%></option>
	<%	} %>
	</select></td>
	<%
	}catch(Exception e1)
	{	System.out.println("(ViewServerInteractiveErrors.jsp :Exception-2) :"+e1.toString());
	}
	finally{
	try{
		if(facilityrs!=null)facilityrs.close();
        if(facilitystmt!=null)facilitystmt.close();	
        ConnectionManager.returnConnection(con);
		}catch(Exception e)
		{
		out.println("ERROR "+e.toString());
		}
		}//end of finally block
%>
</tr>
<tr id="img1" name="" style="display:block">	
<td class=label ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=text name= smsg_dt1 id="smsg_dt1" size=15 onBlur='CheckDate(this);Checkcurrdate(this);' onSelect="Checkcurrdate(this);"> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('smsg_dt1','dd/mm/y');"></td>
</tr>
<tr id="img2" name="" style="display:block">
<td class=label ><fmt:message key="Common.ToDateTime.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=text name= smsg_dt2  id="smsg_dt2" size=15 onBlur='CheckDate(this); Checkcurrdate(this);' onSelect="Checkcurrdate(this);"> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('smsg_dt2','dd/mm/y');"></td>
</tr>
<tr>
<td colspan=2 class='BUTTON'><input class='BUTTON' type="button"  name=search id=search value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="goSearch();"></td>
</tr>

</table>
</form>
</body>
</html>

