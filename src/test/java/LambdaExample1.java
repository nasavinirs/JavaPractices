import java.util.Arrays;
import java.util.List;

public class LambdaExample1 {

	public static void main(String[] args) {
		
		List<Integer> lists = Arrays.asList(1,2,3,4,5);
		
		for(int i = 0; i < lists.size(); i++) {
			System.out.print(lists.get(i) + " ");
		}
		System.out.println();
		for(int i : lists) {
			System.out.print(i + " ");
		}
		System.out.println();
		lists.forEach(i -> System.out.print(i + " "));
		
;	}

}
