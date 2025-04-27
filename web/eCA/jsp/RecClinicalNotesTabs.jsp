<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
?           100				?	         	?				?				created
04/12/2012	IN032060		Ramesh G		?				?				MO-CRF-20059[All the notes which are documented through 																		   OT slate when modified 
																			by the user who has got privilege to Author and modify these notes and the note	type set up is amend original section the system does not store the original note 
																			content which was modified. ]
29/01/2014	IN046648		Karthi L	29/01/2014		Dinesh T			Speciality  NULL In Medical  Certifictae
02/06/2014	IN037701		Nijitha											SKR-CRF-0036
06/05/2015	IN053733		Ramesh G										When a notifiable recorded against a notifiable diagnosis is marked in error, 
																			the notification to be de-linked from the parent diagnosis
15/06/2015	IN055885		Ramesh G										Record Clinical Notes->After modifying the notes ->Click on "Add" button-System is not responding. 
01/11/2016	IN061988		Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
08/05/2017	IN064034		Dinesh T										ML-MMOH-CRF-0557_UT3
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G		ML-MMOH-CRF-0898.1
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eCA.RecordingClinicalNotesTabs.label" bundle="${ca_labels}"/></title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String callback_mode =	(request.getParameter("callback_mode")==null)? "" : request.getParameter("callback_mode");	
		String addTab = "";
		String addTabSpan = "";
		String searchTab = "";
		String searchTabSpan = "";
		if(callback_mode.equals("Add") || callback_mode.equals(""))
		{
			addTab="tabClicked";
			addTabSpan = "tabSpanclicked";
			searchTab = "tabA";
			searchTabSpan = "tabAspan";
		}else if(callback_mode.equals("Search")){
			searchTab="tabClicked";
			searchTabSpan="tabSpanclicked";
			addTab= "tabA";
			addTabSpan = "tabAspan";
		}		
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script>

	function tab_clickAdd(id) 
	{	
		if (document.getElementById('function_id').value  != "SPCL_NOTE")
		{
			//IN055885 Start.
			if(document.getElementById('function_id').value  == "NOTIFIABLEFORM"){
				if(document.getElementById('callBackMode').value !="Search" && document.getElementById("notifiable_code").value ==""){
					document.getElementById('search_tab').className="tabA";
					document.getElementById('search_tabspan').className="tabAspan";
					selectTab(id);		
					callRecClinicalNotesMain();
				}			
			//IN067717 starts
			}else if( document.getElementById('function_id').value  == "BIRTH_REG_NOTES"){
				if(document.getElementById('callBackMode').value !="Search" && document.getElementById('callBackMode').value =="Add"){
					document.getElementById('search_tab').className="tabA";
					document.getElementById('search_tabspan').className="tabAspan";
					selectTab(id);		
					callRecClinicalNotesMain();
				}	
			}if(document.getElementById('function_id').value  == "DECEASEDFORM"){
				if(document.getElementById('callBackMode').value !="Search"){
					document.getElementById('search_tab').className="tabA";
					document.getElementById('search_tabspan').className="tabAspan";
					selectTab(id);		
					callRecClinicalNotesMain();
				}			
			//IN067717 starts
			}
			//IN067717 ends
			else	{
			//IN055885 end.
				document.getElementById('search_tab').className="tabA";
				document.getElementById('search_tabspan').className="tabAspan";
				selectTab(id);		
				callRecClinicalNotesMain();
			} //IN055885
		}
	}

	function tab_clickSearch(id) 
	{
		//if(document.getElementById('function_id').value  == "SPCL_NOTE" && document.getElementById('callBackMode').value  == ""){}//IN032060	//IN053733	
		//if((document.getElementById('function_id').value  == "SPCL_NOTE" ||document.getElementById("notifiable_code").value !="") && document.getElementById('callBackMode').value  == ""){} //IN053733
		if((document.getElementById('function_id').value  == "SPCL_NOTE" ||document.getElementById('function_id').value  == "BIRTH_REG_NOTES"||document.getElementById("notifiable_code").value !="") && document.getElementById('callBackMode').value  == ""){} //IN067717
		else{																						//IN032060
		document.getElementById('add_tab').className="tabA";
		document.getElementById('add_tabspan').className="tabAspan"	;
		selectTab(id);	
		callRecClinicalNotesSearch();
		}	//IN032060
	}

	function dfltTab()
	{
		if ('<%=callback_mode%>'  == "Add" || '<%=callback_mode%>'  == "")
		{
			prevTabObj = "search_tab";
		}else if ('<%=callback_mode%>'  == "Search")
		{
			prevTabObj = "add_tab";
		}	
		//document.getElementById('search_tab').className = "tabA";
		//document.getElementById('search_tabspan').className = "tabAspan";
	}

