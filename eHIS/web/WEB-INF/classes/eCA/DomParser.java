/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
30/08/2012    IN033507     Chowminya G    Incident No: IN033507 - <System display Year in date/time field incorrect> 
26/09/2012    IN035406     DineshT        In Thai screen, the recorded template data is not populated in modify mode
14/12/2012    IN030681	   ChowminyaG	  ARTIMIS:The formula logic which is used to calculate certain values in the notes is not working
11/03/2012	  IN:047461		Ramesh G	  ML-BRU-SCF-1270: Section Template - Grid Component Modification mode required one empty row.
15/02/2018	 IN063799		Prakash C	15/02/2018		Ramesh		ML-MMOH-CRF-0808
31/07/2019	IN071061		Dinesh T	31/07/2019		Ramesh G	ML-MMOH-SCF-1337
29/10/2019  IN071608		Nijitha s	29/10/2019		Ramesh G	ML-BRU-SCF-1991
29/10/2019  IN073315		Ramesh G 								ML-MMOH-SCF-1562
-----------------------------------------------------------------------
*/
package eCA;

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

public class DomParser implements java.io.Serializable
{
    //StringBuffer displayString = new StringBuffer();
	//Hashtable newHashVals = new Hashtable();  
	//public static Document m_XMLDocument = null;

    public StringBuffer updateXMLContentValues(StringBuffer XMLContent, Hashtable htParameters, String locale)
    {
		StringBuffer displayString = new StringBuffer();
		Document m_XMLDocument = null;
		StringBuffer sbXPathDefn =  new StringBuffer();			
			
        try
        {
			displayString.delete(0,displayString.length());														
			ArrayList<String> comp_list = new ArrayList<String>();
			comp_list.add("SHORT-TEXT");
			comp_list.add("LONG-TEXT");
			comp_list.add("SHORT-TEXT-WTD");
			comp_list.add("LONG-TEXT-WTD");
			comp_list.add("TEXT");
			comp_list.add("DATE-TIME-NUMERIC");
			comp_list.add("LIST-BOX");
			comp_list.add("CHECK-BOX");
			comp_list.add("DATE-TIME-NUMERIC-WTD");
			comp_list.add("LIST-BOX-WTD");
			comp_list.add("CHECK-BOX-WTD");
			comp_list.add("TEXT-BOX");
			comp_list.add("FORMULA-COMP");
			comp_list.add("HIDDEN-FIELD");
			comp_list.add("MULTI-LIST");		
			comp_list.add("COMPONENT");
			comp_list.add("USER-TEMPLATE");
				
			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);							

			for (String compName :  comp_list)
			{
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{ 					
					Attribute nameAttribute= element.attribute("NAME");					
					if (element.getName().equals("USER-TEMPLATE"))
					{
						if (element.attribute("LANGID") != null)
						{
							element.attribute("LANGID").setValue(locale);
						}						
					}else if (element.getName().equals("SHORT-TEXT") || element.getName().equals("LONG-TEXT") || element.getName().equals("SHORT-TEXT-WTD") || element.getName().equals("LONG-TEXT-WTD"))
					{						
						if (htParameters.containsKey(nameAttribute.getValue()))
						{
							
							element.setText((((String)htParameters.get(nameAttribute.getValue())).replaceAll("“","\"").replaceAll("”","\"").replaceAll("’","\'").replaceAll("‘","\'").replaceAll("   ","  ")).trim());
						}else{
							element.setText("");
						}											
					}else if (element.getName().equals("LIST-BOX") || element.getName().equals("LIST-BOX-WTD"))
					{
						Attribute std_comp_result_type_attr= element.attribute("STD_COMP_RESULT_TYPE");
						
						if (std_comp_result_type_attr != null && !std_comp_result_type_attr.getValue().equals(""))
						{
							Attribute std_comp_value_attr= element.attribute("STD_COMP_VALUE");
							if (htParameters.containsKey(nameAttribute.getValue()))
							{
								std_comp_value_attr.setValue((String)htParameters.get(nameAttribute.getValue()));
							}else{
								std_comp_value_attr.setValue("");
							}							
						}else{
							List<Element> childElements = element.elements();
							for (Element childElement : childElements )
							{
								 if (childElement.getName().equals("DATA"))
                                 {
									Attribute list_item_id_attr= childElement.attribute("LIST_ITEM_ID");
									Attribute score_attr= childElement.attribute("SCORE");
									if(list_item_id_attr == null)
									{
										if(score_attr != null)
											list_item_id_attr = score_attr;
										else
											list_item_id_attr = childElement.attribute("VALUE");
									}
									Attribute selected_attr= childElement.attribute("SELECTED");
									
									if (selected_attr != null)
									{
										childElement.remove(selected_attr);
									}
									if (htParameters.containsKey(nameAttribute.getValue()))
									{										
										if (list_item_id_attr.getValue().equals((String) htParameters.get(nameAttribute.getValue())))
										{
											childElement.addAttribute("SELECTED", "true") ;
											//break;
										}										
									}								 
								 }								
							}						
						}					
					}else if (element.getName().equals("MULTI-LIST"))
					{						
							boolean radioSelection = false;							
							Attribute list_selection_attr = element.attribute("LIST_SELECTION");
							Attribute list_presentation_attr = element.attribute("LIST_PRESENTATION");						
							
							if(list_selection_attr != null && list_presentation_attr != null)
							{
								if(list_presentation_attr.getValue().equals("M") && list_selection_attr.getValue().equals("S"))
									radioSelection = true;
							}
							List<Element> childElements = element.elements();							
							for (Element childElement : childElements )
							{
								 if (childElement.getName().equals("MULTI-LIST-ROW"))
                                 {
									 List<Element> childElements1 = childElement.elements();
									 for (Element childElement1 : childElements1 )
									{
										 if (childElement1.getName().equals("MULTI-LIST-DATA"))
										 {								 
												Attribute selected_attr= childElement1.attribute("SELECTED");
												Attribute name_attr= childElement1.attribute("NAME");
											
												if (selected_attr != null)									
													childElement1.remove(selected_attr);																		

												if(radioSelection)
												{													
													if (htParameters.containsKey(nameAttribute.getValue()))
													{										
														if (name_attr.getValue().equals((String) htParameters.get(nameAttribute.getValue())))
														{
															childElement1.addAttribute("SELECTED", "true") ;
															//break;
														}										
													}				
												}else{			
														if (htParameters.containsKey(name_attr.getValue()))
														{														
															childElement1.addAttribute("SELECTED", "true") ;
														}															
												}										 
										 }
									}								 
								 }
							}
					}else if (element.getName().equals("COMPONENT"))
					{				
						if (element.attribute("DEFAULT-CODE") != null)
						{
							if (htParameters.containsKey(element.attribute("NAME").getValue()))
							{
								element.attribute("DEFAULT-CODE").setValue((String)htParameters.get(element.attribute("NAME").getValue()));							
							}else {
								element.attribute("DEFAULT-CODE").setValue("");	
							}
						}
						
					}else
					{
						Attribute othlangval_attr = element.attribute("OTHLANGVAL");
						Attribute value_attr = element.attribute("VALUE");
						Attribute comptype_attr = element.attribute("COMPTYPE");
						Attribute resulttype_attr		= null;
						String str_comptype	=	"";
						String str_resulttype	=	"";
						String str_parm_value		=	"";
						String str_otherlang_val	=	"";

							if(comptype_attr != null)
								str_comptype	= comptype_attr.getValue();
														
							if(str_comptype.equals("A") )
							{
								resulttype_attr	= element.attribute("RESULTTYPE");
								str_resulttype = resulttype_attr.getValue();
							}
							
							if(element.getName().equals("DATE-TIME-NUMERIC"))
                            {
                                Attribute num_prefix_required_yn_attr = element.attribute("NUM_PREFIX_REQUIRED_YN");
                                
								if( num_prefix_required_yn_attr != null)
                                {
                                    if(num_prefix_required_yn_attr.getValue().equals("Y"))
                                    { 
										if (htParameters.containsKey(nameAttribute.getValue()+"_number_prefix"))
										{
											Attribute prefix_char_att = element.attribute("PREFIX_CHAR"); 
											prefix_char_att.setValue((String) htParameters.get(nameAttribute.getValue()+"_number_prefix"));				
										}                                                                        										
                                    }
                                }
                            }																				
								if (htParameters.containsKey(nameAttribute.getValue()))
                                {
									str_parm_value	= (String) htParameters.get(nameAttribute.getValue());
									str_otherlang_val	= str_parm_value;

									if(str_comptype.equals("D") )
										str_parm_value		= com.ehis.util.DateUtils.convertDate(str_parm_value,"DMY",locale,"en");
									else if(str_comptype.equals("E") )
										str_parm_value		= com.ehis.util.DateUtils.convertDate(str_parm_value,"DMYHM",locale,"en");
									else if(str_comptype.equals("A") )
									{
										if(str_resulttype.equals("D") )
										{
											//if(str_resulttype.length() > 10)
											if(str_parm_value.length() > 10) //IN030681
												str_parm_value = com.ehis.util.DateUtils.convertDate(str_parm_value,"DMYHM",locale,"en");
											else
												str_parm_value = com.ehis.util.DateUtils.convertDate(str_parm_value,"DMY",locale,"en");
										}
									}
									else if(str_comptype.equals("N"))
									{					
										if(!str_parm_value.equals(""))
										{
											String arrVal[] = str_parm_value.split("\\.");
											String str_parm_value_temp = "";											
											if(arrVal.length>0)
											{												
												if(arrVal.length==2)
												{   
													if(arrVal[0]==null||arrVal[0].equals(""))
													{
														arrVal[0]="0";
													}
													if(arrVal[1]==null||arrVal[1].equals(""))
													{
														arrVal[1]="0";
													}

													//if(Integer.parseInt(arrVal[0])>0)//IN073315
													//{
														str_parm_value_temp = arrVal[0];
													//}									
													

													if(Integer.parseInt(arrVal[1])>0)
													{
														str_parm_value_temp = str_parm_value_temp+"." + arrVal[1];
													}
													if(!str_parm_value_temp.equals(""))
													{
														str_parm_value = str_parm_value_temp;
													}
													else
													{
														str_parm_value = "0";
													}
												}
												else if(arrVal.length==1)
												{													
													if(arrVal[0]==null||arrVal[0].equals(""))
													{
														arrVal[0]="0";
													}
													if(str_parm_value.charAt(0)=='.')
													{
														if(Integer.parseInt(arrVal[0])>0)
														{
															str_parm_value_temp = str_parm_value ;
						
														}
														else
														{
															str_parm_value_temp = "0";
														}														
													}
													else
													{
														if(Integer.parseInt(arrVal[0])>0)
														{
															str_parm_value_temp = arrVal[0] ;						
														}
														else
														{
															str_parm_value_temp = "0";
														}
													}

													if(!str_parm_value_temp.equals(""))
													{
														str_parm_value = str_parm_value_temp;
													}
													else
													{
														str_parm_value = "0";
													}
												}
											}
										}
								}
									if (value_attr == null)
										element.addAttribute("VALUE", str_parm_value) ;	
									else
										value_attr.setValue(str_parm_value);
									if(str_comptype.equals("D") || str_comptype.equals("E") || str_comptype.equals("A") )
									{										
										if(othlangval_attr == null)											
											element.addAttribute("OTHLANGVAL", str_otherlang_val) ;												
										else										
											othlangval_attr.setValue(str_otherlang_val);										
									}                                      
                                }else{
									if (value_attr == null)
										element.addAttribute("VALUE", "") ;	
									else
										value_attr.setValue("");

									if(str_comptype.equals("D") || str_comptype.equals("E") || str_comptype.equals("A") )
									{										
										if(othlangval_attr == null)											
											element.addAttribute("OTHLANGVAL", "") ;												
										else										
											othlangval_attr.setValue("");										
									}      

								}
					}
				}										
			}
			//display(this.m_XMLDocument);
			displayString = convertString(m_XMLDocument,displayString);
			htParameters.clear();
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return displayString;
    }

