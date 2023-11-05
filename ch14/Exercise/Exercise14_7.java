import java.util.*;

public class Exercise14_7 {

	public static void main(String[] args) {
		Set lotto = new HashSet();
		
		for(int i=0;lotto.size()<6;i++) {
			lotto.add((int)(Math.random()*45)+1);
		}
		
		List lottoList = new LinkedList(lotto);
		Collections.sort(lottoList);
		
		Iterator it = lottoList.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
	}

}
