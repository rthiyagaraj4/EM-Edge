package eXH;

import java.io.UnsupportedEncodingException;    
import javax.xml.bind.DatatypeConverter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import java.util.Date;
import java.text.DateFormat;
import java.text.*;
import java.util.*;

public class EncodeString64 {

	public static StringBuffer htmlData = new StringBuffer();

	public static StringBuffer titleHtmlData = new StringBuffer();
	public static StringBuffer custodianHtmlData = new StringBuffer();
	public static StringBuffer patientHtmlData = new StringBuffer();
	public static StringBuffer facilityHtmlData = new StringBuffer();
	public static StringBuffer encounterHtmlData = new StringBuffer();
	public static StringBuffer authorHtmlData = new StringBuffer();
	public static StringBuffer authenticatorHtmlData = new StringBuffer();
	public static StringBuffer recipientHtmlData = new StringBuffer();
	public static StringBuffer componentHtmlData = new StringBuffer();
	public static StringBuffer summaryHtmlData = new StringBuffer();
	
	public static String tableNotesStr = "<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">"; 	
	public static String tableStr = "<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">"; 
	
	public static String tableTempStr = "<table class=\"tableTemp\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">";	
	
	public static String tableMainStr = "<table class=\"breakMainTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">";
	public static String tableMainTempStr = "<table class=\"breakMainTempTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">";
	
	public static String tableDataStr = "<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 750px\">";
	public static String tableLinearStr = "<table class=\"breakTableLC\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=450px >";
	public static String tableLineChartStr = "<table  class=\"breakTable\" valign=\"top\" align=\"left\" border=\"0\" width=400px>";
	public static String tbodyStr = "<tbody>";
	public static String trStr = "<tr class=\"breakTr\">";
	public static String trStrLC = "<tr class=\"breakTrLC\">";
	public static String trNotesStr = "<tr class=\"breakTrNotes\">";
	public static String tdHeadStr = "<td style=\"border-bottom:2px solid red\" valign=\"bottom\">";
	public static String tdGroupHeadStr = "<td style=\"border-bottom:1px solid green\" valign=\"bottom\" colspan=\"4\">";
	public static String tdSubGroupHeadStr = "<td style=\"border-bottom:1px solid green;  text-align: left\" valign=\"bottom\">";
	
	public static String tdTableHeaderStr = "<td style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=250px height=35px>";
	public static String tdTableDataStr = "<td style=\"text-align: left\" valign=\"center\" width=250px height=35px>";
	public static String tdTextStr = "<td style=\"text-align: left\" valign=\"center\" height=35px>";
	public static String tdStr = "<td valign=\"center\" height=35px>";
	public static String tdHeadWidthStr = "<td style=\"border-bottom:2px solid red\" valign=\"bottom\" width=35px>";

	public static String tdLinearLeftStr = "<td style=\"text-align: left\">";
	public static String tdLinearRightStr = "<td style=\"text-align: right\">";
	public static String tdLinearCenterStr = "<td style=\"text-align: center\">";
	public static String tdLineLeftStr = "<td style=\"text-align: left\" valign=\"top\">";
	public static String spanMainHeadStr = "<span style=\"font-family: verdana, geneva, sans-serif; color: red; font-size: 15pt; font-weight: bold;\">";
	//public static String spanMainHeadStr = "<span style=\"font-family: Gotham Book; color: red; font-size: 15pt; font-weight: bold;\">";
	public static String spanGroupHeadStr = "<span style=\"font-family: verdana, geneva, sans-serif; color: black; font-size: 14pt; font-weight: bold;\">";
	public static String spanSubGroupHeadStr = "<span style=\"font-size: 13pt; font-weight: bold;\">";
	public static String spanTextStr = "<span style=\"font-size: 12pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String spanDataStr = "<span style=\"font-size: 12pt\"><span style=\"font-family: verdana, geneva, sans-serif; color: blue;\">";

	public static String spanTableHeadStr = "<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String spanFontSize11Str = "<span style=\"font-size: 11pt\">";

	public static String spanBlackColorStr = "<span style=\"color: #000000\">";
	public static String spanColorStr = "<span style=\"color: #808080\">";
	public static String spanFontFamStr = "<span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String cspanStr = "</span>";
	public static String tdNormalStr = "<td>";
	public static String tdValignStr = "<td valign=\"top\">";
	public static String ctdStr = "</td>";
	public static String ctrStr = "</tr>";
	public static String ctbodyStr = "</tbody>";
	public static String ctableStr = "</table>";
	public static String spaceStr = "&nbsp;";
	public static String brStr = "<br>";
	public static String strongStr = "<strong>";
	public static String cStrongStr = "</strong>";
	
	public static String theadStr = "<thead>";
	public static String ctheadStr = "</thead>";
	
	public static String trTableStr = "<tr class=\"breakTr\">";

	public static String thStr = "<th>";
	public static String cthStr = "</th>";	
	
	public static String tfootStr = "<tfoot>";
	public static String ctfootStr = "</tfoot>";	