	public StringBuffer updateXMLOutContentValues(StringBuffer XMLContentAct, StringBuffer XMLContent ,Hashtable htParameters, String locale,String xslURL)
    {
		StringBuffer sbXPathDefn =  new StringBuffer();
		StringBuffer displayString = new StringBuffer();
		Document m_XMLDocument = null;
        try
        {				
			htParameters =new Hashtable(updateOutHtParamValues(XMLContentAct,htParameters,locale,xslURL));			
			displayString.delete(0,displayString.length());

			ArrayList<String> comp_list = new ArrayList<String>();
			comp_list.add("FIELD");
				
			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);				
            		
			for (String compName :  comp_list)
			{
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{
					Attribute id_attr= element.attribute("ID");
					if (htParameters.containsKey(id_attr.getValue()))
					{
						element.setText((String)htParameters.get(id_attr.getValue()));
					}
				} 							
			}
			//display(this.m_XMLDocument);
			displayString = convertString(m_XMLDocument,displayString);
			htParameters.clear();
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return displayString;
    }

	//This Method is used to update values for List,Matrix,Grid and Embedded Components to Notes OUTPUT Format.
//Added on 06/04/2010 By Sridhar Reddy V  

public Hashtable updateOutHtParamValues(StringBuffer XMLContent, Hashtable htParameters, String locale,String xslURL)
{
		StringBuffer sbXPathDefn =  new StringBuffer();		
		StringBuffer displayString = new StringBuffer();
		Document m_XMLDocument = null;
        try
        {			
			displayString.delete(0,displayString.length());														
			ArrayList<String> comp_list = new ArrayList<String>();
			comp_list.add("SHORT-TEXT");
			comp_list.add("LONG-TEXT");
			comp_list.add("SHORT-TEXT-WTD");
			comp_list.add("LONG-TEXT-WTD");
			comp_list.add("TEXT");
			comp_list.add("DATE-TIME-NUMERIC");
			comp_list.add("LIST-BOX");
			comp_list.add("CHECK-BOX");
			comp_list.add("DATE-TIME-NUMERIC-WTD");
			comp_list.add("LIST-BOX-WTD");
			comp_list.add("CHECK-BOX-WTD");
			comp_list.add("TEXT-BOX");
			comp_list.add("FORMULA-COMP");
			comp_list.add("HIDDEN-FIELD");
			comp_list.add("MULTI-LIST");		
			comp_list.add("MATRIX");		
			comp_list.add("PARAGRAPH");		
			comp_list.add("GRID");		

			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);		
			XMLtoHTML converthtml = new XMLtoHTML();		
			String matrixContent = new String();
			StringBuffer matrixName = new StringBuffer();	
			StringBuffer mutlisel = new StringBuffer();
			String EmbdContent = "";
			String tempmatrixContent = "";
			
			for (String compName :  comp_list)
			{
				tempmatrixContent = new String(XMLContent);
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{ 					
					Attribute nameAttribute= element.attribute("NAME");	
					if (element.getName().equals("LIST-BOX") || element.getName().equals("LIST-BOX-WTD"))
					{
						Attribute std_comp_result_type_attr= element.attribute("STD_COMP_RESULT_TYPE");						
						if (std_comp_result_type_attr == null)
						{
							List<Element> childElements = element.elements();
							for (Element childElement : childElements )
							{
								 if (childElement.getName().equals("DATA"))
                                 {
									Attribute list_item_id_attr= childElement.attribute("LIST_ITEM_ID");
									Attribute score_attr= childElement.attribute("SCORE");
									if(list_item_id_attr == null)
									{
										if(score_attr != null)
											list_item_id_attr = score_attr;
										else
											list_item_id_attr = childElement.attribute("VALUE");
									}
									Attribute selected_attr= childElement.attribute("SELECTED");
									
									if (selected_attr != null)
									{
										childElement.remove(selected_attr);
									}
									if (htParameters.containsKey(nameAttribute.getValue()))
									{										
										if (list_item_id_attr.getValue().equals((String) htParameters.get(nameAttribute.getValue())))
										{
											htParameters.remove(nameAttribute.getValue());
											htParameters.put(nameAttribute.getValue(),childElement.getText()); 											
											break;
										}										
									}								 
								 }								
							}						
						}				
					}else if (element.getName().equals("MULTI-LIST"))
					{						
							boolean radioSelection = false;							
							Attribute list_selection_attr = element.attribute("LIST_SELECTION");
							Attribute list_presentation_attr = element.attribute("LIST_PRESENTATION");		
							String htCompName = element.attribute("NAME").getValue();
							mutlisel.delete(0,mutlisel.length());
							if(list_selection_attr != null && list_presentation_attr != null)
							{
								if(list_presentation_attr.getValue().equals("M") && list_selection_attr.getValue().equals("S"))
									radioSelection = true;
							}
							List<Element> childElements = element.elements();							
							for (Element childElement : childElements )
							{
								 if (childElement.getName().equals("MULTI-LIST-ROW"))
                                 {
									 List<Element> childElements1 = childElement.elements();
									 for (Element childElement1 : childElements1 )
									{
										 if (childElement1.getName().equals("MULTI-LIST-DATA"))
										 {								 
												Attribute selected_attr= childElement1.attribute("SELECTED");
												Attribute name_attr= childElement1.attribute("NAME");
											
												if (selected_attr != null)									
													childElement1.remove(selected_attr);																		

												if(radioSelection)
												{													
													if (htParameters.containsKey(nameAttribute.getValue()))
													{										
														if (name_attr.getValue().equals((String) htParameters.get(nameAttribute.getValue())))
														{
															if(!mutlisel.toString().equals(""))
															{
																mutlisel.append(",");
																mutlisel.append(childElement1.getText());
															}
															else
															{
																mutlisel.append(childElement1.getText());
															}															
															break;
														}										
													}				
												}else{			
														if (htParameters.containsKey(name_attr.getValue()))
														{		
															if(!mutlisel.toString().equals(""))
															{
																mutlisel.append(",");
																mutlisel.append(childElement1.getText());
															}
															else
															{
																mutlisel.append(childElement1.getText());
															}
														}															
												}										 
										 }
									}								 
								 }else if (childElement.getName().equals("TEXT"))
								 {
										Attribute name_attr= childElement.attribute("NAME");
										Attribute value_attr= childElement.attribute("VALUE");
										if (htParameters.containsKey(name_attr.getValue()))
										{		
												//if(!mutlisel.toString().equals(""))IN071608
												if(!mutlisel.toString().equals("") && !"".equals(value_attr.getValue()))//IN071608
												{
													mutlisel.append(",");
													mutlisel.append(value_attr.getValue());
												}
												else
												{
													mutlisel.append(value_attr.getValue());
												}																													
										}
								 }
							}
							if (htParameters.containsKey(htCompName))
							{
								htParameters.remove(htCompName);
							}							
							htParameters.put(htCompName,mutlisel.toString()); 
					}else if (element.getName().equals("MATRIX"))
					{						
						matrixName.delete(0,matrixName.length());																						
						matrixContent = tempmatrixContent.substring(tempmatrixContent.indexOf("<MATRIX"),tempmatrixContent.indexOf("</MATRIX>")+9);
						tempmatrixContent = tempmatrixContent.substring(tempmatrixContent.indexOf("</MATRIX>")+9,tempmatrixContent.length());							
						matrixName.append(element.attributeValue("NAME"));
						matrixName.append(element.attributeValue("SECSEQ"));
						matrixContent = converthtml.buildHTMLFromXML(matrixContent,xslURL);
						matrixContent = matrixContent.substring(matrixContent.indexOf("<table"),matrixContent.indexOf("</table>")+8);						
						htParameters.put(matrixName.toString(),matrixContent);	
					
					}else if (element.getName().equals("GRID"))
					{						
						matrixName.delete(0,matrixName.length());											
						matrixContent = tempmatrixContent.substring(tempmatrixContent.indexOf("<GRID"),tempmatrixContent.indexOf("</GRID>")+7);
						tempmatrixContent = tempmatrixContent.substring(tempmatrixContent.indexOf("</GRID>")+7,tempmatrixContent.length());							
						matrixName.append(element.attributeValue("NAME"));
						matrixName.append(element.attributeValue("SECSEQ"));
						matrixContent = converthtml.buildHTMLFromXML(matrixContent,xslURL);									
						matrixContent = matrixContent.substring(matrixContent.indexOf("<table"),matrixContent.indexOf("</table>")+8);												
						htParameters.put(matrixName.toString(),matrixContent);
					
					}else if (element.getName().equals("PARAGRAPH"))
					{					
						matrixName.delete(0,matrixName.length());												
						matrixContent = tempmatrixContent.substring(tempmatrixContent.indexOf("<PARAGRAPH"),tempmatrixContent.indexOf("</PARAGRAPH>")+12);
						tempmatrixContent = tempmatrixContent.substring(tempmatrixContent.indexOf("</PARAGRAPH>")+12,tempmatrixContent.length());							
						matrixName.append(element.attributeValue("NAME"));							
						matrixContent = converthtml.buildHTMLFromXML(matrixContent,xslURL);										
						if (matrixContent.indexOf("<td") >= 0)
						{							
							EmbdContent = matrixContent.substring(matrixContent.indexOf("<td"),matrixContent.indexOf(">")+1);								
							matrixContent = matrixContent.substring(matrixContent.indexOf(EmbdContent)+EmbdContent.length(),matrixContent.indexOf("</td>"));														
						}														
						htParameters.put(matrixName.toString(),matrixContent);
					
					}
				}										
			}			
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return htParameters;
    }

