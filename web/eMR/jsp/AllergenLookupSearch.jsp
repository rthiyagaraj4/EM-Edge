<!DOCTYPE html>
<!--Created by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");

	Connection conn = null;

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eMR/js/AllergenLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
	<script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;

		var fieldLegend = window.dialogArguments[8] ;
		if(fieldLegend == null) {
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = getLabel("Common.code.label","common")
		fieldLegend["DESC_LEGEND"] = getLabel("Common.description.label","common")
		}
    </script>

</head>
<%
try
{
	conn = ConnectionManager.getConnection(request);
%>
<body onKeyDown = 'lockKey()' onload='check_spcl_char()'>

<form name="CriteriaForm" id="CriteriaForm">
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
	
	<tr>
		<td>&nbsp;&nbsp;</td>
		<td class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_type" id="search_type">
        <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<%
			JSONArray GenericTypeJsonArr = new JSONArray();
			GenericTypeJsonArr = eMR.MRCommonBean.getGenericType(conn);

			for(int i = 0 ; i < GenericTypeJsonArr.size() ; i++) 
			{
				JSONObject GenericTypeJson	= (JSONObject)GenericTypeJsonArr.get(i);
				String generice_type = (String) GenericTypeJson.get("generice_type");
				
				if("Molecule".equals(generice_type))
				{
					out.println("<option value='"+generice_type+"' selected>"+generice_type+"</option>");	
				}else
				{
					out.println("<option value='"+generice_type+"'>"+generice_type+"</option>");	
				}
			}
		%>
        </select>
        </td>
	</tr>

    <tr>
        <td>&nbsp;&nbsp;</td> 
		<td class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="AllergenStoreVal(this)"><script>document.write(fieldLegend["CODE_LEGEND"])</script>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="AllergenStoreVal(this)" checked><script>document.write(fieldLegend["DESC_LEGEND"])</script></td>

		<td class="label"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
    </tr> 

    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_no_chars(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="75" >
        </td>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="Allrgnvalidatetext(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetAllergenForm(this.form)" class="button" >
        </td>
    </tr>

</table>

<br>

<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>

</form>

</body>

<script>
    initializeAllergenText();
</script>

<%
}catch(Exception e)
{
	//out.print(e.toString());
	e.printStackTrace();
}
finally   
{
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
}
%>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

</html>

