<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* ,com.ehis.util.* " contentType="text/html;charset=UTF-8"%>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    String locale =((String)session.getAttribute("LOCALE"));
%>
<html>

<head>
	<link type="text/css" rel="stylesheet" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
</head>

<body onKeyDown = 'lockKey()'>
<form name="newborndtls_form" id="newborndtls_form">
<%
		Connection con = null;		

		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String motherid = request.getParameter("mother_id")==null?"": request.getParameter("mother_id");
		String function_id = request.getParameter("function_id")==null?"": request.getParameter("function_id");
		String function_id_new = request.getParameter("function_id_new")==null?"": request.getParameter("function_id_new");
		String encounter_id = request.getParameter("encounter_id")==null?" ": request.getParameter("encounter_id");
		String nursing_unit = request.getParameter("nursing_unit")==null?"": request.getParameter("nursing_unit");
		String siteId = request.getParameter("siteId")==null?"":request.getParameter("siteId");

		/*
		String unit_of_wt_nb = request.getParameter("unit_of_wt_nb")==null?"": request.getParameter("unit_of_wt_nb");
		String unit_of_circum_nb = request.getParameter("unit_of_circum_nb")==null?"": request.getParameter("unit_of_circum_nb");
		String unitofchestunit = request.getParameter("unitofchestunit")==null?"": request.getParameter("unitofchestunit");
		String unit_of_length_nb = request.getParameter("unit_of_length_nb")==null?"": request.getParameter("unit_of_length_nb");
		String unit_of_gest_nb = request.getParameter("unit_of_gest_nb")==null?"": request.getParameter("unit_of_gest_nb");
		String patient_id_length = request.getParameter("patient_id_length")==null?"": request.getParameter("patient_id_length");
		String name_suffix_male_nb = request.getParameter("name_suffix_male_nb")==null?"": request.getParameter("name_suffix_male_nb");
		String name_suffix_female_nb = request.getParameter("name_suffix_female_nb")==null?"": request.getParameter("name_suffix_female_nb");
		*/

		String inhouse_birth_yn = request.getParameter("inhouse_birth_yn")==null?"": request.getParameter("inhouse_birth_yn"); 
		String new_born_pat_ser_grp = request.getParameter("new_born_pat_ser_grp")==null?"": request.getParameter("new_born_pat_ser_grp");
		String nb_use_mother_ser = request.getParameter("nb_use_mother_ser")==null?"": request.getParameter("nb_use_mother_ser");

		//String allow_nb_regn_within_days = request.getParameter("allow_nb_regn_within_days")==null?"": request.getParameter("allow_nb_regn_within_days");

		String accessRights = request.getParameter("accessRights")==null?"": request.getParameter("accessRights");
		String parent_details = request.getParameter("parent_details")==null?"": request.getParameter("parent_details");
		parent_details = java.net.URLEncoder.encode(parent_details);

		//String alt_id_type_desc = request.getParameter("alt_id_type_desc")==null?"": request.getParameter("alt_id_type_desc");

		String function_invoked = request.getParameter("function_invoked")==null?"": request.getParameter("function_invoked");
		String called_from_mothercare = request.getParameter("called_from_mothercare")==null?"": request.getParameter("called_from_mothercare");
		String module_invoked = request.getParameter("module_invoked")==null?"": request.getParameter("module_invoked");
		String mother_nursing_unit = request.getParameter("mother_nursing_unit")==null?"": request.getParameter("mother_nursing_unit");
		String mother_bed_no = request.getParameter("mother_bed_no")==null?"": request.getParameter("mother_bed_no");
		String function_name = request.getParameter("function_name")==null?"": request.getParameter("function_name");		
		String disable_button_yn = request.getParameter("disable_button_yn")==null?"": request.getParameter("disable_button_yn");
        String invoke_adm_from_newborn_yn =                                    request.getParameter("invoke_adm_from_newborn_yn")==null?"": request.getParameter("invoke_adm_from_newborn_yn");
        String calling_module_id =                                    request.getParameter("calling_module_id")==null?"": request.getParameter("calling_module_id");	
        String exceedMaxBirthYN =                                    request.getParameter("exceedMaxBirthYN")==null?"N": request.getParameter("exceedMaxBirthYN");		
        String newTransactionYN =                                    request.getParameter("newTransactionYN")==null?"Y": request.getParameter("newTransactionYN");		
		String isNewBornChngsAppl = request.getParameter("isNewBornChngsAppl")==null?"false": request.getParameter("isNewBornChngsAppl");		
		
		String birth_date="";
	    String birth_date_time="";
	    String birth_time="";
	    String speciality="";	  
	    String baby_bed_no="";	  
		String patientid ="";
		String outcome ="";
		String finalized_yn ="";
		String pat_ser_grp_code ="";
		String pat_ser_grp_desc ="";
		String regnStatusStyle  ="";
		
		String born_where=""; //Added for this CRF ML-MMOH-CRF-0621
		
		String mother_pat_id="";//Added for this HSA-CRF-0182 linked incident [54168]
		
	    String resuscitated_pract_id="", resuscitated_pract_desc=""; //Added for this CRF ML-MMOH-CRF-0621
		
	
	%>

	<script language="JavaScript">

		function changeToolBar(calling_module_id) {
			var accessRights = parent.newbornmain_frame.document.getElementById('accessRights').value;
			if(calling_module_id == 'IP' || calling_module_id == 'AE')
				home_required_yn = 'N';
			else 
				home_required_yn = 'Y';
			parent.parent.commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?module_id=MP&function_id=NEWBORN_REG&function_name=Register New Born&function_type=F&access='+accessRights+'&home_required_yn='+home_required_yn;
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		}

		async function callAdmitPatient(patientId,calling_module_id)
		{
			var dialogHeight = '90vh';
			var dialogWidth = '90vw';
			var wintop = '65';
			var retVal = "";
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
			var arguments = '';			
			var param = "../../eIP/jsp/AdmitPatient.jsp?module_id=IP&function_id=NEWBORN_REG&access=NYNNN&patient_id="+patientId+"&&home_required_yn=N";

			retVal = await top.window.showModalDialog(param,arguments,features);
			parent.newborndtls_frame.location.href = self.location.href; 			
			
			if(retVal == undefined || retVal == true) {
				changeToolBar(calling_module_id);
			} 	
			
		}

		async function callRegisterAttendance(patientId,calling_module_id){
			var dialogHeight = '45';
			var dialogWidth = '64';
			var wintop = '65';
			var retVal = "";
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
			var arguments = '';			
			var param = "../../eAE/jsp/AERegisterAttn.jsp?patient_id="+patientId+"&menu_id=AE&module_id=AE&function_id=AE_REGISTER_ATTN&function_type=F&access=NYNNN&desktopFlag=N&invoke_from=EMER_REGN_NB&function_name=Register Attendance";

			retVal = await window.showModalDialog(param,arguments,features);
			parent.newborndtls_frame.location.href = self.location.href; 			
			
			if(retVal == undefined || retVal == true) {
				changeToolBar(calling_module_id);
			} 	
		}

		function callOnlineReports(patientID,pat_ser_grp_code,encounter_id,mother_nursing_unit,function_id_new,outcome){
			if(patientID!=null) 
			{
					 var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' method='post' action='../../eMP/jsp/GetRelationship.jsp'><input type='hidden' name='callfunction' value='callOnlineReports'><input type='hidden' name='patient_id1' value="+patientID+"><input type='hidden' name='pat_ser_grp_code' value = '"+pat_ser_grp_code+"'><input type='hidden' name='encounter_id' value="+encounter_id+"><input type='hidden' name='mother_nursing_unit' value="+mother_nursing_unit+"><input type='hidden' name='function_id' value="+function_id_new+"><input type='hidden' name='outcome' value="+outcome+"></form></body></html>";
					 parent.parent.frames[2].document.write(HTMLVal);
					 parent.parent.frames[2].document.tempform1.submit();				 
			}		
		}

		async function callChangePatDtls(patientId,calling_module_id)
		{
			var dialogHeight = '90vh';
			var dialogWidth = '80vw';
			var wintop = '';

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
			var arguments = '';
			var retVal = '';
			
			var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=Y&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patientId;
			var retVal = await top.window.showModalDialog(param,arguments,features);

			parent.newborndtls_frame.location.href = self.location.href;
			
			if(retVal == undefined || retVal == true) {
				changeToolBar(calling_module_id);
			} 			
		}
		
        //Below function parameter modified for this CRF  HSA-CRF-0182 linked incident [54168]
		function viewPatDtls(patientID,function_id,function_id_new,encounter_id,nursing_unit,inhouse_birth_yn,nb_use_mother_ser,accessRights,parent_details,function_invoked,module_invoked,mother_nursing_unit,mother_bed_no,function_name,disable_button_yn,invoke_adm_from_newborn_yn,outcome,calling_module_id,finalized_yn,pat_ser_grp_code,pat_ser_grp_desc,newTransactionYN,called_from_mothercare,siteId,mother_pat_id,resuscitated_pract_id,born_where,isNewBornChngsAppl)
		{   
			var nbMainJsp		= "NewbornRegistrationMain.jsp";
			if(calling_module_id=="IP" && isNewBornChngsAppl=="true"){
				nbMainJsp		= "NewbornRegistrationMainSLY.jsp";
			}
			if(finalized_yn == 'Y'){
				var ip_install_yn =parent.newbornmain_frame.document.forms[0].ip_install_yn.value;
				parent.newbornheader_frame.location.href="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id="+patientID+"&function_id_new=MAINTAIN_BIRTH&invoked_from=details_page&calling_module_id="+calling_module_id+"&chd_id="+patientID+"&pat_ser_grp_code="+pat_ser_grp_code+"&pat_ser_grp_desc="+pat_ser_grp_desc+"&buttonType=R&disable_button_yn=Y"; 
				parent.newbornmain_frame.location.href="../../eMP/jsp/"+nbMainJsp+"?mother_id="+patientID+"&function_id="+function_id+"&function_id_new="+function_id_new+"&encounter_id="+encounter_id+"&nursing_unit="+nursing_unit+"&inhouse_birth_yn="+inhouse_birth_yn+"&nb_use_mother_ser="+nb_use_mother_ser+"&accessRights="+accessRights+"&parent_details="+parent_details+"&function_invoked="+function_invoked+"&module_invoked="+module_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name+"&invoke_adm_from_newborn_yn="+invoke_adm_from_newborn_yn+"&disable_button_yn="+disable_button_yn+"&invoked_from=details_page&calling_module_id="+calling_module_id+"&newTransactionYN="+newTransactionYN+"&regnStatus=F&finalizeYN=Y&siteId="+siteId+"&ip_install_yn="+ip_install_yn+"&mother_pat_id="+mother_pat_id+"&finalized_mult_birth_yn="+finalized_yn+"&disable_finalized_button_yn=Y&resuscitated_pract_id="+resuscitated_pract_id+"&born_where="+born_where+"&outcome="+outcome+"&newbornReg=Y&isNewBornChngsAppl="+isNewBornChngsAppl+"";  //Added for this CRF ML-MMOH-CRF-0621

			} else if(finalized_yn == 'N'){

				
				if(confirm("Do you want to Finalize")) {
					var ip_install_yn =parent.newbornmain_frame.document.forms[0].ip_install_yn.value;
					parent.newbornheader_frame.location.href="../../eMP/jsp/NewbornRegistrationHeader.jsp?mother_id="+patientID+"&function_id_new=MAINTAIN_BIRTH&invoked_from=details_page&calling_module_id="+calling_module_id+"&chd_id="+patientID+"&pat_ser_grp_code="+pat_ser_grp_code+"&pat_ser_grp_desc="+pat_ser_grp_desc+"&buttonType=F&disable_button_yn=N"; 
					var url="../../eMP/jsp/"+nbMainJsp+"?mother_id="+patientID+"&function_id="+function_id+"&function_id_new="+function_id_new+"&encounter_id="+encounter_id+"&nursing_unit="+nursing_unit+"&inhouse_birth_yn="+inhouse_birth_yn+"&nb_use_mother_ser="+nb_use_mother_ser+"&accessRights="+accessRights+"&parent_details="+parent_details+"&function_invoked="+function_invoked+"&module_invoked="+module_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name+"&invoke_adm_from_newborn_yn="+invoke_adm_from_newborn_yn+"&disable_button_yn="+disable_button_yn+"&invoked_from=details_page&outcome="+outcome+"&calling_module_id="+calling_module_id+"&newTransactionYN="+newTransactionYN+"&regnStatus=R&finalizeYN=Y&called_from_mothercare="+called_from_mothercare+"&siteId="+siteId+"&ip_install_yn="+ip_install_yn+"&mother_pat_id="+mother_pat_id+"&finalized_mult_birth_yn="+finalized_yn+"&disable_finalized_button_yn=N&resuscitated_pract_id="+resuscitated_pract_id+"&born_where="+born_where+"&newbornReg=Y&isNewBornChngsAppl="+isNewBornChngsAppl+"";  //Added for this CRF ML-MMOH-CRF-0621
					parent.newbornmain_frame.location.href=url;
				}else{
					callOnlineReports(patientID,pat_ser_grp_code,encounter_id,mother_nursing_unit,function_id_new,outcome);
				}
			}
			//var accessRights=frm.accessRights.value;
		}
	</script>
	
	<%
	try{
		con = ConnectionManager.getConnection(request);				
		if (rset != null) rset.close();
        //Below line modified for this CRF  HSA-CRF-0182 linked incident [54168]
		String sql = "SELECT /*+index(b mp_patient_pk)*/ TO_CHAR(a.TIME_OF_BIRTH,'dd/mm/yyyy'),  TO_CHAR(a.TIME_OF_BIRTH,'hh24:mi'), a.OUTCOME, a.NB_SEX, DECODE('"+locale+"', 'en', b.patient_name, NVL(b.patient_name_loc_lang, b.patient_name)) patient_name, a.PATIENT_ID, a.WEIGHT, a.WEIGHT_UNIT,  AM_GET_DESC.AM_PRACTITIONER(a.attend_physician_id,'"+locale+"','1') practitioner_name, DECODE(c.BED_NO,NULL, d.bed_num,c.bed_no) bed_no, ip_get_desc.ip_nursing_unit(DECODE(c.facility_id,NULL,d.facility_id,c.facility_id),DECODE(c.nursing_unit_code,NULL,d.nursing_unit_code,c.nursing_unit_code),'"+locale+"','1') nursing_unit_desc , Am_Get_desc.Am_speciality(DECODE(c.specialty_code,NULL,d.specialty_code,c.specialty_code),'"+locale+"','1') speciality, a.finalized_yn, b.pat_ser_grp_code pat_ser_grp_code, mp_get_desc.mp_pat_ser_grp(b.pat_ser_grp_code,'"+locale+"',2) pat_ser_grp_desc,a.mother_patient_id mother_patient_id, a.resuscitated_pract_id, am_get_desc.am_practitioner(a.resuscitated_pract_id,'"+locale+"',1) resuscitated_pract_desc, a.bba_yn FROM mp_birth_register a, mp_patient b, ip_nursing_unit_bed c, ip_open_encounter d WHERE a.MOTHER_PATIENT_ID='"+motherid+"' AND a.patient_id = b.patient_id AND c.OCCUPYING_PATIENT_ID(+)=a.patient_id AND d.patient_id(+) = a.patient_id order by a.birth_order, a.time_of_birth";


	
		pstmt = con.prepareStatement(sql.toString());
		rset = pstmt.executeQuery();
		int i=0;
		//String classValue = "";		
		String birth_weight = "";
         
		if(rset!=null && rset.next())
		{	
				%>		
			<table border=1 cellpadding=0 cellspacing=0 width='100%'>
				<tr>			
					
		<td class="COLUMNHEADER" align='center'><B><fmt:message key='eMP.NewbornID.label' bundle='${mp_labels}'/></B></td>
				<%  if((calling_module_id.equals("IP") & invoke_adm_from_newborn_yn.equals("Y")) || calling_module_id.equals("AE"))
			         {
					    %>
						<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.Task.label' bundle='${common_labels}'/></B></td>
				<%  }  %>
				
		<td class="COLUMNHEADER" align='center'><B><fmt:message key='eMP.BabyName.label' bundle='${mp_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.birthDate.label' bundle='${common_labels}'/>/<fmt:message key='Common.time.label' bundle='${common_labels}'/><input type='hidden' name='motherid' id='motherid' value='<%=motherid%>'></B>
					</td>				
			        <td class="COLUMNHEADER" align='center'><B><fmt:message key='eMP.BirthWeight.label' bundle='${mp_labels}'/></B>
					<input type='hidden' name='newbornpatsergrp' id='newbornpatsergrp' value="<%=new_born_pat_ser_grp%>">
					<input type='hidden' name='nb_use_mother_ser' id='nb_use_mother_ser' value="<%=nb_use_mother_ser%>">
					<input type='hidden' name='exceedMaxBirthYN' id='exceedMaxBirthYN' value="<%=exceedMaxBirthYN%>">
					</td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.status.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.speciality.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.nursingUnit.label' bundle='${common_labels}'/></B></td>
					<td class="COLUMNHEADER" align='center'><B><fmt:message key='Common.bedno.label' bundle='${common_labels}'/></B></td>
				</tr>
			<%
			do
			{
				i++;

				/*
				if(i%2 == 0) 
					classValue="QRYEVEN";
				else
					classValue = "QRYODD";
				*/

				patientid = rset.getString("PATIENT_ID");
				nursing_unit = rset.getString("nursing_unit_desc")==null?"":rset.getString("nursing_unit_desc");
				speciality = rset.getString("speciality")==null?"":rset.getString("speciality");
				finalized_yn = rset.getString("finalized_yn")==null?"N":rset.getString("finalized_yn");
				pat_ser_grp_code = rset.getString("pat_ser_grp_code")==null?"":rset.getString("pat_ser_grp_code");
				pat_ser_grp_desc = rset.getString("pat_ser_grp_desc")==null?"":rset.getString("pat_ser_grp_desc");
				outcome = rset.getString("OUTCOME")==null?"":rset.getString("OUTCOME");
				//Below line Added for this CRF  HSA-CRF-0182 linked incident [54168]
				mother_pat_id=rset.getString("mother_patient_id")==null?"":rset.getString("mother_patient_id");
				
				/*Below line added for this CRF ML-MMOH-CRF-0621*/
				resuscitated_pract_id=rset.getString("resuscitated_pract_id")==null?"":rset.getString("resuscitated_pract_id");
				resuscitated_pract_desc=rset.getString("resuscitated_pract_desc")==null?"":rset.getString("resuscitated_pract_desc"); 
				born_where=rset.getString("bba_yn")==null?"":rset.getString("bba_yn"); 
				//End ML-MMOH-CRF-0621
				
				if(finalized_yn.equals("Y")) {
					//out.println("<tr style='background-color:#00FFFF'>");
					regnStatusStyle = "style='background-color:#00FFFF'";
				} else if(finalized_yn.equals("N")) {					
					//out.println("<tr style='background-color:#FECBFA'>");
					regnStatusStyle = "style='background-color:#FECBFA'";
				} 								
				//Below line modified for this CRF  HSA-CRF-0182 linked incident [54168]
				/*Below line added for this CRF ML-MMOH-CRF-0621*/
				%>
				<td <%=regnStatusStyle%> ><a href="javascript:viewPatDtls('<%=patientid%>','<%=function_id%>','<%=function_id_new%>','<%=encounter_id%>','<%=nursing_unit%>','<%=inhouse_birth_yn%>','<%=nb_use_mother_ser%>','<%=accessRights%>','<%=parent_details%>','<%=function_invoked%>','<%=module_invoked%>','<%=mother_nursing_unit%>','<%=mother_bed_no%>','<%=function_name%>','<%=disable_button_yn%>','<%=invoke_adm_from_newborn_yn%>','<%=outcome%>','<%=calling_module_id%>','<%=finalized_yn%>','<%=pat_ser_grp_code%>','<%=pat_ser_grp_desc%>','<%=newTransactionYN%>','<%=called_from_mothercare%>','<%=siteId%>','<%=mother_pat_id%>','<%=resuscitated_pract_id%>','<%=born_where%>','<%=isNewBornChngsAppl%>')"><%=patientid%></td>

				<%

				if(calling_module_id.equals("IP") & invoke_adm_from_newborn_yn.equals("Y")) {
					out.println("<td "+regnStatusStyle+" ><a href=\"javascript:callAdmitPatient('"+patientid+"','"+calling_module_id+"')\"> "+   com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admit.label","common_labels")+"</a></td>");
				} else if(calling_module_id.equals("AE")) {
					out.println("<td "+regnStatusStyle+" ><a href=\"javascript:callRegisterAttendance('"+patientid+"','"+calling_module_id+"')\"> "+   com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterAttendance.label","common_labels")+"</a></td>");
				}

				if(finalized_yn.equals("Y")) {
					out.println("<td "+regnStatusStyle+" >"+rset.getString(5)+"</td>");
				} else {
					out.println("<td "+regnStatusStyle+" ><a href=\"javascript:callChangePatDtls('"+patientid+"','"+calling_module_id+"')\">"+rset.getString(5)+"</a></td>");
				}
				
				baby_bed_no = rset.getString("bed_no")==null?"":rset.getString("bed_no");						
				birth_date=rset.getString(1)==null?"":rset.getString(1);
				birth_time=rset.getString(2)==null?"":rset.getString(2);			birth_date=DateUtils.convertDate(birth_date,"DMY","en",localeName);
				birth_date_time=birth_date+" "+birth_time;
				if(birth_date_time.equals(" "))
					birth_date_time = "&nbsp;";
					
				out.println("<td "+regnStatusStyle+" >"+birth_date_time+"</td>");
			 
		  %>
		  <%  
				
				birth_weight = rset.getString(7)==null?"":rset.getString(7);
				String weight_unit=rset.getString(8)==null?"":rset.getString(8);
				if(weight_unit.toUpperCase().equals("K"))
                {					weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.kg.label","common_labels");
				}
				else if(weight_unit.toUpperCase().equals("L"))
                {			   weight_unit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.lb.label","common_labels");
				}
				if(!birth_weight.equals(""))
					out.println("<td "+regnStatusStyle+" >"+birth_weight+" "+weight_unit+"</td>");
				else
					out.println("<td "+regnStatusStyle+" >"+birth_weight+"</td>");

				if(finalized_yn.equals("Y")) {												out.println("<td "+regnStatusStyle+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalized.label","common_labels")+"</td>");
				} else if(finalized_yn.equals("N")) {					out.println("<td "+regnStatusStyle+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Registered.label","common_labels")+"</td>");
				}

				if(!speciality.equals(""))
				{
				out.println("<td "+regnStatusStyle+">"+speciality+ "</td>");
				}
				else
				{
				  out.println("<td "+regnStatusStyle+">"+"&nbsp"+ "</td>");
				}
				if(!nursing_unit.equals(""))
				{
					out.println("<td "+regnStatusStyle+">"+ nursing_unit+"</td>");
			    } else {
					out.println("<td "+regnStatusStyle+">"+"&nbsp"+ "</td>");
				}
				if(!baby_bed_no.equals(""))
				{
					out.println("<td "+regnStatusStyle+">"+ baby_bed_no+"</td>");
				} else {
					out.println("<td "+regnStatusStyle+">"+"&nbsp"+ "</td>");
				}
				out.println("</tr>");
			}while(rset.next());
			out.println("</table><table border='1' cellpadding=0 cellspacing=0 width='100%'><tr><td width = '5%' bordercolor='black' style='background-color:#FECBFA' >&nbsp;</td><td width = '25%'> &nbsp;" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FirstStageRegistrationRecords.label","mp_labels")+"</td><td width = '5%' bordercolor='black' style='background-color:#00FFFF'> &nbsp;</td><td width = '25%'> &nbsp;" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FinalizedRecords.label","mp_labels")+"</td><td width='40%'>&nbsp;</td></tr></table>");
			
		}
		
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

