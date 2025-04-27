/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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

public class TemplateRangeParser  
{

	private Connection cnParser = null;
	private String curr_sec_hdg_code="";
	private String sex="";
	private String dob="";
	public Document m_XMLDocument = null;
	private StringBuffer sbLangReplXML;


public TemplateRangeParser(Connection cnIn,String strSecHdgCodeIn,String sexIn,String dobIn,StringBuffer strXMLContentIn)
{
	cnParser = cnIn;
	sbLangReplXML 	= new StringBuffer();
	curr_sec_hdg_code	=	strSecHdgCodeIn;
	sex	= sexIn;
	dob = dobIn;

	
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

	public StringBuffer getRangePlacedXML()
	{
		String DISCR_MSR_ID		=""; 
		String NUM_REF_LOW		=""; 
		String NUM_REF_HIGH		=""; 
		String NUM_CRIT_LOW		=""; 
		String NUM_CRIT_HIGH	=""; 
		String COMP_TYPE	=""; 
		PreparedStatement pstmt =null ; 
		ResultSet rs =null  ;
		boolean bLangReplRetn			=	false;
		boolean bNoData					=	true;

		sbLangReplXML.delete(0,sbLangReplXML.length());
		
		try
		{	
	
			String range_query = "SELECT A.DISCR_MSR_ID DISCR_MSR_ID,COMP_TYPE,to_char(NUM_REF_LOW) NUM_REF_LOW ,to_char(NUM_REF_HIGH) NUM_REF_HIGH,to_char(NUM_CRIT_LOW) NUM_CRIT_LOW,to_char(NUM_CRIT_HIGH) NUM_CRIT_HIGH FROM AM_DISCR_MSR_REF_RNG_NUM A, CA_SECTION_DISCR_MSR_VW B   WHERE B.SEC_HDG_CODE = ? AND COMP_TYPE IN  ('I','N','A') AND   B.COMP_ID  =  A.DISCR_MSR_ID AND PATIENT_SEX IN (?,'A') AND (trunc(SYSDATE) - to_Date(?,'DD/MM/YYYY')) BETWEEN START_AGE_DAYS AND END_AGE_DAYS "  ;
			pstmt =	cnParser.prepareStatement(range_query);
			pstmt.setString(1,curr_sec_hdg_code);
			pstmt.setString(2,sex);
			pstmt.setString(3,dob);
					
			rs = pstmt.executeQuery();

			while(rs.next())
			{		
				bNoData = false;
				DISCR_MSR_ID	= rs.getString("DISCR_MSR_ID")==null?"":rs.getString("DISCR_MSR_ID");
				COMP_TYPE	= rs.getString("COMP_TYPE")==null?"":rs.getString("COMP_TYPE");
				NUM_REF_LOW		= rs.getString("NUM_REF_LOW")==null?"":rs.getString("NUM_REF_LOW");
				NUM_REF_HIGH	= rs.getString("NUM_REF_HIGH")==null?"":rs.getString("NUM_REF_HIGH");
				NUM_CRIT_LOW	= rs.getString("NUM_CRIT_LOW")==null?"":rs.getString("NUM_CRIT_LOW");
				NUM_CRIT_HIGH	= rs.getString("NUM_CRIT_HIGH")==null?"":rs.getString("NUM_CRIT_HIGH");
				bLangReplRetn = addRangeValuesForComps(DISCR_MSR_ID,NUM_REF_LOW,NUM_REF_HIGH,NUM_CRIT_LOW,NUM_CRIT_HIGH,COMP_TYPE);
			}
			if (bNoData)
			{
				convertString(this.m_XMLDocument);
			}
			else if(bLangReplRetn && ! bNoData)
			{
				convertString(this.m_XMLDocument);
			}
			else
			{	
				this.sbLangReplXML.append("Error For The Section : " + this.curr_sec_hdg_code + " @ Component : " + DISCR_MSR_ID );
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception exep)
			{
				exep.printStackTrace();
			}
		return this.sbLangReplXML;
			
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
