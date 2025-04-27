/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCA;


import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.xml.sax.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MaternityDataParser
{
	//private Connection cnParser				=	null;

	private String		m_patientId			=	"";
	private String		m_transDate			=	"";
	private String		m_accession_num		=	"";
	private String		m_encounterId		=	"";
	private String		m_facilityId		=	"";
	private String		m_patientClass		=	"";
	private String		m_xslfile			=	"";
	private String		m_sechdgcode		=	"";
	private String		m_subsechdgcode		=	"";
	private String		m_opmode			=	"";
	private String		m_moduleid			=	"";
	private String		m_cycleno			=	"";
	private String		m_eventcode			=	"";
	private String		m_taskcode			=	"";
	private String		m_added_ws_no		=	"";
	private String		m_added_user_id		=	"";
	
	public Document		m_XMLDocument 		=	null;

	private webbeans.eCA.XMLtoHTML	m_converter			=	 null;

	public boolean MatDataPost(Connection con,String sbXMLContentIn,String strPatientId,String trans_date,String strAccNum,String strEncId,String strFacId,String strPatClass,webbeans.eCA.XMLtoHTML converter,String strSecCode,String strSubSecCode,String strOpMode,String strModuleId,String strCycleNo,String strEvtCode,String strTaskCode,String strXSLFile,String strAddedWsNo,String strAddedUser)
	{
		boolean bResult 			= false;
		
		try
		{	
			
			//this.cnParser			= con;
			this.m_converter		= converter;
			this.m_xslfile			= strXSLFile;
			this.m_patientId		= strPatientId;
			this.m_transDate		= trans_date;
			this.m_accession_num	= strAccNum;
			this.m_encounterId		= strEncId;
			this.m_facilityId		= strFacId;
			this.m_patientClass		= strPatClass;
			this.m_xslfile			= strXSLFile;
			this.m_sechdgcode		= strSecCode;
			this.m_subsechdgcode	= strSubSecCode;
			this.m_opmode			= strOpMode;
			this.m_moduleid			= strModuleId;
			this.m_cycleno			= strCycleNo;
			this.m_eventcode		= strEvtCode;
			this.m_taskcode			= strTaskCode;
			this.m_added_ws_no		= strAddedWsNo;
			this.m_added_user_id	= strAddedUser;

			StringReader strTemp	= new StringReader(sbXMLContentIn);
			InputSource isTemp		= new InputSource(strTemp);

			this.m_XMLDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(isTemp);

			bResult	= getPosted(con);
		}
		catch (Exception e1)
		{
			bResult = false;
			System.out.println(" Error in Maternity Data Posting Parser" + e1.getMessage());
			e1.printStackTrace(System.err);
		}
	
		return bResult;	
	}
	
	private boolean getPosted(Connection con)
	{
		boolean bResult				=	true,					bInsStat			=	false;
		
		NodeList nlDataNodes		= 	null,					nlChildNodes		=	null;
		NodeList nlRowNodes			=	null,					nlRowDataNodes		=	null;
		
		Node ndCurDataNode			=	null,					ndCurAttNode		=	null;
		Node ndFirstNode			=	null,					ndLastNode			=	null;
		Node ndFirstRowNode			=	null,					ndLastDtRow			=	null;
		Node ndFirstDtRow			=	null;
	
		String strDiscCompId		=	"",						strNodeName			=	"";
		String strValue				=	"",						strSecSeqNum		=	"";
		String strResultType		=	"",						strTemp				=	"";
		String strRefHigh			=	"",						strRefLow			=	"";
		String strCriHigh			=	"",						strCriLow			=	"";
		String strSelValue			=	"";		
		
		NamedNodeMap nnmpChildAttr	=	null,					nnmpAttr			=	null;
		
		int nGridLen				=	0,						nCurNdIdx			=	0;
		int nChildLength			=	0,						nRowLength			=	0;
		int nChildCurIdx			=	0;
		
		StringBuffer sbXPathDefn		= 	new StringBuffer();

//		webbeans.eCA.XMLtoHTML xmltrans = new webbeans.eCA.XMLtoHTML();
		
		try
		{
			

			sbXPathDefn.append("/USER-TEMPLATE/ROW/COL/*[@ANALYN='Y']");

			nlDataNodes		=	XPathAPI.selectNodeList(this.m_XMLDocument,sbXPathDefn.toString());
			
			nGridLen = nlDataNodes.getLength();

			for(nCurNdIdx = 0; nCurNdIdx < nGridLen ; nCurNdIdx++)
			{
				ndCurDataNode	=	nlDataNodes.item(nCurNdIdx);
				nnmpAttr		=	ndCurDataNode.getAttributes();
				
				ndCurAttNode	=	nnmpAttr.getNamedItem("DISCRID");
				if (ndCurAttNode != null)
					strDiscCompId	=	ndCurAttNode.getNodeValue();
				
				ndCurAttNode	=	nnmpAttr.getNamedItem("COMPTYPE");

				if (ndCurAttNode != null)
					strResultType	=	ndCurAttNode.getNodeValue();
				else
					strResultType	="X";
				
				if(strResultType.equals("N") || strResultType.equals("I") )
				{
					ndCurAttNode	=	nnmpAttr.getNamedItem("REF_LOW");
					if(ndCurAttNode != null)
						strRefLow	=	 ndCurAttNode.getNodeValue();

					ndCurAttNode	=	nnmpAttr.getNamedItem("REF_HIGH");
					if(ndCurAttNode != null)
						strRefHigh	=	 ndCurAttNode.getNodeValue();

					ndCurAttNode	=	nnmpAttr.getNamedItem("CRIT_LOW");
					if(ndCurAttNode != null)
						strCriLow	=	 ndCurAttNode.getNodeValue();

					ndCurAttNode	=	nnmpAttr.getNamedItem("CRIT_HIGH");
					if(ndCurAttNode != null)
						strCriHigh	=	 ndCurAttNode.getNodeValue();
				}
				
				ndCurAttNode	=	nnmpAttr.getNamedItem("SECSEQ");
				if(ndCurAttNode != null)
					strSecSeqNum	=	ndCurAttNode.getNodeValue();
				
				strNodeName		=	ndCurDataNode.getNodeName();
				strValue = "";
				
				if(strNodeName.equals("DATE-TIME-NUMERIC") || strNodeName.equals("CHECK-BOX") || strNodeName.equals("FORMULA-COMP") )
				{
					ndCurAttNode	=	nnmpAttr.getNamedItem("VALUE");
					
					if(ndCurAttNode != null)
						strValue	=	ndCurAttNode.getNodeValue();
				}
				
				if(strNodeName.equals("SHORT-TEXT") || strNodeName.equals("LONG-TEXT"))
				{
					nlChildNodes	=	ndCurDataNode.getChildNodes();
					
					ndFirstNode		=	nlChildNodes.item(0);
					ndLastNode		=	nlChildNodes.item(nlChildNodes.getLength()-1);
					
					if(ndFirstNode != null && ndFirstNode.getNodeType() == Node.TEXT_NODE)
						strValue	= ndFirstNode.getNodeValue();
					else if(ndLastNode != null && ndLastNode.getNodeType() == Node.TEXT_NODE)
						strValue	= ndLastNode.getNodeValue();
				}
				
				if(strNodeName.equals("LIST-BOX"))
				{
					nlChildNodes	=	ndCurDataNode.getChildNodes();
					nChildLength	= 	nlChildNodes.getLength();
					
					for(nChildCurIdx = 0; nChildCurIdx < nChildLength ;  nChildCurIdx++)
					{
						ndFirstNode		= nlChildNodes.item(nChildCurIdx);

						if(ndFirstNode.getNodeType() == Node.ELEMENT_NODE)
						{
							nnmpChildAttr	= ndFirstNode.getAttributes();
							ndCurAttNode	= 	nnmpChildAttr.getNamedItem("SELECTED");

							if(ndCurAttNode != null )
							{
								strTemp	= ndCurAttNode.getNodeValue();

								if(strTemp.equalsIgnoreCase("TRUE"))
								{
									ndCurAttNode	= ndFirstNode.getFirstChild();
									
									if(ndCurAttNode != null)
										strValue		= ndCurAttNode.getNodeValue();
								}
							}
						}
					}
				}

				if(strNodeName.equals("MULTI-LIST"))
				{
					nlChildNodes	=	ndCurDataNode.getChildNodes();
					nChildLength	= 	nlChildNodes.getLength();
					
					for(nChildCurIdx = 0; nChildCurIdx < nChildLength ;  nChildCurIdx++)
					{
						ndFirstNode		= nlChildNodes.item(nChildCurIdx);
						
						if(ndFirstNode.getNodeName().equalsIgnoreCase("MULTI-LIST-ROW"))
						{
							nlRowNodes		= ndFirstNode.getChildNodes();
							
							nRowLength		= nlRowNodes.getLength();
							
							for(int nRowIdx = 0; nRowIdx < nRowLength; nRowIdx++)
							{
								ndFirstRowNode	= nlRowNodes.item(nRowIdx);
								
								if(ndFirstRowNode.getNodeType() == Node.ELEMENT_NODE)
								{
									nnmpChildAttr	= ndFirstRowNode.getAttributes();
									ndCurAttNode	= 	nnmpChildAttr.getNamedItem("SELECTED");

									if(ndCurAttNode != null )
									{
										nlRowDataNodes	= ndFirstRowNode.getChildNodes();
										ndFirstDtRow	= nlRowDataNodes.item(0);
										ndLastDtRow		= nlRowDataNodes.item(nlRowDataNodes.getLength()-1);
										
										if(ndFirstDtRow != null && ndFirstDtRow.getNodeType() == Node.TEXT_NODE)
											strSelValue	= ndFirstDtRow.getNodeValue();
										else if (ndLastDtRow != null && ndLastDtRow.getNodeType() == Node.TEXT_NODE)
											strSelValue	= ndLastDtRow.getNodeValue();
										
										if(strValue.equals(""))
											strValue	= strSelValue;
										else
											//strValue	+= "," + strSelValue;
											strValue	= strValue + "," + strSelValue;
									}

									strSelValue	=	"";
								}
							}
						}
					}

					ndLastDtRow		=	XPathAPI.selectSingleNode(ndCurDataNode,"//TEXT");
					
					nnmpChildAttr	= ndLastDtRow.getAttributes();
					ndCurAttNode	= nnmpChildAttr.getNamedItem("VALUE");
					
					if(ndCurAttNode != null)
						strSelValue	= ndCurAttNode.getNodeValue();
					
					if(strValue.equals(""))
						strValue = strSelValue;
					else
						//strValue += "," + strSelValue;
						strValue = strValue + "," + strSelValue;
				}

				if(strNodeName.equals("MATRIX") || strNodeName.equals("GRID")  || strNodeName.equals("PARAGRAPH") )
				{
					StringBuffer sbFullDtls		= new StringBuffer();
					String p_header				=	"<table border=0 cellspacing=0 width='100%' style=font-family:Verdana>";
					String p_footer_txt			=	"</table>";

					DOMSource dsGroupComp		= new DOMSource(ndCurDataNode);

					strValue			=	m_converter.buildHTMLFromNode(dsGroupComp,m_xslfile);

					sbFullDtls.append(p_header);
					sbFullDtls.append(strValue);
					sbFullDtls.append(p_footer_txt);

					strValue	=	sbFullDtls.toString();
				}		

				
				bInsStat		= insertRec(con, strDiscCompId,strValue,strSecSeqNum,strResultType,strRefHigh,strRefLow,strCriHigh,strCriLow);

				if(!bInsStat)
					bResult= false;
			}
		}
		catch (Exception e2)
		{
			e2.printStackTrace(System.err);
			System.out.println(" Exception in Maternity Data Parser (B) " + e2.getMessage());
			bResult = false;
		}
		
		return bResult;
	}
	

	private boolean insertRec(Connection con, String strCompIdIn,String strValueIn,String strOccuNo,String strResultTypeIn,String strRefHighIn,String strRefLowIn,String strCriHighIn,String strCriLowIn)
	{
			boolean bStatus					=	true;
			String strQuery					=		"";					
		
			int nRecords					=	0;

			PreparedStatement	pstmt		=		null;
			ResultSet			rs			=		null;

			oracle.sql.CLOB clobMatSecContent		= null;
			java.io.Writer matContentWriter			= null;
			java.io.BufferedWriter matContentBufferedWriter = null;
			
			try
			{				
				if(this.m_opmode.equals("Update") )
				{
					if(strResultTypeIn.equals("I") || strResultTypeIn.equals("N") || strResultTypeIn.equals("S") || 
					  (strResultTypeIn.equals("A") && !strValueIn.equals(""))){
						strQuery		=	"UPDATE CA_SPLTY_DISCR_MSR SET RESULT_NUM = ? WHERE ACCESSION_NUM	 = ? AND DISCR_MSR_ID	 = ? AND OCCURANCE_NO = ? AND SEC_HDG_CODE = ? AND SUBSEC_HDG_CODE = ?";
					}else if(strResultTypeIn.equals("L") || strResultTypeIn.equals("C") || strResultTypeIn.equals("D") ||  
							strResultTypeIn.equals("E") || strResultTypeIn.equals("A") || strResultTypeIn.equals("T") || strResultTypeIn.equals("H") || strResultTypeIn.equals("M") ) {
						strQuery		=	"UPDATE CA_SPLTY_DISCR_MSR SET RESULT_STR = ? WHERE ACCESSION_NUM	 = ? AND DISCR_MSR_ID	 = ?  AND OCCURANCE_NO = ? AND SEC_HDG_CODE = ? AND SUBSEC_HDG_CODE = ?";
					}else if( strResultTypeIn.equals("F")  || strResultTypeIn.equals("G")  || strResultTypeIn.equals("X")  || strResultTypeIn.equals("P") ){
						strQuery		=	"SELECT RESULT_DATA FROM CA_SPLTY_DISCR_MSR  WHERE ACCESSION_NUM	 = ? AND DISCR_MSR_ID	 = ?  AND OCCURANCE_NO = ? AND SEC_HDG_CODE = ? AND SUBSEC_HDG_CODE = ? FOR UPDATE";
					}
					//pstmt	=	cnParser.prepareStatement(strQuery);
					pstmt	=	con.prepareStatement(strQuery);

					if(strResultTypeIn.equals("I") || strResultTypeIn.equals("N") || strResultTypeIn.equals("S") ||
					   strResultTypeIn.equals("A") || strResultTypeIn.equals("L") || strResultTypeIn.equals("C") ||
					   strResultTypeIn.equals("D") || strResultTypeIn.equals("E") || strResultTypeIn.equals("A") ||
					   strResultTypeIn.equals("T") || strResultTypeIn.equals("H") || strResultTypeIn.equals("M"))
					{
						pstmt.setString(1,strValueIn);
						pstmt.setString(2,m_accession_num);
						pstmt.setString(3,strCompIdIn);
						pstmt.setString(4,m_sechdgcode);
						pstmt.setString(5,m_subsechdgcode);

						nRecords	= pstmt.executeUpdate();

						if(nRecords > 0)
							bStatus	= true;
						else
							bStatus	= false;
					}
					else if( strResultTypeIn.equals("F")  || strResultTypeIn.equals("G")  || strResultTypeIn.equals("X")  || strResultTypeIn.equals("P") )
					{
						pstmt.setString(1,m_accession_num);
						pstmt.setString(2,strCompIdIn);
						pstmt.setString(3,strOccuNo);
						pstmt.setString(4,m_sechdgcode);
						pstmt.setString(5,m_subsechdgcode);

						rs	= pstmt.executeQuery();

						if(rs != null && rs.next())
						{
							clobMatSecContent = (oracle.sql.CLOB) rs.getObject("RESULT_DATA");
							matContentWriter = ((oracle.sql.CLOB) clobMatSecContent).getCharacterOutputStream();
				
							matContentBufferedWriter = new java.io.BufferedWriter(matContentWriter	);
							matContentBufferedWriter.write(strValueIn,0,strValueIn.length());
							matContentBufferedWriter.flush();
							matContentBufferedWriter.close();
						}
					}
				}
				else
				{					
					
					if(!strValueIn.equals("") )
					{
						strQuery	=	"INSERT INTO CA_SPLTY_DISCR_MSR (DISCR_MSR_ID,ACCESSION_NUM,OCCURANCE_NO,TRANS_DATE,PATIENT_ID,FACILITY_ID,ENCOUNTER_ID,PATIENT_CLASS,MODULE_ID,CYCLE_NO,EVENT_CODE,TASK_CODE,RESULT_TYPE,RESULT_NUM,RESULT_NUM_UOM,RESULT_STR,RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SEC_HDG_CODE,SUBSEC_HDG_CODE) VALUES (?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,empty_clob(),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)";

						//pstmt	= cnParser.prepareStatement(strQuery);					

						pstmt	= con.prepareStatement(strQuery);

						pstmt.setString(1,strCompIdIn);
						pstmt.setString(2,m_accession_num);
						pstmt.setString(3,strOccuNo);
						pstmt.setString(4,m_transDate);
						pstmt.setString(5,m_patientId);
						pstmt.setString(6,m_facilityId);
						pstmt.setString(7,m_encounterId);
						pstmt.setString(8,m_patientClass);
						pstmt.setString(9,m_moduleid);
						pstmt.setString(10,m_cycleno);
						pstmt.setString(11,m_eventcode);
						pstmt.setString(12,m_taskcode);
						pstmt.setString(13,strResultTypeIn);		

						if(strResultTypeIn.equals("I") || strResultTypeIn.equals("N") || strResultTypeIn.equals("S") || 
						  (strResultTypeIn.equals("A") && !strValueIn.equals("")))
						{
							pstmt.setString(14,strValueIn);
							pstmt.setString(15,"");
							pstmt.setString(16,"");

							/* pstmt.setString(14,"");
							pstmt.setString(15,"");
							pstmt.setString(16,strValueIn); */
						}
						else if(strResultTypeIn.equals("L") || strResultTypeIn.equals("C") || strResultTypeIn.equals("D") ||  
							strResultTypeIn.equals("E") || strResultTypeIn.equals("A") || strResultTypeIn.equals("T") || strResultTypeIn.equals("H") || strResultTypeIn.equals("M") )
						{
							pstmt.setString(14,"");
							pstmt.setString(15,"");
							pstmt.setString(16,strValueIn);
						}
						else
						{
							pstmt.setString(14,"");
							pstmt.setString(15,"");
							pstmt.setString(16,"");
						}
						
						pstmt.setString(17,strRefLowIn);
						pstmt.setString(18,strRefHighIn);
						pstmt.setString(19,strCriLowIn);
						pstmt.setString(20,strCriHighIn);
						pstmt.setString(21,m_added_user_id);
						pstmt.setString(22,m_added_ws_no);
						pstmt.setString(23,m_facilityId);
						pstmt.setString(24,m_added_user_id);
						pstmt.setString(25,m_added_ws_no);
						pstmt.setString(26,m_facilityId);
						pstmt.setString(27,m_sechdgcode);
						pstmt.setString(28,m_subsechdgcode);

						nRecords	= pstmt.executeUpdate();

						if(nRecords > 0)
							bStatus	= true;
						else
							bStatus	= false;

						if(strResultTypeIn.equals("G") || strResultTypeIn.equals("X")|| strResultTypeIn.equals("P") || strResultTypeIn.equals("F") ) 
						{
							if(bStatus)
							{
								strQuery = "SELECT RESULT_DATA FROM CA_SPLTY_DISCR_MSR WHERE ACCESSION_NUM = ? AND DISCR_MSR_ID = ? AND OCCURANCE_NO = ? AND SEC_HDG_CODE = ? AND SUBSEC_HDG_CODE = ? FOR UPDATE";

								pstmt.clearParameters();
								//pstmt	= cnParser.prepareStatement(strQuery);
								pstmt	= con.prepareStatement(strQuery);

								pstmt.setString(1,m_accession_num);
								pstmt.setString(2,strCompIdIn);
								pstmt.setString(3,strOccuNo);
								pstmt.setString(4,m_sechdgcode);
								pstmt.setString(5,m_subsechdgcode);

								rs	= pstmt.executeQuery();

								if(rs != null && rs.next())
								{
									clobMatSecContent = (oracle.sql.CLOB) rs.getObject("RESULT_DATA");
									
									matContentWriter = ((oracle.sql.CLOB) clobMatSecContent).getCharacterOutputStream();
					
									matContentBufferedWriter = new java.io.BufferedWriter(matContentWriter	);
									matContentBufferedWriter.write(strValueIn,0,strValueIn.length());
									matContentBufferedWriter.flush();
									matContentBufferedWriter.close();
								}
							}
						}	
					}
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			catch (Exception e2)
			{
				if(pstmt != null) pstmt.close();
				bStatus = false;
				System.out.println(" Record Updation Failiure in MaternityData Parser For " + strCompIdIn + " / " + m_accession_num + " / " + m_subsechdgcode) ;
				e2.printStackTrace(System.err);
			}
			finally
			{				
				return bStatus;
			}
	}
}
