/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * Created on May 10, 2006
 * Bean Name: RecClinicalNotesSectionBean
 */ 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name	Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
24/01/2018	IN063931		Prakash C	25/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)								
------------------------------------------------------------------------------------------------------------------------------
*/
package webbeans.eCA;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Properties;

public class RecClinicalNotesSectionBean implements Serializable
{
		Properties	propPatientSection	=	null;
		Properties	propSection			=	null;

		boolean		bean_status			=	false;
		String operational_status       ="N";
		Hashtable PatientHash =new Hashtable(); 
		
		public RecClinicalNotesSectionBean()
		{
			propPatientSection		=	new Properties();
			propSection				=	new Properties();
			bean_status				=	true;
			 operational_status       ="N";
		}

		public Properties startPatientSection(String patient_id) throws java.lang.Exception
		{
			String error_msg = "";

			try
			{
				if ( validatePatientId(patient_id) )
				{
					propSection			=	new Properties();
					propPatientSection.put(patient_id,propSection);
					
					return propSection;
				}
				else
				{
					error_msg = "Exception@startpatientsection: Patient id is not valid ";
					throw new Exception(error_msg);
				}
			}
			catch (Exception e)
			{
				error_msg = "Exception@startpatientsection: " + e;
				throw new Exception(error_msg);
			}
		}
		// New Method Added by Sridhar Reddy V on 28/05/2008 for Tracing Patient Context Existance in Bean
		public String getpropPatientSection(String patientKey){
			String patientKeyInBean = "";
			String resultStr = "";
			if(propPatientSection != null){
					java.util.Enumeration em = propPatientSection.propertyNames();
					while (em.hasMoreElements()){
						patientKeyInBean =(String) em.nextElement();						
						if (patientKey.equals(patientKeyInBean)){
							resultStr = "patientKey   ***"+patientKey+"***    Exists in Bean";							
						}else{
							resultStr = "patientKey  ***"+patientKey+"**** NotExists in Bean";							
						}
					}
			}
			return resultStr;
		}
	// New Method End

		public Properties getPatientSection(String patient_id) throws java.lang.Exception 
		{
			String error_msg	=	"";

			try
			{
				if ( validatePatientId(patient_id) )
				{
					propSection			=	(Properties) propPatientSection.get(patient_id);
	
					if(propSection == null)	
					{
						propSection		=	new Properties();
						propPatientSection.put(patient_id,propSection);
					}
				}
				else
				{
					error_msg = "Exception@getPatientSection : Patient id is not valid";
					throw new Exception(error_msg);
				}
			}
			catch(Exception e)
			{
				error_msg	=	"Exception@getPatientSection(java.lang.String) : "+e;
				throw new Exception(error_msg);
			}
		
			return propSection;
		}

		public boolean removePatientSection(String patient_id) throws java.lang.Exception
		{
			String error_msg	=	"";
		
			try
			{
				if ( validatePatientId(patient_id) )
				{
					propSection			=	(Properties) propPatientSection.get(patient_id);

					if(propSection != null)
					{
						propPatientSection.remove(patient_id);
						return true;
					}
				}
				else
				{
					error_msg = "Exception@removePatientSection : Patient id is not valid";
					throw new Exception(error_msg);
				}
			}
			catch(Exception e)
			{
				error_msg	=	"Exception@removePatientSection(java.lang.String) : "+e;
				throw new Exception(error_msg);
			}

			return false;
		}

		public boolean setSection ( String sec_hdg_code,String sub_sec_hdg_code ) throws java.lang.Exception
		{
				String error_msg	=	"";
				Properties section_prop = new Properties();
				
				boolean	operation_status	=	true;
				
				if( propSection == null )	
					bean_status	=	false;
					
				if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
				{
					operation_status = false;
					error_msg = "Exception@ setSection : section/subsection values not proper";	
					throw new Exception(error_msg);
				}
				
				if(bean_status && operation_status)
				{
					try
					{
						String key = sec_hdg_code.trim()+"~~"+sub_sec_hdg_code.trim();
						propSection.put ( key, section_prop );
						operation_status	=	true;
					}
					catch(Exception e)
					{
						operation_status	=	false;
						error_msg	=	"Exception@setSection(java.lang.String,java.util.Properties) : "+e;
						throw new Exception(error_msg);
					}
				} // end of if(bean_status)
	
			return operation_status;
		}

