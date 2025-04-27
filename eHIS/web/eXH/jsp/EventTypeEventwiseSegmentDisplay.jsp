<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));	
%>
<HEAD>
<%String sStyle = 
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script> 
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>							 
<script language="javascript" src="../../eCommon/js/common.js" ></script>							    
 <Script Language="JavaScript" src="../../eXH/js/EventTypeTabs.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">  

function showLink(segment_type,fun_id)
{
	callJSPs1('segment',segment_type,fun_id); 
}

function funEventAdd()													    
{
	parent.parent.frames[3].document.location.href='../../eXH/jsp/EventTypeEventwiseSegmentDisplayAdd.jsp?stnd_code='+document.forms[0].stnd_code.value+'&event_type='+document.forms[0].event_type.value;	   
	parent.parent.frames[4].document.location.href='../../eCommon/jsp/MstCodeError.jsp';
} 																						    
function validatecheckbox(obj,which,whichelement) 				    
{  	
	
	if(obj.checked==true)  
	{
		obj.value="Y";
		document.getElementById(which).value="Y";
		document.getElementById("_field"+whichelement).value="Y"; 
	}
	else
	{
		obj.value="N";
		document.getElementById(which).value="N";
		document.getElementById("_field"+whichelement).value="N"; 
	}
}

function funAction(typ){
																		  
		this.document.forms[0].target = 	"";
//	alert(parent.parent.frames[3].name);
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].action_type.value = typ;
	this.document.forms[0].action = '../../eXH/jsp/EventTypeEventwiseSegmentDisplay.jsp';
	this.document.forms[0].submit();
	parent.parent.frames[3].location.href='../../eCommon/html/blank.html';
																		  
}
  function funShowpPopup(obj)						  
{
	
	var segment_type= obj.getAttribute('segment_type');  
		var fun_id= obj.getAttribute('fun_id');  																		 
	 var linkset	= new Array();
		 var outboundatamapping	= getLabel("eXH.Segments.Label","xh");   
			
			  var viewEventLink='<a href="#" onClick='+'\''+'showLink("'+segment_type+'","'+fun_id+'");'+'\''+'>'+outboundatamapping+'</a>';
				 linkset[0]=viewEventLink; 
	 dispMenu(linkset);			 
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
//Statement stmt2=null;
//ResultSet rs2=null;
ArrayList arrRow = null;
ArrayList arrCol = null;										 
String strPrevious = "";  
String strNext  = "";
Statement statment=null;
ResultSet rset=null;  	  
ResultSet rsets=null;
String b_e_d="";
HashMap resultsQry=null; 
String fun_id=XHDBAdapter.checkNull(request.getParameter("fun_id"));
//int i=0;
String classValue="";
String segment_type="";
String segment_name=""; 
String optional_yn="";
String in_use_yn="";
String event_type=request.getParameter("event_type");
String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
String node=XHDBAdapter.checkNull(request.getParameter("node"));
//String evntStnd_code="";
//	System.out.println("standard_code : "+standard_code);				 

String stnd_desc="";
//String stnd_flag = "";

String stnd_code = "";
String event_type_id="";										  

%>
<form name="MasterSegmentListForEventTypeForm" id="MasterSegmentListForEventTypeForm" target='messageFrame' method='post' action=''>
<%
try{ 
		boolean boolToggle =  true;	
		     request.setAttribute("message_type",event_type);
             request.setAttribute("standard_code",standard_code);
             con = ConnectionManager.getConnection(request);
			XHSegmentwiseElementsBean	xhBean = XHSegmentwiseElementsBean.getBean(XHSegmentwiseElementsBean.strBeanName,request,session);
			xhBean.action(request,con);
			resultsQry = xhBean.getResultSet();
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			 strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			if (boolPrevious == true)
			{ 
				strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			}
			else
			{
				strPrevious = " ";
			}									 
			if (boolNext== true)
			{
				strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			}
			else
			{
				strNext  = " ";
			}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
	<td colspan="8" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<!--		<td class='COLUMNHEADER'>  <fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td> -->
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.StandardType.Label" bundle="${xh_labels}"/></td> 
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/> </td>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></td>
<!--		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> -->
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<% 
if(arrRow.size()==0)
{
	if(!event_type.equals("") && !standard_code.equals("")){
	%>
		<script>
			alert(getMessage('XH1016','XH'));
		</script> 
	<% }
	else { 
		%>
		<script>
			alert(getMessage('XH1021','XH'));
		</script> 
<%  
	}														  
}
else { %>

	




		<%
/*			while(rs.next())
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			*/

		for (int j=0; j<arrRow.size();j++)
		{
			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
//				strTDClass = "class='QRYEVEN'";
				classValue = "QRYEVEN" ;
				boolToggle =  false;
			}
			else
			{
//				strTDClass = "class='QRYODD'";
				classValue = "QRYODD" ;
				boolToggle =  true;
			}


 
			segment_type=(String)arrCol.get(0);
			segment_name=(String)arrCol.get(1);
			optional_yn=(String)arrCol.get(2);
			in_use_yn=(String)arrCol.get(3);
			
			stnd_desc=XHDBAdapter.checkNull((String)arrCol.get(4));
			stnd_code=XHDBAdapter.checkNull((String)arrCol.get(7));
			event_type_id=(String)arrCol.get(5);
           
         

	/*		segment_type=rs.getString(1);
			segment_name=rs.getString(2);
			optional_yn=rs.getString(3);
			in_use_yn=rs.getString(4);
			stnd_desc=XHDBAdapter.checkNull(rs.getString(5)); */ 

		if(segment_type.equals("ALL"))
		{
		} 
		else
		{

		   %>
			<tr>
				<% if(fun_id.equals("SWTCHEVENT"))
			{%>
			<td class='<%=classValue%>' align=left ><a href='#'  segment_type='<%=segment_type%>'  fun_id='<%=fun_id%>' onMouseDown='funShowpPopup(this)' > <%=segment_type%></td>  
			<%}else
			{%>
				<td class='<%=classValue%>' align=left ><a href='#'  segment_type='<%=segment_type%>'  fun_id='' onMouseDown='funShowpPopup(this)' ><%=segment_type%></td>
			 <%}%>

			<td class='<%=classValue%>' align=left ><%=segment_name%></td>
			<% if (stnd_code.equals("")){ %>
				<td class='<%=classValue%>' align=left >&nbsp;</td><%} else {%>
				<td class='<%=classValue%>' align=left ><%=stnd_code%></td> <%
			} %>
			<td class='<%=classValue%>' align=left ><%=event_type_id%></td>
			<td class='<%=classValue%>' align=center >
			
			<%----	<%if(event_type.equals("I13") || event_type.equals("I14") || event_type.equals("O01") ||  event_type.equals("O02") ||  event_type.equals("R01") ||  event_type.equals("R02") ||  event_type.equals("R04") ||  event_type.equals("R05"))														  
			{
			%>
            <input type=checkbox name='<%=segment_type+event_type_id+"_optional_yn"%>' id='<%=segment_type+event_type_id+"_optional_yn"%>'   value='N' disabled=true></td>	
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=segment_type+event_type_id+"_inuse1"%>' id='<%=segment_type+event_type_id+"_inuse1"%>' 
			 value='N' disabled>
			<input type=hidden name='<%=segment_type+event_type_id+"_inuse"%>' id='<%=segment_type+event_type_id+"_inuse"%>'  
			value='N'> <input type=hidden name='<%=segment_type+event_type_id+"_field"%>' id='<%=segment_type+event_type_id+"_field"%>' id='<%="_field"+j%>' value='<%=(String)arrCol.get(8)%>'>

			<%}else{ %>	-----%>
			<input type=checkbox name='<%=segment_type+event_type_id+"_optional_yn"%>' id='<%=segment_type+event_type_id+"_optional_yn"%>' <%=optional_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=optional_yn.equals("Y")?"Y":"N"%>' disabled=true></td>	
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=segment_type+event_type_id+"_inuse1"%>' id='<%=segment_type+event_type_id+"_inuse1"%>' 
			<%= in_use_yn.equals("Y")?"checked":""%> onClick="validatecheckbox(this,'<%=segment_type+event_type_id+"_inuse1"%>' ,'<%=j%>');"  <%=optional_yn.equals("Y")?"":"disabled=true"%> value='<%= in_use_yn%>'>
			<input type=hidden name='<%=segment_type+event_type_id+"_inuse"%>' id='<%=segment_type+event_type_id+"_inuse"%>'  
			value='<%= in_use_yn%>'> <input type=hidden name='<%=segment_type+event_type_id+"_field"%>' id='<%="_field"+j%>' value='<%=(String)arrCol.get(8)%>'>
	<%---<%}%>-----%>
			</td>																			 
			
			<!-- <%=optional_yn.equals("Y") && in_use_yn.equals("Y")?"checked":""%>  value='<%=in_use_yn.equals("Y")?"Y":"N"%>' -->
			</tr>  
			<% 
	//			i++;
			}								    
		} // end of for
		} // end of else											  
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				if(resultsQry!=null) resultsQry.clear();
//		} // end of stnd_code chk
}catch(Exception e1)
{
		
		System.out.println("EventTypeEventwiseSegmentDisplay.jsp Exc : "+e1.toString());
}
finally{
			try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		//	ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("EventTypeEventwiseSegmentDisplay.jsp Exception2 is "+e);
				}
		
			}
