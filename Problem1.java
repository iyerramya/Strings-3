//time o(n)
//space o(1)

class Solution {
    String[] oneToNineteen = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = {"", "Ten", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] suffix = {"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String res = "";
        int counter = 0;
        while(num > 0) {
            if(num%1000 > 0) {
                res = helper(num%1000) + suffix[counter] + res;
            }
            num = num/1000;
            counter+=1;   

        }
        
        
        return res.trim();
    }

    public String helper(int val) {
        if(val == 0) {
            return "";
        }
        
        if(val < 20) {
            return oneToNineteen[val];
        } else if(val < 100){
            int ten = val/10;
            return tens[ten] + helper(val%10);
            
        } else if(val < 1000) {
            int hun = val/100;
            return oneToNineteen[hun] + "Hundred " + helper(val%100);
        }
        
        return "";
    }
}
