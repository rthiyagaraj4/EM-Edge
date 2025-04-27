
<%@ page language="java" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="BuildLibraryTermCode" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="BuildLibrary" class="webbeans.eCommon.RecordSet" scope="session"/>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String validate						=		request.getParameter("validate");
HashMap TermCodeData				=       new HashMap();
ArrayList TermCodeList				=		null;
ArrayList TabList					=		null;
ArrayList sessionList				=		(ArrayList)BuildLibraryTermCode.getRecordSetHandle();
ArrayList sessionList1				=		(ArrayList)BuildLibrary.getRecordSetHandle();

if(sessionList.size()>0)
{
	TermCodeData=(HashMap)BuildLibraryTermCode.getObject(0);
}

if(sessionList1.size()>0)
{
	TermCodeList=(ArrayList)BuildLibrary.getObject(0);
}


	String code					=	"";
	String flag					=	"";

	String termSet				=	"";
	String termCode				=	"";
	String tempTermSet			=	"";
	String tempTermCode			=	"";

	String goalCode				=	"";
	String goalDesc				=	"";
	String targetPeriod			=	"";
	String targetPeriodType		=	"";
	String practitionerType		=	"";
	String maxGrpID				=	"";
	String db_action			=	"";
	
	String InterventionCode		=	"";
	String interventionDesc		=	"";
	String Alt					=	"";
	String relativeStart		=	"";
	String relativeStartType	=	"";
	String frequency			=	"";
	String Duration				=	"";
	String DurationType			=	"";
	String Dependency			=	"";
	String Stage				=	"";
//	String GroupNo				=	"";

	String outcomeCode			=	"";
	String outcomeDesc			=	"";
	String Nature				=	"";

	String maxGrpID1				=	"";
	String GroupID					=	"";
	String tempOutcomeFlag			=	"";
	String tempInterventionFlag		=	"";
	String tempInterventiongrpid	=	"";
	String tempOutcomegrpid			=	"";

	HashMap InterventionOutcome	=	null;
	ArrayList Intervention		=	null;
	ArrayList Outcome			=	null;
	ArrayList Goal				=	null;

	int index					=	0;
	int index1					=	0;
	
	boolean flag1					=	false;
	boolean interventionFlag		=	false;
	boolean outcomeFlag				=	false;
	

