<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.PharmacistHomeBean, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
%>
<html>
	<head>	
<%
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<STYLE TYPE="text/css">
			A.imageClass1 
			{
				width:30px;
				height:28px;
				margin-left:0;
				margin-right:0;
				margin-top:0;
				margin-bottom:0;
				padding-left:3px;
				padding-right:3px;
				padding-top:2px;
				padding-bottom:1px;
				border-top:0px;
			}
			A.imageClass2 
			{
				background-color:#FFFFFF;
				width:30px;
				height:28px;
				margin-left:0;
				margin-right:0;
				margin-top:0;
				margin-bottom:0;
				padding-left:2px;
				padding-right:2px;
				padding-top:2px;
				padding-bottom:1px;
				border-left:1px solid;
				border-right:1px solid;
				BORDER-COLOR: #75768B;
			}
			img
			{
				border:0;
			}

			TR.iconBarRow
			{
				BACKGROUND-image: url('../../eCommon/images/toolBarBG.jpg');
				width:1024;
				height:28px;
				border-bottom:none;
			}
			TR.iconBarRowBlue
			{
				BACKGROUND-image: url('../../eCommon/images/toolBarBGBlue.jpg');
				width:1024;
				height:28px;
				border-bottom:none;
			}
			TR.iconBarRowLime
			{
				BACKGROUND-image: url('../../eCommon/images/toolBarBGLime.jpg');
				width:1024;
				height:28px;
				border-bottom:none;
			}
			TR.iconBarRowOrange
			{
				BACKGROUND-image: url('../../eCommon/images/toolBarBGOrange.jpg');
				width:1024;
				height:28px;
				border-bottom:none;
			}
			TR.iconBarRowViolet
			{
				BACKGROUND-image: url('../../eCommon/images/toolBarBGViolet.jpg');
				width:1024;
				height:28px;
				border-bottom:none;
			}
			IMG.imageClass
			{
				vertical-align: middle;
			}

		</STYLE>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../ePH/js/PharmacistHome.js' language='javascript'></script>
		<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		try{
			String bean_id   = "PharmacistHomeBean" ;
			String bean_name = "ePH.PharmacistHomeBean";
			PharmacistHomeBean bean = (PharmacistHomeBean)getBeanObject( bean_id, bean_name, request ) ;

			StringBuffer strBuffPatientInfo = new StringBuffer();
			String respid= request.getParameter("responsibility_id");
			String lookup_window_name = request.getParameter("lookup_window_name")==null?"":request.getParameter("lookup_window_name");			
			String function_display_name = request.getParameter("function_display_name")==null?"":request.getParameter("function_display_name");
			String window_name = request.getParameter("window_name")==null?"":request.getParameter("window_name");
			String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
			String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
			String strRelnYn		= request.getParameter("RelnYn")==null?"Y":request.getParameter("RelnYn");

			if (from_service_yn.equals("") )
				from_service_yn="N";
			
			String limit_function_id = request.getParameter("limit_function_id")==null?"":request.getParameter("limit_function_id");
			String chartTitle = request.getParameter("chartTitle")== null?"":request.getParameter("chartTitle");
            String name=(String)session.getValue("practitioner_name");
			String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
			String pract_type =(String) session.getValue("practitioner_type");
			String menu_Active = "N";

			String dektop_params="";
			String desktop_id="",userdef_desktop_desc="";
			String dfltFunctionId="";			
			String altText="", wname="";
			
			//ArrayList dfltDesktopDtl = bean.getDesktopDtl(respid);THIS NEED TO UNCOMMENT
			ArrayList dfltDesktopDtl = bean.getDesktopDtl();

			if(dfltDesktopDtl!=null && dfltDesktopDtl.size()>0){
				desktop_id			 = (String)dfltDesktopDtl.get(0);
				userdef_desktop_desc = (String)dfltDesktopDtl.get(1);
				dfltFunctionId		 =(String)dfltDesktopDtl.get(2);
			}

             String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
             String queryString = request.getQueryString()== null?"":request.getQueryString() ;
             String defmode = mode;
			
			 String facility_id      = (String)session.getValue( "facility_id" ) ;
			 String menu_id="MED_DFLT",patientclass="",speciality_code="";

			 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
				styleMap = "Blue";
			 else if(sStyle.equals("IeStyleLime.css"))
				styleMap = "Lime";
			 else if(sStyle.equals("IeStyleOrange.css"))
				styleMap = "Orange";
			 else if(sStyle.equals("IeStyleVoilet.css"))
				styleMap = "Violet";
%>

	<script>
		function MM_preloadImages(){ 
			var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
			var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
			if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
		}

		function MM_swapImgRestore(){ 
			var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
		}

		function MM_findObj(n, d){
			var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
			d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
			if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
			 for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
			if(!x && d.getElementById) x=d.getElementById(n); return x;
		}

		function MM_swapImage(){
			var i,j=0,x,a=MM_swapImage.arguments;
			document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
			if ((x=MM_findObj(a[i]))!=null){
			  document.MM_sr[j++]=x; 
			  if(!x.oSrc) x.oSrc=x.src; 
			  x.src=a[i+2];
			}
		}

		function closeFunction(childyn,wname,flag){
			window.location.href = '../../eCommon/jsp/dmenu.jsp';
			parent.location.href ="../../eCommon/jsp/maindisplay.jsp";
		}
	</script>
	</head>
	<body class="COMMON_TOOLBAR" leftmargin=0 topmargin=0 onKeyDown="lockKey()" OnMouseDown='CodeArrest()' >
		<table width="100%" cellspacing='0' cellpadding='0' border='0'>
			<tr class='iconBarRow<%=styleMap%>'>
	<%
		if(lookupFileName.equals("") && limit_function_id.equals("")){
	%>
			<td width='5%'>
				<input type='button' name='clipTxtBtn' id='clipTxtBtn' style='display:none' value='Clip Text'>
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr class='iconBarRow<%=styleMap%>'>
				<%
					if(menu_Active.equals("N") && lookupFileName.equals("")){
				%>
						<td><a href="#" name='Menu' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img align='center' src='../../eCA/images/MI_Show.gif' name='ShowMenu' style='<%=limit_function_id.equals("")?"display:inline":"display:none"%>' onclick="loadOrUnloadMenus(this)" accesskey='M' alt='<fmt:message key="eCA.ShowMenu.label" bundle="${ca_labels}"/>'></img>
						<img align='center' src='../../eCA/images/MI_Hide.gif' name='HideMenu' style='display:none'  onclick="loadOrUnloadMenus(this)" accesskey='M' alt='<fmt:message key="eCA.HideMenu.label" bundle="${ca_labels}"/>'></img></a></td>
						
				<%
					}
					if(lookupFileName.equals("") && from_service_yn.equals("N"))
					{
												
				%>		
							<td id="home" class='iconBarRow<%=styleMap%>'><a href="#" name='Home' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img onclick="loadHomePage('','<%=dfltFunctionId%>' ,loadOrUnloadMenus(document.ShowMenu))" id='searchPatHome' src='../../eCA/images/MI_Home.gif' align='center' alt= '<fmt:message key="eCA.HOMEPAGE.label" bundle="${ca_labels}"/>'></img></a></td>
				<%				
					}	
					
					if(from_service_yn.equals("N") && lookupFileName.equals("")&& limit_function_id.equals(""))
					{
				%>
						<td class='iconBarRow<%=styleMap%>'><a href="#" name='ClinicalCalc' class="imageClass1" onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img align='center' src='../../eCA/images/MI_ClinicalCalc.gif' onclick="callCalculator()" alt='<fmt:message key="eCA.ClinicalCalculator.label" bundle="${ca_labels}"/>'></img></a></td>
				<%
					}
				%>
					<td ><img align='center' name='divider' id='divider' src='../../eCA/images/MI_htStrip<%=styleMap%>.gif' alt='' ></img></td>	
					
					</tr></table>
					</td>
					<td class='' align='right' width='40%'><table border="0" cellspacing="0" cellpadding="0"><tr class='iconBarRow<%=styleMap%>'>
					<%
					if(lookupFileName.equals("") && limit_function_id.equals(""))
						{
					%>

						<td class='iconBarRow<%=styleMap%>' align='right' id='quick' >
						<select name='quick_links' id='quick_links'  onchange='loadFunction(this)' style='FONT-SIZE:8pt'>
						<option value = ''>-----<fmt:message key="eCA.QuickLinks.label" bundle="${ca_labels}"/>-----</option>
					<%
						/*if(detl_sql.length() > 0)
							detl_sql.delete(0,detl_sql.length());

						detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF from sm_quick_link_list_lang_vw A, CA_OPTION B,sm_quick_link_resp d,");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' and a.added_facility_id = '"+facility_id+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND B.OPTION_ID(+)=A.OPTION_ID AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND B.EXECUTABLE_NAME IS NOT NULL AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'Q'");
							detl_sql.append(" and B.DESKTOP_YN(+) = 'N' ");
							if(mode.equals("V"))
								detl_sql.append(" and b.HIST_OR_RECORD = 'H' ");
						detl_sql.append(" and exists (select 1 from ca_appl_task ia where OPTION_ID(+) = a.OPTION_ID and  GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) = 'A' and (ia.BASE_MODULE_ID = 'CA' or exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
						
						detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF  from sm_quick_link_list_lang_vw A,sm_quick_link_resp d, ");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						//detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' order by 2");//IN29822
						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' and a.added_facility_id = '"+facility_id+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? order by 2");//IN29822 //IN035499
						

						pstmt = con.prepareStatement(detl_sql.toString());
						int val = 0;
						if(Existance_Count>0){
							pstmt.setString(++val,login_user);

						}
						else
							{
							pstmt.setString(++val,resp_id);

							}
						pstmt.setString(++val,resp_id);//IN29822
						pstmt.setString(++val,resp_id);
						pstmt.setString(++val,reln_id);
						pstmt.setString(++val,facility_id);
						pstmt.setString(++val,episode_id);
						

						if(!patient_id.equals(""))
						{
							pstmt.setString(++val,splty_code);

						}

						if(Existance_Count>0)
							pstmt.setString(++val,login_user);
						else
							pstmt.setString(++val,resp_id);
						pstmt.setString(++val,resp_id);//IN29822
						
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							
							executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
							if(!executable_name.equals("")){
								if (executable_name.indexOf("~PATIENT_ID`") >= 0){
										executable_name = executable_name.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (executable_name.indexOf("~ENCOUNTER_ID`")>=0){
										executable_name = executable_name.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (executable_name.indexOf("~FACILITY_ID`")>= 0){
										executable_name = executable_name.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (executable_name.indexOf("~NRIC`")>= 0){
										executable_name = executable_name.replaceAll("~NRIC`",nric_code);
								}
							}
							v_query_string = rs.getString("QUERY_STRING")==null?"":rs.getString("QUERY_STRING");
							if(!v_query_string.equals("")){
								
								if (v_query_string.indexOf("~PATIENT_ID`") >= 0){
										v_query_string = v_query_string.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (v_query_string.indexOf("~ENCOUNTER_ID`")>=0){
										v_query_string = v_query_string.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (v_query_string.indexOf("~FACILITY_ID`")>= 0){
										v_query_string = v_query_string.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (v_query_string.indexOf("~NRIC`")>= 0){
										v_query_string = v_query_string.replaceAll("~NRIC`",nric_code);
								}
							} 							
							option_id.delete(0,option_id.length());
							option_id.append(rs.getString("OPTION_ID"));
							option_id.append("|");
							option_id.append(rs.getString("QUICK_LINK_TYPE"));
							option_id.append("|");
							option_id.append(rs.getString("LONG_DESC"));
							
							option_id.append("|");							
							option_id.append(executable_name);
							option_id.append("|");//IN036367
							option_id.append(rs.getString("QUICK_LINK_REF"));//IN036367
							if(!v_query_string.equals("")){ 
								option_id.append("?");							
								option_id.append(v_query_string);
							}
						}*/
				%>
						</select></td>
						<td><a href="#" name='RightStripQL' onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('RightStrip1','','../../eCA/images/MI_RightStrip1<%=styleMap%>.gif',1)"><img src="../../eCA/images/MI_RightStrip2<%=styleMap%>.gif" alt='<fmt:message key="eCA.CustomiseLinks.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='UpdateResp()' style='<%=limit_function_id.equals("")?"display:inline":"display:none"%>' /></a>&nbsp;&nbsp;</td>
				<%
						}
				%>

					</tr>
					</table>
				</td>
			<%
				}
			%>
      	
		<td align='right' width='3%'><table border="0" cellspacing="0" cellpadding="0" align='right'>
		<tr class='iconBarRow<%=styleMap%>'>
		<td>
		<img class='imageClass' id='seperator' src='../../eCA/images/MI_htStrip<%=styleMap%>.gif' alt=''></img><td>

		<td><img class = 'imageClass' align='center' src='../../eCA/images/MI_SwitchT1.gif' onclick="switchToLogin()" alt='Switch Store' id='switch_store' name='switch_store' style="margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;"></img></td>

	
		<td><img class = 'imageClass' align='center' src='../../eCA/images/MI_CloseT1.gif' onclick="closeFunction('','<%=wname%>','Y')" alt='<%=altText%>' id='close' name='close' style="margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;"></img></td>

		</tr></table>
		</td>

    </tr>
</table>
<table width="100%" cellspacing='0' cellpadding='0' border='0'>
	<tr>
		<td class='iconBarRow<%=styleMap%>' id='dispname'><%=function_display_name%></td>
		<td class='iconBarRow<%=styleMap%>' id='filter_by' style='display:none' align='right'><img src="../../eCA/images/filter.gif" name='filterImg' alt='Filter' /> : <select name='filter' id='filter' onchange='loadFilterFunction(this)'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select><a href="#"><img src="../../eCA/images/customize.gif" alt='<fmt:message key="eCA.CustomiseFilter.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='UpdateFilter()' /></a>&nbsp;&nbsp;
		<input type='hidden' name='function_id' id='function_id' value=''><input type='hidden' name='executable_path' id='executable_path' value=''></td>
		<td class ='LABELRIGHT' id='myTask' style='display:none'><fmt:message key="eCA.MyTaskList.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="eCA.Detailsason.label" bundle="${ca_labels}"/>&nbsp;<%=com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale)%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href='javascript:refresh();'><u><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></u></A></td>
	</tr>
</table>

<form name='homePageParam' id='homePageParam' >
    <input type='hidden' name='desktop_id' id='desktop_id' value='<%=desktop_id%>'>
    <input type='hidden' name='dfltFunctionId' id='dfltFunctionId' value='<%=dfltFunctionId%>'>
	 <input type='hidden' name='menuId' id='menuId' value='<%=menu_id%>'>  
</form>


</body>
<script>

async function customizeIcons()
{	
	var dialogHeight= "420px" ;
	var dialogWidth	= "380px" ;
	var dialogTop	= "105";
	var dialogLeft	= "350";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no ";

	var ret = await window.showModalDialog("../../eCA/jsp/CAMainCustomizeToolbar.jsp?<%=request.getQueryString()%>&menuId=<%=menu_id%>&patientclass=<%=patientclass%>",arguments,features);
	
	if(ret != '' && ret != undefined)
	{
		displayIcons(ret);
	}
}
function displayIcons(tableVal)
{
	tableVal = tableVal.replace(/~/g,'"');
	//refreshIcons.innerHTML = tableVal;

}
async function UpdateResp()
{	
	var dialogHeight= "50vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop	= "150";
	var dialogLeft	= "200";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

	var ret = await window.showModalDialog("../../eCA/jsp/QuickLinksForRespCustomize.jsp?<%=request.getQueryString()%>&link_type=Q&patientclass=<%=patientclass%>",arguments,features);
	
	if(ret != '' && ret != undefined)
	{

		if(parent.CommonToolbar.quick_links != null)
		{
			var optlength = parent.CommonToolbar.quick_links.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.quick_links.options.remove("quick_links");
			}
			var HTMLVal="<html><body><form name='QuickLinksUpdateDescForm' id='QuickLinksUpdateDescForm' method='post' action='../../eCA/jsp/QuickLinksForRespUpdateDesc.jsp?<%=request.getQueryString()%>'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.QuickLinksUpdateDescForm.submit();
		}
	}
}
async function UpdateFilter()
{
	var function_id = parent.CommonToolbar.function_id.value;
	var dialogHeight= "40vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop	= "150";
	var dialogLeft	= "200";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

	var ret = await window.showModalDialog("../../eCA/jsp/QuickLinksForRespCustomize.jsp?function_id="+function_id+"&<%=request.getQueryString()%>&link_type=F",arguments,features);
	
	if(ret != '' && ret != undefined)
	{
		if(parent.CommonToolbar.filter != null)
		{
			var optlength = parent.CommonToolbar.filter.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.filter.options.remove("filter");
			}

			var HTMLVal="<html><body><form name='QuickLinksUpdateDescForm' id='QuickLinksUpdateDescForm' method='post' action='../../eCA/jsp/QuickLinksForRespUpdateFilter.jsp'>"+
			"<input type='hidden' name='function_id' id='function_id' value='"+function_id+"'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.QuickLinksUpdateDescForm.submit();
		}
	}
}
</script>

<%
			if(menu_Active.equals("N") && lookupFileName.equals("")){
%>
				<script>
					loadOrUnloadMenus(document.ShowMenu);
					parent.menuFrame.location.href='../../ePH/jsp/PharmacistHomeMenu.jsp?locale=<%=locale%>&<%=queryString%>&limit_function_id=<%=limit_function_id%>&dfltFunctionId=<%=dfltFunctionId%>&deskTopID=<%=desktop_id%>&userdef_desktop_desc=<%=userdef_desktop_desc%>&menuId=<%=menu_id%>';
				</script>
<%			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>

