<!DOCTYPE html>
<%@ page import  ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,webbeans.eCommon.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML> 
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<% 
String function_name="Application Level";
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
ResultSet rs1  = null;
//ResultSet standrs=null;
//Statement standstmt=null;
//Statement segstmt=null;
//ResultSet segrs=null; 
//String selected = "selected";
String defaultval = "";
String code_yn="";
String version_no="";
String application_id="";
%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script> 
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReferenceappltab.js'></script> 
<script language="JavaScript">
function onSelectStandardType()
{  
var	element_id='';
var element_desc='';   
var tab11=document.getElementById("tab1");
var stnd_code=document.forms[0].Standardcode_combo.value;
var seg_type=document.forms[0].segment_type.value;
var appl_id=document.forms[0].application.value;  
if(appl_id=='')
{ 
	alert(getMessage( 'XH1003','XH'));
	parent.parent.frames[0].document.forms[0].appli.focus();
	return;
}

parent.frames[2].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp?applicationid='+appl_id+'&segment_type_id='+seg_type+'&standard_code='+stnd_code+'&element_id=&element_desc=';
 

}
async function funPrev()
{
	var stnd_code=document.forms[0].Standardcode_combo.value;
		var seg_type=document.forms[0].segment_type.value;
			var appl =  this.document.forms[0].application.value; 
		var dialogHeight = "90vh";
var dialogWidth  = "95vw";
var dialogTop    = "115";
var dialogLeft   = "115";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  =new Array();
	var url="../../eXH/jsp/DataElementCrossRefApplicationElementSetupPreview.jsp?applicationid="+appl+"&segment_type_id="+seg_type+"&standard_code="+stnd_code;; 
 await window.showModalDialog(url,arguments,features);  
} 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>		

<BODY  leftmargin=0 topmargin=0   onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="">

<form name="application_element_setup_form" id="application_element_setup_form">

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>    
</tr>
<tr><td width='30%'></td><td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='fields'>
<%
try
{
	con=ConnectionManager.getConnection();
	String qry = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW where IN_USE_YN='Y' and   LANGUAGE_ID='en' ";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
%>

<select class='select' name='application' id='application' onChange="onSelectAppliction();location.href='../../eXH/jsp/DataElementCrossRefApplicationTab.jsp?application_id='+this.value;" style="width:200">
            <option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%
application_id=request.getParameter("application_id");
defaultval=application_id;

	while(rs.next())
            {
              if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
%>
<option value='<%=rs.getString(1)%>'  selected ><%=rs.getString(2)%></option>
 <%             } 
              else
              {
           %>
<option value='<%=rs.getString(1)%>'  ><%=rs.getString(2)%></option>
		   <%
              }

			}
%>
	
            
		

            </select>

 <%

rs1 = stmt.executeQuery("select MASTER_CODE_MAP_YN from  xh_param ");
while(rs1.next())
{

 code_yn=rs1.getString(1);
}
rs1 = stmt.executeQuery("select VERSION_NO from  SM_INSTALLATION ");
while(rs1.next())
{

 version_no=rs1.getString(1);
}
if(rs1!=null)rs1.close();
}catch(Exception e1)
{
	System.out.println("(DataElementCrossRefApplicationTab.jsp:Excception-1):"+e1.toString());
}

%>
<img src='../../eCommon/images/mandatory.gif' align=middle> </td>



