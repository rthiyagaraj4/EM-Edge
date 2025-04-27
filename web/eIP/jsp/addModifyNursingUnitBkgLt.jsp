<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
    Connection con                  =   null;
    Statement stmt                  =   null;
    PreparedStatement pstmt         =   null;
    ResultSet rset                  =   null;
	Statement stmt_gender			=   null;
	ResultSet rs_gender				=   null;

	String facility_id = (String)session.getAttribute("facility_id");
    String nursing_unit_code=request.getParameter("nursing_unit_code");
    
	String max_male_dly_booking_readOnly="";
	String max_female_dly_booking_readOnly="";
	String max_unknown_dly_booking_readOnly="";
	String max_total_dly_booking_readOnly="";

	int i=0;        
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../js/NursingUnitBkgLt.js' language='javascript'></script>


<script language="JavaScript">
       
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='FocusFirstElement();first()' onunload='last()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=NursingUnitBkgLt_form>
<%
    String fnval    = "insert";
    String bedclassdesc     = "";
    String bedclasscode     = "";

    String eff_status="";
    String eff_status_checked="";
    String eff_status_disabled="";

    int maxmaledlybooking       ;
    int maxunknowndlybooking        ;
    int maxfemaledlybooking ;
    int maxtotaldlybooking      ;

    String maxm = "";
    String maxf = "";
    String maxu = "";
    String maxt = "0";

    int start=1;
    int end=0;
    int records_to_show=12;
    int total_count=0;

    String from = request.getParameter("from");
    String to = request.getParameter("to");
    try{
            con  =  ConnectionManager.getConnection(request);
			// Gender Changes
			String gender="";
            StringBuffer sql_gender = new StringBuffer();
			sql_gender.append(" select gender from am_age_group where age_group_code=(select age_group_code from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"') ");	
			stmt_gender=con.createStatement();
			rs_gender=stmt_gender.executeQuery(sql_gender.toString());
			if(rs_gender!=null)
			{
				while(rs_gender.next())
				{
					gender=rs_gender.getString(1);
					if(gender==null) gender="";
				}
				if(rs_gender!=null) rs_gender.close();
				if(stmt_gender!=null) stmt_gender.close();
			}
	if(gender.equals("M"))
            {
                max_male_dly_booking_readOnly = "";
                max_female_dly_booking_readOnly = "readonly";
                max_unknown_dly_booking_readOnly = "readonly";
                max_total_dly_booking_readOnly = "readonly";
            }
	else if(gender.equals("F"))
            {
                max_male_dly_booking_readOnly = "readonly";
                max_female_dly_booking_readOnly = "";
                max_unknown_dly_booking_readOnly = "readonly";
                max_total_dly_booking_readOnly = "readonly";
             }
	else if(gender.equals("U"))
            {
                max_male_dly_booking_readOnly = "readonly";
                max_female_dly_booking_readOnly = "readonly";
                max_unknown_dly_booking_readOnly = "";
                max_total_dly_booking_readOnly = "readonly";
             }
            else 
            {
                  max_male_dly_booking_readOnly = "";
                    max_female_dly_booking_readOnly = "";
                    max_unknown_dly_booking_readOnly = "";
                    max_total_dly_booking_readOnly = "readonly";
             }

            stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
            if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" select bed_class_code, bed_class_short_desc short_desc,");
			sql.append(" max_male_dly_booking, max_female_dly_booking, ");
			sql.append(" max_unknown_dly_booking, max_total_dly_booking, 'Y' ");
			sql.append(" from ip_book_limit_by_nurs_ut_vw where facility_id='"+facility_id+"' ");
			sql.append(" and nursing_unit_code='"+nursing_unit_code+"' ");
			sql.append(" union ");
			sql.append(" select bed_class_code,short_desc,0,0,0,0,'N' from  ");
			sql.append(" ip_bed_class where eff_status='E' and bed_class_code not in ");
			sql.append(" (select bed_class_code from ip_book_limit_by_nurs_ut_vw  ");
			sql.append(" where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"') ");
			sql.append(" order by 2 ");
            rset=stmt.executeQuery(sql.toString());
            if(rset!=null)
            {
                while(rset.next())
                {
                    total_count++;
                }
				if(rset!=null) rset.close();
            }
        if ( from == null )
         {
                    start = 0 ;
         }
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;
/*
try
{
	out.println("<p><table align='right'><tr><td>");    
	if ( !(start <= 0) )
	{
		out.println("<A HREF='../jsp/addModifyNursingUnitBkgLt.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&nursing_unit_code="+nursing_unit_code+"'>Previous</A>");
	}
	if (!((start+records_to_show) >= total_count ) )
	{
		out.println("<A HREF='../jsp/addModifyNursingUnitBkgLt.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&nursing_unit_code="+nursing_unit_code+"'>Next</A>");   
	}
	out.println("</td><td class=BODYCOLORFILLED>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr></table></p>");
	out.println("<br><br>");

}catch(Exception e) 
{
	//out.println("EEE"+e);
	e.printStackTrace();
}
*/
%>
    <table width='90%' border=0 cellspacing=0 cellpadding=0 align=center>
        
        <th colspan=6>  <fmt:message key="eIP.MaxDailyBookingLimit.label" bundle="${ip_labels}"/> </th>
    <tr>
		<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></th>
        <th ><fmt:message key="Common.male.label" bundle="${common_labels}"/></th>
        <th ><fmt:message key="Common.female.label" bundle="${common_labels}"/></th>
        <th ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></th>
        <th ><fmt:message key="Common.total.label" bundle="${common_labels}"/></th>
        <th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
    </tr>
<%
            rset=stmt.executeQuery(sql.toString());

         if(start > 1)
                {
                    for(int k=0; k < start ;k++)
                        rset.next();
                }

            int z=0;
            int id=0;

                while(rset.next())// && ( z < records_to_show) )
                {
                    z++;
               
                    id=i+start;// Naming the elements in the loop
                    
                    bedclasscode                    = rset.getString("bed_class_code");
                    bedclassdesc                    = rset.getString("short_desc");
                    maxmaledlybooking       = rset.getInt("max_male_dly_booking");
                    maxfemaledlybooking = rset.getInt("max_female_dly_booking");
                    maxunknowndlybooking  =rset.getInt("max_unknown_dly_booking");
                    maxtotaldlybooking      = rset.getInt("max_total_dly_booking");

	//out.println("<script>alert(\"maxtotaldlybooking ="+maxtotaldlybooking+"\")</script>");

                    eff_status=rset.getString(7);
                    if(eff_status==null) eff_status="N";

                    if(eff_status.equals("Y")) 
                    {
                      eff_status_checked="checked";
                    }
                    else if(eff_status.equals("N")) 
                    {
                     eff_status_checked="";
                     eff_status_disabled="";
                    }
                    
                    if(maxmaledlybooking == 0)
                        maxm = "";
                    else
                        maxm = Integer.toString(maxmaledlybooking);

                    if(maxfemaledlybooking == 0)
                        maxf = "";
                    else
                        maxf = Integer.toString(maxfemaledlybooking);

                    if(maxtotaldlybooking == 0)
                        maxt = "";
                    else
                        maxt = Integer.toString(maxtotaldlybooking);
                  
                    if(maxunknowndlybooking == 0)
                        maxu = "";
                    else
                        maxu = Integer.toString(maxunknowndlybooking); 
                %>
    <tr>
        <td align=left class=label>&nbsp;&nbsp;<%=bedclassdesc%></td>
		<%
		 if(eff_status.equals("Y")) 					
		{
		%>
        <td align='center'><input type="text" size='6' maxlength='6' id='M<%=id%>' name='M<%=id%>' value="<%=maxm%>"   onKeyPress='return(ChkNumInput(this,event,2))' <%=max_male_dly_booking_readOnly%> onBlur="if(checkNum(this,'<%=id%>'))bookingLimitChk(this,'<%=id%>')" ></td>
                                                                               
        <td align='center'><input type="text" size='6' maxlength='6' id='F<%=id%>' name='F<%=id%>' value="<%=maxf%>" onKeyPress='return(ChkNumInput(this,event,2))'  <%=max_female_dly_booking_readOnly%> onBlur="if(checkNum(this,'<%=id%>'))bookingLimitChk(this,'<%=id%>')" ></td>
                                                                               
        <td align='center'><input type='text' size='6' maxlength='6' id='U<%=id%>' name='U<%=id%>' value='<%=maxu%>' onBlur="if(checkNum(this,'<%=id%>'))bookingLimitChk(this,'<%=id%>')"  <%=max_unknown_dly_booking_readOnly%> onKeyPress='return(ChkNumInput(this,event,2))' ></td>
		<%
		}
		else
		{
		%>
		<td align='center'><input type="text" size='6' maxlength='6' name='M<%=id%>' id='M<%=id%>' value="<%=maxm%>"   onKeyPress='return(ChkNumInput(this,event,2))' <%=max_male_dly_booking_readOnly%> onBlur="if(checkNum(this,'<%=id%>'))bookingLimitChk(this,'<%=id%>')" ></td>
        <td align='center'><input type="text" size='6' maxlength='6' name='F<%=id%>' id='F<%=id%>' value="<%=maxf%>" onKeyPress='return(ChkNumInput(this,event,2))'  <%=max_female_dly_booking_readOnly%> onBlur="if(checkNum(this,'<%=id%>'))bookingLimitChk(this,'<%=id%>')" ></td>
        <td align='center'><input type='text' size='6' maxlength='6' name='U<%=id%>' id='U<%=id%>' value='<%=maxu%>' onBlur="if(checkNum(this,'<%=id%>'))bookingLimitChk(this,'<%=id%>')"  <%=max_unknown_dly_booking_readOnly%> onKeyPress='return(ChkNumInput(this,event,2))' ></td>
		<%
		}
		%>
        <td align='center'><input type='text' name='T<%=id%>' id='T<%=id%>' size='6' maxlength='6'  value='<%=maxt%>'  <%=max_total_dly_booking_readOnly%> onKeyPress='return(ChkNumInput(this,event,2))'  readOnly></td>

		<%
		if(maxt.equals("")){
		eff_status_checked="unchecked";
		eff_status_disabled="";

	}
		%>

        <td align=center><input type=checkbox name='S<%=id%>' id='S<%=id%>' value=E <%=eff_status_checked%> <%=eff_status_disabled%> onclick='enableText(this);'></td>
		 <input type='hidden' name='B<%=id%>' id='B<%=id%>' value=<%=bedclasscode%> >
    </tr>
	<!-- added on 27-11-2003 by dhanasekaran -->
	<tr>
	<td>
	<input type='hidden' name='bedclassdesc' id='bedclassdesc' value="<%=bedclassdesc%>">
	</td>
	</tr>

    <%
            i++;
        }
%>
    </table>
        <input type="hidden" name="gender" id="gender" value="<%=gender%>"> 
        <input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
        <input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>" >
    </form>
    <%
    if(fnval == "modify")
        out.print("<script>getGender()</script>");
    
	    if(rset     != null)   rset.close();
		if(stmt_gender != null) stmt_gender.close();
		if(rs_gender  != null) rs_gender.close();        
        if(stmt   != null)   stmt.close();
        if(pstmt != null)   pstmt.close();

	}catch(Exception e){
        //out.print("Exception :"+e);
		e.printStackTrace();
    }
    finally 
	{
        ConnectionManager.returnConnection(con,request);
    }
     %>
</body>
</html>

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

