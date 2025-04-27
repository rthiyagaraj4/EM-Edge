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
<script Language="JavaScript"  src="../../eXH/js/filterlayerrefrence4.js" ></script>
<script Language="JavaScript">


/*function funSubmit2()
{
	//var tabletextvalue=document.getElementById(k+"_C/E"); 
		//var tabletextvalue1=document.getElementById(k+"_EV");
		//	var tabletextvalue2=document.getElementById(k+"_EO");
			//	var tabletextvalue3=document.getElementById(k+"_EV2");
				//	var tabletextvalue4=document.getElementById(k+"_PO");
	//var elTableCells = this.document.ProfileRef.elTableRow.value;
//alert(tabletextvalue.value+"tabletextvalue1.value"+tabletextvalue1.value+"tabletextvalue.value"+tabletextvalue2.value+"tabletextvalue.value"+tabletextvalue3.value+"tabletextvalue.value"+tabletextvalue4.value);
var value='U';
var act="../../eXH/jsp/Protocollinkupdate.jsp?action_type="+value;
	this.document.forms[0].action = act;
  this.document.forms[0].action_type.value='U';
	this.document.forms[0].target='messageFrame';
	this.document.forms[0].submit();
	
	
	//var act="../../servlet/eXH.DataElementCrossRefSearchServlet?application_id="+application_id1+"&element_id="+element_id1;
	//this.document.forms[0].action = act;
  //this.document.forms[0].action_type.value='U';
	//this.document.forms[0].target='messageFrame';
	//this.document.forms[0].submit();
}*/

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="ProfileRef" id="ProfileRef" method="POST" action='../../eXH/jsp/ProfileDervationSelectMaster.jsp' >
<%
//boolean boolToggle =  true;	
//String strTDClass = "";
Connection conn = null;
//String strBeanName = XHApplicationDerivationProfileSetupControllerBean.strBeanName;
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
catch(Exception exp){
         System.out.println("Error in calling getconnection method of FilterLayerGroupLevalSearch.jsp:"+exp.toString());
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
<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ProtocolLinkId.Label" bundle="${xh_labels}"/></td>
	
</tr>
 
<%
  ResultSet rset = null;
  PreparedStatement pstmt = null ;
/*String ApplicationId=request.getParameter("Application_type_id");
String FacilityId=request.getParameter("Facility__id");
String Messagetype=request.getParameter("Message__id");
String EventType=request.getParameter("Event__id");
String Protocollink=request.getParameter("Protocol_Link_id");
*/
String strstyle="";

int i=0;
try
	{
if(conn==null) conn = ConnectionManager.getConnection();
 }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilterLayerGroupLevalSearch.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }

  try
    {
 String sql="select APPLICATION_ID,FACILITY_ID,MESSAGE_TYPE,EVENT_TYPE,PROTOCOL_LINK,FILTER_GROUP_CODE,FILTER_GROUP_DESC,TOTAL_LEVELS from XH_FILTER_GROUP";


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


<td <%=strstyle%> >
<a  href=" javascript:func1('<%=rset.getString(6) %>','<%= rset.getString(7) %>','<%= rset.getString(1)%>','<%= rset.getString(2)%>',
  '<%= rset.getString(3)%>','<%= rset.getString(4)%>','<%= rset.getString(5)%>','<%= rset.getString(8) %>');">
  &nbsp;<%=rset.getString(6).equals("null")?"":rset.getString(6) %>
</td>
<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(7))%>
	</td>



<td <%=strstyle%>>

<%=XHDBAdapter.checkNull(rset.getString(1))%>
	
	</td>
<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(2))%>	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(3))%>
	</td>
<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(4))%>
	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(5))%>

	</td>
	</tr>

<%

	i++;
   
      }
columval=i;
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
    }
    catch(Exception exp)
    {
       System.out.println("Error in populatexhcodedesc method of FilterLayerGroupLevalSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }


finally
	{
		ConnectionManager.returnConnection(conn);
	}
%>
	</table>
<table cellspacing=0 cellpadding=4 width='100%' height='10%'  name='formtable3' id='formtable3' id='formtable3'align=center >
<tr>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class="BUTTON"><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="funAdd()"></td>
</tr>
</table>



</form>
</body>
</html>


