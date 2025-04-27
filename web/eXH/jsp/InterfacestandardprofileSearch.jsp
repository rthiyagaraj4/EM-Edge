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
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="ProfileRef" id="ProfileRef" method="POST" action='../../eXH/jsp/ProfileDervationSelectMaster.jsp' >
<%


Connection conn = null;

String strPrevious = "";
String strNext="";

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
       System.out.println("Error in  InterfacestandardprofileSearch.jsp :"+exp.toString());
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
	<td class='COLUMNHEADER' width='5%'>Profile ID</td>
	<td class='COLUMNHEADER' width='5%'>Short description</td>
	<td class='COLUMNHEADER' width='5%'>long description </td>
	<td class='COLUMNHEADER' width='5%'>Version description</td>
		<td class='COLUMNHEADER' width='5%'>Geography description</td>
			<td class='COLUMNHEADER' width='5%'>Application ID</td>
	<td class='COLUMNHEADER' width='5%'>Standard code</td>

</tr>

<%
  ResultSet rset = null;
  PreparedStatement pstmt = null ;



  String standardcode=request.getParameter("standard_code");
String profileid=request.getParameter("profile_id");
 String sql="";
int i=0;
try
	{
if(conn==null) conn = ConnectionManager.getConnection();
 }
     catch(Exception exp)
    {
       System.out.println("Error in InterfacestandardprofileSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
  try
    {
 sql="select PROFILE_ID,SHORT_DESC,LONG_DESC,VERSION_DESC,GEOGRAPHY_DESC,APPLICATION_ID,STANDARD_CODE from XH_STANDARD_PROFILE where STANDARD_CODE=NVL('"+standardcode+"',STANDARD_CODE) and PROFILE_ID=NVL('"+profileid+"',PROFILE_ID) ";


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



	%>

<td class=label ><%=rset.getString(1)%></td>
<td class=label ><%=rset.getString(2)%></td>
<td class=label ><%=rset.getString(3)%></td>
<td class=label ><%=rset.getString(4)%></td>
<td class=label ><%=rset.getString(5)%></td>
<td class=label ><%=rset.getString(6)%></td>
<td class=label ><%=rset.getString(7)%></td>	
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
		 System.out.println(" InterfacestandardprofileSearch.jsp :sql "+sql);
       System.out.println("Error in  InterfacestandardprofileSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }

finally
	{
		ConnectionManager.returnConnection(conn);
	}
%>
	<tr>

		<td colspan=4 class=label><img src='../../eCommon/images/green_square.jpg' width=40 height=15 ><fmt:message key="eXH.Recently.Label" bundle="${xh_labels}"/><input type="hidden" name="Num_colu" id="Num_colu" value=<%=columval%>><input type='hidden' name='action_type' id='action_type' value='U' ></td> 
		<td></td>
		<td class=label>
		</td>
<td class=label>
		</td>

		</tr>

	</table> 


</form>
</body>
</html>


