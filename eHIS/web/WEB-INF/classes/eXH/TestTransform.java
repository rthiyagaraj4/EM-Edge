package eXH;

import eXH.TransformXMLData;


class TestTransform 
{
	public static void main(String[] args) 
	{
		String htmlDataStr = "";
		String XSLstr = "<?xml version=\"1.0\"?>" +
							"<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" " +	
							"xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\" " +
							"xmlns:ns2=\"urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0\" " +
								"xmlns:ns3=\"urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0\" " +
								"xmlns:ns4=\"urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0\" " + 
								"xmlns:ns5=\"urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0\" " +
								"xmlns:ns6=\"urn:hl7-org:v3\">" +
							"<xsl:template match=\"/\">" +
								"<html>" +
								  " <script src=\"../../eMP/js/MyHixSearch.js\" language=\"javascript\"></script> " +
									" <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> " +
									" <body onload=\"format_fn()\" link=\"blue\" vlink=\"brown\" alink=\"red\"> " +
									" <table border=\"1\" align=\"center\" width=\"100%\"><tr><td class=\"columnheader\" colspan=\"8\">Summary Details</td></tr> " +
									" <tr> " +
									" <td class=\"columnheader\">Creation Date</td> " + 
									" <td class=\"columnheader\">Title</td> " + 
									" <td class=\"columnheader\">Hospital</td> " +
									" <td class=\"columnheader\">Speciality</td> " +
									" <td class=\"columnheader\">Patient ID</td> " +                                    
									" <td class=\"columnheader\">Physician</td> " +
									" <td class=\"columnheader\">Admission Date</td> " +
									" <td class=\"columnheader\">Discharge Date</td> " +
									  "</tr>" +
									  "<xsl:for-each select=\"S:Envelope/S:Body/ns5:AdhocQueryResponse/ns2:RegistryObjectList/ns2:ExtrinsicObject\">" +
									  "<tr>" +   
									"<xsl:for-each select=\"ns2:Slot\">" +		           			
										"<xsl:if test=\"@name='creationTime'\">" +			
											" <td id=\"cttime\"><xsl:value-of select=\"ns2:ValueList/ns2:Value\"/></td> " +
										"</xsl:if>" +		      
									"</xsl:for-each>" +	
									"<xsl:for-each select=\"ns2:Classification\">" +		           			
										"<xsl:if test=\"@id='cl3'\">" +			
											"<td><xsl:value-of select=\"ns2:Name/ns2:LocalizedString/@value\"/></td>" +
										"</xsl:if>" +		      
									"</xsl:for-each>" +	
									"<xsl:for-each select=\"ns2:Classification\">" +		           			
										"<xsl:if test=\"@id='cl6'\">" +			
											"<td><xsl:value-of select=\"ns2:Name/ns2:LocalizedString/@value\"/></td>" +
										"</xsl:if>" +		      
									"</xsl:for-each>" +	
									"<xsl:for-each select=\"ns2:Classification\">" +		           			
										"<xsl:if test=\"@id='cl7'\">" +			
											"<td><xsl:value-of select=\"ns2:Name/ns2:LocalizedString/@value\"/></td>" +
										"</xsl:if>" +		      
									"</xsl:for-each>" +	
									" <xsl:for-each select=\"ns2:Slot\"> " +                               
									" <xsl:if test=\"@name='sourcePatientId'\"> " +            
									" <td id=\"ptid\"><xsl:value-of select=\"ns2:ValueList/ns2:Value\"/></td> " +
									" </xsl:if> " +              
									" </xsl:for-each> " +    
									" <xsl:for-each select=\"ns2:Classification\"> " +                               
									" <xsl:if test=\"@id='cl1'\"> " +    
									" <xsl:for-each select=\"ns2:Slot\"> " +    
									" <xsl:if test=\"@name='authorPerson'\"> " +    
									" <td id=\"practnm\"><xsl:value-of select=\"ns2:ValueList/ns2:Value\"/></td> " +
									" </xsl:if> " +
									" </xsl:for-each> " +
									" </xsl:if> " +              
									" </xsl:for-each> " +                                        
									" <td><input type=\"hidden\" name=\"doc_txt\"><xsl:attribute name=\"value\"><xsl:value-of select=\"@id\"/> " +
									" </xsl:attribute></input>-</td><td>-</td> " +
									  "</tr>" +
									  "</xsl:for-each>" +
									"</table>" +
								  "</body>" +
								  "</html>" +
							"</xsl:template>" +
						"</xsl:stylesheet>" ;

		//responseDataStr = responseData.toString();

		String responseDataStr = "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\"><S:Body><ns5:AdhocQueryResponse xmlns:ns2=\"urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0\" xmlns:ns3=\"urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0\" xmlns:ns4=\"urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0\" xmlns:ns5=\"urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0\" xmlns:ns6=\"urn:hl7-org:v3\" startIndex=\"0\" totalResultCount=\"2\"><ns2:RegistryObjectList><ns2:ExtrinsicObject mimeType=\"text/xml\" status=\"urn:oasis:names:tc:ebxml-regrep:StatusType:Approved\" id=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\"><ns2:Slot name=\"title\" slotType=\"$XDSDocumentEntryTitle\"><ns2:ValueList><ns2:Value>EM Discharge Summary</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"creationTime\" slotType=\"$XDSDocumentEntryCreationTime\"><ns2:ValueList><ns2:Value>20171005182800</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"sourcePatientId\" slotType=\"$XDSDocumentEntrySourcePatientId\"><ns2:ValueList><ns2:Value>SA00088218^^^XYZ2.16.458.1.100000.1.211XYZISO</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"sourcePatientInfo\" slotType=\"$XDSDocumentEntrySourcePatientInfo\"><ns2:ValueList><ns2:Value>PID-3|SA00088218^^^XYZ2.16.458.1.100000.1.211XYZISO</ns2:Value><ns2:Value>PID-5|^Myhix Shah Alam^^^</ns2:Value><ns2:Value>PID-7|19770317</ns2:Value><ns2:Value>PID-8|F</ns2:Value><ns2:Value>PID-11|^^^^^</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"EM Discharge Summary\"/></ns2:Name><ns2:Classification classificationScheme=\"urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"\" id=\"cl1\"><ns2:Slot name=\"authorPerson\" slotType=\"$XDSDocumentEntryAuthorPerson\"><ns2:ValueList><ns2:Value>MMC^^B.K.Krishnan Balakrishnan,Dr^^SG^^^^^XYZ2.16.458.1.100000.1.211XYZISO</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"authorRole\" slotType=\"$XDSDocumentEntryAuthorRole\"><ns2:ValueList><ns2:Value>Attending</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"authorSpecialty\" slotType=\"$XDSDocumentEntryAuthorSpecialty\"><ns2:ValueList><ns2:Value>General Surgery</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"authorInstitution\" slotType=\"$XDSDocumentEntryAuthorInstitution\"><ns2:ValueList><ns2:Value>General Surgery</ns2:Value><ns2:Value>Surgical Ward (Male) 9A</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"author\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"LP173221-5\" id=\"cl2\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Discharge Summarization\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:f0306f51-975f-434e-a61c-c59651d33983\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"18842-5\" id=\"cl3\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Discharge Summary\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"R\" id=\"cl4\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>Confidentiality</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"restricted\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"DOC\" id=\"cl5\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Document\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"Inpatient Hospital\" id=\"cl6\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Inpatient Hospital\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead\" classifiedObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" nodeRepresentation=\"LP32225-2\" id=\"cl7\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"General Surgery\"/></ns2:Name></ns2:Classification><ns2:ExternalIdentifier registryObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" identificationScheme=\"urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427\" value=\"164ff73f-6ba5-4294-b1d0-feda01b166a1^^^XYZ2.16.458.1.100000.2.1XYZISO\" id=\"ei1\"><ns2:Name><ns2:LocalizedString value=\"XDSDocumentEntry.patientId\"/></ns2:Name></ns2:ExternalIdentifier><ns2:ExternalIdentifier registryObject=\"0cea3d15-9722-4c5e-a110-0f9c490ac3fc\" identificationScheme=\"urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab\" value=\"2.16.458.1.100000.1.211^CN17$0000000000054130\" id=\"ei2\"><ns2:Name><ns2:LocalizedString value=\"XDSDocumentEntry.uniqueId\"/></ns2:Name></ns2:ExternalIdentifier></ns2:ExtrinsicObject><ns2:ExtrinsicObject mimeType=\"text/xml\" status=\"urn:oasis:names:tc:ebxml-regrep:StatusType:Approved\" id=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\"><ns2:Slot name=\"title\" slotType=\"$XDSDocumentEntryTitle\"><ns2:ValueList><ns2:Value>EM Discharge Summary</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"creationTime\" slotType=\"$XDSDocumentEntryCreationTime\"><ns2:ValueList><ns2:Value>20171005150600</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"sourcePatientId\" slotType=\"$XDSDocumentEntrySourcePatientId\"><ns2:ValueList><ns2:Value>SA00088218^^^XYZ2.16.458.1.100000.1.211XYZISO</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"sourcePatientInfo\" slotType=\"$XDSDocumentEntrySourcePatientInfo\"><ns2:ValueList><ns2:Value>PID-3|SA00088218^^^XYZ2.16.458.1.100000.1.211XYZISO</ns2:Value><ns2:Value>PID-5|^Myhix Shah Alam^^^</ns2:Value><ns2:Value>PID-7|19770317</ns2:Value><ns2:Value>PID-8|F</ns2:Value><ns2:Value>PID-11|^^^^^</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"EM Discharge Summary\"/></ns2:Name><ns2:Classification classificationScheme=\"urn:uuid:93606bcf-9494-43ec-9b4e-a7748d1a838d\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"\" id=\"cl1\"><ns2:Slot name=\"authorPerson\" slotType=\"$XDSDocumentEntryAuthorPerson\"><ns2:ValueList><ns2:Value>MMC^^Anil Kumar SreeKumar Pillai,Dr^^MD^^^^^XYZ2.16.458.1.100000.1.211XYZISO</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"authorRole\" slotType=\"$XDSDocumentEntryAuthorRole\"><ns2:ValueList><ns2:Value>Attending</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"authorSpecialty\" slotType=\"$XDSDocumentEntryAuthorSpecialty\"><ns2:ValueList><ns2:Value>General Surgery</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Slot name=\"authorInstitution\" slotType=\"$XDSDocumentEntryAuthorInstitution\"><ns2:ValueList><ns2:Value>General Internal Medicine</ns2:Value><ns2:Value>Medical Ward (Male) 10A</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"author\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:41a5887f-8865-4c09-adf7-e362475b143a\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"LP173221-5\" id=\"cl2\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Discharge Summarization\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:f0306f51-975f-434e-a61c-c59651d33983\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"18842-5\" id=\"cl3\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Discharge Summary\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:f4f85eac-e6cb-4883-b524-f2705394840f\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"R\" id=\"cl4\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>Confidentiality</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"restricted\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:a09d5840-386c-46f2-b5ad-9c3699a4309d\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"DOC\" id=\"cl5\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Document\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:f33fb8ac-18af-42cc-ae0e-ed0b0bdb91e1\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"Inpatient Hospital\" id=\"cl6\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"Inpatient Hospital\"/></ns2:Name></ns2:Classification><ns2:Classification classificationScheme=\"urn:uuid:cccf5598-8b07-4b77-a05e-ae952c785ead\" classifiedObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" nodeRepresentation=\"LP32225-2\" id=\"cl7\"><ns2:Slot name=\"codingScheme\"><ns2:ValueList><ns2:Value>LOINC</ns2:Value></ns2:ValueList></ns2:Slot><ns2:Name><ns2:LocalizedString value=\"General Surgery\"/></ns2:Name></ns2:Classification><ns2:ExternalIdentifier registryObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" identificationScheme=\"urn:uuid:58a6f841-87b3-4a3e-92fd-a8ffeff98427\" value=\"164ff73f-6ba5-4294-b1d0-feda01b166a1^^^XYZ2.16.458.1.100000.2.1XYZISO\" id=\"ei1\"><ns2:Name><ns2:LocalizedString value=\"XDSDocumentEntry.patientId\"/></ns2:Name></ns2:ExternalIdentifier><ns2:ExternalIdentifier registryObject=\"c4536f2f-4302-4fcc-bd52-8ce54c549275\" identificationScheme=\"urn:uuid:2e82c1f6-a085-4c72-9da3-8640a32e42ab\" value=\"2.16.458.1.100000.1.211^CN17$0000000000054111\" id=\"ei2\"><ns2:Name><ns2:LocalizedString value=\"XDSDocumentEntry.uniqueId\"/></ns2:Name></ns2:ExternalIdentifier></ns2:ExtrinsicObject></ns2:RegistryObjectList></ns5:AdhocQueryResponse></S:Body></S:Envelope>";
		
			
		htmlDataStr = eXH.TransformXMLData.getTransformData(responseDataStr, XSLstr);

		System.out.println("Hello World!::: "+htmlDataStr);
	}
}
