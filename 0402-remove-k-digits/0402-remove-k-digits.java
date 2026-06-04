class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();
        
        // Iterate over each digit in the number
        for (char digit : num.toCharArray()) {
            // While we still need to remove digits,
            // and the current stack top is greater than the current digit,
            // remove the stack top (to make number smaller)
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            // Add current digit to stack
            stack.append(digit);
        }
        
        // If we still need to remove digits, remove from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        // Remove leading zeros
        int index = 0;
        while (index < stack.length() && stack.charAt(index) == '0') {
            index++;
        }
        
        // Build final result
        String result = (index == stack.length()) ? "0" : stack.substring(index);
        
        return result;
    }
}