<%---<td class=label>Standard Type</td> 
<td class='fields'>
<%
try
{ 
 defaultval="";

	String qry = "select distinct a.standard_type, decode(a.standard_type,'H','HL7 Interface','P','PABX Interface','E','Electronic Health Record','C','Centralised Patient Record','OT','Oracle Table','ST','SQL Server Table','O','Other Interface')standard_desc from xh_standard a,xh_standard_profile b where a.STANDARD_CODE=b.STANDARD_CODE and a.standard_type is not NULL and b.application_id=nvl('"+application_id+"',b.application_id)";
	standstmt = con.createStatement();
	standrs = standstmt.executeQuery(qry);
%>
 
<select class='select' name='Standardcode_combo' id='Standardcode_combo' onChange='onSelectStandardType()' style="width:200"> 
            <option value='' selected>-------Select-------</option> 
<%
	while(standrs.next())
            {
              if ((standrs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              } 
%>
	<option value='<%=standrs.getString(1)%>'  "+selected+" ><%=standrs.getString(2)%></option> 
            
		<% 	}  
	if(standrs!=null)standrs.close();
			if(standstmt!=null)standstmt.close();


}catch(Exception e1)
{
	System.out.println("(DataElementCrossRefApplicationTab.jsp:Excception-2):"+e1.toString());
}


			%>

            </select>
</td>---%>





<%---<td class=label>Segments</td>
<td class='fields'>
<select class='select' name='segment_type' id='segment_type' onChange='onSelectStandardType()' style="width:200">
            <option value='' selected>-------Select-------</option>
<%
try
{
	
	String qry = "SELECT distinct a.SEGMENT_TYPE,b.SEGMENT_NAME FROM xh_appl_event_segment a,xh_segment b where a.SEGMENT_TYPE=b.SEGMENT_TYPE and a.APPLICATION_ID=nvl('"+application_id+"',a.APPLICATION_ID) and b.IN_USE_YN='Y'   ";
	
	segstmt = con.createStatement();
	segrs = segstmt.executeQuery(qry);
	while(segrs.next())
            {
              if ((segrs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }
%>
	<option value='<%=segrs.getString(1)%>'  "+selected+" ><%=segrs.getString(2)%></option>
            




 <%
}
		if(con!=null)
	{

con.close();
	}

if(segrs!=null)segrs.close();
		if(segstmt!=null)segstmt.close();
	

}catch(Exception e1)
{
	System.out.println("(DataElementCrossRefApplicationTab.jsp:Excception-2):"+e1.toString());
}
%>
            </select>
 </td>---%>

 <td></td>
</tr>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
</tr>
</table>
 <%---<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  <tr><td>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title='<fmt:message key="Common.Usage.label" bundle="${common_labels}"/>'>
				<a onclick="callJSPs('tab1')" class="tabA" id='tab1' >
					<span class="tabAspan" id="tab1_tabspan"><fmt:message key="Common.Usage.label" bundle="${common_labels}"/></span>
				</a>
			 </li>
			 <%
			
			 if(version_no.equals("10.2.10"))
			 {
				 %>
			 <li class="tablistitem" title='<fmt:message key="eXH.TableValues.Label" bundle="${xh_labels}"/>' disabled>
				<a onclick="callJSPs('tab2')" class="tabA" id="tab2" disabled>
					<span class="tabAspan" id="tab2_tabspan" disabled><fmt:message key="eXH.TableValues.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   <li class="tablistitem" title='<fmt:message key="eXH.NonTableValues.Label" bundle="${xh_labels}"/>' disabled>
				<a onclick="callJSPs('tab3')" class="tabA" id="tab3" disabled>
					<span class="tabAspan" id="tab3_tabspan" disabled><fmt:message key="eXH.NonTableValues.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   <%}
			else
			{%>
				 <li class="tablistitem" title='<fmt:message key="eXH.TableValues.Label" bundle="${xh_labels}"/>'>
				<a onclick="callJSPs('tab2')" class="tabA" id="tab2" >
					<span class="tabAspan" id="tab2_tabspan"><fmt:message key="eXH.TableValues.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   <li class="tablistitem" title='<fmt:message key="eXH.NonTableValues.Label" bundle="${xh_labels}"/>'>
				<a onclick="callJSPs('tab3')" class="tabA" id="tab3" >
					<span class="tabAspan" id="tab3_tabspan"><fmt:message key="eXH.NonTableValues.Label" bundle="${xh_labels}"/></span>
				</a>
		   </li>
		   <%}%>
       </ul> 
	 </td>
<td colspan=4><input class='button' type="button"  name='Preview' id='Preview' value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' onClick='funPrev()'></td>

   </tr>
</table>---%>
           

<%
		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);
%>
<input  type="hidden" name=code value='<%=code_yn%>'/>
<input  type="hidden" name=version_no value='<%=version_no%>'/>
<input  type="hidden" name=function_name value='<%=function_name%>'/>
</form>

</BODY>
</HTML>

