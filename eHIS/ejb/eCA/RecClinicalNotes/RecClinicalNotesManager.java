/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
15/12/2011     	IN029312            Menaka V 		Incident No: IN029312 - <Report is printed either through
													order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. > 
20/07/2012		IN033881			Dinesh T		Addendum data is not appearing in the multifacility scenario
19/09/2012		IN033677			Dinesh T		CRF-Recording and signing the addendum with new free text editor 
28/09/2012		IN034910			Dinesh T		Unable to mark the forwarded note as error in other facility
09/10/2012		IN034871			Ramesh G		ML-BRU-SCF-0392
18/01/2013		IN037372			Ramesh G		O22racle 11g Weblogic compilation.
06/02/2013		IN037675			Dinesh T		IN037675
18/02/2013		IN038010			Ramesh G		Include facility id in accession number generation.
27/02/2013		IN038176			DineshT			Privilege level setup with sign is not working	
19/03/2013		IN038614			Ramesh G 		Search Tab->System is displaying the Practitioner 2 name for the section 1, 
													which was actually recorded by Practitioner 1 
20/03/2013		IN038711			Rmesh G			Select Create new addendum in a note type Create sections of type Template based and associate it to the
													note type Record Clinical notes->Select the above note type->Record and sign->Search->Modify->Select a section->Enter notes->Record-> Search->Open the note-> Addendum details are not displayed.
22/03/2013		IN038848 			Ramesh G		Record Clinical notes->Record a note->Sign->Search->Click the note type->Section name is not displayed 										
02/05/2013		IN039227			Ramesh G		Record Clinical Notes->Type the text->Press the 'Enter' key and enter the text->Record & Sign the Note->Search Tab->System is not aligning the text as we entered, it is not wrapping the  text. 										
10/05/2013		IN039642			Ramesh G		Record Clinical Notes->Type the text->Press the 'Enter' key and enter the text->Record & Sign the Note->Search Tab->System is not aligning the text as we entered, it is not wrapping the  text.
12/05/2013		IN041643			Ramesh G		Blank PDF file generated for the Notification report
16/09/2013		IN041827			Nijitha S		ML-BRU-SCF-0949 
17/10/2013		IN041023			Ramesh G		Even though no data is recorded to the section2 which is displayed in Clinical Note details.
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2014	IN048276		Ramesh G		21/04/2014		Sunil Kumar KV		User enters data and signs off a clinical note. Note displays in the search tab as "Authorized", 
																				However on selecting the note, all the data which is entered in the note is missing. Note just displays as empty.
05/05/2015	IN053298		Ramesh G		05/05/2015		Akbar S				When we attach an image to the clinical note part of the image is not displayed.
12/05/2015	IN053733		Ramesh G											Bru-HIMS-CRF-024.3
22/03/2016	IN056951		Vijayakumar K										GHL-SCF-959 [IN:056951]
02/05/2016	IN059489		Raja S												Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
08/11/2016	IN060975		Raja S												MO-CRF-20114
27/06/2017	IN064566		Raja S			27/06/2017		Ramesh G			PMG2017-GHL-CRF-0005
22/01/2018	IN063931		Prakash C	   	23/01/2018		Ramesh				KDAH-CRF-0431(Copy previous section)
22/05/2018	IN067607		Raja S			22/05/2018		Ramesh G			ML-MMOH-CRF-1130.2
05/06/2018	IN67872			Dinesh T		05/06/2018		Ramesh G			GHL-CRF-0497.1	
27/07/2018	IN068105		Raja S			27/07/2018		Ramesh G			MMS-DM-CRF-0143
04/01/2019	IN069251		Prakash			04/01/2019		Ramesh GC			ML-MMOH-CRF-1130.3{Interface Related CRF}
14/05/2019	IN067862		Ramesh G											ML-BRU-CRF-0530  
21/10/2019	IN071569		Ramesh G									ML-MMOH-SCF-1389
06/04/2020	IN071865		Sivabagyam M	06/04/2020		Ramesh G		ML-MMOH-CRF-1484
18/03/2020	IN071264		Nijitha S	    18/03/2020		Ramesh G	    	GHL-CRF-0604
27/05/2020	IN072879		SIVABAGYAM M	27/05/2020		RAMESH G			MMS-DM-SCF-0688
22/06/2020	IN073100		SIVABAGYAM M	22/06/2020		RAMESH G			ML-MMOH-SCF-1541
24/08/2020	IN073435		Ramesh Goli		24/08/2020		Ramesh G			CA-Common-Record Clinical Note
18/11/2020	7605			SIVABAGYAM M	18/11/2020		RAMESH G			PMG2020-COMN-CRF-0085	
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G			MO-CRF-20147.7
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA.RecClinicalNotes;
 
import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.util.zip.GZIPOutputStream;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCA.RecClinicalNotesSectionBean;//IN071264
import webbeans.eCA.XMLtoHTML;//IN071264
import webbeans.eCommon.*;
import java.io.*;
import javax.xml.transform.TransformerException;
import eCA.CAClinicalNotesAutoSaveBean;//IN071264
import javax.xml.transform.TransformerConfigurationException;

import oracle.sql.CLOB; //IN069251
/**
*
* @ejb.bean
*	name="RecClinicalNotes"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecClinicalNotes"
*	local-jndi-name="RecClinicalNotes"
*	impl-class-name="eCA.RecClinicalNotes.RecClinicalNotesManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eCA.RecClinicalNotes.RecClinicalNotesLocal"
*	remote-class="eCA.RecClinicalNotes.RecClinicalNotesRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.RecClinicalNotes.RecClinicalNotesLocalHome"
*	remote-class="eCA.RecClinicalNotes.RecClinicalNotesHome"
*	generate= "local,remote"
*
*
*/

