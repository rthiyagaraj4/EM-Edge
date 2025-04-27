<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--
	Developed by 	:	Suman
	Created on 	:	14/04/2005
	Module		:	OA
	Function	:	Invite WaitList
-->    
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="waitlistinvitation" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="waitlistinvitation1" class="webbeans.eCommon.RecordSet" scope="session"/> 

<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

<% 
  		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String fac_id		= (String) session.getValue( "facility_id" ) ;
		String locale=(String)session.getAttribute("LOCALE");
		int hilgtcnt=0;
		StringBuffer sql=new StringBuffer("") ;
		String patientid	=   request.getParameter("patientid")== null?"":request.getParameter("patientid");
		String WaitListNo	=	request.getParameter("WaitListNo")== null?"":request.getParameter("WaitListNo");
		String waitListfrmdate	=	request.getParameter("waitListfrmdate")== null?"":request.getParameter("waitListfrmdate");
		String waitListTodate	=	request.getParameter("waitListTodate") == null?"":request.getParameter("waitListTodate");

		
		waitListfrmdate=DateUtils.convertDate(waitListfrmdate,"DMY",locale,"en");
		waitListTodate=DateUtils.convertDate(waitListTodate,"DMY",locale,"en");
		
		String specCode=	request.getParameter("specCode") == null?"":request.getParameter("specCode");
		String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
		String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
		String patientname1		=	request.getParameter("patientname")== null?"":request.getParameter("patientname");
		String gender		=	request.getParameter("gender")== null?"":request.getParameter("gender");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String ALCN_CRITERIA_YN=request.getParameter("ALCN_CRITERIA_YN");
		if(ALCN_CRITERIA_YN ==null) ALCN_CRITERIA_YN="";
		String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
		String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
		String priority1=request.getParameter("priority");
		if(priority1==null)priority1="";
		String elapsed=request.getParameter("elaspsed")==null?"":request.getParameter("elaspsed");
		String nat_id_no=request.getParameter("nat_id_no");
		if(nat_id_no ==null) nat_id_no="";
		String alt_id1_no=request.getParameter("alt_id1_no");
		if(alt_id1_no ==null) alt_id1_no="";
		String alt_id1_type=request.getParameter("alt_id1_type");
		if(alt_id1_type ==null) alt_id1_type="";
		String alt_id2_no=request.getParameter("alt_id2_no"); 
		if(alt_id2_no ==null) alt_id2_no="";
		String alt_id2_type=request.getParameter("alt_id2_type");
		if(alt_id2_type ==null) alt_id2_type="";
		String alt_id3_no=request.getParameter("alt_id3_no");
		if(alt_id3_no ==null) alt_id3_no="";
		String alt_id3_type=request.getParameter("alt_id3_type");
		if(alt_id3_type ==null) alt_id3_type="";
		String alt_id4_no=request.getParameter("alt_id4_no");
		if(alt_id4_no ==null) alt_id4_no="";
		String alt_id4_type=request.getParameter("alt_id4_type");
		if(alt_id4_type ==null) alt_id4_type="";
		String other_alt_Id=request.getParameter("other_alt_Id");
		if(other_alt_Id ==null) other_alt_Id="";
		String other_alt_type=request.getParameter("other_alt_type");
		if(other_alt_type ==null) other_alt_type="";

		String nat_id_code=request.getParameter("nat_id_code");
		if(nat_id_code ==null) nat_id_code="";
		String r_area_code=request.getParameter("r_area");
		if(r_area_code ==null) r_area_code="";
		String m_area_code=request.getParameter("m_area");
		if(m_area_code ==null) m_area_code="";
		String r_region_code=request.getParameter("r_region");
		if(r_region_code ==null) r_region_code="";
		String m_region_code=request.getParameter("m_region");
		if(m_region_code ==null) m_region_code="";
		String r_town_code=request.getParameter("r_town");
		if(r_town_code ==null) r_town_code="";
		String m_town_code=request.getParameter("m_town");
		if(m_town_code ==null) m_town_code="";

		String wait_list_status=request.getParameter("wait_list_status");
		if(wait_list_status ==null) wait_list_status="";
		String wait_list_priority=request.getParameter("wait_list_priority");
		if(wait_list_priority ==null) wait_list_priority="";

		String install_yn=request.getParameter("install_yn");
		if(install_yn ==null) install_yn="";
		String install_yn_ca=request.getParameter("install_yn_ca");
		if(install_yn_ca ==null) install_yn_ca="";
	
		
		String or_catalogue_code=request.getParameter("or_catalogue_code");
		if(or_catalogue_code ==null) or_catalogue_code="";

		String  walst_category_code=request.getParameter("walst_category_code");
		if(walst_category_code ==null) walst_category_code="";

		String wtlt_category=request.getParameter("wtlt_category");
		if(wtlt_category ==null) wtlt_category="";
		
		String wtlt_category_one=request.getParameter("wtlt_category_one");
		if(wtlt_category_one ==null) wtlt_category_one="";

		//String elapsed=request.getParameter("elapsed");
		//if(elapsed==null) elapsed="N";

		String elapsed_grace_period=request.getParameter("ELAPSED_GRACE_PERIOD");
		if(elapsed_grace_period ==null) elapsed_grace_period="0";

		String order_by=request.getParameter("order_by");
		if(order_by ==null || order_by=="" ) order_by="FIRST_ENCOUNTER_DATE";

		String order=request.getParameter("order");
		if(order ==null || order=="") order="asc";
		if(order.equals(""))
		{
			order="asc";
		}
	
		String waitliststatus1="";
		String removeCode="";
		String waitlistinviteddate1="";
		String classValue	 = "";
		String waitListNo="";
		String priority="";
		String priority_desc="";
		String waitlist_cat_desc="";
		String patientId="";
		String patientName="";
		String waitlist_category_code="";
		String preferedDate="";
		String preferedDate_display="";
		String specialityDesc="";
		String locationDesc="";
		String resourceClass="";
		String resource="";
		String clinicDesc="";
		String careLocnTypeInd="";
		String clinicCode="";
		String resourceId="";
		String dummyCheckedValue="";
		String specialityCode="";
		String invited_date_time="";
		String resClass="";
		String Gender="";
		String gender1="";
		String last_encounter_id="";
		String age="";
		String res_region_desc="";
		String first_encounter_date="";
		String waitlist_category_code_prev="";
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String flagSelect=request.getParameter("flagSelect");

	    int maxDispRecords			=	6;

		int start = 0 ;
	int end = 0 ;
	int s=1;

