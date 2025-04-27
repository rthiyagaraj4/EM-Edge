<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<html>
	<head>
		<title>
			<fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/>
		</title>
		<script src='../../eOA/js/OAPatientInstructions.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>

	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String patInsTabYN="";
		String procInsTabYN="";
		Connection connection = null;
		Statement stmt = null;
		ResultSet rset = null;
		PreparedStatement pstmt=null;
		HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
		String locale=(String)session.getAttribute("LOCALE");
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");		
		String clinicInsYN=request.getParameter("clinicInsYN")==null?"":request.getParameter("clinicInsYN");		
		String orderInsYN=request.getParameter("orderInsYN")==null?"N":request.getParameter("orderInsYN");		
		String orderInsStandardYN=request.getParameter("orderInsStandardYN")==null?"N":request.getParameter("orderInsStandardYN");		
		String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");		
		String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
		String appt_refno=request.getParameter("appt_refno")==null?"":request.getParameter("appt_refno");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String pending_order_catalog_code=request.getParameter("pending_order_catalog_code")==null?"":request.getParameter("pending_order_catalog_code");
		String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String date_of_birth=request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String rows="";
		String height1="0vh";
		String height2="0vh";
		String height3="0vh";
		String rd_appt_yn = request.getParameter("rd_appt_yn")==null?"":request.getParameter("rd_appt_yn"); // Modified against PMG20089-CRF-0885.3
		try{
			if(from_page.equals("transfer_appt") || from_page.equals("modifyappt")){
				if(clinicInsYN.equals("Y") && orderInsYN.equals("Y")){
					//rows="5%,*,12%"; 
					height1="5vh";
					height2="80vh";
					height3="12vh";
					procInsTabYN="Y";
					patInsTabYN="Y";
				}else{
					//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
				}
			}else if(from_page.equals("book_appt")){
				connection = ConnectionManager.getConnection(request);
				if(orderInsYN.equals("Y") && orderInsStandardYN.equals("Y")){
				}else if(orderInsYN.equals("Y") && orderInsStandardYN.equals("N")){
					if(orderInsYN.equals("Y") && orderInsStandardYN.equals("N")){
						if(or_catalogue_code!=null && !(or_catalogue_code.equals(""))){
							//String order_catalog_std_ins="select PAT_PREPS_OR_INSTRNS_IND,PAT_PREPS_OR_INSTRNS_TXT,CALC_MIN_AGE_IN_DAYS, CALC_MAX_AGE_IN_DAYS,SEX_SPEC_IND from or_catalog_prep_instrn_lang where ORDER_CATALOG_CODE='"+or_catalogue_code+"' and language_id='"+locale+"' AND sex_spec_ind in ('N','"+gender+"') and PAT_PREPS_OR_INSTRNS_IND ='IM' and trunc(sysdate)-to_date('"+date_of_birth+"','dd/mm/yyyy') between calc_min_age_in_days and calc_max_age_in_days";
							String order_catalog_std_ins="select PAT_PREPS_OR_INSTRNS_IND,PAT_PREPS_OR_INSTRNS_TXT,CALC_MIN_AGE_IN_DAYS, CALC_MAX_AGE_IN_DAYS,SEX_SPEC_IND from or_catalog_prep_instrn_lang where ORDER_CATALOG_CODE=? and language_id=? AND sex_spec_ind in ('N',?) and PAT_PREPS_OR_INSTRNS_IND ='IM' and trunc(sysdate)-to_date(?,'dd/mm/yyyy') between calc_min_age_in_days and calc_max_age_in_days";
							//stmt=connection.createStatement();
							//rset=stmt.executeQuery(order_catalog_std_ins);
							pstmt = connection.prepareStatement(order_catalog_std_ins);
							pstmt.setString(1,or_catalogue_code);
							pstmt.setString(2,locale);
							pstmt.setString(3,gender);
							pstmt.setString(4,date_of_birth);
							rset = pstmt.executeQuery();
							if(rset!=null && rset.next()){
								String pat_preps_or_instrns_txt=rset.getString("PAT_PREPS_OR_INSTRNS_TXT");
								String gender_ind=rset.getString("SEX_SPEC_IND");
								int calc_min_age_in_days=rset.getInt("CALC_MIN_AGE_IN_DAYS");
								int calc_max_age_in_days=rset.getInt("CALC_MAX_AGE_IN_DAYS");
								if(prcInstructionMap.size() > 0){
									int map_min_age=Integer.parseInt((String)(prcInstructionMap.get("min_age")==null?"0":prcInstructionMap.get("min_age")));
									int map_max_age=Integer.parseInt((String)(prcInstructionMap.get("max_age")==null?"0":prcInstructionMap.get("max_age")));
									String map_gender=(String)prcInstructionMap.get("sex_spec_ind");
									if((calc_min_age_in_days==map_min_age) && (calc_max_age_in_days==map_max_age)){
										if(!(gender_ind.equals(map_gender))){
											prcInstructionMap.put("prcIns",pat_preps_or_instrns_txt);
											prcInstructionMap.put("checked","Y");
											prcInstructionMap.put("min_age",(new Integer(calc_min_age_in_days)).toString());
											prcInstructionMap.put("max_age",(new Integer(calc_max_age_in_days)).toString());
											prcInstructionMap.put("sex_spec_ind",gender_ind);
											session.setAttribute("prcInstructionMap", prcInstructionMap);
										}
									}else{
										prcInstructionMap.put("prcIns",pat_preps_or_instrns_txt);
										prcInstructionMap.put("checked","Y");
										prcInstructionMap.put("min_age",(new Integer(calc_min_age_in_days)).toString());
										prcInstructionMap.put("max_age",(new Integer(calc_max_age_in_days)).toString());
										prcInstructionMap.put("sex_spec_ind",gender_ind);
										session.setAttribute("prcInstructionMap", prcInstructionMap);
									}
								}else{
									prcInstructionMap.put("prcIns",pat_preps_or_instrns_txt);
									prcInstructionMap.put("checked","Y");
									prcInstructionMap.put("min_age",(new Integer(calc_min_age_in_days)).toString());
									prcInstructionMap.put("max_age",(new Integer(calc_max_age_in_days)).toString());
									prcInstructionMap.put("sex_spec_ind",gender_ind);
									session.setAttribute("prcInstructionMap", prcInstructionMap);
								}
							}else{
								prcInstructionMap.clear();
								session.setAttribute("prcInstructionMap", prcInstructionMap);
							}
						}
					}
				}else{
					//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
					procInsTabYN="N";
					patInsTabYN="N";
				}
				//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
				if(clinicInsYN.equals("Y") && orderInsYN.equals("Y")){
					//rows="5%,*,12%";
					height1="5vh";
					height2="80vh";
					height3="12vh";
					procInsTabYN="Y";
					patInsTabYN="Y";
				}
			}else if(from_page.equals("view_dtls")){
				connection = ConnectionManager.getConnection(request);
				stmt=connection.createStatement();
				HashMap patInstructionsMapResult=new java.util.HashMap();
				HashMap procInstructionsMapResult=new java.util.HashMap();
				String order_stand_ins="";
				//String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityId+"' AND appt_ref_no = '"+appt_refno+"' ORDER BY display_order";
				String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = ? AND appt_ref_no = ? ORDER BY display_order";
				
				//rset=stmt.executeQuery(appt_pat_ins);
				pstmt = connection.prepareStatement(appt_pat_ins);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,appt_refno);
				rset = pstmt.executeQuery();
				int clinicInstructionsCount=1;
				Integer tempInteger=null;
				while(rset!=null && rset.next()){
						String instructionID=rset.getString("instruction_id");
						String instructionDesc=rset.getString("instruction_desc");
						String valueObject=instructionID+"|~"+instructionDesc+"|~"+"Y";
						tempInteger=new Integer(clinicInstructionsCount);
						patInstructionsMapResult.put(tempInteger.toString(),valueObject);
						clinicInstructionsCount++;
				}
				if(clinicInstructionsCount > 1){
					clinicInsYN="Y";
					session.setAttribute("patInstructionsMap", patInstructionsMapResult);
				}
				//String appt_prc_ins="SELECT INSTRUCTION_DESC FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityId+"' AND appt_ref_no = '"+appt_refno+"'";
				String appt_prc_ins="SELECT INSTRUCTION_DESC FROM oa_appt_proc_instructions WHERE facility_id = ? AND appt_ref_no = ? ";
				int countProcInstructions=1;
				//rset=stmt.executeQuery(appt_prc_ins);
				pstmt = connection.prepareStatement(appt_prc_ins);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,appt_refno);
				rset = pstmt.executeQuery();
				if(rset!=null && rset.next()){
					order_stand_ins=rset.getString("INSTRUCTION_DESC");
					countProcInstructions++;
				}
				if(countProcInstructions>1){
					orderInsYN="Y";
					procInstructionsMapResult.put("prcIns",order_stand_ins);
					procInstructionsMapResult.put("checked","Y");
					session.setAttribute("prcInstructionMap", procInstructionsMapResult);
				}
				//rows="0%,*,12%";
					height1="0vh";
					height2="84vh";
					height3="12vh";
				if(clinicInsYN.equals("Y") && orderInsYN.equals("Y")){
					//rows="5%,*,12%";
					height1="5vh";
					height2="80vh";
					height3="12vh";
					procInsTabYN="Y";
					patInsTabYN="Y";
				}
			}
	%>
	<!-- Passing Radiology Appt for PMG20089-CRF-0885.3-->
	<!--<frameset name='patinsmain' id='patinsmainID' rows='<%=rows%>'>  -->
		<iframe name='patinstabframe' id='patinstabframe' style='height:<%=height1%>;width:100vw' src='../../eOA/jsp/OAPatientInstructionsTabs.jsp?patInsTabYN=<%=patInsTabYN%>&procInsTabYN=<%=procInsTabYN%>&rd_appt_yn=<%=rd_appt_yn%>' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0'></iframe>
		<iframe name='patinsframe' id='patinsframe' style='height:<%=height2%>;width:100vw' src='../../eOA/jsp/OAPatientInstructions.jsp?from_page=<%=from_page%>&clinic_code=<%=clinic_code%>&or_catalogue_code=<%=or_catalogue_code%>&pending_order_catalog_code=<%=pending_order_catalog_code%>&order_id=<%=order_id%>&order_line_num=<%=order_line_num%>&clinicInsYN=<%=clinicInsYN%>&orderInsYN=<%=orderInsYN%>&orderInsStandardYN=<%=orderInsStandardYN%>&patient_id=<%=patient_id%>&gender=<%=gender%>&date_of_birth=<%=date_of_birth%>&appt_refno=<%=appt_refno%>&viewinsdtlsYN=N' frameborder=0 noresize scrolling='auto' marginheight='0' marginwidth='0'></iframe>
		<iframe name='patinsbuttonframe' id='patinsbuttonframe' style='height:<%=height3%>;width:100vw' src='../../eOA/jsp/OAPatientInstructionsButtons.jsp?viewinsdtlsYN=<%=viewinsdtlsYN%>&from_page=<%=from_page%>&clinicInsYN=<%=clinicInsYN%>&orderInsYN=<%=orderInsYN%>' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0'></iframe>
	<!--  </frameset> -->
<!-- 	<frameset name='patinsmain' id='patinsmainID'>
		<frame name='patientinstructionsframe' id='patientinstructionsframe' src='../../eOA/jsp/OAPatientInstructions.jsp?clinic_code=<%=clinic_code%>' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0'>
	</frameset> -->
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
	}
%>
</html>

	


