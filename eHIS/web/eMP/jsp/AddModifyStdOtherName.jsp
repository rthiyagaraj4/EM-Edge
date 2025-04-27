<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper "  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
    <head>
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        <script language='javascript' src='../js/StdOtherName.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	<!-- ChangeInitCase() method is moved to StdOtherName.js -->
        <%
            Connection con = null;
            PreparedStatement pstmt = null ;
            PreparedStatement pstmt1 = null ;
            ResultSet rs = null ;
            ResultSet rs2 = null ;
            String mode= "insert" ; 
            String other_name = request.getParameter("other_name") ;  
            String other_lang_name = "";
            String eff_status = "";
            String chked = "checked" ;
            String rdonly ="" ;
			String effreadOnly = "";
			String language_direction="";
			int count=0;
        try
			{
            con = ConnectionManager.getConnection(request);

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


            if(other_name!=null)
            {
                try{
                    pstmt = con.prepareStatement( "select * from mp_std_other_name where other_name = ?" ) ;
					pstmt.setString(1,other_name);
                    rs = pstmt.executeQuery() ;
                    if(rs.next())
                    {
                        mode = "modify";
                        rdonly = "readonly" ;
                    
                        other_name = rs.getString("other_name") ; 
                        if(other_name == null) other_name="";
                        other_lang_name = rs.getString("other_name_loc_lang");
                        if(other_lang_name == null) other_lang_name="";
                        eff_status = rs.getString("eff_status");
						

                        if( eff_status.equals("D") )
						{
                            chked = "" ;
							effreadOnly = "readOnly";
						}
                    }
                }catch(Exception e) { 
					//out.println(e.toString());
					e.printStackTrace();
					}
                finally
                {
                    if (pstmt != null) pstmt.close();
                    if (rs != null) rs.close();
                }
            }           
            else
                other_name = "";
        %>
    </head>

    <body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onKeyPress='if(event.keyCode == 13) return false;' onLoad='FocusFirstElement()' >
        <form name='Oth_family_Name_Form' id='Oth_family_Name_Form' method='post' action='../../servlet/eMP.StdOtherNameServlet' target='messageFrame'>
            <table cellspacing=0 cellpadding=0 align='center' width='100%' height='100%'  border='0'>
                <tr>
                    <td height='100%' width='70%' align='middle' class='white'>
                        <table cellspacing=0 cellpadding=3 align='center' width='75%' border='0'>
                            <tr> 
                                <td colspan='2'>&nbsp;</td>
                            </tr>
                            <tr>
                                <td class="label"><fmt:message key="eMP.OtherName.label" bundle="${mp_labels}"/></td>
                                <td class='fields'><input type ='text' name='other_name' id='other_name' value="<%=other_name %>" maxlength='20' size='20' <%=rdonly%>  
								onBlur="ChangeInitCase(this)">&nbsp;<img src='../images/mandatory.gif'></img></td>
                            </tr>


                            <%
                                try
                                {
                                    pstmt =con.prepareStatement(" select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP'") ;
                                    rs = pstmt.executeQuery() ;

									
									

                                    if(rs!=null)
                                    {
                                        if(rs.next())
                                        {
                                            out.println ("<tr>") ;
                                                out.println ( "<td class='label' nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherNamOtherLang.label","mp_labels")+"</td>" ) ;
                                                out.println( "<td class='fields'><input type = 'text' name='oth_in_oth_lang' id='oth_in_oth_lang' value=\""+other_lang_name+"\"  maxlength='20' size='20'	"+
												" onblur='makeValidString(this)'"+effreadOnly+"");
												
												if(language_direction.equals("R"))
												{
												out.println("dir='RTL'" ) ;
												}
												out.println("></td>" ) ;
                                           
											out.println ("</tr>") ;

                                        }
                                    }
                                }catch(Exception e) { 
									//out.println(e.toString());
									e.printStackTrace();
									}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }                       
                            %>
                            
                            <tr>
                                <td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
                                <td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=chked%> >
                                </td>
                            </tr>

                            <tr> 
                                <td colspan='2'>&nbsp;</td>
                            </tr>
                            
                        </table>
                    </td>
                </tr>
            </table>
            <input type='hidden' name= 'function_name' value = '<%=mode%>'>
        </form>
    </body>
<%
    }catch(Exception e) {
							//out.println(e.toString());
							e.printStackTrace();
							}
    finally {
        if(con!=null) ConnectionManager.returnConnection(con,request);
    }
%>

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

