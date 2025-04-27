<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<HTML> 
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='Stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<%
	Connection con = null;
	ArrayList arrRow = null,arrCol=null;
	XHSelectQuery xhSelect = null;
	String strMessageType = request.getParameter("message_type");
	String strApplicationId = request.getParameter("applicationid");
	String strFacilityId = request.getParameter("facilityid");
	String ROWID="";
	String strOpMode = "I";
try
{
  con = ConnectionManager.getConnection(request);
  xhSelect = new XHSelectQuery();
  HashMap hashmpParams = new HashMap(5);
  hashmpParams.put("connection",con);
  hashmpParams.put("sql","SELECT FILTER_TYPE,FILTER_SUB_TYPE,FILTER_SUB1_TYPE,FILTER_SUB2_TYPE, "+
  " MESSAGE_TRIGGER_EVENT, MESSAGE_TRIGGER_TIME FROM XH_APPL_FILTER_RULE_HDR  WHERE FACILITY_ID='"+strFacilityId+"' AND APPLICATION_ID='"+strApplicationId+"' AND MESSAGE_TYPE='"+strMessageType+"'");
  hashmpParams.put("col","6");
  arrRow = xhSelect.getResults(hashmpParams);
  arrCol = null;	
  xhSelect = null;
  hashmpParams.clear();
  if (arrRow != null)
  {
    if (arrRow.size()>0)
	{
		arrCol = (ArrayList) arrRow.get(0);
		strOpMode = "U";
	}
  }
  arrCol.clear();
  arrRow.clear();
  ConnectionManager.returnConnection(con);
  }
    catch(Exception exp)
    {
       System.out.println("Error in  FilterRuleSetupTypesSubType.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
%>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Filter.js'> </Script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </Script>
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script language="JavaScript">
//function Populate
function Populate()
{

	firstSelectBoxPopulate("<%=strMessageType%>");
   <%if(arrCol!=null){
	   if (arrCol.size()>0)
	{
	     %>
	var ftype=document.getElementById("filter_type");
    var ftype1=document.getElementById("filter_type1");
    var ftype2=document.getElementById("filter_type2");
    var ftype3=document.getElementById("filter_type3");

    for( var j=0;j<ftype.options.length;j++)
	{
	   if(ftype.options[j].value =='<%=arrCol.get(0)%>')
       ftype.options[j].selected=true;
	}
   secondSelectBoxPopulate("<%=strMessageType%>");
   for( var j=0;j<ftype1.options.length;j++)
	{
	   if(ftype1.options[j].value =='<%=arrCol.get(1)%>')
       ftype1.options[j].selected=true;
	}
	thirdSelectBoxPopulate("<%=strMessageType%>");
	for( var j=0;j<ftype2.options.length;j++)
	{
	   if(ftype2.options[j].value =='<%=arrCol.get(2)%>')
       ftype2.options[j].selected=true;
	}
	fourthSelectBoxPopulate("<%=strMessageType%>");
	for( var j=0;j<ftype3.options.length;j++)
	{
	   if(ftype3.options[j].value =='<%=arrCol.get(3)%>')
       ftype3.options[j].selected=true;
	}

	
	<% } }%>

}
//function funSearch
function funSearch()
{	
	
	this.document.forms[0].jspmode.value='F';
	this.document.forms[0].action='../../eXH/jsp/FilteringRuleQueryResult.jsp';
	this.document.forms[0].target='recordframe';
	this.document.forms[0].submit();

}
//function funAdd
function funAdd()
{
    this.document.forms[0].jspmode.value='F';
	this.document.forms[0].action='../../eXH/jsp/FilterRulesAddModifyFunctionality.jsp';
	this.document.forms[0].target='recordframe';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0 onLoad="Populate();"  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="FilteringRuleSetup" id="FilteringRuleSetup"  action='' target='' method="post">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td class=label ><fmt:message key="eXH.FilterType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name='filter_type' id='filter_type' id="filter_type" onChange="secondSelectBoxPopulate('<%=strMessageType%>');" >
</select> <img src='../../eCommon/images/mandatory.gif'> </td>

<td class=label ><fmt:message key="eXH.FilterSubType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name='filter_sub_type' id='filter_sub_type' id="filter_type1" onChange="thirdSelectBoxPopulate('<%=strMessageType%>');" >
</select> <img src='../../eCommon/images/mandatory.gif'></td></tr>
<tr><td class=label ><fmt:message key="eXH.FilterSub1Type.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name='filter_sub1_type' id='filter_sub1_type'  id="filter_type2" onChange="fourthSelectBoxPopulate('<%=strMessageType%>')">
</select> <img src='../../eCommon/images/mandatory.gif'>
</td>
<td class=label ><fmt:message key="eXH.FilterSub2Type.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name='filter_sub2_type' id='filter_sub2_type' id="filter_type3">
</select> <img src='../../eCommon/images/mandatory.gif'></td></tr>
<tr><td colspan=6 class='BUTTON'>
<input class='button' type="button"  name='add' id='add' value='<fmt:message key="eXH.Add.Label" bundle="${xh_labels}"/>' onClick='funAdd()'>
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="eXH.Search.Label" bundle="${xh_labels}"/>' onClick='funSearch()'>
</td>
</tr>
<tr><td colspan=6 ></td></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 ></tr>
<tr><td colspan=6 >&nbsp;</td></tr>
<tr><td colspan=6 >&nbsp;</td></tr>
</table>
<input type='hidden' name='applicationid' id='applicationid' value='<%=strApplicationId%>'>
<input type='hidden' name='message_type' id='message_type' value='<%=strMessageType%>'>
<input type='hidden' name='facilityid' id='facilityid' value='<%=strFacilityId%>'>
<input type='hidden' name='actualmode' id='actualmode' value='I'>
<input type='hidden' name='rowid' id='rowid' value='<%=ROWID%>'>
<input type='hidden' name='jspmode' id='jspmode'>
</form>	
</BODY>
</HTML>

