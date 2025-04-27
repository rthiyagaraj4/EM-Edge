<!DOCTYPE html>
<HTML>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%

	String strMessageType = request.getParameter("message_type");
	String strApplicationId = request.getParameter("applicationid");
	String strFacilityId = request.getParameter("facilityid");
	String filter_type = request.getParameter("filter_type");
	String filter_sub_type = request.getParameter("filter_sub_type");
	String filter_sub1_type = request.getParameter("filter_sub1_type");
	String filter_sub2_type = request.getParameter("filter_sub2_type");
	String FILTER_ELEMENT_TYPE="";
	String FILTER_SUB_ELEMENT_TYPE="";
	String FILTER_SUB1_ELEMENT_TYPE="";
	String FILTER_SUB2_ELEMENT_TYPE="";
    String ELEMENT_CODE_DESC="";
	String SUB_ELEMENT_CODE_DESC="";
	String SUB1_ELEMENT_CODE_DESC="";
	String SUB2_ELEMENT_CODE_DESC="";
    String ROWID="";
	String actualmode = request.getParameter("actualmode").trim();
	if(actualmode.equalsIgnoreCase("M"))
	{
		
		FILTER_ELEMENT_TYPE = request.getParameter("FILTER_ELEMENT_TYPE").trim();
		FILTER_SUB_ELEMENT_TYPE = request.getParameter("FILTER_SUB_ELEMENT_TYPE").trim();
		FILTER_SUB1_ELEMENT_TYPE = request.getParameter("FILTER_SUB1_ELEMENT_TYPE").trim();
		FILTER_SUB2_ELEMENT_TYPE = request.getParameter("FILTER_SUB2_ELEMENT_TYPE").trim();

        ELEMENT_CODE_DESC = request.getParameter("ELEMENT_CODE_DESC").trim();
		SUB_ELEMENT_CODE_DESC = request.getParameter("SUB_ELEMENT_CODE_DESC").trim();
		SUB1_ELEMENT_CODE_DESC = request.getParameter("SUB1_ELEMENT_CODE_DESC").trim();
		SUB2_ELEMENT_CODE_DESC = request.getParameter("SUB2_ELEMENT_CODE_DESC").trim();
        ROWID = request.getParameter("rowid").trim();
	}
%>
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eCommon/js/CommonLookup.js'> </Script>
<script language="JavaScript" src='../../eXH/js/FilterElementsSetting.js'> </Script>
<script language="JavaScript" src='../../eXH/js/FilterSettingLookup.js'> </Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script> 
//function tempAssign
function tempAssign()
{
	this.document.forms[0].filterelement_value.value = '*';
	this.document.forms[0].filterelement_sub_value.value = '*';
	this.document.forms[0].filterelement_sub1_value.value = '*';
	this.document.forms[0].filterelement_sub2_value.value = '*';
}
//function changeElement
function changeElement(obj)
{
	var element = obj.getAttribute('name');
	var elementArr = element.split('_type');
	var val = '*';
	var valDes = 'None';
	if (obj.value == '*')
	{
		val = '*';
		valDes = 'None';
	}
	else
	{
		val = '';
		valDes = '';
	}
	eval('this.document.forms[0].'+elementArr[0]+'_value').value = val;
	eval('this.document.forms[0].'+elementArr[0]+'_desc').value = valDes;
}
//function reload
function reload()
{
	this.parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.parent.filterframe.funSearch();
}
//function record
function record(val)
{
	var fields = new Array ( parent.search.FilterSearchForm.applicationid,
					      parent.search.FilterSearchForm.facilityid,
					      parent.search.FilterSearchForm.message_type);

   var names = new Array ( getLabel("Common.Application.label","XH"),
						getLabel("Common.facility.label","XH"),
						getLabel("Common.MessageType.label","XH"));
  
	if(!parent.recordframe.checkFieldsofMst( fields, names, parent.messageFrame))
	{
   	  // alert("1");
	  //window.parent.commontoolbarFrame.document.forms[0].apply.style.display='none'; 
	  // alert("2");

	}else
		{
	var allElements = this.document.forms[0].elements;
	this.document.forms[0].actualmode.value = val;
	this.document.forms[0].submit();
		}
	
	
}
//function setValues
function setValues()
{   
	this.document.forms[0].f1.value='<%=filter_type%>';
	this.document.forms[0].f2.value='<%=filter_sub_type%>';
	this.document.forms[0].f3.value='<%=filter_sub1_type%>';
	this.document.forms[0].f4.value='<%=filter_sub2_type%>';
	
}
//function cancel
function cancel()
{
parent.recordframe.location.href='../../eCommon/html/blank.html';

}
</Script>
</HEAD>
<BODY  onLoad="setValues();firstMethod()"  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="SetupFilterElement" id="SetupFilterElement" action='../../servlet/eXH.XHFilterRuleRecordServlet' target='messageFrame' method='post'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.Element.label" bundle="${common_labels}"/></td>
	<td  class='fields'>
	<select name="filterelement_type" id="filterelement_type" id="filter_type" onChange='setTextValues()'>
	<option value='*'><fmt:message key="eXH.None.Label" bundle="${xh_labels}"/></option>
	</select> 
	<input type=text name='filterelement_desc' id='filterelement_desc' id="filterelement_desc" size='15'>
	<input class='button' type='button' sql='' name='filterelement' id='filterelement'  value='?' onClick="lookup(this)" align=middle><img src='../../eCommon/images/mandatory.gif'>
	<input type='hidden' name='filterelement_value' id='filterelement_value' id="filterelement_value" value="*" ></input>
	</td>
	
	<td class=label  nowrap><fmt:message key="eXH.SubElement.Label" bundle="${xh_labels}"/></td>
	<td  class='fields'><select name="filterelement_sub_type" id="filterelement_sub_type" id="filter_sub_type" onChange='setTextValues1()'>
	<option value='*'><fmt:message key="eXH.None.Label" bundle="${xh_labels}"/></option>
	</select> 
	<input type=text name='filterelement_sub_desc' id='filterelement_sub_desc' id="filterelement_sub_desc" size='15'>
	<input type='button' name='filterelement_sub' id='filterelement_sub' sql='' class='button' value='?' onClick="lookup(this)"><img src='../../eCommon/images/mandatory.gif'>
	<input type='hidden' name='filterelement_sub_value' id='filterelement_sub_value' id="filterelement_sub_value" value="*"></input>
	</td>