if(validate.equals("UPDATECODE")){

	 code			=	request.getParameter("code");
	 termSet		=	request.getParameter("termSet");
	 flag			=	request.getParameter("flag");
	 tempTermSet	=	"";
	 tempTermCode	=	"";

	if(TermCodeData.containsKey(termSet))
	{
		TabList=(ArrayList)TermCodeData.get(termSet);
	}

	if(TabList.contains(code)){
		 index=TabList.indexOf(code);
		if(flag.equals("1"))
			TabList.set(index+2,flag);
		else
			TabList.set(index+2,flag);
	}

	for(int j=0;j<TermCodeList.size();j=j+7){
		 tempTermSet	= (String)TermCodeList.get(j);
		 tempTermCode	= (String)TermCodeList.get(j+1);

		if(tempTermSet.equals(termSet) && tempTermCode.equals(code)){
			index=TermCodeList.indexOf(code);
			TermCodeList.set(index+2,flag);
			break;
		}
	}
	
	TermCodeData.put(termSet,TabList);


	}else if(validate.equals("UPDATEGOAL")){

		 flag					=	request.getParameter("flag");
		 termSet				=	request.getParameter("termSet");
		 termCode				=	request.getParameter("termCode");
		 goalCode				=	request.getParameter("goalCode");
		 targetPeriod			=	request.getParameter("targetPeriod");
		 targetPeriodType		=	request.getParameter("targetPeriodType");
		 practitionerType		=	request.getParameter("practitionerType");
		 maxGrpID				=	request.getParameter("maxGrpID")==null?"":request.getParameter("maxGrpID");
		 goalDesc				=	request.getParameter("goalDesc");
		 db_action				=	"";
						
		for(int i=0;i<TermCodeList.size();i=i+7){
			 tempTermSet=(String)TermCodeList.get(i);
			if(termSet.equals(tempTermSet)){
				 tempTermCode=(String)TermCodeList.get(i+1);
				if(termCode.equals(tempTermCode)){
					Goal=(ArrayList)TermCodeList.get(i+2);
					if(Goal.contains(goalCode)){
						index	=	Goal.indexOf(goalCode);
						Goal.set(index +1,targetPeriod);
						Goal.set(index +2,targetPeriodType);
						InterventionOutcome	=	(HashMap)Goal.get(index+3);
						Goal.set(index+3,InterventionOutcome);
						Goal.set(index+4,flag);
						db_action	=	(String)Goal.get(index+5);
						if(db_action.equals("U"))
							Goal.set(index+5,"U");
						else
							Goal.set(index+5,"I");
						Goal.set(index+8,practitionerType);

					}else{
						InterventionOutcome		=	new HashMap();     // hashmap to put the corresponding I n O groups for the goal
						 Intervention	=	new ArrayList();     //arraylist
						 Outcome		=	new ArrayList();
						InterventionOutcome.put("I",Intervention);
						InterventionOutcome.put("O",Outcome);
						Goal.add(goalCode);
						Goal.add(targetPeriod);
						Goal.add(targetPeriodType);
						Goal.add(InterventionOutcome);
						Goal.add(flag);
						Goal.add("I");
						Goal.add(maxGrpID);
						Goal.add(goalDesc);
						Goal.add(practitionerType);
						}
				}
			}
		}
		//System.err.println("TermCodeList"+TermCodeList);

	}else if(validate.equals("UPDATEINTERVENTION")){
		 flag					=	request.getParameter("flag");
		 termCode				=	request.getParameter("termCode");
		 termSet				=	request.getParameter("termSet");
		 goalCode				=	request.getParameter("goalCode");
		 InterventionCode		=	request.getParameter("interventionCode");
		 interventionDesc		=	request.getParameter("interventionDesc");
		 Alt					=	request.getParameter("Alt")==null?"":request.getParameter("Alt");
		 relativeStart			=	request.getParameter("relativeStart")==null?"":request.getParameter("relativeStart");
		 relativeStartType		=	request.getParameter("relativeStartType")==null?"":request.getParameter("relativeStartType");
		 frequency				=	request.getParameter("frequency")==null?"":request.getParameter("frequency");
		 Duration				=	request.getParameter("Duration")==null?"":request.getParameter("Duration");
		 DurationType			=	request.getParameter("DurationType")==null?"":request.getParameter("DurationType");
		 Dependency				=	request.getParameter("Dependency")==null?"":request.getParameter("Dependency");
		 Stage					=	request.getParameter("stage")==null?"":request.getParameter("stage");
		 //GroupNo				=	request.getParameter("GroupNo");
		 db_action				=	"";
		
		for(int i=0;i<TermCodeList.size();i=i+7){
			 tempTermSet=(String)TermCodeList.get(i);
			 tempTermCode=(String)TermCodeList.get(i+1);
			if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
				Goal=(ArrayList)TermCodeList.get(i+2);
				if(Goal.contains(goalCode)){
					index			=	Goal.indexOf(goalCode);
					InterventionOutcome	=	(HashMap)Goal.get(index+3);
					Intervention		=	(ArrayList)InterventionOutcome.get("I");
					if(Intervention.contains(InterventionCode)){
						 index1=Intervention.indexOf(InterventionCode); 
					//	if(flag.equals("Y"))
					//		Intervention.set(index1+1,GroupNo);
					//	else
						if(flag.equals("N"))
							Intervention.set(index1+1,"");
						Intervention.set(index1+2,Alt);
						Intervention.set(index1+3,relativeStart);
						Intervention.set(index1+4,relativeStartType);
						Intervention.set(index1+5,frequency);
						Intervention.set(index1+6,Duration);
						Intervention.set(index1+7,DurationType);
						Intervention.set(index1+8,Dependency);
						Intervention.set(index1+9,Stage);
						Intervention.set(index1+10,flag);
						break;
					}else{
						Intervention.add(InterventionCode);			//code
					//	if(flag.equals("Y"))
					//		Intervention.add(GroupNo);
						//else
							Intervention.add("");					//groupid
						Intervention.add(Alt);						// alternative
						Intervention.add(relativeStart);			//relative start
						Intervention.add(relativeStartType);		// relative start type
						Intervention.add(frequency);                // frequency code
						Intervention.add(Duration);					// duration
						Intervention.add(DurationType);				//duration type
						Intervention.add(Dependency);               //dependency
						Intervention.add(Stage);					//stage		
						Intervention.add(flag);						//flag for the check box
						Intervention.add("I");                      // flag to know the operation like insertion or updation
						Intervention.add(interventionDesc);			// Intervention desc
						break;
					}
				}
			}
		}
