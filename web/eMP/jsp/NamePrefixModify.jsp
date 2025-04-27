<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function CheckSpecCh(event){
	var strCheck = '%<>&';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if (!(strCheck.indexOf(key) == -1))
	   return false;  
	return true ;
}
</script>
	</head>

<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<% 
request.setCharacterEncoding("UTF-8");
String name_prefix = request.getParameter("name_prefix");
String language_direction = request.getParameter("language_direction");
Connection con = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt2=null;
PreparedStatement pstmt1 = null;
ResultSet rset=null;
ResultSet rs1 = null;
ResultSet rs = null;

String eff_date_from="",eff_date_to="";
String sizel="";

	try{
			con = ConnectionManager.getConnection(request);
            pstmt2 =con.prepareStatement(" select NAME_PREFIX_LENGTH,PAT_NAME_AS_MULTIPART_YN   from mp_param where  module_id = 'MP'" ) ;
            rs = pstmt2.executeQuery() ;

           /* if(rs!=null)
            {
				rs.next();
				String YN=rs.getString("PAT_NAME_AS_MULTIPART_YN");
                if( YN.equals("N"))
				{    sizel="40";
				}
				else if(YN.equals("Y"))
				{
					sizel="8";
				}
			}*/
			if(rs != null)
			{
				if(rs.next())
				{ 
				sizel=rs.getString("NAME_PREFIX_LENGTH");
				}
			}


	}catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace();
		}finally{
            if (rs != null) rs.close();
            if (pstmt2 != null) pstmt2.close();
        }

