<!DOCTYPE html>
<HTML> 
<%@ page import ="java.util.*,eXH.XHDBAdapter,eXH.ArrayAuditInfo,eXH.XHTYPE,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>

<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String mode=request.getParameter("Mode");
String Short_desc=request.getParameter("Short_desc"); 
String long_desc=request.getParameter("Long_desc"); 
String version_specific=request.getParameter("Version_specific"); 
String Geography_Specific=request.getParameter("Geography_specific");
String Site_Specific=request.getParameter("Site_specific");
String Application_Specific=request.getParameter("Application_specific"); 
String version_desc=request.getParameter("Version_desc"); 
String Geography_desc=request.getParameter("Geography_desc"); 
String Site_desc=request.getParameter("Site_id"); 
String Application_desc=request.getParameter("Application_id"); 
String Profile_id=request.getParameter("Profile_id"); 
String params2="";

params2=(String)session.getAttribute("params");

//params=;
//System.out.println("params36"+params2);
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>


<script language="javascript" src="../../eXH/js/InterfaceStandardsProfile.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eXH/js/checkfield.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<script>

</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onLoad='hidevalue()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<form name="Interface_Profile_form" id="Interface_Profile_form" target='messageFrame' method='post'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<input type=hidden name=versionverify value='<%=version_specific%>'>
<input type=hidden name=Grodrphyverify value='<%=Geography_Specific%>'>
<input type=hidden name=Siteverify value='<%=Site_Specific%>'>
<input type=hidden name=Applicationverify value='<%=Application_Specific%>'>
<%
try
{

%>
<tr>
<td class=label ><fmt:message key="eXH.ProfileId.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name=profile_id1value size=20  value='<%=XHDBAdapter.checkNull(Profile_id)%>'><img src='../../eCommon/images/mandatory.gif' align=middle><input type="hidden" name=profile_id value='<%=XHDBAdapter.checkNull(Profile_id)%>'></td>
<td class=label ><fmt:message key="eXH.Short Description.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name=short_desc size=20 value='<%=XHDBAdapter.checkNull(Short_desc)%>'  > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
    <td class=label ><fmt:message key="eXH.Long Description.Label" bundle="${xh_labels}"/></td>
       <td align=left><input type=text name=Long_desc size=20 value='<%=XHDBAdapter.checkNull(long_desc)%>' ><img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
</tr>
<tr>
<td class=label>
<input type="checkbox" name="Version_Specific" id="Version_Specific"  OnClick='check();' > <fmt:message key="eXH.Version Specific.Label" bundle="${xh_labels}"/></td>
<td class=label><input type="checkbox" name="Geography_Specific" id="Geography_Specific"   OnClick='Geographycheck();' 
 > <fmt:message key="eXH.Geography specific.Label" bundle="${xh_labels}"/></td>
<td class=label><input type="checkbox" name="Site_Specific" id="Site_Specific"  OnClick='Sitecheck();'> <fmt:message key="eXH.Site specific.Label" bundle="${xh_labels}"/></td>
<td class=label><input type="checkbox" name="Application_Specific" id="Application_Specific" OnClick='Applicationcheck();'  > <fmt:message key="eXH.Application specific.Label" bundle="${xh_labels}"/></td>
<td>
</td>
<td>
</td>
</tr>
<tr>
<td align=left>
<input type='text' name='Version_Specific_txt' id='Version_Specific_txt' size='20' value='<%=XHDBAdapter.checkNull(version_desc)%>'  >
</td>	

<td align=left>
<input type='text' name='Geography_Specific_txt' id='Geography_Specific_txt' size='20' value='<%=XHDBAdapter.checkNull(Geography_desc)%>'  >
</td>

<td align=left>
<input type='text' name='Site_Specific_txt' id='Site_Specific_txt' size='20' value='<%=XHDBAdapter.checkNull(Site_desc)%>'  ></td>
<td align=left>
<input type='text' name='Application_Specific_txt1' id='Application_Specific_txt1' size='20' value='<%=XHDBAdapter.checkNull(Application_desc)%>'  >
<input style="background:navy; color:white;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name='TableSearch' id='TableSearch' value='?' onClick='searchApplication1();' disabled ><input type="hidden" name="application_id1" id="application_id1" value="<%=XHDBAdapter.checkNull(Application_desc)%>" ></td>
<td></td>
<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

<td></td>
<%

}
catch(Exception exp)
    {
       System.out.println("Error in InterfacestandardProfileAdd.jsp:"+exp.toString());
	   exp.printStackTrace(System.err);
    }
%>
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
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record()"><input class='button' type='button'  name='Delete' id='Delete' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' onClick="funDelete('D')" disabled><input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='funCancel()'></td>
</tr>
</table>
</form>
</BODY>
</HTML> 

