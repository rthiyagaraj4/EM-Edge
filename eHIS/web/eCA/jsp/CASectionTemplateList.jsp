<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
29/06/2016	IN059630	Krishna	Gowtham	J							   			GHL-CRF-0401	
31/03/2017	IN061907	Krishna Gowtham J		26/02/2017		Ramesh G		ML-MMOH-CRF-0559		
---------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.io.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @09-12-2008> -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<center>
<form name='CASectionTemplateListForm' id='CASectionTemplateListForm'>
<%

	String item_type			=	"",					title_id				=	"";
	String comp_id				=	"",					prompt_id				=	"";
	String prompt_display_loc	=	"",					section					=	"";
	String classValue			=	"",					srl_no					=	"";
	String comp_type			=	"",					age_group_code			=	"";
	String hist_rec_type		=	"",					list_selection			=	"";
	String list_presentation	=	"",					hint_text			=	"";
	String num_prefix_required_yn = "",					operation_mode			=	"";
	String shift_row_num		=	"",					curr_row_num			=	"";
	String mode					=	"",					formula_result_type		=	"";
	String event_code			=	"",					querychkrowpos			=	"";
	String acceptOption			=	"",					includeyn				=	"";
	String link_to_std_value_yn	=	"",					dflt_from_hist_appl_yn	=	"";
	String update_sql			=	"",					prompt_text				=	"";


	String old_hist_time_frame_unit	=	"",				old_hist_time_frame_val =	"";
	String formula_includes_date_yn	=	"",				formula_result_unit		=	"";
	String title_text				=	"",				hint_id					=	"";
//	String comp_prompt = "";
	String text_allign_yn			=	"N";
	String auto_result_yn			=	"N"; //IN061907 
	
	int row_pos_no = 0, column_pos_no = 0, no_of_col_span = 0,i=0;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;
	operation_mode = request.getParameter("operation_mode");
	section=request.getParameter("section");

	
	
	try
	{
		con = ConnectionManager.getConnection(request);	
	}
	catch(Exception e)
	{
		
		out.println("Exception@:"+e);
	}
	
	if(operation_mode==null) 
		operation_mode="";
