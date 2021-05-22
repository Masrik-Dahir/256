package Rough_coding;

public class CodingBat {
    /*
    Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
    countX("xxhixx") → 4
    countX("xhixhix") → 3
    countX("hi") → 0
    */
    int lower = 0;
    public int countX(String str) {
        int lenght = String.valueOf(str).length();
        if (lenght <= 1){
            int result = lower;
            lower = 0;
            return result;
        }
        else {
            if (str.charAt(lenght - 1) == 'x') {
                lower++;
                if (lenght > 1) {
                    str = str.substring(0, str.length() - 1);
                }
                return countX(str);
            }
            else{
                if (lenght > 1) {
                    str = str.substring(0, str.length() - 1);
                }
                return countX(str);
            }
        }
    }
    /*
    Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
    changePi("xpix") → "x3.14x
    changePi("pipi") → "3.143.14"
    changePi("pip") → "3.14p"
     */
    public String changePi(String str) {
        if (str.length() >= 2 && str.charAt(0) == 'p' && str.charAt(1) == 'i' ){
            return "3.14" + changePi(str.substring(2));
        }
        else if (str.length() >= 2){
            return str.charAt(0) + changePi(str.substring(1));
        }
        else{
            return str;
        }
    }

    public int array11(int[] nums, int index) {
        if (nums.length == 1 && nums[0] != 11){
            return 0;
        }

        else if (nums.length == 1 && nums[0] == 11){
            return 1;
        }

        else if (nums.length > 1){
            if (index <= nums.length -1 && nums[index] == 11){
                index++;
                return 1 + array11(nums, index);
            }

            else if (index <= nums.length -1 && nums[index] != 11){
                index++;
                return 0 + array11(nums, index);
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
    public String pairStar(String str) {
        if (str.length() <= 1){
            return str;
        }
        else if (str.length() > 1 && str.charAt(0) == str.charAt(1)){
            return str.charAt(0)+'*'+ str.charAt(1)+pairStar(str.substring(2));
        }
        else{
            return str.charAt(0) + pairStar(str.substring(1));
        }


    }

/*
Count recursively the total number of "abc" and "aba" substrings that appear in the given string.

countAbc("abc") → 1
countAbc("abcxxabc") → 2
countAbc("abaxxaba") → 2
 */
    public int countAbc(String str) {
        if (str.length() <= 2){
            return 0;
        }
        else if (str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba")){
            return 1 + countAbc(str.substring(3));
        }
        else{
            return countAbc(str.substring(1));
        }
    }

    public static void main(String[] args) {
        CodingBat c = new CodingBat();
        System.out.println(c.countX("asdsdsadsadsaxxxdsax"));
        System.out.println(c.changePi("asdpiwasdppip"));

        int a[] = {11,11};
        System.out.println(c.array11(a,0));

        System.out.println(c.countAbc("abcadsaabaababc"));

    }


}
