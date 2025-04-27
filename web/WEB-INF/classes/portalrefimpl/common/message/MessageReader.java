/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package portalrefimpl.common.message;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author gramamoorthy
 *
 */
public class MessageReader {

	private static String REFMESSAGES_FILENAME = "./PortalRefMessages.xml";
	
	/**
	 * 
	 * @return
	 */
	public static Map<String, Module> getMessages(){
		Map<String, Module> moduleMessagesMap = new HashMap<String, Module>();
		
		Document document = getMessageFileContents();
		String rootElement = document.getDocumentElement().getNodeName();
		
		if(MessageConstants.MODULES_KEY.equals(rootElement)){
			NodeList moduleNodes = document
					.getElementsByTagName(MessageConstants.MODULE_KEY);
			
			int modulesLength = moduleNodes != null?moduleNodes.getLength():0;
			
			Module module = null;
			Node moduleNode = null;
			String moduleName = "";
			// iterate through the different modules
			for(int moduleCnt = 0;moduleCnt<modulesLength;moduleCnt++){
				moduleNode = moduleNodes.item(moduleCnt);
				module = readModule(moduleNode);
				
				if(module == null){
					continue;	
				}
				
				moduleName = module.getModuleName();
				moduleMessagesMap.put(moduleName, module);
			}
			
		}
		
		return moduleMessagesMap;
	}
	
	/**
	 * 
	 * @param moduleNode
	 * @return
	 */
	private static Module readModule(Node moduleNode){
		Module module = null;
		
		Element moduleElement = null;
		String moduleName = null;
		if(moduleNode.getNodeType() == Node.ELEMENT_NODE){
			moduleElement = (Element)moduleNode;
			NodeList moduleNameNodeList = moduleElement
					.getElementsByTagName(MessageConstants.MODULE_NAME_KEY);
			
			if(moduleNameNodeList == null){
				return module;
			}
			
			Element moduleNameElement = (Element)moduleNameNodeList.item(0);
			NodeList moduleNameChildNodeList = moduleNameElement.getChildNodes();
			if(moduleNameChildNodeList != null){
				moduleName = ((Node)moduleNameChildNodeList.item(0)).getNodeValue().trim();
				//System.out.println(moduleName);
			}
			
			if(moduleName == null){
				return module;
			}
			// initialize the module
			module = new Module();
			module.setModuleName(moduleName);
			
			// now get the messages part of the module
			NodeList moduleMessagesNodeList = moduleElement
					.getElementsByTagName(MessageConstants.MESSAGES_KEY);
			if(moduleMessagesNodeList == null){
				module = null;
				return module;
			}
			
			List<Message> messageList = readMessages(moduleMessagesNodeList);
			if(messageList == null || messageList.isEmpty()){
				module = null;
				return module;
			}
			
			module.setMessageList(messageList);
		}
		
		
		return module;
	}
	
	/**
	 * 
	 * @param moduleMessagesNodeList
	 * @return
	 */
	private static List<Message> readMessages(NodeList moduleMessagesNodeList){
		List<Message> messageList = new ArrayList<Message>();
		int messagesNodeLength = moduleMessagesNodeList.getLength();
		//System.out.println("Messages node length="+messagesNodeLength);
		Node messagesNode = null;
		Element messagesElement = null;
		NodeList messageNodeList = null;
		
		Message message = null;
		// it is known that there will be only one messages tag inside
		// a module
		messagesNode = moduleMessagesNodeList.item(0);
		if(messagesNode.getNodeType() == Node.ELEMENT_NODE){
			messagesElement = (Element)messagesNode;
			
			messageNodeList = messagesElement
					.getElementsByTagName(MessageConstants.MESSAGE_KEY);
			Node messageNode = null;
			if(messageNodeList == null){
				return messageList;
			}
			int messageLength = messageNodeList.getLength();
			//System.out.println("MessageLength="+messageLength);
			for(int messageCnt=0;messageCnt<messageLength;messageCnt++){
				messageNode = messageNodeList.item(messageCnt);
				if(messageNode != null){
					message = readMessage(messageNode);
					messageList.add(message);
				}
			}
			
		}
		
		// iterate through the messages node
		/*for(int messagesNodeCnt=0;messagesNodeCnt < messagesNodeLength;messagesNodeCnt++){
			messagesNode = moduleMessagesNodeList.item(messagesNodeCnt);
		}*/
		
		
		return messageList;
	}
	
