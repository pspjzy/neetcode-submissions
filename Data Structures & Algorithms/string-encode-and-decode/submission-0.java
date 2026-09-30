class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // 找到 # 的位置
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            // 读取字符串长度
            int length = Integer.parseInt(
                str.substring(i, j)
            );

            // 根据长度提取字符串
            String s = str.substring(j + 1, j + 1 + length);

            res.add(s);

            // 移动到下一个字符串
            i = j + 1 + length;
        }

        return res;
    }
}