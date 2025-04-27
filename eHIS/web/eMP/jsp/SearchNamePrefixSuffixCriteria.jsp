<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	int length_prefix = 0;
	String name_prefix = "";
	String other_lang = "";
	Connection con = null;	
	Statement stmt	= null;
	ResultSet rset	= null ;
	String sql = "Select  NAMES_IN_OTH_LANG_YN,PAT_NAME_AS_MULTIPART_YN from mp_param";
	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(sql);
	     rset = stmt.executeQuery(sql);
	     if( rset != null )
	     {
	         while( rset.next())
	         {
				 name_prefix = rset.getString("PAT_NAME_AS_MULTIPART_YN") ;
				 other_lang = rset.getString("NAMES_IN_OTH_LANG_YN") ;
			 }
		 }
		 if (name_prefix.equals("Y")){
			 length_prefix = 8;
		}else{
			length_prefix = 40;
		}
	String titles = request.getParameter("titles");

	String prompt		= "";
	String prompt_local	= "";

	if(titles.equals("Prefix"))
	{
		prompt		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NamePrefix.label","common_labels");
		prompt_local= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NamePrefixinOtherLanguage.label","mp_labels");
	}

	if(titles.equals("Suffix"))
	{
		prompt		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NameSuffix.label","common_labels");
		prompt_local= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels");
	}

%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script Language="JavaScript" src="../js/NamePrefix.js"></script>

</head>
<body onKeyDown = 'lockKey()'>
    <form name='Search_Name_Prefix_Suffix_form' id='Search_Name_Prefix_Suffix_form' target='messageFrame'>
    <br>
    <table align='center' border='0' cellspacing='0' cellpadding='3' width='98%'>        
        <tr>
            <td width='20%'>&nbsp;</td>
            <td width='20%'>&nbsp;</td>
            <td width='30%'>&nbsp;</td>
            <td width='30%'>&nbsp;</td>
        </tr>
        <tr>
            <td class="label" ><%=prompt%></td>
            <td class='fields'><input type='text' name='name_prefix_suffix' id='name_prefix_suffix' size="<%=length_prefix%>" maxlength="<%=length_prefix%>" align="left">       
            </td>
            <td class="label" id="td2" style="display:none"><%=prompt_local%></td>
			<td colspan="2" id ="td3"></td>
            <td id="td1" style="display:none" class='fields'><input type='text' name='name_prefix_suffix_loc_lang' id='name_prefix_suffix_loc_lang' size="8" maxlength="8"  style="text-align:right"  onFocus='loadArabic()' onBlur = 'loadEnglish()'> </td>
        </tr>
        <tr>
            <td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
            <td class='fields'>
                <select name='criteria' id='criteria'>
                    <option value='N'  selected><fmt:message key="eMP.ByName.label" bundle="${mp_labels}"/></option>
                    <option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
                    <option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
                    <option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>                 
                </select>
            </td>
            <td>
                &nbsp;
            </td>
            <td class='button'><input type='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='search' class='Button' onClick="callsearch('<%=titles%>')"><input type='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name='Close' class='Button' onClick='callclose()' >&nbsp;
            </td>
        </tr>
        <tr>
            <td colspan=4>&nbsp;</td>   
        </tr>
    </table>
	<%
		if(other_lang.equals("N"))
		{
	%>
	<script language="javascript">
		callfunc();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
	<%		
		}
	}
    catch(Exception e){out.println("tst "+e);}
    finally
    {
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
        if(con!=null) ConnectionManager.returnConnection(con,request);
    }
	 %>
    </form>    
</body> 
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

