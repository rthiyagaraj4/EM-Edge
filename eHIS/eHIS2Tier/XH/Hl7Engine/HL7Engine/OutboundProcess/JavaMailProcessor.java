package HL7Engine.OutboundProcess;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import HL7Engine.Common.*;
import HL7Engine.dao.NotificationDAO;
import HL7Engine.exceptions.FatalException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.Connection;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class JavaMailProcessor implements ICommunication
{
	HL7Engine.Common.Message messageObj;
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
	
	private  String username = "";
	private  String password = "";
	
	//Added by Niveditha
	public String mailattachmentflag;
	public String standardCODE = "";
	public String profileID = "";
	public String getsegmenteventtype;
	public String controlsegmentID = "";
	
	private Properties props = null;
	
	private Display display = null;
	
	public String mail_config = "";
	
	
	public Connection connDB;
	Connection externalDBConn;
	
	public JavaMailProcessor()
	{
		
	}

	public JavaMailProcessor(OutboundClientDBInteraction clientDB,
			OutboundClientParameters clientParameters) throws Exception
	{
		//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:JavaMailProcessor) Inside Java Mail Comm Interface...\n" );
		
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
			String smtpAuth = "false";
			String smtpStarttls = "false";
			
			messageObj = new HL7Engine.Common.Message(clientParameters.messageStart,
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
			
			mail_config = clientParameters.mail_config;
			
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:initFunc) Mail Config Option "+ mail_config +"\n" );
			
			if ("SM".equalsIgnoreCase(clientParameters.mail_config))
			{
			
				props = new Properties();
				
				if ("Y".equalsIgnoreCase(clientParameters.mail_smtp_auth_flag))
					smtpAuth = "true";
				
				if ("Y".equalsIgnoreCase(clientParameters.mail_smtp_starttls_flag))
					smtpStarttls = "true";
				
				props.put("mail.smtp.auth", smtpAuth);
		        props.put("mail.smtp.starttls.enable", smtpStarttls);
		        props.put("mail.smtp.host", clientParameters.mail_host);
		        props.put("mail.smtp.port", clientParameters.mail_port);		        
	        
			}
			
			username = clientParameters.odbcDBUserID;
	        password = clientParameters.odbcDBPwd;
	        profileID = clientParameters.profileID;
	        
	        //Added by Niveditha
	        mailattachmentflag = clientParameters.mail_attachment_flag;

		}
		catch(Exception exp)
		{
			throw new FatalException("Exception in initializing JavaMailProcessor");
		}
	}

	private String getTemplateFolder() throws Exception
	{
		return InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "NOTIFICATION_TEMPLATE_FOLDER");
	}

	public String sendMessage(String message) throws Exception
	{		
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
			
			//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processSegments) msgSegments "+ msgSegments.toString() +"\n" );
			
			for(String currentSegment: msgSegments)
			{			
				List<String> currentSegmentList = Arrays.asList(currentSegment.split("\\" + messageObj.getFieldSeparator(), -1));
				String currentSegmentName = currentSegmentList.get(0);
				
				segmentsMap.put(currentSegmentName, currentSegmentList);
				
				if("RCP".equals(currentSegmentName))
				{
					//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processSegments) Inside RCP If Loop "+"\n" );
					processRCPSegment(segmentsMap);
				}
			}
			sendNotification(pendingNotificationList);
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processSegments------)\n" );
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
		
		List<String> tempMSHSegment = new ArrayList<String>(); //Added by Niveditha
		Map<String, List<String>> tempSegmentsMap = new HashMap<String, List<String>>();		
		
		String[] destinationDtlField = rcpSegment.get(3).split("\\" + messageObj.getRepetitionSeparator());	
		
		//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) destinationDtlField : "+ Arrays.toString(destinationDtlField) +"\n" );

		//Added by Niveditha
		String[] mshdestinationDtlField = mshSegment.get(8).split("\\" + messageObj.getRepetitionSeparator());	
		
		//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) mshdestinationDtlField : "+ Arrays.toString(mshdestinationDtlField) +"\n" );

		//List<String> bdSegment = null; 
		
		List<String> mailSegment = null;  //Added by Niveditha
		
		String facilityID = "", encounterID = "", patientID = "", emWebURLLink = "", paramString = "", cleartext = "", functionID="BILL_PRINT";
		
		String mailSubject = "", encryptedFlag="N", ccEmailID = "";
		
		String ciphertext = null;  
		
		String cntsegmailsubject= null; //Added by Niveditha		
		String cntsegmailcc= null; //Added by Niveditha
		String mailAttachmentFile =""; //Added by Niveditha	
		String recipientType = "";
		String contactID = "";	
		String messageContent = "";
		
		for(String currentDest: destinationDtlField)		
		{
			
			//Added by Niveditha
			for(String mshcurrentDest: mshdestinationDtlField)
			{		
				tempRCPSegment.addAll(rcpSegment);
				
				tempMSHSegment.addAll(mshSegment);  //Added by Niveditha
				
				tempSegmentsMap.putAll(segmentsMap);
				
				Map<String, String> currentDestDtlsMap = new HashMap<String, String>();
				try
				{
					tempRCPSegment.remove(3);
					tempRCPSegment.add(3, currentDest); // 3rd field in RCP is repetitive field, removing the repetitions and adding the current repetition field alone in temp segment
					tempSegmentsMap.put("RCP", tempRCPSegment);
					
					String[] currentDestDtls = currentDest.split("\\" + messageObj.getComponentSeparator());
					
					//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) currentDestDtls : "+ Arrays.toString(currentDestDtls) +"\n" );
					
					//Added by Niveditha
					
					tempMSHSegment.remove(8);
					tempMSHSegment.add(8, mshcurrentDest); // 8th field in MSH is repetitive field, removing the repetitions and adding the current repetition field alone in temp segment
					tempSegmentsMap.put("MSH", tempRCPSegment);
					
					String[] mshcurrentDestDtls = mshcurrentDest.split("\\" + messageObj.getComponentSeparator());
					
					//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) mshcurrentDestDtls : "+ Arrays.toString(mshcurrentDestDtls) +"\n" );
					
					int destDtlsLen = currentDestDtls.length;
					
					if(destDtlsLen >= 5 && "E".equals(currentDestDtls[3]) // checking whether this contact is enabled or not
							&& ("N".equals(isNewArchitecture) && clientParameters.strProtocolId.equals(currentDestDtls[0])) )
					{
						
						if("CM".equals(clientParameters.strCommunicationMode))
						{	
							processTemplates(currentDestDtls, tempSegmentsMap, currentDestDtlsMap);
							addCommonDtlsToCurrentDest(currentDestDtls, tempSegmentsMap, currentDestDtlsMap);
							
							currentDestDtlsMap.put("exeCMD", replaceTemplatePointers(clientParameters.url, tempSegmentsMap));
							pendingNotificationList.add(currentDestDtlsMap);
						} 
					
						/*else if( ( (isSMSGateway && "M".equalsIgnoreCase(currentDestDtls[0]) && ("Y".equals(rcpSegment.get(16)) ) ) //RCP[16] = SMS Required Y/N
										|| (isMailGateway && "E".equalsIgnoreCase(currentDestDtls[0]) && ("Y".equals(rcpSegment.get(15)) ) ) )) //RCP[15] = Mail Required Y/N
						*/
					}
					else if( ( (isSMSGateway && "M".equalsIgnoreCase(currentDestDtls[0]) && ("Y".equals(rcpSegment.get(16)) ) ) //RCP[16] = SMS Required Y/N
									|| (isMailGateway && "E".equalsIgnoreCase(currentDestDtls[0]) && ("Y".equals(rcpSegment.get(15)) ) ) //RCP[15] = Mail Required Y/N
									|| (isMailGateway && "EMAIL".equalsIgnoreCase(currentDestDtls[0])))) 
					{
						messageContent = processTemplate(currentDestDtls[4], segmentsMap);
	
						contactID = currentDestDtls[2];	
						
						recipientType = rcpSegment.get(1);
						
						//Added by Niveditha
						if (clientParameters.strProtocolId !=null && clientParameters.strProtocolId !="")
						{	
							if (!(recipientType.equalsIgnoreCase("LAB")))
							{
								getsegmenteventtype = mshcurrentDestDtls[1];		
								mailSegment = segmentsMap.get(getsegmenteventtype);	
								facilityID = mailSegment.get(1);	 		
								encounterID = mailSegment.get(10);								
							
								if(rcpSegment.size() >= 18) {
									patientID = rcpSegment.get(18);
								}  
								
								emWebURLLink = mailSegment.get(12);
								
								controlsegmentID = mshcurrentDestDtls[0];		
								
								standardCODE = clientDB.getstandardprofile(profileID);
	
								cntsegmailsubject = clientDB.getstandardsegsubject(controlsegmentID, standardCODE);
								
								mailSubject = cntsegmailsubject;
	
								if ((mailSubject!=null) && !(mailSubject.trim()).equals(""))
									mailSubject = replaceTemplatePointers(mailSubject, segmentsMap);	
								
								paramString = mailSegment.get(14);
								if ((paramString!=null) && !(paramString.trim()).equals(""))
									paramString = replaceTemplatePointers(paramString, segmentsMap);													
	
								encryptedFlag = mailSegment.get(15);	
			
								cntsegmailcc = clientDB.getstandardsegcc(controlsegmentID, standardCODE);
	
								ccEmailID = cntsegmailcc;
								
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
		
								if("Y".equalsIgnoreCase(mailattachmentflag)){
								mailAttachmentFile = mailSegment.get(16);
								}
							}													
						}
					
						
						
						/*
						if("E".equalsIgnoreCase(currentDestDtls[0]))
						{
							String[] mailContents = mailContents(messageContent);
							messageContent = mailContents[0];
							currentDestDtlsMap.put("subject", mailContents[1]);
							currentDestDtlsMap.put("cc", "");
							currentDestDtlsMap.put("bcc", "");
							if(destDtlsLen > 5) currentDestDtlsMap.put("attachmentPath", processTemplateToFile(currentDestDtls[5], segmentsMap, ATTACHMENT_TEMPLATE_OP_POINTER));
						}
						*/
						
						if (!(recipientType.equalsIgnoreCase("LAB")))
						{
							//common.fileOutputUnicode(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) "+recipientType+" messageContent:\n======\n" + messageContent + "\n======\n");
							
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
							currentDestDtlsMap.put("subject", mailSubject);
							if(ccEmailID != null && ccEmailID != ""){
							currentDestDtlsMap.put("ccEmailID", ccEmailID);
							}
							
							if("Y".equalsIgnoreCase(mailattachmentflag)){
							currentDestDtlsMap.put("mailAttachmentFileName", mailAttachmentFile);  //Added by Niveditha
							}
						}
						
						if (recipientType.equalsIgnoreCase("LAB"))
						{
							contactID = currentDestDtls[2];	//Email ID							
							messageContent = currentDestDtls[4]; //Message Content
							mailAttachmentFile = currentDestDtls[7]; //Mail attachments
							ccEmailID = currentDestDtls[9];//CC Mail ID
							mailSubject = currentDestDtls[11];//Mail Subject
							
							// Added By Suneel for ML-MMOH-CRF-2090.1 on 15/07/2024
							if(currentDestDtls.length > 16){
								String salutation = currentDestDtls[16];
								if(salutation != null && !salutation.isEmpty()){
									messageContent = salutation + "\n\n" +messageContent;
								}
							}
							if(currentDestDtls.length > 17){
								String footer = currentDestDtls[17];
								if(footer != null && !footer.isEmpty()){
									messageContent = messageContent+ "\n\n" +footer;
								}
							}
							
							//common.fileOutputUnicode(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) Mail ID: " +contactID+ " \n======\n" + messageContent.indexOf("<CHR(10)>") + "\n======\n");							
							messageContent = messageContent.replaceAll("<CHR\\(10\\)>", "\n");														
							common.fileOutputUnicode(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) "+recipientType+" Message Content:\n======\n" + messageContent + "\n======\n");						
							
							currentDestDtlsMap.put("templateID", "");
							currentDestDtlsMap.put("recipientType", rcpSegment.get(1)); //LAB
							currentDestDtlsMap.put("contactType", currentDestDtls[1]);//EMAIL
							currentDestDtlsMap.put("contactMode", currentDestDtls[0]);//EMAIL
							currentDestDtlsMap.put("languageID", "en");
							currentDestDtlsMap.put("facilityID", mshSegment.get(3));				
							
		
							if(rcpSegment.size() >= 18) {
								currentDestDtlsMap.put("recipientID", rcpSegment.get(18));
							}
							currentDestDtlsMap.put("messageContent", encodeMessage(messageContent));
							
							currentDestDtlsMap.put("contactID", contactID); // ID is Mobile no for SMS & MailID for mail
							currentDestDtlsMap.put("userID", clientParameters.odbcDBUserID); // ID is Mobile no for SMS & MailID for mail
							currentDestDtlsMap.put("subject", mailSubject);
							if(ccEmailID != null && ccEmailID != ""){
								currentDestDtlsMap.put("ccEmailID", ccEmailID);
							}
							
							if(mailAttachmentFile.length()>0)
							{
								currentDestDtlsMap.put("mailAttachmentFileName", mailAttachmentFile);  //Added by Niveditha
							}							
						}
						
						pendingNotificationList.add(currentDestDtlsMap);
						
						common.fileOutputUnicode(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment)  Destination details:\n======\n" + currentDestDtlsMap + "\n======\n");
					}
					else if(clientParameters.debugYN)
					{
						if(isSMSGateway && "Mobile".equalsIgnoreCase(currentDestDtls[0]) && ("N".equals(rcpSegment.get(16)) ) ) {
							common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) SMS required flag (RCP[16]) is disabled");
						}
						else if((isMailGateway && "E".equalsIgnoreCase(currentDestDtls[0]) && ("N".equals(rcpSegment.get(15)) ) )) {
							common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) eMail required flag (RCP[15]) is disabled");
						}
					}
				}
				catch(Exception exp) {
					common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processRCPSegment) Current Destination - " + currentDest + "\n");
					throw exp;
				}
			}
			
		}//Added by Niveditha				
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
				else if(templateID.endsWith(".html")) templateContent = getHTMLTemplate(templateID);  //Added by Niveditha for AMS-CRF-0234
				templateContent = replaceTemplatePointers(templateContent, segmentsMap);
			}
			
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processException) Exception -------- " + exp.getMessage() + "\n" );
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
					currentMatchVal = messageObj.getFieldValue(segmentID, segmentField, tempSegmentsMap.get(segmentID));
				}
				else
				{
					currentMatchVal = messageObj.getFieldValueStr(segmentID, segmentField, tempSegmentsMap.get(segmentID));
				}
				
				String c1 = currentMatch.replace("[", "\\[");
				String c2 = c1.replace("]", "\\]");
				templateContent = templateContent.replaceAll(c2, currentMatchVal);
				//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:replaceTemplatePointers) c1:: "+ c1  + " :: c2 :: "+ c2  + " :: templateContent :: "+ templateContent  +"\n" );			
			}
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:replaceTemplatePointers) segmentID ["+ segmentID +"] segmentField ["+ segmentField +"]\n" );
			processException(exp);
		}
		return templateContent;
	}

	private String getDocTemplate(String templateID) 
	{
		
		FileInputStream inputStream = null;
		String templateContent = "";
		
		try
		{
			inputStream = new FileInputStream(templateFolder + templateID);
			HWPFDocument doc = new HWPFDocument(new POIFSFileSystem(inputStream));
			Range range = doc.getRange();
			templateContent = range.text();
		}
		catch(FileNotFoundException fileExp) {
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:getDocTemplate) Unable to access---------" + fileExp.getMessage() + " !!!\n");
		}
		catch(Exception exp) {
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:getDocTemplate) Exception "+ exp +"\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally {
			try {
				inputStream.close();
			}
			catch(Exception exp){}
		}
	
		return templateContent;
	}

	//Added by Niveditha for AMS-CRF-0234 To Get the HTML file
	private String getHTMLTemplate(String templateID) 
	{
		String finalOutput="";
		try  {
			String filePath = templateFolder + templateID;
			FileReader fr=new FileReader(filePath);
			
			BufferedReader br= new BufferedReader(fr);
			StringBuilder content = new StringBuilder(1024);
			String lineOfContent;
			while(( lineOfContent =br.readLine())!=null)
			    {
			    content.append(lineOfContent);
			    finalOutput = content.toString();
			    }		
			} 
		catch (IOException e) {
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:getHTMLTemplate) exxception:"+e+"\n" );
			e.printStackTrace();
		}	
		return finalOutput;
	}
	
	private String processDocTemplate(String templateID, Map<String, List<String>> tempSegmentsMap, String outputFile) 
	{

		common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processDocTemplate) Exception "+ templateID +"\n" );
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
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processDocTemplate) Exception "+ exp +"\n" );
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
		String statusMsg = "", attachmentName = "";	
		
		for(Map<String, String> notificationDtls: pendingNotificationList)
		{
			if("JM".equals(clientParameters.strCommunicationMode)) // JM - JAVA MAIL THROUGH EM GATEWAY ENGINE
			{
				if ("SM".equalsIgnoreCase(clientParameters.mail_config))
				{
					Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
					    protected PasswordAuthentication getPasswordAuthentication() {
					        return new PasswordAuthentication(username, password);
					    }
					  });
					
					try {				
						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress(username));
						message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(notificationDtls.get("contactID")));
						String ccEmailID = notificationDtls.get("ccEmailID");
		
						if(ccEmailID != null &&  ccEmailID != ""){	
							if (ccEmailID.length()>0){					
								message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmailID));
							}
						}
						
						message.setSubject(notificationDtls.get("subject"));
	
			            Multipart multipart = new MimeMultipart();
			            message.setContent(multipart);
			           
			            String templateID = notificationDtls.get("templateID");
			            if(templateID.endsWith(".html")){
				            MimeBodyPart messageBodyPartHTML = new MimeBodyPart();
				            messageBodyPartHTML.setContent(notificationDtls.get("messageContent"), "text/html; charset=utf-8");
				            multipart.addBodyPart(messageBodyPartHTML);
			            }else{
			            	MimeBodyPart messageBodyPart = new MimeBodyPart();
				            messageBodyPart.setContent(notificationDtls.get("messageContent"), "text/plain; charset=utf-8");
				            multipart.addBodyPart(messageBodyPart);
			            }
			            
			            if("Y".equalsIgnoreCase(mailattachmentflag)){
			         	
				            attachmentName = notificationDtls.get("mailAttachmentFileName"); //Added by Niveditha
		
							FileDataSource fileDataSource = new FileDataSource(attachmentName);
				            MimeBodyPart attachmentPart = new MimeBodyPart();
				            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
				            attachmentPart.setFileName(fileDataSource.getName());
				            multipart.addBodyPart(attachmentPart);
						}
						
			            //message.setContent(multipart);
						
						//message.setText(notificationDtls.get("messageContent"));
						
						//message.setContent(notificationDtls.get("messageContent"), "text/html; charset=utf-8");  //Added by Niveditha for AMS-CRF-0234
	
						Transport.send(message);	
						
					
					} catch (MessagingException e) {
						common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:sendNotification) Exception "+ e.getMessage() +"\n" );
					    throw new RuntimeException(e);	
					}
				}
				if ("OL".equalsIgnoreCase(clientParameters.mail_config))
				{
					
					display = Display.getCurrent();
					
					Shell shell = new Shell(display);
					OleFrame frame = new OleFrame(shell, SWT.NONE);
					
					// This should start outlook if it is not running yet
					//OleClientSite site = new OleClientSite(frame, SWT.NONE, "OVCtl.OVCtl");
					//site.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
					
					// Now get the outlook application
					OleClientSite site2 = new OleClientSite(frame, SWT.NONE, "Outlook.Application");
					OleAutomation outlook = new OleAutomation(site2);
					
					OleAutomation mail = invoke(outlook, "CreateItem", 0 /* Mail item */).getAutomation();
					//setProperty(mail, "SendUsingAccount", username);
					setProperty(mail, "To", notificationDtls.get("contactID"));
					if ((notificationDtls.get("ccEmailID")!=null) && !(notificationDtls.get("ccEmailID").trim()).equals(""))	
						setProperty(mail, "CC", notificationDtls.get("ccEmailID"));
					
					setProperty(mail, "Subject", notificationDtls.get("subject"));
					
					String templateID = notificationDtls.get("templateID");
		            if(templateID.endsWith(".html")){
		            	setProperty(mail, "BodyFormat", 2 /* HTML */);
		            	setProperty(mail, "HtmlBody", notificationDtls.get("messageContent"));
		            }else{
		            	setProperty(mail, "BodyFormat", 1 /* Plain Text */);
		            	setProperty(mail, "Body", notificationDtls.get("messageContent"));
		            }
		            
		            attachmentName = notificationDtls.get("mailAttachmentFileName"); //Added by Niveditha
		            
		            if (null != attachmentName) {
		            	
		            	File file = new File(attachmentName);
		            	
		            	common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:sendNotification) attachmentName "+attachmentName+" file.exists() "+file.exists()+"\n");
		            	
		            	if (file.exists()) {
		        			OleAutomation attachments = getProperty(mail, "Attachments");
		        			invoke(attachments, "Add", attachmentName);
		        		}            	
				          
		            }
					invoke(mail, "Send" /*"Display" or "Send" */);
					/*
					site2 = null;
					site = null;
					frame = null;
					shell = null;
					display = null;
					*/
					
					display = null;
				}				
				common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:sendNotification) Mail Successfully Sent \n");				
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
			//common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:sendNotification) addMessagetoFile "+currentMessage +"\n" );
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
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:bulidHTTPURL) Exception "+ exp +"\n" );
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:bulidHTTPURL) URL "+ url +"\n" );
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:bulidHTTPURL) Param ["+ param +"] CurrentMatch ["+ currentMatch +"]\n" );
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
			common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processTxtTemplate) Exception "+ exp +"\n" );
		    common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		finally {
			CommonUtil.closeStream(fout);
		}
		
		return outputFile;
	}
	
	void processException(Exception exp) throws Exception
	{
		common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:processException) ProcessException "+ exp +"\n" );
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
				common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:getPointers) Exception "+ exp +"\n" );
				common.fileOutput(clientParameters.strLogFile, "(JavaMailProcessor:getPointers) Current Segment ID ["+ segmentID +"] Current Segment Field ["+ segmentField +"]\n" );
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
	
	/* Methods added for Mail Communication using direct Outlook Mail object */ 
	
	private static OleAutomation getProperty(OleAutomation auto, String name) {
        Variant varResult = auto.getProperty(property(auto, name));
        if (varResult != null && varResult.getType() != OLE.VT_EMPTY) {
            OleAutomation result = varResult.getAutomation();
            varResult.dispose();
            return result;
        }
        return null;
    }

    private static Variant invoke(OleAutomation auto, String command,
            String value) {
        return auto.invoke(property(auto, command),
                new Variant[] { new Variant(value) });
    }

    private static Variant invoke(OleAutomation auto, String command) {
        return auto.invoke(property(auto, command));
    }

    private static Variant invoke(OleAutomation auto, String command, int value) {
        return auto.invoke(property(auto, command),
                new Variant[] { new Variant(value) });
    }

    private static boolean setProperty(OleAutomation auto, String name,
            String value) {
        return auto.setProperty(property(auto, name), new Variant(value));
    }

    private static boolean setProperty(OleAutomation auto, String name,
            int value) {
        return auto.setProperty(property(auto, name), new Variant(value));
    }

    private static int property(OleAutomation auto, String name) {
        return auto.getIDsOfNames(new String[] { name })[0];
    }
}
