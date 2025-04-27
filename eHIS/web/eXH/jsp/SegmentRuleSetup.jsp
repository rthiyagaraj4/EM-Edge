<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<HTML>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='Stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language="JavaScript" src='../../eCommon/js/common.js'></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>


<%
	Connection con = null;
	ArrayList arrRowSeg = null,arrColSeg = null ;
	XHSelectQuery xhSelect = null;

	String strMessageType = request.getParameter("message_type");
	String strApplicationId = request.getParameter("applicationid");
	String strFacilityId = request.getParameter("facilityid");
	String jspmode="";

	String ROWID="";
	String strOpSegMode = "I";

    
try
{
  con = ConnectionManager.getConnection(request);
  xhSelect = new XHSelectQuery();
  HashMap hashmpParams = new HashMap(5);
  hashmpParams.put("connection",con);
  hashmpParams.put("sql","SELECT ROWID ,SEGMENT_TYPE , FILTER_ATTRIBUTE_TYPE , FILTER_ATTRIBUTE_CODE  "+
  " FROM XH_APPL_SEG_FILTER_RULE WHERE FACILITY_ID='"+strFacilityId+"' AND APPLICATION_ID='"+strApplicationId+"' AND MESSAGE_TYPE='"+strMessageType+"' AND LANGUAGE_ID='"+locale+"'  ");
  hashmpParams.put("col","4");
  arrRowSeg = xhSelect.getResults(hashmpParams);
  arrColSeg = null;	
  hashmpParams.clear();
  for (int j=0;j<arrRowSeg.size();j++)
  {
	arrColSeg = (ArrayList) arrRowSeg.get(j);
  }

  xhSelect = null;
  
  if (arrRowSeg != null)
  {
	if (arrRowSeg.size()>0)
	{
		arrColSeg = (ArrayList) arrRowSeg.get(0);
		strOpSegMode = "U";
	}
  }
  if(arrColSeg!=null) arrColSeg.clear();
  if(arrRowSeg!=null) arrRowSeg.clear();
  ConnectionManager.returnConnection(con);
  }
   catch(Exception exp)
   {
   }

%>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Filter.js'></Script>
<script language="JavaScript" src='../../eXH/js/Validate.js'></Script>
<script language="JavaScript">
//function Populate
function Populate()
{

<% 
	jspmode =request.getParameter("jspmode");
    
    if(jspmode.equalsIgnoreCase("S"))
    { %>
	  var segdiv=document.getElementById("segmentrule");
	  var schdiv=document.getElementById("schedulingrule");
	  segdiv.style.display="none";
	  schdiv.style.display="block";
	  var msgType='<%=strMessageType%>';
	  if(msgType=='ORM')
		{
		  var ssrule=document.getElementById("scheduling_rule");
		  removeAllOptions(ssrule);
		
		  var optn13= document.createElement("OPTION");
		  optn13.text ='-----'+'<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>'+'-----';			
		  optn13.value ='N';
		  ssrule.options.add(optn13);		 
          var optn11= document.createElement("OPTION");
		  optn11.text='<fmt:message key="eXH.OnOrder.Label" bundle="${xh_labels}"/>';			
		  optn11.value ='O';
		  ssrule.options.add(optn11);
		  var optn2= document.createElement("OPTION");
		  optn2.text='<fmt:message key="eXH.OnPatientArrival.Label" bundle="${xh_labels}"/>';			  
		  optn2.value ='P';
		  ssrule.options.add(optn2);
		  var optn12= document.createElement("OPTION");
		  optn12.text='<fmt:message key="eXH.None.Label" bundle="${xh_labels}"/>';			 
		  optn12.value ='N';
		  ssrule.options.add(optn12);


	 }

	 if(msgType=='SIU')
		{
         var ssrule=document.getElementById("scheduling_rule");
		  removeAllOptions(ssrule);
		  var optn13= document.createElement("OPTION");
		  optn13.text ='-----'+'<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>'+'------';
		  optn13.value ='N';
		  ssrule.options.add(optn13);
          var optn11= document.createElement("OPTION");
		  optn11.text='<fmt:message key="eXH.Timed.Label" bundle="${xh_labels}"/>';
		  optn11.value ='T';
		  ssrule.options.add(optn11);
		  var optn2= document.createElement("OPTION");
		  optn2.text='<fmt:message key="eXH.WhenScheduled.Label" bundle="${xh_labels}"/>';
		  optn2.value ='S';
		  ssrule.options.add(optn2);
		  var optn12= document.createElement("OPTION");
		  optn12.text='<fmt:message key="eXH.None.Label" bundle="${xh_labels}"/>';
		  optn12.value ='N';
		  ssrule.options.add(optn12);

		}
		var	srule=this.document.forms[0].scheduling_rule.value;
        if(srule!='T')
		{	
			var stime=document.getElementById("scheduling_time");
			stime.disbled=true;
		}

	<%}%>
}
//function funSearch
function funSearch()
{	
	var fields = new Array ( parent.search.FilterSearchForm.applicationid,
					      parent.search.FilterSearchForm.facilityid,
					      parent.search.FilterSearchForm.message_type);

   var names = new Array ( getLabel("eXH.Application.Label","XH"),
						getLabel("eXH.Facility.Label","XH"),
						getLabel("eXH.MessageType.Label","XH"));
  
	if(!parent.filterframe.checkFieldsofMst( fields, names, parent.messageFrame))
	{
   	  // parent.commontoolbarFrame.document.forms[0].apply.style.display='none';
	}else
		{
	this.document.forms[0].jspmode.value='G';
	this.document.forms[0].action='../../eXH/jsp/FilteringRuleQueryResult.jsp';
	this.document.forms[0].target='recordframe';
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	this.document.forms[0].submit();
		}
	window.parent.commontoolbarFrame.document.forms[0].apply.style.display='none';

}

