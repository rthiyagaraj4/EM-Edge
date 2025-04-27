<%
/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
11/09/2024	67020	    Gomathi Sivakumar		12/09/2024		Ramesh G		CA-MMS-DM-CRF-0260-US007/03-Section
14/10/2024	70699	    Gunasekar R		        15/09/2024	  Ashwini Ragupathi		ML-MMOH-CRF-1759
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		// added by Arvind @  08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/FlowSheetCompDetail.js'></script>
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
 <form name='FlowSheetCompCriteriafrm' id='FlowSheetCompCriteriafrm' >

 <table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
 <tr><th class='columnHeader'  colspan=4 align='left'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/> </th></tr>		
	
	<td class='label' ><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan=3>
	<select name="history_type" id="history_type" onChange=''> <!-- selectEventClass(this); -->
	<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
	<%
			//colspan=4
			sql = "select hist_rec_type, short_desc from cr_hist_rec_type where hist_rec_type not in('DIAG','CHIC','MHD') order by 2 "; //Added not in CHIC against 67020 //Added MHD for ML-MMOH-CRF-1759
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{

				hist_desc = rs.getString("short_desc");
				hist_code = rs.getString("hist_rec_type");
				out.println("<option value='"+hist_code+"'>"+hist_desc+"</option>");
			}
	%>
		</select><img src="../../eCommon/images/mandatory.gif"></img> 
		</td>
	
	    <!-- <td class="label" align="left" nowrap>Event Item</td>
		<td align="left">
			<input type="hidden" maxlength=15 size="15" name="event_item" id="event_item"><input type="text" maxlength=15 size="15" name="event_item1" id="event_item1" onBlur='checkItem(this)' ><input type="button" class="button" name="event_item_but" id="event_item_but" value="?" onClick="SearchEventItem();">
		</td> -->
		
	</tr>	
	
	 <tr>
	    
	    <td   class="label" ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td   class="fields" >
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick=""><fmt:message key="Common.code.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        </td>
		
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td   class="fields" ><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
               	
	</tr>
    <tr>
    <td class="label" ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
    <td class="fields"  colspan=2> 
    <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="25%" align="left" size="40" maxlength="70" >
    </td>
    <td class="label" align='right' >
	<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' Onclick='ShowDetails()'></input>
	</td>
	</tr>
				
 </table>
 <!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->


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