/*	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 6 ;
	else
		end = Integer.parseInt( to ) ;*/
		if ( from == null ||from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null ||to.equals("") )
	  	end = maxDispRecords ;
	else
		end = Integer.parseInt( to ) ;  

		Statement stmt				= null;
		ResultSet rs				= null;
		Connection conn=null;
		Statement st=null;
		ResultSet rsSet=null;
		String req_start = "", req_end = "";
		String checkedOnes	= "";
		String invitationdateval="";
		String	waitliststatus="";

		req_start       =   (request.getParameter("start")==null)?"0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)?"0" :   request.getParameter("end");
	%>
	<HTML>
	 <head>
		<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
		<script src="../../eOA/js/QueryLocnForDay.js"></script>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
		 -->
		 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eOA/js/WaitListInvitation.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

	
		<%
try
{

			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			StringBuffer sql2 = new StringBuffer();
			StringBuffer sql3 = new StringBuffer();
			String sqlmain="";
			StringBuffer sqlmain2= new StringBuffer();
			int i=0;		 
			
			   
		 
			if((wait_list_status.equals("") || wait_list_status.equals("O")) )
			{
				//sql2.append("select  /*+rule+*/ WAIT_LIST_NO,to_char(a.PREFERRED_DATE_TIME,'dd/mm/yyyy') date_time   from pr_wait_list a ");
				
				sql2.append("select  /*+rule+*/ WAIT_LIST_NO,to_char(a.PREFERRED_DATE_TIME,'dd/mm/yyyy') date_time   from pr_wait_list_vw a ");

				if(install_yn.equals("Y"))
				{
					sql2.append(",or_order_catalog b  where a.facility_id = '"+fac_id+"'  and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+)  and  a.WAIT_LIST_STATUS ='O'  ");
				}else
				{
					sql2.append("where a.facility_id = '"+fac_id+"' and  a.WAIT_LIST_STATUS ='O'  ");
				}

				if (elapsed.equals("N"))
				{
					sql2.append("and ( trunc(a.PREFERRED_DATE_TIME)>=trunc(sysdate) or trunc(a.PREFERRED_DATE_TIME) is null )");

				}else if (elapsed.equals("Y"))
				{
					sql2.append(" and ( trunc(a.PREFERRED_DATE_TIME) between (sysdate- "+elapsed_grace_period+") and (sysdate) or trunc(a.PREFERRED_DATE_TIME) is null )");
				}
				
			}else if(wait_list_status.equals("I") )
			{
				//sql2.append("select  /*+rule+*/ WAIT_LIST_NO,to_char(a.INVITED_DATE_TIME,'dd/mm/yyyy') date_time  from pr_wait_list a");
				
				sql2.append("select  /*+rule+*/ WAIT_LIST_NO,to_char(a.INVITED_DATE_TIME,'dd/mm/yyyy') date_time  from pr_wait_list_vw a");

				if (install_yn.equals("Y"))
				{
					sql2.append(",or_order_catalog b  where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+) and  a.WAIT_LIST_STATUS ='I' ");
				}else
				{
					sql2.append(" where a.facility_id = '"+fac_id+"' and  a.WAIT_LIST_STATUS ='I' ");
				}
				if (elapsed.equals("N"))
				{
					sql2.append("and ( trunc(a.INVITED_DATE_TIME)>=trunc(sysdate))");

				}else if (elapsed.equals("Y"))
				{
					sql2.append(" and ( trunc(a.INVITED_DATE_TIME) between (sysdate- "+elapsed_grace_period+") and (sysdate))");
				}


			}else if(wait_list_status.equals("S") )
			{
				//sql2.append("select  /*+rule+*/ WAIT_LIST_NO ,to_char(a.PREFERRED_DATE_TIME,'dd/mm/yyyy') date_time from pr_wait_list a");
				
				sql2.append("select  /*+rule+*/ WAIT_LIST_NO ,to_char(a.PREFERRED_DATE_TIME,'dd/mm/yyyy') date_time from pr_wait_list_vw a");

				if(install_yn.equals("Y"))
				{
					sql2.append(",or_order_catalog b  where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+) and  a.WAIT_LIST_STATUS ='S' ");
				}else
				{
					sql2.append(" where a.facility_id = '"+fac_id+"' and a.WAIT_LIST_STATUS ='S' ");
				}
			}
				
			if (!specCode.equals("")) 
				sql3=sql3.append(" and a.SPECIALTY_CODE='"+specCode+"'");

			if(cliniccode.equals("")) res_type="";

			if (!clinic_type.equals("")) 
			sql3.append(" and CARE_LOCN_TYPE_IND='"+clinic_type+"'");

			if (!cliniccode.equals("")) 
				sql3.append(" and NVL(CLINIC_CODE,'*')='"+cliniccode+"'");

			if (!res_type.equals("")) 
				sql3.append(" and resource_class='"+res_type+"'");

			if(!priority1.equals(""))
				sql3.append(" and WAIT_LIST_PRIORITY='"+priority1+"'");

			if (!practcode.equals("")) 
				sql3.append(" and NVL(RESOURCE_ID,'*')='"+practcode+"'");

				if (!gender.equals(""))  
				sql3.append(" and gender='"+gender+"'");
				
			if (!WaitListNo.equals("")) 
				sql3=sql3.append(" and a.WAIT_LIST_NO='"+WaitListNo.trim()+"'");

			if (!patientid.equals(""))  
				sql3.append(" and a.patient_id='"+patientid+"'");

			
					sql3.append(" and UPPER(patient_name) like upper('"+patientname1+"%')");
					


			if (!waitListfrmdate.equals("")) 
				sql3.append("  and trunc(a.preferred_date_time)>=to_date('"+waitListfrmdate+"','dd/mm/yyyy')");

			if (!waitListTodate.equals(""))  
				sql3.append(" and trunc(a.preferred_date_time)<=to_date('"+waitListTodate+"','dd/mm/yyyy')");

			if (!nat_id_no.equals(""))
				sql3.append(" and a.NATIONAL_ID_NO='"+nat_id_no+"'");

			if (!alt_id1_no.equals(""))
				sql3.append(" and a.ALT_ID1_NO='"+alt_id1_no+"'");

			if (!alt_id1_type.equals(""))
				sql3.append(" and a.ALT_ID1_TYPE='"+alt_id1_type+"'");

			if (!alt_id2_no.equals(""))
				sql3.append(" and a.ALT_ID2_NO='"+alt_id2_no+"'");

			if (!alt_id2_type.equals(""))
				sql3.append(" and a.ALT_ID2_TYPE='"+alt_id2_type+"'");

			if (!alt_id3_no.equals(""))
				sql3.append(" and a.ALT_ID3_NO='"+alt_id3_no+"'");

			if (!alt_id3_type.equals(""))
				sql3.append(" and a.ALT_ID3_TYPE='"+alt_id3_type+"'");

			if (!alt_id4_no.equals("") )
				sql3.append(" and a.ALT_ID4_NO='"+alt_id4_no+"'");

			if (!alt_id4_type.equals("") )
				sql3.append(" and a.ALT_ID4_TYPE='"+alt_id4_type+"'");
			
			if (!other_alt_Id.equals(""))
				sql3.append(" and a.OTH_ALT_ID_NO='"+other_alt_Id+"'");
			
			if (!other_alt_type.equals(""))
				sql3.append(" and a.OTH_ALT_ID_TYPE='"+other_alt_type+"'");

			if	(!nat_id_code.equals(""))
				sql3.append(" and a.NATIONALITY_CODE ='"+nat_id_code+"'");

			if	(!r_area_code.equals(""))
				sql3.append(" and a.RES_AREA_CODE ='"+r_area_code+"'");

			if (!m_area_code.equals(""))
				sql3.append(" and a.MAIL_AREA_CODE ='"+m_area_code+"'");

			if	(!r_town_code.equals(""))
				sql3.append(" and a.RES_TOWN_CODE ='"+r_town_code+"'");

			if	(!m_town_code.equals(""))
				sql3.append(" and a.MAIL_TOWN_CODE ='"+m_town_code+"'");

			if	(!r_region_code.equals(""))
				sql3.append(" and a.RES_REGION_CODE ='"+r_region_code+"'");

			if	(!m_region_code.equals(""))
				sql3.append(" and a.MAIL_REGION_CODE ='"+m_region_code+"'");

			if (!wtlt_category_one.equals(""))
				sql3.append(" and a.WAITLIST_CATEGORY_CODE ='"+wtlt_category_one+"'");

			if (!wait_list_priority.equals(""))
				sql3.append(" and a.WAIT_LIST_PRIORITY ='"+wait_list_priority+"'");

			if(install_yn.equals("Y"))
			{
			if (!wtlt_category.equals(""))
				sql3.append(" and b.ORDER_CATALOG_CODE ='"+wtlt_category+"'");
			}

			if(order_by.equals("FIRST_ENCOUNTER_DATE") || order_by.equals(""))	
				{	
				sql3.append(" ORDER BY a.WAITLIST_CATEGORY_CODE ,a.FIRST_ENCOUNTER_DATE  "+order+" ");
				}else
				{

				sql3.append(" ORDER BY  a.WAITLIST_CATEGORY_CODE,to_number(a.WAIT_LIST_NO)  "+order+" ");
				}

				//break here
			if(flagSelect !=null)
			{
			waitlistinvitation.clearAll();
			waitlistinvitation1.clearAll();
			
			sqlmain=sql2.toString()+sql3.toString();
			sql2.setLength(0);
			st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rsSet=null;			
			rsSet 	= st.executeQuery(sqlmain);
			rsSet.last();
			i = rsSet.getRow();
			rsSet.beforeFirst();
			
			HashMap hash = new HashMap();
			if (rsSet!=null)
			{
				while(rsSet.next())
				{	
					hash.put("key"+rsSet.getString(1), "N");
					hash.put("date"+rsSet.getString(1), rsSet.getString(2));
 					waitlistinvitation1.putObject(rsSet.getString(1));
					//waitlistinvitation2.putObject(rsSet.getString(2));	
					//waitlistinvitation3.putObject("");
				}
			}			
			waitlistinvitation.putObject(hash);	
	}
	HashMap hashwait = new HashMap();
	String final_val="";
	if(from != null && to != null){
		int j=0;
		
		
		hashwait = (HashMap)waitlistinvitation.getObject(0);
		
        for( s=(Integer.parseInt(req_start)); s<=(Integer.parseInt(req_end)); s++)
		{
			
				if(request.getParameter("checkBox"+(s)) != null)
				{
						checkedOnes			= request.getParameter("checkBox"+(s));
						
						
						invitationdateval		= request.getParameter("invitation_date"+(s));
						waitliststatus			=request.getParameter("status_val"+(s));
						removeCode				= request.getParameter("remove_Code"+(s));
						final_val			=invitationdateval+"$"+waitliststatus;
						if(removeCode==null|| removeCode.equals(""))
						removeCode = "N";	
						//hashwait = (HashMap)waitlistinvitation.getObject(0);
						if(!(waitlistinvitation1.containsObject(checkedOnes))){
						
							waitlistinvitation1.putObject(checkedOnes);
							
							if(hashwait !=null){
								hashwait.put("key"+checkedOnes, "Y");
								hashwait.put("date"+checkedOnes, invitationdateval);
								hashwait.put("status"+checkedOnes, waitliststatus);
								
							}
							removeCode = "";
							invitationdateval ="";
							waitliststatus = "";
							checkedOnes		="";
							invitationdateval ="";
							waitliststatus	="";
							removeCode="";
							final_val="";	
						} 
						j++;
				}

				removeCode = checkForNull(request.getParameter("remove_Code"+(s)));
				
				
					if(removeCode.equals("Y"))
						{

							String waitlistn = request.getParameter("waitListNo"+(s));
							

							if(hashwait !=null){
							
								hashwait.put("key"+waitlistn, "N");
								hashwait.put("date"+waitlistn, null);
								hashwait.put("status"+waitlistn, null);	
							
								
							}
							
						
				
							//boolean obj=waitlistinvitation1.containsObject(waitlistn);
						
							
							if((waitlistinvitation1.containsObject(waitlistn)))
								{

									int removeCodeIndex = waitlistinvitation1.indexOfObject(waitlistn);
									
									waitlistinvitation1.removeObject(removeCodeIndex);
									}
						}
		}
		 if(hashwait!=null && hashwait.size()>0){
			// out.println(hashwait);
			waitlistinvitation.putObject(hashwait);	
		 }
		
					 
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
		s = 1 ;	
		


				//sql.append("select  /*+rule+*/ nvl(a.WAIT_LIST_NO,'') wait_list_no ,decode(a.WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority ,nvl(a.PATIENT_ID,'') patient_id, nvl(a.PATIENT_NAME,'') patient_name, to_char(a.PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time,decode(a.GENDER,'M','Male','F','Female','U','Unknown')GENDER ,get_age(a.DATE_OF_BIRTH) age,to_char(a.FIRST_ENCOUNTER_DATE, 'dd/mm/yyyy') FIRST_ENCOUNTER_DATE,a.waitlist_category_code, c.LONG_DESC waitlist_cat_desc,d.long_desc res_region_desc, a.last_encounter_id ");

				sql.append("select  /*+rule+*/ nvl(a.WAIT_LIST_NO,'') wait_list_no ,a.WAIT_LIST_PRIORITY priority ,nvl(a.PATIENT_ID,'') patient_id , decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name ,to_char(a.PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time,a.GENDER GENDER ,get_age(a.DATE_OF_BIRTH) age,to_char(a.FIRST_ENCOUNTER_DATE, 'dd/mm/yyyy') FIRST_ENCOUNTER_DATE, a.waitlist_category_code, OA_GET_DESC.OA_WAITLIST_CATEGORY(a.WAITLIST_CATEGORY_CODE,'"+locale+"','1') waitlist_cat_desc, MP_GET_DESC.MP_REGION(a.RES_REGION_CODE,'"+locale+"','1') res_region_desc, a.last_encounter_id ");
					
				if((wait_list_status.equals("O") || wait_list_status.equals("")  ))
					{
						if(install_yn.equals("Y"))
						{
						/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
							//sql.append("from pr_wait_list a, or_order_catalog b ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+) and a.wait_list_status='O' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+) and a.RES_REGION_CODE =d.REGION_CODE(+) ");
							
							/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
							sql.append("from pr_wait_list_vw a, or_order_catalog b ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+) and a.wait_list_status='O' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+) and a.RES_REGION_CODE =d.REGION_CODE(+) ");
						}else
						{
						/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
							 //sql.append("from pr_wait_list a,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.wait_list_status='O' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+)and a.RES_REGION_CODE =d.REGION_CODE(+) ");
							 
							 /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
							 sql.append("from pr_wait_list_vw a,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.wait_list_status='O' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+)and a.RES_REGION_CODE =d.REGION_CODE(+) ");
						}
						if (elapsed.equals("N"))
						{
							sql.append(" and ( trunc(a.PREFERRED_DATE_TIME)>=trunc(sysdate) or trunc(a.PREFERRED_DATE_TIME) is null )");
						}else if (elapsed.equals("Y"))
						{
							sql.append(" and ( trunc(a.PREFERRED_DATE_TIME) between (sysdate- "+elapsed_grace_period+") and (sysdate) or trunc(a.PREFERRED_DATE_TIME) is null )");
						}

					}else if(wait_list_status.equals("I") ){
						if(install_yn.equals("N"))
						{
						/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
						//sql.append(",to_char(a.INVITED_DATE_TIME, 'dd/mm/yyyy') INVITED_DATE_TIME from pr_wait_list a ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+)and a.RES_REGION_CODE =d.REGION_CODE(+) and a.wait_list_status='I' ");
						
						/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
						sql.append(",to_char(a.INVITED_DATE_TIME, 'dd/mm/yyyy') INVITED_DATE_TIME from pr_wait_list_vw a ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+)and a.RES_REGION_CODE =d.REGION_CODE(+) and a.wait_list_status='I' ");
						}else
						{
						/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
						//sql.append(",to_char(a.INVITED_DATE_TIME, 'dd/mm/yyyy') INVITED_DATE_TIME from pr_wait_list a, or_order_catalog b ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE =b.ORDER_CATALOG_CODE(+) and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+) and a.RES_REGION_CODE =d.REGION_CODE(+) and a.wait_list_status='I'");
						
						/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
						sql.append(",to_char(a.INVITED_DATE_TIME, 'dd/mm/yyyy') INVITED_DATE_TIME from pr_wait_list_vw a, or_order_catalog b ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE =b.ORDER_CATALOG_CODE(+) and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+) and a.RES_REGION_CODE =d.REGION_CODE(+) and a.wait_list_status='I'");
						}
					if (elapsed.equals("N"))
						{
							sql.append(" and ( trunc(a.INVITED_DATE_TIME)>=trunc(sysdate))");
						}else if (elapsed.equals("Y"))
						{
							sql.append(" and ( trunc(a.INVITED_DATE_TIME) between (sysdate- "+elapsed_grace_period+") and (sysdate))");
						}

						
					}else if(wait_list_status.equals("S"))
					{
						if(install_yn.equals("N"))
						{
						
						/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
						//	sql.append("from pr_wait_list a,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+)and a.RES_REGION_CODE =d.REGION_CODE(+)and a.wait_list_status='S' ");
						
						/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
							sql.append("from pr_wait_list_vw a,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+)and a.RES_REGION_CODE =d.REGION_CODE(+)and a.wait_list_status='S' ");
						}else
						{
						/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
							//sql.append("from pr_wait_list a, or_order_catalog b ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+) and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+) and a.RES_REGION_CODE =d.REGION_CODE(+) and a.wait_list_status='S'");
							/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
							sql.append("from pr_wait_list_vw a, or_order_catalog b ,OA_WAITLIST_CATEGORY c, mp_region d where a.facility_id = '"+fac_id+"' and a.ORDER_CATALOG_CODE = b.ORDER_CATALOG_CODE(+) and a.WAITLIST_CATEGORY_CODE =c.WAITLIST_CATEGORY_CODE(+) and a.RES_REGION_CODE =d.REGION_CODE(+) and a.wait_list_status='S'");
						}
					}
                
					
				//sqlmain2.append(sql.toString()+sql3.toString());
				sqlmain2.append(sql.toString()+"  AND (a.EFF_STATUS!='D' OR a.EFF_STATUS IS NULL) "+sql3.toString());
		
				sql3.setLength(0);
				sql.setLength(0);
				rs = null;
				st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=null;
				rs 	= st.executeQuery(sqlmain2.toString());
				rs.last();
				i = rs.getRow();
				
				rs.beforeFirst();

				sqlmain2.setLength(0);
		
			if(i == 0)
			{%>	<script>
			
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				parent.frames[3].location.href='../../eCommon/html/blank.html';
				</script>
				<%	
			}else{%>	
			<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' onLoad='chkForSelectAll(<%=start%>,<%=end%>)'>
		    <form name='QueryApptForPatient_one' id='QueryApptForPatient_one' action='../../eOA/jsp/WaitListInvitationQueryResult.jsp' method='post' >
						<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>
						<input type=hidden name='start' id='start' value='<%=start%>'>
						<input type=hidden name='end' id='end' value='<%=end%>'>
					 
	<table width='90%' border=0 align='center' >
		<tr>
		<td align='right' class='NONURGENT'>
	<%
		if ( !(start <= 1)) {
	%>
		<a href='javascript:submitPrevNext(<%=(start-6)%>,<%=(end-6)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
		if ( !((start+6) > i )){
	%>
		<a href='javascript:submitPrevNext(<%=(start+6)%>,<%=(end+6)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	
		

/*if ( !(start <= 1) ){
	

	out.println("<label  onClick=\"self.location.href='../../eOA/jsp/WaitListInvitationQueryResult.jsp?from="+(start-maxDispRecords)+"&to="+(end-maxDispRecords)+"&wait_list_status="+wait_list_status+"&waitListfrmdate="+waitListfrmdate+"&waitListTodate="+waitListTodate+"&clinic_type="+clinic_type+"&res_type="+res_type+"&wtlt_category="+wtlt_category+"&specCode="+specCode+"&install_yn="+install_yn+"&elapsed_grace_period="+elapsed_grace_period+"&elaspsed="+elapsed+"&wtlt_category_one="+wtlt_category_one+"&nat_id_no="+nat_id_no+"&alt_id1_no="+alt_id1_no+"&alt_id2_no="+alt_id2_no+"&alt_id3_no="+alt_id3_no+"&alt_id4_no="+alt_id4_no+"&other_alt_Id="+other_alt_Id+"&nat_id_code="+nat_id_code+"&m_area="+m_area_code+"&r_region="+r_region_code+"&m_region="+m_region_code+"&r_town="+r_town_code+"&m_town="+m_town_code+"&r_area="+r_area_code+"&install_yn_ca="+install_yn_ca+"&priority="+priority1+"&order_by="+order_by+"&order="+order+"&oper_stn_id="+oper_stn_id+"&fac_id="+fac_id+"&first_encounter_date="+first_encounter_date+"&eid="+last_encounter_id+"&patientid="+patientid+"&patientName="+patientName+"&gender="+gender+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&cliniccode="+cliniccode+"&practcode="+practcode+"&maxrecord="+i+"';\" style='cursor:pointer'><font color='BLUE'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font></label>");
	}

  if ( !( (start+maxDispRecords) > i ) ){

	  out.println("<A HREF='../../eOA/jsp/WaitListInvitationQueryResult.jsp?from="+(start+maxDispRecords)+"&to="+(end+maxDispRecords)+"&wait_list_status="+wait_list_status+"&waitListfrmdate="+waitListfrmdate+"&waitListTodate="+waitListTodate+"&clinic_type="+clinic_type+"&res_type="+res_type+"&wtlt_category="+wtlt_category+"&specCode="+specCode+"&install_yn="+install_yn+"&elapsed_grace_period="+elapsed_grace_period+"&elaspsed="+elapsed+"&wtlt_category_one="+wtlt_category_one+"&nat_id_no="+nat_id_no+"&alt_id1_no="+alt_id1_no+"&alt_id2_no="+alt_id2_no+"&alt_id3_no="+alt_id3_no+"&alt_id4_no="+alt_id4_no+"&other_alt_Id="+other_alt_Id+"&nat_id_code="+nat_id_code+"&m_area="+m_area_code+"&r_region="+r_region_code+"&m_region="+m_region_code+"&r_town="+r_town_code+"&m_town="+m_town_code+"&r_area="+r_area_code+"&install_yn_ca="+install_yn_ca+"&priority="+priority1+"&order_by="+order_by+"&order="+order+"&oper_stn_id="+oper_stn_id+"&fac_id="+fac_id+"&first_encounter_date="+first_encounter_date+"&eid="+last_encounter_id+"&patientid="+patientid+"&patientName="+patientName+"&gender="+gender+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&cliniccode="+cliniccode+"&practcode="+practcode+"&maxrecord="+i+"';\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	}*/
%>

<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
			<input type='hidden' name='ALCN_CRITERIA_YN' id='ALCN_CRITERIA_YN' value='<%=ALCN_CRITERIA_YN%>'>
			<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
			<input type='hidden' name='first_encounter_date' id='first_encounter_date' value='<%=first_encounter_date%>'>
			<input type='hidden' name='eid' id='eid' value='<%=last_encounter_id%>'>
			<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>'>
			<input type='hidden' name='maxrecord' id='maxrecord' value='<%=i%>'>
			<input type='hidden'   name='Operation' id='Operation' value='invitation'>
			<input type='hidden'   name='endcnt' id='endcnt' value='<%=hilgtcnt%>'>
		
	</td>
	 </tr>
		</table>
				
				<table border="1" width="100%" bgcolor='white' cellspacing='0' cellpadding='0' id='tb1'>
				<td class='COLUMNHEADER' nowrap width='3%'>&nbsp;</td>
				<td class='COLUMNHEADER' nowrap width='10%' ><fmt:message key="eOA.InvitationDate.label" bundle="${oa_labels}"/>&nbsp;</td>
				<td class='COLUMNHEADER' nowrap width='8%' ><fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;<img id='image' align=center src='../../eCommon/images/mandatory.gif'></img></td>
				<td class='COLUMNHEADER' nowrap width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class='COLUMNHEADER' nowrap width='11%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class='COLUMNHEADER' nowrap  width='5%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap width='4%'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap width='7%'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>


				<td class='COLUMNHEADER' nowrap width='13%' onclick ="sort('arrival_date','<%=order%>');"  style='cursor:pointer'><fmt:message key="eOA.ArrivalDate.label" bundle="${oa_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='arrv_date' id='arrv_date' style='visibility:hidden'></td>
				<td class='COLUMNHEADER' nowrap width='13%'><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap	 width='5%' onclick ="sort('wait_lst_num','<%=order%>');"  style='cursor:pointer' ><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='wait_lst_num' ></td>
				<td class='COLUMNHEADER' nowrap width='12%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				
				
				<%

				HashSet tabdata;	
			 tabdata = new HashSet();	
				int rowcolor=0;
				int k=1;
				String chkAttribute	="";
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}

				if(rs != null)
				{
					
					while ( rs.next() && s<=end )
					{
						waitListNo =rs.getString("wait_list_no");
						priority = rs.getString("priority");
						if(priority.equals("U"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
						}else if(priority.equals("S"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiurgent.label","common_labels");
						}else if(priority.equals("N"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
						}
						waitlist_category_code =rs.getString("WAITLIST_CATEGORY_CODE");
						if(waitlist_category_code ==null) waitlist_category_code="";
						waitlist_cat_desc=rs.getString("WAITLIST_CAT_DESC");
						if(waitlist_cat_desc ==null) waitlist_cat_desc="";
						patientId = rs.getString("patient_id");	

						

						
						patientName	=rs.getString("patient_name");
						
						preferedDate =rs.getString("pref_date_time");						
						age=rs.getString("age");
						if(age==null) age="";
						Gender=rs.getString("GENDER");
					
						if(Gender.equals("M") )
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						}else if(Gender.equals("F"))
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						}else if(Gender.equals("U"))
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}

						res_region_desc=rs.getString("res_region_desc");
						if (res_region_desc ==null) res_region_desc="";
						if(wait_list_status.equals("I"))
						{
						invited_date_time =rs.getString("INVITED_DATE_TIME");
						if(invited_date_time==null)	 invited_date_time="";
						}
						first_encounter_date=rs.getString("FIRST_ENCOUNTER_DATE");
						if(first_encounter_date ==null) first_encounter_date="";
						String first_encounter_date_display=DateUtils.convertDate(first_encounter_date,"DMY","en",locale);
						last_encounter_id= rs.getString("last_encounter_id");
						if(last_encounter_id ==null) last_encounter_id="";
						if (waitListNo==null) waitListNo="";
						if (priority==null) priority="";
						if (patientId==null) patientId="";
						if (patientName==null) 
							patientName="";
						else
						if (patientName.length() >= 25) patientName=patientName.substring(0,25);
						
						if (locationDesc==null) locationDesc="";
						if (resourceClass==null) resourceClass="";
						if (preferedDate==null) preferedDate ="";
						preferedDate_display=DateUtils.convertDate(preferedDate,"DMY","en",locale);
						if (specialityDesc==null) specialityDesc="";
						if (resource==null) resource="";
						if (clinicDesc==null) clinicDesc="";
						if (careLocnTypeInd==null) careLocnTypeInd="";
						if (clinicCode==null) clinicCode="";
						if (resourceId==null) resourceId="";
						if (specialityCode==null) specialityCode="";
						if (resClass==null) resClass="";

						tabdata.add(waitlist_category_code);
				if(waitlistinvitation.getSize() >0)
						{
					for(int m=0;m<waitlistinvitation.getSize();m++)
					{

	
					HashMap hashWait = (HashMap)waitlistinvitation.getObject(0);
					
 					if(hashWait!=null){
					//	if(dummyCheckedValue==null || dummyCheckedValue.equals("N"))
							//dummyCheckedValue	= "Y";

						if(hashWait.containsKey("key"+waitListNo)){
							dummyCheckedValue = (String)hashWait.get("key"+waitListNo);
						 waitlistinviteddate1 = (String)hashWait.get("date"+waitListNo);
						 waitliststatus1 =(String)hashWait.get("status"+waitListNo);
						 
 						if(waitlistinviteddate1!=null && !waitlistinviteddate1.equals("#"))
							{
							 invited_date_time	= waitlistinviteddate1;
							 preferedDate=waitlistinviteddate1;
							 preferedDate_display=DateUtils.convertDate(preferedDate,"DMY","en",locale);
							}
 						}
						

 					}

						}
				}
				if(waitlistinvitation1.containsObject(waitListNo))  
					chkAttribute = "CHECKED";
				else
					chkAttribute = "";


				int recordIndex = waitlistinvitation1.indexOfObject(waitListNo);
				if(recordIndex!=-1)
				{
					if(chkAttribute.equals("CHECKED"))    
					{
						waitlistinvitation1.removeObject(recordIndex);
						//waitlistinvitation2.removeObject(recordIndex);
						//waitlistinvitation3.removeObject(recordIndex);
						
					}
				}
					
						if (  s%2 == 0 )
							classValue = "QRYEVENSMALL" ;
						else
							classValue = "QRYODDSMALL" ;

						if(waitliststatus1 ==null) waitliststatus1="";
						%>

						<%if(!waitlist_category_code.equals(waitlist_category_code_prev)){%>
			<tr >
							<td class=MRHEADER   width='11%' colspan='3'><%=waitlist_cat_desc%>&nbsp;</td>
							<td class=MRHEADER   width='10%'>&nbsp;</td>
							<td class=MRHEADER   width='11%'>&nbsp;</td>
							<td class=MRHEADER   width='5%'>&nbsp;</td>
							<td class=MRHEADER   width='4%'>&nbsp;</td>
							<td class=MRHEADER   width='7%'>&nbsp;</td>
							<td class=MRHEADER   width='13%'>&nbsp;</td>
							<td class=MRHEADER   width='13%'>&nbsp;</td>
							<td class=MRHEADER   width='5%'>&nbsp;</td>
							<td class=MRHEADER   width='12%'>&nbsp;</td>
			</tr>
			<tr >
						<td class='<%=classValue%>' width='3%' align='center' nowrap><input type='checkbox' name='checkBox<%= s %>' id='checkBox<%= s %>' <%= chkAttribute %> onClick='javascript:checkBoxOnClick(this, <%= waitListNo %>, invitation_date<%= s %>, <%= s %>);' value='<%= waitListNo %>'><input type='hidden'  name='remove_Code<%= s %>' id='remove_Code<%= s %>' value=''><input type="hidden" name='dummyCheckedValue<%= s %>' id='dummyCheckedValue_<%= s %>'  value='<%= dummyCheckedValue %>'>
						<input type='hidden' name='waitListNo<%=s%>' id='waitListNo<%=s%>' value='<%=waitListNo%>' >&nbsp; </td>
						
							<%if (wait_list_status.equals("I")){								
								%>
							
							<td class="<%=classValue%>"   width='10%' nowrap><input type='text' name='invitation_date<%=s%>' id='invitation_date<%=s%>' size='10' maxlength='10'  value='<%=invited_date_time%>' onBlur="validate_date_one(this,<%=s%>);clear_value(this,checkBox<%=s%>);"><img  style="cursor:pointer" id='img1'   src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].invitation_date<%=s%>.focus();return showCalendar('invitation_date<%=s%>');">&nbsp;<input type='hidden' name='date_val' id='date_val' value=''></td>
						
							<%}else {								
								%>
							
							<td class="<%=classValue%>"   width='10%' nowrap><input type='text' name='invitation_date<%=s%>' id='invitation_date<%=s%>' size='10' maxlength='10'  value='<%=preferedDate_display%>' onBlur="validate_date_one(this,<%=s%>);clear_value(this,checkBox<%=s%>);"><img  style="cursor:pointer" id='img1'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].invitation_date<%=s%>.focus();document.forms[0].invitation_date<%=s%>.select();return showCalendar('invitation_date<%=s%>');"> &nbsp;<input type='hidden' name='date_val' id='date_val' value=''></td>
							<%}%>
							
							<td class='<%=classValue%>' width='8%' nowrap>	<select name='status_val<%=s%>' id='status_val<%=s%>' onchange='call_statuc_chk(this,<%=s%>,invitation_date<%=s%>)' onblur="/*chk_val(this,<%=s%>)*/">
							<%
							
						
						if(wait_list_status.equals("S") && waitliststatus1.equals("I")){%>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("S") && waitliststatus1.equals("O")) {%>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("S") && waitliststatus1.equals("")) {%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("I")) {%>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("O")) {%>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("S")) {%>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("")) {%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<%}else if(wait_list_status.equals("O") && waitliststatus1.equals("I")){%>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>	
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("O") && waitliststatus1.equals("S")) {%>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("O") && waitliststatus1.equals("")) {%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<%}%>
							</select></td>
					<%
						//if(last_encounter_id=="null")last_encounter_id="";
							if(!last_encounter_id.equals("") && install_yn_ca.equals("Y")){	%>
						
						<td class="<%=classValue%>"   width='8%' id='clrchse<%=hilgtcnt%>' nowrap><a href="javascript:onclick=view_discharge('<%=last_encounter_id%>','<%=patientId%>','clrchse<%=hilgtcnt%>')"><%=patientId%>&nbsp;</a></td>
								
						<%}else{%>
								
						<td class="<%=classValue%>"  width='8%' id='clrchse<%=hilgtcnt%>' > <%=patientId%>&nbsp;</td>
								
						<%}%>
						
						<td class="<%=classValue%>"  id='patname<%=hilgtcnt%>'  width='10%' nowrap>
						<%=patientName%>&nbsp;</td>
						<td class='<%=classValue%>' id='gender<%=hilgtcnt%>' width='5%' nowrap><%=gender1%>&nbsp;</td>
						<td class='<%=classValue%>' id='age<%=hilgtcnt%>' width='4%' nowrap><%=age%>&nbsp;</td>
						<td class="<%=classValue%>" id='region<%=hilgtcnt%>'  width='7%' nowrap>
						<%=res_region_desc%>&nbsp;</td>
						<td class='<%=classValue%>' width='13%' id='firstencounterdate<%=hilgtcnt%>' nowrap><%=first_encounter_date_display%>&nbsp; </td>
						<%if(!patientId.equals("")){ %>
						<td class='<%=classValue%>' id='preenc<%=hilgtcnt%>' width='9%' ><a href='javascript:onclick=past_visits_view("<%=patientId%>")'><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></a></td>
						<%}else{%>
								<td class='<%=classValue%>' id='preenc<%=hilgtcnt%>' width='9%' >
						<%}%>
						<td class='<%=classValue%>' width='5%' nowrap id='waitLst<%=hilgtcnt%>' > 				
						<%=waitListNo%>&nbsp;<input type='hidden' name='wait_num<%=s%>' id='wait_num<%=s%>' value='<%=waitListNo%>'></td>
						<td class='<%=classValue%>' width='12%' id='priority<%=hilgtcnt%>' nowrap ><%=priority_desc%>&nbsp;</td>
							
			</tr>


							<%}else{%>
			<tr >
						<td class='<%=classValue%>' width='3%' align='center' nowrap><input type='checkbox' id='check_box' name='checkBox<%=s%>' id='checkBox<%=s%>' <%=chkAttribute%> onClick='javascript:checkBoxOnClick(this,<%=waitListNo%>,invitation_date<%=s%>,<%=s%>);' value='<%=waitListNo%>'><input type='hidden' name='remove_Code<%=s%>' id='remove_Code<%=s%>' value=""><INPUT TYPE="hidden" name='dummyCheckedValue<%=s%>' id='dummyCheckedValue<%=s%>' value='<%=dummyCheckedValue%>'>
						<input type='hidden' name='waitListNo<%=s%>' id='waitListNo<%=s%>' value='<%=waitListNo%>'>&nbsp; </td>
							
							<%if (wait_list_status.equals("I")){%>
							
						<td class="<%=classValue%>"   width='10%' nowrap><input type='text' name='invitation_date<%=s%>'   id='invitation_date<%=s%>' size='10' maxlength='10'  value='<%=invited_date_time%>' onBlur="validate_date_one(this,<%=s%>);clear_value(this,checkBox<%=s%>);"><img  style="cursor:pointer" id='img1'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].invitation_date<%=s%>.focus();return showCalendar('invitation_date<%=s%>');"> &nbsp;<input type='hidden' name='date_val' id='date_val' value=''></td>
						
							<%}else {%>
							
						<td class="<%=classValue%>"   width='10%' nowrap><input type='text' name='invitation_date<%=s%>' id='invitation_date<%=s%>' size='10' maxlength='10'  value='<%=preferedDate_display%>' onBlur="validate_date_one(this,<%=s%>);clear_value(this,checkBox<%=s%>);"><img  style="cursor:pointer" id='img1'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].invitation_date<%=s%>.focus();document.forms[0].invitation_date<%=s%>.select();return showCalendar('invitation_date<%=s%>');"> &nbsp;<input type='hidden' name='date_val' id='date_val' value=''></td>
							<%}%>
							
						<td class='<%=classValue%>' width='8%' nowrap>
						<select name='status_val<%=s%>' id='status_val<%=s%>' onchange='call_statuc_chk(this,<%=s%>,invitation_date<%=s%>)' onblur="/*chk_val(this,<%=s%>)*/" >
						<%if(wait_list_status.equals("S") && waitliststatus1.equals("I")){%>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("S") && waitliststatus1.equals("O")) {%>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("S") && waitliststatus1.equals("")) {%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("I")) {%>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("O")) {%>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("S")) {%>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("I") && waitliststatus1.equals("")) {%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<%}else if(wait_list_status.equals("O") && waitliststatus1.equals("I")){%>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>	
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("O") && waitliststatus1.equals("S")) {%>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<%}else if(wait_list_status.equals("O") && waitliststatus1.equals("")) {%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/></option>
						<%}%></select>
						</td>


						<%if(!last_encounter_id.equals("") && install_yn_ca.equals("Y")){%>
						<td class="<%=classValue%>"   width='8%'  id='clrchse<%=hilgtcnt%>' nowrap><a href="javascript:onclick=view_discharge('<%=last_encounter_id%>','<%=patientId%>','clrchse<%=hilgtcnt%>')"><%=patientId%>&nbsp;</a></td>
								<%}else{%>
								<td class="<%=classValue%>" id='clrchse<%=hilgtcnt%>' nowrap width='8%'><%=patientId%>&nbsp;</td>
								<%}%>
						<td class="<%=classValue%>"  id='patname<%=hilgtcnt%>' width='10%' nowrap>
						<%=patientName%>&nbsp;</td>
						<td class='<%=classValue%>' id='gender<%=hilgtcnt%>' width='4%' nowrap><%=gender1%>&nbsp;</td>
						<td class='<%=classValue%>' id='age<%=hilgtcnt%>' width='4%' nowrap><%=age%>&nbsp;</td>
						<td class="<%=classValue%>" id='region<%=hilgtcnt%>'  width='7%'nowrap>
						<%=res_region_desc%>&nbsp;</td>
						<td class='<%=classValue%>' id='firstencounterdate<%=hilgtcnt%>' width='13%'nowrap ><%=first_encounter_date_display%>&nbsp; </td>
						
						<%if(!patientId.equals("")){ %>

						<td class='<%=classValue%>' width='9%' id='preenc<%=hilgtcnt%>' nowrap>
						
						<a href='javascript:onclick=past_visits_view("<%=patientId%>")'><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></a>

						</td><%}
						else{%>
						<td class='<%=classValue%>' width='9%' id='preenc<%=hilgtcnt%>' nowrap>&nbsp;</td>
						<%}%>

						<td class='<%=classValue%>' width='5%' id='waitLst<%=hilgtcnt%>' nowrap> 				
						<%=waitListNo%>&nbsp;<input type='hidden' name='wait_num<%=s%>' id='wait_num<%=s%>' value='<%=waitListNo%>'></td>
						<td class='<%=classValue%>' width='12%' id='priority<%=hilgtcnt%>' nowrap><%=priority_desc%>&nbsp;</td>	
				</tr>
					<%}%>
					<!-- <input type='hidden' name='status_val<%=k%>' id='status_val<%=k%>' value=''>	 -->
					<%
							waitlist_category_code_prev = rs.getString("WAITLIST_CATEGORY_CODE");
							if(waitlist_category_code_prev ==null) waitlist_category_code_prev="";
							 invited_date_time="";
								waitliststatus1="";
							k=k+1;
					rowcolor++;
					s++;
				hilgtcnt++;
				}//while loop
		}//if

