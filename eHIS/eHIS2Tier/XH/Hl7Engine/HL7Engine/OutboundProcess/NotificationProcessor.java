package HL7Engine.OutboundProcess;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oracle.sql.ARRAY;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.hwpf.extractor.WordExtractor;
import HL7Engine.Common.*;
import HL7Engine.dao.NotificationDAO;
import HL7Engine.exceptions.FatalException;
import HL7Engine.exceptions.InterfaceException;

import com.isoft.interfaceengine.custominterface.HTTPTransactions;

public class NotificationProcessor implements ICommunication
{
	Message messageObj;
	private OutboundClientDBInteraction clientDB;
	protected OutboundClientParameters clientParameters;
	protected Common common = null;
	private NotificationDAO notificationDAO;
	
	private ICommunication commInterface;
	
	private String templateFolder;
	private List<Map<String, String>> pendingNotificationList = new ArrayList<Map<String, String>>();
	private Pattern pattern = Pattern.compile("#REQ_(.*?)_END"); // used to replace the dynamic values like mobileNo, messageContent while building the URL
	private Matcher matcher;
	private String messageEncodingType;
	private String isNewArchitecture = "N";
	
	private boolean isMailGateway = false;
	private boolean isSMSGateway = false;
	
	//private String fileMessageFormat = "#REQ_contactID_END\t#REQ_messageContent_END\n";
	private String fileMessageFormat = "#REQ_contactID_END\t#REQ_messageContent_END\n";
	
	public static final String BODY_TEMPLATE_OP_POINTER = "3.14";
	public static final String SUBJECT_TEMPLATE_OP_POINTER = "3.15";
	public static final String ATTACHMENT_TEMPLATE_OP_POINTER = "3.16";
	
	public NotificationProcessor()
	{
		
	} 

	public NotificationProcessor(OutboundClientDBInteraction clientDB,
			OutboundClientParameters clientParameters) throws Exception
	{
		this.clientParameters = clientParameters;
		this.clientDB = clientDB;
		common = Common.getInstance();
		notificationDAO = new NotificationDAO(clientParameters, clientDB);
		initFunc();
	}

	public void initFunc() throws Exception
	{
		try
		{
			messageObj = new Message(clientParameters.messageStart,
									clientParameters.messageEnd,
									clientParameters.messageSegmentEnd,
									clientParameters.componentSeparator,
									clientParameters.fieldSeparator,
									clientParameters.repetitionSeparator,
									clientParameters.subComponentSeparator,
									clientParameters.escapeChar);
			templateFolder = getTemplateFolder();
			messageEncodingType = InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "NOTIFICATION_MESSAGE_ENCODING");
			isNewArchitecture = InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "NEW_NOTIFICATION_ARCHITECTURE", "Y");
			
