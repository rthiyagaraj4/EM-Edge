<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML>  
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String applicationid = request.getParameter("applicationid");
String elementid = request.getParameter("nontabelementid");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<Script>
function funMasterCode()
{
	this.document.forms[0].submit();
}
function funRefresh()
{
	var act = '../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="";

	this.document.forms[0].submit();
}
function funAction(typ)
{


	
		var act = '../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="";
this.document.forms[0].action_type.value=typ;
	this.document.forms[0].submit();
	
}

function  func1(eHiscode,crossrefcode,crossRefdesc)
{
	   	  var url='&applicationid='+document.forms[0].applicationid.value+'&nontabelementid='+document.forms[0].nontabelementid.value+'&eHiscode='+eHiscode+'&crossrefcode='+crossrefcode+
      '&crossRefdesc='+crossRefdesc+'&act_mode=U';
	
	 parent.applnontablecodesearch.location.href="../../eXH/jsp/DataElementCrossRefNonTableValuesSetupqueryrecord.jsp?"+url; 
	 // parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp";

}  
 function funAdd()
{
parent.applnontablecodesearch.document.location.href='../../eXH/jsp/DataElementCrossRefNonTableValuesSetupqueryrecord.jsp?applicationid='+document.forms[0].applicationid.value+'&nontabelementid='+document.forms[0].nontabelementid.value+'&act_mode=I';
}
</Script>
</HEAD>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="application_element_setup_form" id="application_element_setup_form" method='post' >

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>



<%
try
{
Connection conn=null;

ArrayList arrRow = null,arrCol = null;

String qry_id = "VIEWXHAPPLELEMENTNONTABVAL";


//String sql = " SELECT MEDICOM_CODE,CROSSREF_CODE,CROSSREF_DESC          "+
//	" FROM  XH_APPL_ELEMENT_NONTABVAL   "+
//	" WHERE APPLICATION_ID='"+applicationid+"'"+
//	" AND ELEMENT_ID = '"+elementid+"' ORDER BY 1";


//System.out.println("sql60"+sql);

String whereClause=" WHERE APPLICATION_ID='"+applicationid+"'"+
	" AND ELEMENT_ID = '"+elementid+"' ORDER BY 1";



    request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.whereClause,whereClause);
	request.setAttribute(XHQueryRender.col,"3");
	request.setAttribute(XHQueryRender.maxRec,"5");
    conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
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
		<td  align="center" class="CAGROUP" >
		<td colspan="2" align="right" class="CAGROUP" > 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
		<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
		</td>
	</tr>
<tr>
	<td class='COLUMNHEADER' rowspan=2 align=center width='10%'><fmt:message key="eXH.ibaehisCode.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' colspan=2 align=center><fmt:message key="eXH.CrossReference.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='COLUMNHEADER' align=center width='4%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' align=center width='15%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
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
<a  href=" javascript:func1('<%=(String)arrCol.get(0)%>','<%=(String)arrCol.get(1)%>','<%=(String)arrCol.get(2)%>');">
  &nbsp;<%=((String)arrCol.get(0)).equals("null")?"":((String)arrCol.get(0)) %>
</td>



<td <%=strTDClass%> ><%=XHDBAdapter.checkNull((String)arrCol.get(1))%></td>
<td <%=strTDClass%> ><%=XHDBAdapter.checkNull((String)arrCol.get(2))%></td>
</tr>
<%
}
%>

<tr>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

<td class="BUTTON"><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="funAdd()"><input class='button' type='button'  name='Refresh' id='Refresh' value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' onClick="funRefresh()"></td></tr>
</table>


<%
	}
arrRow.clear();
arrCol.clear();
ConnectionManager.returnConnection(conn);
}catch(Exception e1)
{
	System.out.println(" (DataElementCrossRefNonTableValuesSetup.jsp : Exception-1 ) "+e1.toString());
}
%>

<input type=hidden name='applicationid' id='applicationid' value='<%=applicationid%>'>
<input type=hidden name='nontabelementid' id='nontabelementid' value='<%=elementid%>'>
<input type=hidden name='action_type' id='action_type' value='' >
</form>
</BODY>
</HTML>

