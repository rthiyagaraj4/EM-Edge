<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	
try{

%>

<html>

<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
	function Disabelfields(obj,obj1,obj2,obj3,obj4)
	{
			if(obj.checked==true){
			document.forms[0].Open_Wound.disabled=false;
			}
			else{
			document.forms[0].Open_Wound.disabled=true;
			}

			if(obj1.checked==true){
			document.forms[0].Open_Pneumothroax.disabled=false;
			}
			else{
			document.forms[0].Open_Pneumothroax.disabled=true;
		    }

			if(obj2.checked==true){
			document.forms[0].Air_Entry_right.disabled=false;
			document.forms[0].Air_Entry_left.disabled=false;
			}
			else{
			document.forms[0].Air_Entry_right.disabled=true;
			document.forms[0].Air_Entry_left.disabled=true;
			}

			if(obj3.checked==true){
			document.forms[0].volume_in_ml.disabled=false;
			document.forms[0].Chest_Tube_in_Situ.disabled=false;
			}
			else{
			document.forms[0].volume_in_ml.disabled=true;
			document.forms[0].Chest_Tube_in_Situ.disabled=true;
			}

			if(obj4.checked==true){
			document.forms[0].Bony_Crepitus.disabled=false;
			}
			else{
			document.forms[0].Bony_Crepitus.disabled=true;
			}
			
	}


	var currentLink = new String();
	currentLink = "Upper";


	function objClick(objName)
	{

		changeLink(objName);
			if (objName == 'Upper')
		{
			moveToLink(1);
			document.forms[0].Facial_Fracture.focus();
		}
		else if(objName == 'lower')
		{
				moveToLink(2);
				document.forms[0].Tone.focus();
		}
		else if(objName == 'other_attr')
		{
				moveToLink(3);
				document.forms[0].Wide_Mediastinum.focus();
		}
		
	}



	function changeLink(LinkName) 
	{
		if (currentLink =='Upper')
		{

		document.getElementById("Upper").src='../../eAE/images/Upper_click.gif';
		}
		else if (currentLink =='lower')
		{	
		
			document.getElementById("lower").src='../../eAE/images/Lower_click.gif';
		}
		
		else if (currentLink =='other_attr')
		{			
			document.getElementById("other_attr").src='../../eAE/images/Others_click.gif';
		}

		

		if(LinkName=='Upper')
		{	
			document.getElementById("Upper").src='../../eAE/images/Upper.gif';
		}
		else if(LinkName=='lower')
		{	

			document.getElementById("lower").src='../../eAE/images/Lower.gif';
		}
		else if(LinkName=='other_attr')
		{	
			
			document.getElementById("other_attr").src='../../eAE/images/Others.gif';
			
		}
		
		currentLink = LinkName;
	}



	function moveToLink(LinkIndex)
	{

		if(LinkIndex==1)
			document.getElementById("upper_view").scrollIntoView();
		else if(LinkIndex==2)
			document.getElementById("lower_view").scrollIntoView();
		else if(LinkIndex==3)
			document.getElementById("otherdetail").scrollIntoView();
		
	}
			


</script>
</head>

   <body onLoad=' objClick("Upper");Disabelfields(document.forms[0].Open_Wound_yn,document.forms[0].Open_Pneumothroax_yn,document.forms[0].Air_Entry,document.forms[0].Chest_Tube_in_Situ_yn,document.forms[0].Bony_Crepitus_yn)' onKeyDown = 'lockKey()'>


<form name="Secondary_form" id="Secondary_form" action="../../servlet/eAE.SecondaryAssessmentServlet" method="post" target="messageFrame">

 <a name='upper_view'></a>
<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
    
      <tr>
         <td width='22%'>&nbsp;</td>
        <td >&nbsp;</td>
        <td >&nbsp;</td>
        <td width='28%'>&nbsp;</td>
		
      </tr>
	  
      <tr>
        <td class="label" align='right'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='Clinic' id='Clinic'></td>
          <td class="label" align='right'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='treatment_area' id='treatment_area'></td>
       </tr>
	   <tr>
        <td class="label" align='right'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='exam _date_time' id='exam _date_time'></td>
          <td class="label" align='right'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
        <td align='left' colspan='2'>&nbsp;<select name='practitioner' id='practitioner' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		</select></td>
       </tr>
</table>
	  <table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%'>
		<tr>
			<td>&nbsp;</td>
			<td width='100%' align='left'>
			<a href="javascript:objClick('Upper');"  alt='Upper' name='inv_char'><img name='Upper' border='0' src='../../eAE/images/Upper.gif' ></img></a><a href="javascript:objClick('lower');" alt='lower'  name='trn_char'><img name='lower' border='0' src='../../eAE/images/Lower_click.gif'  ></img></a><a href="javascript:objClick('other_attr');" alt='other_attr'  name='other_char'><img name='other_attr' border='0' src='../../eAE/images/Others_click.gif'  ></img></a>
			</td>
		</tr>
	
     </table>
	 
	 <table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
     	<tr>
          <th colspan='6' align='left'><fmt:message key="eAE.HeadNeck.label" bundle="${ae_labels}"/></th>
    </tr>
    <tr>
        <td class="label" align='right'><fmt:message key="eAE.FacialFracture.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' class="label"  name='Facial_Fracture' id='Facial_Fracture' ></td>
       <td class="label" align='right'><fmt:message key="eAE.CervicalCollar.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox'  name='cervical_collar' id='cervical_collar' ></td>
		</td>
		</tr>
		<tr>
        <td class="label" align='right'><fmt:message key="eAE.CSpineTenderness.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Spine_Tenderness' id='Spine_Tenderness' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		
		</select></td>
		
		<td class="label" align='right'><fmt:message key="eAE.CSpineFracture.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Spine_Fracture' id='Spine_Fracture' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		
		</select></td>
      </tr> 
      <tr>
        <td class="label" align='right'><fmt:message key="eAE.GTubeNasal.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' class="label"  name='Tube_Nasal' id='Tube_Nasal' ></td>
       <td class="label" align='right'><fmt:message key="eAE.GTubeOral.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox'  name='Tube_Oral' id='Tube_Oral' ></td>
		</td>
      </tr>
	  
	  <tr>
          <th colspan='6' align='left'><fmt:message key="eAE.Chest.label" bundle="${ae_labels}"/></th>
  
      </tr>
	 
	  <tr>
        <td class="label" align='right'><fmt:message key="eAE.OpenWound.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' name='Open_Wound_yn' id='Open_Wound_yn' onClick='Disabelfields(Open_Wound_yn,Open_Pneumothroax_yn,Air_Entry,Chest_Tube_in_Situ_yn,Bony_Crepitus_yn)'  >
		<select name='Open_Wound' id='Open_Wound' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	
		<option value='B'><fmt:message key="eAE.Right.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		
		</select></td>
		
		<td class="label" align='right' nowrap><fmt:message key="eAE.OpenPneumothroax.label" bundle="${ae_labels}"/></td>
		<td align='left' >&nbsp;<input type='checkbox'   name='Open_Pneumothroax_yn' id='Open_Pneumothroax_yn' onClick='Disabelfields(Open_Wound_yn,Open_Pneumothroax_yn,Air_Entry,Chest_Tube_in_Situ_yn,Bony_Crepitus_yn)' >
		<select name='Open_Pneumothroax' id='Open_Pneumothroax' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Right.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
		
		
		</select></td>
      </tr>
	 
	  <tr>
        <td class="label" align='right'><fmt:message key="eAE.AirEntryRight.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox'  name='Air_Entry' id='Air_Entry' onClick='Disabelfields(Open_Wound_yn,Open_Pneumothroax_yn,Air_Entry,Chest_Tube_in_Situ_yn,Bony_Crepitus)' >
		<select name='Air_Entry_right' id='Air_Entry_right' >
		
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.Decreased.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Absent.label" bundle="${ae_labels}"/></option>
		
		</select></td>
		
		<td class="label" align='right' nowrap><fmt:message key="Common.Left.label" bundle="${common_labels}"/></td>
		<td align='left'>&nbsp;<select name='Air_Entry_left' id='Air_Entry_left' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.Decreased.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Absent.label" bundle="${ae_labels}"/></option>
		
		</select></td>
      </tr>
	   <tr>
        <td class="label" align='right'><fmt:message key="eAE.ChestTubeinSitu.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' name='Chest_Tube_in_Situ_yn' id='Chest_Tube_in_Situ_yn'  onClick='Disabelfields(Open_Wound_yn,Open_Pneumothroax_yn,Air_Entry,Chest_Tube_in_Situ_yn,Bony_Crepitus_yn)' >
		<input type='text' size='10' maxlength='10' name='volume_in_ml' id='volume_in_ml'></td>
		<td class="label" align='right' nowrap>&nbsp;</td>
		<td align='left'>&nbsp;<select name='Chest_Tube_in_Situ' id='Chest_Tube_in_Situ' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Right.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
		</select></td>
      </tr>
	 
	  
	   <tr>
        <td class="label" align='right'><fmt:message key="eAE.SubEmphysema.label" bundle="${ae_labels}"/></td>
         <td align='left' >&nbsp;<input type='checkbox' name='Emphysema' id='Emphysema'></td>
          <td class="label" align='right'><fmt:message key="eAE.BonyCrepitus.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' name='Bony_Crepitus_yn' id='Bony_Crepitus_yn'  onClick='Disabelfields(Open_Wound_yn,Open_Pneumothroax_yn,Air_Entry,Chest_Tube_in_Situ_yn,Bony_Crepitus_yn)' >&nbsp;<select name='Bony_Crepitus' id='Bony_Crepitus' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Right.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
		
		</td>
       </tr>
	   <tr>
        
		<td class="label" align='right'><fmt:message key="eAE.RibFracture.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Rib_Fracture' id='Rib_Fracture' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Right.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
		</select></td>
		
		<td class="label" align='right'><fmt:message key="eAE.FlailSegment.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Flail_Segment' id='Flail_Segment' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Right.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.Central.label" bundle="${common_labels}"/></option>
		</select></td>
      </tr> 
	  
	  <tr>
          <th colspan='6' align='left'><fmt:message key="eAE.Abdomen.label" bundle="${ae_labels}"/></th>
       </tr>
	  <tr >
        <td class="label" align='right'><fmt:message key="eAE.OpenWounds.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' name='Open_Wounds' id='Open_Wounds'></td>
		<td class="label" align='right'><fmt:message key="eAE.PreviousSurgery.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' name='Previous_Surgery' id='Previous_Surgery'></td>

       </tr>
	   
	  <tr >
        <td class="label" align='right'><fmt:message key="eAE.Distended.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='checkbox' name='Distended' id='Distended'></td>
		<td class="label" align='right'><fmt:message key="eAE.Tense.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='Tense' ></td>

       </tr>
	    <tr >
        <td class="label" align='right'><fmt:message key="eAE.Tenderness.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='Tenderness' ></td>
		<td class="label" align='right'><fmt:message key="eAE.Rigidity.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='Rigidity' ></td>

       </tr>
	  <tr>
        
		<td class="label" align='right'><fmt:message key="eAE.Diffuse.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Diffuse' id='Diffuse' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.RUQ.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.LUQ.label" bundle="${ae_labels}"/></option>
		</select></td>
		
		<td class="label" align='right'><fmt:message key="eAE.Suprapubic.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Suprapubic' id='Suprapubic' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.RLQ.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.LLQ.label" bundle="${ae_labels}"/></option>
		</select></td>
      </tr> 
	  
	   <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        
      </tr>

	   <tr align='right'><td colspan='6' class='BODYCOLORFILLED' align="right" ><input type=button name='Record' id='Record' value=" Record "   class='Button'  ><input type=button name='Reset' id='Reset' value=" Reset "   class='Button'  ><input type=button name='Close' id='Close' value=" Close "   class='Button' ></td>
	   </tr>
	   </table>
	     <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
	  <a name='lower_view'></a>
<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >
    
     <tr>
         <td width='21%'>&nbsp;</td>
         <td >&nbsp;</td>
        <td >&nbsp;</td>
		<td >&nbsp;</td>
        <td >&nbsp;</td>
        <td width='23%'>&nbsp;</td>
        
        
      </tr>
	  
	  
      <tr>
        <td class="label" align='right'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='Clinic' id='Clinic'></td>
		<td >&nbsp;</td>
		<td >&nbsp;</td>
          <td class="label" align='right'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='treatment_area' id='treatment_area'></td>
       </tr>
	   <tr>
        <td class="label" align='right'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='exam _date_time' id='exam _date_time'></td>
		<td >&nbsp;</td>
		<td >&nbsp;</td>
          <td class="label" align='right'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
        <td align='left' colspan='2'>&nbsp;<select name='practitioner' id='practitioner' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		</select></td>
       </tr>
</table>
	  <table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%'>
		<tr>
			<td>&nbsp;</td>
			<td width='100%' align='left'>
			<a href="javascript:objClick('Upper');"  alt='Upper' name='inv_char'><img name='Upper' border='0' src='../../eAE/images/Upper_click.gif' ></img></a><a href="javascript:objClick('lower');" alt='lower'  name='trn_char'><img name='lower' border='0' src='../../eAE/images/Lower.gif'  ></img></a><a href="javascript:objClick('other_attr');" alt='other_attr'  name='other_char'><img name='other_attr' border='0' src='../../eAE/images/Others_click.gif'  ></img></a>
			</td>
		</tr>
	
     </table>
	  <TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	  <tr>
          <th colspan='6' align='left'><fmt:message key="eAE.Rectal.label" bundle="${ae_labels}"/></th>
       </tr>
	   <tr>
         <td width='24%'>&nbsp;</td>
         <td >&nbsp;</td>
        <td >&nbsp;</td>
		<td >&nbsp;</td>
        <td >&nbsp;</td>
        <td width='27%'>&nbsp;</td>
        
        
      </tr>
	  
	  <tr>

		<td class="label" align='right'><fmt:message key="eAE.Tone.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<select name='Tone' id='Tone' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
		<option value='R'><fmt:message key="eAE.Reduced.label" bundle="${ae_labels}"/></option>
		<option value='A'><fmt:message key="eAE.Absent.label" bundle="${ae_labels}"/></option>
		</select></td>
		<td >&nbsp;</td>
		<td >&nbsp;</td>
		<td class="label" align='right' ><fmt:message key="eAE.BulbocavemousReflex.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<select name='Bulbocavemous_Reflex' id='Bulbocavemous_Reflex' >
		<option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="Common.Positive.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.Negative.label" bundle="${common_labels}"/></option>
		
		</select></td>
		
      </tr> 

	  <tr>
		<td class="label" align='right'><fmt:message key="eAE.Prostrate.label" bundle="${ae_labels}"/></td>
        <td align='left' colspan='3'>&nbsp;<select name='Prostrate' id='Prostrate' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="Common.High.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
		
		</select></td>
      
		<td class="label" align='right'><fmt:message key="eAE.RectalInjury.label" bundle="${ae_labels}"/></td>
      	<td align='left'  valign='center'>&nbsp;<input type='checkbox' name='Rectal_Injury' id='Rectal_Injury'></td>
		
		
      </tr> 
	  <tr><td colspan='6'>&nbsp;</td></tr>
	  <tr>
          <th colspan='6' align='left'><fmt:message key="eAE.Pelvis.label" bundle="${ae_labels}"/></th>
       </tr>
	   <tr><td colspan='6'>&nbsp;</td></tr>
	  <tr >

		<td class="label"  align='right'>&nbsp;</td>
		<td align='left' width='27%'>&nbsp;<select name='pupil_reaction' id='pupil_reaction' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Stable.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Unstable.label" bundle="${ae_labels}"/></option>
		
		</select></td>
		<td class="label"  align='right'><fmt:message key="eAE.Fracture.label" bundle="${ae_labels}"/></td>
        <td align='left'  valign='center'>&nbsp;<input type='checkbox' name='Pupil _Size_left' id='Pupil _Size_left'></td>
       <td class="label"  align='right'><fmt:message key="eAE.FractureDislocation.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<input type='checkbox'  name='Pupil _Size_right' id='Pupil _Size_right'></td>
       </tr>
	   <tr><td colspan='6'>&nbsp;</td></tr>
	   <tr>
          <th colspan='6' align='left'><fmt:message key="eAE.Spine.label" bundle="${ae_labels}"/></th>
       </tr>
	   <tr><td colspan='6'>&nbsp;</td></tr>
	  <tr >
        
		<td class="label"  align='right'>&nbsp;</td>
		<td align='left' width='27%'>&nbsp;<select name='pupil_reaction' id='pupil_reaction' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Stable.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Unstable.label" bundle="${ae_labels}"/></option>
		
		</select></td>
		<td class="label"  align='right'><fmt:message key="eAE.Fracture.label" bundle="${ae_labels}"/></td>
        <td align='left'  valign='center'>&nbsp;<input type='checkbox' name='Pupil _Size_left' id='Pupil _Size_left'></td>
       <td class="label"  align='right'><fmt:message key="eAE.FractureDislocation.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<input type='checkbox'  name='Pupil _Size_right' id='Pupil _Size_right'></td>
       </tr>
	   <tr><td colspan='6'>&nbsp;</td></tr>
      
	   <tr>
          <th colspan='6' align='left'><fmt:message key="eAE.GenitoUrinary.label" bundle="${ae_labels}"/></th>
       </tr>
	   <tr><td colspan='6'>&nbsp;</td></tr>
	  <tr >
        
		
		<td class="label" align='right'><fmt:message key="eAE.Catheterin.label" bundle="${ae_labels}"/></td>
		
        <td align='left'  valign='center'>&nbsp;<input type='checkbox' name='Pupil _Size_left' id='Pupil _Size_left'></td>
        <td class="label" align='right' nowrap><fmt:message key="eAE.BloodAtMeatus.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<input type='checkbox'  name='Pupil_Size_right' id='Pupil_Size_right'></td>
		 <td class="label" align='right'><fmt:message key="eAE.Haematura.label" bundle="${ae_labels}"/></td>
		<td align='left' width='27%'>&nbsp;<select name='pupil_reaction' id='pupil_reaction' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Brisk.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Sluggish.label" bundle="${ae_labels}"/></option>
		<option value='F'><fmt:message key="eAE.NonResp.label" bundle="${ae_labels}"/></option>
		</select></td>
       </tr>
	   <tr><td colspan='6'>&nbsp;</td></tr>
  </table>
  <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br><br> <br>
 
   
	  <a name='otherdetail'></a>
<table align="center" cellPadding="0" border='1' cellSpacing="0" width="100%" >
    
      <tr>
         <td width='33%'>&nbsp;</td>
        <td width='20%'>&nbsp;</td>
        <td width='18%'>&nbsp;</td>
        <td width='25%'>&nbsp;</td>
		
      </tr>
      <tr>
        <td class="label" align='right'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='Clinic' id='Clinic'></td>
          <td class="label" align='right'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='treatment_area' id='treatment_area'></td>
       </tr>
	   <tr>
        <td class="label" align='right'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
        <td align='left' >&nbsp;<input type='text' size='10' maxlength='10' name='exam _date_time' id='exam _date_time'></td>
          <td class="label" align='right'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
        <td align='left' colspan='2'>&nbsp;<select name='practitioner' id='practitioner' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		</select></td>
       </tr>
</table>
	  <table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%'>
		<tr>
			<td>&nbsp;</td>
			<td width='100%' align='left'>
			<a href="javascript:objClick('Upper');"  alt='Upper' name='inv_char'><img name='Upper' border='0' src='../../eAE/images/Upper_click.gif' ></img></a><a href="javascript:objClick('lower');" alt='lower'  name='trn_char'><img name='lower' border='0' src='../../eAE/images/Lower_click.gif'  ></img></a><a href="javascript:objClick('other_attr');" alt='other_attr'  name='other_char'><img name='other_attr' border='0' src='../../eAE/images/Others.gif'  ></img></a>
			</td>
		</tr>
	 
     </table>
	  <TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='1'>
	  <tr>
          <th colspan='4' align='left'><fmt:message key="eAE.Vascular.label" bundle="${ae_labels}"/></th>
       </tr>
	    <tr>
         <td width='45%'>&nbsp;</td>
        <td >&nbsp;</td>
        <td  >&nbsp;</td>
        <td width='29%'>&nbsp;</td>
		
      </tr>
	  
	  <tr>
        
		<td class="label" align='right' nowrap>Wide Mediastinum ( Chest X Ray )</td>
        <td align='left'  valign='center' colspan='4'>&nbsp;<input type='checkbox' name='Wide_Mediastinum' id='Wide_Mediastinum'></td>
		
      </tr> 

	  <tr>
		<td class="label" align='right'><fmt:message key="eAE.LimbColour.label" bundle="${ae_labels}"/></td>
        <td align='left' colspan='4'>&nbsp;<select name='Limb_Colour' id='Limb_Colour' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Pale.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Hyper.label" bundle="${ae_labels}"/></option>
		</select></td>
      </tr>
	  <tr>
		<td class="label" align='right'><fmt:message key="eAE.PulsesRight.label" bundle="${ae_labels}"/></td>
        <td align='left'>&nbsp;<select name='Pulses_Right' id='Pulses_Right' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Radial.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Brachial.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Femoral.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Popliteal.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Pedal.label" bundle="${ae_labels}"/></option>
		</select></td>
		<td class="label" align='right'><fmt:message key="Common.Left.label" bundle="${common_labels}"/></td>
		<td class="label" align='left'>&nbsp;
		<select name='Pulses_left' id='Pulses_left' >
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
		<option value='B'><fmt:message key="eAE.Radial.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Brachial.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Femoral.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Popliteal.label" bundle="${ae_labels}"/></option>
		<option value='V'><fmt:message key="eAE.Pedal.label" bundle="${ae_labels}"/></option>
		</select></td>
      </tr>
	
	  <tr><td colspan='4'>&nbsp;</td></tr>
	  <tr>
          <th colspan='4' align='left'><fmt:message key="eAE.Extremities.label" bundle="${ae_labels}"/></th>
       </tr>
	   <tr><td colspan='4'>&nbsp;</td></tr>
	  <tr >
         <td class="label"  width='24%' align='right'><fmt:message key="eAE.OpenWounds.label" bundle="${ae_labels}"/></td>
        <td align='left'  valign='center' colspan='4'>&nbsp;<input type='checkbox' name='Open_Wounds' id='Open_Wounds'></td>
       </tr>
	  <tr >
        <td class="label"  width='24%' align='right'><fmt:message key="eAE.FracturesList.label" bundle="${ae_labels}"/></td>
		<td align='left' colspan='4'>&nbsp;<textarea name='Fractures_List' rows='3' cols='50' >
		</textarea></td>
       </tr>
	   <tr >
        <td class="label"  width='24%' align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td align='left' colspan='4'>&nbsp;<textarea name='remarks' rows='3' cols='50' >
		</textarea></td>
       </tr>
	   <tr><td colspan='4'>&nbsp;</td></tr>
  </table>
  <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br><br> 
</form>

</body>

</html>
<%
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