			if("XM".equals(clientParameters.strModuleId)) isMailGateway = true;
			else if("XS".equals(clientParameters.strModuleId)) isSMSGateway = true;
		}
		catch(Exception exp)
		{
			throw new FatalException("Exception in initializing NotificationProcessor");
		}
	}

	private String getTemplateFolder() throws Exception
	{
		return InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "NOTIFICATION_TEMPLATE_FOLDER");
	}

	public String sendMessage(String message) throws Exception
	{
		clientDB.getWebServiceParams(); // Added by Sethu for ML-BRU-CRF-0560 
		messageObj.setMessage(message);
		processSegments();
		return "S";
	}

	private void processSegments() throws Exception
	{
		try
		{
			HashMap<String, List<String>> segmentsMap = new HashMap<String, List<String>>();
			String message = messageObj.getMessage();
			String[] msgSegments = message.split("\\" + messageObj.getSegmentEnd());
			
			for(String currentSegment: msgSegments)
			{
				List<String> currentSegmentList = Arrays.asList(currentSegment.split("\\" + messageObj.getFieldSeparator(), -1));
				String currentSegmentName = currentSegmentList.get(0);
				segmentsMap.put(currentSegmentName, currentSegmentList);
				
				if("RCP".equals(currentSegmentName))
				{					
					processRCPSegment(segmentsMap);
				}
			}
			sendNotification(pendingNotificationList);
		}
		catch(Exception exp) {
			processException(exp);
		}
		finally {
			pendingNotificationList.clear();
		}
	}

	private void processRCPSegment(HashMap<String, List<String>> segmentsMap) throws Exception
	{
		
		List<String> rcpSegment = segmentsMap.get("RCP");
		List<String> mshSegment = segmentsMap.get("MSH");
		List<String> tempRCPSegment = new ArrayList<String>();
		Map<String, List<String>> tempSegmentsMap = new HashMap<String, List<String>>();		
				
		String[] destinationDtlField = rcpSegment.get(3).split("\\" + messageObj.getRepetitionSeparator());	
			
		List<String> bdSegment = null;
		
		String facilityID = "", encounterID = "", patientID = "", emWebURLLink = "", paramString = "", cleartext = "", functionID="BILL_PRINT";
		
		String mailSubject = "", encryptedFlag="N", ccEmailID = "";
		
		String ciphertext = null;
		
		for(String currentDest: destinationDtlField)
		{
			tempRCPSegment.addAll(rcpSegment);
			tempSegmentsMap.putAll(segmentsMap);
			
			Map<String, String> currentDestDtlsMap = new HashMap<String, String>();
			try
			{
				tempRCPSegment.remove(3);
				tempRCPSegment.add(3, currentDest); // 3rd field in RCP is repetitive field, removing the repetitions and adding the current repetition field alone in temp segment
				tempSegmentsMap.put("RCP", tempRCPSegment);
				
				String[] currentDestDtls = currentDest.split("\\" + messageObj.getComponentSeparator());
				int destDtlsLen = currentDestDtls.length;
				
				if(destDtlsLen >= 5 && "E".equals(currentDestDtls[3]) // checking whether this contact is enabled or not
						&& ("N".equals(isNewArchitecture) || clientParameters.strProtocolId.equals(currentDestDtls[0])) )
				{
			
					if("CM".equals(clientParameters.strCommunicationMode))
					{	
						processTemplates(currentDestDtls, tempSegmentsMap, currentDestDtlsMap);
						addCommonDtlsToCurrentDest(currentDestDtls, tempSegmentsMap, currentDestDtlsMap);
						
						currentDestDtlsMap.put("exeCMD", replaceTemplatePointers(clientParameters.url, tempSegmentsMap));
						pendingNotificationList.add(currentDestDtlsMap);
					}				
					else if( ( (isSMSGateway && ("M".equalsIgnoreCase(currentDestDtls[0]) || "Mobile".equalsIgnoreCase(currentDestDtls[0])) && ("Y".equals(rcpSegment.get(16)) ) ) //RCP[16] = SMS Required Y/N
									|| (isMailGateway && "E".equalsIgnoreCase(currentDestDtls[0]) && ("Y".equals(rcpSegment.get(15)) ) ) )) //RCP[15] = Mail Required Y/N
					{
						
						String messageContent = processTemplate(currentDestDtls[4], segmentsMap);
						String contactID = currentDestDtls[2];
						
						if (clientParameters.strProtocolId.equals("SMSBP1"))
						{
							bdSegment = segmentsMap.get("BD1");
							
							facilityID = bdSegment.get(1);							
							
							encounterID = bdSegment.get(10);							
							if(rcpSegment.size() >= 18) {
								patientID = rcpSegment.get(18);
							}
							
							emWebURLLink = bdSegment.get(12);											
							
							paramString = bdSegment.get(14);
							if ((paramString!=null) && !(paramString.trim()).equals(""))
								paramString = replaceTemplatePointers(paramString, segmentsMap);							
							
							encryptedFlag = bdSegment.get(15);	
							
							if (encryptedFlag.equalsIgnoreCase("Y"))
							{
								if ((paramString!=null) && !(paramString.trim()).equals(""))
								{
									ciphertext = clientDB.getShortURL(functionID,emWebURLLink,paramString);
									emWebURLLink = emWebURLLink + "?" + ciphertext;
								}							
									
							}
							else
							{
								if ((paramString!=null) && !(paramString.trim()).equals(""))
								{
									emWebURLLink = emWebURLLink + "?" + paramString;
								}
							}	
							
							if ((emWebURLLink!=null) && !(emWebURLLink.trim()).equals(""))						
								messageContent = messageContent.replaceAll("https://", emWebURLLink);
							
						}
						
						if("E".equalsIgnoreCase(currentDestDtls[0]))
						{
							String[] mailContents = mailContents(messageContent);
							messageContent = mailContents[0];
							currentDestDtlsMap.put("subject", mailContents[1]);
							currentDestDtlsMap.put("cc", "");
							currentDestDtlsMap.put("bcc", "");
							if(destDtlsLen > 5) currentDestDtlsMap.put("attachmentPath", processTemplateToFile(currentDestDtls[5], segmentsMap, ATTACHMENT_TEMPLATE_OP_POINTER));
						}
						
						common.fileOutputUnicode(clientParameters.strLogFile, "(NotificationProcessor:processRCPSegment) messageContent:\n======\n" + messageContent + "\n======\n");
						
						currentDestDtlsMap.put("templateID", currentDestDtls[4]);
						currentDestDtlsMap.put("recipientType", rcpSegment.get(1));
						currentDestDtlsMap.put("contactType", currentDestDtls[1]);
						currentDestDtlsMap.put("contactMode", currentDestDtls[0]);
						currentDestDtlsMap.put("languageID", currentDestDtls[6]);
						currentDestDtlsMap.put("facilityID", mshSegment.get(3));
						if(rcpSegment.size() >= 18) {
							currentDestDtlsMap.put("recipientID", rcpSegment.get(18));
						}
						currentDestDtlsMap.put("messageContent", encodeMessage(messageContent));
						currentDestDtlsMap.put("contactID", contactID); // ID is Mobile no for SMS & MailID for mail
						currentDestDtlsMap.put("userID", clientParameters.odbcDBUserID); // ID is Mobile no for SMS & MailID for mail
						
						common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processRCPSegment) Destination details:\n======\n" + currentDestDtlsMap + "\n======\n");
						
						pendingNotificationList.add(currentDestDtlsMap);
					}
					else if(clientParameters.debugYN)
					{
						if(isSMSGateway && "Mobile".equalsIgnoreCase(currentDestDtls[0]) && ("N".equals(rcpSegment.get(16)) ) ) {
							common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processRCPSegment) SMS required flag (RCP[16]) is disabled");
						}
						else if((isMailGateway && "Email".equalsIgnoreCase(currentDestDtls[0]) && ("N".equals(rcpSegment.get(15)) ) )) {
							common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processRCPSegment) eMail required flag (RCP[17]) is disabled");
						}
					}
				}
			}
			catch(Exception exp) {
				common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processRCPSegment) Current Destination - " + currentDest + "\n");
				throw exp;
			}
		}
	}
	
	private void addCommonDtlsToCurrentDest(String[] currentDestDtls, Map<String, List<String>> tempSegmentsMap, Map<String, String> currentDestDtlsMap) 
	{
		List<String> rcpSegment = tempSegmentsMap.get("RCP");
		List<String> mshSegment = tempSegmentsMap.get("MSH");
		
		currentDestDtlsMap.put("recipientType", rcpSegment.get(1));
		currentDestDtlsMap.put("recipientDependency", rcpSegment.get(2));
		currentDestDtlsMap.put("contactType", currentDestDtls[1]);
		currentDestDtlsMap.put("contactMode", currentDestDtls[0]);
		currentDestDtlsMap.put("languageID", currentDestDtls[6]);
		currentDestDtlsMap.put("facilityID", mshSegment.get(3));
		currentDestDtlsMap.put("contactID", currentDestDtls[2]);
		currentDestDtlsMap.put("cc", "");
		currentDestDtlsMap.put("bcc", "");
		currentDestDtlsMap.put("recipientID", rcpSegment.get(18));
	}

	private void processTemplates(String[] currentDestDtls, Map<String, List<String>> tempSegmentsMap, Map<String, String> currentDestDtlsMap) 
	{
		String outputTemplatePath = "";
		
		if(currentDestDtls[4] != null && !currentDestDtls[4].equals("")) {
			outputTemplatePath = processTemplateToFile(currentDestDtls[4], tempSegmentsMap, BODY_TEMPLATE_OP_POINTER);
			currentDestDtlsMap.put("templateID", currentDestDtls[4]);
			currentDestDtlsMap.put("processedTemplateID", outputTemplatePath);
		}
		if(currentDestDtls[5] != null && !currentDestDtls[5].equals("")) {
			outputTemplatePath = processTemplateToFile(currentDestDtls[5], tempSegmentsMap, ATTACHMENT_TEMPLATE_OP_POINTER);
			currentDestDtlsMap.put("attachmentPath", outputTemplatePath);
		}
		if(currentDestDtls[11] != null && !currentDestDtls[11].equals("")) {
			outputTemplatePath = processTemplateToFile(currentDestDtls[11], tempSegmentsMap, SUBJECT_TEMPLATE_OP_POINTER);
			currentDestDtlsMap.put("processedSubjectTemplateID", outputTemplatePath);
		}
	}

	private String processTemplateToFile(String templatePath, Map<String, List<String>> tempSegmentsMap, String templateOutputPointer) 
	{
		String outputFile = messageObj.getFieldValue("RCP", templateOutputPointer, tempSegmentsMap.get("RCP")); // filename will be with path
		
		if(clientParameters.debugYN) {
			common.fileOutputUnicode(clientParameters.strLogFile, "(NotificationProcessor:processTemplateToFile) Template Path [" + templatePath + "] Output [" + outputFile + "]\n");
		}
		
		if(templatePath.endsWith(".doc")) {
			templatePath = processDocTemplate(templatePath, tempSegmentsMap, outputFile);
		}
		else if(templatePath.endsWith(".txt")) {
			templatePath = processTxtTemplate(templatePath, tempSegmentsMap, outputFile);
		}
		else if(templatePath.endsWith(".csv")) {
			templatePath = processTxtTemplate(templatePath, tempSegmentsMap, outputFile);
		}
		return templatePath;
	}

	/**
	 * Returns the message content of the notification after replacing the pointers with transaction values.
	 * In case of mail notification, individual mail attributes will be retrieved by calling {@link #mailContents(String)} method from {@link #processRCPSegment(Map)}
	 * 
	 * @param templateID filename which contains the template of the message
	 * @param segmentsMap transaction values that has to be replaced in template pointers
	 * @return template contents after replacing the pointers with transaction values
	 * @throws Exception
	 */
	private String processTemplate(String templateID, HashMap<String, List<String>> segmentsMap) throws Exception
	{
		String templateContent = "";

		try {
			
			if(templateID != null) {
				if(templateID.endsWith(".rtf") || templateID.endsWith(".txt")) templateContent = InterfaceUtil.fetchFileContents(templateID);
				else if(templateID.endsWith(".doc")) templateContent = getDocTemplate(templateID);
				templateContent = replaceTemplatePointers(templateContent, segmentsMap);

			}
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processException) Exception - " + exp.getMessage() + "\n" );
			processException(exp);
		}
		
		return templateContent;
	}
	
	public String replaceTemplatePointers(String templateContent, Map<String, List<String>> tempSegmentsMap) throws Exception
	{
		String segmentID = "";
		String segmentField = "";
		
		try {
			Pattern pattern = Pattern.compile(":(([A-z0-9]){3,4})\\[(.*?)\\]"); // CMMNP1
			//Pattern pattern = Pattern.compile(":([A-z].*?)\\[(.*?)\\]");
			Matcher matcher = pattern.matcher(templateContent);
			while(matcher.find())
			{
				segmentID = matcher.group(1);
				segmentField = matcher.group(3);
				//segmentField = matcher.group(2);
				String currentMatch = matcher.group();
				
				String currentMatchVal = "";				
				/* If condition added by Sethu for ML-BRU-CRF-0535 on 20/12/2018*/
				if (clientParameters.strProtocolId.equalsIgnoreCase("CMMNP1"))
				{
					common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:replaceTemplatePointers) Inside CMMNP1 ::: "+ clientParameters.strProtocolId  +"\n" );
					currentMatchVal = messageObj.getFieldValue(segmentID, segmentField, tempSegmentsMap.get(segmentID));
				}
				else
				{
					currentMatchVal = messageObj.getFieldValueStr(segmentID, segmentField, tempSegmentsMap.get(segmentID));
				}
				
				String c1 = currentMatch.replace("[", "\\[");
				String c2 = c1.replace("]", "\\]");
				templateContent = templateContent.replaceAll(c2, currentMatchVal);
				//common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:replaceTemplatePointers) c1:: "+ c1  + " :: c2 :: "+ c2  + " :: templateContent :: "+ templateContent  +"\n" );			
			}
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:replaceTemplatePointers) segmentID ["+ segmentID +"] segmentField ["+ segmentField +"]\n" );
			processException(exp);
		}
		return templateContent;
	}

	private String getDocTemplate(String templateID) 
	{
		FileInputStream inputStream = null;
		String templateContent = "";
		WordExtractor extractor = null ;
		
		StringBuffer strData = new StringBuffer();
		
		try
		{
			inputStream = new FileInputStream(templateFolder + templateID);
			HWPFDocument doc = new HWPFDocument(new POIFSFileSystem(inputStream));
			//Range range = doc.getRange();
			//templateContent = range.text();
			
			extractor = new WordExtractor(doc);
			String [] fileData = extractor.getParagraphText();
			for(int i=0;i<fileData.length;i++){
				if(fileData != null)
				strData.append(fileData[i]);
			}
			
		}
		catch(FileNotFoundException fileExp) {
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:getDocTemplate) Unable to access " + fileExp.getMessage() + " !!!\n");
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:getDocTemplate) Exception "+ exp +"\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally {
			try {
				inputStream.close();
			}
			catch(Exception exp){}
		}
	
		//return templateContent;
		return strData.toString();
	}

	private String processDocTemplate(String templateID, Map<String, List<String>> tempSegmentsMap, String outputFile) 
	{
		FileOutputStream outputStream = null;
		FileInputStream inputStream = null;
		
		try
		{
			inputStream = new FileInputStream(templateID);
			HWPFDocument doc = new HWPFDocument(new POIFSFileSystem(inputStream));
			Range range = doc.getRange();

			String templateTxt = range.text();
			Map<String, String> pointers = getPointers(templateTxt, tempSegmentsMap);

			for(Map.Entry<String, String> pointer : pointers.entrySet()) {
				range.replaceText(pointer.getKey(), pointer.getValue());
			}
			
			outputStream = new FileOutputStream(outputFile);
			doc.write(outputStream);
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processDocTemplate) Exception "+ exp +"\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally {
			try {
				outputStream.close();
				inputStream.close();
			}
			catch(Exception exp){}
		}
		return outputFile;
	}

	private void sendNotification(List<Map<String, String>> pendingNotificationList) throws Exception
	{
		String statusMsg = "";		
				
		if(clientParameters.strProtocalLinkId.equals("SMSG4")) { // for file uploads (BULK)
			boolean isTempBulkFileDeleted = new File(templateFolder + "File1.txt").delete();			
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:sendNotification) isTempBulkFileDeleted "+ isTempBulkFileDeleted +"\n" );
		}
		
		if("H".equals(clientParameters.strCommunicationMode))
		{
			HTTPTransactions httpTransactions = HTTPTransactions.getInstance(clientParameters);
			
			for(Map<String, String> notificationDtls: pendingNotificationList)
			{
				if(clientParameters.strProtocalLinkId.equals("SMSG4")) { // for file uploads (BULK)
					addMessagetoFile(notificationDtls);
					notificationDtls.put("notificationType", "R");
				}
				else { 
					
					String url = bulidHTTPURL(notificationDtls);
					common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:sendNotification) After calling bulidHTTPURL "+ url +"\n" );
					httpTransactions.setURL(url, true);
					statusMsg = httpTransactions.sendMessage(notificationDtls.get("messageContent"), "N"); // CMMNP2
					notificationDtls.put("notificationType", "O");
				}
			}
			if(clientParameters.strProtocalLinkId.equals("SMSG4")) {
				statusMsg = httpTransactions.uploadFile(templateFolder + "File1.txt", bulidHTTPURL(null));
				if(statusMsg.startsWith("Error")) {
					throw new InterfaceException("Error from vendor - " + statusMsg);
				}
			}
			notificationDAO.updateIndividualRecipientDtls(pendingNotificationList, statusMsg);
		}
		else if("SO".equals(clientParameters.strCommunicationMode)) // SO - SMTP Outlook
		{
			if(commInterface == null)
			{
				commInterface = new OutlookTrans(null, clientParameters);
			}
			
			for(Map<String, String> mailDtls: pendingNotificationList)
			{
				commInterface.processCommunication(mailDtls);
			}
		}
		else if("CM".equals(clientParameters.strCommunicationMode)) // CM - CMD Protocol
		{
			for(Map<String, String> cmdDtls: pendingNotificationList)
			{
				String exeCMD = cmdDtls.get("exeCMD");
				common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:sendNotification) Executing command "+exeCMD +"\n" );
				statusMsg = CommonUtil.executeCMD(exeCMD, false, false, 0);
				common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:sendNotification) statusMsg "+ statusMsg +"\n" );
				notificationDAO.updateIndividualRecipientDtlsProc(cmdDtls, statusMsg);
			}
		}
	}

	private void addMessagetoFile(Map<String, String> smsDtls) throws Exception
	{
		String currentMessage = fileMessageFormat;
		Matcher matcher = pattern.matcher(fileMessageFormat);
		
		while(matcher.find()) {
			String param = matcher.group(1);
			String currentMatch = matcher.group();
			currentMessage = currentMessage.replace(currentMatch, smsDtls.get(param));
			//common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:sendNotification) addMessagetoFile "+currentMessage +"\n" );
		}
		FileUtil.appendToFile(templateFolder + "File1.txt", currentMessage, messageEncodingType);
		//FileUtil.appendToFile(templateFolder + "File1.csv", currentMessage, messageEncodingType);
	}

	private String bulidHTTPURL(Map<String, String> destDtls) 
	{
		String url = null;
		String param = null;
		String currentMatch = null;
		
		try
		{
			if("SMSBRU08".equals(clientParameters.profileID)) { // Brunei specific initial implementation
				url = clientParameters.url 
						+ "?messageBody=" + URLEncoder.encode(destDtls.get("messageContent"), "UTF-8")
						+ "&DA=" + URLEncoder.encode(destDtls.get("contactID"), "UTF-8")
						+ "&userID=" + URLEncoder.encode(clientParameters.odbcDBUserID, "UTF-8")
						+ "&password=" + URLEncoder.encode(clientParameters.odbcDBPwd, "UTF-8");
			}
			else
			{
				if(matcher == null) {
					clientParameters.url = clientParameters.url.replace("#REQ_USERID_END", URLEncoder.encode(clientParameters.odbcDBUserID, "UTF-8"));
					clientParameters.url = clientParameters.url.replace("#REQ_PASSWORD_END", URLEncoder.encode(clientParameters.odbcDBPwd, "UTF-8"));
				}
				
				matcher = pattern.matcher(clientParameters.url);			
				
				url = clientParameters.url;
				
				while(matcher.find()) {
					param = matcher.group(1);					
					currentMatch = matcher.group();
					url = url.replace(currentMatch, URLEncoder.encode(destDtls.get(param), "UTF-8"));
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:bulidHTTPURL) Exception "+ exp +"\n" );
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:bulidHTTPURL) URL "+ url +"\n" );
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:bulidHTTPURL) Param ["+ param +"] CurrentMatch ["+ currentMatch +"]\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		return url;
	}

	private String processTxtTemplate(String templateID, Map<String, List<String>> segmentsMap, String outputFile)
	{
		String templateContent = "";
		FileOutputStream fout = null;
		try
		{
			fout = new FileOutputStream(outputFile);
			templateContent = InterfaceUtil.fetchFileContents(templateID);
			fout.write(replaceTemplatePointers(templateContent, segmentsMap).getBytes());
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processTxtTemplate) Exception "+ exp +"\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally {
			CommonUtil.closeStream(fout);
		}
		
		return outputFile;
	}
	
	void processException(Exception exp) throws Exception
	{
		common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:processException) Exception in processException "+ exp +"\n" );
	    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
	    throw exp;
	}

	public void closeResources()
	{
		// TODO Auto-generated method stub
		
	}

	public String processCommunication(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	Map<String, String> getPointers(String templateTxt, Map<String, List<String>> tempSegmentsMap)
	{
		String segmentID = "";
		String segmentField = "";
		String currentMatch = "";
		String currentMatchVal = "";
		Map<String, String> pointerMap = new HashMap<String, String>();
		Pattern pattern = Pattern.compile(":(([A-z0-9]){3,4})\\[(.*?)\\]");
		Matcher matcher = pattern.matcher(templateTxt);
		while(matcher.find())
		{
			segmentID = matcher.group(1);
			segmentField = matcher.group(3);
			currentMatch = matcher.group();
			try {
				currentMatchVal = messageObj.getFieldValue(segmentID, segmentField, tempSegmentsMap.get(segmentID));
			}
			catch(Exception exp) {
				common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:getPointers) Exception "+ exp +"\n" );
				common.fileOutput(clientParameters.strLogFile, "(NotificationProcessor:getPointers) Current Segment ID ["+ segmentID +"] Current Segment Field ["+ segmentField +"]\n" );
			    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
			}
			
			pointerMap.put(currentMatch, currentMatchVal);
		}
		return pointerMap;
	}
	
	/**
	 * For regional language SMS, vendors supports different encoding formats.
	 * As of now deciding the encoding type based on the locale from the template ID, has to be replaced to protocol level
	 * templateID is the file name of the template along with the extension (eg:- OA01-PAT-Patient-Mobile.doc)
	 */
	public String encodeMessage(String message) throws Exception
	{
		String encodedMessage = message;
		
		if(messageEncodingType.equals("UNICODE"))
		{
			encodedMessage = EncodeUtil.unicodeEncoding(message);
		}
		return encodedMessage;
	}
	
	public String[] mailContents(String messageContent) throws Exception
	{
		String [] mailContents = new String[2];
		Properties prop = new Properties();
		prop.load(new ByteArrayInputStream(messageContent.getBytes()));
		mailContents[0] = prop.getProperty("MESSAGE_TEMPLATE", "");
		mailContents[1] = prop.getProperty("MAIL_SUBJECT", "");
		return mailContents;
	}
}
