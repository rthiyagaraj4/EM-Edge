<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

		<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<%
    Connection con = null;

    try
    {
		con = ConnectionManager.getConnection(request);
        PreparedStatement pstmt=null;
        ResultSet rset = null;
        String fm_install_yn = "N";
        String facility_id = (String) session.getValue("facility_id");
        String module_id = request.getParameter("module_id") ;
        if(module_id == null)   module_id = "" ;

        String gen_file_no = request.getParameter("gen_file_no");   
        if (gen_file_no==null) gen_file_no="";
        String prompt_for_old_file_no = request.getParameter("prompt_for_old_file_no");
        if (prompt_for_old_file_no==null) prompt_for_old_file_no="N";

        String dflt_fs_locn_code = "";
        String sel = "";
        int recCnt = 0;
        try
        {
            pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'FM'");
            rset = pstmt.executeQuery();
            if (rset.next())
                fm_install_yn = rset.getString(1);      
        }catch(Exception e){}
        finally
        {
            if (rset!=null) rset.close();
            if (pstmt!=null) pstmt.close();
        }

        try
        {
            if (fm_install_yn.equals("Y"))
            {
                if( module_id.equals("OP") || module_id.equals("AE") )
                {
                    if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement("select MR_LOCATION_CODE from op_clinic where facility_id = ? and clinic_code=?");
                    pstmt.setString(1, facility_id);
                    pstmt.setString(2, request.getParameter("clinic_code") );
                }
                else
                {
                    if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement("select dflt_fs_locn_code from fm_parameter where facility_id = ?");
                    pstmt.setString(1, facility_id);
                }
                rset = pstmt.executeQuery();
                if (rset.next())
                {
                    dflt_fs_locn_code = rset.getString(1);
                }
            
            }
        }catch(Exception e){/*out.println(e);*/}
        finally
        {
            if (rset!=null) rset.close();
            if (pstmt!=null) pstmt.close();
        }

        try
        {
            if (fm_install_yn.equals("Y"))
            {
                pstmt = con.prepareStatement("select count(1) from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y'");
                pstmt.setString(1, facility_id);
                rset = pstmt.executeQuery();
                if (rset.next())
                {
                    recCnt = rset.getInt(1);
                }
            }
        }catch(Exception e){}
        finally
        {
            if (rset!=null) rset.close();
            if (pstmt!=null) pstmt.close();
        }
    

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
    <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript'>
    
        top.onunload = new Function('doClose()')
        function doInit()   {
            document.getElementById('gen_file_no').value = window.dialogArguments;
            if(document.getElementById('old_file_no') !=null) document.getElementById('old_file_no').focus();
			document.getElementById('genfileno').innerHTML = "  "+document.getElementById('gen_file_no').value;
        }
        function doClose()  {
            retVal = ""
            if(document.getElementById('old_file_no'))    retVal = document.getElementById('old_file_no').value;
            if(document.getElementById("fs_locn_code"))    retVal +="`"+ document.getElementById("fs_locn_code").value
            else    retVal+="`"
            window.returnValue = retVal ;
            window.close();
        }
    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



    <title> <fmt:message key="eMP.MedicalRecordNumber.label" bundle="${mp_labels}"/></title>
</head>
<form name="oldFileNo" id="oldFileNo">
<body onload='doInit()' OnMouseDown="CodeArrest()" onKeyDown='lockKey();' style='background-color:#E2E3F0;'> 
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
    <tr>
    <td width='50%'>&nbsp;</td>
    <td width='50%'>&nbsp;</td>
    </tr>

    <tr>
    <td width='50%'>&nbsp;</td>
    <td width='50%'>&nbsp;</td>
    </tr>

    <tr>
    <td align='right' class='label' width='50%'><fmt:message key="eMP.GeneratedFileNo.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
    <h3><td id='genfileno' class='querydata' align='left' width='50%'>&nbsp;&nbsp;<input type='hidden' name='gen_file_no' id='gen_file_no' value= ""></input></td></h3>
    </tr>

     <%try{
            if (fm_install_yn.equals("Y"))
        {%>
	<tr><td colspan=2>&nbsp;</td></tr>
    <tr>
    <!--td>&nbsp; </td-->
        <%if(recCnt>1)
        {%>
        <td class="label" align="right" width="40%" nowrap><fmt:message key="eMP.FileStorageLocn.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
        <td width="60%" align="left" nowrap><select name='fs_locn_code' id='fs_locn_code'>        
        <%}%>
        <%
               pstmt = con.prepareStatement("select fs_locn_code,short_desc from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y' order by short_desc ");
                pstmt.setString(1, facility_id);
                rset=pstmt.executeQuery();
                String fs_locn_code = "" ;
                if( rset != null )
                {
                   while( rset.next() )
                    {
                        fs_locn_code = rset.getString( "fs_locn_code" ) ;
                        String shortdesc=rset.getString("short_desc");
                        if (fs_locn_code.equals(dflt_fs_locn_code)) sel = "selected";
                        else sel = "";
                        if(recCnt>1){
            %>
                            <OPTION VALUE='<%= fs_locn_code %>' <%=sel%> ><%= shortdesc %>
            <%          }
                        /*else if(recCnt==1)
                            out.println("<input type='hidden' name='fs_locn_code' id='fs_locn_code' value=\""+fs_locn_code+"\">") ;*/
                    }
              if(recCnt>1){
            %>
        </select>
        <img src='../images/mandatory.gif'></img></td>
        <%}
        else 
            out.println("<input type='hidden' name='fs_locn_code' id='fs_locn_code' value=\""+fs_locn_code+"\">") ;
        %>
    </tr>
            <%
                }
            }
            }catch(Exception e) { out.println(e.toString());}
            finally
            {
                if (pstmt != null) pstmt.close();
                if (rset != null) rset.close();
            }
    %>

    
    <%if( prompt_for_old_file_no.equals("Y")){%>
		<tr><td colspan=2>&nbsp;</td></tr>
        <tr>
        <td align="right" class="label" width="40%"><fmt:message key="eMP.OldFileNo.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
        <td align="left" width="60%"><input type='text' name="old_file_no" id="old_file_no" size="15" maxlength="15" value="" onKeyPress='return CheckForSpecChars(event)'></input></td>
        </tr>
    <%}%>
</table>
<br><br>
<center><input type='Button' class='Button' name='Ok' id='Ok' value='    <fmt:message key="Common.ok.label" bundle="${common_labels}"/>    ' onclick='doClose()'></center>
</body>
</form>
</html>
<%
    }catch(Exception e){}
    finally
    {
        if(con!=null) ConnectionManager.returnConnection(con,request);
    }
%>

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

