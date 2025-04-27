/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.response;

/**
 * @author SaraswathiR
 *
 */
public class ClinicalNotesTransactionResponse {
	public final int TRANSACTION_RESULT_SUCCESS = 0;
	public final int TRANSACTION_RESULT_FAILURE = -1;
	public final int TRANSACTION_RESULT_WARNING = 1;
	
	private String transactionMessage;
	private int transactionResult;
	private String accession_num;
	/**
	 * @return the accession_num
	 */
	public String getAccession_num() {
		return accession_num;
	}
	/**
	 * @param accession_num the accession_num to set
	 */
	public void setAccession_num(String accession_num) {
		this.accession_num = accession_num;
	}
	/**
	 * @return the transactionMessage
	 */
	public String getTransactionMessage() {
		return transactionMessage;
	}
	/**
	 * @param transactionMessage the transactionMessage to set
	 */
	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}
	/**
	 * @return the transactionResult
	 */
	public int getTransactionResult() {
		return transactionResult;
	}
	/**
	 * @param transactionResult the transactionResult to set
	 */
	public void setTransactionResult(int transactionResult) {
		this.transactionResult = transactionResult;
	}
}
