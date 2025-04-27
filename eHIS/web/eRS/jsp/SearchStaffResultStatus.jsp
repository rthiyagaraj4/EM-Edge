<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	22 nov 2004
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<%
	String staff_id= request.getParameter("staff_id");
	String role_type=request.getParameter("role_type");
%>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> 
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
var currentLink = new String();
currentLink = "experience_link";
function objClick(objName,role_type, staff_id)
{		//alert("objName"+objName);
		//selectTab(objName);
	   	changeLink(objName);
      	if (objName == 'experience_link')
		{	
			/*document.getElementById("experience_link").className = "tabClicked";
			document.getElementById("skill_link").className	   = "tabA";	
			document.getElementById("licensure_link").className = "tabA";
			document.getElementById("training_link").className = "tabA";

			document.getElementById("experience_link_aspan").className = "tabSpanclicked";
			document.getElementById("skill_link_aspan").className	   = "tabAspan";	
			document.getElementById("licensure_link_aspan").className = "tabAspan";
			document.getElementById("training_link_aspan").className = "tabAspan";*/

			var url="../../eRS/jsp/StaffExperience.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
			var dialogHeight  = "28" ;
    var dialogWidth = "50" ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = window.showModalDialog( url, arguments, features ) ;
			document.getElementById("experience_link").className = "tabA";
			document.getElementById("experience_link_aspan").className = "tabAspan";
        }
    	else if(objName == 'skill_link')
    	{    
			/*alert('name is  --- '+document.forms[0].name);
			alert('class is --- '+document.getElementById("experience_link").className);
			alert('class is --- '+document.getElementById("skill_link").className);
			document.getElementById("experience_link").className = "tabA";
			document.getElementById("skill_link").className	   = "tabClicked";	
			document.getElementById("licensure_link").className = "tabA";
			document.getElementById("training_link").className = "tabA";

			document.getElementById("experience_link_aspan").className = "tabAspan";
			document.getElementById("skill_link_aspan").className	   = "tabSpanclicked";	
			document.getElementById("licensure_link_aspan").className = "tabAspan";
			document.getElementById("training_link_aspan").className = "tabAspan";*/

			var url="../../eRS/jsp/StaffSkills.jsp?staff_id="+staff_id+"&role_type="+ role_type;
			var dialogHeight  = "28" ;
    var dialogWidth = "50" ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = window.showModalDialog( url, arguments, features ) ;
	document.getElementById("skill_link").className	   = "tabA";
	document.getElementById("skill_link_aspan").className	   = "tabAspan";

    	}
		else if(objName == 'training_link')
    	{
			/*
			document.getElementById("experience_link").className = "tabA";
			document.getElementById("skill_link").className	   = "tabA";	
			document.getElementById("licensure_link").className = "tabA";
			document.getElementById("training_link").className = "tabClicked";

			document.getElementById("experience_link_aspan").className = "tabAspan";
			document.getElementById("skill_link_aspan").className	   = "tabAspan";	
			document.getElementById("licensure_link_aspan").className = "tabAspan";
			document.getElementById("training_link_aspan").className = "tabSpanclicked";*/


			var url="../../eRS/jsp/StaffTraining.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
			var dialogHeight  = "28" ;
    var dialogWidth = "50" ;
	var dialogTop	= '120';
	var dialogLeft = '5' ;
    var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
    var reportURL   = window.showModalDialog( url, arguments, features ) ;
	document.getElementById("training_link").className = "tabA";
    document.getElementById("training_link_aspan").className = "tabAspan";
	}
		else if(objName == 'licensure_link')
      	{
			var url="../../eRS/jsp/StaffLicensure.jsp?staff_id="+staff_id+"&role_type="+ role_type;	
			var dialogHeight  = "28" ;
			var dialogWidth = "50" ;
			var dialogTop	= '120';
			var dialogLeft = '5' ;
			var arguments   = "" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
			var reportURL   = window.showModalDialog( url, arguments, features ) ;
			document.getElementById("licensure_link").className = "tabA";
			document.getElementById("licensure_link_aspan").className = "tabAspan";
      	}

   }