	public String isTemplateEmpty(StringBuffer XMLContent,Hashtable htParameters)
    {
		List compList = new ArrayList();		
		String compVal = "";
		String returnFlag = "false";
		StringBuffer sbXPathDefn =  new StringBuffer();
		Document m_XMLDocument = null;
        try
        {			
			ArrayList<String> comp_list = new ArrayList<String>();
			comp_list.add("SHORT-TEXT");
			comp_list.add("LONG-TEXT");
			comp_list.add("SHORT-TEXT-WTD");
			comp_list.add("LONG-TEXT-WTD");
			comp_list.add("TEXT");
			comp_list.add("DATE-TIME-NUMERIC");
			comp_list.add("LIST-BOX");
			comp_list.add("CHECK-BOX");
			comp_list.add("DATE-TIME-NUMERIC-WTD");
			comp_list.add("LIST-BOX-WTD");
			comp_list.add("CHECK-BOX-WTD");
			comp_list.add("TEXT-BOX");
			comp_list.add("FORMULA-COMP");			
			comp_list.add("MULTI-LIST");							
	
			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);				           
			
			for (String compName :  comp_list)
			{	
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{ 						
					if (element.getName().equals("MULTI-LIST"))
					{	
						List<Element> childElements = element.elements();							
						for (Element childElement : childElements )
						{
							if (childElement.getName().equals("MULTI-LIST-ROW"))
							{
								 List<Element> childElements1 = childElement.elements();
								 for (Element childElement1 : childElements1 )
								{
									 if (childElement1.getName().equals("MULTI-LIST-DATA"))
									 {
										if (htParameters.containsKey(childElement1.attribute("NAME").getValue()))
										{
											compVal = (String)htParameters.get(childElement1.attribute("NAME").getValue());
											if (!compVal.trim().equals(""))
											{
												compList.add(compVal);
											}		
										}		
									 }
								}								 
							}
						}
					}else{
						if (htParameters.containsKey(element.attribute("NAME").getValue()))
						{
							compVal = (String)htParameters.get(element.attribute("NAME").getValue());
							if (!compVal.trim().equals(""))
							{
								compList.add(compVal);
							}		
						}						
					}			
				}																		
			}			
			if (compList.size() > 0)
			{
				returnFlag = "true";
			}	
			
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return returnFlag;
    }

