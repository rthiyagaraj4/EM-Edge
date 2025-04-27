<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
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
String code="";
Connection con=null;  
Statement stmt = null;
ResultSet rs  = null;
ResultSet rs1  = null;
ResultSet standrs=null;
Statement standstmt=null;
Statement segstmt=null;
ResultSet segrs=null; 
String defaultval = "";
String code_yn="";
String version_no=""; 
Statement protocolstmt=null;
ResultSet protocolrs=null;
String application_id="";
String facility_id="";String message_type="";String event_type="";String total_levels="";
String procol_link="";

 code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code_combo"));
application_id=XHDBAdapter.checkNull(request.getParameter("Application_type_id"));
String newcode=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
String newdesc=XHDBAdapter.checkNull(request.getParameter("Filter_group_desc"));
procol_link=XHDBAdapter.checkNull(request.getParameter("Protocol_Link_id"));

//System.out.println("newcode ="+newcode);

%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReference.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReferenceappltab.js'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



<script language="JavaScript">
function checklength(event,obj)
{
    var bool=true;
	
		  if(obj.value.length<=10)
		{
			bool=true;
		}
		else
		{
			bool=false;
		}
	
	
	return bool;
}
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789abcdefghijklmnopqrtsuvwxyzABCDEFGHIJKTLMNOPQRSUVWXYZ';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
function checkEmptyChar(obj)
{
var fields=obj.value;
obj.value=fields.toUpperCase();
if(fields.indexOf(' ')!=-1)
{
alert(getMessage('XH0068','XH'));
obj.focus();
}

}
function  onSelectChange()
{
//parent.frames[2].document.location.href='../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo='+this.value+//'&Application_type_id='++'&Filter_group_code='++'&Filter_group_desc='++'Protocol_Link_id='+;
	this.document.forms[0].action='../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp';
   this.document.forms[0].target='';
   this.document.forms[0].submit();
}

