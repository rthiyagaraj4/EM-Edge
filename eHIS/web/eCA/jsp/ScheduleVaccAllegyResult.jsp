<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
 <%	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//String userId=(String) session.getValue("login_user");

	//String query_string = request.getQueryString();


	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	con = ConnectionManager.getConnection(request);

	//String vacc_categ_id ="";
	//String patient_id ="";
	//String multi_sch_yn ="";
	String vaccine_id ="";
	String dose_no ="";
	String reaction_code ="";
	String reaction_date ="";
	String vac_sch_ref  ="";
	String vac_srl_no  ="";
	/* Modified by Kishore Kumar N on Spet 09-09*/
	String className  ="gridData";
	/*ends here. */
	String short_desc  ="";
	String status ="";

	int k =0;

	vac_sch_ref =request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");  
	vaccine_id =request.getParameter("vaccine_id")==null?"":request.getParameter("vaccine_id");  
	dose_no =request.getParameter("dose_no")==null?"":request.getParameter("dose_no"); 
	status = request.getParameter("status")==null?"":request.getParameter("status");
		

	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <head>

	<script>

	function loadAlergyDetails(vac_sch_ref,vaccine_id,dose_no,vac_srl_no,status)
	{
		parent.AllergyAddModify.location.href='../../eCA/jsp/ScheduleVaccAllegyAddModify.jsp?vac_sch_ref='+vac_sch_ref+'&vaccine_id='+vaccine_id+'&dose_no='+dose_no+'&vac_srl_no='+vac_srl_no+'&mode_new1=view'+'&status='+status;
		parent.parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	}

	</script>


	</head>
	<body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form >
	<!-- Modified by Kishore Kumar N on Spet 09-09 -->
	<table width='100%' class='grid'>
	<!-- ends here. -->
	    <tr>
		  
		  <td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.Reaction.label" bundle="${common_labels}"/></td>
		  <td class='columnheadercenter'  width='' nowrap ><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
		  
		  
		</tr>

<%
		try
		{


		String allergy_query=" Select VACCINE_ID,DOSE_NO ,VAC_SRL_NO,REACTION_CODE,(select SHORT_DESC from  am_reaction_lang_vw b where b.REACTION_CODE =cc.REACTION_CODE and b.LANGUAGE_ID = ?) short_desc, to_char(REACTION_DATE,'DD/MM/YYYY HH:MI')REACTION_DATE  from CA_IM_PAT_VAC_REACTION cc  where cc.VAC_SCH_REF =? and cc.VACCINE_ID= ? and  cc.DOSE_NO =? ";
		// and  cc.DOSE_NO =?";
		pstmt=con.prepareStatement(allergy_query);
		pstmt.setString(1,locale);	
		pstmt.setString(2,vac_sch_ref);	
		pstmt.setString(3,vaccine_id);	
		pstmt.setString(4,dose_no);	
		rs= pstmt.executeQuery();
		
		while(rs.next())
		{
			/* Modified by Kishore Kumar N on Spet 09-09*/
			/*if (k % 2 == 0 )
				   className = "QRYODD";
				else
					className = "QRYEVEN";*/

					/* ends here.*/

			vaccine_id = rs.getString("VACCINE_ID");
			short_desc = rs.getString("short_desc");
			dose_no = rs.getString("DOSE_NO");
			reaction_code = rs.getString("REACTION_CODE");
			reaction_date = rs.getString("REACTION_DATE");
			vac_srl_no = rs.getString("VAC_SRL_NO");
			
		%>
		<tr>
				
		
		<!--<td><a href='javascript:loadAlergyDetails(\""+vac_sch_ref+"\",\""+vaccine_id+"\",\""+dose_no+"\",\""+adhoc_yn+"\",\""+administered_date+"\");'><%=reaction_code%></a></td>-->
		<td class='<%=className%>'><a href="javascript:loadAlergyDetails('<%=vac_sch_ref%>','<%=vaccine_id%>','<%=dose_no%>','<%=vac_srl_no%>','<%=status%>');"><%=short_desc%></a></td>
		<td class='<%=className%>'><%=reaction_date%></td>
		</td>
		<tr>
		
		
		<%		
		
		k++;
		}
		
		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		

		}
		catch(Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}


%>

	</form>
 </body>
</html>