    public static void main(String[] args) throws UnsupportedEncodingException {
		
		// Referral XML Data
		String str = "<ClinicalDocument xmlns='urn:hl7-org:v3'><typeId extension=\"POCD_HD000040\" root=\"2.16.840.1.113883.1.3\" /><templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.1.2\"/> <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.1.3\"/><id root=\" \" extension=\" \"/><code code=\"57133-1\" displayName=\"Referral Note\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><title>Referral Summary</title><effectiveTime value=\"20160601162005\"/><confidentialityCode code=\"R\" displayName=\"Restricted\" codeSystem=\"2.16.840.1.113883.5.25\" codeSystemName=\"Confidentiality\" /><languageCode code=\"en-US\"/><custodian> <assignedCustodian> <representedCustodianOrganization> <id root=\"2.16.458.1.100000.1\"/> <name>Women and Child Hospital</name> </representedCustodianOrganization> </assignedCustodian> </custodian><recordTarget><patientRole><id extension=\"WC00000500\" root=\"2.16.458.1.100000.1\" /><addr use=\"H\"><streetAddressLine>BATU 27/72, SEKSYEN 27</streetAddressLine><city>Shah Alam</city><state>Selangor</state><postalCode>40400</postalCode></addr><telecom value=\"60351910709\" use=\"H\" /><telecom value=\"60351910709\" use=\"MC\" /><patient><name><given>Diganta</given><family>Pramanik</family><suffix>Mast.</suffix></name><administrativeGenderCode code=\"M\" /><birthTime value=\"20010319\" /><raceCode displayName=\"Melayu\" /></patient><providerOrganization><id root=\"2.16.458.1.100000.1\">      </id><name>Women and Child Hospital</name></providerOrganization></patientRole></recordTarget><componentOf> <encompassingEncounter> <id extension=\"IP0001\" root=\"2.16.458.1.100000.1\"/> <effectiveTime> <low value=\"20160530\"/> <high value=\"20160601\"/> </effectiveTime> <encounterParticipant typeCode=\"CONS\"> <time value=\"20160530040516\"/> <assignedEntity> <id extension=\"MMC\" root=\"2.16.458.1.100000.1\"/> <assignedPerson> <name> <given>DR SULAIMAN</given> <family></family> <suffix>MD</suffix> </name></assignedPerson> <representedOrganization> <id extension=\"\" root=\"2.16.458.1.100000.1\"/> </representedOrganization> </assignedEntity> </encounterParticipant> <location> <healthCareFacility classCode=\"DSDLOC\"> <code code=\"GIM\" codeSystem=\"2.16.840.1.113883.5.111\" displayName=\"General internal medicine clinic\"/> </healthCareFacility> </location> </encompassingEncounter> </componentOf><author> <time value=\"20160601162004\"/> <assignedAuthor> <id extension=\"MMC\" root=\"2.16.458.1.100000.1\"/> <code code=\"LP172946-8\" displayName=\"General medicine\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> <functionCode code=\"LP173085-4\" displayName=\"Physician attending\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> <assignedPerson> <name> <given>DR SULAIMAN</given> <family/> <suffix>MD</suffix> </name> </assignedPerson> <representedOrganization> <id extension=\"\" root=\"2.16.458.1.100000.1\"/> <name>HOSPITAL</name> </representedOrganization> </assignedAuthor> </author><legalAuthenticator> <time value=\"20160205012005\"/> <assignedEntity> <id extension=\"MMC\" root=\"2.16.458.1.100000.1\"/> <assignedPerson> <name> <given>DR SULAIMAN</given> <family/> <suffix>MD</suffix> </name> </assignedPerson> <representedOrganization> <id root=\"2.16.458.1.100000.1\"/> <name>HOSPITAL</name> </representedOrganization> </assignedEntity> </legalAuthenticator><informationRecipient> <templateId root=\"1.3.6.1.4.1.19376.1.3.3.1.4\"/> <intendedRecipient> <receivedOrganization> <id extension=\"\" root=\"1.3.6.1.4.1.19376.1.3.4\"/> <name>Good Health Clinic</name> <telecom value=\"tel:404-639-3535\"/> <addr> <streetAddressLine>1600 Clifton Road</streetAddressLine> <city>Atlanta</city> <state>GA</state> <postalCode>30333</postalCode> </addr> </receivedOrganization> </intendedRecipient> </informationRecipient><component><structuredBody><component><section><templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.1\"/><id root=\" \" extension=\" \"/><code code=\"42349-1\" displayName=\"REASON FOR REFERRAL\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><text>Text as described above</text></section></component><component><section> <templateId root=\"2.16.840.1.113883.10.20.1.2\"/> <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.13\"/><id root=\" \" extension=\" \"/><code code=\"4875-2\" displayName=\"ALLERGIES, ADVERSE REACTIONS, ALERTS\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><text>Allergic to Pencillin</text></section></component><component><section><templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.3\"/><id root=\" \" extension=\" \"/><code code=\"46241-6\" displayName=\"HOSPITAL ADMISSION DX\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><text>Diagnosis: Fever, Unspecified, Onset date: 30/05/2016</text></section></component></structuredBody></component></ClinicalDocument>";

		// Discharge Summary
		//String str = "<ClinicalDocument xmlns='urn:hl7-org:v3'><typeId extension=\"POCD_HD000040\" root=\"2.16.840.1.113883.1.3\" /><templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.1.2\"/> <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.1.4\"/><id root=\"2.16.458.1.100000.1\" extension=\"2\" /><code code=\"18842-5\" displayName=\"Discharge Summary\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><title>Discharge Summary</title><effectiveTime value=\"20160601162005\"/><confidentialityCode code=\"N\" displayName=\"Normal\" codeSystem=\"2.16.840.1.113883.5.25\" codeSystemName=\"Confidentiality\" /><languageCode code=\"en-US\"/><custodian> <assignedCustodian> <representedCustodianOrganization> <id root=\"2.16.458.1.100000.1\"/> <name>Women and Child Hospital</name> </representedCustodianOrganization> </assignedCustodian> </custodian><recordTarget><patientRole><id extension=\"WC00000500\" root=\"2.16.458.1.100000.1\" /><addr use=\"H\"><streetAddressLine>BATU 27/72, SEKSYEN 27</streetAddressLine><city>Shah Alam</city><state>Selangor</state><postalCode>40400</postalCode></addr><telecom value=\"60351910709\" use=\"H\" /><telecom value=\"60351910709\" use=\"MC\" /><patient><name><given>Diganta</given><family>Pramanik</family><suffix>Mast.</suffix></name><administrativeGenderCode code=\"M\" /><birthTime value=\"20010319\" /><raceCode displayName=\"Melayu\" /></patient><providerOrganization><id root=\"2.16.458.1.100000.1\">      </id><name>Women and Child Hospital</name></providerOrganization></patientRole></recordTarget><componentOf> <encompassingEncounter> <id extension=\"IP0001\" root=\"2.16.458.1.100000.1\"/> <effectiveTime> <low value='20160530'/> <high value='20160601'/> </effectiveTime> <encounterParticipant typeCode=\"CONS\"> <time value=\"20160530040516\"/> <assignedEntity> <id extension=\"MMC\" root=\"2.16.458.1.100000.1\"/> <assignedPerson> <name> <given>DR SULAIMAN</given> <family></family> <suffix>MD</suffix> </name></assignedPerson> <representedOrganization> <id extension=\"\" root=\"2.16.458.1.100000.1\"/> </representedOrganization> </assignedEntity> </encounterParticipant> <location> <healthCareFacility classCode=\"DSDLOC\"> <code code=\"GIM\" codeSystem=\"2.16.840.1.113883.5.111\" displayName=\"General internal medicine clinic\"/> </healthCareFacility> </location> </encompassingEncounter> </componentOf><author> <time value=\"20160601162004\"/> <assignedAuthor> <id extension=\"MMC\" root=\"2.16.458.1.100000.1\"/> <code code=\"LP172946-8\" displayName=\"General medicine\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> <functionCode code=\"LP173085-4\" displayName=\"Physician attending\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> <assignedPerson> <name> <given>DR SULAIMAN</given> <family/> <suffix>MD</suffix> </name> </assignedPerson> <representedOrganization> <id extension=\"\" root=\"2.16.458.1.100000.1\"/> <name>HOSPITAL</name> </representedOrganization> </assignedAuthor> </author><legalAuthenticator> <time value=\"20160205012005\"/> <assignedEntity> <id extension=\"MMC\" root=\"2.16.458.1.100000.1\"/> <assignedPerson> <name> <given>DR SULAIMAN</given> <family/> <suffix>MD</suffix> </name> </assignedPerson> <representedOrganization> <id root=\"2.16.458.1.100000.1\"/> <name>HOSPITAL</name> </representedOrganization> </assignedEntity> </legalAuthenticator><component><structuredBody><component><section> <templateId root=\"2.16.840.1.113883.10.20.1.2\"/><templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.13\"/><id root=\" \" extension=\" \"/><code code=\"4875-2\" displayName=\"ALLERGIES, ADVERSE REACTIONS, ALERTS\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><text>Allergic to Pencillin</text></section></component><component><section><templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.3\"/><id root=\" \" extension=\" \"/><code code=\"46241-6\" displayName=\"HOSPITAL ADMISSION DX\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\"/><text>Diagnosis: Fever, Unspecified, Onset date: 30/05/2016</text></section></component></structuredBody></component></ClinicalDocument>";
		
       
        // encode data using BASE64
        String encoded = DatatypeConverter.printBase64Binary(str.getBytes());
        System.out.println("encoded value is \t" + encoded);

        // Decode data 		
        String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        System.out.println("decoded value is \t" + decoded);

		summaryHtmlData = getXMLData(decoded);

    }

