<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	Connection con = null;
	ArrayList arrRow = null,arrCol=null;
	XHSelectQuery xhSelect = null;
	String strApplicationId = request.getParameter("applicationid").trim();
	String strFacilityId = request.getParameter("facilityid").trim();
	String strMessageType = request.getParameter("message_type").trim();
	String jspmode = request.getParameter("jspmode").trim();
	

	String filter_type="";
	String filter_sub_type="";
	String filter_sub1_type="";
	String filter_sub2_type="";
	if(jspmode.equalsIgnoreCase("F"))
    {
       filter_type = request.getParameter("filter_type").trim();
	   filter_sub_type = request.getParameter("filter_sub_type").trim();
	   filter_sub1_type = request.getParameter("filter_sub1_type").trim();
	   filter_sub2_type = request.getParameter("filter_sub2_type").trim();
	}
	String strOddClz = "QRYODD";
	String strEvnClz = "QRYEVEN";
	String strClz = "";
	String sql = "";
	
%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
//function funUpdate
function funUpdate(obj)
{

this.document.forms[0].FILTER_ELEMENT_TYPE.value = obj.getAttribute('FILTER_ELEMENT_TYPE');
this.document.forms[0].ELEMENT_TYPE_DESC.value = obj.getAttribute('ELEMENT_TYPE_DESC');
this.document.forms[0].FILTER_ELEMENT_CODE.value = obj.getAttribute('FILTER_ELEMENT_CODE');
this.document.forms[0].ELEMENT_CODE_DESC.value = obj.getAttribute('ELEMENT_CODE_DESC');
	
this.document.forms[0].FILTER_SUB_ELEMENT_TYPE.value = obj.getAttribute('FILTER_SUB_ELEMENT_TYPE');
this.document.forms[0].SUB_ELEMENT_TYPE_DESC.value = obj.getAttribute('SUB_ELEMENT_TYPE_DESC');
this.document.forms[0].FILTER_SUB_ELEMENT_CODE.value = obj.getAttribute('FILTER_SUB_ELEMENT_CODE');
this.document.forms[0].SUB_ELEMENT_CODE_DESC.value = obj.getAttribute('SUB_ELEMENT_CODE_DESC');

this.document.forms[0].FILTER_SUB1_ELEMENT_TYPE.value = obj.getAttribute('FILTER_SUB1_ELEMENT_TYPE');
this.document.forms[0].SUB1_ELEMENT_TYPE_DESC.value = obj.getAttribute('SUB1_ELEMENT_TYPE_DESC');
this.document.forms[0].FILTER_SUB1_ELEMENT_CODE.value = obj.getAttribute('FILTER_SUB1_ELEMENT_CODE');
this.document.forms[0].SUB1_ELEMENT_CODE_DESC.value = obj.getAttribute('SUB1_ELEMENT_CODE_DESC');

this.document.forms[0].FILTER_SUB2_ELEMENT_TYPE.value = obj.getAttribute('FILTER_SUB2_ELEMENT_TYPE');
this.document.forms[0].SUB2_ELEMENT_TYPE_DESC.value = obj.getAttribute('SUB2_ELEMENT_TYPE_DESC');
this.document.forms[0].FILTER_SUB2_ELEMENT_CODE.value = obj.getAttribute('FILTER_SUB2_ELEMENT_CODE');
this.document.forms[0].SUB2_ELEMENT_CODE_DESC.value = obj.getAttribute('SUB2_ELEMENT_CODE_DESC');
this.document.forms[0].rowid.value = obj.getAttribute('rowid');

this.document.forms[0].action = '../../eXH/jsp/FilterRulesAddModifyFunctionality.jsp';
this.document.forms[0].target = 'recordframe';
this.document.forms[0].submit();

}
//function funModify
function funModify(obj)
 {
	
	this.document.forms[0].SEGMENTRULE.value = obj.getAttribute('SEGMENTRULE');
	this.document.forms[0].FILTERSEGRULE.value = obj.getAttribute('FILTERSEGRULE');
	this.document.forms[0].FILTERSEGELTYPE.value = obj.getAttribute('FILTERSEGELTYPE');
    this.document.forms[0].rowid.value = obj.getAttribute('rowid');
	this.document.forms[0].actualmode.value = 'M';
	this.document.forms[0].jspmode.value = 'G';
	this.document.forms[0].action = '../../eXH/jsp/SegmentRuleSetup.jsp';
    this.document.forms[0].target = 'filterframe';
	parent.recordframe.location.href="../../eCommon/html/blank.html";
    this.document.forms[0].submit();
	
 }