	public Hashtable clearComponentValues(StringBuffer XMLContent,Hashtable htParameters)
    {
		List compList = new ArrayList();		
		//String compVal = "";//Checkstyle
		String returnFlag = "false";
		StringBuffer sbXPathDefn =  new StringBuffer();
		Document m_XMLDocument = null;
        try
        {
			ArrayList<String> comp_list = new ArrayList<String>();
			comp_list.add("SHORT-TEXT");
			comp_list.add("LONG-TEXT");
			comp_list.add("SHORT-TEXT-WTD");
			comp_list.add("LONG-TEXT-WTD");
			comp_list.add("TEXT");
			comp_list.add("DATE-TIME-NUMERIC");
			comp_list.add("LIST-BOX");
			comp_list.add("CHECK-BOX");
			comp_list.add("DATE-TIME-NUMERIC-WTD");
			comp_list.add("LIST-BOX-WTD");
			comp_list.add("CHECK-BOX-WTD");
			comp_list.add("TEXT-BOX");
			comp_list.add("FORMULA-COMP");			
			comp_list.add("MULTI-LIST");					
			
			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);		
            
			for (String compName :  comp_list)
			{	
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{ 	
					Attribute nameAttribute= element.attribute("NAME");
					if (htParameters.containsKey(nameAttribute.getValue()))
					{
						htParameters.put(compName,"");
					}				
				}																	
			}					
			if (compList.size() > 0)
			{
				returnFlag = "true";
			}
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }		
		return htParameters;
    }
/*	public void display(Node node)
    {
        if (node == null)
        {
            return;
        }
        int type = node.getNodeType();		
        switch (type)
        {
            case Element.DOCUMENT_NODE:
            {
                displayString.append("");
                display(((Document) node).getRootElement());
                break;
            }
            case Element.ELEMENT_NODE:
            {
                displayString.append("<");
                displayString.append(node.getName());
				Element element = (Element) node;
				List<Attribute> attrList = element.attributes();
				for (Attribute attrList1  : attrList )
				{
					displayString.append(" ");
                    displayString.append(attrList1.getName());
                    displayString.append("=\"");
                    displayString.append(replaceSpecialChars(attrList1.getValue()));
                    displayString.append("\"");
				}			              
				 displayString.append(">");
				 displayString.append(element.getText());
				List<Element> child_elements = element.elements();
				if (child_elements != null)
				{
					for (Element child_elements1  : child_elements )
					{
						display(child_elements1);
					}
				}
                break;
            }

            case Element.CDATA_SECTION_NODE:
            {
                displayString.append("<![CDATA[");
                displayString.append(node.getText());
                displayString.append("]]>");
            }
            case Element.TEXT_NODE:
            {
                String newText = replaceSpecialChars(node.getText());
                if (newText.length() > 0) {
                    displayString.append(newText);
                }
                break;
            }
            case Element.PROCESSING_INSTRUCTION_NODE:
            {
                displayString.append("<?");
                displayString.append(node.getName());
                String text = node.getText();
                if (text != null && text.length() > 0)
                {
                    displayString.append(text);
                }
                displayString.append("?>");
                break;
            }
        }
        if (type == Element.ELEMENT_NODE)
        {
            displayString.append("</");
            displayString.append(node.getName());
            displayString.append(">");
        }
    }*/

	public StringBuffer convertString(Document node,StringBuffer displayString)
	{		
		displayString.delete(0,displayString.length());
		displayString.append(node.asXML());
		String strXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		displayString.delete(0,strXml.length());
		return displayString;
	}
    private String replaceSpecialChars(String input)
    {
         
		if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&#60;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&#62;");	
		if (input.indexOf("\\n") != -1) input = input.replaceAll("\\n","&lt;br&gt;");	
		
        return input;
    }
