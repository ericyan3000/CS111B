// converstion between types
(int) 1.1 //rounding
(double) 1
1.toString()
Integer.parseInt("1")


// define array
int[] arr = new int[size];
int arr[] = new int[size];
int arr[] = {1, 2, 3};

//array sort
import java.util.Arrays;
Arrays.sort(arr);  // no return value

//Array to String
Arrays.toString(arr);



//Character
// check digit
Character.isDigit(var) // return boolean
Character.isUpperCase(var) // check upper case char



// String methods
// to char[]
char[] chars = str.toCharArray()
// object to String
String.valueOf(object) // could pass char[]

// regex function
str.replaceAll("regex", "target")
str.replaceAll("[aeiou]", "-")

// split to array
String[] words = str.split("[ ?!]"); // split("regex")
// Array to String
String.join("delimeter", arr) // return String
// concat
str.concat(str2)


// Hashtable
// Definition
Hashtable<String, Integer> digitWordDict = new Hashtable<String, Integer>();
{ 
	digitWordDict.put("zero", 0);
	digitWordDict.put("one", 1);
}

//check key
digitWordDict.containsKey(key)  // return boolean

// get value
digitWordDict.get(key) // return value


// loop control
break
continue

for (type element : array) {}

do {} while ();

switch (score) {
        case 9: 
          return "A";
        default: 
          return "F";
      }

// random
int var = random.nextInt(range) + min;