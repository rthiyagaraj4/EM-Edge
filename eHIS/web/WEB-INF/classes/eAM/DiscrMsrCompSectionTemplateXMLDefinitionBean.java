/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.util.*;
public class DiscrMsrCompSectionTemplateXMLDefinitionBean implements java.io.Serializable 
{
	public StringBuffer constructXML(Connection con,String section)
	{
		
		StringBuffer sb=new StringBuffer();
		sb.append("<USER-TEMPLATE>");
		sb.append("<ROW>");
		try
		{
			String qry="select * from ca_section_template_vw where SEC_HDG_CODE=? order by row_pos_no, column_pos_no";
			PreparedStatement stmt=con.prepareStatement(qry);
			stmt.setString(1,section);
			ResultSet rs=stmt.executeQuery();
			HashMap hm=null;			
			int previousRow=0;
			int previousCol=0;
			int counter=0;
			int previousColSpan=0;
			int rowPos = 0;
			int colPos = 0;
			int colSpan = 0;
			while(rs.next())
			{
				hm=new HashMap();
				hm.put("SRL_NO",new Integer(rs.getInt("SRL_NO")));
				hm.put("ITEM_TYPE",rs.getString("ITEM_TYPE"));
				hm.put("COMP_ID",rs.getString("COMP_ID"));
				hm.put("TITLE_VALUE",rs.getString("TITLE_VALUE"));
				rowPos=rs.getInt("ROW_POS_NO");
				hm.put("ROW_POS_NO",new Integer(rowPos));
				colPos=rs.getInt("COLUMN_POS_NO");
				hm.put("COLUMN_POS_NO",new Integer(colPos));
				colSpan=rs.getInt("NO_OF_COL_SPAN");
				hm.put("NO_OF_COL_SPAN",new Integer(colSpan));				
				hm.put("PROMPT_DISPLAY_LOC",rs.getString("PROMPT_DISPLAY_LOC"));				
				hm.put("COMP_PROMPT",rs.getString("COMP_PROMPT"));
				hm.put("COMP_TYPE",rs.getString("COMP_TYPE"));
				hm.put("MAX_ALLOWED_LENGTH",new Integer(rs.getInt("MAX_ALLOWED_LENGTH")));
				hm.put("NUM_DIGIT_DEC",new Integer(rs.getInt("NUM_DIGIT_DEC")));
				hm.put("ACCEPT_OPTION",rs.getString("ACCEPT_OPTION"));
				hm.put("MIN_NUM_VALUE",new Integer(rs.getInt("MIN_NUM_VALUE")));
				hm.put("MAX_NUM_VALUE",new Integer(rs.getInt("MAX_NUM_VALUE")));
				hm.put("DFLT_VALUE",rs.getString("DFLT_VALUE"));
                hm.put("FIELD_UNIT",rs.getString("FIELD_UNIT"));
				hm.put("HIST_REC_TYPE",rs.getString("HIST_REC_TYPE"));
				if(previousRow<rowPos && counter!=0)//putting end of row on change of the row and restricting when template is not starting from row 1
				{
					sb.append("</ROW>");
					sb.append("<ROW>");
					previousCol=0;
					previousColSpan=0;
					//previousRow=rowPos;
				}
				//putting empty rows when there is diffrence of more then one
				while(previousRow<(rowPos-1))
				{
					sb.append("<EMPTY-ROW></EMPTY-ROW>");
					sb.append("</ROW>");
					sb.append("<ROW>");
					previousRow++;
					previousCol=0;
					previousColSpan=0;
				}
				previousRow=rowPos;
				sb.append("<COL>");
				while(previousCol<(colPos-1))
				{
					if(previousColSpan>1)
					{
						previousColSpan--;
					}
					else
					{
						sb.append("<EMPTY-COLUMN></EMPTY-COLUMN>");
						sb.append("</COL>");
						sb.append("<COL>");
					}
					previousCol++;
				}
				previousCol=colPos;
				sb.append(buildTagsForComponents(con,hm,section));
				sb.append("</COL>");
				previousColSpan=colSpan;

				counter++;
			}//end of the outer query while()
			sb.append("</ROW>");
			if(mandatoryFields.length()>0)
			{
				mandatoryFields.append(	mandatoryFields.substring(0,mandatoryFields.length()-1));
				if(mandatoryNames.length()>0)
				{
					mandatoryNames.append(	mandatoryNames.substring(0,mandatoryNames.length()-1));
				}
			}
			if(listItemFields.length()>0)
			{
				listItemFields.append(listItemFields.substring(0,listItemFields.length()-1));
			}
			sb.append("<HIDDEN-FIELD NAME=\"mandatory_fields\" VALUE=\""+mandatoryFields+"\"></HIDDEN-FIELD>");
			sb.append("<HIDDEN-FIELD NAME=\"mandatory_names\" 	VALUE=\""+mandatoryNames+"\"></HIDDEN-FIELD>");
			sb.append("<HIDDEN-FIELD NAME=\"list_item_fields\" VALUE=\""+listItemFields+"\"></HIDDEN-FIELD>");
			sb.append("<HIDDEN-FIELD NAME=\"grid_component_ids\" VALUE=\""+grid_component_ids+"\"></HIDDEN-FIELD>");
			sb.append("<HIDDEN-FIELD NAME=\"matrix_names\" VALUE=\""+matrix_names+"\"></HIDDEN-FIELD>");
            sb.append("<CALL-ON-UNLOAD VALUE='"+formulaFuncOnBodyUnload+"' />");
			sb.append("<CALL-ON-LOAD VALUE='"+linkingEventsOnLoad+"' />");
			sb.append("</USER-TEMPLATE>");
			mandatoryFields.setLength(0);
			mandatoryNames.setLength(0);
			listItemFields.setLength(0);
			hm.clear();
			if(rs!=null) rs.close();
			if(stmt !=null)stmt.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return sb;
	}
	private String buildTagsForComponents(Connection con,HashMap hm,String section)
	{
		StringBuffer stringToReturn=new StringBuffer();
		String compId=checkForNull((String)hm.get("COMP_ID"));
		int srlNo=((Integer)hm.get("SRL_NO")).intValue();
		String itemType=checkForNull((String)hm.get("ITEM_TYPE"));
		String titleValue=replaceSpecialChars(checkForNull((String)hm.get("TITLE_VALUE")));
		int colSpan=((Integer)hm.get("NO_OF_COL_SPAN")).intValue();
		String promptLocDisplay=checkForNull((String)hm.get("PROMPT_DISPLAY_LOC"));
		String compPrompt=replaceSpecialChars(checkForNull((String)hm.get("COMP_PROMPT")));
		String compType=checkForNull((String)hm.get("COMP_TYPE"));
		int maxAllowedLength=((Integer)hm.get("MAX_ALLOWED_LENGTH")).intValue();
		int numDecimalDigit=((Integer)hm.get("NUM_DIGIT_DEC")).intValue();
		String acceptOption=checkForNull((String)hm.get("ACCEPT_OPTION"));
		int minNumValue=((Integer)hm.get("MIN_NUM_VALUE")).intValue();
		int maxNumValue=((Integer)hm.get("MAX_NUM_VALUE")).intValue();
		String defaultValue=replaceSpecialChars(checkForNull((String)hm.get("DFLT_VALUE")));
        String fieldUnit=replaceSpecialChars(checkForNull((String)hm.get("FIELD_UNIT")));
		String histRecType=checkForNull((String)hm.get("HIST_REC_TYPE"));
		String fieldAssociationXML = "";
		hm.clear();
		//taking care of the Field Association (Linking between the fields) 
		//happens only when comp_type='L' or 'C'
		if(compType.equals("C") || compType.equals("L"))
		{
			PreparedStatement pstmt2=null;
			ResultSet rs2	=null;
			try
			{
				String queryXMLDef=" select DEFINITION from ca_section_template where SEC_HDG_CODE=? and COMP_ID= ? and SRL_NO =? ";
				pstmt2=	con.prepareStatement(queryXMLDef);
				pstmt2.setString(1,section);
				pstmt2.setString(2,compId);
				pstmt2.setInt(3,srlNo);
				rs2	=	pstmt2.executeQuery();
				if(rs2.next())
					fieldAssociationXML = rs2.getString(1);

				if(rs2 !=null) rs2.close();
				if(pstmt2 !=null) pstmt2.close();
				

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//-------------------------------------
		//taking care of the accept option
		String madatoryGifDisplay="";
		//String readOnlyClause="";
		if(acceptOption.equals("R"))	
		{
			mandatoryFields.append(compId+srlNo+"|");
			mandatoryNames.append(compPrompt+"|");
			madatoryGifDisplay	=	"<IMAGE SRC='../../eCommon/images/mandatory.gif'></IMAGE>";
		}
		else
		{
			madatoryGifDisplay	=	"";
		}
		/*if(acceptOption.equals("D"))	
		{
			readOnlyClause		=	" class=\"READONLY\" ";
		}
		else
		{
			readOnlyClause		=	"";
		}*/
		//--------------
		//taking care of the Title 
		if(itemType.equals("T"))
		{
			if(promptLocDisplay.equals("C"))
			{
				stringToReturn.append("<TITLE-TEXT COLSPAN='"+2*colSpan+"' ALIGN='center' CLASS='ITEMSELECT' TYPE='C'>"+titleValue+"</TITLE-TEXT>");
			}
			else
			{
				stringToReturn.append("<TITLE-TEXT COLSPAN='"+2*colSpan+"' ALIGN='left' TYPE='T' >"+titleValue+"</TITLE-TEXT>");
			}
			return stringToReturn.toString();
		}
		//-------------------
		//taking care of Checkbox		
		if(compType.equals("C"))
		{
			String check_box_prop="";
			String onClickEvent="";
			if(defaultValue.equals("Y"))	
				check_box_prop	=	"true";
			else
				check_box_prop	=	"";

			//checking wether there is any type of linking present with the other fields in the template
			if(fieldAssociationXML!=null && !fieldAssociationXML.equals(""))
			{
				onClickEvent = "ONCLICK = 'fireOnAction"+(compId+srlNo)+"(this)'";	
				linkingEventsOnLoad.append( "fireOnAction"+(compId+srlNo)+"(document.forms[0]."+(compId+srlNo)+");");
			}
			stringToReturn.append("<CHECK-BOX CLASS='LABEL' COLSPAN='"+(2*colSpan-1)+"' ALIGN='' NAME='"+(compId+srlNo)+"' COMPID='"+compId+"' COMPTYPE='"+compType+"' CHECKED='"+check_box_prop+"' PROMPT='"+compPrompt+"' "+onClickEvent+" >"+madatoryGifDisplay+fieldAssociationXML+"</CHECK-BOX>");
		}
		//----------------

		//taking care of Date -Time -Numeric Fields
		String validationClause	=	"";
		String calender_gif="";
		String cal_date_time_validation="";
		if( compType.equals("D") )	
		{
			maxAllowedLength	=	10;
			validationClause	=	" ONBLUR = \"return CheckDate(this)\" ";
			calender_gif = "Y";
			cal_date_time_validation = "DD";
		}else if( compType.equals("T") )	
		{
			maxAllowedLength	=	5;
			validationClause	=	" ONBLUR = \"return callCheckTime(this)\" ";
		}
		else if( compType.equals("E") )	
		{
			maxAllowedLength	=	16;
			validationClause	=	" ONBLUR = \"return callCheckDateTime(this)\" ";
			calender_gif = "Y";
			cal_date_time_validation = "DT";
		} 
		else{
			calender_gif="";
			cal_date_time_validation="";
		}
		if( compType.equals("I") )	
		{
			validationClause	=	" UNIT=\""+fieldUnit+"\" ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+maxAllowedLength+",0)\" ";
		}
		if( compType.equals("N") )	
		{
			validationClause	=	" UNIT=\""+fieldUnit+"\" ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+(maxAllowedLength - numDecimalDigit)+","+numDecimalDigit+")\" ";
			maxAllowedLength++;
		}

		if( compType.equals("D") || compType.equals("T") || compType.equals("E") || compType.equals("I") || compType.equals("N") )
		{
			stringToReturn.append("<DATE-TIME-NUMERIC CLASS='LABEL' COLSPAN='"+(2*colSpan-1)+"' NAME='"+(compId+srlNo)+"' COMPID='"+compId+"' COMPTYPE='"+compType+"' SIZE='"+maxAllowedLength+"' PROMPT='"+compPrompt+"' MAXLENGTH='"+(maxAllowedLength==0?20:maxAllowedLength)+"' VALUE='"+defaultValue+"' "+validationClause+" >");			
			if( compType.equals("I") || compType.equals("N") )
			{
				stringToReturn.append("<HIDDEN-FIELD NAME='min_max"+(compId+srlNo)+"'  VALUE='"+(minNumValue+"|"+maxNumValue)+"'></HIDDEN-FIELD>");
			}
			stringToReturn.append(getCalenderGif(calender_gif, cal_date_time_validation, (compId+srlNo))+madatoryGifDisplay+"</DATE-TIME-NUMERIC>");
		}
		//--------------------------
		//taking care of Short and Long Text
		if( compType.equals("H") )
		{
			/*stringToReturn="<td class="LABEL" colspan="<%=no_of_col_span%>" align="<%=comp_align_prop%>" width="<%=width_percentage%>"> <%if(!(prompt_display_loc.equals("T"))){%>&nbsp;&nbsp;<%}%><textarea name="<%=(comp_id+srl_no)%>" rows="1" cols="<%=(no_of_col_span*15)%>" onBlur="CheckMaximumLength('<%=java.net.URLEncoder.encode(comp_prompt)%>',this,<%=max_allowed_length%>,top.messageFrame);" <%=readOnlyClause%> ><%=dflt_value%></textarea><%=madatory_gif_display%></td> <%=top_display_loc_end%>*/
			stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*colSpan-1)+"' NAME='"+(compId+srlNo)+"' COMPID='"+compId+"' COMPTYPE='"+compType+"' COLS='"+((2*colSpan-1)*15)+"'	PROMPT='"+compPrompt+"' ONBLUR=\"CheckMaximumLength('"+java.net.URLEncoder.encode(compPrompt)+"',this,"+maxAllowedLength+",top.messageFrame);\" >"+defaultValue+madatoryGifDisplay+"</SHORT-TEXT>");
		}
		if(compType.equals("F"))
		{
			/*<td class="LABEL" colspan="<%=no_of_col_span%>" align="<%=comp_align_prop%>" width="<%=width_percentage%>"> <%if(!(prompt_display_loc.equals("T"))){%>&nbsp;<%}%>
			<textarea name="<%=(comp_id+srl_no)%>" rows="3" cols="80" <%=readOnlyClause%>> <%=dflt_value%></textarea><%=madatory_gif_display%></td><%=top_display_loc_end%>*/
			stringToReturn.append("<LONG-TEXT CLASS='LABEL' COLSPAN='"+(2*colSpan-1)+"' PROMPT='"+compPrompt+"' NAME='"+(compId+srlNo)+"' COMPID='"+compId+"' COMPTYPE='"+compType+"' RECORD-TYPE='"+histRecType+"' >"+defaultValue+madatoryGifDisplay+"</LONG-TEXT>");
		}
		//--------------------------------------
		//taking care of List Items
		if(compType.equals("L"))
		{
			listItemFields.append(compId+srlNo+"|");
			String onChangeEvent = "";
			/*stringToReturn="<td class="LABEL" colspan="<%=no_of_col_span%>" align="<%=comp_align_prop%>" width="<%=width_percentage%>"> <%if(!(prompt_display_loc.equals("T"))){%>&nbsp;&nbsp;<%}%><select name="<%=(comp_id+srl_no)%>" <%=readOnlyClause%>>
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- Select -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>*/
			if(fieldAssociationXML!=null && !fieldAssociationXML.equals(""))
			{
				onChangeEvent = "ONCHANGE = 'fireOnAction"+(compId+srlNo)+"(this)'";
				linkingEventsOnLoad.append( "fireOnAction"+(compId+srlNo)+"(document.forms[0]."+(compId+srlNo)+");");
			}
			stringToReturn.append("<LIST-BOX CLASS='LABEL' COLSPAN='"+(2*colSpan-1)+"' PROMPT='"+compPrompt+"' NAME='"+(compId+srlNo)+"' COMPID='"+compId+"' COMPTYPE='"+compType+"' "+onChangeEvent+" >"); 
			PreparedStatement pstmt1=null;
			ResultSet rs1	=null;
			try
			{
				String query_list_values=	" Select list_item_id, list_item_text, default_yn from CA_TEMPLATE_COMP_LIST where comp_id = ?  order by order_seq_no ";
				pstmt1=	con.prepareStatement(query_list_values);

				pstmt1.setString	(	1,	compId		);

				rs1			=	pstmt1.executeQuery();

				while(rs1.next())
				{
					String list_item_id		=	rs1.getString("list_item_id");			
					String list_item_text	=	replaceSpecialChars(checkForNull(rs1.getString("list_item_text")));			
					String default_yn		=	rs1.getString("default_yn");
					
					if(default_yn.equals("Y"))
					{
			
						stringToReturn.append("<DATA VALUE='"+list_item_id+"' SELECTED='true' >"+list_item_text+"</DATA>");
			
					}
					else
					{
			
						stringToReturn.append("<DATA VALUE='"+list_item_id+"'>"+list_item_text+"</DATA>");
			
					}
				}
				rs1.close();
				pstmt1.close();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			stringToReturn.append(madatoryGifDisplay+fieldAssociationXML+"<HIDDEN-FIELD NAME='"+(compId+srlNo)+"_desc'  VALUE=''></HIDDEN-FIELD></LIST-BOX>");
	
		}
		//---------------------------
		//taking care of paragraph
		if(compType.equals("P"))
		{
			PreparedStatement pstmt2=null;
			ResultSet rs2	=null;
			StringBuffer paragraphXML=new StringBuffer();			
			try
			{
				String queryParagraph=	" Select COMP_XML_DEFINITION from CA_TEMPLATE_COMP_DEFINITION where COMP_ID= ?";
				pstmt2=	con.prepareStatement(queryParagraph);
				pstmt2.setString(1,compId);
				rs2	=	pstmt2.executeQuery();
				if(rs2.next())
				{
					Clob clb = rs2.getClob(1);					
					if(clb!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
						String line = null;
						while((line=r.readLine()) != null) 
						{
							paragraphXML.append(line);
						}
					}
				}
				//updating the Name attribute of each component in paragraph by calling the bean
				DiscrMsrCompParagraphDomParser beanObj = new DiscrMsrCompParagraphDomParser();
				paragraphXML = beanObj.updateXMLParaCompNames(paragraphXML,srlNo,compId,paraNo);
				beanObj=null;
				if(rs2 != null) 
				rs2.close();
			if(pstmt2 != null) 
				pstmt2.close();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}			
			stringToReturn.append(paragraphXML.toString());
			paragraphXML = null;
			paraNo++;
			
		}
		// adding a grid component to the section
		if(compType.equals("R") || compType.equals("X"))
		{
			PreparedStatement pstmt2=null;
			ResultSet rs2	=null;
			StringBuffer gridXML = new StringBuffer();			
			try
			{
				String queryGrid =	" Select COMP_XML_DEFINITION from CA_TEMPLATE_COMP_DEFINITION where COMP_ID= ?";
				pstmt2=	con.prepareStatement(queryGrid);
				pstmt2.setString(1,compId);
				rs2	=	pstmt2.executeQuery();
				if(rs2.next())
				{
					Clob clb = rs2.getClob(1);					
					if(clb!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
						String line = null;
						while((line=r.readLine()) != null) 
						{
							gridXML.append(line);
						}
					}
				}
				if(rs2 != null) 
				rs2.close();

			if(pstmt2 != null) 
				pstmt2.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}			
			stringToReturn.append(gridXML.toString());
			if(compType.equals("R"))
			{
				eCA.HiddenComponentIDS gridCompIDS = new eCA.HiddenComponentIDS();
				if(grid_component_ids.equals(""))
					grid_component_ids.append( gridCompIDS.getHiddenComponentIDS("<USER-TEMPLATE><ROW><COL>" + gridXML.toString() + "</COL></ROW></USER-TEMPLATE>","HIDDEN-FIELD","grid_component_ids_"));
				else
					grid_component_ids.append("|" + gridCompIDS.getHiddenComponentIDS("<USER-TEMPLATE><ROW><COL>" + gridXML.toString() + "</COL></ROW></USER-TEMPLATE>","HIDDEN-FIELD","grid_component_ids_"));
				gridCompIDS = null;
			}
			else if(compType.equals("X"))
			{
				eCA.HiddenComponentIDS matrixNames = new eCA.HiddenComponentIDS();
				if(matrix_names.equals(""))
					matrix_names.append( matrixNames.getHiddenComponentIDS(gridXML.toString(),"MATRIX",""));
				else
					matrix_names.append("|" + matrixNames.getHiddenComponentIDS(gridXML.toString(),"MATRIX",""));
				matrixNames = null;
			}
			gridXML = null;
			
			
		}
		//
		if(compType.equals("A"))
		{
			PreparedStatement pstmt2=null;
			ResultSet rs2	=null;
            formulaFuncOnBodyUnload.append("getFormulaResult"+compId+srlNo+"();");
			StringBuffer formulaXML=new StringBuffer("<FORMULA-COMP CLASS='LABEL' COLSPAN='"+(2*colSpan-1)+"' NAME='"+(compId+srlNo)+"' COMPID='"+compId+"' COMPTYPE='"+compType+"' UNIT=\""+fieldUnit+"\" PROMPT='"+compPrompt+"' FORMULA-FUNC='getFormulaResult"+compId+srlNo+"()'>");
			String formulaDefinition="";
			try
			{
				String queryFormula=" select DEFINITION from ca_section_template where SEC_HDG_CODE=? and COMP_ID= ? and SRL_NO =? ";
				pstmt2=	con.prepareStatement(queryFormula);
				pstmt2.setString(1,section);
				pstmt2.setString(2,compId);
				pstmt2.setInt(3,srlNo);
				rs2	=	pstmt2.executeQuery();
				if(rs2.next())
				{
					formulaDefinition = rs2.getString(1);
				}	
				if(rs2 !=null) rs2.close();
				if(pstmt2 !=null) pstmt2.close();
			
				if( formulaDefinition!=null && !formulaDefinition.equals(""))
				{
					DiscrMsrCompFormulaComponentBean beanObj = new DiscrMsrCompFormulaComponentBean();
					formulaXML.append(beanObj.getJavaScriptForFormulaXML(formulaDefinition,compId,srlNo));
					beanObj=null;
				}
				formulaXML.append("</FORMULA-COMP>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			stringToReturn.append(formulaXML.toString());
			formulaXML = null;
			
			
		}
		
		//----------------------------
		return stringToReturn.toString();

	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;	
	}
	
	String getCalenderGif(String calGifYN, String valDateTime, String fldName){
	String retCalGif = "";
		if(calGifYN.equals("Y")){
			if(!valDateTime.equals("")){
				if(valDateTime.equals("DD")){
					retCalGif = "<CALANDER  SRC=\"../../eCommon/images/CommonCalendar.gif\" NAME='"+fldName+"' ONCLICK=\"return templateCalendarValidate(this.value,'N');\" ></CALANDER>";
				}else if(valDateTime.equals("DT")){
					retCalGif = "<CALANDER SRC=\"../../eCommon/images/CommonCalendar.gif\"  NAME='"+fldName+"' ONCLICK=\"return templateCalendarValidate(this.value,'Y');\" ></CALANDER>";
				}
			}
		}
		return retCalGif; 
	}
	private static String replaceSpecialChars(String input)
	{
		StringBuffer temp=null;
		int a=0,b=0,c=0,i=0;
		while(true)
		{
			a=input.indexOf('&',i)==-1?999999:input.indexOf('&',i);
			b=input.indexOf('<',i)==-1?999999:input.indexOf('<',i);
			c=input.indexOf('>',i)==-1?999999:input.indexOf('>',i);
			if(a<b && a<c && a!=-1)
			{
				temp=new StringBuffer(input);
				temp.replace(a,a+1,"&amp;");
				input=temp.toString();
				i=a+5;
			}
			else if(b<a && b<c && b!=-1)
			{
				temp=new StringBuffer(input);
				temp.replace(b,b+1,"&lt;");
				input=temp.toString();
				i=b+4;
			}
			else if(c<a && c<b && c!=-1)
			{
				temp=new StringBuffer(input);
				temp.replace(c,c+1,"&gt;");
				input=temp.toString();
				i=c+4;
			}
			else if(a==b && b==c)
			{
				break;
			}
			else
			{
				break;
			}

		}
		/*while(input.indexOf("\n")!=-1)
		{	
			int ii=input.indexOf("\n");
			temp=new StringBuffer(input);
			temp.replace(ii,ii+2,"&lt;br&gt;");
			input=temp.toString();
		}*/
		return input;
	}
	StringBuffer	mandatoryFields			=new StringBuffer();
	StringBuffer	mandatoryNames			=new StringBuffer();
	StringBuffer  listItemFields			=new StringBuffer();
    StringBuffer  formulaFuncOnBodyUnload	=new StringBuffer();  
	StringBuffer  linkingEventsOnLoad		=new StringBuffer();
	StringBuffer	grid_component_ids		=new StringBuffer();
	StringBuffer	matrix_names		=new StringBuffer();
	int		paraNo					=	0;
        
}