/********************************/
String template_type="";
if((section !=null)&& (!section.equals(""))){
	try
		{
			String sql = "select template_type from ca_section_hdg where SEC_HDG_CODE=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,section);
			rs=pstmt.executeQuery();
//			Clob formula_def_clb = null;
			if(rs.next())
			{
				template_type = rs.getString(1);
				if (template_type == null) template_type="";

			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
}
/********************************/
	if(operation_mode.equals("ShiftRow"))
	{
		shift_row_num  = request.getParameter("shift_row_num");
		curr_row_num   = request.getParameter("curr_row_num");
		mode		   = request.getParameter("mode");	
	    
		if(shift_row_num==null)shift_row_num="";
		if(curr_row_num==null)curr_row_num="";
		if(mode==null)mode="";
		
		int curr_row_no  = Integer.parseInt(curr_row_num);
		int shift_row_no = Integer.parseInt(shift_row_num);
		
		if(mode.equals("backward"))
		{
			int  curr_next_max_row_pos=0;

			querychkrowpos="select nvl(max(row_pos_no),0) curr_next_max_row_pos from ca_section_template where SEC_HDG_CODE=? and row_pos_no <?  ";
			pstmt	=	con.prepareStatement(querychkrowpos);

			pstmt.setString(1,section);
			pstmt.setString(2,curr_row_num);
			rs = pstmt.executeQuery();
			
			if (rs!=null)
			{
				if (rs.next())
					curr_next_max_row_pos=rs.getInt("curr_next_max_row_pos");
			}
			
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();

			if(curr_row_no-shift_row_no<curr_next_max_row_pos+1 )
				 out.println("<script>alert(getMessage('MIN_ROW_VAL','CA'))</script>");			
			else
			{
				update_sql="update ca_section_template set row_pos_no = row_pos_no - ? where sec_hdg_code = ? and row_pos_no >= ? ";
			}
		}
		else if(mode.equals("forward"))
		{
            int  curr_max_row_pos=0;

			querychkrowpos="select nvl(max(row_pos_no),99) curr_max_row_pos from ca_section_template where SEC_HDG_CODE=? ";

			pstmt	=	con.prepareStatement(querychkrowpos);
			pstmt.setString(1,section);
			rs = pstmt.executeQuery();
			
			if (rs!=null)
			{
				if (rs.next())
					curr_max_row_pos=rs.getInt("curr_max_row_pos");
			}

			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
	
			if(curr_max_row_pos+shift_row_no>99 )
				 out.println("<script>alert(getMessage('MAX_ROW_VAL','CA'))</script>");
			else
			{
				update_sql="update ca_section_template set row_pos_no = row_pos_no + ? where sec_hdg_code = ? and row_pos_no >= ? ";
			}
		}
	
		if(!(update_sql.equals("")))
		{
			try
			{
				if(pstmt != null)pstmt.close();
				con.setAutoCommit(false);
				pstmt	=	con.prepareStatement(update_sql);
				
				pstmt.setString(1,shift_row_num);
				pstmt.setString(2,section);
                pstmt.setString(3,curr_row_num);

				pstmt.executeUpdate();
				pstmt.close();
				String insertSQL=" update ca_section_hdg set TEMPLATE_FORMAT = empty_clob() where SEC_HDG_CODE=?";
				PreparedStatement ptmtInsert = con.prepareStatement(insertSQL);
				ptmtInsert.setString(1, section);
				ptmtInsert.executeUpdate();
				ptmtInsert.close();
				String sql = "Select TEMPLATE_FORMAT from ca_section_hdg  where SEC_HDG_CODE = ? for update "; 
				PreparedStatement ptmtInsert1 = con.prepareStatement(sql);
				ptmtInsert1.setString(1, section);					
				ResultSet rsInsert= ptmtInsert1.executeQuery() ;
				Clob clb = null;

				if(rsInsert!=null && rsInsert.next())
				{
					  clb = rsInsert.getClob(1);
				}
				//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
				BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
				eCA.SectionTemplateXMLDefinitionBean objBean = new eCA.SectionTemplateXMLDefinitionBean();
				StringBuffer XMLString=null;
				/***************/
				if((template_type==null) || (template_type.equals("")) ||(template_type.equals("B"))){
						XMLString=objBean.constructXML(con,section);
					}else{
						XMLString=objBean.constructTemplateTypeXML(con,section);
					}
				/***************/
				
				objBean = null;
				String removeSplChar=XMLString.toString();				
				w.write(removeSplChar,0,removeSplChar.length());				
				w.flush();
				w.close();
				rsInsert.close();
				ptmtInsert1.close();
				//ends here----------------			
				con.commit();
			}
			catch(Exception e)
			{
				con.rollback();
				//out.println("Exception in update query"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		}			
	}

	try
	{%>	
		<table  class='grid' width='100%' border='1' cellspacing='0' cellpadding='3' >
		<tr>
			<th class ='columnheadercenter'><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></th>
			<th class ='columnheadercenter'><fmt:message key="eCA.TitleValue.label" bundle="${ca_labels}"/></th>
			<th class ='columnheadercenter'><fmt:message key="Common.Component.label" bundle="${common_labels}"/></th>
			<th class ='columnheadercenter'><fmt:message key="eCA.Row.label" bundle="${ca_labels}"/>/<fmt:message key="eCA.Column.label" bundle="${ca_labels}"/>/<fmt:message key="eCA.Span.label" bundle="${ca_labels}"/>/<fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		</tr>
	
<%
	
		if(section==null)section="";
		//String sql = " SELECT DECODE(ITEM_TYPE, 'C', 'Component/'||NVL(DECODE(COMP_TYPE, 'C', 'Check Box', 'D', 'Date', 'T', 'Time', 'I', 'Integer Numeric', 'L', 'List', 'N', 'Decimal Numeric', 'H', 'Short Text', 'F', 'Long Text', 'E', 'Datetime', 'P', 'Embedded', 'A','Formula','R','Grid Component','X', 'Matrix Component','M','Multi-List Component'),'System'), 'T', 'Title') ITEM_TYPE,COMP_ID, PROMPT_ID,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, DECODE(PROMPT_DISPLAY_LOC, 'L', 'Left', 'T', 'Top', 'C', 'Center') PROMPT_DISPLAY_LOC, SRL_NO, COMP_TYPE, AGE_GROUP_CODE, HIST_REC_TYPE, NVL(ACCEPT_OPTION, 'O') ACCEPT_OPTION,list_presentation, list_selection, num_prefix_required_yn, HINT_ID,CASE WHEN HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(HINT_ID,'en','2') ELSE '' END HINT_TEXT,FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,nvl(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN,LINK_TO_STD_VALUE_YN ,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT,EVENT_CODE,TITLE_ID,CASE WHEN TITLE_ID IS NOT NULL then	CA_GET_DESC.CA_TEMPLATE_LABEL(TITLE_ID,'en','2')  ELSE TITLE_VALUE   END TITLE_TEXT  FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? ORDER BY ROW_POS_NO,COLUMN_POS_NO"; //IN059630_GHL-CRF-0401
		//IN061907 start
		//String sql = " SELECT DECODE(ITEM_TYPE, 'C', 'Component/'||NVL(DECODE(COMP_TYPE, 'C', 'Check Box', 'D', 'Date', 'T', 'Time', 'I', 'Integer Numeric', 'L', 'List', 'N', 'Decimal Numeric', 'H', 'Short Text', 'F', 'Long Text', 'E', 'Datetime', 'P', 'Embedded', 'A','Formula','R','Grid Component','X', 'Matrix Component','M','Multi-List Component'),'System'), 'T', 'Title') ITEM_TYPE,COMP_ID, PROMPT_ID,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, DECODE(PROMPT_DISPLAY_LOC, 'L', 'Left', 'T', 'Top', 'C', 'Center') PROMPT_DISPLAY_LOC, SRL_NO, COMP_TYPE, AGE_GROUP_CODE, HIST_REC_TYPE, NVL(ACCEPT_OPTION, 'O') ACCEPT_OPTION,list_presentation, list_selection, num_prefix_required_yn, HINT_ID,CASE WHEN HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(HINT_ID,'en','2') ELSE '' END HINT_TEXT,FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,nvl(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN,LINK_TO_STD_VALUE_YN ,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT,EVENT_CODE,TITLE_ID,CASE WHEN TITLE_ID IS NOT NULL then	CA_GET_DESC.CA_TEMPLATE_LABEL(TITLE_ID,'en','2')  ELSE TITLE_VALUE   END TITLE_TEXT,TEXT_ALLIGN_YN  FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? ORDER BY ROW_POS_NO,COLUMN_POS_NO"; //IN059630_GHL-CRF-0401
		String sql = " SELECT DECODE(ITEM_TYPE, 'C', 'Component/'||NVL(DECODE(COMP_TYPE, 'C', 'Check Box', 'D', 'Date', 'T', 'Time', 'I', 'Integer Numeric', 'L', 'List', 'N', 'Decimal Numeric', 'H', 'Short Text', 'F', 'Long Text', 'E', 'Datetime', 'P', 'Embedded', 'A','Formula','R','Grid Component','X', 'Matrix Component','M','Multi-List Component'),'System'), 'T', 'Title') ITEM_TYPE,COMP_ID, PROMPT_ID,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, DECODE(PROMPT_DISPLAY_LOC, 'L', 'Left', 'T', 'Top', 'C', 'Center') PROMPT_DISPLAY_LOC, SRL_NO, COMP_TYPE, AGE_GROUP_CODE, HIST_REC_TYPE, NVL(ACCEPT_OPTION, 'O') ACCEPT_OPTION,list_presentation, list_selection, num_prefix_required_yn, HINT_ID,CASE WHEN HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(HINT_ID,'en','2') ELSE '' END HINT_TEXT,FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,nvl(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN,LINK_TO_STD_VALUE_YN ,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT,EVENT_CODE,TITLE_ID,CASE WHEN TITLE_ID IS NOT NULL then	CA_GET_DESC.CA_TEMPLATE_LABEL(TITLE_ID,'en','2')  ELSE TITLE_VALUE   END TITLE_TEXT,TEXT_ALLIGN_YN,AUTO_RESULT_YN  FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? ORDER BY ROW_POS_NO,COLUMN_POS_NO";
		//IN061907 ends
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1,section);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			i++;
			if(i%2 != 0)
				classValue = "gridData";
			else
				classValue = "gridData";		

			item_type						=	rs.getString("ITEM_TYPE");	
			comp_id							=	rs.getString("COMP_ID")==null?"":rs.getString("COMP_ID");	

			prompt_id						=	rs.getString("PROMPT_ID")==null?"":rs.getString("PROMPT_ID");	
			title_id						=   rs.getString("TITLE_ID")==null?"":rs.getString("TITLE_ID");	
			hint_id							=   rs.getString("HINT_ID")==null?"":rs.getString("HINT_ID");	
			
			title_text						=	rs.getString("TITLE_TEXT")==null?"":rs.getString("TITLE_TEXT");	
			hint_text						=	rs.getString("HINT_TEXT")==null?"":rs.getString("HINT_TEXT");
			prompt_text						=	rs.getString("PROMPT_TEXT")==null?"":rs.getString("PROMPT_TEXT");

			row_pos_no						=	rs.getInt("ROW_POS_NO");	
			column_pos_no					=	rs.getInt("COLUMN_POS_NO");	
			no_of_col_span					=	rs.getInt("NO_OF_COL_SPAN");	
			prompt_display_loc				=	rs.getString("PROMPT_DISPLAY_LOC");	
			srl_no							=	rs.getString("SRL_NO");	
			comp_type						=	rs.getString("COMP_TYPE");
			age_group_code					=	rs.getString("AGE_GROUP_CODE")==null?"":rs.getString("AGE_GROUP_CODE");
			hist_rec_type					=	rs.getString("HIST_REC_TYPE")==null?"":rs.getString("HIST_REC_TYPE");
			acceptOption					=	rs.getString("ACCEPT_OPTION")==null?"":rs.getString("ACCEPT_OPTION");
			list_presentation				=	rs.getString("list_presentation")==null?"":rs.getString("list_presentation");
			list_selection					=	rs.getString("list_selection")==null?"":rs.getString("list_selection");

			num_prefix_required_yn			=	rs.getString("num_prefix_required_yn")==null?"":rs.getString("num_prefix_required_yn");
			formula_result_type				=	rs.getString("formula_result_type")==null?"":rs.getString("formula_result_type");
			formula_includes_date_yn		=	rs.getString("formula_includes_date_yn")==null?"":rs.getString("formula_includes_date_yn");
			formula_result_unit				=	rs.getString("formula_result_unit")==null?"":rs.getString("formula_result_unit");
			includeyn						=	rs.getString("INCLUDE_FOR_ANAL_YN")==null?"N":rs.getString("INCLUDE_FOR_ANAL_YN");
			link_to_std_value_yn			=	rs.getString("LINK_TO_STD_VALUE_YN")==null?"N":rs.getString("LINK_TO_STD_VALUE_YN");
			dflt_from_hist_appl_yn			=	rs.getString("DFLT_FROM_HIST_APPL_YN")==null?"N":rs.getString("DFLT_FROM_HIST_APPL_YN");
			old_hist_time_frame_unit		=	rs.getString("OLD_HIST_TIME_FRAME_UNIT")==null?"":rs.getString("OLD_HIST_TIME_FRAME_UNIT");
			old_hist_time_frame_val			=	rs.getString("OLD_HIST_TIME_FRAME_VAL")==null?"":rs.getString("OLD_HIST_TIME_FRAME_VAL");
			event_code						=	rs.getString("EVENT_CODE") == null ? "" : rs.getString("EVENT_CODE");
			text_allign_yn					=	rs.getString("TEXT_ALLIGN_YN"); //IN059630_GHL-CRF-0401
			auto_result_yn					= 	rs.getString("AUTO_RESULT_YN"); //IN061907	
			title_text = replaceSpecialChar(title_text);
			%>	
			<tr>
				<!--IN061907 start-->
				<!--<td  class='gridData' ><a class='gridLink'  href ='javascript:sendtoDetail("<%=item_type%>","<%=title_id%>","<%=title_text%>","<%=comp_id%>","<%=prompt_id%>","<%=row_pos_no%>","<%=column_pos_no%>","<%=no_of_col_span%>","<%=prompt_display_loc%>","<%=srl_no%>","<%=comp_type%>","<%=age_group_code%>","<%=hist_rec_type%>","<%=acceptOption%>","<%=list_selection%>","<%=list_presentation%>","<%=num_prefix_required_yn%>","<%=hint_id%>","<%=formula_result_type%>","<%=formula_includes_date_yn%>","<%=formula_result_unit%>","<%=includeyn%>","<%=link_to_std_value_yn%>","<%=dflt_from_hist_appl_yn%>","<%=old_hist_time_frame_unit%>","<%=old_hist_time_frame_val%>","<%=event_code%>","<%=prompt_text%>","<%=text_allign_yn%>")'><%=item_type%></a> <!-- added new parameter for GHL-CRF-0401 -->
				
				<td  class='gridData' ><a class='gridLink'  href ='javascript:sendtoDetail("<%=item_type%>","<%=title_id%>","<%=title_text%>","<%=comp_id%>","<%=prompt_id%>","<%=row_pos_no%>","<%=column_pos_no%>","<%=no_of_col_span%>","<%=prompt_display_loc%>","<%=srl_no%>","<%=comp_type%>","<%=age_group_code%>","<%=hist_rec_type%>","<%=acceptOption%>","<%=list_selection%>","<%=list_presentation%>","<%=num_prefix_required_yn%>","<%=hint_id%>","<%=formula_result_type%>","<%=formula_includes_date_yn%>","<%=formula_result_unit%>","<%=includeyn%>","<%=link_to_std_value_yn%>","<%=dflt_from_hist_appl_yn%>","<%=old_hist_time_frame_unit%>","<%=old_hist_time_frame_val%>","<%=event_code%>","<%=prompt_text%>","<%=text_allign_yn%>","<%=auto_result_yn%>")'><%=item_type%></a>
				<%=acceptOption.equals("R")?"<img src='../../eCommon/images/mandatory.gif' align='center'></img>":""%>
				<input type="hidden" name="temp_title_value" id="temp_title_value" value="<%=title_id%>">	
				</td>
				<%if(title_text.equals(""))
				{%>
					<td   class='<%=classValue%>' >&nbsp;</td>
				<%}
				else
				{%>
					<td   class='<%=classValue%>' ><%=title_text%></td>
				<%}
				if(prompt_text.equals(""))
				{%>
					<td  class='<%=classValue%>' >&nbsp;</td>
				<%}
				else
				{%>
					<td  class='<%=classValue%>' ><%=replaceSpecialChar(prompt_text)%></td>
				<%}%>
			<!--	<td align='right'  class='<%=classValue%>' nowrap><a href='javascript:PopUpShiftRow("<%=row_pos_no%>");'><%=row_pos_no%></a></td> -->
				<% String row_col_pos_loc = "<a class='gridLink'  href ='javascript:PopUpShiftRow("+row_pos_no+");'>"+ row_pos_no+"/"+column_pos_no+"/"+ no_of_col_span+"/"+ prompt_display_loc ;%>
				<td class='<%=classValue%>' ><%=row_col_pos_loc%></td>
			<!--	<td align='right' class='<%=classValue%>' nowrap><%=no_of_col_span%></td>
				<td align='left'  class='<%=classValue%>' nowrap><%=prompt_display_loc%></td> -->
				
			</tr>
		<%} 		
			
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	} // end of try
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception@1:"+e);//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

%>
</table>
</form>
</center>
</body>
</html>
<%!
		
	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","&quot;");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","&#39;");
		if(resultStr.indexOf("<")!=-1)
			resultStr = resultStr.replaceAll("<","&lt;");
		if(resultStr.indexOf(">")!=-1)
			resultStr = resultStr.replaceAll("<","&gt;");
		
		return resultStr;
	}


	/*String replaceSpecialChar(String resultStr)
	{		
		while(resultStr.indexOf("\n")!=-1)
		{	
			int a=resultStr.indexOf("\n");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"~");
			resultStr=temp.toString();
			
		}

		while(resultStr.indexOf("\"")!=-1)
		{	
			int a=resultStr.indexOf("\"");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&quot;");
			resultStr=temp.toString();
			
		}

		while(resultStr.indexOf("'")!=-1)
		{	
			int a=resultStr.indexOf("'");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&#39;");
			resultStr=temp.toString();
			
		}
		while(resultStr.indexOf("<")!=-1)
		{	
			int a=resultStr.indexOf("<");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&lt;");
			resultStr=temp.toString();
		}
		while(resultStr.indexOf(">")!=-1)
		{	
			int a=resultStr.indexOf(">");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&gt;");
			resultStr=temp.toString();
		}

		return resultStr;
	}*/


%>