	/**
	 * 
	 * @param messageNode
	 * @return
	 */
	private static Message readMessage(Node messageNode){
		Message message = new Message();
		Element messageElement = null;
		
		NodeList codeNodeList = null;
		NodeList resourceBundleNodeList = null;
		NodeList resourceMessageNodeList = null;
		NodeList displayMessageNodeList = null;
		
		String code = null;
		String resourceBundleClass = null;
		String resourceMessage = null;
		String displayMessage = null;
		if(Node.ELEMENT_NODE == messageNode.getNodeType()){
			messageElement = (Element)messageNode;
			
			codeNodeList = messageElement
					.getElementsByTagName(MessageConstants.MESSAGE_CODE_KEY);
			code = readMessageContent(codeNodeList);
			//System.out.println(code);
			message.setCode(code);
			
			resourceBundleNodeList = messageElement
					.getElementsByTagName(MessageConstants.RESOURCEBUNDLE_CLASS_KEY);
			resourceBundleClass = readMessageContent(resourceBundleNodeList);
			//System.out.println(resourceBundleClass);
			message.setResourceBundleClass(resourceBundleClass);
			
			resourceMessageNodeList = messageElement
					.getElementsByTagName(MessageConstants.RESOURCEMESSAGE_KEY);
			resourceMessage = readMessageContent(resourceMessageNodeList);
			//System.out.println(resourceMessage);
			message.setResourceMessage(resourceMessage);
			
			displayMessageNodeList = messageElement
					.getElementsByTagName(MessageConstants.DISPLAYMESSAGE_KEY);
			displayMessage = readMessageContent(displayMessageNodeList);
			//System.out.println(displayMessage);
			message.setDisplayMessage(displayMessage);
		}
		
		return message;
	}
	
	/**
	 * 
	 * @param nodeList
	 * @return
	 */
	private static String readMessageContent(NodeList nodeList){
		String value = "";
		Node node = null;
		if(nodeList != null){
			//System.out.println("code length="+codeNodeList.getLength());
			node = nodeList.item(0);
			NodeList childNodes = node.getChildNodes();
			if(childNodes != null){
				Node childNode = node.getChildNodes().item(0);
				if(childNode != null){
					value = childNode.getNodeValue();
				}
			}
		}
		
		return value;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static Document getMessageFileContents(){
//		StringBuffer fileContentBuffer = new StringBuffer();
		InputStream is = null;
		/*BufferedReader bufReader = null;
		Reader reader = null;
		String line = null;*/
		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(REFMESSAGES_FILENAME);
			/*reader = new InputStreamReader(is);
			bufReader = new BufferedReader(reader);
			// iterate through the file contents and read line by line
			while((line = bufReader.readLine()) != null){
				fileContentBuffer.append(line);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		InputSource source = new InputSource(is);
		// initialize the document builder factory and document builder
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		// initialize the document object - this will contain
		// the xml contents inside it as nodelist
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Could not read from output xml file "
					+ e.getMessage());
			return doc;
		}
		
		try {
			doc = dBuilder.parse(source);
		} catch (Exception e) {
			System.out.println("Could not parse output xml file "
					+ e.getMessage());
			return doc;
		}
		doc.getDocumentElement().normalize();
		
		
		return doc;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		//String fileContent = getMessageFileContents();
		//System.out.println(fileContent);
		/*Document document = getMessageFileContents();
		String rootElement = document.getDocumentElement().getNodeName();
		System.out.println(rootElement);*/
		
		Map<String, Module> moduleMessagesMap = getMessages();
		System.out.println("obtained the map");
	}
	
}
