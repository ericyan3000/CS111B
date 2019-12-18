import java.util.Hashtable;

public class StringProcessor {
  private String str;
  private Hashtable<String, Integer> digitWordDict = new Hashtable<String, Integer>();
  { 
    digitWordDict.put("zero", 0);
    digitWordDict.put("one", 1);
    digitWordDict.put("two", 2);
    digitWordDict.put("three",3);
    digitWordDict.put("four", 4);
    digitWordDict.put("five", 5);
    digitWordDict.put("six", 6);
    digitWordDict.put("seven", 7);
    digitWordDict.put("eight", 8);
    digitWordDict.put("nine", 9);
  }


  public StringProcessor() {
    this.str = "";
  }

  public StringProcessor(String str) {
    this.str = str;
  }

  public void setString(String s) {
    this.str = s;
  }

  public String getString() {
    return str;
  }

  public int wordCount() {
    String[] words = str.split("[ .?!]");
    return words.length;
  }

  public int uppercaseCount() {
    int count = 0;
    char[] chars = str.toCharArray();
    for (int i=0; i<chars.length; i++) {
      if (Character.isUpperCase(chars[i]))
        count++;
    }
    return count;
  }

  public int digitCount() {
    int count = 0;
    char[] chars = str.toCharArray();
    for (int i=0; i<chars.length; i++) {
      if (Character.isDigit(chars[i]))
        count++;
    }
    return count;
  }

  public int digitWord() {
    int count = 0;
    String[] words = str.split("[ ?!]");
    for (String word : words) {
      if (digitWordDict.containsKey(word.toLowerCase()))
        count++;
    }
    return count;
  }

  public String getNoSpaceString() {
    return str.replaceAll(" ", "");
  }

  public String getNoVowelString() {
    return str.replaceAll("[aeiou]", "-");
  }

  public String getNoDigitWordString() {
    String[] words = str.split("[ ?!]");
    char punc = str.charAt(str.length()-1);
    String[] mapWords = new String[words.length];
    for (int i=0; i < words.length; i++) {
      if (digitWordDict.containsKey(words[i].toLowerCase()))
        mapWords[i] = digitWordDict.get(words[i].toLowerCase()).toString();
      else
        mapWords[i] = words[i];
    }
    return String.join(" ", mapWords).concat(String.valueOf(punc));
  }



}