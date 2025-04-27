<!DOCTYPE html>
<%@ page import="eXH.*,webbeans.eCommon.ConnectionManager" %>

<%
		String dataElements=checkForNull(request.getParameter("dataElements")); // Added by Sethu for MyHix changes required.
		//String data_details=checkForNull(request.getParameter("details")); // Commented by Sethu.
		StringBuffer htmlData = new StringBuffer(); // Variables added by Sethu.
		String data_details="";		
		
		System.out.println(" ::: MyHixDisplay ::: dataElements ::: "+dataElements);

		InvokeMyHixRequest myHixRequest = new InvokeMyHixRequest(); 
		//htmlData = myHixRequest.processRequest(dataElements);

		StringBuffer responseData = new StringBuffer();// Added for local testing.

		String xmlIn = 	" <ClinicalDocument xmlns=\"urn:hl7-org:v3\"> " +
							" <typeId extension=\"POCD_HD000040\" root=\"2.16.840.1.113883.1.3\" /> " +
							" <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.1.2\" /> " +
							" <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.1.4\" /> " +
							" <id root=\"2.16.458.1.100000.1.49\" extension=\"2\" /> " +
							" <code code=\"18842-5\" displayName=\"\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> " +
							" <title>Discharge Summary</title> " +
							" <effectiveTime value=\"20160615002600\" /> " +
							" <confidentialityCode code=\"N\" displayName=\"Normal\" codeSystem=\"2.16.840.1.113883.5.25\" codeSystemName=\"Confidentiality\" /> " +
							" <languageCode code=\"en-US\" /> " +
							" <custodian> " +
								" <assignedCustodian> " +
									" <representedCustodianOrganization> " +
										" <id root=\"2.16.458.1.100000.1.49\" /> " +
										" <name>Women and Child Hospital</name> " +
									" </representedCustodianOrganization> " +
								" </assignedCustodian> " +
							" </custodian> " +
							" <recordTarget> " +
								" <patientRole> " +
									" <id extension=\"BN00002465\" root=\"2.16.458.1.100000.1.49\" /> " +
									" <addr use=\"H\"> " +
										" <streetAddressLine>Parkroyal Serviced Suites Kl, No 1 Jalan Nagasari, Off Jalan Raja Chulan, </streetAddressLine> " +
										" <city>Kuala Lumpur</city> " +
										" <state>Kuala Lumpur</state> " +
										" <postalCode>50200</postalCode> " +
									" </addr> " +
									" <telecom value=\"\" use=\"H\" /> " +
									" <telecom value=\"\" use=\"MC\" /> " +
									" <patient> " +
										" <name> " +
											" <given>Sethuraman</given> " +
											" <family>Dhakshinamoorthy</family> " +
											" <suffix></suffix> " +
										" </name> " +
										" <administrativeGenderCode code=\"M\" /> " +
										" <birthTime value=\"19720614\" /> " +
										" <raceCode displayName=\"ML\" /> " +
									" </patient> " +
									" <providerOrganization> " +
										" <id root=\"2.16.458.1.100000.1.49\" /> " +
										" <name>Women and Child Hospital</name> " +
									" </providerOrganization> " +
								" </patientRole> " +
							" </recordTarget> " +
							" <componentOf> " +
								" <encompassingEncounter> " +
									" <id extension=\"20001008\" root=\"2.16.458.1.100000.1.49\" /> " +
									" <effectiveTime> " +
										" <low value=\"20160614\" /> " +
										" <high value=\"20160614\" /> " +
									" </effectiveTime> " +
									" <encounterParticipant typeCode=\"CONS\"> " +
										" <time value=\"20160614223400\" /> " +
										" <assignedEntity> " +
											" <id extension=\"MMC\" root=\"2.16.458.1.100000.1.49\" /> " +
											" <assignedPerson> " +
												" <name> " +
													" <given>CSC Clinician Access</given> " +
													" <family></family> " +
													" <suffix>MD</suffix> " +
												" </name> " +
											" </assignedPerson> " +
											" <representedOrganization> " +
												" <id extension=\"\" root=\"2.16.458.1.100000.1.49\" /> " +
											" </representedOrganization> " +
										" </assignedEntity> " +
									" </encounterParticipant> " +
									" <location> " +
										" <healthCareFacility classCode=\"DSDLOC\"> " +
											" <code code=\"GIME\" codeSystem=\"2.16.840.1.113883.5.111\" displayName=\"General Internal Medicine\" /> " +
										" </healthCareFacility> " +
									" </location> " +
								" </encompassingEncounter> " +
							" </componentOf> " +
							" <author> " +
								" <time value=\"20160614223400\" /> " +
								" <assignedAuthor> " +
									" <id extension=\"MMC\" root=\"2.16.458.1.100000.1.49\" /> " +
									" <code code=\"LP172946-8\" displayName=\"General medicine\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> " +
									" <functionCode code=\"LP173085-4\" displayName=\"Physician attending\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> " +
									" <assignedPerson> " +
										" <name> " +
											" <given>CSC Clinician Access</given> " +
											" <family></family> " +
											" <suffix>MD</suffix> " +
										" </name> " +
									" </assignedPerson> " +
									" <representedOrganization> " +
										" <id extension=\"\" root=\"2.16.458.1.100000.1.49\" /> " +
										" <name>Women and Child Hospital</name> " +
									" </representedOrganization> " +
								" </assignedAuthor> " +
							" </author> " +
							" <legalAuthenticator> " +
								" <time value=\"20160614223400\" /> " +
								" <assignedEntity> " +
									" <id extension=\"MMC\" root=\"2.16.458.1.100000.1.49\" /> " +
									" <assignedPerson> " +
										" <name> " +
											" <given>CSC Clinician Access</given> " +
											" <family></family> " +
											" <suffix>MD</suffix> " +
										" </name> " +
									" </assignedPerson> " +
									" <representedOrganization> " +
										" <id root=\"2.16.458.1.100000.1.49\" /> " +
										" <name>Women and Child Hospital</name> " +
									" </representedOrganization> " +
								" </assignedEntity> " +
							" </legalAuthenticator> " +
							" <component> " +
								" <structuredBody> " +
									" <component> " +
										" <section> " +
											" <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.3\" /> " +
											" <id root=\"\" extension=\"\" /> " +
											" <code code=\"48765-2\" displayName=\"ALLERGIES, ADVERSE REACTIONS, ALERTS\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> " +
											" <text>No Allergies</text> " +
										" </section> " +
									" </component> " +
									" <component> " +
										" <section> " +
											" <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.3\" /> " +
											" <id root=\"\" extension=\"\" /> " +
											" <code code=\"46241-6\" displayName=\"HOSPITAL ADMISSION DX\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> " +
											" <text>lack of sleep</text> " +
										" </section> " +
									" </component> " +
									" <component> " +
										" <section> " +
											" <templateId root=\"1.3.6.1.4.1.19376.1.5.3.1.3.3\" /> " +
											" <id root=\"\" extension=\"\" /> " +
											" <code code=\"11535-2\" displayName=\"PROBLEM LIST\" codeSystem=\"2.16.840.1.113883.6.1\" codeSystemName=\"LOINC\" /> " +
											" <text>No other medications</text> " +
										" </section> " +
									" </component> " +
								" </structuredBody> " +
							" </component> " +
						" </ClinicalDocument> ";
		

		responseData = new StringBuffer(xmlIn); // Added for local testing.

		htmlData = myHixRequest.processResponse(dataElements, responseData); // Added for local testing.
		
		data_details = htmlData.toString();

		data_details = data_details + "\n"+ "<input type=\"button\" name=\"Print\" id=\"Print\"  value=\"Print\" onClick=\"window.print()\">";
		
		System.out.println(" ::: MyHixDisplay ::: data_details ::: "+data_details);
	
		if (!(data_details.equals("")))
		{		
			out.println(data_details);			
		}
%>

<%!	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	?	""	:	inputString;
		}
		
		public static String checkForNull(String inputString, String defaultValue)
		{
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}
%>

