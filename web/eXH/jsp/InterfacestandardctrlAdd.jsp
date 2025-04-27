<!DOCTYPE html>
<%@ page import = "java.util.*,java.net.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% 

//String segement=request.getParameter("segment_Id");
%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


String Segment_id=XHDBAdapter.checkNull(request.getParameter("Segment_id"));
//String Standard_code=XHDBAdapter.checkNull(request.getParameter("Standard_code"));
String Element_id=URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("Element_id")),"utf-8");
String Element_Seq=XHDBAdapter.checkNull(request.getParameter("Element_Seq"));
String Default_value=XHDBAdapter.checkNull(request.getParameter("Default_value"));
String element_name=URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("element_name")),"utf-8");
String Control_elementID=XHDBAdapter.checkNull(request.getParameter("control_elementId"));
String Control_elementname=XHDBAdapter.checkNull(request.getParameter("control_elementname"));

String Mode=XHDBAdapter.checkNull(request.getParameter("Mode")); 
//System.out.println("Control_elementID"+Control_elementID+"Segment_id"+Segment_id+"Element_id"+Element_id+"Element_Seq"+Element_Seq+"Default_value"+Default_value+"element_name"+element_name+"Mode"+Mode);
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/InterfaceStandards.js" ></script> 
<script language="javascript" src="../../eXH/js/InterfaceStandards4.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script language="JavaScript">


</script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='hide()'>
<form name="InterfaceStandard_CtrlStr" id="InterfaceStandard_CtrlStr" target='messageFrame' method='post' >
<table cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
<td class=label ><fmt:message key="Common.Element.label" bundle="${common_labels}"/></td>
<td align=left><input type=text id="element_name"  name =element_name onBlur="if(this.value!='')searchElement();else ele_val_id.value='' "value='<%=element_name%>' size=25><input type=text id="element_idvalue"  name =element_idvalue value='<%=Element_id%>' size=25> <!--<img src='../../eCommon/images/mandatory.gif' align=middle>---><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElemntSearch value='?'    onClick="searchElement()"><img src='../../eCommon/images/mandatory.gif' align=middle><input type="hidden" name="ele_val_id" id="ele_val_id" value="<%=Element_id%>"></td>
<td> </td><td> </td> 
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.ElementSEQ.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=element_seq id="element_seq" size=25 value='<%=Element_Seq%>' onKeyPress='return CheckForSpecCharsforID(event);' > <!--<img src='../../eCommon/images/mandatory.gif' align=middle>---></td>
	<td> </td> <td> </td>
</tr>
<!---<tr>
	<td class=label ><fmt:message key="eXH.CtrlElementId.Label" bundle="${xh_labels}"/></td>
	<td align=left>
	<input type=text name=element_control id="element_control"  value='<%=Control_elementname%>' size=25>
	<input type=text id="element_ctrlidvalue"  name =element_ctrlidvalue value='<%=Control_elementID%>' size=25>
	<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElemntSearch value='?' onClick="searchctrlElement()"><img src='../../eCommon/images/mandatory.gif' align=middle>
	<input type="hidden" name="element_controlID" id="element_controlID" value="<%=Control_elementID%>"></td>
	<td> </td> <td> </td>
</tr>---------->

<tr>
<td class=label ><fmt:message key="eXH.CtrlElementId.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="element_control"  name =element_control onBlur="if(this.value!='')searchctrlElement();else ele_val_id.value='' "value='<%=Control_elementname%>' size=25><input type=text id="element_ctrlidvalue"  name =element_ctrlidvalue value='<%=Control_elementID%>' size=25> <!--<img src='../../eCommon/images/mandatory.gif' align=middle>---><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElemntSearch value='?'    onClick="searchctrlElement()"><img src='../../eCommon/images/mandatory.gif' align=middle><input type="hidden" name="element_controlID" id="element_controlID" value="<%=Control_elementID%>"></td>
<td> </td><td> </td> 
</tr>
<tr>
<td class=label ><fmt:message key="eXH.DefaultVal.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="default_val"  name =def_val_id size=25 value='<%=Default_value%>' > <!---<input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=DefaultValSearch value='?'    onClick="searchDefaultVal()">
<input type="hidden" name="def_val_id" id="def_val_id" value="<%=Default_value%>"><!--<img src='../../eCommon/images/mandatory.gif' align=middle>---></td>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="record()">
<input class='button' type="button"  name=Delete value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>'   onClick="Deleterecord('D')" disabled>
<input class='button' type='button'  name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='funCancel()'></td><td></td> 
</tr>
<tr>
<td>
</td>
<td>
</td>


</tr>


<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='40%'></td>
</tr>
</table>
	


<input type="hidden" name="act_mode" id="act_mode" value='<%=Mode%>'>
<input type="hidden" name="standard_code" id="standard_code" >

<input type="hidden" name="segment_type_id" id="segment_type_id" value='<%=Segment_id%>' >
</form>
</BODY>
</HTML> 

