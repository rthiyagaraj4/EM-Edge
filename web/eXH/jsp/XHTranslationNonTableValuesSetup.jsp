<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML> 
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String applicationid = XHDBAdapter.checkNull(request.getParameter("applicationid"));
String elementid = XHDBAdapter.checkNull(request.getParameter("nontabelementid"));
String slctd_Master_Val =	 XHDBAdapter.checkNull(request.getParameter("slctd_Master_Val"));

String searchText = XHDBAdapter.checkNull(request.getParameter("searchText"));
String start_ends_contains = XHDBAdapter.checkNull(request.getParameter("start_ends_contains"));
				if(start_ends_contains.equals("S")){
						searchText=searchText+"%";
				}
				else if(start_ends_contains.equals("E")){
						searchText="%"+searchText;
				}
				else if(start_ends_contains.equals("C")){
						searchText="%"+searchText+"%";
				}
				else{
						searchText="%";
				}

Connection conn=null;
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
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";

	var act = '../../eXH/jsp/XHTranslationNonTableValuesSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="";
	this.document.forms[0].submit();
//	alert(parent.frames[1].document.forms[0].name);
	if(parent.frames[1].document.forms[0]){
		parent.frames[1].location.href="../../eCommon/html/blank.html";		
	//	parent.frames[1].document.forms[0].reset();
	}
}
function funAction(typ)
{
	var act = '../../eXH/jsp/XHTranslationNonTableValuesSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="";
	this.document.forms[0].action_type.value=typ;
	this.document.forms[0].submit();	
}

function  func1(eHiscode,crossrefcode,crossRefdesc,ehis_desc)
{
//	alert("func1ehis_desc : "+ehis_desc);
	 var url='&applicationid='+document.forms[0].applicationid.value+'&nontabelementid='+document.forms[0].nontabelementid.value+'&slctd_Master_Val='+document.forms[0].slctd_Master_Val.value+'&eHiscode='+eHiscode+'&crossrefcode='+crossrefcode+
      '&crossRefdesc='+crossRefdesc+'&ehis_desc='+ehis_desc+'&act_mode=U';

	 parent.applnontablecode.location.href="../../eXH/jsp/XHTranslationNonTableValuesSetupQueryResult.jsp?"+url; 
//	 alert(parent.parent.frames[3].name);
	 parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp";

}  
 function funAdd()
{
parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
parent.applnontablecode.document.location.href='../../eXH/jsp/XHTranslationNonTableValuesSetupQueryResult.jsp?applicationid='+document.forms[0].applicationid.value+'&nontabelementid='+document.forms[0].nontabelementid.value+'&slctd_Master_Val='+document.forms[0].slctd_Master_Val.value+'&act_mode=I';
}
</Script>
</HEAD>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >

<form name="application_element_setup_form" id="application_element_setup_form" method='post' >

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>



<%
try
{

ArrayList arrRow = null,arrCol = null;

String qry_id = "VIEWXHAPPLELEMENTNONTABVAL";

//System.out.println("sql60"+sql);

String whereClause=" WHERE APPLICATION_ID='"+applicationid+"' AND ELEMENT_ID = '"+elementid+"' AND MEDICOM_CODE LIKE '"+searchText+"'  AND a.CROSSREF_CODE = b.BANK_CODE(+) ORDER BY 1";

    request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.whereClause,whereClause);
	request.setAttribute(XHQueryRender.col,"4");
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
	<td class='COLUMNHEADER' > </td>
	<td class='COLUMNHEADER' colspan=2 align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eXH.CrossReference.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='COLUMNHEADER' align=center width='10%'>External Code<!--<fmt:message key="eXH.ibaehisCode.Label" bundle="${xh_labels}"/>--></td>
	<td class='COLUMNHEADER' align=center width='4%'>eHIS Code<!--<fmt:message key="Common.code.label" bundle="${common_labels}"/>--></td>
	<td class='COLUMNHEADER' align=left width='15%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
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
<a  href=" javascript:func1('<%=(String)arrCol.get(0)%>','<%=(String)arrCol.get(1)%>','<%=(String)arrCol.get(2)%>','<%=(String)arrCol.get(3)%>');">
  &nbsp;<%=((String)arrCol.get(0)).equals("null")?"":((String)arrCol.get(0)) %>
</td>



<td <%=strTDClass%> ><%=XHDBAdapter.checkNull((String)arrCol.get(1))%></td>
<% if (XHDBAdapter.checkNull((String)arrCol.get(3)).equals("")){ %>
	<td <%=strTDClass%> ><%=XHDBAdapter.checkNull((String)arrCol.get(2))%></td>
<% } else { %>
	<td <%=strTDClass%> ><%=XHDBAdapter.checkNull((String)arrCol.get(3))%></td>
<% } %>
</tr>

<%
}
%>
</table>
<%
		} // end of else
%>

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr >
	<td colspan=3 align=right class="BUTTON"><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="funAdd()"><input class='button' type='button'  name='Refresh' id='Refresh' value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' onClick="funRefresh()"></td></tr>
</table>


<%
//	}
arrRow.clear();
arrCol.clear();
}catch(Exception e1)
{
	System.out.println(e1.toString());
}
finally {
	ConnectionManager.returnConnection(conn);
}

%>

<input type=hidden name='applicationid' id='applicationid' value='<%=applicationid%>'>
<input type=hidden name='nontabelementid' id='nontabelementid' value='<%=elementid%>'>
<input type=hidden name='slctd_Master_Val' id='slctd_Master_Val' value='<%=slctd_Master_Val%>'>
<input type=hidden name='action_type' id='action_type' value='' >
</form>
</BODY>
</HTML>

