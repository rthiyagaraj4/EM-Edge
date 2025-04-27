
<%
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100				?           	created
04/03/2013		IN037676		Dinesh T		Signing the addendum is controlled by the note type parameter
07/03/2013		IN038384		Dinesh T		Signing the others addendum is not proper at section level
02/06/2014		IN037701		Nijitha			SKR-CRF-0036
12/03/2014      PER1203			Nijitha			Performance changes suggested by sunil
23/07/2021		21820			Ramesh G		GHL-SCF-1585
-----------------------------------------------------------------------------------------------

*/
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*,java.sql.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
	request.setCharacterEncoding("UTF-8");
	String facility_id				=	(String)session.getValue("facility_id"); //21820
	String resp_id					=	(String)session.getValue("responsibility_id");
	String practitioner_id		=	(String)session.getValue("ca_practitioner_id");

	String validate 		= request.getParameter( "validate" )==null?"":request.getParameter( "validate" );
	String flag				= request.getParameter("flag")==null?"":request.getParameter( "flag" );
	String locale				= request.getParameter("localeName")==null?"":request.getParameter( "localeName" );
	
	String l_task = request.getParameter("task")==null?"":request.getParameter("task");//IN037676
	String l_access_num = request.getParameter("accessnum")==null?"":request.getParameter("accessnum");//IN037676
	String l_note_type = request.getParameter("noteType")==null?"":request.getParameter("noteType");//IN037676

	String p_event_class_widget = "";//IN037701
	StringBuffer sqlQuery = new StringBuffer();
	String appl_task_id = "";
	String c_note_type = "";
	String patient_class = "";
	String speciality_list = "";
	String p_note_type = "";
	String called_from = "";
	String note_group_req = "";
	StringBuffer note_group_query = new StringBuffer();

	Connection				con					= null;	
	PreparedStatement		pstmt				= null;
	ResultSet				rs					= null;	
	int count = 1 ; 
	int count1 = 1 ; 

	String practName = "";//IN037676
	PreparedStatement addendumTextPstmt = null;//IN037676
	ResultSet addendumTextRs = null;//IN037676

	String signAddendumSql = "select SIGN_ADDENM_OTH_YN from ca_note_type where note_type = ? ";//IN037676
	PreparedStatement signAddendumPstmt = null;//IN037676
	ResultSet signAddendumRs = null;//IN037676
	String signOthAddendumYN = "";//IN037676

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;

	if ( validate == null || validate.equals( "" ) )
		return ;
		
	try {
		//java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
		con			= ConnectionManager.getConnection(request);//PER1203
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		if (flag == null || flag.equals("")) {
			if ( validate.equals( "note_list" ) ) {
				String filter_by = (String)hash.get("filter_by") ;
				if(filter_by==null || filter_by.equals("null") || filter_by.equals("") ){
					out.println( "clearNoteTypeValues('document','note_type');");
					out.println( "clearNoteTypeValues('document','note_group');");
				}else{
					appl_task_id = (String)hash.get("appl_task_id") ;
					c_note_type = (String)hash.get("c_note_type") ;
					patient_class = (String)hash.get("patient_class") ;
					called_from = (String)hash.get("called_from") ;
					note_group_req = (String)hash.get("note_group_req") ;
					p_event_class_widget = (String)hash.get("p_event_class_widget") ;//IN037701

					note_group_query.append(" Select note_group, note_group_desc from ca_note_group_lang_vw  a  where a.eff_status='E'  and a.language_id = ? ");

					if(!p_note_type.equals(""))
						note_group_query.append(" and a.note_group =( select note_group_id from ca_note_type where note_type = ? ) ");
					else if (!appl_task_id.equals(""))
						note_group_query.append("  and a.APPL_TASK_ID=?  ");	
				  
					if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT")){
							note_group_query.append("  and a.note_group = ?  ");
					}

					if (filter_by.equals("R")){	
						sqlQuery.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resp a , ca_note_type_lang_vw c where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ? and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");	  																
						note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resp ib where ib.resp_id=? and ib.note_type=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1)");
					}else if (filter_by.equals("P") ){
						sqlQuery.append("Select a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resource ib where ib.resource_type=? and ib.RESOURCE_CODE=? and ib.note_type_id=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1)");							
				    }else if (filter_by.equals("S")){
						speciality_list = (String)hash.get("speciality_list") ;
						if (speciality_list==null) speciality_list="";
					
						sqlQuery.append("Select distinct a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? ");
						  
						if (!(speciality_list.equals("")))
							sqlQuery.append(" and a.RESOURCE_CODE = ? ");
						else
							sqlQuery.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)  ");

						sqlQuery.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )  ");
						 
						 // if ((filter_by.equals("S"))&&(speciality_list.equals(""))

						note_group_query.append(" and exists (select 1 from ca_note_type ia,ca_note_type_for_resource ib where ib.resource_type=? ");
						if (!(speciality_list.equals("")))
							note_group_query.append(" and ib.RESOURCE_CODE=? ");
						else
							note_group_query.append(" and ib.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ? AND FACILITY_ID=? )  ");  //21820 added Facility_id
						note_group_query.append(" and ib.note_type_id=ia.note_type and ia.NOTE_GROUP_ID = a.NOTE_GROUP and rownum=1)");						

				    }
					
					if(!p_note_type.equals(""))
						sqlQuery.append(" 	and c.note_type = ? ");
					else
						sqlQuery.append(" 	AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) ");
					//IN037701 Starts
					if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
					{
						sqlQuery.append(" 	AND C.EVENT_CLASS= ? ");
					}
					//IN037701 Ends
					if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
					{
						sqlQuery.append(" AND c.NOTE_GROUP_ID = ? ");
					}
				
					sqlQuery.append(" 	order by  2 ");			
					note_group_query.append("  order by 2");
				
					try
					{								
						
						pstmt		=	con.prepareStatement(sqlQuery.toString());	
						
						
						if (filter_by.equals("R")) {
							pstmt.setString(count1++,resp_id);
							pstmt.setString(count1++,locale);
							pstmt.setString(count1++,patient_class);
							if(!p_note_type.equals(""))
								pstmt.setString(count1++,p_note_type);
							else
								pstmt.setString(count1++,appl_task_id);
							//IN037701 Starts
							if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
							{
								//p_event_class_widget
								 pstmt.setString(count1++,p_event_class_widget);
							}
							//IN037701 Ends
						}else if (filter_by.equals("P")){
							pstmt.setString(count1++,"P");
							pstmt.setString(count1++,practitioner_id);
							pstmt.setString(count1++,locale);
							pstmt.setString(count1++,patient_class);
							pstmt.setString(count1++,resp_id);
							if(!p_note_type.equals(""))
								pstmt.setString(count1++,p_note_type);
							else
								pstmt.setString(count1++,appl_task_id);
							//IN037701 Starts
							if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
							{
								//p_event_class_widget
								 pstmt.setString(count1++,p_event_class_widget);
							}
							//IN037701 Ends
						}else if (filter_by.equals("S")){
							pstmt.setString(count1++,"S");
							if (!speciality_list.equals(""))
							{
								pstmt.setString(count1++,speciality_list);
								pstmt.setString(count1++,locale);
								pstmt.setString(count1++,patient_class);
								pstmt.setString(count1++,resp_id);
								if(!p_note_type.equals(""))
									pstmt.setString(count1++,p_note_type);
								else
									pstmt.setString(count1++,appl_task_id);
								//IN037701 Starts
								if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
								{
									//p_event_class_widget
									 pstmt.setString(count1++,p_event_class_widget);
								}
								//IN037701 Ends
							}else{
								pstmt.setString(count1++,practitioner_id);
								pstmt.setString(count1++,practitioner_id);
								pstmt.setString(count1++,locale);
								pstmt.setString(count1++,patient_class);
								pstmt.setString(count1++,resp_id);
								if(!p_note_type.equals(""))
									pstmt.setString(count1++,p_note_type);
								else
									pstmt.setString(count1++,appl_task_id);
								//IN037701 Starts
								if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
								{
									//p_event_class_widget
									 pstmt.setString(count1++,p_event_class_widget);
								}
								//IN037701 Ends
							}
						}
						if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
						{
							pstmt.setString(count1++,note_group_req);
						}
						rs			=	pstmt.executeQuery();
						out.println( "clearNoteTypeValues('document','note_type');");
						while(rs.next())
						{							
							String selected = "false";							
							out.println( "addNoteTypeList(\"" + rs.getString("note_type") + "\",\"" + rs.getString("note_type_desc") + "\",\"" + selected + "\") ; " ) ;							
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}catch(Exception e){
						e.printStackTrace();
						//out.println("Exception@2 SpltyCode: "+e);//COMMON-ICN-0181
					}		
					
					try{
						pstmt		=	con.prepareStatement(note_group_query.toString());	

						pstmt.setString(count++,locale);	
						if(!p_note_type.equals(""))
							pstmt.setString(count++,p_note_type);
						else if (!appl_task_id.equals(""))
							pstmt.setString(count++, appl_task_id);

						if(appl_task_id.equals("PROGRESS_NOTES")&&called_from.equals("OH_TREATMENT"))
						{
							pstmt.setString(count++, note_group_req );
						}

						if (filter_by.equals("R")) 
							pstmt.setString(count++,resp_id);
						else  if (filter_by.equals("P"))
						{
							pstmt.setString(count++,"P");
							pstmt.setString(count++,practitioner_id);
						}
						else  if (filter_by.equals("S"))
						{
							pstmt.setString(count++,"S");
						  if (!(speciality_list.equals("")))
							pstmt.setString(count++,speciality_list);
						  else
						  {
							  pstmt.setString(count++,practitioner_id);
							  pstmt.setString(count++,practitioner_id);
							  pstmt.setString(count++,facility_id);   //21820
						  }
						}							
						rs			=	pstmt.executeQuery();
						out.println( "clearNoteTypeValues('document','note_group');");							
	
						while(rs.next())
						{							
							String selected = "false";							
							if(rs.getString("note_group").equals(note_group_req))
							{
								selected="true";
							}
							
							out.println( "addNoteGroupList(\"" + rs.getString("note_group") + "\",\"" + rs.getString("note_group_desc") + "\",\"" + selected + "\") ; " ) ;							
						}
							
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}catch(Exception e){
						e.printStackTrace();
						//out.println("Exception@2 Notegroup: "+e);//COMMON-ICN-0181
					}	
		
				}
			}	 
		}
		//IN037676, starts
		//con = ConnectionManager.getConnection(request);//PER1203

		signAddendumPstmt = con.prepareStatement(signAddendumSql);
		signAddendumPstmt.setString(1,l_note_type);
		signAddendumRs = signAddendumPstmt.executeQuery();

		if(signAddendumRs.next())
		{
			signOthAddendumYN = signAddendumRs.getString("SIGN_ADDENM_OTH_YN");	
		}

		System.out.println("RecClinicalNotesValidate.jsp,297,signOthAddendumYN=>"+signOthAddendumYN);

		if(signOthAddendumYN.equals("N"))
		{
			if(l_task.equals("ADDENDUM_EXISTS_CHECK"))
			{
				//String addendumTextSql = "SELECT PRACTITIONER_ID FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM = ? AND ADDENDUM_STATUS = 'R' AND SEC_HDG_CODE = ? AND SUBSEC_HDG_CODE = ? ORDER BY SRL_NO";
				String addendumTextSql = "SELECT PRACTITIONER_ID FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM = ? AND ADDENDUM_STATUS = 'R' ORDER BY SRL_NO";//IN038384
				
				addendumTextPstmt = con.prepareStatement(addendumTextSql);
				addendumTextPstmt.setString(1,l_access_num);
				//addendumTextPstmt.setString(2,"*AmmendNotes*");//IN038384
				//addendumTextPstmt.setString(3,"*AmmendNotes*");//IN038384
				addendumTextRs = addendumTextPstmt.executeQuery();			

				if(addendumTextRs.next())
				{
					practName = addendumTextRs.getString("PRACTITIONER_ID");
				}

				if(!practName.equals(""))
				{
					if(!practName.equals(practitioner_id))
					{
						out.println("continueYN = 'N'");
					}
					else
					{
						out.println("continueYN = 'Y'");
					}
				}
				else
				{
					out.println("continueYN = 'Y'");
				}
				
			}
		}
		else
		{
			out.println("continueYN = 'Y'");
		}
		//IN037676, ends
	}
	catch(Exception e)
	{
		//out.println("EXCEPTION@ RecClinicalNotesValidate.jsp : "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		//IN037676, starts
		if(addendumTextRs != null)
			addendumTextRs.close();

		if(addendumTextPstmt != null)
			addendumTextPstmt.close();
		//IN037676, ends

		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
	 
