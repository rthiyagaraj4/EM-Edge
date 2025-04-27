<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue %>
	<%
	String height1 ="";
	String height2 ="";
	String height3 ="";
	String height4 ="";
	String height5 ="";
	String height6 ="";
	String height7 ="";
	String height8 ="";

	
 
%>
<%@ include file="RecDiagnosisGetValidation.jsp"%>
<html>
<head>
	<title> <fmt:message key="eMR.RecordDiagnosis.label" bundle="${mr_labels}"/> </title>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<%


	Statement pstmt		= null;
	ResultSet rs				= null;
	Connection conn = ConnectionManager.getConnection(request);	

	try{
	String Patient_Id			= request.getParameter("patient_id");
	String Encounter_Id			= request.getParameter("encounter_id");
	String episode_type			= checkForNull(request.getParameter("episode_type"));
	String relationship_id		= checkForNull(request.getParameter("relationship_id"));	
	String Locn_Code			= checkForNull(request.getParameter("Locn_Code"));
	if(Locn_Code.equals(""))
		Locn_Code				= checkForNull(request.getParameter("location_code"));

	String cause_of_death		= checkForNull(request.getParameter("cause_of_death"),"N");
	String Locn_Type			= checkForNull(request.getParameter("location_type"));   
		if(Locn_Type.equals("")) Locn_Type="C";
	//String call_function		= checkForNull(request.getParameter("call_function"));  
	String function				= checkForNull(request.getParameter("Function"));  
	String context				= checkForNull(request.getParameter("Context"));  
	String logicalseqno			= checkForNull(request.getParameter("Logical_Seq"));  
	String patient_class		= checkForNull(request.getParameter("patient_class"));  
	String called_from_ip		= checkForNull(request.getParameter("IP_YN")); 
	String age					= checkForNull(request.getParameter("Age")); 
	String dob					= checkForNull(request.getParameter("Dob")); 
	String sex					= checkForNull(request.getParameter("Sex"));
	String occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
	String term_code			= checkForNull(request.getParameter("term_code"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String modal_yn				= checkForNull(request.getParameter("modal_yn"),"N");
	String visit_adm_date		= checkForNull(request.getParameter("visit_adm_date")); 
	String practitioner_type	= checkForNull(request.getParameter("practitioner_type"));
	String speciality_code		= checkForNull(request.getParameter("speciality_code"));
	String term_short_desc		= checkForNull(request.getParameter("term_short_desc"));
	String mode						= checkForNull(request.getParameter("mode"));
	String call_from					= checkForNull(request.getParameter("call_from"));//Calling From MDR added on 9/15/2009
	String totalRecords			= checkForNull(request.getParameter("totalRecords"));//Calling From MDR added on 9/15/2009
	String role_id				= "";
	String pract_type			= "";
	StringBuffer role           =new StringBuffer(); 
	String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget"));  //CHL-CRF- 0008 - IN:001472
	/*2/16/2009 SRR20056-SCF-2767 IN008154*/
	//String Practitioner_Id		= checkForNull(request.getParameter("practitioner_id"));
	String Practitioner_Id		= (String)session.getValue("login_user");

	String isCalledFromMDR="N";
	
	String called_from_ot=checkForNull(request.getParameter("called_from_ot")); //this variable Added for this CRF  PMG2012-CRF-0030 [IN:037757]
	
	String function_id				= checkForNull(request.getParameter("function_id")); //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
	
	try{
		//if(role.length() > 0) role.delete(0,role.length());
		role.setLength(0);
		role.append("Select func_role_id,pract_type from sm_appl_user_vw where appl_user_id = '"+Practitioner_Id+"' ");
		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(role.toString());
		while(rs.next())
		{
			role_id            = rs.getString(1);
			pract_type         = rs.getString(2);
		}
		if(rs!=null)rs.close();
        if(pstmt!=null)pstmt.close();

	}catch(Exception ex){
		//out.println(ex);
		ex.printStackTrace();
	}
	
	if(practitioner_type.equals("") ||(!practitioner_type.equals(pract_type))){	
		//practitioner_type = checkForNull((String)session.getValue("practitioner_type"));
		practitioner_type = pract_type;
	}

	if(Practitioner_Id.equals("") || Practitioner_Id.equals("null") || (!Practitioner_Id.equals(role_id))){
			//Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
			Practitioner_Id		    = role_id;
	}


	String stage_code = checkForNull(request.getParameter("stage_code"));
	String isCalledFromCA = checkForNull(request.getParameter("CA")); 
	String accession_number     = checkForNull(request.getParameter("accession_num"));
	String oh_chart_num			= checkForNull(request.getParameter("oh_chart_num"));
	String option_id		    = checkForNull(request.getParameter("option_id"));
	//Maheshwaran added for the SKR-CRF-0020 as on 28/09/2013
	//Start
	if(isCalledFromCA.equals("Y")&&(mode.equals("R")))
	mode="";
	//End
	if(isCalledFromCA.equals(""))
		isCalledFromCA = "N";
	  
	  /*
	  Added for IN010542

	  */	 
	  String restorative_Chart=checkForNull((String)session.getAttribute("restorative_Chart"));
	if(restorative_Chart.equals("OH"))
		isCalledFromCA = "N";
	/*
	End here.
	*/

	//out.println("<script>alert('isCalledFromCA"+isCalledFromCA+"**')</script>");
	//out.println("<script>alert('modal_yn"+modal_yn+"**')</script>");
	//out.println("<script>alert('isCalledFromMDR"+isCalledFromMDR+"**')</script>");
	
%>
	<%
	if(modal_yn.equals("Y")){
		if(isCalledFromCA.equals("Y")){ 	
			
		    	height1="0vh";
				height2="3vh";
				height3="25vh";
				height4="4vh";
				height5="59vh";
				height6="3vh";
				height7="0vh";
				height8="5vh"; 
				%>
		<%
		}else{ 
		   if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
			  
			   height1="8vh";
				height2="3vh";
				height3="2vh";
				height4="2vh";
				height5="75vh";
				height6="6vh";
				height7="0vh";
				height8="8vh";
				
		   
		   %>
			<!-- <frameset id ='RecDiagMain' rows='7%,0%,0%,0%,*,4%,7%,8%' > -->
				<!--<frameset id ='RecDiagMain' rows='7%,15%,3%,*,4%,7%,7%' >-->
		<script>
		/* document.getElementById('pline').style.height="8vh";
		document.getElementById('RecDiagnosisCurrentDiagheader').style.height="3vh";
		document.getElementById('RecDiagnosisCurrentDiag').style.height="2vh";
		document.getElementById('RecDiagnosisCurrentDiagLegend').style.height="2vh";
		document.getElementById('RecDiagnosisAddModify').style.height="75vh";
		document.getElementById('RecDiagnosisOpernToolbar').style.height="6vh";
		document.getElementById('blankframe1').style.height="0vh";
		document.getElementById('messageFrame').style.height="8vh"; */
		</script>
		
		
		
		<%}else{
			 
			height1="10vh";
			height2="3vh";
			height3="25vh";
			height4="3vh";
			height5="59vh";
			height6="4vh";
			height7="7vh";
			height8="7vh";
				
		%> 
		<!--
		Before 9/22/2008 this frame set used modified by anjaneya<frameset id ='RecDiagMain' rows='7%,0,15%,3%,*,4%,7%,7%' >
		-->
			<!--<frameset id ='RecDiagMain' rows='7%,15%,3%,*,4%,7%,7%' >-->
		<!-- <script>
		document.getElementById("pline").style.height="9vh";
		document.getElementById("RecDiagnosisCurrentDiagheader").style.height="3vh";
		document.getElementById("RecDiagnosisCurrentDiag").style.height="2vh";
		document.getElementById("RecDiagnosisCurrentDiagLegend").style.height="2vh";
		document.getElementById("RecDiagnosisAddModify").style.height="75vh";
		document.getElementById("RecDiagnosisOpernToolbar").style.height="6vh";
		document.getElementById("blankframe1").style.height="0vh";
		document.getElementById("messageFrame").style.height="8vh";
		</script> -->
		<%}
	}
	}else{

		if(isCalledFromCA.equals("Y")){
			 
			 height1="8vh";
				height2="69vh";
				height3="3vh";
				height4="18vh";
				height5="4vh";
				height6="0vh";
				height7="7vh";
				
	%>
			<!-- <frameset id ='RecDiagMain' rows='7%,61%,3%,*,4%,0%,7%' > -->
				<!--<frameset id ='RecDiagMain' rows='7%,15%,3%,*,4%,7%,7%' >-->
		<!-- <script>
		document.getElementById('pline').style.height="7vh";
		document.getElementById('RecDiagnosisCurrentDiagheader').style.height="3vh";
		document.getElementById('RecDiagnosisCurrentDiag').style.height="2vh";
		document.getElementById('RecDiagnosisCurrentDiagLegend').style.height="2vh";
		document.getElementById('RecDiagnosisAddModify').style.height="75vh";
		document.getElementById('RecDiagnosisOpernToolbar').style.height="6vh";
		document.getElementById('blankframe1').style.height="0vh";
		document.getElementById('messageFrame').style.height="8vh";
		</script> --><script>//alert("line 231 is coming");</script> 
	<%
		}else{
			
			 height1="8vh";
				height2="8vh";
				height3="51vh";
				height4="3vh";
				height5="10vh";
				height6="4vh";
				height7="0vh";
				height8="7vh";
		%> 
			<!-- <frameset id ='RecDiagMain' rows='7%,7%,61%,3%,*,4%,0%,7%' > -->
				<!--<frameset id ='RecDiagMain' rows='7%,15%,3%,*,4%,7%,7%' >-->
		<!-- <script>
		document.getElementById('pline').style.height="7vh";
		document.getElementById('RecDiagnosisCurrentDiagheader').style.height="3vh";
		document.getElementById('RecDiagnosisCurrentDiag').style.height="2vh";
		document.getElementById('RecDiagnosisCurrentDiagLegend').style.height="2vh";
		document.getElementById('RecDiagnosisAddModify').style.height="75vh";
		document.getElementById('RecDiagnosisOpernToolbar').style.height="6vh";
		document.getElementById('blankframe1').style.height="0vh";
		document.getElementById('messageFrame').style.height="8vh";
		</script> -->
		<%}
	}
	%>
	<% 
	if(!isCalledFromCA.equals("Y")){
	 %>  
		<iframe name='pline' id='pline'  	src="../../eCommon/jsp/pline.jsp?EncounterId=<%=Encounter_Id%>" frameborder=0 scrolling=no style="height:<%=height1%>;width:99vw"></iframe>
	<%}%>
		<iframe name='RecDiagnosisCurrentDiagheader' id='RecDiagnosisCurrentDiagheader' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisCurrentDiagHeader.jsp' scrolling='no' frameborder='no' noresize style="height:<%=height2%>;width:99vw"></iframe>
		
		<iframe name='RecDiagnosisCurrentDiag' id='RecDiagnosisCurrentDiag' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?cause_of_death=<%=cause_of_death%>&stage_code=<%=stage_code%>&Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&episode_type=<%=episode_type%>&visit_adm_date=<%=visit_adm_date%>&Practitioner_Id=<%=Practitioner_Id%>&called_from_ip=<%=called_from_ip%>&practitioner_type=<%=practitioner_type%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&term_code=<%=term_code%>&term_set_id=<%=term_set_id%>&modal_yn=<%=modal_yn%>&option_id=<%=option_id%>&accession_num=<%=accession_number%>&oh_chart_num=<%=oh_chart_num%>&p_called_from_widget=<%=p_called_from_widget%>&called_from_ot=<%=called_from_ot%>&function_id=<%=function_id%>' scrolling='auto'  frameborder='no' noresize style="height:<%=height3%>;width:99vw"></iframe> <!--this line Modified for this [CRFPMG2012-CRF-0030] --> <!-- CHL-CRF- 0008 - IN:001472 --><!-- function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-18,2021-->
  

		<iframe name='RecDiagnosisCurrentDiagLegend' id='RecDiagnosisCurrentDiagLegend' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisCurrentDiagLegend.jsp' frameborder='no' scrolling='no' noresize style="height:<%=height4%>;width:99vw"></iframe>
		<iframe name='RecDiagnosisAddModify' id='RecDiagnosisAddModify' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisAddModify.jsp?cause_of_death=<%=cause_of_death%>&stage_code=<%=stage_code%>&Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&episode_type=<%=episode_type%>&visit_adm_date=<%=visit_adm_date%>&Practitioner_Id=<%=Practitioner_Id%>&speciality_code=<%=speciality_code%>&practitioner_type=<%=practitioner_type%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&occur_srl_no=<%=occur_srl_no%>&term_code=<%=term_code%>&term_set_id=<%=term_set_id%>&modal_yn=<%=modal_yn%>&isCalledFromCA=<%=isCalledFromCA%>&mode=<%=mode%>&term_short_desc=<%=term_short_desc%>&accession_num=<%=accession_number%>&option_id=<%=option_id%>&oh_chart_num=<%=oh_chart_num%>&call_from=<%=call_from%>&totalRecords=<%=totalRecords%>&p_called_from_widget=<%=p_called_from_widget%>&called_from_ot=<%=called_from_ot%>&function_id=<%=function_id%>' frameborder='no' scrolling='auto'   style="height:<%=height5%>;width:99vw;" ></iframe> <!--this line Modified for this [CRFPMG2012-CRF-0030] --><!-- CHL-CRF- 0008 - IN:001472 --><!-- function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021-->
		
		<iframe name='RecDiagnosisOpernToolbar' id='RecDiagnosisOpernToolbar' frameborder='no' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisOpernToolbar.jsp?cause_of_death=<%=cause_of_death%>&Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&call_from=<%=call_from%>&p_called_from_widget=<%=p_called_from_widget%>&function_id=<%=function_id%>' scrolling='no' noresize style="height:<%=height6%>;width:99vw"></iframe><!-- function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021-->
		
		<iframe name='blankframe1' id='blankframe1' scrolling='no' src='../../eCommon/html/blank.html'  border=0 noresize frameborder='no' style="height:<%=height7%>;width:99vw"></iframe>
		<iframe name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder='no' noresize border=0 scrolling='auto' style="height:<%=height8%>;width:99vw"></iframe>
		
	
<script>
if('<%=isCalledFromCA%>'=="Y" && '<%=p_called_from_widget%>' ==""){
	if(top.name!=""){ // if condition added by mujafar for ML-MMOH-CRF-1023
		top.plineFrame.document.location.reload();
	}
}
</script>
<%

}catch ( Exception e )
{ 
	//out.println("Expection in try : "+e);
	e.printStackTrace();
}
finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
}
%>
</html>
