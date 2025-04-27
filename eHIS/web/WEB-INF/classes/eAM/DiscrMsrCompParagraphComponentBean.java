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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;


public class DiscrMsrCompParagraphComponentBean implements java.io.Serializable 
{
	public DiscrMsrCompParagraphComponentBean(){ 
		
	} 
	public synchronized String changeDefinitionToXML(Connection con,String definition,String comp_id)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		PreparedStatement std_comp_stmt = null;
		ResultSet std_comp_rs = null;
		PreparedStatement pstmt1=null;
		ResultSet rs1	=null;

		StringBuffer	mandatoryFields =new StringBuffer();
		StringBuffer  embedded_std_component_information =new StringBuffer();
		String compId = "";
		String actual_compId = "";
		int srlNo=0;
		try
		{
            definition = replaceSpecialChars(definition);  


			StringBuffer strbuf=new StringBuffer(definition);
		//   int k=0;
		   int h=0;
		   while(strbuf.indexOf(" ",h) != -1)
			{
			   h=strbuf.indexOf(" ",h);
			   if (strbuf.indexOf(" ",h+1)==h+1)
			   {
				   strbuf.replace(h,h+1,"&amp;#160;");
				   
			   }
             h++;
          
			}
            definition = strbuf.toString();  
           
			java.text.DecimalFormat	deciFormat	=	new java.text.DecimalFormat();
			deciFormat.setDecimalSeparatorAlwaysShown(false);			
			definition="<PARAGRAPH  COLSPAN='6' CLASS='LABEL'><PRE>"+definition;

			while(definition.indexOf("$$$")!=-1)
			{
				int i=definition.indexOf("$$$");
				int j=definition.indexOf("###");				
				if((j<i))
				{
					return "Component Tampered";					
				}
				else if((definition.substring(i+3,j).indexOf("$$$")!=-1) )
				{
					return "Component Tampered";					
				}
				actual_compId = definition.substring(i+3,j);
			    compId = actual_compId;

		        String query="select * from AM_DISCR_MSR where DISCR_MSR_ID=? ";
				stmt=con.prepareStatement(query);
				stmt.setString(1, actual_compId);
				rs=stmt.executeQuery();				
				int  maxAllowedLength=0;
			//	String validationClause="";
				int numDecimalDigit=0;
				int numdigitsmin=0;
				String defaultValue="";				
				String acceptOption="";
				int minNumValue=0;
				int maxNumValue=0;
                String madatoryGifDisplay="";
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
					//srlNo++;
					compPrompt = checkForNull(rs.getString("SHORT_DESC"));
					compType=checkForNull(rs.getString("RESULT_TYPE"));
					maxAllowedLength=rs.getInt("NUM_DIGITS_MAX");
					numDecimalDigit=rs.getInt("NUM_DIGITS_DEC");
					numdigitsmin=rs.getInt("NUM_DIGITS_MIN");
					minNumValue=rs.getInt("MIN_VALUE");
					maxNumValue=rs.getInt("MAX_VALUE");				
					std_comp_id		     = checkForNull(rs.getString("STD_COMP_ID"));
					link_to_std_value_yn = checkForNull(rs.getString("LINK_TO_STD_VALUE_YN"));
					
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
						if(embedded_std_component_information.toString().equals(""))
							embedded_std_component_information.append((std_comp_id + "|" + lookup_type + "|" + std_comp_result_type +"|" + "C_"+(compId+srlNo) ));
						else
							embedded_std_component_information.append("~" +(std_comp_id + "|" + lookup_type + "|" + std_comp_result_type +"|" + "C_"+(compId+srlNo) ));
					}
						
					if(std_comp_rs!=null) std_comp_rs.close();
					if(std_comp_stmt!=null) std_comp_stmt.close();
				
						
					if(acceptOption.equals("R"))	
					{
						mandatoryFields.append("C_"+compId+srlNo+"|");						
//						madatoryGifDisplay	=	"</PRE><IMAGE SRC='../../eCommon/images/mandatory.gif'></IMAGE><PRE>";
						madatoryGifDisplay  = "Y";
					}
					else
					{
						madatoryGifDisplay	=	"N";
					}					
					if(compType.equals("C"))
					{
						String check_box_prop="";
						if(defaultValue.equals("Y"))	
							check_box_prop	=	"true";
						else
							check_box_prop	=	"";

						stringToReturn.append("</PRE><CHECK-BOX-WTD CLASS='LABEL' ALIGN='' NAME='"+("C_"+compId+srlNo)+"' COMPTYPE='" + compType+ "' CHECKED='"+check_box_prop+"' MANDATORY=\""+madatoryGifDisplay+"\"></CHECK-BOX-WTD><PRE>");
					}
					//----------------
					//taking care of Date -Time -Numeric Fields
					String calender_gif="";
					String cal_date_time_validation="";
					if( compType.equals("D") )	
					{
						maxAllowedLength	=	10;
//						validationClause	=	" ONBLUR = \"return CheckDate(this)\" ";
						calender_gif = "Y";
						cal_date_time_validation = "DD";
					}else if( compType.equals("T") )	
					{
						maxAllowedLength	=	5;
//						validationClause	=	" ONBLUR = \"return callCheckTime(this)\" ";
					}
					else if( compType.equals("E") )	
					{
						maxAllowedLength	=	16;
//						validationClause	=	" ONBLUR = \"return callCheckDateTime(this)\" ";
						calender_gif = "Y";
						cal_date_time_validation = "DT";
					} 
					else
					{
						calender_gif="";
						cal_date_time_validation="";
					}					
					if( compType.equals("I") )	
					{
						if(maxAllowedLength == 0)
							maxAllowedLength = 20;
//						validationClause	=	"  ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+maxAllowedLength+",0)\" ";
					}
					if( compType.equals("N") )	
					{
//						validationClause	=	"  ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+(maxAllowedLength - numDecimalDigit)+","+numDecimalDigit+")\" ";
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
						stringToReturn.append("</PRE><DATE-TIME-NUMERIC-WTD CLASS='LABEL' NAME='"+("C_"+compId+srlNo)+"' COMPTYPE='"+compType+"' SIZE='"+maxAllowedLength+"' MIN_DIGIT ='"+numdigitsmin+"' MAXLENGTH='"+maxAllowedLength+"' VALUE='' MANDATORY=\""+madatoryGifDisplay+"\" ");

						if(compType.equals("D") || compType.equals("E") )
							stringToReturn.append("OTHLANGVAL=''");

						if(compType.equals("N") )
							stringToReturn.append("DEC_DIGIT='"+numDecimalDigit+"' >");
						else
							stringToReturn.append(" >");
						
						stringToReturn.append("</DATE-TIME-NUMERIC-WTD><PRE>");

						if( compType.equals("I") || compType.equals("N") )
						{
							stringToReturn.append("<HIDDEN-FIELD NAME='min_max"+("C_"+compId+srlNo)+"'  VALUE='"+(minNumValue+"|"+maxNumValue)+"'></HIDDEN-FIELD>");
						}
//						stringToReturn.append(getCalenderGif(calender_gif, cal_date_time_validation, ("C_"+compId+srlNo))+madatoryGifDisplay + "<PRE>");
					}
					//--------------------------
					//taking care of Short and Long Text
					if( compType.equals("H") )
					{
						stringToReturn.append("</PRE><SHORT-TEXT-WTD CLASS='LABEL'  NAME='"+("C_"+compId+srlNo)+"' 	 COMPTYPE='"+ compType + "' PROMPT='"+java.net.URLEncoder.encode(compPrompt)+"' SIZE ='"+maxAllowedLength+"' MANDATORY=\""+madatoryGifDisplay+"\"  MAXLENGTH = \"" + maxAllowedLength +"\" ></SHORT-TEXT-WTD><PRE>");
//						ONBLUR=\"CheckMaximumLength('"+ +"',this,"+maxAllowedLength+",top.messageFrame);\"  
					}
					if(compType.equals("F"))
					{
						stringToReturn.append("</PRE><LONG-TEXT-WTD CLASS='LABEL'  NAME='"+("C_"+compId+srlNo)+"'  COMPTYPE='"+ compType+"' MANDATORY=\""+madatoryGifDisplay+"\"></LONG-TEXT-WTD><PRE>");
					}
					//--------------------------------------
					if(compType.equals("L"))
					{
						stringToReturn.append("</PRE><LIST-BOX-WTD CLASS='LABEL'  COMPTYPE='"+compType+"' NAME='"+("C_"+compId+srlNo)+"' COMPID='"+comp_id+"' LOOK_UP_TYPE=\"" + lookup_type + "\" STD_COMP_RESULT_TYPE=\"" + std_comp_result_type + "\" STD_COMP_ID=\"" + std_comp_id + "\" LOOKUP_URL=\"" + lookup_url + "\" STD_COMP_VALUE=\"\"  DISCRID =\"" + actual_compId +"\"  DFLTSEL = 'SELECT"+"'  MANDATORY=\""+madatoryGifDisplay+"\">");
						
						try
						{
							String query_list_values="select discr_msr_id,REF_RNG_DESC,DFLT_YN,result_value from AM_DISCR_MSR_REF_RNG_LIST where discr_msr_id = ?  order by REF_RANGE_SEQ";
							pstmt1=	con.prepareStatement(query_list_values);
							pstmt1.setString	(1,actual_compId);
							rs1			=	pstmt1.executeQuery();
							while(rs1.next())
							{								
								//String list_item_id		=	checkForNull(rs1.getString("DISCR_MSR_ID"));
								String list_item_text	=	replaceSpecialChars(checkForNull(rs1.getString("REF_RNG_DESC")));
								String default_yn		=	checkForNull(rs1.getString("DFLT_YN"));
								String result_value		=	checkForNull(rs1.getString("result_value"));
								if(default_yn.equals("Y"))
								{
									stringToReturn.append("<DATA VALUE='"+result_value+"' SELECTED='true' >"+list_item_text+"</DATA>");
								}
								else
								{
									stringToReturn.append("<DATA VALUE='"+result_value+"'>"+list_item_text+"</DATA>");
								}
							}
							rs1.close();
							pstmt1.close();
						
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}						
						
						
					stringToReturn.append("<HIDDEN-FIELD NAME='"+("C_"+compId+srlNo)+"_desc'  VALUE=''></HIDDEN-FIELD></LIST-BOX-WTD><PRE>"+"</PRE><HIDDEN-FIELD NAME='"+("C_"+compId+srlNo)+"_desc'  VALUE=''></HIDDEN-FIELD><PRE>");
					
					}
					srlNo++;
				}
				
