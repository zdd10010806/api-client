package com.takipi.api.client.functions.output;

import com.takipi.api.client.functions.input.EventsInput;
import com.takipi.api.client.functions.input.ReliabilityReportInput;

public class ReliabilityReportRow implements SeriesRow {
	
	public static class Factory implements RowFactory {

		@Override
		public SeriesRow read(Series series, int index) {
			return new ReliabilityReportRow(series, index);
		}	
		
		@Override
		public Class<?> rowType() {
			return ReliabilityReportRow.class;
		}	
	}
	
	public String service;
	public String key;
	public String name;
	
	public String previousDepName;
	public String previousDepFrom;			
	public String previousDepState;
	public String timelineDiffState;
	
	public int newIssues;
	public int regressions;
	public int slowdowns; 
	
	public String newIssuesDesc;
	public String regressionsDesc;
	public String slowdownsDesc;
	
	public double score; 
	public String scoreDesc;
	
	public long transactionVolume;
	public long transactionCount;
	public double transactionAvgResponse;
	public double transactionResponseDelta;
	
	public long transactionFailures;
	public String transactionVolumeDesc;
	public String transactionFailureCountDesc;
	public long transactionFailureCount;
	public double transactionFailRate;
	public String transactionFailRateDelta;
	
	public long errorVolume;
	public String errorCountDesc;
	public int errorCount;
	
	public String reliabilityState;
	public String failureDesc;
	public String relabilityDesc;
	public String statusName;
	
	public String alertStatus;
	public String alertDesc;
	
	public int connectedClients;
	public String connectedClientsDesc;
	
	public String eventName;
	public String eventDesc;
	public String eventTypeDesc;
	public String eventType;
	public String eventApp;
	
	public String dashboardId;
	public String dashboardField;
	public String dashboardValue;
	
	public ReliabilityReportRow(Series series, int index) {
				
		this.service = series.getString(ReliabilityReportInput.SERVICE, index);
		this.key = series.getString(ReliabilityReportInput.KEY, index);
		this.name = series.getString(EventsInput.NAME, index);
		
		this.previousDepName = series.getString(ReliabilityReportInput.PREV_DEP_NAME, index);
		this.previousDepFrom = series.getString(ReliabilityReportInput.PREV_DEP_FROM, index);			
		this.previousDepState = series.getString(ReliabilityReportInput.PREV_DEP_STATE, index);
		
		this.newIssues = series.getInt(ReliabilityReportInput.NEW_ISSUES, index);
		this.regressions = series.getInt(ReliabilityReportInput.REGRESSIONS, index);
		this.slowdowns = series.getInt(ReliabilityReportInput.SLOWDOWNS, index); 
		
		this.newIssuesDesc = series.getString(ReliabilityReportInput.NEW_ISSUES_DESC, index);
		this.regressionsDesc = series.getString(ReliabilityReportInput.REGRESSIONS_DESC, index);
		this.slowdownsDesc = series.getString(ReliabilityReportInput.SLOWDOWNS_DESC, index);
		
		this.score = series.getDouble(ReliabilityReportInput.SCORE, index); 
		this.scoreDesc = series.getString(ReliabilityReportInput.SCORE_DESC, index);
		
		this.transactionVolume = series.getLong(ReliabilityReportInput.TRANSACTION_VOLUME, index);
		this.transactionCount = series.getInt(ReliabilityReportInput.TRANSACTION_COUNT, index);
		this.transactionAvgResponse = series.getLong(ReliabilityReportInput.TRANSACTION_AVG_RESPONSE, index);
		this.transactionResponseDelta = series.getDouble(ReliabilityReportInput.TRANSACTION_RESPONSE_DELTA, index);
		
		this.transactionFailures = series.getInt(ReliabilityReportInput.TRANSACTION_FAILURES, index);
		this.transactionVolumeDesc = series.getString(ReliabilityReportInput.TRANSACTION_VOLUME_DESC, index);
		this.transactionFailureCountDesc = series.getString(ReliabilityReportInput.TRANSACTION_FAIL_COUNT_DESC, index);
		this.transactionFailureCount = series.getLong(ReliabilityReportInput.TRANSACTION_FAILURES_COUNT, index);
		this.transactionFailRate = series.getDouble(ReliabilityReportInput.TRANSACTION_FAIL_RATE, index);
		this.transactionFailRateDelta = series.getString(ReliabilityReportInput.TRANSACTION_FAIL_RATE_DELTA, index);
		
		this.errorVolume = series.getLong(ReliabilityReportInput.ERROR_VOLUME, index);
		this.errorCountDesc = series.getString(ReliabilityReportInput.ERROR_COUNT_DESC, index);
		this.errorCount = series.getInt(ReliabilityReportInput.ERROR_COUNT, index);
		
		this.reliabilityState = series.getString(ReliabilityReportInput.RELIABILITY_STATE, index);
		this.failureDesc = series.getString(ReliabilityReportInput.TRANSACTION_FAIL_DESC, index);
		this.relabilityDesc = series.getString(ReliabilityReportInput.RELIABILITY_DESC, index);
		
		this.statusName = series.getString(ReliabilityReportInput.STATUS_NAME, index);
		this.alertStatus = series.getString(ReliabilityReportInput.ALERT_STATUS, index);
		this.alertDesc = series.getString(ReliabilityReportInput.ALERT_DESC, index);
		
		this.connectedClients = series.getInt(ReliabilityReportInput.CONNECTED_CLIENTS, index);
		this.connectedClientsDesc = series.getString(ReliabilityReportInput.CONNECTED_CLIENTS_DESC, index);
		
		this.eventName = series.getString(ReliabilityReportInput.EVENT_NAME, index);
		this.eventDesc = series.getString(ReliabilityReportInput.EVENT_DESC, index);
		this.eventTypeDesc = series.getString(ReliabilityReportInput.EVENT_TYPE_DESC, index);
		this.eventType = series.getString(ReliabilityReportInput.EVENT_TYPE, index);
		this.eventApp = series.getString(ReliabilityReportInput.EVENT_APP, index);
		
		this.dashboardId = series.getString(ReliabilityReportInput.DASHBOARD_ID, index);
		this.dashboardField = series.getString(ReliabilityReportInput.DASHBOARD_FIELD, index);
		this.dashboardValue = series.getString(ReliabilityReportInput.DASHBOARD_VALUE, index);		
	}
}