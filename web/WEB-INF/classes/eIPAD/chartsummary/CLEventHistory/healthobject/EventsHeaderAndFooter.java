/**
 * 
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

/**
 * @author ACibibalan
 *
 */
public class EventsHeaderAndFooter {
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	/**
	 * @return the clob_notes_content
	 */
	public java.sql.Clob getClob_notes_content() {
		return clob_notes_content;
	}
	/**
	 * @param clob_notes_content the clob_notes_content to set
	 */
	public void setClob_notes_content(java.sql.Clob clob_notes_content) {
		this.clob_notes_content = clob_notes_content;
	}
	/**
	 * @return the content_reader
	 */
	public java.io.Reader getContent_reader() {
		return content_reader;
	}
	/**
	 * @param content_reader the content_reader to set
	 */
	public void setContent_reader(java.io.Reader content_reader) {
		this.content_reader = content_reader;
	}
	/**
	 * @return the bf_content_reader
	 */
	public java.io.BufferedReader getBf_content_reader() {
		return bf_content_reader;
	}
	/**
	 * @param bf_content_reader the bf_content_reader to set
	 */
	public void setBf_content_reader(java.io.BufferedReader bf_content_reader) {
		this.bf_content_reader = bf_content_reader;
	}
	/**
	 * @return the section_content
	 */
	public String getSection_content() {
		return section_content;
	}
	/**
	 * @param section_content the section_content to set
	 */
	public void setSection_content(String section_content) {
		this.section_content = section_content;
	}
	/**
	 * @return the section_content_rpt
	 */
	public String getSection_content_rpt() {
		return section_content_rpt;
	}
	/**
	 * @param section_content_rpt the section_content_rpt to set
	 */
	public void setSection_content_rpt(String section_content_rpt) {
		this.section_content_rpt = section_content_rpt;
	}
	/**
	 * @return the section_content_ftr
	 */
	public String getSection_content_ftr() {
		return section_content_ftr;
	}
	/**
	 * @param section_content_ftr the section_content_ftr to set
	 */
	public void setSection_content_ftr(String section_content_ftr) {
		this.section_content_ftr = section_content_ftr;
	}
}
