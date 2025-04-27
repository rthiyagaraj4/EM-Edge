<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
    request.setCharacterEncoding("UTF-8");
	String p_module_id		= "AE" ;
	String p_report_id		= "AEBDISST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale						= (String)session.getAttribute("LOCALE");
    Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null ;
	ResultSet rset			= null;
	String currdate			= "";
	try{
		con = ConnectionManager.getConnection(request);

try {
		  String sql = "Select  to_char(sysdate,'dd/mm/yyyy') sys_date from dual";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	currdate = rs.getString("sys_date") ;
			  }
		  }			
    if (rs    != null)    rs.close();
    if (pstmt != null) pstmt.close();
	
	} catch(Exception e) {  e.printStackTrace();}

%>
<html>
<HEAD>
<TITLE></TITLE>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../js/AERepDispositionStatistics.js"></script>
        <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="RepDispositionStatistics" id="RepDispositionStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>
    
		<td width="80%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0" align='center'>
					<td class='label' height='5'></td>
					<tr>
					<td  class="label" width="25%"> <fmt:message key="Common.facility.label" bundle="${common_labels}"/> </td>
					<td width="25%"> 
							<select name='p_all_facility_id' id='p_all_facility_id' >
							<option value='ALL' selected><fmt:message key="Common.AllAccessFacilities.label" bundle="${common_labels}"/></option>
						<%
							try
							{
							
							String sql_facility="select facility_id, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID, '"+locale+"', 1) facility_name  from sm_facility_for_user where appl_user_id=?";				
							
							pstmt=con.prepareStatement(sql_facility);
                            pstmt.setString(1,p_user_name);
							rset=pstmt.executeQuery();

							if(rset!=null)
							{
							   while(rset.next())
							   {
								String fid= rset.getString("facility_id");;
								String fname=rset.getString("facility_name");;
								if(fid == null) fid	=	"";
								if(fname == null) fname = "";

								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
							
							if(rset != null)rset.close();
							if(pstmt != null)pstmt.close();

							}catch(Exception e)
							{
								//out.println(e);
								e.printStackTrace();
							}
					}catch(Exception e){e.printStackTrace();}
					finally { 
						if(con!=null)	
							ConnectionManager.returnConnection(con,request);
					}

						%>	
						</select>
					</td>
					<td width="25%"></td><td width="25%"></td>
				</tr>

				<tr>
						<td class='label' width="25%" ></td>
						<td  width="25%" class='querydata' align="left"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td>
						<td class='querydata' width="25%" align="left"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td>
						<td width="25%"></td>
					</tr>
					<tr>
						<td  class='label' width="25%"><fmt:message key="eAE.DispositionDate.label" bundle="${ae_labels}"/> </td>
						<td width="25%"><input type=text id='hlyattnfrom' name='p_fm_disp_date' id='p_fm_disp_date' size="10" maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('hlyattnfrom');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> 
						</td>
						<td width="25%"><input type=text id='hlyattnto' name='p_to_disp_date' id='p_to_disp_date' size="10" maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('hlyattnto');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img> 
						</td>
						<td width="25%"></td>
				</tr>
				<tr>
						<td  class='label' width="25%"><fmt:message key="eAE.DispositionTypeCode.label" bundle="${ae_labels}"/> </td>
						<td width="25%"><input type=text  name='p_fm_disp_type' id='p_fm_disp_type' size="2" maxlength="2" onBlur="ChangeUpperCase(this);validSplchars(this,'Disposition Type Code')" onKeyPress='return(CheckForSpecChars(event))'><input type='button' name='disposition type' id='disposition type' value='?' tabindex=-1 class='button' onclick='searchCode(this, p_fm_disp_type)'>
						</td>
						<td width="25%"><input type=text  name='p_to_disp_type' id='p_to_disp_type' size="2" maxlength="2" onBlur="ChangeUpperCase(this);validSplchars(this,'Disposition Type Code')" onKeyPress='return(CheckForSpecChars(event))'><input type='button' tabindex=-1 name='disposition type' id='disposition type' value='?' class='button' onclick='searchCode(this, p_to_disp_type)'>
						</td>
                        <td width="25%"></td>
				</tr>
                <tr>
                <td></td>
                <td class='label' height='5'></td>
				</tr>
		</table>
	</td>
</tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_curr_date" id="p_curr_date"			value="<%= currdate%>">
<input type="hidden" name="locale" id="locale"			value="<%= locale %>">
</form>
<script>document.forms[0].p_all_facility_id.focus();</script>
</body>
</html>