try{

String sql = "select name_prefix,prefix_sex, name_prefix_loc_lang, eff_date_from,eff_date_to,eff_status from mp_name_prefix where name_prefix=?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1,name_prefix);
rset = pstmt.executeQuery();
rset.next();
%>

<form name='nameprefix_form' id='nameprefix_form' action='../../servlet/eMP.NamePrefixServlet' method='post' target='messageFrame'>
	<BR><BR><BR><BR><BR><BR><BR><BR><BR>
	<div align='left'>
	<table border='0' cellpadding='3' cellspacing='0' width='85%' align='center'>
		<tr>
			<td width='35%'>&nbsp;</td>
			<td width='60%' colspan='2'>&nbsp;</td>
		</tr>
		<tr>
			<td width='35%' class='label'><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></td>
			<td width='60%' colspan='2' class='fields'><input type='text' name='name_prefix' id='name_prefix' value="<%= rset.getString("name_prefix")%>"  size='<%=sizel%>' readonly ><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
<%			sql = " select 'sss' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP'" ;
                
                try
                {
                    pstmt1 =con.prepareStatement(sql) ;
                    rs1 = pstmt1.executeQuery() ;  
					
					String effStatus=rset.getString("eff_status");
					String effreadOnly = "";
					if (effStatus.equals("E")) effreadOnly = "";
					else	effreadOnly = "readOnly";

                    if(rs1!=null)
                    {
                        if(rs1.next())
                        {
%>
					<tr>
						<td class='label' ><fmt:message key="eMP.NamePrefixinOtherLanguage.label" bundle="${mp_labels}"/></td>
				<!-- 		 <td class='fields'><input type='text' name='prefix_in_oth_lang' id='prefix_in_oth_lang' value='<%=
							(rset.getString("name_prefix_loc_lang") ==null ? "":rset.getString("name_prefix_loc_lang"))%>'  maxlength="<%=sizel%>" size="<%=sizel%>"  onblur='makeValidString(this)' <%=effreadOnly%>></td>  -->
					<%
					String name_prefix_loc_lang =  rset.getString("name_prefix_loc_lang") ==null ? "":rset.getString("name_prefix_loc_lang");
					out.println("<td class='fields'><input type='text' name='prefix_in_oth_lang' id='prefix_in_oth_lang' value=\""+name_prefix_loc_lang+"\"  maxlength='"+sizel+"' size='"+sizel+"'  onblur='makeValidString(this)' onKeypress='return CheckSpecCh(event);' "+effreadOnly+"");

					if(language_direction.equals("R"))
						{
						out.println("dir='RTL'" ) ;
						}
					
					out.println("></td>"); 
					%>
					</tr>
<%                      }
                    }
            }catch(Exception e) { 
				//out.println(e.toString());
				e.printStackTrace();
			}
            finally{
				if (rs1 != null) rs1.close();
                if (pstmt1 != null) pstmt1.close();                
            }

if ( rset.getString("eff_status").equals("E") )
{
    out.println("</td></tr><tr><td width='35%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+" </td><td width='60%' class='fields' colspan='2'><select name='prefix_sex' id='prefix_sex'>");

    if (rset.getString("prefix_sex").equals("M"))
        {
            out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
            out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
            out.println( "<OPTION VALUE="+"U"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>"); //Added by Afruddin for ML-MMOH-CRF-1520 US 0001
            out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</Option>");     //Modified by Afruddin for ML-MMOH-CRF-1520 US 0001

        }
    if (rset.getString("prefix_sex").equals("F"))
            {
                out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
                out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
                out.println( "<OPTION VALUE="+"U"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>"); //Added by Afruddin for ML-MMOH-CRF-1520 US 0001
                out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</Option>");     //Modified by Afruddin for ML-MMOH-CRF-1520 US 0001

            }

    if (rset.getString("prefix_sex").equals("B"))
        {
            out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</Option>"); //Modified by Afruddin for ML-MMOH-CRF-1520 US 0001
            out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
            out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
            out.println( "<OPTION VALUE="+"U"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>"); //Added by Afruddin for ML-MMOH-CRF-1520 US 0001

        }
  //Started by Afruddin for ML-MMOH-CRF-1520 US 0001
    if (rset.getString("prefix_sex").equals("U"))
    {
    	out.println( "<OPTION VALUE="+"U"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>");
    	out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</Option>");
        
        
    }
   //Ended by Afruddin for ML-MMOH-CRF-1520 US 0001
%>

			    </select><img src='../images/mandatory.gif'></img>
			</td>
		</tr>
   
	    <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%=eff_date_from%>'>
	    <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%=eff_date_to%>'>

	    <tr>
			<td width='35%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
	
<%    String eff_status = rset.getString("eff_status");

    if  ( eff_status.equals("E") )
        out.println("checked >");
    else
        out.println(">");
%>
		    </td>
		</tr>
		<tr>
			<td width='35%'>&nbsp;</td>
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
if ( rset.getString("eff_status").equals("D") ){
%>
			<tr>
				<td width='35%' class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/> </td>
				<td width='60%' class='fields' colspan='2'><input type='text' name='prefix_sex' id='prefix_sex' value='
<%        if (rset.getString("prefix_sex").equals("M"))
                out.println("Male' size='6' maxlength='7' readonly >" ) ; //Modified by Afruddin for ML-MMOH-CRF-1520 US 0001
	        if (rset.getString("prefix_sex").equals("F"))
                out.println("Female' size='6' maxlength='7' readonly >" ) ; //Modified by Afruddin for ML-MMOH-CRF-1520 US 0001
		    if (rset.getString("prefix_sex").equals("B"))
                out.println("All' size='6' maxlength='7' readonly >") ;   //Modified by Afruddin for ML-MMOH-CRF-1520 US 0001
		    if (rset.getString("prefix_sex").equals("U"))                //Added by Afruddin for ML-MMOH-CRF-1520 US 0001
                out.println("Unknown' size='6' maxlength='7' readonly >") ; //Added by Afruddin for ML-MMOH-CRF-1520 US 0001
%>
			    <img src="../images/mandatory.gif"></img>
			</td>
		</tr>
    
		<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'   value='<%=eff_date_from%>' readonly>

		<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'    value='<%=eff_date_to%>' readonly>

		<tr>
			<td width='35%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
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
			<td width='35%'>&nbsp;</td>
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
}catch ( Exception e ){ 
	//out.println(e.toString());
	e.printStackTrace();
}
finally{
    if ( rset != null ) rset.close() ;
    if ( pstmt != null ) pstmt.close() ;
    if(con!=null) ConnectionManager.returnConnection(con,request);
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

