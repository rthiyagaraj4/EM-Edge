<!DOCTYPE html>
<HTML> 
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter,java.io.*"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%// String locale = ((String)session.getAttribute("LOCALE"));	
 %>
<HEAD>
<%  
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>

<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
//function validatecheckbox  
function validatecheckbox(obj,whichelement,event_type)
{

		
/*if(event_type=='I13' || event_type=='I14' || event_type=='O01' ||  event_type=='O02' ||  event_type=='R01' ||  event_type=='R02' ||  event_type=='R04' ||  event_type=='R05')
{
document.getElementById(event_type+"_inuse").checked=false;	 

var replace=getMessage('XH0069','XH').replace('$',event_type); 
alert(replace);
obj.value="N";
}
else
{*/
	document.getElementById(event_type+"_field").value="Y";
	if(obj.checked==true)
	obj.value="Y";
	else
	obj.value="N";
//}



	
}

function funAction(typ){
	this.document.forms[0].target = 	"";
//	alert(parent.parent.frames[3].name);
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	this.document.forms[0].action_type.value = typ;
	this.document.forms[0].action = '../../eXH/jsp/EventTypeMessageTypeDisplay.jsp';
	this.document.forms[0].submit();
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
//int i=0;
String classValue="";
String event_type="";
String event_name="";
String commn_type="";
String msg_type=request.getParameter("message_type");
String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
//	System.out.println("standard_code : "+standard_code);
String interfaced_y_n="";
ArrayList arrRow = null;
ArrayList arrCol = null;
String strPrevious = "";  
String strNext  = "";
HashMap resultsQry=null; 
String stnd_desc="";
String generic_y_n="";
String solicited_yn = "";
//String sql  = "";
//String stnd_flag = "";
//String sngl_recflag = "N";
 
//ArrayList Stnd_code = new ArrayList();


%>
<form name="MasterEventListForMessageTypeForm" id="MasterEventListForMessageTypeForm" target='messageFrame' method='post' action=''>
<%
			boolean boolToggle =  true;	
	//		String strTDClass = "";
			//String qry_id = "EVENTTYPES"; 
	//		Connection conn = null;
			//String whereClause = "WHERE  ";

			//whereClause	=	whereClause+"   DECODE(A.MESSAGE_TYPE,NULL,'XX',A.MESSAGE_TYPE) = 	 	 NVL('"+msg_type+"',DECODE(A.MESSAGE_TYPE,NULL,'XX',A.MESSAGE_TYPE)) AND A.LANGUAGE_ID='"+locale+"' and A.STANDARD_CODE=C.STANDARD_CODE(+)      AND DECODE(a.standard_code,NULL,'XX',a.standard_code) = 	 	 NVL('"+standard_code+"',DECODE(a.standard_code,NULL,'XX',a.standard_code))  ORDER BY A.EVENT_TYPE ";
try{
//		con=ConnectionManager.getConnection();
/*		
		if(!msg_type.equals("")){
			sql = "SELECT distinct STANDARD_CODE FROM XH_EVENT_TYPE_LANG_VW WHERE DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE) = 	 	 NVL('"+msg_type+"',DECODE(MESSAGE_TYPE,NULL,'XX',MESSAGE_TYPE)) ";
		}
		else if(msg_type.equals("")&&!standard_code.equals("")){
			sql = "SELECT distinct STANDARD_CODE FROM XH_EVENT_TYPE_LANG_VW WHERE DECODE(standard_code,NULL,'XX',standard_code)	  = 	 	 NVL('"+standard_code+"', DECODE(standard_code,NULL,'XX',standard_code)) ";
		}

		if(sql!=""){
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
			rs.last(); 
			if(rs.getRow()==0)
			{ 
			stnd_flag = "NoRec";
						%>
	<!--		<script>
				alert(getMessage('XH1021','XH'));		
			</script> -->
			<%
/*			}
			else{
				if(!msg_type.equals("") && !standard_code.equals("")){
					rs.beforeFirst();
					while(rs.next()){
						Stnd_code.add(XHDBAdapter.checkNull(rs.getString(1)));
					}
					System.out.println("Stnd_code.size() : "+Stnd_code.size());
				
					for(int j=0;j<Stnd_code.size();j++){
							stnd_flag = "N";
						if(standard_code.equals(Stnd_code.get(j))){
							stnd_flag = "Y";
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();
							break;
						}
					} // end of for
				} // end of stnd_code null chk
			} // rcrds exist in XH_EVENT_TYPE
		} // end of sql

		System.out.println("stnd_flag : "+stnd_flag);
        if(stnd_flag.equals("N")){
				%>
		<!--		<script>
					//alert(getMessage('XH1016','XH'));
					alert("Selected Standard & Message type Combination is incorrect");
				</script> -->
				<%
/*		} // end of stnd_flah chk

		else{
			if(!stnd_flag.equals("NoRec")){
*/
    // cmmntd on Oct31st
	//			sql="SELECT A.EVENT_TYPE,A.EVENT_NAME,A.INTERFACE_YN,A.COMMUNICATION_TYPE,C.STANDARD_DESC,A.GENERIC_YN FROM XH_EVENT_TYPE_LANG_VW A,XH_STANDARD C WHERE      DECODE(A.MESSAGE_TYPE,NULL,'XX',A.MESSAGE_TYPE) = 	 	 NVL('"+msg_type+"',DECODE(A.MESSAGE_TYPE,NULL,'XX',A.MESSAGE_TYPE)) AND A.LANGUAGE_ID='"+locale+"' and A.STANDARD_CODE=C.STANDARD_CODE(+)      AND DECODE(a.standard_code,NULL,'XX',a.standard_code) = 	 	 NVL('"+standard_code+"',DECODE(a.standard_code,NULL,'XX',a.standard_code))  ORDER BY A.EVENT_TYPE ";

			// added on Oct 31st

			//	sql="SELECT A.EVENT_TYPE,A.EVENT_NAME,A.INTERFACE_YN,A.COMMUNICATION_TYPE,C.STANDARD_DESC,A.GENERIC_YN,A.STANDARD_CODE,A.MESSAGE_TYPE,A.SOLICITED_YN FROM XH_EVENT_TYPE_LANG_VW A,XH_STANDARD C WHERE      DECODE(A.MESSAGE_TYPE,NULL,'XX',A.MESSAGE_TYPE) = 	 	 NVL('"+msg_type+"',DECODE(A.MESSAGE_TYPE,NULL,'XX',A.MESSAGE_TYPE)) AND A.LANGUAGE_ID='"+locale+"' and A.STANDARD_CODE=C.STANDARD_CODE(+)      AND DECODE(a.standard_code,NULL,'XX',a.standard_code) = 	 	 NVL('"+standard_code+"',DECODE(a.standard_code,NULL,'XX',a.standard_code))  ORDER BY A.EVENT_TYPE ";

//		System.out.println("EventTypeMessageTypeDisplay sql : "+sql);
       // added on Oct 31st
/*		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.last(); 
		if(rs.getRow()==1){
				sngl_recflag = "Y";
		}	
		rs.beforeFirst(); */
//		qry_id = sql;

		request.setAttribute("message_type",msg_type);
             request.setAttribute("standard_code",standard_code);
        //  request.setAttribute(XHMsgForApplicationElementControllerBean.element_desc,element_desc); 
	        con = ConnectionManager.getConnection(request);
			XHEventApplicationElementControllerBean	xhBean = XHEventApplicationElementControllerBean.getBean(XHEventApplicationElementControllerBean.strBeanName,request,session);
			xhBean.action(request,con);
			resultsQry = xhBean.getResultSet();
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
        strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			if (boolPrevious == true)
			{ 
				strPrevious =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
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
if(arrRow.size()==0)
{
	if(!msg_type.equals("") && !standard_code.equals("")){
	%>
		<script>
			alert(getMessage('XH0059','XH'));
		</script> 
	<% }
	else { 
		%>
		<script>
//			alert(getMessage('XH1021'));
		alert(getMessage('XH1021','XH'));

		</script>
	<%
	}
}
else { %> 
	<tr>
	<td colspan="7" align="right" class="CAGROUP" > 




	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<!--commntd on Oct31st
//		stmt=con.createStatement();
//	  	rs=stmt.executeQuery(sql);
	%>	-->
<!--<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center> -->
<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/>
<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<!--<td class='COLUMNHEADER'>  <fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td> -->
<td class='COLUMNHEADER' width='15%'> <fmt:message key="eXH.StandardType.Label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.CommMode.Label" bundle="${xh_labels}"/></td>
<!--<td class='COLUMNHEADER' width='7%'>Generic</td> -->
<td class='COLUMNHEADER' width='7%'><fmt:message key="eXH.Solicited.Label" bundle="${xh_labels}"/></td> 
<!-- <td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.Interfaced.Label" bundle="${xh_labels}"/></td> -->
<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>  

	<%
		/*while(rs.next())
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ; */
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
	
			    

			event_type=(String)arrCol.get(0);
			event_name=(String)arrCol.get(1);
			interfaced_y_n=(String)arrCol.get(5);
			commn_type=(String)arrCol.get(6);
			stnd_desc=XHDBAdapter.checkNull((String)arrCol.get(8));
			generic_y_n=XHDBAdapter.checkNull((String)arrCol.get(4));
			// added on Oct 31st
//			if(sngl_recflag.equals("Y")){
				standard_code =  XHDBAdapter.checkNull((String)arrCol.get(2));
				msg_type = XHDBAdapter.checkNull((String)arrCol.get(3));
//			}
			solicited_yn = XHDBAdapter.checkNull((String)arrCol.get(7));
	%>

			<tr> 
			<td class='<%=classValue%>' align=left ><%=event_type%></td>
			<td class='<%=classValue%>' align=left ><%=event_name%></td>
			<% if (standard_code.equals("")){ %>
				<td class='<%=classValue%>' align=left >&nbsp;</td><%} else {%>
				<td class='<%=classValue%>' align=left ><%=standard_code%></td> <%
			} %>
			 <% if (msg_type.equals("")){ %>
				<td class='<%=classValue%>' align=left >&nbsp;</td><%} else {%>
				<td class='<%=classValue%>' align=left ><%=msg_type%></td> <%
			} %>
			<td class='<%=classValue%>' align=left >
				<select name='<%=event_type+"_comm_type"%>' id='<%=event_type+"_comm_type"%>' disabled> 
			
				<option  value='O' <%=commn_type.equals("O")?"selected":""%>><fmt:message key="eXH.Outbound.Label"  bundle="${xh_labels}"/></option>
				<option value='I' <%=commn_type.equals("I")?"selected":""%>><fmt:message key="eXH.Inbound.Label"  bundle="${xh_labels}"/></option>
				<option value='*' <%=commn_type.equals("*")?"selected":""%>><fmt:message key="Common.Both.label"  bundle="${common_labels}"/></option> 
				</select> 
			</td>
<!--			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=event_type%>_generic_yn' id='<%=event_type%>_generic_yn' <%=generic_y_n.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=interfaced_y_n.equals("Y")?"Y":"N"%>' disabled></td>-->
<!-- solicitedYN -->
 

				<input type=hidden name='<%=event_type+"_field"%>' id='<%=event_type+"_field"%>' id='<%="_field"+j%>' value='<%=(String)arrCol.get(9)%>'>  
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=event_type+"_solicited_yn"%>' id='<%=event_type+"_solicited_yn"%>' <%=solicited_yn.equals("Y")?"checked":""%> onClick='validatecheckbox(this);' value='<%=solicited_yn.equals("Y")?"Y":"N"%>' disabled></td>

			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=event_type+"_inuse"%>' id='<%=event_type+"_inuse"%>' <%=interfaced_y_n.equals("Y")?"checked":""%> onClick="validatecheckbox(this,'<%=j%>','<%=event_type%>');" value='<%=interfaced_y_n.equals("Y")?"Y":"N"%>'></td>	
			</tr>
			<%
			} // end of for 
		} // end of else
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				if(resultsQry!=null) resultsQry.clear();

	//			i++;

	//	} // rs.next()
//		} // end of stnd_flag chk
//		} // end of No Rec
}catch(Exception e1)
{
		System.out.println("(EventTypeMessageTypeDisplay.jsp:Exc1): "+e1.toString());
}
finally{
			try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("(EventTypeMessageTypeDisplay:Exception-2) "+e);
				}
		
			} 
%>
</table>
<input type=hidden name=msg_text value=<%=msg_type%>>
<input type=hidden name=stnd_code value=<%=standard_code%>>
<input type=hidden name=option value='event'>
<input type='hidden' name='action_type' id='action_type' value=''>

</form>
</body>
</html> 

