<%@ page   contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
request.setCharacterEncoding("UTF-8"); 
String nursing_unit_code = request.getParameter("nursing_unit_code");
String bed_no=request.getParameter("bed_no");
String flag=request.getParameter("flag");
String submit_yn=request.getParameter("submit_yn");
String setup_bl_dtls_in_ip_yn=request.getParameter("setup_bl_dtls_in_ip_yn");
if( flag == null) flag="";
String Bedcode=request.getParameter("Bedcode");
String bedClasscode=request.getParameter("bed_code");
String foc_obj = request.getParameter("foc_obj");
if(foc_obj == null) foc_obj = "";
if(bedClasscode == null) bedClasscode="";
if(Bedcode == null) Bedcode="";
if (submit_yn==null) submit_yn="N";
if (setup_bl_dtls_in_ip_yn==null) setup_bl_dtls_in_ip_yn="N";

Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;

String facilityid	="";
String dly_charge	="";
String room_no		="";
StringBuffer sql	= new StringBuffer();
facilityid			=(String)session.getValue("facility_id");
try 
{
    con = ConnectionManager.getConnection(request);
    stmt = con.createStatement();
    if(!flag.equals("frombedchart"))
    {
		String bed_class_code="";
		if (setup_bl_dtls_in_ip_yn.equals("Y"))
		{
			sql.append(" Select a.bed_class_code, a.bed_type_code, a.room_no, b.dly_charge from IP_NURSING_UNIT_BED a, BL_IP_BED_TYPE b where facility_id='"+facilityid+"' and nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"' and b.bed_type_code=a.bed_type_code and a.bed_class_code='" +bedClasscode+"' ");
		}
		else
		{
			sql.append(" Select bed_class_code, bed_type_code, room_no from IP_NURSING_UNIT_BED where facility_id='"+facilityid+"' and nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"' and bed_class_code='"+bedClasscode+ "' ");
		}

        try {
            stmt=con.createStatement();
			rs = stmt.executeQuery(sql.toString());
            out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
            if(rs.next())
			{
				bed_class_code=rs.getString("bed_class_code");
				if (setup_bl_dtls_in_ip_yn.equals("Y"))
				{
					dly_charge=rs.getString("dly_charge");
				}
				else
				{
					dly_charge="0.00";
				}
				room_no = rs.getString("room_no");
				%>
				<script>
				parent.frames[1].document.forms[0].daily_rate.value="<%=dly_charge%>";
				parent.frames[1].document.forms[0].Bedcode.value="<%=bed_class_code%>";
				parent.frames[1].document.forms[0].room_no.value="<%=room_no%>";
				parent.frames[1].document.getElementById('roomno').innerText = parent.frames[1].document.forms[0].room_no.value;
					
					if ('<%=submit_yn%>'=='Y')
					{
						parent.frames[1].document.forms[0].submit();
					}
				</script>
				<%  
            }
			
            else
            {
            %>
                <script> 
                    var foc_obj = "<%=foc_obj%>"; 
					alert(parent.frames[1].getMessage("BED_CLASS_MISMATCH","IP"));
					if(foc_obj != '' && foc_obj != 'bed_no')
				{
					 eval('parent.frames[1].document.forms[0].'+foc_obj).focus();
					 parent.frames[1].document.forms[0].bed_no.value = '';
					 parent.frames[1].document.getElementById('roomno').innerText = '';
				}
                else
				{	
					parent.frames[1].document.forms[0].bed_no.focus();
					parent.frames[1].document.forms[0].bed_no.select(); 
				}
                </script>
            <%
            }
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

        } // end of try
        catch(Exception e)
        {
            out.println(e.toString());
        }
    }
    else
    {
		if(sql.length() > 0)
			sql.delete(0,sql.length());
						
			sql.append(" Select dly_charge from bl_ip_bed_type where bed_type_code='"+Bedcode+"' ");
        try 
        {	
			stmt=con.createStatement();
            rs = stmt.executeQuery(sql.toString());
            out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
            if(rs.next())
            {
            dly_charge=rs.getString("dly_charge");
            %>
				
                 <script>
                    var comp=parent.frames[1].document.forms[0].daily_rate.value="<%=dly_charge%>";
                </script>
            <% 
					}
				
            else 
            {
            %>
            <script> 
            </script>
            <%
            }
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

        } // end of try
        catch(Exception e1)
        {
            out.println(e1.toString());
        }
    }
}
catch(Exception e)
{
   out.println(e.toString());
}
finally
{
 if (stmt!=null) stmt.close();
    if (rs!=null) rs.close();
	if(con != null)
    ConnectionManager.returnConnection(con,request);
}
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

