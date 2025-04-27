<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	25 Oct 2004
-->
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<%
	String staff_id= request.getParameter("staff_id");
	String role_type=request.getParameter("role_type");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
	var currentLink = new String();
   	currentLink = "experience_link";
	function objClick(objName,role_type, staff_id) {
	   	changeLink(objName);
      	if (objName == 'experience_link'){
			parent.frames[1].location.href="../../eRS/jsp/StaffExperience.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
		}
    	else if(objName == 'skill_link'){    		
			parent.frames[1].location.href="../../eRS/jsp/StaffSkills.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
    	}
		else if(objName == 'training_link'){
			parent.frames[1].location.href="../../eRS/jsp/StaffTraining.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
    	}
		else if(objName == 'licensure_link'){
			parent.frames[1].location.href="../../eRS/jsp/StaffLicensure.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
      	}

   }
/***************************************************************/
	function changeLink(LinkName) {
			if (currentLink=='experience_link')
				document.getElementById("experience_link").src='../../eRS/images/Experience_click.gif';
	      	else if (currentLink=='skill_link')
		  		document.getElementById("skill_link").src = '../../eRS/images/Skill_click.gif';
			else if (currentLink=='training_link')
				document.getElementById("training_link").src='../../eRS/images/Training_click.gif';
	      	else if (currentLink=='licensure_link')
		  		document.getElementById("licensure_link").src = '../../eRS/images/Licensure_click.gif';

			if(LinkName=='experience_link')
				document.getElementById("experience_link").src='../../eRS/images/Experience.gif';
			else if(LinkName=='skill_link')
				document.getElementById("skill_link").src='../../eRS/images/Skill.gif';
			if(LinkName=='training_link')
				document.getElementById("training_link").src='../../eRS/images/Training.gif';
			else if(LinkName=='licensure_link')
				document.getElementById("licensure_link").src='../../eRS/images/Licensure.gif';
			currentLink = LinkName;

		}
</script>
</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name='form_tab' id='form_tab'>
			<table name='insert_tab' id='insert_tab' cellspacing='0' cellpadding='0' border='0' width='*'>
				<tr>
					<td align='right' >
					<a href="javascript:objClick('experience_link','<%=role_type%>','<%=staff_id%>') " alt='Experience'><img name= 'experience_link' border='0' src='../../eRS/images/Experience.gif' alt='Experience' ></img></a></td>
					<td align='left'>
					<a href="javascript:objClick('skill_link','<%=role_type%>','<%=staff_id%>')"    alt='Skill'> <img name='skill_link' border='0' src='../../eRS/images/Skill_click.gif' alt='Skill' onBlur='changeFocus()'  ></img></a></td>
					<td align='left'>
					<a href="javascript:objClick('licensure_link','<%=role_type%>','<%=staff_id%>')"    alt='Licensure'> <img name='licensure_link' border='0' src='../../eRS/images/Licensure_click.gif' alt='Licensure' onBlur='changeFocus()'  ></img></a>
					<td align='right' >
			<a  href="javascript:objClick('training_link','<%=role_type%>','<%=staff_id%>') " alt='Training'><img name= 'training_link' border='0' src='../../eRS/images/Training_click.gif' alt='Training'   ></img></a></td>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