public class RecClinicalNotesManager implements SessionBean
{
	StringBuffer 	sb		=	new StringBuffer("") ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}

	public void setSessionContext(SessionContext sessionContext)
	{
		sessionContext = sessionContext;
	}
	//IN071264 Starts
	public java.util.HashMap recordRecClinicalNotesAutosave( java.util.Properties jdbc_props, 	java.util.HashMap htRecClinicalNotes, webbeans.eCA.RecClinicalNotesSectionBean	sectionBean, webbeans.eCA.XMLtoHTML converter,String strInsertFlag)
	{
		System.out.println("~~~~~~~~EJB recordRecClinicalNotesAutosave~~~~~~~~");
		Connection		  con			=	null;
		java.util.HashMap recresults	=	new java.util.HashMap() ;
		boolean bRtnResult				=	false;

		String  locale					=   "";
	//	CAClinicalNotesAutoSaveBean autoSaveBean = new CAClinicalNotesAutoSaveBean(); // CheckStyle

		try
		{
			con		=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);
		
			recresults = (HashMap) insertSectionTemp(con,jdbc_props,htRecClinicalNotes, sectionBean,converter,strInsertFlag);

			locale = (String) htRecClinicalNotes.get("LOCALE");

			bRtnResult		=	( ((Boolean) recresults.get( "status" )).booleanValue() );

			if(bRtnResult)
				con.commit();
			else
				con.rollback();
		}
		catch (Exception eMainRec)
		{
			eMainRec.printStackTrace();
			sb.append("<br>Exception@Mainrecord-001 : "+eMainRec);
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
		}

		return recresults;
	}

	private HashMap insertSectionTemp(Connection con, Properties jdbc_props,
			HashMap htRecClinicalNotes,
			RecClinicalNotesSectionBean sectionBean, XMLtoHTML converter,
			String strInsertFlag) {


		PreparedStatement pstInslNotSec = null;
		PreparedStatement pstInslNotSecDtls = null;
		ResultSet secdetailsrs = null;
		String note_sec_seq_num = null;
		String subsec_hdg_code = null;
		String sec_hdg_code = null;

		String notes_section_content = "";
		String image_content = "";
		String image_content_editor_data = "";
		ResultSet rs = null;
		boolean result = false;
		String chief_complaint_sec_yn = null;
		java.util.HashMap results = new java.util.HashMap();
		
		String facility_id = (String) htRecClinicalNotes.get("facility_id");
		String login_user_id = (String) htRecClinicalNotes.get("login_user_id");
		String login_at_ws_no = (String) htRecClinicalNotes
				.get("login_at_ws_no");
		String accession_num = (String) htRecClinicalNotes.get("accession_num");
		
		String note_type = (String) htRecClinicalNotes.get("note_type");
		String patient_id = (String) htRecClinicalNotes.get("patient_id");
		String encounter_id = (String) htRecClinicalNotes.get("encounter_id");
		String operation_mode = (String) htRecClinicalNotes.get("operation_mode");
		String resp_id = (String) htRecClinicalNotes.get("resp_id");
		String clinician_id = (String) htRecClinicalNotes.get("clinician_id");
		String image_link_yn = "N";
		String addendum_text = "";
		String addendum_amend_notes = "";
		int insertcnt;

		String query_section_details = " select sec_hdg_code, nvl(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code , note_sec_seq_num, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time  from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num ";
		String insert_addendum_text_tmp_qry = "insert into ca_encntr_note_addendum_tmp(FACILITY_ID,PATIENT_ID,ENCOUNTER_ID,ACCESSION_NUM,SRL_NO,ADDENDUM_TEXT,PRACTITIONER_ID,RESP_ID,ADDENDUM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDENDUM_STATUS,MODIFIED_PRACT_ID,SEC_HDG_CODE,SUBSEC_HDG_CODE,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE,NOTE_TYPE)  values(?,?,?,?,(select TO_NUMBER (nvl(max (srl_no),'0'))+1 from ca_encntr_note_addendum_tmp where PATIENT_ID=? and ENCOUNTER_ID=? AND ADDED_BY_ID =? AND NOTE_TYPE=? and SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?),?,?,?,sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";
		String insert_ca_encntr_note_section_obj_tmp = "insert into ca_encntr_note_section_obj_tmp ( OPERATING_FACILITY_ID, ACCESSION_NUM, NOTE_TYPE,PATIENT_ID, ENCOUNTER_ID,NOTE_SEC_SEQ_NUM, ADDED_BY_ID, ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, IMG_CONTENT, sec_hdg_code, subsec_hdg_code,note_status) values(?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?)";
		String update_ca_encntr_note_section_obj_tmp = "update ca_encntr_note_section_obj_tmp set img_content = ?, modified_by_id = ?, modified_date = SYSDATE ,  note_status = ? where note_type = ? and patient_id=? and encounter_id=? and sec_hdg_code = ? and subsec_hdg_code = ? ";
		try {
			ArrayList<String> notesSeqlist = new ArrayList<String>();
			if("AutoSave".equals(operation_mode) || "SaveDraft".equals(operation_mode))
			{
			if (!"".equals(accession_num)) {
				pstInslNotSec = con
						.prepareStatement("SELECT note_sec_seq_num,ACCESSION_NUM FROM CA_ENCNTR_NOTE_SECTION_TMP WHERE ACCESSION_NUM =? AND NOTE_STATUS IS NULL");
				pstInslNotSec.setString(1, accession_num);
			} else {
				pstInslNotSec = con
						.prepareStatement("SELECT NOTE_SEC_SEQ_NUM,ACCESSION_NUM FRom CA_ENCNTR_NOTE_SECTION_TMP WHERE  NOTE_TYPE = ? AND ADDED_BY_ID = ? AND PATIENT_ID = ? and ENCOUNTER_ID =? AND NOTE_STATUS IS NULL UNION SELECT NOTE_SEC_SEQ_NUM,ACCESSION_NUM FRom CA_ENCNTR_NOTE_SECTION_OBJ_TMP WHERE  NOTE_TYPE = ? AND ADDED_BY_ID = ? AND PATIENT_ID = ? and ENCOUNTER_ID =? AND NOTE_STATUS IS NULL");																										
				pstInslNotSec.setString(1, note_type);
				pstInslNotSec.setString(2, login_user_id);
				pstInslNotSec.setString(3, patient_id);
				pstInslNotSec.setString(4, encounter_id);
				pstInslNotSec.setString(5, note_type);
				pstInslNotSec.setString(6, login_user_id);
				pstInslNotSec.setString(7, patient_id);
				pstInslNotSec.setString(8, encounter_id);
			}
			
			rs = pstInslNotSec.executeQuery();
			}
			else if("AutoSaveUpdate".equals(operation_mode) || "SaveDraftUpdate".equals(operation_mode)){
			
				if (!"".equals(accession_num)) {
					pstInslNotSec = con
							.prepareStatement("SELECT note_sec_seq_num,ACCESSION_NUM FROM CA_ENCNTR_NOTE_SECTION_TMP WHERE ACCESSION_NUM =? AND NOTE_STATUS=?");
					pstInslNotSec.setString(1, accession_num);
					pstInslNotSec.setString(2, "UPDATE");
				} else {
					pstInslNotSec = con
							.prepareStatement("SELECT NOTE_SEC_SEQ_NUM,ACCESSION_NUM FRom CA_ENCNTR_NOTE_SECTION_TMP WHERE  NOTE_TYPE = ? AND ADDED_BY_ID = ? AND PATIENT_ID = ? and ENCOUNTER_ID =? AND NOTE_STATUS=? UNION SELECT NOTE_SEC_SEQ_NUM,ACCESSION_NUM FRom CA_ENCNTR_NOTE_SECTION_OBJ_TMP WHERE  NOTE_TYPE = ? AND ADDED_BY_ID = ? AND PATIENT_ID = ? and ENCOUNTER_ID =? AND NOTE_STATUS=? UNION SELECT SRL_NO as NOTE_SEC_SEQ_NUM,ACCESSION_NUM FRom CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE  NOTE_TYPE = ? AND ADDED_BY_ID = ? AND PATIENT_ID = ? and ENCOUNTER_ID =? ");
					pstInslNotSec.setString(1, note_type);
					pstInslNotSec.setString(2, login_user_id);
					pstInslNotSec.setString(3, patient_id);
					pstInslNotSec.setString(4, encounter_id);
					pstInslNotSec.setString(5, "UPDATE"); 
					pstInslNotSec.setString(6, note_type);
					pstInslNotSec.setString(7, login_user_id);
					pstInslNotSec.setString(8, patient_id);
					pstInslNotSec.setString(9, encounter_id);
					pstInslNotSec.setString(10, "UPDATE");
					pstInslNotSec.setString(11, note_type);
					pstInslNotSec.setString(12, login_user_id);
					pstInslNotSec.setString(13, patient_id);
					pstInslNotSec.setString(14, encounter_id);
				}
				rs = pstInslNotSec.executeQuery();
			}
			while (rs.next()) {

				notesSeqlist.add(rs.getString(1));
				accession_num = rs.getString(2);
			}
			
			if (rs != null)
				rs.close();
			if (pstInslNotSec != null)
				pstInslNotSec.close();
			
			pstInslNotSecDtls = con.prepareStatement(query_section_details);

			pstInslNotSecDtls.setString(1, note_type);

			secdetailsrs = pstInslNotSecDtls.executeQuery();
			int index=0;
			while (secdetailsrs.next()) {

				try {
					sec_hdg_code = checkForNull(
							(String) secdetailsrs.getString("sec_hdg_code"), "");
					subsec_hdg_code = checkForNull(
							(String) secdetailsrs
									.getString("child_sec_hdg_code"),
							"");
					note_sec_seq_num = checkForNull(
							(String) secdetailsrs.getString("note_sec_seq_num"),
							"");
					
					if(operation_mode.equals("AutoSaveUpdate") || operation_mode.equals("SaveDraftUpdate"))
					{	
						if(index==0){
							addendum_amend_notes = (String) sectionBean.getAddendumText( "*AmmendNotes*", "*AmmendNotes*");
						}
						if("<ADDRESS>&nbsp;</ADDRESS>".equals(addendum_amend_notes)){
							addendum_amend_notes = "";
						}
						
						addendum_text = (String) sectionBean.getAddendumText( sec_hdg_code, subsec_hdg_code);

						index++;
					}
					image_link_yn = checkForNull(
							(String) sectionBean.getImageLinked(sec_hdg_code,
									subsec_hdg_code), "");
					chief_complaint_sec_yn = checkForNull(
							(String) sectionBean.getChiefComplaintSection(
									sec_hdg_code, subsec_hdg_code), "");
					if ("Y".equals(image_link_yn)) {
						image_content = (String) sectionBean
								.getSectionImageContent(sec_hdg_code,
										subsec_hdg_code);
					
						image_content_editor_data = (String) sectionBean
								.getSectionContent(sec_hdg_code,
										subsec_hdg_code);
						
					
						if("Y".equals(chief_complaint_sec_yn)){
							//complaint_ids = sectionBean.getSectionChiefComplaint(sec_hdg_code, subsec_hdg_code);
						}
					} else {
						notes_section_content = (String) sectionBean
								.getSectionContent(sec_hdg_code,
										subsec_hdg_code);
						if(null!=addendum_text && !"".equals(addendum_text)){
							notes_section_content = "";
						}
						if("Y".equals(chief_complaint_sec_yn)){
							//complaint_ids = sectionBean.getSectionChiefComplaint(sec_hdg_code, subsec_hdg_code);
						}
					}

					
				}
				
				 catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("accession_num --->" + accession_num);
				if (notesSeqlist.size() == 0 && "".equals(accession_num)) {
					String includeFacilityAccessioNum = "N";
					try {

						String query_logic_accession_num = "select 'Y' from OR_PAT_APPLICABLE_FUNC where function_id = 'MULTI_FACILITY_ORDER_ID'";
						pstInslNotSec = con
								.prepareStatement(query_logic_accession_num);
						rs = pstInslNotSec.executeQuery();

						if (rs.next())
							includeFacilityAccessioNum = rs.getString(1);
					} catch (Exception e) {
						e.printStackTrace();

						sb.append("<br>Exception@EJB : Generating accession Number "
								+ e);
					} finally {
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}

					try {
						// String query_accession_num =
						// "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
						String query_accession_num = "";
						if ("N".equals(includeFacilityAccessioNum))
							query_accession_num = "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
						else if ("Y".equals(includeFacilityAccessioNum))
							query_accession_num = "SELECT 'CN'||'"
									+ facility_id
									+ "'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,14,'0') accession_num FROM DUAL ";
						// IN038010 End.
						pstInslNotSec = con
								.prepareStatement(query_accession_num);
						rs = pstInslNotSec.executeQuery();

						if (rs.next())
							accession_num = rs.getString("accession_num");
						htRecClinicalNotes.put("accession_num", accession_num);
					} catch (Exception e) {
						e.printStackTrace();
						sb.append("<br>Exception@EJB : Generating accession Number "
								+ e);
					} finally {
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}

				}
				insertcnt = 0;
				boolean subSecExists = false;
				subSecExists = checkSubSectionExiststmp(con,subsec_hdg_code,note_sec_seq_num,note_type,login_user_id,patient_id,encounter_id);
				if (null != notes_section_content
						&& !"".equals(notes_section_content)) {

					try {

						if (null != notesSeqlist
								&& notesSeqlist.contains(note_sec_seq_num) && subSecExists) {
						
							insertcnt = updateSecContTemp(con, pstInslNotSec,
									login_user_id, facility_id, login_at_ws_no,
									note_type, patient_id, encounter_id,
									sec_hdg_code, subsec_hdg_code,
									notes_section_content,operation_mode);
							
	
						} else {
							
							insertcnt = insertSecContTemp(con, pstInslNotSec,
									login_user_id, facility_id, login_at_ws_no,
									note_type, patient_id, encounter_id,
									sec_hdg_code, subsec_hdg_code,
									notes_section_content, accession_num,
									note_sec_seq_num, chief_complaint_sec_yn,operation_mode);
						}
						
						notes_section_content = "";
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}
					if (insertcnt > 0) {
						result = true;
					}
				} else if (null != image_content && !"".equals(image_content)) {
					String note_status_obj="";//IN071264 Starts
					if("SaveDraftUpdate".equals(operation_mode) || "AutoSaveUpdate".equals(operation_mode)){
						note_status_obj ="UPDATE";
					}//IN071264 Ends
					try {
						boolean subSecExistsObj = checkSubSectionExistsObj(con,subsec_hdg_code,note_sec_seq_num,note_type,login_user_id,patient_id,encounter_id);
						if (null != notesSeqlist
								&& notesSeqlist.contains(note_sec_seq_num) && subSecExistsObj) {

							
							
								pstInslNotSec = con
										.prepareStatement(update_ca_encntr_note_section_obj_tmp);
								Clob clob = stringToClob(image_content, con);
								pstInslNotSec.setClob(1, clob);
								pstInslNotSec.setString(2, login_user_id);
								pstInslNotSec.setString(3, note_status_obj);
								pstInslNotSec.setString(4, note_type);
								pstInslNotSec.setString(5, patient_id);
								pstInslNotSec.setString(6, encounter_id);
								pstInslNotSec.setString(7, sec_hdg_code);
								pstInslNotSec.setString(8, subsec_hdg_code);
								insertcnt = pstInslNotSec.executeUpdate();
							
							
							
							if (null != image_content_editor_data
									&& !"".equals(image_content_editor_data)) {

								
								if(subSecExists){
									insertcnt = updateSecContTemp(con,
											pstInslNotSec, login_user_id,
											facility_id, login_at_ws_no, note_type,
											patient_id, encounter_id, sec_hdg_code,
											subsec_hdg_code,
											image_content_editor_data,operation_mode);
								}else{
									insertcnt = insertSecContTemp(con, pstInslNotSec,
											login_user_id, facility_id, login_at_ws_no,
											note_type, patient_id, encounter_id,
											sec_hdg_code, subsec_hdg_code,
											image_content_editor_data, accession_num,
											note_sec_seq_num, chief_complaint_sec_yn,operation_mode);
								}
								
							}

						} else {
							pstInslNotSec = con
									.prepareStatement(insert_ca_encntr_note_section_obj_tmp);
							pstInslNotSec.setString(1, facility_id);
							pstInslNotSec.setString(2, accession_num);
							pstInslNotSec.setString(3, note_type);
							pstInslNotSec.setString(4, patient_id);
							pstInslNotSec.setString(5, encounter_id);
							pstInslNotSec.setString(6, note_sec_seq_num);
							pstInslNotSec.setString(7, login_user_id);
							pstInslNotSec.setString(8, login_user_id);
							Clob clob = stringToClob(image_content, con);
							pstInslNotSec.setClob(9, clob);
							pstInslNotSec.setString(10, sec_hdg_code);
							pstInslNotSec.setString(11, subsec_hdg_code);
							pstInslNotSec.setString(12, note_status_obj);
							insertcnt = pstInslNotSec.executeUpdate();
							if (null != image_content_editor_data
									&& !"".equals(image_content_editor_data)) {
								insertcnt = insertSecContTemp(con,
										pstInslNotSec, login_user_id,
										facility_id, login_at_ws_no, note_type,
										patient_id, encounter_id, sec_hdg_code,
										subsec_hdg_code,
										image_content_editor_data,
										accession_num, note_sec_seq_num,
										chief_complaint_sec_yn,operation_mode);
							}
						}
						image_content = "";
						image_content_editor_data="";
						
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}
					if (insertcnt > 0) {
						result = true;
					}
				}
				if(null!= addendum_text && ""!=addendum_text && notesSeqlist.size()==0){
					
					try{
					
					insertcnt = insertAddendumtxtTmp(con, pstInslNotSec, subsec_hdg_code, sec_hdg_code, facility_id,
										login_user_id, login_at_ws_no, accession_num, note_type, patient_id,
										encounter_id, resp_id, clinician_id, addendum_text,insert_addendum_text_tmp_qry);	
								//insertcnt = pstInslNotSec.executeUpdate();
								if (insertcnt > 0) {
									result = true;
								}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally {
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}
				}else if(null!= addendum_text && ""!=addendum_text&& !"".equals(accession_num)){
					int cnt =0;
				try{
					String updateaddendumtextqry ="UPDATE CA_ENCNTR_NOTE_ADDENDUM_TMP SET ADDENDUM_TEXT=?,ADDENDUM_CLOB=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ADDENDUM_STATUS=?,MODIFIED_PRACT_ID=?,practitioner_id=?,ADDENDUM_STORAGE_TYPE = ? WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? AND ADDED_BY_ID=? AND NOTE_TYPE=?";
					String selectaddendumtxtqry = "SELECT COUNT(*) as cnt FROM CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE  PATIENT_ID=? AND ENCOUNTER_ID=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? AND ADDED_BY_ID=? AND NOTE_TYPE=? ";
					pstInslNotSec = con.prepareStatement(selectaddendumtxtqry);
					pstInslNotSec.setString(1,patient_id);
					pstInslNotSec.setString(2,encounter_id);
					pstInslNotSec.setString(3,sec_hdg_code);
					pstInslNotSec.setString(4,subsec_hdg_code);
					pstInslNotSec.setString(5,login_user_id);
					pstInslNotSec.setString(6,note_type);
					rs =	pstInslNotSec.executeQuery();
					while(rs.next()){
						cnt=	Integer.parseInt(rs.getString("cnt"));
					}
					
					if(cnt>0){
					pstInslNotSec = con.prepareStatement(updateaddendumtextqry);
					pstInslNotSec.setString(1," ");									
					Clob updateAddentxtclob = stringToClob(addendum_text, con);
					pstInslNotSec.setClob(2, updateAddentxtclob);
					pstInslNotSec.setString(3,login_user_id);
					pstInslNotSec.setString(4,login_at_ws_no);
					pstInslNotSec.setString(5,facility_id);
					pstInslNotSec.setString(6,"A");
					pstInslNotSec.setString(7,clinician_id);
					pstInslNotSec.setString(8,clinician_id);
					pstInslNotSec.setString(9,"CLOB");
					pstInslNotSec.setString(10,patient_id);
					pstInslNotSec.setString(11,encounter_id);
					pstInslNotSec.setString(12,sec_hdg_code);
					pstInslNotSec.setString(13,subsec_hdg_code);
					pstInslNotSec.setString(14,login_user_id);
					pstInslNotSec.setString(15,note_type);
					insertcnt =	pstInslNotSec.executeUpdate();
					}else{
						
						insertcnt = insertAddendumtxtTmp(con, pstInslNotSec, subsec_hdg_code, sec_hdg_code, facility_id,
								login_user_id, login_at_ws_no, accession_num, note_type, patient_id, encounter_id,
								resp_id, clinician_id, addendum_text,insert_addendum_text_tmp_qry);	
					
			
					}
					if (insertcnt > 0) {
						result = true;
					}
				}catch(Exception e){
						e.printStackTrace();
					}
					finally {
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}
				
				}
				
				if(null!=addendum_amend_notes && !"".equals(addendum_amend_notes)){
					StringBuffer deleteqryaddendumtmp =  new StringBuffer();
					String insert_addendum_amendnotes_tmp_qry = "insert into ca_encntr_note_addendum_tmp(FACILITY_ID,PATIENT_ID,ENCOUNTER_ID,ACCESSION_NUM,SRL_NO,ADDENDUM_TEXT,PRACTITIONER_ID,RESP_ID,ADDENDUM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDENDUM_STATUS,MODIFIED_PRACT_ID,SEC_HDG_CODE,SUBSEC_HDG_CODE,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE,NOTE_TYPE)  values(?,?,?,?,(select TO_NUMBER (nvl(max (srl_no),'0'))+1 from ca_encntr_note_addendum_tmp where PATIENT_ID=? and ENCOUNTER_ID=? AND ADDED_BY_ID =? AND NOTE_TYPE=? and SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?),?,?,?,sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";
					deleteqryaddendumtmp.append("DELETE FROM CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND ADDED_BY_ID=? AND NOTE_TYPE = ? and SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?");
					try{
						pstInslNotSec	=	con.prepareStatement(deleteqryaddendumtmp.toString());
						pstInslNotSec.setString	(	1,	patient_id	);
						pstInslNotSec.setString	(	2,	encounter_id	);
						pstInslNotSec.setString	(	3,	login_user_id		);
						pstInslNotSec.setString	(	4,	note_type	);
						pstInslNotSec.setString(5,"*AmmendNotes*");
						pstInslNotSec.setString(6,"*AmmendNotes*");
					
						insertcnt = pstInslNotSec.executeUpdate();	
						
						pstInslNotSec = con
										.prepareStatement(insert_addendum_amendnotes_tmp_qry);
								Clob clobaddendumtext = stringToClob(addendum_amend_notes, con);
								pstInslNotSec.setString(1,facility_id);
								pstInslNotSec.setString(2,patient_id);
								pstInslNotSec.setString(3,encounter_id);
								pstInslNotSec.setString(4,accession_num);
								pstInslNotSec.setString(5,patient_id);
								pstInslNotSec.setString(6,encounter_id);
								pstInslNotSec.setString(7,login_user_id);
								pstInslNotSec.setString(8,encounter_id);
								
								pstInslNotSec.setString(9,"*AmmendNotes*");
								pstInslNotSec.setString(10,"*AmmendNotes*");
								pstInslNotSec.setString(11," ");	
								pstInslNotSec.setString(12,clinician_id);
								pstInslNotSec.setString(13,resp_id);
								pstInslNotSec.setString(14,login_user_id);
								pstInslNotSec.setString(15,login_at_ws_no);
								pstInslNotSec.setString(16,facility_id);
								pstInslNotSec.setString(17,login_user_id);
								pstInslNotSec.setString(18,login_at_ws_no);
								pstInslNotSec.setString(19,facility_id);
								pstInslNotSec.setString(20,"A");
								pstInslNotSec.setString(21,clinician_id);
								pstInslNotSec.setString(22,"*AmmendNotes*");//IN033677
								pstInslNotSec.setString(23,"*AmmendNotes*");//IN033677
								pstInslNotSec.setClob(24, clobaddendumtext);
								pstInslNotSec.setString(25,"CLOB");
								pstInslNotSec.setString(26,note_type);	
								insertcnt = pstInslNotSec.executeUpdate();
								if (insertcnt > 0) {
									addendum_amend_notes ="";
									result = true;
								}
					}catch(Exception e){
						e.printStackTrace();
					}
					finally {
						//15950 Starts
						if (secdetailsrs != null)
							secdetailsrs.close();
						if (pstInslNotSecDtls != null)
							pstInslNotSecDtls.close();
						//15950 Ends
						if (rs != null)
							rs.close();
						if (pstInslNotSec != null)
							pstInslNotSec.close();
					}	
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		results.put("accession_num", accession_num);

		return results;
	}
	private int insertAddendumtxtTmp(Connection con, PreparedStatement pstInslNotSec, String subsec_hdg_code,
			String sec_hdg_code, String facility_id, String login_user_id, String login_at_ws_no, String accession_num,
			String note_type, String patient_id, String encounter_id, String resp_id, String clinician_id,
			String addendum_text,String insert_addendum_text_tmp_qry) throws SQLException {
		int insertcnt = 0;
		pstInslNotSec = con
				.prepareStatement(insert_addendum_text_tmp_qry);
		Clob clobaddendumtext = stringToClob(addendum_text, con);
		pstInslNotSec.setString(1,facility_id);
		pstInslNotSec.setString(2,patient_id);
		pstInslNotSec.setString(3,encounter_id);
		pstInslNotSec.setString(4,accession_num);
		pstInslNotSec.setString(5,patient_id);
		pstInslNotSec.setString(6,encounter_id);
		pstInslNotSec.setString(7,login_user_id);
		pstInslNotSec.setString(8,encounter_id);
		
		pstInslNotSec.setString(9,sec_hdg_code);//IN033677
		pstInslNotSec.setString(10,subsec_hdg_code);//IN033677
		pstInslNotSec.setString(11," ");	
		pstInslNotSec.setString(12,clinician_id);
		pstInslNotSec.setString(13,resp_id);
		pstInslNotSec.setString(14,login_user_id);
		pstInslNotSec.setString(15,login_at_ws_no);
		pstInslNotSec.setString(16,facility_id);
		pstInslNotSec.setString(17,login_user_id);
		pstInslNotSec.setString(18,login_at_ws_no);
		pstInslNotSec.setString(19,facility_id);
		pstInslNotSec.setString(20,"A");
		pstInslNotSec.setString(21,clinician_id);
		pstInslNotSec.setString(22,sec_hdg_code);//IN033677
		pstInslNotSec.setString(23,subsec_hdg_code);//IN033677
		pstInslNotSec.setClob(24, clobaddendumtext);
		pstInslNotSec.setString(25,"CLOB");
		pstInslNotSec.setString(26,note_type);
		insertcnt = pstInslNotSec.executeUpdate();
		return insertcnt;
	}
	
	private boolean checkSubSectionExistsObj(Connection con,
			String subsec_hdg_code, String note_sec_seq_num, String note_type,
			String login_user_id, String patient_id, String encounter_id) {
	
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		PreparedStatement statement = null;
		ResultSet rs = null;
		int count=0;
		sql.append("SELECT count(*) FROM ca_encntr_note_section_obj_tmp WHERE note_type=? AND note_sec_seq_num=? AND subsec_hdg_code =? AND ADDED_BY_ID=? AND patient_id=? AND encounter_id =? ");
		int cnt=1;
		try {
			statement = con.prepareStatement(sql.toString());
			statement.setString(cnt++, note_type);
			statement.setString(cnt++, note_sec_seq_num);
			statement.setString(cnt++, subsec_hdg_code);
			statement.setString(cnt++, login_user_id);
			statement.setString(cnt++, patient_id);
			statement.setString(cnt++, encounter_id);
			rs = statement.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			
			if(statement != null)statement.close();//15950
			if(count > 0)
				result =true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	private boolean checkSubSectionExiststmp(Connection con, String subsec_hdg_code,
			String note_sec_seq_num, String note_type, String login_user_id,
			String patient_id, String encounter_id) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		PreparedStatement statement = null;
		ResultSet rs = null;
		int count = 0;
		sql.append("SELECT count(*) FROM ca_encntr_note_section_tmp WHERE note_type=? AND note_sec_seq_num=? AND subsec_hdg_code =? AND ADDED_BY_ID=? AND patient_id=? AND encounter_id =? ");
		int cnt=1;
		try {
			statement = con.prepareStatement(sql.toString());
			statement.setString(cnt++, note_type);
			statement.setString(cnt++, note_sec_seq_num);
			statement.setString(cnt++, subsec_hdg_code);
			statement.setString(cnt++, login_user_id);
			statement.setString(cnt++, patient_id);
			statement.setString(cnt++, encounter_id);
			rs = statement.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			
			if(count > 0)
				result =true;
			if(statement != null)statement.close();//15950
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	private HashSet<String> checkComplaintExists(Connection con,
			HashSet<String> complaint_ids, String accession_num) {
		PreparedStatement chfComplaintpsmt =null;
		ResultSet rs =null;
		StringBuffer selquery = new StringBuffer();
		HashSet<String> complaint_ids_exist = new HashSet<String>();
		selquery.append(" SELECT COMPLAINT_ID FROM CA_ENCNTR_NOTE_SEC_COMPLT_TMP WHERE ACCESSION_NUM = ?");
		
		try {
			
			chfComplaintpsmt = con.prepareStatement(selquery.toString());
			chfComplaintpsmt.setString	(1,	accession_num			);
			rs = chfComplaintpsmt.executeQuery();
			while(rs.next()){
				complaint_ids_exist.add(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
		
			try {
				rs.close();
				chfComplaintpsmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return complaint_ids_exist;
		
	}
	private int insertSecContTemp(Connection con,
			PreparedStatement pstInslNotSec, String login_user_id,
			String facility_id, String login_at_ws_no, String note_type,
			String patient_id, String encounter_id, String sec_hdg_code,
			String subsec_hdg_code, String notes_section_content,String accession_num,String note_sec_seq_num,String chief_complaint_sec_yn,String operation_mode) {
		int insertcnt =0;
		String note_status="";
		if("SaveDraftUpdate".equals(operation_mode) || "AutoSaveUpdate".equals(operation_mode)){
			note_status ="UPDATE";
		}
		try
		{
			
			String insert_ca_encntr_note_section = "insert into ca_encntr_note_section_tmp ( facility_id, accession_num, sec_hdg_code, subsec_hdg_code, notes_section_content, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,NOTE_SEC_SEQ_NUM,chief_complaint_sec_yn,patient_id,encounter_id ,note_type,note_status) values ( ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE,?, ? , ?, ?,?,?,?,? ) ";
			pstInslNotSec		=	con.prepareStatement(insert_ca_encntr_note_section);
			pstInslNotSec.setString	(1,	facility_id				);
			pstInslNotSec.setString	(2,	accession_num			);
			pstInslNotSec.setString	(3,	sec_hdg_code			);
			pstInslNotSec.setString	(4,	subsec_hdg_code			);
			Clob clob = stringToClob(notes_section_content, con);
			pstInslNotSec.setClob	(5,	clob	);
			pstInslNotSec.setString	(6,	login_user_id			);
			pstInslNotSec.setString	(7,	login_at_ws_no			); 
			pstInslNotSec.setString	(8,	facility_id				);
			pstInslNotSec.setString	(9,	login_user_id			);
			pstInslNotSec.setString	(10,	login_at_ws_no			);
			pstInslNotSec.setString	(11,facility_id				);
			pstInslNotSec.setString	(12,note_sec_seq_num		);
			pstInslNotSec.setString	(13,chief_complaint_sec_yn	);
			pstInslNotSec.setString	(14,patient_id	);
			pstInslNotSec.setString	(15,encounter_id	);
			pstInslNotSec.setString	(16,note_type	);
			pstInslNotSec.setString	(17,note_status	);
			insertcnt = pstInslNotSec.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertcnt;
	}
	private int updateSecContTemp(Connection con,
			PreparedStatement pstInslNotSec, String login_user_id,String facility_id,String login_at_ws_no,
			String note_type, String patient_id, String encounter_id,
			String sec_hdg_code, String subsec_hdg_code,
			String notes_section_content,String operation_mode) { 
		
			int insertcnt =0;
			String note_status="";
			if("SaveDraftUpdate".equals(operation_mode) || "AutoSaveUpdate".equals(operation_mode)){
				note_status ="UPDATE";
			}
			String update_ca_encntr_note_section = "update ca_encntr_note_section_tmp set notes_section_content = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? , note_status=? where   note_type = ? AND added_by_id = ? AND patient_id = ? and encounter_id =?  and sec_hdg_code = ? and subsec_hdg_code = ? ";
			try {
				pstInslNotSec		=	con.prepareStatement(update_ca_encntr_note_section);
			
				Clob clobupdate = stringToClob(notes_section_content, con);
				pstInslNotSec.setClob	(1,	clobupdate);
				pstInslNotSec.setString	(2,	login_user_id);
				pstInslNotSec.setString	(3,	login_at_ws_no);
				pstInslNotSec.setString	(4,	facility_id);
				pstInslNotSec.setString	(5,	note_status	);
				pstInslNotSec.setString	(6,	note_type);
				pstInslNotSec.setString	(7,	login_user_id); 
				pstInslNotSec.setString	(8,	patient_id	); 
				pstInslNotSec.setString	(9,	encounter_id	); 
				pstInslNotSec.setString	(10,	sec_hdg_code	); 
				pstInslNotSec.setString	(11,	subsec_hdg_code	);
				
				insertcnt = pstInslNotSec.executeUpdate();
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return insertcnt;
		
	}
	//IN071264 Ends
	private java.util.HashMap processTables( Connection con,java.util.Properties jdbc_props, 	java.util.HashMap htRecClinicalNotes, webbeans.eCA.RecClinicalNotesSectionBean	sectionBean, webbeans.eCA.XMLtoHTML converter,String strInsertFlag)
	{
		PreparedStatement	pstmt				=	null;
		PreparedStatement	pstUpdNotSec		=	null;
		PreparedStatement	pstUpdNotSecObj		=	null;
		PreparedStatement	pstUpdChiefComp		=	null;
		PreparedStatement	pstSelNotSec		=	null;
		PreparedStatement	pstSelNotSecObj		=	null;
		PreparedStatement	pstInslNotSec		=	null;
		PreparedStatement	pstInslNotSecObj	=	null;
		PreparedStatement	pstInslChiefComp	=	null;
		PreparedStatement	pstSelChiefComp		=	null;
		PreparedStatement	pstDelChiefComp		=	null;
		PreparedStatement	pstmtPrg			=	null;

		ResultSet			rs					=	null;
		ResultSet			rs1					=	null;
		ResultSet			rs2					=	null;
		ResultSet			rsSelChiefComp		=	null;


		java.util.HashMap results				=	new java.util.HashMap() ;

		String		encntr_date					=	"",		locale						=	"";
		String		facility_id					=	"",		accession_num				=	"";
		String		patient_id					=	"",		encounter_id				=	"";
		String		event_type_caption			=	"",		note_type					=	"";
		String		service_code				=	"",		event_class					=	"";
		String		security_level				=	"",		event_date_caption			=	"";
		String		event_date_time				=	"",		event_perf_by_caption		=	"";
		String		performed_by_id				=	"",		event_title_caption			=	"";
		String		event_title_desc			=	"",		notes_section_content		=	"";
		String		event_auth_by_caption		=	"",		authorized_by_id			=	"";
		String		authorized_date_time		=	"",		event_status_caption		=	"";
		String		event_status				=	"",		login_user_id				=	"";
		String		login_at_ws_no				=	"",		patient_class				=	"";
		String		sec_hdg_code				=	"",		subsec_hdg_code				=	"";
		String		query_clob_object			=	"",     contr_mod_accession_num		=	"";
		String		operation_mode				=	"",		note_sec_seq_num			=	"";
		String		image_link_yn				=	"",		section_image_content		=	"";
		String		clinician_name				=	"",		resp_name					=	"";
		String		appl_task_id				=	"",		selection_type				=	"";
		String record_mode = "";//IN033677
		String 		contr_oth_accession_num		= ""; //IN053733
		String 		notes_section_content_html		= ""; //IN063931
		String  	Copy_prev_section_flag			="N";//IN063931
		String		myHIXFlg ="N";//IN067607
		String		noteCopiedYN ="N";//IN068105
		String sexValue="",speciality_name="",location_code="";//IN072879
		
		/************************ADDED By Deepa on 5/25/2009 for IN010603 ****/
		String privilege_type = "";

		int			insert_result				=	0,		update_result				=	0;
		int			update_result_img			=	0,		colIndex					=	0;
		int			insert_result_img			=	0;
		int			insert_prgdtl				=	0;

		boolean	result							=	false;
		boolean commit_flag					=	true;
		boolean	note_content_exists				=	false;
		//boolean	note_max						=	false;//Checkstyle

		//oracle.sql.CLOB	clob_notes_section_content	=	null,clob_section_image_content	 =	null;  //[IN037372]
		java.sql.Clob	clob_notes_section_content	=	null,clob_section_image_content	 =	null;	//[IN037372]
		java.sql.Clob	clob_notes_section_content_html	=	null;//IN063931

		//java.io.Writer			section_content_writer		=	null;  commented for checkstyle
		java.io.BufferedWriter	bf_section_content_writer	=	null;

		MessageManager			mm							=	null;
		java.util.Hashtable		message						=	null;

		String		strOutput				=	"N" ;
		String outputYN ="N";
		HashMap multiHash = null;
		CAClinicalNotesAutoSaveBean autoSaveBean = new CAClinicalNotesAutoSaveBean();//IN071264

		try
		{
			sb.delete(0,sb.length());
			sb.append("");

			mm							=	new MessageManager();
			notes_section_content		=	null;

			operation_mode				=	(String) htRecClinicalNotes.get ( "operation_mode"			);
			facility_id					=	(String) htRecClinicalNotes.get ( "facility_id"				);
			login_user_id				=	(String) htRecClinicalNotes.get ( "login_user_id"			);
			login_at_ws_no				=	(String) htRecClinicalNotes.get ( "login_at_ws_no"			);
			accession_num				=	(String) htRecClinicalNotes.get ( "accession_num"			);
			patient_id					=	(String) htRecClinicalNotes.get ( "patient_id"				);
			patient_class				=	(String) htRecClinicalNotes.get ( "patient_class"			);
			encounter_id				=	(String) htRecClinicalNotes.get ( "encounter_id"			);
			event_type_caption			=	(String) htRecClinicalNotes.get ( "event_type_caption"		);
			note_type					=	(String) htRecClinicalNotes.get ( "note_type"				);
			service_code				=	(String) htRecClinicalNotes.get ( "service_code"			);
			event_class					=	(String) htRecClinicalNotes.get ( "event_class"				);
			security_level				=	(String) htRecClinicalNotes.get ( "security_level"			);
			event_date_caption			=	(String) htRecClinicalNotes.get ( "event_date_caption"		);
			event_date_time				=	(String) htRecClinicalNotes.get ( "event_date_time"			);
			event_perf_by_caption		=	(String) htRecClinicalNotes.get ( "event_perf_by_caption"	);
			performed_by_id				=	(String) htRecClinicalNotes.get ( "performed_by_id"			);
			event_title_caption			=	(String) htRecClinicalNotes.get ( "event_title_caption"		);
			event_title_desc			=	(String) htRecClinicalNotes.get ( "event_title_desc"		);
			event_auth_by_caption		=	(String) htRecClinicalNotes.get ( "event_auth_by_caption"	);
			authorized_by_id			=	(String) htRecClinicalNotes.get ( "authorized_by_id"		);

			
			authorized_date_time		=	(String) htRecClinicalNotes.get ( "authorized_date_time"	);
			event_status_caption		=	(String) htRecClinicalNotes.get ( "event_status_caption"	);
			event_status				=	(String) htRecClinicalNotes.get ( "event_status"			);
			encntr_date					=	(String) htRecClinicalNotes.get ( "encntr_date"				);
			clinician_name				=	(String) htRecClinicalNotes.get ( "clinician_name"			);
			resp_name					=	(String) htRecClinicalNotes.get ( "resp_name"				);
			contr_mod_accession_num		=	(String) htRecClinicalNotes.get ( "contr_mod_accession_num"	);
			contr_oth_accession_num		=	(String) htRecClinicalNotes.get ( "contr_oth_accession_num"	); //IN053733
			locale						=	(String) htRecClinicalNotes.get ( "LOCALE"	);
			appl_task_id				=	(String) htRecClinicalNotes.get ( "appl_task_id"	);
			selection_type				=	(String) htRecClinicalNotes.get ( "selection_type"	);
			multiHash					=	(HashMap) htRecClinicalNotes.get("multiHash");
			privilege_type					= (String) htRecClinicalNotes.get("privilege_type");
			record_mode					= (String) htRecClinicalNotes.get("record_mode");//IN033677
			myHIXFlg					= (String) htRecClinicalNotes.get("myHIXFlg");//IN067607
			noteCopiedYN					= (String) htRecClinicalNotes.get("noteCopiedYN");//IN068105
			sexValue							= (String) htRecClinicalNotes.get("Sex");//IN072879
			location_code				= (String) htRecClinicalNotes.get("location_code");//IN072879
			speciality_name				= (String) htRecClinicalNotes.get("speciality_name");//IN072879

			if(operation_mode.equals("Record") || operation_mode.equals("RecordOnSign") || event_status.equals(""))
			{
				authorized_by_id		=	"";
				authorized_date_time	=	"";
				event_status			=	"1";
			}

			if(accession_num.equals(""))
			{
				//IN038010  Start.
				String includeFacilityAccessioNum="N";
				try
				{
					String query_logic_accession_num = "select 'Y' from OR_PAT_APPLICABLE_FUNC where function_id = 'MULTI_FACILITY_ORDER_ID'";
					pstmt	=	con.prepareStatement(query_logic_accession_num);
					rs		=	pstmt.executeQuery();

					if(rs.next())
						includeFacilityAccessioNum	=	rs.getString(1);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@EJB : Generating accession Number "+e);
				}
				finally
				{
					if(rs!=null) rs.close();
					if(pstmt!=null)	pstmt.close();
				}
				
				try
				{
					//String query_accession_num =  "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
					String query_accession_num="";
					if("N".equals(includeFacilityAccessioNum))
						query_accession_num =  "select 'CN'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,16,'0') accession_num from dual ";
					else if("Y".equals(includeFacilityAccessioNum))
						query_accession_num =  "SELECT 'CN'||'"+facility_id+"'||to_char(sysdate,'YY')||'$'||lpad(ca_note_type_seq.nextval,14,'0') accession_num FROM DUAL ";
				//IN038010 End.	
					pstmt	=	con.prepareStatement(query_accession_num);
					rs		=	pstmt.executeQuery();

					if(rs.next())
						accession_num	=	rs.getString("accession_num");
					htRecClinicalNotes.put(	"accession_num",	accession_num	);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@EJB : Generating accession Number "+e);
				}
				finally
				{
					if(rs!=null) rs.close();
					if(pstmt!=null)	pstmt.close();
				}

				

				CallableStatement	csDocRef	=	null;
				csDocRef	=	con.prepareCall("{call CA_GET_NOTE_DOC_REF(?)}");

				try
				{
				/*	//while recording the trascriber note form task list
					if(!contr_mod_accession_num.equals("")&&function_id("TASK_LIST"))
					{

						String update_pat_task_list = "update CA_PAT_TASK_LIST set STATUS ='P' where PATIENT_ID = ? and   TASK_CODE  = '&NTS' and REQ_ACCESSION_NUM = ? ";

						pstmt		=	con.prepareStatement(update_pat_task_list);
						pstmt.setString	( 1,	patient_id	);
						pstmt.setString	( 2,	contr_mod_accession_num	);

						update_result = pstmt.executeUpdate();


					}*/

					
					//IN053733 Start.
					//String insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num,contr_oth_accession_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, to_date(?, 'dd/mm/yyyy HH24:MI'), ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),?,? ) ";
					//String insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num,contr_oth_accession_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, to_date(?, 'dd/mm/yyyy HH24:MI'), ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),?,? ) ";//commented for IN068105
					//IN053733 End.
					String insert_ca_encntr_note = "insert into ca_encntr_note ( facility_id, accession_num, patient_id, patient_class, encounter_id, event_type_caption, note_type, service_code, event_class, security_level, event_date_caption, event_date_time, event_perf_by_caption, performed_by_id, event_title_caption, event_title_desc, note_content, event_auth_by_caption, authorized_by_id, authorized_date_time, event_status_caption, event_status,last_amended_by_id, last_amended_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, encntr_date,contr_mod_accession_num,contr_oth_accession_num,NOTES_COPIED_YN ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'), ?, ?, ?, ?, empty_clob(), ?, ?, to_date(?, 'dd/mm/yyyy HH24:MI'), ?, ?, ?,SYSDATE,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, to_date(?,'dd/mm/yyyy HH24:MI'),?,?,? ) ";//Modified for IN068105
					colIndex	=	0;

					pstmt		=	con.prepareStatement(insert_ca_encntr_note);

					pstmt.setString	(  ++colIndex,	facility_id			);
					pstmt.setString	(  ++colIndex,	accession_num	);
					pstmt.setString	(  ++colIndex,	patient_id			);
					pstmt.setString	(  ++colIndex,	patient_class		);

					if(encounter_id.equals(""))
						pstmt.setNull	(  ++colIndex,	Types.NUMERIC	);
					else
						pstmt.setLong	(  ++colIndex,	Long.parseLong(encounter_id));

					pstmt.setString	(  ++colIndex,	event_type_caption		);
					pstmt.setString	(  ++colIndex,	note_type				);
					pstmt.setString	(  ++colIndex,	service_code			);
					if(event_class.equals("")||event_class==null)
					{
						event_class="PHY$";
					}
					pstmt.setString	(  ++colIndex,	event_class				);
					pstmt.setString	(  ++colIndex,	security_level			);
					pstmt.setString	(  ++colIndex,	event_date_caption		);
					pstmt.setString	(  ++colIndex,	event_date_time			);
					pstmt.setString	(  ++colIndex,	event_perf_by_caption	);
					pstmt.setString	(  ++colIndex,	performed_by_id			);
					pstmt.setString	(  ++colIndex,	event_title_caption		);
					pstmt.setString	(  ++colIndex,	event_title_desc		);
					pstmt.setString	(  ++colIndex,	event_auth_by_caption	);

					if(authorized_by_id.equals(""))
						pstmt.setNull	(++colIndex,	Types.VARCHAR		);
					else
						pstmt.setString	( ++colIndex,	authorized_by_id	);

					pstmt.setString	( ++colIndex,	authorized_date_time	);
					pstmt.setString	( ++colIndex,	event_status_caption	);
					pstmt.setString	( ++colIndex,	event_status			);

					if(authorized_by_id.equals(""))
						pstmt.setNull	(++colIndex,	Types.VARCHAR		);
					else
						pstmt.setString	( ++colIndex,	authorized_by_id	);

					pstmt.setString	( ++colIndex,	login_user_id			);
					pstmt.setString	( ++colIndex,	login_at_ws_no			);
					pstmt.setString	( ++colIndex,	facility_id				);
					pstmt.setString	( ++colIndex,	login_user_id			);
					pstmt.setString	( ++colIndex,	login_at_ws_no			);
					pstmt.setString	( ++colIndex,	facility_id				);
					pstmt.setString	( ++colIndex,	encntr_date				);
					pstmt.setString	( ++colIndex,	contr_mod_accession_num	);
					pstmt.setString	( ++colIndex,	contr_oth_accession_num	);//IN053733
					pstmt.setString	( ++colIndex,	noteCopiedYN	);//IN068105

					insert_result = pstmt.executeUpdate();

					if( insert_result <= 0 )
					{
						commit_flag = false;
					}
					else
					{
							
						csDocRef.setString (1,accession_num);
						csDocRef.execute();

						strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null,privilege_type);
						
						if( !strOutput.equals("Y"))
						{
							commit_flag = false;
						}

						if(csDocRef!=null) csDocRef.close();
						// added for crf SRR499
						if((commit_flag)&& appl_task_id.equals("PROGRESS_NOTES"))
						{
							String progression_ref="";

							if(!contr_mod_accession_num.equals("")){
								String prg_ref_arr[] = contr_mod_accession_num.split("!");
								if (prg_ref_arr!=null&&prg_ref_arr.length>1)
								{
									progression_ref  = prg_ref_arr[1];
								}

							}

							String insPrgnDtl = "INSERT INTO CA_PAT_PROGRESSION_DTL(PROGRESSION_REF, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

							pstmtPrg = con.prepareStatement(insPrgnDtl);
							pstmtPrg.setString(1,progression_ref );
							pstmtPrg.setString(2,accession_num );
							pstmtPrg.setString(3,login_user_id );
							pstmtPrg.setString(4,login_at_ws_no );
							pstmtPrg.setString(5,facility_id );
							pstmtPrg.setString(6,login_user_id );
							pstmtPrg.setString(7,login_at_ws_no );
							pstmtPrg.setString(8,facility_id );

							insert_prgdtl = pstmtPrg.executeUpdate();

							if( insert_prgdtl <= 0 )
							{
								commit_flag = false;
							}

						}

					}					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@Ejb - Inserting note header "+e);
				}
				finally
				{
					if(rs!=null) rs.close();
					if(pstmt!=null)	pstmt.close();
				}

			}
			else
			{
				// Added for IN060975 starts
				String note_sys_date_time = ""; 
				String query_note_content = "select to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') note_sys_date_time from dual ";
				
				try
				{
					pstmt			=	con.prepareStatement(query_note_content);
					rs				=	pstmt.executeQuery();

					if(rs.next())
						note_sys_date_time		=	rs.getString("note_sys_date_time");
				}
				catch (Exception eeee)
				{
					eeee.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@modify - 142: "+eeee);
				}
				// Added for IN060975 Ends

				try
				{
					String update_ca_encntr_note =  "";

					if(authorized_date_time.equals("SYSDATE"))
					{
						//update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = SYSDATE, event_status_caption = ?,  event_status = ?,   last_amended_by_id=? , last_amended_date_time=SYSDATE,modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ? where facility_id = ? and accession_num = ? ";//Commented for IN067607
						update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = SYSDATE, event_status_caption = ?,  event_status = ?,   last_amended_by_id=? , last_amended_date_time=SYSDATE,modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ?, MYHIX_SEND_YN = ? where facility_id = ? and accession_num = ? ";//Modified for IN067607

					}
					else if ( operation_mode.equals("UpdateRecord") )
					{
						//update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1)  , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ? where facility_id = ? and accession_num = ? ";
						update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1)  , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ? where accession_num = ? ";
					}
					else if ( operation_mode.equals("ModifySection") )
					{
						//update_ca_encntr_note = "update ca_encntr_note set event_status_caption = ?,  event_status = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1) , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ?  where facility_id = ? and accession_num = ? ";

						update_ca_encntr_note = "update ca_encntr_note set event_status_caption = ?,  event_status = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1) , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ?  where /*facility_id = ? and */ accession_num = ? ";
					}
					else if ( operation_mode.equals("ModifyAddendum") )
					{

						//update_ca_encntr_note = "update ca_encntr_note set event_status_caption = ?,  event_status = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1)  , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?  where facility_id = ? and accession_num = ? ";//IN033881
						update_ca_encntr_note = "update ca_encntr_note set event_status_caption = ?,  event_status = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1)  , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?  where accession_num = ? ";//IN033881
					}
					else
					{
						update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = ?, event_status_caption = ?,  event_status = ?, last_amended_by_id=(select FUNC_ROLE_ID from sm_appl_user where APPL_USER_ID=? and rownum=1)  , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, event_title_desc= ?, service_code = ? where facility_id = ? and accession_num = ? ";
					}

					pstmt	=	con.prepareStatement(update_ca_encntr_note);

					if(authorized_date_time.equals("SYSDATE"))
					{
						pstmt.setString	(1,	authorized_by_id		);
						pstmt.setString	(2,	event_status_caption	);
						pstmt.setString	(3,	event_status			);
						pstmt.setString	(4,	authorized_by_id		);
						pstmt.setString	(5, login_user_id			);
						pstmt.setString	(6, login_at_ws_no			);
						pstmt.setString	(7, facility_id				);
						pstmt.setString	(8,	event_title_desc		);
						pstmt.setString	(9,	service_code    		);
						pstmt.setString	(10,myHIXFlg				);//Added for IN067607
						pstmt.setString	(11,facility_id				);
						pstmt.setString	(12,accession_num			);
					}
					else if ( operation_mode.equals("UpdateRecord") )
					{
						pstmt.setString	(1,	authorized_by_id		);
						pstmt.setString	(2,	authorized_date_time	);
						//pstmt.setString	(3,	authorized_by_id	);
						pstmt.setString	(3,	login_user_id	);
						pstmt.setString	(4, login_user_id			);
						pstmt.setString	(5, login_at_ws_no			);
						pstmt.setString	(6, facility_id				);
						pstmt.setString	(7,	event_title_desc		);
						pstmt.setString	(8,	service_code			);
						//pstmt.setString	(9,	facility_id				);
						pstmt.setString	(9,accession_num			);
					}
					else if ( operation_mode.equals("ModifySection") )
					{
						pstmt.setString	(1,	event_status_caption	);
						pstmt.setString	(2,	event_status			);
						//pstmt.setString	(3,	authorized_by_id		);
						pstmt.setString	(3,	login_user_id		);
						pstmt.setString	(4, login_user_id			);
						pstmt.setString	(5, login_at_ws_no			);
						pstmt.setString	(6, facility_id				);
						pstmt.setString	(7,	event_title_desc		);
						pstmt.setString	(8,	service_code			);
						//pstmt.setString	(9,	facility_id				);
						pstmt.setString	(9,	accession_num			);

					}
					else if ( operation_mode.equals("ModifyAddendum") )
					{
						pstmt.setString	(1,	event_status_caption	);
						pstmt.setString	(2,	event_status			);
						//pstmt.setString	(3,	authorized_by_id		);
						pstmt.setString	(3,	login_user_id		);
						pstmt.setString	(4, login_user_id			);
						pstmt.setString	(5, login_at_ws_no			);
						pstmt.setString	(6, facility_id				);
						///pstmt.setString	(7,	facility_id				);//IN033881
						pstmt.setString	(7,	accession_num			);//IN033881
					}
					else
					{
						pstmt.setString	(1,	authorized_by_id		);
						pstmt.setString	(2,	authorized_date_time	);
						pstmt.setString	(3,	event_status_caption	);
						pstmt.setString	(4,	event_status			);
						//pstmt.setString	(5,	authorized_by_id		);
						pstmt.setString	(5,	login_user_id		);
						pstmt.setString	(6, login_user_id			);
						pstmt.setString	(7, login_at_ws_no			);
						pstmt.setString	(8, facility_id				);
						pstmt.setString	(9,	event_title_desc		);
						pstmt.setString	(10,service_code			);
						pstmt.setString	(11,facility_id				);
						pstmt.setString	(12,accession_num			);
					}

					update_result = pstmt.executeUpdate();

					if( update_result <= 0 )
						commit_flag	= false;
					// Added for IN060975 starts
					if ( operation_mode.equals("UpdateRecord")) {

						strOutput = insertAuditLog(con,facility_id,accession_num,note_sys_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null,privilege_type);

						if( !strOutput.equals("Y"))
							commit_flag = false;
					
						CallableStatement	cspreAmend	=	null;
						cspreAmend					=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?,?)}");
					
						if(strOutput.equals("Y") )
						{
							try
							{
								cspreAmend.setString (1,facility_id);
								cspreAmend.setString (2,accession_num);
								cspreAmend.setString (3,note_sys_date_time);
								cspreAmend.registerOutParameter (4,Types.VARCHAR);
								cspreAmend.setString (5,"PR");
								cspreAmend.execute();
								strOutput = cspreAmend.getString(4);
								if(cspreAmend!=null) cspreAmend.close();
							}
							catch (Exception ee2)
							{
								ee2.printStackTrace();
								commit_flag = false;
								sb.append("<br>Exception@ - 595: "+ee2);
							}
							finally
							{
								if(cspreAmend!=null) cspreAmend.close();
							}
							if(!strOutput.equals("Y") )
								commit_flag = false;
						}
					}	
					// Added for IN060975 Ends
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@Ejb: Updating the note Header "+authorized_date_time+" dtime "+e);
				}
				finally
				{
					if(rs!=null) rs.close();
					if(pstmt!=null)	pstmt.close();
				}
			}

			if( !strInsertFlag.equals("Y") && commit_flag )
			{

				try
				{
					String sys_date_time			=	"",	chief_complaint_sec_yn	=	"";
					String complaint				=	"", edited_yn				=	"";
					String image_edited_yn			=	"";

					HashSet setChiefComp			= null;
					Iterator itChiefComp			= null;
					Copy_prev_section_flag			= sectionBean.getCopyPrevSectionYN ();//IN063931
					String update_ca_encntr_note_section = "";//IN063931

					String query_section_details = " select sec_hdg_code, nvl(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code , note_sec_seq_num, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time  from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num ";
					//IN063931 start 
					if(Copy_prev_section_flag.equals("Y")){
						
						 update_ca_encntr_note_section = " update ca_encntr_note_section set notes_section_content = empty_clob(), modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, notes_sec_cont_html = empty_clob() where /*facility_id = ? and */ accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ?";
					
						query_clob_object = "select notes_section_content,dbms_lob.getlength(notes_section_content),notes_sec_cont_html,dbms_lob.getlength(notes_sec_cont_html) from ca_encntr_note_section where accession_num = ? and sec_hdg_code = ? and subsec_hdg_code=? for update ";
					}
					else{
						 update_ca_encntr_note_section = " update ca_encntr_note_section set notes_section_content = empty_clob(), modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where  accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ?";
						query_clob_object = "select notes_section_content,dbms_lob.getlength(notes_section_content) from ca_encntr_note_section where accession_num = ? and sec_hdg_code = ? and subsec_hdg_code=? for update ";
					}
					//IN063931 ends
					String update_ca_encntr_note_section_obj = "update ca_encntr_note_section_obj set img_content = empty_clob(), modified_by_id = ?, modified_date = SYSDATE where /*operating_facility_id = ? and*/ accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ? ";

					String query_image_clob_object = "select img_content from ca_encntr_note_section_obj where /*operating_facility_id = ? and */ accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ? for update ";
					//IN063931 start
					String insert_ca_encntr_note_section = "";
					if(Copy_prev_section_flag.equals("Y")){
						 insert_ca_encntr_note_section = "insert into ca_encntr_note_section ( facility_id, accession_num, sec_hdg_code, subsec_hdg_code, notes_section_content, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,NOTE_SEC_SEQ_NUM,chief_complaint_sec_yn, notes_sec_cont_html ) values ( ?, ?, ?, ?, empty_clob(), ?, SYSDATE, ?, ?, ?, SYSDATE,?, ? , ?, ?, empty_clob() ) ";
					}else{
						 insert_ca_encntr_note_section = "insert into ca_encntr_note_section ( facility_id, accession_num, sec_hdg_code, subsec_hdg_code, notes_section_content, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,NOTE_SEC_SEQ_NUM,chief_complaint_sec_yn ) values ( ?, ?, ?, ?, empty_clob(), ?, SYSDATE, ?, ?, ?, SYSDATE,?, ? , ?, ? ) ";
					}
					//IN063931 ends
					String insert_ca_encntr_note_section_obj = "insert into ca_encntr_note_section_obj ( OPERATING_FACILITY_ID, ACCESSION_NUM, ADDED_BY_ID, ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, IMG_CONTENT, sec_hdg_code, subsec_hdg_code) values(?,?,?,sysdate,?,sysdate,empty_clob(),?,?)";

					String updateChiefComplaints = " update CA_ENCNTR_NOTE_SEC_COMPLAINT set  SEC_HDG_CODE=? ,COMPLAINT_ID = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where FACILITY_ID = ? and ACCESSION_NUM=? and COMPLAINT_ID=?";

					String selectExistChiefComp = "SELECT COMPLAINT_ID FROM  CA_ENCNTR_NOTE_SEC_COMPLAINT  where FACILITY_ID = ? and ACCESSION_NUM=? and SEC_HDG_CODE=?";

					String insertChiefComplaints = "insert into CA_ENCNTR_NOTE_SEC_COMPLAINT(FACILITY_ID,ACCESSION_NUM,SEC_HDG_CODE,COMPLAINT_ID ,ADDED_BY_ID ,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID ,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

					pstmt				=	con.prepareStatement(query_section_details);
					pstUpdNotSec		=	con.prepareStatement(update_ca_encntr_note_section);
					pstSelNotSec		=	con.prepareStatement(query_clob_object);
					pstUpdNotSecObj		=	con.prepareStatement(update_ca_encntr_note_section_obj);
					pstSelNotSecObj		=	con.prepareStatement(query_image_clob_object);
					pstInslNotSec		=	con.prepareStatement(insert_ca_encntr_note_section);
					pstInslNotSecObj	=	con.prepareStatement(insert_ca_encntr_note_section_obj);
					pstUpdChiefComp		=	con.prepareStatement(updateChiefComplaints);
					pstInslChiefComp	=	con.prepareStatement(insertChiefComplaints);
					pstSelChiefComp		=	con.prepareStatement(selectExistChiefComp);

					pstmt.setString(1,note_type);

					rs2			=	pstmt.executeQuery();

					String strKey = "";

					strKey = patient_id + "~"+encounter_id;

					strKey = strKey.trim();				

					sectionBean.getPatientSection(strKey);

					while(rs2.next())
					{
						update_result_img	= 0;
						update_result		= 0;
						insert_result		= 0;
						insert_result_img	= 0;

						notes_section_content	=	"";
						section_image_content	=	"";
						image_link_yn			=	"N";
						chief_complaint_sec_yn	=	"N";
						edited_yn				=	"N";
						image_edited_yn			=	"N";


						try
						{
							sec_hdg_code			=	checkForNull((String) rs2.getString("sec_hdg_code"),"");
							subsec_hdg_code			=	checkForNull((String) rs2.getString("child_sec_hdg_code"),"");
							note_sec_seq_num		=	checkForNull((String) rs2.getString("note_sec_seq_num"),"");
							sys_date_time			=   rs2.getString("sys_date_time");
							image_link_yn			=	checkForNull((String) sectionBean.getImageLinked(sec_hdg_code, subsec_hdg_code),"");
							chief_complaint_sec_yn  =	checkForNull((String) sectionBean.getChiefComplaintSection(sec_hdg_code, subsec_hdg_code),"");


							if(operation_mode.equals("ModifyAddendum"))
							{
								//notes_section_content	= checkForNull((String) sectionBean.getSectionWithAddendumText(sec_hdg_code,subsec_hdg_code,clinician_name,resp_name,com.ehis.util.DateUtils.convertDate(sys_date_time,"DMYHMS","en",locale)),"");//IN033677					
								notes_section_content	= (String)sectionBean.getSectionContent(sec_hdg_code,subsec_hdg_code);//IN033677				
								//IN033677,starts
								String ammend_text = "";
								String content_type = "";
								String ammend_text_temp = "";

								if(record_mode.equals("SignAddendum"))
								{
									content_type = (String) sectionBean.getSectionType( sec_hdg_code, subsec_hdg_code);
									ammend_text = (String) sectionBean.getAddendumText( sec_hdg_code, subsec_hdg_code);

									//IN039642 Start.
									if(!"".equals(ammend_text) && ammend_text!=null)
										ammend_text_temp = ammend_text.trim();
									ammend_text_temp = ammend_text_temp.replaceAll("<ADDRESS>","");
									ammend_text_temp = ammend_text_temp.replaceAll("</ADDRESS>","");
									//IN039642 End.
									//IN033677
									//if(!ammend_text.equals("")) //IN039642 
									//IN037733 if(!ammend_text_temp.equals("")) //IN039642 
									if(!ammend_text_temp.equals("") && !ammend_text_temp.equals("&nbsp;")) //IN037733 
									{

										if (content_type.equals("T"))
										{
											if( !notes_section_content.equals("") )
												notes_section_content = notes_section_content.substring(0,notes_section_content.indexOf("</USER-TEMPLATE>"));

											notes_section_content = notes_section_content +"<USER-TEMPLATE-ADDENDUM CREATED-BY='"+replaceSpecialChars(clinician_name)+"' DATE='"+sys_date_time+"'><![CDATA["+(ammend_text)+"]]></USER-TEMPLATE-ADDENDUM>";
											notes_section_content = notes_section_content +"</USER-TEMPLATE>";
										}
										else
										{
											//notes_section_content +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By: "+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr></table>"; 
											notes_section_content = notes_section_content +"<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I><B>Addendum Created By :</B> "+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr><tr><td>&nbsp;</td></tr></table>";
										}
									}
								}
								//IN033677,ends

							}
							else
							{
								notes_section_content	=	checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code,subsec_hdg_code ),"");								
								
								if(image_link_yn != null && image_link_yn.equals("Y"))
									section_image_content = checkForNull((java.lang.String) sectionBean.getSectionImageContent( sec_hdg_code,subsec_hdg_code ),"");

							}

							if(notes_section_content.equals("") && !(section_image_content.equals("")) )
							{
								notes_section_content = "<ADDRESS>Refer below image</ADDRESS>";

								sectionBean.setSectionContent(sec_hdg_code,subsec_hdg_code,notes_section_content);
							}
							
							edited_yn			= checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
							image_edited_yn		= checkForNull((String) sectionBean.getSectionImageEdited(sec_hdg_code, subsec_hdg_code),"");

							if ( edited_yn.equals("Y") )
							{

								try
								{									
									pstUpdNotSec.setString	(1,	login_user_id			);
									pstUpdNotSec.setString	(2,	login_at_ws_no			);
									pstUpdNotSec.setString	(3,	facility_id				);
									//pstUpdNotSec.setString	(4,	facility_id				);
									pstUpdNotSec.setString	(4,	accession_num			);
									pstUpdNotSec.setString	(5,	sec_hdg_code			);
									pstUpdNotSec.setString	(6,	subsec_hdg_code			);
									update_result = pstUpdNotSec.executeUpdate();
									
									if(update_result > 0)
										note_content_exists = true;					
																	
									pstUpdNotSec.clearParameters();
									
								}
								catch (Exception eUpdFail)
								{
									eUpdFail.printStackTrace();									
									commit_flag = false;
									sb.append("<br>Exception@EJB - Note section content Updation: "+eUpdFail);
								}

								if( update_result <=0 &&  !notes_section_content.equals("") )
								{
									try
									{
										pstInslNotSec.setString	(1,	facility_id				);
										pstInslNotSec.setString	(2,	accession_num			);
										pstInslNotSec.setString	(3,	sec_hdg_code			);
										pstInslNotSec.setString	(4,	subsec_hdg_code			);
										pstInslNotSec.setString	(5,	login_user_id			);
										pstInslNotSec.setString	(6,	login_at_ws_no			);
										pstInslNotSec.setString	(7,	facility_id				);
										pstInslNotSec.setString	(8,	login_user_id			);
										pstInslNotSec.setString	(9,	login_at_ws_no			);
										pstInslNotSec.setString	(10,facility_id				);
										pstInslNotSec.setString	(11,note_sec_seq_num		);
										pstInslNotSec.setString	(12,chief_complaint_sec_yn	);

										insert_result = pstInslNotSec.executeUpdate();
										pstInslNotSec.clearParameters();								

										if(insert_result > 0)
											note_content_exists = true;
					
										
									}
									catch (Exception eInsertSec)
									{
										eInsertSec.printStackTrace();										
										commit_flag = false;
										sb.append("<br>Exception@EJB - Note section content Inserting: "+eInsertSec);
									}
								}								
								
								if ( (update_result > 0 || insert_result > 0 ) && notes_section_content.trim().length() > 0)
								{

									try
									{										
										//pstSelNotSec.setString	(1,	facility_id				);
										pstSelNotSec.setString	(1,	accession_num			);
										pstSelNotSec.setString	(2,	sec_hdg_code			);
										pstSelNotSec.setString	(3,	subsec_hdg_code			);

										rs1 = pstSelNotSec.executeQuery();

										if(rs1.next())
										{												
										//Web logic Conversion -- [IN037372] Start.
											//clob_notes_section_content	=	(oracle.sql.CLOB) rs1.getObject("notes_section_content");
											//section_content_writer		=	((oracle.sql.CLOB)clob_notes_section_content).getCharacterOutputStream();

											//bf_section_content_writer = new java.io.BufferedWriter(section_content_writer);
											
											clob_notes_section_content	=	(java.sql.Clob) rs1.getClob("notes_section_content");
											bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content.setCharacterStream(0));
										//Web logic Conversion -- [IN037372] End.
											bf_section_content_writer.write(notes_section_content,0,notes_section_content.length());

											bf_section_content_writer.flush();
											bf_section_content_writer.close();
											//IN063931 start
											if(Copy_prev_section_flag.equals("Y")){
											clob_notes_section_content_html	=	(java.sql.Clob) rs1.getClob("notes_sec_cont_html");
											
											if("T".equals((String) sectionBean.getSectionType(sec_hdg_code, subsec_hdg_code))){
											notes_section_content_html=converter.buildHTMLFromXML(notes_section_content,"eCA/html/RecClinicalNotesTemplateSentenceView.xsl");
											}else{
												notes_section_content_html=notes_section_content;
											} 
											
											bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content_html.setCharacterStream(0));

											bf_section_content_writer.write(notes_section_content_html,0,notes_section_content_html.length());

											bf_section_content_writer.flush();
											bf_section_content_writer.close();
										}	////IN063931 ends
										}

										pstSelNotSec.clearParameters();

										// inserting outformat of the section starts
										//String outputYN = sectionBean.getOutputExistYN(sec_hdg_code,subsec_hdg_code);
										outputYN = checkForNull((String) sectionBean.getOutputExistYN(sec_hdg_code, subsec_hdg_code),"N");
										//outputYN ="Y";
										if(outputYN.equals("Y"))
										{

											commit_flag = insertSecOutput(con,sec_hdg_code,subsec_hdg_code,sectionBean,htRecClinicalNotes);

										}
										if(appl_task_id.equals("PAT_MEDICAL_REPORT")&&selection_type.equals("M"))
										{
											commit_flag = insertMultiResultKey(con,htRecClinicalNotes);	 //CA_SECTION_MULT_RESULT_KEY
										}


										//insertion ends
									
									}
									catch(Exception eUpdContentFail)
									{
										eUpdContentFail.printStackTrace();										
										commit_flag = false;
										sb.append("<br>Exception@EJB - Note section content Updation: "+eUpdContentFail);
									}
									finally
									{
										if(rs1!=null) rs1.close();
									}
								}
								else if(update_result <= 0 && insert_result <= 0 && notes_section_content.trim().length() > 0){
									commit_flag = false;									
								}
							}

							if(image_edited_yn.equals("Y") && image_link_yn != null && image_link_yn.equals("Y") && !section_image_content.equals("") )
							{
								try
								{
									pstUpdNotSecObj.setString(1,login_user_id);
									//pstUpdNotSecObj.setString(2,facility_id);
									pstUpdNotSecObj.setString(2,accession_num);
									pstUpdNotSecObj.setString(3,sec_hdg_code);
									pstUpdNotSecObj.setString(4,subsec_hdg_code);

									update_result_img = pstUpdNotSecObj.executeUpdate();
									pstUpdNotSecObj.clearParameters();
								}
								catch (Exception eImgUpd)
								{
									eImgUpd.printStackTrace();									
									commit_flag = false;
									sb.append("<br>Exception@EJB - Section Imagecontent Updation: "+eImgUpd);
								}

								if( update_result_img <= 0 && !section_image_content.equals("") )
								{
									try
									{
										// Inserting record for encounter note section obj
										pstInslNotSecObj.setString(1, facility_id);
										pstInslNotSecObj.setString(2, accession_num);
										pstInslNotSecObj.setString(3, login_user_id);
										pstInslNotSecObj.setString(4, login_user_id);
										pstInslNotSecObj.setString(5, sec_hdg_code);
										pstInslNotSecObj.setString(6, subsec_hdg_code);

										insert_result_img = pstInslNotSecObj.executeUpdate() ;
										pstInslNotSecObj.clearParameters();
									}
									catch (Exception eInsImg)
									{
										eInsImg.printStackTrace();										
										commit_flag = false;
										sb.append("<br>Exception@EJB - Section Imagecontent Updation: "+eInsImg);
									}
								}

								if ( ( update_result_img > 0  || insert_result_img > 0 ) && !section_image_content.equals("") )
								{
									try
									{
										//pstSelNotSecObj.setString(1,facility_id);
										pstSelNotSecObj.setString(1,accession_num);
										pstSelNotSecObj.setString(2,sec_hdg_code);
										pstSelNotSecObj.setString(3,subsec_hdg_code);

										rs1 = pstSelNotSecObj.executeQuery();

										if(rs1.next())
										{
										//Web logic Conversion -- [IN037372] Start.
											//clob_section_image_content	=	(oracle.sql.CLOB) rs1.getClob(1);
											//section_content_writer		=	((oracle.sql.CLOB)	clob_section_image_content).getCharacterOutputStream();
											//bf_section_content_writer	=	new java.io.BufferedWriter(section_content_writer);
											
											clob_section_image_content	=	(java.sql.Clob) rs1.getClob(1);
											bf_section_content_writer	=	new java.io.BufferedWriter(clob_section_image_content.setCharacterStream(0));
										//Web logic Conversion -- [IN037372] End
											bf_section_content_writer.write(section_image_content,0,section_image_content.length());
											bf_section_content_writer.flush();
											bf_section_content_writer.close();
										}

										pstSelNotSecObj.clearParameters();
									}
									catch(Exception e)
									{
										e.printStackTrace();
										commit_flag = false;
										sb.append("<br>Exception@EJB - Updating the section Obj :"+e);
									}
									finally
									{
										if(rs1 != null) rs1.close();
									}
								}
								else if(update_result_img <= 0  && insert_result_img <=0 )
									commit_flag = false;
							}

								// Updation for Chief Complaint Section
							if( chief_complaint_sec_yn.equals("Y") )
							{
								String strCompId = "";
								int nDelResult = 0;

								StringBuffer sbDelCompIds = new StringBuffer();

								setChiefComp = (HashSet) sectionBean.getSectionChiefComplaint(sec_hdg_code,subsec_hdg_code);

								if(setChiefComp != null && !setChiefComp.isEmpty())
								{
									pstSelChiefComp.setString(1,facility_id);
									pstSelChiefComp.setString(2,accession_num);
									pstSelChiefComp.setString(3,sec_hdg_code);

									rsSelChiefComp = pstSelChiefComp.executeQuery();

									try
									{
										while (rsSelChiefComp.next())
										{
											strCompId = rsSelChiefComp.getString("COMPLAINT_ID");

											if(!setChiefComp.contains(strCompId))
											{
												sbDelCompIds.append("'");
												sbDelCompIds.append(strCompId);
												sbDelCompIds.append("'");
												sbDelCompIds.append(",");
											}
										}

										sbDelCompIds.append("'$$$$$'");
									}
									catch (Exception edelChiefComp)
									{
										edelChiefComp.printStackTrace();
										commit_flag = false;
										sb.append("<br>Exception@Ejb - @Getting difference GC : "+edelChiefComp);
									}
									finally
									{
										if( rsSelChiefComp != null) rsSelChiefComp.close();
										if( pstSelChiefComp != null) pstSelChiefComp.close(); //CheckStyle
									}

									try
									{
										String delChiefComplaints = "DELETE FROM  CA_ENCNTR_NOTE_SEC_COMPLAINT  where FACILITY_ID = '"+ facility_id+ "' and ACCESSION_NUM='"+ accession_num+ "' AND SEC_HDG_CODE = '"+ subsec_hdg_code + "' and COMPLAINT_ID IN("+sbDelCompIds.toString()+")";

										pstDelChiefComp		=   con.prepareStatement(delChiefComplaints);
										nDelResult = pstDelChiefComp.executeUpdate();
										if(pstDelChiefComp != null)pstDelChiefComp.close();//15950
									}
									catch (Exception edelChiefComp1)
									{
										edelChiefComp1.printStackTrace();
										commit_flag = false;
										sb.append("<br>Exception@Ejb - Deleting unchecked GC  : "+edelChiefComp1);
									}

									try
									{
										itChiefComp = setChiefComp.iterator();

										while(itChiefComp.hasNext())
										{
											complaint = (String)itChiefComp.next();

											pstUpdChiefComp.setString(1,	sec_hdg_code    );
											pstUpdChiefComp.setString(2,	complaint       );
											pstUpdChiefComp.setString(3,	login_user_id	);
											pstUpdChiefComp.setString(4,	login_at_ws_no	);
											pstUpdChiefComp.setString(5,	facility_id		);
											pstUpdChiefComp.setString(6,	facility_id		);
											pstUpdChiefComp.setString(7,	accession_num	);
											pstUpdChiefComp.setString(8,	complaint	);

											update_result = pstUpdChiefComp.executeUpdate();

											pstUpdChiefComp.clearParameters();

											if( update_result <= 0 )
											{
												pstInslChiefComp.setString(1,	facility_id );
												pstInslChiefComp.setString(2,	accession_num );
												pstInslChiefComp.setString(3,	sec_hdg_code );
												pstInslChiefComp.setString(4,	complaint );
												pstInslChiefComp.setString(5,	login_user_id);
												pstInslChiefComp.setString(6,	login_at_ws_no	);
												pstInslChiefComp.setString(7,	facility_id		);
												pstInslChiefComp.setString(8,	login_user_id	);
												pstInslChiefComp.setString(9,	login_at_ws_no	);
												pstInslChiefComp.setString(10,	facility_id		);

												insert_result = pstInslChiefComp.executeUpdate();

												pstInslChiefComp.clearParameters();

												if(insert_result <= 0)
												{
													commit_flag = false;
													break;
												}
											}
										}
									}
									catch(Exception e)
									{
										e.printStackTrace();
										commit_flag = false;
										sb.append("<br>Exception@Ejb - Inserting /Updating Chief Complaint: "+e);
									}
									finally
									{
										sectionBean.removeSectionChiefComplaint(sec_hdg_code,subsec_hdg_code);
									}
								}
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();							
							commit_flag = false;
							sb.append("<br>Exception@EJB - Updating /Inserting note section  : "+e);
						}
					} // end of section population

					if(setChiefComp != null)
						setChiefComp.clear();

					String strTemp = "";

					// This is only for making the note content exists flag as true if addendum is done only @ note level, since the said flag
					// is set @ section level, this is an exceptional case to make it as true. Bcoz commit_flag is set as false if the said flag
					// is set as False.

				//	trace_note_content_exists.append("note_content_exists ---->>> before  if(operation_mode.equals(ModifyAddendum) && note_content_exists == false) at Line 843 in procrssTable Method  "+note_content_exists+"***login_user_id***"+login_user_id+"Patient ID ***"+patient_id+"***Encounter ID***"+encounter_id+"***");

					if(operation_mode.equals("ModifyAddendum") && note_content_exists == false)
						strTemp = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*")==null?"":(String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");

		//			trace_note_content_exists.append("note_content_exists ---->>> before  if(!strTemp.equals) at Line 848 in procrssTable Method  "+note_content_exists+"***login_user_id***"+login_user_id+"Patient ID ***"+patient_id+"***Encounter ID***"+encounter_id+"***");

					if(!strTemp.equals("") )
						note_content_exists = true;

			//		trace_note_content_exists.append("note_content_exists ---->>> After  if(!strTemp.equals) at Line 848 in procrssTable Method  "+note_content_exists+"***login_user_id***"+login_user_id+"Patient ID ***"+patient_id+"***Encounter ID***"+encounter_id+"***");

				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@Ejb Record - Before Section Population: "+e);
				}
				finally
				{
					if(rs2 != null) rs2.close();
					if(rs1 != null) rs1.close();

					if(pstmt != null)				pstmt.close();
					if(pstUpdNotSec != null)		pstUpdNotSec.close();
					if(pstUpdNotSecObj != null)		pstUpdNotSecObj.close();
					if(pstUpdChiefComp != null)		pstUpdChiefComp.close();
					if(pstSelNotSec != null)		pstSelNotSec.close();
					if(pstSelNotSecObj != null)		pstSelNotSecObj.close();
					if(pstInslNotSec != null)		pstInslNotSec.close();
					if(pstInslChiefComp != null)	pstInslChiefComp.close();
					if(pstInslNotSecObj != null)	pstInslNotSecObj.close();

					if( clob_notes_section_content != null )
						clob_notes_section_content = null;

					if( clob_section_image_content != null )
						clob_section_image_content = null;

					if( notes_section_content != null )
						notes_section_content = null;

					if( section_image_content != null )
						section_image_content = null;
				}				

				if(commit_flag)
				{
					//boolean proc_result = caBuildNotes(converter,facility_id, accession_num, sectionBean, con,locale);//IN033677
					//boolean proc_result = caBuildNotes(converter,facility_id, accession_num, sectionBean, con,locale,htRecClinicalNotes);//IN029312
					//boolean proc_result = caBuildNotes(converter,facility_id, accession_num, sectionBean, con,locale,htRecClinicalNotes);//IN033677
					//boolean proc_result = caBuildNotes(converter,facility_id, accession_num, sectionBean, con,locale,htRecClinicalNotes,patient_id,encounter_id,contr_mod_accession_num);//IN041827
					//boolean proc_result = caBuildNotes(converter,facility_id, accession_num, sectionBean, con,locale,htRecClinicalNotes,patient_id,encounter_id,contr_mod_accession_num,noteCopiedYN);//IN068105//IN072879
					  boolean proc_result = caBuildNotes(converter,facility_id, accession_num, sectionBean, con,locale,htRecClinicalNotes,patient_id,encounter_id,contr_mod_accession_num,noteCopiedYN,sexValue,speciality_name,location_code);//IN072879
					if(!proc_result){
						commit_flag = false;
					}else{//IN071264 Starts
						autoSaveBean.removedatafromsectionTemp(patient_id,encounter_id,note_type,login_user_id,con);
						//removedatafromsectionObjTemp(patient_id,encounter_id,note_type,login_user_id,con);
						//removedatafromaddendumTemp(patient_id,encounter_id,note_type,login_user_id,con);
					}//IN071264 Ends
/*
					String strResult = "N";
					CallableStatement csBuildNotes = null;

					try
					{
						csBuildNotes = con.prepareCall("{call CA_BUILD_NOTES(?,?,?,?)}");
						csBuildNotes.setString(1,facility_id);
						csBuildNotes.setString(2,accession_num);
						csBuildNotes.registerOutParameter(3,Types.VARCHAR);
						csBuildNotes.setString(4,locale);
						csBuildNotes.execute();

						strResult = csBuildNotes.getString(3);

						if(!strResult.equals("Y"))
							commit_flag= false;


					}
					catch (Exception eG)
					{
						eG.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@Ejb - recordCN-004: "+eG);
					}
					finally
					{
						if(csBuildNotes != null) csBuildNotes.close();
					}
					*/
				}
			}
			else	
			{	// If the changes only at Header level not at section level.
				note_content_exists = true;
			//	trace_note_content_exists.append("note_content_exists ---->>> in else at Line 930 in procrssTable Method  "+note_content_exists+"***login_user_id***"+login_user_id+"Patient ID ***"+patient_id+"***Encounter ID***"+encounter_id+"***");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@recordCN-006 : "+e);
		}
		finally
		{
			try
			{
				//Test Code for Trace
				//String strKey = patient_id + "~" + encounter_id;
				//String resultKey = sectionBean.getpropPatientSection(strKey);

				message = new Hashtable();

				//End Test Code

				if(!(note_content_exists))
				{
					commit_flag =	false;
					message		=	mm.getMessage( locale, "NOTE_CONTENT_NOT_EXISTS","CA" ) ;
					sb.append( (String) message.get("message") ) ;					
				}
				
				if(commit_flag)
				{
					result	=	true ;
					message	=	mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
				}
				// IN048276 Start
				else{
					result	=	false ;
					//sb.append( "Transaction Failed, Please try agin." ) ;
					sb.append(" Exception Occurred, Please create 'New Note' to proceed further.");
				}
				//IN048276 End.
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@Recording Final  : "+e);
			}
		}

		htRecClinicalNotes.put(	"accession_num",	accession_num	);
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ;
		message.clear();
		message = null;		
		return results ;
	}

//IN071264 Starts 
	private void removedatafromsectionObjTemp(String patient_id,
			String encounter_id, String note_type, String login_user_id,
			Connection con) {
		String delete_ca_encntr_note_section_temp = "delete from ca_encntr_note_section_obj_tmp where patient_id = ? and encounter_id = ? and added_by_id=? and note_type = ? ";
		
		PreparedStatement pstmt =  null;
		int index=1;
		try {
			pstmt	=	con.prepareStatement(delete_ca_encntr_note_section_temp);
			pstmt.setString	(	index++,	patient_id	);
			pstmt.setString	(	index++,	encounter_id	);
			pstmt.setString	(	index++,	login_user_id		);
			pstmt.setString	(	index++,	note_type	);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//IN071264 ENDS
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap recordRecClinicalNotes( java.util.Properties jdbc_props, 	java.util.HashMap htRecClinicalNotes, webbeans.eCA.RecClinicalNotesSectionBean	sectionBean, webbeans.eCA.XMLtoHTML converter,String strInsertFlag)
	{
		System.out.println("~~~~~~~~EJB recordRecClinicalNotes~~~~~~~~");
		Connection		  con			=	null;
		java.util.HashMap recresults	=	new java.util.HashMap() ;
		boolean bRtnResult				=	false;

		String  locale					=   "";

		try
		{
			con		=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);
		
			recresults = (HashMap) processTables(con,jdbc_props,htRecClinicalNotes, sectionBean,converter,strInsertFlag);

			locale = (String) htRecClinicalNotes.get("LOCALE");

			bRtnResult		=	( ((Boolean) recresults.get( "status" )).booleanValue() );

			if(bRtnResult)
				con.commit();
			else
				con.rollback();
		}
		catch (Exception eMainRec)
		{
			eMainRec.printStackTrace();
			sb.append("<br>Exception@Mainrecord-001 : "+eMainRec);
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
		}

		return recresults;
	}

	//*****************************************************************//

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap signRecClinicalNotes( java.util.Properties jdbc_props, java.util.HashMap htRecClinicalNotes, webbeans.eCA.RecClinicalNotesSectionBean	sectionBean, webbeans.eCA.XMLtoHTML converter)
	{
		System.out.println("~~~~~~~~EJB signRecClinicalNotes~~~~~~~~");
		Connection			con			= null;
		PreparedStatement	pstmt		= null;
		ResultSet			rs					=	null;

		java.util.HashMap results			=	new java.util.HashMap() ;
		java.util.Hashtable		message		=	null;

		StringBuffer		sb		=	new StringBuffer( "" ) ;

		String		clinician_id			=	"",		facility_id					=	"";
		String		accession_num			=	"",		event_date_time				=	"";
		String		performed_by_id			=	"",		authorized_by_id			=	"";
		String		authorized_date_time	=	"",		event_status				=	"";
		String		login_user_id			=	"",		login_at_ws_no				=	"";
		String		forwarded_clinician_id	=	"",		privilege_type				=	"";
		String		action_comment			=	"",		resp_id						=	"";
		String		strInsertFlag			=	"",		note_type					=	"";
		String		strOutput				=	"N",	operation_mode				=	"";
		String      event_status_caption	=	"",		locale						=	"";
		String		print_notes_yn			=	"";
		String		incSysDateTime			=	"";
		String		contr_mod_accession_num	=	"";
		String 		contr_oth_accession_num =	"";//IN053733
		String		patient_id				=	"";
		String		function_id				=	"";
		String forwardToFac = "";//IN038176
		String myHIXFlg = "N";//IN067607
		String noteCopiedYN = "N";//IN068105
		CallableStatement	cspreAmend	=	null; //IN060975

		int			update_result			=	0;
		int			update_task_result		=	0;

		boolean	result						=	false,	commit_flag					=	true;
		boolean record_status				=   false;

		MessageManager			mm			=	null;

		try
		{
			con		=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);

			mm							=	new MessageManager();

			privilege_type				=	(String) htRecClinicalNotes.get ( "privilege_type"		);
			clinician_id				=	(String) htRecClinicalNotes.get ( "clinician_id"		);
			facility_id					=	(String) htRecClinicalNotes.get ( "facility_id"			);
			login_user_id				=	(String) htRecClinicalNotes.get ( "login_user_id"		);
			login_at_ws_no				=	(String) htRecClinicalNotes.get ( "login_at_ws_no"		);
			accession_num				=	(String) htRecClinicalNotes.get ( "accession_num"		);
			privilege_type				=	(String) htRecClinicalNotes.get ( "privilege_type"		);
			event_date_time				=	(String) htRecClinicalNotes.get ( "event_date_time"		);
			performed_by_id				=	(String) htRecClinicalNotes.get ( "performed_by_id"		);
			authorized_by_id			=	(String) htRecClinicalNotes.get ( "authorized_by_id"	);
			authorized_date_time		=	(String) htRecClinicalNotes.get ( "authorized_date_time");
			event_status				=	(String) htRecClinicalNotes.get ( "event_status"		);
			forwarded_clinician_id		=	(String) htRecClinicalNotes.get ( "forwarded_clinician_id"	);
			action_comment				=	(String) htRecClinicalNotes.get ( "action_comment"			);
			resp_id						=	(String) htRecClinicalNotes.get ( "responsibility_id"		);
			note_type					=	(String) htRecClinicalNotes.get ( "note_type"				);
			operation_mode				=	(String) htRecClinicalNotes.get ( "operation_mode"			);
			event_status_caption		=   (String) htRecClinicalNotes.get ( "event_status_caption"	);
			locale						=   (String) htRecClinicalNotes.get ( "LOCALE"	);
			contr_mod_accession_num		=	(String) htRecClinicalNotes.get ( "contr_mod_accession_num"	);
			contr_oth_accession_num		=	(String) htRecClinicalNotes.get ( "contr_oth_accession_num"	); //IN053733
			patient_id					=	(String) htRecClinicalNotes.get ( "patient_id"				);
			function_id					=	(String) htRecClinicalNotes.get ( "function_id"				);
			forwardToFac					=	(String) htRecClinicalNotes.get ("forwardToFac");//IN038176
			myHIXFlg					=	(String) htRecClinicalNotes.get ("myHIXFlg");//IN067607
			noteCopiedYN					=	(String) htRecClinicalNotes.get ("noteCopiedYN");//IN068105


			if(function_id==null)
			{
				function_id="";
			}

			
			if(accession_num.equals(""))
			{
				try
				{
					htRecClinicalNotes.put(	"authorized_by_id",		authorized_by_id		);
					htRecClinicalNotes.put(	"authorized_date_time",	authorized_date_time	);
					htRecClinicalNotes.put(	"event_status",			event_status			);

					strInsertFlag = "N";

					java.util.HashMap record_results	=	(HashMap) processTables(con,jdbc_props, htRecClinicalNotes, sectionBean,converter,strInsertFlag);
					record_status						=	((Boolean)record_results.get("status")).booleanValue();
					
					if(record_status)
					{
						accession_num	=	(String) record_results.get("accession_num");
						strInsertFlag = "Y";
					}
					else
					{
						commit_flag = false;
						sb.append((String)record_results.get("error"));
					}
					record_results.clear();

				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;

					sb.append("<br>Exception@signCN-1: "+e);
				}
			}
			

			if(commit_flag)
			{

				/******************ADDED BY Deepa on 9/19/2009 at 5:23 PM for IN010603************************/

				if(privilege_type == null || privilege_type.equals("") || function_id.equals("SIGN_NOTES"))
				{
					
					try
					{
						privilege_type = getPrivilegeType(con,resp_id,note_type,login_user_id);	
					}
					catch (Exception ePri)
					{
						ePri.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@sign - @ Getting Privilege Type : "+ePri);
					}
				}

				try
				{
					String sys_qry ="select to_char((sysdate+(0.0066/600)),'dd/mm/yyyy hh24:mi:ss') sysTime from dual";

					pstmt	=	con.prepareStatement(sys_qry);
					rs =pstmt.executeQuery();
					while(rs.next())
					{
						incSysDateTime = rs.getString("sysTime")==null?"SYSDATE":rs.getString("sysTime");
					}

				}
				catch (Exception eSys)
				{
					eSys.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@sign - @ Getting Systime : "+eSys);
				}
				finally
				{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
					
				if( privilege_type.equals("1") )
				{
					authorized_by_id		=	"";
					authorized_date_time	=	"";
					event_status			=	"2";

					try
					{

						//if( operation_mode.equals("SignOnModify") )
						//	strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);
						//else
						//	strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);

						//if( strOutput.equals("Y"))
						//{
							strOutput = "N";

							//if( operation_mode.equals("SignOnModify") )
								//strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"TR","CO",clinician_id,login_user_id,login_at_ws_no,null,null,null,privilege_type);//IN67872
							strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","TR","CO",clinician_id,login_user_id,login_at_ws_no,null,null,null,privilege_type);//IN67872
							/*
							else
								strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"TR","CO",clinician_id,login_user_id,login_at_ws_no,null,null,null,privilege_type); */
							

							if( strOutput.equals("Y") )
							{
								strOutput = "N";

								if( operation_mode.equals("SignOnModify") || operation_mode.equals("Sign"))
								{
									strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","RQ",performed_by_id,login_user_id,login_at_ws_no,clinician_id,"SYSDATE",null,privilege_type);
								}
								else
								{
									//strOutput = //insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","RQ",performed_by_id,login_user_id,login_at_ws_no,null,null,null);
									strOutput = insertAuditLog(con,facility_id,accession_num,null,"SN","RQ",performed_by_id,login_user_id,login_at_ws_no,null,"SYSDATE",null,privilege_type);
								}


								if(!strOutput.equals("Y") )
									commit_flag = false;
							}
							else
								commit_flag = false;
						/*}
						else
							commit_flag = false; */
					}
					catch (Exception ePri1Exp)
					{
						ePri1Exp.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@Audit Log for Prev 1  "+ePri1Exp);
					}
				}
				else if( privilege_type.equals("2") )
				{
					authorized_by_id		=	"";
					authorized_date_time	=	"";


					if(forwarded_clinician_id.equals("") || action_comment.equals("") )
					{
						if( operation_mode.equals("Sign") )
						{
							event_status			=	"1";
							commit_flag				=	false;
							message					=	mm.getMessage( locale, "FORWARD_CLINICIAN_REQUIRED","CA" ) ;

							sb.append( (String) message.get("message") ) ;
						}
					}
					else
					{
						event_status			=	"3";

						try
						{

							//String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE, action_status = 'CO', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where /*facility_id = ? and*/ accession_num = ? and action_by_id = ? and action_type = 'SN' ";//IN67872
							String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE, action_status = 'CO', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where /*facility_id = ? and*/ accession_num = ? and action_by_id = ? and action_type = 'SN' and action_status = 'RQ' and action_status != 'RJ'";//IN67872

							pstmt	=	con.prepareStatement(update_ca_encntr_note_audit_log);

							pstmt.setString	(	1,	login_user_id	);
							pstmt.setString	(	2,	login_at_ws_no	);
							pstmt.setString	(	3,	facility_id		);
							//pstmt.setString	(	4,	facility_id		);
							pstmt.setString	(	4,	accession_num	);
							pstmt.setString	(	5,	clinician_id	);

							update_result = pstmt.executeUpdate();

							if(update_result > 0 )
								strOutput = "Y";
					
						}
						catch(Exception e)
						{
							e.printStackTrace();
							commit_flag = false;
							sb.append("<br>Exception@signOnModifyCN-105: @ audit log "+e);
						}

						finally
						{
							if(pstmt!=null) pstmt.close();
						}

						if(update_result <= 0)
						{
							try
							{
								strOutput = "N";

								//if(operation_mode.equals("SignOnModify") )
								//strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);
								//else
								//	strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);

								//if( strOutput.equals("Y") )
								//{
									strOutput = "N";
									//strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null,privilege_type);//IN67872
									strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null,privilege_type,"","",forwardToFac);//IN038176

									if(!strOutput.equals("Y") )
										commit_flag = false;

								/*}
								else
									commit_flag = false; */
							}
							catch (Exception eALPriv2)
							{
								eALPriv2.printStackTrace();
								commit_flag = false;
								sb.append("<br>Exception@signOnModifyCN-105: @ audit log "+eALPriv2);
							}
						}

						if(strOutput.equals("Y") )
						{
							try
							{
								strOutput = "N";

								if(operation_mode.equals("SignOnModify") )
									//strOutput = insertAuditLog(con,facility_id,accession_num,null,"SN","RQ",forwarded_clinician_id,login_user_id,login_at_ws_no,clinician_id,"SYSDATE",action_comment,privilege_type);//IN038176
									strOutput = insertAuditLog(con,facility_id,accession_num,null,"SN","RQ",forwarded_clinician_id,login_user_id,login_at_ws_no,clinician_id,"SYSDATE",action_comment,privilege_type,"","",forwardToFac);//IN038176
								else
									//strOutput = insertAuditLog(con,facility_id,accession_num,null,"SN","RQ",forwarded_clinician_id,login_user_id,login_at_ws_no,performed_by_id,"SYSDATE",action_comment,privilege_type);//IN038176
									strOutput = insertAuditLog(con,facility_id,accession_num,null,"SN","RQ",forwarded_clinician_id,login_user_id,login_at_ws_no,performed_by_id,"SYSDATE",action_comment,privilege_type,"","",forwardToFac);//IN038176

								if(!strOutput.equals("Y") )
									commit_flag = false;
							}
							catch(Exception e)
							{
								e.printStackTrace();
								commit_flag = false;
								sb.append("<br>Exception@Audig Log - sign  "+e);
							}
						}
					}
				} // end of else if(privilege_type.equals("2"))
				else if( privilege_type.equals("3") || privilege_type.equals("4") )
				{
					authorized_by_id		=	clinician_id; //login_user_id;
					authorized_date_time	=	"SYSDATE";
					event_status			=	"4";
					
					try
					{

						//String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE, action_status = 'CO', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? , PRIVILEGE_TYPE= ? where /*facility_id = ? and*/ accession_num = ? and action_by_id = ? and action_type = 'SN' ";//IN67872
						String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE, action_status = 'CO', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? , PRIVILEGE_TYPE= ? where /*facility_id = ? and*/ accession_num = ? and action_by_id = ? and action_type = 'SN' and action_status='RQ'";//IN67872

						pstmt	=	con.prepareStatement(update_ca_encntr_note_audit_log);

						pstmt.setString	(	1,	login_user_id	);
						pstmt.setString	(	2,	login_at_ws_no	);
						pstmt.setString	(	3,	facility_id		);
						pstmt.setString	(	4,	privilege_type		);
						//pstmt.setString	(	5,	facility_id		);
						pstmt.setString	(	5,	accession_num	);
						pstmt.setString	(	6,	clinician_id	);

						update_result = pstmt.executeUpdate();					
					}
					catch(Exception e)
					{
						e.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@sign - 109: @ audit log "+e);
					}

					finally
					{
						try
						{
							if(pstmt!=null) pstmt.close();
						}
						catch(Exception e){}
					}


					if(update_result <= 0)
					{
						try
						{
							strOutput = "N";

							//if(operation_mode.equals("SignOnModify") )
							//	strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);
							//else
								//strOutput = insertAuditLog(con,facility_id,accession_num,event_date_time,"PR","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null);

							//if( strOutput.equals("Y") )
							//{
							//	strOutput = "N";

								if(operation_mode.equals("SignOnModify"))
								{									
									//strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","CO",clinician_id,login_user_id,login_at_ws_no,null,null,null,privilege_type); //commented for IN060975
									strOutput = insertAuditLog(con,facility_id,accession_num,incSysDateTime,"SN","CO",clinician_id,login_user_id,login_at_ws_no,null,null,null,privilege_type); //Modified for IN060975
								}
								else
								{									
									//strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null,privilege_type); //commented for IN060975
									strOutput = insertAuditLog(con,facility_id,accession_num,incSysDateTime,"SN","CO",performed_by_id,login_user_id,login_at_ws_no,null,null,null,privilege_type); //Modified for IN060975
								}

								if(!strOutput.equals("Y"))
									commit_flag = false;
						/*	}
							else
								commit_flag = false; */

								// Added for IN060975 starts
								if(strOutput.equals("Y") )
								{
									try
									{
										cspreAmend					=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?,?)}");
										cspreAmend.setString (1,facility_id);
										cspreAmend.setString (2,accession_num);
										cspreAmend.setString (3,incSysDateTime);
										cspreAmend.registerOutParameter (4,Types.VARCHAR);
										cspreAmend.setString (5,"SN");
										cspreAmend.execute();
										strOutput = cspreAmend.getString(4);
										if(cspreAmend!=null)//15950
											cspreAmend.close();//15950
									}
									catch (Exception ee2)
									{
										ee2.printStackTrace();
										commit_flag = false;
										sb.append("<br>Exception@modify - 142: "+ee2);
									}
									finally//IN67872 CS, starts
									{
										if(cspreAmend!=null)
											cspreAmend.close();
									}//IN67872 CS, ends
									if(!strOutput.equals("Y") )
										commit_flag = false;
								}
								// Added for IN060975 Ends
						}
						catch (Exception ePri3AuditLog)
						{
							ePri3AuditLog.printStackTrace();
							commit_flag = false;
							sb.append("<br>Exception@ audit log 3 "+ePri3AuditLog);
							ePri3AuditLog.printStackTrace();
						}
					}
					// Added else block for IN060975 Starts
					else
					{
						try
						{
							cspreAmend					=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?,?)}");
							cspreAmend.setString (1,facility_id);
							cspreAmend.setString (2,accession_num);
							cspreAmend.setString (3,incSysDateTime);
							cspreAmend.registerOutParameter (4,Types.VARCHAR);
							cspreAmend.setString (5,"SN");
							cspreAmend.execute();
							strOutput = cspreAmend.getString(4);
						}
						catch (Exception ee2)
						{
							ee2.printStackTrace();
							commit_flag = false;
							sb.append("<br>Exception@modify - 142: "+ee2);
						}
						if(!strOutput.equals("Y") )
								commit_flag = false;
					}
					// Added else block for IN060975 Ends
					/*else  -- shaiju commented
						commit_flag = false;*/
				}
			}


			if(!(accession_num.equals("")) && commit_flag == true)
			{
				record_status = false;
				java.util.HashMap record_results = new HashMap();

				try
				{
					htRecClinicalNotes.put(	"authorized_by_id",		authorized_by_id		);
					htRecClinicalNotes.put(	"authorized_date_time",	authorized_date_time	);
					htRecClinicalNotes.put(	"event_status",			event_status			);
					

					// while signing the note requested from task list. contr_mod_accession_num
					if(!contr_mod_accession_num.equals("")&&function_id.equals("TASK_LIST"))
					{

						String update_pat_task_list = "update CA_PAT_TASK_LIST set STATUS ='P' where PATIENT_ID = ? and REQ_ACCESSION_NUM = ? ";

						//\*and   TASK_CODE  = '&NTS'*\
						pstmt		=	con.prepareStatement(update_pat_task_list);
						pstmt.setString	( 1,	patient_id	);
						pstmt.setString	( 2,	contr_mod_accession_num	);

						update_task_result = pstmt.executeUpdate();

						

					}


					if( operation_mode.equals("SignOnModify") )
					{

						//String update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = SYSDATE, event_status_caption = ?, event_status = ?, last_amended_by_id=? , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and accession_num = ? ";//Commented for IN067607
						String update_ca_encntr_note = "update ca_encntr_note set authorized_by_id = ?, authorized_date_time = SYSDATE, event_status_caption = ?, event_status = ?, last_amended_by_id=? , last_amended_date_time=SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, MYHIX_SEND_YN = ? where facility_id = ? and accession_num = ? ";//Modified for IN067607

						pstmt	=	con.prepareStatement(update_ca_encntr_note);

						pstmt.setString	(	1,	authorized_by_id		);
						pstmt.setString	(	2,	event_status_caption	);
						pstmt.setString	(	3,	event_status			);
						pstmt.setString	(	4,	authorized_by_id		);
						pstmt.setString	(	5,	login_user_id			);
						pstmt.setString	(	6,	login_at_ws_no			);
						pstmt.setString	(	7,	facility_id				);
						pstmt.setString	(	8,	myHIXFlg				);//Added for IN067607
						pstmt.setString	(	9,	facility_id				);
						pstmt.setString	(	10,	accession_num			);

						update_result = pstmt.executeUpdate();

						if(update_result > 0)
							record_status = true;
					}
					else
					{

						record_results				=	(HashMap) processTables(con,jdbc_props, htRecClinicalNotes, sectionBean, converter,strInsertFlag);
						record_status				=	((Boolean)record_results.get("status")).booleanValue();
					}



					if(record_status)
						accession_num	=	(String) record_results.get("accession_num");
					else
					{
						commit_flag = false;
						sb.append((String)record_results.get("error"));
					}

					record_results.clear();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@sign -112 : "+e);
				}
			}
			//IN073435 Start.
			if(operation_mode.equals("Sign")){
				try{
					cspreAmend					=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?,?)}");
					cspreAmend.setString (1,facility_id);
					cspreAmend.setString (2,accession_num);
					cspreAmend.setString (3,incSysDateTime);
					cspreAmend.registerOutParameter (4,Types.VARCHAR);
					cspreAmend.setString (5,"SN");
					cspreAmend.execute();
					strOutput = cspreAmend.getString(4);
				}
				catch (Exception ee2)
				{
					ee2.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@modify - 142: "+ee2);
				}
				if(!strOutput.equals("Y") )
					commit_flag = false;		
			
			}
			//IN073435 End.
			//print on sign

			if(pstmt!=null) pstmt.close();


	        String print_qry ="select  PRINT_NOTES_ON_SIGN  from CA_NOTE_TYPE  where NOTE_TYPE =?";

			pstmt	=	con.prepareStatement(print_qry);

			pstmt.setString	( 1,note_type);

			rs			=	pstmt.executeQuery();

			while(rs.next())
			{

				print_notes_yn =rs.getString("PRINT_NOTES_ON_SIGN")==null?"":rs.getString("PRINT_NOTES_ON_SIGN");

			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();


			//end

		} // end of try
		catch(Exception e)
		{
			commit_flag = false;
			sb.append("<br>Exception@signCN -113: "+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
					con.rollback();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@sign - 114: "+e);

				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					strInsertFlag = "N";
					if (message != null) message.clear();
					if(pstmt!=null) pstmt.close();
					if(cspreAmend!=null) cspreAmend.close(); // Added for IN060975
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}
				catch(Exception e){}
			} // end of finally
		} // end of finally

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;

		results.put( "accession_num", accession_num ) ;
		results.put( "print_notes_yn", print_notes_yn ) ;
		return results ;
	} // end of method signRecClinicalNotes

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap forwardRecClinicalNotes( java.util.Properties jdbc_props, java.util.HashMap htRecClinicalNotes)
	{
		System.out.println("~~~~~~~~EJB forwardRecClinicalNotes~~~~~~~~");
		System.out.println(htRecClinicalNotes.toString());
		Connection			con			=	null;
		PreparedStatement	pstmt	=	null;
		java.util.HashMap results	=	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		String	facility_id					=	"",		accession_num				=	"";
		String	clinician_id				=	"",		forwarded_clinician_id		=	"";
		String	login_user_id				=	"",		login_at_ws_no				=	"";
		String	action_comment				=	"";		//strOutput					=	"N";
		String  locale						=	"";
		String forward_mode = "";
		/*******Added by Deepa for IN0010603 on 5/20/2009********/
		String privilege_type = "";
		String strOutput = "";
		String forwardToFac = "";//IN037675

		boolean result						=	false,	commit_flag					=	true;
	//	int		insert_result				=	0;
		MessageManager			mm			=	null;
		java.util.Hashtable		message		=	null;
		//String	insert_ca_encntr_note_audit_log	=	"";

		try
		{
			mm							=	new MessageManager();

			clinician_id				=	(String) htRecClinicalNotes.get ( "clinician_id"			);
			facility_id					=	(String) htRecClinicalNotes.get ( "facility_id"				);
			accession_num				=	(String) htRecClinicalNotes.get ( "accession_num"			);
			forwarded_clinician_id		=	(String) htRecClinicalNotes.get ( "forwarded_clinician_id"	);
			action_comment				=	(String) htRecClinicalNotes.get ( "action_comment"			);
			login_user_id				=	(String) htRecClinicalNotes.get ( "login_user_id"			);
			login_at_ws_no				=	(String) htRecClinicalNotes.get ( "login_at_ws_no"			);
			locale						=	(String) htRecClinicalNotes.get ( "LOCALE"			);
			forwardToFac			    =	(String) htRecClinicalNotes.get ("forwardToFac");//IN037675
			//Added for note forwarding to speciality
			forward_mode = (String) htRecClinicalNotes.get("forward_mode");
			/*******Added by Deepa for IN0010603 on 5/20/2009********/
			privilege_type = (String) htRecClinicalNotes.get("privilege_type");

			//Added for note forwarding to speciality
			con		=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);
			//Shaiju st
			try
			{
				// 10603 changes starts
				//strOutput = insertAuditLog(con,facility_id,accession_num,sys_date_time,"SP","CO",clinician_id,login_user_id,login_at_ws_no,null,null,action_comment,privilege_type);

				//insertAuditLog(Connection con, String facility_id, String accession_num, String event_date_time, String action_type, String action_status,String performed_by_id, String login_user_id, String login_at_ws_no, String request_by_id,String request_datetime,String action_comment, String privilege_type)


				strOutput ="N";

				if(forward_mode.equalsIgnoreCase("P"))
				{
					strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","RV","RQ",forwarded_clinician_id,login_user_id,login_at_ws_no,clinician_id,"SYSDATE",action_comment,privilege_type,forward_mode,"",forwardToFac);//IN037675
				}
				else
				{
					strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","FS","RQ",clinician_id,login_user_id,login_at_ws_no,clinician_id,"SYSDATE",action_comment,privilege_type,forward_mode,forwarded_clinician_id,forwardToFac);//IN037675
				}


				if( strOutput.equals("N") )	commit_flag = false;

				// 10603 changes ends
				//insert_ca_encntr_note_audit_log = "insert into ca_encntr_note_audit_log ( facility_id, accession_num, action_date_time, action_type, action_status, action_by_id, request_date_time, request_by_id, action_comment, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, action_by_type,action_by_group_code ) values ( ?, ?, decode(?,'P',NULL,sysdate), ?, 'RQ', ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,? ) ";
			/*	insert_ca_encntr_note_audit_log = "insert into ca_encntr_note_audit_log ( facility_id, accession_num, action_date_time, action_type, action_status, action_by_id, request_date_time, request_by_id, action_comment, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, action_by_type,action_by_group_code,PRIVILEGE_TYPE ) values ( ?, ?, decode(?,'S',SYSDATE,NULL), ?, 'RQ', ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,? ) ";

				pstmt	=	con.prepareStatement(insert_ca_encntr_note_audit_log);

				pstmt.setString	(	1,	facility_id				);	// facility_id
				pstmt.setString	(	2,	accession_num			);

				if(forward_mode.equalsIgnoreCase("P"))
				{
					pstmt.setString	(	3,	forward_mode);
					pstmt.setString	(	4,	"RV");
					pstmt.setString	(	5,	forwarded_clinician_id	);
					pstmt.setString	(	15,	""	);
				}
				else
				{
					pstmt.setString	(	3,	forward_mode);
					pstmt.setString	(	4,	"FS");
					pstmt.setString	(	5,	clinician_id	);
					pstmt.setString	(	15,	forwarded_clinician_id	);
				}
				pstmt.setString	(	6,	clinician_id			);
				pstmt.setString	(	7,	action_comment			);

				pstmt.setString	(	8,	login_user_id			);
				pstmt.setString	(	9,	login_at_ws_no			);
				pstmt.setString	(  10,	facility_id				);
				pstmt.setString	(  11,	login_user_id			);
				pstmt.setString	(  12,	login_at_ws_no			);
				pstmt.setString	(  13,	facility_id				);
				pstmt.setString	(  14,	forward_mode				);
				/*if(forward_mode.equalsIgnoreCase("S"))
				{
					pstmt.setString	(	12,	forwarded_clinician_id	);
				}
				else
				{
					pstmt.setString	(	12,	""	);
				}*/
				/*******Added by Deepa for IN0010603 on 5/20/2009********/

			/*	pstmt.setString	(  16,	privilege_type				);
				insert_result = pstmt.executeUpdate();*/

				//if( insert_result <= 0 )	commit_flag = false;

			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@forwardCN-1: "+e);
			}

			finally
			{
				try
				{
					if(pstmt!=null) pstmt.close();
					//if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}
				catch(Exception e){}
			}
		} // end of try



			//Shaiju en

			/*try
			{
				strOutput ="N";
				strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","RV","RQ",forwarded_clinician_id,login_user_id,login_at_ws_no,clinician_id,"SYSDATE",action_comment);

				if(!strOutput.equals("Y") )
					commit_flag = false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@forward -121: @ audir log "+e);
			} */

		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@forward- 122:"+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
					con.rollback();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@forward  - 123:"+e);

				try
				{
					con.rollback();
				}
				catch(Exception e1)
				{}
			}
			finally
			{
				try
				{
					message.clear();
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}
				catch(Exception e)
				{}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ;  //[Bru-HIMS-CRF-024] IN041643

		return results ;
	} // end of forwardRecClinicalNotes

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap reviewRecClinicalNotes(java.util.Properties		jdbc_props,java.util.HashMap			htRecClinicalNotes)
	{
		System.out.println("~~~~~~~~EJB reviewRecClinicalNotes~~~~~~~~");
		System.out.println(htRecClinicalNotes.toString());
		Connection			con			=	null;
		PreparedStatement   pstmt		=	null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		String	clinician_id				=	"";
		String	facility_id					=	"",		accession_num				=	"";
		String	login_user_id				=	"",		login_at_ws_no				=	"";
		String  strOutput					=	"N",	locale						=	"";
		/*******Added by Deepa for IN0010603 on 5/20/2009********/
		String privilege_type = "";

		boolean result						=	false,	commit_flag					=	true;

		int		update_result				=	0;

		MessageManager			mm			=	null;
		java.util.Hashtable		message		=	null;

		try
		{
			mm						=	new MessageManager();

			clinician_id			=	(String) htRecClinicalNotes.get ( "clinician_id"			);
			facility_id				=	(String) htRecClinicalNotes.get ( "facility_id"				);
			accession_num			=	(String) htRecClinicalNotes.get ( "accession_num"			);
			login_user_id			=	(String) htRecClinicalNotes.get ( "login_user_id"			);
			login_at_ws_no			=	(String) htRecClinicalNotes.get ( "login_at_ws_no"			);
			locale					=	(String) htRecClinicalNotes.get ( "LOCALE"			);
			/*******Added by Deepa for IN0010603 on 5/20/2009********/
			privilege_type = (String) htRecClinicalNotes.get("privilege_type");

			con		=	ConnectionManager.getConnection(jdbc_props);

			con.setAutoCommit(false);

			try
			{


				String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE, action_status = 'CO', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where action_status = 'RQ' and action_type = 'RV' and action_by_id = ? /*and facility_id = ? */ and accession_num  = ? ";//Dinesh T 7/20/2012

			

				pstmt	=	con.prepareStatement(update_ca_encntr_note_audit_log);

				pstmt.setString	(	1,	login_user_id	);
				pstmt.setString	(	2,	login_at_ws_no	);
				pstmt.setString	(	3,	facility_id		);
				pstmt.setString	(	4,	clinician_id	);
				//pstmt.setString	(	5,	facility_id	);
				pstmt.setString	(	5,	accession_num	);//Dinesh T 7/20/2012

				update_result = pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@review - 141: "+e);
			}

			finally
			{
				if(pstmt!=null) pstmt.close();
			}

			if( update_result <= 0 )
			{
				try
				{
					strOutput ="N";
					strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","RV","CO",clinician_id,login_user_id,login_at_ws_no,null,null,null,privilege_type);

					if(!strOutput.equals("Y"))
						commit_flag = false;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@review - 142: @ audit log "+e);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@reviewCN-3:"+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
					con.rollback();
			}
			catch(Exception e)
			{
				sb.append("<br>Exception@review- 143:"+e);

				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					message.clear();
					if(pstmt!=null) pstmt.close();
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}catch(Exception e){}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ; //[Bru-HIMS-CRF-024] IN041643
		return results ;
	} // end of reviewRecClinicalNotes

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap modifyRecClinicalNotes(java.util.Properties jdbc_props, java.util.HashMap htRecClinicalNotes, webbeans.eCA.RecClinicalNotesSectionBean	sectionBean,webbeans.eCA.XMLtoHTML converter)
	{

		System.out.println("~~~~~~~~EJB modifyRecClinicalNotes~~~~~~~~");
		System.out.println(htRecClinicalNotes.toString());
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;
		PreparedStatement	pstmt1		=	null;
		CallableStatement	cspreAmend	=	null;

		ResultSet			rs		=	null;
		ResultSet			rs1		=	null;
		ResultSet			rs2		=	null;  //[IN038614]
		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;
		//StringBuffer	sql	= new StringBuffer();

		String	clinician_id				=	"",		strOutput					=	"N";
		String	facility_id					=	"",		accession_num				=	"";
		String	event_status				=	"",		locale						=	"";
		String	sys_date_time				=	"",		login_user_id				=	"";
		String	query_note_content			=	"",		login_at_ws_no				=	"";
		String  resp_id						=	"",		action_comment				=	"";
		String  operation_mode				=	"";
		String  patient_id					=	"",		encounter_id				=	"";
		String  authorized_by_id			=	"" ;
		String  record_mode					=	"";
		String	srl_no						=	"";
		/*************ADDED BY Deepa on 5/25/2009 for IN010603******************/
		String privilege_type = "";
		//String action_type = "";

		boolean result						=	false,	commit_flag					=	true;
		//int		update_result		=	0;
		int		insert_result				=	0;

		MessageManager			mm			=	null;
		java.util.Hashtable		message		=	null;
		PreparedStatement pstmt3 = null;//IN67872 CS		
		PreparedStatement pstmt2 = null;//IN67872 CS
		ResultSet rss = null;//IN67872 CS

		try
		{
			mm						=	new MessageManager();

			clinician_id			=	(String) htRecClinicalNotes.get ( "clinician_id"			);
			facility_id				=	(String) htRecClinicalNotes.get ( "facility_id"				);
			login_user_id			=	(String) htRecClinicalNotes.get ( "login_user_id"			);
			login_at_ws_no			=	(String) htRecClinicalNotes.get ( "login_at_ws_no"			);
			accession_num			=	(String) htRecClinicalNotes.get ( "accession_num"			);
			event_status			=	(String) htRecClinicalNotes.get ( "event_status"			);
			resp_id					=	(String) htRecClinicalNotes.get ( "responsibility_id"		);
			action_comment			=	(String) htRecClinicalNotes.get ( "action_comment"		);
			operation_mode			= 	(String) htRecClinicalNotes.get ( "operation_mode"		);
			locale					= 	(String) htRecClinicalNotes.get ( "LOCALE"		);
			patient_id				=	(String) htRecClinicalNotes.get ( "patient_id"		);
			encounter_id			=	(String) htRecClinicalNotes.get ( "encounter_id"		);

			privilege_type			=	(String) htRecClinicalNotes.get ( "privilege_type"		);
			record_mode				=	(String) htRecClinicalNotes.get ( "record_mode");  
			srl_no					=	(String) htRecClinicalNotes.get ( "srl_no");	

			con			=	ConnectionManager.getConnection(jdbc_props);
			con.setAutoCommit(false);

			//cspreAmend	=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?)}");//IN033881 //Commented for IN060975
			cspreAmend	=	con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,?,?,?)}");//Updated the parameter for IN060975


			try
			{
				query_note_content = "select to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time from dual ";

				try
				{
					pstmt			=	con.prepareStatement(query_note_content);
					rs				=	pstmt.executeQuery();

					if(rs.next())
						sys_date_time		=	rs.getString("sys_date_time");
				}
				catch (Exception eeee)
				{
					eeee.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@modify - 142: "+eeee);
				}
				/*
				try
				{
						String action_qry="select a.ACTION_TYPE from ca_encntr_note_audit_log a where a.ACCESSION_NUM= ? and action_status = 'RQ' and action_by_id = ? and facility_id = ? " ;

						pstmt1 = con.prepareStatement(action_qry);
						pstmt1.setString	(	1,	accession_num	);
						pstmt1.setString	(	2,	clinician_id	);
						pstmt1.setString	(	3,	facility_id		);
						rs1				=	pstmt1.executeQuery();

						if(rs1.next())
						{
							action_type		=	rs1.getString("ACTION_TYPE")==null?"":rs1.getString("ACTION_TYPE");
							
						}

						if(rs1!=null) rs1.close();
						if(pstmt1!=null) pstmt1.close();



						sql.append( " Update ca_encntr_note_audit_log ");
						sql.append( " Set action_date_time = SYSDATE, ");
						sql.append( " action_status='CO',action_by_id=nvl(action_by_id,?), ");
						sql.append( " modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, ");
						sql.append( " modified_facility_id = ?, ");
						sql.append(" PRIVILEGE_TYPE			= ?  ");
						sql.append( " Where action_status = 'RQ' ");
						sql.append( " And action_type in ('RV','RS','FS') ");
						sql.append( " And action_by_id	= ? ");
						sql.append( " And facility_id	= ? ");
						sql.append( " And accession_num	= ? ");

						pstmt1 = con.prepareStatement( sql.toString() );
						pstmt1.setString	(	1,	clinician_id	);
						pstmt1.setString	(	2,	login_user_id	);
						pstmt1.setString	(	3,	login_at_ws_no	);
						pstmt1.setString	(	4,	facility_id		);
						pstmt1.setString	(	5,	privilege_type		);
						pstmt1.setString	(	6,	clinician_id		);
						pstmt1.setString	(	7,	facility_id		);
						pstmt1.setString	(	8,	accession_num	);

						update_result  =  pstmt1.executeUpdate() ;
						pstmt1.clearParameters();

					

					if(update_result==0)
					{
						strOutput ="N";
					}
					else
					{
						strOutput ="Y";
					}




				}
				catch (Exception ee2)
				{
					ee2.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@modify - 141: @ audit log "+ee2);
				}*/


				try
				{
					//if(!action_type.equals("RV")){
					//strOutput ="N";
					strOutput = insertAuditLog(con,facility_id,accession_num,sys_date_time,"RV","CO",clinician_id,login_user_id,login_at_ws_no,null,null,action_comment,privilege_type);

					if(!strOutput.equals("Y"))
						commit_flag = false;
					//}
				}
				catch (Exception ee2)
				{
					ee2.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@modify - 141: @ audit log "+ee2);
				}


				if(strOutput.equals("Y") )
				{
					try
					{
						cspreAmend.setString (1,facility_id);
						cspreAmend.setString (2,accession_num);
						cspreAmend.setString (3,sys_date_time);
						cspreAmend.registerOutParameter (4,Types.VARCHAR);
						cspreAmend.setString (5,"RV"); //Added for IN060975
						cspreAmend.execute();
						strOutput = cspreAmend.getString(4);
					}
					catch (Exception ee2)
					{
						ee2.printStackTrace();
						commit_flag = false;
						sb.append("<br>Exception@modify - 142: "+ee2);
					}

					if(!strOutput.equals("Y") )
						commit_flag = false;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@modify - 143: @ audit log"+e);
			}
			finally
			{
				try
				{
					if(rs!=null) rs.close();
					if(rs1!=null) rs1.close();
					if(pstmt!=null) pstmt.close();
					if(pstmt1!=null) pstmt1.close();
					if(cspreAmend!=null) cspreAmend.close();
				}
				catch(Exception e){}
			}

			event_status			=	"5";
			authorized_by_id		=	clinician_id;

			String strKey = "";
			strKey = patient_id + "~"+encounter_id;
			strKey = strKey.trim();

			sectionBean.getPatientSection(strKey);			


			if(strOutput.equals("Y"))
			{
				try
				{
					if(operation_mode.equals("ModifyAddendum") )
					{
						insert_result = 0;

						//String addendumText = sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*")==null?"":sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");//Checkstyle

						//IN033677,starts
						Properties l_prop_sections = (Properties)sectionBean.getPatientSection(strKey);
						java.util.Enumeration em = l_prop_sections.propertyNames();
						String main_sec = "";
						String sub_sec = "";

						while (em.hasMoreElements())
						{
							String sectionContent =(String) em.nextElement();


							StringTokenizer l_str_token = new StringTokenizer(sectionContent,"~~");
						
							while(l_str_token.hasMoreTokens())
							{
								main_sec = l_str_token.nextToken();
								sub_sec = l_str_token.nextToken();
							}

							srl_no = "";
							String addendumText1 = sectionBean.getAddendumText(main_sec,sub_sec)==null?"":sectionBean.getAddendumText(main_sec,sub_sec);
							

							//}

							//Dinesh T on 9/12/2012
							
							//IN033677,starts
							if(addendumText1.equals("<ADDRESS>&nbsp;</ADDRESS>"))
								addendumText1 = "";
							//IN033677,ends

							if(!addendumText1.equals(""))//IN033677
							{
								//addendumText1 = addendumText1.replace("<ADDRESS>","");
								//addendumText1 = addendumText1.replace("</ADDRESS>","");

								//[IN033677] Start
								//String insertAmmendTable="insert into ca_encntr_note_addendum(FACILITY_ID,ACCESSION_NUM,SRL_NO,ADDENDUM_TEXT,PRACTITIONER_ID,RESP_ID,ADDENDUM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)  values(?,?,(select count(*) from ca_encntr_note_addendum where FACILITY_ID=? and ACCESSION_NUM=?),?,?,?,sysdate,?,sysdate,?,?,?,sysdate,?,?)";   

								//IN03367,starts
								String selectQry="SELECT max(srl_no) max_no FROM ca_encntr_note_addendum where ACCESSION_NUM=? and ADDENDUM_STATUS='R' and SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?";
									
								//PreparedStatement pstmt2 = con.prepareStatement(selectQry);//IN67872 CS
								pstmt2 = con.prepareStatement(selectQry);//IN67872 CS
								pstmt2.setString(1,accession_num);
								pstmt2.setString(2,main_sec);
								pstmt2.setString(3,sub_sec);
								
								//ResultSet rss = pstmt2.executeQuery();//IN67872 CS
								rss = pstmt2.executeQuery();//IN67872 CS
								srl_no ="";

								while(rss.next())
								{
									srl_no = rss.getString("max_no");
								}

								srl_no = srl_no==null?"":srl_no;
								boolean statemtExecute =false;

								//IN033677,ends
								if("".equals(srl_no))
								{
									//String insertAmmendTable="insert into ca_encntr_note_addendum(FACILITY_ID,ACCESSION_NUM,SRL_NO,ADDENDUM_TEXT,PRACTITIONER_ID,RESP_ID,ADDENDUM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDENDUM_STATUS,MODIFIED_PRACT_ID)  values(?,?,(select count(*) from ca_encntr_note_addendum where FACILITY_ID=? and ACCESSION_NUM=?),?,?,?,sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?)";//IN033677
									//IN067862 Start.
									//String insertAmmendTable="insert into ca_encntr_note_addendum(FACILITY_ID,ACCESSION_NUM,SRL_NO,ADDENDUM_TEXT,PRACTITIONER_ID,RESP_ID,ADDENDUM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDENDUM_STATUS,MODIFIED_PRACT_ID,SEC_HDG_CODE,SUBSEC_HDG_CODE)  values(?,?,(select TO_NUMBER (nvl(max (srl_no),'0'))+1 from ca_encntr_note_addendum where FACILITY_ID=? and ACCESSION_NUM=? and SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?),?,?,?,sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)";//IN033677
									String insertAmmendTable="insert into ca_encntr_note_addendum(FACILITY_ID,ACCESSION_NUM,SRL_NO,ADDENDUM_TEXT,PRACTITIONER_ID,RESP_ID,ADDENDUM_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ADDENDUM_STATUS,MODIFIED_PRACT_ID,SEC_HDG_CODE,SUBSEC_HDG_CODE,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE)  values(?,?,(select TO_NUMBER (nvl(max (srl_no),'0'))+1 from ca_encntr_note_addendum where FACILITY_ID=? and ACCESSION_NUM=? and SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?),?,?,?,sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?)";//IN033677
									//IN067862 End.
									pstmt = con.prepareStatement(insertAmmendTable);
									pstmt.setString(1,facility_id);
									pstmt.setString(2,accession_num);
									pstmt.setString(3,facility_id);
									pstmt.setString(4,accession_num);
									pstmt.setString(5,main_sec);//IN033677
									pstmt.setString(6,sub_sec);//IN033677
									//IN067862 Start.
									//pstmt.setString(7,addendumText1);	
									pstmt.setString(7," ");	
									//IN067862 end.									
									pstmt.setString(8,clinician_id);
									pstmt.setString(9,resp_id);
									pstmt.setString(10,login_user_id);
									pstmt.setString(11,login_at_ws_no);
									pstmt.setString(12,facility_id);
									pstmt.setString(13,login_user_id);
									pstmt.setString(14,login_at_ws_no);
									pstmt.setString(15,facility_id);
									if("RecordAddendum".equals(record_mode))
										pstmt.setString(16,"R");
									else if("SignAddendum".equals(record_mode))
										pstmt.setString(16,"S");
									pstmt.setString(17,clinician_id);
									pstmt.setString(18,main_sec);//IN033677
									pstmt.setString(19,sub_sec);//IN033677
									//IN067862 Start.
									Clob clobContent = stringToClob(addendumText1, con);
									pstmt.setClob(20, clobContent);
									pstmt.setString(21,"CLOB");
									//IN067862 end.									

									statemtExecute=true;
								}
								else
								{					
									//[IN038614] Start.
									//PreparedStatement pstmt3=con.prepareStatement("SELECT ADDENDUM_TEXT FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? and addendum_status='R'");//IN67872 CS
									//IN067862 Start.
									//pstmt3=con.prepareStatement("SELECT ADDENDUM_TEXT FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? and addendum_status='R'");//IN67872 CS
									pstmt3=con.prepareStatement("SELECT ADDENDUM_TEXT,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? and addendum_status='R'");//IN67872 CS
									//IN067862 End.
									pstmt3.setString(1,accession_num);
									pstmt3.setString(2,main_sec);
									pstmt3.setString(3,sub_sec);
									rs2=pstmt3.executeQuery();
									String addendumTextTemp_="";
									String addendumStorageType=""; //IN067862
									while(rs2.next()){
										//IN067862 Start.
										addendumStorageType = rs2.getString("ADDENDUM_STORAGE_TYPE")==null?"":(String)rs2.getString("ADDENDUM_STORAGE_TYPE");
										if("CLOB".equals(addendumStorageType)){
											addendumTextTemp_ = (String)rs2.getString("ADDENDUM_CLOB");
										}else
											addendumTextTemp_ = (String)rs2.getString("ADDENDUM_TEXT");
										//IN067862 End.
									}
									if(pstmt3!=null)pstmt3.close();
									if(rs2!=null)rs2.close();
									//[IN038614] End.									
									if(!addendumText1.equals(addendumTextTemp_)){
									//IN067862 Start.
									//String updateAmmendTable ="UPDATE CA_ENCNTR_NOTE_ADDENDUM SET ADDENDUM_TEXT=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ADDENDUM_STATUS=?,MODIFIED_PRACT_ID=?,practitioner_id=? WHERE ACCESSION_NUM=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? and addendum_status='R'";
									  String updateAmmendTable ="UPDATE CA_ENCNTR_NOTE_ADDENDUM SET ADDENDUM_TEXT=?,ADDENDUM_CLOB=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ADDENDUM_STATUS=?,MODIFIED_PRACT_ID=?,practitioner_id=?,ADDENDUM_STORAGE_TYPE = ? WHERE ACCESSION_NUM=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ?  and addendum_status='R'";
									//IN067862 End.
									pstmt = con.prepareStatement(updateAmmendTable);
									//IN067862 Start.
									pstmt.setString(1," ");									
									Clob clobContent = stringToClob(addendumText1, con);
									pstmt.setClob(2, clobContent);
									//IN067862 end.
									pstmt.setString(3,login_user_id);
									pstmt.setString(4,login_at_ws_no);
									pstmt.setString(5,facility_id);
									if("RecordAddendum".equals(record_mode))
										pstmt.setString(6,"R");
									else if("SignAddendum".equals(record_mode))
										pstmt.setString(6,"S");
									pstmt.setString(7,clinician_id);
									pstmt.setString(8,clinician_id);//DineshT on 7/30/2012
									pstmt.setString(9,"CLOB"); //IN067862
									pstmt.setString(10,accession_num);
									pstmt.setString(11,main_sec);//IN033677
									pstmt.setString(12,sub_sec);//IN033677
									
										statemtExecute=true;
									}
								}
								//[IN033677] End
								if(statemtExecute)
								{
									try
									{
										insert_result = pstmt.executeUpdate();
									}
									catch (Exception eTest)
									{
										eTest.printStackTrace();
										commit_flag = false;
										sb.append("<br>Exception@modify - 144: "+eTest);
									}
									finally//IN67872 CS, starts
									{
										if(rss!=null)
											rss.close();
										if(pstmt!=null)
											pstmt.close();
										if(pstmt2!=null)
											pstmt2.close();
									}//IN67872 CS, ends
								}								
							}//IN033677
							else
								insert_result = 1;
						}
					}
					else
						insert_result = 1;

					htRecClinicalNotes.put(	"event_status",			event_status			);
					htRecClinicalNotes.put(	"authorized_by_id",		authorized_by_id		);

					boolean record_status = false;
					java.util.HashMap record_results = new HashMap();


					if(insert_result > 0 )
					{
						record_results	=	(HashMap) processTables(con,jdbc_props, htRecClinicalNotes, sectionBean, converter,"N");
						record_status	=	((Boolean)record_results.get("status")).booleanValue();
					}
					else
						record_status = false;


					if(!(record_status))
					{
						sb.append((String)record_results.get("error"));
						commit_flag = false;
					}

					record_results.clear();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@modify - 144: "+e);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@modify - 145: "+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
				{
					result = false ;
					message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.delete(0,sb.length());
					sb.append( (String) message.get("message") ) ;
					con.rollback();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@modify - 146: "+e);

				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					message.clear();
					if(pstmt!=null) pstmt.close();
					//IN67872 CS, starts
					if(rss!=null)
						rss.close();
					if(pstmt3!=null) 
						pstmt3.close();
					//IN67872 CS, ends
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}catch(Exception e){}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ; //[Bru-HIMS-CRF-024] IN041643
		return results ;
	} // end of modifyRecClinicalNotes

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap deleteRecClinicalNotes(java.util.Properties jdbc_props, java.util.HashMap htRecClinicalNotes)
	{
		System.out.println("~~~~~~~~EJB deleteRecClinicalNotes~~~~~~~~");
		System.out.println(htRecClinicalNotes.toString());
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;

		java.util.HashMap results	=	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		String	facility_id			=	"",		accession_num		=	"";
		String	note_type			=	"",		doc_linked_note_yn	=	"";
		String  locale				=	"";

		boolean result				=	false,	commit_flag		=	true;

		MessageManager		mm		=	null;
		java.util.Hashtable	message	=	null;

		try
		{
			mm						=	new MessageManager();

			facility_id				=	(String) htRecClinicalNotes.get ( "facility_id"		);
			accession_num			=	(String) htRecClinicalNotes.get ( "accession_num"	);
			note_type				=	(String) htRecClinicalNotes.get ( "note_type"	);
			doc_linked_note_yn		=	(String) htRecClinicalNotes.get ( "doc_linked_note_yn"	);
			locale					=	(String) htRecClinicalNotes.get ( "LOCALE"	);

			con		=	ConnectionManager.getConnection(jdbc_props);

			con.setAutoCommit(false);

			String delete_ca_encntr_note_sec_expl = "delete ca_encntr_note_section_obj where operating_facility_id = ? and accession_num = ? ";

			pstmt	=	con.prepareStatement(delete_ca_encntr_note_sec_expl);

			pstmt.setString	(1,	facility_id		);
			pstmt.setString	(2,	accession_num	);

			pstmt.executeUpdate();

			if ( pstmt != null)
				pstmt.close();

			String delete_ca_encntr_note_audit_log = "delete ca_encntr_note_audit_log where facility_id = ? and accession_num = ? ";

			pstmt	=	con.prepareStatement(delete_ca_encntr_note_audit_log);

			pstmt.setString	(1,	facility_id		);
			pstmt.setString	(2,	accession_num	);

			 pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();

			String delete_ca_encntr_note_sec_CC = "delete CA_ENCNTR_NOTE_SEC_COMPLAINT where facility_id = ? and accession_num = ? ";

			pstmt	=	con.prepareStatement(delete_ca_encntr_note_sec_CC);

			pstmt.setString	(1,	facility_id		);
			pstmt.setString	(2,	accession_num	);

			 pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();

			String delete_ca_encntr_note_section = "delete ca_encntr_note_section where facility_id = ? and accession_num = ? ";

			pstmt	=	con.prepareStatement(delete_ca_encntr_note_section);

			pstmt.setString	(1,	facility_id		);
			pstmt.setString	(2,	accession_num	);

			 pstmt.executeUpdate();

			if(pstmt!=null) pstmt.close();

			String delete_ca_encntr_note = "delete ca_encntr_note where facility_id = ? and accession_num = ? ";

			pstmt	=	con.prepareStatement(delete_ca_encntr_note);

			pstmt.setString	(1,	facility_id		);
			pstmt.setString	(2,	accession_num	);

			pstmt.executeUpdate();

			if(pstmt!=null)
				pstmt.close();

			if(doc_linked_note_yn.equals("Y"))
			{
				String delete_cr_encntr_detail_obj = "delete cr_encounter_detail_obj where HIST_REC_TYPE = ? and CONTR_SYS_ID = ? and  ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? ";
				pstmt	=	con.prepareStatement(delete_cr_encntr_detail_obj);

				pstmt.setString	(1,	"CLNT"	);
				pstmt.setString	(2,	"CA"	);
				pstmt.setString	(3,	accession_num	);
				pstmt.setString	(4,	note_type	);
				pstmt.executeUpdate();

				if(pstmt!=null)
					pstmt.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@delete - 161: "+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					message = mm.getMessage( locale, "RECORD_DELETED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
					con.rollback();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@deleteCN-2: "+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					message.clear();
					if(pstmt!=null) pstmt.close();
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}catch(Exception e){}
			} // end of finally
		} // end of finally

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ; //[Bru-HIMS-CRF-024] IN041643.
		return results ;
	} // end of deleteRecClinicalNotes

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap errorRecClinicalNotes(java.util.Properties	jdbc_props, java.util.HashMap htRecClinicalNotes)
	{
		System.out.println("~~~~~~~~EJB errorRecClinicalNotes~~~~~~~~");
		System.out.println(htRecClinicalNotes.toString());
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuffer		sb		=	new StringBuffer( "" ) ;

		String	clinician_id		=	"",		action_comment		=	"";
		String	facility_id			=	"",		accession_num		=	"";
		String	login_user_id		=	"",		login_at_ws_no		=	"";
		String  strOutput			=	"N",	locale				=	"";
		/*************ADDED BY Deepa on 5/25/2009 for IN010603******************/
		String privilege_type = "";

		boolean result				=	false,	commit_flag			=	true;
		int		update_result		=	0;

		MessageManager		mm		=	null;
		java.util.Hashtable	message	=	null;

		try
		{
			mm						=	new MessageManager();

			clinician_id			=	(String) htRecClinicalNotes.get ( "clinician_id"			);
			action_comment			=	(String) htRecClinicalNotes.get ( "action_comment"			);
			facility_id				=	(String) htRecClinicalNotes.get ( "facility_id"				);
			accession_num			=	(String) htRecClinicalNotes.get ( "accession_num"			);
			login_user_id			=	(String) htRecClinicalNotes.get ( "login_user_id"			);
			login_at_ws_no			=	(String) htRecClinicalNotes.get ( "login_at_ws_no"			);
			locale					=	(String) htRecClinicalNotes.get ( "LOCALE"			);
			privilege_type					=	(String) htRecClinicalNotes.get ( "privilege_type"			);

			con		=	ConnectionManager.getConnection(jdbc_props);

			con.setAutoCommit(false);

			try
			{
				//String update_ca_encntr_note = "update ca_encntr_note set event_status_caption = 'In Error',  event_status = '9', marked_in_error_by_id = ?, marked_in_error_date_time = SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and accession_num = ? ";
				String update_ca_encntr_note = "update ca_encntr_note set event_status_caption = 'In Error',  event_status = '9', marked_in_error_by_id = ?, marked_in_error_date_time = SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where /*facility_id = ? and */accession_num = ? ";//IN034910

				pstmt	=	con.prepareStatement(update_ca_encntr_note);

				pstmt.setString	(1,	clinician_id	);
				pstmt.setString	(2,	login_user_id	);
				pstmt.setString	(3,	login_at_ws_no	);
				pstmt.setString	(4,	facility_id		);
				//pstmt.setString	(5,	facility_id		);//IN034910
				pstmt.setString	(5,	accession_num	);//IN034910

				update_result = pstmt.executeUpdate();

				if( update_result <= 0 )	commit_flag	= false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@error - 181: "+e);
			}
			finally
			{
				try
				{
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e){}
			}

			if(commit_flag)
			{
				try
				{
					strOutput ="N";
					strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","ER","CO",clinician_id,login_user_id,login_at_ws_no,null,null,action_comment,privilege_type);

					if(!strOutput.equals("Y"))
						commit_flag = false;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@error - 182: @ audit log"+e);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@error - 183: "+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					message = mm.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
					con.rollback();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@error - 184: "+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {}
			}
			finally
			{
				try
				{
					message.clear();
					if(pstmt!=null) pstmt.close();
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}
				catch(Exception e){}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ; //[Bru-HIMS-CRF-024] IN041643
		return results ;
	} // end of errorRecClinicalNotes

	private String getPrivilegeType(Connection con,String resp_id, String note_type, String Appluser)
	{
		PreparedStatement pstmt = null;
		ResultSet rsPri = null;

		String privilege_type ="1";
		String qry_for_privilagetype = "";

		try
		{
			//IN056951 starts
			//qry_for_privilagetype = "select max(privilege_type) from ca_note_type_for_resp where resp_id in (select RESP_ID from sm_resp_for_user where APPL_USER_ID=?) and note_type = ? and privilege_type<='4' ";
			qry_for_privilagetype = "select max(privilege_type) from ca_note_type_for_resp where resp_id in (select RESP_ID from sm_resp_for_user where APPL_USER_ID=? and resp_id = ? ) and note_type = ? and privilege_type<='4'  ";
			//IN056951 ends
			pstmt = con.prepareStatement(qry_for_privilagetype);

			pstmt.setString(1,Appluser);
			pstmt.setString(2,resp_id);//IN056951
			pstmt.setString(3,note_type);



			rsPri = pstmt.executeQuery();

			if(rsPri.next())
				privilege_type = rsPri.getString(1)==null?"1":rsPri.getString(1);
		}
		catch (Exception ePri)
		{
			ePri.printStackTrace();
			sb.append("<br>Exception@Getting Privilege Type "+ePri);
		}
		finally
		{
			try
			{
				if(rsPri != null) rsPri.close();
				if(pstmt != null) pstmt.close();
			}
			catch (Exception eP)
			{}
		}

		return privilege_type;
	}

	private String insertAuditLog(Connection con, String facility_id, String accession_num, String event_date_time, String action_type, String action_status,String performed_by_id, String login_user_id, String login_at_ws_no, String request_by_id,String request_datetime,String action_comment, String privilege_type)
	{
		CallableStatement csAuditLog = null;
		String strOutput = "N";

		try
		{
			csAuditLog = con.prepareCall("{call CA_NOTE_AUDIT_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			csAuditLog.setString	(	1,	facility_id				);
			csAuditLog.setString	(	2,	accession_num			);
			csAuditLog.setString	(	3,	event_date_time			);
			csAuditLog.setString	(	4,	action_type				);
			csAuditLog.setString	(	5,	action_status			);
			csAuditLog.setString	(	6,	performed_by_id			);
			csAuditLog.setString	(	7,	login_user_id			);
			csAuditLog.setString	(	8,	login_at_ws_no			);
			csAuditLog.setString	(	9,	facility_id				);
			csAuditLog.setString	(	10,	login_user_id			);
			csAuditLog.setString	(	11,	login_at_ws_no			);
			csAuditLog.setString	(	12,	facility_id				);
			csAuditLog.setString	(	13,	request_by_id			);
			csAuditLog.setString	(	14,	request_datetime		);
			csAuditLog.setString	(	15,	action_comment			);
			csAuditLog.registerOutParameter	(	16,	Types.VARCHAR);
			csAuditLog.setString	(	17,	privilege_type			);

			csAuditLog.execute();

			strOutput = csAuditLog.getString(16);
			csAuditLog.clearParameters();
		}
		catch (Exception eAuditLog)
		{
			eAuditLog.printStackTrace();
			sb.append("<br>Exception@Inserting Audit Log "+eAuditLog);
		}
		finally
		{
			try
			{
				if (csAuditLog != null) csAuditLog.close();
			}
			catch (Exception eee)	{}
		}

		return strOutput;
	}

	private String insertAuditLog(Connection con, String facility_id, String accession_num, String event_date_time, String action_type, String action_status,String performed_by_id, String login_user_id, String login_at_ws_no, String request_by_id,String request_datetime,String action_comment, String privilege_type,String action_by_type,String forwarded_clinician_id,String forwardToFac)//IN037675
	{
		CallableStatement csAuditLog = null;
		String strOutput = "N";

		try
		{
			csAuditLog = con.prepareCall("{call CA_NOTE_AUDIT_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			csAuditLog.setString	(	1,	facility_id				);
			csAuditLog.setString	(	2,	accession_num			);
			csAuditLog.setString	(	3,	event_date_time			);
			csAuditLog.setString	(	4,	action_type				);
			csAuditLog.setString	(	5,	action_status			);
			csAuditLog.setString	(	6,	performed_by_id			);
			csAuditLog.setString	(	7,	login_user_id			);
			csAuditLog.setString	(	8,	login_at_ws_no			);
			csAuditLog.setString	(	9,	facility_id				);
			csAuditLog.setString	(	10,	login_user_id			);
			csAuditLog.setString	(	11,	login_at_ws_no			);
			csAuditLog.setString	(	12,	facility_id				);
			csAuditLog.setString	(	13,	request_by_id			);
			csAuditLog.setString	(	14,	request_datetime		);
			csAuditLog.setString	(	15,	action_comment			);
			csAuditLog.registerOutParameter	(	16,	Types.VARCHAR);
			csAuditLog.setString	(	17,	privilege_type			);
			csAuditLog.setString	(	18,	action_by_type			);
			csAuditLog.setString	(	19,	forwarded_clinician_id	);
			csAuditLog.setString	(	20,	forwardToFac	);//IN037675

			csAuditLog.execute();

			strOutput = csAuditLog.getString(16);
			csAuditLog.clearParameters();
		}
		catch (Exception eAuditLog)
		{
			eAuditLog.printStackTrace();
			sb.append("<br>Exception@Inserting Audit Log "+eAuditLog);
		}
		finally
		{
			try
			{
				if (csAuditLog != null) csAuditLog.close();
			}
			catch (Exception eee)	{}
		}

		return strOutput;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null || inputString.equals(""))	?	defaultValue	:	inputString;
	}

	private String replaceNewLine(String input)
	{
		/* [IN032064] Start
		if(input.indexOf(" ")!=-1)
			input = input.replaceAll(" ","&nbsp;");
		
		[IN032064] End */
		//input = input.replaceAll("\n","<br>");  [IN032683]
		//input = input.replaceAll("<ADDRESS>",""); 
		//input = input.replaceAll("</ADDRESS>",""); 
		return input;
	}

	//private boolean caBuildNotes(webbeans.eCA.XMLtoHTML converter,String facilityId, String accessionNum, webbeans.eCA.RecClinicalNotesSectionBean sectionBean,Connection con, String locale,java.util.HashMap htRecClinicalNotes)//IN029312
	//private boolean caBuildNotes(webbeans.eCA.XMLtoHTML converter,String facilityId, String accessionNum, webbeans.eCA.RecClinicalNotesSectionBean sectionBean,Connection con, String locale)//IN033677
	//private boolean caBuildNotes(webbeans.eCA.XMLtoHTML converter,String facilityId, String accessionNum, webbeans.eCA.RecClinicalNotesSectionBean sectionBean,Connection con, String locale,java.util.HashMap htRecClinicalNotes)//IN033677
	//private boolean caBuildNotes(webbeans.eCA.XMLtoHTML converter,String facilityId, String accessionNum, webbeans.eCA.RecClinicalNotesSectionBean sectionBean,Connection con, String locale,java.util.HashMap htRecClinicalNotes, String patient_id, String encounter_id, String contr_mod_accession_num)//IN041827//Commented for IN068105
	//private boolean caBuildNotes(webbeans.eCA.XMLtoHTML converter,String facilityId, String accessionNum, webbeans.eCA.RecClinicalNotesSectionBean sectionBean,Connection con, String locale,java.util.HashMap htRecClinicalNotes, String patient_id, String encounter_id, String contr_mod_accession_num,String noteCopiedYN)//Modified for IN068105//IN072879
	  private boolean caBuildNotes(webbeans.eCA.XMLtoHTML converter,String facilityId, String accessionNum, webbeans.eCA.RecClinicalNotesSectionBean sectionBean,Connection con, String locale,java.util.HashMap htRecClinicalNotes, String patient_id, String encounter_id, String contr_mod_accession_num,String noteCopiedYN,String sexValue,String location_code,String speciality_name)//Modified for IN072879
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;//7605
		ResultSet rs1 = null;//7605

		Hashtable htParameter=new Hashtable();
		eCA.HeaderDomParser parser = new eCA.HeaderDomParser();

		if(locale.equals("") )
			locale ="en";

		StringBuffer noteContent = new StringBuffer();
		StringBuffer sectionContentUpdatedXML=new StringBuffer();

		String image_linked_yn		= "";

		String sectionContentType		= "",headerSection = "",prevHeaderSection = "",subSecHdg = "";
		String childSectionContentType  = "",secHdgCode="",subSecHdgCode="";

		String sectionContent			= "";
		String sectionContentTemp		= ""; //[IN039227]
		String section_image_content	= "";
		String section_image_height		= ""; //IN053298
		String preserve_format_yn		= "";
		//String noteTitle				= "";
		//String event_title_caption		= "";
		String note_type ="";
		String section_content ="";
		String note_header_code ="";
		//String footer_code ="";//IN029312
		String doc_ref_id ="";
		String event_date_time ="";
		String note_title ="";
		String output_yn ="";
		String secHdgCode_out ="";
		String subSecHdgCode_out ="";
		String med_service ="";
		String performing_phy_name ="";
		String record_mode = "";//IN033677
		String clinician_name = "";//IN033677
		String practitioner_name = ""; //[IN038614]
		String note_type_desc="";//IN071865
		String prev_note_type_desc="";//IN073100
		String display_note_description="";//7605
		String compressNoteContentYN = "N"; //6484
		//IN029312 Starts
		/*String facility_name="";
		String last_amended_by="";
		String authorized_by="";
		String pract_sign = "";
		String	printDateTime =	"";
		String report_header_code =	"";
		String visit_adm_date="";
		String episode_type="";
		String location_name="";
		String attending_practitioner="";
		String admitting_practitioner="";
		String bed_number="";
		String speciality_name="";
		String dischargeDateTime="";
		String clinician_id ="";
		String patient_id ="";
		String patient_class ="";
		String encounter_id ="";
		String patient_gender ="";
		String patient_name ="";
		String patient_age ="";
		String strPatInfoQuery ="";
		String section_content_rpt ="";*/
		//IN029312 Ends
	//	oracle.sql.CLOB l_notes_clob = null; //IN069251 //Commed for CheckStyle
		
		try
		{
			//Dinesh T on 9/16/2012,starts
			record_mode				=	(String) htRecClinicalNotes.get ( "record_mode");//IN033677
			clinician_name				=	(String) htRecClinicalNotes.get ( "clinician_name");//IN033677
			//Dinesh T on 9/16/2012,ends
			//7605 STARTS
			String disp_noteDesc ="select DISP_NOTE_DESC,COMPRESS_NOTE_CONTENT_YN  from ca_note_param";
			
			pstmt1	= con.prepareStatement(disp_noteDesc);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){	
				display_note_description   = rs1.getString("DISP_NOTE_DESC")==null?"":rs1.getString("DISP_NOTE_DESC");
				compressNoteContentYN   = rs1.getString("COMPRESS_NOTE_CONTENT_YN")==null?"N":rs1.getString("COMPRESS_NOTE_CONTENT_YN");
			}//Exception-PMG2020-COMN-CRF-0085 7605 ends
			System.out.println("RecClinicalNotesManager.java--------------compressNoteContentYN----->"+compressNoteContentYN);
			//IN029312 Starts
			/*patient_id					=	(String) htRecClinicalNotes.get ( "patient_id"				);
			patient_class				=	(String) htRecClinicalNotes.get ( "patient_class"			);
			encounter_id				=	(String) htRecClinicalNotes.get ( "encounter_id"			);
			clinician_id				=	(String) htRecClinicalNotes.get ( "clinician_id"			);
			*/
			//IN029312 Ends
			//String qry0 = "SELECT a.Event_type_caption,a.Event_date_caption,a.Event_title_caption, 		replace(CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1'),'''','') note_type_desc, TO_CHAR(a.Event_date_time,'dd/mm/yyyy hh24:mi') event_date_time ,a.Event_title_desc, replace(AM_GET_DESC.AM_SERVICE(a.service_code,?,'2'),'''','') service_desc,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') phy_prov_name, a.Event_perf_by_caption event_pref_by_caption,a.event_class,a.event_status_caption FROM Ca_encntr_note a WHERE  a.facility_id = ? AND a.Accession_num = ?";
			//String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH:MI') EVENT_DATE_TIME,a.Event_title_desc note_title FROM Ca_encntr_note a WHERE  a.facility_id = ? AND a.Accession_num = ?";
			//IN029312 Starts
			//String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME,a.Event_title_desc note_title ,am_get_desc.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performing_phy_name,am_get_desc.AM_SERVICE(a.SERVICE_CODE,?,2) med_service FROM Ca_encntr_note a WHERE  /*a.facility_id = ? AND */ a.Accession_num = ?";//Commented for IN068105
			//String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME,a.Event_title_desc note_title ,am_get_desc.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performing_phy_name,am_get_desc.AM_SERVICE(a.SERVICE_CODE,?,2) med_service, AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,1) AUTHORIZED_BY_ID, AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,1)  LAST_AMENDED_BY_ID FROM Ca_encntr_note a WHERE  a.facility_id = ? AND a.Accession_num = ? ";
			String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME,a.Event_title_desc note_title ,am_get_desc.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performing_phy_name,am_get_desc.AM_SERVICE(a.SERVICE_CODE,?,2) med_service,NOTES_COPIED_YN FROM Ca_encntr_note a WHERE  /*a.facility_id = ? AND */ a.Accession_num = ?";//modified for IN068105
			
			//IN029312 Ends
			try
			{
				pstmt = con.prepareStatement(qry0);
				//pstmt.setString(1,locale);
				//pstmt.setString(2,locale);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				//pstmt.setString(3,locale); //IN029312
				//pstmt.setString(4,locale); //IN029312
				//pstmt.setString(3,facilityId); //IN029312
				pstmt.setString(3,accessionNum); //IN029312
				
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					
					note_type = rs.getString("NOTE_TYPE")==null?"":rs.getString("NOTE_TYPE");
					doc_ref_id = rs.getString("DOC_REF_ID")==null?"":rs.getString("DOC_REF_ID");
					event_date_time = rs.getString("EVENT_DATE_TIME")==null?"":rs.getString("EVENT_DATE_TIME");
					note_title = rs.getString("note_title")==null?"":rs.getString("note_title");
					performing_phy_name = rs.getString("performing_phy_name")==null?"":rs.getString("performing_phy_name");
					med_service = rs.getString("med_service")==null?"":rs.getString("med_service");
					//IN068105 starts
					if(noteCopiedYN.equals("N"))
						noteCopiedYN = rs.getString("NOTES_COPIED_YN")==null?"N":rs.getString("NOTES_COPIED_YN");
					//IN068105 ends
					//authorized_by =	rs.getString("AUTHORIZED_BY_ID")==null?"":rs.getString("AUTHORIZED_BY_ID");//IN029312
					//last_amended_by	= rs.getString("LAST_AMENDED_BY_ID")==null?"":rs.getString("LAST_AMENDED_BY_ID");//IN029312

					//event_title_caption = rs.getString("event_title_caption")==null?"":rs.getString("event_title_caption");

					//noteContent.append("<HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border=0 cellspacing=0 width=auto width='100%' style=\"font-family:Verdana;font-size:9pt\"><tr><td width=10% nowrap> <B>  "+rs.getString("event_type_caption")+"  </B></td><td width=70% nowrap><b> &nbsp;: </b> "+ rs.getString("note_type_desc")+" </td><td width=10% align=right nowrap><b> Med/Anc Service </B></td><td width=10% nowrap> <b> &nbsp;: </b>  "+rs.getString("service_desc") +"</td></tr><tr><td width=10% nowrap> <B>   "+rs.getString("event_date_caption")+"   </B></td><td width=70% nowrap><b> &nbsp;: </b>  "+rs.getString("event_date_time")+" </td><td width=10% align=right nowrap><b> "+rs.getString("event_pref_by_caption")+" </B></td><td width=10% nowrap> <b> &nbsp;: </b>  "+rs.getString("phy_prov_name")+" </td></tr>");
					//noteContent.append("<HTML><HEAD><TITLE></TITLE> </HEAD><BODY> <br><hr>");

					/*if(!noteTitle.equals(""))
						noteContent.append("<tr><td width=10%> <b>   "+event_title_caption+"  </b></td><td width=90% colspan=3><b> &nbsp;: </b>  "+noteTitle+" </td></tr></table><br><hr>");
					else
						noteContent.append("</table><br><hr>");*/
				}
				
			}
			catch (Exception eeF1)
			{
				eeF1.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20 : "+eeF1);
				return false;
			}
			finally
			{
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();
			}
			/*
			//IN029312 Starts
			//String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME,a.Event_title_desc note_title ,am_get_desc.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performing_phy_name,am_get_desc.AM_SERVICE(a.SERVICE_CODE,?,2) med_service FROM Ca_encntr_note a WHERE  a.facility_id = ? AND a.Accession_num = ?";
			
			String qry2 = "SELECT 	SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name,to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT    a.practitioner_name || CHR (13)|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || b.position_desc  || NVL2 ( b.position_desc, CHR (13), '' )|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)  || credential_id1  || NVL2 (credential_id1, ', ', '') || credential_id2 || NVL2 (credential_id2, ', ', '')|| credential_id3 || NVL2 (   credential_id1|| credential_id2|| credential_id3,CHR (13),'')|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || DEGREE pract_with_pos_cred_deg FROM am_practitioner a, am_position b WHERE a.position_code = b.position_code AND a.practitioner_id = ? ) pract_sign 	from dual ";
			
			try
			{
				pstmt = con.prepareStatement(qry2);

				pstmt.setString(1,facilityId);
				pstmt.setString(2,locale);
				pstmt.setString(3,clinician_id);
							
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					facility_name	=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
					printDateTime	=	rs.getString("print_date_time") == null ? "" : rs.getString("print_date_time");
					pract_sign		=	rs.getString("pract_sign") == null ? "" : rs.getString("pract_sign");
				}
				else
				{
					facility_name = "";
					printDateTime =	"";
				}
				
			}
			catch (Exception eeF1)
			{
				eeF1.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20 : "+eeF1);
				return false;
			}
			finally
			{
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();
			}
			//IN029312 Ends
			//IN029312 Starts
			if(locale.equals("en"))
			{
				strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_patient where patient_id = ? "; 
			}
			else
			{
				strPatInfoQuery = "select PATIENT_NAME_LOC_LANG patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_patient where patient_id = ? "; 
			}
		
	
			if(!patient_class.equals("XT") )
			{
				try
				{
					pstmt	= con.prepareStatement(strPatInfoQuery);
					pstmt.setString(1,patient_id);

				rs = pstmt.executeQuery();

				if(rs.next() )
				{
					patient_name	= rs.getString("patient_name") == null ? "" : rs.getString("patient_name");
					patient_age		= rs.getString("patient_age") == null ? "" : rs.getString("patient_age");
					patient_gender	= rs.getString("gender") == null ? "" : rs.getString("gender");
					printDateTime	= rs.getString("print_date_time") == null ? "" : rs.getString("print_date_time");

					if(patient_gender.equals("M") )
						patient_gender = "Male";
					else if(patient_gender.equals("F") )
						patient_gender = "Female";
					else
						patient_gender = "Unknown";
					
				}	
				}
				catch (Exception ePP6)
				{

					ePP6.printStackTrace();
				}
				finally
				{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}

				try
				{
					//modified below queries by adding ASSIGN_BED_NUM bed_number for [IN:029839]
					String strPatEncDtlQry	=" Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END LOCN_DESC,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2')    specialty_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME , ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A 	WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?";
					pstmt	= con.prepareStatement(strPatEncDtlQry);
				
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,encounter_id);
					rs = pstmt.executeQuery();
					if(rs.next() )
					{
						visit_adm_date			= rs.getString("ENC_DATE") == null ? "" : rs.getString("ENC_DATE");
						episode_type			= rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
						location_name			= rs.getString("LOCN_DESC") == null ? "" : rs.getString("LOCN_DESC");
						attending_practitioner	= rs.getString("attending_practitioner") == null ? "" : rs.getString("attending_practitioner");
						admitting_practitioner  = rs.getString("admitting_practitioner") == null ? "" : rs.getString("admitting_practitioner");
						bed_number				= rs.getString("bed_number") == null ? "" : rs.getString("bed_number");
						speciality_name			= rs.getString("specialty_name") == null ? "" : rs.getString("specialty_name");
						dischargeDateTime		= rs.getString("DISCHARGE_DATE_TIME") == null ? "" : rs.getString("DISCHARGE_DATE_TIME");
					
					}
			
					if(location_name == null)
						location_name ="";
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
				finally
				{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
			}
			//IN029312 Ends
			*/
			if(!note_type.equals(""))
			{
				try
				{
				    //String head_foot_qry ="select a.NOTE_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";//IN071865
					String head_foot_qry ="select a.NOTE_HEADER_CODE,a.note_type_desc from ca_note_type a where  a.NOTE_TYPE=?";
					//String head_foot_qry ="select a.NOTE_HEADER_CODE,a.footer_code,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";//IN029312//IN071865
					pstmt	= con.prepareStatement(head_foot_qry);
					pstmt.setString(1,note_type);
					rs = pstmt.executeQuery();

						while(rs.next())
						{
							note_header_code = rs.getString("NOTE_HEADER_CODE")==null?"":rs.getString("NOTE_HEADER_CODE");
							note_type_desc   = rs.getString("NOTE_TYPE_DESC")==null?"":rs.getString("NOTE_TYPE_DESC");//IN071865
							//footer_code = rs.getString("footer_code")==null?"":rs.getString("footer_code");
							//report_header_code = rs.getString("REPORT_HEADER_CODE")==null?"":rs.getString("REPORT_HEADER_CODE");//IN029312

						}


					}
				catch(Exception ee)
				{

					ee.printStackTrace();
				}
				finally
				{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
			}
			/*
		//IN029312 Starts
		// report header
		if(!report_header_code.equals(""))
		{
			section_content_rpt = checkForNull( (String) sectionBean.getSectionContent(report_header_code,report_header_code), "&nbsp;" );
			
		}

		
		if(!visit_adm_date.equals(""))
		{
			visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
		}
		if(!dischargeDateTime.equals(""))
		{
			dischargeDateTime					=	com.ehis.util.DateUtils.convertDate(dischargeDateTime,"DMYHM","en",locale);
		}
		StringBuffer section_content_new = new StringBuffer(section_content_rpt);
		try
		{
			if(!patient_name.trim().equals(""))
			{
			htParameter.put("V$PT_NAME",patient_name);
			}
			htParameter.put("V$ATT_PRACT", attending_practitioner);
			htParameter.put("V$ADM_PRACT", admitting_practitioner);
			htParameter.put("V$BED_NUM", bed_number);	
			htParameter.put("V$PT_SPLTY", speciality_name);
			htParameter.put("V$PT_LOCN", location_name); 
			htParameter.put("V$ADM_DT", visit_adm_date);
			htParameter.put("V$DIS_DT", dischargeDateTime);
			htParameter.put("V$DOC_REF_H", doc_ref_id);
		}
		catch(Exception textExp)
		{
			
			textExp.printStackTrace();
		}

		if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
		{			
			sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
		}

				
		if(!(sectionContentUpdatedXML.toString().equals("&nbsp;"))&&(!(sectionContentUpdatedXML.toString().equals(""))))
		{								
			
			section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");

		}
		noteContent.append("<html><head><title></title> </head><body><table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>");

		noteContent.append(section_content_rpt);
		noteContent.append("</table><br>");
		noteContent.append("</body></html>");
		// report hdr ends
		//IN029312 Ends
		*/
		if(!note_header_code.equals(""))
		{
			section_content = checkForNull( (String) sectionBean.getSectionContent(note_header_code,note_header_code), "&nbsp;" );
		}

		if(!event_date_time.equals(""))
		{
			event_date_time				=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
		}
		StringBuffer section_content_new = new StringBuffer(section_content);//IN029312
		//section_content_new = new StringBuffer(section_content);//IN029312
		//sectionContentUpdatedXML = new StringBuffer();//IN029312
		htParameter.put("V$DOC_REF_NH", doc_ref_id);
		htParameter.put("V$PR_DATE", event_date_time);
		htParameter.put("V$NT_TITLE", note_title);
		htParameter.put("V$PR_BY_PRACT", performing_phy_name);
		htParameter.put("V$NT_MEDSRV", med_service);
		htParameter.put("V$SEX", sexValue);//IN072879
		htParameter.put("V$PT_LOCN", location_code); //IN072879
		htParameter.put("V$PT_SPLTY", speciality_name);//IN072879
	//htParameter.put("V$NT_STATUS", status);
		if((!section_content_new.toString().equals("&nbsp;")) && (!section_content_new.toString().equals("")))
				{
					//IN041827 Starts
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
					paramHash.put("#p_patient_id#",patient_id);
					paramHash.put("#p_encounter_id#",encounter_id);
					paramHash.put("#p_accNum#",accessionNum);
					paramHash.put("#p_locale#",locale);
					paramHash.put("#p_eventDate#",event_date_time); //IN039562
					paramHash.put("#p_facility_id#",facilityId);//IN038439
					paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
					tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
					if(tempParameter.size()>0){					
					htParameter.putAll(tempParameter);
					}
					//IN041827 Ends
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}
		if((!(section_content.equals("&nbsp;"))) && (!(section_content.equals(""))))
		{
			try{
			section_content=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
			}catch(TransformerConfigurationException tce) {
				tce.printStackTrace();
				System.err.println(" 3506. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+tce);
				return false;
			}catch(TransformerException etx){
				etx.printStackTrace();
				System.err.println(" 3511. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+etx);
				return false;
			}catch(FileNotFoundException efn){
				efn.printStackTrace();
				System.err.println(" 3514. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+efn);
				return false;
			}catch(IOException eio){
				eio.printStackTrace();
				System.err.println(" 3518. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+eio);
				return false;
			}
			catch(Exception e)
			{	
				e.printStackTrace();
				System.err.println(" 3780. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+e);
				return false;
			}
		}
		//<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD"><tr>	<td>
		//<table border=0 cellspacing=0 width=auto width='100%' style=\"font-family:Verdana;font-size:9pt\"><tr>

		//noteContent.append("<HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'><tr> <td colspan='3' ><font style ='font-family:Verdana'>");
		//noteContent.append("<HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>");//Commented for IN059489
		noteContent.append("<html><head><title></title> </head><body><table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;'>"); //Modified for IN059489
		noteContent.append(section_content);
	//	noteContent.append("</td></tr></table><br><hr>");
		//noteContent.append("</table><br><hr>");//IN032744
		noteContent.append("</table><br>");//IN032744


		//constructing each note saparatly

			//String qry1 = "SELECT (SELECT CHILD_SEQ_NUM FROM CA_SUBSECTION_LINK D WHERE D.HEADER_SEC_HDG_CODE=A.SEC_HDG_CODE AND D.CHILD_SEC_HDG_CODE=A.SUBSEC_HDG_CODE )   CHILD_SEQ_NUM, REPLACE(HDR.SEC_HDG_DESC,'''','') HEADER_SECTION, REPLACE(NVL(DTL.SEC_HDG_DESC,HDR.SEC_HDG_DESC),'''','') SUB_SEC_HDG, HDR.CONTENT_TYPE SECTION_CONTENT_TYPE, DTL.CONTENT_TYPE CHILD_SECTION_CONTENT_TYPE,A.SEC_HDG_CODE,A.SUBSEC_HDG_CODE, DTL.IMAGE_LINKED_YN, NVL(DTL.PRESERVE_FORMAT_YN, HDR.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN FROM  CA_ENCNTR_NOTE_SECTION A ,CA_SECTION_HDG_LANG_VW HDR ,CA_SECTION_HDG_LANG_VW DTL  WHERE   A.SEC_HDG_CODE = HDR.SEC_HDG_CODE AND A.SUBSEC_HDG_CODE = DTL.SEC_HDG_CODE(+) AND /*A.FACILITY_ID  = ? AND */ A.ACCESSION_NUM = ? AND A.NOTES_SECTION_CONTENT IS NOT NULL AND HDR.LANGUAGE_ID = ? AND DTL.LANGUAGE_ID(+) = ?  ORDER BY NOTE_SEC_SEQ_NUM ,CHILD_SEQ_NUM";
			//[IN038614] Start
			//String qry1 = "SELECT (SELECT CHILD_SEQ_NUM FROM CA_SUBSECTION_LINK D WHERE D.HEADER_SEC_HDG_CODE=A.SEC_HDG_CODE AND D.CHILD_SEC_HDG_CODE=A.SUBSEC_HDG_CODE )   CHILD_SEQ_NUM, REPLACE(HDR.SEC_HDG_DESC,'''','') HEADER_SECTION, REPLACE(NVL(DTL.SEC_HDG_DESC,HDR.SEC_HDG_DESC),'''','') SUB_SEC_HDG, HDR.CONTENT_TYPE SECTION_CONTENT_TYPE, DTL.CONTENT_TYPE CHILD_SECTION_CONTENT_TYPE,A.SEC_HDG_CODE,A.SUBSEC_HDG_CODE, DTL.IMAGE_LINKED_YN, NVL(DTL.PRESERVE_FORMAT_YN, HDR.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN,to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time FROM  CA_ENCNTR_NOTE_SECTION A ,CA_SECTION_HDG_LANG_VW HDR ,CA_SECTION_HDG_LANG_VW DTL  WHERE   A.SEC_HDG_CODE = HDR.SEC_HDG_CODE AND A.SUBSEC_HDG_CODE = DTL.SEC_HDG_CODE(+) AND /*A.FACILITY_ID  = ? AND */ A.ACCESSION_NUM = ? AND A.NOTES_SECTION_CONTENT IS NOT NULL AND HDR.LANGUAGE_ID = ? AND DTL.LANGUAGE_ID(+) = ?  ORDER BY NOTE_SEC_SEQ_NUM ,CHILD_SEQ_NUM";
			
			String qry1 = "SELECT (SELECT CHILD_SEQ_NUM FROM CA_SUBSECTION_LINK D WHERE D.HEADER_SEC_HDG_CODE=A.SEC_HDG_CODE AND D.CHILD_SEC_HDG_CODE=A.SUBSEC_HDG_CODE )   CHILD_SEQ_NUM, REPLACE(HDR.SEC_HDG_DESC,'''','') HEADER_SECTION, REPLACE(NVL(DTL.SEC_HDG_DESC,HDR.SEC_HDG_DESC),'''','') SUB_SEC_HDG, HDR.CONTENT_TYPE SECTION_CONTENT_TYPE, DTL.CONTENT_TYPE CHILD_SECTION_CONTENT_TYPE,A.SEC_HDG_CODE,A.SUBSEC_HDG_CODE, DTL.IMAGE_LINKED_YN, NVL(DTL.PRESERVE_FORMAT_YN, HDR.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN,to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=(NVL (a.modified_by_id, a.added_by_id))),?,'1') PRACTITIONER_NAME FROM  CA_ENCNTR_NOTE_SECTION A ,CA_SECTION_HDG_LANG_VW HDR ,CA_SECTION_HDG_LANG_VW DTL  WHERE   A.SEC_HDG_CODE = HDR.SEC_HDG_CODE AND A.SUBSEC_HDG_CODE = DTL.SEC_HDG_CODE(+) AND A.ACCESSION_NUM = ? AND A.NOTES_SECTION_CONTENT IS NOT NULL AND HDR.LANGUAGE_ID = ? AND DTL.LANGUAGE_ID(+) = ?  ORDER BY NOTE_SEC_SEQ_NUM ,CHILD_SEQ_NUM";
			//[IN038614] End.
			try
			{
				pstmt = con.prepareStatement(qry1);

				//[IN038614] Start
				//pstmt.setString(1,accessionNum);
				//pstmt.setString(2,locale);
				//pstmt.setString(3,locale);
				
				pstmt.setString(1,locale);
				pstmt.setString(2,accessionNum);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);

				//[IN038614] End
				rs = pstmt.executeQuery();
				String sys_date_time = "";//IN033677
				while(rs.next())
				{
					sectionContent			=	"";
					section_image_content	=	"";
					section_image_height	=	"400"; //IN053298
					preserve_format_yn		= rs.getString("PRESERVE_FORMAT_YN");
					//noteContent.append("<table border=0 cellspacing=0 width=\"100%\" style=\"font-family:Verdana\" >");  //Commented for IN064566 
					headerSection			= rs.getString("Header_section")==null?"":rs.getString("Header_section");
					subSecHdg				= rs.getString("sub_sec_hdg")==null?"":rs.getString("sub_sec_hdg");
					sectionContentType		= rs.getString("section_content_type")==null?"":rs.getString("section_content_type");
					childSectionContentType = rs.getString("child_section_content_type")==null?"":rs.getString("child_section_content_type");
					secHdgCode				= rs.getString("sec_hdg_code")==null?"":rs.getString("sec_hdg_code");
					subSecHdgCode			= rs.getString("subsec_hdg_code")==null?"":rs.getString("subsec_hdg_code");
					image_linked_yn			= rs.getString("image_linked_yn")==null?"":rs.getString("image_linked_yn");
					sys_date_time = rs.getString("sys_date_time")==null?"":rs.getString("sys_date_time");//IN033677
					practitioner_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");//[IN038614]
					//constructing the heading for each section
					
			//Commented for IN064566		
				/*
					//[IN038711] Start.
					if(!record_mode.equals("SignAddendum") && !record_mode.equals("RecordAddendum")){ //IN038848 
						if(!headerSection.equals(subSecHdg))
						{
							if(!prevHeaderSection.equals(headerSection))
							{
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>"); //Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>"); //Modified for IN059489
								prevHeaderSection = headerSection;
							}

						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr><TR><TD colspan=\"3\">");
						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>"); //Commented for IN059489
						noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Modified for IN059489
						}
						else
						{
						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr><TR><TD colspan=\"3\">");
						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
							noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
						}
					} //IN038848 
			*/ //Commented for IN064566
				//[IN038711] Start.
					//getting the section contents from the bean

					output_yn = sectionBean.getOutputExistYN(secHdgCode,subSecHdgCode);
					secHdgCode_out= secHdgCode+"_out";
					subSecHdgCode_out = subSecHdgCode+"_out";
					if(output_yn.equals("Y"))
					{
						sectionContent = checkForNull((String)sectionBean.getSectionContent(secHdgCode_out,subSecHdgCode_out),"&nbsp;");
						//[IN039227] Start
						sectionContentTemp = sectionContent;
						sectionContentTemp = sectionContentTemp.replaceAll("<ADDRESS>","");
						sectionContentTemp = sectionContentTemp.replaceAll("</ADDRESS>","");
						sectionContentTemp = sectionContentTemp.trim();		//IN041023				
						//[IN039227] End.
					}
					else
					{
						sectionContent = checkForNull((String)sectionBean.getSectionContent(secHdgCode,subSecHdgCode),"&nbsp;");
						//[IN039227]Start
						sectionContentTemp = sectionContent;
						sectionContentTemp = sectionContentTemp.replaceAll("<ADDRESS>","");
						sectionContentTemp = sectionContentTemp.replaceAll("</ADDRESS>","");
						sectionContentTemp = sectionContentTemp.trim();  //IN041023
						//[IN039227] End.
					}
					//IN064566 Changes Starts
					if(sectionContent.length()>0)
					{
					noteContent.append("<table border=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:Verdana\" >"); //Added for IN064566
					//[IN038711] Start.
					if(!record_mode.equals("SignAddendum") && !record_mode.equals("RecordAddendum")){ //IN038848 
						if(display_note_description.equals("Y")){//7605
						if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
						noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr>");//IN071865
						 prev_note_type_desc=note_type_desc;//IN073100
						}//7605
						}
						if(!headerSection.equals(subSecHdg))
						{
							if(!prevHeaderSection.equals(headerSection))
							{
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>"); //Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>"); //Modified for IN059489
								prevHeaderSection = headerSection;
							}

						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr><TR><TD colspan=\"3\">");
						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>"); //Commented for IN059489
						noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Modified for IN059489
						}
						else
						{
						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr><TR><TD colspan=\"3\">");
						//	noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
							noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
						}
					} //IN038848 
					//IN064566 changes Ends

					//IN033677,starts
					if(record_mode.equals("SignAddendum"))
					{
						String content_type = (String) sectionBean.getSectionType( secHdgCode, subSecHdgCode);
						String ammend_text = (String) sectionBean.getAddendumText( secHdgCode, subSecHdgCode);
						//IN039642 Start.
						//ammend_text = ammend_text.replaceAll("<ADDRESS>","");
						//ammend_text = ammend_text.replaceAll("</ADDRESS>","");
						
						String ammend_text_temp = "";
						if(!"".equals(ammend_text) && ammend_text!=null)
							ammend_text_temp = ammend_text.trim();
						ammend_text_temp = ammend_text_temp.replaceAll("<ADDRESS>","");
						ammend_text_temp = ammend_text_temp.replaceAll("</ADDRESS>","");
						//IN039642 End.
						//IN033677
						if(!ammend_text_temp.equals("") && !ammend_text_temp.equals("&nbsp;")) //IN039642 .
						{
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr>"); //Modified for IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							//[IN038711] Start.
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
									noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
									prevHeaderSection = headerSection;
								}
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Modified for IN059489
							}else{
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
							}
							//[IN038711] End.
							if (content_type.equals("T"))
							{
								if( !sectionContent.equals("") )
									sectionContent = sectionContent.substring(0,sectionContent.indexOf("</USER-TEMPLATE>"));

								sectionContent = sectionContent +"<USER-TEMPLATE-ADDENDUM CREATED-BY='"+replaceSpecialChars(clinician_name)+"' DATE='"+sys_date_time+"'><![CDATA["+(ammend_text)+"]]></USER-TEMPLATE-ADDENDUM>";
								sectionContent = sectionContent +"</USER-TEMPLATE>";
							}
							else
							{
								//sectionContent +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By: "+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr></table>"; 
								sectionContent = sectionContent +"<table border='0' cellspacing='0' width='100%'><tr><td><table border='0' cellspacing='0' width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><i><b>Addendum Created By :</b>"+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</i></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr><tr><td>&nbsp;</td></tr></table>";
							}
						}
						//IN038848 Start.
						else if(!sectionContentTemp.equals("") && !sectionContentTemp.equals("&nbsp;")){ 
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr>"); //Modified for IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
									noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
									prevHeaderSection = headerSection;
								}
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Modified for IN059489
							}else{
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
							}						
						}
						//IN038848 End.
					}
					else if(record_mode.equals("RecordAddendum"))  // [IN034871] Start
					{
						String content_type = (String) sectionBean.getSectionType( secHdgCode, subSecHdgCode);
						String ammend_text = (String) sectionBean.getAddendumText( secHdgCode, subSecHdgCode);
						//IN039642 Start.
						//ammend_text = ammend_text.replaceAll("<ADDRESS>","");
						//ammend_text = ammend_text.replaceAll("</ADDRESS>","");
						
						String ammend_text_temp = "";
						if(!"".equals(ammend_text) && ammend_text!=null)
							ammend_text_temp = ammend_text.trim();
						ammend_text_temp = ammend_text_temp.replaceAll("<ADDRESS>","");
						ammend_text_temp = ammend_text_temp.replaceAll("</ADDRESS>","");
						//IN039642 End.
						
						//if(!ammend_text.equals("")  && !ammend_text.equals("&nbsp;"))	//IN039642
						if(!ammend_text_temp.equals("") && !ammend_text_temp.equals("&nbsp;")) //IN039642
						{
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr>"); //Modified for IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							//[IN038711] Start.
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
									noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
									prevHeaderSection = headerSection;
								}
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Modified for IN059489
							}else{
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
							}
							//[IN038711] End.
							if (content_type.equals("T"))
							{
								if( !sectionContent.equals("") )
									sectionContent = sectionContent.substring(0,sectionContent.indexOf("</USER-TEMPLATE>"));
								//[IN038614] Start
								//sectionContent +="<USER-TEMPLATE-ADDENDUM-RECORDED RECORDED-BY='"+replaceSpecialChars(clinician_name)+"' DATE='"+sys_date_time+"'><![CDATA["+(ammend_text)+"]]></USER-TEMPLATE-ADDENDUM-RECORDED>";
								
								sectionContent = sectionContent +"<USER-TEMPLATE-ADDENDUM-RECORDED RECORDED-BY='"+replaceSpecialChars(practitioner_name)+"' DATE='"+sys_date_time+"'><![CDATA["+(ammend_text)+"]]></USER-TEMPLATE-ADDENDUM-RECORDED>";
								//[IN038614] End.
								sectionContent= sectionContent +"</USER-TEMPLATE>";
							}
							else
							{
								//sectionContent +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Recorded By: "+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr></table>";  
								//[IN038614] start.
								//sectionContent +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I><B>Addendum Recorded By :</B> "+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr><tr><td>&nbsp;</td></tr></table>";
								sectionContent = sectionContent +"<table border='0' cellspacing='0' width='100%'><tr><td><table border='0' cellspacing='0' width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><i><b>Addendum Recorded By :</b> "+replaceSpecialChars(practitioner_name)+", Date/Time: "+sys_date_time+"</i></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr><tr><td>&nbsp;</td></tr></table>";
								//[IN038614] End.
							}
						}
						//IN038848  Start.
						else if(!sectionContentTemp.equals("") && !sectionContentTemp.equals("&nbsp;")){
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr>"); //Modified for IN071865
							 prev_note_type_desc=note_type_desc;	//IN073100
						}//7605
						}
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
									noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
									prevHeaderSection = headerSection;
								}
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");//Modified for IN059489
							}else{
								//noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Commented for IN059489
								noteContent.append("<tr><td colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");//Modified for IN059489
							}						
						}
						//IN038848 End.
					}  //[IN034871] End.					
					//IN033677,ends

					//Dinesh T on 9/16/2012,ends

					if(sectionContentType.equals("T") || childSectionContentType.equals("T"))
					{
						if(!(sectionContent.equals("&nbsp;")))
						{

							if(output_yn.equals("Y"))
							{
								try{
								sectionContent=converter.buildHTMLFromXML(sectionContent,"eCA/html/RecClinicalNotesOutputFormDisplay.xsl");
								sectionContent = sectionContent.replaceAll("&lt;","<"); 
								sectionContent = sectionContent.replaceAll("&gt;",">");
								sectionContent = sectionContent.replaceAll("&amp;","&");
								noteContent.append("<tr><td colspan=\"3\">");
								noteContent.append(sectionContent);
								noteContent.append("</td></tr>");
								}catch(TransformerConfigurationException tce) {
									tce.printStackTrace();
									System.err.println(" 3769. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+tce);
									return false;
								}catch(TransformerException etx){
									etx.printStackTrace();
									System.err.println(" 3773. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+etx);
									return false;
								}catch(FileNotFoundException efn){
									efn.printStackTrace();
									System.err.println(" 3777. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+efn);
									return false;
								}catch(IOException eio){
									eio.printStackTrace();
									System.err.println(" 3781. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+eio);
									return false;
								}
								catch(Exception e)
								{	
									e.printStackTrace();
									System.err.println(" 3787. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+e);
									return false;
								}
							}
							else
							{
								try{
								sectionContent=converter.buildHTMLFromXML(sectionContent,(preserve_format_yn.equals("Y")?"eCA/html/RecClinicalNotesTemplateDispayView.xsl":"eCA/html/RecClinicalNotesTemplateSentenceView.xsl"));
								noteContent.append("<tr><td>");
								noteContent.append(sectionContent);
								noteContent.append("</td></tr>");
								}catch(TransformerConfigurationException tce) {
									tce.printStackTrace();
									System.err.println(" 3799. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+tce);
									return false;
								}catch(TransformerException etx){
									etx.printStackTrace();
									System.err.println(" 3803. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+etx);
									return false;
								}catch(FileNotFoundException efn){
									efn.printStackTrace();
									System.err.println(" 3807. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+efn);
									return false;
								}catch(IOException eio){
									eio.printStackTrace();
									System.err.println(" 3811. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+eio);
									return false;
								}
								catch(Exception e)
								{	
									e.printStackTrace();
									System.err.println(" 3817. RecClinicalNotesManager.java => Exception in converting XML to HTML : "+e);
									return false;
								}
							}														
						}
						
					}
					else
					{
						if(image_linked_yn.equals("Y"))
						{
							section_image_content 	= (java.lang.String) sectionBean.getSectionImageContent( secHdgCode,subSecHdgCode );
							section_image_height	= (java.lang.String) sectionBean.getSectionImageHeight( secHdgCode,subSecHdgCode );
							if(section_image_content == null)
								section_image_content = "";
							if(section_image_height == null)
								section_image_height = "400";

							if( (sectionContent.equals("&nbsp;") || sectionContent.equals("") )&& !(section_image_content.equals("")) )
								sectionContent = "<ADDRESS>Refer below image</ADDRESS>";
							noteContent.append("<tr><td colspan=\"3\" style=\"hyphens:auto\">");
								noteContent.append(sectionContent);
							noteContent.append("</td></tr>");
							if(!(section_image_content.equals("") ))
							{
								noteContent.append("<tr><td colspan=\"3\"><applet code=\"Drawing.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"845\" height=\""+section_image_height+"\" align=\"baseline\">");
								noteContent.append("<param name=\"canDraw\" value=\"0\">");
								noteContent.append("<param name=\"image\" value=\"" + section_image_content + "\">");
								noteContent.append("</applet></td></tr>");
							}
						}
						else
						{
						    noteContent.append("<tr><td colspan=\"3\" style=\"hyphens:auto\">");
							noteContent.append(sectionContent);
							noteContent.append("</td></tr>");
						}
					}
					noteContent.append("</TD></TR>");
					noteContent.append("</table>");

					sectionContent = "";
					section_image_content = "";
		
					}//Added Closing Bracket for IN064566 Change
				}
			}catch(TransformerConfigurationException etc_){
				System.out.println("RecClinicalNotesManager.java============3797===========>TransformerConfigurationException");
				return false;
			}catch(TransformerException etx_){
				System.out.println("RecClinicalNotesManager.java============3800===========>TransformerException");
				return false;
			}catch(FileNotFoundException efn_){
				return false;
			}catch(IOException eio_){
				return false;
			// IN048276 end.
			}
			catch (Exception eeF2)
			{
				eeF2.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-1: "+eeF2);
				return false;
			}

			finally
			{
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();
			}
			/*************************************************************************/
			//Taking the addendum text from addendum tabel for the note and appending it to the last
			//[IN033677] String addendumSql = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') PRACTITIONER_NAME,RESP_NAME,to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time from ca_encntr_note_addendum a,am_practitioner b,sm_resp c where a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID and FACILITY_ID =? and ACCESSION_NUM =? order by srl_no ";
			//String addendumSql = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(NVL(a.MODIFIED_PRACT_ID,a.practitioner_id),?,'1') PRACTITIONER_NAME,RESP_NAME,to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,a.ADDENDUM_STATUS from ca_encntr_note_addendum a,am_practitioner b,sm_resp c where a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID /*and FACILITY_ID =? */ and ACCESSION_NUM =? order by srl_no "; //IN033677
			//IN067862 Start.
			//String addendumSql = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(NVL(a.MODIFIED_PRACT_ID,a.practitioner_id),?,'1') PRACTITIONER_NAME,RESP_NAME,to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,a.ADDENDUM_STATUS from ca_encntr_note_addendum a,am_practitioner b,sm_resp c where a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID /*and FACILITY_ID =? */ and ACCESSION_NUM =? and SEC_HDG_CODE='*AmmendNotes*' order by srl_no "; 
			String addendumSql = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(NVL(a.MODIFIED_PRACT_ID,a.practitioner_id),?,'1') PRACTITIONER_NAME,RESP_NAME,to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,a.ADDENDUM_STATUS,a.ADDENDUM_CLOB,a.ADDENDUM_STORAGE_TYPE from ca_encntr_note_addendum a,am_practitioner b,sm_resp c where a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID /*and FACILITY_ID =? */ and ACCESSION_NUM =? and SEC_HDG_CODE='*AmmendNotes*' order by srl_no ";
			//IN067862 end.
			try
			{
				pstmt = con.prepareStatement(addendumSql);
				
				pstmt.setString(1,locale);
				pstmt.setString(2,accessionNum);

				rs= pstmt.executeQuery();
				while(rs.next())
				{
					//noteContent.append("<table border=0 cellspacing=0 width=\"100%\" style=\"font-family:Verdana;font-size:9pt;\" >");
					noteContent.append("<table border=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:Verdana;font-size:9pt;\" >");
					noteContent.append("<tr><td colspan=\"3\">");
					//[IN033677] Start
					//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr></table>");
					//IN033677
					if(rs.getString(1)!=null)
					{
						if("S".equals((String)rs.getString(5)))
						{
							//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr></table>"); 
							//IN067862 Start.
							//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Created By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							if("CLOB".equals((String)rs.getString(7))){
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Created By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(6)==null?"":(String)rs.getString(6))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}else{
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Created By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":(String)rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}
							//IN067862 End.
						}else if("R".equals((String)rs.getString(5))){
							//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" >Addendum Recorded By: "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr></table>"); 
							//IN067862 Start.
							//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Recorded By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							if("CLOB".equals((String)rs.getString(7))){
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Recorded By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(6)==null?"":(String)rs.getString(6))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}else{
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Recorded By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}//IN067862 End.
						}
					}/*else if("R".equals((String)rs.getString(5))){
						noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" >Addendum Recorded By: "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr></table>");
					} */					
					//[IN033677] End
					noteContent.append("</td></tr>");
					//noteContent.append("</table><br><hr>");//IN029312//IN032744
					noteContent.append("</table><br>");//IN029312//IN032744
				}
			}
			catch (Exception eeF3)
			{
				eeF3.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-1: "+eeF3);
				return false;
			}

			finally
			{
				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();
			}
			/*
			//IN029312 Starts
			section_content = "";
			if(!footer_code.equals("") && footer_code != null)
			{
				section_content = checkForNull( (String) sectionBean.getSectionContent(footer_code,footer_code), "&nbsp;" );
			}
				if(!printDateTime.equals(""))
				{
					printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
				}
						
				htParameter=new Hashtable();
				try
				{
					htParameter.put("V$DOC_REF_F", doc_ref_id);
					htParameter.put("V$PRN_DTTIME", printDateTime);
					htParameter.put("V$AT_PRACT", authorized_by);
					htParameter.put("V$LT_MODI_USR", last_amended_by);
					htParameter.put("V$LT_PT_P_C_D", pract_sign);
				}
				catch(Exception textExp)
				{
				
					textExp.printStackTrace();
				}
				
				section_content_new = new StringBuffer(section_content);
				sectionContentUpdatedXML = new StringBuffer();
			
				if(section_content_new != null && !section_content_new.toString().equals("&nbsp;")&&(!(section_content_new.toString().equals(""))))
				{					
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}
				
				if(sectionContentUpdatedXML != null && !(sectionContentUpdatedXML.toString().equals("&nbsp;"))&&(!(sectionContentUpdatedXML.toString().equals(""))))
				{					
					section_content=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
				}
				noteContent.append("<table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>");
				noteContent.append(section_content);
				noteContent.append("</table>");
				
			// for note footer
			// IN029312 Ends	
			*/
			/************************************************************************/
			//IN068105 starts
			if("Y".equals(noteCopiedYN))
				noteContent.append("<table border=0 cellspacing=0 width='100%'><tr><td align='right'><span style='background-color: black;color : white'>*COPIED NOTE</span>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr></table>");
			//IN068105 starts
			noteContent.append("</body></html>");
			//6484 Start.
			String catageroyId ="";
			if(!"".equals(contr_mod_accession_num) && (contr_mod_accession_num!=null))
				catageroyId= fetchOrderCatageroyId(con,facilityId,encounter_id,patient_id,contr_mod_accession_num);
			//System.out.println("RecClinicalNotesManager.java----------catageroyId--------->"+catageroyId);
			if("Y".equals(compressNoteContentYN) && !"OT".equals(catageroyId) && !"LB".equals(catageroyId) && !"RD".equals(catageroyId)){
				
				String updateSql = "UPDATE Ca_encntr_note SET  COMPRESS_NOTE_CONTENT_YN =?, Note_content = empty_clob(), COMPRESS_NOTE_CONTENT = ?  WHERE Accession_num = ? ";
				try
				{
					pstmt = con.prepareStatement(updateSql);
					pstmt.setString(1,"Y");
					pstmt.setBytes(2, compress(noteContent.toString()));								
					pstmt.setString(3,accessionNum);
					pstmt.executeUpdate();
				}catch(IOException ioe){   //CheckStyle
					ioe.printStackTrace();
				}catch (Exception eeF4)
				{
					eeF4.printStackTrace();
					sb.append("<br>Exception@Ejb - recordCN-20-3: "+eeF4);
					return false;
				}

				finally
				{
					if (pstmt != null)
						pstmt.close();
				}
			}else{				
			//6484 End. 
				
				String updateSql = "UPDATE Ca_encntr_note SET COMPRESS_NOTE_CONTENT_YN =?,Note_content = ?, COMPRESS_NOTE_CONTENT = null  WHERE Accession_num = ? ";
						
				try
				{
					pstmt = con.prepareStatement(updateSql);
					Clob clobContent = stringToClob(noteContent.toString(), con);
					pstmt.setString(1,"N");
					pstmt.setClob(2, clobContent);	
					pstmt.setString(3,accessionNum);

					pstmt.executeUpdate();
				}
				catch (Exception eeF4)
				{
					eeF4.printStackTrace();
					sb.append("<br>Exception@Ejb - recordCN-20-3: "+eeF4);
					return false;
				}

				finally
				{
					if (pstmt != null)
						pstmt.close();
				}			
			}
		// IN048276 Start.	
		}catch(TransformerConfigurationException etc){
			System.out.println("RecClinicalNotesManager.java=======================>TransformerConfigurationException");
			return false;
		}catch(TransformerException etx){
			System.out.println("RecClinicalNotesManager.java=======================>TransformerException");
			return false;
		}catch(FileNotFoundException efn){
			return false;
		}catch(IOException eio){
			return false;
		// IN048276 end.
		}
		catch(Exception e)
		{
			System.out.println("RecClinicalNotesManager.java=======================>Exception");
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();//7605
				if(rs1!=null) rs1.close();//7605
			}
			catch(Exception e)
			{
				e.printStackTrace();				
			}
			converter = null;
			noteContent = null;
			sectionContentType = null; headerSection = null;prevHeaderSection = null;subSecHdg = null;
			childSectionContentType = null;sectionContent = null;
		}
		
		return true;
	}