//		System.err.println("TermCodeList in validate Intervention  "+TermCodeList);
	}else if(validate.equals("UPDATEOUTCOME")){
		 flag					=	request.getParameter("flag");
		 termCode				=	request.getParameter("termCode");
		 termSet				=	request.getParameter("termSet");
		 goalCode				=	request.getParameter("goalCode");
		 outcomeCode			=	request.getParameter("outcomeCode");
		 outcomeDesc			=	request.getParameter("outcomeDesc");
		 Nature					=	request.getParameter("Nature")==null?"":request.getParameter("Nature");
		 targetPeriod			=	request.getParameter("targetPeriod")==null?"":request.getParameter("targetPeriod");
		 targetPeriodType		=	request.getParameter("targetPeriodType")==null?"":request.getParameter("targetPeriodType");
		 //GroupNo				=	request.getParameter("GroupNo");
		 db_action				=	"";

		for(int i=0;i<TermCodeList.size();i=i+7){
			 tempTermSet	=	(String)TermCodeList.get(i);
			 tempTermCode	=	(String)TermCodeList.get(i+1);
			if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
				 Goal	=	(ArrayList)TermCodeList.get(i+2);
				if(Goal.contains(goalCode)){
					index					=	Goal.indexOf(goalCode);
					 InterventionOutcome	=	(HashMap)Goal.get(index+3);
					 Outcome			=	(ArrayList)InterventionOutcome.get("O");
					if(Outcome.contains(outcomeCode)){
						index1=Outcome.indexOf(outcomeCode);
						//if(flag.equals("Y"))
						//	Outcome.set(index1+1,GroupNo);
						//else
						if(flag.equals("N"))
							Outcome.set(index1+1,"");
						Outcome.set(index1+2,Nature);
						Outcome.set(index1+3,targetPeriod);
						Outcome.set(index1+4,targetPeriodType);
						Outcome.set(index1+5,flag);
						break;
					}else{
						Outcome.add(outcomeCode);                //outcome code
						//if(flag.equals("Y"))
						//	Outcome.add(GroupNo);
						//else
							Outcome.add("");                    //group id
						Outcome.add(Nature);					// nature of outcome
						Outcome.add(targetPeriod);				// target period
						Outcome.add(targetPeriodType);          //target period type
						Outcome.add(flag);						//flag for check box
						Outcome.add("I");						// flag to know the operation like insertion or updation
						Outcome.add(outcomeDesc);               //outcome desc
						break;
					}
				}
			}
		}

