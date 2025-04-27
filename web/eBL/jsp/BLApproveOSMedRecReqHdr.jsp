<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*,webbeans.op.CurrencyFormat, webbeans.eCommon.*"%>
<%!
%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	ResultSet rs=null;
	PreparedStatement pstmt1 = null;
	String locale="";
	String noOfDecimal = "";
	String facility_id="";
	String usr_id		= (String) session.getValue( "login_user" );	
	String PatIDLen = "";

	try{	
			//HttpSession httpSession = request.getSession(false);
			con	=	ConnectionManager.getConnection(request);	
			locale	= (String)session.getAttribute("LOCALE");
			facility_id = (String) session.getValue("facility_id");
			//facility_id = (String)httpSession.getValue("facility_id");
		}
		catch(Exception eX){	
			out.println("Error= "+eX);
			eX.printStackTrace();
		}
%>
<HTML>
	<HEAD>
		<TITLE>
		Approve OS Balance For Medical Record Request
		</TITLE>	
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>			
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../js/BLApproveOSBalance.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>	
	<script language="javascript" src="../../eBL/js/AutoFillSearchCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</HEAD> 		
	<BODY onKeyDown= "lockKey();" onMouseDown="CodeArrest();"onSelect="codeArrestThruSelect();">
	<FORM name='BLApproveOS' id='BLApproveOS' method=''  target="messageFrame">
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	<TR>
		<td width='15%'  style="display:none;"> class='label'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>	
		<td width='15%'  style="display:none;">>
		<Select id="episode_type" name="episode_type" id="episode_type" >
<%	
	try{		
			String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
			pstmt1=con.prepareStatement(sqlLen);
			rs=pstmt1.executeQuery();
			while(rs.next() && rs!=null)
			{
				PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			}
			pstmt1 = null;
			rs = null;
			pstmt1 = con.prepareStatement( " SELECT  PATIENT_CLASS,SHORT_DESC  FROM AM_PATIENT_CLASS");
			rs = pstmt1.executeQuery();	
			System.out.println("RESULT SET :"+rs);			
			while(rs.next())
			{				
				String patientClass  =  rs.getString(1);
				String epi_type=!patientClass.substring(0, 1).equalsIgnoreCase("X")?patientClass.substring(0, 1):"R";
				String patClassShortDesc  =  rs.getString(2);						
				out.println("Inside while loop >> patClassShortDesc :"+patClassShortDesc);
				if(epi_type.equals("I"))
				{
				%>
				<option value="<%=epi_type%>" selected><%= patClassShortDesc %></option>
				<%
				}
				else{
				%>
				<option value="<%=epi_type%>"><%= patClassShortDesc %></option>				
			<%  }out.println("short desc >> patClassShortDesc :"+patClassShortDesc.substring(0, 2)); %>
			<%
			}
			pstmt1= null;
			rs = null;
			pstmt1 = con.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
			rs = pstmt1.executeQuery();
			if(rs != null && rs.next()){
				noOfDecimal = rs.getString("no_of_decimal");
			}
			if (rs != null)   rs.close();
			if (pstmt1 != null)   pstmt1.close();
		}catch(Exception e) {
				System.out.println("currency="+e.toString());
				e.printStackTrace();
			}
		finally{
			if (rs != null) rs.close();
			if (pstmt1 != null) pstmt1.close();
			if(con!=null)
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
	%>			
		<td width="5%" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td width="10%" class='fields'>
		<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=PatIDLen%>" size="12" 	onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value!=''){ChangeUpperCase( this ); callPatValidation(this);defaultEncounter('patId');getPatDetails();} "><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="PatientIdLookup();defaultEncounter();" tabindex='2' /><img src='../../eCommon/images/mandatory.gif'></td>				
		<td width="16%"  style="display:none;"> class="label" ><fmt:message key="eBL.episodeid.label" bundle="${bl_labels}"/></td>
		<td width="16%"  style="display:none;"> class='fields'>
		<input type="text" name='episode_id' id='episode_id' id='episode_id'  maxlength="15"  size="8"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
		<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id' id='hdnEpisode_id'><class="label" width="1%"><fmt:message key="eBL.Slash.label" bundle="${bl_labels}"/>
		<input type="text" name='visit_id' id='visit_id' id='visit_id'  maxlength="2"  onBlur="" size="6"   onKeyPress="" ><input type='button' class='button' name='episode_idbut' id='episode_idbut' value='?' onClick="episodeLookup(episode_id,hdnEpisode_id)"  tabindex='2' /></td>
		<td  class="label" width='16%' ><input type='button' class='button' onclick='search();' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  name='search_but' >	
		<input type='button' class='button' onclick='resetSrchCriteria()' value="Clear"  name='reset_but' id='reset_but' ></td>
	</tr>
	</TABLE>
	<input type= hidden name="locale"  id='locale' value="<%=locale%>">
	<input type= hidden name="facility_id" id="facility_id"   value="<%=facility_id %>">		
	<input type='hidden' name='total_records' id='total_records' value="">
	<input type="hidden" name="usr_id" id="usr_id"	   value="<%= usr_id %>">
	<input type="hidden" name="L_EPISODE_TYPE" id="L_EPISODE_TYPE"	   value="">
	<input type='hidden' name='noOfDecimal'  id='noOfDecimal' value='<%=noOfDecimal %>'>
	<input type='hidden' name='enteredPatient' id='enteredPatient' value=''>
	</FORM>
	</BODY>
</HTML>			
		 

