<!DOCTYPE html>
<HTML> 
<%@ page import ="java.util.*,eXH.XHDBAdapter,eXH.ArrayAuditInfo,eXH.XHTYPE,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
// String selected = "selected";
//String defaultval = "";
%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/InterfaceStandards.js" ></script> 
<script language="javascript" src="../../eXH/js/InterfaceStandards2.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" > 
/*
//function onSelectDataGroup
function onSelectDataGroup(obj)
{
	document.forms[0].action="../../eXH/jsp/.jsp?message_type="+obj.value;
	document.forms[0].submit();
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
*/



/*function hide() 
{
	alert("varuthu1");
	document.Interface_Profile_form.Geography_Specific_txt.style.display='none';
//document.Interface_Profile_form.Version_Specific_txt.style.visibility = 'hidden'; 
//document.Interface_Profile_form.Geography_Specific_txt.style.visibility = 'hidden'; 
//document.Interface_Profile_form.Application_Specific_txt.style.visibility = 'hidden'; 
//document.Interface_Profile_form.Site_Specific_txt.style.visibility = 'hidden'; 
alert("varuthu2");
}*/
function Geographycheck()
{
if(this.document.forms[0].Geography_Specific.checked==true)
{
		document.Interface_Profile_form.Geography_Specific_txt.disabled=false;
//document.forms[0].Geography_Specific_txt.style.visibility='';
}
else
	{
		document.Interface_Profile_form.Geography_Specific_txt.disabled=true;
//	document.forms[0].Geography_Specific_txt.style.visibility='hidden';
	}


}
/*function Geographycheck()
{
if(this.document.forms[0].Geography_Specific.checked==true)
{
document.forms[0].Geography_specific_txt.style.visibility='';
}
else
	{
	document.forms[0].Geography_specific_txt.style.visibility='hidden';
	}
}*/

function record(Mode)
{

var act="../../servlet/eXH.InterfaceStandaredProfileServlet?Profile_Id="+document.forms[0].Profile_Id.value+"&standard_code="+parent.parent.frames[1].document.forms[0].standard_code.value;

this.document.forms[0].action=act;

this.document.forms[0].act_mode.value =Mode;

//this.document.forms[0].standard_code.value= Standard_code;

this.document.forms[0].target="messageFrame";
this.document.forms[0].submit();
}
function funSearch()
{


parent.parent.frames[3].document.location.href="../../eXH/jsp/InterfacestandardprofileSearch.jsp";

}


function Applicationcheck()
{
if(this.document.forms[0].Application_Specific.checked==true)
{
	document.Interface_Profile_form.Application_Specific_txt.disabled=false;
	document.Interface_Profile_form.TableSearch.style.disabled=false;
//document.forms[0].Application_Specific_txt.style.visibility='';
}
else
	{
	document.Interface_Profile_form.Application_Specific_txt.disabled=true;
	document.Interface_Profile_form.TableSearch.disabled=false;
	//document.forms[0].Application_Specific_txt.style.visibility='hidden';
	}
}
//style="display:none;"

function Send()
{


}
function check()
{
	
if(this.document.forms[0].Version_Specific.checked==true)
{
document.forms[0].Version_Specific_txt.disabled=false;
}
else
	{
	document.forms[0].Version_Specific_txt.disabled=true;
	}


}
function Sitecheck()
{
if(this.document.forms[0].Site_Specific.checked==true)
{
	document.Interface_Profile_form.Site_Specific_txt.disabled=false;
//document.forms[0].Site_Specific_txt.style.visibility='';
}
else
	{
	document.Interface_Profile_form.Site_Specific_txt.disabled=true;
	//document.forms[0].Site_Specific_txt.style.visibility='hidden';
	}


}
</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>


