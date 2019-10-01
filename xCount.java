public class xCount {
  public static void main (String[] args) {
    String[] testString = {"xyz", "xeons", "unicorn", "X-ray"};
    int count = xCountMethod(testString);
    System.out.printf("The tested array of string has %d x\n", count);
  }

  public static int xCountMethod(String[] strs) {
    int count = 0;
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs[i].length(); j++) {
        if (strs[i].toLowerCase().charAt(j) == 'x')
          count ++;
      }
    }
    return count;
  }
}