	public static StringBuffer getXMLData(String xmlData) {

		List<Element> elementList = null;
		List<Element> componentList = null;
		
		Element clinicalDocumentNode = null; // Full Document Details
		Element elementNode = null; // Full Document Details

		String[][] titleData = null;	
		String[][] patientData = null;	
		String[][] facilityData = null;	
		String[][] encounterData = null;	
		String[][] authorData = null;	
		String[][] authenticatorData = null;
		String[][] recipientData = null;
		String[][] componentData = null;	

		Element recordTargetNode = null; // Patient Details
		Element custodianNode = null; // facility Details
		Element componentOfNode = null; // Encounter Details
		Element authorNode = null; // Attended By Doctor Details
		Element authenticatorNode = null; // Authenticated by Doctor Details
		Element componentNode = null; // facility Details		
		
		SAXBuilder builder = new SAXBuilder();	
		
		InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlData));    
	 
		try {			
	 
			Document document = (Document) builder.build(is);			
			clinicalDocumentNode = document.getRootElement();
			
			System.out.println(" RootNode ::: "+clinicalDocumentNode);

			elementList = clinicalDocumentNode.getChildren();			
			for (int i = 0; i < elementList.size(); i++) {
				elementNode = (Element) elementList.get(i);
				System.out.println(" :::::::::::::: Element Node Name :::::::::::::: "+elementNode.getName());
				if (elementNode.getName().equalsIgnoreCase("title")){
					titleHtmlData = new StringBuffer();
					titleData = returnTitleData(elementNode);	
					titleHtmlData = drawTitleData(titleData);					
				}

				if (elementNode.getName().equalsIgnoreCase("custodian")){
					facilityHtmlData = new StringBuffer();;
					facilityData = returnCustodianData(elementNode);	
					facilityHtmlData = drawTitleData(facilityData);				
				}

				if (elementNode.getName().equalsIgnoreCase("recordTarget")){
					patientHtmlData = new StringBuffer();
					patientData = returnPatientData(elementNode);	
					patientHtmlData = drawPatientData(patientData);
				}			
				
				if (elementNode.getName().equalsIgnoreCase("componentof")){
					encounterHtmlData = new StringBuffer();;
					encounterData = returnEncounterData(elementNode);	
					encounterHtmlData = drawEncounterData(encounterData);
				}
				if (elementNode.getName().equalsIgnoreCase("author")){
					authorHtmlData = new StringBuffer();;
					authorData = returnAuthorData(elementNode);	
					authorHtmlData = drawAuthorData(authorData, 1);
				}
				if (elementNode.getName().equalsIgnoreCase("legalAuthenticator")){
					authenticatorHtmlData = new StringBuffer();;
					authenticatorData = returnAuthorData(elementNode);	
					authenticatorHtmlData = drawAuthorData(authenticatorData, 2);
				}
				if (elementNode.getName().equalsIgnoreCase("informationRecipient")){
					recipientHtmlData = new StringBuffer();;
					recipientData = returnRecipientData(elementNode);	
					recipientHtmlData = drawRecipientData(recipientData);
				}
				if (elementNode.getName().equalsIgnoreCase("component")){
					componentHtmlData = new StringBuffer();;
					componentData = returnComponentData(elementNode);	
					componentHtmlData = drawComponentData(componentData);
				}
				

			}		
	 
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		if (titleHtmlData.length() > 0)
			{					
				htmlData.append(titleHtmlData);
			}
			if (facilityHtmlData.length() > 0)
			{					
				htmlData.append(facilityHtmlData);
			}
			if (patientHtmlData.length() > 0)
			{					
				htmlData.append(patientHtmlData);
			}
			if (encounterHtmlData.length() > 0)
			{					
				htmlData.append(encounterHtmlData);
			}
			if (authorHtmlData.length() > 0)
			{					
				htmlData.append(authorHtmlData);
			}
			if (authenticatorHtmlData.length() > 0)
			{					
				htmlData.append(authenticatorHtmlData);
			}
			if (recipientHtmlData.length() > 0)
			{					
				htmlData.append(recipientHtmlData);
			}
			if (componentHtmlData.length() > 0)
			{					
				htmlData.append(componentHtmlData);
			}

		System.out.println(" HTML ::: "+htmlData);

		return htmlData;
	}

	public static String[][] returnTitleData(Element Node)
	{
		String[][] titleDataArray = null;		

		titleDataArray = new String[1][2];

		titleDataArray[0][0] = "Title";
		titleDataArray[0][1] = Node.getText();

		System.out.println(titleDataArray[0][0] +" ::: "+ titleDataArray[0][1]);

		return titleDataArray;
	}
	
	public static String[][] returnCustodianData(Element Node)
	{
		String[][] custodianDataArray = null;
		
		List<Element> custodianList = null;
		Element custodianNode = null;

		List<Element> assignedCustodianList = null;
		Element assignedCustodianNode = null;

		List<Element> repCustodianList = null;
		Element repCustodianNode = null;
		
		custodianList = Node.getChildren();
		
		int n = 0;

		custodianDataArray = new String[1][2];

		for (int i=0;i<custodianList.size();i++)
		{
			custodianNode = (Element) custodianList.get(i);		
			
			if (custodianNode.getName().equalsIgnoreCase("assignedCustodian"))
			{
				assignedCustodianList = custodianNode.getChildren();

				for (int j=0;j<assignedCustodianList.size();j++)
				{
					assignedCustodianNode = (Element) assignedCustodianList.get(j);			

					if (assignedCustodianNode.getName().equalsIgnoreCase("representedCustodianOrganization"))
					{
						repCustodianList = assignedCustodianNode.getChildren();
						for (int k=0;k<repCustodianList.size();k++)
						{
							repCustodianNode = (Element) repCustodianList.get(k);

							if (repCustodianNode.getName().equalsIgnoreCase("name")){
								custodianDataArray[0][0] = "Custodian";
								custodianDataArray[0][1] = repCustodianNode.getText();				
								System.out.println(custodianDataArray[0][0] +" ::: "+ custodianDataArray[0][1]);
							}
						}						
					}					
				}
			}
		}
		return custodianDataArray;
	}



	public static String[][] returnPatientData(Element Node){
		String[][] patientDataArray = null;
		List<Element> patientList = null;
		Element patientRoleNode = null;

		List<Element> patientDataList = null;
		Element patientDataNode = null;

		List<Element> addressList = null;
		Element addressDataNode = null;

		List<Element> telecomList = null;
		Element telecomNode = null;

		List<Element> patientNameList = null;
		Element patientNameNode = null;
		
		List<Element> patientNameDetailsList = null;
		Element patientNameDetailsNode = null;

		List<Element> providerList = null;
		Element providerNode = null;

		patientList = Node.getChildren();
		
		int n = 0;

		patientDataArray = new String[14][2];

		for (int i=0;i<patientList.size();i++)
		{
			patientRoleNode = (Element) patientList.get(i);		
			
			if (patientRoleNode.getName().equalsIgnoreCase("patientRole"))
			{
				patientDataList = patientRoleNode.getChildren();

				for (int j=0;j<patientDataList.size();j++)
				{
					patientDataNode = (Element) patientDataList.get(j);			

					if (patientDataNode.getName().equalsIgnoreCase("id")){
						patientDataArray[0][0] = "PatientID";
						patientDataArray[0][1] = patientDataNode.getAttribute("extension").getValue();				
						System.out.println(patientDataArray[0][0] +" ::: "+ patientDataArray[0][1]);
					}
					if (patientDataNode.getName().equalsIgnoreCase("addr"))
					{
						addressList = patientDataNode.getChildren();
						for (int k=0;k<addressList.size();k++)
						{
							n = n + 1;
							addressDataNode = (Element) addressList.get(k);		
							
							if (addressDataNode.getName().equalsIgnoreCase("streetAddressLine")){
								patientDataArray[n][0] = "StreetAddress";
								patientDataArray[n][1] = addressDataNode.getText();
								System.out.println(patientDataArray[1][0] +" ::: "+ patientDataArray[1][1]);
							}
							if (addressDataNode.getName().equalsIgnoreCase("city")){
								patientDataArray[n][0] = "City";
								patientDataArray[n][1] = addressDataNode.getText();
								System.out.println(patientDataArray[2][0] +" ::: "+ patientDataArray[2][1]);
							}
							if (addressDataNode.getName().equalsIgnoreCase("state")){
								patientDataArray[n][0] = "State";
								patientDataArray[n][1] = addressDataNode.getText();
								System.out.println(patientDataArray[3][0] +" ::: "+ patientDataArray[3][1]);
							}
							if (addressDataNode.getName().equalsIgnoreCase("postalCode")){
								patientDataArray[n][0] = "PostalCode";
								patientDataArray[n][1] = addressDataNode.getText();
								System.out.println(patientDataArray[4][0] +" ::: "+ patientDataArray[4][1]);
							}

						}

					}
					if (patientDataNode.getName().equalsIgnoreCase("telecom")){

						if (patientDataNode.getAttribute("use").getValue().equalsIgnoreCase("H"))
						{
							n=n+1;
							patientDataArray[n][0] = "Home";
							patientDataArray[n][1] = patientDataNode.getAttribute("value").getValue();				
							System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
						}
						if (patientDataNode.getAttribute("use").getValue().equalsIgnoreCase("MC"))
						{
							n=n+1;
							patientDataArray[n][0] = "Mobile";
							patientDataArray[n][1] = patientDataNode.getAttribute("value").getValue();				
							System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
						}						
					}

					if (patientDataNode.getName().equalsIgnoreCase("patient"))
					{
						patientNameList = patientDataNode.getChildren();
						for (int k=0;k<patientNameList.size();k++)
						{
							patientNameNode = (Element) patientNameList.get(k);		
							if (patientNameNode.getName().equalsIgnoreCase("name"))
							{
								patientNameDetailsList = patientNameNode.getChildren();
								for (int l=0;l<patientNameDetailsList.size();l++)
								{
									patientNameDetailsNode = (Element) patientNameDetailsList.get(l);	

									if (patientNameDetailsNode.getName().equalsIgnoreCase("given")){
										n = n + 1;
										patientDataArray[n][0] = "Given";
										patientDataArray[n][1] = patientNameDetailsNode.getText();
										System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
									}
									
									if (patientNameDetailsNode.getName().equalsIgnoreCase("family")){
										n = n + 1;
										patientDataArray[n][0] = "Family";
										patientDataArray[n][1] = patientNameDetailsNode.getText();
										System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
									}

									if (patientNameDetailsNode.getName().equalsIgnoreCase("suffix")){
										n = n + 1;
										patientDataArray[n][0] = "Suffix";
										patientDataArray[n][1] = patientNameDetailsNode.getText();
										System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
									}
								}
							}
							if (patientNameNode.getName().equalsIgnoreCase("administrativeGenderCode")){
								n=n+1;
								patientDataArray[n][0] = "Gender";
								patientDataArray[n][1] = patientNameNode.getAttribute("code").getValue();				
								System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
							}
							if (patientNameNode.getName().equalsIgnoreCase("birthTime")){								
								n=n+1;
								patientDataArray[n][0] = "BirthDate";
								patientDataArray[n][1] = formatDateString(patientNameNode.getAttribute("value").getValue());				
								System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
							}
							if (patientNameNode.getName().equalsIgnoreCase("raceCode")){
								n=n+1;
								patientDataArray[n][0] = "Race";
								patientDataArray[n][1] = patientNameNode.getAttribute("displayName").getValue();				
								System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
							}
						}
					}
					if (patientDataNode.getName().equalsIgnoreCase("providerOrganization"))
					{
						providerList = patientDataNode.getChildren();

						for (int k=0;k<providerList.size();k++ )
						{
							providerNode = (Element) providerList.get(k);	
							if (providerNode.getName().equalsIgnoreCase("name"))
							{
								n=n+1;
								patientDataArray[n][0] = "Provider";
								patientDataArray[n][1] = providerNode.getText();				
								System.out.println(patientDataArray[n][0] +" ::: "+ patientDataArray[n][1]);
							}
						}						
					}
				}
			}
		}
		return patientDataArray;
	}

	public static String[][] returnEncounterData(Element Node){
		String[][] encounterDataArray = null;

		List<Element> componentOfList = null;
		Element componentOfNode = null;

		List<Element> encompassingEncounterList = null;
		Element encompassingEncounterNode = null;

		List<Element> encounterNodeChildList = null;
		Element encounterNodeChild = null;

		List<Element> effectiveTimeChildList = null;
		Element effectiveTimeNodeChild = null;

		List<Element> effectiveTimeDataChildList = null;
		Element effectiveTimeDataNodeChild = null;

		List<Element> encounterPartChildList = null;
		Element encounterPartChildNode = null;

		List<Element> locationChildList = null;
		Element locationChildNode = null;

		List<Element> healthCareChildList = null;
		Element healthCareChildNode = null;

		List<Element> assignedEntityChildList = null;
		Element assignedEntityChildNode = null;

		List<Element> consNameChildList = null;
		Element consNameChildNode = null;
		
		List<Element> consNameDetailsChildList = null;
		Element consNameDetailsChildNode = null;

		encompassingEncounterList = Node.getChildren();
		
		int n = 0;

		encounterDataArray = new String[7][2];

		for (int i=0;i<encompassingEncounterList.size();i++)
		{
			encompassingEncounterNode = (Element) encompassingEncounterList.get(i);		
			
			if (encompassingEncounterNode.getName().equalsIgnoreCase("encompassingEncounter"))
			{
				encounterNodeChildList = encompassingEncounterNode.getChildren();

				for (int j=0;j<encounterNodeChildList.size();j++)
				{
					encounterNodeChild = (Element) encounterNodeChildList.get(j);			

					if (encounterNodeChild.getName().equalsIgnoreCase("effectiveTime"))
					{
						effectiveTimeChildList = encounterNodeChild.getChildren();
						for (int k=0;k<effectiveTimeChildList.size();k++)
						{
							
							effectiveTimeNodeChild = (Element) effectiveTimeChildList.get(k);		
							if (effectiveTimeNodeChild.getName().equalsIgnoreCase("low")){
								encounterDataArray[n][0] = "AdmissionDate";
								encounterDataArray[n][1] = formatDateString(effectiveTimeNodeChild.getAttribute("value").getValue());
								System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
							}
							if (effectiveTimeNodeChild.getName().equalsIgnoreCase("high")){
								n = n + 1;
								encounterDataArray[n][0] = "DischargeDate";
								encounterDataArray[n][1] = formatDateString(effectiveTimeNodeChild.getAttribute("value").getValue());
								System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
							}
						}
					}
					if (encounterNodeChild.getName().equalsIgnoreCase("encounterParticipant"))
					{
						encounterPartChildList =  encounterNodeChild.getChildren();
						for (int k=0;k<encounterPartChildList.size();k++)
						{
							encounterPartChildNode = (Element) encounterPartChildList.get(k);
							if (encounterPartChildNode.getName().equalsIgnoreCase("time")){
								n = n + 1;
								encounterDataArray[n][0] = "ConsultationTime";
								encounterDataArray[n][1] = formatDateTimeString(encounterPartChildNode.getAttribute("value").getValue());
								System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
							}
							if (encounterPartChildNode.getName().equalsIgnoreCase("assignedEntity"))
							{
								assignedEntityChildList = encounterPartChildNode.getChildren();
								for (int l=0;l<assignedEntityChildList.size();l++)
								{
									assignedEntityChildNode = (Element) assignedEntityChildList.get(l);
									if (assignedEntityChildNode.getName().equalsIgnoreCase("assignedPerson"))
									{

										consNameChildList = assignedEntityChildNode.getChildren();
										for (int m=0;m<consNameChildList.size();m++)
										{
											consNameChildNode = (Element) consNameChildList.get(m);		
											
											if (consNameChildNode.getName().equalsIgnoreCase("name"))
											{
												consNameDetailsChildList = consNameChildNode.getChildren();
												for (int o=0;o<consNameDetailsChildList.size();o++)
												{
													consNameDetailsChildNode = (Element) consNameDetailsChildList.get(o);	
													
													if (consNameDetailsChildNode.getName().equalsIgnoreCase("given")){
														n = n + 1;
														encounterDataArray[n][0] = "Given";
														encounterDataArray[n][1] = consNameDetailsChildNode.getText();
														System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
													}
													
													if (consNameDetailsChildNode.getName().equalsIgnoreCase("family")){
														n = n + 1;
														encounterDataArray[n][0] = "Family";
														encounterDataArray[n][1] = consNameDetailsChildNode.getText();
														System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
													}

													if (consNameDetailsChildNode.getName().equalsIgnoreCase("suffix")){
														n = n + 1;
														encounterDataArray[n][0] = "Suffix";
														encounterDataArray[n][1] = consNameDetailsChildNode.getText();
														System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
													}
												}
											}
										}										
									}
								}
							}
						}
					}
					if (encounterNodeChild.getName().equalsIgnoreCase("location"))
					{
						locationChildList =  encounterNodeChild.getChildren();
						for (int k=0;k<locationChildList.size();k++)
						{
							locationChildNode = (Element) locationChildList.get(k);

							if (locationChildNode.getName().equalsIgnoreCase("healthCareFacility"))
							{
								healthCareChildList =  locationChildNode.getChildren();
								for (int l=0;l<healthCareChildList.size();l++)
								{
									healthCareChildNode = (Element) healthCareChildList.get(l);

									if (healthCareChildNode.getName().equalsIgnoreCase("code"))
									{
										n = n + 1;
										encounterDataArray[n][0] = "LocationCode";
										encounterDataArray[n][1] = healthCareChildNode.getAttribute("code").getValue() + " - " + healthCareChildNode.getAttribute("displayName").getValue();
										System.out.println(encounterDataArray[n][0] +" ::: "+ encounterDataArray[n][1]);
									}
								}
							}

						}
					}					
				}
			}
		}
		return encounterDataArray;
	}

	public static String[][] returnAuthorData(Element Node){
		String[][] authorDataArray = null;

		List<Element> authorChildList = null;
		Element authorChildNode = null;		

		List<Element> encounterPartChildList = null;
		Element encounterPartChildNode = null;

		List<Element> locationChildList = null;
		Element locationChildNode = null;

		List<Element> healthCareChildList = null;
		Element healthCareChildNode = null;

		List<Element> assignedEntityChildList = null;
		Element assignedEntityChildNode = null;

		List<Element> nameChildList = null;
		Element nameChildNode = null;
		
		List<Element> nameDetailsChildList = null;
		Element nameDetailsChildNode = null;

		List<Element> orgChildList = null;
		Element orgChildNode = null;


		authorChildList = Node.getChildren();
		
		int n = 0;

		if (Node.getName().equalsIgnoreCase("author"))
		{
			authorDataArray = new String[7][2];
		}
		else if (Node.getName().equalsIgnoreCase("legalAuthenticator"))
		{
			authorDataArray = new String[5][2];
		}


		for (int k=0;k<authorChildList.size();k++ )
		{
			authorChildNode = (Element) authorChildList.get(k);

			if (authorChildNode.getName().equalsIgnoreCase("time"))
			{
				authorDataArray[0][0] = "Date" ;
				authorDataArray[0][1] = formatDateTimeString(authorChildNode.getAttribute("value").getValue());
				System.out.println(authorDataArray[0][0] +" ::: "+ authorDataArray[0][1]);
			}
			if ((authorChildNode.getName().equalsIgnoreCase("assignedEntity")) || (authorChildNode.getName().equalsIgnoreCase("assignedAuthor")))
			{
				assignedEntityChildList = authorChildNode.getChildren();
				for (int l=0;l<assignedEntityChildList.size();l++)
				{
					assignedEntityChildNode = (Element) assignedEntityChildList.get(l);

					if (authorChildNode.getName().equalsIgnoreCase("assignedAuthor"))
					{
						if (assignedEntityChildNode.getName().equalsIgnoreCase("code"))
						{
							n = n + 1;
							authorDataArray[n][0] = "Speciality" ;
							authorDataArray[n][1] = assignedEntityChildNode.getAttribute("displayName").getValue();
							System.out.println(authorDataArray[n][0] +" ::: "+ authorDataArray[n][1]);
						}
						if (assignedEntityChildNode.getName().equalsIgnoreCase("functionCode"))
						{
							n = n + 1;
							authorDataArray[n][0] = "PractitionerType" ;
							authorDataArray[n][1] = assignedEntityChildNode.getAttribute("displayName").getValue();
							System.out.println(authorDataArray[n][0] +" ::: "+ authorDataArray[n][1]);
						}
					}
					
					if (assignedEntityChildNode.getName().equalsIgnoreCase("assignedPerson"))
					{

						nameChildList = assignedEntityChildNode.getChildren();
						for (int m=0;m<nameChildList.size();m++)
						{
							nameChildNode = (Element) nameChildList.get(m);		
							
							if (nameChildNode.getName().equalsIgnoreCase("name"))
							{
								nameDetailsChildList = nameChildNode.getChildren();
								for (int o=0;o<nameDetailsChildList.size();o++)
								{
									nameDetailsChildNode = (Element) nameDetailsChildList.get(o);	
									
									if (nameDetailsChildNode.getName().equalsIgnoreCase("given")){
										n = n + 1;
										authorDataArray[n][0] = "Given";
										authorDataArray[n][1] = nameDetailsChildNode.getText();
										System.out.println(authorDataArray[n][0] +" ::: "+ authorDataArray[n][1]);
									}
									
									if (nameDetailsChildNode.getName().equalsIgnoreCase("family")){
										n = n + 1;
										authorDataArray[n][0] = "Family";
										authorDataArray[n][1] = nameDetailsChildNode.getText();
										System.out.println(authorDataArray[n][0] +" ::: "+ authorDataArray[n][1]);
									}

									if (nameDetailsChildNode.getName().equalsIgnoreCase("suffix")){
										n = n + 1;
										authorDataArray[n][0] = "Suffix";
										authorDataArray[n][1] = nameDetailsChildNode.getText();
										System.out.println(authorDataArray[n][0] +" ::: "+ authorDataArray[n][1]);
									}
								}
							}
						}										
					}
					if (assignedEntityChildNode.getName().equalsIgnoreCase("representedOrganization"))
					{
						orgChildList = assignedEntityChildNode.getChildren();
						for (int m=0;m<orgChildList.size();m++)
						{
							orgChildNode = (Element) orgChildList.get(m);

							if (orgChildNode.getName().equalsIgnoreCase("name")){
								n = n + 1;
								authorDataArray[n][0] = "FacilityName";
								authorDataArray[n][1] = orgChildNode.getText();
								System.out.println(authorDataArray[n][0] +" ::: "+ authorDataArray[n][1]);
							}

						}

					}
				}
			}
		}	
					
		return authorDataArray;
	}

	public static String[][] returnRecipientData(Element Node)
	{
		String[][] recipientDataArray = null;
		
		List<Element> recipientChildList = null;
		Element recipientChildNode = null;

		List<Element> intendedRecipientChildList = null;
		Element intendedRecipientChildNode = null;

		List<Element> receivedOrgChildList = null;
		Element receivedOrgChildNode = null;

		List<Element> addrChildList = null;
		Element addrChildNode = null;
		
		recipientChildList = Node.getChildren();
		
		int n = 0;

		recipientDataArray = new String[6][2];

		for (int i=0;i<recipientChildList.size();i++)
		{
			recipientChildNode = (Element) recipientChildList.get(i);		
			
			if (recipientChildNode.getName().equalsIgnoreCase("intendedRecipient"))
			{
				intendedRecipientChildList = recipientChildNode.getChildren();

				for (int j=0;j<intendedRecipientChildList.size();j++)
				{
					intendedRecipientChildNode = (Element) intendedRecipientChildList.get(j);			

					if (intendedRecipientChildNode.getName().equalsIgnoreCase("receivedOrganization"))
					{
						receivedOrgChildList = intendedRecipientChildNode.getChildren();
						for (int k=0;k<receivedOrgChildList.size();k++)
						{
							receivedOrgChildNode = (Element) receivedOrgChildList.get(k);

							if (receivedOrgChildNode.getName().equalsIgnoreCase("name")){
								recipientDataArray[0][0] = "RecipientHospital";
								recipientDataArray[0][1] = receivedOrgChildNode.getText();				
								System.out.println(recipientDataArray[0][0] +" ::: "+ recipientDataArray[0][1]);
							}
							if (receivedOrgChildNode.getName().equalsIgnoreCase("telecom")){
								n = n + 1;
								recipientDataArray[n][0] = "Telephone";
								recipientDataArray[n][1] = receivedOrgChildNode.getAttribute("value").getValue();				
								System.out.println(recipientDataArray[n][0] +" ::: "+ recipientDataArray[n][1]);
							}
							if (receivedOrgChildNode.getName().equalsIgnoreCase("addr"))
							{
								addrChildList = receivedOrgChildNode.getChildren();
								for (int l=0;l<addrChildList.size();l++)
								{
									addrChildNode = (Element) addrChildList.get(l);
									if (addrChildNode.getName().equalsIgnoreCase("streetAddressLine"))
									{
										n = n + 1;
										recipientDataArray[n][0] = "Street";
										recipientDataArray[n][1] = addrChildNode.getText();				
										System.out.println(recipientDataArray[n][0] +" ::: "+ recipientDataArray[n][1]);
									}
									if (addrChildNode.getName().equalsIgnoreCase("city"))
									{
										n = n + 1;
										recipientDataArray[n][0] = "City";
										recipientDataArray[n][1] = addrChildNode.getText();				
										System.out.println(recipientDataArray[n][0] +" ::: "+ recipientDataArray[n][1]);
									}
									if (addrChildNode.getName().equalsIgnoreCase("state"))
									{
										n = n + 1;
										recipientDataArray[n][0] = "State";
										recipientDataArray[n][1] = addrChildNode.getText();				
										System.out.println(recipientDataArray[n][0] +" ::: "+ recipientDataArray[n][1]);
									}
									if (addrChildNode.getName().equalsIgnoreCase("postalCode"))
									{
										n = n + 1;
										recipientDataArray[n][0] = "PostalCode";
										recipientDataArray[n][1] = addrChildNode.getText();				
										System.out.println(recipientDataArray[n][0] +" ::: "+ recipientDataArray[n][1]);
									}
								}
							}
						}						
					}					
				}
			}
		}
		return recipientDataArray;
	}

	public static String[][] returnComponentData(Element Node)
	{
		String[][] componentDataArray = null;
		
		List<Element> componentChildList = null;
		Element componentChildNode = null;

		List<Element> structuredBodyChildList = null;
		Element structuredBodyChildNode = null;

		List<Element> componentDataChildList = null;
		Element componentDataChildNode = null;

		List<Element> sectionDataChildList = null;
		Element sectionDataChildNode = null;
		
		componentChildList = Node.getChildren();
		
		int n = -1;

		int componentCount = 0;

		for (int i=0;i<componentChildList.size();i++)
		{
			componentChildNode = (Element) componentChildList.get(i);	
			
			if (componentChildNode.getName().equalsIgnoreCase("structuredBody"))
			{
				structuredBodyChildList = componentChildNode.getChildren();
				componentCount = structuredBodyChildList.size();
				
			}
		}
		
		componentDataArray = new String[componentCount*2][2];

		for (int i=0;i<componentChildList.size();i++)
		{
			componentChildNode = (Element) componentChildList.get(i);	
			
			if (componentChildNode.getName().equalsIgnoreCase("structuredBody"))
			{
				structuredBodyChildList = componentChildNode.getChildren();
				for (int j=0;j<structuredBodyChildList.size();j++)
				{
					structuredBodyChildNode = (Element) structuredBodyChildList.get(j);	
					
					if (structuredBodyChildNode.getName().equalsIgnoreCase("component"))
					{
						componentDataChildList = structuredBodyChildNode.getChildren();
						for (int k=0;k<componentDataChildList.size();k++)
						{
							componentDataChildNode = (Element) componentDataChildList.get(k);

							if (componentDataChildNode.getName().equalsIgnoreCase("section"))
							{
								sectionDataChildList = componentDataChildNode.getChildren();
								for (int l=0;l<sectionDataChildList.size();l++)
								{
									sectionDataChildNode = (Element) sectionDataChildList.get(l);

									if (sectionDataChildNode.getName().equalsIgnoreCase("code")){
										n = n + 1;
										componentDataArray[n][0] = "Title";
										componentDataArray[n][1] =  sectionDataChildNode.getAttribute("displayName").getValue(); 				
										System.out.println("["+n+"]"+componentDataArray[n][0] +" ::: "+ componentDataArray[n][1]);
									}
									if (sectionDataChildNode.getName().equalsIgnoreCase("text")){
										n = n + 1;
										componentDataArray[n][0] = "Details";
										componentDataArray[n][1] =  sectionDataChildNode.getText();				
										System.out.println("["+n+"]"+componentDataArray[n][0] +" ::: "+ componentDataArray[n][1]);
									}
								}
							}
						}						
					}					
				}
			}
		}
		return componentDataArray;
	}

	public static StringBuffer drawTitleData(String[][] main){

		StringBuffer tempHtmlData = new StringBuffer();
		
		if (main.length>0){
			tempHtmlData.append(tableMainStr);
			tempHtmlData.append(tbodyStr);
			tempHtmlData.append(trStr);							
			tempHtmlData.append(tdHeadStr);
			tempHtmlData.append(spanMainHeadStr);
			tempHtmlData.append(main[0][0]);
			tempHtmlData.append(cspanStr);			
			tempHtmlData.append(ctdStr);
			tempHtmlData.append(ctrStr);
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);			
			
			if (main[0][1].length()>0){
				tempHtmlData.append(tableStr);
				tempHtmlData.append(tbodyStr);
				tempHtmlData.append(trStr);			
				tempHtmlData.append(tdTextStr);
				tempHtmlData.append(spanTextStr);
				tempHtmlData.append(main[0][1]);				
				tempHtmlData.append(cspanStr);
				tempHtmlData.append(cspanStr);
				tempHtmlData.append(ctdStr);
				tempHtmlData.append(ctrStr);
				tempHtmlData.append(ctbodyStr);
				tempHtmlData.append(ctableStr);		
			}	
			tempHtmlData.append(brStr);
		}		
		
		return tempHtmlData;
	}


	public static StringBuffer drawPatientData(String[][] main){

		StringBuffer tempHtmlData = new StringBuffer();

		int rowCount = 0;
		int colCount = 0;

		String patientId = "", patienName = "", gender = "", dateOfBirth = "", race = "", provider = "";
		String streetAddress = "", city = "", state = "", postalCode = "", contactNoH = "", contactNoM = "";


		String patientName = "";
		
		if (main.length>0){
			tempHtmlData.append(tableMainStr);
			tempHtmlData.append(tbodyStr);
			tempHtmlData.append(trStr);				
			tempHtmlData.append(tdHeadStr);
			tempHtmlData.append(spanMainHeadStr);
			tempHtmlData.append("Patient Details");
			tempHtmlData.append(cspanStr);			
			tempHtmlData.append(ctdStr);
			tempHtmlData.append(ctrStr);
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);				
			tempHtmlData.append(tableStr);
			tempHtmlData.append(tbodyStr);		
			
			for (int i=0;i<main.length;i++)
			{
				if (main[i][0].equalsIgnoreCase("patientid"))
				{
					patientId = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("given"))
				{
					patientName = patientName + main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("family"))
				{
					patientName = patientName + main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("suffix"))
				{
					patientName = patientName + main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("gender"))
				{
					gender = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("birthdate"))
				{
					dateOfBirth = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("Race"))
				{
					race = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("provider"))
				{
					provider = main[i][1];
				}	

				if (main[i][0].equalsIgnoreCase("streetaddress"))
				{
					streetAddress = main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("city"))
				{
					city = main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("state"))
				{
					state = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("postalcode"))
				{
					postalCode = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("home"))
				{
					contactNoH = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("mobile"))
				{
					contactNoM = main[i][1];
				}					
			}			
			
			if ((patientId.length()>0) || (patientName.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Patient ID:", patientId));
				tempHtmlData.append(drawTDData("Patient Name:", patientName));
				tempHtmlData.append(ctrStr);
			}
			if ((gender.length()>0) || (dateOfBirth.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Gender:", gender));
				tempHtmlData.append(drawTDData("Birth Date:", dateOfBirth));
				tempHtmlData.append(ctrStr);
			}
			if ((race.length()>0) || (provider.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Race:", race));
				tempHtmlData.append(drawTDData("Provider:", provider));
				tempHtmlData.append(ctrStr);				
			}
			if ((streetAddress.length()>0) || (city.length()>0) || (state.length()>0) || (postalCode.length()>0) || (contactNoH.length()>0) || (contactNoM.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(tdGroupHeadStr);
				tempHtmlData.append(spanGroupHeadStr);
				tempHtmlData.append("Address Details");
				tempHtmlData.append(cspanStr);			
				tempHtmlData.append(ctdStr);
				tempHtmlData.append(ctrStr);
				tempHtmlData.append(ctrStr);
			}
			if ((streetAddress.length()>0) || (city.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Street Address:", streetAddress));
				tempHtmlData.append(drawTDData("City:", city));
				tempHtmlData.append(ctrStr);				
			}
			if ((state.length()>0) || (postalCode.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("State:", state));
				tempHtmlData.append(drawTDData("Postal Code:", postalCode));
				tempHtmlData.append(ctrStr);				
			}
			if ((contactNoH.length()>0) || (contactNoM.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Telecom (H):", contactNoH));
				tempHtmlData.append(drawTDData("Telecom (M):", contactNoM));
				tempHtmlData.append(ctrStr);				
			}
			
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);
			tempHtmlData.append(brStr);
		}	
		return tempHtmlData;
	}

	public static StringBuffer drawEncounterData(String[][] main){

		StringBuffer tempHtmlData = new StringBuffer();

		int rowCount = 0;
		int colCount = 0;

		String admissionDate = "", dischargeDate = "", consultationTime = "", consultationName = "", locationName = "";

		if (main.length>0){
			tempHtmlData.append(tableMainStr);
			tempHtmlData.append(tbodyStr);
			tempHtmlData.append(trStr);				
			tempHtmlData.append(tdHeadStr);
			tempHtmlData.append(spanMainHeadStr);
			tempHtmlData.append("Encounter Details");
			tempHtmlData.append(cspanStr);			
			tempHtmlData.append(ctdStr);
			tempHtmlData.append(ctrStr);
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);				
			tempHtmlData.append(tableStr);
			tempHtmlData.append(tbodyStr);		
			
			for (int i=0;i<main.length;i++)
			{
				if (main[i][0].equalsIgnoreCase("admissiondate"))
				{
					admissionDate = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("dischargedate"))
				{
					dischargeDate = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("consultationtime"))
				{
					consultationTime = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("locationcode"))
				{
					locationName = main[i][1];
				}

				if (main[i][0].equalsIgnoreCase("given"))
				{
					consultationName = consultationName + main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("family"))
				{
					consultationName = consultationName + main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("suffix"))
				{
					consultationName = consultationName + main[i][1];
				}
				
			}		
			
			if ((admissionDate.length()>0) || (dischargeDate.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Admission Date:", admissionDate));
				tempHtmlData.append(drawTDData("Discharge Date:", dischargeDate));
				tempHtmlData.append(ctrStr);
			}
			if ((consultationTime.length()>0) || (consultationName.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Consultation Time:", consultationTime));
				tempHtmlData.append(drawTDData("Consultant Name:", consultationName));
				tempHtmlData.append(ctrStr);
			}
			if (locationName.length()>0)
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Location Name:", locationName));
				tempHtmlData.append(drawTDData("", ""));
				tempHtmlData.append(ctrStr);				
			}			
			
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);
			tempHtmlData.append(brStr);
		}	
		return tempHtmlData;
	}

	public static StringBuffer drawAuthorData(String[][] main, int id){

		StringBuffer tempHtmlData = new StringBuffer();

		int rowCount = 0;
		int colCount = 0;

		String authorDate = "", speciality = "", practitionerType = "", authorName = "", facilityName = "";

		if (main.length>0){
			tempHtmlData.append(tableMainStr);
			tempHtmlData.append(tbodyStr);
			tempHtmlData.append(trStr);				
			tempHtmlData.append(tdHeadStr);
			tempHtmlData.append(spanMainHeadStr);
			if (id == 1)
			{
				tempHtmlData.append("Author Details");
			}
			if (id == 2)
			{
				tempHtmlData.append("Authenticator Details");
			}
			
			tempHtmlData.append(cspanStr);			
			tempHtmlData.append(ctdStr);
			tempHtmlData.append(ctrStr);
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);				
			tempHtmlData.append(tableStr);
			tempHtmlData.append(tbodyStr);		
			
			for (int i=0;i<main.length;i++)
			{
				if (main[i][0].equalsIgnoreCase("date"))
				{
					authorDate = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("speciality"))
				{
					speciality = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("practitionertype"))
				{
					practitionerType = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("given"))
				{
					authorName = authorName + main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("family"))
				{
					authorName = authorName + main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("suffix"))
				{
					authorName = authorName + main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("facilityname"))
				{
					facilityName = main[i][1];
				}			
			}		
			
			if (id == 1)
			{
				if ((authorDate.length()>0) || (speciality.length()>0))
				{
					tempHtmlData.append(trStr);					
					tempHtmlData.append(drawTDData("Author Date:", authorDate));
					tempHtmlData.append(drawTDData("Speciality:", speciality));				
					tempHtmlData.append(ctrStr);
				}
			}
			if (id == 2)
			{
				if ((authorDate.length()>0) || (authorName.length()>0))
				{
					tempHtmlData.append(trStr);					
					tempHtmlData.append(drawTDData("Author Date:", authorDate));
					tempHtmlData.append(drawTDData("Authenticator Name:", authorName));				
					tempHtmlData.append(ctrStr);
				}				
			}
			if (id == 1)
			{
				if ((practitionerType.length()>0) || (authorName.length()>0))
				{
					tempHtmlData.append(trStr);						
					tempHtmlData.append(drawTDData("Practitioner Type:", practitionerType));
					tempHtmlData.append(drawTDData("Practitioner Name:", authorName));									
					tempHtmlData.append(ctrStr);
				}
			}
			if (facilityName.length()>0)
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Facility Name:", facilityName));
				tempHtmlData.append(drawTDData("", ""));
				tempHtmlData.append(ctrStr);				
			}			
			
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);
			tempHtmlData.append(brStr);
		}	
		return tempHtmlData;
	}

	public static StringBuffer drawRecipientData(String[][] main){

		StringBuffer tempHtmlData = new StringBuffer();

		int rowCount = 0;
		int colCount = 0;

		String streetAddress = "", city = "", state = "", postalCode = "", telephone = "", hospitalName = "";

		if (main.length>0){
			tempHtmlData.append(tableMainStr);
			tempHtmlData.append(tbodyStr);
			tempHtmlData.append(trStr);				
			tempHtmlData.append(tdHeadStr);
			tempHtmlData.append(spanMainHeadStr);
			tempHtmlData.append("Intended Recipent Details");
			tempHtmlData.append(cspanStr);			
			tempHtmlData.append(ctdStr);
			tempHtmlData.append(ctrStr);
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);				
			tempHtmlData.append(tableStr);
			tempHtmlData.append(tbodyStr);		
			
			for (int i=0;i<main.length;i++)
			{
				if (main[i][0].equalsIgnoreCase("street"))
				{
					streetAddress = main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("city"))
				{
					city = main[i][1] + " ";
				}
				if (main[i][0].equalsIgnoreCase("state"))
				{
					state = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("postalcode"))
				{
					postalCode = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("telephone"))
				{
					telephone = main[i][1];
				}
				if (main[i][0].equalsIgnoreCase("recipienthospital"))
				{
					hospitalName = main[i][1];
				}					
			}			
			
			if ((hospitalName.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Recipient Hospital:", hospitalName));
				tempHtmlData.append(drawTDData("", ""));
				tempHtmlData.append(ctrStr);				
			}
			if ((streetAddress.length()>0) || (city.length()>0) || (state.length()>0) || (postalCode.length()>0))
			{
				tempHtmlData.append(trStr);	
				tempHtmlData.append(tdGroupHeadStr);
				tempHtmlData.append(spanGroupHeadStr);
				tempHtmlData.append("Address Details");
				tempHtmlData.append(cspanStr);			
				tempHtmlData.append(ctdStr);
				tempHtmlData.append(ctrStr);
				tempHtmlData.append(ctrStr);
			}
			if ((streetAddress.length()>0) || (city.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Street Address:", streetAddress));
				tempHtmlData.append(drawTDData("City:", city));
				tempHtmlData.append(ctrStr);				
			}
			if ((state.length()>0) || (postalCode.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("State:", state));
				tempHtmlData.append(drawTDData("Postal Code:", postalCode));
				tempHtmlData.append(ctrStr);				
			}		
			if ((telephone.length()>0))
			{	
				tempHtmlData.append(trStr);	
				tempHtmlData.append(drawTDData("Telephone:", telephone));
				tempHtmlData.append(drawTDData("", ""));
				tempHtmlData.append(ctrStr);				
			}
			
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);
			tempHtmlData.append(brStr);
		}	
		return tempHtmlData;
	}

	public static StringBuffer drawComponentData(String[][] main){

		StringBuffer tempHtmlData = new StringBuffer();

		int rowCount = 0;
		int colCount = 0;

		String title = "", details = "";

		if (main.length>0){
			tempHtmlData.append(tableMainStr);
			tempHtmlData.append(tbodyStr);
			tempHtmlData.append(trStr);				
			tempHtmlData.append(tdHeadStr);
			tempHtmlData.append(spanMainHeadStr);
			tempHtmlData.append("Summary Details");
			tempHtmlData.append(cspanStr);			
			tempHtmlData.append(ctdStr);
			tempHtmlData.append(ctrStr);
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);				
			tempHtmlData.append(tableStr);
			tempHtmlData.append(tbodyStr);		
			
			for (int i=0;i<main.length;i++)
			{
				System.out.println("Main["+i+"][0]:::"+main[i][0]+ " ::: "+main[i][1]);
				if (main[i][0].equalsIgnoreCase("title"))
				{
					title = main[i][1];
					if ((title.length()>0))
					{	
						tempHtmlData.append(trStr);	
						tempHtmlData.append(tdGroupHeadStr);
						tempHtmlData.append(spanGroupHeadStr);
						tempHtmlData.append(title);
						tempHtmlData.append(cspanStr);			
						tempHtmlData.append(ctdStr);
						tempHtmlData.append(ctrStr);
						tempHtmlData.append(ctrStr);				
					}	
				}
				if (main[i][0].equalsIgnoreCase("details"))
				{
					details = main[i][1];
					if (details.length()>0)
					{	
						tempHtmlData.append(trStr);	
						tempHtmlData.append(drawTDData("Summary",details));
						tempHtmlData.append(ctrStr);
					}
				}						
			}
			
			tempHtmlData.append(ctbodyStr);
			tempHtmlData.append(ctableStr);
			tempHtmlData.append(brStr);
		}	
		return tempHtmlData;
	}

	public static StringBuffer drawTDData(String label, String data){

		StringBuffer tempHtmlData = new StringBuffer();

		if (label.length()>0){			
			
			tempHtmlData.append(tdTextStr);
			tempHtmlData.append(spanTextStr);
			tempHtmlData.append(label);
			tempHtmlData.append(cspanStr);
			tempHtmlData.append(cspanStr);
			tempHtmlData.append(ctdStr);

			tempHtmlData.append(tdTextStr);
			tempHtmlData.append(spanDataStr);
			tempHtmlData.append(data);
			tempHtmlData.append(cspanStr);
			tempHtmlData.append(cspanStr);
			tempHtmlData.append(ctdStr);			
			
		}	
		return tempHtmlData;
	}

	public static String formatDateString(String dateInString) 
	{
		String dateFormatted = "";

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

		try {

			Date date = formatter.parse(dateInString);
			System.out.println(date);			
			dateFormatted = formatDate.format(date);
			System.out.println(" :::: "+dateFormatted);

		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		return dateFormatted;
	}

	public static String formatDateTimeString(String dateInString) 
	{
		String dateTimeFormatted = "";

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");

		try {

			Date date = formatter.parse(dateInString);
			System.out.println(date);			
			dateTimeFormatted = formatDate.format(date);
			System.out.println(" :::: "+dateTimeFormatted);

		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		return dateTimeFormatted;
	}

	/*
	public static StringBuffer titleHtmlData = new StringBuffer();
	public static StringBuffer custodianHtmlData = new StringBuffer();
	public static StringBuffer patientHtmlData = new StringBuffer();
	public static StringBuffer facilityHtmlData = new StringBuffer();
	public static StringBuffer encounterHtmlData = new StringBuffer();
	public static StringBuffer authorHtmlData = new StringBuffer();
	public static StringBuffer authenticatorHtmlData = new StringBuffer();
	public static StringBuffer recipientHtmlData = new StringBuffer();
	public static StringBuffer componentHtmlData = new StringBuffer();
	public static StringBuffer summaryHtmlData = new StringBuffer();
	*/

}