<script language="JavaScript" >
function hidevalue()
{
	
document.Interface_Profile_form.Profile_Id.disabled=true;
document.Interface_Profile_form.standard_code.disabled=true;

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
XHSelectQuery xhSelect = null;
ArrayList arrRow = null,arrCol = null;
HashMap hashmpParams = null;
/*
String application_id=""; 
String facility_id=""; 
String mesg_type_id=""; 
String event_type_id=""; 
String segment_type_id="";
String protocol_link_id="";
String VersionCheck="";
*/
String standard_code="";
/*
String Pr="";
String standard_type="";
String msg_start="";
String msg_end="";
String seg_start="";
String seg_end="";
String fld_separator="";
String elmnt_separator="";
String Version="";
String Geography="";
String application_name=""; 
String facility_name=""; 
String mesg_type=""; 
String event_type=""; 
String segment_type="";
String protocol_linkName="";
String Site="";
String geographycheck="";
*/
int size = 0;
//String sql_xh_Application_select = "";
//String mode			=	request.getParameter("mode");

standard_code=request.getParameter("standard_code"); 

if(standard_code=="" || standard_code==null)
{

//System.out.println("alert('XH:00001 give the  code ');");
}
else
{
String sql="select * from XH_STANDARD_PROFILE where STANDARD_CODE='"+standard_code.toString().toUpperCase()+"'";
//System.out.println("sql"+sql);
try
{
con=ConnectionManager.getConnection(request);
xhSelect = new XHSelectQuery();
hashmpParams = new HashMap(5);
hashmpParams.put("connection",con);
hashmpParams.put("sql",sql);
hashmpParams.put("col","18");
arrRow = xhSelect.getResults(hashmpParams);
arrCol = null;	
xhSelect = null;
hashmpParams.clear();

size = arrRow.size();
}catch(Exception exp)
    {
       System.out.println("Error in  InterfaceStandardProfileStructure.jsp:"+exp.toString());
	   exp.printStackTrace(System.err);
    }
%>
<%
// boolean boolToggle =  true;	
// String strTDClass = "";
if(arrRow.size()<=0)
	{


/*if(mode.equals("U"))
{
	standard_desc=request.getParameter("standard_desc");
	standard_type=request.getParameter("standard_type");
	msg_start=request.getParameter("msg_start");
	msg_end=request.getParameter("msg_end");
	seg_start=request.getParameter("seg_start");
	seg_end=request.getParameter("seg_end");
	fld_separator=request.getParameter("fld_separator");
	elmnt_separator=request.getParameter("elmnt_separator");

//	defaultval=request.getParameter("dg_code");
//	System.out.println("dafaultval : "+defaultval);
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	protocol_linkName=request.getParameter("protocol_linkName");
	//language_id=request.getParameter("lang_id");
}
standard_code=request.getParameter("standard_code");
application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
mesg_type_id		=	request.getParameter("mesg_type_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");
protocol_link_id	=	request.getParameter("protocol_link_id");*/
//title='Standard Code' <%=mode.equals("U")?"readonly":""

%>

<form name="Interface_Profile_form" id="Interface_Profile_form" target='messageFrame' onload='hidevalue()' method='post'>
<table cellspacing=0 cellpadding=3 width='102%' align=center>
<tr>
	<td class=label ><fmt:message key="eXH.ProfileId.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=Profile_Id size=15 value=''    > 
	
	</td>
	<td class=label ><fmt:message key="eXH.Short Description.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=short_desc size=15 value=''  > </td>
<td class=label ><fmt:message key="eXH.Long Description.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name=Long_desc size=15 value='' >
</td>
</tr>
<tr>
<td class=label > <fmt:message key="eXH.Version Specific.Label" bundle="${xh_labels}"/></td><td align=left>
<input type=text name=Version_Specific_txt size=15 value=''  >
</td>	
<td class=label> <fmt:message key="eXH.Geography specific.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text name=Geography_Specific_txt size=15 value='' >
</td>
<td class=label> <fmt:message key="eXH.Site specific.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text name=Site_Specific_txt size=15 value='' ></td>
</tr>
<tr><td class=label> <fmt:message key="eXH.Application specific.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type=text name=Application_Specific_txt1 size=15 value='' ><input style="background:navy; color:white;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=TableSearch value='?' onClick='searchApplication1();' ><input type="hidden" name="application_id1" id="application_id1" value="null"></td><td></td>
<td></td><td></td>
<td></td>

</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="eXH.Record.Label" bundle="${xh_labels}"/>' onClick="record('I')"><input class='button' type='button'  name='Search' id='Search' value='<fmt:message key="eXH.Search.Label" bundle="${xh_labels}"/>' onClick='funSearch()'></td>
</tr

</table>
 

<%}else {
	

%>
<input type="hidden" name="standard_code" id="standard_code" value='<%=standard_code%>'>
<script>
parent.frames[1].document.location.href="../../eXH/jsp/InterfaceStandardElseProfileStructure.jsp?standard_code="+parent.parent.frames[1].document.forms[0].standard_code.value; 
	</script>

<%
}









}%>



	
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='U'>

</form>
</BODY>
</HTML> 

