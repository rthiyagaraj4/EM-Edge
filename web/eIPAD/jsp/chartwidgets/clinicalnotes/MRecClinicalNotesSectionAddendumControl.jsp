<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?                          100                        ?             created
23/07/2012           IN034160             Dinesh T             Printpreview function clears the contents in the addendum editor
19/09/2012           IN033677             Dinesh T             CRF-Recording and signing the addendum with new free text editor and uncommented                                                                                  
                                                                                  some part of the code
03/06/2013           IN040265             Ramesh G             Issue 1: At print preview the addendum details displayed as "Addendum Created by"  instead of "Addendum Recorded by"
                                                                                  Issue 2: Addendum details  displayed twice.
03/06/2013           IN040266             Ramesh G             Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.
                                                                                  Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.
                                                                                  Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
       request.setCharacterEncoding("UTF-8");
       webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean) getObjectFromBean(
                     "sectionBean", "webbeans.eCA.RecClinicalNotesSectionBean",
                     session);

       //sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code)





       String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
                     || (session.getAttribute("PREFERRED_STYLE") != "")
                     ? (String) session.getAttribute("PREFERRED_STYLE")
                     : "IeStyle.css";



       
              String section_content = "";
              String curr_sec_hdg_code = "";
              String curr_child_sec_hdg_code = "";
              String dummyValue = "";
              String patient_id = "";
              String note_type = "";
              String prev_sec_hdg_code = "";
              String prev_child_sec_hdg_code = "";
              String prev_sec_content_type = "";
              String editor_title = "";
              String accession_num = "";
              String operation_mode = "";
              String strAmMode = "";
              String strRecordMode = "";
              String curr_section_type = "";
              String encounter_id = "";
              String episode_type = "";
              String patient_class = "";
              String strKey = "";

              curr_sec_hdg_code = request.getParameter("curr_sec_hdg_code") == null
                           ? ""
                           : request.getParameter("curr_sec_hdg_code");
              curr_child_sec_hdg_code = request
                           .getParameter("curr_child_sec_hdg_code") == null
                           ? curr_sec_hdg_code
                           : request.getParameter("curr_child_sec_hdg_code");
              prev_sec_hdg_code = request.getParameter("curr_sec_hdg_code") == null
                      ? ""
                      : request.getParameter("curr_sec_hdg_code");
              prev_child_sec_hdg_code = request
                      .getParameter("curr_child_sec_hdg_code") == null
                      ? curr_sec_hdg_code
                      : request.getParameter("curr_child_sec_hdg_code");
              patient_id = request.getParameter("patient_id") == null
                           ? ""
                           : request.getParameter("patient_id");
              section_content = request.getParameter("section_content") == null
                           ? ""
                           : request.getParameter("section_content");

              note_type = request.getParameter("note_type") == null
                           ? ""
                           : request.getParameter("note_type");
              editor_title = request.getParameter("editor_title") == null
                           ? "Addendum To Note"
                           : request.getParameter("editor_title");
              accession_num = request.getParameter("accession_num") == null
                           ? ""
                           : request.getParameter("accession_num");
              operation_mode = request.getParameter("operation_mode") == null
                           ? ""
                           : request.getParameter("operation_mode");
              strAmMode = request.getParameter("ammend_mode") == null
                           ? ""
                           : request.getParameter("ammend_mode");
              strRecordMode = request.getParameter("record_mode") == null
                           ? ""
                           : request.getParameter("record_mode");
              encounter_id = request.getParameter("encounter_id") == null
                           ? ""
                           : request.getParameter("encounter_id");
              episode_type = request.getParameter("episode_type") == null
                           ? ""
                           : request.getParameter("episode_type");
              patient_class = request.getParameter("patient_class") == null
                           ? ""
                           : request.getParameter("patient_class");

              try {

                     if (prev_sec_hdg_code.equals("*AmmendNotes*")) 
                     { //[IN033869]
                           prev_sec_hdg_code = "*AmmendNotes*";
                           prev_child_sec_hdg_code = prev_sec_hdg_code;
                     } //[IN033869]//IN033677

                     // NOTE :- Get the patient section and set it as a current section reference.
                     // It is very much important when the practitioner selects more than one patient for
                     // recording clinical notes. please be careful if you are going to change this jsp.

                     strKey = patient_id + "~" + encounter_id;
                     strKey = strKey.trim();

                     sectionBean.getPatientSection(strKey);

                     
     

                     
                     
                     if (!prev_sec_hdg_code.equals("*AmmendNotes*")
                                  && !prev_sec_hdg_code.equals("*AmmendNotes*")) {
                           prev_sec_content_type = sectionBean.getSectionType(
                                         prev_sec_hdg_code, prev_child_sec_hdg_code);
                           

                           
                           

                     }
                     if (!curr_sec_hdg_code.equals("")
                                  && !curr_sec_hdg_code.equals("*AmmendNotes*")) {
                           curr_section_type = sectionBean.getSectionType(
                                         curr_sec_hdg_code, curr_child_sec_hdg_code);

                     }

                     try {
                    	                    
                                  section_content = section_content.replace(
                                                "<ADDRESS>&nbsp;</ADDRESS><BR>",
                                                "<ADDRESS>&nbsp;</ADDRESS>"); //IN040265,IN040266
                                  section_content = section_content.replace("<P>",
                                                "<ADDRESS><P>"); //IN040265,IN040266
                                  section_content = section_content.replace("</P>",
                                                "</P></ADDRESS>"); //IN040265,IN040266
                                  if ("".equals(strRecordMode)) { //IN040265,IN040266                                
                                         sectionBean.setAddendumText(prev_sec_hdg_code,
                                                       prev_child_sec_hdg_code, section_content);
                                   } else {
                                         if ((!"".equals(curr_sec_hdg_code))
                                                       && (!"".equals(curr_child_sec_hdg_code))) {                                                
                                                sectionBean.setAddendumText(curr_sec_hdg_code,
                                                              curr_child_sec_hdg_code,
                                                              section_content);
                                         } else {                                        
                                                sectionBean.setAddendumText(prev_sec_hdg_code,
                                                              prev_child_sec_hdg_code,
                                                              section_content);
                                                }
                                  } //IN040265,IN040266

                                  
                                  if (!curr_child_sec_hdg_code.equals("*AmmendNotes*")) {
                                	  

                                         if (prev_sec_content_type.equals("T"))
                                                dummyValue = "<USER-TEMPLATE></USER-TEMPLATE>";
                                         else
                                                dummyValue = "<ADDRESS> </ADDRESS>";
                                         String strExistingContent = "";
                                         strExistingContent = (String) sectionBean
                                                       .getSectionContent(curr_sec_hdg_code,
                                                    		   curr_child_sec_hdg_code);
                                         

                                         
                                         if (strExistingContent == null
                                                       || strExistingContent.equals("")) {                                 
                                                sectionBean.setSectionContent(
                                                		curr_sec_hdg_code,
                                                		curr_child_sec_hdg_code, dummyValue);
                                                
                                                
                                         }
                                  }
                                  putObjectInBean("sectionBean", sectionBean, session);
                                  String getas=sectionBean.getAddendumText(prev_sec_hdg_code, prev_child_sec_hdg_code);
                                  

                           if (!(curr_sec_hdg_code.equals(""))) {
                                  section_content = (String) sectionBean.getAddendumText(
                                                curr_sec_hdg_code, curr_child_sec_hdg_code);
                           }
                           if (section_content == null)
                                  section_content = "";
                             section_content = java.net.URLEncoder.encode(
                                  section_content, "UTF-8");
                     } catch (Exception e) {
                           out.println("Exception @ NewRecClinicalNotesSectionAddendumControl.jsp "
                                         + e.toString());
                           e.printStackTrace();
                     }
              } catch (Exception eMain) {
                     out.println("Exception @ Main Addnendum Control"
                                  + eMain.toString());
                     eMain.printStackTrace();
              }

       
              
                  
                     
                           try {

                                  if (strAmMode.equals("*AmmendNotes*")) {
              
                     
                     
                           } else if (strAmMode.equals("SectionAmmend")) {
                     
                     
                     
                           } else if (strAmMode.equals("sectionView")) {
              
                     
              
                           } else if (strAmMode.equals("Preview")) {
              
                     
                     
                           }
                                  //if (strRecordMode.equals("RecordAddendum") )    [IN033677]
                                  if (strRecordMode.equals("RecordAddendum")
                                                || strRecordMode.equals("SignAddendum")) //[IN033677]
                                  {
                     
                     
                     
                           }
                                  //[IN033869] Start

                                  if (strRecordMode.equals("") && !strAmMode.equals("Preview")
                                                && operation_mode.equals("ModifyAddendum")) {//IN034160
       
                     
                     
                           }
                                 
                           } catch (Exception eSub) {
                                  out.println("Exception @ Addnencum Control" + eSub.toString());
                                  eSub.printStackTrace();
                           }
              
                           %>
