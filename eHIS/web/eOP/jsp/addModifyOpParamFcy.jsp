<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eOP/js/OpParamFcy.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
    Connection con = null;
    try{
        con=ConnectionManager.getConnection(request);
    PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
    ResultSet rset=null ;
	ResultSet rset1=null ;

	String dat="";
    String id="";
    String fnval="insert";
    String operating_facility_id=null;
    String service_code="";
  
    String episode_close_days_fu="";
    String episode_close_days_wo_fu="";
    String sql="";
    String facility_name="";
    String service_short_desc="";
	//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 02/09/2013
	//Start
	String episode_closure_by="";
	String consecutive_no_shows="";
	String consecutive_no_shows_months="";
	String no_of_visits_months="";
	String no_of_future_appts_months="";
	//End

    operating_facility_id=request.getParameter("operating_facility_id");
    facility_name=request.getParameter("facility_name");
    service_code=request.getParameter("service_code");
	//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 02/09/2013
	//Start
	try
		{
		String fac_id				 = (String) session.getValue( "facility_id" ) ;

		String op_sql="select EPISODE_CLOSURE_BY from  op_param where operating_facility_id=? ";
		pstmt1=con.prepareStatement(op_sql);
		pstmt1.setString(1,fac_id);
		rset1=pstmt1.executeQuery();
		if(rset1.next())
			{
			episode_closure_by=rset1.getString("EPISODE_CLOSURE_BY");
			}
		if(rset1!=null)rset1.close();	
		if(pstmt1!=null)pstmt1.close();
		}
	catch(Exception e)	
		{
		System.out.println("Exception occurred : "+e);
		e.printStackTrace();
		}
	//End	
    if(operating_facility_id!=null )
    {
		operating_facility_id=operating_facility_id.trim();
        fnval="modify";
		try
		{
			/* This query selects all the records from the table op_param_for_facy_service_vw for the corresponding operating facility and service. --- Srijagadeesh */

			sql="select * from  op_param_for_facy_service_vw where operating_facility_id=? and service_code=? "  ;
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,operating_facility_id);
			pstmt.setString(2,service_code);
	        rset=pstmt.executeQuery();

			if(rset.next())
			{
				facility_name=rset.getString("facility_name");
				service_short_desc=rset.getString("service_short_desc");
	           
			    episode_close_days_fu=rset.getString("episode_close_days_fu")==null?"":rset.getString("episode_close_days_fu");
				episode_close_days_wo_fu=rset.getString("episode_close_days_wo_fu")==null?"":rset.getString("episode_close_days_wo_fu");
				//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 02/09/2013
				//Start
				consecutive_no_shows=rset.getString("consecutive_no_shows")==null?"":rset.getString("consecutive_no_shows");
				consecutive_no_shows_months=rset.getString("no_of_no_show_months")==null?"":rset.getString("no_of_no_show_months");
				no_of_visits_months=rset.getString("no_of_visits_months")==null?"":rset.getString("no_of_visits_months");
				no_of_future_appts_months=rset.getString("no_of_future_appts_months")==null?"":rset.getString("no_of_future_appts_months");
				//End
	
			}
	        //else
				//out.println("no resultset");
		}catch(Exception e) {
			e.printStackTrace();
			//out.println(e.toString());
			}
		finally
		{
			if (pstmt != null) pstmt.close();
	        if (rset != null) rset.close();
		}
     }
