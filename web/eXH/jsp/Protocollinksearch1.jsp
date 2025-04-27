<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.net.*,java.util.*,java.lang.String,java.util.ArrayList,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/ProtocollinkRefrence.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>

<script Language="JavaScript">
function funSubmit2()
{
	//var tabletextvalue=document.getElementById(k+"_C/E");
		//var tabletextvalue1=document.getElementById(k+"_EV");
		//	var tabletextvalue2=document.getElementById(k+"_EO");
			//	var tabletextvalue3=document.getElementById(k+"_EV2");
				//	var tabletextvalue4=document.getElementById(k+"_PO");
	//var elTableCells = this.document.ProfileRef.elTableRow.value;
//alert(tabletextvalue.value+"tabletextvalue1.value"+tabletextvalue1.value+"tabletextvalue.value"+tabletextvalue2.value+"tabletextvalue.value"+tabletextvalue3.value+"tabletextvalue.value"+tabletextvalue4.value);

var act="../../eXH/jsp/Protocollinkupdate.jsp?action_type=R";
	this.document.forms[0].action = act;
  //this.document.forms[0].action_type.value='U';
	this.document.forms[0].target='messageFrame';
	this.document.forms[0].submit();
	
	
	//var act="../../servlet/eXH.DataElementCrossRefSearchServlet?application_id="+application_id1+"&element_id="+element_id1;
	//this.document.forms[0].action = act;
  //this.document.forms[0].action_type.value='U';
	//this.document.forms[0].target='messageFrame';
	//this.document.forms[0].submit();
}
function func1(element_id,element_name,derivation_type,in_use_yn,condition_exp1_val,expected_value,execution_order,expected_value2,position,application_id)
{
var url='element_id='+escape(element_id)+'&derivation_type='+derivation_type+'&expected_value='+expected_value+'&execution_order='+execution_order+'&expected_value2='+expected_value2+'&position='+position+'&condition_exp1_val='+condition_exp1_val+'&application_id='+application_id+'&act_mode=D';
this.parent.frames[2].document.location.href="../../eXH/jsp/ProtocollinkRefElementIDDeleteModify.jsp?"+url;

}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload="hide();">
<form name="ProfileRef" id="ProfileRef" method="POST"  >
<script>
function hide()
{


/*var value=parseInt(document.forms[0].count_value.value);

for(var i=0; i<value;i++)
	{
	

	if(document.getElementById(i+"_E").value==""||document.getElementById(i+"_E").value==null)
		{
document.getElementById(i+"_E").disabled=true;
		}
		else
		{
			document.getElementById(i+"_E").disabled=false;
		}
	}*/

}
</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload='hide();'>
<form name="ProfileRef" id="ProfileRef" method="POST"  >
<%
	int count=0;


boolean boolToggle =  true;	

String strBeanName = XHApplicationDerivationProfileSetupControllerBean.strBeanName;
//System.out.println("strBeanName"+strBeanName);
 String application_id="";
  String element_id="";
  String whereClause="";
  String qry_id = "VIEWXHPROTOCOLLINKDERVNRULES";
  application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
element_id=URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("element_id")),"utf-8");


if(application_id.equals("") )
{
if(element_id.equals(""))
	{

whereClause=" where A.ELEMENT_ID=B.ELEMENT_ID ";

	}
else 
	{
out.println("<script>alert('ApplicationID cannt Be Blank');</script>");
out.println("<script>parent.frames[1].document.forms[0].reset();</script>");

	}

}
else if(application_id!=null  )
{

	if(element_id.equals(""))
	{

	 whereClause=" where A.ELEMENT_ID=B.ELEMENT_ID and A.PROTOCOL_ID='"+application_id+"'  " ;

	}
	else
	{
		
whereClause=" where A.ELEMENT_ID=B.ELEMENT_ID and A.PROTOCOL_ID='"+application_id+"' and A.ELEMENT_ID='"+element_id+"' " ;

	}
}



 request.setAttribute(XHQueryRender.strQueryId,qry_id);
