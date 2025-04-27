<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
11/09/2013	 IN034512		Karthi L	A print Option existed next to Close Button in Clinical Event History.		
12/09/2013	 IN043274		Karthi L  While printing a radiology resulted note from Clinical Event History>Flow sheet, it printed as empty 	
24/09/2013	 IN043569		Karthi L  "Print" option not displayed for notes recorded through Result Reporting		
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------	
01/12/2014	 IN052367	ChowminyaG 										Signature not published in Result linked clinical notes 												
26/02/2018	 IN065834	Raja S		26/02/2018	Ramesh G	PMG2017-KDAH-CRF-0002			
28/06/2018	IN065341	Prakash C	29/06/2018	Ramesh G	ML-MMOH-CRF-0115
--------------------------------------------------------------------------------------------------------------------
--> 
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<form>
		<%  // added for IN043274 , IN043569 - Start
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");  
		//IN065341 starts
			String bean_id = "ca_CentralizedBean" ;
			String bean_name = "eCA.CentralizedBean";
			CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(localeName);
			bean.clear() ;
			bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
			String enc_id="";
			String fac_id="";
			String called_from=request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
			String RepDb=request.getParameter("RepDb") == null ? "" : request.getParameter("RepDb");
			String clob_data=request.getParameter("clob_data") == null ? "" : request.getParameter("clob_data");
			if(called_from.equals("CDR")){
				enc_id = request.getParameter("enc_id1") == null ? "" : request.getParameter("enc_id1");
				fac_id = request.getParameter("facility_id1") == null ? "" : request.getParameter("facility_id1");
			}else{
				enc_id = request.getParameter("enc_id") == null ? "" : request.getParameter("enc_id");
				fac_id = request.getParameter("fac_id") == null ? "" : request.getParameter("fac_id");
			}
			//IN065341 ends
		String Histrectype = request.getParameter("Histrectype") == null ? "" : request.getParameter("Histrectype");
		String Contrsysid = request.getParameter("Contrsysid") == null ? "" : request.getParameter("Contrsysid");
		String AccessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
		String Contrsyseventcode = request.getParameter("Contrsyseventcode") == null ? "" : request.getParameter("Contrsyseventcode");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		//String enc_id = request.getParameter("enc_id") == null ? "" : request.getParameter("enc_id");commented for IN065341
		//String fac_id = request.getParameter("fac_id") == null ? "" : request.getParameter("fac_id");commented for IN065341
		String note_acc_num				=   AccessionNum;//IN052367
		String contr_mod_accession_num  =  "";//IN065834
		
		String noteHeaderDesc = "";
		String accNumQry  = "";
		Connection con = null;
		PreparedStatement pstmt =	null; 
		ResultSet rs =	null;
		PreparedStatement pstmt1 =	null; 
		ResultSet rs1 =	null;
		
		try{
			con = ConnectionManager.getConnection(request);
			if(called_from.equals("CDR")){
				bean.executeCDR(con,patient_id,enc_id,RepDb,"CA_ENCNTR_NOTE");
			}
		//IN065341 starts	
			//String sqlQuery = "SELECT (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ib, ca_note_type ia WHERE ib.note_group = ia.note_group_id AND ia.note_type = a.note_type AND ib.language_id = ?) note_header_desc FROM ca_encntr_note a WHERE a.accession_num = ?";		
			String sqlQuery = "SELECT (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ##REPDB## ib, ca_note_type ##REPDB## ia WHERE ib.note_group = ia.note_group_id AND ia.note_type = a.note_type AND ib.language_id = ?) note_header_desc FROM ca_encntr_note##CLOB## a WHERE a.accession_num = ?";		
		//IN065341 ends	
			sqlQuery=sqlQuery.replaceAll("##REPDB##",RepDb);
			sqlQuery=sqlQuery.replaceAll("##CLOB##",clob_data);
			pstmt = con.prepareStatement(sqlQuery);

			pstmt.setString(1,locale);
			pstmt.setString(2,AccessionNum);		
			rs = pstmt.executeQuery();
			while(rs.next()){
				noteHeaderDesc		=	rs.getString("note_header_desc")==null?"":rs.getString("note_header_desc") ;
			}

			if("".equals(noteHeaderDesc) || noteHeaderDesc == null){ //IN043274
				if(Contrsysid.equals("RD")){
					if(Character.isDigit(AccessionNum.charAt(0))) { //IN043274
						//accNumQry = "select accession_num from ca_encntr_note where patient_id=? and contr_mod_accession_num in (select OPERATING_FACILITY_ID || REQUEST_NUM || REQUEST_LINE_NUM from rd_exam_view_requested where EXT_APPL_ACCESSION_NUM=?)";//Commented query for IN065834
					//IN065341 starts
						//accNumQry = "select accession_num,contr_mod_accession_num from ca_encntr_note where patient_id=? and contr_mod_accession_num in (select OPERATING_FACILITY_ID || REQUEST_NUM || REQUEST_LINE_NUM from rd_exam_view_requested where EXT_APPL_ACCESSION_NUM=?)";//Modified query for IN065834
						accNumQry = "select accession_num,contr_mod_accession_num from ca_encntr_note##CLOB## where patient_id=? and contr_mod_accession_num in (select OPERATING_FACILITY_ID || REQUEST_NUM || REQUEST_LINE_NUM from rd_exam_view_requested ##REPDB## where EXT_APPL_ACCESSION_NUM=?)";//IN065341
						accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
						accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
					//IN065341 ends	
						pstmt1 = con.prepareStatement(accNumQry);

						pstmt1.setString(1,patient_id);
						pstmt1.setString(2,AccessionNum);	
						
						rs1 = pstmt1.executeQuery();
						while(rs1.next()){
							AccessionNum		=	rs1.getString("accession_num")==null?"":rs1.getString("accession_num") ;
							contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//IN065834
						}
					}
					else 
					{	
						int firstPos = AccessionNum.indexOf('@');
						AccessionNum = AccessionNum.substring(0, firstPos);
						//accNumQry = "SELECT ACCESSION_NUM FROM ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM  = (SELECT OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM FROM rd_exam_view_requested WHERE 'F'||OPERATING_FACILITY_ID||'#'||REQUEST_NUM||'$'||REQUEST_LINE_NUM = ?)";//Commented query for IN065834
					//IN065341 starts
						//accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM  = (SELECT OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM FROM rd_exam_view_requested WHERE 'F'||OPERATING_FACILITY_ID||'#'||REQUEST_NUM||'$'||REQUEST_LINE_NUM = ?)";//Modified query for IN065834
						accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note##CLOB## WHERE CONTR_MOD_ACCESSION_NUM  = (SELECT OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM FROM rd_exam_view_requested ##REPDB## WHERE 'F'||OPERATING_FACILITY_ID||'#'||REQUEST_NUM||'$'||REQUEST_LINE_NUM = ?)";//Modified query for IN065341
						accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
						accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
					//IN065341 ends
						pstmt1 = con.prepareStatement(accNumQry);

						pstmt1.setString(1,AccessionNum);
						rs1 = pstmt1.executeQuery();
						while(rs1.next()){
							AccessionNum =	rs1.getString("accession_num")==null?"":rs1.getString("accession_num") ;
							contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//IN065834
						}
					}
				}	
				else if(Histrectype.equals("LBIN") && Contrsysid.equals("LB")) {
					//accNumQry = "SELECT ACCESSION_NUM from ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM = (SELECT OPERATING_FACILITY_ID|| SPECIMEN_NO || TEST_CODE || SERIAL_NO FROM RL_OLE_RESULT_TEXT WHERE 'F'||OPERATING_FACILITY_ID || '#' || SPECIMEN_NO || '@' || TEST_CODE =?)";//Commented query for IN065834
				//IN065341 starts	
					//accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num from ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM = (SELECT OPERATING_FACILITY_ID|| SPECIMEN_NO || TEST_CODE || SERIAL_NO FROM RL_OLE_RESULT_TEXT WHERE 'F'||OPERATING_FACILITY_ID || '#' || SPECIMEN_NO || '@' || TEST_CODE =?)";//Modified query for IN065834
					accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num from ca_encntr_note##CLOB## WHERE CONTR_MOD_ACCESSION_NUM = (SELECT OPERATING_FACILITY_ID|| SPECIMEN_NO || TEST_CODE || SERIAL_NO FROM RL_OLE_RESULT_TEXT ##REPDB## WHERE 'F'||OPERATING_FACILITY_ID || '#' || SPECIMEN_NO || '@' || TEST_CODE =?)";//Modified query for IN065341
					accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
					accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
				//IN065341 ends
					pstmt1 = con.prepareStatement(accNumQry);
					pstmt1.setString(1,AccessionNum);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){
						AccessionNum		=	rs1.getString("ACCESSION_NUM")==null?"":rs1.getString("ACCESSION_NUM") ;
						contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//Added for IN065834
					}
				}
				else if(Contrsysid.equals("OT")) {
					int firstPos = AccessionNum.indexOf('$');
					AccessionNum = AccessionNum.substring(0, firstPos);
					//accNumQry = "SELECT ACCESSION_NUM FROM ca_encntr_note WHERE SUBSTR(CONTR_MOD_ACCESSION_NUM,1,LENGTH(CONTR_MOD_ACCESSION_NUM)-2) = (SELECT OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE FROM ot_post_oper_hdr WHERE 'F'||OPERATING_FACILITY_ID||'#'||EPISODE_TYPE||EPISODE_ID||'#'||OPER_NUM = ? )";//Commented query for IN065834
				//IN065341 starts
					//accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note WHERE SUBSTR(CONTR_MOD_ACCESSION_NUM,1,LENGTH(CONTR_MOD_ACCESSION_NUM)-2) = (SELECT OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE FROM ot_post_oper_hdr WHERE 'F'||OPERATING_FACILITY_ID||'#'||EPISODE_TYPE||EPISODE_ID||'#'||OPER_NUM = ? )";//Modified query for IN065834
					accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note##CLOB## WHERE SUBSTR(CONTR_MOD_ACCESSION_NUM,1,LENGTH(CONTR_MOD_ACCESSION_NUM)-2) = (SELECT OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE FROM ot_post_oper_hdr ##REPDB## WHERE 'F'||OPERATING_FACILITY_ID||'#'||EPISODE_TYPE||EPISODE_ID||'#'||OPER_NUM = ? )";//Modified query for IN065341
					accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
					accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
				//IN065341 ends	
					pstmt1 = con.prepareStatement(accNumQry);
					pstmt1.setString(1,AccessionNum);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){
						AccessionNum		=	rs1.getString("ACCESSION_NUM")==null?"":rs1.getString("ACCESSION_NUM") ;
						contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//Added for IN065834
					}
				}
				else {
					//accNumQry = "select linked_note_accession_num from OR_RESULT_DETAIL where ORDER_TYPE_CODE ||'!'|| order_id ||'!'|| REPORT_SRL_NO ||'!'|| LINE_SRL_NO ||'!'|| SRL_NO= ?";//Commented query for IN065834
				//IN065341 starts	
					//accNumQry = "select order_id,linked_note_accession_num from OR_RESULT_DETAIL where ORDER_TYPE_CODE ||'!'|| order_id ||'!'|| REPORT_SRL_NO ||'!'|| LINE_SRL_NO ||'!'|| SRL_NO= ?";//Modified query for IN065834
					accNumQry = "select order_id,linked_note_accession_num from OR_RESULT_DETAIL##REPDB## where ORDER_TYPE_CODE ||'!'|| order_id ||'!'|| REPORT_SRL_NO ||'!'|| LINE_SRL_NO ||'!'|| SRL_NO= ?";//Modified query for IN065341
					accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
				//IN065341 ends
					pstmt1 = con.prepareStatement(accNumQry);
					pstmt1.setString(1,AccessionNum);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){
						AccessionNum		=	rs1.getString("linked_note_accession_num")==null?"":rs1.getString("linked_note_accession_num") ;
						contr_mod_accession_num		=	rs1.getString("order_id")==null?"":rs1.getString("order_id") ;//IN065834
					}
				}	
			}	
		}
		catch(Exception ee)
		{
			//out.println(ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}
		finally {
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}	
		// IN043569 End
		//String queryString = "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+AccessionNum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id+"&fac_id="+fac_id;  // commented for IN043274
		//String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8"); // modified for IN043274
		//String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8"); // IN052367	//Commented for IN065834	
		//String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8")+"&contr_mod_accession_num="+java.net.URLEncoder.encode(contr_mod_accession_num,"UTF-8"); // IN052367	//Modified query for IN065834	
		String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8")+"&contr_mod_accession_num="+java.net.URLEncoder.encode(contr_mod_accession_num,"UTF-8")+"&RepDb="+java.net.URLEncoder.encode(RepDb,"UTF-8")+"&clob_data="+java.net.URLEncoder.encode(clob_data,"UTF-8"); // IN065341	
		%>
	<frameset rows="90%,*" border=0 frameborder=0>
	<!-- 	<frame src="../../eCA/jsp/FlowSheetTextMain.jsp?<//%=queryString%>" name="FlowSheetTextMainFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 /> IN043274 -->
		<!-- <frame src="../../eCA/jsp/FlowSheetTextMain.jsp?<%=request.getQueryString()%>" name="FlowSheetTextMainFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 /> --> <!-- IN043274 -->
		<frame src="../../eCA/jsp/FlowSheetTextMain.jsp?<%=queryString%>" name="FlowSheetTextMainFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 /> <!-- IN052367 -->
	
	<frame src="../../eCA/jsp/FlowSheetTextToolbar.jsp?<%=queryString%>" name="FlowsheetToolbarFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 /> <!-- IN034512 -->
	</frameset>
	</form>
</html>

