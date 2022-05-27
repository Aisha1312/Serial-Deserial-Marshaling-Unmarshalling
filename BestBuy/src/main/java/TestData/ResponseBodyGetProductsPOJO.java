package TestData;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseBodyGetProductsPOJO {
	
	public int total;
	public int limit;
	public int skip;
	public List<DataProductsPOJO> data;
	
	public ResponseBodyGetProductsPOJO() {
		
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public List<DataProductsPOJO> getdataproductsPOJO() {
		return data;
	}
	public void setData(List<DataProductsPOJO> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseBodyGetProductsPOJO [total=" + total + ", limit=" + limit + ", skip=" + skip + ", data="
				+ data + "]";
	}
	
}
