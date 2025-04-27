package eXH;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.StringReader;
import java.io.StringWriter;

public class MyHixProcessRequestData {
    /**
     * @param args the command line arguments
     */

	public static StringBuffer prcoessData(StringBuffer xmlRequestData)
    {
		String xmlIn=xmlRequestData.toString();
		/*String xmlIn = "<S:Envelope xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\"> " +
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
									"</ns2:RegistryObjectList>" +
								"</ns5:AdhocQueryResponse>" +
							"</S:Body>" +
						"</S:Envelope>" ;
		*/

		String xsl = "<?xml version=\"1.0\"?>\n" +
							"<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" " +	
							"xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\" " +
							"xmlns:ns2=\"urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0\" " +
								"xmlns:ns3=\"urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0\" " +
								"xmlns:ns4=\"urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0\" " + 
								"xmlns:ns5=\"urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0\" " +
								"xmlns:ns6=\"urn:hl7-org:v3\">" +
							"<xsl:template match=\"/\">" +
								"<html>" +
								  "<script src='../../eMP/js/MyHixSearch.js' language='javascript'></script>" +
									"<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>" +
									"<body onload='format_fn()' link='blue' vlink='brown' alink='red'>" +
								  	"<table border=\"1\" align='center' width='100%'><tr><td class='columnheader' colspan='8'>Summary Details</td></tr>" +
									  "<tr>" +
									"<td class='columnheader'>Creation Date</td>" + 
									"<td class='columnheader'>Title</td>" + 
									"<td class='columnheader'>Hospital</td>" +
									"<td class='columnheader'>Speciality</td>" +
									"<td class='columnheader'>Patient ID</td>" +									
									"<td class='columnheader'>Physician</td>" +
									"<td class='columnheader'>Admission Date</td>" +
									"<td class='columnheader'>Discharge Date</td>" +
									  "</tr>" +
									  "<xsl:for-each select=\"S:Envelope/S:Body/ns5:AdhocQueryResponse/ns2:RegistryObjectList/ns2:ExtrinsicObject\">" +
									  "<tr>" +   
									"<xsl:for-each select=\"ns2:Slot\">" +		           			
										"<xsl:if test=\"@name='creationTime'\">" +			
											"<td id='cttime'><xsl:value-of select=\"ns2:ValueList/ns2:Value\"/></td>" +
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
									"<xsl:for-each select=\"ns2:Slot\">" +		           			
										"<xsl:if test=\"@name='sourcePatientId'\">" +			
											"<td id='ptid'><xsl:value-of select=\"ns2:ValueList/ns2:Value\"/></td>" +
										"</xsl:if>" +		      
									"</xsl:for-each>" +	
									"<xsl:for-each select=\"ns2:Classification\">" +		           			
										"<xsl:if test=\"@id='cl1'\">" +	
											"<xsl:for-each select=\"ns2:Slot\">" +	
												"<xsl:if test=\"@name='authorPerson'\">" +	
													"<td id='practnm'><xsl:value-of select=\"ns2:ValueList/ns2:Value\"/></td>" +
												"</xsl:if>" +
											"</xsl:for-each>" +
										"</xsl:if>" +		      
									"</xsl:for-each>" +										
										"<td><input type='hidden' name='doc_txt'><xsl:attribute name='value'><xsl:value-of select=\"@id\"/>"+
									  "</xsl:attribute></input>-</td><td>-</td>" +
										"</tr>" +
									  "</xsl:for-each>" +									
									"</table>" +
								  "</body>" +
								  "</html>" +
							"</xsl:template>" +
						"</xsl:stylesheet>" ;

        MyHixProcessRequestData st = new MyHixProcessRequestData();
		String outHTML = "";
		StringBuffer outStrBuffer = new StringBuffer();
        try
        {
			outHTML = st.transformData(xmlIn, xsl);
			outStrBuffer = new StringBuffer(outHTML);
        }
        catch (TransformerConfigurationException e)
        {
            System.err.println("TransformerConfigurationException");
            System.err.println(e);
        }
        catch (TransformerException e)
        {
            System.err.println("TransformerException");
            System.err.println(e);
        }		

		return outStrBuffer;
    }
 
	public String transformData(String xmlIn, String xsl)
            throws TransformerConfigurationException,
            TransformerException
    {
		String outputHTML = "";
		StreamSource xslSource = new StreamSource(new StringReader(xsl));
        StreamSource xmlInSource = new StreamSource(new StringReader(xmlIn));
        Transformer tf = TransformerFactory.newInstance().newTransformer(xslSource);
        StringWriter xmlOutWriter = new StringWriter();
        tf.transform(xmlInSource, new StreamResult(xmlOutWriter));
        outputHTML = xmlOutWriter.toString();
		System.out.println(outputHTML);

		return outputHTML;
	}
}