function onSelectStandardType()
{


  /*var index		= document.forms[0].Filter_group_code1.options.selectedIndex;
	document.forms[0].description_type.value= document.forms[0].Filter_group_code1.options[index].text;
document.forms[0].Filter_group_desc.value= document.forms[0].Filter_group_code1.options[index].text;*/
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>

<BODY  leftmargin=0 topmargin=0   onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="">

<form name="application_element_setup_form" id="application_element_setup_form" action='../../eXH/jsp/FilterLayerGroupRecord.jsp'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<!--<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='30%'></td>
	<td width='30%'></td> 
</tr>--->
<tr>
<td class=label><fmt:message key="eXH.SysdefGroup.Label" bundle="${xh_labels}"/></td> 
<td class='fields'>
<%
try
{
	con=ConnectionManager.getConnection();
    defaultval="";
	String qry = "SELECT FILTER_GROUP_CODE code,FILTER_GROUP_DESC Description,APPLICATION_ID from XH_FILTER_GROUP WHERE filter_group_code IN ('ADTFIL','SIUFIL')";
	standstmt = con.createStatement();
	standrs = standstmt.executeQuery(qry);
%>
 
<select class='select' name='Filter_group_code_combo' id='Filter_group_code_combo' onChange="location.href='../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo='+this.value+'&Application_type_id=&Filter_group_code='+this.document.forms[0].Filter_group_code.value+'&Filter_group_desc='+this.document.forms[0].Filter_group_desc.value+'&Protocol_Link_id=';" style="width:200"> 
<option value='' >-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option> 
<%
defaultval="";
//code="";
 //code=request.getParameter("code");
defaultval=code;

//System.out.println("defaultval  code:"+code);

	while(standrs.next())
            {
              if ((standrs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
      %>
       <option value='<%=standrs.getString(1)%>'  selected ><%=standrs.getString(2)%></option> 
 <%             }
              else
              {%>
				  	<option value='<%=standrs.getString(1)%>'  ><%=standrs.getString(2)%></option> 
               <%
              } 
%>

            
		<% 	}  
	if(standrs!=null)standrs.close();
			if(standstmt!=null)standstmt.close();


}catch(Exception e1)
{
	System.out.println("(FilteringAndSchdulingLookupAdd.jsp:Exception-1):"+e1.toString());
}


			%>

            </select>
			<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td> 
<td class='fields'>
<select class='select' name='Application_type_id' id='Application_type_id' style="width:200" onChange="location.href='../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo=<%=code%>&Application_type_id='+this.value+'&Filter_group_code='+this.document.forms[0].Filter_group_code.value+'&Filter_group_desc='+this.document.forms[0].Filter_group_desc.value+'&Protocol_Link_id=';" >
            <option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
try
{
	
String qry = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW where IN_USE_YN='Y' and   LANGUAGE_ID='en' ";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
%>


<%
//application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
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
}
catch(Exception e)
{
	System.out.println("(FilteringAndSchdulingLookupAdd.jsp:Exception1) :"+e);
}
%> 
   </select>
   <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td class=label><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/><td>
<td class='fields'>
<select class='select' name='Protocol_Link_id' id='Protocol_Link_id' style="width:200">
<option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
try
{
	
String someqry = "SELECT PROTOCOL_LINK_ID, PROTOCOL_LINK_NAME  FROM xh_protocol_link where APPLICATION_ID=nvl('"+application_id+"',APPLICATION_ID)";


	protocolstmt = con.createStatement();
	protocolrs = protocolstmt.executeQuery(someqry);
 while(protocolrs.next())
            {
              if ((protocolrs.getString(1)+"").equalsIgnoreCase(procol_link))
              {
%>
                 <option value='<%=protocolrs.getString(1)%>'  selected ><%=protocolrs.getString(2)%></option>
 <%           }
			  else
			  {
           %>
                  <option value='<%=protocolrs.getString(1)%>'  ><%=protocolrs.getString(2)%></option>
		   <%
              }
  			 }

			if(protocolstmt!=null)
	{
				protocolstmt.close();
	}
if(protocolrs!=null)
	{
protocolrs.close();
	}
      }
catch(Exception e)
{
	System.out.println("(FilteringAndSchdulingLookupAdd.jsp:Exception-2) :"+e);
}
%>



</select>

 <%

 String somesql="SELECT distinct FACILITY_ID, MESSAGE_TYPE, EVENT_TYPE, PROTOCOL_LINK,"+ "TOTAL_LEVELS,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, MODIFIED_AT_WS_NO from XH_FILTER_GROUP where FILTER_GROUP_CODE='"+code+"' "; 
 segstmt = con.createStatement();
	segrs = segstmt.executeQuery(somesql);
	        while(segrs.next())
            {
				facility_id=segrs.getString(1); message_type=segrs.getString(2);event_type=segrs.getString(3);total_levels=segrs.getString(5);
			} 
 
 %>
<img src='../../eCommon/images/mandatory.gif' align=middle> </td> 


<input type="hidden" name="Facility__id" id="Facility__id" value="<%=facility_id%>"> 
<input type="hidden" name="Event__id" id="Event__id" value="<%=event_type%>">
<input type="hidden"   name ='Message__id' size='15' value='<%=message_type%>'  >
 
<input type="hidden" name=Total_level id=Total_level value='<%=total_levels%>'/>
<input type="hidden" name=version_no id=version_no value='<%=version_no%>'/>  
  <input type="hidden" name=code id=code value='<%=code_yn%>'/>

<input type="hidden" name=function_name id=function_name value='<%=function_name%>'/>
</tr>

<TR>
<td class=label><fmt:message key="eXH.UsrdefGroupCode.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<input type="text"  name='Filter_group_code' id='Filter_group_code' value='<%=newcode%>' maxlength=10 style="width:200" onKeyPress='return CheckForSpecCharsforID(event);return checklength(event,this);' onBlur='checkEmptyChar(this);'>
<img src='../../eCommon/images/mandatory.gif' align=middle>

</td>       

<td class=label><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type="text"  name='Filter_group_desc' id='Filter_group_desc' value='<%=newdesc%>' maxlength=30  style="width:200" >
<img src='../../eCommon/images/mandatory.gif' align=middle>
</td>       
	<td class='fields'></td>	
		<td class='fields'></td>
		<td class='fields'></td>	
	
</tr>
<!---<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
</tr>--->
</table>

<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  
<td colspan=4 align=right><input class='button' type="button"  name='Preview' id='Preview' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick='funRecord()'></td>

   </tr>
</table>
           

<%
		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
        if(segstmt!=null)segstmt.close();
        if(segrs!=null)segrs.close();
		ConnectionManager.returnConnection(con);
%>
<input type="hidden" name=actualmode id=actualmode value='I'/>

<input type="hidden" name=code id=code value='<%=code_yn%>'/>
<input type="hidden" name=version_no id=version_no value='<%=version_no%>'/>
<input type="hidden" name=function_name id=function_name value='<%=function_name%>'/>
</form>
<script>
function funRecord()
{

 

var fields = new Array (  document.forms[0].Filter_group_code_combo,
						document.forms[0].Application_type_id,document.forms[0].Protocol_Link_id,document.forms[0].Filter_group_code,document.forms[0].Filter_group_desc   
					   );


var names = new Array (getLabel("eXH.SysdefGroup.Label","XH"),
						getLabel("Common.Application.label","common"),getLabel("eXH.Gateway.Label","XH"),getLabel("eXH.UsrdefGroupCode.Label","XH"),getLabel("Common.description.label","common"));
if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
	{


	}
	else
	{
       document.forms[0].target='messageFrame';
       this.document.forms[0].submit();
       parent.frames[1].document.location.href='FileteringAndSchdulingLookupQueryResult.jsp?';
     parent.frames[2].document.location.href='../../eXH/jsp/FilteringAndSchdulingLookupAdd.jsp?Filter_group_code_combo=&Application_type_id=&Filter_group_code=&Filter_group_desc=&Protocol_Link_id=';
	}

}
 
</script>
</BODY>
</HTML> 

