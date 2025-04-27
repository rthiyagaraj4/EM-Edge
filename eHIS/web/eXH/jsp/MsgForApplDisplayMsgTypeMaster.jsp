<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE")); 
locale = "en"; %>
<%  
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/Validate.js" ></script>						    
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script> 
<script language="JavaScript">

//function validatecheckbox   
function validatecheckbox(obj,whichelement,event_type)  
{

/*&if(event_type=='I13' || event_type=='I14' || event_type=='O01' ||  event_type=='O02' ||  event_type=='R01' ||  event_type=='R02' ||  event_type=='R04' ||  event_type=='R05')
{
document.getElementById(event_type+"_inuse").checked=false;	

var replace=getMessage('XH0069','XH').replace('$',event_type);
	alert(replace);

obj.value="N"; 
}*/
	document.getElementById("_field"+whichelement).value="Y";
	if(obj.checked==true)
	obj.value="Y"; 
	else
	obj.value="N";	
}

//function chkChange 
function chkChange(obj,whichelement)
{
	
	document.getElementById("_field"+whichelement).value="Y";
//	alert(obj.value);
	var temp=obj.value;
	if(obj.mastcommtype!='*')
	{ 
//	alert("obj.mastcommtype : "+obj.mastcommtype);
	obj.value=obj.mastcommtype;
	}
}

function funAction(typ)
{
	this.document.forms[0].target = 	"";
//	alert(parent.parent.frames[3].name);
//	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].action_type.value = typ;
	this.document.forms[0].action = '../../eXH/jsp/MsgForApplDisplayMsgTypeMaster.jsp';
	this.document.forms[0].submit();
}