//function funAdd
function funAdd(val)
{
    var fields = new Array ( parent.search.FilterSearchForm.applicationid,
					      parent.search.FilterSearchForm.facilityid,
					      parent.search.FilterSearchForm.message_type);

   var names = new Array ( getLabel("eXH.Application.Label","XH"),
						getLabel("eXH.Facility.Label","XH"),
						getLabel("eXH.MessageType.Label","XH"));
  
	if(!parent.filterframe.checkFieldsofMst( fields, names, parent.messageFrame))
	{
   	// parent.commontoolbarFrame.document.forms[0].apply.style.display='none';
	}else
		{

	this.document.forms[0].actualmode.value=val;
	this.document.forms[0].action='../../servlet/eXH.XHFilterRuleRecordServlet';
	this.document.forms[0].target='messageFrame';
   	this.document.forms[0].submit();
		}
   	window.parent.commontoolbarFrame.document.forms[0].apply.style.display='none';


}
//function onLoadpage
function onLoadpage()
{
 <%
	 if(arrColSeg!=null){
	 if (arrColSeg.size()>0)
	 {
	   
	  ROWID=(String)arrColSeg.get(0);

  %>
	 var d1=document.getElementById("ss1");
     var d2=document.getElementById("fss1");
     var d3=document.getElementById("fee1");

     for( var j=0;j<d1.options.length;j++)
     {
	   if(d1.options[j].value =='<%=arrColSeg.get(1)%>')
       d1.options[j].selected=true;
     }

     for( var j=0;j<d2.options.length;j++)
     {
	   if(d2.options[j].value =='<%=arrColSeg.get(2)%>')
       d2.options[j].selected=true;
     }

     for( var j=0;j<d3.options.length;j++)
     {
	   if(d3.options[j].value =='<%=arrColSeg.get(3)%>')
       d3.options[j].selected=true;
     }

	var dd1=document.getElementById("addbtton");
    var dd2=document.getElementById("searchbtton");
	var dd3=document.getElementById("modbtton");
    dd1.style.display="none";
    dd2.style.display="none";
	dd3.style.display="block";
	
	<% } }%>

   <%
	String mm=request.getParameter("actualmode");
	if(mm!=null){
	if(mm.equalsIgnoreCase("M"))
	{
		String s1=request.getParameter("SEGMENTRULE");
		String f1=request.getParameter("FILTERSEGRULE");
		String t1=request.getParameter("FILTERSEGELTYPE");
	    ROWID=request.getParameter("rowid");
%>
    
    var d1=document.getElementById("ss1");
    var d2=document.getElementById("fss1");
    var d3=document.getElementById("fee1");

    var dd1=document.getElementById("addbtton");
    var dd2=document.getElementById("searchbtton");
	var dd3=document.getElementById("modbtton");
    dd1.style.display="none";
    dd2.style.display="none";
	dd3.style.display="block";
	
    for( var j=0;j<d1.options.length;j++)
    {
	   if(d1.options[j].value =='<%=s1%>')
       d1.options[j].selected=true;
    }

    for( var j=0;j<d2.options.length;j++)
    {
	   if(d2.options[j].value =='<%=f1%>')
       d2.options[j].selected=true;
    }

    for( var j=0;j<d3.options.length;j++)
    {
	   if(d3.options[j].value =='<%=t1%>')
       d3.options[j].selected=true;
    }

<% } } %>
  
}
//function disableSRule
function disableSRule()
{
	  var srule=this.document.forms[0].scheduling_rule.value;
	  var stime=document.getElementById("scheduling_time");
	  if(srule!='T') stime.disabled=true;
	  else {
		 	stime.disabled=false;	
			stime.enabled=true;
		}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 OnLoad="Populate();onLoadpage();"onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="SegmentRuleSetup" id="SegmentRuleSetup"  action='' target='' method="post">
<div id='segmentrule' style='display:block'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr><td colspan=6 ></td></tr>
<tr>
<td class=label ><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name='segment_type' id='segment_type' id="ss1">
<option value=''>------------------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------------------</option>
<option value='AL1'><fmt:message key="eXH.PatientAllergy.Label" bundle="${xh_labels}"/></option>
</select>
</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.FilterType.Label" bundle="${xh_labels}"/></td>
<td class='fields'><select name ='segment_class' id="fss1">
<option value=''>------------------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------------------</option>
<option value='A'><fmt:message key="eXH.AllergyClass.Label" bundle="${xh_labels}"/></option>

</select>
</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.ElementType.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select name ='segment_element' id="fee1" > 
<option value=''>--------------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------------</option>
<option value='F'><fmt:message key="eXH.Food.Label" bundle="${xh_labels}"/> </option>
<option value='D'><fmt:message key="eXH.Drug.Label" bundle="${xh_labels}"/></option>
<option value='G'><fmt:message key="eXH.General.Label" bundle="${xh_labels}"/></option>
<option value='A'><fmt:message key="eXH.All.Label" bundle="${xh_labels}"/></option>
</select>
</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr><td colspan=6 align=right>
<input style="display:block" class='button' id="addbtton"   type="button"   name='adds' id='adds' value='<fmt:message key="eXH.Record.Label" bundle="${xh_labels}"/>' onClick="funAdd('I')"></td>
<td><input style="display:block" class='button'  id="searchbtton" type="button"  name='Searchs' id='Searchs' value='<fmt:message key="eXH.Search.Label" bundle="${xh_labels}"/>' onClick='funSearch()'></td>
<td><input style="display:none" class='button' id="modbtton"  type="button" name='adds' id='adds' value='<fmt:message key="eXH.Modify.Label" bundle="${xh_labels}"/>' onClick="funAdd('M')">
</td>
</tr>
</table>
</div>
<!-----------------------------------SCHEDULING RULE ---------------------------->
<div id='schedulingrule' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr><td colspan=6 /></tr>
<tr>
<td class=label><fmt:message key="eXH.MessageTriggerEvent.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select name ='scheduling_rule' id="scheduling_rule" onChange="disableSRule()">
<option value='N'>--------------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------------</option>
</select>
</td></tr>
<tr>
<td class=label ><fmt:message key="eXH.MessageTriggerTime.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<input type=text name='scheduling_time' id='scheduling_time' id="scheduling_time" size=4  onblur='checkNumber(this)'> <b class=label><fmt:message key="eXH.Hours.Label" bundle="${xh_labels}"/></td></tr>

<tr><td colspan=4 class= 'BUTTON'>
<input class='button' type="button"  name='ssadd' id='ssadd' value='<fmt:message key="eXH.Record.Label" bundle="${xh_labels}"/>' onClick='funAdd()'>
</td>
</tr>
<tr>
<td colspan=6></td>
</tr>

</table>
</div>

<input type='hidden' name='applicationid' id='applicationid' value='<%=strApplicationId%>'>
<input type='hidden' name='message_type' id='message_type' value='<%=strMessageType%>'>
<input type='hidden' name='facilityid' id='facilityid' value='<%=strFacilityId%>'>
<input type='hidden' name='filter_type' id='filter_type' value='L'>
<input type='hidden' name='filter_sub_type' id='filter_sub_type' value='*'>
<input type='hidden' name='filter_sub1_type' id='filter_sub1_type' value='*'>
<input type='hidden' name='filter_sub2_type' id='filter_sub2_type' value='*'>
<input type='hidden' name='actualmode' id='actualmode' value='I'>
<input type='hidden' name='rowid' id='rowid' value='<%=ROWID%>'>
<input type='hidden' name='jspmode' id='jspmode' value='G'>
</form>	
</BODY>
</HTML>

