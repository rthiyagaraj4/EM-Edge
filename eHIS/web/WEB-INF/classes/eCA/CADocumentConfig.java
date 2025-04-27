/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/  
package eCA;
 
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

 public class CADocumentConfig implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String docFuncitonId;
	private String docFunctionName;	
	
	private String docSubFuncitonId;
	private String docSubFunctionName;
	private String docFolderName;
	private String docSeqNumber;
	private String docStoredType;
	private String docStoredPath;
	
	
	
	public String getDocFuncitonId() {
		return docFuncitonId;
	}
	public void setDocFuncitonId(String docFuncitonId) {
		this.docFuncitonId = docFuncitonId;
	}
	public String getDocFunctionName() {
		return docFunctionName;
	}
	public void setDocFunctionName(String docFunctionName) {
		this.docFunctionName = docFunctionName;
	}
	public String getDocSubFuncitonId() {
		return docSubFuncitonId;
	}
	public void setDocSubFuncitonId(String docSubFuncitonId) {
		this.docSubFuncitonId = docSubFuncitonId;
	}
	public String getDocSubFunctionName() {
		return docSubFunctionName;
	}
	public void setDocSubFunctionName(String docSubFunctionName) {
		this.docSubFunctionName = docSubFunctionName;
	}
	public String getDocFolderName() {
		return docFolderName;
	}
	public void setDocFolderName(String docFolderName) {
		this.docFolderName = docFolderName;
	}
	public String getDocSeqNumber() {
		return docSeqNumber;
	}
	public void setDocSeqNumber(String docSeqNumber) {
		this.docSeqNumber = docSeqNumber;
	}
	public String getDocStoredType() {
		return docStoredType;
	}
	public void setDocStoredType(String docStoredType) {
		this.docStoredType = docStoredType;
	}
	public String getDocStoredPath() {
		return docStoredPath;
	}
	public void setDocStoredPath(String docStoredPath) {
		this.docStoredPath = docStoredPath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

 }