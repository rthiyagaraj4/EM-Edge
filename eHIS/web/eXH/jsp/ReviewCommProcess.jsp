<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import = "java.net.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con=null;
ResultSet rs=null;				   
Statement stmt=null;
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript" src='../../eXH/js/AdministerReviewCommunicationProcess.js'></script>
<script language="JavaScript">
//function callJSPs
function callJSPs(str)
{
	var tab1=document.getElementById("outbound");
	var tabspan1=document.getElementById("outbound_tabspan");
	var tab2=document.getElementById("inbound");
	var tabspan2=document.getElementById("inbound_tabspan");

	var fields = new Array ( this.document.forms[0].comm_client,this.document.forms[0].facility) ;

    var names = new Array ( getLabel("eXH.CommunicationClient.Label","XH"),
						    getLabel("eXH.Facility.Label","XH"));
	var messageFrame=parent.messageFrame;

	if(str=='outbound')
	{
		
		tab1.className='tabClicked';
	    tabspan1.className='tabSpanclicked';
	    tab2.className='tabA';
	    tabspan2.className='tabAspan';

		parent.f_query_add_mod.location.href ='../../eCommon/html/blank.html';
		parent.f_query_btn.location.href ='../../eCommon/html/blank.html';
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
			

		if(!checkFields( fields, names, messageFrame))
        {
  
        }
        else{
        var index=this.document.forms[0].facility.selectedIndex;
		this.document.forms[0].facility_name.value=this.document.forms[0].facility.options[index].getAttribute("facility_name");
		this.document.forms[0].action ='../../eXH/jsp/ReviewCommProcessOutbound.jsp';
		this.document.forms[0].target='f_query_add_mod';
		this.document.forms[0].submit();
		}
	}	
	if(str=='inbound')
	{
		tab2.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		
		parent.f_query_add_mod.location.href ='../../eCommon/html/blank.html';
		parent.f_query_btn.location.href ='../../eCommon/html/blank.html';
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
		
		var fields = new Array ( this.document.forms[0].comm_client) ;
		 var names = new Array ( getLabel("eXH.CommunicationClient.Label","XH"));
		if(!checkFields( fields, names, messageFrame))
        {
  
        }
        else{
		var index=this.document.forms[0].facility.selectedIndex;
		this.document.forms[0].facility_name.value=this.document.forms[0].facility.options[index].getAttribute("facility_name");
		this.document.forms[0].action = '../../eXH/jsp/ReviewCommProcessInbound.jsp';
		this.document.forms[0].target='f_query_add_mod';
		this.document.forms[0].submit();
	}
	}
}
//function callmethod
function callmethod()
{

<%
try{
String hostname1=InetAddress.getLocalHost().getHostName();	
String hostname=hostname1.toUpperCase();
if(hostname!=null){
%>
this.document.forms[0].comm_client.value='<%=hostname%>';
<% }}catch(Exception e){} %>
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0 onLoad="callmethod()" onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<%
try
{
con=ConnectionManager.getConnection();
}catch(Exception e1)
{
	System.out.println("(ReviewCommProcess.jsp:Exception-1) :"+e1.toString());
}
/*String sql="SELECT B.FACILITY_ID,B.FACILITY_NAME FROM  SM_FACILITY_PARAM_LANG_VW  B WHERE B.LANGUAGE_ID='"+locale+"'  ORDER BY FACILITY_ID";	*/
String sql ="SELECT DISTINCT A.FACILITY_ID, s.facility_name  FROM 	xh_appl_for_facility a, sm_facility_param_lang_vw s  WHERE s.language_id='"+locale+"' and	a.facility_id = s.facility_id";
%>
<form name="review_communication_process_form" id="review_communication_process_form" >
<input type="hidden" name="facility_name" id="facility_name"/>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td width='30%'></td> 
<td width='70%'></td> 
</tr>
<tr>
<td class=label ><fmt:message key="eXH.Facility.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ="facility" id ="facility">
<option value='' facility_name='' > --<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-- </option> 
<%
try
{
stmt=con.createStatement();
rs=stmt.executeQuery(sql);
while(rs.next())
{
%>	
<option value='<%=rs.getString(1)%>' facility_name='<%=rs.getString(2)%>'><%=rs.getString(2)%></option>
<% } %>
</select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<%
}catch(Exception e1)
{
	System.out.println(" (ReviewCommProcess.jsp:Exception-2) :"+e1.toString());
}finally{
try{ if(rs!=null)rs.close();
     if(stmt!=null)stmt.close();
	 ConnectionManager.returnConnection(con);
   }catch(Exception e)
   {
	out.println("Exception is "+e);
	}
}//end of finally block
%>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.CommunicationClient.Label" bundle="${xh_labels}"/></td><td class='fields'><input type="text"  name="comm_client" id="comm_client" id="comm_client" size=25> <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.CommunicationClient.Label" bundle="${xh_labels}"/></td><td>
<a id='communication' href="CommunicationAdministrator.jnlp">Communication Administrator</td>
</tr>


</table>

 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
        <tr><td>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="<fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('outbound')" class="tabA" id='outbound' >
					<span class="tabAspan" id="outbound_tabspan"><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title="<fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('inbound')" class="tabA" id="inbound" >
					<span class="tabAspan" id="inbound_tabspan"><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   </ul>
	 </td>
   </tr>
</table>
</form>
</body>
</html>

