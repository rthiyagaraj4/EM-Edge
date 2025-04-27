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

var act="../../servlet/eXH.InterfaceStandaredProfileServlet?Profile_Id="+this.parent.parent.frames[1].document.forms[0].Profile_Id.value+"&standard_code="+parent.parent.frames[1].document.forms[0].standard_code.value;
this.document.forms[0].action=act;
this.document.forms[0].act_mode.value =Mode;
this.document.forms[0].standard_code.value= Standard_code;

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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

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
*/
String VersionCheck="";
String standard_code="";


String Version="";
	String Geography="";

// String facility_name=""; 
 

String Site="";
String geographycheck="";
int size = 0;

// String mode			=	request.getParameter("mode");

standard_code=request.getParameter("standard_code");



String sql="select * from XH_STANDARD_PROFILE where STANDARD_CODE='"+standard_code.toString().toUpperCase()+"'";

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
		System.out.println(" (InterfaceStandardElseProfileStructure.jsp:sql)"+sql);
       System.out.println("Error in InterfaceStandardElseProfileStructure.jsp:"+exp.toString());
	   exp.printStackTrace(System.err);
    }
%>
<%
	

for(int i=0;i<arrRow.size();i++)
{
 
	arrCol = (ArrayList)arrRow.get(i);
	
	Version=XHDBAdapter.checkNull((String)arrCol.get(5));
	Geography=XHDBAdapter.checkNull((String)arrCol.get(7));
    Site=XHDBAdapter.checkNull((String)arrCol.get(11));
VersionCheck=(String)arrCol.get(4);
geographycheck=(String)arrCol.get(6);
} 
%>
<form name="Interface_Profile_form1" id="Interface_Profile_form1" target='messageFrame'  method='post'>
<table cellspacing=0 cellpadding=3 width='102%' align=center>
<tr>
	<td width='20%'></td>
	<td width='35%'></td>
	<td width='15%'></td>
	<td width='30%'></td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.ProfileId.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=Profile_Id size=15 value='<%=arrCol.get(0)%>'  disabled  > 
	</td>
	<td class=label ><fmt:message key="eXH.Short Description.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=short_desc size=15 value='<%=arrCol.get(1)%>'  > </td>
<td class=label ><fmt:message key="eXH.Long Description.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name=Long_desc size=15 value='<%=arrCol.get(2)%>' >
</tr>
<tr>
<td class=label>
<input type="checkbox" name="Version_Specific" id="Version_Specific" value='<%=arrCol.get(4)%>' OnClick='check();' <%=(arrCol.get(4)+"").equals("Y")?"Checked":" "%>> <fmt:message key="eXH.Version Specific.Label" bundle="${xh_labels}"/></td>
<td class=label><input type="checkbox" name="Geography_Specific" id="Geography_Specific" value='<%=arrCol.get(6)%>' OnClick='Geographycheck();'<%=(arrCol.get(6)+"").equals("Y") ?"Checked":" "%>> <fmt:message key="eXH.Geography specific.Label" bundle="${xh_labels}"/></td>
<td class=label><input type="checkbox" name="Site_Specific" id="Site_Specific" value='<%=arrCol.get(10)%>' OnClick='Sitecheck();'<%=(arrCol.get(10)+"").equals("Y") ?"Checked":" "%>> <fmt:message key="eXH.Site specific.Label" bundle="${xh_labels}"/></td>

<td class=label><input type="checkbox" name="Application_Specific" id="Application_Specific" value='<%=arrCol.get(8)%>' OnClick='Applicationcheck();' <%=(arrCol.get(8)+"").equals("Y") ?"Checked":" "%>> <fmt:message key="eXH.Application specific.Label" bundle="${xh_labels}"/></td>
<td>
</td>
<td>
</td>
</tr>
<tr>
<td align=left>
<input type=text name=Version_Specific_txt size=20 value='<%=Version%>' disabled >
</td>
<td align=left>
<input type=text name=Geography_Specific_txt size=20 value='<%=Geography%>' disabled>
</td>
<td align=left>
<input type=text name=Site_Specific_txt size=20 value='<%=Site%>' disabled></td>

<td align=left>
<input type=text name=Application_Specific_txt size=20 value='<%=arrCol.get(9)%>' ><input style="background:navy; color:white;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=TableSearch value='?' onClick='searchApplication();' ><input type="hidden" name="application_id" id="application_id" value="null"></td>
<td>
</td>
<td>
</td>

</tr>
</table>

<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='U'>

</form>
</BODY>
</HTML> 