%>
</head>
    <body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' >

	<!-- The form OpParamFcy_form calls the servlet OpParamFcyServlet using post method; The servlet fetches all the values of Facility,Service, No. of Days for follow-up and No follow-up and updates the database --- Srijagadeesh. -->

        <form name='OpParamFcy_form' id='OpParamFcy_form' action='../../servlet/eOP.OpParamFcyServlet' method='post' target='messageFrame'>
        <BR><BR><BR><BR><BR><BR><BR><BR>
            <div align='center'>
            <table border='0' cellpadding='3' cellspacing='0' width='60%'>
            <tr>
                     <td width='40%' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
                     <td width='60%' class='fields' colspan='3'>
                   <%  if(fnval.equals("modify"))
                        {%>
                     <input type='text' name='facilityid' id='facilityid' READONLY size=50 maxlength=35 value="<%=facility_name%>" ><img align='center' src='../../eCommon/images/mandatory.gif'></img>
                     <input type='hidden' name='operating_facility_id' id='operating_facility_id' value="<%=operating_facility_id%>">
                        <%}
                    else
                    {%>
                    <select name='operating_facility_id' id='operating_facility_id' onChange='getservice(this)'>
                     <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
                 <%
                    try{
                        /* This sql query fetches all the facility id's and their names to display in the Facility drop down box --- Srijagadeesh. */

						sql="select facility_id, facility_name from sm_facility_param order by 2";
						pstmt=con.prepareStatement(sql);
                        rset=pstmt.executeQuery() ;

						if(rset!=null)
                        {
                             while(rset.next())
                             {
                                 String sel="";
                                dat=rset.getString("facility_name");
                                id=rset.getString("facility_id");
                                out.println("<option value='"+id+"'"+sel+">"+dat+"</option>");
                            }
                        }
                    }catch(Exception e) {
						e.printStackTrace();
						//out.println(e.toString());
						}
                    finally
                    {
                        if (pstmt != null) pstmt.close();
                        if (rset != null) rset.close();
                    }                   
                    %>
                         </select><img align='center'
                         src='../../eCommon/images/mandatory.gif'></img>
                     <%}%>
                        </td>
                    </tr>                 
                <tr>
                    <td width='40%' class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
                     <td width='60%' class='fields' colspan='3'>
                     <%
                         if(fnval.equals("modify"))
                        {
                     %>
                        <input type='text' name='servicecode' id='servicecode' value="<%=service_short_desc%>" READONLY><img align='center' src='../../eCommon/images/mandatory.gif'></img>
                        <input type='hidden' name='service_code' id='service_code' value="<%=service_code%>">

                    <%
                        }
                            else
                        {
                    %>
                         <select name='service_code' id='service_code'>
                         <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;</option>
                     </select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
                    <%
                        }
                    %>
                        </td>
                    </tr>                   
                </table>
				   <br>
				   <%
				if(episode_closure_by==null)
					episode_closure_by="D";
				if(!episode_closure_by.equals("N")){%>
                <table border='0' cellpadding='0' cellspacing='0' width='60%'>
				<th  class='columnheader' colspan=4 align="left"><fmt:message key="eOP.ClosureRuleMinelapseddaysfromlastvisit.label" bundle="${op_labels}"/></th>
				</table>
				<%}else{%>
				<table border='0' cellpadding='0' cellspacing='0' width='60%'>
				<th class='columnheader' colspan=4 align="left"><fmt:message key="eOP.ClosureRulebasedonNoshowslastvisitFutappt.label" bundle="${op_labels}"/></th>
				</table>
				<%
				}
				if(!episode_closure_by.equals("N")){%>
				<table cellpadding=3 cellspacing=0 width='60%'>
				<tr>
				<td width='40%'class='label'><fmt:message key="Common.followup.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='3' >
	            <input type ='text' name='episode_close_days_fu' id='episode_close_days_fu' value="<%=episode_close_days_fu%>" size='6' maxlength='6' OnBlur='CheckNum(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>
	            <img align='center' src='../../eCommon/images/mandatory.gif'></img>
                  </td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eOP.NoFollowup.label" bundle="${op_labels}"/></td>
		            <td width='60%' class='fields' colspan='3' >
					<input type ='text' name='episode_close_days_wo_fu' id='episode_close_days_wo_fu' value="<%=episode_close_days_wo_fu%>" size='6' maxlength='6'  OnBlur='CheckNum(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>
				    <img align='center' src='../../eCommon/images/mandatory.gif'></img>
			        </td>
				</tr>
				<input type='hidden' name='consecutive_no_shows' id='consecutive_no_shows' value='0'>
				<input type='hidden' name='consecutive_no_shows_months' id='consecutive_no_shows_months' value='0'>
				<input type='hidden' name='no_of_visits_months' id='no_of_visits_months' value='0'>						
				<input type='hidden' name='no_of_future_appts_months' id='no_of_future_appts_months' value='0'>
				</table>
			<%}
			else
				{
				%>		
				<table border="0" cellpadding=3 cellspacing=0 width='60%'>
				<tr>
					<td width='40%'class='label'><fmt:message key="eOP.ConsecutiveNoShows.label" bundle="${op_labels}"/></td>
					<td width='60%' class='fields' colspan='3' >
					<input type ='text' name='consecutive_no_shows' id='consecutive_no_shows' value="<%=consecutive_no_shows%>" size='6' maxlength='3' OnBlur='CheckNum(this); valid_dat(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>&nbsp;&nbsp;<fmt:message key="eOP.in.label" bundle="${op_labels}"/>&nbsp;&nbsp;<input type ='text' name='consecutive_no_shows_months' id='consecutive_no_shows_months' value="<%=consecutive_no_shows_months%>" size='6' maxlength='2' OnBlur='CheckNum(this); valid_dat(this);' onKeyPress='return(ChkNumberInput(this,event,0))'/>&nbsp;&nbsp;<fmt:message key="Common.months.label" bundle="${common_labels}"/><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eOP.NoVisitsInLast.label" bundle="${op_labels}"/></td>
		            <td width='60%' class='fields' colspan='3' >
					<input type ='text' name='no_of_visits_months' id='no_of_visits_months' value="<%=no_of_visits_months%>" size='6' maxlength='2'  OnBlur='CheckNum(this); valid_dat(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>
					<fmt:message key="Common.months.label" bundle="${common_labels}"/>
					<img align='center' src='../../eCommon/images/mandatory.gif'></img>	
			        </td>
				</tr>			   
				<tr>
					<td width='40%' class='label'><fmt:message key="eOP.NoFutApptsIn.label" bundle="${op_labels}"/></td>
		            <td width='60%' class='fields' colspan='3' >
					<input type ='text' name='no_of_future_appts_months' id='no_of_future_appts_months' value="<%=no_of_future_appts_months%>" size='6' maxlength='2'  OnBlur='CheckNum(this); valid_dat(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>				    				
					<fmt:message key="Common.months.label" bundle="${common_labels}"/>
					<img align='center' src='../../eCommon/images/mandatory.gif'></img>	
			        </td>
				</tr>	
				
				<input type='hidden' name='episode_close_days_fu' id='episode_close_days_fu' value='0'>
				<input type='hidden' name='episode_close_days_wo_fu' id='episode_close_days_wo_fu' value='0'>		
				</table>
				<%
				}%>	
			</div>
	        <input type='hidden' name='function' id='function' value='<%=fnval%>'>
		    <input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		</form>
</body>
</html>
<%
}catch(Exception e){}
finally
{
if(con!=null) 
	ConnectionManager.returnConnection(con,request);
}
%>

