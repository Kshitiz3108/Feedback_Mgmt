package com.cg.project.dto;

public class FeedbackDTO {
	
	private int training_code;
	private int participant_id;
	private int fb_prs_comm;
	private int	fb_prs_dbts;
	private int fb_tm ;
	private int fb_hnd_out;
	private int fb_hw_sw_ntwrk;
	private String comments;
	private String suggestion;
	public int getTraining_code() {
		return training_code;
	}
	public void setTraining_code(int training_code) {
		this.training_code = training_code;
	}
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public int getFb_prs_comm() {
		return fb_prs_comm;
	}
	public void setFb_prs_comm(int fb_prs_comm) {
		this.fb_prs_comm = fb_prs_comm;
	}
	public int getFb_prs_dbts() {
		return fb_prs_dbts;
	}
	public void setFb_prs_dbts(int fb_prs_dbts) {
		this.fb_prs_dbts = fb_prs_dbts;
	}
	public int getFb_tm() {
		return fb_tm;
	}
	public void setFb_tm(int fb_tm) {
		this.fb_tm = fb_tm;
	}
	public int getFb_hnd_out() {
		return fb_hnd_out;
	}
	public void setFb_hnd_out(int fb_hnd_out) {
		this.fb_hnd_out = fb_hnd_out;
	}
	public int getFb_hw_sw_ntwrk() {
		return fb_hw_sw_ntwrk;
	}
	public void setFb_hw_sw_ntwrk(int fb_hw_sw_ntwrk) {
		this.fb_hw_sw_ntwrk = fb_hw_sw_ntwrk;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
}
