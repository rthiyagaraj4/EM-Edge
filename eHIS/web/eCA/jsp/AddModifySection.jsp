<!DOCTYPE html>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J		26/02/2017				Ramesh G		Created new jsp file for ML-MMOH-CRF-0559
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);//MMS-ME-SCF-0038
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con=null;


String sql="";
String dis="";
String dis1="";
String mode="";
String sel="";
String mandatory_visible="";
String disableTemplate="";


String sec_hdg_desc="", sec_hdr_meta_desc="";
String content_type="";
String template_type="";
String result_linked_rec_type="";
String eff_status="";
String enabled_checked="";
String image_linked_yn_checked="";
String hist_rec_type	=	"";
String hist_rec_desc	=	"";
String image_linked_yn = "";
String image_yn	=	"";
String license_rights = "";
String preserve_yn="";
String include_filled_yn="";
String preserve_yn_checked="";
String include_filled_yn_checked="";
String outputYN="N";
String chk_outputYN ="";
String selection_type ="";
String display_order ="";
String out_dis ="disabled";
String res_dis ="disabled";
String multi_dis ="disabled";
String res_auto_lnk ="N";//IN061907
String res_auto_lnk_check_yn ="";//IN061907
eCA.SectionConfigDispFldBean sectionBean = (eCA.SectionConfigDispFldBean)session.getAttribute("SectionConfigDispFldBean");
if(sectionBean != null)
{
	sectionBean.clearBean();
}

if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
{
	license_rights= "FULL";
}
else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
{
	license_rights= "BASIC";
}
else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
{
	license_rights= "MINI";
}
//out.println("<script>alert('license_rights"+license_rights+"')</script>");
String sec_hdg_code=request.getParameter("sec_hdg_code");

if(sec_hdg_code==null) 
{
	sec_hdg_code ="";
	mode="insert";
	enabled_checked="checked";
	//image_linked_yn_checked="checked";
	preserve_yn_checked="";
	include_filled_yn_checked="";
}
else
	mode="modify";

try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
	if(!mode.equals("insert"))
	{
		dis="disabled";
		//IN061907 start
		//sql=" Select  sec_hdg_desc, content_type, result_linked_rec_type, sec_hdr_meta_desc, eff_status, image_linked_yn,PRESERVE_FORMAT_YN,INCLUDE_ONLY_FILLED_COLUMN_YN,template_type,OUTPUT_FORM_EXISTS_YN ,SELECTION_TYPE,DISPLAY_ORDER from ca_section_hdg where sec_hdg_code= ?";
		sql=" Select  sec_hdg_desc, content_type, result_linked_rec_type, sec_hdr_meta_desc, eff_status, image_linked_yn,PRESERVE_FORMAT_YN,INCLUDE_ONLY_FILLED_COLUMN_YN,template_type,OUTPUT_FORM_EXISTS_YN ,SELECTION_TYPE,DISPLAY_ORDER, AUTO_RESULT_YN from ca_section_hdg where sec_hdg_code= ?";
		//IN061907 ends
		stmt=con.prepareStatement(sql);
		stmt.setString(1,sec_hdg_code);
		
		rs=stmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				sec_hdg_desc=rs.getString("sec_hdg_desc");
				content_type=rs.getString("content_type");
				template_type=rs.getString("template_type");
				outputYN=rs.getString("OUTPUT_FORM_EXISTS_YN")==null?"N":rs.getString("OUTPUT_FORM_EXISTS_YN");
				selection_type =rs.getString("SELECTION_TYPE")==null?"N":rs.getString("SELECTION_TYPE");
				display_order =rs.getString("DISPLAY_ORDER")==null?"N":rs.getString("DISPLAY_ORDER");
				res_auto_lnk =rs.getString("AUTO_RESULT_YN")==null?"N":rs.getString("AUTO_RESULT_YN");//IN061907
				if(template_type==null)
					template_type="";
				if(content_type.equals("R") || content_type.equals("F"))
					image_yn = "";
				else
					image_yn = "disabled";
				if(content_type.equals("R"))
				{
					mandatory_visible = "'visibility:visible'";

				}

				image_linked_yn = rs.getString("image_linked_yn");
				if(image_linked_yn == null)image_linked_yn="";
				if(image_linked_yn.equals("Y"))
					image_linked_yn_checked = "checked";
				else{
					if(image_linked_yn==null) image_linked_yn="";
					image_linked_yn_checked = "";
				}
				sec_hdr_meta_desc = rs.getString("sec_hdr_meta_desc");
				if(sec_hdr_meta_desc == null)sec_hdr_meta_desc="";

				result_linked_rec_type=rs.getString("result_linked_rec_type");
				if(result_linked_rec_type==null) result_linked_rec_type="";
				
				eff_status=rs.getString("eff_status");
				if(eff_status.equals("E"))
					enabled_checked="checked";
				else
				{
					enabled_checked="";
					dis1="disabled";
				}
				preserve_yn=rs.getString("PRESERVE_FORMAT_YN");
				if(preserve_yn.equals("Y"))
					preserve_yn_checked="checked";
					//dis1="disabled";
				else
				{
					preserve_yn="N";
					preserve_yn_checked="";
					dis1="disabled";
				}

				include_filled_yn=rs.getString("INCLUDE_ONLY_FILLED_COLUMN_YN");
				if(include_filled_yn.equals("Y"))
					include_filled_yn_checked="checked";
				else
				{
					include_filled_yn="N";
					include_filled_yn_checked="";
					//dis1="disabled";
				}
				
				if(outputYN.equals("Y"))
				{
					chk_outputYN="checked" ;
						 
					out_dis =""; 
						
				}
				else
				{
					chk_outputYN ="";
					
					out_dis ="";
					
				}

				if(selection_type.equals("M"))
				{
					multi_dis="";
					image_yn="disabled";
				}
				//IN061907 start
				if(res_auto_lnk.equals("Y"))
				{
					res_auto_lnk_check_yn = "checked";
				}
				else
				{
					res_auto_lnk_check_yn = " ";	
				}
				//IN061907 ends
			}
		}
		if(content_type.equals("R") && !selection_type.equals("M")){%>
<script>
 		parent.SectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFlds.jsp?qryMode=<%=mode%>&resCategory=<%=result_linked_rec_type%>&pos1=0&pos2=0&sec_hdg_code=<%=sec_hdg_code%>";
					
</script>
	<%}
	}

