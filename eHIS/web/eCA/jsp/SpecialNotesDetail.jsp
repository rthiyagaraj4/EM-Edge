<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
        <title><fmt:message key="eCA.TaskForResponosibilityRelationshipDetails.label" bundle="${ca_labels}"/></title>
       
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

        <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
        <script src="../../eCommon/js/common.js" language="javascript"></script>
        <script language='javascript' src='../js/SpecialNotes.js'></script>
    </head>
    <%
    Connection con            = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null, rs1 = null;
	int i = 0;
    String parentQuery = "select categ_id, note_class, categ_desc, note_type from ca_note_param_detail order by categ_desc ";
    String childQuery = "select note_type, note_type_desc from ca_note_type where event_class = ? and eff_status='E' order by note_type_desc";
    String note_class="", categ_desc="", rowclass="", categ_id = "", curr_note_type = "";
    %><br><br><br>
    <body onload="" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' class='content'>
        <form name="specialNotesForm" id="specialNotesForm">
            <table cellpadding="3" ' cellspacing='0' border='1' width='90%' align='center'>
                <tr>
                    <td class='columnheadercenter'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
                    <td class='columnheadercenter'><fmt:message key="Common.NoteDescription.label" bundle="${common_labels}"/></td>
                </tr>
                <%
                    try
                    {
                        con = ConnectionManager.getConnection();
                        pstmt = con.prepareStatement(parentQuery);
                        rs = pstmt.executeQuery();
                        while(rs.next())
                        {
                            if(i%2==0)
                                rowclass = "QRYEVEN";
                            else
                                rowclass = "QRYODD";
                            note_class = rs.getString("note_class");
                            categ_desc = rs.getString("categ_desc");
                            categ_id = rs.getString("categ_id");
                            curr_note_type = (rs.getString("note_type")==null?"":rs.getString("note_type"));
                            %>s
                            <tr >
                            <TD align = "center" class=<%=rowclass%>><%=categ_desc%></TD>
                            <td align = "center" class=<%=rowclass%> >
                            <%
								//if(pstmt!=null) 
								pstmt=null;
                                pstmt = con.prepareStatement(childQuery);
                                pstmt.setString(1,note_class);
                                rs1 = pstmt.executeQuery();
                                out.println("<select name=\"" + categ_id.trim() + "\" id=\"" + categ_id.trim() + "\">");
                                out.println("<option value = \"\" >-------------------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------------------------</option>");
                                while(rs1.next())
                                {
                                    String note_type = "", note_desc = "";
                                    note_type=rs1.getString("note_type").trim();
                                    note_desc = rs1.getString("note_type_desc");
                                    if(curr_note_type.equals(note_type))
                                        out.println("<option value=\"" + note_type.trim() + "\" selected>" + note_desc + "</option>");
                                    else
                                        out.println("<option value=\"" + note_type.trim() + "\" >" + note_desc + "</option>");
                                }
								if(rs1!=null) rs1.close();
								if(pstmt!=null) pstmt.close();

                                out.println("</select>");
                            %>
                            </td>
                            </tr>
                        <%
                            i++;
                        }
						 if(rs!=null) rs.close();
                        //if(rs1!=null) rs1.close();
						if(pstmt!=null) pstmt.close();

                    }
                    catch(SQLException sqle)
                    {
                        //out.println("Exception in creating a connection object " +sqle);//COMMON-ICN-0181
                        sqle.printStackTrace();//COMMON-ICN-0181
                    }
                    finally
                    {
                        if(con!=null) ConnectionManager.returnConnection(con,request);
                    }
                %>
            </table>
        </form>
    </body>

