<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null ;
PreparedStatement pstmt1 = null ;
ResultSet rs = null ;
ResultSet rs2 = null ;
String name_suffix_length="";
String names_in_oth_lang_yn="";
String language_direction="";
int count=0;

 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src="../../eMP/js/NameSuffix.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onKeyPress='if(event.keyCode == 13) return false;' OnLoad="Focusing('name_suffix')">
<form name="namesuffix_form" id="namesuffix_form" action="../../servlet/eMP.NameSuffixServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>


<%
            try
            {
				con = ConnectionManager.getConnection(request);
                //pstmt =con.prepareStatement(" select name_suffix_length,'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP'") ;

				if(pstmt1 != null) pstmt1.close();
				if(rs2 != null) rs2.close();
				
				pstmt1 = con.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E'" );
				
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


                pstmt =con.prepareStatement(" select name_suffix_length,names_in_oth_lang_yn from mp_param where module_id = 'MP'") ;
                rs = pstmt.executeQuery() ;
                if(rs!=null)
                {
                    if(rs.next())
                    {
					name_suffix_length=rs.getString("name_suffix_length");
					names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn");
					}
                }
            }catch(Exception e) { 
				out.println(e.toString());
				e.printStackTrace();
			}finally{
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if(con!=null) ConnectionManager.returnConnection(con,request);
            }
        %>
  <tr>
    <td width='40%'>&nbsp;</td>
    <td width='60%' colspan='2'>&nbsp;</td>
  </tr>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="name_suffix" id="name_suffix" size="<%=name_suffix_length%>"maxlength="<%=name_suffix_length%>" onBlur="makeValidString1(this);" onKeypress="return CheckForSpecChars(event);"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>
	<%if(names_in_oth_lang_yn.equals("Y")){ %>
	   <tr>
			<td class='label' nowrap><fmt:message key="eMP.NameSuffixinOtherLanguage.label" bundle="${mp_labels}"/></td>
			<!-- <td class='fields'><input type ='text' name='suffix_in_oth_lang' id='suffix_in_oth_lang' value="" size='<%=name_suffix_length%>' maxlength='<%=name_suffix_length%>'  onblur='makeValidString(this)' ></td> -->
			<%
			out.println("<td class='fields'><input type ='text' name='suffix_in_oth_lang' id='suffix_in_oth_lang' value='' size='"+name_suffix_length+"' maxlength='"+name_suffix_length+"'  onblur='makeValidString1(this);'onKeypress='return CheckSpecCh(event);'");
			if(language_direction.equals("R"))
				{
				out.println("dir='RTL'");
				}
			
			out.println("></td>");


			%>
       </tr>
	   <%}%>
        
    <tr>
        <td width="40%" class="label"><fmt:message key="eMP.ForBaby.label" bundle="${mp_labels}"/></td>
        <td width="60%" class='fields' colspan="2"><input type="checkbox" name="baby_suffix_yn" id="baby_suffix_yn" value="Y" checked></td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><select name="baby_sex" id="baby_sex">
      <OPTION VALUE="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/>
      <OPTION VALUE="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/>
      <OPTION VALUE="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>

      </select></td>
    </tr>

    <!--tr>
          <td width="40%" class="label" >Effective From</td>
          <td width="13%" >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
          <!--td width="47%" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;--> <input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--/td-->

    <!--/tr-->


  <!--tr>
    <td width='40%'>&nbsp;</td>
    <td width='60%' colspan='2'>&nbsp;</td>
  </tr-->

    <tr>
    <td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td width="60%" class='fields' colspan="2"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td></tr>


  <tr>
    <td width='40%'>&nbsp;</td>
    <td width='60%' colspan='2'>&nbsp;</td>
  </tr>

  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>
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

