/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
//import org.apache.xerces.parsers.*;
//import org.apache.xerces.xni.parser.XMLInputSource;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;
import java.util.*;
public class ParagraphDomParser implements java.io.Serializable 
{
	StringBuffer displayString=new StringBuffer();
	public ParagraphDomParser(){}	 
	public StringBuffer updateXMLParaCompNames(StringBuffer XMLContent,int srlNo,String compId,int paraNo) 
	{
		
		try
		{
			String tags[]={"PARAGRAPH","SHORT-TEXT-WTD","LONG-TEXT-WTD","DATE-TIME-NUMERIC-WTD","LIST-BOX-WTD","CHECK-BOX-WTD","CALANDER","HIDDEN-FIELD"};
			Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(XMLContent.toString().getBytes()));
			NodeList nl=null;
			Node n = null,nodeName=null,nodeValue=null,temp_nodeName=null;
			NamedNodeMap nnm = null;
			//for introducing NAME attribute in the PARAGRAPH element
			nl=doc.getElementsByTagName(tags[0]);
			if(nl!=null)
			{
				n= nl.item(0);
				Attr attr=doc.createAttribute("NAME");
				nodeName=attr;
				nodeName.setNodeValue(compId+srlNo);
				nnm=n.getAttributes();
				nnm.setNamedItem(nodeName);				
			}
			//-------------------------------------------------------
			for(int j=1;j<tags.length-1;j++)
			{
				nl=doc.getElementsByTagName(tags[j]);
				if(nl!=null)
				{
					for(int i=0;i<nl.getLength();i++)
					{
						n= nl.item(i);
						nnm=n.getAttributes();
						nodeName=nnm.getNamedItem("NAME");
						nodeName.setNodeValue(nodeName.getNodeValue()+compId+srlNo);
						temp_nodeName=nodeName;
					}
				}
			}
			//for HIDDEN-FIELD tag taken for mendatory fields checking
			nl=doc.getElementsByTagName(tags[tags.length-1]);
			if(nl!=null)
			{
				for(int i=0;i<nl.getLength();i++)
				{
					n= nl.item(i);
					nnm=n.getAttributes();
					nodeName=nnm.getNamedItem("NAME");
					//if(i<2)
					//{
					//nodeName.setNodeValue(temp_nodeName.getNodeValue()+"_desc");

					//}
					if(nodeName.getNodeValue().indexOf("_desc")!= -1)
					{
						nodeName.setNodeValue(nodeName.getNodeValue().substring(0,nodeName.getNodeValue().indexOf("_desc"))+compId+srlNo+"_desc");
//						nodeName.setNodeValue(temp_nodeName.getNodeValue()+"_desc");
					}
					if(nodeName.getNodeValue().equals("mandatory_fields_para"))
					{
						nodeValue = nnm.getNamedItem("VALUE");
						nodeName.setNodeValue(nodeName.getNodeValue()+paraNo);
						if(!nodeValue.getNodeValue().equals(""))
						{
							nodeValue.setNodeValue(nodeValue.getNodeValue()+"~"+compId+srlNo);			
						}
					}
					if(nodeName.getNodeValue().substring(0,7).equals("min_max"))
					{
						nodeName.setNodeValue(nodeName.getNodeValue()+compId+srlNo);
					}
					if(nodeName.getNodeValue().equals("para_std_component_information"))
					{
						nodeName.setNodeValue(nodeName.getNodeValue()+compId+srlNo);
						
					}
					
				}
			}
			nl=null;
			n = null;nodeName=null;nodeValue=null;
			nnm = null;
			display(doc);		

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return displayString;

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
	private static String replaceSpecialChars(String input)
	{
		if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");	
		if (input.indexOf("\n") != -1) input = input.replaceAll("\n","&lt;br&gt;");	

	
	/*	StringBuffer temp=null;
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
		
		while(input.indexOf("\n")!=-1)
		{	
			int ii=input.indexOf("\n");
			temp=new StringBuffer(input);
			temp.replace(ii,ii+2,"&lt;br&gt;");
			input=temp.toString();
		}
*/

		return input;
	}
}