</script>
</head>
<%

	String function_id				= "";
	String style_visibility			= " style='display' ";
	String addBt_style_visibility	= " style='display' ";
	String operation_mode		= "";
	String patient_id				= "";
	String modifyYN					= "";
	String encounter_id			= "";
	String episode_type			= "";
	String appl_task_id			= "";
	String patient_class			= "";
	String Sex			= "";
	String Dob			= "";
	String contr_mod_accession_num			= "";
	String module_id			= "";
	String note_type			= "";
	note_type					=	checkForNull(request.getParameter("note_type"));
	String p_called_from="";//CIS-CA-1490	
	String l_speciality_code  = ""; // IN046648
	StringBuffer query_string = new StringBuffer();
	String notifiable_code = ""; //IN053733
	String accession_num 	=""; //IN053733
	String called_from		=""; //IN053733
	String l_dispResLinkHYMLYN = "";//IN064034
	String l_noteSplCharValidate = "";//IN064034
	String speciality_name="",location_code="";//IN072879
	String orderStatusCodeHdr=""; //68801
	try{
	patient_id					=	checkForNull(request.getParameter("patient_id"));
	modifyYN					=	request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");
	encounter_id				=	checkForNull(request.getParameter("encounter_id"));
	episode_type				=	checkForNull(request.getParameter("episode_type"));
	function_id					=	checkForNull(request.getParameter("function_id"));
	appl_task_id				=	checkForNull(request.getParameter("appl_task_id"));
	patient_class				=	checkForNull(request.getParameter("patient_class"));
	operation_mode				=	checkForNull(request.getParameter("operation_mode"));
	Sex				=	checkForNull(request.getParameter("Sex"));
	Dob				=	checkForNull(request.getParameter("Dob"));
	contr_mod_accession_num				=	checkForNull(request.getParameter("contr_mod_accession_num"));
	module_id				=	checkForNull(request.getParameter("module_id"));

	 p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//CIS-CA-1490
	l_speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"); //IN046648
	//IN037701 Starts
	String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");
	//IN037701 Ends
	notifiable_code				=	checkForNull(request.getParameter("notifiable_code")); //IN053733
	accession_num				=	checkForNull(request.getParameter("accession_num")); //IN053733
	called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");  //IN053733 
	l_dispResLinkHYMLYN		= request.getParameter("dispResLinkHYMLYN")==null?"":request.getParameter("dispResLinkHYMLYN");//IN064034
	l_noteSplCharValidate		= request.getParameter("noteSplCharValidate")==null?"":request.getParameter("noteSplCharValidate");//IN064034
	//	query_string.append(request.getQueryString());
	location_code=request.getParameter("location_code")==null?"":request.getParameter("location_code"); //IN072879
	speciality_name=request.getParameter("speciality_name")==null?"":request.getParameter("speciality_name");//IN072879
	orderStatusCodeHdr=request.getParameter("orderStatusCodeHdr")==null?"N":request.getParameter("orderStatusCodeHdr");//IN072879
	query_string.append("patient_id=");		query_string.append(patient_id);
	query_string.append("&encounter_id=");	query_string.append(encounter_id);
	query_string.append("&episode_type=");	query_string.append(episode_type);
	query_string.append("&function_id=");	query_string.append(function_id);
	query_string.append("&appl_task_id="); query_string.append(appl_task_id);
	query_string.append("&patient_class="); query_string.append(patient_class);
	query_string.append("&Sex="); query_string.append(Sex);
	query_string.append("&Dob="); query_string.append(Dob);
	query_string.append("&contr_mod_accession_num="); query_string.append(contr_mod_accession_num);
	query_string.append("&modifyYN="); query_string.append(modifyYN);
	query_string.append("&module_id="); query_string.append(module_id);
	query_string.append("&notifiable_code=");	query_string.append(notifiable_code);//IN053733
	query_string.append("&accession_num=");	query_string.append(accession_num);//IN053733
	query_string.append("&called_from=");	query_string.append(called_from);//IN053733
	query_string.append("&note_type="); query_string.append(note_type);
	query_string.append("&p_called_from_widget="); query_string.append(p_called_from);//CIS-CA-1490
	query_string.append("&speciality_code="); query_string.append(l_speciality_code);//IN046648
	query_string.append("&p_event_class_widget="); query_string.append(p_event_class_widget);//IN037701
	query_string.append("&dispResLinkHYMLYN="); query_string.append(l_dispResLinkHYMLYN);//IN064034
	query_string.append("&noteSplCharValidate="); query_string.append(l_noteSplCharValidate);//IN064034
	query_string.append("&location_code="); query_string.append(location_code);//IN072879
	query_string.append("&speciality_name="); query_string.append(speciality_name);//IN072879
	query_string.append("&orderStatusCodeHdr="); query_string.append(orderStatusCodeHdr);//68801
	
	//if(function_id.equals("SPCL_NOTE")||function_id.equals("TASK_LIST")||appl_task_id.equals("PROGRESS_NOTES"))  //IN032060
	if(function_id.equals("TASK_LIST")||appl_task_id.equals("PROGRESS_NOTES"))									   //IN032060
	{
		style_visibility = " style='display:none' ";
	}else if( function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES") )
	{
		style_visibility = " style='display:none' ";
	}
	if(function_id.equals("SPCL_NOTE") && appl_task_id.equals("PROGRESS_NOTES"))
	{
		addBt_style_visibility  = " style='display:none' ";
	}
	//IN061988 starts
	if(function_id.equals("PH_NOTES") && appl_task_id.equals("PH_NOTES") && !"".equals(accession_num))
	{
		addBt_style_visibility  = " style='display:none' ";
	}
	//IN061988 ends
	}catch(Exception e)
	{
		out.println( "<script>alert('Error    :   " + e.getMessage() + "')</script>"  ) ;
		e.printStackTrace();
	}
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onLoad="dfltTab();">
	<center>
	<form name='RecClinicalNotesTabForm' id='RecClinicalNotesTabForm'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
			<td width= "100%" class="white">
			<ul id="tablist" class="tablist" style="padding-left:0px">
				<li class="tablistitem" title='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' <%=addBt_style_visibility%> >				
				<a onClick="tab_clickAdd('add_tab')" class="<%=addTab%>" id="add_tab" >
					<span class="<%=addTabSpan%>" id="add_tabspan"><fmt:message key="Common.Add.label" bundle="${common_labels}"/></span>
				</a>				
			</li>
			<li class="tablistitem" title='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' <%=style_visibility%>>
				<a onClick="tab_clickSearch('search_tab')" class="<%=searchTab%>" id="search_tab" >
					<span class="<%=searchTabSpan%>" id="search_tabspan"><fmt:message key="Common.search.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			</ul>
			</td>
		</tr>
	</table>

	<input type='hidden' name='query_string' id='query_string'		value='<%=query_string%>'>
	<input type='hidden' name='patient_id' id='patient_id'			value='<%=patient_id%>'>
	<input type='hidden' name='patient_class' id='patient_class'		value='<%=patient_class%>'>
	<input type='hidden' name='function_id' id='function_id'		value='<%=function_id%>'>
	<input type='hidden' name='operation_mode' id='operation_mode' value='<%=operation_mode%>'>
	<input type='hidden' name='callBackMode' id='callBackMode' value='<%=callback_mode%>'>  <!--  IN032060 -->
	<input type='hidden' name='notifiable_code' id='notifiable_code' value='<%=notifiable_code%>'><!-- IN053733  -->
	<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from%>'><!--CIS-CA-1490-->
	<input type='hidden' name='orderStatusCodeHdr' id='orderStatusCodeHdr' value='<%=orderStatusCodeHdr%>'><!--68801-->  
	</form>
	</center>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>
	<%
		
				
		if(callback_mode.equals("Search"))
		{
	%>
			callRecClinicalNotesSearch();
	<%
		}
		else if(callback_mode.equals("Add"))
		{
	%>
			callRecClinicalNotesMain();
	<%
		}
	%>
	if('<%=modifyYN%>' == 'N')
	{
		document.getElementById('add_tab').style.display = 'none';
		document.getElementById('search_tab').click();
	}
	else
		document.getElementById('add_tab').style.display = "";

	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</body>
</html>

<%!
public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}

%>

