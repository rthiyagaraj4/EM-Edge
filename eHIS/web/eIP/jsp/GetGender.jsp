
<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
    java.util.Hashtable hash = (java.util.Hashtable)obj.parseXMLString( request ) ;
    hash = (java.util.Hashtable)hash.get("SEARCH") ;
    String nursingunitcode      = (String)hash.get("nursing_unit_code");
	hash.clear();
    String facilityId           = (String) session.getValue("facility_id");
    Connection con              = null;
    PreparedStatement pstmt     = null;
    ResultSet rs                = null;
    String ID                   = "";

    try
    {
        con  =  ConnectionManager.getConnection(request);

        if (!(nursingunitcode == null || nursingunitcode.equals("")))
        { 
            pstmt=con.prepareStatement("select gender from am_age_group where age_group_code=(select age_group_code from ip_nursing_unit where facility_id = ? and nursing_unit_code=?)");
            pstmt.setString(1,facilityId);
            pstmt.setString(2,nursingunitcode);
            rs=pstmt.executeQuery();

            if(rs!=null)
            {   
                while(rs.next())
                {
                    ID  = rs.getString("gender");
                    if(ID == null) ID="";
                }
            }
            %>
<script>
            var gender = "<%=ID%>";
            if(gender == 'M')
            {
                document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = false;
                document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = true;
                document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = true;
                document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;
                
                //document.NursingUnitBkgLt_form.max_total_dly_booking.value = '';
                document.NursingUnitBkgLt_form.max_female_dly_booking.value = '';
                document.NursingUnitBkgLt_form.max_unknown_dly_booking.value = '';
                
            }
            else if(gender == 'F')
            {
                document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = false;
                document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = true;
                document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = true;
                document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;

                document.NursingUnitBkgLt_form.max_male_dly_booking.value = '';
                document.NursingUnitBkgLt_form.max_unknown_dly_booking.value = '';
                }
            else if(gender == 'U')
            {
                document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = true;
                document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = true;
                document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = false;
                document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;

                document.NursingUnitBkgLt_form.max_male_dly_booking.value = '';
                //document.NursingUnitBkgLt_form.max_total_dly_booking.value = '';
                document.NursingUnitBkgLt_form.max_unknown_dly_booking.value = '';
                }
                else 
                {
                    document.NursingUnitBkgLt_form.max_male_dly_booking.readOnly = false;
                    document.NursingUnitBkgLt_form.max_female_dly_booking.readOnly = false;
                    document.NursingUnitBkgLt_form.max_unknown_dly_booking.readOnly = false;
                    document.NursingUnitBkgLt_form.max_total_dly_booking.readOnly = true;

                    //document.NursingUnitBkgLt_form.max_male_dly_booking.value = '';
                    //document.NursingUnitBkgLt_form.max_female_dly_booking.value = '';
                }

                document.NursingUnitBkgLt_form.gender.value = gender;
</script>
            <%
        }

    }
    catch(Exception e)
    {
            out.print(e);
    }
    finally
    {
        if(pstmt != null)   pstmt.close();
        if(rs != null)  rs.close();
        ConnectionManager.returnConnection(con,request);

    }
%>
