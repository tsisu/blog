package edu.etime.txmcms.pojo;

import java.io.Serializable;
import java.util.List;
 
/**
 * @author TANG
 *
 * @param <T>
 */
public class Pager<T> implements Serializable{
	
	
	private static final long serialVersionUID = 1272640772922982817L;
	private int pageSize;
	private int currentPage;
	private int totalRecord;
	private int totalPage;
	private List<T> dataList;
	
	
	public Pager() {
		super();
	}
	public Pager(int pageSize, int currentPage, int totalRecord, int totalPage,
			List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}
	public Pager(int pNum,int pSize,List<T> sourceData){
		if(sourceData==null)
			return;
		totalRecord = sourceData.size();
		pageSize = pSize;
		currentPage = pNum;
		totalPage = (totalRecord%pageSize)==0?(totalRecord/pageSize):(totalRecord/pageSize+1);
		int fromIndex = (currentPage-1)*pageSize;
		int toIndex = (currentPage*pageSize<=totalRecord)?(currentPage*pageSize):totalRecord;
		dataList = sourceData.subList(fromIndex, toIndex);
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDatalist(List<T> dataList) {
		this.dataList = dataList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}