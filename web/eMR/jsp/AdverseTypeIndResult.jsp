<!DOCTYPE html>
<%@ page import="java.util.*,java.text.*,java.sql.*,java.net.*,webbeans.eCommon.*"
contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>
		<%String sStyle	=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/messages.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/common.js">	</script>
		<script language='javascript' src='../js/AdverseReaction.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript" src="../js/eMRmessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		<%
		Connection conn = null;
		Statement stmt1=null;
		ResultSet rsas=null;
		ResultSet rs=null;
		String mode="";
		String checkBoxAttribute="";
		String ADV_REAC_CODE_1="";	
		String ADVR_TYPE="";
        String facilityId	=(String) session.getValue("facility_id");
	    facilityId	=(String) session.getValue("facility_id");
	    ADVR_TYPE=request.getParameter("ADVR_TYPE")==null?"":request.getParameter("ADVR_TYPE");	ADV_REAC_CODE_1=request.getParameter("ADV_REAC_CODE")==null?"":request.getParameter("ADV_REAC_CODE");
	mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	if(mode ==null || mode=="") mode="insert";
		 %>
		 
	 </head>
	<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onscroll='scrollTitle()'>
	<form name='Adverse_event_result' id='Adverse_event_result' action='../../servlet/eMR.AdverseEventTypeServlet' method='post' target='messageFrame' > 
	<table border='1' cellpadding='0' cellspacing='0' width='80%' align='center'>
					<th>Applicable Adverse Event Type Indicators&nbsp;<img id = 'IND_mand' src = '../../eCommon/images/mandatory.gif'></th>
			<%
			try
		{
 
				conn = ConnectionManager.getConnection(request);
				stmt1 = conn.createStatement();
				String causative_code="";
				String causative_desc="";
				String allow_one="";
				String allow_two="";
				String allow_three="";
				String allow_four="";
				String reaction_type="";
				String reaction_val="";
				int rowcolor=0;
				String classValue	 = "";
				String eff_status="";
				int k=0;
				int i=0;

				String sql_cnt="select count(*) count from MR_ALLERGEN ";
				rs=stmt1.executeQuery(sql_cnt);
				if(rs !=null && rs.next())
				{
					i = rs.getInt("count");
				}
				String sql_list="select A.ALLERGEN_CODE,A.long_desc,A.ADV_EVENT_TYPE_IND1_YN,A.ADV_EVENT_TYPE_IND2_YN, A.ADV_EVENT_TYPE_IND3_YN,A.ADV_EVENT_TYPE_IND4_YN,B.EFF_STATUS from MR_ALLERGEN A,MR_ADV_REA_CAUSE_AGENT  B where A.ADDED_FACILITY_ID='"+facilityId+"' AND A.ALLERGEN_CODE=B.ALLERGEN_CODE(+) and b.ADV_REAC_CODE(+)='"+ADV_REAC_CODE_1+"'  order by A.ADV_EVENT_TYPE_IND4_YN,A.ADV_EVENT_TYPE_IND3_YN ,A.ADV_EVENT_TYPE_IND2_YN,A.ADV_EVENT_TYPE_IND1_YN";
				rsas=stmt1.executeQuery(sql_list);
				if(rsas !=null )
				{
					while(rsas.next())
					{
							causative_code =	rsas.getString("ALLERGEN_CODE");
							causative_desc =	rsas.getString("long_desc");
							allow_one	   =	rsas.getString("ADV_EVENT_TYPE_IND1_YN");
							allow_two	   =	rsas.getString("ADV_EVENT_TYPE_IND2_YN");
							allow_three	   =	rsas.getString("ADV_EVENT_TYPE_IND3_YN");
							allow_four     =	rsas.getString("ADV_EVENT_TYPE_IND4_YN");
							eff_status     =    rsas.getString("EFF_STATUS");
							if(eff_status ==null) eff_status="";
							if(allow_one.equals("Y"))
							{
								reaction_type="Allergy";
								reaction_val="1";
							}else if(allow_two.equals("Y"))
							{
								reaction_type="Hypersensitivity Type II";
								reaction_val="2";
							}else if(allow_three.equals("Y"))
							{
								reaction_type="Hypersensitivity Type III";
								reaction_val="3";
							}else if(allow_four.equals("Y"))
							{	
								reaction_type="Hypersensitivity Type IV";
								reaction_val="4";
							}
							if(eff_status.equals("E"))
							{
								checkBoxAttribute="CHECKED";
							}else if(eff_status.equals("")){
								checkBoxAttribute="";

							}
							
						if ( rowcolor % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							%>
					<tr>
						<td class='<%=classValue%>' width='14%' nowrap>&nbsp;<%=causative_desc%></td>
						<td class='<%=classValue%>' width='14%' nowrap>&nbsp;<%=reaction_type%></td>
						<td class="<%=classValue%>" nowrap width='2%'>&nbsp;<input type='checkbox' id='check_box'name='checkBox<%=k%>'onClick='javascript:checkBoxOnClick(this);' value='' <%=checkBoxAttribute%> ><input type='hidden' name='ret_value' id='ret_value' value='<%=causative_code%>,<%=reaction_val%>,<%=k%>'></td>
						<input type='hidden' name='causative_code<%=k%>' id='causative_code<%=k%>' value='<%=causative_code%>'>
						<input type='hidden' name='reaction_val<%=k%>' id='reaction_val<%=k%>' value='<%=reaction_val%>'>
					</tr>
				<%	
					k=k+1;
					rowcolor++;	
				  }
				}

			%>
				<input type='hidden' name='count' id='count' value="<%=i%>">
				<input type='hidden' name='mode' id='mode' value="<%=mode%>">
				<input type='hidden' name='eff_status1' id='eff_status1' value="">
				<input type='hidden' name='fin_vals' id='fin_vals' value="">
				<input type='hidden' name='adv_reac_code' id='adv_reac_code' value="">
				<input type='hidden' name='adv_reac_long_desc' id='adv_reac_long_desc' value="">
				<input type='hidden' name='adv_reac_short_desc' id='adv_reac_short_desc' value="">
				<input type='hidden' name='eff_status' id='eff_status' value="">
				<input type='hidden' name='causative_code_val' id='causative_code_val' value=''>
				<input type='hidden' name='reaction_fin_val' id='reaction_fin_val' value=''>

					</table>
		</form>
	</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>
	<%}catch(Exception e)
	{

}%>

