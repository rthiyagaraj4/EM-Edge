	<%@ page import="eXH.*,webbeans.eCommon.ConnectionManager" %>

	<%
		String dataElements=checkForNull(request.getParameter("dataElements")); // Added by Sethu for MyHix changes required.
		//String data_details=checkForNull(request.getParameter("details")); // Commented by Sethu.
		StringBuffer htmlData = new StringBuffer(); // Variables added by Sethu.
		String data_details="";

		String action=checkForNull(request.getParameter("action"));
		String facilityid=checkForNull(request.getParameter("facilityid"));
		String pat_id=checkForNull(request.getParameter("pat_id"));
		String encounter_id=checkForNull(request.getParameter("encounter_id"));
		String my_hix_pat_id=checkForNull(request.getParameter("my_hix_pat_id"));
		my_hix_pat_id=my_hix_pat_id.replaceAll("&amp;", "&amp;amp;");
		String final_from_date=checkForNull(request.getParameter("final_from_date"));
		String final_to_date=checkForNull(request.getParameter("final_to_date"));
		
		System.out.println(" ::: MyHixResult ::: dataElements ::: "+dataElements);

		InvokeMyHixRequest myHixRequest = new InvokeMyHixRequest(); 
		htmlData = myHixRequest.processRequest(dataElements); // Commented for local testing
		
		/*
		StringBuffer responseData = new StringBuffer(); // Variables added by Sethu.

		String xmlIn = "<S:Envelope xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\"> " +
								"<S:Body>" +
								"<ns5:AdhocQueryResponse " +
								"xmlns:ns2=\"urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0\" " +
								"xmlns:ns3=\"urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0\" " +
								"xmlns:ns4=\"urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0\" " +
								"xmlns:ns5=\"urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0\" " +
								"xmlns:ns6=\"urn:hl7-org:v3\" " +
								"startIndex=\"0\" totalResultCount=\"1\">" +
									"<ns2:RegistryObjectList>" +
										"<ns2:ExtrinsicObject id=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" mimeType=\"text/xml\" status=\"Approved\">" +
											"<ns2:Slot name=\"title\" slotType=\"$XDSDocumentEntryTitle\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>Viamed Discharge Summary</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"creationTime\" slotType=\"$XDSDocumentEntryCreationTime\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>20160520230409</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientId\" slotType=\"$XDSDocumentEntrySourcePatientId\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientInfo\" slotType=\"$XDSDocumentEntrySourcePatientInfo\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>PID-3|A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
													"<ns2:Value>PID-5|Doe^John^^^</ns2:Value>" +
													"<ns2:Value>PID-7|19560527</ns2:Value>" +
													"<ns2:Value>PID-8|M</ns2:Value>" +
													"<ns2:Value>PID-11|100 Main St^^Metropolis^Il^44130^USA</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Name>" +
												"<ns2:LocalizedString value=\"Viamed Discharge Summary\"/>" +
											"</ns2:Name>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl1\" nodeRepresentation=\"\">" +
												"<ns2:Slot name=\"authorPerson\" slotType=\"$XDSDocumentEntryAuthorPerson\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>MMC^^DR SULAIMAN^^MD^^^^^&amp;2.16.458.1.100000.4.21&amp;ISO</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorRole\" slotType=\"$XDSDocumentEntryAuthorRole\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Attending</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorSpecialty\" slotType=\"$XDSDocumentEntryAuthorSpecialty\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>General medicine</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorInstitution\" slotType=\"$XDSDocumentEntryAuthorInstitution\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Orthopedic Dept.</ns2:Value>" +
														"<ns2:Value>Viamed Clinic</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"author\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl2\" nodeRepresentation=\"LP173221-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Discharge summarization\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f0306f51-975f-434e-a61c-c59651d33983\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl3\" nodeRepresentation=\"18842-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Discharge Summary\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl4\" nodeRepresentation=\"R\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Confidentiality</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"restricted\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl5\" nodeRepresentation=\"DOC\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Document\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl6\" nodeRepresentation=\"Inpatient Hospital\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Inpatient Hospital\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl7\" nodeRepresentation=\"LP32225-2\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"General Medicine\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:ExternalIdentifier id=\"ei1\" identificationScheme=\"urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"08e225e1-18e3-3a6d-818e-c07f58248e58^^^&amp;2.16.458.1.100000.1&amp;ISO\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.patientId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
											"<ns2:ExternalIdentifier id=\"ei2\" identificationScheme=\"urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"2.16.458.1.100000.1.18^4012\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.uniqueId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
										"</ns2:ExtrinsicObject>" +
										"<ns2:ExtrinsicObject id=\"233445-f33a-4be8-b17f-4371611eea6d\" mimeType=\"text/xml\" status=\"Approved\">" +
											"<ns2:Slot name=\"title\" slotType=\"$XDSDocumentEntryTitle\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>Viamed Discharge Summary</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"creationTime\" slotType=\"$XDSDocumentEntryCreationTime\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>20160122180409</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientId\" slotType=\"$XDSDocumentEntrySourcePatientId\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientInfo\" slotType=\"$XDSDocumentEntrySourcePatientInfo\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>PID-3|A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
													"<ns2:Value>PID-5|Doe^John^^^</ns2:Value>" +
													"<ns2:Value>PID-7|19560527</ns2:Value>" +
													"<ns2:Value>PID-8|M</ns2:Value>" +
													"<ns2:Value>PID-11|100 Main St^^Metropolis^Il^44130^USA</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Name>" +
												"<ns2:LocalizedString value=\"Viamed Discharge Summary\"/>" +
											"</ns2:Name>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl1\" nodeRepresentation=\"\">" +
												"<ns2:Slot name=\"authorPerson\" slotType=\"$XDSDocumentEntryAuthorPerson\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>MMC^^DR Vinod Konat^^MD^^^^^&amp;2.16.458.1.100000.4.21&amp;ISO</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorRole\" slotType=\"$XDSDocumentEntryAuthorRole\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Attending</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorSpecialty\" slotType=\"$XDSDocumentEntryAuthorSpecialty\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>General medicine</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorInstitution\" slotType=\"$XDSDocumentEntryAuthorInstitution\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Orthopedic Dept.</ns2:Value>" +
														"<ns2:Value>Viamed Clinic</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"author\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl2\" nodeRepresentation=\"LP173221-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Discharge summarization\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f0306f51-975f-434e-a61c-c59651d33983\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl3\" nodeRepresentation=\"18842-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Referral Summary\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl4\" nodeRepresentation=\"R\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Confidentiality</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"restricted\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl5\" nodeRepresentation=\"DOC\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Document\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl6\" nodeRepresentation=\"Inpatient Hospital\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Inpatient Hospital\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl7\" nodeRepresentation=\"LP32225-2\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Cardiology Surgery\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:ExternalIdentifier id=\"ei1\" identificationScheme=\"urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"08e225e1-18e3-3a6d-818e-c07f58248e58^^^&amp;2.16.458.1.100000.1&amp;ISO\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.patientId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
											"<ns2:ExternalIdentifier id=\"ei2\" identificationScheme=\"urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"2.16.458.1.100000.1.18^4012\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.uniqueId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
										"</ns2:ExtrinsicObject>" +
										"<ns2:ExtrinsicObject id=\"233445-f33a-4be8-b17f-4371611eea6d\" mimeType=\"text/xml\" status=\"Approved\">" +
											"<ns2:Slot name=\"title\" slotType=\"$XDSDocumentEntryTitle\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>Viamed Discharge Summary</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"creationTime\" slotType=\"$XDSDocumentEntryCreationTime\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>20160122180409</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientId\" slotType=\"$XDSDocumentEntrySourcePatientId\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientInfo\" slotType=\"$XDSDocumentEntrySourcePatientInfo\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>PID-3|A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
													"<ns2:Value>PID-5|Doe^John^^^</ns2:Value>" +
													"<ns2:Value>PID-7|19560527</ns2:Value>" +
													"<ns2:Value>PID-8|M</ns2:Value>" +
													"<ns2:Value>PID-11|100 Main St^^Metropolis^Il^44130^USA</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Name>" +
												"<ns2:LocalizedString value=\"Viamed Discharge Summary\"/>" +
											"</ns2:Name>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl1\" nodeRepresentation=\"\">" +
												"<ns2:Slot name=\"authorPerson\" slotType=\"$XDSDocumentEntryAuthorPerson\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>MMC^^DR Anil Purushotham^^MD^^^^^&amp;2.16.458.1.100000.4.21&amp;ISO</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorRole\" slotType=\"$XDSDocumentEntryAuthorRole\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Attending</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorSpecialty\" slotType=\"$XDSDocumentEntryAuthorSpecialty\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>General medicine</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorInstitution\" slotType=\"$XDSDocumentEntryAuthorInstitution\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Cardiology Dept.</ns2:Value>" +
														"<ns2:Value>Cardiology Clinic</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"author\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl2\" nodeRepresentation=\"LP173221-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Discharge summarization\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f0306f51-975f-434e-a61c-c59651d33983\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl3\" nodeRepresentation=\"18842-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Referral Summary\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl4\" nodeRepresentation=\"R\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Confidentiality</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"restricted\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl5\" nodeRepresentation=\"DOC\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Document\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl6\" nodeRepresentation=\"Inpatient Hospital\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Hospital Shah Alam\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl7\" nodeRepresentation=\"LP32225-2\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Orthopedic Surgery \"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:ExternalIdentifier id=\"ei1\" identificationScheme=\"urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"08e225e1-18e3-3a6d-818e-c07f58248e58^^^&amp;2.16.458.1.100000.1&amp;ISO\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.patientId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
											"<ns2:ExternalIdentifier id=\"ei2\" identificationScheme=\"urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"2.16.458.1.100000.1.18^4012\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.uniqueId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
										"</ns2:ExtrinsicObject>" +
										"<ns2:ExtrinsicObject id=\"233445-f33a-4be8-b17f-4371611eea6d\" mimeType=\"text/xml\" status=\"Approved\">" +
											"<ns2:Slot name=\"title\" slotType=\"$XDSDocumentEntryTitle\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>Viamed Discharge Summary</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"creationTime\" slotType=\"$XDSDocumentEntryCreationTime\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>20160122180409</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientId\" slotType=\"$XDSDocumentEntrySourcePatientId\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Slot name=\"sourcePatientInfo\" slotType=\"$XDSDocumentEntrySourcePatientInfo\">" +
												"<ns2:ValueList>" +
													"<ns2:Value>PID-3|A00001^^^&amp;2.16.458.1.100000.1&amp;ISO</ns2:Value>" +
													"<ns2:Value>PID-5|Doe^John^^^</ns2:Value>" +
													"<ns2:Value>PID-7|19560527</ns2:Value>" +
													"<ns2:Value>PID-8|M</ns2:Value>" +
													"<ns2:Value>PID-11|100 Main St^^Metropolis^Il^44130^USA</ns2:Value>" +
												"</ns2:ValueList>" +
											"</ns2:Slot>" +
											"<ns2:Name>" +
												"<ns2:LocalizedString value=\"Viamed Discharge Summary\"/>" +
											"</ns2:Name>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl1\" nodeRepresentation=\"\">" +
												"<ns2:Slot name=\"authorPerson\" slotType=\"$XDSDocumentEntryAuthorPerson\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>MMC^^DR Vinod Konat^^MD^^^^^&amp;2.16.458.1.100000.4.21&amp;ISO</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorRole\" slotType=\"$XDSDocumentEntryAuthorRole\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Attending</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorSpecialty\" slotType=\"$XDSDocumentEntryAuthorSpecialty\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Orthopedic Surgery</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Slot name=\"authorInstitution\" slotType=\"$XDSDocumentEntryAuthorInstitution\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Orthopedic Dept.</ns2:Value>" +
														"<ns2:Value>Viamed Clinic</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"author\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl2\" nodeRepresentation=\"LP173221-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Discharge summarization\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f0306f51-975f-434e-a61c-c59651d33983\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl3\" nodeRepresentation=\"18842-5\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Referral Summary\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl4\" nodeRepresentation=\"R\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>Confidentiality</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"restricted\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl5\" nodeRepresentation=\"DOC\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Document\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl6\" nodeRepresentation=\"Inpatient Hospital\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Hospital Shah Alam\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:Classification classificationScheme=\"urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead\" classifiedObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" id=\"cl7\" nodeRepresentation=\"LP32225-2\">" +
												"<ns2:Slot name=\"codingScheme\">" +
													"<ns2:ValueList>" +
														"<ns2:Value>LOINC</ns2:Value>" +
													"</ns2:ValueList>" +
												"</ns2:Slot>" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"Orthopedic Surgery\"/>" +
												"</ns2:Name>" +
											"</ns2:Classification>" +
											"<ns2:ExternalIdentifier id=\"ei1\" identificationScheme=\"urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"08e225e1-18e3-3a6d-818e-c07f58248e58^^^&amp;2.16.458.1.100000.1&amp;ISO\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.patientId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
											"<ns2:ExternalIdentifier id=\"ei2\" identificationScheme=\"urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab\" registryObject=\"4c8d4637-f33a-4be8-b17f-4371611eea6d\" value=\"2.16.458.1.100000.1.18^4012\">" +
												"<ns2:Name>" +
													"<ns2:LocalizedString value=\"XDSDocumentEntry.uniqueId\"/>" +
												"</ns2:Name>" +
											"</ns2:ExternalIdentifier>" +
										"</ns2:ExtrinsicObject>" +
									"</ns2:RegistryObjectList>" +
								"</ns5:AdhocQueryResponse>" +
							"</S:Body>" +
						"</S:Envelope>" ;
		

		responseData = new StringBuffer(xmlIn); // Added for local testing.

		htmlData = myHixRequest.processResponse(dataElements, responseData); // Added for local testing.

		*/
		
		data_details = htmlData.toString();
		
		System.out.println(" ::: MyHixResult ::: data_details ::: "+data_details);

	
		if (!(data_details.equals("")))
		{
		
			out.println(data_details);
			out.println("<input type='hidden' name=action id=action value='"+action+"'>");
			out.println("<input type='hidden' name=facilityid id=facilityid value='"+facilityid+"'>");
			out.println("<input type='hidden' name=pat_id id=pat_id value='"+pat_id+"'>");
			out.println("<input type='hidden' name=encounter_id id=encounter_id value='"+encounter_id+"'>");
			out.println("<input type='hidden' size='80' name=my_hix_pat_id id=my_hix_pat_id value='"+my_hix_pat_id+"'>");
			out.println("<input type='hidden' name=final_from_date id=final_from_date value='"+final_from_date+"'>");
			out.println("<input type='hidden' name=final_to_date id=final_to_date value='"+final_to_date+"'>");
			%>
			<script language='javascript' src='../../eMP/js/MyHixSearch.js'></script>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<script src='../../eCommon/js/dchk.js' language='javascript'> </script>
			<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
			<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
			<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script>
			<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
			<Script src='../../eCommon/js/CommonCalendar.js' language="JavaScript"></Script>
			<%
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
	