%>

		
			<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
			<input type='hidden' name='ALCN_CRITERIA_YN' id='ALCN_CRITERIA_YN' value='<%=ALCN_CRITERIA_YN%>'>
			<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
			<input type='hidden' name='first_encounter_date' id='first_encounter_date' value='<%=first_encounter_date%>'>
			<input type='hidden' name='eid' id='eid' value='<%=last_encounter_id%>'>
			<input type='hidden' name='patientid' id='patientid' value='<%=patientid%>'>
			<input type='hidden' name='maxrecord' id='maxrecord' value='<%=i%>'>
			<input type='hidden'   name='Operation' id='Operation' value='invitation'>
			<input type='hidden'   name='endcnt' id='endcnt' value='<%=hilgtcnt%>'>
			</table>
				

  <%}// any rec present

	if ( rs != null ) rs.close() ;
	if ( rsSet!=null) rsSet.close();
	if ( stmt != null ) stmt.close() ;
	if ( st != null ) st.close();
%><script>
	toggleGifs('<%=order_by%>','<%=order%>')

</script><%
}	catch ( Exception e ){
	e.printStackTrace();
	//out.println("Exception : "+e);
}finally
{
	ConnectionManager.returnConnection(conn,request);
		
	
	session.setAttribute("waitlistinvitation", waitlistinvitation);
	session.setAttribute("waitlistinvitation1", waitlistinvitation1);
	//session.setAttribute("waitlistinvitation2", waitlistinvitation2);
	//session.setAttribute("waitlistinvitation3", waitlistinvitation3);

}
%>  

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='white'>
<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
<tr><td width='100%' id='t'></td></tr>
</table>
</div>	 
</center>
<input type=hidden name='wait_list_status' id='wait_list_status' value='<%=wait_list_status%>'>
		<input type=hidden name='specCode' id='specCode' value='<%=specCode%>'>
			<input type=hidden name='elaspsed' id='elaspsed' value='<%=elapsed%>'>
			<input type=hidden name='cliniccode' id='cliniccode' value='<%=cliniccode%>'>
			<input type=hidden name='practcode' id='practcode' value='<%=practcode%>'>
			<input type=hidden name='waitListfrmdate' id='waitListfrmdate' value='<%=waitListfrmdate%>'>
			<input type=hidden name='waitListTodate' id='waitListTodate' value='<%=waitListTodate%>'>
			<input type=hidden name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
			<input type=hidden name='res_type' id='res_type' value='<%=res_type%>'>
			<input type=hidden name='elapsed_grace_period' id='elapsed_grace_period' value='<%=elapsed_grace_period%>'>
			<input type=hidden name='wtlt_category' id='wtlt_category' value='<%=wtlt_category%>'>
			<input type=hidden name='wtlt_category_one' id='wtlt_category_one' value='<%=wtlt_category_one%>'>
			<input type=hidden name='nat_id_no' id='nat_id_no' value="<%=nat_id_no%>">
			<input type=hidden name='alt_id1_no' id='alt_id1_no' value="<%=alt_id1_no%>">
			<input type=hidden name='alt_id1_type' id='alt_id1_type' value="<%=alt_id1_type%>">
			<input type=hidden name='alt_id2_no' id='alt_id2_no' value="<%=alt_id2_no%>">
			<input type=hidden name='alt_id2_type' id='alt_id2_type' value="<%=alt_id2_type%>">
			<input type=hidden name='alt_id3_no' id='alt_id3_no' value="<%=alt_id3_no%>">
			<input type=hidden name='alt_id3_type' id='alt_id3_type' value="<%=alt_id3_type%>">
			<input type=hidden name='alt_id4_no' id='alt_id4_no' value="<%=alt_id4_no%>">
			<input type=hidden name='alt_id4_type' id='alt_id4_type' value="<%=alt_id4_type%>">
			<input type=hidden name='other_alt_Id' id='other_alt_Id' value="<%=other_alt_Id%>">
			<input type=hidden name='other_alt_type' id='other_alt_type' value="<%=other_alt_type%>">
			<input type=hidden name='nat_id_code' id='nat_id_code' value="<%=nat_id_code%>">
			<input type=hidden name='r_area' id='r_area' value="<%=r_area_code%>">
			<input type=hidden name='m_area' id='m_area' value="<%=m_area_code%>">
			<input type=hidden name='r_region' id='r_region' value="<%=r_region_code%>">
			<input type=hidden name='m_region' id='m_region' value="<%=m_region_code%>">
			<input type=hidden name='r_town' id='r_town' value="<%=r_town_code%>">
			<input type=hidden name='m_town' id='m_town' value="<%=m_town_code%>">
			<input type=hidden name='priority' id='priority' value="<%=priority1%>">
		<input type=hidden name='install_yn' id='install_yn' value='<%=install_yn%>'>
		<input type=hidden name='install_yn_ca' id='install_yn_ca' value='<%=install_yn_ca%>'>
		<input type=hidden name='order_by' id='order_by' value='<%=order_by%>'>
		<input type=hidden name='order' id='order' value='<%=order%>'>
		<input type=hidden name='patientName' id='patientName' value='<%=patientName%>'>
		<input type=hidden name='gender' id='gender' value='<%=gender%>'>

<!-- 		<script>if(parent.frames[1].document.forms[0].fromSelect.value=="fromSelect")</script>
 --></form>
</body>
</html>
<%!
	
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

