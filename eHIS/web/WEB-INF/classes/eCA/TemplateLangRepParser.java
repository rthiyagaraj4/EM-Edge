/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
05/10/2012	IN035406.1		 Dinesh T	 Thai Date conversion issue in the Record Clinical Notes function 
02/09/2013  IN037405		 Chowminya G  Section template display wrong component description  in some case
31/10/2013	IN000000		 Chowminya	  Formula component doesnt have prompt_id condition added to handle the same		 	
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------		
16/06/2017	IN064044		Raja S			16/06/2017		Ramesh G			ML-MMOH-SCF-0711[Doesnt work for other lang]			 	
3/03/2022 Common-ICN-0092   Pranay                                               connection closing statement
----------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class TemplateLangRepParser 
{
	private Connection cnParser = null;	
	private StringBuffer sbLangReplXML;

	private String m_strSecHdgCode	=	"";
	private String m_strLangId		=	"";
	private String m_strsex		=	"";
	private String m_strdob		=	"";
	private String range_paser_yn		=	"N";

	public Document m_XMLDocument = null;
	
	public TemplateLangRepParser(Connection cnIn,HashMap<String,String> paramMap,StringBuffer strXMLContentIn)
	{
		cnParser 		= cnIn;
		sbLangReplXML 	= new StringBuffer();

		m_strSecHdgCode = paramMap.get("CURR_SEC_HDG_CODE")==null?"":paramMap.get("CURR_SEC_HDG_CODE");
		m_strLangId = paramMap.get("LOCALE")==null?"en":paramMap.get("LOCALE");
		m_strsex = paramMap.get("SEX")==null?"":paramMap.get("SEX");
		m_strdob = paramMap.get("DOB")==null?"":paramMap.get("DOB");
		range_paser_yn = paramMap.get("RANGE_PASER_YN")==null?"N":paramMap.get("RANGE_PASER_YN");
				
		try
		{
			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(strXMLContentIn.toString()));
			this.m_XMLDocument = reader.read(br);
		}
		catch (Exception eConv)
		{
			eConv.printStackTrace();
		}
	}

	public StringBuffer getLangReplacedXML()
	{
		String 	strCompId	=	"",			strPromptMesg		=	"";
		String	strHintMesg	=	"",			strTitleMesg		=	"";
		String	strCompType	=	"",			strCompTitle		=	"";
		String  strTitleId	=	"",			strListPresent		=	"";
		String	strGetLangDataQuery		=	"";
		String	strSrl_No	=	"";
		String	strCompName	=	"";
		String	strPromptId	=	"";//IN037405

		String DISCR_MSR_ID		=""; 
		String NUM_REF_LOW		=""; 
		String NUM_REF_HIGH		=""; 
		String NUM_CRIT_LOW		=""; 
		String NUM_CRIT_HIGH	=""; 
		String COMP_TYPE	=""; 

		boolean bLangReplRetn			=	false;
		boolean bNoData					=	true;
		
		sbLangReplXML.delete(0,sbLangReplXML.length());
		
		PreparedStatement pstmt = null;
		ResultSet rsLang		= null;
		try
		{
			bLangReplRetn = setLangIdinTemplate();

			if(bLangReplRetn)
			{
				// Only for Components other than Titles
				//strGetLangDataQuery = "SELECT a.COMP_ID,nvl(E.RESULT_TYPE,case when instr(a.COMP_ID,'TIME')>0 then 'E' when instr(a.COMP_ID,'DATE')>0 then 'E' when instr(a.COMP_ID,'DT')>0 then 'E'  else 'H' end ) RESULT_TYPE,A.ITEM_TYPE,a.SRL_NO, CASE WHEN A.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(A.PROMPT_ID,?,'1') ELSE AM_GET_DESC.AM_DISCR_MSR(a.comp_id,?,'2')  END  PROMPT_MESG,CASE WHEN A.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(A.HINT_ID,?,'1') ELSE ' ' END HINT_MESG,LIST_PRESENTATION   FROM CA_SECTION_TEMPLATE A,AM_DISCR_MSR E  WHERE A.SEC_HDG_CODE = ? AND DISCR_MSR_ID(+) = A.COMP_ID AND A.ITEM_TYPE NOT IN('T','R','X','A','P')  ORDER BY ROW_POS_NO,COLUMN_POS_NO";//IN037405 
				strGetLangDataQuery = "SELECT a.COMP_ID,nvl(E.RESULT_TYPE,case when instr(a.COMP_ID,'TIME')>0 then 'E' when instr(a.COMP_ID,'DATE')>0 then 'E' when instr(a.COMP_ID,'DT')>0 then 'E'  else 'H' end ) RESULT_TYPE,A.ITEM_TYPE,a.SRL_NO, CASE WHEN A.PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(A.PROMPT_ID,?,'1') ELSE AM_GET_DESC.AM_DISCR_MSR(a.comp_id,?,'2')  END  PROMPT_MESG,CASE WHEN A.HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(A.HINT_ID,?,'1') ELSE ' ' END HINT_MESG,LIST_PRESENTATION, A.PROMPT_ID   FROM CA_SECTION_TEMPLATE A,AM_DISCR_MSR E  WHERE A.SEC_HDG_CODE = ? AND DISCR_MSR_ID(+) = A.COMP_ID AND A.ITEM_TYPE NOT IN('T','R','X','A','P')  ORDER BY ROW_POS_NO,COLUMN_POS_NO";//IN037405 included PROMPT_ID
				
				pstmt = cnParser.prepareStatement(strGetLangDataQuery);

				pstmt.setString(1,m_strLangId);
				pstmt.setString(2,m_strLangId);
				pstmt.setString(3,m_strLangId);
				pstmt.setString(4,m_strSecHdgCode);
			
				rsLang = pstmt.executeQuery();
				
				while (rsLang.next())
				{
					strCompId 		= rsLang.getString("COMP_ID");
					strPromptMesg	= rsLang.getString("PROMPT_MESG")== null?"":rsLang.getString("PROMPT_MESG");
					strHintMesg		= rsLang.getString("HINT_MESG")==null?"":rsLang.getString("HINT_MESG");
					strCompType		= rsLang.getString("RESULT_TYPE")==null?"":rsLang.getString("RESULT_TYPE");
					strCompTitle	= rsLang.getString("ITEM_TYPE")==null?"":rsLang.getString("ITEM_TYPE");
					strSrl_No		= rsLang.getString("SRL_NO");
					strListPresent	= rsLang.getString("LIST_PRESENTATION");
					strPromptId		= rsLang.getString("PROMPT_ID")==null?"":rsLang.getString("PROMPT_ID"); //IN037405

					strCompName =strCompTitle+"_"+strCompId+strSrl_No;
					if(strCompType.equals("L") && strListPresent.equals("M") )
						strCompType = "M";
										
					if (!strCompType.equals("G") && !strCompType.equals("R") && !strCompType.equals("X") && !strCompType.equals("P")) 
						bLangReplRetn = replaceLangValuesForComps(strCompId,strPromptMesg,strHintMesg,strCompType,strCompName,strPromptId);
						//IN037405 included PROMPT_ID in replaceLangValuesForComps
		
					if(!bLangReplRetn)
						break;
				}

				if(rsLang != null) rsLang.close();
				if(pstmt  != null) pstmt.close();
			}

			// Only For Titles 
			if(bLangReplRetn)
			{
				strGetLangDataQuery = "SELECT a.TITLE_ID, CASE WHEN A.TITLE_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(A.TITLE_ID,?,'1') ELSE ' ' END  TITLE_MESG FROM CA_SECTION_TEMPLATE A WHERE A.SEC_HDG_CODE = ?  AND A.ITEM_TYPE = 'T' ORDER BY ROW_POS_NO,COLUMN_POS_NO";
				
				pstmt = cnParser.prepareStatement(strGetLangDataQuery);

				pstmt.setString(1,m_strLangId);
				pstmt.setString(2,m_strSecHdgCode);
			
				rsLang = pstmt.executeQuery();
				
				while (rsLang.next())
				{
					strTitleId		= rsLang.getString("TITLE_ID")==null?"":rsLang.getString("TITLE_ID");
					strTitleMesg	= rsLang.getString("TITLE_MESG")==null?"":rsLang.getString("TITLE_MESG");

					bLangReplRetn = replaceLangValuesForTitles(strTitleId,strTitleMesg);
		
					if(!bLangReplRetn)
						break;
				}

				if(rsLang != null) rsLang.close();
				if(pstmt  != null) pstmt.close();
			}
			
			// for Grid Component Headers
			if(bLangReplRetn)
				bLangReplRetn = replaceLangValuesForGridHeaders();

			// for Matrix Component Headers
			if(bLangReplRetn)
				bLangReplRetn = replaceLangValuesForMatrixHeaders();

			if (range_paser_yn.equals("Y"))
			{
				String range_query = "SELECT A.DISCR_MSR_ID DISCR_MSR_ID,COMP_TYPE,to_char(NUM_REF_LOW) NUM_REF_LOW ,to_char(NUM_REF_HIGH) NUM_REF_HIGH,to_char(NUM_CRIT_LOW) NUM_CRIT_LOW,to_char(NUM_CRIT_HIGH) NUM_CRIT_HIGH FROM AM_DISCR_MSR_REF_RNG_NUM A, CA_SECTION_DISCR_MSR_VW B   WHERE B.SEC_HDG_CODE = ? AND COMP_TYPE IN  ('I','N','A') AND   B.COMP_ID  =  A.DISCR_MSR_ID AND PATIENT_SEX IN (?,'A') AND (trunc(SYSDATE) - to_Date(?,'DD/MM/YYYY')) BETWEEN START_AGE_DAYS AND END_AGE_DAYS "  ;
				pstmt =	cnParser.prepareStatement(range_query);
				pstmt.setString(1,m_strSecHdgCode);
				pstmt.setString(2,m_strsex);
				pstmt.setString(3,m_strdob);
				rsLang = pstmt.executeQuery();

				while(rsLang.next())
				{		
					bNoData = false;
					DISCR_MSR_ID	= rsLang.getString("DISCR_MSR_ID")==null?"":rsLang.getString("DISCR_MSR_ID");
					COMP_TYPE	= rsLang.getString("COMP_TYPE")==null?"":rsLang.getString("COMP_TYPE");
					NUM_REF_LOW		= rsLang.getString("NUM_REF_LOW")==null?"":rsLang.getString("NUM_REF_LOW");
					NUM_REF_HIGH	= rsLang.getString("NUM_REF_HIGH")==null?"":rsLang.getString("NUM_REF_HIGH");
					NUM_CRIT_LOW	= rsLang.getString("NUM_CRIT_LOW")==null?"":rsLang.getString("NUM_CRIT_LOW");
					NUM_CRIT_HIGH	= rsLang.getString("NUM_CRIT_HIGH")==null?"":rsLang.getString("NUM_CRIT_HIGH");
				
					bLangReplRetn = addRangeValuesForComps(DISCR_MSR_ID,NUM_REF_LOW,NUM_REF_HIGH,NUM_CRIT_LOW,NUM_CRIT_HIGH,COMP_TYPE);
				}
				if (rsLang !=null)rsLang.close();
				if (pstmt !=null)pstmt.close();
				
			}			

			if(bLangReplRetn)
				convertString(this.m_XMLDocument);
			else
				this.sbLangReplXML.append("Error For The Section : " + this.m_strSecHdgCode + " @ Component : " + strCompId + "  For The Type " + strCompTitle);
		}
		catch (Exception eGetLang)
		{
			eGetLang.printStackTrace();
		}
		
		return this.sbLangReplXML;
	}
	
	private boolean replaceLangValuesForTitles(String strTitleIdIn, String strTitleMesgIn)
	{
		boolean bRetValue = true;

		StringBuffer sbXPathDefn =  new StringBuffer();
		
		try
		{			
			sbXPathDefn.delete(0,sbXPathDefn.length());
			sbXPathDefn.append("/USER-TEMPLATE/ROW/COL/TITLE-TEXT[@TITLE_ID='"+strTitleIdIn+"']");
		
			List<Element> elementList = this.m_XMLDocument.selectNodes(sbXPathDefn.toString());
				
			if(elementList != null && elementList.size()>0)
			{
				//int nTitleNodeLen = elementList.size();  //Common-ICN-0092  
				//int nCurNodeIdx = 0;					   //Common-ICN-0092  

				for (Element element1 : elementList)
				{					
					element1.setText(strTitleMesgIn);								
				}					
			}			
		}
		catch (Exception eTitle)
		{
			eTitle.printStackTrace();
			bRetValue = false;
			
		}

		return bRetValue;	
	}
	//IN037405 included strPromptId
	private boolean replaceLangValuesForComps(String strCompIdIn,String strPromptMesgIn,String strHintMesgIn,String strCompTypeIn,String strCompNameIn,String strPromptId)
	{
		boolean bRetValue = true;

		StringBuffer sbXPathDefn =  new StringBuffer();

		String strDateInOthLang		=	"",							strResultType	=	"";

		java.util.Locale loc = new java.util.Locale(this.m_strLangId);

		java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		
		try
		{
			sbXPathDefn.delete(0,sbXPathDefn.length());
			sbXPathDefn.append("/USER-TEMPLATE/ROW/COL");
		
			if(strCompTypeIn.equals("C"))
				sbXPathDefn.append("/CHECK-BOX");
			else if(strCompTypeIn.equals("L"))
				sbXPathDefn.append("/LIST-BOX");
			else if(strCompTypeIn.equals("D") || strCompTypeIn.equals("T")|| strCompTypeIn.equals("E") || strCompTypeIn.equals("I") || strCompTypeIn.equals("N"))
				sbXPathDefn.append("/DATE-TIME-NUMERIC");
			else if(strCompTypeIn.equals("H"))
				sbXPathDefn.append("/SHORT-TEXT");
			else if(strCompTypeIn.equals("F"))
				sbXPathDefn.append("/LONG-TEXT");
			else if(strCompTypeIn.equals("M"))
				sbXPathDefn.append("/MULTI-LIST");
			else if(strCompTypeIn.equals("A"))
				sbXPathDefn.append("/FORMULA-COMP");
			
			sbXPathDefn.append("[@DISCRID='" + strCompIdIn+"']");
			
			Element element		=	(Element)this.m_XMLDocument.selectSingleNode(sbXPathDefn.toString());
			
			if(element != null)
			{
				Attribute prompt_attr= element.attribute("PROMPT");	
				Attribute hint_message_attr= element.attribute("HINT_MESSAGE");	
				Attribute prompt_id= element.attribute("PROMPT_ID"); //IN037405	
				
				if(prompt_attr != null  && !"A".equals(strCompTypeIn))//Formula component doesnt have prompt_id condition added to handle the same
				{
					//IN037405 to avoid overriding the prompt value for same component ids
					if(prompt_id.getValue().equals(strPromptId))
						prompt_attr.setValue(strPromptMesgIn);					
				}
				
							
				if(hint_message_attr != null)
				{
					hint_message_attr.setValue(strHintMesgIn);					
				}

				// For Date Conversion in Thai
				
				if(strCompTypeIn.equals("D") || strCompTypeIn.equals("E") || strCompTypeIn.equals("A"))
				{
					Attribute resulttype_attr	=   null;
					
					Attribute value_attr= element.attribute("VALUE");	
					Attribute othlangval_attr= element.attribute("OTHLANGVAL");	

					if(othlangval_attr == null)
					{
						element.addAttribute("OTHLANGVAL", "") ;						
					}
					else
						othlangval_attr.setValue("");

					strDateInOthLang	=	value_attr.getValue();					

					if(strCompTypeIn.equals("A") )
					{
						resulttype_attr= element.attribute("RESULTTYPE");							
						strResultType	= resulttype_attr.getValue();	
					}

					if(strDateInOthLang == null || strDateInOthLang.equals("") )
							strDateInOthLang = "";
					
					if(!strDateInOthLang.equals("") )
					{
						if(strCompTypeIn.equals("D") )
							strDateInOthLang	=	com.ehis.util.DateUtils.convertDate(strDateInOthLang,"DMY","en",this.m_strLangId);
						else if(strCompTypeIn.equals("E") )
							strDateInOthLang	=	com.ehis.util.DateUtils.convertDate(strDateInOthLang,"DMYHM","en",this.m_strLangId);
						else if(strCompTypeIn.equals("A") )
						{	
							if(strResultType.equals("D") )
								strDateInOthLang	=	com.ehis.util.DateUtils.convertDate(strDateInOthLang,"DMY","en",this.m_strLangId);
							else
								strDateInOthLang	=	com.ehis.util.DateUtils.convertDate(strDateInOthLang,"DMYHM","en",this.m_strLangId);
						}						
						
						othlangval_attr.setValue(strDateInOthLang);
					}
				}

				// for List Box and Multi List Items
				if(strCompTypeIn.equals("L") || strCompTypeIn.equals("M") )
				{
					Attribute dfltsel_attr = null;
					String strTempSel = "";

					if(strCompTypeIn.equals("L") )
					{
						dfltsel_attr = element.attribute("DFLTSEL");
						strTempSel = common_labels.getString("Common.defaultSelect.label");
						dfltsel_attr.setValue(strTempSel);
					}
					//Get the  name attribute of this node
					Attribute name_attr = element.attribute("NAME");					
					String strBuiltCompId = name_attr.getValue();

					strBuiltCompId += "L_";
					bRetValue = replaceLangValuesForListItems(element,strBuiltCompId,strCompIdIn,strCompTypeIn);
				}
			}
		}
		catch (Exception eReplace)
		{
			eReplace.printStackTrace();
			bRetValue = false;
			
		}
		
		common_labels = null;
		return bRetValue;
	}


	private boolean replaceLangValuesForListItems(Element element, String strCompBuiltIdIn, String strCompIdIn,String strCompTypeIn)
	{		
		boolean bRetValue			= true;
		PreparedStatement pstData	= null;
		ResultSet rsData			= null;

		String strDataQry			=		""				, strRefRange			=	"";
		String strDesn				=		""				, strMisDisp1			=	"";
		String strMisDisp2			=		"";

		StringBuffer strDataXPathDefn  = new StringBuffer();
		
		java.util.Locale loc = new java.util.Locale(this.m_strLangId);

		java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		java.util.ResourceBundle ca_labels		= java.util.ResourceBundle.getBundle( "eCA.resources.Labels",loc);
		
		strDataQry = "SELECT REF_RNG_DESC,REF_RANGE_SEQ FROM AM_DISCR_MSR_RF_RNG_LS_LANG_VW WHERE DISCR_MSR_ID = ? AND LANGUAGE_ID = ? ORDER BY REF_RANGE_SEQ";
		
		try
		{
			
			pstData = cnParser.prepareStatement(strDataQry);

			pstData.setString(1,strCompIdIn);
			pstData.setString(2,m_strLangId);

			rsData = pstData.executeQuery();
			Element data_element = null;			
			StringBuffer strKey				= new StringBuffer();

			
			while (rsData.next())
			{
				strKey.delete(0,strKey.length());
				strDataXPathDefn.delete(0,strDataXPathDefn.length());
				strDesn			= rsData.getString("REF_RNG_DESC");
				strRefRange		= rsData.getString("REF_RANGE_SEQ");
				
				strKey.append(strCompBuiltIdIn);
				strKey.append(strRefRange);

				if(strCompTypeIn.equals("L") )
					strDataXPathDefn.append("//DATA[@COMPITEMKEY='"+strKey.toString().trim()+"']");
				else
					strDataXPathDefn.append("//MULTI-LIST-DATA[@COMPITEMKEY='"+strKey.toString().trim()+"']");
			
				data_element =  (Element)element.selectSingleNode(strDataXPathDefn.toString());
						
				if(data_element != null)
				{			
					data_element.setText(strDesn);								
				}
			}

			if(rsData != null) rsData.close();
			if(pstData != null) pstData.close();

			// For Others Text Box

			strDataXPathDefn.delete(0,strDataXPathDefn.length());
			strDataXPathDefn.append("//TEXT");

			strMisDisp1 = common_labels.getString("Common.others.label");			
			strMisDisp2 = common_labels.getString("Common.Specify.label");

			data_element = (Element)element.selectSingleNode(strDataXPathDefn.toString());

			if(data_element != null)
			{
				Attribute miscdisp1_attr = data_element.attribute("MISCDISP1");
				Attribute miscdisp2_attr = data_element.attribute("MISCDISP2");				

				if(miscdisp1_attr != null )				
					miscdisp1_attr.setValue(strMisDisp1);					
				
				if(miscdisp2_attr != null)				
					miscdisp2_attr.setValue(strMisDisp2 );									
				
			}
		}
		catch (Exception eData)
		{
			bRetValue = false;
			eData.printStackTrace();
			
		}

		common_labels	= null;
		ca_labels		= null;

		return bRetValue;
	}

	private boolean replaceLangValuesForGridHeaders()
	{
		boolean bRetValue			= true;
		
		String strQuery				=	"",	strQuery1="",				strPromptId		=	"";
		String strPromptVal			=	"",					strDefinition	=	"";
		String strTemp				=	"",					strDiscrId		=	"";
		String strDiscrDn			=	"",					strBuiltCompId	=	"";
		String strDTResultType		=	"",					strDTValue		=	"";

		PreparedStatement	pstData		= null;
		PreparedStatement	pstData1		= null;
		ResultSet			rsData		= null;

		HashMap  hmLangValues		= new HashMap();
		StringTokenizer stComps		= null;
		StringTokenizer stCompIds	= null;

		StringBuffer sbXPathDefn  = new StringBuffer();
		StringBuffer sbCompIds	  = new StringBuffer();

		java.util.Locale loc = new java.util.Locale(this.m_strLangId);

		java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		try
		{
			sbXPathDefn.delete(0,sbXPathDefn.length());
			sbXPathDefn.append("/USER-TEMPLATE/ROW/COL/GRID");
			
//			int nGridTHNdLen			=	0,				nCurIdx					=	0;   //Common-ICN-0092  
//			int nGridNdLen				=	0,				nCurGridNd				=	0;   //Common-ICN-0092
	
			List<Element> grid_elements	=	this.m_XMLDocument.selectNodes(sbXPathDefn.toString());
			
			if (grid_elements != null && grid_elements.size()>0)
			{
				strQuery	= "SELECT DISCR_MSR_DEF FROM AM_DISCR_COMP_DEFINITION WHERE DISCR_MSR_ID = ?";
				pstData		= cnParser.prepareStatement(strQuery);

				//strQuery1 = "SELECT DISCR_MSR_ID, SHORT_DESC FROM AM_DISCR_MSR_LANG_VW WHERE DISCR_MSR_ID IN (?) AND LANGUAGE_ID = ?";//Commented for IN064044
				//pstData1		= cnParser.prepareStatement(strQuery1); //Commented for IN064044

				for (Element grid_element : grid_elements)
				{					
					strPromptId		= grid_element.attribute("DISCRID").getValue();
					pstData.setString(1,strPromptId);
					rsData = pstData.executeQuery();
					if(rsData.next())
					strDefinition = rsData.getString("DISCR_MSR_DEF")==null?"":rsData.getString("DISCR_MSR_DEF");
					if(rsData != null) rsData.close();

					if ((strDefinition != null) && (!strDefinition.trim().equals("")))
					{				
						stComps	= new StringTokenizer(strDefinition,"|");

						sbCompIds.delete(0,sbCompIds.length());

						sbCompIds.append("'"+strPromptId+"',");

						if ((stComps != null) && (!stComps.equals("")))
						{
							while (stComps.hasMoreTokens())
							{						
								stCompIds	= new StringTokenizer(stComps.nextToken(),"~");
								strTemp		= stCompIds.nextToken();
								sbCompIds.append("'"+stCompIds.nextToken()+"',");
							}						
						}				
				
						sbCompIds.append("'$$$$'");
					}
					//IN064044 Changes starts
					strQuery1 = "SELECT DISCR_MSR_ID, SHORT_DESC FROM AM_DISCR_MSR_LANG_VW WHERE DISCR_MSR_ID IN ("+sbCompIds.toString()+") AND LANGUAGE_ID = ?";
					pstData1		= cnParser.prepareStatement(strQuery1);
					//pstData1.setString(1,sbCompIds.toString());
					//pstData1.setString(2,this.m_strLangId);
					pstData1.setString(1,this.m_strLangId);
					//IN064044 Changes Ends
					rsData = pstData1.executeQuery();
					while (rsData.next())
					{
						strDiscrId = rsData.getString("DISCR_MSR_ID");
						strDiscrDn = rsData.getString("SHORT_DESC");
						hmLangValues.put(strDiscrId,strDiscrDn);
					}
					if(rsData != null) rsData.close();

					//strPromptVal		= (String) hmLangValues.get(strPromptId); //Commented for IN064044
					strPromptVal		= (String) hmLangValues.get(strPromptId)==null?"":(String)hmLangValues.get(strPromptId); //Added for IN064044
					Attribute 	description_attr	= grid_element.attribute("DESCRIPTION");
					//IN064044 changes starts
					//description_attr.setValue(strPromptVal);
					if (strPromptVal != null && !strPromptVal.equals(""))
					{
						description_attr.setValue(strPromptVal);
					}
					//IN064044 changes ends
					// Completion of Thai repl for Grid Name
					sbXPathDefn.delete(0,sbXPathDefn.length());
					sbXPathDefn.append("//GRID-TH/TH");
				
					List<Element> grid_child_elements	=	grid_element.selectNodes(sbXPathDefn.toString());
					if (grid_child_elements != null && grid_child_elements.size()>0)
					{
						for (Element grid_child_element  : grid_child_elements )
						{							
							Attribute prompt_id_attr = grid_child_element.attribute("PROMPT_ID");							
							if(prompt_id_attr != null)
							{								
								strPromptId		= prompt_id_attr.getValue();								
								strPromptVal	= hmLangValues.get(strPromptId)==null?"":(String)hmLangValues.get(strPromptId);			
								if (strPromptVal != null && !strPromptVal.equals(""))
								{									
									grid_child_element.setText(strPromptVal);		
								}								
							}
						}
					}
					
					// For Date Conversion to Thai
					//IN035406.1, starts
					/*sbXPathDefn.delete(0,sbXPathDefn.length());
					sbXPathDefn.append("//GRID-ROW/GRID-COL/DATE-TIME-NUMERIC[@COMPTYPE='D' or @COMPTYPE='E']");

					grid_child_elements 	=  grid_element.selectNodes(sbXPathDefn.toString());
					if (grid_child_elements != null && grid_child_elements.size()>0)
					{
						for (Element grid_child_element  : grid_child_elements )
						{							
							//Attribute comptype_attr = grid_child_element.attribute("COMPTYPE");
							strDTResultType = grid_child_element.attribute("COMPTYPE").getValue();
							strDTValue = grid_child_element.attribute("VALUE").getValue();

							if(strDTResultType.equals("D") )
							strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMY","en",this.m_strLangId);
						else if(strDTResultType.equals("E") )
							strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMYHM","en",this.m_strLangId);
						System.out.println("TemplateLangRepParser.java,578,strDTValue=>"+strDTValue);
							if(!(grid_child_element.attribute("VALUE").getValue()).equals(""))
							grid_child_element.attribute("VALUE").setValue(strDTValue);
						}
					}*/
					//IN035406.1, ends
					// For List Items Comps in the Grid

					sbXPathDefn.delete(0,sbXPathDefn.length());
					sbXPathDefn.append("//GRID-ROW/GRID-COL/LIST-BOX");

					grid_child_elements = grid_element.selectNodes(sbXPathDefn.toString());

					if (grid_child_elements != null && grid_child_elements.size()>0)
					{						
						for (Element grid_child_element  : grid_child_elements )
						{														
							strBuiltCompId = common_labels.getString("Common.defaultSelect.label");
							grid_child_element.attribute("DFLTSEL").setValue(strBuiltCompId);
							
							strBuiltCompId		= grid_child_element.attribute("NAME").getValue();
							strDiscrId = grid_child_element.attribute("DISCRID").getValue();

							strBuiltCompId += "L_";						
							bRetValue = replaceLangValuesForListItems(grid_child_element,strBuiltCompId,strDiscrId,"L");		 
						}
					}										
				}
					//IN035406.1, starts
					sbXPathDefn.delete(0,sbXPathDefn.length());
					sbXPathDefn.append("//GRID-ROW/GRID-COL/DATE-TIME-NUMERIC[@COMPTYPE='D' or @COMPTYPE='E']");

					List<Element> grid_child_elements 	=  this.m_XMLDocument.selectNodes(sbXPathDefn.toString());
					
					System.out.println("TemplateLangRepParser.java,grid_child_elements=>"+grid_child_elements.size());
					
					if (grid_child_elements != null && grid_child_elements.size()>0)
					{
						for (Element grid_child_element  : grid_child_elements )
						{							
							//Attribute comptype_attr = grid_child_element.attribute("COMPTYPE");
							strDTResultType = grid_child_element.attribute("COMPTYPE").getValue();
							strDTValue = grid_child_element.attribute("VALUE").getValue();

							if(strDTResultType.equals("D") )
								strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMY","en",this.m_strLangId);
							else if(strDTResultType.equals("E") )
								strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMYHM","en",this.m_strLangId);
							System.out.println("TemplateLangRepParser.java,578,strDTValue=>"+strDTValue);
							
							if(!(grid_child_element.attribute("VALUE").getValue()).equals(""))
								grid_child_element.attribute("VALUE").setValue(strDTValue);
						}
					}
					//IN035406.1, ends

				if (pstData != null)pstData.close();
				if (pstData1 != null)pstData1.close();				
			}
			hmLangValues = null;
		}
		catch (Exception eGridHeader)
		{
			bRetValue = false;
			eGridHeader.printStackTrace();
			
		}

		common_labels = null;
		return bRetValue;
	}

	private boolean replaceLangValuesForMatrixHeaders()
	{
		boolean bRetValue			= true;
		
		String strQuery				=	"",strQuery1="",strQuery2="",	strPromptId		=	"";
		String strPromptVal			=	"",					strDefinition	=	"";
		String strDiscrId		=	"";
		String strDiscrDn			=	"";
		String strRowHeader			=	"",					strColHeader	=	"";
		String strDTResultType		=	"",					strDTValue		=	"";

		PreparedStatement	pstData		= null;
		PreparedStatement	pstData1		= null;
		PreparedStatement	pstData2		= null;
		ResultSet			rsData		= null;

		HashMap  hmLangValues		= new HashMap();
		StringTokenizer stComps		= null;
		StringTokenizer stCompIds	= null;

		StringBuffer sbXPathDefn  = new StringBuffer();
		StringBuffer sbCompIds	  = new StringBuffer();

		java.util.Locale loc = new java.util.Locale(this.m_strLangId);

		java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		try
		{
			sbXPathDefn.delete(0,sbXPathDefn.length());
			sbXPathDefn.append("/USER-TEMPLATE/ROW/COL/MATRIX");

//			int nGridTHNdLen			=	0,				nCurIdx					=	0;   //Common-ICN-0092  
//			int nGridNdLen				=	0,				nCurGridNd				=	0;   //Common-ICN-0092

			List<Element> matrix_elements	=	this.m_XMLDocument.selectNodes(sbXPathDefn.toString());
			
			if (matrix_elements != null && matrix_elements.size()>0)
			{
				strQuery	= "SELECT DISCR_MSR_DEF FROM AM_DISCR_COMP_DEFINITION WHERE DISCR_MSR_ID = ?";
				strQuery1 = "SELECT AM_GET_DESC.AM_DISCR_MSR(?,?,'2') SHORT_DESC from dual";
				//strQuery2 = "SELECT LABEL_ID,LABEL_DESC FROM CA_TEMPLATE_LABEL_LANG_VW WHERE LABEL_ID IN (?) AND LANGUAGE_ID = ?";//Commented for IN064044
				pstData		= cnParser.prepareStatement(strQuery);
				pstData1		= cnParser.prepareStatement(strQuery1);
				//pstData2		= cnParser.prepareStatement(strQuery2); //Commented for IN064044

				for (Element matrix_element : matrix_elements )
				{					
					strPromptId		= matrix_element.attribute("DISCRID").getValue();											

					pstData.setString(1,strPromptId);
					rsData = pstData.executeQuery();

					if(rsData.next())
						strDefinition = rsData.getString("DISCR_MSR_DEF")==null?"":rsData.getString("DISCR_MSR_DEF");					

					if(rsData != null) rsData.close();
					if ((strDefinition != null)  && (!strDefinition.equals("")))
					{
						stComps	= new StringTokenizer(strDefinition,"$$$");
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strColHeader = stComps.nextToken();				
						strRowHeader = stComps.nextToken();				

						if ((strColHeader != null) && (!strColHeader.equals("")))
						{				
							sbCompIds.delete(0,sbCompIds.length());
							stCompIds = new StringTokenizer(strColHeader,"~");
							while (stCompIds.hasMoreTokens())
							{
								sbCompIds.append("'"+stCompIds.nextToken()+"',");
							}
						}
					
						if ((strRowHeader != null) && (!strRowHeader.equals("")))
						{		
							stCompIds = new StringTokenizer(strRowHeader,"~");

							while (stCompIds.hasMoreTokens())
							{
								sbCompIds.append("'"+stCompIds.nextToken()+"',");
							}
						}

						sbCompIds.append("'$$$$'");
						}
						//IN035406.1, starts		
					
						pstData1.setString(1,strPromptId);
						pstData1.setString(2,this.m_strLangId);
						rsData = pstData1.executeQuery();

						if (rsData.next())
						{
							strDiscrDn = rsData.getString("SHORT_DESC")==null?"":rsData.getString("SHORT_DESC");
							hmLangValues.put(strPromptId,strDiscrDn);
						}
						if(rsData != null) rsData.close();	
						//IN064044 Changes starts
						strQuery2 = "SELECT LABEL_ID,LABEL_DESC FROM CA_TEMPLATE_LABEL_LANG_VW WHERE LABEL_ID IN ("+sbCompIds.toString()+") AND LANGUAGE_ID = ?";
						pstData2		= cnParser.prepareStatement(strQuery2);						
						//pstData2.setString(1,sbCompIds.toString()); 
						//pstData2.setString(2,this.m_strLangId);
						pstData2.setString(1,this.m_strLangId);
						//IN064044 changes ends
						rsData = pstData2.executeQuery();

						while (rsData.next())
						{
							strDiscrId	= rsData.getString("LABEL_ID");
							strDiscrDn = rsData.getString("LABEL_DESC");

							if(strDiscrDn == null) strDiscrDn = "";

							hmLangValues.put(strDiscrId,strDiscrDn);
						}
						if(rsData != null) rsData.close();
						strPromptVal		= hmLangValues.get(strPromptId)==null?"":(String)hmLangValues.get(strPromptId);
						if (strPromptVal != null && !strPromptVal.equals(""))
						{
							matrix_element.attribute("MATRIX-DESC").setValue(strPromptVal);
						}						
						// Completion of Thai repl for Matrix Name
						sbXPathDefn.delete(0,sbXPathDefn.length());
						sbXPathDefn.append("//MATRIX-TH/TH");
					
						List<Element> th_matrix_elements =	matrix_element.selectNodes(sbXPathDefn.toString());
						if (th_matrix_elements != null && th_matrix_elements.size()>0)
						{
							for (Element th_matrix_element : th_matrix_elements)
							{
								Attribute col_id_attr = th_matrix_element.attribute("COL_ID");
								if(col_id_attr != null)
								{
									strPromptId		= col_id_attr.getValue();
									strPromptVal	= hmLangValues.get(strPromptId)==null?"":(String) hmLangValues.get(strPromptId);
									if (strPromptVal !=null && !strPromptVal.equals(""))									
										th_matrix_element.setText(strPromptVal);									
								}
							}
						}		
						
						sbXPathDefn.delete(0,sbXPathDefn.length());
						sbXPathDefn.append("//MATRIX-ROW");
					
						List<Element> row_matrix_elements =	matrix_element.selectNodes(sbXPathDefn.toString());
						if (row_matrix_elements != null && row_matrix_elements.size()>0)
						{
							for (Element row_matrix_element : row_matrix_elements)
							{														
								strPromptId		= row_matrix_element.attribute("ROW_ID").getValue();
								strPromptVal	= hmLangValues.get(strPromptId)==null?"":(String) hmLangValues.get(strPromptId);
								if (strPromptVal != null && !strPromptVal.equals(""))
									row_matrix_element.attribute("YAXISPROMPT").setValue(strPromptVal);
							}
						}

						// for Date Component Thai Conversion  in Matrix
						/*sbXPathDefn.delete(0,sbXPathDefn.length());
						sbXPathDefn.append("//MATRIX-ROW/MATRIX-COL/DATE-TIME-NUMERIC[@COMPTYPE='E' or @COMPTYPE='D']");
						
						List<Element> dt_matrix_elements	=  matrix_element.selectNodes(sbXPathDefn.toString());
						if (dt_matrix_elements != null && dt_matrix_elements.size()>0)
						{
							for (Element dt_matrix_element : dt_matrix_elements)
							{
								strDTResultType = dt_matrix_element.attribute("COMPTYPE").getValue();								
								strDTValue		= dt_matrix_element.attribute("VALUE").getValue();
								if(strDTResultType.equals("D") )
									strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMY","en",this.m_strLangId);
								else if(strDTResultType.equals("E") )
									strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMYHM","en",this.m_strLangId);
								 dt_matrix_element.attribute("VALUE").setValue(strDTValue);

							}
						}*/
						//IN035406.1, ends
						// for List Items conversion in the Matrix Component
						String strBuiltCompId		=	"";

						sbXPathDefn.delete(0,sbXPathDefn.length());
						sbXPathDefn.append("//MATRIX-ROW/MATRIX-COL/LIST-BOX");
						
						List<Element> col_matrix_elements	=  matrix_element.selectNodes(sbXPathDefn.toString());
						if (col_matrix_elements != null && col_matrix_elements.size()>0)
						{
							for (Element col_matrix_element : col_matrix_elements)
							{
								strBuiltCompId = common_labels.getString("Common.defaultSelect.label");
								col_matrix_element.attribute("DFLTSEL").setValue(strBuiltCompId);
								strBuiltCompId = col_matrix_element.attribute("NAME").getValue();
								strDiscrId = col_matrix_element.attribute("DISCRID").getValue();
								strBuiltCompId += "L_";
								bRetValue = replaceLangValuesForListItems(col_matrix_element,strBuiltCompId,strDiscrId,"L");
							}
						}
				}
				//IN035406.1, starts
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//MATRIX-ROW/MATRIX-COL/DATE-TIME-NUMERIC[@COMPTYPE='E' or @COMPTYPE='D']");
				
				List<Element> dt_matrix_elements	=  this.m_XMLDocument.selectNodes(sbXPathDefn.toString());
				if (dt_matrix_elements != null && dt_matrix_elements.size()>0)
				{
					for (Element dt_matrix_element : dt_matrix_elements)
					{
						strDTResultType = dt_matrix_element.attribute("COMPTYPE").getValue();								
						strDTValue		= dt_matrix_element.attribute("VALUE").getValue();
						if(strDTResultType.equals("D") )
							strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMY","en",this.m_strLangId);
						else if(strDTResultType.equals("E") )
							strDTValue		= com.ehis.util.DateUtils.convertDate(strDTValue,"DMYHM","en",this.m_strLangId);
						dt_matrix_element.attribute("VALUE").setValue(strDTValue);

					}
				}
				//IN035406.1, ends
				if (pstData != null)pstData.close();
				if (pstData1 != null)pstData1.close();
				if (pstData2 != null)pstData2.close();				
			}

			hmLangValues = null;
		}
		catch (Exception eGridHeader)
		{
			bRetValue = false;
			eGridHeader.printStackTrace();
			
		}
		finally{
			try{
				if (pstData != null)pstData.close();//Common-ICN-0092  
				if (pstData1 != null)pstData1.close();//Common-ICN-0092  
				if (pstData2 != null)pstData2.close();//Common-ICN-0092 
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		common_labels = null;
		return bRetValue;
	}

	private boolean setLangIdinTemplate()
	{
		boolean bRetValue = true;

		StringBuffer sbXPathDefn =  new StringBuffer();
		
		try
		{
			
			sbXPathDefn.delete(0,sbXPathDefn.length());
			sbXPathDefn.append("/USER-TEMPLATE");
			
			Element rootElement = (Element)this.m_XMLDocument.selectSingleNode(sbXPathDefn.toString());
			
			if(rootElement != null)
			{				
				Attribute langid_attr =  rootElement.attribute("LANGID");

				if(langid_attr != null)
				{
					langid_attr.setValue(this.m_strLangId);				
				}
			}
		}
		catch (Exception eLangIdSet)
		{
			bRetValue = false;
			eLangIdSet.printStackTrace();
			
		}
		
		return bRetValue;
	}

	private boolean addRangeValuesForComps(String strCompIdIn,String ref_lowIn ,String ref_highIn,String crit_lowIn ,String crit_highIn ,String strCompTypeIn)
	{
		boolean bRetValue = true;

		StringBuffer sbXPathDefn =  new StringBuffer();		
		
		try
		{
			sbXPathDefn.delete(0,sbXPathDefn.length());
			sbXPathDefn.append("/USER-TEMPLATE/ROW/COL");
		
			
			if( strCompTypeIn.equals("I") || strCompTypeIn.equals("N"))		
				
				sbXPathDefn.append("/DATE-TIME-NUMERIC");					
				sbXPathDefn.append("[@DISCRID='" + strCompIdIn+"']");
			
			//List<Element> listElements		=	this.m_XMLDocument.selectNodes(sbXPathDefn.toString());
			Element element		=	(Element)this.m_XMLDocument.selectSingleNode(sbXPathDefn.toString());
			//Node ndCompNode = XPathAPI.selectSingleNode(this.m_XMLDocument,sbXPathDefn.toString());

			if(element != null)
			{
				//Element element = listElements.get(0);
				Attribute ref_low_attr= element.attribute("REF_LOW");	
				Attribute ref_high_attr= element.attribute("REF_HIGH");	
				Attribute crit_low_attr= element.attribute("CRIT_LOW");	
				Attribute crit_high_attr= element.attribute("CRIT_HIGH");	
									
				if(ref_low_attr != null )
				{
					ref_low_attr.setValue(ref_lowIn);					
				}
				if(ref_high_attr != null )
				{
					ref_high_attr.setValue(ref_highIn);					
				}

				if(crit_low_attr != null )
				{
					crit_low_attr.setValue(crit_lowIn);					
				}
				if(crit_high_attr != null )
				{
					crit_high_attr.setValue(crit_highIn);					
				}							
			}
		}
		catch (Exception eReplace)
		{
			eReplace.printStackTrace();
			bRetValue = false;
			
		}	
		
		return bRetValue;
	}

	public void convertString(Document node)
	{
		sbLangReplXML.delete(0,sbLangReplXML.length());
		sbLangReplXML.append(node.asXML());
		String strXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		sbLangReplXML.delete(0,strXml.length());
	}

    private String replaceSpecialChars(String input)
    {
        if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&#60;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&#62;");	
		if (input.indexOf("\\n") != -1) input = input.replaceAll("\\n","&lt;br&gt;");	

        return input;
    }
}
