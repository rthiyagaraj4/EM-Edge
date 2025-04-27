<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, java.sql.*, webbeans.eCommon.*, com.ehis.eslp.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>


<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*   File Name		:	ReviseCarePlanDynamicValues.jsp
*	Purpose 		:	To list the diagnosis according to the selected diagnosis_set
*	Created By		:	P.Anuradha
*	Created On		:	18-03-2005
*/
%>



<%-- <jsp:useBean id="ReviseCarePlan" class="webbeans.eCommon.RecordSet,eCommon.XSSRequestWrapper" scope="session"/> --%>
<jsp:useBean id="ReviseCarePlan" class="webbeans.eCommon.RecordSet" scope="session"/>
<%-- <jsp:useBean id="XSSRequestWrapper" class="eCommon.XSSRequestWrapper" scope="session"/> --%>
<jsp:useBean id="ReviseCarePlanRecordchanges" class="webbeans.eCommon.RecordSet" scope="session"/>


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
	ArrayList Diagnosis			=	null;
	ArrayList Goal				=	null;
	HashMap InterventionOutcome	=	null;
	HashMap IOGroup				=	null;
	ArrayList Intervention		=	null;
	ArrayList Outcome			=	null;

	HashMap	Intvn	=	null;
	ArrayList IntvnDtl=null;

	String termCode="";
	String termSet="";
	String goalCode="";
	String IntvnCode="";
	String outcomeCode="";

	String flag="";
	String temptermSet="";
	String temptermCode="";
	String grpid1="";
	String goalStatus="";
	String goalprev_yn="";
	String IntvnStatus="";
	String Intvnprev_yn="";
	String outcomeStatus="";
	String outcomeprev_yn="";

	String GoalList="";
	String IntvnList="";
	String OutcomeList="";
	String GroupList="";

	int index=0;
	int gindex=0;
	int Iindex=0;

	String start_date="";
	String frequency="";
	String duration="";
	String durationtype="";
	String end_date="";
	String stage="";
	String priority="";
	String position=""; 
	
	ArrayList sessionList				=	(ArrayList)ReviseCarePlan.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		Diagnosis=(ArrayList)ReviseCarePlan.getObject(0);
	}
	
	ArrayList sessionList1				=	(ArrayList)ReviseCarePlanRecordchanges.getRecordSetHandle();
	if(sessionList1.size()>0)
	{
		Intvn=(HashMap)ReviseCarePlanRecordchanges.getObject(0);
	}
	
	String validate=request.getParameter("validate");

	if(validate.equals("PATIENT")){

		String diagnosis_set=	request.getParameter("diagnosis_set")==null?"":request.getParameter("diagnosis_set");
		String patient_id=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		
		Connection conn 			= null;
		PreparedStatement pstmt 	= null;
		ResultSet rset 		        = null;
	
		String[] record				= null;
		String sql_diagnosis		= "";
		String facility_id=(String)session.getValue("facility_id");

		try {
			conn = ServiceLocator.getInstance().getConnection(request);
	
			sql_diagnosis="select distinct b.term_set_id term_set_id,b.term_code term_code,c.short_desc diag_desc from cp_pat_care_plan a, cp_pat_care_plan_term_code b, mr_term_code c where a.patient_id = ? and a.current_facility_id = ? and current_status = 'O' and a.care_plan_start_date <= sysdate  and b.md_care_plan_id = a.md_care_plan_id and b.care_plan_id = a.care_plan_id  and b.status = 'O' and c.term_set_id = nvl(?,c.term_set_id) and c.term_set_id = b.term_set_id and c.term_code = b.term_code order by diag_desc";

			pstmt = conn.prepareStatement(sql_diagnosis);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,diagnosis_set);
			rset = pstmt.executeQuery();
		   	ArrayList Term_List		= new ArrayList();	
			while (rset != null && rset.next()) 
			{
				record = new String[2];				
				record[0]=rset.getString("term_code");
				record[1] = rset.getString("diag_desc");
            	Term_List.add(record);
			}

		//to list diagnosis
			for( int i=0 ; i< Term_List.size() ; i++ ) 
			{
				record = (String[])Term_List.get(i);
			   out.println("addDiagnosis(\"" + record[0] + "\",\"" + record[1] + "\") ; " );
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			rset.close() ;
			pstmt.close() ;
			ServiceLocator.getInstance().returnConnection(conn,request);
		}
	}else if(validate.equals("DIAGNOSIS")){
		//System.err.println(" before diagnosis"+Diagnosis);
		flag="";
		termSet=request.getParameter("termSet");
		termCode=request.getParameter("termCode");
		flag=request.getParameter("flag");
		//System.err.println("flag"+flag);
		for(int i=0;i<Diagnosis.size();i=i+11){
			temptermSet=(String)Diagnosis.get(i);
			temptermCode=(String)Diagnosis.get(i+1);
			if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
				index=Diagnosis.indexOf(termCode);
				Goal=(ArrayList)Diagnosis.get(index+4);
				if(flag.equals("N"))
					Diagnosis.set(index+7,"N");
				else
					Diagnosis.set(index+7,"Y");
				
				for(int j=0;j<Goal.size();j=j+6){

					goalCode=(String)Goal.get(j);
					goalStatus=(String)Goal.get(j+3);
					goalprev_yn=(String)Goal.get(j+4);
					if(flag.equals("N"))
						Goal.set(j+5,"N");
					else
						Goal.set(j+5,goalprev_yn);
					
					InterventionOutcome=(HashMap)Goal.get(j+2);
					GoalList=GoalList+"~"+goalCode+"~"+goalStatus+"~"+goalprev_yn;
					goalStatus="";

					Set itr_set			=	InterventionOutcome.keySet();
					Iterator recordItr		=	itr_set.iterator();
					while(recordItr.hasNext()){
						grpid1="";
						grpid1=(String)recordItr.next();
						GroupList=GroupList+"~"+grpid1;
						IOGroup=(HashMap)InterventionOutcome.get(grpid1);
						Intervention=(ArrayList)IOGroup.get("I");
						if(IOGroup.containsKey("O"))
							Outcome=(ArrayList)IOGroup.get("O");
						for(int k=0;k<Intervention.size();k=k+6){
							IntvnCode=(String)Intervention.get(k);
							IntvnStatus=(String)Intervention.get(k+2);
							Intvnprev_yn=(String)Intervention.get(k+3);
							if(flag.equals("N"))
								Intervention.set(k+4,"N");
							else
								Intervention.set(k+4,Intvnprev_yn);

							IntvnList=IntvnList+"~"+IntvnCode+"~"+IntvnStatus+"~"+Intvnprev_yn;
							IntvnStatus="";
						}
						if(Outcome!=null)
							for(int k=0;k<Outcome.size();k=k+5){
								outcomeCode=(String)Outcome.get(k);
								outcomeStatus=(String)Outcome.get(k+2);
								outcomeprev_yn=(String)Outcome.get(k+3);
								if(flag.equals("N"))
									Outcome.set(k+4,"N");
								else
									Outcome.set(k+4,outcomeprev_yn);
								OutcomeList=OutcomeList+"~"+outcomeCode+"~"+outcomeStatus+"~"+outcomeprev_yn;
								outcomeStatus="";
							}
							IOGroup=null;
							Intervention=null;
							Outcome=null;
						}
						InterventionOutcome=null;
					}
				}
			}
			out.println( "diagnosisCheck(\""+termSet+"\",\""+termCode+"\",\""+GoalList+"\",\""+IntvnList+"\",\""+OutcomeList+"\",\""+flag+"\",\""+GroupList+"\");") ;
			
			//System.err.println("diagnosis"+Diagnosis);

	}else  if(validate.equals("GOAL")){
		termSet=request.getParameter("termSet");
		termCode=request.getParameter("termCode");
		goalCode=request.getParameter("goalCode");
		flag=request.getParameter("flag");

		for(int i=0;i<Diagnosis.size();i=i+11){
			temptermSet=(String)Diagnosis.get(i);
			temptermCode=(String)Diagnosis.get(i+1);
			if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
				index=Diagnosis.indexOf(termCode);
				Goal=(ArrayList)Diagnosis.get(index+4);
				if(Goal.contains(goalCode)){
					gindex=Goal.indexOf(goalCode);
					if(flag.equals("N"))
						Goal.set(gindex+5,"N");
					else
						Goal.set(gindex+5,"Y");

					InterventionOutcome=(HashMap)Goal.get(gindex+2);
					Set itr_set			=	InterventionOutcome.keySet();
					Iterator recordItr		=	itr_set.iterator();
					while(recordItr.hasNext()){
						grpid1="";
						grpid1=(String)recordItr.next();
						GroupList=GroupList+"~"+grpid1;
						IOGroup=(HashMap)InterventionOutcome.get(grpid1);
						Intervention=(ArrayList)IOGroup.get("I");
						if(IOGroup.containsKey("O"))
							Outcome=(ArrayList)IOGroup.get("O");
						for(int k=0;k<Intervention.size();k=k+6){
							IntvnCode=(String)Intervention.get(k);
							IntvnStatus=(String)Intervention.get(k+2);
							Intvnprev_yn=(String)Intervention.get(k+3);
							if(flag.equals("N"))
								Intervention.set(k+4,"N");
							else
								Intervention.set(k+4,Intvnprev_yn);
							IntvnList=IntvnList+"~"+IntvnCode+"~"+IntvnStatus+"~"+Intvnprev_yn;
							IntvnStatus="";
						}
						if(Outcome!=null){
							
							for(int k=0;k<Outcome.size();k=k+5){
								outcomeCode=(String)Outcome.get(k);
								outcomeStatus=(String)Outcome.get(k+2);
								outcomeprev_yn=(String)Outcome.get(k+3);
								if(flag.equals("N"))
									Outcome.set(k+4,"N");
								else
									Outcome.set(k+4,outcomeprev_yn);
								OutcomeList=OutcomeList+"~"+outcomeCode+"~"+outcomeStatus+"~"+outcomeprev_yn;
								outcomeStatus="";
							}
						}
						IOGroup=null;
						Intervention=null;
						Outcome=null;
					}
				}
			}
			out.println( "goalCheck(\""+termSet+"\",\""+termCode+"\",\""+goalCode+"\",\""+IntvnList+"\",\""+OutcomeList+"\",\""+flag+"\",\""+GroupList+"\");") ;	
		}
		}else  if(validate.equals("INTERVENTION")){
			termSet=request.getParameter("termSet");
			termCode=request.getParameter("termCode");
			goalCode=request.getParameter("goalCode");
			flag=request.getParameter("flag");
			IntvnCode=request.getParameter("IntvnCode");
			grpid1=request.getParameter("grpid");

			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					index=Diagnosis.indexOf(termCode);
					Goal=(ArrayList)Diagnosis.get(index+4);
					if(Goal.contains(goalCode)){
						gindex=Goal.indexOf(goalCode);
						InterventionOutcome=(HashMap)Goal.get(gindex+2);
						IOGroup=(HashMap)InterventionOutcome.get(grpid1);
						Intervention=(ArrayList)IOGroup.get("I");
						if(Intervention.contains(IntvnCode)){
							Iindex=Intervention.indexOf(IntvnCode);
							if(flag.equals("Y"))
								Intervention.set(Iindex+4,"Y");
							else
								Intervention.set(Iindex+4,"N");
						}

					}
				}
			}
		}else  if(validate.equals("OUTCOME")){
			termSet=request.getParameter("termSet");
			termCode=request.getParameter("termCode");
			goalCode=request.getParameter("goalCode");
			flag=request.getParameter("flag");
			outcomeCode=request.getParameter("outcomeCode");
			grpid1=request.getParameter("grpid");

			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					index=Diagnosis.indexOf(termCode);
					Goal=(ArrayList)Diagnosis.get(index+4);
					if(Goal.contains(goalCode)){
						gindex=Goal.indexOf(goalCode);
						InterventionOutcome=(HashMap)Goal.get(gindex+2);
						IOGroup=(HashMap)InterventionOutcome.get(grpid1);
						Outcome=(ArrayList)IOGroup.get("O");
						if(Outcome.contains(outcomeCode)){
							Iindex=Outcome.indexOf(outcomeCode);
							if(flag.equals("Y"))
								Outcome.set(Iindex+4,"Y");
							else
								Outcome.set(Iindex+4,"N");
						}

					}
				}
			}

		}else if(validate.equals("CLEARALL")){
			ReviseCarePlan.clearAll();
		}else if(validate.equals("UPDATEINTVNDTL")){

			//System.err.println("Intvn in validate "+Intvn);
			 IntvnCode=request.getParameter("intvnCode");
			 IntvnDtl=(ArrayList)Intvn.get(IntvnCode);
			
			 start_date=request.getParameter("start_date");
			 frequency=request.getParameter("frequency");
			 duration=request.getParameter("duration");
			 durationtype=request.getParameter("durationtype");
			 end_date=request.getParameter("end_date");
			 stage=request.getParameter("stage");
			 priority=request.getParameter("priority");
			 position=request.getParameter("position"); 
			 String revise_yn	=	request.getParameter("revise_yn"); 
 System.err.println("position in validate==frequency==== "+frequency);
  	 
			 IntvnDtl.set(4,start_date);
			 IntvnDtl.set(5,frequency);
			 IntvnDtl.set(6,duration);
			 IntvnDtl.set(7,durationtype);
			 IntvnDtl.set(8,end_date);
			 IntvnDtl.set(9,stage);
			 IntvnDtl.set(10,priority);
 			 IntvnDtl.set(11,position);
			 IntvnDtl.set(13,revise_yn);


			
		}else if(validate.equals("ADDINTVN")){
			
			Connection conn 			= null;
			PreparedStatement pstmt 	= null;
			ResultSet rset 		        = null;

						 termSet=request.getParameter("termSet");
			 termCode=request.getParameter("termCode");
			 goalCode=request.getParameter("goalCode");
			 grpid1=request.getParameter("groupid");
 	 		 flag=request.getParameter("flag");
			 String intvn_code=request.getParameter("intvn_code");
 			 String intvn_desc=request.getParameter("intvn_desc")==null?"":request.getParameter("intvn_desc");
			 String intvn_type=request.getParameter("intvn_type")==null?"":request.getParameter("intvn_type");
			 String query="Select Intervention_type from CA_INTERVENTION where INTERVENTION_CODE=?";

			 int intvnindex=0;

			 try {
				conn = ServiceLocator.getInstance().getConnection(request);
				pstmt		=	conn.prepareStatement(query);
				pstmt.setString(1,intvn_code);
				rset		=	pstmt.executeQuery();
				if(rset!=null){
					rset.next();
					intvn_type=rset.getString("Intervention_type");
				}
			}catch(Exception e){
				System.err.println(e.toString());
				e.printStackTrace();
			}finally{
				if(rset!=null)
					rset.close();
				if(pstmt!=null)
					pstmt.close();
					ConnectionManager.returnConnection(conn,request);

			}
			
			 for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					index=Diagnosis.indexOf(termCode);
					Goal=(ArrayList)Diagnosis.get(index+4);
					if(Goal.contains(goalCode)){
						gindex=Goal.indexOf(goalCode);
						InterventionOutcome=(HashMap)Goal.get(gindex+2);
						IOGroup=(HashMap)InterventionOutcome.get(grpid1);
						Intervention=(ArrayList)IOGroup.get("I");
						if(Intervention.contains(intvn_code)){
							//System.err.println("inside if in dynamic 111111");
							intvnindex=Intervention.indexOf(intvn_code);
							Intervention.set(intvnindex+4,flag);
						}else{
							//System.err.println("inside else in dynamic 2222222");
							Intervention.add(intvn_code);
							Intervention.add(intvn_desc);
							Intervention.add("O");
							Intervention.add("W");
							Intervention.add(flag);
							Intervention.add(intvn_type);
							
						}

					}

				}
			 }

		}

	
%>
