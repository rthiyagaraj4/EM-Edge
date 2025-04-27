<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*
 " %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../../eMP/js/NameSuffix.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()'  onKeyDown = 'lockKey()'>

<% 
request.setCharacterEncoding("UTF-8");
String name_suffix = request.getParameter("name_suffix");
String language_direction = request.getParameter("language_direction");
Connection conn = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rset=null;
ResultSet rs1 =null;
String eff_date_from="",eff_date_to="";
String name_suffix_length="";
String names_in_oth_lang_yn="";
String effreadOnly = "";


try{
conn = ConnectionManager.getConnection(request);

String sql = "select name_suffix,baby_suffix_yn,baby_sex,name_suffix_loc_lang,eff_date_from,eff_date_to,eff_status from mp_name_suffix where name_suffix=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1,name_suffix);
rset = pstmt.executeQuery();
rset.next();
%>
<form name='namesuffix_form' id='namesuffix_form' action='../../servlet/eMP.NameSuffixServlet' method='post' target='messageFrame'>
	<BR><BR><BR><BR><BR><BR><BR><BR><BR>
	
<%            
                //sql = " select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP'" ;
                sql = "select name_suffix_length,names_in_oth_lang_yn from mp_param where module_id = 'MP'" ;
                
                try
                {
                    pstmt1 =conn.prepareStatement(sql) ;
                    rs1 = pstmt1.executeQuery() ;               
					String effStatus=rset.getString("eff_status");
					if (effStatus.equals("E")) effreadOnly = "";
					else	effreadOnly = "readOnly";

                    if(rs1!=null)
                    {
					if(rs1.next())
					{
					name_suffix_length=rs1.getString("name_suffix_length");
					names_in_oth_lang_yn= rs1.getString("names_in_oth_lang_yn");
					}
                    }
                }catch ( Exception e ){ 
					out.println(e.toString());
					e.printStackTrace();
				}finally{
					if ( rs1 != null ) rs1.close() ;
                    if ( pstmt1 != null ) pstmt1.close() ;                 
                }       
        %>

	<div align='left'>
	<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'> 
		<tr>
			<td width='50%'>&nbsp;</td>
			<td width='60%' colspan='2'>&nbsp;</td>
		</tr>
		<tr>
			<td width='40%' class='label'><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></td> 
			<td width='60%' class='fields' colspan='2'><input type='text' name='name_suffix' id='name_suffix' value="<%=rset.getString("name_suffix") %>" size='8'  readonly ><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
		<%if(names_in_oth_lang_yn.equals("Y")){%>
		<tr>
								<td class='label' nowrap><fmt:message key="eMP.NameSuffixinOtherLanguage.label" bundle="${mp_labels}"/></td>
								<!-- <td class='fields'><input type ='text' name='suffix_in_oth_lang' id='suffix_in_oth_lang' value='<%=					(rset.getString("name_suffix_loc_lang")==null?"&nbsp;":rset.getString("name_suffix_loc_lang"))%>'  maxlength='8' size='8'   onblur='makeValidString(this)' >
								</td>  -->
								<%
								String name_suffix_loc_lang=rset.getString("name_suffix_loc_lang")==null?"&nbsp;":rset.getString("name_suffix_loc_lang");
								out.println("<td class='fields'><input type ='text' name='suffix_in_oth_lang' id='suffix_in_oth_lang' value='"+name_suffix_loc_lang+"'  maxlength='"+name_suffix_length+"' size='"+name_suffix_length+"'   onblur='makeValidString(this)' onKeypress='return CheckSpecCh(event);' "+effreadOnly+" ");
								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
								
								out.println("></td> ");

								%>
							</tr>
<%}
/*if ( rset.getDate("eff_date_from") != null )
        {
         java.util.Date date = rset.getDate("eff_date_from");
         SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
         eff_date_from = formatter.format(date);
         date = null;
         formatter = null;
        }
        

if ( rset.getDate("eff_date_to") != null)
    {
     java.util.Date date1 = rset.getDate("eff_date_to");
     SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
     eff_date_to = formatter.format(date1);
     date1 = null;
     formatter = null;
    }*/

if ( rset.getString("eff_status").equals("E") )
{
%>
    <tr>
		<td width='40%' class='label'><fmt:message key="eMP.ForBaby.label" bundle="${mp_labels}"/></td> 
		<td width='60%' class='fields' colspan='2'><input type='checkbox' name='baby_suffix_yn' id='baby_suffix_yn' value='Y'

<%    if  ( rset.getString("baby_suffix_yn").equals("Y") )
            out.println("checked >");
        else
            out.println(">");

        //out.println("<img src='/eCIS/mp/images/mandatory.gif'></img>");
%>
	    </td>
	</tr>
	<tr>
		<td width='40%' class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><select name='baby_sex' id='baby_sex'>
<%    if (rset.getString("baby_sex").equals("M"))
        {
        out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"</Option>");

        }
    else if (rset.getString("baby_sex").equals("F"))
        {
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"</Option>");

        }
    else if (rset.getString("baby_sex").equals("B"))
        {
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");

        }%>


			</select>
		</td>
	</tr>
   
    <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%=eff_date_from%>'>

    <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%=eff_date_to%>'>

    <tr>
		<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
	String eff_status = rset.getString("eff_status");

    if  ( eff_status.equals("E") )
        out.println("checked >");
    else
        out.println(">");
