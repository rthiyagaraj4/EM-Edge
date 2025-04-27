<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,java.lang.String,eXH.*,java.util.ArrayList,eXI.*,webbeans.eCommon.ConnectionManager,eXI.XIDBAdapter" %>
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
<script language="javascript" src="../../eXI/js/NewItemArrival.js" ></script>
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
	<table name=elTableRow border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
try
{
Connection conn=null;
String after_date=request.getParameter("after_date");
String Item_Category=XIDBAdapter.checkNull(request.getParameter("Item_Category"));
String Organization_code=XIDBAdapter.checkNull(request.getParameter("Organization_code"));
   after_date=com.ehis.util.DateUtils.convertDate(after_date,"DMY","th","en");

ArrayList arrRow = null,arrCol = null;

String qry_id = "NEWARRAIVALITEM";
String whereClause=" WHERE upper(XI_ITEM_CATEGORY_CODE)=upper(NVL('"+Item_Category+"',XI_ITEM_CATEGORY_CODE)) and upper(XI_ORGANIZATION_ID)=upper(NVL('"+Organization_code+"',XI_ORGANIZATION_ID))";

//trunc(added_date) > to_Date('#after_date','dd/mm/yyyy')
whereClause =whereClause +" AND trunc(added_date)"+" > to_Date('#after_date','dd/mm/yyyy')";

//String sql = " SELECT MEDICOM_CODE,CROSSREF_CODE,CROSSREF_DESC          "+
//	" FROM  XH_APPL_ELEMENT_NONTABVAL   "+
//	" WHERE APPLICATION_ID='"+applicationid+"'"+
//	" AND ELEMENT_ID = '"+elementid+"' ORDER BY 1";


//System.out.println("sql60"+sql);

//String whereClause=" WHERE APPLICATION_ID='"+applicationid+"'"+
	//" AND ELEMENT_ID = '"+elementid+"' ORDER BY 1";



    request.setAttribute(XIQueryRender.strQueryId,qry_id);
	request.setAttribute(XIQueryRender.whereClause,whereClause);
	request.setAttribute(XIQueryRender.col,"5");
	request.setAttribute(XIQueryRender.maxRec,"12");
    conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XIQueryRender.getResults(request,session,conn);
 arrRow = (ArrayList)resultsQry.get("qry_result"); 

	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");



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


<%
	if(arrRow.size()==0)
	{

%>
	<script>
alert(getMessage('XH1021','XH'));
</script>

		
	<%
				}
	else
		{
	%>

	<tr>
<td colspan="3" align="right" class="CAGROUP" >
	</td>
	
	<td colspan="3" align="right" class="CAGROUP" > 
<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext%></A>
</td>


</tr>
<tr>
<!--
<td class='COLUMNHEADER' width='35%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td> -->
<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXI.ItemCategory.Label" bundle="${xi_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXI.CreationDate.Label" bundle="${xi_labels}"/></td>
</tr>
<%
boolean boolToggle =  true;	
String strTDClass = "";

for(int i=0;i<arrRow.size();i++)
{
	arrCol = (ArrayList)arrRow.get(i);

	if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
%>
<tr>

<td <%=strTDClass%> >
  &nbsp;<%=((String)arrCol.get(0)).equals("null")?"":((String)arrCol.get(0)) %>
</td>
<td <%=strTDClass%> ><%=XIDBAdapter.checkNull((String)arrCol.get(1))%></td>
<td <%=strTDClass%> ><%=XIDBAdapter.checkNull((String)arrCol.get(2))%></td>
<td <%=strTDClass%> ><%=XIDBAdapter.checkNull((String)arrCol.get(3))%></td>
</tr>

	

<%
}	
}
arrRow.clear();
arrCol.clear();
resultsQry.clear();
ConnectionManager.returnConnection(conn);
}catch(Exception e1)
{
	System.out.println(e1.toString());
}
%>
</table>
<input type='hidden' name='action_type' id='action_type' value='U' >
<input type=hidden name=countfield value=''>
</form>
</body>
</html>


