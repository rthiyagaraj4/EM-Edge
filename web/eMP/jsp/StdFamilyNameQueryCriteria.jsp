<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../js/StdFamilyName.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

//ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//StringBuffer strbuff;

Connection con=null ;
ResultSet rs1=null;
ResultSet rs2=null;
PreparedStatement pstmt1=null;

String nameInOthLang="";
String language_direction="";
int count=0;

try 
{
    //con = (Connection) session.getValue( "connection" );
    con = ConnectionManager.getConnection(request);
    
    
  
        
    pstmt1 = con.prepareStatement("select names_in_oth_lang_yn from mp_param");
    rs1= pstmt1.executeQuery();
    //rs=stmt.executeQuery("select * from mr_section");

	if (rs1.next())
	{
		nameInOthLang=rs1.getString("names_in_oth_lang_yn");       
		//String patNoCtrl=rs.getString("MR_SECTION_CODE");
	}



			if(pstmt1 != null) pstmt1.close();
			if(rs2 != null) rs2.close();
			
			pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
			rs2 = pstmt1.executeQuery() ;
				 
			 if ( rs2 != null && rs2.next() ) 
			 {
			 count = rs2.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "R" ;
			}else
			{
				 language_direction = "L" ;
			}


/*	ArrayList finAr = new ArrayList();
	if(nameInOthLang.equals("Y"))
	{

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FamilyName.label","common_labels"));     // label
		firstItem.add("last_name"); //name of field
		firstItem.add("20");    // SIZE
		firstItem.add("20");    //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr


		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FamilyNameinOtherLanguage.label","mp_labels"));  // label
		secondItem.add("last_name_loc_lang");   //name of field
		secondItem.add("20");   // SIZE
		secondItem.add("20");   //LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr
		ArrayList thirdItem=new ArrayList();

		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		thirdItem.add("eff_status");   //name of field
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("4"); //LENGTH

		finAr.add(thirdItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];



		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FamilyName.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FamilyNameinOtherLanguage.label","mp_labels") ;


		orderByColVals[0] = "last_name";
		orderByColVals[1] = "last_name_loc_lang";

		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StandardFamilyName.label","mp_labels"),"../jsp/StdFamilyNameQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	}else{
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FamilyName.label","common_labels"));     // label
		firstItem.add("last_name"); //name of field
		firstItem.add("20");    // SIZE
		firstItem.add("20");    //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();

		secondItem.add("List");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		secondItem.add("eff_status");   //name of field
		secondItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		secondItem.add("4");    //LENGTH

		finAr.add(secondItem); //add to ArrayList obj finAr
		
		String orderByCols[] = new String[1];
		String orderByColVals[] = new String[1];


		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FamilyName.label","common_labels");
		orderByColVals[0] = "last_name";
		
		
		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StandardFamilyName.label","mp_labels"),"../jsp/StdFamilyNameQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	}
	out.println(strbuff.toString());  */
	
} catch (Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
	}
finally{
	if(rs1!=null) rs1.close();
	if(rs1!=null) rs2.close();
	if(pstmt1!=null) pstmt1.close();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

</head>
	<body  onLoad='focusObject()' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()';>
	<form name='query_form' id='query_form'  target='messageFrame'>

<table border=0 align='center' width="90%" cellpadding=2 cellspacing=0>

	<tr><th colspan='3' align=left><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th></tr>
	<tr>
				<TD colspan='3' align=left>&nbsp;</TD>
	</tr>
	<TR>
				<TD class="label" width='40%'><fmt:message key="Common.FamilyName.label" bundle="${common_labels}"/></td>
				<td class='fields' >
						<input type='text' name='last_name' id='last_name' size="20" maxLength="20" onBlur='makeValidQueryCriteria(this)'></TD>
				<TD colspan='1' align=left>&nbsp;</TD>
	</tr>

	<%

	if(nameInOthLang.equals("Y"))
	{ %>

	<TR>
				<TD class="label" ><fmt:message key="eMP.FamilyNameinOtherLanguage.label" bundle="${mp_labels}"/></td>
				<%
				out.println("<td class='fields' ><input type='text' name='last_name_loc_lang' id='last_name_loc_lang' size='20' maxLength='20' onBlur='makeValidQueryCriteria(this)'");
				
				if(language_direction.equals("R"))
				{
				out.println("dir='RTL'");
				}
		
				out.println("></TD>");
				%>
				<TD colspan='1' align=left>&nbsp;</TD>
	</tr>
	<% } %>

	<tr>

	<TD class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
				<td class='fields' >
						<SELECT name='eff_status' id='eff_status'  >
							<option value='B' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/> </option>
							<option value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
							<option value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/> </option>
							</SELECT></TD>
							<TD colspan='1' align=left>&nbsp;</TD>
	</tr>
</table>

<br><br>

	<table width='90%' align='center'>
		<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
		<tr><td   width='60%' >
		<p  title='Sort Order'>
				<table width='100%'>
							<td nowrap align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
							<td>&nbsp;</td>
							<td nowrap align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<tr>	<td nowrap width='45%'  align='center'>
									<select name='orderbycols' id='orderbycols' size='5' >
										<option value='last_name_loc_lang'><fmt:message key="eMP.FamilyNameinOtherLanguage.label" bundle="${mp_labels}"/></option>
										</select>
										</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>
								<td nowrap width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>
								<option value='last_name'><fmt:message key="Common.FamilyName.label" bundle="${common_labels}"/></option>
								</select>
								</td>
					</tr>
			 </table>
				</p>
				</td>
		</tr>
</table>
					<br>
					<table border='0' width='100%' align='center'>
						<tr><td nowrap width='100%' align='center' class='white'>
						<input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>'>
						</td></tr>
					</table>


</form>
</body>	
</html>

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

