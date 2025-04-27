<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
    <script src='../../eQA/js/QAIndicatorsForDiscipline.js' language='javascript' ></script>
	<script language='javascript' src='../../eOA/js/WaitlistCategoryForSplty.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 <body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onscroll='scrollTitle()'>
<form name='result_form' id='result_form' action="../../servlet/eOA.WaitlistCategoryForSplty" method="post" target=messageFrame>
<%
Connection con					=	null;
PreparedStatement pstmt			=	null;
ResultSet rset					=	null ;
String waitlist_category_code         =  "";
String class_value				= "QRYEVEN";
String selected                 ="";
int	   n						= 0;
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String speciality_code               ="";
String long_desc                      ="";

String sql                 =  "";
con					       =	ConnectionManager.getConnection(request);
	
waitlist_category_code	   =	checkForNull(request.getParameter("waitlist_category_code"));
//sql="SELECT A.SPECIALTY_CODE,B.LONG_DESC,B.SHORT_DESC, 'Y' Selected FROM OA_WL_CATEGORY_FOR_SPLTY A,AM_SPECIALITY B WHERE A.WAITLIST_CATEGORY_CODE ='"+waitlist_category_code+"' AND A.SPECIALTY_CODE = B.SPECIALITY_CODE union SELECT SPECIALITY_CODE, LONG_DESC,SHORT_DESC, 'N' Selected FROM AM_SPECIALITY WHERE EFF_STATUS = 'E' and SPECIALITY_CODE not in (select SPECIALTY_CODE from OA_WL_CATEGORY_FOR_SPLTY WHERE WAITLIST_CATEGORY_CODE ='"+waitlist_category_code+"') ORDER BY 2";
sql="SELECT A.SPECIALTY_CODE,B.LONG_DESC,B.SHORT_DESC, 'Y' Selected FROM OA_WL_CATEGORY_FOR_SPLTY A,AM_SPECIALITY B WHERE A.WAITLIST_CATEGORY_CODE =? AND A.SPECIALTY_CODE = B.SPECIALITY_CODE union SELECT SPECIALITY_CODE, LONG_DESC,SHORT_DESC, 'N' Selected FROM AM_SPECIALITY WHERE EFF_STATUS = 'E' and SPECIALITY_CODE not in (select SPECIALTY_CODE from OA_WL_CATEGORY_FOR_SPLTY WHERE WAITLIST_CATEGORY_CODE =? ) ORDER BY 2";

pstmt = con.prepareStatement(sql);
pstmt.setString(1,waitlist_category_code);
pstmt.setString(2,waitlist_category_code);
rset  = pstmt.executeQuery();
%>

<div id='header' style="visibility:visible;backgroundColor:white;">
<table border="1" cellpadding="0" cellspacing="0" align='center' width='85%'>
	 <td class='COLUMNHEADER' width='75%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	 <td class='COLUMNHEADER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</table></div>
	<table border="1" cellpadding="0" cellspacing="0" align='center' width='85%'>

	<%
	  	while(rset.next())
		{
			speciality_code   = checkForNull(rset.getString("SPECIALTY_CODE"));
			long_desc   = checkForNull(rset.getString("SHORT_DESC"));
			selected=checkForNull(rset.getString("Selected"));
			if(selected.equals("Y"))selected="checked";
	      	if(class_value.equals("QRYEVEN"))
			class_value = "QRYODD";
			else
			class_value = "QRYEVEN";
		  %>

			<tr>
	     	<td class="<%=class_value%>"  width='75%' nowrap >&nbsp;<%=long_desc%>&nbsp;</td>
			<td class="<%=class_value%>" nowrap align=center>
			<input type=checkbox   name='strKey<%=n%>' id='strKey<%=n%>'	<%=selected%> value ='<%=speciality_code%>' > </td>
            </tr>
		<%
		n++;
		
		}
		}catch(Exception e )
		{
		//out.println("Error"+e);
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}finally{
	 ConnectionManager.returnConnection(con,request);
}
		
		
		if(pstmt!=null) pstmt.close();
		 if(rset!=null)  rset.close();
%>
</table>

</div>


	

<input type='hidden' name='n' id='n' value=<%=n%>>
<input type='hidden' name='splty' id='splty' value=''>
<input type='hidden' name='final_val' id='final_val' value=''>

<input type='hidden' name='function' id='function' value="Insert">
<input type='hidden' name='insert_table' id='insert_table' value='Y'>
<input type='hidden' name='waitlist_category_code' id='waitlist_category_code' value=<%=waitlist_category_code%>>

</form>
</body>
</html>

<%!
	
	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}

%>