/* Added new method for PMG20089-CRF-0690  By Sridhar Reddy
	Description : To get the Previous recorded LMP,EDD, Gestation Age, 
	Corrected EDD and Corrected EDD param values to  defaults in MC templates.

	Modified By : Sridhar Reddy
	Date : 02/02/2010
	CRF : PMG20089-CRF-0690.1
*/
	public StringBuffer updateXMLContent(StringBuffer XMLContent, String locale,Connection con,ArrayList paramList) throws Exception
	{
		StringBuffer displayString = new StringBuffer();
		Document m_XMLDocument = null;
        try
        {
			displayString.delete(0,displayString.length());
			 StringBuffer sbXPathDefn = new StringBuffer();
			 String p_facility_id = "";
			 String p_encounter_id = "";
			 String p_patient_id = "";
			 String p_mc_event_code = "";
			 String p_cycle_no = "0";
			 String p_editabale_yn = "Y";
			 String p_lmp = "";
			 String p_lmp_oth_lan = "";
			 String p_ga = "";
			 String p_edd = "";
			 String p_edd_oth_lan = "";
			 String p_corr_edd = "";		
			 String p_corr_edd_oth_lan = "";		
			 String p_corr_edd_param_val = "";		
			
			 // Added By : Sridhar Reddy V
			//	  Date : 09/01/2010
			//	  CRF  : PMG20089-CRF-0690.1
			//	  Discription : Introduced new parameter "p_pat_lmp" to assign the recorded value of "LMP as per patient" component value form 
			//	  CA_SPL_GET_MC_KEY_VAL function to default in Mothercare templates where ever "LMP as per patient" component exists.
			 
			  String p_pat_lmp_oth_lan = "";		
			  String p_pat_lmp = "";		
			  String p_min_gestation = "";		
			  String p_max_gestation = "";		
			  String p_gestation_unit = "";		
			  //end

			  String pract_id		= "";
			  String pract_desc	= "";
			  String nurse_id		= "";
			  String nurse_desc	= "";
			  String discMsrVal = "";
			  String p_subhdr_code = "";
			  ArrayList<String> componentList = new ArrayList<String>();
			  componentList.add("C_MC05ATNDGDOCTOR");
			  componentList.add("C_MC08NURSE");
			  componentList.add("C_MC53STG3MOTHRCO");
			  componentList.add("C_MC53STG3MOTRCO2");
			  componentList.add("C_MC53STG3MOTRCO3");
			  componentList.add("C_MC06MOTHRCOMPLC");
			  componentList.add("C_MC06MOTHRCOMPL2");
			  componentList.add("C_MC06MOTHRCOMPL3");
			  componentList.add("C_MC53PER1");

			if (paramList.size() > 0)
			{
				 p_facility_id = ((String)paramList.get(0)) == null ? "": (String)paramList.get(0);
				 p_encounter_id = ((String)paramList.get(1)) == null ? "": (String)paramList.get(1);
				 p_mc_event_code = ((String)paramList.get(2)) == null ? "": (String)paramList.get(2);
				 p_cycle_no = ((String)paramList.get(3)) == null ? "": (String)paramList.get(3);
				 p_patient_id = ((String)paramList.get(4)) == null ? "": (String)paramList.get(4);				
			}			
			CallableStatement  cstmt = con.prepareCall("{call CA_SPL_GET_MC_KEY_VAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			cstmt.setString(1,p_facility_id);
			cstmt.setString(2,p_encounter_id);
			cstmt.setString(3,p_mc_event_code);
			cstmt.setInt(4,Integer.parseInt(p_cycle_no));
			cstmt.setString(5,p_patient_id);
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);
			cstmt.registerOutParameter(9,Types.VARCHAR);
			cstmt.registerOutParameter(10,Types.VARCHAR);
			cstmt.registerOutParameter(11,Types.VARCHAR);
			cstmt.registerOutParameter(12,Types.VARCHAR);
			cstmt.registerOutParameter(13,Types.NUMERIC);
			cstmt.registerOutParameter(14,Types.NUMERIC);
			cstmt.registerOutParameter(15,Types.VARCHAR);

			cstmt.execute();
		
			p_editabale_yn = cstmt.getString(6)==null?"Y":cstmt.getString(6);
			p_lmp = cstmt.getString(7);
			p_ga = cstmt.getString(8);
			p_edd = cstmt.getString(9);
			p_corr_edd = cstmt.getString(10);
			p_corr_edd_param_val = cstmt.getString(11);
			p_pat_lmp = cstmt.getString(12);
			p_min_gestation = cstmt.getString(13);
			p_max_gestation = cstmt.getString(14);
			p_gestation_unit = cstmt.getString(15);
			
			if (cstmt != null)cstmt.close();			
	
			String Del_rec_qry ="  select ATTEND_PRACT_ID pract_id,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,?,1) pract_desc, ATTEND_NURSE_ID nurse_id,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,?,1) nurse_desc From CA_SPL_DELIVERY_RECORD where MOTHER_PATIENT_ID = ? and FACILITY_ID = ? and CYCLE_NO = ? ";

			String Disrc_qry = " select RESULT_STR from CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B,CA_SPLTY_DISCR_MSR C where C.ACCESSION_NUM=B.ACCESSION_NUM AND A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID = ? AND B.FACILITY_ID = ? AND B.MODULE_ID= 'MC' AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_TASK_CODE='MCT005' AND C.DISCR_MSR_ID = ? AND B.BIRTH_ORDER='1' ";					

			PreparedStatement pstmt		    =	con.prepareStatement(Del_rec_qry);		

			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,p_patient_id);
			pstmt.setString(4,p_facility_id);
			pstmt.setString(5,p_cycle_no);

			ResultSet rs	 =	pstmt.executeQuery();		

			if(rs.next())
			{
				pract_id = rs.getString("pract_id") == null?"":rs.getString("pract_id");
				pract_desc = rs.getString("pract_desc") == null?"":rs.getString("pract_desc");
				nurse_id = rs.getString("nurse_id") == null?"":rs.getString("nurse_id");
				nurse_desc = rs.getString("nurse_desc") == null?"":rs.getString("nurse_desc");
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			pstmt		    =	con.prepareStatement(Disrc_qry);
				
			ArrayList<String> comp_list = new ArrayList<String>();
			comp_list.add("DATE-TIME-NUMERIC");
			comp_list.add("FORMULA-COMP");
			comp_list.add("LIST-BOX");						
			comp_list.add("MULTI-LIST");		

			SAXReader reader = new SAXReader();
			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);		
			
			for (String compName :  comp_list)
			{
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{ 				
					//Attribute nameAttribute= element.attribute("NAME");//checkstyle
					Attribute compid_attr = element.attribute("COMPID");	
					String component_id = compid_attr.getValue();
					if (element.getName().equals("DATE-TIME-NUMERIC") || element.getName().equals("FORMULA-COMP"))
					{													
						Attribute value_attr = element.attribute("VALUE");								
						Attribute editable_attr = element.attribute("EDITABLE");								
						Attribute othlangval_attr = element.attribute("OTHLANGVAL");		
						Attribute onblurreq_attr = element.attribute("ONBLURREQ");							

						if (editable_attr == null)
						{							
							// Modified By : Sridhar Reddy V
							//	  Date : 09/01/2010
							//	  CRF  : PMG20089-CRF-0690.1
							//	  Discription : Below code added to control the edit previlage of LMP as per patient component. 
						 						   
							if (component_id.equals("C_MC01PATLMP") && p_pat_lmp != null && !p_pat_lmp.equals(""))
								element.addAttribute("EDITABLE","N");	
							else if(component_id.equals("C_MC01LMP") || component_id.equals("C_MC01GESTNAGE") || component_id.equals("C_MC01EDD") || component_id.equals("C_MC01CORRECTDEDD") ||  component_id.equals("C_MC01PATLMP"))																			
								element.addAttribute("EDITABLE",p_editabale_yn);	
							else								
								element.addAttribute("EDITABLE","Y");																						
						}	
						
						//Added By : Sridhar Reddy V
						//	  Date : 09/01/2010
						//	  CRF  : PMG20089-CRF-0690.1
							//  Discription : Below code added for "To update the value of C_MC01PATLMP component". 
						 
							if (component_id.equals("C_MC01PATLMP"))
							{																						
								value_attr.setValue(p_pat_lmp);					
								if (!locale.equals("en"))								
									p_pat_lmp_oth_lan = com.ehis.util.DateUtils.convertDate(p_pat_lmp, "DMY", "en", locale);								
								else
									p_pat_lmp_oth_lan = com.ehis.util.DateUtils.convertDate(p_pat_lmp, "DMY", locale, "en");	

								othlangval_attr.setValue(p_pat_lmp_oth_lan);	
								if (p_pat_lmp == null)
								{
									if (onblurreq_attr == null)								
										element.addAttribute("ONBLURREQ","Y");		
									else
										onblurreq_attr.setValue("Y");
								}																
							}else if (component_id.equals("C_MC01LMP"))
							{																						
								value_attr.setValue(p_lmp);		

								Attribute mingesparamval_attr = element.attribute("MINGESPARAMVAL");	
								Attribute maxgesparamval_attr = element.attribute("MAXGESPARAMVAL");	
								Attribute gesunit_attr = element.attribute("GESUNIT");

								if (!locale.equals("en"))								
									p_lmp_oth_lan = com.ehis.util.DateUtils.convertDate(p_lmp, "DMY", "en", locale);
								else
									p_lmp_oth_lan = com.ehis.util.DateUtils.convertDate(p_lmp, "DMY", locale, "en");				
								
									othlangval_attr.setValue(p_lmp_oth_lan);	

								if (onblurreq_attr == null)								
									element.addAttribute("ONBLURREQ","Y");		
								else
									onblurreq_attr.setValue("Y");
								
								if (mingesparamval_attr == null)
									element.addAttribute("MINGESPARAMVAL",p_min_gestation);							
								
								if (maxgesparamval_attr == null)								
									element.addAttribute("MAXGESPARAMVAL",p_max_gestation);									
																
								if (gesunit_attr == null)								
									element.addAttribute("GESUNIT",p_gestation_unit);									
								

							}else if (component_id.equals("C_MC01GESTNAGE"))
							{									
								value_attr.setValue(p_ga);				
								Attribute unit_attr = element.attribute("UNIT");								
								if (unit_attr != null)								
									unit_attr.setValue("");											
															
							}else if (component_id.equals("C_MC01EDD"))
							{											
								
								value_attr.setValue(p_edd);				
								if (!locale.equals("en"))								
									p_edd_oth_lan = com.ehis.util.DateUtils.convertDate(p_edd, "DMY", "en", locale);	
								else
									p_edd_oth_lan = com.ehis.util.DateUtils.convertDate(p_edd, "DMY", locale, "en");
									
								//value_attr.setValue(p_edd_oth_lan);			
								othlangval_attr.setValue(p_edd_oth_lan);			
									//nodeothlangval.setNodeValue(p_edd_oth_lan);							
							}else if (component_id.equals("C_MC01CORRECTDEDD"))
							{											
								value_attr.setValue(p_corr_edd);			
								
								Attribute edd_attr = element.attribute("EDD");
								Attribute creddparamval_attr = element.attribute("CREDDPARAMVAL");
								Attribute mingesparamval_attr = element.attribute("MINGESPARAMVAL");
								Attribute maxgesparamval_attr = element.attribute("MAXGESPARAMVAL");
								Attribute gesunit_attr = element.attribute("GESUNIT");								

								if (!locale.equals("en"))
									p_corr_edd_oth_lan = com.ehis.util.DateUtils.convertDate(p_corr_edd, "DMY", "en", locale);									
								else
									p_corr_edd_oth_lan = com.ehis.util.DateUtils.convertDate(p_corr_edd, "DMY",locale,"en") ;
									
								othlangval_attr.setValue(p_corr_edd_oth_lan);		
																
								if (edd_attr == null)								
									element.addAttribute("EDD",p_edd);									
																
								if (creddparamval_attr == null)
									element.addAttribute("CREDDPARAMVAL",p_corr_edd_param_val);			
																
								if (mingesparamval_attr == null)
									element.addAttribute("MINGESPARAMVAL",p_min_gestation);									
								
								if (maxgesparamval_attr == null)
									element.addAttribute("MAXGESPARAMVAL",p_max_gestation);		
								
								if (gesunit_attr == null)								
									element.addAttribute("GESUNIT",p_gestation_unit);											
							}
					}else if (element.getName().equals("LIST-BOX") && componentList.contains(component_id))
					{							
						Attribute std_comp_value_attr= element.attribute("STD_COMP_VALUE");
						if (component_id.equals("C_MC05ATNDGDOCTOR"))
							std_comp_value_attr.setValue(pract_desc);
						else if (component_id.equals("C_MC08NURSE"))
							std_comp_value_attr.setValue(nurse_desc);									
						else
						{																												
							discMsrVal="";
							if (component_id.equals("C_MC53STG3MOTHRCO") || component_id.equals("C_MC53STG3MOTRCO2") || component_id.equals("C_MC53STG3MOTRCO3"))
							{
								p_subhdr_code = "MC53";
							}if (component_id.equals("C_MC06MOTHRCOMPLC") || component_id.equals("C_MC06MOTHRCOMPL2") || component_id.equals("C_MC06MOTHRCOMPL3"))
							{
								p_subhdr_code = "MC52";
							}
							
							pstmt.setString(1,p_patient_id);
							pstmt.setString(2,p_facility_id);
							pstmt.setString(3,p_cycle_no);								
							pstmt.setString(4,p_subhdr_code);								
							pstmt.setString(5,element.attribute("DISCRID").getValue());

							

							rs	 =	pstmt.executeQuery();								
							if(rs.next())
								discMsrVal = rs.getString("RESULT_STR") == null?"":rs.getString("RESULT_STR");

							
																				
							if(rs!=null) rs.close();

							List<Element> childElements = element.elements();
							for (Element childElement : childElements )
							{
								 if (childElement.getName().equals("DATA"))
								 {
									//Attribute list_item_id_attr= childElement.attribute("LIST_ITEM_ID");		
									Attribute selected_attr= childElement.attribute("SELECTED");		
									
									if (selected_attr != null)
									 {
										
										childElement.remove(selected_attr);
									 }

									
									if(childElement.getText().trim().equals(discMsrVal.trim()))
									{										
										
										childElement.addAttribute("SELECTED", "true") ;
										break;										
									}																 
								 }								
							}						
						}					
					}else if (element.getName().equals("MULTI-LIST") && componentList.contains(component_id))
					{
							discMsrVal="";
							pstmt.setString(1,p_patient_id);
							pstmt.setString(2,p_facility_id);
							pstmt.setString(3,p_cycle_no);								
							pstmt.setString(4,element.attribute("DISCRID").getValue());

							rs	 =	pstmt.executeQuery();
							
							if(rs.next())								
								discMsrVal = rs.getString("RESULT_STR") == null?"":rs.getString("RESULT_STR");		

							if(rs!=null) rs.close();


							boolean radioSelection = false;							
							Attribute list_selection_attr = element.attribute("LIST_SELECTION");
							Attribute list_presentation_attr = element.attribute("LIST_PRESENTATION");						
							
							if(list_selection_attr != null && list_presentation_attr != null)
							{
								if(list_presentation_attr.getValue().equals("M") && list_selection_attr.getValue().equals("S"))
									radioSelection = true;
							}
							if(!discMsrVal.equals(""))
							{
								if(discMsrVal.lastIndexOf(",")!=-1)
								{				
									discMsrVal = discMsrVal.substring(0,discMsrVal.lastIndexOf(","));
								}
							}
							List<Element> childElements = element.elements();							
							for (Element childElement : childElements )
							{
								 if (childElement.getName().equals("MULTI-LIST-ROW"))
                                 {
									 List<Element> childElements1 = childElement.elements();
									 for (Element childElement1 : childElements1 )
									{
										 if (childElement1.getName().equals("MULTI-LIST-DATA"))
										 {								 
												Attribute selected_attr= childElement1.attribute("SELECTED");
												//Attribute name_attr= childElement1.attribute("NAME");//checkstyle
											
												if (selected_attr != null)									
													childElement1.remove(selected_attr);																		

												if(radioSelection)
												{													
													if(childElement1.getText().trim().equals(discMsrVal.trim()))
													{
														childElement1.addAttribute("SELECTED", "true") ;
														break;
													}																											
												}else{			
													if(childElement1.getText().trim().equals(discMsrVal.trim()))
													{
														childElement1.addAttribute("SELECTED", "true") ;
													}																													
												}										 
										 }
									}								 
								 }
							}						
					}				
				}			
			}
			if(pstmt!=null) pstmt.close();				          			
            displayString = convertString(m_XMLDocument,displayString);		
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		finally{
			try{			
				if (con != null)con.close();				
			}catch (Exception ee)	{		
				ee.printStackTrace();	
			}
		}		
		return displayString;
    }