%>
			</td>
		</tr>
		<tr>
			<td width='40%'>&nbsp;</td>
			<td width='60%' colspan='2'>&nbsp;</td>
		</tr> 
	</table>
	</div>
	<input type='hidden' name='function' id='function' value='modify'>
	<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
	<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	<input type='hidden' name='function_name' id='function_name' value='modify'>
</form>
<%
	}

if ( rset.getString("eff_status").equals("D") )
{


    out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ForBaby.label","mp_labels")+"</td> <td width='60%' class='fields' colspan='2'>");

        String baby_suffix_yn = rset.getString( "baby_suffix_yn" ) ;
        if ( baby_suffix_yn == null ) baby_suffix_yn = "N" ;

        out.println( "<input type='hidden' name='baby_suffix_yn' id='baby_suffix_yn' value='" + baby_suffix_yn + "'>" ) ;
        if  ( rset.getString("baby_suffix_yn").equals("Y") ) {
            out.println( "<input type='checkbox' name='baby_suffix_yn1' id='baby_suffix_yn1' value='Y' disabled checked>" ) ;
        } else {
            out.println( "<input type='checkbox' name='baby_suffix_yn1' id='baby_suffix_yn1' value='Y' disabled>" ) ;
        }

         //out.println("<img src='/eCIS/mp/images/mandatory.gif'></img>");


        out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</td><td width='60%' class='fields'  colspan='2'><input type='text' name='baby_sex1' id='baby_sex1' value='" );

        if (rset.getString("baby_sex").equals("M"))
            {

             out.println("Male' size='6' maxlength='6'  readonly >" );
             out.println("<input type='hidden' name='baby_sex' id='baby_sex' value='M'>");

            }
        else if (rset.getString("baby_sex").equals("F"))
            {
             out.println("Female' size='6' maxlength='6'  readonly >" );
             out.println("<input type='hidden' name='baby_sex' id='baby_sex' value='F'>");

            }
        else if (rset.getString("baby_sex").equals("B"))
            {
             out.println("Both' size='6' maxlength='6'  readonly >" );
             out.println("<input type='hidden' name='baby_sex' id='baby_sex' value='B'>");

            }%>


    </td></tr>
    
	<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%=eff_date_from%>' readonly>

    <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%=eff_date_to%>' readonly>

    <tr>
		<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
	String eff_status = rset.getString("eff_status");

    if  ( eff_status.equals("E") )
        out.println("checked >");
    else
        out.println(">");
%>
			</td>
		</tr>
		<tr>
			<td width='40%'>&nbsp;</td>
			<td width='60%' colspan='2'>&nbsp;</td>
		</tr>
	</table>
	</div>
	<input type='hidden' name='function' id='function' value='modify'>
	<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
	<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	<input type='hidden' name='function_name' id='function_name' value='modify'>
</form>

<%}
}catch ( Exception e ){
	out.println(e.toString());
	e.printStackTrace();
}
finally{
    if ( rset != null ) rset.close() ;
    if ( pstmt != null ) pstmt.close() ;
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
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

