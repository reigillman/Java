package recursiontinycode;

public class TinyCode12021 {
	/** countOccurs returns the number of occurrences of the target string
	 */
	public int countOccurs(String str, String target) {
		if(str.length()== 0) {
			return 0;
		}
		else if ((str.substring(0,1).equals(target))) {
			return 1 + countOccurs(str.substring(1), target);
		}
		else if ((str.substring(0).equals(target))) {
			return str.length() + countOccurs(str.substring(1), target);
		}
		else {
			return countOccurs(str.substring(1), target);
		}
	}   

    public static void main(String [] args) {
       TinyCode12021 tc = new TinyCode12021();
       String str = "abacab";
       String target1 = "a";
       int result = tc.countOccurs(str, target1);
       System.out.println("Expected 3, got " + result);
       

       String target2 = "ab";
       result = tc.countOccurs(str, target2);
       System.out.println("Expected 2, got " + result);

       String target3 = "h";
       result = tc.countOccurs(str, target3);
       System.out.println("Expected 0, got " + result);
   }
}
