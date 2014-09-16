package jxau.spms.common.vo;

public class PageVo {
	// 当前要查询的页面
	private int currentPage;
	// 页面的显示的数据个数
	private int size = 2;
	// 数据库中满足数据的个数
	private long count;
	// 可以在页面中显示的数量
	private int pageNum;
	
	private int firstIndex;

	public String toString() {
		return "count:"+count+",size:"+size+",currentPage:"+currentPage+",pageNum:"+pageNum;
	}
	
	public int getFirstIndex() {
		return (this.getCurrentPage() - 1) * this.getSize();
	}

	public int getCurrentPage() {
		if (this.currentPage <= 0) {
			currentPage = 1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setCount(long count) {

		this.count = count;
		pageNum = (int) (this.count % this.getSize() == 0 ? this.count
				/ this.getSize() : this.count / this.getSize() + 1);
	}

	public long getCount() {
		return this.count;
	}
	
	public int getPageNum() {
		return pageNum;
	}

}
