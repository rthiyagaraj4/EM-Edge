/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/05/2014	IN047205		Karthi L		16/05/2014		Ramesh			Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
-----------------------------------------------------------------------------------------------
*/
package eCA;


public class CAExternalLinkDataDTO implements java.io.Serializable {
	private String ext_image_obj_id;
	private String ext_image_appl_id;
	private String ext_image_source;
	private String srce_doc_ref_no;
	private String srce_doc_ref_line_no;
	public String getExt_image_obj_id() {
		return ext_image_obj_id;
	}
	public void setExt_image_obj_id(String ext_image_obj_id) {
		this.ext_image_obj_id = ext_image_obj_id;
	}
	public String getExt_image_appl_id() {
		return ext_image_appl_id;	
	}
	public void setExt_image_appl_id(String ext_image_appl_id) {
		this.ext_image_appl_id = ext_image_appl_id;
	}
	public String getExt_image_source() {
		return ext_image_source;
	}
	public void setExt_image_source(String ext_image_source) {
		this.ext_image_source = ext_image_source;
	}
	public String getSrce_doc_ref_no() {
		return srce_doc_ref_no;
	}
	public void setSrce_doc_ref_no(String srce_doc_ref_no) {
		this.srce_doc_ref_no = srce_doc_ref_no;
	}
	public String getSrce_doc_ref_line_no() {
		return srce_doc_ref_line_no;
	}
	public void setSrce_doc_ref_line_no(String srce_doc_ref_line_no) {
		this.srce_doc_ref_line_no = srce_doc_ref_line_no;
	}
}