%>
<input type=hidden name=event_type value=<%=event_type%>>
<input type=hidden name=stnd_code value=<%=standard_code%>>
<input  type=hidden name=locale value=<%=locale%> >
<input type='hidden' name='action_type' id='action_type' value=''>
<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='node' id='node' value='<%=node%>'>  
</table> 
<%	  														   
				try{	
					String qrybutton="select 1 from sm_menu_dtl where submenu_id='XH_JG_DEVELOPMENT_CONFIG'";
						statment= con.createStatement();
						rset = statment.executeQuery(qrybutton);
						while(rset.next()) 
						{
								 b_e_d=XHDBAdapter.checkNull(rset.getString(1));
							   if(b_e_d.equals(""))
							{
								   b_e_d="";
							}
							else
							{
								String qrybutton2="select 1 from SM_MENU_RSTRN_RESP where submenu_id='XH_JG_DEVELOPMENT_CONFIG'";
							   rsets = statment.executeQuery(qrybutton2);
							   while(rsets.next()) 
								{
								   b_e_d="";
									   //XHDBAdapter.checkNull(rsets.getString(1));
								}
							}
						}
					}catch(Exception e1)
{
		System.out.println("EventTypeMessageTypeDisplay.jsp Exc1: "+e1.toString());
}
finally{
			try{
				if(rset!=null)rset.close();	 
				if(rsets!=null)rsets.close();
				if(statment!=null)statment.close();
				ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("EventTypeMessageTypeDisplay Exception2 is "+e);
				}
		
			} 

			  %>
 <table border='0' width='100%' <%=b_e_d.equals("")?"style=display:none":"style=display:block"%>> 
	 <tr><td class="button" align="right" nowrap ><input type="button" class="button" align="left" onClick="funEventAdd()" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' width='25%' class="button">
	</td></tr></table>
   	<input type=hidden name=fun_id id=fun_id value='<%=fun_id%>'>
</form>
</body>
</html>																				  