// END PMG20089-CRF-0690

public StringBuffer updateXMLLanguageIDValues(StringBuffer XMLContent, String locale)
    {
		StringBuffer displayString = new StringBuffer();
		Document m_XMLDocument = null;
		StringBuffer sbXPathDefn =  new StringBuffer();			
			
        try
        {
			displayString.delete(0,displayString.length());														
			ArrayList<String> comp_list = new ArrayList<String>();			
			comp_list.add("DATE-TIME-NUMERIC");			
			comp_list.add("FORMULA-COMP");			
			comp_list.add("USER-TEMPLATE");
				
			SAXReader reader = new SAXReader();

			BufferedReader	br =	 new BufferedReader(new StringReader(XMLContent.toString()));
			m_XMLDocument = reader.read(br);							

			for (String compName :  comp_list)
			{
				sbXPathDefn.delete(0,sbXPathDefn.length());
				sbXPathDefn.append("//");
				sbXPathDefn.append(compName);
				List <Element> lsComps		=	m_XMLDocument.selectNodes(sbXPathDefn.toString());
				for (Element element : lsComps)
				{ 					
					//Attribute nameAttribute= element.attribute("NAME");//checkstyle
					if (element.getName().equals("USER-TEMPLATE"))
					{
						if (element.attribute("LANGID") != null)
						{
							element.attribute("LANGID").setValue(locale);
						}						
					}else if (element.getName().equals("DATE-TIME-NUMERIC") || element.getName().equals("FORMULA-COMP"))
					{
						Attribute othlangval_attr = element.attribute("OTHLANGVAL");						
						Attribute value_attr = element.attribute("VALUE");
						Attribute comptype_attr = element.attribute("COMPTYPE");	
												
						Attribute resulttype_attr		= null;
						String str_comptype	=	"";
						String str_resulttype	=	"";
						//String str_parm_value		=	"";//checkstyle
						String str_otherlang_val	=	"";

							if(comptype_attr != null)
								str_comptype	= comptype_attr.getValue();
														
							if(str_comptype.equals("A") )
							{
								resulttype_attr	= element.attribute("RESULTTYPE");
								str_resulttype = resulttype_attr.getValue();
							}
							if (value_attr != null && !(value_attr.getValue().equals("")))
							{
								//str_parm_value = value_attr.getValue(); //--[IN033507]
								if(locale.equals("en"))
								{
									str_otherlang_val = value_attr.getValue(); 
								}
								else
								{
									if(othlangval_attr!=null)//IN035406
										str_otherlang_val = othlangval_attr.getValue();//--[IN033507]
				
								/*	if(str_comptype.equals("D") ){ //Commentted --[IN033507]
									str_otherlang_val		= com.ehis.util.DateUtils.convertDate(str_parm_value,"DMY","en",locale);
								}else if(str_comptype.equals("E") ){
									str_otherlang_val		= com.ehis.util.DateUtils.convertDate(str_parm_value,"DMYHM","en",locale);
								}else if(str_comptype.equals("A") && str_resulttype.equals("D"))
								{									
									if(str_resulttype.length() > 10)
										str_otherlang_val = com.ehis.util.DateUtils.convertDate(str_parm_value,"DMYHM","en",locale);
									else
										str_otherlang_val = com.ehis.util.DateUtils.convertDate(str_parm_value,"DMY","en",locale);									
								}*/
								}		
								
									if(str_comptype.equals("D") || str_comptype.equals("E") || str_comptype.equals("A") )
									{										
										if(othlangval_attr == null)											
											element.addAttribute("OTHLANGVAL", str_otherlang_val) ;		
										else										
											othlangval_attr.setValue(str_otherlang_val);										
									} 
							}								
					}
				}										
			}			
			displayString = convertString(m_XMLDocument,displayString);			
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return displayString;
    }
	
	public StringBuffer removeEmptyValuesGridComp(StringBuffer XMLContent)
    {		
		StringBuffer displayString = new StringBuffer();
		try{
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = Factory.newDocumentBuilder();	
			org.w3c.dom.Document doc = builder.parse(new InputSource(new ByteArrayInputStream((XMLContent.toString()).getBytes("utf-8"))));
			//org.w3c.dom.Element rootNode = doc.getDocumentElement();commented for checkstyle
			XPathFactory factory = XPathFactory.newInstance();	    
			XPath xpath = factory.newXPath();	    
			XPathExpression expr = xpath.compile("//" + "GRID" + "/*");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			
			NodeList nodes = (NodeList) result;				
			int s=0;  // IN:047461
			for (int i = 0; i < nodes.getLength(); i++) {
				org.w3c.dom.Element el = (org.w3c.dom.Element) nodes.item(i);	
				//IN:047461 Start.
				int r=0;
				if("GRID-TH".equals(el.getNodeName())){
					s=0;
				}
				//IN:047461 End.
				if("GRID-ROW".equals(el.getNodeName())){	
					NodeList children = el.getChildNodes();					
					for (int k = 0; k < children.getLength(); k++) {
						org.w3c.dom.Node child = children.item(k);
						if (child.getNodeType() != org.w3c.dom.Node.TEXT_NODE) {
							NodeList children_ = child.getChildNodes();
							for (int j = 0; j < children_.getLength(); j++) {
								org.w3c.dom.Node child_ = children_.item(j);
								if (child_.getNodeType() != org.w3c.dom.Node.TEXT_NODE) {
									if("DATE-TIME-NUMERIC".equals(child_.getNodeName())){
										org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;											
										if(!"".equals(eElement.getAttribute("VALUE")))
											r++;
									}else if("SHORT-TEXT".equals(child_.getNodeName())){											 
										if(!"".equals(child_.getTextContent()))
											r++;
									}else if("CHECK-BOX".equals(child_.getNodeName())){
		                				 org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
		                				 if(!"".equals(eElement.getAttribute("VALUE")) && "Y".equals(eElement.getAttribute("VALUE")) )
		                					 r++;
		                			 }else if("LIST-BOX".equals(child_.getNodeName())){			                			 
			                			 NodeList children_temp = child_.getChildNodes();
			                			 for (int h = 0; h < children_temp.getLength(); h++) {
					                		 org.w3c.dom.Node child_temp = children_temp.item(h);
					                		 if("DATA".equals(child_temp.getNodeName())){
				                				 org.w3c.dom.Element eElement_temp = (org.w3c.dom.Element) child_temp;
					                			 if("true".equals(eElement_temp.getAttribute("SELECTED")))
					                				 r++;
					                		 }
			                			 }
		                			 }
									 
								}
							}								
						}
					}
					
				}
				//if("GRID-ROW".equals(el.getNodeName()) && r==0){ //Committed IN:047461
				if("GRID-ROW".equals(el.getNodeName()) && r==0 && s!=0){ // Added IN:047461
					(nodes.item(i)).getParentNode().removeChild(nodes.item(i));
				}
				// IN:047461 Start.
				if("GRID-ROW".equals(el.getNodeName()) && s==0 && r==0){
					s++;
				}
				// IN:047461 End.
			}
	    
			StringWriter stw = new StringWriter();
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
			serializer.transform(new DOMSource(doc), new StreamResult(stw));
			displayString.append(stw.toString());
		}catch (Exception e) {
			e.printStackTrace();			
        }
		return displayString;
	}
	//IN063799 starts	
	public StringBuffer displayGridCompYN(String display,String rows, StringBuffer XMLContent) {
		
		if(display.equals(" ") || display.equals("null")) display = "Y";
		StringBuffer displayString = new StringBuffer();
		int r = 0;
		
		try {
				
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = Factory.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(new InputSource(new ByteArrayInputStream((XMLContent.toString()).getBytes("utf-8"))));
		
			String disp_grid = "N";

			StringTokenizer st_rows = new StringTokenizer(rows, "|");

			int array_rows[] = new int[st_rows.countTokens()];
			int i = 0;

			while (st_rows.hasMoreTokens())
				array_rows[i++] = Integer.parseInt(st_rows.nextToken());

			eCA.DomErrorHandler errorHandler = new eCA.DomErrorHandler();
			builder.setErrorHandler(errorHandler);
			
			org.w3c.dom.Node grid_node = null;
			NodeList nodeList = doc.getElementsByTagName("GRID");
			int grid_node_length = nodeList.getLength();
		
			for (i = 0; i < grid_node_length; i++) 
			{
				grid_node = nodeList.item(i);		
				
				if(grid_node.getAttributes().getNamedItem("DISPLAYGRID")==null){
					org.w3c.dom.Element eg = (org.w3c.dom.Element)grid_node;
					eg.setAttribute("DISPLAYGRID","Y");
				}
				if(display.equals("N")){
						NodeList child_nodes = grid_node.getChildNodes();
						int child_nodes_length = child_nodes.getLength();

						r = 0;
						disp_grid="N";

				
					for (int j = 0; j < child_nodes_length; j++) {

						String dum = "";
						
						if (child_nodes.item(j) != null) {
							dum = child_nodes.item(j).getNodeName();
						}
						
						if ("GRID-ROW".equals(dum) && disp_grid.equals("N")) {						
							NodeList children = child_nodes.item(j).getChildNodes();
					
							for (int k = 0; k < children.getLength(); k++) {
								org.w3c.dom.Node child1 = children.item(k);

								if (child1.getNodeType() != org.w3c.dom.Node.TEXT_NODE) {
									NodeList children_ = child1.getChildNodes();
									
									for (int l = 0; l < children_.getLength(); l++) {
										org.w3c.dom.Node child_ = children_.item(l);

										if (child_.getNodeType() != org.w3c.dom.Node.TEXT_NODE) {
											if ("DATE-TIME-NUMERIC".equals(child_.getNodeName())) {
												org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
												if (!"".equals(eElement.getAttribute("VALUE")))
													r++;
											} else if ("SHORT-TEXT".equals(child_.getNodeName())) {
												if (!"".equals(child_.getTextContent()))
													r++;
											} else if ("CHECK-BOX".equals(child_.getNodeName())) {
												org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
												if (!"".equals(eElement.getAttribute("VALUE"))&& "Y".equals(eElement.getAttribute("VALUE")))
													r++;
											} else if ("LIST-BOX".equals(child_.getNodeName())) {
												NodeList children_temp = child_.getChildNodes();

													for (int h = 0; h < children_temp.getLength(); h++) {
														org.w3c.dom.Node child_temp = children_temp.item(h);

															if ("DATA".equals(child_temp.getNodeName())) {
																org.w3c.dom.Element eElement_temp = (org.w3c.dom.Element) child_temp;
																if ("true".equals(eElement_temp.getAttribute("SELECTED")))
																	r++;
															}
													}
													//IN071061, starts
													org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
													if (!"".equals(eElement.getAttribute("STD_COMP_ID"))){
														if(!"".equals(eElement.getAttribute("STD_COMP_VALUE"))){
															r++;
														}
													}
													//IN071061, ends
												}
										}
									}
								}
							}
						}
				
						if ("GRID-ROW".equals(child_nodes.item(j).getNodeName()))
							{
								//if (r == 0 && disp_grid.equals("N"))//IN071061
								if (r == 0 && display.equals("N"))//IN071061
									disp_grid = "N";
								else
									disp_grid = "Y";
							}
					}	
					
					grid_node.getAttributes().getNamedItem("DISPLAYGRID").setNodeValue(disp_grid);
				}	
			}	
				StringWriter stw = new StringWriter();
				Transformer serializer = TransformerFactory.newInstance().newTransformer();
				serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
				serializer.transform(new DOMSource(doc), new StreamResult(stw));
				displayString.append(stw.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return displayString;
	}

public StringBuffer displayMatrixCompYN(String display,StringBuffer XMLContent) {
		
		if(display.equals(" ") || display.equals("null")) display = "Y";
		StringBuffer displayString = new StringBuffer();
		int r = 0;
		try {

			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = Factory.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(new InputSource(new ByteArrayInputStream((XMLContent.toString()).getBytes("utf-8"))));
			
			String disp_matrix = "N";
			
			int i = 0;

			org.w3c.dom.Node matrix_node = null;
			NodeList nodeList = doc.getElementsByTagName("MATRIX");	
			
			int matrix_node_length = nodeList.getLength();
			
			for (i = 0; i < matrix_node_length; i++) 
			{
				matrix_node = nodeList.item(i);
				if(matrix_node.getAttributes().getNamedItem("DISPLAYMATRIX")==null){
					org.w3c.dom.Element em = (org.w3c.dom.Element)matrix_node;
					em.setAttribute("DISPLAYMATRIX","Y");
				}
				
				if(display.equals("N")){
					NodeList child_nodes = matrix_node.getChildNodes();
					int child_nodes_length = child_nodes.getLength();
				
					r = 0;
					disp_matrix="N";

					for (int j = 0; j < child_nodes_length; j++) {

						String dum = "";
						if (child_nodes.item(j) != null) {
							dum = child_nodes.item(j).getNodeName();
						}
						
						if ("MATRIX-ROW".equals(dum) && disp_matrix.equals("N")) {						
							NodeList children = child_nodes.item(j).getChildNodes();
					
							for (int k = 0; k < children.getLength(); k++) {
								org.w3c.dom.Node child1 = children.item(k);

								if (child1.getNodeType() != org.w3c.dom.Node.TEXT_NODE) {
									NodeList children_ = child1.getChildNodes();
									
									for (int l = 0; l < children_.getLength(); l++) {
										org.w3c.dom.Node child_ = children_.item(l);

											if (child_.getNodeType() != org.w3c.dom.Node.TEXT_NODE) {
												if ("DATE-TIME-NUMERIC".equals(child_.getNodeName())) {
													org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
													if (!"".equals(eElement.getAttribute("VALUE")))
														r++;
												} else if ("SHORT-TEXT".equals(child_.getNodeName())) {
													if (!"".equals(child_.getTextContent()))
														r++;
												} else if ("CHECK-BOX".equals(child_.getNodeName())) {
													org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
													if (!"".equals(eElement.getAttribute("VALUE"))&& "Y".equals(eElement.getAttribute("VALUE")))
														r++;
												} else if ("LIST-BOX".equals(child_.getNodeName())) {
													NodeList children_temp = child_.getChildNodes();

														for (int h = 0; h < children_temp.getLength(); h++) {
															org.w3c.dom.Node child_temp = children_temp.item(h);

															if ("DATA".equals(child_temp.getNodeName())) {
																org.w3c.dom.Element eElement_temp = (org.w3c.dom.Element) child_temp;
																if ("true".equals(eElement_temp.getAttribute("SELECTED")))
																	r++;
															}
													}
													//IN071061, starts
													org.w3c.dom.Element eElement = (org.w3c.dom.Element) child_;
													if (!"".equals(eElement.getAttribute("STD_COMP_ID"))){
														if(!"".equals(eElement.getAttribute("STD_COMP_VALUE"))){
															r++;
														}
													}
													//IN071061, ends
												}
										}
									}
								}
							}
						}
				
						if ("MATRIX-ROW".equals(child_nodes.item(j).getNodeName()))
							{
								//if (r == 0 && disp_matrix.equals("N"))//IN071061
								if (r == 0 && display.equals("N"))//IN071061
									disp_matrix = "N";
								else
									disp_matrix = "Y";
							}
					}					
					matrix_node.getAttributes().getNamedItem("DISPLAYMATRIX").setNodeValue(disp_matrix);
				}	
			}
				StringWriter stw = new StringWriter();
				Transformer serializer = TransformerFactory.newInstance().newTransformer();
				serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
				serializer.transform(new DOMSource(doc), new StreamResult(stw));
				displayString.append(stw.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return displayString;
	}
// IN063799 ends
}	
