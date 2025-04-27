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
<script src='../../eXH/js/filterlayerrefrence3.js' language='javascript'></script>
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
<form name="ProfileRef" id="ProfileRef" method="POST"  >
<%


Connection conn = null;


String strPrevious = "";
String strNext  = "";
int columval=0;

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
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.LevelNumber.Label" bundle="${xh_labels}"/></td> 
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.FilterType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.FilterTypedesc.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.FilterSubType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.FilterSubDesc.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
	
</tr>

<%
  ResultSet rset = null;
  PreparedStatement pstmt = null ;
  String strstyle="";
int i=1;
try
	{
if(conn==null) conn = ConnectionManager.getConnection();
 }
      catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
	     exp.printStackTrace(System.err);
      
     }    

  try
    {
 String sql="select FILTER_GROUP_CODE,LEVEL_NUMBER,FILTER_ELEMENT_TYPE,FILTER_ELEMENT_TYPE_DESC,FILTER_SUBTYPE_CODE,FILTER_SUBTYPE_DESC,ELEMENT_CODE_NAME, TYPE_QUERY,SUBTYPE_QUERY,LOOKUP_QUERY from XH_FILTER_LEVEL_CONFIG order by 2";


 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
 
      while(rset.next())
      {

if((i%2)==0)
		  {
	strstyle = "class='QRYEVEN'";
		  }
		  else
		  {
strstyle = "class='QRYODD'";

		  }
String tquery = XHDBAdapter.checkNull(java.net.URLEncoder.encode(rset.getString(8)));
String stquery = XHDBAdapter.checkNull(java.net.URLEncoder.encode(rset.getString(9)));
String lquery = XHDBAdapter.checkNull(java.net.URLEncoder.encode(rset.getString(10)));


	%>
<input type=hidden id=<%=i+"type_value"%> value='<%=tquery%>'>
<input type=hidden id=<%=i+"subtype_value"%> value='<%=stquery%>'>
<input type=hidden id=<%=i+"lookquery_value"%> value='<%=lquery%>'>
<td <%=strstyle%> nowrap >
<a  href=" javascript:func1('<%=rset.getString(1)%>','<%=rset.getString(2)%>','<%=rset.getString(3)%>','<%=rset.getString(4)%>',
  '<%=rset.getString(5)%>','<%=rset.getString(6)%>','<%=rset.getString(7)%>','<%=(i)%>');">
  &nbsp;<%=rset.getString(1).equals("null")?"":rset.getString(1) %>
</td>

<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(2))%>	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(3))%>
	</td>
<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(4))%>
	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(5))%>

	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(6))%>

	</td>
	<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(7))%>

	</td>
	</tr>

<%

	i++;
   
      }
columval=(i-1);
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
    }
    catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilterLayarGroupFilterRecord.jsp:"+exp.toString());
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

<input type=hidden name=countfield value='<%=columval%>'>
</form>
</body>
</html>


