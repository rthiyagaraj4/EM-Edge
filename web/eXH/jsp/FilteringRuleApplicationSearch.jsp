<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<%
	Connection con = null;
	ArrayList arrRow = null,arrCol=null,arrRow1=null;
	XHSelectQuery xhSelect = null;
	String strApplicationId = "";
	Statement stmt = null;
	ResultSet rs  = null;
	String selected = "selected";
	String defaultval = "";
	String filter_yn="";
%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<Script Langauage='JavaScript'>

var tab1=document.getElementById("filterruletab");
var tabspan1=document.getElementById("filterruletab_tabspan");
var tab2=document.getElementById("segmentruletab");
var tabspan2=document.getElementById("segmentruletab_tabspan");
var tab3=document.getElementById("schedulingruletab");
var tabspan3=document.getElementById("schedulingruletab_tabspan");

//Mandatory checks
function funChangeFacility(obj)
{
	var val = this.document.forms[0].applicationid.value;
	
	if ((val=='') ||(val==null))
	{
		alert(getMessage('XH1003','XH'));
		obj.value = '';
	}
}
// Mandatory checks

function onSelectMessageType(obj)
{
	var val1 = this.document.forms[0].applicationid.value;
	var val2 = this.document.forms[0].facilityid.value;
	var val3 = this.document.forms[0].message_type.value;
	if ((val1=='')||(val2=='')||(val1==null)||(val2==null))
	{
		alert(geteMessage('XH1004','XH'));
		obj.value = '';
	}
	onPage(3);
	parent.filterframe.location.href="../../eCommon/html/blank.html";
	parent.recordframe.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	
}
//function callJSPs
function callJSPs(str)
{
	
	var msgType =this.document.forms[0].message_type.value;
	
	var filter_ynw=this.document.forms[0].filter_yn.value;

	var tab1=document.getElementById("filterruletab");
	var tabspan1=document.getElementById("filterruletab_tabspan");
	var tab2=document.getElementById("segmentruletab");
	var tabspan2=document.getElementById("segmentruletab_tabspan");
	var tab3=document.getElementById("schedulingruletab");
	var tabspan3=document.getElementById("schedulingruletab_tabspan");


	
	if(filter_ynw=='Y'){

	if((msgType=='ADT')||(msgType=='ADR')||(msgType=='ORM')||(msgType=='ORU')||(msgType=='SIU'))
    {
	
		if (str=='filterruletab')
		{  
			tab1.className='tabClicked';
			tabspan1.className='tabSpanclicked';
			tab2.className='tabA';
			tabspan2.className='tabAspan';
			tab3.className='tabA';
			tabspan3.className='tabAspan';

			this.document.forms[0].action='../../eXH/jsp/FilterRuleSetupTypesSubType.jsp';
	        this.document.forms[0].target='filterframe';
			parent.recordframe.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	        this.document.forms[0].submit();
	      
		}
		if (str=='segmentruletab')
		{
			tab1.className='tabA';
			tabspan1.className='tabAspan';
			tab2.className='tabClicked';
			tabspan2.className='tabSpanclicked';
			tab3.className='tabA';
			tabspan3.className='tabAspan';

			this.document.forms[0].jspmode.value='G';
			this.document.forms[0].action='../../eXH/jsp/SegmentRuleSetup.jsp';
	        this.document.forms[0].target='filterframe';
			parent.recordframe.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	        this.document.forms[0].submit();
		
		}
		if (str=='schedulingruletab')
		{
			if((msgType=='ORM')||(msgType=='SIU'))
			{
				tab1.className='tabA';
				tabspan1.className='tabAspan';
				tab2.className='tabA';
				tabspan2.className='tabAspan';
				tab3.className='tabClicked';
				tabspan3.className='tabSpanclicked';

				this.document.forms[0].jspmode.value='S';
				this.document.forms[0].action='../../eXH/jsp/SegmentRuleSetup.jsp';
	            this.document.forms[0].target='filterframe';
				parent.recordframe.location.href="../../eCommon/html/blank.html";
				parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	            this.document.forms[0].submit();
		               
			}
		}
	}
	else
	{
	  alert(getMessage("XH1007","XH"));
	  this.document.forms[0].focus();
	  return false;
	}
   }
	else
		{
            alert(getMessage("XH1030","XH"));
	        this.document.forms[0].focus();
	        return false;
		}
}
//function chnage
function change()
{


var tab1=document.getElementById("filterruletab");
var tabspan1=document.getElementById("filterruletab_tabspan");
var tab2=document.getElementById("segmentruletab");
var tabspan2=document.getElementById("segmentruletab_tabspan");
var tab3=document.getElementById("schedulingruletab");
var tabspan3=document.getElementById("schedulingruletab_tabspan");

tab1.className='tabA';
tabspan1.className='tabAspan';
tab2.className='tabA';
tabspan2.className='tabAspan';
tab3.className='tabA';
tabspan3.className='tabAspan';

parent.filterframe.location.href="../../eCommon/html/blank.html";
parent.recordframe.location.href="../../eCommon/html/blank.html";
parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='' action=''>
<%
try
{
				
		con = ConnectionManager.getConnection(request);
		xhSelect = new XHSelectQuery();
		HashMap hashmpParams = new HashMap(5);
		hashmpParams.put("connection",con);
		hashmpParams.put("sql","SELECT DISTINCT X.APPLICATION_ID APPLICATION_ID,X.APPLICATION_NAME APPLICATION_NAME,Y.FACILITY_ID FACILITY_ID,Z.FACILITY_NAME FACILITY_NAME FROM XH_APPLICATION_LANG_VW X,XH_APPL_FOR_FACILITY Y,SM_FACILITY_PARAM_LANG_VW Z WHERE X.APPLICATION_ID=Y.APPLICATION_ID AND Y.FACILITY_ID=Z.FACILITY_ID AND X.IN_USE_YN='Y' AND Y.FILTER_RULE_TYPE='R' AND X.LANGUAGE_ID='"+locale+"' AND X.LANGUAGE_ID=Z.LANGUAGE_ID 	ORDER BY 1,2,3,4");
		hashmpParams.put("col","4");
		arrRow = xhSelect.getResults(hashmpParams);
		arrCol = null;	
		hashmpParams.clear();
        hashmpParams.put("connection",con);
		hashmpParams.put("sql","SELECT DISTINCT Y.FACILITY_ID FACILITY_ID,Z.FACILITY_NAME FACILITY_NAME FROM XH_APPLICATION_LANG_VW X,XH_APPL_FOR_FACILITY Y,SM_FACILITY_PARAM_LANG_VW Z WHERE X.APPLICATION_ID=Y.APPLICATION_ID AND Y.FACILITY_ID=Z.FACILITY_ID AND X.IN_USE_YN='Y' AND Y.FILTER_RULE_TYPE='R' AND X.LANGUAGE_ID='"+locale+"' AND X.LANGUAGE_ID=Z.LANGUAGE_ID ORDER BY 2");
		hashmpParams.put("col","2");
		arrRow1 = xhSelect.getResults(hashmpParams);
		hashmpParams.clear();
        stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT FILTER_YN FROM  xh_param ");
        while(rs.next())
        {

               filter_yn=rs.getString(1);
        }
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();	
}
catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilteringRuleApplicationsearch.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
																											  
%>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
</tr>
</tr>
<tr>
<td class="label"><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='fields'>
<select class='select' name='applicationid' id='applicationid' onChange="change()" >
<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%
for (int j=0;j<arrRow.size();j++)
{
	arrCol = (ArrayList) arrRow.get(j);
	if (!(strApplicationId.equalsIgnoreCase(arrCol.get(0)+"")))
	{
		strApplicationId = (String)arrCol.get(0);
%>
<option value='<%=strApplicationId%>'><%=arrCol.get(1)+""%></option>
<%
	}
}
%>
</select><img src='../../eCommon/images/mandatory.gif'>
<td></td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'><select class='select' name='facilityid' id='facilityid'  onChange="change()" >
<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
for (int q=0;q<arrRow1.size();q++)
{
	arrCol = (ArrayList) arrRow1.get(q);

%>
<option value='<%=arrCol.get(0)+""%>'><%=arrCol.get(1)+""%></option>
<%
}
if(arrCol!=null) arrCol.clear();
if(arrRow1!=null) arrRow1.clear();
if(arrRow!=null) arrRow.clear();
%>
</select><img src='../../eCommon/images/mandatory.gif'> </td>
<td></td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.MessageType.label" bundle="${common_labels}"/></td>
<td class='fields'>
<%
try
{
String qry = "SELECT MESSAGE_TYPE,DESCRIPTION FROM XH_MESSAGE_TYPE_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>
<select class='select' name='message_type' id='message_type' onChange="onSelectMessageType(this);">
            <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
	while(rs.next())
            {
              if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }
%>
	<option value='<%=rs.getString(1)%>'  "+selected+" ><%=rs.getString(2)%></option>
            
		<% 	}%>

            </select>
<%

}catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of FilteringRuleApplicationsearch.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }																						  
finally{
			try{
			if(rs!=null)rs.close();
	        if(stmt!=null)stmt.close();			
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				out.println("Exception is "+e.toString());
				}
	       }
%>
<img src='../../eCommon/images/mandatory.gif'> </td>
<td></td>
</tr>
<tr>
		<td colspan=3></td>
	</tr>

</table>
 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  <tr><td>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="<fmt:message key="eXH.FilterRules.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('filterruletab')" class="tabA" id='filterruletab' >
					<span class="tabAspan" id="filterruletab_tabspan"><fmt:message key="eXH.FilterRules.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title="<fmt:message key="eXH.Segments.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('segmentruletab')" class="tabA" id="segmentruletab" >
					<span class="tabAspan" id="segmentruletab_tabspan"><fmt:message key="eXH.Segments.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   <li class="tablistitem" title="<fmt:message key="eXH.Scheduling.Label" bundle="${xh_labels}"/>">
				<a onclick="callJSPs('schedulingruletab')" class="tabA" id="schedulingruletab" >
					<span class="tabAspan" id="schedulingruletab_tabspan"><fmt:message key="eXH.Scheduling.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
       </ul>
	 </td>
   </tr>
</table>
	
<input type='hidden' name='jspmode' id='jspmode'>
<input type='hidden' name='filter_yn' id='filter_yn' value='<%=filter_yn%>'>
</form>	
</BODY>
</HTML>

