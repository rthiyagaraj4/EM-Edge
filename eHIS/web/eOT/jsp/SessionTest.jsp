<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<% 
//java.util.Properties prop = (java.util.Properties)session.getAttribute("jdbc");
String jsessionid = request.getParameter("jsessionid");
//String locale = (String)session.getAttribute("LOCALE"); 
String title = request.getParameter("title");
//	String appl_task_id = request.getParameter("appl_task_id");
String patient_id = request.getParameter("patient_id");
String patient_class = request.getParameter("patient_class");
String function_id = request.getParameter("function_id");
String event_class = request.getParameter("event_class");
String accession_num = request.getParameter("accession_num");
String ot_speciality_code = request.getParameter("ot_speciality_code");
String hide_header = request.getParameter("hide_header");
String tab_yn = request.getParameter("tab_yn");
//String window_close = request.getParameter("window_close");
String contr_mod_accession_num = request.getParameter("contr_mod_accession_num");
String facility_id = request.getParameter("facility_id");
String encounter_id = request.getParameter("encounter_id");
String note_type = request.getParameter("note_type");
String episode_id = request.getParameter("episode_id");
%>
<head>
<script language="javascript" src="../../eOT/js/HoldingArea.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<input type='hidden' name='note_type' id='note_type' value= "<%=note_type%>" >
<input type='hidden' name='title' id='title' value= "<%=title%>" >                                                           
<input type='hidden' name='appl_task_id' id='appl_task_id' value= 'CLINICAL_NOTES'>                                   
<input type='hidden' name='patient_id' id='patient_id' value= '<%=patient_id%>'>                                           
<input type='hidden' name='encounter_id' id='encounter_id' value= '<%=encounter_id%>"'>                                   
<input type='hidden' name='patient_class' id='patient_class' value= '<%=patient_class%>'>                                  
<input type='hidden' name='function_id' id='function_id' value= "<%=function_id%>">                                        
<input type='hidden' name='event_class' id='event_class' value= "<%=event_class%>">                                      
<input type='hidden' name='accession_num' id='accession_num' value= "<%=accession_num%>">                              
<input type='hidden' name='window_close' id='window_close' value= "Y">                                 
<input type='hidden' name='ot_speciality_code' id='ot_speciality_code' value= '<%=ot_speciality_code%>'>                        
<input type='hidden' name='hide_header' id='hide_header' value= "<%=hide_header%>" >                                      
<input type='hidden' name='tab_yn' id='tab_yn' value= "<%=tab_yn%>">                                                   
<input type='hidden' name='contr_mod_accession_num' id='contr_mod_accession_num' value= "<%=contr_mod_accession_num%>">
<input type='hidden' name='episode_id' id='episode_id' value= "<%=episode_id%>"  >
<input type='hidden' name='query_flag_yn' id='query_flag_yn' value= "N"  >
<input type='hidden' name='facility_id' id='facility_id' value= "<%=facility_id%>"  >
<input type='hidden' name='jsessionid' id='jsessionid' value= "<%=jsessionid%>"  >
</form>                                                               
<body>                                                                                                                                                                                      </html>                                                                
  <SCRIPT>OpenNotesWindow();</SCRIPT>    

                                                                            

