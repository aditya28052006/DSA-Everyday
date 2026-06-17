class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        // Start DFS with empty expression
        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }
    public void dfs(String num, int target, int start, long current_value, long last_operand, String expression, List<String> result) {
        // Base case: If we've reached the end of the string
        if (start == num.length()) {
            // If the expression evaluates to the target, add it to result
            if (current_value == target) {
                result.add(expression);
            }
            return;
        }

        // Loop through all substrings starting from 'start' index
        for (int i = start; i < num.length(); i++) {
            // Skip leading zeros in numbers
            if (i > start && num.charAt(start) == '0') return;
            // Get the current number
            String current_num = num.substring(start, i + 1);
            long current_num_val = Long.parseLong(current_num);

            // If we are at the first number, just start the expression
            if (start == 0) {
                dfs(num, target, i + 1, current_num_val, current_num_val, current_num, result);
            } else {
                // Add the current number with '+'
                dfs(num, target, i + 1, current_value + current_num_val, current_num_val, expression + "+" + current_num, result);
                
                // Add the current number with '-'
                dfs(num, target, i + 1, current_value - current_num_val, -current_num_val, expression + "-" + current_num, result);
                
                // Add the current number with '*'
                dfs(num, target, i + 1, current_value - last_operand + last_operand * current_num_val, last_operand * current_num_val, expression + "*" + current_num, result);
            }
        }
    }

}