//function delrecord
function delrecord(str)
{

 this.document.forms[0].rowid.value = str;
 this.document.forms[0].actualmode.value = 'D';
 if(this.confirm(getMessage('XH1020','XH'))==true){
 this.document.forms[0].action = '../../servlet/eXH.XHFilterRuleRecordServlet';
 this.document.forms[0].target = 'messageFrame';
 this.document.forms[0].submit();
 }
}
//function delSegrecord
function delSegrecord(str,str1,str2,str3)
{

 this.document.forms[0].rowid.value = str;
 this.document.forms[0].segment_type.value = str1;
 this.document.forms[0].segment_class.value = str2;
 this.document.forms[0].segment_element.value = str3;
 this.document.forms[0].actualmode.value = 'D';
 if(this.confirm(getMessage('XH1020','XH'))==true){
 this.document.forms[0].action = '../../servlet/eXH.XHFilterRuleRecordServlet';
 this.document.forms[0].target = 'messageFrame';
 this.document.forms[0].submit();
 }

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0  onLoad="callFunction()" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="QueryResultForm" id="QueryResultForm" method="post">
<%
try
{
	con = ConnectionManager.getConnection(request);
	if(jspmode.equalsIgnoreCase("F"))
    {
	sql = " SELECT "+ "FILTER_ELEMENT_TYPE,ELEMENT_TYPE_DESC,FILTER_ELEMENT_CODE,ELEMENT_CODE_DESC,FILTER_SUB_ELEMENT_TYPE,"+
"SUB_ELEMENT_TYPE_DESC,FILTER_SUB_ELEMENT_CODE,SUB_ELEMENT_CODE_DESC,FILTER_SUB1_ELEMENT_TYPE,"+
"SUB1_ELEMENT_TYPE_DESC,FILTER_SUB1_ELEMENT_CODE,SUB1_ELEMENT_CODE_DESC,FILTER_SUB2_ELEMENT_TYPE,"+
"SUB2_ELEMENT_TYPE_DESC,FILTER_SUB2_ELEMENT_CODE,SUB2_ELEMENT_CODE_DESC,ROW_ID FROM XH_APPL_FIL_RULE_DTL_LANG_VW  "+
	" WHERE APPLICATION_ID='"+strApplicationId+"'   "+
	" AND FACILITY_ID='"+strFacilityId+"' AND "+
	" MESSAGE_TYPE='"+strMessageType+"'"+ 
	" AND FILTER_TYPE='"+filter_type+"'"+
    " AND FILTER_SUB_TYPE='"+filter_sub_type+"'"+
    " AND FILTER_SUB1_TYPE='"+filter_sub1_type+"'"+
    " AND FILTER_SUB2_TYPE='"+filter_sub2_type+"'"+
	" AND LANGUAGE_ID='"+locale+"'";

		xhSelect = new XHSelectQuery();
		HashMap hashmpParams = new HashMap(5);
		hashmpParams.put("connection",con);
		hashmpParams.put("sql",sql);
		hashmpParams.put("col","17");
		arrRow = xhSelect.getResults(hashmpParams);
		arrCol = null;	
		xhSelect = null;
		hashmpParams.clear();
	}
	
	if(jspmode.equalsIgnoreCase("G"))
    {
	sql = "SELECT SEGMENT_TYPE,SEGMENT_TYPE,"+
" FILTER_ATTRIBUTE_TYPE,FILTER_ATTRIBUTE_TYPE"+
",FILTER_ATTRIBUTE_CODE,FILTER_ATTRIBUTE_CODE,"+
  " ROWID FROM XH_APPL_SEG_FILTER_RULE  WHERE FACILITY_ID='"+strFacilityId+"' AND "+ "APPLICATION_ID='"+strApplicationId+"' AND MESSAGE_TYPE='"+strMessageType +"'";
		xhSelect = new XHSelectQuery();
		HashMap hashmpParams = new HashMap(5);
		hashmpParams.put("connection",con);
		hashmpParams.put("sql",sql);
		hashmpParams.put("col","7");
		arrRow = xhSelect.getResults(hashmpParams);
		arrCol = null;	
		xhSelect = null;
		hashmpParams.clear();
	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
%>
<% if(jspmode.equalsIgnoreCase("F"))
    { %>
<div id ="filterrule" style='display:block'>
<%
if(arrRow.size()==0)
{
%>
<script>
alert(getMessage('XH1021','XH'));
</script>
<% } else { %>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='COLUMNHEADER'><fmt:message key="eXH.ElementType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.Element.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.SubElementType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.SubElement.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Sub1ElementType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Sub1Element.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Sub2ElementType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Sub2Element.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.Delete.Label" bundle="${xh_labels}"/></td>
</tr>
<%
for(int j=0;j<arrRow.size();j++)
{
	arrCol = (ArrayList) arrRow.get(j);
	if (j%2 == 0)
	{
		strClz = strOddClz;

	}	
	else
	{
		strClz = strEvnClz;
	}

%>
<tr>
<td class='<%=strClz%>' onClick='funUpdate(this);' FILTER_ELEMENT_TYPE='<%=arrCol.get(0).equals("null")?"":arrCol.get(0)+""%>' ELEMENT_TYPE_DESC='<%=arrCol.get(1).equals("null")?"":arrCol.get(1)+""%>'  FILTER_ELEMENT_CODE='<%=arrCol.get(2).equals("null")?"":arrCol.get(2)+""%>'  ELEMENT_CODE_DESC='<%=arrCol.get(3).equals("null")?"":arrCol.get(3)+""%>' 
	
FILTER_SUB_ELEMENT_TYPE='<%=arrCol.get(4).equals("null")?"":arrCol.get(4)+""%>'  SUB_ELEMENT_TYPE_DESC='<%=arrCol.get(5).equals("null")?"":arrCol.get(5)+""%>'  FILTER_SUB_ELEMENT_CODE='<%=arrCol.get(6).equals("null")?"":arrCol.get(6)+""%>'  SUB_ELEMENT_CODE_DESC='<%=arrCol.get(7).equals("null")?"":arrCol.get(7)+""%>' 
	
FILTER_SUB1_ELEMENT_TYPE='<%=arrCol.get(8).equals("null")?"":arrCol.get(8)+""%>'  SUB1_ELEMENT_TYPE_DESC='<%=arrCol.get(9).equals("null")?"":arrCol.get(9)+""%>'  FILTER_SUB1_ELEMENT_CODE='<%=arrCol.get(10).equals("null")?"":arrCol.get(10)+""%>'  SUB1_ELEMENT_CODE_DESC='<%=arrCol.get(11).equals("null")?"":arrCol.get(11)+""%>' 
	
FILTER_SUB2_ELEMENT_TYPE='<%=arrCol.get(12).equals("null")?"":arrCol.get(12)+""%>'  SUB2_ELEMENT_TYPE_DESC='<%=arrCol.get(13).equals("null")?"":arrCol.get(13)+""%>'  FILTER_SUB2_ELEMENT_CODE='<%=arrCol.get(14).equals("null")?"":arrCol.get(14)+""%>'  SUB2_ELEMENT_CODE_DESC='<%=arrCol.get(15).equals("null")?"":arrCol.get(15)+""%>' 
	>
<a href='#' style='cursor:pointer'>&nbsp;<%=arrCol.get(1)+""%></a>
</td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(3).equals("null")?"":arrCol.get(3)+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(5).equals("null")?"":arrCol.get(5)+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(7).equals("null")?"":arrCol.get(7)+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(9).equals("null")?"":arrCol.get(9)+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(11).equals("null")?"":arrCol.get(11)+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(13).equals("null")?"":arrCol.get(13)+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=arrCol.get(15).equals("null")?"":arrCol.get(15)+""%></td>
<td class='<%=strClz%>'><input class='button' type='button'  name='Delete' id='Delete' value='<fmt:message key="Common.delete.Label" bundle="${common_labels}"/>'
onClick="delrecord('<%=arrCol.get(16)%>')" ></td>
</tr>
<%
}
%>
</table>
<%} %>
</div>
<% } if(jspmode.equalsIgnoreCase("G"))
    {%>
<div id ="segmentrule" style='display:block'>

<%
if(arrRow.size()==0)
{
%>
<script>
alert(getMessage('XH1021','XH'));
</script>
<% } else { %>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='COLUMNHEADER'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.FilterType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="eXH.ElementType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'><fmt:message key="Common.delete.Label" bundle="${common_labels}"/></td>
</tr>
<%
for(int j=0;j<arrRow.size();j++)
{
	arrCol = (ArrayList) arrRow.get(j);
	if (j%2 == 0)
	{
		strClz = strOddClz;

	}	
	else
	{
		strClz = strEvnClz;
	}

String seg_type="";
String int_seg_type="";
seg_type=(String)arrCol.get(1);

if(seg_type.equalsIgnoreCase("AL1")) int_seg_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.PatientAllergy.Label","xh_labels");
String s_filter_type="";
String str_filter_type="";
s_filter_type=(String)arrCol.get(3);
if(s_filter_type.equalsIgnoreCase("A")) str_filter_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.AllergyClass.Label","xh_labels");
String s_element_type="";
String str_element_type="";
s_element_type=(String)arrCol.get(5);

if(s_element_type.equalsIgnoreCase("F")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Food.Label","xh_labels");
if(s_element_type.equalsIgnoreCase("D")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Drug.Label","xh_labels");
if(s_element_type.equalsIgnoreCase("G")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.General.Label","xh_labels");
if(s_element_type.equalsIgnoreCase("A")) str_element_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.All.Label","xh_labels");
 %>
<tr>
<td class='<%=strClz%>' onClick='funModify(this);'

SEGMENTRULE='<%=arrCol.get(0).equals("null")?"":arrCol.get(0)+""%>' FILTERSEGRULE='<%=arrCol.get(2).equals("null")?"":arrCol.get(2)+""%>'  FILTERSEGELTYPE='<%=arrCol.get(4).equals("null")?"":arrCol.get(4)+""%>' 
rowid='<%=arrCol.get(6)%>'
	>
<a href='#' style='cursor:pointer'>&nbsp;<%=int_seg_type+""%></a>
</td>
<td class='<%=strClz%>'>&nbsp;<%=str_filter_type+""%></td>
<td class='<%=strClz%>'>&nbsp;<%=str_element_type+""%></td>
<td class='<%=strClz%>'><input class='button' type='button'  name='Delete' id='Delete' value='<fmt:message key="Common.delete.Label" bundle="${common_labels}"/>' onClick="delSegrecord('<%=arrCol.get(6)%>','<%=arrCol.get(0)%>','<%=arrCol.get(2)%>','<%=arrCol.get(4)%>')"></td>

</tr>
<%
}
%>
</table>
	<%}%>
</div>
<% } 
if(arrCol!=null) arrCol.clear();
if(arrRow!=null) arrRow.clear();
try
{
	
	ConnectionManager.returnConnection(con);
}
catch(Exception exp)
      {

		 
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }


%>
<input type='hidden' name='applicationid' id='applicationid' value='<%=strApplicationId%>'>
<input type='hidden' name='message_type' id='message_type' value='<%=strMessageType%>'>
<input type='hidden' name='facilityid' id='facilityid' value='<%=strFacilityId%>'>

<input type='hidden' name='filter_type' id='filter_type' value='<%=filter_type%>'>
<input type='hidden' name='filter_sub_type' id='filter_sub_type' value='<%=filter_sub_type%>'>
<input type='hidden' name='filter_sub1_type' id='filter_sub1_type' value='<%=filter_sub1_type%>'>
<input type='hidden' name='filter_sub2_type' id='filter_sub2_type' value='<%=filter_sub2_type%>'>

<input type='hidden' name='FILTER_ELEMENT_TYPE' id='FILTER_ELEMENT_TYPE' >
<input type='hidden' name='ELEMENT_TYPE_DESC' id='ELEMENT_TYPE_DESC' >
<input type='hidden' name='FILTER_ELEMENT_CODE' id='FILTER_ELEMENT_CODE' >
<input type='hidden' name='ELEMENT_CODE_DESC' id='ELEMENT_CODE_DESC' >

<input type='hidden' name='FILTER_SUB_ELEMENT_TYPE' id='FILTER_SUB_ELEMENT_TYPE' >
<input type='hidden' name='SUB_ELEMENT_TYPE_DESC' id='SUB_ELEMENT_TYPE_DESC' >
<input type='hidden' name='FILTER_SUB_ELEMENT_CODE' id='FILTER_SUB_ELEMENT_CODE' >
<input type='hidden' name='SUB_ELEMENT_CODE_DESC' id='SUB_ELEMENT_CODE_DESC' >

<input type='hidden' name='FILTER_SUB1_ELEMENT_TYPE' id='FILTER_SUB1_ELEMENT_TYPE' >
<input type='hidden' name='SUB1_ELEMENT_TYPE_DESC' id='SUB1_ELEMENT_TYPE_DESC' >
<input type='hidden' name='FILTER_SUB1_ELEMENT_CODE' id='FILTER_SUB1_ELEMENT_CODE' >
<input type='hidden' name='SUB1_ELEMENT_CODE_DESC' id='SUB1_ELEMENT_CODE_DESC' >

<input type='hidden' name='FILTER_SUB2_ELEMENT_TYPE' id='FILTER_SUB2_ELEMENT_TYPE' >
<input type='hidden' name='SUB2_ELEMENT_TYPE_DESC' id='SUB2_ELEMENT_TYPE_DESC' >
<input type='hidden' name='FILTER_SUB2_ELEMENT_CODE' id='FILTER_SUB2_ELEMENT_CODE' >
<input type='hidden' name='SUB2_ELEMENT_CODE_DESC' id='SUB2_ELEMENT_CODE_DESC' >

<input type='hidden' name='SEGMENTRULE' id='SEGMENTRULE' >
<input type='hidden' name='FILTERSEGRULE' id='FILTERSEGRULE' >
<input type='hidden' name='FILTERSEGELTYPE' id='FILTERSEGELTYPE' >

<input type='hidden' name='segment_type' id='segment_type' >
<input type='hidden' name='segment_class' id='segment_class' >
<input type='hidden' name='segment_element' id='segment_element' >

<input type='hidden' name='jspmode' id='jspmode'>
<input type='hidden' name='actualmode' id='actualmode' value='M'>
<input type='hidden' name='rowid' id='rowid' value=''>
</form>	
</BODY>
</HTML>