async function funShowEvntViewer(obj)
{
	var event_id = obj.getAttribute('event_type'); 
//		alert("event_id : "+event_id);
	var event_name = obj.getAttribute('event_name');
//		alert("event_name : "+event_name);
	var stand_code = obj.getAttribute('standard_code');
//		alert("stand_code : "+stand_code);
	var appl_id = obj.getAttribute('appl_id');
//		alert("appl_id : "+appl_id);
	var appl_name = obj.getAttribute('appl_name');
//		alert("appl_name : "+appl_name);
	var url = '../../eXH/jsp/EventTypeMessageViewerMain.jsp?event_id='+event_id+'&event_name='+event_name+'&appl_id='+appl_id+'&stand_code='+stand_code+'&appli_name='+appl_name;
	var arguments  =new Array();
	
	var dialogHeight = "250";
	var dialogWidth  = "250"; 
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	await window.showModalDialog(url,arguments,features); 
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
Connection con=null;
Statement stmt1=null;
ResultSet rs1=null;
//int i=0;
ArrayList arrRow = null;
ArrayList arrCol = null;
String strPrevious = "";  
String strNext  = "";
HashMap resultsQry=null;  
String classValue="";
String event_type="";
String event_name="";
//String stnd_desc="";
String commn_type="";
String mast_commn_type="";
String dtl_commn_type="";
String status="";
String strBeanName = XHApplicationElementControllerBean.strBeanName;  
String msg_type=XHDBAdapter.checkNull(request.getParameter("message_type"));
//	System.out.println("msg_type : "+msg_type);
String appl_id=request.getParameter("appl_id");
//	System.out.println("appl_id : "+appl_id);
String appl_name = request.getParameter("appl_name");

String standard_code = XHDBAdapter.checkNull(request.getParameter("standard_code"));
//	System.out.println("standard_code : "+standard_code);
String interfaced_y_n="";
String msg_type_code ="";

boolean flag_rec_enbld = false;
String stnd_code = "";

%>
<form name="ApplicationEventListForMessageTypeForm" id="ApplicationEventListForMessageTypeForm" target='messageFrame' method='post' >
<%


			request.setAttribute("application_Id",appl_id);
			request.setAttribute("message_type",msg_type);
            request.setAttribute("standard_code",standard_code);
       try
	 {
		  if(con==null)
		  con = ConnectionManager.getConnection(request);
	/* }
	 catch(Exception e)
	 {
		 System.out.println(" MsgForApplDisplayMsgTypeMaster :"+e);
	 }
	try{ */
		boolean boolToggle =  true;	
		//String qry_id = "MSGFORAPPLEVNTYP";

//		con=ConnectionManager.getConnection();
		String sql1="";

		// Checking  Records in  - XH_EVENT_TYPE 

		sql1="SELECT EVENT_TYPE,STANDARD_CODE,MESSAGE_TYPE FROM XH_EVENT_TYPE WHERE INTERFACE_YN  ='Y' AND DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)= NVL('"+msg_type+"',DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)) AND DECODE(STANDARD_CODE,NULL,'XX',STANDARD_CODE)= nvl('"+standard_code+"',Decode(STANDARD_CODE,NULL,'XX',STANDARD_CODE))   ";

		 stmt1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
//		System.out.println("MsgForApplDisplayMsgTypeMaster sql1 : "+sql1);
	   	rs1=stmt1.executeQuery(sql1);
        rs1.last(); 
//		System.out.println("MsgForApplDisplayMsgTypeMaster - rs1.getRow() : "+rs1.getRow());
		if(rs1.getRow()==0)
		{ %>
			<script> 
		
			alert(getMessage('XH1014','XH'));
			//	Events are not Interfaced against Standard and Message Type 
			</script>
			<%
		} 

		else
		{  
		
		

			
			XHMsgForApplicationElementControllerBean	xhBean = XHMsgForApplicationElementControllerBean.getBean(strBeanName,request,session);
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
<%
//			System.out.println("arrRow.size() : "+arrRow.size());
if(arrRow.size()==0)
{
	if(!msg_type.equals("") && !standard_code.equals(""))
	{
	%>
		<script>
			alert(getMessage('XH0059','XH'));
		</script> 
	<% 
	}
	else
	{ 
		%>
		<script>
			alert(getMessage('XH1021','XH'));
		</script>
	<%
	}
}
else { %>
	<tr>
	<td colspan="6" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

	<!--%>	<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center> -->
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/>
<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.StandardType.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='12%'><fmt:message key="eXH.CommMode.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'> <fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>  
<%

		for (int j=0; j<arrRow.size();j++)
		{
			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
				classValue = "QRYEVEN" ;				 
				boolToggle =  false;
			}
			else
			{
				classValue = "QRYODD" ;
				boolToggle =  true;
			}
			
			event_type=(String)arrCol.get(0);
			event_name=(String)arrCol.get(1);
			stnd_code=XHDBAdapter.checkNull((String)arrCol.get(2));
			msg_type_code = XHDBAdapter.checkNull((String)arrCol.get(3));
			mast_commn_type=(String)arrCol.get(4);
			interfaced_y_n=XHDBAdapter.checkNull((String)arrCol.get(5));
		
			status = XHDBAdapter.checkNull((String)arrCol.get(7));

			
			dtl_commn_type=XHDBAdapter.checkNull((String)arrCol.get(6));
	//			System.out.println("dtl_commn_type : "+dtl_commn_type);
			if((dtl_commn_type == null)||(dtl_commn_type.equals(""))||(dtl_commn_type.equals("null")))
			commn_type=mast_commn_type;
			else commn_type=dtl_commn_type;
	//			System.out.println("commn_type : "+commn_type);
			%>

			

<tr> 
		 <td class='<%=classValue%>'   event_type="<%=event_type%>" 
			event_name="<%=event_name%>"  standard_code="<%=stnd_code%>"  
			appl_id= "<%=appl_id%>"  appl_name= "<%=appl_name%>" 
			onClick='funShowEvntViewer(this)'>
			<a href="#"><%=event_type%></a></td>
		     <%---  <td class='<%=classValue%>'><%=event_type%></td>---%> 
			<%
			if (status.equals("G")){ 
				flag_rec_enbld = true; %>
            <td class='<%=classValue%>' align=left ><font color=green><%=event_name%></font></td><%} else {%>
			<td class='<%=classValue%>' align=left ><%=event_name%></td> <%} %>

            <% if (stnd_code.equals("")){ %>
				<td class='<%=classValue%>' align=left >&nbsp;</td><%} else {%>
				<td class='<%=classValue%>' align=left ><%=stnd_code%></td> <%
			} %>

			 <% if (msg_type_code.equals("")){ %>
				<td class='<%=classValue%>' align=left >&nbsp;</td><%} else {%>
				<td class='<%=classValue%>' align=left ><%=msg_type_code%></td> <%
			} %>
			
			<td class='<%=classValue%>' align=left >
			<select mastcommtype='<%=mast_commn_type%>' name='<%=arrCol.get(0)+"_type1"%>' onchange="chkChange(this,'<%=j%>');" disabled style="width:200">
			<option  value='O' <%=commn_type.equals("O")?"selected":""%>><fmt:message key="eXH.Outbound.Label"  bundle="${xh_labels}"/></option>
			<option value='I' <%=commn_type.equals("I")?"selected":""%>><fmt:message key="eXH.Inbound.Label"  bundle="${xh_labels}"/></option>
			<option value='*' <%=commn_type.equals("*")?"selected":""%>><fmt:message key="Common.Both.label"  bundle="${common_labels}"/></option> 
           	</select>
			 <input type=hidden name=name= id=name='<%=arrCol.get(0)+"_type"%>'  value='<%=commn_type%>' >
			</td>
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=arrCol.get(0)+"_inuse"%>' id='<%=arrCol.get(0)+"_inuse"%>' <%=interfaced_y_n.equals("Y")?"checked":""%> onClick="validatecheckbox(this,'<%=j%>','<%=(String)arrCol.get(0)%>');" value='<%=interfaced_y_n.equals("Y")?"Y":"N"%>'><input type=hidden name='<%=arrCol.get(0)+"_field"%>' id='<%=arrCol.get(0)+"_field"%>'  id='<%="_field"+j%>' value='<%=(String)arrCol.get(9)%>'></td>	
			</tr>

<% 
		}
}  
			} // end of else - If records found in XH_EVENT_TYPE
}catch(Exception e1)
{
		System.out.println("MsgForApplDisplayMsgTypeMaster.jsp Exc : "+e1.toString());
		e1.printStackTrace(System.err);
}
finally
{
			try{
			if(stmt1!=null)stmt1.close();
			if(rs1!=null)rs1.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("Exception in MsgForApplDisplayMsgTypeMaster.jsp :  "+e);
				}			
}
		%>
<tr>
 <% if (flag_rec_enbld == true)
 { %>
	
	<td colspan=7 class=label><img src='../../eXH/images/green_square.jpg' width=40 height=15 >Recently Enabled Elements</td> 

   
			</tr>
		<%
 } else
 {	%>  

 <%
 }		%>
 </table>
<input type=hidden name=message_type id=message_type value=<%=msg_type%>>
<input type=hidden name=appl_id id=appl_id value=<%=appl_id%>>
<input type=hidden name=stnd_code id=stnd_code value=<%=standard_code%>>
<input type=hidden name=appl_name id=appl_name value=<%=java.net.URLEncoder.encode(appl_name)%>>
<input type=hidden name=status id=status value=''>
<input type=hidden name=option id=option value='event'>
<input type='hidden' name='action_type' id='action_type' value=''>  

</form>
</body>
</html>

