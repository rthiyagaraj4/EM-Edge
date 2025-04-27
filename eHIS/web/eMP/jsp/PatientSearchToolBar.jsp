<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<Script>
		/*function resetform() {

		   var register_button_yn = "";
		   var soundex = "";
		   var func_act = "";
		   if (parent.frames[1].document.forms[0].register_button_yn)
				register_button_yn = parent.frames[1].document.forms[0].register_button_yn.value;
		   if (parent.frames[1].document.forms[0].soundex_dflt)
		   {
				soundex = parent.frames[1].document.forms[0].soundex_dflt.value;
				if (soundex==null) soundex="";
			}
		   if (parent.frames[1].document.forms[0].func_act)
				func_act = parent.frames[1].document.forms[0].func_act.value;	

		   if (parent.frames[1].document.forms[0].soundex_dflt)
		   {
			   parent.frames[1].document.forms[0].reset();
			   parent.frames[1].document.forms[0].Mode.disabled = true;
			   parent.frames[1].document.forms[0].Patient_Id.focus();
		   }
		   else
				parent.frames[1].location.href = '../../eMP/jsp/ViewBirthRegisterCriteria.jsp?function_id='+parent.frames[1].document.forms[0].function_id.value;

			if (parent.frames[1].document.forms[0].apply_oth_name)											parent.frames[1].formatFlds(parent.frames[1].document.forms[0].apply_oth_name);

		   if (parent.frames[1].document.forms[0].newborn_suffix)
			   parent.frames[1].document.forms[0].newborn_suffix.disabled=true;
		   if (parent.frames[1].document.forms[0].soundex_dflt)
			   parent.frames[2].location.href = "../../eMP/jsp/SearchToolbar.jsp?register_button_yn="+register_button_yn+"&func_act="+func_act+"";
			else
				parent.frames[2].location.href = "../../eMP/jsp/ViewBirthSearchToolbar.jsp";

		   parent.frames[3].location.href = '../../eCommon/html/blank.html';
		   if (parent.frames[1].document.forms[0].Soundex)
		   {
			   parent.frames[1].document.forms[0].Soundex.value = soundex;
			   parent.frames[1].tab_click('simplesearch_tab');
			}
			if (parent.frames[1].document.forms[0].searchby)
			{
				var soundexval = "";
				if (parent.frames[1].document.forms[0].Soundex)
					soundexval = parent.frames[1].document.forms[0].Soundex.value
				if (parent.frames[1].document.forms[0].soundex_val)
					soundexval = parent.frames[1].document.forms[0].soundex_val.value
				
				if (soundexval=='')
				{
					parent.frames[1].document.forms[0].searchby.disabled=false;

					//The following line was commented and one line added on 11/10/2004 for making the search by list box to display --select-- after reset.
					parent.frames[1].document.forms[0].searchby.value = "";
				}
				else
				{
					parent.frames[1].document.forms[0].searchby.value = "";
					// The following line was changed to disabled = false for enabling the search by list box after search.
					parent.frames[1].document.forms[0].searchby.disabled=false;
				}
			}
			//parent.frames[1].tab_click3('search_tab1','search_tab1');
			//parent.frames[1].document.forms[0].reset();
			//parent.parent.frames[1].tab_click3('simplesearch_tab');
			parent.frames[1].tab_click3('simplesearch_tab');
			//prevTabObj=null;
			//parent.parent.frames[1].tab_click3('simplesearch_tab');
		}*/ 

		function resetform() {
      
			/*Here Two JspPages are Loading at Pat_Search_Criteria_Frame, i.e to differentiate Two form elements Conditionaly Form Names and Jsp Location was written as follows.		Written-On--12/24/2008 */
	        // var BasicAdvanceForm	= parent.Pat_Search_Criteria_Frame.document.forms(0);
	        var BasicAdvanceForm = parent.Pat_Search_Criteria_Frame.document.forms[0];
			var REPLC_LOC;
			var REPLC_FORM_NAME;
			var patient_class	= "";
			//Below line added for this CRF HSA-CRF-0289
			var alterIdSearch="";
			var isAlternateId="";
			if (BasicAdvanceForm.name=="Advnc_Patient_Search_Form"){
				REPLC_LOC="../jsp/PatientSearchCriteria.jsp?";
				//REPLC_FORM_NAME=parent.parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form;
				REPLC_FORM_NAME= parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form;
				// Added for IN0 by Suresh M on 20.12.2010
				patient_class	=	REPLC_FORM_NAME.patient_class.value;
				 //Below line added for this CRF HSA-CRF-0289
				if(REPLC_FORM_NAME.alterIdSearch){
					  alterIdSearch=REPLC_FORM_NAME.alterIdSearch.value;
				}
				if(REPLC_FORM_NAME.isAlternateId){
					  isAlternateId=REPLC_FORM_NAME.isAlternateId.value;
				}
				 
				//parent.patsearch.document.all.pat_search.rows="20,25,330,20,*"; commented by vedesh for edge converstion 
				parent.document.getElementById("commontoolbar").style.height="4vh";
				parent.document.getElementById("Pat_Search_Tabs_Frame").style.height="3vh";
				parent.document.getElementById("Pat_Search_Criteria_Frame").style.height="70vh";
				parent.document.getElementById("Pat_Search_Criteria_Frame").scrolling="no";
				parent.document.getElementById("Pat_Search_Toolbar_Frame").style.height="20px";
				parent.document.getElementById("Pat_Results_Frame").style.height="4vh";
				
			}
			else{
				
					//REPLC_FORM_NAME=parent.parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form;
				    //REPLC_FORM_NAME = parent.parent.Pat_Search_Criteria_Frame.document.forms['Basic_Patient_Search_Form'];
				REPLC_FORM_NAME= parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form;
				REPLC_LOC="../jsp/BasicPatientSearchCriteria.jsp?";
					
					//Below line added for this CRF HSA-CRF-0289
				if(REPLC_FORM_NAME.alterIdSearch){
					  alterIdSearch=REPLC_FORM_NAME.alterIdSearch.value;
				}
				if(REPLC_FORM_NAME.isAlternateId){
					  isAlternateId=REPLC_FORM_NAME.isAlternateId.value;
				}
				
				//parent.patsearch.document.all.pat_search.rows="20,25,245,20,*";

				//parent.patsearch.document.getElementById("pat_search").rows="20,25,245,20,*"; commented by vedesh for edge converstion 
				parent.document.getElementById("commontoolbar").style.height="4vh";
				parent.document.getElementById("Pat_Search_Tabs_Frame").style.height="3vh";
				parent.document.getElementById("Pat_Search_Criteria_Frame").style.height="38vh";
				parent.document.getElementById("Pat_Search_Criteria_Frame").scrolling="no";
				parent.document.getElementById("Pat_Search_Toolbar_Frame").style.height="4vh";
				parent.document.getElementById("Pat_Results_Frame").style.height="40vh";
				
			}
			 
			var cr_jsp_name		=	REPLC_FORM_NAME.cr_jsp_name.value;
			var cr_window_styl =	REPLC_FORM_NAME.cr_window_styl.value;
			var cr_close_yn		=	REPLC_FORM_NAME.cr_close_yn.value;
			var cr_win_top			=	REPLC_FORM_NAME.cr_win_top.value;
			var cr_win_width		=	REPLC_FORM_NAME.cr_win_width.value;
			var cr_win_height		=	REPLC_FORM_NAME.cr_win_height.value;
			var cr_act_yn			=	REPLC_FORM_NAME.cr_act_yn.value;
			var cr_srr					=	REPLC_FORM_NAME.cr_srr.value;
			var cr_func_act				=	REPLC_FORM_NAME.cr_func_act.value;
			var cr_defaultgender			=	REPLC_FORM_NAME.cr_defaultgender.value;
			var cr_enablegenderyn		=	REPLC_FORM_NAME.cr_enablegenderyn.value;
			var cr_function_id			=	REPLC_FORM_NAME.cr_function_id.value;
			var cr_func_idpassed		=	REPLC_FORM_NAME.cr_func_idpassed.value;
			var cr_register_button_yn="";
			
			if(REPLC_FORM_NAME.cr_register_button_yn){
				cr_register_button_yn=REPLC_FORM_NAME.cr_register_button_yn.value;
			}
			var register_button_yn="";
			if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register_button_yn){
				register_button_yn=parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register_button_yn.value;
			}
			var toolbar_func_act="";
			if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_func_act){
				toolbar_func_act=parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_func_act.value
			}
			var toolbar_dr_function_id="";
			if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_dr_function_id){
				toolbar_dr_function_id=parent.Pat_Search_Toolbar_Frame.document.search_toolbar.toolbar_dr_function_id.value;
			}
			//Below line modified for this CRF HSA-CRF-0289
			parent.Pat_Search_Criteria_Frame.location.href=""+REPLC_LOC+"jsp_name="+cr_jsp_name+"&window_styl="+cr_window_styl+"&close_yn="+cr_close_yn+"&win_top="+cr_win_top+"&win_width="+cr_win_width+"&win_height="+cr_win_height+"&act_yn="+cr_act_yn+"&srr="+cr_srr+"&register_button_yn="+cr_register_button_yn+"&func_act="+cr_func_act+"&default_gender="+cr_defaultgender+"&enable_gender_yn="+cr_enablegenderyn+"&dr_function_id="+cr_function_id+"&func_idpassed="+cr_func_idpassed+"&patient_class="+patient_class+"&alterIdSearch="+alterIdSearch+"&isAlternateId="+isAlternateId;
			parent.Pat_Search_Toolbar_Frame.location.href = "../jsp/SearchToolbar.jsp?register_button_yn="+register_button_yn+"&func_act="+toolbar_func_act+"&dr_function_id="+toolbar_dr_function_id;
			parent.Pat_Results_Frame.location.href = '../../eCommon/html/blank.html'
			parent.colurFrame.location.href = '../../eCommon/html/blank.html'
			parent.messageFrame.location.href = '../../eCommon/html/blank.html'
	}
		
		// bellow function added by Vedesh A D for edge Converstion 
		function closeWidow()
		{
			/* Code Added by Vedesh A D for Edge Conversion */
			var dialogTagFrame = "";
			var dialogBodyFrame = "";
			const diagElement = top.document.getElementsByTagName("dialog");
            var i = 0; var j = 0;
            for (i = 0; i < diagElement.length; i++) 
    		{
            	for (j = 0; j < diagElement[i].children.length; j++) 
				{
            		var element = diagElement[i].children[j];
            		let dialogSrc = element.src;
            		if (typeof dialogSrc !== "undefined")
            		{ 
        	    		if (dialogSrc.includes("ModelPatientSearch.jsp") )
        	        	{
        	    			dialogTagFrame = diagElement[i];
        	    			dialogTagFrame.close();
        	        	}
            		}    		
            	} 
            }
		}
		
</Script>
</head>
<body class="COMMON_TOOLBAR" leftmargin='0' topmargin='0' onKeyDown = 'lockKey()'>
	<table border=0 cellpadding=0 cellspacing=0 width="100%">
		<tr>
			<td class="COMMON_TOOLBAR" width="50%">
					<input type='button' onclick="resetform()" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class='BUTTON'></input>
					<input type='button' onclick="closeWidow()" value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' class='BUTTON'></input>
			</td>
			<td class="COMMON_TOOLBAR" align="right" width="50%">
			</td>
		</tr>
	</table>
</body>
</html>