				else
				{
					return "Component Tampered- Unable to parse "+compId;	
				}
				if(rs !=null) rs.close();
				if(stmt!=null) stmt.close();
				StringBuffer temp=new StringBuffer(definition);
				temp.replace(i,j+3,stringToReturn.toString());
				definition=temp.toString();
			}
			/*while(definition.indexOf("\r")!=-1)
			{
				int a=definition.indexOf("\r");
				StringBuffer temp=new StringBuffer(definition);
				temp.replace(a,a+2,"</PRE>&amp&nbsp;   <PRE>");
				definition=temp.toString();
			}
			while(definition.indexOf("\n")!=-1)
			{
				int a=definition.indexOf("\n");
				StringBuffer temp=new StringBuffer(definition);
				temp.replace(a,a+2,"</PRE><FREE-TAG>&lt;br/&gt;</FREE-TAG><PRE>");
				definition=temp.toString();
			}*/
			while(definition.indexOf("\r\n")!=-1)
			{
				int a=definition.indexOf("\r\n");
				StringBuffer temp=new StringBuffer(definition);
				temp.replace(a,a+2,"</PRE><FREE-TAG>&lt;br/&gt;</FREE-TAG><PRE>");
				definition=temp.toString();
			}
			definition=definition+"</PRE><HIDDEN-FIELD NAME=\"mandatory_fields_para\" VALUE=\""+mandatoryFields+"\"></HIDDEN-FIELD><HIDDEN-FIELD NAME=\"para_std_component_information\" VALUE=\""+embedded_std_component_information+"\"></HIDDEN-FIELD><PRE>";
			definition=definition+"</PRE></PARAGRAPH>";
			
			return definition;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				if(stmt!=null) stmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
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
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;	
	}


}
