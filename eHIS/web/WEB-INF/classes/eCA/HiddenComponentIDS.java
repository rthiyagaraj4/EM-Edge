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
import java.io.IOException;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
public class HiddenComponentIDS
{
    public HiddenComponentIDS()
    {
    }
    public String getHiddenComponentIDS(String componentXMLDefinition, String tagName, String hiddenFieldValue)
    {
        String returnValue = "";
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
			eCA.DomErrorHandler errorHandler = new eCA.DomErrorHandler();
            builder.setErrorHandler(errorHandler);
            Document document = builder.parse(new ByteArrayInputStream(componentXMLDefinition.getBytes()));
            NodeList nodeList = document.getElementsByTagName(tagName);
            for(int index=0;index<nodeList.getLength();index++)
            {
                Node node = nodeList.item(index);
                NamedNodeMap nnm = node.getAttributes();
                Node hidden_field_name = nnm.getNamedItem("NAME");
                String grid_comp_ids = hidden_field_name.getNodeValue();

				

                if(!hiddenFieldValue.equals("") && grid_comp_ids.indexOf(hiddenFieldValue) != -1)
                {
					String gridMemberCompIds = nnm.getNamedItem("VALUE").getNodeValue();
                    returnValue = gridMemberCompIds;
                    break;
                }
				else if(hiddenFieldValue.equals(""))
				{
					returnValue = hidden_field_name.getNodeValue();
					break;
				}
            }
        }
        catch(FactoryConfigurationError fce)
        {
            fce.printStackTrace();            
        }
        catch(ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch(DOMException d)
        {
            d.printStackTrace();
        }
        catch(SAXException sae)
        {
            sae.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
}
