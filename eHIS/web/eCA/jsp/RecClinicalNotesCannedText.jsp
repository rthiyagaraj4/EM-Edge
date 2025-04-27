<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
19/08/2014	  IN050582 		Nijitha S											MO-GN-5452
05/10/2017	  IN063814		Krishna Gowtham	05/10/2017		Ramesh G			ML-MMOH-CRF-0810
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eCA.CannedText.label" bundle="${ca_labels}"/></title>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<!-- added by Kishore Kumar N on 10/12/2008  -->
	
	<!-- end here -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	.COLUMNHEADER1 {
		background: url("../images/headerSeparator.jpg") repeat-y;
		background-position:right;
		COLOR: white ;
		background-color:#83AAB4;
		border-bottom:4px;
		padding-left:3px;
		font-family: Verdana;
		font-size: 8pt;
		font-weight:bold;
		border-collapse:collapse;
		PADDING-TOP:5px;
		PADDING-BOTTOM:10px;
	}
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String calledFrom	=	(request.getParameter("calledFrom")==null) ?	""	:	request.getParameter("calledFrom");
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	service_code		=	"",		login_user_id	=	"";
	String	text_blk_id			=	"",		text_blk		=	"";
	String	query_canned_text	=	"",		selectBlockId	=	"";
	String	text_blk_id_name	=	"",		text_blk_name	=	"";
	String	classValue			=	"",		note_type		=	"";
	String	sec_hdg_code		=	"";
	 //[IN033180] Start.
	String textType				=	(request.getParameter("text_type")==null) ?	"T"	:	request.getParameter("text_type");
	String  textContent			=	"";
	String  EditorContent		=	"";
	if("T".equals(textType))
		textContent="checked";
	else if("E".equals(textType))
		EditorContent="checked";
	//String queryString			= request.getQueryString(); //Commented for checkstyle
	 //[IN033180] End.
	int selectIndex = 0;
	//IN063814 start
	String canned_text_count	= "";
	String canned_text			= "";
	String text_type_TE			= "";
	String more_record_YN 		= "";
	PreparedStatement	pstmt_cnt		=	null;
	ResultSet			rs_cnt			=	null;
	int 				no_of_record	= 	0;
	//IN063814 ends