</tr>
<tr>
	<td class=label  nowrap><fmt:message key="eXH.Sub1Element.Label" bundle="${xh_labels}"/></td>
	<td class='fields'><select name="filterelement_sub1_type" id="filterelement_sub1_type" id="filter_sub1_type"  onChange='setTextValues2()'>
	<option value='*'><fmt:message key="eXH.None.Label" bundle="${xh_labels}"/></option>
	</select> 
	<input type=text name='filterelement_sub1_desc' id='filterelement_sub1_desc' id="filterelement_sub1_desc" size='15'>
	<input class='button' type='button'  name='filterelement_sub1' id='filterelement_sub1'  sql='' value='?' onClick="lookup(this)"><img src='../../eCommon/images/mandatory.gif'>
	<input type='hidden' name='filterelement_sub1_value' id='filterelement_sub1_value' id="filterelement_sub1_value" value="*"></input>
	</td>
	<td class=label  nowrap><fmt:message key="eXH.Sub2Element.Label" bundle="${xh_labels}"/></td>
	<td  class='fields'><select name="filterelement_sub2_type" id="filterelement_sub2_type" id="filter_sub2_type"  onChange='setTextValues3()'>
	<option value='*'><fmt:message key="eXH.None.Label" bundle="${xh_labels}"/></option>
	</select> 
	<input type='text' name='filterelement_sub2_desc' id='filterelement_sub2_desc' id="filterelement_sub2_desc" size='15'>
	<input class='button' type='button'  name='filterelement_sub2' id='filterelement_sub2'  sql='' value='?' onClick="lookup(this)"><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<input type='hidden' name='filterelement_sub2_value' id='filterelement_sub2_value' id="filterelement_sub2_value" value="*" >
</tr>
</table>

<table cellspacing=0 cellpadding=0 width='100%' border=0 align=center id='insertoper' style='display:inline'>
<tr>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record('I')">
<input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.Label" bundle="${common_labels}"/>' onClick="cancel()"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center id='modifyoper' style='display:none'>
<tr>
<td colspan=8 align=right ><input class='button' type='button'  name='modify' id='modify' value='<fmt:message key="eXH.Modify.Label" bundle="${xh_labels}"/>' onClick="record('U')"></td>
</tr>
<tr>
<td >
</td>
</tr>
</table>

<input type='hidden' name='facilityid' id='facilityid' value='<%=strFacilityId%>'>
<input type='hidden' name='applicationid' id='applicationid' value='<%=strApplicationId%>'>
<input type='hidden' name='message_type' id='message_type' value='<%=strMessageType%>'>

<input type='hidden' name='filter_type' id='filter_type' value='<%=filter_type%>'>
<input type='hidden' name='filter_sub_type' id='filter_sub_type' value='<%=filter_sub_type%>'>
<input type='hidden' name='filter_sub1_type' id='filter_sub1_type' value='<%=filter_sub1_type%>'>
<input type='hidden' name='filter_sub2_type' id='filter_sub2_type' value='<%=filter_sub2_type%>'>

<input type='hidden' name='f1' id='f1' value='<%=filter_type%>'>
<input type='hidden' name='f2' id='f2' value='<%=filter_sub_type%>'>
<input type='hidden' name='f3' id='f3' value='<%=filter_sub1_type%>'>
<input type='hidden' name='f4' id='f4' value='<%=filter_sub2_type%>'>

<input type='hidden' name='f11' id='f11' value='<%=FILTER_ELEMENT_TYPE%>'>
<input type='hidden' name='f22' id='f22' value='<%=FILTER_SUB_ELEMENT_TYPE%>'>
<input type='hidden' name='f33' id='f33' value='<%=FILTER_SUB1_ELEMENT_TYPE%>'>
<input type='hidden' name='f44' id='f44' value='<%=FILTER_SUB2_ELEMENT_TYPE%>'>

<input type='hidden' name='f11_desc' id='f11_desc' value='<%=ELEMENT_CODE_DESC%>'>
<input type='hidden' name='f22_desc' id='f22_desc' value='<%=SUB_ELEMENT_CODE_DESC%>'>
<input type='hidden' name='f33_desc' id='f33_desc' value='<%=SUB1_ELEMENT_CODE_DESC%>'>
<input type='hidden' name='f44_desc' id='f44_desc' value='<%=SUB2_ELEMENT_CODE_DESC%>'>

<input type='hidden' name='segment_type' id='segment_type' value=''>
<input type='hidden' name='segment_class' id='segment_class' value=''>
<input type='hidden' name='segment_element' id='segment_element' value=''>
<input type='hidden' name='scheduling_rule' id='scheduling_rule' value=''>
<input type='hidden' name='scheduling_time' id='scheduling_time' value=''>
<input type='hidden' name='actualmode' id='actualmode' value='<%=actualmode%>'>		
<input type='hidden' name='rowid' id='rowid' value='<%=ROWID%>'>
</form>	
</BODY>
</HTML>

