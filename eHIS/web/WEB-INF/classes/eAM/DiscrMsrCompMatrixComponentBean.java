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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;


public class DiscrMsrCompMatrixComponentBean
{
    public DiscrMsrCompMatrixComponentBean()
    {
    }
    public synchronized StringBuffer changeDefinitionToXML(Connection con, String matrixComponentDefinition, String matrixID, String matrixDesc)
    {		
		PreparedStatement stmt=null;
        ResultSet rs=null;
		PreparedStatement std_comp_stmt = null;
		ResultSet std_comp_rs = null;
		PreparedStatement pstmt1=null;
		ResultSet rs1    =null;
		StringBuffer    mandatoryFields =new StringBuffer();
		StringBuffer    matrix_std_component_information =new  StringBuffer();
        int srlNo = 0;
        StringBuffer finalXMLString = new StringBuffer();        
		int matrix_cols		=	0,		matrix_rows		=	0;
		int starting_pos	=	0;
		StringTokenizer componentDetails	=	null,		columnHeaders	=	null;
		StringTokenizer rowHeaders			=	null;
		String comp_id = "";
		String actual_compId = "";
		StringTokenizer columnHeadersId = null;
		StringTokenizer rowHeadersId = null;
		String display="Y";//IN063799
		try
		{
			int total_columns_occupied = 0;
			StringTokenizer stout = new StringTokenizer (matrixComponentDefinition, "$$$");
			matrix_cols = Integer.parseInt(stout.nextToken());
			matrix_rows = Integer.parseInt(stout.nextToken());
			starting_pos = Integer.parseInt(stout.nextToken());
			String mat_colSpan_temp = stout.nextToken();
			StringTokenizer st_temp = new StringTokenizer(mat_colSpan_temp, "~");
			int colSpan_arr[] = new int[st_temp.countTokens()];
			int count = 0;
			while(st_temp.hasMoreTokens())
				colSpan_arr[count++] = Integer.parseInt(st_temp.nextToken());
			for(int i=0;i<colSpan_arr.length;i++)
				total_columns_occupied += colSpan_arr[i];
			total_columns_occupied += 1;
			componentDetails = new StringTokenizer(stout.nextToken(), "||");
			columnHeaders = new StringTokenizer(stout.nextToken(), "~");
			rowHeaders = new StringTokenizer(stout.nextToken(), "~");
			columnHeadersId = new StringTokenizer(stout.nextToken(), "~");
			rowHeadersId =new StringTokenizer(stout.nextToken(), "~");
			for(int x=1;x<starting_pos;x++)
			{
				finalXMLString.append("<MATRIX-COL>");
				finalXMLString.append("<EMPTY-COLUMN MATRIX-COMP='Y'/></MATRIX-COL>");
			}
			//finalXMLString.append("<MATRIX COLSPAN=\"6\" NAME=\"" + matrixID + "\" MATRIX-DESC=\"" + matrixDesc + "\">");commented for IN063799
			finalXMLString.append("<MATRIX COLSPAN=\"6\" NAME=\"" + matrixID + "\" MATRIX-DESC=\"" + matrixDesc +"\" DISPLAYMATRIX=\"" + display + "\">");//IN063799
			finalXMLString.append("<MATRIX-TH>");
			for(int i=0;i<matrix_cols;i++)
			{				
				finalXMLString.append("<TH COLSPAN=\"" + colSpan_arr[i] + "\" COL_ID=\"" + columnHeadersId.nextToken() + "\" >");
				finalXMLString.append(replaceSpecialChars(java.net.URLDecoder.decode(columnHeaders.nextToken())));
				finalXMLString.append("</TH>");
			}
			finalXMLString.append("</MATRIX-TH>");

			for(int i=0;i<matrix_rows;i++)
			{
				finalXMLString.append("<MATRIX-ROW  YAXISPROMPT =\"" + replaceSpecialChars(java.net.URLDecoder.decode(rowHeaders.nextToken())) + "\" ROW_ID =\"" + rowHeadersId.nextToken() + "\">");
				for(int j=0;j<matrix_cols;j++)
				{
					String colSpan = colSpan_arr[j] + "";
					finalXMLString.append("<MATRIX-COL>");
					String compDet = componentDetails.nextToken();
					st_temp = new StringTokenizer(compDet, "~");				
					actual_compId = st_temp.nextToken();//Component Description
                    comp_id = "C_" + actual_compId;
					st_temp.nextToken();
					comp_id = comp_id.equals("9999999999")?"":comp_id;
					st_temp.nextToken();
					String query="select * from AM_DISCR_MSR where DISCR_MSR_ID=?";
					stmt = con.prepareStatement(query);
					stmt.setString(1, actual_compId);
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
					String madatoryGifDisplay="";
					String compPrompt = "";
					String compType = "";
					StringBuffer stringToReturn = new StringBuffer();
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
                		if(rs !=null) rs.close();
						if(stmt !=null) stmt.close();
						if((std_comp_id!= null && !(std_comp_id.equals(""))) && link_to_std_value_yn.equals("Y"))
						{
							String std_comp_qry = "select lookup_type, std_comp_result_type, lookup_url from am_standard_comp where  std_comp_id=?";
							std_comp_stmt = con.prepareStatement(std_comp_qry);
							std_comp_stmt.setString(1,std_comp_id);
							std_comp_rs = std_comp_stmt.executeQuery();
							
							while(std_comp_rs.next())
							{
								lookup_type = std_comp_rs.getString("lookup_type");
								std_comp_result_type = std_comp_rs.getString("std_comp_result_type");
								lookup_url = std_comp_rs.getString("lookup_url");
							}
							if(!std_comp_result_type.equals(""))
							{
								if(matrix_std_component_information.toString().equals(""))
								{
									matrix_std_component_information.append( (std_comp_id + "|" + lookup_type + "|" + std_comp_result_type +"|" + (comp_id+matrixID+srlNo) ));
								}
								else
								{
									matrix_std_component_information.append(("~" + std_comp_id + "|" + lookup_type + "|" + std_comp_result_type  +"|" + (comp_id+matrixID+srlNo)));
								}
							}
						}
						if(std_comp_rs!=null)
							std_comp_rs.close();
						if(std_comp_stmt!=null)
							std_comp_stmt.close();
						if(acceptOption.equals("R"))
						{
							if(mandatoryFields.equals(""))
								mandatoryFields.append(comp_id + matrixID + srlNo);
							else
								mandatoryFields.append("|" + comp_id + matrixID + srlNo);

//							madatoryGifDisplay    =    "<IMAGE SRC='../../eCommon/images/mandatory.gif'></IMAGE>";
							madatoryGifDisplay = "Y";
						}
						else
						 madatoryGifDisplay    =    "N";
						if(compType.equals("C"))
						{
							String check_box_prop="";
							if(defaultValue.equals("Y"))
								check_box_prop    =    "true";
							else
								check_box_prop    =    "";
							stringToReturn.append("<CHECK-BOX MATRIX-COMP=\"Y\" MATRIX-NAME=\"" + matrixID + "\" CLASS='LABEL' ALIGN='' NAME='"+(comp_id+matrixID+srlNo)+"' COLSPAN ='" + colSpan + "' CHECKED='"+check_box_prop+"' COMPTYPE='"+compType+"' COMPID='"+comp_id+"' DISCRID =\"" + actual_compId + "\" >"+ "</CHECK-BOX>");
						}
						String calender_gif="";
						String cal_date_time_validation="";
						if( compType.equals("D") )
						{
							maxAllowedLength    =    10;
//							validationClause    =    " ONBLUR = \"return CheckDate(this)\" ";
//							calender_gif = "Y";
//							cal_date_time_validation = "DD";
						}
						else if( compType.equals("T") )
						{
							maxAllowedLength    =    5;
//							validationClause    =    " ONBLUR = \"return callCheckTime(this)\" ";
							validationClause	=	"";

						}
						else if( compType.equals("E") )
						{
							maxAllowedLength    =    16;
//							validationClause    =    " ONBLUR = \"return callCheckDateTime(this)\" ";
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

//							validationClause    =    " UNIT=\""+fieldUnit+"\" ONBLUR = \"return checkValidRange(this,'min_max" + (comp_id+matrixID+srlNo) + "')\" ONKEYPRESS=\"return allowValidNumber(this,event,"+maxAllowedLength+",0)\" ";
							validationClause    =    " UNIT=\""+fieldUnit+"\" ";

						}
						if( compType.equals("N") )
						{
//							validationClause    =    " UNIT=\""+fieldUnit+"\" ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+(maxAllowedLength - numDecimalDigit)+","+numDecimalDigit+")\" ";
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
							stringToReturn.append("<DATE-TIME-NUMERIC MATRIX-COMP=\"Y\" MATRIX-NAME=\"" + matrixID + "\"  CLASS='LABEL' NAME='"+(comp_id+matrixID+srlNo)+"' COLSPAN ='" + colSpan + "' SIZE=\""+maxAllowedLength+"\"   MAXLENGTH='"+maxAllowedLength+"' VALUE='"+defaultValue+"' "+validationClause+" COMPTYPE='"+compType+"' MIN_DIGIT ='"+numdigitsmin+"' PROMPT='"+compPrompt+"' COMPID='"+comp_id+"'  DEC_DIGIT =\"" +numDecimalDigit +"\" DISCRID =\"" + actual_compId + "\" "); 

							if(compType.equals("D") || compType.equals("E") )
								stringToReturn.append("OTHLANGVAL='' >");
							else
								stringToReturn.append(" >");


							if( compType.equals("I") || compType.equals("N") )
							{
								stringToReturn.append("<HIDDEN-FIELD NAME='min_max"+(comp_id+matrixID+srlNo)+"'  VALUE='"+(minNumValue+"|"+maxNumValue)+"'></HIDDEN-FIELD>");
							}
//							stringToReturn.append(getCalenderGif(calender_gif, cal_date_time_validation, (comp_id+matrixID+srlNo))+madatoryGifDisplay);
							stringToReturn.append("</DATE-TIME-NUMERIC>");
						}
						if( compType.equals("H") )
						{
//							stringToReturn.append("<SHORT-TEXT MATRIX-COMP=\"Y\" MATRIX-NAME=\"" + matrixID + "\" COLSPAN ='" + colSpan + "'   CLASS='LABEL'  COLS =\"" + (Integer.parseInt(colSpan)*15) + "\" NAME='"+(comp_id+matrixID+srlNo)+"' ONBLUR=\"CheckMaximumLength('"+java.net.URLEncoder.encode(compPrompt)+"',this,"+maxAllowedLength+",top.messageFrame);\" ROWS=\"" + /*text_rows*/ "1" + "\" MANDATORY=\""+madatoryGifDisplay+"\">"+defaultValue + "</SHORT-TEXT>");
						stringToReturn.append("<SHORT-TEXT MATRIX-COMP=\"Y\" MATRIX-NAME=\"" + matrixID + "\" COLSPAN ='" + colSpan + "'   CLASS='LABEL'  COLS =\"" + (Integer.parseInt(colSpan)*15) + "\" NAME='"+(comp_id+matrixID+srlNo)+"' SIZE = \"" + maxAllowedLength + "\" ROWS=\"" + /*text_rows*/ "1" + "\"  DISCRID =\"" + actual_compId + "\">"+defaultValue + "</SHORT-TEXT>");
						}
						if(compType.equals("L"))
						{
							stringToReturn.append("<LIST-BOX MATRIX-COMP=\"Y\" MATRIX-NAME=\"" + matrixID + "\" COLSPAN ='" + colSpan + "'  CLASS='LABEL'  NAME='"+(comp_id+matrixID+srlNo)+"' COMPTYPE='"+compType+"' COMPID='"+comp_id+"' LOOK_UP_TYPE=\"" + lookup_type + "\" STD_COMP_RESULT_TYPE=\"" + std_comp_result_type + "\" STD_COMP_ID=\"" + std_comp_id + "\" LOOKUP_URL=\"" + lookup_url + "\" STD_COMP_VALUE=\"\"  DISCRID =\"" + actual_compId + "\"  DFLTSEL = 'SELECT'>"); 
							try
							{
								String strConstructedId = "";
								String strBuildId		=	"";
								String ref_range_seq	= "";

								strConstructedId=	comp_id+matrixID+srlNo+ "L_";

							 String query_list_values= "Select RESULT_VALUE list_item_id, REF_RNG_DESC list_item_text,   DFLT_YN default_yn,REF_RANGE_SEQ from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID = ?  order by REF_RANGE_SEQ";
								pstmt1=    con.prepareStatement(query_list_values);
								pstmt1.setString    (    1,    actual_compId        );
								rs1            =    pstmt1.executeQuery();
						

								while(rs1.next())
								{
									String list_item_id        =    checkForNull(rs1.getString("list_item_id"));
									String list_item_text		=    replaceSpecialChars(checkForNull(rs1.getString("list_item_text")));
									String default_yn			=    checkForNull(rs1.getString("default_yn"));
									ref_range_seq				=    checkForNull(rs1.getString("REF_RANGE_SEQ"));
									strBuildId					=	strConstructedId+ ref_range_seq;
									stringToReturn.append("<DATA VALUE='"+list_item_id+"'" + (default_yn.equals("Y")?" SELECTED='true' ":"") + " COMPITEMKEY = '"+strBuildId+"'>"+list_item_text+"</DATA>");
								}
								rs1.close();
								pstmt1.close();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							stringToReturn.append("<HIDDEN-FIELD NAME='"+(comp_id+matrixID+srlNo)+"_desc'  VALUE=''></HIDDEN-FIELD><HIDDEN-FIELD NAME='"+(comp_id+matrixID+srlNo)+"_code'  VALUE=''></HIDDEN-FIELD>" + "</LIST-BOX>");			
						}
						finalXMLString.append(stringToReturn);					
					}
					else
					{
						finalXMLString.append("<EMPTY-COLUMN MATRIX-COMP='Y' COLSPAN=\"" + colSpan + "\"/>");
					}
					finalXMLString.append("</MATRIX-COL>");
					srlNo++;
				}
				finalXMLString.append("</MATRIX-ROW>");
			}			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finalXMLString.append("<HIDDEN-FIELD NAME=\"matrix_mandatory_fields_" + matrixID + "\" VALUE=\""+mandatoryFields+"\"></HIDDEN-FIELD>");
		finalXMLString.append("<HIDDEN-FIELD NAME=\"matrix_std_component_information_"+matrixID+ "\" VALUE=\""+matrix_std_component_information+"\"></HIDDEN-FIELD>");
		finalXMLString.append("</MATRIX>");
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
