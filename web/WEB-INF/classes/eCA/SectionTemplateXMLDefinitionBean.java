/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
27/09/2013    IN043766       Karthi    		Alpha-CA- While Associating Matrix Component to Section, System Showing xml pagecannot be displayed.
11/07/2016    IN059630       Ramesh G    	GHL-CRF-0401
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
19/04/2017	IN064044		Raja S		19/04/2017		Ramesh G			ML-MMOH-SCF-0711
11/04/2017	IN061905		DineshT		25/4/2016		Ramesh G			The Scoring functionality In Notes should work in the similar manner as in Charts i.e on selection of individual variable, the score gets automatically calculated.
31/03/2017	IN061907	Krishna Gowtham J	26/02/2017	Ramesh G		ML-MMOH-CRF-0559
10/10/2018	IN064431	Kamalakannan	10/10/2018		Ramesh G		ML-MMOH-CRF-0867
22/10/2018	IN68297			Dinesh T	28/09/2018		Ramesh G			ML-MMOH-SCF-1061
04/05/2019	IN069484		Ramesh G										AMRI-CRF-0398
20/02/2024    54391   Krishna Pranay     21/02/2024     Ramesh Goli      COMMON-ICN-0275 
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
-------------------------------------------------------------------------------------------------------------------------------
*/

package eCA;
import java.sql.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
//IN061905, starts
import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCA.XMLtoHTML;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
//IN061905, ends

public class SectionTemplateXMLDefinitionBean implements java.io.Serializable
{
    String       strMandatoryCompIds        =    "",    	strMandatoryCompNames           =    	"";
    String       strListItemFields          =    "",    	strFormulaFuncsonBodyUnload   	=    	"";
    String       strLinkEventsBodyOnLoad    =    "",    	strGridCompIds        			= 		"";
    String       strMatrixNames            	=    "", 		strSTDCompInfn 					= 		"";
	String		 strGridNames				=	  "",		strLangId					  	=		"en";
    String		 strParaNames				=	"",  srtAllwdMaxLenghtCompIds= "" , strAllwdMaxLenghtComName  =  "" , srtAllwdMaxLenghtDistricCompIds =  "", strAllwdstrCompType="";  //68801
	int        paraNo                    =    0;
	HashMap<String, ArrayList> dep_comp_dtls = new HashMap<String, ArrayList>();//IN061905
	