%>
	<center>
	<form name='RecClinicalNotesCannedTextForm' id='RecClinicalNotesCannedTextForm'>
		<table class='grid' width='100%' >
		<tr>
			<td colspan='3' class='columnheader'>
				<!--IN063814 Start-->
				<!--<input type='radio' name='r1' id='r1' value='T' onclick='javascript:refPage();' <%=textContent %> /><fmt:message key="eCA.Text.label" bundle="${ca_labels}"/> &nbsp;&nbsp;
				<input type='radio' name='r1' id='r1' value='E' onclick='javascript:refPage();' <%=EditorContent %> /><fmt:message key="eCA.EditorText.label" bundle="${ca_labels}"/>--> 
				<input type='radio' name='r1' id='r1' value='T' id = 'txt_rd' onclick='javascript:refPage();' <%=textContent %> /><fmt:message key="eCA.Text.label" bundle="${ca_labels}"/> &nbsp;&nbsp;
				
				<input type='radio' name='r1' id='r1' value='E' id = 'edit_rd' onclick='javascript:refPage();' <%=EditorContent %>  <%if("TEMPLATES".equals(calledFrom)){%> style="display:none" <%}%>/><%if(!"TEMPLATES".equals(calledFrom)){%><fmt:message key="eCA.EditorText.label" bundle="${ca_labels}"/>  <%}%>
				
				<!--IN063814 End-->
			</td>			
		</tr>		
		<tr>
			<td class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="eCA.BlockID.label" bundle="${ca_labels}"/></td>
		</tr>
	<%
		try
		{
			con				=	ConnectionManager.getConnection(request);
			login_user_id	=	(String) session.getValue("login_user");
			String practitioner_id =(String)session.getValue("ca_practitioner_id"); //[IN038542] 

			service_code	=	(request.getParameter("service_code")==null) ?	""	:	request.getParameter("service_code");
			note_type		=	(request.getParameter("note_type")==null)	 ?	""	:	request.getParameter("note_type");
			sec_hdg_code	=	(request.getParameter("sec_hdg_code")==null) ?	""	:	request.getParameter("sec_hdg_code");

			//out.println("Query String : "+request.getQueryString());

			if(service_code==null)		service_code	= "";
			//IN063814 start
			Boolean canned_text_auto_fill_site_YN = CommonBean.isSiteSpecific(con, "CA", "CANNED_TXT_AUTO_FILL");
			if(canned_text_auto_fill_site_YN)
			{
				canned_text_count = "Select count(TEXT_TYPE), TEXT_TYPE from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL AND EFF_STATUS='E'  GROUP BY TEXT_TYPE";
				
				pstmt_cnt		=	con.prepareStatement(canned_text_count);
				
				pstmt_cnt.setString(1,service_code);
				pstmt_cnt.setString(2,service_code);
				pstmt_cnt.setString(3,practitioner_id);
				pstmt_cnt.setString(4,practitioner_id);
				pstmt_cnt.setString(5,note_type);
				pstmt_cnt.setString(6,note_type);
				pstmt_cnt.setString(7,sec_hdg_code);
				pstmt_cnt.setString(8,sec_hdg_code);
				pstmt_cnt.setString(9,locale);

				rs_cnt = pstmt_cnt.executeQuery();
				if(rs_cnt!=null)
				{
					while(rs_cnt.next())
					{
						if(no_of_record == 1)
						{
							no_of_record++;
						}
						else if(no_of_record == 0)
						{
							no_of_record 	= rs_cnt.getInt(1);
							text_type_TE	= rs_cnt.getString("TEXT_TYPE");
						}
					}
				}
				if(no_of_record == 1)
				{
					if("T".equals(text_type_TE))
					{	
						canned_text = "SELECT   text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk FROM ca_text_blk_by_serv_pract WHERE NVL (service_code, ?) = ? AND NVL (practitioner_id, ?) = ? AND NVL (note_type, ?) = ? AND NVL (sec_hdg_code, NVL (?, '***')) = NVL (?, '***') AND applicable_category = 'N' AND ca_get_desc.ca_text_blk_by_serv_pract (text_blk_id, ?, '1') IS NOT NULL AND eff_status = 'E' ORDER BY text_blk_id";
					}
					else
					{
						canned_text = "SELECT   text_blk_id, ca_get_desc.ca_text_clob_blk_by_serv_pract(text_blk_id,?,'1') text_blk FROM ca_text_blk_by_serv_pract WHERE NVL (service_code, ?) = ? AND NVL (practitioner_id, ?) = ? AND NVL (note_type, ?) = ? AND NVL (sec_hdg_code, NVL (?, '***')) = NVL (?, '***') AND applicable_category = 'N' AND ca_get_desc.ca_text_blk_by_serv_pract (text_blk_id, ?, '1') IS NOT NULL AND eff_status = 'E' ORDER BY text_blk_id";
					}
					pstmt		=	con.prepareStatement(canned_text);
					
					pstmt.setString(1,locale);
					pstmt.setString(2,service_code);
					pstmt.setString(3,service_code);
					pstmt.setString(4,practitioner_id);
					pstmt.setString(5,practitioner_id);
					pstmt.setString(6,note_type);
					pstmt.setString(7,note_type);
					pstmt.setString(8,sec_hdg_code);
					pstmt.setString(9,sec_hdg_code);
					pstmt.setString(10,locale);

					rs = pstmt.executeQuery();
				}
				else
				{
					more_record_YN = "Y";
				}	
			}
			if(!canned_text_auto_fill_site_YN || "Y".equals(more_record_YN))
			{
			//IN063814 ends
				 //[IN033180] Start.
				if("T".equals(textType)){  
					//query_canned_text = "Select text_blk_id, text_blk from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' ";
					 //[IN033180]query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N'";
					//query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='T' AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";//IN050582
					query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='T' AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL AND EFF_STATUS='E'  ORDER BY text_blk_id";//IN050582
				}else{ 
					//query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='E' AND CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";//IN050582
					query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='E' AND CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL AND EFF_STATUS='E' ORDER BY text_blk_id";//IN050582
				}
				 //[IN033180] End.
				pstmt		=	con.prepareStatement(query_canned_text);

				pstmt.setString(1,locale);
				pstmt.setString(2,service_code);
				pstmt.setString(3,service_code);
				//[IN038542] start.
				//pstmt.setString(4,login_user_id);
				//pstmt.setString(5,login_user_id);
				pstmt.setString(4,practitioner_id);
				pstmt.setString(5,practitioner_id);
				//[IN038542]  End.
				pstmt.setString(6,note_type);
				pstmt.setString(7,note_type);
				pstmt.setString(8,sec_hdg_code);
				pstmt.setString(9,sec_hdg_code);
				pstmt.setString(10,locale);

				rs			=	pstmt.executeQuery();
			}//IN063814
			classValue = "gridData";
			int i=0;
			while(rs.next())
			{
				text_blk_id		=	rs.getString("text_blk_id");
				text_blk		=	rs.getString("text_blk");
				text_blk_name		=	"text_blk"	  + selectIndex ;
				text_blk_id_name	=	"text_blk_id" + selectIndex ;
				selectBlockId		=	"block_id"	  + selectIndex ;

				/*if( (selectIndex%2)==0 )
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";*/

				selectIndex ++ ;
	%>
				<tr style="display:none"><td id="CL<%=i%>"><%=text_blk%></td></tr>
				<input type="hidden" name="TL<%=i%>" id="TL<%=i%>"  id="TL<%=i%>" value=""/>
				<tr>
					<td class='<%=classValue%>' ><input type='checkbox' name='<%=selectBlockId%>' id='<%=selectBlockId%>' value='Y'><input type='hidden' name='<%=text_blk_id_name%>' id='<%=text_blk_id_name%>' value='<%=text_blk_id%>'></td>
					<%
						StringBuffer concatRmks = new StringBuffer();
						text_blk=text_blk.replace('"','`');
						
						if(!text_blk.equals(""))
						{
							if(text_blk.length() > 100)
							{
								concatRmks.append(text_blk.substring(0,99));
								concatRmks.append("..."+"<br>");
					%>
						<script>
							var temp_text=document.getElementById("CL<%=i%>").innerText;
							if(temp_text.length>25){
							temp_text= temp_text.substring(0, 24);
							}
							document.getElementById("TL<%=i%>").value=temp_text;
						</script>
						<!--[IN033786]<td width='60%' class='<%=classValue%>'><a href="javascript:showLongDesc('<%=text_blk_name%>')" id="Temp<%=i%>"></a>-->
						<td width='60%' class='<%=classValue%>'><a href="javascript:showLongDesc_new('<%=textType%>','<%=text_blk_id%>','<%=locale%>','<%=service_code%>','<%=login_user_id%>','<%=note_type%>','<%=sec_hdg_code%>')" id="Temp<%=i%>"></a>
						<div id= '<%=text_blk_name%>' style='display:none'><pre><%=text_blk%></pre></div></td>
						<script>
							document.getElementById("Temp<%=i%>").innerHTML=document.getElementById("TL<%=i%>").value;
						</script>
							<%}
							else
							{%>
						<!--[IN033786]<td width='60%' class='<%=classValue%>'><a href="javascript:showLongDesc('<%=text_blk_name%>')"><%=text_blk%></a> -->
						<td width='60%' class='<%=classValue%>'><a href="javascript:showLongDesc_new('<%=textType%>','<%=text_blk_id%>','<%=locale%>','<%=service_code%>','<%=login_user_id%>','<%=note_type%>','<%=sec_hdg_code%>')"><%=text_blk%></a>
						<div id= '<%=text_blk_name%>' style='display:none'><pre><%=text_blk%></pre></div></td>
							<%}
						}%>		
					<td class='<%=classValue%>'><%=text_blk_id%></td>
				</tr>
				
	<%
			i++;
			} // end of while(rs.next())

		
		
			if(rs!=null) rs.close();
			if(rs_cnt!=null) rs.close(); //IN063814
			if(pstmt!=null) pstmt.close();
			if(pstmt_cnt!=null) pstmt_cnt.close(); //IN063814
		}
		catch(Exception e)
		{
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
	%>
		</table>
		<input type='hidden' name='totalBlocks' id='totalBlocks' value='<%=selectIndex%>'>
		<input type='hidden' name='text_type_TE' id='text_type_TE' value='<%=text_type_TE%>'><!--IN063814-->
		<input type='hidden' name='calledFrom' id='calledFrom' value='<%=calledFrom%>'>
	</form>
	</center>
	<!--  //[IN033180] Start.-->
	<script>
		function refPage(){
			parent.RecClinicalNotesCTFrame.location.href='../../eCA/jsp/RecClinicalNotesCannedText.jsp?service_code=<%=service_code%>&note_type=<%=note_type %>&sec_hdg_code=<%=sec_hdg_code %>&text_type='+getRadioCheckedValue('r1');
		}
		<!--IN063814 start-->
		<%
		if(no_of_record == 1)
		{
		%>
			checkFirstRec();
		<%
		}
		%>
		<!--IN063814 end-->
	</script>
	<!--  //[IN033180] End.-->
</body>
</html>

