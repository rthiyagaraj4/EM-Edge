<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> -->

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String imgUrl="";
		//String strqry=request.getQueryString();
		//out.println("strqry "+strqry);
		if(sStyle.equals("IeStyle.css"))
		 {
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
		 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
			 {
				styleMap = "Blue";
			 }
			 else if(sStyle.equals("IeStyleLime.css"))
			 {
				styleMap = "Lime";
			 }
			 else if(sStyle.equals("IeStyleOrange.css"))
			 {
				styleMap = "Orange";
			 }
			 else if(sStyle.equals("IeStyleVoilet.css"))
			 {
				styleMap = "Violet";
			 }
			 else
			 {
				styleMap = "";
			 }
			
			//out.println("Query string "+request.getQueryString());
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<style type='text/css'>
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
	</style>
	<script>
function loadFilterFunction(obj)
{
	parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href='../../eCommon/html/blank.html';
	if(obj.value != '')
	{
		var arr = new Array();
		arr = obj.value.split("|");
		var pre_ql_ref = arr[0];
		var qs= parent.RecClinicalNotesPrevFilterCriteriaFrame.document.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value;
		if(arr[1].indexOf("?") != -1)
		{
			parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href=arr[1]+'&'+qs+"&pre_ql_ref="+pre_ql_ref;				
		}
		else
		{
			parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href=arr[1]+'?'+qs+"&pre_ql_ref="+pre_ql_ref;	
		
		}
	}
	else
	{
		var executable_path = document.RecClinicalNotesPrevNotesFilterCriteriaForm.executable_path.value;
		var qs = parent.RecClinicalNotesPrevFilterCriteriaFrame.document.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value;
		if(executable_path.indexOf("?") != -1)
		{
			parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.document.location.href = executable_path+'&default_yn=N&'+qs;
			
		}
		else
		{
			parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.document.location.href = executable_path+'?default_yn=N&'+qs;
		}
		
	}
}

async function UpdateFilter()
{
	parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href='../../eCommon/html/blank.html';
	var function_id = "PREVIOUS_NOTES";
	/*
	var dialogHeight= "31" ;
	var dialogWidth	= "35" ;
	var dialogTop	= "150";
	var dialogLeft	= "200";
	*/

	var dialogHeight= "65vh" ;
	var dialogWidth	= "35vw" ;
	var dialogTop	= "0vh";
	var dialogLeft	= "0vw";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";
	var ret = await window.showModalDialog("../../eCA/jsp/QuickLinksForRespCustomize.jsp?<%=request.getQueryString()%>&link_type=F&prev_notes_called_from="+function_id,arguments,features);
	
	if(ret != '' && ret != undefined)
	{
		if(document.RecClinicalNotesPrevNotesFilterCriteriaForm.filter != null)
		{
			var optlength =document.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.options.length;
			for (var i=0; i<optlength; i++)
			{
				document.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.options.remove("filter");
			}
			var HTMLVal="<html><body><form name='QuickLinksUpdateDescForm' id='QuickLinksUpdateDescForm' method='post' action='../../eCA/jsp/QuickLinksForRespUpdateFilter.jsp'>"+
			"<input type='hidden' name='function_id' id='function_id' value='"+function_id+"'>"+
			"</form></body></html>";
			parent.messageframe.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageframe.document.QuickLinksUpdateDescForm.submit();
			
		}
	}
}
	</script>
	</head>
<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='RecClinicalNotesPrevNotesFilterCriteriaForm' id='RecClinicalNotesPrevNotesFilterCriteriaForm'>
<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	StringBuffer	query_string		=	new StringBuffer(request.getQueryString());
	String	from_date_time		=	"",		to_date_time		=	"";
	String appl_task_id		=	"";
	String resp_id			=	(String)		session.getValue("responsibility_id");
	appl_task_id          =   request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String function_id	= "PREVIOUS_NOTES";
		
	int Existance_Count = 0;
	StringBuffer sqlQuery	= new StringBuffer();
	String sql = "";		
	String login_user	= (String)session.getValue("login_user");
	String pre_ql_ref = "";
				
	try
	{
		//query_string	=	request.getQueryString();		
		con				=	ConnectionManager.getConnection(request);
		to_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		from_date_time		=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,1,"d");	
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr class='iconBarRow<%=styleMap%>'>
		<td id='dispname'><b><fmt:message key="eCA.ViewPreviousNotes.label" bundle="${ca_labels}"/></b></td>
		<td id='filter_by' align='right'><img src="../../eCA/images/filter.gif" name='filterImg' alt='Filter' /> : <select name='filter' id='filter' onchange='loadFilterFunction(this)'>
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
				//sql = "select 1 Existance_Count from SM_QUICK_LINK_FOR_USER where APPL_USER_ID = ? and  rownum=1 and OPTION_ID =? ";
				//sql = "SELECT 1 existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.default_yn = 'Y' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y' AND ROWNUM = 1 ";
				sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";

				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1,login_user);
				pstmt.setString(2,resp_id);
				pstmt.setString(3,function_id);
				pstmt.setString(4,locale);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					Existance_Count = rs.getInt("EXISTANCE_COUNT");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				sqlQuery.append("select a.quick_link_ref Quick_Link_Ref, C.quick_link_description, B.EXECUTABLE_NAME,a.DEFAULT_YN from ");
				if(Existance_Count>0)//changed
					sqlQuery.append(" SM_QUICK_LINK_FOR_USER A ");
				else
					sqlQuery.append(" SM_QUICK_LINK_RESP A ");
				sqlQuery.append(", CA_OPTION B,sm_quick_link_list_lang_vw  C where  c.LANGUAGE_ID = '"+locale+"' and B.option_id = ? and c.FUNCTION_SPEC_YN ='Y' AND B.OPTION_ID  = A.OPTION_ID AND C.QUICK_LINK_REF=A.QUICK_LINK_REF AND C.eff_STATUS='E' AND ");
				if(Existance_Count>0)//changed
					sqlQuery.append(" A.APPL_USER_ID=?  ");
				else
					sqlQuery.append(" A.RESP_ID=?  ");
				sqlQuery.append(" and LINK_TYPE = 'F' order by 2 ");
						
				pstmt = con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,function_id);
				if(Existance_Count>0)//changed
					pstmt.setString(2,login_user);
				else
					pstmt.setString(2,resp_id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					%>
					<option value="<%=rs.getString("Quick_Link_Ref")%>|<%=rs.getString("EXECUTABLE_NAME")%>" <%if(rs.getString("DEFAULT_YN").equals("Y")){%>selected<%}%>><%=rs.getString("quick_link_description")%></option>
				<%								
						if(rs.getString("DEFAULT_YN").equals("Y"))
							pre_ql_ref = rs.getString("Quick_Link_Ref");
					}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			
			%>
			</select><a href="#"><img src="../../eCA/images/customize.gif" alt='<fmt:message key="eCA.CustomiseFilter.label" bundle="${ca_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='UpdateFilter()' height='18'/></a>&nbsp;&nbsp;
		<input type='hidden' name='function_id' id='function_id' value=''><input type='hidden' name='executable_path' id='executable_path' value='RecClinicalNotesPrevNotesSearchCriteria.jsp'></td>
</tr>
</table>
<input type='hidden' name='locale' id='locale'	value='<%=locale%>'>
	<input type='hidden' name='operation_mode' id='operation_mode'	value=''>
	<input type='hidden' name='query_string' id='query_string'	value="<%=query_string.toString()%>">
	<input type='hidden' name='appl_task_id' id='appl_task_id'	value="<%=appl_task_id%>">
	<input type='hidden' name='from_date_time' id='from_date_time' value="<%=from_date_time%>">
	<input type='hidden' name='to_date_time' id='to_date_time' value="<%=to_date_time%>">

</form>
</center>
<%}
	catch(Exception e)
	{
		//out.println("Exception@2: "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		%>
		</select></td>
</body>
<script language='javascript'>
	parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href = "../../eCA/jsp/RecClinicalNotesPrevNotesSearchCriteria.jsp?<%=query_string%>&pre_ql_ref=<%=pre_ql_ref%>";


</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</html>