	public StringBuffer constructXML(Connection con,String section)
    {
        boolean bOnlyFilledAtt = 	false;
        StringBuffer sbXMLTrSection		=	new StringBuffer();

		try
        {
            String strQryForSecParam = "SELECT 1 FROM CA_SECTION_HDG WHERE SEC_HDG_CODE = ? AND INCLUDE_ONLY_FILLED_COLUMN_YN ='Y'";
            PreparedStatement pstmt = con.prepareStatement(strQryForSecParam);
            pstmt.setString(1, section);
            ResultSet rs = pstmt.executeQuery();
        
			if(rs.next())
                bOnlyFilledAtt = true;
            
			pstmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }
		loadCompDepDetails(con, section);//IN061905
        
		sbXMLTrSection.append("<USER-TEMPLATE  ONLYFILLED=\"" + (bOnlyFilledAtt?"Y":"N") + "\" LANGID=\""+strLangId+"\" >");
        sbXMLTrSection.append("<ROW>");
        
		try
        {
			//IN059630 Start
            //String strSecTemplateQuery	="select SEC_HDG_CODE, SRL_NO, ITEM_TYPE, 'C_'||COMP_ID COMP_ID, comp_id actual_comp_id, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, PROMPT_DISPLAY_LOC, AGE_GROUP_CODE,  HIST_REC_TYPE, EVENT_CODE, PROMPT_ID  PROMPT_MESGID, LONG_DESC, SHORT_DESC, COMP_TYPE,  MAX_ALLOWED_LENGTH, NUM_DIGIT_DEC, MIN_REQ_LENGTH, ACCEPT_OPTION, MIN_NUM_VALUE,  MAX_NUM_VALUE, DFLT_VALUE, FIELD_UNIT, STD_COMP_ID, ASSOCIATE_SCORE_YN,  LINK_TO_STD_VALUE_YN, LIST_PRESENTATION, LIST_SELECTION, HINT_ID HINT_MESGID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,REF_RANGE_TYPE,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT ,NVL(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN, CASE WHEN CA_SECTION_DISCR_MSR_VW.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.PROMPT_ID,?,'1') ELSE CA_SECTION_DISCR_MSR_VW.COMP_PROMPT  END PROMPT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.HINT_ID,?,'1') ELSE '' END HINT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.TITLE_ID,?,'1') ELSE '' END TIT_VALUE, CA_SECTION_DISCR_MSR_VW.TITLE_ID TITLE_ID from CA_SECTION_DISCR_MSR_VW where SEC_HDG_CODE=?  order by row_pos_no, column_pos_no";
			//IN061907 start
			//String strSecTemplateQuery	="select SEC_HDG_CODE, SRL_NO, ITEM_TYPE, 'C_'||COMP_ID COMP_ID, comp_id actual_comp_id, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, PROMPT_DISPLAY_LOC, AGE_GROUP_CODE,  HIST_REC_TYPE, EVENT_CODE, PROMPT_ID  PROMPT_MESGID, LONG_DESC, SHORT_DESC, COMP_TYPE,  MAX_ALLOWED_LENGTH, NUM_DIGIT_DEC, MIN_REQ_LENGTH, ACCEPT_OPTION, MIN_NUM_VALUE,  MAX_NUM_VALUE, DFLT_VALUE, FIELD_UNIT, STD_COMP_ID, ASSOCIATE_SCORE_YN,  LINK_TO_STD_VALUE_YN, LIST_PRESENTATION, LIST_SELECTION, HINT_ID HINT_MESGID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,REF_RANGE_TYPE,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT ,NVL(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN, CASE WHEN CA_SECTION_DISCR_MSR_VW.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.PROMPT_ID,?,'1') ELSE CA_SECTION_DISCR_MSR_VW.COMP_PROMPT  END PROMPT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.HINT_ID,?,'1') ELSE '' END HINT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.TITLE_ID,?,'1') ELSE '' END TIT_VALUE, CA_SECTION_DISCR_MSR_VW.TITLE_ID TITLE_ID,TEXT_ALLIGN_YN from CA_SECTION_DISCR_MSR_VW where SEC_HDG_CODE=?  order by row_pos_no, column_pos_no";
			String strSecTemplateQuery	="select SEC_HDG_CODE, SRL_NO, ITEM_TYPE, 'C_'||COMP_ID COMP_ID, comp_id actual_comp_id, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, PROMPT_DISPLAY_LOC, AGE_GROUP_CODE,  HIST_REC_TYPE, EVENT_CODE, PROMPT_ID  PROMPT_MESGID, LONG_DESC, SHORT_DESC, COMP_TYPE,  MAX_ALLOWED_LENGTH, NUM_DIGIT_DEC, MIN_REQ_LENGTH, ACCEPT_OPTION, MIN_NUM_VALUE,  MAX_NUM_VALUE, DFLT_VALUE, FIELD_UNIT, STD_COMP_ID, ASSOCIATE_SCORE_YN,  LINK_TO_STD_VALUE_YN, LIST_PRESENTATION, LIST_SELECTION, HINT_ID HINT_MESGID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,REF_RANGE_TYPE,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT ,NVL(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN, CASE WHEN CA_SECTION_DISCR_MSR_VW.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.PROMPT_ID,?,'1') ELSE CA_SECTION_DISCR_MSR_VW.COMP_PROMPT  END PROMPT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.HINT_ID,?,'1') ELSE '' END HINT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.TITLE_ID,?,'1') ELSE '' END TIT_VALUE, CA_SECTION_DISCR_MSR_VW.TITLE_ID TITLE_ID,TEXT_ALLIGN_YN, AUTO_RESULT_YN from CA_SECTION_DISCR_MSR_VW where SEC_HDG_CODE=?  order by row_pos_no, column_pos_no";
			//IN061907 ends
			//IN059630 End
			String strCompDftQry	="Select NUM_DFLT_RESULT DFLT_VALUE,NUM_UOM FROM AM_DISCR_MSR_REF_RNG_NUM 	WHERE DISCR_MSR_ID=? order by REF_RANGE_SEQ ";
			
			PreparedStatement stmtGetDfltValue=con.prepareStatement(strCompDftQry);
			PreparedStatement stmt=con.prepareStatement(strSecTemplateQuery);
			
			ResultSet rsGetDfltValue=null;
            
			stmt.setString(1,"en");
			stmt.setString(2,"en");
			stmt.setString(3,"en");
			stmt.setString(4,section);

            ResultSet rsComponents=stmt.executeQuery();
            
			HashMap hmCompData=null;
            int nPrevRow=0;
            int nPrevCol=0;
            int nCounter=0;
            int nPrevColSpan=0;
            int nCurRowPos = 0;
            int nCurColPos = 0;
            int nCurColSpan = 0;
            
			while(rsComponents.next())
            {


				stmtGetDfltValue.setString(1,rsComponents.getString("actual_comp_id"));
				rsGetDfltValue=stmtGetDfltValue.executeQuery();

                hmCompData=new HashMap();

                hmCompData.put("SRL_NO",new Integer(rsComponents.getInt("SRL_NO")));
                hmCompData.put("ITEM_TYPE",rsComponents.getString("ITEM_TYPE"));
                hmCompData.put("COMP_ID",rsComponents.getString("COMP_ID"));
                hmCompData.put("ACTUAL_COMP_ID",rsComponents.getString("ACTUAL_COMP_ID"));
                hmCompData.put("TITLE_VALUE",rsComponents.getString("TIT_VALUE"));
				hmCompData.put("TITLE_ID",rsComponents.getString("TITLE_ID"));
                nCurRowPos=rsComponents.getInt("ROW_POS_NO");
                hmCompData.put("ROW_POS_NO",new Integer(nCurRowPos));
                nCurColPos=rsComponents.getInt("COLUMN_POS_NO");
                hmCompData.put("COLUMN_POS_NO",new Integer(nCurColPos));
                nCurColSpan=rsComponents.getInt("NO_OF_COL_SPAN");
                hmCompData.put("NO_OF_COL_SPAN",new Integer(nCurColSpan));
                hmCompData.put("PROMPT_DISPLAY_LOC",rsComponents.getString("PROMPT_DISPLAY_LOC"));
                hmCompData.put("COMP_PROMPTID",rsComponents.getString("PROMPT_MESGID"));
				hmCompData.put("COMP_MESG",rsComponents.getString("PROMPT_MESG"));
                hmCompData.put("HINT_MESGID",checkForNull(rsComponents.getString("HINT_MESGID")));
				hmCompData.put("HINT_MESG",checkForNull(rsComponents.getString("HINT_MESG")));
                hmCompData.put("COMP_TYPE",rsComponents.getString("COMP_TYPE"));
                hmCompData.put("MAX_ALLOWED_LENGTH",new Integer(rsComponents.getInt("MAX_ALLOWED_LENGTH")));
                hmCompData.put("NUM_DIGIT_DEC",new Integer(rsComponents.getInt("NUM_DIGIT_DEC")));
                hmCompData.put("MIN_REQ_LENGTH",new Integer(rsComponents.getInt("MIN_REQ_LENGTH")));
                hmCompData.put("ACCEPT_OPTION",rsComponents.getString("ACCEPT_OPTION"));
                hmCompData.put("MIN_NUM_VALUE",new Integer(rsComponents.getInt("MIN_NUM_VALUE")));
                hmCompData.put("MAX_NUM_VALUE",new Integer(rsComponents.getInt("MAX_NUM_VALUE")));

				if (rsGetDfltValue.next())
				{
					hmCompData.put("DFLT_VALUE",rsGetDfltValue.getString("DFLT_VALUE"));
					hmCompData.put("FIELD_UNIT",rsGetDfltValue.getString("NUM_UOM"));
				}

				if(rsGetDfltValue != null) rsGetDfltValue.close();

				hmCompData.put("HIST_REC_TYPE",rsComponents.getString("HIST_REC_TYPE"));
				hmCompData.put("EVENT_CODE",rsComponents.getString("EVENT_CODE"));
                hmCompData.put("SHORT_DESC",rsComponents.getString("SHORT_DESC"));
                hmCompData.put("STD_COMP_ID",checkForNull(rsComponents.getString("STD_COMP_ID")));
                hmCompData.put("LIST_PRESENTATION",checkForNull(rsComponents.getString("LIST_PRESENTATION")));
                hmCompData.put("LIST_SELECTION",checkForNull(rsComponents.getString("LIST_SELECTION")));
                hmCompData.put("NUM_PREFIX_REQUIRED_YN",checkForNull(rsComponents.getString("NUM_PREFIX_REQUIRED_YN")));
                hmCompData.put("FORMULA_RESULT_TYPE",checkForNull(rsComponents.getString("FORMULA_RESULT_TYPE")));
                hmCompData.put("FORMULA_INCLUDES_DATE_YN",checkForNull(rsComponents.getString("FORMULA_INCLUDES_DATE_YN")));
                hmCompData.put("FORMULA_RESULT_UNIT",checkForNull(rsComponents.getString("FORMULA_RESULT_UNIT")));
                hmCompData.put("REF_RANGE_TYPE",checkForNull(rsComponents.getString("REF_RANGE_TYPE")));
                hmCompData.put("LINK_TO_STD_VALUE_YN",checkForNull(rsComponents.getString("LINK_TO_STD_VALUE_YN")));				hmCompData.put("DFLT_FROM_HIST_APPL_YN",checkForNull(rsComponents.getString("DFLT_FROM_HIST_APPL_YN")));                
                hmCompData.put("OLD_HIST_TIME_FRAME_VAL",checkForNull(rsComponents.getString("OLD_HIST_TIME_FRAME_VAL")));              hmCompData.put("OLD_HIST_TIME_FRAME_UNIT",checkForNull(rsComponents.getString("OLD_HIST_TIME_FRAME_UNIT")));
				hmCompData.put("INCLUDE_FOR_ANAL_YN",checkForNull(rsComponents.getString("INCLUDE_FOR_ANAL_YN")));
				hmCompData.put("TEXT_ALLIGN_YN",checkForNull(rsComponents.getString("TEXT_ALLIGN_YN"))); //IN059630
				hmCompData.put("AUTO_RESULT_YN",checkForNull(rsComponents.getString("AUTO_RESULT_YN")));//IN061907

                if(nPrevRow<nCurRowPos && nCounter!=0)//putting end of row on change of the row and restricting when template is not starting from row 1
                {
                    sbXMLTrSection.append("</ROW>");
                    sbXMLTrSection.append("<ROW>");
                    nPrevCol=0;
                    nPrevColSpan=0;
                }
                //putting empty rows when there is diffrence of more then one
                while(nPrevRow<(nCurRowPos-1))
                {
                    sbXMLTrSection.append("<EMPTY-ROW></EMPTY-ROW>");
                    sbXMLTrSection.append("</ROW>");
                    sbXMLTrSection.append("<ROW>");
                    nPrevRow++;
                    nPrevCol=0;
                    nPrevColSpan=0;
                }
                nPrevRow=nCurRowPos;
                sbXMLTrSection.append("<COL>");
                while(nPrevCol<(nCurColPos-1))
                {
                    if(nPrevColSpan>1)
                    {
                        nPrevColSpan--;
                    }
                    else
                    {
                        sbXMLTrSection.append("<EMPTY-COLUMN></EMPTY-COLUMN>");
                        sbXMLTrSection.append("</COL>");
                        sbXMLTrSection.append("<COL>");
                    }
                    nPrevCol++;
                }
                nPrevCol=nCurColPos;
                sbXMLTrSection.append(buildTagsForComponents(con,hmCompData,section));
                sbXMLTrSection.append("</COL>");
                nPrevColSpan=nCurColSpan;
				
                nCounter++;

            }
            sbXMLTrSection.append("</ROW>");
			if(hmCompData != null) hmCompData.clear();
            if(strMandatoryCompIds.length()>0)
            {
                strMandatoryCompIds    =    strMandatoryCompIds.substring(0,strMandatoryCompIds.length()-1);
                if(strMandatoryCompNames.length()>0)
                {
                    strMandatoryCompNames    =    strMandatoryCompNames.substring(0,strMandatoryCompNames.length()-1);
                }
            }
            //68801 start.
            if(srtAllwdMaxLenghtCompIds.length()>0)
            {
            	srtAllwdMaxLenghtCompIds    =    srtAllwdMaxLenghtCompIds.substring(0,srtAllwdMaxLenghtCompIds.length()-1);
                if(strAllwdMaxLenghtComName.length()>0)
                {
                	strAllwdMaxLenghtComName    =    strAllwdMaxLenghtComName.substring(0,strAllwdMaxLenghtComName.length()-1);
                }
                if(srtAllwdMaxLenghtDistricCompIds.length()>0)
                {
                	srtAllwdMaxLenghtDistricCompIds    =    srtAllwdMaxLenghtDistricCompIds.substring(0,srtAllwdMaxLenghtDistricCompIds.length()-1);
                }
                strAllwdstrCompType    =    strAllwdstrCompType.substring(0,strAllwdstrCompType.length()-1);
            } 
            //68801 end.
            if(strListItemFields.length()>0)
            {
                strListItemFields    =    strListItemFields.substring(0,strListItemFields.length()-1);
            }
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"mandatory_fields\" VALUE=\""+strMandatoryCompIds+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"mandatory_names\"     VALUE=\""+strMandatoryCompNames+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"list_item_fields\" VALUE=\""+strListItemFields+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"grid_component_ids\" VALUE=\""+strGridCompIds+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"matrix_names\" VALUE=\""+strMatrixNames+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"grid_names\" VALUE=\""+strGridNames+"\"></HIDDEN-FIELD>");
			//shaiju st
			sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"paragraph_names\" VALUE=\""+strParaNames+"\"></HIDDEN-FIELD>");
			//shaiju ed
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"std_component_information\" VALUE=\""+strSTDCompInfn+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwdMaxLenghtCompIds\"     VALUE=\""+srtAllwdMaxLenghtCompIds+"\"></HIDDEN-FIELD>"); //68801
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwdMaxLenghtComName\"     VALUE=\""+strAllwdMaxLenghtComName+"\"></HIDDEN-FIELD>"); //68801
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwdMaxLenghtDisctComId\"     VALUE=\""+srtAllwdMaxLenghtDistricCompIds+"\"></HIDDEN-FIELD>"); //68801
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwd_Comp_type\"     VALUE=\""+strAllwdstrCompType+"\"></HIDDEN-FIELD>"); //68801

            sbXMLTrSection.append("<CALL-ON-UNLOAD VALUE='"+strFormulaFuncsonBodyUnload+"' />");
            //sbXMLTrSection.append("<CALL-ON-LOAD VALUE='callMeForStandardLinking();"+strLinkEventsBodyOnLoad+"' />");//INC61905
			sbXMLTrSection.append("<CALL-ON-LOAD VALUE='callMeForStandardLinking();setTimeout(function(){"+strLinkEventsBodyOnLoad+"},1000)' />");//INC61905
            sbXMLTrSection.append("</USER-TEMPLATE>");
            strMandatoryCompIds =    "";
            strMandatoryCompNames    =    "";
            strListItemFields    =    "";
            srtAllwdMaxLenghtCompIds    =    "";  //68801
            strAllwdMaxLenghtComName  =  "" ;   //68801
            srtAllwdMaxLenghtDistricCompIds = "" ; //68801
            strAllwdstrCompType =""; //68801
			if (rsGetDfltValue!= null)
			{
					rsGetDfltValue.close();
			}
			if (stmtGetDfltValue!= null)
			{
					stmtGetDfltValue.close();
			}
            if(rsComponents!=null) rsComponents.close();
            if(stmt !=null)stmt.close();

        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }

		
			
		return sbXMLTrSection;
    }

	public StringBuffer constructTemplateTypeXML(Connection con,String section)
    {
        boolean bOnlyFilledAtt = 	false;
        StringBuffer sbXMLTrSection		=	new StringBuffer();
		String		field_mnemonic = "";

		try
        {
            String strQryForSecParam = "SELECT 1 FROM CA_SECTION_HDG WHERE SEC_HDG_CODE = ? AND INCLUDE_ONLY_FILLED_COLUMN_YN ='Y'";
            PreparedStatement pstmt = con.prepareStatement(strQryForSecParam);
            pstmt.setString(1, section);
            ResultSet rs = pstmt.executeQuery();
        
			if(rs.next())
                bOnlyFilledAtt = true;
            
			pstmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }	

		loadCompDepDetails(con, section);//IN061905
		sbXMLTrSection.append("<USER-TEMPLATE  ONLYFILLED=\"" + (bOnlyFilledAtt?"Y":"N") + "\" LANGID=\""+strLangId+"\" >");
        sbXMLTrSection.append("<ROW>");
        
		try
        {
			//IN059630 Start
            //String strSecTemplateQuery	="select SEC_HDG_CODE, SRL_NO, ITEM_TYPE, 'C_'||COMP_ID COMP_ID, comp_id actual_comp_id, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, PROMPT_DISPLAY_LOC, AGE_GROUP_CODE,  HIST_REC_TYPE, EVENT_CODE, PROMPT_ID  PROMPT_MESGID, LONG_DESC, SHORT_DESC, COMP_TYPE,  MAX_ALLOWED_LENGTH, NUM_DIGIT_DEC, MIN_REQ_LENGTH, ACCEPT_OPTION, MIN_NUM_VALUE,  MAX_NUM_VALUE, DFLT_VALUE, FIELD_UNIT, STD_COMP_ID, ASSOCIATE_SCORE_YN,  LINK_TO_STD_VALUE_YN, LIST_PRESENTATION, LIST_SELECTION, HINT_ID HINT_MESGID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,REF_RANGE_TYPE,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT ,NVL(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN, CASE WHEN CA_SECTION_DISCR_MSR_VW.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.PROMPT_ID,?,'1') ELSE CA_SECTION_DISCR_MSR_VW.COMP_PROMPT  END PROMPT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.HINT_ID,?,'1') ELSE '' END HINT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.TITLE_ID,?,'1') ELSE '' END TIT_VALUE, CA_SECTION_DISCR_MSR_VW.TITLE_ID TITLE_ID from CA_SECTION_DISCR_MSR_VW where SEC_HDG_CODE=?  order by row_pos_no, column_pos_no";
			
			//IN061907 start
			//String strSecTemplateQuery	="select SEC_HDG_CODE, SRL_NO, ITEM_TYPE, 'C_'||COMP_ID COMP_ID, comp_id actual_comp_id, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, PROMPT_DISPLAY_LOC, AGE_GROUP_CODE,  HIST_REC_TYPE, EVENT_CODE, PROMPT_ID  PROMPT_MESGID, LONG_DESC, SHORT_DESC, COMP_TYPE,  MAX_ALLOWED_LENGTH, NUM_DIGIT_DEC, MIN_REQ_LENGTH, ACCEPT_OPTION, MIN_NUM_VALUE,  MAX_NUM_VALUE, DFLT_VALUE, FIELD_UNIT, STD_COMP_ID, ASSOCIATE_SCORE_YN,  LINK_TO_STD_VALUE_YN, LIST_PRESENTATION, LIST_SELECTION, HINT_ID HINT_MESGID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,REF_RANGE_TYPE,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT ,NVL(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN, CASE WHEN CA_SECTION_DISCR_MSR_VW.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.PROMPT_ID,?,'1') ELSE CA_SECTION_DISCR_MSR_VW.COMP_PROMPT  END PROMPT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.HINT_ID,?,'1') ELSE '' END HINT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.TITLE_ID,?,'1') ELSE '' END TIT_VALUE, CA_SECTION_DISCR_MSR_VW.TITLE_ID TITLE_ID,TEXT_ALLIGN_YN from CA_SECTION_DISCR_MSR_VW where SEC_HDG_CODE=?  order by row_pos_no, column_pos_no";
			String strSecTemplateQuery	="select SEC_HDG_CODE, SRL_NO, ITEM_TYPE, 'C_'||COMP_ID COMP_ID, comp_id actual_comp_id, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, PROMPT_DISPLAY_LOC, AGE_GROUP_CODE,  HIST_REC_TYPE, EVENT_CODE, PROMPT_ID  PROMPT_MESGID, LONG_DESC, SHORT_DESC, COMP_TYPE,  MAX_ALLOWED_LENGTH, NUM_DIGIT_DEC, MIN_REQ_LENGTH, ACCEPT_OPTION, MIN_NUM_VALUE,  MAX_NUM_VALUE, DFLT_VALUE, FIELD_UNIT, STD_COMP_ID, ASSOCIATE_SCORE_YN,  LINK_TO_STD_VALUE_YN, LIST_PRESENTATION, LIST_SELECTION, HINT_ID HINT_MESGID, NUM_PREFIX_REQUIRED_YN, FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,REF_RANGE_TYPE,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT ,NVL(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN, CASE WHEN CA_SECTION_DISCR_MSR_VW.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.PROMPT_ID,?,'1') ELSE CA_SECTION_DISCR_MSR_VW.COMP_PROMPT  END PROMPT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.HINT_ID,?,'1') ELSE '' END HINT_MESG, CASE WHEN CA_SECTION_DISCR_MSR_VW.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(CA_SECTION_DISCR_MSR_VW.TITLE_ID,?,'1') ELSE '' END TIT_VALUE, CA_SECTION_DISCR_MSR_VW.TITLE_ID TITLE_ID,TEXT_ALLIGN_YN, AUTO_RESULT_YN from CA_SECTION_DISCR_MSR_VW where SEC_HDG_CODE=?  order by row_pos_no, column_pos_no";
			//IN061907 ends
			//IN059630 End.
			String strCompDftQry	="Select NUM_DFLT_RESULT DFLT_VALUE,NUM_UOM FROM AM_DISCR_MSR_REF_RNG_NUM 	WHERE DISCR_MSR_ID=? order by REF_RANGE_SEQ ";
			
			PreparedStatement stmtGetDfltValue=con.prepareStatement(strCompDftQry);
			PreparedStatement stmt=con.prepareStatement(strSecTemplateQuery);
			
			ResultSet rsGetDfltValue=null;
            
			stmt.setString(1,"en");
			stmt.setString(2,"en");
			stmt.setString(3,"en");
			stmt.setString(4,section);

            ResultSet rsComponents=stmt.executeQuery();
            
			HashMap hmCompData=null;
            int nPrevRow=0;
            int nPrevCol=0;
            int nCounter=0;
            int nPrevColSpan=0;
            int nCurRowPos = 0;
            int nCurColPos = 0;
            int nCurColSpan = 0;
            PreparedStatement statement=null;
			ResultSet resultset=null;
			statement=con.prepareStatement("select FIELD_MNEMONIC_DATA_TYPE from CA_MNEMONIC where FIELD_MNEMONIC=?");
			while(rsComponents.next())
            {
				
				stmtGetDfltValue.setString(1,rsComponents.getString("actual_comp_id"));
				rsGetDfltValue=stmtGetDfltValue.executeQuery();

                hmCompData=new HashMap();

                hmCompData.put("SRL_NO",new Integer(rsComponents.getInt("SRL_NO")));
                hmCompData.put("ITEM_TYPE",rsComponents.getString("ITEM_TYPE"));
                hmCompData.put("COMP_ID",rsComponents.getString("COMP_ID"));
                hmCompData.put("ACTUAL_COMP_ID",rsComponents.getString("ACTUAL_COMP_ID"));
				field_mnemonic=rsComponents.getString("ACTUAL_COMP_ID");
                hmCompData.put("TITLE_VALUE",rsComponents.getString("TIT_VALUE"));
				hmCompData.put("TITLE_ID",rsComponents.getString("TITLE_ID"));
                nCurRowPos=rsComponents.getInt("ROW_POS_NO");
                hmCompData.put("ROW_POS_NO",new Integer(nCurRowPos));
                nCurColPos=rsComponents.getInt("COLUMN_POS_NO");
                hmCompData.put("COLUMN_POS_NO",new Integer(nCurColPos));
                nCurColSpan=rsComponents.getInt("NO_OF_COL_SPAN");
                hmCompData.put("NO_OF_COL_SPAN",new Integer(nCurColSpan));
                hmCompData.put("PROMPT_DISPLAY_LOC",rsComponents.getString("PROMPT_DISPLAY_LOC"));
                hmCompData.put("COMP_PROMPTID",rsComponents.getString("PROMPT_MESGID"));
				hmCompData.put("COMP_MESG",rsComponents.getString("PROMPT_MESG"));
                hmCompData.put("HINT_MESGID",checkForNull(rsComponents.getString("HINT_MESGID")));
				hmCompData.put("HINT_MESG",checkForNull(rsComponents.getString("HINT_MESG")));
                hmCompData.put("COMP_TYPE",rsComponents.getString("COMP_TYPE"));

                hmCompData.put("MAX_ALLOWED_LENGTH",new Integer(rsComponents.getInt("MAX_ALLOWED_LENGTH")));
                hmCompData.put("NUM_DIGIT_DEC",new Integer(rsComponents.getInt("NUM_DIGIT_DEC")));
                hmCompData.put("MIN_REQ_LENGTH",new Integer(rsComponents.getInt("MIN_REQ_LENGTH")));
                hmCompData.put("ACCEPT_OPTION",rsComponents.getString("ACCEPT_OPTION"));
                hmCompData.put("MIN_NUM_VALUE",new Integer(rsComponents.getInt("MIN_NUM_VALUE")));
                hmCompData.put("MAX_NUM_VALUE",new Integer(rsComponents.getInt("MAX_NUM_VALUE")));
	/*****get FIELD_MNEMONIC_DATA_TYPE from table "CA_MNEMONIC" to use as comp_type*********/
				try{
				statement.setString(1,field_mnemonic);
				resultset=statement.executeQuery();
				if((resultset !=null) && (resultset.next())){
					hmCompData.put("COMP_TYPE",resultset.getString("FIELD_MNEMONIC_DATA_TYPE"));	
				}

				}catch(Exception e){
					
					e.printStackTrace();
				}finally{
					if(resultset != null) resultset.close();
				}
	/*************************/

				if (rsGetDfltValue.next())
				{
					hmCompData.put("DFLT_VALUE",rsGetDfltValue.getString("DFLT_VALUE"));
					hmCompData.put("FIELD_UNIT",rsGetDfltValue.getString("NUM_UOM"));
				}

				if(rsGetDfltValue != null) rsGetDfltValue.close();

				hmCompData.put("HIST_REC_TYPE",rsComponents.getString("HIST_REC_TYPE"));
				hmCompData.put("EVENT_CODE",rsComponents.getString("EVENT_CODE"));
                hmCompData.put("SHORT_DESC",rsComponents.getString("SHORT_DESC"));
                hmCompData.put("STD_COMP_ID",checkForNull(rsComponents.getString("STD_COMP_ID")));
                hmCompData.put("LIST_PRESENTATION",checkForNull(rsComponents.getString("LIST_PRESENTATION")));
                hmCompData.put("LIST_SELECTION",checkForNull(rsComponents.getString("LIST_SELECTION")));
                hmCompData.put("NUM_PREFIX_REQUIRED_YN",checkForNull(rsComponents.getString("NUM_PREFIX_REQUIRED_YN")));
                hmCompData.put("FORMULA_RESULT_TYPE",checkForNull(rsComponents.getString("FORMULA_RESULT_TYPE")));
                hmCompData.put("FORMULA_INCLUDES_DATE_YN",checkForNull(rsComponents.getString("FORMULA_INCLUDES_DATE_YN")));
                hmCompData.put("FORMULA_RESULT_UNIT",checkForNull(rsComponents.getString("FORMULA_RESULT_UNIT")));
                hmCompData.put("REF_RANGE_TYPE",checkForNull(rsComponents.getString("REF_RANGE_TYPE")));
                hmCompData.put("LINK_TO_STD_VALUE_YN",checkForNull(rsComponents.getString("LINK_TO_STD_VALUE_YN")));				hmCompData.put("DFLT_FROM_HIST_APPL_YN",checkForNull(rsComponents.getString("DFLT_FROM_HIST_APPL_YN")));                
                hmCompData.put("OLD_HIST_TIME_FRAME_VAL",checkForNull(rsComponents.getString("OLD_HIST_TIME_FRAME_VAL")));              hmCompData.put("OLD_HIST_TIME_FRAME_UNIT",checkForNull(rsComponents.getString("OLD_HIST_TIME_FRAME_UNIT")));
				hmCompData.put("INCLUDE_FOR_ANAL_YN",checkForNull(rsComponents.getString("INCLUDE_FOR_ANAL_YN")));
				hmCompData.put("TEXT_ALLIGN_YN",checkForNull(rsComponents.getString("TEXT_ALLIGN_YN"))); //IN059630
				hmCompData.put("AUTO_RESULT_YN",checkForNull(rsComponents.getString("AUTO_RESULT_YN"))); //IN061907

                if(nPrevRow<nCurRowPos && nCounter!=0)//putting end of row on change of the row and restricting when template is not starting from row 1
                {
                    sbXMLTrSection.append("</ROW>");
                    sbXMLTrSection.append("<ROW>");
                    nPrevCol=0;
                    nPrevColSpan=0;
                }
                //putting empty rows when there is diffrence of more then one
                while(nPrevRow<(nCurRowPos-1))
                {
                    sbXMLTrSection.append("<EMPTY-ROW></EMPTY-ROW>");
                    sbXMLTrSection.append("</ROW>");
                    sbXMLTrSection.append("<ROW>");
                    nPrevRow++;
                    nPrevCol=0;
                    nPrevColSpan=0;
                }
                nPrevRow=nCurRowPos;
                sbXMLTrSection.append("<COL>");
                while(nPrevCol<(nCurColPos-1))
                {
                    if(nPrevColSpan>1)
                    {
                        nPrevColSpan--;
                    }
                    else
                    {
                        sbXMLTrSection.append("<EMPTY-COLUMN></EMPTY-COLUMN>");
                        sbXMLTrSection.append("</COL>");
                        sbXMLTrSection.append("<COL>");
                    }
                    nPrevCol++;
                }
                nPrevCol=nCurColPos;
                sbXMLTrSection.append(buildTagsForComponents(con,hmCompData,section));
                sbXMLTrSection.append("</COL>");
                nPrevColSpan=nCurColSpan;
				
                nCounter++;

            }
            sbXMLTrSection.append("</ROW>");
			if(hmCompData != null) hmCompData.clear();
            if(strMandatoryCompIds.length()>0)
            {
                strMandatoryCompIds    =    strMandatoryCompIds.substring(0,strMandatoryCompIds.length()-1);
                if(strMandatoryCompNames.length()>0)
                {
                    strMandatoryCompNames    =    strMandatoryCompNames.substring(0,strMandatoryCompNames.length()-1);
                }
            }
            //68801 start.
            if(srtAllwdMaxLenghtCompIds.length()>0)
            {
                if(strAllwdMaxLenghtComName.length()>0)
                {
                	strAllwdMaxLenghtComName    =    strAllwdMaxLenghtComName.substring(0,strAllwdMaxLenghtComName.length()-1);
                }
                if(srtAllwdMaxLenghtDistricCompIds.length()>0)
                {
                	srtAllwdMaxLenghtDistricCompIds    =    srtAllwdMaxLenghtDistricCompIds.substring(0,srtAllwdMaxLenghtDistricCompIds.length()-1);
                }
                strAllwdstrCompType    =    strAllwdstrCompType.substring(0,strAllwdstrCompType.length()-1);            	
            }
            //68801 end.
            if(strListItemFields.length()>0)
            {
                strListItemFields    =    strListItemFields.substring(0,strListItemFields.length()-1);
            }
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"mandatory_fields\" VALUE=\""+strMandatoryCompIds+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"mandatory_names\"     VALUE=\""+strMandatoryCompNames+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"list_item_fields\" VALUE=\""+strListItemFields+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"grid_component_ids\" VALUE=\""+strGridCompIds+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"matrix_names\" VALUE=\""+strMatrixNames+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"grid_names\" VALUE=\""+strGridNames+"\"></HIDDEN-FIELD>");
			//shaiju st
			sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"paragraph_names\" VALUE=\""+strParaNames+"\"></HIDDEN-FIELD>");
			//shaiju ed
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"std_component_information\" VALUE=\""+strSTDCompInfn+"\"></HIDDEN-FIELD>");
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwdMaxLenghtCompIds\" VALUE=\""+srtAllwdMaxLenghtCompIds+"\"></HIDDEN-FIELD>"); //68801
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwdMaxLenghtComName\" VALUE=\""+strAllwdMaxLenghtComName+"\"></HIDDEN-FIELD>"); //68801
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwdMaxLenghtDisctComId\"     VALUE=\""+srtAllwdMaxLenghtDistricCompIds+"\"></HIDDEN-FIELD>"); //68801
            sbXMLTrSection.append("<HIDDEN-FIELD NAME=\"allwd_Comp_type\"     VALUE=\""+strAllwdstrCompType+"\"></HIDDEN-FIELD>"); //68801

            sbXMLTrSection.append("<CALL-ON-UNLOAD VALUE='"+strFormulaFuncsonBodyUnload+"' />");
            sbXMLTrSection.append("<CALL-ON-LOAD VALUE='callMeForStandardLinking();"+strLinkEventsBodyOnLoad+"' />");
            sbXMLTrSection.append("</USER-TEMPLATE>");
            strMandatoryCompIds =    "";
            strMandatoryCompNames    =    "";
            strListItemFields    =    "";
            srtAllwdMaxLenghtCompIds = ""; //68801
            strAllwdMaxLenghtComName ="";  //68801
            srtAllwdMaxLenghtDistricCompIds="";//68801
            strAllwdstrCompType="";//68801
			if (rsGetDfltValue!= null)
			{
					rsGetDfltValue.close();
			}
			if (stmtGetDfltValue!= null)
			{
					stmtGetDfltValue.close();
			}
            if(rsComponents!=null) rsComponents.close();
            if(stmt !=null)stmt.close();

        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }		
		return sbXMLTrSection;
    }
    private String buildTagsForComponents(Connection con,HashMap hmCompInfn,String section)
    {
        StringBuffer stringToReturn						=    new StringBuffer();
	
        String        strConstructedCompId				=    checkForNull((String)hmCompInfn.get("COMP_ID"));
        String        strActualCompId					=    checkForNull((String)hmCompInfn.get("ACTUAL_COMP_ID"));
        String        strItemType						=    checkForNull((String)hmCompInfn.get("ITEM_TYPE"));
        String        strTitleValue						=    replaceSpecialChars(checkForNull((String)hmCompInfn.get("TITLE_VALUE")));
		String		  strTitleId						=	 checkForNull((String)hmCompInfn.get("TITLE_ID"));
        String        strPromptDisplayLocation			=    checkForNull((String)hmCompInfn.get("PROMPT_DISPLAY_LOC"));
        String        strPromptMesg						=    replaceSpecialChars(checkForNull((String)hmCompInfn.get("COMP_MESG")));
        String        strCompType						=    checkForNull((String)hmCompInfn.get("COMP_TYPE"));
        String        strCompAcceptOption				=    checkForNull((String)hmCompInfn.get("ACCEPT_OPTION"));
        String        strCompDfltValue					=    replaceSpecialChars(checkForNull((String)hmCompInfn.get("DFLT_VALUE")));
        String        strCompUnit						=    replaceSpecialChars(checkForNull((String)hmCompInfn.get("FIELD_UNIT")));
        String        strHistRecType					=    checkForNull((String)hmCompInfn.get("HIST_REC_TYPE"));
        String        strShortDesc						=    checkForNull((String)hmCompInfn.get("SHORT_DESC"));
        String        strSTDCompId						=    checkForNull((String)hmCompInfn.get("STD_COMP_ID"));
        String        strListBoxPresentation			=    checkForNull((String)hmCompInfn.get("LIST_PRESENTATION"));
        String        strListBoxSelection				=    checkForNull((String)hmCompInfn.get("LIST_SELECTION"));
        String        strHintMesg						=    replaceSpecialChars(checkForNull((String)hmCompInfn.get("HINT_MESG")));
        String        strNumPrefixYN					=    checkForNull((String)hmCompInfn.get("NUM_PREFIX_REQUIRED_YN"));
        String        strFormulaResultType				=    checkForNull((String)hmCompInfn.get("FORMULA_RESULT_TYPE"));
        String        strFormulaIncDateYN				=    checkForNull((String)hmCompInfn.get("FORMULA_INCLUDES_DATE_YN"));
        String        strFormulaResultUnit				=    checkForNull((String)hmCompInfn.get("FORMULA_RESULT_UNIT"));
        String        strEventCode						=    checkForNull((String)hmCompInfn.get("EVENT_CODE"));
		String        strLinkToSTDValueYN				=    checkForNull((String)hmCompInfn.get("LINK_TO_STD_VALUE_YN"));
        String        strDfltFromHistYN					=    checkForNull((String)hmCompInfn.get("DFLT_FROM_HIST_APPL_YN"));
        String        strHistTimeFrame					=    checkForNull((String)hmCompInfn.get("OLD_HIST_TIME_FRAME_VAL"));
        String        strHistTimeFrameUnit				=    checkForNull((String)hmCompInfn.get("OLD_HIST_TIME_FRAME_UNIT"));
		String		  strCompAnalysisRequired			=	 checkForNull((String)hmCompInfn.get("INCLUDE_FOR_ANAL_YN"));
		String		  strPromptId						=	 checkForNull((String)hmCompInfn.get("COMP_PROMPTID"));
		String		  strHintMesgId						=	 checkForNull((String)hmCompInfn.get("HINT_MESGID"));
		String		  grid_desc							=	""; // checkForNull((String)hmCompInfn.get("DISCR_MSR_DEF"));
		String		  locale							=	"en"; // checkForNull((String)hmCompInfn.get("DISCR_MSR_DEF"));

		int            nCompSrlNo						=    ((Integer)hmCompInfn.get("SRL_NO")).intValue();
        int            nCompMaxLength					=    ((Integer)hmCompInfn.get("MAX_ALLOWED_LENGTH")).intValue();
        int            nDecimalDigit					=    ((Integer)hmCompInfn.get("NUM_DIGIT_DEC")).intValue();		
        int            nMinDigit						=    ((Integer)hmCompInfn.get("MIN_REQ_LENGTH")).intValue();		
        int            nNumericMinValue					=    ((Integer)hmCompInfn.get("MIN_NUM_VALUE")).intValue();
        int            nNumericMaxValue					=    ((Integer)hmCompInfn.get("MAX_NUM_VALUE")).intValue();
        int            nColSpan							=    ((Integer)hmCompInfn.get("NO_OF_COL_SPAN")).intValue();
		String		  strTextAllingValueYN			=	 checkForNull((String)hmCompInfn.get("TEXT_ALLIGN_YN"));	//IN059630
		String		  linkDocYNFlag						=	 checkForNull((String)hmCompInfn.get("AUTO_RESULT_YN"));//IN061907
		if(hmCompInfn != null) hmCompInfn.clear();
		
        if(strListBoxPresentation.equals("M"))
            strCompType = "M";

        String        strFieldAssnCont					=    "",    strLookUpType				= "";
        String        strSTDCompResultType				=    "",    strLookupURL				= "";
		String		  onBlurReq = "N";
		String onBlurReqYN = "N";//IN061905
		String		  inputComp = "";

		StringBuffer strFormulaXML = new StringBuffer();
		StringBuffer strXMLDefinition = new StringBuffer();

		String LinkHist_Onclick = "openDefaultLookUp('"+strPromptMesg+"','"+strCompType+"','"+(strConstructedCompId+nCompSrlNo)+"','"+strHistRecType+"','"+strEventCode+"','"+strHistTimeFrame+"','"+strHistTimeFrameUnit+"')";
		StringBuilder onblurConcat = new StringBuilder();//IN061905
		StringBuilder onClickConcat = new StringBuilder();//IN061905
		ArrayList<String> l_dep_comp = new ArrayList<String>();//IN061905

		if(!strSTDCompId.equals(""))
        {
			
            try
            {
                PreparedStatement    pstmt_std_comp    =    null;
                ResultSet            rs_std_comp        =    null;
                String               qry_std_comp        = "select lookup_type, std_comp_result_type, lookup_url from am_standard_comp where  std_comp_id=?";

                pstmt_std_comp = con.prepareStatement(qry_std_comp);
                pstmt_std_comp.setString(1, strSTDCompId);
                rs_std_comp = pstmt_std_comp.executeQuery();
                
				if(rs_std_comp.next())
                {
                    strLookUpType               = checkForNull(rs_std_comp.getString("lookup_type"));
                    strSTDCompResultType		= checkForNull(rs_std_comp.getString("std_comp_result_type"));
                    strLookupURL				= checkForNull(rs_std_comp.getString("lookup_url"));
                }
                rs_std_comp.close();
                pstmt_std_comp.close();

				if(strSTDCompInfn.equals(""))
                    strSTDCompInfn = strSTDCompInfn + (strSTDCompId + "|" + strLookUpType + "|" + strSTDCompResultType +"|" + (strConstructedCompId+nCompSrlNo) );
                else
                    strSTDCompInfn = strSTDCompInfn + ("~" + strSTDCompId + "|" + strLookUpType + "|" + strSTDCompResultType  +"|" + (strConstructedCompId+nCompSrlNo));

            }
            catch(Exception e)
            {
                e.printStackTrace();
                
            }
        }
		//--------------NEW Additon to add addtional xml attributes on event handling 

		
		 try
            {
                PreparedStatement    pstmt_action_event_comp    =    null;
                ResultSet            rs_action_event_comp        =    null;
                String               qry_action_event_comp        = "SELECT ACTION_TYPE FROM CA_SPLTY_TEMP_EVENT WHERE SEC_HDG_CODE=? AND ACTION_ITEM_CODE=? AND ACTION_ITEM_SRLNO=?";
                
				String baseComp ="";
				PreparedStatement    pstmt_action_input_list    =    null;
                ResultSet            rs_action_input_list        =    null;
				String               qry_action_input_list        = "select BASE_ITEM_CODE||BASE_ITEM_SRLNO base_comp from CA_SPLTY_TEMP_INPUT_LIST WHERE SEC_HDG_CODE=? AND ACTION_ITEM_CODE=? AND ACTION_ITEM_SRLNO=?";

				pstmt_action_input_list = con.prepareStatement(qry_action_input_list);
                pstmt_action_input_list.setString(1, section);
                pstmt_action_input_list.setString(2, strActualCompId);
                pstmt_action_input_list.setInt(3, nCompSrlNo);
				rs_action_input_list = pstmt_action_input_list.executeQuery();
				while(rs_action_input_list.next())
				{
					baseComp = rs_action_input_list.getString("base_comp");
					
					if(inputComp.equals(""))
						inputComp = baseComp;
					else
						inputComp=inputComp+"~" + baseComp;
				}

				if(rs_action_input_list !=null)		rs_action_input_list.close();
                if(pstmt_action_input_list !=null)	pstmt_action_input_list.close();
				
                pstmt_action_event_comp = con.prepareStatement(qry_action_event_comp);
                pstmt_action_event_comp.setString(1, section);
                pstmt_action_event_comp.setString(2, strActualCompId);
				pstmt_action_event_comp.setInt(3,nCompSrlNo);
                rs_action_event_comp = pstmt_action_event_comp.executeQuery();
                
				if(rs_action_event_comp.next())
                {
                    onBlurReq               = "Y";
				}
                if(rs_action_event_comp !=null)		rs_action_event_comp.close();
                if(pstmt_action_event_comp !=null)	pstmt_action_event_comp.close();

				/*if(strSTDCompInfn.equals(""))
                    strSTDCompInfn = strSTDCompInfn + (strSTDCompId + "|" + strLookUpType + "|" + strSTDCompResultType +"|" + (strConstructedCompId+nCompSrlNo) );
                else
                    strSTDCompInfn = strSTDCompInfn + ("~" + strSTDCompId + "|" + strLookUpType + "|" + strSTDCompResultType  +"|" + (strConstructedCompId+nCompSrlNo));

				*/

            }
            catch(Exception e)
            {
                e.printStackTrace();
                
            }
		//IN061905, starts
		if("I".equals(strCompType) || "N".equals(strCompType) || "D".equals(strCompType) || "E".equals(strCompType))
		{
			if(dep_comp_dtls.get(strConstructedCompId+nCompSrlNo)!=null)
				onBlurReqYN = "Y";
		}
		//IN061905, ends

		//--------------
        
        if(strCompType.equals("C") || strCompType.equals("L"))
        {
            PreparedStatement pstmt2=null;
            ResultSet rs2    =null;
            try
            {
                String queryXMLDef=" select DEP_DEFINITION from ca_section_template where SEC_HDG_CODE=? and COMP_ID= ? and SRL_NO =? ";
                pstmt2=    con.prepareStatement(queryXMLDef);
                pstmt2.setString(1,section);
                pstmt2.setString(2,strActualCompId);
                pstmt2.setInt(3,nCompSrlNo);
                rs2    =    pstmt2.executeQuery();
				Clob formula_def_clob = null;
        
				if(rs2.next())
				{
						formula_def_clob = rs2.getClob(1);
						if(formula_def_clob!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(formula_def_clob.getCharacterStream());
							String line = "";
							while((line = r.readLine())!=null)
									strFormulaXML.append(line);
						}		
						if(strFormulaXML ==null)
								strFormulaXML.append("");

						strFieldAssnCont = strFormulaXML.toString();
				}

                if(rs2 !=null) rs2.close();
                if(pstmt2 !=null) pstmt2.close();
            }
            catch(Exception e)
            {
                
                e.printStackTrace();
            }
        }
        
        String strMandatoryYN="";


		if(strCompAcceptOption.equals("R"))
        {
            strMandatoryCompIds       = strMandatoryCompIds + strConstructedCompId+nCompSrlNo+"|";
            strMandatoryCompNames        = strMandatoryCompNames + strPromptMesg+"|";
            strMandatoryYN	  = "Y";
        }
        else
        	strMandatoryYN    = "N";
        //68801 start.
		if(strCompType.equals("H") || strCompType.equals("F"))
        {
		     srtAllwdMaxLenghtCompIds       = srtAllwdMaxLenghtCompIds + strConstructedCompId+nCompSrlNo+"|";
		     srtAllwdMaxLenghtDistricCompIds        = srtAllwdMaxLenghtDistricCompIds + strActualCompId+"|";
			strAllwdMaxLenghtComName        = strAllwdMaxLenghtComName + strPromptMesg+"|";
			strAllwdstrCompType        = strAllwdstrCompType + strCompType+"|";			
        }
		//68801 end.
		if(strItemType.equals("T"))
        {
            if(strPromptDisplayLocation.equals("C"))
            {
                stringToReturn.append("<TITLE-TEXT COLSPAN='"+3*nColSpan+"' ALIGN='center' CLASS='ITEMSELECT' TYPE='C' TITLE_ID ='"+strTitleId+"'>"+strTitleValue+"</TITLE-TEXT>");
            }
            else
            {
                stringToReturn.append("<TITLE-TEXT COLSPAN='"+3*nColSpan+"' ALIGN='left' TYPE='T' TITLE_ID = '"+strTitleId+"'>"+strTitleValue+"</TITLE-TEXT>");
            }
            return stringToReturn.toString();
        }
        if(strCompType.equals("C"))
        {
            String check_box_prop="";
			String check_box_val ="";
            String onClickEvent="";
            
            if(strCompDfltValue.equals("Y"))
			{
                check_box_prop    =    "true";
				check_box_val	  =		"Y";
			}
            else
			{
                check_box_prop		=    "";
				check_box_val		=	"N";
			}
            
			if(strFieldAssnCont!=null && !strFieldAssnCont.equals(""))
            {
				//onClickEvent = "ONCLICK = 'fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(this)'";
				onClickEvent = "ONCLICK = 'fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(this)";
                if(!strLinkEventsBodyOnLoad.contains("fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(document.forms(0)."+(strConstructedCompId+nCompSrlNo)+")"))//IN061905
				{
					
					strLinkEventsBodyOnLoad = strLinkEventsBodyOnLoad + "fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(document.forms(0)."+(strConstructedCompId+nCompSrlNo)+");";
				}
            }
			//IN061905, starts
			if(dep_comp_dtls.get(strConstructedCompId+nCompSrlNo)!=null)
            {
				l_dep_comp = dep_comp_dtls.get(strConstructedCompId+nCompSrlNo);
				onClickConcat = new StringBuilder();

				for(int dep_index = 0;dep_index<l_dep_comp.size();dep_index++)
				{
					if(!strLinkEventsBodyOnLoad.contains("getFormulaResult"+l_dep_comp.get(dep_index)+"()"))
					{
						strLinkEventsBodyOnLoad = strLinkEventsBodyOnLoad + "getFormulaResult"+l_dep_comp.get(dep_index)+"();";
					}

					onClickConcat.append("getFormulaResult"+l_dep_comp.get(dep_index)+"();");
				}

				if(!"".equals(onClickEvent))
				{
					onClickEvent = onClickEvent+";"+onClickConcat;
				}
				else if("".equals(onClickEvent))
				{
					onClickEvent = " ONCLICK = '"+onClickConcat+"";
				}				
			}

			if(!onClickEvent.equals(""))
				onClickEvent = onClickEvent+"'";
			//IN061905, ends
            stringToReturn.append("<CHECK-BOX CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' ALIGN='' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' CHECKED='"+check_box_prop+"' VALUE ='"+check_box_val+"'  PROMPT_ID='"+strPromptId+"' PROMPT='"+strPromptMesg+"' "+onClickEvent+" HINTMESG_ID = '" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg+"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo +"\" MANDATORY=\""+strMandatoryYN+"\" >"+strFieldAssnCont+"</CHECK-BOX>");
        }
        
        String validationClause    =    "";
//        String calender_gif="";
//        String cal_date_time_validation="";
        
        if( strCompType.equals("D") ) 
        {
            nCompMaxLength    =    10;
				validationClause ="";
    //        validationClause    =    " ONBLUR = \"return CheckDate(this)\" ";
  //          calender_gif = "Y";
  //          cal_date_time_validation = "DD";
        }else if( strCompType.equals("T") )
        {
            nCompMaxLength    =    5;
			validationClause ="";
  //          validationClause    =    " ONBLUR = \"return callCheckTime(this)\" ";
        }
        else if( strCompType.equals("E") )
        {
            nCompMaxLength    =    16;
			validationClause ="";
//            validationClause    =    " ONBLUR = \"return callCheckDateTime(this)\" ";
    //        calender_gif = "Y";
    //        cal_date_time_validation = "DT";
        }
        else{
      //      calender_gif="";
      //      cal_date_time_validation="";
        }
        if( strCompType.equals("I") )
        {
//            validationClause    =    " UNIT=\""+strCompUnit+"\" ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+nCompMaxLength+",0)\" ";
          validationClause    =    " UNIT=\""+strCompUnit+"\" ";
        }
        if( strCompType.equals("N") )
        {
  //          validationClause    =    " UNIT=\""+strCompUnit+"\" ONBLUR = \"return checkValidRange(this)\" ONKEYPRESS=\"return allowValidNumber(this,event,"+(nCompMaxLength)+","+nDecimalDigit+")\" ";
              validationClause    =    " UNIT=\""+strCompUnit+"\" ";
            //nCompMaxLength++;
			}

        if( strCompType.equals("D") || strCompType.equals("T") || strCompType.equals("E") || strCompType.equals("I") || strCompType.equals("N") )
        {
            if(strCompDfltValue.length() > (nCompMaxLength==0?20:nCompMaxLength))
					strCompDfltValue = "";

			stringToReturn.append("<DATE-TIME-NUMERIC CLASS='LABEL'  COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' SIZE=\""+(nCompMaxLength==0?20:nCompMaxLength)+"\" LINK_HIST_YN=\"" + strDfltFromHistYN +"\"  PROMPT_ID='"+strPromptId+"' PROMPT='"+strPromptMesg+"' MAXLENGTH='"+(nCompMaxLength==0?20:nCompMaxLength)+"' VALUE='"+strCompDfltValue+"' "+validationClause+ ((strCompType.equals("I") || strCompType.equals("N"))?("NUM_PREFIX_REQUIRED_YN=\"" + strNumPrefixYN + "\""):"") +" HINT_MESG_ID='"+strHintMesgId+ "'  HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo  + "\" PREFIX_CHAR=\"\" MANDATORY=\""+strMandatoryYN+"\" ");

			if(strCompType.equals("I")||strCompType.equals("N")){

			stringToReturn.append(" MIN_DIGIT='"+nMinDigit+"' ");	
			stringToReturn.append(" REF_LOW='' REF_HIGH='' CRIT_LOW='' CRIT_HIGH='' ");	
			}

			//Shaiju for onblur fun of MC 
			if(onBlurReq.equals("Y"))
			{
			stringToReturn.append("ONBLURREQ='Y' INPUT=\""+inputComp+"\" ");	
			}
			else //Deepa on 22/10/2007 at 9:30 AM
			{
				//IN061905, starts
				if("Y".equals(onBlurReqYN))
				{
					l_dep_comp = dep_comp_dtls.get(strConstructedCompId+nCompSrlNo);

					for(int dep_index = 0;dep_index<l_dep_comp.size();dep_index++)
					{
						//onblurConcat.append("getFormulaResult"+l_dep_comp.get(dep_index)+"();");//IN68297
						onblurConcat.append("getFormulaResultLoadUnload"+l_dep_comp.get(dep_index)+"();");//IN68297
					}

					stringToReturn.append(" ONBLURREQ='Y' ONBLUR='"+onblurConcat+"' ");
				}
				else
				{
					stringToReturn.append(" ONBLURREQ='N' ");
				}
				//IN061905, ends
			}

			//Shaiju
			if(strCompType.equals("D") || strCompType.equals("E") )
				stringToReturn.append("OTHLANGVAL=''");

			if(strCompType.equals("N"))
			{
				stringToReturn.append("DEC_DIGIT='"+(nDecimalDigit==0?18:nDecimalDigit)+"' >");				
			}
			else
			stringToReturn.append(">");

            if( strCompType.equals("I") || strCompType.equals("N") )
                stringToReturn.append("<HIDDEN-FIELD NAME='min_max"+(strConstructedCompId+nCompSrlNo)+"'  VALUE='"+(nNumericMinValue+"|"+nNumericMaxValue)+"'></HIDDEN-FIELD>");
            if(strLinkToSTDValueYN.equals("N") && strDfltFromHistYN.equals("Y") && (strCompType.equals("I") || strCompType.equals("N")))
				stringToReturn.append("<LINK-HISTORY-BUTTON CLASS='BUTTON' NAME='"+(strConstructedCompId+nCompSrlNo)+"'  HIST_REC_TYPE=\"" + strHistRecType + "\"  EVENT_CODE=\"" + strEventCode + "\"  HIST_VAL=\"" + strHistTimeFrame + "\"  HIST_UNIT=\"" + strHistTimeFrameUnit + "\" ONCLICK=\"" + LinkHist_Onclick + "\"  ></LINK-HISTORY-BUTTON>");
//			else
//				stringToReturn.append(getCalenderGif(calender_gif, cal_date_time_validation, (strConstructedCompId+nCompSrlNo)));
			
            stringToReturn.append("</DATE-TIME-NUMERIC>");
        }
        if( strCompType.equals("H") )
        {
			if((strLinkToSTDValueYN.equals("N")|| (strLinkToSTDValueYN.equals("Y")))&& (strDfltFromHistYN.equals("Y")) )
			{
				//IN059630 Start.
				//stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*15)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\" LINK_HIST_YN=\"" + strDfltFromHistYN + "\" HINT_MESG_ID='"+strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\"  DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue);
			    //stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*15)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\" LINK_HIST_YN=\"" + strDfltFromHistYN + "\" HINT_MESG_ID='"+strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue); //68801
				stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*60)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\" LINK_HIST_YN=\"" + strDfltFromHistYN + "\" HINT_MESG_ID='"+strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue); //68801

				//IN059630 End.
				stringToReturn.append("<LINK-HISTORY-BUTTON CLASS='BUTTON' NAME='"+(strConstructedCompId+nCompSrlNo)+"' LINK_HIST_YN=\"" + strDfltFromHistYN + "\" HIST_REC_TYPE=\"" + strHistRecType + "\"  EVENT_CODE=\"" + strEventCode + "\"  HIST_VAL=\"" + strHistTimeFrame + "\"  HIST_UNIT=\"" + strHistTimeFrameUnit + "\" ONCLICK=\"" + LinkHist_Onclick + "\"  ></LINK-HISTORY-BUTTON></SHORT-TEXT>");
			}
			else{
				//IN059630 Start.
				//stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*15)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\"  LOOK_UP_TYPE=\"" + strLookUpType + "\" STD_COMP_RESULT_TYPE=\"" + strSTDCompResultType + "\" STD_COMP_ID=\"" + strSTDCompId+ "\" HINT_MESG_ID='"+strHintMesgId  + "' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</SHORT-TEXT>");
			    //stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*15)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\"  LOOK_UP_TYPE=\"" + strLookUpType + "\" STD_COMP_RESULT_TYPE=\"" + strSTDCompResultType + "\" STD_COMP_ID=\"" + strSTDCompId+ "\" HINT_MESG_ID='"+strHintMesgId  + "' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</SHORT-TEXT>");    //68801
				stringToReturn.append("<SHORT-TEXT CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*60)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\"  LOOK_UP_TYPE=\"" + strLookUpType + "\" STD_COMP_RESULT_TYPE=\"" + strSTDCompResultType + "\" STD_COMP_ID=\"" + strSTDCompId+ "\" HINT_MESG_ID='"+strHintMesgId  + "' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</SHORT-TEXT>");    //68801
				//IN059630 End.
			}
        }
        //IN069484 Start 
        if( strCompType.equals("G") )
        {
			stringToReturn.append("<IMAGE-TAG CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' COLS='"+((2*nColSpan-1)*15)+"'        PROMPT_ID = '"+strPromptId+"'    PROMPT='"+strPromptMesg+"' SIZE = \"" +nCompMaxLength + "\"  LOOK_UP_TYPE=\"" + strLookUpType + "\" STD_COMP_RESULT_TYPE=\"" + strSTDCompResultType + "\" STD_COMP_ID=\"" + strSTDCompId+ "\" HINT_MESG_ID='"+strHintMesgId  + "' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</IMAGE-TAG>");
        }
        //IN069484 End
        if(strCompType.equals("F"))
        {
			//IN059630 Start.
           // stringToReturn.append("<LONG-TEXT CLASS='LABEL' COLSPAN='"+(3*nColSpan-1)+"' PROMPT_ID ='" +strPromptId +"' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' RECORD-TYPE='"+strHistRecType+"' HINT_MESG_ID='" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\"  DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</LONG-TEXT>");
			//IN061907 start
			//stringToReturn.append("<LONG-TEXT CLASS='LABEL' COLSPAN='"+(3*nColSpan-1)+"' PROMPT_ID ='" +strPromptId +"' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' RECORD-TYPE='"+strHistRecType+"' HINT_MESG_ID='" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</LONG-TEXT>");
			stringToReturn.append("<LONG-TEXT CLASS='LABEL' COLSPAN='"+(3*nColSpan-1)+"' PROMPT_ID ='" +strPromptId +"' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' RECORD-TYPE='"+strHistRecType+"' HINT_MESG_ID='" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" TXTALLIGNYN =\""+strTextAllingValueYN +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" LINKDOC-YN=\""+linkDocYNFlag+"\" MANDATORY=\""+strMandatoryYN+"\">"+strCompDfltValue+"</LONG-TEXT>");
			//IN061907 ends
			//IN059630 End.
		}
        //--------------------------------------
        //taking care of List and Mulit-list components
        if(strCompType.equals("L") || strCompType.equals("M"))
        {
            strListItemFields        = strListItemFields + strConstructedCompId+nCompSrlNo+"|";
            String onChangeEvent = "";
            
            if(strFieldAssnCont!=null && !strFieldAssnCont.equals(""))
            {
                if(strCompType.equals("L"))
                {
                    //onChangeEvent = "ONCHANGE = 'fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(this)'";//IN061905
                    onChangeEvent = "ONCHANGE = 'fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(this)";//IN061905
					if(!strLinkEventsBodyOnLoad.contains("fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(document.forms(0)."+(strConstructedCompId+nCompSrlNo)+")"))//IN061905
					{
						strLinkEventsBodyOnLoad = strLinkEventsBodyOnLoad+"fireOnAction"+(strConstructedCompId+nCompSrlNo)+"(document.forms(0)."+(strConstructedCompId+nCompSrlNo)+");";
					}
                }
            }
			//IN061905, starts
			if(dep_comp_dtls.get(strConstructedCompId+nCompSrlNo)!=null)
            {
				l_dep_comp = dep_comp_dtls.get(strConstructedCompId+nCompSrlNo);
				onblurConcat = new StringBuilder();

				for(int dep_index = 0;dep_index<l_dep_comp.size();dep_index++)
				{
					if(!strLinkEventsBodyOnLoad.contains("getFormulaResult"+l_dep_comp.get(dep_index)+"()"))
					{
						strLinkEventsBodyOnLoad = strLinkEventsBodyOnLoad + "getFormulaResult"+l_dep_comp.get(dep_index)+"();";
					}

					onblurConcat.append("getFormulaResult"+l_dep_comp.get(dep_index)+"();");
				}

				if(!"".equals(onChangeEvent))
				{
					onChangeEvent = onChangeEvent+";"+onblurConcat;
				}
				else if("".equals(onChangeEvent))
				{
					onChangeEvent = " ONCHANGE = '"+onblurConcat+"";
				}				
			}
			       
			if(!onChangeEvent.equals(""))
				onChangeEvent = onChangeEvent+"'";
			//IN061905, ends
            if(strCompType.equals("L"))
			{
				if(strSTDCompResultType.equals("") && strSTDCompId.equals(""))
					stringToReturn.append("<LIST-BOX CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' PROMPT_ID='" +strPromptId+ "' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' "+onChangeEvent+" LOOK_UP_TYPE=\"" + strLookUpType + "\"  LIST_PRESENTATION=\"" + strListBoxPresentation + "\"  LIST_SELECTION=\"" + strListBoxSelection + "\" HINT_MESG_ID='" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\" DFLTSEL = 'Select'>");
				else
					stringToReturn.append("<LIST-BOX CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' PROMPT_ID='"+strPromptId + "' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' "+onChangeEvent+" LOOK_UP_TYPE=\"" + strLookUpType + "\" STD_COMP_RESULT_TYPE=\"" + strSTDCompResultType + "\" STD_COMP_ID=\"" + strSTDCompId + "\" LOOKUP_URL=\"" + strLookupURL + "\" STD_COMP_VALUE=\"\" LIST_PRESENTATION=\"" + strListBoxPresentation + "\"  LIST_SELECTION=\"" + strListBoxSelection + "\" HINT_MESG_ID ='"+strHintMesgId +"'  HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\" DFLTSEL = 'Select'>");
			}
            else if(strCompType.equals("M"))
                //stringToReturn.append("<MULTI-LIST CLASS='LABEL' COLSPAN='"+2*nColSpan+"' PROMPT_ID='" + strPromptId + "' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' HEADER = '" + strShortDesc + "' LIST_PRESENTATION=\"" + strListBoxPresentation + "\"   LIST_SELECTION=\"" + strListBoxSelection + "\" HINT_MESG_ID='" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\"><MULTI-LIST-ROW>");
            	stringToReturn.append("<MULTI-LIST CLASS='LABEL' COLSPAN='"+2*nColSpan+"' PROMPT_ID='" + strPromptId + "' PROMPT='"+strPromptMesg+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"' COMPTYPE='"+strCompType+"' HEADER = '" + strPromptMesg + "' LIST_PRESENTATION=\"" + strListBoxPresentation + "\"   LIST_SELECTION=\"" + strListBoxSelection + "\" HINT_MESG_ID='" +strHintMesgId +"' HINT_MESSAGE=\"" + strHintMesg +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo + "\" MANDATORY=\""+strMandatoryYN+"\"><MULTI-LIST-ROW>");//IN064431

            PreparedStatement pstmt1=null;
            ResultSet rs1    =null;
			StringBuffer append_score = new StringBuffer();
			String def_score = "";
            
			try
            {
                String query_list_values=    " SELECT RESULT_VALUE LIST_ITEM_ID, REF_RNG_DESC LIST_ITEM_TEXT,   DFLT_YN DEFAULT_YN, REF_RANGE_SEQ, NUMERIC_VALUE FROM AM_DISCR_MSR_REF_RNG_LIST WHERE DISCR_MSR_ID = ?  ORDER BY SORT_ORDER ";
                pstmt1=    con.prepareStatement(query_list_values);

                pstmt1.setString    (    1,    strActualCompId        );

                rs1            =    pstmt1.executeQuery();

                int number_of_checkboxes_in_one_row = 5; //for multi list component
                int count = 0;

				String strCompItemKey = strConstructedCompId+nCompSrlNo+"L_";

				//append_score.append("");
                while(rs1.next())
                {
                    String list_item_id            =    rs1.getString("list_item_id") ==null?"":rs1.getString("list_item_id");
                    String list_item_text        =    replaceSpecialChars(checkForNull(rs1.getString("list_item_text")));
                    String default_yn            =    rs1.getString("default_yn")==null?"":rs1.getString("default_yn");
                    String ref_range_seq        =    rs1.getString("REF_RANGE_SEQ")==null?"":rs1.getString("REF_RANGE_SEQ");
                    String numeric_value        =    rs1.getString("NUMERIC_VALUE");

				     if(strCompType.equals("L"))
                    {
                        stringToReturn.append("<DATA VALUE=\"" + numeric_value + "\"  SCORE=\"" + numeric_value + "\" LIST_ITEM_ID='"+list_item_id.trim()+"'" +" COMPITEMKEY ='"+strCompItemKey+ref_range_seq +"'" +(default_yn.equals("Y")?" SELECTED='true' ":"") + " >"+list_item_text+"</DATA>");
						def_score =list_item_id+"~"+numeric_value;
						if(append_score.length()==0)
								append_score.append(def_score);
						else
							append_score.append("###"+def_score);
					}
                    else if(strCompType.equals("M"))
                    {
                        if(count != 0 && count%number_of_checkboxes_in_one_row == 0)
                            stringToReturn.append("</MULTI-LIST-ROW><MULTI-LIST-ROW>");
                        stringToReturn.append("<MULTI-LIST-DATA NAME=\"MULTI_LIST_DATA_" + list_item_id +"_"+ (strConstructedCompId+nCompSrlNo) + "\" VALUE='"+list_item_id+"' " +" COMPITEMKEY ='"+strCompItemKey+ref_range_seq +"'"  +(default_yn.equals("Y")?" SELECTED='true' ":"") + " REF_RANGE_SEQ = \"" + ref_range_seq + "\">"+list_item_text + "</MULTI-LIST-DATA>");
                        count++;
                    }
			  }
                if(strCompType.equals("M"))
                    stringToReturn.append("</MULTI-LIST-ROW>");
                rs1.close();
                pstmt1.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                
            }
            if(strCompType.equals("L")){
                stringToReturn.append(strFieldAssnCont+"<HIDDEN-FIELD NAME='"+(strConstructedCompId+nCompSrlNo)+"_desc'  VALUE=''></HIDDEN-FIELD><HIDDEN-FIELD NAME='"+(strConstructedCompId+nCompSrlNo)+"_code'  VALUE=''></HIDDEN-FIELD>");
				stringToReturn.append("<HIDDEN-FIELD NAME='"+(strConstructedCompId+nCompSrlNo)+"_score'  VALUE='"+append_score+"'></HIDDEN-FIELD></LIST-BOX>");
			}
            else if(strCompType.equals("M"))
            {
                stringToReturn.append("<TEXT NAME='MULTI_LIST_"+(strConstructedCompId+nCompSrlNo)+"_OTHERS' COMPID='"+strConstructedCompId+"' VALUE='' MISCDISP1= 'Others'  MISCDISP2 = 'Specify' ></TEXT>");
                stringToReturn.append("<HIDDEN-FIELD NAME='"+(strConstructedCompId+nCompSrlNo)+"_desc'  VALUE=''></HIDDEN-FIELD></MULTI-LIST>");
            }
        }
        //---------------------------
        //taking care of paragraph

        if(strCompType.equals("P"))
        {
            PreparedStatement pstmt2=null;
            ResultSet rs2    =null;
            StringBuffer paragraphXML=new StringBuffer();
            StringBuffer discr_msr_def1 = new StringBuffer();
            try
            {
                String queryParagraph=    " Select DISCR_MSR_DEF from AM_DISCR_COMP_DEFINITION where DISCR_MSR_ID= ?";
                pstmt2=    con.prepareStatement(queryParagraph);
                pstmt2.setString(1,strActualCompId);
                rs2    =    pstmt2.executeQuery();
                if(rs2.next())
                {
                    Clob clb = rs2.getClob(1);
                    if(clb!=null)
                    {

						//discr_msr_def1.append(java.net.URLDecoder.decode(clb.getSubString(1,(int)clb.length()),"UTF-8"));
						//discr_msr_def1.append(clb.getSubString(1,(int)clb.length()));
                        java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
                        String line = null;
                        while((line=r.readLine()) != null)
                        {


                         //   discr_msr_def1+=line+"\n";
                           discr_msr_def1.append((String)line);
							discr_msr_def1.append("\n");
                        }
                    }
                } 				
				 				
				eAM.DiscrMsrCompParagraphComponentBean beanObject = new eAM.DiscrMsrCompParagraphComponentBean();
				if(discr_msr_def1.length() > 0) { //IN043766 - START
					paragraphXML.append(beanObject.changeDefinitionToXML(con,discr_msr_def1.toString(),strConstructedCompId)); // comp_id strConstructedCompId
				} //END
				beanObject =null;

								 
                //updating the Name attribute of each component in paragraph by calling the bean

                ParagraphDomParser beanObj = new ParagraphDomParser();
                paragraphXML = beanObj.updateXMLParaCompNames(paragraphXML,nCompSrlNo,strConstructedCompId,paraNo);
             
                
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
			
			// for Paragrah, the compid attribute is not defined at AM_DISCR_MSR leve, hence at section level
			// the attribute is get included.
			
			if (paragraphXML.length() > 0 )
			{
				String strNewAtt1 = " COMPID=\""+strActualCompId +"\" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo +"\"";
				String strTemp1 = paragraphXML.toString();

				int nIndex1 = 0;
			
				nIndex1 = strTemp1.indexOf("><PRE>");

				if(nIndex1 != -1)
					paragraphXML.insert(nIndex1,strNewAtt1);

				stringToReturn.append(paragraphXML.toString());
			}
			
			// shaiju st
				
				
            
                eCA.HiddenComponentIDS paraNames = new eCA.HiddenComponentIDS();
                if(strParaNames.equals(""))
                    strParaNames = strParaNames + paraNames.getHiddenComponentIDS(paragraphXML.toString(),"PARAGRAPH","");
                else
                    strParaNames = strParaNames + "|" + paraNames.getHiddenComponentIDS(paragraphXML.toString(),"PARAGRAPH","");

                paraNames = null;
            
			 //shaiju en
			
			
            paragraphXML = null;
            paraNo++;
			
        }
        // adding a grid component to the section


        if(strCompType.equals("R") || strCompType.equals("X"))
        {
            PreparedStatement pstmt2=null;
            ResultSet rs2    =null;
            StringBuffer discr_msr_def2 = new StringBuffer();
            
			try
            {
                String queryGrid =    " Select DISCR_MSR_DEF COMP_XML_DEFINITION from AM_DISCR_COMP_DEFINITION where DISCR_MSR_ID= ?";
                pstmt2=    con.prepareStatement(queryGrid);
                pstmt2.setString(1,strActualCompId);
                rs2    =    pstmt2.executeQuery();
                if(rs2.next())
                {
                    Clob clb = rs2.getClob(1);
                    if(clb!=null)
                    {
                        java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
                        String line = null;
                        while((line=r.readLine()) != null)
                        {
                            discr_msr_def2.append(line);
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

		/*	if (gridXML.length() > 0)
			{
			
				String strNewAtt = " ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo +"\"";
				String strTemp = gridXML.toString();
				
				int nIndex = 0;
				
				if (strCompType.equals("R"))
					nIndex = strTemp.indexOf("><GRID-TH>");
				else if (strCompType.equals("X"))
					nIndex = strTemp.indexOf("><MATRIX-TH>");

				if(nIndex != -1)
					gridXML.insert(nIndex,strNewAtt);

				stringToReturn.append(gridXML.toString());
			} */
			
            if(strCompType.equals("R"))
            {
               
			    StringBuffer gridXML = new StringBuffer();
				eAM.DiscrMsrCompGridComponentBean beanObject = new eAM.DiscrMsrCompGridComponentBean();
				if(discr_msr_def2.length() > 0) { //IN043766 - START
				//IN064044 Starts
					//gridXML.append(beanObject.changeDefinitionToXML(con,discr_msr_def2.toString(),strConstructedCompId,grid_desc,locale)); // comp_id strConstructedCompId
					gridXML.append(beanObject.changeDefinitionToXML(con,discr_msr_def2.toString(),strConstructedCompId,strPromptMesg,locale)); // strPromptMesg IN064044
				//IN064044 ends
				} // END
				beanObject =null;
				
				if (gridXML.length() > 0)
				{
			
					String strNewAtt = " ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo +"\"";
					String strTemp = gridXML.toString();
					
					int nIndex = 0;
					
					//if (strCompType.equals("R"))
						nIndex = strTemp.indexOf("><GRID-TH>");
					//else if (strCompType.equals("X"))
						//nIndex = strTemp.indexOf("><MATRIX-TH>");

					if(nIndex != -1)
						gridXML.insert(nIndex,strNewAtt);

					stringToReturn.append(gridXML.toString());
				}
				
				eCA.HiddenComponentIDS gridCompIDS = new eCA.HiddenComponentIDS();

                if(strGridCompIds.equals(""))
                    strGridCompIds = strGridCompIds + gridCompIDS.getHiddenComponentIDS("<USER-TEMPLATE><ROW><COL>" + gridXML.toString() + "</COL></ROW></USER-TEMPLATE>","HIDDEN-FIELD","grid_component_ids_");
                else
                    strGridCompIds = strGridCompIds + "|" + gridCompIDS.getHiddenComponentIDS("<USER-TEMPLATE><ROW><COL>" + gridXML.toString() + "</COL></ROW></USER-TEMPLATE>","HIDDEN-FIELD","grid_component_ids_");

                if(strGridNames.equals(""))
						strGridNames = strGridNames + gridCompIDS.getHiddenComponentIDS("<USER-TEMPLATE><ROW><COL>" + gridXML.toString() + "</COL></ROW></USER-TEMPLATE>","GRID","");
				else
						strGridNames = strGridNames + "|" +gridCompIDS.getHiddenComponentIDS("<USER-TEMPLATE><ROW><COL>" + gridXML.toString() + "</COL></ROW></USER-TEMPLATE>","GRID","");

                gridCompIDS = null;
				gridXML = null;
            }
            else if(strCompType.equals("X"))
            {
               
				StringBuffer matrixXML = new StringBuffer();
				//here matrix

				eAM.DiscrMsrCompMatrixComponentBean beanObject = new eAM.DiscrMsrCompMatrixComponentBean();
				if(discr_msr_def2.length() > 0) { //IN043766 - START
				//IN064044 Changes Starts
					//matrixXML.append(beanObject.changeDefinitionToXML(con,discr_msr_def2.toString(),strConstructedCompId,grid_desc)); // comp_id strConstructedCompId
					matrixXML.append(beanObject.changeDefinitionToXML(con,discr_msr_def2.toString(),strConstructedCompId,strPromptMesg)); // strPromptMesg
				//IN064044 changes Ends
				}	
				//END	
				beanObject =null;
				
				if (matrixXML.length() > 0)
				{
				
					String strNewAtt = " ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo +"\"";
					String strTemp = matrixXML.toString();
					
					int nIndex = 0;
					
					//if (strCompType.equals("R"))
						//nIndex = strTemp.indexOf("><GRID-TH>");
					//else if (strCompType.equals("X"))
						nIndex = strTemp.indexOf("><MATRIX-TH>");

					if(nIndex != -1)
						matrixXML.insert(nIndex,strNewAtt);

					stringToReturn.append(matrixXML.toString());
				}
				
				
				eCA.HiddenComponentIDS matrixNames = new eCA.HiddenComponentIDS();
                if(strMatrixNames.equals(""))
                    strMatrixNames = strMatrixNames + matrixNames.getHiddenComponentIDS(matrixXML.toString(),"MATRIX","");
                else
                    strMatrixNames = strMatrixNames + "|" + matrixNames.getHiddenComponentIDS(matrixXML.toString(),"MATRIX","");

                matrixNames = null;
				matrixXML	= null;
            }
			

           // gridXML = null;
        }
			
        if(strCompType.equals("A"))
        {
            PreparedStatement pstmt2=null;
            ResultSet rs2    =null;            
            StringBuffer formulaXML=new StringBuffer("<FORMULA-COMP CLASS='LABEL' COLSPAN='"+(2*nColSpan-1)+"' NAME='"+(strConstructedCompId+nCompSrlNo)+"' COMPID='"+strConstructedCompId+"'  COMPTYPE='"+strCompType+"' VALUE = '' RESULTTYPE ='"+strFormulaResultType+"' UNIT =\""+(strFormulaResultType.equals("N")?(strFormulaResultUnit.equals("")?strCompUnit:strFormulaResultUnit):strCompUnit)+"\" PROMPT='"+strPromptMesg+"' " +" ANALYN =\""+strCompAnalysisRequired +"\" DISCRID=\""+strActualCompId+"\" SECSEQ=\""+nCompSrlNo +"\""); 
            String formulaDefinition="";
            try
            {
                String queryFormula=" select DEP_DEFINITION from ca_section_template where SEC_HDG_CODE=? and COMP_ID= ? and SRL_NO =? ";
                pstmt2=    con.prepareStatement(queryFormula);
                pstmt2.setString(1,section);
                pstmt2.setString(2,strActualCompId);
                pstmt2.setInt(3,nCompSrlNo);
                rs2    =    pstmt2.executeQuery();
				Clob formula_def_clob1 = null;
                if(rs2.next())
                {
						formula_def_clob1 = rs2.getClob(1);
						if(formula_def_clob1!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(formula_def_clob1.getCharacterStream());
							String line_r = "";
							while((line_r = r.readLine())!=null)
									strXMLDefinition.append(line_r);
						}		
						if(strXMLDefinition ==null)
								strXMLDefinition.append("");
						formulaDefinition = strXMLDefinition.toString();
                }

                if(rs2 !=null) rs2.close();
                if(pstmt2 !=null) pstmt2.close();

				formulaXML.append(" FORMULA-FUNC=" +  ((formulaDefinition!=null && !formulaDefinition.equals(""))?"'getFormulaResult"+strConstructedCompId+nCompSrlNo+"()' ":" '' " ) + " HINT_MESSAGE=\"" + strHintMesg + "\">");

                if( formulaDefinition!=null && !formulaDefinition.equals(""))
                {
                    FormulaComponentBean beanObj = new FormulaComponentBean();
					
                    if(!strFormulaResultType.equals("D") && !strFormulaIncDateYN.equals("Y"))
					{						
						formulaXML.append(beanObj.getJavaScriptForFormulaXML(formulaDefinition,strConstructedCompId,nCompSrlNo,nDecimalDigit));						
						strFormulaFuncsonBodyUnload = strFormulaFuncsonBodyUnload + "getFormulaResult"+strConstructedCompId+nCompSrlNo+"();";
						//IN061905, starts
						if(!strLinkEventsBodyOnLoad.contains("getFormulaResult"+strConstructedCompId+nCompSrlNo+"()"))
						{
							strLinkEventsBodyOnLoad = strLinkEventsBodyOnLoad + "getFormulaResult"+strConstructedCompId+nCompSrlNo+"();";//IN061905
						}
						//IN061905, ends
					}
					else
					{
						formulaXML.append(beanObj.getJavaScriptForDateFormula(formulaDefinition, strConstructedCompId, nCompSrlNo, strFormulaResultUnit, strFormulaResultType));

						//IN061905, starts
						if(!strFormulaFuncsonBodyUnload.contains("getFormulaResultLoadUnload"+strConstructedCompId+nCompSrlNo+"()"))
						{
							strFormulaFuncsonBodyUnload = strFormulaFuncsonBodyUnload + "getFormulaResultLoadUnload"+strConstructedCompId+nCompSrlNo+"();";//IN061905
						}
						if(!strLinkEventsBodyOnLoad.contains("getFormulaResultLoadUnload"+strConstructedCompId+nCompSrlNo+"()"))
						{
							strLinkEventsBodyOnLoad = strLinkEventsBodyOnLoad + "getFormulaResultLoadUnload" +strConstructedCompId+nCompSrlNo+"();";//IN061905					
						}
						//IN061905, ends
					}

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

        
		

        return stringToReturn.toString();
    }
    private String checkForNull(String inputString)
    {
        return (inputString==null)    ?    ""    :    inputString;
    }

/*
	public String getCalenderGif(String calGifYN, String valDateTime, String fldName)
    {
    	String retCalGif = "";
        if(calGifYN.equals("Y")){
            if(!valDateTime.equals("")){
                if(valDateTime.equals("DD")){
                    retCalGif = "<CALANDER  SRC=\"../../eCommon/images/CommonCalendar.gif\" NAME='"+fldName+"' ONCLICK=\"return templateCalendarValidate(this.value,'N');\" CALENDER_NAME=\"calender_for_" + fldName + "\" ></CALANDER>";
                }else if(valDateTime.equals("DT")){
                    retCalGif = "<CALANDER SRC=\"../../eCommon/images/CommonCalendar.gif\"  NAME='"+fldName+"' ONCLICK=\"return templateCalendarValidate(this.value,'Y');\" CALENDER_NAME=\"calender_for_" + fldName + "\" ></CALANDER>";
                }
            }
        }
        return retCalGif;
    }
*/
    private static String replaceSpecialChars(String strInputIn)
    {
		if (strInputIn.indexOf("&") != -1) strInputIn = strInputIn.replaceAll("&","&amp;");
		if (strInputIn.indexOf("<") != -1) strInputIn = strInputIn.replaceAll("<","&lt;");
		if (strInputIn.indexOf(">") != -1) strInputIn = strInputIn.replaceAll(">","&gt;");	

        return strInputIn;
    }
	//IN061905, starts
	private void loadCompDepDetails(Connection con, String section)
	{
		String l_load_dep_dtl_qry = "";
		String l_dep_def = "";
		String l_dependencies[] = {};
		String l_comp = "";
		String l_parent_ref = "";
		String l_child_ref = "";
		String l_clob_line = "";

		StringBuilder l_formula_xml = new StringBuilder();

		ArrayList l_comp_dep = new ArrayList();
		ArrayList l_comp_dep_temp = new ArrayList();
		ArrayList l_comps = null;
		List <Element> l_comps_list	=	null;
		Set l_unique_comp_dtls = null;
		
		SAXReader l_sax_reader = new SAXReader();	
		Document l_xml_document = null;
		Attribute l_name_attribute = null;
		
		Clob l_formula_def_clob = null;
		
		BufferedReader l_formula_comp_reader = null;
		BufferedReader	l_depend_comp_reader =	 null;	

		PreparedStatement l_load_dep_dtl_pstmt = null;
		ResultSet l_load_dep_dtl_rs = null;
	
		try
        {
            l_load_dep_dtl_qry = "SELECT DEP_DEFINITION,'C_'||COMP_ID||SRL_NO COMP_ID FROM CA_SECTION_TEMPLATE WHERE SEC_HDG_CODE=?";
            l_load_dep_dtl_pstmt = con.prepareStatement(l_load_dep_dtl_qry,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            l_load_dep_dtl_pstmt.setString(1, section);
            l_load_dep_dtl_rs = l_load_dep_dtl_pstmt.executeQuery();			

			while(l_load_dep_dtl_rs.next())
			{				
				l_formula_def_clob = l_load_dep_dtl_rs.getClob(1);

				l_formula_xml=new StringBuilder();

				if(l_formula_def_clob!=null)
				{
					l_formula_comp_reader = new BufferedReader(l_formula_def_clob.getCharacterStream());
					l_clob_line = "";

					while((l_clob_line = l_formula_comp_reader.readLine())!=null)
						l_formula_xml.append(l_clob_line);
				}
				
				if(l_formula_xml ==null)
					l_formula_xml.append("");

				l_dep_def = l_formula_xml.toString();
								
				if(!"".equals(l_dep_def))
				{
					if(l_dep_def.contains("$$$") && l_dep_def.contains("###"))
					{
						l_dependencies = l_dep_def.split("~");
						
						for(String l_dep:l_dependencies)
						{
							if(l_dep.startsWith("$$$"))
							{
								l_comp = l_dep.substring(l_dep.lastIndexOf("$")+1,l_dep.indexOf("#")).replace("!","");

								if(!dep_comp_dtls.containsKey("C_"+l_comp))
								{
									l_comp_dep = new ArrayList();
									l_comp_dep.add(l_load_dep_dtl_rs.getString("COMP_ID"));
									dep_comp_dtls.put("C_"+l_comp,l_comp_dep);									
								}
								else
								{
									l_comp_dep = dep_comp_dtls.get("C_"+l_comp);									
									l_comp_dep.add(l_load_dep_dtl_rs.getString("COMP_ID"));
									dep_comp_dtls.put("C_"+l_comp,l_comp_dep);									
								}
							}
						}
					}
				}
			}

			l_load_dep_dtl_rs.first();

			while(l_load_dep_dtl_rs.next())
			{		
				l_formula_def_clob = l_load_dep_dtl_rs.getClob(1);

				l_formula_xml=new StringBuilder();

				if(l_formula_def_clob!=null)
				{
					l_formula_comp_reader = new BufferedReader(l_formula_def_clob.getCharacterStream());
					l_clob_line = "";

					while((l_clob_line = l_formula_comp_reader.readLine())!=null)
						l_formula_xml.append(l_clob_line);
				}
				
				if(l_formula_xml ==null)
					l_formula_xml.append("");

				l_dep_def = l_formula_xml.toString();
								
				if(!"".equals(l_dep_def))
				{
					if(l_dep_def.contains("<POST-ITEM-ACTIONS"))
					{
						l_depend_comp_reader =	 new BufferedReader(new StringReader(l_dep_def));					
						l_xml_document = l_sax_reader.read(l_depend_comp_reader);
						l_comps_list = l_xml_document.selectNodes("//COMPONENT");
						
						for (Element element : l_comps_list)
						{
							l_name_attribute= element.attribute("NAME");
							
							if(dep_comp_dtls.containsKey(l_name_attribute.getValue()))
							{
								l_comp_dep_temp = dep_comp_dtls.get(l_name_attribute.getValue());							

								if(dep_comp_dtls.containsKey(l_load_dep_dtl_rs.getString("COMP_ID")))
								{
									l_comp_dep = dep_comp_dtls.get(l_load_dep_dtl_rs.getString("COMP_ID"));
									l_comp_dep.addAll(l_comp_dep_temp);
									l_unique_comp_dtls = new HashSet(); 
									l_unique_comp_dtls.addAll(l_comp_dep); 
									l_comp_dep.clear(); 
									l_comp_dep.addAll(l_unique_comp_dtls);
									dep_comp_dtls.put(l_load_dep_dtl_rs.getString("COMP_ID"),l_comp_dep);
								}
								else
								{
									dep_comp_dtls.put(l_load_dep_dtl_rs.getString("COMP_ID"),l_comp_dep_temp);
								}
							}
						}
					}
				}
			}

			if(l_load_dep_dtl_rs!=null)
				l_load_dep_dtl_rs.close();

			if(l_load_dep_dtl_pstmt!=null)
				l_load_dep_dtl_pstmt.close();

			if(l_formula_comp_reader!=null)
				l_formula_comp_reader.close();

			if(l_depend_comp_reader!=null)
				l_depend_comp_reader.close();

			l_load_dep_dtl_qry = "SELECT 'C_'||PARENT_COMP_REF PARENT_COMP_REF, 'C_'||CHILD_COMP_REF CHILD_COMP_REF FROM CA_COMPONENT_DEPENDENCY_DTL WHERE SEC_HDG_CODE = ? ORDER BY PARENT_COMP_REF";
            l_load_dep_dtl_pstmt = con.prepareStatement(l_load_dep_dtl_qry);
            l_load_dep_dtl_pstmt.setString(1, section);
            l_load_dep_dtl_rs = l_load_dep_dtl_pstmt.executeQuery();			

			while(l_load_dep_dtl_rs.next())
			{				
				l_parent_ref = l_load_dep_dtl_rs.getString("PARENT_COMP_REF");
				l_child_ref = l_load_dep_dtl_rs.getString("CHILD_COMP_REF");
				l_comp_dep_temp = new ArrayList();
				
				if(dep_comp_dtls.containsKey(l_child_ref))
				{
					l_comp_dep_temp = dep_comp_dtls.get(l_child_ref);
				}
				
				l_comps = new ArrayList();

				if(dep_comp_dtls.containsKey(l_parent_ref))
				{
					l_comps = dep_comp_dtls.get(l_parent_ref);

					if(l_comps!=null)
					{
						l_comps.addAll(l_comp_dep_temp);
						l_unique_comp_dtls = new HashSet(); 
						l_unique_comp_dtls.addAll(l_comps); 
						l_comps.clear(); 
						l_comps.addAll(l_unique_comp_dtls);
						dep_comp_dtls.put(l_parent_ref,l_comps);
					}
				}				
			}

			if(l_load_dep_dtl_rs!=null)
				l_load_dep_dtl_rs.close();

			if(l_load_dep_dtl_pstmt!=null)
				l_load_dep_dtl_pstmt.close();

			if(l_formula_comp_reader!=null)
				l_formula_comp_reader.close();

			if(l_depend_comp_reader!=null)
				l_depend_comp_reader.close();			
        }
        catch(Exception e)
        {
			e.printStackTrace();
        }
		finally
		{
			try
			{
				if(l_load_dep_dtl_rs!=null)
					l_load_dep_dtl_rs.close();

				if(l_load_dep_dtl_pstmt!=null)
					l_load_dep_dtl_pstmt.close();

				if(l_formula_comp_reader!=null)
					l_formula_comp_reader.close();

				if(l_depend_comp_reader!=null)
					l_depend_comp_reader.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
	}
	//IN061905, ends
}
