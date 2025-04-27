<!DOCTYPE html>
<%--
/**
  *
  * @filename MaritalStatusQueryPage.jsp
  * @version 3.0 updated on 2/17/2005
  */
--%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.util.ArrayList,java.sql.PreparedStatement,java.sql.ResultSet" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>

<%
	request.setCharacterEncoding("UTF-8");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script language="javascript" src="../../eMP/js/NameSuffix.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function removeOrderByCol() 
{  
var j=0;
var from = document.getElementById('item')('orderbycolumns'); 
if ( from.options.length > 0 )
{
var to = document.getElementById('item')('orderbycols');
var element = document.createElement('OPTION');
element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);   
from.remove(from.selectedIndex);
if(from.options[j]) from.options[j].selected=true;
j++; 
} 
} 

function addOrderByCol()   
{     
var i=0; var from = document.getElementById('item')('orderbycols'); 
if ( from.options.length > 0 ) { 
	var to = document.getElementById('item')('orderbycolumns'); 
	var element = document.createElement('OPTION'); 
	element.text = from.options[from.selectedIndex].text; 
	element.value= from.options[from.selectedIndex].value; 
	to.add(element);      
	from.remove(from.selectedIndex);
	if(from.options[i])  from.options[i].selected=true ; 
	i++;
}
}

function execQuery()
{
	var name_suffix_loc_lang = "";
	var name_suffix=document.forms[0].name_suffix.value;
	if(document.forms[0].name_suffix_loc_lang!=null)
		name_suffix_loc_lang=document.forms[0].name_suffix_loc_lang.value;
	var enabled=document.forms[0].enabled.value;
	var baby_sex=document.forms[0].baby_sex.value;
	var baby_suffix_yn=document.forms[0].baby_suffix_yn.value;
	var language_direction=document.forms[0].language_direction.value;
	var orderbycolumns =document.forms[0].orderbycolumns.value;

if(document.getElementById("orderbycolumns").options.length >0 ){

parent.frames[1].location.href='../../eMP/jsp/queryNameSuffix.jsp?name_suffix='+encodeURIComponent(name_suffix)+'&name_suffix_loc_lang='+name_suffix_loc_lang+'&enabled='+enabled+'&baby_sex='+baby_sex+'&baby_suffix_yn='+baby_suffix_yn+'&language_direction='+language_direction;

}
else
	{
	alert(getMessage('ORDERBY_NOT_BLANK','Common'));
	}
}

function focusObject()
{
	document.forms[0].name_suffix.focus();
}

</script>

<%
//	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//	StringBuffer strbuff;
	Connection con=null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	ResultSet rs = null ;
	ResultSet rs2 = null ;
	String name_suffix_length="";
	String names_in_oth_lang_yn="";
	String language_direction="";
	int count=0;
	try {
	//	con = (Connection) session.getValue( "connection" );
		con = ConnectionManager.getConnection(request);
		pstmt =con.prepareStatement(" select name_suffix_length, names_in_oth_lang_yn from mp_param where  module_id = 'MP'" ) ;
        rs = pstmt.executeQuery() ;
		if(rs != null)
		{
			if(rs.next())
			{ 
			name_suffix_length=rs.getString("name_suffix_length");
			names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn");
			}
		}
		names_in_oth_lang_yn=checkForNull(names_in_oth_lang_yn);


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

	
		
/*		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NameSuffix.label","common_labels"));	  // label
		firstItem.add("name_suffix");	//name of field
		firstItem.add(name_suffix_length);	// SIZE
		firstItem.add(name_suffix_length);	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();

		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels"));  // label
		secondItem.add("name_suffix_loc_lang");   //name of field
		secondItem.add(name_suffix_length);	// SIZE
		secondItem.add(name_suffix_length);	//LENGTH
		
		if(names_in_oth_lang_yn.equals("Y"))
		{
		finAr.add(secondItem); //add to ArrayList obj finAr
		}

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels"));  // label
		fifthItem.add("baby_sex");//name
		fifthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(fifthItem); //add to ArrayList obj finAr
		

		ArrayList fourthItem=new ArrayList();

		fourthItem.add("List");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ForBaby.label","mp_labels"));  // label
		fourthItem.add("baby_suffix_yn");   //name of field
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("4");	//LENGTH

		finAr.add(fourthItem);





		ArrayList thirdItem=new ArrayList();

		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		thirdItem.add("enabled");   //name of field
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("4");	//LENGTH

		finAr.add(thirdItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NameSuffix.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels");

		orderByColVals[0] = "name_suffix";
		orderByColVals[1] = "name_suffix_loc_lang";

		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels"),"../jsp/queryNameSuffix.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());  */
	}catch (Exception e) {
		out.println(e.toString());
		e.printStackTrace();
	}finally{
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
				<TD class="label" width='40%'><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></td>
				<td class='fields' >
						<input type='text' name='name_suffix' id='name_suffix' size="<%=name_suffix_length%>" maxLength="<%=name_suffix_length%>" onBlur='makeValidString1(this)' onKeypress='return CheckForSpecChars(event);'></TD>
				<TD colspan='1' align=left>&nbsp;</TD>
	</tr>

	<%
	if(names_in_oth_lang_yn.equals("Y"))
		{ %>

	<TR>
				<TD class="label" ><fmt:message key="eMP.NameSuffixinOtherLanguage.label" bundle="${mp_labels}"/></td>
				<%
				out.println("<td class='fields' ><input type='text' name='name_suffix_loc_lang' id='name_suffix_loc_lang' size='"+name_suffix_length+"' maxLength='"+name_suffix_length+"' onBlur='makeValidString1(this);' onKeypress='return CheckForSpecChars(event);' ");

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

	<TD class="label" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td class='fields' >
						<SELECT name='baby_sex' id='baby_sex'  >
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value='B' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/> </option>
							<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
							<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/> </option>
							</SELECT></TD>
							<TD colspan='1' align=left>&nbsp;</TD>
	</tr>

	<tr>

	<TD class="label" ><fmt:message key="eMP.ForBaby.label" bundle="${mp_labels}"/></td>
				<td class='fields' >
						<SELECT name='baby_suffix_yn' id='baby_suffix_yn'  >
							<option value='B' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/> </option>
							<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
							<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/> </option>
							</SELECT></TD>
							<TD colspan='1' align=left>&nbsp;</TD>
	</tr>

	<tr>

	<TD class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
				<td class='fields' >
						<SELECT name='enabled' id='enabled'  >
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
		<tr><td nowrap  width='60%' >
		<p  title='Sort Order'>
				<table width='100%'>
							<td nowrap align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
							<td>&nbsp;</td>
							<td nowrap align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<tr>	<td nowrap width='45%'  align='center'>
									<select name='orderbycols' id='orderbycols' size='5' >
										<option value='name_suffix_loc_lang'><fmt:message key="eMP.NameSuffixinOtherLanguage.label" bundle="${mp_labels}"/></option>
										</select>
										</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>
								<td nowrap width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>
								<option value='name_suffix'><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></option>
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
			<input type="hidden" name="function_mode" id="function_mode" value="modify">
			<input type="hidden" name="language_direction" id="language_direction" value="<%=language_direction%>">
			
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

