<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,java.lang.String,java.util.ArrayList,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ProfiledervationRefrence.js" ></script>
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
  var url='&element_id='+element_id+'&element_name='+element_name+
      '&derivation_type='+derivation_type+'&in_use_yn='+in_use_yn+'&condition_exp1_val='+condition_exp1_val+'&expected_value='+expected_value+'&execution_order='+execution_order+'&expected_value2='+expected_value2+'&position='+position+'&application_id='+application_id+'&act_mode=D';
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


var value=parseInt(document.forms[0].Num_colu.value);

for(var i=0; i<value;i++)
	{
	

	if(document.getElementById(i+"_EV2").value==""||document.getElementById(i+"_EV2").value==null)
		{
document.getElementById(i+"_EV2").disabled=true;
		}
		else
		{
		
				document.getElementById(i+"_EV2").disabled=false;
		}
	}

} 


</script>



<%
//boolean boolToggle =  true;	
String strTDClass = "";
Connection conn = null;
// String strBeanName = XHApplicationDerivationProfileSetupControllerBean.strBeanName;
//HashMap resultsQry=null;
String strPrevious = "";
String strNext  = "";
int columval=0;
try
{
	
	/*conn = ConnectionManager.getConnection(request);
	XHApplicationDerivationProfileSetupControllerBean	xhBean =
	XHApplicationDerivationProfileSetupControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,conn);
	
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/

	}	
catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
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
<tr>
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
  ResultSet rset = null;
  PreparedStatement pstmt = null ;
  String application_id="";
  String element_id="";
  String strstyle="";
  String sql="";
int i=0;
try
	{
if(conn==null) conn = ConnectionManager.getConnection();
 }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of InterfaceStandardAddModifyServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

  try
    {

application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
element_id=XHDBAdapter.checkNull(request.getParameter("element_id"));

//System.out.println("application_id"+application_id+"element_id"+element_id);
if(application_id.equals("") )
{
if(element_id.equals(""))
	{

sql="select B.ELEMENT_ID,B.ELEMENT_NAME,A.DERIVATION_TYPE,B.IN_USE_YN,A.CONDITION_EXP1_VAL,A.EXPECTED_VALUE,A.EXECUTION_ORDER,A.EXPECTED_VALUE2,A.POSITION,A.PROTOCOL_ID from XH_PROTOCOL_LINK_DERVN_RULES A, xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID ";

	}
else 
	{
out.println("<script>alert('ApplicationID cannt Be Blank');</script>");
out.println("<script>parent.frames[1].document.forms[0].reset();</script>");

	}

}
else if(application_id!=null)
{

	if(element_id.equals(""))
	{

	 sql="select B.ELEMENT_ID,B.ELEMENT_NAME,A.DERIVATION_TYPE,B.IN_USE_YN,A.CONDITION_EXP1_VAL,A.EXPECTED_VALUE,A.EXECUTION_ORDER,A.EXPECTED_VALUE2,A.POSITION,A.PROTOCOL_ID from XH_PROTOCOL_LINK_DERVN_RULES A, xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID and A.PROTOCOL_ID='"+application_id+"'  " ;

	}
	else
	{
		
sql="select B.ELEMENT_ID,B.ELEMENT_NAME,A.DERIVATION_TYPE,B.IN_USE_YN,A.CONDITION_EXP1_VAL,A.EXPECTED_VALUE,A.EXECUTION_ORDER,A.EXPECTED_VALUE2,A.POSITION,A.PROTOCOL_ID from XH_PROTOCOL_LINK_DERVN_RULES A, xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID and A.PROTOCOL_ID='"+application_id+"' and A.ELEMENT_ID='"+element_id+"' " ;

	}
}



/* String sql="select B.ELEMENT_ID,B.ELEMENT_NAME,A.DERIVATION_TYPE,B.IN_USE_YN,A.CONDITION_EXP1_VAL,A.EXPECTED_VALUE,A.EXECUTION_ORDER,A.EXPECTED_VALUE2,A.POSITION,A.PROTOCOL_ID from XH_PROTOCOL_LINK_DERVN_RULES A, xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID ";*/

 //System.out.println(sql);
 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
 //strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
// strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	/*		if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/

      while(rset.next())
      {

	//arrRow = (ArrayList)rset.getString(i);

//out.println("rset.next()"+rset.getString(s));

/*try
{
	conn = ConnectionManager.getConnection(request);
	//XHApplicationDerivationSetupControllerBean	xhBean =
	//XHApplicationDerivationSetupControllerBean.getBean(strBeanName,request,session);
	//xhBean.action(request,conn);

	
	resultsQry = xhBean.getResultSet();
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}
	}*/
	
//catch(Exception e1)
//	{
	//	out.println("Error="+e1);
	//}
if((i%2)==0)
		  {
	strstyle = "class='QRYEVEN'";
		  }
		  else
		  {
strstyle = "class='QRYODD'";

		  }


	%>


<td <%=strTDClass%> align="left" nowrap>
<a  href=" javascript:func1('<%=rset.getString(1) %>','<%= rset.getString(2) %>','<%= rset.getString(3)%>','<%= rset.getString(4)%>',
  '<%= rset.getString(5)%>','<%= rset.getString(6)%>','<%= rset.getString(7)%>','<%= rset.getString(8) %>','<%= rset.getString(9) %>','<%= rset.getString(10) %>');">
  &nbsp;<%=rset.getString(10).equals("null")?"":rset.getString(10) %>
</td>

<td <%=strstyle%> align="left" nowrap>
<input type='hidden' id=<%=i+"Profile_ID"%> name='<%=i+"Profile_ID"%>' value=<%=rset.getString(10)%> >
<input type='hidden' id=<%=i+"Element_ID"%> name='<%=i+"Element_ID"%>' value='<%=rset.getString(1)%>' >

<input type='hidden'  name='<%=i+"_Combo"%>' id='<%=i+"_Combo"%>' value='<%=rset.getString(3)%>' >
<INPUT TYPE="text" id=<%=i+"_Combo"%> NAME="<%=i+"_Combo"%>" value="<%=XHDBAdapter.checkNull(rset.getString(3))%>"disabled>

	
	</td>
<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text" id=<%=i+"_C/E"%> NAME="<%=i+"_C/E"%>" value="<%=XHDBAdapter.checkNull(rset.getString(5))%>">
	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text"  id=<%=i+"_EV"%> NAME="<%=i+"_EV"%>" value="<%=XHDBAdapter.checkNull(rset.getString(6))%>">
	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text"  id=<%=i+"_EO1"%> NAME="<%=i+"_EO1"%>" value="<%=XHDBAdapter.checkNull(rset.getString(7))%>" size=8 disabled>
<input type='hidden' name='<%=i+"_EO"%>' id='<%=i+"_EO"%>' value='<%=XHDBAdapter.checkNull(rset.getString(7))%>' ></td> 
	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text" id=<%=i+"_EV2"%> NAME="<%=i+"_EV2"%>" value='<%=XHDBAdapter.checkNull(rset.getString(8))%>'  >

	</td>
	<td <%=strstyle%> align="left" nowrap>
		<INPUT TYPE="text" id=<%=i+"_PO"%> NAME="<%=i+"_PO"%>" value="<%=XHDBAdapter.checkNull(rset.getString(9))%>">

	</td>
	
	</tr>

<%

	i++;
   
      }
columval=i;

%>
	<input type="hidden" name="Num_colu" id="Num_colu" value=<%=columval%>>
	<%
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
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
	

		<input type='hidden' name='action_type' id='action_type' value='U' >
		
	</table> 


</form>
</body>
</html>


