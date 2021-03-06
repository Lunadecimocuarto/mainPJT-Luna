package site.gamsung.service.domain;

import java.util.List;

public class QnaWrapper {
	
	// Filed
	private List<Qna> Qnas;
	private int totalCount;
	
	
	// Constructor
	public QnaWrapper() {
	}

	public QnaWrapper(List<Qna> qnas, int totalCount) {
		Qnas = qnas;
		this.totalCount = totalCount;
	}

	// Getter
	public List<Qna> getQnas() {
		return Qnas;
	}

	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public String toString() {
		return "QnaWrapper [Qnas=\n" + Qnas + ", totalCount=" + totalCount + "]";
	}
	
	
	
	
}
