<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/** added by kishore kumar n on 08/12/2009  */
		String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
		{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}
		/** ends here*/
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ClinicEventMaster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql="";
	String hist_code="";
	String hist_desc="";
	try
	{
		con = ConnectionManager.getConnection();
%>
	</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
 <form name='clinicEventMasterSearchForm' id='clinicEventMasterSearchForm' >

 <table  align='center' cellpadding=3 cellspacing=0 border=0 width='90%'>
	
<tr>
	
	<td class='label' ><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></td>
	<td  colspan=3>
	<select name="hist_rec_type" id="hist_rec_type" onChange='load()'> 
	<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
	<%
			//colspan=4
			sql = "SELECT HIST_REC_TYPE,LONG_DESC  FROM cR_hist_rec_type  WHERE hist_rec_type in ('RXIN','DIET','LBIN','NCIN','PTCR','RDIN','SUNT','TRET') ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{

				hist_desc = rs.getString("LONG_DESC");
				hist_code = rs.getString("HIST_REC_TYPE");
				out.println("<option value='"+hist_code+"'>"+hist_desc+"</option>");
			}
	%>
		</select><img src="../../eCommon/images/mandatory.gif"></img> 
		</td>
	
	    		
	
	
	 <tr>
	    
	    <td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td   class='fields'>
        <input type="radio" name="search_by" id="search_by" class='fields' value="C" onclick=""><fmt:message key="Common.code.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class='fields' value="D" onclick="" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        </td>
		
		<td class="label"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td   class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
               	
	</tr>
		
    <tr>
    <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
    <td class='fields' colspan=2> 
    <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="30%" size="40" maxlength="70" ><img src="../../eCommon/images/mandatory.gif"></img> 
    </td>
    
	<td  align=right >
	<input type="button" class='button' name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" Onclick='loadFrames()'></input>
	</td>
	
 </table>
<!-- added by kishore kumar n on 08/12/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
		catch(Exception e)
		{
			//out.println("Exception in try :"+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
		}

		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}	
%>	 
 </form>
</body>
</html>