		public boolean setSectionValues ( String sec_hdg_code,String sub_sec_hdg_code, String sec_type, String doc_link_yn, String result_link_yn,String image_link_yn, String chief_complaint_yn, String history_type, String image_edited_yn, String edited_yn, String section_content, String image_content,String output_form_exists_yn )  throws java.lang.Exception
		{
			String error_msg = "";

			Properties		section_prop	=	null;
			HashSet			hsChiefComp		=	null;

			hsChiefComp	= new HashSet();

			boolean	operation_status	=	true;
			
			if( propSection == null )	
				bean_status	=	false;
				
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@setSectionValues() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}
		
			if(bean_status && operation_status)
			{
				try
				{
					String key 		= 	sec_hdg_code.trim() + "~~" + sub_sec_hdg_code.trim();
					section_prop	=	( Properties )	propSection.get(key);

					if( section_prop == null ) 
						section_prop	=	new	Properties();
				
					section_prop.put	( "SECTION_TYPE"			,	sec_type );
					
					if(sec_hdg_code.equals(sub_sec_hdg_code))
						section_prop.put	( "SUB_SECTION_YN"				,	"" );
					else
						section_prop.put	( "SUB_SECTION_YN"				,	"S" );
						
					section_prop.put	( "DOC_LINK_YN"				,	doc_link_yn );
					section_prop.put	( "IMAGE_LINK_YN"			,	image_link_yn );
					section_prop.put	( "CHIEF_COMPLAINT_YN"		,	chief_complaint_yn );
					section_prop.put	( "HISTORY_TYPE"			,	history_type );
					section_prop.put	( "IMAGE_EDITED_YN"			,	image_edited_yn );
					section_prop.put	( "EDITED_YN"				,	edited_yn );
					section_prop.put	( "SECTION_CONTENT"			,	section_content );
					section_prop.put	( "SECTION_IMAGE_CONTENT"	,	image_content );
					section_prop.put	( "RESULT_LINK_YN"			,	result_link_yn);
					section_prop.put	("CHIEF_COMPLAINTS"			,	hsChiefComp);
					section_prop.put	("OUTPUT_FORM_EXISTS_YN"			,	output_form_exists_yn);

					propSection.put		( key,		section_prop );
					operation_status	=	true;
	
				} // end of try
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@setSectionValues() : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)
		
