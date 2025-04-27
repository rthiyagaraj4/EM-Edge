/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.xml.sax.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TemplatePromtRepParser  
{

/*	public TemplatePromtRepParser(Connection cnIn,StringBuffer strXMLContentIn)
	{
		cnParser = cnIn;
		sbPromptReplXML 	= new StringBuffer();
		//curr_sec_hdg_code	=	strSecHdgCodeIn;
		//sex	= sexIn;
		//dob = dobIn;

		
			try
			{
				StringReader strTemp = new StringReader(strXMLContentIn.toString());
				InputSource isTemp = new InputSource(strTemp);

				this.m_XMLDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(isTemp);
			}
			catch (Exception eConv)
			{
				eConv.printStackTrace();
			}	
		
		
	
	} //end of constructor */

 StringBuffer displayString = new StringBuffer();


public StringBuffer changePromptValuesForComps(StringBuffer XMLContent, Hashtable htParameters,String locale)
{

	try
        {
									
			displayString.delete(0,displayString.length());

			String tags[] = { "SHORT-TEXT", "LONG-TEXT", "SHORT-TEXT-WTD",
                    "LONG-TEXT-WTD", "TEXT", "DATE-TIME-NUMERIC",
                     "DATE-TIME-NUMERIC-WTD" };
	
					StringReader strTemp = new StringReader(XMLContent.toString());
					InputSource isTemp = new InputSource(strTemp);

//			Document doc  = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(XMLContent.toString().getBytes()));
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(isTemp);
            
			Enumeration keysForHashtable = htParameters.keys();
            
			NodeList nl = null;

			for (int j = 0; j < 4; j++)
            {  
                nl = doc.getElementsByTagName(tags[j]);

                if (nl != null)
                {
                    for (int i = 0; i < nl.getLength(); i++)
                    {
                        Node n = nl.item(i);
                        NamedNodeMap nnm = n.getAttributes();
                        Node nodeName = nnm.getNamedItem("DISCRID");
                        Node nodeName_prompt = nnm.getNamedItem("PROMPT");


                        NodeList nl1 = n.getChildNodes();
                        Node newTextNode = null;
						String compName = "";
                        
						while (keysForHashtable.hasMoreElements())
                        {
                            compName = (String) keysForHashtable.nextElement();


							/*if (nodeName.getNodeValue().equals(compName))
							{
                                newTextNode = doc.createTextNode((String) htParameters.get(compName));
								break;
							}*/
							//if (nodeName.getNodeValue().equals("V$NT_TYPE"))
							if (nodeName.getNodeValue().equals(compName))
							{
                               
							   nodeName_prompt.setNodeValue((String) htParameters.get(compName));
							    
								break;
							}
                        }

						if (newTextNode != null)
                        {
                            Node textNode = nl1.item(0);
                            Node textNodeLast = nl1.item(nl1.getLength() - 1);

							if (textNode != null && textNode.getNodeType() == Node.TEXT_NODE)
                                n.replaceChild(newTextNode, textNode);
                            else if (textNodeLast != null&& textNodeLast.getNodeType() == Node.TEXT_NODE)
                                n.replaceChild(newTextNode, textNodeLast);
                            else
                                n.appendChild(newTextNode);
                        }
						
						keysForHashtable = htParameters.keys();
                    }
                }
            }
            
			for (int j = 4; j < tags.length; j++)
          {
                nl = doc.getElementsByTagName(tags[j]);

                if (nl != null)
                {
                    for (int i = 0; i < nl.getLength(); i++)
                    {

                        Node n = nl.item(i);
                        NamedNodeMap nnm = n.getAttributes();
                        Node nodeName = nnm.getNamedItem("DISCRID");
						 Node nodeName_prompt = nnm.getNamedItem("PROMPT");


                        if (tags[j].equals("LIST-BOX") || tags[j].equals("LIST-BOX-WTD"))
                        {
                            NodeList nodeList = n.getChildNodes();
                            NamedNodeMap node_stdComponent = n.getAttributes();
                            Node stdComponentNode = node_stdComponent.getNamedItem("STD_COMP_RESULT_TYPE");
                            
							if(stdComponentNode != null && !stdComponentNode.getNodeValue().equals(""))
                            {
                                NamedNodeMap nnm_std_ComponentValue = n.getAttributes();
                                Node std_ComponentValue = nnm_std_ComponentValue.getNamedItem("STD_COMP_VALUE");
                                
								while (keysForHashtable.hasMoreElements())
                                {
                                    String compName = (String) keysForHashtable.nextElement();
                                    
									if (nodeName.getNodeValue().equals(compName))
                                    {
                                        String value = (String) htParameters.get(compName);
                                        std_ComponentValue.setNodeValue(value);
                                        break;
                                    }
                                }
                                
								keysForHashtable = htParameters.keys();
                            }
                            else
                            {
                                for (int ii = 0; ii < nodeList.getLength(); ii++)
                                {
                                    Node dataNode = nodeList.item(ii);

                                    if (dataNode.getNodeName().equals("DATA"))
                                    {
                                        NamedNodeMap nnmData = dataNode.getAttributes();
                                        Node nodeListItemIDData = nnmData.getNamedItem("LIST_ITEM_ID");
                                        Node nodeValueData = nnmData.getNamedItem("SCORE");

                                        if(nodeListItemIDData == null)
                                        {
                                            if(nodeValueData != null)
                                                nodeListItemIDData = nodeValueData;
                                            else
                                                nodeListItemIDData = nnmData.getNamedItem("VALUE");
                                        }

                                        Node nodeSelectedData = nnmData.getNamedItem("SELECTED");

										if (nodeSelectedData != null)
                                        {
                                            nnmData.removeNamedItem("SELECTED");
                                        }
                                        while (keysForHashtable.hasMoreElements())
                                        {
                                            String compName = (String) keysForHashtable.nextElement();
                                            
											if (nodeName.getNodeValue().equals(compName))
                                            {
                                                String value = (String) htParameters.get(compName);
                                                
												if (nodeListItemIDData.getNodeValue().equals(value))
                                                {
                                                    Attr attr = doc.createAttribute("SELECTED");
                                                    nodeSelectedData = attr;
                                                    nodeSelectedData.setNodeValue("true");
                                                    nnmData.setNamedItem(nodeSelectedData);
                                                    break;
                                                }
                                            }
                                        }
                                        
										keysForHashtable = htParameters.keys();
                                    }
                                }
                            }
                        }
                        else if (tags[j].equals("MULTI-LIST"))
                        {

							boolean radioSelection = false;							
							Node listSelection = nnm.getNamedItem("LIST_SELECTION");
							Node listPresentation = nnm.getNamedItem("LIST_PRESENTATION");
							
							if(listSelection != null && listPresentation != null)
							{
								if(listPresentation.getNodeValue().equals("M") && listSelection.getNodeValue().equals("S"))
									radioSelection = true;
							}
							
							NodeList nodeList = n.getChildNodes();
							
							for (int ii = 0; ii < nodeList.getLength(); ii++)
							{
								Node multiListRowNode = nodeList.item(ii);
								
								if (multiListRowNode.getNodeName().equals("MULTI-LIST-ROW"))
								{
									NodeList multiListDataNodeList = multiListRowNode.getChildNodes();
									
									for (int jj = 0; jj < multiListDataNodeList.getLength(); jj++)
									{
										Node dataNode = multiListDataNodeList.item(jj);
										
										if (dataNode.getNodeName().equals("MULTI-LIST-DATA"))
										{
											NamedNodeMap nnmData = dataNode.getAttributes();
											Node nodeSelectedData = nnmData.getNamedItem("SELECTED");
											Node multiListDataName = nnmData.getNamedItem("NAME");

											if (nodeSelectedData != null)
												nnmData.removeNamedItem("SELECTED");

											if(radioSelection)
											{
												while (keysForHashtable.hasMoreElements())
												{
													String compName = (String) keysForHashtable.nextElement();																			
													
													if (nodeName.getNodeValue().equals(compName))
													{
														String value = (String) htParameters.get(compName);
														
														if (multiListDataName.getNodeValue().equals(value))
														{
															Attr attr = doc.createAttribute("SELECTED");
															nodeSelectedData = attr;
															nodeSelectedData.setNodeValue("true");
															nnmData.setNamedItem(nodeSelectedData);
															break;
														}
													}
												}
												
												keysForHashtable = htParameters.keys();
											}
											else
											{
												while (keysForHashtable.hasMoreElements())
												{
													String compName = (String) keysForHashtable.nextElement();

													if (multiListDataName.getNodeValue().equals(compName))
													{
														Attr attr = doc.createAttribute("SELECTED");
														nodeSelectedData = attr;
														nodeSelectedData.setNodeValue("true");
														nnmData.setNamedItem(nodeSelectedData);
													}
												}
												
												keysForHashtable = htParameters.keys();
											}
										}
									}
								}
							}
                        }
                        else
                        {
							Node ndOthLangVal	= nnm.getNamedItem("OTHLANGVAL");
							Node nodeValue		= nnm.getNamedItem("VALUE");
							Node nodeCompTy		= nnm.getNamedItem("COMPTYPE");
							Node ndResultTy		= null;

							String strCompType	=	"";
							String strResultTy	=	"";

							if(nodeCompTy != null)
								strCompType	= nodeCompTy.getNodeValue();

							if(strCompType.equals("A") )
							{
								ndResultTy	= nnm.getNamedItem("RESULTTYPE");
								strResultTy = ndResultTy.getNodeValue();
							}

							String strParmValue		=	"";
							String strOthLangVal	=	"";

							if(tags[j].equals("DATE-TIME-NUMERIC"))
                            {
                                Node numPrefixNode = nnm.getNamedItem("NUM_PREFIX_REQUIRED_YN");
                                
								if( numPrefixNode != null)
                                {
                                    if(numPrefixNode.getNodeValue().equals("Y"))
                                    {                                        
                                        while (keysForHashtable.hasMoreElements())
                                        {
                                            String compName = (String) keysForHashtable.nextElement();                                            
                                            
											if((nodeName.getNodeValue() + "_number_prefix").equals(compName))
                                            {
                                                Node numPrefixValue = nnm.getNamedItem("PREFIX_CHAR");
                                                numPrefixValue.setNodeValue((String) htParameters.get(compName));
                                            }
                                        }
                                        
										keysForHashtable = htParameters.keys();
                                    }
                                }
                            }

//                            boolean flag = false;
							
							//	for Setting the value in Other Lang (Only for Date and DateTime componens)												

							if(strCompType.equals("D") || strCompType.equals("E") || strCompType.equals("A") )
							{
								if(ndOthLangVal == null)
								{
									Attr attr1 = doc.createAttribute("OTHLANGVAL");
									ndOthLangVal = attr1;
								}
								else
									ndOthLangVal.setNodeValue("");
							}
							
							// for Setting the value in English														
							if (nodeValue == null)
                            {
                                Attr attr = doc.createAttribute("VALUE");
                                nodeValue = attr;
  //                              flag = true;
                            }
                            else
                                nodeValue.setNodeValue("");
                            
							while (keysForHashtable.hasMoreElements())
                            {
                                String compName = (String) keysForHashtable.nextElement();
								
								if (nodeName.getNodeValue().equals(compName))
                                {
									strParmValue	= (String) htParameters.get(compName);
									strOthLangVal	= strParmValue;

								/*	if(strCompType.equals("D") )
										strParmValue		= com.ehis.util.DateUtils.convertDate(strParmValue,"DMY",locale,"en");
									else if(strCompType.equals("E") )
										strParmValue		= com.ehis.util.DateUtils.convertDate(strParmValue,"DMYHM",locale,"en");
									else if(strCompType.equals("A") )
									{
										if(strResultTy.equals("D") )
										{
											if(strParmValue.length() > 10)
												strParmValue = com.ehis.util.DateUtils.convertDate(strParmValue,"DMYHM",locale,"en");
											else
												strParmValue = com.ehis.util.DateUtils.convertDate(strParmValue,"DMY",locale,"en");
										}
									}
									*/
									//nodeValue.setNodeValue(strParmValue);
									nodeName_prompt.setNodeValue((String) htParameters.get(compName));

									if(strCompType.equals("D") || strCompType.equals("E") || strCompType.equals("A") )
									{
										ndOthLangVal.setNodeValue(strOthLangVal);
										nnm.setNamedItem(ndOthLangVal);
									}
                            
//d									if (flag)
                                        nnm.setNamedItem(nodeValue);
                                }
                            }
                            
							keysForHashtable = htParameters.keys();
                        }
                    }

                }//end of if(nl!=null)
            }//end of for(int j=0;j<tags.length;j++) 

            display(doc);
			htParameters.clear();


        }
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return displayString;
		
	
	
	
	
} //end  changePromptValuesForComps








public void display(Node node)
    {
        if (node == null)
        {
            return;
        }
        int type = node.getNodeType();
        switch (type)
        {
            case Node.DOCUMENT_NODE:
            {
                displayString.append("");
                display(((Document) node).getDocumentElement());
                break;
            }
            case Node.ELEMENT_NODE:
            {
                displayString.append("<");
                displayString.append(node.getNodeName());
                int length = (node.getAttributes() != null) ? node.getAttributes().getLength() : 0;
                Attr attributes[] = new Attr[length];
                for (int loopIndex = 0; loopIndex < length; loopIndex++)
                {
                    attributes[loopIndex] = (Attr) node.getAttributes().item(loopIndex);
                }
                for (int loopIndex = 0; loopIndex < attributes.length; loopIndex++)
                {
                    Attr attribute = attributes[loopIndex];
                    displayString.append(" ");
                    displayString.append(attribute.getNodeName());
                    displayString.append("=\"");
                    displayString.append(replaceSpecialChars(attribute.getNodeValue()));
                    displayString.append("\"");
                }
                displayString.append(">");

                NodeList childNodes = node.getChildNodes();
                if (childNodes != null)
                {
                    length = childNodes.getLength();
                    for (int loopIndex = 0; loopIndex < length; loopIndex++)
                    {
                        display(childNodes.item(loopIndex));
                    }
                }
                break;
            }

            case Node.CDATA_SECTION_NODE:
            {
                displayString.append("<![CDATA[");
                displayString.append(node.getNodeValue());
                displayString.append("]]>");
            }
            case Node.TEXT_NODE:
            {
                String newText = replaceSpecialChars(node.getNodeValue());
                if (newText.length() > 0) {
                    displayString.append(newText);
                }
                break;
            }
            case Node.PROCESSING_INSTRUCTION_NODE:
            {
                displayString.append("<?");
                displayString.append(node.getNodeName());
                String text = node.getNodeValue();
                if (text != null && text.length() > 0)
                {
                    displayString.append(text);
                }
                displayString.append("?>");
                break;
            }
        }
        if (type == Node.ELEMENT_NODE)
        {
            displayString.append("</");
            displayString.append(node.getNodeName());
            displayString.append(">");
        }
    } 

    private String replaceSpecialChars(String input)
    {
        if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&#60;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&#62;");	
		if (input.indexOf("\\n") != -1) input = input.replaceAll("\\n","&lt;br&gt;");	

        return input;
    }




}// end of class
