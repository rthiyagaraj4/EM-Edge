/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
 * GridComponent.java
 *
 * Created on February 8, 2005, 9:57 AM
 * @author arvindk
 */
package eCA;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
import java.util.*;
import org.xml.sax.*;

public class GridComponent
{
    StringBuffer displayString = new StringBuffer();

    public GridComponent()
    {
    }
    public StringBuffer updateXML(String rows, String strXML)
    {
        try
        {
            StringTokenizer st_rows = new StringTokenizer(rows, "|" );
			StringReader srTemp = new StringReader(strXML);
			InputSource isTemp = new InputSource(srTemp);

            int array_rows[] = new int[st_rows.countTokens()];
            int i=0;
            while(st_rows.hasMoreTokens())
                array_rows[i++] = Integer.parseInt(st_rows.nextToken());
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
			eCA.DomErrorHandler errorHandler = new eCA.DomErrorHandler();
            builder.setErrorHandler(errorHandler);
            Document document = builder.parse(isTemp);
            Node grid_node = null;
            NodeList nodeList = document.getElementsByTagName("GRID");
            int grid_node_length = nodeList.getLength();

			for(i=0;i<grid_node_length;i++)
            {
                grid_node = nodeList.item(i);
                NodeList child_nodes = grid_node.getChildNodes();
                int child_nodes_length = child_nodes.getLength();
                //IN007297 changes starts
                int s=1;
                int count=1;
                
                for (int j = 0; j < child_nodes_length; j++)
                {
                	org.w3c.dom.Node child= child_nodes.item(j);
					
                	if(s>1)
                    {
							grid_node.removeChild(child_nodes.item(count));
                    }
					
					if(s==1)
                    {
						if(child.getNodeName().equals("GRID-ROW")){
							s++;
							count=j+1;
						}
                    }
                }
				/*if(child_nodes_length > 5 )
				{
					for(int counter=5;counter < child_nodes_length ; counter++)
					{

						grid_node.removeChild(child_nodes.item(5));
					}
				}*/
                //IN007297 Changes ends
            }

			for(i=0;i<grid_node_length;i++)
            {
                grid_node = nodeList.item(i);
                NodeList child_nodes = grid_node.getChildNodes();
                int child_nodes_length = child_nodes.getLength();



				for(int j=0;j<child_nodes_length;j++)
                {
                    Node grid_row_node = child_nodes.item(j);

					if(grid_row_node.getNodeName().equals("GRID-ROW"))
                    {

						for(int k=0;k<array_rows[i]-1;k++)
                        {
                            Node temp_node = grid_row_node.cloneNode(true);
                            NamedNodeMap namedNodeMap = temp_node.getAttributes();
                            Node nodeRowIndex = namedNodeMap.getNamedItem("ROWINDEX");
                            nodeRowIndex.setNodeValue("" + (k+2));
                            grid_node.appendChild(temp_node);

                        }
                    }
                }

				changeIDSGridRow(grid_node);
            }

			displayString = new StringBuffer();
            display(document);
        }
        catch(SAXException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }
        return displayString;
    }
    public void changeIDSGridRow(Node grid_node)
    {
        int grid_row_index	= 0;
        int name_index		= 0;

		NodeList grid_child_nodeList = grid_node.getChildNodes();
        int grid_child_nodeList_length = grid_child_nodeList.getLength();
        String component_name_array[] = null;

        // Looping thru the Grid Nodes child components
		for(int i=0;i<grid_child_nodeList_length;i++)
        {
            Node grid_row_child_node = grid_child_nodeList.item(i);

			if(grid_row_child_node.getNodeName().equals("GRID-ROW"))
            {
                grid_row_index++;
                NodeList grid_col_nodeList = grid_row_child_node.getChildNodes();
                int grid_col_nodes_childlist_length = grid_col_nodeList.getLength();

				if(grid_row_index == 1)
                {
                    component_name_array = new String[grid_col_nodes_childlist_length];

                }

				// Looping thru the GRID-COL nodes of a GRID-ROW component
				for(int j=0;j<grid_col_nodes_childlist_length;j++)
                {
                    Node grid_col_node = grid_col_nodeList.item(j);
                    NodeList component_nodeList = grid_col_node.getChildNodes();
                    int component_nodeList_length = component_nodeList.getLength();



					// Looping thru the Individual GRID-COL node
					for(int k=0;k<component_nodeList_length;k++)
                    {
                        Node component_node = component_nodeList.item(k);
                        String tag_Name		= component_node.getNodeName();



						if(!tag_Name.equals("EMPTY-COLUMN") && component_node.getNodeType() != 3 )
						{
							NamedNodeMap namedNodeMap = component_node.getAttributes();
							Node componentName = namedNodeMap.getNamedItem("NAME");

							if(grid_row_index == 1)
							{
								component_name_array[j] = componentName.getNodeValue();

							}
							else
							{
								componentName.setNodeValue(component_name_array[j]+(9999+name_index));
								if(tag_Name.equals("DATE-TIME-NUMERIC"))
								{
									NodeList date_time_numeric_children = component_node.getChildNodes();
									int date_time_numeric_children_length = date_time_numeric_children.getLength();
									for(int l=0;l<date_time_numeric_children_length;l++)
									{
										Node date_time_numeric_calender = date_time_numeric_children.item(l);
										if(date_time_numeric_calender.getNodeName().equals("CALANDER"))
										{
											NamedNodeMap calender_field_attr = date_time_numeric_calender.getAttributes();
											Node hidden_field_name = calender_field_attr.getNamedItem("NAME");
											hidden_field_name.setNodeValue(component_name_array[j]+(9999+name_index));
										}
										else if(date_time_numeric_calender.getNodeName().equals("HIDDEN-FIELD"))
										{
											NamedNodeMap hidden_field_attr = date_time_numeric_calender.getAttributes();
											Node hidden_field_name = hidden_field_attr.getNamedItem("NAME");
											hidden_field_name.setNodeValue("min_max" + component_name_array[j]+(9999+name_index));
										}
									}
								}
								if(tag_Name.equals("LIST-BOX"))
								{
									NodeList list_box_children = component_node.getChildNodes();
									int list_box_children_length = list_box_children.getLength();
									for(int l=0;l<list_box_children_length;l++)
									{
										Node list_box_hidden_field = list_box_children.item(l);
										if(list_box_hidden_field.getNodeName().equals("HIDDEN-FIELD"))
										{
											
											NamedNodeMap hidden_field_attr = list_box_hidden_field.getAttributes();
											Node hidden_field_name = hidden_field_attr.getNamedItem("NAME");
											hidden_field_name.setNodeValue(component_name_array[j]+(9999+name_index)+"_desc");
											
										}
									}
								}
							}
						}
                    }
                }
                if(grid_row_index != 1)
                    name_index++;
            }
        }
    }
    public void display(Node node)
    {
        if(node==null)
        {
            return;
        }
        int type=node.getNodeType();
        switch(type)
        {
            case Node.DOCUMENT_NODE:
            {
                displayString.append("");
                display(((Document)node).getDocumentElement());
                break;
            }
            case Node.ELEMENT_NODE:
            {
                displayString.append("<");
                displayString.append(node.getNodeName());
                int length =(node.getAttributes()!=null)?node.getAttributes().getLength():0;
                Attr attributes[]=new Attr[length];
                for(int loopIndex=0;loopIndex<length;loopIndex++)
                {
                    attributes[loopIndex]=(Attr)node.getAttributes().item(loopIndex);
                }
                for(int loopIndex=0;loopIndex<attributes.length;loopIndex++)
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
                if(childNodes!=null)
                {
                    length=childNodes.getLength();
                    for(int loopIndex=0;loopIndex<length;loopIndex++)
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
                String newText=replaceSpecialChars(node.getNodeValue());
                if(newText.length()>0)
                {
                    displayString.append(newText);
                }
                break;
            }
            case Node.PROCESSING_INSTRUCTION_NODE:
            {
                displayString.append("<?");
                displayString.append(node.getNodeName());
                String text = node.getNodeValue();
                if(text!=null && text.length()>0)
                {
                    displayString.append(text);
                }
                displayString.append("?>");
                break;
            }
        }
        if(type==Node.ELEMENT_NODE)
        {
            displayString.append("</");
            displayString.append(node.getNodeName());
            displayString.append(">");
        }
    }
    private String replaceSpecialChars(String input)
    {

		if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");

        /*StringBuffer temp=null;
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
		*/

		/*
		StringBuffer temp=null;

        int ii=input.indexOf("\n");

		while(ii!=-1)
        {
            temp=new StringBuffer(input);
            temp.replace(ii,ii+1,"&lt;br&gt;");
			input = temp.toString();

			ii=input.indexOf("\n");
        }
        */

        //Changed to the following 07/04/2006
        if(input.indexOf("\\n") != -1)input = input.replaceAll("\\n","&lt;br&gt;");

		return input;
    }
}
