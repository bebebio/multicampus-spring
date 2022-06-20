package vo;

public class CommonVo {
	
	private int pageIndex = 1;
		
	private int pageSize = 10;
	
	private int pageFirst = 1;
	
	private int pageBegin = 1;
	
	private int pageEnd = 1;
	
	private int pageLast = 1;
	
	private int pageTotalCount = 0;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageFirst() {
		return pageFirst;
	}

	public void setPageFirst(int pageFirst) {
		this.pageFirst = pageFirst;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getPageLast() {
		return pageLast;
	}

	public void setPageLast(int pageLast) {
		this.pageLast = pageLast;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	@Override
	public String toString() {
		return "CommonVo [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", pageFirst=" + pageFirst
				+ ", pageBegin=" + pageBegin + ", pageEnd=" + pageEnd + ", pageLast=" + pageLast + ", pageTotalCount="
				+ pageTotalCount + "]";
	}
	
}