//		System.err.println("TermCodeList in validate outcome  "+TermCodeList);
	}else if(validate.equals("CHKGROUP")){

		 termCode					=	request.getParameter("termCode");
		 termSet					=	request.getParameter("termSet");
		 goalCode					=	request.getParameter("goalCode");
		 maxGrpID1				=	request.getParameter("maxGrpID");
		 GroupID					=	request.getParameter("GroupID");
		 String fromobj=request.getParameter("fromobj");
		 
//		System.err.println("maxGrpID1 in dynamic"+maxGrpID1);
//		System.err.println("GroupID in dynamic"+GroupID);

		for(int i=0;i<TermCodeList.size();i=i+7){
			tempTermSet			=	(String)TermCodeList.get(i);
			tempTermCode		=	(String)TermCodeList.get(i+1);
			if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
				Goal			=	(ArrayList)TermCodeList.get(i+2);
				if(Goal.contains(goalCode)){
					index						=	Goal.indexOf(goalCode);
					 InterventionOutcome		=	(HashMap)Goal.get(index+3);
					 Outcome				=	(ArrayList)InterventionOutcome.get("O");
					 Intervention			=	(ArrayList)InterventionOutcome.get("I");
					if((Outcome.size()>0)&&(Intervention.size()>0)){
						for(int j=0;j<Intervention.size();j=j+13){
							tempInterventionFlag	=	(String)Intervention.get(j+10);
							tempInterventiongrpid	=	(String)Intervention.get(j+1);
							if(tempInterventionFlag.equals("Y")&& tempInterventiongrpid.equals("")){
								interventionFlag=true;
								Intervention.set(j+1,maxGrpID1);
							}
						}
						
						
						for(int k=0;k<Outcome.size();k=k+8){
							tempOutcomeFlag		=	(String)Outcome.get(k+5);
							tempOutcomegrpid	=	(String)Outcome.get(k+1);
							if(tempOutcomeFlag.equals("Y") && tempOutcomegrpid.equals("")){
								outcomeFlag=true;
								Outcome.set(k+1,maxGrpID1);
								
							}
						}
										
					}

				//System.err.println("interventionFlag first "+interventionFlag);
			//	System.err.println("outcomeFlag first "+outcomeFlag);
						if(!maxGrpID1.equals(GroupID)){
						if(!interventionFlag){
							for(int k=0;k<Outcome.size();k=k+8){
								tempOutcomeFlag		=	(String)Outcome.get(k+5);
								tempOutcomegrpid	=	(String)Outcome.get(k+1);
								if(tempOutcomeFlag.equals("Y") && tempOutcomegrpid.equals(maxGrpID1)){
									Outcome.set(k+1,"");
								}
							}
						}
						if(!outcomeFlag){
							for(int j=0;j<Intervention.size();j=j+13){
								tempInterventionFlag	=	(String)Intervention.get(j+10);
								tempInterventiongrpid	=	(String)Intervention.get(j+1);
								if(tempInterventionFlag.equals("Y")&& tempInterventiongrpid.equals(maxGrpID1)){
									Intervention.set(j+1,"");
								}

							}
						}
					}
				}
			}
		}
		//System.err.println("interventionFlag  "+interventionFlag);
//		System.err.println("outcomeFlag  "+outcomeFlag);
		if(interventionFlag && outcomeFlag){
			flag1=true;
			for(int i=0;i<TermCodeList.size();i=i+7){
				tempTermSet		=	(String)TermCodeList.get(i);
				tempTermCode	=	(String)TermCodeList.get(i+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal		=	(ArrayList)TermCodeList.get(i+2);
					if(Goal.contains(goalCode)){
						index=Goal.indexOf(goalCode);
						if(!GroupID.equals(maxGrpID1))
							Goal.set(index+6,maxGrpID1);
					}
				}
			}
		}
		else
			flag1	=	false;
	//out.println( "creatNewGrp('" + flag1 + "');");	
	out.println("creatNewGrp(\"" + flag1 + "\",\"" + fromobj + "\",\"" + interventionFlag + "\",\"" + outcomeFlag + "\") ; " );

	}
	BuildLibraryTermCode.setObject(0,TermCodeData);
	
	%>
	
