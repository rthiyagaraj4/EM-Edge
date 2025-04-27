<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function CheckForSpecChars(event){
    var strCheck = "&+%()|/\\><";
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (!(strCheck.indexOf(key) == -1)) 
		return false;  // Not a valid key
	return true ;
}

function CheckSpecCh(event){
	var strCheck = '%<>&';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if (!(strCheck.indexOf(key) == -1))
	   return false;  
	return true ;
}
</script>
<%    
	request.setCharacterEncoding("UTF-8");
    Connection con1 = null;
	Connection con = null;
    PreparedStatement pstmt1 = null ;
	PreparedStatement pstmt = null ;
    ResultSet rs1 = null ;
	ResultSet rs = null ;
	ResultSet rs2 = null ;
    //String sql = "";
	String sizel="";
	//String YN = "";
	String language_direction="";
	int count=0;

        try
        {
			con = ConnectionManager.getConnection(request);
            pstmt =con.prepareStatement(" select NAME_PREFIX_LENGTH, PAT_NAME_AS_MULTIPART_YN from mp_param where  module_id = 'MP'" ) ;
            rs = pstmt.executeQuery() ;
			
           /* if(rs!=null)
            { 
				if(rs.next())
				{ 
					YN = rs.getString("PAT_NAME_AS_MULTIPART_YN");
					if(YN == null || YN.equals("null")) YN = "";
				}
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


		}catch(Exception e) { 
			//out.println("TP"+e.toString());
			e.printStackTrace();
			}
        finally
        {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if(con!=null) ConnectionManager.returnConnection(con,request);
        }

%>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onKeyPress='if(event.keyCode == 13) return false;' OnLoad="Focusing('name_prefix')">
<form name="nameprefix_form" id="nameprefix_form" action="../../servlet/eMP.NamePrefixServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="85%" align='center'>

  <tr>
    <td width='35%'>&nbsp;</td>
    <td width='65%' colspan='2'>&nbsp;</td>
  </tr>

    <tr>
      <td width="35%" class="label"><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></td>
      <td width="65%" colspan="2" class="fields"><input type="text" name="name_prefix" id="name_prefix" size=<%=sizel%> maxlength=<%=sizel%> onBlur="makeValidString(this);" onkeypress="return CheckForSpecChars(event);" ><img src='../images/mandatory.gif'></img>
      </td>
    </tr>	
  
    <%
        try
        {
			con1 = ConnectionManager.getConnection(request);
            pstmt1 =con1.prepareStatement(" select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP'" ) ;
            rs1 = pstmt1.executeQuery() ;

            if(rs1!=null)
            {
                if(rs1.next())
                {
                    out.println ("<tr>") ;
                        out.println ( "<td class='label' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NamePrefixinOtherLanguage.label","mp_labels")+"</td>" ) ;
                        out.println ( "<td class='fields'><input type='text' name='prefix_in_oth_lang' id='prefix_in_oth_lang' value=\"\" size="+sizel+" maxlength="+sizel+" onblur='makeValidString(this);' onKeypress='return CheckSpecCh(event);' ");
						
						if(language_direction.equals("R"))
						{
						out.println("dir='RTL'" ) ;
						}
						
						out.println(" ></td>" ) ;
                  
					out.println ("</tr>") ;

                }
            }
        }catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace();
			}
        finally
        {
            if (rs1 != null) rs1.close();
            if (pstmt1 != null) pstmt1.close();
            if(con1!=null) ConnectionManager.returnConnection(con1,request);
        }
    %>
    <tr>
      <td width="35%" class="label"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
      <td width="65%" colspan="2" class='fields'><select name="prefix_sex" id="prefix_sex">
      <OPTION VALUE="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/>
      <OPTION VALUE="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/>
      <!-- Started by Afruddin for ML-MMOH-CRF-1520 US0001 -->
      <OPTION VALUE="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
      <OPTION VALUE="B"><fmt:message key="Common.all.label" bundle="${common_labels}"/> 
      <!-- Ended by Afruddin for ML-MMOH-CRF-1520 US0001 -->
      </select><img src="../images/mandatory.gif"></img></td>
    </tr>

     <!--tr>
      <td width="40%" class="label" >Effective From </td>
      <td width="13%" >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
      <!--td width="47%" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--/td-->
    <!--/tr-->

     <!--tr>
        <td width='40%'>&nbsp;</td>
        <td width='60%' colspan='2'>&nbsp;</td>
  </tr-->

    <tr>
    <td width="35%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td width="65%" class='fields' colspan="2"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td></tr>

   <tr>
        <td width='35%'>&nbsp;</td>
        <td width='65%' colspan='2'>&nbsp;</td>
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

