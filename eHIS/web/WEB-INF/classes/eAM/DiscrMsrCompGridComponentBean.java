/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.util.*;
import java.sql.*;

public class DiscrMsrCompGridComponentBean
{
    public DiscrMsrCompGridComponentBean()
    {
    }
    public synchronized StringBuffer changeDefinitionToXML(Connection con, String gridComponentDefinition, String gridID, String grid_desc,String locale)
    {
        PreparedStatement stmt=null;
        ResultSet rs=null;
		PreparedStatement std_comp_stmt = null;
		ResultSet std_comp_rs = null;
        PreparedStatement pstmt1=null;
		ResultSet rs1	=null;

        StringBuffer    mandatoryFields		=	new StringBuffer();
	    StringBuffer    gridFields			=	new StringBuffer();
        StringBuffer    grid_std_component_information =new StringBuffer();
		StringBuffer	default_values_list =	new StringBuffer();
		StringBuffer	finalXMLString		=	new StringBuffer();
		StringBuffer	grid_component_ids	=	new StringBuffer();
		
		String comp_id = "";
		String actual_compId = "";
		String desc = "";
		String colSpan = "";
		String colPos = "";
		String text_rows = "";
		//String prompt_id = "";
		
		String display="Y";//IN063799
		int  curr_col_pos = 1;

        try
        {            
			int colindex = 1;
			//finalXMLString.append("<GRID NAME=\"" + gridID + "\" COLSPAN=\"6\" COMPTYPE=\"G\" DESCRIPTION = \"" + replaceSpecialChars(grid_desc) + "\">");commented for IN063799	
			finalXMLString.append("<GRID NAME=\"" + gridID + "\" COLSPAN=\"6\" COMPTYPE=\"G\" DESCRIPTION = \"" + replaceSpecialChars(grid_desc)+"\" DISPLAYGRID=\""+display + "\">");	//IN063799
			finalXMLString.append("<GRID-TH>");
			grid_component_ids.append(gridID);
			StringTokenizer stout = new StringTokenizer(gridComponentDefinition, "|");

			while(stout.hasMoreTokens())
			{
				String componentDetails = stout.nextToken();
				StringTokenizer stin = new StringTokenizer(componentDetails, "~");
				stin.nextToken();
				actual_compId = stin.nextToken();
				comp_id = "C_" + actual_compId;
				desc =replaceSpecialChars(checkForNull(stin.nextToken()));
				stin.nextToken();				
				colPos = stin.nextToken();
				colSpan = stin.nextToken();
				text_rows = stin.nextToken();	
//				prompt_id = stin.nextToken();
				finalXMLString.append("<TH COLSPAN='" + colSpan + "' PROMPT_ID= '"+actual_compId + "'>");
				finalXMLString.append(desc);
				finalXMLString.append("</TH>");
				curr_col_pos += Integer.parseInt(colSpan);
			}			
			finalXMLString.append("</GRID-TH>");
			curr_col_pos = 1;
			finalXMLString.append("<GRID-ROW ROWINDEX=\"1\">");
			stout = new StringTokenizer(gridComponentDefinition, "|");
			int srlNo=0;
            while(stout.hasMoreTokens())
            {
                String componentDetails = stout.nextToken();                
                StringTokenizer stin = new StringTokenizer(componentDetails, "~");
                while(stin.hasMoreTokens())
                {
					finalXMLString.append("<GRID-COL COLINDEX=\"" + colindex + "\">");
                    stin.nextToken();
                    actual_compId = stin.nextToken();
					comp_id = "C_" + actual_compId;
                    desc = stin.nextToken();
					stin.nextToken();                    
                    colPos = stin.nextToken();
                    colSpan = stin.nextToken();
                    text_rows = stin.nextToken();
//					prompt_id = stin.nextToken();
					if(curr_col_pos < Integer.parseInt(colPos))
					{
						while(curr_col_pos < Integer.parseInt(colPos))
						{
							finalXMLString.append("<EMPTY-COLUMN GRID-COMP='Y'/></GRID-COL>");
							finalXMLString.append("<GRID-COL COLINDEX = '" + (++colindex) + "'>");
							curr_col_pos++;
						}						
					}

					
					String query="select * from AM_DISCR_MSR_LANG_VW where DISCR_MSR_ID=? and LANGUAGE_ID=? ";
						
    				stmt = con.prepareStatement(query);
    				stmt.setString(1, actual_compId);
    				stmt.setString(2, locale);
    				rs = stmt.executeQuery();
   					int  maxAllowedLength=0;
    				String validationClause="";
    				int numDecimalDigit=0;
					int numdigitsmin=0;
    				String defaultValue="";
    				String acceptOption="";
    				int minNumValue=0;
    				int maxNumValue=0;                    
                    String fieldUnit = "";
    				String mandatoryGifDisplay="";
    				String compPrompt = "";
    				String compType = "";
    				StringBuffer stringToReturn =new StringBuffer();
					String std_comp_id = "";
					String link_to_std_value_yn = "";
					String lookup_type = "";
					String std_comp_result_type = "";
					String lookup_url = "";

					if(rs.next())
					{
						compPrompt = checkForNull(rs.getString("SHORT_DESC"));
						compType=checkForNull(rs.getString("RESULT_TYPE"));
						maxAllowedLength=rs.getInt("NUM_DIGITS_MAX");					
						numDecimalDigit=rs.getInt("NUM_DIGITS_DEC");	
						numdigitsmin=rs.getInt("NUM_DIGITS_MIN");
						minNumValue=rs.getInt("MIN_VALUE");
						maxNumValue=rs.getInt("MAX_VALUE");
						std_comp_id		     = rs.getString("STD_COMP_ID")==null?"":rs.getString("STD_COMP_ID");
						link_to_std_value_yn = rs.getString("LINK_TO_STD_VALUE_YN")==null?"":rs.getString("LINK_TO_STD_VALUE_YN");
						if(rs!= null)rs.close();
						if(stmt !=null) stmt.close();
						
						if((std_comp_id!= null && (!std_comp_id.equals(""))) && link_to_std_value_yn.equals("Y"))
						{
							String std_comp_qry = "select lookup_type, std_comp_result_type, lookup_url from am_standard_comp where  std_comp_id=?";
							std_comp_stmt = con.prepareStatement(std_comp_qry);
							std_comp_stmt.setString(1,std_comp_id);
							std_comp_rs = std_comp_stmt.executeQuery();
							
							while(std_comp_rs.next())
							{
								lookup_type = std_comp_rs.getString("lookup_type")==null?"":std_comp_rs.getString("lookup_type");
								std_comp_result_type = std_comp_rs.getString("std_comp_result_type")==null?"":std_comp_rs.getString("std_comp_result_type");
								lookup_url = std_comp_rs.getString("lookup_url")==null?"":std_comp_rs.getString("lookup_url");
							}
							
							if(!compType.equals("L")){
							if(grid_std_component_information.toString().equals(""))
							grid_std_component_information.append((std_comp_id + "|" + lookup_type + "|" + std_comp_result_type +"|" + (comp_id+gridID+srlNo) ));
							else
								grid_std_component_information.append( "~" +(std_comp_id + "|" + lookup_type + "|" + std_comp_result_type +"|" + (comp_id+gridID+srlNo) ));
							}
						}
						
						if(std_comp_rs!=null) std_comp_rs.close();
						if(std_comp_stmt!=null) std_comp_stmt.close();

						if(gridFields.equals(""))
								gridFields.append(comp_id + gridID + srlNo);
						else
								gridFields.append(("|" + comp_id + gridID + srlNo));
						if(acceptOption.equals("R"))	
						{
							if(mandatoryFields.equals(""))
								mandatoryFields.append(comp_id + gridID + srlNo);
							else
								mandatoryFields.append(("|" + comp_id + gridID + srlNo));

//								mandatoryGifDisplay	=	"<IMAGE SRC='../../eCommon/images/mandatory.gif'></IMAGE>";
								mandatoryGifDisplay = "Y";
						}
						else mandatoryGifDisplay	=	"N";
						
						if(compType.equals("C"))
						{
							String check_box_prop="";
							if(defaultValue.equals("Y"))	
								check_box_prop	=	"true";
							else
								check_box_prop	=	"";
//							stringToReturn.append("<CHECK-BOX GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\" CLASS='LABEL' ALIGN='' 									NAME='"+(comp_id+gridID+srlNo)+"' COLSPAN ='" + colSpan + "' CHECKED='"+check_box_prop+"' 												COMPTYPE='"+compType+"' COMPID='"+comp_id+"' >"+mandatoryGifDisplay);							
							stringToReturn.append("<CHECK-BOX GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\" CLASS='LABEL' ALIGN='center' NAME='"+(comp_id+gridID+srlNo)+"' COLSPAN ='" + colSpan + "' CHECKED='"+check_box_prop+"' COMPTYPE='"+compType+"' COMPID='"+comp_id+"' DISCRID =\"" + actual_compId + "\" >");							
							stringToReturn.append("</CHECK-BOX>");
							default_values_list.append(check_box_prop + "|");
							grid_component_ids.append("~" + ("check_box_component_of_" + gridID + colindex));	
						}						
						String calender_gif="";
						String cal_date_time_validation="";
						if( compType.equals("D") )	
						{
							maxAllowedLength	=	10;
//							validationClause	=	" ONBLUR = \"return CheckDate(this)\" ";
//							calender_gif = "Y";
//							cal_date_time_validation = "DD";
						}
						else if( compType.equals("T") )	
						{
							maxAllowedLength	=	5;
							validationClause	=	"";
						}
						else if( compType.equals("E") )	
						{
							maxAllowedLength	=	16;
//							validationClause	=	" ONBLUR = \"return callCheckDateTime(this)\" ";
//							calender_gif = "Y";
//							cal_date_time_validation = "DT";
						} 
						else
						{
							calender_gif="";
							cal_date_time_validation="";
						}					
						if( compType.equals("I") )	
						{
//							validationClause	=	" UNIT=\""+fieldUnit+"\" ONBLUR = \"return checkValidRange(this,'min_max" + (comp_id+gridID+srlNo) + "')\" ONKEYPRESS=\"return allowValidNumber(this,event,"+maxAllowedLength+",0)\" ";

						
							validationClause    =    " UNIT=\""+fieldUnit+"\" ";
						}
						if( compType.equals("N") )	
						{
//							validationClause	=	" UNIT=\""+fieldUnit+"\" ONBLUR = \"return checkValidRange(this,'min_max" + (comp_id+gridID+srlNo) + "')\" ONKEYPRESS=\"return allowValidNumber(this,event,"+(maxAllowedLength - numDecimalDigit)+","+numDecimalDigit+")\" ";
							validationClause    =    " UNIT=\""+fieldUnit+"\" ";
							maxAllowedLength++;
						} 

						if( compType.equals("D") || compType.equals("T") || compType.equals("E") || compType.equals("I") || compType.equals("N") )
						{
							if( compType.equals("I") ||  compType.equals("N"))
							{
								if(maxAllowedLength ==0)
								{
									maxAllowedLength=20;
								}
							}
							stringToReturn.append("<DATE-TIME-NUMERIC GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\"  CLASS='fields' NAME='"+(comp_id+gridID+srlNo)+"' COLSPAN ='" + colSpan + "'  SIZE='"+maxAllowedLength+"'  MAXLENGTH='"+maxAllowedLength+"' VALUE='"+defaultValue+"' "+validationClause+" COMPTYPE='"+compType+"' MIN_DIGIT ='"+numdigitsmin+"' PROMPT='"+compPrompt+"' COMPID='"+comp_id+"' DISCRID =\"" + actual_compId + "\" ");

							if(compType.equals("D") || compType.equals("E") )
								stringToReturn.append("OTHLANGVAL=''");

							if(compType.equals("N") )
								stringToReturn.append("DEC_DIGIT='"+numDecimalDigit+"' >");
							else
								stringToReturn.append(" >");


							if( compType.equals("I") || compType.equals("N") )
							{
								stringToReturn.append("<HIDDEN-FIELD NAME='min_max"+(comp_id+gridID+srlNo)+"'  VALUE='"+(minNumValue+"|"+maxNumValue)+"'></HIDDEN-FIELD>");
							}
//							stringToReturn.append(getCalenderGif(calender_gif, cal_date_time_validation, (comp_id+gridID+srlNo))+mandatoryGifDisplay);

							stringToReturn.append("</DATE-TIME-NUMERIC>");
							grid_component_ids.append("~" + ("date_time_numeric_component_of_" + gridID + colindex));
							default_values_list.append(defaultValue + "|");
						}						
						if( compType.equals("H") )
						{

//							stringToReturn.append("<SHORT-TEXT GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\" COLSPAN ='" + colSpan + "'   CLASS='LABEL'  COLS =\"" + (Integer.parseInt(colSpan)*15) + "\" NAME='"+(comp_id+gridID+srlNo)+"' 	 ONBLUR=\"CheckMaximumLength('"+java.net.URLEncoder.encode(compPrompt)+"',this,"+maxAllowedLength+",top.messageFrame);\" ROWS=\"" + text_rows + "\" >"+defaultValue+mandatoryGifDisplay);
							stringToReturn.append("<SHORT-TEXT GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\" COLSPAN ='" + colSpan + "'   CLASS='LABEL'  COLS =\"" + (Integer.parseInt(colSpan)*15) + "\" NAME='"+(comp_id+gridID+srlNo)+"' 	 SIZE = \"" + maxAllowedLength + "\"  ROWS=\"" + /* text_rows*/ "\"  DISCRID =\"" + actual_compId + "\">"+defaultValue);

							stringToReturn.append("</SHORT-TEXT>");
							default_values_list.append(defaultValue + "|");

							grid_component_ids.append("~" + ("short_text_component_of_" + gridID + colindex));
						}
						if(compType.equals("L"))
						{
						/*	if((std_comp_id!= null || std_comp_id.equals("")) && link_to_std_value_yn.equals("Y"))
							{
								stringToReturn.append("<LIST-BOX GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\" COLSPAN ='" + colSpan + "'  CLASS='LABEL'  NAME='"+(comp_id+gridID+srlNo)+"' COMPTYPE='"+compType+"' COMPID='"+comp_id+"' LOOK_UP_TYPE=\"" + lookup_type + "\" STD_COMP_RESULT_TYPE=\"" + std_comp_result_type + "\" STD_COMP_ID=\"" + std_comp_id + "\" LOOKUP_URL=\"" + lookup_url + "\" STD_COMP_VALUE=\"\" >"); 
							}*/

								stringToReturn.append("<LIST-BOX GRID-COMP=\"Y\" GRID-NAME=\"" + gridID + "\" COLSPAN ='" + colSpan + "'  CLASS='LABEL'  NAME='"+(comp_id+gridID+srlNo)+"' COMPTYPE='"+compType+"' COMPID='"+comp_id+"' LOOK_UP_TYPE=\"" + lookup_type + "\" STD_COMP_RESULT_TYPE=\"" + std_comp_result_type + "\" STD_COMP_ID=\"" + std_comp_id + "\" LOOKUP_URL=\"" + lookup_url + "\" STD_COMP_VALUE=\"\" DISCRID =\"" + actual_compId + "\" DFLTSEL ='SELECT'>"); 

							String default_selected = "";
							try
							{
								String strConstructedId = "";
								String strBuildId		=	"";

								strConstructedId=	comp_id+gridID+srlNo+ "L_";
								
								String query_list_values="Select RESULT_VALUE list_item_id, REF_RNG_DESC list_item_text,   DFLT_YN default_yn,REF_RANGE_SEQ from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID = ?  order by REF_RANGE_SEQ";

								pstmt1=	con.prepareStatement(query_list_values);
								pstmt1.setString	(	1,	actual_compId		);
								rs1			=	pstmt1.executeQuery();
								String ref_range_seq = "";
								while(rs1.next())
								{
									String list_item_id		=	checkForNull(rs1.getString("list_item_id"));			
									String list_item_text	=	replaceSpecialChars(checkForNull(rs1.getString("list_item_text")));	
									String default_yn		=	checkForNull(rs1.getString("default_yn"));	
									ref_range_seq			=   checkForNull(rs1.getString("REF_RANGE_SEQ"));	
									strBuildId				=	strConstructedId+ ref_range_seq;
									stringToReturn.append("<DATA VALUE='"+list_item_id+"'" + (default_yn.equals("Y")?" SELECTED='true' ":"") + "  COMPITEMKEY = \"" +strBuildId +"\" >"+list_item_text+"</DATA>");
									if(default_yn.equals("Y"))
										default_selected = list_item_id;
								}
								rs1.close();
								pstmt1.close();							
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
//						stringToReturn.append(mandatoryGifDisplay+"<HIDDEN-FIELD NAME='"+(comp_id+gridID+srlNo)+"_desc'  VALUE=''></HIDDEN-FIELD><HIDDEN-FIELD NAME='"+(comp_id+gridID+srlNo)+"_code'  VALUE=''></HIDDEN-FIELD>");
						stringToReturn.append("<HIDDEN-FIELD NAME='"+(comp_id+gridID+srlNo)+"_desc'  VALUE=''></HIDDEN-FIELD><HIDDEN-FIELD NAME='"+(comp_id+gridID+srlNo)+"_code'  VALUE=''></HIDDEN-FIELD>");
							
						/*	if((std_comp_id!= null || std_comp_id.equals("")) && link_to_std_value_yn.equals("Y"))
								stringToReturn.append("</LIST-BOX>");
						*/
								stringToReturn.append("</LIST-BOX>");
								grid_component_ids.append("~" + ("list_box_component_of_" + gridID + colindex));
								
								default_values_list.append(default_selected + "|");
						}						
					}
					finalXMLString.append(stringToReturn);
                }
				finalXMLString.append("</GRID-COL>");
				colindex++;
				srlNo++;
				curr_col_pos += Integer.parseInt(colSpan);
            }
			finalXMLString.append("</GRID-ROW></GRID>");
			finalXMLString.append("<HIDDEN-FIELD NAME=\"mandatory_fields_" + gridID + "\" VALUE=\""+mandatoryFields+"\"></HIDDEN-FIELD>");
			finalXMLString.append("<HIDDEN-FIELD NAME=\"grid_std_component_information_" + gridID + "\" VALUE=\""+grid_std_component_information+"\"></HIDDEN-FIELD>");
			finalXMLString.append("<HIDDEN-FIELD NAME=\"gridFields_" + gridID + "\" VALUE=\""+gridFields+"\"></HIDDEN-FIELD>");		
			finalXMLString.append("<HIDDEN-FIELD NAME=\"grid_component_ids_" + gridID + "\" VALUE=\""+grid_component_ids+"\"></HIDDEN-FIELD>");			
			finalXMLString.append("<HIDDEN-FIELD NAME=\"default_values_list_" + gridID + "\" VALUE=\""+default_values_list+"\"></HIDDEN-FIELD>");			
        }
        catch(Exception e)
        {
			e.printStackTrace();
        }
        return finalXMLString;
    }
    String getCalenderGif(String calGifYN, String valDateTime, String fldName)
    {
        String retCalGif = "";
/*
		if(calGifYN.equals("Y"))
        {
            if(!valDateTime.equals(""))
            {
                if(valDateTime.equals("DD"))
                {
                    retCalGif = "<CALANDER  SRC=\"../../eCommon/images/CommonCalendar.gif\" NAME='"+fldName+"' ONCLICK=\"return templateCalendarValidate(this.value,'N');\" ></CALANDER>";
                }
                else if(valDateTime.equals("DT"))
                {
            retCalGif = "<CALANDER SRC=\"../../eCommon/images/CommonCalendar.gif\"  NAME='"+fldName+"' ONCLICK=\"return templateCalendarValidate(this.value,'Y');\" ></CALANDER>";
                }
            }
        }
		*/
        return retCalGif;
    }
    private String checkForNull(String inputString)
    {
        return (inputString==null)    ?    ""    :    inputString;
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
		
		return input;
	}

}
