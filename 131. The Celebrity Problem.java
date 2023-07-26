import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {

	public static int findCelebrity(int n) {
        Stack<Integer> s = new Stack<>();
		for(int i =0;i<n;i++){
			s.push(i);
		}

		while(s.size()>=2){
			int first = s.pop();
			int second = s.pop();
			
			if(Runner.knows(first,second) == false){
				s.push(first);
			}else{
				s.push(second);
			}
		}
         int mayBeCelebrity = s.pop();
		 boolean flag = true;
		for(int i =0;i<n;i++){
			if(i == mayBeCelebrity){
			   continue;
			}else{
				if(Runner.knows(i,mayBeCelebrity) == false||Runner.knows(mayBeCelebrity,i)==true){
                    flag = false;
				}
			}
		}
		if(flag == true){
			return mayBeCelebrity;
		}else{
			return -1;
		}
    }
}