/***************************************************************/
	function changeLink(LinkName) {
		//alert("LinkName-------->"+LinkName)
			if (currentLink=='experience_link')
			{		//alert("Experience link");
				document.getElementById("experience_link").className = "tabClicked";
				document.getElementById("skill_link").className	   = "tabA";	
				document.getElementById("licensure_link").className = "tabA";
				document.getElementById("training_link").className = "tabA";

				document.getElementById("experience_link_aspan").className = "tabSpanclicked";
				document.getElementById("skill_link_aspan").className	   = "tabAspan";	
				document.getElementById("licensure_link_aspan").className = "tabAspan";
				document.getElementById("training_link_aspan").className = "tabAspan";
			}
	      	else if (currentLink=='skill_link')
			{	//alert("skill link");
				/*alert('name is  --- '+document.forms[0].name);
				alert('class is --- '+document.getElementById("experience_link").className);
				alert('class is --- '+document.getElementById("skill_link").className);*/
				
				document.getElementById("skill_link").className	   ="tabClicked";
				document.getElementById("experience_link").className = "tabA";
				document.getElementById("licensure_link").className = "tabA";
				document.getElementById("training_link").className = "tabA";

				document.getElementById("experience_link_aspan").className = "tabAspan";
				document.getElementById("skill_link_aspan").className	   = "tabSpanclicked";
				document.getElementById("licensure_link_aspan").className = "tabAspan";
				document.getElementById("training_link_aspan").className = "tabAspan";
		  		

			}
			else if (currentLink=='training_link')
			{	//alert("training link");
				document.getElementById("experience_link").className = "tabA";
				document.getElementById("skill_link").className	   = "tabA";	
				document.getElementById("licensure_link").className = "tabA";
				document.getElementById("training_link").className = "tabClicked";

				document.getElementById("experience_link_aspan").className = "tabAspan";
				document.getElementById("skill_link_aspan").className	   = "tabAspan";	
				document.getElementById("licensure_link_aspan").className = "tabAspan";
				document.getElementById("training_link_aspan").className = "tabSpanclicked";
			}
	      	else if (currentLink=='licensure_link')
		  	{		//alert("licensure_link");
					document.getElementById("experience_link").className = "tabA";
					document.getElementById("skill_link").className	   = "tabA";	
					document.getElementById("licensure_link").className = "tabClicked";
					document.getElementById("training_link").className = "tabA";

					document.getElementById("experience_link_aspan").className = "tabAspan";
					document.getElementById("skill_link_aspan").className	   = "tabAspan";	
					document.getElementById("licensure_link_aspan").className = "tabSpanclicked";
					document.getElementById("training_link_aspan").className = "tabAspan";
			}
			
			if(LinkName=='experience_link')
			{		//alert("experience in link name. link");
				document.getElementById("experience_link").className = "tabClicked";
				document.getElementById("skill_link").className	   = "tabA";	
				document.getElementById("licensure_link").className = "tabA";
				document.getElementById("training_link").className = "tabA";

				document.getElementById("experience_link_aspan").className = "tabSpanclicked";
				document.getElementById("skill_link_aspan").className	   = "tabAspan";	
				document.getElementById("licensure_link_aspan").className = "tabAspan";
				document.getElementById("training_link_aspan").className = "tabAspan";
			}
			else if(LinkName=='skill_link')
			{
				//alert("skill in link name. link");
				/*alert('name is  --- '+document.forms[0].name);
				alert('class is --- '+document.getElementById("experience_link").className);
				alert('class is --- '+document.getElementById("skill_link").className);*/
				
				document.getElementById("skill_link").className	   = "tabClicked";
				document.getElementById("experience_link").className = "tabA";
				document.getElementById("licensure_link").className = "tabA";
				document.getElementById("training_link").className = "tabA";

				document.getElementById("experience_link_aspan").className = "tabAspan";
				document.getElementById("skill_link_aspan").className	   = "tabSpanclicked";	
				document.getElementById("licensure_link_aspan").className = "tabAspan";
				document.getElementById("training_link_aspan").className = "tabAspan";
			}	
			if(LinkName=='licensure_link')
			{
					//alert("licensure_link in link name. ");
					document.getElementById("experience_link").className = "tabA";
					document.getElementById("skill_link").className	   = "tabA";	
					document.getElementById("licensure_link").className = "tabClicked";
					document.getElementById("training_link").className = "tabA";

					document.getElementById("experience_link_aspan").className = "tabAspan";
					document.getElementById("skill_link_aspan").className	   = "tabAspan";	
					document.getElementById("licensure_link_aspan").className = "tabSpanclicked";
					document.getElementById("training_link_aspan").className = "tabAspan";
			}	
			else if(LinkName=='training_link')
			{
					//alert("training_link in link name. ");
					document.getElementById("experience_link").className = "tabA";
					document.getElementById("skill_link").className	   = "tabA";	
					document.getElementById("licensure_link").className = "tabA";
					document.getElementById("training_link").className = "tabClicked";

					document.getElementById("experience_link_aspan").className = "tabAspan";
					document.getElementById("skill_link_aspan").className	   = "tabAspan";	
					document.getElementById("licensure_link_aspan").className = "tabAspan";
					document.getElementById("training_link_aspan").className = "tabSpanclicked";
			}
					
			currentLink = LinkName;
			//alert("currentLink="+currentLink);
		}
</script>
</head>
	<body>
			<form name='form_tab' id='form_tab'>
				<ul id="tablist" class="tablist" >
				<li class="tablistitem" title="Experience">
				<a onclick="javascript:objClick('experience_link','<%=role_type%>','<%=staff_id%>') " class="tabA" id="experience_link">
				<span class="tabAspan" id="experience_link_aspan"><fmt:message  key="eRS.Experience.label" bundle="${rs_labels}"/></span>
				</a>
				</li>
      
				<li class="tablistitem" title="Skill">
				 <a onclick="javascript:objClick('skill_link','<%=role_type%>','<%=staff_id%>')" class="tabA" id="skill_link" >
				<span class="tabAspan" id="skill_link_aspan"><fmt:message key="eRS.Skill.label" bundle="${rs_labels}"/></span>
				</a>																			
				</li>
				<li class="tablistitem" title="Licensure">
				<a onclick="javascript:objClick('licensure_link','<%=role_type%>','<%=staff_id%>')"  class="tabA" id="licensure_link" >
				<span class="tabAspan" id="licensure_link_aspan"><fmt:message key="eRS.Licensure.label" bundle="${rs_labels}"/></span>
				</a>
				</li>
				<li class="tablistitem" title="Training">
				<a onclick="javascript:objClick('training_link','<%=role_type%>','<%=staff_id%>')"  class="tabA" id="training_link" >
				 <span class="tabAspan" id="training_link_aspan"><fmt:message key="eRS.Training.label" bundle="${rs_labels}"/></span>
				</a>
				</li>
	   
				 </ul>
				
		</form>

	</body>
</html>