			return operation_status;
		} 

		public boolean setSectionContent ( String sec_hdg_code,String sub_sec_hdg_code, String section_content )  throws java.lang.Exception
		{
			String error_msg = "";
			Properties		section_prop	=	null;

			boolean operation_status = true;			
			
			if( propSection == null )	
				bean_status		=	false;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@setSectionContent() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}
			
			if(bean_status && operation_status)
			{
				try
				{
					String key 			= 	sec_hdg_code.trim() + "~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);

					if( section_prop != null ) 
					{
						section_prop.put	( "SECTION_CONTENT",	section_content );
						section_prop.put	( "EDITED_YN"	   ,	"Y" );
						propSection.put		( key,		section_prop );
						
						operation_status	=	true;
					}
				} 
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@setSectionContent(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				} 
			} // end of if(bean_status)
	
			return operation_status;
		}
	
		public java.lang.Object getSectionContent(String sec_hdg_code,String sub_sec_hdg_code ) throws java.lang.Exception
		{
			String error_msg = "";
			Properties		section_prop		=	null;
			java.lang.Object			section_content		=	null;

			boolean operation_status = true;

			if(propSection==null)		
				bean_status	=	false;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@getSectionContent() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() + "~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
			
					if(section_prop != null)
						section_content	=	section_prop.get("SECTION_CONTENT");
				}
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@getSectionContent(java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				}
			 } // end of if(bean_status)
			
			 return	section_content;
		} 

		public boolean removeSectionContent ( String sec_hdg_code,String sub_sec_hdg_code )  throws java.lang.Exception
		{
			String error_msg = "";
			String strExistingContent = "";

			boolean operation_status = true;

			Properties		section_prop	=	null;

			if( propSection == null )	
				bean_status		=	false;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@removeSectionContent() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					strExistingContent  = (String) getSectionContent(sec_hdg_code,sub_sec_hdg_code);

					if(strExistingContent != null)
					{
						if(strExistingContent.length() > 0)
						{
							section_prop		=	( Properties )	propSection.get(key);
							section_prop.put	( "SECTION_CONTENT" , "");
							propSection.put		( key,			section_prop );
							operation_status	=	true;
						}
					}
				} 
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@removeSectionContent(java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				} 
			} 
			
			return operation_status;
		} 
	
		public boolean setSectionImageContent ( String sec_hdg_code,String sub_sec_hdg_code,String section_image_content )  throws java.lang.Exception
		{
			String error_msg = ""; 
			Properties		section_prop	=	null;

			if( propSection == null )	
				bean_status		=	false;
			
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
					operation_status = false;
					error_msg	=	"Exception@setSectionImageContent() : section/sub section values not proper";
					throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);

					if( section_prop == null ) 
						section_prop	=	new	Properties();
				
					section_prop.put	( "SECTION_IMAGE_CONTENT",	section_image_content );
					section_prop.put	( "IMAGE_EDITED_YN"		,	"Y" );
					propSection.put		( key,		section_prop );
					operation_status	=	true;
				} // end of try
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@setSectionImageContent(java.lang.String, java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)	

			return operation_status;
		}

		public java.lang.Object getSectionImageContent(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			String error_msg = ""; 
			Properties	section_prop		=	null;
			java.lang.Object		section_content		=	null;
	
			if(propSection == null)	
				bean_status		=	false;
			
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
					operation_status = false;
					error_msg	=	"Exception@getSectionImageContent() : section/sub section values not proper";
					throw  new Exception(error_msg);
			}
				if(bean_status && operation_status)
				{
					try
					{
						String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
						section_prop	=	((Properties) propSection.get(key));
					
						if(section_prop != null)
							section_content	=	section_prop.get("SECTION_IMAGE_CONTENT");
					}
					catch(Exception e)
					{
						operation_status = false;
						error_msg	=	"Exception@getSectionImageContent(java.lang.String, java.lang.String) : "+e;
						throw new Exception(error_msg);
					}
				} 
			return	section_content;
		} 
		//IN053298 Start.
		public boolean setSectionImageHeight ( String sec_hdg_code,String sub_sec_hdg_code,String section_image_height )  throws java.lang.Exception
		{
			String error_msg = ""; 
			Properties		section_prop	=	null;

			if( propSection == null )	
				bean_status		=	false;
			
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
					operation_status = false;
					error_msg	=	"Exception@setSectionImageHeight() : section/sub section values not proper";
					throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);

					if( section_prop == null ) 
						section_prop	=	new	Properties();
				
					section_prop.put	( "SECTION_IMAGE_HEIGHT",	section_image_height );
					propSection.put		( key,		section_prop );
					operation_status	=	true;
				} // end of try
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@setSectionImageHeight(java.lang.String, java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)	

			return operation_status;
		}
		public java.lang.String getSectionImageHeight(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			String error_msg = ""; 
			Properties	section_prop		=	null;
			java.lang.String		section_image_height		=	"0";
	
			if(propSection == null)	
				bean_status		=	false;
			
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
					operation_status = false;
					error_msg	=	"Exception@getSectionImageHeight() : section/sub section values not proper";
					throw  new Exception(error_msg);
			}
				if(bean_status && operation_status)
				{
					try
					{
						String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
						section_prop	=	((Properties) propSection.get(key));
					
						if(section_prop != null)
							section_image_height	=(section_prop.get("SECTION_IMAGE_HEIGHT"))==null?"0":(String)section_prop.get("SECTION_IMAGE_HEIGHT");
					}
					catch(Exception e)
					{
						operation_status = false;
						error_msg	=	"Exception@getSectionImageHeight(java.lang.String, java.lang.String) : "+e;
						throw new Exception(error_msg);
					}
				} 
			return	section_image_height;
		} 
		//IN053298 End.
		public void setAddendumText(String sec_hdg_code,String sub_sec_hdg_code, String ammendText) throws java.lang.Exception
		{
			Properties		section_prop	=	null;
			
			String error_msg = "";
	
			if( propSection == null )	
				bean_status		=	false;
				
			boolean	operation_status	=	true;
			
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
					operation_status = false;
					error_msg	=	"Exception@setSectionAddendum() : section/sub section values not proper";
					throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key 			= 	sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);
				
					if( section_prop == null ) 
						section_prop	=	new	Properties();
		
					section_prop.put	( "AMMEND_TEXT",ammendText );

					if(!sec_hdg_code.equals("*AmmendNotes*") )
						section_prop.put("EDITED_YN","Y");
					
					propSection.put		( key,section_prop );
								
				} // end of try
				catch(Exception e)
				{
					operation_status = false;
					error_msg	=	"Exception@setSectionAddendumText(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)
		}

		public String getAddendumText(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			String error_msg = "";

			Properties	section_prop		=	null;
			String ammendText = "";
			
			if(propSection==null)	
				bean_status	=	false;
				
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@getSectionAddendum() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop != null)
					{
						ammendText	=	(String)section_prop.get("AMMEND_TEXT");
						operation_status = true;
					}
				}
				catch(Exception e)
				{
					operation_status = false;
					error_msg	=	"Exception@setSectionAddendumText(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				}
			} 
			
			return	ammendText;
		}

		public boolean setSectionChiefComplaint(String sec_hdg_code,String sub_sec_hdg_code, HashSet set) throws java.lang.Exception
		{
			Properties		section_prop	=	null;
			String error_msg = "";

			if( propSection == null )	
				bean_status		=	false;
				
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@setSectionChiefComplaint() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}
				
			if(bean_status && operation_status)
			{
				try
				{
					String key 			= sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);

					if( section_prop == null ) 
						section_prop	=	new	Properties();

					section_prop.put	( "CHIEF_COMPLAINTS",set );
					propSection.put		( key,section_prop );
				} // end of try
				catch(Exception e)
				{
					operation_status = false;
					error_msg	=	"Exception@setSectionChiefComplaint(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)
			
			return operation_status;
		}

		public HashSet getSectionChiefComplaint(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			Properties	section_prop		=	null;
			HashSet set = null;
			String error_msg = "";
			
			if(propSection==null)	
				bean_status		=	false;
			
			boolean	operation_status	=	true;
			
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@getSectionChiefComplaint() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			try
			{
				if(bean_status && operation_status)
				{
					String key 		= 	sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop != null )
						set	=	(HashSet)section_prop.get("CHIEF_COMPLAINTS");
				}
			}
			catch (Exception e)
			{
				operation_status = false;
				error_msg	=	"Exception@getSectionChiefComplaint(java.lang.String, java.lang.String) : "+e;
				throw new Exception(error_msg);
			} 
			
			return	set;
		}

		public boolean removeSectionChiefComplaint ( String sec_hdg_code,String sub_sec_hdg_code )  throws java.lang.Exception
		{
			String error_msg = "";
			Properties		section_prop	=	null;
			
			if( propSection == null )	
				bean_status		=	false;
			
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@removeSectionChiefComplaint() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			try
			{
				if(bean_status && operation_status)
				{
					try
					{
						String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
						section_prop		=	( Properties )	propSection.get(key);
						section_prop.remove	( "CHIEF_COMPLAINTS" );
						propSection.put( key,	section_prop );
						operation_status	=	true;
					} // end of try
					catch(Exception e)
					{
						operation_status	=	false;
						error_msg	=	"Exception@removeSectionChiefComplaint(java.lang.String) : "+e;
						throw new Exception(error_msg);
					} // end of catch
				} // end of if(bean_status)
			}
			catch (Exception e)
			{
				operation_status = false;
				error_msg	=	"Exception@removeSectionChiefComplaint(java.lang.String, java.lang.String) : "+e;
				throw new Exception(error_msg);
			}
	
			return operation_status;
		} 

		public boolean setExistingSectionChiefComplaint(String sec_hdg_code,String sub_sec_hdg_code, HashSet set) throws java.lang.Exception
		{
			Properties		section_prop	=	null;
			
			String error_msg = "";
			
			if( propSection == null )	
				bean_status		=	false;
			
			boolean	operation_status	=	true;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@setExistingSectionChiefComplaint() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}
			
			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);
					
					if( section_prop == null ) 
						section_prop	=	new	Properties();

					section_prop.put	( "CHIEF_COMPLAINTS_EXISTING",set );
					propSection.put		( key,section_prop );
				} // end of try
				catch(Exception e)
				{
					operation_status = false;
					error_msg	=	"Exception@setSectionChiefComplaint(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)
			
			return operation_status;
		}

		public HashSet getExistingSectionChiefComplaint(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			String error_msg = "";
			Properties	section_prop		=	null;
			HashSet set = null;
			
			if(propSection == null)	
				bean_status		=	false;
			
			boolean	operation_status	=	true;
						
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@getExistingSectionChiefComplaint() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key 		= 	sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop != null)
						set	=	(HashSet)section_prop.get("CHIEF_COMPLAINTS_EXISTING");
				}
				catch(Exception e)
				{
					operation_status = false;
					error_msg	=	"Exception@getExistingSectionChiefComplaint(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				}
			} 
			
			return	set;
		}

		public boolean removeExistingSectionChiefComplaint ( String sec_hdg_code,String sub_sec_hdg_code )  throws java.lang.Exception
		{
			String error_msg = "";
			Properties		section_prop	=	null;
			
			if( propSection == null )	
				bean_status		=	false;
			
			boolean	operation_status	=	true;
			
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@removeExistingSectionChiefComplaint() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key 			= 	sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )propSection.get(key);
					
					section_prop.remove	( "CHIEF_COMPLAINTS_EXISTING" );
					propSection.put( key,	section_prop );
					operation_status	=	true;
				} // end of try
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@removeExistingSectionChiefComplaint(java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)
			
			return operation_status;
		} 

		public boolean setSectionImageEdited ( String sec_hdg_code,String sub_sec_hdg_code,String image_edited_yn )  throws java.lang.Exception
		{
			String error_msg = ""; 
			Properties		section_prop	=	null;

			if( propSection == null )	
				bean_status		=	false;
			
			boolean	operation_status	=	true;
			
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@setSectionImageEdited() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);

					if( section_prop == null ) 
						section_prop	=	new	Properties();
				
					section_prop.put	( "IMAGE_EDITED_YN",	image_edited_yn );

					propSection.put		( key,		section_prop );
					operation_status	=	true;
				} // end of try
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@setSectionImageEdited(java.lang.String, java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)	

			return operation_status;
		}

		public String getSectionImageEdited(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			String error_msg 			= "";
			String image_edited_yn		= ""; 
			Properties	section_prop =	null;
			
	
			if(propSection==null)	
				bean_status		=	false;
			
			boolean	operation_status	=	true;
				
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@getSectionImageEdited() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();

				try
				{
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop!=null)
						image_edited_yn	=	(String) section_prop.get("IMAGE_EDITED_YN");
				}
				catch(Exception e)
				{
					operation_status = false;
					error_msg	=	"Exception@getSectionImageEdited(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg);
				}
			} 

			return	image_edited_yn;
		} 

		public boolean setSectionEdited( String sec_hdg_code,String sub_sec_hdg_code,String edited_yn )  throws java.lang.Exception
		{
			String error_msg = ""; 
			Properties		section_prop	=	null;

			if( propSection == null )	
				bean_status		=	false;
				
			boolean	operation_status	=	true;
							
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@setSectionEdited() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
			{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop		=	( Properties )	propSection.get(key);

					if( section_prop == null ) 
						section_prop	=	new	Properties();
				
					section_prop.put	( "EDITED_YN",	edited_yn );

					propSection.put		( key,		section_prop );
					operation_status	=	true;
				} // end of try
				catch(Exception e)
				{
					operation_status	=	false;
					error_msg	=	"Exception@setSectionEdited(java.lang.String, java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				} // end of catch
			} // end of if(bean_status)	

			return operation_status;
		}

		public String getSectionEdited(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
		{
			String error_msg 	= "";
			String	edited_yn	= ""; 
			Properties	     section_prop		    =	null;
			
	
			if(propSection==null)	
				bean_status		=	false;

			boolean	operation_status	=	true;
			
			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				operation_status = false;
				error_msg	=	"Exception@getSectionEdited() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status && operation_status)
				{
					try
					{
						String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
						section_prop	=	((Properties) propSection.get(key));
					
						if(section_prop!=null)
							edited_yn	=	(String) section_prop.get("EDITED_YN");
					}
					catch(Exception e)
					{
						error_msg	=	"Exception@getSectionEdited(java.lang.String, java.lang.String) : "+e;
						throw new Exception(error_msg); 
					}
				} 
			return	edited_yn;
		}
		
	private boolean validatePatientId(String strPatientId)
	{
		boolean bRetnFlag = false;
		if ( !(strPatientId == null || strPatientId.equals("") || strPatientId.equals("null")) )
			bRetnFlag = true;
			
		return bRetnFlag;
	}
		
	private boolean validateSectionCodes(String strSecHdgCode, String strSubSecHdgCode)
	{
		boolean bRetnFlag = true;

		if( strSecHdgCode == null || strSecHdgCode.equals("") || strSecHdgCode.equals("null") || strSubSecHdgCode == null || strSubSecHdgCode.equals("") || strSubSecHdgCode.equals("null") )
				bRetnFlag = false;
	
		return bRetnFlag;
	}
		
	public String getSectionType(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		Properties	     section_prop		    =	null;
			
		if(propSection==null)	
			bean_status		=	false;

		boolean	operation_status	=	true;
			
		if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
		{
			operation_status = false;
			error_msg	=	"Exception@getSectionType() : section/sub section values not proper";
			throw  new Exception(error_msg);
		}

		if(bean_status && operation_status)
		{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop!=null)
						return_value	=	(String) section_prop.get("SECTION_TYPE");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getSectionType(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}

	public String getImageLinked(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		Properties	     section_prop		    =	null;
			
	  // boolean operation_status	=	true;  commented for checkstyle 

		if(propSection==null)	
			bean_status		=	false;
	
		if(bean_status)
		{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop!=null)
						return_value	=	(String) section_prop.get("IMAGE_LINK_YN");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getImageLinked(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}
		
	public String getDocLinked(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		Properties	     section_prop		    =	null;
			
		if(propSection==null)	
			bean_status		=	false;

		boolean	operation_status	=	true;
			
		if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
		{
			operation_status = false;
			error_msg	=	"Exception@getDocLinked() : section/sub section values not proper";
			throw  new Exception(error_msg);
		}

		if(bean_status && operation_status)
		{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop!=null)
						return_value	=	(String) section_prop.get("DOC_LINK_YN");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getDocLinked(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}
		
	public String getChiefComplaintSection(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		
		Properties	     section_prop		    =	null;
			
		if(propSection==null)	
			bean_status		=	false;

		boolean	operation_status	=	true;
			
		if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
		{
			operation_status = false;
			error_msg	=	"Exception@getChiefComplaintSection() : section/sub section values not proper";
			throw  new Exception(error_msg);
		}

		if(bean_status && operation_status)
		{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop!=null)
						return_value	=	(String) section_prop.get("CHIEF_COMPLAINT_YN");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getChiefComplaintSection(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}
		
	public String getHistoryType(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		
		Properties	     section_prop		    =	null;
			
		if(propSection==null)	
			bean_status		=	false;

		boolean	operation_status	=	true;
			
		if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
		{
			operation_status = false;
			error_msg	=	"Exception@getHistoryType() : section/sub section values not proper";
			throw  new Exception(error_msg);
		}

		if(bean_status && operation_status)
		{
				try
				{
					String key = sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop!=null)
						return_value	=	(String) section_prop.get("HISTORY_TYPE");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getHistoryType(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}

	public String getSectionLevel(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		
		Properties	 section_prop		    =	null;
			
		if(propSection==null)	
			bean_status		=	false;

		boolean	operation_status	=	true;
			
		if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
		{
			operation_status = false;
			error_msg	=	"Exception@getSectionLevel() : section/sub section values not proper";
			throw  new Exception(error_msg);
		}

		if(bean_status && operation_status)
		{
				try
				{
					String key 		= sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop != null)
						return_value	=	(String) section_prop.get("SUB_SECTION_YN");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getSectionLevel(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}

	public String getResultLinked(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{
		String error_msg 	= "";
		String return_value	= ""; 
		
		Properties	 section_prop		    =	null;
			
		if(propSection==null)	
			bean_status		=	false;

		boolean	operation_status	=	true;
			
		if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
		{
			operation_status = false;
			error_msg	=	"Exception@getResultLinked() : section/sub section values not proper";
			throw  new Exception(error_msg);
		}

		if(bean_status && operation_status)
		{
				try
				{
					String key 		=	sec_hdg_code.trim() +"~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
					
					if(section_prop != null)
						return_value	=	(String) section_prop.get("RESULT_LINK_YN");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getResultLinked(java.lang.String, java.lang.String) : "+e;
					throw new Exception(error_msg); 
				}
		} 
	
		return	return_value;
	}

	public String getSectionWithAddendumText(String sec_hdg_code,String sub_sec_hdg_code,String clinician_name,String resp_name, String sys_date_time) throws Exception
	{
		String section_content = "";
	//	String error_msg = ""; commented for checkstyle
		String content_type = "";
		String ammend_text = "";
		String section_content_temp = "";

	//	Properties	 section_prop		    =	null; commented for checkstyle
	//	boolean		 operation_status		=	true; commented for checkstyle
			
		if(propSection == null)	
			bean_status		=	false;

		
		if(bean_status)
		{
			section_content = (String) getSectionContent( sec_hdg_code, sub_sec_hdg_code );
			content_type = (String) getSectionType( sec_hdg_code, sub_sec_hdg_code);
			ammend_text = (String) getAddendumText( sec_hdg_code, sub_sec_hdg_code);

			if(section_content == null)
				section_content = "";

			if(ammend_text == null)
				ammend_text  = "";
			section_content_temp = section_content;

			if (content_type.equals("T"))
			{
				if( !section_content.equals("") )
					section_content = section_content.substring(0,section_content.indexOf("</USER-TEMPLATE>"));

				section_content +="<USER-TEMPLATE-ADDENDUM CREATED-BY='"+replaceSpecialChars(clinician_name)+"' DATE='"+sys_date_time+"'>"+replaceSpecialChars(ammend_text)+"</USER-TEMPLATE-ADDENDUM>";
				section_content+="</USER-TEMPLATE>";
			}
			else
			{
				section_content +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I>Addendum Created By: "+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr></table>";
			}
			if(!(ammend_text.equals("")))
			{
				setSectionContent(sec_hdg_code,sub_sec_hdg_code,section_content);
			}
		}
		return section_content;
	}
	public String getOutputExistYN(String sec_hdg_code,String sub_sec_hdg_code) throws java.lang.Exception
	{

		String output_yn ="N";
		String error_msg = "";

		Properties		section_prop		=	null;
						
			if(propSection==null)		
				bean_status	=	false;

			if ( !(validateSectionCodes(sec_hdg_code, sub_sec_hdg_code)) )
			{
				
				error_msg	=	"Exception@getOutputExistYN() : section/sub section values not proper";
				throw  new Exception(error_msg);
			}

			if(bean_status)
			{
				try
				{
					String key = sec_hdg_code.trim() + "~~"+ sub_sec_hdg_code.trim();
					section_prop	=	((Properties) propSection.get(key));
			
					if(section_prop != null)
						output_yn	=	(String)section_prop.get("OUTPUT_FORM_EXISTS_YN");
				}
				catch(Exception e)
				{
					error_msg	=	"Exception@getSectionContent(java.lang.String,java.lang.String) : "+e;
					throw new Exception(error_msg);
				}
			 } // end of if(bean_status)
			
			 return	output_yn;

	

	}

	// new methods for patient info for outformat

	public void setPatOutDetails(Hashtable PatDetHash, String patientId) throws java.lang.Exception
	{

			
		PatientHash.put(patientId,PatDetHash);
			

	}

	public Hashtable getPatOutDetails(String patientId) throws java.lang.Exception
	{
			Hashtable PatDetHash= new Hashtable();
			
			PatDetHash =(Hashtable)PatientHash.get(patientId);
			 return	PatDetHash;

	}


	// ends...

	private String replaceNewLine(String input)
	{
		if( !input.equals("") )
			input = input.replaceAll("\n","<br>");	
		
		return input;
	}
	
	private String replaceSpecialChars(String input)
	{
		if( !input.equals("") )
		{
			if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
			if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
			if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");	
		}

		return input;
	}
//IN063931 starts
public void setCopyPrevSectionYN (String display)  throws java.lang.Exception
		{
				if(display.equals("Y"))
					operational_status ="Y";
		}

public String getCopyPrevSectionYN ()  throws java.lang.Exception
		{
		return operational_status ;
		}
//IN063931 ends
	/*
		public static void main (String args[])
		{
			try
			{
				 test Cases 
				NewRecClinicalNotesSectionBean nRnBean = new NewRecClinicalNotesSectionBean();
	
				
				
				Properties p1 = null;				
				p1 = nRnBean.getPatientSection("LD004343");
				nRnBean.getPatientSection("LD004343");
				nRnBean.getPatientSection("LD005353");

//				nRnBean.setSection("ST4","ST4");
/*
//				nRnBean.setSection("ST4","ST23");
//				nRnBean.setSection("","");
//				nRnBean.setSection("","ST4");
//				nRnBean.setSection("ST4","");
//				nRnBean.setSection("null","");
//				nRnBean.setSection("","null");
//				nRnBean.setSection("null","null");
//				nRnBean.setSection(null,null);

				nRnBean.setSectionValues("ST4","ST231","M","M","M","M","M","M","M","SEC2","IMA2 CONTENT");
				nRnBean.getPatientSection("LD004343");			
				nRnBean.setSectionValues("ST4","ST23","N","N","N","N","M","N","N","SEC1","IMA1 CONTENT");
				nRnBean.getPatientSection("LD005353");

				nRnBean.setSectionContent("ST4","ST231","First Setting for LD005353");  
				nRnBean.getPatientSection("LD004343");
				nRnBean.setSectionContent("ST4","ST23","First Setting for LD004343");
				
				nRnBean.getPatientSection("LD005353");
				System.out.println("Section Content For LD005353 for section 231 " + nRnBean.getSectionContent("ST4","ST231"));
				System.out.println("Section Type For LD005353 for section 231 " + nRnBean.getSectionType("ST4","ST231"));
				nRnBean.getPatientSection("LD004343");
				System.out.println("Section Content For LD004343 for section 23 " + nRnBean.getSectionContent("ST4","ST23"));
				System.out.println("Section Type For LD004343 for section 23 " + nRnBean.getSectionType("ST4","ST23"));
				System.out.println("Setting Img Content for 231 : " + nRnBean.setSectionImageContent("ST4","ST231","First Image Setting"));  
				System.out.println("Setting Img Content for 23 : " + nRnBean.setSectionImageContent("ST4","ST23","Second Second Setting"));
 
				System.out.println("Section Content FROM 231: " + nRnBean.getSectionContent("ST4","ST231"));
				System.out.println("Section Content FROM 23: " + nRnBean.getSectionContent("ST4","ST23"));
				System.out.println("iMAGE Content FROM 231: " + nRnBean.getSectionImageContent("ST4","ST231"));
				System.out.println("IMAGE Content FROM 23: " + nRnBean.getSectionImageContent("ST4","ST23"));

				System.out.println("Get Section Edited " + nRnBean.getSectionEdited("ST4","ST23"));
				System.out.println("Set Section Edited " + nRnBean.setSectionEdited("ST4","ST23","N"));
				System.out.println("Get Section Edited " + nRnBean.getSectionEdited("ST4","ST23"));

				System.out.println("Get Section Image Edited " + nRnBean.getSectionImageEdited("ST4","ST23"));
				System.out.println("Set Section Image Edited " + nRnBean.setSectionImageEdited("ST4","ST23","N"));
				System.out.println("Get Section Image Edited " + nRnBean.getSectionImageEdited("ST4","ST231"));
				
				System.out.println("Get Section Chief Complaint" + nRnBean.getSectionChiefComplaint("ST4","ST23"));
				
				HashSet set1 = new HashSet();
				boolean retn = nRnBean.setSectionChiefComplaint("ST4","ST231",set1);
				System.out.println("Set Section Chief Complaint " + retn);
				System.out.println("Get Section Chief Complaint " + nRnBean.getSectionChiefComplaint("ST4","ST231"));
				
				System.out.println("Get Existing Section Chief Complaint" + nRnBean.getExistingSectionChiefComplaint("ST4","ST23"));

				retn = nRnBean.setExistingSectionChiefComplaint("ST4","ST231",set1);
				System.out.println("Set Existing Section Chief Complaint " + retn);
				System.out.println("Get Existing Section Chief Complaint " + nRnBean.getExistingSectionChiefComplaint("ST4","ST231"));
				System.out.println("Get DocLInked Yn " + nRnBean.getDocLinked("ST4","ST231"));
				System.out.println("Get Image Linked Yn " + nRnBean.getImageLinked("ST4","ST231"));
				System.out.println("Get Section Type" + nRnBean.getSectionType("ST4","ST231"));
				System.out.println("Get Section Level" + nRnBean.getSectionLevel("ST4","ST231"));
				
				System.out.println("Get Section Level" + nRnBean.getSectionLevel("ST4","ST4"));
				
				System.out.println("Final Properties : " + p1);

			}
			catch (Exception e)
			{
				e.printStackTrace(); 
			}
		}
		*/
}

