import java.util.ArrayList;
import java.util.List;


public class SuperSimpleStock {
	
	public static List<SimpleStock> generateData(){
		List<SimpleStock> listData = new ArrayList<SimpleStock>();

		SimpleStock ss1 = new SimpleStock("TEA", TypeStock.Common, 0f, null, 100, 1f);
		SimpleStock ss2 = new SimpleStock("POP", TypeStock.Common, 8f, null, 100, 0.6f);
		SimpleStock ss3 = new SimpleStock("ALE", TypeStock.Common, 23f, null, 60, 0.75f);
		SimpleStock ss4 = new SimpleStock("GIN", TypeStock.Preferred, 8f, 2f, 100, 1.20f);
		SimpleStock ss5 = new SimpleStock("JOE", TypeStock.Common, 13f, null, 250, 2.35f);
		
		listData.add(ss1);
		listData.add(ss2);
		listData.add(ss3);
		listData.add(ss4);
		listData.add(ss5);
		
		return listData;
	}

	public static void main(String[] args) {
		List<SimpleStock> listStock = generateData();
		System.out.println("For a given stock:");
		System.out.println("==================");
		for(SimpleStock ss : listStock){
			ss.println();
		}
		System.out.println("==================");
		System.out.println("i. Calculate the dividend yield:");
		int i = 1;
		for(SimpleStock ss : listStock){
			System.out.println(i +": " + ss.getDividendYield());
			i++;
		}
		System.out.println("==================");
		System.out.println("ii. Calculate the P//E Ratio:");
		i = 1;
		for(SimpleStock ss : listStock){
			System.out.println(i +": " + ss.getPERatio());
			i++;
		}
	}
	
	public enum TypeStock{
		Common(),Preferred()
	}
	
	public class SimpleStock{
		private String symbol;
		private TypeStock type;
		private float lastDividend;
		private Float fixedDividend;
		private int parValue;
		private float tickerPrice;
		
		public SimpleStock(){
			
		}
		
		public SimpleStock(String symbol, TypeStock type, float lastDividend, Float fixedDividend, int parValue, float tickerPrice) {
			super();
			this.symbol = symbol;
			this.type = type;
			this.lastDividend = lastDividend;
			this.fixedDividend = fixedDividend;
			this.parValue = parValue;
			this.tickerPrice = tickerPrice;
		}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public TypeStock getType() {
			return type;
		}
		public void setType(TypeStock type) {
			this.type = type;
		}
		public float getLastDividend() {
			return lastDividend;
		}
		public void setLastDividend(float lastDividend) {
			this.lastDividend = lastDividend;
		}
		public Float getFixedDividend() {
			return fixedDividend;
		}
		public void setFixedDividend(Float fixedDividend) {
			this.fixedDividend = fixedDividend;
		}
		public int getParValue() {
			return parValue;
		}
		public void setParValue(int parValue) {
			this.parValue = parValue;
		}
		
		@Override
		public String toString(){
			return "Stock symbol: " + this.symbol + ", Type: " +this.type + ", Last Dividend: " + this.lastDividend + ", Fixed Dividend: " + (this.fixedDividend==null ? "" : this.fixedDividend) +
					", Par Value: " + this.parValue + ", Ticker Price: " + this.tickerPrice;
		}
		
		public void println(){
			System.out.println(this.toString());
		}
		
		public float getDividendYield(){
			if(TypeStock.Common == this.type){
				return (this.lastDividend / this.tickerPrice);
			} else if(TypeStock.Preferred == this.type){
				return (this.fixedDividend * this.parValue) / this.tickerPrice;
			}
			return 0f;
		}
		
		public float getPERatio(){
			return (this.tickerPrice / this.lastDividend);
		}
	}

}
