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
package portal.common.message;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This is the container class for storing all the resource bundle messages
 * for the Portal web service application
 * @author gramamoorthy
 *
 */
public class MessageContainer {

	/**
	 * static instance of the class
	 */
	private static MessageContainer s_instance = null;
	
	/**
	 * 
	 */
	private static Map<String, Module> moduleMessageMap = new HashMap<String, Module>();

	/**
	 * private constructor of the class
	 */
	private MessageContainer(){
		initializeMessages();
	}
	
	/**
	 * method to get the instance of this class
	 * @return
	 */
	public static MessageContainer getInstance(){
		if(s_instance == null){
			s_instance = new MessageContainer();
		}
		return s_instance;
	}
	
	/**
	 * 
	 */
	private void initializeMessages(){
		moduleMessageMap = MessageReader.getMessages();
	}
	 
	/**
	 * 
	 */
	public void reInitializeMessages(){
		initializeMessages();
	}
	
	/**
	 * 
	 * @param moduleName
	 * @param code
	 * @return
	 */
	public String getResourceMessage(String moduleName,String code){
		String resourceMessage = "";
		if(moduleMessageMap.containsKey(moduleName)){
			Module module = moduleMessageMap.get(moduleName);
			// module is expected to be not null
			List<Message> messageList = module.getMessageList();
			if(messageList == null){
				return resourceMessage;
			}
			
			for(Message message : messageList){
				if(message.getCode().equals(code)){
					ResourceBundle bundle = message.getResourceBundleInstance();
					// safe check
					if(bundle == null){
						return resourceMessage;
					}
					try {
						resourceMessage = bundle.getString(message.getResourceMessage());
					} catch (Exception e) {
						e.printStackTrace();
						/**
						 * TODO
						 * need to log
						 */
						resourceMessage = "";
					}
					break;
				}
			}
		}
		
		return resourceMessage;
	}
	
	/**
	 * 
	 * @param moduleName
	 * @param code
	 * @return
	 */
	public String getDisplayMessage(String moduleName,String code){
		String displayMessage = "";
		
		if(moduleMessageMap.containsKey(moduleName)){
			Module module = moduleMessageMap.get(moduleName);
			// module is expected to be not null
			List<Message> messageList = module.getMessageList();
			if(messageList == null){
				return displayMessage;
			}
			// iterate through the messages and get the one whose code
			// equals the given code
			for(Message message : messageList){
				if(message.getCode().equals(code)){
					ResourceBundle bundle = message.getResourceBundleInstance();
					// safe check
					if(bundle == null){
						return displayMessage;
					}
					try {
						displayMessage = bundle.getString(message.getDisplayMessage());
						break;
					} catch (Exception e) {
						e.printStackTrace();
						displayMessage = "";
						break;
					}
				}
			}
		}
		
		
		return displayMessage;
	}
	
	/**
	 * 
	 * @param moduleName
	 * @param code
	 * @param parameterList
	 * @return
	 */
	public String getResourceMessage(String moduleName,String code,Object[] parameterArray){
		String resourceMessage = "";
		resourceMessage = getResourceMessage(moduleName, code);
		try {
			resourceMessage = MessageFormat.format(resourceMessage, parameterArray);
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * TODO
			 * need to log
			 */
			resourceMessage = "";
		}
		
		return resourceMessage;
	}
	
	/**
	 * 
	 * @param moduleName
	 * @param code
	 * @param parameterArray
	 * @return
	 */
	public String getDisplayMessage(String moduleName,String code,Object[] parameterArray){
		String displayMessage = "";
		displayMessage = getDisplayMessage(moduleName, code);
		try {
			displayMessage = MessageFormat.format(displayMessage, parameterArray);
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * TODO
			 * need to log 
			 */
			displayMessage = "";
		}
		
		return displayMessage;
	}
	
}