request.setAttribute(XHQueryRender.whereClause,whereClause);
Connection conn = null;
try
{


	conn = ConnectionManager.getConnection(request);

		XHApplicationDerivationProfileSetupControllerBean	xhBean = XHApplicationDerivationProfileSetupControllerBean.getBean(strBeanName,request,session);
	//XHDervationControllerBean xhBean = XHDervationControllerBean.getBean(strBeanName,request,session,response);
	xhBean.action(request,conn);

	HashMap resultsQry = xhBean.getResultSet();
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
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
	<table name=elTableRow border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
<td colspan="4" align="right" class="CAGROUP" >
	</td>
	
	<td colspan="4" align="right" class="CAGROUP" > 
<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext%></A>
</td>


</tr>
<!--
<td class='COLUMNHEADER' width='35%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td> -->
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.ProtocolLinkId.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.DerivationType.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.CondExpr.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ExpectedValue1.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ExecOrder.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ExpectedValue2.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
</tr>

<%

if(arrRow.size()==0)
	{

%>
	<script>
alert(getMessage('XH1021','XH'));
</script>

		
	<%
				}else{
	%>


	
<%

String strstyle = "";

for(int i=0;i<arrRow.size();i++)
{
	arrCol = (ArrayList)arrRow.get(i);

	if (boolToggle == true)
		{
			strstyle = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strstyle = "class='QRYODD'";
			boolToggle =  true;
		}
%>

<td <%=strstyle%> align="left" nowrap>
<a  href=" javascript:func1('<%=URLEncoder.encode((String)arrCol.get(0)) %>','<%= (String)arrCol.get(1) %>','<%=(String)arrCol.get(2)%>','<%= (String)arrCol.get(3)%>',
  '<%= (String)arrCol.get(6)%>','<%= (String)arrCol.get(4)%>','<%= (String)arrCol.get(5)%>','<%= (String)arrCol.get(7) %>','<%= (String)arrCol.get(8) %>','<%= (String)arrCol.get(9) %>');">
  &nbsp;<%=((String)arrCol.get(9)).equals("null")?"":((String)arrCol.get(9)) %>
</td>

<td <%=strstyle%> align="left" nowrap>
<input type='hidden' id=<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"Pr"%> name='<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"Pr"%>' value=<%=(String)arrCol.get(9)%> >
<input type='hidden' id=<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"El"%> name='<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"El"%>' value='<%=(String)arrCol.get(0)%>' >

<input type='hidden'  name='<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"C"%>' id='<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"C"%>' value='<%=(String)arrCol.get(2)%>' >
<INPUT TYPE="text" id='<%=i+"C1"%>' NAME="<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"C1"%>" value="<%=XHDBAdapter.checkNull((String)arrCol.get(2))%>" disabled>

	
	
	</td>

	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text" id=<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"CE"%> NAME="<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"CE"%>" value="<%=XHDBAdapter.checkNull((String)arrCol.get(6))%>">
	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text"  id=<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"EV"%> NAME="<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"EV"%>" value="<%=XHDBAdapter.checkNull((String)arrCol.get(4))%>">
	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text"  id=<%=arrCol.get(0)+"_E1"%> NAME="<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"_E1"%>" value="<%=XHDBAdapter.checkNull((String)arrCol.get(5))%>" size=8 disabled>
<input type='hidden' id='<%=i+"_E"%>' name='<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"_E"%>' value='<%=XHDBAdapter.checkNull((String)arrCol.get(5))%>' ></td> 
	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text" id=<%=arrCol.get(0)+"EV2"%> NAME="<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"EV2"%>" value="<%=XHDBAdapter.checkNull((String)arrCol.get(7))%>" <%=XHDBAdapter.checkNull((String)arrCol.get(7)).equals("")?"disabled":""%>>
		<input type='hidden' id='<%=i+"_E"%>' name='<%=i+"_E"%>' value='<%=XHDBAdapter.checkNull((String)arrCol.get(5))%>' >

	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text" id=<%=arrCol.get(0)+"P"%> NAME="<%=((String)arrCol.get(0))+((String)arrCol.get(2))+"P"%>" value="<%=XHDBAdapter.checkNull((String)arrCol.get(8))%>">

	</td>
	
	</tr>




<%

	
   


}	 
count=arrRow.size();


    }
}
    catch(Exception exp)
    {
       System.out.println("Error in populatexhcodedesc method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }


finally
	{
		ConnectionManager.returnConnection(conn);
	}
%>
	

		<input type="hidden" name="Mode" id="Mode" value='U' ><input type='hidden' name='action_type' id='action_type' value='' >
<input type="hidden" name="count_value" id="count_value" value='<%=count%>' >
	</table> 


</form>
</body>
</html>


