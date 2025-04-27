<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%

Connection con   = null;

try{    
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		con=ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;		
		ResultSet rset   =null;
		
		String fac_id    = (String) session.getValue( "facility_id" ) ;
		String loginuser = (String) session.getValue( "login_user" ) ;	

		String rfresh_param = request.getParameter("refresh");
		String oprstn=request.getParameter("oprstn")==null?"":request.getParameter("oprstn");
		String rule=request.getParameter("access_rule");
		String call_from=request.getParameter("call_from")==null?"":request.getParameter("call_from");
		String ca_speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");		
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		String cdate = dateFormat.format(new java.util.Date()) ;	
		if(cdate!="")
			cdate = DateUtils.convertDate(cdate,"DMY","en",localeName);		
		String speciality_code="";
		String speciality_desc="";
		String pat_id_length = request.getParameter("pat_id_length")==null?"":request.getParameter("pat_id_length");
		String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"N":request.getParameter("bl_package_enabled_yn");
		String sdate = request.getParameter("sdate")==null?"":request.getParameter("sdate");
		String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]

%>

<html>
    <head>
	<script src="../../eOP/js/ManageMPatQueue.js"></script>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

    <body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
    	<form name="MultiPatQ" id="MultiPatQ">
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'  >
   	<tr>
   	</tr>
   	<tr>
	<td width="100%" class="Border">
	<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%"  border='1'>
	<tr>
		<td   class='label'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  class='fields' >
			<input type='text' name='date' id='date'  SIZE='10' maxlength='10' value='<%=cdate%>' readonly>
		</td>

		<td  class='label'><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
			<td  class=fields>
			<input type='text' name='start_time' id='start_time' size='5' maxlength='5'  value='' onBlur="validateTIme(this);" >
	</td>

	<td  align='right' ></td>
	<td  align='left' colspan='2'>
	
			
   					</select>
    				</td>
    				
   				</tr>
			<tr>
					<td  align='right' class='label'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
   				    	<td  class='fields' >
   				    		<input type='radio' name='multiple' id='multiple' SIZE='10' maxlength='10' value='M' checked>
							<font class='label'><fmt:message key="Common.multiple.label" bundle="${common_labels}"/>
							<%
								if(call_from.equals("CA"))
								{
							%>
   				    			<input type='radio' name='multiple' id='multiple' SIZE='10' maxlength='10' value='S' disabled onclick='callSingleQ()'><font class='label' ><fmt:message key="Common.single.label" bundle="${common_labels}"/>
							<%
								} else {
							%>
								<input type='radio' name='multiple' id='multiple' SIZE='10' maxlength='10' value='S' onclick='callSingleQ()'><font class='label' ><fmt:message key="Common.single.label" bundle="${common_labels}"/>

							<% } %>
    				 	</td>

					<td   class='label'><fmt:message key="eOP.ByVisitType.label" bundle="${op_labels}"/></td>
   				    	<td  class='Fields'>
   				    	<input type='checkbox' name='visit_type' id='visit_type' SIZE='10' maxlength='10' value='Y' >
   				    </td>
					</tr>
					<tr>
					<td  align='right' class='label' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						 <td  align='left' colspan='2'>
         	<select name='Qspeciality' id='Qspeciality'  onChange=""><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------  
        <%
        	pstmt=con.prepareStatement("SELECT a.speciality_code, a.short_desc  FROM am_speciality_lang_vw a  WHERE a.eff_status = 'E' and a.language_id = '"+localeName+"'   AND a.speciality_code IN (SELECT b.speciality_code   FROM op_clinic b, am_os_user_locn_access_vw c   WHERE b.facility_id = '"+fac_id+"' AND b.facility_id = c.facility_id  AND b.clinic_code = c.locn_code  AND b.clinic_type=c.LOCN_TYPE and a.speciality_code = b.speciality_code and c.appl_user_id = '"+loginuser+"' and c.oper_stn_id = '"+oprstn+"') order by 2 ");        	
        	rset=pstmt.executeQuery();
        	if(rset != null)
        	{
        		while(rset.next())
        		{
        			 speciality_code=rset.getString("speciality_code");
        			 speciality_desc=rset.getString("short_desc");
					 if(speciality_code.equals(ca_speciality_code))
					 {
						out.println("<option value='"+speciality_code+"' selected>"+speciality_desc);
					 }
					 else {
        				out.println("<option value='"+speciality_code+"'>"+speciality_desc);
					 }
        		}
        	}
        	
          if(rset != null) rset.close();
		  if(pstmt != null) pstmt.close();

        	%>
        	</select></td>
             <td  valign='center' rowspan='2'>
			  <input type='button' name='refresh' id='refresh' Value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='refreshFrames()' class='button'>&nbsp;<input type='button' class='Button' name="cleardata" id="cleardata" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearfields()">
			  <%
				  if(call_from.equals("CA"))
				  {
			  %>
					<input type='button' class='Button' name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="close_op_window()">					
			  <%
				  }
			  %>
   			  </td>  
   			   </tr>
   				</table>
   		</tr>
   	</table>

	<input type='hidden' name='rfresh_param' id='rfresh_param' value='<%=rfresh_param%>'>
	<input type='hidden' name='access_rule' id='access_rule' value='<%=rule%>'>
	<input type='hidden' name='Qoperstat' id='Qoperstat' value='<%=oprstn%>'>
	<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>

	<input type='hidden' name='pat_id_length' id='pat_id_length' value='<%=pat_id_length%>'>
	<input type='hidden' name='bl_package_enabled_yn' id='bl_package_enabled_yn' value='<%=bl_package_enabled_yn%>'>
	<input type='hidden' name='sdate' id='sdate' value='<%=sdate%>'>
	<input type='hidden' name='action_on_pending_bill' id='action_on_pending_bill' value='<%=action_on_pending_bill%>'><!-- added for MMS-QH-CRF-0126 [IN:041880]-->
	

	<%
		if(call_from.equals("CA"))
		{
	%>
			<script>
				if(document.forms[0].Qspeciality)
				{
					if(document.forms[0].Qspeciality.value!="")
					{
						if(document.forms[0].refresh)
						{
							document.forms[0].refresh.click();
						}
					}
				}							
			</script>
	<%
		  }
	%>
   	
	</form>
   <%
   }
   	catch(Exception e){}
	finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
   %>
    </body>
</html>

