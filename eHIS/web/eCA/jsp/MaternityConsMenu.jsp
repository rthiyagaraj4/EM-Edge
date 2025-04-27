<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/MaternityMenuTree.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src='../../eCA/js/RecMaternityCons.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String splty_title_event_desc=request.getParameter("splty_title_event_desc") == null ? "" : request.getParameter("splty_title_event_desc");
	String sel_cycle_no=request.getParameter("sel_cycle_no") == null ? "0" : request.getParameter("sel_cycle_no");
	String cycle_status=request.getParameter("cycle_status");
	String boldText = "";
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String delivery_indicator = "";
	String transDateQryNew ="";
	String deli_rec_facility_id ="";

	int cycle_no=0;
	
	
	//Querires to fecth the data
	String event_SQL="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_STATUS,CA_GET_DESC.CA_SPLTY_EVENT(SPLTY_EVENT_CODE,?,'1')||decode(ADDITIONAL_EVENT_YN,'Y','#','') SPLTY_EVENT_DESC FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE  PATIENT_ID =? AND MODULE_ID=? AND CYCLE_NO=? ORDER BY ADDITIONAL_EVENT_YN,SPLTY_EVENT_START_DATE";
	
	String menuSql="SELECT A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,nvl(A.NUMB_OF_TRANS_ALLOWED,9999),A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE  SPLTY_EVENT_CODE=? AND MODULE_ID=?  AND HEADER_SPLTY_TASK_CODE IS NULL /*and (A.SPLTY_TASK_CODE!='MCT001' or not exists (select 1 from CA_PAT_SPLTY_EPISODE_TASK where PATIENT_ID=? AND FACILITY_ID	=? AND MODULE_ID=? AND CYCLE_NO=? and A.SPLTY_TASK_CODE='MCT001' ))*/ ORDER BY ORDER_SEQ_NO";

	String actionSQL="SELECT A.ACTION_CODE,CASE WHEN A.SPLTY_TASK_TYPE='NT' THEN CA_GET_DESC.CA_NOTE_TYPE(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE='CH' THEN CA_GET_DESC.CA_CHART(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE in ('TM' ,'TG')THEN CA_GET_DESC.CA_SECTION_HDG(A.ACTION_CODE,?,'1') END SPLTY_TASK_DESC FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A  WHERE SPLTY_EVENT_CODE=? AND MODULE_ID=? AND SPLTY_TASK_CODE =?";

	//String dateSQL="SELECT TO_CHAR(TRANS_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_TASK WHERE PATIENT_ID	=? AND FACILITY_ID	=? AND MODULE_ID=? AND CYCLE_NO=? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE ";
	
	String dateSQL="SELECT TO_CHAR(TRANS_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_TASK WHERE PATIENT_ID	=? AND MODULE_ID=? AND CYCLE_NO=? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE ";

	String SQL1="SELECT CYCLE_NO, CYCLE_STATUS  FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 2 desc, 1 desc";

	String sqlCycleStatus = "SELECT CYCLE_STATUS FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? AND CYCLE_NO = ?";

	String SQLSPlty="SELECT SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC FROM CA_SPLTY_EPISODE_CYCLE_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=?";

	String SQLSNoteCnt="SELECT count(*) evnt_cnt FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM=? ";

	//String transDateQry ="select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE";

	String transDateQry ="select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =?  AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? ORDER BY TRANS_DATE";

	//String del_rec_qry=" select no_of_birth,(SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator,nvl(FINALIZE_YN,'N') FINALIZE_YN from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ?  and MOTHER_PATIENT_ID=? and CYCLE_NO = ?   ";
	
	String del_rec_qry=" select no_of_birth,(SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator,nvl(FINALIZE_YN,'N') FINALIZE_YN,FACILITY_ID from CA_SPL_DELIVERY_RECORD where  MOTHER_PATIENT_ID=? and CYCLE_NO = ?   ";

	//String del_rec_qryNew =" select 1 from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ?  and MOTHER_PATIENT_ID=? and CYCLE_NO = ? and ENCOUNTER_ID = ?  ";

	String del_rec_qryNew =" select 1 from CA_SPL_DELIVERY_RECORD where MOTHER_PATIENT_ID=? and CYCLE_NO = ? and ENCOUNTER_ID = ?  ";

	String newBornQry= " select s.PATIENT_ID,s.FINALIZED_YN  from MP_birth_register s where s.MOTHER_PATIENT_ID = ?  and s.BIRTH_ORDER= ? and MC_CYCLE_NO =? " ;	

	String splty_episode_desc=request.getParameter("splty_episode_desc") == null ? "" : request.getParameter("splty_episode_desc");
	String facility_id = (String) session.getValue("facility_id");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//main task variabl
	String splt_event_code="";
	String splt_event_status="";
	String splt_event_desc="";
	String splty_task_code="";
	String splty_task_desc="";
	String splty_task_type="";
	String extble_name="";
	String accessionNum="";
	int no_trans_allowed=0;
	String actn_code;
	String discr_msr_value1 ="";
	String discr_msr_value2 ="";
	String sec_hdg_code_temp ="";
	String sec_det_qry="";
	String sec_hdg_desc="";
	String sec_hdg_code="";
	String noOfBirth="1";
	String newBornid = "";
	String disp_str = "";
	String finalized_yn = "N";
	String newBornDetDisp = "";
	String delivDetDisp = "";
	String delivDetDisp1 = "";
	String del_finalize_yn = "N";
	int occurance = 1;
	int BLoop=1;	
	String sub_act_code=null;
	String sub_act_desc=null;
	String modifyYN = "Y";
	String evnt_cnt = "0";
	String contr_mod_accession_num = "0";
	int i=0;
	int k=0;
	int l=0;
	Boolean flag = true;
	Boolean delivFlag = false;
	Boolean stageComp = true;
	Boolean newBornFlag = false;
	Boolean delEncFlag = false;
	String allow_yn = "";
	String tool_tip = "";
	String modeValueNew = "";
	String dis_date = "";
	String dis_date1 = "";

	PreparedStatement pstmtsql = null;
	PreparedStatement pstmt_evnt = null;
	PreparedStatement pstmtRecOCDisp = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmtSQLSNoteCnt = null;
	PreparedStatement pstmtSect = null;
	PreparedStatement pstmtDelRec = null;
	PreparedStatement pstmtNewBorn = null;
	PreparedStatement pstmtTransDate = null;
	PreparedStatement pstmtDSQ = null;
	PreparedStatement pstmtSectNew = null;
	PreparedStatement pstmtDS = null;
	PreparedStatement pstmtDoccurance = null;
			
	
	CallableStatement cs = null;
	Connection con = null;
	ResultSet rssql = null;
	ResultSet rsMenu_Evnt = null;
	ResultSet resRecOCDisp = null;
	ResultSet rsSQLSNoteCnt = null;
	ResultSet rsSect = null;
	ResultSet rsDelv = null;
	ResultSet rsNewBorn = null;
	ResultSet rsTransDate = null;
	ResultSet rsDSQ = null;
	ResultSet rsDS = null;
	ResultSet rsSectNew = null;
	ResultSet rsDoccurance = null;
	ResultSet rs = null,rsMenu=null,rsDate=null;
	String req_event_code=request.getParameter("req_event_code")==null?"":request.getParameter("req_event_code");

	try{
		con = ConnectionManager.getConnection(request);
	

	try{
		pstmtRecOCDisp = con.prepareStatement("select ACCESSION_NUM,DTL_REC_PRESENT_YN from CA_PAT_SPLTY_EPISODE_TASK a where a.patient_id = ? and a.module_id = ? and a.cycle_no = ? and a.SPLTY_EVENT_CODE = ? ");

		pstmt1=con.prepareStatement(SQLSPlty);
		pstmt1.setString(1,module_id);
		pstmt1.setString(2,locale);
		rs	 =pstmt1.executeQuery();
		while(rs.next()){
		splty_episode_desc=rs.getString(1)==null?"Cycle":rs.getString(1);
		splty_title_event_desc=rs.getString(2)==null?"Event":rs.getString(2);
		}
		splty_episode_desc=splty_episode_desc==null?"Cycle":splty_episode_desc;
		splty_title_event_desc=splty_title_event_desc==null?"Event":splty_title_event_desc;
		if(rs!=null)
			rs.close();
		if(pstmt1!=null)
			pstmt1.close();

		if(pstmtRecOCDisp != null) pstmtRecOCDisp.close();
		if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
	}catch(Exception e){
		e.printStackTrace();
	}

	try{
	pstmtsql=con.prepareStatement(SQL1);
	pstmtsql.setString(1,patient_id);
	pstmtsql.setString(2,module_id);
	rssql	 =pstmtsql.executeQuery();
	rssql.next();
		cycle_no=Integer.parseInt(rssql.getString(1));
		cycle_status=rssql.getString(2);

	if(rssql!=null)
		rssql.close();
	if(pstmtsql!=null)
		pstmtsql.close();	
	
	pstmtsql = con.prepareStatement(sqlCycleStatus);
	pstmtsql.setString(1,patient_id);
	pstmtsql.setString(2,module_id);
	pstmtsql.setInt(3,Integer.parseInt(sel_cycle_no));
	rssql	 =pstmtsql.executeQuery();	
	if(rssql.next())
		cycle_status = rssql.getString("CYCLE_STATUS");

	if(rssql!=null)
		rssql.close();
	if(pstmtsql!=null)
		pstmtsql.close();	

	}catch(Exception e){
		e.printStackTrace();
	}

	if(!sel_cycle_no.equals("0")){
	cycle_no=Integer.parseInt(sel_cycle_no);
	}

	%>
	<script>
	if(parent.maternityeventframe.document.getElementById("newEventID") != null && parent.maternityeventframe.document.getElementById("newEventID") !=  undefined)
	{
		if('<%=cycle_status%>' == 'C') parent.maternityeventframe.document.getElementById("newEventID").style.visibility = 'hidden'; 
		else if('<%=cycle_status%>' != 'C') parent.maternityeventframe.document.getElementById("newEventID").style.visibility = 'visible';
	}
	</script>

<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="callfunction()">
<STYLE>
	TR {
		BACKGROUND-COLOR:white;
	}
	TD {
		BACKGROUND-COLOR:white;		
	}
	A{
		FONT-SIZE:8 pt;
	}

</Style>

<FORM METHOD=POST ACTION="" name="maternityMenu" id="maternityMenu">
<script>
<%
	try{
			pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
			pstmt_evnt=con.prepareStatement(event_SQL);
			pstmt_evnt.setString(1,locale);
			pstmt_evnt.setString(2,patient_id);
			pstmt_evnt.setString(3,module_id);
			pstmt_evnt.setInt(4,cycle_no);
			rsMenu_Evnt=pstmt_evnt.executeQuery();
	
			while(rsMenu_Evnt.next())
			{
				splt_event_code=rsMenu_Evnt.getString("SPLTY_EVENT_CODE");
				splt_event_status=rsMenu_Evnt.getString("SPLTY_EVENT_STATUS");
				splt_event_desc=rsMenu_Evnt.getString("SPLTY_EVENT_DESC");%>
				var obj<%=i%>;
				obj<%=i%> = new dTree('obj<%=i%>');
				obj<%=i%>.add(0,-1,'');
				obj<%=i%>.config.useStatusText=true;		
				<%if (splt_event_status.equals("O"))
				{
				%>	
						

				<%
				}else
				{
				%>	
					
				<%}
				try{
						String date="";
						String DetailPresentYN="N";
						pstmt=con.prepareStatement(menuSql);
						pstmt.setString(1,locale);
						pstmt.setString(2,splt_event_code);
						pstmt.setString(3,module_id);					
						rsMenu=pstmt.executeQuery();

						pstmtDelRec = con.prepareStatement(del_rec_qry);
						//pstmtDelRec.setString(1,facility_id);					
						pstmtDelRec.setString(1,patient_id);
						pstmtDelRec.setInt(2,cycle_no);					
						rsDelv = pstmtDelRec.executeQuery();
						while(rsDelv.next())
						{
							delivFlag = true;
							noOfBirth =  rsDelv.getString("NO_OF_BIRTH")==null?"1":rsDelv.getString("NO_OF_BIRTH");
							delivery_indicator =  rsDelv.getString("delivery_indicator")==null?"":rsDelv.getString("delivery_indicator");
							del_finalize_yn =  rsDelv.getString("FINALIZE_YN")==null?"":rsDelv.getString("FINALIZE_YN");
							deli_rec_facility_id =  rsDelv.getString("FACILITY_ID")==null?"":rsDelv.getString("FACILITY_ID");
							
						}
					
						if(rsDelv!=null) 		rsDelv.close();
						if(pstmtDelRec!=null)	pstmtDelRec.close();

						pstmtDelRec = con.prepareStatement(del_rec_qryNew);
						//pstmtDelRec.setString(1,facility_id);
						pstmtDelRec.setString(1,patient_id);
						pstmtDelRec.setInt(2,cycle_no);
						pstmtDelRec.setString(3,encounter_id);
						rsDelv = pstmtDelRec.executeQuery();
						
						while(rsDelv.next())
						{
							delEncFlag = true;
						}
					
						if(rsDelv!=null) 		rsDelv.close();
						if(pstmtDelRec!=null)	pstmtDelRec.close();
						
						if(!(splt_event_code.equals("MCE009") || splt_event_code.equals("MCE008")))
						{
							delEncFlag = true;
						}
					
					/*if(!(splt_event_code.equals("MCE013")))
					{
						noOfBirth = "1";
					} */
					
					//for(int BLoop=1;BLoop<=Integer.parseInt(noOfBirth);BLoop++){
					//rsMenu.beforeFirst();
					while(rsMenu.next()){
						splty_task_code=rsMenu.getString(1);
						splty_task_desc=rsMenu.getString(2);
						no_trans_allowed=Integer.parseInt(rsMenu.getString(4));
						if (no_trans_allowed==0)
							no_trans_allowed=100;
						splty_task_type=rsMenu.getString(5); 
						extble_name=rsMenu.getString(6); 
						actn_code=rsMenu.getString(7);


						//for(int BLoop=0;BLoop<2;BLoop++){
						
						if(splty_task_type.equals("OC"))
						{
							DetailPresentYN = "N";
							pstmtRecOCDisp = con.prepareStatement("select ACCESSION_NUM,DTL_REC_PRESENT_YN from CA_PAT_SPLTY_EPISODE_TASK a where a.patient_id = ? and a.module_id = ? and a.cycle_no = ? and a.SPLTY_EVENT_CODE = ? ");
							pstmtRecOCDisp.setString(1,patient_id);
							pstmtRecOCDisp.setString(2,module_id);
							pstmtRecOCDisp.setInt(3,cycle_no);
							pstmtRecOCDisp.setString(4,splt_event_code);
							resRecOCDisp = pstmtRecOCDisp.executeQuery();
							while(resRecOCDisp.next())
							{
								DetailPresentYN = resRecOCDisp.getString(2) == null ? "N" : resRecOCDisp.getString(2);
								accessionNum = resRecOCDisp.getString(1) == null ? "" : resRecOCDisp.getString(1);
							}

							if(pstmtRecOCDisp != null) pstmtRecOCDisp.close();
						}
				%>
						if('<%=splty_task_type%>'=='OC')
						{
							
							//if(('<%=BLoop%>'=='<%=Integer.parseInt(noOfBirth)%>')||('<%=splt_event_code%>'!='MCE013'))
							//	{
								
							if(('<%=cycle_status%>' == 'C' )|| ('<%=splt_event_status%>' == 'C'))
							{
									if('<%=DetailPresentYN%>' == 'Y')
									{
										obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','../../eCA/jsp/RecMaternityOutcomeForcedComplete.jsp?sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&OCmode=V&accessionNum=<%=accessionNum%>','<%=splty_task_desc%>','workAreaFrame','','','','R');
									}
									else
									{
										obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','','<%=splty_task_desc%>','','','','','R');
									}
							}
								
							else
							{
								obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','../../eCA/jsp/RecMaternityOutcomeForcedComplete.jsp?sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&OCmode=R','<%=splty_task_desc%>','workAreaFrame','','','','R');
							}//}
						}
						else if('<%=splty_task_type%>'=='PR')
						{ 
							if ('<%=delivery_indicator%>' == 'C' || '<%=delivery_indicator%>' == 'O')
							{	
							
								if('<%=splt_event_status%>' != 'C')
									{	
									obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','../../eCA/jsp/PatProcRecord.jsp?&accession_number=MC!<%=patient_id%>!<%=cycle_no%>!&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&OCmode=R','<%=splty_task_desc%>','workAreaFrame','','','','R');
									}
									else
									{
										obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','','<%=splty_task_desc%>','workAreaFrame','','','','R');

									}
							}
						}
						else if('<%=splty_task_type%>'=='HM')
						{
													
							if(<%=delivFlag%>&&'<%=del_finalize_yn%>'=='Y')
							{
								obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','','<%=splty_task_desc%>','','','','','R');

							}

						}


						else
						{
													
							obj<%=i%>.add('<%=splty_task_code%><%=splt_event_code%>','0','<b><%=splty_task_desc%></b>','','<%=splty_task_desc%>','','','','','R');
						}
						
				<%
					if(splty_task_type.equals("HD")){ 

					if(cycle_status.equals("C") || splt_event_status.equals("C")) modifyYN = "N";
					else modifyYN = "Y";
					if(!splt_event_code.equals("MCE013")){
					%>
					obj<%=i%>.add('MOTHER','<%=splty_task_code%><%=splt_event_code%>','<b><fmt:message key="Common.Mother.label" bundle="${common_labels}"/></b>','','DOCUMENT','','','','','R');
					<%
					 contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!M";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}
					catch(Exception e1)
					{		
						e1.printStackTrace();
					}
					%>
						obj<%=i%>.add('MOTHERDOCUMENT','MOTHER','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")%>(<%=evnt_cnt%>)','../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString%>&appl_task_id=MC_CONSULT&contr_mod_accession_num=<%=module_id%>!<%=patient_id%>!<%=cycle_no%>!<%=splt_event_code%>!M&modifyYN=<%=modifyYN%>','Mother Folder','workAreaFrame','','','','R');
					<%
					/* contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}	
					catch(Exception e2)
					{
						
						e2.printStackTrace();
					}*/
					%>
					obj<%=i%>.add('MOTHERCHART','MOTHER','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")%>','../../eCA/jsp/ChartRecording.jsp?<%=queryString%>&contr_mod_accession_num=<%=module_id%>!<%=patient_id%>!<%=cycle_no%>!<%=splt_event_code%>!M&modifyYN=<%=modifyYN%>','MOTHERCHART','workAreaFrame','','','','R');
					
					<%}
						if(splt_event_code.equals("MCE004") || splt_event_code.equals("MCE008")){//|| splt_event_code.equals("MCE013")){
							
							contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						 
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}	
					catch(Exception e2)
					{		
						e2.printStackTrace();
					}
							
							
							
							%>
						obj<%=i%>.add('FOETUS','<%=splty_task_code%><%=splt_event_code%>','<b><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")%></b>','','CHART','','','','','R');	
					
				
								
						
						obj<%=i%>.add('FOETUSDOCUMENT','FOETUS','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")%>(<%=evnt_cnt%>)','../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString%>&appl_task_id=MC_CONSULT&contr_mod_accession_num=<%=module_id%>!<%=patient_id%>!<%=cycle_no%>!<%=splt_event_code%>!F&modifyYN=<%=modifyYN%>','Foetus Folder','workAreaFrame','','','','R');
						
					// contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
					 obj<%=i%>.add('FOETUSCHART','FOETUS','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")%>','../../eCA/jsp/ChartRecording.jsp?<%=queryString%>&contr_mod_accession_num=<%=module_id%>!<%=patient_id%>!<%=cycle_no%>!<%=splt_event_code%>!F&modifyYN=<%=modifyYN%>','FOETUSCHART','workAreaFrame','','','','R');
					
					<%}
					/*pstmt1=con.prepareStatement(hdquerySQL);
					pstmt1.setString(1,locale);
					pstmt1.setString(2,splt_event_code);
					pstmt1.setString(3,module_id);
					pstmt1.setString(4,splty_task_code);
					rs	  =pstmt1.executeQuery();
					while(rs.next()){
					sub_task_code=rs.getString(1);
					sub_task_desc=rs.getString(2);
					no_trans_allowed=Integer.parseInt(rs.getString(4));
					sub_task_type=rs.getString(5);
					sub_extble_name=rs.getString(6);
					sub_hd_tsk_code=rs.getString(8);
					*/
					%>
					
					<%
					/*if (!sub_task_type.equals("OC"))
					{
					pstmt2=con.prepareStatement(actionSQL);
					pstmt2.setString(1,locale);
					pstmt2.setString(2,locale);
					pstmt2.setString(3,locale);
					pstmt2.setString(4,splt_event_code);
					pstmt2.setString(5,module_id);
					pstmt2.setString(6,sub_task_code);	
					rs2	  =pstmt2.executeQuery();
					while(rs2.next()){
					sub_act_code=rs2.getString(1);
					sub_act_desc=rs2.getString(2);
					*/
					%>

					<%
					
					/*
					try{
					pstmt3=con.prepareStatement(dateSQL);
					int trns_lim=0;
					pstmt3.setString(1,patient_id);
					pstmt3.setString(2,facility_id);
					pstmt3.setString(3,module_id);
					pstmt3.setInt(4,cycle_no);
					pstmt3.setString(5,splt_event_code);
					pstmt3.setString(6,sub_task_code);
					rsDate=pstmt3.executeQuery();
					while(rsDate.next()){
					trns_lim=trns_lim+1;
					
					*/
					%>		
					<%
					/*
					}
					if(rsDate!=null)
						rsDate.close();
					if(pstmt3!=null)
						pstmt3.close();
					if(trns_lim<no_trans_allowed && (!cycle_status.equals("C") && !splt_event_status.equals("C"))){
					
					*/
					%>
					
					<% /*
						}
					}catch(Exception e){
					e.printStackTrace() ;
					} */
					%>	
					<%
						/*}
					if(rs2!=null)
					rs2.close();
					if(pstmt2!=null)
					pstmt2.close();
					}
					}
					if(rs!=null)
					rs.close();
					if(pstmt1!=null)
					pstmt1.close();*/
				}else if (splty_task_type.equals ("HM"))
				{
				 if(delivFlag){
					//String newBornQry= " select s.PATIENT_ID,s.FINALIZED_YN  from MP_birth_register s where s.MOTHER_PATIENT_ID = ?  and s.BIRTH_ORDER= ? " ;
					pstmtNewBorn = con.prepareStatement(newBornQry);
					for(int BLoop1=1;BLoop1<=Integer.parseInt(noOfBirth);BLoop1++){


					contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!"+BLoop1+"!F";
					try
					{
						pstmtSQLSNoteCnt=con.prepareStatement(SQLSNoteCnt);
						 pstmtSQLSNoteCnt.setString(1,contr_mod_accession_num);
						 rsSQLSNoteCnt=pstmtSQLSNoteCnt.executeQuery();
						 if (rsSQLSNoteCnt.next()){
							evnt_cnt=rsSQLSNoteCnt.getString("evnt_cnt");
								 }
						 else
							evnt_cnt="0";
						 
						if(rsSQLSNoteCnt != null) rsSQLSNoteCnt.close();
						if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
					}	
					catch(Exception e2)
					{
						e2.printStackTrace();
					}
							
				if(Integer.parseInt(noOfBirth)>1)
				{
					if(BLoop1==1)
					{
						newBornDetDisp="1<sup>st</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp = "Record 1<sup>st</sup> Birth details ";
						delivDetDisp1 = " 1<sup>st</sup> Birth details ";

					}
					else if(BLoop1==2)
					{
						newBornDetDisp="2<sup>nd</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp ="Record 2<sup>nd</sup> Birth details ";
						delivDetDisp1 =" 2<sup>nd</sup> Birth details ";


					}
					else if(BLoop1==3)
					{
						newBornDetDisp="3<sup>rd</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp ="Record 3<sup>rd</sup> Birth details ";
						delivDetDisp1 ="3<sup>rd</sup> Birth details ";

					}
					else
					{
						newBornDetDisp=BLoop1+"<sup>th</sup> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp ="Record "+BLoop1+"<sup>th</sup> Birth details ";
						delivDetDisp1 =BLoop1+"<sup>th</sup> Birth details ";
					}


				}
				else if(Integer.parseInt(noOfBirth)==1)
				{

						newBornDetDisp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBornDetails.label","ca_labels");
						delivDetDisp =	"Record Birth details ";
						delivDetDisp1 = "Birth details ";


				}
					if(splty_task_code.equals("MCT008")){
							//stageComp falg

							String sec_det_qryNew = " select CHILD_SEC_HDG_CODE from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = 'MC25' order by CHILD_SEQ_NUM " ;
						//	String transDateQryNew1 =" select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

							String transDateQryNew1 =" select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

							pstmtSectNew	= con.prepareStatement(sec_det_qryNew);
							pstmtDS	= con.prepareStatement(transDateQryNew1);

									rsSectNew = pstmtSectNew.executeQuery();

									while(rsSectNew.next())
									{
										sec_hdg_code =rsSectNew.getString("CHILD_SEC_HDG_CODE")==null?"":rsSectNew.getString("CHILD_SEC_HDG_CODE");
										
										if(sec_hdg_code.equals("MC05"))
										{
											continue;
										}
										
										pstmtDS.setString(1,patient_id);
										//pstmtDS.setString(2,facility_id);
										pstmtDS.setString(2,module_id);
										pstmtDS.setInt(3,cycle_no);
										//pstmt.setString(5,sub_act_code);
										pstmtDS.setString(4,sec_hdg_code);
										pstmtDS.setString(5,splt_event_code);
										//pstmt.setString(7,splty_task_code);
										pstmtDS.setInt(6,BLoop1);
										rsDS = pstmtDS.executeQuery();
										
										
										if(!rsDS.next())
										{
											stageComp = false;
											break;
										}
										if(rsDS!=null) rsDS.close();
							

									}
									
									if(rsDS!=null) rsDS.close();
									if(rsSectNew!=null) rsSectNew.close();
									if(pstmtSectNew!=null) pstmtSectNew.close();
									if(pstmtDS!=null) pstmtDS.close();
							

					}




				//
				//if(Integer.parseInt(noOfBirth)>1)
				//{
					if( delivery_indicator.equals("N") || delivery_indicator.equals("O")){
					if(!stageComp){
				%>
					obj<%=i%>.add('DELIV<%=BLoop1%>','<%=splty_task_code%><%=splt_event_code%>','<%=delivDetDisp%>','','','workAreaFrame','','','','R');	

				<%
					}
					else
					{
				%>
					obj<%=i%>.add('DELIV<%=BLoop1%>','<%=splty_task_code%><%=splt_event_code%>','<%=delivDetDisp1%>','../../eCA/jsp/RecMaternityConsView.jsp?sec_hdg_code=<%=sub_act_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&birth_order=<%=BLoop1%>&modeValue=VA','','workAreaFrame','','','','R');	

				<%

					}
					}
				//}


				%>
					
					obj<%=i%>.add('NEWBORN<%=BLoop1%>','<%=splty_task_code%><%=splt_event_code%>','<%=newBornDetDisp%>','','','workAreaFrame','','','','R');
					
					

				<%
					
					
					//pstmtNewBorn = con.prepareStatement(newBornQry);
					pstmtNewBorn.setString(1,patient_id);
					pstmtNewBorn.setInt(2,BLoop1);	
					pstmtNewBorn.setInt(3,cycle_no);
					
					rsNewBorn = pstmtNewBorn.executeQuery();

					while(rsNewBorn.next())
					{
						newBornFlag = true;
						newBornid = rsNewBorn.getString("PATIENT_ID")==null? "" :	rsNewBorn.getString("PATIENT_ID") ;
						finalized_yn = rsNewBorn.getString("FINALIZED_YN")==null? "N" :	rsNewBorn.getString("FINALIZED_YN") ;
					}
					
					if (finalized_yn.equals("Y"))
					{
						disp_str= newBornid;
					}
					else
					{
						disp_str= newBornid+"(Not Finalized)";	
					}

					if(newBornFlag)
					{
				%>
					obj<%=i%>.add('<%=date%><%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=disp_str%>','../../eMP/jsp/ViewBirthRegMain.jsp?Patient_ID=<%=newBornid%>&<%=queryString%>','','workAreaFrame','','','','R');


				<%

					}
					else{

						if((occurance==1)&&splt_event_status.equals("O"))
						{

							//CallableStatement cs = null;
							cs = con.prepareCall("{call mp_validate_nb_mother(?,?,?)}");
							cs.setString(1,patient_id);
							cs.setString(2,splt_event_code);
							cs.registerOutParameter( 3,Types.VARCHAR ) ;
							cs.execute();
							allow_yn = cs.getString(3);
							if(allow_yn==null) allow_yn = "";

							
							
							if(allow_yn.equals("SUBSEQUENT_DELY"))
							{
								tool_tip = getMessage(locale,allow_yn,"MP");
												
								
				%>
								obj<%=i%>.add('<%=date%><%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")%>','../../eCommon/html/blank.html','<%=tool_tip%>','workAreaFrame','','','','R');

				<%
							}
							else
							{		
								
								if (!deli_rec_facility_id.equals("") && deli_rec_facility_id.equals(facility_id))
								{														
				%>
									obj<%=i%>.add('<%=date%><%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")%>','<%=extble_name%>?accessRights=NNNNN&Patient_ID=<%=patient_id%>&menu_id=MC&module_id=CA&function_id=NEWBORN_REG&function_name=Register Newborn&function_type=F&access=NNNNN&<%=queryString%>&called_from_mothercare=MC&calling_module_id=CA','','workAreaFrame','','','','R');				
				<%			
								}else{ %>
									obj<%=i%>.add('<%=date%><%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")%>','','','workAreaFrame','','','','R');
				
		<%						}	
				}
						occurance++; 
					}
					else
					{
				%>
					obj<%=i%>.add('<%=date%><%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisterBaby.label","ca_labels")%>','','','workAreaFrame','','','','R');

				<%
					}
					}
				 if(newBornFlag){
					%>
						obj<%=i%>.add('NEWBORNASS<%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assessment.label","common_labels")%>','','','workAreaFrame','','','','R');
						obj<%=i%>.add('NEWBORNDOCUMENT<%=BLoop1%>','NEWBORNASS<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")%>(<%=evnt_cnt%>)','../../eCA/jsp/RecClinicalNotes.jsp?<%=queryString%>&appl_task_id=MC_CONSULT&contr_mod_accession_num=<%=module_id%>!<%=patient_id%>!<%=cycle_no%>!<%=splt_event_code%>!<%=BLoop1%>!F&modifyYN=<%=modifyYN%>','Newborn Folder','workAreaFrame','','','','R');
						
					// contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
						 obj<%=i%>.add('NEWBORNCHART<%=BLoop1%>','NEWBORNASS<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")%>','../../eCA/jsp/ChartRecording.jsp?<%=queryString%>&contr_mod_accession_num=<%=module_id%>!<%=patient_id%>!<%=cycle_no%>!<%=splt_event_code%>!<%=BLoop1%>!F&modifyYN=<%=modifyYN%>','NEWBORNCHART','workAreaFrame','','','','R');

					<%
					}
					else
						{
				%>
					obj<%=i%>.add('NEWBORNASS<%=BLoop1%>','NEWBORN<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assessment.label","common_labels")%>','','','workAreaFrame','','','','R');
						obj<%=i%>.add('NEWBORNDOCUMENT<%=BLoop1%>','NEWBORNASS<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Document.label","common_labels")%>','','Newborn Folder','workAreaFrame','','','','R');
						
					// contr_mod_accession_num= module_id+"!"+patient_id+"!"+cycle_no+"!"+splt_event_code+"!F";
						 obj<%=i%>.add('NEWBORNCHART<%=BLoop1%>','NEWBORNASS<%=BLoop1%>','<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NewBorn.label","ca_labels")%> <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")%>','','NEWBORNCHART','workAreaFrame','','','','R');

				<%


						}
					newBornFlag=false;
					if(rsNewBorn != null) rsNewBorn.close();
					//if(pstmtNewBorn != null) pstmtNewBorn.close();
					}
					if(pstmtNewBorn != null) pstmtNewBorn.close();
				 }
				}
				else if (!splty_task_type.equals ("OC"))
				{
					pstmt2=con.prepareStatement(actionSQL);
					pstmt2.setString(1,locale);
					pstmt2.setString(2,locale);
					pstmt2.setString(3,locale);
					pstmt2.setString(4,splt_event_code);
					pstmt2.setString(5,module_id);
					pstmt2.setString(6,splty_task_code);
					rs	  =pstmt2.executeQuery();
					while(rs.next()){
						sub_act_code=rs.getString(1);
						sub_act_desc=rs.getString(2);
						sec_hdg_code_temp=sub_act_code;

					try{
					pstmt3=con.prepareStatement(dateSQL);
					int trns_lim=0;
					pstmt3.setString(1,patient_id);
					//pstmt3.setString(2,facility_id);
					pstmt3.setString(2,module_id);
					pstmt3.setInt(3,cycle_no);
					pstmt3.setString(4,splt_event_code);
					pstmt3.setString(5,splty_task_code);
					rsDate=pstmt3.executeQuery();
					while(rsDate.next()){
					trns_lim=trns_lim+1;
					%>	
					<%}
					if(rsDate!=null)
						rsDate.close();
					if(pstmt3!=null)
						pstmt3.close();

					//this line commented by shaiju to enable the link after closing the event.
					//if(!splt_event_status.equals("C")){//  &&
					//if(trns_lim<no_trans_allowed && (!cycle_status.equals("C"))){//  &&!splt_event_status.equals("C"))){
					
						if(splty_task_type.equals ("TM"))
						{

							sec_det_qry= " select SEC_HDG_DESC short_desc from CA_SECTION_HDG where SEC_HDG_CODE = ? " ;
							pstmtSect =	con.prepareStatement(sec_det_qry);
							pstmtSect.setString(1,sub_act_code);
							rsSect = pstmtSect.executeQuery();
							k=0;
							while(rsSect.next())
							{	k++;
								flag =true;
								l=0;

								sec_hdg_desc =rsSect.getString("short_desc")==null?"":rsSect.getString("short_desc");


								pstmtTransDate =	con.prepareStatement(transDateQry);
								pstmtTransDate.setString(1,patient_id);
								//pstmtTransDate.setString(2,facility_id);
								pstmtTransDate.setString(2,module_id);
								pstmtTransDate.setInt(3,cycle_no);
								pstmtTransDate.setString(4,sub_act_code);
								pstmtTransDate.setString(5,sub_act_code);
								pstmtTransDate.setString(6,splt_event_code);
								pstmtTransDate.setString(7,splty_task_code);
								rsTransDate = pstmtTransDate.executeQuery();
								while(rsTransDate.next())
								{
									flag=false;l++;

									dis_date1 = rsTransDate.getString(1);
									if (!locale.equals("en") )
									{
										dis_date1 = com.ehis.util.DateUtils.convertDate(dis_date1,"DMYHM","en",locale);

									}

								%>
									obj<%=i%>.add('<%=rsTransDate.getString(2)%>','<%=splty_task_code%><%=splt_event_code%>','<%=dis_date1%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&trns_datettime=<%=rsTransDate.getString(1)%>&accessionNum=<%=rsTransDate.getString(2)%>&modeValue=V','','workAreaFrame','','','','R');

								<%
									

								}
								if(l<no_trans_allowed)
								{
								
									flag=true;

								}

								if(rsTransDate!=null) rsTransDate.close();
								if(pstmtTransDate!=null) pstmtTransDate.close();
								
								if(flag&&!splt_event_status.equals("C")){
							
								
							%>
							obj<%=i%>.add('<%=k%>','<%=splty_task_code%><%=splt_event_code%>','<%=sec_hdg_desc%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sub_sec_hdg_code=<%=sub_act_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>','','workAreaFrame','','','','R');
						
						
							<%
							}
							}
							if(rsSect!=null) rsSect.close();
							if(pstmtSect!=null) pstmtSect.close();


						}
						else if(splty_task_type.equals ("TG"))
						{
							
							sec_det_qry= " select CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? order by CHILD_SEQ_NUM " ;
							pstmtSect =	con.prepareStatement(sec_det_qry);
							pstmtSect.setString(1,sub_act_code);
							//rsSect = pstmtSect.executeQuery();
							k=0;
							
							if(splty_task_code.equals("MCT005"))
							{
								/*String del_rec_qry=" select NO_OF_BIRTH from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ? and ENCOUNTER_ID =? and MOTHER_PATIENT_ID=? ";

								pstmtDelRec = con.prepareStatement(del_rec_qry);
								pstmtDelRec.setString(1,facility_id);
								pstmtDelRec.setString(2,encounter_id);
								pstmtDelRec.setString(3,patient_id);
								rsDelv = pstmtDelRec.executeQuery();

								while(rsDelv.next())
								{
									delivFlag = true;
									noOfBirth =  rsDelv.getString("NO_OF_BIRTH")==null?"":rsDelv.getString("NO_OF_BIRTH");
								}*/
								if(!splt_event_status.equals("C")){
								%>
								obj<%=i%>.add('<%=date%>','<%=splty_task_code%><%=splt_event_code%>','Delivery Record','../../eCA/jsp/RecMaternityDeliveryRecordMain.jsp?<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>','','workAreaFrame','','','','R');

								<%
								}
								else
								{
								%>
								obj<%=i%>.add('<%=date%>','<%=splty_task_code%><%=splt_event_code%>','Delivery Record','../../eCA/jsp/RecMaternityDeliveryRecordMain.jsp?<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&splt_event_status=<%=splt_event_status%>','','workAreaFrame','','','','R');	
								<%
								}


							}
							
							if (!splty_task_code.equals("MCT005")||((delivery_indicator.equals("N") || delivery_indicator.equals("O"))&&del_finalize_yn.equals("Y")))
							{	
								Boolean Dflag = true;
								Boolean Hflag = true;
								Boolean DOccurFlag = true;
								Boolean Doccurance = true;
								Boolean DSQflag = true;
								String tmpl_finalize_yn = "";

								//String delStageQry="select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = 'MC52' AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND FINALIZE_YN='Y'";

								String delStageQry="select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = 'MC52' AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND FINALIZE_YN='Y'";

							//	String DoccuranceQry = " select 1  from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

								String DoccuranceQry = " select 1  from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

								if(Integer.parseInt(noOfBirth)>=1){
								pstmtDoccurance =	con.prepareStatement(DoccuranceQry);
								
								pstmtDSQ =	con.prepareStatement(delStageQry); 
								pstmtDSQ.setString(1,patient_id);
								//pstmtDSQ.setString(2,facility_id);
								pstmtDSQ.setString(2,module_id);
								pstmtDSQ.setInt(3,cycle_no);
								pstmtDSQ.setString(4,splt_event_code);
								rsDSQ = pstmtDSQ.executeQuery();
								while(rsDSQ.next())
								{
									DSQflag=false;
								}
								}
								if(rsDSQ!=null) rsDSQ.close();
								if(pstmtDSQ!=null) pstmtDSQ.close();
							
							for(int DLoop=1;DLoop<=Integer.parseInt(noOfBirth);DLoop++){
								k=0;
								rsSect = pstmtSect.executeQuery();
							
							while(rsSect.next())
							{	
								flag = true;
								k++;

								sec_hdg_desc =rsSect.getString("CHILD_SEC_HDG_DESC")==null?"":rsSect.getString("CHILD_SEC_HDG_DESC");
								sec_hdg_code =rsSect.getString("CHILD_SEC_HDG_CODE")==null?"":rsSect.getString("CHILD_SEC_HDG_CODE");


								if((DLoop>1)&&(sec_hdg_code.equals("MC05")))
								{
									DSQflag = true;
									continue;
									
								}
								if((sec_hdg_code.equals("MC52")|| sec_hdg_code.equals("MC53"))&&Integer.parseInt(noOfBirth)>1){
								

								
								pstmtDoccurance.setString(1,patient_id);
								//pstmtDoccurance.setString(2,facility_id);
								pstmtDoccurance.setString(2,module_id);
								pstmtDoccurance.setInt(3,cycle_no);
								pstmtDoccurance.setString(4,sub_act_code);
								pstmtDoccurance.setString(5,sec_hdg_code);
								pstmtDoccurance.setString(6,splt_event_code);
								pstmtDoccurance.setString(7,splty_task_code);
								pstmtDoccurance.setInt(8,DLoop);
								rsDoccurance = pstmtDoccurance.executeQuery();
								if(!rsDoccurance.next())
								{
									
									Doccurance = false;
								}
								}
								if(rsDoccurance!=null) rsDoccurance.close();
												
												
								//transDateQryNew =" select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM,nvl(FINALIZE_YN,'N') FINALIZE_YN from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? ORDER BY TRANS_DATE ";
								transDateQryNew =" select TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,A.ACCESSION_NUM,nvl(FINALIZE_YN,'N') FINALIZE_YN from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= ? AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=? AND BIRTH_ORDER = ? ORDER BY TRANS_DATE ";
							
							   // for(int DLoop=1;DLoop<=Integer.parseInt(noOfBirth);DLoop++){
								
								//flag = true;
								/*if(!sec_hdg_code.equals("MC05"))
								{
								  flag = true;
								} */
								
								pstmtTransDate =	con.prepareStatement(transDateQryNew); 
								pstmtTransDate.setString(1,patient_id);
								//pstmtTransDate.setString(2,facility_id);
								pstmtTransDate.setString(2,module_id);
								pstmtTransDate.setInt(3,cycle_no);
								pstmtTransDate.setString(4,sub_act_code);
								pstmtTransDate.setString(5,sec_hdg_code);
								pstmtTransDate.setString(6,splt_event_code);
								pstmtTransDate.setString(7,splty_task_code);
								pstmtTransDate.setInt(8,DLoop);
								rsTransDate = pstmtTransDate.executeQuery();
								while(rsTransDate.next())
								{
									flag = false;
									tmpl_finalize_yn = rsTransDate.getString("FINALIZE_YN");

									dis_date = rsTransDate.getString(1);
									if (!locale.equals("en") )
									{
										dis_date = com.ehis.util.DateUtils.convertDate(dis_date,"DMYHM","en",locale);

									}
									
									/*if(tmpl_finalize_yn.equals("N"))
									{
										Doccurance = false;	
									}*/

									

									if((Integer.parseInt(noOfBirth)>=1)&&(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009")))
									{
										Dflag = false;
									}

									if((Integer.parseInt(noOfBirth)>=1)&&(!Hflag)&&(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009")))//&&(!Hflag)
									{
										
										Dflag = false;
										if(tmpl_finalize_yn.equals("Y"))
										{
									%>
									
									obj<%=i%>.add('<%=rsTransDate.getString(2)%>','DELIV<%=DLoop%>','<%=dis_date%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&trns_datettime=<%=rsTransDate.getString(1)%>&accessionNum=<%=rsTransDate.getString(2)%>&modeValue=V','','workAreaFrame','','','','R');

									<%
										}
										else 
										{
											if((splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))&&delEncFlag)
											{
												modeValueNew ="T" ;
											}
											else
											{
												modeValueNew ="V";
											}
									%>
										
									obj<%=i%>.add('<%=rsTransDate.getString(2)%>','DELIV<%=DLoop%>','<%=sec_hdg_desc%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sub_sec_hdg_code=<%=sec_hdg_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&trns_datettime=<%=rsTransDate.getString(1)%>&accessionNum=<%=rsTransDate.getString(2)%>&modeValue=<%=modeValueNew%>&birth_order=<%=DLoop%>','','workAreaFrame','','','','R');

									<%
										
										}
									}
									else
									{										

										if(tmpl_finalize_yn.equals("Y"))
										{
									%>
																
									obj<%=i%>.add('<%=rsTransDate.getString(2)%>','<%=splty_task_code%><%=splt_event_code%>','<%=dis_date%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&trns_datettime=<%=rsTransDate.getString(1)%>&accessionNum=<%=rsTransDate.getString(2)%>&modeValue=V','','workAreaFrame','','','','R');
									<%
										}
										else if(DSQflag)
										{
											
											if(!splt_event_status.equals("C")){
											if((splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))&&(delEncFlag))
											{
												modeValueNew ="T" ;
											}
											else
											{
												modeValueNew ="V";
											}
											}
											else
											{
												modeValueNew ="V";
											}
										
									%>
									obj<%=i%>.add('<%=rsTransDate.getString(2)%>','<%=splty_task_code%><%=splt_event_code%>','<%=sec_hdg_desc%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sub_sec_hdg_code=<%=sec_hdg_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&trns_datettime=<%=rsTransDate.getString(1)%>&accessionNum=<%=rsTransDate.getString(2)%>&modeValue=<%=modeValueNew%>&birth_order=<%=DLoop%>','','workAreaFrame','','','','R');	
									
									<%


										}
										else
										{
									%>
									
										obj<%=i%>.add('<%=rsTransDate.getString(2)%>','<%=splty_task_code%><%=splt_event_code%>','<%=sec_hdg_desc%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&trns_datettime=<%=rsTransDate.getString(1)%>&accessionNum=<%=rsTransDate.getString(2)%>&modeValue=V','','workAreaFrame','','','','R');	
									
									<%

										}
														 
									}
									Hflag = false;
								}
								if(rsTransDate!=null) rsTransDate.close();
							//}
							//	if(pstmtTransDate!=null) pstmtTransDate.close(); 

							
							if(flag){
							
								
								if(Dflag&&!splt_event_status.equals("C")){
									
									if((DOccurFlag)&&(DSQflag)&&(delEncFlag) ){
											
									if(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))
									{
										modeValueNew ="D" ;
									}
									else
									{
										modeValueNew ="";
									}
									
							%>
							obj<%=i%>.add('<%=k%>','<%=splty_task_code%><%=splt_event_code%>','<%=sec_hdg_desc%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sub_sec_hdg_code=<%=sec_hdg_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&birth_order=<%=DLoop%>&modeValue=<%=modeValueNew%>','','workAreaFrame','','','','R');
							
									
							<%
							}
							else
							{
								
							%>
						obj<%=i%>.add('<%=k%>','<%=splty_task_code%><%=splt_event_code%>','<%=sec_hdg_desc%>','','','workAreaFrame','','','','R');
									
							<%

							}
								if((Integer.parseInt(noOfBirth)>=1)&&(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009")))
								{
									Dflag = false;
									Hflag = false;
									continue;
								}

							}

								
								if(!Dflag){
								
								if((DOccurFlag)&&(delEncFlag) && (!deli_rec_facility_id.equals("") &&  deli_rec_facility_id.equals(facility_id)) ){									
									if(splt_event_code.equals("MCE008")||splt_event_code.equals("MCE009"))
									{
										modeValueNew ="D" ;
									}
									else
									{
										modeValueNew ="";
									}

								%>
									
								obj<%=i%>.add('<%=k%><%=DLoop%>','DELIV<%=DLoop%>','<%=sec_hdg_desc%>','<%=extble_name%>?sec_hdg_code=<%=sub_act_code%>&sub_sec_hdg_code=<%=sec_hdg_code%>&sectionType=<%=splty_task_type%>&<%=queryString%>&cycle_no=<%=cycle_no%>&splty_event_code=<%=splt_event_code%>&splty_task_code=<%=splty_task_code%>&birth_order=<%=DLoop%>&modeValue=<%=modeValueNew%>','','workAreaFrame','','','','R');

								<%
								}
								else
								{
								%>
								obj<%=i%>.add('<%=k%><%=DLoop%>','DELIV<%=DLoop%>','<%=sec_hdg_desc%>','','','workAreaFrame','','','','R');
								<%

								}
								/*

								}
								if(rsTransDate!=null) rsTransDate.close();
								if(pstmtTransDate!=null) pstmtTransDate.close();
								*/
								
								
								}
							}
							 
							//} //Dloop ends
								if(pstmtTransDate!=null) pstmtTransDate.close(); 
							} 
							if((!Doccurance)||(flag))
							{
								DOccurFlag =false;
							}
							
							//while loop ends
								if(rsSect!=null) rsSect.close();
							}
						}
							//if(rsSect!=null) rsSect.close();
							if(pstmtSect!=null) pstmtSect.close();
							if(pstmtDoccurance!=null) pstmtDoccurance.close();
						}
					
					
					%>
					
					<%//}
					}catch(Exception e){
						e.printStackTrace();
					}
					}
					if(rs!=null)
					rs.close();
					if(pstmt2!=null)
					pstmt2.close();
				}



				}
				//if(!splt_event_code.equals("MCE013")){
				//break;
				//}
				//}//end of BLoop
				if(rsMenu!= null) rsMenu.close();
				if(resRecOCDisp!= null) resRecOCDisp.close();
				if(pstmt!=null) pstmt.close();
				if(pstmtRecOCDisp!=null) pstmtRecOCDisp.close();
				if(pstmtSQLSNoteCnt!=null) pstmtSQLSNoteCnt.close();

				String preciouspregQuery ="select RTRIM(RTRIM(DISCR_MSR_VALUE),','),ACCESSION_NUM  from CA_PAT_SPLTY_KEY_MSR where PATIENT_ID	=? and MODULE_ID =? and CYCLE_NO =? and EVENT_CODE=? and DISCR_MSR_ID =?" ;
				pstmt =con.prepareStatement(preciouspregQuery);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,module_id);
				pstmt.setInt(3,cycle_no);
				pstmt.setString(4,splt_event_code);
				pstmt.setString(5,"MC01PRECUSPREGN");

				rs = pstmt.executeQuery();

				   if(rs.next())
					{
						discr_msr_value1 = rs.getString(1);
						
					}
					else
					{
						discr_msr_value1="";
					}
					if(rs!=null)
					rs.close();
					//if(pstmt!=null)
					//pstmt.close();	 
					pstmt.setString(5,"MC03RISKASSESRE");	
					rs = pstmt.executeQuery();

					if (rs.next())
					{
						discr_msr_value2 = rs.getString(1);
						accessionNum	 = rs.getString(2);
						
					}
					else
					{
						discr_msr_value2="";
					}
					if(pstmt!=null)
					pstmt.close();
					
					if(rs!=null)
					rs.close();

				}//end of try
catch(Exception e)
{
	e.printStackTrace();
}

if(splt_event_status.equals("O"))
{
	boldText = "<b>"+splt_event_desc+"</b>";	
}
else
{
	boldText = splt_event_desc;
}

%>
var html="<TABLE width='95%' align='center' border=0 cellspacing=0>";
html=html+"<TR>";
html=html+"<TD background='../../eCA/images/MCT_FullStrip.gif' style='height:32' onclick=\"hideShowNodes('<%=i%>')\">&nbsp;<%=boldText%>";
//here to add  //High Risk
if(('<%=discr_msr_value1%>'=='Y') ||('<%=discr_msr_value1%>'=='YES'))
{
	html=html+"<input type='image' src='../../eCA/images/MCT_PreciousPregnancy.gif'></input>";
}
if(('<%=discr_msr_value2%>'=='High Risk') ||('<%=discr_msr_value2%>'=='HGRI'))
html=html+" <img onClick ='callview(\"<%=sec_hdg_code_temp%>\",\"<%=splty_task_type%>\",\"<%=cycle_no%>\",\"<%=splt_event_code%>\",\"<%=splty_task_code%>\",\"<%=accessionNum%>\",\"<%=i%>\")' src='../../eCA/images/MCT_HighRiskInd.gif'></img>";

html=html+"</TD>";
html=html+"</TR></TABLE>";
parent.maternitytreeframe.document.write(html); //
document.write("<TABLE width='95%' height='75%' align='center' border=0 cellspacing=0><TR VALIGN=TOP><TD id='tdId<%=i%>' style='display;BACKGROUND-IMAGE:url(../../eCA/images/MCT_MenuBgImage.jpg)'>"+obj<%=i%>+"</td></tr></TABLE>");
obj<%=i%>.openAll();

<%
		i++;}
if(rsMenu_Evnt!=null)
	rsMenu_Evnt.close();
if(pstmt_evnt!=null)
	pstmt_evnt.close();

if(pstmtSQLSNoteCnt != null) pstmtSQLSNoteCnt.close();
}catch(Exception e){
		if(rsMenu!=null)
	rsMenu.close();
if(pstmt!=null)
	pstmt.close();
	e.printStackTrace();
}

finally
{
	try
	{
		if(rs!= null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}catch(Exception e){
		e.printStackTrace();
}finally
{
	try
	{		
		if(con!= null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	%>	
</script>	
	<input type=hidden name='req_event_code' id='req_event_code' value='<%=req_event_code%>'>
	<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
	<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type=hidden name='queryString' id='queryString' value='<%=queryString%>'>
	<input type=hidden name='noOfEvents' id='noOfEvents' value='<%=i%>'>
	<input type=hidden name='sel_cycle_no' id='sel_cycle_no' value='<%=sel_cycle_no%>'>


</FORM>
<script>
	//hideAllCycles();
</script>
</body>
</html>

<%!

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}


%>