//new method for output_format insertion ---shaiju


	//insertMultiResultKey
    private boolean insertSecOutput(Connection con,String sec_hdg_code,String subsec_hdg_code,webbeans.eCA.RecClinicalNotesSectionBean	sectionBean, java.util.HashMap htRecClinicalNotes)
	{

		PreparedStatement	pstmt		=	null;
		ResultSet			rs					=	null;
		//oracle.sql.CLOB	clob_notes_section_content	=	null,clob_notes_section_content_out	 =	null; //[IN037372]
		java.sql.Clob	clob_notes_section_content	=	null,clob_notes_section_content_out	 =	null;
		java.io.Writer			section_content_writer		=	null;
		java.io.BufferedWriter	bf_section_content_writer	=	null;
		String notes_section_content = "";
		String notes_section_content_out = "";
		String accession_num = "",operation_mode="",facility_id="",login_at_ws_no="",login_user_id ="";
		int insert_no =0, Update_no=0;
		String query_clob_object ="";
		boolean ins_status =  false ;
		String sec_hdg_code_out = sec_hdg_code+"_out";
		String subsec_hdg_code_out = subsec_hdg_code+"_out";
		String exist_yn = "N";


		operation_mode				=	(String) htRecClinicalNotes.get ( "operation_mode"			);
			facility_id					=	(String) htRecClinicalNotes.get ( "facility_id"				);
			login_user_id				=	(String) htRecClinicalNotes.get ( "login_user_id"			);
			login_at_ws_no				=	(String) htRecClinicalNotes.get ( "login_at_ws_no"			);
			accession_num				=	(String) htRecClinicalNotes.get ( "accession_num"			);

			//patient_id					=	(String) htRecClinicalNotes.get ( "patient_id"				);
			//patient_class				=	(String) htRecClinicalNotes.get ( "patient_class"			);
			//encounter_id				=	(String) htRecClinicalNotes.get ( "encounter_id"			);
		//	event_type_caption			=	(String) htRecClinicalNotes.get ( "event_type_caption"		);
		//	note_type					=	(String) htRecClinicalNotes.get ( "note_type"				);
		//	service_code				=	(String) htRecClinicalNotes.get ( "service_code"			);
		//	event_class					=	(String) htRecClinicalNotes.get ( "event_class"				);
		//	security_level				=	(String) htRecClinicalNotes.get ( "security_level"			);
		//	event_date_caption			=	(String) htRecClinicalNotes.get ( "event_date_caption"		);
		//	event_date_time				=	(String) htRecClinicalNotes.get ( "event_date_time"			);
		//	event_perf_by_caption		=	(String) htRecClinicalNotes.get ( "event_perf_by_caption"	);
		//	performed_by_id				=	(String) htRecClinicalNotes.get ( "performed_by_id"			);
		//	event_title_caption			=	(String) htRecClinicalNotes.get ( "event_title_caption"		);
		//	event_title_desc			=	(String) htRecClinicalNotes.get ( "event_title_desc"		);
		//	event_auth_by_caption		=	(String) htRecClinicalNotes.get ( "event_auth_by_caption"	);
		//	authorized_by_id			=	(String) htRecClinicalNotes.get ( "authorized_by_id"		);
		//	authorized_date_time		=	(String) htRecClinicalNotes.get ( "authorized_date_time"	);
		//	event_status_caption		=	(String) htRecClinicalNotes.get ( "event_status_caption"	);
		//	event_status				=	(String) htRecClinicalNotes.get ( "event_status"			);
		//	encntr_date					=	(String) htRecClinicalNotes.get ( "encntr_date"				);
		//	clinician_name				=	(String) htRecClinicalNotes.get ( "clinician_name"			);
		//	resp_name					=	(String) htRecClinicalNotes.get ( "resp_name"				);
		//	contr_mod_accession_num		=	(String) htRecClinicalNotes.get ( "contr_mod_accession_num"	);
		//	locale						=	(String) htRecClinicalNotes.get ( "LOCALE"	);


		if(operation_mode.equals("Record")||operation_mode.equals("Sign"))
		{

		String record_exist = " select ACCESSION_NUM from CA_ENCNTR_NOTE_SEC_OUTPUT where facility_id = ? and accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ? " ;




		String insert_output ="Insert into CA_ENCNTR_NOTE_SEC_OUTPUT  (ACCESSION_NUM,FACILITY_ID,SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_TEMPLATE,NOTES_SECTION_RESULT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,empty_clob(),empty_clob(),?,SYSDATE,?,?,?,SYSDATE,?,?)";

		query_clob_object = "select NOTES_SECTION_TEMPLATE ,dbms_lob.getlength(NOTES_SECTION_TEMPLATE),NOTES_SECTION_RESULT ,dbms_lob.getlength(NOTES_SECTION_RESULT)from CA_ENCNTR_NOTE_SEC_OUTPUT where FACILITY_ID = ? and ACCESSION_NUM = ? and sec_hdg_code = ? and subsec_hdg_code=? for update ";

		try
		{
		//
			pstmt	=	con.prepareStatement(record_exist);


			pstmt.setString	(1,facility_id);
			pstmt.setString	(2,accession_num);
			pstmt.setString	(3,sec_hdg_code);
			pstmt.setString	(4,subsec_hdg_code);

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				exist_yn ="Y";
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

		//
		if(exist_yn.equals("N"))
		{

		pstmt	=	con.prepareStatement(insert_output);

		pstmt.setString	(1,accession_num);
		pstmt.setString	(2,facility_id);
		pstmt.setString	(3,sec_hdg_code);
		pstmt.setString	(4,subsec_hdg_code);
		pstmt.setString	(5,login_user_id);
		pstmt.setString	(6,login_at_ws_no);
		pstmt.setString	(7,facility_id);
		pstmt.setString	(8,login_user_id);
		pstmt.setString	(9,login_at_ws_no);
		pstmt.setString	(10,facility_id);

		insert_no		=	pstmt.executeUpdate();

		if(pstmt!=null) pstmt.close();


			if(insert_no>0)
			{
				notes_section_content	=	checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code,subsec_hdg_code),"");

				notes_section_content_out	=	checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code_out,subsec_hdg_code_out ),"");
				pstmt	=	con.prepareStatement(query_clob_object);
				pstmt.setString	(1,	facility_id				);
				pstmt.setString	(2,	accession_num			);
				pstmt.setString	(3,	sec_hdg_code			);
				pstmt.setString	(4,	subsec_hdg_code			);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					//Web logic Conversion -- [IN037372] Start.
					//clob_notes_section_content_out	=	(oracle.sql.CLOB) rs.getObject("NOTES_SECTION_RESULT");
					//clob_notes_section_content	=	(oracle.sql.CLOB) rs.getObject("NOTES_SECTION_TEMPLATE");
					//section_content_writer		=	((oracle.sql.CLOB)clob_notes_section_content_out).getCharacterOutputStream();					
					//bf_section_content_writer = new java.io.BufferedWriter(section_content_writer);
					
					clob_notes_section_content_out	=	(java.sql.Clob) rs.getClob("NOTES_SECTION_RESULT");
					clob_notes_section_content	=	(java.sql.Clob) rs.getClob("NOTES_SECTION_TEMPLATE");
					bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content_out.setCharacterStream(0));
					//Web logic Conversion -- [IN037372] End.
					bf_section_content_writer.write(notes_section_content_out,0,notes_section_content_out.length());

					bf_section_content_writer.flush();
					bf_section_content_writer.close();
					clob_notes_section_content_out=null;
					section_content_writer=null;
				//Web logic Conversion -- [IN037372] Start.
					//section_content_writer		=	((oracle.sql.CLOB)clob_notes_section_content).getCharacterOutputStream();
					//bf_section_content_writer = new java.io.BufferedWriter(section_content_writer);

					bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content.setCharacterStream(0));
				//Web logic Conversion -- [IN037372] End.
					bf_section_content_writer.write(notes_section_content,0,notes_section_content.length());

					bf_section_content_writer.flush();
					bf_section_content_writer.close();
					clob_notes_section_content=null;
					section_content_writer=null;

				ins_status = true;
				}

				pstmt.clearParameters();
			}
		}
		else
			{

			String update_output = "update CA_ENCNTR_NOTE_SEC_OUTPUT set NOTES_SECTION_RESULT = empty_clob(), modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ?" ;

			query_clob_object = "select  NOTES_SECTION_RESULT ,dbms_lob.getlength(NOTES_SECTION_RESULT)from CA_ENCNTR_NOTE_SEC_OUTPUT where FACILITY_ID = ? and ACCESSION_NUM = ? and sec_hdg_code = ? and subsec_hdg_code=? for update ";

			pstmt	=	con.prepareStatement(update_output);

			pstmt.setString	(1,login_user_id);
			pstmt.setString	(2,login_at_ws_no);
			pstmt.setString	(3,facility_id);
			pstmt.setString	(4,facility_id); //subsec_hdg_code
			pstmt.setString	(5,accession_num);  //login_user_id
			pstmt.setString	(6,sec_hdg_code); //login_at_ws_no
			pstmt.setString	(7,subsec_hdg_code);  //facility_id


		Update_no		=	pstmt.executeUpdate();

		if(pstmt!=null) pstmt.close();

		if(Update_no>0)
		{

			notes_section_content_out	=	checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code_out,subsec_hdg_code_out ),"");
			pstmt	=	con.prepareStatement(query_clob_object);
			pstmt.setString	(1,	facility_id				);
			pstmt.setString	(2,	accession_num			);
			pstmt.setString	(3,	sec_hdg_code			);
			pstmt.setString	(4,	subsec_hdg_code			);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
			//Web logic Conversion -- [IN037372] Start.
				//clob_notes_section_content_out	=	(oracle.sql.CLOB) rs.getObject("NOTES_SECTION_RESULT");
				//section_content_writer		=	((oracle.sql.CLOB)clob_notes_section_content_out).getCharacterOutputStream();
				//bf_section_content_writer = new java.io.BufferedWriter(section_content_writer);
				
				clob_notes_section_content_out	=	(java.sql.Clob) rs.getClob("NOTES_SECTION_RESULT");
				bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content_out.setCharacterStream(0));
			//Web logic Conversion -- [IN037372] End.
				bf_section_content_writer.write(notes_section_content_out,0,notes_section_content_out.length());

				bf_section_content_writer.flush();
				bf_section_content_writer.close();
				clob_notes_section_content_out=null;
				section_content_writer=null;


				ins_status = true;

			}

			pstmt.clearParameters();
		}



			}

		}
		catch(Exception eUpdContentFail)
		{
			eUpdContentFail.printStackTrace();
				
				ins_status = false;
				//sb.append("<br>Exception@EJB - Note section content Updation: "+eUpdContentFail);
		}
		finally
		{
			try
			{
			if(rs!=null) rs.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}


		}
		else if(operation_mode.equals("UpdateRecord")||operation_mode.equals("ModifySection"))
		{

			String update_output = "update CA_ENCNTR_NOTE_SEC_OUTPUT set NOTES_SECTION_RESULT = empty_clob(), modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and accession_num = ? and sec_hdg_code = ? and subsec_hdg_code = ?" ;

			query_clob_object = "select  NOTES_SECTION_RESULT ,dbms_lob.getlength(NOTES_SECTION_RESULT)from CA_ENCNTR_NOTE_SEC_OUTPUT where FACILITY_ID = ? and ACCESSION_NUM = ? and sec_hdg_code = ? and subsec_hdg_code=? for update ";

			try
			{

			pstmt	=	con.prepareStatement(update_output);

			pstmt.setString	(1,login_user_id);
			pstmt.setString	(2,login_at_ws_no);
			pstmt.setString	(3,facility_id);
			pstmt.setString	(4,facility_id); //subsec_hdg_code
			pstmt.setString	(5,accession_num);  //login_user_id
			pstmt.setString	(6,sec_hdg_code); //login_at_ws_no
			pstmt.setString	(7,subsec_hdg_code);  //facility_id


		Update_no		=	pstmt.executeUpdate();

		if(pstmt!=null) pstmt.close();

		if(Update_no>0)
		{

			notes_section_content_out	=	checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code_out,subsec_hdg_code_out ),"");
			pstmt	=	con.prepareStatement(query_clob_object);
			pstmt.setString	(1,	facility_id				);
			pstmt.setString	(2,	accession_num			);
			pstmt.setString	(3,	sec_hdg_code			);
			pstmt.setString	(4,	subsec_hdg_code			);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
			//Web logic Conversion -- [IN037372] Start.
				//clob_notes_section_content_out	=	(oracle.sql.CLOB) rs.getObject("NOTES_SECTION_RESULT");
				//section_content_writer		=	((oracle.sql.CLOB)clob_notes_section_content_out).getCharacterOutputStream();
				//bf_section_content_writer = new java.io.BufferedWriter(section_content_writer);
				
				clob_notes_section_content_out	=	(java.sql.Clob) rs.getClob("NOTES_SECTION_RESULT");
				bf_section_content_writer = new java.io.BufferedWriter(clob_notes_section_content_out.setCharacterStream(0));
			//Web logic Conversion -- [IN037372] End.	
				bf_section_content_writer.write(notes_section_content_out,0,notes_section_content_out.length());

				bf_section_content_writer.flush();
				bf_section_content_writer.close();
				clob_notes_section_content_out=null;
				section_content_writer=null;


				ins_status = true;

			}

			pstmt.clearParameters();
		}



		}
		catch(Exception eUpdContentFail)
		{
			eUpdContentFail.printStackTrace();
				
				ins_status = false;
				//sb.append("<br>Exception@EJB - Note section content Updation: "+eUpdContentFail);
		}
		finally
		{
			try
			{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
}

	return ins_status ;
	}

	//(con,list,htRecClinicalNotes)

	private boolean insertMultiResultKey(Connection con,java.util.HashMap htRecClinicalNotes)
	{

		PreparedStatement	pstmt		=	null;
		//ResultSet			rs			=	null;

		Boolean insFlag = false;

		String facility_id ="";
		String login_user_id ="";
		String login_at_ws_no ="";
		String accession_num ="";
		HashMap multiHash = null;
		int listsize =0;
		String key ="";

		try
		{

		facility_id			=	(String) htRecClinicalNotes.get ( "facility_id"	);
		login_user_id		=	(String) htRecClinicalNotes.get ( "login_user_id");
		login_at_ws_no		=	(String) htRecClinicalNotes.get ( "login_at_ws_no");
		accession_num		=	(String) htRecClinicalNotes.get ( "accession_num");
		multiHash				=	(HashMap) htRecClinicalNotes.get ( "multiHash");
		Object keyList []	;

		keyList = multiHash.keySet().toArray();
		listsize            =   keyList.length;

		String delete_keys ="delete from CA_ENCNTR_MULT_RESULT_KEY where accession_num = ? and added_facility_id =?";

		pstmt	=	con.prepareStatement(delete_keys);

		pstmt.setString	(1,	accession_num);
		pstmt.setString	(2,	facility_id	);

		pstmt.executeUpdate();

		if(pstmt!=null)
			pstmt.close();


		String insert_keys ="Insert into CA_ENCNTR_MULT_RESULT_KEY  (ACCESSION_NUM,RESULT_LINKED_KEY,RESULT_LINKED_VALUE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";



		pstmt	=	con.prepareStatement(insert_keys);

		for(int i=0;i<listsize;++i)
		{
			key =(String)keyList[i];
			pstmt.setString	(1,accession_num);
			pstmt.setString	(2,key);
			pstmt.setString	(3,(String)multiHash.get(key));
			pstmt.setString	(4,login_user_id);
			pstmt.setString	(5,login_at_ws_no);
			pstmt.setString	(6,facility_id);
			pstmt.setString	(7,login_user_id);
			pstmt.setString	(8,login_at_ws_no);
			pstmt.setString	(9,facility_id);

			pstmt.addBatch();
		}

		int [] nInsStat1 = pstmt.executeBatch();

		for(int k=0; k<nInsStat1.length;++k )
				{
					if(nInsStat1[k]<0 && nInsStat1[k] != -2)
					{
						insFlag = false;
						break;

					}
					else
					{
						insFlag = true;
					}
				}

		}
		catch(Exception eUpdContentFail)
		{
			eUpdContentFail.printStackTrace();
			
			insFlag = false;

		}
		finally
		{
			try
			{
				if(pstmt!=null) pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}


		}

	return insFlag;

	}

	//IN033677,starts
	private String replaceSpecialChars(String input)
	{
		if( !input.equals("") )
		{
			if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
			if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
			if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");				
		}

		return input;
	}
	//IN033677,ends
	//IN67872, starts
	public java.util.HashMap rejectRecClinicalNotes(java.util.Properties jdbc_props, java.util.HashMap htRecClinicalNotes)
	{
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;

		java.util.HashMap results =	new java.util.HashMap() ;
		StringBuilder		sb		=	new StringBuilder("") ;

		String	clinician_id		=	"",		action_comment		=	"";
		String	facility_id			=	"",		accession_num		=	"";
		String	login_user_id		=	"",		login_at_ws_no		=	"";
		String  strOutput			=	"N",	locale				=	"";
		
		String privilege_type = "";

		boolean result				=	false,	commit_flag			=	true;
		int		update_result		=	0;
		java.util.Hashtable	message	=	null;
		String incSysDateTime = "";
		
		try
		{
			clinician_id			=	(String) htRecClinicalNotes.get ("clinician_id");
			action_comment			=	(String) htRecClinicalNotes.get ("action_comment");
			facility_id				=	(String) htRecClinicalNotes.get ("facility_id");
			accession_num			=	(String) htRecClinicalNotes.get ("accession_num");
			login_user_id			=	(String) htRecClinicalNotes.get ("login_user_id");
			login_at_ws_no			=	(String) htRecClinicalNotes.get ("login_at_ws_no");
			locale					=	(String) htRecClinicalNotes.get ("LOCALE");
			privilege_type			=	(String) htRecClinicalNotes.get ("privilege_type");

			con		=	ConnectionManager.getConnection(jdbc_props);

			con.setAutoCommit(false);
	
			incSysDateTime = fetchSystemDateTime(con);

			try
			{
				String update_ca_encntr_note = "update ca_encntr_note set event_status_caption = 'Rejected',  event_status = '8', marked_in_reject_by_id = ?, marked_in_reject_date_time = SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? where accession_num = ? ";

				pstmt	=	con.prepareStatement(update_ca_encntr_note);

				pstmt.setString	(1,	clinician_id	);
				pstmt.setString	(2,	login_user_id	);
				pstmt.setString	(3,	login_at_ws_no	);
				pstmt.setString	(4,	facility_id		);
				pstmt.setString	(5,	accession_num	);

				update_result = pstmt.executeUpdate();

				if( update_result <= 0 )	
					commit_flag	= false;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				commit_flag = false;
				sb.append("<br>Exception@error - 4852: "+e);
			}
			finally
			{
				try
				{
					if(pstmt!=null) 
						pstmt.close();
				}
				catch(Exception e){e.printStackTrace();}
			}

			if(commit_flag)
			{
				try
				{
					strOutput ="N";
					//strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","RJ","SR",clinician_id,login_user_id,login_at_ws_no,null,null,action_comment,privilege_type);
					//String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE,action_status = 'RJ', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? , action_comment = ? where /*action_status = 'RQ' and*/ action_type = 'SN' and action_status != 'RJ' and action_by_id = ? and accession_num  = ? ";
					String update_ca_encntr_note_audit_log = "update ca_encntr_note_audit_log set action_date_time = SYSDATE,action_status = 'RJ', modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? , action_comment = ? where /*action_status = 'RQ' and*/ action_type in ('SN','RV','FS') and action_status != 'RJ' and action_by_id = ? and accession_num  = ? ";
		
					pstmt	=	con.prepareStatement(update_ca_encntr_note_audit_log);

					pstmt.setString	(	1,	login_user_id	);
					pstmt.setString	(	2,	login_at_ws_no	);
					pstmt.setString	(	3,	facility_id		);
					pstmt.setString	(	4,	action_comment	);
					pstmt.setString	(	5,	clinician_id	);
					pstmt.setString	(	6,	accession_num	);

					update_result = pstmt.executeUpdate();

					if( update_result > 0 )
						strOutput = "Y";
					
					if(update_result<=0)
					{
						strOutput = insertAuditLog(con,facility_id,accession_num,"SYSDATE","SN","RJ",clinician_id,login_user_id,login_at_ws_no,null,null,action_comment,privilege_type);
					}
					
					if("Y".equals(strOutput))
					{
						strOutput  = noteAuditPreAmend(con,facility_id,accession_num,"RJ");
					}
					
					if("Y".equals(strOutput))
					{
						commit_flag = true;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					commit_flag = false;
					sb.append("<br>Exception@error - 4895: @ audit log"+e);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			commit_flag = false;
			sb.append("<br>Exception@error - 4903: "+e);
		}
		finally
		{
			try
			{
				if(commit_flag)
				{
					result = true ;
					MessageManager msgMgr = new MessageManager();
					message = msgMgr.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					con.commit();
				}
				else
					con.rollback();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>Exception@error - 4922: "+e);
				try
				{
					con.rollback();
				}
				catch(Exception e1) {e1.printStackTrace();}
			}
			finally
			{
				try
				{
					message.clear();
					if(pstmt!=null) pstmt.close();
					if(con!=null)	ConnectionManager.returnConnection(con, jdbc_props);
				}
				catch(Exception e){e.printStackTrace();}
			}
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "accession_num", accession_num ) ; 
		return results ;
}

	
	public String fetchSystemDateTime(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String incSysDateTime = "";
		
		try 
		{
			String sys_qry = "select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysTime from dual";

			pstmt = con.prepareStatement(sys_qry);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				incSysDateTime = rs.getString("sysTime") == null ? "SYSDATE": rs.getString("sysTime");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{			
			try 
			{
				if(rs!=null)
					rs.close();
					
				if(pstmt!=null)
					pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return incSysDateTime;
	}

	public String noteAuditPreAmend(Connection con, String facility_id, String accession_num, String status_code) {
		CallableStatement cspreAmend = null;
		String strOutput = "N";

		try 
		{
			cspreAmend = con.prepareCall("{call CA_NOTE_AUDIT_PREAMEND(?,?,to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss'),?,?)}");
			cspreAmend.setString(1, facility_id);
			cspreAmend.setString(2, accession_num);
			cspreAmend.registerOutParameter(3, Types.VARCHAR);
			cspreAmend.setString(4, status_code);
			cspreAmend.execute();
			strOutput = cspreAmend.getString(3);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strOutput = "N";
			sb.append("<br>Exception@ - noteAuditPreAmend: " + e);
		}
		finally 
		{
			try 
			{
				if (cspreAmend != null)
					cspreAmend.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return strOutput;
	}
	//IN67872, ends
	//IN069251 starts 
		public CLOB stringToClob(String stringData, Connection dbConn) 
		{
	        CLOB clob = null;
	        try 
			{
	            clob = oracle.sql.CLOB.createTemporary(dbConn, false, CLOB.DURATION_SESSION);
	            clob.setString(1, stringData);
	        } catch (SQLException sqlException) {
	            System.out.println("Exception thrown in stringtoClob function : SQL Exception : " + sqlException.getMessage());
	        }
	        return clob;
		}
	//IN069251 ends
		//6484 Start.
		public  byte[] compress(final String str) throws IOException {
			if ((str == null) || (str.length() == 0)) {
				return null;
			}
			ByteArrayOutputStream obj = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(obj);
			gzip.write(str.getBytes("UTF-8"));
			gzip.close();
			return obj.toByteArray();
		}
		public String fetchOrderCatageroyId(Connection con,String facilityId,String encounterId,String patientId,String contr_mod_accession_num) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String orderCategoryId = "";
			
			try 
			{
				StringBuffer sys_qry = new StringBuffer(); 
				
				//sys_qry.append(" SELECT 'LB' order_category FROM RL_REQUEST_DETAIL A WHERE  A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.OPERATING_FACILITY_ID||A.OPERATING_FACILITY_ID||A.SPECIMEN_NO||A.TEST_CODE||A.LINE_NO =? ");
				//sys_qry.append(" UNION ALL ");
				//sys_qry.append(" SELECT 'LB' order_category FROM RL_REQUEST_DETAIL A WHERE  A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.OPERATING_FACILITY_ID||A.SPECIMEN_NO||A.TEST_CODE||A.LINE_NO =? ");
				//sys_qry.append(" UNION ALL ");
				sys_qry.append(" SELECT 'RD' order_category FROM  RD_EXAM_VIEW_REQUESTED WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM =? ");
				/*
				sys_qry.append(" UNION ALL ");
				sys_qry.append(" SELECT 'OT' order_category FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID||ANAESTHESIA_SERIAL_NUM||'PRE' like UPPER(?) ");
				sys_qry.append(" UNION ALL ");
				sys_qry.append(" SELECT 'OT' order_category FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID||ANAESTHESIA_SERIAL_NUM||'INTRA' like UPPER(?) ");
				sys_qry.append(" UNION ALL ");
				sys_qry.append(" SELECT 'OT' order_category FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID||ANAESTHESIA_SERIAL_NUM||'POST' like UPPER(?) ");
				sys_qry.append(" UNION ALL ");
				sys_qry.append(" SELECT 'OT' order_category FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = ? AND ENCOUNTER_ID = ? AND OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE||'30' like UPPER(?) ");
				sys_qry.append(" UNION ALL ");
				sys_qry.append(" SELECT 'OT' order_category FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = ? AND ENCOUNTER_ID = ? AND OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE||'99' like UPPER(?) ");
				*/

				pstmt = con.prepareStatement(sys_qry.toString());
				
			/*
				pstmt.setString(1, facilityId);
				pstmt.setString(2, patientId);
				pstmt.setString(3, contr_mod_accession_num);
				
				pstmt.setString(4, facilityId);
				pstmt.setString(5, patientId);
				pstmt.setString(6, contr_mod_accession_num);
			*/	
				pstmt.setString(1, facilityId);
				pstmt.setString(2, patientId);
				pstmt.setString(3, contr_mod_accession_num);
				/*
				pstmt.setString(4, contr_mod_accession_num);
				pstmt.setString(5, contr_mod_accession_num);
				pstmt.setString(6, contr_mod_accession_num);
				
				pstmt.setString(7, facilityId);
				pstmt.setString(8, encounterId);
				pstmt.setString(9, contr_mod_accession_num);
				
				pstmt.setString(10, facilityId);
				pstmt.setString(11, encounterId);
				pstmt.setString(12, contr_mod_accession_num);
				*/
				rs = pstmt.executeQuery();
				while (rs.next()) 
				{
					orderCategoryId = rs.getString("order_category") == null ? "": rs.getString("order_category");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{			
				try 
				{
					if(rs!=null)
						rs.close();
						
					if(pstmt!=null)
						pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			return orderCategoryId;
		}
		
		//6484 End.
		//Auto Save Starts
		private void removedatafromsectionTemp(String patient_id,
				String encounter_id, String note_type,String login_user_id,Connection con) {
				
			StringBuffer deleteqry =  new StringBuffer();
			
			deleteqry.append("DELETE FROM CA_ENCNTR_NOTE_SECTION_TMP WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ? AND ADDED_BY_ID=? AND NOTE_TYPE = ? ");
			int index=1;
			PreparedStatement pstmt =  null;
			try {
				pstmt	=	con.prepareStatement(deleteqry.toString());
				pstmt.setString	(	index++,	patient_id	);
				pstmt.setString	(	index++,	encounter_id	);
				pstmt.setString	(	index++,	login_user_id		);
				pstmt.setString	(	index++,	note_type	);
				pstmt.executeQuery();
				if(pstmt != null)pstmt.close();//15950
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Auto Save Ends
} // end of class RecClinicalNotesManager
