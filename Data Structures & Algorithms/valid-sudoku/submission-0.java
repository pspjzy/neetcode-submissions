class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                // 跳过空格
                if (num == '.') {
                    continue;
                }

                // 当前数字所属的 3x3 Box
                int box = (r / 3) * 3 + c / 3;

                // 检查 Row、Column 和 Box
                if (!seen.add("R" + r + ":" + num) ||
                    !seen.add("C" + c + ":" + num) ||
                    !seen.add("B" + box + ":" + num)) {

                    return false;
                }
            }
        }

        return true;
    }
}