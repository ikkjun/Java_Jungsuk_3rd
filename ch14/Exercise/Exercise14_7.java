import java.util.*;
import java.util.stream.*;

public class Exercise14_7 {

	public static void main(String[] args) {
//		Set lotto = new HashSet();
//		
//		for(int i=0;lotto.size()<6;i++) {
//			lotto.add((int)(Math.random()*45)+1);
//		}
//		
//		List lottoList = new LinkedList(lotto);
//		Collections.sort(lottoList);
//		
//		Iterator it = lottoList.iterator();
//		
//		while(it.hasNext())
//			System.out.println(it.next());
		
		Stream<Integer> die = IntStream.rangeClosed(1, 6).boxed();
		
		die.flatMap(i -> Stream.of(1,2,3,4,5,6).map(i2 -> new int[]{i,i2}))
			.filter(iArr -> iArr[0] + iArr[1] == 6)
			.forEach(iArr -> System.out.println(Arrays.toString(iArr)));
		
	}

}