%>
<html>
<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/Section.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
function PopulateCategory(obj)
{
	
	var content_type=document.forms[0].content_type.value;
	//IN061907 start
	if(content_type != "R")
	{
		document.getElementById("res_auto_link_desc").style.display = 'none';
		document.getElementById("res_auto_link_id").style.display = 'none';
	}
	//IN061907 ends
	if(content_type=="R")
	{
		//parent.confDispID.rows = "42,*,290,0,50";
		//parent.confDispID.rows = "8%,35%,*,0,6%";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="28vh";
		parent.document.getElementById("SectionConfigDispFlds").style.height="48vh";
		parent.document.getElementById("IntermediateSectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("messageFrame").style.height="9vh";
		
		parent.SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
		document.getElementById('mandatory').style.visibility = "visible";
		document.forms[0].result_linked_rec_type.disabled=false;

		document.forms[0].result_sel.disabled=false;
		//document.forms[0].disp_ord.disabled=false;
		document.forms[0].result_sel.selectedIndex=1;
		//document.getElementById('mandatory').style.visibility = "none";



		var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='PopulateCategory.jsp?content_type="+content_type+"'></form></BODY></HTML>";
		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.forms[0].submit();
	}
	else
	{
		//parent.confDispID.rows = "42,*,0,0,50";
		//parent.confDispID.rows = "8%,*,0,0,6%";
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="86vh";
		parent.document.getElementById("SectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("IntermediateSectionConfigDispFlds").style.height="0vh";
		parent.document.getElementById("messageFrame").style.height="6vh";
		
		document.getElementById('mandatory').style.visibility = "hidden";
		document.forms[0].result_linked_rec_type.disabled=true;

		document.forms[0].result_sel.value="";
		document.forms[0].result_sel.disabled=true;
		document.forms[0].disp_ord.value="";
		document.forms[0].disp_ord.disabled=true;
		document.forms[0].ord_multi.disabled=true;

	}
	delete_values(parent.frames[1].document.forms[0].result_linked_rec_type);
	if(content_type == 'R' || content_type == 'F')
	{
		if (document.forms[0].image_linked_yn){
			document.forms[0].image_linked_yn.disabled = false;
		//document.forms[0].include_filled_yn.checked=true;
		document.forms[0].image_linked_yn.checked=false; 
		document.forms[0].image_linked_yn.value=""; 
		}
	}
	else
	{
		if (document.forms[0].image_linked_yn){
			document.forms[0].image_linked_yn.disabled = true;
		//  document.forms[0].include_filled_yn.checked=true;
		  document.forms[0].image_linked_yn.checked=false;
		  document.forms[0].image_linked_yn.value="";
		}
	}
	if(content_type =='T')
	{
		if (document.forms[0].preserve_format_yn){
			document.forms[0].preserve_format_yn.disabled=false;
		}
		if (document.forms[0].include_filled_yn)
		{
			document.forms[0].include_filled_yn.disabled=false;
			document.forms[0].include_filled_yn.checked=true;
			document.forms[0].include_filled_yn.value="Y";
		}
		if(document.forms[0].template_type){
			document.forms[0].template_type.value="B";
			document.forms[0].template_type.disabled=false;
		}
		if(document.forms[0].outputYN){
			document.forms[0].outputYN.value="N";
			document.forms[0].outputYN.disabled=false;
		}
		
	}
	else
	{
		if (document.forms[0].preserve_format_yn){
			document.forms[0].preserve_format_yn.disabled=true;
		}
		if (document.forms[0].include_filled_yn)
			document.forms[0].include_filled_yn.disabled=true;
	   if (document.forms[0].preserve_format_yn)
	   {
		if(document.forms[0].preserve_format_yn.checked==true)
		{
			document.forms[0].preserve_format_yn.checked=false;
			document.forms[0].preserve_format_yn.value="N";
		}
		document.forms[0].include_filled_yn.checked=false;
		document.forms[0].include_filled_yn.value="N";
	   }
	   	if(document.forms[0].template_type){
			document.forms[0].template_type.value="";
			document.forms[0].template_type.disabled=true;
		}
		if(document.forms[0].outputYN){
			document.forms[0].outputYN.value="N";
			document.forms[0].outputYN.checked=false;
			document.forms[0].outputYN.disabled=true;
		}
	}

	
  }

  function changeTempleType(obj){

	if((obj.value != "B") && (obj.value != "") && (obj.value != '')){
			
			if (document.forms[0].include_filled_yn)
				document.forms[0].include_filled_yn.disabled=true;
		   if (document.forms[0].preserve_format_yn)
		   {	
				document.forms[0].preserve_format_yn.checked=true;
				document.forms[0].preserve_format_yn.value="Y";
				document.forms[0].preserve_format_yn.disabled=true;			
				document.forms[0].include_filled_yn.checked=false;
				document.forms[0].include_filled_yn.value="N";
		   }
	 }else{
		 document.getElementById('mandatory').style.visibility = "hidden";
		document.forms[0].result_linked_rec_type.disabled=true;
		delete_values(parent.frames[1].document.forms[0].result_linked_rec_type);
		if (document.forms[0].image_linked_yn)
		document.forms[0].image_linked_yn.disabled = true;
		//  document.forms[0].include_filled_yn.checked=true;
		document.forms[0].image_linked_yn.checked=false;
		if (document.forms[0].preserve_format_yn){
			document.forms[0].preserve_format_yn.checked=false;
			document.forms[0].preserve_format_yn.value="N";
			document.forms[0].preserve_format_yn.disabled=false;
		}
		if (document.forms[0].include_filled_yn)
		{
			document.forms[0].include_filled_yn.disabled=false;
			document.forms[0].include_filled_yn.checked=true;
			document.forms[0].include_filled_yn.value="Y";
		}

	 
	 }
  }

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt		=	parent.frames[1].document.createElement("Option");
	opt.text	=	"     ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----  ";
	opt.value	=	"";
	field.add(opt);
}
async function showImageLinkingDialog(obj)
{
	var action_url = "";
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url = '../../eCA/jsp/AddModifyImages.jsp';
	retVal				= await window.showModalDialog(action_url,arguments,features);
}

function displaySectionCongifDispFlds(obj)
{
	//IN061907 start
	if(obj.value == "DIAG")
	{
		document.getElementById("res_auto_link_desc").style='display ';
		document.getElementById("res_auto_link_id").style='display';
	}
	else
	{
		document.getElementById("res_auto_link_desc").style.display = 'none';
		document.getElementById("res_auto_link_id").style.display = 'none';
	}
	//IN061907 ends
	if(obj.value != null && !obj.value == "")
	{
		parent.SectionConfigDispFlds.location.href="../../eCA/jsp/SectionConfigDispFlds.jsp?qryMode=<%=mode%>&resCategory="+obj.value+"&pos1=0&pos2=0";
	}
	else
	{
		parent.SectionConfigDispFlds.location.href='../../eCommon/html/blank.html';
	}
}
</script>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name="Section_form" id="Section_form" action="../../servlet/eCA.SectionServlet" method="post" target="messageFrame">
<br>
<table border=0 cellspacing=0 cellpadding=3 width='75%' align=center>
<tr>
	<td class=label><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><input type="text" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>" size=4 maxlength=4 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" <%=dis%>><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><input type="text" name="sec_hdg_desc" id="sec_hdg_desc" value="<%=sec_hdg_desc%>"  size=60 maxlength=60 onBlur = "return makeValidString(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<!-- Added on 24th June 2003 Starts -->

<%
	if(license_rights.equals("FULL") || license_rights.equals("BASIC")){%>
<tr>
	<td class=label><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><input type="text" name="sec_hdr_meta_desc" id="sec_hdr_meta_desc" value="<%=sec_hdr_meta_desc%>"  size='30' maxlength='30' onBlur = "return makeValidString(this)"></td>
</tr>
<%}else if(license_rights.equals("MINI")){%>
	<input type="hidden" name="sec_hdr_meta_desc" id="sec_hdr_meta_desc" value="">
<%}%>
<!-- <tr><td>&nbsp</td><td></td></tr> -->
<!-- Added on 24th June 2003 ends -->
<tr>
		<td class=label><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td class='fields'><select name=content_type id=content_type <%=dis%> onchange='PopulateCategory(this)'>
			<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>

			<%if (content_type.equals("F")) {sel="selected";} else {sel="";}%>
			<option value='F' <%=sel%>><fmt:message key="Common.FreeFormat.label" bundle="${common_labels}"/></option>
			
			<%if(license_rights.equals("FULL") || license_rights.equals("BASIC")){%>
				<%if (content_type.equals("R")) sel="selected"; else sel="";%>
				<option value='R' <%=sel%>><fmt:message key="eCA.Resultlinked.label" bundle="${ca_labels}"/></option>
			<%}%>
			
			<%if (content_type.equals("S")) sel="selected"; else sel="";%>
			<option value='S' <%=sel%>><fmt:message key="eCA.MainSection.label" bundle="${ca_labels}"/></option>
	
			<%if(license_rights.equals("FULL") || license_rights.equals("BASIC")){%>
				<%if (content_type.equals("T")) sel="selected"; else sel="";%>
				<option value='T' <%=sel%>><fmt:message key="eCA.TemplateBased.label" bundle="${ca_labels}"/></option>
			<%}%></select><img src='../../eCommon/images/mandatory.gif'></td>
			<td class=label><fmt:message key="eCA.TemplateType.label" bundle="${ca_labels}"/></td>
			<%
				disableTemplate=dis;
			    //out_dis = dis;
			    
				if((!mode.equals("insert")) || (content_type.equals(""))){
					disableTemplate="disabled";
					//out_dis ="disabled";
				}
				if((mode.equals("modify"))&& (!content_type.equals("T")))
				{
					out_dis ="disabled";
				}


				
			%>
			<td class='fields'>
			<%if(license_rights.equals("FULL") || license_rights.equals("BASIC")){%>
			<select name="template_type" id="template_type" <%=disableTemplate%> onchange="changeTempleType(this)">
			
			<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>

			<%if (template_type.equals("H")) sel="selected"; else sel="";%>
			<option value='H' <%=sel%>><fmt:message key="eCA.NoteHeader.label" bundle="${ca_labels}"/></option>
						
			<%if (template_type.equals("F")) sel="selected"; else sel="";%>
			<option value='F' <%=sel%>><fmt:message key="eCA.NoteFooter.label" bundle="${ca_labels}"/></option>
			
			<%if (template_type.equals("B")) sel="selected"; else sel="";%>
			<option value='B' <%=sel%>><fmt:message key="eCA.NoteBody.label" bundle="${ca_labels}"/></option>

			<%if (template_type.equals("R")) sel="selected"; else sel="";%>
			<option value='R' <%=sel%>><fmt:message key="eCA.ReportHeader.label" bundle="${ca_labels}"/></option>
			
<%}else{%>
<input type='hidden' name='template_type' id='template_type' value=''>
	<%}%>		</td>
</tr>
<%if(license_rights.equals("FULL") || license_rights.equals("BASIC")){%>

<tr>
<td class=label ><fmt:message key="Common.Selection.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
<td class='fields' >
<select name= "result_sel" <%=res_dis%> onchange="changeResultSel(this)">
<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
<% if(selection_type.equals("S")) sel ="selected" ; else  sel ="";%>
<option value="S" <%=sel%>><fmt:message key="Common.single.label" bundle="${common_labels}"/></option>
<% if(selection_type.equals("M")) { sel ="selected" ; res_dis="";} else  sel ="";%>
<option value="M" <%=sel%>><fmt:message key="Common.multiple.label" bundle="${common_labels}"/></option>
</select>
</td>


<td class=label ><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
<td class='fields' >
<select name="disp_ord" id="disp_ord" <%=res_dis%>>
<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
<% if(display_order.equals("D")) sel ="selected" ; else  sel ="";%>
<option value="D" <%=sel%> ><fmt:message key="Common.ByDate.label" bundle="${common_labels}"/></option>
<% if(display_order.equals("C")) sel ="selected" ; else  sel ="";%>
<option value="C" <%=sel%> ><fmt:message key="eCA.ByCategory.label" bundle="${ca_labels}"/></option>
</select>
</td></tr>

<tr>
		<td class=label><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
		<td class='fields' ><select name=result_linked_rec_type id=result_linked_rec_type <%=dis1%> onchange="displaySectionCongifDispFlds(this);" onmousewheel='return false;' > 
			<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
			<%if(mode.equals("modify") && content_type.equals("R"))
			{
				String cat_query="select hist_rec_type, short_desc from cr_hist_rec_type order by 2";
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				stmt = con.prepareStatement(cat_query);
				rs = stmt.executeQuery();
				while(rs.next())
				{
					hist_rec_type	=	rs.getString("hist_rec_type");
					hist_rec_desc	=	rs.getString("short_desc");
					
					if(result_linked_rec_type.equals(hist_rec_type))
						out.println("<option value ="+hist_rec_type+" selected>"+hist_rec_desc+"</option>");
					else
						out.println("<option value ="+hist_rec_type+">"+hist_rec_desc+"</option>");
				}
				
			}
			%>
			</select><input type='button' name='ord_multi' id='ord_multi' value='M' class='button' onClick='callMultiWin();'  <%=multi_dis%>>
			<img style='<%=mandatory_visible.equals("")?"visibility:hidden":mandatory_visible%>' id="mandatory" src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class=label><fmt:message key="eCA.ConfigureOutput.label" bundle="${ca_labels}"/></td><td class='fields' ><input type="checkbox" name="outputYN" id="outputYN" value='<%=outputYN%>' <%=chk_outputYN%> <%=out_dis%> onClick='changeOutputYN(this)'></td>
</tr>

<tr>
<!--IN061907 start-->
	<!--<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td class='fields' colspan='3'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=enabled_checked%> dis1 onClick='check(this)'></td>-->
	
	<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=enabled_checked%> dis1 onClick='check(this)'></td>
	
	<td class=label id='res_auto_link_desc' Style='display:none'><fmt:message key="eCA.AutoFillActiveDiagnosis.label" bundle="${ca_labels}"/></td><td class='fields'><input type="checkbox" id='res_auto_link_id' name="res_auto_lnk" id="res_auto_lnk" value='' onClick='checkDiagResAutoLink(this)' <%=res_auto_lnk_check_yn%> Style='display:none'></td>
<!--IN061907 Ends-->
</tr>
<!--IN061907 start-->
<script>
resultLinkOnload();
</script>
<!--IN061907 Ends-->
<%if(!license_rights.equals("BASIC"))
{
				%>
			<tr>
					<th class='columnheader' align ="left"><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></th>
					<th class='columnheader' colspan='3'></th>
			</tr>
			<tr>
			<td  class=label colspan='0' ><fmt:message key="eCA.ImageLinked.label" bundle="${ca_labels}"/>
			</td>
			<td><input type="checkbox" name="image_linked_yn" id="image_linked_yn" <%=image_linked_yn.equals("Y")?"checked":""%>  value='<%=image_linked_yn%>' <%=image_yn%> <%=image_linked_yn_checked%> onClick='imageCheck(this)'>
			</td>
			</tr>
		<%}%>

<%if(license_rights.equals("FULL")){%>
<tr><td  class=label colspan='0'><b><fmt:message key="eCA.BuildingNotes.label" bundle="${ca_labels}"/></b></td></tr>
<td class=label colspan='0'><fmt:message key="eCA.PreserveTemplateFormat.label" bundle="${ca_labels}"/></td>
<% if( mode.equals("modify")  && content_type.equals("F") || content_type.equals("R") || content_type.equals("S") )
{
	dis1="disabled";
}	

else{dis1="";}

if(mode.equals("modify") && !(template_type.equals("B") || template_type.equals(""))){
	dis1="disabled";
}

%>
<td>
<input type="checkbox" name="preserve_format_yn" id="preserve_format_yn" value='<%=preserve_yn%>'  <%=preserve_yn_checked%> onClick='preserveyn();checkpreserve(this)' <%=dis1%>> </td>
</td>
</tr> 
<td class=label colspan='0'><fmt:message key="eCA.IncludeonlythefilledComponents.label" bundle="${ca_labels}"/></td>
 <%if(mode.equals("modify")  && preserve_yn.equals("Y") || preserve_yn.equals("N") &&  content_type.equals("F") || content_type.equals("R") || content_type.equals("S") )
	
				{
					dis1="disabled" ;
				}

				else
				{
					dis1="";
				}
			if(mode.equals("modify") && !(template_type.equals("B") || template_type.equals(""))){
				dis1="disabled";
			}
			%> 
			<td>
			<input type="checkbox" name="include_filled_yn" id="include_filled_yn" value='<%=include_filled_yn%>' <%=include_filled_yn_checked%> <%=dis1%> onClick='checkinclude(this)'  >
			</td>
</tr> 
<%}
	
}else if(license_rights.equals("MINI")){%>
<tr>
	<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=enabled_checked%> onClick='check(this)'></td>
</tr>
<tr style='visibility:hidden'>
	<td class=label><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
	<td class='fields' colspan='3'><select name=result_linked_rec_type id=result_linked_rec_type <%=dis1%>> 
	<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
			<%if(mode.equals("modify") && content_type.equals("R"))
			{
				String cat_query="select hist_rec_type, short_desc from cr_hist_rec_type order by 2";
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				stmt = con.prepareStatement(cat_query);
				rs = stmt.executeQuery();
				while(rs.next())
				{
					hist_rec_type	=	rs.getString("hist_rec_type");
					hist_rec_desc	=	rs.getString("short_desc");
					
					if(result_linked_rec_type.equals(hist_rec_type))
						out.println("<option value ="+hist_rec_type+" selected>"+hist_rec_desc+"</option>");
					else
						out.println("<option value ="+hist_rec_type+">"+hist_rec_desc+"</option>");
				}
			}
			%>
	</select><img style="visibility:hidden" id="mandatory" src="../../eCommon/images/mandatory.gif"></img>
	</td>


<%}%>
</table>


<input type='hidden' name=mode id=mode value="<%=mode%>">
<input type='hidden' name=sec_hdg_code1 id=sec_hdg_code1 value="<%=sec_hdg_code%>">
<input type='hidden' name=sec_hdg_desc1 id=sec_hdg_desc1 value="<%=sec_hdg_desc%>">
<input type='hidden' name=result_linked_rec_type1 id=result_linked_rec_type1 value="<%=result_linked_rec_type%>">
<input type="hidden" name="sec_hdr_meta_desc1" id="sec_hdr_meta_desc1" value="<%=sec_hdr_meta_desc%>">
<input type="hidden" name="include_filled_yn1" id="include_filled_yn1" value="<%=include_filled_yn%>">
<input type="hidden" name="preserve_format_yn1" id="preserve_format_yn1" value="<%=preserve_yn%>">
<input type="hidden" name="image_linked_yn1" id="image_linked_yn1" value="<%=image_linked_yn%>">
<input type="hidden" name="content_type1" id="content_type1" value="<%=content_type%>">
<input type='hidden' name='applicable' id='applicable' value='NA'>
<input type="hidden" name="res_auto_lnk_yn" id="res_auto_lnk_yn" value="<%=res_auto_lnk%>"><!--IN061907-->


</form>
</body>

</html>
<% if(mode.equals("modify") && eff_status.equals("D"))%>
<script>
	document.forms[0].preserve_format_yn.disabled=true;
	document.forms[0].include_filled_yn.disabled=true;
	document.forms[0].image_linked_yn.disabled=true;
</script>
<%

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e){
	//out.println("Exception in AddModifySection.jsp"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

